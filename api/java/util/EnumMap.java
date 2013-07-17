package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;

public class EnumMap<K extends Enum<K>, V> extends AbstractMap<K, V> implements Serializable, Cloneable, Map<K, V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.590 -0400", hash_original_field = "056E0360B75D77ECE0AE955FE59BF15D", hash_generated_field = "784B4CB2B0AA1435846B96ECF749418D")

    private Class<K> keyType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.590 -0400", hash_original_field = "14F802E1FBA977727845E8872C1743A7", hash_generated_field = "1296F5D01B4090600677F6D5CA1FE096")

    transient Enum[] keys;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.590 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "4150C40DB1D8CEF16DAAF4E72141B18D")

    transient Object[] values;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.590 -0400", hash_original_field = "EB33C464BB85B740774E660ED19A4D23", hash_generated_field = "2AFD2ACFCCD988AD1A9DB860BFAFC15E")

    transient boolean[] hasMapping;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.590 -0400", hash_original_field = "80ADFCE58E22D304D276F1C6D95D4EF2", hash_generated_field = "204CA002E2DD9253A57F08EEC28189B5")

    private transient int mappingsCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.590 -0400", hash_original_field = "2FF4AF744F4AEE0F57EA018EF3FA7088", hash_generated_field = "2AA1CC9DCAEA03EA6B04E81906ED8EEA")

    transient int enumSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.590 -0400", hash_original_field = "22D97DDA025E6292D4C7D4F7678A4EEA", hash_generated_field = "60757B7103C3702D9A64F686BFD44FCF")

    private transient EnumMapEntrySet<K, V> entrySet = null;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.591 -0400", hash_original_method = "357B463561F8F38F36CCB594B2B44169", hash_generated_method = "D728EB7714A45C35A27862A2389C889E")
    public  EnumMap(Class<K> keyType) {
        addTaint(keyType.getTaint());
        initialization(keyType);
        // ---------- Original Method ----------
        //initialization(keyType);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.591 -0400", hash_original_method = "4FB74096ACFD3857AE5FA5EC3BFDBAC1", hash_generated_method = "DE0DEE09D8F2B560E6E7F0765E6E4F06")
    public  EnumMap(EnumMap<K, ? extends V> map) {
        addTaint(map.getTaint());
        initialization(map);
        // ---------- Original Method ----------
        //initialization(map);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.591 -0400", hash_original_method = "D652AC252782A7206F7D0F46E9A22736", hash_generated_method = "9CC33E4068876BFF8F77F0DCBF257B50")
    @SuppressWarnings("unchecked")
    public  EnumMap(Map<K, ? extends V> map) {
        addTaint(map.getTaint());
        if(map instanceof EnumMap)        
        {
            initialization((EnumMap<K, V>) map);
        } //End block
        else
        {
            if(map.size() == 0)            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_715994921 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_715994921.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_715994921;
            } //End block
            Iterator<K> iter = map.keySet().iterator();
            K enumKey = iter.next();
            Class clazz = enumKey.getClass();
            if(clazz.isEnum())            
            {
                initialization(clazz);
            } //End block
            else
            {
                initialization(clazz.getSuperclass());
            } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.592 -0400", hash_original_method = "2976CFC6D7176D4F9EDBE7E00A9203F9", hash_generated_method = "B80AABDFA9194B1768A3A2F9D08F6AA8")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.592 -0400", hash_original_method = "27D6CD5C74C8D110D14D6D471707F1DE", hash_generated_method = "12AD123C275828B67F145ADFD21A2D90")
    @SuppressWarnings("unchecked")
    @Override
    public EnumMap<K, V> clone() {
        try 
        {
            EnumMap<K, V> enumMap = (EnumMap<K, V>) super.clone();
            enumMap.initialization(this);
EnumMap<K, V> var93535FC7597EF533BF9378E6783BB0AC_1899359267 =             enumMap;
            var93535FC7597EF533BF9378E6783BB0AC_1899359267.addTaint(taint);
            return var93535FC7597EF533BF9378E6783BB0AC_1899359267;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_1475084858 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_1475084858.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_1475084858;
        } //End block
        // ---------- Original Method ----------
        //try {
            //EnumMap<K, V> enumMap = (EnumMap<K, V>) super.clone();
            //enumMap.initialization(this);
            //return enumMap;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.593 -0400", hash_original_method = "0E01365989D6BCC217AC6A8119B6F173", hash_generated_method = "B7BB2C106F5BF07E0AE7A4B899C0BCE7")
    @Override
    public boolean containsKey(Object key) {
        addTaint(key.getTaint());
        if(isValidKeyType(key))        
        {
            int keyOrdinal = ((Enum) key).ordinal();
            boolean var374E637230383A96BDB1617063C947D4_1272855673 = (hasMapping[keyOrdinal]);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1500108455 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1500108455;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_764078341 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_584377857 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_584377857;
        // ---------- Original Method ----------
        //if (isValidKeyType(key)) {
            //int keyOrdinal = ((Enum) key).ordinal();
            //return hasMapping[keyOrdinal];
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.594 -0400", hash_original_method = "FD4C7D9777FB1B3FC7F27A22C70B4A60", hash_generated_method = "654F8B9EE5C15EE1B4DDD43D15DC049B")
    @Override
    public boolean containsValue(Object value) {
        addTaint(value.getTaint());
        if(value == null)        
        {
for(int i = 0;i < enumSize;i++)
            {
                if(hasMapping[i] && values[i] == null)                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_601158996 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1100311970 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1100311970;
                } //End block
            } //End block
        } //End block
        else
        {
for(int i = 0;i < enumSize;i++)
            {
                if(hasMapping[i] && value.equals(values[i]))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_1754083380 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_646593383 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_646593383;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_2057171932 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2037062860 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2037062860;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.596 -0400", hash_original_method = "1D25B0764045DBFAD19E9C060947BE81", hash_generated_method = "8B89555382F557DC782057B5415E9994")
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        if(entrySet == null)        
        {
            entrySet = new EnumMapEntrySet<K, V>(this);
        } //End block
Set<Map.Entry<K, V>> var844F1DC6137EC02DBA16CAD3ADE04B13_1573660 =         entrySet;
        var844F1DC6137EC02DBA16CAD3ADE04B13_1573660.addTaint(taint);
        return var844F1DC6137EC02DBA16CAD3ADE04B13_1573660;
        // ---------- Original Method ----------
        //if (entrySet == null) {
            //entrySet = new EnumMapEntrySet<K, V>(this);
        //}
        //return entrySet;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.596 -0400", hash_original_method = "AC8EB1BDF42FFE99FA259DC7FD35D677", hash_generated_method = "545565E0A04297A6C761DA2AA4EF22CB")
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        if(this == object)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_527581744 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_931338031 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_931338031;
        } //End block
        if(!(object instanceof EnumMap))        
        {
            boolean var75EAEC12DA10D524D5BB1C4333283B8A_1482065747 = (super.equals(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_308174279 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_308174279;
        } //End block
        EnumMap<K, V> enumMap = (EnumMap<K, V>) object;
        if(keyType != enumMap.keyType || size() != enumMap.size())        
        {
            boolean var68934A3E9455FA72420237EB05902327_693207080 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_742575288 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_742575288;
        } //End block
        boolean var9F6C49E239B2F806D5BF401076D8C7F5_1216450902 = (Arrays.equals(hasMapping, enumMap.hasMapping)
                && Arrays.equals(values, enumMap.values));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1709386738 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1709386738;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.597 -0400", hash_original_method = "D1D1E4650582CB36D48A88314ACBD849", hash_generated_method = "458E14CA3E4412CDA7FBBA7ADEEF12FF")
    @Override
    @SuppressWarnings("unchecked")
    public V get(Object key) {
        addTaint(key.getTaint());
        if(!isValidKeyType(key))        
        {
V var540C13E9E156B687226421B24F2DF178_399124525 =             null;
            var540C13E9E156B687226421B24F2DF178_399124525.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_399124525;
        } //End block
        int keyOrdinal = ((Enum) key).ordinal();
V varC4A454773D3C3B58D8F0D07F64F91612_1129109630 =         (V) values[keyOrdinal];
        varC4A454773D3C3B58D8F0D07F64F91612_1129109630.addTaint(taint);
        return varC4A454773D3C3B58D8F0D07F64F91612_1129109630;
        // ---------- Original Method ----------
        //if (!isValidKeyType(key)) {
            //return null;
        //}
        //int keyOrdinal = ((Enum) key).ordinal();
        //return (V) values[keyOrdinal];
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.597 -0400", hash_original_method = "ADC2E4F8D882C3AAF1D0303EAF8C1F23", hash_generated_method = "29F648174FBC406C5AD688244011B8C3")
    @Override
    public Set<K> keySet() {
        if(keySet == null)        
        {
            keySet = new EnumMapKeySet<K, V>(this);
        } //End block
Set<K> varCB23CF4AFB8B7AE1843E733C4B0CC600_2143342539 =         keySet;
        varCB23CF4AFB8B7AE1843E733C4B0CC600_2143342539.addTaint(taint);
        return varCB23CF4AFB8B7AE1843E733C4B0CC600_2143342539;
        // ---------- Original Method ----------
        //if (keySet == null) {
            //keySet = new EnumMapKeySet<K, V>(this);
        //}
        //return keySet;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.598 -0400", hash_original_method = "0FAB728DBD67C753D3CD4965FE16DA6D", hash_generated_method = "035358D943ABD0C4952276CAE8F281A0")
    @Override
    @SuppressWarnings("unchecked")
    public V put(K key, V value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
V var9BB0B2FF0AC3AF2A11FC956ABA5FBB6B_365580803 =         putImpl(key, value);
        var9BB0B2FF0AC3AF2A11FC956ABA5FBB6B_365580803.addTaint(taint);
        return var9BB0B2FF0AC3AF2A11FC956ABA5FBB6B_365580803;
        // ---------- Original Method ----------
        //return putImpl(key, value);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.598 -0400", hash_original_method = "57B3987EA7E50826E0AAD0198F968E42", hash_generated_method = "AD80324C19FD450664605D07167C9609")
    @Override
    @SuppressWarnings("unchecked")
    public void putAll(Map<? extends K, ? extends V> map) {
        addTaint(map.getTaint());
        putAllImpl(map);
        // ---------- Original Method ----------
        //putAllImpl(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.598 -0400", hash_original_method = "2531311459BDF6AE48398CDBD33066ED", hash_generated_method = "1E87C04AFB47B49E5DA4D6054D79D762")
    @Override
    @SuppressWarnings("unchecked")
    public V remove(Object key) {
        addTaint(key.getTaint());
        if(!isValidKeyType(key))        
        {
V var540C13E9E156B687226421B24F2DF178_1427045758 =             null;
            var540C13E9E156B687226421B24F2DF178_1427045758.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1427045758;
        } //End block
        int keyOrdinal = ((Enum) key).ordinal();
        if(hasMapping[keyOrdinal])        
        {
            hasMapping[keyOrdinal] = false;
            mappingsCount--;
        } //End block
        V oldValue = (V) values[keyOrdinal];
        values[keyOrdinal] = null;
V var8CDBD2181CBEF5C2129AFFA68C014D4A_2020337539 =         oldValue;
        var8CDBD2181CBEF5C2129AFFA68C014D4A_2020337539.addTaint(taint);
        return var8CDBD2181CBEF5C2129AFFA68C014D4A_2020337539;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.599 -0400", hash_original_method = "9B5434C347C8B5979021C04F4F7D3AC0", hash_generated_method = "E67E40A57D7512EDB08499A5406808B5")
    @Override
    public int size() {
        int var80ADFCE58E22D304D276F1C6D95D4EF2_1410637665 = (mappingsCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1764250508 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1764250508;
        // ---------- Original Method ----------
        //return mappingsCount;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.599 -0400", hash_original_method = "3209B6B28BA147378CF80090EC868BEA", hash_generated_method = "47DCD94E2E0AC3447ACC37842334B395")
    @Override
    public Collection<V> values() {
        if(valuesCollection == null)        
        {
            valuesCollection = new EnumMapValueCollection<K, V>(this);
        } //End block
Collection<V> var60B0A8A6E555943126A18D312F8E04FB_358821968 =         valuesCollection;
        var60B0A8A6E555943126A18D312F8E04FB_358821968.addTaint(taint);
        return var60B0A8A6E555943126A18D312F8E04FB_358821968;
        // ---------- Original Method ----------
        //if (valuesCollection == null) {
            //valuesCollection = new EnumMapValueCollection<K, V>(this);
        //}
        //return valuesCollection;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.600 -0400", hash_original_method = "DC4D5C48E92024F936CD723136F7EC43", hash_generated_method = "232D92AC03D454BF9E5F7DAD40AE5CC2")
    @SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        addTaint(stream.getTaint());
        stream.defaultReadObject();
        initialization(keyType);
        int elementCount = stream.readInt();
        Enum<K> enumKey;
        Object value;
for(int i = elementCount;i > 0;i--)
        {
            enumKey = (Enum<K>) stream.readObject();
            value = stream.readObject();
            putImpl((K) enumKey, (V) value);
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.600 -0400", hash_original_method = "7E98F968D6A8FBC0CE4D31A606E7DB44", hash_generated_method = "EC4BE742E19546A2AFEEFA873A1FD45F")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        addTaint(stream.getTaint());
        stream.defaultWriteObject();
        stream.writeInt(mappingsCount);
        Iterator<Map.Entry<K, V>> iterator = entrySet().iterator();
        while
(iterator.hasNext())        
        {
            Map.Entry<K, V> entry = iterator.next();
            stream.writeObject(entry.getKey());
            stream.writeObject(entry.getValue());
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.601 -0400", hash_original_method = "AB7EF2A62AD1394405351664F3033DEE", hash_generated_method = "F2EE450EC8782A7EB49638B9E8E56378")
    private boolean isValidKeyType(Object key) {
        addTaint(key.getTaint());
        if(key != null && keyType.isInstance(key))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1448875561 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1607080101 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1607080101;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_2027173322 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_104421043 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_104421043;
        // ---------- Original Method ----------
        //if (key != null && keyType.isInstance(key)) {
            //return true;
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.603 -0400", hash_original_method = "E2B9C0EDB3E88C666CBFA70F3A732433", hash_generated_method = "D730116B98D134A16FDA01B3A791E739")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.604 -0400", hash_original_method = "74B7FF14F292272934F29B542A6B3535", hash_generated_method = "9FC8FBB551CD14785E1041E3AB443C0B")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.605 -0400", hash_original_method = "394364EB9AA119D86D9EB30D7D288B77", hash_generated_method = "628FCDAE26CD1B1682776714272B0E9B")
    @SuppressWarnings("unchecked")
    private void putAllImpl(Map map) {
        addTaint(map.getTaint());
        Iterator iter = map.entrySet().iterator();
        while
(iter.hasNext())        
        {
            Map.Entry entry = (Map.Entry) iter.next();
            putImpl((K) entry.getKey(), (V) entry.getValue());
        } //End block
        // ---------- Original Method ----------
        //Iterator iter = map.entrySet().iterator();
        //while (iter.hasNext()) {
            //Map.Entry entry = (Map.Entry) iter.next();
            //putImpl((K) entry.getKey(), (V) entry.getValue());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.606 -0400", hash_original_method = "1C83BB92B4CC56A2EE4CEBB2A5F2E79E", hash_generated_method = "B309462D2B25E23BA52DF5AC1FFE28BB")
    @SuppressWarnings("unchecked")
    private V putImpl(K key, V value) {
        addTaint(key.getTaint());
        if(key == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_208899063 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_208899063.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_208899063;
        } //End block
        keyType.cast(key);
        int keyOrdinal = key.ordinal();
        if(!hasMapping[keyOrdinal])        
        {
            hasMapping[keyOrdinal] = true;
            mappingsCount++;
        } //End block
        V oldValue = (V) values[keyOrdinal];
        values[keyOrdinal] = value;
V var8CDBD2181CBEF5C2129AFFA68C014D4A_153286268 =         oldValue;
        var8CDBD2181CBEF5C2129AFFA68C014D4A_153286268.addTaint(taint);
        return var8CDBD2181CBEF5C2129AFFA68C014D4A_153286268;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.607 -0400", hash_original_field = "0C2D76D104B4FBD56D5878F0C7B4948D", hash_generated_field = "2D3692AFCA37C24E228F49DBDE7EDE40")

        private EnumMap<KT, VT> enumMap;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.607 -0400", hash_original_field = "281858037F7DCF7ED49271BB92C60526", hash_generated_field = "1620EEB839396CD546E81EA24F66C13A")

        private int ordinal;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.608 -0400", hash_original_method = "04522B4DB01C65E7C5169DAAB9B0A8B0", hash_generated_method = "9DA00E81301FA773B81C897C5DE73FC8")
          Entry(KT theKey, VT theValue, EnumMap<KT, VT> em) {
            super(theKey, theValue);
            addTaint(theValue.getTaint());
            enumMap = em;
            ordinal = ((Enum) theKey).ordinal();
            // ---------- Original Method ----------
            //enumMap = em;
            //ordinal = ((Enum) theKey).ordinal();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.609 -0400", hash_original_method = "8DD0429C812BC3CB5F9E4D12A50ED42A", hash_generated_method = "E9F23B358A4F0FA759BD3DFDE3DC5ACD")
        @SuppressWarnings("unchecked")
        @Override
        public boolean equals(Object object) {
            addTaint(object.getTaint());
            if(!enumMap.hasMapping[ordinal])            
            {
                boolean var68934A3E9455FA72420237EB05902327_418875815 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1849378733 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1849378733;
            } //End block
            boolean isEqual = false;
            if(object instanceof Map.Entry)            
            {
                Map.Entry<KT, VT> entry = (Map.Entry<KT, VT>) object;
                Object enumKey = entry.getKey();
                if(key.equals(enumKey))                
                {
                    Object theValue = entry.getValue();
                    if(enumMap.values[ordinal] == null)                    
                    {
                        isEqual = (theValue == null);
                    } //End block
                    else
                    {
                        isEqual = enumMap.values[ordinal].equals(theValue);
                    } //End block
                } //End block
            } //End block
            boolean var39E60812C32297C6953BED0D58CF27B6_704803286 = (isEqual);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1524483701 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1524483701;
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.610 -0400", hash_original_method = "1D3BE2C1E2DBC9C20DAD39B42D607656", hash_generated_method = "BAE6F9A7AE22FB839D375AFE749B1CE2")
        @Override
        public int hashCode() {
            int varBAFC54215A37A028960D05F4776852F1_527198728 = ((enumMap.keys[ordinal] == null ? 0 : enumMap.keys[ordinal]
                    .hashCode())
                    ^ (enumMap.values[ordinal] == null ? 0
                            : enumMap.values[ordinal].hashCode()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_579460123 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_579460123;
            // ---------- Original Method ----------
            //return (enumMap.keys[ordinal] == null ? 0 : enumMap.keys[ordinal]
                    //.hashCode())
                    //^ (enumMap.values[ordinal] == null ? 0
                            //: enumMap.values[ordinal].hashCode());
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.611 -0400", hash_original_method = "E6F3009D3E7934C3E89ABA04C91C1657", hash_generated_method = "B24AC9B14E3219E4B9DFF1B4F7FC45B9")
        @SuppressWarnings("unchecked")
        @Override
        public KT getKey() {
            checkEntryStatus();
KT varFBE74173B54C2544358AA545CBC3746C_840902970 =             (KT) enumMap.keys[ordinal];
            varFBE74173B54C2544358AA545CBC3746C_840902970.addTaint(taint);
            return varFBE74173B54C2544358AA545CBC3746C_840902970;
            // ---------- Original Method ----------
            //checkEntryStatus();
            //return (KT) enumMap.keys[ordinal];
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.612 -0400", hash_original_method = "F5CFE00A2E55AC6B5D81DB2B62FB299C", hash_generated_method = "ADC2D58CCD92219B5B70716284FE0BFB")
        @SuppressWarnings("unchecked")
        @Override
        public VT getValue() {
            checkEntryStatus();
VT varC64AFFD8CD7AF4B7B051702B1CD603C7_1224023512 =             (VT) enumMap.values[ordinal];
            varC64AFFD8CD7AF4B7B051702B1CD603C7_1224023512.addTaint(taint);
            return varC64AFFD8CD7AF4B7B051702B1CD603C7_1224023512;
            // ---------- Original Method ----------
            //checkEntryStatus();
            //return (VT) enumMap.values[ordinal];
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.613 -0400", hash_original_method = "2B70B6F95ECF307373567A039C54EE32", hash_generated_method = "7D79245275C274180D8DBE96DBACD3D3")
        @SuppressWarnings("unchecked")
        @Override
        public VT setValue(VT value) {
            addTaint(value.getTaint());
            checkEntryStatus();
VT varCB3E544D5FFA29237FC4A5D9C05B5921_1509771988 =             enumMap.put((KT) enumMap.keys[ordinal], value);
            varCB3E544D5FFA29237FC4A5D9C05B5921_1509771988.addTaint(taint);
            return varCB3E544D5FFA29237FC4A5D9C05B5921_1509771988;
            // ---------- Original Method ----------
            //checkEntryStatus();
            //return enumMap.put((KT) enumMap.keys[ordinal], value);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.614 -0400", hash_original_method = "7B70A2A5E5AF6D0A4A4180BECB8A721B", hash_generated_method = "49E10AE1C0707A19DC02859D37EBF606")
        @Override
        public String toString() {
            StringBuilder result = new StringBuilder(enumMap.keys[ordinal]
                    .toString());
            result.append("=");
            result.append(enumMap.values[ordinal] == null
                    ? "null" : enumMap.values[ordinal].toString());
String varE65B3A02759122992CB82C0E651AD408_184613515 =             result.toString();
            varE65B3A02759122992CB82C0E651AD408_184613515.addTaint(taint);
            return varE65B3A02759122992CB82C0E651AD408_184613515;
            // ---------- Original Method ----------
            //StringBuilder result = new StringBuilder(enumMap.keys[ordinal]
                    //.toString());
            //result.append("=");
            //result.append(enumMap.values[ordinal] == null
                    //? "null" : enumMap.values[ordinal].toString());
            //return result.toString();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.615 -0400", hash_original_method = "D6BC45043628808E78169E86857FDCA6", hash_generated_method = "AC1A8C3D838C2FCAACFBDBD39E6D6E2F")
        private void checkEntryStatus() {
            if(!enumMap.hasMapping[ordinal])            
            {
                IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1528777579 = new IllegalStateException();
                varC311A989A119B96A6232C22ABFE87C25_1528777579.addTaint(taint);
                throw varC311A989A119B96A6232C22ABFE87C25_1528777579;
            } //End block
            // ---------- Original Method ----------
            //if (!enumMap.hasMapping[ordinal]) {
                //throw new IllegalStateException();
            //}
        }

        
    }


    
    private static class EnumMapIterator<E, KT extends Enum<KT>, VT> implements Iterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.615 -0400", hash_original_field = "64F8FBF9ECD410CCCCA37B900774D128", hash_generated_field = "B0CD1B3F8E4067A68C294939F6EB1E36")

        int position = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.615 -0400", hash_original_field = "77548F33E0633F26B4CA86617FB59DA9", hash_generated_field = "3A5C61B7C027E04C48479D5037A2A070")

        int prePosition = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.615 -0400", hash_original_field = "0C2D76D104B4FBD56D5878F0C7B4948D", hash_generated_field = "7727A7369BF41381EE0BE2DFDA995DE4")

        EnumMap<KT, VT> enumMap;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.616 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "32CBE0E3CB6327A7B40B9B82E058EE9D")

        MapEntry.Type<E, KT, VT> type;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.616 -0400", hash_original_method = "9ED4E2039768E2794B08864F6EFD4280", hash_generated_method = "833B8AD483E734D37A90F49EA36161A4")
          EnumMapIterator(MapEntry.Type<E, KT, VT> value, EnumMap<KT, VT> em) {
            enumMap = em;
            type = value;
            // ---------- Original Method ----------
            //enumMap = em;
            //type = value;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.617 -0400", hash_original_method = "6D6AB5C8509128D2C00828238AD4C0D9", hash_generated_method = "BEE1DDC52CC8B8716E6235AE340B4099")
        public boolean hasNext() {
            int length = enumMap.enumSize;
for(;position < length;position++)
            {
                if(enumMap.hasMapping[position])                
                {
                    break;
                } //End block
            } //End block
            boolean var9AC5A81BACC519945D59326F34D06F81_423839409 = (position != length);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_938959233 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_938959233;
            // ---------- Original Method ----------
            //int length = enumMap.enumSize;
            //for (; position < length; position++) {
                //if (enumMap.hasMapping[position]) {
                    //break;
                //}
            //}
            //return position != length;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.618 -0400", hash_original_method = "8136BC21B836EBF6A2416BD2D7F3270E", hash_generated_method = "C396270083154106ED13E4371E0BF8A9")
        @SuppressWarnings("unchecked")
        public E next() {
            if(!hasNext())            
            {
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_2091759541 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_2091759541.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_2091759541;
            } //End block
            prePosition = position++;
E varDA0DC4B052C93886CC4EAB16A9092606_434122920 =             type.get(new MapEntry(enumMap.keys[prePosition],
                    enumMap.values[prePosition]));
            varDA0DC4B052C93886CC4EAB16A9092606_434122920.addTaint(taint);
            return varDA0DC4B052C93886CC4EAB16A9092606_434122920;
            // ---------- Original Method ----------
            //if (!hasNext()) {
                //throw new NoSuchElementException();
            //}
            //prePosition = position++;
            //return type.get(new MapEntry(enumMap.keys[prePosition],
                    //enumMap.values[prePosition]));
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.618 -0400", hash_original_method = "A29557D70FF021A737315678DDBC3059", hash_generated_method = "15C8B24C87835A17E165D3860EA6D95F")
        public void remove() {
            checkStatus();
            if(enumMap.hasMapping[prePosition])            
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.619 -0400", hash_original_method = "D4FD3F1C9995E81E934F03FC5256A25C", hash_generated_method = "88C6BB50D31E013F4B62CFE95E2B4B94")
        @Override
        @SuppressWarnings("unchecked")
        public String toString() {
            if(-1 == prePosition)            
            {
String varD8287C6801A4C167675BF9EBA9EC2C1B_704953140 =                 super.toString();
                varD8287C6801A4C167675BF9EBA9EC2C1B_704953140.addTaint(taint);
                return varD8287C6801A4C167675BF9EBA9EC2C1B_704953140;
            } //End block
String var5CDD27A171D0E5C79918D5587971E74E_1999057489 =             type.get(
                    new MapEntry(enumMap.keys[prePosition],
                            enumMap.values[prePosition])).toString();
            var5CDD27A171D0E5C79918D5587971E74E_1999057489.addTaint(taint);
            return var5CDD27A171D0E5C79918D5587971E74E_1999057489;
            // ---------- Original Method ----------
            //if (-1 == prePosition) {
                //return super.toString();
            //}
            //return type.get(
                    //new MapEntry(enumMap.keys[prePosition],
                            //enumMap.values[prePosition])).toString();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.620 -0400", hash_original_method = "8DC9DAAEB887A2B3089BD6592C09E5DA", hash_generated_method = "87F138B17A91C9990B1B7B120E52F08B")
        private void checkStatus() {
            if(-1 == prePosition)            
            {
                IllegalStateException varC311A989A119B96A6232C22ABFE87C25_956670486 = new IllegalStateException();
                varC311A989A119B96A6232C22ABFE87C25_956670486.addTaint(taint);
                throw varC311A989A119B96A6232C22ABFE87C25_956670486;
            } //End block
            // ---------- Original Method ----------
            //if (-1 == prePosition) {
                //throw new IllegalStateException();
            //}
        }

        
    }


    
    private static class EnumMapKeySet<KT extends Enum<KT>, VT> extends AbstractSet<KT> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.621 -0400", hash_original_field = "0C2D76D104B4FBD56D5878F0C7B4948D", hash_generated_field = "2D3692AFCA37C24E228F49DBDE7EDE40")

        private EnumMap<KT, VT> enumMap;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.621 -0400", hash_original_method = "2A1696B691A1F64388AB3AC9907332E4", hash_generated_method = "F2ECC98C583C95B1C2F72BFAEFD592CC")
          EnumMapKeySet(EnumMap<KT, VT> em) {
            enumMap = em;
            // ---------- Original Method ----------
            //enumMap = em;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.622 -0400", hash_original_method = "C3DE5D46C4F9CFEF3C6B4695838239E5", hash_generated_method = "063732887140DDE2D3345C92C7674BBE")
        @Override
        public void clear() {
            enumMap.clear();
            // ---------- Original Method ----------
            //enumMap.clear();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.622 -0400", hash_original_method = "434CC1CFD8E42092C734D9BD095515B9", hash_generated_method = "769D7EA53ADF73A605CE548E0D42951D")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            boolean var9C433BA8DB82AA2DC9650721B236AEF4_93702655 = (enumMap.containsKey(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_757146961 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_757146961;
            // ---------- Original Method ----------
            //return enumMap.containsKey(object);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.623 -0400", hash_original_method = "A4EABEDB06E5BDF24065F571F359AF57", hash_generated_method = "0EA830D80ED934DF409C1796255F7483")
        @Override
        @SuppressWarnings("unchecked")
        public Iterator iterator() {
Iterator var3DC885AAF5C13DB42B2D8CE8802A24A5_914319383 =             new EnumMapIterator<KT, KT, VT>(
                    new MapEntry.Type<KT, KT, VT>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.623 -0400", hash_original_method = "58D5C15AA7C95D597054A9860FD7B3EB", hash_generated_method = "D3F6C51187C8C6249EAB6238AA515E70")
            public KT get(MapEntry<KT, VT> entry) {
                addTaint(entry.getTaint());
KT varB5B6628E54DDBF3AFBF30F96A74440CA_307129287 =                 entry.key;
                varB5B6628E54DDBF3AFBF30F96A74440CA_307129287.addTaint(taint);
                return varB5B6628E54DDBF3AFBF30F96A74440CA_307129287;
                // ---------- Original Method ----------
                //return entry.key;
            }
}, enumMap);
            var3DC885AAF5C13DB42B2D8CE8802A24A5_914319383.addTaint(taint);
            return var3DC885AAF5C13DB42B2D8CE8802A24A5_914319383;
            // ---------- Original Method ----------
            //return new EnumMapIterator<KT, KT, VT>(
                    //new MapEntry.Type<KT, KT, VT>() {
                        //public KT get(MapEntry<KT, VT> entry) {
                            //return entry.key;
                        //}
                    //}, enumMap);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.623 -0400", hash_original_method = "B8F9F39AE912D64223C40421DFD1515A", hash_generated_method = "BAA8180CF5C2F76FB2BEC8E5E6595DFD")
        @Override
        @SuppressWarnings("unchecked")
        public boolean remove(Object object) {
            addTaint(object.getTaint());
            if(contains(object))            
            {
                enumMap.remove(object);
                boolean varB326B5062B2F0E69046810717534CB09_590784591 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1016814766 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1016814766;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_129942768 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1485479240 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1485479240;
            // ---------- Original Method ----------
            //if (contains(object)) {
                //enumMap.remove(object);
                //return true;
            //}
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.624 -0400", hash_original_method = "C9EE7DD74ED1B4234C539DA28C6D21A7", hash_generated_method = "4946626B573DEB6EE93DE158EC323200")
        @Override
        public int size() {
            int var0937C4E59AE70A23FC6F4E24085E6345_1711562304 = (enumMap.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_507838718 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_507838718;
            // ---------- Original Method ----------
            //return enumMap.size();
        }

        
        // orphaned legacy method
        public KT get(MapEntry<KT, VT> entry) {
                            return entry.key;
                        }
        
    }


    
    private static class EnumMapValueCollection<KT extends Enum<KT>, VT> extends AbstractCollection<VT> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.625 -0400", hash_original_field = "0C2D76D104B4FBD56D5878F0C7B4948D", hash_generated_field = "2D3692AFCA37C24E228F49DBDE7EDE40")

        private EnumMap<KT, VT> enumMap;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.625 -0400", hash_original_method = "1A0661F4095C8F41E606FE019F34B01E", hash_generated_method = "E5ABA9176789D0F83D15C4076A2F1270")
          EnumMapValueCollection(EnumMap<KT, VT> em) {
            enumMap = em;
            // ---------- Original Method ----------
            //enumMap = em;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.625 -0400", hash_original_method = "C3DE5D46C4F9CFEF3C6B4695838239E5", hash_generated_method = "063732887140DDE2D3345C92C7674BBE")
        @Override
        public void clear() {
            enumMap.clear();
            // ---------- Original Method ----------
            //enumMap.clear();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.626 -0400", hash_original_method = "F0FBCB059002559902B972108CF0BABE", hash_generated_method = "E1A975D2D38DBCC11CEB81A5216E6B56")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            boolean var4814599FF046122293A219E70CF983CB_993281994 = (enumMap.containsValue(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1476592314 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1476592314;
            // ---------- Original Method ----------
            //return enumMap.containsValue(object);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.627 -0400", hash_original_method = "BC6C06395E1460CC49F247C03E1763F0", hash_generated_method = "C39B93940722F221BDAB91C09CDA1FFA")
        @SuppressWarnings("unchecked")
        @Override
        public Iterator iterator() {
Iterator var036D6891E4F32E3A02A8377B9160AF5E_384011634 =             new EnumMapIterator<VT, KT, VT>(
                    new MapEntry.Type<VT, KT, VT>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.627 -0400", hash_original_method = "C542D68881AE52AD0D43DA03AB0FAD85", hash_generated_method = "16ACD91D4BACFD35D0A06831F3B96C08")
            public VT get(MapEntry<KT, VT> entry) {
                addTaint(entry.getTaint());
VT varD2C0624DDD8A4F8F307477F36B405DFB_1326606983 =                 entry.value;
                varD2C0624DDD8A4F8F307477F36B405DFB_1326606983.addTaint(taint);
                return varD2C0624DDD8A4F8F307477F36B405DFB_1326606983;
                // ---------- Original Method ----------
                //return entry.value;
            }
}, enumMap);
            var036D6891E4F32E3A02A8377B9160AF5E_384011634.addTaint(taint);
            return var036D6891E4F32E3A02A8377B9160AF5E_384011634;
            // ---------- Original Method ----------
            //return new EnumMapIterator<VT, KT, VT>(
                    //new MapEntry.Type<VT, KT, VT>() {
                        //public VT get(MapEntry<KT, VT> entry) {
                            //return entry.value;
                        //}
                    //}, enumMap);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.628 -0400", hash_original_method = "47E37FB3671E07CE32BC2BA28A816FCA", hash_generated_method = "82595ACDB8D3D2FC06A78FB5BC2C5870")
        @Override
        public boolean remove(Object object) {
            addTaint(object.getTaint());
            if(object == null)            
            {
for(int i = 0;i < enumMap.enumSize;i++)
                {
                    if(enumMap.hasMapping[i] && enumMap.values[i] == null)                    
                    {
                        enumMap.remove(enumMap.keys[i]);
                        boolean varB326B5062B2F0E69046810717534CB09_1881940059 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2033841344 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2033841344;
                    } //End block
                } //End block
            } //End block
            else
            {
for(int i = 0;i < enumMap.enumSize;i++)
                {
                    if(enumMap.hasMapping[i]
                            && object.equals(enumMap.values[i]))                    
                    {
                        enumMap.remove(enumMap.keys[i]);
                        boolean varB326B5062B2F0E69046810717534CB09_821357832 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_988568440 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_988568440;
                    } //End block
                } //End block
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1637950126 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1354499747 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1354499747;
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.637 -0400", hash_original_method = "C9EE7DD74ED1B4234C539DA28C6D21A7", hash_generated_method = "2B40A6B06F7D796830DB11CDEB4F5A06")
        @Override
        public int size() {
            int var0937C4E59AE70A23FC6F4E24085E6345_1357576441 = (enumMap.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_533218606 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_533218606;
            // ---------- Original Method ----------
            //return enumMap.size();
        }

        
        // orphaned legacy method
        public VT get(MapEntry<KT, VT> entry) {
                            return entry.value;
                        }
        
    }


    
    private static class EnumMapEntryIterator<E, KT extends Enum<KT>, VT> extends EnumMapIterator<E, KT, VT> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.638 -0400", hash_original_method = "4B20A4930FDD81120A40D2421C6DB306", hash_generated_method = "4FBF75CCFB9FEF701AD2A23786B7B68E")
          EnumMapEntryIterator(MapEntry.Type<E, KT, VT> value, EnumMap<KT, VT> em) {
            super(value, em);
            addTaint(em.getTaint());
            addTaint(value.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.638 -0400", hash_original_method = "AA0A985577200C3410BBA8066828BEEB", hash_generated_method = "39B9D172CA37B2BCC0566AA5287766D9")
        @SuppressWarnings("unchecked")
        @Override
        public E next() {
            if(!hasNext())            
            {
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_1833876854 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_1833876854.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_1833876854;
            } //End block
            prePosition = position++;
E var9AC0307A5A079FF49EDDEA7AAD7008A5_471513423 =             type.get(new Entry<KT, VT>((KT) enumMap.keys[prePosition],
                    (VT) enumMap.values[prePosition], enumMap));
            var9AC0307A5A079FF49EDDEA7AAD7008A5_471513423.addTaint(taint);
            return var9AC0307A5A079FF49EDDEA7AAD7008A5_471513423;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.638 -0400", hash_original_field = "0C2D76D104B4FBD56D5878F0C7B4948D", hash_generated_field = "2D3692AFCA37C24E228F49DBDE7EDE40")

        private EnumMap<KT, VT> enumMap;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.638 -0400", hash_original_method = "616E4B9747EFF9433BD58C5F15DEC121", hash_generated_method = "D78FC31B5B25F7A257282F3524D220D6")
          EnumMapEntrySet(EnumMap<KT, VT> em) {
            enumMap = em;
            // ---------- Original Method ----------
            //enumMap = em;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.638 -0400", hash_original_method = "C3DE5D46C4F9CFEF3C6B4695838239E5", hash_generated_method = "063732887140DDE2D3345C92C7674BBE")
        @Override
        public void clear() {
            enumMap.clear();
            // ---------- Original Method ----------
            //enumMap.clear();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.638 -0400", hash_original_method = "4AC40C6458CB1EE4BF18663D9AB10FCB", hash_generated_method = "4FB3CBCCC26E41ED3EE1BFFB170EB4FD")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            boolean isEqual = false;
            if(object instanceof Map.Entry)            
            {
                Object enumKey = ((Map.Entry) object).getKey();
                Object enumValue = ((Map.Entry) object).getValue();
                if(enumMap.containsKey(enumKey))                
                {
                    VT value = enumMap.get(enumKey);
                    if(value == null)                    
                    {
                        isEqual = enumValue == null;
                    } //End block
                    else
                    {
                        isEqual = value.equals(enumValue);
                    } //End block
                } //End block
            } //End block
            boolean var39E60812C32297C6953BED0D58CF27B6_185367574 = (isEqual);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_578989064 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_578989064;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.639 -0400", hash_original_method = "95EB2B60E0E6891B83EBE6118D53811C", hash_generated_method = "A7761D3ED15577747C76DFEBA1BFD839")
        @Override
        public Iterator<Map.Entry<KT, VT>> iterator() {
Iterator<Map.Entry<KT, VT>> varFE22973482D44A4465B49DBA0D13776B_1643986750 =             new EnumMapEntryIterator<Map.Entry<KT, VT>, KT, VT>(
                    new MapEntry.Type<Map.Entry<KT, VT>, KT, VT>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.639 -0400", hash_original_method = "E6C5689ECDF5DCF09D122C660DDB94F0", hash_generated_method = "3561F848BD9F6372D59C8CBD9F75D8B2")
            public Map.Entry<KT, VT> get(MapEntry<KT, VT> entry) {
                addTaint(entry.getTaint());
Map.Entry<KT, VT> varF26DBE38545460D6F6AE1D948FF53869_1192507839 =                 entry;
                varF26DBE38545460D6F6AE1D948FF53869_1192507839.addTaint(taint);
                return varF26DBE38545460D6F6AE1D948FF53869_1192507839;
                // ---------- Original Method ----------
                //return entry;
            }
}, enumMap);
            varFE22973482D44A4465B49DBA0D13776B_1643986750.addTaint(taint);
            return varFE22973482D44A4465B49DBA0D13776B_1643986750;
            // ---------- Original Method ----------
            //return new EnumMapEntryIterator<Map.Entry<KT, VT>, KT, VT>(
                    //new MapEntry.Type<Map.Entry<KT, VT>, KT, VT>() {
                        //public Map.Entry<KT, VT> get(MapEntry<KT, VT> entry) {
                            //return entry;
                        //}
                    //}, enumMap);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.639 -0400", hash_original_method = "B1FBE3FDE380AB91D92300437712D6CE", hash_generated_method = "BBAB7206750AC4BBA78F547309B27D0F")
        @Override
        public boolean remove(Object object) {
            addTaint(object.getTaint());
            if(contains(object))            
            {
                enumMap.remove(((Map.Entry) object).getKey());
                boolean varB326B5062B2F0E69046810717534CB09_1693870137 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2075945006 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2075945006;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_489855809 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_16711874 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_16711874;
            // ---------- Original Method ----------
            //if (contains(object)) {
                //enumMap.remove(((Map.Entry) object).getKey());
                //return true;
            //}
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.639 -0400", hash_original_method = "C9EE7DD74ED1B4234C539DA28C6D21A7", hash_generated_method = "5E2D4278275412569FFE0C55C2EF231E")
        @Override
        public int size() {
            int var0937C4E59AE70A23FC6F4E24085E6345_215054263 = (enumMap.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_833650344 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_833650344;
            // ---------- Original Method ----------
            //return enumMap.size();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.639 -0400", hash_original_method = "36EAFDE13B72544D308E66F5613D1161", hash_generated_method = "806B416E42FA1C45456F66A90D1B0C1C")
        @Override
        public Object[] toArray() {
            Object[] entryArray = new Object[enumMap.size()];
Object[] var8030B76E3C574EFC5D11EBF77AB90BE3_1744026384 =             toArray(entryArray);
            var8030B76E3C574EFC5D11EBF77AB90BE3_1744026384.addTaint(taint);
            return var8030B76E3C574EFC5D11EBF77AB90BE3_1744026384;
            // ---------- Original Method ----------
            //Object[] entryArray = new Object[enumMap.size()];
            //return toArray(entryArray);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.640 -0400", hash_original_method = "9EABF255823509EF0FD5FF1AC40C33FF", hash_generated_method = "94D158C964E1D57DE552FDC3177CB361")
        @SuppressWarnings("unchecked")
        @Override
        public Object[] toArray(Object[] array) {
            addTaint(array[0].getTaint());
            int size = enumMap.size();
            int index = 0;
            Object[] entryArray = array;
            if(size > array.length)            
            {
                Class<?> clazz = array.getClass().getComponentType();
                entryArray = (Object[]) Array.newInstance(clazz, size);
            } //End block
            Iterator<Map.Entry<KT, VT>> iter = iterator();
for(;index < size;index++)
            {
                Map.Entry<KT, VT> entry = iter.next();
                entryArray[index] = new MapEntry<KT, VT>(entry.getKey(), entry
                        .getValue());
            } //End block
            if(index < array.length)            
            {
                entryArray[index] = null;
            } //End block
Object[] var2DBA465DA7F2FCDFB98C27D0A75614F5_2099802399 =             entryArray;
            var2DBA465DA7F2FCDFB98C27D0A75614F5_2099802399.addTaint(taint);
            return var2DBA465DA7F2FCDFB98C27D0A75614F5_2099802399;
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

        
        // orphaned legacy method
        public Map.Entry<KT, VT> get(MapEntry<KT, VT> entry) {
                            return entry;
                        }
        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.640 -0400", hash_original_field = "ACF5FEE0E990C707AF7445EBA9610512", hash_generated_field = "E1BAC054FBC7EDF33360B5E852ACA6E1")

    private static final long serialVersionUID = 458661240069192865L;
}

