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

package android.support.v4.content;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;

import java.io.File;

class ContextCompatKitKat {
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:02:00.411 -0400", hash_original_method = "F5E4AB09821CBA6993C7EF241D02012D", hash_generated_method = "5D1C2C5738058966F44E2C563563501C")
    
public static File[] getExternalCacheDirs(Context context) {
        return context.getExternalCacheDirs();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:02:00.417 -0400", hash_original_method = "7D458881F32F02270D1563CBA0D743AC", hash_generated_method = "1B64C186F7EE2BEA2B59C7BD2B559DD0")
    
public static File[] getExternalFilesDirs(Context context, String type) {
        return context.getExternalFilesDirs(type);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:02:00.423 -0400", hash_original_method = "0C42EC6EF36494141C341D6BF3DFBBEF", hash_generated_method = "342A9EDFA5569CBF78B75880232A1107")
    
public static File[] getObbDirs(Context context) {
        return context.getObbDirs();
    }
}
