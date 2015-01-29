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
import android.view.ViewGroup;

class MarginLayoutParamsCompatJellybeanMr1 {
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.052 -0400", hash_original_method = "609F5BCC61CE11177AFDDF9BEF03E773", hash_generated_method = "A37AA809B9A2D56411D00FBE2E46216B")
    
public static int getMarginStart(ViewGroup.MarginLayoutParams lp) {
        return lp.getMarginStart();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.056 -0400", hash_original_method = "97D84A9DD2BCC67B826D7F5729A82568", hash_generated_method = "F6C07ECE1090843AB21A8D21A234C7BC")
    
public static int getMarginEnd(ViewGroup.MarginLayoutParams lp) {
        return lp.getMarginEnd();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.061 -0400", hash_original_method = "E336ABE09863B8F750493E912E449BCE", hash_generated_method = "5831FB851BC2352FF76A7D35FADD28BC")
    
public static void setMarginStart(ViewGroup.MarginLayoutParams lp, int marginStart) {
        lp.setMarginStart(marginStart);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.066 -0400", hash_original_method = "FEBCE49130A71B4D5F16D8CD3B8E2401", hash_generated_method = "4C4BDF04133CEE1DB9FFB124616723CF")
    
public static void setMarginEnd(ViewGroup.MarginLayoutParams lp, int marginEnd) {
        lp.setMarginEnd(marginEnd);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.070 -0400", hash_original_method = "3104A10767F806733B37F1E31C447833", hash_generated_method = "D001067C92CC3009D202CB7AE1F2E969")
    
public static boolean isMarginRelative(ViewGroup.MarginLayoutParams lp) {
        return lp.isMarginRelative();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.074 -0400", hash_original_method = "D2588C83FFD3A43E59223C33A981814F", hash_generated_method = "1C1661EA8638B6AB4C619EA2F233ECCE")
    
public static int getLayoutDirection(ViewGroup.MarginLayoutParams lp) {
        return lp.getLayoutDirection();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.079 -0400", hash_original_method = "A808E95F8FD12B30844D9CC5311CAFBC", hash_generated_method = "ED3B21C30D52B4110F645857D7F6138F")
    
public static void setLayoutDirection(ViewGroup.MarginLayoutParams lp, int layoutDirection) {
        lp.setLayoutDirection(layoutDirection);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.083 -0400", hash_original_method = "4633B19ACD2A9F1CD1FA1E99CB3ABD97", hash_generated_method = "4053574B52B7ECA6800AF12F9777DBCF")
    
public static void resolveLayoutDirection(ViewGroup.MarginLayoutParams lp,
            int layoutDirection) {
        lp.resolveLayoutDirection(layoutDirection);
    }
}
