package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

abstract class DoubleArrayBuffer extends DoubleBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.220 -0400", hash_original_field = "8D50CD27AA8B6BEC65C484FFCC5B2334", hash_generated_field = "72A67E62C40D09BAE43910B3E5CACC06")

    protected double[] backingArray;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.220 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "22BBBB3BDBDCD622FED3EBF1A70B4EC5")

    protected int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.220 -0400", hash_original_method = "3F3E4A2A5ABE550DAD549AD9F5CD19DE", hash_generated_method = "A2E232E5A375C8A84AC787A356B04DA3")
      DoubleArrayBuffer(double[] array) {
        this(array.length, array, 0);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.221 -0400", hash_original_method = "6003BB432EE138547D90D60175004272", hash_generated_method = "ECA92ED55259B9830AB77E0461708767")
      DoubleArrayBuffer(int capacity) {
        this(capacity, new double[capacity], 0);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.222 -0400", hash_original_method = "BFD112F1B44B2A6AED2367002E1D0285", hash_generated_method = "F391A5381EDB500B74FE1B60B1D81FB5")
      DoubleArrayBuffer(int capacity, double[] backingArray, int offset) {
        super(capacity);
        addTaint(capacity);
        this.backingArray = backingArray;
        this.offset = offset;
        // ---------- Original Method ----------
        //this.backingArray = backingArray;
        //this.offset = offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.222 -0400", hash_original_method = "CBBA623098702DBD3F5C6B97B033DEBD", hash_generated_method = "9B4DD3C96F249EA71FDB319A9A71364E")
    @Override
    public final double get() {
    if(position == limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_1697101791 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_1697101791.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_1697101791;
        } //End block
        double varD1A88672373807059A15983DE4C2AC9F_1067539881 = (backingArray[offset + position++]);
                double varE8CD7DA078A86726031AD64F35F5A6C0_458908285 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_458908285;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return backingArray[offset + position++];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.222 -0400", hash_original_method = "0637023D2B498B1330CE2AA53BD56A5A", hash_generated_method = "78DD3C90A1E312CF5EF94B2B609E50CF")
    @Override
    public final double get(int index) {
        addTaint(index);
        checkIndex(index);
        double varF4617D5762E2F642102CBB5F4FA87F0A_1876974619 = (backingArray[offset + index]);
                double varE8CD7DA078A86726031AD64F35F5A6C0_416478697 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_416478697;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return backingArray[offset + index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.223 -0400", hash_original_method = "DBA28E4E7AFB8E492F1C52FCFBB2DA2D", hash_generated_method = "24D4B266E54C2CC79C673DE6ACEED756")
    @Override
    public final DoubleBuffer get(double[] dst, int dstOffset, int doubleCount) {
        addTaint(doubleCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
    if(doubleCount > remaining())        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_1966784761 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_1966784761.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_1966784761;
        } //End block
        System.arraycopy(backingArray, offset + position, dst, dstOffset, doubleCount);
        position += doubleCount;
DoubleBuffer var72A74007B2BE62B849F475C7BDA4658B_404760712 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_404760712.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_404760712;
        // ---------- Original Method ----------
        //if (doubleCount > remaining()) {
            //throw new BufferUnderflowException();
        //}
        //System.arraycopy(backingArray, offset + position, dst, dstOffset, doubleCount);
        //position += doubleCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.223 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "EC820593E971BF7834A195AC55E15EBD")
    @Override
    public final boolean isDirect() {
        boolean var68934A3E9455FA72420237EB05902327_931809489 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1869255806 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1869255806;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.224 -0400", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "01477F3525897482534C427A4E485B68")
    @Override
    public final ByteOrder order() {
ByteOrder var1B533639214E0AD13A9C318946B77D59_917331522 =         ByteOrder.nativeOrder();
        var1B533639214E0AD13A9C318946B77D59_917331522.addTaint(taint);
        return var1B533639214E0AD13A9C318946B77D59_917331522;
        // ---------- Original Method ----------
        //return ByteOrder.nativeOrder();
    }

    
}

