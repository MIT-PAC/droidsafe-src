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


package android.text.style;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextUtils;

public class SpellCheckSpan implements ParcelableSpan {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.444 -0500", hash_original_field = "084B0C868B1F8BD7E3BE83E6B71E75D7", hash_generated_field = "CD03D035E3A34C62C050AB1056925600")

    private boolean mSpellCheckInProgress;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.447 -0500", hash_original_method = "F1D4E96290AC8C7754627E362363B9DA", hash_generated_method = "312C28E8749A7E188B801215CF7716D6")
    
public SpellCheckSpan() {
        mSpellCheckInProgress = false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.451 -0500", hash_original_method = "9BB9BE3CC699053708AEB172BEE11085", hash_generated_method = "41A090A41E901AC537DECBBCA35AA278")
    
public SpellCheckSpan(Parcel src) {
        mSpellCheckInProgress = (src.readInt() != 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.453 -0500", hash_original_method = "712093FDA6926C8B5E44D517F24CE2ED", hash_generated_method = "324125E7FB933C86372919A4522CE772")
    
public void setSpellCheckInProgress(boolean inProgress) {
        mSpellCheckInProgress = inProgress;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.456 -0500", hash_original_method = "DF88C425EC6702745B81C07A898C5194", hash_generated_method = "1A353917CBE465CDA9B6B2EE4E80CC0F")
    
public boolean isSpellCheckInProgress() {
        return mSpellCheckInProgress;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.458 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    
@Override
    public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.461 -0500", hash_original_method = "4374405C13E287E9F22B8DE100EB99A0", hash_generated_method = "F3587621251199042C93B6CF48312F2D")
    
@Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mSpellCheckInProgress ? 1 : 0);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.464 -0500", hash_original_method = "8BC137FF3CFAC8D1FC70CD10E3E0E733", hash_generated_method = "707A5D23ABAB90A54C1D8C1E36C59126")
    
@Override
    public int getSpanTypeId() {
        return TextUtils.SPELL_CHECK_SPAN;
    }
    
}

