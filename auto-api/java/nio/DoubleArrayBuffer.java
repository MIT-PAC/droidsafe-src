package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

abstract class DoubleArrayBuffer extends DoubleBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.185 -0400", hash_original_field = "8D50CD27AA8B6BEC65C484FFCC5B2334", hash_generated_field = "72A67E62C40D09BAE43910B3E5CACC06")

    protected double[] backingArray;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.185 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "22BBBB3BDBDCD622FED3EBF1A70B4EC5")

    protected int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.185 -0400", hash_original_method = "3F3E4A2A5ABE550DAD549AD9F5CD19DE", hash_generated_method = "A2E232E5A375C8A84AC787A356B04DA3")
      DoubleArrayBuffer(double[] array) {
        this(array.length, array, 0);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.211 -0400", hash_original_method = "6003BB432EE138547D90D60175004272", hash_generated_method = "ECA92ED55259B9830AB77E0461708767")
      DoubleArrayBuffer(int capacity) {
        this(capacity, new double[capacity], 0);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.212 -0400", hash_original_method = "BFD112F1B44B2A6AED2367002E1D0285", hash_generated_method = "B31DFEB67E337FD1072E7AC8D4E75475")
      DoubleArrayBuffer(int capacity, double[] backingArray, int offset) {
        super(capacity);
        this.backingArray = backingArray;
        this.offset = offset;
        addTaint(capacity);
        // ---------- Original Method ----------
        //this.backingArray = backingArray;
        //this.offset = offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.212 -0400", hash_original_method = "CBBA623098702DBD3F5C6B97B033DEBD", hash_generated_method = "37A7E40639C2CAA8FAC9CE2E7C47BCC7")
    @Override
    public final double get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        double varE8CD7DA078A86726031AD64F35F5A6C0_408432509 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_408432509;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return backingArray[offset + position++];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.213 -0400", hash_original_method = "0637023D2B498B1330CE2AA53BD56A5A", hash_generated_method = "0CF23B513CBA8E752C38F8E9BB51C5E4")
    @Override
    public final double get(int index) {
        checkIndex(index);
        addTaint(index);
        double varE8CD7DA078A86726031AD64F35F5A6C0_214314853 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_214314853;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return backingArray[offset + index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.214 -0400", hash_original_method = "DBA28E4E7AFB8E492F1C52FCFBB2DA2D", hash_generated_method = "8D50C8003072A448E07FF715CB137F70")
    @Override
    public final DoubleBuffer get(double[] dst, int dstOffset, int doubleCount) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_740650347 = null; //Variable for return #1
        {
            boolean var74C0A42AB3BAE67C7C3CC56E2CA2CC6D_1985442757 = (doubleCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
            } //End block
        } //End collapsed parenthetic
        System.arraycopy(backingArray, offset + position, dst, dstOffset, doubleCount);
        position += doubleCount;
        varB4EAC82CA7396A68D541C85D26508E83_740650347 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(doubleCount);
        varB4EAC82CA7396A68D541C85D26508E83_740650347.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_740650347;
        // ---------- Original Method ----------
        //if (doubleCount > remaining()) {
            //throw new BufferUnderflowException();
        //}
        //System.arraycopy(backingArray, offset + position, dst, dstOffset, doubleCount);
        //position += doubleCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.214 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "21D9815BFF1F3D7FE75B42C476FCA09E")
    @Override
    public final boolean isDirect() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1967703725 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1967703725;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.220 -0400", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "F566A5C54E9AA82DCC67CF4A18D05F13")
    @Override
    public final ByteOrder order() {
        ByteOrder varB4EAC82CA7396A68D541C85D26508E83_966575803 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_966575803 = ByteOrder.nativeOrder();
        varB4EAC82CA7396A68D541C85D26508E83_966575803.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_966575803;
        // ---------- Original Method ----------
        //return ByteOrder.nativeOrder();
    }

    
}

