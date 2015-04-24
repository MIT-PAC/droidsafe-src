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
 * Copyright (C) 2007 The Android Open Source Project
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


package android.preference;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.util.AttributeSet;





public class PreferenceCategory extends PreferenceGroup {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.493 -0500", hash_original_field = "0BAC90275D4395911E2F5DBDB06BE5BE", hash_generated_field = "441EBA3E1E175AE51D9A464A63573C42")

    private static final String TAG = "PreferenceCategory";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.495 -0500", hash_original_method = "1DC034B1500658FC000B09366B7B5F7E", hash_generated_method = "F4825E768EAD5298050A0C9DA399D85B")
    
public PreferenceCategory(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.498 -0500", hash_original_method = "8161E913420B97F1DB3C693A6B08D371", hash_generated_method = "0ECE7F6D8F7DFDBE079E09E608577F22")
    
public PreferenceCategory(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.preferenceCategoryStyle);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.500 -0500", hash_original_method = "41E6234004F62208925BDD88189872FC", hash_generated_method = "0A5E517EB76E49DCC89ECB26CCFED113")
    
public PreferenceCategory(Context context) {
        this(context, null);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.503 -0500", hash_original_method = "C0B8615ABBF994242F8771673126794E", hash_generated_method = "A0932983EFFEC1940110F2509480E45B")
    
@Override
    protected boolean onPrepareAddPreference(Preference preference) {
        if (preference instanceof PreferenceCategory) {
            throw new IllegalArgumentException(
                    "Cannot add a " + TAG + " directly to a " + TAG);
        }
        
        return super.onPrepareAddPreference(preference);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.505 -0500", hash_original_method = "92A62D678EEB31430D80EB6E828940C3", hash_generated_method = "D7A670949734E0F874E0E87449866F43")
    
@Override
    public boolean isEnabled() {
        return false;
    }
}

