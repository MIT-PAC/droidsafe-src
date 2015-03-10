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


package android.accounts;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class Account implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:12.359 -0400", hash_original_field = "DE2599644EF9112EA03F6AEF302C05E0", hash_generated_field = "E8FF743E340A29709E9F49FE249853DC")

    public static final Creator<Account> CREATOR = new Creator<Account>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.375 -0500", hash_original_method = "71E28F2FAFB9F3EEB2F3FA6DF61F882A", hash_generated_method = "2EA57EEFF611B8231A465F9D9FB85EE1")
        
public Account createFromParcel(Parcel source) {
            return new Account(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.378 -0500", hash_original_method = "0C51DAE4A68DBFF5A186B7DE414E81B4", hash_generated_method = "F13E62DB4EE6A9D9D452A167FBD24B07")
        
public Account[] newArray(int size) {
            return new Account[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.353 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

    public  String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.356 -0500", hash_original_field = "1B03D0EF3E71EB350936336F82D5E0C5", hash_generated_field = "7BA709B14E744AD5C81755E81EB9D05D")

    public  String type;

    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.365 -0500", hash_original_method = "92321A38B636724882B81077847DFFEE", hash_generated_method = "F048E77C9215A8AF9B03F89C76A7DD3C")
    
public Account(String name, String type) {
        if (TextUtils.isEmpty(name)) {
            throw new IllegalArgumentException("the name must not be empty: " + name);
        }
        if (TextUtils.isEmpty(type)) {
            throw new IllegalArgumentException("the type must not be empty: " + type);
        }
        this.name = name;
        this.type = type;
    }

    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.367 -0500", hash_original_method = "634539653E1462125AEF6C008057544F", hash_generated_method = "FC9CA9A81C9A52928A015565A6C91A13")
    
public Account(Parcel in) {
        this.name = in.readString();
        this.type = in.readString();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.359 -0500", hash_original_method = "8952178E80D6EF68D44FC6803A31AC53", hash_generated_method = "E11F1B2B48F4426422AA38A1FF583D29")
    
public boolean equals(Object o) {
        return (((o.getTaintInt() + getTaintInt())) == 1);
        /*
        if (o == this) return true;
        if (!(o instanceof Account)) return false;
        final Account other = (Account)o;
        return name.equals(other.name) && type.equals(other.type);
        */
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.362 -0500", hash_original_method = "2D8E3835F41EEE5A0134485B603913A1", hash_generated_method = "FC220BBEAC6B827E0FEF5853192F624B")
    
public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.370 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.372 -0500", hash_original_method = "5E35BE18734E956B072A3A591EB1639E", hash_generated_method = "D9A022F5156B61E8B9CBDE5DB3521B6C")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(type);
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.382 -0500", hash_original_method = "E40D22A387A231E7FC5FB70BCBB60906", hash_generated_method = "7190CE6F6B01E485C4D2655A294C13CC")
    
public String toString() {
        return "Account {name=" + name + ", type=" + type + "}";
    }
    // orphaned legacy method
    public Account createFromParcel(Parcel source) {
            return new Account(source);
        }
    
    // orphaned legacy method
    public Account[] newArray(int size) {
            return new Account[size];
        }
    
}

