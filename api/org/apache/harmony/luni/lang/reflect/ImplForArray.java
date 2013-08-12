package org.apache.harmony.luni.lang.reflect;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;






public final class ImplForArray implements GenericArrayType {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.927 -0400", hash_original_field = "2B3D37BF85E68F44CAF08F0E8BE5B871", hash_generated_field = "E5C2178136BA4F8025942E6B948C4074")

    private Type componentType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.928 -0400", hash_original_method = "2027F862B9235E5067268A95F39519F4", hash_generated_method = "FF0AF6F4DC1AD0565714CE91EA701306")
    public  ImplForArray(Type componentType) {
        this.componentType = componentType;
        // ---------- Original Method ----------
        //this.componentType = componentType;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.928 -0400", hash_original_method = "DF2F4D0FDA59F8B376BF76172F429ABC", hash_generated_method = "B0EA318D4CA3F6C9A3E93185BA8DB035")
    public Type getGenericComponentType() {
        try 
        {
Type var02EBCB8B6C8A87B230261C6EC7F3F14C_1956927436 =             ((ImplForType)componentType).getResolvedType();
            var02EBCB8B6C8A87B230261C6EC7F3F14C_1956927436.addTaint(taint);
            return var02EBCB8B6C8A87B230261C6EC7F3F14C_1956927436;
        } //End block
        catch (ClassCastException e)
        {
Type var62B4DAC76A381C72E7C16DCF7E120C0E_456818428 =             componentType;
            var62B4DAC76A381C72E7C16DCF7E120C0E_456818428.addTaint(taint);
            return var62B4DAC76A381C72E7C16DCF7E120C0E_456818428;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return ((ImplForType)componentType).getResolvedType();
        //} catch (ClassCastException e) {
            //return componentType;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.928 -0400", hash_original_method = "4E93C574A33186DE87D5834EAA369B51", hash_generated_method = "F9B8946FAF450819E8216E86433A5D3D")
    public String toString() {
String varA243640258685B816D0B9D5AF9381898_628835627 =         componentType.toString() + "[]";
        varA243640258685B816D0B9D5AF9381898_628835627.addTaint(taint);
        return varA243640258685B816D0B9D5AF9381898_628835627;
        // ---------- Original Method ----------
        //return componentType.toString() + "[]";
    }

    
}

