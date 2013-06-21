package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.ListIterator;

class ByteArrayBuilder {
    private LinkedList<Chunk> mChunks;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.735 -0400", hash_original_method = "4B643343F90EB2A0E25A848B20B29FC2", hash_generated_method = "585D3F9A7DBBC98189950DBD22ABFA56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ByteArrayBuilder() {
        mChunks = new LinkedList<Chunk>();
        // ---------- Original Method ----------
        //mChunks = new LinkedList<Chunk>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.735 -0400", hash_original_method = "F99906839EA8B42FAEE592DB92B3532B", hash_generated_method = "2AE1C25C530862EC41D8CBB1F221FA37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void append(byte[] array, int offset, int length) {
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(array[0]);
        {
            Chunk c;
            c = null;
            {
                boolean var8993D16895D6DD6A19E8FE9C22420F8A_1348239293 = (mChunks.isEmpty());
                {
                    c = obtainChunk(length);
                    mChunks.addLast(c);
                } //End block
                {
                    c = mChunks.getLast();
                    {
                        c = obtainChunk(length);
                        mChunks.addLast(c);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            int amount;
            amount = Math.min(length, c.mArray.length - c.mLength);
            System.arraycopy(array, offset, c.mArray, c.mLength, amount);
            c.mLength += amount;
            length -= amount;
            offset += amount;
        } //End block
        // ---------- Original Method ----------
        //while (length > 0) {
            //Chunk c = null;
            //if (mChunks.isEmpty()) {
                //c = obtainChunk(length);
                //mChunks.addLast(c);
            //} else {
                //c = mChunks.getLast();
                //if (c.mLength == c.mArray.length) {
                    //c = obtainChunk(length);
                    //mChunks.addLast(c);
                //}
            //}
            //int amount = Math.min(length, c.mArray.length - c.mLength);
            //System.arraycopy(array, offset, c.mArray, c.mLength, amount);
            //c.mLength += amount;
            //length -= amount;
            //offset += amount;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.736 -0400", hash_original_method = "A351746FD34CE9C266D741F531DA2BD6", hash_generated_method = "73DBA37B5284AF77912A83DD70F629E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized Chunk getFirstChunk() {
        {
            boolean var80D64A7912806675BFE8C9AA767A8E24_1642503650 = (mChunks.isEmpty());
        } //End collapsed parenthetic
        Chunk varBED15748858B08225169C7B490568F93_1430723777 = (mChunks.removeFirst());
        return (Chunk)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mChunks.isEmpty()) return null;
        //return mChunks.removeFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.736 -0400", hash_original_method = "16ED363A8E80AEA093971B1CDA828010", hash_generated_method = "59DF5316E8A73A63F29D38BAA7DB1095")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized boolean isEmpty() {
        boolean varB17D8418AFE521C924103445195E283C_1810651815 = (mChunks.isEmpty());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mChunks.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.736 -0400", hash_original_method = "6BBE6D0629DEE9459E725081CE095168", hash_generated_method = "FE4C4D491031BFCF67001514F071BB80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int getByteSize() {
        int total;
        total = 0;
        ListIterator<Chunk> it;
        it = mChunks.listIterator(0);
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1707582555 = (it.hasNext());
            {
                Chunk c;
                c = it.next();
                total += c.mLength;
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int total = 0;
        //ListIterator<Chunk> it = mChunks.listIterator(0);
        //while (it.hasNext()) {
            //Chunk c = it.next();
            //total += c.mLength;
        //}
        //return total;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.736 -0400", hash_original_method = "F807D4A4D9C660A6AF7B8E4ADC0E0EE6", hash_generated_method = "A590C9738B98A77072BF7BAC53812C73")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void clear() {
        Chunk c;
        c = getFirstChunk();
        {
            c.release();
            c = getFirstChunk();
        } //End block
        // ---------- Original Method ----------
        //Chunk c = getFirstChunk();
        //while (c != null) {
            //c.release();
            //c = getFirstChunk();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.737 -0400", hash_original_method = "3A2BA3FFD8F41065BE9E5F1BD3D65412", hash_generated_method = "61414B73D9015B49B54B9C0158F8D5E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void processPoolLocked() {
        {
            SoftReference<Chunk> entry;
            entry = (SoftReference<Chunk>) sQueue.poll();
            sPool.remove(entry);
        } //End block
        // ---------- Original Method ----------
        //while (true) {
            //SoftReference<Chunk> entry = (SoftReference<Chunk>) sQueue.poll();
            //if (entry == null) {
                //break;
            //}
            //sPool.remove(entry);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.737 -0400", hash_original_method = "823F243F1FE2DDA7035072AD49FCCD96", hash_generated_method = "50DD5E90107C1C3DA004BD60541A4C54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Chunk obtainChunk(int length) {
        dsTaint.addTaint(length);
        {
            length = DEFAULT_CAPACITY;
        } //End block
        {
            processPoolLocked();
            {
                boolean varADDBC07E5FAD7BBD438CB737F9DBE3FD_1572907125 = (!sPool.isEmpty());
                {
                    Chunk c;
                    c = sPool.removeFirst().get();
                } //End block
            } //End collapsed parenthetic
            Chunk varB5D7D70A365A012818325415A50F09C5_544045027 = (new Chunk(length));
        } //End block
        return (Chunk)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (length < DEFAULT_CAPACITY) {
            //length = DEFAULT_CAPACITY;
        //}
        //synchronized (sPool) {
            //processPoolLocked();
            //if (!sPool.isEmpty()) {
                //Chunk c = sPool.removeFirst().get();
                //if (c != null) {
                    //return c;
                //}
            //}
            //return new Chunk(length);
        //}
    }

    
    public static class Chunk {
        public byte[]  mArray;
        public int     mLength;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.737 -0400", hash_original_method = "7BA2D66980388409381C11ACBE550E64", hash_generated_method = "3BFCC6C8E8236A09245E00E8D82DEBEC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Chunk(int length) {
            dsTaint.addTaint(length);
            mArray = new byte[length];
            mLength = 0;
            // ---------- Original Method ----------
            //mArray = new byte[length];
            //mLength = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.737 -0400", hash_original_method = "3768D7B4204F23A6FF321EC840D75009", hash_generated_method = "7A59FCD8915A433718155A60AACFA1A8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void release() {
            mLength = 0;
            {
                sPool.offer(new SoftReference<Chunk>(this, sQueue));
                sPool.notifyAll();
            } //End block
            // ---------- Original Method ----------
            //mLength = 0;
            //synchronized (sPool) {
                //sPool.offer(new SoftReference<Chunk>(this, sQueue));
                //sPool.notifyAll();
            //}
        }

        
    }


    
    private static final int DEFAULT_CAPACITY = 8192;
    private static final LinkedList<SoftReference<Chunk>> sPool =
            new LinkedList<SoftReference<Chunk>>();
    private static final ReferenceQueue<Chunk> sQueue =
            new ReferenceQueue<Chunk>();
}

