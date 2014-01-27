/*
 * Copyright (C) 2011 The Android Open Source Project
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
import android.accessibilityservice.AccessibilityServiceInfo;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;

import java.util.List;

/**
 * ICS specific AccessibilityManager API implementation.
 */
class AccessibilityManagerCompatIcs {

    interface AccessibilityStateChangeListenerBridge {
        public void onAccessibilityStateChanged(boolean enabled);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:22.651 -0500", hash_original_method = "D814172201D5C80052D384F94332BA64", hash_generated_method = "FD99394DDA75F97805C31A4FEB55FB17")
    
public static Object newAccessibilityStateChangeListener(
            final AccessibilityStateChangeListenerBridge bridge) {
        return new AccessibilityStateChangeListener() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:55:36.516 -0500", hash_original_method = "7DFC139A1BBFB5E151103C0F641F46AE", hash_generated_method = "3AF7962F14925508AC38B678C2D3D546")
            
@Override
            public void onAccessibilityStateChanged(boolean enabled) {
                bridge.onAccessibilityStateChanged(enabled);
            }
        };
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:22.655 -0500", hash_original_method = "1E42FA2CBDAA6CDE42F15096AC3B4DBB", hash_generated_method = "5DA5D6C6C15773B16E4846A142225FD6")
    
public static boolean addAccessibilityStateChangeListener(AccessibilityManager manager,
            Object listener) {
        return manager.addAccessibilityStateChangeListener(
                (AccessibilityStateChangeListener)listener);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:22.658 -0500", hash_original_method = "F82F3FDA3C6CBAA10DED373E5F9E56D8", hash_generated_method = "D94AAB7D7B4982D6AFDEB2025EC1E6BE")
    
public static boolean removeAccessibilityStateChangeListener(AccessibilityManager manager,
            Object listener) {
        return manager.removeAccessibilityStateChangeListener(
                (AccessibilityStateChangeListener)listener);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:22.660 -0500", hash_original_method = "477E162F4F6EED2A7669011E019D996E", hash_generated_method = "3EC9971B22CA07AFB531D4C523E3CFB5")
    
public static List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(
            AccessibilityManager manager,int feedbackTypeFlags) {
        return manager.getEnabledAccessibilityServiceList(feedbackTypeFlags);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:22.662 -0500", hash_original_method = "CAACCEBD4D7BC4BFEA09FE18704B5690", hash_generated_method = "47A94CBCD092F051AC69866B44166806")
    
public static List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(
            AccessibilityManager manager) {
        return manager.getInstalledAccessibilityServiceList();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:22.664 -0500", hash_original_method = "663E0375223E08E43F5C642EE0FE51A9", hash_generated_method = "B66FFCF2B86663B6BF16D2EE43982FC4")
    
public static boolean isTouchExplorationEnabled(AccessibilityManager manager) {
        return manager.isTouchExplorationEnabled();
    }
}
