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


package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;

public class Duration implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.245 -0400", hash_original_field = "A45E48454A5718B4D58B745F8A75DBD7", hash_generated_field = "3313211CC65C61401C6638CF5336E71F")

    public static final Parcelable.Creator<Duration> CREATOR = new Parcelable.Creator<Duration>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.582 -0500", hash_original_method = "68D9516041C92E7EB281A6DDCC1708DE", hash_generated_method = "5144F18F3E73DCB13D888D29E8A3E2DC")
        
public Duration createFromParcel(Parcel in) {
            return new Duration(in);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.584 -0500", hash_original_method = "FA2B9C14FB9C286DB1C90150CBF11069", hash_generated_method = "9F25EF6DC2491ED70C1EC507AB275ADF")
        
public Duration[] newArray(int size) {
            return new Duration[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.557 -0500", hash_original_field = "13D63EDCAAEDDF154A09ADC3CD7EFCBE", hash_generated_field = "35448C58A22DDC559F47B71F64B98655")

    public int timeInterval;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.559 -0500", hash_original_field = "5160C4F9E1C0ECDFA8C96CDFDC93A706", hash_generated_field = "E104F5569DCF2B31AE0BB025718138E9")

    public TimeUnit timeUnit;

    /**
     * @param timeInterval Between 1 and 255 inclusive.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.571 -0500", hash_original_method = "49A364E6511EE6731DA0B9EFBCF0B191", hash_generated_method = "2019A6F8728EBD2152D5C1E4EA010BAC")
    
public Duration(int timeInterval, TimeUnit timeUnit) {
        this.timeInterval = timeInterval;
        this.timeUnit = timeUnit;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.574 -0500", hash_original_method = "69931BD60CFF69C2725A634D6D46CC0C", hash_generated_method = "845498D2971A8F56D26B3F75057AB4B5")
    
private Duration(Parcel in) {
        timeInterval = in.readInt();
        timeUnit = TimeUnit.values()[in.readInt()];
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.576 -0500", hash_original_method = "7A3E2E3AAE56FB706A1FF7E711848E72", hash_generated_method = "DECBA15ED6F586EFCCA8B3CD85843707")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(timeInterval);
        dest.writeInt(timeUnit.ordinal());
    }
    
    public enum TimeUnit {
        MINUTE(0x00),
        SECOND(0x01),
        TENTH_SECOND(0x02);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.562 -0500", hash_original_field = "177FAFFA7A38FCF6D55DEE4AFF0E6CEC", hash_generated_field = "1FE26AAF0F7068BF50C3FDD7D6BD850D")

        private int mValue;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.565 -0500", hash_original_method = "4E0A317716E60B3858321F9D13157B8E", hash_generated_method = "4E0A317716E60B3858321F9D13157B8E")
            
TimeUnit(int value) {
            mValue = value;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.568 -0500", hash_original_method = "27017A4BB2548485661BB15426A7D88C", hash_generated_method = "830F464825E9198C7936F8382B630542")
            
public int value() {
            return mValue;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.578 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }
}

