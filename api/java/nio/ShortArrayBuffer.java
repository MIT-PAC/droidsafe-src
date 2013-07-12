package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

abstract class ShortArrayBuffer extends ShortBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.313 -0400", hash_original_field = "8D50CD27AA8B6BEC65C484FFCC5B2334", hash_generated_field = "D6BFE43B0E3E7A05E4F673EAC5DBB347")

    protected short[] backingArray;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.313 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "22BBBB3BDBDCD622FED3EBF1A70B4EC5")

    protected int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.313 -0400", hash_original_method = "2309FEF74B5324CE6644430AA32CE10F", hash_generated_method = "FF0F9A06C16F267BF5CA0F550B350245")
      ShortArrayBuffer(short[] array) {
        this(array.length, array, 0);
        addTaint(array[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.313 -0400", hash_original_method = "83C4FE898A0AB05D8AFE678BFD611891", hash_generated_method = "1665ACB846300A3BE1C2B7D1195FF044")
      ShortArrayBuffer(int capacity) {
        this(capacity, new short[capacity], 0);
        addTaint(capacity);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.314 -0400", hash_original_method = "6241269CB95A33BDF406F3571CF80FE7", hash_generated_method = "7BB39139A9810CDFE136112E0045D0EE")
      ShortArrayBuffer(int capacity, short[] backingArray, int offset) {
        super(capacity);
        addTaint(capacity);
        this.backingArray = backingArray;
        this.offset = offset;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.314 -0400", hash_original_method = "3107E6B251B23EDC44F5CD8DFDAAC4B8", hash_generated_method = "1590F637867CB931939EE4429C97A9AF")
    @Override
    public final short get() {
    if(position == limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_1617421942 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_1617421942.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_1617421942;
        } 
        short varD1A88672373807059A15983DE4C2AC9F_723681917 = (backingArray[offset + position++]);
                short var4F09DAA9D95BCB166A302407A0E0BABE_1698905612 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1698905612;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.315 -0400", hash_original_method = "C45D95B915B8493973D4F3C69BA81F93", hash_generated_method = "0CA8934AE653BFDE5803698E354F5A38")
    @Override
    public final short get(int index) {
        addTaint(index);
        checkIndex(index);
        short varF4617D5762E2F642102CBB5F4FA87F0A_1945530151 = (backingArray[offset + index]);
                short var4F09DAA9D95BCB166A302407A0E0BABE_186450070 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_186450070;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.316 -0400", hash_original_method = "89DFF38986FFC53F43866053D7635804", hash_generated_method = "D56340685CC9C3ED2B0B5B191D16499B")
    @Override
    public final ShortBuffer get(short[] dst, int dstOffset, int shortCount) {
        addTaint(shortCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
    if(shortCount > remaining())        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_1823217778 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_1823217778.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_1823217778;
        } 
        System.arraycopy(backingArray, offset + position, dst, dstOffset, shortCount);
        position += shortCount;
ShortBuffer var72A74007B2BE62B849F475C7BDA4658B_137811097 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_137811097.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_137811097;
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.316 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "334EF8E31D703642973D44267584F734")
    @Override
    public final boolean isDirect() {
        boolean var68934A3E9455FA72420237EB05902327_947427524 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1937970314 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1937970314;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.317 -0400", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "ED78E1F98CE6D50AD92C66D31347B6B1")
    @Override
    public final ByteOrder order() {
ByteOrder var1B533639214E0AD13A9C318946B77D59_780607391 =         ByteOrder.nativeOrder();
        var1B533639214E0AD13A9C318946B77D59_780607391.addTaint(taint);
        return var1B533639214E0AD13A9C318946B77D59_780607391;
        
        
    }

    
}

