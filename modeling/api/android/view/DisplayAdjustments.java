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

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.res.CompatibilityInfo;
import android.os.IBinder;

import com.android.internal.util.Objects;

/** @hide */
public class DisplayAdjustments {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:06:10.730 -0500", hash_original_field = "19C5902296BC3B441B313C2A77EC9E1B", hash_generated_field = "7277364B30380F34B982FA926D783D1F")

    public static final boolean DEVELOPMENT_RESOURCES_DEPEND_ON_ACTIVITY_TOKEN = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:06:10.735 -0500", hash_original_field = "EB66FD95EA0C9978AFF3048D54FFA6D5", hash_generated_field = "478114736FF744527146FD2DFD8F6FD9")

    public static final DisplayAdjustments DEFAULT_DISPLAY_ADJUSTMENTS = new DisplayAdjustments();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:06:10.739 -0500", hash_original_field = "E5B566789C44F2CF56BA88B943058EF6", hash_generated_field = "5A8F1066A37F831BD10CAF4B8FC9C285")

    private volatile CompatibilityInfo mCompatInfo = CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:06:10.742 -0500", hash_original_field = "E5471F0C03B08F98EE10B0F0E117A36C", hash_generated_field = "43AD28DFD27BD5445752248E4FFE1654")

    private volatile IBinder mActivityToken;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:06:10.745 -0500", hash_original_method = "6E253AB26463FBEBDC80C273E7CAAA30", hash_generated_method = "127C3E4AF5081C9D39388944233AFFB6")
    
public DisplayAdjustments() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:06:10.755 -0500", hash_original_method = "D404197A66B1F21EFB019301A861B159", hash_generated_method = "CE2C3D8EE48B0300660F8B5A1E63E1AF")
    
public DisplayAdjustments(IBinder token) {
        mActivityToken = token;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:06:10.758 -0500", hash_original_method = "581E2DEE8CC015428D215EFBC7702646", hash_generated_method = "994A231BE8DD0CBAC3E3F87FAE24D158")
    
public DisplayAdjustments(DisplayAdjustments daj) {
        this (daj.getCompatibilityInfo(), daj.getActivityToken());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:06:10.762 -0500", hash_original_method = "A17B0B149BB1F798DE6E0ADC95B2E75E", hash_generated_method = "D464C8E3F1B2F098A810226DC94CA00F")
    
public DisplayAdjustments(CompatibilityInfo compatInfo, IBinder token) {
        setCompatibilityInfo(compatInfo);
        mActivityToken = token;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:06:10.767 -0500", hash_original_method = "F2AFB5F447317B5FFED45D68BA6A2EF8", hash_generated_method = "3D6A4A50D5F55AF32889B1E685480FB9")
    
public void setCompatibilityInfo(CompatibilityInfo compatInfo) {
        if (this == DEFAULT_DISPLAY_ADJUSTMENTS) {
            throw new IllegalArgumentException(
                    "setCompatbilityInfo: Cannot modify DEFAULT_DISPLAY_ADJUSTMENTS");
        }
        if (compatInfo != null && (compatInfo.isScalingRequired()
                || !compatInfo.supportsScreen())) {
            mCompatInfo = compatInfo;
        } else {
            mCompatInfo = CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:06:10.769 -0500", hash_original_method = "8E45564872BB3D3E93F39418770AA105", hash_generated_method = "AE51DFC480814BD7433A06651D380117")
    
public CompatibilityInfo getCompatibilityInfo() {
        return mCompatInfo;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:06:10.773 -0500", hash_original_method = "D250583BEC586CB620A932A1854412D6", hash_generated_method = "FD7C6E3138B1585C6B838DE3031A8ECD")
    
public void setActivityToken(IBinder token) {
        if (this == DEFAULT_DISPLAY_ADJUSTMENTS) {
            throw new IllegalArgumentException(
                    "setActivityToken: Cannot modify DEFAULT_DISPLAY_ADJUSTMENTS");
        }
        mActivityToken = token;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:06:10.777 -0500", hash_original_method = "D32D1A589CFC02641AF8A3133A37BC7F", hash_generated_method = "F15685847150FBEBCF37BC64BE7EA719")
    
public IBinder getActivityToken() {
        return mActivityToken;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:06:10.781 -0500", hash_original_method = "36A62F1D8F9EDF6F78B4B7BFC685B870", hash_generated_method = "E0F0FA719D5C342E53645466B3A262DB")
    
@Override
    public int hashCode() {
        int hash = 17;
        hash = hash * 31 + mCompatInfo.hashCode();
        if (DEVELOPMENT_RESOURCES_DEPEND_ON_ACTIVITY_TOKEN) {
            hash = hash * 31 + (mActivityToken == null ? 0 : mActivityToken.hashCode());
        }
        return hash;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:06:10.785 -0500", hash_original_method = "02840D9BBD6693658717720E473FE716", hash_generated_method = "8DFCCDA919D68308C4D3218D5300787E")
    
@Override
    public boolean equals(Object o) {
        if (!(o instanceof DisplayAdjustments)) {
            return false;
        }
        DisplayAdjustments daj = (DisplayAdjustments)o;
        return Objects.equal(daj.mCompatInfo, mCompatInfo) &&
                Objects.equal(daj.mActivityToken, mActivityToken);
    }
}
