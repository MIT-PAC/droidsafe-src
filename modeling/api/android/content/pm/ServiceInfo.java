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


package android.content.pm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Printer;

public class ServiceInfo extends ComponentInfo implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.873 -0500", hash_original_field = "C7C0637C46F344602F3BBA0296ACE08D", hash_generated_field = "BCFC88EA4A2C840BDC8017A6371C1D0B")

    public static final int FLAG_STOP_WITH_TASK = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.708 -0400", hash_original_field = "0617EC2A993DE099179336515C76721A", hash_generated_field = "3C5616FB8F531F1B5A69F671577BAF41")

    public static final Creator<ServiceInfo> CREATOR =
        new Creator<ServiceInfo>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.891 -0500", hash_original_method = "8978DD753FD4CAD4F30EAB16B876BC2A", hash_generated_method = "9BF65EB054B247A0818D16F348DD5D11")
        
public ServiceInfo createFromParcel(Parcel source) {
            return new ServiceInfo(source);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.894 -0500", hash_original_method = "A983BB1A64296EC543A70CA925936DDB", hash_generated_method = "B37CFDF0F34099E8B5BF731DF89760DD")
        
public ServiceInfo[] newArray(int size) {
            return new ServiceInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.870 -0500", hash_original_field = "6CAD99B186075AF38B34666A3804B23C", hash_generated_field = "3670CE1CBA400C10EB64B3D7DD616511")

    public String permission;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.875 -0500", hash_original_field = "E0CDE1A38A40425C446F52269E5723DC", hash_generated_field = "06C062A47B4E980AE7B4928732A7AB14")

    public int flags;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.877 -0500", hash_original_method = "F8437ACFEC0EA098621A29EA36F6AD07", hash_generated_method = "CD2038A4FA51EE8D98D0458B3EFA463A")
    
public ServiceInfo() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.879 -0500", hash_original_method = "FE9252C5AEDF7EDCC5A8663E23AE8AA0", hash_generated_method = "F747DDC11F6DBB4835D8388B8D559EDA")
    
public ServiceInfo(ServiceInfo orig) {
        super(orig);
        permission = orig.permission;
        flags = orig.flags;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.899 -0500", hash_original_method = "03E698CAC1E21FAA46C8FF1C3071D430", hash_generated_method = "2FD656109B3013C5E4FDE714D28C7218")
    
private ServiceInfo(Parcel source) {
        super(source);
        permission = source.readString();
        flags = source.readInt();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.881 -0500", hash_original_method = "DA4A80B9AC3442B8DFBCD8315889AD94", hash_generated_method = "EB15B241B0E3029C6BA03D8227806BD3")
    
public void dump(Printer pw, String prefix) {
        super.dumpFront(pw, prefix);
        pw.println(prefix + "permission=" + permission);
        pw.println(prefix + "flags=0x" + Integer.toHexString(flags));
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.883 -0500", hash_original_method = "59146AE4B3130A7BADEE9DF4447D4A3B", hash_generated_method = "4F27970B040085460F0C06B7720A2D63")
    
public String toString() {
        return "ServiceInfo{"
            + Integer.toHexString(System.identityHashCode(this))
            + " " + name + "}";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.886 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.888 -0500", hash_original_method = "0D65CECC76E553C003E9EF65F2ADA018", hash_generated_method = "FBE9D1BF041597956272BE112BB8DFFD")
    
public void writeToParcel(Parcel dest, int parcelableFlags) {
        super.writeToParcel(dest, parcelableFlags);
        dest.writeString(permission);
        dest.writeInt(flags);
    }
    // orphaned legacy method
    public ServiceInfo createFromParcel(Parcel source) {
            return new ServiceInfo(source);
        }
    
    // orphaned legacy method
    public ServiceInfo[] newArray(int size) {
            return new ServiceInfo[size];
        }
    
}

