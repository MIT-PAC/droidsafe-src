package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class IdentityHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Serializable, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.421 -0400", hash_original_field = "8D395F1876FF8AE01BE52A9C4C2ED552", hash_generated_field = "AD127E2B4D986278CBFC1D9FF3B666A1")

    transient Object[] elementData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.421 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "673BDAEBF4FBC900963E210E042549D6")

    int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.421 -0400", hash_original_field = "F0598264A691A8F62272ACA0E79AF374", hash_generated_field = "EBFF2C10A18F7B4BDFBFF5FE82B9E916")

    transient int threshold;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.421 -0400", hash_original_field = "8626C3CD64A823DD7B97C6F5EF45A8FC", hash_generated_field = "12E79C42739D112FBF146E2A08503782")

    transient int modCount = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.422 -0400", hash_original_method = "CF4E04D9BE7BBED84D489834E5A66249", hash_generated_method = "7B2C94FF6E4515C0EBFC83D4A1CE56F5")
    public  IdentityHashMap() {
        this(DEFAULT_MAX_SIZE);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.422 -0400", hash_original_method = "7CD774B1E9CE336DC45F8F4C393FF983", hash_generated_method = "6DCE95B840878CC5A266B02ACB28F0BF")
    public  IdentityHashMap(int maxSize) {
        {
            this.size = 0;
            threshold = getThreshold(maxSize);
            elementData = newElementArray(computeElementArraySize());
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } 
        
        
            
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.422 -0400", hash_original_method = "A6044E4311D15BDAC205EAB611B1078B", hash_generated_method = "1A4F44C5E408C25801B283C6B6B4B0E2")
    public  IdentityHashMap(Map<? extends K, ? extends V> map) {
        this(map.size() < 6 ? 11 : map.size() * 2);
        putAllImpl(map);
        addTaint(map.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.422 -0400", hash_original_method = "781BC1AEB43B59447DF913A0C6E9B0CF", hash_generated_method = "9148DCFA2322196302C055946E5228E9")
    private int getThreshold(int maxSize) {
        addTaint(maxSize);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1645702210 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1645702210;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.422 -0400", hash_original_method = "1EC323E151A9A9F2A50AC6CDC57160D0", hash_generated_method = "2B7F8307E4A5A2BCD05B5DEFEE459523")
    private int computeElementArraySize() {
        int arraySize = (int) (((long) threshold * 10000) / loadFactor) * 2;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_433676903 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_433676903;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.423 -0400", hash_original_method = "82EDC40DB5D2D8551DABF13E0864CA4A", hash_generated_method = "B6F92F55D3F633277A424E361CA2790F")
    private Object[] newElementArray(int s) {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_661521152 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_661521152 = new Object[s];
        addTaint(s);
        varB4EAC82CA7396A68D541C85D26508E83_661521152.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_661521152;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.423 -0400", hash_original_method = "EC077FF294E7BB24D59CB59A711685E2", hash_generated_method = "D257BB0B84E444CEE4AE44DF63BF461E")
    @SuppressWarnings("unchecked")
    private V massageValue(Object value) {
        V varB4EAC82CA7396A68D541C85D26508E83_934622021 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_934622021 = (V) ((value == NULL_OBJECT) ? null : value);
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_934622021.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_934622021;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.424 -0400", hash_original_method = "BDCD76FD65816EABAE96959FB0B37C8A", hash_generated_method = "FB306520919E91A959D588485570D829")
    @Override
    public void clear() {
        size = 0;
        {
            int i = 0;
            {
                elementData[i] = null;
            } 
        } 
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.425 -0400", hash_original_method = "5096545BB8D7E235F81B2D74AA90BB35", hash_generated_method = "31CB46311324B2912B93D6E362953B32")
    @Override
    public boolean containsKey(Object key) {
        {
            key = NULL_OBJECT;
        } 
        int index = findIndex(key, elementData);
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_462850326 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_462850326;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.425 -0400", hash_original_method = "182DC7E21BB3FA85F9FDDA653B5E53EC", hash_generated_method = "839767B35D8B24C40EAD9DD9E48C7A23")
    @Override
    public boolean containsValue(Object value) {
        {
            value = NULL_OBJECT;
        } 
        {
            int i = 1;
            i = i + 2;
        } 
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2140092775 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2140092775;
        
        
            
        
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.426 -0400", hash_original_method = "F6964BC1AA97AC873AACFDCE0324626E", hash_generated_method = "CB0BA633CEA94D6B98163ACCA012A536")
    @Override
    public V get(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_585228903 = null; 
        V varB4EAC82CA7396A68D541C85D26508E83_289004928 = null; 
        {
            key = NULL_OBJECT;
        } 
        int index = findIndex(key, elementData);
        {
            Object result = elementData[index + 1];
            varB4EAC82CA7396A68D541C85D26508E83_585228903 = massageValue(result);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_289004928 = null;
        addTaint(key.getTaint());
        V varA7E53CE21691AB073D9660D615818899_1367047269; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1367047269 = varB4EAC82CA7396A68D541C85D26508E83_585228903;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1367047269 = varB4EAC82CA7396A68D541C85D26508E83_289004928;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1367047269.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1367047269;
        
        
            
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.427 -0400", hash_original_method = "BBF7F36B48A0928E4E8AF0FBF2D6C2A4", hash_generated_method = "CAAAD47A00464332E84D21FC40EB7520")
    private IdentityHashMapEntry<K, V> getEntry(Object key) {
        IdentityHashMapEntry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1824060608 = null; 
        IdentityHashMapEntry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1473428508 = null; 
        {
            key = NULL_OBJECT;
        } 
        int index = findIndex(key, elementData);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1824060608 = getEntry(index);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1473428508 = null;
        addTaint(key.getTaint());
        IdentityHashMapEntry<K, V> varA7E53CE21691AB073D9660D615818899_1167081802; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1167081802 = varB4EAC82CA7396A68D541C85D26508E83_1824060608;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1167081802 = varB4EAC82CA7396A68D541C85D26508E83_1473428508;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1167081802.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1167081802;
        
        
            
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.428 -0400", hash_original_method = "84E908F75D5C9D1CDED221D7011BB031", hash_generated_method = "80A6DE483C845AD3E3F1ABD5D6180FDB")
    @SuppressWarnings("unchecked")
    private IdentityHashMapEntry<K, V> getEntry(int index) {
        IdentityHashMapEntry<K, V> varB4EAC82CA7396A68D541C85D26508E83_702933437 = null; 
        Object key = elementData[index];
        Object value = elementData[index + 1];
        {
            key = null;
        } 
        {
            value = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_702933437 = new IdentityHashMapEntry<K, V>(this, (K) key, (V) value);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_702933437.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_702933437;
        
        
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.428 -0400", hash_original_method = "A3A8F03C1D1CA3BA128703E55ACFBE13", hash_generated_method = "04FED1BC7F7F82A367DF6AF9A08810C2")
    private int findIndex(Object key, Object[] array) {
        int length = array.length;
        int index = getModuloHash(key, length);
        int last = (index + length - 2) % length;
        {
            index = (index + 2) % length;
        } 
        addTaint(key.getTaint());
        addTaint(array[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1376564749 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1376564749;
        
        
        
        
        
            
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.429 -0400", hash_original_method = "5971E6E68410637276D03AFF9F1601B4", hash_generated_method = "A5D3691D7D16CFFF7C0C8748C683371A")
    private int getModuloHash(Object key, int length) {
        int var1955E354538F965E02CCD189A606FF50_367041793 = (((System.identityHashCode(key) & 0x7FFFFFFF) % (length / 2)) * 2);
        addTaint(key.getTaint());
        addTaint(length);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1025253888 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1025253888;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.429 -0400", hash_original_method = "5FE57D2E7B335A053FA4B0E269FB9FA5", hash_generated_method = "67267266389236DA22D7B61B56E6CB9D")
    @Override
    public V put(K key, V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_853627991 = null; 
        Object _key = key;
        Object _value = value;
        {
            _key = NULL_OBJECT;
        } 
        {
            _value = NULL_OBJECT;
        } 
        int index = findIndex(_key, elementData);
        {
            {
                rehash();
                index = findIndex(_key, elementData);
            } 
            elementData[index] = _key;
            elementData[index + 1] = null;
        } 
        Object result = elementData[index + 1];
        elementData[index + 1] = _value;
        varB4EAC82CA7396A68D541C85D26508E83_853627991 = massageValue(result);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_853627991.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_853627991;
        
        
        
        
            
        
        
            
        
        
        
            
            
                
                
            
            
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.430 -0400", hash_original_method = "57B3987EA7E50826E0AAD0198F968E42", hash_generated_method = "43FD7CC93F90FFCD58209DA7AC6028FD")
    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        putAllImpl(map);
        addTaint(map.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.430 -0400", hash_original_method = "DDE8094F149435C7DE287F5101860F65", hash_generated_method = "197BF53BF7436450A9EDFACA4A61885E")
    private void rehash() {
        int newlength = elementData.length * 2;
        {
            newlength = 1;
        } 
        Object[] newData = newElementArray(newlength);
        {
            int i = 0;
            i = i + 2;
            {
                Object key = elementData[i];
                {
                    int index = findIndex(key, newData);
                    newData[index] = key;
                    newData[index + 1] = elementData[i + 1];
                } 
            } 
        } 
        elementData = newData;
        computeMaxSize();
        
        
        
            
        
        
        
            
            
                
                
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.430 -0400", hash_original_method = "89E1F2A524C9BAC235F25992FD1AF281", hash_generated_method = "3D7CA775847A3C80DA39F0E34AAE3ABF")
    private void computeMaxSize() {
        threshold = (int) ((long) (elementData.length / 2) * loadFactor / 10000);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.432 -0400", hash_original_method = "5D1C6299BDD74A2A432086CB6E5E8EB0", hash_generated_method = "14508F0BC2D4CE2FA7CC0AF1F9909B4A")
    @Override
    public V remove(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_1694559451 = null; 
        V varB4EAC82CA7396A68D541C85D26508E83_1969042052 = null; 
        {
            key = NULL_OBJECT;
        } 
        boolean hashedOk;
        int index;
        int next;
        int hash;
        Object result;
        Object object;
        index = next = findIndex(key, elementData);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1694559451 = null;
        } 
        result = elementData[index + 1];
        int length = elementData.length;
        {
            next = (next + 2) % length;
            object = elementData[next];
            hash = getModuloHash(object, length);
            hashedOk = hash > index;
            {
                hashedOk = hashedOk || (hash <= next);
            } 
            {
                hashedOk = hashedOk && (hash <= next);
            } 
            {
                elementData[index] = object;
                elementData[index + 1] = elementData[next + 1];
                index = next;
            } 
        } 
        elementData[index] = null;
        elementData[index + 1] = null;
        varB4EAC82CA7396A68D541C85D26508E83_1969042052 = massageValue(result);
        addTaint(key.getTaint());
        V varA7E53CE21691AB073D9660D615818899_1028681978; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1028681978 = varB4EAC82CA7396A68D541C85D26508E83_1694559451;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1028681978 = varB4EAC82CA7396A68D541C85D26508E83_1969042052;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1028681978.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1028681978;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.432 -0400", hash_original_method = "426CBD32668C89F2F09688DDB7CBD67D", hash_generated_method = "124BC247831114462E550FD22B7D875C")
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_439324487 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_439324487 = new IdentityHashMapEntrySet<K, V>(this);
        varB4EAC82CA7396A68D541C85D26508E83_439324487.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_439324487;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.437 -0400", hash_original_method = "9E081198F867421B2EE1E810B189D8F9", hash_generated_method = "7984562DAB5D0B03116CD2A1BA8CD80A")
    @Override
    public Set<K> keySet() {
        Set<K> varB4EAC82CA7396A68D541C85D26508E83_467864958 = null; 
        {
            keySet = new AbstractSet<K>() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.434 -0400", hash_original_method = "D170B4D54B17306878DDF90A529C04ED", hash_generated_method = "FD111AE60FA346FC9D2F652BFB96FA6D")
                @Override
                public boolean contains(Object object) {
                    boolean var5CF08BC5A8889C1E8B40FF0332AFAC24_1601020562 = (containsKey(object));
                    addTaint(object.getTaint());
                    boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_803393030 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_803393030;
                    
                    
                }
                @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.434 -0400", hash_original_method = "493FF83788BDD57678BE8EC76775D2EC", hash_generated_method = "85A7F843018B6961F2DBDB790D320547")
                @Override
                public int size() {
                    int varBC51B28386FA67ED3E3F40218C89CFB9_670801143 = (IdentityHashMap.this.size());
                    int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2097021022 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2097021022;
                    
                    
                }
                @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.435 -0400", hash_original_method = "8EE7B74E95EF739684600DCE51B8E175", hash_generated_method = "8E7BC4B18C8D2D3FCEC28F8038114E81")
                @Override
                public void clear() {
                    IdentityHashMap.this.clear();
                    
                    
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.435 -0400", hash_original_method = "490547D1556DE6EF3FD9A72186FC3697", hash_generated_method = "F2BBBFBC4B3FB9059E4459F927D29F40")
                @Override
                public boolean remove(Object key) {
                    {
                        boolean varD4D10245FFFD9692A4F42EDF884E815E_436680064 = (containsKey(key));
                        {
                            IdentityHashMap.this.remove(key);
                        } 
                    } 
                    addTaint(key.getTaint());
                    boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_78946469 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_78946469;
                    
                    
                        
                        
                    
                    
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.436 -0400", hash_original_method = "723F8CF71A67441033B1836A0735513A", hash_generated_method = "FE042C563D758FF14989B75A33C6BA7E")
                @Override
                public Iterator<K> iterator() {
                    Iterator<K> varB4EAC82CA7396A68D541C85D26508E83_187246772 = null; 
                    varB4EAC82CA7396A68D541C85D26508E83_187246772 = new IdentityHashMapIterator<K, K, V>(
                            new MapEntry.Type<K, K, V>() {
                                public K get(MapEntry<K, V> entry) {
                                    return entry.key;
                                }
                            }, IdentityHashMap.this);
                    varB4EAC82CA7396A68D541C85D26508E83_187246772.addTaint(getTaint()); 
                    return varB4EAC82CA7396A68D541C85D26508E83_187246772;
                    
                    
                            
                                
                                    
                                
                            
                }
};
        } 
        varB4EAC82CA7396A68D541C85D26508E83_467864958 = keySet;
        varB4EAC82CA7396A68D541C85D26508E83_467864958.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_467864958;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.443 -0400", hash_original_method = "C71140816AE220E4DE6F3C222B8E61B9", hash_generated_method = "5CD4E65522D01FC73EC08EF78F1AE5CE")
    @Override
    public Collection<V> values() {
        Collection<V> varB4EAC82CA7396A68D541C85D26508E83_562859744 = null; 
        {
            valuesCollection = new AbstractCollection<V>() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.440 -0400", hash_original_method = "7679F4183F803D10EFCD1172E399C7C3", hash_generated_method = "4C70935FD1AC3F31E7C3E7F1D738F75E")
                @Override
                public boolean contains(Object object) {
                    boolean varF0370008E8B5928F4FAF5BBF8632C1B3_186516410 = (containsValue(object));
                    addTaint(object.getTaint());
                    boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_85542026 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_85542026;
                    
                    
                }
                @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.441 -0400", hash_original_method = "493FF83788BDD57678BE8EC76775D2EC", hash_generated_method = "C9DF7514FE8D2946E2D939ED4491B63E")
                @Override
                public int size() {
                    int varBC51B28386FA67ED3E3F40218C89CFB9_1649948298 = (IdentityHashMap.this.size());
                    int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1030618222 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1030618222;
                    
                    
                }
                @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.441 -0400", hash_original_method = "8EE7B74E95EF739684600DCE51B8E175", hash_generated_method = "8E7BC4B18C8D2D3FCEC28F8038114E81")
                @Override
                public void clear() {
                    IdentityHashMap.this.clear();
                    
                    
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.442 -0400", hash_original_method = "716DB1296581D00BED615692167CF55E", hash_generated_method = "5CC1AE3EBD3F003A0BA5C44E4310930A")
                @Override
                public Iterator<V> iterator() {
                    Iterator<V> varB4EAC82CA7396A68D541C85D26508E83_248076205 = null; 
                    varB4EAC82CA7396A68D541C85D26508E83_248076205 = new IdentityHashMapIterator<V, K, V>(
                            new MapEntry.Type<V, K, V>() {
                                public V get(MapEntry<K, V> entry) {
                                    return entry.value;
                                }
                            }, IdentityHashMap.this);
                    varB4EAC82CA7396A68D541C85D26508E83_248076205.addTaint(getTaint()); 
                    return varB4EAC82CA7396A68D541C85D26508E83_248076205;
                    
                    
                            
                                
                                    
                                
                            
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.442 -0400", hash_original_method = "5ADE2469436E9C63C02002691A8A1FCC", hash_generated_method = "C5E2AC58EC94953475F0FA37AD8DF4C6")
                @Override
                public boolean remove(Object object) {
                    Iterator<?> it = iterator();
                    {
                        boolean var4CA2EDBF7D27138D75E73CCD01CCB025_453686197 = (it.hasNext());
                        {
                            {
                                boolean var130391727764061DB0EB2373925D07D9_1989403352 = (object == it.next());
                                {
                                    it.remove();
                                } 
                            } 
                        } 
                    } 
                    addTaint(object.getTaint());
                    boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_683163433 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_683163433;
                    
                    
                    
                        
                            
                            
                        
                    
                    
                }
};
        } 
        varB4EAC82CA7396A68D541C85D26508E83_562859744 = valuesCollection;
        varB4EAC82CA7396A68D541C85D26508E83_562859744.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_562859744;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.444 -0400", hash_original_method = "84B9E6027D2FCCE6A1B5E4707316E9F7", hash_generated_method = "A8396DEB2BF526DD8AC4F4A9BF000CE2")
    @Override
    public boolean equals(Object object) {
        {
            Map<?, ?> map = (Map) object;
            {
                boolean var17E93156AEDB9EC4C0BE0F9FC6995057_544915061 = (size() != map.size());
            } 
            Set<Map.Entry<K, V>> set = entrySet();
            boolean var5B7F63BD128FBBEA15DCBF7B0F66F062_1066591939 = (set.equals(map.entrySet()));
        } 
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1265195781 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1265195781;
        
        
            
        
        
            
            
                
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.450 -0400", hash_original_method = "593629377CF6402E72F5DC997FF5D0DD", hash_generated_method = "9FA457D80DE69585BC43D4A5DB6F7F9C")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_2016894653 = null; 
        try 
        {
            IdentityHashMap<K, V> cloneHashMap = (IdentityHashMap<K, V>) super.clone();
            cloneHashMap.elementData = newElementArray(elementData.length);
            System.arraycopy(elementData, 0, cloneHashMap.elementData, 0, elementData.length);
            varB4EAC82CA7396A68D541C85D26508E83_2016894653 = cloneHashMap;
        } 
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2016894653.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2016894653;
        
        
            
            
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.452 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "586F3E83135B26EA8ABA89DBBBC892E5")
    @Override
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1124155461 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1124155461;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.453 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "1F4B711F0163E0B9A7EAF9A5C48FF245")
    @Override
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_851901315 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_851901315;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.453 -0400", hash_original_method = "8BD2A28D5C70743AFDE70AFCF38381D1", hash_generated_method = "EE09F8027DFB9DE3F835376208DACD45")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(size);
        Iterator<?> iterator = entrySet().iterator();
        {
            boolean var15F7FE2AD7E10C613CA4B915023EF041_90941097 = (iterator.hasNext());
            {
                MapEntry<?, ?> entry = (MapEntry) iterator.next();
                stream.writeObject(entry.key);
                stream.writeObject(entry.value);
            } 
        } 
        addTaint(stream.getTaint());
        
        
        
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.454 -0400", hash_original_method = "7467D6AC226ECB31B060088968C9C4EC", hash_generated_method = "4A6E59B11DEAC30950BF3047181DBB90")
    @SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        stream.defaultReadObject();
        int savedSize = stream.readInt();
        threshold = getThreshold(DEFAULT_MAX_SIZE);
        elementData = newElementArray(computeElementArraySize());
        {
            int i = savedSize;
            {
                K key = (K) stream.readObject();
                put(key, (V) stream.readObject());
            } 
        } 
        size = savedSize;
        addTaint(stream.getTaint());
        
        
        
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.454 -0400", hash_original_method = "F23833AECC848C129604A1D671C10BB2", hash_generated_method = "532F8BACA6BBE4354E375E5D51D0AE1A")
    private void putAllImpl(Map<? extends K, ? extends V> map) {
        {
            boolean var6889E31DD8EB0136BAB9D60DD7EEE838_333859109 = (map.entrySet() != null);
            {
                super.putAll(map);
            } 
        } 
        addTaint(map.getTaint());
        
        
            
        
    }

    
    static class IdentityHashMapEntry<K, V> extends MapEntry<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.454 -0400", hash_original_field = "1D78DC8ED51214E518B5114FE24490AE", hash_generated_field = "3D88558CB5032F1BD977664E1B57DEDB")

        private IdentityHashMap<K,V> map;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.455 -0400", hash_original_method = "45D4C8262B140EBFC37DC125C8AC9505", hash_generated_method = "D274449496C16FE0BBB0F55539584098")
          IdentityHashMapEntry(IdentityHashMap<K,V> map, K theKey, V theValue) {
            super(theKey, theValue);
            this.map = map;
            addTaint(theKey.getTaint());
            addTaint(theValue.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.456 -0400", hash_original_method = "323EA29B58059AEF6BA9ED0328A60A9B", hash_generated_method = "6F684A7AC2CFE7A531873667864731D6")
        @Override
        public Object clone() {
            Object varB4EAC82CA7396A68D541C85D26508E83_1332765546 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1332765546 = super.clone();
            varB4EAC82CA7396A68D541C85D26508E83_1332765546.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1332765546;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.457 -0400", hash_original_method = "BEBDBC589EC917AC9D19EF3668A7491A", hash_generated_method = "0679B26EF9EF72AB5C2DD33F0AA9706C")
        @Override
        public boolean equals(Object object) {
            {
                Map.Entry<?, ?> entry = (Map.Entry) object;
                boolean var2CF4DA5B248B71F8723C2CFF4C38CCCF_1489010905 = ((key == entry.getKey()) && (value == entry.getValue()));
            } 
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_199000643 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_199000643;
            
            
                
            
            
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.458 -0400", hash_original_method = "6C06106E191A8CD852E6C421EE7C4BCA", hash_generated_method = "2A7446F310859B0A9A9F77064D69EC7D")
        @Override
        public int hashCode() {
            int var1F8EEF3049B8A3F70256231F65F00B6F_1248441400 = (System.identityHashCode(key)
                    ^ System.identityHashCode(value));
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1672333965 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1672333965;
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.459 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "3DDF1CD173A82B530F65B2CB48D64B72")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1539489011 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1539489011 = key + "=" + value;
            varB4EAC82CA7396A68D541C85D26508E83_1539489011.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1539489011;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.460 -0400", hash_original_method = "3AB767B3337A96E3FF8E7E50DD61C26B", hash_generated_method = "D721DB0CCD6481649685579169DC88D7")
        @Override
        public V setValue(V object) {
            V varB4EAC82CA7396A68D541C85D26508E83_2135751105 = null; 
            V result = super.setValue(object);
            map.put(key, object);
            varB4EAC82CA7396A68D541C85D26508E83_2135751105 = result;
            addTaint(object.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2135751105.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2135751105;
            
            
            
            
        }

        
    }


    
    static class IdentityHashMapIterator<E, KT, VT> implements Iterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.460 -0400", hash_original_field = "64F8FBF9ECD410CCCCA37B900774D128", hash_generated_field = "6E2A691F6D792F742C26DA32023216AB")

        private int position = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.460 -0400", hash_original_field = "6F04CE4FBA27D4E32176E1FA260C7944", hash_generated_field = "158350FDC3EB690937A7433CD8FDCF25")

        private int lastPosition = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.460 -0400", hash_original_field = "17596D9B1BA2E6C64969EEC939BA98FD", hash_generated_field = "4A3F446F089E073EC39F9EFCA5E0A875")

        IdentityHashMap<KT, VT> associatedMap;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.460 -0400", hash_original_field = "295CC8887E8B8B43596FF881B307867C", hash_generated_field = "92DA548A98D3BA977C330B914F0C29E7")

        int expectedModCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.460 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "32CBE0E3CB6327A7B40B9B82E058EE9D")

        MapEntry.Type<E, KT, VT> type;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.460 -0400", hash_original_field = "95B5EA53A559DF3C9FB473B486E592C4", hash_generated_field = "89B380148E5E88610AC53F02DD8177BF")

        boolean canRemove = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.461 -0400", hash_original_method = "BFDED7A7210C6DD0D7CDC5258204AA4E", hash_generated_method = "4210FC6D81640DF85E6C94C89696CA19")
          IdentityHashMapIterator(MapEntry.Type<E, KT, VT> value,
                IdentityHashMap<KT, VT> hm) {
            associatedMap = hm;
            type = value;
            expectedModCount = hm.modCount;
            
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.461 -0400", hash_original_method = "B784A2EBEA8DE50E57B347BC65196B23", hash_generated_method = "017113B91894153D4E1584685C24A96A")
        public boolean hasNext() {
            {
                {
                    position += 2;
                } 
            } 
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1350538636 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1350538636;
            
            
                
                    
                
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.461 -0400", hash_original_method = "7D8E1D2F4CAE7D5905092B32E8FA958D", hash_generated_method = "20EB64A4FD391708937242ACB32D2E32")
         void checkConcurrentMod() throws ConcurrentModificationException {
            {
                if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            } 
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.462 -0400", hash_original_method = "3CE3A2DA18ED93620446BB239F9F4A5B", hash_generated_method = "5A6E1ED0EC04C22ABFFFFAB0D4B7C2FE")
        public E next() {
            E varB4EAC82CA7396A68D541C85D26508E83_591929636 = null; 
            checkConcurrentMod();
            {
                boolean var61E0EA93C8F2038A69462393E2D5DF33_901301296 = (!hasNext());
                {
                    if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                } 
            } 
            IdentityHashMapEntry<KT, VT> result = associatedMap
                    .getEntry(position);
            lastPosition = position;
            position += 2;
            canRemove = true;
            varB4EAC82CA7396A68D541C85D26508E83_591929636 = type.get(result);
            varB4EAC82CA7396A68D541C85D26508E83_591929636.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_591929636;
            
            
            
                
            
            
                    
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.462 -0400", hash_original_method = "32BCAC2DF7A999AB0ADCB0B00908AC85", hash_generated_method = "CDFCFF766F31D79BCE6150409EA27389")
        public void remove() {
            checkConcurrentMod();
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            } 
            canRemove = false;
            associatedMap.remove(associatedMap.elementData[lastPosition]);
            position = lastPosition;
            
            
            
                
            
            
            
            
            
        }

        
    }


    
    static class IdentityHashMapEntrySet<KT, VT> extends AbstractSet<Map.Entry<KT, VT>> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.463 -0400", hash_original_field = "17596D9B1BA2E6C64969EEC939BA98FD", hash_generated_field = "031CFCCC69F39569E94AA635C28967A7")

        private IdentityHashMap<KT, VT> associatedMap;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.463 -0400", hash_original_method = "644AC8197CA2ECBB03BB45257D811561", hash_generated_method = "4EC3D979DE6973C429F81EC0B65DF241")
        public  IdentityHashMapEntrySet(IdentityHashMap<KT, VT> hm) {
            associatedMap = hm;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.463 -0400", hash_original_method = "DF0712385DAC2839FE08C1A7B2E52EB0", hash_generated_method = "9C9DA92BEDBEEECA79B8FFB6EEA055ED")
         IdentityHashMap<KT, VT> hashMap() {
            IdentityHashMap<KT, VT> varB4EAC82CA7396A68D541C85D26508E83_1364925225 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1364925225 = associatedMap;
            varB4EAC82CA7396A68D541C85D26508E83_1364925225.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1364925225;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.464 -0400", hash_original_method = "738E45D9F25B44D082CFB9E446EECBFE", hash_generated_method = "3C37855880D012F99DB6A1384FD660B8")
        @Override
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_429348973 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_429348973;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.464 -0400", hash_original_method = "B5D899CE1CEF925AE089B354CDA8F2E9", hash_generated_method = "13758FD8D23019A75770695ACA1B98B9")
        @Override
        public void clear() {
            associatedMap.clear();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.465 -0400", hash_original_method = "BC07645C8C1B001BABAC9BE4665F3CB5", hash_generated_method = "233FCC3E29F107A8EBE19CC2B3CE5465")
        @Override
        public boolean remove(Object object) {
            {
                boolean var4F9267015FE86EBB3F33114954B93ED1_922250162 = (contains(object));
                {
                    associatedMap.remove(((Map.Entry) object).getKey());
                } 
            } 
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2096801433 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2096801433;
            
            
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.465 -0400", hash_original_method = "C92543981F7A1AD01DCA60A82EA89AF9", hash_generated_method = "07318752FF001D8CF07A4A6988A24BF6")
        @Override
        public boolean contains(Object object) {
            {
                IdentityHashMapEntry<?, ?> entry = associatedMap
                        .getEntry(((Map.Entry) object).getKey());
                boolean varD0E98BB343F5BCF087AF8810D205B9B8_544837923 = (entry != null && entry.equals(object));
            } 
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1524068041 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1524068041;
            
            
                
                        
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.466 -0400", hash_original_method = "4BC212BC4A955648ACAE505982F2CF30", hash_generated_method = "7A648B75DDCE4AA42EF82AEE1F3EFAC5")
        @Override
        public Iterator<Map.Entry<KT, VT>> iterator() {
            Iterator<Map.Entry<KT, VT>> varB4EAC82CA7396A68D541C85D26508E83_1052747161 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1052747161 = new IdentityHashMapIterator<Map.Entry<KT, VT>, KT, VT>(
                    new MapEntry.Type<Map.Entry<KT, VT>, KT, VT>() {
                        public Map.Entry<KT, VT> get(MapEntry<KT, VT> entry) {
                            return entry;
                        }
                    }, associatedMap);
            varB4EAC82CA7396A68D541C85D26508E83_1052747161.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1052747161;
            
            
                    
                        
                            
                        
                    
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.467 -0400", hash_original_field = "2250BF2C5D45E9A4DA80E533ECA51561", hash_generated_field = "79E552DDD6CD74A49BFF2F345B8A2229")

    private static final long serialVersionUID = 8188218128353913216L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.467 -0400", hash_original_field = "0D907AB13CC38C0C0C4D64DC62CBEF87", hash_generated_field = "FB05DAE1C403395EF791F285C9C2DC34")

    private static final int DEFAULT_MAX_SIZE = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.467 -0400", hash_original_field = "B2BD8AE5E74B9F87BAC3865215923A2E", hash_generated_field = "8DF1401F08FBAB169B77234D2A23A58C")

    private static final int loadFactor = 7500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.467 -0400", hash_original_field = "A910395C962F6CB32B28C4B279BACC18", hash_generated_field = "9670838B634F6F99ABC3B1A0098F1B0D")

    private static final Object NULL_OBJECT = new Object();
}

