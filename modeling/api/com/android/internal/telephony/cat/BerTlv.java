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
import java.util.List;

class BerTlv {

    /**
     * Decodes a BER-TLV object from a byte array.
     *
     * @param data A byte array to decode from
     * @return A BER-TLV object decoded
     * @throws ResultException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.221 -0500", hash_original_method = "FE58CB5D6CE6A2E9688AD17CCBB6B897", hash_generated_method = "8496BD84730B5DD604BC36EA0D058875")
    
public static BerTlv decode(byte[] data) throws ResultException {
        int curIndex = 0;
        int endIndex = data.length;
        int tag, length = 0;

        try {
            /* tag */
            tag = data[curIndex++] & 0xff;
            if (tag == BER_PROACTIVE_COMMAND_TAG) {
                /* length */
                int temp = data[curIndex++] & 0xff;
                if (temp < 0x80) {
                    length = temp;
                } else if (temp == 0x81) {
                    temp = data[curIndex++] & 0xff;
                    if (temp < 0x80) {
                        throw new ResultException(
                                ResultCode.CMD_DATA_NOT_UNDERSTOOD);
                    }
                    length = temp;
                } else {
                    throw new ResultException(
                            ResultCode.CMD_DATA_NOT_UNDERSTOOD);
                }
            } else {
                if (ComprehensionTlvTag.COMMAND_DETAILS.value() == (tag & ~0x80)) {
                    tag = BER_UNKNOWN_TAG;
                    curIndex = 0;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            throw new ResultException(ResultCode.REQUIRED_VALUES_MISSING);
        } catch (ResultException e) {
            throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
        }

        /* COMPREHENSION-TLVs */
        if (endIndex - curIndex < length) {
            throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
        }

        List<ComprehensionTlv> ctlvs = ComprehensionTlv.decodeMany(data,
                curIndex);

        return new BerTlv(tag, ctlvs);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.202 -0500", hash_original_field = "E46564801AB3D6DC8660EAD1318E8D77", hash_generated_field = "51019AD6C5CC55D9C6AF4E6FA65C2CFC")

    public static final int BER_UNKNOWN_TAG             = 0x00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.205 -0500", hash_original_field = "A5F484D7C9AC31A97C300F3A238CA40B", hash_generated_field = "849EF9FE5E783A4D18EB93EBEF07AF92")

    public static final int BER_PROACTIVE_COMMAND_TAG   = 0xd0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.208 -0500", hash_original_field = "C8240165FD441B09DBE910D691692579", hash_generated_field = "FD25A090599EDE67E1DA85645D40DBBC")

    public static final int BER_MENU_SELECTION_TAG      = 0xd3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.210 -0500", hash_original_field = "AC9FA17127F7E94BAD1D9D7BB524A7A4", hash_generated_field = "037978F26D244A2F18B40FEF8C880C0F")

    public static final int BER_EVENT_DOWNLOAD_TAG      = 0xd6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.197 -0500", hash_original_field = "38F5E2CF6A68114F4D07368E8CD18F7D", hash_generated_field = "39FE9CD97B9AFEAEBF1F07C1BE8432FF")

    private int mTag = BER_UNKNOWN_TAG;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.199 -0500", hash_original_field = "6A32C99C41F706EBDBE246DB753FB229", hash_generated_field = "D44204BE63F06CA8F47FCF402390D741")

    private List<ComprehensionTlv> mCompTlvs = null;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.213 -0500", hash_original_method = "5C874FE61091A7FA99CA633BD5413E3E", hash_generated_method = "7792EFE71B80E06007BBB19FC27A915F")
    
private BerTlv(int tag, List<ComprehensionTlv> ctlvs) {
        mTag = tag;
        mCompTlvs = ctlvs;
    }

    /**
     * Gets a list of ComprehensionTlv objects contained in this BER-TLV object.
     *
     * @return A list of COMPREHENSION-TLV object
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.215 -0500", hash_original_method = "4DB54AB9F503DA894E5725BF1F0BC01C", hash_generated_method = "31036B0C79BC3AE7FC0A6AE828E11749")
    
public List<ComprehensionTlv> getComprehensionTlvs() {
        return mCompTlvs;
    }

    /**
     * Gets a tag id of the BER-TLV object.
     *
     * @return A tag integer.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.217 -0500", hash_original_method = "F4331D0775C023B121D08D63B25AAACE", hash_generated_method = "92179372CE49E6423B644726BDCEE63E")
    
public int getTag() {
        return mTag;
    }
}

