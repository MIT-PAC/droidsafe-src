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

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

class ContextCompatJellybean {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:02:00.384 -0400", hash_original_method = "F6FCC0565F4A19B5E5C9443658BA910F", hash_generated_method = "54787197071EEB2F1794447E9C5AC238")
    
public static void startActivities(Context context, Intent[] intents, Bundle options) {
    	intents[0].addTaint(options.getTaint());
        context.startActivities(intents);
    }

}
