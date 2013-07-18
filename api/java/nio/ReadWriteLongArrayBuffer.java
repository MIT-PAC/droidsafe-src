package java.nio;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

final class ReadWriteLongArrayBuffer extends LongArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.779 -0400", hash_original_method = "834F92961971218638A9D7B65E865A6A", hash_generated_method = "0BF1E72F9CDE48CDFF9B1041B1117CC0")
      ReadWriteLongArrayBuffer(long[] array) {
        super(array);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.779 -0400", hash_original_method = "B372464DEEDD255C23B3D6D2F6AC357B", hash_generated_method = "12326B1AE0736FDED662AAC5D35BA336")
      ReadWriteLongArrayBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.780 -0400", hash_original_method = "D4CFA6531161D5EBB7847D86519768A8", hash_generated_method = "C7D9C800988D13824BEC08E7C867CA20")
      ReadWriteLongArrayBuffer(int capacity, long[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        addTaint(arrayOffset);
        addTaint(backingArray[0]);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    static ReadWriteLongArrayBuffer copy(LongArrayBuffer other, int markOfOther) {
        ReadWriteLongArrayBuffer buf =
                new ReadWriteLongArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.780 -0400", hash_original_method = "491DB95BA7040FC98389856362623E65", hash_generated_method = "04AF9664DB9A718B4C54DE3216639E4B")
    @Override
    public LongBuffer asReadOnlyBuffer() {
LongBuffer varDA4A3975823E842A8B5EAA30C374D8BD_2065326723 =         ReadOnlyLongArrayBuffer.copy(this, mark);
        varDA4A3975823E842A8B5EAA30C374D8BD_2065326723.addTaint(taint);
        return varDA4A3975823E842A8B5EAA30C374D8BD_2065326723;
        // ---------- Original Method ----------
        //return ReadOnlyLongArrayBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.781 -0400", hash_original_method = "060222CDD5267DE677B9C3E035FABA38", hash_generated_method = "315B08CC5A9D9056F62F681A748F33D4")
    @Override
    public LongBuffer compact() {
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
LongBuffer var72A74007B2BE62B849F475C7BDA4658B_65017631 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_65017631.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_65017631;
        // ---------- Original Method ----------
        //System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.781 -0400", hash_original_method = "BCAEF14AE65D2F213653B4CB45E8B265", hash_generated_method = "7C085C3FA9AF01DFE59009A7ED714C93")
    @Override
    public LongBuffer duplicate() {
LongBuffer var6ED4708F04CD11720ECFFDBFD927116F_208821004 =         copy(this, mark);
        var6ED4708F04CD11720ECFFDBFD927116F_208821004.addTaint(taint);
        return var6ED4708F04CD11720ECFFDBFD927116F_208821004;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.781 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "89051537C2B22B6ED7B185B2B78CCFE1")
    @Override
    public boolean isReadOnly() {
        boolean var68934A3E9455FA72420237EB05902327_1976895273 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_421808063 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_421808063;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.782 -0400", hash_original_method = "7F3F8A80822D5A0A92B191B6CC171534", hash_generated_method = "7E39F4095584BF7F267041F528199C0B")
    @Override
    protected long[] protectedArray() {
        long[] var8D50CD27AA8B6BEC65C484FFCC5B2334_382189597 = (backingArray);
                long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_831840296 = {getTaintLong()};
        return var3908C7C3AF5171CEE1F112DAE77A5C4D_831840296;
        // ---------- Original Method ----------
        //return backingArray;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.782 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "22072084990D7FAE15B0C6D4E960C58C")
    @Override
    protected int protectedArrayOffset() {
        int var7A86C157EE9713C34FBD7A1EE40F0C5A_123923341 = (offset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_538078462 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_538078462;
        // ---------- Original Method ----------
        //return offset;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.782 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "71E63EDE9B0A2E0DB1DD029921D1E2FC")
    @Override
    protected boolean protectedHasArray() {
        boolean varB326B5062B2F0E69046810717534CB09_1174534357 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_386058316 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_386058316;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.782 -0400", hash_original_method = "425DFBE2ED449316EC67E343889A606E", hash_generated_method = "9D2EFDC17CDDCEF184F48799D325FCC1")
    @Override
    public LongBuffer put(long c) {
        addTaint(c);
        if(position == limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1625398753 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1625398753.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1625398753;
        } //End block
        backingArray[offset + position++] = c;
LongBuffer var72A74007B2BE62B849F475C7BDA4658B_159414822 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_159414822.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_159414822;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //backingArray[offset + position++] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.783 -0400", hash_original_method = "1D23D6036C356E1E5C3421A08A3084B8", hash_generated_method = "906848AA0A8A31717D328F9FD1FF6DFF")
    @Override
    public LongBuffer put(int index, long c) {
        addTaint(c);
        addTaint(index);
        checkIndex(index);
        backingArray[offset + index] = c;
LongBuffer var72A74007B2BE62B849F475C7BDA4658B_2061280030 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2061280030.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2061280030;
        // ---------- Original Method ----------
        //checkIndex(index);
        //backingArray[offset + index] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.784 -0400", hash_original_method = "DEBADA2447C09B43BF32BF5E36B4652E", hash_generated_method = "6177B7F9C9165D6002BBC4987605D106")
    @Override
    public LongBuffer put(long[] src, int srcOffset, int longCount) {
        addTaint(longCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        if(longCount > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1851719444 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1851719444.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1851719444;
        } //End block
        System.arraycopy(src, srcOffset, backingArray, offset + position, longCount);
        position += longCount;
LongBuffer var72A74007B2BE62B849F475C7BDA4658B_256148212 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_256148212.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_256148212;
        // ---------- Original Method ----------
        //if (longCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //System.arraycopy(src, srcOffset, backingArray, offset + position, longCount);
        //position += longCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.784 -0400", hash_original_method = "66DF3FBD18C3DE0FC10F7184B9F43E0E", hash_generated_method = "E4BC208D2E3633E451D010FED7F7DA95")
    @Override
    public LongBuffer slice() {
LongBuffer varF838B8488B24FE2D283C1D7E2D639822_666793000 =         new ReadWriteLongArrayBuffer(remaining(), backingArray, offset + position);
        varF838B8488B24FE2D283C1D7E2D639822_666793000.addTaint(taint);
        return varF838B8488B24FE2D283C1D7E2D639822_666793000;
        // ---------- Original Method ----------
        //return new ReadWriteLongArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

