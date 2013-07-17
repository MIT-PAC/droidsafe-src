package gov.nist.core;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MultiValueMapImpl<V> implements MultiValueMap<String, V>, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.550 -0400", hash_original_field = "160FA6EE5E99052B187A1F80FEB63F9A", hash_generated_field = "7CFE38AEC9CFBA4A360ACB9AB9A4320E")

    private HashMap<String, ArrayList<V>> map = new HashMap<String, ArrayList<V>>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.550 -0400", hash_original_method = "92FBF841CDA8BB538E9BCFC9D2E80E36", hash_generated_method = "BBAE31DA49C30209803972329341FA59")
    public  MultiValueMapImpl() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.551 -0400", hash_original_method = "015B36338D34B6EBF400464F225017F7", hash_generated_method = "1C0B2B13F4366A8EFD0D2282684937FF")
    public List<V> put(String key, V value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        ArrayList<V> keyList = map.get(key);
        if(keyList == null)        
        {
            keyList = new ArrayList<V>(10);
            map.put(key, keyList);
        } //End block
        keyList.add(value);
List<V> varCC0C5B4D79414422EDBBE9E933224EAF_169550543 =         keyList;
        varCC0C5B4D79414422EDBBE9E933224EAF_169550543.addTaint(taint);
        return varCC0C5B4D79414422EDBBE9E933224EAF_169550543;
        // ---------- Original Method ----------
        //ArrayList<V> keyList = map.get(key);
        //if (keyList == null) {
            //keyList = new ArrayList<V>(10);
            //map.put(key, keyList);
        //}
        //keyList.add(value);
        //return keyList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.551 -0400", hash_original_method = "DB86C9FAE576BDCBCAB6ACEF27E24DCF", hash_generated_method = "69852D00D48587D96481C2987F55E96C")
    public boolean containsValue(Object value) {
        addTaint(value.getTaint());
        Set pairs = map.entrySet();
        if(pairs == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_660836364 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1573933017 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1573933017;
        }
        Iterator pairsIterator = pairs.iterator();
        while
(pairsIterator.hasNext())        
        {
            Map.Entry keyValuePair = (Map.Entry) (pairsIterator.next());
            ArrayList list = (ArrayList) (keyValuePair.getValue());
            if(list.contains(value))            
            {
            boolean varB326B5062B2F0E69046810717534CB09_1785073350 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1942030693 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1942030693;
            }
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_887868472 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_884604454 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_884604454;
        // ---------- Original Method ----------
        //Set pairs = map.entrySet();
        //if (pairs == null)
            //return false;
        //Iterator pairsIterator = pairs.iterator();
        //while (pairsIterator.hasNext()) {
            //Map.Entry keyValuePair = (Map.Entry) (pairsIterator.next());
            //ArrayList list = (ArrayList) (keyValuePair.getValue());
            //if (list.contains(value))
                //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.552 -0400", hash_original_method = "ACD58D82904FAC9C1E105DF6132F728F", hash_generated_method = "FF8067C1BE23B04FD9994F427CB86C7B")
    public void clear() {
        Set pairs = map.entrySet();
        Iterator pairsIterator = pairs.iterator();
        while
(pairsIterator.hasNext())        
        {
            Map.Entry keyValuePair = (Map.Entry) (pairsIterator.next());
            ArrayList list = (ArrayList) (keyValuePair.getValue());
            list.clear();
        } //End block
        map.clear();
        // ---------- Original Method ----------
        //Set pairs = map.entrySet();
        //Iterator pairsIterator = pairs.iterator();
        //while (pairsIterator.hasNext()) {
            //Map.Entry keyValuePair = (Map.Entry) (pairsIterator.next());
            //ArrayList list = (ArrayList) (keyValuePair.getValue());
            //list.clear();
        //}
        //map.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.552 -0400", hash_original_method = "9D94995CB4905B7A6A15BF37AA0AF804", hash_generated_method = "FD6771849D78D38234823819780D6055")
    public Collection values() {
        ArrayList returnList = new ArrayList(map.size());
        Set pairs = map.entrySet();
        Iterator pairsIterator = pairs.iterator();
        while
(pairsIterator.hasNext())        
        {
            Map.Entry keyValuePair = (Map.Entry) (pairsIterator.next());
            ArrayList list = (ArrayList) (keyValuePair.getValue());
            Object[] values = list.toArray();
for(int ii = 0;ii < values.length;ii++)
            {
                returnList.add(values[ii]);
            } //End block
        } //End block
Collection var195207CFC264788B20A079C8C3E1371E_1769858331 =         returnList;
        var195207CFC264788B20A079C8C3E1371E_1769858331.addTaint(taint);
        return var195207CFC264788B20A079C8C3E1371E_1769858331;
        // ---------- Original Method ----------
        //ArrayList returnList = new ArrayList(map.size());
        //Set pairs = map.entrySet();
        //Iterator pairsIterator = pairs.iterator();
        //while (pairsIterator.hasNext()) {
            //Map.Entry keyValuePair = (Map.Entry) (pairsIterator.next());
            //ArrayList list = (ArrayList) (keyValuePair.getValue());
            //Object[] values = list.toArray();
            //for (int ii = 0; ii < values.length; ii++) {
                //returnList.add(values[ii]);
            //}
        //}
        //return returnList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.553 -0400", hash_original_method = "7FD8976C5EB94AF5BEDA5274AB7D4960", hash_generated_method = "E884E58C8941027381D67221D0F56C96")
    public Object clone() {
        MultiValueMapImpl obj = new MultiValueMapImpl<V>();
        obj.map = (HashMap<Object, ArrayList<V>>) this.map.clone();
Object var2FDE1120F80AA4E8798ECDBDB1C0E85C_989861187 =         obj;
        var2FDE1120F80AA4E8798ECDBDB1C0E85C_989861187.addTaint(taint);
        return var2FDE1120F80AA4E8798ECDBDB1C0E85C_989861187;
        // ---------- Original Method ----------
        //MultiValueMapImpl obj = new MultiValueMapImpl<V>();
        //obj.map = (HashMap<Object, ArrayList<V>>) this.map.clone();
        //return obj;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.554 -0400", hash_original_method = "5426196537489B9F267A5D92E091E0D1", hash_generated_method = "C30BB07F0E84EC3D2D26EB0E37E9A4B2")
    public int size() {
        int varF2202A8501CD0EEDB2506BC8F112F883_597054500 = (this.map.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2104733541 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2104733541;
        // ---------- Original Method ----------
        //return this.map.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.555 -0400", hash_original_method = "51FDEF8A21E6EA5E0FB4715F8113FE74", hash_generated_method = "AC99E0989B854DF534FF8AE5E5ACB5CF")
    public boolean containsKey(Object key) {
        addTaint(key.getTaint());
        boolean var1F5C7C829096E4FDB1A63A2E9D4DD6A2_1201850775 = (map.containsKey(key));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1290819177 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1290819177;
        // ---------- Original Method ----------
        //return map.containsKey(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.555 -0400", hash_original_method = "A7117DE6FDE9AB582C79C19A4704EAC3", hash_generated_method = "1899965AEBD733CE71042BE83C55B6CE")
    public Set entrySet() {
Set varD70A818A9C24919C79B0A6854ED78BA4_1775642719 =         map.entrySet();
        varD70A818A9C24919C79B0A6854ED78BA4_1775642719.addTaint(taint);
        return varD70A818A9C24919C79B0A6854ED78BA4_1775642719;
        // ---------- Original Method ----------
        //return map.entrySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.555 -0400", hash_original_method = "193F4487BCC4A9B88FB28866363E7ABF", hash_generated_method = "A0F7062A9E0CADEF6BCD423DD898ABAE")
    public boolean isEmpty() {
        boolean varAF143B23ABB0913809523AA7F6DBE946_507651432 = (map.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1162965773 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1162965773;
        // ---------- Original Method ----------
        //return map.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.556 -0400", hash_original_method = "6CB9892D3A46557FDBF8DC408603010A", hash_generated_method = "11FE6A27793C8E8405EB256AE0F15D64")
    public Set<String> keySet() {
Set<String> varF820A78B2E5CB85B7FD62FD1DAFAA525_1491861802 =         this.map.keySet();
        varF820A78B2E5CB85B7FD62FD1DAFAA525_1491861802.addTaint(taint);
        return varF820A78B2E5CB85B7FD62FD1DAFAA525_1491861802;
        // ---------- Original Method ----------
        //return this.map.keySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.556 -0400", hash_original_method = "7F32EDF5FAFC7BC56577B23C28284BD1", hash_generated_method = "967D742B484872F8723580E12F0EEE62")
    public Object remove(String key, V item) {
        addTaint(item.getTaint());
        addTaint(key.getTaint());
        ArrayList<V> list = this.map.get(key);
        if(list == null)        
        {
Object var540C13E9E156B687226421B24F2DF178_1385995454 =             null;
            var540C13E9E156B687226421B24F2DF178_1385995454.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1385995454;
        } //End block
        else
        {
Object varA9485A2631DFC87793B41E94772B18C9_1086340367 =             list.remove(item);
            varA9485A2631DFC87793B41E94772B18C9_1086340367.addTaint(taint);
            return varA9485A2631DFC87793B41E94772B18C9_1086340367;
        } //End block
        // ---------- Original Method ----------
        //ArrayList<V> list = this.map.get(key);
        //if (list == null) {
            //return null;
        //} else {
            //return list.remove(item);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.557 -0400", hash_original_method = "08F032B341F8C34A7104B10254E1B693", hash_generated_method = "E280722D005946B1376933BAAF30FFB9")
    public List<V> get(Object key) {
        addTaint(key.getTaint());
List<V> var97156AACD411ADC83FECC30C065B5B0C_71251643 =         map.get(key);
        var97156AACD411ADC83FECC30C065B5B0C_71251643.addTaint(taint);
        return var97156AACD411ADC83FECC30C065B5B0C_71251643;
        // ---------- Original Method ----------
        //return map.get(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.557 -0400", hash_original_method = "23A91A040F7CE5CCEDDB4E75AB426F56", hash_generated_method = "D6D85735ED78922D51F8B2CB0E3E24F4")
    public List<V> put(String key, List<V> value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
List<V> var02481C24BCFA11D91CC01A5BB2621143_1868674711 =         this.map.put(key,(ArrayList<V>) value);
        var02481C24BCFA11D91CC01A5BB2621143_1868674711.addTaint(taint);
        return var02481C24BCFA11D91CC01A5BB2621143_1868674711;
        // ---------- Original Method ----------
        //return this.map.put(key,(ArrayList<V>) value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.558 -0400", hash_original_method = "7B07E9B7FC8B36A67A63DC78734F6C09", hash_generated_method = "0B893344ABB70D7D6A98A32CBA9DB888")
    public List<V> remove(Object key) {
        addTaint(key.getTaint());
List<V> var680816A9C90635BE8F543A56792CAAE8_965021963 =         map.remove(key);
        var680816A9C90635BE8F543A56792CAAE8_965021963.addTaint(taint);
        return var680816A9C90635BE8F543A56792CAAE8_965021963;
        // ---------- Original Method ----------
        //return map.remove(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.559 -0400", hash_original_method = "FD6B4077E86FCBA56C835917C4A62A14", hash_generated_method = "64A21048E3C0C6D4B7BF0879E25C0CE1")
    public void putAll(Map< ? extends String, ? extends List<V>> mapToPut) {
        addTaint(mapToPut.getTaint());
for(String k : mapToPut.keySet())
        {
            ArrayList<V> al = new ArrayList<V>();
            al.addAll(mapToPut.get(k));
            this.map.put(k, al);
        } //End block
        // ---------- Original Method ----------
        //for (String k : mapToPut.keySet()) {
            //ArrayList<V> al = new ArrayList<V>();
            //al.addAll(mapToPut.get(k));
            //this.map.put(k, al);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.559 -0400", hash_original_field = "CFD525E80C90A9F4632ED696EA4A2C3A", hash_generated_field = "A182B7666DFBDE7AEB9947BAE926EB53")

    private static final long serialVersionUID = 4275505380960964605L;
}

