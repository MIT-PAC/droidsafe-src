package org.apache.harmony.luni.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public final class ListOfTypes {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.007 -0400", hash_original_field = "D14A8022B085F9EF19D479CBDD581127", hash_generated_field = "8892A3AAA12E491FA3A203DD834955E2")

    private ArrayList<Type> types;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.007 -0400", hash_original_field = "9D3C508B350DACB1819B1B8FF8C2892F", hash_generated_field = "87D7847847236888863F03CF45EBFAF0")

    private Type[] resolvedTypes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.008 -0400", hash_original_method = "1B717CC03BB3C0AEB2AD5F80BAEDAB75", hash_generated_method = "4DC1BA96B5060DA9D761A0767EF562F5")
      ListOfTypes(int capacity) {
        types = new ArrayList<Type>(capacity);
        // ---------- Original Method ----------
        //types = new ArrayList<Type>(capacity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.011 -0400", hash_original_method = "A3B43C45442B7BC58B3D5A9B17362DF9", hash_generated_method = "066504CA947C4D2ABD44C073D016E503")
      ListOfTypes(Type[] types) {
        this.types = new ArrayList<Type>(types.length);
        {
            Iterator<Type> varFD80A5A4793194060697DC80455E19F0_1062566599 = (types).iterator();
            varFD80A5A4793194060697DC80455E19F0_1062566599.hasNext();
            Type type = varFD80A5A4793194060697DC80455E19F0_1062566599.next();
            {
                this.types.add(type);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //this.types = new ArrayList<Type>(types.length);
        //for (Type type : types) {
            //this.types.add(type);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.011 -0400", hash_original_method = "521B9354050D45CFE1C9313A9C3FFED0", hash_generated_method = "80E84AAB57486F37C62FE02D4C0D6EB9")
     void add(Type type) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("type == null");
        } //End block
        types.add(type);
        addTaint(type.getTaint());
        // ---------- Original Method ----------
        //if (type == null) {
            //throw new NullPointerException("type == null");
        //}
        //types.add(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.011 -0400", hash_original_method = "5C54E587FAEC26FCFBB8E0F344888E86", hash_generated_method = "A5688E928ECA066B93CDB8391DBEA374")
     int length() {
        int var36D5E6EA8FBC745E7500AFF20661D660_1714231910 = (types.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1584953487 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1584953487;
        // ---------- Original Method ----------
        //return types.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.013 -0400", hash_original_method = "631AD2F872BA627B3C9B69A500832CF8", hash_generated_method = "58EB0E28BD566C1345A276CC8B889056")
    public Type[] getResolvedTypes() {
        Type[] varB4EAC82CA7396A68D541C85D26508E83_253981705 = null; //Variable for return #1
        Type[] result;
        result = resolvedTypes;
        varB4EAC82CA7396A68D541C85D26508E83_253981705 = result != null ? result : (resolvedTypes = resolveTypes(types));
        varB4EAC82CA7396A68D541C85D26508E83_253981705.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_253981705;
        // ---------- Original Method ----------
        //Type[] result = resolvedTypes;
        //return result != null ? result : (resolvedTypes = resolveTypes(types));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.014 -0400", hash_original_method = "F2767C6141E0603586233C8F8B50B3D9", hash_generated_method = "6CCA769B8D35C0F789B28709CC268145")
    private Type[] resolveTypes(List<Type> unresolved) {
        Type[] varB4EAC82CA7396A68D541C85D26508E83_283129420 = null; //Variable for return #1
        Type[] result;
        result = new Type[unresolved.size()];
        {
            int i;
            i = 0;
            boolean var4B6942D14B8B3CA4D1DDA3BF54081882_852507879 = (i < unresolved.size());
            {
                Type type;
                type = unresolved.get(i);
                try 
                {
                    result[i] = ((ImplForType) type).getResolvedType();
                } //End block
                catch (ClassCastException e)
                {
                    result[i] = type;
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_283129420 = result;
        addTaint(unresolved.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_283129420.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_283129420;
        // ---------- Original Method ----------
        //Type[] result = new Type[unresolved.size()];
        //for (int i = 0; i < unresolved.size(); i++) {
            //Type type = unresolved.get(i);
            //try {
                //result[i] = ((ImplForType) type).getResolvedType();
            //} catch (ClassCastException e) {
                //result[i] = type;
            //}
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.015 -0400", hash_original_method = "E058D2B2430FADEC45CDF66AF212F70E", hash_generated_method = "A52290A833E7DE1698D58AA4A6AB8353")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_53249438 = null; //Variable for return #1
        StringBuilder result;
        result = new StringBuilder();
        {
            int i;
            i = 0;
            boolean var5B2E9C78052F33E6158F587025879BF2_1283544694 = (i < types.size());
            {
                {
                    result.append(", ");
                } //End block
                result.append(types.get(i));
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_53249438 = result.toString();
        varB4EAC82CA7396A68D541C85D26508E83_53249438.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_53249438;
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder();
        //for (int i = 0; i < types.size(); i++) {
            //if (i > 0) {
                //result.append(", ");
            //}
            //result.append(types.get(i));
        //}
        //return result.toString();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.015 -0400", hash_original_field = "BA2CE12BA025194CD2FA1EAB55E9AC2C", hash_generated_field = "E5BC5D3021F6BC63E6401C0642F71BC4")

    public static final ListOfTypes EMPTY = new ListOfTypes(0);
}

