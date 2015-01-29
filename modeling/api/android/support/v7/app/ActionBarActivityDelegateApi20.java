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

package android.support.v7.app;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.view.Window;

class ActionBarActivityDelegateApi20 extends ActionBarActivityDelegateJBMR2 {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.461 -0400", hash_original_method = "C501192B5A6DBE12F50EEDDD7AF674E5", hash_generated_method = "C501192B5A6DBE12F50EEDDD7AF674E5")
    
ActionBarActivityDelegateApi20(ActionBarActivity activity) {
        super(activity);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.466 -0400", hash_original_method = "0F83E1508FE19A135FDAF8FA01435633", hash_generated_method = "BC7FD2580D5DB3382D4C9CF178E67DA3")
    
@Override
    Window.Callback createWindowCallbackWrapper(Window.Callback cb) {
        return new WindowCallbackWrapperApi20(cb);
    }

    class WindowCallbackWrapperApi20 extends WindowCallbackWrapper {

        WindowCallbackWrapperApi20(Window.Callback wrapped) {
            super(wrapped);
        }

    }

}
