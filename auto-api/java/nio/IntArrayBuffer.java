package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

abstract class IntArrayBuffer extends IntBuffer {
    protected int[] backingArray;
    protected int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.748 -0400", hash_original_method = "D18B871637BEEEB2AE768346D692C9D7", hash_generated_method = "C4E195D6B737FDEC7D77C50A9B39D24A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     IntArrayBuffer(int[] array) {
        this(array.length, array, 0);
        dsTaint.addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.748 -0400", hash_original_method = "64ADCEABF0045F3DCF099C9C9B4F7808", hash_generated_method = "BDA37B4EDB923B7F2C64FD8F7F0A6F8E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     IntArrayBuffer(int capacity) {
        this(capacity, new int[capacity], 0);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.749 -0400", hash_original_method = "8D85757E2A089A86486F1DA1C7B27DB7", hash_generated_method = "C9AD8C61891709570130D7CDBD0ABF6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     IntArrayBuffer(int capacity, int[] backingArray, int offset) {
        super(capacity);
        dsTaint.addTaint(backingArray[0]);
        dsTaint.addTaint(capacity);
        dsTaint.addTaint(offset);
        // ---------- Original Method ----------
        //this.backingArray = backingArray;
        //this.offset = offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.749 -0400", hash_original_method = "2EA67F38ECDA332174959B54F9DC216E", hash_generated_method = "694FA807C4C6A6E1C5D66C370B38B0AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final int get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return backingArray[offset + position++];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.749 -0400", hash_original_method = "BB46C2F433DB7E33613C9314C6AAA302", hash_generated_method = "79ABF1F47D1905DC2397E2C828E282FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final int get(int index) {
        dsTaint.addTaint(index);
        checkIndex(index);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkIndex(index);
        //return backingArray[offset + index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.750 -0400", hash_original_method = "CF9BFE676211E932B27B1BA0A79794E4", hash_generated_method = "962241979D184F5A03C4A00EB9373131")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final IntBuffer get(int[] dst, int dstOffset, int intCount) {
        dsTaint.addTaint(intCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
        {
            boolean var88D58DBFE8E26BEBC18FDE3265CF76EF_1592462858 = (intCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
            } //End block
        } //End collapsed parenthetic
        System.arraycopy(backingArray, offset + position, dst, dstOffset, intCount);
        position += intCount;
        return (IntBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (intCount > remaining()) {
            //throw new BufferUnderflowException();
        //}
        //System.arraycopy(backingArray, offset + position, dst, dstOffset, intCount);
        //position += intCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.750 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "7E7C9B3B0EC5D6CFC1C636F6242D264A")
    @DSModeled(DSC.SAFE)
    @Override
    public final boolean isDirect() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.750 -0400", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "ED993411505F6FD12FBDDE448D80E4CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final ByteOrder order() {
        ByteOrder var65FB841C6DEFAE151AADF2CD2F0C0FB5_500939106 = (ByteOrder.nativeOrder());
        return (ByteOrder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ByteOrder.nativeOrder();
    }

    
}

