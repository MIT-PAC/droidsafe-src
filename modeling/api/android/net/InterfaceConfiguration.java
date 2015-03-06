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
 * Copyright (C) 2008 The Android Open Source Project
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


package android.net;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.Parcelable;
import android.os.Parcel;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * A simple object for retrieving / setting an interfaces configuration
 * @hide
 */
public class InterfaceConfiguration implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:13.705 -0400", hash_original_field = "816B3E8E6D6EF3708A93ED8DBBCA8ED6", hash_generated_field = "924A8CD5A96A3BE37991179726ACCBFD")

    public static final Creator<InterfaceConfiguration> CREATOR =
        new Creator<InterfaceConfiguration>() {
            @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:20.731 -0400", hash_original_method = "76C6CBF6FE2D5EB36C73B2620657A1AC", hash_generated_method = "4D05993755407010E5072F2053E009C7")
        
public InterfaceConfiguration createFromParcel(Parcel in) {
                InterfaceConfiguration info = new InterfaceConfiguration();
                info.hwAddr = in.readString();
                if (in.readByte() == 1) {
                    info.addr = in.readParcelable(null);
                }
                info.interfaceFlags = in.readString();
                return info;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:20.732 -0400", hash_original_method = "9F99AD90A41C85329A32DABBF90EC240", hash_generated_method = "8921B33319AE1F1D8C9DBB71F3C379A9")
        
public InterfaceConfiguration[] newArray(int size) {
                return new InterfaceConfiguration[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:13.683 -0400", hash_original_field = "8FB3E1ED35B5E9BC5D6A5E28C5D0E519", hash_generated_field = "655C83DA1C8B411C7D6F796ACBC6672E")

    public String hwAddr;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:13.685 -0400", hash_original_field = "4CAB5FA4C5E1E75EA0C6680674F3C642", hash_generated_field = "C9AD81BC20853ECB1F7187EF6944F092")

    public LinkAddress addr;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:13.687 -0400", hash_original_field = "CB9859CD31BC4CEE77034D030468EA14", hash_generated_field = "8898CF9A177D041C1324C96C724720D8")

    public String interfaceFlags;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:13.689 -0400", hash_original_method = "523C01300D35910BBD3295D95AC6D51D", hash_generated_method = "B3E68325E7C854EFD956E051BD393275")
    
public InterfaceConfiguration() {
        super();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:13.691 -0400", hash_original_method = "B449045062EB1726128DB5FDD6056851", hash_generated_method = "A9C8BAF46537E7AC7B16260A7B552BC1")
    
public String toString() {
        StringBuffer str = new StringBuffer();

        str.append("ipddress ");
        str.append((addr != null) ? addr.toString() : "NULL");
        str.append(" flags ").append(interfaceFlags);
        str.append(" hwaddr ").append(hwAddr);

        return str.toString();
    }

    /**
     * This function determines if the interface is up and has a valid IP
     * configuration (IP address has a non zero octet).
     *
     * Note: It is supposed to be quick and hence should not initiate
     * any network activity
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:13.693 -0400", hash_original_method = "89519989C64AB37C48D4072AC076DB7C", hash_generated_method = "A439B0DB4788FA6A803A254DC7A5267C")
    
public boolean isActive() {
        try {
            if(interfaceFlags.contains("up")) {
                for (byte b : addr.getAddress().getAddress()) {
                    if (b != 0) return true;
                }
            }
        } catch (NullPointerException e) {
            return false;
        }
        return false;
    }

    /** Implement the Parcelable interface {@hide} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:13.695 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    /** Implement the Parcelable interface {@hide} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:13.697 -0400", hash_original_method = "C5F6FC8AC46A0C5D042C15C1BC88CD0B", hash_generated_method = "3988DA642896072B1F5C2F50E479051D")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(hwAddr);
        if (addr != null) {
            dest.writeByte((byte)1);
            dest.writeParcelable(addr, flags);
        } else {
            dest.writeByte((byte)0);
        }
        dest.writeString(interfaceFlags);
    }
}
