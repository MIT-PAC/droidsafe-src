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
import android.view.ScaleGestureDetector;
import android.view.MotionEvent;
import android.content.Context;

/**
 * Implementation of ScaleGestureDetector compatibility that can call KitKat APIs. This class is an
 * implementation detail for ScaleGestureDetectorCompat and should not be used directly.
 */
class ScaleGestureDetectorCompatKitKat {

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.915 -0400", hash_original_method = "B3AD45B89F0B07380E5685C537D31C64", hash_generated_method = "021EF3DBF51FED0E94B65B05BD0246B1")
    
public static void setQuickScaleEnabled(Object scaleGestureDetector, boolean enabled) {
        ((ScaleGestureDetector) scaleGestureDetector).setQuickScaleEnabled(enabled);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.919 -0400", hash_original_method = "CFAC6CBB2FDB7DF67963B9CDE14F0E99", hash_generated_method = "98AE5444D9A200793BEA4ED6C692241D")
    
public static boolean isQuickScaleEnabled(Object scaleGestureDetector) {
        return ((ScaleGestureDetector) scaleGestureDetector).isQuickScaleEnabled();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.911 -0400", hash_original_method = "C67ACAD63350D2376A4F0279F135E6C8", hash_generated_method = "6C3FDFD46A765B8ED84AEEEDC0D01F16")
    
private ScaleGestureDetectorCompatKitKat() {
    }
}
