package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





abstract class ShortArrayBuffer extends ShortBuffer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.167 -0500", hash_original_field = "0A4ECA1B121A47F10A1E5DF0E41F62BB", hash_generated_field = "D6BFE43B0E3E7A05E4F673EAC5DBB347")


    protected  short[] backingArray;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.170 -0500", hash_original_field = "B7E810BF01B52122CB927525A0CA4721", hash_generated_field = "22BBBB3BDBDCD622FED3EBF1A70B4EC5")


    protected  int offset;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.173 -0500", hash_original_method = "2309FEF74B5324CE6644430AA32CE10F", hash_generated_method = "2309FEF74B5324CE6644430AA32CE10F")
    
ShortArrayBuffer(short[] array) {
        this(array.length, array, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.175 -0500", hash_original_method = "83C4FE898A0AB05D8AFE678BFD611891", hash_generated_method = "83C4FE898A0AB05D8AFE678BFD611891")
    
ShortArrayBuffer(int capacity) {
        this(capacity, new short[capacity], 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.178 -0500", hash_original_method = "6241269CB95A33BDF406F3571CF80FE7", hash_generated_method = "6241269CB95A33BDF406F3571CF80FE7")
    
ShortArrayBuffer(int capacity, short[] backingArray, int offset) {
        super(capacity);
        this.backingArray = backingArray;
        this.offset = offset;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.181 -0500", hash_original_method = "3107E6B251B23EDC44F5CD8DFDAAC4B8", hash_generated_method = "F7338196DDF3BCF4AFFAA49FC8877C1A")
    
@Override
    public final short get() {
        if (position == limit) {
            throw new BufferUnderflowException();
        }
        return backingArray[offset + position++];
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.183 -0500", hash_original_method = "C45D95B915B8493973D4F3C69BA81F93", hash_generated_method = "3BCAD0461455FD40D24DEBDFD2035C9F")
    
@Override
    public final short get(int index) {
        checkIndex(index);
        return backingArray[offset + index];
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.186 -0500", hash_original_method = "89DFF38986FFC53F43866053D7635804", hash_generated_method = "370F6D6D8D95A5BEF0188E22EEEF8FCD")
    
@Override
    public final ShortBuffer get(short[] dst, int dstOffset, int shortCount) {
        if (shortCount > remaining()) {
            throw new BufferUnderflowException();
        }
        System.arraycopy(backingArray, offset + position, dst, dstOffset, shortCount);
        position += shortCount;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.189 -0500", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "1EC9A508074FE2792E86546C8EBA9E2B")
    
@Override
    public final boolean isDirect() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.191 -0500", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "FF53E3A2EB4F54AB08FAE8FA7C0C29DD")
    
@Override
    public final ByteOrder order() {
        return ByteOrder.nativeOrder();
    }

    
}

