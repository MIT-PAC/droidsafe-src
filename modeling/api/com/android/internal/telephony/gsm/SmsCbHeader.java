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
 * Copyright (C) 2010 The Android Open Source Project
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
import android.telephony.SmsCbConstants;

public class SmsCbHeader implements SmsCbConstants {

    /**
     * Return whether the specified message ID is an emergency (PWS) message type.
     * This method is static and takes an argument so that it can be used by
     * CellBroadcastReceiver, which stores message ID's in SQLite rather than PDU.
     * @param id the message identifier to check
     * @return true if the message is emergency type; false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.594 -0500", hash_original_method = "C914D7E35A4624471549A0AE16D24940", hash_generated_method = "F0548958B40A83AA883C615982816527")
    
public static boolean isEmergencyMessage(int id) {
        return id >= MESSAGE_ID_PWS_FIRST_IDENTIFIER && id <= MESSAGE_ID_PWS_LAST_IDENTIFIER;
    }

    /**
     * Return whether the specified message ID is an ETWS emergency message type.
     * This method is static and takes an argument so that it can be used by
     * CellBroadcastReceiver, which stores message ID's in SQLite rather than PDU.
     * @param id the message identifier to check
     * @return true if the message is ETWS emergency type; false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.596 -0500", hash_original_method = "4C70ECA3D09099250615666E21F5961A", hash_generated_method = "A086C2ADA3071BE2E148E67D0B17583B")
    
public static boolean isEtwsMessage(int id) {
        return (id & MESSAGE_ID_ETWS_TYPE_MASK) == MESSAGE_ID_ETWS_TYPE;
    }

    /**
     * Return whether the specified message ID is a CMAS emergency message type.
     * This method is static and takes an argument so that it can be used by
     * CellBroadcastReceiver, which stores message ID's in SQLite rather than PDU.
     * @param id the message identifier to check
     * @return true if the message is CMAS emergency type; false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.599 -0500", hash_original_method = "6F975588874A217BF414483961FFBC21", hash_generated_method = "604F65D9535DC588B0ED38BC228F68C4")
    
public static boolean isCmasMessage(int id) {
        return id >= MESSAGE_ID_CMAS_FIRST_IDENTIFIER && id <= MESSAGE_ID_CMAS_LAST_IDENTIFIER;
    }

    /**
     * Return whether the specified message code indicates an ETWS popup alert.
     * This method is static and takes an argument so that it can be used by
     * CellBroadcastReceiver, which stores message codes in SQLite rather than PDU.
     * This method assumes that the message ID has already been checked for ETWS type.
     *
     * @param messageCode the message code to check
     * @return true if the message code indicates a popup alert should be displayed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.601 -0500", hash_original_method = "785A21683DF02537913C025154B975A6", hash_generated_method = "A5F7E4770C244FAC926968A50E89781D")
    
public static boolean isEtwsPopupAlert(int messageCode) {
        return (messageCode & MESSAGE_CODE_ETWS_ACTIVATE_POPUP) != 0;
    }

    /**
     * Return whether the specified message code indicates an ETWS emergency user alert.
     * This method is static and takes an argument so that it can be used by
     * CellBroadcastReceiver, which stores message codes in SQLite rather than PDU.
     * This method assumes that the message ID has already been checked for ETWS type.
     *
     * @param messageCode the message code to check
     * @return true if the message code indicates an emergency user alert
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.604 -0500", hash_original_method = "1338FD648DB3B2BAA5C0EC8F5443BAC7", hash_generated_method = "8F49EA1283EBC0CE39F3CC5A101B9DB9")
    
public static boolean isEtwsEmergencyUserAlert(int messageCode) {
        return (messageCode & MESSAGE_CODE_ETWS_EMERGENCY_USER_ALERT) != 0;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.545 -0500", hash_original_field = "3479E9D6D3896BFF7D06070F6A44E682", hash_generated_field = "7E8F3E0A33C6A1772480AFF2D24BEB86")

    public static final int PDU_HEADER_LENGTH = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.547 -0500", hash_original_field = "4C449A46F350067E8494D9A97358E2CA", hash_generated_field = "AD5EFFBD9301232FCB41B3EE928ADF6C")

    public static final int FORMAT_GSM = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.550 -0500", hash_original_field = "6BD4586C8671A042FFB0EB57C6848CDE", hash_generated_field = "B24C6DE0C8B3F9C256D18EDEB67BB8C0")

    public static final int FORMAT_UMTS = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.552 -0500", hash_original_field = "438E3851F52A8BF0051A2D6FE1991EE8", hash_generated_field = "FF539DEE25DC67A07ABC4EC6BE492742")

    public static final int FORMAT_ETWS_PRIMARY = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.555 -0500", hash_original_field = "DF8E022503EACE9629FD13F805B5C496", hash_generated_field = "EDB7EDFB4873395BD2745F96175B8117")

    private static final int MESSAGE_TYPE_CBS_MESSAGE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.557 -0500", hash_original_field = "732ADA75F05B206A86E1F6F8094AAAD9", hash_generated_field = "4F0B093BC053A489824F11B3593BF645")

    public static final int PDU_LENGTH_GSM = 88;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.560 -0500", hash_original_field = "A5A845124F2F82EB362FC6BFDCEA8277", hash_generated_field = "829A8FE49043E7F186EB425545E12087")

    public static final int PDU_LENGTH_ETWS = 56;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.562 -0500", hash_original_field = "F613B1B4B12EADE872DCEAC4272C29B2", hash_generated_field = "1D5E4DABFDDA8C9C0EA798EAAADB2805")

    public  int geographicalScope;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.565 -0500", hash_original_field = "1426B113078F30C34542A176C3C46771", hash_generated_field = "5A14F88CF089D587182B20FD8BFABCD4")

    public  int messageCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.567 -0500", hash_original_field = "24DE7F2BBBB2D76B21964A620ECB5E6E", hash_generated_field = "7EC9965A45B411C158B30B7C98CE6E9F")

    public  int updateNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.569 -0500", hash_original_field = "68EC1A218477F467D3B53D45675E35D0", hash_generated_field = "D0F6F349F40771E87DD4A0D1B07055EF")

    public  int messageIdentifier;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.572 -0500", hash_original_field = "0463FAC0FF75D1D68251893EEF7FA86E", hash_generated_field = "0532B741E6B346E45FA103D1BFE0FE0D")

    public  int dataCodingScheme;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.574 -0500", hash_original_field = "CE3729C69607433DACBCD1445FB73F09", hash_generated_field = "9B2C08A54E75C2F08E1D537651339465")

    public  int pageIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.576 -0500", hash_original_field = "5C605043A45950C5D599C22EABF90700", hash_generated_field = "9F94093BFD073A9802BB5459EAA16BCF")

    public  int nrOfPages;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.579 -0500", hash_original_field = "DF6A9425E64603B99565AC4512172219", hash_generated_field = "607BD764A61A3197D0A2D65B6E1CF0E2")

    public  int format;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.582 -0500", hash_original_field = "0F8F9C0CEB0FA2EBC7690A1AC581ED95", hash_generated_field = "A790BFAEF6B0FE178FDF16CD5DDFB350")

    public  boolean etwsEmergencyUserAlert;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.584 -0500", hash_original_field = "E8101DE63D9C477A83EC6D9095F0707D", hash_generated_field = "F8E090EAD27FBA00AFC967E09A39BD7F")

    public  boolean etwsPopup;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.586 -0500", hash_original_field = "4B36A14F2D837A7C68AF2C01C76D379F", hash_generated_field = "67B1A0815B115CD87AEEBA262974E91F")

    public  int etwsWarningType;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.591 -0500", hash_original_method = "261755DF1F24560363C9FCA5817FD7DA", hash_generated_method = "C2F56B5963112091B57DCE42F603F9A4")
    
public SmsCbHeader(byte[] pdu) throws IllegalArgumentException {
        if (pdu == null || pdu.length < PDU_HEADER_LENGTH) {
            throw new IllegalArgumentException("Illegal PDU");
        }

        if (pdu.length <= PDU_LENGTH_ETWS) {
            format = FORMAT_ETWS_PRIMARY;
            geographicalScope = -1; //not applicable
            messageCode = -1;
            updateNumber = -1;
            messageIdentifier = ((pdu[2] & 0xff) << 8) | (pdu[3] & 0xff);
            dataCodingScheme = -1;
            pageIndex = -1;
            nrOfPages = -1;
            etwsEmergencyUserAlert = (pdu[4] & 0x1) != 0;
            etwsPopup = (pdu[5] & 0x80) != 0;
            etwsWarningType = (pdu[4] & 0xfe) >> 1;
        } else if (pdu.length <= PDU_LENGTH_GSM) {
            // GSM pdus are no more than 88 bytes
            format = FORMAT_GSM;
            geographicalScope = (pdu[0] & 0xc0) >> 6;
            messageCode = ((pdu[0] & 0x3f) << 4) | ((pdu[1] & 0xf0) >> 4);
            updateNumber = pdu[1] & 0x0f;
            messageIdentifier = ((pdu[2] & 0xff) << 8) | (pdu[3] & 0xff);
            dataCodingScheme = pdu[4] & 0xff;

            // Check for invalid page parameter
            int pageIndex = (pdu[5] & 0xf0) >> 4;
            int nrOfPages = pdu[5] & 0x0f;

            if (pageIndex == 0 || nrOfPages == 0 || pageIndex > nrOfPages) {
                pageIndex = 1;
                nrOfPages = 1;
            }

            this.pageIndex = pageIndex;
            this.nrOfPages = nrOfPages;
            etwsEmergencyUserAlert = false;
            etwsPopup = false;
            etwsWarningType = -1;
        } else {
            // UMTS pdus are always at least 90 bytes since the payload includes
            // a number-of-pages octet and also one length octet per page
            format = FORMAT_UMTS;

            int messageType = pdu[0];

            if (messageType != MESSAGE_TYPE_CBS_MESSAGE) {
                throw new IllegalArgumentException("Unsupported message type " + messageType);
            }

            messageIdentifier = ((pdu[1] & 0xff) << 8) | pdu[2] & 0xff;
            geographicalScope = (pdu[3] & 0xc0) >> 6;
            messageCode = ((pdu[3] & 0x3f) << 4) | ((pdu[4] & 0xf0) >> 4);
            updateNumber = pdu[4] & 0x0f;
            dataCodingScheme = pdu[5] & 0xff;

            // We will always consider a UMTS message as having one single page
            // since there's only one instance of the header, even though the
            // actual payload may contain several pages.
            pageIndex = 1;
            nrOfPages = 1;
            etwsEmergencyUserAlert = false;
            etwsPopup = false;
            etwsWarningType = -1;
        }
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.607 -0500", hash_original_method = "F77CFF978B7542934CFB3B1620EE83C7", hash_generated_method = "0B43DE98EFC8CC82B5F9A939E4FCF369")
    
@Override
    public String toString() {
        return "SmsCbHeader{GS=" + geographicalScope + ", messageCode=0x" +
                Integer.toHexString(messageCode) + ", updateNumber=" + updateNumber +
                ", messageIdentifier=0x" + Integer.toHexString(messageIdentifier) +
                ", DCS=0x" + Integer.toHexString(dataCodingScheme) +
                ", page " + pageIndex + " of " + nrOfPages + '}';
    }
}

