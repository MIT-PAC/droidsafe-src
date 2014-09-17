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

package android.support.v4.view;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.graphics.Paint;
import android.view.View;

/**
 * Jellybean MR1 - specific View API access.
 */
class ViewCompatJellybeanMr1 {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:02.105 -0400", hash_original_method = "AF353697C9977B1339D960AAE179C615", hash_generated_method = "FFE281A4E013589CE3E687F51FCB846F")
    
public static int getLabelFor(View view) {
        return view.getLabelFor();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:02.109 -0400", hash_original_method = "EF0DCC04D8F64AD4C770E6D1EC277DA3", hash_generated_method = "9C445234EEC7B22C326280011E8B930A")
    
public static void setLabelFor(View view, int id) {
        view.setLabelFor(id);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:02.113 -0400", hash_original_method = "06B7302AA06C34472A71482491C754F5", hash_generated_method = "E90C3F3A61F56980DC571CB857C0F298")
    
public static void setLayerPaint(View view, Paint paint) {
        view.setLayerPaint(paint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:02.118 -0400", hash_original_method = "EF908D3693306A34136FC9622B81565D", hash_generated_method = "211AA16DE3EE826F4708C4B2A35A93F5")
    
public static int getLayoutDirection(View view) {
        return view.getLayoutDirection();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:02.125 -0400", hash_original_method = "F389E42A8F59A57CF89BB3551B88E793", hash_generated_method = "9BBA8471604EBE4702EB76ABC2919B35")
    
public static void setLayoutDirection(View view, int layoutDirection) {
        view.setLayoutDirection(layoutDirection);
    }
}
