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
 * Copyright (C) 2013 The Android Open Source Project
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


package android.support.v4.view;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.Build;
import android.view.ViewGroup;

/**
 * Helper for accessing API features in
 * {@link android.view.ViewGroup.MarginLayoutParams MarginLayoutParams} added after API 4.
 */
public class MarginLayoutParamsCompat {
    interface MarginLayoutParamsCompatImpl {
        int getMarginStart(ViewGroup.MarginLayoutParams lp);
        int getMarginEnd(ViewGroup.MarginLayoutParams lp);
        void setMarginStart(ViewGroup.MarginLayoutParams lp, int marginStart);
        void setMarginEnd(ViewGroup.MarginLayoutParams lp, int marginEnd);
        boolean isMarginRelative(ViewGroup.MarginLayoutParams lp);
        int getLayoutDirection(ViewGroup.MarginLayoutParams lp);
        void setLayoutDirection(ViewGroup.MarginLayoutParams lp, int layoutDirection);
        void resolveLayoutDirection(ViewGroup.MarginLayoutParams lp, int layoutDirection);
    }

    static class MarginLayoutParamsCompatImplBase implements MarginLayoutParamsCompatImpl {

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getMarginStart(ViewGroup.MarginLayoutParams lp) {
            return lp.leftMargin;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getMarginEnd(ViewGroup.MarginLayoutParams lp) {
            return lp.rightMargin;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setMarginStart(ViewGroup.MarginLayoutParams lp, int marginStart) {
            lp.leftMargin = marginStart;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setMarginEnd(ViewGroup.MarginLayoutParams lp, int marginEnd) {
            lp.rightMargin = marginEnd;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isMarginRelative(ViewGroup.MarginLayoutParams lp) {
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getLayoutDirection(ViewGroup.MarginLayoutParams lp) {
            //return ViewCompat.LAYOUT_DIRECTION_LTR;
            return DSUtils.FAKE_INT;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setLayoutDirection(ViewGroup.MarginLayoutParams lp, int layoutDirection) {
            // No-op
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void resolveLayoutDirection(ViewGroup.MarginLayoutParams lp, int layoutDirection) {
            // No-op
        }
    }

    static class MarginLayoutParamsCompatImplJbMr1 implements MarginLayoutParamsCompatImpl {

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getMarginStart(ViewGroup.MarginLayoutParams lp) {
            return MarginLayoutParamsCompatJellybeanMr1.getMarginStart(lp);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getMarginEnd(ViewGroup.MarginLayoutParams lp) {
            return MarginLayoutParamsCompatJellybeanMr1.getMarginEnd(lp);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setMarginStart(ViewGroup.MarginLayoutParams lp, int marginStart) {
            MarginLayoutParamsCompatJellybeanMr1.setMarginStart(lp, marginStart);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setMarginEnd(ViewGroup.MarginLayoutParams lp, int marginEnd) {
            MarginLayoutParamsCompatJellybeanMr1.setMarginEnd(lp, marginEnd);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isMarginRelative(ViewGroup.MarginLayoutParams lp) {
            return MarginLayoutParamsCompatJellybeanMr1.isMarginRelative(lp);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getLayoutDirection(ViewGroup.MarginLayoutParams lp) {
            return MarginLayoutParamsCompatJellybeanMr1.getLayoutDirection(lp);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setLayoutDirection(ViewGroup.MarginLayoutParams lp, int layoutDirection) {
            MarginLayoutParamsCompatJellybeanMr1.setLayoutDirection(lp, layoutDirection);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void resolveLayoutDirection(ViewGroup.MarginLayoutParams lp, int layoutDirection) {
            MarginLayoutParamsCompatJellybeanMr1.resolveLayoutDirection(lp, layoutDirection);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:00.894 -0400", hash_original_field = "B4D73602A5D6DC3503486B65C1D6FE41", hash_generated_field = "7D50C44D218F071796F75D4CD56AFB2B")

    static  MarginLayoutParamsCompatImpl IMPL;
    static {
        final int version = Build.VERSION.SDK_INT;
        if (version >= 17) { // jb-mr1
            IMPL = new MarginLayoutParamsCompatImplJbMr1();
        } else {
            IMPL = new MarginLayoutParamsCompatImplBase();
        }
    }

    /**
     * Get the relative starting margin that was set.
     *
     * <p>On platform versions supporting bidirectional text and layouts
     * this value will be resolved into the LayoutParams object's left or right
     * margin as appropriate when the associated View is attached to a window
     * or when the layout direction of that view changes.</p>
     *
     * @param lp LayoutParams to query
     * @return the margin along the starting edge in pixels
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:00.900 -0400", hash_original_method = "4B9CC687978016222D57C5F4F46054FF", hash_generated_method = "670DC7FC95B58B6DB4D0D949B6B62FC0")
        
public static int getMarginStart(ViewGroup.MarginLayoutParams lp) {
        return IMPL.getMarginStart(lp);
    }

    /**
     * Get the relative ending margin that was set.
     *
     * <p>On platform versions supporting bidirectional text and layouts
     * this value will be resolved into the LayoutParams object's left or right
     * margin as appropriate when the associated View is attached to a window
     * or when the layout direction of that view changes.</p>
     *
     * @param lp LayoutParams to query
     * @return the margin along the ending edge in pixels
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:00.904 -0400", hash_original_method = "401A33757930D94EA92F08C9F612FDFD", hash_generated_method = "902A8A535A734F055E9638CC28947940")
        
public static int getMarginEnd(ViewGroup.MarginLayoutParams lp) {
        return IMPL.getMarginEnd(lp);
    }

    /**
     * Set the relative start margin.
     *
     * <p>On platform versions supporting bidirectional text and layouts
     * this value will be resolved into the LayoutParams object's left or right
     * margin as appropriate when the associated View is attached to a window
     * or when the layout direction of that view changes.</p>
     *
     * @param lp LayoutParams to query
     * @param marginStart the desired start margin in pixels
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:00.909 -0400", hash_original_method = "91F41F0D51424BAAABC25A1288AAE40C", hash_generated_method = "6F30699B04A746DA431BE7644A052801")
        
public static void setMarginStart(ViewGroup.MarginLayoutParams lp, int marginStart) {
        IMPL.setMarginStart(lp, marginStart);
    }

    /**
     * Set the relative end margin.
     *
     * <p>On platform versions supporting bidirectional text and layouts
     * this value will be resolved into the LayoutParams object's left or right
     * margin as appropriate when the associated View is attached to a window
     * or when the layout direction of that view changes.</p>
     *
     * @param lp LayoutParams to query
     * @param marginEnd the desired end margin in pixels
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:00.913 -0400", hash_original_method = "043E0845ECC71B34F75CAEA21DBBA800", hash_generated_method = "BF95D59AB907D8CF42029596990F0880")
        
public static void setMarginEnd(ViewGroup.MarginLayoutParams lp, int marginEnd) {
        IMPL.setMarginEnd(lp, marginEnd);
    }

    /**
     * Check if margins are relative.
     *
     * @return true if either marginStart or marginEnd has been set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:00.917 -0400", hash_original_method = "6481A24114D20C06ED396520204BD1D0", hash_generated_method = "BCE3B4E5A8C80A7B0EFEDF010984ABC5")
        
public static boolean isMarginRelative(ViewGroup.MarginLayoutParams lp) {
        return IMPL.isMarginRelative(lp);
    }

    /**
     * Retuns the layout direction. Can be either {@link ViewCompat#LAYOUT_DIRECTION_LTR} or
     * {@link ViewCompat#LAYOUT_DIRECTION_RTL}.
     *
     * @return the layout direction.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:00.921 -0400", hash_original_method = "0C97179A111E49198CCA78CD6C46E971", hash_generated_method = "B8BB30D9094F10F55CD1EA1596F3C380")
        
public static int getLayoutDirection(ViewGroup.MarginLayoutParams lp) {
        return IMPL.getLayoutDirection(lp);
    }

    /**
     * Set the layout direction.
     *
     * @param layoutDirection the layout direction.
     *        Should be either {@link ViewCompat#LAYOUT_DIRECTION_LTR}
     *                     or {@link ViewCompat#LAYOUT_DIRECTION_RTL}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:00.926 -0400", hash_original_method = "7254D214E0495AE3ADD1337EFF0B927B", hash_generated_method = "948A9501326E900330AD794E815B37F1")
        
public static void setLayoutDirection(ViewGroup.MarginLayoutParams lp, int layoutDirection) {
        IMPL.setLayoutDirection(lp, layoutDirection);
    }

    /**
     * This will be called by {@link android.view.View#requestLayout()}. Left and Right margins
     * may be overridden depending on layout direction.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:00.930 -0400", hash_original_method = "9C595E4D1E4EE85166F87E4910922C1D", hash_generated_method = "B0B91F9EF3F92DB54D8CA9F775C28160")
        
public static void resolveLayoutDirection(ViewGroup.MarginLayoutParams lp,
            int layoutDirection) {
        IMPL.resolveLayoutDirection(lp, layoutDirection);
    }
}
