package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public abstract class AbstractMap<K, V> implements Map<K, V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.380 -0400", hash_original_field = "3E8ABCE844B6A8A95397486A3899B536", hash_generated_field = "8E2B51CCF89ADF7243D25312F0ABCDAC")

    Set<K> keySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.381 -0400", hash_original_field = "8169AE04F2776F041E9D71005E918170", hash_generated_field = "BE71573A2BD5F9F8A42171B5E82953DE")

    Collection<V> valuesCollection;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.381 -0400", hash_original_method = "38C8E9EBD98120A2B6A13CBC6F342ADF", hash_generated_method = "BA1BD3AE70CC5BFD1550DE98F5395666")
    protected  AbstractMap() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.382 -0400", hash_original_method = "76EEE079F2D9B88A31C5F2E8E9C7EB92", hash_generated_method = "D04492222E27A17B4DBF52591A0F49E1")
    public void clear() {
        entrySet().clear();
        // ---------- Original Method ----------
        //entrySet().clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.387 -0400", hash_original_method = "3D741B03C8862C52B96D9B3B81701BE0", hash_generated_method = "FB8FB8B9AD4D257617165F6C772BB53F")
    public boolean containsKey(Object key) {
        Iterator<Map.Entry<K, V>> it;
        it = entrySet().iterator();
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_896561049 = (it.hasNext());
                {
                    {
                        boolean var336751FB500C73D2E78ACA4F990236DD_183107426 = (key.equals(it.next().getKey()));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_2141935348 = (it.hasNext());
                {
                    {
                        boolean varF8E9FE1C2FF7A3716E9DE49769E3ED8E_1975983339 = (it.next().getKey() == null);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2086221367 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2086221367;
        // ---------- Original Method ----------
        //Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        //if (key != null) {
            //while (it.hasNext()) {
                //if (key.equals(it.next().getKey())) {
                    //return true;
                //}
            //}
        //} else {
            //while (it.hasNext()) {
                //if (it.next().getKey() == null) {
                    //return true;
                //}
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.387 -0400", hash_original_method = "D1C1AD8AFDB44AE56F4D2DF37F057E9D", hash_generated_method = "1FF00A6FA850952323E918FEF6C17CA4")
    public boolean containsValue(Object value) {
        Iterator<Map.Entry<K, V>> it;
        it = entrySet().iterator();
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_780887365 = (it.hasNext());
                {
                    {
                        boolean var2840902430CC9CE595E44E3BC99DC210_657322922 = (value.equals(it.next().getValue()));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1327842191 = (it.hasNext());
                {
                    {
                        boolean var447D2FB852C22F3FC7BB27E177199524_1831025940 = (it.next().getValue() == null);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_517668617 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_517668617;
        // ---------- Original Method ----------
        //Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        //if (value != null) {
            //while (it.hasNext()) {
                //if (value.equals(it.next().getValue())) {
                    //return true;
                //}
            //}
        //} else {
            //while (it.hasNext()) {
                //if (it.next().getValue() == null) {
                    //return true;
                //}
            //}
        //}
        //return false;
    }

    
    public abstract Set<Map.Entry<K, V>> entrySet();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.431 -0400", hash_original_method = "5B9317AAB202C2AFA6ECB99B62EB1150", hash_generated_method = "F7A106F17294DCAFAF5C106B683FEAED")
    @Override
    public boolean equals(Object object) {
        {
            Map<?, ?> map;
            map = (Map<?, ?>) object;
            {
                boolean var17E93156AEDB9EC4C0BE0F9FC6995057_1043920260 = (size() != map.size());
            } //End collapsed parenthetic
            try 
            {
                {
                    Iterator<Entry<K, V>> var3C9398D697CD538C1DB9788B7EB77AE6_956266904 = (entrySet()).iterator();
                    var3C9398D697CD538C1DB9788B7EB77AE6_956266904.hasNext();
                    Entry<K, V> entry = var3C9398D697CD538C1DB9788B7EB77AE6_956266904.next();
                    {
                        K key;
                        key = entry.getKey();
                        V mine;
                        mine = entry.getValue();
                        Object theirs;
                        theirs = map.get(key);
                        {
                            {
                                boolean varE9FDF34CB553A188B1AB044FFF7E6F9B_1109450746 = (theirs != null || !map.containsKey(key));
                            } //End collapsed parenthetic
                        } //End block
                        {
                            boolean varFC1E0BD092353CAAE827D7D85269DF68_2107263587 = (!mine.equals(theirs));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            catch (NullPointerException ignored)
            { }
            catch (ClassCastException ignored)
            { }
        } //End block
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_345956296 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_345956296;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.437 -0400", hash_original_method = "80DED5B1493F4175A64A94324F6ABF01", hash_generated_method = "A78DEAA82DD0073F21AB0B8964123C3A")
    public V get(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_451111522 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_1659800418 = null; //Variable for return #2
        V varB4EAC82CA7396A68D541C85D26508E83_1209469736 = null; //Variable for return #3
        Iterator<Map.Entry<K, V>> it;
        it = entrySet().iterator();
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_369296046 = (it.hasNext());
                {
                    Map.Entry<K, V> entry;
                    entry = it.next();
                    {
                        boolean varF16E55D9A798E58C2D063C16A4BD00B9_1732477498 = (key.equals(entry.getKey()));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_451111522 = entry.getValue();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1945386190 = (it.hasNext());
                {
                    Map.Entry<K, V> entry;
                    entry = it.next();
                    {
                        boolean varAAAB7182D9FFD9762DBAE32CE15E7BF0_526388783 = (entry.getKey() == null);
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1659800418 = entry.getValue();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1209469736 = null;
        addTaint(key.getTaint());
        V varA7E53CE21691AB073D9660D615818899_1443574504; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1443574504 = varB4EAC82CA7396A68D541C85D26508E83_451111522;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1443574504 = varB4EAC82CA7396A68D541C85D26508E83_1659800418;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1443574504 = varB4EAC82CA7396A68D541C85D26508E83_1209469736;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1443574504.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1443574504;
        // ---------- Original Method ----------
        //Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        //if (key != null) {
            //while (it.hasNext()) {
                //Map.Entry<K, V> entry = it.next();
                //if (key.equals(entry.getKey())) {
                    //return entry.getValue();
                //}
            //}
        //} else {
            //while (it.hasNext()) {
                //Map.Entry<K, V> entry = it.next();
                //if (entry.getKey() == null) {
                    //return entry.getValue();
                //}
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.437 -0400", hash_original_method = "64FA0B5ACB2A736D0354FE373D9CD3E5", hash_generated_method = "4C59DFC491443B1BCAB127D2C20E9B2F")
    @Override
    public int hashCode() {
        int result;
        result = 0;
        Iterator<Map.Entry<K, V>> it;
        it = entrySet().iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1592287731 = (it.hasNext());
            {
                result += it.next().hashCode();
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_490081457 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_490081457;
        // ---------- Original Method ----------
        //int result = 0;
        //Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        //while (it.hasNext()) {
            //result += it.next().hashCode();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.439 -0400", hash_original_method = "296240B68F4A866C698190CF33710ED8", hash_generated_method = "E112185EA910D419916C1E0CCFD96C60")
    public boolean isEmpty() {
        boolean var5E7C4FBBEC9A5754B20CB85881048CD5_1960413800 = (size() == 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_439263238 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_439263238;
        // ---------- Original Method ----------
        //return size() == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.450 -0400", hash_original_method = "F40A232B51CF144805B23E3A97CCF7A5", hash_generated_method = "55C598F51A2E5068DB3BB89B87B684AF")
    public Set<K> keySet() {
        Set<K> varB4EAC82CA7396A68D541C85D26508E83_1108411236 = null; //Variable for return #1
        {
            keySet = new AbstractSet<K>() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.445 -0400", hash_original_method = "D170B4D54B17306878DDF90A529C04ED", hash_generated_method = "23A87E81E784306E505D5B52C80D4C89")
                @Override
                public boolean contains(Object object) {
                    boolean var5CF08BC5A8889C1E8B40FF0332AFAC24_1613221534 = (containsKey(object));
                    addTaint(object.getTaint());
                    boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_698389095 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_698389095;
                    // ---------- Original Method ----------
                    //return containsKey(object);
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.445 -0400", hash_original_method = "3B94EB65D5DE623B3E08A5638A43D0EB", hash_generated_method = "B225C9F89DD2C083E10B88796FB4DA19")
                @Override
                public int size() {
                    int varFC76DB1BDD141E3C83EACBE167CD5D2A_590962726 = (AbstractMap.this.size());
                    int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_724668248 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_724668248;
                    // ---------- Original Method ----------
                    //return AbstractMap.this.size();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.449 -0400", hash_original_method = "4DAF499E5ADBF0012E8FC0F4014839E7", hash_generated_method = "A5B0D5F43D85DFB272BF2AB948D1CFB8")
                @Override
                public Iterator<K> iterator() {
                    Iterator<K> varB4EAC82CA7396A68D541C85D26508E83_1723885812 = null; //Variable for return #1
                    varB4EAC82CA7396A68D541C85D26508E83_1723885812 = new Iterator<K>() {
                        Iterator<Map.Entry<K, V>> setIterator = entrySet().iterator();
                        public boolean hasNext() {
                            return setIterator.hasNext();
                        }
                        public K next() {
                            return setIterator.next().getKey();
                        }
                        public void remove() {
                            setIterator.remove();
                        }
                    };
                    varB4EAC82CA7396A68D541C85D26508E83_1723885812.addTaint(getTaint()); //Add taint from parent
                    return varB4EAC82CA7396A68D541C85D26508E83_1723885812;
                    // ---------- Original Method ----------
                    //return new Iterator<K>() {
                        //Iterator<Map.Entry<K, V>> setIterator = entrySet().iterator();
                        //public boolean hasNext() {
                            //return setIterator.hasNext();
                        //}
                        //public K next() {
                            //return setIterator.next().getKey();
                        //}
                        //public void remove() {
                            //setIterator.remove();
                        //}
                    //};
                }
};
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1108411236 = keySet;
        varB4EAC82CA7396A68D541C85D26508E83_1108411236.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1108411236;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.450 -0400", hash_original_method = "1AE25A34BEB4A8F08F41373ADFFCFE34", hash_generated_method = "32D770B6587B989453B110A6DB3F9E94")
    public V put(K key, V value) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.460 -0400", hash_original_method = "1BF9761154AA89A664F00EA3C1B1A227", hash_generated_method = "D437120E0666C13A15D1097B265114E3")
    public void putAll(Map<? extends K, ? extends V> map) {
        {
            map.entrySet().iterator().hasNext();
            Map.Entry<? extends K, ? extends V> entry = map.entrySet().iterator().next();
            {
                put(entry.getKey(), entry.getValue());
            } //End block
        } //End collapsed parenthetic
        addTaint(map.getTaint());
        // ---------- Original Method ----------
        //for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            //put(entry.getKey(), entry.getValue());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.470 -0400", hash_original_method = "DF925EC53E8E5501C52A21B969B7A962", hash_generated_method = "5969A11B5B06EF23B5162277EA8A384B")
    public V remove(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_1610413458 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_1711255278 = null; //Variable for return #2
        V varB4EAC82CA7396A68D541C85D26508E83_2069390084 = null; //Variable for return #3
        Iterator<Map.Entry<K, V>> it;
        it = entrySet().iterator();
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1155444987 = (it.hasNext());
                {
                    Map.Entry<K, V> entry;
                    entry = it.next();
                    {
                        boolean varF16E55D9A798E58C2D063C16A4BD00B9_2106971988 = (key.equals(entry.getKey()));
                        {
                            it.remove();
                            varB4EAC82CA7396A68D541C85D26508E83_1610413458 = entry.getValue();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_2007026515 = (it.hasNext());
                {
                    Map.Entry<K, V> entry;
                    entry = it.next();
                    {
                        boolean varAAAB7182D9FFD9762DBAE32CE15E7BF0_292994087 = (entry.getKey() == null);
                        {
                            it.remove();
                            varB4EAC82CA7396A68D541C85D26508E83_1711255278 = entry.getValue();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2069390084 = null;
        addTaint(key.getTaint());
        V varA7E53CE21691AB073D9660D615818899_788040729; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_788040729 = varB4EAC82CA7396A68D541C85D26508E83_1610413458;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_788040729 = varB4EAC82CA7396A68D541C85D26508E83_1711255278;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_788040729 = varB4EAC82CA7396A68D541C85D26508E83_2069390084;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_788040729.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_788040729;
        // ---------- Original Method ----------
        //Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        //if (key != null) {
            //while (it.hasNext()) {
                //Map.Entry<K, V> entry = it.next();
                //if (key.equals(entry.getKey())) {
                    //it.remove();
                    //return entry.getValue();
                //}
            //}
        //} else {
            //while (it.hasNext()) {
                //Map.Entry<K, V> entry = it.next();
                //if (entry.getKey() == null) {
                    //it.remove();
                    //return entry.getValue();
                //}
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.470 -0400", hash_original_method = "68473A1BCB9C7CDFC9C6F1089F605F26", hash_generated_method = "361F24DD9E40F15FC1484D1B629B4E0E")
    public int size() {
        int var7F32C43E8079B6AEF852C4A760F273DE_1819464294 = (entrySet().size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_788359760 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_788359760;
        // ---------- Original Method ----------
        //return entrySet().size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.471 -0400", hash_original_method = "03506E32B26B17661064F3FFDE4F185F", hash_generated_method = "BDDD67B5B08F40DDD45231FC67CF3B04")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1182935954 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1744043864 = null; //Variable for return #2
        {
            boolean var8697D8FD88387502770F7E34BAFBCF5A_195424158 = (isEmpty());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1182935954 = "{}";
            } //End block
        } //End collapsed parenthetic
        StringBuilder buffer;
        buffer = new StringBuilder(size() * 28);
        buffer.append('{');
        Iterator<Map.Entry<K, V>> it;
        it = entrySet().iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1015210166 = (it.hasNext());
            {
                Map.Entry<K, V> entry;
                entry = it.next();
                Object key;
                key = entry.getKey();
                {
                    boolean var16D2B55F557CAD854A6DE05990C0A440_879087472 = (key != this);
                    {
                        buffer.append(key);
                    } //End block
                    {
                        buffer.append("(this Map)");
                    } //End block
                } //End collapsed parenthetic
                buffer.append('=');
                Object value;
                value = entry.getValue();
                {
                    boolean var821264377CC13EB114216A02538260EC_330120468 = (value != this);
                    {
                        buffer.append(value);
                    } //End block
                    {
                        buffer.append("(this Map)");
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_272140502 = (it.hasNext());
                    {
                        buffer.append(", ");
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        buffer.append('}');
        varB4EAC82CA7396A68D541C85D26508E83_1744043864 = buffer.toString();
        String varA7E53CE21691AB073D9660D615818899_1137724519; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1137724519 = varB4EAC82CA7396A68D541C85D26508E83_1182935954;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1137724519 = varB4EAC82CA7396A68D541C85D26508E83_1744043864;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1137724519.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1137724519;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.486 -0400", hash_original_method = "BE68DB72EA44A9864EFB8085A73DD13D", hash_generated_method = "CB2948D8DABA58D81971AAD98D5E872E")
    public Collection<V> values() {
        Collection<V> varB4EAC82CA7396A68D541C85D26508E83_1217666381 = null; //Variable for return #1
        {
            valuesCollection = new AbstractCollection<V>() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.474 -0400", hash_original_method = "3B94EB65D5DE623B3E08A5638A43D0EB", hash_generated_method = "5F6C5F5A6F0B255D040100E5AB3C4AE3")
                @Override
                public int size() {
                    int varFC76DB1BDD141E3C83EACBE167CD5D2A_1540597592 = (AbstractMap.this.size());
                    int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_967974876 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_967974876;
                    // ---------- Original Method ----------
                    //return AbstractMap.this.size();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.474 -0400", hash_original_method = "7679F4183F803D10EFCD1172E399C7C3", hash_generated_method = "9A9AAA23B829BBA391F895BBA0374286")
                @Override
                public boolean contains(Object object) {
                    boolean varF0370008E8B5928F4FAF5BBF8632C1B3_1973150618 = (containsValue(object));
                    addTaint(object.getTaint());
                    boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_966193034 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_966193034;
                    // ---------- Original Method ----------
                    //return containsValue(object);
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.486 -0400", hash_original_method = "22ABA9D926948DD0ED49A20C6509C8CB", hash_generated_method = "423A3EF1E8FDC3D8F02A75F9675272EC")
                @Override
                public Iterator<V> iterator() {
                    Iterator<V> varB4EAC82CA7396A68D541C85D26508E83_727695032 = null; //Variable for return #1
                    varB4EAC82CA7396A68D541C85D26508E83_727695032 = new Iterator<V>() {
                        Iterator<Map.Entry<K, V>> setIterator = entrySet().iterator();
                        public boolean hasNext() {
                            return setIterator.hasNext();
                        }
                        public V next() {
                            return setIterator.next().getValue();
                        }
                        public void remove() {
                            setIterator.remove();
                        }
                    };
                    varB4EAC82CA7396A68D541C85D26508E83_727695032.addTaint(getTaint()); //Add taint from parent
                    return varB4EAC82CA7396A68D541C85D26508E83_727695032;
                    // ---------- Original Method ----------
                    //return new Iterator<V>() {
                        //Iterator<Map.Entry<K, V>> setIterator = entrySet().iterator();
                        //public boolean hasNext() {
                            //return setIterator.hasNext();
                        //}
                        //public V next() {
                            //return setIterator.next().getValue();
                        //}
                        //public void remove() {
                            //setIterator.remove();
                        //}
                    //};
                }
};
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1217666381 = valuesCollection;
        varB4EAC82CA7396A68D541C85D26508E83_1217666381.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1217666381;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.488 -0400", hash_original_method = "DEDBEBF1A9DF717B6A61BCEAEE5EB8FF", hash_generated_method = "D41B4A26A6344349CD3C8DC6A11D6B05")
    @SuppressWarnings("unchecked")
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_87636390 = null; //Variable for return #1
        AbstractMap<K, V> result;
        result = (AbstractMap<K, V>) super.clone();
        result.keySet = null;
        result.valuesCollection = null;
        varB4EAC82CA7396A68D541C85D26508E83_87636390 = result;
        varB4EAC82CA7396A68D541C85D26508E83_87636390.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_87636390;
        // ---------- Original Method ----------
        //AbstractMap<K, V> result = (AbstractMap<K, V>) super.clone();
        //result.keySet = null;
        //result.valuesCollection = null;
        //return result;
    }

    
    public static class SimpleImmutableEntry<K, V> implements Map.Entry<K, V>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.488 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "EBAE1A8AD28B83F3F907DD83D8B82F01")

        private K key;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.488 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "EEA53383AEF96F58506DEE94A549CB01")

        private V value;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.488 -0400", hash_original_method = "33F8AD4AA392C56EA79ABB4A58A6836E", hash_generated_method = "1A26EA514829E31B02595112305C8058")
        public  SimpleImmutableEntry(K theKey, V theValue) {
            key = theKey;
            value = theValue;
            // ---------- Original Method ----------
            //key = theKey;
            //value = theValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.488 -0400", hash_original_method = "B328F2475798EE2AF89F33F6E7AEA482", hash_generated_method = "C6AD03E3758C4CD95B20142655BD5CD9")
        public  SimpleImmutableEntry(Map.Entry<? extends K, ? extends V> copyFrom) {
            key = copyFrom.getKey();
            value = copyFrom.getValue();
            // ---------- Original Method ----------
            //key = copyFrom.getKey();
            //value = copyFrom.getValue();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.494 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "B69EA4D4316FD4A0F7C063C31418C9C7")
        public K getKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_1121119631 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1121119631 = key;
            varB4EAC82CA7396A68D541C85D26508E83_1121119631.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1121119631;
            // ---------- Original Method ----------
            //return key;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.495 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "3BAF31E28D0668BE3DF02AEBC9A1EDD3")
        public V getValue() {
            V varB4EAC82CA7396A68D541C85D26508E83_1723948540 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1723948540 = value;
            varB4EAC82CA7396A68D541C85D26508E83_1723948540.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1723948540;
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.495 -0400", hash_original_method = "3526712C126765AF36CB8D920CBD3B1B", hash_generated_method = "353FCD816437638683D9FB782CBD2AF6")
        public V setValue(V object) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(object.getTaint());
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.496 -0400", hash_original_method = "5E665954E6171F76B6FD9130152FC1D9", hash_generated_method = "42E3C095A97F5BDE0FD945ADAA35D186")
        @Override
        public boolean equals(Object object) {
            {
                Map.Entry<?, ?> entry;
                entry = (Map.Entry<?, ?>) object;
                boolean var11197553A07BA849DF0822783F0D5152_353604376 = ((key == null ? entry.getKey() == null : key.equals(entry
                        .getKey()))
                        && (value == null ? entry.getValue() == null : value
                                .equals(entry.getValue()))); //DSFIXME:  CODE0008: Nested ternary operator in expression
            } //End block
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1570784873 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1570784873;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.496 -0400", hash_original_method = "6416487D313DFCFD3052C01ADB883217", hash_generated_method = "E24D351A1B004F8F80D78C76562A5879")
        @Override
        public int hashCode() {
            int var4B5981580A705D92ADA4BF72B6E1E3C5_74708354 = ((key == null ? 0 : key.hashCode())
                    ^ (value == null ? 0 : value.hashCode())); //DSFIXME:  CODE0008: Nested ternary operator in expression
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_664683903 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_664683903;
            // ---------- Original Method ----------
            //return (key == null ? 0 : key.hashCode())
                    //^ (value == null ? 0 : value.hashCode());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.497 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "E3F417726255763BD8D2444C5439FA9F")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_716355677 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_716355677 = key + "=" + value;
            varB4EAC82CA7396A68D541C85D26508E83_716355677.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_716355677;
            // ---------- Original Method ----------
            //return key + "=" + value;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.497 -0400", hash_original_field = "0FB41B94E91231F1583771B8C0C0C696", hash_generated_field = "03E66DCA96538DB895F88F39FB65BFF8")

        private static long serialVersionUID = 7138329143949025153L;
    }


    
    public static class SimpleEntry<K, V> implements Map.Entry<K, V>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.497 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "EBAE1A8AD28B83F3F907DD83D8B82F01")

        private K key;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.497 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "EEA53383AEF96F58506DEE94A549CB01")

        private V value;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.497 -0400", hash_original_method = "BD7301488126194D9FCD92EBDE27E89B", hash_generated_method = "6DD3ADB0E0C9AC93F8E4466B16A19993")
        public  SimpleEntry(K theKey, V theValue) {
            key = theKey;
            value = theValue;
            // ---------- Original Method ----------
            //key = theKey;
            //value = theValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.497 -0400", hash_original_method = "69734A3C3A679CA95ADF7DC846433DE1", hash_generated_method = "54A51761FD45C24B5F05A70D91586172")
        public  SimpleEntry(Map.Entry<? extends K, ? extends V> copyFrom) {
            key = copyFrom.getKey();
            value = copyFrom.getValue();
            // ---------- Original Method ----------
            //key = copyFrom.getKey();
            //value = copyFrom.getValue();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.512 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "FE4B2BAF35C242DD34F372AD2178C807")
        public K getKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_31970884 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_31970884 = key;
            varB4EAC82CA7396A68D541C85D26508E83_31970884.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_31970884;
            // ---------- Original Method ----------
            //return key;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.513 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "0BBD602A198F6CDDF9E798E75B1ED172")
        public V getValue() {
            V varB4EAC82CA7396A68D541C85D26508E83_1299473003 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1299473003 = value;
            varB4EAC82CA7396A68D541C85D26508E83_1299473003.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1299473003;
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.514 -0400", hash_original_method = "123DAF07FFBE76C8EE5BD5879EB92827", hash_generated_method = "A80D2BBD4E92D04E1FDAC14B624E9910")
        public V setValue(V object) {
            V varB4EAC82CA7396A68D541C85D26508E83_493280113 = null; //Variable for return #1
            V result;
            result = value;
            value = object;
            varB4EAC82CA7396A68D541C85D26508E83_493280113 = result;
            varB4EAC82CA7396A68D541C85D26508E83_493280113.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_493280113;
            // ---------- Original Method ----------
            //V result = value;
            //value = object;
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.514 -0400", hash_original_method = "5E665954E6171F76B6FD9130152FC1D9", hash_generated_method = "B85DB2A448EEEADA3F28BC0CAECB5E62")
        @Override
        public boolean equals(Object object) {
            {
                Map.Entry<?, ?> entry;
                entry = (Map.Entry<?, ?>) object;
                boolean var11197553A07BA849DF0822783F0D5152_772324706 = ((key == null ? entry.getKey() == null : key.equals(entry
                        .getKey()))
                        && (value == null ? entry.getValue() == null : value
                                .equals(entry.getValue()))); //DSFIXME:  CODE0008: Nested ternary operator in expression
            } //End block
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_88502914 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_88502914;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.515 -0400", hash_original_method = "6416487D313DFCFD3052C01ADB883217", hash_generated_method = "FBAC3815F7F71E2BC554693A7B509BEE")
        @Override
        public int hashCode() {
            int var4B5981580A705D92ADA4BF72B6E1E3C5_1760863785 = ((key == null ? 0 : key.hashCode())
                    ^ (value == null ? 0 : value.hashCode())); //DSFIXME:  CODE0008: Nested ternary operator in expression
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_627821092 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_627821092;
            // ---------- Original Method ----------
            //return (key == null ? 0 : key.hashCode())
                    //^ (value == null ? 0 : value.hashCode());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.515 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "B357A89ABD8630846B7BFD74053EB7F7")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1335504888 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1335504888 = key + "=" + value;
            varB4EAC82CA7396A68D541C85D26508E83_1335504888.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1335504888;
            // ---------- Original Method ----------
            //return key + "=" + value;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.515 -0400", hash_original_field = "6740671D10922D6DCB5AFF41C09E8C7B", hash_generated_field = "69D93EB2C7A6CA20863AB99BD1E97247")

        private static long serialVersionUID = -8499721149061103585L;
    }


    
}

