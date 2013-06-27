package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

class MapEntry<K, V> implements Map.Entry<K, V>, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.252 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "F780C5984CF24E477CB9559E91475987")

    K key;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.252 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "A7E8A049E4C72FD5713D3AFD6CBF7C08")

    V value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.252 -0400", hash_original_method = "1776FA5E19E8D82B200F9151CF90A74A", hash_generated_method = "CBCD735FCAC72B0E750457D5D44BE736")
      MapEntry(K theKey) {
        key = theKey;
        // ---------- Original Method ----------
        //key = theKey;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.265 -0400", hash_original_method = "D494BFA0BCF5AB6B3E53FE04C11D2F42", hash_generated_method = "63672617A0FD25776E962F4E19FA2F6F")
      MapEntry(K theKey, V theValue) {
        key = theKey;
        value = theValue;
        // ---------- Original Method ----------
        //key = theKey;
        //value = theValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.266 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "6DAC717AF19FE2F77AE13CB03C7D7911")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1151692239 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1151692239 = super.clone();
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1151692239.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1151692239;
        // ---------- Original Method ----------
        //try {
            //return super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.266 -0400", hash_original_method = "5E665954E6171F76B6FD9130152FC1D9", hash_generated_method = "E7EA9614C0D4F4109408D7B2A912F189")
    @Override
    public boolean equals(Object object) {
        {
            Map.Entry<?, ?> entry;
            entry = (Map.Entry<?, ?>) object;
            boolean varA968BD7EB7991BA4A759E0255BB341DA_1162634817 = ((key == null ? entry.getKey() == null : key.equals(entry
                    .getKey()))
                    && (value == null ? entry.getValue() == null : value
                            .equals(entry.getValue()))); //DSFIXME:  CODE0008: Nested ternary operator in expression
        } //End block
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1296420727 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1296420727;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.267 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "1B847F19AE8A51DAB7E8B5CA22026737")
    public K getKey() {
        K varB4EAC82CA7396A68D541C85D26508E83_1084347825 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1084347825 = key;
        varB4EAC82CA7396A68D541C85D26508E83_1084347825.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1084347825;
        // ---------- Original Method ----------
        //return key;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.280 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "B78335949E2C28E89BE6E941EB598952")
    public V getValue() {
        V varB4EAC82CA7396A68D541C85D26508E83_1311594322 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1311594322 = value;
        varB4EAC82CA7396A68D541C85D26508E83_1311594322.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1311594322;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.281 -0400", hash_original_method = "6416487D313DFCFD3052C01ADB883217", hash_generated_method = "4F77049CBAF78CFDC76405A4C7A4A67E")
    @Override
    public int hashCode() {
        int var405BA182403049FF248011FD048FE4C0_1855270894 = ((key == null ? 0 : key.hashCode())
                ^ (value == null ? 0 : value.hashCode())); //DSFIXME:  CODE0008: Nested ternary operator in expression
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1060702267 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1060702267;
        // ---------- Original Method ----------
        //return (key == null ? 0 : key.hashCode())
                //^ (value == null ? 0 : value.hashCode());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.282 -0400", hash_original_method = "123DAF07FFBE76C8EE5BD5879EB92827", hash_generated_method = "231589D017DA883DB960A049A590CEB5")
    public V setValue(V object) {
        V varB4EAC82CA7396A68D541C85D26508E83_643587677 = null; //Variable for return #1
        V result;
        result = value;
        value = object;
        varB4EAC82CA7396A68D541C85D26508E83_643587677 = result;
        varB4EAC82CA7396A68D541C85D26508E83_643587677.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_643587677;
        // ---------- Original Method ----------
        //V result = value;
        //value = object;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.282 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "C1BBCA475DF76CD2937AFBC918F5FF5D")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_769838579 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_769838579 = key + "=" + value;
        varB4EAC82CA7396A68D541C85D26508E83_769838579.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_769838579;
        // ---------- Original Method ----------
        //return key + "=" + value;
    }

    
    interface Type<RT, KT, VT> {
        RT get(MapEntry<KT, VT> entry);
    }
    
}

