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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.760 -0400", hash_original_field = "4092F21BD0E2CC3C9CA971DF59AA8608", hash_generated_field = "10E826BC31BCAB9BF3EF3CC29146C2D4")

    Comparator<? super K> comparator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.760 -0400", hash_original_field = "63A9F0EA7BB98050796B649E85481845", hash_generated_field = "85295BCB9659691A12B83D4313F1A2F9")

    Node<K, V> root;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.760 -0400", hash_original_field = "4C519DE3531208469B40CCB51004CD2D", hash_generated_field = "689FC3CB9A887B5817C15E9CFDD066DB")

    int size = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.760 -0400", hash_original_field = "8626C3CD64A823DD7B97C6F5EF45A8FC", hash_generated_field = "7C38AA8724D6D8AD727BB2AB85887DF0")

    int modCount = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.760 -0400", hash_original_field = "D4E06C98DBA5A687CB6C836BF538EC81", hash_generated_field = "78564EACF73DB0AEDD2E075A8DFF1B13")

    private EntrySet entrySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.760 -0400", hash_original_field = "3E8ABCE844B6A8A95397486A3899B536", hash_generated_field = "455D81AE8BC4090CF8AD993E78862377")

    private KeySet keySet;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.761 -0400", hash_original_method = "A79D85B768A2B786B5F2ACD3F2B9D249", hash_generated_method = "CFE342F2F41F7796DB24A93B3EC5E9D4")
    @SuppressWarnings("unchecked")
    public  TreeMap() {
        this.comparator = (Comparator<? super K>) NATURAL_ORDER;
        // ---------- Original Method ----------
        //this.comparator = (Comparator<? super K>) NATURAL_ORDER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.813 -0400", hash_original_method = "317880CC1AD8B8CC7D9C11CC941EE8C3", hash_generated_method = "D5F7002165857F6E4A37D803A7EDC81E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.813 -0400", hash_original_method = "C1FE892CAD9D3780A675F5A8CA11F4FA", hash_generated_method = "A5FA904989BCCDB3DA871E0B26BCC9ED")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.858 -0400", hash_original_method = "2607F9CE6A88866DC32D385287E67644", hash_generated_method = "0D83ED9D530594A5ECD516091B277AF9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.859 -0400", hash_original_method = "FB8B1056739768AF92CF25DB3C2D30EB", hash_generated_method = "D5952C7AF4291949D38E3DEB729FEB03")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_693420321 = null; //Variable for return #1
        try 
        {
            @SuppressWarnings("unchecked") TreeMap<K, V> map;
            map = (TreeMap<K, V>) super.clone();
            map.root = root != null ? root.copy(null) : null;
            map.entrySet = null;
            map.keySet = null;
            varB4EAC82CA7396A68D541C85D26508E83_693420321 = map;
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_693420321.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_693420321;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.860 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "8B2098DDC9D5C90239E5E1896151984E")
    @Override
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_588458038 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_588458038;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.860 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "DA26A8957BB588505F3EF19EE2A0F689")
    @Override
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_743079537 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_743079537;
        // ---------- Original Method ----------
        //return size == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.860 -0400", hash_original_method = "C35732A40B74AF28951D9E96FE33879B", hash_generated_method = "E29B4C53352725A2CD0FC0953E7ADAE2")
    @Override
    public V get(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_2022669946 = null; //Variable for return #1
        Entry<K, V> entry;
        entry = findByObject(key);
        varB4EAC82CA7396A68D541C85D26508E83_2022669946 = entry != null ? entry.getValue() : null;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2022669946.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2022669946;
        // ---------- Original Method ----------
        //Entry<K, V> entry = findByObject(key);
        //return entry != null ? entry.getValue() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.861 -0400", hash_original_method = "CD38E6D478445847B9B0A556F5E63837", hash_generated_method = "087A53A85EB29D91A1C2568C4247CBAD")
    @Override
    public boolean containsKey(Object key) {
        boolean var169B170947F44477F294694A95E8B219_947114323 = (findByObject(key) != null);
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1573790422 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1573790422;
        // ---------- Original Method ----------
        //return findByObject(key) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.879 -0400", hash_original_method = "09423F07E68B4770E107529B69AA8334", hash_generated_method = "55DBE98F2B62457027453ACFADD8B076")
    @Override
    public V put(K key, V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_752084204 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_752084204 = putInternal(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_752084204.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_752084204;
        // ---------- Original Method ----------
        //return putInternal(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.880 -0400", hash_original_method = "EA5BE6ED678D7376259BCC3DB1C01E21", hash_generated_method = "25747B87C7C6F2CC69ED86A75548B960")
    @Override
    public void clear() {
        root = null;
        size = 0;
        // ---------- Original Method ----------
        //root = null;
        //size = 0;
        //modCount++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.880 -0400", hash_original_method = "0207194EB3BB344ADD94A18916C183DF", hash_generated_method = "2F0CD2DB5B1DB1F66120750A112ACBC6")
    @Override
    public V remove(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_583842466 = null; //Variable for return #1
        Node<K, V> node;
        node = removeInternalByKey(key);
        varB4EAC82CA7396A68D541C85D26508E83_583842466 = node != null ? node.value : null;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_583842466.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_583842466;
        // ---------- Original Method ----------
        //Node<K, V> node = removeInternalByKey(key);
        //return node != null ? node.value : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.881 -0400", hash_original_method = "73D5DA91D47B13631BBA1FF4FFC14006", hash_generated_method = "D0F3CDE454573147DD8BCF5E6160ECD0")
     V putInternal(K key, V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_254443638 = null; //Variable for return #1
        Node<K, V> created;
        created = find(key, Relation.CREATE);
        V result;
        result = created.value;
        created.value = value;
        varB4EAC82CA7396A68D541C85D26508E83_254443638 = result;
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_254443638.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_254443638;
        // ---------- Original Method ----------
        //Node<K, V> created = find(key, Relation.CREATE);
        //V result = created.value;
        //created.value = value;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.906 -0400", hash_original_method = "A47B461F1595004F5F78D5AE91E8DCD0", hash_generated_method = "5E073311E68DC1FB0FF67FFC52E19362")
     Node<K, V> find(K key, Relation relation) {
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_2055687940 = null; //Variable for return #1
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_447075256 = null; //Variable for return #2
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_73703548 = null; //Variable for return #3
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1454462140 = null; //Variable for return #4
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1566866005 = null; //Variable for return #5
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1890935044 = null; //Variable for return #6
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1476426246 = null; //Variable for return #7
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1080848081 = null; //Variable for return #8
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1601423899 = null; //Variable for return #9
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1316909629 = null; //Variable for return #10
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_224907671 = null; //Variable for return #11
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1754182870 = null; //Variable for return #12
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_635689454 = null; //Variable for return #13
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new ClassCastException(key.getClass().getName() + " is not Comparable");
            } //End block
            {
                root = new Node<K, V>(null, key);
                size = 1;
                varB4EAC82CA7396A68D541C85D26508E83_2055687940 = root;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_447075256 = null;
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
                varB4EAC82CA7396A68D541C85D26508E83_73703548 = nearest.prev();
                //End case LOWER 
                //Begin case FLOOR EQUAL CREATE CEILING 
                varB4EAC82CA7396A68D541C85D26508E83_1454462140 = nearest;
                //End case FLOOR EQUAL CREATE CEILING 
                //Begin case HIGHER 
                varB4EAC82CA7396A68D541C85D26508E83_1566866005 = nearest.next();
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
                varB4EAC82CA7396A68D541C85D26508E83_1890935044 = nearest.prev();
                //End case LOWER FLOOR 
                //Begin case CEILING HIGHER 
                varB4EAC82CA7396A68D541C85D26508E83_1476426246 = nearest;
                //End case CEILING HIGHER 
                //Begin case EQUAL 
                varB4EAC82CA7396A68D541C85D26508E83_1080848081 = null;
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
                varB4EAC82CA7396A68D541C85D26508E83_1601423899 = created;
                //End case CREATE 
            } //End block
            {
                //Begin case LOWER FLOOR 
                varB4EAC82CA7396A68D541C85D26508E83_1316909629 = nearest;
                //End case LOWER FLOOR 
                //Begin case CEILING HIGHER 
                varB4EAC82CA7396A68D541C85D26508E83_224907671 = nearest.next();
                //End case CEILING HIGHER 
                //Begin case EQUAL 
                varB4EAC82CA7396A68D541C85D26508E83_1754182870 = null;
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
                varB4EAC82CA7396A68D541C85D26508E83_635689454 = created;
                //End case CREATE 
            } //End block
        } //End block
        addTaint(relation.getTaint());
        Node<K, V> varA7E53CE21691AB073D9660D615818899_1039860520; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1039860520 = varB4EAC82CA7396A68D541C85D26508E83_2055687940;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1039860520 = varB4EAC82CA7396A68D541C85D26508E83_447075256;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1039860520 = varB4EAC82CA7396A68D541C85D26508E83_73703548;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1039860520 = varB4EAC82CA7396A68D541C85D26508E83_1454462140;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1039860520 = varB4EAC82CA7396A68D541C85D26508E83_1566866005;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_1039860520 = varB4EAC82CA7396A68D541C85D26508E83_1890935044;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_1039860520 = varB4EAC82CA7396A68D541C85D26508E83_1476426246;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_1039860520 = varB4EAC82CA7396A68D541C85D26508E83_1080848081;
                break;
            case 9: //Assign result for return ordinal #9
                varA7E53CE21691AB073D9660D615818899_1039860520 = varB4EAC82CA7396A68D541C85D26508E83_1601423899;
                break;
            case 10: //Assign result for return ordinal #10
                varA7E53CE21691AB073D9660D615818899_1039860520 = varB4EAC82CA7396A68D541C85D26508E83_1316909629;
                break;
            case 11: //Assign result for return ordinal #11
                varA7E53CE21691AB073D9660D615818899_1039860520 = varB4EAC82CA7396A68D541C85D26508E83_224907671;
                break;
            case 12: //Assign result for return ordinal #12
                varA7E53CE21691AB073D9660D615818899_1039860520 = varB4EAC82CA7396A68D541C85D26508E83_1754182870;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1039860520 = varB4EAC82CA7396A68D541C85D26508E83_635689454;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1039860520.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1039860520;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.909 -0400", hash_original_method = "C267D163E835004AE4803D9A2BC1E552", hash_generated_method = "EDBC0887F6EAEC555B517D4D192EF643")
    @SuppressWarnings("unchecked")
     Node<K, V> findByObject(Object key) {
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1173990549 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1173990549 = find((K) key, EQUAL);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1173990549.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1173990549;
        // ---------- Original Method ----------
        //return find((K) key, EQUAL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.928 -0400", hash_original_method = "8678505752B854905CFE7B96C4FE458B", hash_generated_method = "EDDFE2AB6D77019537433F8B03604C1D")
     Node<K, V> findByEntry(Entry<?, ?> entry) {
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1924820697 = null; //Variable for return #1
        Node<K, V> mine;
        mine = findByObject(entry.getKey());
        boolean valuesEqual;
        valuesEqual = mine != null && Objects.equal(mine.value, entry.getValue());
        varB4EAC82CA7396A68D541C85D26508E83_1924820697 = valuesEqual ? mine : null;
        addTaint(entry.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1924820697.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1924820697;
        // ---------- Original Method ----------
        //Node<K, V> mine = findByObject(entry.getKey());
        //boolean valuesEqual = mine != null && Objects.equal(mine.value, entry.getValue());
        //return valuesEqual ? mine : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.934 -0400", hash_original_method = "FAD76EC8E4C5DF9CCDE64BA514AC9743", hash_generated_method = "829F2DC186393E27F305515F02A5DD3D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.934 -0400", hash_original_method = "C9B9883A6728DC2F4DBB90BDF61B9978", hash_generated_method = "403ECE532CECA08B9ED3FDC8AD95CAA6")
     Node<K, V> removeInternalByKey(Object key) {
        Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1516821571 = null; //Variable for return #1
        Node<K, V> node;
        node = findByObject(key);
        {
            removeInternal(node);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1516821571 = node;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1516821571.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1516821571;
        // ---------- Original Method ----------
        //Node<K, V> node = findByObject(key);
        //if (node != null) {
            //removeInternal(node);
        //}
        //return node;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.935 -0400", hash_original_method = "8CBFE12E379E7871AFCE5B0FC5C284CB", hash_generated_method = "5D9C04E6B48B66D85F2051BBA336997D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.040 -0400", hash_original_method = "DE22B63E2A021BAF8A5DCC142FCC4B40", hash_generated_method = "41613B51E1B5900AA3F99F24B9CA38F2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.042 -0400", hash_original_method = "6326CB79DBF89391F00F9AB13B0E81D9", hash_generated_method = "29E24C70394F131BDC1B8808649E5575")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.051 -0400", hash_original_method = "DF035E309292DEA6067E726F513C85C3", hash_generated_method = "5541990C0BDCC254D68C4A2537F73601")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.061 -0400", hash_original_method = "E2F61A98BB539F90A11465C6A8354CE5", hash_generated_method = "28F61022C22B4B3CD39880D3CD472637")
    private SimpleImmutableEntry<K, V> immutableCopy(Entry<K, V> entry) {
        SimpleImmutableEntry<K, V> varB4EAC82CA7396A68D541C85D26508E83_376483897 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_376483897 = entry == null ? null : new SimpleImmutableEntry<K, V>(entry);
        addTaint(entry.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_376483897.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_376483897;
        // ---------- Original Method ----------
        //return entry == null ? null : new SimpleImmutableEntry<K, V>(entry);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.062 -0400", hash_original_method = "9F2AE61C584701540103A59451B8FA45", hash_generated_method = "5AB48E2DAEE8EE725ADD730E5322CFB1")
    public Entry<K, V> firstEntry() {
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_670419899 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_670419899 = immutableCopy(root == null ? null : root.first());
        varB4EAC82CA7396A68D541C85D26508E83_670419899.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_670419899;
        // ---------- Original Method ----------
        //return immutableCopy(root == null ? null : root.first());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.064 -0400", hash_original_method = "2730A7A2197248AC3B653DF430BA3F4A", hash_generated_method = "E814E73F098CF9D0EC8ABC809D81D02C")
    private Entry<K, V> internalPollFirstEntry() {
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1775466665 = null; //Variable for return #1
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1509371865 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1775466665 = null;
        } //End block
        Node<K, V> result;
        result = root.first();
        removeInternal(result);
        varB4EAC82CA7396A68D541C85D26508E83_1509371865 = result;
        Entry<K, V> varA7E53CE21691AB073D9660D615818899_2133499432; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2133499432 = varB4EAC82CA7396A68D541C85D26508E83_1775466665;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2133499432 = varB4EAC82CA7396A68D541C85D26508E83_1509371865;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2133499432.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2133499432;
        // ---------- Original Method ----------
        //if (root == null) {
            //return null;
        //}
        //Node<K, V> result = root.first();
        //removeInternal(result);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.064 -0400", hash_original_method = "1456A4986DE10120F25B46536C8BF169", hash_generated_method = "3A208C0F19B72CBCBAD0BBECCC7F8B9B")
    public Entry<K, V> pollFirstEntry() {
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_2092636266 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2092636266 = immutableCopy(internalPollFirstEntry());
        varB4EAC82CA7396A68D541C85D26508E83_2092636266.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2092636266;
        // ---------- Original Method ----------
        //return immutableCopy(internalPollFirstEntry());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.086 -0400", hash_original_method = "B0B89D697E050FAAC6816A6E8B1E56A4", hash_generated_method = "9C994903536C71A0ECED26A83587E83E")
    public K firstKey() {
        K varB4EAC82CA7396A68D541C85D26508E83_418191209 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_418191209 = root.first().getKey();
        varB4EAC82CA7396A68D541C85D26508E83_418191209.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_418191209;
        // ---------- Original Method ----------
        //if (root == null) {
            //throw new NoSuchElementException();
        //}
        //return root.first().getKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.087 -0400", hash_original_method = "9DDE470F0E6425136CCDC59F74FCDED6", hash_generated_method = "085C3F8F24DF0AFD0EDE3A1827313A0D")
    public Entry<K, V> lastEntry() {
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_747199602 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_747199602 = immutableCopy(root == null ? null : root.last());
        varB4EAC82CA7396A68D541C85D26508E83_747199602.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_747199602;
        // ---------- Original Method ----------
        //return immutableCopy(root == null ? null : root.last());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.088 -0400", hash_original_method = "A726E2736A4C282A51BDD8062FE5CCFA", hash_generated_method = "60BC2847289184E585603B1929F3FC01")
    private Entry<K, V> internalPollLastEntry() {
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_680613125 = null; //Variable for return #1
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_709776850 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_680613125 = null;
        } //End block
        Node<K, V> result;
        result = root.last();
        removeInternal(result);
        varB4EAC82CA7396A68D541C85D26508E83_709776850 = result;
        Entry<K, V> varA7E53CE21691AB073D9660D615818899_995630139; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_995630139 = varB4EAC82CA7396A68D541C85D26508E83_680613125;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_995630139 = varB4EAC82CA7396A68D541C85D26508E83_709776850;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_995630139.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_995630139;
        // ---------- Original Method ----------
        //if (root == null) {
            //return null;
        //}
        //Node<K, V> result = root.last();
        //removeInternal(result);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.088 -0400", hash_original_method = "5064879999AB9A13D0821F605568F112", hash_generated_method = "30D3D452B85CDAC8D77AE1042447717F")
    public Entry<K, V> pollLastEntry() {
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_572662814 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_572662814 = immutableCopy(internalPollLastEntry());
        varB4EAC82CA7396A68D541C85D26508E83_572662814.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_572662814;
        // ---------- Original Method ----------
        //return immutableCopy(internalPollLastEntry());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.103 -0400", hash_original_method = "9EE1928205B19C964D03E8011BB7E907", hash_generated_method = "098A1C5FC5581409059CD1B1F50594E9")
    public K lastKey() {
        K varB4EAC82CA7396A68D541C85D26508E83_349054070 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_349054070 = root.last().getKey();
        varB4EAC82CA7396A68D541C85D26508E83_349054070.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_349054070;
        // ---------- Original Method ----------
        //if (root == null) {
            //throw new NoSuchElementException();
        //}
        //return root.last().getKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.104 -0400", hash_original_method = "9D71F38DCAD7DBC2AA9FACCDA9CF4866", hash_generated_method = "6C5ADD9AB732695F4AACFE0D37B47441")
    public Entry<K, V> lowerEntry(K key) {
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1027116804 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1027116804 = immutableCopy(find(key, LOWER));
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1027116804.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1027116804;
        // ---------- Original Method ----------
        //return immutableCopy(find(key, LOWER));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.104 -0400", hash_original_method = "BC9464ECC7239B355BB45B80204BADD6", hash_generated_method = "6CBE6829BD5202C204CF3F67899D0564")
    public K lowerKey(K key) {
        K varB4EAC82CA7396A68D541C85D26508E83_87646374 = null; //Variable for return #1
        Entry<K, V> entry;
        entry = find(key, LOWER);
        varB4EAC82CA7396A68D541C85D26508E83_87646374 = entry != null ? entry.getKey() : null;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_87646374.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_87646374;
        // ---------- Original Method ----------
        //Entry<K, V> entry = find(key, LOWER);
        //return entry != null ? entry.getKey() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.106 -0400", hash_original_method = "5D12D4D534218428856149792C7C973A", hash_generated_method = "A16FC20174AA0EE4EA0519CF6D4DA554")
    public Entry<K, V> floorEntry(K key) {
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1170164737 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1170164737 = immutableCopy(find(key, FLOOR));
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1170164737.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1170164737;
        // ---------- Original Method ----------
        //return immutableCopy(find(key, FLOOR));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.106 -0400", hash_original_method = "9E3521C1E5D0BB4CA97E65B4B91FC561", hash_generated_method = "B82B61273AED729FA19EE3EA1D6B6E86")
    public K floorKey(K key) {
        K varB4EAC82CA7396A68D541C85D26508E83_1830090708 = null; //Variable for return #1
        Entry<K, V> entry;
        entry = find(key, FLOOR);
        varB4EAC82CA7396A68D541C85D26508E83_1830090708 = entry != null ? entry.getKey() : null;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1830090708.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1830090708;
        // ---------- Original Method ----------
        //Entry<K, V> entry = find(key, FLOOR);
        //return entry != null ? entry.getKey() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.136 -0400", hash_original_method = "14BBCA12BBBC651385215255CDF3836D", hash_generated_method = "13A3A89F2C81775DF91A4A6F77146086")
    public Entry<K, V> ceilingEntry(K key) {
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1381323414 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1381323414 = immutableCopy(find(key, CEILING));
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1381323414.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1381323414;
        // ---------- Original Method ----------
        //return immutableCopy(find(key, CEILING));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.136 -0400", hash_original_method = "818E984E93F7F07D0C27D2493F11C2A5", hash_generated_method = "9841646EDA1C56AAAAF09CD9EA15CEB6")
    public K ceilingKey(K key) {
        K varB4EAC82CA7396A68D541C85D26508E83_2105406979 = null; //Variable for return #1
        Entry<K, V> entry;
        entry = find(key, CEILING);
        varB4EAC82CA7396A68D541C85D26508E83_2105406979 = entry != null ? entry.getKey() : null;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2105406979.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2105406979;
        // ---------- Original Method ----------
        //Entry<K, V> entry = find(key, CEILING);
        //return entry != null ? entry.getKey() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.137 -0400", hash_original_method = "AC2414FDDF42A1318F8CC45C80E09BC1", hash_generated_method = "F813A81BEC077D85AFE21468C72317F5")
    public Entry<K, V> higherEntry(K key) {
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1562504115 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1562504115 = immutableCopy(find(key, HIGHER));
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1562504115.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1562504115;
        // ---------- Original Method ----------
        //return immutableCopy(find(key, HIGHER));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.138 -0400", hash_original_method = "0C080E769BA3B62EBC93442ECCB0FC7D", hash_generated_method = "364C847256E8075C7F6A123C9CDD9B04")
    public K higherKey(K key) {
        K varB4EAC82CA7396A68D541C85D26508E83_743838104 = null; //Variable for return #1
        Entry<K, V> entry;
        entry = find(key, HIGHER);
        varB4EAC82CA7396A68D541C85D26508E83_743838104 = entry != null ? entry.getKey() : null;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_743838104.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_743838104;
        // ---------- Original Method ----------
        //Entry<K, V> entry = find(key, HIGHER);
        //return entry != null ? entry.getKey() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.139 -0400", hash_original_method = "6A8618E17145F23513711DA8498038AE", hash_generated_method = "13104699E439DAAB310EF9AE40A00EA8")
    public Comparator<? super K> comparator() {
        Comparator<? super K> varB4EAC82CA7396A68D541C85D26508E83_1362520676 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1362520676 = comparator != NATURAL_ORDER ? comparator : null;
        varB4EAC82CA7396A68D541C85D26508E83_1362520676.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1362520676;
        // ---------- Original Method ----------
        //return comparator != NATURAL_ORDER ? comparator : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.143 -0400", hash_original_method = "D2C4C51D99D6D10356C2F96D116110D2", hash_generated_method = "2BDE35CA34E827BB86FB5D58183419DE")
    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_277614557 = null; //Variable for return #1
        EntrySet result;
        result = entrySet;
        varB4EAC82CA7396A68D541C85D26508E83_277614557 = result != null ? result : (entrySet = new EntrySet());
        varB4EAC82CA7396A68D541C85D26508E83_277614557.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_277614557;
        // ---------- Original Method ----------
        //EntrySet result = entrySet;
        //return result != null ? result : (entrySet = new EntrySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.147 -0400", hash_original_method = "0E17D4043440FAA66222611D1AC45111", hash_generated_method = "6292445A2E2442A5530F6D4CFFA38A1C")
    @Override
    public Set<K> keySet() {
        Set<K> varB4EAC82CA7396A68D541C85D26508E83_1173020519 = null; //Variable for return #1
        KeySet result;
        result = keySet;
        varB4EAC82CA7396A68D541C85D26508E83_1173020519 = result != null ? result : (keySet = new KeySet());
        varB4EAC82CA7396A68D541C85D26508E83_1173020519.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1173020519;
        // ---------- Original Method ----------
        //KeySet result = keySet;
        //return result != null ? result : (keySet = new KeySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.162 -0400", hash_original_method = "016115EA38C293C7AAA8E892AEA754CA", hash_generated_method = "CC0B66F5ED542A7328B86390EA4CC1BA")
    public NavigableSet<K> navigableKeySet() {
        NavigableSet<K> varB4EAC82CA7396A68D541C85D26508E83_2011577148 = null; //Variable for return #1
        KeySet result;
        result = keySet;
        varB4EAC82CA7396A68D541C85D26508E83_2011577148 = result != null ? result : (keySet = new KeySet());
        varB4EAC82CA7396A68D541C85D26508E83_2011577148.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2011577148;
        // ---------- Original Method ----------
        //KeySet result = keySet;
        //return result != null ? result : (keySet = new KeySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.163 -0400", hash_original_method = "DA6DE2093EE8DE46EE4576501F54E528", hash_generated_method = "EC1157DB71467DAAF9C2B8A322E06CBA")
    public NavigableMap<K, V> subMap(K from, boolean fromInclusive, K to, boolean toInclusive) {
        NavigableMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_1412209106 = null; //Variable for return #1
        Bound fromBound;
        fromBound = INCLUSIVE;
        fromBound = EXCLUSIVE;
        Bound toBound;
        toBound = INCLUSIVE;
        toBound = EXCLUSIVE;
        varB4EAC82CA7396A68D541C85D26508E83_1412209106 = new BoundedMap(true, from, fromBound, to, toBound);
        addTaint(from.getTaint());
        addTaint(fromInclusive);
        addTaint(to.getTaint());
        addTaint(toInclusive);
        varB4EAC82CA7396A68D541C85D26508E83_1412209106.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1412209106;
        // ---------- Original Method ----------
        //Bound fromBound = fromInclusive ? INCLUSIVE : EXCLUSIVE;
        //Bound toBound = toInclusive ? INCLUSIVE : EXCLUSIVE;
        //return new BoundedMap(true, from, fromBound, to, toBound);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.164 -0400", hash_original_method = "193BA03007E91EBBDB489C20B60BFC88", hash_generated_method = "758E7C3124D39B749795C871B448E71F")
    public SortedMap<K, V> subMap(K fromInclusive, K toExclusive) {
        SortedMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_2135539294 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2135539294 = new BoundedMap(true, fromInclusive, INCLUSIVE, toExclusive, EXCLUSIVE);
        addTaint(fromInclusive.getTaint());
        addTaint(toExclusive.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2135539294.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2135539294;
        // ---------- Original Method ----------
        //return new BoundedMap(true, fromInclusive, INCLUSIVE, toExclusive, EXCLUSIVE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.168 -0400", hash_original_method = "FA312E74B0C04D741489E3323E0FFDFE", hash_generated_method = "593A8A280FFFB020497775CCC8521A1C")
    public NavigableMap<K, V> headMap(K to, boolean inclusive) {
        NavigableMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_791188867 = null; //Variable for return #1
        Bound toBound;
        toBound = INCLUSIVE;
        toBound = EXCLUSIVE;
        varB4EAC82CA7396A68D541C85D26508E83_791188867 = new BoundedMap(true, null, NO_BOUND, to, toBound);
        addTaint(to.getTaint());
        addTaint(inclusive);
        varB4EAC82CA7396A68D541C85D26508E83_791188867.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_791188867;
        // ---------- Original Method ----------
        //Bound toBound = inclusive ? INCLUSIVE : EXCLUSIVE;
        //return new BoundedMap(true, null, NO_BOUND, to, toBound);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.197 -0400", hash_original_method = "CAC178CA3C39A0AC08FB27C63F9A635C", hash_generated_method = "E692D486D9FB75F08BEE6767A38BD5AE")
    public SortedMap<K, V> headMap(K toExclusive) {
        SortedMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_10703893 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_10703893 = new BoundedMap(true, null, NO_BOUND, toExclusive, EXCLUSIVE);
        addTaint(toExclusive.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_10703893.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_10703893;
        // ---------- Original Method ----------
        //return new BoundedMap(true, null, NO_BOUND, toExclusive, EXCLUSIVE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.198 -0400", hash_original_method = "828BC950C20B857C189141DA99499F09", hash_generated_method = "BB3D4861EE99828EF637EAF348DB7399")
    public NavigableMap<K, V> tailMap(K from, boolean inclusive) {
        NavigableMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_399468908 = null; //Variable for return #1
        Bound fromBound;
        fromBound = INCLUSIVE;
        fromBound = EXCLUSIVE;
        varB4EAC82CA7396A68D541C85D26508E83_399468908 = new BoundedMap(true, from, fromBound, null, NO_BOUND);
        addTaint(from.getTaint());
        addTaint(inclusive);
        varB4EAC82CA7396A68D541C85D26508E83_399468908.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_399468908;
        // ---------- Original Method ----------
        //Bound fromBound = inclusive ? INCLUSIVE : EXCLUSIVE;
        //return new BoundedMap(true, from, fromBound, null, NO_BOUND);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.198 -0400", hash_original_method = "79B47D2E0956F27B23E0B18E5FD19D6A", hash_generated_method = "468C9D343DCACD465800CE264E16F757")
    public SortedMap<K, V> tailMap(K fromInclusive) {
        SortedMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_2035670714 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2035670714 = new BoundedMap(true, fromInclusive, INCLUSIVE, null, NO_BOUND);
        addTaint(fromInclusive.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2035670714.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2035670714;
        // ---------- Original Method ----------
        //return new BoundedMap(true, fromInclusive, INCLUSIVE, null, NO_BOUND);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.199 -0400", hash_original_method = "5AD6A5A37D3C9366BEF11B75DC396D31", hash_generated_method = "D1D90E4847FD1B7DA0A17643E665CA62")
    public NavigableMap<K, V> descendingMap() {
        NavigableMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_126591233 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_126591233 = new BoundedMap(false, null, NO_BOUND, null, NO_BOUND);
        varB4EAC82CA7396A68D541C85D26508E83_126591233.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_126591233;
        // ---------- Original Method ----------
        //return new BoundedMap(false, null, NO_BOUND, null, NO_BOUND);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.199 -0400", hash_original_method = "1207DF79B9959BCB242E95030D6177B0", hash_generated_method = "7A0E6A0AE9FCB9BA103D535C90FA9D08")
    public NavigableSet<K> descendingKeySet() {
        NavigableSet<K> varB4EAC82CA7396A68D541C85D26508E83_1572034429 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1572034429 = new BoundedMap(false, null, NO_BOUND, null, NO_BOUND).navigableKeySet();
        varB4EAC82CA7396A68D541C85D26508E83_1572034429.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1572034429;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.314 -0400", hash_original_method = "BF81D129CE69F9BEB40CAD27F974F3C8", hash_generated_method = "E9A000D4C57F2AB4815C02434EFADFCD")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.putFields().put("comparator", comparator != NATURAL_ORDER ? comparator : null);
        stream.writeFields();
        stream.writeInt(size);
        {
            Iterator<Map.Entry<K, V>> var40A6EBFD1C8AB95DF2D9F4B462803CBE_1807478970 = (entrySet()).iterator();
            var40A6EBFD1C8AB95DF2D9F4B462803CBE_1807478970.hasNext();
            Map.Entry<K, V> entry = var40A6EBFD1C8AB95DF2D9F4B462803CBE_1807478970.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.328 -0400", hash_original_method = "4DE82E48A11AFCCB2DCFEAE704B1F475", hash_generated_method = "A6862155C8797DD5C5DCDADAA69B5495")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.328 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "8813BD57943FF9B7DFC4722D0BF25C24")

        Node<K, V> parent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.328 -0400", hash_original_field = "811882FECD5C7618D7099EBBD39EA254", hash_generated_field = "25F53C0BDEE77B7CD3BD6D035AA5E15F")

        Node<K, V> left;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.328 -0400", hash_original_field = "7C4F29407893C334A6CB7A87BF045C0D", hash_generated_field = "37DD2CA6D859801A463F8F880FD4F30D")

        Node<K, V> right;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.328 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "F780C5984CF24E477CB9559E91475987")

        K key;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.329 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "A7E8A049E4C72FD5713D3AFD6CBF7C08")

        V value;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.329 -0400", hash_original_field = "B435E227D5DD201E1768B2BCB2E0AA81", hash_generated_field = "CE84F1587D182C1F0A32D7CD44443A18")

        int height;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.329 -0400", hash_original_method = "62891C3DA898C4CAE2A216E3248BC6D0", hash_generated_method = "DE342B9B0B30391F4646033D3553010C")
          Node(Node<K, V> parent, K key) {
            this.parent = parent;
            this.key = key;
            this.height = 1;
            // ---------- Original Method ----------
            //this.parent = parent;
            //this.key = key;
            //this.height = 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.339 -0400", hash_original_method = "81E3C4E28B5839A0B87A03CA341E9BD1", hash_generated_method = "746130FD26DC227E4E6DBA37336B2D15")
         Node<K, V> copy(Node<K, V> parent) {
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_298028960 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_298028960 = result;
            addTaint(parent.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_298028960.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_298028960;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.344 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "174EC81D76D499F25F2868670FD01F19")
        public K getKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_178374200 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_178374200 = key;
            varB4EAC82CA7396A68D541C85D26508E83_178374200.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_178374200;
            // ---------- Original Method ----------
            //return key;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.366 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "5264057936A60B37FED235A3B5227B0A")
        public V getValue() {
            V varB4EAC82CA7396A68D541C85D26508E83_626265389 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_626265389 = value;
            varB4EAC82CA7396A68D541C85D26508E83_626265389.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_626265389;
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.367 -0400", hash_original_method = "B73895AEE255DB24C138E57D2456050E", hash_generated_method = "7D957110D61C54E098FEF4FDF761F0DD")
        public V setValue(V value) {
            V varB4EAC82CA7396A68D541C85D26508E83_39133181 = null; //Variable for return #1
            V oldValue;
            oldValue = this.value;
            this.value = value;
            varB4EAC82CA7396A68D541C85D26508E83_39133181 = oldValue;
            varB4EAC82CA7396A68D541C85D26508E83_39133181.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_39133181;
            // ---------- Original Method ----------
            //V oldValue = this.value;
            //this.value = value;
            //return oldValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.367 -0400", hash_original_method = "08E0671CAB8873A0A05165CE64371DB8", hash_generated_method = "D7603C793B59681182365A31922C15CD")
        @Override
        public boolean equals(Object o) {
            {
                Map.Entry other;
                other = (Map.Entry) o;
                boolean var7912CC5897005EB768B2514BECBB8DA1_1750837321 = ((key == null ? other.getKey() == null : key.equals(other.getKey()))
                        && (value == null ? other.getValue() == null : value.equals(other.getValue()))); //DSFIXME:  CODE0008: Nested ternary operator in expression
            } //End block
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_592203043 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_592203043;
            // ---------- Original Method ----------
            //if (o instanceof Map.Entry) {
                //Map.Entry other = (Map.Entry) o;
                //return (key == null ? other.getKey() == null : key.equals(other.getKey()))
                        //&& (value == null ? other.getValue() == null : value.equals(other.getValue()));
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.367 -0400", hash_original_method = "6416487D313DFCFD3052C01ADB883217", hash_generated_method = "2B78BC82777DF31E0AE8BFAC8FBA9E1C")
        @Override
        public int hashCode() {
            int var4B5981580A705D92ADA4BF72B6E1E3C5_1516243261 = ((key == null ? 0 : key.hashCode())
                    ^ (value == null ? 0 : value.hashCode())); //DSFIXME:  CODE0008: Nested ternary operator in expression
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_554216948 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_554216948;
            // ---------- Original Method ----------
            //return (key == null ? 0 : key.hashCode())
                    //^ (value == null ? 0 : value.hashCode());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.368 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "9DE7777B206312F8A8D9C2F97E554562")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1265526827 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1265526827 = key + "=" + value;
            varB4EAC82CA7396A68D541C85D26508E83_1265526827.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1265526827;
            // ---------- Original Method ----------
            //return key + "=" + value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.385 -0400", hash_original_method = "4A8921E3C940E88A3EF0004D6F064697", hash_generated_method = "0A78B519DEF18A56F006A0E57EBAE400")
         Node<K, V> next() {
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1835044343 = null; //Variable for return #1
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1880064116 = null; //Variable for return #2
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_324258435 = null; //Variable for return #3
            {
                varB4EAC82CA7396A68D541C85D26508E83_1835044343 = right.first();
            } //End block
            Node<K, V> node;
            node = this;
            Node<K, V> parent;
            parent = node.parent;
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1880064116 = parent;
                } //End block
                node = parent;
                parent = node.parent;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_324258435 = null;
            Node<K, V> varA7E53CE21691AB073D9660D615818899_1143920795; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1143920795 = varB4EAC82CA7396A68D541C85D26508E83_1835044343;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_1143920795 = varB4EAC82CA7396A68D541C85D26508E83_1880064116;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1143920795 = varB4EAC82CA7396A68D541C85D26508E83_324258435;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1143920795.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1143920795;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.386 -0400", hash_original_method = "A5795D04699EE4D7981584600E0900FB", hash_generated_method = "9417C4AFFAEFE53390FC406BB5ADD70D")
        public Node<K, V> prev() {
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1301698205 = null; //Variable for return #1
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1210643816 = null; //Variable for return #2
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1402336919 = null; //Variable for return #3
            {
                varB4EAC82CA7396A68D541C85D26508E83_1301698205 = left.last();
            } //End block
            Node<K, V> node;
            node = this;
            Node<K, V> parent;
            parent = node.parent;
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1210643816 = parent;
                } //End block
                node = parent;
                parent = node.parent;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1402336919 = null;
            Node<K, V> varA7E53CE21691AB073D9660D615818899_91825040; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_91825040 = varB4EAC82CA7396A68D541C85D26508E83_1301698205;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_91825040 = varB4EAC82CA7396A68D541C85D26508E83_1210643816;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_91825040 = varB4EAC82CA7396A68D541C85D26508E83_1402336919;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_91825040.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_91825040;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.387 -0400", hash_original_method = "4F7C0267C30B98E081694FF304478F8A", hash_generated_method = "5FEE33AD0EA4A6103C2C850284566EE7")
        public Node<K, V> first() {
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1130395481 = null; //Variable for return #1
            Node<K, V> node;
            node = this;
            Node<K, V> child;
            child = node.left;
            {
                node = child;
                child = node.left;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1130395481 = node;
            varB4EAC82CA7396A68D541C85D26508E83_1130395481.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1130395481;
            // ---------- Original Method ----------
            //Node<K, V> node = this;
            //Node<K, V> child = node.left;
            //while (child != null) {
                //node = child;
                //child = node.left;
            //}
            //return node;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.402 -0400", hash_original_method = "E5BF79B4B513B5631F4BBC9604CA3FC9", hash_generated_method = "0817BC618D7A1B71A6815283BB7F8785")
        public Node<K, V> last() {
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_233571363 = null; //Variable for return #1
            Node<K, V> node;
            node = this;
            Node<K, V> child;
            child = node.right;
            {
                node = child;
                child = node.right;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_233571363 = node;
            varB4EAC82CA7396A68D541C85D26508E83_233571363.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_233571363;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.402 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "4E383A6783C389E295874CEC0140061D")

        protected Node<K, V> next;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.402 -0400", hash_original_field = "98BD1C45684CF587AC2347A92DD7BB51", hash_generated_field = "A9411E67538F8DD40B9344B2A6DD22CB")

        protected Node<K, V> last;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.402 -0400", hash_original_field = "587E194BCD330DA9D6CB9DB53EA8709A", hash_generated_field = "AB0DDF01BBCC99511DA5FB1867F9AF26")

        protected int expectedModCount = modCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.403 -0400", hash_original_method = "1934503C2038D80E73C2C0A3DE09B0C3", hash_generated_method = "8E0327A33AFF8D45EE12C60F2FAE7675")
          MapIterator(Node<K, V> next) {
            this.next = next;
            // ---------- Original Method ----------
            //this.next = next;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.403 -0400", hash_original_method = "5C1B7B0DA20667590A4D5C5559468A28", hash_generated_method = "E4D033EFD39EAE1CE85E4E6303C9EFE5")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_404768930 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_404768930;
            // ---------- Original Method ----------
            //return next != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.408 -0400", hash_original_method = "85C80BB4AD318538DB8131E722149B15", hash_generated_method = "87B45192B465723ED225B75CFCB294FF")
        protected Node<K, V> stepForward() {
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1679711420 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            } //End block
            last = next;
            next = next.next();
            varB4EAC82CA7396A68D541C85D26508E83_1679711420 = last;
            varB4EAC82CA7396A68D541C85D26508E83_1679711420.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1679711420;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.421 -0400", hash_original_method = "A54C5D61E9DBD724A09A36F78C304124", hash_generated_method = "C4FBC65E1380CAAE53E9BCC8619727A0")
        protected Node<K, V> stepBackward() {
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_587793547 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            } //End block
            last = next;
            next = next.prev();
            varB4EAC82CA7396A68D541C85D26508E83_587793547 = last;
            varB4EAC82CA7396A68D541C85D26508E83_587793547.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_587793547;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.422 -0400", hash_original_method = "36CB2F7F3A40368DEE67850156136E6A", hash_generated_method = "68E79A243AD9DF221A3356BB1D7AE83F")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.422 -0400", hash_original_method = "AA90B2AD56C6E037D76F6D8ACC9327A5", hash_generated_method = "AA90B2AD56C6E037D76F6D8ACC9327A5")
        public EntrySet ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.422 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "FB502B8DB06B74D83FE034CE0520F2C8")
        @Override
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1977113486 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1977113486;
            // ---------- Original Method ----------
            //return size;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.423 -0400", hash_original_method = "B4D4FA13F54A295418FF58C47A14DDE9", hash_generated_method = "354C2CC948152E82EE5DA972E7447741")
        @Override
        public Iterator<Entry<K, V>> iterator() {
            Iterator<Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_1667188327 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1667188327 = new MapIterator<Entry<K, V>>(root == null ? null : root.first()) {
                public Entry<K, V> next() {
                    return stepForward();
                }
            };
            varB4EAC82CA7396A68D541C85D26508E83_1667188327.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1667188327;
            // ---------- Original Method ----------
            //return new MapIterator<Entry<K, V>>(root == null ? null : root.first()) {
                //public Entry<K, V> next() {
                    //return stepForward();
                //}
            //};
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.436 -0400", hash_original_method = "AAE5A29808B951CC80BD03F648B6A63A", hash_generated_method = "1B49D75FECE5B31A3E254CF2A0A748A8")
        @Override
        public boolean contains(Object o) {
            boolean var12117A785F30278636E2FCE711DC72F4_129803034 = (o instanceof Entry && findByEntry((Entry<?, ?>) o) != null);
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1073218312 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1073218312;
            // ---------- Original Method ----------
            //return o instanceof Entry && findByEntry((Entry<?, ?>) o) != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.437 -0400", hash_original_method = "50402191313F22EA9CF206F14CC9A5A4", hash_generated_method = "CB3A6983E05A03348601E9BC9DDBB7F2")
        @Override
        public boolean remove(Object o) {
            Node<K, V> node;
            node = findByEntry((Entry<?, ?>) o);
            removeInternal(node);
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_726091678 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_726091678;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.438 -0400", hash_original_method = "1CC2A082C181027407DFF573950B6D85", hash_generated_method = "E132377B1C3D8FD49066BD79A34C72A8")
        @Override
        public void clear() {
            TreeMap.this.clear();
            // ---------- Original Method ----------
            //TreeMap.this.clear();
        }

        
    }


    
    class KeySet extends AbstractSet<K> implements NavigableSet<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.438 -0400", hash_original_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF", hash_generated_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF")
        public KeySet ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.438 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "F4B7022C185F6BDA669EAF4D835ED4D0")
        @Override
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1122051493 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1122051493;
            // ---------- Original Method ----------
            //return size;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.454 -0400", hash_original_method = "7A518595D7BAAD9E696AF11FE92FFDBE", hash_generated_method = "66B2BA53613BBEE602C70001856D7278")
        @Override
        public Iterator<K> iterator() {
            Iterator<K> varB4EAC82CA7396A68D541C85D26508E83_530786803 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_530786803 = new MapIterator<K>(root == null ? null : root.first()) {
                public K next() {
                    return stepForward().key;
                }
            };
            varB4EAC82CA7396A68D541C85D26508E83_530786803.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_530786803;
            // ---------- Original Method ----------
            //return new MapIterator<K>(root == null ? null : root.first()) {
                //public K next() {
                    //return stepForward().key;
                //}
            //};
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.455 -0400", hash_original_method = "C8D968F3C5FE84BB3D2A53544A3D4B19", hash_generated_method = "57371E8263567EDC5201E383B4AFF949")
        public Iterator<K> descendingIterator() {
            Iterator<K> varB4EAC82CA7396A68D541C85D26508E83_535909122 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_535909122 = new MapIterator<K>(root == null ? null : root.last()) {
                public K next() {
                    return stepBackward().key;
                }
            };
            varB4EAC82CA7396A68D541C85D26508E83_535909122.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_535909122;
            // ---------- Original Method ----------
            //return new MapIterator<K>(root == null ? null : root.last()) {
                //public K next() {
                    //return stepBackward().key;
                //}
            //};
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.455 -0400", hash_original_method = "55474555B71DFC8666AC2B6E4F0261A5", hash_generated_method = "6034C12F80CCE43C43A97F90A76F2E3D")
        @Override
        public boolean contains(Object o) {
            boolean var997BAB39B2F072D5CD66A271F3B6E196_775594252 = (containsKey(o));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1773506478 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1773506478;
            // ---------- Original Method ----------
            //return containsKey(o);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.456 -0400", hash_original_method = "174345B10BAB0003712B28F94B9BEA53", hash_generated_method = "CA119B39B7003B3642023C2B80BD804B")
        @Override
        public boolean remove(Object key) {
            boolean varE16D747D3226990FB8F8723539274182_1460386086 = (removeInternalByKey(key) != null);
            addTaint(key.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_937117151 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_937117151;
            // ---------- Original Method ----------
            //return removeInternalByKey(key) != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.457 -0400", hash_original_method = "1CC2A082C181027407DFF573950B6D85", hash_generated_method = "E132377B1C3D8FD49066BD79A34C72A8")
        @Override
        public void clear() {
            TreeMap.this.clear();
            // ---------- Original Method ----------
            //TreeMap.this.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.457 -0400", hash_original_method = "E1A1305471DEE1FE749764F6E03BE3A0", hash_generated_method = "FA2A703CC23F29CE172BC54597F850DF")
        public Comparator<? super K> comparator() {
            Comparator<? super K> varB4EAC82CA7396A68D541C85D26508E83_254927657 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_254927657 = TreeMap.this.comparator();
            varB4EAC82CA7396A68D541C85D26508E83_254927657.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_254927657;
            // ---------- Original Method ----------
            //return TreeMap.this.comparator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.461 -0400", hash_original_method = "3067DEE01FBBBFD061436C7D4561F434", hash_generated_method = "394997E46671D2651CCA73374EF81883")
        public K first() {
            K varB4EAC82CA7396A68D541C85D26508E83_1973624357 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1973624357 = firstKey();
            varB4EAC82CA7396A68D541C85D26508E83_1973624357.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1973624357;
            // ---------- Original Method ----------
            //return firstKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.480 -0400", hash_original_method = "39C87F788E647BCD3FB86FFF34D7EF10", hash_generated_method = "18709D716EE1742A51A5E6D4E4EEAC4B")
        public K last() {
            K varB4EAC82CA7396A68D541C85D26508E83_2128432469 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2128432469 = lastKey();
            varB4EAC82CA7396A68D541C85D26508E83_2128432469.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2128432469;
            // ---------- Original Method ----------
            //return lastKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.481 -0400", hash_original_method = "5CFE05BF706A06BBB501067306F1B9ED", hash_generated_method = "23A9A99F0626664BA77CC7B437DBDAC7")
        public K lower(K key) {
            K varB4EAC82CA7396A68D541C85D26508E83_1640735106 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1640735106 = lowerKey(key);
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1640735106.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1640735106;
            // ---------- Original Method ----------
            //return lowerKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.481 -0400", hash_original_method = "10BABB7BB2E837824A13AAE89EE7EC6F", hash_generated_method = "FCD5F60964A88B8947E573FC9B24D55A")
        public K floor(K key) {
            K varB4EAC82CA7396A68D541C85D26508E83_75393776 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_75393776 = floorKey(key);
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_75393776.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_75393776;
            // ---------- Original Method ----------
            //return floorKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.482 -0400", hash_original_method = "2AD4706A6D818B709A1E2CA64B48B4B9", hash_generated_method = "5562492C1D3FA8A759FA641BCDB7974F")
        public K ceiling(K key) {
            K varB4EAC82CA7396A68D541C85D26508E83_893649480 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_893649480 = ceilingKey(key);
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_893649480.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_893649480;
            // ---------- Original Method ----------
            //return ceilingKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.482 -0400", hash_original_method = "8CC63649234BFC57DB10A2387AE34DD6", hash_generated_method = "332231079BA14D9E27ACA435597181D8")
        public K higher(K key) {
            K varB4EAC82CA7396A68D541C85D26508E83_1278730216 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1278730216 = higherKey(key);
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1278730216.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1278730216;
            // ---------- Original Method ----------
            //return higherKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.483 -0400", hash_original_method = "0E3C9584B722234668005FBA598A1EC0", hash_generated_method = "220930BFD7B4BEC7D1266BBF340FB55B")
        public K pollFirst() {
            K varB4EAC82CA7396A68D541C85D26508E83_1875695914 = null; //Variable for return #1
            Entry<K, V> entry;
            entry = internalPollFirstEntry();
            varB4EAC82CA7396A68D541C85D26508E83_1875695914 = entry != null ? entry.getKey() : null;
            varB4EAC82CA7396A68D541C85D26508E83_1875695914.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1875695914;
            // ---------- Original Method ----------
            //Entry<K, V> entry = internalPollFirstEntry();
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.483 -0400", hash_original_method = "ABD0A1CFCFA4D3D1F242F2375F97811C", hash_generated_method = "6407F44028BA2ADF463D502C24B786FB")
        public K pollLast() {
            K varB4EAC82CA7396A68D541C85D26508E83_4440206 = null; //Variable for return #1
            Entry<K, V> entry;
            entry = internalPollLastEntry();
            varB4EAC82CA7396A68D541C85D26508E83_4440206 = entry != null ? entry.getKey() : null;
            varB4EAC82CA7396A68D541C85D26508E83_4440206.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_4440206;
            // ---------- Original Method ----------
            //Entry<K, V> entry = internalPollLastEntry();
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.497 -0400", hash_original_method = "21828DA90728B75367EF3BEE7D62C832", hash_generated_method = "FBCC20573443269E240ED7C3F725556A")
        public NavigableSet<K> subSet(K from, boolean fromInclusive, K to, boolean toInclusive) {
            NavigableSet<K> varB4EAC82CA7396A68D541C85D26508E83_1307472118 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1307472118 = TreeMap.this.subMap(from, fromInclusive, to, toInclusive).navigableKeySet();
            addTaint(from.getTaint());
            addTaint(fromInclusive);
            addTaint(to.getTaint());
            addTaint(toInclusive);
            varB4EAC82CA7396A68D541C85D26508E83_1307472118.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1307472118;
            // ---------- Original Method ----------
            //return TreeMap.this.subMap(from, fromInclusive, to, toInclusive).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.498 -0400", hash_original_method = "B37C6130D4B0113815E317EEB111D1E9", hash_generated_method = "0F342E490AAA70F8AAC9E37619F94516")
        public SortedSet<K> subSet(K fromInclusive, K toExclusive) {
            SortedSet<K> varB4EAC82CA7396A68D541C85D26508E83_2037566648 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2037566648 = TreeMap.this.subMap(fromInclusive, true, toExclusive, false).navigableKeySet();
            addTaint(fromInclusive.getTaint());
            addTaint(toExclusive.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2037566648.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2037566648;
            // ---------- Original Method ----------
            //return TreeMap.this.subMap(fromInclusive, true, toExclusive, false).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.511 -0400", hash_original_method = "15C518A93EE21ED6E81237BD492369B4", hash_generated_method = "4572F69C0543CA12CC7981CA12C792E6")
        public NavigableSet<K> headSet(K to, boolean inclusive) {
            NavigableSet<K> varB4EAC82CA7396A68D541C85D26508E83_1422345852 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1422345852 = TreeMap.this.headMap(to, inclusive).navigableKeySet();
            addTaint(to.getTaint());
            addTaint(inclusive);
            varB4EAC82CA7396A68D541C85D26508E83_1422345852.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1422345852;
            // ---------- Original Method ----------
            //return TreeMap.this.headMap(to, inclusive).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.511 -0400", hash_original_method = "1E1BD4D122D1F75D80BDC2474EF32137", hash_generated_method = "F2A7CE28D00699D0A0BA82218EBF20C5")
        public SortedSet<K> headSet(K toExclusive) {
            SortedSet<K> varB4EAC82CA7396A68D541C85D26508E83_1291137297 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1291137297 = TreeMap.this.headMap(toExclusive, false).navigableKeySet();
            addTaint(toExclusive.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1291137297.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1291137297;
            // ---------- Original Method ----------
            //return TreeMap.this.headMap(toExclusive, false).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.512 -0400", hash_original_method = "3007AE414049BD587DD344AEC05F7630", hash_generated_method = "44E818573A9B00C11DEC483488C9CC9C")
        public NavigableSet<K> tailSet(K from, boolean inclusive) {
            NavigableSet<K> varB4EAC82CA7396A68D541C85D26508E83_1079126447 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1079126447 = TreeMap.this.tailMap(from, inclusive).navigableKeySet();
            addTaint(from.getTaint());
            addTaint(inclusive);
            varB4EAC82CA7396A68D541C85D26508E83_1079126447.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1079126447;
            // ---------- Original Method ----------
            //return TreeMap.this.tailMap(from, inclusive).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.512 -0400", hash_original_method = "4DA58A152F26E7271643C0314BDDDB69", hash_generated_method = "9808182751C92FD0EE43F6B0C419444C")
        public SortedSet<K> tailSet(K fromInclusive) {
            SortedSet<K> varB4EAC82CA7396A68D541C85D26508E83_538922708 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_538922708 = TreeMap.this.tailMap(fromInclusive, true).navigableKeySet();
            addTaint(fromInclusive.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_538922708.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_538922708;
            // ---------- Original Method ----------
            //return TreeMap.this.tailMap(fromInclusive, true).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.513 -0400", hash_original_method = "1704B63D396CC7A2877008D7CE821A20", hash_generated_method = "9E6029833A85D9D01AA087D0DDBCAC9F")
        public NavigableSet<K> descendingSet() {
            NavigableSet<K> varB4EAC82CA7396A68D541C85D26508E83_397621598 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_397621598 = new BoundedMap(false, null, NO_BOUND, null, NO_BOUND).navigableKeySet();
            varB4EAC82CA7396A68D541C85D26508E83_397621598.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_397621598;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.513 -0400", hash_original_field = "9C9AB624360885FCF93B7643C93B6748", hash_generated_field = "BC70714ECDFF7490EBA777F7B93EF439")

        private transient boolean ascending;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.513 -0400", hash_original_field = "D98A07F84921B24EE30F86FD8CD85C3C", hash_generated_field = "EEAE90D76D5F301C983CBE52CC99E066")

        private transient K from;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.513 -0400", hash_original_field = "8632C30284D52AAEE2237CDB621740BD", hash_generated_field = "8ED035FAE673A429CD23C9E2219BCCAB")

        private transient Bound fromBound;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.513 -0400", hash_original_field = "01B6E20344B68835C5ED1DDEDF20D531", hash_generated_field = "61687A1A941C5D04AF6012AAB46409E8")

        private transient K to;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.513 -0400", hash_original_field = "7CA17358064D231F30EBE9DEA6953FC3", hash_generated_field = "AA1B7E444C65D0CB4426137E2FCF44C2")

        private transient Bound toBound;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.513 -0400", hash_original_field = "D4E06C98DBA5A687CB6C836BF538EC81", hash_generated_field = "71A92C43EAA002A1D21DF22BACB230F5")

        private transient BoundedEntrySet entrySet;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.513 -0400", hash_original_field = "3E8ABCE844B6A8A95397486A3899B536", hash_generated_field = "8C5699591CBD5CFF428C3B6D5369D846")

        private transient BoundedKeySet keySet;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.517 -0400", hash_original_method = "EAF770A918D33B7B0B98CAAC01791FDE", hash_generated_method = "9A90164F7EAA2E91C7CDFA454F04C7C5")
          BoundedMap(boolean ascending, K from, Bound fromBound, K to, Bound toBound) {
            {
                {
                    boolean varDF5DEF900BBEA61318C4B860BE963A0C_389973462 = (comparator.compare(from, to) > 0);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.533 -0400", hash_original_method = "0165FF9BE82C19127CA9F7A8EFBCC5F6", hash_generated_method = "E25C36324C621305BB211655662E4891")
        @Override
        public int size() {
            int varFAAE4FEB39919E901926F6E4652B275E_206911631 = (count(entrySet().iterator()));
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_583061020 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_583061020;
            // ---------- Original Method ----------
            //return count(entrySet().iterator());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.533 -0400", hash_original_method = "25ACC65054E604EE8ADED763702CFAA7", hash_generated_method = "6F7AE07724D1221953599B2AB63C04C3")
        @Override
        public boolean isEmpty() {
            boolean var19B0E21581FF256C0BE5D0F9299E6746_204381456 = (endpoint(true) == null);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_236880704 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_236880704;
            // ---------- Original Method ----------
            //return endpoint(true) == null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.534 -0400", hash_original_method = "00AB887CF1625BBE035D7C27E115F8F5", hash_generated_method = "58D86D304A2BA8D30F7BE5586AE9FF6E")
        @Override
        public V get(Object key) {
            V varB4EAC82CA7396A68D541C85D26508E83_1071077857 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1071077857 = isInBounds(key) ? TreeMap.this.get(key) : null;
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1071077857.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1071077857;
            // ---------- Original Method ----------
            //return isInBounds(key) ? TreeMap.this.get(key) : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.535 -0400", hash_original_method = "97933E3E15C41B402232AC9CC0472CF2", hash_generated_method = "78FD4AA5530BBA20D0E89F6CC28FFC34")
        @Override
        public boolean containsKey(Object key) {
            boolean varA3E267D2E614E41BB78FB5916F69E5F6_2097779200 = (isInBounds(key) && TreeMap.this.containsKey(key));
            addTaint(key.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_470756688 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_470756688;
            // ---------- Original Method ----------
            //return isInBounds(key) && TreeMap.this.containsKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.557 -0400", hash_original_method = "AA5BBA9E7D3BEE615F1E652A3C2B8A57", hash_generated_method = "7CC2DB0C3146249250D22361A124AF5D")
        @Override
        public V put(K key, V value) {
            V varB4EAC82CA7396A68D541C85D26508E83_242700862 = null; //Variable for return #1
            {
                boolean varAD602F34696280F613EFFCC6CD1936C9_1621423461 = (!isInBounds(key));
                {
                    if (DroidSafeAndroidRuntime.control) throw outOfBounds(key, fromBound, toBound);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_242700862 = putInternal(key, value);
            addTaint(key.getTaint());
            addTaint(value.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_242700862.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_242700862;
            // ---------- Original Method ----------
            //if (!isInBounds(key)) {
                //throw outOfBounds(key, fromBound, toBound);
            //}
            //return putInternal(key, value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.558 -0400", hash_original_method = "FD860E76286147E5825948B59334B12A", hash_generated_method = "C8BB0810E3382176EC7956BEF450E89E")
        @Override
        public V remove(Object key) {
            V varB4EAC82CA7396A68D541C85D26508E83_2142855565 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2142855565 = isInBounds(key) ? TreeMap.this.remove(key) : null;
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2142855565.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2142855565;
            // ---------- Original Method ----------
            //return isInBounds(key) ? TreeMap.this.remove(key) : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.558 -0400", hash_original_method = "CBDDB4BBE438A9DB233DEA58A1C969FA", hash_generated_method = "BF33969F545F62CC02276EF50BD3CEA4")
        @SuppressWarnings("unchecked")
        private boolean isInBounds(Object key) {
            boolean varA5F72E2E91F3E285BA97AAF5A99A4DA1_1212916429 = (isInBounds((K) key, fromBound, toBound));
            addTaint(key.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_844765295 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_844765295;
            // ---------- Original Method ----------
            //return isInBounds((K) key, fromBound, toBound);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.559 -0400", hash_original_method = "692642A6AE210FFE582C89EC91302D79", hash_generated_method = "234FB54F25A5C5F099AAA85423813A7B")
        private boolean isInBounds(K key, Bound fromBound, Bound toBound) {
            {
                {
                    boolean var9F6E7E65C5DF7B537032AF04E3982098_1315561802 = (comparator.compare(key, from) < 0);
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean varFBA4E02ED99BA8F4A60A17B22AA50698_308289702 = (comparator.compare(key, from) <= 0);
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var3BF67E403FFC608A69421DC18FA2C214_702045718 = (comparator.compare(key, to) > 0);
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean varEA1D9A2226B6707B7C8DE8BD2619E59B_804802055 = (comparator.compare(key, to) >= 0);
                } //End collapsed parenthetic
            } //End block
            addTaint(key.getTaint());
            addTaint(fromBound.getTaint());
            addTaint(toBound.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1671196016 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1671196016;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.559 -0400", hash_original_method = "CAAC4C1A33B13586569CF07F541A55C7", hash_generated_method = "F1D78B2789FC3FA42AC8599EE72655B7")
        private Node<K, V> bound(Node<K, V> node, Bound fromBound, Bound toBound) {
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1915022939 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1915022939 = node != null && isInBounds(node.getKey(), fromBound, toBound) ? node : null;
            addTaint(node.getTaint());
            addTaint(fromBound.getTaint());
            addTaint(toBound.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1915022939.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1915022939;
            // ---------- Original Method ----------
            //return node != null && isInBounds(node.getKey(), fromBound, toBound) ? node : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.559 -0400", hash_original_method = "692355E3656C196457301F91A19D5157", hash_generated_method = "196D150FD3B90F4477B9D1F05BDB0B9E")
        public Entry<K, V> firstEntry() {
            Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1644297583 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1644297583 = immutableCopy(endpoint(true));
            varB4EAC82CA7396A68D541C85D26508E83_1644297583.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1644297583;
            // ---------- Original Method ----------
            //return immutableCopy(endpoint(true));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.560 -0400", hash_original_method = "3800FF04B85DB50D775ADF76A89AF0FD", hash_generated_method = "AC6017253DC4CA0F533107E1A5169BF4")
        public Entry<K, V> pollFirstEntry() {
            Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1137430095 = null; //Variable for return #1
            Node<K, V> result;
            result = endpoint(true);
            {
                removeInternal(result);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1137430095 = immutableCopy(result);
            varB4EAC82CA7396A68D541C85D26508E83_1137430095.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1137430095;
            // ---------- Original Method ----------
            //Node<K, V> result = endpoint(true);
            //if (result != null) {
                //removeInternal(result);
            //}
            //return immutableCopy(result);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.573 -0400", hash_original_method = "1DE5152AF86A2FB092CD0802BF299C85", hash_generated_method = "BE4E36A05C8D02231CFD222037C52A29")
        public K firstKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_549603424 = null; //Variable for return #1
            Entry<K, V> entry;
            entry = endpoint(true);
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_549603424 = entry.getKey();
            varB4EAC82CA7396A68D541C85D26508E83_549603424.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_549603424;
            // ---------- Original Method ----------
            //Entry<K, V> entry = endpoint(true);
            //if (entry == null) {
                //throw new NoSuchElementException();
            //}
            //return entry.getKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.574 -0400", hash_original_method = "3349B358C55B472B88F39549996E074C", hash_generated_method = "B27976D71F1ECC2D7BAAEB799AAC3092")
        public Entry<K, V> lastEntry() {
            Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1666551108 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1666551108 = immutableCopy(endpoint(false));
            varB4EAC82CA7396A68D541C85D26508E83_1666551108.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1666551108;
            // ---------- Original Method ----------
            //return immutableCopy(endpoint(false));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.574 -0400", hash_original_method = "4E391E55891B2D72162CA8FBBFDB8088", hash_generated_method = "A2CDDDFBCDDEA780F4542E3588525C13")
        public Entry<K, V> pollLastEntry() {
            Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1567357311 = null; //Variable for return #1
            Node<K, V> result;
            result = endpoint(false);
            {
                removeInternal(result);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1567357311 = immutableCopy(result);
            varB4EAC82CA7396A68D541C85D26508E83_1567357311.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1567357311;
            // ---------- Original Method ----------
            //Node<K, V> result = endpoint(false);
            //if (result != null) {
                //removeInternal(result);
            //}
            //return immutableCopy(result);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.575 -0400", hash_original_method = "394B9DCC52DC405017E9FB6F95D12436", hash_generated_method = "C5611FF3AE877DFA0217D7416F391705")
        public K lastKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_324692931 = null; //Variable for return #1
            Entry<K, V> entry;
            entry = endpoint(false);
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_324692931 = entry.getKey();
            varB4EAC82CA7396A68D541C85D26508E83_324692931.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_324692931;
            // ---------- Original Method ----------
            //Entry<K, V> entry = endpoint(false);
            //if (entry == null) {
                //throw new NoSuchElementException();
            //}
            //return entry.getKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.576 -0400", hash_original_method = "83D48F5C9D4926E1668CDBC652A8BB3D", hash_generated_method = "CAE04CF15B36CDCBCF5F2A95782BDA3B")
        private Node<K, V> endpoint(boolean first) {
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_427224487 = null; //Variable for return #1
            Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_699496293 = null; //Variable for return #2
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
                varB4EAC82CA7396A68D541C85D26508E83_427224487 = bound(node, NO_BOUND, toBound);
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
                varB4EAC82CA7396A68D541C85D26508E83_699496293 = bound(node, fromBound, NO_BOUND);
            } //End block
            addTaint(first);
            Node<K, V> varA7E53CE21691AB073D9660D615818899_1508490378; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1508490378 = varB4EAC82CA7396A68D541C85D26508E83_427224487;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1508490378 = varB4EAC82CA7396A68D541C85D26508E83_699496293;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1508490378.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1508490378;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.587 -0400", hash_original_method = "4CDC04225A960E79B8311D7465BD3125", hash_generated_method = "B489CAD30974D76ED41C46B40E88A106")
        private Entry<K, V> findBounded(K key, Relation relation) {
            Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1809288091 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_1809288091 = bound(find(key, relation), fromBoundForCheck, toBoundForCheck);
            addTaint(key.getTaint());
            addTaint(relation.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1809288091.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1809288091;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.588 -0400", hash_original_method = "BD9CF59DC295A4AE3510934F298E27E6", hash_generated_method = "CDCEA731333302C43246B6AC10D906D3")
        public Entry<K, V> lowerEntry(K key) {
            Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_2066832344 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2066832344 = immutableCopy(findBounded(key, LOWER));
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2066832344.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2066832344;
            // ---------- Original Method ----------
            //return immutableCopy(findBounded(key, LOWER));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.603 -0400", hash_original_method = "EBA87E3AFD9E90051DFFEBD0117773EA", hash_generated_method = "5349311B28F03348FAE2BC796E0B444D")
        public K lowerKey(K key) {
            K varB4EAC82CA7396A68D541C85D26508E83_397612906 = null; //Variable for return #1
            Entry<K, V> entry;
            entry = findBounded(key, LOWER);
            varB4EAC82CA7396A68D541C85D26508E83_397612906 = entry != null ? entry.getKey() : null;
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_397612906.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_397612906;
            // ---------- Original Method ----------
            //Entry<K, V> entry = findBounded(key, LOWER);
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.604 -0400", hash_original_method = "581C54D570AF4193E6400C576ED95C35", hash_generated_method = "9608831E8AB33DE49127845AC26962A8")
        public Entry<K, V> floorEntry(K key) {
            Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1390846271 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1390846271 = immutableCopy(findBounded(key, FLOOR));
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1390846271.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1390846271;
            // ---------- Original Method ----------
            //return immutableCopy(findBounded(key, FLOOR));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.615 -0400", hash_original_method = "E92237DAC033388A5150FD58D66D705D", hash_generated_method = "99AC3452EC76B090651B9FE2C16F52FA")
        public K floorKey(K key) {
            K varB4EAC82CA7396A68D541C85D26508E83_612936799 = null; //Variable for return #1
            Entry<K, V> entry;
            entry = findBounded(key, FLOOR);
            varB4EAC82CA7396A68D541C85D26508E83_612936799 = entry != null ? entry.getKey() : null;
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_612936799.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_612936799;
            // ---------- Original Method ----------
            //Entry<K, V> entry = findBounded(key, FLOOR);
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.617 -0400", hash_original_method = "C11821BD096982DAE03E94867B2C92BE", hash_generated_method = "7CCBE29DA4E751F9DE0503AA0EA77646")
        public Entry<K, V> ceilingEntry(K key) {
            Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_858008695 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_858008695 = immutableCopy(findBounded(key, CEILING));
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_858008695.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_858008695;
            // ---------- Original Method ----------
            //return immutableCopy(findBounded(key, CEILING));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.630 -0400", hash_original_method = "01AF63D6DC81CC48D8C6B0BE37F83B4D", hash_generated_method = "1BA039EADD72692DA191BDD286012CE6")
        public K ceilingKey(K key) {
            K varB4EAC82CA7396A68D541C85D26508E83_1440567536 = null; //Variable for return #1
            Entry<K, V> entry;
            entry = findBounded(key, CEILING);
            varB4EAC82CA7396A68D541C85D26508E83_1440567536 = entry != null ? entry.getKey() : null;
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1440567536.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1440567536;
            // ---------- Original Method ----------
            //Entry<K, V> entry = findBounded(key, CEILING);
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.631 -0400", hash_original_method = "4DE66AB7FA66EBE29F4E4509967D65D0", hash_generated_method = "22ED94911CE142982A8A5C405ED4B5DF")
        public Entry<K, V> higherEntry(K key) {
            Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1780733517 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1780733517 = immutableCopy(findBounded(key, HIGHER));
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1780733517.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1780733517;
            // ---------- Original Method ----------
            //return immutableCopy(findBounded(key, HIGHER));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.650 -0400", hash_original_method = "47A499322D06CDAFFEC1D4DA0A079F0A", hash_generated_method = "5AF1DC2E2B4E044679BF81585975CA71")
        public K higherKey(K key) {
            K varB4EAC82CA7396A68D541C85D26508E83_94864896 = null; //Variable for return #1
            Entry<K, V> entry;
            entry = findBounded(key, HIGHER);
            varB4EAC82CA7396A68D541C85D26508E83_94864896 = entry != null ? entry.getKey() : null;
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_94864896.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_94864896;
            // ---------- Original Method ----------
            //Entry<K, V> entry = findBounded(key, HIGHER);
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.650 -0400", hash_original_method = "631801B6DE22632DEACA2B547DEBE43A", hash_generated_method = "0811A8F6260BCDFF2B66304991B95E93")
        public Comparator<? super K> comparator() {
            Comparator<? super K> varB4EAC82CA7396A68D541C85D26508E83_1402182286 = null; //Variable for return #1
            Comparator<? super K> varB4EAC82CA7396A68D541C85D26508E83_2005275221 = null; //Variable for return #2
            {
                varB4EAC82CA7396A68D541C85D26508E83_1402182286 = TreeMap.this.comparator();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_2005275221 = Collections.reverseOrder(comparator);
            } //End block
            Comparator<? super K> varA7E53CE21691AB073D9660D615818899_1625310166; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1625310166 = varB4EAC82CA7396A68D541C85D26508E83_1402182286;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1625310166 = varB4EAC82CA7396A68D541C85D26508E83_2005275221;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1625310166.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1625310166;
            // ---------- Original Method ----------
            //if (ascending) {
            //return TreeMap.this.comparator();
          //} else {
            //return Collections.reverseOrder(comparator);
          //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.651 -0400", hash_original_method = "7F86A739037DCA8312EEE2819E1107F8", hash_generated_method = "779E28B97DF3CF560E4C033B306A98EE")
        @Override
        public Set<Entry<K, V>> entrySet() {
            Set<Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_1907422382 = null; //Variable for return #1
            BoundedEntrySet result;
            result = entrySet;
            varB4EAC82CA7396A68D541C85D26508E83_1907422382 = result != null ? result : (entrySet = new BoundedEntrySet());
            varB4EAC82CA7396A68D541C85D26508E83_1907422382.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1907422382;
            // ---------- Original Method ----------
            //BoundedEntrySet result = entrySet;
            //return result != null ? result : (entrySet = new BoundedEntrySet());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.651 -0400", hash_original_method = "8D1D053C1D8B0756868AB879DB7CB086", hash_generated_method = "A62C7556DD4677F5CF7CB4ED1211D8A9")
        @Override
        public Set<K> keySet() {
            Set<K> varB4EAC82CA7396A68D541C85D26508E83_2034232031 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2034232031 = navigableKeySet();
            varB4EAC82CA7396A68D541C85D26508E83_2034232031.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2034232031;
            // ---------- Original Method ----------
            //return navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.652 -0400", hash_original_method = "58209BC6FD1C6420A0C3CE4B441A6EA8", hash_generated_method = "AA09D1F4158CCCAD2512B5340B42CB4A")
        public NavigableSet<K> navigableKeySet() {
            NavigableSet<K> varB4EAC82CA7396A68D541C85D26508E83_1332334686 = null; //Variable for return #1
            BoundedKeySet result;
            result = keySet;
            varB4EAC82CA7396A68D541C85D26508E83_1332334686 = result != null ? result : (keySet = new BoundedKeySet());
            varB4EAC82CA7396A68D541C85D26508E83_1332334686.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1332334686;
            // ---------- Original Method ----------
            //BoundedKeySet result = keySet;
            //return result != null ? result : (keySet = new BoundedKeySet());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.653 -0400", hash_original_method = "6D358EC631E9E279A9C759613AD4CBF5", hash_generated_method = "75E67F1FC0DCE66C709767D7F81D3479")
        public NavigableMap<K, V> descendingMap() {
            NavigableMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_494887067 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_494887067 = new BoundedMap(!ascending, from, fromBound, to, toBound);
            varB4EAC82CA7396A68D541C85D26508E83_494887067.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_494887067;
            // ---------- Original Method ----------
            //return new BoundedMap(!ascending, from, fromBound, to, toBound);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.653 -0400", hash_original_method = "E068C75BD35AA3BEC427F457C352E2B5", hash_generated_method = "B84C9F52BF039D8FF7BA4DBBE13C36C2")
        public NavigableSet<K> descendingKeySet() {
            NavigableSet<K> varB4EAC82CA7396A68D541C85D26508E83_329125402 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_329125402 = new BoundedMap(!ascending, from, fromBound, to, toBound).navigableKeySet();
            varB4EAC82CA7396A68D541C85D26508E83_329125402.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_329125402;
            // ---------- Original Method ----------
            //return new BoundedMap(!ascending, from, fromBound, to, toBound).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.668 -0400", hash_original_method = "3DC9A98D108EA5F857802D111DD4C7BC", hash_generated_method = "E63F506EEC5DA8B36678559DA202C403")
        public NavigableMap<K, V> subMap(K from, boolean fromInclusive, K to, boolean toInclusive) {
            NavigableMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_2104076176 = null; //Variable for return #1
            Bound fromBound;
            fromBound = INCLUSIVE;
            fromBound = EXCLUSIVE;
            Bound toBound;
            toBound = INCLUSIVE;
            toBound = EXCLUSIVE;
            varB4EAC82CA7396A68D541C85D26508E83_2104076176 = subMap(from, fromBound, to, toBound);
            addTaint(from.getTaint());
            addTaint(fromInclusive);
            addTaint(to.getTaint());
            addTaint(toInclusive);
            varB4EAC82CA7396A68D541C85D26508E83_2104076176.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2104076176;
            // ---------- Original Method ----------
            //Bound fromBound = fromInclusive ? INCLUSIVE : EXCLUSIVE;
            //Bound toBound = toInclusive ? INCLUSIVE : EXCLUSIVE;
            //return subMap(from, fromBound, to, toBound);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.668 -0400", hash_original_method = "85C9C855FCFD7C01DE62316D427AA356", hash_generated_method = "0965B1788CFA79528CBD80A36515615D")
        public NavigableMap<K, V> subMap(K fromInclusive, K toExclusive) {
            NavigableMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_1535710165 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1535710165 = subMap(fromInclusive, INCLUSIVE, toExclusive, EXCLUSIVE);
            addTaint(fromInclusive.getTaint());
            addTaint(toExclusive.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1535710165.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1535710165;
            // ---------- Original Method ----------
            //return subMap(fromInclusive, INCLUSIVE, toExclusive, EXCLUSIVE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.672 -0400", hash_original_method = "F0BAF6F2CF2FCD82E483E31B5C869204", hash_generated_method = "4E63EC30DF9C5E4E47388DEA38BFDAD6")
        public NavigableMap<K, V> headMap(K to, boolean inclusive) {
            NavigableMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_2052103601 = null; //Variable for return #1
            Bound toBound;
            toBound = INCLUSIVE;
            toBound = EXCLUSIVE;
            varB4EAC82CA7396A68D541C85D26508E83_2052103601 = subMap(null, NO_BOUND, to, toBound);
            addTaint(to.getTaint());
            addTaint(inclusive);
            varB4EAC82CA7396A68D541C85D26508E83_2052103601.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2052103601;
            // ---------- Original Method ----------
            //Bound toBound = inclusive ? INCLUSIVE : EXCLUSIVE;
            //return subMap(null, NO_BOUND, to, toBound);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.686 -0400", hash_original_method = "ABFE13DC9073E46E049BB999D5306953", hash_generated_method = "E36C922F79B856CD9E7CB51D6F628B17")
        public NavigableMap<K, V> headMap(K toExclusive) {
            NavigableMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_961127790 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_961127790 = subMap(null, NO_BOUND, toExclusive, EXCLUSIVE);
            addTaint(toExclusive.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_961127790.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_961127790;
            // ---------- Original Method ----------
            //return subMap(null, NO_BOUND, toExclusive, EXCLUSIVE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.687 -0400", hash_original_method = "26986665A8C827C93D404190F2752B4C", hash_generated_method = "6F95A527EE8832ED0AC52177C431118B")
        public NavigableMap<K, V> tailMap(K from, boolean inclusive) {
            NavigableMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_540345459 = null; //Variable for return #1
            Bound fromBound;
            fromBound = INCLUSIVE;
            fromBound = EXCLUSIVE;
            varB4EAC82CA7396A68D541C85D26508E83_540345459 = subMap(from, fromBound, null, NO_BOUND);
            addTaint(from.getTaint());
            addTaint(inclusive);
            varB4EAC82CA7396A68D541C85D26508E83_540345459.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_540345459;
            // ---------- Original Method ----------
            //Bound fromBound = inclusive ? INCLUSIVE : EXCLUSIVE;
            //return subMap(from, fromBound, null, NO_BOUND);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.688 -0400", hash_original_method = "CF387452C0473BBA846F53D5C56CE3B2", hash_generated_method = "A136A75C42CE1B2EA191B5C2FD8A5324")
        public NavigableMap<K, V> tailMap(K fromInclusive) {
            NavigableMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_931310353 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_931310353 = subMap(fromInclusive, INCLUSIVE, null, NO_BOUND);
            addTaint(fromInclusive.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_931310353.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_931310353;
            // ---------- Original Method ----------
            //return subMap(fromInclusive, INCLUSIVE, null, NO_BOUND);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.703 -0400", hash_original_method = "0BE57F9811CA6209D3A6FF727B140802", hash_generated_method = "984E2BB32277F7C819D879EC1097BED3")
        private NavigableMap<K, V> subMap(K from, Bound fromBound, K to, Bound toBound) {
            NavigableMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_634717406 = null; //Variable for return #1
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
                    boolean var1DAE628D732342D7BC54FD4D3278CE34_1112401295 = (!isInBounds(from, fromBoundToCheck, this.toBound));
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
                    boolean var5922B8A01789147118CB04C1CDD52F79_2072583870 = (!isInBounds(to, this.fromBound, toBoundToCheck));
                    {
                        if (DroidSafeAndroidRuntime.control) throw outOfBounds(to, this.fromBound, toBoundToCheck);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_634717406 = new BoundedMap(ascending, from, fromBound, to, toBound);
            varB4EAC82CA7396A68D541C85D26508E83_634717406.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_634717406;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.703 -0400", hash_original_method = "65FB71F2A366D35F7884C2869AFAA6ED", hash_generated_method = "46C883979C9AEAEB0AC47A13BBEF85FC")
        private IllegalArgumentException outOfBounds(Object value, Bound fromBound, Bound toBound) {
            IllegalArgumentException varB4EAC82CA7396A68D541C85D26508E83_575354003 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_575354003 = new IllegalArgumentException(value + " not in range "
                    + fromBound.leftCap(from) + ".." + toBound.rightCap(to));
            addTaint(value.getTaint());
            addTaint(fromBound.getTaint());
            addTaint(toBound.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_575354003.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_575354003;
            // ---------- Original Method ----------
            //return new IllegalArgumentException(value + " not in range "
                    //+ fromBound.leftCap(from) + ".." + toBound.rightCap(to));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.704 -0400", hash_original_method = "9F20C8CFE1A741092D9743A31C3F8586", hash_generated_method = "5ECC48643D7A980421D074EC314CDCFF")
         Object writeReplace() throws ObjectStreamException {
            Object varB4EAC82CA7396A68D541C85D26508E83_957797394 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_957797394 = ascending
                    ? new AscendingSubMap<K, V>(TreeMap.this, from, fromBound, to, toBound)
                    : new DescendingSubMap<K, V>(TreeMap.this, from, fromBound, to, toBound);
            varB4EAC82CA7396A68D541C85D26508E83_957797394.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_957797394;
            // ---------- Original Method ----------
            //return ascending
                    //? new AscendingSubMap<K, V>(TreeMap.this, from, fromBound, to, toBound)
                    //: new DescendingSubMap<K, V>(TreeMap.this, from, fromBound, to, toBound);
        }

        
        abstract class BoundedIterator<T> extends MapIterator<T> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.704 -0400", hash_original_method = "30CDAF663F351A84269F6FB0B072EFA9", hash_generated_method = "DCA6AE078FF061847F66F0A7A80CFEA2")
            protected  BoundedIterator(Node<K, V> next) {
                super(next);
                addTaint(next.getTaint());
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.705 -0400", hash_original_method = "E9206CF01CB691A7CC292AD03FA9736C", hash_generated_method = "7997431BE6BFB68A3A5116D3D3268CA5")
            @Override
            protected Node<K, V> stepForward() {
                Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1433910661 = null; //Variable for return #1
                Node<K, V> result;
                result = super.stepForward();
                {
                    boolean varB492F846C21C09F0364F2416324ABD06_599107108 = (next != null && !isInBounds(next.key, NO_BOUND, toBound));
                    {
                        next = null;
                    } //End block
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_1433910661 = result;
                varB4EAC82CA7396A68D541C85D26508E83_1433910661.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1433910661;
                // ---------- Original Method ----------
                //Node<K, V> result = super.stepForward();
                //if (next != null && !isInBounds(next.key, NO_BOUND, toBound)) {
                    //next = null;
                //}
                //return result;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.705 -0400", hash_original_method = "E55F6A3E56D317586EA4F65D3F74D30B", hash_generated_method = "A01CB354FCC8A254B57491EF123DF5FD")
            @Override
            protected Node<K, V> stepBackward() {
                Node<K, V> varB4EAC82CA7396A68D541C85D26508E83_1394758128 = null; //Variable for return #1
                Node<K, V> result;
                result = super.stepBackward();
                {
                    boolean varA14FF8A4CC2199BAF982AB4CC94D03CC_1049259967 = (next != null && !isInBounds(next.key, fromBound, NO_BOUND));
                    {
                        next = null;
                    } //End block
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_1394758128 = result;
                varB4EAC82CA7396A68D541C85D26508E83_1394758128.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1394758128;
                // ---------- Original Method ----------
                //Node<K, V> result = super.stepBackward();
                //if (next != null && !isInBounds(next.key, fromBound, NO_BOUND)) {
                    //next = null;
                //}
                //return result;
            }

            
        }


        
        final class BoundedEntrySet extends AbstractSet<Entry<K, V>> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.720 -0400", hash_original_method = "6A727A04787362E0DA8C9D4EFA8450E8", hash_generated_method = "6A727A04787362E0DA8C9D4EFA8450E8")
            public BoundedEntrySet ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.721 -0400", hash_original_method = "29BBB3BE9EA7B6D6C0B83C28F05082A4", hash_generated_method = "3B2326A63374B10E3A6522F205D54094")
            @Override
            public int size() {
                int var69D9F234E7E76618743D3D698A58599B_162034511 = (BoundedMap.this.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_747189181 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_747189181;
                // ---------- Original Method ----------
                //return BoundedMap.this.size();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.722 -0400", hash_original_method = "AEA447F4A69E282FABF93736832EBAA3", hash_generated_method = "AF581FA187093B6F293DE66A8BB32F69")
            @Override
            public boolean isEmpty() {
                boolean varF1E2DF8AD3E4C9C508E293B19251E66A_444877402 = (BoundedMap.this.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_435856750 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_435856750;
                // ---------- Original Method ----------
                //return BoundedMap.this.isEmpty();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.735 -0400", hash_original_method = "0E267F64AB80178C28467CD978AC79C8", hash_generated_method = "D3B7CA250FE527B021570CA390E7ADCA")
            @Override
            public Iterator<Entry<K, V>> iterator() {
                Iterator<Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_1779564076 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1779564076 = new BoundedIterator<Entry<K, V>>(endpoint(true)) {
                    public Entry<K, V> next() {
                        return ascending ? stepForward() : stepBackward();
                    }
                };
                varB4EAC82CA7396A68D541C85D26508E83_1779564076.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1779564076;
                // ---------- Original Method ----------
                //return new BoundedIterator<Entry<K, V>>(endpoint(true)) {
                    //public Entry<K, V> next() {
                        //return ascending ? stepForward() : stepBackward();
                    //}
                //};
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.736 -0400", hash_original_method = "954A21A7B25CC1709817AC62B8C6864E", hash_generated_method = "0C1649D3CA02E5D07BED78936B1EC2E3")
            @Override
            public boolean contains(Object o) {
                Entry<?, ?> entry;
                entry = (Entry<?, ?>) o;
                boolean varC238596BFA0BDAC8F31141888DBD9FC9_410247831 = (isInBounds(entry.getKey()) && findByEntry(entry) != null);
                addTaint(o.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1972907291 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1972907291;
                // ---------- Original Method ----------
                //if (!(o instanceof Entry)) {
                    //return false;
                //}
                //Entry<?, ?> entry = (Entry<?, ?>) o;
                //return isInBounds(entry.getKey()) && findByEntry(entry) != null;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.736 -0400", hash_original_method = "EF59D88655EE445530DBDC219FDD1A5F", hash_generated_method = "873B16DCD87E01001318F250198A5732")
            @Override
            public boolean remove(Object o) {
                Entry<?, ?> entry;
                entry = (Entry<?, ?>) o;
                boolean var155AF0A9D9B42FB9DF7C214F267A7E1B_133631856 = (isInBounds(entry.getKey()) && TreeMap.this.entrySet().remove(entry));
                addTaint(o.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_397996037 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_397996037;
                // ---------- Original Method ----------
                //if (!(o instanceof Entry)) {
                    //return false;
                //}
                //Entry<?, ?> entry = (Entry<?, ?>) o;
                //return isInBounds(entry.getKey()) && TreeMap.this.entrySet().remove(entry);
            }

            
        }


        
        final class BoundedKeySet extends AbstractSet<K> implements NavigableSet<K> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.739 -0400", hash_original_method = "9AD1259E686AD3B6150FA3E61E8BAA17", hash_generated_method = "9AD1259E686AD3B6150FA3E61E8BAA17")
            public BoundedKeySet ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.739 -0400", hash_original_method = "29BBB3BE9EA7B6D6C0B83C28F05082A4", hash_generated_method = "A94FE664AAFAAB6369DD2984A44915D3")
            @Override
            public int size() {
                int var69D9F234E7E76618743D3D698A58599B_1323080184 = (BoundedMap.this.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_296346366 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_296346366;
                // ---------- Original Method ----------
                //return BoundedMap.this.size();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.740 -0400", hash_original_method = "AEA447F4A69E282FABF93736832EBAA3", hash_generated_method = "C90BDB2CB865A7C3BDB5EE06485E0FF4")
            @Override
            public boolean isEmpty() {
                boolean varF1E2DF8AD3E4C9C508E293B19251E66A_1160262200 = (BoundedMap.this.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_855934561 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_855934561;
                // ---------- Original Method ----------
                //return BoundedMap.this.isEmpty();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.752 -0400", hash_original_method = "8539DDED7A19368CB3D09440D6A62269", hash_generated_method = "00DC9C707DD361C6555FE2E2BE28A22D")
            @Override
            public Iterator<K> iterator() {
                Iterator<K> varB4EAC82CA7396A68D541C85D26508E83_1896165218 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1896165218 = new BoundedIterator<K>(endpoint(true)) {
                    public K next() {
                        return (ascending ? stepForward() : stepBackward()).key;
                    }
                };
                varB4EAC82CA7396A68D541C85D26508E83_1896165218.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1896165218;
                // ---------- Original Method ----------
                //return new BoundedIterator<K>(endpoint(true)) {
                    //public K next() {
                        //return (ascending ? stepForward() : stepBackward()).key;
                    //}
                //};
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.753 -0400", hash_original_method = "74923548E6D3A508C57DDA053BC0EE64", hash_generated_method = "18542DF6A491C13AF15BD26E972F3177")
            public Iterator<K> descendingIterator() {
                Iterator<K> varB4EAC82CA7396A68D541C85D26508E83_1717349198 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1717349198 = new BoundedIterator<K>(endpoint(false)) {
                    public K next() {
                        return (ascending ? stepBackward() : stepForward()).key;
                    }
                };
                varB4EAC82CA7396A68D541C85D26508E83_1717349198.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1717349198;
                // ---------- Original Method ----------
                //return new BoundedIterator<K>(endpoint(false)) {
                    //public K next() {
                        //return (ascending ? stepBackward() : stepForward()).key;
                    //}
                //};
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.754 -0400", hash_original_method = "F2816D590B9E0F32B93C47AB444AEEED", hash_generated_method = "BE07EC7921D729B393C9F307D8504A7A")
            @Override
            public boolean contains(Object key) {
                boolean varDEADC564C50A1257392A09A833F9988B_1198621458 = (isInBounds(key) && findByObject(key) != null);
                addTaint(key.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_585239194 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_585239194;
                // ---------- Original Method ----------
                //return isInBounds(key) && findByObject(key) != null;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.754 -0400", hash_original_method = "ADEDE1B4ABE9B2F86F8B629056F35200", hash_generated_method = "1170BE233C585ABFC97408F95B6F2078")
            @Override
            public boolean remove(Object key) {
                boolean var55612E9AB490EF3FFBD38F202307B8D4_29832360 = (isInBounds(key) && removeInternalByKey(key) != null);
                addTaint(key.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1185763669 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1185763669;
                // ---------- Original Method ----------
                //return isInBounds(key) && removeInternalByKey(key) != null;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.770 -0400", hash_original_method = "3067DEE01FBBBFD061436C7D4561F434", hash_generated_method = "DF672BB942C09696EADF34E254CA9E23")
            public K first() {
                K varB4EAC82CA7396A68D541C85D26508E83_1488483261 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1488483261 = firstKey();
                varB4EAC82CA7396A68D541C85D26508E83_1488483261.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1488483261;
                // ---------- Original Method ----------
                //return firstKey();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.782 -0400", hash_original_method = "4985BB63726B115899F1811F08E80BDF", hash_generated_method = "DF0011F1242635497F21DFCE4C665AFF")
            public K pollFirst() {
                K varB4EAC82CA7396A68D541C85D26508E83_1360523250 = null; //Variable for return #1
                Entry<K, ?> entry;
                entry = pollFirstEntry();
                varB4EAC82CA7396A68D541C85D26508E83_1360523250 = entry != null ? entry.getKey() : null;
                varB4EAC82CA7396A68D541C85D26508E83_1360523250.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1360523250;
                // ---------- Original Method ----------
                //Entry<K, ?> entry = pollFirstEntry();
                //return entry != null ? entry.getKey() : null;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.782 -0400", hash_original_method = "39C87F788E647BCD3FB86FFF34D7EF10", hash_generated_method = "755BF8B6D7C755EB3D1C363BD0824FDB")
            public K last() {
                K varB4EAC82CA7396A68D541C85D26508E83_243308774 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_243308774 = lastKey();
                varB4EAC82CA7396A68D541C85D26508E83_243308774.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_243308774;
                // ---------- Original Method ----------
                //return lastKey();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.783 -0400", hash_original_method = "B202B1B2AAB477548F6A0AD72C9B1701", hash_generated_method = "96CCF945AB8FF49C99909FDD82C76654")
            public K pollLast() {
                K varB4EAC82CA7396A68D541C85D26508E83_2052981009 = null; //Variable for return #1
                Entry<K, ?> entry;
                entry = pollLastEntry();
                varB4EAC82CA7396A68D541C85D26508E83_2052981009 = entry != null ? entry.getKey() : null;
                varB4EAC82CA7396A68D541C85D26508E83_2052981009.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_2052981009;
                // ---------- Original Method ----------
                //Entry<K, ?> entry = pollLastEntry();
                //return entry != null ? entry.getKey() : null;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.783 -0400", hash_original_method = "5CFE05BF706A06BBB501067306F1B9ED", hash_generated_method = "666F5121542BE2FBB4E41CBC8CD5E22E")
            public K lower(K key) {
                K varB4EAC82CA7396A68D541C85D26508E83_184731373 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_184731373 = lowerKey(key);
                addTaint(key.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_184731373.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_184731373;
                // ---------- Original Method ----------
                //return lowerKey(key);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.783 -0400", hash_original_method = "10BABB7BB2E837824A13AAE89EE7EC6F", hash_generated_method = "22DE82E9823B27A1FECDB90A8CECE782")
            public K floor(K key) {
                K varB4EAC82CA7396A68D541C85D26508E83_720180639 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_720180639 = floorKey(key);
                addTaint(key.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_720180639.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_720180639;
                // ---------- Original Method ----------
                //return floorKey(key);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.784 -0400", hash_original_method = "2AD4706A6D818B709A1E2CA64B48B4B9", hash_generated_method = "6DC9A393ADA5951D498C6828CD14551C")
            public K ceiling(K key) {
                K varB4EAC82CA7396A68D541C85D26508E83_1007971537 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1007971537 = ceilingKey(key);
                addTaint(key.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_1007971537.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1007971537;
                // ---------- Original Method ----------
                //return ceilingKey(key);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.784 -0400", hash_original_method = "8CC63649234BFC57DB10A2387AE34DD6", hash_generated_method = "A67192E429452D06DE9F7D3FBA0ED1E9")
            public K higher(K key) {
                K varB4EAC82CA7396A68D541C85D26508E83_17162539 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_17162539 = higherKey(key);
                addTaint(key.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_17162539.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_17162539;
                // ---------- Original Method ----------
                //return higherKey(key);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.799 -0400", hash_original_method = "C5DD330893039070B9523799F47D2DEB", hash_generated_method = "305A8D67FA9DA946B75479CD07284873")
            public Comparator<? super K> comparator() {
                Comparator<? super K> varB4EAC82CA7396A68D541C85D26508E83_2033617959 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_2033617959 = BoundedMap.this.comparator();
                varB4EAC82CA7396A68D541C85D26508E83_2033617959.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_2033617959;
                // ---------- Original Method ----------
                //return BoundedMap.this.comparator();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.800 -0400", hash_original_method = "21039715CA3F916EA62F8064E71FC6CA", hash_generated_method = "71D87E53AB7CEEFA64C2601ADE2B0074")
            public NavigableSet<K> subSet(K from, boolean fromInclusive, K to, boolean toInclusive) {
                NavigableSet<K> varB4EAC82CA7396A68D541C85D26508E83_2144410276 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_2144410276 = subMap(from, fromInclusive, to, toInclusive).navigableKeySet();
                addTaint(from.getTaint());
                addTaint(fromInclusive);
                addTaint(to.getTaint());
                addTaint(toInclusive);
                varB4EAC82CA7396A68D541C85D26508E83_2144410276.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_2144410276;
                // ---------- Original Method ----------
                //return subMap(from, fromInclusive, to, toInclusive).navigableKeySet();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.800 -0400", hash_original_method = "AA0E5149ADFB9D8316CC8EA86FBC0B9E", hash_generated_method = "F5A53B8DBF81229070A849A35B7E7445")
            public SortedSet<K> subSet(K fromInclusive, K toExclusive) {
                SortedSet<K> varB4EAC82CA7396A68D541C85D26508E83_1864221777 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1864221777 = subMap(fromInclusive, toExclusive).navigableKeySet();
                addTaint(fromInclusive.getTaint());
                addTaint(toExclusive.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_1864221777.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1864221777;
                // ---------- Original Method ----------
                //return subMap(fromInclusive, toExclusive).navigableKeySet();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.801 -0400", hash_original_method = "EDDD3784AC7E9834A18CCB5F2AE27346", hash_generated_method = "1AAD9F32CCF6965D9A6496226966DE11")
            public NavigableSet<K> headSet(K to, boolean inclusive) {
                NavigableSet<K> varB4EAC82CA7396A68D541C85D26508E83_388208966 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_388208966 = headMap(to, inclusive).navigableKeySet();
                addTaint(to.getTaint());
                addTaint(inclusive);
                varB4EAC82CA7396A68D541C85D26508E83_388208966.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_388208966;
                // ---------- Original Method ----------
                //return headMap(to, inclusive).navigableKeySet();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.801 -0400", hash_original_method = "85EE899AF4D85617CB858518BA70EA12", hash_generated_method = "9CE23649DD4098B52DC973D3DEE28636")
            public SortedSet<K> headSet(K toExclusive) {
                SortedSet<K> varB4EAC82CA7396A68D541C85D26508E83_1442652257 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1442652257 = headMap(toExclusive).navigableKeySet();
                addTaint(toExclusive.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_1442652257.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1442652257;
                // ---------- Original Method ----------
                //return headMap(toExclusive).navigableKeySet();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.805 -0400", hash_original_method = "B964A303D464756EDD8E9C26A8D54411", hash_generated_method = "CF850FF3C923CD7EC3DF610DC07E7740")
            public NavigableSet<K> tailSet(K from, boolean inclusive) {
                NavigableSet<K> varB4EAC82CA7396A68D541C85D26508E83_1503249213 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1503249213 = tailMap(from, inclusive).navigableKeySet();
                addTaint(from.getTaint());
                addTaint(inclusive);
                varB4EAC82CA7396A68D541C85D26508E83_1503249213.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1503249213;
                // ---------- Original Method ----------
                //return tailMap(from, inclusive).navigableKeySet();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.816 -0400", hash_original_method = "9536952691BDDFD3D8EFB20A3BD9AE85", hash_generated_method = "245AF754F8DBDB30165949D7EE92D42C")
            public SortedSet<K> tailSet(K fromInclusive) {
                SortedSet<K> varB4EAC82CA7396A68D541C85D26508E83_608282715 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_608282715 = tailMap(fromInclusive).navigableKeySet();
                addTaint(fromInclusive.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_608282715.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_608282715;
                // ---------- Original Method ----------
                //return tailMap(fromInclusive).navigableKeySet();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.817 -0400", hash_original_method = "2BD89B2F5D5D75B5A66FC121E2BE77F9", hash_generated_method = "A9DE4BC8DE69A65CB998410F7CA71CFF")
            public NavigableSet<K> descendingSet() {
                NavigableSet<K> varB4EAC82CA7396A68D541C85D26508E83_1813827320 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1813827320 = new BoundedMap(!ascending, from, fromBound, to, toBound).navigableKeySet();
                varB4EAC82CA7396A68D541C85D26508E83_1813827320.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1813827320;
                // ---------- Original Method ----------
                //return new BoundedMap(!ascending, from, fromBound, to, toBound).navigableKeySet();
            }

            
        }


        
    }


    
    static abstract class NavigableSubMap<K, V> extends AbstractMap<K, V> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.934 -0400", hash_original_field = "6F8F57715090DA2632453988D9A1501B", hash_generated_field = "B4717CF7B02EE2D309DEC599DAA1DA31")

        TreeMap<K, V> m;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.934 -0400", hash_original_field = "7CE8636C076F5F42316676F7CA5CCFBE", hash_generated_field = "281EBE4703232193C289CCB42FC430E9")

        Object lo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.934 -0400", hash_original_field = "49F68A5C8493EC2C0BF489821C21FC3B", hash_generated_field = "EE270961C9ABF0EB22776F11E5EA361C")

        Object hi;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.934 -0400", hash_original_field = "0F5BB94160321573CBA39E65B009DB81", hash_generated_field = "D276D04527E3A57EE21A2E9A0B8A1207")

        boolean fromStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.934 -0400", hash_original_field = "A7515FC4FC23FB8889BFBA1242727AA1", hash_generated_field = "949B6DE90AB1D05CDD408410B1AFD766")

        boolean toEnd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.934 -0400", hash_original_field = "A7CF08EB9369574B3716AAA5776C2B8D", hash_generated_field = "21B44DD2A9CF91217A1B213D6DC61745")

        boolean loInclusive;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.934 -0400", hash_original_field = "A4BF0B040F2788C41F2B3BBC34352A92", hash_generated_field = "B6BC458569D2A14CE4BE7D6F92D77203")

        boolean hiInclusive;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.936 -0400", hash_original_method = "C1ACA683FC5CFCA3BE29823730AC5B8B", hash_generated_method = "D5980D3B68B4F742E542A915179E4C63")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.937 -0400", hash_original_method = "98169B5D59A5E61A69F2A37D56262114", hash_generated_method = "3CAF377124FBFCFBABACDE8606964B0B")
        @Override
        public Set<Entry<K, V>> entrySet() {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.937 -0400", hash_original_method = "6A8A4C8549808D70F841B9593D31A43F", hash_generated_method = "BCB6B91410A9D0ABC206623BCBCD1DDB")
        @SuppressWarnings("unchecked")
        protected Object readResolve() throws ObjectStreamException {
            Object varB4EAC82CA7396A68D541C85D26508E83_1204450577 = null; //Variable for return #1
            Bound fromBound;
            fromBound = NO_BOUND;
            fromBound = (loInclusive ? INCLUSIVE : EXCLUSIVE);
            Bound toBound;
            toBound = NO_BOUND;
            toBound = (hiInclusive ? INCLUSIVE : EXCLUSIVE);
            boolean ascending;
            ascending = !(this instanceof DescendingSubMap);
            varB4EAC82CA7396A68D541C85D26508E83_1204450577 = m.new BoundedMap(ascending, (K) lo, fromBound, (K) hi, toBound);
            varB4EAC82CA7396A68D541C85D26508E83_1204450577.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1204450577;
            // ---------- Original Method ----------
            //Bound fromBound = fromStart ? NO_BOUND : (loInclusive ? INCLUSIVE : EXCLUSIVE);
            //Bound toBound = toEnd ? NO_BOUND : (hiInclusive ? INCLUSIVE : EXCLUSIVE);
            //boolean ascending = !(this instanceof DescendingSubMap);
            //return m.new BoundedMap(ascending, (K) lo, fromBound, (K) hi, toBound);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.938 -0400", hash_original_field = "24DD802BAD101B93E8408F7D464B2F7C", hash_generated_field = "B6DBB99D66C7D5257F18744C6ED55042")

        private static long serialVersionUID = -2102997345730753016L;
    }


    
    static class DescendingSubMap<K, V> extends NavigableSubMap<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.938 -0400", hash_original_field = "9895B45EF9B1655F7485C1A0A0B5F7B1", hash_generated_field = "4B9119BDF2383B87567C450919484206")

        Comparator<K> reverseComparator;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.938 -0400", hash_original_method = "FDAA1F4436CE129642763FB7A272001D", hash_generated_method = "403BC4E2D5604955FA33199087DB72AD")
          DescendingSubMap(TreeMap<K, V> delegate, K from, Bound fromBound, K to, Bound toBound) {
            super(delegate, from, fromBound, to, toBound);
            addTaint(delegate.getTaint());
            addTaint(from.getTaint());
            addTaint(fromBound.getTaint());
            addTaint(to.getTaint());
            addTaint(toBound.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.938 -0400", hash_original_field = "52D0D343187A178B79D894969A386899", hash_generated_field = "EFA8ED22E30CE9903B2F3A838ED881F4")

        private static long serialVersionUID = 912986545866120460L;
    }


    
    static class AscendingSubMap<K, V> extends NavigableSubMap<K, V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.938 -0400", hash_original_method = "C32F016187D7478ED63A0FCF56CB93EB", hash_generated_method = "CB936BEDAF7FEDB34599950C363DBD15")
          AscendingSubMap(TreeMap<K, V> delegate, K from, Bound fromBound, K to, Bound toBound) {
            super(delegate, from, fromBound, to, toBound);
            addTaint(delegate.getTaint());
            addTaint(from.getTaint());
            addTaint(fromBound.getTaint());
            addTaint(to.getTaint());
            addTaint(toBound.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.939 -0400", hash_original_field = "B7AE5FA51DF371C0F9A4E87B021D4132", hash_generated_field = "476C935E303A86073A4CED2972DE762E")

        private static long serialVersionUID = 912986545866124060L;
    }


    
    class SubMap extends AbstractMap<K, V> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.939 -0400", hash_original_field = "430A77C88BFBC96EB36AF12A2DC1DEB7", hash_generated_field = "7CA688EFC5D14AE4FAAF4A0FA771CBD0")

        Object fromKey;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.939 -0400", hash_original_field = "A8F9F07D66AF8C1622E025437E7B26CE", hash_generated_field = "40A3A7AC103CBB24D1824415661519AF")

        Object toKey;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.939 -0400", hash_original_field = "0F5BB94160321573CBA39E65B009DB81", hash_generated_field = "D276D04527E3A57EE21A2E9A0B8A1207")

        boolean fromStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.939 -0400", hash_original_field = "A7515FC4FC23FB8889BFBA1242727AA1", hash_generated_field = "949B6DE90AB1D05CDD408410B1AFD766")

        boolean toEnd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.939 -0400", hash_original_method = "F30568FCC0DA5EEA09201E340702FDB4", hash_generated_method = "F30568FCC0DA5EEA09201E340702FDB4")
        public SubMap ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.948 -0400", hash_original_method = "98169B5D59A5E61A69F2A37D56262114", hash_generated_method = "3CAF377124FBFCFBABACDE8606964B0B")
        @Override
        public Set<Entry<K, V>> entrySet() {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.949 -0400", hash_original_method = "AC95C6CC81DF8BD4B0519A49635D6CF0", hash_generated_method = "91CB9AC9BBAFC9F6E7A2EA63B1E28B14")
        @SuppressWarnings("unchecked")
        protected Object readResolve() throws ObjectStreamException {
            Object varB4EAC82CA7396A68D541C85D26508E83_1333718678 = null; //Variable for return #1
            Bound fromBound;
            fromBound = NO_BOUND;
            fromBound = INCLUSIVE;
            Bound toBound;
            toBound = NO_BOUND;
            toBound = EXCLUSIVE;
            varB4EAC82CA7396A68D541C85D26508E83_1333718678 = new BoundedMap(true, (K) fromKey, fromBound, (K) toKey, toBound);
            varB4EAC82CA7396A68D541C85D26508E83_1333718678.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1333718678;
            // ---------- Original Method ----------
            //Bound fromBound = fromStart ? NO_BOUND : INCLUSIVE;
            //Bound toBound = toEnd ? NO_BOUND : EXCLUSIVE;
            //return new BoundedMap(true, (K) fromKey, fromBound, (K) toKey, toBound);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.950 -0400", hash_original_field = "EB690E9D3449E3ACDD044094944C88A2", hash_generated_field = "1C1BE65D094A2A2CF312563B1B5E5211")

        private static long serialVersionUID = -6520786458950516097L;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.950 -0400", hash_original_field = "AAD864C939B46188F070706401E1932C", hash_generated_field = "32AF0C3C3D2AD769936B5B8F09BD0206")

    @SuppressWarnings("unchecked") private static Comparator<Comparable> NATURAL_ORDER = new Comparator<Comparable>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.950 -0400", hash_original_method = "078A1DB9555D9E606EA5FF406F56B2E6", hash_generated_method = "5D4CF0428855D4E3BA89E6C8AAD4B962")
        public int compare(Comparable a, Comparable b) {
            int varC15B2565AD7A5177ED0132648C5386D9_1577898284 = (a.compareTo(b));
            addTaint(a.getTaint());
            addTaint(b.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1485232600 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1485232600;
            // ---------- Original Method ----------
            //return a.compareTo(b);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.950 -0400", hash_original_field = "0CB2D400AD555324093441A5EA2C6B7E", hash_generated_field = "BA41D7ADB475E35CDFC9F7B608EF580C")

    private static long serialVersionUID = 919286545866124006L;
}

