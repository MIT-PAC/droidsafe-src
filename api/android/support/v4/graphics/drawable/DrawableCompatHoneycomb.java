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
 * Implementation of drawable compatibility that can call Honeycomb APIs.
 */
class DrawableCompatHoneycomb {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:57.314 -0400", hash_original_method = "F744FB0B371A76C5A0DB23B608108605", hash_generated_method = "E3379BB730DE073C3C8D12BA63B85753")
    
public static void jumpToCurrentState(Drawable drawable) {
        drawable.jumpToCurrentState();
    }
}
