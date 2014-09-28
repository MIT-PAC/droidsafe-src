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
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;

/**
 * ICS specific AccessibilityEvent API implementation.
 */
class AccessibilityEventCompatIcs {

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:26.206 -0500", hash_original_method = "734AB2E40956FCBD0EB2BC35639EB37D", hash_generated_method = "B76C5AFC70CE948B4F7531949C972F45")
    
public static int getRecordCount(AccessibilityEvent event) {
        return event.getRecordCount();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:26.207 -0500", hash_original_method = "A93BFBF408BB0A53396D00D04FBC85AB", hash_generated_method = "68368AFA2A2E07C99E468E0B015B3830")
    
public static void appendRecord(AccessibilityEvent event, Object record) {
        event.appendRecord((AccessibilityRecord) record);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:26.208 -0500", hash_original_method = "AEFA1D9BC3943F705C8EF9ED91D496C4", hash_generated_method = "DC73AE4C02E7F7A4AD409A3EBB2EEF26")
    
public static Object getRecord(AccessibilityEvent event, int index) {
        return event.getRecord(index);
    }
}
