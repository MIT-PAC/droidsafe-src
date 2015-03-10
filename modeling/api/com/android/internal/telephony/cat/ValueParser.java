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
 * Copyright (C) 2006-2007 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.android.internal.telephony.GsmAlphabet;
import com.android.internal.telephony.IccUtils;
import com.android.internal.telephony.cat.Duration.TimeUnit;

abstract class ValueParser {

    /**
     * Search for a Command Details object from a list.
     *
     * @param ctlvs List of ComprehensionTlv objects used for search
     * @return An CtlvCommandDetails object found from the objects. If no
     *         Command Details object is found, ResultException is thrown.
     * @throws ResultException
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.788 -0500", hash_original_method = "6AE2D5DA6C5F460EE4B46BC785279C7C", hash_generated_method = "07B2A188896D620B2AEF2081BDEE7294")
    
static CommandDetails retrieveCommandDetails(ComprehensionTlv ctlv)
            throws ResultException {

        CommandDetails cmdDet = new CommandDetails();
        byte[] rawValue = ctlv.getRawValue();
        int valueIndex = ctlv.getValueIndex();
        try {
            cmdDet.compRequired = ctlv.isComprehensionRequired();
            cmdDet.commandNumber = rawValue[valueIndex] & 0xff;
            cmdDet.typeOfCommand = rawValue[valueIndex + 1] & 0xff;
            cmdDet.commandQualifier = rawValue[valueIndex + 2] & 0xff;
            return cmdDet;
        } catch (IndexOutOfBoundsException e) {
            throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
        }
    }

    /**
     * Search for a Device Identities object from a list.
     *
     * @param ctlvs List of ComprehensionTlv objects used for search
     * @return An CtlvDeviceIdentities object found from the objects. If no
     *         Command Details object is found, ResultException is thrown.
     * @throws ResultException
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.791 -0500", hash_original_method = "71A21439D49BE4DC675A1D07C5085E0D", hash_generated_method = "4EA9082D3B18CDF043CA61C90B966003")
    
static DeviceIdentities retrieveDeviceIdentities(ComprehensionTlv ctlv)
            throws ResultException {

        DeviceIdentities devIds = new DeviceIdentities();
        byte[] rawValue = ctlv.getRawValue();
        int valueIndex = ctlv.getValueIndex();
        try {
            devIds.sourceId = rawValue[valueIndex] & 0xff;
            devIds.destinationId = rawValue[valueIndex + 1] & 0xff;
            return devIds;
        } catch (IndexOutOfBoundsException e) {
            throw new ResultException(ResultCode.REQUIRED_VALUES_MISSING);
        }
    }

    /**
     * Retrieves Duration information from the Duration COMPREHENSION-TLV
     * object.
     *
     * @param ctlv A Text Attribute COMPREHENSION-TLV object
     * @return A Duration object
     * @throws ResultException
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.793 -0500", hash_original_method = "60F0F464B613534040B157E1C2112C00", hash_generated_method = "E7F46C5369B89F2355684BABFAC81CB3")
    
static Duration retrieveDuration(ComprehensionTlv ctlv) throws ResultException {
        int timeInterval = 0;
        TimeUnit timeUnit = TimeUnit.SECOND;

        byte[] rawValue = ctlv.getRawValue();
        int valueIndex = ctlv.getValueIndex();

        try {
            timeUnit = TimeUnit.values()[(rawValue[valueIndex] & 0xff)];
            timeInterval = rawValue[valueIndex + 1] & 0xff;
        } catch (IndexOutOfBoundsException e) {
            throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
        }
        return new Duration(timeInterval, timeUnit);
    }

    /**
     * Retrieves Item information from the COMPREHENSION-TLV object.
     *
     * @param ctlv A Text Attribute COMPREHENSION-TLV object
     * @return An Item
     * @throws ResultException
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.796 -0500", hash_original_method = "152402B1F19F5AF3A149355992289F4E", hash_generated_method = "5A7C233B5CE9F29C1DD832CCE8FC99D4")
    
static Item retrieveItem(ComprehensionTlv ctlv) throws ResultException {
        Item item = null;

        byte[] rawValue = ctlv.getRawValue();
        int valueIndex = ctlv.getValueIndex();
        int length = ctlv.getLength();

        if (length != 0) {
            int textLen = length - 1;

            try {
                int id = rawValue[valueIndex] & 0xff;
                String text = IccUtils.adnStringFieldToString(rawValue,
                        valueIndex + 1, textLen);
                item = new Item(id, text);
            } catch (IndexOutOfBoundsException e) {
                throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
            }
        }

        return item;
    }

    /**
     * Retrieves Item id information from the COMPREHENSION-TLV object.
     *
     * @param ctlv A Text Attribute COMPREHENSION-TLV object
     * @return An Item id
     * @throws ResultException
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.799 -0500", hash_original_method = "327E65F268062B661107B9088D7D6DB0", hash_generated_method = "394814D2A6BAF01CA9935D76F60C042A")
    
static int retrieveItemId(ComprehensionTlv ctlv) throws ResultException {
        int id = 0;

        byte[] rawValue = ctlv.getRawValue();
        int valueIndex = ctlv.getValueIndex();

        try {
            id = rawValue[valueIndex] & 0xff;
        } catch (IndexOutOfBoundsException e) {
            throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
        }

        return id;
    }

    /**
     * Retrieves icon id from an Icon Identifier COMPREHENSION-TLV object
     *
     * @param ctlv An Icon Identifier COMPREHENSION-TLV object
     * @return IconId instance
     * @throws ResultException
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.801 -0500", hash_original_method = "31E51BFBE155FA06FC60503CF7989650", hash_generated_method = "2D5C1ACFC7853CCB44D8E6BD90E832BB")
    
static IconId retrieveIconId(ComprehensionTlv ctlv) throws ResultException {
        IconId id = new IconId();

        byte[] rawValue = ctlv.getRawValue();
        int valueIndex = ctlv.getValueIndex();
        try {
            id.selfExplanatory = (rawValue[valueIndex++] & 0xff) == 0x00;
            id.recordNumber = rawValue[valueIndex] & 0xff;
        } catch (IndexOutOfBoundsException e) {
            throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
        }

        return id;
    }

    /**
     * Retrieves item icons id from an Icon Identifier List COMPREHENSION-TLV
     * object
     *
     * @param ctlv An Item Icon List Identifier COMPREHENSION-TLV object
     * @return ItemsIconId instance
     * @throws ResultException
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.804 -0500", hash_original_method = "30C4B6CD40D711382C087F999961E577", hash_generated_method = "DA61DAAA30AE3E61CF44B7B5BEA9107D")
    
static ItemsIconId retrieveItemsIconId(ComprehensionTlv ctlv)
            throws ResultException {
        CatLog.d("ValueParser", "retrieveItemsIconId:");
        ItemsIconId id = new ItemsIconId();

        byte[] rawValue = ctlv.getRawValue();
        int valueIndex = ctlv.getValueIndex();
        int numOfItems = ctlv.getLength() - 1;
        id.recordNumbers = new int[numOfItems];

        try {
            // get icon self-explanatory
            id.selfExplanatory = (rawValue[valueIndex++] & 0xff) == 0x00;

            for (int index = 0; index < numOfItems;) {
                id.recordNumbers[index++] = rawValue[valueIndex++];
            }
        } catch (IndexOutOfBoundsException e) {
            throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
        }
        return id;
    }

    /**
     * Retrieves text attribute information from the Text Attribute
     * COMPREHENSION-TLV object.
     *
     * @param ctlv A Text Attribute COMPREHENSION-TLV object
     * @return A list of TextAttribute objects
     * @throws ResultException
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.807 -0500", hash_original_method = "D4116A9C3735B3F595194F995C84896F", hash_generated_method = "79801730538B34C12C03F956F4749FAF")
    
static List<TextAttribute> retrieveTextAttribute(ComprehensionTlv ctlv)
            throws ResultException {
        ArrayList<TextAttribute> lst = new ArrayList<TextAttribute>();

        byte[] rawValue = ctlv.getRawValue();
        int valueIndex = ctlv.getValueIndex();
        int length = ctlv.getLength();

        if (length != 0) {
            // Each attribute is consisted of four bytes
            int itemCount = length / 4;

            try {
                for (int i = 0; i < itemCount; i++, valueIndex += 4) {
                    int start = rawValue[valueIndex] & 0xff;
                    int textLength = rawValue[valueIndex + 1] & 0xff;
                    int format = rawValue[valueIndex + 2] & 0xff;
                    int colorValue = rawValue[valueIndex + 3] & 0xff;

                    int alignValue = format & 0x03;
                    TextAlignment align = TextAlignment.fromInt(alignValue);

                    int sizeValue = (format >> 2) & 0x03;
                    FontSize size = FontSize.fromInt(sizeValue);
                    if (size == null) {
                        // Font size value is not defined. Use default.
                        size = FontSize.NORMAL;
                    }

                    boolean bold = (format & 0x10) != 0;
                    boolean italic = (format & 0x20) != 0;
                    boolean underlined = (format & 0x40) != 0;
                    boolean strikeThrough = (format & 0x80) != 0;

                    TextColor color = TextColor.fromInt(colorValue);

                    TextAttribute attr = new TextAttribute(start, textLength,
                            align, size, bold, italic, underlined,
                            strikeThrough, color);
                    lst.add(attr);
                }

                return lst;

            } catch (IndexOutOfBoundsException e) {
                throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
            }
        }
        return null;
    }

    /**
     * Retrieves alpha identifier from an Alpha Identifier COMPREHENSION-TLV
     * object.
     *
     * @param ctlv An Alpha Identifier COMPREHENSION-TLV object
     * @return String corresponding to the alpha identifier
     * @throws ResultException
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.809 -0500", hash_original_method = "B98E5D45204294650F3F1CE04E4B9F56", hash_generated_method = "6DB0E7689EB3EEE02057D1BF22BCF5E0")
    
static String retrieveAlphaId(ComprehensionTlv ctlv) throws ResultException {

        if (ctlv != null) {
            byte[] rawValue = ctlv.getRawValue();
            int valueIndex = ctlv.getValueIndex();
            int length = ctlv.getLength();
            if (length != 0) {
                try {
                    return IccUtils.adnStringFieldToString(rawValue, valueIndex,
                            length);
                } catch (IndexOutOfBoundsException e) {
                    throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
                }
            } else {
                return CatService.STK_DEFAULT;
            }
        } else {
            return CatService.STK_DEFAULT;
        }
    }

    /**
     * Retrieves text from the Text COMPREHENSION-TLV object, and decodes it
     * into a Java String.
     *
     * @param ctlv A Text COMPREHENSION-TLV object
     * @return A Java String object decoded from the Text object
     * @throws ResultException
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.813 -0500", hash_original_method = "3BCED7FFBE0FE784BA49584BB088736F", hash_generated_method = "A6D1542B468031E8023E6CF76568C729")
    
static String retrieveTextString(ComprehensionTlv ctlv) throws ResultException {
        byte[] rawValue = ctlv.getRawValue();
        int valueIndex = ctlv.getValueIndex();
        byte codingScheme = 0x00;
        String text = null;
        int textLen = ctlv.getLength();

        // In case the text length is 0, return a null string.
        if (textLen == 0) {
            return text;
        } else {
            // one byte is coding scheme
            textLen -= 1;
        }

        try {
            codingScheme = (byte) (rawValue[valueIndex] & 0x0c);

            if (codingScheme == 0x00) { // GSM 7-bit packed
                text = GsmAlphabet.gsm7BitPackedToString(rawValue,
                        valueIndex + 1, (textLen * 8) / 7);
            } else if (codingScheme == 0x04) { // GSM 8-bit unpacked
                text = GsmAlphabet.gsm8BitUnpackedToString(rawValue,
                        valueIndex + 1, textLen);
            } else if (codingScheme == 0x08) { // UCS2
                text = new String(rawValue, valueIndex + 1, textLen, "UTF-16");
            } else {
                throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
            }

            return text;
        } catch (IndexOutOfBoundsException e) {
            throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
        } catch (UnsupportedEncodingException e) {
            // This should never happen.
            throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
        }
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:21.076 -0400", hash_original_method = "536C7A90AC0042B9CC31730ED4B5756F", hash_generated_method = "536C7A90AC0042B9CC31730ED4B5756F")
    public ValueParser ()
    {
        //Synthesized constructor
    }
    
}

