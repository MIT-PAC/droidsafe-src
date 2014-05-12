package gov.nist.core;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MultiValueMapImpl<V> implements MultiValueMap<String, V>, Cloneable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.016 -0500", hash_original_field = "3B997311D3D318FE0ED78E80D905A3F0", hash_generated_field = "A182B7666DFBDE7AEB9947BAE926EB53")

    private static final long serialVersionUID = 4275505380960964605L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.014 -0500", hash_original_field = "FFACFEC1D816CE2FD3ED2B5D447867BF", hash_generated_field = "7CFE38AEC9CFBA4A360ACB9AB9A4320E")

    private HashMap<String, ArrayList<V>> map = new HashMap<String, ArrayList<V>>();

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.019 -0500", hash_original_method = "92FBF841CDA8BB538E9BCFC9D2E80E36", hash_generated_method = "365E207D667D243D23CD1C022BBE4132")
    
public MultiValueMapImpl() {
        super();

    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.021 -0500", hash_original_method = "015B36338D34B6EBF400464F225017F7", hash_generated_method = "A0EF9E4F18A993D8B1918CB90B56E3DE")
    
public List<V> put(String key, V value) {
        ArrayList<V> keyList = map.get(key);
        if (keyList == null) {
            keyList = new ArrayList<V>(10);
            map.put(key, keyList);
        }

        keyList.add(value);
        return keyList;
    }

    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.024 -0500", hash_original_method = "DB86C9FAE576BDCBCAB6ACEF27E24DCF", hash_generated_method = "CEE0A46C40FD207E07B1C5B3BE4B14F0")
    
public boolean containsValue(Object value) {
        Set pairs = map.entrySet();

        if (pairs == null)
            return false;

        Iterator pairsIterator = pairs.iterator();
        while (pairsIterator.hasNext()) {
            Map.Entry keyValuePair = (Map.Entry) (pairsIterator.next());
            ArrayList list = (ArrayList) (keyValuePair.getValue());
            if (list.contains(value))
                return true;
        }
        return false;
    }

    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.027 -0500", hash_original_method = "ACD58D82904FAC9C1E105DF6132F728F", hash_generated_method = "733C6DFCBE2A2BCE4B58528AD4BE67AE")
    
public void clear() {
        Set pairs = map.entrySet();
        Iterator pairsIterator = pairs.iterator();
        while (pairsIterator.hasNext()) {
            Map.Entry keyValuePair = (Map.Entry) (pairsIterator.next());
            ArrayList list = (ArrayList) (keyValuePair.getValue());
            list.clear();
        }
        map.clear();
    }

    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.029 -0500", hash_original_method = "9D94995CB4905B7A6A15BF37AA0AF804", hash_generated_method = "9975EB8392C975BCAF68262BC906C38C")
    
public Collection values() {
        ArrayList returnList = new ArrayList(map.size());

        Set pairs = map.entrySet();
        Iterator pairsIterator = pairs.iterator();
        while (pairsIterator.hasNext()) {
            Map.Entry keyValuePair = (Map.Entry) (pairsIterator.next());
            ArrayList list = (ArrayList) (keyValuePair.getValue());

            Object[] values = list.toArray();
            for (int ii = 0; ii < values.length; ii++) {
                returnList.add(values[ii]);
            }
        }
        return returnList;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.031 -0500", hash_original_method = "7FD8976C5EB94AF5BEDA5274AB7D4960", hash_generated_method = "C5EFC9B836DA8EF189C1836B03049C57")
    
public Object clone() {
        MultiValueMapImpl obj = new MultiValueMapImpl<V>();
        obj.map = (HashMap<Object, ArrayList<V>>) this.map.clone();
        return obj;
    }

    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.034 -0500", hash_original_method = "5426196537489B9F267A5D92E091E0D1", hash_generated_method = "906D6ACA90D2AB1C36E2015BAA5F50F9")
    
public int size() {
        return this.map.size();
    }

    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.036 -0500", hash_original_method = "51FDEF8A21E6EA5E0FB4715F8113FE74", hash_generated_method = "C774AF9EFA934E85591394B11D4C7343")
    
public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.038 -0500", hash_original_method = "A7117DE6FDE9AB582C79C19A4704EAC3", hash_generated_method = "DF3843AF12A68342434DE17C6F4FCFF5")
    
public Set entrySet() {
        return map.entrySet();
    }

    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.041 -0500", hash_original_method = "193F4487BCC4A9B88FB28866363E7ABF", hash_generated_method = "18D56647BDCE89DD9DAE584B2203FB91")
    
public boolean isEmpty() {
        return map.isEmpty();
    }

    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.044 -0500", hash_original_method = "6CB9892D3A46557FDBF8DC408603010A", hash_generated_method = "7D1023C6550D4C0BAD63D4E2C5DA6F28")
    
public Set<String> keySet() {
        return this.map.keySet();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.048 -0500", hash_original_method = "7F32EDF5FAFC7BC56577B23C28284BD1", hash_generated_method = "9BEF0E8DB7FDD590B04185ED92F77C24")
    
public Object remove(String key, V item) {
        ArrayList<V> list = this.map.get(key);
        if (list == null) {
            return null;
        } else {
            return list.remove(item);
        }
    }

    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.051 -0500", hash_original_method = "08F032B341F8C34A7104B10254E1B693", hash_generated_method = "50D00F6756BC4700D7C0AD4E12C562D1")
    
public List<V> get(Object key) {
        return map.get(key);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.053 -0500", hash_original_method = "23A91A040F7CE5CCEDDB4E75AB426F56", hash_generated_method = "A2C99B25153A12E1942A45EA141F9896")
    
public List<V> put(String key, List<V> value) {
        return this.map.put(key,(ArrayList<V>) value);
    }

    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.225 -0500", hash_original_method = "7B07E9B7FC8B36A67A63DC78734F6C09", hash_generated_method = "6A7958B0A3022682292CF76F808DF8BB")
    
public List<V> remove(Object key) {
        return map.remove(key);
    }
    
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.228 -0500", hash_original_method = "FD6B4077E86FCBA56C835917C4A62A14", hash_generated_method = "C9EC4CB251B636155E1D730CE89CB5C5")
    
public void putAll(Map< ? extends String, ? extends List<V>> mapToPut) {
        for (String k : mapToPut.keySet()) {
            ArrayList<V> al = new ArrayList<V>();
            al.addAll(mapToPut.get(k));
            this.map.put(k, al);
        }  
    }
}

