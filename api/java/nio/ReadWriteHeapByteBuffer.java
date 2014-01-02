package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import libcore.io.Memory;
import libcore.io.SizeOf;




final class ReadWriteHeapByteBuffer extends HeapByteBuffer {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.759 -0500", hash_original_method = "D8F52E8B0014492B64280C8D830BE45D", hash_generated_method = "9ABE08A12BB800BF5E2FE1F348B24DCA")
    
static ReadWriteHeapByteBuffer copy(HeapByteBuffer other, int markOfOther) {
        ReadWriteHeapByteBuffer buf =
                new ReadWriteHeapByteBuffer(other.backingArray, other.capacity(), other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.762 -0500", hash_original_method = "698A4093B5D08261CD10BBA0DD254D03", hash_generated_method = "698A4093B5D08261CD10BBA0DD254D03")
    
ReadWriteHeapByteBuffer(byte[] backingArray) {
        super(backingArray);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.764 -0500", hash_original_method = "39FF2878164033A82C16A4024A20F407", hash_generated_method = "39FF2878164033A82C16A4024A20F407")
    
ReadWriteHeapByteBuffer(int capacity) {
        super(capacity);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.767 -0500", hash_original_method = "705DEFE9EE10EC6D3F5F785589C89AC0", hash_generated_method = "705DEFE9EE10EC6D3F5F785589C89AC0")
    
ReadWriteHeapByteBuffer(byte[] backingArray, int capacity, int arrayOffset) {
        super(backingArray, capacity, arrayOffset);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.770 -0500", hash_original_method = "DAFC57596AF38F7142398219C2B48840", hash_generated_method = "855A6B8048FC6C558B5B12C48BFA9A0C")
    
@Override
    public ByteBuffer asReadOnlyBuffer() {
        return ReadOnlyHeapByteBuffer.copy(this, mark);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.772 -0500", hash_original_method = "E8B47769CA0E36E125D00B7BF0C31D0B", hash_generated_method = "11AD393247FC3531CE051417A856A13F")
    
@Override
    public ByteBuffer compact() {
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.774 -0500", hash_original_method = "C2883EB2B7E86A704D76356E1AAB194F", hash_generated_method = "ED4EF02B9858C417E9309F42C851963A")
    
@Override
    public ByteBuffer duplicate() {
        return copy(this, mark);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.777 -0500", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "71081A201DF7B08144D6AE781E679981")
    
@Override
    public boolean isReadOnly() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.779 -0500", hash_original_method = "DFA49F6DA30AF833A3263BE3EE9CD5BB", hash_generated_method = "C841D45CC1FB04924EA78669A55EFC77")
    
@Override
    protected byte[] protectedArray() {
        return backingArray;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.782 -0500", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "F5674176D88BEBAEFE4F538492719546")
    
@Override
    protected int protectedArrayOffset() {
        return offset;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.785 -0500", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "314D008C862B56E51390FC603128783F")
    
@Override
    protected boolean protectedHasArray() {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.788 -0500", hash_original_method = "72E0A22D7133932D83149D22C98F13AD", hash_generated_method = "6BDC587B214F88BCF3130A27ADFCBD69")
    
@Override
    public ByteBuffer put(byte b) {
        if (position == limit) {
            throw new BufferOverflowException();
        }
        backingArray[offset + position++] = b;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.790 -0500", hash_original_method = "78F8125A8164FE61A30FAF2DC4593DB0", hash_generated_method = "62A168A27C70E26C9B512CD645300A78")
    
@Override
    public ByteBuffer put(int index, byte b) {
        checkIndex(index);
        backingArray[offset + index] = b;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.793 -0500", hash_original_method = "B19EE749C09ADF1A37CE1094243997D4", hash_generated_method = "52FC6093A82B1500734BE774317CD812")
    
@Override
    public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
        checkPutBounds(1, src.length, srcOffset, byteCount);
        System.arraycopy(src, srcOffset, backingArray, offset + position, byteCount);
        position += byteCount;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.795 -0500", hash_original_method = "45B8F2F72971D070F593434F2D8E9160", hash_generated_method = "B728EF84672A1F87CFEAB5DD156AB32A")
    
final void put(char[] src, int srcOffset, int charCount) {
        int byteCount = checkPutBounds(SizeOf.CHAR, src.length, srcOffset, charCount);
        Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.CHAR, order.needsSwap);
        position += byteCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.798 -0500", hash_original_method = "9ABCB25C494E5D0A0EE76A30D8E8B283", hash_generated_method = "EEFA3396E68322D10D967E2C2DDB62CD")
    
final void put(double[] src, int srcOffset, int doubleCount) {
        int byteCount = checkPutBounds(SizeOf.DOUBLE, src.length, srcOffset, doubleCount);
        Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.DOUBLE, order.needsSwap);
        position += byteCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.800 -0500", hash_original_method = "0A59724EAC29A22512857FADB561826F", hash_generated_method = "D94DD572A2E3768D31331D653DEBC17D")
    
final void put(float[] src, int srcOffset, int floatCount) {
        int byteCount = checkPutBounds(SizeOf.FLOAT, src.length, srcOffset, floatCount);
        Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.FLOAT, order.needsSwap);
        position += byteCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.803 -0500", hash_original_method = "5866478CCFA9AC7EB5AD084734CBE2FD", hash_generated_method = "35CA77A17ECFFA52A1468D2042041933")
    
final void put(int[] src, int srcOffset, int intCount) {
        int byteCount = checkPutBounds(SizeOf.INT, src.length, srcOffset, intCount);
        Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.INT, order.needsSwap);
        position += byteCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.805 -0500", hash_original_method = "4DE3C17BC2F6A0E6284BCBDEFF4353E5", hash_generated_method = "FA8062DF8FD184C70F4277909EFB7727")
    
final void put(long[] src, int srcOffset, int longCount) {
        int byteCount = checkPutBounds(SizeOf.LONG, src.length, srcOffset, longCount);
        Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.LONG, order.needsSwap);
        position += byteCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.807 -0500", hash_original_method = "77593A6CF9C8DAF6764F897CF6EC2842", hash_generated_method = "EAE8B1216F3E97B7C64C6665F01067EF")
    
final void put(short[] src, int srcOffset, int shortCount) {
        int byteCount = checkPutBounds(SizeOf.SHORT, src.length, srcOffset, shortCount);
        Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.SHORT, order.needsSwap);
        position += byteCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.811 -0500", hash_original_method = "82EE1C0866E5BEF2C6330A6E38277E0B", hash_generated_method = "0D3429B39E7B949CCF4A7A722F9B4323")
    
@Override
    public ByteBuffer putChar(int index, char value) {
        checkIndex(index, SizeOf.CHAR);
        Memory.pokeShort(backingArray, offset + index, (short) value, order);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.814 -0500", hash_original_method = "15F32C27634A3E86C7051E2D179448EE", hash_generated_method = "CB7011749562DA4E93666385682B6869")
    
@Override
    public ByteBuffer putChar(char value) {
        int newPosition = position + SizeOf.CHAR;
        if (newPosition > limit) {
            throw new BufferOverflowException();
        }
        Memory.pokeShort(backingArray, offset + position, (short) value, order);
        position = newPosition;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.816 -0500", hash_original_method = "D3D66F8ECD97953078E15D88E3210D7C", hash_generated_method = "B546CF7347862E08E05F010EC04F4DCF")
    
@Override
    public ByteBuffer putDouble(double value) {
        return putLong(Double.doubleToRawLongBits(value));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.818 -0500", hash_original_method = "FE6D03BC4C20DB28CF1BCC78BA5DBE78", hash_generated_method = "1159482AC67B4C74363BFB04CC935053")
    
@Override
    public ByteBuffer putDouble(int index, double value) {
        return putLong(index, Double.doubleToRawLongBits(value));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.821 -0500", hash_original_method = "E45ECD1B48C76B33C550D1D3ABE8CF24", hash_generated_method = "F1B009E253B6AAF4F7087360900EF848")
    
@Override
    public ByteBuffer putFloat(float value) {
        return putInt(Float.floatToRawIntBits(value));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.823 -0500", hash_original_method = "9AFB8F5FE765C8CDC0ED3C930ED840C0", hash_generated_method = "3212C4B007946BAB3A94AF1E4C3C3334")
    
@Override
    public ByteBuffer putFloat(int index, float value) {
        return putInt(index, Float.floatToRawIntBits(value));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.826 -0500", hash_original_method = "5F1F62F303EDB135D2A78931AEAB6972", hash_generated_method = "FF0F546D203E4CA8CCD44E4A3CEA5A0E")
    
@Override
    public ByteBuffer putInt(int value) {
        int newPosition = position + SizeOf.INT;
        if (newPosition > limit) {
            throw new BufferOverflowException();
        }
        Memory.pokeInt(backingArray, offset + position, value, order);
        position = newPosition;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.829 -0500", hash_original_method = "D1A78DDD0C9ED6E4483E1AE7C4872A32", hash_generated_method = "2CE23C0AF61F75D4F6AF42180534F6D0")
    
@Override
    public ByteBuffer putInt(int index, int value) {
        checkIndex(index, SizeOf.INT);
        Memory.pokeInt(backingArray, offset + index, value, order);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.831 -0500", hash_original_method = "1EDA1D6C4FBFEC9DA3CAFFF9583F4A7A", hash_generated_method = "5797FAF80DEE87FD2E17F85A370BB932")
    
@Override
    public ByteBuffer putLong(int index, long value) {
        checkIndex(index, SizeOf.LONG);
        Memory.pokeLong(backingArray, offset + index, value, order);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.834 -0500", hash_original_method = "9648BBCB2FCB23C0FEFFC646460FB4AC", hash_generated_method = "F5C3D9020FDCDCC7A796CDC59EEE10D1")
    
@Override
    public ByteBuffer putLong(long value) {
        int newPosition = position + SizeOf.LONG;
        if (newPosition > limit) {
            throw new BufferOverflowException();
        }
        Memory.pokeLong(backingArray, offset + position, value, order);
        position = newPosition;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.837 -0500", hash_original_method = "8DD945BCFB457C15F47AA89E5C45F024", hash_generated_method = "28BB5DE8C5A9F14D3EDB367604B2F817")
    
@Override
    public ByteBuffer putShort(int index, short value) {
        checkIndex(index, SizeOf.SHORT);
        Memory.pokeShort(backingArray, offset + index, value, order);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.839 -0500", hash_original_method = "D29A208D139CC962C11C8258F595C612", hash_generated_method = "605E67BD4A37C23CA8FA2BDBCCEA8B5A")
    
@Override
    public ByteBuffer putShort(short value) {
        int newPosition = position + SizeOf.SHORT;
        if (newPosition > limit) {
            throw new BufferOverflowException();
        }
        Memory.pokeShort(backingArray, offset + position, value, order);
        position = newPosition;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.842 -0500", hash_original_method = "510A931F94808139B1B1492FD0FC70A6", hash_generated_method = "9DF2ACDA4FD622B3C1FA7AA3A86A29AE")
    
@Override
    public ByteBuffer slice() {
        return new ReadWriteHeapByteBuffer(backingArray, remaining(), offset + position);
    }

    
}

