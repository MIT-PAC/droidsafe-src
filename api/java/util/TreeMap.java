package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.643 -0400", hash_original_field = "4092F21BD0E2CC3C9CA971DF59AA8608", hash_generated_field = "10E826BC31BCAB9BF3EF3CC29146C2D4")

    Comparator<? super K> comparator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.644 -0400", hash_original_field = "63A9F0EA7BB98050796B649E85481845", hash_generated_field = "85295BCB9659691A12B83D4313F1A2F9")

    Node<K, V> root;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.644 -0400", hash_original_field = "4C519DE3531208469B40CCB51004CD2D", hash_generated_field = "689FC3CB9A887B5817C15E9CFDD066DB")

    int size = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.644 -0400", hash_original_field = "8626C3CD64A823DD7B97C6F5EF45A8FC", hash_generated_field = "7C38AA8724D6D8AD727BB2AB85887DF0")

    int modCount = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.644 -0400", hash_original_field = "D4E06C98DBA5A687CB6C836BF538EC81", hash_generated_field = "78564EACF73DB0AEDD2E075A8DFF1B13")

    private EntrySet entrySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.644 -0400", hash_original_field = "3E8ABCE844B6A8A95397486A3899B536", hash_generated_field = "455D81AE8BC4090CF8AD993E78862377")

    private KeySet keySet;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.644 -0400", hash_original_method = "A79D85B768A2B786B5F2ACD3F2B9D249", hash_generated_method = "CFE342F2F41F7796DB24A93B3EC5E9D4")
    @SuppressWarnings("unchecked")
    public  TreeMap() {
        this.comparator = (Comparator<? super K>) NATURAL_ORDER;
        // ---------- Original Method ----------
        //this.comparator = (Comparator<? super K>) NATURAL_ORDER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.645 -0400", hash_original_method = "317880CC1AD8B8CC7D9C11CC941EE8C3", hash_generated_method = "C50778A3B9FF17C06EAC39C559AF87B9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.645 -0400", hash_original_method = "C1FE892CAD9D3780A675F5A8CA11F4FA", hash_generated_method = "39BB15B650529D91F63E90DE9C103299")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.646 -0400", hash_original_method = "2607F9CE6A88866DC32D385287E67644", hash_generated_method = "88414D93BF999D1A507D7F23D1F831E8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.647 -0400", hash_original_method = "FB8B1056739768AF92CF25DB3C2D30EB", hash_generated_method = "E5C81777706380397C2EFCD0E7CCEDA8")
    @Override
    public Object clone() {
        try 
        {
            @SuppressWarnings("unchecked") TreeMap<K, V> map = (TreeMap<K, V>) super.clone();
            map.root = root != null ? root.copy(null) : null;
            map.entrySet = null;
            map.keySet = null;
Object var16A0D6FA6CCA40A72F4213E7169FA153_1182723090 =             map;
            var16A0D6FA6CCA40A72F4213E7169FA153_1182723090.addTaint(taint);
            return var16A0D6FA6CCA40A72F4213E7169FA153_1182723090;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA81442E36297E737EB908877E58260E8_1069877208 = new AssertionError();
            varA81442E36297E737EB908877E58260E8_1069877208.addTaint(taint);
            throw varA81442E36297E737EB908877E58260E8_1069877208;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.647 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "632CD7774234EEFCE7765B8BBD35AC0E")
    @Override
    public int size() {
        int varF7BD60B75B29D79B660A2859395C1A24_1221432753 = (size);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_748840871 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_748840871;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.647 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "6E7013EAB8B4DF9682CA6232BE0B117E")
    @Override
    public boolean isEmpty() {
        boolean var9FB8BC7F775DDD98EEAB5582D340229E_679926484 = (size == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1752170438 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1752170438;
        // ---------- Original Method ----------
        //return size == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.648 -0400", hash_original_method = "C35732A40B74AF28951D9E96FE33879B", hash_generated_method = "AC57AB11E9311C0B3046B76992B32525")
    @Override
    public V get(Object key) {
        addTaint(key.getTaint());
        Entry<K, V> entry = findByObject(key);
V var6522E82B8E3E24073E106E1391BF1804_653846231 =         entry != null ? entry.getValue() : null;
        var6522E82B8E3E24073E106E1391BF1804_653846231.addTaint(taint);
        return var6522E82B8E3E24073E106E1391BF1804_653846231;
        // ---------- Original Method ----------
        //Entry<K, V> entry = findByObject(key);
        //return entry != null ? entry.getValue() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.648 -0400", hash_original_method = "CD38E6D478445847B9B0A556F5E63837", hash_generated_method = "844E2573215D8131FDEF47A1DBBCF018")
    @Override
    public boolean containsKey(Object key) {
        addTaint(key.getTaint());
        boolean var50FA98E2BCCBB965D41019D477E20A3B_1777514582 = (findByObject(key) != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2096545470 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2096545470;
        // ---------- Original Method ----------
        //return findByObject(key) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.649 -0400", hash_original_method = "09423F07E68B4770E107529B69AA8334", hash_generated_method = "7485480741C52CA29731712B64B72B92")
    @Override
    public V put(K key, V value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
V var2E37B97A19208A3D82E5317F45BDDA5A_1445598295 =         putInternal(key, value);
        var2E37B97A19208A3D82E5317F45BDDA5A_1445598295.addTaint(taint);
        return var2E37B97A19208A3D82E5317F45BDDA5A_1445598295;
        // ---------- Original Method ----------
        //return putInternal(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.649 -0400", hash_original_method = "EA5BE6ED678D7376259BCC3DB1C01E21", hash_generated_method = "E961ABE6C82A278E3968107998979047")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.649 -0400", hash_original_method = "0207194EB3BB344ADD94A18916C183DF", hash_generated_method = "79C72FE21A9E1ACB958A90868B3D3421")
    @Override
    public V remove(Object key) {
        addTaint(key.getTaint());
        Node<K, V> node = removeInternalByKey(key);
V var103CE18E43EB729FC0D45019043637D4_621906416 =         node != null ? node.value : null;
        var103CE18E43EB729FC0D45019043637D4_621906416.addTaint(taint);
        return var103CE18E43EB729FC0D45019043637D4_621906416;
        // ---------- Original Method ----------
        //Node<K, V> node = removeInternalByKey(key);
        //return node != null ? node.value : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.650 -0400", hash_original_method = "73D5DA91D47B13631BBA1FF4FFC14006", hash_generated_method = "7D17DC97ED4C5C8D5B672D9F5319C5BA")
     V putInternal(K key, V value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        Node<K, V> created = find(key, Relation.CREATE);
        V result = created.value;
        created.value = value;
V varDC838461EE2FA0CA4C9BBB70A15456B0_473259386 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_473259386.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_473259386;
        // ---------- Original Method ----------
        //Node<K, V> created = find(key, Relation.CREATE);
        //V result = created.value;
        //created.value = value;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.651 -0400", hash_original_method = "A47B461F1595004F5F78D5AE91E8DCD0", hash_generated_method = "12184AD614040D3963A4F242FEBF5263")
     Node<K, V> find(K key, Relation relation) {
        addTaint(relation.getTaint());
    if(root == null)        
        {
    if(comparator == NATURAL_ORDER && !(key instanceof Comparable))            
            {
                ClassCastException varE25C8FF4E605E3C5DE615DBEA48247CB_741019513 = new ClassCastException(key.getClass().getName() + " is not Comparable");
                varE25C8FF4E605E3C5DE615DBEA48247CB_741019513.addTaint(taint);
                throw varE25C8FF4E605E3C5DE615DBEA48247CB_741019513;
            } //End block
    if(relation == Relation.CREATE)            
            {
                root = new Node<K, V>(null, key);
                size = 1;
                modCount++;
Node<K, V> varE2FC54A1BB143D1D1A0E38EDF22F290D_1871088496 =                 root;
                varE2FC54A1BB143D1D1A0E38EDF22F290D_1871088496.addTaint(taint);
                return varE2FC54A1BB143D1D1A0E38EDF22F290D_1871088496;
            } //End block
            else
            {
Node<K, V> var540C13E9E156B687226421B24F2DF178_1236016292 =                 null;
                var540C13E9E156B687226421B24F2DF178_1236016292.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1236016292;
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
Node<K, V> var4FA6404FB0D962CE5F6E6CAEF4B8D23D_950281261 =                 nearest.prev();
                var4FA6404FB0D962CE5F6E6CAEF4B8D23D_950281261.addTaint(taint);
                return var4FA6404FB0D962CE5F6E6CAEF4B8D23D_950281261;
                case FLOOR:
                case EQUAL:
                case CREATE:
                case CEILING:
Node<K, V> var1ABCA9B14CBAD43438A66451686D7523_312902969 =                 nearest;
                var1ABCA9B14CBAD43438A66451686D7523_312902969.addTaint(taint);
                return var1ABCA9B14CBAD43438A66451686D7523_312902969;
                case HIGHER:
Node<K, V> varB0C7B68E04E5B0A83ABC7508552291EE_783296243 =                 nearest.next();
                varB0C7B68E04E5B0A83ABC7508552291EE_783296243.addTaint(taint);
                return varB0C7B68E04E5B0A83ABC7508552291EE_783296243;
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
Node<K, V> var4FA6404FB0D962CE5F6E6CAEF4B8D23D_2132374199 =                 nearest.prev();
                var4FA6404FB0D962CE5F6E6CAEF4B8D23D_2132374199.addTaint(taint);
                return var4FA6404FB0D962CE5F6E6CAEF4B8D23D_2132374199;
                case CEILING:
                case HIGHER:
Node<K, V> var1ABCA9B14CBAD43438A66451686D7523_2071407758 =                 nearest;
                var1ABCA9B14CBAD43438A66451686D7523_2071407758.addTaint(taint);
                return var1ABCA9B14CBAD43438A66451686D7523_2071407758;
                case EQUAL:
Node<K, V> var540C13E9E156B687226421B24F2DF178_1817856437 =                 null;
                var540C13E9E156B687226421B24F2DF178_1817856437.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1817856437;
                case CREATE:
                Node<K, V> created = new Node<K, V>(nearest, key);
                nearest.left = created;
                size++;
                modCount++;
                rebalance(nearest, true);
Node<K, V> varF62A73A42555B3FDC3F4E92223B094E6_830586287 =                 created;
                varF62A73A42555B3FDC3F4E92223B094E6_830586287.addTaint(taint);
                return varF62A73A42555B3FDC3F4E92223B094E6_830586287;
}
            } //End block
            else
            {
switch(relation){
                case LOWER:
                case FLOOR:
Node<K, V> var1ABCA9B14CBAD43438A66451686D7523_558767124 =                 nearest;
                var1ABCA9B14CBAD43438A66451686D7523_558767124.addTaint(taint);
                return var1ABCA9B14CBAD43438A66451686D7523_558767124;
                case CEILING:
                case HIGHER:
Node<K, V> varB0C7B68E04E5B0A83ABC7508552291EE_312314272 =                 nearest.next();
                varB0C7B68E04E5B0A83ABC7508552291EE_312314272.addTaint(taint);
                return varB0C7B68E04E5B0A83ABC7508552291EE_312314272;
                case EQUAL:
Node<K, V> var540C13E9E156B687226421B24F2DF178_1737607442 =                 null;
                var540C13E9E156B687226421B24F2DF178_1737607442.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1737607442;
                case CREATE:
                Node<K, V> created = new Node<K, V>(nearest, key);
                nearest.right = created;
                size++;
                modCount++;
                rebalance(nearest, true);
Node<K, V> varF62A73A42555B3FDC3F4E92223B094E6_1117013361 =                 created;
                varF62A73A42555B3FDC3F4E92223B094E6_1117013361.addTaint(taint);
                return varF62A73A42555B3FDC3F4E92223B094E6_1117013361;
}
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.652 -0400", hash_original_method = "C267D163E835004AE4803D9A2BC1E552", hash_generated_method = "77BE61E5DE192D2494FE69DDA3458378")
    @SuppressWarnings("unchecked")
     Node<K, V> findByObject(Object key) {
        addTaint(key.getTaint());
Node<K, V> var979736B4CE3624D031D085814C41C424_1142296489 =         find((K) key, EQUAL);
        var979736B4CE3624D031D085814C41C424_1142296489.addTaint(taint);
        return var979736B4CE3624D031D085814C41C424_1142296489;
        // ---------- Original Method ----------
        //return find((K) key, EQUAL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.652 -0400", hash_original_method = "8678505752B854905CFE7B96C4FE458B", hash_generated_method = "F9D1D7C982928EE29B5D5522E1A6AE79")
     Node<K, V> findByEntry(Entry<?, ?> entry) {
        addTaint(entry.getTaint());
        Node<K, V> mine = findByObject(entry.getKey());
        boolean valuesEqual = mine != null && Objects.equal(mine.value, entry.getValue());
Node<K, V> varF219D1114161BEAF529424AB7E82DFA0_326406107 =         valuesEqual ? mine : null;
        varF219D1114161BEAF529424AB7E82DFA0_326406107.addTaint(taint);
        return varF219D1114161BEAF529424AB7E82DFA0_326406107;
        // ---------- Original Method ----------
        //Node<K, V> mine = findByObject(entry.getKey());
        //boolean valuesEqual = mine != null && Objects.equal(mine.value, entry.getValue());
        //return valuesEqual ? mine : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.654 -0400", hash_original_method = "FAD76EC8E4C5DF9CCDE64BA514AC9743", hash_generated_method = "B30FED3CC81BBE6E813079857E593100")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.655 -0400", hash_original_method = "C9B9883A6728DC2F4DBB90BDF61B9978", hash_generated_method = "D4FBC3AB71FC55151587EE9E8E4C80B1")
     Node<K, V> removeInternalByKey(Object key) {
        addTaint(key.getTaint());
        Node<K, V> node = findByObject(key);
    if(node != null)        
        {
            removeInternal(node);
        } //End block
Node<K, V> var1924C94B76524D1C3D7310EA17B0EF94_1853289817 =         node;
        var1924C94B76524D1C3D7310EA17B0EF94_1853289817.addTaint(taint);
        return var1924C94B76524D1C3D7310EA17B0EF94_1853289817;
        // ---------- Original Method ----------
        //Node<K, V> node = findByObject(key);
        //if (node != null) {
            //removeInternal(node);
        //}
        //return node;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.656 -0400", hash_original_method = "8CBFE12E379E7871AFCE5B0FC5C284CB", hash_generated_method = "6C31EDACABDC5C5503AC657CCCAF0917")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.657 -0400", hash_original_method = "DE22B63E2A021BAF8A5DCC142FCC4B40", hash_generated_method = "493B1AC789FA627753B6464BC00715EE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.659 -0400", hash_original_method = "6326CB79DBF89391F00F9AB13B0E81D9", hash_generated_method = "685523E676E56BFF33243B0EB971ECC7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.660 -0400", hash_original_method = "DF035E309292DEA6067E726F513C85C3", hash_generated_method = "4A8DF272658781BA2B1B74BBEFBED10F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.660 -0400", hash_original_method = "E2F61A98BB539F90A11465C6A8354CE5", hash_generated_method = "467DD50FCF349E490BDE0F7C6F95AAC6")
    private SimpleImmutableEntry<K, V> immutableCopy(Entry<K, V> entry) {
        addTaint(entry.getTaint());
SimpleImmutableEntry<K, V> var00719393D67D40742FD53C80CE0E5B0C_983283116 =         entry == null ? null : new SimpleImmutableEntry<K, V>(entry);
        var00719393D67D40742FD53C80CE0E5B0C_983283116.addTaint(taint);
        return var00719393D67D40742FD53C80CE0E5B0C_983283116;
        // ---------- Original Method ----------
        //return entry == null ? null : new SimpleImmutableEntry<K, V>(entry);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.661 -0400", hash_original_method = "9F2AE61C584701540103A59451B8FA45", hash_generated_method = "C549812CCF255EA15880CE2F3DBBB23F")
    public Entry<K, V> firstEntry() {
Entry<K, V> var79CE0C1FA3610C2C3C5116B38C8243BB_1087479243 =         immutableCopy(root == null ? null : root.first());
        var79CE0C1FA3610C2C3C5116B38C8243BB_1087479243.addTaint(taint);
        return var79CE0C1FA3610C2C3C5116B38C8243BB_1087479243;
        // ---------- Original Method ----------
        //return immutableCopy(root == null ? null : root.first());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.661 -0400", hash_original_method = "2730A7A2197248AC3B653DF430BA3F4A", hash_generated_method = "29D389EB951CF0534D3738B82F3503A4")
    private Entry<K, V> internalPollFirstEntry() {
    if(root == null)        
        {
Entry<K, V> var540C13E9E156B687226421B24F2DF178_1783160516 =             null;
            var540C13E9E156B687226421B24F2DF178_1783160516.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1783160516;
        } //End block
        Node<K, V> result = root.first();
        removeInternal(result);
Entry<K, V> varDC838461EE2FA0CA4C9BBB70A15456B0_1892069661 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1892069661.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1892069661;
        // ---------- Original Method ----------
        //if (root == null) {
            //return null;
        //}
        //Node<K, V> result = root.first();
        //removeInternal(result);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.661 -0400", hash_original_method = "1456A4986DE10120F25B46536C8BF169", hash_generated_method = "90BAF5ADFD23CA2B675F2C5322A0FABD")
    public Entry<K, V> pollFirstEntry() {
Entry<K, V> var0EECE440B7D78C06FD543B2F85411722_905859838 =         immutableCopy(internalPollFirstEntry());
        var0EECE440B7D78C06FD543B2F85411722_905859838.addTaint(taint);
        return var0EECE440B7D78C06FD543B2F85411722_905859838;
        // ---------- Original Method ----------
        //return immutableCopy(internalPollFirstEntry());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.662 -0400", hash_original_method = "B0B89D697E050FAAC6816A6E8B1E56A4", hash_generated_method = "9501CDFB81F308A10865E1B60D60CCB4")
    public K firstKey() {
    if(root == null)        
        {
            NoSuchElementException var28D00AB599969908D71F102AF992D49A_92829633 = new NoSuchElementException();
            var28D00AB599969908D71F102AF992D49A_92829633.addTaint(taint);
            throw var28D00AB599969908D71F102AF992D49A_92829633;
        } //End block
K varFFDB4EE987544BDFCAAFFDF456CF9ED7_1888618703 =         root.first().getKey();
        varFFDB4EE987544BDFCAAFFDF456CF9ED7_1888618703.addTaint(taint);
        return varFFDB4EE987544BDFCAAFFDF456CF9ED7_1888618703;
        // ---------- Original Method ----------
        //if (root == null) {
            //throw new NoSuchElementException();
        //}
        //return root.first().getKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.662 -0400", hash_original_method = "9DDE470F0E6425136CCDC59F74FCDED6", hash_generated_method = "6C3AB18AD0A302621D4BCA349562A51A")
    public Entry<K, V> lastEntry() {
Entry<K, V> varB7DBB4F9C12E716C4523A7BCAD68DA7B_1410352332 =         immutableCopy(root == null ? null : root.last());
        varB7DBB4F9C12E716C4523A7BCAD68DA7B_1410352332.addTaint(taint);
        return varB7DBB4F9C12E716C4523A7BCAD68DA7B_1410352332;
        // ---------- Original Method ----------
        //return immutableCopy(root == null ? null : root.last());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.662 -0400", hash_original_method = "A726E2736A4C282A51BDD8062FE5CCFA", hash_generated_method = "65BAA5893A8F91310C14C2F5D0B9795C")
    private Entry<K, V> internalPollLastEntry() {
    if(root == null)        
        {
Entry<K, V> var540C13E9E156B687226421B24F2DF178_974070069 =             null;
            var540C13E9E156B687226421B24F2DF178_974070069.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_974070069;
        } //End block
        Node<K, V> result = root.last();
        removeInternal(result);
Entry<K, V> varDC838461EE2FA0CA4C9BBB70A15456B0_441105591 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_441105591.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_441105591;
        // ---------- Original Method ----------
        //if (root == null) {
            //return null;
        //}
        //Node<K, V> result = root.last();
        //removeInternal(result);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.663 -0400", hash_original_method = "5064879999AB9A13D0821F605568F112", hash_generated_method = "A3074ED48F833C25835C2878C33D1090")
    public Entry<K, V> pollLastEntry() {
Entry<K, V> var44A4321894496F1D46DEB734245D76D0_1206739168 =         immutableCopy(internalPollLastEntry());
        var44A4321894496F1D46DEB734245D76D0_1206739168.addTaint(taint);
        return var44A4321894496F1D46DEB734245D76D0_1206739168;
        // ---------- Original Method ----------
        //return immutableCopy(internalPollLastEntry());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.663 -0400", hash_original_method = "9EE1928205B19C964D03E8011BB7E907", hash_generated_method = "D11CB15E7F1A5E3DDA57C88CBA9E4859")
    public K lastKey() {
    if(root == null)        
        {
            NoSuchElementException var28D00AB599969908D71F102AF992D49A_582935207 = new NoSuchElementException();
            var28D00AB599969908D71F102AF992D49A_582935207.addTaint(taint);
            throw var28D00AB599969908D71F102AF992D49A_582935207;
        } //End block
K var89E8F762FABDD09081364F205A5E223D_594727910 =         root.last().getKey();
        var89E8F762FABDD09081364F205A5E223D_594727910.addTaint(taint);
        return var89E8F762FABDD09081364F205A5E223D_594727910;
        // ---------- Original Method ----------
        //if (root == null) {
            //throw new NoSuchElementException();
        //}
        //return root.last().getKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.663 -0400", hash_original_method = "9D71F38DCAD7DBC2AA9FACCDA9CF4866", hash_generated_method = "555567C7650F49F0A40236FBB2F8DF15")
    public Entry<K, V> lowerEntry(K key) {
        addTaint(key.getTaint());
Entry<K, V> var2CD740B62094A0BE9D7BBD31060576E2_1773949371 =         immutableCopy(find(key, LOWER));
        var2CD740B62094A0BE9D7BBD31060576E2_1773949371.addTaint(taint);
        return var2CD740B62094A0BE9D7BBD31060576E2_1773949371;
        // ---------- Original Method ----------
        //return immutableCopy(find(key, LOWER));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.664 -0400", hash_original_method = "BC9464ECC7239B355BB45B80204BADD6", hash_generated_method = "62D17DCFC0C523DDC86F2D30C71AB6F0")
    public K lowerKey(K key) {
        addTaint(key.getTaint());
        Entry<K, V> entry = find(key, LOWER);
K var15DE16EBAA69B0A4EA051FB5DEC39C10_349222226 =         entry != null ? entry.getKey() : null;
        var15DE16EBAA69B0A4EA051FB5DEC39C10_349222226.addTaint(taint);
        return var15DE16EBAA69B0A4EA051FB5DEC39C10_349222226;
        // ---------- Original Method ----------
        //Entry<K, V> entry = find(key, LOWER);
        //return entry != null ? entry.getKey() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.664 -0400", hash_original_method = "5D12D4D534218428856149792C7C973A", hash_generated_method = "ED55DFCBBB5211503B30C6857BFDDC97")
    public Entry<K, V> floorEntry(K key) {
        addTaint(key.getTaint());
Entry<K, V> varFC28F480740B0E7D38107EE8EE92D0CE_1062546657 =         immutableCopy(find(key, FLOOR));
        varFC28F480740B0E7D38107EE8EE92D0CE_1062546657.addTaint(taint);
        return varFC28F480740B0E7D38107EE8EE92D0CE_1062546657;
        // ---------- Original Method ----------
        //return immutableCopy(find(key, FLOOR));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.664 -0400", hash_original_method = "9E3521C1E5D0BB4CA97E65B4B91FC561", hash_generated_method = "A52390492C42ABF063BB80F1A3CEE986")
    public K floorKey(K key) {
        addTaint(key.getTaint());
        Entry<K, V> entry = find(key, FLOOR);
K var15DE16EBAA69B0A4EA051FB5DEC39C10_1319502373 =         entry != null ? entry.getKey() : null;
        var15DE16EBAA69B0A4EA051FB5DEC39C10_1319502373.addTaint(taint);
        return var15DE16EBAA69B0A4EA051FB5DEC39C10_1319502373;
        // ---------- Original Method ----------
        //Entry<K, V> entry = find(key, FLOOR);
        //return entry != null ? entry.getKey() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.665 -0400", hash_original_method = "14BBCA12BBBC651385215255CDF3836D", hash_generated_method = "74EE26EB5907AD35EE217E9DB9A47CA5")
    public Entry<K, V> ceilingEntry(K key) {
        addTaint(key.getTaint());
Entry<K, V> var131EB57F4C7B5C94393840328ED7CD98_5497528 =         immutableCopy(find(key, CEILING));
        var131EB57F4C7B5C94393840328ED7CD98_5497528.addTaint(taint);
        return var131EB57F4C7B5C94393840328ED7CD98_5497528;
        // ---------- Original Method ----------
        //return immutableCopy(find(key, CEILING));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.665 -0400", hash_original_method = "818E984E93F7F07D0C27D2493F11C2A5", hash_generated_method = "D7F0173E5645E74AB7BA1F07B61AD9D2")
    public K ceilingKey(K key) {
        addTaint(key.getTaint());
        Entry<K, V> entry = find(key, CEILING);
K var15DE16EBAA69B0A4EA051FB5DEC39C10_71912207 =         entry != null ? entry.getKey() : null;
        var15DE16EBAA69B0A4EA051FB5DEC39C10_71912207.addTaint(taint);
        return var15DE16EBAA69B0A4EA051FB5DEC39C10_71912207;
        // ---------- Original Method ----------
        //Entry<K, V> entry = find(key, CEILING);
        //return entry != null ? entry.getKey() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.665 -0400", hash_original_method = "AC2414FDDF42A1318F8CC45C80E09BC1", hash_generated_method = "E23781F582A2BE57C328866F27C4AB30")
    public Entry<K, V> higherEntry(K key) {
        addTaint(key.getTaint());
Entry<K, V> var1FAF81EDC2E516F856DA0495977C077B_756852747 =         immutableCopy(find(key, HIGHER));
        var1FAF81EDC2E516F856DA0495977C077B_756852747.addTaint(taint);
        return var1FAF81EDC2E516F856DA0495977C077B_756852747;
        // ---------- Original Method ----------
        //return immutableCopy(find(key, HIGHER));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.666 -0400", hash_original_method = "0C080E769BA3B62EBC93442ECCB0FC7D", hash_generated_method = "4F09165DCB66A7D8EBB18912D7E0A4A4")
    public K higherKey(K key) {
        addTaint(key.getTaint());
        Entry<K, V> entry = find(key, HIGHER);
K var15DE16EBAA69B0A4EA051FB5DEC39C10_902934812 =         entry != null ? entry.getKey() : null;
        var15DE16EBAA69B0A4EA051FB5DEC39C10_902934812.addTaint(taint);
        return var15DE16EBAA69B0A4EA051FB5DEC39C10_902934812;
        // ---------- Original Method ----------
        //Entry<K, V> entry = find(key, HIGHER);
        //return entry != null ? entry.getKey() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.666 -0400", hash_original_method = "6A8618E17145F23513711DA8498038AE", hash_generated_method = "3BB11C7C3505C8A42EB45D5346D6A39C")
    public Comparator<? super K> comparator() {
Comparator<? super K> varFC8F75816E5A2BE67601D262F4DD4CC3_1820605315 =         comparator != NATURAL_ORDER ? comparator : null;
        varFC8F75816E5A2BE67601D262F4DD4CC3_1820605315.addTaint(taint);
        return varFC8F75816E5A2BE67601D262F4DD4CC3_1820605315;
        // ---------- Original Method ----------
        //return comparator != NATURAL_ORDER ? comparator : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.666 -0400", hash_original_method = "D2C4C51D99D6D10356C2F96D116110D2", hash_generated_method = "F70D30D688550C2769B9B9F5BB353C8A")
    @Override
    public Set<Entry<K, V>> entrySet() {
        EntrySet result = entrySet;
Set<Entry<K, V>> var546348868B918B94B697AA7A0212D78D_1181926916 =         result != null ? result : (entrySet = new EntrySet());
        var546348868B918B94B697AA7A0212D78D_1181926916.addTaint(taint);
        return var546348868B918B94B697AA7A0212D78D_1181926916;
        // ---------- Original Method ----------
        //EntrySet result = entrySet;
        //return result != null ? result : (entrySet = new EntrySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.667 -0400", hash_original_method = "0E17D4043440FAA66222611D1AC45111", hash_generated_method = "CC8FE06EAE1405042A237BB13CEB0906")
    @Override
    public Set<K> keySet() {
        KeySet result = keySet;
Set<K> varA3D98E595497E0937159D5BF4C5A28F3_831928747 =         result != null ? result : (keySet = new KeySet());
        varA3D98E595497E0937159D5BF4C5A28F3_831928747.addTaint(taint);
        return varA3D98E595497E0937159D5BF4C5A28F3_831928747;
        // ---------- Original Method ----------
        //KeySet result = keySet;
        //return result != null ? result : (keySet = new KeySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.667 -0400", hash_original_method = "016115EA38C293C7AAA8E892AEA754CA", hash_generated_method = "E63773ABEA31F230AA0FDA4363EA0340")
    public NavigableSet<K> navigableKeySet() {
        KeySet result = keySet;
NavigableSet<K> varA3D98E595497E0937159D5BF4C5A28F3_1920794509 =         result != null ? result : (keySet = new KeySet());
        varA3D98E595497E0937159D5BF4C5A28F3_1920794509.addTaint(taint);
        return varA3D98E595497E0937159D5BF4C5A28F3_1920794509;
        // ---------- Original Method ----------
        //KeySet result = keySet;
        //return result != null ? result : (keySet = new KeySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.668 -0400", hash_original_method = "DA6DE2093EE8DE46EE4576501F54E528", hash_generated_method = "D93BA36897981BFD72B1F2AD7F20169F")
    public NavigableMap<K, V> subMap(K from, boolean fromInclusive, K to, boolean toInclusive) {
        addTaint(toInclusive);
        addTaint(to.getTaint());
        addTaint(fromInclusive);
        addTaint(from.getTaint());
        Bound fromBound = fromInclusive ? INCLUSIVE : EXCLUSIVE;
        Bound toBound = toInclusive ? INCLUSIVE : EXCLUSIVE;
NavigableMap<K, V> varC1ADA0B077817E4E937F0AB6A4E4BFEB_1536599461 =         new BoundedMap(true, from, fromBound, to, toBound);
        varC1ADA0B077817E4E937F0AB6A4E4BFEB_1536599461.addTaint(taint);
        return varC1ADA0B077817E4E937F0AB6A4E4BFEB_1536599461;
        // ---------- Original Method ----------
        //Bound fromBound = fromInclusive ? INCLUSIVE : EXCLUSIVE;
        //Bound toBound = toInclusive ? INCLUSIVE : EXCLUSIVE;
        //return new BoundedMap(true, from, fromBound, to, toBound);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.668 -0400", hash_original_method = "193BA03007E91EBBDB489C20B60BFC88", hash_generated_method = "976CC4411F6C4475E0878F269EE5CDC5")
    public SortedMap<K, V> subMap(K fromInclusive, K toExclusive) {
        addTaint(toExclusive.getTaint());
        addTaint(fromInclusive.getTaint());
SortedMap<K, V> varD1C8F801B36255D14CED2B3CFD68DC65_737943635 =         new BoundedMap(true, fromInclusive, INCLUSIVE, toExclusive, EXCLUSIVE);
        varD1C8F801B36255D14CED2B3CFD68DC65_737943635.addTaint(taint);
        return varD1C8F801B36255D14CED2B3CFD68DC65_737943635;
        // ---------- Original Method ----------
        //return new BoundedMap(true, fromInclusive, INCLUSIVE, toExclusive, EXCLUSIVE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.668 -0400", hash_original_method = "FA312E74B0C04D741489E3323E0FFDFE", hash_generated_method = "1A3C2433AE73BBA9B355453E7E5340CA")
    public NavigableMap<K, V> headMap(K to, boolean inclusive) {
        addTaint(inclusive);
        addTaint(to.getTaint());
        Bound toBound = inclusive ? INCLUSIVE : EXCLUSIVE;
NavigableMap<K, V> varAA2AC7CD4326D49962BB154708AC9F4E_1687386387 =         new BoundedMap(true, null, NO_BOUND, to, toBound);
        varAA2AC7CD4326D49962BB154708AC9F4E_1687386387.addTaint(taint);
        return varAA2AC7CD4326D49962BB154708AC9F4E_1687386387;
        // ---------- Original Method ----------
        //Bound toBound = inclusive ? INCLUSIVE : EXCLUSIVE;
        //return new BoundedMap(true, null, NO_BOUND, to, toBound);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.669 -0400", hash_original_method = "CAC178CA3C39A0AC08FB27C63F9A635C", hash_generated_method = "5C55FEE694CC6519ECD45159ABE05827")
    public SortedMap<K, V> headMap(K toExclusive) {
        addTaint(toExclusive.getTaint());
SortedMap<K, V> varF36207FD347C9B8A75FD36AB250F2562_934660282 =         new BoundedMap(true, null, NO_BOUND, toExclusive, EXCLUSIVE);
        varF36207FD347C9B8A75FD36AB250F2562_934660282.addTaint(taint);
        return varF36207FD347C9B8A75FD36AB250F2562_934660282;
        // ---------- Original Method ----------
        //return new BoundedMap(true, null, NO_BOUND, toExclusive, EXCLUSIVE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.669 -0400", hash_original_method = "828BC950C20B857C189141DA99499F09", hash_generated_method = "F9193243852EB0E29775F3B20B08A5A5")
    public NavigableMap<K, V> tailMap(K from, boolean inclusive) {
        addTaint(inclusive);
        addTaint(from.getTaint());
        Bound fromBound = inclusive ? INCLUSIVE : EXCLUSIVE;
NavigableMap<K, V> var858AA4077810E3CAD30935021614C398_644838 =         new BoundedMap(true, from, fromBound, null, NO_BOUND);
        var858AA4077810E3CAD30935021614C398_644838.addTaint(taint);
        return var858AA4077810E3CAD30935021614C398_644838;
        // ---------- Original Method ----------
        //Bound fromBound = inclusive ? INCLUSIVE : EXCLUSIVE;
        //return new BoundedMap(true, from, fromBound, null, NO_BOUND);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.669 -0400", hash_original_method = "79B47D2E0956F27B23E0B18E5FD19D6A", hash_generated_method = "0B8D26884AB4700058922046FD67FCD8")
    public SortedMap<K, V> tailMap(K fromInclusive) {
        addTaint(fromInclusive.getTaint());
SortedMap<K, V> var238F6B1D3AB45506AAB3C8043B1183BA_1015090543 =         new BoundedMap(true, fromInclusive, INCLUSIVE, null, NO_BOUND);
        var238F6B1D3AB45506AAB3C8043B1183BA_1015090543.addTaint(taint);
        return var238F6B1D3AB45506AAB3C8043B1183BA_1015090543;
        // ---------- Original Method ----------
        //return new BoundedMap(true, fromInclusive, INCLUSIVE, null, NO_BOUND);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.670 -0400", hash_original_method = "5AD6A5A37D3C9366BEF11B75DC396D31", hash_generated_method = "97E3F04FBE4386C6F3735C5403EA9DBE")
    public NavigableMap<K, V> descendingMap() {
NavigableMap<K, V> var1294C8AE6093F28046A52F9C508EC87F_1602789549 =         new BoundedMap(false, null, NO_BOUND, null, NO_BOUND);
        var1294C8AE6093F28046A52F9C508EC87F_1602789549.addTaint(taint);
        return var1294C8AE6093F28046A52F9C508EC87F_1602789549;
        // ---------- Original Method ----------
        //return new BoundedMap(false, null, NO_BOUND, null, NO_BOUND);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.670 -0400", hash_original_method = "1207DF79B9959BCB242E95030D6177B0", hash_generated_method = "1C234AC3FBBA4F390A0C0C80D2610D62")
    public NavigableSet<K> descendingKeySet() {
NavigableSet<K> var147103AFA753373FDDCF430FA02E998F_2050558359 =         new BoundedMap(false, null, NO_BOUND, null, NO_BOUND).navigableKeySet();
        var147103AFA753373FDDCF430FA02E998F_2050558359.addTaint(taint);
        return var147103AFA753373FDDCF430FA02E998F_2050558359;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.671 -0400", hash_original_method = "BF81D129CE69F9BEB40CAD27F974F3C8", hash_generated_method = "913EA14829CB66885A0D07F3ADF68B3F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.671 -0400", hash_original_method = "4DE82E48A11AFCCB2DCFEAE704B1F475", hash_generated_method = "14915F7022307C7DC1B494E04297B335")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.672 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "8813BD57943FF9B7DFC4722D0BF25C24")

        Node<K, V> parent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.672 -0400", hash_original_field = "811882FECD5C7618D7099EBBD39EA254", hash_generated_field = "25F53C0BDEE77B7CD3BD6D035AA5E15F")

        Node<K, V> left;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.672 -0400", hash_original_field = "7C4F29407893C334A6CB7A87BF045C0D", hash_generated_field = "37DD2CA6D859801A463F8F880FD4F30D")

        Node<K, V> right;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.672 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "F780C5984CF24E477CB9559E91475987")

        K key;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.672 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "A7E8A049E4C72FD5713D3AFD6CBF7C08")

        V value;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.672 -0400", hash_original_field = "B435E227D5DD201E1768B2BCB2E0AA81", hash_generated_field = "CE84F1587D182C1F0A32D7CD44443A18")

        int height;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.673 -0400", hash_original_method = "62891C3DA898C4CAE2A216E3248BC6D0", hash_generated_method = "DE342B9B0B30391F4646033D3553010C")
          Node(Node<K, V> parent, K key) {
            this.parent = parent;
            this.key = key;
            this.height = 1;
            // ---------- Original Method ----------
            //this.parent = parent;
            //this.key = key;
            //this.height = 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.674 -0400", hash_original_method = "81E3C4E28B5839A0B87A03CA341E9BD1", hash_generated_method = "C15EAA9D6963E2CC077361A4017AF81E")
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
Node<K, V> varDC838461EE2FA0CA4C9BBB70A15456B0_745913502 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_745913502.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_745913502;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.674 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "4355C6D33F09B7D067BA0935FF872316")
        public K getKey() {
K var6A95247616A3A8B93CFF7783DABD08D4_948480325 =             key;
            var6A95247616A3A8B93CFF7783DABD08D4_948480325.addTaint(taint);
            return var6A95247616A3A8B93CFF7783DABD08D4_948480325;
            // ---------- Original Method ----------
            //return key;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.674 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "6A24D41406DC81549D96517B9D7DC83D")
        public V getValue() {
V varAF280DA2BC37D8BE783D8499160168DE_8933263 =             value;
            varAF280DA2BC37D8BE783D8499160168DE_8933263.addTaint(taint);
            return varAF280DA2BC37D8BE783D8499160168DE_8933263;
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.675 -0400", hash_original_method = "B73895AEE255DB24C138E57D2456050E", hash_generated_method = "6B59765A1EBDCA50FFB2F2A2CA1525DD")
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
V var8CDBD2181CBEF5C2129AFFA68C014D4A_900570700 =             oldValue;
            var8CDBD2181CBEF5C2129AFFA68C014D4A_900570700.addTaint(taint);
            return var8CDBD2181CBEF5C2129AFFA68C014D4A_900570700;
            // ---------- Original Method ----------
            //V oldValue = this.value;
            //this.value = value;
            //return oldValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.675 -0400", hash_original_method = "08E0671CAB8873A0A05165CE64371DB8", hash_generated_method = "81DDF962CB913B8D911EFAD965488656")
        @Override
        public boolean equals(Object o) {
            addTaint(o.getTaint());
    if(o instanceof Map.Entry)            
            {
                Map.Entry other = (Map.Entry) o;
                boolean var2F838DD1DBC9D4D4CEF8D80C17D3B446_366137413 = ((key == null ? other.getKey() == null : key.equals(other.getKey()))
                        && (value == null ? other.getValue() == null : value.equals(other.getValue())));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_601456481 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_601456481;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_2132622578 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_540338383 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_540338383;
            // ---------- Original Method ----------
            //if (o instanceof Map.Entry) {
                //Map.Entry other = (Map.Entry) o;
                //return (key == null ? other.getKey() == null : key.equals(other.getKey()))
                        //&& (value == null ? other.getValue() == null : value.equals(other.getValue()));
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.676 -0400", hash_original_method = "6416487D313DFCFD3052C01ADB883217", hash_generated_method = "EE26A1D39A23F8DECF11BDB988515B4E")
        @Override
        public int hashCode() {
            int var6426FEC1614D5FE74370608AA1AC68B8_31153553 = ((key == null ? 0 : key.hashCode())
                    ^ (value == null ? 0 : value.hashCode()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2073488774 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2073488774;
            // ---------- Original Method ----------
            //return (key == null ? 0 : key.hashCode())
                    //^ (value == null ? 0 : value.hashCode());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.676 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "75F4BEFBD167E7EF8AEE8A0F7B8CE3FE")
        @Override
        public String toString() {
String varFE698C13EFD83B87FAF2DC2AB0874271_2009112021 =             key + "=" + value;
            varFE698C13EFD83B87FAF2DC2AB0874271_2009112021.addTaint(taint);
            return varFE698C13EFD83B87FAF2DC2AB0874271_2009112021;
            // ---------- Original Method ----------
            //return key + "=" + value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.677 -0400", hash_original_method = "4A8921E3C940E88A3EF0004D6F064697", hash_generated_method = "B57414775C973FD5B69ED484D857F759")
         Node<K, V> next() {
    if(right != null)            
            {
Node<K, V> var49ECFE5B15D077B6A57AF2EF5E52D000_973846568 =                 right.first();
                var49ECFE5B15D077B6A57AF2EF5E52D000_973846568.addTaint(taint);
                return var49ECFE5B15D077B6A57AF2EF5E52D000_973846568;
            } //End block
            Node<K, V> node = this;
            Node<K, V> parent = node.parent;
            while
(parent != null)            
            {
    if(parent.left == node)                
                {
Node<K, V> var0F49909EA73F8892C338E4DCA6EB9906_1324052836 =                     parent;
                    var0F49909EA73F8892C338E4DCA6EB9906_1324052836.addTaint(taint);
                    return var0F49909EA73F8892C338E4DCA6EB9906_1324052836;
                } //End block
                node = parent;
                parent = node.parent;
            } //End block
Node<K, V> var540C13E9E156B687226421B24F2DF178_1354751491 =             null;
            var540C13E9E156B687226421B24F2DF178_1354751491.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1354751491;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.677 -0400", hash_original_method = "A5795D04699EE4D7981584600E0900FB", hash_generated_method = "6897A7C6D132DC28831225A4F19674AD")
        public Node<K, V> prev() {
    if(left != null)            
            {
Node<K, V> varF107747D6B949A969681DC4598F3BB98_900205747 =                 left.last();
                varF107747D6B949A969681DC4598F3BB98_900205747.addTaint(taint);
                return varF107747D6B949A969681DC4598F3BB98_900205747;
            } //End block
            Node<K, V> node = this;
            Node<K, V> parent = node.parent;
            while
(parent != null)            
            {
    if(parent.right == node)                
                {
Node<K, V> var0F49909EA73F8892C338E4DCA6EB9906_1278846361 =                     parent;
                    var0F49909EA73F8892C338E4DCA6EB9906_1278846361.addTaint(taint);
                    return var0F49909EA73F8892C338E4DCA6EB9906_1278846361;
                } //End block
                node = parent;
                parent = node.parent;
            } //End block
Node<K, V> var540C13E9E156B687226421B24F2DF178_110769481 =             null;
            var540C13E9E156B687226421B24F2DF178_110769481.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_110769481;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.678 -0400", hash_original_method = "4F7C0267C30B98E081694FF304478F8A", hash_generated_method = "783C8BC1EF0883758EC3CED2F6810417")
        public Node<K, V> first() {
            Node<K, V> node = this;
            Node<K, V> child = node.left;
            while
(child != null)            
            {
                node = child;
                child = node.left;
            } //End block
Node<K, V> var1924C94B76524D1C3D7310EA17B0EF94_589852097 =             node;
            var1924C94B76524D1C3D7310EA17B0EF94_589852097.addTaint(taint);
            return var1924C94B76524D1C3D7310EA17B0EF94_589852097;
            // ---------- Original Method ----------
            //Node<K, V> node = this;
            //Node<K, V> child = node.left;
            //while (child != null) {
                //node = child;
                //child = node.left;
            //}
            //return node;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.678 -0400", hash_original_method = "E5BF79B4B513B5631F4BBC9604CA3FC9", hash_generated_method = "80B8EAE9E9BE5C1EC57F5AA6F475F13A")
        public Node<K, V> last() {
            Node<K, V> node = this;
            Node<K, V> child = node.right;
            while
(child != null)            
            {
                node = child;
                child = node.right;
            } //End block
Node<K, V> var1924C94B76524D1C3D7310EA17B0EF94_2140277366 =             node;
            var1924C94B76524D1C3D7310EA17B0EF94_2140277366.addTaint(taint);
            return var1924C94B76524D1C3D7310EA17B0EF94_2140277366;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.679 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "4E383A6783C389E295874CEC0140061D")

        protected Node<K, V> next;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.679 -0400", hash_original_field = "98BD1C45684CF587AC2347A92DD7BB51", hash_generated_field = "A9411E67538F8DD40B9344B2A6DD22CB")

        protected Node<K, V> last;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.679 -0400", hash_original_field = "587E194BCD330DA9D6CB9DB53EA8709A", hash_generated_field = "AB0DDF01BBCC99511DA5FB1867F9AF26")

        protected int expectedModCount = modCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.679 -0400", hash_original_method = "1934503C2038D80E73C2C0A3DE09B0C3", hash_generated_method = "8E0327A33AFF8D45EE12C60F2FAE7675")
          MapIterator(Node<K, V> next) {
            this.next = next;
            // ---------- Original Method ----------
            //this.next = next;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.679 -0400", hash_original_method = "5C1B7B0DA20667590A4D5C5559468A28", hash_generated_method = "5152585FEA108CC3B48404ED88D6D5F2")
        public boolean hasNext() {
            boolean var1D0482B34E42F032728DF2F52373E7A2_1801958362 = (next != null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_232180818 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_232180818;
            // ---------- Original Method ----------
            //return next != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.680 -0400", hash_original_method = "85C80BB4AD318538DB8131E722149B15", hash_generated_method = "2C796BECC05E6001DA4F208E4EB4DFA6")
        protected Node<K, V> stepForward() {
    if(next == null)            
            {
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_174197263 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_174197263.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_174197263;
            } //End block
    if(modCount != expectedModCount)            
            {
                ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_1506408954 = new ConcurrentModificationException();
                var779BA6969BD29E5F2D0448781C543B65_1506408954.addTaint(taint);
                throw var779BA6969BD29E5F2D0448781C543B65_1506408954;
            } //End block
            last = next;
            next = next.next();
Node<K, V> var3D331EA760A7BCD3BF7E380A6C79C638_1579585393 =             last;
            var3D331EA760A7BCD3BF7E380A6C79C638_1579585393.addTaint(taint);
            return var3D331EA760A7BCD3BF7E380A6C79C638_1579585393;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.681 -0400", hash_original_method = "A54C5D61E9DBD724A09A36F78C304124", hash_generated_method = "662D906C526FE6839198B817E76BF8A8")
        protected Node<K, V> stepBackward() {
    if(next == null)            
            {
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_1686638614 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_1686638614.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_1686638614;
            } //End block
    if(modCount != expectedModCount)            
            {
                ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_2042644627 = new ConcurrentModificationException();
                var779BA6969BD29E5F2D0448781C543B65_2042644627.addTaint(taint);
                throw var779BA6969BD29E5F2D0448781C543B65_2042644627;
            } //End block
            last = next;
            next = next.prev();
Node<K, V> var3D331EA760A7BCD3BF7E380A6C79C638_405769857 =             last;
            var3D331EA760A7BCD3BF7E380A6C79C638_405769857.addTaint(taint);
            return var3D331EA760A7BCD3BF7E380A6C79C638_405769857;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.681 -0400", hash_original_method = "36CB2F7F3A40368DEE67850156136E6A", hash_generated_method = "ADA325F616FF9F7CF242174280269418")
        public void remove() {
    if(last == null)            
            {
                IllegalStateException varC311A989A119B96A6232C22ABFE87C25_174490884 = new IllegalStateException();
                varC311A989A119B96A6232C22ABFE87C25_174490884.addTaint(taint);
                throw varC311A989A119B96A6232C22ABFE87C25_174490884;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.681 -0400", hash_original_method = "AA90B2AD56C6E037D76F6D8ACC9327A5", hash_generated_method = "AA90B2AD56C6E037D76F6D8ACC9327A5")
        public EntrySet ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.682 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "DDD54B7EAA6366A6AEFA0AE4831DE888")
        @Override
        public int size() {
            int varF7BD60B75B29D79B660A2859395C1A24_241857664 = (size);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_496534304 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_496534304;
            // ---------- Original Method ----------
            //return size;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.682 -0400", hash_original_method = "B4D4FA13F54A295418FF58C47A14DDE9", hash_generated_method = "3352AE6E59439E34665A6D7183A93662")
        @Override
        public Iterator<Entry<K, V>> iterator() {
Iterator<Entry<K, V>> var622BFC9B0FC71AB66EF04995E784B17E_1269676996 =             new MapIterator<Entry<K, V>>(root == null ? null : root.first()) {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.682 -0400", hash_original_method = "86F000434530E8D6B0755FFE9A16C5F8", hash_generated_method = "ABEEFE29E4773397BACC7D11088A9411")
            public Entry<K, V> next() {
Entry<K, V> varBEFE63D427BFF5E467D509E70ABD58CE_1006813479 =                 stepForward();
                varBEFE63D427BFF5E467D509E70ABD58CE_1006813479.addTaint(taint);
                return varBEFE63D427BFF5E467D509E70ABD58CE_1006813479;
                // ---------- Original Method ----------
                //return stepForward();
            }
};
            var622BFC9B0FC71AB66EF04995E784B17E_1269676996.addTaint(taint);
            return var622BFC9B0FC71AB66EF04995E784B17E_1269676996;
            // ---------- Original Method ----------
            //return new MapIterator<Entry<K, V>>(root == null ? null : root.first()) {
                //public Entry<K, V> next() {
                    //return stepForward();
                //}
            //};
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.683 -0400", hash_original_method = "AAE5A29808B951CC80BD03F648B6A63A", hash_generated_method = "3DB9A30590143F659A048EC36685EF6B")
        @Override
        public boolean contains(Object o) {
            addTaint(o.getTaint());
            boolean var9956AA7309D9CCD50D7FC35B407023ED_1257566462 = (o instanceof Entry && findByEntry((Entry<?, ?>) o) != null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1107297444 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1107297444;
            // ---------- Original Method ----------
            //return o instanceof Entry && findByEntry((Entry<?, ?>) o) != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.683 -0400", hash_original_method = "50402191313F22EA9CF206F14CC9A5A4", hash_generated_method = "29216B6A5C95574E9933491F8D48397A")
        @Override
        public boolean remove(Object o) {
            addTaint(o.getTaint());
    if(!(o instanceof Entry))            
            {
                boolean var68934A3E9455FA72420237EB05902327_377784527 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1628138162 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1628138162;
            } //End block
            Node<K, V> node = findByEntry((Entry<?, ?>) o);
    if(node == null)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1495161333 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_873229524 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_873229524;
            } //End block
            removeInternal(node);
            boolean varB326B5062B2F0E69046810717534CB09_237870516 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1826439487 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1826439487;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.684 -0400", hash_original_method = "1CC2A082C181027407DFF573950B6D85", hash_generated_method = "E132377B1C3D8FD49066BD79A34C72A8")
        @Override
        public void clear() {
            TreeMap.this.clear();
            // ---------- Original Method ----------
            //TreeMap.this.clear();
        }

        
    }


    
    class KeySet extends AbstractSet<K> implements NavigableSet<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.684 -0400", hash_original_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF", hash_generated_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF")
        public KeySet ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.684 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "B801BEB07EE42D592579AD36747D5EA9")
        @Override
        public int size() {
            int varF7BD60B75B29D79B660A2859395C1A24_2003436943 = (size);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_414231715 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_414231715;
            // ---------- Original Method ----------
            //return size;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.685 -0400", hash_original_method = "7A518595D7BAAD9E696AF11FE92FFDBE", hash_generated_method = "E71396284137C5B509AD92F2EBD2AAD5")
        @Override
        public Iterator<K> iterator() {
Iterator<K> varC6C6F031377E271DFB1816B61A8EA88F_915028328 =             new MapIterator<K>(root == null ? null : root.first()) {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.685 -0400", hash_original_method = "E581E07EB6E816B7B0F53BDF6AE52418", hash_generated_method = "8F09D13CF0A3CEB190660EC8E60D9D23")
            public K next() {
K varED589F5CB2626464AC74D486990A7A15_126425715 =                 stepForward().key;
                varED589F5CB2626464AC74D486990A7A15_126425715.addTaint(taint);
                return varED589F5CB2626464AC74D486990A7A15_126425715;
                // ---------- Original Method ----------
                //return stepForward().key;
            }
};
            varC6C6F031377E271DFB1816B61A8EA88F_915028328.addTaint(taint);
            return varC6C6F031377E271DFB1816B61A8EA88F_915028328;
            // ---------- Original Method ----------
            //return new MapIterator<K>(root == null ? null : root.first()) {
                //public K next() {
                    //return stepForward().key;
                //}
            //};
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.686 -0400", hash_original_method = "C8D968F3C5FE84BB3D2A53544A3D4B19", hash_generated_method = "71686ACBA4491CFF48A16EBCB275466B")
        public Iterator<K> descendingIterator() {
Iterator<K> var684ADF17601F4E6DD3748CC4B25E0E8D_52934725 =             new MapIterator<K>(root == null ? null : root.last()) {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.685 -0400", hash_original_method = "30CD89883F8CEF7ECE49A6E9F42F1507", hash_generated_method = "B7B3C6CB45707B2B4C4B1A4F883EE3C3")
            public K next() {
K varFE3C1A21095894F113C168C20974D3B7_1604747499 =                 stepBackward().key;
                varFE3C1A21095894F113C168C20974D3B7_1604747499.addTaint(taint);
                return varFE3C1A21095894F113C168C20974D3B7_1604747499;
                // ---------- Original Method ----------
                //return stepBackward().key;
            }
};
            var684ADF17601F4E6DD3748CC4B25E0E8D_52934725.addTaint(taint);
            return var684ADF17601F4E6DD3748CC4B25E0E8D_52934725;
            // ---------- Original Method ----------
            //return new MapIterator<K>(root == null ? null : root.last()) {
                //public K next() {
                    //return stepBackward().key;
                //}
            //};
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.686 -0400", hash_original_method = "55474555B71DFC8666AC2B6E4F0261A5", hash_generated_method = "D98EE96A8FCCC6F51FB247B27D369A7F")
        @Override
        public boolean contains(Object o) {
            addTaint(o.getTaint());
            boolean var6CE6D88A4041ABB2C763C00DFE3D40ED_509225480 = (containsKey(o));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1439796590 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1439796590;
            // ---------- Original Method ----------
            //return containsKey(o);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.686 -0400", hash_original_method = "174345B10BAB0003712B28F94B9BEA53", hash_generated_method = "2E06B5B7AE565A129EE32FBFAA8D52CE")
        @Override
        public boolean remove(Object key) {
            addTaint(key.getTaint());
            boolean var1C50BB7C86DAF131C5CF146B5D063A21_145819696 = (removeInternalByKey(key) != null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1769069490 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1769069490;
            // ---------- Original Method ----------
            //return removeInternalByKey(key) != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.687 -0400", hash_original_method = "1CC2A082C181027407DFF573950B6D85", hash_generated_method = "E132377B1C3D8FD49066BD79A34C72A8")
        @Override
        public void clear() {
            TreeMap.this.clear();
            // ---------- Original Method ----------
            //TreeMap.this.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.687 -0400", hash_original_method = "E1A1305471DEE1FE749764F6E03BE3A0", hash_generated_method = "95B6E5881C7EFBB95E615DD6F1706004")
        public Comparator<? super K> comparator() {
Comparator<? super K> varEE9621AAB15522B49DAC63CE835E2941_2140837860 =             TreeMap.this.comparator();
            varEE9621AAB15522B49DAC63CE835E2941_2140837860.addTaint(taint);
            return varEE9621AAB15522B49DAC63CE835E2941_2140837860;
            // ---------- Original Method ----------
            //return TreeMap.this.comparator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.687 -0400", hash_original_method = "3067DEE01FBBBFD061436C7D4561F434", hash_generated_method = "ED0D60309B0AC7EF991CC011D77D0439")
        public K first() {
K var59F2D49FC0979EFEDD893E9689C2AA6B_120792461 =             firstKey();
            var59F2D49FC0979EFEDD893E9689C2AA6B_120792461.addTaint(taint);
            return var59F2D49FC0979EFEDD893E9689C2AA6B_120792461;
            // ---------- Original Method ----------
            //return firstKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.687 -0400", hash_original_method = "39C87F788E647BCD3FB86FFF34D7EF10", hash_generated_method = "038FB8E5336E85BEE2B3682E4C02B867")
        public K last() {
K var9DAA79F4D4E0401E91D6AAF423D49398_50290161 =             lastKey();
            var9DAA79F4D4E0401E91D6AAF423D49398_50290161.addTaint(taint);
            return var9DAA79F4D4E0401E91D6AAF423D49398_50290161;
            // ---------- Original Method ----------
            //return lastKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.688 -0400", hash_original_method = "5CFE05BF706A06BBB501067306F1B9ED", hash_generated_method = "1FE8CC96F8E77CA5BDB8EF10F9C60DE3")
        public K lower(K key) {
            addTaint(key.getTaint());
K var2B86BD115FCBD0ED4D0B4CB097A2C388_303336512 =             lowerKey(key);
            var2B86BD115FCBD0ED4D0B4CB097A2C388_303336512.addTaint(taint);
            return var2B86BD115FCBD0ED4D0B4CB097A2C388_303336512;
            // ---------- Original Method ----------
            //return lowerKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.688 -0400", hash_original_method = "10BABB7BB2E837824A13AAE89EE7EC6F", hash_generated_method = "BD53A1B8CDCF2178BB05EB9E50A12DAC")
        public K floor(K key) {
            addTaint(key.getTaint());
K var350534B70A929DCE92BCA350B3F7DA8E_1924189919 =             floorKey(key);
            var350534B70A929DCE92BCA350B3F7DA8E_1924189919.addTaint(taint);
            return var350534B70A929DCE92BCA350B3F7DA8E_1924189919;
            // ---------- Original Method ----------
            //return floorKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.688 -0400", hash_original_method = "2AD4706A6D818B709A1E2CA64B48B4B9", hash_generated_method = "C049622E68DD98501A19DE0EB667621A")
        public K ceiling(K key) {
            addTaint(key.getTaint());
K varC33643BEB47C1CC66B2C2CDB25527B59_1450660578 =             ceilingKey(key);
            varC33643BEB47C1CC66B2C2CDB25527B59_1450660578.addTaint(taint);
            return varC33643BEB47C1CC66B2C2CDB25527B59_1450660578;
            // ---------- Original Method ----------
            //return ceilingKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.689 -0400", hash_original_method = "8CC63649234BFC57DB10A2387AE34DD6", hash_generated_method = "276DE89A23BB5D790A7379748794BC9C")
        public K higher(K key) {
            addTaint(key.getTaint());
K var75CF48C4839A7AAF074C16D584CD6253_1519561961 =             higherKey(key);
            var75CF48C4839A7AAF074C16D584CD6253_1519561961.addTaint(taint);
            return var75CF48C4839A7AAF074C16D584CD6253_1519561961;
            // ---------- Original Method ----------
            //return higherKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.689 -0400", hash_original_method = "0E3C9584B722234668005FBA598A1EC0", hash_generated_method = "ADE001499502CE39F72231FA2DDDA2B9")
        public K pollFirst() {
            Entry<K, V> entry = internalPollFirstEntry();
K var15DE16EBAA69B0A4EA051FB5DEC39C10_1299542359 =             entry != null ? entry.getKey() : null;
            var15DE16EBAA69B0A4EA051FB5DEC39C10_1299542359.addTaint(taint);
            return var15DE16EBAA69B0A4EA051FB5DEC39C10_1299542359;
            // ---------- Original Method ----------
            //Entry<K, V> entry = internalPollFirstEntry();
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.689 -0400", hash_original_method = "ABD0A1CFCFA4D3D1F242F2375F97811C", hash_generated_method = "6565C248A2994F14419AB0104E78B7B4")
        public K pollLast() {
            Entry<K, V> entry = internalPollLastEntry();
K var15DE16EBAA69B0A4EA051FB5DEC39C10_585688846 =             entry != null ? entry.getKey() : null;
            var15DE16EBAA69B0A4EA051FB5DEC39C10_585688846.addTaint(taint);
            return var15DE16EBAA69B0A4EA051FB5DEC39C10_585688846;
            // ---------- Original Method ----------
            //Entry<K, V> entry = internalPollLastEntry();
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.690 -0400", hash_original_method = "21828DA90728B75367EF3BEE7D62C832", hash_generated_method = "9F4D2B16BD53C44450248D2503D91369")
        public NavigableSet<K> subSet(K from, boolean fromInclusive, K to, boolean toInclusive) {
            addTaint(toInclusive);
            addTaint(to.getTaint());
            addTaint(fromInclusive);
            addTaint(from.getTaint());
NavigableSet<K> var1E006BA33691F75FD5C590518669F7CF_1573228529 =             TreeMap.this.subMap(from, fromInclusive, to, toInclusive).navigableKeySet();
            var1E006BA33691F75FD5C590518669F7CF_1573228529.addTaint(taint);
            return var1E006BA33691F75FD5C590518669F7CF_1573228529;
            // ---------- Original Method ----------
            //return TreeMap.this.subMap(from, fromInclusive, to, toInclusive).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.690 -0400", hash_original_method = "B37C6130D4B0113815E317EEB111D1E9", hash_generated_method = "989BEA879A538E5C144017A29B887C05")
        public SortedSet<K> subSet(K fromInclusive, K toExclusive) {
            addTaint(toExclusive.getTaint());
            addTaint(fromInclusive.getTaint());
SortedSet<K> varAEEB9B76D84A9A3D1311D62B7C8E400F_1724408701 =             TreeMap.this.subMap(fromInclusive, true, toExclusive, false).navigableKeySet();
            varAEEB9B76D84A9A3D1311D62B7C8E400F_1724408701.addTaint(taint);
            return varAEEB9B76D84A9A3D1311D62B7C8E400F_1724408701;
            // ---------- Original Method ----------
            //return TreeMap.this.subMap(fromInclusive, true, toExclusive, false).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.690 -0400", hash_original_method = "15C518A93EE21ED6E81237BD492369B4", hash_generated_method = "68B49D1BC46A1D0911F59C3FB3414954")
        public NavigableSet<K> headSet(K to, boolean inclusive) {
            addTaint(inclusive);
            addTaint(to.getTaint());
NavigableSet<K> var2AC6FCA4CD759F1D6886D1E522029C64_866814581 =             TreeMap.this.headMap(to, inclusive).navigableKeySet();
            var2AC6FCA4CD759F1D6886D1E522029C64_866814581.addTaint(taint);
            return var2AC6FCA4CD759F1D6886D1E522029C64_866814581;
            // ---------- Original Method ----------
            //return TreeMap.this.headMap(to, inclusive).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.691 -0400", hash_original_method = "1E1BD4D122D1F75D80BDC2474EF32137", hash_generated_method = "27B59EC175E1E73A7EC670B912B2C755")
        public SortedSet<K> headSet(K toExclusive) {
            addTaint(toExclusive.getTaint());
SortedSet<K> var9CABB3B743BD7889D426F02DACBBE99F_2134541373 =             TreeMap.this.headMap(toExclusive, false).navigableKeySet();
            var9CABB3B743BD7889D426F02DACBBE99F_2134541373.addTaint(taint);
            return var9CABB3B743BD7889D426F02DACBBE99F_2134541373;
            // ---------- Original Method ----------
            //return TreeMap.this.headMap(toExclusive, false).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.691 -0400", hash_original_method = "3007AE414049BD587DD344AEC05F7630", hash_generated_method = "2C2D3EC782A172364F2CE27B333898FD")
        public NavigableSet<K> tailSet(K from, boolean inclusive) {
            addTaint(inclusive);
            addTaint(from.getTaint());
NavigableSet<K> var119889AEAA5B3E18E2858897784D1CE7_449995205 =             TreeMap.this.tailMap(from, inclusive).navigableKeySet();
            var119889AEAA5B3E18E2858897784D1CE7_449995205.addTaint(taint);
            return var119889AEAA5B3E18E2858897784D1CE7_449995205;
            // ---------- Original Method ----------
            //return TreeMap.this.tailMap(from, inclusive).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.691 -0400", hash_original_method = "4DA58A152F26E7271643C0314BDDDB69", hash_generated_method = "4C13FBA1899B0FC7F4764BFB3638F7DC")
        public SortedSet<K> tailSet(K fromInclusive) {
            addTaint(fromInclusive.getTaint());
SortedSet<K> varFF4E3FFD47F6151862E3275C1D99A159_1846250949 =             TreeMap.this.tailMap(fromInclusive, true).navigableKeySet();
            varFF4E3FFD47F6151862E3275C1D99A159_1846250949.addTaint(taint);
            return varFF4E3FFD47F6151862E3275C1D99A159_1846250949;
            // ---------- Original Method ----------
            //return TreeMap.this.tailMap(fromInclusive, true).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.692 -0400", hash_original_method = "1704B63D396CC7A2877008D7CE821A20", hash_generated_method = "793332CA84FD615D4436AB5C90D52497")
        public NavigableSet<K> descendingSet() {
NavigableSet<K> var147103AFA753373FDDCF430FA02E998F_2090869408 =             new BoundedMap(false, null, NO_BOUND, null, NO_BOUND).navigableKeySet();
            var147103AFA753373FDDCF430FA02E998F_2090869408.addTaint(taint);
            return var147103AFA753373FDDCF430FA02E998F_2090869408;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.692 -0400", hash_original_field = "9C9AB624360885FCF93B7643C93B6748", hash_generated_field = "BC70714ECDFF7490EBA777F7B93EF439")

        private transient boolean ascending;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.692 -0400", hash_original_field = "D98A07F84921B24EE30F86FD8CD85C3C", hash_generated_field = "EEAE90D76D5F301C983CBE52CC99E066")

        private transient K from;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.692 -0400", hash_original_field = "8632C30284D52AAEE2237CDB621740BD", hash_generated_field = "8ED035FAE673A429CD23C9E2219BCCAB")

        private transient Bound fromBound;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.693 -0400", hash_original_field = "01B6E20344B68835C5ED1DDEDF20D531", hash_generated_field = "61687A1A941C5D04AF6012AAB46409E8")

        private transient K to;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.693 -0400", hash_original_field = "7CA17358064D231F30EBE9DEA6953FC3", hash_generated_field = "AA1B7E444C65D0CB4426137E2FCF44C2")

        private transient Bound toBound;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.693 -0400", hash_original_field = "D4E06C98DBA5A687CB6C836BF538EC81", hash_generated_field = "71A92C43EAA002A1D21DF22BACB230F5")

        private transient BoundedEntrySet entrySet;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.693 -0400", hash_original_field = "3E8ABCE844B6A8A95397486A3899B536", hash_generated_field = "8C5699591CBD5CFF428C3B6D5369D846")

        private transient BoundedKeySet keySet;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.694 -0400", hash_original_method = "EAF770A918D33B7B0B98CAAC01791FDE", hash_generated_method = "B82F70935DB576067DCB5CE78892E56D")
          BoundedMap(boolean ascending, K from, Bound fromBound, K to, Bound toBound) {
    if(fromBound != NO_BOUND && toBound != NO_BOUND)            
            {
    if(comparator.compare(from, to) > 0)                
                {
                    IllegalArgumentException var8DDE4F833C7F6DD25182F12F52D69FD0_1614869061 = new IllegalArgumentException(from + " > " + to);
                    var8DDE4F833C7F6DD25182F12F52D69FD0_1614869061.addTaint(taint);
                    throw var8DDE4F833C7F6DD25182F12F52D69FD0_1614869061;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.695 -0400", hash_original_method = "0165FF9BE82C19127CA9F7A8EFBCC5F6", hash_generated_method = "97686CD27C2F69AC9FC997C6E3F9A25B")
        @Override
        public int size() {
            int var26AE06B895E339433E4D6CD04CD66FE7_674062512 = (count(entrySet().iterator()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_944005431 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_944005431;
            // ---------- Original Method ----------
            //return count(entrySet().iterator());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.695 -0400", hash_original_method = "25ACC65054E604EE8ADED763702CFAA7", hash_generated_method = "7D49055009A3D111F7687DF72C8E3D2E")
        @Override
        public boolean isEmpty() {
            boolean var24822569AE9F7F715FDC0563401A6591_222596769 = (endpoint(true) == null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_485432533 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_485432533;
            // ---------- Original Method ----------
            //return endpoint(true) == null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.695 -0400", hash_original_method = "00AB887CF1625BBE035D7C27E115F8F5", hash_generated_method = "67E76428BC9019091EDFFA54E4740831")
        @Override
        public V get(Object key) {
            addTaint(key.getTaint());
V var0A832C0727F42F6014F929FB0FC378A4_453144385 =             isInBounds(key) ? TreeMap.this.get(key) : null;
            var0A832C0727F42F6014F929FB0FC378A4_453144385.addTaint(taint);
            return var0A832C0727F42F6014F929FB0FC378A4_453144385;
            // ---------- Original Method ----------
            //return isInBounds(key) ? TreeMap.this.get(key) : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.696 -0400", hash_original_method = "97933E3E15C41B402232AC9CC0472CF2", hash_generated_method = "A5FD6454DC02420CDC38DA3FA0B9FF5B")
        @Override
        public boolean containsKey(Object key) {
            addTaint(key.getTaint());
            boolean varBFF824D91838D02D5EC29B8CCE262926_1662416247 = (isInBounds(key) && TreeMap.this.containsKey(key));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_194347328 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_194347328;
            // ---------- Original Method ----------
            //return isInBounds(key) && TreeMap.this.containsKey(key);
        }

        
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.703 -0400", hash_original_method = "FD860E76286147E5825948B59334B12A", hash_generated_method = "8E7F59670EDE5B714D12AB0E3E0C1A28")
        @Override
        public V remove(Object key) {
            addTaint(key.getTaint());
V var2D26847273D18E896AF5F18CD64B937E_235700661 =             isInBounds(key) ? TreeMap.this.remove(key) : null;
            var2D26847273D18E896AF5F18CD64B937E_235700661.addTaint(taint);
            return var2D26847273D18E896AF5F18CD64B937E_235700661;
            // ---------- Original Method ----------
            //return isInBounds(key) ? TreeMap.this.remove(key) : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.703 -0400", hash_original_method = "CBDDB4BBE438A9DB233DEA58A1C969FA", hash_generated_method = "55257C0A30B14A5DC8A4EA6D7C0CD004")
        @SuppressWarnings("unchecked")
        private boolean isInBounds(Object key) {
            addTaint(key.getTaint());
            boolean varC2E8E4B0821BECC73AF223B4F22DE24B_759604239 = (isInBounds((K) key, fromBound, toBound));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_894080008 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_894080008;
            // ---------- Original Method ----------
            //return isInBounds((K) key, fromBound, toBound);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.704 -0400", hash_original_method = "692642A6AE210FFE582C89EC91302D79", hash_generated_method = "4D0A391AE8FBB3E3345D0367C08F00D1")
        private boolean isInBounds(K key, Bound fromBound, Bound toBound) {
            addTaint(toBound.getTaint());
            addTaint(fromBound.getTaint());
            addTaint(key.getTaint());
    if(fromBound == INCLUSIVE)            
            {
    if(comparator.compare(key, from) < 0)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1862365070 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1905021947 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1905021947;
                } //End block
            } //End block
            else
    if(fromBound == EXCLUSIVE)            
            {
    if(comparator.compare(key, from) <= 0)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_291220155 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_93581379 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_93581379;
                } //End block
            } //End block
    if(toBound == INCLUSIVE)            
            {
    if(comparator.compare(key, to) > 0)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_733680688 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_243018512 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_243018512;
                } //End block
            } //End block
            else
    if(toBound == EXCLUSIVE)            
            {
    if(comparator.compare(key, to) >= 0)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1359531014 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1667289849 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1667289849;
                } //End block
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1259294978 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2005243264 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2005243264;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.705 -0400", hash_original_method = "CAAC4C1A33B13586569CF07F541A55C7", hash_generated_method = "253387163A5C71F64105F827C64672B6")
        private Node<K, V> bound(Node<K, V> node, Bound fromBound, Bound toBound) {
            addTaint(toBound.getTaint());
            addTaint(fromBound.getTaint());
            addTaint(node.getTaint());
Node<K, V> varBCBECEA5E483CDB70086F19B700D6F49_245491095 =             node != null && isInBounds(node.getKey(), fromBound, toBound) ? node : null;
            varBCBECEA5E483CDB70086F19B700D6F49_245491095.addTaint(taint);
            return varBCBECEA5E483CDB70086F19B700D6F49_245491095;
            // ---------- Original Method ----------
            //return node != null && isInBounds(node.getKey(), fromBound, toBound) ? node : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.705 -0400", hash_original_method = "692355E3656C196457301F91A19D5157", hash_generated_method = "17FD0994DF3D214AAA16F2CFB626A3AC")
        public Entry<K, V> firstEntry() {
Entry<K, V> var0A56181019B755400DBCE1C237EBF90C_1686973441 =             immutableCopy(endpoint(true));
            var0A56181019B755400DBCE1C237EBF90C_1686973441.addTaint(taint);
            return var0A56181019B755400DBCE1C237EBF90C_1686973441;
            // ---------- Original Method ----------
            //return immutableCopy(endpoint(true));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.705 -0400", hash_original_method = "3800FF04B85DB50D775ADF76A89AF0FD", hash_generated_method = "5289AF09044615D897F01977BF9FAE69")
        public Entry<K, V> pollFirstEntry() {
            Node<K, V> result = endpoint(true);
    if(result != null)            
            {
                removeInternal(result);
            } //End block
Entry<K, V> var6B63F11358115BF1F4CDE6AD6F400177_1573095601 =             immutableCopy(result);
            var6B63F11358115BF1F4CDE6AD6F400177_1573095601.addTaint(taint);
            return var6B63F11358115BF1F4CDE6AD6F400177_1573095601;
            // ---------- Original Method ----------
            //Node<K, V> result = endpoint(true);
            //if (result != null) {
                //removeInternal(result);
            //}
            //return immutableCopy(result);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.706 -0400", hash_original_method = "1DE5152AF86A2FB092CD0802BF299C85", hash_generated_method = "18E1EE5C1F9B29537C5460E295E96D7E")
        public K firstKey() {
            Entry<K, V> entry = endpoint(true);
    if(entry == null)            
            {
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_1756053558 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_1756053558.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_1756053558;
            } //End block
K varE5CD6225CB16CF7AEFEC373E217B052C_1638260490 =             entry.getKey();
            varE5CD6225CB16CF7AEFEC373E217B052C_1638260490.addTaint(taint);
            return varE5CD6225CB16CF7AEFEC373E217B052C_1638260490;
            // ---------- Original Method ----------
            //Entry<K, V> entry = endpoint(true);
            //if (entry == null) {
                //throw new NoSuchElementException();
            //}
            //return entry.getKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.706 -0400", hash_original_method = "3349B358C55B472B88F39549996E074C", hash_generated_method = "223D5A3E10F585D3DFBA1C99C865182C")
        public Entry<K, V> lastEntry() {
Entry<K, V> varDB864FBFECFDD7EF32688DE10742D92E_1372554135 =             immutableCopy(endpoint(false));
            varDB864FBFECFDD7EF32688DE10742D92E_1372554135.addTaint(taint);
            return varDB864FBFECFDD7EF32688DE10742D92E_1372554135;
            // ---------- Original Method ----------
            //return immutableCopy(endpoint(false));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.706 -0400", hash_original_method = "4E391E55891B2D72162CA8FBBFDB8088", hash_generated_method = "69AC3B291282CC4F39C990294E79EA91")
        public Entry<K, V> pollLastEntry() {
            Node<K, V> result = endpoint(false);
    if(result != null)            
            {
                removeInternal(result);
            } //End block
Entry<K, V> var6B63F11358115BF1F4CDE6AD6F400177_393513853 =             immutableCopy(result);
            var6B63F11358115BF1F4CDE6AD6F400177_393513853.addTaint(taint);
            return var6B63F11358115BF1F4CDE6AD6F400177_393513853;
            // ---------- Original Method ----------
            //Node<K, V> result = endpoint(false);
            //if (result != null) {
                //removeInternal(result);
            //}
            //return immutableCopy(result);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.707 -0400", hash_original_method = "394B9DCC52DC405017E9FB6F95D12436", hash_generated_method = "545BDB7278C0B447EE850B53F91B3168")
        public K lastKey() {
            Entry<K, V> entry = endpoint(false);
    if(entry == null)            
            {
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_504377802 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_504377802.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_504377802;
            } //End block
K varE5CD6225CB16CF7AEFEC373E217B052C_1576042881 =             entry.getKey();
            varE5CD6225CB16CF7AEFEC373E217B052C_1576042881.addTaint(taint);
            return varE5CD6225CB16CF7AEFEC373E217B052C_1576042881;
            // ---------- Original Method ----------
            //Entry<K, V> entry = endpoint(false);
            //if (entry == null) {
                //throw new NoSuchElementException();
            //}
            //return entry.getKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.708 -0400", hash_original_method = "83D48F5C9D4926E1668CDBC652A8BB3D", hash_generated_method = "3B72F5A58ED70AF7D0BB41897ECA183E")
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
                AssertionError varA81442E36297E737EB908877E58260E8_520222041 = new AssertionError();
                varA81442E36297E737EB908877E58260E8_520222041.addTaint(taint);
                throw varA81442E36297E737EB908877E58260E8_520222041;
}Node<K, V> varEAB025B2B90A78721FD3A719622C9FBE_2096893339 =                 bound(node, NO_BOUND, toBound);
                varEAB025B2B90A78721FD3A719622C9FBE_2096893339.addTaint(taint);
                return varEAB025B2B90A78721FD3A719622C9FBE_2096893339;
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
                AssertionError varA81442E36297E737EB908877E58260E8_500675214 = new AssertionError();
                varA81442E36297E737EB908877E58260E8_500675214.addTaint(taint);
                throw varA81442E36297E737EB908877E58260E8_500675214;
}Node<K, V> varD0FBEC1C8500F0F6B11CE96CBEBC0942_1130348095 =                 bound(node, fromBound, NO_BOUND);
                varD0FBEC1C8500F0F6B11CE96CBEBC0942_1130348095.addTaint(taint);
                return varD0FBEC1C8500F0F6B11CE96CBEBC0942_1130348095;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.709 -0400", hash_original_method = "4CDC04225A960E79B8311D7465BD3125", hash_generated_method = "DCC3806923B93E3CE3F4074539F9D406")
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
Entry<K, V> var5E7C8E05686CD046B5E518E1A524CD5B_817990290 =             bound(find(key, relation), fromBoundForCheck, toBoundForCheck);
            var5E7C8E05686CD046B5E518E1A524CD5B_817990290.addTaint(taint);
            return var5E7C8E05686CD046B5E518E1A524CD5B_817990290;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.710 -0400", hash_original_method = "BD9CF59DC295A4AE3510934F298E27E6", hash_generated_method = "6C7DBBDB03998B87FF9CC72339F15F20")
        public Entry<K, V> lowerEntry(K key) {
            addTaint(key.getTaint());
Entry<K, V> var5EEE7716674B425CEA31D7AC72A401A4_971851386 =             immutableCopy(findBounded(key, LOWER));
            var5EEE7716674B425CEA31D7AC72A401A4_971851386.addTaint(taint);
            return var5EEE7716674B425CEA31D7AC72A401A4_971851386;
            // ---------- Original Method ----------
            //return immutableCopy(findBounded(key, LOWER));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.710 -0400", hash_original_method = "EBA87E3AFD9E90051DFFEBD0117773EA", hash_generated_method = "BFD2860C08BF68F9D9F958C31CC6EE36")
        public K lowerKey(K key) {
            addTaint(key.getTaint());
            Entry<K, V> entry = findBounded(key, LOWER);
K var15DE16EBAA69B0A4EA051FB5DEC39C10_278622633 =             entry != null ? entry.getKey() : null;
            var15DE16EBAA69B0A4EA051FB5DEC39C10_278622633.addTaint(taint);
            return var15DE16EBAA69B0A4EA051FB5DEC39C10_278622633;
            // ---------- Original Method ----------
            //Entry<K, V> entry = findBounded(key, LOWER);
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.711 -0400", hash_original_method = "581C54D570AF4193E6400C576ED95C35", hash_generated_method = "F18D0743F8BCBE603BDDA9898A1FBE3D")
        public Entry<K, V> floorEntry(K key) {
            addTaint(key.getTaint());
Entry<K, V> varC2D8288DAEE7B2AD361DAA75FC2202C3_104231524 =             immutableCopy(findBounded(key, FLOOR));
            varC2D8288DAEE7B2AD361DAA75FC2202C3_104231524.addTaint(taint);
            return varC2D8288DAEE7B2AD361DAA75FC2202C3_104231524;
            // ---------- Original Method ----------
            //return immutableCopy(findBounded(key, FLOOR));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.711 -0400", hash_original_method = "E92237DAC033388A5150FD58D66D705D", hash_generated_method = "7F36126EF8401E463E91665493B643DE")
        public K floorKey(K key) {
            addTaint(key.getTaint());
            Entry<K, V> entry = findBounded(key, FLOOR);
K var15DE16EBAA69B0A4EA051FB5DEC39C10_537538919 =             entry != null ? entry.getKey() : null;
            var15DE16EBAA69B0A4EA051FB5DEC39C10_537538919.addTaint(taint);
            return var15DE16EBAA69B0A4EA051FB5DEC39C10_537538919;
            // ---------- Original Method ----------
            //Entry<K, V> entry = findBounded(key, FLOOR);
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.711 -0400", hash_original_method = "C11821BD096982DAE03E94867B2C92BE", hash_generated_method = "FDD74F87191B0165185C5177075CBC6A")
        public Entry<K, V> ceilingEntry(K key) {
            addTaint(key.getTaint());
Entry<K, V> var4231880C2A190D7782E1F90F0F7B868D_729851703 =             immutableCopy(findBounded(key, CEILING));
            var4231880C2A190D7782E1F90F0F7B868D_729851703.addTaint(taint);
            return var4231880C2A190D7782E1F90F0F7B868D_729851703;
            // ---------- Original Method ----------
            //return immutableCopy(findBounded(key, CEILING));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.712 -0400", hash_original_method = "01AF63D6DC81CC48D8C6B0BE37F83B4D", hash_generated_method = "7FC625D40730DA52832D549D7426BF4F")
        public K ceilingKey(K key) {
            addTaint(key.getTaint());
            Entry<K, V> entry = findBounded(key, CEILING);
K var15DE16EBAA69B0A4EA051FB5DEC39C10_394414836 =             entry != null ? entry.getKey() : null;
            var15DE16EBAA69B0A4EA051FB5DEC39C10_394414836.addTaint(taint);
            return var15DE16EBAA69B0A4EA051FB5DEC39C10_394414836;
            // ---------- Original Method ----------
            //Entry<K, V> entry = findBounded(key, CEILING);
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.712 -0400", hash_original_method = "4DE66AB7FA66EBE29F4E4509967D65D0", hash_generated_method = "50BB647F27999F69942F700545C70C6A")
        public Entry<K, V> higherEntry(K key) {
            addTaint(key.getTaint());
Entry<K, V> var0D6C34F1391AD2F31A7F6610A91CE3C1_663010426 =             immutableCopy(findBounded(key, HIGHER));
            var0D6C34F1391AD2F31A7F6610A91CE3C1_663010426.addTaint(taint);
            return var0D6C34F1391AD2F31A7F6610A91CE3C1_663010426;
            // ---------- Original Method ----------
            //return immutableCopy(findBounded(key, HIGHER));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.712 -0400", hash_original_method = "47A499322D06CDAFFEC1D4DA0A079F0A", hash_generated_method = "683D79B0ECBFA6A92012D73DDBCDCB57")
        public K higherKey(K key) {
            addTaint(key.getTaint());
            Entry<K, V> entry = findBounded(key, HIGHER);
K var15DE16EBAA69B0A4EA051FB5DEC39C10_1480402330 =             entry != null ? entry.getKey() : null;
            var15DE16EBAA69B0A4EA051FB5DEC39C10_1480402330.addTaint(taint);
            return var15DE16EBAA69B0A4EA051FB5DEC39C10_1480402330;
            // ---------- Original Method ----------
            //Entry<K, V> entry = findBounded(key, HIGHER);
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.713 -0400", hash_original_method = "631801B6DE22632DEACA2B547DEBE43A", hash_generated_method = "C0DC73A6D78B39B30755D58AE084243D")
        public Comparator<? super K> comparator() {
    if(ascending)            
            {
Comparator<? super K> varEE9621AAB15522B49DAC63CE835E2941_1560237227 =                 TreeMap.this.comparator();
                varEE9621AAB15522B49DAC63CE835E2941_1560237227.addTaint(taint);
                return varEE9621AAB15522B49DAC63CE835E2941_1560237227;
            } //End block
            else
            {
Comparator<? super K> var189BFD6654899F3ED4575521560E0DC6_2031334128 =                 Collections.reverseOrder(comparator);
                var189BFD6654899F3ED4575521560E0DC6_2031334128.addTaint(taint);
                return var189BFD6654899F3ED4575521560E0DC6_2031334128;
            } //End block
            // ---------- Original Method ----------
            //if (ascending) {
            //return TreeMap.this.comparator();
          //} else {
            //return Collections.reverseOrder(comparator);
          //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.713 -0400", hash_original_method = "7F86A739037DCA8312EEE2819E1107F8", hash_generated_method = "C00E80BF19CF0C55D7BC29F652AF1E49")
        @Override
        public Set<Entry<K, V>> entrySet() {
            BoundedEntrySet result = entrySet;
Set<Entry<K, V>> var7EA657578A416D0A7E3291794489838F_858317075 =             result != null ? result : (entrySet = new BoundedEntrySet());
            var7EA657578A416D0A7E3291794489838F_858317075.addTaint(taint);
            return var7EA657578A416D0A7E3291794489838F_858317075;
            // ---------- Original Method ----------
            //BoundedEntrySet result = entrySet;
            //return result != null ? result : (entrySet = new BoundedEntrySet());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.713 -0400", hash_original_method = "8D1D053C1D8B0756868AB879DB7CB086", hash_generated_method = "C4277EA6CEB9A29F788BD31A36E894AB")
        @Override
        public Set<K> keySet() {
Set<K> varAF7F4C03A95ED30F86359E39EFFF72E9_833092249 =             navigableKeySet();
            varAF7F4C03A95ED30F86359E39EFFF72E9_833092249.addTaint(taint);
            return varAF7F4C03A95ED30F86359E39EFFF72E9_833092249;
            // ---------- Original Method ----------
            //return navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.714 -0400", hash_original_method = "58209BC6FD1C6420A0C3CE4B441A6EA8", hash_generated_method = "51DCB3CBF2CA03CE7F27CB41E217143D")
        public NavigableSet<K> navigableKeySet() {
            BoundedKeySet result = keySet;
NavigableSet<K> var65433A428F01D1730EDF71551397CAE5_188585050 =             result != null ? result : (keySet = new BoundedKeySet());
            var65433A428F01D1730EDF71551397CAE5_188585050.addTaint(taint);
            return var65433A428F01D1730EDF71551397CAE5_188585050;
            // ---------- Original Method ----------
            //BoundedKeySet result = keySet;
            //return result != null ? result : (keySet = new BoundedKeySet());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.714 -0400", hash_original_method = "6D358EC631E9E279A9C759613AD4CBF5", hash_generated_method = "BD73B2E4A46C22E4980E4B49778FD62B")
        public NavigableMap<K, V> descendingMap() {
NavigableMap<K, V> var86E3BFF502581898758F73B9E6908FAD_2081546671 =             new BoundedMap(!ascending, from, fromBound, to, toBound);
            var86E3BFF502581898758F73B9E6908FAD_2081546671.addTaint(taint);
            return var86E3BFF502581898758F73B9E6908FAD_2081546671;
            // ---------- Original Method ----------
            //return new BoundedMap(!ascending, from, fromBound, to, toBound);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.714 -0400", hash_original_method = "E068C75BD35AA3BEC427F457C352E2B5", hash_generated_method = "79251016494E04021FC72E00DDDAB075")
        public NavigableSet<K> descendingKeySet() {
NavigableSet<K> varAF8103DD5E04E7E5EEF583022A60862D_1733955366 =             new BoundedMap(!ascending, from, fromBound, to, toBound).navigableKeySet();
            varAF8103DD5E04E7E5EEF583022A60862D_1733955366.addTaint(taint);
            return varAF8103DD5E04E7E5EEF583022A60862D_1733955366;
            // ---------- Original Method ----------
            //return new BoundedMap(!ascending, from, fromBound, to, toBound).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.715 -0400", hash_original_method = "3DC9A98D108EA5F857802D111DD4C7BC", hash_generated_method = "3DB8DAC3BDD92BD8AECFC144BC3C3A3D")
        public NavigableMap<K, V> subMap(K from, boolean fromInclusive, K to, boolean toInclusive) {
            addTaint(toInclusive);
            addTaint(to.getTaint());
            addTaint(fromInclusive);
            addTaint(from.getTaint());
            Bound fromBound = fromInclusive ? INCLUSIVE : EXCLUSIVE;
            Bound toBound = toInclusive ? INCLUSIVE : EXCLUSIVE;
NavigableMap<K, V> var0455DF56F4615D9DE9D27B19AFAEF226_1052266388 =             subMap(from, fromBound, to, toBound);
            var0455DF56F4615D9DE9D27B19AFAEF226_1052266388.addTaint(taint);
            return var0455DF56F4615D9DE9D27B19AFAEF226_1052266388;
            // ---------- Original Method ----------
            //Bound fromBound = fromInclusive ? INCLUSIVE : EXCLUSIVE;
            //Bound toBound = toInclusive ? INCLUSIVE : EXCLUSIVE;
            //return subMap(from, fromBound, to, toBound);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.715 -0400", hash_original_method = "85C9C855FCFD7C01DE62316D427AA356", hash_generated_method = "445E036A20CA4EA5E7DD5DF4D89FF570")
        public NavigableMap<K, V> subMap(K fromInclusive, K toExclusive) {
            addTaint(toExclusive.getTaint());
            addTaint(fromInclusive.getTaint());
NavigableMap<K, V> varB4D2F6DE1EAD448F88B0A434FEE1794C_1855159299 =             subMap(fromInclusive, INCLUSIVE, toExclusive, EXCLUSIVE);
            varB4D2F6DE1EAD448F88B0A434FEE1794C_1855159299.addTaint(taint);
            return varB4D2F6DE1EAD448F88B0A434FEE1794C_1855159299;
            // ---------- Original Method ----------
            //return subMap(fromInclusive, INCLUSIVE, toExclusive, EXCLUSIVE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.716 -0400", hash_original_method = "F0BAF6F2CF2FCD82E483E31B5C869204", hash_generated_method = "D5F902A4723F04EAEB361718197B35B4")
        public NavigableMap<K, V> headMap(K to, boolean inclusive) {
            addTaint(inclusive);
            addTaint(to.getTaint());
            Bound toBound = inclusive ? INCLUSIVE : EXCLUSIVE;
NavigableMap<K, V> var2AFE5CD544BBF55ECF5B05CE6BA0FAD1_948313641 =             subMap(null, NO_BOUND, to, toBound);
            var2AFE5CD544BBF55ECF5B05CE6BA0FAD1_948313641.addTaint(taint);
            return var2AFE5CD544BBF55ECF5B05CE6BA0FAD1_948313641;
            // ---------- Original Method ----------
            //Bound toBound = inclusive ? INCLUSIVE : EXCLUSIVE;
            //return subMap(null, NO_BOUND, to, toBound);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.716 -0400", hash_original_method = "ABFE13DC9073E46E049BB999D5306953", hash_generated_method = "1F00EF65243E361BF4FFDE16EC849C1F")
        public NavigableMap<K, V> headMap(K toExclusive) {
            addTaint(toExclusive.getTaint());
NavigableMap<K, V> var765BFAC84EB1A83FC3B14F73D7910B18_2103757900 =             subMap(null, NO_BOUND, toExclusive, EXCLUSIVE);
            var765BFAC84EB1A83FC3B14F73D7910B18_2103757900.addTaint(taint);
            return var765BFAC84EB1A83FC3B14F73D7910B18_2103757900;
            // ---------- Original Method ----------
            //return subMap(null, NO_BOUND, toExclusive, EXCLUSIVE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.716 -0400", hash_original_method = "26986665A8C827C93D404190F2752B4C", hash_generated_method = "29C8C6A1FE567C27D2163C05EE4E242A")
        public NavigableMap<K, V> tailMap(K from, boolean inclusive) {
            addTaint(inclusive);
            addTaint(from.getTaint());
            Bound fromBound = inclusive ? INCLUSIVE : EXCLUSIVE;
NavigableMap<K, V> var35EFA145DEE09E716468DD6B2AFF8A39_438904639 =             subMap(from, fromBound, null, NO_BOUND);
            var35EFA145DEE09E716468DD6B2AFF8A39_438904639.addTaint(taint);
            return var35EFA145DEE09E716468DD6B2AFF8A39_438904639;
            // ---------- Original Method ----------
            //Bound fromBound = inclusive ? INCLUSIVE : EXCLUSIVE;
            //return subMap(from, fromBound, null, NO_BOUND);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.717 -0400", hash_original_method = "CF387452C0473BBA846F53D5C56CE3B2", hash_generated_method = "4DC8A9698C48C0C00D5457D542DB7D19")
        public NavigableMap<K, V> tailMap(K fromInclusive) {
            addTaint(fromInclusive.getTaint());
NavigableMap<K, V> varE8FB1045162A43BFD2F2D63D6DC8CED9_1001726769 =             subMap(fromInclusive, INCLUSIVE, null, NO_BOUND);
            varE8FB1045162A43BFD2F2D63D6DC8CED9_1001726769.addTaint(taint);
            return varE8FB1045162A43BFD2F2D63D6DC8CED9_1001726769;
            // ---------- Original Method ----------
            //return subMap(fromInclusive, INCLUSIVE, null, NO_BOUND);
        }

        
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.731 -0400", hash_original_method = "65FB71F2A366D35F7884C2869AFAA6ED", hash_generated_method = "F50F1C2022A41DA4BAEDAD7601AF2F23")
        private IllegalArgumentException outOfBounds(Object value, Bound fromBound, Bound toBound) {
            addTaint(toBound.getTaint());
            addTaint(fromBound.getTaint());
            addTaint(value.getTaint());
IllegalArgumentException varB6209D04CF3E19CAD859CC3BE52189E0_950407803 =             new IllegalArgumentException(value + " not in range "
                    + fromBound.leftCap(from) + ".." + toBound.rightCap(to));
            varB6209D04CF3E19CAD859CC3BE52189E0_950407803.addTaint(taint);
            return varB6209D04CF3E19CAD859CC3BE52189E0_950407803;
            // ---------- Original Method ----------
            //return new IllegalArgumentException(value + " not in range "
                    //+ fromBound.leftCap(from) + ".." + toBound.rightCap(to));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.731 -0400", hash_original_method = "9F20C8CFE1A741092D9743A31C3F8586", hash_generated_method = "0E8702C4867B256576228B361A0AAAEC")
         Object writeReplace() throws ObjectStreamException {
Object var7F4944441F64C47E165D9A9EC6DB3E3C_1359595494 =             ascending
                    ? new AscendingSubMap<K, V>(TreeMap.this, from, fromBound, to, toBound)
                    : new DescendingSubMap<K, V>(TreeMap.this, from, fromBound, to, toBound);
            var7F4944441F64C47E165D9A9EC6DB3E3C_1359595494.addTaint(taint);
            return var7F4944441F64C47E165D9A9EC6DB3E3C_1359595494;
            // ---------- Original Method ----------
            //return ascending
                    //? new AscendingSubMap<K, V>(TreeMap.this, from, fromBound, to, toBound)
                    //: new DescendingSubMap<K, V>(TreeMap.this, from, fromBound, to, toBound);
        }

        
        abstract class BoundedIterator<T> extends MapIterator<T> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.732 -0400", hash_original_method = "30CDAF663F351A84269F6FB0B072EFA9", hash_generated_method = "DCA6AE078FF061847F66F0A7A80CFEA2")
            protected  BoundedIterator(Node<K, V> next) {
                super(next);
                addTaint(next.getTaint());
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.732 -0400", hash_original_method = "E9206CF01CB691A7CC292AD03FA9736C", hash_generated_method = "0C1A221BEC1403A7554B42696207DFDD")
            @Override
            protected Node<K, V> stepForward() {
                Node<K, V> result = super.stepForward();
    if(next != null && !isInBounds(next.key, NO_BOUND, toBound))                
                {
                    next = null;
                } //End block
Node<K, V> varDC838461EE2FA0CA4C9BBB70A15456B0_178381585 =                 result;
                varDC838461EE2FA0CA4C9BBB70A15456B0_178381585.addTaint(taint);
                return varDC838461EE2FA0CA4C9BBB70A15456B0_178381585;
                // ---------- Original Method ----------
                //Node<K, V> result = super.stepForward();
                //if (next != null && !isInBounds(next.key, NO_BOUND, toBound)) {
                    //next = null;
                //}
                //return result;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.733 -0400", hash_original_method = "E55F6A3E56D317586EA4F65D3F74D30B", hash_generated_method = "6AA9B11EA00E75EC7C57B807224A3E24")
            @Override
            protected Node<K, V> stepBackward() {
                Node<K, V> result = super.stepBackward();
    if(next != null && !isInBounds(next.key, fromBound, NO_BOUND))                
                {
                    next = null;
                } //End block
Node<K, V> varDC838461EE2FA0CA4C9BBB70A15456B0_868536180 =                 result;
                varDC838461EE2FA0CA4C9BBB70A15456B0_868536180.addTaint(taint);
                return varDC838461EE2FA0CA4C9BBB70A15456B0_868536180;
                // ---------- Original Method ----------
                //Node<K, V> result = super.stepBackward();
                //if (next != null && !isInBounds(next.key, fromBound, NO_BOUND)) {
                    //next = null;
                //}
                //return result;
            }

            
        }


        
        final class BoundedEntrySet extends AbstractSet<Entry<K, V>> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.733 -0400", hash_original_method = "6A727A04787362E0DA8C9D4EFA8450E8", hash_generated_method = "6A727A04787362E0DA8C9D4EFA8450E8")
            public BoundedEntrySet ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.733 -0400", hash_original_method = "29BBB3BE9EA7B6D6C0B83C28F05082A4", hash_generated_method = "744710A20315A8A622B84467C39FBB91")
            @Override
            public int size() {
                int var97BE7EAD6DC7A924C500E8F471E6CC2B_1420855947 = (BoundedMap.this.size());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_137254300 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_137254300;
                // ---------- Original Method ----------
                //return BoundedMap.this.size();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.733 -0400", hash_original_method = "AEA447F4A69E282FABF93736832EBAA3", hash_generated_method = "7B9B699803214EC27CC3A0EB544807C8")
            @Override
            public boolean isEmpty() {
                boolean varE6F4C3E8DEB8CD0D0ECE5B894222EC74_1304563417 = (BoundedMap.this.isEmpty());
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_37464214 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_37464214;
                // ---------- Original Method ----------
                //return BoundedMap.this.isEmpty();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.734 -0400", hash_original_method = "0E267F64AB80178C28467CD978AC79C8", hash_generated_method = "1280FAD27349CF23A4108D89C18B5121")
            @Override
            public Iterator<Entry<K, V>> iterator() {
Iterator<Entry<K, V>> var007B5231128F5E237111AC487E38483B_1804540363 =                 new BoundedIterator<Entry<K, V>>(endpoint(true)) {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.734 -0400", hash_original_method = "336D5542BA5231E0955145F5F84B4BBD", hash_generated_method = "79153B52AF1F33AF4F611AE0A2972D43")
                public Entry<K, V> next() {
Entry<K, V> var20BE8BC2B8AE57FD70A8A3FD9993CBC9_1965850926 =                     ascending ? stepForward() : stepBackward();
                    var20BE8BC2B8AE57FD70A8A3FD9993CBC9_1965850926.addTaint(taint);
                    return var20BE8BC2B8AE57FD70A8A3FD9993CBC9_1965850926;
                    // ---------- Original Method ----------
                    //return ascending ? stepForward() : stepBackward();
                }
};
                var007B5231128F5E237111AC487E38483B_1804540363.addTaint(taint);
                return var007B5231128F5E237111AC487E38483B_1804540363;
                // ---------- Original Method ----------
                //return new BoundedIterator<Entry<K, V>>(endpoint(true)) {
                    //public Entry<K, V> next() {
                        //return ascending ? stepForward() : stepBackward();
                    //}
                //};
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.734 -0400", hash_original_method = "954A21A7B25CC1709817AC62B8C6864E", hash_generated_method = "40D006EB5C1CD62D7307B0D20CBCA77C")
            @Override
            public boolean contains(Object o) {
                addTaint(o.getTaint());
    if(!(o instanceof Entry))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1509731096 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_568483493 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_568483493;
                } //End block
                Entry<?, ?> entry = (Entry<?, ?>) o;
                boolean varD02E5172633A0EEA6042DCC36F6688AC_1272179986 = (isInBounds(entry.getKey()) && findByEntry(entry) != null);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_404896350 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_404896350;
                // ---------- Original Method ----------
                //if (!(o instanceof Entry)) {
                    //return false;
                //}
                //Entry<?, ?> entry = (Entry<?, ?>) o;
                //return isInBounds(entry.getKey()) && findByEntry(entry) != null;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.735 -0400", hash_original_method = "EF59D88655EE445530DBDC219FDD1A5F", hash_generated_method = "6C514951AA913CAE578935E198F27A1E")
            @Override
            public boolean remove(Object o) {
                addTaint(o.getTaint());
    if(!(o instanceof Entry))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_459774941 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_975956473 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_975956473;
                } //End block
                Entry<?, ?> entry = (Entry<?, ?>) o;
                boolean var0B802A8F8F22690871A9C64508FC359C_231815343 = (isInBounds(entry.getKey()) && TreeMap.this.entrySet().remove(entry));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_247363047 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_247363047;
                // ---------- Original Method ----------
                //if (!(o instanceof Entry)) {
                    //return false;
                //}
                //Entry<?, ?> entry = (Entry<?, ?>) o;
                //return isInBounds(entry.getKey()) && TreeMap.this.entrySet().remove(entry);
            }

            
        }


        
        final class BoundedKeySet extends AbstractSet<K> implements NavigableSet<K> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.735 -0400", hash_original_method = "9AD1259E686AD3B6150FA3E61E8BAA17", hash_generated_method = "9AD1259E686AD3B6150FA3E61E8BAA17")
            public BoundedKeySet ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.736 -0400", hash_original_method = "29BBB3BE9EA7B6D6C0B83C28F05082A4", hash_generated_method = "47117ED1C38FDF398CE607F106966439")
            @Override
            public int size() {
                int var97BE7EAD6DC7A924C500E8F471E6CC2B_60404900 = (BoundedMap.this.size());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_381296564 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_381296564;
                // ---------- Original Method ----------
                //return BoundedMap.this.size();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.736 -0400", hash_original_method = "AEA447F4A69E282FABF93736832EBAA3", hash_generated_method = "FC25271AF637EFB1C310A17BC00ACFCA")
            @Override
            public boolean isEmpty() {
                boolean varE6F4C3E8DEB8CD0D0ECE5B894222EC74_1302516279 = (BoundedMap.this.isEmpty());
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1060221886 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1060221886;
                // ---------- Original Method ----------
                //return BoundedMap.this.isEmpty();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.737 -0400", hash_original_method = "8539DDED7A19368CB3D09440D6A62269", hash_generated_method = "A81AD9CEA78A8B3119ACA8A110E67F2C")
            @Override
            public Iterator<K> iterator() {
Iterator<K> var67B4ECA44D3FE1877CC98B43105388F5_1223410124 =                 new BoundedIterator<K>(endpoint(true)) {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.736 -0400", hash_original_method = "3A3F5ECB2E6902CB8A6D0DE3222F8B33", hash_generated_method = "1638E481A4CD4EB5897C5FE77B20C460")
                public K next() {
K varCF8CFCF1855BD2B023CA836D055B4ADC_1027083953 =                     (ascending ? stepForward() : stepBackward()).key;
                    varCF8CFCF1855BD2B023CA836D055B4ADC_1027083953.addTaint(taint);
                    return varCF8CFCF1855BD2B023CA836D055B4ADC_1027083953;
                    // ---------- Original Method ----------
                    //return (ascending ? stepForward() : stepBackward()).key;
                }
};
                var67B4ECA44D3FE1877CC98B43105388F5_1223410124.addTaint(taint);
                return var67B4ECA44D3FE1877CC98B43105388F5_1223410124;
                // ---------- Original Method ----------
                //return new BoundedIterator<K>(endpoint(true)) {
                    //public K next() {
                        //return (ascending ? stepForward() : stepBackward()).key;
                    //}
                //};
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.737 -0400", hash_original_method = "74923548E6D3A508C57DDA053BC0EE64", hash_generated_method = "00FFAA7570D06939BDA49FBBAAB2D110")
            public Iterator<K> descendingIterator() {
Iterator<K> var9EBD11D4DEB7C81B42F9AB79E3A635DE_1173279209 =                 new BoundedIterator<K>(endpoint(false)) {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.737 -0400", hash_original_method = "3DCBF0E7821BEEE7C84D65AF30CA29D6", hash_generated_method = "8788D8D27323196A1A6429406E044AE6")
                public K next() {
K var5AE3460D8173776397FCF8731046F295_2040528405 =                     (ascending ? stepBackward() : stepForward()).key;
                    var5AE3460D8173776397FCF8731046F295_2040528405.addTaint(taint);
                    return var5AE3460D8173776397FCF8731046F295_2040528405;
                    // ---------- Original Method ----------
                    //return (ascending ? stepBackward() : stepForward()).key;
                }
};
                var9EBD11D4DEB7C81B42F9AB79E3A635DE_1173279209.addTaint(taint);
                return var9EBD11D4DEB7C81B42F9AB79E3A635DE_1173279209;
                // ---------- Original Method ----------
                //return new BoundedIterator<K>(endpoint(false)) {
                    //public K next() {
                        //return (ascending ? stepBackward() : stepForward()).key;
                    //}
                //};
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.738 -0400", hash_original_method = "F2816D590B9E0F32B93C47AB444AEEED", hash_generated_method = "AF96322EF641BA42FA68D87E6C7401C6")
            @Override
            public boolean contains(Object key) {
                addTaint(key.getTaint());
                boolean var61DB1BC73AFD05F9CFD09A5DB24EF2D6_1676400530 = (isInBounds(key) && findByObject(key) != null);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1797531212 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1797531212;
                // ---------- Original Method ----------
                //return isInBounds(key) && findByObject(key) != null;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.738 -0400", hash_original_method = "ADEDE1B4ABE9B2F86F8B629056F35200", hash_generated_method = "8D2542F75E9FE813DC26CEA3CE17BB13")
            @Override
            public boolean remove(Object key) {
                addTaint(key.getTaint());
                boolean varFEC11371252D69AE7E6714162868C228_1839880151 = (isInBounds(key) && removeInternalByKey(key) != null);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1309914823 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1309914823;
                // ---------- Original Method ----------
                //return isInBounds(key) && removeInternalByKey(key) != null;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.738 -0400", hash_original_method = "3067DEE01FBBBFD061436C7D4561F434", hash_generated_method = "818BDB272970EF062596FBEFB437D88F")
            public K first() {
K var59F2D49FC0979EFEDD893E9689C2AA6B_1347754593 =                 firstKey();
                var59F2D49FC0979EFEDD893E9689C2AA6B_1347754593.addTaint(taint);
                return var59F2D49FC0979EFEDD893E9689C2AA6B_1347754593;
                // ---------- Original Method ----------
                //return firstKey();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.739 -0400", hash_original_method = "4985BB63726B115899F1811F08E80BDF", hash_generated_method = "B64258D13E7056A763A15D9E8A5A77D2")
            public K pollFirst() {
                Entry<K, ?> entry = pollFirstEntry();
K var15DE16EBAA69B0A4EA051FB5DEC39C10_1987325943 =                 entry != null ? entry.getKey() : null;
                var15DE16EBAA69B0A4EA051FB5DEC39C10_1987325943.addTaint(taint);
                return var15DE16EBAA69B0A4EA051FB5DEC39C10_1987325943;
                // ---------- Original Method ----------
                //Entry<K, ?> entry = pollFirstEntry();
                //return entry != null ? entry.getKey() : null;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.739 -0400", hash_original_method = "39C87F788E647BCD3FB86FFF34D7EF10", hash_generated_method = "F96EED7996E52365189DC76CD76AB893")
            public K last() {
K var9DAA79F4D4E0401E91D6AAF423D49398_1395444969 =                 lastKey();
                var9DAA79F4D4E0401E91D6AAF423D49398_1395444969.addTaint(taint);
                return var9DAA79F4D4E0401E91D6AAF423D49398_1395444969;
                // ---------- Original Method ----------
                //return lastKey();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.739 -0400", hash_original_method = "B202B1B2AAB477548F6A0AD72C9B1701", hash_generated_method = "7E15283223CCB497A35B94D298B598DA")
            public K pollLast() {
                Entry<K, ?> entry = pollLastEntry();
K var15DE16EBAA69B0A4EA051FB5DEC39C10_1690666735 =                 entry != null ? entry.getKey() : null;
                var15DE16EBAA69B0A4EA051FB5DEC39C10_1690666735.addTaint(taint);
                return var15DE16EBAA69B0A4EA051FB5DEC39C10_1690666735;
                // ---------- Original Method ----------
                //Entry<K, ?> entry = pollLastEntry();
                //return entry != null ? entry.getKey() : null;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.740 -0400", hash_original_method = "5CFE05BF706A06BBB501067306F1B9ED", hash_generated_method = "0336018AA8D3B3691F5993B43C12B1AE")
            public K lower(K key) {
                addTaint(key.getTaint());
K var2B86BD115FCBD0ED4D0B4CB097A2C388_1521326101 =                 lowerKey(key);
                var2B86BD115FCBD0ED4D0B4CB097A2C388_1521326101.addTaint(taint);
                return var2B86BD115FCBD0ED4D0B4CB097A2C388_1521326101;
                // ---------- Original Method ----------
                //return lowerKey(key);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.740 -0400", hash_original_method = "10BABB7BB2E837824A13AAE89EE7EC6F", hash_generated_method = "0A495F5466447F00736AA99A4E24DB4B")
            public K floor(K key) {
                addTaint(key.getTaint());
K var350534B70A929DCE92BCA350B3F7DA8E_1338404355 =                 floorKey(key);
                var350534B70A929DCE92BCA350B3F7DA8E_1338404355.addTaint(taint);
                return var350534B70A929DCE92BCA350B3F7DA8E_1338404355;
                // ---------- Original Method ----------
                //return floorKey(key);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.740 -0400", hash_original_method = "2AD4706A6D818B709A1E2CA64B48B4B9", hash_generated_method = "31AD5D91AD0080B3F6E537A6DFFFB7F0")
            public K ceiling(K key) {
                addTaint(key.getTaint());
K varC33643BEB47C1CC66B2C2CDB25527B59_1447538728 =                 ceilingKey(key);
                varC33643BEB47C1CC66B2C2CDB25527B59_1447538728.addTaint(taint);
                return varC33643BEB47C1CC66B2C2CDB25527B59_1447538728;
                // ---------- Original Method ----------
                //return ceilingKey(key);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.741 -0400", hash_original_method = "8CC63649234BFC57DB10A2387AE34DD6", hash_generated_method = "B2CE70B0769D014B595A1C58F7809384")
            public K higher(K key) {
                addTaint(key.getTaint());
K var75CF48C4839A7AAF074C16D584CD6253_1109765044 =                 higherKey(key);
                var75CF48C4839A7AAF074C16D584CD6253_1109765044.addTaint(taint);
                return var75CF48C4839A7AAF074C16D584CD6253_1109765044;
                // ---------- Original Method ----------
                //return higherKey(key);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.741 -0400", hash_original_method = "C5DD330893039070B9523799F47D2DEB", hash_generated_method = "ECD01580D52453B92FB0288AE1C51048")
            public Comparator<? super K> comparator() {
Comparator<? super K> varBA2FE525F1D4BFB7E44CC52BEB2076A0_1795213104 =                 BoundedMap.this.comparator();
                varBA2FE525F1D4BFB7E44CC52BEB2076A0_1795213104.addTaint(taint);
                return varBA2FE525F1D4BFB7E44CC52BEB2076A0_1795213104;
                // ---------- Original Method ----------
                //return BoundedMap.this.comparator();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.741 -0400", hash_original_method = "21039715CA3F916EA62F8064E71FC6CA", hash_generated_method = "00AD7B26887302432CF0704A69C70319")
            public NavigableSet<K> subSet(K from, boolean fromInclusive, K to, boolean toInclusive) {
                addTaint(toInclusive);
                addTaint(to.getTaint());
                addTaint(fromInclusive);
                addTaint(from.getTaint());
NavigableSet<K> var81C01024AF0DDE2CDF42AA146D845866_1560167237 =                 subMap(from, fromInclusive, to, toInclusive).navigableKeySet();
                var81C01024AF0DDE2CDF42AA146D845866_1560167237.addTaint(taint);
                return var81C01024AF0DDE2CDF42AA146D845866_1560167237;
                // ---------- Original Method ----------
                //return subMap(from, fromInclusive, to, toInclusive).navigableKeySet();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.742 -0400", hash_original_method = "AA0E5149ADFB9D8316CC8EA86FBC0B9E", hash_generated_method = "C529D1362A6C7D76E2FA0FAEC86E511D")
            public SortedSet<K> subSet(K fromInclusive, K toExclusive) {
                addTaint(toExclusive.getTaint());
                addTaint(fromInclusive.getTaint());
SortedSet<K> var4825DD5198D9DFA934AB97460E43155A_1128827847 =                 subMap(fromInclusive, toExclusive).navigableKeySet();
                var4825DD5198D9DFA934AB97460E43155A_1128827847.addTaint(taint);
                return var4825DD5198D9DFA934AB97460E43155A_1128827847;
                // ---------- Original Method ----------
                //return subMap(fromInclusive, toExclusive).navigableKeySet();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.742 -0400", hash_original_method = "EDDD3784AC7E9834A18CCB5F2AE27346", hash_generated_method = "15E2F8712A7EB4E912B52BDCE9D8CF5E")
            public NavigableSet<K> headSet(K to, boolean inclusive) {
                addTaint(inclusive);
                addTaint(to.getTaint());
NavigableSet<K> var1DDC11FD80C467CDB58D05608701E96E_284333520 =                 headMap(to, inclusive).navigableKeySet();
                var1DDC11FD80C467CDB58D05608701E96E_284333520.addTaint(taint);
                return var1DDC11FD80C467CDB58D05608701E96E_284333520;
                // ---------- Original Method ----------
                //return headMap(to, inclusive).navigableKeySet();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.742 -0400", hash_original_method = "85EE899AF4D85617CB858518BA70EA12", hash_generated_method = "D31AC7A6D478D5328F6FFEEC3E57CAA2")
            public SortedSet<K> headSet(K toExclusive) {
                addTaint(toExclusive.getTaint());
SortedSet<K> var296570554B3647284DAA1B64FE89EA1C_1789622883 =                 headMap(toExclusive).navigableKeySet();
                var296570554B3647284DAA1B64FE89EA1C_1789622883.addTaint(taint);
                return var296570554B3647284DAA1B64FE89EA1C_1789622883;
                // ---------- Original Method ----------
                //return headMap(toExclusive).navigableKeySet();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.743 -0400", hash_original_method = "B964A303D464756EDD8E9C26A8D54411", hash_generated_method = "5E9621DD5056D282A6A8BFDFF3259C33")
            public NavigableSet<K> tailSet(K from, boolean inclusive) {
                addTaint(inclusive);
                addTaint(from.getTaint());
NavigableSet<K> varCAB92A74D6D2084A2C4FEA91193971BF_591660902 =                 tailMap(from, inclusive).navigableKeySet();
                varCAB92A74D6D2084A2C4FEA91193971BF_591660902.addTaint(taint);
                return varCAB92A74D6D2084A2C4FEA91193971BF_591660902;
                // ---------- Original Method ----------
                //return tailMap(from, inclusive).navigableKeySet();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.743 -0400", hash_original_method = "9536952691BDDFD3D8EFB20A3BD9AE85", hash_generated_method = "6E4403614CF4C856AFF55BEB7D9BA93A")
            public SortedSet<K> tailSet(K fromInclusive) {
                addTaint(fromInclusive.getTaint());
SortedSet<K> var599DB6DD96A121671494C9C10C8AD7AE_1585852710 =                 tailMap(fromInclusive).navigableKeySet();
                var599DB6DD96A121671494C9C10C8AD7AE_1585852710.addTaint(taint);
                return var599DB6DD96A121671494C9C10C8AD7AE_1585852710;
                // ---------- Original Method ----------
                //return tailMap(fromInclusive).navigableKeySet();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.743 -0400", hash_original_method = "2BD89B2F5D5D75B5A66FC121E2BE77F9", hash_generated_method = "C1464F950C6CE548198F17EF6845316F")
            public NavigableSet<K> descendingSet() {
NavigableSet<K> varAF8103DD5E04E7E5EEF583022A60862D_62672176 =                 new BoundedMap(!ascending, from, fromBound, to, toBound).navigableKeySet();
                varAF8103DD5E04E7E5EEF583022A60862D_62672176.addTaint(taint);
                return varAF8103DD5E04E7E5EEF583022A60862D_62672176;
                // ---------- Original Method ----------
                //return new BoundedMap(!ascending, from, fromBound, to, toBound).navigableKeySet();
            }

            
        }


        
    }


    
    static abstract class NavigableSubMap<K, V> extends AbstractMap<K, V> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.744 -0400", hash_original_field = "6F8F57715090DA2632453988D9A1501B", hash_generated_field = "B4717CF7B02EE2D309DEC599DAA1DA31")

        TreeMap<K, V> m;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.744 -0400", hash_original_field = "7CE8636C076F5F42316676F7CA5CCFBE", hash_generated_field = "281EBE4703232193C289CCB42FC430E9")

        Object lo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.744 -0400", hash_original_field = "49F68A5C8493EC2C0BF489821C21FC3B", hash_generated_field = "EE270961C9ABF0EB22776F11E5EA361C")

        Object hi;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.744 -0400", hash_original_field = "0F5BB94160321573CBA39E65B009DB81", hash_generated_field = "D276D04527E3A57EE21A2E9A0B8A1207")

        boolean fromStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.744 -0400", hash_original_field = "A7515FC4FC23FB8889BFBA1242727AA1", hash_generated_field = "949B6DE90AB1D05CDD408410B1AFD766")

        boolean toEnd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.744 -0400", hash_original_field = "A7CF08EB9369574B3716AAA5776C2B8D", hash_generated_field = "21B44DD2A9CF91217A1B213D6DC61745")

        boolean loInclusive;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.745 -0400", hash_original_field = "A4BF0B040F2788C41F2B3BBC34352A92", hash_generated_field = "B6BC458569D2A14CE4BE7D6F92D77203")

        boolean hiInclusive;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.746 -0400", hash_original_method = "C1ACA683FC5CFCA3BE29823730AC5B8B", hash_generated_method = "D5980D3B68B4F742E542A915179E4C63")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.746 -0400", hash_original_method = "98169B5D59A5E61A69F2A37D56262114", hash_generated_method = "F447C195B060F4C7ACDCF51C6793D0D2")
        @Override
        public Set<Entry<K, V>> entrySet() {
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1889237441 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_1889237441.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_1889237441;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.746 -0400", hash_original_method = "6A8A4C8549808D70F841B9593D31A43F", hash_generated_method = "EB72B0C591A18CC1611870A92FA9E32C")
        @SuppressWarnings("unchecked")
        protected Object readResolve() throws ObjectStreamException {
            Bound fromBound = fromStart ? NO_BOUND : (loInclusive ? INCLUSIVE : EXCLUSIVE);
            Bound toBound = toEnd ? NO_BOUND : (hiInclusive ? INCLUSIVE : EXCLUSIVE);
            boolean ascending = !(this instanceof DescendingSubMap);
Object var1219B05CBB1AEEB8B0049A311D9879A0_333604951 =             m.new BoundedMap(ascending, (K) lo, fromBound, (K) hi, toBound);
            var1219B05CBB1AEEB8B0049A311D9879A0_333604951.addTaint(taint);
            return var1219B05CBB1AEEB8B0049A311D9879A0_333604951;
            // ---------- Original Method ----------
            //Bound fromBound = fromStart ? NO_BOUND : (loInclusive ? INCLUSIVE : EXCLUSIVE);
            //Bound toBound = toEnd ? NO_BOUND : (hiInclusive ? INCLUSIVE : EXCLUSIVE);
            //boolean ascending = !(this instanceof DescendingSubMap);
            //return m.new BoundedMap(ascending, (K) lo, fromBound, (K) hi, toBound);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.747 -0400", hash_original_field = "24DD802BAD101B93E8408F7D464B2F7C", hash_generated_field = "6BF063A975464DC368634F8846E9F148")

        private static final long serialVersionUID = -2102997345730753016L;
    }


    
    static class DescendingSubMap<K, V> extends NavigableSubMap<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.747 -0400", hash_original_field = "9895B45EF9B1655F7485C1A0A0B5F7B1", hash_generated_field = "4B9119BDF2383B87567C450919484206")

        Comparator<K> reverseComparator;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.747 -0400", hash_original_method = "FDAA1F4436CE129642763FB7A272001D", hash_generated_method = "EE69462E1E829F3C3BD441CA8A6A00F0")
          DescendingSubMap(TreeMap<K, V> delegate, K from, Bound fromBound, K to, Bound toBound) {
            super(delegate, from, fromBound, to, toBound);
            addTaint(toBound.getTaint());
            addTaint(to.getTaint());
            addTaint(fromBound.getTaint());
            addTaint(from.getTaint());
            addTaint(delegate.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.747 -0400", hash_original_field = "52D0D343187A178B79D894969A386899", hash_generated_field = "C2E3DB7866C7906947BFB5DD9B67BC77")

        private static final long serialVersionUID = 912986545866120460L;
    }


    
    static class AscendingSubMap<K, V> extends NavigableSubMap<K, V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.748 -0400", hash_original_method = "C32F016187D7478ED63A0FCF56CB93EB", hash_generated_method = "6B067806C6CF8D3FE392FCD588CFD190")
          AscendingSubMap(TreeMap<K, V> delegate, K from, Bound fromBound, K to, Bound toBound) {
            super(delegate, from, fromBound, to, toBound);
            addTaint(toBound.getTaint());
            addTaint(to.getTaint());
            addTaint(fromBound.getTaint());
            addTaint(from.getTaint());
            addTaint(delegate.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.748 -0400", hash_original_field = "B7AE5FA51DF371C0F9A4E87B021D4132", hash_generated_field = "9BC786EF1C7A0AEECE0DAFB6F4501079")

        private static final long serialVersionUID = 912986545866124060L;
    }


    
    class SubMap extends AbstractMap<K, V> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.748 -0400", hash_original_field = "430A77C88BFBC96EB36AF12A2DC1DEB7", hash_generated_field = "7CA688EFC5D14AE4FAAF4A0FA771CBD0")

        Object fromKey;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.748 -0400", hash_original_field = "A8F9F07D66AF8C1622E025437E7B26CE", hash_generated_field = "40A3A7AC103CBB24D1824415661519AF")

        Object toKey;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.748 -0400", hash_original_field = "0F5BB94160321573CBA39E65B009DB81", hash_generated_field = "D276D04527E3A57EE21A2E9A0B8A1207")

        boolean fromStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.748 -0400", hash_original_field = "A7515FC4FC23FB8889BFBA1242727AA1", hash_generated_field = "949B6DE90AB1D05CDD408410B1AFD766")

        boolean toEnd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.749 -0400", hash_original_method = "F30568FCC0DA5EEA09201E340702FDB4", hash_generated_method = "F30568FCC0DA5EEA09201E340702FDB4")
        public SubMap ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.749 -0400", hash_original_method = "98169B5D59A5E61A69F2A37D56262114", hash_generated_method = "2BB1F62192FCEA60FE1ACDB503F8D701")
        @Override
        public Set<Entry<K, V>> entrySet() {
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1648438884 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_1648438884.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_1648438884;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.749 -0400", hash_original_method = "AC95C6CC81DF8BD4B0519A49635D6CF0", hash_generated_method = "C4B5E0875EE2EF921C776C1BCC93F3A2")
        @SuppressWarnings("unchecked")
        protected Object readResolve() throws ObjectStreamException {
            Bound fromBound = fromStart ? NO_BOUND : INCLUSIVE;
            Bound toBound = toEnd ? NO_BOUND : EXCLUSIVE;
Object var7784C953CCD41FF740A502CFF8B72EA4_2012559801 =             new BoundedMap(true, (K) fromKey, fromBound, (K) toKey, toBound);
            var7784C953CCD41FF740A502CFF8B72EA4_2012559801.addTaint(taint);
            return var7784C953CCD41FF740A502CFF8B72EA4_2012559801;
            // ---------- Original Method ----------
            //Bound fromBound = fromStart ? NO_BOUND : INCLUSIVE;
            //Bound toBound = toEnd ? NO_BOUND : EXCLUSIVE;
            //return new BoundedMap(true, (K) fromKey, fromBound, (K) toKey, toBound);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.749 -0400", hash_original_field = "EB690E9D3449E3ACDD044094944C88A2", hash_generated_field = "20872E7F065D1D88A3E41FBB2346AD4E")

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
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.749 -0400", hash_original_field = "0CB2D400AD555324093441A5EA2C6B7E", hash_generated_field = "72B7CECA8AF68C19BE3FF8E965B18D99")

    private static final long serialVersionUID = 919286545866124006L;
}

