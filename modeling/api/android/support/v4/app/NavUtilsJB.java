/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


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
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:00.681 -0400", hash_original_method = "CB98B27E302D7CC17AB9C2D1275BAB9B", hash_generated_method = "C9AD71EFE7773FE5CC11389F47BD19A0")
    
public static Intent getParentActivityIntent(Activity activity) {
        return activity.getParentActivityIntent();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:00.685 -0400", hash_original_method = "600F3A01F406647A22CFAD43585E8A93", hash_generated_method = "F46ECBD0A4E9645EB3E430F86A83D6E4")
    
public static boolean shouldUpRecreateTask(Activity activity, Intent targetIntent) {
        return activity.shouldUpRecreateTask(targetIntent);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:00.688 -0400", hash_original_method = "0AEB6BA6380873C2F8737DDBA04A3183", hash_generated_method = "A6824288A65DB84A7A9926C5522CFA03")
    
public static void navigateUpTo(Activity activity, Intent upIntent) {
        activity.navigateUpTo(upIntent);
    }

    /*
    // this will require API16's version of ActivityInfo
    public static String getParentActivityName(ActivityInfo info) {
        return NavUtils.getParentActivityName(info.targetActivity);
    }

    */

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:00.691 -0400", hash_original_method = "1B7AF8495952C7746A5ACB9A83810BD2", hash_generated_method = "FD1D364EE353803CDF480E20AA76DC74")
    
public static String getParentActivityName(ActivityInfo info) {
        return info.parentActivityName;
    }}
