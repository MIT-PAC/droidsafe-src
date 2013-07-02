package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import libcore.io.SizeOf;
import libcore.io.Memory;

final class ReadWriteDirectByteBuffer extends DirectByteBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.042 -0400", hash_original_method = "F2F90AA1C14708BA27FBCC0DAF6F8A9D", hash_generated_method = "A1D49C312E14188BB002F04E7B541A21")
      ReadWriteDirectByteBuffer(int capacity) {
        super(MemoryBlock.allocate(capacity), capacity, 0);
        addTaint(capacity);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.042 -0400", hash_original_method = "B59F4E2576E1A9EB301DFADAA106D67F", hash_generated_method = "4DBC541F028817814A8B0165E80478BA")
      ReadWriteDirectByteBuffer(int address, int capacity) {
        super(MemoryBlock.wrapFromJni(address, capacity), capacity, 0);
        addTaint(address);
        addTaint(capacity);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.042 -0400", hash_original_method = "64217974EE9299818C86F07054C3DD19", hash_generated_method = "CE9C0657FBC2886847E6FF2A8981FE9E")
      ReadWriteDirectByteBuffer(MemoryBlock block, int capacity, int offset) {
        super(block, capacity, offset);
        addTaint(block.getTaint());
        addTaint(capacity);
        addTaint(offset);
        
    }

    
    @DSModeled(DSC.SAFE)
    static ReadWriteDirectByteBuffer copy(DirectByteBuffer other, int markOfOther) {
        ReadWriteDirectByteBuffer buf =
                new ReadWriteDirectByteBuffer(other.block, other.capacity(), other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.043 -0400", hash_original_method = "CE9B7C65263563316466CBF3E3F947EC", hash_generated_method = "91339DA2436BCAA786E01EBD7DDA57EC")
    @Override
    public ByteBuffer asReadOnlyBuffer() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_506470668 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_506470668 = ReadOnlyDirectByteBuffer.copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_506470668.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_506470668;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.044 -0400", hash_original_method = "D5E5DB3E7908F6BA902162C22E7A6F05", hash_generated_method = "C6264B0695A64496F36960EC64FFE99A")
    @Override
    public ByteBuffer compact() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1045972758 = null; 
        Memory.memmove(this, 0, this, position, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_1045972758 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1045972758.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1045972758;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.044 -0400", hash_original_method = "C2883EB2B7E86A704D76356E1AAB194F", hash_generated_method = "D57254242D864F608B18D6487E7224A0")
    @Override
    public ByteBuffer duplicate() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1521258136 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1521258136 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_1521258136.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1521258136;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.044 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "B7EF59703E310DDD57ECC81A2EB25337")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_98658210 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_98658210;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.045 -0400", hash_original_method = "395C1E25ABAA7CA19067E1D56A7B6B36", hash_generated_method = "9387E465BCCA97DD36CE5DBBD205CCA4")
    @Override
    public ByteBuffer put(byte value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1804872030 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } 
        this.block.pokeByte(offset + position++, value);
        varB4EAC82CA7396A68D541C85D26508E83_1804872030 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1804872030.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1804872030;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.046 -0400", hash_original_method = "652949A668C0C42E265D3C7FA8C1BFFC", hash_generated_method = "B9EEF9C2D66B20723A7D1601322C91D6")
    @Override
    public ByteBuffer put(int index, byte value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1774948555 = null; 
        checkIndex(index);
        this.block.pokeByte(offset + index, value);
        varB4EAC82CA7396A68D541C85D26508E83_1774948555 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1774948555.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1774948555;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.046 -0400", hash_original_method = "BDD014EAD3BC316DD5191C68FD62AF55", hash_generated_method = "FC2B47F6219B02435830870565416FDC")
    @Override
    public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1532652704 = null; 
        checkPutBounds(1, src.length, srcOffset, byteCount);
        this.block.pokeByteArray(offset + position, src, srcOffset, byteCount);
        position += byteCount;
        varB4EAC82CA7396A68D541C85D26508E83_1532652704 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(byteCount);
        varB4EAC82CA7396A68D541C85D26508E83_1532652704.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1532652704;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.047 -0400", hash_original_method = "3221718B504A786DEFCB0B7DC092A6F4", hash_generated_method = "9B6613133FD36E73E6C667926858D02A")
    final void put(char[] src, int srcOffset, int charCount) {
        int byteCount = checkPutBounds(SizeOf.CHAR, src.length, srcOffset, charCount);
        this.block.pokeCharArray(offset + position, src, srcOffset, charCount, order.needsSwap);
        position += byteCount;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(charCount);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.047 -0400", hash_original_method = "96DFC920F61F6006882BF66934B5DF94", hash_generated_method = "BC0AE3009F7EAA785173FB9A9410EBC9")
    final void put(double[] src, int srcOffset, int doubleCount) {
        int byteCount = checkPutBounds(SizeOf.DOUBLE, src.length, srcOffset, doubleCount);
        this.block.pokeDoubleArray(offset + position, src, srcOffset, doubleCount, order.needsSwap);
        position += byteCount;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(doubleCount);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.047 -0400", hash_original_method = "C81F946AF2E7397E3B6D2FB9DB9038F5", hash_generated_method = "5698C9913CB29F6D4924EF870B363B09")
    final void put(float[] src, int srcOffset, int floatCount) {
        int byteCount = checkPutBounds(SizeOf.FLOAT, src.length, srcOffset, floatCount);
        this.block.pokeFloatArray(offset + position, src, srcOffset, floatCount, order.needsSwap);
        position += byteCount;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(floatCount);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.048 -0400", hash_original_method = "69116E139CC5D8D5FB2D59FB1E27087D", hash_generated_method = "F8E1A5FC69BF2FACE453D4A306CD9904")
    final void put(int[] src, int srcOffset, int intCount) {
        int byteCount = checkPutBounds(SizeOf.INT, src.length, srcOffset, intCount);
        this.block.pokeIntArray(offset + position, src, srcOffset, intCount, order.needsSwap);
        position += byteCount;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(intCount);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.048 -0400", hash_original_method = "F69F67F942D07574E852DB6B4C993418", hash_generated_method = "EF7258DF1B5FE95DFAE85A6CF7C0599E")
    final void put(long[] src, int srcOffset, int longCount) {
        int byteCount = checkPutBounds(SizeOf.LONG, src.length, srcOffset, longCount);
        this.block.pokeLongArray(offset + position, src, srcOffset, longCount, order.needsSwap);
        position += byteCount;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(longCount);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.049 -0400", hash_original_method = "E0EA76B0F879DDFFA81447B27E7A4446", hash_generated_method = "8766E61ED173D89EB33DA5A069581A8E")
    final void put(short[] src, int srcOffset, int shortCount) {
        int byteCount = checkPutBounds(SizeOf.SHORT, src.length, srcOffset, shortCount);
        this.block.pokeShortArray(offset + position, src, srcOffset, shortCount, order.needsSwap);
        position += byteCount;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(shortCount);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.050 -0400", hash_original_method = "F0572D8329DABC9F86465CEDFC740ABD", hash_generated_method = "05454CBD39E856289F9517F559C7B7C8")
    @Override
    public ByteBuffer putChar(char value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_692811183 = null; 
        int newPosition = position + SizeOf.CHAR;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } 
        this.block.pokeShort(offset + position, (short) value, order);
        position = newPosition;
        varB4EAC82CA7396A68D541C85D26508E83_692811183 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_692811183.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_692811183;
        
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.051 -0400", hash_original_method = "CBD66B79847E3D8D427C79D0498E0CCC", hash_generated_method = "1B4863F48A67F2C9241FFED7476FD67A")
    @Override
    public ByteBuffer putChar(int index, char value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_66643320 = null; 
        checkIndex(index, SizeOf.CHAR);
        this.block.pokeShort(offset + index, (short) value, order);
        varB4EAC82CA7396A68D541C85D26508E83_66643320 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_66643320.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_66643320;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.051 -0400", hash_original_method = "9ED8D9340D66DD3DF3B6EBAEE44AFD16", hash_generated_method = "31B26520F29EE69CC2CB0D9ED504AEF3")
    @Override
    public ByteBuffer putDouble(double value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_528034617 = null; 
        int newPosition = position + SizeOf.DOUBLE;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } 
        this.block.pokeLong(offset + position, Double.doubleToRawLongBits(value), order);
        position = newPosition;
        varB4EAC82CA7396A68D541C85D26508E83_528034617 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_528034617.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_528034617;
        
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.052 -0400", hash_original_method = "8AAC575A61B55D0966D81E09A35D0181", hash_generated_method = "B2A947B9F050F770D3153F246F411DC7")
    @Override
    public ByteBuffer putDouble(int index, double value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_387643196 = null; 
        checkIndex(index, SizeOf.DOUBLE);
        this.block.pokeLong(offset + index, Double.doubleToRawLongBits(value), order);
        varB4EAC82CA7396A68D541C85D26508E83_387643196 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_387643196.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_387643196;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.053 -0400", hash_original_method = "0A3477476230781B1656EAAB87E3304B", hash_generated_method = "C87AF838868893A86E59958FDD977348")
    @Override
    public ByteBuffer putFloat(float value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1875375486 = null; 
        int newPosition = position + SizeOf.FLOAT;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } 
        this.block.pokeInt(offset + position, Float.floatToRawIntBits(value), order);
        position = newPosition;
        varB4EAC82CA7396A68D541C85D26508E83_1875375486 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1875375486.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1875375486;
        
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.054 -0400", hash_original_method = "E1D9BD09C632F025AC8B3D46ED3F66A9", hash_generated_method = "3C2E039A2620444512AAD57BCC5B37CD")
    @Override
    public ByteBuffer putFloat(int index, float value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_547681612 = null; 
        checkIndex(index, SizeOf.FLOAT);
        this.block.pokeInt(offset + index, Float.floatToRawIntBits(value), order);
        varB4EAC82CA7396A68D541C85D26508E83_547681612 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_547681612.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_547681612;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.055 -0400", hash_original_method = "8B2258E2CDB6554D65089AAF42AB6164", hash_generated_method = "CD2FE418FC6D65EBE5EB64D8320B5ED5")
    @Override
    public ByteBuffer putInt(int value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_717050175 = null; 
        int newPosition = position + SizeOf.INT;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } 
        this.block.pokeInt(offset + position, value, order);
        position = newPosition;
        varB4EAC82CA7396A68D541C85D26508E83_717050175 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_717050175.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_717050175;
        
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.056 -0400", hash_original_method = "8C6F9A9AD35489B3E9144FE27229FEA6", hash_generated_method = "E5F7DAC12C26F7C4E55DA0234EA0B67C")
    @Override
    public ByteBuffer putInt(int index, int value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_638911656 = null; 
        checkIndex(index, SizeOf.INT);
        this.block.pokeInt(offset + index, value, order);
        varB4EAC82CA7396A68D541C85D26508E83_638911656 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_638911656.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_638911656;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.059 -0400", hash_original_method = "1B6AA9EF9F994F4063EEE65EEDAD78AF", hash_generated_method = "A9FE71F1940294AD95BC2BB42E038DC7")
    @Override
    public ByteBuffer putLong(long value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_596668378 = null; 
        int newPosition = position + SizeOf.LONG;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } 
        this.block.pokeLong(offset + position, value, order);
        position = newPosition;
        varB4EAC82CA7396A68D541C85D26508E83_596668378 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_596668378.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_596668378;
        
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.061 -0400", hash_original_method = "4C4D1F2ADFCF9A28948ABA57C52309AC", hash_generated_method = "BD49607C707602026E457576DFD13070")
    @Override
    public ByteBuffer putLong(int index, long value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_266673289 = null; 
        checkIndex(index, SizeOf.LONG);
        this.block.pokeLong(offset + index, value, order);
        varB4EAC82CA7396A68D541C85D26508E83_266673289 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_266673289.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_266673289;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.062 -0400", hash_original_method = "3ACD25E4A627200A6604DD06DE084CC0", hash_generated_method = "E86EB9ECCA34D3C911F0FDD0A0E40BB1")
    @Override
    public ByteBuffer putShort(short value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1432590727 = null; 
        int newPosition = position + SizeOf.SHORT;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } 
        this.block.pokeShort(offset + position, value, order);
        position = newPosition;
        varB4EAC82CA7396A68D541C85D26508E83_1432590727 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1432590727.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1432590727;
        
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.063 -0400", hash_original_method = "BC61FE6FEC8007EEA3BC0AA561C1C935", hash_generated_method = "4490C578E5EE940D942D174A8EBA4B24")
    @Override
    public ByteBuffer putShort(int index, short value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1122710283 = null; 
        checkIndex(index, SizeOf.SHORT);
        this.block.pokeShort(offset + index, value, order);
        varB4EAC82CA7396A68D541C85D26508E83_1122710283 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1122710283.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1122710283;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.063 -0400", hash_original_method = "D4755AC954967E40D5DAD107FB36CBC4", hash_generated_method = "B0258EC31155915A341F24DF06BF3B7A")
    @Override
    public ByteBuffer slice() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1905326620 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1905326620 = new ReadWriteDirectByteBuffer(block, remaining(), offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_1905326620.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1905326620;
        
        
    }

    
}

