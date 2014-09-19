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
import android.util.Log;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/**
 * Helper for accessing features in {@link View} introduced after API
 * level 4 in a backwards compatible fashion.
 */
public class ViewCompat {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:17.732 -0400", hash_original_field = "9B04E0CD1C78A31557DBCD443623A053", hash_generated_field = "03AB82A3771E8C87EBCF748D29CBC8C2")

    private static final String TAG = "ViewCompat";

    @Retention(RetentionPolicy.SOURCE)
    private @interface ResolvedLayoutDirectionMode {}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:17.752 -0400", hash_original_field = "361BC31D07AD9559F194AE7DCEA363BD", hash_generated_field = "8F276B4C86F06142AEDE0C97A7FE2F68")

    public static final int OVER_SCROLL_ALWAYS = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:17.759 -0400", hash_original_field = "CC647B45C45ACE646CE989AEBDB00745", hash_generated_field = "218BFE0FF46A804B55589DCE0FFD7D0A")

    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:17.767 -0400", hash_original_field = "F3053BB78DC68F981F29ECFBD3977D87", hash_generated_field = "009B55485034BF3BF55F8691DA9788F7")

    public static final int OVER_SCROLL_NEVER = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:17.784 -0400", hash_original_field = "F01F6026A556A1479651B1673A0D609A", hash_generated_field = "0C12F527669B717C6A0C28E0DC587883")


    private static final long FAKE_FRAME_TIME = 10;

    @Retention(RetentionPolicy.SOURCE)
    private @interface ImportantForAccessibility {}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:17.799 -0400", hash_original_field = "40D27D84924242906788B073B8D7D43D", hash_generated_field = "9FC88D25425BBFC06487793792B4731F")

    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0x00000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:17.807 -0400", hash_original_field = "0F6746356647232A4911D778DEDDD0B9", hash_generated_field = "EBD4EE29D9002764BC19ADEAF158AB51")

    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:17.815 -0400", hash_original_field = "FEE2CE1E2B9F75F46CF43644D0C15CD1", hash_generated_field = "C46957D899C740323BAF5BFE44374D24")

    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:17.823 -0400", hash_original_field = "03E180A43B4EF65FB2774FF27512EB3A", hash_generated_field = "36616A048DC5DAE4EC1C0E18A01EF45E")

    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 0x00000004;

    @Retention(RetentionPolicy.SOURCE)
    private @interface AccessibilityLiveRegion {}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:17.839 -0400", hash_original_field = "97F30E9F24785CCD4F841BE6079552EA", hash_generated_field = "201F8ABA5B877D13B125FCD910A076E1")

    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0x00000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:17.846 -0400", hash_original_field = "86204997185E141A01807E1A132FD4C2", hash_generated_field = "F3B60E27A87726FCFCF4C54D897F88BB")

    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:17.854 -0400", hash_original_field = "CDFCF6C7DB83F70398C0C3EFA3C35138", hash_generated_field = "786DA6FA536B5D1C814D1E7896B413BA")

    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 0x00000002;

    /** @hide */
    @Retention(RetentionPolicy.SOURCE)
    private @interface LayerType {}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:17.868 -0400", hash_original_field = "A7FC7A142388B7E68C811E9F0DE82AAB", hash_generated_field = "4B71A3CAAC0983C5CC19785C41F5E14C")

    public static final int LAYER_TYPE_NONE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:17.877 -0400", hash_original_field = "10F1EBB3EA286BF40E15A7DC5A5C77B1", hash_generated_field = "9362C41130448D1BEC071BA7F3927A19")

    public static final int LAYER_TYPE_SOFTWARE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:17.886 -0400", hash_original_field = "A83617A3813259E5F20A2BA621D5CBC5", hash_generated_field = "339CEE307F54C01A3C41187443B4553A")

    public static final int LAYER_TYPE_HARDWARE = 2;

    /** @hide */
    @Retention(RetentionPolicy.SOURCE)
    private @interface LayoutDirectionMode {}

    /** @hide */
    //@Retention(RetentionPolicy.SOURCE)
    //private @interface ResolvedLayoutDirectionMode {}

@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:17.906 -0400", hash_original_field = "C4524789EA5512E454B44BB4CE2240C5", hash_generated_field = "6CDDA9A4918979CF413E3AD0E2FFF054")

    public static final int LAYOUT_DIRECTION_LTR = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:17.913 -0400", hash_original_field = "EBD0AD1207972A573E13ECB5247DB2FA", hash_generated_field = "C4A46E9EFF07999D4098B78F47274F59")

    public static final int LAYOUT_DIRECTION_RTL = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:17.921 -0400", hash_original_field = "3D7E4A6568C27BAA049DD7E236B058B8", hash_generated_field = "9C36C06369223000C72A65C54BB4FB62")

    public static final int LAYOUT_DIRECTION_INHERIT = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:17.928 -0400", hash_original_field = "ADD5FE1C7EBA761C48748E00EF713DAE", hash_generated_field = "7B546D9DADAB714BB86A609097540DB3")

    public static final int LAYOUT_DIRECTION_LOCALE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:17.935 -0400", hash_original_field = "A41AFB14561C756088DE88EA294BDF02", hash_generated_field = "3584CE2038396D56F00CBCE4E0AF47E7")

    public static final int MEASURED_SIZE_MASK = 0x00ffffff;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:17.942 -0400", hash_original_field = "230A433CB35000100586A63BAB0A109F", hash_generated_field = "874FE93B404AA4B2617E7E2F47B091CC")

    public static final int MEASURED_STATE_MASK = 0xff000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:17.950 -0400", hash_original_field = "8C0B03FFB0098DA8DAB9230B3C51EB0D", hash_generated_field = "859653BE0AACCFF2DA07F4D6CA30948B")

    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:17.958 -0400", hash_original_field = "22A909B4958BA8440BEDEF503B97A322", hash_generated_field = "499640E6C451DA0A8A056EE1F14203E6")

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
        public int getPaddingStart(View view);
        public int getPaddingEnd(View view);
        public void setPaddingRelative(View view, int start, int top, int end, int bottom);
        public void dispatchStartTemporaryDetach(View view);
        public void dispatchFinishTemporaryDetach(View view);
        public float getX(View view);
        public float getY(View view);
        public float getRotation(View view);
        public float getRotationX(View view);
        public float getRotationY(View view);
        public float getScaleX(View view);
        public float getScaleY(View view);
        public float getTranslationX(View view);
        public float getTranslationY(View view);
        public int getMinimumWidth(View view);
        public int getMinimumHeight(View view);
        public ViewPropertyAnimatorCompat animate(View view);
        public void setRotation(View view, float value);
        public void setRotationX(View view, float value);
        public void setRotationY(View view, float value);
        public void setScaleX(View view, float value);
        public void setScaleY(View view, float value);
        public void setTranslationX(View view, float value);
        public void setTranslationY(View view, float value);
        public void setX(View view, float value);
        public void setY(View view, float value);
        public void setAlpha(View view, float value);
        public void setPivotX(View view, float value);
        public void setPivotY(View view, float value);
        public float getPivotX(View view);
        public float getPivotY(View view);
    }

    static class BaseViewCompatImpl implements ViewCompatImpl {
        private Method mDispatchStartTemporaryDetach;
        private Method mDispatchFinishTemporaryDetach;
        private boolean mTempDetachBound;
        WeakHashMap<View, ViewPropertyAnimatorCompat> mViewPropertyAnimatorCompatMap = null;


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
            view.invalidate();
        }
        public void postInvalidateOnAnimation(View view, int left, int top, int right, int bottom) {
            view.invalidate(left, top, right, bottom);
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

        @Override
        public int getPaddingStart(View view) {
            return view.getPaddingLeft();
        }

        @Override
        public int getPaddingEnd(View view) {
            return view.getPaddingRight();
        }

        @Override
        public void setPaddingRelative(View view, int start, int top, int end, int bottom) {
            view.setPadding(start, top, end, bottom);
        }

        @Override
        public void dispatchStartTemporaryDetach(View view) {
            if (!mTempDetachBound) {
                bindTempDetach();
            }
            if (mDispatchStartTemporaryDetach != null) {
                try {
                    mDispatchStartTemporaryDetach.invoke(view);
                } catch (Exception e) {
                    Log.d(TAG, "Error calling dispatchStartTemporaryDetach", e);
                }
            } else {
                // Try this instead
                view.onStartTemporaryDetach();
            }
        }

        @Override
        public void dispatchFinishTemporaryDetach(View view) {
            if (!mTempDetachBound) {
                bindTempDetach();
            }
            if (mDispatchFinishTemporaryDetach != null) {
                try {
                    mDispatchFinishTemporaryDetach.invoke(view);
                } catch (Exception e) {
                    Log.d(TAG, "Error calling dispatchFinishTemporaryDetach", e);
                }
            } else {
                // Try this instead
                view.onFinishTemporaryDetach();
            }
        }

        private void bindTempDetach() {
            try {
                mDispatchStartTemporaryDetach = View.class.getDeclaredMethod(
                        "dispatchStartTemporaryDetach");
                mDispatchFinishTemporaryDetach = View.class.getDeclaredMethod(
                        "dispatchFinishTemporaryDetach");
            } catch (NoSuchMethodException e) {
                Log.e(TAG, "Couldn't find method", e);
            }
            mTempDetachBound = true;
        }

        @Override
        public float getTranslationX(View view) {
            return 0;
        }

        @Override
        public float getTranslationY(View view) {
            return 0;
        }

        @Override
        public float getX(View view) {
            return 0;
        }

        @Override
        public float getY(View view) {
            return 0;
        }

        @Override
        public float getRotation(View view) {
            return 0;
        }

        @Override
        public float getRotationX(View view) {
            return 0;
        }

        @Override
        public float getRotationY(View view) {
            return 0;
        }

        @Override
        public float getScaleX(View view) {
            return 0;
        }

        @Override
        public float getScaleY(View view) {
            return 0;
        }

        @Override
        public int getMinimumWidth(View view) {
            return 0;
        }

        @Override
        public int getMinimumHeight(View view) {
            return 0;
        }

        @Override
        public ViewPropertyAnimatorCompat animate(View view) {
            return new ViewPropertyAnimatorCompat(view);
        }

        @Override
        public void setRotation(View view, float value) {
            // noop
        }

        @Override
        public void setTranslationX(View view, float value) {
            // noop
        }

        @Override
        public void setTranslationY(View view, float value) {
            // noop
        }

        @Override
        public void setAlpha(View view, float value) {
            // noop
        }

        @Override
        public void setRotationX(View view, float value) {
            // noop
        }

        @Override
        public void setRotationY(View view, float value) {
            // noop
        }

        @Override
        public void setScaleX(View view, float value) {
            // noop
        }

        @Override
        public void setScaleY(View view, float value) {
            // noop
        }

        @Override
        public void setX(View view, float value) {
            // noop
        }

        @Override
        public void setY(View view, float value) {
            // noop
        }

        @Override
        public void setPivotX(View view, float value) {
            // noop
        }

        @Override
        public void setPivotY(View view, float value) {
            // noop
        }

        @Override
        public float getPivotX(View view) {
            return 0;
        }

        @Override
        public float getPivotY(View view) {
            return 0;
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
        @Override
        public float getTranslationX(View view) {
            return ViewCompatHC.getTranslationX(view);
        }
        @Override
        public float getTranslationY(View view) {
            return ViewCompatHC.getTranslationY(view);
        }
        @Override
        public void setTranslationX(View view, float value) {
            ViewCompatHC.setTranslationX(view, value);
        }
        @Override
        public void setTranslationY(View view, float value) {
            ViewCompatHC.setTranslationY(view, value);
        }
        @Override
        public void setAlpha(View view, float value) {
            ViewCompatHC.setAlpha(view, value);
        }
        @Override
        public void setX(View view, float value) {
            ViewCompatHC.setX(view, value);
        }
        @Override
        public void setY(View view, float value) {
            ViewCompatHC.setY(view, value);
        }
        @Override
        public void setRotation(View view, float value) {
            ViewCompatHC.setRotation(view, value);
        }
        @Override
        public void setRotationX(View view, float value) {
            ViewCompatHC.setRotationX(view, value);
        }
        @Override
        public void setRotationY(View view, float value) {
            ViewCompatHC.setRotationY(view, value);
        }
        @Override
        public void setScaleX(View view, float value) {
            ViewCompatHC.setScaleX(view, value);
        }
        @Override
        public void setScaleY(View view, float value) {
            ViewCompatHC.setScaleY(view, value);
        }
        @Override
        public void setPivotX(View view, float value) {
            ViewCompatHC.setPivotX(view, value);
        }
        @Override
        public void setPivotY(View view, float value) {
            ViewCompatHC.setPivotY(view, value);
        }
        @Override
        public float getX(View view) {
            return ViewCompatHC.getX(view);
        }

        @Override
        public float getY(View view) {
            return ViewCompatHC.getY(view);
        }

        @Override
        public float getRotation(View view) {
            return ViewCompatHC.getRotation(view);
        }

        @Override
        public float getRotationX(View view) {
            return ViewCompatHC.getRotationX(view);
        }

        @Override
        public float getRotationY(View view) {
            return ViewCompatHC.getRotationY(view);
        }

        @Override
        public float getScaleX(View view) {
            return ViewCompatHC.getScaleX(view);
        }

        @Override
        public float getScaleY(View view) {
            return ViewCompatHC.getScaleY(view);
        }

        @Override
        public float getPivotX(View view) {
            return ViewCompatHC.getPivotX(view);
        }
        @Override
        public float getPivotY(View view) {
            return ViewCompatHC.getPivotY(view);
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
        @Override
        public ViewPropertyAnimatorCompat animate(View view) {
            if (mViewPropertyAnimatorCompatMap == null) {
                mViewPropertyAnimatorCompatMap =
                        new WeakHashMap<View, ViewPropertyAnimatorCompat>();
            }
            ViewPropertyAnimatorCompat vpa = mViewPropertyAnimatorCompatMap.get(view);
            if (vpa == null) {
                vpa = new ViewPropertyAnimatorCompat(view);
                mViewPropertyAnimatorCompatMap.put(view, vpa);
            }
            return vpa;
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
            // IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS is not available
            // on this platform so replace with IMPORTANT_FOR_ACCESSIBILITY_NO
            // which is closer semantically.
            if (mode == IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS) {
                mode = IMPORTANT_FOR_ACCESSIBILITY_NO;
            }
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

        @Override
        public int getMinimumWidth(View view) {
            return ViewCompatJB.getMinimumWidth(view);
        }

        @Override
        public int getMinimumHeight(View view) {
            return ViewCompatJB.getMinimumHeight(view);
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

        @Override
        public int getPaddingStart(View view) {
            return ViewCompatJellybeanMr1.getPaddingStart(view);
        }

        @Override
        public int getPaddingEnd(View view) {
            return ViewCompatJellybeanMr1.getPaddingEnd(view);
        }

        @Override
        public void setPaddingRelative(View view, int start, int top, int end, int bottom) {
            ViewCompatJellybeanMr1.setPaddingRelative(view, start, top, end, bottom);
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

        @Override
        public void setImportantForAccessibility(View view, int mode) {
            ViewCompatJB.setImportantForAccessibility(view, mode);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:18.943 -0400", hash_original_field = "8C7B75196624F10657FDCEE6792BBCF8", hash_generated_field = "BBDF66702D3CCA930AA785B97237B8E4")


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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:18.955 -0400", hash_original_method = "857005B1ED2030A6958E9EB0D4C8F4E9", hash_generated_method = "1589EB5E74EE7AEADA18B3309A63800A")
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:18.959 -0400", hash_original_method = "2DFFD160E11AA00CE94741E99122C12E", hash_generated_method = "50EBFE12C5079C61D137C632B3083850")
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:18.964 -0400", hash_original_method = "7494BE1D565A64230355951115CC2869", hash_generated_method = "AE83B4D709C13B26DA732E689B1CF153")
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:18.969 -0400", hash_original_method = "635FAD0D3F748319DC4EC3FBC11231A4", hash_generated_method = "7F58FB915C382F707C3A7DDEEA2A51B7")
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:18.973 -0400", hash_original_method = "F7A6696474DBC18E9559BE63429BF45C", hash_generated_method = "84312CBDA69652B8F39427C8F4ECFAA9")
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:18.979 -0400", hash_original_method = "ED19022FEB94C3A5867003FD25E7BFF2", hash_generated_method = "DAA6BC4411CAEFEBE90A13CE6A87A9F3")
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:18.984 -0400", hash_original_method = "73AA4AFD15DD1C9DB48D7754FEBFC0EB", hash_generated_method = "FB6FC5466D59E9C530E92CA40A2B6091")
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:18.988 -0400", hash_original_method = "4280E8CA0A8375D977DD927F0A6FE108", hash_generated_method = "FDC098EF58DE2FA81B05DBE4DBC3A2B4")
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:18.994 -0400", hash_original_method = "460086EE3CFF8118DE0113851199B782", hash_generated_method = "50B771605AA90F97D058657272FCF7E6")
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:18.999 -0400", hash_original_method = "43518A996658B786A094321F7D499A0B", hash_generated_method = "CE37B08572C28D8A931672A074328E4E")
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.003 -0400", hash_original_method = "13EB7C07EE18A6F4533610314AE46EE4", hash_generated_method = "7AB6431BFACC42EAB466EA6AD2D6CBD7")
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.009 -0400", hash_original_method = "0C44E4531B46F2C870F02629E599CB97", hash_generated_method = "EB0E706D838EB9668F736FB19FECA1C0")
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.014 -0400", hash_original_method = "5F4A37C40BDB0773A33D63BB030FF77C", hash_generated_method = "11E4E49EECB1842AA09416EC4947CD9C")
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.019 -0400", hash_original_method = "0FAD04BB0A0F09D75E4DF96A69CCF3CB", hash_generated_method = "19F4354D19593418FF2F3BF0AA25F648")
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.024 -0400", hash_original_method = "58153325535AF15DDE2E1ECB138BDE5D", hash_generated_method = "B71673F353948D41996B2FCC5A20AF28")
        
@ImportantForAccessibility
    public static int getImportantForAccessibility(View view) {
        return IMPL.getImportantForAccessibility(view);
    }

    /**
     * Sets how to determine whether this view is important for accessibility
     * which is if it fires accessibility events and if it is reported to
     * accessibility services that query the screen.
     * <p>
     * <em>Note:</em> If the current paltform version does not support the
     *  {@link #IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS} mode, then
     *  {@link #IMPORTANT_FOR_ACCESSIBILITY_NO} will be used as it is the
     *  closest terms of semantics.
     * </p>
     *
     * @param view The view whose property to set.
     * @param mode How to determine whether this view is important for accessibility.
     *
     * @see #IMPORTANT_FOR_ACCESSIBILITY_YES
     * @see #IMPORTANT_FOR_ACCESSIBILITY_NO
     * @see #IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS
     * @see #IMPORTANT_FOR_ACCESSIBILITY_AUTO
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.028 -0400", hash_original_method = "5E2E1B6E922D63BE31F5AFAD700C1499", hash_generated_method = "37A75EE6BF881183B79B33A3EF4CF4B7")
        
public static void setImportantForAccessibility(View view,
            @ImportantForAccessibility int mode) {
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.033 -0400", hash_original_method = "9732AC072CD967AA40BB72464A16FDC3", hash_generated_method = "FC54304D599392C03042D2FD00726A1C")
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.038 -0400", hash_original_method = "5D39CEEA849CBA7AFA696397B862059E", hash_generated_method = "E895C08DD7BDA397DA74E49282E9B251")
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.043 -0400", hash_original_method = "46EAB694106D4AF66F8F41DED7A5B7C4", hash_generated_method = "695C3524C8D4BBE07A13153ED7417D36")
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.048 -0400", hash_original_method = "84359FA4C14479ECD3B07394092306F7", hash_generated_method = "52F52D2B0C1590FC5FC7B3D889597290")
        
public static void setLayerType(View view, @LayerType int layerType, Paint paint) {
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.053 -0400", hash_original_method = "052EE158F70370997B34A0226D95F9E6", hash_generated_method = "ED78D781EFC00CC8E5BE809F6E6A32B1")
        
@LayerType
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.058 -0400", hash_original_method = "3F4A7F2C91E0B87B584BB39947937B5A", hash_generated_method = "80899472ABAE1EE8BE952A31098B5B46")
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.063 -0400", hash_original_method = "B42234C4B8E3FCAB815E05101D4D4388", hash_generated_method = "A30357B0AB3BEE77E5735B5DC9E6F1DF")
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.069 -0400", hash_original_method = "47DF25BC91539BCD776DF84DDF9C3F59", hash_generated_method = "998997BD0E82A4D9D62323B5EB028470")
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.073 -0400", hash_original_method = "40594DE735026B6C38028B35D7E018F6", hash_generated_method = "B3729AA9DB3CD1DB76B907B98C3E11BB")
        
@ResolvedLayoutDirectionMode
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.078 -0400", hash_original_method = "A2768230DD85DF68CB8A7BDFDCC55F67", hash_generated_method = "4AC7BF62BA6C016DE43B82E47852BDA3")
        
public static void setLayoutDirection(View view, @LayoutDirectionMode int layoutDirection) {
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.082 -0400", hash_original_method = "1F2068DDAD86C0FF15102CEE7DBB6F17", hash_generated_method = "AB0E306B912E7392AE72CC72BCD81D67")
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.088 -0400", hash_original_method = "49E3C4AA6CE54B7C84275FBD581C84E3", hash_generated_method = "BB33EBDE412CBDF8A07C94655A243B6D")
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.093 -0400", hash_original_method = "F8DD309CCDB4A368448FB42453723E97", hash_generated_method = "4900920526200F5CA7795ED7E852689F")
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.097 -0400", hash_original_method = "D074DA630A442AE0E174C0F96C86287D", hash_generated_method = "4F78C0A43FA8E81C24AC09EFBC340885")
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.102 -0400", hash_original_method = "63876A100B34973DA9146F6B2B106193", hash_generated_method = "C098197D92684EE714942C211619CD16")
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.108 -0400", hash_original_method = "081B9E2DD3ED1E3A573F6F4943A5CE0C", hash_generated_method = "8E0C21E3B3D81D42AEEB84FB903DF2B2")
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.112 -0400", hash_original_method = "46108D1CAAEA00D102CE2D4FE151D97C", hash_generated_method = "395540A7301BAC85B5127E3BA8B9153D")
        
@AccessibilityLiveRegion
    public static int getAccessibilityLiveRegion(View view) {
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.117 -0400", hash_original_method = "B429E1CFBFD703F29DC5555D00DC82F7", hash_generated_method = "A20E2871794C81FB771772C4DD71B1A3")
        
public static void setAccessibilityLiveRegion(View view, @AccessibilityLiveRegion int mode) {
        IMPL.setAccessibilityLiveRegion(view, mode);
    }

    /**
     * Returns the start padding of the specified view depending on its resolved layout direction.
     * If there are inset and enabled scrollbars, this value may include the space
     * required to display the scrollbars as well.
     *
     * @param view The view to get padding for
     * @return the start padding in pixels
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.121 -0400", hash_original_method = "EDA82449C2FFEA6C2C72ED47A205C3E3", hash_generated_method = "E65533AF7E1734433C4552734281CD7F")
        
public static int getPaddingStart(View view) {
        return IMPL.getPaddingStart(view);
    }

    /**
     * Returns the end padding of the specified view depending on its resolved layout direction.
     * If there are inset and enabled scrollbars, this value may include the space
     * required to display the scrollbars as well.
     *
     * @param view The view to get padding for
     * @return the end padding in pixels
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.126 -0400", hash_original_method = "6A91162EA5E728DF2FD23CD9E3C6B3A8", hash_generated_method = "1633AD9051DE7FEDF022669F1EA32CF6")
        
public static int getPaddingEnd(View view) {
        return IMPL.getPaddingEnd(view);
    }

    /**
     * Sets the relative padding. The view may add on the space required to display
     * the scrollbars, depending on the style and visibility of the scrollbars.
     * So the values returned from {@link #getPaddingStart}, {@link View#getPaddingTop},
     * {@link #getPaddingEnd} and {@link View#getPaddingBottom} may be different
     * from the values set in this call.
     *
     * @param view The view on which to set relative padding
     * @param start the start padding in pixels
     * @param top the top padding in pixels
     * @param end the end padding in pixels
     * @param bottom the bottom padding in pixels
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.132 -0400", hash_original_method = "B124C713C85109C51A046725F4FC9C88", hash_generated_method = "AE67A54F0BA62636F25E9E1CACC4E5F3")
        
public static void setPaddingRelative(View view, int start, int top, int end, int bottom) {
        IMPL.setPaddingRelative(view, start, top, end, bottom);
    }

    /**
     * Notify a view that it is being temporarily detached.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.136 -0400", hash_original_method = "C954F6D4E3EFAD104D178F77A7A46033", hash_generated_method = "0EEDD005833981D6CEB5C4AF7BBA6827")
        
public static void dispatchStartTemporaryDetach(View view) {
        IMPL.dispatchStartTemporaryDetach(view);
    }

    /**
     * Notify a view that its temporary detach has ended; the view is now reattached.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.141 -0400", hash_original_method = "3501A55DA0A45D02E5C4DAD2B3E4C9F8", hash_generated_method = "813A6B5331E3F57F5D866FF8AE0065BD")
        
public static void dispatchFinishTemporaryDetach(View view) {
        IMPL.dispatchFinishTemporaryDetach(view);
    }

    /**
     * The horizontal location of this view relative to its {@link View#getLeft() left} position.
     * This position is post-layout, in addition to wherever the object's
     * layout placed it.
     *
     * <p>Prior to API 11 this will return 0.</p>
     *
     * @return The horizontal position of this view relative to its left position, in pixels.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.146 -0400", hash_original_method = "F80CC1367A16B11D8896073EB0E82662", hash_generated_method = "F2E3C8CC5EADE821888976DD7766678D")
        
public static float getTranslationX(View view) {
        return IMPL.getTranslationX(view);
    }

    /**
     * The vertical location of this view relative to its {@link View#getTop() left} position.
     * This position is post-layout, in addition to wherever the object's
     * layout placed it.
     *
     * <p>Prior to API 11 this will return 0.</p>
     *
     * @return The vertical position of this view relative to its top position, in pixels.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.150 -0400", hash_original_method = "4CC141D2E2D9356BBD82C01FCB672D31", hash_generated_method = "05CAF98DE139E2F6C2632B9081379CC0")
        
public static float getTranslationY(View view) {
        return IMPL.getTranslationY(view);
    }

    /**
     * Returns the minimum width of the view.
     *
     * <p>Prior to API 16 this will return 0.</p>
     *
     * @return the minimum width the view will try to be.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.154 -0400", hash_original_method = "AFB2E1A3FA943DF120A989904994CB78", hash_generated_method = "9A3648B22696A5B9516349D9F033ABF1")
        
public static int getMinimumWidth(View view) {
        return IMPL.getMinimumWidth(view);
    }

    /**
     * Returns the minimum height of the view.
     *
     * <p>Prior to API 16 this will return 0.</p>
     *
     * @return the minimum height the view will try to be.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.159 -0400", hash_original_method = "FBB8147D95470749DEF98AD88485E852", hash_generated_method = "226C9D29F7E99D17DDE241F6F91B5641")
        
public static int getMinimumHeight(View view) {
        return IMPL.getMinimumHeight(view);
    }

    /**
     * This method returns a ViewPropertyAnimator object, which can be used to animate
     * specific properties on this View.
     *
     * <p>Prior to API 14, this method will do nothing.</p>
     *
     * @return ViewPropertyAnimator The ViewPropertyAnimator associated with this View.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.163 -0400", hash_original_method = "51DD8209FA02495170C5BA83698DADAF", hash_generated_method = "1686C9716DF0557634A51A270F5A2CA5")
        
public static ViewPropertyAnimatorCompat animate(View view) {
        return IMPL.animate(view);
    }

    /**
     * Sets the horizontal location of this view relative to its left position.
     * This effectively positions the object post-layout, in addition to wherever the object's
     * layout placed it.
     *
     * <p>Prior to API 11 this will have no effect.</p>
     *
     * @param value The horizontal position of this view relative to its left position,
     * in pixels.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.168 -0400", hash_original_method = "65CC3BEE4328027857FDE112F59F02C5", hash_generated_method = "745E2CFF3576C4FA8BF9C6EB517C1E15")
        
public static void setTranslationX(View view, float value) {
        IMPL.setTranslationX(view, value);
    }

    /**
     * Sets the vertical location of this view relative to its top position.
     * This effectively positions the object post-layout, in addition to wherever the object's
     * layout placed it.
     *
     * <p>Prior to API 11 this will have no effect.</p>
     *
     * @param value The vertical position of this view relative to its top position,
     * in pixels.
     *
     * @attr ref android.R.styleable#View_translationY
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.173 -0400", hash_original_method = "B2F2F4C484F93132F7D873CC5058B1C3", hash_generated_method = "D9B7520102B8DDA9DFA8FC5651E44C66")
        
public static void setTranslationY(View view, float value) {
        IMPL.setTranslationY(view, value);
    }

    /**
     * <p>Sets the opacity of the view. This is a value from 0 to 1, where 0 means the view is
     * completely transparent and 1 means the view is completely opaque.</p>
     *
     * <p> Note that setting alpha to a translucent value (0 < alpha < 1) can have significant
     * performance implications, especially for large views. It is best to use the alpha property
     * sparingly and transiently, as in the case of fading animations.</p>
     *
     * <p>Prior to API 11 this will have no effect.</p>
     *
     * @param value The opacity of the view.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.178 -0400", hash_original_method = "050C3B96A8ECF04E756EC33D10412B32", hash_generated_method = "4DF661C1EA99585DDABF8DD169885CFB")
        
public static void setAlpha(View view, float value) {
        IMPL.setAlpha(view, value);
    }

    /**
     * Sets the visual x position of this view, in pixels. This is equivalent to setting the
     * {@link #setTranslationX(View, float) translationX} property to be the difference between
     * the x value passed in and the current left property of the view as determined
     * by the layout bounds.
     *
     * <p>Prior to API 11 this will have no effect.</p>
     *
     * @param value The visual x position of this view, in pixels.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.183 -0400", hash_original_method = "BA3E790F2CC4B0A18B8620ECAAFDE1BD", hash_generated_method = "CB1458C925471E5BEA76D3506CC193DA")
        
public static void setX(View view, float value) {
        IMPL.setX(view, value);
    }

    /**
     * Sets the visual y position of this view, in pixels. This is equivalent to setting the
     * {@link #setTranslationY(View, float) translationY} property to be the difference between
     * the y value passed in and the current top property of the view as determined by the
     * layout bounds.
     *
     * <p>Prior to API 11 this will have no effect.</p>
     *
     * @param value The visual y position of this view, in pixels.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.188 -0400", hash_original_method = "5A05BC1D19C2B9E8654D4492B55F5BB8", hash_generated_method = "35D97EBA36B132F0FEBA71741F8AE841")
        
public static void setY(View view, float value) {
        IMPL.setY(view, value);
    }

    /**
     * Sets the degrees that the view is rotated around the pivot point. Increasing values
     * result in clockwise rotation.
     *
     * <p>Prior to API 11 this will have no effect.</p>
     *
     * @param value The degrees of rotation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.193 -0400", hash_original_method = "1C4EA394946FD7D4F27F5B5374A7D140", hash_generated_method = "BB134BCCA098C977555860104513D7BF")
        
public static void setRotation(View view, float value) {
        IMPL.setRotation(view, value);
    }

    /**
     * Sets the degrees that the view is rotated around the horizontal axis through the pivot point.
     * Increasing values result in clockwise rotation from the viewpoint of looking down the
     * x axis.
     *
     * <p>Prior to API 11 this will have no effect.</p>
     *
     * @param value The degrees of X rotation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.197 -0400", hash_original_method = "F8E1642590581AAB88FA557212C80755", hash_generated_method = "B2C64F14568900A4077246355F9A45BC")
        
public static void setRotationX(View view, float value) {
        IMPL.setRotationX(view, value);
    }

    /**
     * Sets the degrees that the view is rotated around the vertical axis through the pivot point.
     * Increasing values result in counter-clockwise rotation from the viewpoint of looking
     * down the y axis.
     *
     * <p>Prior to API 11 this will have no effect.</p>
     *
     * @param value The degrees of Y rotation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.204 -0400", hash_original_method = "4D34CBC70754A4F90CD81A2F84C6AA0D", hash_generated_method = "64EB50CF7414030165EF1B732CBA01B0")
        
public static void setRotationY(View view, float value) {
        IMPL.setRotationY(view, value);
    }

    /**
     * Sets the amount that the view is scaled in x around the pivot point, as a proportion of
     * the view's unscaled width. A value of 1 means that no scaling is applied.
     *
     * <p>Prior to API 11 this will have no effect.</p>
     *
     * @param value The scaling factor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.210 -0400", hash_original_method = "1D6AF97EF236DB27ED03D433B2EC8560", hash_generated_method = "8F48AE8B6B1DB968BC23E87FB9F66D77")
        
public static void setScaleX(View view, float value) {
        IMPL.setScaleX(view, value);
    }

    /**
     * Sets the amount that the view is scaled in Y around the pivot point, as a proportion of
     * the view's unscaled width. A value of 1 means that no scaling is applied.
     *
     * <p>Prior to API 11 this will have no effect.</p>
     *
     * @param value The scaling factor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.215 -0400", hash_original_method = "1802B9AA391AA7ECB0E8E8E2459C997B", hash_generated_method = "A0C589A138BE6E0B2AD61E67414F31F1")
        
public static void setScaleY(View view, float value) {
        IMPL.setScaleY(view, value);
    }

    /**
     * The x location of the point around which the view is
     * {@link #setRotation(View, float) rotated} and {@link #setScaleX(View, float) scaled}.
     *
     * <p>Prior to API 11 this will have no effect.</p>
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.220 -0400", hash_original_method = "F5893004DBA4174DF4A769A3E664ECAE", hash_generated_method = "4D6DC7BA6A984B44CFEFA585927953CC")
        
public float getPivotX(View view) {
        return IMPL.getPivotX(view);
    }

    /**
     * Sets the x location of the point around which the view is
     * {@link #setRotation(View, float) rotated} and {@link #setScaleX(View, float) scaled}.
     * By default, the pivot point is centered on the object.
     * Setting this property disables this behavior and causes the view to use only the
     * explicitly set pivotX and pivotY values.
     *
     * <p>Prior to API 11 this will have no effect.</p>
     *
     * @param value The x location of the pivot point.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.224 -0400", hash_original_method = "DB784B16C64517A850AC0D708702BC72", hash_generated_method = "5C4DD6EC861089C39CF1BC4BBFAC403C")
        
public void setPivotX(View view, float value) {
        IMPL.setPivotX(view, value);
    }

    /**
     * The y location of the point around which the view is {@link #setRotation(View,
     * float) rotated} and {@link #setScaleY(View, float) scaled}.
     *
     * <p>Prior to API 11 this will return 0.</p>
     *
     * @return The y location of the pivot point.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.229 -0400", hash_original_method = "373B35DBA277B6D1D8D22E028FE427EB", hash_generated_method = "832473A37EB44A958A9354D6733508C1")
        
public float getPivotY(View view) {
        return IMPL.getPivotY(view);
    }

    /**
     * Sets the y location of the point around which the view is
     * {@link #setRotation(View, float) rotated} and {@link #setScaleY(View, float) scaled}.
     * By default, the pivot point is centered on the object.
     * Setting this property disables this behavior and causes the view to use only the
     * explicitly set pivotX and pivotY values.
     *
     * <p>Prior to API 11 this will have no effect.</p>
     *
     * @param value The y location of the pivot point.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.233 -0400", hash_original_method = "DBBC89C9FB31393D4AF499D419A36944", hash_generated_method = "AFAFDF4B20B2EEC5F3EE074B283073D0")
        
public void setPivotY(View view, float value) {
        IMPL.setPivotX(view, value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.238 -0400", hash_original_method = "FC6EDCF4BDCCD69421E6554AF61A5DA2", hash_generated_method = "094B28DCD10567A0342F63001AC2F344")
        
public float getRotation(View view) {
        return IMPL.getRotation(view);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.242 -0400", hash_original_method = "C8B87EB4B388580A6BBC4F606CBC1A60", hash_generated_method = "C9C10F8E12B231E558D8AE6C7020C552")
        
public float getRotationX(View view) {
        return IMPL.getRotationX(view);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.246 -0400", hash_original_method = "81230FAB13903480E0F0A6A25AA9F9C1", hash_generated_method = "8717D9075577A1C02621035CF424133B")
        
public float getRotationY(View view) {
        return IMPL.getRotationY(view);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.251 -0400", hash_original_method = "69D5D4B6A35397C39865BFD2D04B3C98", hash_generated_method = "20A8B3C8068CD24B0E2A8CA0DDA92B5E")
        
public float getScaleX(View view) {
        return IMPL.getScaleX(view);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.255 -0400", hash_original_method = "AD5CB0C70506746CDCD2DAE2556D4F65", hash_generated_method = "96F04AF20253C5B2B0B8A132CC9DF24B")
        
public float getScaleY(View view) {
        return IMPL.getScaleY(view);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.259 -0400", hash_original_method = "CFC10ED4C5C0B7EB8F15E2E7A1C253FB", hash_generated_method = "350565A25BFEB300043E05C2D9A81F03")
        
public float getX(View view) {
        return IMPL.getX(view);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:58:19.263 -0400", hash_original_method = "16824F8ED38935616A07A6ED4769E7B8", hash_generated_method = "03293B20A6B501925CA04FC0B20993D0")
        
public float getY(View view) {
        return IMPL.getY(view);
    }

    // TODO: getters for various view properties (rotation, etc)
}
