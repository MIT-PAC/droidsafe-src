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


package android.support.v4.view;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.view.KeyEvent;
import android.view.View;

class KeyEventCompatEclair {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:00.750 -0400", hash_original_method = "606B2FF88E1E0B5548004EF761B77C1B", hash_generated_method = "C208CAA3B7833A70D08896938619A05E")
    
public static Object getKeyDispatcherState(View view) {
        return view.getKeyDispatcherState();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:00.754 -0400", hash_original_method = "102669BD739DAD3BFB1430061D263A1F", hash_generated_method = "D8EF35FB02274D86859DF75341002CE4")
    
public static boolean dispatch(KeyEvent event, KeyEvent.Callback receiver, Object state,
                Object target) {
        return event.dispatch(receiver, (KeyEvent.DispatcherState)state, target);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:00.758 -0400", hash_original_method = "C305132C33C49F8806F84E415C7A2387", hash_generated_method = "08335C68292ED95915FCBE1CD4A98ED9")
    
public static void startTracking(KeyEvent event) {
        event.startTracking();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:00.762 -0400", hash_original_method = "39EEE9A9B814F40ACD260A4BFA3CB088", hash_generated_method = "436455AFD62FC6F093F49E838C606713")
    
public static boolean isTracking(KeyEvent event) {
        return event.isTracking();
    }
}
