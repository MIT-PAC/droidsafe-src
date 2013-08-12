package java.nio;

// Droidsafe Imports
import droidsafe.annotations.*;





abstract class LongArrayBuffer extends LongBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.234 -0400", hash_original_field = "8D50CD27AA8B6BEC65C484FFCC5B2334", hash_generated_field = "328A8BF34389CAFD34319C79BCDE07B5")

    protected long[] backingArray;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.234 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "22BBBB3BDBDCD622FED3EBF1A70B4EC5")

    protected int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.234 -0400", hash_original_method = "D20A97F337BC1EF41CF62C2D80A010BB", hash_generated_method = "FE0F345F00C1A48D4CB6AE2613BACF04")
      LongArrayBuffer(long[] array) {
        this(array.length, array, 0);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.235 -0400", hash_original_method = "EE894B007B87BC6BD13255E42716BBF0", hash_generated_method = "5AFAF67FACB01860C017417566B36978")
      LongArrayBuffer(int capacity) {
        this(capacity, new long[capacity], 0);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.235 -0400", hash_original_method = "C693B30298FFAD9EFA29C4595321A1EB", hash_generated_method = "34F313263D720E17E1BBA3C23271405D")
      LongArrayBuffer(int capacity, long[] backingArray, int offset) {
        super(capacity);
        addTaint(capacity);
        this.backingArray = backingArray;
        this.offset = offset;
        // ---------- Original Method ----------
        //this.backingArray = backingArray;
        //this.offset = offset;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.236 -0400", hash_original_method = "E2FF30257BFFCB6B65D7425E7B88C7B2", hash_generated_method = "70EFC8E8521A00BAA88C6778892A2BA0")
    @Override
    public final long get() {
        if(position == limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_131250950 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_131250950.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_131250950;
        } //End block
        long varD1A88672373807059A15983DE4C2AC9F_1246967774 = (backingArray[offset + position++]);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1154678712 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1154678712;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return backingArray[offset + position++];
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.236 -0400", hash_original_method = "E501A733A2C96D5405AAE01CF07D222B", hash_generated_method = "ECD506101BCF466A0562858FC6B0276F")
    @Override
    public final long get(int index) {
        addTaint(index);
        checkIndex(index);
        long varF4617D5762E2F642102CBB5F4FA87F0A_953639961 = (backingArray[offset + index]);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_171921203 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_171921203;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return backingArray[offset + index];
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.237 -0400", hash_original_method = "E85CBDF91AD45B8A94165F7B57575CBE", hash_generated_method = "3830FDE74DDFBA4DAFE141C9359B1EA8")
    @Override
    public final LongBuffer get(long[] dst, int dstOffset, int longCount) {
        addTaint(longCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        if(longCount > remaining())        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_380899473 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_380899473.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_380899473;
        } //End block
        System.arraycopy(backingArray, offset + position, dst, dstOffset, longCount);
        position += longCount;
LongBuffer var72A74007B2BE62B849F475C7BDA4658B_521928492 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_521928492.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_521928492;
        // ---------- Original Method ----------
        //if (longCount > remaining()) {
            //throw new BufferUnderflowException();
        //}
        //System.arraycopy(backingArray, offset + position, dst, dstOffset, longCount);
        //position += longCount;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.237 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "FBE3B57131451A979FEC5BE77660D83E")
    @Override
    public final boolean isDirect() {
        boolean var68934A3E9455FA72420237EB05902327_1352531130 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_191544063 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_191544063;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.238 -0400", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "7892F5EC7D30B5A3E34D3A379E6CAF0C")
    @Override
    public final ByteOrder order() {
ByteOrder var1B533639214E0AD13A9C318946B77D59_1600287686 =         ByteOrder.nativeOrder();
        var1B533639214E0AD13A9C318946B77D59_1600287686.addTaint(taint);
        return var1B533639214E0AD13A9C318946B77D59_1600287686;
        // ---------- Original Method ----------
        //return ByteOrder.nativeOrder();
    }

    
}

