/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.support.v4.widget;

import android.os.Build;
import android.view.animation.Interpolator;
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:40.495 -0400", hash_original_method = "0764E8F4B67CA9D0E2FB09B48BECB8C6", hash_generated_method = "83DF987F8679674E57BC6669B9A5F4BC")
            
        public float getCurrVelocity(Object scroller) {
            return ScrollerCompatIcs.getCurrVelocity((Scroller)scroller);
        }}
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
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:40.524 -0400", hash_original_method = "11CABA54472F263992F2940138C1CB0C", hash_generated_method = "9A52536CC723D2F88CF8A51F7D073A1D")
        
public boolean isFinished() {
        return IMPL.isFinished(mScroller);
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
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:40.527 -0400", hash_original_method = "B815160F376EBB11C2A18AA4D2E8FC95", hash_generated_method = "9FE4C83B830EB71BC6727845DD7E42D9")
        
public int getCurrX() {
        return IMPL.getCurrX(mScroller);
    }

    /**
     * Returns the current Y offset in the scroll.
     *
     * @return The new Y offset as an absolute distance from the origin.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:40.530 -0400", hash_original_method = "A19A402C35D861B6A946F669639762CF", hash_generated_method = "24CBDBABF4C8DFCDC3BC57294B0B530C")
        
public int getCurrY() {
        return IMPL.getCurrY(mScroller);
    }

    /**
     * Returns the current velocity on platform versions that support it.
     *
     * <p>The device must support at least API level 14 (Ice Cream Sandwich).
     * On older platform versions this method will return 0. This method should
     * only be used as input for nonessential visual effects such as {@link EdgeEffectCompat}.</p>
     *
     * @return The original velocity less the deceleration. Result may be
     * negative.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:40.539 -0400", hash_original_method = "430FB218CB87FCDEAF4019662616EE32", hash_generated_method = "5BB62D5FD5CC8C36D234EC593D24EF32")
        
public float getCurrVelocity() {
        return IMPL.getCurrVelocity(mScroller);
    }

    /**
     * Call this when you want to know the new location.  If it returns true,
     * the animation is not yet finished.  loc will be altered to provide the
     * new location.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:40.543 -0400", hash_original_method = "ECC72998C7D88FADC4D1D87DC14F5F46", hash_generated_method = "207F8C6420F9420683865CEC96A3810B")
        
public boolean computeScrollOffset() {
        return IMPL.computeScrollOffset(mScroller);
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:40.548 -0400", hash_original_method = "C0B126AD76096694715812FEFBB0DD84", hash_generated_method = "930A010765D3C2CCADEBFAA345252E06")
        
public void startScroll(int startX, int startY, int dx, int dy) {
        IMPL.startScroll(mScroller, startX, startY, dx, dy);
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:40.552 -0400", hash_original_method = "8AB25FB3E98E38D4F499309DFB22FBD7", hash_generated_method = "0BE5CC9055AF8AC249E889C2D61D190C")
        
public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        IMPL.startScroll(mScroller, startX, startY, dx, dy, duration);
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:40.557 -0400", hash_original_method = "18912E232E88A5E781F61E47D9282344", hash_generated_method = "4F4507D34731F4942F69C7E6CB0470BD")
        
public void fling(int startX, int startY, int velocityX, int velocityY,
            int minX, int maxX, int minY, int maxY) {
        IMPL.fling(mScroller, startX, startY, velocityX, velocityY, minX, maxX, minY, maxY);
    }

    /**
     * Stops the animation. Aborting the animation causes the scroller to move to the final x and y
     * position.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:40.571 -0400", hash_original_method = "E005DA6439155CCFD4499447A0C361E5", hash_generated_method = "7C65BD8AEDAEB6F75CDA63ACC45B17DC")
        
public void abortAnimation() {
        IMPL.abortAnimation(mScroller);
    }

@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:40.506 -0400", hash_original_field = "6C0E1CE3AF31A13B0F9072B46668518D", hash_generated_field = "E4FF87B37D3C54043BCFA3A333E80A77")

    static  ScrollerCompatImpl IMPL;

    interface ScrollerCompatImpl {
        Object createScroller(Context context, Interpolator interpolator);
        boolean isFinished(Object scroller);
        int getCurrX(Object scroller);
        int getCurrY(Object scroller);
        float getCurrVelocity(Object scroller);
        boolean computeScrollOffset(Object scroller);
        void startScroll(Object scroller, int startX, int startY, int dx, int dy);
        void startScroll(Object scroller, int startX, int startY, int dx, int dy, int duration);
        void fling(Object scroller, int startX, int startY, int velX, int velY,
                int minX, int maxX, int minY, int maxY);
        void fling(Object scroller, int startX, int startY, int velX, int velY,
                int minX, int maxX, int minY, int maxY, int overX, int overY);
        void abortAnimation(Object scroller);
        void notifyHorizontalEdgeReached(Object scroller, int startX, int finalX, int overX);
        void notifyVerticalEdgeReached(Object scroller, int startY, int finalY, int overY);
        boolean isOverScrolled(Object scroller);
        int getFinalX(Object scroller);
        int getFinalY(Object scroller);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:40.520 -0400", hash_original_method = "BDFDA41137CF2FBBECB72CB483D24F5B", hash_generated_method = "BDFDA41137CF2FBBECB72CB483D24F5B")
        
ScrollerCompat(Context context, Interpolator interpolator) {
        mScroller = (Scroller) IMPL.createScroller(context, interpolator);
    }

    /**
     * Returns whether the current Scroller is currently returning to a valid position.
     * Valid bounds were provided by the
     * {@link #fling(int, int, int, int, int, int, int, int, int, int)} method.
     *
     * One should check this value before calling
     * {@link #startScroll(int, int, int, int)} as the interpolation currently in progress
     * to restore a valid position will then be stopped. The caller has to take into account
     * the fact that the started scroll will start from an overscrolled position.
     *
     * @return true when the current position is overscrolled and in the process of
     *         interpolating back to a valid value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:40.590 -0400", hash_original_method = "4D505AD1DD3F6334754F33286D4337E2", hash_generated_method = "69E0A9D940F7B0A33A3DBA2DBF057BB1")
        
public boolean isOverScrolled() {
        return IMPL.isOverScrolled(mScroller);
    }

    /**
     * Notify the scroller that we've reached a vertical boundary.
     * Normally the information to handle this will already be known
     * when the animation is started, such as in a call to one of the
     * fling functions. However there are cases where this cannot be known
     * in advance. This function will animate a parabolic motion from
     * startY to finalY.
     *
     * @param startY Starting/current Y position
     * @param finalY Desired final Y position
     * @param overY Magnitude of overscroll allowed. This should be the maximum
     *              desired distance from finalY. Absolute value - must be positive.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:40.584 -0400", hash_original_method = "082AC6F604997EF37F74D1977468BC58", hash_generated_method = "E0353E1CB0511C1E910BE4EEF01143D8")
        
public void notifyVerticalEdgeReached(int startY, int finalY, int overY) {
        IMPL.notifyVerticalEdgeReached(mScroller, startY, finalY, overY);
    }

    /**
     * Notify the scroller that we've reached a horizontal boundary.
     * Normally the information to handle this will already be known
     * when the animation is started, such as in a call to one of the
     * fling functions. However there are cases where this cannot be known
     * in advance. This function will transition the current motion and
     * animate from startX to finalX as appropriate.
     *
     * @param startX Starting/current X position
     * @param finalX Desired final X position
     * @param overX Magnitude of overscroll allowed. This should be the maximum
     *              desired distance from finalX. Absolute value - must be positive.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:40.577 -0400", hash_original_method = "56EE1FFA33CB4FCC94D177D6C214BE92", hash_generated_method = "8303FDA3A9096961713F217E27605FF4")
        
public void notifyHorizontalEdgeReached(int startX, int finalX, int overX) {
        IMPL.notifyHorizontalEdgeReached(mScroller, startX, finalX, overX);
    }

    static class ScrollerCompatImplBase implements ScrollerCompatImpl {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Object createScroller(Context context, Interpolator interpolator) {
            return interpolator != null ?
                    new Scroller(context, interpolator) : new Scroller(context);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isFinished(Object scroller) {
            return ((Scroller) scroller).isFinished();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getCurrX(Object scroller) {
            return ((Scroller) scroller).getCurrX();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getCurrY(Object scroller) {
            return ((Scroller) scroller).getCurrY();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public float getCurrVelocity(Object scroller) {
            return 0;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean computeScrollOffset(Object scroller) {
            return ((Scroller) scroller).computeScrollOffset();
        }
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void startScroll(Object scroller, int startX, int startY, int dx, int dy) {
            ((Scroller) scroller).startScroll(startX, startY, dx, dy);
        }
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void startScroll(Object scroller, int startX, int startY, int dx, int dy,
                int duration) {
            ((Scroller) scroller).startScroll(startX, startY, dx, dy, duration);
        }
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void fling(Object scroller, int startX, int startY, int velX, int velY,
                int minX, int maxX, int minY, int maxY) {
            ((Scroller) scroller).fling(startX, startY, velX, velY, minX, maxX, minY, maxY);
        }
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void fling(Object scroller, int startX, int startY, int velX, int velY,
                int minX, int maxX, int minY, int maxY, int overX, int overY) {
            ((Scroller) scroller).fling(startX, startY, velX, velY, minX, maxX, minY, maxY);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void abortAnimation(Object scroller) {
            ((Scroller) scroller).abortAnimation();
        }
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void notifyHorizontalEdgeReached(Object scroller, int startX, int finalX,
                int overX) {
            // No-op
        }
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void notifyVerticalEdgeReached(Object scroller, int startY, int finalY, int overY) {
            // No-op
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isOverScrolled(Object scroller) {
            // Always false
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getFinalX(Object scroller) {
            return ((Scroller) scroller).getFinalX();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getFinalY(Object scroller) {
            return ((Scroller) scroller).getFinalY();
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:40.512 -0400", hash_original_method = "6675C157AAA92FCDCADBDC0DF5C2A33B", hash_generated_method = "6FF1BE024EB83439B843D693BB27ED55")
        
public static ScrollerCompat create(Context context) {
        return create(context, null);
    }

    static class ScrollerCompatImplGingerbread implements ScrollerCompatImpl {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Object createScroller(Context context, Interpolator interpolator) {
            return ScrollerCompatGingerbread.createScroller(context, interpolator);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isFinished(Object scroller) {
            return ScrollerCompatGingerbread.isFinished(scroller);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getCurrX(Object scroller) {
            return ScrollerCompatGingerbread.getCurrX(scroller);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getCurrY(Object scroller) {
            return ScrollerCompatGingerbread.getCurrY(scroller);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public float getCurrVelocity(Object scroller) {
            return 0;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean computeScrollOffset(Object scroller) {
            return ScrollerCompatGingerbread.computeScrollOffset(scroller);
        }

        @Override
        public void startScroll(Object scroller, int startX, int startY, int dx, int dy) {
            ScrollerCompatGingerbread.startScroll(scroller, startX, startY, dx, dy);
        }

        @Override
        public void startScroll(Object scroller, int startX, int startY, int dx, int dy,
                int duration) {
            ScrollerCompatGingerbread.startScroll(scroller, startX, startY, dx, dy, duration);
        }

        @Override
        public void fling(Object scroller, int startX, int startY, int velX, int velY,
                int minX, int maxX, int minY, int maxY) {
            ScrollerCompatGingerbread.fling(scroller, startX, startY, velX, velY,
                    minX, maxX, minY, maxY);
        }

        @Override
        public void fling(Object scroller, int startX, int startY, int velX, int velY,
                int minX, int maxX, int minY, int maxY, int overX, int overY) {
            ScrollerCompatGingerbread.fling(scroller, startX, startY, velX, velY,
                    minX, maxX, minY, maxY, overX, overY);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void abortAnimation(Object scroller) {
            ScrollerCompatGingerbread.abortAnimation(scroller);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void notifyHorizontalEdgeReached(Object scroller, int startX, int finalX,
                int overX) {
            ScrollerCompatGingerbread.notifyHorizontalEdgeReached(scroller, startX, finalX, overX);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void notifyVerticalEdgeReached(Object scroller, int startY, int finalY, int overY) {
            ScrollerCompatGingerbread.notifyVerticalEdgeReached(scroller, startY, finalY, overY);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isOverScrolled(Object scroller) {
            return ScrollerCompatGingerbread.isOverScrolled(scroller);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getFinalX(Object scroller) {
            return ScrollerCompatGingerbread.getFinalX(scroller);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getFinalY(Object scroller) {
            return ScrollerCompatGingerbread.getFinalY(scroller);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:40.516 -0400", hash_original_method = "EF0DA108440114D747965FBB756462D0", hash_generated_method = "3AB1B6FB0180957FA6CF5DEA3627A240")
        
public static ScrollerCompat create(Context context, Interpolator interpolator) {
        return new ScrollerCompat(context, interpolator);
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
     * @param overX Overfling range. If > 0, horizontal overfling in either
     *            direction will be possible.
     * @param overY Overfling range. If > 0, vertical overfling in either
     *            direction will be possible.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:40.565 -0400", hash_original_method = "543ABF1653F4D95CB3C6761CBBBA7BFD", hash_generated_method = "6DC44AC627B1A5C4A66AD48D9E19192B")
        
public void fling(int startX, int startY, int velocityX, int velocityY,
            int minX, int maxX, int minY, int maxY, int overX, int overY) {
        IMPL.fling(mScroller, startX, startY, velocityX, velocityY,
                minX, maxX, minY, maxY, overX, overY);
    }

    /**
     * @return The final Y position for the scroll in progress, if known.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:40.536 -0400", hash_original_method = "9261256690A4BD04EE31F493375BFA46", hash_generated_method = "60917930334D4B064D58B2A4281422EE")
        
public int getFinalY() {
        return IMPL.getFinalY(mScroller);
    }

    /**
     * @return The final X position for the scroll in progress, if known.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 11:53:40.533 -0400", hash_original_method = "69A8D29CBC3A4B7AF16781633F54C850", hash_generated_method = "A777EF428E1503AE17668E2F72533FEA")
        
public int getFinalX() {
        return IMPL.getFinalX(mScroller);
    }}
