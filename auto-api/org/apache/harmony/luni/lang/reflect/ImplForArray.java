package org.apache.harmony.luni.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

public final class ImplForArray implements GenericArrayType {
    private Type componentType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.818 -0400", hash_original_method = "2027F862B9235E5067268A95F39519F4", hash_generated_method = "1E691A6AF40B4BB5FD890A0DB7BE2301")
    @DSModeled(DSC.SAFE)
    public ImplForArray(Type componentType) {
        dsTaint.addTaint(componentType.dsTaint);
        // ---------- Original Method ----------
        //this.componentType = componentType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.818 -0400", hash_original_method = "DF2F4D0FDA59F8B376BF76172F429ABC", hash_generated_method = "1830B1A171A8042D2D3C96892EBEBC21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Type getGenericComponentType() {
        try 
        {
            Type var18CCE467305EB676BC74CD66F6A508E5_1340561464 = (((ImplForType)componentType).getResolvedType());
        } //End block
        catch (ClassCastException e)
        { }
        return (Type)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return ((ImplForType)componentType).getResolvedType();
        //} catch (ClassCastException e) {
            //return componentType;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.818 -0400", hash_original_method = "4E93C574A33186DE87D5834EAA369B51", hash_generated_method = "C6A20A109BA38F32215E74CACA16D8C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String varEF4EC25839FDB716C03195031FF0C51A_1471890584 = (componentType.toString() + "[]");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return componentType.toString() + "[]";
    }

    
}

