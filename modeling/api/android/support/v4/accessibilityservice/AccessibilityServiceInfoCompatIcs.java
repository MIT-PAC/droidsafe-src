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

package android.support.v4.accessibilityservice;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.ResolveInfo;

/**
 * ICS implementation of the new APIs in AccessibilityServiceInfo.
 */
class AccessibilityServiceInfoCompatIcs {

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:55.899 -0500", hash_original_method = "FAFDC6EB95D6E735940062458ED33905", hash_generated_method = "4C20F4398E828C1671DD03075411DC20")
    
public static boolean getCanRetrieveWindowContent(AccessibilityServiceInfo info) {
        return info.getCanRetrieveWindowContent();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:55.902 -0500", hash_original_method = "C8AFAC0875FF06301C7CBA267F50EF31", hash_generated_method = "4582D1DEC75F89494D23CAEC0F31FE41")
    
public static String getDescription(AccessibilityServiceInfo info) {
        return info.getDescription();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:55.905 -0500", hash_original_method = "E3BB7616A31CF09066E16B5124CBD174", hash_generated_method = "9EA3787D902A167BDD82A55CC0E42368")
    
public static String getId(AccessibilityServiceInfo info) {
        return info.getId();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:55.910 -0500", hash_original_method = "204974EDB09C16C41A490D169687356B", hash_generated_method = "A540F8EBEB1CDEFADA11C122E2FDFEED")
    
public static ResolveInfo getResolveInfo(AccessibilityServiceInfo info) {
        return info.getResolveInfo();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:55.917 -0500", hash_original_method = "24335661110E67CDE38A123074BB61B9", hash_generated_method = "72CE782819C915AAF5E31DE06F871CA1")
    
public static String getSettingsActivityName(AccessibilityServiceInfo info) {
        return info.getSettingsActivityName();
    }
}
