package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadOnlyIntArrayBuffer extends IntArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.893 -0400", hash_original_method = "01590DEAE9E3D05BD420F8A41610BAB0", hash_generated_method = "1E782D4FB23A760DD806DBD5E60BABD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ReadOnlyIntArrayBuffer(int capacity, int[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        dsTaint.addTaint(backingArray[0]);
        dsTaint.addTaint(arrayOffset);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
        static ReadOnlyIntArrayBuffer copy(IntArrayBuffer other, int markOfOther) {
        ReadOnlyIntArrayBuffer buf =
                new ReadOnlyIntArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.893 -0400", hash_original_method = "6813C80E6F33BB643F69D9471CD54ED3", hash_generated_method = "5F0AAC3CD934F8CB24E273C175CCEC2A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public IntBuffer asReadOnlyBuffer() {
        IntBuffer var92CA36B72AD8E4E9D1F46737F34CE751_2027634767 = (duplicate());
        return (IntBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return duplicate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.893 -0400", hash_original_method = "95709EC066A435B9AA3687E160003D5F", hash_generated_method = "F6EC9ED4AA8E0D0496E17167BC0036A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public IntBuffer compact() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (IntBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.893 -0400", hash_original_method = "E687D66866CD72B4F21034D8F21E9369", hash_generated_method = "5C8596E14802BF0DFACD57D9418E6005")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public IntBuffer duplicate() {
        IntBuffer var8C82ED9E4FDE12C9486E1252174918B6_452743226 = (copy(this, mark));
        return (IntBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.893 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "1F37B5B4451C181C67CEF1957DF5BE74")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isReadOnly() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.894 -0400", hash_original_method = "0A06910467E88EE62CDFBCBE0CB802DA", hash_generated_method = "89BFF149DDD0433AC9EC8885ECFBD82D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        int[] retVal = new int[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.894 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "E33577BEEC5DADCAF68823E6F78877A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.894 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "ABBE1C4E781471842A6D95D790DBFBEE")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean protectedHasArray() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.894 -0400", hash_original_method = "09ED0F57CBC06365DA988C0313F02515", hash_generated_method = "192EC228FAE08E11909C61424F91108C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public IntBuffer put(int c) {
        dsTaint.addTaint(c);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (IntBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.894 -0400", hash_original_method = "72974DF4DE68C45A0CAEDB3056BAFC34", hash_generated_method = "6F161217DFA1A8AADDA5FD5DB6BDB93C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public IntBuffer put(int index, int c) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(c);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (IntBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.894 -0400", hash_original_method = "0AE015769B07B9A1C6447FCD87483B4D", hash_generated_method = "06453D26761A43BFB32C600E945ED950")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public IntBuffer put(IntBuffer buf) {
        dsTaint.addTaint(buf.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (IntBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.894 -0400", hash_original_method = "4CDCCEB43894118BDB0755D2BC3EFD49", hash_generated_method = "80F1EC54655FAF65272CADF1653262F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final IntBuffer put(int[] src, int srcOffset, int intCount) {
        dsTaint.addTaint(intCount);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (IntBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.895 -0400", hash_original_method = "7D836F4D3C901F2E02BB73C6A2A966F7", hash_generated_method = "6AF9CFF7F6F1AF0FDBF99356C86BD00B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public IntBuffer slice() {
        IntBuffer varF0FDF8953567C90C49F00B0BD99CDEE3_1298401471 = (new ReadOnlyIntArrayBuffer(remaining(), backingArray, offset + position));
        return (IntBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ReadOnlyIntArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

