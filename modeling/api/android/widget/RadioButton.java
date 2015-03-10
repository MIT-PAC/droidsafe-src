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

public class RadioButton extends CompoundButton {
    
    @DSComment("RadioButton")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:19.424 -0500", hash_original_method = "8EA0788A6467FFBB5D903E4298CD9D3F", hash_generated_method = "1CC640C88E022C090251D7E89C600A3A")
    
public RadioButton(Context context) {
        this(context, null);
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:19.427 -0500", hash_original_method = "FCCFFF736372EBE3F690E025A55A3D26", hash_generated_method = "1CE647101DE770DCB868C130223B07E9")
    
public RadioButton(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.radioButtonStyle);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:19.429 -0500", hash_original_method = "8A4946DCA2378530E5A11522D0746FD0", hash_generated_method = "EB63F6BC032F703A24610404E43AE019")
    
public RadioButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * {@inheritDoc}
     * <p>
     * If the radio button is already checked, this method will not toggle the radio button.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:19.432 -0500", hash_original_method = "4F290A4820515377F1C311D5735DB548", hash_generated_method = "ACBF296FB7E42777A2E5A8A4B90FF666")
    
@Override
    public void toggle() {
        // we override to prevent toggle when the radio is already
        // checked (as opposed to check boxes widgets)
        if (!isChecked()) {
            super.toggle();
        }
    }

    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:19.434 -0500", hash_original_method = "800F92BFA9EDE937B28EAF651D664B90", hash_generated_method = "4788EAEF4BDBCFDCBBBE5CEFA99C5E9D")
    
@Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        super.onPopulateAccessibilityEvent(event);
        if (isChecked()) {
            event.getText().add(mContext.getString(R.string.radiobutton_selected));
        } else {
            event.getText().add(mContext.getString(R.string.radiobutton_not_selected));
        }
    }
    
}

