package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import libcore.io.SizeOf;
import libcore.io.Memory;

final class ReadWriteDirectByteBuffer extends DirectByteBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.073 -0400", hash_original_method = "F2F90AA1C14708BA27FBCC0DAF6F8A9D", hash_generated_method = "A1D49C312E14188BB002F04E7B541A21")
      ReadWriteDirectByteBuffer(int capacity) {
        super(MemoryBlock.allocate(capacity), capacity, 0);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.073 -0400", hash_original_method = "B59F4E2576E1A9EB301DFADAA106D67F", hash_generated_method = "264D2923708596F248F5794732655ED2")
      ReadWriteDirectByteBuffer(int address, int capacity) {
        super(MemoryBlock.wrapFromJni(address, capacity), capacity, 0);
        addTaint(capacity);
        addTaint(address);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.073 -0400", hash_original_method = "64217974EE9299818C86F07054C3DD19", hash_generated_method = "2A1D91344B5A42ACEC5A11490936AA00")
      ReadWriteDirectByteBuffer(MemoryBlock block, int capacity, int offset) {
        super(block, capacity, offset);
        addTaint(offset);
        addTaint(capacity);
        addTaint(block.getTaint());
        // ---------- Original Method ----------
    }

    
        static ReadWriteDirectByteBuffer copy(DirectByteBuffer other, int markOfOther) {
        ReadWriteDirectByteBuffer buf =
                new ReadWriteDirectByteBuffer(other.block, other.capacity(), other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.074 -0400", hash_original_method = "CE9B7C65263563316466CBF3E3F947EC", hash_generated_method = "AE74D602711F0A6F1F8186DF5C3ED0AF")
    @Override
    public ByteBuffer asReadOnlyBuffer() {
ByteBuffer var714A9DFD2E7945C29F120BE1B2CB47FA_78430939 =         ReadOnlyDirectByteBuffer.copy(this, mark);
        var714A9DFD2E7945C29F120BE1B2CB47FA_78430939.addTaint(taint);
        return var714A9DFD2E7945C29F120BE1B2CB47FA_78430939;
        // ---------- Original Method ----------
        //return ReadOnlyDirectByteBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.075 -0400", hash_original_method = "D5E5DB3E7908F6BA902162C22E7A6F05", hash_generated_method = "A09717D0ED5B0C0ABB191AED714B5E44")
    @Override
    public ByteBuffer compact() {
        Memory.memmove(this, 0, this, position, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1797271017 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1797271017.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1797271017;
        // ---------- Original Method ----------
        //Memory.memmove(this, 0, this, position, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.075 -0400", hash_original_method = "C2883EB2B7E86A704D76356E1AAB194F", hash_generated_method = "638661F4281C00319E808D0D24766B71")
    @Override
    public ByteBuffer duplicate() {
ByteBuffer var6ED4708F04CD11720ECFFDBFD927116F_450775086 =         copy(this, mark);
        var6ED4708F04CD11720ECFFDBFD927116F_450775086.addTaint(taint);
        return var6ED4708F04CD11720ECFFDBFD927116F_450775086;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.075 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "90797DFA61554814F3288FD3E0AE8712")
    @Override
    public boolean isReadOnly() {
        boolean var68934A3E9455FA72420237EB05902327_412783853 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1555872997 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1555872997;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.076 -0400", hash_original_method = "395C1E25ABAA7CA19067E1D56A7B6B36", hash_generated_method = "69C9B0F2401CBDB33D6FE61E1E4C6D20")
    @Override
    public ByteBuffer put(byte value) {
        addTaint(value);
    if(position == limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_292849547 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_292849547.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_292849547;
        } //End block
        this.block.pokeByte(offset + position++, value);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_718019908 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_718019908.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_718019908;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //this.block.pokeByte(offset + position++, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.076 -0400", hash_original_method = "652949A668C0C42E265D3C7FA8C1BFFC", hash_generated_method = "3C7DEC2FAE90F326E5933204BAD6ECED")
    @Override
    public ByteBuffer put(int index, byte value) {
        addTaint(value);
        addTaint(index);
        checkIndex(index);
        this.block.pokeByte(offset + index, value);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1213423683 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1213423683.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1213423683;
        // ---------- Original Method ----------
        //checkIndex(index);
        //this.block.pokeByte(offset + index, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.077 -0400", hash_original_method = "BDD014EAD3BC316DD5191C68FD62AF55", hash_generated_method = "7F65C03DA1B6AC4D5FD0BE95DDCC7F3A")
    @Override
    public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
        addTaint(byteCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        checkPutBounds(1, src.length, srcOffset, byteCount);
        this.block.pokeByteArray(offset + position, src, srcOffset, byteCount);
        position += byteCount;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1934808971 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1934808971.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1934808971;
        // ---------- Original Method ----------
        //checkPutBounds(1, src.length, srcOffset, byteCount);
        //this.block.pokeByteArray(offset + position, src, srcOffset, byteCount);
        //position += byteCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.077 -0400", hash_original_method = "3221718B504A786DEFCB0B7DC092A6F4", hash_generated_method = "04EDCB9B47515888FEFF0140C5B1C962")
    final void put(char[] src, int srcOffset, int charCount) {
        addTaint(charCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        int byteCount = checkPutBounds(SizeOf.CHAR, src.length, srcOffset, charCount);
        this.block.pokeCharArray(offset + position, src, srcOffset, charCount, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkPutBounds(SizeOf.CHAR, src.length, srcOffset, charCount);
        //this.block.pokeCharArray(offset + position, src, srcOffset, charCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.078 -0400", hash_original_method = "96DFC920F61F6006882BF66934B5DF94", hash_generated_method = "6C154BF0FCF3B4FCE979B8EE92E84353")
    final void put(double[] src, int srcOffset, int doubleCount) {
        addTaint(doubleCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        int byteCount = checkPutBounds(SizeOf.DOUBLE, src.length, srcOffset, doubleCount);
        this.block.pokeDoubleArray(offset + position, src, srcOffset, doubleCount, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkPutBounds(SizeOf.DOUBLE, src.length, srcOffset, doubleCount);
        //this.block.pokeDoubleArray(offset + position, src, srcOffset, doubleCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.078 -0400", hash_original_method = "C81F946AF2E7397E3B6D2FB9DB9038F5", hash_generated_method = "39F19424789394E78DAD0EB2D79A33B4")
    final void put(float[] src, int srcOffset, int floatCount) {
        addTaint(floatCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        int byteCount = checkPutBounds(SizeOf.FLOAT, src.length, srcOffset, floatCount);
        this.block.pokeFloatArray(offset + position, src, srcOffset, floatCount, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkPutBounds(SizeOf.FLOAT, src.length, srcOffset, floatCount);
        //this.block.pokeFloatArray(offset + position, src, srcOffset, floatCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.079 -0400", hash_original_method = "69116E139CC5D8D5FB2D59FB1E27087D", hash_generated_method = "9BCC903CA1DEE7B3EDEEBC86071B1F37")
    final void put(int[] src, int srcOffset, int intCount) {
        addTaint(intCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        int byteCount = checkPutBounds(SizeOf.INT, src.length, srcOffset, intCount);
        this.block.pokeIntArray(offset + position, src, srcOffset, intCount, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkPutBounds(SizeOf.INT, src.length, srcOffset, intCount);
        //this.block.pokeIntArray(offset + position, src, srcOffset, intCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.080 -0400", hash_original_method = "F69F67F942D07574E852DB6B4C993418", hash_generated_method = "82B3C420F1A4ABC30C0C151AD9826A4A")
    final void put(long[] src, int srcOffset, int longCount) {
        addTaint(longCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        int byteCount = checkPutBounds(SizeOf.LONG, src.length, srcOffset, longCount);
        this.block.pokeLongArray(offset + position, src, srcOffset, longCount, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkPutBounds(SizeOf.LONG, src.length, srcOffset, longCount);
        //this.block.pokeLongArray(offset + position, src, srcOffset, longCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.080 -0400", hash_original_method = "E0EA76B0F879DDFFA81447B27E7A4446", hash_generated_method = "B27D1FDF5C70B0AC3ED759243D4560DB")
    final void put(short[] src, int srcOffset, int shortCount) {
        addTaint(shortCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        int byteCount = checkPutBounds(SizeOf.SHORT, src.length, srcOffset, shortCount);
        this.block.pokeShortArray(offset + position, src, srcOffset, shortCount, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkPutBounds(SizeOf.SHORT, src.length, srcOffset, shortCount);
        //this.block.pokeShortArray(offset + position, src, srcOffset, shortCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.081 -0400", hash_original_method = "F0572D8329DABC9F86465CEDFC740ABD", hash_generated_method = "A7BC01399E3CF758F5577EB4186EED91")
    @Override
    public ByteBuffer putChar(char value) {
        addTaint(value);
        int newPosition = position + SizeOf.CHAR;
    if(newPosition > limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_760436299 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_760436299.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_760436299;
        } //End block
        this.block.pokeShort(offset + position, (short) value, order);
        position = newPosition;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1315917855 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1315917855.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1315917855;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.CHAR;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //this.block.pokeShort(offset + position, (short) value, order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.081 -0400", hash_original_method = "CBD66B79847E3D8D427C79D0498E0CCC", hash_generated_method = "1C8A980FD65D7733D00EF1F3453E121E")
    @Override
    public ByteBuffer putChar(int index, char value) {
        addTaint(value);
        addTaint(index);
        checkIndex(index, SizeOf.CHAR);
        this.block.pokeShort(offset + index, (short) value, order);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1287806197 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1287806197.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1287806197;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.CHAR);
        //this.block.pokeShort(offset + index, (short) value, order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.081 -0400", hash_original_method = "9ED8D9340D66DD3DF3B6EBAEE44AFD16", hash_generated_method = "AE7401ADAA4562BA66B863E6C6431726")
    @Override
    public ByteBuffer putDouble(double value) {
        addTaint(value);
        int newPosition = position + SizeOf.DOUBLE;
    if(newPosition > limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_684839337 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_684839337.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_684839337;
        } //End block
        this.block.pokeLong(offset + position, Double.doubleToRawLongBits(value), order);
        position = newPosition;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_563402395 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_563402395.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_563402395;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.DOUBLE;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //this.block.pokeLong(offset + position, Double.doubleToRawLongBits(value), order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.082 -0400", hash_original_method = "8AAC575A61B55D0966D81E09A35D0181", hash_generated_method = "E090B166015DCAA3B3145C6785A7035D")
    @Override
    public ByteBuffer putDouble(int index, double value) {
        addTaint(value);
        addTaint(index);
        checkIndex(index, SizeOf.DOUBLE);
        this.block.pokeLong(offset + index, Double.doubleToRawLongBits(value), order);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1811148824 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1811148824.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1811148824;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.DOUBLE);
        //this.block.pokeLong(offset + index, Double.doubleToRawLongBits(value), order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.082 -0400", hash_original_method = "0A3477476230781B1656EAAB87E3304B", hash_generated_method = "30661FE57B114FE2B4F5FEDDEEF4242A")
    @Override
    public ByteBuffer putFloat(float value) {
        addTaint(value);
        int newPosition = position + SizeOf.FLOAT;
    if(newPosition > limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_178449602 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_178449602.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_178449602;
        } //End block
        this.block.pokeInt(offset + position, Float.floatToRawIntBits(value), order);
        position = newPosition;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_456328033 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_456328033.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_456328033;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.FLOAT;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //this.block.pokeInt(offset + position, Float.floatToRawIntBits(value), order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.083 -0400", hash_original_method = "E1D9BD09C632F025AC8B3D46ED3F66A9", hash_generated_method = "057D56B11DA341873B699626122C2813")
    @Override
    public ByteBuffer putFloat(int index, float value) {
        addTaint(value);
        addTaint(index);
        checkIndex(index, SizeOf.FLOAT);
        this.block.pokeInt(offset + index, Float.floatToRawIntBits(value), order);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1534542677 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1534542677.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1534542677;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.FLOAT);
        //this.block.pokeInt(offset + index, Float.floatToRawIntBits(value), order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.083 -0400", hash_original_method = "8B2258E2CDB6554D65089AAF42AB6164", hash_generated_method = "6DBDC78B49F6321970128C275EDDADB5")
    @Override
    public ByteBuffer putInt(int value) {
        addTaint(value);
        int newPosition = position + SizeOf.INT;
    if(newPosition > limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1118980543 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1118980543.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1118980543;
        } //End block
        this.block.pokeInt(offset + position, value, order);
        position = newPosition;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1831086124 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1831086124.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1831086124;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.INT;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //this.block.pokeInt(offset + position, value, order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.084 -0400", hash_original_method = "8C6F9A9AD35489B3E9144FE27229FEA6", hash_generated_method = "1E44792DC4E2D3FA8AD2AF5F5550D8D3")
    @Override
    public ByteBuffer putInt(int index, int value) {
        addTaint(value);
        addTaint(index);
        checkIndex(index, SizeOf.INT);
        this.block.pokeInt(offset + index, value, order);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_957162746 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_957162746.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_957162746;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.INT);
        //this.block.pokeInt(offset + index, value, order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.084 -0400", hash_original_method = "1B6AA9EF9F994F4063EEE65EEDAD78AF", hash_generated_method = "D9AAD8D828932B2E3913083823041108")
    @Override
    public ByteBuffer putLong(long value) {
        addTaint(value);
        int newPosition = position + SizeOf.LONG;
    if(newPosition > limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1651683964 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1651683964.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1651683964;
        } //End block
        this.block.pokeLong(offset + position, value, order);
        position = newPosition;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_595417263 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_595417263.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_595417263;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.LONG;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //this.block.pokeLong(offset + position, value, order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.085 -0400", hash_original_method = "4C4D1F2ADFCF9A28948ABA57C52309AC", hash_generated_method = "BECE35A726ADF03E60D50A038DB372A4")
    @Override
    public ByteBuffer putLong(int index, long value) {
        addTaint(value);
        addTaint(index);
        checkIndex(index, SizeOf.LONG);
        this.block.pokeLong(offset + index, value, order);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1657302816 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1657302816.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1657302816;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.LONG);
        //this.block.pokeLong(offset + index, value, order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.085 -0400", hash_original_method = "3ACD25E4A627200A6604DD06DE084CC0", hash_generated_method = "C69AB7FBC178C2F3379F1D2BE197FA2C")
    @Override
    public ByteBuffer putShort(short value) {
        addTaint(value);
        int newPosition = position + SizeOf.SHORT;
    if(newPosition > limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_14804482 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_14804482.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_14804482;
        } //End block
        this.block.pokeShort(offset + position, value, order);
        position = newPosition;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1185377339 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1185377339.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1185377339;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.SHORT;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //this.block.pokeShort(offset + position, value, order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.086 -0400", hash_original_method = "BC61FE6FEC8007EEA3BC0AA561C1C935", hash_generated_method = "31953E4B7B26F64CE83827B5D07B9667")
    @Override
    public ByteBuffer putShort(int index, short value) {
        addTaint(value);
        addTaint(index);
        checkIndex(index, SizeOf.SHORT);
        this.block.pokeShort(offset + index, value, order);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_883451551 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_883451551.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_883451551;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.SHORT);
        //this.block.pokeShort(offset + index, value, order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.086 -0400", hash_original_method = "D4755AC954967E40D5DAD107FB36CBC4", hash_generated_method = "3024DCC10FD1A2FC07C431FECD4B8BCA")
    @Override
    public ByteBuffer slice() {
ByteBuffer var0F2E98598D64ED8F01A29053D96965F6_1625689682 =         new ReadWriteDirectByteBuffer(block, remaining(), offset + position);
        var0F2E98598D64ED8F01A29053D96965F6_1625689682.addTaint(taint);
        return var0F2E98598D64ED8F01A29053D96965F6_1625689682;
        // ---------- Original Method ----------
        //return new ReadWriteDirectByteBuffer(block, remaining(), offset + position);
    }

    
}

