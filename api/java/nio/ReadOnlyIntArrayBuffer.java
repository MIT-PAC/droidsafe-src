package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;




final class ReadOnlyIntArrayBuffer extends IntArrayBuffer {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.987 -0500", hash_original_method = "F37F94B8B4B6C4E82BA18B981375BACA", hash_generated_method = "4B51AE8695235A862EA81A49325E7D2C")
    
static ReadOnlyIntArrayBuffer copy(IntArrayBuffer other, int markOfOther) {
        ReadOnlyIntArrayBuffer buf =
                new ReadOnlyIntArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.990 -0500", hash_original_method = "01590DEAE9E3D05BD420F8A41610BAB0", hash_generated_method = "01590DEAE9E3D05BD420F8A41610BAB0")
    
ReadOnlyIntArrayBuffer(int capacity, int[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.993 -0500", hash_original_method = "6813C80E6F33BB643F69D9471CD54ED3", hash_generated_method = "CC2F032B5F2F1818B4AC956DE6ACAE1D")
    
@Override
    public IntBuffer asReadOnlyBuffer() {
        return duplicate();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.995 -0500", hash_original_method = "95709EC066A435B9AA3687E160003D5F", hash_generated_method = "622BF3C6CFA1C84EC411E10C2C26C433")
    
@Override
    public IntBuffer compact() {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.998 -0500", hash_original_method = "E687D66866CD72B4F21034D8F21E9369", hash_generated_method = "1E7DC474F320749966A19EE776FB4E91")
    
@Override
    public IntBuffer duplicate() {
        return copy(this, mark);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.000 -0500", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "E930BFBB15BF0F3A3E2A714B41BC0488")
    
@Override
    public boolean isReadOnly() {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.003 -0500", hash_original_method = "0A06910467E88EE62CDFBCBE0CB802DA", hash_generated_method = "93980BAFEDED9DBE2729E9961E45EA13")
    
@Override
    protected int[] protectedArray() {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.006 -0500", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "74EBBCBD37A62C7AD6A8876E571480EF")
    
@Override
    protected int protectedArrayOffset() {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.008 -0500", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "4DE1ADBFC1C0BCD2FC8429D8307DD9AC")
    
@Override
    protected boolean protectedHasArray() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.011 -0500", hash_original_method = "09ED0F57CBC06365DA988C0313F02515", hash_generated_method = "B4746CF7E792A297DAE144F13C3C2526")
    
@Override
    public IntBuffer put(int c) {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.014 -0500", hash_original_method = "72974DF4DE68C45A0CAEDB3056BAFC34", hash_generated_method = "2F89B02834C24E0F48ADEC08B8CAE08C")
    
@Override
    public IntBuffer put(int index, int c) {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.017 -0500", hash_original_method = "0AE015769B07B9A1C6447FCD87483B4D", hash_generated_method = "E7BC4C66E639B4A8078A7A166DEA332A")
    
@Override
    public IntBuffer put(IntBuffer buf) {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.020 -0500", hash_original_method = "4CDCCEB43894118BDB0755D2BC3EFD49", hash_generated_method = "300961B17441D0FF38927BEE9CCA3AFC")
    
@Override
    public final IntBuffer put(int[] src, int srcOffset, int intCount) {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.022 -0500", hash_original_method = "7D836F4D3C901F2E02BB73C6A2A966F7", hash_generated_method = "E12DCB8F4960802F416FEC4D3F5F8BF3")
    
@Override
    public IntBuffer slice() {
        return new ReadOnlyIntArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

