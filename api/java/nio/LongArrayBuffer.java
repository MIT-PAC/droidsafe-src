package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

abstract class LongArrayBuffer extends LongBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.742 -0400", hash_original_field = "8D50CD27AA8B6BEC65C484FFCC5B2334", hash_generated_field = "328A8BF34389CAFD34319C79BCDE07B5")

    protected long[] backingArray;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.742 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "22BBBB3BDBDCD622FED3EBF1A70B4EC5")

    protected int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.742 -0400", hash_original_method = "D20A97F337BC1EF41CF62C2D80A010BB", hash_generated_method = "FE0F345F00C1A48D4CB6AE2613BACF04")
      LongArrayBuffer(long[] array) {
        this(array.length, array, 0);
        addTaint(array[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.743 -0400", hash_original_method = "EE894B007B87BC6BD13255E42716BBF0", hash_generated_method = "5AFAF67FACB01860C017417566B36978")
      LongArrayBuffer(int capacity) {
        this(capacity, new long[capacity], 0);
        addTaint(capacity);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.743 -0400", hash_original_method = "C693B30298FFAD9EFA29C4595321A1EB", hash_generated_method = "34F313263D720E17E1BBA3C23271405D")
      LongArrayBuffer(int capacity, long[] backingArray, int offset) {
        super(capacity);
        addTaint(capacity);
        this.backingArray = backingArray;
        this.offset = offset;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.744 -0400", hash_original_method = "E2FF30257BFFCB6B65D7425E7B88C7B2", hash_generated_method = "4A3276CED0E49D77CC1ACAAA01144CD2")
    @Override
    public final long get() {
    if(position == limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_174180381 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_174180381.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_174180381;
        } 
        long varD1A88672373807059A15983DE4C2AC9F_1432909021 = (backingArray[offset + position++]);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1121991173 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1121991173;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.744 -0400", hash_original_method = "E501A733A2C96D5405AAE01CF07D222B", hash_generated_method = "A08CABAA002535D7ECDE6ECB19792DAA")
    @Override
    public final long get(int index) {
        addTaint(index);
        checkIndex(index);
        long varF4617D5762E2F642102CBB5F4FA87F0A_1831566595 = (backingArray[offset + index]);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_168912800 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_168912800;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.745 -0400", hash_original_method = "E85CBDF91AD45B8A94165F7B57575CBE", hash_generated_method = "3C76BA3999FD1CFACB2C540B3EA74BC7")
    @Override
    public final LongBuffer get(long[] dst, int dstOffset, int longCount) {
        addTaint(longCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
    if(longCount > remaining())        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_178131660 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_178131660.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_178131660;
        } 
        System.arraycopy(backingArray, offset + position, dst, dstOffset, longCount);
        position += longCount;
LongBuffer var72A74007B2BE62B849F475C7BDA4658B_984128695 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_984128695.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_984128695;
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.745 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "72BD14F72B30E3CA0FA3E6FCC833A7D8")
    @Override
    public final boolean isDirect() {
        boolean var68934A3E9455FA72420237EB05902327_1706063131 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_481069569 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_481069569;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.745 -0400", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "99B3C54CEAB5A31E714C64F72C532F76")
    @Override
    public final ByteOrder order() {
ByteOrder var1B533639214E0AD13A9C318946B77D59_1003523709 =         ByteOrder.nativeOrder();
        var1B533639214E0AD13A9C318946B77D59_1003523709.addTaint(taint);
        return var1B533639214E0AD13A9C318946B77D59_1003523709;
        
        
    }

    
}

