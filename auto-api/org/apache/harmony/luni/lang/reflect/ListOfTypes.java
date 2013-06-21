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
    private ArrayList<Type> types;
    private Type[] resolvedTypes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.851 -0400", hash_original_method = "1B717CC03BB3C0AEB2AD5F80BAEDAB75", hash_generated_method = "6394BD71FBD7BBFAA8B5BDC9FF05B048")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ListOfTypes(int capacity) {
        dsTaint.addTaint(capacity);
        types = new ArrayList<Type>(capacity);
        // ---------- Original Method ----------
        //types = new ArrayList<Type>(capacity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.852 -0400", hash_original_method = "A3B43C45442B7BC58B3D5A9B17362DF9", hash_generated_method = "E9D378B58997D04869C098A7BBC594D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ListOfTypes(Type[] types) {
        dsTaint.addTaint(types[0].dsTaint);
        this.types = new ArrayList<Type>(types.length);
        {
            Iterator<Type> varFD80A5A4793194060697DC80455E19F0_628479132 = (types).iterator();
            varFD80A5A4793194060697DC80455E19F0_628479132.hasNext();
            Type type = varFD80A5A4793194060697DC80455E19F0_628479132.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.852 -0400", hash_original_method = "521B9354050D45CFE1C9313A9C3FFED0", hash_generated_method = "59DD43590C5E7AE6470C216E4E121075")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void add(Type type) {
        dsTaint.addTaint(type.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("type == null");
        } //End block
        types.add(type);
        // ---------- Original Method ----------
        //if (type == null) {
            //throw new NullPointerException("type == null");
        //}
        //types.add(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.852 -0400", hash_original_method = "5C54E587FAEC26FCFBB8E0F344888E86", hash_generated_method = "5C2668A054827A5E363A78F4BB02293C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int length() {
        int var36D5E6EA8FBC745E7500AFF20661D660_1481560161 = (types.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return types.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.853 -0400", hash_original_method = "631AD2F872BA627B3C9B69A500832CF8", hash_generated_method = "4B022ECFEE8EF4399267334F3586334A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Type[] getResolvedTypes() {
        Type[] result;
        result = resolvedTypes;
        {
            Object var9A157EAA582B38E564A2D8D4EBD6576D_1098994781 = ((resolvedTypes = resolveTypes(types)));
        } //End flattened ternary
        return (Type[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //Type[] result = resolvedTypes;
        //return result != null ? result : (resolvedTypes = resolveTypes(types));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.853 -0400", hash_original_method = "F2767C6141E0603586233C8F8B50B3D9", hash_generated_method = "4C9AADF2876A5CCED4CB326C21BECA30")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Type[] resolveTypes(List<Type> unresolved) {
        dsTaint.addTaint(unresolved.dsTaint);
        Type[] result;
        result = new Type[unresolved.size()];
        {
            int i;
            i = 0;
            boolean var4B6942D14B8B3CA4D1DDA3BF54081882_2048486548 = (i < unresolved.size());
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
        return (Type[])dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.853 -0400", hash_original_method = "E058D2B2430FADEC45CDF66AF212F70E", hash_generated_method = "BE524403F16B57EB56F6CFC19121A20C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder result;
        result = new StringBuilder();
        {
            int i;
            i = 0;
            boolean var5B2E9C78052F33E6158F587025879BF2_1981531752 = (i < types.size());
            {
                {
                    result.append(", ");
                } //End block
                result.append(types.get(i));
            } //End block
        } //End collapsed parenthetic
        String varEA70154FDA28CC59402440C6317B57EF_1892270333 = (result.toString());
        return dsTaint.getTaintString();
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

    
    public static final ListOfTypes EMPTY = new ListOfTypes(0);
}

