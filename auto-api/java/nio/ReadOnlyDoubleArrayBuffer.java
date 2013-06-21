package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadOnlyDoubleArrayBuffer extends DoubleArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.878 -0400", hash_original_method = "3FFC117F0906E795E350A76B08676C14", hash_generated_method = "3412319D932B291ECCBA1BCE82175BA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ReadOnlyDoubleArrayBuffer(int capacity, double[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        dsTaint.addTaint(backingArray[0]);
        dsTaint.addTaint(arrayOffset);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
        static ReadOnlyDoubleArrayBuffer copy(DoubleArrayBuffer other, int markOfOther) {
        ReadOnlyDoubleArrayBuffer buf =
                new ReadOnlyDoubleArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.880 -0400", hash_original_method = "D0795F45904A3274E0D7958444D9D8FF", hash_generated_method = "27AC03A114C6C9A81D61E785C7440D97")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public DoubleBuffer asReadOnlyBuffer() {
        DoubleBuffer var92CA36B72AD8E4E9D1F46737F34CE751_557560026 = (duplicate());
        return (DoubleBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return duplicate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.880 -0400", hash_original_method = "CD5EB2CF4409DC8F2ECB88FE902C9443", hash_generated_method = "69681C85ED241E8313BFDE0B4F392703")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public DoubleBuffer compact() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (DoubleBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.880 -0400", hash_original_method = "BCF332FB26078E1D870C2E24915718AE", hash_generated_method = "7BB8DA3E933FE2FADD5841DA206D7498")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public DoubleBuffer duplicate() {
        DoubleBuffer var8C82ED9E4FDE12C9486E1252174918B6_1034692746 = (copy(this, mark));
        return (DoubleBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.880 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "1F37B5B4451C181C67CEF1957DF5BE74")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isReadOnly() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.880 -0400", hash_original_method = "76BCA3BE19863C28A8D1735E632EB441", hash_generated_method = "5E2483883EAF5AABDBC835DC423AFC75")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected double[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        double[] retVal = new double[1];
        retVal[0] = dsTaint.getTaintFloat();
        return retVal;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.880 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "E33577BEEC5DADCAF68823E6F78877A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.880 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "ABBE1C4E781471842A6D95D790DBFBEE")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean protectedHasArray() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.881 -0400", hash_original_method = "E5C4F08E8681AF4EC36C77A34D3981AA", hash_generated_method = "E0688161CF92F0CC2DDCCEECE2E565B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public DoubleBuffer put(double c) {
        dsTaint.addTaint(c);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (DoubleBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.881 -0400", hash_original_method = "FE1D1321B1031173065E240BA4BCC6BC", hash_generated_method = "200D3E04D8E70A747099EE018844FE60")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public DoubleBuffer put(int index, double c) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(c);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (DoubleBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.881 -0400", hash_original_method = "817A5808CCAD86E249EA0880FB43BA43", hash_generated_method = "CDE59452F38ACD3D70E2D756048485C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final DoubleBuffer put(double[] src, int srcOffset, int byteCount) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (DoubleBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.881 -0400", hash_original_method = "9B0D4970C825DBBBAE90A7583E6AACE4", hash_generated_method = "FA773905906939B4AE2465A6D46CF729")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final DoubleBuffer put(DoubleBuffer buf) {
        dsTaint.addTaint(buf.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        return (DoubleBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.881 -0400", hash_original_method = "CFD0B1420E5034874759174E514350BC", hash_generated_method = "0AB9D5DA0DCB1E1F4D8C6C2823A14F05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public DoubleBuffer slice() {
        DoubleBuffer var2B5BB2244AE4AF6FFE3C052465C3C6A7_1708665129 = (new ReadOnlyDoubleArrayBuffer(remaining(), backingArray, offset + position));
        return (DoubleBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ReadOnlyDoubleArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

