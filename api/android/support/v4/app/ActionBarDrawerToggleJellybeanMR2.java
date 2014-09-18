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
package android.support.v4.app;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.R;
import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.Log;
class ActionBarDrawerToggleJellybeanMR2 {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:54.338 -0400", hash_original_field = "06B1DE42B1D5382740A7064CF7C82A42", hash_generated_field = "E3DCF1A031211ADB1092829FE11CE160")

    private static final String TAG = "ActionBarDrawerToggleImplJellybeanMR2";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:54.343 -0400", hash_original_field = "5C7C7C807D4667E8DFE167233BAF6A11", hash_generated_field = "431C79031997EF2D7CAA06096E8A2CAF")

    private static final int[] THEME_ATTRS = new int[] {
            //R.attr.homeAsUpIndicator
			DSUtils.FAKE_INT
    };
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:54.351 -0400", hash_original_method = "7C0F600752A785E987B36C95FA36D9B2", hash_generated_method = "5FECDFEB6B2CBF4F2C67091A1D6E1356")
    
public static Object setActionBarUpIndicator(Object info, Activity activity,
            Drawable drawable, int contentDescRes) {
        final ActionBar actionBar = activity.getActionBar();
        actionBar.setHomeAsUpIndicator(drawable);
        actionBar.setHomeActionContentDescription(contentDescRes);
        return info;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:54.356 -0400", hash_original_method = "9DE0BDAD694DC908B71A729BF1BCCE9B", hash_generated_method = "84D3EBE6CD05405C5CB2DEA3BDEE9DD8")
    
public static Object setActionBarDescription(Object info, Activity activity,
            int contentDescRes) {
        final ActionBar actionBar = activity.getActionBar();
        actionBar.setHomeActionContentDescription(contentDescRes);
        return info;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:54.362 -0400", hash_original_method = "8A5AE9AC9313119D692C1ED43667FE3F", hash_generated_method = "FBAE5216BBEB963ACC00EB29E8E63280")
    
public static Drawable getThemeUpIndicator(Activity activity) {
        final TypedArray a = activity.obtainStyledAttributes(THEME_ATTRS);
        final Drawable result = a.getDrawable(0);
        a.recycle();
        return result;
    }
}

