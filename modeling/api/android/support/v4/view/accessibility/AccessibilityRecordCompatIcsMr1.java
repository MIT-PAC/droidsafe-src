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
import android.view.accessibility.AccessibilityRecord;

/**
 * ICS MR1 specific AccessibilityRecord API implementation.
 */
class AccessibilityRecordCompatIcsMr1 {

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:21.843 -0500", hash_original_method = "5F18D21FBC85556E36D058A8F6406A88", hash_generated_method = "70E2F76D4DB3EA0BED8FD976A26A3A0C")
    
public static int getMaxScrollX(Object record) {
        return ((AccessibilityRecord) record).getMaxScrollX();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:21.844 -0500", hash_original_method = "435D9B79CBD1BB93AAC045ABE9B84680", hash_generated_method = "5196EB419F2F7DCCF5028CBD09D456F6")
    
public static int getMaxScrollY(Object record) {
        return ((AccessibilityRecord) record).getMaxScrollY();
    }
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:21.846 -0500", hash_original_method = "83AC57D581C731AEB167D9996775E4BC", hash_generated_method = "B481F2128282A0924D765E8315751C99")
    
public static void setMaxScrollX(Object record, int maxScrollX) {
        ((AccessibilityRecord) record).setMaxScrollX(maxScrollX);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:21.849 -0500", hash_original_method = "CBEF973D8F234832A5DF3CE7523844B3", hash_generated_method = "544F23472DC81A998132A44940067160")
    
public static void setMaxScrollY(Object record, int maxScrollY) {
        ((AccessibilityRecord) record).setMaxScrollY(maxScrollY);
    }
}
