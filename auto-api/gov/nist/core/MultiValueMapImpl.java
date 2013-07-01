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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.699 -0400", hash_original_field = "160FA6EE5E99052B187A1F80FEB63F9A", hash_generated_field = "7CFE38AEC9CFBA4A360ACB9AB9A4320E")

    private HashMap<String, ArrayList<V>> map = new HashMap<String, ArrayList<V>>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.699 -0400", hash_original_method = "92FBF841CDA8BB538E9BCFC9D2E80E36", hash_generated_method = "BBAE31DA49C30209803972329341FA59")
    public  MultiValueMapImpl() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.700 -0400", hash_original_method = "015B36338D34B6EBF400464F225017F7", hash_generated_method = "A154EEF568C220EBE286DEEF9CCF0FB9")
    public List<V> put(String key, V value) {
        List<V> varB4EAC82CA7396A68D541C85D26508E83_2050554989 = null; //Variable for return #1
        ArrayList<V> keyList = map.get(key);
        {
            keyList = new ArrayList<V>(10);
            map.put(key, keyList);
        } //End block
        keyList.add(value);
        varB4EAC82CA7396A68D541C85D26508E83_2050554989 = keyList;
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2050554989.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2050554989;
        // ---------- Original Method ----------
        //ArrayList<V> keyList = map.get(key);
        //if (keyList == null) {
            //keyList = new ArrayList<V>(10);
            //map.put(key, keyList);
        //}
        //keyList.add(value);
        //return keyList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.700 -0400", hash_original_method = "DB86C9FAE576BDCBCAB6ACEF27E24DCF", hash_generated_method = "431CDB2FA03BAFAE9F75A65D815013B6")
    public boolean containsValue(Object value) {
        Set pairs = map.entrySet();
        Iterator pairsIterator = pairs.iterator();
        {
            boolean varAFC1C232FAFCF3B88BE1C2040FEA85C1_934722351 = (pairsIterator.hasNext());
            {
                Map.Entry keyValuePair = (Map.Entry) (pairsIterator.next());
                ArrayList list = (ArrayList) (keyValuePair.getValue());
                {
                    boolean var4A1616F333FF43E87183886DC3AB20B0_720164535 = (list.contains(value));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1555796514 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1555796514;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.701 -0400", hash_original_method = "ACD58D82904FAC9C1E105DF6132F728F", hash_generated_method = "91A27A6C322498CB26A888D36B0C7A90")
    public void clear() {
        Set pairs = map.entrySet();
        Iterator pairsIterator = pairs.iterator();
        {
            boolean varAFC1C232FAFCF3B88BE1C2040FEA85C1_1379580537 = (pairsIterator.hasNext());
            {
                Map.Entry keyValuePair = (Map.Entry) (pairsIterator.next());
                ArrayList list = (ArrayList) (keyValuePair.getValue());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.702 -0400", hash_original_method = "9D94995CB4905B7A6A15BF37AA0AF804", hash_generated_method = "5C82BC4D34A905F0AA3CAADB18FA5624")
    public Collection values() {
        Collection varB4EAC82CA7396A68D541C85D26508E83_191203306 = null; //Variable for return #1
        ArrayList returnList = new ArrayList(map.size());
        Set pairs = map.entrySet();
        Iterator pairsIterator = pairs.iterator();
        {
            boolean varAFC1C232FAFCF3B88BE1C2040FEA85C1_1132142205 = (pairsIterator.hasNext());
            {
                Map.Entry keyValuePair = (Map.Entry) (pairsIterator.next());
                ArrayList list = (ArrayList) (keyValuePair.getValue());
                Object[] values = list.toArray();
                {
                    int ii = 0;
                    {
                        returnList.add(values[ii]);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_191203306 = returnList;
        varB4EAC82CA7396A68D541C85D26508E83_191203306.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_191203306;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.703 -0400", hash_original_method = "7FD8976C5EB94AF5BEDA5274AB7D4960", hash_generated_method = "7B3A3A30E0C26170DF02055EAE02E07F")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_761509769 = null; //Variable for return #1
        MultiValueMapImpl obj = new MultiValueMapImpl<V>();
        obj.map = (HashMap<Object, ArrayList<V>>) this.map.clone();
        varB4EAC82CA7396A68D541C85D26508E83_761509769 = obj;
        varB4EAC82CA7396A68D541C85D26508E83_761509769.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_761509769;
        // ---------- Original Method ----------
        //MultiValueMapImpl obj = new MultiValueMapImpl<V>();
        //obj.map = (HashMap<Object, ArrayList<V>>) this.map.clone();
        //return obj;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.704 -0400", hash_original_method = "5426196537489B9F267A5D92E091E0D1", hash_generated_method = "9E0F621EE25DBD926A5AC5449F634FFF")
    public int size() {
        int varE3E5330F94254BCBA3E355D469C195F3_114627884 = (this.map.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_941859151 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_941859151;
        // ---------- Original Method ----------
        //return this.map.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.705 -0400", hash_original_method = "51FDEF8A21E6EA5E0FB4715F8113FE74", hash_generated_method = "7C0F8B5A95796668D1AC2090FE1989BD")
    public boolean containsKey(Object key) {
        boolean var56EC89656FCA0EA2E21B790CBA0BA5A2_1561576943 = (map.containsKey(key));
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_924649569 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_924649569;
        // ---------- Original Method ----------
        //return map.containsKey(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.706 -0400", hash_original_method = "A7117DE6FDE9AB582C79C19A4704EAC3", hash_generated_method = "D34A81290E1BC6CAC05182D764A937BF")
    public Set entrySet() {
        Set varB4EAC82CA7396A68D541C85D26508E83_328675714 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_328675714 = map.entrySet();
        varB4EAC82CA7396A68D541C85D26508E83_328675714.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_328675714;
        // ---------- Original Method ----------
        //return map.entrySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.706 -0400", hash_original_method = "193F4487BCC4A9B88FB28866363E7ABF", hash_generated_method = "F0ECA116A7635ECA49AC26441527845D")
    public boolean isEmpty() {
        boolean var59C8754218A5378301A7B2210B450A8A_1302366885 = (map.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1019626872 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1019626872;
        // ---------- Original Method ----------
        //return map.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.706 -0400", hash_original_method = "6CB9892D3A46557FDBF8DC408603010A", hash_generated_method = "D97B0081184267D751E1EBA3CF7BFA7F")
    public Set<String> keySet() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_2132124689 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2132124689 = this.map.keySet();
        varB4EAC82CA7396A68D541C85D26508E83_2132124689.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2132124689;
        // ---------- Original Method ----------
        //return this.map.keySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.707 -0400", hash_original_method = "7F32EDF5FAFC7BC56577B23C28284BD1", hash_generated_method = "E4BD5008F6C17745B765133A32F5521A")
    public Object remove(String key, V item) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1348101848 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_284966077 = null; //Variable for return #2
        ArrayList<V> list = this.map.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1348101848 = null;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_284966077 = list.remove(item);
        } //End block
        addTaint(key.getTaint());
        addTaint(item.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_1319723763; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1319723763 = varB4EAC82CA7396A68D541C85D26508E83_1348101848;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1319723763 = varB4EAC82CA7396A68D541C85D26508E83_284966077;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1319723763.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1319723763;
        // ---------- Original Method ----------
        //ArrayList<V> list = this.map.get(key);
        //if (list == null) {
            //return null;
        //} else {
            //return list.remove(item);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.707 -0400", hash_original_method = "08F032B341F8C34A7104B10254E1B693", hash_generated_method = "88CB5A59D6C7FE07824CDFAF4527CBB4")
    public List<V> get(Object key) {
        List<V> varB4EAC82CA7396A68D541C85D26508E83_745160427 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_745160427 = map.get(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_745160427.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_745160427;
        // ---------- Original Method ----------
        //return map.get(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.708 -0400", hash_original_method = "23A91A040F7CE5CCEDDB4E75AB426F56", hash_generated_method = "0CE4CB9FD5C9B9503DA998E1C38AC669")
    public List<V> put(String key, List<V> value) {
        List<V> varB4EAC82CA7396A68D541C85D26508E83_1533313947 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1533313947 = this.map.put(key,(ArrayList<V>) value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1533313947.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1533313947;
        // ---------- Original Method ----------
        //return this.map.put(key,(ArrayList<V>) value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.708 -0400", hash_original_method = "7B07E9B7FC8B36A67A63DC78734F6C09", hash_generated_method = "4FDEFFBDE04AE1A2412E1DD79B11C21D")
    public List<V> remove(Object key) {
        List<V> varB4EAC82CA7396A68D541C85D26508E83_2141038622 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2141038622 = map.remove(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2141038622.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2141038622;
        // ---------- Original Method ----------
        //return map.remove(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.715 -0400", hash_original_method = "FD6B4077E86FCBA56C835917C4A62A14", hash_generated_method = "126ED89B9E623405C2AE3244B3BCEA6B")
    public void putAll(Map< ? extends String, ? extends List<V>> mapToPut) {
        {
            Iterator<String> varF1CB148D7070D789DA3D044F6B603FDC_1640892939 = (Iterator<String>) (mapToPut.keySet()).iterator();
            varF1CB148D7070D789DA3D044F6B603FDC_1640892939.hasNext();
            String k = varF1CB148D7070D789DA3D044F6B603FDC_1640892939.next();
            {
                ArrayList<V> al = new ArrayList<V>();
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.715 -0400", hash_original_field = "CFD525E80C90A9F4632ED696EA4A2C3A", hash_generated_field = "A182B7666DFBDE7AEB9947BAE926EB53")

    private static final long serialVersionUID = 4275505380960964605L;
}

