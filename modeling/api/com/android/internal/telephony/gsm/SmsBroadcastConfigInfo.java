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


package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public final class SmsBroadcastConfigInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.768 -0500", hash_original_field = "EB30D6A69A78AF8AB364DD370D4AE145", hash_generated_field = "333B1EBCCD576A11F3929B04C911A0CC")

    private int fromServiceId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.771 -0500", hash_original_field = "3CC4D3E1B4F77F50D51F58346B2BC3D3", hash_generated_field = "21D520383BDB72483F46B478E9E8442E")

    private int toServiceId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.773 -0500", hash_original_field = "243A8D99C40969740A8266178D6D0C4E", hash_generated_field = "1C45CBAE9BFCDDAE4B54CFFD731AE53A")

    private int fromCodeScheme;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.775 -0500", hash_original_field = "917906B1289A7B05040C609631064DE9", hash_generated_field = "6C4271AD3AC2111E09C7BAF5CEECEDA7")

    private int toCodeScheme;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.777 -0500", hash_original_field = "8A82ABFB789DACD9C16E7861C3FFDBCE", hash_generated_field = "63F1085A29CC1E5353801D8BBF9C9BF5")

    private boolean selected;

    /**
     * Initialize the object from rssi and cid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.780 -0500", hash_original_method = "9D05E73016D00F2A428351060541CD33", hash_generated_method = "3B519C73BEB86A86B89C9FAC5054EC7A")
    
public SmsBroadcastConfigInfo(int fromId, int toId, int fromScheme,
            int toScheme, boolean selected) {
        fromServiceId = fromId;
        toServiceId = toId;
        fromCodeScheme = fromScheme;
        toCodeScheme = toScheme;
        this.selected = selected;
    }

    /**
     * @param fromServiceId the fromServiceId to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.783 -0500", hash_original_method = "EC03A9EAB74ED9CD08C5E767148A9E3D", hash_generated_method = "D939601DE953B980C1439B53C0C1E00D")
    
public void setFromServiceId(int fromServiceId) {
        this.fromServiceId = fromServiceId;
    }

    /**
     * @return the fromServiceId
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.785 -0500", hash_original_method = "000CFE123E4AC86430B83F6EA13C644C", hash_generated_method = "06D80871D93C0FECA5AFFF1D4C89C5F9")
    
public int getFromServiceId() {
        return fromServiceId;
    }

    /**
     * @param toServiceId the toServiceId to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.788 -0500", hash_original_method = "C662FD0745B0F3A8663C07D8F01AF54F", hash_generated_method = "79067789E19BDE1BDA5D0DC65ACE720F")
    
public void setToServiceId(int toServiceId) {
        this.toServiceId = toServiceId;
    }

    /**
     * @return the toServiceId
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.790 -0500", hash_original_method = "708E088605DA57A3DA16BEEB2BE47BA2", hash_generated_method = "4D34601116B76A9C44D59B4CC78B5007")
    
public int getToServiceId() {
        return toServiceId;
    }

    /**
     * @param fromCodeScheme the fromCodeScheme to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.792 -0500", hash_original_method = "0A2734671D04AE4B45C1C1B3377422E5", hash_generated_method = "05A9EA3AC441B6715DA5BB4F762FA284")
    
public void setFromCodeScheme(int fromCodeScheme) {
        this.fromCodeScheme = fromCodeScheme;
    }

    /**
     * @return the fromCodeScheme
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.794 -0500", hash_original_method = "7AEC5FB7E81910AF5A7A8C716EA8E7A5", hash_generated_method = "BF03F8B5D499ECB725C44BAD2E9EEE21")
    
public int getFromCodeScheme() {
        return fromCodeScheme;
    }

    /**
     * @param toCodeScheme the toCodeScheme to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.797 -0500", hash_original_method = "33ACE8C1E6B66F0AD44209B7329819FD", hash_generated_method = "B45A9054FE587D54AD0194AC1EF2A2F7")
    
public void setToCodeScheme(int toCodeScheme) {
        this.toCodeScheme = toCodeScheme;
    }

    /**
     * @return the toCodeScheme
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.799 -0500", hash_original_method = "70F3C47437BA22E7BE36EFF6F1AA8F5B", hash_generated_method = "2F2A70E3835D925BF0181FB345693EAD")
    
public int getToCodeScheme() {
        return toCodeScheme;
    }

    /**
     * @param selected the selected to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.802 -0500", hash_original_method = "F22B16E73947604A26216421AD1B5C38", hash_generated_method = "A0E75742062EE739971655BEADBE86AC")
    
public void setSelected(boolean selected) {
        this.selected = selected;
    }

    /**
     * @return the selected
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.804 -0500", hash_original_method = "4072656BD90ABB561422ECCC238321A3", hash_generated_method = "13DE1CEC193185973CDB1D073F60C2BC")
    
public boolean isSelected() {
        return selected;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.806 -0500", hash_original_method = "7023ED8B006DA79CC4837559B31EDFCC", hash_generated_method = "F8E3453FC5EF80C13752A12C89B0C95D")
    
@Override
    public String toString() {
        return "SmsBroadcastConfigInfo: Id [" +
                fromServiceId + ',' + toServiceId + "] Code [" +
                fromCodeScheme + ',' + toCodeScheme + "] " +
            (selected ? "ENABLED" : "DISABLED");
    }
    
}

