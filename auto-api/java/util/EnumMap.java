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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.674 -0400", hash_original_field = "056E0360B75D77ECE0AE955FE59BF15D", hash_generated_field = "784B4CB2B0AA1435846B96ECF749418D")

    private Class<K> keyType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.675 -0400", hash_original_field = "14F802E1FBA977727845E8872C1743A7", hash_generated_field = "1296F5D01B4090600677F6D5CA1FE096")

    transient Enum[] keys;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.675 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "4150C40DB1D8CEF16DAAF4E72141B18D")

    transient Object[] values;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.675 -0400", hash_original_field = "EB33C464BB85B740774E660ED19A4D23", hash_generated_field = "2AFD2ACFCCD988AD1A9DB860BFAFC15E")

    transient boolean[] hasMapping;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.675 -0400", hash_original_field = "80ADFCE58E22D304D276F1C6D95D4EF2", hash_generated_field = "204CA002E2DD9253A57F08EEC28189B5")

    private transient int mappingsCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.675 -0400", hash_original_field = "2FF4AF744F4AEE0F57EA018EF3FA7088", hash_generated_field = "2AA1CC9DCAEA03EA6B04E81906ED8EEA")

    transient int enumSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.675 -0400", hash_original_field = "22D97DDA025E6292D4C7D4F7678A4EEA", hash_generated_field = "60757B7103C3702D9A64F686BFD44FCF")

    private transient EnumMapEntrySet<K, V> entrySet = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.675 -0400", hash_original_method = "357B463561F8F38F36CCB594B2B44169", hash_generated_method = "859B4E62287F3B6BA4AD35D4BB715F67")
    public  EnumMap(Class<K> keyType) {
        initialization(keyType);
        addTaint(keyType.getTaint());
        // ---------- Original Method ----------
        //initialization(keyType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.675 -0400", hash_original_method = "4FB74096ACFD3857AE5FA5EC3BFDBAC1", hash_generated_method = "4D95A42660BE79B089DA64C3EDD70A2D")
    public  EnumMap(EnumMap<K, ? extends V> map) {
        initialization(map);
        addTaint(map.getTaint());
        // ---------- Original Method ----------
        //initialization(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.676 -0400", hash_original_method = "D652AC252782A7206F7D0F46E9A22736", hash_generated_method = "1EBE733B8B0446A8E3CF0B9AAB525E36")
    @SuppressWarnings("unchecked")
    public  EnumMap(Map<K, ? extends V> map) {
        {
            initialization((EnumMap<K, V>) map);
        } //End block
        {
            {
                boolean var25E2C4EEA885A5E03E8C4F2DC9C5AD7F_2113401825 = (map.size() == 0);
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
                boolean var65B366502464B6D98F6AF940C135B000_1583371827 = (clazz.isEnum());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.679 -0400", hash_original_method = "2976CFC6D7176D4F9EDBE7E00A9203F9", hash_generated_method = "B80AABDFA9194B1768A3A2F9D08F6AA8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.684 -0400", hash_original_method = "27D6CD5C74C8D110D14D6D471707F1DE", hash_generated_method = "B8DF8421861AD4D32C36251C1477A390")
    @SuppressWarnings("unchecked")
    @Override
    public EnumMap<K, V> clone() {
        EnumMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_1438623208 = null; //Variable for return #1
        try 
        {
            EnumMap<K, V> enumMap;
            enumMap = (EnumMap<K, V>) super.clone();
            enumMap.initialization(this);
            varB4EAC82CA7396A68D541C85D26508E83_1438623208 = enumMap;
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1438623208.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1438623208;
        // ---------- Original Method ----------
        //try {
            //EnumMap<K, V> enumMap = (EnumMap<K, V>) super.clone();
            //enumMap.initialization(this);
            //return enumMap;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.686 -0400", hash_original_method = "0E01365989D6BCC217AC6A8119B6F173", hash_generated_method = "89D676E27982CC1DAE2F3C684C46B0AB")
    @Override
    public boolean containsKey(Object key) {
        {
            boolean var2881195E5753FB7F055ED20418F3E365_210947661 = (isValidKeyType(key));
            {
                int keyOrdinal;
                keyOrdinal = ((Enum) key).ordinal();
            } //End block
        } //End collapsed parenthetic
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1115062868 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1115062868;
        // ---------- Original Method ----------
        //if (isValidKeyType(key)) {
            //int keyOrdinal = ((Enum) key).ordinal();
            //return hasMapping[keyOrdinal];
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.692 -0400", hash_original_method = "FD4C7D9777FB1B3FC7F27A22C70B4A60", hash_generated_method = "37DDC202B72C8E0256DBD660162B5C9D")
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
                        boolean var9645DA12622E821663F15BC1CC8202C0_1435028821 = (hasMapping[i] && value.equals(values[i]));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_457645418 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_457645418;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.695 -0400", hash_original_method = "1D25B0764045DBFAD19E9C060947BE81", hash_generated_method = "4D1744415440053BB2D85C2D4DE4B3C2")
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_149102473 = null; //Variable for return #1
        {
            entrySet = new EnumMapEntrySet<K, V>(this);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_149102473 = entrySet;
        varB4EAC82CA7396A68D541C85D26508E83_149102473.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_149102473;
        // ---------- Original Method ----------
        //if (entrySet == null) {
            //entrySet = new EnumMapEntrySet<K, V>(this);
        //}
        //return entrySet;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.696 -0400", hash_original_method = "AC8EB1BDF42FFE99FA259DC7FD35D677", hash_generated_method = "110807A321C9CA044C5E4C026FDEBFFB")
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object object) {
        {
            boolean varA3157AA9BC21D9DE63321077403F3F07_515719652 = (super.equals(object));
        } //End block
        EnumMap<K, V> enumMap;
        enumMap = (EnumMap<K, V>) object;
        {
            boolean varD0EFCA813FC7B10D8353B658CADEDA24_510829418 = (keyType != enumMap.keyType || size() != enumMap.size());
        } //End collapsed parenthetic
        boolean var86C56C7BA36A8C7548B1E6C40C5BF1BD_1403920663 = (Arrays.equals(hasMapping, enumMap.hasMapping)
                && Arrays.equals(values, enumMap.values));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_486133035 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_486133035;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.697 -0400", hash_original_method = "D1D1E4650582CB36D48A88314ACBD849", hash_generated_method = "9C2E4D9831186B2BBCC3527230F41EAB")
    @Override
    @SuppressWarnings("unchecked")
    public V get(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_2127339185 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_996364016 = null; //Variable for return #2
        {
            boolean varE7267BA1C950E6E221E46F63E7F428DF_1155161363 = (!isValidKeyType(key));
            {
                varB4EAC82CA7396A68D541C85D26508E83_2127339185 = null;
            } //End block
        } //End collapsed parenthetic
        int keyOrdinal;
        keyOrdinal = ((Enum) key).ordinal();
        varB4EAC82CA7396A68D541C85D26508E83_996364016 = (V) values[keyOrdinal];
        addTaint(key.getTaint());
        V varA7E53CE21691AB073D9660D615818899_1756743000; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1756743000 = varB4EAC82CA7396A68D541C85D26508E83_2127339185;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1756743000 = varB4EAC82CA7396A68D541C85D26508E83_996364016;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1756743000.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1756743000;
        // ---------- Original Method ----------
        //if (!isValidKeyType(key)) {
            //return null;
        //}
        //int keyOrdinal = ((Enum) key).ordinal();
        //return (V) values[keyOrdinal];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.702 -0400", hash_original_method = "ADC2E4F8D882C3AAF1D0303EAF8C1F23", hash_generated_method = "2F79BE188FB35D9A82899E0E62CDF05E")
    @Override
    public Set<K> keySet() {
        Set<K> varB4EAC82CA7396A68D541C85D26508E83_920884251 = null; //Variable for return #1
        {
            keySet = new EnumMapKeySet<K, V>(this);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_920884251 = keySet;
        varB4EAC82CA7396A68D541C85D26508E83_920884251.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_920884251;
        // ---------- Original Method ----------
        //if (keySet == null) {
            //keySet = new EnumMapKeySet<K, V>(this);
        //}
        //return keySet;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.703 -0400", hash_original_method = "0FAB728DBD67C753D3CD4965FE16DA6D", hash_generated_method = "D88C4AB4842686ECD4521BB6941845CC")
    @Override
    @SuppressWarnings("unchecked")
    public V put(K key, V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_1308010892 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1308010892 = putImpl(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1308010892.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1308010892;
        // ---------- Original Method ----------
        //return putImpl(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.704 -0400", hash_original_method = "57B3987EA7E50826E0AAD0198F968E42", hash_generated_method = "90447D4153EA2A9592AA1B07C1905DF7")
    @Override
    @SuppressWarnings("unchecked")
    public void putAll(Map<? extends K, ? extends V> map) {
        putAllImpl(map);
        addTaint(map.getTaint());
        // ---------- Original Method ----------
        //putAllImpl(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.715 -0400", hash_original_method = "2531311459BDF6AE48398CDBD33066ED", hash_generated_method = "7CF4D02D93375A4ED4A59EDD2E121966")
    @Override
    @SuppressWarnings("unchecked")
    public V remove(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_112228305 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_1416313648 = null; //Variable for return #2
        {
            boolean varE7267BA1C950E6E221E46F63E7F428DF_1092812262 = (!isValidKeyType(key));
            {
                varB4EAC82CA7396A68D541C85D26508E83_112228305 = null;
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
        varB4EAC82CA7396A68D541C85D26508E83_1416313648 = oldValue;
        addTaint(key.getTaint());
        V varA7E53CE21691AB073D9660D615818899_264930295; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_264930295 = varB4EAC82CA7396A68D541C85D26508E83_112228305;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_264930295 = varB4EAC82CA7396A68D541C85D26508E83_1416313648;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_264930295.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_264930295;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.715 -0400", hash_original_method = "9B5434C347C8B5979021C04F4F7D3AC0", hash_generated_method = "258BD9E19917AD21C1091BB2633048A3")
    @Override
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2006885620 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2006885620;
        // ---------- Original Method ----------
        //return mappingsCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.721 -0400", hash_original_method = "3209B6B28BA147378CF80090EC868BEA", hash_generated_method = "11D00730FCCF9304630FBE3804E85963")
    @Override
    public Collection<V> values() {
        Collection<V> varB4EAC82CA7396A68D541C85D26508E83_1013174669 = null; //Variable for return #1
        {
            valuesCollection = new EnumMapValueCollection<K, V>(this);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1013174669 = valuesCollection;
        varB4EAC82CA7396A68D541C85D26508E83_1013174669.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1013174669;
        // ---------- Original Method ----------
        //if (valuesCollection == null) {
            //valuesCollection = new EnumMapValueCollection<K, V>(this);
        //}
        //return valuesCollection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.722 -0400", hash_original_method = "DC4D5C48E92024F936CD723136F7EC43", hash_generated_method = "6CEDE98B7ECB1D7B785E5633120CC439")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.722 -0400", hash_original_method = "7E98F968D6A8FBC0CE4D31A606E7DB44", hash_generated_method = "B3BB48CDAD2CFD4C356FE3031D6DA2EF")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(mappingsCount);
        Iterator<Map.Entry<K, V>> iterator;
        iterator = entrySet().iterator();
        {
            boolean var15F7FE2AD7E10C613CA4B915023EF041_673862237 = (iterator.hasNext());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.722 -0400", hash_original_method = "AB7EF2A62AD1394405351664F3033DEE", hash_generated_method = "FB81569CDC80F56805A237D6A38E655B")
    private boolean isValidKeyType(Object key) {
        {
            boolean var747CFA0C5BD42E365CF87FEF40B6940C_1289240659 = (key != null && keyType.isInstance(key));
        } //End collapsed parenthetic
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_830145655 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_830145655;
        // ---------- Original Method ----------
        //if (key != null && keyType.isInstance(key)) {
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.723 -0400", hash_original_method = "E2B9C0EDB3E88C666CBFA70F3A732433", hash_generated_method = "D730116B98D134A16FDA01B3A791E739")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.727 -0400", hash_original_method = "74B7FF14F292272934F29B542A6B3535", hash_generated_method = "9FC8FBB551CD14785E1041E3AB443C0B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.736 -0400", hash_original_method = "394364EB9AA119D86D9EB30D7D288B77", hash_generated_method = "45FCA24D17323B5A59349BBC88A3EB93")
    @SuppressWarnings("unchecked")
    private void putAllImpl(Map map) {
        Iterator iter;
        iter = map.entrySet().iterator();
        {
            boolean varADABAFEBBAB7E585DD903333BD7F20A8_2130848378 = (iter.hasNext());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.741 -0400", hash_original_method = "1C83BB92B4CC56A2EE4CEBB2A5F2E79E", hash_generated_method = "F6BF32B1FADF4B91F5711D098E8CD560")
    @SuppressWarnings("unchecked")
    private V putImpl(K key, V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_624947269 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_624947269 = oldValue;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_624947269.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_624947269;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.743 -0400", hash_original_field = "0C2D76D104B4FBD56D5878F0C7B4948D", hash_generated_field = "2D3692AFCA37C24E228F49DBDE7EDE40")

        private EnumMap<KT, VT> enumMap;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.743 -0400", hash_original_field = "281858037F7DCF7ED49271BB92C60526", hash_generated_field = "1620EEB839396CD546E81EA24F66C13A")

        private int ordinal;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.743 -0400", hash_original_method = "04522B4DB01C65E7C5169DAAB9B0A8B0", hash_generated_method = "DA35C72F6F79331CC50CB441C0779B80")
          Entry(KT theKey, VT theValue, EnumMap<KT, VT> em) {
            super(theKey, theValue);
            enumMap = em;
            ordinal = ((Enum) theKey).ordinal();
            addTaint(theValue.getTaint());
            // ---------- Original Method ----------
            //enumMap = em;
            //ordinal = ((Enum) theKey).ordinal();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.755 -0400", hash_original_method = "8DD0429C812BC3CB5F9E4D12A50ED42A", hash_generated_method = "6A69E9CD58C6773499C41FA85C4AC0BA")
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
                    boolean var3FA36501E027AB1388F65D474C9CD126_291217414 = (key.equals(enumKey));
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
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1819839439 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1819839439;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.755 -0400", hash_original_method = "1D3BE2C1E2DBC9C20DAD39B42D607656", hash_generated_method = "528D6ECBE2C5FEEECF83FCF2FF6D284A")
        @Override
        public int hashCode() {
            int var335CA3F4B5A3CBFD417F696F0F465E58_1224534980 = ((enumMap.keys[ordinal] == null ? 0 : enumMap.keys[ordinal]
                    .hashCode())
                    ^ (enumMap.values[ordinal] == null ? 0
                            : enumMap.values[ordinal].hashCode())); //DSFIXME:  CODE0008: Nested ternary operator in expression
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_367318713 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_367318713;
            // ---------- Original Method ----------
            //return (enumMap.keys[ordinal] == null ? 0 : enumMap.keys[ordinal]
                    //.hashCode())
                    //^ (enumMap.values[ordinal] == null ? 0
                            //: enumMap.values[ordinal].hashCode());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.756 -0400", hash_original_method = "E6F3009D3E7934C3E89ABA04C91C1657", hash_generated_method = "BC6172BC2D2720A1D8C9ABB90E56815B")
        @SuppressWarnings("unchecked")
        @Override
        public KT getKey() {
            KT varB4EAC82CA7396A68D541C85D26508E83_1690718940 = null; //Variable for return #1
            checkEntryStatus();
            varB4EAC82CA7396A68D541C85D26508E83_1690718940 = (KT) enumMap.keys[ordinal];
            varB4EAC82CA7396A68D541C85D26508E83_1690718940.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1690718940;
            // ---------- Original Method ----------
            //checkEntryStatus();
            //return (KT) enumMap.keys[ordinal];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.766 -0400", hash_original_method = "F5CFE00A2E55AC6B5D81DB2B62FB299C", hash_generated_method = "FA697908B8CF9F44AF9F2BCC70A7D825")
        @SuppressWarnings("unchecked")
        @Override
        public VT getValue() {
            VT varB4EAC82CA7396A68D541C85D26508E83_1025604152 = null; //Variable for return #1
            checkEntryStatus();
            varB4EAC82CA7396A68D541C85D26508E83_1025604152 = (VT) enumMap.values[ordinal];
            varB4EAC82CA7396A68D541C85D26508E83_1025604152.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1025604152;
            // ---------- Original Method ----------
            //checkEntryStatus();
            //return (VT) enumMap.values[ordinal];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.767 -0400", hash_original_method = "2B70B6F95ECF307373567A039C54EE32", hash_generated_method = "903A88DBEAF20C533D0F384BD8C30F70")
        @SuppressWarnings("unchecked")
        @Override
        public VT setValue(VT value) {
            VT varB4EAC82CA7396A68D541C85D26508E83_1767292232 = null; //Variable for return #1
            checkEntryStatus();
            varB4EAC82CA7396A68D541C85D26508E83_1767292232 = enumMap.put((KT) enumMap.keys[ordinal], value);
            addTaint(value.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1767292232.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1767292232;
            // ---------- Original Method ----------
            //checkEntryStatus();
            //return enumMap.put((KT) enumMap.keys[ordinal], value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.768 -0400", hash_original_method = "7B70A2A5E5AF6D0A4A4180BECB8A721B", hash_generated_method = "0695A85100695D33B6B2C4F142072854")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1272315917 = null; //Variable for return #1
            StringBuilder result;
            result = new StringBuilder(enumMap.keys[ordinal]
                    .toString());
            result.append("=");
            result.append(enumMap.values[ordinal] == null
                    ? "null" : enumMap.values[ordinal].toString());
            varB4EAC82CA7396A68D541C85D26508E83_1272315917 = result.toString();
            varB4EAC82CA7396A68D541C85D26508E83_1272315917.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1272315917;
            // ---------- Original Method ----------
            //StringBuilder result = new StringBuilder(enumMap.keys[ordinal]
                    //.toString());
            //result.append("=");
            //result.append(enumMap.values[ordinal] == null
                    //? "null" : enumMap.values[ordinal].toString());
            //return result.toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.769 -0400", hash_original_method = "D6BC45043628808E78169E86857FDCA6", hash_generated_method = "8038D89382E041C2E7CD0D2C11997BDD")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.769 -0400", hash_original_field = "64F8FBF9ECD410CCCCA37B900774D128", hash_generated_field = "B0CD1B3F8E4067A68C294939F6EB1E36")

        int position = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.769 -0400", hash_original_field = "77548F33E0633F26B4CA86617FB59DA9", hash_generated_field = "3A5C61B7C027E04C48479D5037A2A070")

        int prePosition = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.769 -0400", hash_original_field = "0C2D76D104B4FBD56D5878F0C7B4948D", hash_generated_field = "7727A7369BF41381EE0BE2DFDA995DE4")

        EnumMap<KT, VT> enumMap;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.769 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "32CBE0E3CB6327A7B40B9B82E058EE9D")

        MapEntry.Type<E, KT, VT> type;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.777 -0400", hash_original_method = "9ED4E2039768E2794B08864F6EFD4280", hash_generated_method = "833B8AD483E734D37A90F49EA36161A4")
          EnumMapIterator(MapEntry.Type<E, KT, VT> value, EnumMap<KT, VT> em) {
            enumMap = em;
            type = value;
            // ---------- Original Method ----------
            //enumMap = em;
            //type = value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.783 -0400", hash_original_method = "6D6AB5C8509128D2C00828238AD4C0D9", hash_generated_method = "20A08A2E80361B5E6168487BCECBF029")
        public boolean hasNext() {
            int length;
            length = enumMap.enumSize;
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_145592872 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_145592872;
            // ---------- Original Method ----------
            //int length = enumMap.enumSize;
            //for (; position < length; position++) {
                //if (enumMap.hasMapping[position]) {
                    //break;
                //}
            //}
            //return position != length;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.784 -0400", hash_original_method = "8136BC21B836EBF6A2416BD2D7F3270E", hash_generated_method = "80C69AF550C8A1533DC1B4D990CF817C")
        @SuppressWarnings("unchecked")
        public E next() {
            E varB4EAC82CA7396A68D541C85D26508E83_59926874 = null; //Variable for return #1
            {
                boolean var61E0EA93C8F2038A69462393E2D5DF33_929484365 = (!hasNext());
                {
                    if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                } //End block
            } //End collapsed parenthetic
            prePosition = position++;
            varB4EAC82CA7396A68D541C85D26508E83_59926874 = type.get(new MapEntry(enumMap.keys[prePosition],
                    enumMap.values[prePosition]));
            varB4EAC82CA7396A68D541C85D26508E83_59926874.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_59926874;
            // ---------- Original Method ----------
            //if (!hasNext()) {
                //throw new NoSuchElementException();
            //}
            //prePosition = position++;
            //return type.get(new MapEntry(enumMap.keys[prePosition],
                    //enumMap.values[prePosition]));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.785 -0400", hash_original_method = "A29557D70FF021A737315678DDBC3059", hash_generated_method = "022234A89EDA9DECBBFDD48346827F6C")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.796 -0400", hash_original_method = "D4FD3F1C9995E81E934F03FC5256A25C", hash_generated_method = "E5608F885F2B6323165665E64E99B00F")
        @Override
        @SuppressWarnings("unchecked")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1424907436 = null; //Variable for return #1
            String varB4EAC82CA7396A68D541C85D26508E83_948561727 = null; //Variable for return #2
            {
                varB4EAC82CA7396A68D541C85D26508E83_1424907436 = super.toString();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_948561727 = type.get(
                    new MapEntry(enumMap.keys[prePosition],
                            enumMap.values[prePosition])).toString();
            String varA7E53CE21691AB073D9660D615818899_2099927211; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_2099927211 = varB4EAC82CA7396A68D541C85D26508E83_1424907436;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_2099927211 = varB4EAC82CA7396A68D541C85D26508E83_948561727;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_2099927211.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_2099927211;
            // ---------- Original Method ----------
            //if (-1 == prePosition) {
                //return super.toString();
            //}
            //return type.get(
                    //new MapEntry(enumMap.keys[prePosition],
                            //enumMap.values[prePosition])).toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.797 -0400", hash_original_method = "8DC9DAAEB887A2B3089BD6592C09E5DA", hash_generated_method = "550AE755F21ED782D17504DB2A2A7655")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.797 -0400", hash_original_field = "0C2D76D104B4FBD56D5878F0C7B4948D", hash_generated_field = "2D3692AFCA37C24E228F49DBDE7EDE40")

        private EnumMap<KT, VT> enumMap;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.798 -0400", hash_original_method = "2A1696B691A1F64388AB3AC9907332E4", hash_generated_method = "F2ECC98C583C95B1C2F72BFAEFD592CC")
          EnumMapKeySet(EnumMap<KT, VT> em) {
            enumMap = em;
            // ---------- Original Method ----------
            //enumMap = em;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.798 -0400", hash_original_method = "C3DE5D46C4F9CFEF3C6B4695838239E5", hash_generated_method = "063732887140DDE2D3345C92C7674BBE")
        @Override
        public void clear() {
            enumMap.clear();
            // ---------- Original Method ----------
            //enumMap.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.804 -0400", hash_original_method = "434CC1CFD8E42092C734D9BD095515B9", hash_generated_method = "0933F986E730BF21F11364979BB68B4B")
        @Override
        public boolean contains(Object object) {
            boolean varE1D05B251B8CFF246CADE02385321F75_1788454406 = (enumMap.containsKey(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1880000198 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1880000198;
            // ---------- Original Method ----------
            //return enumMap.containsKey(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.805 -0400", hash_original_method = "A4EABEDB06E5BDF24065F571F359AF57", hash_generated_method = "22C3E75DBED369FE98DE833C32646FC5")
        @Override
        @SuppressWarnings("unchecked")
        public Iterator iterator() {
            Iterator varB4EAC82CA7396A68D541C85D26508E83_1590299701 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1590299701 = new EnumMapIterator<KT, KT, VT>(
                    new MapEntry.Type<KT, KT, VT>() {
                        public KT get(MapEntry<KT, VT> entry) {
                            return entry.key;
                        }
                    }, enumMap);
            varB4EAC82CA7396A68D541C85D26508E83_1590299701.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1590299701;
            // ---------- Original Method ----------
            //return new EnumMapIterator<KT, KT, VT>(
                    //new MapEntry.Type<KT, KT, VT>() {
                        //public KT get(MapEntry<KT, VT> entry) {
                            //return entry.key;
                        //}
                    //}, enumMap);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.810 -0400", hash_original_method = "B8F9F39AE912D64223C40421DFD1515A", hash_generated_method = "F42F0F29DA1C49496CC4F919EE9253F4")
        @Override
        @SuppressWarnings("unchecked")
        public boolean remove(Object object) {
            {
                boolean var4F9267015FE86EBB3F33114954B93ED1_1046450323 = (contains(object));
                {
                    enumMap.remove(object);
                } //End block
            } //End collapsed parenthetic
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1469786130 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1469786130;
            // ---------- Original Method ----------
            //if (contains(object)) {
                //enumMap.remove(object);
                //return true;
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.815 -0400", hash_original_method = "C9EE7DD74ED1B4234C539DA28C6D21A7", hash_generated_method = "650AF3246E808C81E3D500E3EEA46FC9")
        @Override
        public int size() {
            int varF8250C8AC739D0318AEF09F1AC34F78B_636463022 = (enumMap.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1214036353 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1214036353;
            // ---------- Original Method ----------
            //return enumMap.size();
        }

        
    }


    
    private static class EnumMapValueCollection<KT extends Enum<KT>, VT> extends AbstractCollection<VT> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.815 -0400", hash_original_field = "0C2D76D104B4FBD56D5878F0C7B4948D", hash_generated_field = "2D3692AFCA37C24E228F49DBDE7EDE40")

        private EnumMap<KT, VT> enumMap;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.816 -0400", hash_original_method = "1A0661F4095C8F41E606FE019F34B01E", hash_generated_method = "E5ABA9176789D0F83D15C4076A2F1270")
          EnumMapValueCollection(EnumMap<KT, VT> em) {
            enumMap = em;
            // ---------- Original Method ----------
            //enumMap = em;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.816 -0400", hash_original_method = "C3DE5D46C4F9CFEF3C6B4695838239E5", hash_generated_method = "063732887140DDE2D3345C92C7674BBE")
        @Override
        public void clear() {
            enumMap.clear();
            // ---------- Original Method ----------
            //enumMap.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.820 -0400", hash_original_method = "F0FBCB059002559902B972108CF0BABE", hash_generated_method = "42EAB1D419D1CA511FC3A0B026D7F1E5")
        @Override
        public boolean contains(Object object) {
            boolean var2DAB091BFC98C0153936AB7B719C95FF_367093055 = (enumMap.containsValue(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_241837303 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_241837303;
            // ---------- Original Method ----------
            //return enumMap.containsValue(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.820 -0400", hash_original_method = "BC6C06395E1460CC49F247C03E1763F0", hash_generated_method = "11D651265ABDCCBA448CD5495AD2C38D")
        @SuppressWarnings("unchecked")
        @Override
        public Iterator iterator() {
            Iterator varB4EAC82CA7396A68D541C85D26508E83_2094797723 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2094797723 = new EnumMapIterator<VT, KT, VT>(
                    new MapEntry.Type<VT, KT, VT>() {
                        public VT get(MapEntry<KT, VT> entry) {
                            return entry.value;
                        }
                    }, enumMap);
            varB4EAC82CA7396A68D541C85D26508E83_2094797723.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2094797723;
            // ---------- Original Method ----------
            //return new EnumMapIterator<VT, KT, VT>(
                    //new MapEntry.Type<VT, KT, VT>() {
                        //public VT get(MapEntry<KT, VT> entry) {
                            //return entry.value;
                        //}
                    //}, enumMap);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.833 -0400", hash_original_method = "47E37FB3671E07CE32BC2BA28A816FCA", hash_generated_method = "9612EF058BDB0BC7D186197B52D38128")
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
                            boolean var37BC2A140D0EB4ED70B9893BBE73815F_1393933024 = (enumMap.hasMapping[i]
                            && object.equals(enumMap.values[i]));
                            {
                                enumMap.remove(enumMap.keys[i]);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_859586342 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_859586342;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.834 -0400", hash_original_method = "C9EE7DD74ED1B4234C539DA28C6D21A7", hash_generated_method = "62EC679C990099ACD75B16A436E9973A")
        @Override
        public int size() {
            int varF8250C8AC739D0318AEF09F1AC34F78B_986100377 = (enumMap.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_849576959 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_849576959;
            // ---------- Original Method ----------
            //return enumMap.size();
        }

        
    }


    
    private static class EnumMapEntryIterator<E, KT extends Enum<KT>, VT> extends EnumMapIterator<E, KT, VT> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.834 -0400", hash_original_method = "4B20A4930FDD81120A40D2421C6DB306", hash_generated_method = "9C5201D72293FD6623A70488883B34A9")
          EnumMapEntryIterator(MapEntry.Type<E, KT, VT> value, EnumMap<KT, VT> em) {
            super(value, em);
            addTaint(value.getTaint());
            addTaint(em.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.835 -0400", hash_original_method = "AA0A985577200C3410BBA8066828BEEB", hash_generated_method = "0CE2C3F76BA6D32CB91A1560FA22896E")
        @SuppressWarnings("unchecked")
        @Override
        public E next() {
            E varB4EAC82CA7396A68D541C85D26508E83_110858876 = null; //Variable for return #1
            {
                boolean var61E0EA93C8F2038A69462393E2D5DF33_1115798108 = (!hasNext());
                {
                    if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                } //End block
            } //End collapsed parenthetic
            prePosition = position++;
            varB4EAC82CA7396A68D541C85D26508E83_110858876 = type.get(new Entry<KT, VT>((KT) enumMap.keys[prePosition],
                    (VT) enumMap.values[prePosition], enumMap));
            varB4EAC82CA7396A68D541C85D26508E83_110858876.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_110858876;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.835 -0400", hash_original_field = "0C2D76D104B4FBD56D5878F0C7B4948D", hash_generated_field = "2D3692AFCA37C24E228F49DBDE7EDE40")

        private EnumMap<KT, VT> enumMap;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.836 -0400", hash_original_method = "616E4B9747EFF9433BD58C5F15DEC121", hash_generated_method = "D78FC31B5B25F7A257282F3524D220D6")
          EnumMapEntrySet(EnumMap<KT, VT> em) {
            enumMap = em;
            // ---------- Original Method ----------
            //enumMap = em;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.836 -0400", hash_original_method = "C3DE5D46C4F9CFEF3C6B4695838239E5", hash_generated_method = "063732887140DDE2D3345C92C7674BBE")
        @Override
        public void clear() {
            enumMap.clear();
            // ---------- Original Method ----------
            //enumMap.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.836 -0400", hash_original_method = "4AC40C6458CB1EE4BF18663D9AB10FCB", hash_generated_method = "085284022623B777EEEC4D3DC5567753")
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
                    boolean varC998F6B44C0D6A13C1F3DA4549FC80BB_273448048 = (enumMap.containsKey(enumKey));
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
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_434704717 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_434704717;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.848 -0400", hash_original_method = "95EB2B60E0E6891B83EBE6118D53811C", hash_generated_method = "28BB2DE3AB282F61492BDEF1B15442E1")
        @Override
        public Iterator<Map.Entry<KT, VT>> iterator() {
            Iterator<Map.Entry<KT, VT>> varB4EAC82CA7396A68D541C85D26508E83_1473033694 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1473033694 = new EnumMapEntryIterator<Map.Entry<KT, VT>, KT, VT>(
                    new MapEntry.Type<Map.Entry<KT, VT>, KT, VT>() {
                        public Map.Entry<KT, VT> get(MapEntry<KT, VT> entry) {
                            return entry;
                        }
                    }, enumMap);
            varB4EAC82CA7396A68D541C85D26508E83_1473033694.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1473033694;
            // ---------- Original Method ----------
            //return new EnumMapEntryIterator<Map.Entry<KT, VT>, KT, VT>(
                    //new MapEntry.Type<Map.Entry<KT, VT>, KT, VT>() {
                        //public Map.Entry<KT, VT> get(MapEntry<KT, VT> entry) {
                            //return entry;
                        //}
                    //}, enumMap);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.850 -0400", hash_original_method = "B1FBE3FDE380AB91D92300437712D6CE", hash_generated_method = "D88026AD8B61B23B52020D18B6377224")
        @Override
        public boolean remove(Object object) {
            {
                boolean var4F9267015FE86EBB3F33114954B93ED1_997729227 = (contains(object));
                {
                    enumMap.remove(((Map.Entry) object).getKey());
                } //End block
            } //End collapsed parenthetic
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_723742130 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_723742130;
            // ---------- Original Method ----------
            //if (contains(object)) {
                //enumMap.remove(((Map.Entry) object).getKey());
                //return true;
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.854 -0400", hash_original_method = "C9EE7DD74ED1B4234C539DA28C6D21A7", hash_generated_method = "CC17C2DA7D02F1A4F567C4F956528560")
        @Override
        public int size() {
            int varF8250C8AC739D0318AEF09F1AC34F78B_438682557 = (enumMap.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1702765792 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1702765792;
            // ---------- Original Method ----------
            //return enumMap.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.855 -0400", hash_original_method = "36EAFDE13B72544D308E66F5613D1161", hash_generated_method = "45CF7652B6314EDE0EB0E4FA81D33E1F")
        @Override
        public Object[] toArray() {
            Object[] varB4EAC82CA7396A68D541C85D26508E83_1492769245 = null; //Variable for return #1
            Object[] entryArray;
            entryArray = new Object[enumMap.size()];
            varB4EAC82CA7396A68D541C85D26508E83_1492769245 = toArray(entryArray);
            varB4EAC82CA7396A68D541C85D26508E83_1492769245.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1492769245;
            // ---------- Original Method ----------
            //Object[] entryArray = new Object[enumMap.size()];
            //return toArray(entryArray);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.856 -0400", hash_original_method = "9EABF255823509EF0FD5FF1AC40C33FF", hash_generated_method = "24DB4243E902294B7ADB4BD841D048A2")
        @SuppressWarnings("unchecked")
        @Override
        public Object[] toArray(Object[] array) {
            Object[] varB4EAC82CA7396A68D541C85D26508E83_1712775694 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_1712775694 = entryArray;
            addTaint(array[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1712775694.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1712775694;
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.856 -0400", hash_original_field = "ACF5FEE0E990C707AF7445EBA9610512", hash_generated_field = "DA36825EF0A1E693763F8E0F3C343B7A")

    private static long serialVersionUID = 458661240069192865L;
}

