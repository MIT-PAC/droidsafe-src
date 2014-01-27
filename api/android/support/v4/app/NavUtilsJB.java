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

package android.support.v4.app;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;

import android.support.v4.app.NavUtils;

/**
* Notes:  We patched this up as we do not want to pull in API version 16 source code
*/

class NavUtilsJB {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:06.873 -0500", hash_original_method = "BFEDDA266C52CC81FA2F1DABC0703AC4", hash_generated_method = "B53AFB187DC25461701B8991E1B4DA16")
    
public static Intent getParentActivityIntent(Activity activity) {
        //return activity.getParentActivityIntent();
        // if (activity.getParent())
        //     return activity.getParent().getIntent();
        // return null;
        return NavUtils.getParentActivityIntent(activity);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:06.876 -0500", hash_original_method = "325459876D1B7AB5D6C4710EF08AEF89", hash_generated_method = "E4D944E7302885FB663DF407AEFB8F3D")
    
public static boolean shouldUpRecreateTask(Activity activity, Intent targetIntent) {
        // String action = activity.getIntent().getAction();
        // return action != null && !action.equals(Intent.ACTION_MAIN);

        return NavUtils.shouldUpRecreateTask(activity, targetIntent);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:06.878 -0500", hash_original_method = "E25C64227F2491C3FBC8B59DDF495413", hash_generated_method = "2BDCE6BF98026CF9147F04D774614870")
    
public static void navigateUpTo(Activity activity, Intent upIntent) {
        //activity.navigateUpTo(upIntent);
        // upIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        // activity.startActivity(upIntent);
        // activity.finish();
        NavUtils.navigateUpTo(activity, upIntent);
    }

    /*
    // this will require API16's version of ActivityInfo
    public static String getParentActivityName(ActivityInfo info) {
        return NavUtils.getParentActivityName(info.targetActivity);
    }

    */
}
