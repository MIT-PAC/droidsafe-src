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

package android.support.v4.hardware.display;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.view.Display;

final class DisplayManagerJellybeanMr1 {
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:58.213 -0400", hash_original_method = "22DAF5E6C8E031F52C4B0909D3A94856", hash_generated_method = "BCB8751A2E2DA448D4A7A8C7A08AC417")
    
public static Object getDisplayManager(Context context) {
        return context.getSystemService(Context.DISPLAY_SERVICE);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:58.220 -0400", hash_original_method = "DD108FB5048788429B2EA5E7A6C4A7E9", hash_generated_method = "B664D6F1F7EAEE8193BBA7E7D874AEB2")
    
public static Display getDisplay(Object displayManagerObj, int displayId) {
        return ((android.hardware.display.DisplayManager)displayManagerObj).getDisplay(displayId);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:58.229 -0400", hash_original_method = "A96130BE86AC802BAF5ACC14F7B3CC72", hash_generated_method = "940ED178DFFB0646836583DF731FB885")
    
public static Display[] getDisplays(Object displayManagerObj) {
        return ((android.hardware.display.DisplayManager)displayManagerObj).getDisplays();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:58.236 -0400", hash_original_method = "CCA44916734F1B1FCB5E8863EEBF6186", hash_generated_method = "6D5B0F6CC95AFB1B0B6F866886D5C50B")
    
public static Display[] getDisplays(Object displayManagerObj, String category) {
        return ((android.hardware.display.DisplayManager)displayManagerObj).getDisplays(category);
    }
}
