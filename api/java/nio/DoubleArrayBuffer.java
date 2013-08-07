package java.nio;

// Droidsafe Imports
import droidsafe.annotations.*;





abstract class DoubleArrayBuffer extends DoubleBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.554 -0400", hash_original_field = "8D50CD27AA8B6BEC65C484FFCC5B2334", hash_generated_field = "72A67E62C40D09BAE43910B3E5CACC06")

    protected double[] backingArray;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.554 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "22BBBB3BDBDCD622FED3EBF1A70B4EC5")

    protected int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.554 -0400", hash_original_method = "3F3E4A2A5ABE550DAD549AD9F5CD19DE", hash_generated_method = "A2E232E5A375C8A84AC787A356B04DA3")
      DoubleArrayBuffer(double[] array) {
        this(array.length, array, 0);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.554 -0400", hash_original_method = "6003BB432EE138547D90D60175004272", hash_generated_method = "ECA92ED55259B9830AB77E0461708767")
      DoubleArrayBuffer(int capacity) {
        this(capacity, new double[capacity], 0);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.555 -0400", hash_original_method = "BFD112F1B44B2A6AED2367002E1D0285", hash_generated_method = "F391A5381EDB500B74FE1B60B1D81FB5")
      DoubleArrayBuffer(int capacity, double[] backingArray, int offset) {
        super(capacity);
        addTaint(capacity);
        this.backingArray = backingArray;
        this.offset = offset;
        // ---------- Original Method ----------
        //this.backingArray = backingArray;
        //this.offset = offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.556 -0400", hash_original_method = "CBBA623098702DBD3F5C6B97B033DEBD", hash_generated_method = "223BE1B4F4E9B6E5329544F4BFA18C5F")
    @Override
    public final double get() {
        if(position == limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_1535028270 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_1535028270.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_1535028270;
        } //End block
        double varD1A88672373807059A15983DE4C2AC9F_1911207946 = (backingArray[offset + position++]);
                double varE8CD7DA078A86726031AD64F35F5A6C0_1961411785 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1961411785;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return backingArray[offset + position++];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.556 -0400", hash_original_method = "0637023D2B498B1330CE2AA53BD56A5A", hash_generated_method = "A2C9005164CA67FE46CD65B522692928")
    @Override
    public final double get(int index) {
        addTaint(index);
        checkIndex(index);
        double varF4617D5762E2F642102CBB5F4FA87F0A_1776145041 = (backingArray[offset + index]);
                double varE8CD7DA078A86726031AD64F35F5A6C0_1027884019 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1027884019;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return backingArray[offset + index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.557 -0400", hash_original_method = "DBA28E4E7AFB8E492F1C52FCFBB2DA2D", hash_generated_method = "54FF410BAFC7A3C5D08C807102DADDC7")
    @Override
    public final DoubleBuffer get(double[] dst, int dstOffset, int doubleCount) {
        addTaint(doubleCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        if(doubleCount > remaining())        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_994312262 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_994312262.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_994312262;
        } //End block
        System.arraycopy(backingArray, offset + position, dst, dstOffset, doubleCount);
        position += doubleCount;
DoubleBuffer var72A74007B2BE62B849F475C7BDA4658B_185333783 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_185333783.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_185333783;
        // ---------- Original Method ----------
        //if (doubleCount > remaining()) {
            //throw new BufferUnderflowException();
        //}
        //System.arraycopy(backingArray, offset + position, dst, dstOffset, doubleCount);
        //position += doubleCount;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.558 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "12555E4005A9FDE757D64E52D4D715CB")
    @Override
    public final boolean isDirect() {
        boolean var68934A3E9455FA72420237EB05902327_1008659975 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1944476319 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1944476319;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.558 -0400", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "9CCCB7DC6ABF90F8E4308BDF4C496C68")
    @Override
    public final ByteOrder order() {
ByteOrder var1B533639214E0AD13A9C318946B77D59_616999529 =         ByteOrder.nativeOrder();
        var1B533639214E0AD13A9C318946B77D59_616999529.addTaint(taint);
        return var1B533639214E0AD13A9C318946B77D59_616999529;
        // ---------- Original Method ----------
        //return ByteOrder.nativeOrder();
    }

    
}

