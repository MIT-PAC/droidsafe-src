package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.io.SizeOf;
import libcore.io.Memory;

final class ReadWriteDirectByteBuffer extends DirectByteBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.917 -0400", hash_original_method = "F2F90AA1C14708BA27FBCC0DAF6F8A9D", hash_generated_method = "65AB489BCE4BC99145C0F60A49EF2C84")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ReadWriteDirectByteBuffer(int capacity) {
        super(MemoryBlock.allocate(capacity), capacity, 0);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.918 -0400", hash_original_method = "B59F4E2576E1A9EB301DFADAA106D67F", hash_generated_method = "4A29E17A4C990EBB48FA5661EF2EE988")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ReadWriteDirectByteBuffer(int address, int capacity) {
        super(MemoryBlock.wrapFromJni(address, capacity), capacity, 0);
        dsTaint.addTaint(address);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.918 -0400", hash_original_method = "64217974EE9299818C86F07054C3DD19", hash_generated_method = "84D5B9DB2981B9A9F688BCD8F8338C1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ReadWriteDirectByteBuffer(MemoryBlock block, int capacity, int offset) {
        super(block, capacity, offset);
        dsTaint.addTaint(capacity);
        dsTaint.addTaint(block.dsTaint);
        dsTaint.addTaint(offset);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.918 -0400", hash_original_method = "CE9B7C65263563316466CBF3E3F947EC", hash_generated_method = "ACFC3E90202B8EB9C4883C99DA696ED8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer asReadOnlyBuffer() {
        ByteBuffer var7722015ED403035ECEFF52DBAA3B44B5_1524094867 = (ReadOnlyDirectByteBuffer.copy(this, mark));
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ReadOnlyDirectByteBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.918 -0400", hash_original_method = "D5E5DB3E7908F6BA902162C22E7A6F05", hash_generated_method = "62DF9E0C35E6C36984482E17C7BDA73D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer compact() {
        Memory.memmove(this, 0, this, position, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Memory.memmove(this, 0, this, position, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.919 -0400", hash_original_method = "C2883EB2B7E86A704D76356E1AAB194F", hash_generated_method = "104191BBA057291C3D3147AD1950DA42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer duplicate() {
        ByteBuffer var8C82ED9E4FDE12C9486E1252174918B6_2082521919 = (copy(this, mark));
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.919 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "1F2BF0EB1F192C8C411CC0427A2B9F5B")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isReadOnly() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.919 -0400", hash_original_method = "395C1E25ABAA7CA19067E1D56A7B6B36", hash_generated_method = "E5821EFF9C1B8775725E2C7F6035104E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer put(byte value) {
        dsTaint.addTaint(value);
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        this.block.pokeByte(offset + position++, value);
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //this.block.pokeByte(offset + position++, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.919 -0400", hash_original_method = "652949A668C0C42E265D3C7FA8C1BFFC", hash_generated_method = "5F26C44788CB8F7558EEA80BE0A9EBCD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer put(int index, byte value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
        checkIndex(index);
        this.block.pokeByte(offset + index, value);
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkIndex(index);
        //this.block.pokeByte(offset + index, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.919 -0400", hash_original_method = "BDD014EAD3BC316DD5191C68FD62AF55", hash_generated_method = "22CA95FCAC925520EC79C4D0187576C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        checkPutBounds(1, src.length, srcOffset, byteCount);
        this.block.pokeByteArray(offset + position, src, srcOffset, byteCount);
        position += byteCount;
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkPutBounds(1, src.length, srcOffset, byteCount);
        //this.block.pokeByteArray(offset + position, src, srcOffset, byteCount);
        //position += byteCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.919 -0400", hash_original_method = "3221718B504A786DEFCB0B7DC092A6F4", hash_generated_method = "4B78F26BBA83BBF9D3521A9871D49004")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void put(char[] src, int srcOffset, int charCount) {
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        dsTaint.addTaint(charCount);
        int byteCount;
        byteCount = checkPutBounds(SizeOf.CHAR, src.length, srcOffset, charCount);
        this.block.pokeCharArray(offset + position, src, srcOffset, charCount, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkPutBounds(SizeOf.CHAR, src.length, srcOffset, charCount);
        //this.block.pokeCharArray(offset + position, src, srcOffset, charCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.920 -0400", hash_original_method = "96DFC920F61F6006882BF66934B5DF94", hash_generated_method = "DCC9CDCBB9CA813A887B6F838ABE2CBE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void put(double[] src, int srcOffset, int doubleCount) {
        dsTaint.addTaint(doubleCount);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        int byteCount;
        byteCount = checkPutBounds(SizeOf.DOUBLE, src.length, srcOffset, doubleCount);
        this.block.pokeDoubleArray(offset + position, src, srcOffset, doubleCount, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkPutBounds(SizeOf.DOUBLE, src.length, srcOffset, doubleCount);
        //this.block.pokeDoubleArray(offset + position, src, srcOffset, doubleCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.920 -0400", hash_original_method = "C81F946AF2E7397E3B6D2FB9DB9038F5", hash_generated_method = "43350895D7304FA28E6770F805916C67")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void put(float[] src, int srcOffset, int floatCount) {
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        dsTaint.addTaint(floatCount);
        int byteCount;
        byteCount = checkPutBounds(SizeOf.FLOAT, src.length, srcOffset, floatCount);
        this.block.pokeFloatArray(offset + position, src, srcOffset, floatCount, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkPutBounds(SizeOf.FLOAT, src.length, srcOffset, floatCount);
        //this.block.pokeFloatArray(offset + position, src, srcOffset, floatCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.920 -0400", hash_original_method = "69116E139CC5D8D5FB2D59FB1E27087D", hash_generated_method = "2E19E8EAC683DCAD29E7E0E557EAB7C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void put(int[] src, int srcOffset, int intCount) {
        dsTaint.addTaint(intCount);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        int byteCount;
        byteCount = checkPutBounds(SizeOf.INT, src.length, srcOffset, intCount);
        this.block.pokeIntArray(offset + position, src, srcOffset, intCount, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkPutBounds(SizeOf.INT, src.length, srcOffset, intCount);
        //this.block.pokeIntArray(offset + position, src, srcOffset, intCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.920 -0400", hash_original_method = "F69F67F942D07574E852DB6B4C993418", hash_generated_method = "18439A2386915E3C582F2458745897AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void put(long[] src, int srcOffset, int longCount) {
        dsTaint.addTaint(longCount);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        int byteCount;
        byteCount = checkPutBounds(SizeOf.LONG, src.length, srcOffset, longCount);
        this.block.pokeLongArray(offset + position, src, srcOffset, longCount, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkPutBounds(SizeOf.LONG, src.length, srcOffset, longCount);
        //this.block.pokeLongArray(offset + position, src, srcOffset, longCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.920 -0400", hash_original_method = "E0EA76B0F879DDFFA81447B27E7A4446", hash_generated_method = "E16E46F08B2878C218BCB4ECE5948F86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void put(short[] src, int srcOffset, int shortCount) {
        dsTaint.addTaint(shortCount);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        int byteCount;
        byteCount = checkPutBounds(SizeOf.SHORT, src.length, srcOffset, shortCount);
        this.block.pokeShortArray(offset + position, src, srcOffset, shortCount, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkPutBounds(SizeOf.SHORT, src.length, srcOffset, shortCount);
        //this.block.pokeShortArray(offset + position, src, srcOffset, shortCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.921 -0400", hash_original_method = "F0572D8329DABC9F86465CEDFC740ABD", hash_generated_method = "648DDB939B0BC6F30929C87383481DA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putChar(char value) {
        dsTaint.addTaint(value);
        int newPosition;
        newPosition = position + SizeOf.CHAR;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        this.block.pokeShort(offset + position, (short) value, order);
        position = newPosition;
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.CHAR;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //this.block.pokeShort(offset + position, (short) value, order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.921 -0400", hash_original_method = "CBD66B79847E3D8D427C79D0498E0CCC", hash_generated_method = "273E8E23E8E0E368B86790B6AE590F42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putChar(int index, char value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
        checkIndex(index, SizeOf.CHAR);
        this.block.pokeShort(offset + index, (short) value, order);
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.CHAR);
        //this.block.pokeShort(offset + index, (short) value, order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.921 -0400", hash_original_method = "9ED8D9340D66DD3DF3B6EBAEE44AFD16", hash_generated_method = "FCED520B52046844CB0477548DE6D46D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putDouble(double value) {
        dsTaint.addTaint(value);
        int newPosition;
        newPosition = position + SizeOf.DOUBLE;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        this.block.pokeLong(offset + position, Double.doubleToRawLongBits(value), order);
        position = newPosition;
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.DOUBLE;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //this.block.pokeLong(offset + position, Double.doubleToRawLongBits(value), order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.921 -0400", hash_original_method = "8AAC575A61B55D0966D81E09A35D0181", hash_generated_method = "B69BE2964692571A8FEE2E0B9A22F582")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putDouble(int index, double value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
        checkIndex(index, SizeOf.DOUBLE);
        this.block.pokeLong(offset + index, Double.doubleToRawLongBits(value), order);
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.DOUBLE);
        //this.block.pokeLong(offset + index, Double.doubleToRawLongBits(value), order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.921 -0400", hash_original_method = "0A3477476230781B1656EAAB87E3304B", hash_generated_method = "AD33100E17E2EB98A040C4CD998E2763")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putFloat(float value) {
        dsTaint.addTaint(value);
        int newPosition;
        newPosition = position + SizeOf.FLOAT;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        this.block.pokeInt(offset + position, Float.floatToRawIntBits(value), order);
        position = newPosition;
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.FLOAT;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //this.block.pokeInt(offset + position, Float.floatToRawIntBits(value), order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.922 -0400", hash_original_method = "E1D9BD09C632F025AC8B3D46ED3F66A9", hash_generated_method = "A9DACE187BA59B2532533A3D00799947")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putFloat(int index, float value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
        checkIndex(index, SizeOf.FLOAT);
        this.block.pokeInt(offset + index, Float.floatToRawIntBits(value), order);
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.FLOAT);
        //this.block.pokeInt(offset + index, Float.floatToRawIntBits(value), order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.922 -0400", hash_original_method = "8B2258E2CDB6554D65089AAF42AB6164", hash_generated_method = "2DCEEF2058D5E6FAEB40550CCE07EC5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putInt(int value) {
        dsTaint.addTaint(value);
        int newPosition;
        newPosition = position + SizeOf.INT;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        this.block.pokeInt(offset + position, value, order);
        position = newPosition;
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.INT;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //this.block.pokeInt(offset + position, value, order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.922 -0400", hash_original_method = "8C6F9A9AD35489B3E9144FE27229FEA6", hash_generated_method = "C90E10328E4AE301D5FC6F43F1112A2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putInt(int index, int value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
        checkIndex(index, SizeOf.INT);
        this.block.pokeInt(offset + index, value, order);
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.INT);
        //this.block.pokeInt(offset + index, value, order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.922 -0400", hash_original_method = "1B6AA9EF9F994F4063EEE65EEDAD78AF", hash_generated_method = "2D684EB5CE085C64A78F87F6D79487CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putLong(long value) {
        dsTaint.addTaint(value);
        int newPosition;
        newPosition = position + SizeOf.LONG;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        this.block.pokeLong(offset + position, value, order);
        position = newPosition;
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.LONG;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //this.block.pokeLong(offset + position, value, order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.922 -0400", hash_original_method = "4C4D1F2ADFCF9A28948ABA57C52309AC", hash_generated_method = "9A7EDFC4118B851A5B44B70A547BAEA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putLong(int index, long value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
        checkIndex(index, SizeOf.LONG);
        this.block.pokeLong(offset + index, value, order);
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.LONG);
        //this.block.pokeLong(offset + index, value, order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.923 -0400", hash_original_method = "3ACD25E4A627200A6604DD06DE084CC0", hash_generated_method = "4D6023850C10C83F4223E765FAF9AE99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putShort(short value) {
        dsTaint.addTaint(value);
        int newPosition;
        newPosition = position + SizeOf.SHORT;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        this.block.pokeShort(offset + position, value, order);
        position = newPosition;
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.SHORT;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //this.block.pokeShort(offset + position, value, order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.923 -0400", hash_original_method = "BC61FE6FEC8007EEA3BC0AA561C1C935", hash_generated_method = "7A83707B7030A7980610F236DECF3D32")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putShort(int index, short value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
        checkIndex(index, SizeOf.SHORT);
        this.block.pokeShort(offset + index, value, order);
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.SHORT);
        //this.block.pokeShort(offset + index, value, order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.923 -0400", hash_original_method = "D4755AC954967E40D5DAD107FB36CBC4", hash_generated_method = "6B243128FB5D28EEAA1742213199D46A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer slice() {
        ByteBuffer var2AEE8F97EFB1E919134E49F540017CE9_1452625921 = (new ReadWriteDirectByteBuffer(block, remaining(), offset + position));
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ReadWriteDirectByteBuffer(block, remaining(), offset + position);
    }

    
}

