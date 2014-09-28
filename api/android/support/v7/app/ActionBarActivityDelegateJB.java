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
class ActionBarActivityDelegateJB extends ActionBarActivityDelegateICS {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.983 -0400", hash_original_method = "6722D71408EE4659DB41B1E209176E81", hash_generated_method = "6722D71408EE4659DB41B1E209176E81")
    
ActionBarActivityDelegateJB(ActionBarActivity activity) {
        super(activity);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.987 -0400", hash_original_method = "400F6497A4025EE72A6758B8616AE82F", hash_generated_method = "A5D8EEEE407E4CDDADA7D3F88D368D7B")
    
@Override
    public ActionBar createSupportActionBar() {
        return new ActionBarImplJB(mActivity, mActivity);
    }
}
