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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.799 -0400", hash_original_field = "160FA6EE5E99052B187A1F80FEB63F9A", hash_generated_field = "7CFE38AEC9CFBA4A360ACB9AB9A4320E")

    private HashMap<String, ArrayList<V>> map = new HashMap<String, ArrayList<V>>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.799 -0400", hash_original_method = "92FBF841CDA8BB538E9BCFC9D2E80E36", hash_generated_method = "BBAE31DA49C30209803972329341FA59")
    public  MultiValueMapImpl() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.800 -0400", hash_original_method = "015B36338D34B6EBF400464F225017F7", hash_generated_method = "4DC74159A0A060E745707715D2BC0E15")
    public List<V> put(String key, V value) {
        List<V> varB4EAC82CA7396A68D541C85D26508E83_1872936544 = null; //Variable for return #1
        ArrayList<V> keyList;
        keyList = map.get(key);
        {
            keyList = new ArrayList<V>(10);
            map.put(key, keyList);
        } //End block
        keyList.add(value);
        varB4EAC82CA7396A68D541C85D26508E83_1872936544 = keyList;
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1872936544.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1872936544;
        // ---------- Original Method ----------
        //ArrayList<V> keyList = map.get(key);
        //if (keyList == null) {
            //keyList = new ArrayList<V>(10);
            //map.put(key, keyList);
        //}
        //keyList.add(value);
        //return keyList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.804 -0400", hash_original_method = "DB86C9FAE576BDCBCAB6ACEF27E24DCF", hash_generated_method = "ECB9150636917AE0CDC45D13DB4D8DAE")
    public boolean containsValue(Object value) {
        Set pairs;
        pairs = map.entrySet();
        Iterator pairsIterator;
        pairsIterator = pairs.iterator();
        {
            boolean varAFC1C232FAFCF3B88BE1C2040FEA85C1_476131086 = (pairsIterator.hasNext());
            {
                Map.Entry keyValuePair;
                keyValuePair = (Map.Entry) (pairsIterator.next());
                ArrayList list;
                list = (ArrayList) (keyValuePair.getValue());
                {
                    boolean var4A1616F333FF43E87183886DC3AB20B0_679858633 = (list.contains(value));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1638875723 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1638875723;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.811 -0400", hash_original_method = "ACD58D82904FAC9C1E105DF6132F728F", hash_generated_method = "96D636344132FAD1EDEFAB08E13EDAB9")
    public void clear() {
        Set pairs;
        pairs = map.entrySet();
        Iterator pairsIterator;
        pairsIterator = pairs.iterator();
        {
            boolean varAFC1C232FAFCF3B88BE1C2040FEA85C1_1863489195 = (pairsIterator.hasNext());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.812 -0400", hash_original_method = "9D94995CB4905B7A6A15BF37AA0AF804", hash_generated_method = "17A4A264400CE2B06E10DB8439B4B0CC")
    public Collection values() {
        Collection varB4EAC82CA7396A68D541C85D26508E83_1397998516 = null; //Variable for return #1
        ArrayList returnList;
        returnList = new ArrayList(map.size());
        Set pairs;
        pairs = map.entrySet();
        Iterator pairsIterator;
        pairsIterator = pairs.iterator();
        {
            boolean varAFC1C232FAFCF3B88BE1C2040FEA85C1_663548378 = (pairsIterator.hasNext());
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
        varB4EAC82CA7396A68D541C85D26508E83_1397998516 = returnList;
        varB4EAC82CA7396A68D541C85D26508E83_1397998516.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1397998516;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.826 -0400", hash_original_method = "7FD8976C5EB94AF5BEDA5274AB7D4960", hash_generated_method = "2AFB0F46E6761611FAA281871FD50481")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_983395637 = null; //Variable for return #1
        MultiValueMapImpl obj;
        obj = new MultiValueMapImpl<V>();
        obj.map = (HashMap<Object, ArrayList<V>>) this.map.clone();
        varB4EAC82CA7396A68D541C85D26508E83_983395637 = obj;
        varB4EAC82CA7396A68D541C85D26508E83_983395637.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_983395637;
        // ---------- Original Method ----------
        //MultiValueMapImpl obj = new MultiValueMapImpl<V>();
        //obj.map = (HashMap<Object, ArrayList<V>>) this.map.clone();
        //return obj;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.826 -0400", hash_original_method = "5426196537489B9F267A5D92E091E0D1", hash_generated_method = "A38102DC232C722BF929E77FF30E1FB8")
    public int size() {
        int varE3E5330F94254BCBA3E355D469C195F3_1358150150 = (this.map.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_68670126 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_68670126;
        // ---------- Original Method ----------
        //return this.map.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.826 -0400", hash_original_method = "51FDEF8A21E6EA5E0FB4715F8113FE74", hash_generated_method = "CAB054F1117B182FFE8EAEEFC265598F")
    public boolean containsKey(Object key) {
        boolean var56EC89656FCA0EA2E21B790CBA0BA5A2_50591743 = (map.containsKey(key));
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_50088340 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_50088340;
        // ---------- Original Method ----------
        //return map.containsKey(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.833 -0400", hash_original_method = "A7117DE6FDE9AB582C79C19A4704EAC3", hash_generated_method = "689B29E65FFF46A7A910FE91C8553C1F")
    public Set entrySet() {
        Set varB4EAC82CA7396A68D541C85D26508E83_309247348 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_309247348 = map.entrySet();
        varB4EAC82CA7396A68D541C85D26508E83_309247348.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_309247348;
        // ---------- Original Method ----------
        //return map.entrySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.835 -0400", hash_original_method = "193F4487BCC4A9B88FB28866363E7ABF", hash_generated_method = "6F82ED51BB223B95F567C59F9D26EE95")
    public boolean isEmpty() {
        boolean var59C8754218A5378301A7B2210B450A8A_64636046 = (map.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1485394 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1485394;
        // ---------- Original Method ----------
        //return map.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.835 -0400", hash_original_method = "6CB9892D3A46557FDBF8DC408603010A", hash_generated_method = "1579D43772EAA12514558DE30333D08C")
    public Set<String> keySet() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1148656308 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1148656308 = this.map.keySet();
        varB4EAC82CA7396A68D541C85D26508E83_1148656308.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1148656308;
        // ---------- Original Method ----------
        //return this.map.keySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.835 -0400", hash_original_method = "7F32EDF5FAFC7BC56577B23C28284BD1", hash_generated_method = "7CA1EE925E745EF78D69669AEDC6D349")
    public Object remove(String key, V item) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1949769420 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1385347124 = null; //Variable for return #2
        ArrayList<V> list;
        list = this.map.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1949769420 = null;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1385347124 = list.remove(item);
        } //End block
        addTaint(key.getTaint());
        addTaint(item.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_224615420; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_224615420 = varB4EAC82CA7396A68D541C85D26508E83_1949769420;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_224615420 = varB4EAC82CA7396A68D541C85D26508E83_1385347124;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_224615420.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_224615420;
        // ---------- Original Method ----------
        //ArrayList<V> list = this.map.get(key);
        //if (list == null) {
            //return null;
        //} else {
            //return list.remove(item);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.836 -0400", hash_original_method = "08F032B341F8C34A7104B10254E1B693", hash_generated_method = "3A6DBF35E9DB937A140537624567ECA6")
    public List<V> get(Object key) {
        List<V> varB4EAC82CA7396A68D541C85D26508E83_794308854 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_794308854 = map.get(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_794308854.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_794308854;
        // ---------- Original Method ----------
        //return map.get(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.836 -0400", hash_original_method = "23A91A040F7CE5CCEDDB4E75AB426F56", hash_generated_method = "FA7DE28977354ABC0B258D0CEE85E9C1")
    public List<V> put(String key, List<V> value) {
        List<V> varB4EAC82CA7396A68D541C85D26508E83_332170902 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_332170902 = this.map.put(key,(ArrayList<V>) value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_332170902.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_332170902;
        // ---------- Original Method ----------
        //return this.map.put(key,(ArrayList<V>) value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.837 -0400", hash_original_method = "7B07E9B7FC8B36A67A63DC78734F6C09", hash_generated_method = "69930B9A149BC7C46C88A575E7077223")
    public List<V> remove(Object key) {
        List<V> varB4EAC82CA7396A68D541C85D26508E83_842028763 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_842028763 = map.remove(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_842028763.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_842028763;
        // ---------- Original Method ----------
        //return map.remove(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.897 -0400", hash_original_method = "FD6B4077E86FCBA56C835917C4A62A14", hash_generated_method = "578354E819A4793F348BD24C0105EE70")
    public void putAll(Map< ? extends String, ? extends List<V>> mapToPut) {
        {
            Iterator<String> varF1CB148D7070D789DA3D044F6B603FDC_1751435596 = (mapToPut.keySet()).iterator();
            varF1CB148D7070D789DA3D044F6B603FDC_1751435596.hasNext();
            String k = varF1CB148D7070D789DA3D044F6B603FDC_1751435596.next();
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.898 -0400", hash_original_field = "CFD525E80C90A9F4632ED696EA4A2C3A", hash_generated_field = "39B8D8A67D3867ED06FF4538FB4D4551")

    private static long serialVersionUID = 4275505380960964605L;
}

