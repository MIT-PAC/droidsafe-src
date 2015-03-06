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
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.harmony.security.provider.crypto;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.security.DigestException;
import java.security.MessageDigestSpi;
import java.util.Arrays;

import static org.apache.harmony.security.provider.crypto.SHA1Constants.*;

/**
 * This class extends the MessageDigestSpi class implementing all its abstract methods;
 * it overrides the "Object clone()" and "int engineGetDigestLength()" methods. <BR>
 * The class implements the Cloneable interface.
 */
public class SHA1_MessageDigestImpl extends MessageDigestSpi implements Cloneable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.121 -0400", hash_original_field = "EEE3C029CA3ECD817D7F0A32DA179389", hash_generated_field = "310FFB490A64EBECFFE86EFB7B25EB11")

    private int[] buffer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.121 -0400", hash_original_field = "4AC734E5BD30AE8F332E5763EEDC1337", hash_generated_field = "A834C114B356A38191B5056290C5CFEF")

                                 // -  0-16 - frame for accumulating a message
                                 // - 17-79 - for SHA1Impl methods
                                 // - 80    - unused
                                 // - 81    - to store length of the message
                                 // - 82-86 - frame for current message digest

    private byte[] oneByte;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.122 -0400", hash_original_field = "6A5A81A4426ED40AE55A06094B366D2A", hash_generated_field = "7859BC60DB0F775170FC54890C383CAD")

                                 // having buffer as private field is just optimization

    private long messageLength;   // total length of bytes supplied by user

    /**
     *  The constructor creates needed buffers and sets the engine at initial state
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.122 -0400", hash_original_method = "8B4418C5AAA7BFDA9371B9AE60C2714D", hash_generated_method = "2AE26BE1E6CC891B5726F905465219D0")
    
public SHA1_MessageDigestImpl() {

        // BYTES_OFFSET +6 is minimal length required by methods in SHA1Impl
        buffer  = new int[BYTES_OFFSET +6];

        oneByte = new byte[1];

        engineReset();
    }

    /**
     * The method performs final actions and invokes the "computeHash(int[])" method.
     * In case if there is no enough words in current frame
     * after processing its data, extra frame is prepared and
     * the "computeHash(int[])" method is invoked second time. <BR>
     *
     * After processing, the method resets engine's state
     *
     * @param
     *       digest - byte array
     * @param
     *       offset - offset in digest
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.124 -0400", hash_original_method = "8D1FC85EF8B51F3A01D708D9998B3DDE", hash_generated_method = "8B05697A3DD6FB4705EA2C4613CCB703")
    
private void processDigest(byte[] digest, int offset) {

        int i, j;         // implementation variables
        int lastWord;     //

        long nBits = messageLength <<3 ;  // length has to be calculated before padding

        engineUpdate( (byte) 0x80 );      // beginning byte in padding

        i = 0;                     // i contains number of beginning word for following loop

        lastWord = (buffer[BYTES_OFFSET] + 3)>>2 ;  // computing of # of full words by shifting
                                                    // # of bytes

        // possible cases:
        //
        // - buffer[BYTES_OFFSET] == 0 - buffer frame is empty,
        //                         padding byte was 64th in previous frame
        //                         current frame should contain only message's length
        //
        // - lastWord < 14 - two last, these are 14 & 15, words in 16 word frame are free;
        //                   no extra frame needed
        // - lastWord = 14 - only one last, namely 15-th, word in frame doesn't contain bytes;
        //                   extra frame is needed
        // - lastWord > 14 - last word in frame is not full;
        //                   extra frame is needed

        if ( buffer[BYTES_OFFSET] != 0 ) {

            if ( lastWord < 15 ) {
                i = lastWord;
            } else {
                if ( lastWord == 15 ) {
                    buffer[15] = 0;       // last word in frame is set to "0"
                }
                SHA1Impl.computeHash(buffer);
                i = 0;
            }
        }
        Arrays.fill(buffer, i, 14, 0);

        buffer[14] = (int)( nBits >>>32 );
        buffer[15] = (int)( nBits & 0xFFFFFFFF );
        SHA1Impl.computeHash(buffer);

        // converting 5-word frame into 20 bytes
        j = offset;
        for ( i = HASH_OFFSET; i < HASH_OFFSET +5; i++ ) {
            int k = buffer[i];
            digest[j  ] = (byte) ( k >>>24 );   // getting first  byte from left
            digest[j+1] = (byte) ( k >>>16 );   // getting second byte from left
            digest[j+2] = (byte) ( k >>> 8 );   // getting third  byte from left
            digest[j+3] = (byte) ( k       );   // getting fourth byte from left
            j += 4;
        }

        engineReset();
    }

    //  methods specified in java.security.MessageDigestSpi

    /**
     * Returns a "deep" copy of this SHA1MDImpl object. <BR>
     *
     * The method overrides "clone()" in class Object. <BR>
     *
     * @return
     *       a clone of this object
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.125 -0400", hash_original_method = "6E9FF04EDBC10C1681EBB7B80AAD70DA", hash_generated_method = "6B2F8573B12D5EEA4E1F115F0BDFF2D3")
    
public Object clone() throws CloneNotSupportedException {
        SHA1_MessageDigestImpl cloneObj = (SHA1_MessageDigestImpl) super.clone();
        cloneObj.buffer = buffer.clone();
        cloneObj.oneByte = oneByte.clone();
        return cloneObj;
    }

    /**
     * Computes a message digest value. <BR>
     *
     * The method resets the engine. <BR>
     *
     * The method overrides "engineDigest()" in class MessageDigestSpi. <BR>
     *
     * @return
     *       byte array containing message digest value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.125 -0400", hash_original_method = "2629CFA25E1C88868D85E1F8B588DA31", hash_generated_method = "A657FE6538844C44D68B9541E520CD04")
    
protected byte[] engineDigest() {
        byte[] hash = new byte[DIGEST_LENGTH];
        processDigest(hash, 0);
        return hash;
    }

    /**
     * Computes message digest value.
     * Upon return, the value is stored in "buf" buffer beginning "offset" byte. <BR>
     *
     * The method resets the engine. <BR>
     *
     * The method overrides "engineDigest(byte[],int,int) in class MessageDigestSpi.
     *
     * @param
     *       buf    byte array to store a message digest returned
     * @param
     *       offset a position in the array for first byte of the message digest
     * @param
     *       len    number of bytes within buffer allotted for the message digest;
     *                as this implementation doesn't provide partial digests,
     *                len should be >= 20, DigestException is thrown otherwise
     * @return
     *       the length of the message digest stored in the "buf" buffer;
     *       in this implementation the length=20
     *
     * @throws IllegalArgumentException
     *               if null is passed to the "buf" argument <BR>
     *               if offset + len > buf.length  <BR>
     *               if offset > buf.length or len > buf.length
     *
     * @throws DigestException
     *               if len < 20
     *
     * @throws  ArrayIndexOutOfBoundsException
     *               if offset < 0
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.126 -0400", hash_original_method = "966FCD8B40FDE9881C88D25A85E81669", hash_generated_method = "AC03D3F9AE9DA95991FFFDACA0C59E41")
    
protected int engineDigest(byte[] buf, int offset, int len) throws DigestException {
        if (buf == null) {
            throw new IllegalArgumentException("buf == null");
        }
        if (offset > buf.length || len > buf.length || (len + offset) > buf.length) {
            throw new IllegalArgumentException();
        }
        if (len < DIGEST_LENGTH) {
            throw new DigestException("len < DIGEST_LENGTH");
        }
        if (offset < 0) {
            throw new ArrayIndexOutOfBoundsException(offset);
        }

        processDigest(buf, offset);

        return DIGEST_LENGTH;
    }

    /**
     * Returns a message digest length. <BR>
     *
     * The method overrides "engineGetDigestLength()" in class MessageDigestSpi. <BR>
     *
     * @return
     *        total length of current message digest as an int value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.127 -0400", hash_original_method = "8B615132CA365FD6AAA05512132E9CB5", hash_generated_method = "5DE0A1E3CF7EED692E50AB07609A20B8")
    
protected int engineGetDigestLength() {
        return DIGEST_LENGTH;
    }

    /**
     * Resets the engine. <BR>
     *
     * The method overrides "engineReset()" in class MessageDigestSpi. <BR>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.127 -0400", hash_original_method = "7233480063D9B70EDAE30CAF1CCF8A70", hash_generated_method = "9C5D91D1D5674A95DF8BDABEA911F9A5")
    
protected void engineReset() {

        messageLength = 0;

        buffer[BYTES_OFFSET] = 0;
        buffer[HASH_OFFSET   ] = H0;
        buffer[HASH_OFFSET +1] = H1;
        buffer[HASH_OFFSET +2] = H2;
        buffer[HASH_OFFSET +3] = H3;
        buffer[HASH_OFFSET +4] = H4;
    }

    /**
     * Supplements a byte to current message. <BR>
     *
     * The method overrides "engineUpdate(byte)" in class MessageDigestSpi. <BR>
     *
     * @param
     *       input byte to add to current message
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.128 -0400", hash_original_method = "7855450641F7BEAB9B605C4390783013", hash_generated_method = "4D3E123755D01FEB460C17473C4BE80F")
    
protected void engineUpdate(byte input) {

        oneByte[0] = input;
        SHA1Impl.updateHash( buffer, oneByte, 0, 0 );
        messageLength++;
    }

    /**
     * Updates current message. <BR>
     *
     * The method overrides "engineUpdate(byte[],int,int)" in class MessageDigestSpi. <BR>
     *
     * The method silently returns if "len" <= 0.
     *
     * @param
     *       input  a byte array
     * @param
     *       offset a number of first byte in the "input" array to use for updating
     * @param
     *       len    a number of bytes to use
     *
     * @throws NullPointerException
     *                if null is passed to the "buf" argument
     *
     * @throws IllegalArgumentException
     *                if offset > buf.length or len > buf.length or
     *                (len + offset) > buf.length
     * @throws ArrayIndexOutOfBoundsException
     *                offset < 0
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.128 -0400", hash_original_method = "9F0B27264067DF5350DE54F3922D4027", hash_generated_method = "F04D7AA849D0E59A9532D46F4BB3E64C")
    
protected void engineUpdate(byte[] input, int offset, int len) {
        if (input == null) {
            throw new IllegalArgumentException("input == null");
        }
        if (len <= 0) {
            return;
        }
        if (offset < 0) {
            throw new ArrayIndexOutOfBoundsException(offset);
        }
        if (offset > input.length || len > input.length || (len + offset) > input.length) {
            throw new IllegalArgumentException();
        }

        SHA1Impl.updateHash(buffer, input, offset, offset + len -1 );
        messageLength += len;
    }

}
