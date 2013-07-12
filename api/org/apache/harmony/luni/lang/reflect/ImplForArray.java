package org.apache.harmony.luni.lang.reflect;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

public final class ImplForArray implements GenericArrayType {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.288 -0400", hash_original_field = "2B3D37BF85E68F44CAF08F0E8BE5B871", hash_generated_field = "E5C2178136BA4F8025942E6B948C4074")

    private Type componentType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.288 -0400", hash_original_method = "2027F862B9235E5067268A95F39519F4", hash_generated_method = "FF0AF6F4DC1AD0565714CE91EA701306")
    public  ImplForArray(Type componentType) {
        this.componentType = componentType;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.288 -0400", hash_original_method = "DF2F4D0FDA59F8B376BF76172F429ABC", hash_generated_method = "F20A02ABE43F362BED583FDD519EE0F7")
    public Type getGenericComponentType() {
        try 
        {
Type var02EBCB8B6C8A87B230261C6EC7F3F14C_1776809363 =             ((ImplForType)componentType).getResolvedType();
            var02EBCB8B6C8A87B230261C6EC7F3F14C_1776809363.addTaint(taint);
            return var02EBCB8B6C8A87B230261C6EC7F3F14C_1776809363;
        } 
        catch (ClassCastException e)
        {
Type var62B4DAC76A381C72E7C16DCF7E120C0E_1761714208 =             componentType;
            var62B4DAC76A381C72E7C16DCF7E120C0E_1761714208.addTaint(taint);
            return var62B4DAC76A381C72E7C16DCF7E120C0E_1761714208;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.289 -0400", hash_original_method = "4E93C574A33186DE87D5834EAA369B51", hash_generated_method = "BFB36E40CC2279A2A32B64E414F12BAF")
    public String toString() {
String varA243640258685B816D0B9D5AF9381898_539473302 =         componentType.toString() + "[]";
        varA243640258685B816D0B9D5AF9381898_539473302.addTaint(taint);
        return varA243640258685B816D0B9D5AF9381898_539473302;
        
        
    }

    
}

