package org.apache.harmony.luni.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public final class ListOfTypes {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.377 -0400", hash_original_field = "D14A8022B085F9EF19D479CBDD581127", hash_generated_field = "8892A3AAA12E491FA3A203DD834955E2")

    private ArrayList<Type> types;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.377 -0400", hash_original_field = "9D3C508B350DACB1819B1B8FF8C2892F", hash_generated_field = "87D7847847236888863F03CF45EBFAF0")

    private Type[] resolvedTypes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.377 -0400", hash_original_method = "1B717CC03BB3C0AEB2AD5F80BAEDAB75", hash_generated_method = "4DC1BA96B5060DA9D761A0767EF562F5")
      ListOfTypes(int capacity) {
        types = new ArrayList<Type>(capacity);
        // ---------- Original Method ----------
        //types = new ArrayList<Type>(capacity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.378 -0400", hash_original_method = "A3B43C45442B7BC58B3D5A9B17362DF9", hash_generated_method = "33409140B4A821F97F1F5460E3F14A2E")
      ListOfTypes(Type[] types) {
        this.types = new ArrayList<Type>(types.length);
for(Type type : types)
        {
            this.types.add(type);
        } //End block
        // ---------- Original Method ----------
        //this.types = new ArrayList<Type>(types.length);
        //for (Type type : types) {
            //this.types.add(type);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.378 -0400", hash_original_method = "521B9354050D45CFE1C9313A9C3FFED0", hash_generated_method = "312AD3D581E88C7FB55ED722FD25999F")
     void add(Type type) {
        addTaint(type.getTaint());
    if(type == null)        
        {
            NullPointerException varCD4724072671F65422BAAD1C59E26C3D_1087910181 = new NullPointerException("type == null");
            varCD4724072671F65422BAAD1C59E26C3D_1087910181.addTaint(taint);
            throw varCD4724072671F65422BAAD1C59E26C3D_1087910181;
        } //End block
        types.add(type);
        // ---------- Original Method ----------
        //if (type == null) {
            //throw new NullPointerException("type == null");
        //}
        //types.add(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.378 -0400", hash_original_method = "5C54E587FAEC26FCFBB8E0F344888E86", hash_generated_method = "1FEEEC93F5A11973109C42B13B7E5712")
     int length() {
        int var09DE4273DF28F413F1060AF72C4E73F0_720585895 = (types.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2041653747 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2041653747;
        // ---------- Original Method ----------
        //return types.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.379 -0400", hash_original_method = "631AD2F872BA627B3C9B69A500832CF8", hash_generated_method = "A5956C4B329506009AAD4B2B18480B53")
    public Type[] getResolvedTypes() {
        Type[] result = resolvedTypes;
Type[] var4FC3DD720A833DD110402A8E8C2EB61B_513815630 =         result != null ? result : (resolvedTypes = resolveTypes(types));
        var4FC3DD720A833DD110402A8E8C2EB61B_513815630.addTaint(taint);
        return var4FC3DD720A833DD110402A8E8C2EB61B_513815630;
        // ---------- Original Method ----------
        //Type[] result = resolvedTypes;
        //return result != null ? result : (resolvedTypes = resolveTypes(types));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.379 -0400", hash_original_method = "F2767C6141E0603586233C8F8B50B3D9", hash_generated_method = "37819D61D0D3BB8B2AC8A079BFC29896")
    private Type[] resolveTypes(List<Type> unresolved) {
        addTaint(unresolved.getTaint());
        Type[] result = new Type[unresolved.size()];
for(int i = 0;i < unresolved.size();i++)
        {
            Type type = unresolved.get(i);
            try 
            {
                result[i] = ((ImplForType) type).getResolvedType();
            } //End block
            catch (ClassCastException e)
            {
                result[i] = type;
            } //End block
        } //End block
Type[] varDC838461EE2FA0CA4C9BBB70A15456B0_307896444 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_307896444.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_307896444;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.380 -0400", hash_original_method = "E058D2B2430FADEC45CDF66AF212F70E", hash_generated_method = "838C7103B60F947867ABCEE566E21F8B")
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
for(int i = 0;i < types.size();i++)
        {
    if(i > 0)            
            {
                result.append(", ");
            } //End block
            result.append(types.get(i));
        } //End block
String varE65B3A02759122992CB82C0E651AD408_890000765 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_890000765.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_890000765;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.380 -0400", hash_original_field = "BA2CE12BA025194CD2FA1EAB55E9AC2C", hash_generated_field = "E5BC5D3021F6BC63E6401C0642F71BC4")

    public static final ListOfTypes EMPTY = new ListOfTypes(0);
}

