package java.nio;

// Droidsafe Imports
import droidsafe.annotations.*;
import libcore.io.Memory;
import libcore.io.SizeOf;




final class ReadWriteDirectByteBuffer extends DirectByteBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.659 -0400", hash_original_method = "F2F90AA1C14708BA27FBCC0DAF6F8A9D", hash_generated_method = "A1D49C312E14188BB002F04E7B541A21")
      ReadWriteDirectByteBuffer(int capacity) {
        super(MemoryBlock.allocate(capacity), capacity, 0);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.659 -0400", hash_original_method = "B59F4E2576E1A9EB301DFADAA106D67F", hash_generated_method = "264D2923708596F248F5794732655ED2")
      ReadWriteDirectByteBuffer(int address, int capacity) {
        super(MemoryBlock.wrapFromJni(address, capacity), capacity, 0);
        addTaint(capacity);
        addTaint(address);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.659 -0400", hash_original_method = "64217974EE9299818C86F07054C3DD19", hash_generated_method = "2A1D91344B5A42ACEC5A11490936AA00")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.660 -0400", hash_original_method = "CE9B7C65263563316466CBF3E3F947EC", hash_generated_method = "EBAA576757D3399D8915D5D14C6C5D27")
    @Override
    public ByteBuffer asReadOnlyBuffer() {
ByteBuffer var714A9DFD2E7945C29F120BE1B2CB47FA_1871305374 =         ReadOnlyDirectByteBuffer.copy(this, mark);
        var714A9DFD2E7945C29F120BE1B2CB47FA_1871305374.addTaint(taint);
        return var714A9DFD2E7945C29F120BE1B2CB47FA_1871305374;
        // ---------- Original Method ----------
        //return ReadOnlyDirectByteBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.661 -0400", hash_original_method = "D5E5DB3E7908F6BA902162C22E7A6F05", hash_generated_method = "5EE6183B4340E8CB7D9A1399E9EA70E5")
    @Override
    public ByteBuffer compact() {
        Memory.memmove(this, 0, this, position, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1996816127 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1996816127.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1996816127;
        // ---------- Original Method ----------
        //Memory.memmove(this, 0, this, position, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.661 -0400", hash_original_method = "C2883EB2B7E86A704D76356E1AAB194F", hash_generated_method = "20698C022137EE0E8C08172655A4DB70")
    @Override
    public ByteBuffer duplicate() {
ByteBuffer var6ED4708F04CD11720ECFFDBFD927116F_350739242 =         copy(this, mark);
        var6ED4708F04CD11720ECFFDBFD927116F_350739242.addTaint(taint);
        return var6ED4708F04CD11720ECFFDBFD927116F_350739242;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.661 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "3C4E7C7C984C6BB063ECD6B033444E0A")
    @Override
    public boolean isReadOnly() {
        boolean var68934A3E9455FA72420237EB05902327_656748712 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1093441438 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1093441438;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.662 -0400", hash_original_method = "395C1E25ABAA7CA19067E1D56A7B6B36", hash_generated_method = "C410BEA75BDCE6CD717E1F3A7100BE17")
    @Override
    public ByteBuffer put(byte value) {
        addTaint(value);
        if(position == limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1836167996 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1836167996.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1836167996;
        } //End block
        this.block.pokeByte(offset + position++, value);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1566285146 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1566285146.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1566285146;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //this.block.pokeByte(offset + position++, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.662 -0400", hash_original_method = "652949A668C0C42E265D3C7FA8C1BFFC", hash_generated_method = "C877682B7AEA1518D37B010F006EDA8C")
    @Override
    public ByteBuffer put(int index, byte value) {
        addTaint(value);
        addTaint(index);
        checkIndex(index);
        this.block.pokeByte(offset + index, value);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1484495440 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1484495440.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1484495440;
        // ---------- Original Method ----------
        //checkIndex(index);
        //this.block.pokeByte(offset + index, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.663 -0400", hash_original_method = "BDD014EAD3BC316DD5191C68FD62AF55", hash_generated_method = "3FA86ED47BF3CEEA810227EFABA43929")
    @Override
    public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
        addTaint(byteCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        checkPutBounds(1, src.length, srcOffset, byteCount);
        this.block.pokeByteArray(offset + position, src, srcOffset, byteCount);
        position += byteCount;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1714559401 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1714559401.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1714559401;
        // ---------- Original Method ----------
        //checkPutBounds(1, src.length, srcOffset, byteCount);
        //this.block.pokeByteArray(offset + position, src, srcOffset, byteCount);
        //position += byteCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.663 -0400", hash_original_method = "3221718B504A786DEFCB0B7DC092A6F4", hash_generated_method = "04EDCB9B47515888FEFF0140C5B1C962")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.664 -0400", hash_original_method = "96DFC920F61F6006882BF66934B5DF94", hash_generated_method = "6C154BF0FCF3B4FCE979B8EE92E84353")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.664 -0400", hash_original_method = "C81F946AF2E7397E3B6D2FB9DB9038F5", hash_generated_method = "39F19424789394E78DAD0EB2D79A33B4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.665 -0400", hash_original_method = "69116E139CC5D8D5FB2D59FB1E27087D", hash_generated_method = "9BCC903CA1DEE7B3EDEEBC86071B1F37")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.665 -0400", hash_original_method = "F69F67F942D07574E852DB6B4C993418", hash_generated_method = "82B3C420F1A4ABC30C0C151AD9826A4A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.665 -0400", hash_original_method = "E0EA76B0F879DDFFA81447B27E7A4446", hash_generated_method = "B27D1FDF5C70B0AC3ED759243D4560DB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.665 -0400", hash_original_method = "F0572D8329DABC9F86465CEDFC740ABD", hash_generated_method = "66BF13DB3F991EDA089EAE3EEE82B541")
    @Override
    public ByteBuffer putChar(char value) {
        addTaint(value);
        int newPosition = position + SizeOf.CHAR;
        if(newPosition > limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_852981307 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_852981307.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_852981307;
        } //End block
        this.block.pokeShort(offset + position, (short) value, order);
        position = newPosition;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1647010232 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1647010232.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1647010232;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.CHAR;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //this.block.pokeShort(offset + position, (short) value, order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.666 -0400", hash_original_method = "CBD66B79847E3D8D427C79D0498E0CCC", hash_generated_method = "62CE8D06CE46A7442C8399ABE0F08696")
    @Override
    public ByteBuffer putChar(int index, char value) {
        addTaint(value);
        addTaint(index);
        checkIndex(index, SizeOf.CHAR);
        this.block.pokeShort(offset + index, (short) value, order);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1037538565 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1037538565.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1037538565;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.CHAR);
        //this.block.pokeShort(offset + index, (short) value, order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.666 -0400", hash_original_method = "9ED8D9340D66DD3DF3B6EBAEE44AFD16", hash_generated_method = "1D7CE7C0D946E97901001872042D782D")
    @Override
    public ByteBuffer putDouble(double value) {
        addTaint(value);
        int newPosition = position + SizeOf.DOUBLE;
        if(newPosition > limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1723565843 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1723565843.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1723565843;
        } //End block
        this.block.pokeLong(offset + position, Double.doubleToRawLongBits(value), order);
        position = newPosition;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1337889220 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1337889220.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1337889220;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.DOUBLE;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //this.block.pokeLong(offset + position, Double.doubleToRawLongBits(value), order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.667 -0400", hash_original_method = "8AAC575A61B55D0966D81E09A35D0181", hash_generated_method = "273F1C73BCF4F41D79B64374B58C8F46")
    @Override
    public ByteBuffer putDouble(int index, double value) {
        addTaint(value);
        addTaint(index);
        checkIndex(index, SizeOf.DOUBLE);
        this.block.pokeLong(offset + index, Double.doubleToRawLongBits(value), order);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_66588267 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_66588267.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_66588267;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.DOUBLE);
        //this.block.pokeLong(offset + index, Double.doubleToRawLongBits(value), order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.669 -0400", hash_original_method = "0A3477476230781B1656EAAB87E3304B", hash_generated_method = "71AABC9F3B4EAA10B07DA0FEA40E9332")
    @Override
    public ByteBuffer putFloat(float value) {
        addTaint(value);
        int newPosition = position + SizeOf.FLOAT;
        if(newPosition > limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_527061166 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_527061166.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_527061166;
        } //End block
        this.block.pokeInt(offset + position, Float.floatToRawIntBits(value), order);
        position = newPosition;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_682221565 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_682221565.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_682221565;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.FLOAT;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //this.block.pokeInt(offset + position, Float.floatToRawIntBits(value), order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.670 -0400", hash_original_method = "E1D9BD09C632F025AC8B3D46ED3F66A9", hash_generated_method = "FF1568708CC9FFA06A18D05A01C6D00F")
    @Override
    public ByteBuffer putFloat(int index, float value) {
        addTaint(value);
        addTaint(index);
        checkIndex(index, SizeOf.FLOAT);
        this.block.pokeInt(offset + index, Float.floatToRawIntBits(value), order);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_188963628 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_188963628.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_188963628;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.FLOAT);
        //this.block.pokeInt(offset + index, Float.floatToRawIntBits(value), order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.671 -0400", hash_original_method = "8B2258E2CDB6554D65089AAF42AB6164", hash_generated_method = "23C511525D446C8450199F078832AEE0")
    @Override
    public ByteBuffer putInt(int value) {
        addTaint(value);
        int newPosition = position + SizeOf.INT;
        if(newPosition > limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1557307268 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1557307268.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1557307268;
        } //End block
        this.block.pokeInt(offset + position, value, order);
        position = newPosition;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1481160782 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1481160782.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1481160782;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.INT;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //this.block.pokeInt(offset + position, value, order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.672 -0400", hash_original_method = "8C6F9A9AD35489B3E9144FE27229FEA6", hash_generated_method = "2084D01989806D10BC5076DCCC46E1BE")
    @Override
    public ByteBuffer putInt(int index, int value) {
        addTaint(value);
        addTaint(index);
        checkIndex(index, SizeOf.INT);
        this.block.pokeInt(offset + index, value, order);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_456453921 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_456453921.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_456453921;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.INT);
        //this.block.pokeInt(offset + index, value, order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.673 -0400", hash_original_method = "1B6AA9EF9F994F4063EEE65EEDAD78AF", hash_generated_method = "31CB560E632F8C8F0E011BBE412F9A6F")
    @Override
    public ByteBuffer putLong(long value) {
        addTaint(value);
        int newPosition = position + SizeOf.LONG;
        if(newPosition > limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_293321310 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_293321310.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_293321310;
        } //End block
        this.block.pokeLong(offset + position, value, order);
        position = newPosition;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_885200726 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_885200726.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_885200726;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.LONG;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //this.block.pokeLong(offset + position, value, order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.673 -0400", hash_original_method = "4C4D1F2ADFCF9A28948ABA57C52309AC", hash_generated_method = "ED630E9104238307B3148BF4C94ED8CA")
    @Override
    public ByteBuffer putLong(int index, long value) {
        addTaint(value);
        addTaint(index);
        checkIndex(index, SizeOf.LONG);
        this.block.pokeLong(offset + index, value, order);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1135262838 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1135262838.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1135262838;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.LONG);
        //this.block.pokeLong(offset + index, value, order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.674 -0400", hash_original_method = "3ACD25E4A627200A6604DD06DE084CC0", hash_generated_method = "08230F0BD0D4D74195A10432F9F6EFAA")
    @Override
    public ByteBuffer putShort(short value) {
        addTaint(value);
        int newPosition = position + SizeOf.SHORT;
        if(newPosition > limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_445808502 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_445808502.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_445808502;
        } //End block
        this.block.pokeShort(offset + position, value, order);
        position = newPosition;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_817420966 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_817420966.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_817420966;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.SHORT;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //this.block.pokeShort(offset + position, value, order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.674 -0400", hash_original_method = "BC61FE6FEC8007EEA3BC0AA561C1C935", hash_generated_method = "26C86491E1777B074236AD02B8A3E8FD")
    @Override
    public ByteBuffer putShort(int index, short value) {
        addTaint(value);
        addTaint(index);
        checkIndex(index, SizeOf.SHORT);
        this.block.pokeShort(offset + index, value, order);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1989901607 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1989901607.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1989901607;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.SHORT);
        //this.block.pokeShort(offset + index, value, order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.675 -0400", hash_original_method = "D4755AC954967E40D5DAD107FB36CBC4", hash_generated_method = "4C1CAEA092E2C0393453F587930AED26")
    @Override
    public ByteBuffer slice() {
ByteBuffer var0F2E98598D64ED8F01A29053D96965F6_691501863 =         new ReadWriteDirectByteBuffer(block, remaining(), offset + position);
        var0F2E98598D64ED8F01A29053D96965F6_691501863.addTaint(taint);
        return var0F2E98598D64ED8F01A29053D96965F6_691501863;
        // ---------- Original Method ----------
        //return new ReadWriteDirectByteBuffer(block, remaining(), offset + position);
    }

    
}

