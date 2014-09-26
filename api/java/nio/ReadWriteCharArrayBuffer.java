package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

final class ReadWriteCharArrayBuffer extends CharArrayBuffer {

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.334 -0500", hash_original_method = "DC122679E39D379674ECB7170941B521", hash_generated_method = "50E047E3BCE9CF21492181B4605C7215")
    
static ReadWriteCharArrayBuffer copy(CharArrayBuffer other, int markOfOther) {
        ReadWriteCharArrayBuffer buf =
                new ReadWriteCharArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.337 -0500", hash_original_method = "0630B531F09F4BDCAC95566C749465B0", hash_generated_method = "0630B531F09F4BDCAC95566C749465B0")
    
ReadWriteCharArrayBuffer(char[] array) {
        super(array);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.339 -0500", hash_original_method = "818D04612A5488A8EF47518DF8152754", hash_generated_method = "818D04612A5488A8EF47518DF8152754")
    
ReadWriteCharArrayBuffer(int capacity) {
        super(capacity);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.342 -0500", hash_original_method = "44E079FDDD8CFD80B0248AA4E3DA3A3F", hash_generated_method = "44E079FDDD8CFD80B0248AA4E3DA3A3F")
    
ReadWriteCharArrayBuffer(int capacity, char[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.344 -0500", hash_original_method = "ACF2009427E3EF6DAD4B7F3E78A7296D", hash_generated_method = "50FF842C4395F29B45C5868F3D11A154")
    
@Override
    public CharBuffer asReadOnlyBuffer() {
        return ReadOnlyCharArrayBuffer.copy(this, mark);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.347 -0500", hash_original_method = "2217DC8E6F603B0A8DFB635A1BB06CA2", hash_generated_method = "A384CF902E4B326ED56400E801949F58")
    
@Override
    public CharBuffer compact() {
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.350 -0500", hash_original_method = "CC31CA0A52E7075216F6C304954E7B50", hash_generated_method = "1D23E659FD61AA77B2D3D7F85F6A84C8")
    
@Override
    public CharBuffer duplicate() {
        return copy(this, mark);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.352 -0500", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "71081A201DF7B08144D6AE781E679981")
    
@Override
    public boolean isReadOnly() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.355 -0500", hash_original_method = "6989B404B9CBE6C8C0C27A3F3280C746", hash_generated_method = "F1A0F5E6E5B279632A60CB1934460D8E")
    
@Override
    protected char[] protectedArray() {
        return backingArray;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.357 -0500", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "F5674176D88BEBAEFE4F538492719546")
    
@Override
    protected int protectedArrayOffset() {
        return offset;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.360 -0500", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "314D008C862B56E51390FC603128783F")
    
@Override
    protected boolean protectedHasArray() {
        return true;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.363 -0500", hash_original_method = "BCF668C88F0582882A83FAE19696C98E", hash_generated_method = "7841DFE415A6552F6BA4458198795D74")
    
@Override
    public CharBuffer put(char c) {
        if (position == limit) {
            throw new BufferOverflowException();
        }
        backingArray[offset + position++] = c;
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.366 -0500", hash_original_method = "F160357793F9CF9C4361A956C61F810C", hash_generated_method = "D4B29BD55D7A81312740471590A7A500")
    
@Override
    public CharBuffer put(int index, char c) {
        checkIndex(index);
        backingArray[offset + index] = c;
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.368 -0500", hash_original_method = "F185C844C40257FD948EFFAB7DA8DE68", hash_generated_method = "2ACAF97679BA1AC3D367345879FBD016")
    
@Override
    public CharBuffer put(char[] src, int srcOffset, int charCount) {
        if (charCount > remaining()) {
            throw new BufferOverflowException();
        }
        System.arraycopy(src, srcOffset, backingArray, offset + position, charCount);
        position += charCount;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.372 -0500", hash_original_method = "B445BD4E0B93C5941BD1A67927E72611", hash_generated_method = "8194CB55C3032F954D3BB74C2901656B")
    
@Override
    public CharBuffer slice() {
        return new ReadWriteCharArrayBuffer(remaining(), backingArray, offset + position);
    }
    
}

