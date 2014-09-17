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
import android.view.ViewGroup;

class ViewGroupCompatJellybeanMR2 {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:02.354 -0400", hash_original_method = "D24C39B6E733D57ECAD980375D191673", hash_generated_method = "FEFDAD47F60FFBB8A4BAADD2D78C4BE1")
    
public static int getLayoutMode(ViewGroup group) {
        return group.getLayoutMode();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:02.358 -0400", hash_original_method = "D9A089729232A2023421668EA04EE6E1", hash_generated_method = "18B806F622BD113788855800B7B75553")
    
public static void setLayoutMode(ViewGroup group, int mode) {
        group.setLayoutMode(mode);
    }
}
