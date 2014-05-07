package java.util.concurrent;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

import libcore.util.EmptyArray;
import libcore.util.Objects;

public class CopyOnWriteArrayList<E> implements List<E>, RandomAccess, Cloneable, Serializable {

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.950 -0500", hash_original_method = "C42EED85EE25206F94CCF01E5CEAD68C", hash_generated_method = "6B24A90E95A1434E966751946DCEB460")
    
static boolean containsAll(Collection<?> collection, Object[] snapshot, int from, int to) {
        for (Object o : collection) {
            if (indexOf(o, snapshot, from, to) == -1) {
                return false;
            }
        }
        return true;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.025 -0500", hash_original_method = "AE5D3DEFCCE0E3FC6EC46BC47A64D153", hash_generated_method = "55332F1BF88F2737B54A34D956F8DBAC")
    
static int lastIndexOf(Object o, Object[] data, int from, int to) {
        if (o == null) {
            for (int i = to - 1; i >= from; i--) {
                if (data[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = to - 1; i >= from; i--) {
                if (o.equals(data[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.027 -0500", hash_original_method = "504933ED8B334053A53FA397546C5B85", hash_generated_method = "C18CB0FE7B2EB3676356370B7238F27B")
    
static int indexOf(Object o, Object[] data, int from, int to) {
        if (o == null) {
            for (int i = from; i < to; i++) {
                if (data[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = from; i < to; i++) {
                if (o.equals(data[i])) {
                    return i;
                }
            }
        }
        return -1;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.923 -0500", hash_original_field = "45AA2F406EECE326B8FC46BAC40C64B4", hash_generated_field = "392EFB541281482E947C8FEFEB5A2F62")

    private static final long serialVersionUID = 8673264195747942595L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.926 -0500", hash_original_field = "66D8E00DB6C4DE41F495FA4BFC73A047", hash_generated_field = "9773C6104DBFF8AC92488F3C4AD39164")

    private transient volatile Object[] elements;

    /**
     * Creates a new empty instance.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.928 -0500", hash_original_method = "E357703A48348C8EEE9667190E563C6C", hash_generated_method = "E35E785C1CA6F25DCC940C5A7D20BFFD")
    
public CopyOnWriteArrayList() {
        elements = EmptyArray.OBJECT;
    }

    /**
     * Creates a new instance containing the elements of {@code collection}.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.932 -0500", hash_original_method = "84AACC1E4283EC6F676E4F2CD339FC5B", hash_generated_method = "055556F726947E25A73EAD27BE56F44C")
    
@SuppressWarnings("unchecked")
    public CopyOnWriteArrayList(Collection<? extends E> collection) {
        this((E[]) collection.toArray());
    }

    /**
     * Creates a new instance containing the elements of {@code array}.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.934 -0500", hash_original_method = "51C6AA63C04D903DC2F19EE7270C9A87", hash_generated_method = "CF8A43BBF7E32E1F34D4AA3517AE8F70")
    
public CopyOnWriteArrayList(E[] array) {
        this.elements = Arrays.copyOf(array, array.length, Object[].class);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.937 -0500", hash_original_method = "FF2ED4DF1B70DABD1A45F755E1952592", hash_generated_method = "09F8363AB090F7EA92B2D49E3162453A")
    
@Override public Object clone() {
        try {
            CopyOnWriteArrayList result = (CopyOnWriteArrayList) super.clone();
            result.elements = result.elements.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.939 -0500", hash_original_method = "68DC52534F60D1A5138253A79B12E67C", hash_generated_method = "F9DA793CCA7A2C61149490BBDD9BAC62")
    
public int size() {
        return elements.length;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.942 -0500", hash_original_method = "07C72EA93D8BC7AB1EE5326762E05E69", hash_generated_method = "B8501BC5823BDF19EB13EA69078CA5AF")
    
@SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) elements[index];
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.945 -0500", hash_original_method = "1274BF0858E749C3D9852E86C4A99C22", hash_generated_method = "6DA9BA6F033792CEAA68BABF51C0C85D")
    
public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.947 -0500", hash_original_method = "F181183DABCA5209C115C87B0BC63071", hash_generated_method = "EF0A8DFCAD171CA6E7FD057CE73091AB")
    
public boolean containsAll(Collection<?> collection) {
        Object[] snapshot = elements;
        return containsAll(collection, snapshot, 0, snapshot.length);
    }

    /**
     * Searches this list for {@code object} and returns the index of the first
     * occurrence that is at or after {@code from}.
     *
     * @return the index or -1 if the object was not found.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.952 -0500", hash_original_method = "8F838DDE7B5E08714D6360ECE6328BF5", hash_generated_method = "785125CFAC9AD265CFD59C5BB3AD7B87")
    
public int indexOf(E object, int from) {
        Object[] snapshot = elements;
        return indexOf(object, snapshot, from, snapshot.length);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.955 -0500", hash_original_method = "3333011450759BE4404CA7231EDCF09F", hash_generated_method = "1228E5BF23DB59CA54F76F52F6C50D92")
    
public int indexOf(Object object) {
        Object[] snapshot = elements;
        return indexOf(object, snapshot, 0, snapshot.length);
    }

    /**
     * Searches this list for {@code object} and returns the index of the last
     * occurrence that is before {@code to}.
     *
     * @return the index or -1 if the object was not found.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.957 -0500", hash_original_method = "19C8A04DC3A46E49A84DF6B57E1917A9", hash_generated_method = "CDBBAE7CB48B9ADBC68BDDBD3C5C1344")
    
public int lastIndexOf(E object, int to) {
        Object[] snapshot = elements;
        return lastIndexOf(object, snapshot, 0, to);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.959 -0500", hash_original_method = "D45902A72D19AFDC170F4A4D129ABA97", hash_generated_method = "D8EA9A9A72C7FD75C840EF61C473CA5B")
    
public int lastIndexOf(Object object) {
        Object[] snapshot = elements;
        return lastIndexOf(object, snapshot, 0, snapshot.length);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.962 -0500", hash_original_method = "E13DA7C33D486C9539B3B38ADEEDBA9D", hash_generated_method = "E4DC8687BF74F910B1F36F4C2363933E")
    
public boolean isEmpty() {
        return elements.length == 0;
    }

    /**
     * Returns an {@link Iterator} that iterates over the elements of this list
     * as they were at the time of this method call. Changes to the list made
     * after this method call will not be reflected by the iterator, nor will
     * they trigger a {@link ConcurrentModificationException}.
     *
     * <p>The returned iterator does not support {@link Iterator#remove()}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.964 -0500", hash_original_method = "8AC2A236339BBBFB218E3FC5088D17DA", hash_generated_method = "77F70A85A0D922984A0D35D762605E09")
    
public Iterator<E> iterator() {
        Object[] snapshot = elements;
        return new CowIterator<E>(snapshot, 0, snapshot.length);
    }

    /**
     * Returns a {@link ListIterator} that iterates over the elements of this
     * list as they were at the time of this method call. Changes to the list
     * made after this method call will not be reflected by the iterator, nor
     * will they trigger a {@link ConcurrentModificationException}.
     *
     * <p>The returned iterator does not support {@link ListIterator#add},
     * {@link ListIterator#set} or {@link Iterator#remove()},
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.966 -0500", hash_original_method = "6CF42CA16C3188E71052A9A04B3E4D16", hash_generated_method = "1A76DC37F1E5ACEE1723E409EC686FA8")
    
public ListIterator<E> listIterator(int index) {
        Object[] snapshot = elements;
        if (index < 0 || index > snapshot.length) {
            throw new IndexOutOfBoundsException("index=" + index + ", length=" + snapshot.length);
        }
        CowIterator<E> result = new CowIterator<E>(snapshot, 0, snapshot.length);
        result.index = index;
        return result;
    }

    /**
     * Equivalent to {@code listIterator(0)}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.969 -0500", hash_original_method = "A4A3425D1D4C041DAFB5C093D1247DF1", hash_generated_method = "CDADF80558F3C689DFFAE1740861B5F9")
    
public ListIterator<E> listIterator() {
        Object[] snapshot = elements;
        return new CowIterator<E>(snapshot, 0, snapshot.length);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.971 -0500", hash_original_method = "594A2D8CB57DB4B1D13107F70D453706", hash_generated_method = "CE88C9A85D8BD40C30A8ACB5DA660CE4")
    
public List<E> subList(int from, int to) {
        Object[] snapshot = elements;
        if (from < 0 || from > to || to > snapshot.length) {
            throw new IndexOutOfBoundsException("from=" + from + ", to=" + to +
                    ", list size=" + snapshot.length);
        }
        return new CowSubList(snapshot, from, to);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.973 -0500", hash_original_method = "49659221AAE3F1C0ECCE830D1E5CE8D1", hash_generated_method = "66C692977C354165146FAD59B7600B06")
    
public Object[] toArray() {
        return elements.clone();
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.850 -0400", hash_original_method = "C1E48E79962F836E76F520B2DEE3FDB8", hash_generated_method = "2906A4D4D1D1A23323A06045B06FBF69")
    @SuppressWarnings({"unchecked","SuspiciousSystemArraycopy"})
    public <T> T[] toArray(T[] contents) {
        addTaint(contents[0].getTaint());
        Object[] snapshot = elements;
        if(snapshot.length > contents.length)        
        {
T[] varAA242AD64FBF22E93B9DE930C2395AE0_337796799 =             (T[]) Arrays.copyOf(snapshot, snapshot.length, contents.getClass());
            varAA242AD64FBF22E93B9DE930C2395AE0_337796799.addTaint(getTaint());
            return varAA242AD64FBF22E93B9DE930C2395AE0_337796799;
        } //End block
        System.arraycopy(snapshot, 0, contents, 0, snapshot.length);
        if(snapshot.length < contents.length)        
        {
            contents[snapshot.length] = null;
        } //End block
T[] var5DC9C33EDB9F81CF1216538024B770BE_39742848 =         contents;
        var5DC9C33EDB9F81CF1216538024B770BE_39742848.addTaint(getTaint());
        return var5DC9C33EDB9F81CF1216538024B770BE_39742848;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //if (snapshot.length > contents.length) {
            //return (T[]) Arrays.copyOf(snapshot, snapshot.length, contents.getClass());
        //}
        //System.arraycopy(snapshot, 0, contents, 0, snapshot.length);
        //if (snapshot.length < contents.length) {
            //contents[snapshot.length] = null;
        //}
        //return contents;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.979 -0500", hash_original_method = "6010CBD888F6152118D77E36B5616E02", hash_generated_method = "95BA1BB990E57A82ECF905695CF62B33")
    
@Override public boolean equals(Object other) {
        if (other instanceof CopyOnWriteArrayList) {
            return this == other
                    || Arrays.equals(elements, ((CopyOnWriteArrayList<?>) other).elements);
        } else if (other instanceof List) {
            Object[] snapshot = elements;
            Iterator<?> i = ((List<?>) other).iterator();
            for (Object o : snapshot) {
                if (!i.hasNext() || !Objects.equal(o, i.next())) {
                    return false;
                }
            }
            return !i.hasNext();
        } else {
            return false;
        }
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.981 -0500", hash_original_method = "5CBAD38024C40A34FCDA1A3FF083FDEC", hash_generated_method = "7DC2C2D377925CE8F1E60FBC83A9BAB2")
    
@Override public int hashCode() {
        return Arrays.hashCode(elements);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.984 -0500", hash_original_method = "D569C6F4ED8C88274D5F2CC2C9F6FBD2", hash_generated_method = "F1E6EEE48B49AC857ED788D30B57C0FF")
    
@Override public String toString() {
        return Arrays.toString(elements);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.987 -0500", hash_original_method = "4C47893BDB4E93647009AE85D0DD4F0A", hash_generated_method = "705AC6CC224BC4A417F50CBB6261A6F8")
    
public synchronized boolean add(E e) {
        Object[] newElements = new Object[elements.length + 1];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        newElements[elements.length] = e;
        elements = newElements;
        return true;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.989 -0500", hash_original_method = "9DD013FF12CCDC2B9301BB35B7E69B98", hash_generated_method = "BF4A31867BFBDC774A42CA3DE2C5543A")
    
public synchronized void add(int index, E e) {
        Object[] newElements = new Object[elements.length + 1];
        System.arraycopy(elements, 0, newElements, 0, index);
        newElements[index] = e;
        System.arraycopy(elements, index, newElements, index + 1, elements.length - index);
        elements = newElements;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.992 -0500", hash_original_method = "76766E6A3193E0133903AC8237158932", hash_generated_method = "D4F569A652C595934F2B46B92806C013")
    
public synchronized boolean addAll(Collection<? extends E> collection) {
        return addAll(elements.length, collection);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.995 -0500", hash_original_method = "16622B391256B6F864845FABB18695E4", hash_generated_method = "B2639FD4CF4C0E7F8A484D4EB91B659C")
    
public synchronized boolean addAll(int index, Collection<? extends E> collection) {
        Object[] toAdd = collection.toArray();
        Object[] newElements = new Object[elements.length + toAdd.length];
        System.arraycopy(elements, 0, newElements, 0, index);
        System.arraycopy(toAdd, 0, newElements, index, toAdd.length);
        System.arraycopy(elements, index,
                newElements, index + toAdd.length, elements.length - index);
        elements = newElements;
        return toAdd.length > 0;
    }

    /**
     * Adds the elements of {@code collection} that are not already present in
     * this list. If {@code collection} includes a repeated value, at most one
     * occurrence of that value will be added to this list. Elements are added
     * at the end of this list.
     *
     * <p>Callers of this method may prefer {@link CopyOnWriteArraySet}, whose
     * API is more appropriate for set operations.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.998 -0500", hash_original_method = "F6411BBDC5A81E1C464E9CEEEB8CCCF0", hash_generated_method = "1530D6362C247347C74805FFE0476B68")
    
public synchronized int addAllAbsent(Collection<? extends E> collection) {
        Object[] toAdd = collection.toArray();
        Object[] newElements = new Object[elements.length + toAdd.length];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        int addedCount = 0;
        for (Object o : toAdd) {
            if (indexOf(o, newElements, 0, elements.length + addedCount) == -1) {
                newElements[elements.length + addedCount++] = o;
            }
        }
        if (addedCount < toAdd.length) {
            newElements = Arrays.copyOfRange(
                    newElements, 0, elements.length + addedCount); // trim to size
        }
        elements = newElements;
        return addedCount;
    }

    /**
     * Adds {@code object} to the end of this list if it is not already present.
     *
     * <p>Callers of this method may prefer {@link CopyOnWriteArraySet}, whose
     * API is more appropriate for set operations.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.000 -0500", hash_original_method = "17D643777423FC6042E703F36B3EB43F", hash_generated_method = "56919D2D9BA5B4BE1BFCFEB430260039")
    
public synchronized boolean addIfAbsent(E object) {
        if (contains(object)) {
            return false;
        }
        add(object);
        return true;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.003 -0500", hash_original_method = "343DE0C64B38A0F7CE33FC0930F8B1CE", hash_generated_method = "BC538F2B1E8623592395CB5158B89D9B")
    
@Override public synchronized void clear() {
        elements = EmptyArray.OBJECT;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.006 -0500", hash_original_method = "83ED6C7BC28A1565457859811EDD5A3A", hash_generated_method = "B9B20CC48173A0B993B8065C80E3FC1D")
    
public synchronized E remove(int index) {
        @SuppressWarnings("unchecked")
        E removed = (E) elements[index];
        removeRange(index, index + 1);
        return removed;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.008 -0500", hash_original_method = "4348B5D441F5A12C585788ED2765C3A4", hash_generated_method = "BF729F951ED65072D4AE55B003AB21A7")
    
public synchronized boolean remove(Object o) {
        int index = indexOf(o);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.011 -0500", hash_original_method = "1C7B7BE5468A5E30603ED6851F28BACD", hash_generated_method = "B58C465C19D7C5E1DEF895B1132ADA61")
    
public synchronized boolean removeAll(Collection<?> collection) {
        return removeOrRetain(collection, false, 0, elements.length) != 0;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.014 -0500", hash_original_method = "6F7BCA7B0FD040BA943A37C2A3FEA10F", hash_generated_method = "4D5A066BB20A3B18DE0CC873BCD48514")
    
public synchronized boolean retainAll(Collection<?> collection) {
        return removeOrRetain(collection, true, 0, elements.length) != 0;
    }

    /**
     * Removes or retains the elements in {@code collection}. Returns the number
     * of elements removed.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.017 -0500", hash_original_method = "4C6E97480A096674EA078C65954A8FE2", hash_generated_method = "47D239EC4D7FBBF93E23B211D4E97D64")
    
private int removeOrRetain(Collection<?> collection, boolean retain, int from, int to) {
        for (int i = from; i < to; i++) {
            if (collection.contains(elements[i]) == retain) {
                continue;
            }

            /*
             * We've encountered an element that must be removed! Create a new
             * array and copy in the surviving elements one by one.
             */
            Object[] newElements = new Object[elements.length - 1];
            System.arraycopy(elements, 0, newElements, 0, i);
            int newSize = i;
            for (int j = i + 1; j < to; j++) {
                if (collection.contains(elements[j]) == retain) {
                    newElements[newSize++] = elements[j];
                }
            }

            /*
             * Copy the elements after 'to'. This is only useful for sub lists,
             * where 'to' will be less than elements.length.
             */
            System.arraycopy(elements, to, newElements, newSize, elements.length - to);
            newSize += (elements.length - to);

            if (newSize < newElements.length) {
                newElements = Arrays.copyOfRange(newElements, 0, newSize); // trim to size
            }
            int removed = elements.length - newElements.length;
            elements = newElements;
            return removed;
        }

        // we made it all the way through the loop without making any changes
        return 0;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.020 -0500", hash_original_method = "DD4407442CC828B95DFD10F580DA2DDA", hash_generated_method = "B675E951E2B618950D3AB8DB9CB4F22C")
    
public synchronized E set(int index, E e) {
        Object[] newElements = elements.clone();
        @SuppressWarnings("unchecked")
        E result = (E) newElements[index];
        newElements[index] = e;
        elements = newElements;
        return result;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.022 -0500", hash_original_method = "3E2723924788C644A99252EDEC8904D6", hash_generated_method = "0A2000680A1776B7FB92BBE05211E1B7")
    
private void removeRange(int from, int to) {
        Object[] newElements = new Object[elements.length - (to - from)];
        System.arraycopy(elements, 0, newElements, 0, from);
        System.arraycopy(elements, to, newElements, from, elements.length - to);
        elements = newElements;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.029 -0500", hash_original_method = "223CD20A6350F975434ED49A9EB8E646", hash_generated_method = "1C0E5B506CC6D74BA562E67AA4D5265F")
    
final Object[] getArray() {
        // CopyOnWriteArraySet needs this.
        return elements;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.161 -0500", hash_original_method = "53FDF52EC3502469838FF7FC9C3722C1", hash_generated_method = "2AFECBE8B96C55694756BAEE30187895")
    
private void writeObject(ObjectOutputStream out) throws IOException {
        Object[] snapshot = elements;
        out.defaultWriteObject();
        out.writeInt(snapshot.length);
        for (Object o : snapshot) {
            out.writeObject(o);
        }
    }
    
    class CowSubList extends AbstractList<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.032 -0500", hash_original_field = "5C9767232AD9DD28D27839A4405D545E", hash_generated_field = "8800B1EC4033F6ED9C1D3C210D1DF359")

        private volatile Slice slice;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.035 -0500", hash_original_method = "19F9B6A2C098797122B64953C4557260", hash_generated_method = "21275100E1A9BA1B3596EC4CD80BBF68")
        
public CowSubList(Object[] expectedElements, int from, int to) {
            this.slice = new Slice(expectedElements, from, to);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.038 -0500", hash_original_method = "50828BB5D9839792ECEF31A7338C6C2F", hash_generated_method = "504DB1A3D6A4F057A48FC6607E3256F4")
        
@Override public int size() {
            Slice slice = this.slice;
            return slice.to - slice.from;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.040 -0500", hash_original_method = "9FA55EF0B71DE676ACDFCDE8D001E08C", hash_generated_method = "CC2A68CF6742DE66405DD2F08EF86A83")
        
@Override public boolean isEmpty() {
            Slice slice = this.slice;
            return slice.from == slice.to;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.044 -0500", hash_original_method = "E9398BCB1605EBC5A566CA332DEC078B", hash_generated_method = "DBC29EA8CCFF76F6BD9D84C497AB8BE7")
        
@SuppressWarnings("unchecked")
        @Override public E get(int index) {
            Slice slice = this.slice;
            Object[] snapshot = elements;
            slice.checkElementIndex(index);
            slice.checkConcurrentModification(snapshot);
            return (E) snapshot[index + slice.from];
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.046 -0500", hash_original_method = "1D00ECD22B3575A885077212162F97B2", hash_generated_method = "F8A35E883987D86B173CE6E6651B4120")
        
@Override public Iterator<E> iterator() {
            return listIterator(0);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.049 -0500", hash_original_method = "DF7BE0B13ABC5A9B1C74313BD06FB64C", hash_generated_method = "BFE08F68D525BB3FE20C89D63996BF59")
        
@Override public ListIterator<E> listIterator() {
            return listIterator(0);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.052 -0500", hash_original_method = "2453E5226E92CA007A5F28D50241AFEC", hash_generated_method = "9D2FCD7D917684EBA1D8898953D2D6C5")
        
@Override public ListIterator<E> listIterator(int index) {
            Slice slice = this.slice;
            Object[] snapshot = elements;
            slice.checkPositionIndex(index);
            slice.checkConcurrentModification(snapshot);
            CowIterator<E> result = new CowIterator<E>(snapshot, slice.from, slice.to);
            result.index = slice.from + index;
            return result;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.054 -0500", hash_original_method = "3CF9433C05AE07A5EB66F121888070F6", hash_generated_method = "BA1510C786635CE596E4EEDEBBE89B2A")
        
@Override public int indexOf(Object object) {
            Slice slice = this.slice;
            Object[] snapshot = elements;
            slice.checkConcurrentModification(snapshot);
            int result = CopyOnWriteArrayList.indexOf(object, snapshot, slice.from, slice.to);
            return (result != -1) ? (result - slice.from) : -1;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.057 -0500", hash_original_method = "1CFCD041D8AD8CF1B36536A28BABB7D9", hash_generated_method = "AEE782D630FCCBB7A7BE67471BF7485E")
        
@Override public int lastIndexOf(Object object) {
            Slice slice = this.slice;
            Object[] snapshot = elements;
            slice.checkConcurrentModification(snapshot);
            int result = CopyOnWriteArrayList.lastIndexOf(object, snapshot, slice.from, slice.to);
            return (result != -1) ? (result - slice.from) : -1;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.061 -0500", hash_original_method = "3D9C8519C0BA49AAEEEEE7D259DD1898", hash_generated_method = "5F43988D6D913A9B82AACBDB6A2843D4")
        
@Override public boolean contains(Object object) {
            return indexOf(object) != -1;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.063 -0500", hash_original_method = "1CE1F4665E7580AB233B83935273A194", hash_generated_method = "724E596103E5CED5748A07EDC5268EBC")
        
@Override public boolean containsAll(Collection<?> collection) {
            Slice slice = this.slice;
            Object[] snapshot = elements;
            slice.checkConcurrentModification(snapshot);
            return CopyOnWriteArrayList.containsAll(collection, snapshot, slice.from, slice.to);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.066 -0500", hash_original_method = "023D8E294D6742BA836A68C5ADAAB497", hash_generated_method = "A109CD9BEA09110C104908A613D35D4F")
        
@Override public List<E> subList(int from, int to) {
            Slice slice = this.slice;
            if (from < 0 || from > to || to > size()) {
                throw new IndexOutOfBoundsException("from=" + from + ", to=" + to +
                        ", list size=" + size());
            }
            return new CowSubList(slice.expectedElements, slice.from + from, slice.from + to);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.069 -0500", hash_original_method = "F47D7AB044AE200CBA9EE898533B8FEC", hash_generated_method = "C83C026C1A3BF7CD253A327951590626")
        
@Override public E remove(int index) {
            synchronized (CopyOnWriteArrayList.this) {
                slice.checkElementIndex(index);
                slice.checkConcurrentModification(elements);
                E removed = CopyOnWriteArrayList.this.remove(slice.from + index);
                slice = new Slice(elements, slice.from, slice.to - 1);
                return removed;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.072 -0500", hash_original_method = "E7748E0E6765940072A4C93526FE4787", hash_generated_method = "611BD9FCE967231409C31C57D0DB9D61")
        
@Override public void clear() {
            synchronized (CopyOnWriteArrayList.this) {
                slice.checkConcurrentModification(elements);
                CopyOnWriteArrayList.this.removeRange(slice.from, slice.to);
                slice = new Slice(elements, slice.from, slice.from);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.074 -0500", hash_original_method = "7558F5D9173C65FEAD4E275F1C1E5A80", hash_generated_method = "27BF70741A7A475BC5EE00180DF8341A")
        
@Override public void add(int index, E object) {
            synchronized (CopyOnWriteArrayList.this) {
                slice.checkPositionIndex(index);
                slice.checkConcurrentModification(elements);
                CopyOnWriteArrayList.this.add(index + slice.from, object);
                slice = new Slice(elements, slice.from, slice.to + 1);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.077 -0500", hash_original_method = "E905080D7BBE0BD2F3F279BF8EF6D6A8", hash_generated_method = "412E8014F05227CB652CFEB14C702C69")
        
@Override public boolean add(E object) {
            synchronized (CopyOnWriteArrayList.this) {
                add(slice.to - slice.from, object);
                return true;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.080 -0500", hash_original_method = "1293804DB9B63143F37D5D821EA6A87E", hash_generated_method = "DD7E952FEE7A917CC25769C0A8E36030")
        
@Override public boolean addAll(int index, Collection<? extends E> collection) {
            synchronized (CopyOnWriteArrayList.this) {
                slice.checkPositionIndex(index);
                slice.checkConcurrentModification(elements);
                int oldSize = elements.length;
                boolean result = CopyOnWriteArrayList.this.addAll(index + slice.from, collection);
                slice = new Slice(elements, slice.from, slice.to + (elements.length - oldSize));
                return result;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.083 -0500", hash_original_method = "2FF5E8554EDDACF9F2F627214E3BC10D", hash_generated_method = "9446E355FA8A0E6AD2743254D92175A2")
        
@Override public boolean addAll(Collection<? extends E> collection) {
            synchronized (CopyOnWriteArrayList.this) {
                return addAll(size(), collection);
            }
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.085 -0500", hash_original_method = "E52798445FC11575DB685349896EB8F6", hash_generated_method = "AC3D2814FB6C7232080B438F73BAB72F")
        
@Override public E set(int index, E object) {
            synchronized (CopyOnWriteArrayList.this) {
                slice.checkElementIndex(index);
                slice.checkConcurrentModification(elements);
                E result = CopyOnWriteArrayList.this.set(index + slice.from, object);
                slice = new Slice(elements, slice.from, slice.to);
                return result;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.088 -0500", hash_original_method = "924C9E5471F08F30B8E12AD962D48DF2", hash_generated_method = "8EC1A5EB60FF01C4790CE022314C8794")
        
@Override public boolean remove(Object object) {
            synchronized (CopyOnWriteArrayList.this) {
                int index = indexOf(object);
                if (index == -1) {
                    return false;
                }
                remove(index);
                return true;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.090 -0500", hash_original_method = "6ECA6BCBA1861C546E018F40208C7C7C", hash_generated_method = "0669989DAC34CFE7088458920EA5DD4B")
        
@Override public boolean removeAll(Collection<?> collection) {
            synchronized (CopyOnWriteArrayList.this) {
                slice.checkConcurrentModification(elements);
                int removed = removeOrRetain(collection, false, slice.from, slice.to);
                slice = new Slice(elements, slice.from, slice.to - removed);
                return removed != 0;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.093 -0500", hash_original_method = "055B3FCFE954B48BD2D5F95BFF90FFFE", hash_generated_method = "3A1ED23174ADFAA4196C923BB99D6BB6")
        
@Override public boolean retainAll(Collection<?> collection) {
            synchronized (CopyOnWriteArrayList.this) {
                slice.checkConcurrentModification(elements);
                int removed = removeOrRetain(collection, true, slice.from, slice.to);
                slice = new Slice(elements, slice.from, slice.to - removed);
                return removed != 0;
            }
        }
        
    }
    
    static class Slice {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.101 -0500", hash_original_field = "D17B5E4901DA076A46C305F8F53600EB", hash_generated_field = "578E1B95CBBB0F53A72648DE31016F3A")

        private  Object[] expectedElements;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.103 -0500", hash_original_field = "6323710AADAB082EA32AF6193466B2AC", hash_generated_field = "98A0E6E2AB8AB9E19CC3F35C494E6A79")

        private  int from;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.106 -0500", hash_original_field = "7919D837C2297339330E1D3984F72596", hash_generated_field = "BDB6664DDCCB6D4D52DFAB8483E3BBDE")

        private  int to;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.109 -0500", hash_original_method = "83A1C0AAD9B8B03E61B8B75E1CD914D7", hash_generated_method = "83A1C0AAD9B8B03E61B8B75E1CD914D7")
        
Slice(Object[] expectedElements, int from, int to) {
            this.expectedElements = expectedElements;
            this.from = from;
            this.to = to;
        }

        /**
         * Throws if {@code index} doesn't identify an element in the array.
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.111 -0500", hash_original_method = "C41DDBF64E4B04157ED5EDFC21AF561C", hash_generated_method = "C41DDBF64E4B04157ED5EDFC21AF561C")
        
void checkElementIndex(int index) {
            if (index < 0 || index >= to - from) {
                throw new IndexOutOfBoundsException("index=" + index + ", size=" + (to - from));
            }
        }

        /**
         * Throws if {@code index} doesn't identify an insertion point in the
         * array. Unlike element index, it's okay to add or iterate at size().
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.113 -0500", hash_original_method = "D022C90E4388D47B06DB5C9D4119BF1C", hash_generated_method = "D022C90E4388D47B06DB5C9D4119BF1C")
        
void checkPositionIndex(int index) {
            if (index < 0 || index > to - from) {
                throw new IndexOutOfBoundsException("index=" + index + ", size=" + (to - from));
            }
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.116 -0500", hash_original_method = "7DF1E46EED7497F4680296245E77E1DC", hash_generated_method = "7DF1E46EED7497F4680296245E77E1DC")
        
void checkConcurrentModification(Object[] snapshot) {
            if (expectedElements != snapshot) {
                throw new ConcurrentModificationException();
            }
        }
        
    }
    
    static class CowIterator<E> implements ListIterator<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.120 -0500", hash_original_field = "674A3857E57B137834DC0350BE12C2A4", hash_generated_field = "FEC1DD40EAC9BB9175BC6E1CF39F3785")

        private  Object[] snapshot;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.124 -0500", hash_original_field = "6323710AADAB082EA32AF6193466B2AC", hash_generated_field = "98A0E6E2AB8AB9E19CC3F35C494E6A79")

        private  int from;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.127 -0500", hash_original_field = "7919D837C2297339330E1D3984F72596", hash_generated_field = "BDB6664DDCCB6D4D52DFAB8483E3BBDE")

        private  int to;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.130 -0500", hash_original_field = "47C32AAF84C84D33B0EA3C852250FE1D", hash_generated_field = "AE5C9711C7D27D5EECF32B3638DBE7E5")

        private int index = 0;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.133 -0500", hash_original_method = "E0987AFDD42E4364FE4BB0FD3F1A0501", hash_generated_method = "E0987AFDD42E4364FE4BB0FD3F1A0501")
        
CowIterator(Object[] snapshot, int from, int to) {
            this.snapshot = snapshot;
            this.from = from;
            this.to = to;
            this.index = from;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.135 -0500", hash_original_method = "960DAE05B3D69FE5F79E9628DB5B33E6", hash_generated_method = "09044AB72C380E5A65BD298B40EDEDFB")
        
public void add(E object) {
            throw new UnsupportedOperationException();
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.138 -0500", hash_original_method = "D639D4E7D9CD50DE4105991F3953FD80", hash_generated_method = "2873F607AF1472B18F1E6FAB71BCBCB5")
        
public boolean hasNext() {
            return index < to;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.140 -0500", hash_original_method = "EC30B2CF9A7B23E69047D11D06EFA3CA", hash_generated_method = "D1E328A7D3697E43D6918D860FC0303C")
        
public boolean hasPrevious() {
            return index > from;
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.143 -0500", hash_original_method = "32D582641092A62093AF5BD2A9D350AD", hash_generated_method = "BABFCAD02FB6CF8FD9AD6A843B7086B3")
        
@SuppressWarnings("unchecked")
        public E next() {
            if (index < to) {
                return (E) snapshot[index++];
            } else {
                throw new NoSuchElementException();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.145 -0500", hash_original_method = "B3E96A2468FAF72FDE35394237D3EDCC", hash_generated_method = "8630C847C2E97AE765852CBF665BFF4D")
        
public int nextIndex() {
            return index;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.148 -0500", hash_original_method = "7AA7D7DC0436E32BBB89C3C957160D69", hash_generated_method = "90D65BE9E43DF5A31B8350A51BE73E34")
        
@SuppressWarnings("unchecked")
        public E previous() {
            if (index > from) {
                return (E) snapshot[--index];
            } else {
                throw new NoSuchElementException();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.151 -0500", hash_original_method = "30EF9C1C05880C206BCB89722B1108E9", hash_generated_method = "BD9A67D1F94F968F58867CE4BD2415BC")
        
public int previousIndex() {
            return index - 1;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.153 -0500", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "5B2A4852FF2684177E07742561C615C2")
        
public void remove() {
            throw new UnsupportedOperationException();
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.156 -0500", hash_original_method = "1001E1C2B2FD09C7DE97126421AC0A91", hash_generated_method = "0DB69E3C790FE7C9C5203D0164F78DAC")
        
public void set(E object) {
            throw new UnsupportedOperationException();
        }
        
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:18.163 -0500", hash_original_method = "5D8878D7111BA02D76F457F9A02251F1", hash_generated_method = "AC2D919729F64A6C1DFB88AC24ED42FC")
    
private synchronized void readObject(ObjectInputStream in)
            throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        Object[] snapshot = new Object[in.readInt()];
        for (int i = 0; i < snapshot.length; i++) {
            snapshot[i] = in.readObject();
        }
        elements = snapshot;
    }
}

