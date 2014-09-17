/*
 * Copyright (C) 2014 The Android Open Source Project
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

class ViewPropertyAnimatorCompatJB {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.684 -0400", hash_original_method = "4CEAA92353DBAE19B74C1E2C9610066D", hash_generated_method = "EDC3EE28E9CF6984066E6C18D2FC48E1")
    
public static void withStartAction(View view, Runnable runnable) {
        //view.animate().withStartAction(runnable);
    	if (runnable != null)
    		runnable.run();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.687 -0400", hash_original_method = "6FB5FC5FABE4222F1DB4DF0A12FD2B97", hash_generated_method = "F0C29020235131832307E20EE7A2C1E9")
    
public static void withEndAction(View view, Runnable runnable) {
        //view.animate().withEndAction(runnable);
        if (runnable != null)
    		runnable.run();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.690 -0400", hash_original_method = "02AB9DFC10344919DA5D9FAC752BDE0F", hash_generated_method = "DB06E1AF58922135E9D3C1B196336DEA")
    
public static void withLayer(View view) {
        //view.animate().withLayer();
    }

}
