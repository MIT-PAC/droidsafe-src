package org.apache.harmony.luni.lang.reflect;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;




public final class ListOfTypes {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:17.015 -0500", hash_original_field = "3F1F6030BCDD98A28C66A50CDE6FA707", hash_generated_field = "E5BC5D3021F6BC63E6401C0642F71BC4")

    public static final ListOfTypes EMPTY = new ListOfTypes(0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:17.016 -0500", hash_original_field = "25EE3D1DF3EFF447F1E23307BE5924F7", hash_generated_field = "8892A3AAA12E491FA3A203DD834955E2")


    private  ArrayList<Type> types;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:17.017 -0500", hash_original_field = "D770CE609AEA02FF918F433C4A25BBD4", hash_generated_field = "87D7847847236888863F03CF45EBFAF0")

    private Type[] resolvedTypes;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:17.018 -0500", hash_original_method = "1B717CC03BB3C0AEB2AD5F80BAEDAB75", hash_generated_method = "1B717CC03BB3C0AEB2AD5F80BAEDAB75")
    ListOfTypes(int capacity) {
        types = new ArrayList<Type>(capacity);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:17.018 -0500", hash_original_method = "A3B43C45442B7BC58B3D5A9B17362DF9", hash_generated_method = "A3B43C45442B7BC58B3D5A9B17362DF9")
    ListOfTypes(Type[] types) {
        this.types = new ArrayList<Type>(types.length);
        for (Type type : types) {
            this.types.add(type);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:17.019 -0500", hash_original_method = "521B9354050D45CFE1C9313A9C3FFED0", hash_generated_method = "521B9354050D45CFE1C9313A9C3FFED0")
    void add(Type type) {
        if (type == null) {
            throw new NullPointerException("type == null");
        }
        types.add(type);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:17.020 -0500", hash_original_method = "5C54E587FAEC26FCFBB8E0F344888E86", hash_generated_method = "5C54E587FAEC26FCFBB8E0F344888E86")
    int length() {
        return types.size();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:17.021 -0500", hash_original_method = "631AD2F872BA627B3C9B69A500832CF8", hash_generated_method = "7C8FA95CDCE8FEEFD2611EA1DB9E4457")
    public Type[] getResolvedTypes() {
        Type[] result = resolvedTypes;
        return result != null ? result : (resolvedTypes = resolveTypes(types));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:17.022 -0500", hash_original_method = "F2767C6141E0603586233C8F8B50B3D9", hash_generated_method = "D4DD27393712A5F784F0C5FAEC33AC16")
    private Type[] resolveTypes(List<Type> unresolved) {
        Type[] result = new Type[unresolved.size()];
        for (int i = 0; i < unresolved.size(); i++) {
            Type type = unresolved.get(i);
            try {
                result[i] = ((ImplForType) type).getResolvedType();
            } catch (ClassCastException e) {
                result[i] = type;
            }
        }
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:17.023 -0500", hash_original_method = "E058D2B2430FADEC45CDF66AF212F70E", hash_generated_method = "C48B5FE2503511730C3FE65E0E6BFCB8")
    @Override
public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < types.size(); i++) {
            if (i > 0) {
                result.append(", ");
            }
            result.append(types.get(i));
        }
        return result.toString();
    }
}

