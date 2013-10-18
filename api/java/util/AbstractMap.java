package java.util;

// Droidsafe Imports
import droidsafe.annotations.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;

import java.io.Serializable;

public abstract class AbstractMap<K, V> implements Map<K, V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.575 -0400", hash_original_field = "3E8ABCE844B6A8A95397486A3899B536", hash_generated_field = "8E2B51CCF89ADF7243D25312F0ABCDAC")

    HashSet<K> keySet = new HashSet<K>();
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.575 -0400", hash_original_field = "8169AE04F2776F041E9D71005E918170", hash_generated_field = "BE71573A2BD5F9F8A42171B5E82953DE")

    AbstractList<V> valuesCollection = (AbstractList<V>)AbstractList.newSimpleList();
    
    HashSet<Entry<K,V>> backingEntrySet = new HashSet<Entry<K,V>>();
    
    public static final int DEF_MAP_SIZE = 16;
    protected int capacity = DEF_MAP_SIZE;
    
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.575 -0400", hash_original_method = "38C8E9EBD98120A2B6A13CBC6F342ADF", hash_generated_method = "BA1BD3AE70CC5BFD1550DE98F5395666")
    protected  AbstractMap() {
        // ---------- Original Method ----------
    }

        @DSModeled(DSC.BAN)
        public void requestCapacity(int capacity) {
            valuesCollection.requestCapacity(capacity);
            keySet.requestCapacity(capacity);
            addTaint(capacity);
        }
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.576 -0400", hash_original_method = "76EEE079F2D9B88A31C5F2E8E9C7EB92", hash_generated_method = "D04492222E27A17B4DBF52591A0F49E1")
    public void clear() {
        entrySet().clear();
        keySet.clear();
        valuesCollection.clear();
        // ---------- Original Method ----------
        //entrySet().clear();
    }

    
        @DSModeled(DSC.SAFE)
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

    
        @DSModeled(DSC.SAFE)
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

    
    public abstract Set<Map.Entry<K, V>> entrySet();
    

    @DSModeled(DSC.BAN)
    protected Set<Map.Entry<K, V>> getEntrySet() {
        return backingEntrySet;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.578 -0400", hash_original_method = "5B9317AAB202C2AFA6ECB99B62EB1150", hash_generated_method = "DBD8B1A42F9CC9FA5EA8264BA255A505")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        return getTaintBoolean();
        
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.579 -0400", hash_original_method = "80DED5B1493F4175A64A94324F6ABF01", hash_generated_method = "DE4E462DDFAD080821E1F2FDD12CBB2F")
    public V get(Object key) {
        addTaint(key.getTaint());
        int keyIndex = keySet.getIndexOf(key);
        V value = valuesCollection.get(keyIndex);
        value.addTaint(getTaint());
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

    
        @DSModeled(DSC.SAFE)
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.580 -0400", hash_original_method = "296240B68F4A866C698190CF33710ED8", hash_generated_method = "19051CBE57A799DDD0D479D317B6168E")
    public boolean isEmpty() {
        return getTaintBoolean();
        // ---------- Original Method ----------
        //return size() == 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.240 -0400", hash_original_method = "F40A232B51CF144805B23E3A97CCF7A5", hash_generated_method = "9A0B801A8CE9D5D944144F6F2D5118B9")
    public Set<K> keySet() {
        return keySet;
    }
    
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.584 -0400", hash_original_method = "1AE25A34BEB4A8F08F41373ADFFCFE34", hash_generated_method = "68BBC7F50DC671ED0F56BA1A5CF63CD0")
    public V put(K key, V value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        if (DroidSafeAndroidRuntime.control) {
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1588673601 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_1588673601.addTaint(taint);
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.585 -0400", hash_original_method = "1BF9761154AA89A664F00EA3C1B1A227", hash_generated_method = "0E9082BE17046803AA3D46E2D766E2F8")
    public void putAll(Map<? extends K, ? extends V> map) {
        addTaint(map.getTaint());
for(Map.Entry<? extends K, ? extends V> entry : map.entrySet())
        {
            put(entry.getKey(), entry.getValue());
        } //End block
        // ---------- Original Method ----------
        //for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            //put(entry.getKey(), entry.getValue());
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.585 -0400", hash_original_method = "DF925EC53E8E5501C52A21B969B7A962", hash_generated_method = "A8C27B378C94E544EE89D7FD0FB575DD")
    public V remove(Object key) {
        addTaint(key.getTaint());
        
        int index = keySet.getIndexOf(key);
        if (index == -1) {
            return null;
        }
        
        backingEntrySet.removeElementAt(index);
        keySet.removeElementAt(index);

        V value = valuesCollection.getElementAt(index);
        value.addTaint(getTaint());
        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.586 -0400", hash_original_method = "68473A1BCB9C7CDFC9C6F1089F605F26", hash_generated_method = "C7A06C4B5755155D9E19DE9DF6D4033E")
    public int size() {
        return keySet.size();
        // ---------- Original Method ----------
        //return entrySet().size();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.586 -0400", hash_original_method = "03506E32B26B17661064F3FFDE4F185F", hash_generated_method = "ABE46D8E2C215347621AA9E9717A7234")
    @Override
    public String toString() {
        if(isEmpty())        
        {
String var1F80A99BA4B69CEEA7520BE66ADA743C_1127697087 =             "{}";
            var1F80A99BA4B69CEEA7520BE66ADA743C_1127697087.addTaint(taint);
            return var1F80A99BA4B69CEEA7520BE66ADA743C_1127697087;
        } //End block
        StringBuilder buffer = new StringBuilder(size() * 28);
        buffer.append('{');
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        while
(it.hasNext())        
        {
            Map.Entry<K, V> entry = it.next();
            Object key = entry.getKey();
            if(key != this)            
            {
                buffer.append(key);
            } //End block
            else
            {
                buffer.append("(this Map)");
            } //End block
            buffer.append('=');
            Object value = entry.getValue();
            if(value != this)            
            {
                buffer.append(value);
            } //End block
            else
            {
                buffer.append("(this Map)");
            } //End block
            if(it.hasNext())            
            {
                buffer.append(", ");
            } //End block
        } //End block
        buffer.append('}');
String varD03843288D33B9E1D3062E25339ECF6D_1216113150 =         buffer.toString();
        varD03843288D33B9E1D3062E25339ECF6D_1216113150.addTaint(taint);
        return varD03843288D33B9E1D3062E25339ECF6D_1216113150;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.248 -0400", hash_original_method = "BE68DB72EA44A9864EFB8085A73DD13D", hash_generated_method = "FFF60DD0BB73731BB57AABB5E433364A")
    public Collection<V> values() {
        Collection<V> var60B0A8A6E555943126A18D312F8E04FB_154168766 =         valuesCollection;
        //var60B0A8A6E555943126A18D312F8E04FB_154168766.addTaint(getTaint());
        return var60B0A8A6E555943126A18D312F8E04FB_154168766;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.589 -0400", hash_original_method = "DEDBEBF1A9DF717B6A61BCEAEE5EB8FF", hash_generated_method = "CF2AA62163C630C7B78B734803415A96")
    @SuppressWarnings("unchecked")
    @Override
    protected Object clone() throws CloneNotSupportedException {

        if (DroidSafeAndroidRuntime.control) {
            CloneNotSupportedException ex = new CloneNotSupportedException();
            ex.addTaint(getTaint());
            throw ex; 
        }

        AbstractMap<K, V> result = (AbstractMap<K, V>) super.clone();
        result.keySet = null;
        result.valuesCollection = null;
        Object varDC838461EE2FA0CA4C9BBB70A15456B0_1501740900 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1501740900.addTaint(getTaint());
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1501740900;
        // ---------- Original Method ----------
        //AbstractMap<K, V> result = (AbstractMap<K, V>) super.clone();
        //result.keySet = null;
        //result.valuesCollection = null;
        //return result;
    }

    
    public static class SimpleImmutableEntry<K, V> implements Map.Entry<K, V>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.589 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "EBAE1A8AD28B83F3F907DD83D8B82F01")

        private K key;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.589 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "EEA53383AEF96F58506DEE94A549CB01")

        private V value;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.590 -0400", hash_original_method = "33F8AD4AA392C56EA79ABB4A58A6836E", hash_generated_method = "1A26EA514829E31B02595112305C8058")
        public  SimpleImmutableEntry(K theKey, V theValue) {
            key = theKey;
            value = theValue;
            // ---------- Original Method ----------
            //key = theKey;
            //value = theValue;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.590 -0400", hash_original_method = "B328F2475798EE2AF89F33F6E7AEA482", hash_generated_method = "C6AD03E3758C4CD95B20142655BD5CD9")
        public  SimpleImmutableEntry(Map.Entry<? extends K, ? extends V> copyFrom) {
            key = copyFrom.getKey();
            value = copyFrom.getValue();
            // ---------- Original Method ----------
            //key = copyFrom.getKey();
            //value = copyFrom.getValue();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.590 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "7053A7D020CBEDCD2DD0190E639C8788")
        public K getKey() {
            K var6A95247616A3A8B93CFF7783DABD08D4_1096555166 = key;
            var6A95247616A3A8B93CFF7783DABD08D4_1096555166.addTaint(taint);
            return var6A95247616A3A8B93CFF7783DABD08D4_1096555166;
            // ---------- Original Method ----------
            //return key;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.591 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "D0589D508859854ECE7BDAA59BFD723C")
        public V getValue() {
            V varAF280DA2BC37D8BE783D8499160168DE_2088121448 = value;
            varAF280DA2BC37D8BE783D8499160168DE_2088121448.addTaint(taint);
            return varAF280DA2BC37D8BE783D8499160168DE_2088121448;
            // ---------- Original Method ----------
            //return value;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.591 -0400", hash_original_method = "3526712C126765AF36CB8D920CBD3B1B", hash_generated_method = "EB9F930298727FE038FD0E2F1F331E96")
        public V setValue(V object) {
            if (DroidSafeAndroidRuntime.control) {
                UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_2054359486 = new UnsupportedOperationException();
                var81FA7E299EEE7F062EBFBEEF08B0464D_2054359486.addTaint(getTaint());
                throw var81FA7E299EEE7F062EBFBEEF08B0464D_2054359486;
            }
            addTaint(object.getTaint());
            value = object;
            return object;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
                @DSModeled(DSC.SAFE)
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.592 -0400", hash_original_method = "6416487D313DFCFD3052C01ADB883217", hash_generated_method = "D86799DE423316A82C36A0BA527AC967")
        @Override
        public int hashCode() {
            int var6426FEC1614D5FE74370608AA1AC68B8_2115271755 = ((key == null ? 0 : key.hashCode())
                    ^ (value == null ? 0 : value.hashCode()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1639644516 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1639644516;
            // ---------- Original Method ----------
            //return (key == null ? 0 : key.hashCode())
                    //^ (value == null ? 0 : value.hashCode());
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.592 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "0CDE96E7192FEDE1B1E1BE9446B00F63")
        @Override
        public String toString() {
String varFE698C13EFD83B87FAF2DC2AB0874271_1452541569 =             key + "=" + value;
            varFE698C13EFD83B87FAF2DC2AB0874271_1452541569.addTaint(taint);
            return varFE698C13EFD83B87FAF2DC2AB0874271_1452541569;
            // ---------- Original Method ----------
            //return key + "=" + value;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.592 -0400", hash_original_field = "0FB41B94E91231F1583771B8C0C0C696", hash_generated_field = "3DFDD92E82A1CB0CEF7DE41ED65507D7")

        private static final long serialVersionUID = 7138329143949025153L;
    }


    
    public static class SimpleEntry<K, V> implements Map.Entry<K, V>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.592 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "EBAE1A8AD28B83F3F907DD83D8B82F01")

        private K key;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.592 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "EEA53383AEF96F58506DEE94A549CB01")

        private V value;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.593 -0400", hash_original_method = "BD7301488126194D9FCD92EBDE27E89B", hash_generated_method = "6DD3ADB0E0C9AC93F8E4466B16A19993")
        public  SimpleEntry(K theKey, V theValue) {
            key = theKey;
            value = theValue;
            // ---------- Original Method ----------
            //key = theKey;
            //value = theValue;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.593 -0400", hash_original_method = "69734A3C3A679CA95ADF7DC846433DE1", hash_generated_method = "54A51761FD45C24B5F05A70D91586172")
        public  SimpleEntry(Map.Entry<? extends K, ? extends V> copyFrom) {
            key = copyFrom.getKey();
            value = copyFrom.getValue();
            // ---------- Original Method ----------
            //key = copyFrom.getKey();
            //value = copyFrom.getValue();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.593 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "DED2DCB7D9AC2A45C93F999F67F3F5F9")
        public K getKey() {
             key.addTaint(getTaint());
             return key;
            //return key;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.594 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "216C7B5B26FAEF2C00F428578E4A7BDC")
        public V getValue() {
V varAF280DA2BC37D8BE783D8499160168DE_583848597 =             value;
            varAF280DA2BC37D8BE783D8499160168DE_583848597.addTaint(taint);
            return varAF280DA2BC37D8BE783D8499160168DE_583848597;
            // ---------- Original Method ----------
            //return value;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.594 -0400", hash_original_method = "123DAF07FFBE76C8EE5BD5879EB92827", hash_generated_method = "D46BA4A0C4959C37DCA67748CB1A6F02")
        public V setValue(V object) {
            V result = value;
            value = object;
V varDC838461EE2FA0CA4C9BBB70A15456B0_86814009 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_86814009.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_86814009;
            // ---------- Original Method ----------
            //V result = value;
            //value = object;
            //return result;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.595 -0400", hash_original_method = "5E665954E6171F76B6FD9130152FC1D9", hash_generated_method = "F93344D954B9D2FDBA33A1EBFA8D6AC4")
        @Override
        public boolean equals(Object object) {
            addTaint(object.getTaint());
            if(this == object)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1685467876 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_206369416 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_206369416;
            } //End block
            if(object instanceof Map.Entry)            
            {
                Map.Entry<?, ?> entry = (Map.Entry<?, ?>) object;
                boolean varFDE4007C31A825095FEA758AC6BF92FF_974019923 = ((key == null ? entry.getKey() == null : key.equals(entry
                        .getKey()))
                        && (value == null ? entry.getValue() == null : value
                                .equals(entry.getValue())));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_313456890 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_313456890;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1384144989 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1325361564 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1325361564;
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.595 -0400", hash_original_method = "6416487D313DFCFD3052C01ADB883217", hash_generated_method = "8FBF3A2345490BCA3E128CD5FBED18DE")
        @Override
        public int hashCode() {
            int var6426FEC1614D5FE74370608AA1AC68B8_579029383 = ((key == null ? 0 : key.hashCode())
                    ^ (value == null ? 0 : value.hashCode()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_724379253 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_724379253;
            // ---------- Original Method ----------
            //return (key == null ? 0 : key.hashCode())
                    //^ (value == null ? 0 : value.hashCode());
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.595 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "74F4BFB372D889C3491F29BAD76B35C1")
        @Override
        public String toString() {
String varFE698C13EFD83B87FAF2DC2AB0874271_1884902144 =             key + "=" + value;
            varFE698C13EFD83B87FAF2DC2AB0874271_1884902144.addTaint(getTaint());
            return varFE698C13EFD83B87FAF2DC2AB0874271_1884902144;
            // ---------- Original Method ----------
            //return key + "=" + value;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.596 -0400", hash_original_field = "6740671D10922D6DCB5AFF41C09E8C7B", hash_generated_field = "9B9E5FFE746EC28EB67AAB64BC8691E2")

        private static final long serialVersionUID = -8499721149061103585L;
    }
    
}

