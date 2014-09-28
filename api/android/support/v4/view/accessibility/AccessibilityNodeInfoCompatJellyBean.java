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
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

/**
 * JellyBean specific AccessibilityNodeInfo API implementation.
 */
class AccessibilityNodeInfoCompatJellyBean {

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:09.433 -0400", hash_original_method = "AE7A52F10E2057CAF9838AD96E1F8667", hash_generated_method = "6C88248F4D0ABA3578C6DDD7B71FC554")
    
public static void addChild(Object info, View child, int virtualDescendantId) {
        ((AccessibilityNodeInfo) info).addChild(child);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:09.436 -0400", hash_original_method = "B5F530E74BDD824E0D04ADF91CF58AEA", hash_generated_method = "318B4C72D835538A498AE4FF8B1909B9")
    
public static void setSource(Object info, View root, int virtualDescendantId) {
        ((AccessibilityNodeInfo) info).setSource(root);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:09.439 -0400", hash_original_method = "656D4F3CE1F0106BF08ECF9D5E5F8E49", hash_generated_method = "696B44EAC6EF213873214F6A9739F735")
    
public static boolean isVisibleToUser(Object info) {
        return ((AccessibilityNodeInfo) info).isVisibleToUser();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:09.442 -0400", hash_original_method = "E9DB67098AB234DB025B5D1CBCB61300", hash_generated_method = "75D12FA0EFC5EF53D116A59E1B423D12")
    
public static void setVisibleToUser(Object info, boolean visibleToUser) {
        ((AccessibilityNodeInfo) info).setVisibleToUser(visibleToUser);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:09.444 -0400", hash_original_method = "ABB713D379FB5200D32D1893428FA1E7", hash_generated_method = "5411B05F215FE0F63E1199F007DEEE2D")
    
public static boolean performAction(Object info, int action, Bundle arguments) {
        return ((AccessibilityNodeInfo) info).performAction(action);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:09.447 -0400", hash_original_method = "15CD543F4BD95D1B2E47B97515F09CDD", hash_generated_method = "2ABD75DA384E1BF8914EAE7C54E2F0F0")
    
public static void setMovementGranularities(Object info, int granularities) {
        ((AccessibilityNodeInfo) info).setMovementGranularities(granularities);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:09.450 -0400", hash_original_method = "A4465BFF551CF1A7E1D394FA0547FD4C", hash_generated_method = "E8C745794E0CC0B97D7AE46605F499FD")
    
public static int getMovementGranularities(Object info) {
        return ((AccessibilityNodeInfo) info).getMovementGranularities();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:09.453 -0400", hash_original_method = "CB7FCDD77485C9FC9A893A9E82F3604F", hash_generated_method = "5762E9E1772D653BBD1F8FB923DA74FF")
    
public static Object obtain(View root, int virtualDescendantId) {
        return AccessibilityNodeInfo.obtain(root);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:09.456 -0400", hash_original_method = "212D7076F166AAE91DA66D82B6B83F82", hash_generated_method = "D120E83B4E8564CF7DFCCD4D325CCDA7")
    
public static Object findFocus(Object info, int focus) {
        return ((AccessibilityNodeInfo) info).findFocus(focus);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:09.459 -0400", hash_original_method = "A39CFE16DAB56E17A57FDB0A17D61094", hash_generated_method = "947BFF0999D3DB93D5468683ABB19BBA")
    
public static Object focusSearch(Object info, int direction) {
        return ((AccessibilityNodeInfo) info).focusSearch(direction);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:09.463 -0400", hash_original_method = "A4DC525FE988126FA30BB33C08B5FABA", hash_generated_method = "D240C1E92744EC47E5597FF5C90B1D11")
    
public static void setParent(Object info, View root, int virtualDescendantId) {
        ((AccessibilityNodeInfo) info).setParent(root);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:09.465 -0400", hash_original_method = "0798236D6089CCF84F39DB23C4B6EF33", hash_generated_method = "D4A24D7D3DD5477CD39D24FE27A41EC1")
    
public static boolean isAccessibilityFocused(Object info) {
        return ((AccessibilityNodeInfo) info).isAccessibilityFocused();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:09.468 -0400", hash_original_method = "D2D41188FA0010F0A699D006E51BA117", hash_generated_method = "2BC36BC0B11D7411F1F35CAB345DF14A")
    
public static void setAccesibilityFocused(Object info, boolean focused) {
        ((AccessibilityNodeInfo) info).setAccessibilityFocused(focused);
    }
}
