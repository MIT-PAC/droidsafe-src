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
 * Copyright (C) 2009 The Android Open Source Project
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


package android.app.backup;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;

public class RestoreSet implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.595 -0400", hash_original_field = "CE8E8F9B87B41BD54B3EF7D5C775C91C", hash_generated_field = "FA29E88161E42230CFC58EC9483694A2")

    public static final Parcelable.Creator<RestoreSet> CREATOR
            = new Parcelable.Creator<RestoreSet>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.546 -0500", hash_original_method = "BAC0E1D02FA6C265C2D5D1FA79671B4B", hash_generated_method = "4ADCCD2B1E1F80E21C15C859BEE302EF")
        
public RestoreSet createFromParcel(Parcel in) {
            return new RestoreSet(in);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.548 -0500", hash_original_method = "03C8EF6AD074BC1F725D7C9C3018C39D", hash_generated_method = "E6A5EB2F5A30C5E737BAD300909FC32C")
        
public RestoreSet[] newArray(int size) {
            return new RestoreSet[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.529 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

    public String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.531 -0500", hash_original_field = "3D8895BEB451720D28BB2802C75981F7", hash_generated_field = "0631FBD4EFF378254463BB4235C76180")

    public String device;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.533 -0500", hash_original_field = "D9F546AA1CD533963BACAD0CFE06DDBD", hash_generated_field = "D837BDC3597836EC3D401AFD06D9D644")

    public long token;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.536 -0500", hash_original_method = "8F1DCA72C97A5A82D254BEC6432DE3FB", hash_generated_method = "F72E27EE7BBB93FAA5D5AC97FA16596B")
    
public RestoreSet() {
        // Leave everything zero / null
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.538 -0500", hash_original_method = "F547208C80F4E032CD5D9862703EA509", hash_generated_method = "91BF4EC799662775079597CD73602955")
    
public RestoreSet(String _name, String _dev, long _token) {
        name = _name;
        device = _dev;
        token = _token;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.553 -0500", hash_original_method = "2219E3A595B9AC7F0E16EAF40A593277", hash_generated_method = "1D7844FE912FD902EF079617CE2F8BFF")
    
private RestoreSet(Parcel in) {
        name = in.readString();
        device = in.readString();
        token = in.readLong();
    }

    // Parcelable implementation
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.540 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.542 -0500", hash_original_method = "6F3E6147075189D34A5652BA91455185", hash_generated_method = "7489F8A98DBF0342A63F57E6A7247F09")
    
public void writeToParcel(Parcel out, int flags) {
        out.writeString(name);
        out.writeString(device);
        out.writeLong(token);
    }
    // orphaned legacy method
    public RestoreSet createFromParcel(Parcel in) {
            return new RestoreSet(in);
        }
    
    // orphaned legacy method
    public RestoreSet[] newArray(int size) {
            return new RestoreSet[size];
        }
    
}

