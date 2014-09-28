/*
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

package android.support.v4.view;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.graphics.Rect;
import android.os.Build;
import android.view.Gravity;

/**
 * Compatibility shim for accessing newer functionality from {@link android.view.Gravity}.
 */
public class GravityCompat {
    interface GravityCompatImpl {
        int getAbsoluteGravity(int gravity, int layoutDirection);
        void apply(int gravity, int w, int h, Rect container, Rect outRect, int layoutDirection);
        void apply(int gravity, int w, int h, Rect container, int xAdj, int yAdj,
                Rect outRect, int layoutDirection);
        void applyDisplay(int gravity, Rect display, Rect inoutObj, int layoutDirection);
    }

    static class GravityCompatImplBase implements GravityCompatImpl {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getAbsoluteGravity(int gravity, int layoutDirection) {
            // Just strip off the relative bit to get LEFT/RIGHT.
            return gravity & ~RELATIVE_LAYOUT_DIRECTION;
        }

        @Override
        public void apply(int gravity, int w, int h, Rect container, Rect outRect,
                int layoutDirection) {
            Gravity.apply(gravity, w, h, container, outRect);
        }

        @Override
        public void apply(int gravity, int w, int h, Rect container, int xAdj, int yAdj,
                Rect outRect, int layoutDirection) {
            Gravity.apply(gravity, w, h, container, xAdj, yAdj, outRect);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void applyDisplay(int gravity, Rect display, Rect inoutObj,
                int layoutDirection) {
            Gravity.applyDisplay(gravity, display, inoutObj);
        }
    }

    static class GravityCompatImplJellybeanMr1 implements GravityCompatImpl {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getAbsoluteGravity(int gravity, int layoutDirection) {
            return GravityCompatJellybeanMr1.getAbsoluteGravity(gravity, layoutDirection);
        }

        @Override
        public void apply(int gravity, int w, int h, Rect container, Rect outRect,
                int layoutDirection) {
            GravityCompatJellybeanMr1.apply(gravity, w, h, container, outRect, layoutDirection);
        }

        @Override
        public void apply(int gravity, int w, int h, Rect container, int xAdj, int yAdj,
                Rect outRect, int layoutDirection) {
            GravityCompatJellybeanMr1.apply(gravity, w, h, container, xAdj, yAdj, outRect,
                    layoutDirection);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void applyDisplay(int gravity, Rect display, Rect inoutObj, int layoutDirection) {
            GravityCompatJellybeanMr1.applyDisplay(gravity, display, inoutObj, layoutDirection);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:00.162 -0400", hash_original_field = "6FB04C8EF0021B9B20BBE605F60E55DE", hash_generated_field = "2A28AAC9A7DFC53CC9D75BB43432ECD5")

    static  GravityCompatImpl IMPL;
    static {
        final int version = Build.VERSION.SDK_INT;
        if (version >= 17) {
            IMPL = new GravityCompatImplJellybeanMr1();
        } else {
            IMPL = new GravityCompatImplBase();
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:00.168 -0400", hash_original_field = "C578C91BD8760FF8962DE1CEBE458715", hash_generated_field = "244F6F66FA77B1BA261012A1DB3B883F")

    public static final int RELATIVE_LAYOUT_DIRECTION = 0x00800000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:00.173 -0400", hash_original_field = "D3B39705ADFA5EF516628D1645BF019E", hash_generated_field = "FAB1C14C8268ABB9704FC7F6F91C9284")

    public static final int START = RELATIVE_LAYOUT_DIRECTION | Gravity.LEFT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:00.178 -0400", hash_original_field = "3D9B5033A8174C91D850471C4F800352", hash_generated_field = "E6E36D0CB94F79BA47ECA6069F6B4C0B")

    public static final int END = RELATIVE_LAYOUT_DIRECTION | Gravity.RIGHT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:00.182 -0400", hash_original_field = "2BE0CDDC90FBE4CA1BB317ED9C6D3BB3", hash_generated_field = "8FE6AB1D802BBC04FC5F75B277F16533")

    public static final int RELATIVE_HORIZONTAL_GRAVITY_MASK = START | END;

    /**
     * Apply a gravity constant to an object and take care if layout direction is RTL or not.
     *
     * @param gravity The desired placement of the object, as defined by the
     *                constants in this class.
     * @param w The horizontal size of the object.
     * @param h The vertical size of the object.
     * @param container The frame of the containing space, in which the object
     *                  will be placed.  Should be large enough to contain the
     *                  width and height of the object.
     * @param outRect Receives the computed frame of the object in its
     *                container.
     * @param layoutDirection The layout direction.
     *
     * @see ViewCompat#LAYOUT_DIRECTION_LTR
     * @see ViewCompat#LAYOUT_DIRECTION_RTL
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:00.187 -0400", hash_original_method = "4E3232C38120B900B0BC0F06B3D6F5CE", hash_generated_method = "540651ED0FB771E3D6E78BC2F4924A11")
        
public static void apply(int gravity, int w, int h, Rect container,
            Rect outRect, int layoutDirection) {
        IMPL.apply(gravity, w, h, container, outRect, layoutDirection);
    }

    /**
     * Apply a gravity constant to an object.
     *
     * @param gravity The desired placement of the object, as defined by the
     *                constants in this class.
     * @param w The horizontal size of the object.
     * @param h The vertical size of the object.
     * @param container The frame of the containing space, in which the object
     *                  will be placed.  Should be large enough to contain the
     *                  width and height of the object.
     * @param xAdj Offset to apply to the X axis.  If gravity is LEFT this
     *             pushes it to the right; if gravity is RIGHT it pushes it to
     *             the left; if gravity is CENTER_HORIZONTAL it pushes it to the
     *             right or left; otherwise it is ignored.
     * @param yAdj Offset to apply to the Y axis.  If gravity is TOP this pushes
     *             it down; if gravity is BOTTOM it pushes it up; if gravity is
     *             CENTER_VERTICAL it pushes it down or up; otherwise it is
     *             ignored.
     * @param outRect Receives the computed frame of the object in its
     *                container.
     * @param layoutDirection The layout direction.
     *
     * @see ViewCompat#LAYOUT_DIRECTION_LTR
     * @see ViewCompat#LAYOUT_DIRECTION_RTL
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:00.194 -0400", hash_original_method = "503FC42373991D1417FDE765658B6B7F", hash_generated_method = "61D7EED24598563D0394D7537B24FB20")
        
public static void apply(int gravity, int w, int h, Rect container,
            int xAdj, int yAdj, Rect outRect, int layoutDirection) {
        IMPL.apply(gravity, w, h, container, xAdj, yAdj, outRect, layoutDirection);
    }

    /**
     * Apply additional gravity behavior based on the overall "display" that an
     * object exists in.  This can be used after
     * {@link android.view.Gravity#apply(int, int, int, Rect, int, int, Rect)} to place the object
     * within a visible display.  By default this moves or clips the object
     * to be visible in the display; the gravity flags
     * {@link android.view.Gravity#DISPLAY_CLIP_HORIZONTAL} and
     * {@link android.view.Gravity#DISPLAY_CLIP_VERTICAL} can be used to change this behavior.
     *
     * @param gravity Gravity constants to modify the placement within the
     * display.
     * @param display The rectangle of the display in which the object is
     * being placed.
     * @param inoutObj Supplies the current object position; returns with it
     * modified if needed to fit in the display.
     * @param layoutDirection The layout direction.
     *
     * @see ViewCompat#LAYOUT_DIRECTION_LTR
     * @see ViewCompat#LAYOUT_DIRECTION_RTL
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:00.198 -0400", hash_original_method = "EDE73960F86A0A9570579107542E54CF", hash_generated_method = "17AF9D027497E23E45F588BC087BFFAB")
        
public static void applyDisplay(int gravity, Rect display, Rect inoutObj, int layoutDirection) {
        IMPL.applyDisplay(gravity, display, inoutObj, layoutDirection);
    }

    /**
     * <p>Convert script specific gravity to absolute horizontal value.</p>
     *
     * if horizontal direction is LTR, then START will set LEFT and END will set RIGHT.
     * if horizontal direction is RTL, then START will set RIGHT and END will set LEFT.
     *
     *
     * @param gravity The gravity to convert to absolute (horizontal) values.
     * @param layoutDirection The layout direction.
     * @return gravity converted to absolute (horizontal) values.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:00.203 -0400", hash_original_method = "DF2E98D464BC3D298CD3C59AC14EEDAC", hash_generated_method = "6A552C14A36A4D4FCFD44E2C56891794")
        
public static int getAbsoluteGravity(int gravity, int layoutDirection) {
        return IMPL.getAbsoluteGravity(gravity, layoutDirection);
    }
}
