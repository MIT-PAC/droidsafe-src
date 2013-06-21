package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public abstract class AbstractMap<K, V> implements Map<K, V> {
    Set<K> keySet;
    Collection<V> valuesCollection;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.818 -0400", hash_original_method = "38C8E9EBD98120A2B6A13CBC6F342ADF", hash_generated_method = "BA1BD3AE70CC5BFD1550DE98F5395666")
    @DSModeled(DSC.SAFE)
    protected AbstractMap() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.818 -0400", hash_original_method = "76EEE079F2D9B88A31C5F2E8E9C7EB92", hash_generated_method = "D04492222E27A17B4DBF52591A0F49E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clear() {
        entrySet().clear();
        // ---------- Original Method ----------
        //entrySet().clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.818 -0400", hash_original_method = "3D741B03C8862C52B96D9B3B81701BE0", hash_generated_method = "F5FAE712544465FE6DA3942B18DB0D20")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsKey(Object key) {
        dsTaint.addTaint(key.dsTaint);
        Iterator<Map.Entry<K, V>> it;
        it = entrySet().iterator();
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1666926201 = (it.hasNext());
                {
                    {
                        boolean var336751FB500C73D2E78ACA4F990236DD_758291430 = (key.equals(it.next().getKey()));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1764789370 = (it.hasNext());
                {
                    {
                        boolean varF8E9FE1C2FF7A3716E9DE49769E3ED8E_552466850 = (it.next().getKey() == null);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.819 -0400", hash_original_method = "D1C1AD8AFDB44AE56F4D2DF37F057E9D", hash_generated_method = "06E1606F309719FDCB4D812BA1B685F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsValue(Object value) {
        dsTaint.addTaint(value.dsTaint);
        Iterator<Map.Entry<K, V>> it;
        it = entrySet().iterator();
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1397513003 = (it.hasNext());
                {
                    {
                        boolean var2840902430CC9CE595E44E3BC99DC210_1753650588 = (value.equals(it.next().getValue()));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1126423226 = (it.hasNext());
                {
                    {
                        boolean var447D2FB852C22F3FC7BB27E177199524_1784931529 = (it.next().getValue() == null);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.826 -0400", hash_original_method = "5B9317AAB202C2AFA6ECB99B62EB1150", hash_generated_method = "DE9BD1351E33D303E15F969DC637F709")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        {
            Map<?, ?> map;
            map = (Map<?, ?>) object;
            {
                boolean var17E93156AEDB9EC4C0BE0F9FC6995057_402485882 = (size() != map.size());
            } //End collapsed parenthetic
            try 
            {
                {
                    Iterator<Entry<K, V>> var3C9398D697CD538C1DB9788B7EB77AE6_1947264378 = (entrySet()).iterator();
                    var3C9398D697CD538C1DB9788B7EB77AE6_1947264378.hasNext();
                    Entry<K, V> entry = var3C9398D697CD538C1DB9788B7EB77AE6_1947264378.next();
                    {
                        K key;
                        key = entry.getKey();
                        V mine;
                        mine = entry.getValue();
                        Object theirs;
                        theirs = map.get(key);
                        {
                            {
                                boolean varE9FDF34CB553A188B1AB044FFF7E6F9B_1802983843 = (theirs != null || !map.containsKey(key));
                            } //End collapsed parenthetic
                        } //End block
                        {
                            boolean varFC1E0BD092353CAAE827D7D85269DF68_1999985471 = (!mine.equals(theirs));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            catch (NullPointerException ignored)
            { }
            catch (ClassCastException ignored)
            { }
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.826 -0400", hash_original_method = "80DED5B1493F4175A64A94324F6ABF01", hash_generated_method = "CA28D89B9C887D473899B9373493B18C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public V get(Object key) {
        dsTaint.addTaint(key.dsTaint);
        Iterator<Map.Entry<K, V>> it;
        it = entrySet().iterator();
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_263290790 = (it.hasNext());
                {
                    Map.Entry<K, V> entry;
                    entry = it.next();
                    {
                        boolean varF16E55D9A798E58C2D063C16A4BD00B9_1908795824 = (key.equals(entry.getKey()));
                        {
                            V var4E1F40FF31F2D73819A604B313C40C8C_1893823178 = (entry.getValue());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_115981424 = (it.hasNext());
                {
                    Map.Entry<K, V> entry;
                    entry = it.next();
                    {
                        boolean varAAAB7182D9FFD9762DBAE32CE15E7BF0_1919268283 = (entry.getKey() == null);
                        {
                            V var4E1F40FF31F2D73819A604B313C40C8C_2077031251 = (entry.getValue());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (V)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.826 -0400", hash_original_method = "64FA0B5ACB2A736D0354FE373D9CD3E5", hash_generated_method = "719F8B9916521E7F6EC60719B940997C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int result;
        result = 0;
        Iterator<Map.Entry<K, V>> it;
        it = entrySet().iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1662024430 = (it.hasNext());
            {
                result += it.next().hashCode();
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int result = 0;
        //Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        //while (it.hasNext()) {
            //result += it.next().hashCode();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.827 -0400", hash_original_method = "296240B68F4A866C698190CF33710ED8", hash_generated_method = "198838D9CA595FC64283D889B3661A63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEmpty() {
        boolean var5E7C4FBBEC9A5754B20CB85881048CD5_1950049525 = (size() == 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return size() == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.830 -0400", hash_original_method = "F40A232B51CF144805B23E3A97CCF7A5", hash_generated_method = "ECBC17E88F44E3FE21EA67C34FA83719")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<K> keySet() {
        {
            keySet = new AbstractSet<K>() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.827 -0400", hash_original_method = "D170B4D54B17306878DDF90A529C04ED", hash_generated_method = "B4B4867A5833DAD74F8FDE9AF240FD8B")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public boolean contains(Object object) {
                    dsTaint.addTaint(object.dsTaint);
                    boolean var5CF08BC5A8889C1E8B40FF0332AFAC24_423633234 = (containsKey(object));
                    return dsTaint.getTaintBoolean();
                    // ---------- Original Method ----------
                    //return containsKey(object);
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.828 -0400", hash_original_method = "3B94EB65D5DE623B3E08A5638A43D0EB", hash_generated_method = "7B3BF9A73DE0A1051FD6794956AD4E7E")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public int size() {
                    int varFC76DB1BDD141E3C83EACBE167CD5D2A_2098057359 = (AbstractMap.this.size());
                    return dsTaint.getTaintInt();
                    // ---------- Original Method ----------
                    //return AbstractMap.this.size();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.830 -0400", hash_original_method = "4DAF499E5ADBF0012E8FC0F4014839E7", hash_generated_method = "0A2F68602D51B798B3DE956CF5FEAE94")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public Iterator<K> iterator() {
                    Iterator<K> var2CF138F6448E3AE216F40814AE244EF8_721057732 = (new Iterator<K>() {                        Iterator<Map.Entry<K, V>> setIterator = entrySet().iterator();
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.829 -0400", hash_original_method = "213B6F6BF550680DB14A6264553A9606", hash_generated_method = "F223C42B370CCC19A46D44CA939533BA")
                        //DSFIXME:  CODE0002: Requires DSC value to be set
                        public boolean hasNext() {
                            boolean var1D5A90C08F5F4E0C6DFBA38E545BDD0F_742154895 = (setIterator.hasNext());
                            return dsTaint.getTaintBoolean();
                            // ---------- Original Method ----------
                            //return setIterator.hasNext();
                        }
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.830 -0400", hash_original_method = "2ACAF5E8045DB2C1E5B1B79533A99B49", hash_generated_method = "C29F095E47761D33496F0A12318AD060")
                        //DSFIXME:  CODE0002: Requires DSC value to be set
                        public K next() {
                            K varF0F77686F865401FE759CC3726751139_1219779262 = (setIterator.next().getKey());
                            return (K)dsTaint.getTaint();
                            // ---------- Original Method ----------
                            //return setIterator.next().getKey();
                        }
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.830 -0400", hash_original_method = "18575B4AE5EB78B20BC29135C417B7D0", hash_generated_method = "1D1456161322FC7023EBF5038D6C13EA")
                        //DSFIXME:  CODE0002: Requires DSC value to be set
                        public void remove() {
                            setIterator.remove();
                            // ---------- Original Method ----------
                            //setIterator.remove();
                        }
});
                    return (Iterator<K>)dsTaint.getTaint();
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
        return (Set<K>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.832 -0400", hash_original_method = "1AE25A34BEB4A8F08F41373ADFFCFE34", hash_generated_method = "E5B62AA1D00DEA9EE1384E024D437143")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public V put(K key, V value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.835 -0400", hash_original_method = "1BF9761154AA89A664F00EA3C1B1A227", hash_generated_method = "FD6115B126E3FE00F5476C6C91BABDBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void putAll(Map<? extends K, ? extends V> map) {
        dsTaint.addTaint(map.dsTaint);
        {
            map.entrySet().iterator().hasNext();
            Map.Entry<? extends K, ? extends V> entry = map.entrySet().iterator().next();
            {
                put(entry.getKey(), entry.getValue());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            //put(entry.getKey(), entry.getValue());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.835 -0400", hash_original_method = "DF925EC53E8E5501C52A21B969B7A962", hash_generated_method = "5056EF447C6F2E3B6FA5C846007A9CE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public V remove(Object key) {
        dsTaint.addTaint(key.dsTaint);
        Iterator<Map.Entry<K, V>> it;
        it = entrySet().iterator();
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_968190620 = (it.hasNext());
                {
                    Map.Entry<K, V> entry;
                    entry = it.next();
                    {
                        boolean varF16E55D9A798E58C2D063C16A4BD00B9_601177278 = (key.equals(entry.getKey()));
                        {
                            it.remove();
                            V var4E1F40FF31F2D73819A604B313C40C8C_1534189672 = (entry.getValue());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1661230462 = (it.hasNext());
                {
                    Map.Entry<K, V> entry;
                    entry = it.next();
                    {
                        boolean varAAAB7182D9FFD9762DBAE32CE15E7BF0_2058192491 = (entry.getKey() == null);
                        {
                            it.remove();
                            V var4E1F40FF31F2D73819A604B313C40C8C_1613943368 = (entry.getValue());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (V)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.836 -0400", hash_original_method = "68473A1BCB9C7CDFC9C6F1089F605F26", hash_generated_method = "28F0101B46F4002817E15168005049F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int size() {
        int var7F32C43E8079B6AEF852C4A760F273DE_1754571689 = (entrySet().size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return entrySet().size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.836 -0400", hash_original_method = "03506E32B26B17661064F3FFDE4F185F", hash_generated_method = "9B1DEEA29049CA4B7E7CC8C60554B3B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        {
            boolean var8697D8FD88387502770F7E34BAFBCF5A_328471460 = (isEmpty());
        } //End collapsed parenthetic
        StringBuilder buffer;
        buffer = new StringBuilder(size() * 28);
        buffer.append('{');
        Iterator<Map.Entry<K, V>> it;
        it = entrySet().iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1740298870 = (it.hasNext());
            {
                Map.Entry<K, V> entry;
                entry = it.next();
                Object key;
                key = entry.getKey();
                {
                    boolean var16D2B55F557CAD854A6DE05990C0A440_407539470 = (key != this);
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
                    boolean var821264377CC13EB114216A02538260EC_316352761 = (value != this);
                    {
                        buffer.append(value);
                    } //End block
                    {
                        buffer.append("(this Map)");
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_1694976383 = (it.hasNext());
                    {
                        buffer.append(", ");
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        buffer.append('}');
        String varAD28D02EB1C6982A5710D014292E1955_1129256512 = (buffer.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.838 -0400", hash_original_method = "BE68DB72EA44A9864EFB8085A73DD13D", hash_generated_method = "39A715D72598C658C379F342645957BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Collection<V> values() {
        {
            valuesCollection = new AbstractCollection<V>() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.837 -0400", hash_original_method = "3B94EB65D5DE623B3E08A5638A43D0EB", hash_generated_method = "8560A05BE823B9BA4559F3A9BBDD5E5F")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public int size() {
                    int varFC76DB1BDD141E3C83EACBE167CD5D2A_56252704 = (AbstractMap.this.size());
                    return dsTaint.getTaintInt();
                    // ---------- Original Method ----------
                    //return AbstractMap.this.size();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.837 -0400", hash_original_method = "7679F4183F803D10EFCD1172E399C7C3", hash_generated_method = "48790413DA9751522F1DA419D3D447BA")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public boolean contains(Object object) {
                    dsTaint.addTaint(object.dsTaint);
                    boolean varF0370008E8B5928F4FAF5BBF8632C1B3_1595846620 = (containsValue(object));
                    return dsTaint.getTaintBoolean();
                    // ---------- Original Method ----------
                    //return containsValue(object);
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.838 -0400", hash_original_method = "22ABA9D926948DD0ED49A20C6509C8CB", hash_generated_method = "644262880BD467B5F1E78B8077A9513D")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public Iterator<V> iterator() {
                    Iterator<V> var600BBF8E688AA47B1DD55335B5640D55_1715349595 = (new Iterator<V>() {                        Iterator<Map.Entry<K, V>> setIterator = entrySet().iterator();
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.837 -0400", hash_original_method = "213B6F6BF550680DB14A6264553A9606", hash_generated_method = "5FABD105A69F2DEA8F1002980F8A724B")
                        //DSFIXME:  CODE0002: Requires DSC value to be set
                        public boolean hasNext() {
                            boolean var1D5A90C08F5F4E0C6DFBA38E545BDD0F_1865539158 = (setIterator.hasNext());
                            return dsTaint.getTaintBoolean();
                            // ---------- Original Method ----------
                            //return setIterator.hasNext();
                        }
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.838 -0400", hash_original_method = "26FD6EB64128E32F409902FB919BC33E", hash_generated_method = "120BDF4BF5A7C7D074B3F636AEC0990F")
                        //DSFIXME:  CODE0002: Requires DSC value to be set
                        public V next() {
                            V var4B996BD93A47403C6AD7577EB72B7EBE_415491747 = (setIterator.next().getValue());
                            return (V)dsTaint.getTaint();
                            // ---------- Original Method ----------
                            //return setIterator.next().getValue();
                        }
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.838 -0400", hash_original_method = "18575B4AE5EB78B20BC29135C417B7D0", hash_generated_method = "1D1456161322FC7023EBF5038D6C13EA")
                        //DSFIXME:  CODE0002: Requires DSC value to be set
                        public void remove() {
                            setIterator.remove();
                            // ---------- Original Method ----------
                            //setIterator.remove();
                        }
});
                    return (Iterator<V>)dsTaint.getTaint();
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
        return (Collection<V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.838 -0400", hash_original_method = "DEDBEBF1A9DF717B6A61BCEAEE5EB8FF", hash_generated_method = "D53FBBCF6DBD7B636DD9B368BCF21519")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    @Override
    protected Object clone() throws CloneNotSupportedException {
        AbstractMap<K, V> result;
        result = (AbstractMap<K, V>) super.clone();
        result.keySet = null;
        result.valuesCollection = null;
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //AbstractMap<K, V> result = (AbstractMap<K, V>) super.clone();
        //result.keySet = null;
        //result.valuesCollection = null;
        //return result;
    }

    
    public static class SimpleImmutableEntry<K, V> implements Map.Entry<K, V>, Serializable {
        private K key;
        private V value;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.839 -0400", hash_original_method = "33F8AD4AA392C56EA79ABB4A58A6836E", hash_generated_method = "E605418AC230E09F10B8C8FC6B1B9A4F")
        @DSModeled(DSC.SAFE)
        public SimpleImmutableEntry(K theKey, V theValue) {
            dsTaint.addTaint(theKey.dsTaint);
            dsTaint.addTaint(theValue.dsTaint);
            // ---------- Original Method ----------
            //key = theKey;
            //value = theValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.839 -0400", hash_original_method = "B328F2475798EE2AF89F33F6E7AEA482", hash_generated_method = "C65F358C2CEF5395B6C8602F2668B5D7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SimpleImmutableEntry(Map.Entry<? extends K, ? extends V> copyFrom) {
            dsTaint.addTaint(copyFrom.dsTaint);
            key = copyFrom.getKey();
            value = copyFrom.getValue();
            // ---------- Original Method ----------
            //key = copyFrom.getKey();
            //value = copyFrom.getValue();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.839 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "72E8E211F4CBB9A3E7EA7C601BF9517D")
        @DSModeled(DSC.SAFE)
        public K getKey() {
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return key;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.839 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "1716B03F3EEDEC9A8CDFDC8FCC55E236")
        @DSModeled(DSC.SAFE)
        public V getValue() {
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.840 -0400", hash_original_method = "3526712C126765AF36CB8D920CBD3B1B", hash_generated_method = "5C7438F0BECC0D16D3DEFF2F3313E787")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public V setValue(V object) {
            dsTaint.addTaint(object.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.840 -0400", hash_original_method = "5E665954E6171F76B6FD9130152FC1D9", hash_generated_method = "5577BBC94B9A5E014B1754317C0728B2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                Map.Entry<?, ?> entry;
                entry = (Map.Entry<?, ?>) object;
                boolean var11197553A07BA849DF0822783F0D5152_501804973 = ((key == null ? entry.getKey() == null : key.equals(entry
                        .getKey()))
                        && (value == null ? entry.getValue() == null : value
                                .equals(entry.getValue()))); //DSFIXME:  CODE0008: Nested ternary operator in expression
            } //End block
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.840 -0400", hash_original_method = "6416487D313DFCFD3052C01ADB883217", hash_generated_method = "91D47C63E29D566E82B7A5E5C2B04FF0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int var4B5981580A705D92ADA4BF72B6E1E3C5_95915420 = ((key == null ? 0 : key.hashCode())
                    ^ (value == null ? 0 : value.hashCode())); //DSFIXME:  CODE0008: Nested ternary operator in expression
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return (key == null ? 0 : key.hashCode())
                    //^ (value == null ? 0 : value.hashCode());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.840 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "4002110D0218F85825FBB09C78ED072B")
        @DSModeled(DSC.SAFE)
        @Override
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return key + "=" + value;
        }

        
        private static final long serialVersionUID = 7138329143949025153L;
    }


    
    public static class SimpleEntry<K, V> implements Map.Entry<K, V>, Serializable {
        private K key;
        private V value;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.841 -0400", hash_original_method = "BD7301488126194D9FCD92EBDE27E89B", hash_generated_method = "C5D853CF11C60CFABEE527163B331BC2")
        @DSModeled(DSC.SAFE)
        public SimpleEntry(K theKey, V theValue) {
            dsTaint.addTaint(theKey.dsTaint);
            dsTaint.addTaint(theValue.dsTaint);
            // ---------- Original Method ----------
            //key = theKey;
            //value = theValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.841 -0400", hash_original_method = "69734A3C3A679CA95ADF7DC846433DE1", hash_generated_method = "338BB2ADC9FEADE4999D34E2C6D9DBE1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SimpleEntry(Map.Entry<? extends K, ? extends V> copyFrom) {
            dsTaint.addTaint(copyFrom.dsTaint);
            key = copyFrom.getKey();
            value = copyFrom.getValue();
            // ---------- Original Method ----------
            //key = copyFrom.getKey();
            //value = copyFrom.getValue();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.841 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "72E8E211F4CBB9A3E7EA7C601BF9517D")
        @DSModeled(DSC.SAFE)
        public K getKey() {
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return key;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.841 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "1716B03F3EEDEC9A8CDFDC8FCC55E236")
        @DSModeled(DSC.SAFE)
        public V getValue() {
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.841 -0400", hash_original_method = "123DAF07FFBE76C8EE5BD5879EB92827", hash_generated_method = "6C04AFB63E89CDE7EFCF5132A9B136AE")
        @DSModeled(DSC.SAFE)
        public V setValue(V object) {
            dsTaint.addTaint(object.dsTaint);
            V result;
            result = value;
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //V result = value;
            //value = object;
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.842 -0400", hash_original_method = "5E665954E6171F76B6FD9130152FC1D9", hash_generated_method = "20AC3143AA2E29246AD79F46210F5C8C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                Map.Entry<?, ?> entry;
                entry = (Map.Entry<?, ?>) object;
                boolean var11197553A07BA849DF0822783F0D5152_1349287207 = ((key == null ? entry.getKey() == null : key.equals(entry
                        .getKey()))
                        && (value == null ? entry.getValue() == null : value
                                .equals(entry.getValue()))); //DSFIXME:  CODE0008: Nested ternary operator in expression
            } //End block
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.842 -0400", hash_original_method = "6416487D313DFCFD3052C01ADB883217", hash_generated_method = "5B60110F9512F03866644894DC45D0A0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int var4B5981580A705D92ADA4BF72B6E1E3C5_970709554 = ((key == null ? 0 : key.hashCode())
                    ^ (value == null ? 0 : value.hashCode())); //DSFIXME:  CODE0008: Nested ternary operator in expression
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return (key == null ? 0 : key.hashCode())
                    //^ (value == null ? 0 : value.hashCode());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.842 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "4002110D0218F85825FBB09C78ED072B")
        @DSModeled(DSC.SAFE)
        @Override
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return key + "=" + value;
        }

        
        private static final long serialVersionUID = -8499721149061103585L;
    }


    
}

