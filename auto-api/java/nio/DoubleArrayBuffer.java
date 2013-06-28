package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

abstract class DoubleArrayBuffer extends DoubleBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.110 -0400", hash_original_field = "8D50CD27AA8B6BEC65C484FFCC5B2334", hash_generated_field = "72A67E62C40D09BAE43910B3E5CACC06")

    protected double[] backingArray;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.110 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "22BBBB3BDBDCD622FED3EBF1A70B4EC5")

    protected int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.111 -0400", hash_original_method = "3F3E4A2A5ABE550DAD549AD9F5CD19DE", hash_generated_method = "A2E232E5A375C8A84AC787A356B04DA3")
      DoubleArrayBuffer(double[] array) {
        this(array.length, array, 0);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.111 -0400", hash_original_method = "6003BB432EE138547D90D60175004272", hash_generated_method = "ECA92ED55259B9830AB77E0461708767")
      DoubleArrayBuffer(int capacity) {
        this(capacity, new double[capacity], 0);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.111 -0400", hash_original_method = "BFD112F1B44B2A6AED2367002E1D0285", hash_generated_method = "B31DFEB67E337FD1072E7AC8D4E75475")
      DoubleArrayBuffer(int capacity, double[] backingArray, int offset) {
        super(capacity);
        this.backingArray = backingArray;
        this.offset = offset;
        addTaint(capacity);
        // ---------- Original Method ----------
        //this.backingArray = backingArray;
        //this.offset = offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.112 -0400", hash_original_method = "CBBA623098702DBD3F5C6B97B033DEBD", hash_generated_method = "3CC74B9769BC6AD991D4D872C53C567E")
    @Override
    public final double get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        double varE8CD7DA078A86726031AD64F35F5A6C0_1288667782 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1288667782;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return backingArray[offset + position++];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.112 -0400", hash_original_method = "0637023D2B498B1330CE2AA53BD56A5A", hash_generated_method = "FF486DECC48118C5C460CD8143D302FE")
    @Override
    public final double get(int index) {
        checkIndex(index);
        addTaint(index);
        double varE8CD7DA078A86726031AD64F35F5A6C0_1469664289 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1469664289;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return backingArray[offset + index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.112 -0400", hash_original_method = "DBA28E4E7AFB8E492F1C52FCFBB2DA2D", hash_generated_method = "891678973517B3CA65F092DF2D398F32")
    @Override
    public final DoubleBuffer get(double[] dst, int dstOffset, int doubleCount) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1137134558 = null; //Variable for return #1
        {
            boolean var74C0A42AB3BAE67C7C3CC56E2CA2CC6D_593865428 = (doubleCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
            } //End block
        } //End collapsed parenthetic
        System.arraycopy(backingArray, offset + position, dst, dstOffset, doubleCount);
        position += doubleCount;
        varB4EAC82CA7396A68D541C85D26508E83_1137134558 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(doubleCount);
        varB4EAC82CA7396A68D541C85D26508E83_1137134558.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1137134558;
        // ---------- Original Method ----------
        //if (doubleCount > remaining()) {
            //throw new BufferUnderflowException();
        //}
        //System.arraycopy(backingArray, offset + position, dst, dstOffset, doubleCount);
        //position += doubleCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.113 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "5854F474B882993C24DF614249FA1E7D")
    @Override
    public final boolean isDirect() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1729198208 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1729198208;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.113 -0400", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "0AB5A93F83614CDD9BAEF8A57C8FFB0B")
    @Override
    public final ByteOrder order() {
        ByteOrder varB4EAC82CA7396A68D541C85D26508E83_415781806 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_415781806 = ByteOrder.nativeOrder();
        varB4EAC82CA7396A68D541C85D26508E83_415781806.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_415781806;
        // ---------- Original Method ----------
        //return ByteOrder.nativeOrder();
    }

    
}

