package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;

public class EnumMap<K extends Enum<K>, V> extends AbstractMap<K, V> implements Serializable, Cloneable, Map<K, V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.764 -0400", hash_original_field = "056E0360B75D77ECE0AE955FE59BF15D", hash_generated_field = "784B4CB2B0AA1435846B96ECF749418D")

    private Class<K> keyType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.764 -0400", hash_original_field = "14F802E1FBA977727845E8872C1743A7", hash_generated_field = "1296F5D01B4090600677F6D5CA1FE096")

    transient Enum[] keys;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.764 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "4150C40DB1D8CEF16DAAF4E72141B18D")

    transient Object[] values;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.764 -0400", hash_original_field = "EB33C464BB85B740774E660ED19A4D23", hash_generated_field = "2AFD2ACFCCD988AD1A9DB860BFAFC15E")

    transient boolean[] hasMapping;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.764 -0400", hash_original_field = "80ADFCE58E22D304D276F1C6D95D4EF2", hash_generated_field = "204CA002E2DD9253A57F08EEC28189B5")

    private transient int mappingsCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.764 -0400", hash_original_field = "2FF4AF744F4AEE0F57EA018EF3FA7088", hash_generated_field = "2AA1CC9DCAEA03EA6B04E81906ED8EEA")

    transient int enumSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.764 -0400", hash_original_field = "22D97DDA025E6292D4C7D4F7678A4EEA", hash_generated_field = "60757B7103C3702D9A64F686BFD44FCF")

    private transient EnumMapEntrySet<K, V> entrySet = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.765 -0400", hash_original_method = "357B463561F8F38F36CCB594B2B44169", hash_generated_method = "859B4E62287F3B6BA4AD35D4BB715F67")
    public  EnumMap(Class<K> keyType) {
        initialization(keyType);
        addTaint(keyType.getTaint());
        // ---------- Original Method ----------
        //initialization(keyType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.766 -0400", hash_original_method = "4FB74096ACFD3857AE5FA5EC3BFDBAC1", hash_generated_method = "4D95A42660BE79B089DA64C3EDD70A2D")
    public  EnumMap(EnumMap<K, ? extends V> map) {
        initialization(map);
        addTaint(map.getTaint());
        // ---------- Original Method ----------
        //initialization(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.766 -0400", hash_original_method = "D652AC252782A7206F7D0F46E9A22736", hash_generated_method = "B82681067DC0CED3EEB25872F70C7387")
    @SuppressWarnings("unchecked")
    public  EnumMap(Map<K, ? extends V> map) {
        {
            initialization((EnumMap<K, V>) map);
        } //End block
        {
            {
                boolean var25E2C4EEA885A5E03E8C4F2DC9C5AD7F_440839047 = (map.size() == 0);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
                } //End block
            } //End collapsed parenthetic
            Iterator<K> iter;
            iter = map.keySet().iterator();
            K enumKey;
            enumKey = iter.next();
            Class clazz;
            clazz = enumKey.getClass();
            {
                boolean var65B366502464B6D98F6AF940C135B000_1246913638 = (clazz.isEnum());
                {
                    initialization(clazz);
                } //End block
                {
                    initialization(clazz.getSuperclass());
                } //End block
            } //End collapsed parenthetic
            putAllImpl(map);
        } //End block
        addTaint(map.getTaint());
        // ---------- Original Method ----------
        //if (map instanceof EnumMap) {
            //initialization((EnumMap<K, V>) map);
        //} else {
            //if (map.size() == 0) {
                //throw new IllegalArgumentException();
            //}
            //Iterator<K> iter = map.keySet().iterator();
            //K enumKey = iter.next();
            //Class clazz = enumKey.getClass();
            //if (clazz.isEnum()) {
                //initialization(clazz);
            //} else {
                //initialization(clazz.getSuperclass());
            //}
            //putAllImpl(map);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.768 -0400", hash_original_method = "2976CFC6D7176D4F9EDBE7E00A9203F9", hash_generated_method = "B80AABDFA9194B1768A3A2F9D08F6AA8")
    @Override
    public void clear() {
        Arrays.fill(values, null);
        Arrays.fill(hasMapping, false);
        mappingsCount = 0;
        // ---------- Original Method ----------
        //Arrays.fill(values, null);
        //Arrays.fill(hasMapping, false);
        //mappingsCount = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.768 -0400", hash_original_method = "27D6CD5C74C8D110D14D6D471707F1DE", hash_generated_method = "7266318D43140E6EC38CE3F8912935F2")
    @SuppressWarnings("unchecked")
    @Override
    public EnumMap<K, V> clone() {
        EnumMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_81269336 = null; //Variable for return #1
        try 
        {
            EnumMap<K, V> enumMap;
            enumMap = (EnumMap<K, V>) super.clone();
            enumMap.initialization(this);
            varB4EAC82CA7396A68D541C85D26508E83_81269336 = enumMap;
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_81269336.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_81269336;
        // ---------- Original Method ----------
        //try {
            //EnumMap<K, V> enumMap = (EnumMap<K, V>) super.clone();
            //enumMap.initialization(this);
            //return enumMap;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.773 -0400", hash_original_method = "0E01365989D6BCC217AC6A8119B6F173", hash_generated_method = "E5A96BA54A33212E0FD3018CFA7CE35F")
    @Override
    public boolean containsKey(Object key) {
        {
            boolean var2881195E5753FB7F055ED20418F3E365_609739132 = (isValidKeyType(key));
            {
                int keyOrdinal;
                keyOrdinal = ((Enum) key).ordinal();
            } //End block
        } //End collapsed parenthetic
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1605999416 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1605999416;
        // ---------- Original Method ----------
        //if (isValidKeyType(key)) {
            //int keyOrdinal = ((Enum) key).ordinal();
            //return hasMapping[keyOrdinal];
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.778 -0400", hash_original_method = "FD4C7D9777FB1B3FC7F27A22C70B4A60", hash_generated_method = "EE550F97DF4E71C764ADCD354125A45E")
    @Override
    public boolean containsValue(Object value) {
        {
            {
                int i;
                i = 0;
            } //End collapsed parenthetic
        } //End block
        {
            {
                int i;
                i = 0;
                {
                    {
                        boolean var9645DA12622E821663F15BC1CC8202C0_2084235339 = (hasMapping[i] && value.equals(values[i]));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_206930090 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_206930090;
        // ---------- Original Method ----------
        //if (value == null) {
            //for (int i = 0; i < enumSize; i++) {
                //if (hasMapping[i] && values[i] == null) {
                    //return true;
                //}
            //}
        //} else {
            //for (int i = 0; i < enumSize; i++) {
                //if (hasMapping[i] && value.equals(values[i])) {
                    //return true;
                //}
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.778 -0400", hash_original_method = "1D25B0764045DBFAD19E9C060947BE81", hash_generated_method = "A0F5C370441B2F6EF7194755C5FA04D8")
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_804796389 = null; //Variable for return #1
        {
            entrySet = new EnumMapEntrySet<K, V>(this);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_804796389 = entrySet;
        varB4EAC82CA7396A68D541C85D26508E83_804796389.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_804796389;
        // ---------- Original Method ----------
        //if (entrySet == null) {
            //entrySet = new EnumMapEntrySet<K, V>(this);
        //}
        //return entrySet;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.779 -0400", hash_original_method = "AC8EB1BDF42FFE99FA259DC7FD35D677", hash_generated_method = "059E52503AE0FEF75D8D84E4A9C6D0A0")
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object object) {
        {
            boolean varA3157AA9BC21D9DE63321077403F3F07_733066276 = (super.equals(object));
        } //End block
        EnumMap<K, V> enumMap;
        enumMap = (EnumMap<K, V>) object;
        {
            boolean varD0EFCA813FC7B10D8353B658CADEDA24_557720773 = (keyType != enumMap.keyType || size() != enumMap.size());
        } //End collapsed parenthetic
        boolean var86C56C7BA36A8C7548B1E6C40C5BF1BD_377372075 = (Arrays.equals(hasMapping, enumMap.hasMapping)
                && Arrays.equals(values, enumMap.values));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_471978836 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_471978836;
        // ---------- Original Method ----------
        //if (this == object) {
            //return true;
        //}
        //if (!(object instanceof EnumMap)) {
            //return super.equals(object);
        //}
        //EnumMap<K, V> enumMap = (EnumMap<K, V>) object;
        //if (keyType != enumMap.keyType || size() != enumMap.size()) {
            //return false;
        //}
        //return Arrays.equals(hasMapping, enumMap.hasMapping)
                //&& Arrays.equals(values, enumMap.values);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.780 -0400", hash_original_method = "D1D1E4650582CB36D48A88314ACBD849", hash_generated_method = "1F1076692746A7114D53D3224A371E8E")
    @Override
    @SuppressWarnings("unchecked")
    public V get(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_1994620985 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_606088360 = null; //Variable for return #2
        {
            boolean varE7267BA1C950E6E221E46F63E7F428DF_814823770 = (!isValidKeyType(key));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1994620985 = null;
            } //End block
        } //End collapsed parenthetic
        int keyOrdinal;
        keyOrdinal = ((Enum) key).ordinal();
        varB4EAC82CA7396A68D541C85D26508E83_606088360 = (V) values[keyOrdinal];
        addTaint(key.getTaint());
        V varA7E53CE21691AB073D9660D615818899_1635651048; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1635651048 = varB4EAC82CA7396A68D541C85D26508E83_1994620985;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1635651048 = varB4EAC82CA7396A68D541C85D26508E83_606088360;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1635651048.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1635651048;
        // ---------- Original Method ----------
        //if (!isValidKeyType(key)) {
            //return null;
        //}
        //int keyOrdinal = ((Enum) key).ordinal();
        //return (V) values[keyOrdinal];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.781 -0400", hash_original_method = "ADC2E4F8D882C3AAF1D0303EAF8C1F23", hash_generated_method = "83E86581304424DDE75268BC568828AA")
    @Override
    public Set<K> keySet() {
        Set<K> varB4EAC82CA7396A68D541C85D26508E83_2045261066 = null; //Variable for return #1
        {
            keySet = new EnumMapKeySet<K, V>(this);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2045261066 = keySet;
        varB4EAC82CA7396A68D541C85D26508E83_2045261066.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2045261066;
        // ---------- Original Method ----------
        //if (keySet == null) {
            //keySet = new EnumMapKeySet<K, V>(this);
        //}
        //return keySet;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.781 -0400", hash_original_method = "0FAB728DBD67C753D3CD4965FE16DA6D", hash_generated_method = "BA0EAD376D668B70AF9A036E07125559")
    @Override
    @SuppressWarnings("unchecked")
    public V put(K key, V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_1553148596 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1553148596 = putImpl(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1553148596.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1553148596;
        // ---------- Original Method ----------
        //return putImpl(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.784 -0400", hash_original_method = "57B3987EA7E50826E0AAD0198F968E42", hash_generated_method = "90447D4153EA2A9592AA1B07C1905DF7")
    @Override
    @SuppressWarnings("unchecked")
    public void putAll(Map<? extends K, ? extends V> map) {
        putAllImpl(map);
        addTaint(map.getTaint());
        // ---------- Original Method ----------
        //putAllImpl(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.784 -0400", hash_original_method = "2531311459BDF6AE48398CDBD33066ED", hash_generated_method = "96CD66030C4AE17B44B49DAFE73E911F")
    @Override
    @SuppressWarnings("unchecked")
    public V remove(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_45203738 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_1441338204 = null; //Variable for return #2
        {
            boolean varE7267BA1C950E6E221E46F63E7F428DF_212120074 = (!isValidKeyType(key));
            {
                varB4EAC82CA7396A68D541C85D26508E83_45203738 = null;
            } //End block
        } //End collapsed parenthetic
        int keyOrdinal;
        keyOrdinal = ((Enum) key).ordinal();
        {
            hasMapping[keyOrdinal] = false;
        } //End block
        V oldValue;
        oldValue = (V) values[keyOrdinal];
        values[keyOrdinal] = null;
        varB4EAC82CA7396A68D541C85D26508E83_1441338204 = oldValue;
        addTaint(key.getTaint());
        V varA7E53CE21691AB073D9660D615818899_726736293; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_726736293 = varB4EAC82CA7396A68D541C85D26508E83_45203738;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_726736293 = varB4EAC82CA7396A68D541C85D26508E83_1441338204;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_726736293.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_726736293;
        // ---------- Original Method ----------
        //if (!isValidKeyType(key)) {
            //return null;
        //}
        //int keyOrdinal = ((Enum) key).ordinal();
        //if (hasMapping[keyOrdinal]) {
            //hasMapping[keyOrdinal] = false;
            //mappingsCount--;
        //}
        //V oldValue = (V) values[keyOrdinal];
        //values[keyOrdinal] = null;
        //return oldValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.789 -0400", hash_original_method = "9B5434C347C8B5979021C04F4F7D3AC0", hash_generated_method = "57DC9BF1A1234886BFDA0D2E05DDCA99")
    @Override
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_687260668 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_687260668;
        // ---------- Original Method ----------
        //return mappingsCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.789 -0400", hash_original_method = "3209B6B28BA147378CF80090EC868BEA", hash_generated_method = "2E65E88EF48B87080649DFE72FE7DB81")
    @Override
    public Collection<V> values() {
        Collection<V> varB4EAC82CA7396A68D541C85D26508E83_670653667 = null; //Variable for return #1
        {
            valuesCollection = new EnumMapValueCollection<K, V>(this);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_670653667 = valuesCollection;
        varB4EAC82CA7396A68D541C85D26508E83_670653667.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_670653667;
        // ---------- Original Method ----------
        //if (valuesCollection == null) {
            //valuesCollection = new EnumMapValueCollection<K, V>(this);
        //}
        //return valuesCollection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.790 -0400", hash_original_method = "DC4D5C48E92024F936CD723136F7EC43", hash_generated_method = "6CEDE98B7ECB1D7B785E5633120CC439")
    @SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        stream.defaultReadObject();
        initialization(keyType);
        int elementCount;
        elementCount = stream.readInt();
        Enum<K> enumKey;
        Object value;
        {
            int i;
            i = elementCount;
            {
                enumKey = (Enum<K>) stream.readObject();
                value = stream.readObject();
                putImpl((K) enumKey, (V) value);
            } //End block
        } //End collapsed parenthetic
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        //stream.defaultReadObject();
        //initialization(keyType);
        //int elementCount = stream.readInt();
        //Enum<K> enumKey;
        //Object value;
        //for (int i = elementCount; i > 0; i--) {
            //enumKey = (Enum<K>) stream.readObject();
            //value = stream.readObject();
            //putImpl((K) enumKey, (V) value);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.796 -0400", hash_original_method = "7E98F968D6A8FBC0CE4D31A606E7DB44", hash_generated_method = "E94193BA54F5BDC982B3D2C01910DEEA")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(mappingsCount);
        Iterator<Map.Entry<K, V>> iterator;
        iterator = entrySet().iterator();
        {
            boolean var15F7FE2AD7E10C613CA4B915023EF041_1344347365 = (iterator.hasNext());
            {
                Map.Entry<K, V> entry;
                entry = iterator.next();
                stream.writeObject(entry.getKey());
                stream.writeObject(entry.getValue());
            } //End block
        } //End collapsed parenthetic
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        //stream.defaultWriteObject();
        //stream.writeInt(mappingsCount);
        //Iterator<Map.Entry<K, V>> iterator = entrySet().iterator();
        //while (iterator.hasNext()) {
            //Map.Entry<K, V> entry = iterator.next();
            //stream.writeObject(entry.getKey());
            //stream.writeObject(entry.getValue());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.796 -0400", hash_original_method = "AB7EF2A62AD1394405351664F3033DEE", hash_generated_method = "4826C55BBF1DF388C746457E5F7563CE")
    private boolean isValidKeyType(Object key) {
        {
            boolean var747CFA0C5BD42E365CF87FEF40B6940C_1299828329 = (key != null && keyType.isInstance(key));
        } //End collapsed parenthetic
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1886541714 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1886541714;
        // ---------- Original Method ----------
        //if (key != null && keyType.isInstance(key)) {
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.802 -0400", hash_original_method = "E2B9C0EDB3E88C666CBFA70F3A732433", hash_generated_method = "D730116B98D134A16FDA01B3A791E739")
    @SuppressWarnings("unchecked")
    private void initialization(EnumMap enumMap) {
        keyType = enumMap.keyType;
        keys = enumMap.keys;
        enumSize = enumMap.enumSize;
        values = enumMap.values.clone();
        hasMapping = enumMap.hasMapping.clone();
        mappingsCount = enumMap.mappingsCount;
        // ---------- Original Method ----------
        //keyType = enumMap.keyType;
        //keys = enumMap.keys;
        //enumSize = enumMap.enumSize;
        //values = enumMap.values.clone();
        //hasMapping = enumMap.hasMapping.clone();
        //mappingsCount = enumMap.mappingsCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.803 -0400", hash_original_method = "74B7FF14F292272934F29B542A6B3535", hash_generated_method = "9FC8FBB551CD14785E1041E3AB443C0B")
    private void initialization(Class<K> type) {
        keyType = type;
        keys = Enum.getSharedConstants(keyType);
        enumSize = keys.length;
        values = new Object[enumSize];
        hasMapping = new boolean[enumSize];
        // ---------- Original Method ----------
        //keyType = type;
        //keys = Enum.getSharedConstants(keyType);
        //enumSize = keys.length;
        //values = new Object[enumSize];
        //hasMapping = new boolean[enumSize];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.812 -0400", hash_original_method = "394364EB9AA119D86D9EB30D7D288B77", hash_generated_method = "1ED0447C7D38022CC95A87EC77813E48")
    @SuppressWarnings("unchecked")
    private void putAllImpl(Map map) {
        Iterator iter;
        iter = map.entrySet().iterator();
        {
            boolean varADABAFEBBAB7E585DD903333BD7F20A8_1930083448 = (iter.hasNext());
            {
                Map.Entry entry;
                entry = (Map.Entry) iter.next();
                putImpl((K) entry.getKey(), (V) entry.getValue());
            } //End block
        } //End collapsed parenthetic
        addTaint(map.getTaint());
        // ---------- Original Method ----------
        //Iterator iter = map.entrySet().iterator();
        //while (iter.hasNext()) {
            //Map.Entry entry = (Map.Entry) iter.next();
            //putImpl((K) entry.getKey(), (V) entry.getValue());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.813 -0400", hash_original_method = "1C83BB92B4CC56A2EE4CEBB2A5F2E79E", hash_generated_method = "AD8432C284422FF63EC7229ACD6C98E2")
    @SuppressWarnings("unchecked")
    private V putImpl(K key, V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_1235420832 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        keyType.cast(key);
        int keyOrdinal;
        keyOrdinal = key.ordinal();
        {
            hasMapping[keyOrdinal] = true;
        } //End block
        V oldValue;
        oldValue = (V) values[keyOrdinal];
        values[keyOrdinal] = value;
        varB4EAC82CA7396A68D541C85D26508E83_1235420832 = oldValue;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1235420832.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1235420832;
        // ---------- Original Method ----------
        //if (key == null) {
            //throw new NullPointerException();
        //}
        //keyType.cast(key);
        //int keyOrdinal = key.ordinal();
        //if (!hasMapping[keyOrdinal]) {
            //hasMapping[keyOrdinal] = true;
            //mappingsCount++;
        //}
        //V oldValue = (V) values[keyOrdinal];
        //values[keyOrdinal] = value;
        //return oldValue;
    }

    
    private static class Entry<KT extends Enum<KT>, VT> extends MapEntry<KT, VT> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.813 -0400", hash_original_field = "0C2D76D104B4FBD56D5878F0C7B4948D", hash_generated_field = "2D3692AFCA37C24E228F49DBDE7EDE40")

        private EnumMap<KT, VT> enumMap;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.813 -0400", hash_original_field = "281858037F7DCF7ED49271BB92C60526", hash_generated_field = "1620EEB839396CD546E81EA24F66C13A")

        private int ordinal;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.818 -0400", hash_original_method = "04522B4DB01C65E7C5169DAAB9B0A8B0", hash_generated_method = "DA35C72F6F79331CC50CB441C0779B80")
          Entry(KT theKey, VT theValue, EnumMap<KT, VT> em) {
            super(theKey, theValue);
            enumMap = em;
            ordinal = ((Enum) theKey).ordinal();
            addTaint(theValue.getTaint());
            // ---------- Original Method ----------
            //enumMap = em;
            //ordinal = ((Enum) theKey).ordinal();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.819 -0400", hash_original_method = "8DD0429C812BC3CB5F9E4D12A50ED42A", hash_generated_method = "B1D2F92B538B1B725BC64E66279F6ED1")
        @SuppressWarnings("unchecked")
        @Override
        public boolean equals(Object object) {
            boolean isEqual;
            isEqual = false;
            {
                Map.Entry<KT, VT> entry;
                entry = (Map.Entry<KT, VT>) object;
                Object enumKey;
                enumKey = entry.getKey();
                {
                    boolean var3FA36501E027AB1388F65D474C9CD126_1356118674 = (key.equals(enumKey));
                    {
                        Object theValue;
                        theValue = entry.getValue();
                        {
                            isEqual = (theValue == null);
                        } //End block
                        {
                            isEqual = enumMap.values[ordinal].equals(theValue);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1695421639 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1695421639;
            // ---------- Original Method ----------
            //if (!enumMap.hasMapping[ordinal]) {
                //return false;
            //}
            //boolean isEqual = false;
            //if (object instanceof Map.Entry) {
                //Map.Entry<KT, VT> entry = (Map.Entry<KT, VT>) object;
                //Object enumKey = entry.getKey();
                //if (key.equals(enumKey)) {
                    //Object theValue = entry.getValue();
                    //if (enumMap.values[ordinal] == null) {
                        //isEqual = (theValue == null);
                    //} else {
                        //isEqual = enumMap.values[ordinal].equals(theValue);
                    //}
                //}
            //}
            //return isEqual;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.824 -0400", hash_original_method = "1D3BE2C1E2DBC9C20DAD39B42D607656", hash_generated_method = "30D5C1A38F3B3A02DC147BB42528481D")
        @Override
        public int hashCode() {
            int var335CA3F4B5A3CBFD417F696F0F465E58_623750418 = ((enumMap.keys[ordinal] == null ? 0 : enumMap.keys[ordinal]
                    .hashCode())
                    ^ (enumMap.values[ordinal] == null ? 0
                            : enumMap.values[ordinal].hashCode())); //DSFIXME:  CODE0008: Nested ternary operator in expression
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_255509349 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_255509349;
            // ---------- Original Method ----------
            //return (enumMap.keys[ordinal] == null ? 0 : enumMap.keys[ordinal]
                    //.hashCode())
                    //^ (enumMap.values[ordinal] == null ? 0
                            //: enumMap.values[ordinal].hashCode());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.827 -0400", hash_original_method = "E6F3009D3E7934C3E89ABA04C91C1657", hash_generated_method = "B89E01D515B560B1405536F4C5A4A382")
        @SuppressWarnings("unchecked")
        @Override
        public KT getKey() {
            KT varB4EAC82CA7396A68D541C85D26508E83_1302596497 = null; //Variable for return #1
            checkEntryStatus();
            varB4EAC82CA7396A68D541C85D26508E83_1302596497 = (KT) enumMap.keys[ordinal];
            varB4EAC82CA7396A68D541C85D26508E83_1302596497.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1302596497;
            // ---------- Original Method ----------
            //checkEntryStatus();
            //return (KT) enumMap.keys[ordinal];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.828 -0400", hash_original_method = "F5CFE00A2E55AC6B5D81DB2B62FB299C", hash_generated_method = "6B26DD95C02D952E48559CF49BBC87CD")
        @SuppressWarnings("unchecked")
        @Override
        public VT getValue() {
            VT varB4EAC82CA7396A68D541C85D26508E83_1624246868 = null; //Variable for return #1
            checkEntryStatus();
            varB4EAC82CA7396A68D541C85D26508E83_1624246868 = (VT) enumMap.values[ordinal];
            varB4EAC82CA7396A68D541C85D26508E83_1624246868.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1624246868;
            // ---------- Original Method ----------
            //checkEntryStatus();
            //return (VT) enumMap.values[ordinal];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.828 -0400", hash_original_method = "2B70B6F95ECF307373567A039C54EE32", hash_generated_method = "E9B481C0D1DE215301E17AD8B73B23CB")
        @SuppressWarnings("unchecked")
        @Override
        public VT setValue(VT value) {
            VT varB4EAC82CA7396A68D541C85D26508E83_1413968975 = null; //Variable for return #1
            checkEntryStatus();
            varB4EAC82CA7396A68D541C85D26508E83_1413968975 = enumMap.put((KT) enumMap.keys[ordinal], value);
            addTaint(value.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1413968975.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1413968975;
            // ---------- Original Method ----------
            //checkEntryStatus();
            //return enumMap.put((KT) enumMap.keys[ordinal], value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.829 -0400", hash_original_method = "7B70A2A5E5AF6D0A4A4180BECB8A721B", hash_generated_method = "D77B906B24C080B5F9D0141FB5A3A5E6")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_2064276318 = null; //Variable for return #1
            StringBuilder result;
            result = new StringBuilder(enumMap.keys[ordinal]
                    .toString());
            result.append("=");
            result.append(enumMap.values[ordinal] == null
                    ? "null" : enumMap.values[ordinal].toString());
            varB4EAC82CA7396A68D541C85D26508E83_2064276318 = result.toString();
            varB4EAC82CA7396A68D541C85D26508E83_2064276318.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2064276318;
            // ---------- Original Method ----------
            //StringBuilder result = new StringBuilder(enumMap.keys[ordinal]
                    //.toString());
            //result.append("=");
            //result.append(enumMap.values[ordinal] == null
                    //? "null" : enumMap.values[ordinal].toString());
            //return result.toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.829 -0400", hash_original_method = "D6BC45043628808E78169E86857FDCA6", hash_generated_method = "8038D89382E041C2E7CD0D2C11997BDD")
        private void checkEntryStatus() {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            } //End block
            // ---------- Original Method ----------
            //if (!enumMap.hasMapping[ordinal]) {
                //throw new IllegalStateException();
            //}
        }

        
    }


    
    private static class EnumMapIterator<E, KT extends Enum<KT>, VT> implements Iterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.829 -0400", hash_original_field = "64F8FBF9ECD410CCCCA37B900774D128", hash_generated_field = "B0CD1B3F8E4067A68C294939F6EB1E36")

        int position = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.829 -0400", hash_original_field = "77548F33E0633F26B4CA86617FB59DA9", hash_generated_field = "3A5C61B7C027E04C48479D5037A2A070")

        int prePosition = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.829 -0400", hash_original_field = "0C2D76D104B4FBD56D5878F0C7B4948D", hash_generated_field = "7727A7369BF41381EE0BE2DFDA995DE4")

        EnumMap<KT, VT> enumMap;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.829 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "32CBE0E3CB6327A7B40B9B82E058EE9D")

        MapEntry.Type<E, KT, VT> type;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.836 -0400", hash_original_method = "9ED4E2039768E2794B08864F6EFD4280", hash_generated_method = "833B8AD483E734D37A90F49EA36161A4")
          EnumMapIterator(MapEntry.Type<E, KT, VT> value, EnumMap<KT, VT> em) {
            enumMap = em;
            type = value;
            // ---------- Original Method ----------
            //enumMap = em;
            //type = value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.837 -0400", hash_original_method = "6D6AB5C8509128D2C00828238AD4C0D9", hash_generated_method = "0EA9C8583D3B1A3502E87C9BF88D3D6C")
        public boolean hasNext() {
            int length;
            length = enumMap.enumSize;
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_845190483 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_845190483;
            // ---------- Original Method ----------
            //int length = enumMap.enumSize;
            //for (; position < length; position++) {
                //if (enumMap.hasMapping[position]) {
                    //break;
                //}
            //}
            //return position != length;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.841 -0400", hash_original_method = "8136BC21B836EBF6A2416BD2D7F3270E", hash_generated_method = "E73B36F41F5491D33702C4FF74E739A8")
        @SuppressWarnings("unchecked")
        public E next() {
            E varB4EAC82CA7396A68D541C85D26508E83_136818485 = null; //Variable for return #1
            {
                boolean var61E0EA93C8F2038A69462393E2D5DF33_2058573662 = (!hasNext());
                {
                    if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                } //End block
            } //End collapsed parenthetic
            prePosition = position++;
            varB4EAC82CA7396A68D541C85D26508E83_136818485 = type.get(new MapEntry(enumMap.keys[prePosition],
                    enumMap.values[prePosition]));
            varB4EAC82CA7396A68D541C85D26508E83_136818485.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_136818485;
            // ---------- Original Method ----------
            //if (!hasNext()) {
                //throw new NoSuchElementException();
            //}
            //prePosition = position++;
            //return type.get(new MapEntry(enumMap.keys[prePosition],
                    //enumMap.values[prePosition]));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.842 -0400", hash_original_method = "A29557D70FF021A737315678DDBC3059", hash_generated_method = "022234A89EDA9DECBBFDD48346827F6C")
        public void remove() {
            checkStatus();
            {
                enumMap.remove(enumMap.keys[prePosition]);
            } //End block
            prePosition = -1;
            // ---------- Original Method ----------
            //checkStatus();
            //if (enumMap.hasMapping[prePosition]) {
                //enumMap.remove(enumMap.keys[prePosition]);
            //}
            //prePosition = -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.842 -0400", hash_original_method = "D4FD3F1C9995E81E934F03FC5256A25C", hash_generated_method = "E42FB7BE21C4F0A4921E57A34F65251C")
        @Override
        @SuppressWarnings("unchecked")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_506706706 = null; //Variable for return #1
            String varB4EAC82CA7396A68D541C85D26508E83_387791547 = null; //Variable for return #2
            {
                varB4EAC82CA7396A68D541C85D26508E83_506706706 = super.toString();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_387791547 = type.get(
                    new MapEntry(enumMap.keys[prePosition],
                            enumMap.values[prePosition])).toString();
            String varA7E53CE21691AB073D9660D615818899_682475672; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_682475672 = varB4EAC82CA7396A68D541C85D26508E83_506706706;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_682475672 = varB4EAC82CA7396A68D541C85D26508E83_387791547;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_682475672.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_682475672;
            // ---------- Original Method ----------
            //if (-1 == prePosition) {
                //return super.toString();
            //}
            //return type.get(
                    //new MapEntry(enumMap.keys[prePosition],
                            //enumMap.values[prePosition])).toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.842 -0400", hash_original_method = "8DC9DAAEB887A2B3089BD6592C09E5DA", hash_generated_method = "550AE755F21ED782D17504DB2A2A7655")
        private void checkStatus() {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            } //End block
            // ---------- Original Method ----------
            //if (-1 == prePosition) {
                //throw new IllegalStateException();
            //}
        }

        
    }


    
    private static class EnumMapKeySet<KT extends Enum<KT>, VT> extends AbstractSet<KT> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.843 -0400", hash_original_field = "0C2D76D104B4FBD56D5878F0C7B4948D", hash_generated_field = "2D3692AFCA37C24E228F49DBDE7EDE40")

        private EnumMap<KT, VT> enumMap;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.843 -0400", hash_original_method = "2A1696B691A1F64388AB3AC9907332E4", hash_generated_method = "F2ECC98C583C95B1C2F72BFAEFD592CC")
          EnumMapKeySet(EnumMap<KT, VT> em) {
            enumMap = em;
            // ---------- Original Method ----------
            //enumMap = em;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.843 -0400", hash_original_method = "C3DE5D46C4F9CFEF3C6B4695838239E5", hash_generated_method = "063732887140DDE2D3345C92C7674BBE")
        @Override
        public void clear() {
            enumMap.clear();
            // ---------- Original Method ----------
            //enumMap.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.847 -0400", hash_original_method = "434CC1CFD8E42092C734D9BD095515B9", hash_generated_method = "49437C2BDFFB8F4D9EB2EA39066DABEC")
        @Override
        public boolean contains(Object object) {
            boolean varE1D05B251B8CFF246CADE02385321F75_1047706661 = (enumMap.containsKey(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1910162021 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1910162021;
            // ---------- Original Method ----------
            //return enumMap.containsKey(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.848 -0400", hash_original_method = "A4EABEDB06E5BDF24065F571F359AF57", hash_generated_method = "049EB5871B332D3026CE7606C9B5E1DF")
        @Override
        @SuppressWarnings("unchecked")
        public Iterator iterator() {
            Iterator varB4EAC82CA7396A68D541C85D26508E83_1713387679 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1713387679 = new EnumMapIterator<KT, KT, VT>(
                    new MapEntry.Type<KT, KT, VT>() {
                        public KT get(MapEntry<KT, VT> entry) {
                            return entry.key;
                        }
                    }, enumMap);
            varB4EAC82CA7396A68D541C85D26508E83_1713387679.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1713387679;
            // ---------- Original Method ----------
            //return new EnumMapIterator<KT, KT, VT>(
                    //new MapEntry.Type<KT, KT, VT>() {
                        //public KT get(MapEntry<KT, VT> entry) {
                            //return entry.key;
                        //}
                    //}, enumMap);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.853 -0400", hash_original_method = "B8F9F39AE912D64223C40421DFD1515A", hash_generated_method = "0A9A100B0D993523C6CAAF6EF4CAA057")
        @Override
        @SuppressWarnings("unchecked")
        public boolean remove(Object object) {
            {
                boolean var4F9267015FE86EBB3F33114954B93ED1_1219936409 = (contains(object));
                {
                    enumMap.remove(object);
                } //End block
            } //End collapsed parenthetic
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1509305078 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1509305078;
            // ---------- Original Method ----------
            //if (contains(object)) {
                //enumMap.remove(object);
                //return true;
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.853 -0400", hash_original_method = "C9EE7DD74ED1B4234C539DA28C6D21A7", hash_generated_method = "0E9D7544019885D4F4A5934555345F3D")
        @Override
        public int size() {
            int varF8250C8AC739D0318AEF09F1AC34F78B_647587130 = (enumMap.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1854765905 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1854765905;
            // ---------- Original Method ----------
            //return enumMap.size();
        }

        
    }


    
    private static class EnumMapValueCollection<KT extends Enum<KT>, VT> extends AbstractCollection<VT> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.854 -0400", hash_original_field = "0C2D76D104B4FBD56D5878F0C7B4948D", hash_generated_field = "2D3692AFCA37C24E228F49DBDE7EDE40")

        private EnumMap<KT, VT> enumMap;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.854 -0400", hash_original_method = "1A0661F4095C8F41E606FE019F34B01E", hash_generated_method = "E5ABA9176789D0F83D15C4076A2F1270")
          EnumMapValueCollection(EnumMap<KT, VT> em) {
            enumMap = em;
            // ---------- Original Method ----------
            //enumMap = em;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.854 -0400", hash_original_method = "C3DE5D46C4F9CFEF3C6B4695838239E5", hash_generated_method = "063732887140DDE2D3345C92C7674BBE")
        @Override
        public void clear() {
            enumMap.clear();
            // ---------- Original Method ----------
            //enumMap.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.864 -0400", hash_original_method = "F0FBCB059002559902B972108CF0BABE", hash_generated_method = "EADD1260552EF80886DEDFBFEE1BAE2F")
        @Override
        public boolean contains(Object object) {
            boolean var2DAB091BFC98C0153936AB7B719C95FF_546305172 = (enumMap.containsValue(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1243818043 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1243818043;
            // ---------- Original Method ----------
            //return enumMap.containsValue(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.865 -0400", hash_original_method = "BC6C06395E1460CC49F247C03E1763F0", hash_generated_method = "82E6ADE4EDBE3DE278B8743E9F33894F")
        @SuppressWarnings("unchecked")
        @Override
        public Iterator iterator() {
            Iterator varB4EAC82CA7396A68D541C85D26508E83_1069807836 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1069807836 = new EnumMapIterator<VT, KT, VT>(
                    new MapEntry.Type<VT, KT, VT>() {
                        public VT get(MapEntry<KT, VT> entry) {
                            return entry.value;
                        }
                    }, enumMap);
            varB4EAC82CA7396A68D541C85D26508E83_1069807836.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1069807836;
            // ---------- Original Method ----------
            //return new EnumMapIterator<VT, KT, VT>(
                    //new MapEntry.Type<VT, KT, VT>() {
                        //public VT get(MapEntry<KT, VT> entry) {
                            //return entry.value;
                        //}
                    //}, enumMap);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.870 -0400", hash_original_method = "47E37FB3671E07CE32BC2BA28A816FCA", hash_generated_method = "855B1FD54038C677694DEADFFCCE8B7D")
        @Override
        public boolean remove(Object object) {
            {
                {
                    int i;
                    i = 0;
                    {
                        {
                            enumMap.remove(enumMap.keys[i]);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    int i;
                    i = 0;
                    {
                        {
                            boolean var37BC2A140D0EB4ED70B9893BBE73815F_1762839623 = (enumMap.hasMapping[i]
                            && object.equals(enumMap.values[i]));
                            {
                                enumMap.remove(enumMap.keys[i]);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1117160122 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1117160122;
            // ---------- Original Method ----------
            //if (object == null) {
                //for (int i = 0; i < enumMap.enumSize; i++) {
                    //if (enumMap.hasMapping[i] && enumMap.values[i] == null) {
                        //enumMap.remove(enumMap.keys[i]);
                        //return true;
                    //}
                //}
            //} else {
                //for (int i = 0; i < enumMap.enumSize; i++) {
                    //if (enumMap.hasMapping[i]
                            //&& object.equals(enumMap.values[i])) {
                        //enumMap.remove(enumMap.keys[i]);
                        //return true;
                    //}
                //}
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.871 -0400", hash_original_method = "C9EE7DD74ED1B4234C539DA28C6D21A7", hash_generated_method = "4E7EDC7B709625C9BFF60286F9E191AF")
        @Override
        public int size() {
            int varF8250C8AC739D0318AEF09F1AC34F78B_405082511 = (enumMap.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_529285802 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_529285802;
            // ---------- Original Method ----------
            //return enumMap.size();
        }

        
    }


    
    private static class EnumMapEntryIterator<E, KT extends Enum<KT>, VT> extends EnumMapIterator<E, KT, VT> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.871 -0400", hash_original_method = "4B20A4930FDD81120A40D2421C6DB306", hash_generated_method = "9C5201D72293FD6623A70488883B34A9")
          EnumMapEntryIterator(MapEntry.Type<E, KT, VT> value, EnumMap<KT, VT> em) {
            super(value, em);
            addTaint(value.getTaint());
            addTaint(em.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.872 -0400", hash_original_method = "AA0A985577200C3410BBA8066828BEEB", hash_generated_method = "99585CCE949017709218BD2143B68709")
        @SuppressWarnings("unchecked")
        @Override
        public E next() {
            E varB4EAC82CA7396A68D541C85D26508E83_1852210145 = null; //Variable for return #1
            {
                boolean var61E0EA93C8F2038A69462393E2D5DF33_1896110435 = (!hasNext());
                {
                    if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                } //End block
            } //End collapsed parenthetic
            prePosition = position++;
            varB4EAC82CA7396A68D541C85D26508E83_1852210145 = type.get(new Entry<KT, VT>((KT) enumMap.keys[prePosition],
                    (VT) enumMap.values[prePosition], enumMap));
            varB4EAC82CA7396A68D541C85D26508E83_1852210145.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1852210145;
            // ---------- Original Method ----------
            //if (!hasNext()) {
                //throw new NoSuchElementException();
            //}
            //prePosition = position++;
            //return type.get(new Entry<KT, VT>((KT) enumMap.keys[prePosition],
                    //(VT) enumMap.values[prePosition], enumMap));
        }

        
    }


    
    private static class EnumMapEntrySet<KT extends Enum<KT>, VT> extends AbstractSet<Map.Entry<KT, VT>> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.872 -0400", hash_original_field = "0C2D76D104B4FBD56D5878F0C7B4948D", hash_generated_field = "2D3692AFCA37C24E228F49DBDE7EDE40")

        private EnumMap<KT, VT> enumMap;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.872 -0400", hash_original_method = "616E4B9747EFF9433BD58C5F15DEC121", hash_generated_method = "D78FC31B5B25F7A257282F3524D220D6")
          EnumMapEntrySet(EnumMap<KT, VT> em) {
            enumMap = em;
            // ---------- Original Method ----------
            //enumMap = em;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.877 -0400", hash_original_method = "C3DE5D46C4F9CFEF3C6B4695838239E5", hash_generated_method = "063732887140DDE2D3345C92C7674BBE")
        @Override
        public void clear() {
            enumMap.clear();
            // ---------- Original Method ----------
            //enumMap.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.878 -0400", hash_original_method = "4AC40C6458CB1EE4BF18663D9AB10FCB", hash_generated_method = "73BA8D936CEE62D365D4AC6B19B65B9D")
        @Override
        public boolean contains(Object object) {
            boolean isEqual;
            isEqual = false;
            {
                Object enumKey;
                enumKey = ((Map.Entry) object).getKey();
                Object enumValue;
                enumValue = ((Map.Entry) object).getValue();
                {
                    boolean varC998F6B44C0D6A13C1F3DA4549FC80BB_1847230389 = (enumMap.containsKey(enumKey));
                    {
                        VT value;
                        value = enumMap.get(enumKey);
                        {
                            isEqual = enumValue == null;
                        } //End block
                        {
                            isEqual = value.equals(enumValue);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1839601681 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1839601681;
            // ---------- Original Method ----------
            //boolean isEqual = false;
            //if (object instanceof Map.Entry) {
                //Object enumKey = ((Map.Entry) object).getKey();
                //Object enumValue = ((Map.Entry) object).getValue();
                //if (enumMap.containsKey(enumKey)) {
                    //VT value = enumMap.get(enumKey);
                    //if (value == null) {
                        //isEqual = enumValue == null;
                    //} else {
                        //isEqual = value.equals(enumValue);
                    //}
                //}
            //}
            //return isEqual;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.880 -0400", hash_original_method = "95EB2B60E0E6891B83EBE6118D53811C", hash_generated_method = "783AE5FFD7274C6387E0436F9B47AD1D")
        @Override
        public Iterator<Map.Entry<KT, VT>> iterator() {
            Iterator<Map.Entry<KT, VT>> varB4EAC82CA7396A68D541C85D26508E83_1400251399 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1400251399 = new EnumMapEntryIterator<Map.Entry<KT, VT>, KT, VT>(
                    new MapEntry.Type<Map.Entry<KT, VT>, KT, VT>() {
                        public Map.Entry<KT, VT> get(MapEntry<KT, VT> entry) {
                            return entry;
                        }
                    }, enumMap);
            varB4EAC82CA7396A68D541C85D26508E83_1400251399.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1400251399;
            // ---------- Original Method ----------
            //return new EnumMapEntryIterator<Map.Entry<KT, VT>, KT, VT>(
                    //new MapEntry.Type<Map.Entry<KT, VT>, KT, VT>() {
                        //public Map.Entry<KT, VT> get(MapEntry<KT, VT> entry) {
                            //return entry;
                        //}
                    //}, enumMap);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.880 -0400", hash_original_method = "B1FBE3FDE380AB91D92300437712D6CE", hash_generated_method = "B3E093A7DD01947DB351BF09061FE073")
        @Override
        public boolean remove(Object object) {
            {
                boolean var4F9267015FE86EBB3F33114954B93ED1_595749389 = (contains(object));
                {
                    enumMap.remove(((Map.Entry) object).getKey());
                } //End block
            } //End collapsed parenthetic
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1188834134 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1188834134;
            // ---------- Original Method ----------
            //if (contains(object)) {
                //enumMap.remove(((Map.Entry) object).getKey());
                //return true;
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.883 -0400", hash_original_method = "C9EE7DD74ED1B4234C539DA28C6D21A7", hash_generated_method = "04B7F6F69D928491AC53FEF58E0A8DBF")
        @Override
        public int size() {
            int varF8250C8AC739D0318AEF09F1AC34F78B_1224648251 = (enumMap.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2041997813 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2041997813;
            // ---------- Original Method ----------
            //return enumMap.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.883 -0400", hash_original_method = "36EAFDE13B72544D308E66F5613D1161", hash_generated_method = "5F326ECC25DAE7E76F9BD12E93D7EB4C")
        @Override
        public Object[] toArray() {
            Object[] varB4EAC82CA7396A68D541C85D26508E83_417749844 = null; //Variable for return #1
            Object[] entryArray;
            entryArray = new Object[enumMap.size()];
            varB4EAC82CA7396A68D541C85D26508E83_417749844 = toArray(entryArray);
            varB4EAC82CA7396A68D541C85D26508E83_417749844.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_417749844;
            // ---------- Original Method ----------
            //Object[] entryArray = new Object[enumMap.size()];
            //return toArray(entryArray);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.889 -0400", hash_original_method = "9EABF255823509EF0FD5FF1AC40C33FF", hash_generated_method = "CF33B978C025283F8F9773D4E80F32BE")
        @SuppressWarnings("unchecked")
        @Override
        public Object[] toArray(Object[] array) {
            Object[] varB4EAC82CA7396A68D541C85D26508E83_158343378 = null; //Variable for return #1
            int size;
            size = enumMap.size();
            int index;
            index = 0;
            Object[] entryArray;
            entryArray = array;
            {
                Class<?> clazz;
                clazz = array.getClass().getComponentType();
                entryArray = (Object[]) Array.newInstance(clazz, size);
            } //End block
            Iterator<Map.Entry<KT, VT>> iter;
            iter = iterator();
            {
                Map.Entry<KT, VT> entry;
                entry = iter.next();
                entryArray[index] = new MapEntry<KT, VT>(entry.getKey(), entry
                        .getValue());
            } //End block
            {
                entryArray[index] = null;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_158343378 = entryArray;
            addTaint(array[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_158343378.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_158343378;
            // ---------- Original Method ----------
            //int size = enumMap.size();
            //int index = 0;
            //Object[] entryArray = array;
            //if (size > array.length) {
                //Class<?> clazz = array.getClass().getComponentType();
                //entryArray = (Object[]) Array.newInstance(clazz, size);
            //}
            //Iterator<Map.Entry<KT, VT>> iter = iterator();
            //for (; index < size; index++) {
                //Map.Entry<KT, VT> entry = iter.next();
                //entryArray[index] = new MapEntry<KT, VT>(entry.getKey(), entry
                        //.getValue());
            //}
            //if (index < array.length) {
                //entryArray[index] = null;
            //}
            //return entryArray;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.889 -0400", hash_original_field = "ACF5FEE0E990C707AF7445EBA9610512", hash_generated_field = "DA36825EF0A1E693763F8E0F3C343B7A")

    private static long serialVersionUID = 458661240069192865L;
}

