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
** Copyright 2007, The Android Open Source Project
**
** Licensed under the Apache License, Version 2.0 (the "License");
** you may not use this file except in compliance with the License.
** You may obtain a copy of the License at
**
**     http://www.apache.org/licenses/LICENSE-2.0
**
** Unless required by applicable law or agreed to in writing, software
** distributed under the License is distributed on an "AS IS" BASIS,
** WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
** See the License for the specific language governing permissions and
** limitations under the License.
*/



/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;

public class SmsRawData implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.300 -0400", hash_original_field = "5F248018C4F105B9FC6BE9470BA097DB", hash_generated_field = "AED96BE50F57834351625E8AF71D8275")

    public static final Parcelable.Creator<SmsRawData> CREATOR
            = new Parcelable.Creator<SmsRawData> (){
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.214 -0500", hash_original_method = "F1422F1901EE9861E97E875C16081393", hash_generated_method = "CC2AE54837ED271F414AE0BE9B40DF87")
        
public SmsRawData createFromParcel(Parcel source) {
            int size;
            size = source.readInt();
            byte[] data = new byte[size];
            source.readByteArray(data);
            return new SmsRawData(data);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.217 -0500", hash_original_method = "A7CDF66D285B3D1FAFEC746019F799D8", hash_generated_method = "3270F6E6E837B0086218DA03B43A620B")
        
public SmsRawData[] newArray(int size) {
            return new SmsRawData[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.210 -0500", hash_original_field = "B330DF564CD90A5498A9E4F0AB344BB9", hash_generated_field = "B330DF564CD90A5498A9E4F0AB344BB9")

    byte[] data;

    // Constructor
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.223 -0500", hash_original_method = "786E0C6936F82B829DA5B3FF66BF9330", hash_generated_method = "A05FAFF842B04C1718E224ACB930FC77")
    
public SmsRawData(byte[] data) {
        this.data = data;
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.225 -0500", hash_original_method = "A347A6B90A5D4D940F0721005973D58D", hash_generated_method = "3C7438C8A4069E5C199E2D48F79B0806")
    
public byte[] getBytes() {
        return data;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.228 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.230 -0500", hash_original_method = "D4C3CA886CA029713C39962D7FB3C06B", hash_generated_method = "7D70EC3F42867245D2B569BE15182600")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(data.length);
        dest.writeByteArray(data);
    }
    // orphaned legacy method
    public SmsRawData createFromParcel(Parcel source) {
            int size;
            size = source.readInt();
            byte[] data = new byte[size];
            source.readByteArray(data);
            return new SmsRawData(data);
        }
    
    // orphaned legacy method
    public SmsRawData[] newArray(int size) {
            return new SmsRawData[size];
        }
    
}

