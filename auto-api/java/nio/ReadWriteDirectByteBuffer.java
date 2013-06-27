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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.111 -0400", hash_original_method = "F2F90AA1C14708BA27FBCC0DAF6F8A9D", hash_generated_method = "A1D49C312E14188BB002F04E7B541A21")
      ReadWriteDirectByteBuffer(int capacity) {
        super(MemoryBlock.allocate(capacity), capacity, 0);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.123 -0400", hash_original_method = "B59F4E2576E1A9EB301DFADAA106D67F", hash_generated_method = "4DBC541F028817814A8B0165E80478BA")
      ReadWriteDirectByteBuffer(int address, int capacity) {
        super(MemoryBlock.wrapFromJni(address, capacity), capacity, 0);
        addTaint(address);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.123 -0400", hash_original_method = "64217974EE9299818C86F07054C3DD19", hash_generated_method = "CE9C0657FBC2886847E6FF2A8981FE9E")
      ReadWriteDirectByteBuffer(MemoryBlock block, int capacity, int offset) {
        super(block, capacity, offset);
        addTaint(block.getTaint());
        addTaint(capacity);
        addTaint(offset);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.124 -0400", hash_original_method = "CE9B7C65263563316466CBF3E3F947EC", hash_generated_method = "8AD07AEA4457CEBD70C962C661885AC3")
    @Override
    public ByteBuffer asReadOnlyBuffer() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_274786188 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_274786188 = ReadOnlyDirectByteBuffer.copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_274786188.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_274786188;
        // ---------- Original Method ----------
        //return ReadOnlyDirectByteBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.125 -0400", hash_original_method = "D5E5DB3E7908F6BA902162C22E7A6F05", hash_generated_method = "CEFB359ED14E1F0ECBC27D1BCAAA75F8")
    @Override
    public ByteBuffer compact() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_949778500 = null; //Variable for return #1
        Memory.memmove(this, 0, this, position, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_949778500 = this;
        varB4EAC82CA7396A68D541C85D26508E83_949778500.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_949778500;
        // ---------- Original Method ----------
        //Memory.memmove(this, 0, this, position, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.126 -0400", hash_original_method = "C2883EB2B7E86A704D76356E1AAB194F", hash_generated_method = "77EC9765871F7F9CA4FC4AAD6564F3A9")
    @Override
    public ByteBuffer duplicate() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1459425815 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1459425815 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_1459425815.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1459425815;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.129 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "28B75998DDEF9A3A5FF07CDC1787F2FB")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_130459441 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_130459441;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.136 -0400", hash_original_method = "395C1E25ABAA7CA19067E1D56A7B6B36", hash_generated_method = "B9B3541D53303DF70BB47694B103D6CA")
    @Override
    public ByteBuffer put(byte value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1522902725 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        this.block.pokeByte(offset + position++, value);
        varB4EAC82CA7396A68D541C85D26508E83_1522902725 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1522902725.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1522902725;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //this.block.pokeByte(offset + position++, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.154 -0400", hash_original_method = "652949A668C0C42E265D3C7FA8C1BFFC", hash_generated_method = "15D7364D8E27BC838C0F07872F307DBC")
    @Override
    public ByteBuffer put(int index, byte value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_182129895 = null; //Variable for return #1
        checkIndex(index);
        this.block.pokeByte(offset + index, value);
        varB4EAC82CA7396A68D541C85D26508E83_182129895 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_182129895.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_182129895;
        // ---------- Original Method ----------
        //checkIndex(index);
        //this.block.pokeByte(offset + index, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.166 -0400", hash_original_method = "BDD014EAD3BC316DD5191C68FD62AF55", hash_generated_method = "306406EBCDAFCEBAD059045193BDFF2A")
    @Override
    public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1537835696 = null; //Variable for return #1
        checkPutBounds(1, src.length, srcOffset, byteCount);
        this.block.pokeByteArray(offset + position, src, srcOffset, byteCount);
        position += byteCount;
        varB4EAC82CA7396A68D541C85D26508E83_1537835696 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(byteCount);
        varB4EAC82CA7396A68D541C85D26508E83_1537835696.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1537835696;
        // ---------- Original Method ----------
        //checkPutBounds(1, src.length, srcOffset, byteCount);
        //this.block.pokeByteArray(offset + position, src, srcOffset, byteCount);
        //position += byteCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.167 -0400", hash_original_method = "3221718B504A786DEFCB0B7DC092A6F4", hash_generated_method = "EECD5523FCA921241DF78846199487CE")
    final void put(char[] src, int srcOffset, int charCount) {
        int byteCount;
        byteCount = checkPutBounds(SizeOf.CHAR, src.length, srcOffset, charCount);
        this.block.pokeCharArray(offset + position, src, srcOffset, charCount, order.needsSwap);
        position += byteCount;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(charCount);
        // ---------- Original Method ----------
        //int byteCount = checkPutBounds(SizeOf.CHAR, src.length, srcOffset, charCount);
        //this.block.pokeCharArray(offset + position, src, srcOffset, charCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.167 -0400", hash_original_method = "96DFC920F61F6006882BF66934B5DF94", hash_generated_method = "24F236B81615C2CDF3CBF0D677E32F60")
    final void put(double[] src, int srcOffset, int doubleCount) {
        int byteCount;
        byteCount = checkPutBounds(SizeOf.DOUBLE, src.length, srcOffset, doubleCount);
        this.block.pokeDoubleArray(offset + position, src, srcOffset, doubleCount, order.needsSwap);
        position += byteCount;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(doubleCount);
        // ---------- Original Method ----------
        //int byteCount = checkPutBounds(SizeOf.DOUBLE, src.length, srcOffset, doubleCount);
        //this.block.pokeDoubleArray(offset + position, src, srcOffset, doubleCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.168 -0400", hash_original_method = "C81F946AF2E7397E3B6D2FB9DB9038F5", hash_generated_method = "203A0BF7337BB5AAC4CBE0A1F8CD027A")
    final void put(float[] src, int srcOffset, int floatCount) {
        int byteCount;
        byteCount = checkPutBounds(SizeOf.FLOAT, src.length, srcOffset, floatCount);
        this.block.pokeFloatArray(offset + position, src, srcOffset, floatCount, order.needsSwap);
        position += byteCount;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(floatCount);
        // ---------- Original Method ----------
        //int byteCount = checkPutBounds(SizeOf.FLOAT, src.length, srcOffset, floatCount);
        //this.block.pokeFloatArray(offset + position, src, srcOffset, floatCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.168 -0400", hash_original_method = "69116E139CC5D8D5FB2D59FB1E27087D", hash_generated_method = "2DF2D6E0A5BA66DFDA68236E3A317C53")
    final void put(int[] src, int srcOffset, int intCount) {
        int byteCount;
        byteCount = checkPutBounds(SizeOf.INT, src.length, srcOffset, intCount);
        this.block.pokeIntArray(offset + position, src, srcOffset, intCount, order.needsSwap);
        position += byteCount;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(intCount);
        // ---------- Original Method ----------
        //int byteCount = checkPutBounds(SizeOf.INT, src.length, srcOffset, intCount);
        //this.block.pokeIntArray(offset + position, src, srcOffset, intCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.168 -0400", hash_original_method = "F69F67F942D07574E852DB6B4C993418", hash_generated_method = "070488BBF2FF170B14365BD35AFB7B52")
    final void put(long[] src, int srcOffset, int longCount) {
        int byteCount;
        byteCount = checkPutBounds(SizeOf.LONG, src.length, srcOffset, longCount);
        this.block.pokeLongArray(offset + position, src, srcOffset, longCount, order.needsSwap);
        position += byteCount;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(longCount);
        // ---------- Original Method ----------
        //int byteCount = checkPutBounds(SizeOf.LONG, src.length, srcOffset, longCount);
        //this.block.pokeLongArray(offset + position, src, srcOffset, longCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.169 -0400", hash_original_method = "E0EA76B0F879DDFFA81447B27E7A4446", hash_generated_method = "1DF4F16AE7070F0017D2D542454E5ED3")
    final void put(short[] src, int srcOffset, int shortCount) {
        int byteCount;
        byteCount = checkPutBounds(SizeOf.SHORT, src.length, srcOffset, shortCount);
        this.block.pokeShortArray(offset + position, src, srcOffset, shortCount, order.needsSwap);
        position += byteCount;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(shortCount);
        // ---------- Original Method ----------
        //int byteCount = checkPutBounds(SizeOf.SHORT, src.length, srcOffset, shortCount);
        //this.block.pokeShortArray(offset + position, src, srcOffset, shortCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.174 -0400", hash_original_method = "F0572D8329DABC9F86465CEDFC740ABD", hash_generated_method = "D6822075A39A7E881D788771F5581BBA")
    @Override
    public ByteBuffer putChar(char value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1319719280 = null; //Variable for return #1
        int newPosition;
        newPosition = position + SizeOf.CHAR;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        this.block.pokeShort(offset + position, (short) value, order);
        position = newPosition;
        varB4EAC82CA7396A68D541C85D26508E83_1319719280 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1319719280.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1319719280;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.CHAR;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //this.block.pokeShort(offset + position, (short) value, order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.174 -0400", hash_original_method = "CBD66B79847E3D8D427C79D0498E0CCC", hash_generated_method = "786FE272831FC0669B6BBBDB6B032330")
    @Override
    public ByteBuffer putChar(int index, char value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_170303901 = null; //Variable for return #1
        checkIndex(index, SizeOf.CHAR);
        this.block.pokeShort(offset + index, (short) value, order);
        varB4EAC82CA7396A68D541C85D26508E83_170303901 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_170303901.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_170303901;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.CHAR);
        //this.block.pokeShort(offset + index, (short) value, order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.193 -0400", hash_original_method = "9ED8D9340D66DD3DF3B6EBAEE44AFD16", hash_generated_method = "FA6DEB756A8713F3EB27E832DA7D4F42")
    @Override
    public ByteBuffer putDouble(double value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1807955489 = null; //Variable for return #1
        int newPosition;
        newPosition = position + SizeOf.DOUBLE;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        this.block.pokeLong(offset + position, Double.doubleToRawLongBits(value), order);
        position = newPosition;
        varB4EAC82CA7396A68D541C85D26508E83_1807955489 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1807955489.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1807955489;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.DOUBLE;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //this.block.pokeLong(offset + position, Double.doubleToRawLongBits(value), order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.193 -0400", hash_original_method = "8AAC575A61B55D0966D81E09A35D0181", hash_generated_method = "592A76451C878EBC6E08A8109C0E66F5")
    @Override
    public ByteBuffer putDouble(int index, double value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_796174668 = null; //Variable for return #1
        checkIndex(index, SizeOf.DOUBLE);
        this.block.pokeLong(offset + index, Double.doubleToRawLongBits(value), order);
        varB4EAC82CA7396A68D541C85D26508E83_796174668 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_796174668.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_796174668;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.DOUBLE);
        //this.block.pokeLong(offset + index, Double.doubleToRawLongBits(value), order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.194 -0400", hash_original_method = "0A3477476230781B1656EAAB87E3304B", hash_generated_method = "F1AC9F6D01D443C59D75F3F29F1F08FD")
    @Override
    public ByteBuffer putFloat(float value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1396816170 = null; //Variable for return #1
        int newPosition;
        newPosition = position + SizeOf.FLOAT;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        this.block.pokeInt(offset + position, Float.floatToRawIntBits(value), order);
        position = newPosition;
        varB4EAC82CA7396A68D541C85D26508E83_1396816170 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1396816170.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1396816170;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.FLOAT;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //this.block.pokeInt(offset + position, Float.floatToRawIntBits(value), order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.204 -0400", hash_original_method = "E1D9BD09C632F025AC8B3D46ED3F66A9", hash_generated_method = "9C350AFF587246D50356960281D8CBE8")
    @Override
    public ByteBuffer putFloat(int index, float value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_170348262 = null; //Variable for return #1
        checkIndex(index, SizeOf.FLOAT);
        this.block.pokeInt(offset + index, Float.floatToRawIntBits(value), order);
        varB4EAC82CA7396A68D541C85D26508E83_170348262 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_170348262.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_170348262;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.FLOAT);
        //this.block.pokeInt(offset + index, Float.floatToRawIntBits(value), order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.205 -0400", hash_original_method = "8B2258E2CDB6554D65089AAF42AB6164", hash_generated_method = "FEC4E8B7A399B41174FABC4CD438D722")
    @Override
    public ByteBuffer putInt(int value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_309012225 = null; //Variable for return #1
        int newPosition;
        newPosition = position + SizeOf.INT;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        this.block.pokeInt(offset + position, value, order);
        position = newPosition;
        varB4EAC82CA7396A68D541C85D26508E83_309012225 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_309012225.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_309012225;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.INT;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //this.block.pokeInt(offset + position, value, order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.206 -0400", hash_original_method = "8C6F9A9AD35489B3E9144FE27229FEA6", hash_generated_method = "B6890AD99CDE554A89864AB57E749B41")
    @Override
    public ByteBuffer putInt(int index, int value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1083183903 = null; //Variable for return #1
        checkIndex(index, SizeOf.INT);
        this.block.pokeInt(offset + index, value, order);
        varB4EAC82CA7396A68D541C85D26508E83_1083183903 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1083183903.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1083183903;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.INT);
        //this.block.pokeInt(offset + index, value, order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.221 -0400", hash_original_method = "1B6AA9EF9F994F4063EEE65EEDAD78AF", hash_generated_method = "FC1067A62CC320D7672E2F9607F1BF12")
    @Override
    public ByteBuffer putLong(long value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_380969428 = null; //Variable for return #1
        int newPosition;
        newPosition = position + SizeOf.LONG;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        this.block.pokeLong(offset + position, value, order);
        position = newPosition;
        varB4EAC82CA7396A68D541C85D26508E83_380969428 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_380969428.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_380969428;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.LONG;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //this.block.pokeLong(offset + position, value, order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.222 -0400", hash_original_method = "4C4D1F2ADFCF9A28948ABA57C52309AC", hash_generated_method = "721E32B577AF3F819CBCF0D1FEDB85C6")
    @Override
    public ByteBuffer putLong(int index, long value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1597692945 = null; //Variable for return #1
        checkIndex(index, SizeOf.LONG);
        this.block.pokeLong(offset + index, value, order);
        varB4EAC82CA7396A68D541C85D26508E83_1597692945 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1597692945.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1597692945;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.LONG);
        //this.block.pokeLong(offset + index, value, order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.231 -0400", hash_original_method = "3ACD25E4A627200A6604DD06DE084CC0", hash_generated_method = "409F33B0C25C4B7FD0DE7A0DE7B2CD55")
    @Override
    public ByteBuffer putShort(short value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1612284421 = null; //Variable for return #1
        int newPosition;
        newPosition = position + SizeOf.SHORT;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        this.block.pokeShort(offset + position, value, order);
        position = newPosition;
        varB4EAC82CA7396A68D541C85D26508E83_1612284421 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1612284421.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1612284421;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.SHORT;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //this.block.pokeShort(offset + position, value, order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.231 -0400", hash_original_method = "BC61FE6FEC8007EEA3BC0AA561C1C935", hash_generated_method = "BB5DCFBE8290995DE12A7EE14F70DFE9")
    @Override
    public ByteBuffer putShort(int index, short value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1632849831 = null; //Variable for return #1
        checkIndex(index, SizeOf.SHORT);
        this.block.pokeShort(offset + index, value, order);
        varB4EAC82CA7396A68D541C85D26508E83_1632849831 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1632849831.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1632849831;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.SHORT);
        //this.block.pokeShort(offset + index, value, order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.232 -0400", hash_original_method = "D4755AC954967E40D5DAD107FB36CBC4", hash_generated_method = "B0324EFD18F1EE47333CB1A26BE95E04")
    @Override
    public ByteBuffer slice() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1909992185 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1909992185 = new ReadWriteDirectByteBuffer(block, remaining(), offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_1909992185.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1909992185;
        // ---------- Original Method ----------
        //return new ReadWriteDirectByteBuffer(block, remaining(), offset + position);
    }

    
}

