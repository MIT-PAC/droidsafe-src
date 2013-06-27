package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public abstract class AbstractMap<K, V> implements Map<K, V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.453 -0400", hash_original_field = "3E8ABCE844B6A8A95397486A3899B536", hash_generated_field = "8E2B51CCF89ADF7243D25312F0ABCDAC")

    Set<K> keySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.453 -0400", hash_original_field = "8169AE04F2776F041E9D71005E918170", hash_generated_field = "BE71573A2BD5F9F8A42171B5E82953DE")

    Collection<V> valuesCollection;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.453 -0400", hash_original_method = "38C8E9EBD98120A2B6A13CBC6F342ADF", hash_generated_method = "BA1BD3AE70CC5BFD1550DE98F5395666")
    protected  AbstractMap() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.470 -0400", hash_original_method = "76EEE079F2D9B88A31C5F2E8E9C7EB92", hash_generated_method = "D04492222E27A17B4DBF52591A0F49E1")
    public void clear() {
        entrySet().clear();
        // ---------- Original Method ----------
        //entrySet().clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.471 -0400", hash_original_method = "3D741B03C8862C52B96D9B3B81701BE0", hash_generated_method = "C90A63B4E4F47D9CC9E38A57BAA956CB")
    public boolean containsKey(Object key) {
        Iterator<Map.Entry<K, V>> it;
        it = entrySet().iterator();
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_537329279 = (it.hasNext());
                {
                    {
                        boolean var336751FB500C73D2E78ACA4F990236DD_705700895 = (key.equals(it.next().getKey()));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_677803138 = (it.hasNext());
                {
                    {
                        boolean varF8E9FE1C2FF7A3716E9DE49769E3ED8E_1865171574 = (it.next().getKey() == null);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1141266931 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1141266931;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.472 -0400", hash_original_method = "D1C1AD8AFDB44AE56F4D2DF37F057E9D", hash_generated_method = "C37A24BF9B09985F13EF190F98815567")
    public boolean containsValue(Object value) {
        Iterator<Map.Entry<K, V>> it;
        it = entrySet().iterator();
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_106655091 = (it.hasNext());
                {
                    {
                        boolean var2840902430CC9CE595E44E3BC99DC210_33904837 = (value.equals(it.next().getValue()));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_814799127 = (it.hasNext());
                {
                    {
                        boolean var447D2FB852C22F3FC7BB27E177199524_1720028354 = (it.next().getValue() == null);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_968272099 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_968272099;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.553 -0400", hash_original_method = "5B9317AAB202C2AFA6ECB99B62EB1150", hash_generated_method = "21FB06F47919FC24CBB25A0D390E97F5")
    @Override
    public boolean equals(Object object) {
        {
            Map<?, ?> map;
            map = (Map<?, ?>) object;
            {
                boolean var17E93156AEDB9EC4C0BE0F9FC6995057_519101189 = (size() != map.size());
            } //End collapsed parenthetic
            try 
            {
                {
                    Iterator<Entry<K, V>> var3C9398D697CD538C1DB9788B7EB77AE6_714438439 = (entrySet()).iterator();
                    var3C9398D697CD538C1DB9788B7EB77AE6_714438439.hasNext();
                    Entry<K, V> entry = var3C9398D697CD538C1DB9788B7EB77AE6_714438439.next();
                    {
                        K key;
                        key = entry.getKey();
                        V mine;
                        mine = entry.getValue();
                        Object theirs;
                        theirs = map.get(key);
                        {
                            {
                                boolean varE9FDF34CB553A188B1AB044FFF7E6F9B_1323913462 = (theirs != null || !map.containsKey(key));
                            } //End collapsed parenthetic
                        } //End block
                        {
                            boolean varFC1E0BD092353CAAE827D7D85269DF68_1940437044 = (!mine.equals(theirs));
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2029721211 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2029721211;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.562 -0400", hash_original_method = "80DED5B1493F4175A64A94324F6ABF01", hash_generated_method = "B79B8466590228841736A5347612D000")
    public V get(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_762403177 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_781843392 = null; //Variable for return #2
        V varB4EAC82CA7396A68D541C85D26508E83_1325328054 = null; //Variable for return #3
        Iterator<Map.Entry<K, V>> it;
        it = entrySet().iterator();
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_876597010 = (it.hasNext());
                {
                    Map.Entry<K, V> entry;
                    entry = it.next();
                    {
                        boolean varF16E55D9A798E58C2D063C16A4BD00B9_2073658989 = (key.equals(entry.getKey()));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_762403177 = entry.getValue();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1787930773 = (it.hasNext());
                {
                    Map.Entry<K, V> entry;
                    entry = it.next();
                    {
                        boolean varAAAB7182D9FFD9762DBAE32CE15E7BF0_1159986576 = (entry.getKey() == null);
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_781843392 = entry.getValue();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1325328054 = null;
        addTaint(key.getTaint());
        V varA7E53CE21691AB073D9660D615818899_1500349039; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1500349039 = varB4EAC82CA7396A68D541C85D26508E83_762403177;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1500349039 = varB4EAC82CA7396A68D541C85D26508E83_781843392;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1500349039 = varB4EAC82CA7396A68D541C85D26508E83_1325328054;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1500349039.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1500349039;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.569 -0400", hash_original_method = "64FA0B5ACB2A736D0354FE373D9CD3E5", hash_generated_method = "73874752B4B4BA85321DA191D99F34B2")
    @Override
    public int hashCode() {
        int result;
        result = 0;
        Iterator<Map.Entry<K, V>> it;
        it = entrySet().iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_535634889 = (it.hasNext());
            {
                result += it.next().hashCode();
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1345024045 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1345024045;
        // ---------- Original Method ----------
        //int result = 0;
        //Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        //while (it.hasNext()) {
            //result += it.next().hashCode();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.569 -0400", hash_original_method = "296240B68F4A866C698190CF33710ED8", hash_generated_method = "063838B8903CA8F614C959CE140EBFBB")
    public boolean isEmpty() {
        boolean var5E7C4FBBEC9A5754B20CB85881048CD5_1102022039 = (size() == 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1738974194 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1738974194;
        // ---------- Original Method ----------
        //return size() == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.571 -0400", hash_original_method = "F40A232B51CF144805B23E3A97CCF7A5", hash_generated_method = "89C1B6713456A718EBE5874ED2531C2C")
    public Set<K> keySet() {
        Set<K> varB4EAC82CA7396A68D541C85D26508E83_1194165257 = null; //Variable for return #1
        {
            keySet = new AbstractSet<K>() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.570 -0400", hash_original_method = "D170B4D54B17306878DDF90A529C04ED", hash_generated_method = "D8F7C8EF36EE40E2488565C14C4F40DB")
                @Override
                public boolean contains(Object object) {
                    boolean var5CF08BC5A8889C1E8B40FF0332AFAC24_190930823 = (containsKey(object));
                    addTaint(object.getTaint());
                    boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1543108713 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1543108713;
                    // ---------- Original Method ----------
                    //return containsKey(object);
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.570 -0400", hash_original_method = "3B94EB65D5DE623B3E08A5638A43D0EB", hash_generated_method = "E2FD4D53F2E1FC34EEFC317520E4636D")
                @Override
                public int size() {
                    int varFC76DB1BDD141E3C83EACBE167CD5D2A_1641760380 = (AbstractMap.this.size());
                    int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1880656255 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1880656255;
                    // ---------- Original Method ----------
                    //return AbstractMap.this.size();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.571 -0400", hash_original_method = "4DAF499E5ADBF0012E8FC0F4014839E7", hash_generated_method = "B5020D99F05286E51D3DFBB0EC73476C")
                @Override
                public Iterator<K> iterator() {
                    Iterator<K> varB4EAC82CA7396A68D541C85D26508E83_1642864152 = null; //Variable for return #1
                    varB4EAC82CA7396A68D541C85D26508E83_1642864152 = new Iterator<K>() {
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
                    varB4EAC82CA7396A68D541C85D26508E83_1642864152.addTaint(getTaint()); //Add taint from parent
                    return varB4EAC82CA7396A68D541C85D26508E83_1642864152;
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
        varB4EAC82CA7396A68D541C85D26508E83_1194165257 = keySet;
        varB4EAC82CA7396A68D541C85D26508E83_1194165257.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1194165257;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.572 -0400", hash_original_method = "1AE25A34BEB4A8F08F41373ADFFCFE34", hash_generated_method = "32D770B6587B989453B110A6DB3F9E94")
    public V put(K key, V value) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.593 -0400", hash_original_method = "1BF9761154AA89A664F00EA3C1B1A227", hash_generated_method = "D437120E0666C13A15D1097B265114E3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.594 -0400", hash_original_method = "DF925EC53E8E5501C52A21B969B7A962", hash_generated_method = "63479B8E6AA193CAB6AB30926DB2428F")
    public V remove(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_1969561575 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_756867937 = null; //Variable for return #2
        V varB4EAC82CA7396A68D541C85D26508E83_1707970201 = null; //Variable for return #3
        Iterator<Map.Entry<K, V>> it;
        it = entrySet().iterator();
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1070644226 = (it.hasNext());
                {
                    Map.Entry<K, V> entry;
                    entry = it.next();
                    {
                        boolean varF16E55D9A798E58C2D063C16A4BD00B9_1831827637 = (key.equals(entry.getKey()));
                        {
                            it.remove();
                            varB4EAC82CA7396A68D541C85D26508E83_1969561575 = entry.getValue();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_614861081 = (it.hasNext());
                {
                    Map.Entry<K, V> entry;
                    entry = it.next();
                    {
                        boolean varAAAB7182D9FFD9762DBAE32CE15E7BF0_245852626 = (entry.getKey() == null);
                        {
                            it.remove();
                            varB4EAC82CA7396A68D541C85D26508E83_756867937 = entry.getValue();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1707970201 = null;
        addTaint(key.getTaint());
        V varA7E53CE21691AB073D9660D615818899_1124770489; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1124770489 = varB4EAC82CA7396A68D541C85D26508E83_1969561575;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1124770489 = varB4EAC82CA7396A68D541C85D26508E83_756867937;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1124770489 = varB4EAC82CA7396A68D541C85D26508E83_1707970201;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1124770489.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1124770489;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.614 -0400", hash_original_method = "68473A1BCB9C7CDFC9C6F1089F605F26", hash_generated_method = "627A54A9C52DC89337F76A54DB642AC7")
    public int size() {
        int var7F32C43E8079B6AEF852C4A760F273DE_1658888256 = (entrySet().size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1037971376 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1037971376;
        // ---------- Original Method ----------
        //return entrySet().size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.615 -0400", hash_original_method = "03506E32B26B17661064F3FFDE4F185F", hash_generated_method = "8EBAD5F7F9C87EBBE75930304D49B8B2")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1886571884 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_468146480 = null; //Variable for return #2
        {
            boolean var8697D8FD88387502770F7E34BAFBCF5A_1402617646 = (isEmpty());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1886571884 = "{}";
            } //End block
        } //End collapsed parenthetic
        StringBuilder buffer;
        buffer = new StringBuilder(size() * 28);
        buffer.append('{');
        Iterator<Map.Entry<K, V>> it;
        it = entrySet().iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_531982897 = (it.hasNext());
            {
                Map.Entry<K, V> entry;
                entry = it.next();
                Object key;
                key = entry.getKey();
                {
                    boolean var16D2B55F557CAD854A6DE05990C0A440_211038779 = (key != this);
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
                    boolean var821264377CC13EB114216A02538260EC_2000392173 = (value != this);
                    {
                        buffer.append(value);
                    } //End block
                    {
                        buffer.append("(this Map)");
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_1522380666 = (it.hasNext());
                    {
                        buffer.append(", ");
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        buffer.append('}');
        varB4EAC82CA7396A68D541C85D26508E83_468146480 = buffer.toString();
        String varA7E53CE21691AB073D9660D615818899_124831622; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_124831622 = varB4EAC82CA7396A68D541C85D26508E83_1886571884;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_124831622 = varB4EAC82CA7396A68D541C85D26508E83_468146480;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_124831622.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_124831622;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.628 -0400", hash_original_method = "BE68DB72EA44A9864EFB8085A73DD13D", hash_generated_method = "B6F6D16DB156BDA96183CBC1EA1685B5")
    public Collection<V> values() {
        Collection<V> varB4EAC82CA7396A68D541C85D26508E83_459322218 = null; //Variable for return #1
        {
            valuesCollection = new AbstractCollection<V>() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.627 -0400", hash_original_method = "3B94EB65D5DE623B3E08A5638A43D0EB", hash_generated_method = "BFF12870EC233EAA21E353C26AA6200B")
                @Override
                public int size() {
                    int varFC76DB1BDD141E3C83EACBE167CD5D2A_1876283750 = (AbstractMap.this.size());
                    int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_681218268 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_681218268;
                    // ---------- Original Method ----------
                    //return AbstractMap.this.size();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.628 -0400", hash_original_method = "7679F4183F803D10EFCD1172E399C7C3", hash_generated_method = "465CA312FED230F6E410E745F8294723")
                @Override
                public boolean contains(Object object) {
                    boolean varF0370008E8B5928F4FAF5BBF8632C1B3_997415911 = (containsValue(object));
                    addTaint(object.getTaint());
                    boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_216185178 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_216185178;
                    // ---------- Original Method ----------
                    //return containsValue(object);
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.628 -0400", hash_original_method = "22ABA9D926948DD0ED49A20C6509C8CB", hash_generated_method = "BDD6087E75B74418B202E91AEC7FF6C8")
                @Override
                public Iterator<V> iterator() {
                    Iterator<V> varB4EAC82CA7396A68D541C85D26508E83_680724818 = null; //Variable for return #1
                    varB4EAC82CA7396A68D541C85D26508E83_680724818 = new Iterator<V>() {
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
                    varB4EAC82CA7396A68D541C85D26508E83_680724818.addTaint(getTaint()); //Add taint from parent
                    return varB4EAC82CA7396A68D541C85D26508E83_680724818;
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
        varB4EAC82CA7396A68D541C85D26508E83_459322218 = valuesCollection;
        varB4EAC82CA7396A68D541C85D26508E83_459322218.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_459322218;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.629 -0400", hash_original_method = "DEDBEBF1A9DF717B6A61BCEAEE5EB8FF", hash_generated_method = "D60AE7DE940DC9C50BFBE4C40B351B34")
    @SuppressWarnings("unchecked")
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1698362393 = null; //Variable for return #1
        AbstractMap<K, V> result;
        result = (AbstractMap<K, V>) super.clone();
        result.keySet = null;
        result.valuesCollection = null;
        varB4EAC82CA7396A68D541C85D26508E83_1698362393 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1698362393.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1698362393;
        // ---------- Original Method ----------
        //AbstractMap<K, V> result = (AbstractMap<K, V>) super.clone();
        //result.keySet = null;
        //result.valuesCollection = null;
        //return result;
    }

    
    public static class SimpleImmutableEntry<K, V> implements Map.Entry<K, V>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.629 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "EBAE1A8AD28B83F3F907DD83D8B82F01")

        private K key;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.629 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "EEA53383AEF96F58506DEE94A549CB01")

        private V value;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.629 -0400", hash_original_method = "33F8AD4AA392C56EA79ABB4A58A6836E", hash_generated_method = "1A26EA514829E31B02595112305C8058")
        public  SimpleImmutableEntry(K theKey, V theValue) {
            key = theKey;
            value = theValue;
            // ---------- Original Method ----------
            //key = theKey;
            //value = theValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.630 -0400", hash_original_method = "B328F2475798EE2AF89F33F6E7AEA482", hash_generated_method = "C6AD03E3758C4CD95B20142655BD5CD9")
        public  SimpleImmutableEntry(Map.Entry<? extends K, ? extends V> copyFrom) {
            key = copyFrom.getKey();
            value = copyFrom.getValue();
            // ---------- Original Method ----------
            //key = copyFrom.getKey();
            //value = copyFrom.getValue();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.630 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "226B7E0509BE966304BF7FF08A8283EB")
        public K getKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_131238350 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_131238350 = key;
            varB4EAC82CA7396A68D541C85D26508E83_131238350.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_131238350;
            // ---------- Original Method ----------
            //return key;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.634 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "FF59D78C4E7D9C529E394A70F360B5B5")
        public V getValue() {
            V varB4EAC82CA7396A68D541C85D26508E83_1253090834 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1253090834 = value;
            varB4EAC82CA7396A68D541C85D26508E83_1253090834.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1253090834;
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.635 -0400", hash_original_method = "3526712C126765AF36CB8D920CBD3B1B", hash_generated_method = "353FCD816437638683D9FB782CBD2AF6")
        public V setValue(V object) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(object.getTaint());
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.635 -0400", hash_original_method = "5E665954E6171F76B6FD9130152FC1D9", hash_generated_method = "1E59F732D58FD8EEA6656EDB8F4EF393")
        @Override
        public boolean equals(Object object) {
            {
                Map.Entry<?, ?> entry;
                entry = (Map.Entry<?, ?>) object;
                boolean var11197553A07BA849DF0822783F0D5152_893125060 = ((key == null ? entry.getKey() == null : key.equals(entry
                        .getKey()))
                        && (value == null ? entry.getValue() == null : value
                                .equals(entry.getValue()))); //DSFIXME:  CODE0008: Nested ternary operator in expression
            } //End block
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1371553151 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1371553151;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.635 -0400", hash_original_method = "6416487D313DFCFD3052C01ADB883217", hash_generated_method = "0F16D54C48E2A1C5119DFF5AB58F9927")
        @Override
        public int hashCode() {
            int var4B5981580A705D92ADA4BF72B6E1E3C5_1073471020 = ((key == null ? 0 : key.hashCode())
                    ^ (value == null ? 0 : value.hashCode())); //DSFIXME:  CODE0008: Nested ternary operator in expression
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_385369506 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_385369506;
            // ---------- Original Method ----------
            //return (key == null ? 0 : key.hashCode())
                    //^ (value == null ? 0 : value.hashCode());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.651 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "22DC8D472F89197411C2865D6C8C25B4")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_42648499 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_42648499 = key + "=" + value;
            varB4EAC82CA7396A68D541C85D26508E83_42648499.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_42648499;
            // ---------- Original Method ----------
            //return key + "=" + value;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.651 -0400", hash_original_field = "0FB41B94E91231F1583771B8C0C0C696", hash_generated_field = "03E66DCA96538DB895F88F39FB65BFF8")

        private static long serialVersionUID = 7138329143949025153L;
    }


    
    public static class SimpleEntry<K, V> implements Map.Entry<K, V>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.651 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "EBAE1A8AD28B83F3F907DD83D8B82F01")

        private K key;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.651 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "EEA53383AEF96F58506DEE94A549CB01")

        private V value;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.651 -0400", hash_original_method = "BD7301488126194D9FCD92EBDE27E89B", hash_generated_method = "6DD3ADB0E0C9AC93F8E4466B16A19993")
        public  SimpleEntry(K theKey, V theValue) {
            key = theKey;
            value = theValue;
            // ---------- Original Method ----------
            //key = theKey;
            //value = theValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.652 -0400", hash_original_method = "69734A3C3A679CA95ADF7DC846433DE1", hash_generated_method = "54A51761FD45C24B5F05A70D91586172")
        public  SimpleEntry(Map.Entry<? extends K, ? extends V> copyFrom) {
            key = copyFrom.getKey();
            value = copyFrom.getValue();
            // ---------- Original Method ----------
            //key = copyFrom.getKey();
            //value = copyFrom.getValue();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.652 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "C859607A496A435D7C6B054006AD8AC0")
        public K getKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_781786289 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_781786289 = key;
            varB4EAC82CA7396A68D541C85D26508E83_781786289.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_781786289;
            // ---------- Original Method ----------
            //return key;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.653 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "9DDD972BFE97D7679884E3F381261E03")
        public V getValue() {
            V varB4EAC82CA7396A68D541C85D26508E83_268026522 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_268026522 = value;
            varB4EAC82CA7396A68D541C85D26508E83_268026522.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_268026522;
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.653 -0400", hash_original_method = "123DAF07FFBE76C8EE5BD5879EB92827", hash_generated_method = "31F51394C5F8A631B9BEBA0B94F3C4DE")
        public V setValue(V object) {
            V varB4EAC82CA7396A68D541C85D26508E83_962829772 = null; //Variable for return #1
            V result;
            result = value;
            value = object;
            varB4EAC82CA7396A68D541C85D26508E83_962829772 = result;
            varB4EAC82CA7396A68D541C85D26508E83_962829772.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_962829772;
            // ---------- Original Method ----------
            //V result = value;
            //value = object;
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.654 -0400", hash_original_method = "5E665954E6171F76B6FD9130152FC1D9", hash_generated_method = "CA437C8C18094CAD23635489889FA873")
        @Override
        public boolean equals(Object object) {
            {
                Map.Entry<?, ?> entry;
                entry = (Map.Entry<?, ?>) object;
                boolean var11197553A07BA849DF0822783F0D5152_84835527 = ((key == null ? entry.getKey() == null : key.equals(entry
                        .getKey()))
                        && (value == null ? entry.getValue() == null : value
                                .equals(entry.getValue()))); //DSFIXME:  CODE0008: Nested ternary operator in expression
            } //End block
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1998304562 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1998304562;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.654 -0400", hash_original_method = "6416487D313DFCFD3052C01ADB883217", hash_generated_method = "7E742AFC75D60AF7229E0EC52808DB8E")
        @Override
        public int hashCode() {
            int var4B5981580A705D92ADA4BF72B6E1E3C5_1548793676 = ((key == null ? 0 : key.hashCode())
                    ^ (value == null ? 0 : value.hashCode())); //DSFIXME:  CODE0008: Nested ternary operator in expression
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_129491983 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_129491983;
            // ---------- Original Method ----------
            //return (key == null ? 0 : key.hashCode())
                    //^ (value == null ? 0 : value.hashCode());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.654 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "268CBB39D14AA018A4CBDEB8D5B37C94")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_163044935 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_163044935 = key + "=" + value;
            varB4EAC82CA7396A68D541C85D26508E83_163044935.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_163044935;
            // ---------- Original Method ----------
            //return key + "=" + value;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.654 -0400", hash_original_field = "6740671D10922D6DCB5AFF41C09E8C7B", hash_generated_field = "69D93EB2C7A6CA20863AB99BD1E97247")

        private static long serialVersionUID = -8499721149061103585L;
    }


    
}

