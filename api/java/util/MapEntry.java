package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

class MapEntry<K, V> implements Map.Entry<K, V>, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.244 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "F780C5984CF24E477CB9559E91475987")

    K key;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.244 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "A7E8A049E4C72FD5713D3AFD6CBF7C08")

    V value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.244 -0400", hash_original_method = "1776FA5E19E8D82B200F9151CF90A74A", hash_generated_method = "CBCD735FCAC72B0E750457D5D44BE736")
      MapEntry(K theKey) {
        key = theKey;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.245 -0400", hash_original_method = "D494BFA0BCF5AB6B3E53FE04C11D2F42", hash_generated_method = "63672617A0FD25776E962F4E19FA2F6F")
      MapEntry(K theKey, V theValue) {
        key = theKey;
        value = theValue;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.245 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "8B30912E88C36EB725749935EDFEDE2C")
    @Override
    public Object clone() {
        try 
        {
Object var46F3A0D86742C1D6E099C2B166941A33_1882483393 =             super.clone();
            var46F3A0D86742C1D6E099C2B166941A33_1882483393.addTaint(taint);
            return var46F3A0D86742C1D6E099C2B166941A33_1882483393;
        } 
        catch (CloneNotSupportedException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_225859927 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_225859927.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_225859927;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.246 -0400", hash_original_method = "5E665954E6171F76B6FD9130152FC1D9", hash_generated_method = "ED623F74D3DF31AA826708C0B2E640DF")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
    if(this == object)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1728365881 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_508218977 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_508218977;
        } 
    if(object instanceof Map.Entry)        
        {
            Map.Entry<?, ?> entry = (Map.Entry<?, ?>) object;
            boolean varE99876168EF35BC1ABDF297288B8927B_112423659 = ((key == null ? entry.getKey() == null : key.equals(entry
                    .getKey()))
                    && (value == null ? entry.getValue() == null : value
                            .equals(entry.getValue())));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1792031051 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1792031051;
        } 
        boolean var68934A3E9455FA72420237EB05902327_998625005 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1836886449 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1836886449;
        
        
            
        
        
            
            
                    
                    
                            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.246 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "1F7CFBFC3FEE0BE85F2E842364ADFFEB")
    public K getKey() {
K var6A95247616A3A8B93CFF7783DABD08D4_621731468 =         key;
        var6A95247616A3A8B93CFF7783DABD08D4_621731468.addTaint(taint);
        return var6A95247616A3A8B93CFF7783DABD08D4_621731468;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.247 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "D00225FA57E4FFB49C767D892CA994AE")
    public V getValue() {
V varAF280DA2BC37D8BE783D8499160168DE_1876233294 =         value;
        varAF280DA2BC37D8BE783D8499160168DE_1876233294.addTaint(taint);
        return varAF280DA2BC37D8BE783D8499160168DE_1876233294;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.247 -0400", hash_original_method = "6416487D313DFCFD3052C01ADB883217", hash_generated_method = "491F0B580A9025238764F5CCBF84AD25")
    @Override
    public int hashCode() {
        int var313162C4C2DF85A4CBE27DEF0699C565_143312484 = ((key == null ? 0 : key.hashCode())
                ^ (value == null ? 0 : value.hashCode()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1564785666 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1564785666;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.247 -0400", hash_original_method = "123DAF07FFBE76C8EE5BD5879EB92827", hash_generated_method = "AAD55C3693F5CF8A529F7AEC09E9C2F6")
    public V setValue(V object) {
        V result = value;
        value = object;
V varDC838461EE2FA0CA4C9BBB70A15456B0_1544203432 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1544203432.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1544203432;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.248 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "32EC444F7B2E8D0AC3D460702ABBC30F")
    @Override
    public String toString() {
String varFE698C13EFD83B87FAF2DC2AB0874271_1208378628 =         key + "=" + value;
        varFE698C13EFD83B87FAF2DC2AB0874271_1208378628.addTaint(taint);
        return varFE698C13EFD83B87FAF2DC2AB0874271_1208378628;
        
        
    }

    
    interface Type<RT, KT, VT> {
        RT get(MapEntry<KT, VT> entry);
    }
    
}

