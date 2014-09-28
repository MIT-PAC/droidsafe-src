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

package android.support.v4.view;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/**
 * ICS specific ViewGroup API implementation.
 */
class ViewGroupCompatIcs {
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:28.989 -0500", hash_original_method = "33E36D1DFBA0BBF224A4BFF2CB6EC880", hash_generated_method = "79BB2D0F1E6018D65B1386DB5ED08C8F")
    
public static boolean onRequestSendAccessibilityEvent(ViewGroup group, View child,
            AccessibilityEvent event) {
        return group.onRequestSendAccessibilityEvent(child, event);
    }
}
