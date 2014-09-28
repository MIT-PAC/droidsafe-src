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

package android.support.v4.content;

import java.io.File;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.content.Intent;

/**
 * Implementation of context compatibility that can call Honeycomb APIs.
 */
class ContextCompatHoneycomb {

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSSpec(DSCat.SPEC_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:33.068 -0500", hash_original_method = "629B555D256106BD45BE0BBC53CBB391", hash_generated_method = "5E3FAE56E2C6DF50D8907A1F0ED80712")
    
static void startActivities(Context context, Intent[] intents) {
        context.startActivities(intents);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:02:00.357 -0400", hash_original_method = "1E32EC37BEBA248EE7951C1566149DD4", hash_generated_method = "9028D49E0C10FE4880B2CB55FA201E53")
    
public static File getObbDir(Context context) {
        return context.getObbDir();
    }}
