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


package android.bluetooth;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;

import android.os.ParcelUuid;

public final class BluetoothUuid {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:36.366 -0500", hash_original_method = "B5DFCB7F3755C1609FBC5A2E72C4D96E", hash_generated_method = "0F52FBEB0F30E2998B7486896D61EC4B")
    
public static boolean isAudioSource(ParcelUuid uuid) {
        return uuid.equals(AudioSource);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:36.368 -0500", hash_original_method = "F463C9623FD0141968E5C25A73F5F7AC", hash_generated_method = "2E04F2FF064F9FE9560317CE11110945")
    
public static boolean isAudioSink(ParcelUuid uuid) {
        return uuid.equals(AudioSink);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:36.371 -0500", hash_original_method = "A7C2E19A56764FB2D9706B381FEC83E8", hash_generated_method = "40448BFC968E5A93B15882AACF888549")
    
public static boolean isAdvAudioDist(ParcelUuid uuid) {
        return uuid.equals(AdvAudioDist);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:36.373 -0500", hash_original_method = "7CF7727626E90908A1AA1A40CDF5B676", hash_generated_method = "F4B56FC40B4018849F2ABD090696144D")
    
public static boolean isHandsfree(ParcelUuid uuid) {
        return uuid.equals(Handsfree);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:36.375 -0500", hash_original_method = "54B3710AF57C9FA51722B6B40D9516D5", hash_generated_method = "4CADA264B2EB43D4FF94E48ED6C4E067")
    
public static boolean isHeadset(ParcelUuid uuid) {
        return uuid.equals(HSP);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:36.377 -0500", hash_original_method = "508758E11B5A78D9A1046E283411F047", hash_generated_method = "E0C944635079B187F8E81C825A735C88")
    
public static boolean isAvrcpController(ParcelUuid uuid) {
        return uuid.equals(AvrcpController);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:36.380 -0500", hash_original_method = "5C1E269574E65190C8B7B5C5E2841402", hash_generated_method = "11EDBA638DC0F2263684CC2218187064")
    
public static boolean isAvrcpTarget(ParcelUuid uuid) {
        return uuid.equals(AvrcpTarget);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:36.382 -0500", hash_original_method = "D55EFBEA47D7D31D4A3861DA0C373C90", hash_generated_method = "15D5C051B16A1EAF4B65354E3BA7821C")
    
public static boolean isInputDevice(ParcelUuid uuid) {
        return uuid.equals(Hid);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:36.384 -0500", hash_original_method = "B279779708B76B1CDFC5A65CA7692BC7", hash_generated_method = "84524D4FA4A0C134B9743C6B821B6E6A")
    
public static boolean isPanu(ParcelUuid uuid) {
        return uuid.equals(PANU);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:36.386 -0500", hash_original_method = "30E9ADFE467F8741204F5E7A679BB033", hash_generated_method = "9404CAA4817F4BFAD35E028DC7678254")
    
public static boolean isNap(ParcelUuid uuid) {
        return uuid.equals(NAP);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:36.388 -0500", hash_original_method = "219491D5B7A018F7B5377C0F049AC085", hash_generated_method = "29E20E2F755031583115F6674889B6E8")
    
public static boolean isBnep(ParcelUuid uuid) {
        return uuid.equals(BNEP);
    }
    /**
     * Returns true if ParcelUuid is present in uuidArray
     *
     * @param uuidArray - Array of ParcelUuids
     * @param uuid
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:36.391 -0500", hash_original_method = "1EC8CD1C7675CE6AC38524566B03F520", hash_generated_method = "6ED8D306BB225918A9D9A28D4BF26E13")
    
public static boolean isUuidPresent(ParcelUuid[] uuidArray, ParcelUuid uuid) {
        if ((uuidArray == null || uuidArray.length == 0) && uuid == null)
            return true;

        if (uuidArray == null)
            return false;

        for (ParcelUuid element: uuidArray) {
            if (element.equals(uuid)) return true;
        }
        return false;
    }

    /**
     * Returns true if there any common ParcelUuids in uuidA and uuidB.
     *
     * @param uuidA - List of ParcelUuids
     * @param uuidB - List of ParcelUuids
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:36.393 -0500", hash_original_method = "217F3325EF864A770B5752CB9A6C19DE", hash_generated_method = "9DA24C2923A9FF7A002FB13B91D86C4B")
    
public static boolean containsAnyUuid(ParcelUuid[] uuidA, ParcelUuid[] uuidB) {
        if (uuidA == null && uuidB == null) return true;
        return (((uuidA[0].getTaintInt() + uuidB[0].getTaintInt())) == 1);
/*

        if (uuidA == null) {
            return uuidB.length == 0 ? true : false;
        }

        if (uuidB == null) {
            return uuidA.length == 0 ? true : false;
        }

        HashSet<ParcelUuid> uuidSet = new HashSet<ParcelUuid> (Arrays.asList(uuidA));
        for (ParcelUuid uuid: uuidB) {
            if (uuidSet.contains(uuid)) return true;
        }
        return false;
*/
    }

    /**
     * Returns true if all the ParcelUuids in ParcelUuidB are present in
     * ParcelUuidA
     *
     * @param uuidA - Array of ParcelUuidsA
     * @param uuidB - Array of ParcelUuidsB
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:36.396 -0500", hash_original_method = "64FE4BCFF37135E4351D114236B1F8ED", hash_generated_method = "CB29F07E326DE7D9AB69928B4AA4A699")
    
public static boolean containsAllUuids(ParcelUuid[] uuidA, ParcelUuid[] uuidB) {
        if (uuidA == null && uuidB == null) return true;

        return (((uuidA[0].getTaintInt() + uuidB[0].getTaintInt())) == 1);
        /*

        if (uuidA == null) {
            return uuidB.length == 0 ? true : false;
        }

        if (uuidB == null) return true;

        HashSet<ParcelUuid> uuidSet = new HashSet<ParcelUuid> (Arrays.asList(uuidA));
        for (ParcelUuid uuid: uuidB) {
            if (!uuidSet.contains(uuid)) return false;
        }
        return true;
        */
    }

    /**
     * Extract the Service Identifier or the actual uuid from the Parcel Uuid.
     * For example, if 0000110B-0000-1000-8000-00805F9B34FB is the parcel Uuid,
     * this function will return 110B
     * @param parcelUuid
     * @return the service identifier.
     */
    @DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:36.398 -0500", hash_original_method = "F016C5A5F194C2EC56E874A5CB01C8BA", hash_generated_method = "19EF59BC210E96E879B3DBC348B4AD2E")
    
public static int getServiceIdentifierFromParcelUuid(ParcelUuid parcelUuid) {
        UUID uuid = parcelUuid.getUuid();
        long value = (uuid.getMostSignificantBits() & 0x0000FFFF00000000L) >>> 32;
        return (int)value;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:36.327 -0500", hash_original_field = "8118E589DFEAC7AED2ED988B6821A2A7", hash_generated_field = "F359610201989CB2AF4AAC47BBFC7DE3")

    public static final ParcelUuid AudioSink =
            ParcelUuid.fromString("0000110B-0000-1000-8000-00805F9B34FB");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:36.330 -0500", hash_original_field = "82F9566B822EE689A6FDA50CDF9531A8", hash_generated_field = "311CD8A9AC8E0F2A27B689FBD57C2D97")

    public static final ParcelUuid AudioSource =
            ParcelUuid.fromString("0000110A-0000-1000-8000-00805F9B34FB");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:36.332 -0500", hash_original_field = "DBC67E0082D793076BA038BE80A76AE2", hash_generated_field = "DDA406BBE304C417312756D9C9FA848C")

    public static final ParcelUuid AdvAudioDist =
            ParcelUuid.fromString("0000110D-0000-1000-8000-00805F9B34FB");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:36.335 -0500", hash_original_field = "DC055189D4419453DD6535D3697523D0", hash_generated_field = "94C83300C9FD3DD4445D093C881AE311")

    public static final ParcelUuid HSP =
            ParcelUuid.fromString("00001108-0000-1000-8000-00805F9B34FB");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:36.337 -0500", hash_original_field = "758E2DAEA348F68FB8C2B9BB04C6E26E", hash_generated_field = "A8716277C367CFFECA81EE406C703EC4")

    public static final ParcelUuid HSP_AG =
            ParcelUuid.fromString("00001112-0000-1000-8000-00805F9B34FB");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:36.340 -0500", hash_original_field = "0C32FDC9A01338C47DF5E25A54A8ACD5", hash_generated_field = "F65BE4EA7E86A63F3F8C2FE288570C05")

    public static final ParcelUuid Handsfree =
            ParcelUuid.fromString("0000111E-0000-1000-8000-00805F9B34FB");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:36.342 -0500", hash_original_field = "5042A49BA59BB145602A689D2C780C9B", hash_generated_field = "84885ECC78B4D3850B0C8A9FAFCE1098")

    public static final ParcelUuid Handsfree_AG =
            ParcelUuid.fromString("0000111F-0000-1000-8000-00805F9B34FB");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:36.344 -0500", hash_original_field = "20ED8E60D9DFD4E0218DB1E5A37B6192", hash_generated_field = "A16E0DBA0D8FDAA66F32D4A4CD7C5B64")

    public static final ParcelUuid AvrcpController =
            ParcelUuid.fromString("0000110E-0000-1000-8000-00805F9B34FB");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:36.346 -0500", hash_original_field = "6FFAA7FC20A1D6038C5197C5F7732F4C", hash_generated_field = "6DF603FD2840F83CB3B7E5275C9906FF")

    public static final ParcelUuid AvrcpTarget =
            ParcelUuid.fromString("0000110C-0000-1000-8000-00805F9B34FB");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:36.349 -0500", hash_original_field = "9E85036AC184A26F5D699909D2636FF9", hash_generated_field = "29D7958A4B7F4376DA9FB7A5153DC803")

    public static final ParcelUuid ObexObjectPush =
            ParcelUuid.fromString("00001105-0000-1000-8000-00805f9b34fb");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:36.352 -0500", hash_original_field = "CEBE068D722A98B76DFF27A6E6E55D16", hash_generated_field = "6C94A075F8F648576D398ABBE69F9B5C")

    public static final ParcelUuid Hid =
            ParcelUuid.fromString("00001124-0000-1000-8000-00805f9b34fb");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:36.354 -0500", hash_original_field = "EFADEA0C423A3E479F96EBF26F3CB61A", hash_generated_field = "BF68444EAA11BF24FB0C3BD970D099A8")

    public static final ParcelUuid PANU =
            ParcelUuid.fromString("00001115-0000-1000-8000-00805F9B34FB");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:36.356 -0500", hash_original_field = "CEFBD84A94C64F91A0F7E082D8C7E9D4", hash_generated_field = "B3814C7772E6BDC291321A7775060BD2")

    public static final ParcelUuid NAP =
            ParcelUuid.fromString("00001116-0000-1000-8000-00805F9B34FB");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:36.359 -0500", hash_original_field = "432781679682339C78761900AD9AE6E3", hash_generated_field = "C0AA6678DBE3CFED1B8246D39CA85DC7")

    public static final ParcelUuid BNEP =
            ParcelUuid.fromString("0000000f-0000-1000-8000-00805F9B34FB");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:36.362 -0500", hash_original_field = "9615B5DEDA8BFC21C7D4BBB44BEBC687", hash_generated_field = "4A653A0EC0C71C8E285EC329D0C3DEAA")

    public static final ParcelUuid PBAP_PSE =
            ParcelUuid.fromString("0000112f-0000-1000-8000-00805F9B34FB");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:36.364 -0500", hash_original_field = "DB67FFC3270C4399FCF0A259E4C7ECD9", hash_generated_field = "21C8273B00AA1A7F9C975686F7D4F5C5")

    public static final ParcelUuid[] RESERVED_UUIDS = {
        AudioSink, AudioSource, AdvAudioDist, HSP, Handsfree, AvrcpController, AvrcpTarget,
        ObexObjectPush, PANU, NAP};
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.741 -0400", hash_original_method = "FFEFA3BC7BFF4E84DBF24098C0B3A717", hash_generated_method = "FFEFA3BC7BFF4E84DBF24098C0B3A717")
    public BluetoothUuid ()
    {
        //Synthesized constructor
    }
}

