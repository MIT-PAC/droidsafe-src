package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.ListIterator;

class ByteArrayBuilder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.020 -0500", hash_original_field = "D90E68022A4FB3270027D1F0FF67C191", hash_generated_field = "3DAEEFED1145BF3DC7E54720D7042881")

    private static final int DEFAULT_CAPACITY = 8192;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.023 -0500", hash_original_field = "EB9567C1FECB9A49841277DD0F3CDB82", hash_generated_field = "17FC8AB839DC2BF0E0AEEEE12FA31109")

    private static final LinkedList<SoftReference<Chunk>> sPool =
            new LinkedList<SoftReference<Chunk>>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.025 -0500", hash_original_field = "DFC382CDFCA0ED4A7C72A516854B15B2", hash_generated_field = "0910402B8F1D975C39ECFC606C833B18")

    private static final ReferenceQueue<Chunk> sQueue =
            new ReferenceQueue<Chunk>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.028 -0500", hash_original_field = "80AD2E8B287372A40D02DBBE7E931F01", hash_generated_field = "B776907C1A6A4E01FFB277D178950D86")

    private LinkedList<Chunk> mChunks;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.031 -0500", hash_original_method = "4B643343F90EB2A0E25A848B20B29FC2", hash_generated_method = "70BD4D371B468DC8E79D214F46CEAA88")
    
public ByteArrayBuilder() {
        mChunks = new LinkedList<Chunk>();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.033 -0500", hash_original_method = "F99906839EA8B42FAEE592DB92B3532B", hash_generated_method = "95F08E499D14CB27445A43046C3AAE25")
    
public synchronized void append(byte[] array, int offset, int length) {
        while (length > 0) {
            Chunk c = null;
            if (mChunks.isEmpty()) {
                c = obtainChunk(length);
                mChunks.addLast(c);
            } else {
                c = mChunks.getLast();
                if (c.mLength == c.mArray.length) {
                    c = obtainChunk(length);
                    mChunks.addLast(c);
                }
            }
            int amount = Math.min(length, c.mArray.length - c.mLength);
            System.arraycopy(array, offset, c.mArray, c.mLength, amount);
            c.mLength += amount;
            length -= amount;
            offset += amount;
        }
    }

    /**
     * The fastest way to retrieve the data is to iterate through the
     * chunks.  This returns the first chunk.  Note: this pulls the
     * chunk out of the queue.  The caller must call Chunk.release() to
     * dispose of it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.035 -0500", hash_original_method = "A351746FD34CE9C266D741F531DA2BD6", hash_generated_method = "5510CCDF7848516818DD499F2303D931")
    
public synchronized Chunk getFirstChunk() {
        if (mChunks.isEmpty()) return null;
        return mChunks.removeFirst();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.037 -0500", hash_original_method = "16ED363A8E80AEA093971B1CDA828010", hash_generated_method = "20E96DBE03FE4C60996D191802380F3E")
    
public synchronized boolean isEmpty() {
        return mChunks.isEmpty();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.039 -0500", hash_original_method = "6BBE6D0629DEE9459E725081CE095168", hash_generated_method = "A894256BA5D1EA51D5D3B96D77AC722F")
    
public synchronized int getByteSize() {
        int total = 0;
        ListIterator<Chunk> it = mChunks.listIterator(0);
        while (it.hasNext()) {
            Chunk c = it.next();
            total += c.mLength;
        }
        return total;
    }
    
    public static class Chunk {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.050 -0500", hash_original_field = "F421D8AFAAC1D792F938E23541530028", hash_generated_field = "0EDCDC8DA17864CD42594730EA96D957")

        public byte[]  mArray;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.052 -0500", hash_original_field = "FC3D477E7B6A4ACE9A379E6E41129BD1", hash_generated_field = "D223D4590FC7845D7348BABCD2C232A4")

        public int     mLength;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.054 -0500", hash_original_method = "7BA2D66980388409381C11ACBE550E64", hash_generated_method = "740AD7E96BFFA77901B631A9408B80CD")
        
public Chunk(int length) {
            mArray = new byte[length];
            mLength = 0;
        }

        /**
         * Release the chunk and make it available for reuse.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.057 -0500", hash_original_method = "3768D7B4204F23A6FF321EC840D75009", hash_generated_method = "B70A91142CA8AE381D4E0ED914D64153")
        
public void release() {
            mLength = 0;
            synchronized (sPool) {
                // Add the chunk back to the pool as a SoftReference so it can
                // be gc'd if needed.
                sPool.offer(new SoftReference<Chunk>(this, sQueue));
                sPool.notifyAll();
            }
        }
        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.042 -0500", hash_original_method = "F807D4A4D9C660A6AF7B8E4ADC0E0EE6", hash_generated_method = "82672CCCE175514B81EE923AFB5FFA43")
    
public synchronized void clear() {
        Chunk c = getFirstChunk();
        while (c != null) {
            c.release();
            c = getFirstChunk();
        }
    }

    // Must be called with lock held on sPool.
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.044 -0500", hash_original_method = "3A2BA3FFD8F41065BE9E5F1BD3D65412", hash_generated_method = "7CF91C143EFCEEA7FC5F4DA321CA6FDD")
    
private void processPoolLocked() {
        while (true) {
            SoftReference<Chunk> entry = (SoftReference<Chunk>) sQueue.poll();
            if (entry == null) {
                break;
            }
            sPool.remove(entry);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.047 -0500", hash_original_method = "823F243F1FE2DDA7035072AD49FCCD96", hash_generated_method = "69947A8872E8E49A91FC0CA032020271")
    
private Chunk obtainChunk(int length) {
        // Correct a small length.
        if (length < DEFAULT_CAPACITY) {
            length = DEFAULT_CAPACITY;
        }
        synchronized (sPool) {
            // Process any queued references and remove them from the pool.
            processPoolLocked();
            if (!sPool.isEmpty()) {
                Chunk c = sPool.removeFirst().get();
                // The first item may have been queued after processPoolLocked
                // so check for null.
                if (c != null) {
                    return c;
                }
            }
            return new Chunk(length);
        }
    }
}

