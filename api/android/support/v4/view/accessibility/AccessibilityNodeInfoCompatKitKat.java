/*
 * Copyright (C) 2012 The Android Open Source Project
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

/**
 * KitKat-specific AccessibilityNodeInfo API implementation.
 */
class AccessibilityNodeInfoCompatKitKat {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:09.522 -0400", hash_original_method = "79AD14635A7684796DFE37760ACA73DE", hash_generated_method = "716C190E5F0B85C519B104A67999B386")
    
public static int getLiveRegion(Object info) {
        return ((AccessibilityNodeInfo) info).getLiveRegion();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:09.525 -0400", hash_original_method = "94E53B40182320E9977C79884270800E", hash_generated_method = "E7239FC6480D725DD13DD0612C39F584")
    
public static void setLiveRegion(Object info, int mode) {
        ((AccessibilityNodeInfo) info).setLiveRegion(mode);
    }
}
