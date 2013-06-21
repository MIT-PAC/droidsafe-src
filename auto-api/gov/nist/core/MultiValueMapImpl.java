package gov.nist.core;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MultiValueMapImpl<V> implements MultiValueMap<String, V>, Cloneable {
    private HashMap<String, ArrayList<V>> map = new HashMap<String, ArrayList<V>>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.688 -0400", hash_original_method = "92FBF841CDA8BB538E9BCFC9D2E80E36", hash_generated_method = "BBAE31DA49C30209803972329341FA59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MultiValueMapImpl() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.689 -0400", hash_original_method = "015B36338D34B6EBF400464F225017F7", hash_generated_method = "040872551656D8C31F1FA48A05AC6456")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<V> put(String key, V value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key);
        ArrayList<V> keyList;
        keyList = map.get(key);
        {
            keyList = new ArrayList<V>(10);
            map.put(key, keyList);
        } //End block
        keyList.add(value);
        return (List<V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ArrayList<V> keyList = map.get(key);
        //if (keyList == null) {
            //keyList = new ArrayList<V>(10);
            //map.put(key, keyList);
        //}
        //keyList.add(value);
        //return keyList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.690 -0400", hash_original_method = "DB86C9FAE576BDCBCAB6ACEF27E24DCF", hash_generated_method = "8CA7636A5C0AD98FDC11A03418CF0519")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsValue(Object value) {
        dsTaint.addTaint(value.dsTaint);
        Set pairs;
        pairs = map.entrySet();
        Iterator pairsIterator;
        pairsIterator = pairs.iterator();
        {
            boolean varAFC1C232FAFCF3B88BE1C2040FEA85C1_1878408732 = (pairsIterator.hasNext());
            {
                Map.Entry keyValuePair;
                keyValuePair = (Map.Entry) (pairsIterator.next());
                ArrayList list;
                list = (ArrayList) (keyValuePair.getValue());
                {
                    boolean var4A1616F333FF43E87183886DC3AB20B0_309102433 = (list.contains(value));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.690 -0400", hash_original_method = "ACD58D82904FAC9C1E105DF6132F728F", hash_generated_method = "42D07DB83F31026439183E7F53525622")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clear() {
        Set pairs;
        pairs = map.entrySet();
        Iterator pairsIterator;
        pairsIterator = pairs.iterator();
        {
            boolean varAFC1C232FAFCF3B88BE1C2040FEA85C1_101186867 = (pairsIterator.hasNext());
            {
                Map.Entry keyValuePair;
                keyValuePair = (Map.Entry) (pairsIterator.next());
                ArrayList list;
                list = (ArrayList) (keyValuePair.getValue());
                list.clear();
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.691 -0400", hash_original_method = "9D94995CB4905B7A6A15BF37AA0AF804", hash_generated_method = "93B661F8C5DE5EB1B2019A19CEE36907")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Collection values() {
        ArrayList returnList;
        returnList = new ArrayList(map.size());
        Set pairs;
        pairs = map.entrySet();
        Iterator pairsIterator;
        pairsIterator = pairs.iterator();
        {
            boolean varAFC1C232FAFCF3B88BE1C2040FEA85C1_745150697 = (pairsIterator.hasNext());
            {
                Map.Entry keyValuePair;
                keyValuePair = (Map.Entry) (pairsIterator.next());
                ArrayList list;
                list = (ArrayList) (keyValuePair.getValue());
                Object[] values;
                values = list.toArray();
                {
                    int ii;
                    ii = 0;
                    {
                        returnList.add(values[ii]);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (Collection)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.691 -0400", hash_original_method = "7FD8976C5EB94AF5BEDA5274AB7D4960", hash_generated_method = "DC9D102B9FB4E5ECAA537DC55580A741")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        MultiValueMapImpl obj;
        obj = new MultiValueMapImpl<V>();
        obj.map = (HashMap<Object, ArrayList<V>>) this.map.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //MultiValueMapImpl obj = new MultiValueMapImpl<V>();
        //obj.map = (HashMap<Object, ArrayList<V>>) this.map.clone();
        //return obj;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.691 -0400", hash_original_method = "5426196537489B9F267A5D92E091E0D1", hash_generated_method = "FEAD9B2DD8A47FA65E835ECAD17FD8CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int size() {
        int varE3E5330F94254BCBA3E355D469C195F3_771821832 = (this.map.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.map.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.691 -0400", hash_original_method = "51FDEF8A21E6EA5E0FB4715F8113FE74", hash_generated_method = "85FFE826956CFD358ABBDD0E0233337A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsKey(Object key) {
        dsTaint.addTaint(key.dsTaint);
        boolean var56EC89656FCA0EA2E21B790CBA0BA5A2_1929145980 = (map.containsKey(key));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return map.containsKey(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.692 -0400", hash_original_method = "A7117DE6FDE9AB582C79C19A4704EAC3", hash_generated_method = "75B9610655151A481BB673F61A4CC308")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set entrySet() {
        Set var84DA32A5A57D791E799D00532065D1DC_1379608588 = (map.entrySet());
        return (Set)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return map.entrySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.692 -0400", hash_original_method = "193F4487BCC4A9B88FB28866363E7ABF", hash_generated_method = "5F85C26E30EBCADECE45E0852749F914")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEmpty() {
        boolean var59C8754218A5378301A7B2210B450A8A_1481622378 = (map.isEmpty());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return map.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.692 -0400", hash_original_method = "6CB9892D3A46557FDBF8DC408603010A", hash_generated_method = "9C3E5587EFDF60F6A23ED5029F428F03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<String> keySet() {
        Set<String> varFC94F82E3F78D211074532A985DDA13A_502191162 = (this.map.keySet());
        return (Set<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.map.keySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.692 -0400", hash_original_method = "7F32EDF5FAFC7BC56577B23C28284BD1", hash_generated_method = "8D2FF080CF7417174D24BC6B532AA938")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object remove(String key, V item) {
        dsTaint.addTaint(item.dsTaint);
        dsTaint.addTaint(key);
        ArrayList<V> list;
        list = this.map.get(key);
        {
            Object var1D95E7A314D123290BDCE6C403B7D08A_649085525 = (list.remove(item));
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ArrayList<V> list = this.map.get(key);
        //if (list == null) {
            //return null;
        //} else {
            //return list.remove(item);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.692 -0400", hash_original_method = "08F032B341F8C34A7104B10254E1B693", hash_generated_method = "99B1D241F3301023A807A1DD542AAEDF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<V> get(Object key) {
        dsTaint.addTaint(key.dsTaint);
        List<V> var24A27D2286C1D17B4AB70798C0BC1C16_1040922278 = (map.get(key));
        return (List<V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return map.get(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.693 -0400", hash_original_method = "23A91A040F7CE5CCEDDB4E75AB426F56", hash_generated_method = "B79E9D7ACA019FA5528FF3CEEA88054A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<V> put(String key, List<V> value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key);
        List<V> varE020E8B5E31409EC2AE43F2484EFAD25_525306260 = (this.map.put(key,(ArrayList<V>) value));
        return (List<V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.map.put(key,(ArrayList<V>) value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.693 -0400", hash_original_method = "7B07E9B7FC8B36A67A63DC78734F6C09", hash_generated_method = "80318C9962D1FB17DF02A2EBD9740A3D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<V> remove(Object key) {
        dsTaint.addTaint(key.dsTaint);
        List<V> var8B97B65E44C2FA9E70FEA56ECDEE63A2_121028527 = (map.remove(key));
        return (List<V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return map.remove(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.696 -0400", hash_original_method = "FD6B4077E86FCBA56C835917C4A62A14", hash_generated_method = "D1CCD2A33935408F4326FD707A84B97A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void putAll(Map< ? extends String, ? extends List<V>> mapToPut) {
        dsTaint.addTaint(mapToPut.dsTaint);
        {
            Iterator<String> varF1CB148D7070D789DA3D044F6B603FDC_326789033 = (mapToPut.keySet()).iterator();
            varF1CB148D7070D789DA3D044F6B603FDC_326789033.hasNext();
            String k = varF1CB148D7070D789DA3D044F6B603FDC_326789033.next();
            {
                ArrayList<V> al;
                al = new ArrayList<V>();
                al.addAll(mapToPut.get(k));
                this.map.put(k, al);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (String k : mapToPut.keySet()) {
            //ArrayList<V> al = new ArrayList<V>();
            //al.addAll(mapToPut.get(k));
            //this.map.put(k, al);
        //}
    }

    
    private static final long serialVersionUID = 4275505380960964605L;
}

