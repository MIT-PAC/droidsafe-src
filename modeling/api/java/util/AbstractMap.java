/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;

import java.io.Serializable;

public abstract class AbstractMap<K, V> implements Map<K, V> {
    
    public static final int DEF_MAP_SIZE = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.575 -0400", hash_original_field = "3E8ABCE844B6A8A95397486A3899B536", hash_generated_field = "8E2B51CCF89ADF7243D25312F0ABCDAC")

    HashSet<K> keySet = new HashSet<K>();
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.575 -0400", hash_original_field = "8169AE04F2776F041E9D71005E918170", hash_generated_field = "BE71573A2BD5F9F8A42171B5E82953DE")

        AbstractList<V> valuesCollection = (AbstractList<V>)new AbstractList.SubAbstractList<V>();
    
    HashSet<Entry<K,V>> backingEntrySet = new HashSet<Entry<K,V>>();
    protected int capacity = DEF_MAP_SIZE;

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.235 -0500", hash_original_method = "38C8E9EBD98120A2B6A13CBC6F342ADF", hash_generated_method = "B1D961F5E0533851507A1609E87B76A2")
    
protected AbstractMap() {
    }
        
        public void requestCapacity(int capacity) {
            valuesCollection.requestCapacity(capacity);
            keySet.requestCapacity(capacity);
            //addTaint(capacity);
        }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.576 -0400", hash_original_method = "76EEE079F2D9B88A31C5F2E8E9C7EB92", hash_generated_method = "D04492222E27A17B4DBF52591A0F49E1")
    public void clear() {
        entrySet().clear();
        keySet.clear();
        valuesCollection.clear();
        // ---------- Original Method ----------
        //entrySet().clear();
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.576 -0400", hash_original_method = "3D741B03C8862C52B96D9B3B81701BE0", hash_generated_method = "BECB956768FEB16D2592D8DFDCE1254E")
    public boolean containsKey(Object key) {
        return keySet.contains(key);
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
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.577 -0400", hash_original_method = "D1C1AD8AFDB44AE56F4D2DF37F057E9D", hash_generated_method = "513B516F3194E91B15E22C3E95839BEC")
    public boolean containsValue(Object value) {
        return valuesCollection.contains(value);
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

    @DSComment("Abstract Method")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.244 -0500", hash_original_method = "7CBA802DA52C526436F00BC470BF1937", hash_generated_method = "53D33ED4D71E7E913FBCA82803B17B2C")
    
public abstract Set<Map.Entry<K, V>> entrySet();
    
    @DSVerified
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    protected Set<Map.Entry<K, V>> getEntrySet() {
        return backingEntrySet;
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.578 -0400", hash_original_method = "5B9317AAB202C2AFA6ECB99B62EB1150", hash_generated_method = "DBD8B1A42F9CC9FA5EA8264BA255A505")
    @Override
    public boolean equals(Object object) {
    //this needs a new implementation of get / add taint
    return this.getTaintBoolean() && object.getTaintBoolean();
       
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.579 -0400", hash_original_method = "80DED5B1493F4175A64A94324F6ABF01", hash_generated_method = "DE4E462DDFAD080821E1F2FDD12CBB2F")
    public V get(Object key) {
        //addTaint(key.getTaint());
        int keyIndex = keySet.getIndexOf(key);
        V value = valuesCollection.get(keyIndex);
        //value.addTaint(getTaint());
        return value;
        
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
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.579 -0400", hash_original_method = "64FA0B5ACB2A736D0354FE373D9CD3E5", hash_generated_method = "3CE35D33DC7EA27D168D7DB47B163C91")
    @Override
    public int hashCode() {
        return getTaintInt();
        
        // ---------- Original Method ----------
        //int result = 0;
        //Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        //while (it.hasNext()) {
            //result += it.next().hashCode();
        //}
        //return result;
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.580 -0400", hash_original_method = "296240B68F4A866C698190CF33710ED8", hash_generated_method = "19051CBE57A799DDD0D479D317B6168E")
    public boolean isEmpty() {
        return getTaintBoolean();
        // ---------- Original Method ----------
        //return size() == 0;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    //@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.240 -0400", hash_original_method = "F40A232B51CF144805B23E3A97CCF7A5", hash_generated_method = "9A0B801A8CE9D5D944144F6F2D5118B9")
    public Set<K> keySet() {
        return keySet;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.584 -0400", hash_original_method = "1AE25A34BEB4A8F08F41373ADFFCFE34", hash_generated_method = "68BBC7F50DC671ED0F56BA1A5CF63CD0")
    public V put(K key, V value) {
        //addTaint(value.getTaint());
        //addTaint(key.getTaint());
        if (DroidSafeAndroidRuntime.control) {
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1588673601 = new UnsupportedOperationException();
            //var81FA7E299EEE7F062EBFBEEF08B0464D_1588673601.addTaint(getTaint());
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_1588673601;
        }
        
        int index = keySet.getIndexOf(key);
        if (index == -1){
            keySet.add(key);
            index = size() - 1;
        }

        valuesCollection.set(index, value);
        
        backingEntrySet.setElementAt(index, new SimpleEntry(key, value));
        
        return value;
        
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     *
     * <p>This implementation iterates through {@code map}'s entry set, calling
     * {@code put()} for each.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.285 -0500", hash_original_method = "1BF9761154AA89A664F00EA3C1B1A227", hash_generated_method = "7E02F7CA54E3FC942C49F89EFE900DF7")
    
public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }
    
    protected Entry<K,V> removeFirstEntry() {
        Entry<K,V> entry = backingEntrySet.removeFirstElement();
        valuesCollection.removeFirstElement();
        keySet.removeFirstElement();
        //entry.addTaint(getTaint());
        return entry;
    }
    
    protected Entry<K,V> getFirstEntry() {
        Entry<K,V> entry = backingEntrySet.getFirstElement();
        //entry.addTaint(getTaint());
        return entry;
    }
     
    protected V getFirstValue() {
        V value = backingEntrySet.getFirstElement().getValue();
        //value.addTaint(getTaint());
        return value;
    }
    
    protected K getFirstKey() {
        K key = backingEntrySet.getFirstElement().getKey();
        //key.addTaint(getTaint());
        return key;
    }
    
    protected Entry<K,V> removeLastEntry() {
        Entry<K,V> entry = backingEntrySet.removeLastElement();
        valuesCollection.removeLastElement();
        keySet.removeLastElement();
        //entry.addTaint(getTaint());
        return entry;
    }
    
    protected Entry<K,V> getLastEntry() {
        Entry<K,V> entry = backingEntrySet.getLastElement();
        //entry.addTaint(getTaint());
        return entry;
    }
   
    protected V getLastValue() {
        V value = backingEntrySet.getLastElement().getValue();
        //value.addTaint(getTaint());
        return value;
    }
    
    protected K getLastKey() {
        K key = backingEntrySet.getLastElement().getKey();
        //key.addTaint(getTaint());
        return key;
    }
    
    protected Entry<K,V> getSomeEntry() {
        Entry<K,V> entry = backingEntrySet.getElementAt(getTaintInt());
        //entry.addTaint(getTaint());
        return entry;
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.585 -0400", hash_original_method = "DF925EC53E8E5501C52A21B969B7A962", hash_generated_method = "A8C27B378C94E544EE89D7FD0FB575DD")
    public V remove(Object key) {
       //addTaint(key.getTaint());
        
        int index = keySet.getIndexOf(key);
        if (index == -1) {
            return null;
        }
        
        backingEntrySet.removeElementAt(index);
        keySet.removeElementAt(index);

        V value = valuesCollection.getElementAt(index);
        valuesCollection.removeElementAt(index);
        //value.addTaint(getTaint());
        
        return value;
        
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
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.586 -0400", hash_original_method = "68473A1BCB9C7CDFC9C6F1089F605F26", hash_generated_method = "C7A06C4B5755155D9E19DE9DF6D4033E")
    public int size() {
        return getTaintInt();
        // ---------- Original Method ----------
        //return entrySet().size();
    }

    /**
     * {@inheritDoc}
     *
     * <p>This implementation composes a string by iterating its entry set. If
     * this map contains itself as a key or a value, the string "(this Map)"
     * will appear in its place.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    //@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.293 -0500", hash_original_method = "03506E32B26B17661064F3FFDE4F185F", hash_generated_method = "FE18E3871177E49857452EE0E11F67D8")
    
@Override public String toString() {
        if (isEmpty()) {
            return "{}";
        }

        StringBuilder buffer = new StringBuilder(size() * 28);
        buffer.append('{');
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> entry = it.next();
            Object key = entry.getKey();
            if (key != this) {
                buffer.append(key);
            } else {
                buffer.append("(this Map)");
            }
            buffer.append('=');
            Object value = entry.getValue();
            if (value != this) {
                buffer.append(value);
            } else {
                buffer.append("(this Map)");
            }
            if (it.hasNext()) {
                buffer.append(", ");
            }
        }
        buffer.append('}');
        return buffer.toString();
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    //@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.248 -0400", hash_original_method = "BE68DB72EA44A9864EFB8085A73DD13D", hash_generated_method = "FFF60DD0BB73731BB57AABB5E433364A")
    public Collection<V> values() {
        return valuesCollection;
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    //@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.589 -0400", hash_original_method = "DEDBEBF1A9DF717B6A61BCEAEE5EB8FF", hash_generated_method = "CF2AA62163C630C7B78B734803415A96")
    @SuppressWarnings("unchecked")
    @Override
    protected Object clone() throws CloneNotSupportedException {

        if (DroidSafeAndroidRuntime.control) {
            CloneNotSupportedException ex = new CloneNotSupportedException();
            //ex.addTaint(getTaint());
            throw ex; 
        }

        AbstractMap<K, V> result = (AbstractMap<K, V>) super.clone();
        result.putAll(this);
        Object varDC838461EE2FA0CA4C9BBB70A15456B0_1501740900 =         result;
        //varDC838461EE2FA0CA4C9BBB70A15456B0_1501740900.addTaint(getTaint());
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1501740900;
        // ---------- Original Method ----------
        //AbstractMap<K, V> result = (AbstractMap<K, V>) super.clone();
        //result.keySet = null;
        //result.valuesCollection = null;
        //return result;
    }
    
    public static class SimpleImmutableEntry<K, V> implements Map.Entry<K, V>, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.171 -0500", hash_original_field = "92E8B75F0019C79713630FD110ACEA3C", hash_generated_field = "3DFDD92E82A1CB0CEF7DE41ED65507D7")

        private static final long serialVersionUID = 7138329143949025153L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.174 -0500", hash_original_field = "F780C5984CF24E477CB9559E91475987", hash_generated_field = "EBAE1A8AD28B83F3F907DD83D8B82F01")

        private  K key;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.176 -0500", hash_original_field = "A7E8A049E4C72FD5713D3AFD6CBF7C08", hash_generated_field = "EEA53383AEF96F58506DEE94A549CB01")

        private  V value;

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.179 -0500", hash_original_method = "33F8AD4AA392C56EA79ABB4A58A6836E", hash_generated_method = "477085AB5BF507C37ECBC6075C8B3DDE")
        
public SimpleImmutableEntry(K theKey, V theValue) {
            key = theKey;
            value = theValue;
        }

        /**
         * Constructs an instance with the key and value of {@code copyFrom}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.182 -0500", hash_original_method = "B328F2475798EE2AF89F33F6E7AEA482", hash_generated_method = "B6065B8ED63DE61773E1F3270CC44E7D")
        
public SimpleImmutableEntry(Map.Entry<? extends K, ? extends V> copyFrom) {
            key = copyFrom.getKey();
            value = copyFrom.getValue();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        //@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.184 -0500", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "70BBB2F2B97930263570BF1F94F8248D")
        
public K getKey() {
            return key;
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_OTHERS)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.187 -0500", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "95D4F56CA118DD7517C6CA2E4A00FE92")
        
public V getValue() {
            return value;
        }
                
@DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        //@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.591 -0400", hash_original_method = "3526712C126765AF36CB8D920CBD3B1B", hash_generated_method = "EB9F930298727FE038FD0E2F1F331E96")
        public V setValue(V object) {
            if (DroidSafeAndroidRuntime.control) {
                UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_2054359486 = new UnsupportedOperationException();
                //var81FA7E299EEE7F062EBFBEEF08B0464D_2054359486.addTaint(getTaint());
                throw var81FA7E299EEE7F062EBFBEEF08B0464D_2054359486;
            }
            //addTaint(object.getTaint());
            value = object;
            return object;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }
                
@DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.591 -0400", hash_original_method = "5E665954E6171F76B6FD9130152FC1D9", hash_generated_method = "1FF7867B1DC9E467B3C710E28BD73150")
        @Override
        public boolean equals(Object object) {
            addTaint(object.getTaint());
            if(object instanceof Map.Entry)            
            {
                Map.Entry<?, ?> entry = (Map.Entry<?, ?>) object;
                Object retTaint = new Object();
                retTaint.addTaint(getTaint());
                retTaint.addTaint(object.getTaint());
                return retTaint.getTaintBoolean();
            } //End block

            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_900360818 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_900360818;

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

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.195 -0500", hash_original_method = "6416487D313DFCFD3052C01ADB883217", hash_generated_method = "5C9EDD5B771CD9A47AFF55CF54BFB883")
        
@Override public int hashCode() {
            return (key == null ? 0 : key.hashCode())
                    ^ (value == null ? 0 : value.hashCode());
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.197 -0500", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "EDF37FB38FD11F88857163FA6E2BE31B")
        
@Override public String toString() {
            return key + "=" + value;
        }
    }
    
    public static class SimpleEntry<K, V> implements Map.Entry<K, V>, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.203 -0500", hash_original_field = "53846B0837C4D2B0AB1EE1C9C9E5860F", hash_generated_field = "9B9E5FFE746EC28EB67AAB64BC8691E2")

        private static final long serialVersionUID = -8499721149061103585L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.206 -0500", hash_original_field = "F780C5984CF24E477CB9559E91475987", hash_generated_field = "EBAE1A8AD28B83F3F907DD83D8B82F01")

        private  K key;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.208 -0500", hash_original_field = "A7E8A049E4C72FD5713D3AFD6CBF7C08", hash_generated_field = "EEA53383AEF96F58506DEE94A549CB01")

        private V value;

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.211 -0500", hash_original_method = "BD7301488126194D9FCD92EBDE27E89B", hash_generated_method = "211E37AD636ECD6C0C3BF17FD5D672B9")
        
public SimpleEntry(K theKey, V theValue) {
            key = theKey;
            value = theValue;
        }

        /**
         * Constructs an instance with the key and value of {@code copyFrom}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.214 -0500", hash_original_method = "69734A3C3A679CA95ADF7DC846433DE1", hash_generated_method = "7BCF36A82CC3D79CBED655755AC2ABF0")
        
public SimpleEntry(Map.Entry<? extends K, ? extends V> copyFrom) {
            key = copyFrom.getKey();
            value = copyFrom.getValue();
        }
                
@DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        //@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.593 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "DED2DCB7D9AC2A45C93F999F67F3F5F9")
        public K getKey() {
    //key.addTaint(getTaint());
             return key;
            //return key;
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_OTHERS)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.219 -0500", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "95D4F56CA118DD7517C6CA2E4A00FE92")
        
public V getValue() {
            return value;
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.222 -0500", hash_original_method = "123DAF07FFBE76C8EE5BD5879EB92827", hash_generated_method = "F9467D3B60D7F9589C17103B5B4486CB")
        
public V setValue(V object) {
            V result = value;
            value = object;
            return result;
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.224 -0500", hash_original_method = "5E665954E6171F76B6FD9130152FC1D9", hash_generated_method = "905555CEA4EF740508EE8D4A3655FE25")
        
@Override public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object instanceof Map.Entry) {
                Map.Entry<?, ?> entry = (Map.Entry<?, ?>) object;
                return (key == null ? entry.getKey() == null : key.equals(entry
                        .getKey()))
                        && (value == null ? entry.getValue() == null : value
                                .equals(entry.getValue()));
            }
            return false;
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.227 -0500", hash_original_method = "6416487D313DFCFD3052C01ADB883217", hash_generated_method = "5C9EDD5B771CD9A47AFF55CF54BFB883")
        
@Override public int hashCode() {
            return (key == null ? 0 : key.hashCode())
                    ^ (value == null ? 0 : value.hashCode());
        }
                
@DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.595 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "74F4BFB372D889C3491F29BAD76B35C1")
        @Override
        public String toString() {
String varFE698C13EFD83B87FAF2DC2AB0874271_1884902144 =             key + "=" + value;
//varFE698C13EFD83B87FAF2DC2AB0874271_1884902144.addTaint(getTaint());
            return varFE698C13EFD83B87FAF2DC2AB0874271_1884902144;
            // ---------- Original Method ----------
            //return key + "=" + value;
        }
    }
    
}

