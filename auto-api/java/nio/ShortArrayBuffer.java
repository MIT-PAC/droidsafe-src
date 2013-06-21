package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

abstract class ShortArrayBuffer extends ShortBuffer {
    protected short[] backingArray;
    protected int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.020 -0400", hash_original_method = "2309FEF74B5324CE6644430AA32CE10F", hash_generated_method = "5D14CDA801F89F43F86BF9D5C087E9F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ShortArrayBuffer(short[] array) {
        this(array.length, array, 0);
        dsTaint.addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.021 -0400", hash_original_method = "83C4FE898A0AB05D8AFE678BFD611891", hash_generated_method = "E7B90EF60CC9E771184AAA931BE91A10")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ShortArrayBuffer(int capacity) {
        this(capacity, new short[capacity], 0);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.021 -0400", hash_original_method = "6241269CB95A33BDF406F3571CF80FE7", hash_generated_method = "4CF7582778FFD137402AA48E7AB9FC85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ShortArrayBuffer(int capacity, short[] backingArray, int offset) {
        super(capacity);
        dsTaint.addTaint(backingArray[0]);
        dsTaint.addTaint(capacity);
        dsTaint.addTaint(offset);
        // ---------- Original Method ----------
        //this.backingArray = backingArray;
        //this.offset = offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.021 -0400", hash_original_method = "3107E6B251B23EDC44F5CD8DFDAAC4B8", hash_generated_method = "8C0588ADB405CFEFC70D1B6B7AF34743")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final short get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return backingArray[offset + position++];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.021 -0400", hash_original_method = "C45D95B915B8493973D4F3C69BA81F93", hash_generated_method = "66893E96CE9C9028ED057C4AFE4A4144")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final short get(int index) {
        dsTaint.addTaint(index);
        checkIndex(index);
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //checkIndex(index);
        //return backingArray[offset + index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.021 -0400", hash_original_method = "89DFF38986FFC53F43866053D7635804", hash_generated_method = "2580F394BDB0036CC262AB085DFD5740")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final ShortBuffer get(short[] dst, int dstOffset, int shortCount) {
        dsTaint.addTaint(shortCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
        {
            boolean varD727A1D2181C264BA4333582F807AE27_1294451245 = (shortCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
            } //End block
        } //End collapsed parenthetic
        System.arraycopy(backingArray, offset + position, dst, dstOffset, shortCount);
        position += shortCount;
        return (ShortBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (shortCount > remaining()) {
            //throw new BufferUnderflowException();
        //}
        //System.arraycopy(backingArray, offset + position, dst, dstOffset, shortCount);
        //position += shortCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.021 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "7E7C9B3B0EC5D6CFC1C636F6242D264A")
    @DSModeled(DSC.SAFE)
    @Override
    public final boolean isDirect() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.022 -0400", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "7299E01FC44711FCF0E1B1949600C44E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final ByteOrder order() {
        ByteOrder var65FB841C6DEFAE151AADF2CD2F0C0FB5_216008611 = (ByteOrder.nativeOrder());
        return (ByteOrder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ByteOrder.nativeOrder();
    }

    
}

