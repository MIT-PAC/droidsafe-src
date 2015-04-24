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
 * Copyright (C) 2006 The Android Open Source Project
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


package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;

import com.android.internal.R;

public class CheckBox extends CompoundButton {
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.727 -0500", hash_original_method = "07A60C33F591AF3364367476C757E191", hash_generated_method = "E6771C4C8CFC6F5CDC28750B50C2D1E4")
    
public CheckBox(Context context) {
        this(context, null);
    }
    
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.729 -0500", hash_original_method = "8805AB2AC1AEC0E9A85C20D3125221E0", hash_generated_method = "71BC6DBDC707861A63C3CDC0797C5E15")
    
public CheckBox(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.checkboxStyle);
    }

    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.732 -0500", hash_original_method = "DC2D9AD560E05B0AD2F1F269CCCF9F57", hash_generated_method = "AD2FD894859AA2FF10ABD4A010F667B5")
    
public CheckBox(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.734 -0500", hash_original_method = "270C42284D505CD6CA182328DD88ED30", hash_generated_method = "0AE7313901D0A224234DCDCF680EB599")
    
@Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        super.onPopulateAccessibilityEvent(event);
        if (isChecked()) {
            event.getText().add(mContext.getString(R.string.checkbox_checked));
        } else {
            event.getText().add(mContext.getString(R.string.checkbox_not_checked));
        }
    }
    
}

