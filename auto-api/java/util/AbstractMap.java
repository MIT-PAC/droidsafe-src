package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.Serializable;

public abstract class AbstractMap<K, V> implements Map<K, V> {
    Set<K> keySet;
    Collection<V> valuesCollection;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.294 -0400", hash_original_method = "38C8E9EBD98120A2B6A13CBC6F342ADF", hash_generated_method = "4C97DB92D08D9D21F80276D6713DCC64")
    @DSModeled(DSC.SAFE)
    protected AbstractMap() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.294 -0400", hash_original_method = "76EEE079F2D9B88A31C5F2E8E9C7EB92", hash_generated_method = "6C7AD1C868E7A54754274FDDB79EE677")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clear() {
        entrySet().clear();
        // ---------- Original Method ----------
        //entrySet().clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.295 -0400", hash_original_method = "3D741B03C8862C52B96D9B3B81701BE0", hash_generated_method = "A98FEA70F63BEC2FF703E6F67F5E284F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsKey(Object key) {
        dsTaint.addTaint(key.dsTaint);
        Iterator<Map.Entry<K, V>> it;
        it = entrySet().iterator();
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1807515287 = (it.hasNext());
                {
                    {
                        boolean var336751FB500C73D2E78ACA4F990236DD_1483957149 = (key.equals(it.next().getKey()));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1421048899 = (it.hasNext());
                {
                    {
                        boolean varF8E9FE1C2FF7A3716E9DE49769E3ED8E_75414123 = (it.next().getKey() == null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.295 -0400", hash_original_method = "D1C1AD8AFDB44AE56F4D2DF37F057E9D", hash_generated_method = "D1006E07D0D8C9BDE958E25C3388BBB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsValue(Object value) {
        dsTaint.addTaint(value.dsTaint);
        Iterator<Map.Entry<K, V>> it;
        it = entrySet().iterator();
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_93086705 = (it.hasNext());
                {
                    {
                        boolean var2840902430CC9CE595E44E3BC99DC210_1648531982 = (value.equals(it.next().getValue()));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_414822969 = (it.hasNext());
                {
                    {
                        boolean var447D2FB852C22F3FC7BB27E177199524_1068404884 = (it.next().getValue() == null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.295 -0400", hash_original_method = "5B9317AAB202C2AFA6ECB99B62EB1150", hash_generated_method = "2435E06563CDE85F16C5F6209E9200E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        {
            Map<?, ?> map;
            map = (Map<?, ?>) object;
            {
                boolean var17E93156AEDB9EC4C0BE0F9FC6995057_1031732449 = (size() != map.size());
            } //End collapsed parenthetic
            try 
            {
                {
                    Iterator<Entry<K, V>> seatecAstronomy42 = entrySet().iterator();
                    seatecAstronomy42.hasNext();
                    Entry<K, V> entry = seatecAstronomy42.next();
                    {
                        K key;
                        key = entry.getKey();
                        V mine;
                        mine = entry.getValue();
                        Object theirs;
                        theirs = map.get(key);
                        {
                            {
                                boolean varE9FDF34CB553A188B1AB044FFF7E6F9B_627958528 = (theirs != null || !map.containsKey(key));
                            } //End collapsed parenthetic
                        } //End block
                        {
                            boolean varFC1E0BD092353CAAE827D7D85269DF68_485267495 = (!mine.equals(theirs));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.295 -0400", hash_original_method = "80DED5B1493F4175A64A94324F6ABF01", hash_generated_method = "EE37453DC630F2C36D50A59D27FF3EA9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public V get(Object key) {
        dsTaint.addTaint(key.dsTaint);
        Iterator<Map.Entry<K, V>> it;
        it = entrySet().iterator();
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_295269055 = (it.hasNext());
                {
                    Map.Entry<K, V> entry;
                    entry = it.next();
                    {
                        boolean varF16E55D9A798E58C2D063C16A4BD00B9_1982718637 = (key.equals(entry.getKey()));
                        {
                            V var4E1F40FF31F2D73819A604B313C40C8C_1248224092 = (entry.getValue());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1423248904 = (it.hasNext());
                {
                    Map.Entry<K, V> entry;
                    entry = it.next();
                    {
                        boolean varAAAB7182D9FFD9762DBAE32CE15E7BF0_1955467626 = (entry.getKey() == null);
                        {
                            V var4E1F40FF31F2D73819A604B313C40C8C_2006008994 = (entry.getValue());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.295 -0400", hash_original_method = "64FA0B5ACB2A736D0354FE373D9CD3E5", hash_generated_method = "65ED402DD641C730F703B965C9A5C69F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int result;
        result = 0;
        Iterator<Map.Entry<K, V>> it;
        it = entrySet().iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1160990613 = (it.hasNext());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.295 -0400", hash_original_method = "296240B68F4A866C698190CF33710ED8", hash_generated_method = "85DE953A0679543CF1AF6F1467F4BEA2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEmpty() {
        boolean var5E7C4FBBEC9A5754B20CB85881048CD5_1464421343 = (size() == 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return size() == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.296 -0400", hash_original_method = "F40A232B51CF144805B23E3A97CCF7A5", hash_generated_method = "6EFEC1EC0EABD867006B17D3A736F972")
    @DSModeled(DSC.SAFE)
    public Set<K> keySet() {
        {
            keySet = new AbstractSet<K>() {
                @Override public boolean contains(Object object) {
                    return containsKey(object);
                }
                @Override public int size() {
                    return AbstractMap.this.size();
                }
                @Override public Iterator<K> iterator() {
                    return new Iterator<K>() {
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
                }
            };
        } //End block
        return (Set<K>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.296 -0400", hash_original_method = "1AE25A34BEB4A8F08F41373ADFFCFE34", hash_generated_method = "9B6FF17B8833DF1797B483D608022BD8")
    @DSModeled(DSC.SAFE)
    public V put(K key, V value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        throw new UnsupportedOperationException();
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.296 -0400", hash_original_method = "1BF9761154AA89A664F00EA3C1B1A227", hash_generated_method = "A0CD77E178FC31917279DFE3744F87DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void putAll(Map <? extends K, ? extends V> map) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.296 -0400", hash_original_method = "DF925EC53E8E5501C52A21B969B7A962", hash_generated_method = "D286FE58C676F89A720741F3A7AAC9C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public V remove(Object key) {
        dsTaint.addTaint(key.dsTaint);
        Iterator<Map.Entry<K, V>> it;
        it = entrySet().iterator();
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_41242136 = (it.hasNext());
                {
                    Map.Entry<K, V> entry;
                    entry = it.next();
                    {
                        boolean varF16E55D9A798E58C2D063C16A4BD00B9_584873550 = (key.equals(entry.getKey()));
                        {
                            it.remove();
                            V var4E1F40FF31F2D73819A604B313C40C8C_1941315469 = (entry.getValue());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_2744546 = (it.hasNext());
                {
                    Map.Entry<K, V> entry;
                    entry = it.next();
                    {
                        boolean varAAAB7182D9FFD9762DBAE32CE15E7BF0_913650569 = (entry.getKey() == null);
                        {
                            it.remove();
                            V var4E1F40FF31F2D73819A604B313C40C8C_485077729 = (entry.getValue());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.296 -0400", hash_original_method = "68473A1BCB9C7CDFC9C6F1089F605F26", hash_generated_method = "F74C425C10C6D15BA421ADDBD3EFEB93")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int size() {
        int var7F32C43E8079B6AEF852C4A760F273DE_683591346 = (entrySet().size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return entrySet().size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.296 -0400", hash_original_method = "03506E32B26B17661064F3FFDE4F185F", hash_generated_method = "187239FB10DDEB06400DCFF8D6E9C866")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        {
            boolean var8697D8FD88387502770F7E34BAFBCF5A_796561337 = (isEmpty());
        } //End collapsed parenthetic
        StringBuilder buffer;
        buffer = new StringBuilder(size() * 28);
        buffer.append('{');
        Iterator<Map.Entry<K, V>> it;
        it = entrySet().iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_2099939262 = (it.hasNext());
            {
                Map.Entry<K, V> entry;
                entry = it.next();
                Object key;
                key = entry.getKey();
                {
                    buffer.append(key);
                } //End block
                {
                    buffer.append("(this Map)");
                } //End block
                buffer.append('=');
                Object value;
                value = entry.getValue();
                {
                    buffer.append(value);
                } //End block
                {
                    buffer.append("(this Map)");
                } //End block
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_103232585 = (it.hasNext());
                    {
                        buffer.append(", ");
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        buffer.append('}');
        String varAD28D02EB1C6982A5710D014292E1955_1028873391 = (buffer.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.296 -0400", hash_original_method = "BE68DB72EA44A9864EFB8085A73DD13D", hash_generated_method = "4204BA47CB2619D558789B472EF9EC45")
    @DSModeled(DSC.SAFE)
    public Collection<V> values() {
        {
            valuesCollection = new AbstractCollection<V>() {
                @Override public int size() {
                    return AbstractMap.this.size();
                }
                @Override public boolean contains(Object object) {
                    return containsValue(object);
                }
                @Override public Iterator<V> iterator() {
                    return new Iterator<V>() {
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
                }
            };
        } //End block
        return (Collection<V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.297 -0400", hash_original_method = "DEDBEBF1A9DF717B6A61BCEAEE5EB8FF", hash_generated_method = "B89B893EBD896179F2B18C2FFCC6766C")
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
        private static final long serialVersionUID = 7138329143949025153L;
        private final K key;
        private final V value;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.297 -0400", hash_original_method = "33F8AD4AA392C56EA79ABB4A58A6836E", hash_generated_method = "3728BB30B096230C731D521F25DC9992")
        @DSModeled(DSC.SAFE)
        public SimpleImmutableEntry(K theKey, V theValue) {
            dsTaint.addTaint(theKey.dsTaint);
            dsTaint.addTaint(theValue.dsTaint);
            // ---------- Original Method ----------
            //key = theKey;
            //value = theValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.297 -0400", hash_original_method = "B328F2475798EE2AF89F33F6E7AEA482", hash_generated_method = "1A3EBAC771CFD6C9B1B6A6CEF341813E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SimpleImmutableEntry(Map.Entry<? extends K, ? extends V> copyFrom) {
            dsTaint.addTaint(copyFrom.dsTaint);
            key = copyFrom.getKey();
            value = copyFrom.getValue();
            // ---------- Original Method ----------
            //key = copyFrom.getKey();
            //value = copyFrom.getValue();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.297 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "8797862276BB802C39794187DB372D9F")
        @DSModeled(DSC.SAFE)
        public K getKey() {
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return key;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.297 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "296B8D2ED309B616704C60943FB1CB71")
        @DSModeled(DSC.SAFE)
        public V getValue() {
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.297 -0400", hash_original_method = "3526712C126765AF36CB8D920CBD3B1B", hash_generated_method = "AE408730122C13BA33170C1C80E22EFB")
        @DSModeled(DSC.SAFE)
        public V setValue(V object) {
            dsTaint.addTaint(object.dsTaint);
            throw new UnsupportedOperationException();
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.297 -0400", hash_original_method = "5E665954E6171F76B6FD9130152FC1D9", hash_generated_method = "BA8282760C475D297365994D0E08986D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                Map.Entry<?, ?> entry;
                entry = (Map.Entry<?, ?>) object;
                boolean var11197553A07BA849DF0822783F0D5152_609062795 = ((key == null ? entry.getKey() == null : key.equals(entry
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.297 -0400", hash_original_method = "6416487D313DFCFD3052C01ADB883217", hash_generated_method = "4BDFB1E957940E4DD27AE1AE60B760DE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int var4B5981580A705D92ADA4BF72B6E1E3C5_2038910200 = ((key == null ? 0 : key.hashCode())
                    ^ (value == null ? 0 : value.hashCode())); //DSFIXME:  CODE0008: Nested ternary operator in expression
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return (key == null ? 0 : key.hashCode())
                    //^ (value == null ? 0 : value.hashCode());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.297 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "D9CF5F2E91FFBBAC087C0CF3658AE8DF")
        @DSModeled(DSC.SAFE)
        @Override
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return key + "=" + value;
        }

        
    }


    
    public static class SimpleEntry<K, V> implements Map.Entry<K, V>, Serializable {
        private static final long serialVersionUID = -8499721149061103585L;
        private final K key;
        private V value;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.297 -0400", hash_original_method = "BD7301488126194D9FCD92EBDE27E89B", hash_generated_method = "EFBD8BC73C29FF68463D4388D5A5EC7F")
        @DSModeled(DSC.SAFE)
        public SimpleEntry(K theKey, V theValue) {
            dsTaint.addTaint(theKey.dsTaint);
            dsTaint.addTaint(theValue.dsTaint);
            // ---------- Original Method ----------
            //key = theKey;
            //value = theValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.297 -0400", hash_original_method = "69734A3C3A679CA95ADF7DC846433DE1", hash_generated_method = "3CA05CCAD8990374D794D3B7A69B2649")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SimpleEntry(Map.Entry<? extends K, ? extends V> copyFrom) {
            dsTaint.addTaint(copyFrom.dsTaint);
            key = copyFrom.getKey();
            value = copyFrom.getValue();
            // ---------- Original Method ----------
            //key = copyFrom.getKey();
            //value = copyFrom.getValue();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.297 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "8797862276BB802C39794187DB372D9F")
        @DSModeled(DSC.SAFE)
        public K getKey() {
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return key;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.297 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "296B8D2ED309B616704C60943FB1CB71")
        @DSModeled(DSC.SAFE)
        public V getValue() {
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.298 -0400", hash_original_method = "123DAF07FFBE76C8EE5BD5879EB92827", hash_generated_method = "D7D161FD7F5A353B9D0AF473B6320B0F")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.298 -0400", hash_original_method = "5E665954E6171F76B6FD9130152FC1D9", hash_generated_method = "05EEC0FB693DF60C493843941DF842FD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                Map.Entry<?, ?> entry;
                entry = (Map.Entry<?, ?>) object;
                boolean var11197553A07BA849DF0822783F0D5152_1197087469 = ((key == null ? entry.getKey() == null : key.equals(entry
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.298 -0400", hash_original_method = "6416487D313DFCFD3052C01ADB883217", hash_generated_method = "98308815252509A81629BB3967E3DAB7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int var4B5981580A705D92ADA4BF72B6E1E3C5_28482820 = ((key == null ? 0 : key.hashCode())
                    ^ (value == null ? 0 : value.hashCode())); //DSFIXME:  CODE0008: Nested ternary operator in expression
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return (key == null ? 0 : key.hashCode())
                    //^ (value == null ? 0 : value.hashCode());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.298 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "D9CF5F2E91FFBBAC087C0CF3658AE8DF")
        @DSModeled(DSC.SAFE)
        @Override
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return key + "=" + value;
        }

        
    }


    
}


