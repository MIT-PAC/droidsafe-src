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
class ActionBarActivityDelegateJBMR2 extends ActionBarActivityDelegateJB {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.003 -0400", hash_original_method = "61CAF37377BC7855D1672BFBD6054743", hash_generated_method = "61CAF37377BC7855D1672BFBD6054743")
    
ActionBarActivityDelegateJBMR2(ActionBarActivity activity) {
        super(activity);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.006 -0400", hash_original_method = "E9FB48F5B206E27666F43111747F1C19", hash_generated_method = "51CDA8C459CF485AE27F1EABE1583ED7")
    
@Override
    public ActionBar createSupportActionBar() {
        return new ActionBarImplJBMR2(mActivity, mActivity);
    }
}
