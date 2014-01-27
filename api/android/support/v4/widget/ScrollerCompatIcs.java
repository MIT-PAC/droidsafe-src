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

package android.support.v4.widget;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.widget.Scroller;

/**
 * ICS API access for Scroller
 */
class ScrollerCompatIcs {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:37.521 -0500", hash_original_method = "E030C3845B81F0A581ED2A6FFAB845FA", hash_generated_method = "9DA3E3CB997A49484FE436B4EC2B6318")
    
public static float getCurrVelocity(Scroller scroller) {
        return scroller.getCurrVelocity();
    }
}
