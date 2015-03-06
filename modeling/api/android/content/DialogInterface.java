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


package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.view.KeyEvent;

public interface DialogInterface {
    
    public static final int BUTTON_POSITIVE = -1;
    
    public static final int BUTTON_NEGATIVE = -2;
    
    public static final int BUTTON_NEUTRAL = -3;
    
    @Deprecated
    public static final int BUTTON1 = BUTTON_POSITIVE;
    
    @Deprecated
    public static final int BUTTON2 = BUTTON_NEGATIVE;
    
    @Deprecated
    public static final int BUTTON3 = BUTTON_NEUTRAL;
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    public void cancel();

    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    public void dismiss();
    
    interface OnCancelListener {
        @DSVerified("Called from Dialog")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void onCancel(DialogInterface dialog);
    }
    
    interface OnDismissListener {
        @DSVerified("Called from AlertDialog.Builder.create()")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void onDismiss(DialogInterface dialog);
    }
    
    interface OnShowListener {
        @DSVerified("Called from Dialog")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void onShow(DialogInterface dialog);
    }
    
    interface OnClickListener {
        
        @DSVerified("Called from AlertDialog.Builder.create()")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void onClick(DialogInterface dialog, int which);
    }
    
    interface OnMultiChoiceClickListener {
        @DSVerified("Called from AlertDialog.Builder.create()")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void onClick(DialogInterface dialog, int which, boolean isChecked);
    }
    
    interface OnKeyListener {
        @DSVerified("Called from Dialog")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event);
    }
}
