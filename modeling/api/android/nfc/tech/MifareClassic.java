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


package android.nfc.tech;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import android.nfc.ErrorCodes;
import android.nfc.Tag;
import android.nfc.TagLostException;
import android.os.RemoteException;

public final class MifareClassic extends BasicTagTechnology {

    /**
     * Get an instance of {@link MifareClassic} for the given tag.
     * <p>Does not cause any RF activity and does not block.
     * <p>Returns null if {@link MifareClassic} was not enumerated in {@link Tag#getTechList}.
     * This indicates the tag is not MIFARE Classic compatible, or this Android
     * device does not support MIFARE Classic.
     *
     * @param tag an MIFARE Classic compatible tag
     * @return MIFARE Classic object
     */
    @DSComment("NFC technology implementation")
    @DSSpec(DSCat.NFC)
    @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.500 -0500", hash_original_method = "E256682DB559ACD3975BBE21D7BE6E4D", hash_generated_method = "9F064CCAD2CBFBF1159E2F336F20BB74")
    
public static MifareClassic get(Tag tag) {
        if (!tag.hasTech(TagTechnology.MIFARE_CLASSIC)) return null;
        try {
            return new MifareClassic(tag);
        } catch (RemoteException e) {
            return null;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.555 -0500", hash_original_method = "6AEBAB1312792C7703187110E11F13AB", hash_generated_method = "D3B8644AAE9BC8E492D40EC59854C738")
    
private static void validateSector(int sector) {
        // Do not be too strict on upper bounds checking, since some cards
        // have more addressable memory than they report. For example,
        // MIFARE Plus 2k cards will appear as MIFARE Classic 1k cards when in
        // MIFARE Classic compatibility mode.
        // Note that issuing a command to an out-of-bounds block is safe - the
        // tag should report error causing IOException. This validation is a
        // helper to guard against obvious programming mistakes.
        if (sector < 0 || sector >= MAX_SECTOR_COUNT) {
            throw new IndexOutOfBoundsException("sector out of bounds: " + sector);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.558 -0500", hash_original_method = "CFA9481E8F030900CA0048919D894F77", hash_generated_method = "C34B68B047A4989525857FEB4C250D12")
    
private static void validateBlock(int block) {
        // Just looking for obvious out of bounds...
        if (block < 0 || block >= MAX_BLOCK_COUNT) {
            throw new IndexOutOfBoundsException("block out of bounds: " + block);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.560 -0500", hash_original_method = "F036ABF163B31A4495D232DA6641AE31", hash_generated_method = "CDE5A15CE101FB85B5C6757A52726679")
    
private static void validateValueOperand(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("value operand negative");
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.456 -0500", hash_original_field = "76B42502A850F1BA8F9A78C316486025", hash_generated_field = "BC8F11E4AEAD11E0412B7B53DF0CA6C8")

    private static final String TAG = "NFC";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.459 -0500", hash_original_field = "568A5AF0E2D7D166BEA1301C59CC2B40", hash_generated_field = "54FD0024ABE4EEEC2428AB757D9F3016")

    public static final byte[] KEY_DEFAULT =
            {(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFF};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.461 -0500", hash_original_field = "13BA65685947D1AA3A3063BE4D3A4240", hash_generated_field = "15DB5DCB955364C48035DA5E4E953740")

    public static final byte[] KEY_MIFARE_APPLICATION_DIRECTORY =
            {(byte)0xA0,(byte)0xA1,(byte)0xA2,(byte)0xA3,(byte)0xA4,(byte)0xA5};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.464 -0500", hash_original_field = "0B71AB72F9C67F75BDD47653DBC0F1F8", hash_generated_field = "12E87E1D5AC9EA588363E4D80F1B1001")

    public static final byte[] KEY_NFC_FORUM =
            {(byte)0xD3,(byte)0xF7,(byte)0xD3,(byte)0xF7,(byte)0xD3,(byte)0xF7};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.466 -0500", hash_original_field = "4E3213304A9AE81B4AE58CC302F1CDF6", hash_generated_field = "384725A35AE2048CC01CB14C667E6F8D")

    public static final int TYPE_UNKNOWN = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.468 -0500", hash_original_field = "CA23C1EFE8B94F090EE8F755F08A2362", hash_generated_field = "7061FCCEF7055B824FD2AA480431DCC6")

    public static final int TYPE_CLASSIC = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.471 -0500", hash_original_field = "04F9C862049EB6F3FEABC8834B994268", hash_generated_field = "4E9412DEFDF67F37DBAB413F0A64A35E")

    public static final int TYPE_PLUS = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.473 -0500", hash_original_field = "EFFFF72CBC30B276E36F01D6F78ED854", hash_generated_field = "E54C8D8F5C6AB4014CB13C1AA7F26768")

    public static final int TYPE_PRO = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.476 -0500", hash_original_field = "357C56F4AAE2A9253051CEF7AAE2F8F5", hash_generated_field = "1768559A5BB2B8E1D785D5C51528A7E2")

    public static final int SIZE_1K = 1024;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.479 -0500", hash_original_field = "F323C7F0693506F0180DBE5A6D1E000E", hash_generated_field = "29839D581DC916610DC52670577D996D")

    public static final int SIZE_2K = 2048;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.481 -0500", hash_original_field = "CA4C64740611919A41F7D46531BA3821", hash_generated_field = "901EEE828F9926FE0467F5BB2C7B7D08")

    public static final int SIZE_4K = 4096;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.484 -0500", hash_original_field = "270A7469AFB7D89E6A467EA06638C66B", hash_generated_field = "042D532175870A55F83E79C5988117F4")

    public static final int SIZE_MINI = 320;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.487 -0500", hash_original_field = "22CAEF6299D730132E9AD238F610AAF5", hash_generated_field = "195B8DA56AF39DED77508EB085D1B2A5")

    public static final int BLOCK_SIZE = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.489 -0500", hash_original_field = "52FA28BBF5C30D3FFD109260D6B78CCB", hash_generated_field = "BC260A9D029BA6EDF18C45D0AF8942E9")

    private static final int MAX_BLOCK_COUNT = 256;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.491 -0500", hash_original_field = "18D1231F189EEF295B834E3AC6952D5E", hash_generated_field = "D29CA245349D4EF940C9F42785B91E3A")

    private static final int MAX_SECTOR_COUNT = 40;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.493 -0500", hash_original_field = "A8195C44C78CB64F7BEB74D57C77637D", hash_generated_field = "A5FF4684C8ADE9FC7594EE2E1226C64D")

    private boolean mIsEmulated;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.496 -0500", hash_original_field = "B93BF1EFA6B57CC598632E54B97CD147", hash_generated_field = "E6B4AC7A48E0E54E09A504C828AF50C5")

    private int mType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.498 -0500", hash_original_field = "205262C28D2B190751535A4911B3B259", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

    private int mSize;

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.504 -0500", hash_original_method = "05B1EEC895D259A0FF8852CB7B561E5D", hash_generated_method = "D5703B9D179A855AEC267C65F05B7ECB")
    
public MifareClassic(Tag tag) throws RemoteException {
        super(tag, TagTechnology.MIFARE_CLASSIC);

        NfcA a = NfcA.get(tag);  // MIFARE Classic is always based on NFC a

        mIsEmulated = false;

        switch (a.getSak()) {
        case 0x08:
            mType = TYPE_CLASSIC;
            mSize = SIZE_1K;
            break;
        case 0x09:
            mType = TYPE_CLASSIC;
            mSize = SIZE_MINI;
            break;
        case 0x10:
            mType = TYPE_PLUS;
            mSize = SIZE_2K;
            // SecLevel = SL2
            break;
        case 0x11:
            mType = TYPE_PLUS;
            mSize = SIZE_4K;
            // Seclevel = SL2
            break;
        case 0x18:
            mType = TYPE_CLASSIC;
            mSize = SIZE_4K;
            break;
        case 0x28:
            mType = TYPE_CLASSIC;
            mSize = SIZE_1K;
            mIsEmulated = true;
            break;
        case 0x38:
            mType = TYPE_CLASSIC;
            mSize = SIZE_4K;
            mIsEmulated = true;
            break;
        case 0x88:
            mType = TYPE_CLASSIC;
            mSize = SIZE_1K;
            // NXP-tag: false
            break;
        case 0x98:
        case 0xB8:
            mType = TYPE_PRO;
            mSize = SIZE_4K;
            break;
        default:
            // Stack incorrectly reported a MifareClassic. We cannot handle this
            // gracefully - we have no idea of the memory layout. Bail.
            throw new RuntimeException(
                    "Tag incorrectly enumerated as MIFARE Classic, SAK = " + a.getSak());
        }
    }

    /**
     * Return the type of this MIFARE Classic compatible tag.
     * <p>One of {@link #TYPE_UNKNOWN}, {@link #TYPE_CLASSIC}, {@link #TYPE_PLUS} or
     * {@link #TYPE_PRO}.
     * <p>Does not cause any RF activity and does not block.
     *
     * @return type
     */
    @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.506 -0500", hash_original_method = "E9AD68D49398B2B9D86D12D221B14582", hash_generated_method = "32498FCDA3AC1E9A676800B51A331335")
    
public int getType() {
        return mType;
    }

    /**
     * Return the size of the tag in bytes
     * <p>One of {@link #SIZE_MINI}, {@link #SIZE_1K}, {@link #SIZE_2K}, {@link #SIZE_4K}.
     * These constants are equal to their respective size in bytes.
     * <p>Does not cause any RF activity and does not block.
     * @return size in bytes
     */
    @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.508 -0500", hash_original_method = "2098B918320D3D5229820CAB47C60E59", hash_generated_method = "5C0A5CB4DD3116647C99AA4ADB19626C")
    
public int getSize() {
        return mSize;
    }

    /**
     * Return true if the tag is emulated, determined at discovery time.
     * These are actually smart-cards that emulate a MIFARE Classic interface.
     * They can be treated identically to a MIFARE Classic tag.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.510 -0500", hash_original_method = "571F1D61EE68738D4B1083BD48C02876", hash_generated_method = "E5E6612EE5F6102975B877338E28BF26")
    
public boolean isEmulated() {
        return mIsEmulated;
    }

    /**
     * Return the number of MIFARE Classic sectors.
     * <p>Does not cause any RF activity and does not block.
     * @return number of sectors
     */
    @DSComment("NFC technology implementation")
    @DSSpec(DSCat.NFC)
    @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.512 -0500", hash_original_method = "4AAA3C3D329C939FDD63EF1F58378EDA", hash_generated_method = "4D2FADE42AC7537391D9250404E1EABD")
    
public int getSectorCount() {
        switch (mSize) {
        case SIZE_1K:
            return 16;
        case SIZE_2K:
            return 32;
        case SIZE_4K:
            return 40;
        case SIZE_MINI:
            return 5;
        default:
            return 0;
        }
    }

    /**
     * Return the total number of MIFARE Classic blocks.
     * <p>Does not cause any RF activity and does not block.
     * @return total number of blocks
     */
    @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.514 -0500", hash_original_method = "94025DFC316C8F4CE80BFCF15B00E224", hash_generated_method = "702BC6C3AD9C09E630E017F6B5D91E64")
    
public int getBlockCount() {
        return mSize / BLOCK_SIZE;
    }

    /**
     * Return the number of blocks in the given sector.
     * <p>Does not cause any RF activity and does not block.
     *
     * @param sectorIndex index of sector, starting from 0
     * @return number of blocks in the sector
     */
    @DSComment("NFC technology implementation")
    @DSSpec(DSCat.NFC)
    @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.516 -0500", hash_original_method = "4046C9F5F79A621BBA2F7BE2C9D1103D", hash_generated_method = "73213613B5EED476EAA815B3DE45523F")
    
public int getBlockCountInSector(int sectorIndex) {
        validateSector(sectorIndex);

        if (sectorIndex < 32) {
            return 4;
        } else {
            return 16;
        }
    }

    /**
     * Return the sector that contains a given block.
     * <p>Does not cause any RF activity and does not block.
     *
     * @param blockIndex index of block to lookup, starting from 0
     * @return sector index that contains the block
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.519 -0500", hash_original_method = "54173D46B73CE605A7C420967C72CF9C", hash_generated_method = "4A017C2D04B7D7BF7D39E350F3E8682F")
    
public int blockToSector(int blockIndex) {
        validateBlock(blockIndex);

        if (blockIndex < 32 * 4) {
            return blockIndex / 4;
        } else {
            return 32 + (blockIndex - 32 * 4) / 16;
        }
    }

    /**
     * Return the first block of a given sector.
     * <p>Does not cause any RF activity and does not block.
     *
     * @param sectorIndex index of sector to lookup, starting from 0
     * @return block index of first block in sector
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.521 -0500", hash_original_method = "9D4F0360D229F71B4914DA14E59850F0", hash_generated_method = "DF81E847F0CB6237B109B3D92602C5BF")
    
public int sectorToBlock(int sectorIndex) {
        if (sectorIndex < 32) {
            return sectorIndex * 4;
        } else {
            return 32 * 4 + (sectorIndex - 32) * 16;
        }
    }

    /**
     * Authenticate a sector with key A.
     *
     * <p>Successful authentication of a sector with key A enables other
     * I/O operations on that sector. The set of operations granted by key A
     * key depends on the ACL bits set in that sector. For more information
     * see the MIFARE Classic specification on {@see http://www.nxp.com}.
     *
     * <p>A failed authentication attempt causes an implicit reconnection to the
     * tag, so authentication to other sectors will be lost.
     *
     * <p>This is an I/O operation and will block until complete. It must
     * not be called from the main application thread. A blocked call will be canceled with
     * {@link IOException} if {@link #close} is called from another thread.
     *
     * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
     *
     * @param sectorIndex index of sector to authenticate, starting from 0
     * @param key 6-byte authentication key
     * @return true on success, false on authentication failure
     * @throws TagLostException if the tag leaves the field
     * @throws IOException if there is an I/O failure, or the operation is canceled
     */
    @DSComment("NFC technology implementation")
    @DSSpec(DSCat.NFC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.524 -0500", hash_original_method = "88C199BE0D888C3B911ED6B5CDCE45B3", hash_generated_method = "2F30C532D366C8631223F424EE7BD491")
    
public boolean authenticateSectorWithKeyA(int sectorIndex, byte[] key) throws IOException {
        return authenticate(sectorIndex, key, true);
    }

    /**
     * Authenticate a sector with key B.
     *
     * <p>Successful authentication of a sector with key B enables other
     * I/O operations on that sector. The set of operations granted by key B
     * depends on the ACL bits set in that sector. For more information
     * see the MIFARE Classic specification on {@see http://www.nxp.com}.
     *
     * <p>A failed authentication attempt causes an implicit reconnection to the
     * tag, so authentication to other sectors will be lost.
     *
     * <p>This is an I/O operation and will block until complete. It must
     * not be called from the main application thread. A blocked call will be canceled with
     * {@link IOException} if {@link #close} is called from another thread.
     *
     * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
     *
     * @param sectorIndex index of sector to authenticate, starting from 0
     * @param key 6-byte authentication key
     * @return true on success, false on authentication failure
     * @throws TagLostException if the tag leaves the field
     * @throws IOException if there is an I/O failure, or the operation is canceled
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.527 -0500", hash_original_method = "18C51006B4E85BDBA44E7C237EA48ACA", hash_generated_method = "B369F0B3F0D5020EBD23E4B5F61711FA")
    
public boolean authenticateSectorWithKeyB(int sectorIndex, byte[] key) throws IOException {
        return authenticate(sectorIndex, key, false);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.529 -0500", hash_original_method = "A4BE9C6E30E6595D3E1AAF1825AE0C43", hash_generated_method = "E27CCEFD3D52E13A0552F8D874A1AC02")
    
private boolean authenticate(int sector, byte[] key, boolean keyA) throws IOException {
        validateSector(sector);
        checkConnected();

        byte[] cmd = new byte[12];

        // First byte is the command
        if (keyA) {
            cmd[0] = 0x60; // phHal_eMifareAuthentA
        } else {
            cmd[0] = 0x61; // phHal_eMifareAuthentB
        }

        // Second byte is block address
        // Authenticate command takes a block address. Authenticating a block
        // of a sector will authenticate the entire sector.
        cmd[1] = (byte) sectorToBlock(sector);

        // Next 4 bytes are last 4 bytes of UID
        byte[] uid = getTag().getId();
        System.arraycopy(uid, uid.length - 4, cmd, 2, 4);

        // Next 6 bytes are key
        System.arraycopy(key, 0, cmd, 6, 6);

        try {
            if (transceive(cmd, false) != null) {
                return true;
            }
        } catch (TagLostException e) {
            throw e;
        } catch (IOException e) {
            // No need to deal with, will return false anyway
        }
        return false;
    }

    /**
     * Read 16-byte block.
     *
     * <p>This is an I/O operation and will block until complete. It must
     * not be called from the main application thread. A blocked call will be canceled with
     * {@link IOException} if {@link #close} is called from another thread.
     *
     * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
     *
     * @param blockIndex index of block to read, starting from 0
     * @return 16 byte block
     * @throws TagLostException if the tag leaves the field
     * @throws IOException if there is an I/O failure, or the operation is canceled
     */
    @DSComment("NFC technology implementation")
    @DSSpec(DSCat.NFC)
    @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.532 -0500", hash_original_method = "540E686F2680F6F111FB5FE029F249C7", hash_generated_method = "ED987BFD8349BF414FD2365B04E64336")
    
public byte[] readBlock(int blockIndex) throws IOException {
        validateBlock(blockIndex);
        checkConnected();

        byte[] cmd = { 0x30, (byte) blockIndex };
        return transceive(cmd, false);
    }

    /**
     * Write 16-byte block.
     *
     * <p>This is an I/O operation and will block until complete. It must
     * not be called from the main application thread. A blocked call will be canceled with
     * {@link IOException} if {@link #close} is called from another thread.
     *
     * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
     *
     * @param blockIndex index of block to write, starting from 0
     * @param data 16 bytes of data to write
     * @throws TagLostException if the tag leaves the field
     * @throws IOException if there is an I/O failure, or the operation is canceled
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.534 -0500", hash_original_method = "6EB213EA4DA32B7A4304947C71CED66E", hash_generated_method = "A7EEC08B0AA170934CACE7AC814DF49A")
    
public void writeBlock(int blockIndex, byte[] data) throws IOException {
        validateBlock(blockIndex);
        checkConnected();
        if (data.length != 16) {
            throw new IllegalArgumentException("must write 16-bytes");
        }

        byte[] cmd = new byte[data.length + 2];
        cmd[0] = (byte) 0xA0; // MF write command
        cmd[1] = (byte) blockIndex;
        System.arraycopy(data, 0, cmd, 2, data.length);

        transceive(cmd, false);
    }

    /**
     * Increment a value block, storing the result in the temporary block on the tag.
     *
     * <p>This is an I/O operation and will block until complete. It must
     * not be called from the main application thread. A blocked call will be canceled with
     * {@link IOException} if {@link #close} is called from another thread.
     *
     * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
     *
     * @param blockIndex index of block to increment, starting from 0
     * @param value non-negative to increment by
     * @throws TagLostException if the tag leaves the field
     * @throws IOException if there is an I/O failure, or the operation is canceled
     */
    @DSSink({DSSinkKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.537 -0500", hash_original_method = "B8563CE393F659B55E0B9D3772EFE7A6", hash_generated_method = "5AF5E8C91CAD8B0F8CC6116D65C3A94A")
    
public void increment(int blockIndex, int value) throws IOException {
        validateBlock(blockIndex);
        validateValueOperand(value);
        checkConnected();

        ByteBuffer cmd = ByteBuffer.allocate(6);
        cmd.order(ByteOrder.LITTLE_ENDIAN);
        cmd.put( (byte) 0xC1 );
        cmd.put( (byte) blockIndex );
        cmd.putInt(value);

        transceive(cmd.array(), false);
    }

    /**
     * Decrement a value block, storing the result in the temporary block on the tag.
     *
     * <p>This is an I/O operation and will block until complete. It must
     * not be called from the main application thread. A blocked call will be canceled with
     * {@link IOException} if {@link #close} is called from another thread.
     *
     * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
     *
     * @param blockIndex index of block to decrement, starting from 0
     * @param value non-negative to decrement by
     * @throws TagLostException if the tag leaves the field
     * @throws IOException if there is an I/O failure, or the operation is canceled
     */
    @DSSink({DSSinkKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.539 -0500", hash_original_method = "FAA38C9F5E4C186E0FA530C9A1909DAD", hash_generated_method = "A92A75E89900C5ABB49245ACA28AF5B3")
    
public void decrement(int blockIndex, int value) throws IOException {
        validateBlock(blockIndex);
        validateValueOperand(value);
        checkConnected();

        ByteBuffer cmd = ByteBuffer.allocate(6);
        cmd.order(ByteOrder.LITTLE_ENDIAN);
        cmd.put( (byte) 0xC0 );
        cmd.put( (byte) blockIndex );
        cmd.putInt(value);

        transceive(cmd.array(), false);
    }

    /**
     * Copy from the temporary block to a value block.
     *
     * <p>This is an I/O operation and will block until complete. It must
     * not be called from the main application thread. A blocked call will be canceled with
     * {@link IOException} if {@link #close} is called from another thread.
     *
     * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
     *
     * @param blockIndex index of block to copy to
     * @throws TagLostException if the tag leaves the field
     * @throws IOException if there is an I/O failure, or the operation is canceled
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.541 -0500", hash_original_method = "25F048093BEC30F816A6E356A5759AAE", hash_generated_method = "DDC50391C15E331393724933E98CF089")
    
public void transfer(int blockIndex) throws IOException {
        validateBlock(blockIndex);
        checkConnected();

        byte[] cmd = { (byte) 0xB0, (byte) blockIndex };

        transceive(cmd, false);
    }

    /**
     * Copy from a value block to the temporary block.
     *
     * <p>This is an I/O operation and will block until complete. It must
     * not be called from the main application thread. A blocked call will be canceled with
     * {@link IOException} if {@link #close} is called from another thread.
     *
     * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
     *
     * @param blockIndex index of block to copy from
     * @throws TagLostException if the tag leaves the field
     * @throws IOException if there is an I/O failure, or the operation is canceled
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.543 -0500", hash_original_method = "CA1FBC952F4C8F3DF96DFF31BC2893A2", hash_generated_method = "AA3D315461AC5D8F483597DB8508AC33")
    
public void restore(int blockIndex) throws IOException {
        validateBlock(blockIndex);
        checkConnected();

        byte[] cmd = { (byte) 0xC2, (byte) blockIndex };

        transceive(cmd, false);
    }

    /**
     * Send raw NfcA data to a tag and receive the response.
     *
     * <p>This is equivalent to connecting to this tag via {@link NfcA}
     * and calling {@link NfcA#transceive}. Note that all MIFARE Classic
     * tags are based on {@link NfcA} technology.
     *
     * <p>Use {@link #getMaxTransceiveLength} to retrieve the maximum number of bytes
     * that can be sent with {@link #transceive}.
     *
     * <p>This is an I/O operation and will block until complete. It must
     * not be called from the main application thread. A blocked call will be canceled with
     * {@link IOException} if {@link #close} is called from another thread.
     *
     * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
     *
     * @see NfcA#transceive
     */
    @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.546 -0500", hash_original_method = "E43990821CE38E04B46B3E901EFDFA24", hash_generated_method = "CC13A29AED45E04C4807822531800242")
    
public byte[] transceive(byte[] data) throws IOException {
        return transceive(data, true);
    }

    /**
     * Return the maximum number of bytes that can be sent with {@link #transceive}.
     * @return the maximum number of bytes that can be sent with {@link #transceive}.
     */
    @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.548 -0500", hash_original_method = "CF96EF3BF3FCE4DA3D9E7FBB541AEB70", hash_generated_method = "ECC61C711C2C081CEFB91A790D67A4A8")
    
public int getMaxTransceiveLength() {
        return getMaxTransceiveLengthInternal();
    }

    /**
     * Set the {@link #transceive} timeout in milliseconds.
     *
     * <p>The timeout only applies to {@link #transceive} on this object,
     * and is reset to a default value when {@link #close} is called.
     *
     * <p>Setting a longer timeout may be useful when performing
     * transactions that require a long processing time on the tag
     * such as key generation.
     *
     * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
     *
     * @param timeout timeout value in milliseconds
     */
    @DSSink({DSSinkKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.551 -0500", hash_original_method = "F9EC6D04AED06B3DFE22DC9A2A8AC0C3", hash_generated_method = "9E5730519065B43D0F999CFF9537BF7D")
    
public void setTimeout(int timeout) {
        try {
            int err = mTag.getTagService().setTimeout(TagTechnology.MIFARE_CLASSIC, timeout);
            if (err != ErrorCodes.SUCCESS) {
                throw new IllegalArgumentException("The supplied timeout is not valid");
            }
        } catch (RemoteException e) {
            Log.e(TAG, "NFC service dead", e);
        }
    }

    /**
     * Get the current {@link #transceive} timeout in milliseconds.
     *
     * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
     *
     * @return timeout value in milliseconds
     */
    @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:49.553 -0500", hash_original_method = "59718E6CF1FABD433F7C060A44E5C453", hash_generated_method = "502A195A8ADED54A1910871BDD9CE087")
    
public int getTimeout() {
        try {
            return mTag.getTagService().getTimeout(TagTechnology.MIFARE_CLASSIC);
        } catch (RemoteException e) {
            Log.e(TAG, "NFC service dead", e);
            return 0;
        }
    }
}

