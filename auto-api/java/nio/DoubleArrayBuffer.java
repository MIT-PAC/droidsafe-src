package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

abstract class DoubleArrayBuffer extends DoubleBuffer {
    protected double[] backingArray;
    protected int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.629 -0400", hash_original_method = "3F3E4A2A5ABE550DAD549AD9F5CD19DE", hash_generated_method = "B6091F03D2938FE4F274F07BCC057075")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     DoubleArrayBuffer(double[] array) {
        this(array.length, array, 0);
        dsTaint.addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.629 -0400", hash_original_method = "6003BB432EE138547D90D60175004272", hash_generated_method = "774170D302A433CAA60D52C7FB2A7D0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     DoubleArrayBuffer(int capacity) {
        this(capacity, new double[capacity], 0);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.629 -0400", hash_original_method = "BFD112F1B44B2A6AED2367002E1D0285", hash_generated_method = "51FE9AECD6BE10268E804A2685730EBF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     DoubleArrayBuffer(int capacity, double[] backingArray, int offset) {
        super(capacity);
        dsTaint.addTaint(backingArray[0]);
        dsTaint.addTaint(capacity);
        dsTaint.addTaint(offset);
        // ---------- Original Method ----------
        //this.backingArray = backingArray;
        //this.offset = offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.629 -0400", hash_original_method = "CBBA623098702DBD3F5C6B97B033DEBD", hash_generated_method = "90454E2A90AEB082E1E69A021AB4AFE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final double get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return backingArray[offset + position++];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.629 -0400", hash_original_method = "0637023D2B498B1330CE2AA53BD56A5A", hash_generated_method = "8C978609AA797456DB3678058FD56B75")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final double get(int index) {
        dsTaint.addTaint(index);
        checkIndex(index);
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //checkIndex(index);
        //return backingArray[offset + index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.630 -0400", hash_original_method = "DBA28E4E7AFB8E492F1C52FCFBB2DA2D", hash_generated_method = "8CFE92649293277D0129BBE98AF48C7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final DoubleBuffer get(double[] dst, int dstOffset, int doubleCount) {
        dsTaint.addTaint(doubleCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
        {
            boolean var74C0A42AB3BAE67C7C3CC56E2CA2CC6D_805769181 = (doubleCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
            } //End block
        } //End collapsed parenthetic
        System.arraycopy(backingArray, offset + position, dst, dstOffset, doubleCount);
        position += doubleCount;
        return (DoubleBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (doubleCount > remaining()) {
            //throw new BufferUnderflowException();
        //}
        //System.arraycopy(backingArray, offset + position, dst, dstOffset, doubleCount);
        //position += doubleCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.630 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "7E7C9B3B0EC5D6CFC1C636F6242D264A")
    @DSModeled(DSC.SAFE)
    @Override
    public final boolean isDirect() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.630 -0400", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "CC9F9FC8772ED4B4FA78573D87CB7990")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final ByteOrder order() {
        ByteOrder var65FB841C6DEFAE151AADF2CD2F0C0FB5_96260932 = (ByteOrder.nativeOrder());
        return (ByteOrder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ByteOrder.nativeOrder();
    }

    
}

