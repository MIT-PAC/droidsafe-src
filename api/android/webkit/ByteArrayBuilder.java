package android.webkit;

// Droidsafe Imports
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.ListIterator;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

class ByteArrayBuilder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.330 -0400", hash_original_field = "D96663553B59C302287984487A58CF9F", hash_generated_field = "B776907C1A6A4E01FFB277D178950D86")

    private LinkedList<Chunk> mChunks;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.331 -0400", hash_original_method = "4B643343F90EB2A0E25A848B20B29FC2", hash_generated_method = "585D3F9A7DBBC98189950DBD22ABFA56")
    public  ByteArrayBuilder() {
        mChunks = new LinkedList<Chunk>();
        // ---------- Original Method ----------
        //mChunks = new LinkedList<Chunk>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.332 -0400", hash_original_method = "F99906839EA8B42FAEE592DB92B3532B", hash_generated_method = "F716C9B9F59A870F6651BA318CF060D1")
    public synchronized void append(byte[] array, int offset, int length) {
        addTaint(length);
        addTaint(offset);
        addTaint(array[0]);
        while
(length > 0)        
        {
            Chunk c = null;
            if(mChunks.isEmpty())            
            {
                c = obtainChunk(length);
                mChunks.addLast(c);
            } //End block
            else
            {
                c = mChunks.getLast();
                if(c.mLength == c.mArray.length)                
                {
                    c = obtainChunk(length);
                    mChunks.addLast(c);
                } //End block
            } //End block
            int amount = Math.min(length, c.mArray.length - c.mLength);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.332 -0400", hash_original_method = "A351746FD34CE9C266D741F531DA2BD6", hash_generated_method = "DF09C529AA47FA5F2C0238F46905AACF")
    public synchronized Chunk getFirstChunk() {
        if(mChunks.isEmpty())        
        {
Chunk var540C13E9E156B687226421B24F2DF178_935332142 =         null;
        var540C13E9E156B687226421B24F2DF178_935332142.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_935332142;
        }
Chunk varC2D728EB19718E4BE6488369DA087CF3_1752700387 =         mChunks.removeFirst();
        varC2D728EB19718E4BE6488369DA087CF3_1752700387.addTaint(taint);
        return varC2D728EB19718E4BE6488369DA087CF3_1752700387;
        // ---------- Original Method ----------
        //if (mChunks.isEmpty()) return null;
        //return mChunks.removeFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.332 -0400", hash_original_method = "16ED363A8E80AEA093971B1CDA828010", hash_generated_method = "23CF97B4777238B890CCEA7CC64259B5")
    public synchronized boolean isEmpty() {
        boolean varE85C4ADB4BA58A94A981B77BD2E5382D_401390915 = (mChunks.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1418193360 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1418193360;
        // ---------- Original Method ----------
        //return mChunks.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.333 -0400", hash_original_method = "6BBE6D0629DEE9459E725081CE095168", hash_generated_method = "110A24EB15DE16AC1BCB97DD0A5A2DA2")
    public synchronized int getByteSize() {
        int total = 0;
        ListIterator<Chunk> it = mChunks.listIterator(0);
        while
(it.hasNext())        
        {
            Chunk c = it.next();
            total += c.mLength;
        } //End block
        int varFBB44B4487415B134BCE9C790A27FE5E_237339947 = (total);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1851715794 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1851715794;
        // ---------- Original Method ----------
        //int total = 0;
        //ListIterator<Chunk> it = mChunks.listIterator(0);
        //while (it.hasNext()) {
            //Chunk c = it.next();
            //total += c.mLength;
        //}
        //return total;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.333 -0400", hash_original_method = "F807D4A4D9C660A6AF7B8E4ADC0E0EE6", hash_generated_method = "FE9FC7E3F5C3C5E0A6A31CBC5466203B")
    public synchronized void clear() {
        Chunk c = getFirstChunk();
        while
(c != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.334 -0400", hash_original_method = "3A2BA3FFD8F41065BE9E5F1BD3D65412", hash_generated_method = "1EB4B4A1E7FA715FCC99A0FD6C6AAEBA")
    private void processPoolLocked() {
        while
(true)        
        {
            SoftReference<Chunk> entry = (SoftReference<Chunk>) sQueue.poll();
            if(entry == null)            
            {
                break;
            } //End block
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.334 -0400", hash_original_method = "823F243F1FE2DDA7035072AD49FCCD96", hash_generated_method = "0353DE0C405506CD1CDA6AFC07F97AE8")
    private Chunk obtainChunk(int length) {
        addTaint(length);
        if(length < DEFAULT_CAPACITY)        
        {
            length = DEFAULT_CAPACITY;
        } //End block
        synchronized
(sPool)        {
            processPoolLocked();
            if(!sPool.isEmpty())            
            {
                Chunk c = sPool.removeFirst().get();
                if(c != null)                
                {
Chunk var807FB10045EE51C06BDB74744A6714DF_1615308147 =                     c;
                    var807FB10045EE51C06BDB74744A6714DF_1615308147.addTaint(taint);
                    return var807FB10045EE51C06BDB74744A6714DF_1615308147;
                } //End block
            } //End block
Chunk var25D655AA1A429AC271EAF4DC65CAF319_524317345 =             new Chunk(length);
            var25D655AA1A429AC271EAF4DC65CAF319_524317345.addTaint(taint);
            return var25D655AA1A429AC271EAF4DC65CAF319_524317345;
        } //End block
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.335 -0400", hash_original_field = "982501881A3C318D6605E92D3AB0ADBA", hash_generated_field = "0EDCDC8DA17864CD42594730EA96D957")

        public byte[] mArray;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.335 -0400", hash_original_field = "429F431E8CD8AC287AA27460675EAEFE", hash_generated_field = "D223D4590FC7845D7348BABCD2C232A4")

        public int mLength;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.336 -0400", hash_original_method = "7BA2D66980388409381C11ACBE550E64", hash_generated_method = "6BFFC18DD8022D0016AEE6264E983E07")
        public  Chunk(int length) {
            mArray = new byte[length];
            mLength = 0;
            // ---------- Original Method ----------
            //mArray = new byte[length];
            //mLength = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.337 -0400", hash_original_method = "3768D7B4204F23A6FF321EC840D75009", hash_generated_method = "7ADB2B8A1D44657987D12AE6352EE312")
        public void release() {
            mLength = 0;
            synchronized
(sPool)            {
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.337 -0400", hash_original_field = "38D15E82EC973864FD3752B99D07E77B", hash_generated_field = "3DAEEFED1145BF3DC7E54720D7042881")

    private static final int DEFAULT_CAPACITY = 8192;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.337 -0400", hash_original_field = "816179A8A82629E5F41E68E61458E62A", hash_generated_field = "17FC8AB839DC2BF0E0AEEEE12FA31109")

    private static final LinkedList<SoftReference<Chunk>> sPool = new LinkedList<SoftReference<Chunk>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.337 -0400", hash_original_field = "F230A632C09600C5590998055E0EA3CB", hash_generated_field = "0910402B8F1D975C39ECFC606C833B18")

    private static final ReferenceQueue<Chunk> sQueue = new ReferenceQueue<Chunk>();
}

