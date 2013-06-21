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
    Comparator<? super K> comparator;
    Node<K, V> root;
    int size = 0;
    int modCount = 0;
    private EntrySet entrySet;
    private KeySet keySet;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.045 -0400", hash_original_method = "A79D85B768A2B786B5F2ACD3F2B9D249", hash_generated_method = "CFE342F2F41F7796DB24A93B3EC5E9D4")
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    public TreeMap() {
        this.comparator = (Comparator<? super K>) NATURAL_ORDER;
        // ---------- Original Method ----------
        //this.comparator = (Comparator<? super K>) NATURAL_ORDER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.048 -0400", hash_original_method = "317880CC1AD8B8CC7D9C11CC941EE8C3", hash_generated_method = "83DFF81168746787EC772572751FF68E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TreeMap(Map<? extends K, ? extends V> copyFrom) {
        this();
        dsTaint.addTaint(copyFrom.dsTaint);
        {
            copyFrom.entrySet().iterator().hasNext();
            Map.Entry<? extends K, ? extends V> entry = copyFrom.entrySet().iterator().next();
            {
                putInternal(entry.getKey(), entry.getValue());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (Map.Entry<? extends K, ? extends V> entry : copyFrom.entrySet()) {
            //putInternal(entry.getKey(), entry.getValue());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.048 -0400", hash_original_method = "C1FE892CAD9D3780A675F5A8CA11F4FA", hash_generated_method = "C0E9CC47B1398B3B3DBACCF875250B44")
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    public TreeMap(Comparator<? super K> comparator) {
        dsTaint.addTaint(comparator.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.051 -0400", hash_original_method = "2607F9CE6A88866DC32D385287E67644", hash_generated_method = "9AE65D25C9D8023257BA1A8591E1212E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public TreeMap(SortedMap<K, ? extends V> copyFrom) {
        dsTaint.addTaint(copyFrom.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.051 -0400", hash_original_method = "FB8B1056739768AF92CF25DB3C2D30EB", hash_generated_method = "99BA114BEA7AE9908F2DA23FFEE2289E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        try 
        {
            @SuppressWarnings("unchecked") TreeMap<K, V> map;
            map = (TreeMap<K, V>) super.clone();
            map.root = root != null ? root.copy(null) : null;
            map.entrySet = null;
            map.keySet = null;
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        } //End block
        return (Object)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.051 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "2127DA49D089D6CBC77B455A0DBDC124")
    @DSModeled(DSC.SAFE)
    @Override
    public int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.051 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "4BEC7A3919A556BE19BE40EE7160C52B")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isEmpty() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return size == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.052 -0400", hash_original_method = "C35732A40B74AF28951D9E96FE33879B", hash_generated_method = "E0548EB1D251E37F1C5CB02D8FE8C5AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public V get(Object key) {
        dsTaint.addTaint(key.dsTaint);
        Entry<K, V> entry;
        entry = findByObject(key);
        {
            Object varDDD7292C065899F2728EAD5CD98A4F68_1654731373 = (entry.getValue());
        } //End flattened ternary
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Entry<K, V> entry = findByObject(key);
        //return entry != null ? entry.getValue() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.052 -0400", hash_original_method = "CD38E6D478445847B9B0A556F5E63837", hash_generated_method = "989EAA52D2C2DD5780FD28D783B88ABE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean containsKey(Object key) {
        dsTaint.addTaint(key.dsTaint);
        boolean var169B170947F44477F294694A95E8B219_1811422337 = (findByObject(key) != null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return findByObject(key) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.052 -0400", hash_original_method = "09423F07E68B4770E107529B69AA8334", hash_generated_method = "5CD0C66DD6A733A15553031E470D497F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public V put(K key, V value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        V var286DC1D6FE6BD99771DB62C242D34D70_1554962276 = (putInternal(key, value));
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return putInternal(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.052 -0400", hash_original_method = "EA5BE6ED678D7376259BCC3DB1C01E21", hash_generated_method = "25747B87C7C6F2CC69ED86A75548B960")
    @DSModeled(DSC.SAFE)
    @Override
    public void clear() {
        root = null;
        size = 0;
        // ---------- Original Method ----------
        //root = null;
        //size = 0;
        //modCount++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.052 -0400", hash_original_method = "0207194EB3BB344ADD94A18916C183DF", hash_generated_method = "63FFBB88666899CCBC9D0238E2CE2EC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public V remove(Object key) {
        dsTaint.addTaint(key.dsTaint);
        Node<K, V> node;
        node = removeInternalByKey(key);
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Node<K, V> node = removeInternalByKey(key);
        //return node != null ? node.value : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.053 -0400", hash_original_method = "73D5DA91D47B13631BBA1FF4FFC14006", hash_generated_method = "ED3E7105D392B62D4C3E8297DB21D14F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     V putInternal(K key, V value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        Node<K, V> created;
        created = find(key, Relation.CREATE);
        V result;
        result = created.value;
        created.value = value;
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Node<K, V> created = find(key, Relation.CREATE);
        //V result = created.value;
        //created.value = value;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.053 -0400", hash_original_method = "A47B461F1595004F5F78D5AE91E8DCD0", hash_generated_method = "CACF750EE791E64D9A66B5FE93D7060D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Node<K, V> find(K key, Relation relation) {
        dsTaint.addTaint(relation.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new ClassCastException(key.getClass().getName() + " is not Comparable");
            } //End block
            {
                root = new Node<K, V>(null, key);
                size = 1;
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
                Node<K, V> var6A988A9BDC609329B721B0F5708527C0_2128450825 = (nearest.prev());
                //End case LOWER 
                //Begin case HIGHER 
                Node<K, V> varDAA2591EEA78F448691CDB26099D1445_613788090 = (nearest.next());
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
                Node<K, V> var6A988A9BDC609329B721B0F5708527C0_1993146963 = (nearest.prev());
                //End case LOWER FLOOR 
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
            } //End block
            {
                //Begin case CEILING HIGHER 
                Node<K, V> varDAA2591EEA78F448691CDB26099D1445_1811200836 = (nearest.next());
                //End case CEILING HIGHER 
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
            } //End block
        } //End block
        return (Node<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.054 -0400", hash_original_method = "C267D163E835004AE4803D9A2BC1E552", hash_generated_method = "6CA901FD1923776D65F4609977D291AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
     Node<K, V> findByObject(Object key) {
        dsTaint.addTaint(key.dsTaint);
        Node<K, V> var5F6F4D349557FD85F3DF8AD05D69DA1F_1790241789 = (find((K) key, EQUAL));
        return (Node<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return find((K) key, EQUAL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.054 -0400", hash_original_method = "8678505752B854905CFE7B96C4FE458B", hash_generated_method = "7041836748CDDB197622AECBD13F1531")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Node<K, V> findByEntry(Entry<?, ?> entry) {
        dsTaint.addTaint(entry.dsTaint);
        Node<K, V> mine;
        mine = findByObject(entry.getKey());
        boolean valuesEqual;
        valuesEqual = mine != null && Objects.equal(mine.value, entry.getValue());
        return (Node<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Node<K, V> mine = findByObject(entry.getKey());
        //boolean valuesEqual = mine != null && Objects.equal(mine.value, entry.getValue());
        //return valuesEqual ? mine : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.054 -0400", hash_original_method = "FAD76EC8E4C5DF9CCDE64BA514AC9743", hash_generated_method = "C15434F27D20D69A0AD8D52CF80E6C3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void removeInternal(Node<K, V> node) {
        dsTaint.addTaint(node.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.055 -0400", hash_original_method = "C9B9883A6728DC2F4DBB90BDF61B9978", hash_generated_method = "3383793E163A8EB5B1BD2783F268FFF7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Node<K, V> removeInternalByKey(Object key) {
        dsTaint.addTaint(key.dsTaint);
        Node<K, V> node;
        node = findByObject(key);
        {
            removeInternal(node);
        } //End block
        return (Node<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Node<K, V> node = findByObject(key);
        //if (node != null) {
            //removeInternal(node);
        //}
        //return node;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.055 -0400", hash_original_method = "8CBFE12E379E7871AFCE5B0FC5C284CB", hash_generated_method = "624873D25B2D5F5141AD5568E46FC2B7")
    @DSModeled(DSC.SAFE)
    private void replaceInParent(Node<K, V> node, Node<K, V> replacement) {
        dsTaint.addTaint(replacement.dsTaint);
        dsTaint.addTaint(node.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.055 -0400", hash_original_method = "DE22B63E2A021BAF8A5DCC142FCC4B40", hash_generated_method = "3FAB6FFB72E1F994B7A797AAA71D3448")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void rebalance(Node<K, V> unbalanced, boolean insert) {
        dsTaint.addTaint(insert);
        dsTaint.addTaint(unbalanced.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.057 -0400", hash_original_method = "6326CB79DBF89391F00F9AB13B0E81D9", hash_generated_method = "DA8DD91308A4B65B318C2D9A003C9F76")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void rotateLeft(Node<K, V> root) {
        dsTaint.addTaint(root.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.058 -0400", hash_original_method = "DF035E309292DEA6067E726F513C85C3", hash_generated_method = "C071E281475D4C3E839183EC2FFC4F20")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void rotateRight(Node<K, V> root) {
        dsTaint.addTaint(root.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.058 -0400", hash_original_method = "E2F61A98BB539F90A11465C6A8354CE5", hash_generated_method = "BD47854D6496F9294728C18D57AE71A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SimpleImmutableEntry<K, V> immutableCopy(Entry<K, V> entry) {
        dsTaint.addTaint(entry.dsTaint);
        {
            Object var03D618631891EE782D97F8369D312785_1064517955 = (new SimpleImmutableEntry<K, V>(entry));
        } //End flattened ternary
        return (SimpleImmutableEntry<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return entry == null ? null : new SimpleImmutableEntry<K, V>(entry);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.060 -0400", hash_original_method = "9F2AE61C584701540103A59451B8FA45", hash_generated_method = "EE0E069380C89ECF33CEFDA8F62FF39A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Entry<K, V> firstEntry() {
        Entry<K, V> var91697C82AF12979B72ED8D5517077B0E_1143104362 = (immutableCopy(root == null ? null : root.first())); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return (Entry<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return immutableCopy(root == null ? null : root.first());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.060 -0400", hash_original_method = "2730A7A2197248AC3B653DF430BA3F4A", hash_generated_method = "DBEE90E0EA9E6E0ED8CCAE4D428B8B40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Entry<K, V> internalPollFirstEntry() {
        Node<K, V> result;
        result = root.first();
        removeInternal(result);
        return (Entry<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (root == null) {
            //return null;
        //}
        //Node<K, V> result = root.first();
        //removeInternal(result);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.060 -0400", hash_original_method = "1456A4986DE10120F25B46536C8BF169", hash_generated_method = "E71B62D22011D3B4FDFA81B2BFEFB105")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Entry<K, V> pollFirstEntry() {
        Entry<K, V> var2DD0DA1167DFD6680DF2814CCC0024FA_945961022 = (immutableCopy(internalPollFirstEntry()));
        return (Entry<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return immutableCopy(internalPollFirstEntry());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.060 -0400", hash_original_method = "B0B89D697E050FAAC6816A6E8B1E56A4", hash_generated_method = "6B413BDDFA5DB8EA11976FE7FB9FA22E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public K firstKey() {
        {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        } //End block
        K var808169D4062ACF553C2513AD3EE389E3_12992017 = (root.first().getKey());
        return (K)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (root == null) {
            //throw new NoSuchElementException();
        //}
        //return root.first().getKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.060 -0400", hash_original_method = "9DDE470F0E6425136CCDC59F74FCDED6", hash_generated_method = "B258E084DA1B45B17F99AC2D2BFE8716")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Entry<K, V> lastEntry() {
        Entry<K, V> varCB82AD30BDE1CF7B30FA2F2B8FFF1AF6_1103348300 = (immutableCopy(root == null ? null : root.last())); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return (Entry<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return immutableCopy(root == null ? null : root.last());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.061 -0400", hash_original_method = "A726E2736A4C282A51BDD8062FE5CCFA", hash_generated_method = "AD0041ED06A957D48C37A374DC418641")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Entry<K, V> internalPollLastEntry() {
        Node<K, V> result;
        result = root.last();
        removeInternal(result);
        return (Entry<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (root == null) {
            //return null;
        //}
        //Node<K, V> result = root.last();
        //removeInternal(result);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.061 -0400", hash_original_method = "5064879999AB9A13D0821F605568F112", hash_generated_method = "E8AB3710E3A395AFAFEA6154F5FF00A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Entry<K, V> pollLastEntry() {
        Entry<K, V> var81CEC5DDB72A8FC1D52EAF1F2C6E1769_1910970500 = (immutableCopy(internalPollLastEntry()));
        return (Entry<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return immutableCopy(internalPollLastEntry());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.061 -0400", hash_original_method = "9EE1928205B19C964D03E8011BB7E907", hash_generated_method = "144C80AEE3300CE2E4EA67DF040F594A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public K lastKey() {
        {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        } //End block
        K varA55DE5EAFF8E2D4E1470238AFBDC1446_358089226 = (root.last().getKey());
        return (K)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (root == null) {
            //throw new NoSuchElementException();
        //}
        //return root.last().getKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.062 -0400", hash_original_method = "9D71F38DCAD7DBC2AA9FACCDA9CF4866", hash_generated_method = "9950E0F3B3AC48C9D3F807C8F1AA5CEF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Entry<K, V> lowerEntry(K key) {
        dsTaint.addTaint(key.dsTaint);
        Entry<K, V> varF4B11A3A54D92CC29E1FEDB5BBEC8427_1685039468 = (immutableCopy(find(key, LOWER)));
        return (Entry<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return immutableCopy(find(key, LOWER));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.062 -0400", hash_original_method = "BC9464ECC7239B355BB45B80204BADD6", hash_generated_method = "2E0C4990955A563B5582E2F3F853FCDD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public K lowerKey(K key) {
        dsTaint.addTaint(key.dsTaint);
        Entry<K, V> entry;
        entry = find(key, LOWER);
        {
            Object var4B8D962F1524E92662DE034798AAC65A_1124747943 = (entry.getKey());
        } //End flattened ternary
        return (K)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Entry<K, V> entry = find(key, LOWER);
        //return entry != null ? entry.getKey() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.063 -0400", hash_original_method = "5D12D4D534218428856149792C7C973A", hash_generated_method = "7C63A884489B2DEF0F632BE60FCE25C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Entry<K, V> floorEntry(K key) {
        dsTaint.addTaint(key.dsTaint);
        Entry<K, V> varAA00A36E7D90CF7484C2AA7BFB9036A1_1894093975 = (immutableCopy(find(key, FLOOR)));
        return (Entry<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return immutableCopy(find(key, FLOOR));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.063 -0400", hash_original_method = "9E3521C1E5D0BB4CA97E65B4B91FC561", hash_generated_method = "3179A3E805E9D0DDB4EB4072D57A6270")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public K floorKey(K key) {
        dsTaint.addTaint(key.dsTaint);
        Entry<K, V> entry;
        entry = find(key, FLOOR);
        {
            Object var4B8D962F1524E92662DE034798AAC65A_1532023004 = (entry.getKey());
        } //End flattened ternary
        return (K)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Entry<K, V> entry = find(key, FLOOR);
        //return entry != null ? entry.getKey() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.064 -0400", hash_original_method = "14BBCA12BBBC651385215255CDF3836D", hash_generated_method = "74A48CCC9E3BA6A47D272C198D38F8D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Entry<K, V> ceilingEntry(K key) {
        dsTaint.addTaint(key.dsTaint);
        Entry<K, V> var5FDAD4FEC5E903AD4D7C9B4926AF956C_1550691030 = (immutableCopy(find(key, CEILING)));
        return (Entry<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return immutableCopy(find(key, CEILING));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.064 -0400", hash_original_method = "818E984E93F7F07D0C27D2493F11C2A5", hash_generated_method = "1478AC66D013B950038A5C2985716ECF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public K ceilingKey(K key) {
        dsTaint.addTaint(key.dsTaint);
        Entry<K, V> entry;
        entry = find(key, CEILING);
        {
            Object var4B8D962F1524E92662DE034798AAC65A_1943618096 = (entry.getKey());
        } //End flattened ternary
        return (K)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Entry<K, V> entry = find(key, CEILING);
        //return entry != null ? entry.getKey() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.064 -0400", hash_original_method = "AC2414FDDF42A1318F8CC45C80E09BC1", hash_generated_method = "92F65589E45B3139684E5F01E8D6D3D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Entry<K, V> higherEntry(K key) {
        dsTaint.addTaint(key.dsTaint);
        Entry<K, V> varE7778894287DDB6FC47EE2D8B0DFA8E9_1439998928 = (immutableCopy(find(key, HIGHER)));
        return (Entry<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return immutableCopy(find(key, HIGHER));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.065 -0400", hash_original_method = "0C080E769BA3B62EBC93442ECCB0FC7D", hash_generated_method = "E4B1B84B9E5FA592B223BF8C2AEDC7BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public K higherKey(K key) {
        dsTaint.addTaint(key.dsTaint);
        Entry<K, V> entry;
        entry = find(key, HIGHER);
        {
            Object var4B8D962F1524E92662DE034798AAC65A_1686057774 = (entry.getKey());
        } //End flattened ternary
        return (K)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Entry<K, V> entry = find(key, HIGHER);
        //return entry != null ? entry.getKey() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.065 -0400", hash_original_method = "6A8618E17145F23513711DA8498038AE", hash_generated_method = "9DDEED32BAB4C23BACD25C1D7DDED1E9")
    @DSModeled(DSC.SAFE)
    public Comparator<? super K> comparator() {
        return (Comparator<? super K>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return comparator != NATURAL_ORDER ? comparator : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.065 -0400", hash_original_method = "D2C4C51D99D6D10356C2F96D116110D2", hash_generated_method = "A3ABA476C9AD1AC763D659A937DE979C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Set<Entry<K, V>> entrySet() {
        EntrySet result;
        result = entrySet;
        {
            Object var8EEA31F996A0AE22A7B2AC281EA5A60C_1222135581 = ((entrySet = new EntrySet()));
        } //End flattened ternary
        return (Set<Entry<K, V>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //EntrySet result = entrySet;
        //return result != null ? result : (entrySet = new EntrySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.066 -0400", hash_original_method = "0E17D4043440FAA66222611D1AC45111", hash_generated_method = "DFE005FCFBF23F654EF70BE552624783")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Set<K> keySet() {
        KeySet result;
        result = keySet;
        {
            Object varB5B77DAF0CA06DFD739ACDEAEEA4B87A_1670873147 = ((keySet = new KeySet()));
        } //End flattened ternary
        return (Set<K>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //KeySet result = keySet;
        //return result != null ? result : (keySet = new KeySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.066 -0400", hash_original_method = "016115EA38C293C7AAA8E892AEA754CA", hash_generated_method = "5A94FD65E674A0CB698CD9323ED452E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NavigableSet<K> navigableKeySet() {
        KeySet result;
        result = keySet;
        {
            Object varB5B77DAF0CA06DFD739ACDEAEEA4B87A_1280452317 = ((keySet = new KeySet()));
        } //End flattened ternary
        return (NavigableSet<K>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //KeySet result = keySet;
        //return result != null ? result : (keySet = new KeySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.066 -0400", hash_original_method = "DA6DE2093EE8DE46EE4576501F54E528", hash_generated_method = "AADF13A732AF8A75C1CBFBB9DACFEAB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NavigableMap<K, V> subMap(K from, boolean fromInclusive, K to, boolean toInclusive) {
        dsTaint.addTaint(to.dsTaint);
        dsTaint.addTaint(fromInclusive);
        dsTaint.addTaint(toInclusive);
        dsTaint.addTaint(from.dsTaint);
        Bound fromBound;
        fromBound = INCLUSIVE;
        fromBound = EXCLUSIVE;
        Bound toBound;
        toBound = INCLUSIVE;
        toBound = EXCLUSIVE;
        NavigableMap<K, V> var054BAF669D4459134524014BD4A6EFBF_1729153393 = (new BoundedMap(true, from, fromBound, to, toBound));
        return (NavigableMap<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Bound fromBound = fromInclusive ? INCLUSIVE : EXCLUSIVE;
        //Bound toBound = toInclusive ? INCLUSIVE : EXCLUSIVE;
        //return new BoundedMap(true, from, fromBound, to, toBound);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.066 -0400", hash_original_method = "193BA03007E91EBBDB489C20B60BFC88", hash_generated_method = "3CD78198629AB681AF6C5FE52AECD61B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SortedMap<K, V> subMap(K fromInclusive, K toExclusive) {
        dsTaint.addTaint(fromInclusive.dsTaint);
        dsTaint.addTaint(toExclusive.dsTaint);
        SortedMap<K, V> var03D08967ED52E0048065A20AFB492FEE_1721891479 = (new BoundedMap(true, fromInclusive, INCLUSIVE, toExclusive, EXCLUSIVE));
        return (SortedMap<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new BoundedMap(true, fromInclusive, INCLUSIVE, toExclusive, EXCLUSIVE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.067 -0400", hash_original_method = "FA312E74B0C04D741489E3323E0FFDFE", hash_generated_method = "5D3A06B549FCB15088A8A0B172226F38")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NavigableMap<K, V> headMap(K to, boolean inclusive) {
        dsTaint.addTaint(inclusive);
        dsTaint.addTaint(to.dsTaint);
        Bound toBound;
        toBound = INCLUSIVE;
        toBound = EXCLUSIVE;
        NavigableMap<K, V> var8D2217666628A0B8F341ABD6E6595BF3_1179556648 = (new BoundedMap(true, null, NO_BOUND, to, toBound));
        return (NavigableMap<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Bound toBound = inclusive ? INCLUSIVE : EXCLUSIVE;
        //return new BoundedMap(true, null, NO_BOUND, to, toBound);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.067 -0400", hash_original_method = "CAC178CA3C39A0AC08FB27C63F9A635C", hash_generated_method = "7403CBDB6DA0210D847C45AB69C876F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SortedMap<K, V> headMap(K toExclusive) {
        dsTaint.addTaint(toExclusive.dsTaint);
        SortedMap<K, V> varDB1C8B07F30243D91E4CCEA365377AAB_1313100317 = (new BoundedMap(true, null, NO_BOUND, toExclusive, EXCLUSIVE));
        return (SortedMap<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new BoundedMap(true, null, NO_BOUND, toExclusive, EXCLUSIVE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.067 -0400", hash_original_method = "828BC950C20B857C189141DA99499F09", hash_generated_method = "60DFDB630B946D5BAC73FB4CDF0AE185")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NavigableMap<K, V> tailMap(K from, boolean inclusive) {
        dsTaint.addTaint(inclusive);
        dsTaint.addTaint(from.dsTaint);
        Bound fromBound;
        fromBound = INCLUSIVE;
        fromBound = EXCLUSIVE;
        NavigableMap<K, V> var49875892219989D5EF6874329A3A868E_1216013041 = (new BoundedMap(true, from, fromBound, null, NO_BOUND));
        return (NavigableMap<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Bound fromBound = inclusive ? INCLUSIVE : EXCLUSIVE;
        //return new BoundedMap(true, from, fromBound, null, NO_BOUND);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.067 -0400", hash_original_method = "79B47D2E0956F27B23E0B18E5FD19D6A", hash_generated_method = "B6D1502D7C21EF253F3D4DFB18553C41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SortedMap<K, V> tailMap(K fromInclusive) {
        dsTaint.addTaint(fromInclusive.dsTaint);
        SortedMap<K, V> varAD1E02098D787A3216F85C02FD11D54C_983296305 = (new BoundedMap(true, fromInclusive, INCLUSIVE, null, NO_BOUND));
        return (SortedMap<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new BoundedMap(true, fromInclusive, INCLUSIVE, null, NO_BOUND);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.067 -0400", hash_original_method = "5AD6A5A37D3C9366BEF11B75DC396D31", hash_generated_method = "F0D9A095CB53BA798D93C0A81EDA9950")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NavigableMap<K, V> descendingMap() {
        NavigableMap<K, V> var12F4366B5F71837F0AE2B014B974F59E_2045622348 = (new BoundedMap(false, null, NO_BOUND, null, NO_BOUND));
        return (NavigableMap<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new BoundedMap(false, null, NO_BOUND, null, NO_BOUND);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.068 -0400", hash_original_method = "1207DF79B9959BCB242E95030D6177B0", hash_generated_method = "8D90C0FDF628E88D68F543294404B5AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NavigableSet<K> descendingKeySet() {
        NavigableSet<K> var788D31692CC1663DAFB1AB6BA92F5FF1_1268943081 = (new BoundedMap(false, null, NO_BOUND, null, NO_BOUND).navigableKeySet());
        return (NavigableSet<K>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.075 -0400", hash_original_method = "BF81D129CE69F9BEB40CAD27F974F3C8", hash_generated_method = "2B00EAA19914F49D520B512067CAD909")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(ObjectOutputStream stream) throws IOException {
        dsTaint.addTaint(stream.dsTaint);
        stream.putFields().put("comparator", comparator != NATURAL_ORDER ? comparator : null);
        stream.writeFields();
        stream.writeInt(size);
        {
            Iterator<Map.Entry<K, V>> var40A6EBFD1C8AB95DF2D9F4B462803CBE_1189813452 = (entrySet()).iterator();
            var40A6EBFD1C8AB95DF2D9F4B462803CBE_1189813452.hasNext();
            Map.Entry<K, V> entry = var40A6EBFD1C8AB95DF2D9F4B462803CBE_1189813452.next();
            {
                stream.writeObject(entry.getKey());
                stream.writeObject(entry.getValue());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //stream.putFields().put("comparator", comparator != NATURAL_ORDER ? comparator : null);
        //stream.writeFields();
        //stream.writeInt(size);
        //for (Map.Entry<K, V> entry : entrySet()) {
            //stream.writeObject(entry.getKey());
            //stream.writeObject(entry.getValue());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.076 -0400", hash_original_method = "4DE82E48A11AFCCB2DCFEAE704B1F475", hash_generated_method = "FA2578CCED00FB043710439C4B906D7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        dsTaint.addTaint(stream.dsTaint);
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
        Node<K, V> parent;
        Node<K, V> left;
        Node<K, V> right;
        K key;
        V value;
        int height;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.076 -0400", hash_original_method = "62891C3DA898C4CAE2A216E3248BC6D0", hash_generated_method = "920D3DDD011ADE58A63933B8109FEDF0")
        @DSModeled(DSC.SAFE)
         Node(Node<K, V> parent, K key) {
            dsTaint.addTaint(parent.dsTaint);
            dsTaint.addTaint(key.dsTaint);
            this.height = 1;
            // ---------- Original Method ----------
            //this.parent = parent;
            //this.key = key;
            //this.height = 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.076 -0400", hash_original_method = "81E3C4E28B5839A0B87A03CA341E9BD1", hash_generated_method = "402477AB28495F6134B21C9DEF7C62D1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Node<K, V> copy(Node<K, V> parent) {
            dsTaint.addTaint(parent.dsTaint);
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
            return (Node<K, V>)dsTaint.getTaint();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.077 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "72E8E211F4CBB9A3E7EA7C601BF9517D")
        @DSModeled(DSC.SAFE)
        public K getKey() {
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return key;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.077 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "1716B03F3EEDEC9A8CDFDC8FCC55E236")
        @DSModeled(DSC.SAFE)
        public V getValue() {
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.077 -0400", hash_original_method = "B73895AEE255DB24C138E57D2456050E", hash_generated_method = "4333C41A04860BA6AEEB70B0D6A9817D")
        @DSModeled(DSC.SAFE)
        public V setValue(V value) {
            dsTaint.addTaint(value.dsTaint);
            V oldValue;
            oldValue = this.value;
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //V oldValue = this.value;
            //this.value = value;
            //return oldValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.077 -0400", hash_original_method = "08E0671CAB8873A0A05165CE64371DB8", hash_generated_method = "924E0E7A8BD6BFCD5B948E923CCC4555")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object o) {
            dsTaint.addTaint(o.dsTaint);
            {
                Map.Entry other;
                other = (Map.Entry) o;
                boolean var7912CC5897005EB768B2514BECBB8DA1_484686079 = ((key == null ? other.getKey() == null : key.equals(other.getKey()))
                        && (value == null ? other.getValue() == null : value.equals(other.getValue()))); //DSFIXME:  CODE0008: Nested ternary operator in expression
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (o instanceof Map.Entry) {
                //Map.Entry other = (Map.Entry) o;
                //return (key == null ? other.getKey() == null : key.equals(other.getKey()))
                        //&& (value == null ? other.getValue() == null : value.equals(other.getValue()));
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.078 -0400", hash_original_method = "6416487D313DFCFD3052C01ADB883217", hash_generated_method = "BB6B9E2570D624452DFF3009566E0E69")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int var4B5981580A705D92ADA4BF72B6E1E3C5_900585867 = ((key == null ? 0 : key.hashCode())
                    ^ (value == null ? 0 : value.hashCode())); //DSFIXME:  CODE0008: Nested ternary operator in expression
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return (key == null ? 0 : key.hashCode())
                    //^ (value == null ? 0 : value.hashCode());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.078 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "4002110D0218F85825FBB09C78ED072B")
        @DSModeled(DSC.SAFE)
        @Override
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return key + "=" + value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.078 -0400", hash_original_method = "4A8921E3C940E88A3EF0004D6F064697", hash_generated_method = "332BE24614C49BDD6CDF566A1697C5D7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Node<K, V> next() {
            {
                Node<K, V> var2EF4FAB4BFD6E9F96FD38031DFD813CF_1445182417 = (right.first());
            } //End block
            Node<K, V> node;
            node = this;
            Node<K, V> parent;
            parent = node.parent;
            {
                node = parent;
                parent = node.parent;
            } //End block
            return (Node<K, V>)dsTaint.getTaint();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.079 -0400", hash_original_method = "A5795D04699EE4D7981584600E0900FB", hash_generated_method = "BD9E016863CDD309E78EB0B7C3250CBB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Node<K, V> prev() {
            {
                Node<K, V> var79BDCF9DB0B2B23947BF70D4B1A1B748_829432568 = (left.last());
            } //End block
            Node<K, V> node;
            node = this;
            Node<K, V> parent;
            parent = node.parent;
            {
                node = parent;
                parent = node.parent;
            } //End block
            return (Node<K, V>)dsTaint.getTaint();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.079 -0400", hash_original_method = "4F7C0267C30B98E081694FF304478F8A", hash_generated_method = "14A8E59368CD9AA6DD66A477E22B3184")
        @DSModeled(DSC.SAFE)
        public Node<K, V> first() {
            Node<K, V> node;
            node = this;
            Node<K, V> child;
            child = node.left;
            {
                node = child;
                child = node.left;
            } //End block
            return (Node<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Node<K, V> node = this;
            //Node<K, V> child = node.left;
            //while (child != null) {
                //node = child;
                //child = node.left;
            //}
            //return node;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.079 -0400", hash_original_method = "E5BF79B4B513B5631F4BBC9604CA3FC9", hash_generated_method = "F9BD48458D8CFB57D3E4D053858DC9BC")
        @DSModeled(DSC.SAFE)
        public Node<K, V> last() {
            Node<K, V> node;
            node = this;
            Node<K, V> child;
            child = node.right;
            {
                node = child;
                child = node.right;
            } //End block
            return (Node<K, V>)dsTaint.getTaint();
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
        protected Node<K, V> next;
        protected Node<K, V> last;
        protected int expectedModCount = modCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.079 -0400", hash_original_method = "1934503C2038D80E73C2C0A3DE09B0C3", hash_generated_method = "893CA80EB94644EA04161024646A8CC3")
        @DSModeled(DSC.SAFE)
         MapIterator(Node<K, V> next) {
            dsTaint.addTaint(next.dsTaint);
            // ---------- Original Method ----------
            //this.next = next;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.080 -0400", hash_original_method = "5C1B7B0DA20667590A4D5C5559468A28", hash_generated_method = "29B457758B43EA4A6E8E90F7268F57BD")
        @DSModeled(DSC.SAFE)
        public boolean hasNext() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return next != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.080 -0400", hash_original_method = "85C80BB4AD318538DB8131E722149B15", hash_generated_method = "CCC70D77FAA6F251EB6084169DB32EA0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected Node<K, V> stepForward() {
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            } //End block
            last = next;
            next = next.next();
            return (Node<K, V>)dsTaint.getTaint();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.081 -0400", hash_original_method = "A54C5D61E9DBD724A09A36F78C304124", hash_generated_method = "707DAD764CFB8BF9CB4652333D4EC053")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected Node<K, V> stepBackward() {
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            } //End block
            last = next;
            next = next.prev();
            return (Node<K, V>)dsTaint.getTaint();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.081 -0400", hash_original_method = "36CB2F7F3A40368DEE67850156136E6A", hash_generated_method = "68E79A243AD9DF221A3356BB1D7AE83F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.081 -0400", hash_original_method = "2F953926D7C5D976A09AA3C5A1A35BD1", hash_generated_method = "2F953926D7C5D976A09AA3C5A1A35BD1")
                public EntrySet ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.082 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "2127DA49D089D6CBC77B455A0DBDC124")
        @DSModeled(DSC.SAFE)
        @Override
        public int size() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return size;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.082 -0400", hash_original_method = "B4D4FA13F54A295418FF58C47A14DDE9", hash_generated_method = "7FE61748A4E2C69C95C8A855D9682FF9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Iterator<Entry<K, V>> iterator() {
            Iterator<Entry<K, V>> varB1AFC3FD067115C02B8FF8F72F2A29FD_162481887 = (new MapIterator<Entry<K, V>>(root == null ? null : root.first()) {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.082 -0400", hash_original_method = "86F000434530E8D6B0755FFE9A16C5F8", hash_generated_method = "E4EFC85793562BACBF2B8A9B4335585A")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                public Entry<K, V> next() {
                    Entry<K, V> var7D35D3E95C131BA5C99A60A5908903AD_11100728 = (stepForward());
                    return (Entry<K, V>)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //return stepForward();
                }
}); //DSFIXME:  CODE0008: Nested ternary operator in expression
            return (Iterator<Entry<K, V>>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new MapIterator<Entry<K, V>>(root == null ? null : root.first()) {
                //public Entry<K, V> next() {
                    //return stepForward();
                //}
            //};
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.083 -0400", hash_original_method = "AAE5A29808B951CC80BD03F648B6A63A", hash_generated_method = "624FEFCF364703A1D99B22EB4CF7DE1F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean contains(Object o) {
            dsTaint.addTaint(o.dsTaint);
            boolean var12117A785F30278636E2FCE711DC72F4_200890869 = (o instanceof Entry && findByEntry((Entry<?, ?>) o) != null);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return o instanceof Entry && findByEntry((Entry<?, ?>) o) != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.083 -0400", hash_original_method = "50402191313F22EA9CF206F14CC9A5A4", hash_generated_method = "B54D7445B08C198D0EE718B28E4CAEC5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean remove(Object o) {
            dsTaint.addTaint(o.dsTaint);
            Node<K, V> node;
            node = findByEntry((Entry<?, ?>) o);
            removeInternal(node);
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.083 -0400", hash_original_method = "1CC2A082C181027407DFF573950B6D85", hash_generated_method = "E132377B1C3D8FD49066BD79A34C72A8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void clear() {
            TreeMap.this.clear();
            // ---------- Original Method ----------
            //TreeMap.this.clear();
        }

        
    }


    
    class KeySet extends AbstractSet<K> implements NavigableSet<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.083 -0400", hash_original_method = "AD2AA12DF2DCFDBEC9B4D1AB308E571A", hash_generated_method = "AD2AA12DF2DCFDBEC9B4D1AB308E571A")
                public KeySet ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.084 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "2127DA49D089D6CBC77B455A0DBDC124")
        @DSModeled(DSC.SAFE)
        @Override
        public int size() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return size;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.084 -0400", hash_original_method = "7A518595D7BAAD9E696AF11FE92FFDBE", hash_generated_method = "D9AA0B4FB67ED6EF4D248063C5AEB6BB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Iterator<K> iterator() {
            Iterator<K> var2B1B602FB3020AA4BC610E88B5AD841C_461927412 = (new MapIterator<K>(root == null ? null : root.first()) {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.084 -0400", hash_original_method = "E581E07EB6E816B7B0F53BDF6AE52418", hash_generated_method = "68CAD0D011F9DF88D2CD8822E2F886E8")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                public K next() {
                    K varF1617C620A609839F1FA2D64FEFC594A_2134683579 = (stepForward().key);
                    return (K)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //return stepForward().key;
                }
}); //DSFIXME:  CODE0008: Nested ternary operator in expression
            return (Iterator<K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new MapIterator<K>(root == null ? null : root.first()) {
                //public K next() {
                    //return stepForward().key;
                //}
            //};
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.085 -0400", hash_original_method = "C8D968F3C5FE84BB3D2A53544A3D4B19", hash_generated_method = "5D0045EFF4103EC26FDEFEF228BB9E31")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Iterator<K> descendingIterator() {
            Iterator<K> varAA8F5FB6EB0D7024407297363765F6B1_69573043 = (new MapIterator<K>(root == null ? null : root.last()) {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.085 -0400", hash_original_method = "30CD89883F8CEF7ECE49A6E9F42F1507", hash_generated_method = "8020805957B2BE2E668866895FD4CA73")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                public K next() {
                    K var71FF50A7997C2220EA4C7EFB29BC0587_69984961 = (stepBackward().key);
                    return (K)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //return stepBackward().key;
                }
}); //DSFIXME:  CODE0008: Nested ternary operator in expression
            return (Iterator<K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new MapIterator<K>(root == null ? null : root.last()) {
                //public K next() {
                    //return stepBackward().key;
                //}
            //};
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.085 -0400", hash_original_method = "55474555B71DFC8666AC2B6E4F0261A5", hash_generated_method = "DA1E255EE5E460B50E1FAF73F3001373")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean contains(Object o) {
            dsTaint.addTaint(o.dsTaint);
            boolean var997BAB39B2F072D5CD66A271F3B6E196_687571590 = (containsKey(o));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return containsKey(o);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.085 -0400", hash_original_method = "174345B10BAB0003712B28F94B9BEA53", hash_generated_method = "75E9D9B5746B2EE74C60CB6DEF946BBC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean remove(Object key) {
            dsTaint.addTaint(key.dsTaint);
            boolean varE16D747D3226990FB8F8723539274182_692249934 = (removeInternalByKey(key) != null);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return removeInternalByKey(key) != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.086 -0400", hash_original_method = "1CC2A082C181027407DFF573950B6D85", hash_generated_method = "E132377B1C3D8FD49066BD79A34C72A8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void clear() {
            TreeMap.this.clear();
            // ---------- Original Method ----------
            //TreeMap.this.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.086 -0400", hash_original_method = "E1A1305471DEE1FE749764F6E03BE3A0", hash_generated_method = "CA15790FBBCE75A3C6F57C5F72B7F8C1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Comparator<? super K> comparator() {
            Comparator<? super K> var2487665AC7A2CC89F64C1A7B4151CFFF_1568685339 = (TreeMap.this.comparator());
            return (Comparator<? super K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return TreeMap.this.comparator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.086 -0400", hash_original_method = "3067DEE01FBBBFD061436C7D4561F434", hash_generated_method = "F14FD0F5802EC50202BB7392EF05ED21")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K first() {
            K varEA9ABE1AF2A9358BDAA77226B4553F9C_1656939477 = (firstKey());
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return firstKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.086 -0400", hash_original_method = "39C87F788E647BCD3FB86FFF34D7EF10", hash_generated_method = "ED3D47BF11B140A3549E7673D1D7F8A7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K last() {
            K var4E5EB7D1078667D29EA70FAC2161BB72_822065343 = (lastKey());
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return lastKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.086 -0400", hash_original_method = "5CFE05BF706A06BBB501067306F1B9ED", hash_generated_method = "23029731CCABA7AC886AC425385791C2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K lower(K key) {
            dsTaint.addTaint(key.dsTaint);
            K var475BD0FCF76DB09FCE7B3689FBCF1B30_1187802016 = (lowerKey(key));
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return lowerKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.087 -0400", hash_original_method = "10BABB7BB2E837824A13AAE89EE7EC6F", hash_generated_method = "84B2F6A802189B29A9D23DBA856FA38F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K floor(K key) {
            dsTaint.addTaint(key.dsTaint);
            K var568F19E8CED46AB67D471C07AEF14D94_1471873992 = (floorKey(key));
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return floorKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.087 -0400", hash_original_method = "2AD4706A6D818B709A1E2CA64B48B4B9", hash_generated_method = "FE85A27761D0B6AAD9DC14EEEF98C4CE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K ceiling(K key) {
            dsTaint.addTaint(key.dsTaint);
            K varE800CF10B89C185E918CFD2CE3432015_531066183 = (ceilingKey(key));
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ceilingKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.087 -0400", hash_original_method = "8CC63649234BFC57DB10A2387AE34DD6", hash_generated_method = "5683FD938382384BACFCD6F11E3F5532")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K higher(K key) {
            dsTaint.addTaint(key.dsTaint);
            K var3BD8F3923A952E40F404AE2D34B50021_1665247454 = (higherKey(key));
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return higherKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.088 -0400", hash_original_method = "0E3C9584B722234668005FBA598A1EC0", hash_generated_method = "25077FA3002DEB5CE23BDE0C25B46D12")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K pollFirst() {
            Entry<K, V> entry;
            entry = internalPollFirstEntry();
            {
                Object var89F8384D8DD2CA583B7A90F311F2A4B1_1467710947 = (entry.getKey());
            } //End flattened ternary
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Entry<K, V> entry = internalPollFirstEntry();
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.088 -0400", hash_original_method = "ABD0A1CFCFA4D3D1F242F2375F97811C", hash_generated_method = "E379AE2CA4B266BCA29BACE12F972BC6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K pollLast() {
            Entry<K, V> entry;
            entry = internalPollLastEntry();
            {
                Object var89F8384D8DD2CA583B7A90F311F2A4B1_2067800121 = (entry.getKey());
            } //End flattened ternary
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Entry<K, V> entry = internalPollLastEntry();
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.088 -0400", hash_original_method = "21828DA90728B75367EF3BEE7D62C832", hash_generated_method = "A17F3E32C5D847E252D7841412F75608")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NavigableSet<K> subSet(K from, boolean fromInclusive, K to, boolean toInclusive) {
            dsTaint.addTaint(to.dsTaint);
            dsTaint.addTaint(fromInclusive);
            dsTaint.addTaint(toInclusive);
            dsTaint.addTaint(from.dsTaint);
            NavigableSet<K> varF92FE939FAADF410928C920688845576_803667973 = (TreeMap.this.subMap(from, fromInclusive, to, toInclusive).navigableKeySet());
            return (NavigableSet<K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return TreeMap.this.subMap(from, fromInclusive, to, toInclusive).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.089 -0400", hash_original_method = "B37C6130D4B0113815E317EEB111D1E9", hash_generated_method = "896453655A69D211A2D287DC21F2DCA1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SortedSet<K> subSet(K fromInclusive, K toExclusive) {
            dsTaint.addTaint(fromInclusive.dsTaint);
            dsTaint.addTaint(toExclusive.dsTaint);
            SortedSet<K> varC6FAFDAF1D0EB98F47E3BA77B4064028_218587177 = (TreeMap.this.subMap(fromInclusive, true, toExclusive, false).navigableKeySet());
            return (SortedSet<K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return TreeMap.this.subMap(fromInclusive, true, toExclusive, false).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.089 -0400", hash_original_method = "15C518A93EE21ED6E81237BD492369B4", hash_generated_method = "3C795AC16B9FC390E87D1F2E3FCE09A0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NavigableSet<K> headSet(K to, boolean inclusive) {
            dsTaint.addTaint(inclusive);
            dsTaint.addTaint(to.dsTaint);
            NavigableSet<K> varB37A3AC42A2B1005AB3B277A761DA730_1315233048 = (TreeMap.this.headMap(to, inclusive).navigableKeySet());
            return (NavigableSet<K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return TreeMap.this.headMap(to, inclusive).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.090 -0400", hash_original_method = "1E1BD4D122D1F75D80BDC2474EF32137", hash_generated_method = "FBE925A50B7925C09ECEC80D80776DBC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SortedSet<K> headSet(K toExclusive) {
            dsTaint.addTaint(toExclusive.dsTaint);
            SortedSet<K> var4A1C3A9FC62B2A3888489C1D3F44AFE1_1183789134 = (TreeMap.this.headMap(toExclusive, false).navigableKeySet());
            return (SortedSet<K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return TreeMap.this.headMap(toExclusive, false).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.091 -0400", hash_original_method = "3007AE414049BD587DD344AEC05F7630", hash_generated_method = "AA87E81C9836815691A7EC33C0C4C66F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NavigableSet<K> tailSet(K from, boolean inclusive) {
            dsTaint.addTaint(inclusive);
            dsTaint.addTaint(from.dsTaint);
            NavigableSet<K> var79AC81160E828D49DCF9E0468A96BE96_1710893773 = (TreeMap.this.tailMap(from, inclusive).navigableKeySet());
            return (NavigableSet<K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return TreeMap.this.tailMap(from, inclusive).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.091 -0400", hash_original_method = "4DA58A152F26E7271643C0314BDDDB69", hash_generated_method = "83AD6783029D571E60924D8ED654B36B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SortedSet<K> tailSet(K fromInclusive) {
            dsTaint.addTaint(fromInclusive.dsTaint);
            SortedSet<K> var787DDC5D63F27B9350D66F52D279622A_1926997917 = (TreeMap.this.tailMap(fromInclusive, true).navigableKeySet());
            return (SortedSet<K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return TreeMap.this.tailMap(fromInclusive, true).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.091 -0400", hash_original_method = "1704B63D396CC7A2877008D7CE821A20", hash_generated_method = "08C305CDC8BCA4205CC749999B6521BB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NavigableSet<K> descendingSet() {
            NavigableSet<K> var929F6B70CAAA59E1766EAB1B7C2C1384_1107434004 = (new BoundedMap(false, null, NO_BOUND, null, NO_BOUND).navigableKeySet());
            return (NavigableSet<K>)dsTaint.getTaint();
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
        private transient boolean ascending;
        private transient K from;
        private transient Bound fromBound;
        private transient K to;
        private transient Bound toBound;
        private transient BoundedEntrySet entrySet;
        private transient BoundedKeySet keySet;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.092 -0400", hash_original_method = "EAF770A918D33B7B0B98CAAC01791FDE", hash_generated_method = "6A569243BB97CAE9EA478E10F4004343")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         BoundedMap(boolean ascending, K from, Bound fromBound, K to, Bound toBound) {
            dsTaint.addTaint(to.dsTaint);
            dsTaint.addTaint(toBound.dsTaint);
            dsTaint.addTaint(fromBound.dsTaint);
            dsTaint.addTaint(ascending);
            dsTaint.addTaint(from.dsTaint);
            {
                {
                    boolean varDF5DEF900BBEA61318C4B860BE963A0C_184836183 = (comparator.compare(from, to) > 0);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.092 -0400", hash_original_method = "0165FF9BE82C19127CA9F7A8EFBCC5F6", hash_generated_method = "43AFB3418896CDA4367E8F7FE6719D35")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int size() {
            int varFAAE4FEB39919E901926F6E4652B275E_492640105 = (count(entrySet().iterator()));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return count(entrySet().iterator());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.092 -0400", hash_original_method = "25ACC65054E604EE8ADED763702CFAA7", hash_generated_method = "2D335581DFE852C4525165515FA62E89")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean isEmpty() {
            boolean var19B0E21581FF256C0BE5D0F9299E6746_1836639488 = (endpoint(true) == null);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return endpoint(true) == null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.092 -0400", hash_original_method = "00AB887CF1625BBE035D7C27E115F8F5", hash_generated_method = "CEAD6378C85ECB940E065AC168F1ECFE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public V get(Object key) {
            dsTaint.addTaint(key.dsTaint);
            {
                boolean var9135CD85F99C2376B2054E1BFF183EE5_1386380630 = (isInBounds(key));
                Object varDCA787235BE6A2E5196575B0FAC0DEDE_1868123685 = (TreeMap.this.get(key));
            } //End flattened ternary
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return isInBounds(key) ? TreeMap.this.get(key) : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.093 -0400", hash_original_method = "97933E3E15C41B402232AC9CC0472CF2", hash_generated_method = "49AE485EDF69ABFCC1817CB1743D6AAE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsKey(Object key) {
            dsTaint.addTaint(key.dsTaint);
            boolean varA3E267D2E614E41BB78FB5916F69E5F6_1183539595 = (isInBounds(key) && TreeMap.this.containsKey(key));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return isInBounds(key) && TreeMap.this.containsKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.093 -0400", hash_original_method = "AA5BBA9E7D3BEE615F1E652A3C2B8A57", hash_generated_method = "C76D36FDC8121CF8BBCD532C1926629C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public V put(K key, V value) {
            dsTaint.addTaint(value.dsTaint);
            dsTaint.addTaint(key.dsTaint);
            {
                boolean varAD602F34696280F613EFFCC6CD1936C9_1951787803 = (!isInBounds(key));
                {
                    if (DroidSafeAndroidRuntime.control) throw outOfBounds(key, fromBound, toBound);
                } //End block
            } //End collapsed parenthetic
            V var8F551A1DF75EEEC56F34F3A9504C8B20_1396796413 = (putInternal(key, value));
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (!isInBounds(key)) {
                //throw outOfBounds(key, fromBound, toBound);
            //}
            //return putInternal(key, value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.093 -0400", hash_original_method = "FD860E76286147E5825948B59334B12A", hash_generated_method = "21AD36195AE99FF74FCC8CB8D05DFC85")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public V remove(Object key) {
            dsTaint.addTaint(key.dsTaint);
            {
                boolean var9135CD85F99C2376B2054E1BFF183EE5_1529657747 = (isInBounds(key));
                Object var4AF1CF7C51C3940F4140C0E33E762C29_84770936 = (TreeMap.this.remove(key));
            } //End flattened ternary
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return isInBounds(key) ? TreeMap.this.remove(key) : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.093 -0400", hash_original_method = "CBDDB4BBE438A9DB233DEA58A1C969FA", hash_generated_method = "88E3C73B736DE6A682A68CEBAA4BA670")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @SuppressWarnings("unchecked")
        private boolean isInBounds(Object key) {
            dsTaint.addTaint(key.dsTaint);
            boolean varA5F72E2E91F3E285BA97AAF5A99A4DA1_1556886071 = (isInBounds((K) key, fromBound, toBound));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return isInBounds((K) key, fromBound, toBound);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.094 -0400", hash_original_method = "692642A6AE210FFE582C89EC91302D79", hash_generated_method = "259194691ED3EE035D024B2E10860F04")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private boolean isInBounds(K key, Bound fromBound, Bound toBound) {
            dsTaint.addTaint(toBound.dsTaint);
            dsTaint.addTaint(fromBound.dsTaint);
            dsTaint.addTaint(key.dsTaint);
            {
                {
                    boolean var9F6E7E65C5DF7B537032AF04E3982098_881395509 = (comparator.compare(key, from) < 0);
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean varFBA4E02ED99BA8F4A60A17B22AA50698_216958503 = (comparator.compare(key, from) <= 0);
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var3BF67E403FFC608A69421DC18FA2C214_833349557 = (comparator.compare(key, to) > 0);
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean varEA1D9A2226B6707B7C8DE8BD2619E59B_989267739 = (comparator.compare(key, to) >= 0);
                } //End collapsed parenthetic
            } //End block
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.094 -0400", hash_original_method = "CAAC4C1A33B13586569CF07F541A55C7", hash_generated_method = "085CBA4508402791A84CE4E06EBBAD49")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private Node<K, V> bound(Node<K, V> node, Bound fromBound, Bound toBound) {
            dsTaint.addTaint(node.dsTaint);
            dsTaint.addTaint(toBound.dsTaint);
            dsTaint.addTaint(fromBound.dsTaint);
            {
                boolean varC116C584CC9981AECCA6F0640121C4B9_638659560 = (node != null && isInBounds(node.getKey(), fromBound, toBound));
            } //End flattened ternary
            return (Node<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return node != null && isInBounds(node.getKey(), fromBound, toBound) ? node : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.094 -0400", hash_original_method = "692355E3656C196457301F91A19D5157", hash_generated_method = "B2D70082F3E7192A8C58BC76C066221B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Entry<K, V> firstEntry() {
            Entry<K, V> var4A477756646ABEF870028743EA09F8EC_1133672107 = (immutableCopy(endpoint(true)));
            return (Entry<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return immutableCopy(endpoint(true));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.094 -0400", hash_original_method = "3800FF04B85DB50D775ADF76A89AF0FD", hash_generated_method = "0412AE5779647E40B7E7E72D7991E081")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Entry<K, V> pollFirstEntry() {
            Node<K, V> result;
            result = endpoint(true);
            {
                removeInternal(result);
            } //End block
            Entry<K, V> varC10CFBE1B9807D081D784E25B519FE7E_2049417769 = (immutableCopy(result));
            return (Entry<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Node<K, V> result = endpoint(true);
            //if (result != null) {
                //removeInternal(result);
            //}
            //return immutableCopy(result);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.095 -0400", hash_original_method = "1DE5152AF86A2FB092CD0802BF299C85", hash_generated_method = "E47433288D492A85BCFA5613B253C058")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K firstKey() {
            Entry<K, V> entry;
            entry = endpoint(true);
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            K var4B8D962F1524E92662DE034798AAC65A_847256935 = (entry.getKey());
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Entry<K, V> entry = endpoint(true);
            //if (entry == null) {
                //throw new NoSuchElementException();
            //}
            //return entry.getKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.095 -0400", hash_original_method = "3349B358C55B472B88F39549996E074C", hash_generated_method = "429BD917493DE01414D6FD010D7B37C5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Entry<K, V> lastEntry() {
            Entry<K, V> varB6A1B7F0F8557CC304E4C72A892B03F9_183986230 = (immutableCopy(endpoint(false)));
            return (Entry<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return immutableCopy(endpoint(false));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.095 -0400", hash_original_method = "4E391E55891B2D72162CA8FBBFDB8088", hash_generated_method = "9AFC6E994121B59A1EA0FB911C2BE7DC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Entry<K, V> pollLastEntry() {
            Node<K, V> result;
            result = endpoint(false);
            {
                removeInternal(result);
            } //End block
            Entry<K, V> varC10CFBE1B9807D081D784E25B519FE7E_121434338 = (immutableCopy(result));
            return (Entry<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Node<K, V> result = endpoint(false);
            //if (result != null) {
                //removeInternal(result);
            //}
            //return immutableCopy(result);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.095 -0400", hash_original_method = "394B9DCC52DC405017E9FB6F95D12436", hash_generated_method = "FA8F7A13778EE101066DA48C1D9C362E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K lastKey() {
            Entry<K, V> entry;
            entry = endpoint(false);
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            K var4B8D962F1524E92662DE034798AAC65A_982956504 = (entry.getKey());
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Entry<K, V> entry = endpoint(false);
            //if (entry == null) {
                //throw new NoSuchElementException();
            //}
            //return entry.getKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.095 -0400", hash_original_method = "83D48F5C9D4926E1668CDBC652A8BB3D", hash_generated_method = "0DA58CDBD5AD094E5663F32784E2BAF0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private Node<K, V> endpoint(boolean first) {
            dsTaint.addTaint(first);
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
                Node<K, V> var83B74AA9D3A2FC2A95056081BE86827F_953664084 = (bound(node, NO_BOUND, toBound));
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
                Node<K, V> var0C5D193A5BFBF64BBA8D6E7FB91219A8_701202172 = (bound(node, fromBound, NO_BOUND));
            } //End block
            return (Node<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.096 -0400", hash_original_method = "4CDC04225A960E79B8311D7465BD3125", hash_generated_method = "3F8ABC85D7A0FF9A532B33CFFCED02C0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private Entry<K, V> findBounded(K key, Relation relation) {
            dsTaint.addTaint(relation.dsTaint);
            dsTaint.addTaint(key.dsTaint);
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
            Entry<K, V> varC4960990CFB3B4F10B005DBFC572F18B_1955243642 = (bound(find(key, relation), fromBoundForCheck, toBoundForCheck));
            return (Entry<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.096 -0400", hash_original_method = "BD9CF59DC295A4AE3510934F298E27E6", hash_generated_method = "88EE310DE7D4458DD141AF413E105644")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Entry<K, V> lowerEntry(K key) {
            dsTaint.addTaint(key.dsTaint);
            Entry<K, V> var49E3C017DDA5E77A73FD777A1A941CFE_825243445 = (immutableCopy(findBounded(key, LOWER)));
            return (Entry<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return immutableCopy(findBounded(key, LOWER));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.096 -0400", hash_original_method = "EBA87E3AFD9E90051DFFEBD0117773EA", hash_generated_method = "0E2F8C95E0EA91760C232B54ACD7EB27")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K lowerKey(K key) {
            dsTaint.addTaint(key.dsTaint);
            Entry<K, V> entry;
            entry = findBounded(key, LOWER);
            {
                Object var89F8384D8DD2CA583B7A90F311F2A4B1_612766065 = (entry.getKey());
            } //End flattened ternary
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Entry<K, V> entry = findBounded(key, LOWER);
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.096 -0400", hash_original_method = "581C54D570AF4193E6400C576ED95C35", hash_generated_method = "DA69E556E6AE51B5BA514542A58DF028")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Entry<K, V> floorEntry(K key) {
            dsTaint.addTaint(key.dsTaint);
            Entry<K, V> var53162E819F91269ADC18976393EA39D9_630288828 = (immutableCopy(findBounded(key, FLOOR)));
            return (Entry<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return immutableCopy(findBounded(key, FLOOR));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.097 -0400", hash_original_method = "E92237DAC033388A5150FD58D66D705D", hash_generated_method = "8AFEC388871A83A895A6DAAFABCECB0A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K floorKey(K key) {
            dsTaint.addTaint(key.dsTaint);
            Entry<K, V> entry;
            entry = findBounded(key, FLOOR);
            {
                Object var89F8384D8DD2CA583B7A90F311F2A4B1_324774483 = (entry.getKey());
            } //End flattened ternary
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Entry<K, V> entry = findBounded(key, FLOOR);
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.097 -0400", hash_original_method = "C11821BD096982DAE03E94867B2C92BE", hash_generated_method = "7EBE413BBD66F07E042BE04A3CE03B00")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Entry<K, V> ceilingEntry(K key) {
            dsTaint.addTaint(key.dsTaint);
            Entry<K, V> varF829DF5632FF7CC677B851446FA8358F_2017586811 = (immutableCopy(findBounded(key, CEILING)));
            return (Entry<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return immutableCopy(findBounded(key, CEILING));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.097 -0400", hash_original_method = "01AF63D6DC81CC48D8C6B0BE37F83B4D", hash_generated_method = "186583C524B4BEBFFBA54FB491D0FDBF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K ceilingKey(K key) {
            dsTaint.addTaint(key.dsTaint);
            Entry<K, V> entry;
            entry = findBounded(key, CEILING);
            {
                Object var89F8384D8DD2CA583B7A90F311F2A4B1_1509505754 = (entry.getKey());
            } //End flattened ternary
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Entry<K, V> entry = findBounded(key, CEILING);
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.097 -0400", hash_original_method = "4DE66AB7FA66EBE29F4E4509967D65D0", hash_generated_method = "8EF843774233939CEF8FCAB596921C77")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Entry<K, V> higherEntry(K key) {
            dsTaint.addTaint(key.dsTaint);
            Entry<K, V> var5017B9B4B55FC3DCD39FDB020AD9AC2B_1265099580 = (immutableCopy(findBounded(key, HIGHER)));
            return (Entry<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return immutableCopy(findBounded(key, HIGHER));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.098 -0400", hash_original_method = "47A499322D06CDAFFEC1D4DA0A079F0A", hash_generated_method = "5F4B50CD82BC4C1AB485E8E43E269F06")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K higherKey(K key) {
            dsTaint.addTaint(key.dsTaint);
            Entry<K, V> entry;
            entry = findBounded(key, HIGHER);
            {
                Object var89F8384D8DD2CA583B7A90F311F2A4B1_15964710 = (entry.getKey());
            } //End flattened ternary
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Entry<K, V> entry = findBounded(key, HIGHER);
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.098 -0400", hash_original_method = "631801B6DE22632DEACA2B547DEBE43A", hash_generated_method = "DCC9EF0DC9693EF434A64D8F3F58FA75")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Comparator<? super K> comparator() {
            {
                Comparator<? super K> var4EFCFF1E7C20902B6A370F2A482D639F_1936795603 = (TreeMap.this.comparator());
            } //End block
            {
                Comparator<? super K> var7777CBBA6524383189220439D91F8386_238385322 = (Collections.reverseOrder(comparator));
            } //End block
            return (Comparator<? super K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (ascending) {
            //return TreeMap.this.comparator();
          //} else {
            //return Collections.reverseOrder(comparator);
          //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.098 -0400", hash_original_method = "7F86A739037DCA8312EEE2819E1107F8", hash_generated_method = "9F75123D0491AC30197F9A90E935C696")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Set<Entry<K, V>> entrySet() {
            BoundedEntrySet result;
            result = entrySet;
            {
                Object var06F56A3E1A72792A058B617DFBC26BAF_86314608 = ((entrySet = new BoundedEntrySet()));
            } //End flattened ternary
            return (Set<Entry<K, V>>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //BoundedEntrySet result = entrySet;
            //return result != null ? result : (entrySet = new BoundedEntrySet());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.098 -0400", hash_original_method = "8D1D053C1D8B0756868AB879DB7CB086", hash_generated_method = "E5AC29E57881C53B0F635E8723E7526A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Set<K> keySet() {
            Set<K> varC031E4767BC23709B128EF5E3409EAEC_68761200 = (navigableKeySet());
            return (Set<K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.099 -0400", hash_original_method = "58209BC6FD1C6420A0C3CE4B441A6EA8", hash_generated_method = "AF938661676FFF52AC8E53D11AFF10FF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NavigableSet<K> navigableKeySet() {
            BoundedKeySet result;
            result = keySet;
            {
                Object var432629C1BD30DF87707253BD52D0E68C_1500469157 = ((keySet = new BoundedKeySet()));
            } //End flattened ternary
            return (NavigableSet<K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //BoundedKeySet result = keySet;
            //return result != null ? result : (keySet = new BoundedKeySet());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.099 -0400", hash_original_method = "6D358EC631E9E279A9C759613AD4CBF5", hash_generated_method = "A61AAC83FA2485F7099BD48D3431CA28")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NavigableMap<K, V> descendingMap() {
            NavigableMap<K, V> var18870BEBD48F8C3BF33CF82C41710D31_478832557 = (new BoundedMap(!ascending, from, fromBound, to, toBound));
            return (NavigableMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new BoundedMap(!ascending, from, fromBound, to, toBound);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.099 -0400", hash_original_method = "E068C75BD35AA3BEC427F457C352E2B5", hash_generated_method = "8AFCE2484B00ED9109E41532557893DA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NavigableSet<K> descendingKeySet() {
            NavigableSet<K> var90AC92C6A05DE7658D745EA746EA20FC_1406825324 = (new BoundedMap(!ascending, from, fromBound, to, toBound).navigableKeySet());
            return (NavigableSet<K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new BoundedMap(!ascending, from, fromBound, to, toBound).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.099 -0400", hash_original_method = "3DC9A98D108EA5F857802D111DD4C7BC", hash_generated_method = "A69B789FCD23975D389CA6B56C5DDF0B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NavigableMap<K, V> subMap(K from, boolean fromInclusive, K to, boolean toInclusive) {
            dsTaint.addTaint(to.dsTaint);
            dsTaint.addTaint(fromInclusive);
            dsTaint.addTaint(toInclusive);
            dsTaint.addTaint(from.dsTaint);
            Bound fromBound;
            fromBound = INCLUSIVE;
            fromBound = EXCLUSIVE;
            Bound toBound;
            toBound = INCLUSIVE;
            toBound = EXCLUSIVE;
            NavigableMap<K, V> var20B592584BC039D7D72F3E40688B285C_570226044 = (subMap(from, fromBound, to, toBound));
            return (NavigableMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Bound fromBound = fromInclusive ? INCLUSIVE : EXCLUSIVE;
            //Bound toBound = toInclusive ? INCLUSIVE : EXCLUSIVE;
            //return subMap(from, fromBound, to, toBound);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.099 -0400", hash_original_method = "85C9C855FCFD7C01DE62316D427AA356", hash_generated_method = "948661A1EA6369346A235AE56BD3051D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NavigableMap<K, V> subMap(K fromInclusive, K toExclusive) {
            dsTaint.addTaint(fromInclusive.dsTaint);
            dsTaint.addTaint(toExclusive.dsTaint);
            NavigableMap<K, V> var74A6890EEA15D328BE1DF402367AC3EE_452789307 = (subMap(fromInclusive, INCLUSIVE, toExclusive, EXCLUSIVE));
            return (NavigableMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return subMap(fromInclusive, INCLUSIVE, toExclusive, EXCLUSIVE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.099 -0400", hash_original_method = "F0BAF6F2CF2FCD82E483E31B5C869204", hash_generated_method = "4EC5BB74C7D913747AF5813073A2D1D3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NavigableMap<K, V> headMap(K to, boolean inclusive) {
            dsTaint.addTaint(inclusive);
            dsTaint.addTaint(to.dsTaint);
            Bound toBound;
            toBound = INCLUSIVE;
            toBound = EXCLUSIVE;
            NavigableMap<K, V> varE2521AFD311C1CF75C9D0C3A25FC2174_1853405018 = (subMap(null, NO_BOUND, to, toBound));
            return (NavigableMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Bound toBound = inclusive ? INCLUSIVE : EXCLUSIVE;
            //return subMap(null, NO_BOUND, to, toBound);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.100 -0400", hash_original_method = "ABFE13DC9073E46E049BB999D5306953", hash_generated_method = "911A78D7A87E181A9A0040D4ED6A7047")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NavigableMap<K, V> headMap(K toExclusive) {
            dsTaint.addTaint(toExclusive.dsTaint);
            NavigableMap<K, V> var161932101AABB5B600CE7FDA25BE03E6_1200792995 = (subMap(null, NO_BOUND, toExclusive, EXCLUSIVE));
            return (NavigableMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return subMap(null, NO_BOUND, toExclusive, EXCLUSIVE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.100 -0400", hash_original_method = "26986665A8C827C93D404190F2752B4C", hash_generated_method = "6CD97C1F66C79CF2279DCBF895545796")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NavigableMap<K, V> tailMap(K from, boolean inclusive) {
            dsTaint.addTaint(inclusive);
            dsTaint.addTaint(from.dsTaint);
            Bound fromBound;
            fromBound = INCLUSIVE;
            fromBound = EXCLUSIVE;
            NavigableMap<K, V> var3BB4FB5B1FEFA64BF14D2559066721EE_1396331651 = (subMap(from, fromBound, null, NO_BOUND));
            return (NavigableMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Bound fromBound = inclusive ? INCLUSIVE : EXCLUSIVE;
            //return subMap(from, fromBound, null, NO_BOUND);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.100 -0400", hash_original_method = "CF387452C0473BBA846F53D5C56CE3B2", hash_generated_method = "DB79E2033688391008197D0C44FC1E72")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NavigableMap<K, V> tailMap(K fromInclusive) {
            dsTaint.addTaint(fromInclusive.dsTaint);
            NavigableMap<K, V> varEA6F137E8B17463734F984DED03116AD_1763790356 = (subMap(fromInclusive, INCLUSIVE, null, NO_BOUND));
            return (NavigableMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return subMap(fromInclusive, INCLUSIVE, null, NO_BOUND);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.100 -0400", hash_original_method = "0BE57F9811CA6209D3A6FF727B140802", hash_generated_method = "56BC1744F40CE90C04A2F66065C56614")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private NavigableMap<K, V> subMap(K from, Bound fromBound, K to, Bound toBound) {
            dsTaint.addTaint(to.dsTaint);
            dsTaint.addTaint(toBound.dsTaint);
            dsTaint.addTaint(fromBound.dsTaint);
            dsTaint.addTaint(from.dsTaint);
            {
                K fromTmp;
                fromTmp = from;
                Bound fromBoundTmp;
                fromBoundTmp = fromBound;
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
                    boolean var1DAE628D732342D7BC54FD4D3278CE34_936483585 = (!isInBounds(from, fromBoundToCheck, this.toBound));
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
                    boolean var5922B8A01789147118CB04C1CDD52F79_415662145 = (!isInBounds(to, this.fromBound, toBoundToCheck));
                    {
                        if (DroidSafeAndroidRuntime.control) throw outOfBounds(to, this.fromBound, toBoundToCheck);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            NavigableMap<K, V> var3501FCD90E7637D59099A57F1C35DD98_908533662 = (new BoundedMap(ascending, from, fromBound, to, toBound));
            return (NavigableMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.101 -0400", hash_original_method = "65FB71F2A366D35F7884C2869AFAA6ED", hash_generated_method = "F0A2058DC3BF29DF844758A06E1AD410")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private IllegalArgumentException outOfBounds(Object value, Bound fromBound, Bound toBound) {
            dsTaint.addTaint(toBound.dsTaint);
            dsTaint.addTaint(fromBound.dsTaint);
            dsTaint.addTaint(value.dsTaint);
            IllegalArgumentException varA0438CE0741623F7F68D8DC9E3FC3D30_702004917 = (new IllegalArgumentException(value + " not in range "
                    + fromBound.leftCap(from) + ".." + toBound.rightCap(to)));
            return (IllegalArgumentException)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new IllegalArgumentException(value + " not in range "
                    //+ fromBound.leftCap(from) + ".." + toBound.rightCap(to));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.101 -0400", hash_original_method = "9F20C8CFE1A741092D9743A31C3F8586", hash_generated_method = "B59530F3290E978D19FCF087E2C35D6E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Object writeReplace() throws ObjectStreamException {
            {
                Object var379F03EFEF9609B6C095C3B1E12D5202_810617283 = (new AscendingSubMap<K, V>(TreeMap.this, from, fromBound, to, toBound));
                Object varF62D8F0697F67B2C19C54935F9D16A63_134872117 = (new DescendingSubMap<K, V>(TreeMap.this, from, fromBound, to, toBound));
            } //End flattened ternary
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ascending
                    //? new AscendingSubMap<K, V>(TreeMap.this, from, fromBound, to, toBound)
                    //: new DescendingSubMap<K, V>(TreeMap.this, from, fromBound, to, toBound);
        }

        
        abstract class BoundedIterator<T> extends MapIterator<T> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.101 -0400", hash_original_method = "30CDAF663F351A84269F6FB0B072EFA9", hash_generated_method = "1F3D2FED93AFB92C7193318D60F1D705")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            protected BoundedIterator(Node<K, V> next) {
                super(next);
                dsTaint.addTaint(next.dsTaint);
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.101 -0400", hash_original_method = "E9206CF01CB691A7CC292AD03FA9736C", hash_generated_method = "E12CEE4F45CF2FA7D2AC1AB9562960AD")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            protected Node<K, V> stepForward() {
                Node<K, V> result;
                result = super.stepForward();
                {
                    boolean varB492F846C21C09F0364F2416324ABD06_1832656153 = (next != null && !isInBounds(next.key, NO_BOUND, toBound));
                    {
                        next = null;
                    } //End block
                } //End collapsed parenthetic
                return (Node<K, V>)dsTaint.getTaint();
                // ---------- Original Method ----------
                //Node<K, V> result = super.stepForward();
                //if (next != null && !isInBounds(next.key, NO_BOUND, toBound)) {
                    //next = null;
                //}
                //return result;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.102 -0400", hash_original_method = "E55F6A3E56D317586EA4F65D3F74D30B", hash_generated_method = "7EEA4005609A91A9AB370A57540D71EF")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            protected Node<K, V> stepBackward() {
                Node<K, V> result;
                result = super.stepBackward();
                {
                    boolean varA14FF8A4CC2199BAF982AB4CC94D03CC_1087007916 = (next != null && !isInBounds(next.key, fromBound, NO_BOUND));
                    {
                        next = null;
                    } //End block
                } //End collapsed parenthetic
                return (Node<K, V>)dsTaint.getTaint();
                // ---------- Original Method ----------
                //Node<K, V> result = super.stepBackward();
                //if (next != null && !isInBounds(next.key, fromBound, NO_BOUND)) {
                    //next = null;
                //}
                //return result;
            }

            
        }


        
        final class BoundedEntrySet extends AbstractSet<Entry<K, V>> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.102 -0400", hash_original_method = "C4340F1CFE2D477525C4902F551FF57B", hash_generated_method = "C4340F1CFE2D477525C4902F551FF57B")
                        public BoundedEntrySet ()
            {
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.102 -0400", hash_original_method = "29BBB3BE9EA7B6D6C0B83C28F05082A4", hash_generated_method = "F98925567BD0A212C53B4A59124C9C86")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public int size() {
                int var69D9F234E7E76618743D3D698A58599B_1814062775 = (BoundedMap.this.size());
                return dsTaint.getTaintInt();
                // ---------- Original Method ----------
                //return BoundedMap.this.size();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.102 -0400", hash_original_method = "AEA447F4A69E282FABF93736832EBAA3", hash_generated_method = "EC8E83D5E943845D9F28661618C5695C")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean isEmpty() {
                boolean varF1E2DF8AD3E4C9C508E293B19251E66A_1483861962 = (BoundedMap.this.isEmpty());
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return BoundedMap.this.isEmpty();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.102 -0400", hash_original_method = "0E267F64AB80178C28467CD978AC79C8", hash_generated_method = "38EA8D422DFACB8408E0B164AEC15B5F")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public Iterator<Entry<K, V>> iterator() {
                Iterator<Entry<K, V>> varE7617E70A9F4D611390AF871C24ED537_755809542 = (new BoundedIterator<Entry<K, V>>(endpoint(true)) {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.102 -0400", hash_original_method = "336D5542BA5231E0955145F5F84B4BBD", hash_generated_method = "F3C3D41F23E60954AB7B818439C8CE9D")
                    //DSFIXME:  CODE0002: Requires DSC value to be set
                    public Entry<K, V> next() {
                        {
                            Object var0045FF2416F55F1A6AC2E6F16F72D4A4_619410021 = (stepForward());
                            Object varC6A5586ABEB8963BE954F8D1901250EE_62643155 = (stepBackward());
                        } //End flattened ternary
                        return (Entry<K, V>)dsTaint.getTaint();
                        // ---------- Original Method ----------
                        //return ascending ? stepForward() : stepBackward();
                    }
});
                return (Iterator<Entry<K, V>>)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new BoundedIterator<Entry<K, V>>(endpoint(true)) {
                    //public Entry<K, V> next() {
                        //return ascending ? stepForward() : stepBackward();
                    //}
                //};
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.103 -0400", hash_original_method = "954A21A7B25CC1709817AC62B8C6864E", hash_generated_method = "4C5CA153F07398DC97020B4EC8F39A6D")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean contains(Object o) {
                dsTaint.addTaint(o.dsTaint);
                Entry<?, ?> entry;
                entry = (Entry<?, ?>) o;
                boolean varC238596BFA0BDAC8F31141888DBD9FC9_1921699082 = (isInBounds(entry.getKey()) && findByEntry(entry) != null);
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //if (!(o instanceof Entry)) {
                    //return false;
                //}
                //Entry<?, ?> entry = (Entry<?, ?>) o;
                //return isInBounds(entry.getKey()) && findByEntry(entry) != null;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.103 -0400", hash_original_method = "EF59D88655EE445530DBDC219FDD1A5F", hash_generated_method = "5430BF43AF1D5B70A052174D140DCA69")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean remove(Object o) {
                dsTaint.addTaint(o.dsTaint);
                Entry<?, ?> entry;
                entry = (Entry<?, ?>) o;
                boolean var155AF0A9D9B42FB9DF7C214F267A7E1B_1846614260 = (isInBounds(entry.getKey()) && TreeMap.this.entrySet().remove(entry));
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //if (!(o instanceof Entry)) {
                    //return false;
                //}
                //Entry<?, ?> entry = (Entry<?, ?>) o;
                //return isInBounds(entry.getKey()) && TreeMap.this.entrySet().remove(entry);
            }

            
        }


        
        final class BoundedKeySet extends AbstractSet<K> implements NavigableSet<K> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.103 -0400", hash_original_method = "E2D3F876A53715BED290C7F87B02539C", hash_generated_method = "E2D3F876A53715BED290C7F87B02539C")
                        public BoundedKeySet ()
            {
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.103 -0400", hash_original_method = "29BBB3BE9EA7B6D6C0B83C28F05082A4", hash_generated_method = "02D90F70BE15EA2E38D315279F221B17")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public int size() {
                int var69D9F234E7E76618743D3D698A58599B_1735925201 = (BoundedMap.this.size());
                return dsTaint.getTaintInt();
                // ---------- Original Method ----------
                //return BoundedMap.this.size();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.103 -0400", hash_original_method = "AEA447F4A69E282FABF93736832EBAA3", hash_generated_method = "CB0F306C08E31D6962E48E658C920D10")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean isEmpty() {
                boolean varF1E2DF8AD3E4C9C508E293B19251E66A_2114749713 = (BoundedMap.this.isEmpty());
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return BoundedMap.this.isEmpty();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.106 -0400", hash_original_method = "8539DDED7A19368CB3D09440D6A62269", hash_generated_method = "EED610CB0AF25A133F33CE4A3B75EFA4")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public Iterator<K> iterator() {
                Iterator<K> var4101BDC7221B43B8EF249F98965F3739_779190608 = (new BoundedIterator<K>(endpoint(true)) {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.106 -0400", hash_original_method = "3A3F5ECB2E6902CB8A6D0DE3222F8B33", hash_generated_method = "650C6369C4BF2E02AB9A7073F4D241DC")
                    //DSFIXME:  CODE0002: Requires DSC value to be set
                    public K next() {
                        K var3265F7DEA8317691510BFB56F433AA22_432377952 = ((ascending ? stepForward() : stepBackward()).key); //DSFIXME:  CODE0008: Nested ternary operator in expression
                        return (K)dsTaint.getTaint();
                        // ---------- Original Method ----------
                        //return (ascending ? stepForward() : stepBackward()).key;
                    }
});
                return (Iterator<K>)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new BoundedIterator<K>(endpoint(true)) {
                    //public K next() {
                        //return (ascending ? stepForward() : stepBackward()).key;
                    //}
                //};
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.106 -0400", hash_original_method = "74923548E6D3A508C57DDA053BC0EE64", hash_generated_method = "E20C1C0CA76D7875A8B0F81AF5EDB9A4")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Iterator<K> descendingIterator() {
                Iterator<K> var320B2E7C741042E53FDFAEE3FE0ED30B_662348584 = (new BoundedIterator<K>(endpoint(false)) {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.106 -0400", hash_original_method = "3DCBF0E7821BEEE7C84D65AF30CA29D6", hash_generated_method = "C97B18846247940392A2480EEF190259")
                    //DSFIXME:  CODE0002: Requires DSC value to be set
                    public K next() {
                        K var86F7170DA1165040324167B1674F15D4_1771632358 = ((ascending ? stepBackward() : stepForward()).key); //DSFIXME:  CODE0008: Nested ternary operator in expression
                        return (K)dsTaint.getTaint();
                        // ---------- Original Method ----------
                        //return (ascending ? stepBackward() : stepForward()).key;
                    }
});
                return (Iterator<K>)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new BoundedIterator<K>(endpoint(false)) {
                    //public K next() {
                        //return (ascending ? stepBackward() : stepForward()).key;
                    //}
                //};
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.106 -0400", hash_original_method = "F2816D590B9E0F32B93C47AB444AEEED", hash_generated_method = "1990EB443540C01A18788CAB0673DD81")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean contains(Object key) {
                dsTaint.addTaint(key.dsTaint);
                boolean varDEADC564C50A1257392A09A833F9988B_670286134 = (isInBounds(key) && findByObject(key) != null);
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return isInBounds(key) && findByObject(key) != null;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.107 -0400", hash_original_method = "ADEDE1B4ABE9B2F86F8B629056F35200", hash_generated_method = "A662F3E689FBDF44D90075A9F373E234")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean remove(Object key) {
                dsTaint.addTaint(key.dsTaint);
                boolean var55612E9AB490EF3FFBD38F202307B8D4_75999916 = (isInBounds(key) && removeInternalByKey(key) != null);
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return isInBounds(key) && removeInternalByKey(key) != null;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.107 -0400", hash_original_method = "3067DEE01FBBBFD061436C7D4561F434", hash_generated_method = "FB4172F3652B248FC55A25EBD0C11F8B")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public K first() {
                K varE22EDE26363A40A00EFF03C7035872E0_1306594022 = (firstKey());
                return (K)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return firstKey();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.107 -0400", hash_original_method = "4985BB63726B115899F1811F08E80BDF", hash_generated_method = "4CD00123A35E8189C2D8599D18B957BE")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public K pollFirst() {
                Entry<K, ?> entry;
                entry = pollFirstEntry();
                {
                    Object varD72C0ADBA213ED9F1E64858437A5A9A7_1634198410 = (entry.getKey());
                } //End flattened ternary
                return (K)dsTaint.getTaint();
                // ---------- Original Method ----------
                //Entry<K, ?> entry = pollFirstEntry();
                //return entry != null ? entry.getKey() : null;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.107 -0400", hash_original_method = "39C87F788E647BCD3FB86FFF34D7EF10", hash_generated_method = "545E80B5700B8C74EF417FA1C20F083F")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public K last() {
                K var1259CADB733D4F3EEEE72461A39A8456_1835167354 = (lastKey());
                return (K)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return lastKey();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.108 -0400", hash_original_method = "B202B1B2AAB477548F6A0AD72C9B1701", hash_generated_method = "9843C7F56760D091F296489686F4744B")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public K pollLast() {
                Entry<K, ?> entry;
                entry = pollLastEntry();
                {
                    Object varD72C0ADBA213ED9F1E64858437A5A9A7_1590921661 = (entry.getKey());
                } //End flattened ternary
                return (K)dsTaint.getTaint();
                // ---------- Original Method ----------
                //Entry<K, ?> entry = pollLastEntry();
                //return entry != null ? entry.getKey() : null;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.108 -0400", hash_original_method = "5CFE05BF706A06BBB501067306F1B9ED", hash_generated_method = "F2DDA5699EB9A95C0D6CE67DCD13DFF5")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public K lower(K key) {
                dsTaint.addTaint(key.dsTaint);
                K varC8CA35B34879A5BBD97ABB8E8EAD5EB1_531519109 = (lowerKey(key));
                return (K)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return lowerKey(key);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.108 -0400", hash_original_method = "10BABB7BB2E837824A13AAE89EE7EC6F", hash_generated_method = "A8EAFDA72DF50739CF6FB9531DB8DEFF")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public K floor(K key) {
                dsTaint.addTaint(key.dsTaint);
                K varD09AD4788238A5CED608A1BF0E5D1D7F_75027765 = (floorKey(key));
                return (K)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return floorKey(key);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.108 -0400", hash_original_method = "2AD4706A6D818B709A1E2CA64B48B4B9", hash_generated_method = "DD69780B6D62192AEC8AAAA340A59E09")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public K ceiling(K key) {
                dsTaint.addTaint(key.dsTaint);
                K var52D28137C5EDE984721BFD710675DC0F_634997772 = (ceilingKey(key));
                return (K)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return ceilingKey(key);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.108 -0400", hash_original_method = "8CC63649234BFC57DB10A2387AE34DD6", hash_generated_method = "3CC56D9380AF08146EA7B59EF21A2517")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public K higher(K key) {
                dsTaint.addTaint(key.dsTaint);
                K var27E969402503A92141B8193AA2FC438A_1665028204 = (higherKey(key));
                return (K)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return higherKey(key);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.108 -0400", hash_original_method = "C5DD330893039070B9523799F47D2DEB", hash_generated_method = "3941F11FC49C131156EA82ED6F581D4E")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Comparator<? super K> comparator() {
                Comparator<? super K> var00F595C821A260475D2C8A9157D79018_960788694 = (BoundedMap.this.comparator());
                return (Comparator<? super K>)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return BoundedMap.this.comparator();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.109 -0400", hash_original_method = "21039715CA3F916EA62F8064E71FC6CA", hash_generated_method = "A16596E1D6B714B7CB70F2A6CC5BA9F0")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public NavigableSet<K> subSet(K from, boolean fromInclusive, K to, boolean toInclusive) {
                dsTaint.addTaint(to.dsTaint);
                dsTaint.addTaint(fromInclusive);
                dsTaint.addTaint(toInclusive);
                dsTaint.addTaint(from.dsTaint);
                NavigableSet<K> var6CB83A4AEF7A36080313376C8A56BB48_1720816975 = (subMap(from, fromInclusive, to, toInclusive).navigableKeySet());
                return (NavigableSet<K>)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return subMap(from, fromInclusive, to, toInclusive).navigableKeySet();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.109 -0400", hash_original_method = "AA0E5149ADFB9D8316CC8EA86FBC0B9E", hash_generated_method = "47505987AAC829A3B6A5CAD4ADC85E10")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public SortedSet<K> subSet(K fromInclusive, K toExclusive) {
                dsTaint.addTaint(fromInclusive.dsTaint);
                dsTaint.addTaint(toExclusive.dsTaint);
                SortedSet<K> var979679B636B038708723E255D7275809_1140132194 = (subMap(fromInclusive, toExclusive).navigableKeySet());
                return (SortedSet<K>)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return subMap(fromInclusive, toExclusive).navigableKeySet();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.109 -0400", hash_original_method = "EDDD3784AC7E9834A18CCB5F2AE27346", hash_generated_method = "9671BD7B8E87234FFD51C21FB99362CA")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public NavigableSet<K> headSet(K to, boolean inclusive) {
                dsTaint.addTaint(inclusive);
                dsTaint.addTaint(to.dsTaint);
                NavigableSet<K> varA465CE6FE43AAA87C98D7E92F4EA614A_939602319 = (headMap(to, inclusive).navigableKeySet());
                return (NavigableSet<K>)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return headMap(to, inclusive).navigableKeySet();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.109 -0400", hash_original_method = "85EE899AF4D85617CB858518BA70EA12", hash_generated_method = "9914CFFF1AED60819986B06FCF666FE9")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public SortedSet<K> headSet(K toExclusive) {
                dsTaint.addTaint(toExclusive.dsTaint);
                SortedSet<K> var78B614F54CD75B1427B0E4001EC03FD2_810315507 = (headMap(toExclusive).navigableKeySet());
                return (SortedSet<K>)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return headMap(toExclusive).navigableKeySet();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.109 -0400", hash_original_method = "B964A303D464756EDD8E9C26A8D54411", hash_generated_method = "1D938DB872BF266D6C4E694DECB0DEA0")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public NavigableSet<K> tailSet(K from, boolean inclusive) {
                dsTaint.addTaint(inclusive);
                dsTaint.addTaint(from.dsTaint);
                NavigableSet<K> var1BB4478007407ED929DB1EA901876653_202672749 = (tailMap(from, inclusive).navigableKeySet());
                return (NavigableSet<K>)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return tailMap(from, inclusive).navigableKeySet();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.110 -0400", hash_original_method = "9536952691BDDFD3D8EFB20A3BD9AE85", hash_generated_method = "3EE659A8AEC5E4F7BB09D036C9F90BFC")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public SortedSet<K> tailSet(K fromInclusive) {
                dsTaint.addTaint(fromInclusive.dsTaint);
                SortedSet<K> varAD280FBA9CC1A4E49367439FCC9998BF_973348892 = (tailMap(fromInclusive).navigableKeySet());
                return (SortedSet<K>)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return tailMap(fromInclusive).navigableKeySet();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.110 -0400", hash_original_method = "2BD89B2F5D5D75B5A66FC121E2BE77F9", hash_generated_method = "B600A6A7A9C161A29A6EFC9AAF9B47DD")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public NavigableSet<K> descendingSet() {
                NavigableSet<K> var26A6654EC6C38F80CE6F5BDE2CCE66DD_101153441 = (new BoundedMap(!ascending, from, fromBound, to, toBound).navigableKeySet());
                return (NavigableSet<K>)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new BoundedMap(!ascending, from, fromBound, to, toBound).navigableKeySet();
            }

            
        }


        
    }


    
    static abstract class NavigableSubMap<K, V> extends AbstractMap<K, V> implements Serializable {
        TreeMap<K, V> m;
        Object lo;
        Object hi;
        boolean fromStart;
        boolean toEnd;
        boolean loInclusive;
        boolean hiInclusive;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.110 -0400", hash_original_method = "C1ACA683FC5CFCA3BE29823730AC5B8B", hash_generated_method = "628F1F0FDEE3F980B1DE03B1D95ED3A3")
        @DSModeled(DSC.SAFE)
         NavigableSubMap(TreeMap<K, V> delegate, K from, Bound fromBound, K to, Bound toBound) {
            dsTaint.addTaint(to.dsTaint);
            dsTaint.addTaint(toBound.dsTaint);
            dsTaint.addTaint(fromBound.dsTaint);
            dsTaint.addTaint(from.dsTaint);
            dsTaint.addTaint(delegate.dsTaint);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.111 -0400", hash_original_method = "98169B5D59A5E61A69F2A37D56262114", hash_generated_method = "2ADCBE450663D97C27DD6FDDB9E616C8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Set<Entry<K, V>> entrySet() {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            return (Set<Entry<K, V>>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.111 -0400", hash_original_method = "6A8A4C8549808D70F841B9593D31A43F", hash_generated_method = "FCADCEB5A5C9CF0D7BB46D9AFAFE32DC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @SuppressWarnings("unchecked")
        protected Object readResolve() throws ObjectStreamException {
            Bound fromBound;
            fromBound = NO_BOUND;
            fromBound = (loInclusive ? INCLUSIVE : EXCLUSIVE);
            Bound toBound;
            toBound = NO_BOUND;
            toBound = (hiInclusive ? INCLUSIVE : EXCLUSIVE);
            boolean ascending;
            ascending = !(this instanceof DescendingSubMap);
            Object var08CC73B87B1675313039795FC1F9E93D_589870220 = (m.new BoundedMap(ascending, (K) lo, fromBound, (K) hi, toBound));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Bound fromBound = fromStart ? NO_BOUND : (loInclusive ? INCLUSIVE : EXCLUSIVE);
            //Bound toBound = toEnd ? NO_BOUND : (hiInclusive ? INCLUSIVE : EXCLUSIVE);
            //boolean ascending = !(this instanceof DescendingSubMap);
            //return m.new BoundedMap(ascending, (K) lo, fromBound, (K) hi, toBound);
        }

        
        private static final long serialVersionUID = -2102997345730753016L;
    }


    
    static class DescendingSubMap<K, V> extends NavigableSubMap<K, V> {
        Comparator<K> reverseComparator;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.111 -0400", hash_original_method = "FDAA1F4436CE129642763FB7A272001D", hash_generated_method = "179DAFDD9A9101078E482746F1A3E3B9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         DescendingSubMap(TreeMap<K, V> delegate, K from, Bound fromBound, K to, Bound toBound) {
            super(delegate, from, fromBound, to, toBound);
            dsTaint.addTaint(to.dsTaint);
            dsTaint.addTaint(toBound.dsTaint);
            dsTaint.addTaint(fromBound.dsTaint);
            dsTaint.addTaint(from.dsTaint);
            dsTaint.addTaint(delegate.dsTaint);
            // ---------- Original Method ----------
        }

        
        private static final long serialVersionUID = 912986545866120460L;
    }


    
    static class AscendingSubMap<K, V> extends NavigableSubMap<K, V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.111 -0400", hash_original_method = "C32F016187D7478ED63A0FCF56CB93EB", hash_generated_method = "DD1A7563C349F23CA446CE4F9D8F0999")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         AscendingSubMap(TreeMap<K, V> delegate, K from, Bound fromBound, K to, Bound toBound) {
            super(delegate, from, fromBound, to, toBound);
            dsTaint.addTaint(to.dsTaint);
            dsTaint.addTaint(toBound.dsTaint);
            dsTaint.addTaint(fromBound.dsTaint);
            dsTaint.addTaint(from.dsTaint);
            dsTaint.addTaint(delegate.dsTaint);
            // ---------- Original Method ----------
        }

        
        private static final long serialVersionUID = 912986545866124060L;
    }


    
    class SubMap extends AbstractMap<K, V> implements Serializable {
        Object fromKey;
        Object toKey;
        boolean fromStart;
        boolean toEnd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.112 -0400", hash_original_method = "1497E4A70A7CCC376BB7A4F5336DC150", hash_generated_method = "1497E4A70A7CCC376BB7A4F5336DC150")
                public SubMap ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.112 -0400", hash_original_method = "98169B5D59A5E61A69F2A37D56262114", hash_generated_method = "2ADCBE450663D97C27DD6FDDB9E616C8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Set<Entry<K, V>> entrySet() {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            return (Set<Entry<K, V>>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.112 -0400", hash_original_method = "AC95C6CC81DF8BD4B0519A49635D6CF0", hash_generated_method = "EC1D3B0A068E0326C9142A5BDC6B4968")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @SuppressWarnings("unchecked")
        protected Object readResolve() throws ObjectStreamException {
            Bound fromBound;
            fromBound = NO_BOUND;
            fromBound = INCLUSIVE;
            Bound toBound;
            toBound = NO_BOUND;
            toBound = EXCLUSIVE;
            Object var04CD6C0C3004889AA1E5E47A29853376_310038224 = (new BoundedMap(true, (K) fromKey, fromBound, (K) toKey, toBound));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Bound fromBound = fromStart ? NO_BOUND : INCLUSIVE;
            //Bound toBound = toEnd ? NO_BOUND : EXCLUSIVE;
            //return new BoundedMap(true, (K) fromKey, fromBound, (K) toKey, toBound);
        }

        
        private static final long serialVersionUID = -6520786458950516097L;
    }


    
    @SuppressWarnings("unchecked") private static final Comparator<Comparable> NATURAL_ORDER = new Comparator<Comparable>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.112 -0400", hash_original_method = "078A1DB9555D9E606EA5FF406F56B2E6", hash_generated_method = "D8D5524CBA6FBF6484703F07CF0B451F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int compare(Comparable a, Comparable b) {
            dsTaint.addTaint(b.dsTaint);
            dsTaint.addTaint(a.dsTaint);
            int varC15B2565AD7A5177ED0132648C5386D9_939511398 = (a.compareTo(b));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return a.compareTo(b);
        }

        
}; //Transformed anonymous class
    private static final long serialVersionUID = 919286545866124006L;
}

