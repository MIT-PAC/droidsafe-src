package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

abstract class CharArrayBuffer extends CharBuffer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.720 -0500", hash_original_field = "831C21935489E2C2946A16D310875EF0", hash_generated_field = "0CB5FB822B200EFB3152ED27D6D936CC")

    protected  char[] backingArray;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.723 -0500", hash_original_field = "B7E810BF01B52122CB927525A0CA4721", hash_generated_field = "22BBBB3BDBDCD622FED3EBF1A70B4EC5")

    protected  int offset;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.725 -0500", hash_original_method = "A72F78A13989965B326E51B9BE40A191", hash_generated_method = "A72F78A13989965B326E51B9BE40A191")
    
CharArrayBuffer(char[] array) {
        this(array.length, array, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.727 -0500", hash_original_method = "1D86BFBD657FBEBE6746E0A26E3B60D6", hash_generated_method = "1D86BFBD657FBEBE6746E0A26E3B60D6")
    
CharArrayBuffer(int capacity) {
        this(capacity, new char[capacity], 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.730 -0500", hash_original_method = "C3B2650154B809A9DCA4173590E7D6FB", hash_generated_method = "C3B2650154B809A9DCA4173590E7D6FB")
    
CharArrayBuffer(int capacity, char[] backingArray, int offset) {
        super(capacity);
        this.backingArray = backingArray;
        this.offset = offset;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.733 -0500", hash_original_method = "930271761AD6BA9DD8139CF2E7572A4C", hash_generated_method = "AB16C65E6A6A21196EF3A9432E5259E0")
    
@Override
    public final char get() {
        if (position == limit) {
            throw new BufferUnderflowException();
        }
        return backingArray[offset + position++];
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.736 -0500", hash_original_method = "5DC544428BD1C6845537E5987EE9535C", hash_generated_method = "36732CDF494CD519857B498DCB00F396")
    
@Override
    public final char get(int index) {
        checkIndex(index);
        return backingArray[offset + index];
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.738 -0500", hash_original_method = "7C08804A3C6FF079C168DF2ED7D4D9F5", hash_generated_method = "0483CD7F7555664F27D79641D4D0064C")
    
@Override
    public final CharBuffer get(char[] dst, int srcOffset, int charCount) {
        if (charCount > remaining()) {
            throw new BufferUnderflowException();
        }
        System.arraycopy(backingArray, offset + position, dst, srcOffset, charCount);
        position += charCount;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.741 -0500", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "1EC9A508074FE2792E86546C8EBA9E2B")
    
@Override
    public final boolean isDirect() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.744 -0500", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "FF53E3A2EB4F54AB08FAE8FA7C0C29DD")
    
@Override
    public final ByteOrder order() {
        return ByteOrder.nativeOrder();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.746 -0500", hash_original_method = "4B1929E0A98D3F3896D7290A74598BEB", hash_generated_method = "5892B368D51E60F64B12571ED04F0CAF")
    
@Override
    public final CharSequence subSequence(int start, int end) {
        checkStartEndRemaining(start, end);
        CharBuffer result = duplicate();
        result.limit(position + end);
        result.position(position + start);
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.749 -0500", hash_original_method = "955B04A37714208757E4A9A84A4E89C7", hash_generated_method = "6227D3F98397C965DB912CBD6A64C0F1")
    
@Override
    public final String toString() {
        return String.copyValueOf(backingArray, offset + position, remaining());
    }
    
}

