package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TreeSet<E> extends AbstractSet<E> implements NavigableSet<E>, Cloneable, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.826 -0500", hash_original_field = "F0F45E90FD957A3B68DECCE5AC6BAE9C", hash_generated_field = "31AEFE2A50D43E7000DE1CE15A90AC24")

    private static final long serialVersionUID = -2479143000061671589L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.828 -0500", hash_original_field = "E2C66E531AD1935404D259785B7A7B33", hash_generated_field = "C78575AC49DB698118FD5EA7F65EAFD3")

    private transient NavigableMap<E, Object> backingMap;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.831 -0500", hash_original_field = "AA941F50F6CB1178805EC6663D334268", hash_generated_field = "71D5DD9C91D04D73018803CC77A3333A")

    private transient NavigableSet<E> descendingSet;

    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.834 -0500", hash_original_method = "B468A43994310DE7D91A1366853F3908", hash_generated_method = "B468A43994310DE7D91A1366853F3908")
    
TreeSet(NavigableMap<E, Object> map) {
        backingMap = map;
    }

    /**
     * Constructs a new empty instance of {@code TreeSet} which uses natural
     * ordering.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.836 -0500", hash_original_method = "A94A461A61DAB692596F2C820B79ED22", hash_generated_method = "327076A149DBADC603C3153C96F5BBC3")
    
public TreeSet() {
        backingMap = new TreeMap<E, Object>();
    }
    
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.545 -0400", hash_original_method = "98B2B75BFA703DD0E35ED82DE7014603", hash_generated_method = "9295DFAB1B2A4F093CB6CC0F48F4D93E")
    public  TreeSet(Collection<? extends E> collection) {
        this();
        addTaint(collection.getTaint());
        addAll(collection);
        backingMap.addTaint(collection.getTaint());
        // ---------- Original Method ----------
        //addAll(collection);
    }

    /**
     * Constructs a new empty instance of {@code TreeSet} which uses the
     * specified comparator.
     *
     * @param comparator
     *            the comparator to use.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.843 -0500", hash_original_method = "8C746452C9FB7802CDFBFB3337D39F4C", hash_generated_method = "E0BD18821C11565186A14557633F54CF")
    
public TreeSet(Comparator<? super E> comparator) {
        backingMap = new TreeMap<E, Object>(comparator);
    }

    /**
     * Constructs a new instance of {@code TreeSet} containing the elements of
     * the specified SortedSet and using the same Comparator.
     *
     * @param set
     *            the SortedSet of elements to add.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.845 -0500", hash_original_method = "A9811B2E808509DC9D16313E2A4EF959", hash_generated_method = "7357EAA636FC4374A613D83DAF4FD331")
    
public TreeSet(SortedSet<E> set) {
        this(set.comparator());
        Iterator<E> it = set.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @Override
    
    public boolean add(E object) {
        backingMap.addTaint(object.getTaint());
        return super.add(object);
    }
    
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.548 -0400", hash_original_method = "BDDE8348BEC59AA11A27D7FE3ECB76D9", hash_generated_method = "037128A946DAF3846E141644E35E59AD")
    @SuppressWarnings("unchecked")
    @Override
    public Object clone() {

        // ---------- Original Method ----------
        try {
            TreeSet<E> clone = (TreeSet<E>) super.clone();
            if (backingMap instanceof TreeMap) {
                clone.backingMap = (NavigableMap<E, Object>) ((TreeMap<E, Object>) backingMap)
                        .clone();
            } else {
                clone.backingMap = new TreeMap<E, Object>(backingMap);
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /**
     * Returns the comparator used to compare elements in this {@code TreeSet}.
     *
     * @return a Comparator or null if the natural ordering is used
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.858 -0500", hash_original_method = "15725AB8DA5A973CA6D3756CF495713E", hash_generated_method = "6EEA529A6B609A566059065CE51057E6")
    
public Comparator<? super E> comparator() {
        return backingMap.comparator();
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.549 -0400", hash_original_method = "B45AC88DE7B9594C8371B21B65FAB594", hash_generated_method = "861FF20C39960260BA63816D3660E6B9")
    @Override
    public Iterator<E> iterator() {
        return super.getIterator();
        // ---------- Original Method ----------
        //return backingMap.keySet().iterator();
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.549 -0400", hash_original_method = "5A7C74B47E5E24EDAEF18CEBD56ECC34", hash_generated_method = "985B1000856FE0C2D90F59DE62A312F9")
    public Iterator<E> descendingIterator() {
        return super.getReverseIterator();
        // ---------- Original Method ----------
        //return descendingSet().iterator();
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.550 -0400", hash_original_method = "4513FA2253D64848D60CCD34F380731F", hash_generated_method = "326AB076421601A1FA7897EB46E26059")
    public E first() {
        return super.getFirstElement();
        // ---------- Original Method ----------
        //return backingMap.firstKey();
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.550 -0400", hash_original_method = "4FE03970533DF6513B3C509D55D59969", hash_generated_method = "59265760E3EF80DCF16FAD0ABADA19DF")
    public E last() {
            return super.getLastElement();
        // ---------- Original Method ----------
        //return backingMap.lastKey();
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.551 -0400", hash_original_method = "C4703F0CB955C02A45F56DAC0B50011B", hash_generated_method = "430FC412772ED928A0B8CBF86430BEE9")
    public E pollFirst() {
        return super.removeFirstElement();
        // ---------- Original Method ----------
        //Map.Entry<E, Object> entry = backingMap.pollFirstEntry();
        //return (entry == null) ? null : entry.getKey();
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.551 -0400", hash_original_method = "F4F5E61D6851DE05B80C97EFA1D29318", hash_generated_method = "EC62C48804D72E4F44AACF87C1322107")
    public E pollLast() {
        return super.removeLastElement();
        // ---------- Original Method ----------
        //Map.Entry<E, Object> entry = backingMap.pollLastEntry();
        //return (entry == null) ? null : entry.getKey();
    }

    /**
     * {@inheritDoc}
     *
     * @see java.util.NavigableSet#higher(java.lang.Object)
     * @since 1.6
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.885 -0500", hash_original_method = "255C56AF04920CEFFC0E8FF16D0886BA", hash_generated_method = "BAB0A6DE3A0E5EEC383839F103BC1121")
    
public E higher(E e) {
        return backingMap.higherKey(e);
    }

    /**
     * {@inheritDoc}
     *
     * @see java.util.NavigableSet#lower(java.lang.Object)
     * @since 1.6
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.887 -0500", hash_original_method = "2923D8AB0DD9211CCF8AD13865FD4B03", hash_generated_method = "27EF061D4628915C35943B91D46B2980")
    
public E lower(E e) {
        return backingMap.lowerKey(e);
    }

    /**
     * {@inheritDoc}
     *
     * @see java.util.NavigableSet#ceiling(java.lang.Object)
     * @since 1.6
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.890 -0500", hash_original_method = "F02A103FC86BCAE7229665056FB74739", hash_generated_method = "4876CBCE7966F5366E623D71B6E25C42")
    
public E ceiling(E e) {
        return backingMap.ceilingKey(e);
    }

    /**
     * {@inheritDoc}
     *
     * @see java.util.NavigableSet#floor(java.lang.Object)
     * @since 1.6
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.892 -0500", hash_original_method = "09066F58D542F9425C5670329C148EFE", hash_generated_method = "305044D863F1396456C7C58F5FD6AC3C")
    
public E floor(E e) {
        return backingMap.floorKey(e);
    }

    /**
     * {@inheritDoc}
     *
     * @see java.util.NavigableSet#descendingSet()
     * @since 1.6
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.894 -0500", hash_original_method = "A6CC6F36D568F252AE741D0349E41073", hash_generated_method = "3CF353DEC30C2380750D2C8D95583DA4")
    
public NavigableSet<E> descendingSet() {
        return (descendingSet != null) ? descendingSet
                : (descendingSet = new TreeSet<E>(backingMap.descendingMap()));
    }

    /**
     * {@inheritDoc}
     *
     * @see java.util.NavigableSet#subSet(Object, boolean, Object, boolean)
     * @since 1.6
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.897 -0500", hash_original_method = "ED81F074F474A876A14D172DD54F12F1", hash_generated_method = "00943543B1A162988CEB2A4F8B35119B")
    
@SuppressWarnings("unchecked")
    public NavigableSet<E> subSet(E start, boolean startInclusive, E end,
            boolean endInclusive) {
        Comparator<? super E> c = backingMap.comparator();
        int compare = (c == null) ? ((Comparable<E>) start).compareTo(end) : c
                .compare(start, end);
        if (compare <= 0) {
            return new TreeSet<E>(backingMap.subMap(start, startInclusive, end,
                    endInclusive));
        }
        throw new IllegalArgumentException();
    }

    /**
     * {@inheritDoc}
     *
     * @see java.util.NavigableSet#headSet(Object, boolean)
     * @since 1.6
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.899 -0500", hash_original_method = "F84D7A45054DBC97192AC73FC2432832", hash_generated_method = "BADCA3D6E5B3206564BBFAF111706B2C")
    
@SuppressWarnings("unchecked")
    public NavigableSet<E> headSet(E end, boolean endInclusive) {
        // Check for errors
        Comparator<? super E> c = backingMap.comparator();
        if (c == null) {
            ((Comparable<E>) end).compareTo(end);
        } else {
            c.compare(end, end);
        }
        return new TreeSet<E>(backingMap.headMap(end, endInclusive));
    }

    /**
     * {@inheritDoc}
     *
     * @see java.util.NavigableSet#tailSet(Object, boolean)
     * @since 1.6
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.902 -0500", hash_original_method = "663A99D3FA4C192D3A7FF25E6DB9D983", hash_generated_method = "D36F1EE33754292EB0A457B00F2F8026")
    
@SuppressWarnings("unchecked")
    public NavigableSet<E> tailSet(E start, boolean startInclusive) {
        // Check for errors
        Comparator<? super E> c = backingMap.comparator();
        if (c == null) {
            ((Comparable<E>) start).compareTo(start);
        } else {
            c.compare(start, start);
        }
        return new TreeSet<E>(backingMap.tailMap(start, startInclusive));
    }

    /**
     * Returns a {@code SortedSet} of the specified portion of this {@code TreeSet} which
     * contains elements greater or equal to the start element but less than the
     * end element. The returned SortedSet is backed by this TreeSet so changes
     * to one are reflected by the other.
     *
     * @param start
     *            the start element
     * @param end
     *            the end element
     * @return a subset where the elements are greater or equal to
     *         <code>start</code> and less than <code>end</code>
     *
     * @exception ClassCastException
     *                when the start or end object cannot be compared with the
     *                elements in this TreeSet
     * @exception NullPointerException
     *                when the start or end object is null and the comparator
     *                cannot handle null
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.905 -0500", hash_original_method = "C92358BB1651ED2C24F4D6C79CD951E7", hash_generated_method = "261A1E8194C4A0B83586EABA1F1258A6")
    
@SuppressWarnings("unchecked")
    public SortedSet<E> subSet(E start, E end) {
        return subSet(start, true, end, false);
    }

    /**
     * Returns a {@code SortedSet} of the specified portion of this {@code TreeSet} which
     * contains elements less than the end element. The returned SortedSet is
     * backed by this TreeSet so changes to one are reflected by the other.
     *
     * @param end
     *            the end element
     * @return a subset where the elements are less than <code>end</code>
     *
     * @exception ClassCastException
     *                when the end object cannot be compared with the elements
     *                in this TreeSet
     * @exception NullPointerException
     *                when the end object is null and the comparator cannot
     *                handle null
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.907 -0500", hash_original_method = "B22F87137AF3AAA5F7ECED16F7688B46", hash_generated_method = "FCBD8B988A8139DB86114DBF3716E343")
    
@SuppressWarnings("unchecked")
    public SortedSet<E> headSet(E end) {
        return headSet(end, false);
    }

    /**
     * Returns a {@code SortedSet} of the specified portion of this {@code TreeSet} which
     * contains elements greater or equal to the start element. The returned
     * SortedSet is backed by this TreeSet so changes to one are reflected by
     * the other.
     *
     * @param start
     *            the start element
     * @return a subset where the elements are greater or equal to
     *         <code>start</code>
     *
     * @exception ClassCastException
     *                when the start object cannot be compared with the elements
     *                in this TreeSet
     * @exception NullPointerException
     *                when the start object is null and the comparator cannot
     *                handle null
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.910 -0500", hash_original_method = "D9366E253CBE1FE1D040B6F98C30B4A1", hash_generated_method = "8D2D3DBE95A0DB0C8135A9DD554761C5")
    
@SuppressWarnings("unchecked")
    public SortedSet<E> tailSet(E start) {
        return tailSet(start, true);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.913 -0500", hash_original_method = "99C17ADAEB11E32F56AB0674B65B4A86", hash_generated_method = "2F3DFE7FA121EB1EA6565E53426830EB")
    
private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(backingMap.comparator());
        int size = backingMap.size();
        stream.writeInt(size);
        if (size > 0) {
            Iterator<E> it = backingMap.keySet().iterator();
            while (it.hasNext()) {
                stream.writeObject(it.next());
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.916 -0500", hash_original_method = "675A9075CC9828201778F15727C38572", hash_generated_method = "1FB3794B815BD7ED90D65C97CC7299B0")
    
@SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        stream.defaultReadObject();
        TreeMap<E, Object> map = new TreeMap<E, Object>(
                (Comparator<? super E>) stream.readObject());
        int size = stream.readInt();
        if (size > 0) {
            for (int i=0; i<size; i++) {
                E elem = (E)stream.readObject();
                map.put(elem, Boolean.TRUE);
            }
        }
        backingMap = map;
    }
}

