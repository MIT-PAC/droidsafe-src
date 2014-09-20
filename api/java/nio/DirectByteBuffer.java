package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import libcore.io.SizeOf;

abstract class DirectByteBuffer extends BaseByteBuffer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.506 -0500", hash_original_field = "B7E810BF01B52122CB927525A0CA4721", hash_generated_field = "31A2F879A77A09C1A376B33370A04001")

    // TODO: rewrite this so we set 'block' to an OffsetMemoryBlock?
    protected  int offset;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.509 -0500", hash_original_method = "474B95A59FDFCBE6BE31B5807DAED730", hash_generated_method = "1A445FFAE21BEAEFB3AF692D7E5CD41E")
    
protected DirectByteBuffer(MemoryBlock block, int capacity, int offset) {
        super(capacity, block);

        long baseSize = block.getSize();
        if (baseSize >= 0 && (capacity + offset) > baseSize) {
            throw new IllegalArgumentException("capacity + offset > baseSize");
        }

        this.offset = offset;
        this.effectiveDirectAddress = block.toInt() + offset;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.513 -0500", hash_original_method = "05EA367CE37FB792328EB9B5E5178E53", hash_generated_method = "1D32C90866A795DFAFDBD28F424891F4")
    
@Override
    public final ByteBuffer get(byte[] dst, int dstOffset, int byteCount) {
        checkGetBounds(1, dst.length, dstOffset, byteCount);
        this.block.peekByteArray(offset + position, dst, dstOffset, byteCount);
        position += byteCount;
        return this;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.516 -0500", hash_original_method = "5166EE5E9707A9E6D584C615F445133C", hash_generated_method = "B30EDA1977F77CE49FA9B1426D58DEB6")
    
final void get(char[] dst, int dstOffset, int charCount) {
        int byteCount = checkGetBounds(SizeOf.CHAR, dst.length, dstOffset, charCount);
        this.block.peekCharArray(offset + position, dst, dstOffset, charCount, order.needsSwap);
        position += byteCount;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.518 -0500", hash_original_method = "ADD0EB5B665BFADA07EEB34F0C07C866", hash_generated_method = "6C4F3C32A19700751A31E8D634D20A72")
    
final void get(double[] dst, int dstOffset, int doubleCount) {
        int byteCount = checkGetBounds(SizeOf.DOUBLE, dst.length, dstOffset, doubleCount);
        this.block.peekDoubleArray(offset + position, dst, dstOffset, doubleCount, order.needsSwap);
        position += byteCount;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.521 -0500", hash_original_method = "6E512C073258D3379E68BD1EE70E834D", hash_generated_method = "DC8D55351A0E9BD27426AEFE42D5721F")
    
final void get(float[] dst, int dstOffset, int floatCount) {
        int byteCount = checkGetBounds(SizeOf.FLOAT, dst.length, dstOffset, floatCount);
        this.block.peekFloatArray(offset + position, dst, dstOffset, floatCount, order.needsSwap);
        position += byteCount;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.523 -0500", hash_original_method = "C51D1E84C7192049016360AA331FDA28", hash_generated_method = "FBD02CAAB60A94D18E05AF8FE4113F19")
    
final void get(int[] dst, int dstOffset, int intCount) {
        int byteCount = checkGetBounds(SizeOf.INT, dst.length, dstOffset, intCount);
        this.block.peekIntArray(offset + position, dst, dstOffset, intCount, order.needsSwap);
        position += byteCount;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.525 -0500", hash_original_method = "3F36E5287836D62D1612D85220FCD9CD", hash_generated_method = "1F265C990180FD1AD92AED4E7CEDA728")
    
final void get(long[] dst, int dstOffset, int longCount) {
        int byteCount = checkGetBounds(SizeOf.LONG, dst.length, dstOffset, longCount);
        this.block.peekLongArray(offset + position, dst, dstOffset, longCount, order.needsSwap);
        position += byteCount;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.528 -0500", hash_original_method = "95F33E34C92C83F601EF4DD99BC92C04", hash_generated_method = "1EF395AB09CA9076C226A9E143E4EF79")
    
final void get(short[] dst, int dstOffset, int shortCount) {
        int byteCount = checkGetBounds(SizeOf.SHORT, dst.length, dstOffset, shortCount);
        this.block.peekShortArray(offset + position, dst, dstOffset, shortCount, order.needsSwap);
        position += byteCount;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.531 -0500", hash_original_method = "FD6E107A3BCF0EDBECB1B5D0CCC3DC10", hash_generated_method = "528B498BEE1239A022F8366E285AF715")
    
@Override
    public final byte get() {
        if (position == limit) {
            throw new BufferUnderflowException();
        }
        return this.block.peekByte(offset + position++);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.533 -0500", hash_original_method = "4EC80D94823705ACCC824037AEC83986", hash_generated_method = "9D786281E8C8FB7C9514EB5E35320A10")
    
@Override
    public final byte get(int index) {
        checkIndex(index);
        return this.block.peekByte(offset + index);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.536 -0500", hash_original_method = "24C7DEF0B0564BDE5B8AAC76D5D642E1", hash_generated_method = "F199AC4A5A06DA1E41BDB7B600FDFDEA")
    
@Override
    public final char getChar() {
        int newPosition = position + SizeOf.CHAR;
        if (newPosition > limit) {
            throw new BufferUnderflowException();
        }
        char result = (char) this.block.peekShort(offset + position, order);
        position = newPosition;
        return result;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.539 -0500", hash_original_method = "5FBE332600F81DB9B06A8F423199602B", hash_generated_method = "FA05F00B9AB6DD2608F3538E7E86E241")
    
@Override
    public final char getChar(int index) {
        checkIndex(index, SizeOf.CHAR);
        return (char) this.block.peekShort(offset + index, order);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.542 -0500", hash_original_method = "5EFA43D409368A8372AA180C23146E16", hash_generated_method = "F394C04020918682B54E6CA88F6EE740")
    
@Override
    public final double getDouble() {
        int newPosition = position + SizeOf.DOUBLE;
        if (newPosition > limit) {
            throw new BufferUnderflowException();
        }
        double result = Double.longBitsToDouble(this.block.peekLong(offset + position, order));
        position = newPosition;
        return result;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.544 -0500", hash_original_method = "96FC6E541F1994B391122E02AC73326B", hash_generated_method = "06A6DD8D022DA9AC180BFC290EC56364")
    
@Override
    public final double getDouble(int index) {
        checkIndex(index, SizeOf.DOUBLE);
        return Double.longBitsToDouble(this.block.peekLong(offset + index, order));
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.547 -0500", hash_original_method = "2EE285AEEA4FEACBF45EAADB7A9A5368", hash_generated_method = "D835509F3B91FD748E85609CF704CC1D")
    
@Override
    public final float getFloat() {
        int newPosition = position + SizeOf.FLOAT;
        if (newPosition > limit) {
            throw new BufferUnderflowException();
        }
        float result = Float.intBitsToFloat(this.block.peekInt(offset + position, order));
        position = newPosition;
        return result;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.549 -0500", hash_original_method = "050B7A76EC6791ECC7468C2E0B06A7E7", hash_generated_method = "28F9BFF2F04D2F266E87D47495586D9E")
    
@Override
    public final float getFloat(int index) {
        checkIndex(index, SizeOf.FLOAT);
        return Float.intBitsToFloat(this.block.peekInt(offset + index, order));
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.552 -0500", hash_original_method = "D5783EC3520BA4180543335F9AE942E7", hash_generated_method = "DC0F46CA0D2CC97F1AB23A141BC34BB6")
    
@Override
    public final int getInt() {
        int newPosition = position + SizeOf.INT;
        if (newPosition > limit) {
            throw new BufferUnderflowException();
        }
        int result = this.block.peekInt(offset + position, order);
        position = newPosition;
        return result;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.556 -0500", hash_original_method = "A56F512613C67F8975E594518A590248", hash_generated_method = "9FAE58A05CDDFB599F885BCF5E7EDA24")
    
@Override
    public final int getInt(int index) {
        checkIndex(index, SizeOf.INT);
        return this.block.peekInt(offset + index, order);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.559 -0500", hash_original_method = "8F4B5A1B3C9B20E6E7648EDEC4DC7AE6", hash_generated_method = "4518D29348E62C3929845A94B11CF644")
    
@Override
    public final long getLong() {
        int newPosition = position + SizeOf.LONG;
        if (newPosition > limit) {
            throw new BufferUnderflowException();
        }
        long result = this.block.peekLong(offset + position, order);
        position = newPosition;
        return result;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.561 -0500", hash_original_method = "94B0F156AE4944E60A0908AA30F792C3", hash_generated_method = "77DB8FB08C8A12EBAF489A8BF1984634")
    
@Override
    public final long getLong(int index) {
        checkIndex(index, SizeOf.LONG);
        return this.block.peekLong(offset + index, order);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.564 -0500", hash_original_method = "A23C234E65EF1DC26A40AB6396A2664F", hash_generated_method = "B3A1525A11457A28E01BB87912873355")
    
@Override
    public final short getShort() {
        int newPosition = position + SizeOf.SHORT;
        if (newPosition > limit) {
            throw new BufferUnderflowException();
        }
        short result = this.block.peekShort(offset + position, order);
        position = newPosition;
        return result;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.567 -0500", hash_original_method = "3D46A49BA7FE751296135E85F30A2B25", hash_generated_method = "E71B4C8821E686B370DCC87E29B57BB8")
    
@Override
    public final short getShort(int index) {
        checkIndex(index, SizeOf.SHORT);
        return this.block.peekShort(offset + index, order);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.569 -0500", hash_original_method = "E1FB1E1D5A4E2DA2FDB3B2E50C938B59", hash_generated_method = "71DE1C093C1D68008F8A5746315E5B99")
    
@Override
    public final boolean isDirect() {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.572 -0500", hash_original_method = "B372104876D32901CA696FF1048C8368", hash_generated_method = "58EFDE0722F81D64BCDB772965B5657B")
    
public final void free() {
        block.free();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.574 -0500", hash_original_method = "6C3FEAC6B139FD6B0B9CDBF24FD25811", hash_generated_method = "588F2E38F1C9BA601A4E0EBA80974C50")
    
@Override protected byte[] protectedArray() {
        byte[] array = this.block.array();
        if (array == null) {
            throw new UnsupportedOperationException();
        }
        return array;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.577 -0500", hash_original_method = "BE42CB64719A7E35581BD2552BC2391A", hash_generated_method = "D2EFA8645FB524016E42E434214AC361")
    
@Override protected int protectedArrayOffset() {
        protectedArray(); // Check we have an array.
        return offset;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.579 -0500", hash_original_method = "F879D2589AC497F37E3C882F528D27BC", hash_generated_method = "182413D1B509DB9300ECF9963F9ED76B")
    
@Override protected boolean protectedHasArray() {
        return protectedArray() != null;
    }
    
    //Droidsafe: We added here to resolve compiler error, not sure when it was changed
    public ByteBuffer put(Object src, int srcOffset, int byteCount) {
        byte[] byteArray = new byte[1];
        if (src instanceof byte[]) {
            byte[] srcArray = (byte[]) src;
            byteArray[0] = (byte)srcArray[0];
        }
        if (src instanceof char[]) {
            char[] srcArray = (char[]) src;
            byteArray[0] = (byte)srcArray[0];
        }
        if (src instanceof short[]) {
            short[] srcArray = (short[]) src;
            byteArray[0] = (byte)srcArray[0];
        }
        if (src instanceof int[]) {
            int[] srcArray = (int[]) src;
            byteArray[0] = (byte)srcArray[0];
        }
        if (src instanceof float[]) {
            float[] srcArray = (float[]) src;
            byteArray[0] = (byte)srcArray[0];
        }
        return put(byteArray, srcOffset, byteCount);
    }
}

