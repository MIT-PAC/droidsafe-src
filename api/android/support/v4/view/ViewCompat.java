/*
 * Copyright (C) 2011 The Android Open Source Project
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

package android.support.v4.view;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

/**
 * Helper for accessing features in {@link View} introduced after API
 * level 4 in a backwards compatible fashion.
 */
public class ViewCompat {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:25.554 -0400", hash_original_field = "361BC31D07AD9559F194AE7DCEA363BD", hash_generated_field = "8F276B4C86F06142AEDE0C97A7FE2F68")

    public static final int OVER_SCROLL_ALWAYS = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:25.565 -0400", hash_original_field = "CC647B45C45ACE646CE989AEBDB00745", hash_generated_field = "218BFE0FF46A804B55589DCE0FFD7D0A")

    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:25.573 -0400", hash_original_field = "F3053BB78DC68F981F29ECFBD3977D87", hash_generated_field = "009B55485034BF3BF55F8691DA9788F7")

    public static final int OVER_SCROLL_NEVER = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:25.581 -0400", hash_original_field = "F01F6026A556A1479651B1673A0D609A", hash_generated_field = "0C12F527669B717C6A0C28E0DC587883")


    private static final long FAKE_FRAME_TIME = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:25.589 -0400", hash_original_field = "40D27D84924242906788B073B8D7D43D", hash_generated_field = "9FC88D25425BBFC06487793792B4731F")

    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0x00000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:25.609 -0400", hash_original_field = "0F6746356647232A4911D778DEDDD0B9", hash_generated_field = "EBD4EE29D9002764BC19ADEAF158AB51")

    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:25.617 -0400", hash_original_field = "FEE2CE1E2B9F75F46CF43644D0C15CD1", hash_generated_field = "C46957D899C740323BAF5BFE44374D24")

    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:25.625 -0400", hash_original_field = "03E180A43B4EF65FB2774FF27512EB3A", hash_generated_field = "36616A048DC5DAE4EC1C0E18A01EF45E")

    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 0x00000004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:25.635 -0400", hash_original_field = "97F30E9F24785CCD4F841BE6079552EA", hash_generated_field = "201F8ABA5B877D13B125FCD910A076E1")

    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0x00000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:25.643 -0400", hash_original_field = "86204997185E141A01807E1A132FD4C2", hash_generated_field = "F3B60E27A87726FCFCF4C54D897F88BB")

    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:25.651 -0400", hash_original_field = "CDFCF6C7DB83F70398C0C3EFA3C35138", hash_generated_field = "786DA6FA536B5D1C814D1E7896B413BA")

    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:25.660 -0400", hash_original_field = "A7FC7A142388B7E68C811E9F0DE82AAB", hash_generated_field = "4B71A3CAAC0983C5CC19785C41F5E14C")

    public static final int LAYER_TYPE_NONE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:25.669 -0400", hash_original_field = "10F1EBB3EA286BF40E15A7DC5A5C77B1", hash_generated_field = "9362C41130448D1BEC071BA7F3927A19")

    public static final int LAYER_TYPE_SOFTWARE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:25.681 -0400", hash_original_field = "A83617A3813259E5F20A2BA621D5CBC5", hash_generated_field = "339CEE307F54C01A3C41187443B4553A")

    public static final int LAYER_TYPE_HARDWARE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:25.688 -0400", hash_original_field = "C4524789EA5512E454B44BB4CE2240C5", hash_generated_field = "6CDDA9A4918979CF413E3AD0E2FFF054")

    public static final int LAYOUT_DIRECTION_LTR = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:25.696 -0400", hash_original_field = "EBD0AD1207972A573E13ECB5247DB2FA", hash_generated_field = "C4A46E9EFF07999D4098B78F47274F59")

    public static final int LAYOUT_DIRECTION_RTL = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:25.704 -0400", hash_original_field = "3D7E4A6568C27BAA049DD7E236B058B8", hash_generated_field = "9C36C06369223000C72A65C54BB4FB62")

    public static final int LAYOUT_DIRECTION_INHERIT = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:25.712 -0400", hash_original_field = "ADD5FE1C7EBA761C48748E00EF713DAE", hash_generated_field = "7B546D9DADAB714BB86A609097540DB3")

    public static final int LAYOUT_DIRECTION_LOCALE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:25.721 -0400", hash_original_field = "A41AFB14561C756088DE88EA294BDF02", hash_generated_field = "3584CE2038396D56F00CBCE4E0AF47E7")

    public static final int MEASURED_SIZE_MASK = 0x00ffffff;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:25.729 -0400", hash_original_field = "230A433CB35000100586A63BAB0A109F", hash_generated_field = "874FE93B404AA4B2617E7E2F47B091CC")

    public static final int MEASURED_STATE_MASK = 0xff000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:25.737 -0400", hash_original_field = "8C0B03FFB0098DA8DAB9230B3C51EB0D", hash_generated_field = "859653BE0AACCFF2DA07F4D6CA30948B")

    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:25.746 -0400", hash_original_field = "22A909B4958BA8440BEDEF503B97A322", hash_generated_field = "499640E6C451DA0A8A056EE1F14203E6")

    public static final int MEASURED_STATE_TOO_SMALL = 0x01000000;

    interface ViewCompatImpl {
        public boolean canScrollHorizontally(View v, int direction);
        public boolean canScrollVertically(View v, int direction);
        public int getOverScrollMode(View v);
        public void setOverScrollMode(View v, int mode);
        public void onInitializeAccessibilityEvent(View v, AccessibilityEvent event);
        public void onPopulateAccessibilityEvent(View v, AccessibilityEvent event);
        public void onInitializeAccessibilityNodeInfo(View v, AccessibilityNodeInfoCompat info);
        public void setAccessibilityDelegate(View v, AccessibilityDelegateCompat delegate);
        public boolean hasTransientState(View view);
        public void setHasTransientState(View view, boolean hasTransientState);
        public void postInvalidateOnAnimation(View view);
        public void postInvalidateOnAnimation(View view, int left, int top, int right, int bottom);
        public void postOnAnimation(View view, Runnable action);
        public void postOnAnimationDelayed(View view, Runnable action, long delayMillis);
        public int getImportantForAccessibility(View view);
        public void setImportantForAccessibility(View view, int mode);
        public boolean performAccessibilityAction(View view, int action, Bundle arguments);
        public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view);
        public float getAlpha(View view);
        public void setLayerType(View view, int layerType, Paint paint);
        public int getLayerType(View view);
        public int getLabelFor(View view);
        public void setLabelFor(View view, int id);
        public void setLayerPaint(View view, Paint paint);
        public int getLayoutDirection(View view);
        public void setLayoutDirection(View view, int layoutDirection);
        public ViewParent getParentForAccessibility(View view);
        public boolean isOpaque(View view);
        public int resolveSizeAndState(int size, int measureSpec, int childMeasuredState);
        public int getMeasuredWidthAndState(View view);
        public int getMeasuredHeightAndState(View view);
        public int getMeasuredState(View view);
        public int getAccessibilityLiveRegion(View view);
        public void setAccessibilityLiveRegion(View view, int mode);
    }

    static class BaseViewCompatImpl implements ViewCompatImpl {
        public boolean canScrollHorizontally(View v, int direction) {
            return false;
        }
        public boolean canScrollVertically(View v, int direction) {
            return false;
        }
        public int getOverScrollMode(View v) {
            return OVER_SCROLL_NEVER;
        }
        public void setOverScrollMode(View v, int mode) {
            // Do nothing; API doesn't exist
        }
        public void setAccessibilityDelegate(View v, AccessibilityDelegateCompat delegate) {
            // Do nothing; API doesn't exist
        }
        public void onPopulateAccessibilityEvent(View v, AccessibilityEvent event) {
            // Do nothing; API doesn't exist
        }
        public void onInitializeAccessibilityEvent(View v, AccessibilityEvent event) {
         // Do nothing; API doesn't exist
        }
        public void onInitializeAccessibilityNodeInfo(View v, AccessibilityNodeInfoCompat info) {
            // Do nothing; API doesn't exist
        }
        public boolean hasTransientState(View view) {
            // A view can't have transient state if transient state wasn't supported.
            return false;
        }
        public void setHasTransientState(View view, boolean hasTransientState) {
            // Do nothing; API doesn't exist
        }
        public void postInvalidateOnAnimation(View view) {
            view.postInvalidateDelayed(getFrameTime());
        }
        public void postInvalidateOnAnimation(View view, int left, int top, int right, int bottom) {
            view.postInvalidateDelayed(getFrameTime(), left, top, right, bottom);
        }
        public void postOnAnimation(View view, Runnable action) {
            view.postDelayed(action, getFrameTime());
        }
        public void postOnAnimationDelayed(View view, Runnable action, long delayMillis) {
            view.postDelayed(action, getFrameTime() + delayMillis);
        }
        long getFrameTime() {
            return FAKE_FRAME_TIME;
        }
        public int getImportantForAccessibility(View view) {
            return 0;
        }
        public void setImportantForAccessibility(View view, int mode) {

        }
        public boolean performAccessibilityAction(View view, int action, Bundle arguments) {
            return false;
        }
        public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
            return null;
        }
        public float getAlpha(View view) {
            return 1.0f;
        }
        public void setLayerType(View view, int layerType, Paint paint) {
            // No-op until layers became available (HC)
        }
        public int getLayerType(View view) {
            return LAYER_TYPE_NONE;
        }
        public int getLabelFor(View view) {
            return 0;
        }
        public void setLabelFor(View view, int id) {

        }
        public void setLayerPaint(View view, Paint p) {
            // No-op until layers became available (HC)
        }

        @Override
        public int getLayoutDirection(View view) {
            return LAYOUT_DIRECTION_LTR;
        }

        @Override
        public void setLayoutDirection(View view, int layoutDirection) {
            // No-op
        }

        @Override
        public ViewParent getParentForAccessibility(View view) {
            return view.getParent();
        }

        @Override
        public boolean isOpaque(View view) {
            final Drawable bg = view.getBackground();
            if (bg != null) {
                return bg.getOpacity() == PixelFormat.OPAQUE;
            }
            return false;
        }

        public int resolveSizeAndState(int size, int measureSpec, int childMeasuredState) {
            return View.resolveSize(size, measureSpec);
        }

        @Override
        public int getMeasuredWidthAndState(View view) {
            return view.getMeasuredWidth();
        }

        @Override
        public int getMeasuredHeightAndState(View view) {
            return view.getMeasuredHeight();
        }

        @Override
        public int getMeasuredState(View view) {
            return 0;
        }

        @Override
        public int getAccessibilityLiveRegion(View view) {
            return ACCESSIBILITY_LIVE_REGION_NONE;
        }

        @Override
        public void setAccessibilityLiveRegion(View view, int mode) {
            // No-op
        }
    }

    static class EclairMr1ViewCompatImpl extends BaseViewCompatImpl {
        @Override
        public boolean isOpaque(View view) {
            return ViewCompatEclairMr1.isOpaque(view);
        }
    }

    static class GBViewCompatImpl extends EclairMr1ViewCompatImpl {
        @Override
        public int getOverScrollMode(View v) {
            return ViewCompatGingerbread.getOverScrollMode(v);
        }
        @Override
        public void setOverScrollMode(View v, int mode) {
            ViewCompatGingerbread.setOverScrollMode(v, mode);
        }
    }

    static class HCViewCompatImpl extends GBViewCompatImpl {
        @Override
        long getFrameTime() {
            return ViewCompatHC.getFrameTime();
        }
        @Override
        public float getAlpha(View view) {
            return ViewCompatHC.getAlpha(view);
        }
        @Override
        public void setLayerType(View view, int layerType, Paint paint) {
            ViewCompatHC.setLayerType(view, layerType, paint);
        }
        @Override
        public int getLayerType(View view)  {
            return ViewCompatHC.getLayerType(view);
        }
        @Override
        public void setLayerPaint(View view, Paint paint) {
            // Make sure the paint is correct; this will be cheap if it's the same
            // instance as was used to call setLayerType earlier.
            setLayerType(view, getLayerType(view), paint);
            // This is expensive, but the only way to accomplish this before JB-MR1.
            view.invalidate();
        }
        @Override
        public int resolveSizeAndState(int size, int measureSpec, int childMeasuredState) {
            return ViewCompatHC.resolveSizeAndState(size, measureSpec, childMeasuredState);
        }
        @Override
        public int getMeasuredWidthAndState(View view) {
            return ViewCompatHC.getMeasuredWidthAndState(view);
        }
        @Override
        public int getMeasuredHeightAndState(View view) {
            return ViewCompatHC.getMeasuredHeightAndState(view);
        }
        @Override
        public int getMeasuredState(View view) {
            return ViewCompatHC.getMeasuredState(view);
        }
    }

    static class ICSViewCompatImpl extends HCViewCompatImpl {
        @Override
        public boolean canScrollHorizontally(View v, int direction) {
            return ViewCompatICS.canScrollHorizontally(v, direction);
        }
        @Override
        public boolean canScrollVertically(View v, int direction) {
            return ViewCompatICS.canScrollVertically(v, direction);
        }
        @Override
        public void onPopulateAccessibilityEvent(View v, AccessibilityEvent event) {
            ViewCompatICS.onPopulateAccessibilityEvent(v, event);
        }
        @Override
        public void onInitializeAccessibilityEvent(View v, AccessibilityEvent event) {
            ViewCompatICS.onInitializeAccessibilityEvent(v, event);
        }
        @Override
        public void onInitializeAccessibilityNodeInfo(View v, AccessibilityNodeInfoCompat info) {
            ViewCompatICS.onInitializeAccessibilityNodeInfo(v, info.getInfo());
        }
        @Override
        public void setAccessibilityDelegate(View v, AccessibilityDelegateCompat delegate) {
            ViewCompatICS.setAccessibilityDelegate(v, delegate.getBridge());
        }
    }

    static class JBViewCompatImpl extends ICSViewCompatImpl {
        @Override
        public boolean hasTransientState(View view) {
            return ViewCompatJB.hasTransientState(view);
        }
        @Override
        public void setHasTransientState(View view, boolean hasTransientState) {
            ViewCompatJB.setHasTransientState(view, hasTransientState);
        }
        @Override
        public void postInvalidateOnAnimation(View view) {
            ViewCompatJB.postInvalidateOnAnimation(view);
        }
        @Override
        public void postInvalidateOnAnimation(View view, int left, int top, int right, int bottom) {
            ViewCompatJB.postInvalidateOnAnimation(view, left, top, right, bottom);
        }
        @Override
        public void postOnAnimation(View view, Runnable action) {
            ViewCompatJB.postOnAnimation(view, action);
        }
        @Override
        public void postOnAnimationDelayed(View view, Runnable action, long delayMillis) {
            ViewCompatJB.postOnAnimationDelayed(view, action, delayMillis);
        }
        @Override
        public int getImportantForAccessibility(View view) {
            return ViewCompatJB.getImportantForAccessibility(view);
        }
        @Override
        public void setImportantForAccessibility(View view, int mode) {
            ViewCompatJB.setImportantForAccessibility(view, mode);
        }
        @Override
        public boolean performAccessibilityAction(View view, int action, Bundle arguments) {
            return ViewCompatJB.performAccessibilityAction(view, action, arguments);
        }
        @Override
        public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
            Object compat = ViewCompatJB.getAccessibilityNodeProvider(view);
            if (compat != null) {
                return new AccessibilityNodeProviderCompat(compat);
            }
            return null;
        }

        @Override
        public ViewParent getParentForAccessibility(View view) {
            return ViewCompatJB.getParentForAccessibility(view);
        }
    }

    static class JbMr1ViewCompatImpl extends JBViewCompatImpl {

        @Override
        public int getLabelFor(View view) {
            return ViewCompatJellybeanMr1.getLabelFor(view);
        }

        @Override
        public void setLabelFor(View view, int id) {
            ViewCompatJellybeanMr1.setLabelFor(view, id);
        }

        @Override
        public void setLayerPaint(View view, Paint paint) {
            ViewCompatJellybeanMr1.setLayerPaint(view, paint);
        }

        @Override
        public int getLayoutDirection(View view) {
            return ViewCompatJellybeanMr1.getLayoutDirection(view);
        }

        @Override
        public void setLayoutDirection(View view, int layoutDirection) {
            ViewCompatJellybeanMr1.setLayoutDirection(view, layoutDirection);
        }
    }

    static class KitKatViewCompatImpl extends JbMr1ViewCompatImpl {
        @Override
        public int getAccessibilityLiveRegion(View view) {
            return ViewCompatKitKat.getAccessibilityLiveRegion(view);
        }

        @Override
        public void setAccessibilityLiveRegion(View view, int mode) {
            ViewCompatKitKat.setAccessibilityLiveRegion(view, mode);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:26.362 -0400", hash_original_field = "8C7B75196624F10657FDCEE6792BBCF8", hash_generated_field = "BBDF66702D3CCA930AA785B97237B8E4")


    static  ViewCompatImpl IMPL;
    static {
        final int version = android.os.Build.VERSION.SDK_INT;
        if (version >= 19) {
            IMPL = new KitKatViewCompatImpl();
        } else if (version >= 17) {
            IMPL = new JbMr1ViewCompatImpl();
        } else if (version >= 16) {
            IMPL = new JBViewCompatImpl();
        } else if (version >= 14) {
            IMPL = new ICSViewCompatImpl();
        } else if (version >= 11) {
            IMPL = new HCViewCompatImpl();
        } else if (version >= 9) {
            IMPL = new GBViewCompatImpl();
        } else {
            IMPL = new BaseViewCompatImpl();
        }
    }

    /**
     * Check if this view can be scrolled horizontally in a certain direction.
     *
     * @param v The View against which to invoke the method.
     * @param direction Negative to check scrolling left, positive to check scrolling right.
     * @return true if this view can be scrolled in the specified direction, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:26.374 -0400", hash_original_method = "857005B1ED2030A6958E9EB0D4C8F4E9", hash_generated_method = "1589EB5E74EE7AEADA18B3309A63800A")
        
public static boolean canScrollHorizontally(View v, int direction) {
        return IMPL.canScrollHorizontally(v, direction);
    }

    /**
     * Check if this view can be scrolled vertically in a certain direction.
     *
     * @param v The View against which to invoke the method.
     * @param direction Negative to check scrolling up, positive to check scrolling down.
     * @return true if this view can be scrolled in the specified direction, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:26.382 -0400", hash_original_method = "2DFFD160E11AA00CE94741E99122C12E", hash_generated_method = "50EBFE12C5079C61D137C632B3083850")
        
public static boolean canScrollVertically(View v, int direction) {
        return IMPL.canScrollVertically(v, direction);
    }

    /**
     * Returns the over-scroll mode for this view. The result will be
     * one of {@link #OVER_SCROLL_ALWAYS} (default), {@link #OVER_SCROLL_IF_CONTENT_SCROLLS}
     * (allow over-scrolling only if the view content is larger than the container),
     * or {@link #OVER_SCROLL_NEVER}.
     *
     * @param v The View against which to invoke the method.
     * @return This view's over-scroll mode.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:26.388 -0400", hash_original_method = "7494BE1D565A64230355951115CC2869", hash_generated_method = "7EEDECBD1D9B7CD261970618A310D03F")
        
public static int getOverScrollMode(View v) {
        return IMPL.getOverScrollMode(v);
    }

    /**
     * Set the over-scroll mode for this view. Valid over-scroll modes are
     * {@link #OVER_SCROLL_ALWAYS} (default), {@link #OVER_SCROLL_IF_CONTENT_SCROLLS}
     * (allow over-scrolling only if the view content is larger than the container),
     * or {@link #OVER_SCROLL_NEVER}.
     *
     * Setting the over-scroll mode of a view will have an effect only if the
     * view is capable of scrolling.
     *
     * @param v The View against which to invoke the method.
     * @param overScrollMode The new over-scroll mode for this view.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:26.395 -0400", hash_original_method = "CFB7431DB4F757CDA816E6FEFF5ADAB6", hash_generated_method = "CF3FF226C5879DDABABCC07C72634DEA")
        
public static void setOverScrollMode(View v, int overScrollMode) {
        IMPL.setOverScrollMode(v, overScrollMode);
    }

    /**
     * Called from {@link View#dispatchPopulateAccessibilityEvent(AccessibilityEvent)}
     * giving a chance to this View to populate the accessibility event with its
     * text content. While this method is free to modify event
     * attributes other than text content, doing so should normally be performed in
     * {@link View#onInitializeAccessibilityEvent(AccessibilityEvent)}.
     * <p>
     * Example: Adding formatted date string to an accessibility event in addition
     *          to the text added by the super implementation:
     * <pre> public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
     *     super.onPopulateAccessibilityEvent(event);
     *     final int flags = DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_WEEKDAY;
     *     String selectedDateUtterance = DateUtils.formatDateTime(mContext,
     *         mCurrentDate.getTimeInMillis(), flags);
     *     event.getText().add(selectedDateUtterance);
     * }</pre>
     * <p>
     * If an {@link android.view.View.AccessibilityDelegate} has been specified via calling
     * {@link View#setAccessibilityDelegate(android.view.View.AccessibilityDelegate)} its
     * {@link android.view.View.AccessibilityDelegate#onPopulateAccessibilityEvent(View,
     *  AccessibilityEvent)}
     * is responsible for handling this call.
     * </p>
     * <p class="note"><strong>Note:</strong> Always call the super implementation before adding
     * information to the event, in case the default implementation has basic information to add.
     * </p>
     *
     * @param v The View against which to invoke the method.
     * @param event The accessibility event which to populate.
     *
     * @see View#sendAccessibilityEvent(int)
     * @see View#dispatchPopulateAccessibilityEvent(AccessibilityEvent)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:26.402 -0400", hash_original_method = "F7A6696474DBC18E9559BE63429BF45C", hash_generated_method = "84312CBDA69652B8F39427C8F4ECFAA9")
        
public static void onPopulateAccessibilityEvent(View v, AccessibilityEvent event) {
        IMPL.onPopulateAccessibilityEvent(v, event);
    }

    /**
     * Initializes an {@link AccessibilityEvent} with information about
     * this View which is the event source. In other words, the source of
     * an accessibility event is the view whose state change triggered firing
     * the event.
     * <p>
     * Example: Setting the password property of an event in addition
     *          to properties set by the super implementation:
     * <pre> public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
     *     super.onInitializeAccessibilityEvent(event);
     *     event.setPassword(true);
     * }</pre>
     * <p>
     * If an {@link android.view.View.AccessibilityDelegate} has been specified via calling
     * {@link View#setAccessibilityDelegate(android.view.View.AccessibilityDelegate)} its
     * {@link android.view.View.AccessibilityDelegate#onInitializeAccessibilityEvent(View,
     *  AccessibilityEvent)}
     * is responsible for handling this call.
     * </p>
     * <p class="note"><strong>Note:</strong> Always call the super implementation before adding
     * information to the event, in case the default implementation has basic information to add.
     * </p>
     *
     * @param v The View against which to invoke the method.
     * @param event The event to initialize.
     *
     * @see View#sendAccessibilityEvent(int)
     * @see View#dispatchPopulateAccessibilityEvent(AccessibilityEvent)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:26.407 -0400", hash_original_method = "ED19022FEB94C3A5867003FD25E7BFF2", hash_generated_method = "DAA6BC4411CAEFEBE90A13CE6A87A9F3")
        
public static void onInitializeAccessibilityEvent(View v, AccessibilityEvent event) {
        IMPL.onInitializeAccessibilityEvent(v, event);
    }

    /**
     * Initializes an {@link android.view.accessibility.AccessibilityNodeInfo} with information
     * about this view. The base implementation sets:
     * <ul>
     * <li>{@link android.view.accessibility.AccessibilityNodeInfo#setParent(View)},</li>
     * <li>{@link android.view.accessibility.AccessibilityNodeInfo#setBoundsInParent(Rect)},</li>
     * <li>{@link android.view.accessibility.AccessibilityNodeInfo#setBoundsInScreen(Rect)},</li>
     * <li>{@link android.view.accessibility.AccessibilityNodeInfo#setPackageName(CharSequence)},</li>
     * <li>{@link android.view.accessibility.AccessibilityNodeInfo#setClassName(CharSequence)},</li>
     * <li>{@link android.view.accessibility.AccessibilityNodeInfo#setContentDescription(CharSequence)},</li>
     * <li>{@link android.view.accessibility.AccessibilityNodeInfo#setEnabled(boolean)},</li>
     * <li>{@link android.view.accessibility.AccessibilityNodeInfo#setClickable(boolean)},</li>
     * <li>{@link android.view.accessibility.AccessibilityNodeInfo#setFocusable(boolean)},</li>
     * <li>{@link android.view.accessibility.AccessibilityNodeInfo#setFocused(boolean)},</li>
     * <li>{@link android.view.accessibility.AccessibilityNodeInfo#setLongClickable(boolean)},</li>
     * <li>{@link android.view.accessibility.AccessibilityNodeInfo#setSelected(boolean)},</li>
     * </ul>
     * <p>
     * Subclasses should override this method, call the super implementation,
     * and set additional attributes.
     * </p>
     * <p>
     * If an {@link android.view.View.AccessibilityDelegate} has been specified via calling
     * {@link View#setAccessibilityDelegate(android.view.View.AccessibilityDelegate)} its
     * {@link android.view.View.AccessibilityDelegate#onInitializeAccessibilityNodeInfo(View,
     *  android.view.accessibility.AccessibilityNodeInfo)}
     * is responsible for handling this call.
     * </p>
     *
     * @param v The View against which to invoke the method.
     * @param info The instance to initialize.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:26.413 -0400", hash_original_method = "73AA4AFD15DD1C9DB48D7754FEBFC0EB", hash_generated_method = "FB6FC5466D59E9C530E92CA40A2B6091")
        
public static void onInitializeAccessibilityNodeInfo(View v, AccessibilityNodeInfoCompat info) {
        IMPL.onInitializeAccessibilityNodeInfo(v, info);
    }

    /**
     * Sets a delegate for implementing accessibility support via compositon as
     * opposed to inheritance. The delegate's primary use is for implementing
     * backwards compatible widgets. For more details see
     * {@link android.view.View.AccessibilityDelegate}.
     *
     * @param v The View against which to invoke the method.
     * @param delegate The delegate instance.
     *
     * @see android.view.View.AccessibilityDelegate
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:26.437 -0400", hash_original_method = "4280E8CA0A8375D977DD927F0A6FE108", hash_generated_method = "FDC098EF58DE2FA81B05DBE4DBC3A2B4")
        
public static void setAccessibilityDelegate(View v, AccessibilityDelegateCompat delegate) {
        IMPL.setAccessibilityDelegate(v, delegate);
    }

    /**
     * Indicates whether the view is currently tracking transient state that the
     * app should not need to concern itself with saving and restoring, but that
     * the framework should take special note to preserve when possible.
     *
     * @param view View to check for transient state
     * @return true if the view has transient state
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:26.442 -0400", hash_original_method = "460086EE3CFF8118DE0113851199B782", hash_generated_method = "50B771605AA90F97D058657272FCF7E6")
        
public static boolean hasTransientState(View view) {
        return IMPL.hasTransientState(view);
    }

    /**
     * Set whether this view is currently tracking transient state that the
     * framework should attempt to preserve when possible.
     *
     * @param view View tracking transient state
     * @param hasTransientState true if this view has transient state
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:26.448 -0400", hash_original_method = "43518A996658B786A094321F7D499A0B", hash_generated_method = "CE37B08572C28D8A931672A074328E4E")
        
public static void setHasTransientState(View view, boolean hasTransientState) {
        IMPL.setHasTransientState(view, hasTransientState);
    }

    /**
     * <p>Cause an invalidate to happen on the next animation time step, typically the
     * next display frame.</p>
     *
     * <p>This method can be invoked from outside of the UI thread
     * only when this View is attached to a window.</p>
     *
     * @param view View to invalidate
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:26.454 -0400", hash_original_method = "13EB7C07EE18A6F4533610314AE46EE4", hash_generated_method = "7AB6431BFACC42EAB466EA6AD2D6CBD7")
        
public static void postInvalidateOnAnimation(View view) {
        IMPL.postInvalidateOnAnimation(view);
    }

    /**
     * <p>Cause an invalidate of the specified area to happen on the next animation
     * time step, typically the next display frame.</p>
     *
     * <p>This method can be invoked from outside of the UI thread
     * only when this View is attached to a window.</p>
     *
     * @param view View to invalidate
     * @param left The left coordinate of the rectangle to invalidate.
     * @param top The top coordinate of the rectangle to invalidate.
     * @param right The right coordinate of the rectangle to invalidate.
     * @param bottom The bottom coordinate of the rectangle to invalidate.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:26.461 -0400", hash_original_method = "0C44E4531B46F2C870F02629E599CB97", hash_generated_method = "EB0E706D838EB9668F736FB19FECA1C0")
        
public static void postInvalidateOnAnimation(View view, int left, int top,
            int right, int bottom) {
        IMPL.postInvalidateOnAnimation(view, left, top, right, bottom);
    }

    /**
     * <p>Causes the Runnable to execute on the next animation time step.
     * The runnable will be run on the user interface thread.</p>
     *
     * <p>This method can be invoked from outside of the UI thread
     * only when this View is attached to a window.</p>
     *
     * @param view View to post this Runnable to
     * @param action The Runnable that will be executed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:26.466 -0400", hash_original_method = "5F4A37C40BDB0773A33D63BB030FF77C", hash_generated_method = "11E4E49EECB1842AA09416EC4947CD9C")
        
public static void postOnAnimation(View view, Runnable action) {
        IMPL.postOnAnimation(view, action);
    }

    /**
     * <p>Causes the Runnable to execute on the next animation time step,
     * after the specified amount of time elapses.
     * The runnable will be run on the user interface thread.</p>
     *
     * <p>This method can be invoked from outside of the UI thread
     * only when this View is attached to a window.</p>
     *
     * @param view The view to post this Runnable to
     * @param action The Runnable that will be executed.
     * @param delayMillis The delay (in milliseconds) until the Runnable
     *        will be executed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:26.473 -0400", hash_original_method = "0FAD04BB0A0F09D75E4DF96A69CCF3CB", hash_generated_method = "19F4354D19593418FF2F3BF0AA25F648")
        
public static void postOnAnimationDelayed(View view, Runnable action, long delayMillis) {
        IMPL.postOnAnimationDelayed(view, action, delayMillis);
    }

    /**
     * Gets the mode for determining whether this View is important for accessibility
     * which is if it fires accessibility events and if it is reported to
     * accessibility services that query the screen.
     *
     * @param view The view whose property to get.
     * @return The mode for determining whether a View is important for accessibility.
     *
     * @see #IMPORTANT_FOR_ACCESSIBILITY_YES
     * @see #IMPORTANT_FOR_ACCESSIBILITY_NO
     * @see #IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS
     * @see #IMPORTANT_FOR_ACCESSIBILITY_AUTO
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:26.478 -0400", hash_original_method = "58153325535AF15DDE2E1ECB138BDE5D", hash_generated_method = "6062515F378B11ABFD74FE0C0A5D822C")
        
public static int getImportantForAccessibility(View view) {
        return IMPL.getImportantForAccessibility(view);
    }

    /**
     * Sets how to determine whether this view is important for accessibility
     * which is if it fires accessibility events and if it is reported to
     * accessibility services that query the screen.
     *
     * @param view The view whose property to set.
     * @param mode How to determine whether this view is important for accessibility.
     *
     * @see #IMPORTANT_FOR_ACCESSIBILITY_YES
     * @see #IMPORTANT_FOR_ACCESSIBILITY_NO
     * @see #IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS
     * @see #IMPORTANT_FOR_ACCESSIBILITY_AUTO
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:26.483 -0400", hash_original_method = "800D6F8FCFD8309F7CCD8A956FED8815", hash_generated_method = "5A0BB2935601D8D0FF5E98CFB79251B2")
        
public static void setImportantForAccessibility(View view, int mode) {
        IMPL.setImportantForAccessibility(view, mode);
    }

    /**
     * Performs the specified accessibility action on the view. For
     * possible accessibility actions look at {@link AccessibilityNodeInfoCompat}.
     * <p>
     * If an {@link AccessibilityDelegateCompat} has been specified via calling
     * {@link #setAccessibilityDelegate(View, AccessibilityDelegateCompat)} its
     * {@link AccessibilityDelegateCompat#performAccessibilityAction(View, int, Bundle)}
     * is responsible for handling this call.
     * </p>
     *
     * @param action The action to perform.
     * @param arguments Optional action arguments.
     * @return Whether the action was performed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:26.489 -0400", hash_original_method = "9732AC072CD967AA40BB72464A16FDC3", hash_generated_method = "FC54304D599392C03042D2FD00726A1C")
        
public static boolean performAccessibilityAction(View view, int action, Bundle arguments) {
        return IMPL.performAccessibilityAction(view, action, arguments);
    }

    /**
     * Gets the provider for managing a virtual view hierarchy rooted at this View
     * and reported to {@link android.accessibilityservice.AccessibilityService}s
     * that explore the window content.
     * <p>
     * If this method returns an instance, this instance is responsible for managing
     * {@link AccessibilityNodeInfoCompat}s describing the virtual sub-tree rooted at
     * this View including the one representing the View itself. Similarly the returned
     * instance is responsible for performing accessibility actions on any virtual
     * view or the root view itself.
     * </p>
     * <p>
     * If an {@link AccessibilityDelegateCompat} has been specified via calling
     * {@link #setAccessibilityDelegate(View, AccessibilityDelegateCompat)} its
     * {@link AccessibilityDelegateCompat#getAccessibilityNodeProvider(View)}
     * is responsible for handling this call.
     * </p>
     *
     * @param view The view whose property to get.
     * @return The provider.
     *
     * @see AccessibilityNodeProviderCompat
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:26.494 -0400", hash_original_method = "5D39CEEA849CBA7AFA696397B862059E", hash_generated_method = "E895C08DD7BDA397DA74E49282E9B251")
        
public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        return IMPL.getAccessibilityNodeProvider(view);
    }

    /**
     * The opacity of the view. This is a value from 0 to 1, where 0 means the view is
     * completely transparent and 1 means the view is completely opaque.
     *
     * <p>By default this is 1.0f. Prior to API 11, the returned value is always 1.0f.
     * @return The opacity of the view.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:26.500 -0400", hash_original_method = "46EAB694106D4AF66F8F41DED7A5B7C4", hash_generated_method = "695C3524C8D4BBE07A13153ED7417D36")
        
public static float getAlpha(View view) {
        return IMPL.getAlpha(view);
    }

    /**
     * <p>Specifies the type of layer backing this view. The layer can be
     * {@link #LAYER_TYPE_NONE disabled}, {@link #LAYER_TYPE_SOFTWARE software} or
     * {@link #LAYER_TYPE_HARDWARE hardware}.</p>
     *
     * <p>A layer is associated with an optional {@link android.graphics.Paint}
     * instance that controls how the layer is composed on screen. The following
     * properties of the paint are taken into account when composing the layer:</p>
     * <ul>
     * <li>{@link android.graphics.Paint#getAlpha() Translucency (alpha)}</li>
     * <li>{@link android.graphics.Paint#getXfermode() Blending mode}</li>
     * <li>{@link android.graphics.Paint#getColorFilter() Color filter}</li>
     * </ul>
     *
     * <p>If this view has an alpha value set to < 1.0 by calling
     * setAlpha(float), the alpha value of the layer's paint is replaced by
     * this view's alpha value. Calling setAlpha(float) is therefore
     * equivalent to setting a hardware layer on this view and providing a paint with
     * the desired alpha value.<p>
     *
     * <p>Refer to the documentation of {@link #LAYER_TYPE_NONE disabled},
     * {@link #LAYER_TYPE_SOFTWARE software} and {@link #LAYER_TYPE_HARDWARE hardware}
     * for more information on when and how to use layers.</p>
     *
     * @param layerType The ype of layer to use with this view, must be one of
     *        {@link #LAYER_TYPE_NONE}, {@link #LAYER_TYPE_SOFTWARE} or
     *        {@link #LAYER_TYPE_HARDWARE}
     * @param paint The paint used to compose the layer. This argument is optional
     *        and can be null. It is ignored when the layer type is
     *        {@link #LAYER_TYPE_NONE}
     *
     * @param view View to set the layer type for
     * @param layerType The type of layer to use with this view, must be one of
     *        {@link #LAYER_TYPE_NONE}, {@link #LAYER_TYPE_SOFTWARE} or
     *        {@link #LAYER_TYPE_HARDWARE}
     * @param paint The paint used to compose the layer. This argument is optional
     *        and can be null. It is ignored when the layer type is
     *        {@link #LAYER_TYPE_NONE}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:26.505 -0400", hash_original_method = "DC214103B793E78BE48A6C7E3773E9E0", hash_generated_method = "1B25A631BB8A093D05E854A54820DD2D")
        
public static void setLayerType(View view, int layerType, Paint paint) {
        IMPL.setLayerType(view, layerType, paint);
    }

    /**
     * Indicates what type of layer is currently associated with this view. By default
     * a view does not have a layer, and the layer type is {@link #LAYER_TYPE_NONE}.
     * Refer to the documentation of
     * {@link #setLayerType(android.view.View, int, android.graphics.Paint)}
     * for more information on the different types of layers.
     *
     * @param view The view to fetch the layer type from
     * @return {@link #LAYER_TYPE_NONE}, {@link #LAYER_TYPE_SOFTWARE} or
     *         {@link #LAYER_TYPE_HARDWARE}
     *
     * @see #setLayerType(android.view.View, int, android.graphics.Paint)
     * @see #LAYER_TYPE_NONE
     * @see #LAYER_TYPE_SOFTWARE
     * @see #LAYER_TYPE_HARDWARE
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:26.509 -0400", hash_original_method = "052EE158F70370997B34A0226D95F9E6", hash_generated_method = "06471C2CE2F348030DC867F9E3086E01")
        
public static int getLayerType(View view) {
        return IMPL.getLayerType(view);
    }

    /**
     * Gets the id of a view for which a given view serves as a label for
     * accessibility purposes.
     *
     * @param view The view on which to invoke the corresponding method.
     * @return The labeled view id.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:26.514 -0400", hash_original_method = "3F4A7F2C91E0B87B584BB39947937B5A", hash_generated_method = "80899472ABAE1EE8BE952A31098B5B46")
        
public static int getLabelFor(View view) {
        return IMPL.getLabelFor(view);
    }

    /**
     * Sets the id of a view for which a given view serves as a label for
     * accessibility purposes.
     *
     * @param view The view on which to invoke the corresponding method.
     * @param labeledId The labeled view id.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:26.519 -0400", hash_original_method = "4CC61E495BBDB2EA58BFAF981622D475", hash_generated_method = "F936CFBC548F2FE3EE16AF6E77275B9B")
        
public static void setLabelFor(View view, int labeledId) {
        IMPL.setLabelFor(view, labeledId);
    }

    /**
     * Updates the {@link Paint} object used with the current layer (used only if the current
     * layer type is not set to {@link #LAYER_TYPE_NONE}). Changed properties of the Paint
     * provided to {@link #setLayerType(android.view.View, int, android.graphics.Paint)}
     * will be used the next time the View is redrawn, but
     * {@link #setLayerPaint(android.view.View, android.graphics.Paint)}
     * must be called to ensure that the view gets redrawn immediately.
     *
     * <p>A layer is associated with an optional {@link android.graphics.Paint}
     * instance that controls how the layer is composed on screen. The following
     * properties of the paint are taken into account when composing the layer:</p>
     * <ul>
     * <li>{@link android.graphics.Paint#getAlpha() Translucency (alpha)}</li>
     * <li>{@link android.graphics.Paint#getXfermode() Blending mode}</li>
     * <li>{@link android.graphics.Paint#getColorFilter() Color filter}</li>
     * </ul>
     *
     * <p>If this view has an alpha value set to < 1.0 by calling
     * View#setAlpha(float), the alpha value of the layer's paint is replaced by
     * this view's alpha value. Calling View#setAlpha(float) is therefore
     * equivalent to setting a hardware layer on this view and providing a paint with
     * the desired alpha value.</p>
     *
     * @param view View to set a layer paint for
     * @param paint The paint used to compose the layer. This argument is optional
     *        and can be null. It is ignored when the layer type is
     *        {@link #LAYER_TYPE_NONE}
     *
     * @see #setLayerType(View, int, android.graphics.Paint)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:26.525 -0400", hash_original_method = "47DF25BC91539BCD776DF84DDF9C3F59", hash_generated_method = "998997BD0E82A4D9D62323B5EB028470")
        
public static void setLayerPaint(View view, Paint paint) {
        IMPL.setLayerPaint(view, paint);
    }

    /**
     * Returns the resolved layout direction for this view.
     *
     * @param view View to get layout direction for
     * @return {@link #LAYOUT_DIRECTION_RTL} if the layout direction is RTL or returns
     * {@link #LAYOUT_DIRECTION_LTR} if the layout direction is not RTL.
     *
     * For compatibility, this will return {@link #LAYOUT_DIRECTION_LTR} if API version
     * is lower than Jellybean MR1 (API 17)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:26.530 -0400", hash_original_method = "40594DE735026B6C38028B35D7E018F6", hash_generated_method = "A1A6C9F8F49C1B377149EE8E08246511")
        
public static int getLayoutDirection(View view) {
        return IMPL.getLayoutDirection(view);
    }

    /**
     * Set the layout direction for this view. This will propagate a reset of layout direction
     * resolution to the view's children and resolve layout direction for this view.
     *
     * @param view View to set layout direction for
     * @param layoutDirection the layout direction to set. Should be one of:
     *
     * {@link #LAYOUT_DIRECTION_LTR},
     * {@link #LAYOUT_DIRECTION_RTL},
     * {@link #LAYOUT_DIRECTION_INHERIT},
     * {@link #LAYOUT_DIRECTION_LOCALE}.
     *
     * Resolution will be done if the value is set to LAYOUT_DIRECTION_INHERIT. The resolution
     * proceeds up the parent chain of the view to get the value. If there is no parent, then it
     * will return the default {@link #LAYOUT_DIRECTION_LTR}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:26.535 -0400", hash_original_method = "408B783533E7BB2348641B0F775BEC29", hash_generated_method = "DFB8E141A1600BCA43B4CAB52F0DB23D")
        
public static void setLayoutDirection(View view, int layoutDirection) {
        IMPL.setLayoutDirection(view, layoutDirection);
    }

    /**
     * Gets the parent for accessibility purposes. Note that the parent for
     * accessibility is not necessary the immediate parent. It is the first
     * predecessor that is important for accessibility.
     *
     * @param view View to retrieve parent for
     * @return The parent for use in accessibility inspection
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:26.540 -0400", hash_original_method = "1F2068DDAD86C0FF15102CEE7DBB6F17", hash_generated_method = "AB0E306B912E7392AE72CC72BCD81D67")
        
public static ViewParent getParentForAccessibility(View view) {
        return IMPL.getParentForAccessibility(view);
    }

    /**
     * Indicates whether this View is opaque. An opaque View guarantees that it will
     * draw all the pixels overlapping its bounds using a fully opaque color.
     *
     * On API 7 and above this will call View's true isOpaque method. On previous platform
     * versions it will check the opacity of the view's background drawable if present.
     *
     * @return True if this View is guaranteed to be fully opaque, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:26.545 -0400", hash_original_method = "49E3C4AA6CE54B7C84275FBD581C84E3", hash_generated_method = "BB33EBDE412CBDF8A07C94655A243B6D")
        
public static boolean isOpaque(View view) {
        return IMPL.isOpaque(view);
    }

    /**
     * Utility to reconcile a desired size and state, with constraints imposed
     * by a MeasureSpec.  Will take the desired size, unless a different size
     * is imposed by the constraints.  The returned value is a compound integer,
     * with the resolved size in the {@link #MEASURED_SIZE_MASK} bits and
     * optionally the bit {@link #MEASURED_STATE_TOO_SMALL} set if the resulting
     * size is smaller than the size the view wants to be.
     *
     * @param size How big the view wants to be
     * @param measureSpec Constraints imposed by the parent
     * @return Size information bit mask as defined by
     * {@link #MEASURED_SIZE_MASK} and {@link #MEASURED_STATE_TOO_SMALL}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:26.552 -0400", hash_original_method = "F8DD309CCDB4A368448FB42453723E97", hash_generated_method = "4900920526200F5CA7795ED7E852689F")
        
public static int resolveSizeAndState(int size, int measureSpec, int childMeasuredState) {
        return IMPL.resolveSizeAndState(size, measureSpec, childMeasuredState);
    }

    /**
     * Return the full width measurement information for this view as computed
     * by the most recent call to {@link android.view.View#measure(int, int)}.
     * This result is a bit mask as defined by {@link #MEASURED_SIZE_MASK} and
     * {@link #MEASURED_STATE_TOO_SMALL}.
     * This should be used during measurement and layout calculations only. Use
     * {@link android.view.View#getWidth()} to see how wide a view is after layout.
     *
     * @return The measured width of this view as a bit mask.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:26.557 -0400", hash_original_method = "D074DA630A442AE0E174C0F96C86287D", hash_generated_method = "4F78C0A43FA8E81C24AC09EFBC340885")
        
public static int getMeasuredWidthAndState(View view) {
        return IMPL.getMeasuredWidthAndState(view);
    }

    /**
     * Return the full height measurement information for this view as computed
     * by the most recent call to {@link android.view.View#measure(int, int)}.
     * This result is a bit mask as defined by {@link #MEASURED_SIZE_MASK} and
     * {@link #MEASURED_STATE_TOO_SMALL}.
     * This should be used during measurement and layout calculations only. Use
     * {@link android.view.View#getHeight()} to see how wide a view is after layout.
     *
     * @return The measured width of this view as a bit mask.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:26.562 -0400", hash_original_method = "63876A100B34973DA9146F6B2B106193", hash_generated_method = "C098197D92684EE714942C211619CD16")
        
public static int getMeasuredHeightAndState(View view) {
        return IMPL.getMeasuredHeightAndState(view);
    }

    /**
     * Return only the state bits of {@link #getMeasuredWidthAndState}
     * and {@link #getMeasuredHeightAndState}, combined into one integer.
     * The width component is in the regular bits {@link #MEASURED_STATE_MASK}
     * and the height component is at the shifted bits
     * {@link #MEASURED_HEIGHT_STATE_SHIFT}>>{@link #MEASURED_STATE_MASK}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:26.567 -0400", hash_original_method = "081B9E2DD3ED1E3A573F6F4943A5CE0C", hash_generated_method = "8E0C21E3B3D81D42AEEB84FB903DF2B2")
        
public static int getMeasuredState(View view) {
        return IMPL.getMeasuredState(view);
    }

    /**
     * Gets the live region mode for the specified View.
     *
     * @param view The view from which to obtain the live region mode
     * @return The live region mode for the view.
     *
     * @see ViewCompat#setAccessibilityLiveRegion(View, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:26.572 -0400", hash_original_method = "46108D1CAAEA00D102CE2D4FE151D97C", hash_generated_method = "098A90350429B09ECC73C30EDF73E645")
        
public int getAccessibilityLiveRegion(View view) {
        return IMPL.getAccessibilityLiveRegion(view);
    }

    /**
     * Sets the live region mode for the specified view. This indicates to
     * accessibility services whether they should automatically notify the user
     * about changes to the view's content description or text, or to the
     * content descriptions or text of the view's children (where applicable).
     * <p>
     * For example, in a login screen with a TextView that displays an "incorrect
     * password" notification, that view should be marked as a live region with
     * mode {@link #ACCESSIBILITY_LIVE_REGION_POLITE}.
     * <p>
     * To disable change notifications for this view, use
     * {@link #ACCESSIBILITY_LIVE_REGION_NONE}. This is the default live region
     * mode for most views.
     * <p>
     * To indicate that the user should be notified of changes, use
     * {@link #ACCESSIBILITY_LIVE_REGION_POLITE}.
     * <p>
     * If the view's changes should interrupt ongoing speech and notify the user
     * immediately, use {@link #ACCESSIBILITY_LIVE_REGION_ASSERTIVE}.
     *
     * @param view The view on which to set the live region mode
     * @param mode The live region mode for this view, one of:
     *        <ul>
     *        <li>{@link #ACCESSIBILITY_LIVE_REGION_NONE}
     *        <li>{@link #ACCESSIBILITY_LIVE_REGION_POLITE}
     *        <li>{@link #ACCESSIBILITY_LIVE_REGION_ASSERTIVE}
     *        </ul>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:47:26.576 -0400", hash_original_method = "E43FA423766011D162E5A374679CD4E8", hash_generated_method = "ABC1404C5001EAF19635D7298378F85F")
        
public void setAccessibilityLiveRegion(View view, int mode) {
        IMPL.setAccessibilityLiveRegion(view, mode);
    }
}
