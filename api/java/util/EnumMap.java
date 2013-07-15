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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.350 -0400", hash_original_field = "056E0360B75D77ECE0AE955FE59BF15D", hash_generated_field = "784B4CB2B0AA1435846B96ECF749418D")

    private Class<K> keyType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.350 -0400", hash_original_field = "14F802E1FBA977727845E8872C1743A7", hash_generated_field = "1296F5D01B4090600677F6D5CA1FE096")

    transient Enum[] keys;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.350 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "4150C40DB1D8CEF16DAAF4E72141B18D")

    transient Object[] values;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.350 -0400", hash_original_field = "EB33C464BB85B740774E660ED19A4D23", hash_generated_field = "2AFD2ACFCCD988AD1A9DB860BFAFC15E")

    transient boolean[] hasMapping;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.350 -0400", hash_original_field = "80ADFCE58E22D304D276F1C6D95D4EF2", hash_generated_field = "204CA002E2DD9253A57F08EEC28189B5")

    private transient int mappingsCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.350 -0400", hash_original_field = "2FF4AF744F4AEE0F57EA018EF3FA7088", hash_generated_field = "2AA1CC9DCAEA03EA6B04E81906ED8EEA")

    transient int enumSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.350 -0400", hash_original_field = "22D97DDA025E6292D4C7D4F7678A4EEA", hash_generated_field = "60757B7103C3702D9A64F686BFD44FCF")

    private transient EnumMapEntrySet<K, V> entrySet = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.351 -0400", hash_original_method = "357B463561F8F38F36CCB594B2B44169", hash_generated_method = "D728EB7714A45C35A27862A2389C889E")
    public  EnumMap(Class<K> keyType) {
        addTaint(keyType.getTaint());
        initialization(keyType);
        // ---------- Original Method ----------
        //initialization(keyType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.351 -0400", hash_original_method = "4FB74096ACFD3857AE5FA5EC3BFDBAC1", hash_generated_method = "DE0DEE09D8F2B560E6E7F0765E6E4F06")
    public  EnumMap(EnumMap<K, ? extends V> map) {
        addTaint(map.getTaint());
        initialization(map);
        // ---------- Original Method ----------
        //initialization(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.351 -0400", hash_original_method = "D652AC252782A7206F7D0F46E9A22736", hash_generated_method = "D99C6BF2AB101669D5A070EB567C8D80")
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
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1051092089 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_1051092089.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_1051092089;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.352 -0400", hash_original_method = "2976CFC6D7176D4F9EDBE7E00A9203F9", hash_generated_method = "B80AABDFA9194B1768A3A2F9D08F6AA8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.352 -0400", hash_original_method = "27D6CD5C74C8D110D14D6D471707F1DE", hash_generated_method = "90B16289BC91AE89DB4651CA40B3E867")
    @SuppressWarnings("unchecked")
    @Override
    public EnumMap<K, V> clone() {
        try 
        {
            EnumMap<K, V> enumMap = (EnumMap<K, V>) super.clone();
            enumMap.initialization(this);
EnumMap<K, V> var93535FC7597EF533BF9378E6783BB0AC_835391855 =             enumMap;
            var93535FC7597EF533BF9378E6783BB0AC_835391855.addTaint(taint);
            return var93535FC7597EF533BF9378E6783BB0AC_835391855;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_325703323 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_325703323.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_325703323;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.353 -0400", hash_original_method = "0E01365989D6BCC217AC6A8119B6F173", hash_generated_method = "5754AC8C5374AF98E2FFE997C23BFAB5")
    @Override
    public boolean containsKey(Object key) {
        addTaint(key.getTaint());
    if(isValidKeyType(key))        
        {
            int keyOrdinal = ((Enum) key).ordinal();
            boolean var374E637230383A96BDB1617063C947D4_1952479753 = (hasMapping[keyOrdinal]);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_933947471 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_933947471;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1670652782 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_986175444 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_986175444;
        // ---------- Original Method ----------
        //if (isValidKeyType(key)) {
            //int keyOrdinal = ((Enum) key).ordinal();
            //return hasMapping[keyOrdinal];
        //}
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.353 -0400", hash_original_method = "FD4C7D9777FB1B3FC7F27A22C70B4A60", hash_generated_method = "1077991F65A157C5726B92CDAF2C804A")
    @Override
    public boolean containsValue(Object value) {
        addTaint(value.getTaint());
    if(value == null)        
        {
for(int i = 0;i < enumSize;i++)
            {
    if(hasMapping[i] && values[i] == null)                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_1568974699 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2037712241 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_2037712241;
                } //End block
            } //End block
        } //End block
        else
        {
for(int i = 0;i < enumSize;i++)
            {
    if(hasMapping[i] && value.equals(values[i]))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_452391301 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1424536349 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1424536349;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_532440693 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_536667837 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_536667837;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.354 -0400", hash_original_method = "1D25B0764045DBFAD19E9C060947BE81", hash_generated_method = "C38CB832C5171D7F969E4C3F47998CEC")
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
    if(entrySet == null)        
        {
            entrySet = new EnumMapEntrySet<K, V>(this);
        } //End block
Set<Map.Entry<K, V>> var844F1DC6137EC02DBA16CAD3ADE04B13_774371746 =         entrySet;
        var844F1DC6137EC02DBA16CAD3ADE04B13_774371746.addTaint(taint);
        return var844F1DC6137EC02DBA16CAD3ADE04B13_774371746;
        // ---------- Original Method ----------
        //if (entrySet == null) {
            //entrySet = new EnumMapEntrySet<K, V>(this);
        //}
        //return entrySet;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.355 -0400", hash_original_method = "AC8EB1BDF42FFE99FA259DC7FD35D677", hash_generated_method = "BB0A577B88A4978BFF6F0F957166B651")
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
    if(this == object)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1358923795 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_887833948 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_887833948;
        } //End block
    if(!(object instanceof EnumMap))        
        {
            boolean var75EAEC12DA10D524D5BB1C4333283B8A_848699312 = (super.equals(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2094269491 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2094269491;
        } //End block
        EnumMap<K, V> enumMap = (EnumMap<K, V>) object;
    if(keyType != enumMap.keyType || size() != enumMap.size())        
        {
            boolean var68934A3E9455FA72420237EB05902327_793995301 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_474789724 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_474789724;
        } //End block
        boolean var9F6C49E239B2F806D5BF401076D8C7F5_1159947666 = (Arrays.equals(hasMapping, enumMap.hasMapping)
                && Arrays.equals(values, enumMap.values));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_304225259 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_304225259;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.355 -0400", hash_original_method = "D1D1E4650582CB36D48A88314ACBD849", hash_generated_method = "761F16A0784F0113F0504075C8384786")
    @Override
    @SuppressWarnings("unchecked")
    public V get(Object key) {
        addTaint(key.getTaint());
    if(!isValidKeyType(key))        
        {
V var540C13E9E156B687226421B24F2DF178_643660391 =             null;
            var540C13E9E156B687226421B24F2DF178_643660391.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_643660391;
        } //End block
        int keyOrdinal = ((Enum) key).ordinal();
V varC4A454773D3C3B58D8F0D07F64F91612_1377959117 =         (V) values[keyOrdinal];
        varC4A454773D3C3B58D8F0D07F64F91612_1377959117.addTaint(taint);
        return varC4A454773D3C3B58D8F0D07F64F91612_1377959117;
        // ---------- Original Method ----------
        //if (!isValidKeyType(key)) {
            //return null;
        //}
        //int keyOrdinal = ((Enum) key).ordinal();
        //return (V) values[keyOrdinal];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.355 -0400", hash_original_method = "ADC2E4F8D882C3AAF1D0303EAF8C1F23", hash_generated_method = "34E744DCD888E920C31F818020293BD6")
    @Override
    public Set<K> keySet() {
    if(keySet == null)        
        {
            keySet = new EnumMapKeySet<K, V>(this);
        } //End block
Set<K> varCB23CF4AFB8B7AE1843E733C4B0CC600_774845152 =         keySet;
        varCB23CF4AFB8B7AE1843E733C4B0CC600_774845152.addTaint(taint);
        return varCB23CF4AFB8B7AE1843E733C4B0CC600_774845152;
        // ---------- Original Method ----------
        //if (keySet == null) {
            //keySet = new EnumMapKeySet<K, V>(this);
        //}
        //return keySet;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.356 -0400", hash_original_method = "0FAB728DBD67C753D3CD4965FE16DA6D", hash_generated_method = "43B73A8DEA76AEF927B250198473BA27")
    @Override
    @SuppressWarnings("unchecked")
    public V put(K key, V value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
V var9BB0B2FF0AC3AF2A11FC956ABA5FBB6B_1540078284 =         putImpl(key, value);
        var9BB0B2FF0AC3AF2A11FC956ABA5FBB6B_1540078284.addTaint(taint);
        return var9BB0B2FF0AC3AF2A11FC956ABA5FBB6B_1540078284;
        // ---------- Original Method ----------
        //return putImpl(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.356 -0400", hash_original_method = "57B3987EA7E50826E0AAD0198F968E42", hash_generated_method = "AD80324C19FD450664605D07167C9609")
    @Override
    @SuppressWarnings("unchecked")
    public void putAll(Map<? extends K, ? extends V> map) {
        addTaint(map.getTaint());
        putAllImpl(map);
        // ---------- Original Method ----------
        //putAllImpl(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.357 -0400", hash_original_method = "2531311459BDF6AE48398CDBD33066ED", hash_generated_method = "612278A1709ABEED15B193684808899B")
    @Override
    @SuppressWarnings("unchecked")
    public V remove(Object key) {
        addTaint(key.getTaint());
    if(!isValidKeyType(key))        
        {
V var540C13E9E156B687226421B24F2DF178_971912468 =             null;
            var540C13E9E156B687226421B24F2DF178_971912468.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_971912468;
        } //End block
        int keyOrdinal = ((Enum) key).ordinal();
    if(hasMapping[keyOrdinal])        
        {
            hasMapping[keyOrdinal] = false;
            mappingsCount--;
        } //End block
        V oldValue = (V) values[keyOrdinal];
        values[keyOrdinal] = null;
V var8CDBD2181CBEF5C2129AFFA68C014D4A_123290220 =         oldValue;
        var8CDBD2181CBEF5C2129AFFA68C014D4A_123290220.addTaint(taint);
        return var8CDBD2181CBEF5C2129AFFA68C014D4A_123290220;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.357 -0400", hash_original_method = "9B5434C347C8B5979021C04F4F7D3AC0", hash_generated_method = "CB90CD25447AC083505C2D62A9B68AE1")
    @Override
    public int size() {
        int var80ADFCE58E22D304D276F1C6D95D4EF2_1102137402 = (mappingsCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_16963672 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_16963672;
        // ---------- Original Method ----------
        //return mappingsCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.357 -0400", hash_original_method = "3209B6B28BA147378CF80090EC868BEA", hash_generated_method = "C760996A47D0EE6F648B42BF82CA2347")
    @Override
    public Collection<V> values() {
    if(valuesCollection == null)        
        {
            valuesCollection = new EnumMapValueCollection<K, V>(this);
        } //End block
Collection<V> var60B0A8A6E555943126A18D312F8E04FB_1768845921 =         valuesCollection;
        var60B0A8A6E555943126A18D312F8E04FB_1768845921.addTaint(taint);
        return var60B0A8A6E555943126A18D312F8E04FB_1768845921;
        // ---------- Original Method ----------
        //if (valuesCollection == null) {
            //valuesCollection = new EnumMapValueCollection<K, V>(this);
        //}
        //return valuesCollection;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.358 -0400", hash_original_method = "DC4D5C48E92024F936CD723136F7EC43", hash_generated_method = "232D92AC03D454BF9E5F7DAD40AE5CC2")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.358 -0400", hash_original_method = "7E98F968D6A8FBC0CE4D31A606E7DB44", hash_generated_method = "EC4BE742E19546A2AFEEFA873A1FD45F")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.359 -0400", hash_original_method = "AB7EF2A62AD1394405351664F3033DEE", hash_generated_method = "19E531AAD007F59470F24F4FCC410EFB")
    private boolean isValidKeyType(Object key) {
        addTaint(key.getTaint());
    if(key != null && keyType.isInstance(key))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1565685399 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1739215051 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1739215051;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1274908784 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1574119422 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1574119422;
        // ---------- Original Method ----------
        //if (key != null && keyType.isInstance(key)) {
            //return true;
        //}
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.360 -0400", hash_original_method = "E2B9C0EDB3E88C666CBFA70F3A732433", hash_generated_method = "D730116B98D134A16FDA01B3A791E739")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.360 -0400", hash_original_method = "74B7FF14F292272934F29B542A6B3535", hash_generated_method = "9FC8FBB551CD14785E1041E3AB443C0B")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.361 -0400", hash_original_method = "394364EB9AA119D86D9EB30D7D288B77", hash_generated_method = "628FCDAE26CD1B1682776714272B0E9B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.361 -0400", hash_original_method = "1C83BB92B4CC56A2EE4CEBB2A5F2E79E", hash_generated_method = "0553800167764F0B4015407872FC65F2")
    @SuppressWarnings("unchecked")
    private V putImpl(K key, V value) {
        addTaint(key.getTaint());
    if(key == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_521796557 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_521796557.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_521796557;
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
V var8CDBD2181CBEF5C2129AFFA68C014D4A_1840048586 =         oldValue;
        var8CDBD2181CBEF5C2129AFFA68C014D4A_1840048586.addTaint(taint);
        return var8CDBD2181CBEF5C2129AFFA68C014D4A_1840048586;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.362 -0400", hash_original_field = "0C2D76D104B4FBD56D5878F0C7B4948D", hash_generated_field = "2D3692AFCA37C24E228F49DBDE7EDE40")

        private EnumMap<KT, VT> enumMap;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.362 -0400", hash_original_field = "281858037F7DCF7ED49271BB92C60526", hash_generated_field = "1620EEB839396CD546E81EA24F66C13A")

        private int ordinal;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.363 -0400", hash_original_method = "04522B4DB01C65E7C5169DAAB9B0A8B0", hash_generated_method = "9DA00E81301FA773B81C897C5DE73FC8")
          Entry(KT theKey, VT theValue, EnumMap<KT, VT> em) {
            super(theKey, theValue);
            addTaint(theValue.getTaint());
            enumMap = em;
            ordinal = ((Enum) theKey).ordinal();
            // ---------- Original Method ----------
            //enumMap = em;
            //ordinal = ((Enum) theKey).ordinal();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.364 -0400", hash_original_method = "8DD0429C812BC3CB5F9E4D12A50ED42A", hash_generated_method = "74F86A4D80C9DDD8138B213DD66F2085")
        @SuppressWarnings("unchecked")
        @Override
        public boolean equals(Object object) {
            addTaint(object.getTaint());
    if(!enumMap.hasMapping[ordinal])            
            {
                boolean var68934A3E9455FA72420237EB05902327_1087261350 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1741028725 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1741028725;
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
            boolean var39E60812C32297C6953BED0D58CF27B6_834497534 = (isEqual);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1063856734 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1063856734;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.366 -0400", hash_original_method = "1D3BE2C1E2DBC9C20DAD39B42D607656", hash_generated_method = "BD7753A9AFFAAFA86D7002EE74ED94E0")
        @Override
        public int hashCode() {
            int varBAFC54215A37A028960D05F4776852F1_471407780 = ((enumMap.keys[ordinal] == null ? 0 : enumMap.keys[ordinal]
                    .hashCode())
                    ^ (enumMap.values[ordinal] == null ? 0
                            : enumMap.values[ordinal].hashCode()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_999165197 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_999165197;
            // ---------- Original Method ----------
            //return (enumMap.keys[ordinal] == null ? 0 : enumMap.keys[ordinal]
                    //.hashCode())
                    //^ (enumMap.values[ordinal] == null ? 0
                            //: enumMap.values[ordinal].hashCode());
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.367 -0400", hash_original_method = "E6F3009D3E7934C3E89ABA04C91C1657", hash_generated_method = "73BD54249A2CF3C61A74DDFFA144E970")
        @SuppressWarnings("unchecked")
        @Override
        public KT getKey() {
            checkEntryStatus();
KT varFBE74173B54C2544358AA545CBC3746C_1918974346 =             (KT) enumMap.keys[ordinal];
            varFBE74173B54C2544358AA545CBC3746C_1918974346.addTaint(taint);
            return varFBE74173B54C2544358AA545CBC3746C_1918974346;
            // ---------- Original Method ----------
            //checkEntryStatus();
            //return (KT) enumMap.keys[ordinal];
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.367 -0400", hash_original_method = "F5CFE00A2E55AC6B5D81DB2B62FB299C", hash_generated_method = "48F8CC512779FA45B257A8CD9FA8A89D")
        @SuppressWarnings("unchecked")
        @Override
        public VT getValue() {
            checkEntryStatus();
VT varC64AFFD8CD7AF4B7B051702B1CD603C7_1686261652 =             (VT) enumMap.values[ordinal];
            varC64AFFD8CD7AF4B7B051702B1CD603C7_1686261652.addTaint(taint);
            return varC64AFFD8CD7AF4B7B051702B1CD603C7_1686261652;
            // ---------- Original Method ----------
            //checkEntryStatus();
            //return (VT) enumMap.values[ordinal];
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.368 -0400", hash_original_method = "2B70B6F95ECF307373567A039C54EE32", hash_generated_method = "BDD2B98CB22FF2CF5E3D282D10D77F2F")
        @SuppressWarnings("unchecked")
        @Override
        public VT setValue(VT value) {
            addTaint(value.getTaint());
            checkEntryStatus();
VT varCB3E544D5FFA29237FC4A5D9C05B5921_1730143678 =             enumMap.put((KT) enumMap.keys[ordinal], value);
            varCB3E544D5FFA29237FC4A5D9C05B5921_1730143678.addTaint(taint);
            return varCB3E544D5FFA29237FC4A5D9C05B5921_1730143678;
            // ---------- Original Method ----------
            //checkEntryStatus();
            //return enumMap.put((KT) enumMap.keys[ordinal], value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.368 -0400", hash_original_method = "7B70A2A5E5AF6D0A4A4180BECB8A721B", hash_generated_method = "083DD0B1744222D4A674903D4C226E44")
        @Override
        public String toString() {
            StringBuilder result = new StringBuilder(enumMap.keys[ordinal]
                    .toString());
            result.append("=");
            result.append(enumMap.values[ordinal] == null
                    ? "null" : enumMap.values[ordinal].toString());
String varE65B3A02759122992CB82C0E651AD408_817279275 =             result.toString();
            varE65B3A02759122992CB82C0E651AD408_817279275.addTaint(taint);
            return varE65B3A02759122992CB82C0E651AD408_817279275;
            // ---------- Original Method ----------
            //StringBuilder result = new StringBuilder(enumMap.keys[ordinal]
                    //.toString());
            //result.append("=");
            //result.append(enumMap.values[ordinal] == null
                    //? "null" : enumMap.values[ordinal].toString());
            //return result.toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.368 -0400", hash_original_method = "D6BC45043628808E78169E86857FDCA6", hash_generated_method = "8D30FBFA50E7305B189CF45857B2E00A")
        private void checkEntryStatus() {
    if(!enumMap.hasMapping[ordinal])            
            {
                IllegalStateException varC311A989A119B96A6232C22ABFE87C25_444618763 = new IllegalStateException();
                varC311A989A119B96A6232C22ABFE87C25_444618763.addTaint(taint);
                throw varC311A989A119B96A6232C22ABFE87C25_444618763;
            } //End block
            // ---------- Original Method ----------
            //if (!enumMap.hasMapping[ordinal]) {
                //throw new IllegalStateException();
            //}
        }

        
    }


    
    private static class EnumMapIterator<E, KT extends Enum<KT>, VT> implements Iterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.369 -0400", hash_original_field = "64F8FBF9ECD410CCCCA37B900774D128", hash_generated_field = "B0CD1B3F8E4067A68C294939F6EB1E36")

        int position = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.369 -0400", hash_original_field = "77548F33E0633F26B4CA86617FB59DA9", hash_generated_field = "3A5C61B7C027E04C48479D5037A2A070")

        int prePosition = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.369 -0400", hash_original_field = "0C2D76D104B4FBD56D5878F0C7B4948D", hash_generated_field = "7727A7369BF41381EE0BE2DFDA995DE4")

        EnumMap<KT, VT> enumMap;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.369 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "32CBE0E3CB6327A7B40B9B82E058EE9D")

        MapEntry.Type<E, KT, VT> type;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.370 -0400", hash_original_method = "9ED4E2039768E2794B08864F6EFD4280", hash_generated_method = "833B8AD483E734D37A90F49EA36161A4")
          EnumMapIterator(MapEntry.Type<E, KT, VT> value, EnumMap<KT, VT> em) {
            enumMap = em;
            type = value;
            // ---------- Original Method ----------
            //enumMap = em;
            //type = value;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.370 -0400", hash_original_method = "6D6AB5C8509128D2C00828238AD4C0D9", hash_generated_method = "ED6E1D088704136A361C3AEB8DBE5AE9")
        public boolean hasNext() {
            int length = enumMap.enumSize;
for(;position < length;position++)
            {
    if(enumMap.hasMapping[position])                
                {
                    break;
                } //End block
            } //End block
            boolean var9AC5A81BACC519945D59326F34D06F81_96498649 = (position != length);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1743894817 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1743894817;
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.371 -0400", hash_original_method = "8136BC21B836EBF6A2416BD2D7F3270E", hash_generated_method = "FB88AB8A7471D2E350EB78DAF21DE9B0")
        @SuppressWarnings("unchecked")
        public E next() {
    if(!hasNext())            
            {
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_1196673750 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_1196673750.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_1196673750;
            } //End block
            prePosition = position++;
E varDA0DC4B052C93886CC4EAB16A9092606_120152809 =             type.get(new MapEntry(enumMap.keys[prePosition],
                    enumMap.values[prePosition]));
            varDA0DC4B052C93886CC4EAB16A9092606_120152809.addTaint(taint);
            return varDA0DC4B052C93886CC4EAB16A9092606_120152809;
            // ---------- Original Method ----------
            //if (!hasNext()) {
                //throw new NoSuchElementException();
            //}
            //prePosition = position++;
            //return type.get(new MapEntry(enumMap.keys[prePosition],
                    //enumMap.values[prePosition]));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.371 -0400", hash_original_method = "A29557D70FF021A737315678DDBC3059", hash_generated_method = "15C8B24C87835A17E165D3860EA6D95F")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.371 -0400", hash_original_method = "D4FD3F1C9995E81E934F03FC5256A25C", hash_generated_method = "248BD7012811D95A174C6BCAADD73BF6")
        @Override
        @SuppressWarnings("unchecked")
        public String toString() {
    if(-1 == prePosition)            
            {
String varD8287C6801A4C167675BF9EBA9EC2C1B_690264152 =                 super.toString();
                varD8287C6801A4C167675BF9EBA9EC2C1B_690264152.addTaint(taint);
                return varD8287C6801A4C167675BF9EBA9EC2C1B_690264152;
            } //End block
String var5CDD27A171D0E5C79918D5587971E74E_949333300 =             type.get(
                    new MapEntry(enumMap.keys[prePosition],
                            enumMap.values[prePosition])).toString();
            var5CDD27A171D0E5C79918D5587971E74E_949333300.addTaint(taint);
            return var5CDD27A171D0E5C79918D5587971E74E_949333300;
            // ---------- Original Method ----------
            //if (-1 == prePosition) {
                //return super.toString();
            //}
            //return type.get(
                    //new MapEntry(enumMap.keys[prePosition],
                            //enumMap.values[prePosition])).toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.372 -0400", hash_original_method = "8DC9DAAEB887A2B3089BD6592C09E5DA", hash_generated_method = "4A3245BACC9642280B28BFF971FE4A39")
        private void checkStatus() {
    if(-1 == prePosition)            
            {
                IllegalStateException varC311A989A119B96A6232C22ABFE87C25_645905133 = new IllegalStateException();
                varC311A989A119B96A6232C22ABFE87C25_645905133.addTaint(taint);
                throw varC311A989A119B96A6232C22ABFE87C25_645905133;
            } //End block
            // ---------- Original Method ----------
            //if (-1 == prePosition) {
                //throw new IllegalStateException();
            //}
        }

        
    }


    
    private static class EnumMapKeySet<KT extends Enum<KT>, VT> extends AbstractSet<KT> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.372 -0400", hash_original_field = "0C2D76D104B4FBD56D5878F0C7B4948D", hash_generated_field = "2D3692AFCA37C24E228F49DBDE7EDE40")

        private EnumMap<KT, VT> enumMap;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.372 -0400", hash_original_method = "2A1696B691A1F64388AB3AC9907332E4", hash_generated_method = "F2ECC98C583C95B1C2F72BFAEFD592CC")
          EnumMapKeySet(EnumMap<KT, VT> em) {
            enumMap = em;
            // ---------- Original Method ----------
            //enumMap = em;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.372 -0400", hash_original_method = "C3DE5D46C4F9CFEF3C6B4695838239E5", hash_generated_method = "063732887140DDE2D3345C92C7674BBE")
        @Override
        public void clear() {
            enumMap.clear();
            // ---------- Original Method ----------
            //enumMap.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.373 -0400", hash_original_method = "434CC1CFD8E42092C734D9BD095515B9", hash_generated_method = "D5A6AE2AD96D6E5CDD2C090455EC45B2")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            boolean var9C433BA8DB82AA2DC9650721B236AEF4_58595618 = (enumMap.containsKey(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1979364856 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1979364856;
            // ---------- Original Method ----------
            //return enumMap.containsKey(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.374 -0400", hash_original_method = "A4EABEDB06E5BDF24065F571F359AF57", hash_generated_method = "CFF7585E258920FAA3FC467EFA638A52")
        @Override
        @SuppressWarnings("unchecked")
        public Iterator iterator() {
Iterator var3DC885AAF5C13DB42B2D8CE8802A24A5_667933594 =             new EnumMapIterator<KT, KT, VT>(
                    new MapEntry.Type<KT, KT, VT>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.373 -0400", hash_original_method = "58D5C15AA7C95D597054A9860FD7B3EB", hash_generated_method = "D98C9FEDEFAB794A038939506D3E6D21")
            public KT get(MapEntry<KT, VT> entry) {
                addTaint(entry.getTaint());
KT varB5B6628E54DDBF3AFBF30F96A74440CA_547975423 =                 entry.key;
                varB5B6628E54DDBF3AFBF30F96A74440CA_547975423.addTaint(taint);
                return varB5B6628E54DDBF3AFBF30F96A74440CA_547975423;
                // ---------- Original Method ----------
                //return entry.key;
            }
}, enumMap);
            var3DC885AAF5C13DB42B2D8CE8802A24A5_667933594.addTaint(taint);
            return var3DC885AAF5C13DB42B2D8CE8802A24A5_667933594;
            // ---------- Original Method ----------
            //return new EnumMapIterator<KT, KT, VT>(
                    //new MapEntry.Type<KT, KT, VT>() {
                        //public KT get(MapEntry<KT, VT> entry) {
                            //return entry.key;
                        //}
                    //}, enumMap);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.374 -0400", hash_original_method = "B8F9F39AE912D64223C40421DFD1515A", hash_generated_method = "E90E60D5EA1E82308AFDBF55C8DBAE96")
        @Override
        @SuppressWarnings("unchecked")
        public boolean remove(Object object) {
            addTaint(object.getTaint());
    if(contains(object))            
            {
                enumMap.remove(object);
                boolean varB326B5062B2F0E69046810717534CB09_1279055051 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_813587055 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_813587055;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_572973368 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1524161818 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1524161818;
            // ---------- Original Method ----------
            //if (contains(object)) {
                //enumMap.remove(object);
                //return true;
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.374 -0400", hash_original_method = "C9EE7DD74ED1B4234C539DA28C6D21A7", hash_generated_method = "5517B2648A46E44E23F545D738635F3A")
        @Override
        public int size() {
            int var0937C4E59AE70A23FC6F4E24085E6345_1095626477 = (enumMap.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_656120405 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_656120405;
            // ---------- Original Method ----------
            //return enumMap.size();
        }

        
        // orphaned legacy method
        public KT get(MapEntry<KT, VT> entry) {
                            return entry.key;
                        }
        
    }


    
    private static class EnumMapValueCollection<KT extends Enum<KT>, VT> extends AbstractCollection<VT> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.375 -0400", hash_original_field = "0C2D76D104B4FBD56D5878F0C7B4948D", hash_generated_field = "2D3692AFCA37C24E228F49DBDE7EDE40")

        private EnumMap<KT, VT> enumMap;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.375 -0400", hash_original_method = "1A0661F4095C8F41E606FE019F34B01E", hash_generated_method = "E5ABA9176789D0F83D15C4076A2F1270")
          EnumMapValueCollection(EnumMap<KT, VT> em) {
            enumMap = em;
            // ---------- Original Method ----------
            //enumMap = em;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.375 -0400", hash_original_method = "C3DE5D46C4F9CFEF3C6B4695838239E5", hash_generated_method = "063732887140DDE2D3345C92C7674BBE")
        @Override
        public void clear() {
            enumMap.clear();
            // ---------- Original Method ----------
            //enumMap.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.376 -0400", hash_original_method = "F0FBCB059002559902B972108CF0BABE", hash_generated_method = "23A72651478097EC9CA30B274B6AB624")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            boolean var4814599FF046122293A219E70CF983CB_1912989636 = (enumMap.containsValue(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2042250567 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2042250567;
            // ---------- Original Method ----------
            //return enumMap.containsValue(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.376 -0400", hash_original_method = "BC6C06395E1460CC49F247C03E1763F0", hash_generated_method = "D6D4E6275F707D524FE5C38F9D1DCFC8")
        @SuppressWarnings("unchecked")
        @Override
        public Iterator iterator() {
Iterator var036D6891E4F32E3A02A8377B9160AF5E_1525878628 =             new EnumMapIterator<VT, KT, VT>(
                    new MapEntry.Type<VT, KT, VT>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.376 -0400", hash_original_method = "C542D68881AE52AD0D43DA03AB0FAD85", hash_generated_method = "53950E68077AD40EDC148BFFDD793420")
            public VT get(MapEntry<KT, VT> entry) {
                addTaint(entry.getTaint());
VT varD2C0624DDD8A4F8F307477F36B405DFB_1058118917 =                 entry.value;
                varD2C0624DDD8A4F8F307477F36B405DFB_1058118917.addTaint(taint);
                return varD2C0624DDD8A4F8F307477F36B405DFB_1058118917;
                // ---------- Original Method ----------
                //return entry.value;
            }
}, enumMap);
            var036D6891E4F32E3A02A8377B9160AF5E_1525878628.addTaint(taint);
            return var036D6891E4F32E3A02A8377B9160AF5E_1525878628;
            // ---------- Original Method ----------
            //return new EnumMapIterator<VT, KT, VT>(
                    //new MapEntry.Type<VT, KT, VT>() {
                        //public VT get(MapEntry<KT, VT> entry) {
                            //return entry.value;
                        //}
                    //}, enumMap);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.377 -0400", hash_original_method = "47E37FB3671E07CE32BC2BA28A816FCA", hash_generated_method = "9587E650891319F3A295B9504A6D8DB1")
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
                        boolean varB326B5062B2F0E69046810717534CB09_2108961818 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1469730853 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1469730853;
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
                        boolean varB326B5062B2F0E69046810717534CB09_717666975 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_504415325 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_504415325;
                    } //End block
                } //End block
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1614765207 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1746469079 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1746469079;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.378 -0400", hash_original_method = "C9EE7DD74ED1B4234C539DA28C6D21A7", hash_generated_method = "E20648AB0F29AEB92EF7683C1D660461")
        @Override
        public int size() {
            int var0937C4E59AE70A23FC6F4E24085E6345_1564791274 = (enumMap.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1962762706 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1962762706;
            // ---------- Original Method ----------
            //return enumMap.size();
        }

        
        // orphaned legacy method
        public VT get(MapEntry<KT, VT> entry) {
                            return entry.value;
                        }
        
    }


    
    private static class EnumMapEntryIterator<E, KT extends Enum<KT>, VT> extends EnumMapIterator<E, KT, VT> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.378 -0400", hash_original_method = "4B20A4930FDD81120A40D2421C6DB306", hash_generated_method = "4FBF75CCFB9FEF701AD2A23786B7B68E")
          EnumMapEntryIterator(MapEntry.Type<E, KT, VT> value, EnumMap<KT, VT> em) {
            super(value, em);
            addTaint(em.getTaint());
            addTaint(value.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.378 -0400", hash_original_method = "AA0A985577200C3410BBA8066828BEEB", hash_generated_method = "89B17F92BA031A57412F2F5B662AC429")
        @SuppressWarnings("unchecked")
        @Override
        public E next() {
    if(!hasNext())            
            {
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_1424121048 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_1424121048.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_1424121048;
            } //End block
            prePosition = position++;
E var9AC0307A5A079FF49EDDEA7AAD7008A5_78168117 =             type.get(new Entry<KT, VT>((KT) enumMap.keys[prePosition],
                    (VT) enumMap.values[prePosition], enumMap));
            var9AC0307A5A079FF49EDDEA7AAD7008A5_78168117.addTaint(taint);
            return var9AC0307A5A079FF49EDDEA7AAD7008A5_78168117;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.379 -0400", hash_original_field = "0C2D76D104B4FBD56D5878F0C7B4948D", hash_generated_field = "2D3692AFCA37C24E228F49DBDE7EDE40")

        private EnumMap<KT, VT> enumMap;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.379 -0400", hash_original_method = "616E4B9747EFF9433BD58C5F15DEC121", hash_generated_method = "D78FC31B5B25F7A257282F3524D220D6")
          EnumMapEntrySet(EnumMap<KT, VT> em) {
            enumMap = em;
            // ---------- Original Method ----------
            //enumMap = em;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.379 -0400", hash_original_method = "C3DE5D46C4F9CFEF3C6B4695838239E5", hash_generated_method = "063732887140DDE2D3345C92C7674BBE")
        @Override
        public void clear() {
            enumMap.clear();
            // ---------- Original Method ----------
            //enumMap.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.380 -0400", hash_original_method = "4AC40C6458CB1EE4BF18663D9AB10FCB", hash_generated_method = "A390510E20E5DB6D0445FD088382E86D")
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
            boolean var39E60812C32297C6953BED0D58CF27B6_595112840 = (isEqual);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_155078476 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_155078476;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.380 -0400", hash_original_method = "95EB2B60E0E6891B83EBE6118D53811C", hash_generated_method = "767CDDB0BEA4B0E0E35F898B94F722BB")
        @Override
        public Iterator<Map.Entry<KT, VT>> iterator() {
Iterator<Map.Entry<KT, VT>> varFE22973482D44A4465B49DBA0D13776B_925469802 =             new EnumMapEntryIterator<Map.Entry<KT, VT>, KT, VT>(
                    new MapEntry.Type<Map.Entry<KT, VT>, KT, VT>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.380 -0400", hash_original_method = "E6C5689ECDF5DCF09D122C660DDB94F0", hash_generated_method = "F01DAA78CE97EC2EB61B6C025B400B61")
            public Map.Entry<KT, VT> get(MapEntry<KT, VT> entry) {
                addTaint(entry.getTaint());
Map.Entry<KT, VT> varF26DBE38545460D6F6AE1D948FF53869_1411832324 =                 entry;
                varF26DBE38545460D6F6AE1D948FF53869_1411832324.addTaint(taint);
                return varF26DBE38545460D6F6AE1D948FF53869_1411832324;
                // ---------- Original Method ----------
                //return entry;
            }
}, enumMap);
            varFE22973482D44A4465B49DBA0D13776B_925469802.addTaint(taint);
            return varFE22973482D44A4465B49DBA0D13776B_925469802;
            // ---------- Original Method ----------
            //return new EnumMapEntryIterator<Map.Entry<KT, VT>, KT, VT>(
                    //new MapEntry.Type<Map.Entry<KT, VT>, KT, VT>() {
                        //public Map.Entry<KT, VT> get(MapEntry<KT, VT> entry) {
                            //return entry;
                        //}
                    //}, enumMap);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.381 -0400", hash_original_method = "B1FBE3FDE380AB91D92300437712D6CE", hash_generated_method = "C27FF241FB9F1D3B1FBA937917298C02")
        @Override
        public boolean remove(Object object) {
            addTaint(object.getTaint());
    if(contains(object))            
            {
                enumMap.remove(((Map.Entry) object).getKey());
                boolean varB326B5062B2F0E69046810717534CB09_1987447501 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_908449486 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_908449486;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1750264273 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1051942452 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1051942452;
            // ---------- Original Method ----------
            //if (contains(object)) {
                //enumMap.remove(((Map.Entry) object).getKey());
                //return true;
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.381 -0400", hash_original_method = "C9EE7DD74ED1B4234C539DA28C6D21A7", hash_generated_method = "16288892C1C2D823E52D033EF8171CA1")
        @Override
        public int size() {
            int var0937C4E59AE70A23FC6F4E24085E6345_539539780 = (enumMap.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1338159621 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1338159621;
            // ---------- Original Method ----------
            //return enumMap.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.381 -0400", hash_original_method = "36EAFDE13B72544D308E66F5613D1161", hash_generated_method = "9016F4AA0DCC5B31405C566CFEF3E55A")
        @Override
        public Object[] toArray() {
            Object[] entryArray = new Object[enumMap.size()];
Object[] var8030B76E3C574EFC5D11EBF77AB90BE3_1995038497 =             toArray(entryArray);
            var8030B76E3C574EFC5D11EBF77AB90BE3_1995038497.addTaint(taint);
            return var8030B76E3C574EFC5D11EBF77AB90BE3_1995038497;
            // ---------- Original Method ----------
            //Object[] entryArray = new Object[enumMap.size()];
            //return toArray(entryArray);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.382 -0400", hash_original_method = "9EABF255823509EF0FD5FF1AC40C33FF", hash_generated_method = "D891BCAD6481FE8589C20C71A0DBEC38")
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
Object[] var2DBA465DA7F2FCDFB98C27D0A75614F5_135012861 =             entryArray;
            var2DBA465DA7F2FCDFB98C27D0A75614F5_135012861.addTaint(taint);
            return var2DBA465DA7F2FCDFB98C27D0A75614F5_135012861;
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.382 -0400", hash_original_field = "ACF5FEE0E990C707AF7445EBA9610512", hash_generated_field = "E1BAC054FBC7EDF33360B5E852ACA6E1")

    private static final long serialVersionUID = 458661240069192865L;
}

