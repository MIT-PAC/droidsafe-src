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


package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.telephony.PhoneNumberUtils;

import com.android.internal.telephony.GsmAlphabet;
import com.android.internal.telephony.SmsAddress;

public class GsmSmsAddress extends SmsAddress {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:21.633 -0500", hash_original_field = "18DA9B883CBAF7214F059A4E280D4E9A", hash_generated_field = "BAEAAA3B1617171D1C1E99BC0FAB1BFC")

    static final int OFFSET_ADDRESS_LENGTH = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:21.636 -0500", hash_original_field = "9E47FBBB53AF74FDF2F28F097B14D2E3", hash_generated_field = "7FDA3A692BC2298A10BEE7791ED6AD24")

    static final int OFFSET_TOA = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:21.638 -0500", hash_original_field = "E8F4F7484EB3F156514A17792BA2EDD6", hash_generated_field = "E0E5804158D85D8E1B3FA048EFDDDD90")

    static final int OFFSET_ADDRESS_VALUE = 2;

    /**
     * New GsmSmsAddress from TS 23.040 9.1.2.5 Address Field
     *
     * @param offset the offset of the Address-Length byte
     * @param length the length in bytes rounded up, e.g. "2 +
     *        (addressLength + 1) / 2"
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:21.641 -0500", hash_original_method = "A0B07CD6AB37B7B30863E7D1CAF36981", hash_generated_method = "5DFF62CE6B9C14D1C45D38C7C356DD12")
    
public GsmSmsAddress(byte[] data, int offset, int length) {
        origBytes = new byte[length];
        System.arraycopy(data, offset, origBytes, 0, length);

        // addressLength is the count of semi-octets, not bytes
        int addressLength = origBytes[OFFSET_ADDRESS_LENGTH] & 0xff;

        int toa = origBytes[OFFSET_TOA] & 0xff;
        ton = 0x7 & (toa >> 4);

        // TOA must have its high bit set
        if ((toa & 0x80) != 0x80) {
            throw new RuntimeException("Invalid TOA - high bit must be set");
        }

        if (isAlphanumeric()) {
            // An alphanumeric address
            int countSeptets = addressLength * 4 / 7;

            address = GsmAlphabet.gsm7BitPackedToString(origBytes,
                    OFFSET_ADDRESS_VALUE, countSeptets);
        } else {
            // TS 23.040 9.1.2.5 says
            // that "the MS shall interpret reserved values as 'Unknown'
            // but shall store them exactly as received"

            byte lastByte = origBytes[length - 1];

            if ((addressLength & 1) == 1) {
                // Make sure the final unused BCD digit is 0xf
                origBytes[length - 1] |= 0xf0;
            }
            address = PhoneNumberUtils.calledPartyBCDToString(origBytes,
                    OFFSET_TOA, length - OFFSET_TOA);

            // And restore origBytes
            origBytes[length - 1] = lastByte;
        }
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:21.644 -0500", hash_original_method = "EAD8B5BB0DBAF5034E5C9FE6C7B0909A", hash_generated_method = "16A98D98BF22E2226CA4E552EBC9B9DF")
    
public String getAddressString() {
        return address;
    }

    /**
     * Returns true if this is an alphanumeric address
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:21.646 -0500", hash_original_method = "364284D6387231DFE8BEB00860E244AE", hash_generated_method = "94FCF7D6584B29E11994CD05B47D594C")
    
public boolean isAlphanumeric() {
        return ton == TON_ALPHANUMERIC;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:21.648 -0500", hash_original_method = "9A297062C2D2EDFA0EA27742D0F1F520", hash_generated_method = "4702E1F913E3FD9A825CCD513A01703B")
    
public boolean isNetworkSpecific() {
        return ton == TON_NETWORK;
    }

    /**
     * Returns true of this is a valid CPHS voice message waiting indicator
     * address
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:21.651 -0500", hash_original_method = "7BECB9552858FA87C7AFE2E5228279B4", hash_generated_method = "A92CF9911E7F488800E294D71D407FCD")
    
public boolean isCphsVoiceMessageIndicatorAddress() {
        // CPHS-style MWI message
        // See CPHS 4.7 B.4.2.1
        //
        // Basically:
        //
        // - Originating address should be 4 bytes long and alphanumeric
        // - Decode will result with two chars:
        // - Char 1
        // 76543210
        // ^ set/clear indicator (0 = clear)
        // ^^^ type of indicator (000 = voice)
        // ^^^^ must be equal to 0001
        // - Char 2:
        // 76543210
        // ^ line number (0 = line 1)
        // ^^^^^^^ set to 0
        //
        // Remember, since the alpha address is stored in 7-bit compact form,
        // the "line number" is really the top bit of the first address value
        // byte

        return (origBytes[OFFSET_ADDRESS_LENGTH] & 0xff) == 4
                && isAlphanumeric() && (origBytes[OFFSET_TOA] & 0x0f) == 0;
    }

    /**
     * Returns true if this is a valid CPHS voice message waiting indicator
     * address indicating a "set" of "indicator 1" of type "voice message
     * waiting"
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:21.654 -0500", hash_original_method = "4D79B8C2A51115F6F438822C99644146", hash_generated_method = "86F79CBB124E16917B7A1AE7C11CD87B")
    
public boolean isCphsVoiceMessageSet() {
        // 0x11 means "set" "voice message waiting" "indicator 1"
        return isCphsVoiceMessageIndicatorAddress()
                && (origBytes[OFFSET_ADDRESS_VALUE] & 0xff) == 0x11;

    }

    /**
     * Returns true if this is a valid CPHS voice message waiting indicator
     * address indicating a "clear" of "indicator 1" of type "voice message
     * waiting"
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:21.657 -0500", hash_original_method = "4C77C20AE3A5F3CC1A1FB56D13643756", hash_generated_method = "3C47A8B9F98A0EC35EE39FB32875C58F")
    
public boolean isCphsVoiceMessageClear() {
        // 0x10 means "clear" "voice message waiting" "indicator 1"
        return isCphsVoiceMessageIndicatorAddress()
                && (origBytes[OFFSET_ADDRESS_VALUE] & 0xff) == 0x10;

    }
}

