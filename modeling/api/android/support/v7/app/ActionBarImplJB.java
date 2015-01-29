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
package android.support.v7.app;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.app.Activity;

public class ActionBarImplJB extends ActionBarImplICS {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.302 -0400", hash_original_method = "DE8A2A97827FCA9EDFC4141E5A23A061", hash_generated_method = "6E6867BFD5FFBCD2BAE0BAFAC770F877")
    
public ActionBarImplJB(Activity activity, Callback callback) {
        // checkHomeAsUpOption = false as this was fixed in v4.1's framework
        super(activity, callback, false);
    }
}
