package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadOnlyCharArrayBuffer extends CharArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.867 -0400", hash_original_method = "45CC985A35F0F1494520573D6ACE292A", hash_generated_method = "082BBEDDFFF78245BCAF1B2E29B37BC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ReadOnlyCharArrayBuffer(int capacity, char[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        dsTaint.addTaint(backingArray[0]);
        dsTaint.addTaint(arrayOffset);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
        static ReadOnlyCharArrayBuffer copy(CharArrayBuffer other, int markOfOther) {
        ReadOnlyCharArrayBuffer buf =
                new ReadOnlyCharArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.867 -0400", hash_original_method = "6272265C933D4E168CAF2033C47ED968", hash_generated_method = "0D96BFA7643F6763CFA7DEBD3D1B9C81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharBuffer asReadOnlyBuffer() {
        CharBuffer var92CA36B72AD8E4E9D1F46737F34CE751_188960463 = (duplicate());
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return duplicate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.867 -0400", hash_original_method = "B36182A594E1794791B93E3BECF5B149", hash_generated_method = "6475C24754098F78DC94F2B3FFD444C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharBuffer compact() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.868 -0400", hash_original_method = "CC31CA0A52E7075216F6C304954E7B50", hash_generated_method = "4E625FCB992F225D20EA1E3253198552")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharBuffer duplicate() {
        CharBuffer var8C82ED9E4FDE12C9486E1252174918B6_2102925289 = (copy(this, mark));
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.868 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "1F37B5B4451C181C67CEF1957DF5BE74")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isReadOnly() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.868 -0400", hash_original_method = "0F9E5668E984B4901FBF78711C9DAE7C", hash_generated_method = "301FF39F164E6A3A078E45B587649A41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected char[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.868 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "E33577BEEC5DADCAF68823E6F78877A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.868 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "ABBE1C4E781471842A6D95D790DBFBEE")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean protectedHasArray() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.868 -0400", hash_original_method = "AA890865E828C97A020097D7CDA5EE73", hash_generated_method = "C2B14B0F3712C764313649EA2AB3614F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharBuffer put(char c) {
        dsTaint.addTaint(c);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.868 -0400", hash_original_method = "4BB5828CEE96E76B6DAC9C0855ABDDFD", hash_generated_method = "A802840441A2EEF83BFFAD3B83041131")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharBuffer put(int index, char c) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(c);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.868 -0400", hash_original_method = "456A915B3249AF3B6DBAB08ACEE5755D", hash_generated_method = "01904E93363197DD8B5ED66C2B8F8979")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final CharBuffer put(char[] src, int srcOffset, int charCount) {
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        dsTaint.addTaint(charCount);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.869 -0400", hash_original_method = "FB6FEA0A32E7A03D5D90CE6B495DAC9B", hash_generated_method = "C59CE05E8C9C061A98D5865C6080E9AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final CharBuffer put(CharBuffer src) {
        dsTaint.addTaint(src.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.869 -0400", hash_original_method = "4A99CE8F005D81D8D8D69EFF935B4E86", hash_generated_method = "AF13B7FF22AD982E9DE2112A316F7A24")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharBuffer put(String src, int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(src);
        dsTaint.addTaint(end);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.869 -0400", hash_original_method = "B45CBDD156981DE98E6537855A7A214E", hash_generated_method = "516DC1148BE649937395D0C66D8850F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharBuffer slice() {
        CharBuffer var27E22D9639A0B9F323D0C45D9568A677_117257137 = (new ReadOnlyCharArrayBuffer(remaining(), backingArray, offset + position));
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ReadOnlyCharArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

