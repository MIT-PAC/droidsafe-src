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

/**
 * Helper for accessing features in <code>ScaleGestureDetector</code> introduced
 * after API level 19 (KitKat) in a backwards compatible fashion.
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class ScaleGestureDetectorCompat {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.829 -0400", hash_original_field = "9939C0CCE1BE6BA7CB7B7FE64719421B", hash_generated_field = "B3D560514A01F5878BA95AD7EF689CAD")

    static  ScaleGestureDetectorImpl IMPL;

    interface ScaleGestureDetectorImpl {

        public void setQuickScaleEnabled(Object o, boolean enabled);

        public boolean isQuickScaleEnabled(Object o);
    }

    private static class BaseScaleGestureDetectorImpl implements ScaleGestureDetectorImpl {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setQuickScaleEnabled(Object o, boolean enabled) {
            // Intentionally blank
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isQuickScaleEnabled(Object o) {
            return false;
        }
    }

    private static class ScaleGestureDetectorCompatKitKatImpl implements ScaleGestureDetectorImpl {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setQuickScaleEnabled(Object o, boolean enabled) {
            ScaleGestureDetectorCompatKitKat.setQuickScaleEnabled(o, enabled);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isQuickScaleEnabled(Object o) {
            return ScaleGestureDetectorCompatKitKat.isQuickScaleEnabled(o);
        }
    }

    static {
        final int version = android.os.Build.VERSION.SDK_INT;
        if (version >= 19) { // KitKat
            IMPL = new ScaleGestureDetectorCompatKitKatImpl();
        } else {
            IMPL = new BaseScaleGestureDetectorImpl();
        }
    }

    /**
     * Set whether the associated <code>OnScaleGestureListener</code> should receive onScale
     * callbacks when the user performs a doubleTap followed by a swipe. Note that this is enabled
     * by default if the app targets API 19 and newer.
     * @param enabled true to enable quick scaling, false to disable
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.864 -0400", hash_original_method = "45FD127C9B1D9E088FAA8E4BFD82CEC1", hash_generated_method = "FC3608A23A622A68631A0A649EC47D4B")
        
public static void setQuickScaleEnabled(Object scaleGestureDetector, boolean enabled) {
        IMPL.setQuickScaleEnabled(scaleGestureDetector, enabled);
    }

    /**
     * Return whether the quick scale gesture, in which the user performs a double tap followed by a
     * swipe, should perform scaling. See <code>setQuickScaleEnabled(Object, boolean)<code>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.867 -0400", hash_original_method = "9A1EBA8D9F34D0582B69D7C6A35DD21F", hash_generated_method = "83C28EBCFF684D6692A0E287789BA901")
        
public static boolean isQuickScaleEnabled(Object scaleGestureDetector) {
        return IMPL.isQuickScaleEnabled(scaleGestureDetector); // KitKat
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.860 -0400", hash_original_method = "891A0F4CB4BF3A0ADE7467E5C3CBEA9F", hash_generated_method = "8A86312FEEB5473F868887C54D8596D6")
        
private ScaleGestureDetectorCompat() {}
}
