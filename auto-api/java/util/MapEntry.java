package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

class MapEntry<K, V> implements Map.Entry<K, V>, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.451 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "F780C5984CF24E477CB9559E91475987")

    K key;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.451 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "A7E8A049E4C72FD5713D3AFD6CBF7C08")

    V value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.452 -0400", hash_original_method = "1776FA5E19E8D82B200F9151CF90A74A", hash_generated_method = "CBCD735FCAC72B0E750457D5D44BE736")
      MapEntry(K theKey) {
        key = theKey;
        // ---------- Original Method ----------
        //key = theKey;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.461 -0400", hash_original_method = "D494BFA0BCF5AB6B3E53FE04C11D2F42", hash_generated_method = "63672617A0FD25776E962F4E19FA2F6F")
      MapEntry(K theKey, V theValue) {
        key = theKey;
        value = theValue;
        // ---------- Original Method ----------
        //key = theKey;
        //value = theValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.463 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "892E175615715522791DFDA223C1EA27")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_179445880 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_179445880 = super.clone();
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_179445880.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_179445880;
        // ---------- Original Method ----------
        //try {
            //return super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.465 -0400", hash_original_method = "5E665954E6171F76B6FD9130152FC1D9", hash_generated_method = "1E31D29A83166D1EEFC56E9CCFB75D22")
    @Override
    public boolean equals(Object object) {
        {
            Map.Entry<?, ?> entry;
            entry = (Map.Entry<?, ?>) object;
            boolean varA968BD7EB7991BA4A759E0255BB341DA_638279859 = ((key == null ? entry.getKey() == null : key.equals(entry
                    .getKey()))
                    && (value == null ? entry.getValue() == null : value
                            .equals(entry.getValue()))); //DSFIXME:  CODE0008: Nested ternary operator in expression
        } //End block
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_777350007 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_777350007;
        // ---------- Original Method ----------
        //if (this == object) {
            //return true;
        //}
        //if (object instanceof Map.Entry) {
            //Map.Entry<?, ?> entry = (Map.Entry<?, ?>) object;
            //return (key == null ? entry.getKey() == null : key.equals(entry
                    //.getKey()))
                    //&& (value == null ? entry.getValue() == null : value
                            //.equals(entry.getValue()));
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.466 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "E57CF4424D3A7D38B936E6291B05AEE7")
    public K getKey() {
        K varB4EAC82CA7396A68D541C85D26508E83_1507390645 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1507390645 = key;
        varB4EAC82CA7396A68D541C85D26508E83_1507390645.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1507390645;
        // ---------- Original Method ----------
        //return key;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.468 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "2E54DDD41B34AE584B63CD8C403889A6")
    public V getValue() {
        V varB4EAC82CA7396A68D541C85D26508E83_6314411 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_6314411 = value;
        varB4EAC82CA7396A68D541C85D26508E83_6314411.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_6314411;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.469 -0400", hash_original_method = "6416487D313DFCFD3052C01ADB883217", hash_generated_method = "7F81ACE9D52D8CD106933E0C05BDFBC2")
    @Override
    public int hashCode() {
        int var405BA182403049FF248011FD048FE4C0_865868409 = ((key == null ? 0 : key.hashCode())
                ^ (value == null ? 0 : value.hashCode())); //DSFIXME:  CODE0008: Nested ternary operator in expression
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_951582561 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_951582561;
        // ---------- Original Method ----------
        //return (key == null ? 0 : key.hashCode())
                //^ (value == null ? 0 : value.hashCode());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.470 -0400", hash_original_method = "123DAF07FFBE76C8EE5BD5879EB92827", hash_generated_method = "DBBAECA4C2AFD58A673665869300515D")
    public V setValue(V object) {
        V varB4EAC82CA7396A68D541C85D26508E83_641920622 = null; //Variable for return #1
        V result;
        result = value;
        value = object;
        varB4EAC82CA7396A68D541C85D26508E83_641920622 = result;
        varB4EAC82CA7396A68D541C85D26508E83_641920622.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_641920622;
        // ---------- Original Method ----------
        //V result = value;
        //value = object;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.470 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "25A33E7F814518D70335D835FF7F5C2C")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1576832330 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1576832330 = key + "=" + value;
        varB4EAC82CA7396A68D541C85D26508E83_1576832330.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1576832330;
        // ---------- Original Method ----------
        //return key + "=" + value;
    }

    
    interface Type<RT, KT, VT> {
        RT get(MapEntry<KT, VT> entry);
    }
    
}

