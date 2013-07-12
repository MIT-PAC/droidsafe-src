package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

abstract class IntArrayBuffer extends IntBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.628 -0400", hash_original_field = "8D50CD27AA8B6BEC65C484FFCC5B2334", hash_generated_field = "04E795690AE1E5BC2E4466B25302D831")

    protected int[] backingArray;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.629 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "22BBBB3BDBDCD622FED3EBF1A70B4EC5")

    protected int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.629 -0400", hash_original_method = "D18B871637BEEEB2AE768346D692C9D7", hash_generated_method = "25468EA3ECB2C85286991D054DD5BEAB")
      IntArrayBuffer(int[] array) {
        this(array.length, array, 0);
        addTaint(array[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.629 -0400", hash_original_method = "64ADCEABF0045F3DCF099C9C9B4F7808", hash_generated_method = "F393261691B5336A002C11C65715A42E")
      IntArrayBuffer(int capacity) {
        this(capacity, new int[capacity], 0);
        addTaint(capacity);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.631 -0400", hash_original_method = "8D85757E2A089A86486F1DA1C7B27DB7", hash_generated_method = "8BB268A4C4257A422792D6B23437FFA3")
      IntArrayBuffer(int capacity, int[] backingArray, int offset) {
        super(capacity);
        addTaint(capacity);
        this.backingArray = backingArray;
        this.offset = offset;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.631 -0400", hash_original_method = "2EA67F38ECDA332174959B54F9DC216E", hash_generated_method = "DC0BF3CAF852BF9E99034A10DA53D591")
    @Override
    public final int get() {
    if(position == limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_709428500 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_709428500.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_709428500;
        } 
        int varD1A88672373807059A15983DE4C2AC9F_736352448 = (backingArray[offset + position++]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1191857330 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1191857330;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.632 -0400", hash_original_method = "BB46C2F433DB7E33613C9314C6AAA302", hash_generated_method = "0032B159D7FF7D9372CAD3EDDF6F836D")
    @Override
    public final int get(int index) {
        addTaint(index);
        checkIndex(index);
        int varF4617D5762E2F642102CBB5F4FA87F0A_2062639245 = (backingArray[offset + index]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_4524559 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_4524559;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.633 -0400", hash_original_method = "CF9BFE676211E932B27B1BA0A79794E4", hash_generated_method = "C2F17BE4492A254FCCC21A766EA44739")
    @Override
    public final IntBuffer get(int[] dst, int dstOffset, int intCount) {
        addTaint(intCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
    if(intCount > remaining())        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_24230712 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_24230712.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_24230712;
        } 
        System.arraycopy(backingArray, offset + position, dst, dstOffset, intCount);
        position += intCount;
IntBuffer var72A74007B2BE62B849F475C7BDA4658B_1334079230 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1334079230.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1334079230;
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.634 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "79D957BDC1ACE86A932C950A94F0D519")
    @Override
    public final boolean isDirect() {
        boolean var68934A3E9455FA72420237EB05902327_1428766608 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1050519626 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1050519626;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.634 -0400", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "7A7B2BF5E51F4AEFDBFEFBA8BBBBEDC1")
    @Override
    public final ByteOrder order() {
ByteOrder var1B533639214E0AD13A9C318946B77D59_1613725165 =         ByteOrder.nativeOrder();
        var1B533639214E0AD13A9C318946B77D59_1613725165.addTaint(taint);
        return var1B533639214E0AD13A9C318946B77D59_1613725165;
        
        
    }

    
}

