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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.075 -0400", hash_original_field = "D96663553B59C302287984487A58CF9F", hash_generated_field = "B776907C1A6A4E01FFB277D178950D86")

    private LinkedList<Chunk> mChunks;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.075 -0400", hash_original_method = "4B643343F90EB2A0E25A848B20B29FC2", hash_generated_method = "585D3F9A7DBBC98189950DBD22ABFA56")
    public  ByteArrayBuilder() {
        mChunks = new LinkedList<Chunk>();
        // ---------- Original Method ----------
        //mChunks = new LinkedList<Chunk>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.077 -0400", hash_original_method = "F99906839EA8B42FAEE592DB92B3532B", hash_generated_method = "723DA0871B932C81AF75B568E5D9A5E0")
    public synchronized void append(byte[] array, int offset, int length) {
        {
            Chunk c;
            c = null;
            {
                boolean var8993D16895D6DD6A19E8FE9C22420F8A_990494610 = (mChunks.isEmpty());
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
        addTaint(array[0]);
        addTaint(offset);
        addTaint(length);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.078 -0400", hash_original_method = "A351746FD34CE9C266D741F531DA2BD6", hash_generated_method = "0FCCD45069A11AB55737E21864BF63AC")
    public synchronized Chunk getFirstChunk() {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_319318613 = null; //Variable for return #1
        Chunk varB4EAC82CA7396A68D541C85D26508E83_2120617645 = null; //Variable for return #2
        {
            boolean var80D64A7912806675BFE8C9AA767A8E24_888833660 = (mChunks.isEmpty());
            varB4EAC82CA7396A68D541C85D26508E83_319318613 = null;
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2120617645 = mChunks.removeFirst();
        Chunk varA7E53CE21691AB073D9660D615818899_220711389; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_220711389 = varB4EAC82CA7396A68D541C85D26508E83_319318613;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_220711389 = varB4EAC82CA7396A68D541C85D26508E83_2120617645;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_220711389.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_220711389;
        // ---------- Original Method ----------
        //if (mChunks.isEmpty()) return null;
        //return mChunks.removeFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.078 -0400", hash_original_method = "16ED363A8E80AEA093971B1CDA828010", hash_generated_method = "B8D67F9E1C906B5A316549AE661511A6")
    public synchronized boolean isEmpty() {
        boolean varB17D8418AFE521C924103445195E283C_1932352131 = (mChunks.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_391473001 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_391473001;
        // ---------- Original Method ----------
        //return mChunks.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.083 -0400", hash_original_method = "6BBE6D0629DEE9459E725081CE095168", hash_generated_method = "E60EC6EED580E5CD991BAB552C98DD36")
    public synchronized int getByteSize() {
        int total;
        total = 0;
        ListIterator<Chunk> it;
        it = mChunks.listIterator(0);
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_599297201 = (it.hasNext());
            {
                Chunk c;
                c = it.next();
                total += c.mLength;
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1385631132 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1385631132;
        // ---------- Original Method ----------
        //int total = 0;
        //ListIterator<Chunk> it = mChunks.listIterator(0);
        //while (it.hasNext()) {
            //Chunk c = it.next();
            //total += c.mLength;
        //}
        //return total;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.083 -0400", hash_original_method = "F807D4A4D9C660A6AF7B8E4ADC0E0EE6", hash_generated_method = "A590C9738B98A77072BF7BAC53812C73")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.097 -0400", hash_original_method = "3A2BA3FFD8F41065BE9E5F1BD3D65412", hash_generated_method = "61414B73D9015B49B54B9C0158F8D5E8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.098 -0400", hash_original_method = "823F243F1FE2DDA7035072AD49FCCD96", hash_generated_method = "B4466C8A8ABE5BE3CDA49F7E56CB124D")
    private Chunk obtainChunk(int length) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_621624856 = null; //Variable for return #1
        Chunk varB4EAC82CA7396A68D541C85D26508E83_1828471591 = null; //Variable for return #2
        {
            length = DEFAULT_CAPACITY;
        } //End block
        {
            processPoolLocked();
            {
                boolean varADDBC07E5FAD7BBD438CB737F9DBE3FD_1352917788 = (!sPool.isEmpty());
                {
                    Chunk c;
                    c = sPool.removeFirst().get();
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_621624856 = c;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1828471591 = new Chunk(length);
        } //End block
        addTaint(length);
        Chunk varA7E53CE21691AB073D9660D615818899_1147806171; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1147806171 = varB4EAC82CA7396A68D541C85D26508E83_621624856;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1147806171 = varB4EAC82CA7396A68D541C85D26508E83_1828471591;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1147806171.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1147806171;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.098 -0400", hash_original_field = "982501881A3C318D6605E92D3AB0ADBA", hash_generated_field = "0EDCDC8DA17864CD42594730EA96D957")

        public byte[] mArray;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.098 -0400", hash_original_field = "429F431E8CD8AC287AA27460675EAEFE", hash_generated_field = "D223D4590FC7845D7348BABCD2C232A4")

        public int mLength;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.098 -0400", hash_original_method = "7BA2D66980388409381C11ACBE550E64", hash_generated_method = "6BFFC18DD8022D0016AEE6264E983E07")
        public  Chunk(int length) {
            mArray = new byte[length];
            mLength = 0;
            // ---------- Original Method ----------
            //mArray = new byte[length];
            //mLength = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.099 -0400", hash_original_method = "3768D7B4204F23A6FF321EC840D75009", hash_generated_method = "7A59FCD8915A433718155A60AACFA1A8")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.100 -0400", hash_original_field = "38D15E82EC973864FD3752B99D07E77B", hash_generated_field = "71014950F6E15CE77F68F34DC54B4FC5")

    private static int DEFAULT_CAPACITY = 8192;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.100 -0400", hash_original_field = "816179A8A82629E5F41E68E61458E62A", hash_generated_field = "900DCBA7843418662AF1D83B23DF8A0F")

    private static LinkedList<SoftReference<Chunk>> sPool = new LinkedList<SoftReference<Chunk>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.100 -0400", hash_original_field = "F230A632C09600C5590998055E0EA3CB", hash_generated_field = "B93B5D695B59A14A11D93FB0FC80EA2E")

    private static ReferenceQueue<Chunk> sQueue = new ReferenceQueue<Chunk>();
}

