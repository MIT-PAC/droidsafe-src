package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;




final class ReadOnlyShortArrayBuffer extends ShortArrayBuffer {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.038 -0500", hash_original_method = "03D8D114610C5C7BBB7B2EABDE9E86BE", hash_generated_method = "8256C40C7AB8D0660C4B957D37528128")
    
static ReadOnlyShortArrayBuffer copy(ShortArrayBuffer other, int markOfOther) {
        ReadOnlyShortArrayBuffer buf =
                new ReadOnlyShortArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.041 -0500", hash_original_method = "DA0F6B028B84C196FFD1459A256816D4", hash_generated_method = "DA0F6B028B84C196FFD1459A256816D4")
    
ReadOnlyShortArrayBuffer(int capacity, short[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.043 -0500", hash_original_method = "293D70534F08F1337102FFA8FF94EA93", hash_generated_method = "C6B8A9648C018DAB8933F97CABA66877")
    
@Override
    public ShortBuffer asReadOnlyBuffer() {
        return duplicate();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.045 -0500", hash_original_method = "1358DD6DB518D15E9F2A390375DC21ED", hash_generated_method = "EDFC381D343DB40DBE0BC50CE694F89F")
    
@Override
    public ShortBuffer compact() {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.048 -0500", hash_original_method = "F49238B32F318D341B9FD2839B701A87", hash_generated_method = "DA11699F4331CF771EFF0F49C605960A")
    
@Override
    public ShortBuffer duplicate() {
        return copy(this, mark);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.051 -0500", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "E930BFBB15BF0F3A3E2A714B41BC0488")
    
@Override
    public boolean isReadOnly() {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.053 -0500", hash_original_method = "AFBE97926DC7C5B917D9DD29C0718A4F", hash_generated_method = "EF3164D26F5290CBE7F7A239175D1ECE")
    
@Override
    protected short[] protectedArray() {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.055 -0500", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "74EBBCBD37A62C7AD6A8876E571480EF")
    
@Override
    protected int protectedArrayOffset() {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.058 -0500", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "4DE1ADBFC1C0BCD2FC8429D8307DD9AC")
    
@Override
    protected boolean protectedHasArray() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.061 -0500", hash_original_method = "5592BDB3AAC352212C254B47F1811E27", hash_generated_method = "9D3E23350247DD8A243D69FFB490D11D")
    
@Override
    public ShortBuffer put(ShortBuffer buf) {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.063 -0500", hash_original_method = "499D2BB8AE90111A3249031C62268D84", hash_generated_method = "AD37212FA6B4C09A0BA62B574A38FEE9")
    
@Override
    public ShortBuffer put(short c) {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.066 -0500", hash_original_method = "617A2BE3714A70A7C820CD4B75072087", hash_generated_method = "CE5DAD3E894FDBA46D81D1E25A32A045")
    
@Override
    public ShortBuffer put(int index, short c) {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.068 -0500", hash_original_method = "1E52CD3CC46ECF6ADC15EFA5E594FA46", hash_generated_method = "C1BAF41A8CDD4CD548167EFA2B8555DF")
    
@Override
    public final ShortBuffer put(short[] src, int srcOffset, int shortCount) {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.071 -0500", hash_original_method = "1014849B0415FF72B64D3271FAB61336", hash_generated_method = "0EABCE3CAB88D349B88EB4961B0FBEC5")
    
@Override
    public ShortBuffer slice() {
        return new ReadOnlyShortArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

