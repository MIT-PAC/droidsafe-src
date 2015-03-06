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

public enum Tone implements Parcelable {
    DIAL(0x01),
    BUSY(0x02),
    CONGESTION(0x03),
    RADIO_PATH_ACK(0x04),
    RADIO_PATH_NOT_AVAILABLE(0x05),
    ERROR_SPECIAL_INFO(0x06),
    CALL_WAITING(0x07),
    RINGING(0x08),
    GENERAL_BEEP(0x10),
    POSITIVE_ACK(0x11),
    NEGATIVE_ACK(0x12),
    INCOMING_SPEECH_CALL(0x13),
    INCOMING_SMS(0x14),
    CRITICAL_ALERT(0x15),
    VIBRATE_ONLY(0x20),
    HAPPY(0x30),
    SAD(0x31),
    URGENT(0x32),
    QUESTION(0x33),
    MESSAGE_RECEIVED(0x34),
    MELODY_1(0x40),
    MELODY_2(0x41),
    MELODY_3(0x42),
    MELODY_4(0x43),
    MELODY_5(0x44),
    MELODY_6(0x45),
    MELODY_7(0x46),
    MELODY_8(0x47);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.114 -0500", hash_original_field = "177FAFFA7A38FCF6D55DEE4AFF0E6CEC", hash_generated_field = "1FE26AAF0F7068BF50C3FDD7D6BD850D")

    private int mValue;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.116 -0500", hash_original_method = "BDBACB64D99DCF38AB2923A144B6C0E4", hash_generated_method = "BDBACB64D99DCF38AB2923A144B6C0E4")
        
Tone(int value) {
        mValue = value;
    }

    /**
     * Create a Tone object.
     * @param value Integer value to be converted to a Tone object.
     * @return Tone object whose value is {@code value}. If no Tone object has
     *         that value, null is returned.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.119 -0500", hash_original_method = "A970DDD7F2B2024DC5880E629D23445D", hash_generated_method = "C1E80BCA687F7EAAE8B43F6941DBB452")
        
public static Tone fromInt(int value) {
        for (Tone e : Tone.values()) {
            if (e.mValue == value) {
                return e;
            }
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.121 -0500", hash_original_method = "CA78CB088E4E888EDACE4E63A2BFC1CF", hash_generated_method = "CA78CB088E4E888EDACE4E63A2BFC1CF")
        
Tone(Parcel in) {
        mValue = in.readInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.124 -0500", hash_original_method = "4DEEB1638EE68640AE3E572B5E86410F", hash_generated_method = "817453A1E081B170BEDD24003987BF6D")
        
public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ordinal());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.127 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
        
public int describeContents() {
        return 0;
    }
    public static final Parcelable.Creator<Tone> CREATOR = new Parcelable.Creator<Tone>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.130 -0500", hash_original_method = "5C679EE782E7016A2A81EBD327549C98", hash_generated_method = "3BD7D2BD490A2DF77A538D482E32F6D6")
            
public Tone createFromParcel(Parcel in) {
            return Tone.values()[in.readInt()];
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.133 -0500", hash_original_method = "E970AED1E8618EE0FAF085CE748BBE1F", hash_generated_method = "B835ACBB3DF95673626D96D1EEE2BF37")
            
public Tone[] newArray(int size) {
            return new Tone[size];
        }
    };
}
