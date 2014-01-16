package org.apache.harmony.security.provider.crypto;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.SecureRandomSpi;

import libcore.io.Streams;
import libcore.util.EmptyArray;

public class SHA1PRNG_SecureRandomImpl extends SecureRandomSpi implements Serializable, SHA1_Data {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:03.846 -0500", hash_original_field = "6F03A5AC2EC741E6E21992044EC9E20A", hash_generated_field = "0572D6ADF8B4E59E97C497432F887795")

    private static final long serialVersionUID = 283736797212159675L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:03.848 -0500", hash_original_field = "60A82CC01099C7BAF874DAE854BC3873", hash_generated_field = "0F1C325B708C29F28B9D69D7577CC406")

    // END_FLAGS - final bytes in words to append to message;
    //             see "ch.5.1 Padding the Message, FIPS 180-2"
    // RIGHT1    - shifts to right for left half of long
    // RIGHT2    - shifts to right for right half of long
    // LEFT      - shifts to left for bytes
    // MASK      - mask to select counter's bytes after shift to right

    private static final int[] END_FLAGS = { 0x80000000, 0x800000, 0x8000, 0x80 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:03.851 -0500", hash_original_field = "A3597CAB9F9B70F78CB01E1E962409FE", hash_generated_field = "5C807BEE19CE765B4317F673B97DF948")

    private static final int[] RIGHT1 = { 0, 40, 48, 56 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:03.853 -0500", hash_original_field = "B5DF17BA81F90ACA0C2CCF658BE65002", hash_generated_field = "EAE2B62B1EF3A743512A0964184AADD2")

    private static final int[] RIGHT2 = { 0, 8, 16, 24 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:03.855 -0500", hash_original_field = "B6787AC593801E247278B20C503DAC3A", hash_generated_field = "B0E4A4E8E92603834DE04BB669F210A3")

    private static final int[] LEFT = { 0, 24, 16, 8 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:03.858 -0500", hash_original_field = "4BA2F89887BE125CE4FDA3872EB2FB82", hash_generated_field = "5ED2E9AA85783BAD621E242DDC93B094")

    private static final int[] MASK = { 0xFFFFFFFF, 0x00FFFFFF, 0x0000FFFF,
            0x000000FF };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:03.861 -0500", hash_original_field = "C7AD854AF7070C51A14A14E85D47CF39", hash_generated_field = "DE929ED7A1883F2A024A60E49078ACF1")

    // to use to form byte array returning by the "nextBytes(byte[])" method
    // Note, that this implementation uses more bytes than it is defined
    // in the above specification.
    private static final int HASHBYTES_TO_USE = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:03.863 -0500", hash_original_field = "6B29BD59424A4F1C1A2F836F9DBF6862", hash_generated_field = "7E064B495B5339B29C44E33FD9B2BEB9")

    private static final int FRAME_LENGTH = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:03.866 -0500", hash_original_field = "66BFF3251C2507D6E7BB7AB2E27CF8C0", hash_generated_field = "F9A61A72C3D0AC9C2EB4D43A646C66D3")

    // COUNTER_BASE - initial value to set to "counter" before computing "nextBytes(..)";
    //                note, that the exact value is not defined in STANDARD
    // HASHCOPY_OFFSET   - offset for copy of current hash in "copies" array
    // EXTRAFRAME_OFFSET - offset for extra frame in "copies" array;
    //                     as the extra frame follows the current hash frame,
    //                     EXTRAFRAME_OFFSET is equal to length of current hash frame
    // FRAME_OFFSET      - offset for frame in "copies" array
    // MAX_BYTES - maximum # of seed bytes processing which doesn't require extra frame
    //             see (1) comments on usage of "seed" array below and
    //             (2) comments in "engineNextBytes(byte[])" method
    //
    // UNDEFINED  - three states of engine; initially its state is "UNDEFINED"
    // SET_SEED     call to "engineSetSeed"  sets up "SET_SEED" state,
    // NEXT_BYTES   call to "engineNextByte" sets up "NEXT_BYTES" state

    private static final int COUNTER_BASE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:03.869 -0500", hash_original_field = "D91CE7754FB2AAD93BB2ED44153EDD46", hash_generated_field = "FC08696CCFA3EE206632295D5608E52A")

    private static final int HASHCOPY_OFFSET = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:03.871 -0500", hash_original_field = "50763DBF508EAE5AC2FA012522F30F0E", hash_generated_field = "BDC895B0D82A3B69363AB3B21E484915")

    private static final int EXTRAFRAME_OFFSET = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:03.874 -0500", hash_original_field = "CE1D88E6ACC97EF54DFCB7F7C36E5635", hash_generated_field = "D124EA7B91A1E166C74CB5971C4654D2")

    private static final int FRAME_OFFSET = 21;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:03.876 -0500", hash_original_field = "C5089646A7A1EABB39E57DED21CF5BE3", hash_generated_field = "16F5CCEF9F3F7B3A8F222B597A35CCA0")

    private static final int MAX_BYTES = 48;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:03.879 -0500", hash_original_field = "76543FBD60BDE03E72033EDE3CFE4116", hash_generated_field = "0DF11F4AAB291BF53347A9E765D366AE")

    private static final int UNDEFINED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:03.881 -0500", hash_original_field = "1CE9ED40DD56F00D2B174CD7ADC11648", hash_generated_field = "70F1EFD63BAB99FD438DDC5003389359")

    private static final int SET_SEED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:03.884 -0500", hash_original_field = "2C5DE8B3C43DC2FBE7D337554C2BEC79", hash_generated_field = "C7803B16145BE4E5D1B39E398B4A7566")

    private static final int NEXT_BYTES = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:03.886 -0500", hash_original_field = "5B4AC7C3AA889606B4A9C7B25C35A4FF", hash_generated_field = "8D0E7E89B95D023E9161984B3CF40ACF")

    private static SHA1PRNG_SecureRandomImpl myRandom;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:03.888 -0500", hash_original_field = "3900C177E5826B2C8E23E54E341EEF94", hash_generated_field = "3A8DBD8D358FE4BE848C2D6E312D8C3C")

    // -  0-79 - words for computing hash
    // - 80    - unused
    // - 81    - # of seed bytes in current seed frame
    // - 82-86 - 5 words, current seed hash
    private transient int[] seed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:03.891 -0500", hash_original_field = "FAC6A0DA8B0258B2B15A534742CE3D6A", hash_generated_field = "83E016BC8F9F281AEFFD444105646AA9")

    private transient long seedLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:03.893 -0500", hash_original_field = "A81CEEC5472639ECC84F1FA5C2337026", hash_generated_field = "E24484E69995031206F55EC230493B85")

    // -  0-4  - 5 words, copy of current seed hash
    // -  5-20 - extra 16 words frame;
    //           is used if  padding exceeds 512-bit length
    // - 21-36 - 16 word frame to store a copy of remaining bytes
    private transient int[] copies;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:03.896 -0500", hash_original_field = "7F0303B8B69315B79F1443224FFA24C1", hash_generated_field = "0965AA7A7376EC05762FAF3451426E68")

    private transient byte[] nextBytes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:03.898 -0500", hash_original_field = "A29F62382E3D6283344824E4B617CE0D", hash_generated_field = "E17BB00B83C020C7021F5FEF67FD5BB0")

    private transient int nextBIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:03.900 -0500", hash_original_field = "D55B002A6A8F37CC045F356950CAB689", hash_generated_field = "AD2EEEFD65883FBF954D83EC27AF4609")

    private transient long counter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:03.902 -0500", hash_original_field = "962E680994F097CBCF73193974918C63", hash_generated_field = "83BF4AAE59CAAA48C8661EF5F4399BE3")

    private transient int state;

    // The "seed" array is used to compute both "current seed hash" and "next bytes".
    //
    // As the "SHA1" algorithm computes a hash of entire seed by splitting it into
    // a number of the 512-bit length frames (512 bits = 64 bytes = 16 words),
    // "current seed hash" is a hash (5 words, 20 bytes) for all previous full frames;
    // remaining bytes are stored in the 0-15 word frame of the "seed" array.
    //
    // As for calculating "next bytes",
    // both remaining bytes and "current seed hash" are used,
    // to preserve the latter for following "setSeed(..)" commands,
    // the following technique is used:
    // - upon getting "nextBytes(byte[])" invoked, single or first in row,
    //   which requires computing new hash, that is,
    //   there is no more bytes remaining from previous "next bytes" computation,
    //   remaining bytes are copied into the 21-36 word frame of the "copies" array;
    // - upon getting "setSeed(byte[])" invoked, single or first in row,
    //   remaining bytes are copied back.

    /**
     *  Creates object and sets implementation variables to their initial values
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:03.906 -0500", hash_original_method = "D644E56206842370DC4588BE79799AE3", hash_generated_method = "DF9C009961D95E0DC22956E98C1707F5")
    
public SHA1PRNG_SecureRandomImpl() {

        seed = new int[HASH_OFFSET + EXTRAFRAME_OFFSET];
        seed[HASH_OFFSET] = H0;
        seed[HASH_OFFSET + 1] = H1;
        seed[HASH_OFFSET + 2] = H2;
        seed[HASH_OFFSET + 3] = H3;
        seed[HASH_OFFSET + 4] = H4;

        seedLength = 0;
        copies = new int[2 * FRAME_LENGTH + EXTRAFRAME_OFFSET];
        nextBytes = new byte[DIGEST_LENGTH];
        nextBIndex = HASHBYTES_TO_USE;
        counter = COUNTER_BASE;
        state = UNDEFINED;
    }

    /*
     * The method invokes the SHA1Impl's "updateHash(..)" method
     * to update current seed frame and
     * to compute new intermediate hash value if the frame is full.
     *
     * After that it computes a length of whole seed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:03.908 -0500", hash_original_method = "71D119B7F725F786DBF6F5411B9162C3", hash_generated_method = "4A1195A2F6F98D960D738679187CC73C")
    
private void updateSeed(byte[] bytes) {

        // on call:   "seed" contains current bytes and current hash;
        // on return: "seed" contains new current bytes and possibly new current hash
        //            if after adding, seed bytes overfill its buffer
        SHA1Impl.updateHash(seed, bytes, 0, bytes.length - 1);

        seedLength += bytes.length;
    }

    /**
     * Changes current seed by supplementing a seed argument to the current seed,
     * if this already set;
     * the argument is used as first seed otherwise. <BR>
     *
     * The method overrides "engineSetSeed(byte[])" in class SecureRandomSpi.
     *
     * @param
     *       seed - byte array
     * @throws
     *       NullPointerException - if null is passed to the "seed" argument
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:03.911 -0500", hash_original_method = "D3CE71F13CE971E436333BDFEF7BBD46", hash_generated_method = "A6D87286F5C72C2CE859A3AB5D36EB41")
    
protected synchronized void engineSetSeed(byte[] seed) {

        if (seed == null) {
            throw new NullPointerException("seed == null");
        }

        if (state == NEXT_BYTES) { // first setSeed after NextBytes; restoring hash
            System.arraycopy(copies, HASHCOPY_OFFSET, this.seed, HASH_OFFSET,
                    EXTRAFRAME_OFFSET);
        }
        state = SET_SEED;

        if (seed.length != 0) {
            updateSeed(seed);
        }
    }

    /**
     * Returns a required number of random bytes. <BR>
     *
     * The method overrides "engineGenerateSeed (int)" in class SecureRandomSpi. <BR>
     *
     * @param
     *       numBytes - number of bytes to return; should be >= 0.
     * @return
     *       byte array containing bits in order from left to right
     * @throws
     *       InvalidParameterException - if numBytes < 0
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:03.914 -0500", hash_original_method = "DD8EBB0EDF44ABE263687E4C98AB74A0", hash_generated_method = "DF02DED43394811F487DC203A1224014")
    
protected synchronized byte[] engineGenerateSeed(int numBytes) {

        byte[] myBytes; // byte[] for bytes returned by "nextBytes()"

        if (numBytes < 0) {
            throw new NegativeArraySizeException(Integer.toString(numBytes));
        }
        if (numBytes == 0) {
            return EmptyArray.BYTE;
        }

        if (myRandom == null) {
            myRandom = new SHA1PRNG_SecureRandomImpl();
            myRandom.engineSetSeed(RandomBitsSupplier.getRandomBits(DIGEST_LENGTH));
        }

        myBytes = new byte[numBytes];
        myRandom.engineNextBytes(myBytes);

        return myBytes;
    }

    /**
     * Writes random bytes into an array supplied.
     * Bits in a byte are from left to right. <BR>
     *
     * To generate random bytes, the "expansion of source bits" method is used,
     * that is,
     * the current seed with a 64-bit counter appended is used to compute new bits.
     * The counter is incremented by 1 for each 20-byte output. <BR>
     *
     * The method overrides engineNextBytes in class SecureRandomSpi.
     *
     * @param
     *       bytes - byte array to be filled in with bytes
     * @throws
     *       NullPointerException - if null is passed to the "bytes" argument
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:03.918 -0500", hash_original_method = "788172F4432069DD19F6D1F4ED0FDE85", hash_generated_method = "B16D1BB8705D157654A596714DBB3827")
    
protected synchronized void engineNextBytes(byte[] bytes) {

        int i, n;

        long bits; // number of bits required by Secure Hash Standard
        int nextByteToReturn; // index of ready bytes in "bytes" array
        int lastWord; // index of last word in frame containing bytes
        final int extrabytes = 7;// # of bytes to add in order to computer # of 8 byte words

        if (bytes == null) {
            throw new NullPointerException("bytes == null");
        }

        lastWord = seed[BYTES_OFFSET] == 0 ? 0
                : (seed[BYTES_OFFSET] + extrabytes) >> 3 - 1;

        if (state == UNDEFINED) {

            // no seed supplied by user, hence it is generated thus randomizing internal state
            updateSeed(RandomBitsSupplier.getRandomBits(DIGEST_LENGTH));
            nextBIndex = HASHBYTES_TO_USE;

        } else if (state == SET_SEED) {

            System.arraycopy(seed, HASH_OFFSET, copies, HASHCOPY_OFFSET,
                    EXTRAFRAME_OFFSET);

            // possible cases for 64-byte frame:
            //
            // seed bytes < 48      - remaining bytes are enough for all, 8 counter bytes,
            //                        0x80, and 8 seedLength bytes; no extra frame required
            // 48 < seed bytes < 56 - remaining 9 bytes are for 0x80 and 8 counter bytes
            //                        extra frame contains only seedLength value at the end
            // seed bytes > 55      - extra frame contains both counter's bytes
            //                        at the beginning and seedLength value at the end;
            //                        note, that beginning extra bytes are not more than 8,
            //                        that is, only 2 extra words may be used

            // no need to set to "0" 3 words after "lastWord" and
            // more than two words behind frame
            for (i = lastWord + 3; i < FRAME_LENGTH + 2; i++) {
                seed[i] = 0;
            }

            bits = (seedLength << 3) + 64; // transforming # of bytes into # of bits

            // putting # of bits into two last words (14,15) of 16 word frame in
            // seed or copies array depending on total length after padding
            if (seed[BYTES_OFFSET] < MAX_BYTES) {
                seed[14] = (int) (bits >>> 32);
                seed[15] = (int) (bits & 0xFFFFFFFF);
            } else {
                copies[EXTRAFRAME_OFFSET + 14] = (int) (bits >>> 32);
                copies[EXTRAFRAME_OFFSET + 15] = (int) (bits & 0xFFFFFFFF);
            }

            nextBIndex = HASHBYTES_TO_USE; // skipping remaining random bits
        }
        state = NEXT_BYTES;

        if (bytes.length == 0) {
            return;
        }

        nextByteToReturn = 0;

        // possibly not all of HASHBYTES_TO_USE bytes were used previous time
        n = (HASHBYTES_TO_USE - nextBIndex) < (bytes.length - nextByteToReturn) ? HASHBYTES_TO_USE
                - nextBIndex
                : bytes.length - nextByteToReturn;
        if (n > 0) {
            System.arraycopy(nextBytes, nextBIndex, bytes, nextByteToReturn, n);
            nextBIndex += n;
            nextByteToReturn += n;
        }

        if (nextByteToReturn >= bytes.length) {
            return; // return because "bytes[]" are filled in
        }

        n = seed[BYTES_OFFSET] & 0x03;
        for (;;) {
            if (n == 0) {

                seed[lastWord] = (int) (counter >>> 32);
                seed[lastWord + 1] = (int) (counter & 0xFFFFFFFF);
                seed[lastWord + 2] = END_FLAGS[0];

            } else {

                seed[lastWord] |= (int) ((counter >>> RIGHT1[n]) & MASK[n]);
                seed[lastWord + 1] = (int) ((counter >>> RIGHT2[n]) & 0xFFFFFFFF);
                seed[lastWord + 2] = (int) ((counter << LEFT[n]) | END_FLAGS[n]);
            }
            if (seed[BYTES_OFFSET] > MAX_BYTES) {
                copies[EXTRAFRAME_OFFSET] = seed[FRAME_LENGTH];
                copies[EXTRAFRAME_OFFSET + 1] = seed[FRAME_LENGTH + 1];
            }

            SHA1Impl.computeHash(seed);

            if (seed[BYTES_OFFSET] > MAX_BYTES) {

                System.arraycopy(seed, 0, copies, FRAME_OFFSET, FRAME_LENGTH);
                System.arraycopy(copies, EXTRAFRAME_OFFSET, seed, 0,
                        FRAME_LENGTH);

                SHA1Impl.computeHash(seed);
                System.arraycopy(copies, FRAME_OFFSET, seed, 0, FRAME_LENGTH);
            }
            counter++;

            int j = 0;
            for (i = 0; i < EXTRAFRAME_OFFSET; i++) {
                int k = seed[HASH_OFFSET + i];
                nextBytes[j] = (byte) (k >>> 24); // getting first  byte from left
                nextBytes[j + 1] = (byte) (k >>> 16); // getting second byte from left
                nextBytes[j + 2] = (byte) (k >>> 8); // getting third  byte from left
                nextBytes[j + 3] = (byte) (k); // getting fourth byte from left
                j += 4;
            }

            nextBIndex = 0;
            j = HASHBYTES_TO_USE < (bytes.length - nextByteToReturn) ? HASHBYTES_TO_USE
                    : bytes.length - nextByteToReturn;

            if (j > 0) {
                System.arraycopy(nextBytes, 0, bytes, nextByteToReturn, j);
                nextByteToReturn += j;
                nextBIndex += j;
            }

            if (nextByteToReturn >= bytes.length) {
                break;
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:03.922 -0500", hash_original_method = "716FAD60FA2495E9DABF23B35E588917", hash_generated_method = "D69CBD4AB153720E4ABBC92D1EB7AAC4")
    
private void writeObject(ObjectOutputStream oos) throws IOException {

        int[] intData = null;

        final int only_hash = EXTRAFRAME_OFFSET;
        final int hashes_and_frame = EXTRAFRAME_OFFSET * 2 + FRAME_LENGTH;
        final int hashes_and_frame_extra = EXTRAFRAME_OFFSET * 2 + FRAME_LENGTH
                * 2;

        oos.writeLong(seedLength);
        oos.writeLong(counter);
        oos.writeInt(state);
        oos.writeInt(seed[BYTES_OFFSET]);

        int nRemaining = (seed[BYTES_OFFSET] + 3) >> 2; // converting bytes in words
        // result may be 0
        if (state != NEXT_BYTES) {

            // either the state is UNDEFINED or previous method was "setSeed(..)"
            // so in "seed[]" to serialize are remaining bytes (seed[0-nRemaining]) and
            // current hash (seed[82-86])

            intData = new int[only_hash + nRemaining];

            System.arraycopy(seed, 0, intData, 0, nRemaining);
            System.arraycopy(seed, HASH_OFFSET, intData, nRemaining,
                    EXTRAFRAME_OFFSET);

        } else {
            // previous method was "nextBytes(..)"
            // so, data to serialize are all the above (two first are in "copies" array)
            // and current words in both frame and extra frame (as if)

            int offset = 0;
            if (seed[BYTES_OFFSET] < MAX_BYTES) { // no extra frame

                intData = new int[hashes_and_frame + nRemaining];

            } else { // extra frame is used

                intData = new int[hashes_and_frame_extra + nRemaining];

                intData[offset] = seed[FRAME_LENGTH];
                intData[offset + 1] = seed[FRAME_LENGTH + 1];
                intData[offset + 2] = seed[FRAME_LENGTH + 14];
                intData[offset + 3] = seed[FRAME_LENGTH + 15];
                offset += 4;
            }

            System.arraycopy(seed, 0, intData, offset, FRAME_LENGTH);
            offset += FRAME_LENGTH;

            System.arraycopy(copies, FRAME_LENGTH + EXTRAFRAME_OFFSET, intData,
                    offset, nRemaining);
            offset += nRemaining;

            System.arraycopy(copies, 0, intData, offset, EXTRAFRAME_OFFSET);
            offset += EXTRAFRAME_OFFSET;

            System.arraycopy(seed, HASH_OFFSET, intData, offset,
                    EXTRAFRAME_OFFSET);
        }
        for (int i = 0; i < intData.length; i++) {
            oos.writeInt(intData[i]);
        }

        oos.writeInt(nextBIndex);
        oos.write(nextBytes, nextBIndex, HASHBYTES_TO_USE - nextBIndex);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:03.926 -0500", hash_original_method = "87BDC97ACB5596298F61FE4642318DFC", hash_generated_method = "590F04898F9D59A6A9E462377985AEC6")
    
private void readObject(ObjectInputStream ois) throws IOException,
            ClassNotFoundException {

        seed = new int[HASH_OFFSET + EXTRAFRAME_OFFSET];
        copies = new int[2 * FRAME_LENGTH + EXTRAFRAME_OFFSET];
        nextBytes = new byte[DIGEST_LENGTH];

        seedLength = ois.readLong();
        counter = ois.readLong();
        state = ois.readInt();
        seed[BYTES_OFFSET] = ois.readInt();

        int nRemaining = (seed[BYTES_OFFSET] + 3) >> 2; // converting bytes in words

        if (state != NEXT_BYTES) {

            for (int i = 0; i < nRemaining; i++) {
                seed[i] = ois.readInt();
            }
            for (int i = 0; i < EXTRAFRAME_OFFSET; i++) {
                seed[HASH_OFFSET + i] = ois.readInt();
            }
        } else {
            if (seed[BYTES_OFFSET] >= MAX_BYTES) {

                // reading next bytes in seed extra frame
                seed[FRAME_LENGTH] = ois.readInt();
                seed[FRAME_LENGTH + 1] = ois.readInt();
                seed[FRAME_LENGTH + 14] = ois.readInt();
                seed[FRAME_LENGTH + 15] = ois.readInt();
            }
            // reading next bytes in seed frame
            for (int i = 0; i < FRAME_LENGTH; i++) {
                seed[i] = ois.readInt();
            }
            // reading remaining seed bytes
            for (int i = 0; i < nRemaining; i++) {
                copies[FRAME_LENGTH + EXTRAFRAME_OFFSET + i] = ois.readInt();
            }
            // reading copy of current hash
            for (int i = 0; i < EXTRAFRAME_OFFSET; i++) {
                copies[i] = ois.readInt();
            }
            // reading current hash
            for (int i = 0; i < EXTRAFRAME_OFFSET; i++) {
                seed[HASH_OFFSET + i] = ois.readInt();
            }
        }

        nextBIndex = ois.readInt();
        Streams.readFully(ois, nextBytes, nextBIndex, HASHBYTES_TO_USE - nextBIndex);
    }
}

