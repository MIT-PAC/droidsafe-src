package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadWriteIntArrayBuffer extends IntArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.952 -0400", hash_original_method = "8D9DDDEFB3AB21DD4A0254B750731D70", hash_generated_method = "5A12C348B1C2FEBBD55EC2B2CBC31F34")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ReadWriteIntArrayBuffer(int[] array) {
        super(array);
        dsTaint.addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.952 -0400", hash_original_method = "43CEDB64CCBA692E544DE7CD0AC198FC", hash_generated_method = "92B11ED65E283DF42445759D313B4745")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ReadWriteIntArrayBuffer(int capacity) {
        super(capacity);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.952 -0400", hash_original_method = "A26E8A674EF0ED3D9F3331CA6DE93799", hash_generated_method = "FCC6198CFDB19776B5B5994DFE086C92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ReadWriteIntArrayBuffer(int capacity, int[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        dsTaint.addTaint(backingArray[0]);
        dsTaint.addTaint(arrayOffset);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
        static ReadWriteIntArrayBuffer copy(IntArrayBuffer other, int markOfOther) {
        ReadWriteIntArrayBuffer buf =
                new ReadWriteIntArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.952 -0400", hash_original_method = "4B95192F4339BC062AF51933230B3F0C", hash_generated_method = "A3C5DA198086CFE7DE01F04F29C73C83")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public IntBuffer asReadOnlyBuffer() {
        IntBuffer varD2F353FFA88F5FCD672A00E141B57183_1115451764 = (ReadOnlyIntArrayBuffer.copy(this, mark));
        return (IntBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ReadOnlyIntArrayBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.952 -0400", hash_original_method = "62E2BDB6C89716847449D50CC36598CA", hash_generated_method = "679621508A9BE6447432606102471E57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public IntBuffer compact() {
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        return (IntBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.953 -0400", hash_original_method = "E687D66866CD72B4F21034D8F21E9369", hash_generated_method = "64EB7025EF4D06DC1F90C1B9DF15E971")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public IntBuffer duplicate() {
        IntBuffer var8C82ED9E4FDE12C9486E1252174918B6_76351500 = (copy(this, mark));
        return (IntBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.953 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "1F2BF0EB1F192C8C411CC0427A2B9F5B")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isReadOnly() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.953 -0400", hash_original_method = "A905887CE8C7700C79178CD7C8EB8B1A", hash_generated_method = "DB776023787C0F9C1DFEF35E4DEF4D9A")
    @DSModeled(DSC.SAFE)
    @Override
    protected int[] protectedArray() {
        int[] retVal = new int[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return backingArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.953 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "B6AF1441163DC81E5A7523DBEAED19DC")
    @DSModeled(DSC.SAFE)
    @Override
    protected int protectedArrayOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.953 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "F14C0EBC785314AEABBE7CBCFAB3FB1D")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean protectedHasArray() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.953 -0400", hash_original_method = "24A625E8D082FBF527A2D93F3C5BC8E0", hash_generated_method = "11B0653ED84330A16CDC8C3068CD6734")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public IntBuffer put(int c) {
        dsTaint.addTaint(c);
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        backingArray[offset + position++] = c;
        return (IntBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //backingArray[offset + position++] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.953 -0400", hash_original_method = "2E47BE1B8B3BBE9EFD962F4A517C459A", hash_generated_method = "2DF762E225D1323C29D5738C6E7F064A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public IntBuffer put(int index, int c) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(c);
        checkIndex(index);
        backingArray[offset + index] = c;
        return (IntBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkIndex(index);
        //backingArray[offset + index] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.954 -0400", hash_original_method = "F72176B11CC709D09C4C37209C319F78", hash_generated_method = "996ECDB0F578CC9286935DC7E666114F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public IntBuffer put(int[] src, int srcOffset, int intCount) {
        dsTaint.addTaint(intCount);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        {
            boolean var88D58DBFE8E26BEBC18FDE3265CF76EF_1601582623 = (intCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        System.arraycopy(src, srcOffset, backingArray, offset + position, intCount);
        position += intCount;
        return (IntBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (intCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //System.arraycopy(src, srcOffset, backingArray, offset + position, intCount);
        //position += intCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.954 -0400", hash_original_method = "E64EEB28D2F233E17F9AAF235F4E0576", hash_generated_method = "66635779C59F05A88AEB479EF2EB246F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public IntBuffer slice() {
        IntBuffer var4D38B83CEBE059D5A10E3AA5B8BB07AE_1682038360 = (new ReadWriteIntArrayBuffer(remaining(), backingArray, offset + position));
        return (IntBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ReadWriteIntArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

