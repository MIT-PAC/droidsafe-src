package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

abstract class FloatArrayBuffer extends FloatBuffer {
    protected float[] backingArray;
    protected int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.705 -0400", hash_original_method = "D11EDAC27157134F6D93222FED96804A", hash_generated_method = "D9ADB07FD21F5F3369932F1F4425376E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     FloatArrayBuffer(float[] array) {
        this(array.length, array, 0);
        dsTaint.addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.705 -0400", hash_original_method = "1F51B561748313656A83CE5668F8D726", hash_generated_method = "3555E57472A5B564AF4E055CA826C5F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     FloatArrayBuffer(int capacity) {
        this(capacity, new float[capacity], 0);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.706 -0400", hash_original_method = "08256304DC715C68C786DDFF589B597E", hash_generated_method = "888501028DEA0E632B2DFB0366F3327E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     FloatArrayBuffer(int capacity, float[] backingArray, int offset) {
        super(capacity);
        dsTaint.addTaint(backingArray[0]);
        dsTaint.addTaint(capacity);
        dsTaint.addTaint(offset);
        // ---------- Original Method ----------
        //this.backingArray = backingArray;
        //this.offset = offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.706 -0400", hash_original_method = "27C2E9E0DC08E8F6369DBB2405A9C20A", hash_generated_method = "993609C7B66159C7E707B908BF5042F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final float get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return backingArray[offset + position++];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.706 -0400", hash_original_method = "7B23CE1A9B110702665631EFEB3A42BD", hash_generated_method = "776BB57658C311A744DC5D71A15699A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final float get(int index) {
        dsTaint.addTaint(index);
        checkIndex(index);
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //checkIndex(index);
        //return backingArray[offset + index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.706 -0400", hash_original_method = "0E5CD729EA86ED4C8F1722765DDD0E33", hash_generated_method = "3EBFAF0FFE52225F516BA0E29EE98EEB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final FloatBuffer get(float[] dst, int dstOffset, int floatCount) {
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
        dsTaint.addTaint(floatCount);
        {
            boolean varE021C2AFD91F3DCFB06333FB83FDE7E4_1474994939 = (floatCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
            } //End block
        } //End collapsed parenthetic
        System.arraycopy(backingArray, offset + position, dst, dstOffset, floatCount);
        position += floatCount;
        return (FloatBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (floatCount > remaining()) {
            //throw new BufferUnderflowException();
        //}
        //System.arraycopy(backingArray, offset + position, dst, dstOffset, floatCount);
        //position += floatCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.706 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "7E7C9B3B0EC5D6CFC1C636F6242D264A")
    @DSModeled(DSC.SAFE)
    @Override
    public final boolean isDirect() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.706 -0400", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "46FC3A2375154A53729D1E00956E6660")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final ByteOrder order() {
        ByteOrder var65FB841C6DEFAE151AADF2CD2F0C0FB5_810446326 = (ByteOrder.nativeOrder());
        return (ByteOrder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ByteOrder.nativeOrder();
    }

    
}

