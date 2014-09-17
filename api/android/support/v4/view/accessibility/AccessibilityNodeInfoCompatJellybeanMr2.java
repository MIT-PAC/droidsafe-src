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

package android.support.v4.view.accessibility;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.view.accessibility.AccessibilityNodeInfo;

class AccessibilityNodeInfoCompatJellybeanMr2 {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:09.506 -0400", hash_original_method = "1A4B91EF1799AB9B656A4901B02E809F", hash_generated_method = "3491E82ECAA0A1331869E7D1202B8DDA")
    
public static void setViewIdResourceName(Object info, String viewId) {
        ((AccessibilityNodeInfo) info).setViewIdResourceName(viewId);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:09.509 -0400", hash_original_method = "8BC72748D492E60677B6F2591E0D8C46", hash_generated_method = "8B1A820B580E6365A7E508AB3D98C90D")
    
public static String getViewIdResourceName(Object info) {
        return ((AccessibilityNodeInfo) info).getViewIdResourceName();
    }
}
