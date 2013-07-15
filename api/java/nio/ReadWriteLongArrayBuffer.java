package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

final class ReadWriteLongArrayBuffer extends LongArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.174 -0400", hash_original_method = "834F92961971218638A9D7B65E865A6A", hash_generated_method = "0BF1E72F9CDE48CDFF9B1041B1117CC0")
      ReadWriteLongArrayBuffer(long[] array) {
        super(array);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.174 -0400", hash_original_method = "B372464DEEDD255C23B3D6D2F6AC357B", hash_generated_method = "12326B1AE0736FDED662AAC5D35BA336")
      ReadWriteLongArrayBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.175 -0400", hash_original_method = "D4CFA6531161D5EBB7847D86519768A8", hash_generated_method = "C7D9C800988D13824BEC08E7C867CA20")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.175 -0400", hash_original_method = "491DB95BA7040FC98389856362623E65", hash_generated_method = "7AE3A82BB09D585F033BD24E158A68BD")
    @Override
    public LongBuffer asReadOnlyBuffer() {
LongBuffer varDA4A3975823E842A8B5EAA30C374D8BD_979730925 =         ReadOnlyLongArrayBuffer.copy(this, mark);
        varDA4A3975823E842A8B5EAA30C374D8BD_979730925.addTaint(taint);
        return varDA4A3975823E842A8B5EAA30C374D8BD_979730925;
        // ---------- Original Method ----------
        //return ReadOnlyLongArrayBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.176 -0400", hash_original_method = "060222CDD5267DE677B9C3E035FABA38", hash_generated_method = "60BB4F0657E9FE7EB3B9E5533CC7C89A")
    @Override
    public LongBuffer compact() {
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
LongBuffer var72A74007B2BE62B849F475C7BDA4658B_1543771323 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1543771323.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1543771323;
        // ---------- Original Method ----------
        //System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.176 -0400", hash_original_method = "BCAEF14AE65D2F213653B4CB45E8B265", hash_generated_method = "088B7ED5AEF73956593786D222D25E91")
    @Override
    public LongBuffer duplicate() {
LongBuffer var6ED4708F04CD11720ECFFDBFD927116F_1316631865 =         copy(this, mark);
        var6ED4708F04CD11720ECFFDBFD927116F_1316631865.addTaint(taint);
        return var6ED4708F04CD11720ECFFDBFD927116F_1316631865;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.176 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "1CB98A3D97774E9476DE06820E72496F")
    @Override
    public boolean isReadOnly() {
        boolean var68934A3E9455FA72420237EB05902327_2112085164 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_809177117 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_809177117;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.177 -0400", hash_original_method = "7F3F8A80822D5A0A92B191B6CC171534", hash_generated_method = "A1E234B373403184A023CDAE3500A5F8")
    @Override
    protected long[] protectedArray() {
        long[] var8D50CD27AA8B6BEC65C484FFCC5B2334_2053141890 = (backingArray);
                long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_1308813717 = {getTaintLong()};
        return var3908C7C3AF5171CEE1F112DAE77A5C4D_1308813717;
        // ---------- Original Method ----------
        //return backingArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.177 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "25A784D56D38FD164C7AF883EBF48F22")
    @Override
    protected int protectedArrayOffset() {
        int var7A86C157EE9713C34FBD7A1EE40F0C5A_1934641770 = (offset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1534427347 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1534427347;
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.178 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "A28097BCEA71EE0140920CDBDC0B6F3B")
    @Override
    protected boolean protectedHasArray() {
        boolean varB326B5062B2F0E69046810717534CB09_978685905 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_375912303 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_375912303;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.178 -0400", hash_original_method = "425DFBE2ED449316EC67E343889A606E", hash_generated_method = "E5252D0BBC30952F22C05D635649ED52")
    @Override
    public LongBuffer put(long c) {
        addTaint(c);
    if(position == limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1540323524 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1540323524.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1540323524;
        } //End block
        backingArray[offset + position++] = c;
LongBuffer var72A74007B2BE62B849F475C7BDA4658B_1634024953 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1634024953.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1634024953;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //backingArray[offset + position++] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.179 -0400", hash_original_method = "1D23D6036C356E1E5C3421A08A3084B8", hash_generated_method = "BBB6E8EE0F1C6F1CE825ECA9CC2582A2")
    @Override
    public LongBuffer put(int index, long c) {
        addTaint(c);
        addTaint(index);
        checkIndex(index);
        backingArray[offset + index] = c;
LongBuffer var72A74007B2BE62B849F475C7BDA4658B_107622817 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_107622817.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_107622817;
        // ---------- Original Method ----------
        //checkIndex(index);
        //backingArray[offset + index] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.179 -0400", hash_original_method = "DEBADA2447C09B43BF32BF5E36B4652E", hash_generated_method = "4A89ACB90BFED3D03306C3FD2B8E0052")
    @Override
    public LongBuffer put(long[] src, int srcOffset, int longCount) {
        addTaint(longCount);
        addTaint(srcOffset);
        addTaint(src[0]);
    if(longCount > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_955187678 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_955187678.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_955187678;
        } //End block
        System.arraycopy(src, srcOffset, backingArray, offset + position, longCount);
        position += longCount;
LongBuffer var72A74007B2BE62B849F475C7BDA4658B_570935048 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_570935048.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_570935048;
        // ---------- Original Method ----------
        //if (longCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //System.arraycopy(src, srcOffset, backingArray, offset + position, longCount);
        //position += longCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.180 -0400", hash_original_method = "66DF3FBD18C3DE0FC10F7184B9F43E0E", hash_generated_method = "FE70D760CDC03C80BB44B33780B23F7B")
    @Override
    public LongBuffer slice() {
LongBuffer varF838B8488B24FE2D283C1D7E2D639822_923570600 =         new ReadWriteLongArrayBuffer(remaining(), backingArray, offset + position);
        varF838B8488B24FE2D283C1D7E2D639822_923570600.addTaint(taint);
        return varF838B8488B24FE2D283C1D7E2D639822_923570600;
        // ---------- Original Method ----------
        //return new ReadWriteLongArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

