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


package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.res.CompatibilityInfo;

public class CompatibilityInfoHolder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.839 -0500", hash_original_field = "E5B566789C44F2CF56BA88B943058EF6", hash_generated_field = "5A8F1066A37F831BD10CAF4B8FC9C285")

    private volatile CompatibilityInfo mCompatInfo = CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.445 -0400", hash_original_method = "97B7CCDD2675E63E6068438C6851DDC9", hash_generated_method = "97B7CCDD2675E63E6068438C6851DDC9")
    public CompatibilityInfoHolder ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.842 -0500", hash_original_method = "0EA4FD6EEBB493F77BF170E078055D26", hash_generated_method = "DA47424005D0B51DB4B3A6A1336D3F46")
    
public void set(CompatibilityInfo compatInfo) {
        if (compatInfo != null && (compatInfo.isScalingRequired()
                || !compatInfo.supportsScreen())) {
            mCompatInfo = compatInfo;
        } else {
            mCompatInfo = CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.844 -0500", hash_original_method = "2844201B11A6D03D93C5B2DA2F70B8EA", hash_generated_method = "972BCA8FA8DA67067CC9D73237125234")
    
public CompatibilityInfo get() {
        return mCompatInfo;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.846 -0500", hash_original_method = "1E806FB90B93A5B9B671B556A0C9FEA7", hash_generated_method = "A2ED4AD7815C5D418E93D7C3AA5E4870")
    
public CompatibilityInfo getIfNeeded() {
        CompatibilityInfo ci = mCompatInfo;
        if (ci == null || ci  == CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO) {
            return null;
        }
        return ci;
    }
    
}

