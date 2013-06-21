package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadOnlyShortArrayBuffer extends ShortArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.900 -0400", hash_original_method = "DA0F6B028B84C196FFD1459A256816D4", hash_generated_method = "FFB22E4788D46F336E8476148C6D7DEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ReadOnlyShortArrayBuffer(int capacity, short[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        dsTaint.addTaint(backingArray[0]);
        dsTaint.addTaint(arrayOffset);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
        static ReadOnlyShortArrayBuffer copy(ShortArrayBuffer other, int markOfOther) {
        ReadOnlyShortArrayBuffer buf =
                new ReadOnlyShortArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.901 -0400", hash_original_method = "293D70534F08F1337102FFA8FF94EA93", hash_generated_method = "DA8F97333954D2BD44E9B4E572BB8F30")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ShortBuffer asReadOnlyBuffer() {
        ShortBuffer var92CA36B72AD8E4E9D1F46737F34CE751_1333450916 = (duplicate());
        return (ShortBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return duplicate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.901 -0400", hash_original_method = "1358DD6DB518D15E9F2A390375DC21ED", hash_generated_method = "DD0181DE27B71706B856EC64206F6C65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ShortBuffer compact() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (ShortBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.901 -0400", hash_original_method = "F49238B32F318D341B9FD2839B701A87", hash_generated_method = "D2F567DFF181097C2F9AB9292E83221C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ShortBuffer duplicate() {
        ShortBuffer var8C82ED9E4FDE12C9486E1252174918B6_1347470864 = (copy(this, mark));
        return (ShortBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.901 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "1F37B5B4451C181C67CEF1957DF5BE74")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isReadOnly() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.901 -0400", hash_original_method = "AFBE97926DC7C5B917D9DD29C0718A4F", hash_generated_method = "B788954C81C3EAB2CACAA97CD4562727")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected short[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        short[] retVal = new short[1];
        retVal[0] = (short)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.901 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "E33577BEEC5DADCAF68823E6F78877A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.901 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "ABBE1C4E781471842A6D95D790DBFBEE")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean protectedHasArray() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.901 -0400", hash_original_method = "5592BDB3AAC352212C254B47F1811E27", hash_generated_method = "065460D46301B068005B1199BF6A00EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ShortBuffer put(ShortBuffer buf) {
        dsTaint.addTaint(buf.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (ShortBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.902 -0400", hash_original_method = "499D2BB8AE90111A3249031C62268D84", hash_generated_method = "0DC73F57EA8E29B8796F6336E497D260")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ShortBuffer put(short c) {
        dsTaint.addTaint(c);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (ShortBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.902 -0400", hash_original_method = "617A2BE3714A70A7C820CD4B75072087", hash_generated_method = "28A5BB055EEF4F3C225604649A0AA9B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ShortBuffer put(int index, short c) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(c);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (ShortBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.902 -0400", hash_original_method = "1E52CD3CC46ECF6ADC15EFA5E594FA46", hash_generated_method = "86637F3ECFD523B7C1E83F5FDA1F7F28")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final ShortBuffer put(short[] src, int srcOffset, int shortCount) {
        dsTaint.addTaint(shortCount);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (ShortBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.902 -0400", hash_original_method = "1014849B0415FF72B64D3271FAB61336", hash_generated_method = "E41A408EAC0AACD7CC212D2968634C6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ShortBuffer slice() {
        ShortBuffer var5FF260310AC30219BB7A404186354A5D_965427785 = (new ReadOnlyShortArrayBuffer(remaining(), backingArray, offset + position));
        return (ShortBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ReadOnlyShortArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

