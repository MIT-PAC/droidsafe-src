package org.apache.harmony.luni.lang.reflect;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;






public final class ImplForArray implements GenericArrayType {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.091 -0500", hash_original_field = "F00973532948845018B52A37FE021D3D", hash_generated_field = "E5C2178136BA4F8025942E6B948C4074")

    private  Type componentType;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.094 -0500", hash_original_method = "2027F862B9235E5067268A95F39519F4", hash_generated_method = "FF87340AB7A0B61B9F8FC14E23DB9FB4")
    
public ImplForArray(Type componentType) {
        this.componentType = componentType;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.096 -0500", hash_original_method = "DF2F4D0FDA59F8B376BF76172F429ABC", hash_generated_method = "F54BF30A1F49AEE5A1AF09CA296E86D0")
    
public Type getGenericComponentType() {
        try {
            return ((ImplForType)componentType).getResolvedType();
        } catch (ClassCastException e) {
            return componentType;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.098 -0500", hash_original_method = "4E93C574A33186DE87D5834EAA369B51", hash_generated_method = "406518163465E3F00AFF50CA1CF0EF49")
    
public String toString() {
        return componentType.toString() + "[]";
    }

    
}

