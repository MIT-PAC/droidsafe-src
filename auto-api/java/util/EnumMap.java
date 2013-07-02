package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;

public class EnumMap<K extends Enum<K>, V> extends AbstractMap<K, V> implements Serializable, Cloneable, Map<K, V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.966 -0400", hash_original_field = "056E0360B75D77ECE0AE955FE59BF15D", hash_generated_field = "784B4CB2B0AA1435846B96ECF749418D")

    private Class<K> keyType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.966 -0400", hash_original_field = "14F802E1FBA977727845E8872C1743A7", hash_generated_field = "1296F5D01B4090600677F6D5CA1FE096")

    transient Enum[] keys;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.966 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "4150C40DB1D8CEF16DAAF4E72141B18D")

    transient Object[] values;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.966 -0400", hash_original_field = "EB33C464BB85B740774E660ED19A4D23", hash_generated_field = "2AFD2ACFCCD988AD1A9DB860BFAFC15E")

    transient boolean[] hasMapping;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.966 -0400", hash_original_field = "80ADFCE58E22D304D276F1C6D95D4EF2", hash_generated_field = "204CA002E2DD9253A57F08EEC28189B5")

    private transient int mappingsCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.966 -0400", hash_original_field = "2FF4AF744F4AEE0F57EA018EF3FA7088", hash_generated_field = "2AA1CC9DCAEA03EA6B04E81906ED8EEA")

    transient int enumSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.966 -0400", hash_original_field = "22D97DDA025E6292D4C7D4F7678A4EEA", hash_generated_field = "60757B7103C3702D9A64F686BFD44FCF")

    private transient EnumMapEntrySet<K, V> entrySet = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.967 -0400", hash_original_method = "357B463561F8F38F36CCB594B2B44169", hash_generated_method = "859B4E62287F3B6BA4AD35D4BB715F67")
    public  EnumMap(Class<K> keyType) {
        initialization(keyType);
        addTaint(keyType.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.967 -0400", hash_original_method = "4FB74096ACFD3857AE5FA5EC3BFDBAC1", hash_generated_method = "4D95A42660BE79B089DA64C3EDD70A2D")
    public  EnumMap(EnumMap<K, ? extends V> map) {
        initialization(map);
        addTaint(map.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.968 -0400", hash_original_method = "D652AC252782A7206F7D0F46E9A22736", hash_generated_method = "43DE6615E3383396923DB64E38618A59")
    @SuppressWarnings("unchecked")
    public  EnumMap(Map<K, ? extends V> map) {
        {
            initialization((EnumMap<K, V>) map);
        } 
        {
            {
                boolean var25E2C4EEA885A5E03E8C4F2DC9C5AD7F_2062592675 = (map.size() == 0);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
                } 
            } 
            Iterator<K> iter = map.keySet().iterator();
            K enumKey = iter.next();
            Class clazz = enumKey.getClass();
            {
                boolean var65B366502464B6D98F6AF940C135B000_1255475173 = (clazz.isEnum());
                {
                    initialization(clazz);
                } 
                {
                    initialization(clazz.getSuperclass());
                } 
            } 
            putAllImpl(map);
        } 
        addTaint(map.getTaint());
        
        
            
        
            
                
            
            
            
            
            
                
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.968 -0400", hash_original_method = "2976CFC6D7176D4F9EDBE7E00A9203F9", hash_generated_method = "B80AABDFA9194B1768A3A2F9D08F6AA8")
    @Override
    public void clear() {
        Arrays.fill(values, null);
        Arrays.fill(hasMapping, false);
        mappingsCount = 0;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.968 -0400", hash_original_method = "27D6CD5C74C8D110D14D6D471707F1DE", hash_generated_method = "0ED3C424C7C4A4C3DAEF1A3CBFD1B70B")
    @SuppressWarnings("unchecked")
    @Override
    public EnumMap<K, V> clone() {
        EnumMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_1814392561 = null; 
        try 
        {
            EnumMap<K, V> enumMap = (EnumMap<K, V>) super.clone();
            enumMap.initialization(this);
            varB4EAC82CA7396A68D541C85D26508E83_1814392561 = enumMap;
        } 
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1814392561.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1814392561;
        
        
            
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.969 -0400", hash_original_method = "0E01365989D6BCC217AC6A8119B6F173", hash_generated_method = "F2BA2D87522CDC48019AB721BFA42164")
    @Override
    public boolean containsKey(Object key) {
        {
            boolean var2881195E5753FB7F055ED20418F3E365_1298201213 = (isValidKeyType(key));
            {
                int keyOrdinal = ((Enum) key).ordinal();
            } 
        } 
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1863048920 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1863048920;
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.969 -0400", hash_original_method = "FD4C7D9777FB1B3FC7F27A22C70B4A60", hash_generated_method = "6C9CF3C9D62F3409626DC7780D26BB65")
    @Override
    public boolean containsValue(Object value) {
        {
            {
                int i = 0;
            } 
        } 
        {
            {
                int i = 0;
                {
                    {
                        boolean var9645DA12622E821663F15BC1CC8202C0_840714871 = (hasMapping[i] && value.equals(values[i]));
                    } 
                } 
            } 
        } 
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_166135722 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_166135722;
        
        
            
                
                    
                
            
        
            
                
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.970 -0400", hash_original_method = "1D25B0764045DBFAD19E9C060947BE81", hash_generated_method = "50D30300BB21D2A69C9C724BCF598D86")
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_361123520 = null; 
        {
            entrySet = new EnumMapEntrySet<K, V>(this);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_361123520 = entrySet;
        varB4EAC82CA7396A68D541C85D26508E83_361123520.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_361123520;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.971 -0400", hash_original_method = "AC8EB1BDF42FFE99FA259DC7FD35D677", hash_generated_method = "EB3C4F3A8D8A18AAB290A2FF20D7903C")
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object object) {
        {
            boolean varA3157AA9BC21D9DE63321077403F3F07_507275352 = (super.equals(object));
        } 
        EnumMap<K, V> enumMap = (EnumMap<K, V>) object;
        {
            boolean varD0EFCA813FC7B10D8353B658CADEDA24_1875011292 = (keyType != enumMap.keyType || size() != enumMap.size());
        } 
        boolean var86C56C7BA36A8C7548B1E6C40C5BF1BD_86309609 = (Arrays.equals(hasMapping, enumMap.hasMapping)
                && Arrays.equals(values, enumMap.values));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_47395415 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_47395415;
        
        
            
        
        
            
        
        
        
            
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.972 -0400", hash_original_method = "D1D1E4650582CB36D48A88314ACBD849", hash_generated_method = "36D44B58CC105B2736A6F948DC90E31E")
    @Override
    @SuppressWarnings("unchecked")
    public V get(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_2123558232 = null; 
        V varB4EAC82CA7396A68D541C85D26508E83_676492887 = null; 
        {
            boolean varE7267BA1C950E6E221E46F63E7F428DF_359928641 = (!isValidKeyType(key));
            {
                varB4EAC82CA7396A68D541C85D26508E83_2123558232 = null;
            } 
        } 
        int keyOrdinal = ((Enum) key).ordinal();
        varB4EAC82CA7396A68D541C85D26508E83_676492887 = (V) values[keyOrdinal];
        addTaint(key.getTaint());
        V varA7E53CE21691AB073D9660D615818899_1035664735; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1035664735 = varB4EAC82CA7396A68D541C85D26508E83_2123558232;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1035664735 = varB4EAC82CA7396A68D541C85D26508E83_676492887;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1035664735.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1035664735;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.973 -0400", hash_original_method = "ADC2E4F8D882C3AAF1D0303EAF8C1F23", hash_generated_method = "C81906F52A94DF0DEC03164A39FD21D6")
    @Override
    public Set<K> keySet() {
        Set<K> varB4EAC82CA7396A68D541C85D26508E83_1095724636 = null; 
        {
            keySet = new EnumMapKeySet<K, V>(this);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1095724636 = keySet;
        varB4EAC82CA7396A68D541C85D26508E83_1095724636.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1095724636;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.973 -0400", hash_original_method = "0FAB728DBD67C753D3CD4965FE16DA6D", hash_generated_method = "290059360ABACC36E726A5D0FE157CD0")
    @Override
    @SuppressWarnings("unchecked")
    public V put(K key, V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_530273755 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_530273755 = putImpl(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_530273755.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_530273755;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.973 -0400", hash_original_method = "57B3987EA7E50826E0AAD0198F968E42", hash_generated_method = "90447D4153EA2A9592AA1B07C1905DF7")
    @Override
    @SuppressWarnings("unchecked")
    public void putAll(Map<? extends K, ? extends V> map) {
        putAllImpl(map);
        addTaint(map.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.974 -0400", hash_original_method = "2531311459BDF6AE48398CDBD33066ED", hash_generated_method = "E162D9314F3929D71358E508E8DFB263")
    @Override
    @SuppressWarnings("unchecked")
    public V remove(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_1472157059 = null; 
        V varB4EAC82CA7396A68D541C85D26508E83_721886846 = null; 
        {
            boolean varE7267BA1C950E6E221E46F63E7F428DF_357116843 = (!isValidKeyType(key));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1472157059 = null;
            } 
        } 
        int keyOrdinal = ((Enum) key).ordinal();
        {
            hasMapping[keyOrdinal] = false;
        } 
        V oldValue = (V) values[keyOrdinal];
        values[keyOrdinal] = null;
        varB4EAC82CA7396A68D541C85D26508E83_721886846 = oldValue;
        addTaint(key.getTaint());
        V varA7E53CE21691AB073D9660D615818899_138144751; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_138144751 = varB4EAC82CA7396A68D541C85D26508E83_1472157059;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_138144751 = varB4EAC82CA7396A68D541C85D26508E83_721886846;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_138144751.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_138144751;
        
        
            
        
        
        
            
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.974 -0400", hash_original_method = "9B5434C347C8B5979021C04F4F7D3AC0", hash_generated_method = "DFB13462564472F3EBFF4A8C10854D60")
    @Override
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1774676627 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1774676627;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.975 -0400", hash_original_method = "3209B6B28BA147378CF80090EC868BEA", hash_generated_method = "053F46B7F1CC826394D31720B6A8E7A8")
    @Override
    public Collection<V> values() {
        Collection<V> varB4EAC82CA7396A68D541C85D26508E83_520494627 = null; 
        {
            valuesCollection = new EnumMapValueCollection<K, V>(this);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_520494627 = valuesCollection;
        varB4EAC82CA7396A68D541C85D26508E83_520494627.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_520494627;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.975 -0400", hash_original_method = "DC4D5C48E92024F936CD723136F7EC43", hash_generated_method = "2FED10115B943296B46DD67B186EEA2F")
    @SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        stream.defaultReadObject();
        initialization(keyType);
        int elementCount = stream.readInt();
        Enum<K> enumKey;
        Object value;
        {
            int i = elementCount;
            {
                enumKey = (Enum<K>) stream.readObject();
                value = stream.readObject();
                putImpl((K) enumKey, (V) value);
            } 
        } 
        addTaint(stream.getTaint());
        
        
        
        
        
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.976 -0400", hash_original_method = "7E98F968D6A8FBC0CE4D31A606E7DB44", hash_generated_method = "2730A81CCB3E56CF5BD47E04BC5A8DA4")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(mappingsCount);
        Iterator<Map.Entry<K, V>> iterator = entrySet().iterator();
        {
            boolean var15F7FE2AD7E10C613CA4B915023EF041_1049690326 = (iterator.hasNext());
            {
                Map.Entry<K, V> entry = iterator.next();
                stream.writeObject(entry.getKey());
                stream.writeObject(entry.getValue());
            } 
        } 
        addTaint(stream.getTaint());
        
        
        
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.976 -0400", hash_original_method = "AB7EF2A62AD1394405351664F3033DEE", hash_generated_method = "8982F54CF8E6A48907C3505C83FC4A5A")
    private boolean isValidKeyType(Object key) {
        {
            boolean var747CFA0C5BD42E365CF87FEF40B6940C_798091666 = (key != null && keyType.isInstance(key));
        } 
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1983794871 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1983794871;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.976 -0400", hash_original_method = "E2B9C0EDB3E88C666CBFA70F3A732433", hash_generated_method = "D730116B98D134A16FDA01B3A791E739")
    @SuppressWarnings("unchecked")
    private void initialization(EnumMap enumMap) {
        keyType = enumMap.keyType;
        keys = enumMap.keys;
        enumSize = enumMap.enumSize;
        values = enumMap.values.clone();
        hasMapping = enumMap.hasMapping.clone();
        mappingsCount = enumMap.mappingsCount;
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.977 -0400", hash_original_method = "74B7FF14F292272934F29B542A6B3535", hash_generated_method = "9FC8FBB551CD14785E1041E3AB443C0B")
    private void initialization(Class<K> type) {
        keyType = type;
        keys = Enum.getSharedConstants(keyType);
        enumSize = keys.length;
        values = new Object[enumSize];
        hasMapping = new boolean[enumSize];
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.977 -0400", hash_original_method = "394364EB9AA119D86D9EB30D7D288B77", hash_generated_method = "A8BA247628B03AF1E94274FE2E139023")
    @SuppressWarnings("unchecked")
    private void putAllImpl(Map map) {
        Iterator iter = map.entrySet().iterator();
        {
            boolean varADABAFEBBAB7E585DD903333BD7F20A8_624689198 = (iter.hasNext());
            {
                Map.Entry entry = (Map.Entry) iter.next();
                putImpl((K) entry.getKey(), (V) entry.getValue());
            } 
        } 
        addTaint(map.getTaint());
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.978 -0400", hash_original_method = "1C83BB92B4CC56A2EE4CEBB2A5F2E79E", hash_generated_method = "9E7A50D66A3EB74620F6C8459610D15A")
    @SuppressWarnings("unchecked")
    private V putImpl(K key, V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_1761586452 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        keyType.cast(key);
        int keyOrdinal = key.ordinal();
        {
            hasMapping[keyOrdinal] = true;
        } 
        V oldValue = (V) values[keyOrdinal];
        values[keyOrdinal] = value;
        varB4EAC82CA7396A68D541C85D26508E83_1761586452 = oldValue;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1761586452.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1761586452;
        
        
            
        
        
        
        
            
            
        
        
        
        
    }

    
    private static class Entry<KT extends Enum<KT>, VT> extends MapEntry<KT, VT> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.978 -0400", hash_original_field = "0C2D76D104B4FBD56D5878F0C7B4948D", hash_generated_field = "2D3692AFCA37C24E228F49DBDE7EDE40")

        private EnumMap<KT, VT> enumMap;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.978 -0400", hash_original_field = "281858037F7DCF7ED49271BB92C60526", hash_generated_field = "1620EEB839396CD546E81EA24F66C13A")

        private int ordinal;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.978 -0400", hash_original_method = "04522B4DB01C65E7C5169DAAB9B0A8B0", hash_generated_method = "DA35C72F6F79331CC50CB441C0779B80")
          Entry(KT theKey, VT theValue, EnumMap<KT, VT> em) {
            super(theKey, theValue);
            enumMap = em;
            ordinal = ((Enum) theKey).ordinal();
            addTaint(theValue.getTaint());
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.979 -0400", hash_original_method = "8DD0429C812BC3CB5F9E4D12A50ED42A", hash_generated_method = "B24B2E72BD782971F1C3D1E3C23BE64B")
        @SuppressWarnings("unchecked")
        @Override
        public boolean equals(Object object) {
            boolean isEqual = false;
            {
                Map.Entry<KT, VT> entry = (Map.Entry<KT, VT>) object;
                Object enumKey = entry.getKey();
                {
                    boolean var3FA36501E027AB1388F65D474C9CD126_1469559856 = (key.equals(enumKey));
                    {
                        Object theValue = entry.getValue();
                        {
                            isEqual = (theValue == null);
                        } 
                        {
                            isEqual = enumMap.values[ordinal].equals(theValue);
                        } 
                    } 
                } 
            } 
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1499792036 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1499792036;
            
            
                
            
            
            
                
                
                
                    
                    
                        
                    
                        
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.979 -0400", hash_original_method = "1D3BE2C1E2DBC9C20DAD39B42D607656", hash_generated_method = "9498CA1AF1107B369D1F6D7F2768BD59")
        @Override
        public int hashCode() {
            int var335CA3F4B5A3CBFD417F696F0F465E58_278601544 = ((enumMap.keys[ordinal] == null ? 0 : enumMap.keys[ordinal]
                    .hashCode())
                    ^ (enumMap.values[ordinal] == null ? 0
                            : enumMap.values[ordinal].hashCode())); 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1575570049 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1575570049;
            
            
                    
                    
                            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.980 -0400", hash_original_method = "E6F3009D3E7934C3E89ABA04C91C1657", hash_generated_method = "900DEEB15553386AC35A46465AB8C82C")
        @SuppressWarnings("unchecked")
        @Override
        public KT getKey() {
            KT varB4EAC82CA7396A68D541C85D26508E83_254013776 = null; 
            checkEntryStatus();
            varB4EAC82CA7396A68D541C85D26508E83_254013776 = (KT) enumMap.keys[ordinal];
            varB4EAC82CA7396A68D541C85D26508E83_254013776.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_254013776;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.981 -0400", hash_original_method = "F5CFE00A2E55AC6B5D81DB2B62FB299C", hash_generated_method = "CBAFFFEEAE3A94C4B5F5C32F78486E83")
        @SuppressWarnings("unchecked")
        @Override
        public VT getValue() {
            VT varB4EAC82CA7396A68D541C85D26508E83_1935652373 = null; 
            checkEntryStatus();
            varB4EAC82CA7396A68D541C85D26508E83_1935652373 = (VT) enumMap.values[ordinal];
            varB4EAC82CA7396A68D541C85D26508E83_1935652373.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1935652373;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.985 -0400", hash_original_method = "2B70B6F95ECF307373567A039C54EE32", hash_generated_method = "2233383C7A3F65972B0B0B0DC12FF3FA")
        @SuppressWarnings("unchecked")
        @Override
        public VT setValue(VT value) {
            VT varB4EAC82CA7396A68D541C85D26508E83_1530336985 = null; 
            checkEntryStatus();
            varB4EAC82CA7396A68D541C85D26508E83_1530336985 = enumMap.put((KT) enumMap.keys[ordinal], value);
            addTaint(value.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1530336985.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1530336985;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.985 -0400", hash_original_method = "7B70A2A5E5AF6D0A4A4180BECB8A721B", hash_generated_method = "667A278C2885D0E7D804C897ADFB6F49")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1405278419 = null; 
            StringBuilder result = new StringBuilder(enumMap.keys[ordinal]
                    .toString());
            result.append("=");
            result.append(enumMap.values[ordinal] == null
                    ? "null" : enumMap.values[ordinal].toString());
            varB4EAC82CA7396A68D541C85D26508E83_1405278419 = result.toString();
            varB4EAC82CA7396A68D541C85D26508E83_1405278419.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1405278419;
            
            
                    
            
            
                    
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.986 -0400", hash_original_method = "D6BC45043628808E78169E86857FDCA6", hash_generated_method = "8038D89382E041C2E7CD0D2C11997BDD")
        private void checkEntryStatus() {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            } 
            
            
                
            
        }

        
    }


    
    private static class EnumMapIterator<E, KT extends Enum<KT>, VT> implements Iterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.986 -0400", hash_original_field = "64F8FBF9ECD410CCCCA37B900774D128", hash_generated_field = "B0CD1B3F8E4067A68C294939F6EB1E36")

        int position = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.986 -0400", hash_original_field = "77548F33E0633F26B4CA86617FB59DA9", hash_generated_field = "3A5C61B7C027E04C48479D5037A2A070")

        int prePosition = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.986 -0400", hash_original_field = "0C2D76D104B4FBD56D5878F0C7B4948D", hash_generated_field = "7727A7369BF41381EE0BE2DFDA995DE4")

        EnumMap<KT, VT> enumMap;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.986 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "32CBE0E3CB6327A7B40B9B82E058EE9D")

        MapEntry.Type<E, KT, VT> type;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.987 -0400", hash_original_method = "9ED4E2039768E2794B08864F6EFD4280", hash_generated_method = "833B8AD483E734D37A90F49EA36161A4")
          EnumMapIterator(MapEntry.Type<E, KT, VT> value, EnumMap<KT, VT> em) {
            enumMap = em;
            type = value;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.987 -0400", hash_original_method = "6D6AB5C8509128D2C00828238AD4C0D9", hash_generated_method = "AF90C751A8765A5EE84FC09E13A67C39")
        public boolean hasNext() {
            int length = enumMap.enumSize;
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1764211182 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1764211182;
            
            
            
                
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.988 -0400", hash_original_method = "8136BC21B836EBF6A2416BD2D7F3270E", hash_generated_method = "5E113124DD1B0AEB5BF31AD38B9B6364")
        @SuppressWarnings("unchecked")
        public E next() {
            E varB4EAC82CA7396A68D541C85D26508E83_1601423971 = null; 
            {
                boolean var61E0EA93C8F2038A69462393E2D5DF33_851731696 = (!hasNext());
                {
                    if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                } 
            } 
            prePosition = position++;
            varB4EAC82CA7396A68D541C85D26508E83_1601423971 = type.get(new MapEntry(enumMap.keys[prePosition],
                    enumMap.values[prePosition]));
            varB4EAC82CA7396A68D541C85D26508E83_1601423971.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1601423971;
            
            
                
            
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.989 -0400", hash_original_method = "A29557D70FF021A737315678DDBC3059", hash_generated_method = "022234A89EDA9DECBBFDD48346827F6C")
        public void remove() {
            checkStatus();
            {
                enumMap.remove(enumMap.keys[prePosition]);
            } 
            prePosition = -1;
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.991 -0400", hash_original_method = "D4FD3F1C9995E81E934F03FC5256A25C", hash_generated_method = "602C84BF7FB9FDDB207925F0631A4540")
        @Override
        @SuppressWarnings("unchecked")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1458447395 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_1296043671 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1458447395 = super.toString();
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1296043671 = type.get(
                    new MapEntry(enumMap.keys[prePosition],
                            enumMap.values[prePosition])).toString();
            String varA7E53CE21691AB073D9660D615818899_83070038; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_83070038 = varB4EAC82CA7396A68D541C85D26508E83_1458447395;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_83070038 = varB4EAC82CA7396A68D541C85D26508E83_1296043671;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_83070038.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_83070038;
            
            
                
            
            
                    
                            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.992 -0400", hash_original_method = "8DC9DAAEB887A2B3089BD6592C09E5DA", hash_generated_method = "550AE755F21ED782D17504DB2A2A7655")
        private void checkStatus() {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            } 
            
            
                
            
        }

        
    }


    
    private static class EnumMapKeySet<KT extends Enum<KT>, VT> extends AbstractSet<KT> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.992 -0400", hash_original_field = "0C2D76D104B4FBD56D5878F0C7B4948D", hash_generated_field = "2D3692AFCA37C24E228F49DBDE7EDE40")

        private EnumMap<KT, VT> enumMap;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.993 -0400", hash_original_method = "2A1696B691A1F64388AB3AC9907332E4", hash_generated_method = "F2ECC98C583C95B1C2F72BFAEFD592CC")
          EnumMapKeySet(EnumMap<KT, VT> em) {
            enumMap = em;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.994 -0400", hash_original_method = "C3DE5D46C4F9CFEF3C6B4695838239E5", hash_generated_method = "063732887140DDE2D3345C92C7674BBE")
        @Override
        public void clear() {
            enumMap.clear();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.995 -0400", hash_original_method = "434CC1CFD8E42092C734D9BD095515B9", hash_generated_method = "1CD972375A208BC9CC71775E49DF3D52")
        @Override
        public boolean contains(Object object) {
            boolean varE1D05B251B8CFF246CADE02385321F75_299418269 = (enumMap.containsKey(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_766140915 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_766140915;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.997 -0400", hash_original_method = "A4EABEDB06E5BDF24065F571F359AF57", hash_generated_method = "1784D71224A9B58CCD913CDC9BD3B3C0")
        @Override
        @SuppressWarnings("unchecked")
        public Iterator iterator() {
            Iterator varB4EAC82CA7396A68D541C85D26508E83_156082786 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_156082786 = new EnumMapIterator<KT, KT, VT>(
                    new MapEntry.Type<KT, KT, VT>() {
                        public KT get(MapEntry<KT, VT> entry) {
                            return entry.key;
                        }
                    }, enumMap);
            varB4EAC82CA7396A68D541C85D26508E83_156082786.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_156082786;
            
            
                    
                        
                            
                        
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.998 -0400", hash_original_method = "B8F9F39AE912D64223C40421DFD1515A", hash_generated_method = "F7CD0DA83DC3692089EE6B81FC7BB97E")
        @Override
        @SuppressWarnings("unchecked")
        public boolean remove(Object object) {
            {
                boolean var4F9267015FE86EBB3F33114954B93ED1_544373801 = (contains(object));
                {
                    enumMap.remove(object);
                } 
            } 
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1693746880 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1693746880;
            
            
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.998 -0400", hash_original_method = "C9EE7DD74ED1B4234C539DA28C6D21A7", hash_generated_method = "DFDA40A6BD0B86AF22CBE80DB093C49C")
        @Override
        public int size() {
            int varF8250C8AC739D0318AEF09F1AC34F78B_740846273 = (enumMap.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1863621956 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1863621956;
            
            
        }

        
        
        public KT get(MapEntry<KT, VT> entry) {
                            return entry.key;
                        }
        
    }


    
    private static class EnumMapValueCollection<KT extends Enum<KT>, VT> extends AbstractCollection<VT> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.998 -0400", hash_original_field = "0C2D76D104B4FBD56D5878F0C7B4948D", hash_generated_field = "2D3692AFCA37C24E228F49DBDE7EDE40")

        private EnumMap<KT, VT> enumMap;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.999 -0400", hash_original_method = "1A0661F4095C8F41E606FE019F34B01E", hash_generated_method = "E5ABA9176789D0F83D15C4076A2F1270")
          EnumMapValueCollection(EnumMap<KT, VT> em) {
            enumMap = em;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.999 -0400", hash_original_method = "C3DE5D46C4F9CFEF3C6B4695838239E5", hash_generated_method = "063732887140DDE2D3345C92C7674BBE")
        @Override
        public void clear() {
            enumMap.clear();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.999 -0400", hash_original_method = "F0FBCB059002559902B972108CF0BABE", hash_generated_method = "0593383E7A2169766AAB02FD35BAEC13")
        @Override
        public boolean contains(Object object) {
            boolean var2DAB091BFC98C0153936AB7B719C95FF_1547148717 = (enumMap.containsValue(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_166855417 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_166855417;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.000 -0400", hash_original_method = "BC6C06395E1460CC49F247C03E1763F0", hash_generated_method = "209EA93E447D9BE20FF63F15120E0AE2")
        @SuppressWarnings("unchecked")
        @Override
        public Iterator iterator() {
            Iterator varB4EAC82CA7396A68D541C85D26508E83_1108241589 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1108241589 = new EnumMapIterator<VT, KT, VT>(
                    new MapEntry.Type<VT, KT, VT>() {
                        public VT get(MapEntry<KT, VT> entry) {
                            return entry.value;
                        }
                    }, enumMap);
            varB4EAC82CA7396A68D541C85D26508E83_1108241589.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1108241589;
            
            
                    
                        
                            
                        
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.000 -0400", hash_original_method = "47E37FB3671E07CE32BC2BA28A816FCA", hash_generated_method = "1A3AA6800FCF7D62FAD78A77B0E4F70C")
        @Override
        public boolean remove(Object object) {
            {
                {
                    int i = 0;
                    {
                        {
                            enumMap.remove(enumMap.keys[i]);
                        } 
                    } 
                } 
            } 
            {
                {
                    int i = 0;
                    {
                        {
                            boolean var37BC2A140D0EB4ED70B9893BBE73815F_214288986 = (enumMap.hasMapping[i]
                            && object.equals(enumMap.values[i]));
                            {
                                enumMap.remove(enumMap.keys[i]);
                            } 
                        } 
                    } 
                } 
            } 
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1759174851 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1759174851;
            
            
                
                    
                        
                        
                    
                
            
                
                    
                            
                        
                        
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.001 -0400", hash_original_method = "C9EE7DD74ED1B4234C539DA28C6D21A7", hash_generated_method = "21881667DB896B0E78A02DBBAF0AB119")
        @Override
        public int size() {
            int varF8250C8AC739D0318AEF09F1AC34F78B_1470435105 = (enumMap.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_470934072 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_470934072;
            
            
        }

        
        
        public VT get(MapEntry<KT, VT> entry) {
                            return entry.value;
                        }
        
    }


    
    private static class EnumMapEntryIterator<E, KT extends Enum<KT>, VT> extends EnumMapIterator<E, KT, VT> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.001 -0400", hash_original_method = "4B20A4930FDD81120A40D2421C6DB306", hash_generated_method = "9C5201D72293FD6623A70488883B34A9")
          EnumMapEntryIterator(MapEntry.Type<E, KT, VT> value, EnumMap<KT, VT> em) {
            super(value, em);
            addTaint(value.getTaint());
            addTaint(em.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.002 -0400", hash_original_method = "AA0A985577200C3410BBA8066828BEEB", hash_generated_method = "E5827CF03787922427E69EA1A70B5F13")
        @SuppressWarnings("unchecked")
        @Override
        public E next() {
            E varB4EAC82CA7396A68D541C85D26508E83_471024862 = null; 
            {
                boolean var61E0EA93C8F2038A69462393E2D5DF33_174324891 = (!hasNext());
                {
                    if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                } 
            } 
            prePosition = position++;
            varB4EAC82CA7396A68D541C85D26508E83_471024862 = type.get(new Entry<KT, VT>((KT) enumMap.keys[prePosition],
                    (VT) enumMap.values[prePosition], enumMap));
            varB4EAC82CA7396A68D541C85D26508E83_471024862.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_471024862;
            
            
                
            
            
            
                    
        }

        
    }


    
    private static class EnumMapEntrySet<KT extends Enum<KT>, VT> extends AbstractSet<Map.Entry<KT, VT>> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.002 -0400", hash_original_field = "0C2D76D104B4FBD56D5878F0C7B4948D", hash_generated_field = "2D3692AFCA37C24E228F49DBDE7EDE40")

        private EnumMap<KT, VT> enumMap;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.003 -0400", hash_original_method = "616E4B9747EFF9433BD58C5F15DEC121", hash_generated_method = "D78FC31B5B25F7A257282F3524D220D6")
          EnumMapEntrySet(EnumMap<KT, VT> em) {
            enumMap = em;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.003 -0400", hash_original_method = "C3DE5D46C4F9CFEF3C6B4695838239E5", hash_generated_method = "063732887140DDE2D3345C92C7674BBE")
        @Override
        public void clear() {
            enumMap.clear();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.004 -0400", hash_original_method = "4AC40C6458CB1EE4BF18663D9AB10FCB", hash_generated_method = "A57C0F594C6427259832674CA24914AD")
        @Override
        public boolean contains(Object object) {
            boolean isEqual = false;
            {
                Object enumKey = ((Map.Entry) object).getKey();
                Object enumValue = ((Map.Entry) object).getValue();
                {
                    boolean varC998F6B44C0D6A13C1F3DA4549FC80BB_826979488 = (enumMap.containsKey(enumKey));
                    {
                        VT value = enumMap.get(enumKey);
                        {
                            isEqual = enumValue == null;
                        } 
                        {
                            isEqual = value.equals(enumValue);
                        } 
                    } 
                } 
            } 
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1313729376 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1313729376;
            
            
            
                
                
                
                    
                    
                        
                    
                        
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.006 -0400", hash_original_method = "95EB2B60E0E6891B83EBE6118D53811C", hash_generated_method = "3F1680DE0ED200C62624AF62F3C0DD9A")
        @Override
        public Iterator<Map.Entry<KT, VT>> iterator() {
            Iterator<Map.Entry<KT, VT>> varB4EAC82CA7396A68D541C85D26508E83_126789828 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_126789828 = new EnumMapEntryIterator<Map.Entry<KT, VT>, KT, VT>(
                    new MapEntry.Type<Map.Entry<KT, VT>, KT, VT>() {
                        public Map.Entry<KT, VT> get(MapEntry<KT, VT> entry) {
                            return entry;
                        }
                    }, enumMap);
            varB4EAC82CA7396A68D541C85D26508E83_126789828.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_126789828;
            
            
                    
                        
                            
                        
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.006 -0400", hash_original_method = "B1FBE3FDE380AB91D92300437712D6CE", hash_generated_method = "BB3EF008EF598645FEFCA7A4E67EC1DA")
        @Override
        public boolean remove(Object object) {
            {
                boolean var4F9267015FE86EBB3F33114954B93ED1_1709098671 = (contains(object));
                {
                    enumMap.remove(((Map.Entry) object).getKey());
                } 
            } 
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_567575807 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_567575807;
            
            
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.007 -0400", hash_original_method = "C9EE7DD74ED1B4234C539DA28C6D21A7", hash_generated_method = "60354C9F5F057B346D446A3709476B80")
        @Override
        public int size() {
            int varF8250C8AC739D0318AEF09F1AC34F78B_961790683 = (enumMap.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_758391713 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_758391713;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.007 -0400", hash_original_method = "36EAFDE13B72544D308E66F5613D1161", hash_generated_method = "5FCDBA3F00789FC3A448A2CD3C63EDFE")
        @Override
        public Object[] toArray() {
            Object[] varB4EAC82CA7396A68D541C85D26508E83_1829482505 = null; 
            Object[] entryArray = new Object[enumMap.size()];
            varB4EAC82CA7396A68D541C85D26508E83_1829482505 = toArray(entryArray);
            varB4EAC82CA7396A68D541C85D26508E83_1829482505.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1829482505;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.008 -0400", hash_original_method = "9EABF255823509EF0FD5FF1AC40C33FF", hash_generated_method = "7FDAF7E1FB640CB002D235EF4778466C")
        @SuppressWarnings("unchecked")
        @Override
        public Object[] toArray(Object[] array) {
            Object[] varB4EAC82CA7396A68D541C85D26508E83_592910873 = null; 
            int size = enumMap.size();
            int index = 0;
            Object[] entryArray = array;
            {
                Class<?> clazz = array.getClass().getComponentType();
                entryArray = (Object[]) Array.newInstance(clazz, size);
            } 
            Iterator<Map.Entry<KT, VT>> iter = iterator();
            {
                Map.Entry<KT, VT> entry = iter.next();
                entryArray[index] = new MapEntry<KT, VT>(entry.getKey(), entry
                        .getValue());
            } 
            {
                entryArray[index] = null;
            } 
            varB4EAC82CA7396A68D541C85D26508E83_592910873 = entryArray;
            addTaint(array[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_592910873.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_592910873;
            
            
            
            
            
                
                
            
            
            
                
                
                        
            
            
                
            
            
        }

        
        
        public Map.Entry<KT, VT> get(MapEntry<KT, VT> entry) {
                            return entry;
                        }
        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.008 -0400", hash_original_field = "ACF5FEE0E990C707AF7445EBA9610512", hash_generated_field = "E1BAC054FBC7EDF33360B5E852ACA6E1")

    private static final long serialVersionUID = 458661240069192865L;
}

