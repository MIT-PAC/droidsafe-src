package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;




final class ReadWriteFloatArrayBuffer extends FloatArrayBuffer {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.844 -0500", hash_original_method = "69207B0DA27229328F09A2CAFC37638C", hash_generated_method = "D405A554BFA398C48477200EDC7E4B66")
    static ReadWriteFloatArrayBuffer copy(FloatArrayBuffer other, int markOfOther) {
        ReadWriteFloatArrayBuffer buf =
                new ReadWriteFloatArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.846 -0500", hash_original_method = "5A8DCC269DCB08038721B4A37F7722F4", hash_generated_method = "5A8DCC269DCB08038721B4A37F7722F4")
    ReadWriteFloatArrayBuffer(float[] array) {
        super(array);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.847 -0500", hash_original_method = "495FFBE47D4B4B6385F4C7F54B916311", hash_generated_method = "495FFBE47D4B4B6385F4C7F54B916311")
    ReadWriteFloatArrayBuffer(int capacity) {
        super(capacity);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.848 -0500", hash_original_method = "2552E9D1905F4AE718E09F5BFBACBECB", hash_generated_method = "2552E9D1905F4AE718E09F5BFBACBECB")
    ReadWriteFloatArrayBuffer(int capacity, float[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.849 -0500", hash_original_method = "497069A519BB7A8E272B0965E0C603B5", hash_generated_method = "87D8314BA46E9B9646C924B1ED48A3AB")
    @Override
public FloatBuffer asReadOnlyBuffer() {
        return ReadOnlyFloatArrayBuffer.copy(this, mark);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.849 -0500", hash_original_method = "22708AB3F2B534798FB2EED23A67DC19", hash_generated_method = "2E7E78C6B96D09ABA11C9CBD0BA5E411")
    @Override
public FloatBuffer compact() {
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.850 -0500", hash_original_method = "3E38DEB88805A3AD5A9BAFA46381EB46", hash_generated_method = "0110369AFCDD0624F359E2091231917C")
    @Override
public FloatBuffer duplicate() {
        return copy(this, mark);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.851 -0500", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "71081A201DF7B08144D6AE781E679981")
    @Override
public boolean isReadOnly() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.852 -0500", hash_original_method = "902CC876A0B5CBA68FC4A86CDFA0BAEB", hash_generated_method = "91A224C42EA7753B4A8A4729BA2A1A85")
    @Override
protected float[] protectedArray() {
        return backingArray;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.853 -0500", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "F5674176D88BEBAEFE4F538492719546")
    @Override
protected int protectedArrayOffset() {
        return offset;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.854 -0500", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "314D008C862B56E51390FC603128783F")
    @Override
protected boolean protectedHasArray() {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.855 -0500", hash_original_method = "13B22E8941626D16AD9A1C582F86CDB9", hash_generated_method = "0D30CB8829139B63442C0038B5547CCE")
    @Override
public FloatBuffer put(float c) {
        if (position == limit) {
            throw new BufferOverflowException();
        }
        backingArray[offset + position++] = c;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.856 -0500", hash_original_method = "DA3D1DBD794212B37FED89EC3B7543A3", hash_generated_method = "842CDCCE0BEF338F797A779ED9151667")
    @Override
public FloatBuffer put(int index, float c) {
        checkIndex(index);
        backingArray[offset + index] = c;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.857 -0500", hash_original_method = "596A2808C1B03A79358C8C3443A19501", hash_generated_method = "3293E4F011E2C03A2F2F3CF9DDB88622")
    @Override
public FloatBuffer put(float[] src, int srcOffset, int floatCount) {
        if (floatCount > remaining()) {
            throw new BufferOverflowException();
        }
        System.arraycopy(src, srcOffset, backingArray, offset + position, floatCount);
        position += floatCount;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.858 -0500", hash_original_method = "B98DF5C640FB2DE362AEC4E72A11F767", hash_generated_method = "36FA6877A82CEE5F4BCE352E379E6E4C")
    @Override
public FloatBuffer slice() {
        return new ReadWriteFloatArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

