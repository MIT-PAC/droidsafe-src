package java.util;

// Droidsafe Imports
import droidsafe.annotations.*;



class MapEntry<K, V> implements Map.Entry<K, V>, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.237 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "F780C5984CF24E477CB9559E91475987")

    K key;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.237 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "A7E8A049E4C72FD5713D3AFD6CBF7C08")

    V value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.237 -0400", hash_original_method = "1776FA5E19E8D82B200F9151CF90A74A", hash_generated_method = "CBCD735FCAC72B0E750457D5D44BE736")
      MapEntry(K theKey) {
        key = theKey;
        // ---------- Original Method ----------
        //key = theKey;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.238 -0400", hash_original_method = "D494BFA0BCF5AB6B3E53FE04C11D2F42", hash_generated_method = "63672617A0FD25776E962F4E19FA2F6F")
      MapEntry(K theKey, V theValue) {
        key = theKey;
        value = theValue;
        // ---------- Original Method ----------
        //key = theKey;
        //value = theValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.238 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "8EDE7B69DC67A76DEE18F7FE424C3605")
    @Override
    public Object clone() {
        try 
        {
Object var46F3A0D86742C1D6E099C2B166941A33_1244014084 =             super.clone();
            var46F3A0D86742C1D6E099C2B166941A33_1244014084.addTaint(taint);
            return var46F3A0D86742C1D6E099C2B166941A33_1244014084;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_347571966 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_347571966.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_347571966;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.240 -0400", hash_original_method = "5E665954E6171F76B6FD9130152FC1D9", hash_generated_method = "8F54D8CB0924EDB88B9486C244E9FF8D")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        if(this == object)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1601737361 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_596827087 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_596827087;
        } //End block
        if(object instanceof Map.Entry)        
        {
            Map.Entry<?, ?> entry = (Map.Entry<?, ?>) object;
            boolean varE99876168EF35BC1ABDF297288B8927B_104817218 = ((key == null ? entry.getKey() == null : key.equals(entry
                    .getKey()))
                    && (value == null ? entry.getValue() == null : value
                            .equals(entry.getValue())));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1169621203 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1169621203;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1968934948 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1276739828 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1276739828;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.241 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "84EF349DA9FD804363B17C81E338B2E1")
    public K getKey() {
K var6A95247616A3A8B93CFF7783DABD08D4_460635772 =         key;
        var6A95247616A3A8B93CFF7783DABD08D4_460635772.addTaint(taint);
        return var6A95247616A3A8B93CFF7783DABD08D4_460635772;
        // ---------- Original Method ----------
        //return key;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.242 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "29A93CF1CC192CBE1C5203ACBDF756F0")
    public V getValue() {
V varAF280DA2BC37D8BE783D8499160168DE_415404468 =         value;
        varAF280DA2BC37D8BE783D8499160168DE_415404468.addTaint(taint);
        return varAF280DA2BC37D8BE783D8499160168DE_415404468;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.242 -0400", hash_original_method = "6416487D313DFCFD3052C01ADB883217", hash_generated_method = "5309D083F516B850AF99E539ED282614")
    @Override
    public int hashCode() {
        int var313162C4C2DF85A4CBE27DEF0699C565_211933150 = ((key == null ? 0 : key.hashCode())
                ^ (value == null ? 0 : value.hashCode()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1460014075 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1460014075;
        // ---------- Original Method ----------
        //return (key == null ? 0 : key.hashCode())
                //^ (value == null ? 0 : value.hashCode());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.243 -0400", hash_original_method = "123DAF07FFBE76C8EE5BD5879EB92827", hash_generated_method = "290CA4DDFCD3D88C3F29D74BFBA30D93")
    public V setValue(V object) {
        V result = value;
        value = object;
V varDC838461EE2FA0CA4C9BBB70A15456B0_1201748382 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1201748382.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1201748382;
        // ---------- Original Method ----------
        //V result = value;
        //value = object;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.243 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "92FE49A57458094FFFA068F5F96716B4")
    @Override
    public String toString() {
String varFE698C13EFD83B87FAF2DC2AB0874271_78369177 =         key + "=" + value;
        varFE698C13EFD83B87FAF2DC2AB0874271_78369177.addTaint(taint);
        return varFE698C13EFD83B87FAF2DC2AB0874271_78369177;
        // ---------- Original Method ----------
        //return key + "=" + value;
    }

    
    interface Type<RT, KT, VT> {
        RT get(MapEntry<KT, VT> entry);
    }
    
}

