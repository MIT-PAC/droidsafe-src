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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.540 -0400", hash_original_field = "4092F21BD0E2CC3C9CA971DF59AA8608", hash_generated_field = "10E826BC31BCAB9BF3EF3CC29146C2D4")

    Comparator<? super K> comparator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.540 -0400", hash_original_field = "63A9F0EA7BB98050796B649E85481845", hash_generated_field = "85295BCB9659691A12B83D4313F1A2F9")

    Node<K, V> root;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.540 -0400", hash_original_field = "4C519DE3531208469B40CCB51004CD2D", hash_generated_field = "689FC3CB9A887B5817C15E9CFDD066DB")

    int size = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.540 -0400", hash_original_field = "8626C3CD64A823DD7B97C6F5EF45A8FC", hash_generated_field = "7C38AA8724D6D8AD727BB2AB85887DF0")

    int modCount = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.540 -0400", hash_original_field = "D4E06C98DBA5A687CB6C836BF538EC81", hash_generated_field = "78564EACF73DB0AEDD2E075A8DFF1B13")

    private EntrySet entrySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.540 -0400", hash_original_field = "3E8ABCE844B6A8A95397486A3899B536", hash_generated_field = "455D81AE8BC4090CF8AD993E78862377")

    private KeySet keySet;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.546 -0400", hash_original_method = "A79D85B768A2B786B5F2ACD3F2B9D249", hash_generated_method = "CFE342F2F41F7796DB24A93B3EC5E9D4")
    @SuppressWarnings("unchecked")
    public  TreeMap() {
        this.comparator = (Comparator<? super K>) NATURAL_ORDER;
        // ---------- Original Method ----------
        //this.comparator = (Comparator<? super K>) NATURAL_ORDER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.593 -0400", hash_original_method = "317880CC1AD8B8CC7D9C11CC941EE8C3", hash_generated_method = "D5F7002165857F6E4A37D803A7EDC81E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.594 -0400", hash_original_method = "C1FE892CAD9D3780A675F5A8CA11F4FA", hash_generated_method = "A5FA904989BCCDB3DA871E0B26BCC9ED")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.627 -0400", hash_original_method = "2607F9CE6A88866DC32D385287E67644", hash_generated_method = "0D83ED9D530594A5ECD516091B277AF9")
    @SuppressWarnings("unchecked")
    public  TreeMap(SortedMap<K, ? extends V> copyFrom) {
        Comparator<? super K> sourceComparator;
        sourceComparator = copyFrom.comparator();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.643 -0400", hash_original_method = "FB8B1056739768AF92CF25DB3C2D30EB", hash_generated_method = "BFE8B2A8EEF9AAFCB470E97AA5A4F8DA")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_940873942 = null; //Variable for return #1
        try 
        {
            @SuppressWarnings("unchecked") TreeMap<K, V> map;
            map = (TreeMap<K, V>) super.clone();
            map.root = root != null ? root.copy(null) : null;
            map.entrySet = null;
            map.keySet = null;
            varB4EAC82CA7396A68D541C85D26508E83_940873942 = map;
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_940873942.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_940873942;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.644 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "12C2CFB5B5DB50B128DF8056A4FC9C1D")
    @Override
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_597242572 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_597242572;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.644 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "D9AA343C42E5548EF8C715B2E030A7CF")
    @Override
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_450219313 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_450219313;
        // ---------- Original Method ----------
        //return size == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.645 -0400", hash_original_method = "C35732A40B74AF28951D9E96FE33879B", hash_generated_method = "5C674EB9F23F4A158F025769D06C5E91")
    @Override
    public V get(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_1025944810 = null; //Variable for return #1
        Entry<K, V> entry;
        entry = findByObject(key);
        varB4EAC82CA7396A68D541C85D26508E83_1025944810 = entry != null ? entry.getValue() : null;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1025944810.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1025944810;
        // ---------- Original Method ----------
        //Entry<K, V> entry = findByObject(key);
        //return entry != null ? entry.getValue() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.645 -0400", hash_original_method = "CD38E6D478445847B9B0A556F5E63837", hash_generated_method = "8DAAB51C887E2DD69D62E5FC265C9ACB")
    @Override
    public boolean containsKey(Object key) {
        boolean var169B170947F44477F294694A95E8B219_1084853473 = (findByObject(key) != null);
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_425599154 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_425599154;
        // ---------- Original Method ----------
        //return findByObject(key) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.648 -0400", hash_original_method = "09423F07E68B4770E107529B69AA8334", hash_generated_method = "2CB8DB1C6184E358E6E57AE4245584FD")
    @Override
    public V put(K key, V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_776289260 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_776289260 = putInternal(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_776289260.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_776289260;
        // ---------- Original Method ----------
        //return putInternal(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.648 -0400", hash_original_method = "EA5BE6ED678D7376259BCC3DB1C01E21", hash_generated_method = "25747B87C7C6F2CC69ED86A75548B960")
    @Override
    public void clear() {
        root = null;
        size = 0;
        // ---------- Original Method ----------
        //root = null;
        //size = 0;
        //modCount++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.664 -0400", hash_original_method = "0207194EB3BB344ADD94A18916C183DF", hash_generated_method = "CA200EBFE2831C800DA6FF65EC60548C")
    @Override
    public V remove(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_2119441556 = null; //Variable for return #1
        Node<K, V> node;
        node = removeInternalByKey(key);
        varB4EAC82CA7396A68D541C85D26508E83_2119441556 = node != null ? node.value : null;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2119441556.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2119441556;
        // ---------- Original Method ----------
        //Node<K, V> node = removeInternalByKey(key);
        //return node != null ? node.value : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.673 -0400", hash_original_method = "73D5DA91D47B13631BBA1FF4FFC14006", hash_generated_method = "A11BDC39802FC01B2ACA89E8049165D5")
     V putInternal(K key, V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_1286240602 = null; //Variable for return #1
        Node<K, V> created;
        created = find(key, Relation.CREATE);
        V result;
        result = created.value;
        created.value = value;
        varB4EAC82CA7396A68D541C85D26508E83_1286240602 = result;
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1286240602.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1286240602;
        // ---------- Original Method ----------
        //Node<K, V> created = find(key, Relation.CREATE);
        //V result = created.value;
        //created.value = value;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.676 -0400", hash_original_method = "A47B461F1595004F5F78D5AE91E8DCD0", hash_generated_method = "F91A88CD4D8CC6FC74DC181A545A05C3")
     Node<K, V> find(K key, Relation relation) {
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_2010626218 = null; //Variable for return #1
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_934218018 = null; //Variable for return #2
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1115081354 = null; //Variable for return #3
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1730175169 = null; //Variable for return #4
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_876481365 = null; //Variable for return #5
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1731203512 = null; //Variable for return #6
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_419993728 = null; //Variable for return #7
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_144313570 = null; //Variable for return #8
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1853871110 = null; //Variable for return #9
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_91350894 = null; //Variable for return #10
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1018978044 = null; //Variable for return #11
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1369724133 = null; //Variable for return #12
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1263527419 = null; //Variable for return #13
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new ClassCastException(key.getClass().getName() + " is not Comparable");
            } //End block
            {
                root = new Node<K, V>(null, key);
                size = 1;
                varB4EAC82CA7396A68D541C85D26508E83_2010626218 = root;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_934218018 = null;
            } //End block
        } //End block
        @SuppressWarnings("unchecked") Comparable<Object> comparableKey;
        comparableKey = (Comparable<Object>) key;
        comparableKey = null;
        Node<K, V> nearest;
        nearest = root;
        {
            int comparison;
            comparison = comparableKey.compareTo(nearest.key);
            comparison = comparator.compare(key, nearest.key);
            {
                //Begin case LOWER 
                varB4EAC82CA7396A68D541C85D26508E83_1115081354 = nearest.prev();
                //End case LOWER 
                //Begin case FLOOR EQUAL CREATE CEILING 
                varB4EAC82CA7396A68D541C85D26508E83_1730175169 = nearest;
                //End case FLOOR EQUAL CREATE CEILING 
                //Begin case HIGHER 
                varB4EAC82CA7396A68D541C85D26508E83_876481365 = nearest.next();
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
                varB4EAC82CA7396A68D541C85D26508E83_1731203512 = nearest.prev();
                //End case LOWER FLOOR 
                //Begin case CEILING HIGHER 
                varB4EAC82CA7396A68D541C85D26508E83_419993728 = nearest;
                //End case CEILING HIGHER 
                //Begin case EQUAL 
                varB4EAC82CA7396A68D541C85D26508E83_144313570 = null;
                //End case EQUAL 
                //Begin case CREATE 
                Node<K, V> created;
                created = new Node<K, V>(nearest, key);
                //End case CREATE 
                //Begin case CREATE 
                nearest.left = created;
                //End case CREATE 
                //Begin case CREATE 
                rebalance(nearest, true);
                //End case CREATE 
                //Begin case CREATE 
                varB4EAC82CA7396A68D541C85D26508E83_1853871110 = created;
                //End case CREATE 
            } //End block
            {
                //Begin case LOWER FLOOR 
                varB4EAC82CA7396A68D541C85D26508E83_91350894 = nearest;
                //End case LOWER FLOOR 
                //Begin case CEILING HIGHER 
                varB4EAC82CA7396A68D541C85D26508E83_1018978044 = nearest.next();
                //End case CEILING HIGHER 
                //Begin case EQUAL 
                varB4EAC82CA7396A68D541C85D26508E83_1369724133 = null;
                //End case EQUAL 
                //Begin case CREATE 
                Node<K, V> created;
                created = new Node<K, V>(nearest, key);
                //End case CREATE 
                //Begin case CREATE 
                nearest.right = created;
                //End case CREATE 
                //Begin case CREATE 
                rebalance(nearest, true);
                //End case CREATE 
                //Begin case CREATE 
                varB4EAC82CA7396A68D541C85D26508E83_1263527419 = created;
                //End case CREATE 
            } //End block
        } //End block
        addTaint(relation.getTaint());
        Node<K, V> varA7E53CE21691AB073D9660D615818899_201163948; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_201163948 = varB4EAC82CA7396A68D541C85D26508E83_2010626218;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_201163948 = varB4EAC82CA7396A68D541C85D26508E83_934218018;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_201163948 = varB4EAC82CA7396A68D541C85D26508E83_1115081354;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_201163948 = varB4EAC82CA7396A68D541C85D26508E83_1730175169;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_201163948 = varB4EAC82CA7396A68D541C85D26508E83_876481365;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_201163948 = varB4EAC82CA7396A68D541C85D26508E83_1731203512;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_201163948 = varB4EAC82CA7396A68D541C85D26508E83_419993728;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_201163948 = varB4EAC82CA7396A68D541C85D26508E83_144313570;
                break;
            case 9: //Assign result for return ordinal #9
                varA7E53CE21691AB073D9660D615818899_201163948 = varB4EAC82CA7396A68D541C85D26508E83_1853871110;
                break;
            case 10: //Assign result for return ordinal #10
                varA7E53CE21691AB073D9660D615818899_201163948 = varB4EAC82CA7396A68D541C85D26508E83_91350894;
                break;
            case 11: //Assign result for return ordinal #11
                varA7E53CE21691AB073D9660D615818899_201163948 = varB4EAC82CA7396A68D541C85D26508E83_1018978044;
                break;
            case 12: //Assign result for return ordinal #12
                varA7E53CE21691AB073D9660D615818899_201163948 = varB4EAC82CA7396A68D541C85D26508E83_1369724133;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_201163948 = varB4EAC82CA7396A68D541C85D26508E83_1263527419;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_201163948.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_201163948;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.691 -0400", hash_original_method = "C267D163E835004AE4803D9A2BC1E552", hash_generated_method = "E835B7B68652FBF4E61B0994653F8035")
    @SuppressWarnings("unchecked")
     Node<K, V> findByObject(Object key) {
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1278602466 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1278602466 = find((K) key, EQUAL);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1278602466.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1278602466;
        // ---------- Original Method ----------
        //return find((K) key, EQUAL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.691 -0400", hash_original_method = "8678505752B854905CFE7B96C4FE458B", hash_generated_method = "AC9360DA49EE93512279D80DB86CAB1D")
     Node<K, V> findByEntry(Entry<?, ?> entry) {
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_339554984 = null; //Variable for return #1
        Node<K, V> mine;
        mine = findByObject(entry.getKey());
        boolean valuesEqual;
        valuesEqual = mine != null && Objects.equal(mine.value, entry.getValue());
        varB4EAC82CA7396A68D541C85D26508E83_339554984 = valuesEqual ? mine : null;
        addTaint(entry.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_339554984.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_339554984;
        // ---------- Original Method ----------
        //Node<K, V> mine = findByObject(entry.getKey());
        //boolean valuesEqual = mine != null && Objects.equal(mine.value, entry.getValue());
        //return valuesEqual ? mine : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.696 -0400", hash_original_method = "FAD76EC8E4C5DF9CCDE64BA514AC9743", hash_generated_method = "829F2DC186393E27F305515F02A5DD3D")
     void removeInternal(Node<K, V> node) {
        Node<K, V> left;
        left = node.left;
        Node<K, V> right;
        right = node.right;
        Node<K, V> originalParent;
        originalParent = node.parent;
        {
            Node<K, V> adjacent;
            adjacent = left.last();
            adjacent = right.first();
            removeInternal(adjacent);
            int leftHeight;
            leftHeight = 0;
            left = node.left;
            {
                leftHeight = left.height;
                adjacent.left = left;
                left.parent = adjacent;
                node.left = null;
            } //End block
            int rightHeight;
            rightHeight = 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.697 -0400", hash_original_method = "C9B9883A6728DC2F4DBB90BDF61B9978", hash_generated_method = "A2A53058CC05D9D4C0AB39E27625988B")
     Node<K, V> removeInternalByKey(Object key) {
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_987170324 = null; //Variable for return #1
        Node<K, V> node;
        node = findByObject(key);
        {
            removeInternal(node);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_987170324 = node;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_987170324.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_987170324;
        // ---------- Original Method ----------
        //Node<K, V> node = findByObject(key);
        //if (node != null) {
            //removeInternal(node);
        //}
        //return node;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.698 -0400", hash_original_method = "8CBFE12E379E7871AFCE5B0FC5C284CB", hash_generated_method = "5D9C04E6B48B66D85F2051BBA336997D")
    private void replaceInParent(Node<K, V> node, Node<K, V> replacement) {
        Node<K, V> parent;
        parent = node.parent;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.721 -0400", hash_original_method = "DE22B63E2A021BAF8A5DCC142FCC4B40", hash_generated_method = "41613B51E1B5900AA3F99F24B9CA38F2")
    private void rebalance(Node<K, V> unbalanced, boolean insert) {
        {
            Node<K, V> node;
            node = unbalanced;
            node = node.parent;
            {
                Node<K, V> left;
                left = node.left;
                Node<K, V> right;
                right = node.right;
                int leftHeight;
                leftHeight = left.height;
                leftHeight = 0;
                int rightHeight;
                rightHeight = right.height;
                rightHeight = 0;
                int delta;
                delta = leftHeight - rightHeight;
                {
                    Node<K, V> rightLeft;
                    rightLeft = right.left;
                    Node<K, V> rightRight;
                    rightRight = right.right;
                    int rightRightHeight;
                    rightRightHeight = rightRight.height;
                    rightRightHeight = 0;
                    int rightLeftHeight;
                    rightLeftHeight = rightLeft.height;
                    rightLeftHeight = 0;
                    int rightDelta;
                    rightDelta = rightLeftHeight - rightRightHeight;
                    {
                        rotateLeft(node);
                    } //End block
                    {
                        rotateRight(right);
                        rotateLeft(node);
                    } //End block
                } //End block
                {
                    Node<K, V> leftLeft;
                    leftLeft = left.left;
                    Node<K, V> leftRight;
                    leftRight = left.right;
                    int leftRightHeight;
                    leftRightHeight = leftRight.height;
                    leftRightHeight = 0;
                    int leftLeftHeight;
                    leftLeftHeight = leftLeft.height;
                    leftLeftHeight = 0;
                    int leftDelta;
                    leftDelta = leftLeftHeight - leftRightHeight;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.722 -0400", hash_original_method = "6326CB79DBF89391F00F9AB13B0E81D9", hash_generated_method = "29E24C70394F131BDC1B8808649E5575")
    private void rotateLeft(Node<K, V> root) {
        Node<K, V> left;
        left = root.left;
        Node<K, V> pivot;
        pivot = root.right;
        Node<K, V> pivotLeft;
        pivotLeft = pivot.left;
        Node<K, V> pivotRight;
        pivotRight = pivot.right;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.728 -0400", hash_original_method = "DF035E309292DEA6067E726F513C85C3", hash_generated_method = "5541990C0BDCC254D68C4A2537F73601")
    private void rotateRight(Node<K, V> root) {
        Node<K, V> pivot;
        pivot = root.left;
        Node<K, V> right;
        right = root.right;
        Node<K, V> pivotLeft;
        pivotLeft = pivot.left;
        Node<K, V> pivotRight;
        pivotRight = pivot.right;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.729 -0400", hash_original_method = "E2F61A98BB539F90A11465C6A8354CE5", hash_generated_method = "E5F7B851F2890C6EB639D17694E98067")
    private SimpleImmutableEntry<K, V> immutableCopy(Entry<K, V> entry) {
        SimpleImmutableEntry<K, V> varB4EAC82CA7396A68D541C85D26508E83_212370564 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_212370564 = entry == null ? null : new SimpleImmutableEntry<K, V>(entry);
        addTaint(entry.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_212370564.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_212370564;
        // ---------- Original Method ----------
        //return entry == null ? null : new SimpleImmutableEntry<K, V>(entry);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.729 -0400", hash_original_method = "9F2AE61C584701540103A59451B8FA45", hash_generated_method = "ED4D93D10BD69F2C33130F3912CE4E01")
    public Entry<K, V> firstEntry() {
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1671702217 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1671702217 = immutableCopy(root == null ? null : root.first());
        varB4EAC82CA7396A68D541C85D26508E83_1671702217.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1671702217;
        // ---------- Original Method ----------
        //return immutableCopy(root == null ? null : root.first());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.745 -0400", hash_original_method = "2730A7A2197248AC3B653DF430BA3F4A", hash_generated_method = "525822F193DECFBE5702FECF3B27F95F")
    private Entry<K, V> internalPollFirstEntry() {
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_955693344 = null; //Variable for return #1
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_137296207 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_955693344 = null;
        } //End block
        Node<K, V> result;
        result = root.first();
        removeInternal(result);
        varB4EAC82CA7396A68D541C85D26508E83_137296207 = result;
        Entry<K, V> varA7E53CE21691AB073D9660D615818899_1337808880; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1337808880 = varB4EAC82CA7396A68D541C85D26508E83_955693344;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1337808880 = varB4EAC82CA7396A68D541C85D26508E83_137296207;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1337808880.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1337808880;
        // ---------- Original Method ----------
        //if (root == null) {
            //return null;
        //}
        //Node<K, V> result = root.first();
        //removeInternal(result);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.746 -0400", hash_original_method = "1456A4986DE10120F25B46536C8BF169", hash_generated_method = "EC5B24D79A562E8A682B83DD96A5F8B6")
    public Entry<K, V> pollFirstEntry() {
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_511187923 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_511187923 = immutableCopy(internalPollFirstEntry());
        varB4EAC82CA7396A68D541C85D26508E83_511187923.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_511187923;
        // ---------- Original Method ----------
        //return immutableCopy(internalPollFirstEntry());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.746 -0400", hash_original_method = "B0B89D697E050FAAC6816A6E8B1E56A4", hash_generated_method = "11FBB38BFDB4A971B184A86C204D9B46")
    public K firstKey() {
        K varB4EAC82CA7396A68D541C85D26508E83_890136874 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_890136874 = root.first().getKey();
        varB4EAC82CA7396A68D541C85D26508E83_890136874.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_890136874;
        // ---------- Original Method ----------
        //if (root == null) {
            //throw new NoSuchElementException();
        //}
        //return root.first().getKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.747 -0400", hash_original_method = "9DDE470F0E6425136CCDC59F74FCDED6", hash_generated_method = "6D1EE75C9DBDA400F68A66EC2B205F2F")
    public Entry<K, V> lastEntry() {
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_994959994 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_994959994 = immutableCopy(root == null ? null : root.last());
        varB4EAC82CA7396A68D541C85D26508E83_994959994.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_994959994;
        // ---------- Original Method ----------
        //return immutableCopy(root == null ? null : root.last());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.747 -0400", hash_original_method = "A726E2736A4C282A51BDD8062FE5CCFA", hash_generated_method = "9FB508CA5C9139D26382B0171D9DB9A6")
    private Entry<K, V> internalPollLastEntry() {
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1442652902 = null; //Variable for return #1
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_234725999 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1442652902 = null;
        } //End block
        Node<K, V> result;
        result = root.last();
        removeInternal(result);
        varB4EAC82CA7396A68D541C85D26508E83_234725999 = result;
        Entry<K, V> varA7E53CE21691AB073D9660D615818899_1946068320; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1946068320 = varB4EAC82CA7396A68D541C85D26508E83_1442652902;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1946068320 = varB4EAC82CA7396A68D541C85D26508E83_234725999;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1946068320.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1946068320;
        // ---------- Original Method ----------
        //if (root == null) {
            //return null;
        //}
        //Node<K, V> result = root.last();
        //removeInternal(result);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.750 -0400", hash_original_method = "5064879999AB9A13D0821F605568F112", hash_generated_method = "DABF7F9484DD81ADD986B19A5B645C81")
    public Entry<K, V> pollLastEntry() {
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1980557786 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1980557786 = immutableCopy(internalPollLastEntry());
        varB4EAC82CA7396A68D541C85D26508E83_1980557786.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1980557786;
        // ---------- Original Method ----------
        //return immutableCopy(internalPollLastEntry());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.751 -0400", hash_original_method = "9EE1928205B19C964D03E8011BB7E907", hash_generated_method = "B6412738E1B154C6F70172E71F87B7A6")
    public K lastKey() {
        K varB4EAC82CA7396A68D541C85D26508E83_1434697778 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1434697778 = root.last().getKey();
        varB4EAC82CA7396A68D541C85D26508E83_1434697778.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1434697778;
        // ---------- Original Method ----------
        //if (root == null) {
            //throw new NoSuchElementException();
        //}
        //return root.last().getKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.768 -0400", hash_original_method = "9D71F38DCAD7DBC2AA9FACCDA9CF4866", hash_generated_method = "1A6CB1D34B5533F2BBE80C83FD48ABD6")
    public Entry<K, V> lowerEntry(K key) {
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_394670907 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_394670907 = immutableCopy(find(key, LOWER));
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_394670907.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_394670907;
        // ---------- Original Method ----------
        //return immutableCopy(find(key, LOWER));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.768 -0400", hash_original_method = "BC9464ECC7239B355BB45B80204BADD6", hash_generated_method = "2F47808D9C1FB06A0BC4DA634E7D7B01")
    public K lowerKey(K key) {
        K varB4EAC82CA7396A68D541C85D26508E83_1448789458 = null; //Variable for return #1
        Entry<K, V> entry;
        entry = find(key, LOWER);
        varB4EAC82CA7396A68D541C85D26508E83_1448789458 = entry != null ? entry.getKey() : null;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1448789458.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1448789458;
        // ---------- Original Method ----------
        //Entry<K, V> entry = find(key, LOWER);
        //return entry != null ? entry.getKey() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.768 -0400", hash_original_method = "5D12D4D534218428856149792C7C973A", hash_generated_method = "DF827984723FD53B942F3708E64A94E5")
    public Entry<K, V> floorEntry(K key) {
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_2119051573 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2119051573 = immutableCopy(find(key, FLOOR));
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2119051573.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2119051573;
        // ---------- Original Method ----------
        //return immutableCopy(find(key, FLOOR));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.769 -0400", hash_original_method = "9E3521C1E5D0BB4CA97E65B4B91FC561", hash_generated_method = "7B0A6E3D3B7B5D501F4976D1737D25F2")
    public K floorKey(K key) {
        K varB4EAC82CA7396A68D541C85D26508E83_1669863419 = null; //Variable for return #1
        Entry<K, V> entry;
        entry = find(key, FLOOR);
        varB4EAC82CA7396A68D541C85D26508E83_1669863419 = entry != null ? entry.getKey() : null;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1669863419.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1669863419;
        // ---------- Original Method ----------
        //Entry<K, V> entry = find(key, FLOOR);
        //return entry != null ? entry.getKey() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.769 -0400", hash_original_method = "14BBCA12BBBC651385215255CDF3836D", hash_generated_method = "A7896893B40FB22C21F3AA9183502467")
    public Entry<K, V> ceilingEntry(K key) {
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1372064562 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1372064562 = immutableCopy(find(key, CEILING));
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1372064562.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1372064562;
        // ---------- Original Method ----------
        //return immutableCopy(find(key, CEILING));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.770 -0400", hash_original_method = "818E984E93F7F07D0C27D2493F11C2A5", hash_generated_method = "525805C6E5BBA52034B05C7F33BD9118")
    public K ceilingKey(K key) {
        K varB4EAC82CA7396A68D541C85D26508E83_671902948 = null; //Variable for return #1
        Entry<K, V> entry;
        entry = find(key, CEILING);
        varB4EAC82CA7396A68D541C85D26508E83_671902948 = entry != null ? entry.getKey() : null;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_671902948.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_671902948;
        // ---------- Original Method ----------
        //Entry<K, V> entry = find(key, CEILING);
        //return entry != null ? entry.getKey() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.771 -0400", hash_original_method = "AC2414FDDF42A1318F8CC45C80E09BC1", hash_generated_method = "A944751255E101D7714435210120DB9B")
    public Entry<K, V> higherEntry(K key) {
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_322639723 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_322639723 = immutableCopy(find(key, HIGHER));
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_322639723.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_322639723;
        // ---------- Original Method ----------
        //return immutableCopy(find(key, HIGHER));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.771 -0400", hash_original_method = "0C080E769BA3B62EBC93442ECCB0FC7D", hash_generated_method = "E0C95A55706CDF6D38EFED9AE88A92FB")
    public K higherKey(K key) {
        K varB4EAC82CA7396A68D541C85D26508E83_531283791 = null; //Variable for return #1
        Entry<K, V> entry;
        entry = find(key, HIGHER);
        varB4EAC82CA7396A68D541C85D26508E83_531283791 = entry != null ? entry.getKey() : null;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_531283791.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_531283791;
        // ---------- Original Method ----------
        //Entry<K, V> entry = find(key, HIGHER);
        //return entry != null ? entry.getKey() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.791 -0400", hash_original_method = "6A8618E17145F23513711DA8498038AE", hash_generated_method = "3413E99225AC3DB730B6DB4C66312C58")
    public Comparator<? super K> comparator() {
        Comparator<? super K> varB4EAC82CA7396A68D541C85D26508E83_591112504 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_591112504 = comparator != NATURAL_ORDER ? comparator : null;
        varB4EAC82CA7396A68D541C85D26508E83_591112504.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_591112504;
        // ---------- Original Method ----------
        //return comparator != NATURAL_ORDER ? comparator : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.792 -0400", hash_original_method = "D2C4C51D99D6D10356C2F96D116110D2", hash_generated_method = "BDE375973A7225DFF67EAA494056F653")
    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_1242318477 = null; //Variable for return #1
        EntrySet result;
        result = entrySet;
        varB4EAC82CA7396A68D541C85D26508E83_1242318477 = result != null ? result : (entrySet = new EntrySet());
        varB4EAC82CA7396A68D541C85D26508E83_1242318477.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1242318477;
        // ---------- Original Method ----------
        //EntrySet result = entrySet;
        //return result != null ? result : (entrySet = new EntrySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.792 -0400", hash_original_method = "0E17D4043440FAA66222611D1AC45111", hash_generated_method = "10B344D2489EDDDDFB8E902B63491ECB")
    @Override
    public Set<K> keySet() {
        Set<K> varB4EAC82CA7396A68D541C85D26508E83_303344521 = null; //Variable for return #1
        KeySet result;
        result = keySet;
        varB4EAC82CA7396A68D541C85D26508E83_303344521 = result != null ? result : (keySet = new KeySet());
        varB4EAC82CA7396A68D541C85D26508E83_303344521.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_303344521;
        // ---------- Original Method ----------
        //KeySet result = keySet;
        //return result != null ? result : (keySet = new KeySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.793 -0400", hash_original_method = "016115EA38C293C7AAA8E892AEA754CA", hash_generated_method = "AF66EE85B4A25454B2DB73271D6A73BE")
    public NavigableSet<K> navigableKeySet() {
        NavigableSet<K> varB4EAC82CA7396A68D541C85D26508E83_2025378878 = null; //Variable for return #1
        KeySet result;
        result = keySet;
        varB4EAC82CA7396A68D541C85D26508E83_2025378878 = result != null ? result : (keySet = new KeySet());
        varB4EAC82CA7396A68D541C85D26508E83_2025378878.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2025378878;
        // ---------- Original Method ----------
        //KeySet result = keySet;
        //return result != null ? result : (keySet = new KeySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.801 -0400", hash_original_method = "DA6DE2093EE8DE46EE4576501F54E528", hash_generated_method = "F966EF932AD729BE2CBFC0F53B02CF42")
    public NavigableMap<K, V> subMap(K from, boolean fromInclusive, K to, boolean toInclusive) {
        NavigableMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_88996206 = null; //Variable for return #1
        Bound fromBound;
        fromBound = INCLUSIVE;
        fromBound = EXCLUSIVE;
        Bound toBound;
        toBound = INCLUSIVE;
        toBound = EXCLUSIVE;
        varB4EAC82CA7396A68D541C85D26508E83_88996206 = new BoundedMap(true, from, fromBound, to, toBound);
        addTaint(from.getTaint());
        addTaint(fromInclusive);
        addTaint(to.getTaint());
        addTaint(toInclusive);
        varB4EAC82CA7396A68D541C85D26508E83_88996206.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_88996206;
        // ---------- Original Method ----------
        //Bound fromBound = fromInclusive ? INCLUSIVE : EXCLUSIVE;
        //Bound toBound = toInclusive ? INCLUSIVE : EXCLUSIVE;
        //return new BoundedMap(true, from, fromBound, to, toBound);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.802 -0400", hash_original_method = "193BA03007E91EBBDB489C20B60BFC88", hash_generated_method = "A8A4207F99346C4C5491BEE6F2E2128B")
    public SortedMap<K, V> subMap(K fromInclusive, K toExclusive) {
        SortedMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_597717441 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_597717441 = new BoundedMap(true, fromInclusive, INCLUSIVE, toExclusive, EXCLUSIVE);
        addTaint(fromInclusive.getTaint());
        addTaint(toExclusive.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_597717441.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_597717441;
        // ---------- Original Method ----------
        //return new BoundedMap(true, fromInclusive, INCLUSIVE, toExclusive, EXCLUSIVE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.802 -0400", hash_original_method = "FA312E74B0C04D741489E3323E0FFDFE", hash_generated_method = "8540B3D24FEA8287F49AEA26DCBA535C")
    public NavigableMap<K, V> headMap(K to, boolean inclusive) {
        NavigableMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_1358732408 = null; //Variable for return #1
        Bound toBound;
        toBound = INCLUSIVE;
        toBound = EXCLUSIVE;
        varB4EAC82CA7396A68D541C85D26508E83_1358732408 = new BoundedMap(true, null, NO_BOUND, to, toBound);
        addTaint(to.getTaint());
        addTaint(inclusive);
        varB4EAC82CA7396A68D541C85D26508E83_1358732408.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1358732408;
        // ---------- Original Method ----------
        //Bound toBound = inclusive ? INCLUSIVE : EXCLUSIVE;
        //return new BoundedMap(true, null, NO_BOUND, to, toBound);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.803 -0400", hash_original_method = "CAC178CA3C39A0AC08FB27C63F9A635C", hash_generated_method = "29645DD1046603C8C69EF137F71E046B")
    public SortedMap<K, V> headMap(K toExclusive) {
        SortedMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_15000699 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_15000699 = new BoundedMap(true, null, NO_BOUND, toExclusive, EXCLUSIVE);
        addTaint(toExclusive.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_15000699.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_15000699;
        // ---------- Original Method ----------
        //return new BoundedMap(true, null, NO_BOUND, toExclusive, EXCLUSIVE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.813 -0400", hash_original_method = "828BC950C20B857C189141DA99499F09", hash_generated_method = "7A914F00D13B2E43B7934911F5684856")
    public NavigableMap<K, V> tailMap(K from, boolean inclusive) {
        NavigableMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_1808718578 = null; //Variable for return #1
        Bound fromBound;
        fromBound = INCLUSIVE;
        fromBound = EXCLUSIVE;
        varB4EAC82CA7396A68D541C85D26508E83_1808718578 = new BoundedMap(true, from, fromBound, null, NO_BOUND);
        addTaint(from.getTaint());
        addTaint(inclusive);
        varB4EAC82CA7396A68D541C85D26508E83_1808718578.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1808718578;
        // ---------- Original Method ----------
        //Bound fromBound = inclusive ? INCLUSIVE : EXCLUSIVE;
        //return new BoundedMap(true, from, fromBound, null, NO_BOUND);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.813 -0400", hash_original_method = "79B47D2E0956F27B23E0B18E5FD19D6A", hash_generated_method = "F55797B9A64C80B5A327FF40651D73F9")
    public SortedMap<K, V> tailMap(K fromInclusive) {
        SortedMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_211970892 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_211970892 = new BoundedMap(true, fromInclusive, INCLUSIVE, null, NO_BOUND);
        addTaint(fromInclusive.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_211970892.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_211970892;
        // ---------- Original Method ----------
        //return new BoundedMap(true, fromInclusive, INCLUSIVE, null, NO_BOUND);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.814 -0400", hash_original_method = "5AD6A5A37D3C9366BEF11B75DC396D31", hash_generated_method = "9FA8874346CBEEA036EF23E64B3B2A46")
    public NavigableMap<K, V> descendingMap() {
        NavigableMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_598761201 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_598761201 = new BoundedMap(false, null, NO_BOUND, null, NO_BOUND);
        varB4EAC82CA7396A68D541C85D26508E83_598761201.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_598761201;
        // ---------- Original Method ----------
        //return new BoundedMap(false, null, NO_BOUND, null, NO_BOUND);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.814 -0400", hash_original_method = "1207DF79B9959BCB242E95030D6177B0", hash_generated_method = "F11484A1BC52D842E37BAF219E7C6932")
    public NavigableSet<K> descendingKeySet() {
        NavigableSet<K> varB4EAC82CA7396A68D541C85D26508E83_954711323 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_954711323 = new BoundedMap(false, null, NO_BOUND, null, NO_BOUND).navigableKeySet();
        varB4EAC82CA7396A68D541C85D26508E83_954711323.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_954711323;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.886 -0400", hash_original_method = "BF81D129CE69F9BEB40CAD27F974F3C8", hash_generated_method = "E86AD7446DCE3CF2DB0BD1C665387D4E")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.putFields().put("comparator", comparator != NATURAL_ORDER ? comparator : null);
        stream.writeFields();
        stream.writeInt(size);
        {
            Iterator<Map.Entry<K, V>> var40A6EBFD1C8AB95DF2D9F4B462803CBE_1739970778 = (entrySet()).iterator();
            var40A6EBFD1C8AB95DF2D9F4B462803CBE_1739970778.hasNext();
            Map.Entry<K, V> entry = var40A6EBFD1C8AB95DF2D9F4B462803CBE_1739970778.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.903 -0400", hash_original_method = "4DE82E48A11AFCCB2DCFEAE704B1F475", hash_generated_method = "A6862155C8797DD5C5DCDADAA69B5495")
    @SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        GetField fields;
        fields = stream.readFields();
        comparator = (Comparator<? super K>) fields.get("comparator", null);
        {
            comparator = (Comparator<? super K>) NATURAL_ORDER;
        } //End block
        int size;
        size = stream.readInt();
        {
            int i;
            i = 0;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.903 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "8813BD57943FF9B7DFC4722D0BF25C24")

        Node<K, V> parent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.903 -0400", hash_original_field = "811882FECD5C7618D7099EBBD39EA254", hash_generated_field = "25F53C0BDEE77B7CD3BD6D035AA5E15F")

        Node<K, V> left;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.903 -0400", hash_original_field = "7C4F29407893C334A6CB7A87BF045C0D", hash_generated_field = "37DD2CA6D859801A463F8F880FD4F30D")

        Node<K, V> right;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.903 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "F780C5984CF24E477CB9559E91475987")

        K key;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.903 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "A7E8A049E4C72FD5713D3AFD6CBF7C08")

        V value;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.903 -0400", hash_original_field = "B435E227D5DD201E1768B2BCB2E0AA81", hash_generated_field = "CE84F1587D182C1F0A32D7CD44443A18")

        int height;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.904 -0400", hash_original_method = "62891C3DA898C4CAE2A216E3248BC6D0", hash_generated_method = "DE342B9B0B30391F4646033D3553010C")
          Node(Node<K, V> parent, K key) {
            this.parent = parent;
            this.key = key;
            this.height = 1;
            // ---------- Original Method ----------
            //this.parent = parent;
            //this.key = key;
            //this.height = 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.904 -0400", hash_original_method = "81E3C4E28B5839A0B87A03CA341E9BD1", hash_generated_method = "2F80702C7C66B62DF89261249969ADEC")
         Node<K, V> copy(Node<K, V> parent) {
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1618706304 = null; //Variable for return #1
            Node<K, V> result;
            result = new Node<K, V>(parent, key);
            {
                result.left = left.copy(result);
            } //End block
            {
                result.right = right.copy(result);
            } //End block
            result.value = value;
            result.height = height;
            varB4EAC82CA7396A68D541C85D26508E83_1618706304 = result;
            addTaint(parent.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1618706304.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1618706304;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.908 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "5E98EF2A6F95647D1E4EE52C81B893F8")
        public K getKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_1979907694 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1979907694 = key;
            varB4EAC82CA7396A68D541C85D26508E83_1979907694.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1979907694;
            // ---------- Original Method ----------
            //return key;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.909 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "B8142D281574B653B164DDE1795AC73C")
        public V getValue() {
            V varB4EAC82CA7396A68D541C85D26508E83_1779835355 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1779835355 = value;
            varB4EAC82CA7396A68D541C85D26508E83_1779835355.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1779835355;
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.909 -0400", hash_original_method = "B73895AEE255DB24C138E57D2456050E", hash_generated_method = "154E0B3E8F25404E03351837B8FBF6C6")
        public V setValue(V value) {
            V varB4EAC82CA7396A68D541C85D26508E83_99625316 = null; //Variable for return #1
            V oldValue;
            oldValue = this.value;
            this.value = value;
            varB4EAC82CA7396A68D541C85D26508E83_99625316 = oldValue;
            varB4EAC82CA7396A68D541C85D26508E83_99625316.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_99625316;
            // ---------- Original Method ----------
            //V oldValue = this.value;
            //this.value = value;
            //return oldValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.915 -0400", hash_original_method = "08E0671CAB8873A0A05165CE64371DB8", hash_generated_method = "C1577FCF4DE6A613791D2DA07F3DC328")
        @Override
        public boolean equals(Object o) {
            {
                Map.Entry other;
                other = (Map.Entry) o;
                boolean var7912CC5897005EB768B2514BECBB8DA1_878754408 = ((key == null ? other.getKey() == null : key.equals(other.getKey()))
                        && (value == null ? other.getValue() == null : value.equals(other.getValue()))); //DSFIXME:  CODE0008: Nested ternary operator in expression
            } //End block
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_164041463 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_164041463;
            // ---------- Original Method ----------
            //if (o instanceof Map.Entry) {
                //Map.Entry other = (Map.Entry) o;
                //return (key == null ? other.getKey() == null : key.equals(other.getKey()))
                        //&& (value == null ? other.getValue() == null : value.equals(other.getValue()));
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.915 -0400", hash_original_method = "6416487D313DFCFD3052C01ADB883217", hash_generated_method = "D32AF74039994949A9A4F11D9A79F9AD")
        @Override
        public int hashCode() {
            int var4B5981580A705D92ADA4BF72B6E1E3C5_604219966 = ((key == null ? 0 : key.hashCode())
                    ^ (value == null ? 0 : value.hashCode())); //DSFIXME:  CODE0008: Nested ternary operator in expression
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_281344958 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_281344958;
            // ---------- Original Method ----------
            //return (key == null ? 0 : key.hashCode())
                    //^ (value == null ? 0 : value.hashCode());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.916 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "0338CC044B1098143DEEA6EA47FEE1D1")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1137755207 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1137755207 = key + "=" + value;
            varB4EAC82CA7396A68D541C85D26508E83_1137755207.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1137755207;
            // ---------- Original Method ----------
            //return key + "=" + value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.924 -0400", hash_original_method = "4A8921E3C940E88A3EF0004D6F064697", hash_generated_method = "8505F1456210B91583A8AFC610CF8956")
         Node<K, V> next() {
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_522841869 = null; //Variable for return #1
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_6917531 = null; //Variable for return #2
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_889067361 = null; //Variable for return #3
            {
                varB4EAC82CA7396A68D541C85D26508E83_522841869 = right.first();
            } //End block
            Node<K, V> node;
            node = this;
            Node<K, V> parent;
            parent = node.parent;
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_6917531 = parent;
                } //End block
                node = parent;
                parent = node.parent;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_889067361 = null;
            Node<K, V> varA7E53CE21691AB073D9660D615818899_80620875; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_80620875 = varB4EAC82CA7396A68D541C85D26508E83_522841869;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_80620875 = varB4EAC82CA7396A68D541C85D26508E83_6917531;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_80620875 = varB4EAC82CA7396A68D541C85D26508E83_889067361;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_80620875.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_80620875;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.925 -0400", hash_original_method = "A5795D04699EE4D7981584600E0900FB", hash_generated_method = "C010BDBFB51D10928266B4194FFB1BF8")
        public Node<K, V> prev() {
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1810114955 = null; //Variable for return #1
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_2014886004 = null; //Variable for return #2
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_85435582 = null; //Variable for return #3
            {
                varB4EAC82CA7396A68D541C85D26508E83_1810114955 = left.last();
            } //End block
            Node<K, V> node;
            node = this;
            Node<K, V> parent;
            parent = node.parent;
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_2014886004 = parent;
                } //End block
                node = parent;
                parent = node.parent;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_85435582 = null;
            Node<K, V> varA7E53CE21691AB073D9660D615818899_1518073286; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1518073286 = varB4EAC82CA7396A68D541C85D26508E83_1810114955;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_1518073286 = varB4EAC82CA7396A68D541C85D26508E83_2014886004;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1518073286 = varB4EAC82CA7396A68D541C85D26508E83_85435582;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1518073286.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1518073286;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.925 -0400", hash_original_method = "4F7C0267C30B98E081694FF304478F8A", hash_generated_method = "DA0D3E627BEA31016EF80D542F520730")
        public Node<K, V> first() {
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1168120372 = null; //Variable for return #1
            Node<K, V> node;
            node = this;
            Node<K, V> child;
            child = node.left;
            {
                node = child;
                child = node.left;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1168120372 = node;
            varB4EAC82CA7396A68D541C85D26508E83_1168120372.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1168120372;
            // ---------- Original Method ----------
            //Node<K, V> node = this;
            //Node<K, V> child = node.left;
            //while (child != null) {
                //node = child;
                //child = node.left;
            //}
            //return node;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.926 -0400", hash_original_method = "E5BF79B4B513B5631F4BBC9604CA3FC9", hash_generated_method = "022331A06062BCDD16D5DCF9E3936B72")
        public Node<K, V> last() {
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1634148176 = null; //Variable for return #1
            Node<K, V> node;
            node = this;
            Node<K, V> child;
            child = node.right;
            {
                node = child;
                child = node.right;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1634148176 = node;
            varB4EAC82CA7396A68D541C85D26508E83_1634148176.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1634148176;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.068 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "4E383A6783C389E295874CEC0140061D")

        protected Node<K, V> next;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.068 -0400", hash_original_field = "98BD1C45684CF587AC2347A92DD7BB51", hash_generated_field = "A9411E67538F8DD40B9344B2A6DD22CB")

        protected Node<K, V> last;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.068 -0400", hash_original_field = "587E194BCD330DA9D6CB9DB53EA8709A", hash_generated_field = "AB0DDF01BBCC99511DA5FB1867F9AF26")

        protected int expectedModCount = modCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.077 -0400", hash_original_method = "1934503C2038D80E73C2C0A3DE09B0C3", hash_generated_method = "8E0327A33AFF8D45EE12C60F2FAE7675")
          MapIterator(Node<K, V> next) {
            this.next = next;
            // ---------- Original Method ----------
            //this.next = next;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.077 -0400", hash_original_method = "5C1B7B0DA20667590A4D5C5559468A28", hash_generated_method = "055AE16187B6EAAFFAF7AC273E9EF579")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_347954498 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_347954498;
            // ---------- Original Method ----------
            //return next != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.078 -0400", hash_original_method = "85C80BB4AD318538DB8131E722149B15", hash_generated_method = "64B3D1547FCB085F56DA19D5ADF68555")
        protected Node<K, V> stepForward() {
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1940382899 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            } //End block
            last = next;
            next = next.next();
            varB4EAC82CA7396A68D541C85D26508E83_1940382899 = last;
            varB4EAC82CA7396A68D541C85D26508E83_1940382899.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1940382899;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.079 -0400", hash_original_method = "A54C5D61E9DBD724A09A36F78C304124", hash_generated_method = "9E50FC8FAB61EA8928322ABC5F6CC044")
        protected Node<K, V> stepBackward() {
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1111874426 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            } //End block
            last = next;
            next = next.prev();
            varB4EAC82CA7396A68D541C85D26508E83_1111874426 = last;
            varB4EAC82CA7396A68D541C85D26508E83_1111874426.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1111874426;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.089 -0400", hash_original_method = "36CB2F7F3A40368DEE67850156136E6A", hash_generated_method = "68E79A243AD9DF221A3356BB1D7AE83F")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.089 -0400", hash_original_method = "AA90B2AD56C6E037D76F6D8ACC9327A5", hash_generated_method = "AA90B2AD56C6E037D76F6D8ACC9327A5")
        public EntrySet ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.090 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "9086155D32835AF4540795AA0A79F330")
        @Override
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1090815922 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1090815922;
            // ---------- Original Method ----------
            //return size;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.090 -0400", hash_original_method = "B4D4FA13F54A295418FF58C47A14DDE9", hash_generated_method = "61B0E12AACAD36FE6324D7117D0DADB1")
        @Override
        public Iterator<Entry<K, V>> iterator() {
            Iterator<Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_298642818 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_298642818 = new MapIterator<Entry<K, V>>(root == null ? null : root.first()) {
                public Entry<K, V> next() {
                    return stepForward();
                }
            };
            varB4EAC82CA7396A68D541C85D26508E83_298642818.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_298642818;
            // ---------- Original Method ----------
            //return new MapIterator<Entry<K, V>>(root == null ? null : root.first()) {
                //public Entry<K, V> next() {
                    //return stepForward();
                //}
            //};
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.091 -0400", hash_original_method = "AAE5A29808B951CC80BD03F648B6A63A", hash_generated_method = "BFA43A2B10C10BDB9D37C656AABC7074")
        @Override
        public boolean contains(Object o) {
            boolean var12117A785F30278636E2FCE711DC72F4_1824377123 = (o instanceof Entry && findByEntry((Entry<?, ?>) o) != null);
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_274402917 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_274402917;
            // ---------- Original Method ----------
            //return o instanceof Entry && findByEntry((Entry<?, ?>) o) != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.091 -0400", hash_original_method = "50402191313F22EA9CF206F14CC9A5A4", hash_generated_method = "878975F3AD75B8EC1D42A1CD14C11FAA")
        @Override
        public boolean remove(Object o) {
            Node<K, V> node;
            node = findByEntry((Entry<?, ?>) o);
            removeInternal(node);
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1457771890 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1457771890;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.091 -0400", hash_original_method = "1CC2A082C181027407DFF573950B6D85", hash_generated_method = "E132377B1C3D8FD49066BD79A34C72A8")
        @Override
        public void clear() {
            TreeMap.this.clear();
            // ---------- Original Method ----------
            //TreeMap.this.clear();
        }

        
    }


    
    class KeySet extends AbstractSet<K> implements NavigableSet<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.092 -0400", hash_original_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF", hash_generated_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF")
        public KeySet ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.092 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "A2C962C5579A88C14BE6BF9D43E43C0E")
        @Override
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1991105793 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1991105793;
            // ---------- Original Method ----------
            //return size;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.092 -0400", hash_original_method = "7A518595D7BAAD9E696AF11FE92FFDBE", hash_generated_method = "CE3874AD784BFA74DBC2C2A59B085A3B")
        @Override
        public Iterator<K> iterator() {
            Iterator<K> varB4EAC82CA7396A68D541C85D26508E83_1813432017 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1813432017 = new MapIterator<K>(root == null ? null : root.first()) {
                public K next() {
                    return stepForward().key;
                }
            };
            varB4EAC82CA7396A68D541C85D26508E83_1813432017.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1813432017;
            // ---------- Original Method ----------
            //return new MapIterator<K>(root == null ? null : root.first()) {
                //public K next() {
                    //return stepForward().key;
                //}
            //};
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.093 -0400", hash_original_method = "C8D968F3C5FE84BB3D2A53544A3D4B19", hash_generated_method = "BB544B3DD7D748E32FB998783E9D8907")
        public Iterator<K> descendingIterator() {
            Iterator<K> varB4EAC82CA7396A68D541C85D26508E83_21288845 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_21288845 = new MapIterator<K>(root == null ? null : root.last()) {
                public K next() {
                    return stepBackward().key;
                }
            };
            varB4EAC82CA7396A68D541C85D26508E83_21288845.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_21288845;
            // ---------- Original Method ----------
            //return new MapIterator<K>(root == null ? null : root.last()) {
                //public K next() {
                    //return stepBackward().key;
                //}
            //};
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.093 -0400", hash_original_method = "55474555B71DFC8666AC2B6E4F0261A5", hash_generated_method = "501A0279939263EABE7AD1D01DA94615")
        @Override
        public boolean contains(Object o) {
            boolean var997BAB39B2F072D5CD66A271F3B6E196_1680608274 = (containsKey(o));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1260984822 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1260984822;
            // ---------- Original Method ----------
            //return containsKey(o);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.102 -0400", hash_original_method = "174345B10BAB0003712B28F94B9BEA53", hash_generated_method = "D4F75EA39D16647B4C644CB58B98770C")
        @Override
        public boolean remove(Object key) {
            boolean varE16D747D3226990FB8F8723539274182_1557600929 = (removeInternalByKey(key) != null);
            addTaint(key.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1518298150 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1518298150;
            // ---------- Original Method ----------
            //return removeInternalByKey(key) != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.102 -0400", hash_original_method = "1CC2A082C181027407DFF573950B6D85", hash_generated_method = "E132377B1C3D8FD49066BD79A34C72A8")
        @Override
        public void clear() {
            TreeMap.this.clear();
            // ---------- Original Method ----------
            //TreeMap.this.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.103 -0400", hash_original_method = "E1A1305471DEE1FE749764F6E03BE3A0", hash_generated_method = "99C1FE9C42ECA67AE115DA300A3775B2")
        public Comparator<? super K> comparator() {
            Comparator<? super K> varB4EAC82CA7396A68D541C85D26508E83_1895977752 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1895977752 = TreeMap.this.comparator();
            varB4EAC82CA7396A68D541C85D26508E83_1895977752.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1895977752;
            // ---------- Original Method ----------
            //return TreeMap.this.comparator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.103 -0400", hash_original_method = "3067DEE01FBBBFD061436C7D4561F434", hash_generated_method = "3286928108FC9B6A4C1F5ED9C1350E20")
        public K first() {
            K varB4EAC82CA7396A68D541C85D26508E83_1053428809 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1053428809 = firstKey();
            varB4EAC82CA7396A68D541C85D26508E83_1053428809.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1053428809;
            // ---------- Original Method ----------
            //return firstKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.124 -0400", hash_original_method = "39C87F788E647BCD3FB86FFF34D7EF10", hash_generated_method = "77A92AD3554E824E86F1D6FCBDDBCD9F")
        public K last() {
            K varB4EAC82CA7396A68D541C85D26508E83_1965781838 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1965781838 = lastKey();
            varB4EAC82CA7396A68D541C85D26508E83_1965781838.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1965781838;
            // ---------- Original Method ----------
            //return lastKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.125 -0400", hash_original_method = "5CFE05BF706A06BBB501067306F1B9ED", hash_generated_method = "DF8B8A01314FBCE2FED60F55CA4C6D62")
        public K lower(K key) {
            K varB4EAC82CA7396A68D541C85D26508E83_1627346806 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1627346806 = lowerKey(key);
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1627346806.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1627346806;
            // ---------- Original Method ----------
            //return lowerKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.126 -0400", hash_original_method = "10BABB7BB2E837824A13AAE89EE7EC6F", hash_generated_method = "7F4FF7AA804E7D863C5CB30F47463049")
        public K floor(K key) {
            K varB4EAC82CA7396A68D541C85D26508E83_1101677075 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1101677075 = floorKey(key);
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1101677075.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1101677075;
            // ---------- Original Method ----------
            //return floorKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.126 -0400", hash_original_method = "2AD4706A6D818B709A1E2CA64B48B4B9", hash_generated_method = "9C2C3FA8C4AA3B820BAD1234A44719F7")
        public K ceiling(K key) {
            K varB4EAC82CA7396A68D541C85D26508E83_957835104 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_957835104 = ceilingKey(key);
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_957835104.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_957835104;
            // ---------- Original Method ----------
            //return ceilingKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.127 -0400", hash_original_method = "8CC63649234BFC57DB10A2387AE34DD6", hash_generated_method = "543F672AACB287A25C72417A496EC2E9")
        public K higher(K key) {
            K varB4EAC82CA7396A68D541C85D26508E83_159079737 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_159079737 = higherKey(key);
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_159079737.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_159079737;
            // ---------- Original Method ----------
            //return higherKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.127 -0400", hash_original_method = "0E3C9584B722234668005FBA598A1EC0", hash_generated_method = "4B0DCE5D6B5F8CC6FDFAA58D1057CDBB")
        public K pollFirst() {
            K varB4EAC82CA7396A68D541C85D26508E83_95757385 = null; //Variable for return #1
            Entry<K, V> entry;
            entry = internalPollFirstEntry();
            varB4EAC82CA7396A68D541C85D26508E83_95757385 = entry != null ? entry.getKey() : null;
            varB4EAC82CA7396A68D541C85D26508E83_95757385.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_95757385;
            // ---------- Original Method ----------
            //Entry<K, V> entry = internalPollFirstEntry();
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.128 -0400", hash_original_method = "ABD0A1CFCFA4D3D1F242F2375F97811C", hash_generated_method = "035036624D398264CDE7EE2352E22133")
        public K pollLast() {
            K varB4EAC82CA7396A68D541C85D26508E83_1961831824 = null; //Variable for return #1
            Entry<K, V> entry;
            entry = internalPollLastEntry();
            varB4EAC82CA7396A68D541C85D26508E83_1961831824 = entry != null ? entry.getKey() : null;
            varB4EAC82CA7396A68D541C85D26508E83_1961831824.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1961831824;
            // ---------- Original Method ----------
            //Entry<K, V> entry = internalPollLastEntry();
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.129 -0400", hash_original_method = "21828DA90728B75367EF3BEE7D62C832", hash_generated_method = "CD50E1541E810F330D4EB982F84BDA68")
        public NavigableSet<K> subSet(K from, boolean fromInclusive, K to, boolean toInclusive) {
            NavigableSet<K> varB4EAC82CA7396A68D541C85D26508E83_1688008447 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1688008447 = TreeMap.this.subMap(from, fromInclusive, to, toInclusive).navigableKeySet();
            addTaint(from.getTaint());
            addTaint(fromInclusive);
            addTaint(to.getTaint());
            addTaint(toInclusive);
            varB4EAC82CA7396A68D541C85D26508E83_1688008447.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1688008447;
            // ---------- Original Method ----------
            //return TreeMap.this.subMap(from, fromInclusive, to, toInclusive).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.146 -0400", hash_original_method = "B37C6130D4B0113815E317EEB111D1E9", hash_generated_method = "26A55A0A9F0639F63834C981676FC12B")
        public SortedSet<K> subSet(K fromInclusive, K toExclusive) {
            SortedSet<K> varB4EAC82CA7396A68D541C85D26508E83_1547787608 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1547787608 = TreeMap.this.subMap(fromInclusive, true, toExclusive, false).navigableKeySet();
            addTaint(fromInclusive.getTaint());
            addTaint(toExclusive.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1547787608.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1547787608;
            // ---------- Original Method ----------
            //return TreeMap.this.subMap(fromInclusive, true, toExclusive, false).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.159 -0400", hash_original_method = "15C518A93EE21ED6E81237BD492369B4", hash_generated_method = "FC84CA9F5A288C8106A9B5435379B2C7")
        public NavigableSet<K> headSet(K to, boolean inclusive) {
            NavigableSet<K> varB4EAC82CA7396A68D541C85D26508E83_1241410210 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1241410210 = TreeMap.this.headMap(to, inclusive).navigableKeySet();
            addTaint(to.getTaint());
            addTaint(inclusive);
            varB4EAC82CA7396A68D541C85D26508E83_1241410210.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1241410210;
            // ---------- Original Method ----------
            //return TreeMap.this.headMap(to, inclusive).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.159 -0400", hash_original_method = "1E1BD4D122D1F75D80BDC2474EF32137", hash_generated_method = "020BC20DB720E9B47CC6268B6A3AACFB")
        public SortedSet<K> headSet(K toExclusive) {
            SortedSet<K> varB4EAC82CA7396A68D541C85D26508E83_1017150456 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1017150456 = TreeMap.this.headMap(toExclusive, false).navigableKeySet();
            addTaint(toExclusive.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1017150456.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1017150456;
            // ---------- Original Method ----------
            //return TreeMap.this.headMap(toExclusive, false).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.160 -0400", hash_original_method = "3007AE414049BD587DD344AEC05F7630", hash_generated_method = "5AB25E032F9762A2EC055B9EBB8113D9")
        public NavigableSet<K> tailSet(K from, boolean inclusive) {
            NavigableSet<K> varB4EAC82CA7396A68D541C85D26508E83_1721333773 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1721333773 = TreeMap.this.tailMap(from, inclusive).navigableKeySet();
            addTaint(from.getTaint());
            addTaint(inclusive);
            varB4EAC82CA7396A68D541C85D26508E83_1721333773.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1721333773;
            // ---------- Original Method ----------
            //return TreeMap.this.tailMap(from, inclusive).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.171 -0400", hash_original_method = "4DA58A152F26E7271643C0314BDDDB69", hash_generated_method = "588F5C450B4F914682A10486EA5C4C34")
        public SortedSet<K> tailSet(K fromInclusive) {
            SortedSet<K> varB4EAC82CA7396A68D541C85D26508E83_574169602 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_574169602 = TreeMap.this.tailMap(fromInclusive, true).navigableKeySet();
            addTaint(fromInclusive.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_574169602.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_574169602;
            // ---------- Original Method ----------
            //return TreeMap.this.tailMap(fromInclusive, true).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.172 -0400", hash_original_method = "1704B63D396CC7A2877008D7CE821A20", hash_generated_method = "F729CD4136882249E42C94B0E0B13619")
        public NavigableSet<K> descendingSet() {
            NavigableSet<K> varB4EAC82CA7396A68D541C85D26508E83_867615323 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_867615323 = new BoundedMap(false, null, NO_BOUND, null, NO_BOUND).navigableKeySet();
            varB4EAC82CA7396A68D541C85D26508E83_867615323.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_867615323;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.172 -0400", hash_original_field = "9C9AB624360885FCF93B7643C93B6748", hash_generated_field = "BC70714ECDFF7490EBA777F7B93EF439")

        private transient boolean ascending;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.172 -0400", hash_original_field = "D98A07F84921B24EE30F86FD8CD85C3C", hash_generated_field = "EEAE90D76D5F301C983CBE52CC99E066")

        private transient K from;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.172 -0400", hash_original_field = "8632C30284D52AAEE2237CDB621740BD", hash_generated_field = "8ED035FAE673A429CD23C9E2219BCCAB")

        private transient Bound fromBound;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.172 -0400", hash_original_field = "01B6E20344B68835C5ED1DDEDF20D531", hash_generated_field = "61687A1A941C5D04AF6012AAB46409E8")

        private transient K to;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.172 -0400", hash_original_field = "7CA17358064D231F30EBE9DEA6953FC3", hash_generated_field = "AA1B7E444C65D0CB4426137E2FCF44C2")

        private transient Bound toBound;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.172 -0400", hash_original_field = "D4E06C98DBA5A687CB6C836BF538EC81", hash_generated_field = "71A92C43EAA002A1D21DF22BACB230F5")

        private transient BoundedEntrySet entrySet;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.172 -0400", hash_original_field = "3E8ABCE844B6A8A95397486A3899B536", hash_generated_field = "8C5699591CBD5CFF428C3B6D5369D846")

        private transient BoundedKeySet keySet;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.173 -0400", hash_original_method = "EAF770A918D33B7B0B98CAAC01791FDE", hash_generated_method = "BAE0B1222029EFE82B9E5817FEE92F48")
          BoundedMap(boolean ascending, K from, Bound fromBound, K to, Bound toBound) {
            {
                {
                    boolean varDF5DEF900BBEA61318C4B860BE963A0C_1419166125 = (comparator.compare(from, to) > 0);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.178 -0400", hash_original_method = "0165FF9BE82C19127CA9F7A8EFBCC5F6", hash_generated_method = "3DABFD52DA08D0076DA85B654EC41A90")
        @Override
        public int size() {
            int varFAAE4FEB39919E901926F6E4652B275E_1265910204 = (count(entrySet().iterator()));
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_539964027 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_539964027;
            // ---------- Original Method ----------
            //return count(entrySet().iterator());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.179 -0400", hash_original_method = "25ACC65054E604EE8ADED763702CFAA7", hash_generated_method = "FF91BBDED0F8BCE8CBFD42681DD6C69E")
        @Override
        public boolean isEmpty() {
            boolean var19B0E21581FF256C0BE5D0F9299E6746_908152885 = (endpoint(true) == null);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_295169752 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_295169752;
            // ---------- Original Method ----------
            //return endpoint(true) == null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.179 -0400", hash_original_method = "00AB887CF1625BBE035D7C27E115F8F5", hash_generated_method = "51D1C63F6206595B1D70793FD66D26E5")
        @Override
        public V get(Object key) {
            V varB4EAC82CA7396A68D541C85D26508E83_57324865 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_57324865 = isInBounds(key) ? TreeMap.this.get(key) : null;
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_57324865.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_57324865;
            // ---------- Original Method ----------
            //return isInBounds(key) ? TreeMap.this.get(key) : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.179 -0400", hash_original_method = "97933E3E15C41B402232AC9CC0472CF2", hash_generated_method = "7157B60F6BC8EFAF7B41099CE8574CBF")
        @Override
        public boolean containsKey(Object key) {
            boolean varA3E267D2E614E41BB78FB5916F69E5F6_1227947265 = (isInBounds(key) && TreeMap.this.containsKey(key));
            addTaint(key.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_801238899 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_801238899;
            // ---------- Original Method ----------
            //return isInBounds(key) && TreeMap.this.containsKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.194 -0400", hash_original_method = "AA5BBA9E7D3BEE615F1E652A3C2B8A57", hash_generated_method = "FBACBDBF932C038577CF0D4063534B54")
        @Override
        public V put(K key, V value) {
            V varB4EAC82CA7396A68D541C85D26508E83_927190695 = null; //Variable for return #1
            {
                boolean varAD602F34696280F613EFFCC6CD1936C9_312653355 = (!isInBounds(key));
                {
                    if (DroidSafeAndroidRuntime.control) throw outOfBounds(key, fromBound, toBound);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_927190695 = putInternal(key, value);
            addTaint(key.getTaint());
            addTaint(value.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_927190695.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_927190695;
            // ---------- Original Method ----------
            //if (!isInBounds(key)) {
                //throw outOfBounds(key, fromBound, toBound);
            //}
            //return putInternal(key, value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.195 -0400", hash_original_method = "FD860E76286147E5825948B59334B12A", hash_generated_method = "A18EA2360B4820A509B81A3724CEE086")
        @Override
        public V remove(Object key) {
            V varB4EAC82CA7396A68D541C85D26508E83_909300311 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_909300311 = isInBounds(key) ? TreeMap.this.remove(key) : null;
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_909300311.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_909300311;
            // ---------- Original Method ----------
            //return isInBounds(key) ? TreeMap.this.remove(key) : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.195 -0400", hash_original_method = "CBDDB4BBE438A9DB233DEA58A1C969FA", hash_generated_method = "BFED3D6982D935B53A65503E517FD630")
        @SuppressWarnings("unchecked")
        private boolean isInBounds(Object key) {
            boolean varA5F72E2E91F3E285BA97AAF5A99A4DA1_1299202423 = (isInBounds((K) key, fromBound, toBound));
            addTaint(key.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2123896878 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2123896878;
            // ---------- Original Method ----------
            //return isInBounds((K) key, fromBound, toBound);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.196 -0400", hash_original_method = "692642A6AE210FFE582C89EC91302D79", hash_generated_method = "8863A4D121C871DBAE9802C287768BDE")
        private boolean isInBounds(K key, Bound fromBound, Bound toBound) {
            {
                {
                    boolean var9F6E7E65C5DF7B537032AF04E3982098_17968256 = (comparator.compare(key, from) < 0);
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean varFBA4E02ED99BA8F4A60A17B22AA50698_1525579792 = (comparator.compare(key, from) <= 0);
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var3BF67E403FFC608A69421DC18FA2C214_1657920063 = (comparator.compare(key, to) > 0);
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean varEA1D9A2226B6707B7C8DE8BD2619E59B_2053147583 = (comparator.compare(key, to) >= 0);
                } //End collapsed parenthetic
            } //End block
            addTaint(key.getTaint());
            addTaint(fromBound.getTaint());
            addTaint(toBound.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_568916679 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_568916679;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.196 -0400", hash_original_method = "CAAC4C1A33B13586569CF07F541A55C7", hash_generated_method = "E4AE43B6EF4F3DB547F6053DCA8671E5")
        private Node<K, V> bound(Node<K, V> node, Bound fromBound, Bound toBound) {
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_2001309586 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2001309586 = node != null && isInBounds(node.getKey(), fromBound, toBound) ? node : null;
            addTaint(node.getTaint());
            addTaint(fromBound.getTaint());
            addTaint(toBound.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2001309586.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2001309586;
            // ---------- Original Method ----------
            //return node != null && isInBounds(node.getKey(), fromBound, toBound) ? node : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.209 -0400", hash_original_method = "692355E3656C196457301F91A19D5157", hash_generated_method = "B7A3AB7F6516E80E34AAE0B449C406D0")
        public Entry<K, V> firstEntry() {
            Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_496636567 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_496636567 = immutableCopy(endpoint(true));
            varB4EAC82CA7396A68D541C85D26508E83_496636567.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_496636567;
            // ---------- Original Method ----------
            //return immutableCopy(endpoint(true));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.209 -0400", hash_original_method = "3800FF04B85DB50D775ADF76A89AF0FD", hash_generated_method = "3B921A21349FB96839A9277318416AA2")
        public Entry<K, V> pollFirstEntry() {
            Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_171715667 = null; //Variable for return #1
            Node<K, V> result;
            result = endpoint(true);
            {
                removeInternal(result);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_171715667 = immutableCopy(result);
            varB4EAC82CA7396A68D541C85D26508E83_171715667.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_171715667;
            // ---------- Original Method ----------
            //Node<K, V> result = endpoint(true);
            //if (result != null) {
                //removeInternal(result);
            //}
            //return immutableCopy(result);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.210 -0400", hash_original_method = "1DE5152AF86A2FB092CD0802BF299C85", hash_generated_method = "83F7D90029094E9A5C1969C7DA2FB992")
        public K firstKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_1682527505 = null; //Variable for return #1
            Entry<K, V> entry;
            entry = endpoint(true);
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1682527505 = entry.getKey();
            varB4EAC82CA7396A68D541C85D26508E83_1682527505.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1682527505;
            // ---------- Original Method ----------
            //Entry<K, V> entry = endpoint(true);
            //if (entry == null) {
                //throw new NoSuchElementException();
            //}
            //return entry.getKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.210 -0400", hash_original_method = "3349B358C55B472B88F39549996E074C", hash_generated_method = "3D2E162B2007B3D72B50A811B99BC395")
        public Entry<K, V> lastEntry() {
            Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_726977927 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_726977927 = immutableCopy(endpoint(false));
            varB4EAC82CA7396A68D541C85D26508E83_726977927.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_726977927;
            // ---------- Original Method ----------
            //return immutableCopy(endpoint(false));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.211 -0400", hash_original_method = "4E391E55891B2D72162CA8FBBFDB8088", hash_generated_method = "587B129F5506479022373FA0823F3B90")
        public Entry<K, V> pollLastEntry() {
            Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1388545884 = null; //Variable for return #1
            Node<K, V> result;
            result = endpoint(false);
            {
                removeInternal(result);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1388545884 = immutableCopy(result);
            varB4EAC82CA7396A68D541C85D26508E83_1388545884.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1388545884;
            // ---------- Original Method ----------
            //Node<K, V> result = endpoint(false);
            //if (result != null) {
                //removeInternal(result);
            //}
            //return immutableCopy(result);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.211 -0400", hash_original_method = "394B9DCC52DC405017E9FB6F95D12436", hash_generated_method = "2A4B3449612FFBF3991B9953D90DE44D")
        public K lastKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_1251665983 = null; //Variable for return #1
            Entry<K, V> entry;
            entry = endpoint(false);
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1251665983 = entry.getKey();
            varB4EAC82CA7396A68D541C85D26508E83_1251665983.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1251665983;
            // ---------- Original Method ----------
            //Entry<K, V> entry = endpoint(false);
            //if (entry == null) {
                //throw new NoSuchElementException();
            //}
            //return entry.getKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.220 -0400", hash_original_method = "83D48F5C9D4926E1668CDBC652A8BB3D", hash_generated_method = "45D1EF223BBF6ADBCCB63AC1ABCCC1D0")
        private Node<K, V> endpoint(boolean first) {
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1387466349 = null; //Variable for return #1
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_2076674888 = null; //Variable for return #2
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
                varB4EAC82CA7396A68D541C85D26508E83_1387466349 = bound(node, NO_BOUND, toBound);
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
                varB4EAC82CA7396A68D541C85D26508E83_2076674888 = bound(node, fromBound, NO_BOUND);
            } //End block
            addTaint(first);
            Node<K, V> varA7E53CE21691AB073D9660D615818899_483882862; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_483882862 = varB4EAC82CA7396A68D541C85D26508E83_1387466349;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_483882862 = varB4EAC82CA7396A68D541C85D26508E83_2076674888;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_483882862.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_483882862;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.225 -0400", hash_original_method = "4CDC04225A960E79B8311D7465BD3125", hash_generated_method = "CD998DACE1F11337E1BBF624180B87F8")
        private Entry<K, V> findBounded(K key, Relation relation) {
            Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_524564971 = null; //Variable for return #1
            relation = relation.forOrder(ascending);
            Bound fromBoundForCheck;
            fromBoundForCheck = fromBound;
            Bound toBoundForCheck;
            toBoundForCheck = toBound;
            {
                int comparison;
                comparison = comparator.compare(to, key);
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
                int comparison;
                comparison = comparator.compare(from, key);
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
            varB4EAC82CA7396A68D541C85D26508E83_524564971 = bound(find(key, relation), fromBoundForCheck, toBoundForCheck);
            addTaint(key.getTaint());
            addTaint(relation.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_524564971.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_524564971;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.226 -0400", hash_original_method = "BD9CF59DC295A4AE3510934F298E27E6", hash_generated_method = "3D5B758C7B4BD21D1CC4EED18D999E88")
        public Entry<K, V> lowerEntry(K key) {
            Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1589406529 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1589406529 = immutableCopy(findBounded(key, LOWER));
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1589406529.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1589406529;
            // ---------- Original Method ----------
            //return immutableCopy(findBounded(key, LOWER));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.226 -0400", hash_original_method = "EBA87E3AFD9E90051DFFEBD0117773EA", hash_generated_method = "B768AA6989A6263444B4A753A9EB8DD5")
        public K lowerKey(K key) {
            K varB4EAC82CA7396A68D541C85D26508E83_2056316752 = null; //Variable for return #1
            Entry<K, V> entry;
            entry = findBounded(key, LOWER);
            varB4EAC82CA7396A68D541C85D26508E83_2056316752 = entry != null ? entry.getKey() : null;
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2056316752.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2056316752;
            // ---------- Original Method ----------
            //Entry<K, V> entry = findBounded(key, LOWER);
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.238 -0400", hash_original_method = "581C54D570AF4193E6400C576ED95C35", hash_generated_method = "6CA3A2F04DC0376D03030EBE82515F64")
        public Entry<K, V> floorEntry(K key) {
            Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_290582325 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_290582325 = immutableCopy(findBounded(key, FLOOR));
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_290582325.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_290582325;
            // ---------- Original Method ----------
            //return immutableCopy(findBounded(key, FLOOR));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.243 -0400", hash_original_method = "E92237DAC033388A5150FD58D66D705D", hash_generated_method = "DA65AD4B04EA1E2C468BAC52BDAFE813")
        public K floorKey(K key) {
            K varB4EAC82CA7396A68D541C85D26508E83_1230376350 = null; //Variable for return #1
            Entry<K, V> entry;
            entry = findBounded(key, FLOOR);
            varB4EAC82CA7396A68D541C85D26508E83_1230376350 = entry != null ? entry.getKey() : null;
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1230376350.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1230376350;
            // ---------- Original Method ----------
            //Entry<K, V> entry = findBounded(key, FLOOR);
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.244 -0400", hash_original_method = "C11821BD096982DAE03E94867B2C92BE", hash_generated_method = "0011D83ADC653E49FB80536C06333B9D")
        public Entry<K, V> ceilingEntry(K key) {
            Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1531129256 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1531129256 = immutableCopy(findBounded(key, CEILING));
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1531129256.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1531129256;
            // ---------- Original Method ----------
            //return immutableCopy(findBounded(key, CEILING));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.256 -0400", hash_original_method = "01AF63D6DC81CC48D8C6B0BE37F83B4D", hash_generated_method = "B32AD70CC7C27877632364EA68E1C486")
        public K ceilingKey(K key) {
            K varB4EAC82CA7396A68D541C85D26508E83_1772522598 = null; //Variable for return #1
            Entry<K, V> entry;
            entry = findBounded(key, CEILING);
            varB4EAC82CA7396A68D541C85D26508E83_1772522598 = entry != null ? entry.getKey() : null;
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1772522598.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1772522598;
            // ---------- Original Method ----------
            //Entry<K, V> entry = findBounded(key, CEILING);
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.256 -0400", hash_original_method = "4DE66AB7FA66EBE29F4E4509967D65D0", hash_generated_method = "18D9D25EEAE86DEE8A9C2AC0D6931959")
        public Entry<K, V> higherEntry(K key) {
            Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1134092582 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1134092582 = immutableCopy(findBounded(key, HIGHER));
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1134092582.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1134092582;
            // ---------- Original Method ----------
            //return immutableCopy(findBounded(key, HIGHER));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.257 -0400", hash_original_method = "47A499322D06CDAFFEC1D4DA0A079F0A", hash_generated_method = "05402ABE309780C156D86A6A537B1438")
        public K higherKey(K key) {
            K varB4EAC82CA7396A68D541C85D26508E83_469656601 = null; //Variable for return #1
            Entry<K, V> entry;
            entry = findBounded(key, HIGHER);
            varB4EAC82CA7396A68D541C85D26508E83_469656601 = entry != null ? entry.getKey() : null;
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_469656601.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_469656601;
            // ---------- Original Method ----------
            //Entry<K, V> entry = findBounded(key, HIGHER);
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.258 -0400", hash_original_method = "631801B6DE22632DEACA2B547DEBE43A", hash_generated_method = "E25739DAF5054FD4D8DA16DBD09CB990")
        public Comparator<? super K> comparator() {
            Comparator<? super K> varB4EAC82CA7396A68D541C85D26508E83_401080463 = null; //Variable for return #1
            Comparator<? super K> varB4EAC82CA7396A68D541C85D26508E83_789048052 = null; //Variable for return #2
            {
                varB4EAC82CA7396A68D541C85D26508E83_401080463 = TreeMap.this.comparator();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_789048052 = Collections.reverseOrder(comparator);
            } //End block
            Comparator<? super K> varA7E53CE21691AB073D9660D615818899_789616475; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_789616475 = varB4EAC82CA7396A68D541C85D26508E83_401080463;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_789616475 = varB4EAC82CA7396A68D541C85D26508E83_789048052;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_789616475.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_789616475;
            // ---------- Original Method ----------
            //if (ascending) {
            //return TreeMap.this.comparator();
          //} else {
            //return Collections.reverseOrder(comparator);
          //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.258 -0400", hash_original_method = "7F86A739037DCA8312EEE2819E1107F8", hash_generated_method = "04EF5AC7B32647A85D1FE2478F5376E6")
        @Override
        public Set<Entry<K, V>> entrySet() {
            Set<Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_1085357860 = null; //Variable for return #1
            BoundedEntrySet result;
            result = entrySet;
            varB4EAC82CA7396A68D541C85D26508E83_1085357860 = result != null ? result : (entrySet = new BoundedEntrySet());
            varB4EAC82CA7396A68D541C85D26508E83_1085357860.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1085357860;
            // ---------- Original Method ----------
            //BoundedEntrySet result = entrySet;
            //return result != null ? result : (entrySet = new BoundedEntrySet());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.259 -0400", hash_original_method = "8D1D053C1D8B0756868AB879DB7CB086", hash_generated_method = "7CE6CCC12C39D925BD37DCED8FFCDADB")
        @Override
        public Set<K> keySet() {
            Set<K> varB4EAC82CA7396A68D541C85D26508E83_1677104709 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1677104709 = navigableKeySet();
            varB4EAC82CA7396A68D541C85D26508E83_1677104709.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1677104709;
            // ---------- Original Method ----------
            //return navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.260 -0400", hash_original_method = "58209BC6FD1C6420A0C3CE4B441A6EA8", hash_generated_method = "C9B6EC60CAF52B74D30877C0B525EFE3")
        public NavigableSet<K> navigableKeySet() {
            NavigableSet<K> varB4EAC82CA7396A68D541C85D26508E83_553331645 = null; //Variable for return #1
            BoundedKeySet result;
            result = keySet;
            varB4EAC82CA7396A68D541C85D26508E83_553331645 = result != null ? result : (keySet = new BoundedKeySet());
            varB4EAC82CA7396A68D541C85D26508E83_553331645.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_553331645;
            // ---------- Original Method ----------
            //BoundedKeySet result = keySet;
            //return result != null ? result : (keySet = new BoundedKeySet());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.281 -0400", hash_original_method = "6D358EC631E9E279A9C759613AD4CBF5", hash_generated_method = "8C3A2E3395D25A9BFCA62284D47E1A33")
        public NavigableMap<K, V> descendingMap() {
            NavigableMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_631799194 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_631799194 = new BoundedMap(!ascending, from, fromBound, to, toBound);
            varB4EAC82CA7396A68D541C85D26508E83_631799194.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_631799194;
            // ---------- Original Method ----------
            //return new BoundedMap(!ascending, from, fromBound, to, toBound);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.282 -0400", hash_original_method = "E068C75BD35AA3BEC427F457C352E2B5", hash_generated_method = "9BED122F9AF269BB790D20F2E1ECF514")
        public NavigableSet<K> descendingKeySet() {
            NavigableSet<K> varB4EAC82CA7396A68D541C85D26508E83_1289296068 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1289296068 = new BoundedMap(!ascending, from, fromBound, to, toBound).navigableKeySet();
            varB4EAC82CA7396A68D541C85D26508E83_1289296068.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1289296068;
            // ---------- Original Method ----------
            //return new BoundedMap(!ascending, from, fromBound, to, toBound).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.283 -0400", hash_original_method = "3DC9A98D108EA5F857802D111DD4C7BC", hash_generated_method = "F5D02395EF7AE10CFA0A693CD949A9D7")
        public NavigableMap<K, V> subMap(K from, boolean fromInclusive, K to, boolean toInclusive) {
            NavigableMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_51966583 = null; //Variable for return #1
            Bound fromBound;
            fromBound = INCLUSIVE;
            fromBound = EXCLUSIVE;
            Bound toBound;
            toBound = INCLUSIVE;
            toBound = EXCLUSIVE;
            varB4EAC82CA7396A68D541C85D26508E83_51966583 = subMap(from, fromBound, to, toBound);
            addTaint(from.getTaint());
            addTaint(fromInclusive);
            addTaint(to.getTaint());
            addTaint(toInclusive);
            varB4EAC82CA7396A68D541C85D26508E83_51966583.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_51966583;
            // ---------- Original Method ----------
            //Bound fromBound = fromInclusive ? INCLUSIVE : EXCLUSIVE;
            //Bound toBound = toInclusive ? INCLUSIVE : EXCLUSIVE;
            //return subMap(from, fromBound, to, toBound);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.283 -0400", hash_original_method = "85C9C855FCFD7C01DE62316D427AA356", hash_generated_method = "0C6334CC259E37E7FFA80847450B430C")
        public NavigableMap<K, V> subMap(K fromInclusive, K toExclusive) {
            NavigableMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_129403653 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_129403653 = subMap(fromInclusive, INCLUSIVE, toExclusive, EXCLUSIVE);
            addTaint(fromInclusive.getTaint());
            addTaint(toExclusive.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_129403653.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_129403653;
            // ---------- Original Method ----------
            //return subMap(fromInclusive, INCLUSIVE, toExclusive, EXCLUSIVE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.284 -0400", hash_original_method = "F0BAF6F2CF2FCD82E483E31B5C869204", hash_generated_method = "F23DD5C54C8448A290EFE337119C4D65")
        public NavigableMap<K, V> headMap(K to, boolean inclusive) {
            NavigableMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_2105203322 = null; //Variable for return #1
            Bound toBound;
            toBound = INCLUSIVE;
            toBound = EXCLUSIVE;
            varB4EAC82CA7396A68D541C85D26508E83_2105203322 = subMap(null, NO_BOUND, to, toBound);
            addTaint(to.getTaint());
            addTaint(inclusive);
            varB4EAC82CA7396A68D541C85D26508E83_2105203322.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2105203322;
            // ---------- Original Method ----------
            //Bound toBound = inclusive ? INCLUSIVE : EXCLUSIVE;
            //return subMap(null, NO_BOUND, to, toBound);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.300 -0400", hash_original_method = "ABFE13DC9073E46E049BB999D5306953", hash_generated_method = "DF7B794FFD4C0A940AD12C1FD915A85C")
        public NavigableMap<K, V> headMap(K toExclusive) {
            NavigableMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_507992341 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_507992341 = subMap(null, NO_BOUND, toExclusive, EXCLUSIVE);
            addTaint(toExclusive.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_507992341.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_507992341;
            // ---------- Original Method ----------
            //return subMap(null, NO_BOUND, toExclusive, EXCLUSIVE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.300 -0400", hash_original_method = "26986665A8C827C93D404190F2752B4C", hash_generated_method = "48FB9D618F34F568D8FA5A8C35E471F4")
        public NavigableMap<K, V> tailMap(K from, boolean inclusive) {
            NavigableMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_212811436 = null; //Variable for return #1
            Bound fromBound;
            fromBound = INCLUSIVE;
            fromBound = EXCLUSIVE;
            varB4EAC82CA7396A68D541C85D26508E83_212811436 = subMap(from, fromBound, null, NO_BOUND);
            addTaint(from.getTaint());
            addTaint(inclusive);
            varB4EAC82CA7396A68D541C85D26508E83_212811436.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_212811436;
            // ---------- Original Method ----------
            //Bound fromBound = inclusive ? INCLUSIVE : EXCLUSIVE;
            //return subMap(from, fromBound, null, NO_BOUND);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.301 -0400", hash_original_method = "CF387452C0473BBA846F53D5C56CE3B2", hash_generated_method = "4DAB077A874A2AE665994A8BCACE2ACC")
        public NavigableMap<K, V> tailMap(K fromInclusive) {
            NavigableMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_871378138 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_871378138 = subMap(fromInclusive, INCLUSIVE, null, NO_BOUND);
            addTaint(fromInclusive.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_871378138.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_871378138;
            // ---------- Original Method ----------
            //return subMap(fromInclusive, INCLUSIVE, null, NO_BOUND);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.317 -0400", hash_original_method = "0BE57F9811CA6209D3A6FF727B140802", hash_generated_method = "20269031BF7E175B5E4E0068B1A71247")
        private NavigableMap<K, V> subMap(K from, Bound fromBound, K to, Bound toBound) {
            NavigableMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_256998119 = null; //Variable for return #1
            {
                K fromTmp;
                fromTmp = from;
                Bound fromBoundTmp;
                fromBoundTmp = fromBound;
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
                    boolean var1DAE628D732342D7BC54FD4D3278CE34_492870008 = (!isInBounds(from, fromBoundToCheck, this.toBound));
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
                    boolean var5922B8A01789147118CB04C1CDD52F79_555086736 = (!isInBounds(to, this.fromBound, toBoundToCheck));
                    {
                        if (DroidSafeAndroidRuntime.control) throw outOfBounds(to, this.fromBound, toBoundToCheck);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_256998119 = new BoundedMap(ascending, from, fromBound, to, toBound);
            varB4EAC82CA7396A68D541C85D26508E83_256998119.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_256998119;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.321 -0400", hash_original_method = "65FB71F2A366D35F7884C2869AFAA6ED", hash_generated_method = "60304EC81B74A0C401094B6F7C0B1047")
        private IllegalArgumentException outOfBounds(Object value, Bound fromBound, Bound toBound) {
            IllegalArgumentException varB4EAC82CA7396A68D541C85D26508E83_1587076276 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1587076276 = new IllegalArgumentException(value + " not in range "
                    + fromBound.leftCap(from) + ".." + toBound.rightCap(to));
            addTaint(value.getTaint());
            addTaint(fromBound.getTaint());
            addTaint(toBound.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1587076276.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1587076276;
            // ---------- Original Method ----------
            //return new IllegalArgumentException(value + " not in range "
                    //+ fromBound.leftCap(from) + ".." + toBound.rightCap(to));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.322 -0400", hash_original_method = "9F20C8CFE1A741092D9743A31C3F8586", hash_generated_method = "E275FC397DA2BF04B1287A2BAD11355A")
         Object writeReplace() throws ObjectStreamException {
            Object varB4EAC82CA7396A68D541C85D26508E83_790514007 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_790514007 = ascending
                    ? new AscendingSubMap<K, V>(TreeMap.this, from, fromBound, to, toBound)
                    : new DescendingSubMap<K, V>(TreeMap.this, from, fromBound, to, toBound);
            varB4EAC82CA7396A68D541C85D26508E83_790514007.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_790514007;
            // ---------- Original Method ----------
            //return ascending
                    //? new AscendingSubMap<K, V>(TreeMap.this, from, fromBound, to, toBound)
                    //: new DescendingSubMap<K, V>(TreeMap.this, from, fromBound, to, toBound);
        }

        
        abstract class BoundedIterator<T> extends MapIterator<T> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.322 -0400", hash_original_method = "30CDAF663F351A84269F6FB0B072EFA9", hash_generated_method = "DCA6AE078FF061847F66F0A7A80CFEA2")
            protected  BoundedIterator(Node<K, V> next) {
                super(next);
                addTaint(next.getTaint());
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.323 -0400", hash_original_method = "E9206CF01CB691A7CC292AD03FA9736C", hash_generated_method = "8FF34C02F95A15C5E64F88C461111399")
            @Override
            protected Node<K, V> stepForward() {
                Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1494221275 = null; //Variable for return #1
                Node<K, V> result;
                result = super.stepForward();
                {
                    boolean varB492F846C21C09F0364F2416324ABD06_1033509395 = (next != null && !isInBounds(next.key, NO_BOUND, toBound));
                    {
                        next = null;
                    } //End block
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_1494221275 = result;
                varB4EAC82CA7396A68D541C85D26508E83_1494221275.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1494221275;
                // ---------- Original Method ----------
                //Node<K, V> result = super.stepForward();
                //if (next != null && !isInBounds(next.key, NO_BOUND, toBound)) {
                    //next = null;
                //}
                //return result;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.327 -0400", hash_original_method = "E55F6A3E56D317586EA4F65D3F74D30B", hash_generated_method = "099C217C221B24111BD9F8153AD42F90")
            @Override
            protected Node<K, V> stepBackward() {
                Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_889257395 = null; //Variable for return #1
                Node<K, V> result;
                result = super.stepBackward();
                {
                    boolean varA14FF8A4CC2199BAF982AB4CC94D03CC_1246726694 = (next != null && !isInBounds(next.key, fromBound, NO_BOUND));
                    {
                        next = null;
                    } //End block
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_889257395 = result;
                varB4EAC82CA7396A68D541C85D26508E83_889257395.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_889257395;
                // ---------- Original Method ----------
                //Node<K, V> result = super.stepBackward();
                //if (next != null && !isInBounds(next.key, fromBound, NO_BOUND)) {
                    //next = null;
                //}
                //return result;
            }

            
        }


        
        final class BoundedEntrySet extends AbstractSet<Entry<K, V>> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.328 -0400", hash_original_method = "6A727A04787362E0DA8C9D4EFA8450E8", hash_generated_method = "6A727A04787362E0DA8C9D4EFA8450E8")
            public BoundedEntrySet ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.342 -0400", hash_original_method = "29BBB3BE9EA7B6D6C0B83C28F05082A4", hash_generated_method = "ECDE60B141722BA458A1A7A1F51780AA")
            @Override
            public int size() {
                int var69D9F234E7E76618743D3D698A58599B_436291898 = (BoundedMap.this.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1397262837 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1397262837;
                // ---------- Original Method ----------
                //return BoundedMap.this.size();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.342 -0400", hash_original_method = "AEA447F4A69E282FABF93736832EBAA3", hash_generated_method = "B2D6FA9B9792CE48D17232723D4629F8")
            @Override
            public boolean isEmpty() {
                boolean varF1E2DF8AD3E4C9C508E293B19251E66A_1921771909 = (BoundedMap.this.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1891614368 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1891614368;
                // ---------- Original Method ----------
                //return BoundedMap.this.isEmpty();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.342 -0400", hash_original_method = "0E267F64AB80178C28467CD978AC79C8", hash_generated_method = "3E4B31C430B298A61276654F04628DDC")
            @Override
            public Iterator<Entry<K, V>> iterator() {
                Iterator<Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_2053315933 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_2053315933 = new BoundedIterator<Entry<K, V>>(endpoint(true)) {
                    public Entry<K, V> next() {
                        return ascending ? stepForward() : stepBackward();
                    }
                };
                varB4EAC82CA7396A68D541C85D26508E83_2053315933.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_2053315933;
                // ---------- Original Method ----------
                //return new BoundedIterator<Entry<K, V>>(endpoint(true)) {
                    //public Entry<K, V> next() {
                        //return ascending ? stepForward() : stepBackward();
                    //}
                //};
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.343 -0400", hash_original_method = "954A21A7B25CC1709817AC62B8C6864E", hash_generated_method = "39B0D925DA0F62B5386F9433CB05DDDA")
            @Override
            public boolean contains(Object o) {
                Entry<?, ?> entry;
                entry = (Entry<?, ?>) o;
                boolean varC238596BFA0BDAC8F31141888DBD9FC9_1442336027 = (isInBounds(entry.getKey()) && findByEntry(entry) != null);
                addTaint(o.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1023947984 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1023947984;
                // ---------- Original Method ----------
                //if (!(o instanceof Entry)) {
                    //return false;
                //}
                //Entry<?, ?> entry = (Entry<?, ?>) o;
                //return isInBounds(entry.getKey()) && findByEntry(entry) != null;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.343 -0400", hash_original_method = "EF59D88655EE445530DBDC219FDD1A5F", hash_generated_method = "FB46B7BF65953C0A2ACD75A8083EBDAB")
            @Override
            public boolean remove(Object o) {
                Entry<?, ?> entry;
                entry = (Entry<?, ?>) o;
                boolean var155AF0A9D9B42FB9DF7C214F267A7E1B_1959115596 = (isInBounds(entry.getKey()) && TreeMap.this.entrySet().remove(entry));
                addTaint(o.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1970803161 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1970803161;
                // ---------- Original Method ----------
                //if (!(o instanceof Entry)) {
                    //return false;
                //}
                //Entry<?, ?> entry = (Entry<?, ?>) o;
                //return isInBounds(entry.getKey()) && TreeMap.this.entrySet().remove(entry);
            }

            
        }


        
        final class BoundedKeySet extends AbstractSet<K> implements NavigableSet<K> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.343 -0400", hash_original_method = "9AD1259E686AD3B6150FA3E61E8BAA17", hash_generated_method = "9AD1259E686AD3B6150FA3E61E8BAA17")
            public BoundedKeySet ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.360 -0400", hash_original_method = "29BBB3BE9EA7B6D6C0B83C28F05082A4", hash_generated_method = "6CF1D026D9D7E400B2CEB07EFAF94B7A")
            @Override
            public int size() {
                int var69D9F234E7E76618743D3D698A58599B_2042998733 = (BoundedMap.this.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1175585513 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1175585513;
                // ---------- Original Method ----------
                //return BoundedMap.this.size();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.360 -0400", hash_original_method = "AEA447F4A69E282FABF93736832EBAA3", hash_generated_method = "C96CBC1CC48243486DE839FBB4C04A50")
            @Override
            public boolean isEmpty() {
                boolean varF1E2DF8AD3E4C9C508E293B19251E66A_2096708157 = (BoundedMap.this.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_919451027 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_919451027;
                // ---------- Original Method ----------
                //return BoundedMap.this.isEmpty();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.362 -0400", hash_original_method = "8539DDED7A19368CB3D09440D6A62269", hash_generated_method = "50204176EFEC0E0FD2BBE96CDEF31CA4")
            @Override
            public Iterator<K> iterator() {
                Iterator<K> varB4EAC82CA7396A68D541C85D26508E83_2004475203 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_2004475203 = new BoundedIterator<K>(endpoint(true)) {
                    public K next() {
                        return (ascending ? stepForward() : stepBackward()).key;
                    }
                };
                varB4EAC82CA7396A68D541C85D26508E83_2004475203.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_2004475203;
                // ---------- Original Method ----------
                //return new BoundedIterator<K>(endpoint(true)) {
                    //public K next() {
                        //return (ascending ? stepForward() : stepBackward()).key;
                    //}
                //};
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.362 -0400", hash_original_method = "74923548E6D3A508C57DDA053BC0EE64", hash_generated_method = "64492519F6677BD96147D9F2AB4B30EF")
            public Iterator<K> descendingIterator() {
                Iterator<K> varB4EAC82CA7396A68D541C85D26508E83_1308676968 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1308676968 = new BoundedIterator<K>(endpoint(false)) {
                    public K next() {
                        return (ascending ? stepBackward() : stepForward()).key;
                    }
                };
                varB4EAC82CA7396A68D541C85D26508E83_1308676968.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1308676968;
                // ---------- Original Method ----------
                //return new BoundedIterator<K>(endpoint(false)) {
                    //public K next() {
                        //return (ascending ? stepBackward() : stepForward()).key;
                    //}
                //};
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.362 -0400", hash_original_method = "F2816D590B9E0F32B93C47AB444AEEED", hash_generated_method = "E12200B584A26225E9539D87AF05D75D")
            @Override
            public boolean contains(Object key) {
                boolean varDEADC564C50A1257392A09A833F9988B_1141867694 = (isInBounds(key) && findByObject(key) != null);
                addTaint(key.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1304194443 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1304194443;
                // ---------- Original Method ----------
                //return isInBounds(key) && findByObject(key) != null;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.363 -0400", hash_original_method = "ADEDE1B4ABE9B2F86F8B629056F35200", hash_generated_method = "1B5004A4D06EDD6C6E1AA7EDFB258123")
            @Override
            public boolean remove(Object key) {
                boolean var55612E9AB490EF3FFBD38F202307B8D4_1006057516 = (isInBounds(key) && removeInternalByKey(key) != null);
                addTaint(key.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1522450927 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1522450927;
                // ---------- Original Method ----------
                //return isInBounds(key) && removeInternalByKey(key) != null;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.363 -0400", hash_original_method = "3067DEE01FBBBFD061436C7D4561F434", hash_generated_method = "D0FC6237DDA593F5F977E6A197F23511")
            public K first() {
                K varB4EAC82CA7396A68D541C85D26508E83_2122470325 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_2122470325 = firstKey();
                varB4EAC82CA7396A68D541C85D26508E83_2122470325.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_2122470325;
                // ---------- Original Method ----------
                //return firstKey();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.367 -0400", hash_original_method = "4985BB63726B115899F1811F08E80BDF", hash_generated_method = "E15C3849449FDF3E1BA7D189948D7232")
            public K pollFirst() {
                K varB4EAC82CA7396A68D541C85D26508E83_1747994955 = null; //Variable for return #1
                Entry<K, ?> entry;
                entry = pollFirstEntry();
                varB4EAC82CA7396A68D541C85D26508E83_1747994955 = entry != null ? entry.getKey() : null;
                varB4EAC82CA7396A68D541C85D26508E83_1747994955.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1747994955;
                // ---------- Original Method ----------
                //Entry<K, ?> entry = pollFirstEntry();
                //return entry != null ? entry.getKey() : null;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.368 -0400", hash_original_method = "39C87F788E647BCD3FB86FFF34D7EF10", hash_generated_method = "B828261276A5F95C01FFFE6B648D493F")
            public K last() {
                K varB4EAC82CA7396A68D541C85D26508E83_372763133 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_372763133 = lastKey();
                varB4EAC82CA7396A68D541C85D26508E83_372763133.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_372763133;
                // ---------- Original Method ----------
                //return lastKey();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.368 -0400", hash_original_method = "B202B1B2AAB477548F6A0AD72C9B1701", hash_generated_method = "471F8C9BEE9F01E439E281ADEF3507B3")
            public K pollLast() {
                K varB4EAC82CA7396A68D541C85D26508E83_1217020898 = null; //Variable for return #1
                Entry<K, ?> entry;
                entry = pollLastEntry();
                varB4EAC82CA7396A68D541C85D26508E83_1217020898 = entry != null ? entry.getKey() : null;
                varB4EAC82CA7396A68D541C85D26508E83_1217020898.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1217020898;
                // ---------- Original Method ----------
                //Entry<K, ?> entry = pollLastEntry();
                //return entry != null ? entry.getKey() : null;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.369 -0400", hash_original_method = "5CFE05BF706A06BBB501067306F1B9ED", hash_generated_method = "5224DB718637B9114F3392D4564566CC")
            public K lower(K key) {
                K varB4EAC82CA7396A68D541C85D26508E83_1680943559 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1680943559 = lowerKey(key);
                addTaint(key.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_1680943559.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1680943559;
                // ---------- Original Method ----------
                //return lowerKey(key);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.369 -0400", hash_original_method = "10BABB7BB2E837824A13AAE89EE7EC6F", hash_generated_method = "81CCB0D42C0FE04377DF14E2CEDF7C86")
            public K floor(K key) {
                K varB4EAC82CA7396A68D541C85D26508E83_580155988 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_580155988 = floorKey(key);
                addTaint(key.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_580155988.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_580155988;
                // ---------- Original Method ----------
                //return floorKey(key);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.386 -0400", hash_original_method = "2AD4706A6D818B709A1E2CA64B48B4B9", hash_generated_method = "C8B6BF62F45C49AB6E411EEA54F17AD7")
            public K ceiling(K key) {
                K varB4EAC82CA7396A68D541C85D26508E83_801166302 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_801166302 = ceilingKey(key);
                addTaint(key.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_801166302.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_801166302;
                // ---------- Original Method ----------
                //return ceilingKey(key);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.393 -0400", hash_original_method = "8CC63649234BFC57DB10A2387AE34DD6", hash_generated_method = "0AA49951FDA3219DB53C8AB5EBA55035")
            public K higher(K key) {
                K varB4EAC82CA7396A68D541C85D26508E83_717748255 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_717748255 = higherKey(key);
                addTaint(key.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_717748255.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_717748255;
                // ---------- Original Method ----------
                //return higherKey(key);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.394 -0400", hash_original_method = "C5DD330893039070B9523799F47D2DEB", hash_generated_method = "0406B5F77163874F35E5E362D22E451D")
            public Comparator<? super K> comparator() {
                Comparator<? super K> varB4EAC82CA7396A68D541C85D26508E83_251706064 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_251706064 = BoundedMap.this.comparator();
                varB4EAC82CA7396A68D541C85D26508E83_251706064.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_251706064;
                // ---------- Original Method ----------
                //return BoundedMap.this.comparator();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.394 -0400", hash_original_method = "21039715CA3F916EA62F8064E71FC6CA", hash_generated_method = "F49C50D4CBB963C5B5BD6E8C636C056A")
            public NavigableSet<K> subSet(K from, boolean fromInclusive, K to, boolean toInclusive) {
                NavigableSet<K> varB4EAC82CA7396A68D541C85D26508E83_989635664 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_989635664 = subMap(from, fromInclusive, to, toInclusive).navigableKeySet();
                addTaint(from.getTaint());
                addTaint(fromInclusive);
                addTaint(to.getTaint());
                addTaint(toInclusive);
                varB4EAC82CA7396A68D541C85D26508E83_989635664.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_989635664;
                // ---------- Original Method ----------
                //return subMap(from, fromInclusive, to, toInclusive).navigableKeySet();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.413 -0400", hash_original_method = "AA0E5149ADFB9D8316CC8EA86FBC0B9E", hash_generated_method = "BB9BC74C6D679F058C1DA2EE120FD598")
            public SortedSet<K> subSet(K fromInclusive, K toExclusive) {
                SortedSet<K> varB4EAC82CA7396A68D541C85D26508E83_1887406883 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1887406883 = subMap(fromInclusive, toExclusive).navigableKeySet();
                addTaint(fromInclusive.getTaint());
                addTaint(toExclusive.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_1887406883.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1887406883;
                // ---------- Original Method ----------
                //return subMap(fromInclusive, toExclusive).navigableKeySet();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.414 -0400", hash_original_method = "EDDD3784AC7E9834A18CCB5F2AE27346", hash_generated_method = "9A37939AA1E5DCFB9369D2D0F259A6DF")
            public NavigableSet<K> headSet(K to, boolean inclusive) {
                NavigableSet<K> varB4EAC82CA7396A68D541C85D26508E83_1186970951 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1186970951 = headMap(to, inclusive).navigableKeySet();
                addTaint(to.getTaint());
                addTaint(inclusive);
                varB4EAC82CA7396A68D541C85D26508E83_1186970951.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1186970951;
                // ---------- Original Method ----------
                //return headMap(to, inclusive).navigableKeySet();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.414 -0400", hash_original_method = "85EE899AF4D85617CB858518BA70EA12", hash_generated_method = "9D8E6546709084881B65004F70356509")
            public SortedSet<K> headSet(K toExclusive) {
                SortedSet<K> varB4EAC82CA7396A68D541C85D26508E83_1209214484 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1209214484 = headMap(toExclusive).navigableKeySet();
                addTaint(toExclusive.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_1209214484.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1209214484;
                // ---------- Original Method ----------
                //return headMap(toExclusive).navigableKeySet();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.415 -0400", hash_original_method = "B964A303D464756EDD8E9C26A8D54411", hash_generated_method = "48E393B812B9559E3D0F19A4F0451C59")
            public NavigableSet<K> tailSet(K from, boolean inclusive) {
                NavigableSet<K> varB4EAC82CA7396A68D541C85D26508E83_1747223924 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1747223924 = tailMap(from, inclusive).navigableKeySet();
                addTaint(from.getTaint());
                addTaint(inclusive);
                varB4EAC82CA7396A68D541C85D26508E83_1747223924.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1747223924;
                // ---------- Original Method ----------
                //return tailMap(from, inclusive).navigableKeySet();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.415 -0400", hash_original_method = "9536952691BDDFD3D8EFB20A3BD9AE85", hash_generated_method = "7411C178B7FA4EDF012E550491011E82")
            public SortedSet<K> tailSet(K fromInclusive) {
                SortedSet<K> varB4EAC82CA7396A68D541C85D26508E83_1610980914 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1610980914 = tailMap(fromInclusive).navigableKeySet();
                addTaint(fromInclusive.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_1610980914.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1610980914;
                // ---------- Original Method ----------
                //return tailMap(fromInclusive).navigableKeySet();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.416 -0400", hash_original_method = "2BD89B2F5D5D75B5A66FC121E2BE77F9", hash_generated_method = "47786975237C4C683D8BBFE8FCBAA236")
            public NavigableSet<K> descendingSet() {
                NavigableSet<K> varB4EAC82CA7396A68D541C85D26508E83_873406571 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_873406571 = new BoundedMap(!ascending, from, fromBound, to, toBound).navigableKeySet();
                varB4EAC82CA7396A68D541C85D26508E83_873406571.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_873406571;
                // ---------- Original Method ----------
                //return new BoundedMap(!ascending, from, fromBound, to, toBound).navigableKeySet();
            }

            
        }


        
    }


    
    static abstract class NavigableSubMap<K, V> extends AbstractMap<K, V> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.416 -0400", hash_original_field = "6F8F57715090DA2632453988D9A1501B", hash_generated_field = "B4717CF7B02EE2D309DEC599DAA1DA31")

        TreeMap<K, V> m;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.416 -0400", hash_original_field = "7CE8636C076F5F42316676F7CA5CCFBE", hash_generated_field = "281EBE4703232193C289CCB42FC430E9")

        Object lo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.416 -0400", hash_original_field = "49F68A5C8493EC2C0BF489821C21FC3B", hash_generated_field = "EE270961C9ABF0EB22776F11E5EA361C")

        Object hi;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.416 -0400", hash_original_field = "0F5BB94160321573CBA39E65B009DB81", hash_generated_field = "D276D04527E3A57EE21A2E9A0B8A1207")

        boolean fromStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.416 -0400", hash_original_field = "A7515FC4FC23FB8889BFBA1242727AA1", hash_generated_field = "949B6DE90AB1D05CDD408410B1AFD766")

        boolean toEnd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.416 -0400", hash_original_field = "A7CF08EB9369574B3716AAA5776C2B8D", hash_generated_field = "21B44DD2A9CF91217A1B213D6DC61745")

        boolean loInclusive;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.416 -0400", hash_original_field = "A4BF0B040F2788C41F2B3BBC34352A92", hash_generated_field = "B6BC458569D2A14CE4BE7D6F92D77203")

        boolean hiInclusive;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.430 -0400", hash_original_method = "C1ACA683FC5CFCA3BE29823730AC5B8B", hash_generated_method = "D5980D3B68B4F742E542A915179E4C63")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.442 -0400", hash_original_method = "98169B5D59A5E61A69F2A37D56262114", hash_generated_method = "3CAF377124FBFCFBABACDE8606964B0B")
        @Override
        public Set<Entry<K, V>> entrySet() {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.442 -0400", hash_original_method = "6A8A4C8549808D70F841B9593D31A43F", hash_generated_method = "E7EECDCF9D07FBD1B1F40D4FBF3EA035")
        @SuppressWarnings("unchecked")
        protected Object readResolve() throws ObjectStreamException {
            Object varB4EAC82CA7396A68D541C85D26508E83_476782845 = null; //Variable for return #1
            Bound fromBound;
            fromBound = NO_BOUND;
            fromBound = (loInclusive ? INCLUSIVE : EXCLUSIVE);
            Bound toBound;
            toBound = NO_BOUND;
            toBound = (hiInclusive ? INCLUSIVE : EXCLUSIVE);
            boolean ascending;
            ascending = !(this instanceof DescendingSubMap);
            varB4EAC82CA7396A68D541C85D26508E83_476782845 = m.new BoundedMap(ascending, (K) lo, fromBound, (K) hi, toBound);
            varB4EAC82CA7396A68D541C85D26508E83_476782845.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_476782845;
            // ---------- Original Method ----------
            //Bound fromBound = fromStart ? NO_BOUND : (loInclusive ? INCLUSIVE : EXCLUSIVE);
            //Bound toBound = toEnd ? NO_BOUND : (hiInclusive ? INCLUSIVE : EXCLUSIVE);
            //boolean ascending = !(this instanceof DescendingSubMap);
            //return m.new BoundedMap(ascending, (K) lo, fromBound, (K) hi, toBound);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.442 -0400", hash_original_field = "24DD802BAD101B93E8408F7D464B2F7C", hash_generated_field = "B6DBB99D66C7D5257F18744C6ED55042")

        private static long serialVersionUID = -2102997345730753016L;
    }


    
    static class DescendingSubMap<K, V> extends NavigableSubMap<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.443 -0400", hash_original_field = "9895B45EF9B1655F7485C1A0A0B5F7B1", hash_generated_field = "4B9119BDF2383B87567C450919484206")

        Comparator<K> reverseComparator;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.448 -0400", hash_original_method = "FDAA1F4436CE129642763FB7A272001D", hash_generated_method = "403BC4E2D5604955FA33199087DB72AD")
          DescendingSubMap(TreeMap<K, V> delegate, K from, Bound fromBound, K to, Bound toBound) {
            super(delegate, from, fromBound, to, toBound);
            addTaint(delegate.getTaint());
            addTaint(from.getTaint());
            addTaint(fromBound.getTaint());
            addTaint(to.getTaint());
            addTaint(toBound.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.459 -0400", hash_original_field = "52D0D343187A178B79D894969A386899", hash_generated_field = "EFA8ED22E30CE9903B2F3A838ED881F4")

        private static long serialVersionUID = 912986545866120460L;
    }


    
    static class AscendingSubMap<K, V> extends NavigableSubMap<K, V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.460 -0400", hash_original_method = "C32F016187D7478ED63A0FCF56CB93EB", hash_generated_method = "CB936BEDAF7FEDB34599950C363DBD15")
          AscendingSubMap(TreeMap<K, V> delegate, K from, Bound fromBound, K to, Bound toBound) {
            super(delegate, from, fromBound, to, toBound);
            addTaint(delegate.getTaint());
            addTaint(from.getTaint());
            addTaint(fromBound.getTaint());
            addTaint(to.getTaint());
            addTaint(toBound.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.460 -0400", hash_original_field = "B7AE5FA51DF371C0F9A4E87B021D4132", hash_generated_field = "476C935E303A86073A4CED2972DE762E")

        private static long serialVersionUID = 912986545866124060L;
    }


    
    class SubMap extends AbstractMap<K, V> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.460 -0400", hash_original_field = "430A77C88BFBC96EB36AF12A2DC1DEB7", hash_generated_field = "7CA688EFC5D14AE4FAAF4A0FA771CBD0")

        Object fromKey;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.460 -0400", hash_original_field = "A8F9F07D66AF8C1622E025437E7B26CE", hash_generated_field = "40A3A7AC103CBB24D1824415661519AF")

        Object toKey;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.460 -0400", hash_original_field = "0F5BB94160321573CBA39E65B009DB81", hash_generated_field = "D276D04527E3A57EE21A2E9A0B8A1207")

        boolean fromStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.460 -0400", hash_original_field = "A7515FC4FC23FB8889BFBA1242727AA1", hash_generated_field = "949B6DE90AB1D05CDD408410B1AFD766")

        boolean toEnd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.461 -0400", hash_original_method = "F30568FCC0DA5EEA09201E340702FDB4", hash_generated_method = "F30568FCC0DA5EEA09201E340702FDB4")
        public SubMap ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.461 -0400", hash_original_method = "98169B5D59A5E61A69F2A37D56262114", hash_generated_method = "3CAF377124FBFCFBABACDE8606964B0B")
        @Override
        public Set<Entry<K, V>> entrySet() {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.462 -0400", hash_original_method = "AC95C6CC81DF8BD4B0519A49635D6CF0", hash_generated_method = "0E779AB211DED5460C5823BCDDF8FD66")
        @SuppressWarnings("unchecked")
        protected Object readResolve() throws ObjectStreamException {
            Object varB4EAC82CA7396A68D541C85D26508E83_1974421064 = null; //Variable for return #1
            Bound fromBound;
            fromBound = NO_BOUND;
            fromBound = INCLUSIVE;
            Bound toBound;
            toBound = NO_BOUND;
            toBound = EXCLUSIVE;
            varB4EAC82CA7396A68D541C85D26508E83_1974421064 = new BoundedMap(true, (K) fromKey, fromBound, (K) toKey, toBound);
            varB4EAC82CA7396A68D541C85D26508E83_1974421064.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1974421064;
            // ---------- Original Method ----------
            //Bound fromBound = fromStart ? NO_BOUND : INCLUSIVE;
            //Bound toBound = toEnd ? NO_BOUND : EXCLUSIVE;
            //return new BoundedMap(true, (K) fromKey, fromBound, (K) toKey, toBound);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.469 -0400", hash_original_field = "EB690E9D3449E3ACDD044094944C88A2", hash_generated_field = "1C1BE65D094A2A2CF312563B1B5E5211")

        private static long serialVersionUID = -6520786458950516097L;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.470 -0400", hash_original_field = "AAD864C939B46188F070706401E1932C", hash_generated_field = "5EF963E9E0FAC9EDBF55B347DF529C53")

    @SuppressWarnings("unchecked") private static Comparator<Comparable> NATURAL_ORDER = new Comparator<Comparable>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.470 -0400", hash_original_method = "078A1DB9555D9E606EA5FF406F56B2E6", hash_generated_method = "81BB8D30019CADFB31838A3F5BF63807")
        public int compare(Comparable a, Comparable b) {
            int varC15B2565AD7A5177ED0132648C5386D9_7637460 = (a.compareTo(b));
            addTaint(a.getTaint());
            addTaint(b.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1270933056 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1270933056;
            // ---------- Original Method ----------
            //return a.compareTo(b);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.470 -0400", hash_original_field = "0CB2D400AD555324093441A5EA2C6B7E", hash_generated_field = "BA41D7ADB475E35CDFC9F7B608EF580C")

    private static long serialVersionUID = 919286545866124006L;
}

