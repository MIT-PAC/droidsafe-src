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
import android.util.Log;
import droidsafe.annotations.*;
import java.util.HashMap;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

import com.android.internal.telephony.IccFileHandler;

class IconLoader extends Handler {

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.645 -0500", hash_original_method = "10E76DA53BC66F7E84AC913A1A382A5D", hash_generated_method = "3CA2F1EE9B38A7F66535F31F612C0A2B")
    
static IconLoader getInstance(Handler caller, IccFileHandler fh) {
        if (sLoader != null) {
            return sLoader;
        }
        if (fh != null) {
            HandlerThread thread = new HandlerThread("Cat Icon Loader");
            thread.start();
            return new IconLoader(thread.getLooper(), fh);
        }
        return null;
    }

    /**
     * Convert a TS 131.102 image instance of code scheme '11' into Bitmap
     * @param data The raw data
     * @param length The length of image body
     * @return The bitmap
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.673 -0500", hash_original_method = "2A78BD7C43C6EA7A88473349A445518E", hash_generated_method = "F02845359F6B6044975DC5E98AE8CF68")
    
public static Bitmap parseToBnW(byte[] data, int length){
        int valueIndex = 0;
        int width = data[valueIndex++] & 0xFF;
        int height = data[valueIndex++] & 0xFF;
        int numOfPixels = width*height;

        int[] pixels = new int[numOfPixels];

        int pixelIndex = 0;
        int bitIndex = 7;
        byte currentByte = 0x00;
        while (pixelIndex < numOfPixels) {
            // reassign data and index for every byte (8 bits).
            if (pixelIndex % 8 == 0) {
                currentByte = data[valueIndex++];
                bitIndex = 7;
            }
            pixels[pixelIndex++] = bitToBnW((currentByte >> bitIndex-- ) & 0x01);
        }

        if (pixelIndex != numOfPixels) {
            CatLog.d("IconLoader", "parseToBnW; size error");
        }
        return Bitmap.createBitmap(pixels, width, height, Bitmap.Config.ARGB_8888);
    }

    /**
     * Decode one bit to a black and white color:
     * 0 is black
     * 1 is white
     * @param bit to decode
     * @return RGB color
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.676 -0500", hash_original_method = "758199315728DD79898C642BC32E0396", hash_generated_method = "9C69BA60637CF2A860900E10547403B0")
    
private static int bitToBnW(int bit){
        if(bit == 1){
            return Color.WHITE;
        } else {
            return Color.BLACK;
        }
    }

    /**
     * a TS 131.102 image instance of code scheme '11' into color Bitmap
     *
     * @param data The raw data
     * @param length the length of image body
     * @param transparency with or without transparency
     * @param clut coulor lookup table
     * @return The color bitmap
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.679 -0500", hash_original_method = "9AF939262FB3DB6E45968B076173B00B", hash_generated_method = "11463A3BFE88B5F071F1874A4BF48D6F")
    
public static Bitmap parseToRGB(byte[] data, int length,
            boolean transparency, byte[] clut) {
        int valueIndex = 0;
        int width = data[valueIndex++] & 0xFF;
        int height = data[valueIndex++] & 0xFF;
        int bitsPerImg = data[valueIndex++] & 0xFF;
        int numOfClutEntries = data[valueIndex++] & 0xFF;

        if (true == transparency) {
            clut[numOfClutEntries - 1] = Color.TRANSPARENT;
        }

        int numOfPixels = width * height;
        int[] pixels = new int[numOfPixels];

        valueIndex = 6;
        int pixelIndex = 0;
        int bitsStartOffset = 8 - bitsPerImg;
        int bitIndex = bitsStartOffset;
        byte currentByte = data[valueIndex++];
        int mask = getMask(bitsPerImg);
        boolean bitsOverlaps = (8 % bitsPerImg == 0);
        while (pixelIndex < numOfPixels) {
            // reassign data and index for every byte (8 bits).
            if (bitIndex < 0) {
                currentByte = data[valueIndex++];
                bitIndex = bitsOverlaps ? (bitsStartOffset) : (bitIndex * -1);
            }
            int clutEntry = ((currentByte >> bitIndex) & mask);
            int clutIndex = clutEntry * CLUT_ENTRY_SIZE;
            pixels[pixelIndex++] = Color.rgb(clut[clutIndex],
                    clut[clutIndex + 1], clut[clutIndex + 2]);
            bitIndex -= bitsPerImg;
        }

        return Bitmap.createBitmap(pixels, width, height,
                Bitmap.Config.ARGB_8888);
    }

    /**
     * Calculate bit mask for a given number of bits. The mask should enable to
     * make a bitwise and to the given number of bits.
     * @param numOfBits number of bits to calculate mask for.
     * @return bit mask
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.682 -0500", hash_original_method = "DF9B429B85BE381DF686E1C6B7F0295C", hash_generated_method = "F425E4641A6FA3E5B633769FD3361E98")
    
private static int getMask(int numOfBits) {
        int mask = 0x00;

        switch (numOfBits) {
        case 1:
            mask = 0x01;
            break;
        case 2:
            mask = 0x03;
            break;
        case 3:
            mask = 0x07;
            break;
        case 4:
            mask = 0x0F;
            break;
        case 5:
            mask = 0x1F;
            break;
        case 6:
            mask = 0x3F;
            break;
        case 7:
            mask = 0x7F;
            break;
        case 8:
            mask = 0xFF;
            break;
        }
        return mask;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.620 -0500", hash_original_field = "0C75363FDA7A50E0EE7CA86AD7A1C31F", hash_generated_field = "81EC33A739284D15A326AED6A69F224E")

    private static IconLoader sLoader = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.622 -0500", hash_original_field = "568E7457E2BF61A996A0F4781B0DF6B9", hash_generated_field = "D01A6F849D09BA82DD97BA1D8717EC58")

    private static final int STATE_SINGLE_ICON = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.625 -0500", hash_original_field = "A3BDCD56A04ACF9FC86EE801A1B98EAA", hash_generated_field = "33544B92131C82893E35396C5ECA7589")

    private static final int STATE_MULTI_ICONS = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.628 -0500", hash_original_field = "414719FA6E083AADFC62D5ECB6369DBA", hash_generated_field = "0D80FB9FDA8A6837BB3BE8B7C9E0BA4B")

    private static final int EVENT_READ_EF_IMG_RECOED_DONE  = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.631 -0500", hash_original_field = "788A01288AC046E85BB3E2CDB8296EF0", hash_generated_field = "EFCD2E00E5FDB44DF1B199DC277FDC66")

    private static final int EVENT_READ_ICON_DONE           = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.634 -0500", hash_original_field = "DA7194F60328FEF259C8D9B7F7C685BC", hash_generated_field = "B846C390A0623DCBB7AC15A8B2D5824E")

    private static final int EVENT_READ_CLUT_DONE           = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.636 -0500", hash_original_field = "B932588BB478906D8C80C09BD0866C21", hash_generated_field = "3B0A1E53A488A72F02012F8ACD3D744C")

    private static final int CLUT_LOCATION_OFFSET = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.639 -0500", hash_original_field = "3EF01B9ABC7EC47F122BCD26ED4353A5", hash_generated_field = "FBE878DE7996E8296B61C24CEDCE7575")

    private static final int CLUT_ENTRY_SIZE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.594 -0500", hash_original_field = "4825F962A9652F9B65595FDCB8C1197A", hash_generated_field = "34FA58117F875C1478775AF3E2E8B77F")

    private int mState = STATE_SINGLE_ICON;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.596 -0500", hash_original_field = "4085DCB229A0AA5D9434FEB35B39CA16", hash_generated_field = "BBF32FCC0D1BDC907D743204AEBDE31E")

    private ImageDescriptor mId = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.598 -0500", hash_original_field = "78C82045A9CAC104EFC23F89B8D73BB7", hash_generated_field = "C437DBCD739D99106D16871E5C170598")

    private Bitmap mCurrentIcon = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.601 -0500", hash_original_field = "75F9E619FCCBED7EBB13E3C35ACF89BB", hash_generated_field = "915D91392A6FD2996994AAECEF49523C")

    private int mRecordNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.603 -0500", hash_original_field = "C0B2C4A2C2400558E0062698570FD972", hash_generated_field = "466ECA2EC8599DB18BA618AF3BB38E4A")

    private IccFileHandler mSimFH = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.605 -0500", hash_original_field = "C5014EEB4264D1428995B72B01AE133A", hash_generated_field = "B30996872B8060E9F9D87F9AD668CBDD")

    private Message mEndMsg = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.608 -0500", hash_original_field = "E0BE95F70EB2020B7BEE649AE57A8BBF", hash_generated_field = "154C16D413ECF747A4DDA2BE115A565B")

    private byte[] mIconData = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.610 -0500", hash_original_field = "EC16F3C9FE43663636904284383F5797", hash_generated_field = "992E68CF65D2B9E251C815E9737B213A")

    private int[] mRecordNumbers = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.612 -0500", hash_original_field = "9FD2B30867CB96A4CA63A737A4BCE759", hash_generated_field = "27D98BF0C1B289316F3B85701A09EBD0")

    private int mCurrentRecordIndex = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.615 -0500", hash_original_field = "C87FF15F5CF40B5C7FA0428D1EC9E992", hash_generated_field = "7BFCC2EA81A743318762373A8002B1FC")

    private Bitmap[] mIcons = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.617 -0500", hash_original_field = "CCED152393512228C41C20A9EC9E4A8A", hash_generated_field = "8961889328AF5E677CB9B441A72BB954")

    private HashMap<Integer, Bitmap> mIconsCache = null;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.642 -0500", hash_original_method = "FC71F40EA342EA47A36AF8D952C946AD", hash_generated_method = "5B9E9596C4A2E6E80977BF6867A3B575")
    
private IconLoader(Looper looper , IccFileHandler fh) {
        super(looper);
        mSimFH = fh;

        mIconsCache = new HashMap<Integer, Bitmap>(50);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.647 -0500", hash_original_method = "E56E284105F777D8A6CAB7DB3EDAC84F", hash_generated_method = "D9DD8AA7ABE851D3DC0CEF4D5C3ED35D")
    
void loadIcons(int[] recordNumbers, Message msg) {
        if (recordNumbers == null || recordNumbers.length == 0 || msg == null) {
            return;
        }
        mEndMsg = msg;
        // initialize multi icons load variables.
        mIcons = new Bitmap[recordNumbers.length];
        mRecordNumbers = recordNumbers;
        mCurrentRecordIndex = 0;
        mState = STATE_MULTI_ICONS;
        startLoadingIcon(recordNumbers[0]);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.649 -0500", hash_original_method = "328A1F48C7F5C3C618F7E134C6DE5C8B", hash_generated_method = "328A1F48C7F5C3C618F7E134C6DE5C8B")
    
void loadIcon(int recordNumber, Message msg) {
        if (msg == null) {
            return;
        }
        mEndMsg = msg;
        mState = STATE_SINGLE_ICON;
        startLoadingIcon(recordNumber);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.651 -0500", hash_original_method = "CF2A7740DA96FFBF2B7742A73D5B85D3", hash_generated_method = "DDD092AF2B653AF7BD1D9927E97DA288")
    
private void startLoadingIcon(int recordNumber) {
        // Reset the load variables.
        mId = null;
        mIconData = null;
        mCurrentIcon = null;
        mRecordNumber = recordNumber;

        // make sure the icon was not already loaded and saved in the local cache.
        if (mIconsCache.containsKey(recordNumber)) {
            mCurrentIcon = mIconsCache.get(recordNumber);
            postIcon();
            return;
        }

        // start the first phase ==> loading Image Descriptor.
        readId();
    }

    @DSSafe(DSCat.IPC_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.655 -0500", hash_original_method = "E1BF715B9C953843C5BFB563C24D3B0D", hash_generated_method = "506A2135A8DA90B2FE90922F9E010C6E")
    
@Override
    public void handleMessage(Message msg) {
        AsyncResult ar;

        try {
            switch (msg.what) {
            case EVENT_READ_EF_IMG_RECOED_DONE:
                ar = (AsyncResult) msg.obj;
                if (handleImageDescriptor((byte[]) ar.result)) {
                    readIconData();
                } else {
                    throw new Exception("Unable to parse image descriptor");
                }
                break;
            case EVENT_READ_ICON_DONE:
                ar = (AsyncResult) msg.obj;
                byte[] rawData = ((byte[]) ar.result);
                if (mId.codingScheme == ImageDescriptor.CODING_SCHEME_BASIC) {
                    mCurrentIcon = parseToBnW(rawData, rawData.length);
                    mIconsCache.put(mRecordNumber, mCurrentIcon);
                    postIcon();
                } else if (mId.codingScheme == ImageDescriptor.CODING_SCHEME_COLOUR) {
                    mIconData = rawData;
                    readClut();
                }
                break;
            case EVENT_READ_CLUT_DONE:
                ar = (AsyncResult) msg.obj;
                byte [] clut = ((byte[]) ar.result);
                mCurrentIcon = parseToRGB(mIconData, mIconData.length,
                        false, clut);
                mIconsCache.put(mRecordNumber, mCurrentIcon);
                postIcon();
                break;
            }
        } catch (Exception e) {
            CatLog.d(this, "Icon load failed");
            // post null icon back to the caller.
            postIcon();
        }
    }

    /**
     * Handles Image descriptor parsing and required processing. This is the
     * first step required to handle retrieving icons from the SIM.
     *
     * @param data byte [] containing Image Instance descriptor as defined in
     * TS 51.011.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.658 -0500", hash_original_method = "57AAD79E24539ED69C4A9588C1A4DBA1", hash_generated_method = "543CA322D833BE6F09B7DDF7A30413D7")
    
private boolean handleImageDescriptor(byte[] rawData) {
        mId = ImageDescriptor.parse(rawData, 1);
        if (mId == null) {
            return false;
        }
        return true;
    }

    // Start reading colour lookup table from SIM card.
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.661 -0500", hash_original_method = "78AA98F6413EBAF06D9D3065D89FA10B", hash_generated_method = "EADDAF35C0C1512BAFD6A5DD9B22347E")
    
private void readClut() {
        int length = mIconData[3] * CLUT_ENTRY_SIZE;
        Message msg = this.obtainMessage(EVENT_READ_CLUT_DONE);
        mSimFH.loadEFImgTransparent(mId.imageId,
                mIconData[CLUT_LOCATION_OFFSET],
                mIconData[CLUT_LOCATION_OFFSET + 1], length, msg);
    }

    // Start reading Image Descriptor from SIM card.
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.664 -0500", hash_original_method = "9B2E1F9D86B0BE7AA9984F6F6998AD1A", hash_generated_method = "7ED3AFE64FD1741ED2E7309F9E6F7BA7")
    
private void readId() {
        if (mRecordNumber < 0) {
            mCurrentIcon = null;
            postIcon();
            return;
        }
        Message msg = this.obtainMessage(EVENT_READ_EF_IMG_RECOED_DONE);
        mSimFH.loadEFImgLinearFixed(mRecordNumber, msg);
    }

    // Start reading icon bytes array from SIM card.
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.668 -0500", hash_original_method = "E5FF0727F4A23FBA52C74807E31F642C", hash_generated_method = "928F35D10CA4F1844C969B5A5C629F7E")
    
private void readIconData() {
        Message msg = this.obtainMessage(EVENT_READ_ICON_DONE);
        mSimFH.loadEFImgTransparent(mId.imageId, 0, 0, mId.length ,msg);
    }

    // When all is done pass icon back to caller.
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.670 -0500", hash_original_method = "2C2351D604337717A113511ACF501262", hash_generated_method = "5AA7AB8619696C01D37191203018D31F")
    
private void postIcon() {
        if (mState == STATE_SINGLE_ICON) {
            mEndMsg.obj = mCurrentIcon;
            mEndMsg.sendToTarget();
        } else if (mState == STATE_MULTI_ICONS) {
            mIcons[mCurrentRecordIndex++] = mCurrentIcon;
            // If not all icons were loaded, start loading the next one.
            if (mCurrentRecordIndex < mRecordNumbers.length) {
                startLoadingIcon(mRecordNumbers[mCurrentRecordIndex]);
            } else {
                mEndMsg.obj = mIcons;
                mEndMsg.sendToTarget();
            }
        }
    }
}

