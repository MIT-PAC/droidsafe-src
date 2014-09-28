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

package android.support.v4.graphics.drawable;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.graphics.drawable.Drawable;

/**
 * Helper for accessing features in {@link android.graphics.drawable.Drawable}
 * introduced after API level 4 in a backwards compatible fashion.
 */
public class DrawableCompat {
    /**
     * Interface for the full API.
     */
    interface DrawableImpl {
        void jumpToCurrentState(Drawable drawable);
        void setAutoMirrored(Drawable drawable, boolean mirrored);
        boolean isAutoMirrored(Drawable drawable);
    }

    /**
     * Interface implementation that doesn't use anything about v4 APIs.
     */
    static class BaseDrawableImpl implements DrawableImpl {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void jumpToCurrentState(Drawable drawable) {
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setAutoMirrored(Drawable drawable, boolean mirrored) {
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isAutoMirrored(Drawable drawable) {
            return false;
        }
    }

    /**
     * Interface implementation for devices with at least v11 APIs.
     */
    static class HoneycombDrawableImpl extends BaseDrawableImpl {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void jumpToCurrentState(Drawable drawable) {
            DrawableCompatHoneycomb.jumpToCurrentState(drawable);
        }
    }

    /**
     * Interface implementation for devices with at least v11 APIs.
     */
    static class KitKatDrawableImpl extends HoneycombDrawableImpl {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setAutoMirrored(Drawable drawable, boolean mirrored) {
            DrawableCompatKitKat.setAutoMirrored(drawable, mirrored);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isAutoMirrored(Drawable drawable) {
            return DrawableCompatKitKat.isAutoMirrored(drawable);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:57.007 -0400", hash_original_field = "359D8C7F61A74E79F84F19A19A642108", hash_generated_field = "14CFF56770217B4A682C56E251F47379")

    static  DrawableImpl IMPL;
    static {
        final int version = android.os.Build.VERSION.SDK_INT;
        if (version >= 19) {
            IMPL = new KitKatDrawableImpl();
        } else if (version >= 11) {
            IMPL = new HoneycombDrawableImpl();
        } else {
            IMPL = new BaseDrawableImpl();
        }
    }

    /**
     * Call {@link Drawable#jumpToCurrentState() Drawable.jumpToCurrentState()}.
     * <p>
     * If running on a pre-{@link android.os.Build.VERSION_CODES#HONEYCOMB}
     * device this method does nothing.
     *
     * @param drawable The Drawable against which to invoke the method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:57.027 -0400", hash_original_method = "E69EFF22B87AFFA352036D414C55623D", hash_generated_method = "3EC9DF68B71BAF1BDB508CDFDFE5684D")
        
public static void jumpToCurrentState(Drawable drawable) {
        IMPL.jumpToCurrentState(drawable);
    }

    /**
     * Set whether this Drawable is automatically mirrored when its layout
     * direction is RTL (right-to left). See
     * {@link android.util.LayoutDirection}.
     * <p>
     * If running on a pre-{@link android.os.Build.VERSION_CODES#KITKAT} device
     * this method does nothing.
     *
     * @param drawable The Drawable against which to invoke the method.
     * @param mirrored Set to true if the Drawable should be mirrored, false if
     *            not.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:57.042 -0400", hash_original_method = "BA5D0A0688EC5EC72583904FE94086D4", hash_generated_method = "3F67E439DFF352E0E751A4C8CDA36200")
        
public static void setAutoMirrored(Drawable drawable, boolean mirrored) {
        IMPL.setAutoMirrored(drawable, mirrored);
    }

    /**
     * Tells if this Drawable will be automatically mirrored when its layout
     * direction is RTL right-to-left. See {@link android.util.LayoutDirection}.
     * <p>
     * If running on a pre-{@link android.os.Build.VERSION_CODES#KITKAT} device
     * this method returns false.
     *
     * @param drawable The Drawable against which to invoke the method.
     * @return boolean Returns true if this Drawable will be automatically
     *         mirrored.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:57.051 -0400", hash_original_method = "62271D2BB189BE6E4919DFFA0CB435A1", hash_generated_method = "ED5D95CB7C82CBED126EDB8449A0DF98")
        
public static boolean isAutoMirrored(Drawable drawable) {
        return IMPL.isAutoMirrored(drawable);
    }
}
