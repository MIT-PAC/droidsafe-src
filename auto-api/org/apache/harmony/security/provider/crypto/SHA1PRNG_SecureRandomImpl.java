package org.apache.harmony.security.provider.crypto;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.security.SecureRandomSpi;
import libcore.io.Streams;
import libcore.util.EmptyArray;

public class SHA1PRNG_SecureRandomImpl extends SecureRandomSpi implements Serializable, SHA1_Data {
    private static final long serialVersionUID = 283736797212159675L;
    private static final int[] END_FLAGS = { 0x80000000, 0x800000, 0x8000, 0x80 };
    private static final int[] RIGHT1 = { 0, 40, 48, 56 };
    private static final int[] RIGHT2 = { 0, 8, 16, 24 };
    private static final int[] LEFT = { 0, 24, 16, 8 };
    private static final int[] MASK = { 0xFFFFFFFF, 0x00FFFFFF, 0x0000FFFF,
            0x000000FF };
    private static final int HASHBYTES_TO_USE = 20;
    private static final int FRAME_LENGTH = 16;
    private static final int COUNTER_BASE = 0;
    private static final int HASHCOPY_OFFSET = 0;
    private static final int EXTRAFRAME_OFFSET = 5;
    private static final int FRAME_OFFSET = 21;
    private static final int MAX_BYTES = 48;
    private static final int UNDEFINED = 0;
    private static final int SET_SEED = 1;
    private static final int NEXT_BYTES = 2;
    private static SHA1PRNG_SecureRandomImpl myRandom;
    private transient int[] seed;
    private transient long seedLength;
    private transient int[] copies;
    private transient byte[] nextBytes;
    private transient int nextBIndex;
    private transient long counter;
    private transient int state;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.778 -0400", hash_original_method = "D644E56206842370DC4588BE79799AE3", hash_generated_method = "10F4A9076034100C8C935D612DEA08CF")
    @DSModeled(DSC.SAFE)
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
        // ---------- Original Method ----------
        //seed = new int[HASH_OFFSET + EXTRAFRAME_OFFSET];
        //seed[HASH_OFFSET] = H0;
        //seed[HASH_OFFSET + 1] = H1;
        //seed[HASH_OFFSET + 2] = H2;
        //seed[HASH_OFFSET + 3] = H3;
        //seed[HASH_OFFSET + 4] = H4;
        //seedLength = 0;
        //copies = new int[2 * FRAME_LENGTH + EXTRAFRAME_OFFSET];
        //nextBytes = new byte[DIGEST_LENGTH];
        //nextBIndex = HASHBYTES_TO_USE;
        //counter = COUNTER_BASE;
        //state = UNDEFINED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.778 -0400", hash_original_method = "71D119B7F725F786DBF6F5411B9162C3", hash_generated_method = "7904914C43AB8047884E33F948F58DEB")
    @DSModeled(DSC.SAFE)
    private void updateSeed(byte[] bytes) {
        dsTaint.addTaint(bytes);
        SHA1Impl.updateHash(seed, bytes, 0, bytes.length - 1);
        seedLength += bytes.length;
        // ---------- Original Method ----------
        //SHA1Impl.updateHash(seed, bytes, 0, bytes.length - 1);
        //seedLength += bytes.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.778 -0400", hash_original_method = "D3CE71F13CE971E436333BDFEF7BBD46", hash_generated_method = "C5CC23BCD59AF25E3F40AE9AF590E2A9")
    @DSModeled(DSC.SAFE)
    protected synchronized void engineSetSeed(byte[] seed) {
        dsTaint.addTaint(seed);
        {
        	if (DroidSafeAndroidRuntime.control) throw new NullPointerException("seed == null");
        } //End block
        {
            System.arraycopy(copies, HASHCOPY_OFFSET, this.seed, HASH_OFFSET,
                    EXTRAFRAME_OFFSET);
        } //End block
        state = SET_SEED;
        {
            updateSeed(seed);
        } //End block
        // ---------- Original Method ----------
        //if (seed == null) {
            //throw new NullPointerException("seed == null");
        //}
        //if (state == NEXT_BYTES) { 
            //System.arraycopy(copies, HASHCOPY_OFFSET, this.seed, HASH_OFFSET,
                    //EXTRAFRAME_OFFSET);
        //}
        //state = SET_SEED;
        //if (seed.length != 0) {
            //updateSeed(seed);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.779 -0400", hash_original_method = "DD8EBB0EDF44ABE263687E4C98AB74A0", hash_generated_method = "78B12CCD65380ED155649804296F042F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected synchronized byte[] engineGenerateSeed(int numBytes) {
        dsTaint.addTaint(numBytes);
        byte[] myBytes;
        {
        	if (DroidSafeAndroidRuntime.control) throw new NegativeArraySizeException(Integer.toString(numBytes));
        } //End block
        {
            myRandom = new SHA1PRNG_SecureRandomImpl();
            myRandom.engineSetSeed(RandomBitsSupplier.getRandomBits(DIGEST_LENGTH));
        } //End block
        myBytes = new byte[numBytes];
        myRandom.engineNextBytes(myBytes);
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //byte[] myBytes;
        //if (numBytes < 0) {
            //throw new NegativeArraySizeException(Integer.toString(numBytes));
        //}
        //if (numBytes == 0) {
            //return EmptyArray.BYTE;
        //}
        //if (myRandom == null) {
            //myRandom = new SHA1PRNG_SecureRandomImpl();
            //myRandom.engineSetSeed(RandomBitsSupplier.getRandomBits(DIGEST_LENGTH));
        //}
        //myBytes = new byte[numBytes];
        //myRandom.engineNextBytes(myBytes);
        //return myBytes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.779 -0400", hash_original_method = "788172F4432069DD19F6D1F4ED0FDE85", hash_generated_method = "01D6A5BD3D5B1AB7C1840B9B8E1FA4C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected synchronized void engineNextBytes(byte[] bytes) {
        dsTaint.addTaint(bytes);
        int i, n;
        long bits;
        int nextByteToReturn;
        int lastWord;
        final int extrabytes;
        extrabytes = 7;
        {
        	if (DroidSafeAndroidRuntime.control) throw new NullPointerException("bytes == null");
        } //End block
        lastWord = seed[BYTES_OFFSET] == 0 ? 0
                : (seed[BYTES_OFFSET] + extrabytes) >> 3 - 1;
        {
            updateSeed(RandomBitsSupplier.getRandomBits(DIGEST_LENGTH));
            nextBIndex = HASHBYTES_TO_USE;
        } //End block
        {
            System.arraycopy(seed, HASH_OFFSET, copies, HASHCOPY_OFFSET,
                    EXTRAFRAME_OFFSET);
            {
                i = lastWord + 3;
                {
                    seed[i] = 0;
                } //End block
            } //End collapsed parenthetic
            bits = (seedLength << 3) + 64;
            {
                seed[14] = (int) (bits >>> 32);
                seed[15] = (int) (bits & 0xFFFFFFFF);
            } //End block
            {
                copies[EXTRAFRAME_OFFSET + 14] = (int) (bits >>> 32);
                copies[EXTRAFRAME_OFFSET + 15] = (int) (bits & 0xFFFFFFFF);
            } //End block
            nextBIndex = HASHBYTES_TO_USE;
        } //End block
        state = NEXT_BYTES;
        nextByteToReturn = 0;
        n = (HASHBYTES_TO_USE - nextBIndex) < (bytes.length - nextByteToReturn) ? HASHBYTES_TO_USE
                - nextBIndex
                : bytes.length - nextByteToReturn;
        {
            System.arraycopy(nextBytes, nextBIndex, bytes, nextByteToReturn, n);
            nextBIndex += n;
            nextByteToReturn += n;
        } //End block
        n = seed[BYTES_OFFSET] & 0x03;
        {
            {
                seed[lastWord] = (int) (counter >>> 32);
                seed[lastWord + 1] = (int) (counter & 0xFFFFFFFF);
                seed[lastWord + 2] = END_FLAGS[0];
            } //End block
            {
                seed[lastWord] |= (int) ((counter >>> RIGHT1[n]) & MASK[n]);
                seed[lastWord + 1] = (int) ((counter >>> RIGHT2[n]) & 0xFFFFFFFF);
                seed[lastWord + 2] = (int) ((counter << LEFT[n]) | END_FLAGS[n]);
            } //End block
            {
                copies[EXTRAFRAME_OFFSET] = seed[FRAME_LENGTH];
                copies[EXTRAFRAME_OFFSET + 1] = seed[FRAME_LENGTH + 1];
            } //End block
            SHA1Impl.computeHash(seed);
            {
                System.arraycopy(seed, 0, copies, FRAME_OFFSET, FRAME_LENGTH);
                System.arraycopy(copies, EXTRAFRAME_OFFSET, seed, 0,
                        FRAME_LENGTH);
                SHA1Impl.computeHash(seed);
                System.arraycopy(copies, FRAME_OFFSET, seed, 0, FRAME_LENGTH);
            } //End block
            counter++;
            int j;
            j = 0;
            {
                i = 0;
                {
                    int k;
                    k = seed[HASH_OFFSET + i];
                    nextBytes[j] = (byte) (k >>> 24);
                    nextBytes[j + 1] = (byte) (k >>> 16);
                    nextBytes[j + 2] = (byte) (k >>> 8);
                    nextBytes[j + 3] = (byte) (k);
                    j += 4;
                } //End block
            } //End collapsed parenthetic
            nextBIndex = 0;
            j = HASHBYTES_TO_USE < (bytes.length - nextByteToReturn) ? HASHBYTES_TO_USE
                    : bytes.length - nextByteToReturn;
            {
                System.arraycopy(nextBytes, 0, bytes, nextByteToReturn, j);
                nextByteToReturn += j;
                nextBIndex += j;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.780 -0400", hash_original_method = "716FAD60FA2495E9DABF23B35E588917", hash_generated_method = "9443F10CCECFD8C8B0CFC2B6B91DD41F")
    @DSModeled(DSC.SAFE)
    private void writeObject(ObjectOutputStream oos) throws IOException {
        dsTaint.addTaint(oos.dsTaint);
        int[] intData;
        intData = null;
        final int only_hash;
        only_hash = EXTRAFRAME_OFFSET;
        final int hashes_and_frame;
        hashes_and_frame = EXTRAFRAME_OFFSET * 2 + FRAME_LENGTH;
        final int hashes_and_frame_extra;
        hashes_and_frame_extra = EXTRAFRAME_OFFSET * 2 + FRAME_LENGTH
                * 2;
        oos.writeLong(seedLength);
        oos.writeLong(counter);
        oos.writeInt(state);
        oos.writeInt(seed[BYTES_OFFSET]);
        int nRemaining;
        nRemaining = (seed[BYTES_OFFSET] + 3) >> 2;
        {
            intData = new int[only_hash + nRemaining];
            System.arraycopy(seed, 0, intData, 0, nRemaining);
            System.arraycopy(seed, HASH_OFFSET, intData, nRemaining,
                    EXTRAFRAME_OFFSET);
        } //End block
        {
            int offset;
            offset = 0;
            {
                intData = new int[hashes_and_frame + nRemaining];
            } //End block
            {
                intData = new int[hashes_and_frame_extra + nRemaining];
                intData[offset] = seed[FRAME_LENGTH];
                intData[offset + 1] = seed[FRAME_LENGTH + 1];
                intData[offset + 2] = seed[FRAME_LENGTH + 14];
                intData[offset + 3] = seed[FRAME_LENGTH + 15];
                offset += 4;
            } //End block
            System.arraycopy(seed, 0, intData, offset, FRAME_LENGTH);
            offset += FRAME_LENGTH;
            System.arraycopy(copies, FRAME_LENGTH + EXTRAFRAME_OFFSET, intData,
                    offset, nRemaining);
            offset += nRemaining;
            System.arraycopy(copies, 0, intData, offset, EXTRAFRAME_OFFSET);
            offset += EXTRAFRAME_OFFSET;
            System.arraycopy(seed, HASH_OFFSET, intData, offset,
                    EXTRAFRAME_OFFSET);
        } //End block
        {
            int i;
            i = 0;
            {
                oos.writeInt(intData[i]);
            } //End block
        } //End collapsed parenthetic
        oos.writeInt(nextBIndex);
        oos.write(nextBytes, nextBIndex, HASHBYTES_TO_USE - nextBIndex);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.780 -0400", hash_original_method = "87BDC97ACB5596298F61FE4642318DFC", hash_generated_method = "707E5DD4A85D091B3C01D82A7FDB457A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(ObjectInputStream ois) throws IOException,
            ClassNotFoundException {
        dsTaint.addTaint(ois.dsTaint);
        seed = new int[HASH_OFFSET + EXTRAFRAME_OFFSET];
        copies = new int[2 * FRAME_LENGTH + EXTRAFRAME_OFFSET];
        nextBytes = new byte[DIGEST_LENGTH];
        seedLength = ois.readLong();
        counter = ois.readLong();
        state = ois.readInt();
        seed[BYTES_OFFSET] = ois.readInt();
        int nRemaining;
        nRemaining = (seed[BYTES_OFFSET] + 3) >> 2;
        {
            {
                int i;
                i = 0;
                {
                    seed[i] = ois.readInt();
                } //End block
            } //End collapsed parenthetic
            {
                int i;
                i = 0;
                {
                    seed[HASH_OFFSET + i] = ois.readInt();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                seed[FRAME_LENGTH] = ois.readInt();
                seed[FRAME_LENGTH + 1] = ois.readInt();
                seed[FRAME_LENGTH + 14] = ois.readInt();
                seed[FRAME_LENGTH + 15] = ois.readInt();
            } //End block
            {
                int i;
                i = 0;
                {
                    seed[i] = ois.readInt();
                } //End block
            } //End collapsed parenthetic
            {
                int i;
                i = 0;
                {
                    copies[FRAME_LENGTH + EXTRAFRAME_OFFSET + i] = ois.readInt();
                } //End block
            } //End collapsed parenthetic
            {
                int i;
                i = 0;
                {
                    copies[i] = ois.readInt();
                } //End block
            } //End collapsed parenthetic
            {
                int i;
                i = 0;
                {
                    seed[HASH_OFFSET + i] = ois.readInt();
                } //End block
            } //End collapsed parenthetic
        } //End block
        nextBIndex = ois.readInt();
        Streams.readFully(ois, nextBytes, nextBIndex, HASHBYTES_TO_USE - nextBIndex);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}


