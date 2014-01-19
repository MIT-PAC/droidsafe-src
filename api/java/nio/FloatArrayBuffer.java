package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

abstract class FloatArrayBuffer extends FloatBuffer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.575 -0500", hash_original_field = "67EDE1E2A7FE11E96B68099B2642708D", hash_generated_field = "8679C1DDE03C0998C5B4254D7B007554")

    protected  float[] backingArray;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.577 -0500", hash_original_field = "B7E810BF01B52122CB927525A0CA4721", hash_generated_field = "22BBBB3BDBDCD622FED3EBF1A70B4EC5")

    protected  int offset;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.580 -0500", hash_original_method = "D11EDAC27157134F6D93222FED96804A", hash_generated_method = "D11EDAC27157134F6D93222FED96804A")
    
FloatArrayBuffer(float[] array) {
        this(array.length, array, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.582 -0500", hash_original_method = "1F51B561748313656A83CE5668F8D726", hash_generated_method = "1F51B561748313656A83CE5668F8D726")
    
FloatArrayBuffer(int capacity) {
        this(capacity, new float[capacity], 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.585 -0500", hash_original_method = "08256304DC715C68C786DDFF589B597E", hash_generated_method = "08256304DC715C68C786DDFF589B597E")
    
FloatArrayBuffer(int capacity, float[] backingArray, int offset) {
        super(capacity);
        this.backingArray = backingArray;
        this.offset = offset;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.588 -0500", hash_original_method = "27C2E9E0DC08E8F6369DBB2405A9C20A", hash_generated_method = "181A66CCB98469B492AE11B3D0C540A9")
    
@Override
    public final float get() {
        if (position == limit) {
            throw new BufferUnderflowException();
        }
        return backingArray[offset + position++];
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.590 -0500", hash_original_method = "7B23CE1A9B110702665631EFEB3A42BD", hash_generated_method = "1BB0C085EF3424014FE54FCBB67A6985")
    
@Override
    public final float get(int index) {
        checkIndex(index);
        return backingArray[offset + index];
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.593 -0500", hash_original_method = "0E5CD729EA86ED4C8F1722765DDD0E33", hash_generated_method = "113C4A0C69CBDDB9ADAFCA46CB755894")
    
@Override
    public final FloatBuffer get(float[] dst, int dstOffset, int floatCount) {
        if (floatCount > remaining()) {
            throw new BufferUnderflowException();
        }
        System.arraycopy(backingArray, offset + position, dst, dstOffset, floatCount);
        position += floatCount;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.595 -0500", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "1EC9A508074FE2792E86546C8EBA9E2B")
    
@Override
    public final boolean isDirect() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.597 -0500", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "FF53E3A2EB4F54AB08FAE8FA7C0C29DD")
    
@Override
    public final ByteOrder order() {
        return ByteOrder.nativeOrder();
    }
    
}

