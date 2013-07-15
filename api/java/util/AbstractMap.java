package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;

public abstract class AbstractMap<K, V> implements Map<K, V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.230 -0400", hash_original_field = "3E8ABCE844B6A8A95397486A3899B536", hash_generated_field = "8E2B51CCF89ADF7243D25312F0ABCDAC")

    Set<K> keySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.230 -0400", hash_original_field = "8169AE04F2776F041E9D71005E918170", hash_generated_field = "BE71573A2BD5F9F8A42171B5E82953DE")

    Collection<V> valuesCollection;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.230 -0400", hash_original_method = "38C8E9EBD98120A2B6A13CBC6F342ADF", hash_generated_method = "BA1BD3AE70CC5BFD1550DE98F5395666")
    protected  AbstractMap() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.230 -0400", hash_original_method = "76EEE079F2D9B88A31C5F2E8E9C7EB92", hash_generated_method = "D04492222E27A17B4DBF52591A0F49E1")
    public void clear() {
        entrySet().clear();
        // ---------- Original Method ----------
        //entrySet().clear();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.231 -0400", hash_original_method = "3D741B03C8862C52B96D9B3B81701BE0", hash_generated_method = "E7C965AD6ACEF760354E01FCEBF965AD")
    public boolean containsKey(Object key) {
        addTaint(key.getTaint());
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
    if(key != null)        
        {
            while
(it.hasNext())            
            {
    if(key.equals(it.next().getKey()))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_1099453565 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2105080955 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_2105080955;
                } //End block
            } //End block
        } //End block
        else
        {
            while
(it.hasNext())            
            {
    if(it.next().getKey() == null)                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_1649380619 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1941706527 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1941706527;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1454139052 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1340685774 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1340685774;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.232 -0400", hash_original_method = "D1C1AD8AFDB44AE56F4D2DF37F057E9D", hash_generated_method = "F6601BD0BA8093CAF98849B0F9A08136")
    public boolean containsValue(Object value) {
        addTaint(value.getTaint());
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
    if(value != null)        
        {
            while
(it.hasNext())            
            {
    if(value.equals(it.next().getValue()))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_596447610 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_246654310 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_246654310;
                } //End block
            } //End block
        } //End block
        else
        {
            while
(it.hasNext())            
            {
    if(it.next().getValue() == null)                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_1520119712 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_863888096 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_863888096;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_894213121 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2103497839 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2103497839;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.233 -0400", hash_original_method = "5B9317AAB202C2AFA6ECB99B62EB1150", hash_generated_method = "E0A809A3F1F0FB391983D6679F6C9DE0")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
    if(this == object)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1377233797 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1456196726 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1456196726;
        } //End block
    if(object instanceof Map)        
        {
            Map<?, ?> map = (Map<?, ?>) object;
    if(size() != map.size())            
            {
                boolean var68934A3E9455FA72420237EB05902327_530181060 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_700673839 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_700673839;
            } //End block
            try 
            {
for(Entry<K, V> entry : entrySet())
                {
                    K key = entry.getKey();
                    V mine = entry.getValue();
                    Object theirs = map.get(key);
    if(mine == null)                    
                    {
    if(theirs != null || !map.containsKey(key))                        
                        {
                            boolean var68934A3E9455FA72420237EB05902327_1005843996 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1682569489 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1682569489;
                        } //End block
                    } //End block
                    else
    if(!mine.equals(theirs))                    
                    {
                        boolean var68934A3E9455FA72420237EB05902327_593154358 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1279753694 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1279753694;
                    } //End block
                } //End block
            } //End block
            catch (NullPointerException ignored)
            {
                boolean var68934A3E9455FA72420237EB05902327_1899622757 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1688331535 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1688331535;
            } //End block
            catch (ClassCastException ignored)
            {
                boolean var68934A3E9455FA72420237EB05902327_8963103 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1256767467 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1256767467;
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_590948338 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1788234000 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1788234000;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1824046551 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1729632788 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1729632788;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.234 -0400", hash_original_method = "80DED5B1493F4175A64A94324F6ABF01", hash_generated_method = "4213DC07AF80C266F31E0523628DB000")
    public V get(Object key) {
        addTaint(key.getTaint());
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
    if(key != null)        
        {
            while
(it.hasNext())            
            {
                Map.Entry<K, V> entry = it.next();
    if(key.equals(entry.getKey()))                
                {
V var4A887D14956ECA386DDED2772C1F523B_1193053014 =                     entry.getValue();
                    var4A887D14956ECA386DDED2772C1F523B_1193053014.addTaint(taint);
                    return var4A887D14956ECA386DDED2772C1F523B_1193053014;
                } //End block
            } //End block
        } //End block
        else
        {
            while
(it.hasNext())            
            {
                Map.Entry<K, V> entry = it.next();
    if(entry.getKey() == null)                
                {
V var4A887D14956ECA386DDED2772C1F523B_1275357855 =                     entry.getValue();
                    var4A887D14956ECA386DDED2772C1F523B_1275357855.addTaint(taint);
                    return var4A887D14956ECA386DDED2772C1F523B_1275357855;
                } //End block
            } //End block
        } //End block
V var540C13E9E156B687226421B24F2DF178_93322948 =         null;
        var540C13E9E156B687226421B24F2DF178_93322948.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_93322948;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.235 -0400", hash_original_method = "64FA0B5ACB2A736D0354FE373D9CD3E5", hash_generated_method = "FD53FD653C54C72010E79D8E24D978DF")
    @Override
    public int hashCode() {
        int result = 0;
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        while
(it.hasNext())        
        {
            result += it.next().hashCode();
        } //End block
        int varB4A88417B3D0170D754C647C30B7216A_1032827225 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1452649804 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1452649804;
        // ---------- Original Method ----------
        //int result = 0;
        //Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        //while (it.hasNext()) {
            //result += it.next().hashCode();
        //}
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.235 -0400", hash_original_method = "296240B68F4A866C698190CF33710ED8", hash_generated_method = "89E8AFAB37597CBD5054EBE7AB4BC0C1")
    public boolean isEmpty() {
        boolean var5BD3446419BAE72903C4742BF777F0E0_884518028 = (size() == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_122343884 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_122343884;
        // ---------- Original Method ----------
        //return size() == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.240 -0400", hash_original_method = "F40A232B51CF144805B23E3A97CCF7A5", hash_generated_method = "9A0B801A8CE9D5D944144F6F2D5118B9")
    public Set<K> keySet() {
    if(keySet == null)        
        {
            keySet = new AbstractSet<K>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.237 -0400", hash_original_method = "D170B4D54B17306878DDF90A529C04ED", hash_generated_method = "FDAA696C7ED7CE45784C393C32AA0AAE")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            boolean varF42ECC5119C86E67C012437242277954_2089300521 = (containsKey(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_877633448 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_877633448;
            // ---------- Original Method ----------
            //return containsKey(object);
        }
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.237 -0400", hash_original_method = "3B94EB65D5DE623B3E08A5638A43D0EB", hash_generated_method = "8A23B0CE787503A671856DBDDA1AA29A")
        @Override
        public int size() {
            int var41C7EAB6B6C31A7460E79C2D82CCC7A9_348206438 = (AbstractMap.this.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1955769991 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1955769991;
            // ---------- Original Method ----------
            //return AbstractMap.this.size();
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.239 -0400", hash_original_method = "4DAF499E5ADBF0012E8FC0F4014839E7", hash_generated_method = "18FF75BD21A0BA1167FFC9E9018BD346")
        @Override
        public Iterator<K> iterator() {
Iterator<K> var4B7F8C61468541A26B3FAC55056B6833_1559186866 =             new Iterator<K>() {            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.238 -0400", hash_original_field = "04F401FA3821AC3FF2BCE0E3D156C68B", hash_generated_field = "0C09F8E15A29D51A05F808D7E7E66C06")
            Iterator<Map.Entry<K, V>> setIterator = entrySet().iterator();
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.238 -0400", hash_original_method = "213B6F6BF550680DB14A6264553A9606", hash_generated_method = "ACB963D682EF88D926D2B80F10997625")
            public boolean hasNext() {
                boolean var148F57DEC6206B4324A475DF6F64D64C_691562238 = (setIterator.hasNext());
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1699861455 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1699861455;
                // ---------- Original Method ----------
                //return setIterator.hasNext();
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.238 -0400", hash_original_method = "2ACAF5E8045DB2C1E5B1B79533A99B49", hash_generated_method = "4EF12DBA947241D9C30175FFA733A8DB")
            public K next() {
K var617A45C7DCCD8863F5C5FEA71DA0D3FB_1568056615 =                 setIterator.next().getKey();
                var617A45C7DCCD8863F5C5FEA71DA0D3FB_1568056615.addTaint(taint);
                return var617A45C7DCCD8863F5C5FEA71DA0D3FB_1568056615;
                // ---------- Original Method ----------
                //return setIterator.next().getKey();
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.239 -0400", hash_original_method = "18575B4AE5EB78B20BC29135C417B7D0", hash_generated_method = "1D1456161322FC7023EBF5038D6C13EA")
            public void remove() {
                setIterator.remove();
                // ---------- Original Method ----------
                //setIterator.remove();
            }
};
            var4B7F8C61468541A26B3FAC55056B6833_1559186866.addTaint(taint);
            return var4B7F8C61468541A26B3FAC55056B6833_1559186866;
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
Set<K> varCB23CF4AFB8B7AE1843E733C4B0CC600_1160017523 =         keySet;
        varCB23CF4AFB8B7AE1843E733C4B0CC600_1160017523.addTaint(taint);
        return varCB23CF4AFB8B7AE1843E733C4B0CC600_1160017523;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.240 -0400", hash_original_method = "1AE25A34BEB4A8F08F41373ADFFCFE34", hash_generated_method = "2D7DCEDCFDACFCF44F687AD5E95C6B2E")
    public V put(K key, V value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1585484780 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1585484780.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1585484780;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.241 -0400", hash_original_method = "1BF9761154AA89A664F00EA3C1B1A227", hash_generated_method = "0E9082BE17046803AA3D46E2D766E2F8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.241 -0400", hash_original_method = "DF925EC53E8E5501C52A21B969B7A962", hash_generated_method = "8C5AC30EDC7A400556C0A38E655D19DC")
    public V remove(Object key) {
        addTaint(key.getTaint());
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
    if(key != null)        
        {
            while
(it.hasNext())            
            {
                Map.Entry<K, V> entry = it.next();
    if(key.equals(entry.getKey()))                
                {
                    it.remove();
V var4A887D14956ECA386DDED2772C1F523B_1972057497 =                     entry.getValue();
                    var4A887D14956ECA386DDED2772C1F523B_1972057497.addTaint(taint);
                    return var4A887D14956ECA386DDED2772C1F523B_1972057497;
                } //End block
            } //End block
        } //End block
        else
        {
            while
(it.hasNext())            
            {
                Map.Entry<K, V> entry = it.next();
    if(entry.getKey() == null)                
                {
                    it.remove();
V var4A887D14956ECA386DDED2772C1F523B_1913434618 =                     entry.getValue();
                    var4A887D14956ECA386DDED2772C1F523B_1913434618.addTaint(taint);
                    return var4A887D14956ECA386DDED2772C1F523B_1913434618;
                } //End block
            } //End block
        } //End block
V var540C13E9E156B687226421B24F2DF178_805568219 =         null;
        var540C13E9E156B687226421B24F2DF178_805568219.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_805568219;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.242 -0400", hash_original_method = "68473A1BCB9C7CDFC9C6F1089F605F26", hash_generated_method = "3FB78859829E4A9C7CC61FC635E09982")
    public int size() {
        int var604FDDD4DABDE463FBE55E0705D69FFA_668854263 = (entrySet().size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1016374635 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1016374635;
        // ---------- Original Method ----------
        //return entrySet().size();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.243 -0400", hash_original_method = "03506E32B26B17661064F3FFDE4F185F", hash_generated_method = "B1F7C7F452CE607268A656C977B6534C")
    @Override
    public String toString() {
    if(isEmpty())        
        {
String var1F80A99BA4B69CEEA7520BE66ADA743C_193929624 =             "{}";
            var1F80A99BA4B69CEEA7520BE66ADA743C_193929624.addTaint(taint);
            return var1F80A99BA4B69CEEA7520BE66ADA743C_193929624;
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
String varD03843288D33B9E1D3062E25339ECF6D_624098864 =         buffer.toString();
        varD03843288D33B9E1D3062E25339ECF6D_624098864.addTaint(taint);
        return varD03843288D33B9E1D3062E25339ECF6D_624098864;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.248 -0400", hash_original_method = "BE68DB72EA44A9864EFB8085A73DD13D", hash_generated_method = "FFF60DD0BB73731BB57AABB5E433364A")
    public Collection<V> values() {
    if(valuesCollection == null)        
        {
            valuesCollection = new AbstractCollection<V>() {        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.245 -0400", hash_original_method = "3B94EB65D5DE623B3E08A5638A43D0EB", hash_generated_method = "CA6CFA952C03545D3E3A2769F765A811")
        @Override
        public int size() {
            int var41C7EAB6B6C31A7460E79C2D82CCC7A9_1262057663 = (AbstractMap.this.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_73026285 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_73026285;
            // ---------- Original Method ----------
            //return AbstractMap.this.size();
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.246 -0400", hash_original_method = "7679F4183F803D10EFCD1172E399C7C3", hash_generated_method = "E601FC259267242ADF833FF8A17CC953")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            boolean varB5B67EA4257497C0385399BB5E8BA25C_649085155 = (containsValue(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1286987854 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1286987854;
            // ---------- Original Method ----------
            //return containsValue(object);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.248 -0400", hash_original_method = "22ABA9D926948DD0ED49A20C6509C8CB", hash_generated_method = "633BD0FCA294414635E38D88D2E7604F")
        @Override
        public Iterator<V> iterator() {
Iterator<V> var71B24D83A007564AC361D4FC2D7C0C99_607584023 =             new Iterator<V>() {            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.246 -0400", hash_original_field = "04F401FA3821AC3FF2BCE0E3D156C68B", hash_generated_field = "0C09F8E15A29D51A05F808D7E7E66C06")
            Iterator<Map.Entry<K, V>> setIterator = entrySet().iterator();
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.247 -0400", hash_original_method = "213B6F6BF550680DB14A6264553A9606", hash_generated_method = "5F927E12BD212B66E70FB60CC74C280E")
            public boolean hasNext() {
                boolean var148F57DEC6206B4324A475DF6F64D64C_1846683100 = (setIterator.hasNext());
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1087171588 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1087171588;
                // ---------- Original Method ----------
                //return setIterator.hasNext();
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.247 -0400", hash_original_method = "26FD6EB64128E32F409902FB919BC33E", hash_generated_method = "05A4E19C8E43F297299161B945560D2D")
            public V next() {
V var5D9B7DBE16C9E1B136841E3D4AAD057C_1169932288 =                 setIterator.next().getValue();
                var5D9B7DBE16C9E1B136841E3D4AAD057C_1169932288.addTaint(taint);
                return var5D9B7DBE16C9E1B136841E3D4AAD057C_1169932288;
                // ---------- Original Method ----------
                //return setIterator.next().getValue();
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.248 -0400", hash_original_method = "18575B4AE5EB78B20BC29135C417B7D0", hash_generated_method = "1D1456161322FC7023EBF5038D6C13EA")
            public void remove() {
                setIterator.remove();
                // ---------- Original Method ----------
                //setIterator.remove();
            }
};
            var71B24D83A007564AC361D4FC2D7C0C99_607584023.addTaint(taint);
            return var71B24D83A007564AC361D4FC2D7C0C99_607584023;
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
Collection<V> var60B0A8A6E555943126A18D312F8E04FB_154168766 =         valuesCollection;
        var60B0A8A6E555943126A18D312F8E04FB_154168766.addTaint(taint);
        return var60B0A8A6E555943126A18D312F8E04FB_154168766;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.249 -0400", hash_original_method = "DEDBEBF1A9DF717B6A61BCEAEE5EB8FF", hash_generated_method = "250044BB0BBEAA228809036D096A5438")
    @SuppressWarnings("unchecked")
    @Override
    protected Object clone() throws CloneNotSupportedException {
        AbstractMap<K, V> result = (AbstractMap<K, V>) super.clone();
        result.keySet = null;
        result.valuesCollection = null;
Object varDC838461EE2FA0CA4C9BBB70A15456B0_1889422054 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1889422054.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1889422054;
        // ---------- Original Method ----------
        //AbstractMap<K, V> result = (AbstractMap<K, V>) super.clone();
        //result.keySet = null;
        //result.valuesCollection = null;
        //return result;
    }

    
    public static class SimpleImmutableEntry<K, V> implements Map.Entry<K, V>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.249 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "EBAE1A8AD28B83F3F907DD83D8B82F01")

        private K key;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.250 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "EEA53383AEF96F58506DEE94A549CB01")

        private V value;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.250 -0400", hash_original_method = "33F8AD4AA392C56EA79ABB4A58A6836E", hash_generated_method = "1A26EA514829E31B02595112305C8058")
        public  SimpleImmutableEntry(K theKey, V theValue) {
            key = theKey;
            value = theValue;
            // ---------- Original Method ----------
            //key = theKey;
            //value = theValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.251 -0400", hash_original_method = "B328F2475798EE2AF89F33F6E7AEA482", hash_generated_method = "C6AD03E3758C4CD95B20142655BD5CD9")
        public  SimpleImmutableEntry(Map.Entry<? extends K, ? extends V> copyFrom) {
            key = copyFrom.getKey();
            value = copyFrom.getValue();
            // ---------- Original Method ----------
            //key = copyFrom.getKey();
            //value = copyFrom.getValue();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.251 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "AE0F2B8EF61FAD6AC49A3CFF8ED0F16D")
        public K getKey() {
K var6A95247616A3A8B93CFF7783DABD08D4_1615786583 =             key;
            var6A95247616A3A8B93CFF7783DABD08D4_1615786583.addTaint(taint);
            return var6A95247616A3A8B93CFF7783DABD08D4_1615786583;
            // ---------- Original Method ----------
            //return key;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.251 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "3F99D65E43B7A3132DD43AD3C053FC8D")
        public V getValue() {
V varAF280DA2BC37D8BE783D8499160168DE_952894279 =             value;
            varAF280DA2BC37D8BE783D8499160168DE_952894279.addTaint(taint);
            return varAF280DA2BC37D8BE783D8499160168DE_952894279;
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.251 -0400", hash_original_method = "3526712C126765AF36CB8D920CBD3B1B", hash_generated_method = "161EA663FDFBC866354DB45BAD643842")
        public V setValue(V object) {
            addTaint(object.getTaint());
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_866508797 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_866508797.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_866508797;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.252 -0400", hash_original_method = "5E665954E6171F76B6FD9130152FC1D9", hash_generated_method = "FB9AA7A2846A02916944CC7EF068B174")
        @Override
        public boolean equals(Object object) {
            addTaint(object.getTaint());
    if(this == object)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_2046572262 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_910787536 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_910787536;
            } //End block
    if(object instanceof Map.Entry)            
            {
                Map.Entry<?, ?> entry = (Map.Entry<?, ?>) object;
                boolean varFDE4007C31A825095FEA758AC6BF92FF_67659163 = ((key == null ? entry.getKey() == null : key.equals(entry
                        .getKey()))
                        && (value == null ? entry.getValue() == null : value
                                .equals(entry.getValue())));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1326736876 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1326736876;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1331988896 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_846440056 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_846440056;
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.252 -0400", hash_original_method = "6416487D313DFCFD3052C01ADB883217", hash_generated_method = "7C7C64681724685F2F00AA8199BF121F")
        @Override
        public int hashCode() {
            int var6426FEC1614D5FE74370608AA1AC68B8_951116950 = ((key == null ? 0 : key.hashCode())
                    ^ (value == null ? 0 : value.hashCode()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1561869648 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1561869648;
            // ---------- Original Method ----------
            //return (key == null ? 0 : key.hashCode())
                    //^ (value == null ? 0 : value.hashCode());
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.253 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "41C65E954D271A8B81BC5F6A0A35E9C6")
        @Override
        public String toString() {
String varFE698C13EFD83B87FAF2DC2AB0874271_1404233435 =             key + "=" + value;
            varFE698C13EFD83B87FAF2DC2AB0874271_1404233435.addTaint(taint);
            return varFE698C13EFD83B87FAF2DC2AB0874271_1404233435;
            // ---------- Original Method ----------
            //return key + "=" + value;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.253 -0400", hash_original_field = "0FB41B94E91231F1583771B8C0C0C696", hash_generated_field = "3DFDD92E82A1CB0CEF7DE41ED65507D7")

        private static final long serialVersionUID = 7138329143949025153L;
    }


    
    public static class SimpleEntry<K, V> implements Map.Entry<K, V>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.253 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "EBAE1A8AD28B83F3F907DD83D8B82F01")

        private K key;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.253 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "EEA53383AEF96F58506DEE94A549CB01")

        private V value;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.254 -0400", hash_original_method = "BD7301488126194D9FCD92EBDE27E89B", hash_generated_method = "6DD3ADB0E0C9AC93F8E4466B16A19993")
        public  SimpleEntry(K theKey, V theValue) {
            key = theKey;
            value = theValue;
            // ---------- Original Method ----------
            //key = theKey;
            //value = theValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.254 -0400", hash_original_method = "69734A3C3A679CA95ADF7DC846433DE1", hash_generated_method = "54A51761FD45C24B5F05A70D91586172")
        public  SimpleEntry(Map.Entry<? extends K, ? extends V> copyFrom) {
            key = copyFrom.getKey();
            value = copyFrom.getValue();
            // ---------- Original Method ----------
            //key = copyFrom.getKey();
            //value = copyFrom.getValue();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.254 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "C816EB03AEBEF41130731EC4129E18DC")
        public K getKey() {
K var6A95247616A3A8B93CFF7783DABD08D4_1689557728 =             key;
            var6A95247616A3A8B93CFF7783DABD08D4_1689557728.addTaint(taint);
            return var6A95247616A3A8B93CFF7783DABD08D4_1689557728;
            // ---------- Original Method ----------
            //return key;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.255 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "6DCBFD1BA5CFDCFC61F47518531964B3")
        public V getValue() {
V varAF280DA2BC37D8BE783D8499160168DE_815272886 =             value;
            varAF280DA2BC37D8BE783D8499160168DE_815272886.addTaint(taint);
            return varAF280DA2BC37D8BE783D8499160168DE_815272886;
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.255 -0400", hash_original_method = "123DAF07FFBE76C8EE5BD5879EB92827", hash_generated_method = "3091626D83A2A5D585E791AC367F3190")
        public V setValue(V object) {
            V result = value;
            value = object;
V varDC838461EE2FA0CA4C9BBB70A15456B0_1945949918 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1945949918.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1945949918;
            // ---------- Original Method ----------
            //V result = value;
            //value = object;
            //return result;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.256 -0400", hash_original_method = "5E665954E6171F76B6FD9130152FC1D9", hash_generated_method = "080F08A7CF6BC3A06DC26F9CD4D6DD58")
        @Override
        public boolean equals(Object object) {
            addTaint(object.getTaint());
    if(this == object)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_682062541 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1387574617 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1387574617;
            } //End block
    if(object instanceof Map.Entry)            
            {
                Map.Entry<?, ?> entry = (Map.Entry<?, ?>) object;
                boolean varFDE4007C31A825095FEA758AC6BF92FF_1604990829 = ((key == null ? entry.getKey() == null : key.equals(entry
                        .getKey()))
                        && (value == null ? entry.getValue() == null : value
                                .equals(entry.getValue())));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1238859345 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1238859345;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_70578164 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_576184828 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_576184828;
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.256 -0400", hash_original_method = "6416487D313DFCFD3052C01ADB883217", hash_generated_method = "DF3DBD217F7E167AAE60DED588035DD7")
        @Override
        public int hashCode() {
            int var6426FEC1614D5FE74370608AA1AC68B8_1964555641 = ((key == null ? 0 : key.hashCode())
                    ^ (value == null ? 0 : value.hashCode()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_821557053 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_821557053;
            // ---------- Original Method ----------
            //return (key == null ? 0 : key.hashCode())
                    //^ (value == null ? 0 : value.hashCode());
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.257 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "C03DE36C58877BFA292596E7C606FBFF")
        @Override
        public String toString() {
String varFE698C13EFD83B87FAF2DC2AB0874271_820127116 =             key + "=" + value;
            varFE698C13EFD83B87FAF2DC2AB0874271_820127116.addTaint(taint);
            return varFE698C13EFD83B87FAF2DC2AB0874271_820127116;
            // ---------- Original Method ----------
            //return key + "=" + value;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.257 -0400", hash_original_field = "6740671D10922D6DCB5AFF41C09E8C7B", hash_generated_field = "9B9E5FFE746EC28EB67AAB64BC8691E2")

        private static final long serialVersionUID = -8499721149061103585L;
    }


    
}

