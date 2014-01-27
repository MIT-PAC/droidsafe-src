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
import android.widget.Scroller;

/**
 * Provides access to new {@link android.widget.Scroller Scroller} APIs when available.
 *
 * <p>This class provides a platform version-independent mechanism for obeying the
 * current device's preferred scroll physics and fling behavior. It offers a subset of
 * the APIs from Scroller or OverScroller.</p>
 */
class ScrollerCompat {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:37.924 -0500", hash_original_method = "919E3D856BE363687C76479CB8511F80", hash_generated_method = "E1AEAC1C0896A9CEA0871396706F5FB6")
    
public static ScrollerCompat from(Context context) {
        if (android.os.Build.VERSION.SDK_INT >= 14) {
            return new ScrollerCompatImplIcs(context);
        }
        return new ScrollerCompat(context);
    }

    static class ScrollerCompatImplIcs extends ScrollerCompat {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:37.920 -0500", hash_original_method = "A457AA7689BFE7024C2FB76B15B39CB7", hash_generated_method = "BA59C0F0963740EE8B74527293A7C112")
        
public ScrollerCompatImplIcs(Context context) {
            super(context);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:37.921 -0500", hash_original_method = "3DB200182B4DEC93AD6432958A4646FE", hash_generated_method = "17009BD1CC72BE7CFE48D4E123DBBE64")
        
@Override
        public float getCurrVelocity() {
            return ScrollerCompatIcs.getCurrVelocity(mScroller);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:37.919 -0500", hash_original_field = "16226695B3E75E1B75AD8C16FE7698DB", hash_generated_field = "16226695B3E75E1B75AD8C16FE7698DB")

    Scroller mScroller;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:37.926 -0500", hash_original_method = "FA1A2D0DAD3F764AAD83BFC7CD2D5247", hash_generated_method = "FA1A2D0DAD3F764AAD83BFC7CD2D5247")
    
ScrollerCompat(Context context) {
        mScroller = new Scroller(context);
    }

    /**
     * Returns whether the scroller has finished scrolling.
     *
     * @return True if the scroller has finished scrolling, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:37.927 -0500", hash_original_method = "08E3AC245A369E97AD27AAF8D6409619", hash_generated_method = "680FB2B13D8F721F58E8BB8014E7F0BB")
    
public boolean isFinished() {
        return mScroller.isFinished();
    }

    /**
     * Returns how long the scroll event will take, in milliseconds.
     *
     * @return The duration of the scroll in milliseconds.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:37.928 -0500", hash_original_method = "366441F0E9218C10049321570A6B0EEE", hash_generated_method = "8C0508AE618133AE0726E4EB914576A7")
    
public int getDuration() {
        return mScroller.getDuration();
    }

    /**
     * Returns the current X offset in the scroll.
     *
     * @return The new X offset as an absolute distance from the origin.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:37.929 -0500", hash_original_method = "35378E6889E84DC24B962EF341786646", hash_generated_method = "4B1FC92E58CF7EAE2C2B33E18B5D6F18")
    
public int getCurrX() {
        return mScroller.getCurrX();
    }

    /**
     * Returns the current Y offset in the scroll.
     *
     * @return The new Y offset as an absolute distance from the origin.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:37.931 -0500", hash_original_method = "88F1303EFC32E6128287766990FA2843", hash_generated_method = "6401DA147189520182B19130F8F11092")
    
public int getCurrY() {
        return mScroller.getCurrY();
    }

    /**
     * Returns the current velocity.
     *
     * TODO: Approximate a sane result for older platform versions. Right now
     * this will return 0 for platforms earlier than ICS. This is acceptable
     * at the moment only since it is only used for EdgeEffect, which is also only
     * present in ICS+, and ScrollerCompat is not public.
     *
     * @return The original velocity less the deceleration. Result may be
     * negative.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:37.933 -0500", hash_original_method = "7F4E33B7B0F7490B30E97B0B0A01E6E1", hash_generated_method = "3438DDD97C42E30E69F13B15DB54692F")
    
public float getCurrVelocity() {
        return 0;
    }

    /**
     * Call this when you want to know the new location.  If it returns true,
     * the animation is not yet finished.  loc will be altered to provide the
     * new location.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:37.935 -0500", hash_original_method = "A0C0DE015B6558CE9DF1FB944A356241", hash_generated_method = "BC1F6D096AF08125237A11007FCED2B2")
    
public boolean computeScrollOffset() {
        return mScroller.computeScrollOffset();
    }

    /**
     * Start scrolling by providing a starting point and the distance to travel.
     * The scroll will use the default value of 250 milliseconds for the
     * duration.
     *
     * @param startX Starting horizontal scroll offset in pixels. Positive
     *        numbers will scroll the content to the left.
     * @param startY Starting vertical scroll offset in pixels. Positive numbers
     *        will scroll the content up.
     * @param dx Horizontal distance to travel. Positive numbers will scroll the
     *        content to the left.
     * @param dy Vertical distance to travel. Positive numbers will scroll the
     *        content up.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:37.937 -0500", hash_original_method = "B37994C7256BD0AE82424571EBE03373", hash_generated_method = "8401A0FBB56C5428061EA1D9041082AF")
    
public void startScroll(int startX, int startY, int dx, int dy) {
        mScroller.startScroll(startX, startY, dx, dy);
    }

    /**
     * Start scrolling by providing a starting point and the distance to travel.
     *
     * @param startX Starting horizontal scroll offset in pixels. Positive
     *        numbers will scroll the content to the left.
     * @param startY Starting vertical scroll offset in pixels. Positive numbers
     *        will scroll the content up.
     * @param dx Horizontal distance to travel. Positive numbers will scroll the
     *        content to the left.
     * @param dy Vertical distance to travel. Positive numbers will scroll the
     *        content up.
     * @param duration Duration of the scroll in milliseconds.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:37.940 -0500", hash_original_method = "AD5D18790E0603EF4AC905740DD66097", hash_generated_method = "BBEDA6B6E340D4CD3D30D1F001BA1038")
    
public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        mScroller.startScroll(startX, startY, dx, dy, duration);
    }

    /**
     * Start scrolling based on a fling gesture. The distance travelled will
     * depend on the initial velocity of the fling.
     *
     * @param startX Starting point of the scroll (X)
     * @param startY Starting point of the scroll (Y)
     * @param velocityX Initial velocity of the fling (X) measured in pixels per
     *        second.
     * @param velocityY Initial velocity of the fling (Y) measured in pixels per
     *        second
     * @param minX Minimum X value. The scroller will not scroll past this
     *        point.
     * @param maxX Maximum X value. The scroller will not scroll past this
     *        point.
     * @param minY Minimum Y value. The scroller will not scroll past this
     *        point.
     * @param maxY Maximum Y value. The scroller will not scroll past this
     *        point.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:37.941 -0500", hash_original_method = "7C081E82C785E2E194103B9AE1A28412", hash_generated_method = "FF8580BFA3C622674381F56ED2E5E8F0")
    
public void fling(int startX, int startY, int velocityX, int velocityY,
            int minX, int maxX, int minY, int maxY) {
        mScroller.fling(startX, startY, velocityX, velocityY, minX, maxX, minY, maxY);
    }

    /**
     * Stops the animation. Contrary to {@link #forceFinished(boolean)},
     * aborting the animating cause the scroller to move to the final x and y
     * position
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:37.942 -0500", hash_original_method = "C4C8DA6FAA392191BEE38D271B2F867F", hash_generated_method = "DFFF34A542109F688C3BD1F3D5E094F4")
    
public void abortAnimation() {
        mScroller.abortAnimation();
    }
}
