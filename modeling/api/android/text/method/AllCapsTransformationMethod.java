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
 * Copyright (C) 2011 The Android Open Source Project
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


package android.text.method;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.util.Locale;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;

public class AllCapsTransformationMethod implements TransformationMethod2 {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.577 -0500", hash_original_field = "CB4660A21DBB0A940F639C69E46D7C67", hash_generated_field = "4F51E6D9C8017CC0D76D6E29A09B68C6")

    private static final String TAG = "AllCapsTransformationMethod";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.580 -0500", hash_original_field = "B372655E189CA31F1D74E7441882FA0E", hash_generated_field = "7A48C52BD142368ED44BC086FD9013A2")

    private boolean mEnabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.583 -0500", hash_original_field = "D959780368C6CA232CF8C3906CDDEDF3", hash_generated_field = "1A21143DB168F6FB0629A178DF0F089E")

    private Locale mLocale;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.586 -0500", hash_original_method = "3B95B7992FFC661A96A84916391DF4EA", hash_generated_method = "5F49A117C3F37EA010CD143A6C139215")
    
public AllCapsTransformationMethod(Context context) {
        mLocale = context.getResources().getConfiguration().locale;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.589 -0500", hash_original_method = "78672DB29526C1EED454DBBBA0FA4686", hash_generated_method = "C508363441DE225DBCC5C9BABCF533DD")
    
@Override
    public CharSequence getTransformation(CharSequence source, View view) {
        if (mEnabled) {
            return source != null ? source.toString().toUpperCase(mLocale) : null;
        }
        Log.w(TAG, "Caller did not enable length changes; not transforming text");
        return source;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.592 -0500", hash_original_method = "13D8211EBDC6D4196EF2DDB70ED5CACD", hash_generated_method = "BFBF07CECC1413C3431BE0A8B506DC03")
    
@Override
    public void onFocusChanged(View view, CharSequence sourceText, boolean focused, int direction,
            Rect previouslyFocusedRect) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.595 -0500", hash_original_method = "507549025152D254EA227D255598B5AF", hash_generated_method = "B00E5B37CD6563947F1BDD2639ADB714")
    
@Override
    public void setLengthChangesAllowed(boolean allowLengthChanges) {
        mEnabled = allowLengthChanges;
    }
}

