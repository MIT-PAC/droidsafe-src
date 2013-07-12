package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

abstract class FloatArrayBuffer extends FloatBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.499 -0400", hash_original_field = "8D50CD27AA8B6BEC65C484FFCC5B2334", hash_generated_field = "8679C1DDE03C0998C5B4254D7B007554")

    protected float[] backingArray;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.499 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "22BBBB3BDBDCD622FED3EBF1A70B4EC5")

    protected int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.499 -0400", hash_original_method = "D11EDAC27157134F6D93222FED96804A", hash_generated_method = "235954FFD5A65E27D2B4AC86646DAA42")
      FloatArrayBuffer(float[] array) {
        this(array.length, array, 0);
        addTaint(array[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.500 -0400", hash_original_method = "1F51B561748313656A83CE5668F8D726", hash_generated_method = "6ABAF8ACDB270E1271ACAA69FBF587EF")
      FloatArrayBuffer(int capacity) {
        this(capacity, new float[capacity], 0);
        addTaint(capacity);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.501 -0400", hash_original_method = "08256304DC715C68C786DDFF589B597E", hash_generated_method = "97450B9F3DF4B625F7689966430B11A4")
      FloatArrayBuffer(int capacity, float[] backingArray, int offset) {
        super(capacity);
        addTaint(capacity);
        this.backingArray = backingArray;
        this.offset = offset;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.501 -0400", hash_original_method = "27C2E9E0DC08E8F6369DBB2405A9C20A", hash_generated_method = "A08C335669B8486033F20EDA70E96419")
    @Override
    public final float get() {
    if(position == limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_557255408 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_557255408.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_557255408;
        } 
        float varD1A88672373807059A15983DE4C2AC9F_988633331 = (backingArray[offset + position++]);
                float var546ADE640B6EDFBC8A086EF31347E768_2081370713 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2081370713;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.501 -0400", hash_original_method = "7B23CE1A9B110702665631EFEB3A42BD", hash_generated_method = "C5FCAA394F8A01B02966D27FEB8AD259")
    @Override
    public final float get(int index) {
        addTaint(index);
        checkIndex(index);
        float varF4617D5762E2F642102CBB5F4FA87F0A_1927889421 = (backingArray[offset + index]);
                float var546ADE640B6EDFBC8A086EF31347E768_484515441 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_484515441;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.502 -0400", hash_original_method = "0E5CD729EA86ED4C8F1722765DDD0E33", hash_generated_method = "E18D7AD03D2BBF3CC9B56F2A4C2AC9FD")
    @Override
    public final FloatBuffer get(float[] dst, int dstOffset, int floatCount) {
        addTaint(floatCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
    if(floatCount > remaining())        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_1252486666 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_1252486666.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_1252486666;
        } 
        System.arraycopy(backingArray, offset + position, dst, dstOffset, floatCount);
        position += floatCount;
FloatBuffer var72A74007B2BE62B849F475C7BDA4658B_2005503457 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2005503457.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2005503457;
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.502 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "88E4D6336751C90307D6F35E26F35D24")
    @Override
    public final boolean isDirect() {
        boolean var68934A3E9455FA72420237EB05902327_1139477177 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_52440202 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_52440202;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.503 -0400", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "15FE45679CFB6AC20A738EF7E08B1CCD")
    @Override
    public final ByteOrder order() {
ByteOrder var1B533639214E0AD13A9C318946B77D59_872322139 =         ByteOrder.nativeOrder();
        var1B533639214E0AD13A9C318946B77D59_872322139.addTaint(taint);
        return var1B533639214E0AD13A9C318946B77D59_872322139;
        
        
    }

    
}

