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


package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;

public class ToneSettings implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:21.050 -0400", hash_original_field = "006B52A6764FB6E11133906A413EC74A", hash_generated_field = "FABADDC48937C3190B4F868CEBE56675")

    public static final Parcelable.Creator<ToneSettings> CREATOR = new Parcelable.Creator<ToneSettings>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.206 -0500", hash_original_method = "0AF8B6A3D7EC6128A504A6DF918A5419", hash_generated_method = "ECEB41C779D6358CAC1832A8D39688A6")
        
public ToneSettings createFromParcel(Parcel in) {
            return new ToneSettings(in);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.209 -0500", hash_original_method = "DAFFA5B94F1FE936F2C8E737B7D9ABDB", hash_generated_method = "580F7944D1449F9EC332452F39F75690")
        
public ToneSettings[] newArray(int size) {
            return new ToneSettings[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.188 -0500", hash_original_field = "A6070A7BA087BD42A534C9AD7E3C0404", hash_generated_field = "F627176E1C35421D662BC9D4AD138316")

    public Duration duration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.190 -0500", hash_original_field = "7A948D5492CC9156CF1F7C4A9406CE2E", hash_generated_field = "EB3E719105B196E3B2D9B760B5FAACD1")

    public Tone tone;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.193 -0500", hash_original_field = "F31F21EBDF514B21C5AA2638FF612AB7", hash_generated_field = "DDF27BF2683D75AD38AE982C8B9BF193")

    public boolean vibrate;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.195 -0500", hash_original_method = "1758CDE2435E3198DD1711D15D7C0A67", hash_generated_method = "3D6EC7643062092830AD7D94C691CE9C")
    
public ToneSettings(Duration duration, Tone tone, boolean vibrate) {
        this.duration = duration;
        this.tone = tone;
        this.vibrate = vibrate;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.198 -0500", hash_original_method = "BF14929F27F95EDB5212CB812386B849", hash_generated_method = "EB37CD53DAB118EB2E38EA858843DF9C")
    
private ToneSettings(Parcel in) {
        duration = in.readParcelable(null);
        tone = in.readParcelable(null);
        vibrate = in.readInt() == 1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.201 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.203 -0500", hash_original_method = "A5E63ABB35658FAF6D2AA5EF55230C8C", hash_generated_method = "679FFFFCAC06C80903598895F0C3F2CF")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(duration, 0);
        dest.writeParcelable(tone, 0);
        dest.writeInt(vibrate ? 1 : 0);
    }
    // orphaned legacy method
    public ToneSettings createFromParcel(Parcel in) {
            return new ToneSettings(in);
        }
    
    // orphaned legacy method
    public ToneSettings[] newArray(int size) {
            return new ToneSettings[size];
        }
    
}

