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

package android.support.v4.app;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

class TaskStackBuilderJellybean {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:08.325 -0400", hash_original_method = "255A62452327ABCB9177B6E227777225", hash_generated_method = "EB56AB1048947AC4AC8FD023E4A29817")
    
public static PendingIntent getActivitiesPendingIntent(Context context, int requestCode,
            Intent[] intents, int flags, Bundle options) {
        return PendingIntent.getActivities(context, requestCode, intents, (flags + options.getTaintInt()));
    }

}
