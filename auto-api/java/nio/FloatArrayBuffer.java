package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

abstract class FloatArrayBuffer extends FloatBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.318 -0400", hash_original_field = "8D50CD27AA8B6BEC65C484FFCC5B2334", hash_generated_field = "8679C1DDE03C0998C5B4254D7B007554")

    protected float[] backingArray;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.319 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "22BBBB3BDBDCD622FED3EBF1A70B4EC5")

    protected int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.319 -0400", hash_original_method = "D11EDAC27157134F6D93222FED96804A", hash_generated_method = "235954FFD5A65E27D2B4AC86646DAA42")
      FloatArrayBuffer(float[] array) {
        this(array.length, array, 0);
        addTaint(array[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.319 -0400", hash_original_method = "1F51B561748313656A83CE5668F8D726", hash_generated_method = "6ABAF8ACDB270E1271ACAA69FBF587EF")
      FloatArrayBuffer(int capacity) {
        this(capacity, new float[capacity], 0);
        addTaint(capacity);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.320 -0400", hash_original_method = "08256304DC715C68C786DDFF589B597E", hash_generated_method = "1F51DE0004CB02E198E539B87CD58BFF")
      FloatArrayBuffer(int capacity, float[] backingArray, int offset) {
        super(capacity);
        this.backingArray = backingArray;
        this.offset = offset;
        addTaint(capacity);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.320 -0400", hash_original_method = "27C2E9E0DC08E8F6369DBB2405A9C20A", hash_generated_method = "1F95EF0C65D113E9E1632460EA6950EE")
    @Override
    public final float get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } 
        float var546ADE640B6EDFBC8A086EF31347E768_2104960899 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2104960899;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.320 -0400", hash_original_method = "7B23CE1A9B110702665631EFEB3A42BD", hash_generated_method = "61CD4292FA9596729BA236DA6CDEBBCF")
    @Override
    public final float get(int index) {
        checkIndex(index);
        addTaint(index);
        float var546ADE640B6EDFBC8A086EF31347E768_1444946584 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1444946584;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.321 -0400", hash_original_method = "0E5CD729EA86ED4C8F1722765DDD0E33", hash_generated_method = "BAFC179FA0CB42F1F93574D654367896")
    @Override
    public final FloatBuffer get(float[] dst, int dstOffset, int floatCount) {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_373874222 = null; 
        {
            boolean varE021C2AFD91F3DCFB06333FB83FDE7E4_1664175404 = (floatCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
            } 
        } 
        System.arraycopy(backingArray, offset + position, dst, dstOffset, floatCount);
        position += floatCount;
        varB4EAC82CA7396A68D541C85D26508E83_373874222 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(floatCount);
        varB4EAC82CA7396A68D541C85D26508E83_373874222.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_373874222;
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.321 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "09828D3083E8B0F1E1419CBF3D30841A")
    @Override
    public final boolean isDirect() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1231688976 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1231688976;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.322 -0400", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "6104ACA7FD7E22F04A4A39CE2F352659")
    @Override
    public final ByteOrder order() {
        ByteOrder varB4EAC82CA7396A68D541C85D26508E83_1439256216 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1439256216 = ByteOrder.nativeOrder();
        varB4EAC82CA7396A68D541C85D26508E83_1439256216.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1439256216;
        
        
    }

    
}

