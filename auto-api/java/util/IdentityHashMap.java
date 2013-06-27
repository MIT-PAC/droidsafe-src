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

public class IdentityHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Serializable, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.021 -0400", hash_original_field = "8D395F1876FF8AE01BE52A9C4C2ED552", hash_generated_field = "AD127E2B4D986278CBFC1D9FF3B666A1")

    transient Object[] elementData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.021 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "673BDAEBF4FBC900963E210E042549D6")

    int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.021 -0400", hash_original_field = "F0598264A691A8F62272ACA0E79AF374", hash_generated_field = "EBFF2C10A18F7B4BDFBFF5FE82B9E916")

    transient int threshold;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.021 -0400", hash_original_field = "8626C3CD64A823DD7B97C6F5EF45A8FC", hash_generated_field = "12E79C42739D112FBF146E2A08503782")

    transient int modCount = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.022 -0400", hash_original_method = "CF4E04D9BE7BBED84D489834E5A66249", hash_generated_method = "7B2C94FF6E4515C0EBFC83D4A1CE56F5")
    public  IdentityHashMap() {
        this(DEFAULT_MAX_SIZE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.022 -0400", hash_original_method = "7CD774B1E9CE336DC45F8F4C393FF983", hash_generated_method = "6DCE95B840878CC5A266B02ACB28F0BF")
    public  IdentityHashMap(int maxSize) {
        {
            this.size = 0;
            threshold = getThreshold(maxSize);
            elementData = newElementArray(computeElementArraySize());
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        // ---------- Original Method ----------
        //if (maxSize >= 0) {
            //this.size = 0;
            //threshold = getThreshold(maxSize);
            //elementData = newElementArray(computeElementArraySize());
        //} else {
            //throw new IllegalArgumentException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.022 -0400", hash_original_method = "A6044E4311D15BDAC205EAB611B1078B", hash_generated_method = "1A4F44C5E408C25801B283C6B6B4B0E2")
    public  IdentityHashMap(Map<? extends K, ? extends V> map) {
        this(map.size() < 6 ? 11 : map.size() * 2);
        putAllImpl(map);
        addTaint(map.getTaint());
        // ---------- Original Method ----------
        //putAllImpl(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.023 -0400", hash_original_method = "781BC1AEB43B59447DF913A0C6E9B0CF", hash_generated_method = "7B4000FC59D65AC8665A8B2F0656899E")
    private int getThreshold(int maxSize) {
        addTaint(maxSize);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_626956728 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_626956728;
        // ---------- Original Method ----------
        //return maxSize > 3 ? maxSize : 3;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.023 -0400", hash_original_method = "1EC323E151A9A9F2A50AC6CDC57160D0", hash_generated_method = "27DABBED8C67FB7BABF560C5BA71FE8F")
    private int computeElementArraySize() {
        int arraySize;
        arraySize = (int) (((long) threshold * 10000) / loadFactor) * 2;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_800894946 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_800894946;
        // ---------- Original Method ----------
        //int arraySize = (int) (((long) threshold * 10000) / loadFactor) * 2;
        //return arraySize < 0 ? -arraySize : arraySize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.023 -0400", hash_original_method = "82EDC40DB5D2D8551DABF13E0864CA4A", hash_generated_method = "69FA7D095A280BE59DC1091AF155EBF8")
    private Object[] newElementArray(int s) {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_1754181884 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1754181884 = new Object[s];
        addTaint(s);
        varB4EAC82CA7396A68D541C85D26508E83_1754181884.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1754181884;
        // ---------- Original Method ----------
        //return new Object[s];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.027 -0400", hash_original_method = "EC077FF294E7BB24D59CB59A711685E2", hash_generated_method = "68B06FD3E11A78C4B041D1E1A67930FF")
    @SuppressWarnings("unchecked")
    private V massageValue(Object value) {
        V varB4EAC82CA7396A68D541C85D26508E83_1790998910 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1790998910 = (V) ((value == NULL_OBJECT) ? null : value);
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1790998910.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1790998910;
        // ---------- Original Method ----------
        //return (V) ((value == NULL_OBJECT) ? null : value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.032 -0400", hash_original_method = "BDCD76FD65816EABAE96959FB0B37C8A", hash_generated_method = "6CAA2609653D750C47F7C4BC910C2874")
    @Override
    public void clear() {
        size = 0;
        {
            int i;
            i = 0;
            {
                elementData[i] = null;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //size = 0;
        //for (int i = 0; i < elementData.length; i++) {
            //elementData[i] = null;
        //}
        //modCount++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.032 -0400", hash_original_method = "5096545BB8D7E235F81B2D74AA90BB35", hash_generated_method = "939E0EC8E48EC2A00D0B08B48629CDA8")
    @Override
    public boolean containsKey(Object key) {
        {
            key = NULL_OBJECT;
        } //End block
        int index;
        index = findIndex(key, elementData);
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2092590351 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2092590351;
        // ---------- Original Method ----------
        //if (key == null) {
            //key = NULL_OBJECT;
        //}
        //int index = findIndex(key, elementData);
        //return elementData[index] == key;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.033 -0400", hash_original_method = "182DC7E21BB3FA85F9FDDA653B5E53EC", hash_generated_method = "3FB5BC3A0BB2BDAC09C3CD6046BE922B")
    @Override
    public boolean containsValue(Object value) {
        {
            value = NULL_OBJECT;
        } //End block
        {
            int i;
            i = 1;
            i = i + 2;
        } //End collapsed parenthetic
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_969477043 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_969477043;
        // ---------- Original Method ----------
        //if (value == null) {
            //value = NULL_OBJECT;
        //}
        //for (int i = 1; i < elementData.length; i = i + 2) {
            //if (elementData[i] == value) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.038 -0400", hash_original_method = "F6964BC1AA97AC873AACFDCE0324626E", hash_generated_method = "37123ED06CF64B7D21126E507305DDF6")
    @Override
    public V get(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_1151485825 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_121588528 = null; //Variable for return #2
        {
            key = NULL_OBJECT;
        } //End block
        int index;
        index = findIndex(key, elementData);
        {
            Object result;
            result = elementData[index + 1];
            varB4EAC82CA7396A68D541C85D26508E83_1151485825 = massageValue(result);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_121588528 = null;
        addTaint(key.getTaint());
        V varA7E53CE21691AB073D9660D615818899_1221453096; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1221453096 = varB4EAC82CA7396A68D541C85D26508E83_1151485825;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1221453096 = varB4EAC82CA7396A68D541C85D26508E83_121588528;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1221453096.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1221453096;
        // ---------- Original Method ----------
        //if (key == null) {
            //key = NULL_OBJECT;
        //}
        //int index = findIndex(key, elementData);
        //if (elementData[index] == key) {
            //Object result = elementData[index + 1];
            //return massageValue(result);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.038 -0400", hash_original_method = "BBF7F36B48A0928E4E8AF0FBF2D6C2A4", hash_generated_method = "F429DE4A8990E39609CD0140DC22D100")
    private IdentityHashMapEntry<K, V> getEntry(Object key) {
        IdentityHashMapEntry<K, V> varB4EAC82CA7396A68D541C85D26508E83_234439172 = null; //Variable for return #1
        IdentityHashMapEntry<K, V> varB4EAC82CA7396A68D541C85D26508E83_698829399 = null; //Variable for return #2
        {
            key = NULL_OBJECT;
        } //End block
        int index;
        index = findIndex(key, elementData);
        {
            varB4EAC82CA7396A68D541C85D26508E83_234439172 = getEntry(index);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_698829399 = null;
        addTaint(key.getTaint());
        IdentityHashMapEntry<K, V> varA7E53CE21691AB073D9660D615818899_128346448; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_128346448 = varB4EAC82CA7396A68D541C85D26508E83_234439172;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_128346448 = varB4EAC82CA7396A68D541C85D26508E83_698829399;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_128346448.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_128346448;
        // ---------- Original Method ----------
        //if (key == null) {
            //key = NULL_OBJECT;
        //}
        //int index = findIndex(key, elementData);
        //if (elementData[index] == key) {
            //return getEntry(index);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.044 -0400", hash_original_method = "84E908F75D5C9D1CDED221D7011BB031", hash_generated_method = "381B20EDF0FC2857671FAC2D750D3420")
    @SuppressWarnings("unchecked")
    private IdentityHashMapEntry<K, V> getEntry(int index) {
        IdentityHashMapEntry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1190183922 = null; //Variable for return #1
        Object key;
        key = elementData[index];
        Object value;
        value = elementData[index + 1];
        {
            key = null;
        } //End block
        {
            value = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1190183922 = new IdentityHashMapEntry<K, V>(this, (K) key, (V) value);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1190183922.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1190183922;
        // ---------- Original Method ----------
        //Object key = elementData[index];
        //Object value = elementData[index + 1];
        //if (key == NULL_OBJECT) {
            //key = null;
        //}
        //if (value == NULL_OBJECT) {
            //value = null;
        //}
        //return new IdentityHashMapEntry<K, V>(this, (K) key, (V) value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.044 -0400", hash_original_method = "A3A8F03C1D1CA3BA128703E55ACFBE13", hash_generated_method = "5B367CC6C1D3FF71988ECBC5365AF2A2")
    private int findIndex(Object key, Object[] array) {
        int length;
        length = array.length;
        int index;
        index = getModuloHash(key, length);
        int last;
        last = (index + length - 2) % length;
        {
            index = (index + 2) % length;
        } //End block
        addTaint(key.getTaint());
        addTaint(array[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_855993811 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_855993811;
        // ---------- Original Method ----------
        //int length = array.length;
        //int index = getModuloHash(key, length);
        //int last = (index + length - 2) % length;
        //while (index != last) {
            //if (array[index] == key || (array[index] == null)) {
                //break;
            //}
            //index = (index + 2) % length;
        //}
        //return index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.046 -0400", hash_original_method = "5971E6E68410637276D03AFF9F1601B4", hash_generated_method = "12BD254DAF997CBACD4DF8A06372B4A3")
    private int getModuloHash(Object key, int length) {
        int var1955E354538F965E02CCD189A606FF50_1860711008 = (((System.identityHashCode(key) & 0x7FFFFFFF) % (length / 2)) * 2);
        addTaint(key.getTaint());
        addTaint(length);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_167102614 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_167102614;
        // ---------- Original Method ----------
        //return ((System.identityHashCode(key) & 0x7FFFFFFF) % (length / 2)) * 2;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.049 -0400", hash_original_method = "5FE57D2E7B335A053FA4B0E269FB9FA5", hash_generated_method = "0C49F8C725F1607CA9C438D8FA50ED89")
    @Override
    public V put(K key, V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_873999894 = null; //Variable for return #1
        Object _key;
        _key = key;
        Object _value;
        _value = value;
        {
            _key = NULL_OBJECT;
        } //End block
        {
            _value = NULL_OBJECT;
        } //End block
        int index;
        index = findIndex(_key, elementData);
        {
            {
                rehash();
                index = findIndex(_key, elementData);
            } //End block
            elementData[index] = _key;
            elementData[index + 1] = null;
        } //End block
        Object result;
        result = elementData[index + 1];
        elementData[index + 1] = _value;
        varB4EAC82CA7396A68D541C85D26508E83_873999894 = massageValue(result);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_873999894.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_873999894;
        // ---------- Original Method ----------
        //Object _key = key;
        //Object _value = value;
        //if (_key == null) {
            //_key = NULL_OBJECT;
        //}
        //if (_value == null) {
            //_value = NULL_OBJECT;
        //}
        //int index = findIndex(_key, elementData);
        //if (elementData[index] != _key) {
            //modCount++;
            //if (++size > threshold) {
                //rehash();
                //index = findIndex(_key, elementData);
            //}
            //elementData[index] = _key;
            //elementData[index + 1] = null;
        //}
        //Object result = elementData[index + 1];
        //elementData[index + 1] = _value;
        //return massageValue(result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.050 -0400", hash_original_method = "57B3987EA7E50826E0AAD0198F968E42", hash_generated_method = "43FD7CC93F90FFCD58209DA7AC6028FD")
    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        putAllImpl(map);
        addTaint(map.getTaint());
        // ---------- Original Method ----------
        //putAllImpl(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.057 -0400", hash_original_method = "DDE8094F149435C7DE287F5101860F65", hash_generated_method = "B51652A6AD17E4CCE0DE4FBFEEBCBC89")
    private void rehash() {
        int newlength;
        newlength = elementData.length * 2;
        {
            newlength = 1;
        } //End block
        Object[] newData;
        newData = newElementArray(newlength);
        {
            int i;
            i = 0;
            i = i + 2;
            {
                Object key;
                key = elementData[i];
                {
                    int index;
                    index = findIndex(key, newData);
                    newData[index] = key;
                    newData[index + 1] = elementData[i + 1];
                } //End block
            } //End block
        } //End collapsed parenthetic
        elementData = newData;
        computeMaxSize();
        // ---------- Original Method ----------
        //int newlength = elementData.length * 2;
        //if (newlength == 0) {
            //newlength = 1;
        //}
        //Object[] newData = newElementArray(newlength);
        //for (int i = 0; i < elementData.length; i = i + 2) {
            //Object key = elementData[i];
            //if (key != null) {
                //int index = findIndex(key, newData);
                //newData[index] = key;
                //newData[index + 1] = elementData[i + 1];
            //}
        //}
        //elementData = newData;
        //computeMaxSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.058 -0400", hash_original_method = "89E1F2A524C9BAC235F25992FD1AF281", hash_generated_method = "3D7CA775847A3C80DA39F0E34AAE3ABF")
    private void computeMaxSize() {
        threshold = (int) ((long) (elementData.length / 2) * loadFactor / 10000);
        // ---------- Original Method ----------
        //threshold = (int) ((long) (elementData.length / 2) * loadFactor / 10000);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.061 -0400", hash_original_method = "5D1C6299BDD74A2A432086CB6E5E8EB0", hash_generated_method = "B70E642607B3E6C45A8DDDF9E48ED4AA")
    @Override
    public V remove(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_1475209920 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_686495348 = null; //Variable for return #2
        {
            key = NULL_OBJECT;
        } //End block
        boolean hashedOk;
        int index, next, hash;
        Object result, object;
        index = next = findIndex(key, elementData);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1475209920 = null;
        } //End block
        result = elementData[index + 1];
        int length;
        length = elementData.length;
        {
            next = (next + 2) % length;
            object = elementData[next];
            hash = getModuloHash(object, length);
            hashedOk = hash > index;
            {
                hashedOk = hashedOk || (hash <= next);
            } //End block
            {
                hashedOk = hashedOk && (hash <= next);
            } //End block
            {
                elementData[index] = object;
                elementData[index + 1] = elementData[next + 1];
                index = next;
            } //End block
        } //End block
        elementData[index] = null;
        elementData[index + 1] = null;
        varB4EAC82CA7396A68D541C85D26508E83_686495348 = massageValue(result);
        addTaint(key.getTaint());
        V varA7E53CE21691AB073D9660D615818899_979308168; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_979308168 = varB4EAC82CA7396A68D541C85D26508E83_1475209920;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_979308168 = varB4EAC82CA7396A68D541C85D26508E83_686495348;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_979308168.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_979308168;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.061 -0400", hash_original_method = "426CBD32668C89F2F09688DDB7CBD67D", hash_generated_method = "5379AA6523C97FCF585B94B55A560405")
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_1418547811 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1418547811 = new IdentityHashMapEntrySet<K, V>(this);
        varB4EAC82CA7396A68D541C85D26508E83_1418547811.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1418547811;
        // ---------- Original Method ----------
        //return new IdentityHashMapEntrySet<K, V>(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.093 -0400", hash_original_method = "9E081198F867421B2EE1E810B189D8F9", hash_generated_method = "8F921927AD773C6EECC9825D098BBDFB")
    @Override
    public Set<K> keySet() {
        Set<K> varB4EAC82CA7396A68D541C85D26508E83_1426264772 = null; //Variable for return #1
        {
            keySet = new AbstractSet<K>() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.073 -0400", hash_original_method = "D170B4D54B17306878DDF90A529C04ED", hash_generated_method = "55BA816120C5FB115A4CC560ADA88233")
                @Override
                public boolean contains(Object object) {
                    boolean var5CF08BC5A8889C1E8B40FF0332AFAC24_1260800297 = (containsKey(object));
                    addTaint(object.getTaint());
                    boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_207268393 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_207268393;
                    // ---------- Original Method ----------
                    //return containsKey(object);
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.073 -0400", hash_original_method = "493FF83788BDD57678BE8EC76775D2EC", hash_generated_method = "F64C1914C5F3FE89C6D19729E924FB16")
                @Override
                public int size() {
                    int varBC51B28386FA67ED3E3F40218C89CFB9_1229496223 = (IdentityHashMap.this.size());
                    int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1106942167 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1106942167;
                    // ---------- Original Method ----------
                    //return IdentityHashMap.this.size();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.073 -0400", hash_original_method = "8EE7B74E95EF739684600DCE51B8E175", hash_generated_method = "8E7BC4B18C8D2D3FCEC28F8038114E81")
                @Override
                public void clear() {
                    IdentityHashMap.this.clear();
                    // ---------- Original Method ----------
                    //IdentityHashMap.this.clear();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.086 -0400", hash_original_method = "490547D1556DE6EF3FD9A72186FC3697", hash_generated_method = "6691E1AD80B16A47C06F8716CFF6E0DD")
                @Override
                public boolean remove(Object key) {
                    {
                        boolean varD4D10245FFFD9692A4F42EDF884E815E_1320195676 = (containsKey(key));
                        {
                            IdentityHashMap.this.remove(key);
                        } //End block
                    } //End collapsed parenthetic
                    addTaint(key.getTaint());
                    boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_92256714 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_92256714;
                    // ---------- Original Method ----------
                    //if (containsKey(key)) {
                        //IdentityHashMap.this.remove(key);
                        //return true;
                    //}
                    //return false;
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.093 -0400", hash_original_method = "723F8CF71A67441033B1836A0735513A", hash_generated_method = "CAEFD56CE09516327765138015CFAB4E")
                @Override
                public Iterator<K> iterator() {
                    Iterator<K> varB4EAC82CA7396A68D541C85D26508E83_2065919024 = null; //Variable for return #1
                    varB4EAC82CA7396A68D541C85D26508E83_2065919024 = new IdentityHashMapIterator<K, K, V>(
                            new MapEntry.Type<K, K, V>() {
                                public K get(MapEntry<K, V> entry) {
                                    return entry.key;
                                }
                            }, IdentityHashMap.this);
                    varB4EAC82CA7396A68D541C85D26508E83_2065919024.addTaint(getTaint()); //Add taint from parent
                    return varB4EAC82CA7396A68D541C85D26508E83_2065919024;
                    // ---------- Original Method ----------
                    //return new IdentityHashMapIterator<K, K, V>(
                            //new MapEntry.Type<K, K, V>() {
                                //public K get(MapEntry<K, V> entry) {
                                    //return entry.key;
                                //}
                            //}, IdentityHashMap.this);
                }
};
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1426264772 = keySet;
        varB4EAC82CA7396A68D541C85D26508E83_1426264772.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1426264772;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.105 -0400", hash_original_method = "C71140816AE220E4DE6F3C222B8E61B9", hash_generated_method = "58600D5D96C342FD41FFE12B7CC7D915")
    @Override
    public Collection<V> values() {
        Collection<V> varB4EAC82CA7396A68D541C85D26508E83_2048264482 = null; //Variable for return #1
        {
            valuesCollection = new AbstractCollection<V>() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.095 -0400", hash_original_method = "7679F4183F803D10EFCD1172E399C7C3", hash_generated_method = "0B8F096FC150E93D3BE09C112D0DA60A")
                @Override
                public boolean contains(Object object) {
                    boolean varF0370008E8B5928F4FAF5BBF8632C1B3_291575449 = (containsValue(object));
                    addTaint(object.getTaint());
                    boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1323139744 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1323139744;
                    // ---------- Original Method ----------
                    //return containsValue(object);
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.095 -0400", hash_original_method = "493FF83788BDD57678BE8EC76775D2EC", hash_generated_method = "616F247781DB112404C0A2AD53057790")
                @Override
                public int size() {
                    int varBC51B28386FA67ED3E3F40218C89CFB9_157629285 = (IdentityHashMap.this.size());
                    int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_514786403 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_514786403;
                    // ---------- Original Method ----------
                    //return IdentityHashMap.this.size();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.098 -0400", hash_original_method = "8EE7B74E95EF739684600DCE51B8E175", hash_generated_method = "8E7BC4B18C8D2D3FCEC28F8038114E81")
                @Override
                public void clear() {
                    IdentityHashMap.this.clear();
                    // ---------- Original Method ----------
                    //IdentityHashMap.this.clear();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.099 -0400", hash_original_method = "716DB1296581D00BED615692167CF55E", hash_generated_method = "4E3E27C771C119ED0D6C1F27DFA4A460")
                @Override
                public Iterator<V> iterator() {
                    Iterator<V> varB4EAC82CA7396A68D541C85D26508E83_1532617600 = null; //Variable for return #1
                    varB4EAC82CA7396A68D541C85D26508E83_1532617600 = new IdentityHashMapIterator<V, K, V>(
                            new MapEntry.Type<V, K, V>() {
                                public V get(MapEntry<K, V> entry) {
                                    return entry.value;
                                }
                            }, IdentityHashMap.this);
                    varB4EAC82CA7396A68D541C85D26508E83_1532617600.addTaint(getTaint()); //Add taint from parent
                    return varB4EAC82CA7396A68D541C85D26508E83_1532617600;
                    // ---------- Original Method ----------
                    //return new IdentityHashMapIterator<V, K, V>(
                            //new MapEntry.Type<V, K, V>() {
                                //public V get(MapEntry<K, V> entry) {
                                    //return entry.value;
                                //}
                            //}, IdentityHashMap.this);
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.102 -0400", hash_original_method = "5ADE2469436E9C63C02002691A8A1FCC", hash_generated_method = "08795868DA75D27CEABD07D05604C0AA")
                @Override
                public boolean remove(Object object) {
                    Iterator<?> it;
                    it = iterator();
                    {
                        boolean var4CA2EDBF7D27138D75E73CCD01CCB025_1605291498 = (it.hasNext());
                        {
                            {
                                boolean var130391727764061DB0EB2373925D07D9_1387078578 = (object == it.next());
                                {
                                    it.remove();
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                    addTaint(object.getTaint());
                    boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_988321176 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_988321176;
                    // ---------- Original Method ----------
                    //Iterator<?> it = iterator();
                    //while (it.hasNext()) {
                        //if (object == it.next()) {
                            //it.remove();
                            //return true;
                        //}
                    //}
                    //return false;
                }
};
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2048264482 = valuesCollection;
        varB4EAC82CA7396A68D541C85D26508E83_2048264482.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2048264482;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.111 -0400", hash_original_method = "84B9E6027D2FCCE6A1B5E4707316E9F7", hash_generated_method = "13619F94514FD34BDDD609005F46A99B")
    @Override
    public boolean equals(Object object) {
        {
            Map<?, ?> map;
            map = (Map) object;
            {
                boolean var17E93156AEDB9EC4C0BE0F9FC6995057_1053183925 = (size() != map.size());
            } //End collapsed parenthetic
            Set<Map.Entry<K, V>> set;
            set = entrySet();
            boolean var5B7F63BD128FBBEA15DCBF7B0F66F062_364043521 = (set.equals(map.entrySet()));
        } //End block
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1740519069 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1740519069;
        // ---------- Original Method ----------
        //if (this == object) {
            //return true;
        //}
        //if (object instanceof Map) {
            //Map<?, ?> map = (Map) object;
            //if (size() != map.size()) {
                //return false;
            //}
            //Set<Map.Entry<K, V>> set = entrySet();
            //return set.equals(map.entrySet());
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.112 -0400", hash_original_method = "593629377CF6402E72F5DC997FF5D0DD", hash_generated_method = "B9ED189BF297DF5280B9FA32BF215410")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1068792378 = null; //Variable for return #1
        try 
        {
            IdentityHashMap<K, V> cloneHashMap;
            cloneHashMap = (IdentityHashMap<K, V>) super.clone();
            cloneHashMap.elementData = newElementArray(elementData.length);
            System.arraycopy(elementData, 0, cloneHashMap.elementData, 0, elementData.length);
            varB4EAC82CA7396A68D541C85D26508E83_1068792378 = cloneHashMap;
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1068792378.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1068792378;
        // ---------- Original Method ----------
        //try {
            //IdentityHashMap<K, V> cloneHashMap = (IdentityHashMap<K, V>) super.clone();
            //cloneHashMap.elementData = newElementArray(elementData.length);
            //System.arraycopy(elementData, 0, cloneHashMap.elementData, 0, elementData.length);
            //return cloneHashMap;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.112 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "DDA996E9A710C62985EBD019CEE19A00")
    @Override
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1120238050 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1120238050;
        // ---------- Original Method ----------
        //return size == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.113 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "B181C577BC44A0EEB40E22381A80B2F5")
    @Override
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1523465333 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1523465333;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.113 -0400", hash_original_method = "8BD2A28D5C70743AFDE70AFCF38381D1", hash_generated_method = "A140733980CC30AC0AEDF32686EA6389")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(size);
        Iterator<?> iterator;
        iterator = entrySet().iterator();
        {
            boolean var15F7FE2AD7E10C613CA4B915023EF041_1764242541 = (iterator.hasNext());
            {
                MapEntry<?, ?> entry;
                entry = (MapEntry) iterator.next();
                stream.writeObject(entry.key);
                stream.writeObject(entry.value);
            } //End block
        } //End collapsed parenthetic
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        //stream.defaultWriteObject();
        //stream.writeInt(size);
        //Iterator<?> iterator = entrySet().iterator();
        //while (iterator.hasNext()) {
            //MapEntry<?, ?> entry = (MapEntry) iterator.next();
            //stream.writeObject(entry.key);
            //stream.writeObject(entry.value);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.114 -0400", hash_original_method = "7467D6AC226ECB31B060088968C9C4EC", hash_generated_method = "BE467148DCE34608C1F96705FF851469")
    @SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        stream.defaultReadObject();
        int savedSize;
        savedSize = stream.readInt();
        threshold = getThreshold(DEFAULT_MAX_SIZE);
        elementData = newElementArray(computeElementArraySize());
        {
            int i;
            i = savedSize;
            {
                K key;
                key = (K) stream.readObject();
                put(key, (V) stream.readObject());
            } //End block
        } //End collapsed parenthetic
        size = savedSize;
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        //stream.defaultReadObject();
        //int savedSize = stream.readInt();
        //threshold = getThreshold(DEFAULT_MAX_SIZE);
        //elementData = newElementArray(computeElementArraySize());
        //for (int i = savedSize; --i >= 0;) {
            //K key = (K) stream.readObject();
            //put(key, (V) stream.readObject());
        //}
        //size = savedSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.114 -0400", hash_original_method = "F23833AECC848C129604A1D671C10BB2", hash_generated_method = "E1AB933A1BFC60FBE7DDF357A0638FB3")
    private void putAllImpl(Map<? extends K, ? extends V> map) {
        {
            boolean var6889E31DD8EB0136BAB9D60DD7EEE838_157092071 = (map.entrySet() != null);
            {
                super.putAll(map);
            } //End block
        } //End collapsed parenthetic
        addTaint(map.getTaint());
        // ---------- Original Method ----------
        //if (map.entrySet() != null) {
            //super.putAll(map);
        //}
    }

    
    static class IdentityHashMapEntry<K, V> extends MapEntry<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.114 -0400", hash_original_field = "1D78DC8ED51214E518B5114FE24490AE", hash_generated_field = "3D88558CB5032F1BD977664E1B57DEDB")

        private IdentityHashMap<K,V> map;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.115 -0400", hash_original_method = "45D4C8262B140EBFC37DC125C8AC9505", hash_generated_method = "D274449496C16FE0BBB0F55539584098")
          IdentityHashMapEntry(IdentityHashMap<K,V> map, K theKey, V theValue) {
            super(theKey, theValue);
            this.map = map;
            addTaint(theKey.getTaint());
            addTaint(theValue.getTaint());
            // ---------- Original Method ----------
            //this.map = map;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.116 -0400", hash_original_method = "323EA29B58059AEF6BA9ED0328A60A9B", hash_generated_method = "A9064C5E26542D807D258D26C484BCCE")
        @Override
        public Object clone() {
            Object varB4EAC82CA7396A68D541C85D26508E83_1441082421 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1441082421 = super.clone();
            varB4EAC82CA7396A68D541C85D26508E83_1441082421.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1441082421;
            // ---------- Original Method ----------
            //return super.clone();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.126 -0400", hash_original_method = "BEBDBC589EC917AC9D19EF3668A7491A", hash_generated_method = "B07A7A62677E8F8306D943BA37F4DF0B")
        @Override
        public boolean equals(Object object) {
            {
                Map.Entry<?, ?> entry;
                entry = (Map.Entry) object;
                boolean var2CF4DA5B248B71F8723C2CFF4C38CCCF_2115633418 = ((key == entry.getKey()) && (value == entry.getValue()));
            } //End block
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_101006992 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_101006992;
            // ---------- Original Method ----------
            //if (this == object) {
                //return true;
            //}
            //if (object instanceof Map.Entry) {
                //Map.Entry<?, ?> entry = (Map.Entry) object;
                //return (key == entry.getKey()) && (value == entry.getValue());
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.126 -0400", hash_original_method = "6C06106E191A8CD852E6C421EE7C4BCA", hash_generated_method = "AAAF647ECA763C5FDF6E9FBDAA664E99")
        @Override
        public int hashCode() {
            int var1F8EEF3049B8A3F70256231F65F00B6F_692126529 = (System.identityHashCode(key)
                    ^ System.identityHashCode(value));
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1348070556 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1348070556;
            // ---------- Original Method ----------
            //return System.identityHashCode(key)
                    //^ System.identityHashCode(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.127 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "1CF352C59B373F3CF17196EA2EB93588")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_899791453 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_899791453 = key + "=" + value;
            varB4EAC82CA7396A68D541C85D26508E83_899791453.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_899791453;
            // ---------- Original Method ----------
            //return key + "=" + value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.134 -0400", hash_original_method = "3AB767B3337A96E3FF8E7E50DD61C26B", hash_generated_method = "85EF735356E3E84252547934392FEB28")
        @Override
        public V setValue(V object) {
            V varB4EAC82CA7396A68D541C85D26508E83_186266418 = null; //Variable for return #1
            V result;
            result = super.setValue(object);
            map.put(key, object);
            varB4EAC82CA7396A68D541C85D26508E83_186266418 = result;
            addTaint(object.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_186266418.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_186266418;
            // ---------- Original Method ----------
            //V result = super.setValue(object);
            //map.put(key, object);
            //return result;
        }

        
    }


    
    static class IdentityHashMapIterator<E, KT, VT> implements Iterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.134 -0400", hash_original_field = "64F8FBF9ECD410CCCCA37B900774D128", hash_generated_field = "6E2A691F6D792F742C26DA32023216AB")

        private int position = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.134 -0400", hash_original_field = "6F04CE4FBA27D4E32176E1FA260C7944", hash_generated_field = "158350FDC3EB690937A7433CD8FDCF25")

        private int lastPosition = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.134 -0400", hash_original_field = "17596D9B1BA2E6C64969EEC939BA98FD", hash_generated_field = "4A3F446F089E073EC39F9EFCA5E0A875")

        IdentityHashMap<KT, VT> associatedMap;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.135 -0400", hash_original_field = "295CC8887E8B8B43596FF881B307867C", hash_generated_field = "92DA548A98D3BA977C330B914F0C29E7")

        int expectedModCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.135 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "32CBE0E3CB6327A7B40B9B82E058EE9D")

        MapEntry.Type<E, KT, VT> type;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.135 -0400", hash_original_field = "95B5EA53A559DF3C9FB473B486E592C4", hash_generated_field = "89B380148E5E88610AC53F02DD8177BF")

        boolean canRemove = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.135 -0400", hash_original_method = "BFDED7A7210C6DD0D7CDC5258204AA4E", hash_generated_method = "4210FC6D81640DF85E6C94C89696CA19")
          IdentityHashMapIterator(MapEntry.Type<E, KT, VT> value,
                IdentityHashMap<KT, VT> hm) {
            associatedMap = hm;
            type = value;
            expectedModCount = hm.modCount;
            // ---------- Original Method ----------
            //associatedMap = hm;
            //type = value;
            //expectedModCount = hm.modCount;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.135 -0400", hash_original_method = "B784A2EBEA8DE50E57B347BC65196B23", hash_generated_method = "2EF49F990EBC6EE4616CF53056CA7173")
        public boolean hasNext() {
            {
                {
                    position += 2;
                } //End block
            } //End block
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_265574860 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_265574860;
            // ---------- Original Method ----------
            //while (position < associatedMap.elementData.length) {
                //if (associatedMap.elementData[position] == null) {
                    //position += 2;
                //} else {
                    //return true;
                //}
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.136 -0400", hash_original_method = "7D8E1D2F4CAE7D5905092B32E8FA958D", hash_generated_method = "20EB64A4FD391708937242ACB32D2E32")
         void checkConcurrentMod() throws ConcurrentModificationException {
            {
                if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            } //End block
            // ---------- Original Method ----------
            //if (expectedModCount != associatedMap.modCount) {
                //throw new ConcurrentModificationException();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.136 -0400", hash_original_method = "3CE3A2DA18ED93620446BB239F9F4A5B", hash_generated_method = "546BC32FC23E2A92E76C5A8FCADFE730")
        public E next() {
            E varB4EAC82CA7396A68D541C85D26508E83_1856615696 = null; //Variable for return #1
            checkConcurrentMod();
            {
                boolean var61E0EA93C8F2038A69462393E2D5DF33_1550255020 = (!hasNext());
                {
                    if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                } //End block
            } //End collapsed parenthetic
            IdentityHashMapEntry<KT, VT> result;
            result = associatedMap
                    .getEntry(position);
            lastPosition = position;
            position += 2;
            canRemove = true;
            varB4EAC82CA7396A68D541C85D26508E83_1856615696 = type.get(result);
            varB4EAC82CA7396A68D541C85D26508E83_1856615696.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1856615696;
            // ---------- Original Method ----------
            //checkConcurrentMod();
            //if (!hasNext()) {
                //throw new NoSuchElementException();
            //}
            //IdentityHashMapEntry<KT, VT> result = associatedMap
                    //.getEntry(position);
            //lastPosition = position;
            //position += 2;
            //canRemove = true;
            //return type.get(result);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.137 -0400", hash_original_method = "32BCAC2DF7A999AB0ADCB0B00908AC85", hash_generated_method = "CDFCFF766F31D79BCE6150409EA27389")
        public void remove() {
            checkConcurrentMod();
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            } //End block
            canRemove = false;
            associatedMap.remove(associatedMap.elementData[lastPosition]);
            position = lastPosition;
            // ---------- Original Method ----------
            //checkConcurrentMod();
            //if (!canRemove) {
                //throw new IllegalStateException();
            //}
            //canRemove = false;
            //associatedMap.remove(associatedMap.elementData[lastPosition]);
            //position = lastPosition;
            //expectedModCount++;
        }

        
    }


    
    static class IdentityHashMapEntrySet<KT, VT> extends AbstractSet<Map.Entry<KT, VT>> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.137 -0400", hash_original_field = "17596D9B1BA2E6C64969EEC939BA98FD", hash_generated_field = "031CFCCC69F39569E94AA635C28967A7")

        private IdentityHashMap<KT, VT> associatedMap;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.138 -0400", hash_original_method = "644AC8197CA2ECBB03BB45257D811561", hash_generated_method = "4EC3D979DE6973C429F81EC0B65DF241")
        public  IdentityHashMapEntrySet(IdentityHashMap<KT, VT> hm) {
            associatedMap = hm;
            // ---------- Original Method ----------
            //associatedMap = hm;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.138 -0400", hash_original_method = "DF0712385DAC2839FE08C1A7B2E52EB0", hash_generated_method = "E61743B4CD758DF406B67A45E6BD1AE4")
         IdentityHashMap<KT, VT> hashMap() {
            IdentityHashMap<KT, VT> varB4EAC82CA7396A68D541C85D26508E83_51060978 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_51060978 = associatedMap;
            varB4EAC82CA7396A68D541C85D26508E83_51060978.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_51060978;
            // ---------- Original Method ----------
            //return associatedMap;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.138 -0400", hash_original_method = "738E45D9F25B44D082CFB9E446EECBFE", hash_generated_method = "B0152521C9BACE9EA9C66E1A65AD6D3C")
        @Override
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_103540801 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_103540801;
            // ---------- Original Method ----------
            //return associatedMap.size;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.139 -0400", hash_original_method = "B5D899CE1CEF925AE089B354CDA8F2E9", hash_generated_method = "13758FD8D23019A75770695ACA1B98B9")
        @Override
        public void clear() {
            associatedMap.clear();
            // ---------- Original Method ----------
            //associatedMap.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.139 -0400", hash_original_method = "BC07645C8C1B001BABAC9BE4665F3CB5", hash_generated_method = "6A425BFE7EF47C400FE9A6FD27D218F5")
        @Override
        public boolean remove(Object object) {
            {
                boolean var4F9267015FE86EBB3F33114954B93ED1_936207138 = (contains(object));
                {
                    associatedMap.remove(((Map.Entry) object).getKey());
                } //End block
            } //End collapsed parenthetic
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_458029150 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_458029150;
            // ---------- Original Method ----------
            //if (contains(object)) {
                //associatedMap.remove(((Map.Entry) object).getKey());
                //return true;
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.139 -0400", hash_original_method = "C92543981F7A1AD01DCA60A82EA89AF9", hash_generated_method = "104FDA06227DE2B581114AE4EB2304B7")
        @Override
        public boolean contains(Object object) {
            {
                IdentityHashMapEntry<?, ?> entry;
                entry = associatedMap
                        .getEntry(((Map.Entry) object).getKey());
                boolean varD0E98BB343F5BCF087AF8810D205B9B8_272921128 = (entry != null && entry.equals(object));
            } //End block
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1147627517 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1147627517;
            // ---------- Original Method ----------
            //if (object instanceof Map.Entry) {
                //IdentityHashMapEntry<?, ?> entry = associatedMap
                        //.getEntry(((Map.Entry) object).getKey());
                //return entry != null && entry.equals(object);
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.140 -0400", hash_original_method = "4BC212BC4A955648ACAE505982F2CF30", hash_generated_method = "416D50E093271960B45531F5DC7E3DAD")
        @Override
        public Iterator<Map.Entry<KT, VT>> iterator() {
            Iterator<Map.Entry<KT, VT>> varB4EAC82CA7396A68D541C85D26508E83_257756313 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_257756313 = new IdentityHashMapIterator<Map.Entry<KT, VT>, KT, VT>(
                    new MapEntry.Type<Map.Entry<KT, VT>, KT, VT>() {
                        public Map.Entry<KT, VT> get(MapEntry<KT, VT> entry) {
                            return entry;
                        }
                    }, associatedMap);
            varB4EAC82CA7396A68D541C85D26508E83_257756313.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_257756313;
            // ---------- Original Method ----------
            //return new IdentityHashMapIterator<Map.Entry<KT, VT>, KT, VT>(
                    //new MapEntry.Type<Map.Entry<KT, VT>, KT, VT>() {
                        //public Map.Entry<KT, VT> get(MapEntry<KT, VT> entry) {
                            //return entry;
                        //}
                    //}, associatedMap);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.140 -0400", hash_original_field = "2250BF2C5D45E9A4DA80E533ECA51561", hash_generated_field = "B6DD30064667DCF5DF4B088F4F44A77D")

    private static long serialVersionUID = 8188218128353913216L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.140 -0400", hash_original_field = "0D907AB13CC38C0C0C4D64DC62CBEF87", hash_generated_field = "F90B0509FD3BE8CC2B8344E80529FF32")

    private static int DEFAULT_MAX_SIZE = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.140 -0400", hash_original_field = "B2BD8AE5E74B9F87BAC3865215923A2E", hash_generated_field = "BED983D2086F6C9BBF9A97829A31A009")

    private static int loadFactor = 7500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.140 -0400", hash_original_field = "A910395C962F6CB32B28C4B279BACC18", hash_generated_field = "7C874A5FE63091D0EE665FCC48F05F00")

    private static Object NULL_OBJECT = new Object();
}

