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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.309 -0400", hash_original_field = "160FA6EE5E99052B187A1F80FEB63F9A", hash_generated_field = "7CFE38AEC9CFBA4A360ACB9AB9A4320E")

    private HashMap<String, ArrayList<V>> map = new HashMap<String, ArrayList<V>>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.310 -0400", hash_original_method = "92FBF841CDA8BB538E9BCFC9D2E80E36", hash_generated_method = "BBAE31DA49C30209803972329341FA59")
    public  MultiValueMapImpl() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.322 -0400", hash_original_method = "015B36338D34B6EBF400464F225017F7", hash_generated_method = "3988E0CB69954DA9177E3E2D0826C686")
    public List<V> put(String key, V value) {
        List<V> varB4EAC82CA7396A68D541C85D26508E83_369556530 = null; //Variable for return #1
        ArrayList<V> keyList;
        keyList = map.get(key);
        {
            keyList = new ArrayList<V>(10);
            map.put(key, keyList);
        } //End block
        keyList.add(value);
        varB4EAC82CA7396A68D541C85D26508E83_369556530 = keyList;
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_369556530.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_369556530;
        // ---------- Original Method ----------
        //ArrayList<V> keyList = map.get(key);
        //if (keyList == null) {
            //keyList = new ArrayList<V>(10);
            //map.put(key, keyList);
        //}
        //keyList.add(value);
        //return keyList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.323 -0400", hash_original_method = "DB86C9FAE576BDCBCAB6ACEF27E24DCF", hash_generated_method = "58E3EB12F5A78215DBBFE370C5B7843A")
    public boolean containsValue(Object value) {
        Set pairs;
        pairs = map.entrySet();
        Iterator pairsIterator;
        pairsIterator = pairs.iterator();
        {
            boolean varAFC1C232FAFCF3B88BE1C2040FEA85C1_1753905553 = (pairsIterator.hasNext());
            {
                Map.Entry keyValuePair;
                keyValuePair = (Map.Entry) (pairsIterator.next());
                ArrayList list;
                list = (ArrayList) (keyValuePair.getValue());
                {
                    boolean var4A1616F333FF43E87183886DC3AB20B0_1057440214 = (list.contains(value));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_726654030 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_726654030;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.324 -0400", hash_original_method = "ACD58D82904FAC9C1E105DF6132F728F", hash_generated_method = "27BD1E3E13C095E754B5A5EA75CAA629")
    public void clear() {
        Set pairs;
        pairs = map.entrySet();
        Iterator pairsIterator;
        pairsIterator = pairs.iterator();
        {
            boolean varAFC1C232FAFCF3B88BE1C2040FEA85C1_2055125181 = (pairsIterator.hasNext());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.334 -0400", hash_original_method = "9D94995CB4905B7A6A15BF37AA0AF804", hash_generated_method = "5AC6785BBE36E80901D46B06DB7B1F66")
    public Collection values() {
        Collection varB4EAC82CA7396A68D541C85D26508E83_828663437 = null; //Variable for return #1
        ArrayList returnList;
        returnList = new ArrayList(map.size());
        Set pairs;
        pairs = map.entrySet();
        Iterator pairsIterator;
        pairsIterator = pairs.iterator();
        {
            boolean varAFC1C232FAFCF3B88BE1C2040FEA85C1_2116324674 = (pairsIterator.hasNext());
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
        varB4EAC82CA7396A68D541C85D26508E83_828663437 = returnList;
        varB4EAC82CA7396A68D541C85D26508E83_828663437.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_828663437;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.335 -0400", hash_original_method = "7FD8976C5EB94AF5BEDA5274AB7D4960", hash_generated_method = "2B155CAED81A99725A1A99DF11CD71C7")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_414348954 = null; //Variable for return #1
        MultiValueMapImpl obj;
        obj = new MultiValueMapImpl<V>();
        obj.map = (HashMap<Object, ArrayList<V>>) this.map.clone();
        varB4EAC82CA7396A68D541C85D26508E83_414348954 = obj;
        varB4EAC82CA7396A68D541C85D26508E83_414348954.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_414348954;
        // ---------- Original Method ----------
        //MultiValueMapImpl obj = new MultiValueMapImpl<V>();
        //obj.map = (HashMap<Object, ArrayList<V>>) this.map.clone();
        //return obj;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.335 -0400", hash_original_method = "5426196537489B9F267A5D92E091E0D1", hash_generated_method = "104AED4CE4868B4ACC8482E25B4C29A8")
    public int size() {
        int varE3E5330F94254BCBA3E355D469C195F3_125454032 = (this.map.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_797828002 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_797828002;
        // ---------- Original Method ----------
        //return this.map.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.336 -0400", hash_original_method = "51FDEF8A21E6EA5E0FB4715F8113FE74", hash_generated_method = "9F967FDD0956D5204345EDFB81A080CD")
    public boolean containsKey(Object key) {
        boolean var56EC89656FCA0EA2E21B790CBA0BA5A2_1706469823 = (map.containsKey(key));
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1645486226 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1645486226;
        // ---------- Original Method ----------
        //return map.containsKey(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.336 -0400", hash_original_method = "A7117DE6FDE9AB582C79C19A4704EAC3", hash_generated_method = "758875416CB0C954096B9E2C62B81775")
    public Set entrySet() {
        Set varB4EAC82CA7396A68D541C85D26508E83_2075142892 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2075142892 = map.entrySet();
        varB4EAC82CA7396A68D541C85D26508E83_2075142892.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2075142892;
        // ---------- Original Method ----------
        //return map.entrySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.336 -0400", hash_original_method = "193F4487BCC4A9B88FB28866363E7ABF", hash_generated_method = "8D2F74001B27FED3DB8766B587B4DDEC")
    public boolean isEmpty() {
        boolean var59C8754218A5378301A7B2210B450A8A_1257497713 = (map.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_315347885 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_315347885;
        // ---------- Original Method ----------
        //return map.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.356 -0400", hash_original_method = "6CB9892D3A46557FDBF8DC408603010A", hash_generated_method = "A065C6CD942D92B3FB52F84FFC286F40")
    public Set<String> keySet() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1464302946 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1464302946 = this.map.keySet();
        varB4EAC82CA7396A68D541C85D26508E83_1464302946.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1464302946;
        // ---------- Original Method ----------
        //return this.map.keySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.356 -0400", hash_original_method = "7F32EDF5FAFC7BC56577B23C28284BD1", hash_generated_method = "7DE11042E58F4706ABBB801DCFA55D56")
    public Object remove(String key, V item) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1692754625 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_135864267 = null; //Variable for return #2
        ArrayList<V> list;
        list = this.map.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1692754625 = null;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_135864267 = list.remove(item);
        } //End block
        addTaint(key.getTaint());
        addTaint(item.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_716564454; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_716564454 = varB4EAC82CA7396A68D541C85D26508E83_1692754625;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_716564454 = varB4EAC82CA7396A68D541C85D26508E83_135864267;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_716564454.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_716564454;
        // ---------- Original Method ----------
        //ArrayList<V> list = this.map.get(key);
        //if (list == null) {
            //return null;
        //} else {
            //return list.remove(item);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.359 -0400", hash_original_method = "08F032B341F8C34A7104B10254E1B693", hash_generated_method = "9BD54B7135CDCDCD7C1CCD6788371DEA")
    public List<V> get(Object key) {
        List<V> varB4EAC82CA7396A68D541C85D26508E83_524983633 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_524983633 = map.get(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_524983633.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_524983633;
        // ---------- Original Method ----------
        //return map.get(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.359 -0400", hash_original_method = "23A91A040F7CE5CCEDDB4E75AB426F56", hash_generated_method = "6D14E47A11626DAEFEC57BDFA457064E")
    public List<V> put(String key, List<V> value) {
        List<V> varB4EAC82CA7396A68D541C85D26508E83_1466464223 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1466464223 = this.map.put(key,(ArrayList<V>) value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1466464223.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1466464223;
        // ---------- Original Method ----------
        //return this.map.put(key,(ArrayList<V>) value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.360 -0400", hash_original_method = "7B07E9B7FC8B36A67A63DC78734F6C09", hash_generated_method = "EA3E5BEEA5FAB038F161B10CD9140A32")
    public List<V> remove(Object key) {
        List<V> varB4EAC82CA7396A68D541C85D26508E83_1651447895 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1651447895 = map.remove(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1651447895.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1651447895;
        // ---------- Original Method ----------
        //return map.remove(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.408 -0400", hash_original_method = "FD6B4077E86FCBA56C835917C4A62A14", hash_generated_method = "CD916D1BEFA0342D0BA4D5BCB8122C39")
    public void putAll(Map< ? extends String, ? extends List<V>> mapToPut) {
        {
            Iterator<String> varF1CB148D7070D789DA3D044F6B603FDC_917257958 = (mapToPut.keySet()).iterator();
            varF1CB148D7070D789DA3D044F6B603FDC_917257958.hasNext();
            String k = varF1CB148D7070D789DA3D044F6B603FDC_917257958.next();
            {
                ArrayList<V> al;
                al = new ArrayList<V>();
                al.addAll(mapToPut.get(k));
                this.map.put(k, al);
            } //End block
        } //End collapsed parenthetic
        addTaint(mapToPut.getTaint());
        // ---------- Original Method ----------
        //for (String k : mapToPut.keySet()) {
            //ArrayList<V> al = new ArrayList<V>();
            //al.addAll(mapToPut.get(k));
            //this.map.put(k, al);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.408 -0400", hash_original_field = "CFD525E80C90A9F4632ED696EA4A2C3A", hash_generated_field = "39B8D8A67D3867ED06FF4538FB4D4551")

    private static long serialVersionUID = 4275505380960964605L;
}

