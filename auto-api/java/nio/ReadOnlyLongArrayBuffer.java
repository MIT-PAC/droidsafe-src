package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadOnlyLongArrayBuffer extends LongArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.896 -0400", hash_original_method = "C217C684C5DFBD85DAC953DA8CC4F355", hash_generated_method = "87079D75CE67AA16B50D2C9AE54E2B45")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ReadOnlyLongArrayBuffer(int capacity, long[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        dsTaint.addTaint(backingArray[0]);
        dsTaint.addTaint(arrayOffset);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
        static ReadOnlyLongArrayBuffer copy(LongArrayBuffer other, int markOfOther) {
        ReadOnlyLongArrayBuffer buf =
                new ReadOnlyLongArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.897 -0400", hash_original_method = "9283ADC80310F7E479295F96D960F17D", hash_generated_method = "ED078C49CDA370771DAF2A53FCD7770C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public LongBuffer asReadOnlyBuffer() {
        LongBuffer var92CA36B72AD8E4E9D1F46737F34CE751_143681091 = (duplicate());
        return (LongBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return duplicate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.897 -0400", hash_original_method = "0AF2CD05C541DF81A768714F9C7047F3", hash_generated_method = "88D588C3B99AC6B91E035596EE99BA4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public LongBuffer compact() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (LongBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.897 -0400", hash_original_method = "BCAEF14AE65D2F213653B4CB45E8B265", hash_generated_method = "1A6EE0C7DD5808A8703BDC713EA2CC97")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public LongBuffer duplicate() {
        LongBuffer var8C82ED9E4FDE12C9486E1252174918B6_238332946 = (copy(this, mark));
        return (LongBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.897 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "1F37B5B4451C181C67CEF1957DF5BE74")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isReadOnly() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.897 -0400", hash_original_method = "4182362C5B9492F840FDEB2D9E41E07C", hash_generated_method = "3C530C084B4226F2E0F989771CDAC574")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected long[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        long[] retVal = new long[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.898 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "E33577BEEC5DADCAF68823E6F78877A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.898 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "ABBE1C4E781471842A6D95D790DBFBEE")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean protectedHasArray() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.898 -0400", hash_original_method = "7393DFCF52569FCC2605F08F020574B2", hash_generated_method = "10D501790A0D20CF5DC6AF98267198DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public LongBuffer put(long c) {
        dsTaint.addTaint(c);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (LongBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.898 -0400", hash_original_method = "E5FA3278A640CB37396E7D9BDEEA6C53", hash_generated_method = "6E1BDD5BC314E3A42640F0D3D3757F89")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public LongBuffer put(int index, long c) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(c);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (LongBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.898 -0400", hash_original_method = "30B5D6EAC290C108C17070B0EA497381", hash_generated_method = "19CBA1AA799D6ABBB3AD103710972396")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public LongBuffer put(LongBuffer buf) {
        dsTaint.addTaint(buf.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (LongBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.898 -0400", hash_original_method = "216FEF8EB820A47DE670615020EB98B3", hash_generated_method = "190D6A0DED287A3D763344CA25062588")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final LongBuffer put(long[] src, int srcOffset, int longCount) {
        dsTaint.addTaint(longCount);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (LongBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.898 -0400", hash_original_method = "B55D734F8AFBBB86296CAB7433B17B3B", hash_generated_method = "67AD66541FAD2FCD50D60B2189AC54E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public LongBuffer slice() {
        LongBuffer varE0F9D3D080470D13EDB47610405A0CB6_1828283577 = (new ReadOnlyLongArrayBuffer(remaining(), backingArray, offset + position));
        return (LongBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ReadOnlyLongArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

