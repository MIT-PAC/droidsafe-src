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
import android.view.Gravity;

class GravityCompatJellybeanMr1 {

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:00.295 -0400", hash_original_method = "77A87285F359A52F08330AD80A5D1C91", hash_generated_method = "38AA03C6E03A4704B6F952AF30C1AB56")
    
public static int getAbsoluteGravity(int gravity, int layoutDirection) {
        return Gravity.getAbsoluteGravity(gravity, layoutDirection);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:00.300 -0400", hash_original_method = "5DDCBF6898E521B25861AFE4267C2596", hash_generated_method = "8824305B741A12EF390BE97A7194C49D")
    
public static void apply(int gravity, int w, int h, Rect container, Rect outRect,
            int layoutDirection) {
        Gravity.apply(gravity, w, h, container, outRect, layoutDirection);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:00.307 -0400", hash_original_method = "6A861C91D58E30F74EB627E1C82A34AC", hash_generated_method = "B444151227B7E8154E1B46D1AFE5147E")
    
public static void apply(int gravity, int w, int h, Rect container, int xAdj, int yAdj,
            Rect outRect, int layoutDirection) {
        Gravity.apply(gravity, w, h, container, xAdj, yAdj, outRect);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:00.312 -0400", hash_original_method = "10CDEA1D9DA95FA94176554FB1F66D46", hash_generated_method = "80087F3F9C468CBB2804103B04D81E18")
    
public static void applyDisplay(int gravity, Rect display, Rect inoutObj, int layoutDirection) {
        Gravity.applyDisplay(gravity, display, inoutObj);
    }
}
