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


package android.text.style;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;

public class ScaleXSpan extends MetricAffectingSpan implements ParcelableSpan {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:10.167 -0500", hash_original_field = "859F89A95EA81D453D987D576B8DE2B6", hash_generated_field = "F3DE0713F398F5B7918E6C35C0AAE054")

	private  float mProportion;

	@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:10.169 -0500", hash_original_method = "5A8420DEA89D3BA24C51E3449203D410", hash_generated_method = "1D0472D3B5866F27F68DFF001CC0FF53")
    
public ScaleXSpan(float proportion) {
		mProportion = proportion;
	}

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:10.172 -0500", hash_original_method = "84B8294F7669FCC40D337D5712D24934", hash_generated_method = "606539CC8A5B28AED4AD71074AC1FC89")
    
public ScaleXSpan(Parcel src) {
        mProportion = src.readFloat();
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:10.175 -0500", hash_original_method = "305A59DEF4DC94D07B224B5DAB862393", hash_generated_method = "454F15ABAB6AB97134EC46CE4EF196D1")
    
public int getSpanTypeId() {
        return TextUtils.SCALE_X_SPAN;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:10.177 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:10.179 -0500", hash_original_method = "0FDF8A7C1083C0A4BBAF4047CBF27DA9", hash_generated_method = "6269EB970CDD3F9298E6DD0FFC02ACA2")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(mProportion);
    }

	@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:10.182 -0500", hash_original_method = "EC544E0B7E0BD00BAC5AC8960BBAB7C7", hash_generated_method = "47DD6B3C3E4ECDD728FA56F864D8EE6B")
    
public float getScaleX() {
		return mProportion;
	}

	@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:10.184 -0500", hash_original_method = "E20B555A657035EC86C04FC249B48C55", hash_generated_method = "4409F4C61E772C443FD5780BFF0A344D")
    
@Override
	public void updateDrawState(TextPaint ds) {
		ds.setTextScaleX(ds.getTextScaleX() * mProportion);
	}

	@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:10.187 -0500", hash_original_method = "7988BDF035A46DF7E155ADF4B90D7F9B", hash_generated_method = "ED2BEC775AFAB29F71AA3FF7645CA9B4")
    
@Override
	public void updateMeasureState(TextPaint ds) {
		ds.setTextScaleX(ds.getTextScaleX() * mProportion);
	}
    
}

