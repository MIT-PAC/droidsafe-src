package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

abstract class FloatArrayBuffer extends FloatBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.433 -0400", hash_original_field = "8D50CD27AA8B6BEC65C484FFCC5B2334", hash_generated_field = "8679C1DDE03C0998C5B4254D7B007554")

    protected float[] backingArray;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.433 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "22BBBB3BDBDCD622FED3EBF1A70B4EC5")

    protected int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.434 -0400", hash_original_method = "D11EDAC27157134F6D93222FED96804A", hash_generated_method = "235954FFD5A65E27D2B4AC86646DAA42")
      FloatArrayBuffer(float[] array) {
        this(array.length, array, 0);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.434 -0400", hash_original_method = "1F51B561748313656A83CE5668F8D726", hash_generated_method = "6ABAF8ACDB270E1271ACAA69FBF587EF")
      FloatArrayBuffer(int capacity) {
        this(capacity, new float[capacity], 0);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.451 -0400", hash_original_method = "08256304DC715C68C786DDFF589B597E", hash_generated_method = "1F51DE0004CB02E198E539B87CD58BFF")
      FloatArrayBuffer(int capacity, float[] backingArray, int offset) {
        super(capacity);
        this.backingArray = backingArray;
        this.offset = offset;
        addTaint(capacity);
        // ---------- Original Method ----------
        //this.backingArray = backingArray;
        //this.offset = offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.452 -0400", hash_original_method = "27C2E9E0DC08E8F6369DBB2405A9C20A", hash_generated_method = "D80EB578454492863E51EF153A0BD2B1")
    @Override
    public final float get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        float var546ADE640B6EDFBC8A086EF31347E768_1711169930 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1711169930;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return backingArray[offset + position++];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.452 -0400", hash_original_method = "7B23CE1A9B110702665631EFEB3A42BD", hash_generated_method = "5542841DB4F411D5AC533CADBFB71141")
    @Override
    public final float get(int index) {
        checkIndex(index);
        addTaint(index);
        float var546ADE640B6EDFBC8A086EF31347E768_1725905991 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1725905991;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return backingArray[offset + index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.453 -0400", hash_original_method = "0E5CD729EA86ED4C8F1722765DDD0E33", hash_generated_method = "B30C7D92F4F6E6F40AB4D857938DD9FB")
    @Override
    public final FloatBuffer get(float[] dst, int dstOffset, int floatCount) {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_80555939 = null; //Variable for return #1
        {
            boolean varE021C2AFD91F3DCFB06333FB83FDE7E4_1323765022 = (floatCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
            } //End block
        } //End collapsed parenthetic
        System.arraycopy(backingArray, offset + position, dst, dstOffset, floatCount);
        position += floatCount;
        varB4EAC82CA7396A68D541C85D26508E83_80555939 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(floatCount);
        varB4EAC82CA7396A68D541C85D26508E83_80555939.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_80555939;
        // ---------- Original Method ----------
        //if (floatCount > remaining()) {
            //throw new BufferUnderflowException();
        //}
        //System.arraycopy(backingArray, offset + position, dst, dstOffset, floatCount);
        //position += floatCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.454 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "628D0B0EBA243CBA87164A31C5ECE635")
    @Override
    public final boolean isDirect() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1782563977 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1782563977;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.455 -0400", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "B55904C8657A296F62B942A05F1DEE7C")
    @Override
    public final ByteOrder order() {
        ByteOrder varB4EAC82CA7396A68D541C85D26508E83_202452859 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_202452859 = ByteOrder.nativeOrder();
        varB4EAC82CA7396A68D541C85D26508E83_202452859.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_202452859;
        // ---------- Original Method ----------
        //return ByteOrder.nativeOrder();
    }

    
}

