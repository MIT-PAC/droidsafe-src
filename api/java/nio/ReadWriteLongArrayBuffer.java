package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;




final class ReadWriteLongArrayBuffer extends LongArrayBuffer {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.262 -0500", hash_original_method = "4F47DB2B8CB8473CB09876AAA01E381B", hash_generated_method = "4E88693328066D168A03E765A3848554")
    
static ReadWriteLongArrayBuffer copy(LongArrayBuffer other, int markOfOther) {
        ReadWriteLongArrayBuffer buf =
                new ReadWriteLongArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.265 -0500", hash_original_method = "834F92961971218638A9D7B65E865A6A", hash_generated_method = "834F92961971218638A9D7B65E865A6A")
    
ReadWriteLongArrayBuffer(long[] array) {
        super(array);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.268 -0500", hash_original_method = "B372464DEEDD255C23B3D6D2F6AC357B", hash_generated_method = "B372464DEEDD255C23B3D6D2F6AC357B")
    
ReadWriteLongArrayBuffer(int capacity) {
        super(capacity);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.271 -0500", hash_original_method = "D4CFA6531161D5EBB7847D86519768A8", hash_generated_method = "D4CFA6531161D5EBB7847D86519768A8")
    
ReadWriteLongArrayBuffer(int capacity, long[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.273 -0500", hash_original_method = "491DB95BA7040FC98389856362623E65", hash_generated_method = "D7931047D286183A003D17206BD9060F")
    
@Override
    public LongBuffer asReadOnlyBuffer() {
        return ReadOnlyLongArrayBuffer.copy(this, mark);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.276 -0500", hash_original_method = "060222CDD5267DE677B9C3E035FABA38", hash_generated_method = "2C11990051E8D9226C89E75B69FA3CCB")
    
@Override
    public LongBuffer compact() {
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.278 -0500", hash_original_method = "BCAEF14AE65D2F213653B4CB45E8B265", hash_generated_method = "C800A40BEC6C63B069051B527F16F425")
    
@Override
    public LongBuffer duplicate() {
        return copy(this, mark);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.280 -0500", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "71081A201DF7B08144D6AE781E679981")
    
@Override
    public boolean isReadOnly() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.283 -0500", hash_original_method = "7F3F8A80822D5A0A92B191B6CC171534", hash_generated_method = "F084F245B7CEB4D4F51A809F7BCB7754")
    
@Override
    protected long[] protectedArray() {
        return backingArray;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.286 -0500", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "F5674176D88BEBAEFE4F538492719546")
    
@Override
    protected int protectedArrayOffset() {
        return offset;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.288 -0500", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "314D008C862B56E51390FC603128783F")
    
@Override
    protected boolean protectedHasArray() {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.291 -0500", hash_original_method = "425DFBE2ED449316EC67E343889A606E", hash_generated_method = "EBA928E1719B0F0379F3E4045AECE92E")
    
@Override
    public LongBuffer put(long c) {
        if (position == limit) {
            throw new BufferOverflowException();
        }
        backingArray[offset + position++] = c;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.293 -0500", hash_original_method = "1D23D6036C356E1E5C3421A08A3084B8", hash_generated_method = "BEBD2AA05F9F7F8E7434CEB7766C8B45")
    
@Override
    public LongBuffer put(int index, long c) {
        checkIndex(index);
        backingArray[offset + index] = c;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.297 -0500", hash_original_method = "DEBADA2447C09B43BF32BF5E36B4652E", hash_generated_method = "5209A04D7A9F2732F49CFBA318921ADB")
    
@Override
    public LongBuffer put(long[] src, int srcOffset, int longCount) {
        if (longCount > remaining()) {
            throw new BufferOverflowException();
        }
        System.arraycopy(src, srcOffset, backingArray, offset + position, longCount);
        position += longCount;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.299 -0500", hash_original_method = "66DF3FBD18C3DE0FC10F7184B9F43E0E", hash_generated_method = "BD85021627E41E30AACBDBEA737D8635")
    
@Override
    public LongBuffer slice() {
        return new ReadWriteLongArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

