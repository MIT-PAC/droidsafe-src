package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public abstract class AbstractMap<K, V> implements Map<K, V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.503 -0400", hash_original_field = "3E8ABCE844B6A8A95397486A3899B536", hash_generated_field = "8E2B51CCF89ADF7243D25312F0ABCDAC")

    Set<K> keySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.503 -0400", hash_original_field = "8169AE04F2776F041E9D71005E918170", hash_generated_field = "BE71573A2BD5F9F8A42171B5E82953DE")

    Collection<V> valuesCollection;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.503 -0400", hash_original_method = "38C8E9EBD98120A2B6A13CBC6F342ADF", hash_generated_method = "BA1BD3AE70CC5BFD1550DE98F5395666")
    protected  AbstractMap() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.504 -0400", hash_original_method = "76EEE079F2D9B88A31C5F2E8E9C7EB92", hash_generated_method = "D04492222E27A17B4DBF52591A0F49E1")
    public void clear() {
        entrySet().clear();
        // ---------- Original Method ----------
        //entrySet().clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.504 -0400", hash_original_method = "3D741B03C8862C52B96D9B3B81701BE0", hash_generated_method = "1300C5B42BA0AEABD54B767D321737E5")
    public boolean containsKey(Object key) {
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_110110971 = (it.hasNext());
                {
                    {
                        boolean var336751FB500C73D2E78ACA4F990236DD_765111874 = (key.equals(it.next().getKey()));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_639961014 = (it.hasNext());
                {
                    {
                        boolean varF8E9FE1C2FF7A3716E9DE49769E3ED8E_822465496 = (it.next().getKey() == null);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_649001681 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_649001681;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.504 -0400", hash_original_method = "D1C1AD8AFDB44AE56F4D2DF37F057E9D", hash_generated_method = "4CA79AF01AB3C5418C399B4BD0025C3C")
    public boolean containsValue(Object value) {
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_163604381 = (it.hasNext());
                {
                    {
                        boolean var2840902430CC9CE595E44E3BC99DC210_662651985 = (value.equals(it.next().getValue()));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_768017350 = (it.hasNext());
                {
                    {
                        boolean var447D2FB852C22F3FC7BB27E177199524_1472779958 = (it.next().getValue() == null);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_541678077 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_541678077;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.511 -0400", hash_original_method = "5B9317AAB202C2AFA6ECB99B62EB1150", hash_generated_method = "50F8C36BCC36994C9381563E34821865")
    @Override
    public boolean equals(Object object) {
        {
            Map<?, ?> map = (Map<?, ?>) object;
            {
                boolean var17E93156AEDB9EC4C0BE0F9FC6995057_1475012566 = (size() != map.size());
            } //End collapsed parenthetic
            try 
            {
                {
                    Iterator<Entry<K, V>> var3C9398D697CD538C1DB9788B7EB77AE6_1472079642 = (entrySet()).iterator();
                    var3C9398D697CD538C1DB9788B7EB77AE6_1472079642.hasNext();
                    Entry<K, V> entry = var3C9398D697CD538C1DB9788B7EB77AE6_1472079642.next();
                    {
                        K key = entry.getKey();
                        V mine = entry.getValue();
                        Object theirs = map.get(key);
                        {
                            {
                                boolean varE9FDF34CB553A188B1AB044FFF7E6F9B_1728487955 = (theirs != null || !map.containsKey(key));
                            } //End collapsed parenthetic
                        } //End block
                        {
                            boolean varFC1E0BD092353CAAE827D7D85269DF68_229217534 = (!mine.equals(theirs));
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1903549042 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1903549042;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.512 -0400", hash_original_method = "80DED5B1493F4175A64A94324F6ABF01", hash_generated_method = "734A943EF8E4BDC6A9421D6D1D350FA9")
    public V get(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_1175291848 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_986277471 = null; //Variable for return #2
        V varB4EAC82CA7396A68D541C85D26508E83_259209752 = null; //Variable for return #3
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1889406401 = (it.hasNext());
                {
                    Map.Entry<K, V> entry = it.next();
                    {
                        boolean varF16E55D9A798E58C2D063C16A4BD00B9_581923827 = (key.equals(entry.getKey()));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1175291848 = entry.getValue();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1452571829 = (it.hasNext());
                {
                    Map.Entry<K, V> entry = it.next();
                    {
                        boolean varAAAB7182D9FFD9762DBAE32CE15E7BF0_552362281 = (entry.getKey() == null);
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_986277471 = entry.getValue();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_259209752 = null;
        addTaint(key.getTaint());
        V varA7E53CE21691AB073D9660D615818899_382749966; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_382749966 = varB4EAC82CA7396A68D541C85D26508E83_1175291848;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_382749966 = varB4EAC82CA7396A68D541C85D26508E83_986277471;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_382749966 = varB4EAC82CA7396A68D541C85D26508E83_259209752;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_382749966.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_382749966;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.512 -0400", hash_original_method = "64FA0B5ACB2A736D0354FE373D9CD3E5", hash_generated_method = "FBE0595E38845157EE1552EC37C4FC2C")
    @Override
    public int hashCode() {
        int result = 0;
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_101547190 = (it.hasNext());
            {
                result += it.next().hashCode();
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_852074848 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_852074848;
        // ---------- Original Method ----------
        //int result = 0;
        //Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        //while (it.hasNext()) {
            //result += it.next().hashCode();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.512 -0400", hash_original_method = "296240B68F4A866C698190CF33710ED8", hash_generated_method = "FCCDBB16EA7CE24859581DD8738BD4DD")
    public boolean isEmpty() {
        boolean var5E7C4FBBEC9A5754B20CB85881048CD5_1384055966 = (size() == 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1893314426 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1893314426;
        // ---------- Original Method ----------
        //return size() == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.515 -0400", hash_original_method = "F40A232B51CF144805B23E3A97CCF7A5", hash_generated_method = "1AA696129FF433109FF2BE8ED4845277")
    public Set<K> keySet() {
        Set<K> varB4EAC82CA7396A68D541C85D26508E83_2114878106 = null; //Variable for return #1
        {
            keySet = new AbstractSet<K>() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.513 -0400", hash_original_method = "D170B4D54B17306878DDF90A529C04ED", hash_generated_method = "40E05F353FC505B44E726190B5A71DFE")
                @Override
                public boolean contains(Object object) {
                    boolean var5CF08BC5A8889C1E8B40FF0332AFAC24_345165767 = (containsKey(object));
                    addTaint(object.getTaint());
                    boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1287308783 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1287308783;
                    // ---------- Original Method ----------
                    //return containsKey(object);
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.514 -0400", hash_original_method = "3B94EB65D5DE623B3E08A5638A43D0EB", hash_generated_method = "46BAD33ED48171CC48D1A982FB394E4F")
                @Override
                public int size() {
                    int varFC76DB1BDD141E3C83EACBE167CD5D2A_834221976 = (AbstractMap.this.size());
                    int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_479694362 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_479694362;
                    // ---------- Original Method ----------
                    //return AbstractMap.this.size();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.515 -0400", hash_original_method = "4DAF499E5ADBF0012E8FC0F4014839E7", hash_generated_method = "DCE0A5B34FB1D3EF971133B5F3792CFE")
                @Override
                public Iterator<K> iterator() {
                    Iterator<K> varB4EAC82CA7396A68D541C85D26508E83_1551804556 = null; //Variable for return #1
                    varB4EAC82CA7396A68D541C85D26508E83_1551804556 = new Iterator<K>() {
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
                    varB4EAC82CA7396A68D541C85D26508E83_1551804556.addTaint(getTaint()); //Add taint from parent
                    return varB4EAC82CA7396A68D541C85D26508E83_1551804556;
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
        varB4EAC82CA7396A68D541C85D26508E83_2114878106 = keySet;
        varB4EAC82CA7396A68D541C85D26508E83_2114878106.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2114878106;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.515 -0400", hash_original_method = "1AE25A34BEB4A8F08F41373ADFFCFE34", hash_generated_method = "32D770B6587B989453B110A6DB3F9E94")
    public V put(K key, V value) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.518 -0400", hash_original_method = "1BF9761154AA89A664F00EA3C1B1A227", hash_generated_method = "D437120E0666C13A15D1097B265114E3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.520 -0400", hash_original_method = "DF925EC53E8E5501C52A21B969B7A962", hash_generated_method = "EE7CD2956F0B26D37132C851C58FB8E2")
    public V remove(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_104767998 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_433379381 = null; //Variable for return #2
        V varB4EAC82CA7396A68D541C85D26508E83_388347611 = null; //Variable for return #3
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_522302645 = (it.hasNext());
                {
                    Map.Entry<K, V> entry = it.next();
                    {
                        boolean varF16E55D9A798E58C2D063C16A4BD00B9_620712278 = (key.equals(entry.getKey()));
                        {
                            it.remove();
                            varB4EAC82CA7396A68D541C85D26508E83_104767998 = entry.getValue();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1915420284 = (it.hasNext());
                {
                    Map.Entry<K, V> entry = it.next();
                    {
                        boolean varAAAB7182D9FFD9762DBAE32CE15E7BF0_467110246 = (entry.getKey() == null);
                        {
                            it.remove();
                            varB4EAC82CA7396A68D541C85D26508E83_433379381 = entry.getValue();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_388347611 = null;
        addTaint(key.getTaint());
        V varA7E53CE21691AB073D9660D615818899_1385017175; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1385017175 = varB4EAC82CA7396A68D541C85D26508E83_104767998;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1385017175 = varB4EAC82CA7396A68D541C85D26508E83_433379381;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1385017175 = varB4EAC82CA7396A68D541C85D26508E83_388347611;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1385017175.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1385017175;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.521 -0400", hash_original_method = "68473A1BCB9C7CDFC9C6F1089F605F26", hash_generated_method = "5096C1670E11ED889042029C9D8E56CF")
    public int size() {
        int var7F32C43E8079B6AEF852C4A760F273DE_1367881924 = (entrySet().size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_470515939 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_470515939;
        // ---------- Original Method ----------
        //return entrySet().size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.523 -0400", hash_original_method = "03506E32B26B17661064F3FFDE4F185F", hash_generated_method = "2CCECF42ADFD824F6947A4A41A6BB1E0")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_775218016 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1895273299 = null; //Variable for return #2
        {
            boolean var8697D8FD88387502770F7E34BAFBCF5A_317387923 = (isEmpty());
            {
                varB4EAC82CA7396A68D541C85D26508E83_775218016 = "{}";
            } //End block
        } //End collapsed parenthetic
        StringBuilder buffer = new StringBuilder(size() * 28);
        buffer.append('{');
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1669336311 = (it.hasNext());
            {
                Map.Entry<K, V> entry = it.next();
                Object key = entry.getKey();
                {
                    boolean var16D2B55F557CAD854A6DE05990C0A440_215096647 = (key != this);
                    {
                        buffer.append(key);
                    } //End block
                    {
                        buffer.append("(this Map)");
                    } //End block
                } //End collapsed parenthetic
                buffer.append('=');
                Object value = entry.getValue();
                {
                    boolean var821264377CC13EB114216A02538260EC_116041627 = (value != this);
                    {
                        buffer.append(value);
                    } //End block
                    {
                        buffer.append("(this Map)");
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_1309656886 = (it.hasNext());
                    {
                        buffer.append(", ");
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        buffer.append('}');
        varB4EAC82CA7396A68D541C85D26508E83_1895273299 = buffer.toString();
        String varA7E53CE21691AB073D9660D615818899_7281077; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_7281077 = varB4EAC82CA7396A68D541C85D26508E83_775218016;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_7281077 = varB4EAC82CA7396A68D541C85D26508E83_1895273299;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_7281077.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_7281077;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.525 -0400", hash_original_method = "BE68DB72EA44A9864EFB8085A73DD13D", hash_generated_method = "B654A90308677B80CD54F100D0A8DBA5")
    public Collection<V> values() {
        Collection<V> varB4EAC82CA7396A68D541C85D26508E83_1245758365 = null; //Variable for return #1
        {
            valuesCollection = new AbstractCollection<V>() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.523 -0400", hash_original_method = "3B94EB65D5DE623B3E08A5638A43D0EB", hash_generated_method = "315B24437C45FE5A4765979868300C1F")
                @Override
                public int size() {
                    int varFC76DB1BDD141E3C83EACBE167CD5D2A_645559505 = (AbstractMap.this.size());
                    int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_522389208 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_522389208;
                    // ---------- Original Method ----------
                    //return AbstractMap.this.size();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.524 -0400", hash_original_method = "7679F4183F803D10EFCD1172E399C7C3", hash_generated_method = "C2D2A469E3BB72B3E7FC10FCEAA36ED3")
                @Override
                public boolean contains(Object object) {
                    boolean varF0370008E8B5928F4FAF5BBF8632C1B3_197809621 = (containsValue(object));
                    addTaint(object.getTaint());
                    boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_417544816 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_417544816;
                    // ---------- Original Method ----------
                    //return containsValue(object);
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.524 -0400", hash_original_method = "22ABA9D926948DD0ED49A20C6509C8CB", hash_generated_method = "BB2DF3094D65DB9FB76684E04402FB14")
                @Override
                public Iterator<V> iterator() {
                    Iterator<V> varB4EAC82CA7396A68D541C85D26508E83_28933730 = null; //Variable for return #1
                    varB4EAC82CA7396A68D541C85D26508E83_28933730 = new Iterator<V>() {
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
                    varB4EAC82CA7396A68D541C85D26508E83_28933730.addTaint(getTaint()); //Add taint from parent
                    return varB4EAC82CA7396A68D541C85D26508E83_28933730;
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
        varB4EAC82CA7396A68D541C85D26508E83_1245758365 = valuesCollection;
        varB4EAC82CA7396A68D541C85D26508E83_1245758365.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1245758365;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.526 -0400", hash_original_method = "DEDBEBF1A9DF717B6A61BCEAEE5EB8FF", hash_generated_method = "252D1CC35DA703AB61C7F08A8EB0F0F6")
    @SuppressWarnings("unchecked")
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_212899040 = null; //Variable for return #1
        AbstractMap<K, V> result = (AbstractMap<K, V>) super.clone();
        result.keySet = null;
        result.valuesCollection = null;
        varB4EAC82CA7396A68D541C85D26508E83_212899040 = result;
        varB4EAC82CA7396A68D541C85D26508E83_212899040.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_212899040;
        // ---------- Original Method ----------
        //AbstractMap<K, V> result = (AbstractMap<K, V>) super.clone();
        //result.keySet = null;
        //result.valuesCollection = null;
        //return result;
    }

    
    public static class SimpleImmutableEntry<K, V> implements Map.Entry<K, V>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.526 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "EBAE1A8AD28B83F3F907DD83D8B82F01")

        private K key;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.527 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "EEA53383AEF96F58506DEE94A549CB01")

        private V value;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.528 -0400", hash_original_method = "33F8AD4AA392C56EA79ABB4A58A6836E", hash_generated_method = "1A26EA514829E31B02595112305C8058")
        public  SimpleImmutableEntry(K theKey, V theValue) {
            key = theKey;
            value = theValue;
            // ---------- Original Method ----------
            //key = theKey;
            //value = theValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.530 -0400", hash_original_method = "B328F2475798EE2AF89F33F6E7AEA482", hash_generated_method = "C6AD03E3758C4CD95B20142655BD5CD9")
        public  SimpleImmutableEntry(Map.Entry<? extends K, ? extends V> copyFrom) {
            key = copyFrom.getKey();
            value = copyFrom.getValue();
            // ---------- Original Method ----------
            //key = copyFrom.getKey();
            //value = copyFrom.getValue();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.535 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "E8166AC29D42B5454C272C700D54AACF")
        public K getKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_878563623 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_878563623 = key;
            varB4EAC82CA7396A68D541C85D26508E83_878563623.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_878563623;
            // ---------- Original Method ----------
            //return key;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.536 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "28E9960EF97E375819A49B7A19FAD1DC")
        public V getValue() {
            V varB4EAC82CA7396A68D541C85D26508E83_1897048647 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1897048647 = value;
            varB4EAC82CA7396A68D541C85D26508E83_1897048647.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1897048647;
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.537 -0400", hash_original_method = "3526712C126765AF36CB8D920CBD3B1B", hash_generated_method = "353FCD816437638683D9FB782CBD2AF6")
        public V setValue(V object) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(object.getTaint());
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.538 -0400", hash_original_method = "5E665954E6171F76B6FD9130152FC1D9", hash_generated_method = "D6868DE1B53A4B19ABD179D80B5FCEEE")
        @Override
        public boolean equals(Object object) {
            {
                Map.Entry<?, ?> entry = (Map.Entry<?, ?>) object;
                boolean var11197553A07BA849DF0822783F0D5152_507576319 = ((key == null ? entry.getKey() == null : key.equals(entry
                        .getKey()))
                        && (value == null ? entry.getValue() == null : value
                                .equals(entry.getValue()))); //DSFIXME:  CODE0008: Nested ternary operator in expression
            } //End block
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1127185900 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1127185900;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.539 -0400", hash_original_method = "6416487D313DFCFD3052C01ADB883217", hash_generated_method = "E8372C03009EDC1677675DC35EB0C31C")
        @Override
        public int hashCode() {
            int var4B5981580A705D92ADA4BF72B6E1E3C5_1235172568 = ((key == null ? 0 : key.hashCode())
                    ^ (value == null ? 0 : value.hashCode())); //DSFIXME:  CODE0008: Nested ternary operator in expression
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1937489598 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1937489598;
            // ---------- Original Method ----------
            //return (key == null ? 0 : key.hashCode())
                    //^ (value == null ? 0 : value.hashCode());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.541 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "251BE5FBBE8EB9D7EFF4705C555174C1")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1784031904 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1784031904 = key + "=" + value;
            varB4EAC82CA7396A68D541C85D26508E83_1784031904.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1784031904;
            // ---------- Original Method ----------
            //return key + "=" + value;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.541 -0400", hash_original_field = "0FB41B94E91231F1583771B8C0C0C696", hash_generated_field = "3DFDD92E82A1CB0CEF7DE41ED65507D7")

        private static final long serialVersionUID = 7138329143949025153L;
    }


    
    public static class SimpleEntry<K, V> implements Map.Entry<K, V>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.542 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "EBAE1A8AD28B83F3F907DD83D8B82F01")

        private K key;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.542 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "EEA53383AEF96F58506DEE94A549CB01")

        private V value;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.542 -0400", hash_original_method = "BD7301488126194D9FCD92EBDE27E89B", hash_generated_method = "6DD3ADB0E0C9AC93F8E4466B16A19993")
        public  SimpleEntry(K theKey, V theValue) {
            key = theKey;
            value = theValue;
            // ---------- Original Method ----------
            //key = theKey;
            //value = theValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.543 -0400", hash_original_method = "69734A3C3A679CA95ADF7DC846433DE1", hash_generated_method = "54A51761FD45C24B5F05A70D91586172")
        public  SimpleEntry(Map.Entry<? extends K, ? extends V> copyFrom) {
            key = copyFrom.getKey();
            value = copyFrom.getValue();
            // ---------- Original Method ----------
            //key = copyFrom.getKey();
            //value = copyFrom.getValue();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.544 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "9F0F65AAC27C8BD3F417E915D0CBF5B2")
        public K getKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_1084115693 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1084115693 = key;
            varB4EAC82CA7396A68D541C85D26508E83_1084115693.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1084115693;
            // ---------- Original Method ----------
            //return key;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.544 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "F2343CC9D9528C20901836F047397845")
        public V getValue() {
            V varB4EAC82CA7396A68D541C85D26508E83_1155326197 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1155326197 = value;
            varB4EAC82CA7396A68D541C85D26508E83_1155326197.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1155326197;
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.545 -0400", hash_original_method = "123DAF07FFBE76C8EE5BD5879EB92827", hash_generated_method = "7EFA572F682F2C0DCB60D34582CC3DFA")
        public V setValue(V object) {
            V varB4EAC82CA7396A68D541C85D26508E83_210879845 = null; //Variable for return #1
            V result = value;
            value = object;
            varB4EAC82CA7396A68D541C85D26508E83_210879845 = result;
            varB4EAC82CA7396A68D541C85D26508E83_210879845.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_210879845;
            // ---------- Original Method ----------
            //V result = value;
            //value = object;
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.546 -0400", hash_original_method = "5E665954E6171F76B6FD9130152FC1D9", hash_generated_method = "C40C188BE63DA87F4B478C2AFE74D20C")
        @Override
        public boolean equals(Object object) {
            {
                Map.Entry<?, ?> entry = (Map.Entry<?, ?>) object;
                boolean var11197553A07BA849DF0822783F0D5152_369162173 = ((key == null ? entry.getKey() == null : key.equals(entry
                        .getKey()))
                        && (value == null ? entry.getValue() == null : value
                                .equals(entry.getValue()))); //DSFIXME:  CODE0008: Nested ternary operator in expression
            } //End block
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_354959533 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_354959533;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.546 -0400", hash_original_method = "6416487D313DFCFD3052C01ADB883217", hash_generated_method = "23D2C4993D2E11F9BF9168A3A0ADC472")
        @Override
        public int hashCode() {
            int var4B5981580A705D92ADA4BF72B6E1E3C5_1721821932 = ((key == null ? 0 : key.hashCode())
                    ^ (value == null ? 0 : value.hashCode())); //DSFIXME:  CODE0008: Nested ternary operator in expression
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1227324552 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1227324552;
            // ---------- Original Method ----------
            //return (key == null ? 0 : key.hashCode())
                    //^ (value == null ? 0 : value.hashCode());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.547 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "1B6481D5FE114251EC854A9348552BDC")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_411014027 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_411014027 = key + "=" + value;
            varB4EAC82CA7396A68D541C85D26508E83_411014027.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_411014027;
            // ---------- Original Method ----------
            //return key + "=" + value;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.547 -0400", hash_original_field = "6740671D10922D6DCB5AFF41C09E8C7B", hash_generated_field = "9B9E5FFE746EC28EB67AAB64BC8691E2")

        private static final long serialVersionUID = -8499721149061103585L;
    }


    
}

