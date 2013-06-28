package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectInputStream.GetField;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import static java.util.TreeMap.Bound.*;
import static java.util.TreeMap.Relation.*;
import libcore.util.Objects;

public class TreeMap<K, V> extends AbstractMap<K, V> implements SortedMap<K, V>, NavigableMap<K, V>, Cloneable, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.386 -0400", hash_original_field = "4092F21BD0E2CC3C9CA971DF59AA8608", hash_generated_field = "10E826BC31BCAB9BF3EF3CC29146C2D4")

    Comparator<? super K> comparator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.386 -0400", hash_original_field = "63A9F0EA7BB98050796B649E85481845", hash_generated_field = "85295BCB9659691A12B83D4313F1A2F9")

    Node<K, V> root;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.386 -0400", hash_original_field = "4C519DE3531208469B40CCB51004CD2D", hash_generated_field = "689FC3CB9A887B5817C15E9CFDD066DB")

    int size = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.386 -0400", hash_original_field = "8626C3CD64A823DD7B97C6F5EF45A8FC", hash_generated_field = "7C38AA8724D6D8AD727BB2AB85887DF0")

    int modCount = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.387 -0400", hash_original_field = "D4E06C98DBA5A687CB6C836BF538EC81", hash_generated_field = "78564EACF73DB0AEDD2E075A8DFF1B13")

    private EntrySet entrySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.387 -0400", hash_original_field = "3E8ABCE844B6A8A95397486A3899B536", hash_generated_field = "455D81AE8BC4090CF8AD993E78862377")

    private KeySet keySet;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.387 -0400", hash_original_method = "A79D85B768A2B786B5F2ACD3F2B9D249", hash_generated_method = "CFE342F2F41F7796DB24A93B3EC5E9D4")
    @SuppressWarnings("unchecked")
    public  TreeMap() {
        this.comparator = (Comparator<? super K>) NATURAL_ORDER;
        // ---------- Original Method ----------
        //this.comparator = (Comparator<? super K>) NATURAL_ORDER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.390 -0400", hash_original_method = "317880CC1AD8B8CC7D9C11CC941EE8C3", hash_generated_method = "D5F7002165857F6E4A37D803A7EDC81E")
    public  TreeMap(Map<? extends K, ? extends V> copyFrom) {
        this();
        {
            copyFrom.entrySet().iterator().hasNext();
            Map.Entry<? extends K, ? extends V> entry = copyFrom.entrySet().iterator().next();
            {
                putInternal(entry.getKey(), entry.getValue());
            } //End block
        } //End collapsed parenthetic
        addTaint(copyFrom.getTaint());
        // ---------- Original Method ----------
        //for (Map.Entry<? extends K, ? extends V> entry : copyFrom.entrySet()) {
            //putInternal(entry.getKey(), entry.getValue());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.391 -0400", hash_original_method = "C1FE892CAD9D3780A675F5A8CA11F4FA", hash_generated_method = "A5FA904989BCCDB3DA871E0B26BCC9ED")
    @SuppressWarnings("unchecked")
    public  TreeMap(Comparator<? super K> comparator) {
        {
            this.comparator = comparator;
        } //End block
        {
            this.comparator = (Comparator<? super K>) NATURAL_ORDER;
        } //End block
        // ---------- Original Method ----------
        //if (comparator != null) {
            //this.comparator = comparator;
        //} else {
            //this.comparator = (Comparator<? super K>) NATURAL_ORDER;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.393 -0400", hash_original_method = "2607F9CE6A88866DC32D385287E67644", hash_generated_method = "B02DEA663401CA54A90B73C624FD16C7")
    @SuppressWarnings("unchecked")
    public  TreeMap(SortedMap<K, ? extends V> copyFrom) {
        Comparator<? super K> sourceComparator = copyFrom.comparator();
        {
            this.comparator = sourceComparator;
        } //End block
        {
            this.comparator = (Comparator<? super K>) NATURAL_ORDER;
        } //End block
        {
            copyFrom.entrySet().iterator().hasNext();
            Map.Entry<K, ? extends V> entry = copyFrom.entrySet().iterator().next();
            {
                putInternal(entry.getKey(), entry.getValue());
            } //End block
        } //End collapsed parenthetic
        addTaint(copyFrom.getTaint());
        // ---------- Original Method ----------
        //Comparator<? super K> sourceComparator = copyFrom.comparator();
        //if (sourceComparator != null) {
            //this.comparator = sourceComparator;
        //} else {
            //this.comparator = (Comparator<? super K>) NATURAL_ORDER;
        //}
        //for (Map.Entry<K, ? extends V> entry : copyFrom.entrySet()) {
            //putInternal(entry.getKey(), entry.getValue());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.394 -0400", hash_original_method = "FB8B1056739768AF92CF25DB3C2D30EB", hash_generated_method = "C66652E53D1EC5CE74E0E0F0D12647B3")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1427926947 = null; //Variable for return #1
        try 
        {
            @SuppressWarnings("unchecked") TreeMap<K, V> map = (TreeMap<K, V>) super.clone();
            map.root = root != null ? root.copy(null) : null;
            map.entrySet = null;
            map.keySet = null;
            varB4EAC82CA7396A68D541C85D26508E83_1427926947 = map;
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1427926947.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1427926947;
        // ---------- Original Method ----------
        //try {
            //@SuppressWarnings("unchecked") 
            //TreeMap<K, V> map = (TreeMap<K, V>) super.clone();
            //map.root = root != null ? root.copy(null) : null;
            //map.entrySet = null;
            //map.keySet = null;
            //return map;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.394 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "F963D8D2561E5C9F8A7DA045BAB3E135")
    @Override
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_102987185 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_102987185;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.395 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "49BE7A4803E6B29B03B26D59E5DB8E46")
    @Override
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1021349901 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1021349901;
        // ---------- Original Method ----------
        //return size == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.395 -0400", hash_original_method = "C35732A40B74AF28951D9E96FE33879B", hash_generated_method = "2240A14FEE0FB869F814BD30003A77CE")
    @Override
    public V get(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_1763815589 = null; //Variable for return #1
        Entry<K, V> entry = findByObject(key);
        varB4EAC82CA7396A68D541C85D26508E83_1763815589 = entry != null ? entry.getValue() : null;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1763815589.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1763815589;
        // ---------- Original Method ----------
        //Entry<K, V> entry = findByObject(key);
        //return entry != null ? entry.getValue() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.395 -0400", hash_original_method = "CD38E6D478445847B9B0A556F5E63837", hash_generated_method = "C795050A497A8EB81A8DD6119401BDB5")
    @Override
    public boolean containsKey(Object key) {
        boolean var169B170947F44477F294694A95E8B219_1693200904 = (findByObject(key) != null);
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_268238277 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_268238277;
        // ---------- Original Method ----------
        //return findByObject(key) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.396 -0400", hash_original_method = "09423F07E68B4770E107529B69AA8334", hash_generated_method = "1FA1E4B60EE47C7FCFED8964FEBC3C13")
    @Override
    public V put(K key, V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_1545896626 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1545896626 = putInternal(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1545896626.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1545896626;
        // ---------- Original Method ----------
        //return putInternal(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.396 -0400", hash_original_method = "EA5BE6ED678D7376259BCC3DB1C01E21", hash_generated_method = "25747B87C7C6F2CC69ED86A75548B960")
    @Override
    public void clear() {
        root = null;
        size = 0;
        // ---------- Original Method ----------
        //root = null;
        //size = 0;
        //modCount++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.397 -0400", hash_original_method = "0207194EB3BB344ADD94A18916C183DF", hash_generated_method = "5E3F840C73ED5A2BF3AAE2560196E2FD")
    @Override
    public V remove(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_796492616 = null; //Variable for return #1
        Node<K, V> node = removeInternalByKey(key);
        varB4EAC82CA7396A68D541C85D26508E83_796492616 = node != null ? node.value : null;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_796492616.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_796492616;
        // ---------- Original Method ----------
        //Node<K, V> node = removeInternalByKey(key);
        //return node != null ? node.value : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.397 -0400", hash_original_method = "73D5DA91D47B13631BBA1FF4FFC14006", hash_generated_method = "230CDD2A6D7EA28A449710DDFE4412E9")
     V putInternal(K key, V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_655521944 = null; //Variable for return #1
        Node<K, V> created = find(key, Relation.CREATE);
        V result = created.value;
        created.value = value;
        varB4EAC82CA7396A68D541C85D26508E83_655521944 = result;
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_655521944.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_655521944;
        // ---------- Original Method ----------
        //Node<K, V> created = find(key, Relation.CREATE);
        //V result = created.value;
        //created.value = value;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.398 -0400", hash_original_method = "A47B461F1595004F5F78D5AE91E8DCD0", hash_generated_method = "0FE26256CD057DF34B9DA0EDBEB8F102")
     Node<K, V> find(K key, Relation relation) {
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1200348515 = null; //Variable for return #1
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_86517620 = null; //Variable for return #2
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_8398286 = null; //Variable for return #3
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_950152985 = null; //Variable for return #4
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1895346137 = null; //Variable for return #5
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1619075097 = null; //Variable for return #6
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_5553854 = null; //Variable for return #7
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1571079583 = null; //Variable for return #8
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_907697366 = null; //Variable for return #9
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1190816592 = null; //Variable for return #10
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_521001657 = null; //Variable for return #11
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_367385604 = null; //Variable for return #12
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1883990829 = null; //Variable for return #13
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new ClassCastException(key.getClass().getName() + " is not Comparable");
            } //End block
            {
                root = new Node<K, V>(null, key);
                size = 1;
                varB4EAC82CA7396A68D541C85D26508E83_1200348515 = root;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_86517620 = null;
            } //End block
        } //End block
        @SuppressWarnings("unchecked") Comparable<Object> comparableKey;
        comparableKey = (Comparable<Object>) key;
        comparableKey = null;
        Node<K, V> nearest = root;
        {
            int comparison;
            comparison = comparableKey.compareTo(nearest.key);
            comparison = comparator.compare(key, nearest.key);
            {
                //Begin case LOWER 
                varB4EAC82CA7396A68D541C85D26508E83_8398286 = nearest.prev();
                //End case LOWER 
                //Begin case FLOOR EQUAL CREATE CEILING 
                varB4EAC82CA7396A68D541C85D26508E83_950152985 = nearest;
                //End case FLOOR EQUAL CREATE CEILING 
                //Begin case HIGHER 
                varB4EAC82CA7396A68D541C85D26508E83_1895346137 = nearest.next();
                //End case HIGHER 
            } //End block
            Node<K, V> child;
            child = nearest.left;
            child = nearest.right;
            {
                nearest = child;
            } //End block
            {
                //Begin case LOWER FLOOR 
                varB4EAC82CA7396A68D541C85D26508E83_1619075097 = nearest.prev();
                //End case LOWER FLOOR 
                //Begin case CEILING HIGHER 
                varB4EAC82CA7396A68D541C85D26508E83_5553854 = nearest;
                //End case CEILING HIGHER 
                //Begin case EQUAL 
                varB4EAC82CA7396A68D541C85D26508E83_1571079583 = null;
                //End case EQUAL 
                //Begin case CREATE 
                Node<K, V> created = new Node<K, V>(nearest, key);
                //End case CREATE 
                //Begin case CREATE 
                nearest.left = created;
                //End case CREATE 
                //Begin case CREATE 
                rebalance(nearest, true);
                //End case CREATE 
                //Begin case CREATE 
                varB4EAC82CA7396A68D541C85D26508E83_907697366 = created;
                //End case CREATE 
            } //End block
            {
                //Begin case LOWER FLOOR 
                varB4EAC82CA7396A68D541C85D26508E83_1190816592 = nearest;
                //End case LOWER FLOOR 
                //Begin case CEILING HIGHER 
                varB4EAC82CA7396A68D541C85D26508E83_521001657 = nearest.next();
                //End case CEILING HIGHER 
                //Begin case EQUAL 
                varB4EAC82CA7396A68D541C85D26508E83_367385604 = null;
                //End case EQUAL 
                //Begin case CREATE 
                Node<K, V> created = new Node<K, V>(nearest, key);
                //End case CREATE 
                //Begin case CREATE 
                nearest.right = created;
                //End case CREATE 
                //Begin case CREATE 
                rebalance(nearest, true);
                //End case CREATE 
                //Begin case CREATE 
                varB4EAC82CA7396A68D541C85D26508E83_1883990829 = created;
                //End case CREATE 
            } //End block
        } //End block
        addTaint(relation.getTaint());
        Node<K, V> varA7E53CE21691AB073D9660D615818899_1368907497; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1368907497 = varB4EAC82CA7396A68D541C85D26508E83_1200348515;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1368907497 = varB4EAC82CA7396A68D541C85D26508E83_86517620;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1368907497 = varB4EAC82CA7396A68D541C85D26508E83_8398286;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1368907497 = varB4EAC82CA7396A68D541C85D26508E83_950152985;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1368907497 = varB4EAC82CA7396A68D541C85D26508E83_1895346137;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_1368907497 = varB4EAC82CA7396A68D541C85D26508E83_1619075097;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_1368907497 = varB4EAC82CA7396A68D541C85D26508E83_5553854;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_1368907497 = varB4EAC82CA7396A68D541C85D26508E83_1571079583;
                break;
            case 9: //Assign result for return ordinal #9
                varA7E53CE21691AB073D9660D615818899_1368907497 = varB4EAC82CA7396A68D541C85D26508E83_907697366;
                break;
            case 10: //Assign result for return ordinal #10
                varA7E53CE21691AB073D9660D615818899_1368907497 = varB4EAC82CA7396A68D541C85D26508E83_1190816592;
                break;
            case 11: //Assign result for return ordinal #11
                varA7E53CE21691AB073D9660D615818899_1368907497 = varB4EAC82CA7396A68D541C85D26508E83_521001657;
                break;
            case 12: //Assign result for return ordinal #12
                varA7E53CE21691AB073D9660D615818899_1368907497 = varB4EAC82CA7396A68D541C85D26508E83_367385604;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1368907497 = varB4EAC82CA7396A68D541C85D26508E83_1883990829;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1368907497.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1368907497;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.400 -0400", hash_original_method = "C267D163E835004AE4803D9A2BC1E552", hash_generated_method = "7C0F0257335ADAB696DE6F7A4D090EF5")
    @SuppressWarnings("unchecked")
     Node<K, V> findByObject(Object key) {
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1467736952 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1467736952 = find((K) key, EQUAL);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1467736952.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1467736952;
        // ---------- Original Method ----------
        //return find((K) key, EQUAL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.400 -0400", hash_original_method = "8678505752B854905CFE7B96C4FE458B", hash_generated_method = "5C738E1A192686E764F0FFB896390737")
     Node<K, V> findByEntry(Entry<?, ?> entry) {
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_855714006 = null; //Variable for return #1
        Node<K, V> mine = findByObject(entry.getKey());
        boolean valuesEqual = mine != null && Objects.equal(mine.value, entry.getValue());
        varB4EAC82CA7396A68D541C85D26508E83_855714006 = valuesEqual ? mine : null;
        addTaint(entry.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_855714006.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_855714006;
        // ---------- Original Method ----------
        //Node<K, V> mine = findByObject(entry.getKey());
        //boolean valuesEqual = mine != null && Objects.equal(mine.value, entry.getValue());
        //return valuesEqual ? mine : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.402 -0400", hash_original_method = "FAD76EC8E4C5DF9CCDE64BA514AC9743", hash_generated_method = "A54D36CF7DAAECE7D0E126F4B346055B")
     void removeInternal(Node<K, V> node) {
        Node<K, V> left = node.left;
        Node<K, V> right = node.right;
        Node<K, V> originalParent = node.parent;
        {
            Node<K, V> adjacent;
            adjacent = left.last();
            adjacent = right.first();
            removeInternal(adjacent);
            int leftHeight = 0;
            left = node.left;
            {
                leftHeight = left.height;
                adjacent.left = left;
                left.parent = adjacent;
                node.left = null;
            } //End block
            int rightHeight = 0;
            right = node.right;
            {
                rightHeight = right.height;
                adjacent.right = right;
                right.parent = adjacent;
                node.right = null;
            } //End block
            adjacent.height = Math.max(leftHeight, rightHeight) + 1;
            replaceInParent(node, adjacent);
        } //End block
        {
            replaceInParent(node, left);
            node.left = null;
        } //End block
        {
            replaceInParent(node, right);
            node.right = null;
        } //End block
        {
            replaceInParent(node, null);
        } //End block
        rebalance(originalParent, false);
        addTaint(node.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.403 -0400", hash_original_method = "C9B9883A6728DC2F4DBB90BDF61B9978", hash_generated_method = "629FC88E14FB6A12C98A308E95421A8A")
     Node<K, V> removeInternalByKey(Object key) {
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_803395287 = null; //Variable for return #1
        Node<K, V> node = findByObject(key);
        {
            removeInternal(node);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_803395287 = node;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_803395287.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_803395287;
        // ---------- Original Method ----------
        //Node<K, V> node = findByObject(key);
        //if (node != null) {
            //removeInternal(node);
        //}
        //return node;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.404 -0400", hash_original_method = "8CBFE12E379E7871AFCE5B0FC5C284CB", hash_generated_method = "C4C7042EC89786AF76EBD765B666E2EF")
    private void replaceInParent(Node<K, V> node, Node<K, V> replacement) {
        Node<K, V> parent = node.parent;
        node.parent = null;
        {
            replacement.parent = parent;
        } //End block
        {
            {
                parent.left = replacement;
            } //End block
            {
                parent.right = replacement;
            } //End block
        } //End block
        {
            root = replacement;
        } //End block
        addTaint(node.getTaint());
        // ---------- Original Method ----------
        //Node<K, V> parent = node.parent;
        //node.parent = null;
        //if (replacement != null) {
            //replacement.parent = parent;
        //}
        //if (parent != null) {
            //if (parent.left == node) {
                //parent.left = replacement;
            //} else {
                //assert (parent.right == node);
                //parent.right = replacement;
            //}
        //} else {
            //root = replacement;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.405 -0400", hash_original_method = "DE22B63E2A021BAF8A5DCC142FCC4B40", hash_generated_method = "CEDE1483B08ABA0D92A258E233B117AB")
    private void rebalance(Node<K, V> unbalanced, boolean insert) {
        {
            Node<K, V> node = unbalanced;
            node = node.parent;
            {
                Node<K, V> left = node.left;
                Node<K, V> right = node.right;
                int leftHeight;
                leftHeight = left.height;
                leftHeight = 0;
                int rightHeight;
                rightHeight = right.height;
                rightHeight = 0;
                int delta = leftHeight - rightHeight;
                {
                    Node<K, V> rightLeft = right.left;
                    Node<K, V> rightRight = right.right;
                    int rightRightHeight;
                    rightRightHeight = rightRight.height;
                    rightRightHeight = 0;
                    int rightLeftHeight;
                    rightLeftHeight = rightLeft.height;
                    rightLeftHeight = 0;
                    int rightDelta = rightLeftHeight - rightRightHeight;
                    {
                        rotateLeft(node);
                    } //End block
                    {
                        rotateRight(right);
                        rotateLeft(node);
                    } //End block
                } //End block
                {
                    Node<K, V> leftLeft = left.left;
                    Node<K, V> leftRight = left.right;
                    int leftRightHeight;
                    leftRightHeight = leftRight.height;
                    leftRightHeight = 0;
                    int leftLeftHeight;
                    leftLeftHeight = leftLeft.height;
                    leftLeftHeight = 0;
                    int leftDelta = leftLeftHeight - leftRightHeight;
                    {
                        rotateRight(node);
                    } //End block
                    {
                        rotateLeft(left);
                        rotateRight(node);
                    } //End block
                } //End block
                {
                    node.height = leftHeight + 1;
                } //End block
                {
                    node.height = Math.max(leftHeight, rightHeight) + 1;
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(unbalanced.getTaint());
        addTaint(insert);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.406 -0400", hash_original_method = "6326CB79DBF89391F00F9AB13B0E81D9", hash_generated_method = "5DC9B49BEAC34E2572A340D6C43BBC6F")
    private void rotateLeft(Node<K, V> root) {
        Node<K, V> left = root.left;
        Node<K, V> pivot = root.right;
        Node<K, V> pivotLeft = pivot.left;
        Node<K, V> pivotRight = pivot.right;
        root.right = pivotLeft;
        {
            pivotLeft.parent = root;
        } //End block
        replaceInParent(root, pivot);
        pivot.left = root;
        root.parent = pivot;
        root.height = Math.max(left != null ? left.height : 0,
                pivotLeft != null ? pivotLeft.height : 0) + 1;
        pivot.height = Math.max(root.height,
                pivotRight != null ? pivotRight.height : 0) + 1;
        // ---------- Original Method ----------
        //Node<K, V> left = root.left;
        //Node<K, V> pivot = root.right;
        //Node<K, V> pivotLeft = pivot.left;
        //Node<K, V> pivotRight = pivot.right;
        //root.right = pivotLeft;
        //if (pivotLeft != null) {
            //pivotLeft.parent = root;
        //}
        //replaceInParent(root, pivot);
        //pivot.left = root;
        //root.parent = pivot;
        //root.height = Math.max(left != null ? left.height : 0,
                //pivotLeft != null ? pivotLeft.height : 0) + 1;
        //pivot.height = Math.max(root.height,
                //pivotRight != null ? pivotRight.height : 0) + 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.406 -0400", hash_original_method = "DF035E309292DEA6067E726F513C85C3", hash_generated_method = "7280F713A9F283337AED95B241E7238A")
    private void rotateRight(Node<K, V> root) {
        Node<K, V> pivot = root.left;
        Node<K, V> right = root.right;
        Node<K, V> pivotLeft = pivot.left;
        Node<K, V> pivotRight = pivot.right;
        root.left = pivotRight;
        {
            pivotRight.parent = root;
        } //End block
        replaceInParent(root, pivot);
        pivot.right = root;
        root.parent = pivot;
        root.height = Math.max(right != null ? right.height : 0,
                pivotRight != null ? pivotRight.height : 0) + 1;
        pivot.height = Math.max(root.height,
                pivotLeft != null ? pivotLeft.height : 0) + 1;
        // ---------- Original Method ----------
        //Node<K, V> pivot = root.left;
        //Node<K, V> right = root.right;
        //Node<K, V> pivotLeft = pivot.left;
        //Node<K, V> pivotRight = pivot.right;
        //root.left = pivotRight;
        //if (pivotRight != null) {
            //pivotRight.parent = root;
        //}
        //replaceInParent(root, pivot);
        //pivot.right = root;
        //root.parent = pivot;
        //root.height = Math.max(right != null ? right.height : 0,
                //pivotRight != null ? pivotRight.height : 0) + 1;
        //pivot.height = Math.max(root.height,
                //pivotLeft != null ? pivotLeft.height : 0) + 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.407 -0400", hash_original_method = "E2F61A98BB539F90A11465C6A8354CE5", hash_generated_method = "BCD6A1318FC886E2DB799DBA9602BCE4")
    private SimpleImmutableEntry<K, V> immutableCopy(Entry<K, V> entry) {
        SimpleImmutableEntry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1406144860 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1406144860 = entry == null ? null : new SimpleImmutableEntry<K, V>(entry);
        addTaint(entry.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1406144860.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1406144860;
        // ---------- Original Method ----------
        //return entry == null ? null : new SimpleImmutableEntry<K, V>(entry);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.408 -0400", hash_original_method = "9F2AE61C584701540103A59451B8FA45", hash_generated_method = "4A9AC0716175D9D3D6A42FA9A7DC84C2")
    public Entry<K, V> firstEntry() {
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1065833757 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1065833757 = immutableCopy(root == null ? null : root.first());
        varB4EAC82CA7396A68D541C85D26508E83_1065833757.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1065833757;
        // ---------- Original Method ----------
        //return immutableCopy(root == null ? null : root.first());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.409 -0400", hash_original_method = "2730A7A2197248AC3B653DF430BA3F4A", hash_generated_method = "B918553EDFA8FF32ECFFC951E3ED550E")
    private Entry<K, V> internalPollFirstEntry() {
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_217515554 = null; //Variable for return #1
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1704654624 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_217515554 = null;
        } //End block
        Node<K, V> result = root.first();
        removeInternal(result);
        varB4EAC82CA7396A68D541C85D26508E83_1704654624 = result;
        Entry<K, V> varA7E53CE21691AB073D9660D615818899_1691670297; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1691670297 = varB4EAC82CA7396A68D541C85D26508E83_217515554;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1691670297 = varB4EAC82CA7396A68D541C85D26508E83_1704654624;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1691670297.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1691670297;
        // ---------- Original Method ----------
        //if (root == null) {
            //return null;
        //}
        //Node<K, V> result = root.first();
        //removeInternal(result);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.410 -0400", hash_original_method = "1456A4986DE10120F25B46536C8BF169", hash_generated_method = "FF0BF27F80C1582EF8ED69AA4E759BE9")
    public Entry<K, V> pollFirstEntry() {
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1263756430 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1263756430 = immutableCopy(internalPollFirstEntry());
        varB4EAC82CA7396A68D541C85D26508E83_1263756430.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1263756430;
        // ---------- Original Method ----------
        //return immutableCopy(internalPollFirstEntry());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.411 -0400", hash_original_method = "B0B89D697E050FAAC6816A6E8B1E56A4", hash_generated_method = "991AA5D89469EF3C55D0FF60B8621014")
    public K firstKey() {
        K varB4EAC82CA7396A68D541C85D26508E83_1393553191 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1393553191 = root.first().getKey();
        varB4EAC82CA7396A68D541C85D26508E83_1393553191.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1393553191;
        // ---------- Original Method ----------
        //if (root == null) {
            //throw new NoSuchElementException();
        //}
        //return root.first().getKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.412 -0400", hash_original_method = "9DDE470F0E6425136CCDC59F74FCDED6", hash_generated_method = "8D9C1A900774B9444AFECBCFB9891DC8")
    public Entry<K, V> lastEntry() {
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_862913174 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_862913174 = immutableCopy(root == null ? null : root.last());
        varB4EAC82CA7396A68D541C85D26508E83_862913174.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_862913174;
        // ---------- Original Method ----------
        //return immutableCopy(root == null ? null : root.last());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.415 -0400", hash_original_method = "A726E2736A4C282A51BDD8062FE5CCFA", hash_generated_method = "58A677179C2E2762EE95978B9CFC05ED")
    private Entry<K, V> internalPollLastEntry() {
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_2099396490 = null; //Variable for return #1
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_569346140 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_2099396490 = null;
        } //End block
        Node<K, V> result = root.last();
        removeInternal(result);
        varB4EAC82CA7396A68D541C85D26508E83_569346140 = result;
        Entry<K, V> varA7E53CE21691AB073D9660D615818899_1997762792; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1997762792 = varB4EAC82CA7396A68D541C85D26508E83_2099396490;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1997762792 = varB4EAC82CA7396A68D541C85D26508E83_569346140;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1997762792.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1997762792;
        // ---------- Original Method ----------
        //if (root == null) {
            //return null;
        //}
        //Node<K, V> result = root.last();
        //removeInternal(result);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.416 -0400", hash_original_method = "5064879999AB9A13D0821F605568F112", hash_generated_method = "F63499AA04A7CC15FA29D1DE715845C1")
    public Entry<K, V> pollLastEntry() {
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_694286300 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_694286300 = immutableCopy(internalPollLastEntry());
        varB4EAC82CA7396A68D541C85D26508E83_694286300.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_694286300;
        // ---------- Original Method ----------
        //return immutableCopy(internalPollLastEntry());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.417 -0400", hash_original_method = "9EE1928205B19C964D03E8011BB7E907", hash_generated_method = "56A5F9B9C9F656DA254B69F362F4DF2F")
    public K lastKey() {
        K varB4EAC82CA7396A68D541C85D26508E83_901563863 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_901563863 = root.last().getKey();
        varB4EAC82CA7396A68D541C85D26508E83_901563863.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_901563863;
        // ---------- Original Method ----------
        //if (root == null) {
            //throw new NoSuchElementException();
        //}
        //return root.last().getKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.418 -0400", hash_original_method = "9D71F38DCAD7DBC2AA9FACCDA9CF4866", hash_generated_method = "7063EC84489AC69D32B2C2C1CC36D7C0")
    public Entry<K, V> lowerEntry(K key) {
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1594734185 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1594734185 = immutableCopy(find(key, LOWER));
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1594734185.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1594734185;
        // ---------- Original Method ----------
        //return immutableCopy(find(key, LOWER));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.418 -0400", hash_original_method = "BC9464ECC7239B355BB45B80204BADD6", hash_generated_method = "4CAC26ED96FD73B2117D1BD7FE21C619")
    public K lowerKey(K key) {
        K varB4EAC82CA7396A68D541C85D26508E83_387542399 = null; //Variable for return #1
        Entry<K, V> entry = find(key, LOWER);
        varB4EAC82CA7396A68D541C85D26508E83_387542399 = entry != null ? entry.getKey() : null;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_387542399.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_387542399;
        // ---------- Original Method ----------
        //Entry<K, V> entry = find(key, LOWER);
        //return entry != null ? entry.getKey() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.419 -0400", hash_original_method = "5D12D4D534218428856149792C7C973A", hash_generated_method = "EA9B6A81D09C867AFD63654A6934898D")
    public Entry<K, V> floorEntry(K key) {
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1734900667 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1734900667 = immutableCopy(find(key, FLOOR));
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1734900667.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1734900667;
        // ---------- Original Method ----------
        //return immutableCopy(find(key, FLOOR));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.419 -0400", hash_original_method = "9E3521C1E5D0BB4CA97E65B4B91FC561", hash_generated_method = "1C819544BDE6AF40D80096F6AB4553DB")
    public K floorKey(K key) {
        K varB4EAC82CA7396A68D541C85D26508E83_645164768 = null; //Variable for return #1
        Entry<K, V> entry = find(key, FLOOR);
        varB4EAC82CA7396A68D541C85D26508E83_645164768 = entry != null ? entry.getKey() : null;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_645164768.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_645164768;
        // ---------- Original Method ----------
        //Entry<K, V> entry = find(key, FLOOR);
        //return entry != null ? entry.getKey() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.420 -0400", hash_original_method = "14BBCA12BBBC651385215255CDF3836D", hash_generated_method = "90474922288A98C84660F3A7BD27374F")
    public Entry<K, V> ceilingEntry(K key) {
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_396126761 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_396126761 = immutableCopy(find(key, CEILING));
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_396126761.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_396126761;
        // ---------- Original Method ----------
        //return immutableCopy(find(key, CEILING));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.420 -0400", hash_original_method = "818E984E93F7F07D0C27D2493F11C2A5", hash_generated_method = "B7866F878211D1BFB6B29674AAB939D0")
    public K ceilingKey(K key) {
        K varB4EAC82CA7396A68D541C85D26508E83_1848421305 = null; //Variable for return #1
        Entry<K, V> entry = find(key, CEILING);
        varB4EAC82CA7396A68D541C85D26508E83_1848421305 = entry != null ? entry.getKey() : null;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1848421305.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1848421305;
        // ---------- Original Method ----------
        //Entry<K, V> entry = find(key, CEILING);
        //return entry != null ? entry.getKey() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.421 -0400", hash_original_method = "AC2414FDDF42A1318F8CC45C80E09BC1", hash_generated_method = "0F8A20502B612D434A53A197453314DB")
    public Entry<K, V> higherEntry(K key) {
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_927099321 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_927099321 = immutableCopy(find(key, HIGHER));
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_927099321.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_927099321;
        // ---------- Original Method ----------
        //return immutableCopy(find(key, HIGHER));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.421 -0400", hash_original_method = "0C080E769BA3B62EBC93442ECCB0FC7D", hash_generated_method = "C702440C38AD4AE03083F64643FF276D")
    public K higherKey(K key) {
        K varB4EAC82CA7396A68D541C85D26508E83_1274003298 = null; //Variable for return #1
        Entry<K, V> entry = find(key, HIGHER);
        varB4EAC82CA7396A68D541C85D26508E83_1274003298 = entry != null ? entry.getKey() : null;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1274003298.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1274003298;
        // ---------- Original Method ----------
        //Entry<K, V> entry = find(key, HIGHER);
        //return entry != null ? entry.getKey() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.422 -0400", hash_original_method = "6A8618E17145F23513711DA8498038AE", hash_generated_method = "659468C70B1C19C79EB3EB6D244598E4")
    public Comparator<? super K> comparator() {
        Comparator<? super K> varB4EAC82CA7396A68D541C85D26508E83_236454803 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_236454803 = comparator != NATURAL_ORDER ? comparator : null;
        varB4EAC82CA7396A68D541C85D26508E83_236454803.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_236454803;
        // ---------- Original Method ----------
        //return comparator != NATURAL_ORDER ? comparator : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.423 -0400", hash_original_method = "D2C4C51D99D6D10356C2F96D116110D2", hash_generated_method = "7FBAB4437136C81CD0C16873D03327D7")
    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_2069200208 = null; //Variable for return #1
        EntrySet result = entrySet;
        varB4EAC82CA7396A68D541C85D26508E83_2069200208 = result != null ? result : (entrySet = new EntrySet());
        varB4EAC82CA7396A68D541C85D26508E83_2069200208.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2069200208;
        // ---------- Original Method ----------
        //EntrySet result = entrySet;
        //return result != null ? result : (entrySet = new EntrySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.423 -0400", hash_original_method = "0E17D4043440FAA66222611D1AC45111", hash_generated_method = "D0B5C26D753450D81975EA4B8FC86319")
    @Override
    public Set<K> keySet() {
        Set<K> varB4EAC82CA7396A68D541C85D26508E83_1394811731 = null; //Variable for return #1
        KeySet result = keySet;
        varB4EAC82CA7396A68D541C85D26508E83_1394811731 = result != null ? result : (keySet = new KeySet());
        varB4EAC82CA7396A68D541C85D26508E83_1394811731.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1394811731;
        // ---------- Original Method ----------
        //KeySet result = keySet;
        //return result != null ? result : (keySet = new KeySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.424 -0400", hash_original_method = "016115EA38C293C7AAA8E892AEA754CA", hash_generated_method = "A3892636C54CE81EFF2AF150C3CB20B3")
    public NavigableSet<K> navigableKeySet() {
        NavigableSet<K> varB4EAC82CA7396A68D541C85D26508E83_237772288 = null; //Variable for return #1
        KeySet result = keySet;
        varB4EAC82CA7396A68D541C85D26508E83_237772288 = result != null ? result : (keySet = new KeySet());
        varB4EAC82CA7396A68D541C85D26508E83_237772288.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_237772288;
        // ---------- Original Method ----------
        //KeySet result = keySet;
        //return result != null ? result : (keySet = new KeySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.424 -0400", hash_original_method = "DA6DE2093EE8DE46EE4576501F54E528", hash_generated_method = "D95FAEB096E4232EB119D3123588FDD7")
    public NavigableMap<K, V> subMap(K from, boolean fromInclusive, K to, boolean toInclusive) {
        NavigableMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_752315601 = null; //Variable for return #1
        Bound fromBound;
        fromBound = INCLUSIVE;
        fromBound = EXCLUSIVE;
        Bound toBound;
        toBound = INCLUSIVE;
        toBound = EXCLUSIVE;
        varB4EAC82CA7396A68D541C85D26508E83_752315601 = new BoundedMap(true, from, fromBound, to, toBound);
        addTaint(from.getTaint());
        addTaint(fromInclusive);
        addTaint(to.getTaint());
        addTaint(toInclusive);
        varB4EAC82CA7396A68D541C85D26508E83_752315601.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_752315601;
        // ---------- Original Method ----------
        //Bound fromBound = fromInclusive ? INCLUSIVE : EXCLUSIVE;
        //Bound toBound = toInclusive ? INCLUSIVE : EXCLUSIVE;
        //return new BoundedMap(true, from, fromBound, to, toBound);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.425 -0400", hash_original_method = "193BA03007E91EBBDB489C20B60BFC88", hash_generated_method = "69513147111FD6BB261B06841B96C621")
    public SortedMap<K, V> subMap(K fromInclusive, K toExclusive) {
        SortedMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_1492347468 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1492347468 = new BoundedMap(true, fromInclusive, INCLUSIVE, toExclusive, EXCLUSIVE);
        addTaint(fromInclusive.getTaint());
        addTaint(toExclusive.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1492347468.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1492347468;
        // ---------- Original Method ----------
        //return new BoundedMap(true, fromInclusive, INCLUSIVE, toExclusive, EXCLUSIVE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.425 -0400", hash_original_method = "FA312E74B0C04D741489E3323E0FFDFE", hash_generated_method = "7F831C2D0F22D5067DEEA8CD574B9BAE")
    public NavigableMap<K, V> headMap(K to, boolean inclusive) {
        NavigableMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_1331932182 = null; //Variable for return #1
        Bound toBound;
        toBound = INCLUSIVE;
        toBound = EXCLUSIVE;
        varB4EAC82CA7396A68D541C85D26508E83_1331932182 = new BoundedMap(true, null, NO_BOUND, to, toBound);
        addTaint(to.getTaint());
        addTaint(inclusive);
        varB4EAC82CA7396A68D541C85D26508E83_1331932182.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1331932182;
        // ---------- Original Method ----------
        //Bound toBound = inclusive ? INCLUSIVE : EXCLUSIVE;
        //return new BoundedMap(true, null, NO_BOUND, to, toBound);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.426 -0400", hash_original_method = "CAC178CA3C39A0AC08FB27C63F9A635C", hash_generated_method = "740F6AED9663658C7CF05A8D81251DCA")
    public SortedMap<K, V> headMap(K toExclusive) {
        SortedMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_276702073 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_276702073 = new BoundedMap(true, null, NO_BOUND, toExclusive, EXCLUSIVE);
        addTaint(toExclusive.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_276702073.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_276702073;
        // ---------- Original Method ----------
        //return new BoundedMap(true, null, NO_BOUND, toExclusive, EXCLUSIVE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.426 -0400", hash_original_method = "828BC950C20B857C189141DA99499F09", hash_generated_method = "B726776156DFA8E3109F174D3DBC62A9")
    public NavigableMap<K, V> tailMap(K from, boolean inclusive) {
        NavigableMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_973340906 = null; //Variable for return #1
        Bound fromBound;
        fromBound = INCLUSIVE;
        fromBound = EXCLUSIVE;
        varB4EAC82CA7396A68D541C85D26508E83_973340906 = new BoundedMap(true, from, fromBound, null, NO_BOUND);
        addTaint(from.getTaint());
        addTaint(inclusive);
        varB4EAC82CA7396A68D541C85D26508E83_973340906.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_973340906;
        // ---------- Original Method ----------
        //Bound fromBound = inclusive ? INCLUSIVE : EXCLUSIVE;
        //return new BoundedMap(true, from, fromBound, null, NO_BOUND);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.427 -0400", hash_original_method = "79B47D2E0956F27B23E0B18E5FD19D6A", hash_generated_method = "50CF78B4648DA97F93EE02368F883F25")
    public SortedMap<K, V> tailMap(K fromInclusive) {
        SortedMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_1665009934 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1665009934 = new BoundedMap(true, fromInclusive, INCLUSIVE, null, NO_BOUND);
        addTaint(fromInclusive.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1665009934.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1665009934;
        // ---------- Original Method ----------
        //return new BoundedMap(true, fromInclusive, INCLUSIVE, null, NO_BOUND);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.427 -0400", hash_original_method = "5AD6A5A37D3C9366BEF11B75DC396D31", hash_generated_method = "6CF049FCCAF9D718751EA725A88F14D9")
    public NavigableMap<K, V> descendingMap() {
        NavigableMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_1250203342 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1250203342 = new BoundedMap(false, null, NO_BOUND, null, NO_BOUND);
        varB4EAC82CA7396A68D541C85D26508E83_1250203342.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1250203342;
        // ---------- Original Method ----------
        //return new BoundedMap(false, null, NO_BOUND, null, NO_BOUND);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.427 -0400", hash_original_method = "1207DF79B9959BCB242E95030D6177B0", hash_generated_method = "3F7A6B551F1280E6DE73B3B8BDC598B0")
    public NavigableSet<K> descendingKeySet() {
        NavigableSet<K> varB4EAC82CA7396A68D541C85D26508E83_2002068576 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2002068576 = new BoundedMap(false, null, NO_BOUND, null, NO_BOUND).navigableKeySet();
        varB4EAC82CA7396A68D541C85D26508E83_2002068576.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2002068576;
        // ---------- Original Method ----------
        //return new BoundedMap(false, null, NO_BOUND, null, NO_BOUND).navigableKeySet();
    }

    
    static int count(Iterator<?> iterator) {
        int count = 0;
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }
        return count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.434 -0400", hash_original_method = "BF81D129CE69F9BEB40CAD27F974F3C8", hash_generated_method = "FA17D74F3406DDC95B97EBEB3D9152AC")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.putFields().put("comparator", comparator != NATURAL_ORDER ? comparator : null);
        stream.writeFields();
        stream.writeInt(size);
        {
            Iterator<Map.Entry<K, V>> var40A6EBFD1C8AB95DF2D9F4B462803CBE_1120747879 = (entrySet()).iterator();
            var40A6EBFD1C8AB95DF2D9F4B462803CBE_1120747879.hasNext();
            Map.Entry<K, V> entry = var40A6EBFD1C8AB95DF2D9F4B462803CBE_1120747879.next();
            {
                stream.writeObject(entry.getKey());
                stream.writeObject(entry.getValue());
            } //End block
        } //End collapsed parenthetic
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        //stream.putFields().put("comparator", comparator != NATURAL_ORDER ? comparator : null);
        //stream.writeFields();
        //stream.writeInt(size);
        //for (Map.Entry<K, V> entry : entrySet()) {
            //stream.writeObject(entry.getKey());
            //stream.writeObject(entry.getValue());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.436 -0400", hash_original_method = "4DE82E48A11AFCCB2DCFEAE704B1F475", hash_generated_method = "FF6A51E8B15D705FB556D3698CC65CE5")
    @SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        GetField fields = stream.readFields();
        comparator = (Comparator<? super K>) fields.get("comparator", null);
        {
            comparator = (Comparator<? super K>) NATURAL_ORDER;
        } //End block
        int size = stream.readInt();
        {
            int i = 0;
            {
                putInternal((K) stream.readObject(), (V) stream.readObject());
            } //End block
        } //End collapsed parenthetic
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        //GetField fields = stream.readFields();
        //comparator = (Comparator<? super K>) fields.get("comparator", null);
        //if (comparator == null) {
            //comparator = (Comparator<? super K>) NATURAL_ORDER;
        //}
        //int size = stream.readInt();
        //for (int i = 0; i < size; i++) {
            //putInternal((K) stream.readObject(), (V) stream.readObject());
        //}
    }

    
    enum Relation {
        LOWER,
        FLOOR,
        EQUAL,
        CREATE,
        CEILING,
        HIGHER;
        Relation forOrder(boolean ascending) {
            if (ascending) {
                return this;
            }
            switch (this) {
                case LOWER:
                    return HIGHER;
                case FLOOR:
                    return CEILING;
                case EQUAL:
                    return EQUAL;
                case CEILING:
                    return FLOOR;
                case HIGHER:
                    return LOWER;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    
    static class Node<K, V> implements Map.Entry<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.437 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "8813BD57943FF9B7DFC4722D0BF25C24")

        Node<K, V> parent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.437 -0400", hash_original_field = "811882FECD5C7618D7099EBBD39EA254", hash_generated_field = "25F53C0BDEE77B7CD3BD6D035AA5E15F")

        Node<K, V> left;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.437 -0400", hash_original_field = "7C4F29407893C334A6CB7A87BF045C0D", hash_generated_field = "37DD2CA6D859801A463F8F880FD4F30D")

        Node<K, V> right;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.437 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "F780C5984CF24E477CB9559E91475987")

        K key;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.437 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "A7E8A049E4C72FD5713D3AFD6CBF7C08")

        V value;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.437 -0400", hash_original_field = "B435E227D5DD201E1768B2BCB2E0AA81", hash_generated_field = "CE84F1587D182C1F0A32D7CD44443A18")

        int height;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.438 -0400", hash_original_method = "62891C3DA898C4CAE2A216E3248BC6D0", hash_generated_method = "DE342B9B0B30391F4646033D3553010C")
          Node(Node<K, V> parent, K key) {
            this.parent = parent;
            this.key = key;
            this.height = 1;
            // ---------- Original Method ----------
            //this.parent = parent;
            //this.key = key;
            //this.height = 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.440 -0400", hash_original_method = "81E3C4E28B5839A0B87A03CA341E9BD1", hash_generated_method = "EEEC57CAB91B2114BA34507AC8FB2731")
         Node<K, V> copy(Node<K, V> parent) {
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1731283071 = null; //Variable for return #1
            Node<K, V> result = new Node<K, V>(parent, key);
            {
                result.left = left.copy(result);
            } //End block
            {
                result.right = right.copy(result);
            } //End block
            result.value = value;
            result.height = height;
            varB4EAC82CA7396A68D541C85D26508E83_1731283071 = result;
            addTaint(parent.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1731283071.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1731283071;
            // ---------- Original Method ----------
            //Node<K, V> result = new Node<K, V>(parent, key);
            //if (left != null) {
                //result.left = left.copy(result);
            //}
            //if (right != null) {
                //result.right = right.copy(result);
            //}
            //result.value = value;
            //result.height = height;
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.442 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "C3D53D0364457210510871F9478A571C")
        public K getKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_1197142223 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1197142223 = key;
            varB4EAC82CA7396A68D541C85D26508E83_1197142223.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1197142223;
            // ---------- Original Method ----------
            //return key;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.442 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "CD0380B674DC5230363AD9294C879537")
        public V getValue() {
            V varB4EAC82CA7396A68D541C85D26508E83_960759236 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_960759236 = value;
            varB4EAC82CA7396A68D541C85D26508E83_960759236.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_960759236;
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.444 -0400", hash_original_method = "B73895AEE255DB24C138E57D2456050E", hash_generated_method = "045A01A5235C1A456072929EA73034FB")
        public V setValue(V value) {
            V varB4EAC82CA7396A68D541C85D26508E83_544698100 = null; //Variable for return #1
            V oldValue = this.value;
            this.value = value;
            varB4EAC82CA7396A68D541C85D26508E83_544698100 = oldValue;
            varB4EAC82CA7396A68D541C85D26508E83_544698100.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_544698100;
            // ---------- Original Method ----------
            //V oldValue = this.value;
            //this.value = value;
            //return oldValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.445 -0400", hash_original_method = "08E0671CAB8873A0A05165CE64371DB8", hash_generated_method = "98643C9C67A5E94E2D211E501F677BBA")
        @Override
        public boolean equals(Object o) {
            {
                Map.Entry other = (Map.Entry) o;
                boolean var7912CC5897005EB768B2514BECBB8DA1_2079762610 = ((key == null ? other.getKey() == null : key.equals(other.getKey()))
                        && (value == null ? other.getValue() == null : value.equals(other.getValue()))); //DSFIXME:  CODE0008: Nested ternary operator in expression
            } //End block
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_901471670 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_901471670;
            // ---------- Original Method ----------
            //if (o instanceof Map.Entry) {
                //Map.Entry other = (Map.Entry) o;
                //return (key == null ? other.getKey() == null : key.equals(other.getKey()))
                        //&& (value == null ? other.getValue() == null : value.equals(other.getValue()));
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.445 -0400", hash_original_method = "6416487D313DFCFD3052C01ADB883217", hash_generated_method = "7FC5E45653800D6D090582A1A4916A64")
        @Override
        public int hashCode() {
            int var4B5981580A705D92ADA4BF72B6E1E3C5_1535396690 = ((key == null ? 0 : key.hashCode())
                    ^ (value == null ? 0 : value.hashCode())); //DSFIXME:  CODE0008: Nested ternary operator in expression
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_542505683 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_542505683;
            // ---------- Original Method ----------
            //return (key == null ? 0 : key.hashCode())
                    //^ (value == null ? 0 : value.hashCode());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.446 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "B9F2DF0C82351ED41E0FC022991C2EF6")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1155996554 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1155996554 = key + "=" + value;
            varB4EAC82CA7396A68D541C85D26508E83_1155996554.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1155996554;
            // ---------- Original Method ----------
            //return key + "=" + value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.447 -0400", hash_original_method = "4A8921E3C940E88A3EF0004D6F064697", hash_generated_method = "952DEE878ADBBBE814DD2FAEBFDD8C32")
         Node<K, V> next() {
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_80211444 = null; //Variable for return #1
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_900351783 = null; //Variable for return #2
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1671277426 = null; //Variable for return #3
            {
                varB4EAC82CA7396A68D541C85D26508E83_80211444 = right.first();
            } //End block
            Node<K, V> node = this;
            Node<K, V> parent = node.parent;
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_900351783 = parent;
                } //End block
                node = parent;
                parent = node.parent;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1671277426 = null;
            Node<K, V> varA7E53CE21691AB073D9660D615818899_463778246; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_463778246 = varB4EAC82CA7396A68D541C85D26508E83_80211444;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_463778246 = varB4EAC82CA7396A68D541C85D26508E83_900351783;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_463778246 = varB4EAC82CA7396A68D541C85D26508E83_1671277426;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_463778246.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_463778246;
            // ---------- Original Method ----------
            //if (right != null) {
                //return right.first();
            //}
            //Node<K, V> node = this;
            //Node<K, V> parent = node.parent;
            //while (parent != null) {
                //if (parent.left == node) {
                    //return parent;
                //}
                //node = parent;
                //parent = node.parent;
            //}
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.448 -0400", hash_original_method = "A5795D04699EE4D7981584600E0900FB", hash_generated_method = "29AFE33EB2B82735C19A9EDE3CBF2ED8")
        public Node<K, V> prev() {
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_905186204 = null; //Variable for return #1
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1900678403 = null; //Variable for return #2
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_510900746 = null; //Variable for return #3
            {
                varB4EAC82CA7396A68D541C85D26508E83_905186204 = left.last();
            } //End block
            Node<K, V> node = this;
            Node<K, V> parent = node.parent;
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1900678403 = parent;
                } //End block
                node = parent;
                parent = node.parent;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_510900746 = null;
            Node<K, V> varA7E53CE21691AB073D9660D615818899_132169089; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_132169089 = varB4EAC82CA7396A68D541C85D26508E83_905186204;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_132169089 = varB4EAC82CA7396A68D541C85D26508E83_1900678403;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_132169089 = varB4EAC82CA7396A68D541C85D26508E83_510900746;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_132169089.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_132169089;
            // ---------- Original Method ----------
            //if (left != null) {
                //return left.last();
            //}
            //Node<K, V> node = this;
            //Node<K, V> parent = node.parent;
            //while (parent != null) {
                //if (parent.right == node) {
                    //return parent;
                //}
                //node = parent;
                //parent = node.parent;
            //}
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.448 -0400", hash_original_method = "4F7C0267C30B98E081694FF304478F8A", hash_generated_method = "27617F7499BF981C5D32897A75EF0017")
        public Node<K, V> first() {
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_241625522 = null; //Variable for return #1
            Node<K, V> node = this;
            Node<K, V> child = node.left;
            {
                node = child;
                child = node.left;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_241625522 = node;
            varB4EAC82CA7396A68D541C85D26508E83_241625522.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_241625522;
            // ---------- Original Method ----------
            //Node<K, V> node = this;
            //Node<K, V> child = node.left;
            //while (child != null) {
                //node = child;
                //child = node.left;
            //}
            //return node;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.449 -0400", hash_original_method = "E5BF79B4B513B5631F4BBC9604CA3FC9", hash_generated_method = "D5673EE2BB2E24F11FCD3D6A6A1DFAFC")
        public Node<K, V> last() {
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_584843675 = null; //Variable for return #1
            Node<K, V> node = this;
            Node<K, V> child = node.right;
            {
                node = child;
                child = node.right;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_584843675 = node;
            varB4EAC82CA7396A68D541C85D26508E83_584843675.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_584843675;
            // ---------- Original Method ----------
            //Node<K, V> node = this;
            //Node<K, V> child = node.right;
            //while (child != null) {
                //node = child;
                //child = node.right;
            //}
            //return node;
        }

        
    }


    
    abstract class MapIterator<T> implements Iterator<T> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.449 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "4E383A6783C389E295874CEC0140061D")

        protected Node<K, V> next;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.449 -0400", hash_original_field = "98BD1C45684CF587AC2347A92DD7BB51", hash_generated_field = "A9411E67538F8DD40B9344B2A6DD22CB")

        protected Node<K, V> last;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.449 -0400", hash_original_field = "587E194BCD330DA9D6CB9DB53EA8709A", hash_generated_field = "AB0DDF01BBCC99511DA5FB1867F9AF26")

        protected int expectedModCount = modCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.450 -0400", hash_original_method = "1934503C2038D80E73C2C0A3DE09B0C3", hash_generated_method = "8E0327A33AFF8D45EE12C60F2FAE7675")
          MapIterator(Node<K, V> next) {
            this.next = next;
            // ---------- Original Method ----------
            //this.next = next;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.450 -0400", hash_original_method = "5C1B7B0DA20667590A4D5C5559468A28", hash_generated_method = "2E100FB913BCC86561DE796A09986F54")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_553739796 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_553739796;
            // ---------- Original Method ----------
            //return next != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.451 -0400", hash_original_method = "85C80BB4AD318538DB8131E722149B15", hash_generated_method = "263CB490DDE085DFBC0684F21EFD6C13")
        protected Node<K, V> stepForward() {
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1653080615 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            } //End block
            last = next;
            next = next.next();
            varB4EAC82CA7396A68D541C85D26508E83_1653080615 = last;
            varB4EAC82CA7396A68D541C85D26508E83_1653080615.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1653080615;
            // ---------- Original Method ----------
            //if (next == null) {
                //throw new NoSuchElementException();
            //}
            //if (modCount != expectedModCount) {
                //throw new ConcurrentModificationException();
            //}
            //last = next;
            //next = next.next();
            //return last;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.452 -0400", hash_original_method = "A54C5D61E9DBD724A09A36F78C304124", hash_generated_method = "E4D20CBCFA95EB12D3E2FA860ADB49F0")
        protected Node<K, V> stepBackward() {
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1825197815 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            } //End block
            last = next;
            next = next.prev();
            varB4EAC82CA7396A68D541C85D26508E83_1825197815 = last;
            varB4EAC82CA7396A68D541C85D26508E83_1825197815.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1825197815;
            // ---------- Original Method ----------
            //if (next == null) {
                //throw new NoSuchElementException();
            //}
            //if (modCount != expectedModCount) {
                //throw new ConcurrentModificationException();
            //}
            //last = next;
            //next = next.prev();
            //return last;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.453 -0400", hash_original_method = "36CB2F7F3A40368DEE67850156136E6A", hash_generated_method = "68E79A243AD9DF221A3356BB1D7AE83F")
        public void remove() {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            } //End block
            removeInternal(last);
            expectedModCount = modCount;
            last = null;
            // ---------- Original Method ----------
            //if (last == null) {
                //throw new IllegalStateException();
            //}
            //removeInternal(last);
            //expectedModCount = modCount;
            //last = null;
        }

        
    }


    
    class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.454 -0400", hash_original_method = "AA90B2AD56C6E037D76F6D8ACC9327A5", hash_generated_method = "AA90B2AD56C6E037D76F6D8ACC9327A5")
        public EntrySet ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.455 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "D67A64726CBDBF1B031B29B2E127459C")
        @Override
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1966839933 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1966839933;
            // ---------- Original Method ----------
            //return size;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.456 -0400", hash_original_method = "B4D4FA13F54A295418FF58C47A14DDE9", hash_generated_method = "6FC75865B9B82BB55B678EDD92D48DFC")
        @Override
        public Iterator<Entry<K, V>> iterator() {
            Iterator<Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_852869071 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_852869071 = new MapIterator<Entry<K, V>>(root == null ? null : root.first()) {
                public Entry<K, V> next() {
                    return stepForward();
                }
            };
            varB4EAC82CA7396A68D541C85D26508E83_852869071.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_852869071;
            // ---------- Original Method ----------
            //return new MapIterator<Entry<K, V>>(root == null ? null : root.first()) {
                //public Entry<K, V> next() {
                    //return stepForward();
                //}
            //};
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.456 -0400", hash_original_method = "AAE5A29808B951CC80BD03F648B6A63A", hash_generated_method = "55AE0CF7AD512973EE3F2D6B8388A5EF")
        @Override
        public boolean contains(Object o) {
            boolean var12117A785F30278636E2FCE711DC72F4_495790035 = (o instanceof Entry && findByEntry((Entry<?, ?>) o) != null);
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1906901293 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1906901293;
            // ---------- Original Method ----------
            //return o instanceof Entry && findByEntry((Entry<?, ?>) o) != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.456 -0400", hash_original_method = "50402191313F22EA9CF206F14CC9A5A4", hash_generated_method = "A02723D445886BF1BD93483058F8C2D1")
        @Override
        public boolean remove(Object o) {
            Node<K, V> node = findByEntry((Entry<?, ?>) o);
            removeInternal(node);
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_78212184 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_78212184;
            // ---------- Original Method ----------
            //if (!(o instanceof Entry)) {
                //return false;
            //}
            //Node<K, V> node = findByEntry((Entry<?, ?>) o);
            //if (node == null) {
                //return false;
            //}
            //removeInternal(node);
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.457 -0400", hash_original_method = "1CC2A082C181027407DFF573950B6D85", hash_generated_method = "E132377B1C3D8FD49066BD79A34C72A8")
        @Override
        public void clear() {
            TreeMap.this.clear();
            // ---------- Original Method ----------
            //TreeMap.this.clear();
        }

        
    }


    
    class KeySet extends AbstractSet<K> implements NavigableSet<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.457 -0400", hash_original_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF", hash_generated_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF")
        public KeySet ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.457 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "0639F493158D20EB66B2F32D4DA73861")
        @Override
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_59477517 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_59477517;
            // ---------- Original Method ----------
            //return size;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.458 -0400", hash_original_method = "7A518595D7BAAD9E696AF11FE92FFDBE", hash_generated_method = "3C7A58BCB34C52E702BAE47E56BAE647")
        @Override
        public Iterator<K> iterator() {
            Iterator<K> varB4EAC82CA7396A68D541C85D26508E83_1458286589 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1458286589 = new MapIterator<K>(root == null ? null : root.first()) {
                public K next() {
                    return stepForward().key;
                }
            };
            varB4EAC82CA7396A68D541C85D26508E83_1458286589.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1458286589;
            // ---------- Original Method ----------
            //return new MapIterator<K>(root == null ? null : root.first()) {
                //public K next() {
                    //return stepForward().key;
                //}
            //};
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.459 -0400", hash_original_method = "C8D968F3C5FE84BB3D2A53544A3D4B19", hash_generated_method = "E8F8BBE4C1BB89DC7E2E6C1FD487C77E")
        public Iterator<K> descendingIterator() {
            Iterator<K> varB4EAC82CA7396A68D541C85D26508E83_88330207 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_88330207 = new MapIterator<K>(root == null ? null : root.last()) {
                public K next() {
                    return stepBackward().key;
                }
            };
            varB4EAC82CA7396A68D541C85D26508E83_88330207.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_88330207;
            // ---------- Original Method ----------
            //return new MapIterator<K>(root == null ? null : root.last()) {
                //public K next() {
                    //return stepBackward().key;
                //}
            //};
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.459 -0400", hash_original_method = "55474555B71DFC8666AC2B6E4F0261A5", hash_generated_method = "6A639F82442C4542AEB48E2A68D3E8B4")
        @Override
        public boolean contains(Object o) {
            boolean var997BAB39B2F072D5CD66A271F3B6E196_1740955417 = (containsKey(o));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1429988868 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1429988868;
            // ---------- Original Method ----------
            //return containsKey(o);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.460 -0400", hash_original_method = "174345B10BAB0003712B28F94B9BEA53", hash_generated_method = "A3FC75C7A1C13B54BB17337CFD0C3779")
        @Override
        public boolean remove(Object key) {
            boolean varE16D747D3226990FB8F8723539274182_45504060 = (removeInternalByKey(key) != null);
            addTaint(key.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2040285984 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2040285984;
            // ---------- Original Method ----------
            //return removeInternalByKey(key) != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.461 -0400", hash_original_method = "1CC2A082C181027407DFF573950B6D85", hash_generated_method = "E132377B1C3D8FD49066BD79A34C72A8")
        @Override
        public void clear() {
            TreeMap.this.clear();
            // ---------- Original Method ----------
            //TreeMap.this.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.462 -0400", hash_original_method = "E1A1305471DEE1FE749764F6E03BE3A0", hash_generated_method = "DEF30DA25BEFD21AB5768404002CC933")
        public Comparator<? super K> comparator() {
            Comparator<? super K> varB4EAC82CA7396A68D541C85D26508E83_188944143 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_188944143 = TreeMap.this.comparator();
            varB4EAC82CA7396A68D541C85D26508E83_188944143.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_188944143;
            // ---------- Original Method ----------
            //return TreeMap.this.comparator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.466 -0400", hash_original_method = "3067DEE01FBBBFD061436C7D4561F434", hash_generated_method = "8E04DC546743C7DEB13A43F1D8709120")
        public K first() {
            K varB4EAC82CA7396A68D541C85D26508E83_1250969366 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1250969366 = firstKey();
            varB4EAC82CA7396A68D541C85D26508E83_1250969366.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1250969366;
            // ---------- Original Method ----------
            //return firstKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.468 -0400", hash_original_method = "39C87F788E647BCD3FB86FFF34D7EF10", hash_generated_method = "36DF7FF105377BED428F8C37F2F5EF4B")
        public K last() {
            K varB4EAC82CA7396A68D541C85D26508E83_851967290 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_851967290 = lastKey();
            varB4EAC82CA7396A68D541C85D26508E83_851967290.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_851967290;
            // ---------- Original Method ----------
            //return lastKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.469 -0400", hash_original_method = "5CFE05BF706A06BBB501067306F1B9ED", hash_generated_method = "C63A981002DA0D98EFFDFCD40D9ED8B8")
        public K lower(K key) {
            K varB4EAC82CA7396A68D541C85D26508E83_1676803261 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1676803261 = lowerKey(key);
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1676803261.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1676803261;
            // ---------- Original Method ----------
            //return lowerKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.469 -0400", hash_original_method = "10BABB7BB2E837824A13AAE89EE7EC6F", hash_generated_method = "9BD4AA1602BAE927F55D5A8255155F8C")
        public K floor(K key) {
            K varB4EAC82CA7396A68D541C85D26508E83_1882250174 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1882250174 = floorKey(key);
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1882250174.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1882250174;
            // ---------- Original Method ----------
            //return floorKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.470 -0400", hash_original_method = "2AD4706A6D818B709A1E2CA64B48B4B9", hash_generated_method = "CBD211AFF25A0A26BC9BF4CB90661AC8")
        public K ceiling(K key) {
            K varB4EAC82CA7396A68D541C85D26508E83_1868174 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1868174 = ceilingKey(key);
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1868174.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1868174;
            // ---------- Original Method ----------
            //return ceilingKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.471 -0400", hash_original_method = "8CC63649234BFC57DB10A2387AE34DD6", hash_generated_method = "1C19C5504C27E75DF41A7392F9B963D3")
        public K higher(K key) {
            K varB4EAC82CA7396A68D541C85D26508E83_1615924278 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1615924278 = higherKey(key);
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1615924278.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1615924278;
            // ---------- Original Method ----------
            //return higherKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.472 -0400", hash_original_method = "0E3C9584B722234668005FBA598A1EC0", hash_generated_method = "551479170100723051E06CDDF87331F7")
        public K pollFirst() {
            K varB4EAC82CA7396A68D541C85D26508E83_2026012491 = null; //Variable for return #1
            Entry<K, V> entry = internalPollFirstEntry();
            varB4EAC82CA7396A68D541C85D26508E83_2026012491 = entry != null ? entry.getKey() : null;
            varB4EAC82CA7396A68D541C85D26508E83_2026012491.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2026012491;
            // ---------- Original Method ----------
            //Entry<K, V> entry = internalPollFirstEntry();
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.472 -0400", hash_original_method = "ABD0A1CFCFA4D3D1F242F2375F97811C", hash_generated_method = "9ABDE5F16702346415A25CAED5AFEE68")
        public K pollLast() {
            K varB4EAC82CA7396A68D541C85D26508E83_758294967 = null; //Variable for return #1
            Entry<K, V> entry = internalPollLastEntry();
            varB4EAC82CA7396A68D541C85D26508E83_758294967 = entry != null ? entry.getKey() : null;
            varB4EAC82CA7396A68D541C85D26508E83_758294967.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_758294967;
            // ---------- Original Method ----------
            //Entry<K, V> entry = internalPollLastEntry();
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.473 -0400", hash_original_method = "21828DA90728B75367EF3BEE7D62C832", hash_generated_method = "01307A0F306CCA9F3D0F8E8F5C2D21A4")
        public NavigableSet<K> subSet(K from, boolean fromInclusive, K to, boolean toInclusive) {
            NavigableSet<K> varB4EAC82CA7396A68D541C85D26508E83_1825229841 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1825229841 = TreeMap.this.subMap(from, fromInclusive, to, toInclusive).navigableKeySet();
            addTaint(from.getTaint());
            addTaint(fromInclusive);
            addTaint(to.getTaint());
            addTaint(toInclusive);
            varB4EAC82CA7396A68D541C85D26508E83_1825229841.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1825229841;
            // ---------- Original Method ----------
            //return TreeMap.this.subMap(from, fromInclusive, to, toInclusive).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.474 -0400", hash_original_method = "B37C6130D4B0113815E317EEB111D1E9", hash_generated_method = "8EA944EDFAB1474F1C0A4BEA674F9B39")
        public SortedSet<K> subSet(K fromInclusive, K toExclusive) {
            SortedSet<K> varB4EAC82CA7396A68D541C85D26508E83_62935440 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_62935440 = TreeMap.this.subMap(fromInclusive, true, toExclusive, false).navigableKeySet();
            addTaint(fromInclusive.getTaint());
            addTaint(toExclusive.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_62935440.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_62935440;
            // ---------- Original Method ----------
            //return TreeMap.this.subMap(fromInclusive, true, toExclusive, false).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.475 -0400", hash_original_method = "15C518A93EE21ED6E81237BD492369B4", hash_generated_method = "28F3E049D8D86E09D8976FC6C4428329")
        public NavigableSet<K> headSet(K to, boolean inclusive) {
            NavigableSet<K> varB4EAC82CA7396A68D541C85D26508E83_878719209 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_878719209 = TreeMap.this.headMap(to, inclusive).navigableKeySet();
            addTaint(to.getTaint());
            addTaint(inclusive);
            varB4EAC82CA7396A68D541C85D26508E83_878719209.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_878719209;
            // ---------- Original Method ----------
            //return TreeMap.this.headMap(to, inclusive).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.476 -0400", hash_original_method = "1E1BD4D122D1F75D80BDC2474EF32137", hash_generated_method = "477990D201C238A0524CA4550ED4563E")
        public SortedSet<K> headSet(K toExclusive) {
            SortedSet<K> varB4EAC82CA7396A68D541C85D26508E83_1426691348 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1426691348 = TreeMap.this.headMap(toExclusive, false).navigableKeySet();
            addTaint(toExclusive.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1426691348.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1426691348;
            // ---------- Original Method ----------
            //return TreeMap.this.headMap(toExclusive, false).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.476 -0400", hash_original_method = "3007AE414049BD587DD344AEC05F7630", hash_generated_method = "099472943F4ED3FD3116E66E6A0BCD86")
        public NavigableSet<K> tailSet(K from, boolean inclusive) {
            NavigableSet<K> varB4EAC82CA7396A68D541C85D26508E83_686409208 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_686409208 = TreeMap.this.tailMap(from, inclusive).navigableKeySet();
            addTaint(from.getTaint());
            addTaint(inclusive);
            varB4EAC82CA7396A68D541C85D26508E83_686409208.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_686409208;
            // ---------- Original Method ----------
            //return TreeMap.this.tailMap(from, inclusive).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.477 -0400", hash_original_method = "4DA58A152F26E7271643C0314BDDDB69", hash_generated_method = "ED0EFC86A6378AB8D0D63985C0B8222F")
        public SortedSet<K> tailSet(K fromInclusive) {
            SortedSet<K> varB4EAC82CA7396A68D541C85D26508E83_1219137407 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1219137407 = TreeMap.this.tailMap(fromInclusive, true).navigableKeySet();
            addTaint(fromInclusive.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1219137407.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1219137407;
            // ---------- Original Method ----------
            //return TreeMap.this.tailMap(fromInclusive, true).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.478 -0400", hash_original_method = "1704B63D396CC7A2877008D7CE821A20", hash_generated_method = "E15E984D816E8D663FAB01EB36C20AEA")
        public NavigableSet<K> descendingSet() {
            NavigableSet<K> varB4EAC82CA7396A68D541C85D26508E83_1930012657 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1930012657 = new BoundedMap(false, null, NO_BOUND, null, NO_BOUND).navigableKeySet();
            varB4EAC82CA7396A68D541C85D26508E83_1930012657.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1930012657;
            // ---------- Original Method ----------
            //return new BoundedMap(false, null, NO_BOUND, null, NO_BOUND).navigableKeySet();
        }

        
    }


    
    enum Bound {
        INCLUSIVE {
            @Override public String leftCap(Object from) {
                return "[" + from;
            }
            @Override public String rightCap(Object to) {
                return to + "]";
            }
        },
        EXCLUSIVE {
            @Override public String leftCap(Object from) {
                return "(" + from;
            }
            @Override public String rightCap(Object to) {
                return to + ")";
            }
        },
        NO_BOUND {
            @Override public String leftCap(Object from) {
                return ".";
            }
            @Override public String rightCap(Object to) {
                return ".";
            }
        };
        public abstract String leftCap(Object from);
        public abstract String rightCap(Object to);
    }

    
    final class BoundedMap extends AbstractMap<K, V> implements NavigableMap<K, V>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.478 -0400", hash_original_field = "9C9AB624360885FCF93B7643C93B6748", hash_generated_field = "BC70714ECDFF7490EBA777F7B93EF439")

        private transient boolean ascending;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.478 -0400", hash_original_field = "D98A07F84921B24EE30F86FD8CD85C3C", hash_generated_field = "EEAE90D76D5F301C983CBE52CC99E066")

        private transient K from;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.478 -0400", hash_original_field = "8632C30284D52AAEE2237CDB621740BD", hash_generated_field = "8ED035FAE673A429CD23C9E2219BCCAB")

        private transient Bound fromBound;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.478 -0400", hash_original_field = "01B6E20344B68835C5ED1DDEDF20D531", hash_generated_field = "61687A1A941C5D04AF6012AAB46409E8")

        private transient K to;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.478 -0400", hash_original_field = "7CA17358064D231F30EBE9DEA6953FC3", hash_generated_field = "AA1B7E444C65D0CB4426137E2FCF44C2")

        private transient Bound toBound;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.478 -0400", hash_original_field = "D4E06C98DBA5A687CB6C836BF538EC81", hash_generated_field = "71A92C43EAA002A1D21DF22BACB230F5")

        private transient BoundedEntrySet entrySet;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.478 -0400", hash_original_field = "3E8ABCE844B6A8A95397486A3899B536", hash_generated_field = "8C5699591CBD5CFF428C3B6D5369D846")

        private transient BoundedKeySet keySet;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.479 -0400", hash_original_method = "EAF770A918D33B7B0B98CAAC01791FDE", hash_generated_method = "89487AB728DEC3967288AB6F94C64A77")
          BoundedMap(boolean ascending, K from, Bound fromBound, K to, Bound toBound) {
            {
                {
                    boolean varDF5DEF900BBEA61318C4B860BE963A0C_591422037 = (comparator.compare(from, to) > 0);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(from + " > " + to);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                comparator.compare(from, from);
            } //End block
            {
                comparator.compare(to, to);
            } //End block
            this.ascending = ascending;
            this.from = from;
            this.fromBound = fromBound;
            this.to = to;
            this.toBound = toBound;
            // ---------- Original Method ----------
            //if (fromBound != NO_BOUND && toBound != NO_BOUND) {
                //if (comparator.compare(from, to) > 0) {
                    //throw new IllegalArgumentException(from + " > " + to);
                //}
            //} else if (fromBound != NO_BOUND) {
                //comparator.compare(from, from);
            //} else if (toBound != NO_BOUND) {
                //comparator.compare(to, to);
            //}
            //this.ascending = ascending;
            //this.from = from;
            //this.fromBound = fromBound;
            //this.to = to;
            //this.toBound = toBound;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.479 -0400", hash_original_method = "0165FF9BE82C19127CA9F7A8EFBCC5F6", hash_generated_method = "2F4C0F7A7295D03D30D9583DD27536DB")
        @Override
        public int size() {
            int varFAAE4FEB39919E901926F6E4652B275E_187580125 = (count(entrySet().iterator()));
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2112250902 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2112250902;
            // ---------- Original Method ----------
            //return count(entrySet().iterator());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.480 -0400", hash_original_method = "25ACC65054E604EE8ADED763702CFAA7", hash_generated_method = "2F3969FE73537C422434E6253C3081ED")
        @Override
        public boolean isEmpty() {
            boolean var19B0E21581FF256C0BE5D0F9299E6746_572858348 = (endpoint(true) == null);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1699973346 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1699973346;
            // ---------- Original Method ----------
            //return endpoint(true) == null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.480 -0400", hash_original_method = "00AB887CF1625BBE035D7C27E115F8F5", hash_generated_method = "9DEE2A6AD142EEF01FD3459C2A5C1687")
        @Override
        public V get(Object key) {
            V varB4EAC82CA7396A68D541C85D26508E83_908459689 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_908459689 = isInBounds(key) ? TreeMap.this.get(key) : null;
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_908459689.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_908459689;
            // ---------- Original Method ----------
            //return isInBounds(key) ? TreeMap.this.get(key) : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.481 -0400", hash_original_method = "97933E3E15C41B402232AC9CC0472CF2", hash_generated_method = "B7D6C67BC4415F4231869D6D0FE31C32")
        @Override
        public boolean containsKey(Object key) {
            boolean varA3E267D2E614E41BB78FB5916F69E5F6_374396575 = (isInBounds(key) && TreeMap.this.containsKey(key));
            addTaint(key.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_144486082 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_144486082;
            // ---------- Original Method ----------
            //return isInBounds(key) && TreeMap.this.containsKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.482 -0400", hash_original_method = "AA5BBA9E7D3BEE615F1E652A3C2B8A57", hash_generated_method = "60B2373C64C70631E32B036BC0B1C7A7")
        @Override
        public V put(K key, V value) {
            V varB4EAC82CA7396A68D541C85D26508E83_704660796 = null; //Variable for return #1
            {
                boolean varAD602F34696280F613EFFCC6CD1936C9_585086890 = (!isInBounds(key));
                {
                    if (DroidSafeAndroidRuntime.control) throw outOfBounds(key, fromBound, toBound);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_704660796 = putInternal(key, value);
            addTaint(key.getTaint());
            addTaint(value.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_704660796.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_704660796;
            // ---------- Original Method ----------
            //if (!isInBounds(key)) {
                //throw outOfBounds(key, fromBound, toBound);
            //}
            //return putInternal(key, value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.483 -0400", hash_original_method = "FD860E76286147E5825948B59334B12A", hash_generated_method = "520DF26F59B19C462636D0DA4B24EDB8")
        @Override
        public V remove(Object key) {
            V varB4EAC82CA7396A68D541C85D26508E83_1611503211 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1611503211 = isInBounds(key) ? TreeMap.this.remove(key) : null;
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1611503211.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1611503211;
            // ---------- Original Method ----------
            //return isInBounds(key) ? TreeMap.this.remove(key) : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.484 -0400", hash_original_method = "CBDDB4BBE438A9DB233DEA58A1C969FA", hash_generated_method = "E014D13A0C1AF77BFA267482471BBF28")
        @SuppressWarnings("unchecked")
        private boolean isInBounds(Object key) {
            boolean varA5F72E2E91F3E285BA97AAF5A99A4DA1_241555450 = (isInBounds((K) key, fromBound, toBound));
            addTaint(key.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_700212336 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_700212336;
            // ---------- Original Method ----------
            //return isInBounds((K) key, fromBound, toBound);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.485 -0400", hash_original_method = "692642A6AE210FFE582C89EC91302D79", hash_generated_method = "B4112FA283A8C6E03DE2380D74C2E1E7")
        private boolean isInBounds(K key, Bound fromBound, Bound toBound) {
            {
                {
                    boolean var9F6E7E65C5DF7B537032AF04E3982098_1914027402 = (comparator.compare(key, from) < 0);
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean varFBA4E02ED99BA8F4A60A17B22AA50698_1490218153 = (comparator.compare(key, from) <= 0);
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var3BF67E403FFC608A69421DC18FA2C214_1564247126 = (comparator.compare(key, to) > 0);
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean varEA1D9A2226B6707B7C8DE8BD2619E59B_621585943 = (comparator.compare(key, to) >= 0);
                } //End collapsed parenthetic
            } //End block
            addTaint(key.getTaint());
            addTaint(fromBound.getTaint());
            addTaint(toBound.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_559515379 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_559515379;
            // ---------- Original Method ----------
            //if (fromBound == INCLUSIVE) {
                //if (comparator.compare(key, from) < 0) {
                    //return false; 
                //}
            //} else if (fromBound == EXCLUSIVE) {
                //if (comparator.compare(key, from) <= 0) {
                    //return false; 
                //}
            //}
            //if (toBound == INCLUSIVE) {
                //if (comparator.compare(key, to) > 0) {
                    //return false; 
                //}
            //} else if (toBound == EXCLUSIVE) {
                //if (comparator.compare(key, to) >= 0) {
                    //return false; 
                //}
            //}
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.488 -0400", hash_original_method = "CAAC4C1A33B13586569CF07F541A55C7", hash_generated_method = "1F5577E44F4C94C0057ECA3C24EB3EBF")
        private Node<K, V> bound(Node<K, V> node, Bound fromBound, Bound toBound) {
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1372403925 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1372403925 = node != null && isInBounds(node.getKey(), fromBound, toBound) ? node : null;
            addTaint(node.getTaint());
            addTaint(fromBound.getTaint());
            addTaint(toBound.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1372403925.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1372403925;
            // ---------- Original Method ----------
            //return node != null && isInBounds(node.getKey(), fromBound, toBound) ? node : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.489 -0400", hash_original_method = "692355E3656C196457301F91A19D5157", hash_generated_method = "A3D960F4DC2CB2FAB3F859E8212D4CF4")
        public Entry<K, V> firstEntry() {
            Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_130386775 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_130386775 = immutableCopy(endpoint(true));
            varB4EAC82CA7396A68D541C85D26508E83_130386775.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_130386775;
            // ---------- Original Method ----------
            //return immutableCopy(endpoint(true));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.490 -0400", hash_original_method = "3800FF04B85DB50D775ADF76A89AF0FD", hash_generated_method = "78DB9B62ECB94C15805A319708323B7F")
        public Entry<K, V> pollFirstEntry() {
            Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1254082734 = null; //Variable for return #1
            Node<K, V> result = endpoint(true);
            {
                removeInternal(result);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1254082734 = immutableCopy(result);
            varB4EAC82CA7396A68D541C85D26508E83_1254082734.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1254082734;
            // ---------- Original Method ----------
            //Node<K, V> result = endpoint(true);
            //if (result != null) {
                //removeInternal(result);
            //}
            //return immutableCopy(result);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.491 -0400", hash_original_method = "1DE5152AF86A2FB092CD0802BF299C85", hash_generated_method = "F0BA593F982AF752A4144BF27D206728")
        public K firstKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_219554398 = null; //Variable for return #1
            Entry<K, V> entry = endpoint(true);
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_219554398 = entry.getKey();
            varB4EAC82CA7396A68D541C85D26508E83_219554398.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_219554398;
            // ---------- Original Method ----------
            //Entry<K, V> entry = endpoint(true);
            //if (entry == null) {
                //throw new NoSuchElementException();
            //}
            //return entry.getKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.492 -0400", hash_original_method = "3349B358C55B472B88F39549996E074C", hash_generated_method = "7F2553F82EDDECE85A39F73BBB0C37CA")
        public Entry<K, V> lastEntry() {
            Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_2044584245 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2044584245 = immutableCopy(endpoint(false));
            varB4EAC82CA7396A68D541C85D26508E83_2044584245.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2044584245;
            // ---------- Original Method ----------
            //return immutableCopy(endpoint(false));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.493 -0400", hash_original_method = "4E391E55891B2D72162CA8FBBFDB8088", hash_generated_method = "FB66DA64894B67ADA06EA19D99DA6BCC")
        public Entry<K, V> pollLastEntry() {
            Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1925790521 = null; //Variable for return #1
            Node<K, V> result = endpoint(false);
            {
                removeInternal(result);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1925790521 = immutableCopy(result);
            varB4EAC82CA7396A68D541C85D26508E83_1925790521.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1925790521;
            // ---------- Original Method ----------
            //Node<K, V> result = endpoint(false);
            //if (result != null) {
                //removeInternal(result);
            //}
            //return immutableCopy(result);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.493 -0400", hash_original_method = "394B9DCC52DC405017E9FB6F95D12436", hash_generated_method = "593518F8B77D3BAD28640ECAFF4F1917")
        public K lastKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_964309502 = null; //Variable for return #1
            Entry<K, V> entry = endpoint(false);
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_964309502 = entry.getKey();
            varB4EAC82CA7396A68D541C85D26508E83_964309502.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_964309502;
            // ---------- Original Method ----------
            //Entry<K, V> entry = endpoint(false);
            //if (entry == null) {
                //throw new NoSuchElementException();
            //}
            //return entry.getKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.494 -0400", hash_original_method = "83D48F5C9D4926E1668CDBC652A8BB3D", hash_generated_method = "A96DE559879A9A6895FF16F6B0E52A81")
        private Node<K, V> endpoint(boolean first) {
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1548605991 = null; //Variable for return #1
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_163295816 = null; //Variable for return #2
            Node<K, V> node;
            {
                //Begin case NO_BOUND 
                node = root == null ? null : root.first();
                //End case NO_BOUND 
                //Begin case INCLUSIVE 
                node = find(from, CEILING);
                //End case INCLUSIVE 
                //Begin case EXCLUSIVE 
                node = find(from, HIGHER);
                //End case EXCLUSIVE 
                //Begin case default 
                if (DroidSafeAndroidRuntime.control) throw new AssertionError();
                //End case default 
                varB4EAC82CA7396A68D541C85D26508E83_1548605991 = bound(node, NO_BOUND, toBound);
            } //End block
            {
                //Begin case NO_BOUND 
                node = root == null ? null : root.last();
                //End case NO_BOUND 
                //Begin case INCLUSIVE 
                node = find(to, FLOOR);
                //End case INCLUSIVE 
                //Begin case EXCLUSIVE 
                node = find(to, LOWER);
                //End case EXCLUSIVE 
                //Begin case default 
                if (DroidSafeAndroidRuntime.control) throw new AssertionError();
                //End case default 
                varB4EAC82CA7396A68D541C85D26508E83_163295816 = bound(node, fromBound, NO_BOUND);
            } //End block
            addTaint(first);
            Node<K, V> varA7E53CE21691AB073D9660D615818899_869527804; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_869527804 = varB4EAC82CA7396A68D541C85D26508E83_1548605991;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_869527804 = varB4EAC82CA7396A68D541C85D26508E83_163295816;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_869527804.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_869527804;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.495 -0400", hash_original_method = "4CDC04225A960E79B8311D7465BD3125", hash_generated_method = "CE262D2ADD031F8ECA03A3308DDDE53B")
        private Entry<K, V> findBounded(K key, Relation relation) {
            Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_991257453 = null; //Variable for return #1
            relation = relation.forOrder(ascending);
            Bound fromBoundForCheck = fromBound;
            Bound toBoundForCheck = toBound;
            {
                int comparison = comparator.compare(to, key);
                {
                    key = to;
                    {
                        relation = LOWER;
                    } //End block
                    {
                        relation = FLOOR;
                    } //End block
                } //End block
                toBoundForCheck = NO_BOUND;
            } //End block
            {
                int comparison = comparator.compare(from, key);
                {
                    key = from;
                    {
                        relation = HIGHER;
                    } //End block
                    {
                        relation = CEILING;
                    } //End block
                } //End block
                fromBoundForCheck = NO_BOUND;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_991257453 = bound(find(key, relation), fromBoundForCheck, toBoundForCheck);
            addTaint(key.getTaint());
            addTaint(relation.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_991257453.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_991257453;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.496 -0400", hash_original_method = "BD9CF59DC295A4AE3510934F298E27E6", hash_generated_method = "6E40CA8E633C9B4865D5A57AA661006F")
        public Entry<K, V> lowerEntry(K key) {
            Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_523909820 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_523909820 = immutableCopy(findBounded(key, LOWER));
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_523909820.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_523909820;
            // ---------- Original Method ----------
            //return immutableCopy(findBounded(key, LOWER));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.496 -0400", hash_original_method = "EBA87E3AFD9E90051DFFEBD0117773EA", hash_generated_method = "72ECAD418AA420BAA9337245EA709DAE")
        public K lowerKey(K key) {
            K varB4EAC82CA7396A68D541C85D26508E83_1554404615 = null; //Variable for return #1
            Entry<K, V> entry = findBounded(key, LOWER);
            varB4EAC82CA7396A68D541C85D26508E83_1554404615 = entry != null ? entry.getKey() : null;
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1554404615.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1554404615;
            // ---------- Original Method ----------
            //Entry<K, V> entry = findBounded(key, LOWER);
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.497 -0400", hash_original_method = "581C54D570AF4193E6400C576ED95C35", hash_generated_method = "BA3EF162B667CD26B8E46EDE958BC23A")
        public Entry<K, V> floorEntry(K key) {
            Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_478077704 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_478077704 = immutableCopy(findBounded(key, FLOOR));
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_478077704.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_478077704;
            // ---------- Original Method ----------
            //return immutableCopy(findBounded(key, FLOOR));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.498 -0400", hash_original_method = "E92237DAC033388A5150FD58D66D705D", hash_generated_method = "37EDC38260D5DD9051B9F970AB2AF1CE")
        public K floorKey(K key) {
            K varB4EAC82CA7396A68D541C85D26508E83_1791540805 = null; //Variable for return #1
            Entry<K, V> entry = findBounded(key, FLOOR);
            varB4EAC82CA7396A68D541C85D26508E83_1791540805 = entry != null ? entry.getKey() : null;
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1791540805.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1791540805;
            // ---------- Original Method ----------
            //Entry<K, V> entry = findBounded(key, FLOOR);
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.498 -0400", hash_original_method = "C11821BD096982DAE03E94867B2C92BE", hash_generated_method = "57922AC6793F7F66D86736861404A7FA")
        public Entry<K, V> ceilingEntry(K key) {
            Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1346220024 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1346220024 = immutableCopy(findBounded(key, CEILING));
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1346220024.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1346220024;
            // ---------- Original Method ----------
            //return immutableCopy(findBounded(key, CEILING));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.499 -0400", hash_original_method = "01AF63D6DC81CC48D8C6B0BE37F83B4D", hash_generated_method = "0D0795375D8EFFE0198704886D6FFC53")
        public K ceilingKey(K key) {
            K varB4EAC82CA7396A68D541C85D26508E83_1162810979 = null; //Variable for return #1
            Entry<K, V> entry = findBounded(key, CEILING);
            varB4EAC82CA7396A68D541C85D26508E83_1162810979 = entry != null ? entry.getKey() : null;
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1162810979.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1162810979;
            // ---------- Original Method ----------
            //Entry<K, V> entry = findBounded(key, CEILING);
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.500 -0400", hash_original_method = "4DE66AB7FA66EBE29F4E4509967D65D0", hash_generated_method = "6C8D7A6065EF105D7FD89A1F03274F5F")
        public Entry<K, V> higherEntry(K key) {
            Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_989071961 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_989071961 = immutableCopy(findBounded(key, HIGHER));
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_989071961.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_989071961;
            // ---------- Original Method ----------
            //return immutableCopy(findBounded(key, HIGHER));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.501 -0400", hash_original_method = "47A499322D06CDAFFEC1D4DA0A079F0A", hash_generated_method = "DF134404860E0D4A6935C3368450BFD0")
        public K higherKey(K key) {
            K varB4EAC82CA7396A68D541C85D26508E83_1476847396 = null; //Variable for return #1
            Entry<K, V> entry = findBounded(key, HIGHER);
            varB4EAC82CA7396A68D541C85D26508E83_1476847396 = entry != null ? entry.getKey() : null;
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1476847396.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1476847396;
            // ---------- Original Method ----------
            //Entry<K, V> entry = findBounded(key, HIGHER);
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.502 -0400", hash_original_method = "631801B6DE22632DEACA2B547DEBE43A", hash_generated_method = "7B24D3DEAD80AB6791BAD2584DFD06B8")
        public Comparator<? super K> comparator() {
            Comparator<? super K> varB4EAC82CA7396A68D541C85D26508E83_1480678856 = null; //Variable for return #1
            Comparator<? super K> varB4EAC82CA7396A68D541C85D26508E83_921199201 = null; //Variable for return #2
            {
                varB4EAC82CA7396A68D541C85D26508E83_1480678856 = TreeMap.this.comparator();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_921199201 = Collections.reverseOrder(comparator);
            } //End block
            Comparator<? super K> varA7E53CE21691AB073D9660D615818899_1375814523; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1375814523 = varB4EAC82CA7396A68D541C85D26508E83_1480678856;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1375814523 = varB4EAC82CA7396A68D541C85D26508E83_921199201;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1375814523.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1375814523;
            // ---------- Original Method ----------
            //if (ascending) {
            //return TreeMap.this.comparator();
          //} else {
            //return Collections.reverseOrder(comparator);
          //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.503 -0400", hash_original_method = "7F86A739037DCA8312EEE2819E1107F8", hash_generated_method = "E7EDB3C769CDE8369C76E69CA900A3E9")
        @Override
        public Set<Entry<K, V>> entrySet() {
            Set<Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_882615380 = null; //Variable for return #1
            BoundedEntrySet result = entrySet;
            varB4EAC82CA7396A68D541C85D26508E83_882615380 = result != null ? result : (entrySet = new BoundedEntrySet());
            varB4EAC82CA7396A68D541C85D26508E83_882615380.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_882615380;
            // ---------- Original Method ----------
            //BoundedEntrySet result = entrySet;
            //return result != null ? result : (entrySet = new BoundedEntrySet());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.504 -0400", hash_original_method = "8D1D053C1D8B0756868AB879DB7CB086", hash_generated_method = "2FE65B60AEF792FFA62FF46E9A5383F4")
        @Override
        public Set<K> keySet() {
            Set<K> varB4EAC82CA7396A68D541C85D26508E83_535215913 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_535215913 = navigableKeySet();
            varB4EAC82CA7396A68D541C85D26508E83_535215913.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_535215913;
            // ---------- Original Method ----------
            //return navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.505 -0400", hash_original_method = "58209BC6FD1C6420A0C3CE4B441A6EA8", hash_generated_method = "94A508FB0B95FAC4199760EB4A4877C6")
        public NavigableSet<K> navigableKeySet() {
            NavigableSet<K> varB4EAC82CA7396A68D541C85D26508E83_1191495392 = null; //Variable for return #1
            BoundedKeySet result = keySet;
            varB4EAC82CA7396A68D541C85D26508E83_1191495392 = result != null ? result : (keySet = new BoundedKeySet());
            varB4EAC82CA7396A68D541C85D26508E83_1191495392.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1191495392;
            // ---------- Original Method ----------
            //BoundedKeySet result = keySet;
            //return result != null ? result : (keySet = new BoundedKeySet());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.505 -0400", hash_original_method = "6D358EC631E9E279A9C759613AD4CBF5", hash_generated_method = "6D8CAEA93DC3805B44E625239E6AAEAB")
        public NavigableMap<K, V> descendingMap() {
            NavigableMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_1681539791 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1681539791 = new BoundedMap(!ascending, from, fromBound, to, toBound);
            varB4EAC82CA7396A68D541C85D26508E83_1681539791.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1681539791;
            // ---------- Original Method ----------
            //return new BoundedMap(!ascending, from, fromBound, to, toBound);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.506 -0400", hash_original_method = "E068C75BD35AA3BEC427F457C352E2B5", hash_generated_method = "B283CE1BC6BA173592C173214D3966FE")
        public NavigableSet<K> descendingKeySet() {
            NavigableSet<K> varB4EAC82CA7396A68D541C85D26508E83_2037164084 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2037164084 = new BoundedMap(!ascending, from, fromBound, to, toBound).navigableKeySet();
            varB4EAC82CA7396A68D541C85D26508E83_2037164084.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2037164084;
            // ---------- Original Method ----------
            //return new BoundedMap(!ascending, from, fromBound, to, toBound).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.506 -0400", hash_original_method = "3DC9A98D108EA5F857802D111DD4C7BC", hash_generated_method = "7AF75F9589F21587EDE04BC3515617C4")
        public NavigableMap<K, V> subMap(K from, boolean fromInclusive, K to, boolean toInclusive) {
            NavigableMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_702124398 = null; //Variable for return #1
            Bound fromBound;
            fromBound = INCLUSIVE;
            fromBound = EXCLUSIVE;
            Bound toBound;
            toBound = INCLUSIVE;
            toBound = EXCLUSIVE;
            varB4EAC82CA7396A68D541C85D26508E83_702124398 = subMap(from, fromBound, to, toBound);
            addTaint(from.getTaint());
            addTaint(fromInclusive);
            addTaint(to.getTaint());
            addTaint(toInclusive);
            varB4EAC82CA7396A68D541C85D26508E83_702124398.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_702124398;
            // ---------- Original Method ----------
            //Bound fromBound = fromInclusive ? INCLUSIVE : EXCLUSIVE;
            //Bound toBound = toInclusive ? INCLUSIVE : EXCLUSIVE;
            //return subMap(from, fromBound, to, toBound);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.507 -0400", hash_original_method = "85C9C855FCFD7C01DE62316D427AA356", hash_generated_method = "5CDDC8179D48A8CE1AE9E6CB1AF5D9B6")
        public NavigableMap<K, V> subMap(K fromInclusive, K toExclusive) {
            NavigableMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_1202745370 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1202745370 = subMap(fromInclusive, INCLUSIVE, toExclusive, EXCLUSIVE);
            addTaint(fromInclusive.getTaint());
            addTaint(toExclusive.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1202745370.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1202745370;
            // ---------- Original Method ----------
            //return subMap(fromInclusive, INCLUSIVE, toExclusive, EXCLUSIVE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.507 -0400", hash_original_method = "F0BAF6F2CF2FCD82E483E31B5C869204", hash_generated_method = "F0B937A34173AEF35821E0F64533CC25")
        public NavigableMap<K, V> headMap(K to, boolean inclusive) {
            NavigableMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_645691002 = null; //Variable for return #1
            Bound toBound;
            toBound = INCLUSIVE;
            toBound = EXCLUSIVE;
            varB4EAC82CA7396A68D541C85D26508E83_645691002 = subMap(null, NO_BOUND, to, toBound);
            addTaint(to.getTaint());
            addTaint(inclusive);
            varB4EAC82CA7396A68D541C85D26508E83_645691002.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_645691002;
            // ---------- Original Method ----------
            //Bound toBound = inclusive ? INCLUSIVE : EXCLUSIVE;
            //return subMap(null, NO_BOUND, to, toBound);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.508 -0400", hash_original_method = "ABFE13DC9073E46E049BB999D5306953", hash_generated_method = "1DC046FC79FF40E7D68A1928DA1A6B29")
        public NavigableMap<K, V> headMap(K toExclusive) {
            NavigableMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_1806454446 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1806454446 = subMap(null, NO_BOUND, toExclusive, EXCLUSIVE);
            addTaint(toExclusive.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1806454446.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1806454446;
            // ---------- Original Method ----------
            //return subMap(null, NO_BOUND, toExclusive, EXCLUSIVE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.509 -0400", hash_original_method = "26986665A8C827C93D404190F2752B4C", hash_generated_method = "E292CA8AAD2EE49721F650D15FFAEB00")
        public NavigableMap<K, V> tailMap(K from, boolean inclusive) {
            NavigableMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_1020101392 = null; //Variable for return #1
            Bound fromBound;
            fromBound = INCLUSIVE;
            fromBound = EXCLUSIVE;
            varB4EAC82CA7396A68D541C85D26508E83_1020101392 = subMap(from, fromBound, null, NO_BOUND);
            addTaint(from.getTaint());
            addTaint(inclusive);
            varB4EAC82CA7396A68D541C85D26508E83_1020101392.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1020101392;
            // ---------- Original Method ----------
            //Bound fromBound = inclusive ? INCLUSIVE : EXCLUSIVE;
            //return subMap(from, fromBound, null, NO_BOUND);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.510 -0400", hash_original_method = "CF387452C0473BBA846F53D5C56CE3B2", hash_generated_method = "7E37FA3F8E623F9A4E52B54EA8434AE4")
        public NavigableMap<K, V> tailMap(K fromInclusive) {
            NavigableMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_999703466 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_999703466 = subMap(fromInclusive, INCLUSIVE, null, NO_BOUND);
            addTaint(fromInclusive.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_999703466.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_999703466;
            // ---------- Original Method ----------
            //return subMap(fromInclusive, INCLUSIVE, null, NO_BOUND);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.511 -0400", hash_original_method = "0BE57F9811CA6209D3A6FF727B140802", hash_generated_method = "74D278D72F3B482896A8D9D62169FC92")
        private NavigableMap<K, V> subMap(K from, Bound fromBound, K to, Bound toBound) {
            NavigableMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_847604832 = null; //Variable for return #1
            {
                K fromTmp = from;
                Bound fromBoundTmp = fromBound;
                from = to;
                fromBound = toBound;
                to = fromTmp;
                toBound = fromBoundTmp;
            } //End block
            {
                from = this.from;
                fromBound = this.fromBound;
            } //End block
            {
                Bound fromBoundToCheck;
                fromBoundToCheck = INCLUSIVE;
                fromBoundToCheck = this.fromBound;
                {
                    boolean var1DAE628D732342D7BC54FD4D3278CE34_1676070267 = (!isInBounds(from, fromBoundToCheck, this.toBound));
                    {
                        if (DroidSafeAndroidRuntime.control) throw outOfBounds(to, fromBoundToCheck, this.toBound);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                to = this.to;
                toBound = this.toBound;
            } //End block
            {
                Bound toBoundToCheck;
                toBoundToCheck = INCLUSIVE;
                toBoundToCheck = this.toBound;
                {
                    boolean var5922B8A01789147118CB04C1CDD52F79_716715722 = (!isInBounds(to, this.fromBound, toBoundToCheck));
                    {
                        if (DroidSafeAndroidRuntime.control) throw outOfBounds(to, this.fromBound, toBoundToCheck);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_847604832 = new BoundedMap(ascending, from, fromBound, to, toBound);
            varB4EAC82CA7396A68D541C85D26508E83_847604832.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_847604832;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.514 -0400", hash_original_method = "65FB71F2A366D35F7884C2869AFAA6ED", hash_generated_method = "4B9B4C5CF688E1FA2E3603DF014D2D98")
        private IllegalArgumentException outOfBounds(Object value, Bound fromBound, Bound toBound) {
            IllegalArgumentException varB4EAC82CA7396A68D541C85D26508E83_579928883 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_579928883 = new IllegalArgumentException(value + " not in range "
                    + fromBound.leftCap(from) + ".." + toBound.rightCap(to));
            addTaint(value.getTaint());
            addTaint(fromBound.getTaint());
            addTaint(toBound.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_579928883.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_579928883;
            // ---------- Original Method ----------
            //return new IllegalArgumentException(value + " not in range "
                    //+ fromBound.leftCap(from) + ".." + toBound.rightCap(to));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.516 -0400", hash_original_method = "9F20C8CFE1A741092D9743A31C3F8586", hash_generated_method = "4262E58B0046318F15B77635BCF4DBEA")
         Object writeReplace() throws ObjectStreamException {
            Object varB4EAC82CA7396A68D541C85D26508E83_296271150 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_296271150 = ascending
                    ? new AscendingSubMap<K, V>(TreeMap.this, from, fromBound, to, toBound)
                    : new DescendingSubMap<K, V>(TreeMap.this, from, fromBound, to, toBound);
            varB4EAC82CA7396A68D541C85D26508E83_296271150.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_296271150;
            // ---------- Original Method ----------
            //return ascending
                    //? new AscendingSubMap<K, V>(TreeMap.this, from, fromBound, to, toBound)
                    //: new DescendingSubMap<K, V>(TreeMap.this, from, fromBound, to, toBound);
        }

        
        abstract class BoundedIterator<T> extends MapIterator<T> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.517 -0400", hash_original_method = "30CDAF663F351A84269F6FB0B072EFA9", hash_generated_method = "DCA6AE078FF061847F66F0A7A80CFEA2")
            protected  BoundedIterator(Node<K, V> next) {
                super(next);
                addTaint(next.getTaint());
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.518 -0400", hash_original_method = "E9206CF01CB691A7CC292AD03FA9736C", hash_generated_method = "0C69FDE320F28B56FA89332F0D02670F")
            @Override
            protected Node<K, V> stepForward() {
                Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_231161740 = null; //Variable for return #1
                Node<K, V> result = super.stepForward();
                {
                    boolean varB492F846C21C09F0364F2416324ABD06_1971453646 = (next != null && !isInBounds(next.key, NO_BOUND, toBound));
                    {
                        next = null;
                    } //End block
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_231161740 = result;
                varB4EAC82CA7396A68D541C85D26508E83_231161740.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_231161740;
                // ---------- Original Method ----------
                //Node<K, V> result = super.stepForward();
                //if (next != null && !isInBounds(next.key, NO_BOUND, toBound)) {
                    //next = null;
                //}
                //return result;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.519 -0400", hash_original_method = "E55F6A3E56D317586EA4F65D3F74D30B", hash_generated_method = "9A8BC38692A0D2F16BD19329E4067A6E")
            @Override
            protected Node<K, V> stepBackward() {
                Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1945388 = null; //Variable for return #1
                Node<K, V> result = super.stepBackward();
                {
                    boolean varA14FF8A4CC2199BAF982AB4CC94D03CC_1591320516 = (next != null && !isInBounds(next.key, fromBound, NO_BOUND));
                    {
                        next = null;
                    } //End block
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_1945388 = result;
                varB4EAC82CA7396A68D541C85D26508E83_1945388.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1945388;
                // ---------- Original Method ----------
                //Node<K, V> result = super.stepBackward();
                //if (next != null && !isInBounds(next.key, fromBound, NO_BOUND)) {
                    //next = null;
                //}
                //return result;
            }

            
        }


        
        final class BoundedEntrySet extends AbstractSet<Entry<K, V>> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.520 -0400", hash_original_method = "6A727A04787362E0DA8C9D4EFA8450E8", hash_generated_method = "6A727A04787362E0DA8C9D4EFA8450E8")
            public BoundedEntrySet ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.520 -0400", hash_original_method = "29BBB3BE9EA7B6D6C0B83C28F05082A4", hash_generated_method = "227BB399F6B25FE5A57062520E25961F")
            @Override
            public int size() {
                int var69D9F234E7E76618743D3D698A58599B_1799950833 = (BoundedMap.this.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2059548862 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2059548862;
                // ---------- Original Method ----------
                //return BoundedMap.this.size();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.520 -0400", hash_original_method = "AEA447F4A69E282FABF93736832EBAA3", hash_generated_method = "CCFB435205CDE90AFA655387F5E594C9")
            @Override
            public boolean isEmpty() {
                boolean varF1E2DF8AD3E4C9C508E293B19251E66A_1735240871 = (BoundedMap.this.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_859668547 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_859668547;
                // ---------- Original Method ----------
                //return BoundedMap.this.isEmpty();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.521 -0400", hash_original_method = "0E267F64AB80178C28467CD978AC79C8", hash_generated_method = "257096B209EA42D754BC3E5E0DA58975")
            @Override
            public Iterator<Entry<K, V>> iterator() {
                Iterator<Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_1242854174 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1242854174 = new BoundedIterator<Entry<K, V>>(endpoint(true)) {
                    public Entry<K, V> next() {
                        return ascending ? stepForward() : stepBackward();
                    }
                };
                varB4EAC82CA7396A68D541C85D26508E83_1242854174.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1242854174;
                // ---------- Original Method ----------
                //return new BoundedIterator<Entry<K, V>>(endpoint(true)) {
                    //public Entry<K, V> next() {
                        //return ascending ? stepForward() : stepBackward();
                    //}
                //};
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.521 -0400", hash_original_method = "954A21A7B25CC1709817AC62B8C6864E", hash_generated_method = "FD5A17D2D4151BC01FE012D695F6B55D")
            @Override
            public boolean contains(Object o) {
                Entry<?, ?> entry = (Entry<?, ?>) o;
                boolean varC238596BFA0BDAC8F31141888DBD9FC9_282835029 = (isInBounds(entry.getKey()) && findByEntry(entry) != null);
                addTaint(o.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1847148199 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1847148199;
                // ---------- Original Method ----------
                //if (!(o instanceof Entry)) {
                    //return false;
                //}
                //Entry<?, ?> entry = (Entry<?, ?>) o;
                //return isInBounds(entry.getKey()) && findByEntry(entry) != null;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.522 -0400", hash_original_method = "EF59D88655EE445530DBDC219FDD1A5F", hash_generated_method = "4F14394A952C66CF722A41AF3FDCD0E6")
            @Override
            public boolean remove(Object o) {
                Entry<?, ?> entry = (Entry<?, ?>) o;
                boolean var155AF0A9D9B42FB9DF7C214F267A7E1B_2125679003 = (isInBounds(entry.getKey()) && TreeMap.this.entrySet().remove(entry));
                addTaint(o.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1744106670 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1744106670;
                // ---------- Original Method ----------
                //if (!(o instanceof Entry)) {
                    //return false;
                //}
                //Entry<?, ?> entry = (Entry<?, ?>) o;
                //return isInBounds(entry.getKey()) && TreeMap.this.entrySet().remove(entry);
            }

            
        }


        
        final class BoundedKeySet extends AbstractSet<K> implements NavigableSet<K> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.522 -0400", hash_original_method = "9AD1259E686AD3B6150FA3E61E8BAA17", hash_generated_method = "9AD1259E686AD3B6150FA3E61E8BAA17")
            public BoundedKeySet ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.523 -0400", hash_original_method = "29BBB3BE9EA7B6D6C0B83C28F05082A4", hash_generated_method = "4C375AED55C332C3C09CECB827546AB4")
            @Override
            public int size() {
                int var69D9F234E7E76618743D3D698A58599B_2086967916 = (BoundedMap.this.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_250761058 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_250761058;
                // ---------- Original Method ----------
                //return BoundedMap.this.size();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.524 -0400", hash_original_method = "AEA447F4A69E282FABF93736832EBAA3", hash_generated_method = "57C0CA3D3DEC7E0DAA047D2877EB1BDA")
            @Override
            public boolean isEmpty() {
                boolean varF1E2DF8AD3E4C9C508E293B19251E66A_1099809281 = (BoundedMap.this.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1023721777 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1023721777;
                // ---------- Original Method ----------
                //return BoundedMap.this.isEmpty();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.525 -0400", hash_original_method = "8539DDED7A19368CB3D09440D6A62269", hash_generated_method = "32046B8942701DD6670ECE32A2F00927")
            @Override
            public Iterator<K> iterator() {
                Iterator<K> varB4EAC82CA7396A68D541C85D26508E83_1201741434 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1201741434 = new BoundedIterator<K>(endpoint(true)) {
                    public K next() {
                        return (ascending ? stepForward() : stepBackward()).key;
                    }
                };
                varB4EAC82CA7396A68D541C85D26508E83_1201741434.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1201741434;
                // ---------- Original Method ----------
                //return new BoundedIterator<K>(endpoint(true)) {
                    //public K next() {
                        //return (ascending ? stepForward() : stepBackward()).key;
                    //}
                //};
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.526 -0400", hash_original_method = "74923548E6D3A508C57DDA053BC0EE64", hash_generated_method = "D3D8B0BD4D23CBCF1BBD3E243639EF1C")
            public Iterator<K> descendingIterator() {
                Iterator<K> varB4EAC82CA7396A68D541C85D26508E83_223209243 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_223209243 = new BoundedIterator<K>(endpoint(false)) {
                    public K next() {
                        return (ascending ? stepBackward() : stepForward()).key;
                    }
                };
                varB4EAC82CA7396A68D541C85D26508E83_223209243.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_223209243;
                // ---------- Original Method ----------
                //return new BoundedIterator<K>(endpoint(false)) {
                    //public K next() {
                        //return (ascending ? stepBackward() : stepForward()).key;
                    //}
                //};
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.526 -0400", hash_original_method = "F2816D590B9E0F32B93C47AB444AEEED", hash_generated_method = "4BC4B2DDB4110543CABA47D03E052949")
            @Override
            public boolean contains(Object key) {
                boolean varDEADC564C50A1257392A09A833F9988B_52929889 = (isInBounds(key) && findByObject(key) != null);
                addTaint(key.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1028278826 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1028278826;
                // ---------- Original Method ----------
                //return isInBounds(key) && findByObject(key) != null;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.526 -0400", hash_original_method = "ADEDE1B4ABE9B2F86F8B629056F35200", hash_generated_method = "560912F34941B34E49ACB2B81E20F61A")
            @Override
            public boolean remove(Object key) {
                boolean var55612E9AB490EF3FFBD38F202307B8D4_935906227 = (isInBounds(key) && removeInternalByKey(key) != null);
                addTaint(key.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1304415795 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1304415795;
                // ---------- Original Method ----------
                //return isInBounds(key) && removeInternalByKey(key) != null;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.527 -0400", hash_original_method = "3067DEE01FBBBFD061436C7D4561F434", hash_generated_method = "216CE8C43BEF589069DD5D9B3FD12046")
            public K first() {
                K varB4EAC82CA7396A68D541C85D26508E83_1528704714 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1528704714 = firstKey();
                varB4EAC82CA7396A68D541C85D26508E83_1528704714.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1528704714;
                // ---------- Original Method ----------
                //return firstKey();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.527 -0400", hash_original_method = "4985BB63726B115899F1811F08E80BDF", hash_generated_method = "A6A6F5D9F0F91B3993BD4A43D9CB5D86")
            public K pollFirst() {
                K varB4EAC82CA7396A68D541C85D26508E83_1308676049 = null; //Variable for return #1
                Entry<K, ?> entry = pollFirstEntry();
                varB4EAC82CA7396A68D541C85D26508E83_1308676049 = entry != null ? entry.getKey() : null;
                varB4EAC82CA7396A68D541C85D26508E83_1308676049.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1308676049;
                // ---------- Original Method ----------
                //Entry<K, ?> entry = pollFirstEntry();
                //return entry != null ? entry.getKey() : null;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.528 -0400", hash_original_method = "39C87F788E647BCD3FB86FFF34D7EF10", hash_generated_method = "DD545322A39F40274E4F22E5C4FFFEB9")
            public K last() {
                K varB4EAC82CA7396A68D541C85D26508E83_1568491815 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1568491815 = lastKey();
                varB4EAC82CA7396A68D541C85D26508E83_1568491815.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1568491815;
                // ---------- Original Method ----------
                //return lastKey();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.528 -0400", hash_original_method = "B202B1B2AAB477548F6A0AD72C9B1701", hash_generated_method = "02C1925B6672426E49E0E9C0207BAE49")
            public K pollLast() {
                K varB4EAC82CA7396A68D541C85D26508E83_1844726281 = null; //Variable for return #1
                Entry<K, ?> entry = pollLastEntry();
                varB4EAC82CA7396A68D541C85D26508E83_1844726281 = entry != null ? entry.getKey() : null;
                varB4EAC82CA7396A68D541C85D26508E83_1844726281.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1844726281;
                // ---------- Original Method ----------
                //Entry<K, ?> entry = pollLastEntry();
                //return entry != null ? entry.getKey() : null;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.529 -0400", hash_original_method = "5CFE05BF706A06BBB501067306F1B9ED", hash_generated_method = "3FB9282AC70B23E72C66CBA2B7A9783F")
            public K lower(K key) {
                K varB4EAC82CA7396A68D541C85D26508E83_1868407861 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1868407861 = lowerKey(key);
                addTaint(key.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_1868407861.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1868407861;
                // ---------- Original Method ----------
                //return lowerKey(key);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.529 -0400", hash_original_method = "10BABB7BB2E837824A13AAE89EE7EC6F", hash_generated_method = "693A1DB716851DD27FAAA30DE83C8943")
            public K floor(K key) {
                K varB4EAC82CA7396A68D541C85D26508E83_1430123595 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1430123595 = floorKey(key);
                addTaint(key.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_1430123595.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1430123595;
                // ---------- Original Method ----------
                //return floorKey(key);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.530 -0400", hash_original_method = "2AD4706A6D818B709A1E2CA64B48B4B9", hash_generated_method = "B08443DF53A3C8840DE24D5223CFEAD1")
            public K ceiling(K key) {
                K varB4EAC82CA7396A68D541C85D26508E83_455803822 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_455803822 = ceilingKey(key);
                addTaint(key.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_455803822.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_455803822;
                // ---------- Original Method ----------
                //return ceilingKey(key);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.530 -0400", hash_original_method = "8CC63649234BFC57DB10A2387AE34DD6", hash_generated_method = "1AB460667A5E5D2FB7DC707CD5E4DFA3")
            public K higher(K key) {
                K varB4EAC82CA7396A68D541C85D26508E83_804029768 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_804029768 = higherKey(key);
                addTaint(key.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_804029768.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_804029768;
                // ---------- Original Method ----------
                //return higherKey(key);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.530 -0400", hash_original_method = "C5DD330893039070B9523799F47D2DEB", hash_generated_method = "102056A3BF79C2489E341AC33701FF82")
            public Comparator<? super K> comparator() {
                Comparator<? super K> varB4EAC82CA7396A68D541C85D26508E83_775681917 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_775681917 = BoundedMap.this.comparator();
                varB4EAC82CA7396A68D541C85D26508E83_775681917.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_775681917;
                // ---------- Original Method ----------
                //return BoundedMap.this.comparator();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.531 -0400", hash_original_method = "21039715CA3F916EA62F8064E71FC6CA", hash_generated_method = "2BDE4018EF259F4DA2B4924118A5F335")
            public NavigableSet<K> subSet(K from, boolean fromInclusive, K to, boolean toInclusive) {
                NavigableSet<K> varB4EAC82CA7396A68D541C85D26508E83_1481125486 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1481125486 = subMap(from, fromInclusive, to, toInclusive).navigableKeySet();
                addTaint(from.getTaint());
                addTaint(fromInclusive);
                addTaint(to.getTaint());
                addTaint(toInclusive);
                varB4EAC82CA7396A68D541C85D26508E83_1481125486.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1481125486;
                // ---------- Original Method ----------
                //return subMap(from, fromInclusive, to, toInclusive).navigableKeySet();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.531 -0400", hash_original_method = "AA0E5149ADFB9D8316CC8EA86FBC0B9E", hash_generated_method = "D6CA7E64BBB1F677B532999F0D3AD446")
            public SortedSet<K> subSet(K fromInclusive, K toExclusive) {
                SortedSet<K> varB4EAC82CA7396A68D541C85D26508E83_562264103 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_562264103 = subMap(fromInclusive, toExclusive).navigableKeySet();
                addTaint(fromInclusive.getTaint());
                addTaint(toExclusive.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_562264103.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_562264103;
                // ---------- Original Method ----------
                //return subMap(fromInclusive, toExclusive).navigableKeySet();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.532 -0400", hash_original_method = "EDDD3784AC7E9834A18CCB5F2AE27346", hash_generated_method = "4420D7CA4F93C66A76DB268B8119D9E4")
            public NavigableSet<K> headSet(K to, boolean inclusive) {
                NavigableSet<K> varB4EAC82CA7396A68D541C85D26508E83_216369923 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_216369923 = headMap(to, inclusive).navigableKeySet();
                addTaint(to.getTaint());
                addTaint(inclusive);
                varB4EAC82CA7396A68D541C85D26508E83_216369923.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_216369923;
                // ---------- Original Method ----------
                //return headMap(to, inclusive).navigableKeySet();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.533 -0400", hash_original_method = "85EE899AF4D85617CB858518BA70EA12", hash_generated_method = "4D21BCE11145A2F6DB79DD32EF494AD5")
            public SortedSet<K> headSet(K toExclusive) {
                SortedSet<K> varB4EAC82CA7396A68D541C85D26508E83_964713578 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_964713578 = headMap(toExclusive).navigableKeySet();
                addTaint(toExclusive.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_964713578.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_964713578;
                // ---------- Original Method ----------
                //return headMap(toExclusive).navigableKeySet();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.533 -0400", hash_original_method = "B964A303D464756EDD8E9C26A8D54411", hash_generated_method = "61B8F0BE98458CD07858782049642057")
            public NavigableSet<K> tailSet(K from, boolean inclusive) {
                NavigableSet<K> varB4EAC82CA7396A68D541C85D26508E83_1690539773 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1690539773 = tailMap(from, inclusive).navigableKeySet();
                addTaint(from.getTaint());
                addTaint(inclusive);
                varB4EAC82CA7396A68D541C85D26508E83_1690539773.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1690539773;
                // ---------- Original Method ----------
                //return tailMap(from, inclusive).navigableKeySet();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.534 -0400", hash_original_method = "9536952691BDDFD3D8EFB20A3BD9AE85", hash_generated_method = "3ACBFD6FBAFEDDC033F7F37798687B5F")
            public SortedSet<K> tailSet(K fromInclusive) {
                SortedSet<K> varB4EAC82CA7396A68D541C85D26508E83_1497554085 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1497554085 = tailMap(fromInclusive).navigableKeySet();
                addTaint(fromInclusive.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_1497554085.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1497554085;
                // ---------- Original Method ----------
                //return tailMap(fromInclusive).navigableKeySet();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.534 -0400", hash_original_method = "2BD89B2F5D5D75B5A66FC121E2BE77F9", hash_generated_method = "1F72E67C4AEA703A3EDF10B28750073A")
            public NavigableSet<K> descendingSet() {
                NavigableSet<K> varB4EAC82CA7396A68D541C85D26508E83_490017472 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_490017472 = new BoundedMap(!ascending, from, fromBound, to, toBound).navigableKeySet();
                varB4EAC82CA7396A68D541C85D26508E83_490017472.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_490017472;
                // ---------- Original Method ----------
                //return new BoundedMap(!ascending, from, fromBound, to, toBound).navigableKeySet();
            }

            
        }


        
    }


    
    static abstract class NavigableSubMap<K, V> extends AbstractMap<K, V> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.536 -0400", hash_original_field = "6F8F57715090DA2632453988D9A1501B", hash_generated_field = "B4717CF7B02EE2D309DEC599DAA1DA31")

        TreeMap<K, V> m;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.536 -0400", hash_original_field = "7CE8636C076F5F42316676F7CA5CCFBE", hash_generated_field = "281EBE4703232193C289CCB42FC430E9")

        Object lo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.536 -0400", hash_original_field = "49F68A5C8493EC2C0BF489821C21FC3B", hash_generated_field = "EE270961C9ABF0EB22776F11E5EA361C")

        Object hi;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.536 -0400", hash_original_field = "0F5BB94160321573CBA39E65B009DB81", hash_generated_field = "D276D04527E3A57EE21A2E9A0B8A1207")

        boolean fromStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.536 -0400", hash_original_field = "A7515FC4FC23FB8889BFBA1242727AA1", hash_generated_field = "949B6DE90AB1D05CDD408410B1AFD766")

        boolean toEnd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.536 -0400", hash_original_field = "A7CF08EB9369574B3716AAA5776C2B8D", hash_generated_field = "21B44DD2A9CF91217A1B213D6DC61745")

        boolean loInclusive;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.536 -0400", hash_original_field = "A4BF0B040F2788C41F2B3BBC34352A92", hash_generated_field = "B6BC458569D2A14CE4BE7D6F92D77203")

        boolean hiInclusive;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.538 -0400", hash_original_method = "C1ACA683FC5CFCA3BE29823730AC5B8B", hash_generated_method = "D5980D3B68B4F742E542A915179E4C63")
          NavigableSubMap(TreeMap<K, V> delegate, K from, Bound fromBound, K to, Bound toBound) {
            this.m = delegate;
            this.lo = from;
            this.hi = to;
            this.fromStart = fromBound == NO_BOUND;
            this.toEnd = toBound == NO_BOUND;
            this.loInclusive = fromBound == INCLUSIVE;
            this.hiInclusive = toBound == INCLUSIVE;
            // ---------- Original Method ----------
            //this.m = delegate;
            //this.lo = from;
            //this.hi = to;
            //this.fromStart = fromBound == NO_BOUND;
            //this.toEnd = toBound == NO_BOUND;
            //this.loInclusive = fromBound == INCLUSIVE;
            //this.hiInclusive = toBound == INCLUSIVE;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.540 -0400", hash_original_method = "98169B5D59A5E61A69F2A37D56262114", hash_generated_method = "3CAF377124FBFCFBABACDE8606964B0B")
        @Override
        public Set<Entry<K, V>> entrySet() {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.542 -0400", hash_original_method = "6A8A4C8549808D70F841B9593D31A43F", hash_generated_method = "4CA16AC9F6C4BCC2190604D6B0646189")
        @SuppressWarnings("unchecked")
        protected Object readResolve() throws ObjectStreamException {
            Object varB4EAC82CA7396A68D541C85D26508E83_631445865 = null; //Variable for return #1
            Bound fromBound;
            fromBound = NO_BOUND;
            fromBound = (loInclusive ? INCLUSIVE : EXCLUSIVE);
            Bound toBound;
            toBound = NO_BOUND;
            toBound = (hiInclusive ? INCLUSIVE : EXCLUSIVE);
            boolean ascending = !(this instanceof DescendingSubMap);
            varB4EAC82CA7396A68D541C85D26508E83_631445865 = m.new BoundedMap(ascending, (K) lo, fromBound, (K) hi, toBound);
            varB4EAC82CA7396A68D541C85D26508E83_631445865.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_631445865;
            // ---------- Original Method ----------
            //Bound fromBound = fromStart ? NO_BOUND : (loInclusive ? INCLUSIVE : EXCLUSIVE);
            //Bound toBound = toEnd ? NO_BOUND : (hiInclusive ? INCLUSIVE : EXCLUSIVE);
            //boolean ascending = !(this instanceof DescendingSubMap);
            //return m.new BoundedMap(ascending, (K) lo, fromBound, (K) hi, toBound);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.542 -0400", hash_original_field = "24DD802BAD101B93E8408F7D464B2F7C", hash_generated_field = "6BF063A975464DC368634F8846E9F148")

        private static final long serialVersionUID = -2102997345730753016L;
    }


    
    static class DescendingSubMap<K, V> extends NavigableSubMap<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.542 -0400", hash_original_field = "9895B45EF9B1655F7485C1A0A0B5F7B1", hash_generated_field = "4B9119BDF2383B87567C450919484206")

        Comparator<K> reverseComparator;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.543 -0400", hash_original_method = "FDAA1F4436CE129642763FB7A272001D", hash_generated_method = "403BC4E2D5604955FA33199087DB72AD")
          DescendingSubMap(TreeMap<K, V> delegate, K from, Bound fromBound, K to, Bound toBound) {
            super(delegate, from, fromBound, to, toBound);
            addTaint(delegate.getTaint());
            addTaint(from.getTaint());
            addTaint(fromBound.getTaint());
            addTaint(to.getTaint());
            addTaint(toBound.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.543 -0400", hash_original_field = "52D0D343187A178B79D894969A386899", hash_generated_field = "C2E3DB7866C7906947BFB5DD9B67BC77")

        private static final long serialVersionUID = 912986545866120460L;
    }


    
    static class AscendingSubMap<K, V> extends NavigableSubMap<K, V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.544 -0400", hash_original_method = "C32F016187D7478ED63A0FCF56CB93EB", hash_generated_method = "CB936BEDAF7FEDB34599950C363DBD15")
          AscendingSubMap(TreeMap<K, V> delegate, K from, Bound fromBound, K to, Bound toBound) {
            super(delegate, from, fromBound, to, toBound);
            addTaint(delegate.getTaint());
            addTaint(from.getTaint());
            addTaint(fromBound.getTaint());
            addTaint(to.getTaint());
            addTaint(toBound.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.544 -0400", hash_original_field = "B7AE5FA51DF371C0F9A4E87B021D4132", hash_generated_field = "9BC786EF1C7A0AEECE0DAFB6F4501079")

        private static final long serialVersionUID = 912986545866124060L;
    }


    
    class SubMap extends AbstractMap<K, V> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.544 -0400", hash_original_field = "430A77C88BFBC96EB36AF12A2DC1DEB7", hash_generated_field = "7CA688EFC5D14AE4FAAF4A0FA771CBD0")

        Object fromKey;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.544 -0400", hash_original_field = "A8F9F07D66AF8C1622E025437E7B26CE", hash_generated_field = "40A3A7AC103CBB24D1824415661519AF")

        Object toKey;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.544 -0400", hash_original_field = "0F5BB94160321573CBA39E65B009DB81", hash_generated_field = "D276D04527E3A57EE21A2E9A0B8A1207")

        boolean fromStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.544 -0400", hash_original_field = "A7515FC4FC23FB8889BFBA1242727AA1", hash_generated_field = "949B6DE90AB1D05CDD408410B1AFD766")

        boolean toEnd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.544 -0400", hash_original_method = "F30568FCC0DA5EEA09201E340702FDB4", hash_generated_method = "F30568FCC0DA5EEA09201E340702FDB4")
        public SubMap ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.546 -0400", hash_original_method = "98169B5D59A5E61A69F2A37D56262114", hash_generated_method = "3CAF377124FBFCFBABACDE8606964B0B")
        @Override
        public Set<Entry<K, V>> entrySet() {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.547 -0400", hash_original_method = "AC95C6CC81DF8BD4B0519A49635D6CF0", hash_generated_method = "A62CB3DCF9C6A1DC9286059C6A5610D8")
        @SuppressWarnings("unchecked")
        protected Object readResolve() throws ObjectStreamException {
            Object varB4EAC82CA7396A68D541C85D26508E83_2016910940 = null; //Variable for return #1
            Bound fromBound;
            fromBound = NO_BOUND;
            fromBound = INCLUSIVE;
            Bound toBound;
            toBound = NO_BOUND;
            toBound = EXCLUSIVE;
            varB4EAC82CA7396A68D541C85D26508E83_2016910940 = new BoundedMap(true, (K) fromKey, fromBound, (K) toKey, toBound);
            varB4EAC82CA7396A68D541C85D26508E83_2016910940.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2016910940;
            // ---------- Original Method ----------
            //Bound fromBound = fromStart ? NO_BOUND : INCLUSIVE;
            //Bound toBound = toEnd ? NO_BOUND : EXCLUSIVE;
            //return new BoundedMap(true, (K) fromKey, fromBound, (K) toKey, toBound);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.547 -0400", hash_original_field = "EB690E9D3449E3ACDD044094944C88A2", hash_generated_field = "20872E7F065D1D88A3E41FBB2346AD4E")

        private static final long serialVersionUID = -6520786458950516097L;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.547 -0400", hash_original_field = "AAD864C939B46188F070706401E1932C", hash_generated_field = "C574FEBC92A9E5D83B951EB931304363")

    @SuppressWarnings("unchecked") private static final Comparator<Comparable> NATURAL_ORDER = new Comparator<Comparable>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.547 -0400", hash_original_method = "078A1DB9555D9E606EA5FF406F56B2E6", hash_generated_method = "00940CF90AFA854079CAC5C992323851")
        public int compare(Comparable a, Comparable b) {
            int varC15B2565AD7A5177ED0132648C5386D9_18628642 = (a.compareTo(b));
            addTaint(a.getTaint());
            addTaint(b.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1221955437 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1221955437;
            // ---------- Original Method ----------
            //return a.compareTo(b);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.547 -0400", hash_original_field = "0CB2D400AD555324093441A5EA2C6B7E", hash_generated_field = "72B7CECA8AF68C19BE3FF8E965B18D99")

    private static final long serialVersionUID = 919286545866124006L;
}

