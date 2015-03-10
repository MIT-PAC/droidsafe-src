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
 * limitations under the License
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.nfc;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;

public class TechListParcel implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.415 -0400", hash_original_field = "3EF1D37F275B16491C644A6C6C17DFAE", hash_generated_field = "26E56EC2A9AB9ADBEAAD9C9C0A9E8ECF")

    public static final Creator<TechListParcel> CREATOR = new Creator<TechListParcel>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.003 -0500", hash_original_method = "24B5B0F43AE1F40832E0294086D57B0A", hash_generated_method = "278E58E108F778B4DE1B623A83A60D65")
        
@Override
        public TechListParcel createFromParcel(Parcel source) {
            int count = source.readInt();
            String[][] techLists = new String[count][];
            for (int i = 0; i < count; i++) {
                techLists[i] = source.readStringArray();
            }
            return new TechListParcel(techLists);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.005 -0500", hash_original_method = "61CA68758CEDCBD410FFB44FD4FB304C", hash_generated_method = "296E638926534A938B8F9794791F7E57")
        
@Override
        public TechListParcel[] newArray(int size) {
            return new TechListParcel[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.988 -0500", hash_original_field = "81C0628C8277BC5186C8301B61FFEA4A", hash_generated_field = "C36B9D5CB222403FE3E00F43AA3D1F77")

    private String[][] mTechLists;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.991 -0500", hash_original_method = "6AB5FDB623A6EE108E2E4847F2947558", hash_generated_method = "54EBEA92C4E134A3E6AB63DC48C4CBDE")
    
public TechListParcel(String[]... strings) {
        mTechLists = strings;
    }

    @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.993 -0500", hash_original_method = "6EF67533858F398D5EC0425F1D475F89", hash_generated_method = "CA9DE982BE5A725ED2BD4675F167914B")
    
public String[][] getTechLists() {
        return mTechLists;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.995 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    
@Override
    public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.998 -0500", hash_original_method = "B19E49B45A2ACFBF18675BF33A9FB41F", hash_generated_method = "86942881170CA5DCD2992A885D2083EC")
    
@Override
    public void writeToParcel(Parcel dest, int flags) {
        int count = mTechLists.length;
        dest.writeInt(count);
        for (int i = 0; i < count; i++) {
            String[] techList = mTechLists[i];
            dest.writeStringArray(techList);
        }
    }
}

