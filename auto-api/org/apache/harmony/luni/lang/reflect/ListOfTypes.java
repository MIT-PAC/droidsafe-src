package org.apache.harmony.luni.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public final class ListOfTypes {
    public static final ListOfTypes EMPTY = new ListOfTypes(0);
    private final ArrayList<Type> types;
    private Type[] resolvedTypes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.585 -0400", hash_original_method = "1B717CC03BB3C0AEB2AD5F80BAEDAB75", hash_generated_method = "B66AE5091B7B6A523D3A59258C40C856")
    @DSModeled(DSC.SAFE)
     ListOfTypes(int capacity) {
        dsTaint.addTaint(capacity);
        types = new ArrayList<Type>(capacity);
        // ---------- Original Method ----------
        //types = new ArrayList<Type>(capacity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.585 -0400", hash_original_method = "A3B43C45442B7BC58B3D5A9B17362DF9", hash_generated_method = "A646E9C067F1224C90D70747E95DDF6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ListOfTypes(Type[] types) {
        dsTaint.addTaint(types.dsTaint);
        this.types = new ArrayList<Type>(types.length);
        {
            Iterator<Type> seatecAstronomy42 = types.iterator();
            seatecAstronomy42.hasNext();
            Type type = seatecAstronomy42.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.586 -0400", hash_original_method = "521B9354050D45CFE1C9313A9C3FFED0", hash_generated_method = "71F555BC6BED95E16D53E5065C2A8D81")
    @DSModeled(DSC.SAFE)
     void add(Type type) {
        dsTaint.addTaint(type.dsTaint);
        {
            throw new NullPointerException("type == null");
        } //End block
        types.add(type);
        // ---------- Original Method ----------
        //if (type == null) {
            //throw new NullPointerException("type == null");
        //}
        //types.add(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.586 -0400", hash_original_method = "5C54E587FAEC26FCFBB8E0F344888E86", hash_generated_method = "75D5389CC26522B7D29D2BE1EA9547FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int length() {
        int var36D5E6EA8FBC745E7500AFF20661D660_1929752766 = (types.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return types.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.586 -0400", hash_original_method = "631AD2F872BA627B3C9B69A500832CF8", hash_generated_method = "818CF8C0578632C975EE5EDC5D7F2C97")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Type[] getResolvedTypes() {
        Type[] result;
        result = resolvedTypes;
        {
            Object var9A157EAA582B38E564A2D8D4EBD6576D_1085386022 = ((resolvedTypes = resolveTypes(types)));
        } //End flattened ternary
        return (Type[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //Type[] result = resolvedTypes;
        //return result != null ? result : (resolvedTypes = resolveTypes(types));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.586 -0400", hash_original_method = "F2767C6141E0603586233C8F8B50B3D9", hash_generated_method = "B532E6C2A549BA9BDCEF492386B9DF6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Type[] resolveTypes(List<Type> unresolved) {
        dsTaint.addTaint(unresolved.dsTaint);
        Type[] result;
        result = new Type[unresolved.size()];
        {
            int i;
            i = 0;
            boolean var4B6942D14B8B3CA4D1DDA3BF54081882_1384706588 = (i < unresolved.size());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.586 -0400", hash_original_method = "E058D2B2430FADEC45CDF66AF212F70E", hash_generated_method = "CB192E0448DF1A3352471E2A0ED13EF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder result;
        result = new StringBuilder();
        {
            int i;
            i = 0;
            boolean var5B2E9C78052F33E6158F587025879BF2_746072486 = (i < types.size());
            {
                {
                    result.append(", ");
                } //End block
                result.append(types.get(i));
            } //End block
        } //End collapsed parenthetic
        String varEA70154FDA28CC59402440C6317B57EF_1497926060 = (result.toString());
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

    
}


