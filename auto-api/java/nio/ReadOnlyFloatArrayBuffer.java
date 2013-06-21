package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadOnlyFloatArrayBuffer extends FloatArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.883 -0400", hash_original_method = "E7687DEEE2349AEC9B3D116E5F0447AE", hash_generated_method = "C49127360501E3606D7ACFCE14A774EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ReadOnlyFloatArrayBuffer(int capacity, float[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        dsTaint.addTaint(backingArray[0]);
        dsTaint.addTaint(arrayOffset);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
        static ReadOnlyFloatArrayBuffer copy(FloatArrayBuffer other, int markOfOther) {
        ReadOnlyFloatArrayBuffer buf =
                new ReadOnlyFloatArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.884 -0400", hash_original_method = "950AD5330FDA6C397B84663FB836B7AC", hash_generated_method = "028F684C9CC8454B6B9CD36F8F8B49DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public FloatBuffer asReadOnlyBuffer() {
        FloatBuffer var92CA36B72AD8E4E9D1F46737F34CE751_743637557 = (duplicate());
        return (FloatBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return duplicate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.884 -0400", hash_original_method = "3651F4075426ACE9E47115ABCBF7340C", hash_generated_method = "6C56F1D61FE3CFD289E55BCB507466ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public FloatBuffer compact() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (FloatBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.884 -0400", hash_original_method = "3E38DEB88805A3AD5A9BAFA46381EB46", hash_generated_method = "B20277EFA0CB586DB793595A4B925156")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public FloatBuffer duplicate() {
        FloatBuffer var8C82ED9E4FDE12C9486E1252174918B6_2056491437 = (copy(this, mark));
        return (FloatBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.884 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "1F37B5B4451C181C67CEF1957DF5BE74")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isReadOnly() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.884 -0400", hash_original_method = "C411BFEF69C342422C56A1A8A49A766C", hash_generated_method = "507FD3D18D3BA145CBBE19E02088F5A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected float[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        float[] retVal = new float[1];
        retVal[0] = dsTaint.getTaintFloat();
        return retVal;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.885 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "E33577BEEC5DADCAF68823E6F78877A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.885 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "ABBE1C4E781471842A6D95D790DBFBEE")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean protectedHasArray() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.885 -0400", hash_original_method = "4648A9FB9F6674DFF187FD22874B4264", hash_generated_method = "35EA918A6512C1914C1A512AEAB0DEAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public FloatBuffer put(float c) {
        dsTaint.addTaint(c);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (FloatBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.885 -0400", hash_original_method = "2F3AA3FAE455D6D3597D42F3669BC144", hash_generated_method = "8DDC340AF13707B07CC0FE01E2143EF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public FloatBuffer put(int index, float c) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(c);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (FloatBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.885 -0400", hash_original_method = "4593D163A029E48A7BF09387C27B8D4B", hash_generated_method = "72C573E6DB099DEEADF36306FCC68899")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public FloatBuffer put(FloatBuffer buf) {
        dsTaint.addTaint(buf.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (FloatBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.885 -0400", hash_original_method = "B855D58A55D1A37F7BFB3C60ACA0157A", hash_generated_method = "8588C37D8298F80CFB05C4EA22882491")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final FloatBuffer put(float[] src, int srcOffset, int byteCount) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (FloatBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.886 -0400", hash_original_method = "CBF8325EDBAF150278EE67A0E06067DF", hash_generated_method = "464E7A64E85B439C43F78D0E6DED326A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public FloatBuffer slice() {
        FloatBuffer var8DFB1DDDBD4CF8EF687ED8BF4094A4F7_1850767083 = (new ReadOnlyFloatArrayBuffer(remaining(), backingArray, offset + position));
        return (FloatBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ReadOnlyFloatArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

