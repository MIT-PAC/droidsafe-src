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
 * Implementation of drawable compatibility that can call KitKat APIs.
 */
class DrawableCompatKitKat {
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:57.378 -0400", hash_original_method = "E205005DC380054AB24338FFDCEBE7D6", hash_generated_method = "65F8009068D642425535F4F0C7658819")
    
public static void setAutoMirrored(Drawable drawable, boolean mirrored) {
        drawable.setAutoMirrored(mirrored);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:57.387 -0400", hash_original_method = "9999C5BE66159918E57304A5E62272CA", hash_generated_method = "3FCC490ADEB72633A5C186B8F7BCC634")
    
public static boolean isAutoMirrored(Drawable drawable) {
        return drawable.isAutoMirrored();
    }
}
