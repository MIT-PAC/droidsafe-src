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
    private Class<K> keyType;
    transient Enum[] keys;
    transient Object[] values;
    transient boolean[] hasMapping;
    private transient int mappingsCount;
    transient int enumSize;
    private transient EnumMapEntrySet<K, V> entrySet = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.975 -0400", hash_original_method = "357B463561F8F38F36CCB594B2B44169", hash_generated_method = "791E7C0AFF1CAAE9F2C44295B633679E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public EnumMap(Class<K> keyType) {
        dsTaint.addTaint(keyType.dsTaint);
        initialization(keyType);
        // ---------- Original Method ----------
        //initialization(keyType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.975 -0400", hash_original_method = "4FB74096ACFD3857AE5FA5EC3BFDBAC1", hash_generated_method = "096C02D2216E853E567BE53BEE308320")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public EnumMap(EnumMap<K, ? extends V> map) {
        dsTaint.addTaint(map.dsTaint);
        initialization(map);
        // ---------- Original Method ----------
        //initialization(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.976 -0400", hash_original_method = "D652AC252782A7206F7D0F46E9A22736", hash_generated_method = "18A12889EADCE8ED9A4B28AF84B91BF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public EnumMap(Map<K, ? extends V> map) {
        dsTaint.addTaint(map.dsTaint);
        {
            initialization((EnumMap<K, V>) map);
        } //End block
        {
            {
                boolean var25E2C4EEA885A5E03E8C4F2DC9C5AD7F_819660023 = (map.size() == 0);
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
                boolean var65B366502464B6D98F6AF940C135B000_520053442 = (clazz.isEnum());
                {
                    initialization(clazz);
                } //End block
                {
                    initialization(clazz.getSuperclass());
                } //End block
            } //End collapsed parenthetic
            putAllImpl(map);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.976 -0400", hash_original_method = "2976CFC6D7176D4F9EDBE7E00A9203F9", hash_generated_method = "B80AABDFA9194B1768A3A2F9D08F6AA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.976 -0400", hash_original_method = "27D6CD5C74C8D110D14D6D471707F1DE", hash_generated_method = "D516AFAD9C784CFC4CF8E81030E6DBB4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    @Override
    public EnumMap<K, V> clone() {
        try 
        {
            EnumMap<K, V> enumMap;
            enumMap = (EnumMap<K, V>) super.clone();
            enumMap.initialization(this);
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        return (EnumMap<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //EnumMap<K, V> enumMap = (EnumMap<K, V>) super.clone();
            //enumMap.initialization(this);
            //return enumMap;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.976 -0400", hash_original_method = "0E01365989D6BCC217AC6A8119B6F173", hash_generated_method = "5763BB08BDA3B2F239C70BAD3CED2ACB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean containsKey(Object key) {
        dsTaint.addTaint(key.dsTaint);
        {
            boolean var2881195E5753FB7F055ED20418F3E365_653027922 = (isValidKeyType(key));
            {
                int keyOrdinal;
                keyOrdinal = ((Enum) key).ordinal();
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (isValidKeyType(key)) {
            //int keyOrdinal = ((Enum) key).ordinal();
            //return hasMapping[keyOrdinal];
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.977 -0400", hash_original_method = "FD4C7D9777FB1B3FC7F27A22C70B4A60", hash_generated_method = "40C306C1444EF0295DFDC430B5621A50")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean containsValue(Object value) {
        dsTaint.addTaint(value.dsTaint);
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
                        boolean var9645DA12622E821663F15BC1CC8202C0_579821479 = (hasMapping[i] && value.equals(values[i]));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.977 -0400", hash_original_method = "1D25B0764045DBFAD19E9C060947BE81", hash_generated_method = "4D87143F443887486D9D592913243DF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        {
            entrySet = new EnumMapEntrySet<K, V>(this);
        } //End block
        return (Set<Map.Entry<K, V>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (entrySet == null) {
            //entrySet = new EnumMapEntrySet<K, V>(this);
        //}
        //return entrySet;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.977 -0400", hash_original_method = "AC8EB1BDF42FFE99FA259DC7FD35D677", hash_generated_method = "6EC83E070C73CE1FFF03D684A407B8B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        {
            boolean varA3157AA9BC21D9DE63321077403F3F07_1478161578 = (super.equals(object));
        } //End block
        EnumMap<K, V> enumMap;
        enumMap = (EnumMap<K, V>) object;
        {
            boolean varD0EFCA813FC7B10D8353B658CADEDA24_1259949268 = (keyType != enumMap.keyType || size() != enumMap.size());
        } //End collapsed parenthetic
        boolean var86C56C7BA36A8C7548B1E6C40C5BF1BD_233323513 = (Arrays.equals(hasMapping, enumMap.hasMapping)
                && Arrays.equals(values, enumMap.values));
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.978 -0400", hash_original_method = "D1D1E4650582CB36D48A88314ACBD849", hash_generated_method = "4A6CA4530AC78E1723CF76BA0BD125D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    @SuppressWarnings("unchecked")
    public V get(Object key) {
        dsTaint.addTaint(key.dsTaint);
        {
            boolean varE7267BA1C950E6E221E46F63E7F428DF_1310366705 = (!isValidKeyType(key));
        } //End collapsed parenthetic
        int keyOrdinal;
        keyOrdinal = ((Enum) key).ordinal();
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!isValidKeyType(key)) {
            //return null;
        //}
        //int keyOrdinal = ((Enum) key).ordinal();
        //return (V) values[keyOrdinal];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.978 -0400", hash_original_method = "ADC2E4F8D882C3AAF1D0303EAF8C1F23", hash_generated_method = "344D48144731421461FF798C4E9EC6F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Set<K> keySet() {
        {
            keySet = new EnumMapKeySet<K, V>(this);
        } //End block
        return (Set<K>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (keySet == null) {
            //keySet = new EnumMapKeySet<K, V>(this);
        //}
        //return keySet;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.978 -0400", hash_original_method = "0FAB728DBD67C753D3CD4965FE16DA6D", hash_generated_method = "742BD97A2CC0D04B30BB5D065080D424")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    @SuppressWarnings("unchecked")
    public V put(K key, V value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        V varAD76EA2891FFFBC70A2EF53F545B5B4F_992936964 = (putImpl(key, value));
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return putImpl(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.978 -0400", hash_original_method = "57B3987EA7E50826E0AAD0198F968E42", hash_generated_method = "8711BEB6E3B50523980A9B56B6635DDF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    @SuppressWarnings("unchecked")
    public void putAll(Map<? extends K, ? extends V> map) {
        dsTaint.addTaint(map.dsTaint);
        putAllImpl(map);
        // ---------- Original Method ----------
        //putAllImpl(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.979 -0400", hash_original_method = "2531311459BDF6AE48398CDBD33066ED", hash_generated_method = "0E5D55FDD7570940F459501CC840A911")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    @SuppressWarnings("unchecked")
    public V remove(Object key) {
        dsTaint.addTaint(key.dsTaint);
        {
            boolean varE7267BA1C950E6E221E46F63E7F428DF_2143911485 = (!isValidKeyType(key));
        } //End collapsed parenthetic
        int keyOrdinal;
        keyOrdinal = ((Enum) key).ordinal();
        {
            hasMapping[keyOrdinal] = false;
        } //End block
        V oldValue;
        oldValue = (V) values[keyOrdinal];
        values[keyOrdinal] = null;
        return (V)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.979 -0400", hash_original_method = "9B5434C347C8B5979021C04F4F7D3AC0", hash_generated_method = "324259DF9190896414EEEB63D6126969")
    @DSModeled(DSC.SAFE)
    @Override
    public int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mappingsCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.979 -0400", hash_original_method = "3209B6B28BA147378CF80090EC868BEA", hash_generated_method = "31A43C13D76B013F733B33BE83E58D7E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Collection<V> values() {
        {
            valuesCollection = new EnumMapValueCollection<K, V>(this);
        } //End block
        return (Collection<V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (valuesCollection == null) {
            //valuesCollection = new EnumMapValueCollection<K, V>(this);
        //}
        //return valuesCollection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.979 -0400", hash_original_method = "DC4D5C48E92024F936CD723136F7EC43", hash_generated_method = "D2079DFB4BCCF053C1CE927B9E7F749E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        dsTaint.addTaint(stream.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.980 -0400", hash_original_method = "7E98F968D6A8FBC0CE4D31A606E7DB44", hash_generated_method = "A4BAB79AD9E52ED630095CDC087FFB5A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(ObjectOutputStream stream) throws IOException {
        dsTaint.addTaint(stream.dsTaint);
        stream.defaultWriteObject();
        stream.writeInt(mappingsCount);
        Iterator<Map.Entry<K, V>> iterator;
        iterator = entrySet().iterator();
        {
            boolean var15F7FE2AD7E10C613CA4B915023EF041_2070870280 = (iterator.hasNext());
            {
                Map.Entry<K, V> entry;
                entry = iterator.next();
                stream.writeObject(entry.getKey());
                stream.writeObject(entry.getValue());
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.980 -0400", hash_original_method = "AB7EF2A62AD1394405351664F3033DEE", hash_generated_method = "C2A2FDF681FCB0F801081BC87B3713BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isValidKeyType(Object key) {
        dsTaint.addTaint(key.dsTaint);
        {
            boolean var747CFA0C5BD42E365CF87FEF40B6940C_304310547 = (key != null && keyType.isInstance(key));
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (key != null && keyType.isInstance(key)) {
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.980 -0400", hash_original_method = "E2B9C0EDB3E88C666CBFA70F3A732433", hash_generated_method = "AACDA1FBB5AC1B410DB01FDC33B38EEB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    private void initialization(EnumMap enumMap) {
        dsTaint.addTaint(enumMap.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.980 -0400", hash_original_method = "74B7FF14F292272934F29B542A6B3535", hash_generated_method = "DCE37C9DBD3186B18E567D586CDC30DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initialization(Class<K> type) {
        dsTaint.addTaint(type.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.981 -0400", hash_original_method = "394364EB9AA119D86D9EB30D7D288B77", hash_generated_method = "76F1E6847A03EF73615A3F4CFC6BF170")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    private void putAllImpl(Map map) {
        dsTaint.addTaint(map.dsTaint);
        Iterator iter;
        iter = map.entrySet().iterator();
        {
            boolean varADABAFEBBAB7E585DD903333BD7F20A8_1934493385 = (iter.hasNext());
            {
                Map.Entry entry;
                entry = (Map.Entry) iter.next();
                putImpl((K) entry.getKey(), (V) entry.getValue());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //Iterator iter = map.entrySet().iterator();
        //while (iter.hasNext()) {
            //Map.Entry entry = (Map.Entry) iter.next();
            //putImpl((K) entry.getKey(), (V) entry.getValue());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.981 -0400", hash_original_method = "1C83BB92B4CC56A2EE4CEBB2A5F2E79E", hash_generated_method = "F42E4361A27DDDF1B5EFD213F3DBBEE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    private V putImpl(K key, V value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
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
        return (V)dsTaint.getTaint();
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
        private EnumMap<KT, VT> enumMap;
        private int ordinal;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.981 -0400", hash_original_method = "04522B4DB01C65E7C5169DAAB9B0A8B0", hash_generated_method = "1EFDCDAECA451C0CA6C9993805076540")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Entry(KT theKey, VT theValue, EnumMap<KT, VT> em) {
            super(theKey, theValue);
            dsTaint.addTaint(theKey.dsTaint);
            dsTaint.addTaint(em.dsTaint);
            dsTaint.addTaint(theValue.dsTaint);
            ordinal = ((Enum) theKey).ordinal();
            // ---------- Original Method ----------
            //enumMap = em;
            //ordinal = ((Enum) theKey).ordinal();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.982 -0400", hash_original_method = "8DD0429C812BC3CB5F9E4D12A50ED42A", hash_generated_method = "1052117AE352A0E9113164F94D2E47FC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @SuppressWarnings("unchecked")
        @Override
        public boolean equals(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean isEqual;
            isEqual = false;
            {
                Map.Entry<KT, VT> entry;
                entry = (Map.Entry<KT, VT>) object;
                Object enumKey;
                enumKey = entry.getKey();
                {
                    boolean var3FA36501E027AB1388F65D474C9CD126_1060579422 = (key.equals(enumKey));
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
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.982 -0400", hash_original_method = "1D3BE2C1E2DBC9C20DAD39B42D607656", hash_generated_method = "15A396657E4C408C0A24117E5BF8C0B5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int var335CA3F4B5A3CBFD417F696F0F465E58_451168527 = ((enumMap.keys[ordinal] == null ? 0 : enumMap.keys[ordinal]
                    .hashCode())
                    ^ (enumMap.values[ordinal] == null ? 0
                            : enumMap.values[ordinal].hashCode())); //DSFIXME:  CODE0008: Nested ternary operator in expression
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return (enumMap.keys[ordinal] == null ? 0 : enumMap.keys[ordinal]
                    //.hashCode())
                    //^ (enumMap.values[ordinal] == null ? 0
                            //: enumMap.values[ordinal].hashCode());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.982 -0400", hash_original_method = "E6F3009D3E7934C3E89ABA04C91C1657", hash_generated_method = "AF51F5A37CFCB6644B553FFDA071CF6F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @SuppressWarnings("unchecked")
        @Override
        public KT getKey() {
            checkEntryStatus();
            return (KT)dsTaint.getTaint();
            // ---------- Original Method ----------
            //checkEntryStatus();
            //return (KT) enumMap.keys[ordinal];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.982 -0400", hash_original_method = "F5CFE00A2E55AC6B5D81DB2B62FB299C", hash_generated_method = "77E6D784B7AE4C1E6097978ED7314898")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @SuppressWarnings("unchecked")
        @Override
        public VT getValue() {
            checkEntryStatus();
            return (VT)dsTaint.getTaint();
            // ---------- Original Method ----------
            //checkEntryStatus();
            //return (VT) enumMap.values[ordinal];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.983 -0400", hash_original_method = "2B70B6F95ECF307373567A039C54EE32", hash_generated_method = "28EE275F67328D806770C92599535489")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @SuppressWarnings("unchecked")
        @Override
        public VT setValue(VT value) {
            dsTaint.addTaint(value.dsTaint);
            checkEntryStatus();
            VT var428042B4DC412FEFE51701ECC9C2CB8A_2136295804 = (enumMap.put((KT) enumMap.keys[ordinal], value));
            return (VT)dsTaint.getTaint();
            // ---------- Original Method ----------
            //checkEntryStatus();
            //return enumMap.put((KT) enumMap.keys[ordinal], value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.983 -0400", hash_original_method = "7B70A2A5E5AF6D0A4A4180BECB8A721B", hash_generated_method = "C9CB0AB5D15E8A32398E801B6ED030F5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            StringBuilder result;
            result = new StringBuilder(enumMap.keys[ordinal]
                    .toString());
            result.append("=");
            result.append(enumMap.values[ordinal] == null
                    ? "null" : enumMap.values[ordinal].toString());
            String varEC2CAD6F4392C35EA2158E6C5520B613_270206485 = (result.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //StringBuilder result = new StringBuilder(enumMap.keys[ordinal]
                    //.toString());
            //result.append("=");
            //result.append(enumMap.values[ordinal] == null
                    //? "null" : enumMap.values[ordinal].toString());
            //return result.toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.983 -0400", hash_original_method = "D6BC45043628808E78169E86857FDCA6", hash_generated_method = "8038D89382E041C2E7CD0D2C11997BDD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
        int position = 0;
        int prePosition = -1;
        EnumMap<KT, VT> enumMap;
        MapEntry.Type<E, KT, VT> type;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.984 -0400", hash_original_method = "9ED4E2039768E2794B08864F6EFD4280", hash_generated_method = "F49FB992910722F8FA6E858408EBA3E7")
        @DSModeled(DSC.SAFE)
         EnumMapIterator(MapEntry.Type<E, KT, VT> value, EnumMap<KT, VT> em) {
            dsTaint.addTaint(value.dsTaint);
            dsTaint.addTaint(em.dsTaint);
            // ---------- Original Method ----------
            //enumMap = em;
            //type = value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.984 -0400", hash_original_method = "6D6AB5C8509128D2C00828238AD4C0D9", hash_generated_method = "293CF3FE92F36C502FC8B1311D8ACABC")
        @DSModeled(DSC.SAFE)
        public boolean hasNext() {
            int length;
            length = enumMap.enumSize;
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //int length = enumMap.enumSize;
            //for (; position < length; position++) {
                //if (enumMap.hasMapping[position]) {
                    //break;
                //}
            //}
            //return position != length;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.984 -0400", hash_original_method = "8136BC21B836EBF6A2416BD2D7F3270E", hash_generated_method = "F7DE41598D9AE5B1723E40E1E3833D8C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @SuppressWarnings("unchecked")
        public E next() {
            {
                boolean var61E0EA93C8F2038A69462393E2D5DF33_1678796956 = (!hasNext());
                {
                    if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                } //End block
            } //End collapsed parenthetic
            prePosition = position++;
            E var3B82ED50194ED0EE1A6EC01FA97D17C2_952266962 = (type.get(new MapEntry(enumMap.keys[prePosition],
                    enumMap.values[prePosition])));
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (!hasNext()) {
                //throw new NoSuchElementException();
            //}
            //prePosition = position++;
            //return type.get(new MapEntry(enumMap.keys[prePosition],
                    //enumMap.values[prePosition]));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.984 -0400", hash_original_method = "A29557D70FF021A737315678DDBC3059", hash_generated_method = "022234A89EDA9DECBBFDD48346827F6C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.985 -0400", hash_original_method = "D4FD3F1C9995E81E934F03FC5256A25C", hash_generated_method = "4A0999210E2DE2A62116506CC4C9C3D9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        @SuppressWarnings("unchecked")
        public String toString() {
            {
                String varF45A451555C5FF491E4319B524E3196B_2141772258 = (super.toString());
            } //End block
            String var3E2FE6310557E2D427AB42E907F3B80B_2111628271 = (type.get(
                    new MapEntry(enumMap.keys[prePosition],
                            enumMap.values[prePosition])).toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //if (-1 == prePosition) {
                //return super.toString();
            //}
            //return type.get(
                    //new MapEntry(enumMap.keys[prePosition],
                            //enumMap.values[prePosition])).toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.985 -0400", hash_original_method = "8DC9DAAEB887A2B3089BD6592C09E5DA", hash_generated_method = "550AE755F21ED782D17504DB2A2A7655")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
        private EnumMap<KT, VT> enumMap;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.987 -0400", hash_original_method = "2A1696B691A1F64388AB3AC9907332E4", hash_generated_method = "733D14F7C460490B875B41944C568ADD")
        @DSModeled(DSC.SAFE)
         EnumMapKeySet(EnumMap<KT, VT> em) {
            dsTaint.addTaint(em.dsTaint);
            // ---------- Original Method ----------
            //enumMap = em;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.987 -0400", hash_original_method = "C3DE5D46C4F9CFEF3C6B4695838239E5", hash_generated_method = "063732887140DDE2D3345C92C7674BBE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void clear() {
            enumMap.clear();
            // ---------- Original Method ----------
            //enumMap.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.987 -0400", hash_original_method = "434CC1CFD8E42092C734D9BD095515B9", hash_generated_method = "BE4A0447AB7C72AD03B815F8435D3C50")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean contains(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean varE1D05B251B8CFF246CADE02385321F75_945445469 = (enumMap.containsKey(object));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return enumMap.containsKey(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.988 -0400", hash_original_method = "A4EABEDB06E5BDF24065F571F359AF57", hash_generated_method = "2133378A9088450BA1DB8E98141E8C25")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        @SuppressWarnings("unchecked")
        public Iterator iterator() {
            Iterator var45615C7EB1A263BAE7BB88181991B2AF_48150291 = (new EnumMapIterator<KT, KT, VT>(
                    new MapEntry.Type<KT, KT, VT>() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.987 -0400", hash_original_method = "58D5C15AA7C95D597054A9860FD7B3EB", hash_generated_method = "C1AFEE60A651EF6B7D055ED59853455E")
                @DSModeled(DSC.SAFE)
                public KT get(MapEntry<KT, VT> entry) {
                    dsTaint.addTaint(entry.dsTaint);
                    return (KT)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //return entry.key;
                }
}, enumMap));
            return (Iterator)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new EnumMapIterator<KT, KT, VT>(
                    //new MapEntry.Type<KT, KT, VT>() {
                        //public KT get(MapEntry<KT, VT> entry) {
                            //return entry.key;
                        //}
                    //}, enumMap);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.989 -0400", hash_original_method = "B8F9F39AE912D64223C40421DFD1515A", hash_generated_method = "8F16D074D046F6F2B5013EAD42E03C94")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        @SuppressWarnings("unchecked")
        public boolean remove(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                boolean var4F9267015FE86EBB3F33114954B93ED1_255860117 = (contains(object));
                {
                    enumMap.remove(object);
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (contains(object)) {
                //enumMap.remove(object);
                //return true;
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.989 -0400", hash_original_method = "C9EE7DD74ED1B4234C539DA28C6D21A7", hash_generated_method = "AB54A529D1DD31BE37B48893C306D813")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int size() {
            int varF8250C8AC739D0318AEF09F1AC34F78B_393232908 = (enumMap.size());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return enumMap.size();
        }

        
    }


    
    private static class EnumMapValueCollection<KT extends Enum<KT>, VT> extends AbstractCollection<VT> {
        private EnumMap<KT, VT> enumMap;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.989 -0400", hash_original_method = "1A0661F4095C8F41E606FE019F34B01E", hash_generated_method = "79A126DE71301A81BBA268D693BAD7B6")
        @DSModeled(DSC.SAFE)
         EnumMapValueCollection(EnumMap<KT, VT> em) {
            dsTaint.addTaint(em.dsTaint);
            // ---------- Original Method ----------
            //enumMap = em;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.990 -0400", hash_original_method = "C3DE5D46C4F9CFEF3C6B4695838239E5", hash_generated_method = "063732887140DDE2D3345C92C7674BBE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void clear() {
            enumMap.clear();
            // ---------- Original Method ----------
            //enumMap.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.990 -0400", hash_original_method = "F0FBCB059002559902B972108CF0BABE", hash_generated_method = "53F868C3E28699DDD3F163B2B533BD6D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean contains(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean var2DAB091BFC98C0153936AB7B719C95FF_1334638240 = (enumMap.containsValue(object));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return enumMap.containsValue(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.990 -0400", hash_original_method = "BC6C06395E1460CC49F247C03E1763F0", hash_generated_method = "637B0B94C984403A9EF46F695AF7F114")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @SuppressWarnings("unchecked")
        @Override
        public Iterator iterator() {
            Iterator var0F9FF78520236EB01684E540F196D88C_2054144653 = (new EnumMapIterator<VT, KT, VT>(
                    new MapEntry.Type<VT, KT, VT>() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.990 -0400", hash_original_method = "C542D68881AE52AD0D43DA03AB0FAD85", hash_generated_method = "A2A32DAB2E75E42CE9803BCEAC4923B6")
                @DSModeled(DSC.SAFE)
                public VT get(MapEntry<KT, VT> entry) {
                    dsTaint.addTaint(entry.dsTaint);
                    return (VT)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //return entry.value;
                }
}, enumMap));
            return (Iterator)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new EnumMapIterator<VT, KT, VT>(
                    //new MapEntry.Type<VT, KT, VT>() {
                        //public VT get(MapEntry<KT, VT> entry) {
                            //return entry.value;
                        //}
                    //}, enumMap);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.991 -0400", hash_original_method = "47E37FB3671E07CE32BC2BA28A816FCA", hash_generated_method = "15F7EA339AE14B491F6EF7C5D072B9EF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean remove(Object object) {
            dsTaint.addTaint(object.dsTaint);
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
                            boolean var37BC2A140D0EB4ED70B9893BBE73815F_1667472740 = (enumMap.hasMapping[i]
                            && object.equals(enumMap.values[i]));
                            {
                                enumMap.remove(enumMap.keys[i]);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.991 -0400", hash_original_method = "C9EE7DD74ED1B4234C539DA28C6D21A7", hash_generated_method = "3F41136DC76C88EB0B35492F1652A14B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int size() {
            int varF8250C8AC739D0318AEF09F1AC34F78B_214313255 = (enumMap.size());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return enumMap.size();
        }

        
    }


    
    private static class EnumMapEntryIterator<E, KT extends Enum<KT>, VT> extends EnumMapIterator<E, KT, VT> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.991 -0400", hash_original_method = "4B20A4930FDD81120A40D2421C6DB306", hash_generated_method = "C1D667C3BAB0027919EF7AFAA265396B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         EnumMapEntryIterator(MapEntry.Type<E, KT, VT> value, EnumMap<KT, VT> em) {
            super(value, em);
            dsTaint.addTaint(value.dsTaint);
            dsTaint.addTaint(em.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.991 -0400", hash_original_method = "AA0A985577200C3410BBA8066828BEEB", hash_generated_method = "39B272EFA6B46A3952C26F4278231F72")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @SuppressWarnings("unchecked")
        @Override
        public E next() {
            {
                boolean var61E0EA93C8F2038A69462393E2D5DF33_200782162 = (!hasNext());
                {
                    if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                } //End block
            } //End collapsed parenthetic
            prePosition = position++;
            E varE232D59F0DCB35A2BB16D270A10ED093_2023695182 = (type.get(new Entry<KT, VT>((KT) enumMap.keys[prePosition],
                    (VT) enumMap.values[prePosition], enumMap)));
            return (E)dsTaint.getTaint();
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
        private EnumMap<KT, VT> enumMap;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.992 -0400", hash_original_method = "616E4B9747EFF9433BD58C5F15DEC121", hash_generated_method = "CFD97ACB951D774C0614832EA276495F")
        @DSModeled(DSC.SAFE)
         EnumMapEntrySet(EnumMap<KT, VT> em) {
            dsTaint.addTaint(em.dsTaint);
            // ---------- Original Method ----------
            //enumMap = em;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.992 -0400", hash_original_method = "C3DE5D46C4F9CFEF3C6B4695838239E5", hash_generated_method = "063732887140DDE2D3345C92C7674BBE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void clear() {
            enumMap.clear();
            // ---------- Original Method ----------
            //enumMap.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.993 -0400", hash_original_method = "4AC40C6458CB1EE4BF18663D9AB10FCB", hash_generated_method = "8C0752C756872346F463E5A97A3EF078")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean contains(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean isEqual;
            isEqual = false;
            {
                Object enumKey;
                enumKey = ((Map.Entry) object).getKey();
                Object enumValue;
                enumValue = ((Map.Entry) object).getValue();
                {
                    boolean varC998F6B44C0D6A13C1F3DA4549FC80BB_1267724372 = (enumMap.containsKey(enumKey));
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
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.993 -0400", hash_original_method = "95EB2B60E0E6891B83EBE6118D53811C", hash_generated_method = "A592AB87E5CDED3A77AD7CCF9B38CBDE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Iterator<Map.Entry<KT, VT>> iterator() {
            Iterator<Map.Entry<KT, VT>> var36DEC9CE7F4C3A237CE69EEA5F96ACBB_458077033 = (new EnumMapEntryIterator<Map.Entry<KT, VT>, KT, VT>(
                    new MapEntry.Type<Map.Entry<KT, VT>, KT, VT>() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.993 -0400", hash_original_method = "E6C5689ECDF5DCF09D122C660DDB94F0", hash_generated_method = "CC957E1A4FE490D0E356D6236A714F3C")
                @DSModeled(DSC.SAFE)
                public Map.Entry<KT, VT> get(MapEntry<KT, VT> entry) {
                    dsTaint.addTaint(entry.dsTaint);
                    return (Map.Entry<KT, VT>)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //return entry;
                }
}, enumMap));
            return (Iterator<Map.Entry<KT, VT>>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new EnumMapEntryIterator<Map.Entry<KT, VT>, KT, VT>(
                    //new MapEntry.Type<Map.Entry<KT, VT>, KT, VT>() {
                        //public Map.Entry<KT, VT> get(MapEntry<KT, VT> entry) {
                            //return entry;
                        //}
                    //}, enumMap);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.994 -0400", hash_original_method = "B1FBE3FDE380AB91D92300437712D6CE", hash_generated_method = "B6C598AB560E54329BF23C589053BD4E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean remove(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                boolean var4F9267015FE86EBB3F33114954B93ED1_1166516477 = (contains(object));
                {
                    enumMap.remove(((Map.Entry) object).getKey());
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (contains(object)) {
                //enumMap.remove(((Map.Entry) object).getKey());
                //return true;
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.994 -0400", hash_original_method = "C9EE7DD74ED1B4234C539DA28C6D21A7", hash_generated_method = "CDB455227AF126C2EBE2A9FECF15C420")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int size() {
            int varF8250C8AC739D0318AEF09F1AC34F78B_1057582322 = (enumMap.size());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return enumMap.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.994 -0400", hash_original_method = "36EAFDE13B72544D308E66F5613D1161", hash_generated_method = "2D41B7991BDA0D44A17A10EDF45CE81D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Object[] toArray() {
            Object[] entryArray;
            entryArray = new Object[enumMap.size()];
            Object[] var19A6248894A75947800D588F975F7C81_1759688754 = (toArray(entryArray));
            return (Object[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //Object[] entryArray = new Object[enumMap.size()];
            //return toArray(entryArray);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.994 -0400", hash_original_method = "9EABF255823509EF0FD5FF1AC40C33FF", hash_generated_method = "3F36868C66886263BEEC2FB8AC9B9BE2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @SuppressWarnings("unchecked")
        @Override
        public Object[] toArray(Object[] array) {
            dsTaint.addTaint(array[0].dsTaint);
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
            return (Object[])dsTaint.getTaint();
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


    
    private static final long serialVersionUID = 458661240069192865L;
}

