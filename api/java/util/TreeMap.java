package java.util;

// Droidsafe Imports
import droidsafe.annotations.*;
import static java.util.TreeMap.Bound.EXCLUSIVE;
import static java.util.TreeMap.Bound.INCLUSIVE;
import static java.util.TreeMap.Bound.NO_BOUND;
import static java.util.TreeMap.Relation.CEILING;
import static java.util.TreeMap.Relation.EQUAL;
import static java.util.TreeMap.Relation.FLOOR;
import static java.util.TreeMap.Relation.HIGHER;
import static java.util.TreeMap.Relation.LOWER;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectInputStream.GetField;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

import libcore.util.Objects;





public class TreeMap<K, V> extends AbstractMap<K, V> implements SortedMap<K, V>, NavigableMap<K, V>, Cloneable, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.367 -0400", hash_original_field = "4092F21BD0E2CC3C9CA971DF59AA8608", hash_generated_field = "10E826BC31BCAB9BF3EF3CC29146C2D4")

    Comparator<? super K> comparator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.367 -0400", hash_original_field = "63A9F0EA7BB98050796B649E85481845", hash_generated_field = "85295BCB9659691A12B83D4313F1A2F9")

    Node<K, V> root;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.367 -0400", hash_original_field = "4C519DE3531208469B40CCB51004CD2D", hash_generated_field = "689FC3CB9A887B5817C15E9CFDD066DB")

    int size = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.367 -0400", hash_original_field = "8626C3CD64A823DD7B97C6F5EF45A8FC", hash_generated_field = "7C38AA8724D6D8AD727BB2AB85887DF0")

    int modCount = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.367 -0400", hash_original_field = "D4E06C98DBA5A687CB6C836BF538EC81", hash_generated_field = "78564EACF73DB0AEDD2E075A8DFF1B13")

    private EntrySet entrySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.367 -0400", hash_original_field = "3E8ABCE844B6A8A95397486A3899B536", hash_generated_field = "455D81AE8BC4090CF8AD993E78862377")

    private KeySet keySet;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.367 -0400", hash_original_method = "A79D85B768A2B786B5F2ACD3F2B9D249", hash_generated_method = "CFE342F2F41F7796DB24A93B3EC5E9D4")
    @SuppressWarnings("unchecked")
    public  TreeMap() {
        this.comparator = (Comparator<? super K>) NATURAL_ORDER;
        // ---------- Original Method ----------
        //this.comparator = (Comparator<? super K>) NATURAL_ORDER;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.367 -0400", hash_original_method = "317880CC1AD8B8CC7D9C11CC941EE8C3", hash_generated_method = "C50778A3B9FF17C06EAC39C559AF87B9")
    public  TreeMap(Map<? extends K, ? extends V> copyFrom) {
        this();
        addTaint(copyFrom.getTaint());
for(Map.Entry<? extends K, ? extends V> entry : copyFrom.entrySet())
        {
            putInternal(entry.getKey(), entry.getValue());
        } //End block
        // ---------- Original Method ----------
        //for (Map.Entry<? extends K, ? extends V> entry : copyFrom.entrySet()) {
            //putInternal(entry.getKey(), entry.getValue());
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.369 -0400", hash_original_method = "C1FE892CAD9D3780A675F5A8CA11F4FA", hash_generated_method = "39BB15B650529D91F63E90DE9C103299")
    @SuppressWarnings("unchecked")
    public  TreeMap(Comparator<? super K> comparator) {
        if(comparator != null)        
        {
            this.comparator = comparator;
        } //End block
        else
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.369 -0400", hash_original_method = "2607F9CE6A88866DC32D385287E67644", hash_generated_method = "88414D93BF999D1A507D7F23D1F831E8")
    @SuppressWarnings("unchecked")
    public  TreeMap(SortedMap<K, ? extends V> copyFrom) {
        addTaint(copyFrom.getTaint());
        Comparator<? super K> sourceComparator = copyFrom.comparator();
        if(sourceComparator != null)        
        {
            this.comparator = sourceComparator;
        } //End block
        else
        {
            this.comparator = (Comparator<? super K>) NATURAL_ORDER;
        } //End block
for(Map.Entry<K, ? extends V> entry : copyFrom.entrySet())
        {
            putInternal(entry.getKey(), entry.getValue());
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.371 -0400", hash_original_method = "FB8B1056739768AF92CF25DB3C2D30EB", hash_generated_method = "CE6AA112E1019EE80B24D939F4FE6814")
    @Override
    public Object clone() {
        try 
        {
            @SuppressWarnings("unchecked") TreeMap<K, V> map = (TreeMap<K, V>) super.clone();
            map.root = root != null ? root.copy(null) : null;
            map.entrySet = null;
            map.keySet = null;
Object var16A0D6FA6CCA40A72F4213E7169FA153_779200350 =             map;
            var16A0D6FA6CCA40A72F4213E7169FA153_779200350.addTaint(taint);
            return var16A0D6FA6CCA40A72F4213E7169FA153_779200350;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA81442E36297E737EB908877E58260E8_1101679512 = new AssertionError();
            varA81442E36297E737EB908877E58260E8_1101679512.addTaint(taint);
            throw varA81442E36297E737EB908877E58260E8_1101679512;
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.371 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "423F27A96A488B0DA8DC2BBFCDDE98F8")
    @Override
    public int size() {
        int varF7BD60B75B29D79B660A2859395C1A24_1453147450 = (size);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_266565842 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_266565842;
        // ---------- Original Method ----------
        //return size;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.371 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "669D491A7BC6AFF33E0D5841FFF45FB6")
    @Override
    public boolean isEmpty() {
        boolean var9FB8BC7F775DDD98EEAB5582D340229E_1199050716 = (size == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1390633133 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1390633133;
        // ---------- Original Method ----------
        //return size == 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.372 -0400", hash_original_method = "C35732A40B74AF28951D9E96FE33879B", hash_generated_method = "30F2B3E06D7CE43187DC3BF731297F08")
    @Override
    public V get(Object key) {
        addTaint(key.getTaint());
        Entry<K, V> entry = findByObject(key);
V var6522E82B8E3E24073E106E1391BF1804_1216658952 =         entry != null ? entry.getValue() : null;
        var6522E82B8E3E24073E106E1391BF1804_1216658952.addTaint(taint);
        return var6522E82B8E3E24073E106E1391BF1804_1216658952;
        // ---------- Original Method ----------
        //Entry<K, V> entry = findByObject(key);
        //return entry != null ? entry.getValue() : null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.372 -0400", hash_original_method = "CD38E6D478445847B9B0A556F5E63837", hash_generated_method = "0BCFD560FB9E3A20F326479EAD1C6475")
    @Override
    public boolean containsKey(Object key) {
        addTaint(key.getTaint());
        boolean var50FA98E2BCCBB965D41019D477E20A3B_1640231553 = (findByObject(key) != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_639126882 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_639126882;
        // ---------- Original Method ----------
        //return findByObject(key) != null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.372 -0400", hash_original_method = "09423F07E68B4770E107529B69AA8334", hash_generated_method = "76CC54DBCF87FB2FD40DBA26C0B8EE98")
    @Override
    public V put(K key, V value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
V var2E37B97A19208A3D82E5317F45BDDA5A_691891396 =         putInternal(key, value);
        var2E37B97A19208A3D82E5317F45BDDA5A_691891396.addTaint(taint);
        return var2E37B97A19208A3D82E5317F45BDDA5A_691891396;
        // ---------- Original Method ----------
        //return putInternal(key, value);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.373 -0400", hash_original_method = "EA5BE6ED678D7376259BCC3DB1C01E21", hash_generated_method = "E961ABE6C82A278E3968107998979047")
    @Override
    public void clear() {
        root = null;
        size = 0;
        modCount++;
        // ---------- Original Method ----------
        //root = null;
        //size = 0;
        //modCount++;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.373 -0400", hash_original_method = "0207194EB3BB344ADD94A18916C183DF", hash_generated_method = "30F4E9FF0D0A9DBAC56AC3DF76692A7B")
    @Override
    public V remove(Object key) {
        addTaint(key.getTaint());
        Node<K, V> node = removeInternalByKey(key);
V var103CE18E43EB729FC0D45019043637D4_473887955 =         node != null ? node.value : null;
        var103CE18E43EB729FC0D45019043637D4_473887955.addTaint(taint);
        return var103CE18E43EB729FC0D45019043637D4_473887955;
        // ---------- Original Method ----------
        //Node<K, V> node = removeInternalByKey(key);
        //return node != null ? node.value : null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.374 -0400", hash_original_method = "73D5DA91D47B13631BBA1FF4FFC14006", hash_generated_method = "06F151B3D45C5299BF44A6E8B2E93D07")
     V putInternal(K key, V value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        Node<K, V> created = find(key, Relation.CREATE);
        V result = created.value;
        created.value = value;
V varDC838461EE2FA0CA4C9BBB70A15456B0_1043780877 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1043780877.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1043780877;
        // ---------- Original Method ----------
        //Node<K, V> created = find(key, Relation.CREATE);
        //V result = created.value;
        //created.value = value;
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.375 -0400", hash_original_method = "A47B461F1595004F5F78D5AE91E8DCD0", hash_generated_method = "2EAD98AAFBE9EE42B51B0C4F155BDEA0")
     Node<K, V> find(K key, Relation relation) {
        addTaint(relation.getTaint());
        if(root == null)        
        {
            if(comparator == NATURAL_ORDER && !(key instanceof Comparable))            
            {
                ClassCastException varE25C8FF4E605E3C5DE615DBEA48247CB_349416873 = new ClassCastException(key.getClass().getName() + " is not Comparable");
                varE25C8FF4E605E3C5DE615DBEA48247CB_349416873.addTaint(taint);
                throw varE25C8FF4E605E3C5DE615DBEA48247CB_349416873;
            } //End block
            if(relation == Relation.CREATE)            
            {
                root = new Node<K, V>(null, key);
                size = 1;
                modCount++;
Node<K, V> varE2FC54A1BB143D1D1A0E38EDF22F290D_809014646 =                 root;
                varE2FC54A1BB143D1D1A0E38EDF22F290D_809014646.addTaint(taint);
                return varE2FC54A1BB143D1D1A0E38EDF22F290D_809014646;
            } //End block
            else
            {
Node<K, V> var540C13E9E156B687226421B24F2DF178_2136800698 =                 null;
                var540C13E9E156B687226421B24F2DF178_2136800698.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_2136800698;
            } //End block
        } //End block
        @SuppressWarnings("unchecked") Comparable<Object> comparableKey = (comparator == NATURAL_ORDER)
                ? (Comparable<Object>) key
                : null;
        Node<K, V> nearest = root;
        while
(true)        
        {
            int comparison = (comparableKey != null)
                    ? comparableKey.compareTo(nearest.key)
                    : comparator.compare(key, nearest.key);
            if(comparison == 0)            
            {
switch(relation){
                case LOWER:
Node<K, V> var4FA6404FB0D962CE5F6E6CAEF4B8D23D_377855236 =                 nearest.prev();
                var4FA6404FB0D962CE5F6E6CAEF4B8D23D_377855236.addTaint(taint);
                return var4FA6404FB0D962CE5F6E6CAEF4B8D23D_377855236;
                case FLOOR:
                case EQUAL:
                case CREATE:
                case CEILING:
Node<K, V> var1ABCA9B14CBAD43438A66451686D7523_1858136222 =                 nearest;
                var1ABCA9B14CBAD43438A66451686D7523_1858136222.addTaint(taint);
                return var1ABCA9B14CBAD43438A66451686D7523_1858136222;
                case HIGHER:
Node<K, V> varB0C7B68E04E5B0A83ABC7508552291EE_1199117911 =                 nearest.next();
                varB0C7B68E04E5B0A83ABC7508552291EE_1199117911.addTaint(taint);
                return varB0C7B68E04E5B0A83ABC7508552291EE_1199117911;
}
            } //End block
            Node<K, V> child = (comparison < 0) ? nearest.left : nearest.right;
            if(child != null)            
            {
                nearest = child;
                continue;
            } //End block
            if(comparison < 0)            
            {
switch(relation){
                case LOWER:
                case FLOOR:
Node<K, V> var4FA6404FB0D962CE5F6E6CAEF4B8D23D_98081050 =                 nearest.prev();
                var4FA6404FB0D962CE5F6E6CAEF4B8D23D_98081050.addTaint(taint);
                return var4FA6404FB0D962CE5F6E6CAEF4B8D23D_98081050;
                case CEILING:
                case HIGHER:
Node<K, V> var1ABCA9B14CBAD43438A66451686D7523_1981984083 =                 nearest;
                var1ABCA9B14CBAD43438A66451686D7523_1981984083.addTaint(taint);
                return var1ABCA9B14CBAD43438A66451686D7523_1981984083;
                case EQUAL:
Node<K, V> var540C13E9E156B687226421B24F2DF178_860133582 =                 null;
                var540C13E9E156B687226421B24F2DF178_860133582.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_860133582;
                case CREATE:
                Node<K, V> created = new Node<K, V>(nearest, key);
                nearest.left = created;
                size++;
                modCount++;
                rebalance(nearest, true);
Node<K, V> varF62A73A42555B3FDC3F4E92223B094E6_210513977 =                 created;
                varF62A73A42555B3FDC3F4E92223B094E6_210513977.addTaint(taint);
                return varF62A73A42555B3FDC3F4E92223B094E6_210513977;
}
            } //End block
            else
            {
switch(relation){
                case LOWER:
                case FLOOR:
Node<K, V> var1ABCA9B14CBAD43438A66451686D7523_698020168 =                 nearest;
                var1ABCA9B14CBAD43438A66451686D7523_698020168.addTaint(taint);
                return var1ABCA9B14CBAD43438A66451686D7523_698020168;
                case CEILING:
                case HIGHER:
Node<K, V> varB0C7B68E04E5B0A83ABC7508552291EE_1798181037 =                 nearest.next();
                varB0C7B68E04E5B0A83ABC7508552291EE_1798181037.addTaint(taint);
                return varB0C7B68E04E5B0A83ABC7508552291EE_1798181037;
                case EQUAL:
Node<K, V> var540C13E9E156B687226421B24F2DF178_814829197 =                 null;
                var540C13E9E156B687226421B24F2DF178_814829197.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_814829197;
                case CREATE:
                Node<K, V> created = new Node<K, V>(nearest, key);
                nearest.right = created;
                size++;
                modCount++;
                rebalance(nearest, true);
Node<K, V> varF62A73A42555B3FDC3F4E92223B094E6_185981280 =                 created;
                varF62A73A42555B3FDC3F4E92223B094E6_185981280.addTaint(taint);
                return varF62A73A42555B3FDC3F4E92223B094E6_185981280;
}
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.376 -0400", hash_original_method = "C267D163E835004AE4803D9A2BC1E552", hash_generated_method = "BAE7264510D4903ADAC43DDDE51C3C91")
    @SuppressWarnings("unchecked")
     Node<K, V> findByObject(Object key) {
        addTaint(key.getTaint());
Node<K, V> var979736B4CE3624D031D085814C41C424_1242991568 =         find((K) key, EQUAL);
        var979736B4CE3624D031D085814C41C424_1242991568.addTaint(taint);
        return var979736B4CE3624D031D085814C41C424_1242991568;
        // ---------- Original Method ----------
        //return find((K) key, EQUAL);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.376 -0400", hash_original_method = "8678505752B854905CFE7B96C4FE458B", hash_generated_method = "307A762D24D53168AE7C0B2F922BED89")
     Node<K, V> findByEntry(Entry<?, ?> entry) {
        addTaint(entry.getTaint());
        Node<K, V> mine = findByObject(entry.getKey());
        boolean valuesEqual = mine != null && Objects.equal(mine.value, entry.getValue());
Node<K, V> varF219D1114161BEAF529424AB7E82DFA0_665053083 =         valuesEqual ? mine : null;
        varF219D1114161BEAF529424AB7E82DFA0_665053083.addTaint(taint);
        return varF219D1114161BEAF529424AB7E82DFA0_665053083;
        // ---------- Original Method ----------
        //Node<K, V> mine = findByObject(entry.getKey());
        //boolean valuesEqual = mine != null && Objects.equal(mine.value, entry.getValue());
        //return valuesEqual ? mine : null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.378 -0400", hash_original_method = "FAD76EC8E4C5DF9CCDE64BA514AC9743", hash_generated_method = "B30FED3CC81BBE6E813079857E593100")
     void removeInternal(Node<K, V> node) {
        addTaint(node.getTaint());
        Node<K, V> left = node.left;
        Node<K, V> right = node.right;
        Node<K, V> originalParent = node.parent;
        if(left != null && right != null)        
        {
            Node<K, V> adjacent = (left.height > right.height) ? left.last() : right.first();
            removeInternal(adjacent);
            int leftHeight = 0;
            left = node.left;
            if(left != null)            
            {
                leftHeight = left.height;
                adjacent.left = left;
                left.parent = adjacent;
                node.left = null;
            } //End block
            int rightHeight = 0;
            right = node.right;
            if(right != null)            
            {
                rightHeight = right.height;
                adjacent.right = right;
                right.parent = adjacent;
                node.right = null;
            } //End block
            adjacent.height = Math.max(leftHeight, rightHeight) + 1;
            replaceInParent(node, adjacent);
            return;
        } //End block
        else
        if(left != null)        
        {
            replaceInParent(node, left);
            node.left = null;
        } //End block
        else
        if(right != null)        
        {
            replaceInParent(node, right);
            node.right = null;
        } //End block
        else
        {
            replaceInParent(node, null);
        } //End block
        rebalance(originalParent, false);
        size--;
        modCount++;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.378 -0400", hash_original_method = "C9B9883A6728DC2F4DBB90BDF61B9978", hash_generated_method = "F53057B6F177C87757CBED9F64E27289")
     Node<K, V> removeInternalByKey(Object key) {
        addTaint(key.getTaint());
        Node<K, V> node = findByObject(key);
        if(node != null)        
        {
            removeInternal(node);
        } //End block
Node<K, V> var1924C94B76524D1C3D7310EA17B0EF94_483797481 =         node;
        var1924C94B76524D1C3D7310EA17B0EF94_483797481.addTaint(taint);
        return var1924C94B76524D1C3D7310EA17B0EF94_483797481;
        // ---------- Original Method ----------
        //Node<K, V> node = findByObject(key);
        //if (node != null) {
            //removeInternal(node);
        //}
        //return node;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.379 -0400", hash_original_method = "8CBFE12E379E7871AFCE5B0FC5C284CB", hash_generated_method = "6C31EDACABDC5C5503AC657CCCAF0917")
    private void replaceInParent(Node<K, V> node, Node<K, V> replacement) {
        addTaint(node.getTaint());
        Node<K, V> parent = node.parent;
        node.parent = null;
        if(replacement != null)        
        {
            replacement.parent = parent;
        } //End block
        if(parent != null)        
        {
            if(parent.left == node)            
            {
                parent.left = replacement;
            } //End block
            else
            {
                parent.right = replacement;
            } //End block
        } //End block
        else
        {
            root = replacement;
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.380 -0400", hash_original_method = "DE22B63E2A021BAF8A5DCC142FCC4B40", hash_generated_method = "493B1AC789FA627753B6464BC00715EE")
    private void rebalance(Node<K, V> unbalanced, boolean insert) {
        addTaint(insert);
        addTaint(unbalanced.getTaint());
for(Node<K, V> node = unbalanced;node != null;node = node.parent)
        {
            Node<K, V> left = node.left;
            Node<K, V> right = node.right;
            int leftHeight = left != null ? left.height : 0;
            int rightHeight = right != null ? right.height : 0;
            int delta = leftHeight - rightHeight;
            if(delta == -2)            
            {
                Node<K, V> rightLeft = right.left;
                Node<K, V> rightRight = right.right;
                int rightRightHeight = rightRight != null ? rightRight.height : 0;
                int rightLeftHeight = rightLeft != null ? rightLeft.height : 0;
                int rightDelta = rightLeftHeight - rightRightHeight;
                if(rightDelta == -1 || (rightDelta == 0 && !insert))                
                {
                    rotateLeft(node);
                } //End block
                else
                {
                    rotateRight(right);
                    rotateLeft(node);
                } //End block
                if(insert)                
                {
                    break;
                } //End block
            } //End block
            else
            if(delta == 2)            
            {
                Node<K, V> leftLeft = left.left;
                Node<K, V> leftRight = left.right;
                int leftRightHeight = leftRight != null ? leftRight.height : 0;
                int leftLeftHeight = leftLeft != null ? leftLeft.height : 0;
                int leftDelta = leftLeftHeight - leftRightHeight;
                if(leftDelta == 1 || (leftDelta == 0 && !insert))                
                {
                    rotateRight(node);
                } //End block
                else
                {
                    rotateLeft(left);
                    rotateRight(node);
                } //End block
                if(insert)                
                {
                    break;
                } //End block
            } //End block
            else
            if(delta == 0)            
            {
                node.height = leftHeight + 1;
                if(insert)                
                {
                    break;
                } //End block
            } //End block
            else
            {
                node.height = Math.max(leftHeight, rightHeight) + 1;
                if(!insert)                
                {
                    break;
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.382 -0400", hash_original_method = "6326CB79DBF89391F00F9AB13B0E81D9", hash_generated_method = "685523E676E56BFF33243B0EB971ECC7")
    private void rotateLeft(Node<K, V> root) {
        Node<K, V> left = root.left;
        Node<K, V> pivot = root.right;
        Node<K, V> pivotLeft = pivot.left;
        Node<K, V> pivotRight = pivot.right;
        root.right = pivotLeft;
        if(pivotLeft != null)        
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.383 -0400", hash_original_method = "DF035E309292DEA6067E726F513C85C3", hash_generated_method = "4A8DF272658781BA2B1B74BBEFBED10F")
    private void rotateRight(Node<K, V> root) {
        Node<K, V> pivot = root.left;
        Node<K, V> right = root.right;
        Node<K, V> pivotLeft = pivot.left;
        Node<K, V> pivotRight = pivot.right;
        root.left = pivotRight;
        if(pivotRight != null)        
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.384 -0400", hash_original_method = "E2F61A98BB539F90A11465C6A8354CE5", hash_generated_method = "36A8E8F7C8F1548B797F92A82E79587A")
    private SimpleImmutableEntry<K, V> immutableCopy(Entry<K, V> entry) {
        addTaint(entry.getTaint());
SimpleImmutableEntry<K, V> var00719393D67D40742FD53C80CE0E5B0C_107891035 =         entry == null ? null : new SimpleImmutableEntry<K, V>(entry);
        var00719393D67D40742FD53C80CE0E5B0C_107891035.addTaint(taint);
        return var00719393D67D40742FD53C80CE0E5B0C_107891035;
        // ---------- Original Method ----------
        //return entry == null ? null : new SimpleImmutableEntry<K, V>(entry);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.384 -0400", hash_original_method = "9F2AE61C584701540103A59451B8FA45", hash_generated_method = "9609CA310A4F3C97BB9D2732B3DF52A3")
    public Entry<K, V> firstEntry() {
Entry<K, V> var79CE0C1FA3610C2C3C5116B38C8243BB_809308155 =         immutableCopy(root == null ? null : root.first());
        var79CE0C1FA3610C2C3C5116B38C8243BB_809308155.addTaint(taint);
        return var79CE0C1FA3610C2C3C5116B38C8243BB_809308155;
        // ---------- Original Method ----------
        //return immutableCopy(root == null ? null : root.first());
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.384 -0400", hash_original_method = "2730A7A2197248AC3B653DF430BA3F4A", hash_generated_method = "765C84295E7A812C5689B97EF7D348DA")
    private Entry<K, V> internalPollFirstEntry() {
        if(root == null)        
        {
Entry<K, V> var540C13E9E156B687226421B24F2DF178_47096835 =             null;
            var540C13E9E156B687226421B24F2DF178_47096835.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_47096835;
        } //End block
        Node<K, V> result = root.first();
        removeInternal(result);
Entry<K, V> varDC838461EE2FA0CA4C9BBB70A15456B0_1241143470 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1241143470.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1241143470;
        // ---------- Original Method ----------
        //if (root == null) {
            //return null;
        //}
        //Node<K, V> result = root.first();
        //removeInternal(result);
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.385 -0400", hash_original_method = "1456A4986DE10120F25B46536C8BF169", hash_generated_method = "59FDE0C916F804D8BDDBBEE6BF688E03")
    public Entry<K, V> pollFirstEntry() {
Entry<K, V> var0EECE440B7D78C06FD543B2F85411722_2116397085 =         immutableCopy(internalPollFirstEntry());
        var0EECE440B7D78C06FD543B2F85411722_2116397085.addTaint(taint);
        return var0EECE440B7D78C06FD543B2F85411722_2116397085;
        // ---------- Original Method ----------
        //return immutableCopy(internalPollFirstEntry());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.385 -0400", hash_original_method = "B0B89D697E050FAAC6816A6E8B1E56A4", hash_generated_method = "45639CD4F8A7960AB0F76E59B3F86639")
    public K firstKey() {
        if(root == null)        
        {
            NoSuchElementException var28D00AB599969908D71F102AF992D49A_873687230 = new NoSuchElementException();
            var28D00AB599969908D71F102AF992D49A_873687230.addTaint(taint);
            throw var28D00AB599969908D71F102AF992D49A_873687230;
        } //End block
K varFFDB4EE987544BDFCAAFFDF456CF9ED7_2005565213 =         root.first().getKey();
        varFFDB4EE987544BDFCAAFFDF456CF9ED7_2005565213.addTaint(taint);
        return varFFDB4EE987544BDFCAAFFDF456CF9ED7_2005565213;
        // ---------- Original Method ----------
        //if (root == null) {
            //throw new NoSuchElementException();
        //}
        //return root.first().getKey();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.385 -0400", hash_original_method = "9DDE470F0E6425136CCDC59F74FCDED6", hash_generated_method = "FBFF331DFF9FD7C7DCA0277A9F4B1F56")
    public Entry<K, V> lastEntry() {
Entry<K, V> varB7DBB4F9C12E716C4523A7BCAD68DA7B_980612346 =         immutableCopy(root == null ? null : root.last());
        varB7DBB4F9C12E716C4523A7BCAD68DA7B_980612346.addTaint(taint);
        return varB7DBB4F9C12E716C4523A7BCAD68DA7B_980612346;
        // ---------- Original Method ----------
        //return immutableCopy(root == null ? null : root.last());
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.385 -0400", hash_original_method = "A726E2736A4C282A51BDD8062FE5CCFA", hash_generated_method = "2C0243DBF384000A2D892057D6A4EDC1")
    private Entry<K, V> internalPollLastEntry() {
        if(root == null)        
        {
Entry<K, V> var540C13E9E156B687226421B24F2DF178_1361354396 =             null;
            var540C13E9E156B687226421B24F2DF178_1361354396.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1361354396;
        } //End block
        Node<K, V> result = root.last();
        removeInternal(result);
Entry<K, V> varDC838461EE2FA0CA4C9BBB70A15456B0_1062286291 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1062286291.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1062286291;
        // ---------- Original Method ----------
        //if (root == null) {
            //return null;
        //}
        //Node<K, V> result = root.last();
        //removeInternal(result);
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.385 -0400", hash_original_method = "5064879999AB9A13D0821F605568F112", hash_generated_method = "291B59401FC6112C81277C32A0627EF4")
    public Entry<K, V> pollLastEntry() {
Entry<K, V> var44A4321894496F1D46DEB734245D76D0_1990421553 =         immutableCopy(internalPollLastEntry());
        var44A4321894496F1D46DEB734245D76D0_1990421553.addTaint(taint);
        return var44A4321894496F1D46DEB734245D76D0_1990421553;
        // ---------- Original Method ----------
        //return immutableCopy(internalPollLastEntry());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.385 -0400", hash_original_method = "9EE1928205B19C964D03E8011BB7E907", hash_generated_method = "451040275CF8B1301DAF0D1964AD3B8C")
    public K lastKey() {
        if(root == null)        
        {
            NoSuchElementException var28D00AB599969908D71F102AF992D49A_451909438 = new NoSuchElementException();
            var28D00AB599969908D71F102AF992D49A_451909438.addTaint(taint);
            throw var28D00AB599969908D71F102AF992D49A_451909438;
        } //End block
K var89E8F762FABDD09081364F205A5E223D_1358037594 =         root.last().getKey();
        var89E8F762FABDD09081364F205A5E223D_1358037594.addTaint(taint);
        return var89E8F762FABDD09081364F205A5E223D_1358037594;
        // ---------- Original Method ----------
        //if (root == null) {
            //throw new NoSuchElementException();
        //}
        //return root.last().getKey();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.385 -0400", hash_original_method = "9D71F38DCAD7DBC2AA9FACCDA9CF4866", hash_generated_method = "CE49465CD0F5C880DD3A31B61D48C0EE")
    public Entry<K, V> lowerEntry(K key) {
        addTaint(key.getTaint());
Entry<K, V> var2CD740B62094A0BE9D7BBD31060576E2_996278142 =         immutableCopy(find(key, LOWER));
        var2CD740B62094A0BE9D7BBD31060576E2_996278142.addTaint(taint);
        return var2CD740B62094A0BE9D7BBD31060576E2_996278142;
        // ---------- Original Method ----------
        //return immutableCopy(find(key, LOWER));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.385 -0400", hash_original_method = "BC9464ECC7239B355BB45B80204BADD6", hash_generated_method = "3636C675780B4335E6C60C8746818D04")
    public K lowerKey(K key) {
        addTaint(key.getTaint());
        Entry<K, V> entry = find(key, LOWER);
K var15DE16EBAA69B0A4EA051FB5DEC39C10_1424026158 =         entry != null ? entry.getKey() : null;
        var15DE16EBAA69B0A4EA051FB5DEC39C10_1424026158.addTaint(taint);
        return var15DE16EBAA69B0A4EA051FB5DEC39C10_1424026158;
        // ---------- Original Method ----------
        //Entry<K, V> entry = find(key, LOWER);
        //return entry != null ? entry.getKey() : null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.386 -0400", hash_original_method = "5D12D4D534218428856149792C7C973A", hash_generated_method = "C7817021B619213D3EE27C4AA91BDD1F")
    public Entry<K, V> floorEntry(K key) {
        addTaint(key.getTaint());
Entry<K, V> varFC28F480740B0E7D38107EE8EE92D0CE_1933608678 =         immutableCopy(find(key, FLOOR));
        varFC28F480740B0E7D38107EE8EE92D0CE_1933608678.addTaint(taint);
        return varFC28F480740B0E7D38107EE8EE92D0CE_1933608678;
        // ---------- Original Method ----------
        //return immutableCopy(find(key, FLOOR));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.386 -0400", hash_original_method = "9E3521C1E5D0BB4CA97E65B4B91FC561", hash_generated_method = "880CD88C17EE808F26C08DF26CFB2B4F")
    public K floorKey(K key) {
        addTaint(key.getTaint());
        Entry<K, V> entry = find(key, FLOOR);
K var15DE16EBAA69B0A4EA051FB5DEC39C10_112787554 =         entry != null ? entry.getKey() : null;
        var15DE16EBAA69B0A4EA051FB5DEC39C10_112787554.addTaint(taint);
        return var15DE16EBAA69B0A4EA051FB5DEC39C10_112787554;
        // ---------- Original Method ----------
        //Entry<K, V> entry = find(key, FLOOR);
        //return entry != null ? entry.getKey() : null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.386 -0400", hash_original_method = "14BBCA12BBBC651385215255CDF3836D", hash_generated_method = "80B3DF47CCA9DFA0A0B061B97C037B4B")
    public Entry<K, V> ceilingEntry(K key) {
        addTaint(key.getTaint());
Entry<K, V> var131EB57F4C7B5C94393840328ED7CD98_969753598 =         immutableCopy(find(key, CEILING));
        var131EB57F4C7B5C94393840328ED7CD98_969753598.addTaint(taint);
        return var131EB57F4C7B5C94393840328ED7CD98_969753598;
        // ---------- Original Method ----------
        //return immutableCopy(find(key, CEILING));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.386 -0400", hash_original_method = "818E984E93F7F07D0C27D2493F11C2A5", hash_generated_method = "C3B24BEC20A17BBFDC65B4801AF6CF50")
    public K ceilingKey(K key) {
        addTaint(key.getTaint());
        Entry<K, V> entry = find(key, CEILING);
K var15DE16EBAA69B0A4EA051FB5DEC39C10_294055300 =         entry != null ? entry.getKey() : null;
        var15DE16EBAA69B0A4EA051FB5DEC39C10_294055300.addTaint(taint);
        return var15DE16EBAA69B0A4EA051FB5DEC39C10_294055300;
        // ---------- Original Method ----------
        //Entry<K, V> entry = find(key, CEILING);
        //return entry != null ? entry.getKey() : null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.386 -0400", hash_original_method = "AC2414FDDF42A1318F8CC45C80E09BC1", hash_generated_method = "565EA84C7F7A45C75F9C561C93A2697C")
    public Entry<K, V> higherEntry(K key) {
        addTaint(key.getTaint());
Entry<K, V> var1FAF81EDC2E516F856DA0495977C077B_710862771 =         immutableCopy(find(key, HIGHER));
        var1FAF81EDC2E516F856DA0495977C077B_710862771.addTaint(taint);
        return var1FAF81EDC2E516F856DA0495977C077B_710862771;
        // ---------- Original Method ----------
        //return immutableCopy(find(key, HIGHER));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.387 -0400", hash_original_method = "0C080E769BA3B62EBC93442ECCB0FC7D", hash_generated_method = "ACA38850C4D60EAECB3BEBE407172495")
    public K higherKey(K key) {
        addTaint(key.getTaint());
        Entry<K, V> entry = find(key, HIGHER);
K var15DE16EBAA69B0A4EA051FB5DEC39C10_1159489844 =         entry != null ? entry.getKey() : null;
        var15DE16EBAA69B0A4EA051FB5DEC39C10_1159489844.addTaint(taint);
        return var15DE16EBAA69B0A4EA051FB5DEC39C10_1159489844;
        // ---------- Original Method ----------
        //Entry<K, V> entry = find(key, HIGHER);
        //return entry != null ? entry.getKey() : null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.388 -0400", hash_original_method = "6A8618E17145F23513711DA8498038AE", hash_generated_method = "671CFE180618C227BE3F9BE8B24C616A")
    public Comparator<? super K> comparator() {
Comparator<? super K> varFC8F75816E5A2BE67601D262F4DD4CC3_1185112911 =         comparator != NATURAL_ORDER ? comparator : null;
        varFC8F75816E5A2BE67601D262F4DD4CC3_1185112911.addTaint(taint);
        return varFC8F75816E5A2BE67601D262F4DD4CC3_1185112911;
        // ---------- Original Method ----------
        //return comparator != NATURAL_ORDER ? comparator : null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.388 -0400", hash_original_method = "D2C4C51D99D6D10356C2F96D116110D2", hash_generated_method = "15DEF691DDE93A78222D8CB4F2BC7B82")
    @Override
    public Set<Entry<K, V>> entrySet() {
        EntrySet result = entrySet;
Set<Entry<K, V>> var546348868B918B94B697AA7A0212D78D_1102963133 =         result != null ? result : (entrySet = new EntrySet());
        var546348868B918B94B697AA7A0212D78D_1102963133.addTaint(taint);
        return var546348868B918B94B697AA7A0212D78D_1102963133;
        // ---------- Original Method ----------
        //EntrySet result = entrySet;
        //return result != null ? result : (entrySet = new EntrySet());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.388 -0400", hash_original_method = "0E17D4043440FAA66222611D1AC45111", hash_generated_method = "D97ACFDE7388D3B3E213D03322BE44D4")
    @Override
    public Set<K> keySet() {
        KeySet result = keySet;
Set<K> varA3D98E595497E0937159D5BF4C5A28F3_564409736 =         result != null ? result : (keySet = new KeySet());
        varA3D98E595497E0937159D5BF4C5A28F3_564409736.addTaint(taint);
        return varA3D98E595497E0937159D5BF4C5A28F3_564409736;
        // ---------- Original Method ----------
        //KeySet result = keySet;
        //return result != null ? result : (keySet = new KeySet());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.389 -0400", hash_original_method = "016115EA38C293C7AAA8E892AEA754CA", hash_generated_method = "D88D54D5795839FF7F07BA1C52D59A51")
    public NavigableSet<K> navigableKeySet() {
        KeySet result = keySet;
NavigableSet<K> varA3D98E595497E0937159D5BF4C5A28F3_450087542 =         result != null ? result : (keySet = new KeySet());
        varA3D98E595497E0937159D5BF4C5A28F3_450087542.addTaint(taint);
        return varA3D98E595497E0937159D5BF4C5A28F3_450087542;
        // ---------- Original Method ----------
        //KeySet result = keySet;
        //return result != null ? result : (keySet = new KeySet());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.389 -0400", hash_original_method = "DA6DE2093EE8DE46EE4576501F54E528", hash_generated_method = "61AFBAA571A231CB4274E9FABA852F84")
    public NavigableMap<K, V> subMap(K from, boolean fromInclusive, K to, boolean toInclusive) {
        addTaint(toInclusive);
        addTaint(to.getTaint());
        addTaint(fromInclusive);
        addTaint(from.getTaint());
        Bound fromBound = fromInclusive ? INCLUSIVE : EXCLUSIVE;
        Bound toBound = toInclusive ? INCLUSIVE : EXCLUSIVE;
NavigableMap<K, V> varC1ADA0B077817E4E937F0AB6A4E4BFEB_326795118 =         new BoundedMap(true, from, fromBound, to, toBound);
        varC1ADA0B077817E4E937F0AB6A4E4BFEB_326795118.addTaint(taint);
        return varC1ADA0B077817E4E937F0AB6A4E4BFEB_326795118;
        // ---------- Original Method ----------
        //Bound fromBound = fromInclusive ? INCLUSIVE : EXCLUSIVE;
        //Bound toBound = toInclusive ? INCLUSIVE : EXCLUSIVE;
        //return new BoundedMap(true, from, fromBound, to, toBound);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.389 -0400", hash_original_method = "193BA03007E91EBBDB489C20B60BFC88", hash_generated_method = "6BB6B8CB9CBAED369CA5DF253A4EFB76")
    public SortedMap<K, V> subMap(K fromInclusive, K toExclusive) {
        addTaint(toExclusive.getTaint());
        addTaint(fromInclusive.getTaint());
SortedMap<K, V> varD1C8F801B36255D14CED2B3CFD68DC65_688170002 =         new BoundedMap(true, fromInclusive, INCLUSIVE, toExclusive, EXCLUSIVE);
        varD1C8F801B36255D14CED2B3CFD68DC65_688170002.addTaint(taint);
        return varD1C8F801B36255D14CED2B3CFD68DC65_688170002;
        // ---------- Original Method ----------
        //return new BoundedMap(true, fromInclusive, INCLUSIVE, toExclusive, EXCLUSIVE);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.389 -0400", hash_original_method = "FA312E74B0C04D741489E3323E0FFDFE", hash_generated_method = "132250EB8563FF2A9194BB072FDB5222")
    public NavigableMap<K, V> headMap(K to, boolean inclusive) {
        addTaint(inclusive);
        addTaint(to.getTaint());
        Bound toBound = inclusive ? INCLUSIVE : EXCLUSIVE;
NavigableMap<K, V> varAA2AC7CD4326D49962BB154708AC9F4E_234290265 =         new BoundedMap(true, null, NO_BOUND, to, toBound);
        varAA2AC7CD4326D49962BB154708AC9F4E_234290265.addTaint(taint);
        return varAA2AC7CD4326D49962BB154708AC9F4E_234290265;
        // ---------- Original Method ----------
        //Bound toBound = inclusive ? INCLUSIVE : EXCLUSIVE;
        //return new BoundedMap(true, null, NO_BOUND, to, toBound);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.389 -0400", hash_original_method = "CAC178CA3C39A0AC08FB27C63F9A635C", hash_generated_method = "F115429E0CC0CEC82092193D12298EAE")
    public SortedMap<K, V> headMap(K toExclusive) {
        addTaint(toExclusive.getTaint());
SortedMap<K, V> varF36207FD347C9B8A75FD36AB250F2562_2084544995 =         new BoundedMap(true, null, NO_BOUND, toExclusive, EXCLUSIVE);
        varF36207FD347C9B8A75FD36AB250F2562_2084544995.addTaint(taint);
        return varF36207FD347C9B8A75FD36AB250F2562_2084544995;
        // ---------- Original Method ----------
        //return new BoundedMap(true, null, NO_BOUND, toExclusive, EXCLUSIVE);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.389 -0400", hash_original_method = "828BC950C20B857C189141DA99499F09", hash_generated_method = "E1F799729CFB590546C7E3601ED3B253")
    public NavigableMap<K, V> tailMap(K from, boolean inclusive) {
        addTaint(inclusive);
        addTaint(from.getTaint());
        Bound fromBound = inclusive ? INCLUSIVE : EXCLUSIVE;
NavigableMap<K, V> var858AA4077810E3CAD30935021614C398_1172707928 =         new BoundedMap(true, from, fromBound, null, NO_BOUND);
        var858AA4077810E3CAD30935021614C398_1172707928.addTaint(taint);
        return var858AA4077810E3CAD30935021614C398_1172707928;
        // ---------- Original Method ----------
        //Bound fromBound = inclusive ? INCLUSIVE : EXCLUSIVE;
        //return new BoundedMap(true, from, fromBound, null, NO_BOUND);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.390 -0400", hash_original_method = "79B47D2E0956F27B23E0B18E5FD19D6A", hash_generated_method = "F76D8B004F22DC740F898636C13D287A")
    public SortedMap<K, V> tailMap(K fromInclusive) {
        addTaint(fromInclusive.getTaint());
SortedMap<K, V> var238F6B1D3AB45506AAB3C8043B1183BA_692610858 =         new BoundedMap(true, fromInclusive, INCLUSIVE, null, NO_BOUND);
        var238F6B1D3AB45506AAB3C8043B1183BA_692610858.addTaint(taint);
        return var238F6B1D3AB45506AAB3C8043B1183BA_692610858;
        // ---------- Original Method ----------
        //return new BoundedMap(true, fromInclusive, INCLUSIVE, null, NO_BOUND);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.390 -0400", hash_original_method = "5AD6A5A37D3C9366BEF11B75DC396D31", hash_generated_method = "F6619A914F54F978F5CEFA48433AD62B")
    public NavigableMap<K, V> descendingMap() {
NavigableMap<K, V> var1294C8AE6093F28046A52F9C508EC87F_691939230 =         new BoundedMap(false, null, NO_BOUND, null, NO_BOUND);
        var1294C8AE6093F28046A52F9C508EC87F_691939230.addTaint(taint);
        return var1294C8AE6093F28046A52F9C508EC87F_691939230;
        // ---------- Original Method ----------
        //return new BoundedMap(false, null, NO_BOUND, null, NO_BOUND);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.390 -0400", hash_original_method = "1207DF79B9959BCB242E95030D6177B0", hash_generated_method = "B55B98D34D1D0D4E321F3F2DE53BE34B")
    public NavigableSet<K> descendingKeySet() {
NavigableSet<K> var147103AFA753373FDDCF430FA02E998F_84879498 =         new BoundedMap(false, null, NO_BOUND, null, NO_BOUND).navigableKeySet();
        var147103AFA753373FDDCF430FA02E998F_84879498.addTaint(taint);
        return var147103AFA753373FDDCF430FA02E998F_84879498;
        // ---------- Original Method ----------
        //return new BoundedMap(false, null, NO_BOUND, null, NO_BOUND).navigableKeySet();
    }

    
    @DSModeled(DSC.SAFE)
    static int count(Iterator<?> iterator) {
        int count = 0;
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }
        return count;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.390 -0400", hash_original_method = "BF81D129CE69F9BEB40CAD27F974F3C8", hash_generated_method = "913EA14829CB66885A0D07F3ADF68B3F")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        addTaint(stream.getTaint());
        stream.putFields().put("comparator", comparator != NATURAL_ORDER ? comparator : null);
        stream.writeFields();
        stream.writeInt(size);
for(Map.Entry<K, V> entry : entrySet())
        {
            stream.writeObject(entry.getKey());
            stream.writeObject(entry.getValue());
        } //End block
        // ---------- Original Method ----------
        //stream.putFields().put("comparator", comparator != NATURAL_ORDER ? comparator : null);
        //stream.writeFields();
        //stream.writeInt(size);
        //for (Map.Entry<K, V> entry : entrySet()) {
            //stream.writeObject(entry.getKey());
            //stream.writeObject(entry.getValue());
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.390 -0400", hash_original_method = "4DE82E48A11AFCCB2DCFEAE704B1F475", hash_generated_method = "14915F7022307C7DC1B494E04297B335")
    @SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        addTaint(stream.getTaint());
        GetField fields = stream.readFields();
        comparator = (Comparator<? super K>) fields.get("comparator", null);
        if(comparator == null)        
        {
            comparator = (Comparator<? super K>) NATURAL_ORDER;
        } //End block
        int size = stream.readInt();
for(int i = 0;i < size;i++)
        {
            putInternal((K) stream.readObject(), (V) stream.readObject());
        } //End block
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
        @DSModeled(DSC.SAFE)
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.390 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "8813BD57943FF9B7DFC4722D0BF25C24")

        Node<K, V> parent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.390 -0400", hash_original_field = "811882FECD5C7618D7099EBBD39EA254", hash_generated_field = "25F53C0BDEE77B7CD3BD6D035AA5E15F")

        Node<K, V> left;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.390 -0400", hash_original_field = "7C4F29407893C334A6CB7A87BF045C0D", hash_generated_field = "37DD2CA6D859801A463F8F880FD4F30D")

        Node<K, V> right;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.390 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "F780C5984CF24E477CB9559E91475987")

        K key;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.390 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "A7E8A049E4C72FD5713D3AFD6CBF7C08")

        V value;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.390 -0400", hash_original_field = "B435E227D5DD201E1768B2BCB2E0AA81", hash_generated_field = "CE84F1587D182C1F0A32D7CD44443A18")

        int height;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.391 -0400", hash_original_method = "62891C3DA898C4CAE2A216E3248BC6D0", hash_generated_method = "DE342B9B0B30391F4646033D3553010C")
          Node(Node<K, V> parent, K key) {
            this.parent = parent;
            this.key = key;
            this.height = 1;
            // ---------- Original Method ----------
            //this.parent = parent;
            //this.key = key;
            //this.height = 1;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.391 -0400", hash_original_method = "81E3C4E28B5839A0B87A03CA341E9BD1", hash_generated_method = "20ED39F4DF689209683C28AA6A468834")
         Node<K, V> copy(Node<K, V> parent) {
            addTaint(parent.getTaint());
            Node<K, V> result = new Node<K, V>(parent, key);
            if(left != null)            
            {
                result.left = left.copy(result);
            } //End block
            if(right != null)            
            {
                result.right = right.copy(result);
            } //End block
            result.value = value;
            result.height = height;
Node<K, V> varDC838461EE2FA0CA4C9BBB70A15456B0_2096459981 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_2096459981.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_2096459981;
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.391 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "9B676D91431AA7ECC0B13C6892DEBCE4")
        public K getKey() {
K var6A95247616A3A8B93CFF7783DABD08D4_51680378 =             key;
            var6A95247616A3A8B93CFF7783DABD08D4_51680378.addTaint(taint);
            return var6A95247616A3A8B93CFF7783DABD08D4_51680378;
            // ---------- Original Method ----------
            //return key;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.391 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "A5E439AD59C9114B520D12AAB31A5CCA")
        public V getValue() {
V varAF280DA2BC37D8BE783D8499160168DE_918074591 =             value;
            varAF280DA2BC37D8BE783D8499160168DE_918074591.addTaint(taint);
            return varAF280DA2BC37D8BE783D8499160168DE_918074591;
            // ---------- Original Method ----------
            //return value;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.391 -0400", hash_original_method = "B73895AEE255DB24C138E57D2456050E", hash_generated_method = "4CDA922CCD246200C167BD13F5DF9515")
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
V var8CDBD2181CBEF5C2129AFFA68C014D4A_904751436 =             oldValue;
            var8CDBD2181CBEF5C2129AFFA68C014D4A_904751436.addTaint(taint);
            return var8CDBD2181CBEF5C2129AFFA68C014D4A_904751436;
            // ---------- Original Method ----------
            //V oldValue = this.value;
            //this.value = value;
            //return oldValue;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.392 -0400", hash_original_method = "08E0671CAB8873A0A05165CE64371DB8", hash_generated_method = "DAFC6E5589262B2556F90E287173C788")
        @Override
        public boolean equals(Object o) {
            addTaint(o.getTaint());
            if(o instanceof Map.Entry)            
            {
                Map.Entry other = (Map.Entry) o;
                boolean var2F838DD1DBC9D4D4CEF8D80C17D3B446_239752765 = ((key == null ? other.getKey() == null : key.equals(other.getKey()))
                        && (value == null ? other.getValue() == null : value.equals(other.getValue())));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_910793696 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_910793696;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_762663402 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_805724533 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_805724533;
            // ---------- Original Method ----------
            //if (o instanceof Map.Entry) {
                //Map.Entry other = (Map.Entry) o;
                //return (key == null ? other.getKey() == null : key.equals(other.getKey()))
                        //&& (value == null ? other.getValue() == null : value.equals(other.getValue()));
            //}
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.392 -0400", hash_original_method = "6416487D313DFCFD3052C01ADB883217", hash_generated_method = "FF2CBDCD625592C6D82ECF0D24883FCE")
        @Override
        public int hashCode() {
            int var6426FEC1614D5FE74370608AA1AC68B8_1474283807 = ((key == null ? 0 : key.hashCode())
                    ^ (value == null ? 0 : value.hashCode()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_25473286 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_25473286;
            // ---------- Original Method ----------
            //return (key == null ? 0 : key.hashCode())
                    //^ (value == null ? 0 : value.hashCode());
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.392 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "3F813F0149868591C64D9B29EF25F139")
        @Override
        public String toString() {
String varFE698C13EFD83B87FAF2DC2AB0874271_1963007300 =             key + "=" + value;
            varFE698C13EFD83B87FAF2DC2AB0874271_1963007300.addTaint(taint);
            return varFE698C13EFD83B87FAF2DC2AB0874271_1963007300;
            // ---------- Original Method ----------
            //return key + "=" + value;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.392 -0400", hash_original_method = "4A8921E3C940E88A3EF0004D6F064697", hash_generated_method = "AEBD9797971565899391825918DF3CA1")
         Node<K, V> next() {
            if(right != null)            
            {
Node<K, V> var49ECFE5B15D077B6A57AF2EF5E52D000_1155553424 =                 right.first();
                var49ECFE5B15D077B6A57AF2EF5E52D000_1155553424.addTaint(taint);
                return var49ECFE5B15D077B6A57AF2EF5E52D000_1155553424;
            } //End block
            Node<K, V> node = this;
            Node<K, V> parent = node.parent;
            while
(parent != null)            
            {
                if(parent.left == node)                
                {
Node<K, V> var0F49909EA73F8892C338E4DCA6EB9906_1626343001 =                     parent;
                    var0F49909EA73F8892C338E4DCA6EB9906_1626343001.addTaint(taint);
                    return var0F49909EA73F8892C338E4DCA6EB9906_1626343001;
                } //End block
                node = parent;
                parent = node.parent;
            } //End block
Node<K, V> var540C13E9E156B687226421B24F2DF178_1520750945 =             null;
            var540C13E9E156B687226421B24F2DF178_1520750945.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1520750945;
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.392 -0400", hash_original_method = "A5795D04699EE4D7981584600E0900FB", hash_generated_method = "DD38CE94F4B9C42E12165AA33222EB90")
        public Node<K, V> prev() {
            if(left != null)            
            {
Node<K, V> varF107747D6B949A969681DC4598F3BB98_57106280 =                 left.last();
                varF107747D6B949A969681DC4598F3BB98_57106280.addTaint(taint);
                return varF107747D6B949A969681DC4598F3BB98_57106280;
            } //End block
            Node<K, V> node = this;
            Node<K, V> parent = node.parent;
            while
(parent != null)            
            {
                if(parent.right == node)                
                {
Node<K, V> var0F49909EA73F8892C338E4DCA6EB9906_546619059 =                     parent;
                    var0F49909EA73F8892C338E4DCA6EB9906_546619059.addTaint(taint);
                    return var0F49909EA73F8892C338E4DCA6EB9906_546619059;
                } //End block
                node = parent;
                parent = node.parent;
            } //End block
Node<K, V> var540C13E9E156B687226421B24F2DF178_1500300747 =             null;
            var540C13E9E156B687226421B24F2DF178_1500300747.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1500300747;
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.392 -0400", hash_original_method = "4F7C0267C30B98E081694FF304478F8A", hash_generated_method = "BE4840C095CA991231AF2B9420CF6BAB")
        public Node<K, V> first() {
            Node<K, V> node = this;
            Node<K, V> child = node.left;
            while
(child != null)            
            {
                node = child;
                child = node.left;
            } //End block
Node<K, V> var1924C94B76524D1C3D7310EA17B0EF94_1865575860 =             node;
            var1924C94B76524D1C3D7310EA17B0EF94_1865575860.addTaint(taint);
            return var1924C94B76524D1C3D7310EA17B0EF94_1865575860;
            // ---------- Original Method ----------
            //Node<K, V> node = this;
            //Node<K, V> child = node.left;
            //while (child != null) {
                //node = child;
                //child = node.left;
            //}
            //return node;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.392 -0400", hash_original_method = "E5BF79B4B513B5631F4BBC9604CA3FC9", hash_generated_method = "1FBD51F3CACF4723430C92671421701B")
        public Node<K, V> last() {
            Node<K, V> node = this;
            Node<K, V> child = node.right;
            while
(child != null)            
            {
                node = child;
                child = node.right;
            } //End block
Node<K, V> var1924C94B76524D1C3D7310EA17B0EF94_275470883 =             node;
            var1924C94B76524D1C3D7310EA17B0EF94_275470883.addTaint(taint);
            return var1924C94B76524D1C3D7310EA17B0EF94_275470883;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.393 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "4E383A6783C389E295874CEC0140061D")

        protected Node<K, V> next;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.393 -0400", hash_original_field = "98BD1C45684CF587AC2347A92DD7BB51", hash_generated_field = "A9411E67538F8DD40B9344B2A6DD22CB")

        protected Node<K, V> last;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.393 -0400", hash_original_field = "587E194BCD330DA9D6CB9DB53EA8709A", hash_generated_field = "AB0DDF01BBCC99511DA5FB1867F9AF26")

        protected int expectedModCount = modCount;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.393 -0400", hash_original_method = "1934503C2038D80E73C2C0A3DE09B0C3", hash_generated_method = "8E0327A33AFF8D45EE12C60F2FAE7675")
          MapIterator(Node<K, V> next) {
            this.next = next;
            // ---------- Original Method ----------
            //this.next = next;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.393 -0400", hash_original_method = "5C1B7B0DA20667590A4D5C5559468A28", hash_generated_method = "5D06E5E9AFB987194D4D024F463595B0")
        public boolean hasNext() {
            boolean var1D0482B34E42F032728DF2F52373E7A2_613423371 = (next != null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_859414382 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_859414382;
            // ---------- Original Method ----------
            //return next != null;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.393 -0400", hash_original_method = "85C80BB4AD318538DB8131E722149B15", hash_generated_method = "B975A1095FBFCB67235058A3006D1B6D")
        protected Node<K, V> stepForward() {
            if(next == null)            
            {
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_1707397385 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_1707397385.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_1707397385;
            } //End block
            if(modCount != expectedModCount)            
            {
                ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_552468789 = new ConcurrentModificationException();
                var779BA6969BD29E5F2D0448781C543B65_552468789.addTaint(taint);
                throw var779BA6969BD29E5F2D0448781C543B65_552468789;
            } //End block
            last = next;
            next = next.next();
Node<K, V> var3D331EA760A7BCD3BF7E380A6C79C638_279335897 =             last;
            var3D331EA760A7BCD3BF7E380A6C79C638_279335897.addTaint(taint);
            return var3D331EA760A7BCD3BF7E380A6C79C638_279335897;
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.393 -0400", hash_original_method = "A54C5D61E9DBD724A09A36F78C304124", hash_generated_method = "DA58A325CF55FC772D8594B975C156E5")
        protected Node<K, V> stepBackward() {
            if(next == null)            
            {
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_1464512214 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_1464512214.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_1464512214;
            } //End block
            if(modCount != expectedModCount)            
            {
                ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_2144913113 = new ConcurrentModificationException();
                var779BA6969BD29E5F2D0448781C543B65_2144913113.addTaint(taint);
                throw var779BA6969BD29E5F2D0448781C543B65_2144913113;
            } //End block
            last = next;
            next = next.prev();
Node<K, V> var3D331EA760A7BCD3BF7E380A6C79C638_738207279 =             last;
            var3D331EA760A7BCD3BF7E380A6C79C638_738207279.addTaint(taint);
            return var3D331EA760A7BCD3BF7E380A6C79C638_738207279;
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.393 -0400", hash_original_method = "36CB2F7F3A40368DEE67850156136E6A", hash_generated_method = "751BAB52BFBB154D1CAE9E2BD13EF361")
        public void remove() {
            if(last == null)            
            {
                IllegalStateException varC311A989A119B96A6232C22ABFE87C25_666488378 = new IllegalStateException();
                varC311A989A119B96A6232C22ABFE87C25_666488378.addTaint(taint);
                throw varC311A989A119B96A6232C22ABFE87C25_666488378;
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
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.393 -0400", hash_original_method = "AA90B2AD56C6E037D76F6D8ACC9327A5", hash_generated_method = "AA90B2AD56C6E037D76F6D8ACC9327A5")
        public EntrySet ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.394 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "B38E6FBF565A9E6E05C0117C5F3E2E19")
        @Override
        public int size() {
            int varF7BD60B75B29D79B660A2859395C1A24_1303806461 = (size);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_149193566 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_149193566;
            // ---------- Original Method ----------
            //return size;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.394 -0400", hash_original_method = "B4D4FA13F54A295418FF58C47A14DDE9", hash_generated_method = "08B1384F60C9BE44161E455AA60B25B9")
        @Override
        public Iterator<Entry<K, V>> iterator() {
Iterator<Entry<K, V>> var622BFC9B0FC71AB66EF04995E784B17E_614310421 =             new MapIterator<Entry<K, V>>(root == null ? null : root.first()) {            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.394 -0400", hash_original_method = "86F000434530E8D6B0755FFE9A16C5F8", hash_generated_method = "4BE0C7785663E2E9FA82B3C401C686B4")
            public Entry<K, V> next() {
Entry<K, V> varBEFE63D427BFF5E467D509E70ABD58CE_1041489519 =                 stepForward();
                varBEFE63D427BFF5E467D509E70ABD58CE_1041489519.addTaint(taint);
                return varBEFE63D427BFF5E467D509E70ABD58CE_1041489519;
                // ---------- Original Method ----------
                //return stepForward();
            }
};
            var622BFC9B0FC71AB66EF04995E784B17E_614310421.addTaint(taint);
            return var622BFC9B0FC71AB66EF04995E784B17E_614310421;
            // ---------- Original Method ----------
            //return new MapIterator<Entry<K, V>>(root == null ? null : root.first()) {
                //public Entry<K, V> next() {
                    //return stepForward();
                //}
            //};
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.394 -0400", hash_original_method = "AAE5A29808B951CC80BD03F648B6A63A", hash_generated_method = "459BCDFA67A108843CDA544267059F17")
        @Override
        public boolean contains(Object o) {
            addTaint(o.getTaint());
            boolean var9956AA7309D9CCD50D7FC35B407023ED_328408853 = (o instanceof Entry && findByEntry((Entry<?, ?>) o) != null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1035495509 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1035495509;
            // ---------- Original Method ----------
            //return o instanceof Entry && findByEntry((Entry<?, ?>) o) != null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.394 -0400", hash_original_method = "50402191313F22EA9CF206F14CC9A5A4", hash_generated_method = "1F1ABDD203825706F392D770EDCB01D8")
        @Override
        public boolean remove(Object o) {
            addTaint(o.getTaint());
            if(!(o instanceof Entry))            
            {
                boolean var68934A3E9455FA72420237EB05902327_82339228 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_272344355 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_272344355;
            } //End block
            Node<K, V> node = findByEntry((Entry<?, ?>) o);
            if(node == null)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1495655665 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1921321809 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1921321809;
            } //End block
            removeInternal(node);
            boolean varB326B5062B2F0E69046810717534CB09_1487674842 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1634914282 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1634914282;
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.394 -0400", hash_original_method = "1CC2A082C181027407DFF573950B6D85", hash_generated_method = "E132377B1C3D8FD49066BD79A34C72A8")
        @Override
        public void clear() {
            TreeMap.this.clear();
            // ---------- Original Method ----------
            //TreeMap.this.clear();
        }

        
    }


    
    class KeySet extends AbstractSet<K> implements NavigableSet<K> {
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.394 -0400", hash_original_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF", hash_generated_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF")
        public KeySet ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.394 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "D20328811C764BF9255B0DA7AFF29FB0")
        @Override
        public int size() {
            int varF7BD60B75B29D79B660A2859395C1A24_386134805 = (size);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1016238857 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1016238857;
            // ---------- Original Method ----------
            //return size;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.395 -0400", hash_original_method = "7A518595D7BAAD9E696AF11FE92FFDBE", hash_generated_method = "A5C7370937EF6533806E5C701C915836")
        @Override
        public Iterator<K> iterator() {
Iterator<K> varC6C6F031377E271DFB1816B61A8EA88F_1443392908 =             new MapIterator<K>(root == null ? null : root.first()) {            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.395 -0400", hash_original_method = "E581E07EB6E816B7B0F53BDF6AE52418", hash_generated_method = "B3B40503996237A4E981BADF67FB3C91")
            public K next() {
K varED589F5CB2626464AC74D486990A7A15_713493815 =                 stepForward().key;
                varED589F5CB2626464AC74D486990A7A15_713493815.addTaint(taint);
                return varED589F5CB2626464AC74D486990A7A15_713493815;
                // ---------- Original Method ----------
                //return stepForward().key;
            }
};
            varC6C6F031377E271DFB1816B61A8EA88F_1443392908.addTaint(taint);
            return varC6C6F031377E271DFB1816B61A8EA88F_1443392908;
            // ---------- Original Method ----------
            //return new MapIterator<K>(root == null ? null : root.first()) {
                //public K next() {
                    //return stepForward().key;
                //}
            //};
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.395 -0400", hash_original_method = "C8D968F3C5FE84BB3D2A53544A3D4B19", hash_generated_method = "DFEC2748635A9728BBC4A153F1CD9035")
        public Iterator<K> descendingIterator() {
Iterator<K> var684ADF17601F4E6DD3748CC4B25E0E8D_2021365314 =             new MapIterator<K>(root == null ? null : root.last()) {            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.395 -0400", hash_original_method = "30CD89883F8CEF7ECE49A6E9F42F1507", hash_generated_method = "3E677B0B05EF009C3C0689FAAA5C4159")
            public K next() {
K varFE3C1A21095894F113C168C20974D3B7_1118199779 =                 stepBackward().key;
                varFE3C1A21095894F113C168C20974D3B7_1118199779.addTaint(taint);
                return varFE3C1A21095894F113C168C20974D3B7_1118199779;
                // ---------- Original Method ----------
                //return stepBackward().key;
            }
};
            var684ADF17601F4E6DD3748CC4B25E0E8D_2021365314.addTaint(taint);
            return var684ADF17601F4E6DD3748CC4B25E0E8D_2021365314;
            // ---------- Original Method ----------
            //return new MapIterator<K>(root == null ? null : root.last()) {
                //public K next() {
                    //return stepBackward().key;
                //}
            //};
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.395 -0400", hash_original_method = "55474555B71DFC8666AC2B6E4F0261A5", hash_generated_method = "241B84FCE7FAD2545E868B98D331349B")
        @Override
        public boolean contains(Object o) {
            addTaint(o.getTaint());
            boolean var6CE6D88A4041ABB2C763C00DFE3D40ED_1088231482 = (containsKey(o));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1011623749 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1011623749;
            // ---------- Original Method ----------
            //return containsKey(o);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.395 -0400", hash_original_method = "174345B10BAB0003712B28F94B9BEA53", hash_generated_method = "0FFD86D9B268988D9EF72D55AC38B618")
        @Override
        public boolean remove(Object key) {
            addTaint(key.getTaint());
            boolean var1C50BB7C86DAF131C5CF146B5D063A21_1548511868 = (removeInternalByKey(key) != null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_8808861 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_8808861;
            // ---------- Original Method ----------
            //return removeInternalByKey(key) != null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.395 -0400", hash_original_method = "1CC2A082C181027407DFF573950B6D85", hash_generated_method = "E132377B1C3D8FD49066BD79A34C72A8")
        @Override
        public void clear() {
            TreeMap.this.clear();
            // ---------- Original Method ----------
            //TreeMap.this.clear();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.395 -0400", hash_original_method = "E1A1305471DEE1FE749764F6E03BE3A0", hash_generated_method = "C7818EC65508E1FD0378C372C72437AE")
        public Comparator<? super K> comparator() {
Comparator<? super K> varEE9621AAB15522B49DAC63CE835E2941_1657680967 =             TreeMap.this.comparator();
            varEE9621AAB15522B49DAC63CE835E2941_1657680967.addTaint(taint);
            return varEE9621AAB15522B49DAC63CE835E2941_1657680967;
            // ---------- Original Method ----------
            //return TreeMap.this.comparator();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.395 -0400", hash_original_method = "3067DEE01FBBBFD061436C7D4561F434", hash_generated_method = "2C1F2B80BE5099C6CC737F87CBF345EC")
        public K first() {
K var59F2D49FC0979EFEDD893E9689C2AA6B_647562204 =             firstKey();
            var59F2D49FC0979EFEDD893E9689C2AA6B_647562204.addTaint(taint);
            return var59F2D49FC0979EFEDD893E9689C2AA6B_647562204;
            // ---------- Original Method ----------
            //return firstKey();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.395 -0400", hash_original_method = "39C87F788E647BCD3FB86FFF34D7EF10", hash_generated_method = "E83882116D9474B8DA62E987E82D7AF4")
        public K last() {
K var9DAA79F4D4E0401E91D6AAF423D49398_687491925 =             lastKey();
            var9DAA79F4D4E0401E91D6AAF423D49398_687491925.addTaint(taint);
            return var9DAA79F4D4E0401E91D6AAF423D49398_687491925;
            // ---------- Original Method ----------
            //return lastKey();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.396 -0400", hash_original_method = "5CFE05BF706A06BBB501067306F1B9ED", hash_generated_method = "79CE01DB5D41E90D3D1961971D6B0A44")
        public K lower(K key) {
            addTaint(key.getTaint());
K var2B86BD115FCBD0ED4D0B4CB097A2C388_519970440 =             lowerKey(key);
            var2B86BD115FCBD0ED4D0B4CB097A2C388_519970440.addTaint(taint);
            return var2B86BD115FCBD0ED4D0B4CB097A2C388_519970440;
            // ---------- Original Method ----------
            //return lowerKey(key);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.396 -0400", hash_original_method = "10BABB7BB2E837824A13AAE89EE7EC6F", hash_generated_method = "FC71AF77B8FE05D1A78FA69AF1E9FB2E")
        public K floor(K key) {
            addTaint(key.getTaint());
K var350534B70A929DCE92BCA350B3F7DA8E_124869356 =             floorKey(key);
            var350534B70A929DCE92BCA350B3F7DA8E_124869356.addTaint(taint);
            return var350534B70A929DCE92BCA350B3F7DA8E_124869356;
            // ---------- Original Method ----------
            //return floorKey(key);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.396 -0400", hash_original_method = "2AD4706A6D818B709A1E2CA64B48B4B9", hash_generated_method = "15DD3314DD9285CC86FFAF616F295E4A")
        public K ceiling(K key) {
            addTaint(key.getTaint());
K varC33643BEB47C1CC66B2C2CDB25527B59_1820794234 =             ceilingKey(key);
            varC33643BEB47C1CC66B2C2CDB25527B59_1820794234.addTaint(taint);
            return varC33643BEB47C1CC66B2C2CDB25527B59_1820794234;
            // ---------- Original Method ----------
            //return ceilingKey(key);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.396 -0400", hash_original_method = "8CC63649234BFC57DB10A2387AE34DD6", hash_generated_method = "211EEF49E9DB40A724C5B8B8EFC795AA")
        public K higher(K key) {
            addTaint(key.getTaint());
K var75CF48C4839A7AAF074C16D584CD6253_1611036069 =             higherKey(key);
            var75CF48C4839A7AAF074C16D584CD6253_1611036069.addTaint(taint);
            return var75CF48C4839A7AAF074C16D584CD6253_1611036069;
            // ---------- Original Method ----------
            //return higherKey(key);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.396 -0400", hash_original_method = "0E3C9584B722234668005FBA598A1EC0", hash_generated_method = "582C71EC83854437C45BD4ECAB12FC0E")
        public K pollFirst() {
            Entry<K, V> entry = internalPollFirstEntry();
K var15DE16EBAA69B0A4EA051FB5DEC39C10_1410747018 =             entry != null ? entry.getKey() : null;
            var15DE16EBAA69B0A4EA051FB5DEC39C10_1410747018.addTaint(taint);
            return var15DE16EBAA69B0A4EA051FB5DEC39C10_1410747018;
            // ---------- Original Method ----------
            //Entry<K, V> entry = internalPollFirstEntry();
            //return entry != null ? entry.getKey() : null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.396 -0400", hash_original_method = "ABD0A1CFCFA4D3D1F242F2375F97811C", hash_generated_method = "77E3A5EDA608877B2105AD6CB47399B4")
        public K pollLast() {
            Entry<K, V> entry = internalPollLastEntry();
K var15DE16EBAA69B0A4EA051FB5DEC39C10_237366973 =             entry != null ? entry.getKey() : null;
            var15DE16EBAA69B0A4EA051FB5DEC39C10_237366973.addTaint(taint);
            return var15DE16EBAA69B0A4EA051FB5DEC39C10_237366973;
            // ---------- Original Method ----------
            //Entry<K, V> entry = internalPollLastEntry();
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.396 -0400", hash_original_method = "21828DA90728B75367EF3BEE7D62C832", hash_generated_method = "2E4201D2362A504529F86E585130A331")
        public NavigableSet<K> subSet(K from, boolean fromInclusive, K to, boolean toInclusive) {
            addTaint(toInclusive);
            addTaint(to.getTaint());
            addTaint(fromInclusive);
            addTaint(from.getTaint());
NavigableSet<K> var1E006BA33691F75FD5C590518669F7CF_1005058275 =             TreeMap.this.subMap(from, fromInclusive, to, toInclusive).navigableKeySet();
            var1E006BA33691F75FD5C590518669F7CF_1005058275.addTaint(taint);
            return var1E006BA33691F75FD5C590518669F7CF_1005058275;
            // ---------- Original Method ----------
            //return TreeMap.this.subMap(from, fromInclusive, to, toInclusive).navigableKeySet();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.396 -0400", hash_original_method = "B37C6130D4B0113815E317EEB111D1E9", hash_generated_method = "8EED1081530EB87C5A39D4E4ED7881AB")
        public SortedSet<K> subSet(K fromInclusive, K toExclusive) {
            addTaint(toExclusive.getTaint());
            addTaint(fromInclusive.getTaint());
SortedSet<K> varAEEB9B76D84A9A3D1311D62B7C8E400F_254578809 =             TreeMap.this.subMap(fromInclusive, true, toExclusive, false).navigableKeySet();
            varAEEB9B76D84A9A3D1311D62B7C8E400F_254578809.addTaint(taint);
            return varAEEB9B76D84A9A3D1311D62B7C8E400F_254578809;
            // ---------- Original Method ----------
            //return TreeMap.this.subMap(fromInclusive, true, toExclusive, false).navigableKeySet();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.396 -0400", hash_original_method = "15C518A93EE21ED6E81237BD492369B4", hash_generated_method = "A124BB0357679F203AEC92A15A76B098")
        public NavigableSet<K> headSet(K to, boolean inclusive) {
            addTaint(inclusive);
            addTaint(to.getTaint());
NavigableSet<K> var2AC6FCA4CD759F1D6886D1E522029C64_173148844 =             TreeMap.this.headMap(to, inclusive).navigableKeySet();
            var2AC6FCA4CD759F1D6886D1E522029C64_173148844.addTaint(taint);
            return var2AC6FCA4CD759F1D6886D1E522029C64_173148844;
            // ---------- Original Method ----------
            //return TreeMap.this.headMap(to, inclusive).navigableKeySet();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.396 -0400", hash_original_method = "1E1BD4D122D1F75D80BDC2474EF32137", hash_generated_method = "E0814C0D314042BF9AFC76298E197FAA")
        public SortedSet<K> headSet(K toExclusive) {
            addTaint(toExclusive.getTaint());
SortedSet<K> var9CABB3B743BD7889D426F02DACBBE99F_972687639 =             TreeMap.this.headMap(toExclusive, false).navigableKeySet();
            var9CABB3B743BD7889D426F02DACBBE99F_972687639.addTaint(taint);
            return var9CABB3B743BD7889D426F02DACBBE99F_972687639;
            // ---------- Original Method ----------
            //return TreeMap.this.headMap(toExclusive, false).navigableKeySet();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.397 -0400", hash_original_method = "3007AE414049BD587DD344AEC05F7630", hash_generated_method = "98F4F8D293381E7963362222061B8105")
        public NavigableSet<K> tailSet(K from, boolean inclusive) {
            addTaint(inclusive);
            addTaint(from.getTaint());
NavigableSet<K> var119889AEAA5B3E18E2858897784D1CE7_1556931084 =             TreeMap.this.tailMap(from, inclusive).navigableKeySet();
            var119889AEAA5B3E18E2858897784D1CE7_1556931084.addTaint(taint);
            return var119889AEAA5B3E18E2858897784D1CE7_1556931084;
            // ---------- Original Method ----------
            //return TreeMap.this.tailMap(from, inclusive).navigableKeySet();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.397 -0400", hash_original_method = "4DA58A152F26E7271643C0314BDDDB69", hash_generated_method = "B8130BEB4ABD34E9261B84E5AE5F0053")
        public SortedSet<K> tailSet(K fromInclusive) {
            addTaint(fromInclusive.getTaint());
SortedSet<K> varFF4E3FFD47F6151862E3275C1D99A159_239939253 =             TreeMap.this.tailMap(fromInclusive, true).navigableKeySet();
            varFF4E3FFD47F6151862E3275C1D99A159_239939253.addTaint(taint);
            return varFF4E3FFD47F6151862E3275C1D99A159_239939253;
            // ---------- Original Method ----------
            //return TreeMap.this.tailMap(fromInclusive, true).navigableKeySet();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.397 -0400", hash_original_method = "1704B63D396CC7A2877008D7CE821A20", hash_generated_method = "130374D647FE97BA9B570550A5F45882")
        public NavigableSet<K> descendingSet() {
NavigableSet<K> var147103AFA753373FDDCF430FA02E998F_940472183 =             new BoundedMap(false, null, NO_BOUND, null, NO_BOUND).navigableKeySet();
            var147103AFA753373FDDCF430FA02E998F_940472183.addTaint(taint);
            return var147103AFA753373FDDCF430FA02E998F_940472183;
            // ---------- Original Method ----------
            //return new BoundedMap(false, null, NO_BOUND, null, NO_BOUND).navigableKeySet();
        }

        
    }


    
    enum Bound {
        INCLUSIVE {
            @DSModeled(DSC.SAFE)
        @Override public String leftCap(Object from) {
                return "[" + from;
            }
            @DSModeled(DSC.SAFE)
        @Override public String rightCap(Object to) {
                return to + "]";
            }
        },
        EXCLUSIVE {
            @DSModeled(DSC.SAFE)
        @Override public String leftCap(Object from) {
                return "(" + from;
            }
            @DSModeled(DSC.SAFE)
        @Override public String rightCap(Object to) {
                return to + ")";
            }
        },
        NO_BOUND {
            @DSModeled(DSC.SAFE)
        @Override public String leftCap(Object from) {
                return ".";
            }
            @DSModeled(DSC.SAFE)
        @Override public String rightCap(Object to) {
                return ".";
            }
        };
        @DSModeled(DSC.SAFE)
        public abstract String leftCap(Object from);
        @DSModeled(DSC.SAFE)
        public abstract String rightCap(Object to);
    }

    
    final class BoundedMap extends AbstractMap<K, V> implements NavigableMap<K, V>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.397 -0400", hash_original_field = "9C9AB624360885FCF93B7643C93B6748", hash_generated_field = "BC70714ECDFF7490EBA777F7B93EF439")

        private transient boolean ascending;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.397 -0400", hash_original_field = "D98A07F84921B24EE30F86FD8CD85C3C", hash_generated_field = "EEAE90D76D5F301C983CBE52CC99E066")

        private transient K from;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.397 -0400", hash_original_field = "8632C30284D52AAEE2237CDB621740BD", hash_generated_field = "8ED035FAE673A429CD23C9E2219BCCAB")

        private transient Bound fromBound;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.397 -0400", hash_original_field = "01B6E20344B68835C5ED1DDEDF20D531", hash_generated_field = "61687A1A941C5D04AF6012AAB46409E8")

        private transient K to;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.397 -0400", hash_original_field = "7CA17358064D231F30EBE9DEA6953FC3", hash_generated_field = "AA1B7E444C65D0CB4426137E2FCF44C2")

        private transient Bound toBound;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.397 -0400", hash_original_field = "D4E06C98DBA5A687CB6C836BF538EC81", hash_generated_field = "71A92C43EAA002A1D21DF22BACB230F5")

        private transient BoundedEntrySet entrySet;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.397 -0400", hash_original_field = "3E8ABCE844B6A8A95397486A3899B536", hash_generated_field = "8C5699591CBD5CFF428C3B6D5369D846")

        private transient BoundedKeySet keySet;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.398 -0400", hash_original_method = "EAF770A918D33B7B0B98CAAC01791FDE", hash_generated_method = "1ED7235088DE7EE5A250298A66834C92")
          BoundedMap(boolean ascending, K from, Bound fromBound, K to, Bound toBound) {
            if(fromBound != NO_BOUND && toBound != NO_BOUND)            
            {
                if(comparator.compare(from, to) > 0)                
                {
                    IllegalArgumentException var8DDE4F833C7F6DD25182F12F52D69FD0_617920333 = new IllegalArgumentException(from + " > " + to);
                    var8DDE4F833C7F6DD25182F12F52D69FD0_617920333.addTaint(taint);
                    throw var8DDE4F833C7F6DD25182F12F52D69FD0_617920333;
                } //End block
            } //End block
            else
            if(fromBound != NO_BOUND)            
            {
                comparator.compare(from, from);
            } //End block
            else
            if(toBound != NO_BOUND)            
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.398 -0400", hash_original_method = "0165FF9BE82C19127CA9F7A8EFBCC5F6", hash_generated_method = "6EB40E9077DB31978A9EF7F2CB9A6CB5")
        @Override
        public int size() {
            int var26AE06B895E339433E4D6CD04CD66FE7_1793751928 = (count(entrySet().iterator()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_920932493 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_920932493;
            // ---------- Original Method ----------
            //return count(entrySet().iterator());
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.398 -0400", hash_original_method = "25ACC65054E604EE8ADED763702CFAA7", hash_generated_method = "DC79002DCD3439688D2E6F85B6E32EA8")
        @Override
        public boolean isEmpty() {
            boolean var24822569AE9F7F715FDC0563401A6591_217347263 = (endpoint(true) == null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1672346699 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1672346699;
            // ---------- Original Method ----------
            //return endpoint(true) == null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.398 -0400", hash_original_method = "00AB887CF1625BBE035D7C27E115F8F5", hash_generated_method = "87A501FB5C50318FA9334DB5DBDCE1DE")
        @Override
        public V get(Object key) {
            addTaint(key.getTaint());
V var0A832C0727F42F6014F929FB0FC378A4_235444351 =             isInBounds(key) ? TreeMap.this.get(key) : null;
            var0A832C0727F42F6014F929FB0FC378A4_235444351.addTaint(taint);
            return var0A832C0727F42F6014F929FB0FC378A4_235444351;
            // ---------- Original Method ----------
            //return isInBounds(key) ? TreeMap.this.get(key) : null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.398 -0400", hash_original_method = "97933E3E15C41B402232AC9CC0472CF2", hash_generated_method = "3E4F37E840DEB6D4DE4FA9D0DDA5D806")
        @Override
        public boolean containsKey(Object key) {
            addTaint(key.getTaint());
            boolean varBFF824D91838D02D5EC29B8CCE262926_159720739 = (isInBounds(key) && TreeMap.this.containsKey(key));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1859024831 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1859024831;
            // ---------- Original Method ----------
            //return isInBounds(key) && TreeMap.this.containsKey(key);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.703 -0400", hash_original_method = "AA5BBA9E7D3BEE615F1E652A3C2B8A57", hash_generated_method = "DD84D362DC950AD9C4DD5437580BB493")
        @Override
        public V put(K key, V value) {
            addTaint(value.getTaint());
            addTaint(key.getTaint());
    if(!isInBounds(key))            
            {
                IllegalArgumentException varBC3996C2999EA65E41157E6460FE43CB_1483502092 = outOfBounds(key, fromBound, toBound);
                varBC3996C2999EA65E41157E6460FE43CB_1483502092.addTaint(taint);
                throw varBC3996C2999EA65E41157E6460FE43CB_1483502092;
            } //End block
V var2E37B97A19208A3D82E5317F45BDDA5A_693549569 =             putInternal(key, value);
            var2E37B97A19208A3D82E5317F45BDDA5A_693549569.addTaint(taint);
            return var2E37B97A19208A3D82E5317F45BDDA5A_693549569;
            // ---------- Original Method ----------
            //if (!isInBounds(key)) {
                //throw outOfBounds(key, fromBound, toBound);
            //}
            //return putInternal(key, value);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.405 -0400", hash_original_method = "FD860E76286147E5825948B59334B12A", hash_generated_method = "B750917BDB81D0CB49EC1C6805C98705")
        @Override
        public V remove(Object key) {
            addTaint(key.getTaint());
V var2D26847273D18E896AF5F18CD64B937E_1133931004 =             isInBounds(key) ? TreeMap.this.remove(key) : null;
            var2D26847273D18E896AF5F18CD64B937E_1133931004.addTaint(taint);
            return var2D26847273D18E896AF5F18CD64B937E_1133931004;
            // ---------- Original Method ----------
            //return isInBounds(key) ? TreeMap.this.remove(key) : null;
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.405 -0400", hash_original_method = "CBDDB4BBE438A9DB233DEA58A1C969FA", hash_generated_method = "8EDF25B3F305EDC0E18B84933E902E62")
        @SuppressWarnings("unchecked")
        private boolean isInBounds(Object key) {
            addTaint(key.getTaint());
            boolean varC2E8E4B0821BECC73AF223B4F22DE24B_874940378 = (isInBounds((K) key, fromBound, toBound));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_911130650 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_911130650;
            // ---------- Original Method ----------
            //return isInBounds((K) key, fromBound, toBound);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.406 -0400", hash_original_method = "692642A6AE210FFE582C89EC91302D79", hash_generated_method = "57DB4CC0B52B6C54EEBFE21544ED143D")
        private boolean isInBounds(K key, Bound fromBound, Bound toBound) {
            addTaint(toBound.getTaint());
            addTaint(fromBound.getTaint());
            addTaint(key.getTaint());
            if(fromBound == INCLUSIVE)            
            {
                if(comparator.compare(key, from) < 0)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_975355936 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_535268610 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_535268610;
                } //End block
            } //End block
            else
            if(fromBound == EXCLUSIVE)            
            {
                if(comparator.compare(key, from) <= 0)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1609902290 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1021495642 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1021495642;
                } //End block
            } //End block
            if(toBound == INCLUSIVE)            
            {
                if(comparator.compare(key, to) > 0)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_905663288 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_446989377 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_446989377;
                } //End block
            } //End block
            else
            if(toBound == EXCLUSIVE)            
            {
                if(comparator.compare(key, to) >= 0)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1204756040 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2945594 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_2945594;
                } //End block
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1207137993 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1122480133 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1122480133;
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

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.406 -0400", hash_original_method = "CAAC4C1A33B13586569CF07F541A55C7", hash_generated_method = "193C777DCD9C779DE5039B971645D83B")
        private Node<K, V> bound(Node<K, V> node, Bound fromBound, Bound toBound) {
            addTaint(toBound.getTaint());
            addTaint(fromBound.getTaint());
            addTaint(node.getTaint());
Node<K, V> varBCBECEA5E483CDB70086F19B700D6F49_1648111564 =             node != null && isInBounds(node.getKey(), fromBound, toBound) ? node : null;
            varBCBECEA5E483CDB70086F19B700D6F49_1648111564.addTaint(taint);
            return varBCBECEA5E483CDB70086F19B700D6F49_1648111564;
            // ---------- Original Method ----------
            //return node != null && isInBounds(node.getKey(), fromBound, toBound) ? node : null;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.406 -0400", hash_original_method = "692355E3656C196457301F91A19D5157", hash_generated_method = "A2241F9BE30C170EC93B019D26CF6CEA")
        public Entry<K, V> firstEntry() {
Entry<K, V> var0A56181019B755400DBCE1C237EBF90C_1528184344 =             immutableCopy(endpoint(true));
            var0A56181019B755400DBCE1C237EBF90C_1528184344.addTaint(taint);
            return var0A56181019B755400DBCE1C237EBF90C_1528184344;
            // ---------- Original Method ----------
            //return immutableCopy(endpoint(true));
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.406 -0400", hash_original_method = "3800FF04B85DB50D775ADF76A89AF0FD", hash_generated_method = "E6184055E5DF063F213F3B704CAB5DD8")
        public Entry<K, V> pollFirstEntry() {
            Node<K, V> result = endpoint(true);
            if(result != null)            
            {
                removeInternal(result);
            } //End block
Entry<K, V> var6B63F11358115BF1F4CDE6AD6F400177_1028174148 =             immutableCopy(result);
            var6B63F11358115BF1F4CDE6AD6F400177_1028174148.addTaint(taint);
            return var6B63F11358115BF1F4CDE6AD6F400177_1028174148;
            // ---------- Original Method ----------
            //Node<K, V> result = endpoint(true);
            //if (result != null) {
                //removeInternal(result);
            //}
            //return immutableCopy(result);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.406 -0400", hash_original_method = "1DE5152AF86A2FB092CD0802BF299C85", hash_generated_method = "4F369FAFEB3839113FB78D21CF3E4E48")
        public K firstKey() {
            Entry<K, V> entry = endpoint(true);
            if(entry == null)            
            {
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_1341202273 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_1341202273.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_1341202273;
            } //End block
K varE5CD6225CB16CF7AEFEC373E217B052C_347516471 =             entry.getKey();
            varE5CD6225CB16CF7AEFEC373E217B052C_347516471.addTaint(taint);
            return varE5CD6225CB16CF7AEFEC373E217B052C_347516471;
            // ---------- Original Method ----------
            //Entry<K, V> entry = endpoint(true);
            //if (entry == null) {
                //throw new NoSuchElementException();
            //}
            //return entry.getKey();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.406 -0400", hash_original_method = "3349B358C55B472B88F39549996E074C", hash_generated_method = "A78AA2AEE5BBE2BAA15204452435ACB1")
        public Entry<K, V> lastEntry() {
Entry<K, V> varDB864FBFECFDD7EF32688DE10742D92E_84084912 =             immutableCopy(endpoint(false));
            varDB864FBFECFDD7EF32688DE10742D92E_84084912.addTaint(taint);
            return varDB864FBFECFDD7EF32688DE10742D92E_84084912;
            // ---------- Original Method ----------
            //return immutableCopy(endpoint(false));
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.407 -0400", hash_original_method = "4E391E55891B2D72162CA8FBBFDB8088", hash_generated_method = "CDA95D4A9FCD45FFE54B9FF98BF0CCAE")
        public Entry<K, V> pollLastEntry() {
            Node<K, V> result = endpoint(false);
            if(result != null)            
            {
                removeInternal(result);
            } //End block
Entry<K, V> var6B63F11358115BF1F4CDE6AD6F400177_1564928535 =             immutableCopy(result);
            var6B63F11358115BF1F4CDE6AD6F400177_1564928535.addTaint(taint);
            return var6B63F11358115BF1F4CDE6AD6F400177_1564928535;
            // ---------- Original Method ----------
            //Node<K, V> result = endpoint(false);
            //if (result != null) {
                //removeInternal(result);
            //}
            //return immutableCopy(result);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.407 -0400", hash_original_method = "394B9DCC52DC405017E9FB6F95D12436", hash_generated_method = "308C6B05EEE289F85DE7A41C5269C122")
        public K lastKey() {
            Entry<K, V> entry = endpoint(false);
            if(entry == null)            
            {
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_2022465659 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_2022465659.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_2022465659;
            } //End block
K varE5CD6225CB16CF7AEFEC373E217B052C_1394501131 =             entry.getKey();
            varE5CD6225CB16CF7AEFEC373E217B052C_1394501131.addTaint(taint);
            return varE5CD6225CB16CF7AEFEC373E217B052C_1394501131;
            // ---------- Original Method ----------
            //Entry<K, V> entry = endpoint(false);
            //if (entry == null) {
                //throw new NoSuchElementException();
            //}
            //return entry.getKey();
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.407 -0400", hash_original_method = "83D48F5C9D4926E1668CDBC652A8BB3D", hash_generated_method = "DB02F5EF128473C0A5555C361CAF76D6")
        private Node<K, V> endpoint(boolean first) {
            addTaint(first);
            Node<K, V> node;
            if(ascending == first)            
            {
switch(fromBound){
                case NO_BOUND:
                node = root == null ? null : root.first();
                break;
                case INCLUSIVE:
                node = find(from, CEILING);
                break;
                case EXCLUSIVE:
                node = find(from, HIGHER);
                break;
                default:
                AssertionError varA81442E36297E737EB908877E58260E8_626046374 = new AssertionError();
                varA81442E36297E737EB908877E58260E8_626046374.addTaint(taint);
                throw varA81442E36297E737EB908877E58260E8_626046374;
}Node<K, V> varEAB025B2B90A78721FD3A719622C9FBE_1992436228 =                 bound(node, NO_BOUND, toBound);
                varEAB025B2B90A78721FD3A719622C9FBE_1992436228.addTaint(taint);
                return varEAB025B2B90A78721FD3A719622C9FBE_1992436228;
            } //End block
            else
            {
switch(toBound){
                case NO_BOUND:
                node = root == null ? null : root.last();
                break;
                case INCLUSIVE:
                node = find(to, FLOOR);
                break;
                case EXCLUSIVE:
                node = find(to, LOWER);
                break;
                default:
                AssertionError varA81442E36297E737EB908877E58260E8_1899357171 = new AssertionError();
                varA81442E36297E737EB908877E58260E8_1899357171.addTaint(taint);
                throw varA81442E36297E737EB908877E58260E8_1899357171;
}Node<K, V> varD0FBEC1C8500F0F6B11CE96CBEBC0942_1200480690 =                 bound(node, fromBound, NO_BOUND);
                varD0FBEC1C8500F0F6B11CE96CBEBC0942_1200480690.addTaint(taint);
                return varD0FBEC1C8500F0F6B11CE96CBEBC0942_1200480690;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.408 -0400", hash_original_method = "4CDC04225A960E79B8311D7465BD3125", hash_generated_method = "2B35969DD602F9C19252A5CCFE06BEC3")
        private Entry<K, V> findBounded(K key, Relation relation) {
            addTaint(relation.getTaint());
            addTaint(key.getTaint());
            relation = relation.forOrder(ascending);
            Bound fromBoundForCheck = fromBound;
            Bound toBoundForCheck = toBound;
            if(toBound != NO_BOUND && (relation == LOWER || relation == FLOOR))            
            {
                int comparison = comparator.compare(to, key);
                if(comparison <= 0)                
                {
                    key = to;
                    if(toBound == EXCLUSIVE)                    
                    {
                        relation = LOWER;
                    } //End block
                    else
                    if(comparison < 0)                    
                    {
                        relation = FLOOR;
                    } //End block
                } //End block
                toBoundForCheck = NO_BOUND;
            } //End block
            if(fromBound != NO_BOUND && (relation == CEILING || relation == HIGHER))            
            {
                int comparison = comparator.compare(from, key);
                if(comparison >= 0)                
                {
                    key = from;
                    if(fromBound == EXCLUSIVE)                    
                    {
                        relation = HIGHER;
                    } //End block
                    else
                    if(comparison > 0)                    
                    {
                        relation = CEILING;
                    } //End block
                } //End block
                fromBoundForCheck = NO_BOUND;
            } //End block
Entry<K, V> var5E7C8E05686CD046B5E518E1A524CD5B_736542112 =             bound(find(key, relation), fromBoundForCheck, toBoundForCheck);
            var5E7C8E05686CD046B5E518E1A524CD5B_736542112.addTaint(taint);
            return var5E7C8E05686CD046B5E518E1A524CD5B_736542112;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.410 -0400", hash_original_method = "BD9CF59DC295A4AE3510934F298E27E6", hash_generated_method = "800C44A75F0910ECF65DAFA4A14C589C")
        public Entry<K, V> lowerEntry(K key) {
            addTaint(key.getTaint());
Entry<K, V> var5EEE7716674B425CEA31D7AC72A401A4_1590730262 =             immutableCopy(findBounded(key, LOWER));
            var5EEE7716674B425CEA31D7AC72A401A4_1590730262.addTaint(taint);
            return var5EEE7716674B425CEA31D7AC72A401A4_1590730262;
            // ---------- Original Method ----------
            //return immutableCopy(findBounded(key, LOWER));
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.410 -0400", hash_original_method = "EBA87E3AFD9E90051DFFEBD0117773EA", hash_generated_method = "4897E67A7A0CEB95201B7CBDCF0CD284")
        public K lowerKey(K key) {
            addTaint(key.getTaint());
            Entry<K, V> entry = findBounded(key, LOWER);
K var15DE16EBAA69B0A4EA051FB5DEC39C10_1076535905 =             entry != null ? entry.getKey() : null;
            var15DE16EBAA69B0A4EA051FB5DEC39C10_1076535905.addTaint(taint);
            return var15DE16EBAA69B0A4EA051FB5DEC39C10_1076535905;
            // ---------- Original Method ----------
            //Entry<K, V> entry = findBounded(key, LOWER);
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.411 -0400", hash_original_method = "581C54D570AF4193E6400C576ED95C35", hash_generated_method = "09AAD82126671121348D3AF58979D787")
        public Entry<K, V> floorEntry(K key) {
            addTaint(key.getTaint());
Entry<K, V> varC2D8288DAEE7B2AD361DAA75FC2202C3_1985893705 =             immutableCopy(findBounded(key, FLOOR));
            varC2D8288DAEE7B2AD361DAA75FC2202C3_1985893705.addTaint(taint);
            return varC2D8288DAEE7B2AD361DAA75FC2202C3_1985893705;
            // ---------- Original Method ----------
            //return immutableCopy(findBounded(key, FLOOR));
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.411 -0400", hash_original_method = "E92237DAC033388A5150FD58D66D705D", hash_generated_method = "0DF297046DF8ACAB33998F61AAFD5064")
        public K floorKey(K key) {
            addTaint(key.getTaint());
            Entry<K, V> entry = findBounded(key, FLOOR);
K var15DE16EBAA69B0A4EA051FB5DEC39C10_318602000 =             entry != null ? entry.getKey() : null;
            var15DE16EBAA69B0A4EA051FB5DEC39C10_318602000.addTaint(taint);
            return var15DE16EBAA69B0A4EA051FB5DEC39C10_318602000;
            // ---------- Original Method ----------
            //Entry<K, V> entry = findBounded(key, FLOOR);
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.411 -0400", hash_original_method = "C11821BD096982DAE03E94867B2C92BE", hash_generated_method = "4BE2FEE6E92F9283260535F5A64E6A7C")
        public Entry<K, V> ceilingEntry(K key) {
            addTaint(key.getTaint());
Entry<K, V> var4231880C2A190D7782E1F90F0F7B868D_1665266098 =             immutableCopy(findBounded(key, CEILING));
            var4231880C2A190D7782E1F90F0F7B868D_1665266098.addTaint(taint);
            return var4231880C2A190D7782E1F90F0F7B868D_1665266098;
            // ---------- Original Method ----------
            //return immutableCopy(findBounded(key, CEILING));
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.411 -0400", hash_original_method = "01AF63D6DC81CC48D8C6B0BE37F83B4D", hash_generated_method = "C073DCA1BAFA336BC39FC830CA93D0BC")
        public K ceilingKey(K key) {
            addTaint(key.getTaint());
            Entry<K, V> entry = findBounded(key, CEILING);
K var15DE16EBAA69B0A4EA051FB5DEC39C10_1074725763 =             entry != null ? entry.getKey() : null;
            var15DE16EBAA69B0A4EA051FB5DEC39C10_1074725763.addTaint(taint);
            return var15DE16EBAA69B0A4EA051FB5DEC39C10_1074725763;
            // ---------- Original Method ----------
            //Entry<K, V> entry = findBounded(key, CEILING);
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.411 -0400", hash_original_method = "4DE66AB7FA66EBE29F4E4509967D65D0", hash_generated_method = "F157BC69B199F5C52B6F2E1E17636AD0")
        public Entry<K, V> higherEntry(K key) {
            addTaint(key.getTaint());
Entry<K, V> var0D6C34F1391AD2F31A7F6610A91CE3C1_1782524399 =             immutableCopy(findBounded(key, HIGHER));
            var0D6C34F1391AD2F31A7F6610A91CE3C1_1782524399.addTaint(taint);
            return var0D6C34F1391AD2F31A7F6610A91CE3C1_1782524399;
            // ---------- Original Method ----------
            //return immutableCopy(findBounded(key, HIGHER));
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.411 -0400", hash_original_method = "47A499322D06CDAFFEC1D4DA0A079F0A", hash_generated_method = "AA2A51CC0D5D53CD767075732CB324C1")
        public K higherKey(K key) {
            addTaint(key.getTaint());
            Entry<K, V> entry = findBounded(key, HIGHER);
K var15DE16EBAA69B0A4EA051FB5DEC39C10_1504091058 =             entry != null ? entry.getKey() : null;
            var15DE16EBAA69B0A4EA051FB5DEC39C10_1504091058.addTaint(taint);
            return var15DE16EBAA69B0A4EA051FB5DEC39C10_1504091058;
            // ---------- Original Method ----------
            //Entry<K, V> entry = findBounded(key, HIGHER);
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.414 -0400", hash_original_method = "631801B6DE22632DEACA2B547DEBE43A", hash_generated_method = "9B52C499D53D4D52AB37A4E38E7ED06C")
        public Comparator<? super K> comparator() {
            if(ascending)            
            {
Comparator<? super K> varEE9621AAB15522B49DAC63CE835E2941_719622732 =                 TreeMap.this.comparator();
                varEE9621AAB15522B49DAC63CE835E2941_719622732.addTaint(taint);
                return varEE9621AAB15522B49DAC63CE835E2941_719622732;
            } //End block
            else
            {
Comparator<? super K> var189BFD6654899F3ED4575521560E0DC6_171463195 =                 Collections.reverseOrder(comparator);
                var189BFD6654899F3ED4575521560E0DC6_171463195.addTaint(taint);
                return var189BFD6654899F3ED4575521560E0DC6_171463195;
            } //End block
            // ---------- Original Method ----------
            //if (ascending) {
            //return TreeMap.this.comparator();
          //} else {
            //return Collections.reverseOrder(comparator);
          //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.414 -0400", hash_original_method = "7F86A739037DCA8312EEE2819E1107F8", hash_generated_method = "1A825E07991CFBB133E661A46E7D8171")
        @Override
        public Set<Entry<K, V>> entrySet() {
            BoundedEntrySet result = entrySet;
Set<Entry<K, V>> var7EA657578A416D0A7E3291794489838F_265723040 =             result != null ? result : (entrySet = new BoundedEntrySet());
            var7EA657578A416D0A7E3291794489838F_265723040.addTaint(taint);
            return var7EA657578A416D0A7E3291794489838F_265723040;
            // ---------- Original Method ----------
            //BoundedEntrySet result = entrySet;
            //return result != null ? result : (entrySet = new BoundedEntrySet());
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.415 -0400", hash_original_method = "8D1D053C1D8B0756868AB879DB7CB086", hash_generated_method = "846343F75D269EDEE1E03944A18F6A3B")
        @Override
        public Set<K> keySet() {
Set<K> varAF7F4C03A95ED30F86359E39EFFF72E9_523440260 =             navigableKeySet();
            varAF7F4C03A95ED30F86359E39EFFF72E9_523440260.addTaint(taint);
            return varAF7F4C03A95ED30F86359E39EFFF72E9_523440260;
            // ---------- Original Method ----------
            //return navigableKeySet();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.415 -0400", hash_original_method = "58209BC6FD1C6420A0C3CE4B441A6EA8", hash_generated_method = "B801D1D10C2B73017043CBBD21C17DD9")
        public NavigableSet<K> navigableKeySet() {
            BoundedKeySet result = keySet;
NavigableSet<K> var65433A428F01D1730EDF71551397CAE5_78673603 =             result != null ? result : (keySet = new BoundedKeySet());
            var65433A428F01D1730EDF71551397CAE5_78673603.addTaint(taint);
            return var65433A428F01D1730EDF71551397CAE5_78673603;
            // ---------- Original Method ----------
            //BoundedKeySet result = keySet;
            //return result != null ? result : (keySet = new BoundedKeySet());
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.415 -0400", hash_original_method = "6D358EC631E9E279A9C759613AD4CBF5", hash_generated_method = "9F6656E37C26FADAA473D0005E100ED5")
        public NavigableMap<K, V> descendingMap() {
NavigableMap<K, V> var86E3BFF502581898758F73B9E6908FAD_183492606 =             new BoundedMap(!ascending, from, fromBound, to, toBound);
            var86E3BFF502581898758F73B9E6908FAD_183492606.addTaint(taint);
            return var86E3BFF502581898758F73B9E6908FAD_183492606;
            // ---------- Original Method ----------
            //return new BoundedMap(!ascending, from, fromBound, to, toBound);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.415 -0400", hash_original_method = "E068C75BD35AA3BEC427F457C352E2B5", hash_generated_method = "56B1884511540FA9BC3DF7CA660342AD")
        public NavigableSet<K> descendingKeySet() {
NavigableSet<K> varAF8103DD5E04E7E5EEF583022A60862D_580695088 =             new BoundedMap(!ascending, from, fromBound, to, toBound).navigableKeySet();
            varAF8103DD5E04E7E5EEF583022A60862D_580695088.addTaint(taint);
            return varAF8103DD5E04E7E5EEF583022A60862D_580695088;
            // ---------- Original Method ----------
            //return new BoundedMap(!ascending, from, fromBound, to, toBound).navigableKeySet();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.415 -0400", hash_original_method = "3DC9A98D108EA5F857802D111DD4C7BC", hash_generated_method = "6BC69D98C39613DEC3DB97974813D115")
        public NavigableMap<K, V> subMap(K from, boolean fromInclusive, K to, boolean toInclusive) {
            addTaint(toInclusive);
            addTaint(to.getTaint());
            addTaint(fromInclusive);
            addTaint(from.getTaint());
            Bound fromBound = fromInclusive ? INCLUSIVE : EXCLUSIVE;
            Bound toBound = toInclusive ? INCLUSIVE : EXCLUSIVE;
NavigableMap<K, V> var0455DF56F4615D9DE9D27B19AFAEF226_1546866907 =             subMap(from, fromBound, to, toBound);
            var0455DF56F4615D9DE9D27B19AFAEF226_1546866907.addTaint(taint);
            return var0455DF56F4615D9DE9D27B19AFAEF226_1546866907;
            // ---------- Original Method ----------
            //Bound fromBound = fromInclusive ? INCLUSIVE : EXCLUSIVE;
            //Bound toBound = toInclusive ? INCLUSIVE : EXCLUSIVE;
            //return subMap(from, fromBound, to, toBound);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.415 -0400", hash_original_method = "85C9C855FCFD7C01DE62316D427AA356", hash_generated_method = "3EC9C7E261EAB9455C49729E3FD0C80A")
        public NavigableMap<K, V> subMap(K fromInclusive, K toExclusive) {
            addTaint(toExclusive.getTaint());
            addTaint(fromInclusive.getTaint());
NavigableMap<K, V> varB4D2F6DE1EAD448F88B0A434FEE1794C_1876922838 =             subMap(fromInclusive, INCLUSIVE, toExclusive, EXCLUSIVE);
            varB4D2F6DE1EAD448F88B0A434FEE1794C_1876922838.addTaint(taint);
            return varB4D2F6DE1EAD448F88B0A434FEE1794C_1876922838;
            // ---------- Original Method ----------
            //return subMap(fromInclusive, INCLUSIVE, toExclusive, EXCLUSIVE);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.418 -0400", hash_original_method = "F0BAF6F2CF2FCD82E483E31B5C869204", hash_generated_method = "1BFB2395AAD778DE8315306450FC93A0")
        public NavigableMap<K, V> headMap(K to, boolean inclusive) {
            addTaint(inclusive);
            addTaint(to.getTaint());
            Bound toBound = inclusive ? INCLUSIVE : EXCLUSIVE;
NavigableMap<K, V> var2AFE5CD544BBF55ECF5B05CE6BA0FAD1_688162958 =             subMap(null, NO_BOUND, to, toBound);
            var2AFE5CD544BBF55ECF5B05CE6BA0FAD1_688162958.addTaint(taint);
            return var2AFE5CD544BBF55ECF5B05CE6BA0FAD1_688162958;
            // ---------- Original Method ----------
            //Bound toBound = inclusive ? INCLUSIVE : EXCLUSIVE;
            //return subMap(null, NO_BOUND, to, toBound);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.418 -0400", hash_original_method = "ABFE13DC9073E46E049BB999D5306953", hash_generated_method = "207215060221B14E9B528B6DA6262001")
        public NavigableMap<K, V> headMap(K toExclusive) {
            addTaint(toExclusive.getTaint());
NavigableMap<K, V> var765BFAC84EB1A83FC3B14F73D7910B18_149610979 =             subMap(null, NO_BOUND, toExclusive, EXCLUSIVE);
            var765BFAC84EB1A83FC3B14F73D7910B18_149610979.addTaint(taint);
            return var765BFAC84EB1A83FC3B14F73D7910B18_149610979;
            // ---------- Original Method ----------
            //return subMap(null, NO_BOUND, toExclusive, EXCLUSIVE);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.419 -0400", hash_original_method = "26986665A8C827C93D404190F2752B4C", hash_generated_method = "3DC6370EE24D87AD7E85250E7FB7D926")
        public NavigableMap<K, V> tailMap(K from, boolean inclusive) {
            addTaint(inclusive);
            addTaint(from.getTaint());
            Bound fromBound = inclusive ? INCLUSIVE : EXCLUSIVE;
NavigableMap<K, V> var35EFA145DEE09E716468DD6B2AFF8A39_117362615 =             subMap(from, fromBound, null, NO_BOUND);
            var35EFA145DEE09E716468DD6B2AFF8A39_117362615.addTaint(taint);
            return var35EFA145DEE09E716468DD6B2AFF8A39_117362615;
            // ---------- Original Method ----------
            //Bound fromBound = inclusive ? INCLUSIVE : EXCLUSIVE;
            //return subMap(from, fromBound, null, NO_BOUND);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.419 -0400", hash_original_method = "CF387452C0473BBA846F53D5C56CE3B2", hash_generated_method = "2862E06CB5D0DE6E59DEF56226BC36BA")
        public NavigableMap<K, V> tailMap(K fromInclusive) {
            addTaint(fromInclusive.getTaint());
NavigableMap<K, V> varE8FB1045162A43BFD2F2D63D6DC8CED9_2069697177 =             subMap(fromInclusive, INCLUSIVE, null, NO_BOUND);
            varE8FB1045162A43BFD2F2D63D6DC8CED9_2069697177.addTaint(taint);
            return varE8FB1045162A43BFD2F2D63D6DC8CED9_2069697177;
            // ---------- Original Method ----------
            //return subMap(fromInclusive, INCLUSIVE, null, NO_BOUND);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.730 -0400", hash_original_method = "0BE57F9811CA6209D3A6FF727B140802", hash_generated_method = "14DFB39D85A7ADED4DBBEFD0ED517DB0")
        private NavigableMap<K, V> subMap(K from, Bound fromBound, K to, Bound toBound) {
    if(!ascending)            
            {
                K fromTmp = from;
                Bound fromBoundTmp = fromBound;
                from = to;
                fromBound = toBound;
                to = fromTmp;
                toBound = fromBoundTmp;
            } //End block
    if(fromBound == NO_BOUND)            
            {
                from = this.from;
                fromBound = this.fromBound;
            } //End block
            else
            {
                Bound fromBoundToCheck = fromBound == this.fromBound ? INCLUSIVE : this.fromBound;
    if(!isInBounds(from, fromBoundToCheck, this.toBound))                
                {
    		IllegalArgumentException varAAE60559F56B2D07E4FD593449F5EA72_1154125570 = outOfBounds(to, fromBoundToCheck, this.toBound);
                    varAAE60559F56B2D07E4FD593449F5EA72_1154125570.addTaint(taint);
                    throw varAAE60559F56B2D07E4FD593449F5EA72_1154125570;
                } //End block
            } //End block
    if(toBound == NO_BOUND)            
            {
                to = this.to;
                toBound = this.toBound;
            } //End block
            else
            {
                Bound toBoundToCheck = toBound == this.toBound ? INCLUSIVE : this.toBound;
    if(!isInBounds(to, this.fromBound, toBoundToCheck))                
                {
                    IllegalArgumentException var56B3D45BCEE596AC83A0B23A3B92857C_293578796 = outOfBounds(to, this.fromBound, toBoundToCheck);
                    var56B3D45BCEE596AC83A0B23A3B92857C_293578796.addTaint(taint);
                    throw var56B3D45BCEE596AC83A0B23A3B92857C_293578796;
                } //End block
            } //End block
NavigableMap<K, V> varEC04A97C55B7258B88C9CBFBFF445575_3340594 =             new BoundedMap(ascending, from, fromBound, to, toBound);
            varEC04A97C55B7258B88C9CBFBFF445575_3340594.addTaint(taint);
            return varEC04A97C55B7258B88C9CBFBFF445575_3340594;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.439 -0400", hash_original_method = "65FB71F2A366D35F7884C2869AFAA6ED", hash_generated_method = "5D2BA88D46418ACDF68911C9EF8B0901")
        private IllegalArgumentException outOfBounds(Object value, Bound fromBound, Bound toBound) {
            addTaint(toBound.getTaint());
            addTaint(fromBound.getTaint());
            addTaint(value.getTaint());
IllegalArgumentException varB6209D04CF3E19CAD859CC3BE52189E0_1141603753 =             new IllegalArgumentException(value + " not in range "
                    + fromBound.leftCap(from) + ".." + toBound.rightCap(to));
            varB6209D04CF3E19CAD859CC3BE52189E0_1141603753.addTaint(taint);
            return varB6209D04CF3E19CAD859CC3BE52189E0_1141603753;
            // ---------- Original Method ----------
            //return new IllegalArgumentException(value + " not in range "
                    //+ fromBound.leftCap(from) + ".." + toBound.rightCap(to));
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.439 -0400", hash_original_method = "9F20C8CFE1A741092D9743A31C3F8586", hash_generated_method = "83FB27AB0EB8C1109558C0AF671DF845")
         Object writeReplace() throws ObjectStreamException {
Object var7F4944441F64C47E165D9A9EC6DB3E3C_1279999326 =             ascending
                    ? new AscendingSubMap<K, V>(TreeMap.this, from, fromBound, to, toBound)
                    : new DescendingSubMap<K, V>(TreeMap.this, from, fromBound, to, toBound);
            var7F4944441F64C47E165D9A9EC6DB3E3C_1279999326.addTaint(taint);
            return var7F4944441F64C47E165D9A9EC6DB3E3C_1279999326;
            // ---------- Original Method ----------
            //return ascending
                    //? new AscendingSubMap<K, V>(TreeMap.this, from, fromBound, to, toBound)
                    //: new DescendingSubMap<K, V>(TreeMap.this, from, fromBound, to, toBound);
        }

        
        abstract class BoundedIterator<T> extends MapIterator<T> {
            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.440 -0400", hash_original_method = "30CDAF663F351A84269F6FB0B072EFA9", hash_generated_method = "DCA6AE078FF061847F66F0A7A80CFEA2")
            protected  BoundedIterator(Node<K, V> next) {
                super(next);
                addTaint(next.getTaint());
                // ---------- Original Method ----------
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.440 -0400", hash_original_method = "E9206CF01CB691A7CC292AD03FA9736C", hash_generated_method = "2F914F41CA4729A0E08177F0E49F1A7A")
            @Override
            protected Node<K, V> stepForward() {
                Node<K, V> result = super.stepForward();
                if(next != null && !isInBounds(next.key, NO_BOUND, toBound))                
                {
                    next = null;
                } //End block
Node<K, V> varDC838461EE2FA0CA4C9BBB70A15456B0_732099798 =                 result;
                varDC838461EE2FA0CA4C9BBB70A15456B0_732099798.addTaint(taint);
                return varDC838461EE2FA0CA4C9BBB70A15456B0_732099798;
                // ---------- Original Method ----------
                //Node<K, V> result = super.stepForward();
                //if (next != null && !isInBounds(next.key, NO_BOUND, toBound)) {
                    //next = null;
                //}
                //return result;
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.440 -0400", hash_original_method = "E55F6A3E56D317586EA4F65D3F74D30B", hash_generated_method = "99E0D5F70036FB1691C0851FFD3F5335")
            @Override
            protected Node<K, V> stepBackward() {
                Node<K, V> result = super.stepBackward();
                if(next != null && !isInBounds(next.key, fromBound, NO_BOUND))                
                {
                    next = null;
                } //End block
Node<K, V> varDC838461EE2FA0CA4C9BBB70A15456B0_196472020 =                 result;
                varDC838461EE2FA0CA4C9BBB70A15456B0_196472020.addTaint(taint);
                return varDC838461EE2FA0CA4C9BBB70A15456B0_196472020;
                // ---------- Original Method ----------
                //Node<K, V> result = super.stepBackward();
                //if (next != null && !isInBounds(next.key, fromBound, NO_BOUND)) {
                    //next = null;
                //}
                //return result;
            }

            
        }


        
        final class BoundedEntrySet extends AbstractSet<Entry<K, V>> {
            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.440 -0400", hash_original_method = "6A727A04787362E0DA8C9D4EFA8450E8", hash_generated_method = "6A727A04787362E0DA8C9D4EFA8450E8")
            public BoundedEntrySet ()
            {
                //Synthesized constructor
            }


                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.440 -0400", hash_original_method = "29BBB3BE9EA7B6D6C0B83C28F05082A4", hash_generated_method = "6E14FF2877AECCD022C19FA20487114D")
            @Override
            public int size() {
                int var97BE7EAD6DC7A924C500E8F471E6CC2B_789591285 = (BoundedMap.this.size());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1222782697 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1222782697;
                // ---------- Original Method ----------
                //return BoundedMap.this.size();
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.440 -0400", hash_original_method = "AEA447F4A69E282FABF93736832EBAA3", hash_generated_method = "48BA99F5360E31AA875A2F91426F90F8")
            @Override
            public boolean isEmpty() {
                boolean varE6F4C3E8DEB8CD0D0ECE5B894222EC74_1158496335 = (BoundedMap.this.isEmpty());
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_293229371 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_293229371;
                // ---------- Original Method ----------
                //return BoundedMap.this.isEmpty();
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.441 -0400", hash_original_method = "0E267F64AB80178C28467CD978AC79C8", hash_generated_method = "5A221781EE99493EE05E3B7294B54281")
            @Override
            public Iterator<Entry<K, V>> iterator() {
Iterator<Entry<K, V>> var007B5231128F5E237111AC487E38483B_1132179570 =                 new BoundedIterator<Entry<K, V>>(endpoint(true)) {                
                @DSModeled(DSC.SAFE)
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.441 -0400", hash_original_method = "336D5542BA5231E0955145F5F84B4BBD", hash_generated_method = "5C262257CAF0017D8DDEB3567F5E9421")
                public Entry<K, V> next() {
Entry<K, V> var20BE8BC2B8AE57FD70A8A3FD9993CBC9_1537078141 =                     ascending ? stepForward() : stepBackward();
                    var20BE8BC2B8AE57FD70A8A3FD9993CBC9_1537078141.addTaint(taint);
                    return var20BE8BC2B8AE57FD70A8A3FD9993CBC9_1537078141;
                    // ---------- Original Method ----------
                    //return ascending ? stepForward() : stepBackward();
                }
};
                var007B5231128F5E237111AC487E38483B_1132179570.addTaint(taint);
                return var007B5231128F5E237111AC487E38483B_1132179570;
                // ---------- Original Method ----------
                //return new BoundedIterator<Entry<K, V>>(endpoint(true)) {
                    //public Entry<K, V> next() {
                        //return ascending ? stepForward() : stepBackward();
                    //}
                //};
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.442 -0400", hash_original_method = "954A21A7B25CC1709817AC62B8C6864E", hash_generated_method = "FFF9F66763008A22AB0A9199914DD28C")
            @Override
            public boolean contains(Object o) {
                addTaint(o.getTaint());
                if(!(o instanceof Entry))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1000388722 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_752785179 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_752785179;
                } //End block
                Entry<?, ?> entry = (Entry<?, ?>) o;
                boolean varD02E5172633A0EEA6042DCC36F6688AC_1560752600 = (isInBounds(entry.getKey()) && findByEntry(entry) != null);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_427767443 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_427767443;
                // ---------- Original Method ----------
                //if (!(o instanceof Entry)) {
                    //return false;
                //}
                //Entry<?, ?> entry = (Entry<?, ?>) o;
                //return isInBounds(entry.getKey()) && findByEntry(entry) != null;
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.442 -0400", hash_original_method = "EF59D88655EE445530DBDC219FDD1A5F", hash_generated_method = "6FDFBF6CCB593C998F4F9C975C859CA3")
            @Override
            public boolean remove(Object o) {
                addTaint(o.getTaint());
                if(!(o instanceof Entry))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1515588551 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1584970990 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1584970990;
                } //End block
                Entry<?, ?> entry = (Entry<?, ?>) o;
                boolean var0B802A8F8F22690871A9C64508FC359C_1076833361 = (isInBounds(entry.getKey()) && TreeMap.this.entrySet().remove(entry));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1754617513 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1754617513;
                // ---------- Original Method ----------
                //if (!(o instanceof Entry)) {
                    //return false;
                //}
                //Entry<?, ?> entry = (Entry<?, ?>) o;
                //return isInBounds(entry.getKey()) && TreeMap.this.entrySet().remove(entry);
            }

            
        }


        
        final class BoundedKeySet extends AbstractSet<K> implements NavigableSet<K> {
            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.442 -0400", hash_original_method = "9AD1259E686AD3B6150FA3E61E8BAA17", hash_generated_method = "9AD1259E686AD3B6150FA3E61E8BAA17")
            public BoundedKeySet ()
            {
                //Synthesized constructor
            }


                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.442 -0400", hash_original_method = "29BBB3BE9EA7B6D6C0B83C28F05082A4", hash_generated_method = "FE03E5B311A7808E125D12A711573612")
            @Override
            public int size() {
                int var97BE7EAD6DC7A924C500E8F471E6CC2B_616720598 = (BoundedMap.this.size());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_203127529 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_203127529;
                // ---------- Original Method ----------
                //return BoundedMap.this.size();
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.442 -0400", hash_original_method = "AEA447F4A69E282FABF93736832EBAA3", hash_generated_method = "6D85FF95818EB64F62EEC2278A0E839A")
            @Override
            public boolean isEmpty() {
                boolean varE6F4C3E8DEB8CD0D0ECE5B894222EC74_43863092 = (BoundedMap.this.isEmpty());
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1063868621 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1063868621;
                // ---------- Original Method ----------
                //return BoundedMap.this.isEmpty();
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.442 -0400", hash_original_method = "8539DDED7A19368CB3D09440D6A62269", hash_generated_method = "0A0D63673932A6547B1A7C68FCBD2AF3")
            @Override
            public Iterator<K> iterator() {
Iterator<K> var67B4ECA44D3FE1877CC98B43105388F5_2060286296 =                 new BoundedIterator<K>(endpoint(true)) {                
                @DSModeled(DSC.SAFE)
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.442 -0400", hash_original_method = "3A3F5ECB2E6902CB8A6D0DE3222F8B33", hash_generated_method = "A0D253C620D6189C0E8987C453DC4E10")
                public K next() {
K varCF8CFCF1855BD2B023CA836D055B4ADC_195836093 =                     (ascending ? stepForward() : stepBackward()).key;
                    varCF8CFCF1855BD2B023CA836D055B4ADC_195836093.addTaint(taint);
                    return varCF8CFCF1855BD2B023CA836D055B4ADC_195836093;
                    // ---------- Original Method ----------
                    //return (ascending ? stepForward() : stepBackward()).key;
                }
};
                var67B4ECA44D3FE1877CC98B43105388F5_2060286296.addTaint(taint);
                return var67B4ECA44D3FE1877CC98B43105388F5_2060286296;
                // ---------- Original Method ----------
                //return new BoundedIterator<K>(endpoint(true)) {
                    //public K next() {
                        //return (ascending ? stepForward() : stepBackward()).key;
                    //}
                //};
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.445 -0400", hash_original_method = "74923548E6D3A508C57DDA053BC0EE64", hash_generated_method = "61D08906757EB6C4EBA71581A3002F1B")
            public Iterator<K> descendingIterator() {
Iterator<K> var9EBD11D4DEB7C81B42F9AB79E3A635DE_1813629407 =                 new BoundedIterator<K>(endpoint(false)) {                
                @DSModeled(DSC.SAFE)
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.445 -0400", hash_original_method = "3DCBF0E7821BEEE7C84D65AF30CA29D6", hash_generated_method = "E99A6431A8CDC809F30FBC7B10FB455D")
                public K next() {
K var5AE3460D8173776397FCF8731046F295_74905366 =                     (ascending ? stepBackward() : stepForward()).key;
                    var5AE3460D8173776397FCF8731046F295_74905366.addTaint(taint);
                    return var5AE3460D8173776397FCF8731046F295_74905366;
                    // ---------- Original Method ----------
                    //return (ascending ? stepBackward() : stepForward()).key;
                }
};
                var9EBD11D4DEB7C81B42F9AB79E3A635DE_1813629407.addTaint(taint);
                return var9EBD11D4DEB7C81B42F9AB79E3A635DE_1813629407;
                // ---------- Original Method ----------
                //return new BoundedIterator<K>(endpoint(false)) {
                    //public K next() {
                        //return (ascending ? stepBackward() : stepForward()).key;
                    //}
                //};
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.446 -0400", hash_original_method = "F2816D590B9E0F32B93C47AB444AEEED", hash_generated_method = "5191C55165DD7A5FD174ADCB681A0925")
            @Override
            public boolean contains(Object key) {
                addTaint(key.getTaint());
                boolean var61DB1BC73AFD05F9CFD09A5DB24EF2D6_1136714811 = (isInBounds(key) && findByObject(key) != null);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1777202807 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1777202807;
                // ---------- Original Method ----------
                //return isInBounds(key) && findByObject(key) != null;
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.446 -0400", hash_original_method = "ADEDE1B4ABE9B2F86F8B629056F35200", hash_generated_method = "68A8B30931254E846A3AF969C1D1E498")
            @Override
            public boolean remove(Object key) {
                addTaint(key.getTaint());
                boolean varFEC11371252D69AE7E6714162868C228_2146736190 = (isInBounds(key) && removeInternalByKey(key) != null);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1563405611 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1563405611;
                // ---------- Original Method ----------
                //return isInBounds(key) && removeInternalByKey(key) != null;
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.446 -0400", hash_original_method = "3067DEE01FBBBFD061436C7D4561F434", hash_generated_method = "CA6E4924867E4F986CF018AD08E18736")
            public K first() {
K var59F2D49FC0979EFEDD893E9689C2AA6B_796994586 =                 firstKey();
                var59F2D49FC0979EFEDD893E9689C2AA6B_796994586.addTaint(taint);
                return var59F2D49FC0979EFEDD893E9689C2AA6B_796994586;
                // ---------- Original Method ----------
                //return firstKey();
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.446 -0400", hash_original_method = "4985BB63726B115899F1811F08E80BDF", hash_generated_method = "A76D072F1F4D9514A547E982458E3B81")
            public K pollFirst() {
                Entry<K, ?> entry = pollFirstEntry();
K var15DE16EBAA69B0A4EA051FB5DEC39C10_1934134007 =                 entry != null ? entry.getKey() : null;
                var15DE16EBAA69B0A4EA051FB5DEC39C10_1934134007.addTaint(taint);
                return var15DE16EBAA69B0A4EA051FB5DEC39C10_1934134007;
                // ---------- Original Method ----------
                //Entry<K, ?> entry = pollFirstEntry();
                //return entry != null ? entry.getKey() : null;
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.446 -0400", hash_original_method = "39C87F788E647BCD3FB86FFF34D7EF10", hash_generated_method = "72C5F9648DFB4910E387AF62C583F60B")
            public K last() {
K var9DAA79F4D4E0401E91D6AAF423D49398_1503771283 =                 lastKey();
                var9DAA79F4D4E0401E91D6AAF423D49398_1503771283.addTaint(taint);
                return var9DAA79F4D4E0401E91D6AAF423D49398_1503771283;
                // ---------- Original Method ----------
                //return lastKey();
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.446 -0400", hash_original_method = "B202B1B2AAB477548F6A0AD72C9B1701", hash_generated_method = "D36D955CA2459804FDCE0EBC044D7958")
            public K pollLast() {
                Entry<K, ?> entry = pollLastEntry();
K var15DE16EBAA69B0A4EA051FB5DEC39C10_1399037975 =                 entry != null ? entry.getKey() : null;
                var15DE16EBAA69B0A4EA051FB5DEC39C10_1399037975.addTaint(taint);
                return var15DE16EBAA69B0A4EA051FB5DEC39C10_1399037975;
                // ---------- Original Method ----------
                //Entry<K, ?> entry = pollLastEntry();
                //return entry != null ? entry.getKey() : null;
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.446 -0400", hash_original_method = "5CFE05BF706A06BBB501067306F1B9ED", hash_generated_method = "FAE98F1170EAAAD882483873EA2AED3C")
            public K lower(K key) {
                addTaint(key.getTaint());
K var2B86BD115FCBD0ED4D0B4CB097A2C388_1805832483 =                 lowerKey(key);
                var2B86BD115FCBD0ED4D0B4CB097A2C388_1805832483.addTaint(taint);
                return var2B86BD115FCBD0ED4D0B4CB097A2C388_1805832483;
                // ---------- Original Method ----------
                //return lowerKey(key);
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.446 -0400", hash_original_method = "10BABB7BB2E837824A13AAE89EE7EC6F", hash_generated_method = "EC6F459C9EB10CFEF0AD02E2AF218B03")
            public K floor(K key) {
                addTaint(key.getTaint());
K var350534B70A929DCE92BCA350B3F7DA8E_472819157 =                 floorKey(key);
                var350534B70A929DCE92BCA350B3F7DA8E_472819157.addTaint(taint);
                return var350534B70A929DCE92BCA350B3F7DA8E_472819157;
                // ---------- Original Method ----------
                //return floorKey(key);
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.447 -0400", hash_original_method = "2AD4706A6D818B709A1E2CA64B48B4B9", hash_generated_method = "569D280400F0162F85FF8981A233FF39")
            public K ceiling(K key) {
                addTaint(key.getTaint());
K varC33643BEB47C1CC66B2C2CDB25527B59_1305879380 =                 ceilingKey(key);
                varC33643BEB47C1CC66B2C2CDB25527B59_1305879380.addTaint(taint);
                return varC33643BEB47C1CC66B2C2CDB25527B59_1305879380;
                // ---------- Original Method ----------
                //return ceilingKey(key);
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.447 -0400", hash_original_method = "8CC63649234BFC57DB10A2387AE34DD6", hash_generated_method = "01085DCAF70DFFF2CF574521E87F2F36")
            public K higher(K key) {
                addTaint(key.getTaint());
K var75CF48C4839A7AAF074C16D584CD6253_1892759944 =                 higherKey(key);
                var75CF48C4839A7AAF074C16D584CD6253_1892759944.addTaint(taint);
                return var75CF48C4839A7AAF074C16D584CD6253_1892759944;
                // ---------- Original Method ----------
                //return higherKey(key);
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.447 -0400", hash_original_method = "C5DD330893039070B9523799F47D2DEB", hash_generated_method = "D61C7ABC39C8C99F14398FFA25ABEF45")
            public Comparator<? super K> comparator() {
Comparator<? super K> varBA2FE525F1D4BFB7E44CC52BEB2076A0_1544429499 =                 BoundedMap.this.comparator();
                varBA2FE525F1D4BFB7E44CC52BEB2076A0_1544429499.addTaint(taint);
                return varBA2FE525F1D4BFB7E44CC52BEB2076A0_1544429499;
                // ---------- Original Method ----------
                //return BoundedMap.this.comparator();
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.447 -0400", hash_original_method = "21039715CA3F916EA62F8064E71FC6CA", hash_generated_method = "4B73A791B08783F8C00BD7D56348FD51")
            public NavigableSet<K> subSet(K from, boolean fromInclusive, K to, boolean toInclusive) {
                addTaint(toInclusive);
                addTaint(to.getTaint());
                addTaint(fromInclusive);
                addTaint(from.getTaint());
NavigableSet<K> var81C01024AF0DDE2CDF42AA146D845866_1186551349 =                 subMap(from, fromInclusive, to, toInclusive).navigableKeySet();
                var81C01024AF0DDE2CDF42AA146D845866_1186551349.addTaint(taint);
                return var81C01024AF0DDE2CDF42AA146D845866_1186551349;
                // ---------- Original Method ----------
                //return subMap(from, fromInclusive, to, toInclusive).navigableKeySet();
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.448 -0400", hash_original_method = "AA0E5149ADFB9D8316CC8EA86FBC0B9E", hash_generated_method = "E078CDE4EFCB6191251DCFDA57DBD585")
            public SortedSet<K> subSet(K fromInclusive, K toExclusive) {
                addTaint(toExclusive.getTaint());
                addTaint(fromInclusive.getTaint());
SortedSet<K> var4825DD5198D9DFA934AB97460E43155A_671359139 =                 subMap(fromInclusive, toExclusive).navigableKeySet();
                var4825DD5198D9DFA934AB97460E43155A_671359139.addTaint(taint);
                return var4825DD5198D9DFA934AB97460E43155A_671359139;
                // ---------- Original Method ----------
                //return subMap(fromInclusive, toExclusive).navigableKeySet();
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.448 -0400", hash_original_method = "EDDD3784AC7E9834A18CCB5F2AE27346", hash_generated_method = "6A9E6EEE845B32044F26271A7C1458DE")
            public NavigableSet<K> headSet(K to, boolean inclusive) {
                addTaint(inclusive);
                addTaint(to.getTaint());
NavigableSet<K> var1DDC11FD80C467CDB58D05608701E96E_1843974992 =                 headMap(to, inclusive).navigableKeySet();
                var1DDC11FD80C467CDB58D05608701E96E_1843974992.addTaint(taint);
                return var1DDC11FD80C467CDB58D05608701E96E_1843974992;
                // ---------- Original Method ----------
                //return headMap(to, inclusive).navigableKeySet();
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.448 -0400", hash_original_method = "85EE899AF4D85617CB858518BA70EA12", hash_generated_method = "9B29651F19890F97ADD7AC02EDB02228")
            public SortedSet<K> headSet(K toExclusive) {
                addTaint(toExclusive.getTaint());
SortedSet<K> var296570554B3647284DAA1B64FE89EA1C_1408494725 =                 headMap(toExclusive).navigableKeySet();
                var296570554B3647284DAA1B64FE89EA1C_1408494725.addTaint(taint);
                return var296570554B3647284DAA1B64FE89EA1C_1408494725;
                // ---------- Original Method ----------
                //return headMap(toExclusive).navigableKeySet();
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.448 -0400", hash_original_method = "B964A303D464756EDD8E9C26A8D54411", hash_generated_method = "8C93F715487CF1208CBC9B98F5655B84")
            public NavigableSet<K> tailSet(K from, boolean inclusive) {
                addTaint(inclusive);
                addTaint(from.getTaint());
NavigableSet<K> varCAB92A74D6D2084A2C4FEA91193971BF_21951347 =                 tailMap(from, inclusive).navigableKeySet();
                varCAB92A74D6D2084A2C4FEA91193971BF_21951347.addTaint(taint);
                return varCAB92A74D6D2084A2C4FEA91193971BF_21951347;
                // ---------- Original Method ----------
                //return tailMap(from, inclusive).navigableKeySet();
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.448 -0400", hash_original_method = "9536952691BDDFD3D8EFB20A3BD9AE85", hash_generated_method = "355E3C1D4458F32DBA78B9CB9087282D")
            public SortedSet<K> tailSet(K fromInclusive) {
                addTaint(fromInclusive.getTaint());
SortedSet<K> var599DB6DD96A121671494C9C10C8AD7AE_2063971726 =                 tailMap(fromInclusive).navigableKeySet();
                var599DB6DD96A121671494C9C10C8AD7AE_2063971726.addTaint(taint);
                return var599DB6DD96A121671494C9C10C8AD7AE_2063971726;
                // ---------- Original Method ----------
                //return tailMap(fromInclusive).navigableKeySet();
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.448 -0400", hash_original_method = "2BD89B2F5D5D75B5A66FC121E2BE77F9", hash_generated_method = "7F76CFA1470D7577F0F9C0089A57F78D")
            public NavigableSet<K> descendingSet() {
NavigableSet<K> varAF8103DD5E04E7E5EEF583022A60862D_1663713395 =                 new BoundedMap(!ascending, from, fromBound, to, toBound).navigableKeySet();
                varAF8103DD5E04E7E5EEF583022A60862D_1663713395.addTaint(taint);
                return varAF8103DD5E04E7E5EEF583022A60862D_1663713395;
                // ---------- Original Method ----------
                //return new BoundedMap(!ascending, from, fromBound, to, toBound).navigableKeySet();
            }

            
        }


        
    }


    
    static abstract class NavigableSubMap<K, V> extends AbstractMap<K, V> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.448 -0400", hash_original_field = "6F8F57715090DA2632453988D9A1501B", hash_generated_field = "B4717CF7B02EE2D309DEC599DAA1DA31")

        TreeMap<K, V> m;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.448 -0400", hash_original_field = "7CE8636C076F5F42316676F7CA5CCFBE", hash_generated_field = "281EBE4703232193C289CCB42FC430E9")

        Object lo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.448 -0400", hash_original_field = "49F68A5C8493EC2C0BF489821C21FC3B", hash_generated_field = "EE270961C9ABF0EB22776F11E5EA361C")

        Object hi;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.448 -0400", hash_original_field = "0F5BB94160321573CBA39E65B009DB81", hash_generated_field = "D276D04527E3A57EE21A2E9A0B8A1207")

        boolean fromStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.448 -0400", hash_original_field = "A7515FC4FC23FB8889BFBA1242727AA1", hash_generated_field = "949B6DE90AB1D05CDD408410B1AFD766")

        boolean toEnd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.448 -0400", hash_original_field = "A7CF08EB9369574B3716AAA5776C2B8D", hash_generated_field = "21B44DD2A9CF91217A1B213D6DC61745")

        boolean loInclusive;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.448 -0400", hash_original_field = "A4BF0B040F2788C41F2B3BBC34352A92", hash_generated_field = "B6BC458569D2A14CE4BE7D6F92D77203")

        boolean hiInclusive;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.449 -0400", hash_original_method = "C1ACA683FC5CFCA3BE29823730AC5B8B", hash_generated_method = "D5980D3B68B4F742E542A915179E4C63")
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.449 -0400", hash_original_method = "98169B5D59A5E61A69F2A37D56262114", hash_generated_method = "ABF792B182FE0894B28111C19970E55E")
        @Override
        public Set<Entry<K, V>> entrySet() {
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1483565003 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_1483565003.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_1483565003;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.449 -0400", hash_original_method = "6A8A4C8549808D70F841B9593D31A43F", hash_generated_method = "A4FBF9CD36A8B654FC19886F53027E77")
        @SuppressWarnings("unchecked")
        protected Object readResolve() throws ObjectStreamException {
            Bound fromBound = fromStart ? NO_BOUND : (loInclusive ? INCLUSIVE : EXCLUSIVE);
            Bound toBound = toEnd ? NO_BOUND : (hiInclusive ? INCLUSIVE : EXCLUSIVE);
            boolean ascending = !(this instanceof DescendingSubMap);
Object var1219B05CBB1AEEB8B0049A311D9879A0_224498156 =             m.new BoundedMap(ascending, (K) lo, fromBound, (K) hi, toBound);
            var1219B05CBB1AEEB8B0049A311D9879A0_224498156.addTaint(taint);
            return var1219B05CBB1AEEB8B0049A311D9879A0_224498156;
            // ---------- Original Method ----------
            //Bound fromBound = fromStart ? NO_BOUND : (loInclusive ? INCLUSIVE : EXCLUSIVE);
            //Bound toBound = toEnd ? NO_BOUND : (hiInclusive ? INCLUSIVE : EXCLUSIVE);
            //boolean ascending = !(this instanceof DescendingSubMap);
            //return m.new BoundedMap(ascending, (K) lo, fromBound, (K) hi, toBound);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.450 -0400", hash_original_field = "24DD802BAD101B93E8408F7D464B2F7C", hash_generated_field = "6BF063A975464DC368634F8846E9F148")

        private static final long serialVersionUID = -2102997345730753016L;
    }


    
    static class DescendingSubMap<K, V> extends NavigableSubMap<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.450 -0400", hash_original_field = "9895B45EF9B1655F7485C1A0A0B5F7B1", hash_generated_field = "4B9119BDF2383B87567C450919484206")

        Comparator<K> reverseComparator;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.450 -0400", hash_original_method = "FDAA1F4436CE129642763FB7A272001D", hash_generated_method = "EE69462E1E829F3C3BD441CA8A6A00F0")
          DescendingSubMap(TreeMap<K, V> delegate, K from, Bound fromBound, K to, Bound toBound) {
            super(delegate, from, fromBound, to, toBound);
            addTaint(toBound.getTaint());
            addTaint(to.getTaint());
            addTaint(fromBound.getTaint());
            addTaint(from.getTaint());
            addTaint(delegate.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.450 -0400", hash_original_field = "52D0D343187A178B79D894969A386899", hash_generated_field = "C2E3DB7866C7906947BFB5DD9B67BC77")

        private static final long serialVersionUID = 912986545866120460L;
    }


    
    static class AscendingSubMap<K, V> extends NavigableSubMap<K, V> {
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.452 -0400", hash_original_method = "C32F016187D7478ED63A0FCF56CB93EB", hash_generated_method = "6B067806C6CF8D3FE392FCD588CFD190")
          AscendingSubMap(TreeMap<K, V> delegate, K from, Bound fromBound, K to, Bound toBound) {
            super(delegate, from, fromBound, to, toBound);
            addTaint(toBound.getTaint());
            addTaint(to.getTaint());
            addTaint(fromBound.getTaint());
            addTaint(from.getTaint());
            addTaint(delegate.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.452 -0400", hash_original_field = "B7AE5FA51DF371C0F9A4E87B021D4132", hash_generated_field = "9BC786EF1C7A0AEECE0DAFB6F4501079")

        private static final long serialVersionUID = 912986545866124060L;
    }


    
    class SubMap extends AbstractMap<K, V> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.452 -0400", hash_original_field = "430A77C88BFBC96EB36AF12A2DC1DEB7", hash_generated_field = "7CA688EFC5D14AE4FAAF4A0FA771CBD0")

        Object fromKey;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.452 -0400", hash_original_field = "A8F9F07D66AF8C1622E025437E7B26CE", hash_generated_field = "40A3A7AC103CBB24D1824415661519AF")

        Object toKey;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.452 -0400", hash_original_field = "0F5BB94160321573CBA39E65B009DB81", hash_generated_field = "D276D04527E3A57EE21A2E9A0B8A1207")

        boolean fromStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.452 -0400", hash_original_field = "A7515FC4FC23FB8889BFBA1242727AA1", hash_generated_field = "949B6DE90AB1D05CDD408410B1AFD766")

        boolean toEnd;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.452 -0400", hash_original_method = "F30568FCC0DA5EEA09201E340702FDB4", hash_generated_method = "F30568FCC0DA5EEA09201E340702FDB4")
        public SubMap ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.452 -0400", hash_original_method = "98169B5D59A5E61A69F2A37D56262114", hash_generated_method = "5845133A2FDB7DB3B5F4E606D0D555F5")
        @Override
        public Set<Entry<K, V>> entrySet() {
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_666067017 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_666067017.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_666067017;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.453 -0400", hash_original_method = "AC95C6CC81DF8BD4B0519A49635D6CF0", hash_generated_method = "93AA2D497A7C38810EC0BE526229A26E")
        @SuppressWarnings("unchecked")
        protected Object readResolve() throws ObjectStreamException {
            Bound fromBound = fromStart ? NO_BOUND : INCLUSIVE;
            Bound toBound = toEnd ? NO_BOUND : EXCLUSIVE;
Object var7784C953CCD41FF740A502CFF8B72EA4_1031546749 =             new BoundedMap(true, (K) fromKey, fromBound, (K) toKey, toBound);
            var7784C953CCD41FF740A502CFF8B72EA4_1031546749.addTaint(taint);
            return var7784C953CCD41FF740A502CFF8B72EA4_1031546749;
            // ---------- Original Method ----------
            //Bound fromBound = fromStart ? NO_BOUND : INCLUSIVE;
            //Bound toBound = toEnd ? NO_BOUND : EXCLUSIVE;
            //return new BoundedMap(true, (K) fromKey, fromBound, (K) toKey, toBound);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.453 -0400", hash_original_field = "EB690E9D3449E3ACDD044094944C88A2", hash_generated_field = "20872E7F065D1D88A3E41FBB2346AD4E")

        private static final long serialVersionUID = -6520786458950516097L;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.547 -0400", hash_original_field = "AAD864C939B46188F070706401E1932C", hash_generated_field = "C574FEBC92A9E5D83B951EB931304363")

    @SuppressWarnings("unchecked") private static final Comparator<Comparable> NATURAL_ORDER = new Comparator<Comparable>() {        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.547 -0400", hash_original_method = "078A1DB9555D9E606EA5FF406F56B2E6", hash_generated_method = "00940CF90AFA854079CAC5C992323851")
        public int compare(Comparable a, Comparable b) {
            int varC15B2565AD7A5177ED0132648C5386D9_18628642 = (a.compareTo(b));
            addTaint(a.getTaint());
            addTaint(b.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1221955437 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1221955437;
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.453 -0400", hash_original_field = "0CB2D400AD555324093441A5EA2C6B7E", hash_generated_field = "72B7CECA8AF68C19BE3FF8E965B18D99")

    private static final long serialVersionUID = 919286545866124006L;
}

