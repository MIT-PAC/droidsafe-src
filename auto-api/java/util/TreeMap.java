package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    @SuppressWarnings("unchecked") private static final Comparator<Comparable> NATURAL_ORDER = new Comparator<Comparable>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.316 -0400", hash_original_method = "078A1DB9555D9E606EA5FF406F56B2E6", hash_generated_method = "A1E0A2E88D4F240572351BBA4CE1D88B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int compare(Comparable a, Comparable b) {
            dsTaint.addTaint(b.dsTaint);
            dsTaint.addTaint(a.dsTaint);
            int varC15B2565AD7A5177ED0132648C5386D9_20896876 = (a.compareTo(b));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return a.compareTo(b);
        }

        
}; //Transformed anonymous class
    Comparator<? super K> comparator;
    Node<K, V> root;
    int size = 0;
    int modCount = 0;
    private EntrySet entrySet;
    private KeySet keySet;
    private static final long serialVersionUID = 919286545866124006L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.316 -0400", hash_original_method = "A79D85B768A2B786B5F2ACD3F2B9D249", hash_generated_method = "E81AC7EA41F9B6B76565445C616D0071")
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    public TreeMap() {
        this.comparator = (Comparator<? super K>) NATURAL_ORDER;
        // ---------- Original Method ----------
        //this.comparator = (Comparator<? super K>) NATURAL_ORDER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.316 -0400", hash_original_method = "317880CC1AD8B8CC7D9C11CC941EE8C3", hash_generated_method = "7B3FC2E7D3AC67829009E365C610A88B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TreeMap(Map<? extends K, ? extends V> copyFrom) {
        this();
        dsTaint.addTaint(copyFrom.dsTaint);
        {
            Iterator<Map.Entry<? extends K, ? extends V>> seatecAstronomy42 = copyFrom.entrySet().iterator();
            seatecAstronomy42.hasNext();
            Map.Entry<? extends K, ? extends V> entry = seatecAstronomy42.next();
            {
                putInternal(entry.getKey(), entry.getValue());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (Map.Entry<? extends K, ? extends V> entry : copyFrom.entrySet()) {
            //putInternal(entry.getKey(), entry.getValue());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.316 -0400", hash_original_method = "C1FE892CAD9D3780A675F5A8CA11F4FA", hash_generated_method = "20614961B2EF56479D0ABC292FDED179")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.316 -0400", hash_original_method = "2607F9CE6A88866DC32D385287E67644", hash_generated_method = "76C3F1BF81D61EFF5F6541B97748DB83")
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
            Iterator<Map.Entry<K, ? extends V>> seatecAstronomy42 = copyFrom.entrySet().iterator();
            seatecAstronomy42.hasNext();
            Map.Entry<K, ? extends V> entry = seatecAstronomy42.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.316 -0400", hash_original_method = "FB8B1056739768AF92CF25DB3C2D30EB", hash_generated_method = "123A98EEFCA55ADC0B57C9A5ABB71B5C")
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
            throw new AssertionError();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.316 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "D93308C9204B4F7B72696D16CFAD067E")
    @DSModeled(DSC.SAFE)
    @Override
    public int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.317 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "F6C7B08EFA5C7EF5C4F8802990711F9E")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isEmpty() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return size == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.317 -0400", hash_original_method = "C35732A40B74AF28951D9E96FE33879B", hash_generated_method = "950DF4C4F081E273D1DCE11D552288D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public V get(Object key) {
        dsTaint.addTaint(key.dsTaint);
        Entry<K, V> entry;
        entry = findByObject(key);
        {
            Object varDDD7292C065899F2728EAD5CD98A4F68_446483930 = (entry.getValue());
        } //End flattened ternary
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Entry<K, V> entry = findByObject(key);
        //return entry != null ? entry.getValue() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.317 -0400", hash_original_method = "CD38E6D478445847B9B0A556F5E63837", hash_generated_method = "0354AD365B303134775F444A0E53854E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean containsKey(Object key) {
        dsTaint.addTaint(key.dsTaint);
        boolean var169B170947F44477F294694A95E8B219_49381484 = (findByObject(key) != null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return findByObject(key) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.317 -0400", hash_original_method = "09423F07E68B4770E107529B69AA8334", hash_generated_method = "F84922A33D5A81836C61AEA6C27A955C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public V put(K key, V value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        V var286DC1D6FE6BD99771DB62C242D34D70_832710014 = (putInternal(key, value));
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return putInternal(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.317 -0400", hash_original_method = "EA5BE6ED678D7376259BCC3DB1C01E21", hash_generated_method = "803FCE5C4CA01633E8F5F04594FAD7F7")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.317 -0400", hash_original_method = "0207194EB3BB344ADD94A18916C183DF", hash_generated_method = "971DE51A8C14D409EBEC34A39754159B")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.317 -0400", hash_original_method = "73D5DA91D47B13631BBA1FF4FFC14006", hash_generated_method = "3BA00511526DB18111F01FD77419F95E")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.317 -0400", hash_original_method = "A47B461F1595004F5F78D5AE91E8DCD0", hash_generated_method = "D788DD2D9D8F7D2AB0FBB38A08984D75")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Node<K, V> find(K key, Relation relation) {
        dsTaint.addTaint(relation.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        {
            {
                throw new ClassCastException(key.getClass().getName() + " is not Comparable");
            } //End block
            {
                root = new Node<K, V>(null, key);
                size = 1;
                modCount++;
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
                Node<K, V> var6A988A9BDC609329B721B0F5708527C0_232345925 = (nearest.prev());
                //End case LOWER 
                //Begin case HIGHER 
                Node<K, V> varDAA2591EEA78F448691CDB26099D1445_1932931808 = (nearest.next());
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
                Node<K, V> var6A988A9BDC609329B721B0F5708527C0_1182166330 = (nearest.prev());
                //End case LOWER FLOOR 
                //Begin case CREATE 
                Node<K, V> created;
                created = new Node<K, V>(nearest, key);
                //End case CREATE 
                //Begin case CREATE 
                nearest.left = created;
                //End case CREATE 
                //Begin case CREATE 
                size++;
                //End case CREATE 
                //Begin case CREATE 
                modCount++;
                //End case CREATE 
                //Begin case CREATE 
                rebalance(nearest, true);
                //End case CREATE 
            } //End block
            {
                //Begin case CEILING HIGHER 
                Node<K, V> varDAA2591EEA78F448691CDB26099D1445_1747871358 = (nearest.next());
                //End case CEILING HIGHER 
                //Begin case CREATE 
                Node<K, V> created;
                created = new Node<K, V>(nearest, key);
                //End case CREATE 
                //Begin case CREATE 
                nearest.right = created;
                //End case CREATE 
                //Begin case CREATE 
                size++;
                //End case CREATE 
                //Begin case CREATE 
                modCount++;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.318 -0400", hash_original_method = "C267D163E835004AE4803D9A2BC1E552", hash_generated_method = "2439A1DC598CA736095EECF89245AC5B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
     Node<K, V> findByObject(Object key) {
        dsTaint.addTaint(key.dsTaint);
        Node<K, V> var5F6F4D349557FD85F3DF8AD05D69DA1F_1695068922 = (find((K) key, EQUAL));
        return (Node<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return find((K) key, EQUAL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.318 -0400", hash_original_method = "8678505752B854905CFE7B96C4FE458B", hash_generated_method = "CC4D084908613B46FB7D4F6C311FA14A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.318 -0400", hash_original_method = "FAD76EC8E4C5DF9CCDE64BA514AC9743", hash_generated_method = "31B5C3A71CBF747A72AD3910B87CE560")
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
        size--;
        modCount++;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.318 -0400", hash_original_method = "C9B9883A6728DC2F4DBB90BDF61B9978", hash_generated_method = "B5A1E72EE83E02C890BBEDB825436897")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.318 -0400", hash_original_method = "8CBFE12E379E7871AFCE5B0FC5C284CB", hash_generated_method = "FFE564926B6C98A6426CFC75A0781AEE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.319 -0400", hash_original_method = "DE22B63E2A021BAF8A5DCC142FCC4B40", hash_generated_method = "16996F292209046B0AD78C5C0B5B75AF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.319 -0400", hash_original_method = "6326CB79DBF89391F00F9AB13B0E81D9", hash_generated_method = "E3354E25CF9CB7E46ED3DDDD16AD815C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.319 -0400", hash_original_method = "DF035E309292DEA6067E726F513C85C3", hash_generated_method = "D906E65456D41EFE1A0FBFA44DB1664E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.319 -0400", hash_original_method = "E2F61A98BB539F90A11465C6A8354CE5", hash_generated_method = "FAE9E276C0C283B33EA13B9091CF354C")
    @DSModeled(DSC.SAFE)
    private SimpleImmutableEntry<K, V> immutableCopy(Entry<K, V> entry) {
        dsTaint.addTaint(entry.dsTaint);
        return (SimpleImmutableEntry<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return entry == null ? null : new SimpleImmutableEntry<K, V>(entry);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.319 -0400", hash_original_method = "9F2AE61C584701540103A59451B8FA45", hash_generated_method = "A52AFC6F556F93DDB8340E52B6326B41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Entry<K, V> firstEntry() {
        Entry<K, V> var91697C82AF12979B72ED8D5517077B0E_137584764 = (immutableCopy(root == null ? null : root.first())); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return (Entry<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return immutableCopy(root == null ? null : root.first());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.319 -0400", hash_original_method = "2730A7A2197248AC3B653DF430BA3F4A", hash_generated_method = "D05C210030C4E24B8FF3BE5F1E2B11BF")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.319 -0400", hash_original_method = "1456A4986DE10120F25B46536C8BF169", hash_generated_method = "36D87B462E9418B3B159DA774205D222")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Entry<K, V> pollFirstEntry() {
        Entry<K, V> var2DD0DA1167DFD6680DF2814CCC0024FA_1203014218 = (immutableCopy(internalPollFirstEntry()));
        return (Entry<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return immutableCopy(internalPollFirstEntry());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.319 -0400", hash_original_method = "B0B89D697E050FAAC6816A6E8B1E56A4", hash_generated_method = "EF292B740BF49BCDEF69844C6F68BFC9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public K firstKey() {
        {
            throw new NoSuchElementException();
        } //End block
        K var808169D4062ACF553C2513AD3EE389E3_2122958798 = (root.first().getKey());
        return (K)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (root == null) {
            //throw new NoSuchElementException();
        //}
        //return root.first().getKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.319 -0400", hash_original_method = "9DDE470F0E6425136CCDC59F74FCDED6", hash_generated_method = "DA32C5B41EE8A51365AB4D272BD00A8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Entry<K, V> lastEntry() {
        Entry<K, V> varCB82AD30BDE1CF7B30FA2F2B8FFF1AF6_2117305080 = (immutableCopy(root == null ? null : root.last())); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return (Entry<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return immutableCopy(root == null ? null : root.last());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.320 -0400", hash_original_method = "A726E2736A4C282A51BDD8062FE5CCFA", hash_generated_method = "13843541D893234A036FDE262047BCB8")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.320 -0400", hash_original_method = "5064879999AB9A13D0821F605568F112", hash_generated_method = "9747F53EA3229433C1C97599C82C1297")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Entry<K, V> pollLastEntry() {
        Entry<K, V> var81CEC5DDB72A8FC1D52EAF1F2C6E1769_395238194 = (immutableCopy(internalPollLastEntry()));
        return (Entry<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return immutableCopy(internalPollLastEntry());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.320 -0400", hash_original_method = "9EE1928205B19C964D03E8011BB7E907", hash_generated_method = "3F97641990743F2C3F3B46FF826C7BDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public K lastKey() {
        {
            throw new NoSuchElementException();
        } //End block
        K varA55DE5EAFF8E2D4E1470238AFBDC1446_711395344 = (root.last().getKey());
        return (K)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (root == null) {
            //throw new NoSuchElementException();
        //}
        //return root.last().getKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.320 -0400", hash_original_method = "9D71F38DCAD7DBC2AA9FACCDA9CF4866", hash_generated_method = "A8C3D8732614527B9FA466E0CB02DF5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Entry<K, V> lowerEntry(K key) {
        dsTaint.addTaint(key.dsTaint);
        Entry<K, V> varF4B11A3A54D92CC29E1FEDB5BBEC8427_518677999 = (immutableCopy(find(key, LOWER)));
        return (Entry<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return immutableCopy(find(key, LOWER));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.320 -0400", hash_original_method = "BC9464ECC7239B355BB45B80204BADD6", hash_generated_method = "A4A560535BEF258FEB1763E4184DBB4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public K lowerKey(K key) {
        dsTaint.addTaint(key.dsTaint);
        Entry<K, V> entry;
        entry = find(key, LOWER);
        {
            Object var4B8D962F1524E92662DE034798AAC65A_2111191740 = (entry.getKey());
        } //End flattened ternary
        return (K)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Entry<K, V> entry = find(key, LOWER);
        //return entry != null ? entry.getKey() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.320 -0400", hash_original_method = "5D12D4D534218428856149792C7C973A", hash_generated_method = "587122C584EE67B148EA50410BFFEB29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Entry<K, V> floorEntry(K key) {
        dsTaint.addTaint(key.dsTaint);
        Entry<K, V> varAA00A36E7D90CF7484C2AA7BFB9036A1_1495420413 = (immutableCopy(find(key, FLOOR)));
        return (Entry<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return immutableCopy(find(key, FLOOR));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.320 -0400", hash_original_method = "9E3521C1E5D0BB4CA97E65B4B91FC561", hash_generated_method = "DCCBEFEB305F953A5648223202D88A67")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public K floorKey(K key) {
        dsTaint.addTaint(key.dsTaint);
        Entry<K, V> entry;
        entry = find(key, FLOOR);
        {
            Object var4B8D962F1524E92662DE034798AAC65A_711437429 = (entry.getKey());
        } //End flattened ternary
        return (K)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Entry<K, V> entry = find(key, FLOOR);
        //return entry != null ? entry.getKey() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.320 -0400", hash_original_method = "14BBCA12BBBC651385215255CDF3836D", hash_generated_method = "B6D9FBC703FCBF182E8808C2F2674C4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Entry<K, V> ceilingEntry(K key) {
        dsTaint.addTaint(key.dsTaint);
        Entry<K, V> var5FDAD4FEC5E903AD4D7C9B4926AF956C_691229795 = (immutableCopy(find(key, CEILING)));
        return (Entry<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return immutableCopy(find(key, CEILING));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.320 -0400", hash_original_method = "818E984E93F7F07D0C27D2493F11C2A5", hash_generated_method = "67E6A26A26EF70400EED625A39AC8216")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public K ceilingKey(K key) {
        dsTaint.addTaint(key.dsTaint);
        Entry<K, V> entry;
        entry = find(key, CEILING);
        {
            Object var4B8D962F1524E92662DE034798AAC65A_2128696893 = (entry.getKey());
        } //End flattened ternary
        return (K)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Entry<K, V> entry = find(key, CEILING);
        //return entry != null ? entry.getKey() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.320 -0400", hash_original_method = "AC2414FDDF42A1318F8CC45C80E09BC1", hash_generated_method = "E39E0C6C84EACAF12B57A22226A83445")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Entry<K, V> higherEntry(K key) {
        dsTaint.addTaint(key.dsTaint);
        Entry<K, V> varE7778894287DDB6FC47EE2D8B0DFA8E9_324650887 = (immutableCopy(find(key, HIGHER)));
        return (Entry<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return immutableCopy(find(key, HIGHER));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.320 -0400", hash_original_method = "0C080E769BA3B62EBC93442ECCB0FC7D", hash_generated_method = "32395B60568277D60AD3489AA08B371D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public K higherKey(K key) {
        dsTaint.addTaint(key.dsTaint);
        Entry<K, V> entry;
        entry = find(key, HIGHER);
        {
            Object var4B8D962F1524E92662DE034798AAC65A_371958439 = (entry.getKey());
        } //End flattened ternary
        return (K)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Entry<K, V> entry = find(key, HIGHER);
        //return entry != null ? entry.getKey() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.320 -0400", hash_original_method = "6A8618E17145F23513711DA8498038AE", hash_generated_method = "D05C28FF82A31A64F7BCDD5446697E90")
    @DSModeled(DSC.SAFE)
    public Comparator<? super K> comparator() {
        return (Comparator<? super K>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return comparator != NATURAL_ORDER ? comparator : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.320 -0400", hash_original_method = "D2C4C51D99D6D10356C2F96D116110D2", hash_generated_method = "120D8A17FFAA3BF0769AF8D914E9B1E9")
    @DSModeled(DSC.SAFE)
    @Override
    public Set<Entry<K, V>> entrySet() {
        EntrySet result;
        result = entrySet;
        return (Set<Entry<K, V>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //EntrySet result = entrySet;
        //return result != null ? result : (entrySet = new EntrySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.320 -0400", hash_original_method = "0E17D4043440FAA66222611D1AC45111", hash_generated_method = "BDE6D69066CA485B23D9029FE8E80F26")
    @DSModeled(DSC.SAFE)
    @Override
    public Set<K> keySet() {
        KeySet result;
        result = keySet;
        return (Set<K>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //KeySet result = keySet;
        //return result != null ? result : (keySet = new KeySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.320 -0400", hash_original_method = "016115EA38C293C7AAA8E892AEA754CA", hash_generated_method = "895A6C21165CDA354AE58BF8349C5D8F")
    @DSModeled(DSC.SAFE)
    public NavigableSet<K> navigableKeySet() {
        KeySet result;
        result = keySet;
        return (NavigableSet<K>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //KeySet result = keySet;
        //return result != null ? result : (keySet = new KeySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.321 -0400", hash_original_method = "DA6DE2093EE8DE46EE4576501F54E528", hash_generated_method = "D91AC1EDA981E7BB9E847A7A4A0066B8")
    @DSModeled(DSC.SAFE)
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
        return (NavigableMap<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Bound fromBound = fromInclusive ? INCLUSIVE : EXCLUSIVE;
        //Bound toBound = toInclusive ? INCLUSIVE : EXCLUSIVE;
        //return new BoundedMap(true, from, fromBound, to, toBound);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.321 -0400", hash_original_method = "193BA03007E91EBBDB489C20B60BFC88", hash_generated_method = "DFE633A5978AC939308E56265A38C872")
    @DSModeled(DSC.SAFE)
    public SortedMap<K, V> subMap(K fromInclusive, K toExclusive) {
        dsTaint.addTaint(fromInclusive.dsTaint);
        dsTaint.addTaint(toExclusive.dsTaint);
        return (SortedMap<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new BoundedMap(true, fromInclusive, INCLUSIVE, toExclusive, EXCLUSIVE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.321 -0400", hash_original_method = "FA312E74B0C04D741489E3323E0FFDFE", hash_generated_method = "5EB70B1129FB4BB34CC470B43D7422A2")
    @DSModeled(DSC.SAFE)
    public NavigableMap<K, V> headMap(K to, boolean inclusive) {
        dsTaint.addTaint(to.dsTaint);
        dsTaint.addTaint(inclusive);
        Bound toBound;
        toBound = INCLUSIVE;
        toBound = EXCLUSIVE;
        return (NavigableMap<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Bound toBound = inclusive ? INCLUSIVE : EXCLUSIVE;
        //return new BoundedMap(true, null, NO_BOUND, to, toBound);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.321 -0400", hash_original_method = "CAC178CA3C39A0AC08FB27C63F9A635C", hash_generated_method = "59B806C6ACB3C390039F2D8E5D125C8C")
    @DSModeled(DSC.SAFE)
    public SortedMap<K, V> headMap(K toExclusive) {
        dsTaint.addTaint(toExclusive.dsTaint);
        return (SortedMap<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new BoundedMap(true, null, NO_BOUND, toExclusive, EXCLUSIVE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.321 -0400", hash_original_method = "828BC950C20B857C189141DA99499F09", hash_generated_method = "8DF258A5E7FEAF353FF07818C92E9508")
    @DSModeled(DSC.SAFE)
    public NavigableMap<K, V> tailMap(K from, boolean inclusive) {
        dsTaint.addTaint(inclusive);
        dsTaint.addTaint(from.dsTaint);
        Bound fromBound;
        fromBound = INCLUSIVE;
        fromBound = EXCLUSIVE;
        return (NavigableMap<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Bound fromBound = inclusive ? INCLUSIVE : EXCLUSIVE;
        //return new BoundedMap(true, from, fromBound, null, NO_BOUND);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.321 -0400", hash_original_method = "79B47D2E0956F27B23E0B18E5FD19D6A", hash_generated_method = "F9ED6D72ECA39CD819848D69029FBFA3")
    @DSModeled(DSC.SAFE)
    public SortedMap<K, V> tailMap(K fromInclusive) {
        dsTaint.addTaint(fromInclusive.dsTaint);
        return (SortedMap<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new BoundedMap(true, fromInclusive, INCLUSIVE, null, NO_BOUND);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.321 -0400", hash_original_method = "5AD6A5A37D3C9366BEF11B75DC396D31", hash_generated_method = "CAEAACCC0C26E28D8526F48A03300073")
    @DSModeled(DSC.SAFE)
    public NavigableMap<K, V> descendingMap() {
        return (NavigableMap<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new BoundedMap(false, null, NO_BOUND, null, NO_BOUND);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.321 -0400", hash_original_method = "1207DF79B9959BCB242E95030D6177B0", hash_generated_method = "565CDF17E4B525253C14A6D90E810116")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NavigableSet<K> descendingKeySet() {
        NavigableSet<K> var788D31692CC1663DAFB1AB6BA92F5FF1_1335081852 = (new BoundedMap(false, null, NO_BOUND, null, NO_BOUND).navigableKeySet());
        return (NavigableSet<K>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new BoundedMap(false, null, NO_BOUND, null, NO_BOUND).navigableKeySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.321 -0400", hash_original_method = "FF9071DA9035F09D9A096319B6A6FDA6", hash_generated_method = "7C5B4DDB15F102DFA56E66C2F3366598")
    static int count(Iterator<?> iterator) {
        int count = 0;
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }
        return count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.321 -0400", hash_original_method = "BF81D129CE69F9BEB40CAD27F974F3C8", hash_generated_method = "9E3B38CE4A756DCA756B841E45E36704")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(ObjectOutputStream stream) throws IOException {
        dsTaint.addTaint(stream.dsTaint);
        stream.putFields().put("comparator", comparator != NATURAL_ORDER ? comparator : null);
        stream.writeFields();
        stream.writeInt(size);
        {
            Iterator<Map.Entry<K, V>> seatecAstronomy42 = entrySet().iterator();
            seatecAstronomy42.hasNext();
            Map.Entry<K, V> entry = seatecAstronomy42.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.321 -0400", hash_original_method = "4DE82E48A11AFCCB2DCFEAE704B1F475", hash_generated_method = "8A41D6FC1D1C1742AD81A0B274ABEE7D")
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
        final K key;
        V value;
        int height;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.321 -0400", hash_original_method = "62891C3DA898C4CAE2A216E3248BC6D0", hash_generated_method = "C1B445A367CB0EF20A88B48BD73C8A75")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.321 -0400", hash_original_method = "81E3C4E28B5839A0B87A03CA341E9BD1", hash_generated_method = "02774791B7CD764C30330C9CDFF0CE80")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.321 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "8797862276BB802C39794187DB372D9F")
        @DSModeled(DSC.SAFE)
        public K getKey() {
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return key;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.322 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "296B8D2ED309B616704C60943FB1CB71")
        @DSModeled(DSC.SAFE)
        public V getValue() {
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.322 -0400", hash_original_method = "B73895AEE255DB24C138E57D2456050E", hash_generated_method = "AEF3A6641E279E603C73CF735B20993A")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.322 -0400", hash_original_method = "08E0671CAB8873A0A05165CE64371DB8", hash_generated_method = "92ABD365FD792FE84CF5A3754F8939E7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object o) {
            dsTaint.addTaint(o.dsTaint);
            {
                Map.Entry other;
                other = (Map.Entry) o;
                boolean var7912CC5897005EB768B2514BECBB8DA1_1639777717 = ((key == null ? other.getKey() == null : key.equals(other.getKey()))
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.322 -0400", hash_original_method = "6416487D313DFCFD3052C01ADB883217", hash_generated_method = "113EFC45A67D02FADDA342B031B5DC5A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int var4B5981580A705D92ADA4BF72B6E1E3C5_823993388 = ((key == null ? 0 : key.hashCode())
                    ^ (value == null ? 0 : value.hashCode())); //DSFIXME:  CODE0008: Nested ternary operator in expression
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return (key == null ? 0 : key.hashCode())
                    //^ (value == null ? 0 : value.hashCode());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.322 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "D9CF5F2E91FFBBAC087C0CF3658AE8DF")
        @DSModeled(DSC.SAFE)
        @Override
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return key + "=" + value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.322 -0400", hash_original_method = "4A8921E3C940E88A3EF0004D6F064697", hash_generated_method = "E0EEE6BF422AF8E4A77E32DCCD7CFB3F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Node<K, V> next() {
            {
                Node<K, V> var2EF4FAB4BFD6E9F96FD38031DFD813CF_288052179 = (right.first());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.322 -0400", hash_original_method = "A5795D04699EE4D7981584600E0900FB", hash_generated_method = "5BDFFC2DDE2D1B8C79F757BA92435136")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Node<K, V> prev() {
            {
                Node<K, V> var79BDCF9DB0B2B23947BF70D4B1A1B748_41441596 = (left.last());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.322 -0400", hash_original_method = "4F7C0267C30B98E081694FF304478F8A", hash_generated_method = "CB84F60E5FE47498E40B1AC484BC1321")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.322 -0400", hash_original_method = "E5BF79B4B513B5631F4BBC9604CA3FC9", hash_generated_method = "4B78FA5D9735426BBB921F72DA4EDDD0")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.322 -0400", hash_original_method = "1934503C2038D80E73C2C0A3DE09B0C3", hash_generated_method = "A5E1A2DB95F67AAFB61F7C708F21E79F")
        @DSModeled(DSC.SAFE)
         MapIterator(Node<K, V> next) {
            dsTaint.addTaint(next.dsTaint);
            // ---------- Original Method ----------
            //this.next = next;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.322 -0400", hash_original_method = "5C1B7B0DA20667590A4D5C5559468A28", hash_generated_method = "EC2651A5000EBE9BAFA0FE5275271169")
        @DSModeled(DSC.SAFE)
        public boolean hasNext() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return next != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.322 -0400", hash_original_method = "85C80BB4AD318538DB8131E722149B15", hash_generated_method = "D1F87CEAA0E8E5F535CCEE3414E22AE0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected Node<K, V> stepForward() {
            {
                throw new NoSuchElementException();
            } //End block
            {
                throw new ConcurrentModificationException();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.323 -0400", hash_original_method = "A54C5D61E9DBD724A09A36F78C304124", hash_generated_method = "0813BF7AB5D52ECAD2E91054953720A6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected Node<K, V> stepBackward() {
            {
                throw new NoSuchElementException();
            } //End block
            {
                throw new ConcurrentModificationException();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.323 -0400", hash_original_method = "36CB2F7F3A40368DEE67850156136E6A", hash_generated_method = "05E0F8B23F899AB2038981A205ED4BED")
        @DSModeled(DSC.SAFE)
        public void remove() {
            {
                throw new IllegalStateException();
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.323 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "D93308C9204B4F7B72696D16CFAD067E")
        @DSModeled(DSC.SAFE)
        @Override
        public int size() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return size;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.323 -0400", hash_original_method = "B4D4FA13F54A295418FF58C47A14DDE9", hash_generated_method = "661197A2998FA96F6B00AFEAAE46D4DF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Iterator<Entry<K, V>> iterator() {
            Iterator<Entry<K, V>> var5E234ED1CBBA20F1AF1EC4A08DDDA17B_1723113086 = (new MapIterator<Entry<K, V>>(root == null ? null : root.first()) {
                public Entry<K, V> next() {
                    return stepForward();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.323 -0400", hash_original_method = "AAE5A29808B951CC80BD03F648B6A63A", hash_generated_method = "6AD96759DC0AA17E4AD0478B6C3CD29E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean contains(Object o) {
            dsTaint.addTaint(o.dsTaint);
            boolean var12117A785F30278636E2FCE711DC72F4_617621743 = (o instanceof Entry && findByEntry((Entry<?, ?>) o) != null);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return o instanceof Entry && findByEntry((Entry<?, ?>) o) != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.323 -0400", hash_original_method = "50402191313F22EA9CF206F14CC9A5A4", hash_generated_method = "C2B9A1B8659C81FF9C60A46CE99C935B")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.323 -0400", hash_original_method = "1CC2A082C181027407DFF573950B6D85", hash_generated_method = "12C6A2DA9EA8266C0F353E448257FC84")
        @DSModeled(DSC.SAFE)
        @Override
        public void clear() {
            TreeMap.this.clear();
            // ---------- Original Method ----------
            //TreeMap.this.clear();
        }

        
    }


    
    class KeySet extends AbstractSet<K> implements NavigableSet<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.323 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "D93308C9204B4F7B72696D16CFAD067E")
        @DSModeled(DSC.SAFE)
        @Override
        public int size() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return size;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.323 -0400", hash_original_method = "7A518595D7BAAD9E696AF11FE92FFDBE", hash_generated_method = "8E82205464BCAEFD9B83AAA7BBE10644")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Iterator<K> iterator() {
            Iterator<K> varF290663158A017B75F9B5EA4F4D7E219_50065729 = (new MapIterator<K>(root == null ? null : root.first()) {
                public K next() {
                    return stepForward().key;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.323 -0400", hash_original_method = "C8D968F3C5FE84BB3D2A53544A3D4B19", hash_generated_method = "CC7D6AF77CEFB9E85F282EDA909E3FF8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Iterator<K> descendingIterator() {
            Iterator<K> var35AB7FDC1160E5E4CC49747F55B602B7_1588409391 = (new MapIterator<K>(root == null ? null : root.last()) {
                public K next() {
                    return stepBackward().key;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.323 -0400", hash_original_method = "55474555B71DFC8666AC2B6E4F0261A5", hash_generated_method = "ED263E27A9C49C15CD753EF1290EA2D0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean contains(Object o) {
            dsTaint.addTaint(o.dsTaint);
            boolean var997BAB39B2F072D5CD66A271F3B6E196_1088200377 = (containsKey(o));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return containsKey(o);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.323 -0400", hash_original_method = "174345B10BAB0003712B28F94B9BEA53", hash_generated_method = "1CCDFFF54CC1AF7B9A4412DC25C226F1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean remove(Object key) {
            dsTaint.addTaint(key.dsTaint);
            boolean varE16D747D3226990FB8F8723539274182_1958706751 = (removeInternalByKey(key) != null);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return removeInternalByKey(key) != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.323 -0400", hash_original_method = "1CC2A082C181027407DFF573950B6D85", hash_generated_method = "12C6A2DA9EA8266C0F353E448257FC84")
        @DSModeled(DSC.SAFE)
        @Override
        public void clear() {
            TreeMap.this.clear();
            // ---------- Original Method ----------
            //TreeMap.this.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.323 -0400", hash_original_method = "E1A1305471DEE1FE749764F6E03BE3A0", hash_generated_method = "660E6DE7BD2AD29DA64EC6B622B7E8E9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Comparator<? super K> comparator() {
            Comparator<? super K> var2487665AC7A2CC89F64C1A7B4151CFFF_1100865823 = (TreeMap.this.comparator());
            return (Comparator<? super K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return TreeMap.this.comparator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.323 -0400", hash_original_method = "3067DEE01FBBBFD061436C7D4561F434", hash_generated_method = "B99DE89E1702A7097AE30E55959FD6F8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K first() {
            K varEA9ABE1AF2A9358BDAA77226B4553F9C_1738114282 = (firstKey());
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return firstKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.323 -0400", hash_original_method = "39C87F788E647BCD3FB86FFF34D7EF10", hash_generated_method = "0A30BD073486125752A1401EEB11D049")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K last() {
            K var4E5EB7D1078667D29EA70FAC2161BB72_271156651 = (lastKey());
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return lastKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.324 -0400", hash_original_method = "5CFE05BF706A06BBB501067306F1B9ED", hash_generated_method = "C6E1877E49EDBF43900ECC6BB229978D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K lower(K key) {
            dsTaint.addTaint(key.dsTaint);
            K var475BD0FCF76DB09FCE7B3689FBCF1B30_1872824880 = (lowerKey(key));
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return lowerKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.324 -0400", hash_original_method = "10BABB7BB2E837824A13AAE89EE7EC6F", hash_generated_method = "39D4FEF13846B3606FD49BA2C07675D2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K floor(K key) {
            dsTaint.addTaint(key.dsTaint);
            K var568F19E8CED46AB67D471C07AEF14D94_1326755913 = (floorKey(key));
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return floorKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.324 -0400", hash_original_method = "2AD4706A6D818B709A1E2CA64B48B4B9", hash_generated_method = "C214775DB45EA09A392F79DB0D6A2A79")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K ceiling(K key) {
            dsTaint.addTaint(key.dsTaint);
            K varE800CF10B89C185E918CFD2CE3432015_1257258669 = (ceilingKey(key));
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ceilingKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.324 -0400", hash_original_method = "8CC63649234BFC57DB10A2387AE34DD6", hash_generated_method = "A87D8C67FFE20D653327101A13123D7E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K higher(K key) {
            dsTaint.addTaint(key.dsTaint);
            K var3BD8F3923A952E40F404AE2D34B50021_686255937 = (higherKey(key));
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return higherKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.324 -0400", hash_original_method = "0E3C9584B722234668005FBA598A1EC0", hash_generated_method = "B2D318278DF35BAC20E2E7537BDCF31F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K pollFirst() {
            Entry<K, V> entry;
            entry = internalPollFirstEntry();
            {
                Object var89F8384D8DD2CA583B7A90F311F2A4B1_1648071775 = (entry.getKey());
            } //End flattened ternary
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Entry<K, V> entry = internalPollFirstEntry();
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.324 -0400", hash_original_method = "ABD0A1CFCFA4D3D1F242F2375F97811C", hash_generated_method = "B5E38E75DA7DD65698B1AED792C0A6B3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K pollLast() {
            Entry<K, V> entry;
            entry = internalPollLastEntry();
            {
                Object var89F8384D8DD2CA583B7A90F311F2A4B1_1251664055 = (entry.getKey());
            } //End flattened ternary
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Entry<K, V> entry = internalPollLastEntry();
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.324 -0400", hash_original_method = "21828DA90728B75367EF3BEE7D62C832", hash_generated_method = "312771357C5A95E0B5BB70037AE155B9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NavigableSet<K> subSet(K from, boolean fromInclusive, K to, boolean toInclusive) {
            dsTaint.addTaint(to.dsTaint);
            dsTaint.addTaint(fromInclusive);
            dsTaint.addTaint(toInclusive);
            dsTaint.addTaint(from.dsTaint);
            NavigableSet<K> varF92FE939FAADF410928C920688845576_298959627 = (TreeMap.this.subMap(from, fromInclusive, to, toInclusive).navigableKeySet());
            return (NavigableSet<K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return TreeMap.this.subMap(from, fromInclusive, to, toInclusive).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.324 -0400", hash_original_method = "B37C6130D4B0113815E317EEB111D1E9", hash_generated_method = "CD94798D8E93916E5AC2772255A6074A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SortedSet<K> subSet(K fromInclusive, K toExclusive) {
            dsTaint.addTaint(fromInclusive.dsTaint);
            dsTaint.addTaint(toExclusive.dsTaint);
            SortedSet<K> varC6FAFDAF1D0EB98F47E3BA77B4064028_538557725 = (TreeMap.this.subMap(fromInclusive, true, toExclusive, false).navigableKeySet());
            return (SortedSet<K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return TreeMap.this.subMap(fromInclusive, true, toExclusive, false).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.324 -0400", hash_original_method = "15C518A93EE21ED6E81237BD492369B4", hash_generated_method = "67F3D2F7C87058EE4D055332441B2DC8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NavigableSet<K> headSet(K to, boolean inclusive) {
            dsTaint.addTaint(to.dsTaint);
            dsTaint.addTaint(inclusive);
            NavigableSet<K> varB37A3AC42A2B1005AB3B277A761DA730_1676735408 = (TreeMap.this.headMap(to, inclusive).navigableKeySet());
            return (NavigableSet<K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return TreeMap.this.headMap(to, inclusive).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.324 -0400", hash_original_method = "1E1BD4D122D1F75D80BDC2474EF32137", hash_generated_method = "B8F58AC5CFF68501F5AAE29CC063D7AB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SortedSet<K> headSet(K toExclusive) {
            dsTaint.addTaint(toExclusive.dsTaint);
            SortedSet<K> var4A1C3A9FC62B2A3888489C1D3F44AFE1_559842908 = (TreeMap.this.headMap(toExclusive, false).navigableKeySet());
            return (SortedSet<K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return TreeMap.this.headMap(toExclusive, false).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.324 -0400", hash_original_method = "3007AE414049BD587DD344AEC05F7630", hash_generated_method = "1D0EE7C462BC6222437381D21CE16FB0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NavigableSet<K> tailSet(K from, boolean inclusive) {
            dsTaint.addTaint(inclusive);
            dsTaint.addTaint(from.dsTaint);
            NavigableSet<K> var79AC81160E828D49DCF9E0468A96BE96_807733259 = (TreeMap.this.tailMap(from, inclusive).navigableKeySet());
            return (NavigableSet<K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return TreeMap.this.tailMap(from, inclusive).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.324 -0400", hash_original_method = "4DA58A152F26E7271643C0314BDDDB69", hash_generated_method = "6E0741026D985906F591CDFA9A28BEC3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SortedSet<K> tailSet(K fromInclusive) {
            dsTaint.addTaint(fromInclusive.dsTaint);
            SortedSet<K> var787DDC5D63F27B9350D66F52D279622A_927569730 = (TreeMap.this.tailMap(fromInclusive, true).navigableKeySet());
            return (SortedSet<K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return TreeMap.this.tailMap(fromInclusive, true).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.324 -0400", hash_original_method = "1704B63D396CC7A2877008D7CE821A20", hash_generated_method = "A9AFF6950BEB3B4EF4F572607E2CDA6A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NavigableSet<K> descendingSet() {
            NavigableSet<K> var929F6B70CAAA59E1766EAB1B7C2C1384_5946768 = (new BoundedMap(false, null, NO_BOUND, null, NO_BOUND).navigableKeySet());
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
        private final transient boolean ascending;
        private final transient K from;
        private final transient Bound fromBound;
        private final transient K to;
        private final transient Bound toBound;
        private transient BoundedEntrySet entrySet;
        private transient BoundedKeySet keySet;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.325 -0400", hash_original_method = "EAF770A918D33B7B0B98CAAC01791FDE", hash_generated_method = "7602B18889923C1F316FA616D29E3378")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         BoundedMap(boolean ascending, K from, Bound fromBound, K to, Bound toBound) {
            dsTaint.addTaint(to.dsTaint);
            dsTaint.addTaint(toBound.dsTaint);
            dsTaint.addTaint(fromBound.dsTaint);
            dsTaint.addTaint(ascending);
            dsTaint.addTaint(from.dsTaint);
            {
                {
                    boolean varDF5DEF900BBEA61318C4B860BE963A0C_881041530 = (comparator.compare(from, to) > 0);
                    {
                        throw new IllegalArgumentException(from + " > " + to);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.325 -0400", hash_original_method = "0165FF9BE82C19127CA9F7A8EFBCC5F6", hash_generated_method = "40C6A79CB1FF6075365FE79C3446DE57")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int size() {
            int varFAAE4FEB39919E901926F6E4652B275E_900864522 = (count(entrySet().iterator()));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return count(entrySet().iterator());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.325 -0400", hash_original_method = "25ACC65054E604EE8ADED763702CFAA7", hash_generated_method = "45C48DDC0C5C672EE3E9CF412316E959")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean isEmpty() {
            boolean var19B0E21581FF256C0BE5D0F9299E6746_237027331 = (endpoint(true) == null);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return endpoint(true) == null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.325 -0400", hash_original_method = "00AB887CF1625BBE035D7C27E115F8F5", hash_generated_method = "765BC018C7C3E02E6F21E9618F8F27C8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public V get(Object key) {
            dsTaint.addTaint(key.dsTaint);
            {
                boolean var9135CD85F99C2376B2054E1BFF183EE5_2103933657 = (isInBounds(key));
                Object varDCA787235BE6A2E5196575B0FAC0DEDE_1101770311 = (TreeMap.this.get(key));
            } //End flattened ternary
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return isInBounds(key) ? TreeMap.this.get(key) : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.325 -0400", hash_original_method = "97933E3E15C41B402232AC9CC0472CF2", hash_generated_method = "FEA02559D6CA4C5E92B3D2A7AF52AEA0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsKey(Object key) {
            dsTaint.addTaint(key.dsTaint);
            boolean varA3E267D2E614E41BB78FB5916F69E5F6_375787918 = (isInBounds(key) && TreeMap.this.containsKey(key));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return isInBounds(key) && TreeMap.this.containsKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.325 -0400", hash_original_method = "AA5BBA9E7D3BEE615F1E652A3C2B8A57", hash_generated_method = "9D76E7FE9DD01D816B63B75A782E109A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public V put(K key, V value) {
            dsTaint.addTaint(value.dsTaint);
            dsTaint.addTaint(key.dsTaint);
            {
                boolean varAD602F34696280F613EFFCC6CD1936C9_1008342070 = (!isInBounds(key));
                {
                    throw outOfBounds(key, fromBound, toBound);
                } //End block
            } //End collapsed parenthetic
            V var8F551A1DF75EEEC56F34F3A9504C8B20_827343360 = (putInternal(key, value));
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (!isInBounds(key)) {
                //throw outOfBounds(key, fromBound, toBound);
            //}
            //return putInternal(key, value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.325 -0400", hash_original_method = "FD860E76286147E5825948B59334B12A", hash_generated_method = "6CAAC6C90494E73984AC4829A6CE3E7B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public V remove(Object key) {
            dsTaint.addTaint(key.dsTaint);
            {
                boolean var9135CD85F99C2376B2054E1BFF183EE5_212004841 = (isInBounds(key));
                Object var4AF1CF7C51C3940F4140C0E33E762C29_1631903537 = (TreeMap.this.remove(key));
            } //End flattened ternary
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return isInBounds(key) ? TreeMap.this.remove(key) : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.325 -0400", hash_original_method = "CBDDB4BBE438A9DB233DEA58A1C969FA", hash_generated_method = "15E171DDBEE4BF0A63824171F9CBCE58")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @SuppressWarnings("unchecked")
        private boolean isInBounds(Object key) {
            dsTaint.addTaint(key.dsTaint);
            boolean varA5F72E2E91F3E285BA97AAF5A99A4DA1_1379126002 = (isInBounds((K) key, fromBound, toBound));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return isInBounds((K) key, fromBound, toBound);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.325 -0400", hash_original_method = "692642A6AE210FFE582C89EC91302D79", hash_generated_method = "D667D533DC56B8B55CB9A5AF2E33AAF6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private boolean isInBounds(K key, Bound fromBound, Bound toBound) {
            dsTaint.addTaint(toBound.dsTaint);
            dsTaint.addTaint(fromBound.dsTaint);
            dsTaint.addTaint(key.dsTaint);
            {
                {
                    boolean var9F6E7E65C5DF7B537032AF04E3982098_1441398151 = (comparator.compare(key, from) < 0);
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean varFBA4E02ED99BA8F4A60A17B22AA50698_1125963449 = (comparator.compare(key, from) <= 0);
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var3BF67E403FFC608A69421DC18FA2C214_548860000 = (comparator.compare(key, to) > 0);
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean varEA1D9A2226B6707B7C8DE8BD2619E59B_790588825 = (comparator.compare(key, to) >= 0);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.325 -0400", hash_original_method = "CAAC4C1A33B13586569CF07F541A55C7", hash_generated_method = "54798DF6D5D76AA6F3D9F6122E35B608")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private Node<K, V> bound(Node<K, V> node, Bound fromBound, Bound toBound) {
            dsTaint.addTaint(node.dsTaint);
            dsTaint.addTaint(toBound.dsTaint);
            dsTaint.addTaint(fromBound.dsTaint);
            {
                boolean varC116C584CC9981AECCA6F0640121C4B9_421594454 = (node != null && isInBounds(node.getKey(), fromBound, toBound));
            } //End flattened ternary
            return (Node<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return node != null && isInBounds(node.getKey(), fromBound, toBound) ? node : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.325 -0400", hash_original_method = "692355E3656C196457301F91A19D5157", hash_generated_method = "5C0A67A2ACA9CB53ED4891256215213A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Entry<K, V> firstEntry() {
            Entry<K, V> var4A477756646ABEF870028743EA09F8EC_1303665376 = (immutableCopy(endpoint(true)));
            return (Entry<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return immutableCopy(endpoint(true));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.325 -0400", hash_original_method = "3800FF04B85DB50D775ADF76A89AF0FD", hash_generated_method = "E307F7A72E69DA7B343AD6A3542AB67E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Entry<K, V> pollFirstEntry() {
            Node<K, V> result;
            result = endpoint(true);
            {
                removeInternal(result);
            } //End block
            Entry<K, V> varC10CFBE1B9807D081D784E25B519FE7E_1773554573 = (immutableCopy(result));
            return (Entry<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Node<K, V> result = endpoint(true);
            //if (result != null) {
                //removeInternal(result);
            //}
            //return immutableCopy(result);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.326 -0400", hash_original_method = "1DE5152AF86A2FB092CD0802BF299C85", hash_generated_method = "EFD189C850FE7F4A33CD334209818454")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K firstKey() {
            Entry<K, V> entry;
            entry = endpoint(true);
            {
                throw new NoSuchElementException();
            } //End block
            K var4B8D962F1524E92662DE034798AAC65A_534066152 = (entry.getKey());
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Entry<K, V> entry = endpoint(true);
            //if (entry == null) {
                //throw new NoSuchElementException();
            //}
            //return entry.getKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.326 -0400", hash_original_method = "3349B358C55B472B88F39549996E074C", hash_generated_method = "C6BCBFC518650E99A593E8BAC32182F6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Entry<K, V> lastEntry() {
            Entry<K, V> varB6A1B7F0F8557CC304E4C72A892B03F9_778519414 = (immutableCopy(endpoint(false)));
            return (Entry<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return immutableCopy(endpoint(false));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.326 -0400", hash_original_method = "4E391E55891B2D72162CA8FBBFDB8088", hash_generated_method = "CD51FCFB6E1F644E3ED33C710243A165")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Entry<K, V> pollLastEntry() {
            Node<K, V> result;
            result = endpoint(false);
            {
                removeInternal(result);
            } //End block
            Entry<K, V> varC10CFBE1B9807D081D784E25B519FE7E_213682245 = (immutableCopy(result));
            return (Entry<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Node<K, V> result = endpoint(false);
            //if (result != null) {
                //removeInternal(result);
            //}
            //return immutableCopy(result);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.326 -0400", hash_original_method = "394B9DCC52DC405017E9FB6F95D12436", hash_generated_method = "035B278357148F5435D972884AB2D475")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K lastKey() {
            Entry<K, V> entry;
            entry = endpoint(false);
            {
                throw new NoSuchElementException();
            } //End block
            K var4B8D962F1524E92662DE034798AAC65A_474929305 = (entry.getKey());
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Entry<K, V> entry = endpoint(false);
            //if (entry == null) {
                //throw new NoSuchElementException();
            //}
            //return entry.getKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.326 -0400", hash_original_method = "83D48F5C9D4926E1668CDBC652A8BB3D", hash_generated_method = "11E1FF6D13448BB1FB93D35B89A5D96D")
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
                throw new AssertionError();
                //End case default 
                Node<K, V> var83B74AA9D3A2FC2A95056081BE86827F_1693617811 = (bound(node, NO_BOUND, toBound));
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
                throw new AssertionError();
                //End case default 
                Node<K, V> var0C5D193A5BFBF64BBA8D6E7FB91219A8_746273363 = (bound(node, fromBound, NO_BOUND));
            } //End block
            return (Node<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.326 -0400", hash_original_method = "4CDC04225A960E79B8311D7465BD3125", hash_generated_method = "B1ECD9CB39F2D47846B0C1C86EC2A139")
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
            Entry<K, V> varC4960990CFB3B4F10B005DBFC572F18B_1711728972 = (bound(find(key, relation), fromBoundForCheck, toBoundForCheck));
            return (Entry<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.326 -0400", hash_original_method = "BD9CF59DC295A4AE3510934F298E27E6", hash_generated_method = "9182F0DAC712ABCF3C1E9768DE4C2929")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Entry<K, V> lowerEntry(K key) {
            dsTaint.addTaint(key.dsTaint);
            Entry<K, V> var49E3C017DDA5E77A73FD777A1A941CFE_960222851 = (immutableCopy(findBounded(key, LOWER)));
            return (Entry<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return immutableCopy(findBounded(key, LOWER));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.326 -0400", hash_original_method = "EBA87E3AFD9E90051DFFEBD0117773EA", hash_generated_method = "BC0AB01599E821ADA3F4CBA39D329D75")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K lowerKey(K key) {
            dsTaint.addTaint(key.dsTaint);
            Entry<K, V> entry;
            entry = findBounded(key, LOWER);
            {
                Object var89F8384D8DD2CA583B7A90F311F2A4B1_176530327 = (entry.getKey());
            } //End flattened ternary
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Entry<K, V> entry = findBounded(key, LOWER);
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.326 -0400", hash_original_method = "581C54D570AF4193E6400C576ED95C35", hash_generated_method = "A5DA415AFB7503898ABA7A63808C4F0A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Entry<K, V> floorEntry(K key) {
            dsTaint.addTaint(key.dsTaint);
            Entry<K, V> var53162E819F91269ADC18976393EA39D9_1382336039 = (immutableCopy(findBounded(key, FLOOR)));
            return (Entry<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return immutableCopy(findBounded(key, FLOOR));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.327 -0400", hash_original_method = "E92237DAC033388A5150FD58D66D705D", hash_generated_method = "75806F9E3D1CB3642CEF1B9C998DA443")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K floorKey(K key) {
            dsTaint.addTaint(key.dsTaint);
            Entry<K, V> entry;
            entry = findBounded(key, FLOOR);
            {
                Object var89F8384D8DD2CA583B7A90F311F2A4B1_1358758427 = (entry.getKey());
            } //End flattened ternary
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Entry<K, V> entry = findBounded(key, FLOOR);
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.327 -0400", hash_original_method = "C11821BD096982DAE03E94867B2C92BE", hash_generated_method = "212C4A233CB92D2AD364D0385A2F19BD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Entry<K, V> ceilingEntry(K key) {
            dsTaint.addTaint(key.dsTaint);
            Entry<K, V> varF829DF5632FF7CC677B851446FA8358F_662421037 = (immutableCopy(findBounded(key, CEILING)));
            return (Entry<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return immutableCopy(findBounded(key, CEILING));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.327 -0400", hash_original_method = "01AF63D6DC81CC48D8C6B0BE37F83B4D", hash_generated_method = "C3419BC20B749EE06FEF72C1A82402C0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K ceilingKey(K key) {
            dsTaint.addTaint(key.dsTaint);
            Entry<K, V> entry;
            entry = findBounded(key, CEILING);
            {
                Object var89F8384D8DD2CA583B7A90F311F2A4B1_2029125449 = (entry.getKey());
            } //End flattened ternary
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Entry<K, V> entry = findBounded(key, CEILING);
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.327 -0400", hash_original_method = "4DE66AB7FA66EBE29F4E4509967D65D0", hash_generated_method = "C55F2F3ABED1A29FAC4DB4336CBEC4AD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Entry<K, V> higherEntry(K key) {
            dsTaint.addTaint(key.dsTaint);
            Entry<K, V> var5017B9B4B55FC3DCD39FDB020AD9AC2B_1879806731 = (immutableCopy(findBounded(key, HIGHER)));
            return (Entry<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return immutableCopy(findBounded(key, HIGHER));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.327 -0400", hash_original_method = "47A499322D06CDAFFEC1D4DA0A079F0A", hash_generated_method = "29222B04C899DC923473059741A2DFB6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K higherKey(K key) {
            dsTaint.addTaint(key.dsTaint);
            Entry<K, V> entry;
            entry = findBounded(key, HIGHER);
            {
                Object var89F8384D8DD2CA583B7A90F311F2A4B1_1645061387 = (entry.getKey());
            } //End flattened ternary
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Entry<K, V> entry = findBounded(key, HIGHER);
            //return entry != null ? entry.getKey() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.327 -0400", hash_original_method = "631801B6DE22632DEACA2B547DEBE43A", hash_generated_method = "E2EC5556FE46F7B91C095822CC0DC901")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Comparator<? super K> comparator() {
            {
                Comparator<? super K> var4EFCFF1E7C20902B6A370F2A482D639F_1771831229 = (TreeMap.this.comparator());
            } //End block
            {
                Comparator<? super K> var7777CBBA6524383189220439D91F8386_86823964 = (Collections.reverseOrder(comparator));
            } //End block
            return (Comparator<? super K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (ascending) {
            //return TreeMap.this.comparator();
          //} else {
            //return Collections.reverseOrder(comparator);
          //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.327 -0400", hash_original_method = "7F86A739037DCA8312EEE2819E1107F8", hash_generated_method = "0BA0A588233DBD04D48ACC483CD02D66")
        @DSModeled(DSC.SAFE)
        @Override
        public Set<Entry<K, V>> entrySet() {
            BoundedEntrySet result;
            result = entrySet;
            return (Set<Entry<K, V>>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //BoundedEntrySet result = entrySet;
            //return result != null ? result : (entrySet = new BoundedEntrySet());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.327 -0400", hash_original_method = "8D1D053C1D8B0756868AB879DB7CB086", hash_generated_method = "36702A8375CAF21F9A194966428B21D0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Set<K> keySet() {
            Set<K> varC031E4767BC23709B128EF5E3409EAEC_544690024 = (navigableKeySet());
            return (Set<K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.327 -0400", hash_original_method = "58209BC6FD1C6420A0C3CE4B441A6EA8", hash_generated_method = "9B2E228256B7510A3F39D3120E557AF8")
        @DSModeled(DSC.SAFE)
        public NavigableSet<K> navigableKeySet() {
            BoundedKeySet result;
            result = keySet;
            return (NavigableSet<K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //BoundedKeySet result = keySet;
            //return result != null ? result : (keySet = new BoundedKeySet());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.327 -0400", hash_original_method = "6D358EC631E9E279A9C759613AD4CBF5", hash_generated_method = "801E2A6CF7BD2920E186C2249F07F2C2")
        @DSModeled(DSC.SAFE)
        public NavigableMap<K, V> descendingMap() {
            return (NavigableMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new BoundedMap(!ascending, from, fromBound, to, toBound);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.327 -0400", hash_original_method = "E068C75BD35AA3BEC427F457C352E2B5", hash_generated_method = "40644184B6DA15134B303F66F1F08B02")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NavigableSet<K> descendingKeySet() {
            NavigableSet<K> var90AC92C6A05DE7658D745EA746EA20FC_1748202124 = (new BoundedMap(!ascending, from, fromBound, to, toBound).navigableKeySet());
            return (NavigableSet<K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new BoundedMap(!ascending, from, fromBound, to, toBound).navigableKeySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.327 -0400", hash_original_method = "3DC9A98D108EA5F857802D111DD4C7BC", hash_generated_method = "AF2A21D95315C3FBBBB78F5E8D1EA240")
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
            NavigableMap<K, V> var20B592584BC039D7D72F3E40688B285C_290105195 = (subMap(from, fromBound, to, toBound));
            return (NavigableMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Bound fromBound = fromInclusive ? INCLUSIVE : EXCLUSIVE;
            //Bound toBound = toInclusive ? INCLUSIVE : EXCLUSIVE;
            //return subMap(from, fromBound, to, toBound);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.327 -0400", hash_original_method = "85C9C855FCFD7C01DE62316D427AA356", hash_generated_method = "2321E952A6B907DE2485295A82BEE770")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NavigableMap<K, V> subMap(K fromInclusive, K toExclusive) {
            dsTaint.addTaint(fromInclusive.dsTaint);
            dsTaint.addTaint(toExclusive.dsTaint);
            NavigableMap<K, V> var74A6890EEA15D328BE1DF402367AC3EE_1763251201 = (subMap(fromInclusive, INCLUSIVE, toExclusive, EXCLUSIVE));
            return (NavigableMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return subMap(fromInclusive, INCLUSIVE, toExclusive, EXCLUSIVE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.327 -0400", hash_original_method = "F0BAF6F2CF2FCD82E483E31B5C869204", hash_generated_method = "7A774A54D349DACBAA2E54FBD36BBA88")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NavigableMap<K, V> headMap(K to, boolean inclusive) {
            dsTaint.addTaint(to.dsTaint);
            dsTaint.addTaint(inclusive);
            Bound toBound;
            toBound = INCLUSIVE;
            toBound = EXCLUSIVE;
            NavigableMap<K, V> varE2521AFD311C1CF75C9D0C3A25FC2174_1959888817 = (subMap(null, NO_BOUND, to, toBound));
            return (NavigableMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Bound toBound = inclusive ? INCLUSIVE : EXCLUSIVE;
            //return subMap(null, NO_BOUND, to, toBound);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.327 -0400", hash_original_method = "ABFE13DC9073E46E049BB999D5306953", hash_generated_method = "9AB63450B715D2DE2EB0C2336179A8D8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NavigableMap<K, V> headMap(K toExclusive) {
            dsTaint.addTaint(toExclusive.dsTaint);
            NavigableMap<K, V> var161932101AABB5B600CE7FDA25BE03E6_566108776 = (subMap(null, NO_BOUND, toExclusive, EXCLUSIVE));
            return (NavigableMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return subMap(null, NO_BOUND, toExclusive, EXCLUSIVE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.328 -0400", hash_original_method = "26986665A8C827C93D404190F2752B4C", hash_generated_method = "6E5D7C55F925FAE815F0BCE63659D741")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NavigableMap<K, V> tailMap(K from, boolean inclusive) {
            dsTaint.addTaint(inclusive);
            dsTaint.addTaint(from.dsTaint);
            Bound fromBound;
            fromBound = INCLUSIVE;
            fromBound = EXCLUSIVE;
            NavigableMap<K, V> var3BB4FB5B1FEFA64BF14D2559066721EE_222397502 = (subMap(from, fromBound, null, NO_BOUND));
            return (NavigableMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Bound fromBound = inclusive ? INCLUSIVE : EXCLUSIVE;
            //return subMap(from, fromBound, null, NO_BOUND);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.328 -0400", hash_original_method = "CF387452C0473BBA846F53D5C56CE3B2", hash_generated_method = "038792C6F35730A5C5F36BDCD8AC651D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NavigableMap<K, V> tailMap(K fromInclusive) {
            dsTaint.addTaint(fromInclusive.dsTaint);
            NavigableMap<K, V> varEA6F137E8B17463734F984DED03116AD_1295609644 = (subMap(fromInclusive, INCLUSIVE, null, NO_BOUND));
            return (NavigableMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return subMap(fromInclusive, INCLUSIVE, null, NO_BOUND);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.328 -0400", hash_original_method = "0BE57F9811CA6209D3A6FF727B140802", hash_generated_method = "4ADEBE136EF026CDC29570385153F0CA")
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
                    boolean var1DAE628D732342D7BC54FD4D3278CE34_1402067833 = (!isInBounds(from, fromBoundToCheck, this.toBound));
                    {
                        throw outOfBounds(to, fromBoundToCheck, this.toBound);
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
                    boolean var5922B8A01789147118CB04C1CDD52F79_360406989 = (!isInBounds(to, this.fromBound, toBoundToCheck));
                    {
                        throw outOfBounds(to, this.fromBound, toBoundToCheck);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            return (NavigableMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.328 -0400", hash_original_method = "65FB71F2A366D35F7884C2869AFAA6ED", hash_generated_method = "FF60EA4CA072369D8A206B93A789ECC0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private IllegalArgumentException outOfBounds(Object value, Bound fromBound, Bound toBound) {
            dsTaint.addTaint(toBound.dsTaint);
            dsTaint.addTaint(value.dsTaint);
            dsTaint.addTaint(fromBound.dsTaint);
            IllegalArgumentException varA0438CE0741623F7F68D8DC9E3FC3D30_2034683951 = (new IllegalArgumentException(value + " not in range "
                    + fromBound.leftCap(from) + ".." + toBound.rightCap(to)));
            return (IllegalArgumentException)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new IllegalArgumentException(value + " not in range "
                    //+ fromBound.leftCap(from) + ".." + toBound.rightCap(to));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.328 -0400", hash_original_method = "9F20C8CFE1A741092D9743A31C3F8586", hash_generated_method = "6369F935F969C02AD96017B0D9EE60A8")
        @DSModeled(DSC.SAFE)
         Object writeReplace() throws ObjectStreamException {
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ascending
                    //? new AscendingSubMap<K, V>(TreeMap.this, from, fromBound, to, toBound)
                    //: new DescendingSubMap<K, V>(TreeMap.this, from, fromBound, to, toBound);
        }

        
        abstract class BoundedIterator<T> extends MapIterator<T> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.328 -0400", hash_original_method = "30CDAF663F351A84269F6FB0B072EFA9", hash_generated_method = "6A0FE1DC52E3AF85F8E6871FFDB0C7C3")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            protected BoundedIterator(Node<K, V> next) {
                super(next);
                dsTaint.addTaint(next.dsTaint);
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.328 -0400", hash_original_method = "E9206CF01CB691A7CC292AD03FA9736C", hash_generated_method = "1D473743B57F57B72B4DDF2378C100E6")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            protected Node<K, V> stepForward() {
                Node<K, V> result;
                result = super.stepForward();
                {
                    boolean varB492F846C21C09F0364F2416324ABD06_307158996 = (next != null && !isInBounds(next.key, NO_BOUND, toBound));
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.328 -0400", hash_original_method = "E55F6A3E56D317586EA4F65D3F74D30B", hash_generated_method = "4AA22BED23597E94E37CF2330C7CC8B9")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            protected Node<K, V> stepBackward() {
                Node<K, V> result;
                result = super.stepBackward();
                {
                    boolean varA14FF8A4CC2199BAF982AB4CC94D03CC_2133153134 = (next != null && !isInBounds(next.key, fromBound, NO_BOUND));
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.328 -0400", hash_original_method = "29BBB3BE9EA7B6D6C0B83C28F05082A4", hash_generated_method = "D929A71FAF09821B745C3975D22C7E05")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public int size() {
                int var69D9F234E7E76618743D3D698A58599B_1559512488 = (BoundedMap.this.size());
                return dsTaint.getTaintInt();
                // ---------- Original Method ----------
                //return BoundedMap.this.size();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.328 -0400", hash_original_method = "AEA447F4A69E282FABF93736832EBAA3", hash_generated_method = "7CA44035FD656DD1195362F4E70DA7F1")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean isEmpty() {
                boolean varF1E2DF8AD3E4C9C508E293B19251E66A_527242797 = (BoundedMap.this.isEmpty());
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return BoundedMap.this.isEmpty();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.328 -0400", hash_original_method = "0E267F64AB80178C28467CD978AC79C8", hash_generated_method = "9CB160DDB514CF6705F77E97ACF6D95A")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public Iterator<Entry<K, V>> iterator() {
                Iterator<Entry<K, V>> var59B49E4F229577CD52E2B7387C0670D8_51674664 = (new BoundedIterator<Entry<K, V>>(endpoint(true)) {
                    public Entry<K, V> next() {
                        return ascending ? stepForward() : stepBackward();
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.329 -0400", hash_original_method = "954A21A7B25CC1709817AC62B8C6864E", hash_generated_method = "688B6D4F929508789490E52CF198F5F2")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean contains(Object o) {
                dsTaint.addTaint(o.dsTaint);
                Entry<?, ?> entry;
                entry = (Entry<?, ?>) o;
                boolean varC238596BFA0BDAC8F31141888DBD9FC9_1849018473 = (isInBounds(entry.getKey()) && findByEntry(entry) != null);
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //if (!(o instanceof Entry)) {
                    //return false;
                //}
                //Entry<?, ?> entry = (Entry<?, ?>) o;
                //return isInBounds(entry.getKey()) && findByEntry(entry) != null;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.329 -0400", hash_original_method = "EF59D88655EE445530DBDC219FDD1A5F", hash_generated_method = "ABCA783E03E0C7C2F4150D822DDE1B37")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean remove(Object o) {
                dsTaint.addTaint(o.dsTaint);
                Entry<?, ?> entry;
                entry = (Entry<?, ?>) o;
                boolean var155AF0A9D9B42FB9DF7C214F267A7E1B_125355195 = (isInBounds(entry.getKey()) && TreeMap.this.entrySet().remove(entry));
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.329 -0400", hash_original_method = "29BBB3BE9EA7B6D6C0B83C28F05082A4", hash_generated_method = "CA5C8892F90D68B6A210702317CB8E6A")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public int size() {
                int var69D9F234E7E76618743D3D698A58599B_1632263577 = (BoundedMap.this.size());
                return dsTaint.getTaintInt();
                // ---------- Original Method ----------
                //return BoundedMap.this.size();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.329 -0400", hash_original_method = "AEA447F4A69E282FABF93736832EBAA3", hash_generated_method = "34D5D73491667E1941CCD5C140515FE6")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean isEmpty() {
                boolean varF1E2DF8AD3E4C9C508E293B19251E66A_1145266502 = (BoundedMap.this.isEmpty());
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return BoundedMap.this.isEmpty();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.329 -0400", hash_original_method = "8539DDED7A19368CB3D09440D6A62269", hash_generated_method = "E6B9AA19483E280F6953B20B7CB8B3E2")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public Iterator<K> iterator() {
                Iterator<K> varA2222DF9ED972D5F0CD3199E24BA603C_1241616073 = (new BoundedIterator<K>(endpoint(true)) {
                    public K next() {
                        return (ascending ? stepForward() : stepBackward()).key;
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.329 -0400", hash_original_method = "74923548E6D3A508C57DDA053BC0EE64", hash_generated_method = "9276F05917ADB630117EDD34B447C799")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Iterator<K> descendingIterator() {
                Iterator<K> varEEA7CE7FBCD6B6A8B97DE1E11902D4A2_2039861124 = (new BoundedIterator<K>(endpoint(false)) {
                    public K next() {
                        return (ascending ? stepBackward() : stepForward()).key;
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.329 -0400", hash_original_method = "F2816D590B9E0F32B93C47AB444AEEED", hash_generated_method = "14D7DFC584DF47208F8A0C27B689B0C0")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean contains(Object key) {
                dsTaint.addTaint(key.dsTaint);
                boolean varDEADC564C50A1257392A09A833F9988B_696564619 = (isInBounds(key) && findByObject(key) != null);
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return isInBounds(key) && findByObject(key) != null;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.329 -0400", hash_original_method = "ADEDE1B4ABE9B2F86F8B629056F35200", hash_generated_method = "F3928FD9EE46A96129F5673CBA7DA2BB")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean remove(Object key) {
                dsTaint.addTaint(key.dsTaint);
                boolean var55612E9AB490EF3FFBD38F202307B8D4_1481358627 = (isInBounds(key) && removeInternalByKey(key) != null);
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return isInBounds(key) && removeInternalByKey(key) != null;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.329 -0400", hash_original_method = "3067DEE01FBBBFD061436C7D4561F434", hash_generated_method = "8835D909A2023CDD5F256D833B6D574F")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public K first() {
                K varE22EDE26363A40A00EFF03C7035872E0_621111589 = (firstKey());
                return (K)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return firstKey();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.329 -0400", hash_original_method = "4985BB63726B115899F1811F08E80BDF", hash_generated_method = "8FCA0AC2027E8E87D237258CB9FF53F8")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public K pollFirst() {
                Entry<K, ?> entry;
                entry = pollFirstEntry();
                {
                    Object varD72C0ADBA213ED9F1E64858437A5A9A7_1812260814 = (entry.getKey());
                } //End flattened ternary
                return (K)dsTaint.getTaint();
                // ---------- Original Method ----------
                //Entry<K, ?> entry = pollFirstEntry();
                //return entry != null ? entry.getKey() : null;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.329 -0400", hash_original_method = "39C87F788E647BCD3FB86FFF34D7EF10", hash_generated_method = "603D81FA03ECD513CA7C88062E7566C9")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public K last() {
                K var1259CADB733D4F3EEEE72461A39A8456_1010820255 = (lastKey());
                return (K)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return lastKey();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.329 -0400", hash_original_method = "B202B1B2AAB477548F6A0AD72C9B1701", hash_generated_method = "33FF288CD76CBB4F305E6BF318016EDC")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public K pollLast() {
                Entry<K, ?> entry;
                entry = pollLastEntry();
                {
                    Object varD72C0ADBA213ED9F1E64858437A5A9A7_728881770 = (entry.getKey());
                } //End flattened ternary
                return (K)dsTaint.getTaint();
                // ---------- Original Method ----------
                //Entry<K, ?> entry = pollLastEntry();
                //return entry != null ? entry.getKey() : null;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.329 -0400", hash_original_method = "5CFE05BF706A06BBB501067306F1B9ED", hash_generated_method = "E2C8BC3879520FA9D4DE6B8299A3646D")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public K lower(K key) {
                dsTaint.addTaint(key.dsTaint);
                K varC8CA35B34879A5BBD97ABB8E8EAD5EB1_519976269 = (lowerKey(key));
                return (K)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return lowerKey(key);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.329 -0400", hash_original_method = "10BABB7BB2E837824A13AAE89EE7EC6F", hash_generated_method = "7A76C3F34ECC2D76D33BB709E625E30E")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public K floor(K key) {
                dsTaint.addTaint(key.dsTaint);
                K varD09AD4788238A5CED608A1BF0E5D1D7F_1712231917 = (floorKey(key));
                return (K)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return floorKey(key);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.329 -0400", hash_original_method = "2AD4706A6D818B709A1E2CA64B48B4B9", hash_generated_method = "C4878FAF1FE6771361E464F61068F79A")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public K ceiling(K key) {
                dsTaint.addTaint(key.dsTaint);
                K var52D28137C5EDE984721BFD710675DC0F_1624989275 = (ceilingKey(key));
                return (K)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return ceilingKey(key);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.330 -0400", hash_original_method = "8CC63649234BFC57DB10A2387AE34DD6", hash_generated_method = "D01443AB53601F25AC17E6C4FF5E461E")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public K higher(K key) {
                dsTaint.addTaint(key.dsTaint);
                K var27E969402503A92141B8193AA2FC438A_280855380 = (higherKey(key));
                return (K)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return higherKey(key);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.330 -0400", hash_original_method = "C5DD330893039070B9523799F47D2DEB", hash_generated_method = "679B246EC12E99FD96EEFF1AC7CC95D0")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Comparator<? super K> comparator() {
                Comparator<? super K> var00F595C821A260475D2C8A9157D79018_1089306973 = (BoundedMap.this.comparator());
                return (Comparator<? super K>)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return BoundedMap.this.comparator();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.330 -0400", hash_original_method = "21039715CA3F916EA62F8064E71FC6CA", hash_generated_method = "37A5B8A6D8FEE3C552F90A4DADBAD084")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public NavigableSet<K> subSet(K from, boolean fromInclusive, K to, boolean toInclusive) {
                dsTaint.addTaint(to.dsTaint);
                dsTaint.addTaint(fromInclusive);
                dsTaint.addTaint(toInclusive);
                dsTaint.addTaint(from.dsTaint);
                NavigableSet<K> var6CB83A4AEF7A36080313376C8A56BB48_1034308968 = (subMap(from, fromInclusive, to, toInclusive).navigableKeySet());
                return (NavigableSet<K>)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return subMap(from, fromInclusive, to, toInclusive).navigableKeySet();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.330 -0400", hash_original_method = "AA0E5149ADFB9D8316CC8EA86FBC0B9E", hash_generated_method = "027062934D20B544AE4A715B344615E2")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public SortedSet<K> subSet(K fromInclusive, K toExclusive) {
                dsTaint.addTaint(fromInclusive.dsTaint);
                dsTaint.addTaint(toExclusive.dsTaint);
                SortedSet<K> var979679B636B038708723E255D7275809_2089957968 = (subMap(fromInclusive, toExclusive).navigableKeySet());
                return (SortedSet<K>)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return subMap(fromInclusive, toExclusive).navigableKeySet();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.330 -0400", hash_original_method = "EDDD3784AC7E9834A18CCB5F2AE27346", hash_generated_method = "5E68C395884D645E2E27811F8293DC3B")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public NavigableSet<K> headSet(K to, boolean inclusive) {
                dsTaint.addTaint(to.dsTaint);
                dsTaint.addTaint(inclusive);
                NavigableSet<K> varA465CE6FE43AAA87C98D7E92F4EA614A_989481254 = (headMap(to, inclusive).navigableKeySet());
                return (NavigableSet<K>)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return headMap(to, inclusive).navigableKeySet();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.330 -0400", hash_original_method = "85EE899AF4D85617CB858518BA70EA12", hash_generated_method = "2B4F8374C3AF37AA6BBA26D95CE45F75")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public SortedSet<K> headSet(K toExclusive) {
                dsTaint.addTaint(toExclusive.dsTaint);
                SortedSet<K> var78B614F54CD75B1427B0E4001EC03FD2_1360182974 = (headMap(toExclusive).navigableKeySet());
                return (SortedSet<K>)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return headMap(toExclusive).navigableKeySet();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.330 -0400", hash_original_method = "B964A303D464756EDD8E9C26A8D54411", hash_generated_method = "D0C2B97A0FAE8686FC7D032DC5A16F44")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public NavigableSet<K> tailSet(K from, boolean inclusive) {
                dsTaint.addTaint(inclusive);
                dsTaint.addTaint(from.dsTaint);
                NavigableSet<K> var1BB4478007407ED929DB1EA901876653_823654471 = (tailMap(from, inclusive).navigableKeySet());
                return (NavigableSet<K>)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return tailMap(from, inclusive).navigableKeySet();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.330 -0400", hash_original_method = "9536952691BDDFD3D8EFB20A3BD9AE85", hash_generated_method = "1E98EEC4EE193BD48550EF010D960E1C")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public SortedSet<K> tailSet(K fromInclusive) {
                dsTaint.addTaint(fromInclusive.dsTaint);
                SortedSet<K> varAD280FBA9CC1A4E49367439FCC9998BF_88498693 = (tailMap(fromInclusive).navigableKeySet());
                return (SortedSet<K>)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return tailMap(fromInclusive).navigableKeySet();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.330 -0400", hash_original_method = "2BD89B2F5D5D75B5A66FC121E2BE77F9", hash_generated_method = "2AEC0524C1B270BD04C9AC179D67BD66")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public NavigableSet<K> descendingSet() {
                NavigableSet<K> var26A6654EC6C38F80CE6F5BDE2CCE66DD_524438647 = (new BoundedMap(!ascending, from, fromBound, to, toBound).navigableKeySet());
                return (NavigableSet<K>)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new BoundedMap(!ascending, from, fromBound, to, toBound).navigableKeySet();
            }

            
        }


        
    }


    
    static abstract class NavigableSubMap<K, V> extends AbstractMap<K, V> implements Serializable {
        private static final long serialVersionUID = -2102997345730753016L;
        TreeMap<K, V> m;
        Object lo;
        Object hi;
        boolean fromStart;
        boolean toEnd;
        boolean loInclusive;
        boolean hiInclusive;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.330 -0400", hash_original_method = "C1ACA683FC5CFCA3BE29823730AC5B8B", hash_generated_method = "6FC51C4791E05597D43DAB55AA918A83")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.330 -0400", hash_original_method = "98169B5D59A5E61A69F2A37D56262114", hash_generated_method = "AB15B7616ECCC50CBCE6B278074726EC")
        @DSModeled(DSC.SAFE)
        @Override
        public Set<Entry<K, V>> entrySet() {
            throw new UnsupportedOperationException();
            return (Set<Entry<K, V>>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.330 -0400", hash_original_method = "6A8A4C8549808D70F841B9593D31A43F", hash_generated_method = "1000F592DE269C020D82293F7F82D12D")
        @DSModeled(DSC.SAFE)
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
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Bound fromBound = fromStart ? NO_BOUND : (loInclusive ? INCLUSIVE : EXCLUSIVE);
            //Bound toBound = toEnd ? NO_BOUND : (hiInclusive ? INCLUSIVE : EXCLUSIVE);
            //boolean ascending = !(this instanceof DescendingSubMap);
            //return m.new BoundedMap(ascending, (K) lo, fromBound, (K) hi, toBound);
        }

        
    }


    
    static class DescendingSubMap<K, V> extends NavigableSubMap<K, V> {
        private static final long serialVersionUID = 912986545866120460L;
        Comparator<K> reverseComparator;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.331 -0400", hash_original_method = "FDAA1F4436CE129642763FB7A272001D", hash_generated_method = "60788637045F1E24563EEB184AE97C75")
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

        
    }


    
    static class AscendingSubMap<K, V> extends NavigableSubMap<K, V> {
        private static final long serialVersionUID = 912986545866124060L;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.331 -0400", hash_original_method = "C32F016187D7478ED63A0FCF56CB93EB", hash_generated_method = "6A4452D225847C44CD6CEFCE07A12535")
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

        
    }


    
    class SubMap extends AbstractMap<K, V> implements Serializable {
        private static final long serialVersionUID = -6520786458950516097L;
        Object fromKey;
        Object toKey;
        boolean fromStart;
        boolean toEnd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.331 -0400", hash_original_method = "98169B5D59A5E61A69F2A37D56262114", hash_generated_method = "AB15B7616ECCC50CBCE6B278074726EC")
        @DSModeled(DSC.SAFE)
        @Override
        public Set<Entry<K, V>> entrySet() {
            throw new UnsupportedOperationException();
            return (Set<Entry<K, V>>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.331 -0400", hash_original_method = "AC95C6CC81DF8BD4B0519A49635D6CF0", hash_generated_method = "0781DC15E42FF185F0EDC8A62B68376C")
        @DSModeled(DSC.SAFE)
        @SuppressWarnings("unchecked")
        protected Object readResolve() throws ObjectStreamException {
            Bound fromBound;
            fromBound = NO_BOUND;
            fromBound = INCLUSIVE;
            Bound toBound;
            toBound = NO_BOUND;
            toBound = EXCLUSIVE;
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Bound fromBound = fromStart ? NO_BOUND : INCLUSIVE;
            //Bound toBound = toEnd ? NO_BOUND : EXCLUSIVE;
            //return new BoundedMap(true, (K) fromKey, fromBound, (K) toKey, toBound);
        }

        
    }


    
}


