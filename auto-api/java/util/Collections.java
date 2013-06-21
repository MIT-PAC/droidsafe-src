package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Array;

public class Collections {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.594 -0400", hash_original_method = "0C1BC548FC19EEB6A684F12763720939", hash_generated_method = "F5EC8594995493427AAF50F2EB8C349F")
    @DSModeled(DSC.SAFE)
    private Collections() {
        // ---------- Original Method ----------
    }

    
        @SuppressWarnings("unchecked")
    public static <T> int binarySearch(List<? extends Comparable<? super T>> list, T object) {
        if (list == null) {
            throw new NullPointerException();
        }
        if (list.isEmpty()) {
            return -1;
        }
        if (!(list instanceof RandomAccess)) {
            ListIterator<? extends Comparable<? super T>> it = list.listIterator();
            while (it.hasNext()) {
                int result;
                if ((result = -it.next().compareTo(object)) <= 0) {
                    if (result == 0) {
                        return it.previousIndex();
                    }
                    return -it.previousIndex() - 1;
                }
            }
            return -list.size() - 1;
        }
        int low = 0, mid = list.size(), high = mid - 1, result = -1;
        while (low <= high) {
            mid = (low + high) >>> 1;
            if ((result = -list.get(mid).compareTo(object)) > 0) {
                low = mid + 1;
            } else if (result == 0) {
                return mid;
            } else {
                high = mid - 1;
            }
        }
        return -mid - (result < 0 ? 1 : 2);
    }

    
        @SuppressWarnings("unchecked")
    public static <T> int binarySearch(List<? extends T> list, T object,
            Comparator<? super T> comparator) {
        if (comparator == null) {
            return Collections.binarySearch(
                    (List<? extends Comparable<? super T>>) list, object);
        }
        if (!(list instanceof RandomAccess)) {
            ListIterator<? extends T> it = list.listIterator();
            while (it.hasNext()) {
                int result;
                if ((result = -comparator.compare(it.next(), object)) <= 0) {
                    if (result == 0) {
                        return it.previousIndex();
                    }
                    return -it.previousIndex() - 1;
                }
            }
            return -list.size() - 1;
        }
        int low = 0, mid = list.size(), high = mid - 1, result = -1;
        while (low <= high) {
            mid = (low + high) >>> 1;
            if ((result = -comparator.compare(list.get(mid), object)) > 0) {
                low = mid + 1;
            } else if (result == 0) {
                return mid;
            } else {
                high = mid - 1;
            }
        }
        return -mid - (result < 0 ? 1 : 2);
    }

    
        public static <T> void copy(List<? super T> destination, List<? extends T> source) {
        if (destination.size() < source.size()) {
            throw new IndexOutOfBoundsException("destination.size() < source.size(): " +
                    destination.size() + " < " + source.size());
        }
        Iterator<? extends T> srcIt = source.iterator();
        ListIterator<? super T> destIt = destination.listIterator();
        while (srcIt.hasNext()) {
            try {
                destIt.next();
            } catch (NoSuchElementException e) {
                throw new IndexOutOfBoundsException("Source size " + source.size() +
                        " does not fit into destination");
            }
            destIt.set(srcIt.next());
        }
    }

    
        public static <T> Enumeration<T> enumeration(Collection<T> collection) {
        final Collection<T> c = collection;
        return new Enumeration<T>() {
            Iterator<T> it = c.iterator();
            @Override public boolean hasMoreElements() {
                return it.hasNext();
            }
            @Override public T nextElement() {
                return it.next();
            }
        };
    }

    
        public static <T> void fill(List<? super T> list, T object) {
        ListIterator<? super T> it = list.listIterator();
        while (it.hasNext()) {
            it.next();
            it.set(object);
        }
    }

    
        public static <T extends Object & Comparable<? super T>> T max(
            Collection<? extends T> collection) {
        Iterator<? extends T> it = collection.iterator();
        T max = it.next();
        while (it.hasNext()) {
            T next = it.next();
            if (max.compareTo(next) < 0) {
                max = next;
            }
        }
        return max;
    }

    
        public static <T> T max(Collection<? extends T> collection,
            Comparator<? super T> comparator) {
        if (comparator == null) {
            @SuppressWarnings("unchecked") 
            T result = (T) max((Collection<Comparable>) collection);
            return result;
        }
        Iterator<? extends T> it = collection.iterator();
        T max = it.next();
        while (it.hasNext()) {
            T next = it.next();
            if (comparator.compare(max, next) < 0) {
                max = next;
            }
        }
        return max;
    }

    
        public static <T extends Object & Comparable<? super T>> T min(
            Collection<? extends T> collection) {
        Iterator<? extends T> it = collection.iterator();
        T min = it.next();
        while (it.hasNext()) {
            T next = it.next();
            if (min.compareTo(next) > 0) {
                min = next;
            }
        }
        return min;
    }

    
        public static <T> T min(Collection<? extends T> collection,
            Comparator<? super T> comparator) {
        if (comparator == null) {
            @SuppressWarnings("unchecked") 
            T result = (T) min((Collection<Comparable>) collection);
            return result;
        }
        Iterator<? extends T> it = collection.iterator();
        T min = it.next();
        while (it.hasNext()) {
            T next = it.next();
            if (comparator.compare(min, next) > 0) {
                min = next;
            }
        }
        return min;
    }

    
        public static <T> List<T> nCopies(final int length, T object) {
        return new CopiesList<T>(length, object);
    }

    
        @SuppressWarnings("unchecked")
    public static void reverse(List<?> list) {
        int size = list.size();
        ListIterator<Object> front = (ListIterator<Object>) list.listIterator();
        ListIterator<Object> back = (ListIterator<Object>) list
                .listIterator(size);
        for (int i = 0; i < size / 2; i++) {
            Object frontNext = front.next();
            Object backPrev = back.previous();
            front.set(backPrev);
            back.set(frontNext);
        }
    }

    
        @SuppressWarnings("unchecked")
    public static <T> Comparator<T> reverseOrder() {
        return (Comparator) ReverseComparator.INSTANCE;
    }

    
        public static <T> Comparator<T> reverseOrder(Comparator<T> c) {
        if (c == null) {
            return reverseOrder();
        }
        if (c instanceof ReverseComparator2) {
            return ((ReverseComparator2<T>) c).cmp;
        }
        return new ReverseComparator2<T>(c);
    }

    
        public static void shuffle(List<?> list) {
        shuffle(list, new Random());
    }

    
        public static void shuffle(List<?> list, Random random) {
        @SuppressWarnings("unchecked") 
        final List<Object> objectList = (List<Object>) list;
        if (list instanceof RandomAccess) {
            for (int i = objectList.size() - 1; i > 0; i--) {
                int index = random.nextInt(i + 1);
                objectList.set(index, objectList.set(i, objectList.get(index)));
            }
        } else {
            Object[] array = objectList.toArray();
            for (int i = array.length - 1; i > 0; i--) {
                int index = random.nextInt(i + 1);
                Object temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
            int i = 0;
            ListIterator<Object> it = objectList.listIterator();
            while (it.hasNext()) {
                it.next();
                it.set(array[i++]);
            }
        }
    }

    
        public static <E> Set<E> singleton(E object) {
        return new SingletonSet<E>(object);
    }

    
        public static <E> List<E> singletonList(E object) {
        return new SingletonList<E>(object);
    }

    
        public static <K, V> Map<K, V> singletonMap(K key, V value) {
        return new SingletonMap<K, V>(key, value);
    }

    
        @SuppressWarnings("unchecked")
    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        Object[] array = list.toArray();
        Arrays.sort(array);
        int i = 0;
        ListIterator<T> it = list.listIterator();
        while (it.hasNext()) {
            it.next();
            it.set((T) array[i++]);
        }
    }

    
        @SuppressWarnings("unchecked")
    public static <T> void sort(List<T> list, Comparator<? super T> comparator) {
        T[] array = list.toArray((T[]) new Object[list.size()]);
        Arrays.sort(array, comparator);
        int i = 0;
        ListIterator<T> it = list.listIterator();
        while (it.hasNext()) {
            it.next();
            it.set(array[i++]);
        }
    }

    
        @SuppressWarnings("unchecked")
    public static void swap(List<?> list, int index1, int index2) {
        if (list == null) {
            throw new NullPointerException();
        }
        final int size = list.size();
        if (index1 < 0 || index1 >= size || index2 < 0 || index2 >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index1 == index2) {
            return;
        }
        List<Object> rawList = (List<Object>) list;
        rawList.set(index2, rawList.set(index1, rawList.get(index2)));
    }

    
        public static <T> boolean replaceAll(List<T> list, T obj, T obj2) {
        int index;
        boolean found = false;
        while ((index = list.indexOf(obj)) > -1) {
            found = true;
            list.set(index, obj2);
        }
        return found;
    }

    
        @SuppressWarnings("unchecked")
    public static void rotate(List<?> lst, int dist) {
        List<Object> list = (List<Object>) lst;
        int size = list.size();
        if (size == 0) {
            return;
        }
        int normdist;
        if (dist > 0) {
            normdist = dist % size;
        } else {
            normdist = size - ((dist % size) * (-1));
        }
        if (normdist == 0 || normdist == size) {
            return;
        }
        if (list instanceof RandomAccess) {
            Object temp = list.get(0);
            int index = 0, beginIndex = 0;
            for (int i = 0; i < size; i++) {
                index = (index + normdist) % size;
                temp = list.set(index, temp);
                if (index == beginIndex) {
                    index = ++beginIndex;
                    temp = list.get(beginIndex);
                }
            }
        } else {
            int divideIndex = (size - normdist) % size;
            List<Object> sublist1 = list.subList(0, divideIndex);
            List<Object> sublist2 = list.subList(divideIndex, size);
            reverse(sublist1);
            reverse(sublist2);
            reverse(list);
        }
    }

    
        public static int indexOfSubList(List<?> list, List<?> sublist) {
        int size = list.size();
        int sublistSize = sublist.size();
        if (sublistSize > size) {
            return -1;
        }
        if (sublistSize == 0) {
            return 0;
        }
        Object firstObj = sublist.get(0);
        int index = list.indexOf(firstObj);
        if (index == -1) {
            return -1;
        }
        while (index < size && (size - index >= sublistSize)) {
            ListIterator<?> listIt = list.listIterator(index);
            if ((firstObj == null) ? listIt.next() == null : firstObj
                    .equals(listIt.next())) {
                ListIterator<?> sublistIt = sublist.listIterator(1);
                boolean difFound = false;
                while (sublistIt.hasNext()) {
                    Object element = sublistIt.next();
                    if (!listIt.hasNext()) {
                        return -1;
                    }
                    if ((element == null) ? listIt.next() != null : !element
                            .equals(listIt.next())) {
                        difFound = true;
                        break;
                    }
                }
                if (!difFound) {
                    return index;
                }
            }
            index++;
        }
        return -1;
    }

    
        public static int lastIndexOfSubList(List<?> list, List<?> sublist) {
        int sublistSize = sublist.size();
        int size = list.size();
        if (sublistSize > size) {
            return -1;
        }
        if (sublistSize == 0) {
            return size;
        }
        Object lastObj = sublist.get(sublistSize - 1);
        int index = list.lastIndexOf(lastObj);
        while ((index > -1) && (index + 1 >= sublistSize)) {
            ListIterator<?> listIt = list.listIterator(index + 1);
            if ((lastObj == null) ? listIt.previous() == null : lastObj
                    .equals(listIt.previous())) {
                ListIterator<?> sublistIt = sublist
                        .listIterator(sublistSize - 1);
                boolean difFound = false;
                while (sublistIt.hasPrevious()) {
                    Object element = sublistIt.previous();
                    if (!listIt.hasPrevious()) {
                        return -1;
                    }
                    if ((element == null) ? listIt.previous() != null
                            : !element.equals(listIt.previous())) {
                        difFound = true;
                        break;
                    }
                }
                if (!difFound) {
                    return listIt.nextIndex();
                }
            }
            index--;
        }
        return -1;
    }

    
        public static <T> ArrayList<T> list(Enumeration<T> enumeration) {
        ArrayList<T> list = new ArrayList<T>();
        while (enumeration.hasMoreElements()) {
            list.add(enumeration.nextElement());
        }
        return list;
    }

    
        public static <T> Collection<T> synchronizedCollection(
            Collection<T> collection) {
        if (collection == null) {
            throw new NullPointerException();
        }
        return new SynchronizedCollection<T>(collection);
    }

    
        public static <T> List<T> synchronizedList(List<T> list) {
        if (list == null) {
            throw new NullPointerException();
        }
        if (list instanceof RandomAccess) {
            return new SynchronizedRandomAccessList<T>(list);
        }
        return new SynchronizedList<T>(list);
    }

    
        public static <K, V> Map<K, V> synchronizedMap(Map<K, V> map) {
        if (map == null) {
            throw new NullPointerException();
        }
        return new SynchronizedMap<K, V>(map);
    }

    
        public static <E> Set<E> synchronizedSet(Set<E> set) {
        if (set == null) {
            throw new NullPointerException();
        }
        return new SynchronizedSet<E>(set);
    }

    
        public static <K, V> SortedMap<K, V> synchronizedSortedMap(
            SortedMap<K, V> map) {
        if (map == null) {
            throw new NullPointerException();
        }
        return new SynchronizedSortedMap<K, V>(map);
    }

    
        public static <E> SortedSet<E> synchronizedSortedSet(SortedSet<E> set) {
        if (set == null) {
            throw new NullPointerException();
        }
        return new SynchronizedSortedSet<E>(set);
    }

    
        @SuppressWarnings("unchecked")
    public static <E> Collection<E> unmodifiableCollection(
            Collection<? extends E> collection) {
        if (collection == null) {
            throw new NullPointerException();
        }
        return new UnmodifiableCollection<E>((Collection<E>) collection);
    }

    
        @SuppressWarnings("unchecked")
    public static <E> List<E> unmodifiableList(List<? extends E> list) {
        if (list == null) {
            throw new NullPointerException();
        }
        if (list instanceof RandomAccess) {
            return new UnmodifiableRandomAccessList<E>((List<E>) list);
        }
        return new UnmodifiableList<E>((List<E>) list);
    }

    
        @SuppressWarnings("unchecked")
    public static <K, V> Map<K, V> unmodifiableMap(
            Map<? extends K, ? extends V> map) {
        if (map == null) {
            throw new NullPointerException();
        }
        return new UnmodifiableMap<K, V>((Map<K, V>) map);
    }

    
        @SuppressWarnings("unchecked")
    public static <E> Set<E> unmodifiableSet(Set<? extends E> set) {
        if (set == null) {
            throw new NullPointerException();
        }
        return new UnmodifiableSet<E>((Set<E>) set);
    }

    
        @SuppressWarnings("unchecked")
    public static <K, V> SortedMap<K, V> unmodifiableSortedMap(
            SortedMap<K, ? extends V> map) {
        if (map == null) {
            throw new NullPointerException();
        }
        return new UnmodifiableSortedMap<K, V>((SortedMap<K, V>) map);
    }

    
        public static <E> SortedSet<E> unmodifiableSortedSet(SortedSet<E> set) {
        if (set == null) {
            throw new NullPointerException();
        }
        return new UnmodifiableSortedSet<E>(set);
    }

    
        public static int frequency(Collection<?> c, Object o) {
        if (c == null) {
            throw new NullPointerException();
        }
        if (c.isEmpty()) {
            return 0;
        }
        int result = 0;
        Iterator<?> itr = c.iterator();
        while (itr.hasNext()) {
            Object e = itr.next();
            if (o == null ? e == null : o.equals(e)) {
                result++;
            }
        }
        return result;
    }

    
        @SuppressWarnings("unchecked")
    public static final <T> List<T> emptyList() {
        return EMPTY_LIST;
    }

    
        @SuppressWarnings("unchecked")
    public static final <T> Set<T> emptySet() {
        return EMPTY_SET;
    }

    
        @SuppressWarnings("unchecked")
    public static final <K, V> Map<K, V> emptyMap() {
        return EMPTY_MAP;
    }

    
        @SuppressWarnings("unchecked")
    public static <T> Enumeration<T> emptyEnumeration() {
        return (Enumeration<T>) EMPTY_ENUMERATION;
    }

    
        @SuppressWarnings("unchecked")
    public static <T> Iterator<T> emptyIterator() {
        return (Iterator<T>) EMPTY_ITERATOR;
    }

    
        public static <T> ListIterator<T> emptyListIterator() {
        return Collections.<T>emptyList().listIterator();
    }

    
        public static <E> Collection<E> checkedCollection(Collection<E> c,
            Class<E> type) {
        return new CheckedCollection<E>(c, type);
    }

    
        public static <K, V> Map<K, V> checkedMap(Map<K, V> m, Class<K> keyType,
            Class<V> valueType) {
        return new CheckedMap<K, V>(m, keyType, valueType);
    }

    
        public static <E> List<E> checkedList(List<E> list, Class<E> type) {
        if (list instanceof RandomAccess) {
            return new CheckedRandomAccessList<E>(list, type);
        }
        return new CheckedList<E>(list, type);
    }

    
        public static <E> Set<E> checkedSet(Set<E> s, Class<E> type) {
        return new CheckedSet<E>(s, type);
    }

    
        public static <K, V> SortedMap<K, V> checkedSortedMap(SortedMap<K, V> m,
            Class<K> keyType, Class<V> valueType) {
        return new CheckedSortedMap<K, V>(m, keyType, valueType);
    }

    
        public static <E> SortedSet<E> checkedSortedSet(SortedSet<E> s,
            Class<E> type) {
        return new CheckedSortedSet<E>(s, type);
    }

    
        public static <T> boolean addAll(Collection<? super T> c, T... a) {
        boolean modified = false;
        for (int i = 0; i < a.length; i++) {
            modified |= c.add(a[i]);
        }
        return modified;
    }

    
        public static boolean disjoint(Collection<?> c1, Collection<?> c2) {
        if ((c1 instanceof Set) && !(c2 instanceof Set)
                || (c2.size()) > c1.size()) {
            Collection<?> tmp = c1;
            c1 = c2;
            c2 = tmp;
        }
        Iterator<?> it = c1.iterator();
        while (it.hasNext()) {
            if (c2.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    
        static <E> E checkType(E obj, Class<? extends E> type) {
        if (obj != null && !type.isInstance(obj)) {
            throw new ClassCastException("Attempt to insert element of type " + obj.getClass() +
                    " into collection of type " + type);
        }
        return obj;
    }

    
        public static <E> Set<E> newSetFromMap(Map<E, Boolean> map) {
        if (map.isEmpty()) {
            return new SetFromMap<E>(map);
        }
        throw new IllegalArgumentException();
    }

    
        public static <T> Queue<T> asLifoQueue(Deque<T> deque) {
        return new AsLIFOQueue<T>(deque);
    }

    
    private static final class CopiesList<E> extends AbstractList<E> implements Serializable {
        private int n;
        private E element;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.603 -0400", hash_original_method = "5A122D173062D06824D4571736320F87", hash_generated_method = "03180C008E5921CA633B60F0A62033A8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         CopiesList(int length, E object) {
            dsTaint.addTaint(length);
            dsTaint.addTaint(object.dsTaint);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
            // ---------- Original Method ----------
            //if (length < 0) {
                //throw new IllegalArgumentException();
            //}
            //n = length;
            //element = object;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.603 -0400", hash_original_method = "B07BCF81C9C48C72A08077A0468A8769", hash_generated_method = "406A79468BDC71E403475B4229F68B00")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean contains(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                Object var918C716CCB523821E4DE921B4E432F42_428265731 = (element.equals(object));
            } //End flattened ternary
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return element == null ? object == null : element.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.603 -0400", hash_original_method = "61094B9B9DEC6161E82512577FAF3323", hash_generated_method = "722860B12E5ACFE400F4913703256B48")
        @DSModeled(DSC.SAFE)
        @Override
        public int size() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return n;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.603 -0400", hash_original_method = "857A70B35DA7146CF7ADC484EC4AABC8", hash_generated_method = "BEC9E7B729A18CD60D000AC80CF17DF8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E get(int location) {
            dsTaint.addTaint(location);
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (location >= 0 && location < n) {
                //return element;
            //}
            //throw new IndexOutOfBoundsException();
        }

        
        private static final long serialVersionUID = 2739099268398711800L;
    }


    
    private static final class EmptyList extends AbstractList implements RandomAccess, Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.603 -0400", hash_original_method = "5DF64FCFE7015A3075D19E85F6CD6CC3", hash_generated_method = "5DF64FCFE7015A3075D19E85F6CD6CC3")
                public EmptyList ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.603 -0400", hash_original_method = "38B750FD34BF6CB1144CDF020D3299E6", hash_generated_method = "9642DC198F89D513350849A82D74F4CC")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean contains(Object object) {
            dsTaint.addTaint(object.dsTaint);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.604 -0400", hash_original_method = "F4586E3A64B5D10DEB709A723C85E55E", hash_generated_method = "788D3E30289B1A85B9E3FBB1043436DF")
        @DSModeled(DSC.SAFE)
        @Override
        public int size() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.604 -0400", hash_original_method = "F59F44D1664BC2EE59D5A9B30D144285", hash_generated_method = "41680CE961931248BDE515D408C2D524")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Object get(int location) {
            dsTaint.addTaint(location);
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //throw new IndexOutOfBoundsException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.604 -0400", hash_original_method = "3CB4CAF1EADC3F12C565BD7D2B5F5514", hash_generated_method = "139651FF26F41400ADAF91679037E4F0")
        @DSModeled(DSC.SAFE)
        private Object readResolve() {
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return Collections.EMPTY_LIST;
        }

        
        private static final long serialVersionUID = 8842843931221139166L;
    }


    
    private static final class EmptySet extends AbstractSet implements Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.604 -0400", hash_original_method = "68187429BDD98C923D5E6D696E1975C9", hash_generated_method = "68187429BDD98C923D5E6D696E1975C9")
                public EmptySet ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.604 -0400", hash_original_method = "38B750FD34BF6CB1144CDF020D3299E6", hash_generated_method = "9642DC198F89D513350849A82D74F4CC")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean contains(Object object) {
            dsTaint.addTaint(object.dsTaint);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.604 -0400", hash_original_method = "F4586E3A64B5D10DEB709A723C85E55E", hash_generated_method = "788D3E30289B1A85B9E3FBB1043436DF")
        @DSModeled(DSC.SAFE)
        @Override
        public int size() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.604 -0400", hash_original_method = "FC88A4B2F50E498E162F3F7EEDE885B1", hash_generated_method = "D7DF26FE072A1CC1012DF699890C6557")
        @DSModeled(DSC.SAFE)
        @Override
        public Iterator iterator() {
            return (Iterator)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return EMPTY_ITERATOR;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.604 -0400", hash_original_method = "2ED0845ADEAE5655731C197578B08F82", hash_generated_method = "43C39E34A4F2CA3B049DF398A46EB468")
        @DSModeled(DSC.SAFE)
        private Object readResolve() {
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return Collections.EMPTY_SET;
        }

        
        private static final long serialVersionUID = 1582296315990362920L;
    }


    
    private static final class EmptyMap extends AbstractMap implements Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.605 -0400", hash_original_method = "AF7EC33A28C61FC971CF2D1AAF9E3AF3", hash_generated_method = "AF7EC33A28C61FC971CF2D1AAF9E3AF3")
                public EmptyMap ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.605 -0400", hash_original_method = "2AD0E7E75E88E287D6229481B74BEBCC", hash_generated_method = "DC78164391E1F7FC2F1D7F8E0E3F603E")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean containsKey(Object key) {
            dsTaint.addTaint(key.dsTaint);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.605 -0400", hash_original_method = "9D32B6FFC088649ED5480F6E533A1288", hash_generated_method = "F4D09E2852EB971A15B3ED5FB2524274")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean containsValue(Object value) {
            dsTaint.addTaint(value.dsTaint);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.605 -0400", hash_original_method = "709DD403C63D2F4104FF93FEEB6E3457", hash_generated_method = "9F602CE99470A46295F4F60E9F37A9C2")
        @DSModeled(DSC.SAFE)
        @Override
        public Set entrySet() {
            return (Set)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return EMPTY_SET;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.605 -0400", hash_original_method = "59A1188DDD48CFFB749850DC2DA09C1D", hash_generated_method = "D4CA24F588DCF4D7433AAF0A1F69E7DE")
        @DSModeled(DSC.SAFE)
        @Override
        public Object get(Object key) {
            dsTaint.addTaint(key.dsTaint);
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.605 -0400", hash_original_method = "266B164C16644761E32491964C192EB7", hash_generated_method = "B92638FF981280052DB8C0C46FE2EE7B")
        @DSModeled(DSC.SAFE)
        @Override
        public Set keySet() {
            return (Set)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return EMPTY_SET;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.605 -0400", hash_original_method = "745E6E226DD5F7D4E763DA74DFF70792", hash_generated_method = "1352462B4067DE9072C8B54644C4DB9D")
        @DSModeled(DSC.SAFE)
        @Override
        public Collection values() {
            return (Collection)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return EMPTY_LIST;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.606 -0400", hash_original_method = "59A22E9415A338EB85D7A7DD214359CC", hash_generated_method = "3EF6B8A785CF05AC34AFC8EC7B9062C3")
        @DSModeled(DSC.SAFE)
        private Object readResolve() {
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return Collections.EMPTY_MAP;
        }

        
        private static final long serialVersionUID = 6428348081105594320L;
    }


    
    private static final class ReverseComparator<T> implements Comparator<T>, Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.606 -0400", hash_original_method = "094D24D79F0FB4F6BFBC618A96A8C2F9", hash_generated_method = "094D24D79F0FB4F6BFBC618A96A8C2F9")
                public ReverseComparator ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.606 -0400", hash_original_method = "907488F1D5625FE5C9F59ED8A7B6E697", hash_generated_method = "B44787587FC3EC42D76C96CC1CFF5465")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @SuppressWarnings("unchecked")
        @Override
        public int compare(T o1, T o2) {
            dsTaint.addTaint(o2.dsTaint);
            dsTaint.addTaint(o1.dsTaint);
            Comparable<T> c2;
            c2 = (Comparable<T>) o2;
            int var692167FC6770150DF2B5DF91BFB83EC2_928390725 = (c2.compareTo(o1));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //Comparable<T> c2 = (Comparable<T>) o2;
            //return c2.compareTo(o1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.606 -0400", hash_original_method = "DD371F0FDF8300FDCFBD1E5C395D42BC", hash_generated_method = "A4E964AF01A77513038DCEE7CBEA7411")
        @DSModeled(DSC.SAFE)
        private Object readResolve() throws ObjectStreamException {
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return INSTANCE;
        }

        
        private static final ReverseComparator<Object> INSTANCE = new ReverseComparator<Object>();
        private static final long serialVersionUID = 7207038068494060240L;
    }


    
    private static final class ReverseComparator2<T> implements Comparator<T>, Serializable {
        private Comparator<T> cmp;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.606 -0400", hash_original_method = "1ABA0972F29BDB004C28A1246ABEF788", hash_generated_method = "4C9E128B06D3D86DF31B50005430AE33")
        @DSModeled(DSC.SAFE)
         ReverseComparator2(Comparator<T> comparator) {
            dsTaint.addTaint(comparator.dsTaint);
            // ---------- Original Method ----------
            //this.cmp = comparator;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.606 -0400", hash_original_method = "449D1B24DD0E97F4D53DEB786BD04597", hash_generated_method = "C83F508C1EC2E4A22E611FD10C736DAA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int compare(T o1, T o2) {
            dsTaint.addTaint(o2.dsTaint);
            dsTaint.addTaint(o1.dsTaint);
            int varC3FAEC3684B290716428C4AB73BA307C_1736511068 = (cmp.compare(o2, o1));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return cmp.compare(o2, o1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.606 -0400", hash_original_method = "30689CAB8FBFDCB9289EF03377EE08A0", hash_generated_method = "DE29B09636D285424AC6DCF2B445B250")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object o) {
            dsTaint.addTaint(o.dsTaint);
            boolean varB42AC7AE9468AAA515C4B77EBD2F7BC7_678515325 = (o instanceof ReverseComparator2
                    && ((ReverseComparator2) o).cmp.equals(cmp));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return o instanceof ReverseComparator2
                    //&& ((ReverseComparator2) o).cmp.equals(cmp);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.607 -0400", hash_original_method = "CAA612A5887D060562790EB1CDD1FEFE", hash_generated_method = "167DDAE621E8B7F0F9CEE824F7778E3C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int varFAD4BDCF5F08AFF151A94355744A94BB_1506416493 = (~cmp.hashCode());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return ~cmp.hashCode();
        }

        
        private static final long serialVersionUID = 4374092139857L;
    }


    
    private static final class SingletonSet<E> extends AbstractSet<E> implements Serializable {
        E element;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.607 -0400", hash_original_method = "044BE6981927B9234E2AE8686E07A72F", hash_generated_method = "775771B0F2DAE5BC716D5433FB177282")
        @DSModeled(DSC.SAFE)
         SingletonSet(E object) {
            dsTaint.addTaint(object.dsTaint);
            // ---------- Original Method ----------
            //element = object;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.607 -0400", hash_original_method = "B07BCF81C9C48C72A08077A0468A8769", hash_generated_method = "EDC559008E9C4881DDECB01B34493575")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean contains(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                Object var918C716CCB523821E4DE921B4E432F42_1710173939 = (element.equals(object));
            } //End flattened ternary
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return element == null ? object == null : element.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.607 -0400", hash_original_method = "798A0AE2F2A6352396904AB5C9ED97D5", hash_generated_method = "4404283D353E235E1E8B4DE70A024536")
        @DSModeled(DSC.SAFE)
        @Override
        public int size() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.608 -0400", hash_original_method = "135AC18A6A8AD4548E2E750F2D4C7699", hash_generated_method = "9F16450BFE107452921EF7850F9F3BC7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Iterator<E> iterator() {
            Iterator<E> varE6881755AD0AEF56444A58E605B26A9E_981594012 = (new Iterator<E>() {                boolean hasNext = true;
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.608 -0400", hash_original_method = "1FFE1DD028DACE64CCBE65BDB363D72C", hash_generated_method = "6E5CDB7FF89219DEF4E2BD16DD8CE2FB")
                @DSModeled(DSC.SAFE)
                @Override
                public boolean hasNext() {
                    return dsTaint.getTaintBoolean();
                    // ---------- Original Method ----------
                    //return hasNext;
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.608 -0400", hash_original_method = "163A9F5CD311CAB76B0FCB4B7573EA38", hash_generated_method = "33A52D697F3C92CAD6246B7EFEF61C80")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public E next() {
                    {
                        hasNext = false;
                    } //End block
                    if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                    return (E)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //if (hasNext) {
                        //hasNext = false;
                        //return element;
                    //}
                    //throw new NoSuchElementException();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.608 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "DFF7497E2B871A702DD14228358026F0")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public void remove() {
                    if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
                    // ---------- Original Method ----------
                    //throw new UnsupportedOperationException();
                }
});
            return (Iterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Iterator<E>() {
                //boolean hasNext = true;
                //@Override public boolean hasNext() {
                    //return hasNext;
                //}
                //@Override public E next() {
                    //if (hasNext) {
                        //hasNext = false;
                        //return element;
                    //}
                    //throw new NoSuchElementException();
                //}
                //@Override public void remove() {
                    //throw new UnsupportedOperationException();
                //}
            //};
        }

        
        private static final long serialVersionUID = 3193687207550431679L;
    }


    
    private static final class SingletonList<E> extends AbstractList<E> implements Serializable {
        E element;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.608 -0400", hash_original_method = "F3174A5FA7BA5962D109EAC3245F2C1D", hash_generated_method = "0F68A2E6F652EE5C8C699413F0B3DEC8")
        @DSModeled(DSC.SAFE)
         SingletonList(E object) {
            dsTaint.addTaint(object.dsTaint);
            // ---------- Original Method ----------
            //element = object;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.609 -0400", hash_original_method = "B07BCF81C9C48C72A08077A0468A8769", hash_generated_method = "9F3A2F91F7767D3ADA5AD12B8D6CA828")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean contains(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                Object var918C716CCB523821E4DE921B4E432F42_863798391 = (element.equals(object));
            } //End flattened ternary
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return element == null ? object == null : element.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.609 -0400", hash_original_method = "1C6E7D1EB082158D5E00EA29E883A612", hash_generated_method = "BF95B363B95F98AF88F7F52C3449E811")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E get(int location) {
            dsTaint.addTaint(location);
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (location == 0) {
                //return element;
            //}
            //throw new IndexOutOfBoundsException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.609 -0400", hash_original_method = "798A0AE2F2A6352396904AB5C9ED97D5", hash_generated_method = "4404283D353E235E1E8B4DE70A024536")
        @DSModeled(DSC.SAFE)
        @Override
        public int size() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 1;
        }

        
        private static final long serialVersionUID = 3093736618740652951L;
    }


    
    private static final class SingletonMap<K, V> extends AbstractMap<K, V> implements Serializable {
        K k;
        V v;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.609 -0400", hash_original_method = "85D3D420EE431E7A3C1CBFB71D1CEAE2", hash_generated_method = "950575F588629B31C544B29F4DABF8F5")
        @DSModeled(DSC.SAFE)
         SingletonMap(K key, V value) {
            dsTaint.addTaint(value.dsTaint);
            dsTaint.addTaint(key.dsTaint);
            // ---------- Original Method ----------
            //k = key;
            //v = value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.609 -0400", hash_original_method = "26D5E87A2C62405ADA3B15C5C8B30FEC", hash_generated_method = "F34C0A0D2B93A5A75345A2F365E7F59C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsKey(Object key) {
            dsTaint.addTaint(key.dsTaint);
            {
                Object var0EB569FD4AF21D116A21E287F6027A39_26475253 = (k.equals(key));
            } //End flattened ternary
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return k == null ? key == null : k.equals(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.610 -0400", hash_original_method = "827D42B4F919454EC51CA86D0E534994", hash_generated_method = "A69A3B87AF323A4500D83FB44E71AC5B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsValue(Object value) {
            dsTaint.addTaint(value.dsTaint);
            {
                Object var1F74AE50105434A557EE1F3FD50522E7_1209276285 = (v.equals(value));
            } //End flattened ternary
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return v == null ? value == null : v.equals(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.610 -0400", hash_original_method = "8C587096F5E6029DBB187C58CF22D158", hash_generated_method = "EBFD04434C6B9D61E131B505EFFEEA71")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public V get(Object key) {
            dsTaint.addTaint(key.dsTaint);
            {
                boolean varD8EB9E9C73E773501877E01187F3B5DA_906185330 = (containsKey(key));
            } //End collapsed parenthetic
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (containsKey(key)) {
                //return v;
            //}
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.610 -0400", hash_original_method = "798A0AE2F2A6352396904AB5C9ED97D5", hash_generated_method = "4404283D353E235E1E8B4DE70A024536")
        @DSModeled(DSC.SAFE)
        @Override
        public int size() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.612 -0400", hash_original_method = "AB4A6E093F1AE40B73184C21F1D08E5E", hash_generated_method = "8BD8DDA7714376E33B3DFA67BB481863")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> var5E469BFE4E6883AA9EC86B276F21B6BF_1602181652 = (new AbstractSet<Map.Entry<K, V>>() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.611 -0400", hash_original_method = "2A1C1E3E6C77DBF97F80372F94562608", hash_generated_method = "A7E5A85FA43C0F1A709BEC380BD98374")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public boolean contains(Object object) {
                    dsTaint.addTaint(object.dsTaint);
                    {
                        Map.Entry<?, ?> entry;
                        entry = (Map.Entry<?, ?>) object;
                        boolean varA802623D185CF7D7FE4713ECF8491B1D_816814934 = (containsKey(entry.getKey())
                                && containsValue(entry.getValue()));
                    } //End block
                    return dsTaint.getTaintBoolean();
                    // ---------- Original Method ----------
                    //if (object instanceof Map.Entry) {
                        //Map.Entry<?, ?> entry = (Map.Entry<?, ?>) object;
                        //return containsKey(entry.getKey())
                                //&& containsValue(entry.getValue());
                    //}
                    //return false;
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.611 -0400", hash_original_method = "798A0AE2F2A6352396904AB5C9ED97D5", hash_generated_method = "4404283D353E235E1E8B4DE70A024536")
                @DSModeled(DSC.SAFE)
                @Override
                public int size() {
                    return dsTaint.getTaintInt();
                    // ---------- Original Method ----------
                    //return 1;
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.612 -0400", hash_original_method = "514544EF1052F229FBEAE8C28F5C502A", hash_generated_method = "BA812ACA8000E6A9C4BDDF858237C7C1")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public Iterator<Map.Entry<K, V>> iterator() {
                    Iterator<Map.Entry<K, V>> var9013311ED2FFAEB62C3CB918C30398D0_2005354120 = (new Iterator<Map.Entry<K, V>>() {                        boolean hasNext = true;
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.611 -0400", hash_original_method = "1FFE1DD028DACE64CCBE65BDB363D72C", hash_generated_method = "6E5CDB7FF89219DEF4E2BD16DD8CE2FB")
                        @DSModeled(DSC.SAFE)
                        @Override
                        public boolean hasNext() {
                            return dsTaint.getTaintBoolean();
                            // ---------- Original Method ----------
                            //return hasNext;
                        }
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.612 -0400", hash_original_method = "E80284659713283C8723ACEF8D2E3A9E", hash_generated_method = "7F518E77052BE3961C60CEFB9FD5986D")
                        //DSFIXME:  CODE0002: Requires DSC value to be set
                        @Override
                        public Map.Entry<K, V> next() {
                            {
                                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                            } //End block
                            hasNext = false;
                            Map.Entry<K, V> var58F2AA4600C08BD4EA51D8C641F231D4_808142481 = (new MapEntry<K, V>(k, v) {                                
                                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.612 -0400", hash_original_method = "C8286CC3DDAAC404E3663F831F2B1F6D", hash_generated_method = "06301BB9C4B82B74D402057396A27C98")
                                //DSFIXME:  CODE0002: Requires DSC value to be set
                                @Override
                                public V setValue(V value) {
                                    dsTaint.addTaint(value.dsTaint);
                                    if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
                                    return (V)dsTaint.getTaint();
                                    // ---------- Original Method ----------
                                    //throw new UnsupportedOperationException();
                                }
});
                            return (Map.Entry<K, V>)dsTaint.getTaint();
                            // ---------- Original Method ----------
                            //if (!hasNext) {
                                //throw new NoSuchElementException();
                            //}
                            //hasNext = false;
                            //return new MapEntry<K, V>(k, v) {
                                //@Override public V setValue(V value) {
                                    //throw new UnsupportedOperationException();
                                //}
                            //};
                        }
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.612 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "DFF7497E2B871A702DD14228358026F0")
                        //DSFIXME:  CODE0002: Requires DSC value to be set
                        @Override
                        public void remove() {
                            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
                            // ---------- Original Method ----------
                            //throw new UnsupportedOperationException();
                        }
});
                    return (Iterator<Map.Entry<K, V>>)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    // Original Method Too Long, Refer to Original Implementation
                }
});
            return (Set<Map.Entry<K, V>>)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        private static final long serialVersionUID = -6979724477215052911L;
    }


    
    static class SynchronizedCollection<E> implements Collection<E>, Serializable {
        Collection<E> c;
        Object mutex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.613 -0400", hash_original_method = "30FA7B26D2517E75155300E21A44EE02", hash_generated_method = "5A8355F510BAE19ED256095CB7E3F124")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SynchronizedCollection(Collection<E> collection) {
            dsTaint.addTaint(collection.dsTaint);
            mutex = this;
            // ---------- Original Method ----------
            //c = collection;
            //mutex = this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.613 -0400", hash_original_method = "A2A350BD37040709EC39C6B0536AFBDE", hash_generated_method = "B1FB8615528FD5AE502021E555BD44BE")
        @DSModeled(DSC.SAFE)
         SynchronizedCollection(Collection<E> collection, Object mutex) {
            dsTaint.addTaint(mutex.dsTaint);
            dsTaint.addTaint(collection.dsTaint);
            // ---------- Original Method ----------
            //c = collection;
            //this.mutex = mutex;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.613 -0400", hash_original_method = "FB2AC5CD0A8119C2DE50A53F38732CDD", hash_generated_method = "C55C2BE6FD4FCFE00709AB77085317DA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean add(E object) {
            dsTaint.addTaint(object.dsTaint);
            {
                boolean var2BB0FD33FED1B2B72867ACF06FBFC56B_533399934 = (c.add(object));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.add(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.613 -0400", hash_original_method = "8489E829BC0B88048B305735D46B1D99", hash_generated_method = "81BA967FBDB49CC97CDAD7327379732A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean addAll(Collection<? extends E> collection) {
            dsTaint.addTaint(collection.dsTaint);
            {
                boolean varAB7EBFBCA4F45D51E737154B11C4108B_467059109 = (c.addAll(collection));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.addAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.614 -0400", hash_original_method = "7AE3345D011114FF0F62A8DFD7762BE2", hash_generated_method = "ED4D6B89485DB8E6E90C08ACDF15F82F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void clear() {
            {
                c.clear();
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //c.clear();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.614 -0400", hash_original_method = "1B12503F1112F0CD581293F3A624FEFF", hash_generated_method = "9B68D001AA3C1D71A5F68EA98562E694")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean contains(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                boolean var34971DB84F983FD59B337EBDA19618A7_584263183 = (c.contains(object));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.contains(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.614 -0400", hash_original_method = "F945FF2C907D1AA0923D46DECCCD5EAD", hash_generated_method = "3BCFB141C4FFB2022C1BE0516A5BBC9C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            {
                boolean varDACCFBFB1E0F996A35B7BB8B776BF827_871637254 = (c.containsAll(collection));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.containsAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.614 -0400", hash_original_method = "FC4F88C8FB9F4E3716AD2ABCD3101657", hash_generated_method = "F3EB630C10E8940420E73A2BE0196464")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean isEmpty() {
            {
                boolean var13DC031C5380F0C4DA515946E668AE17_2032353271 = (c.isEmpty());
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.isEmpty();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.614 -0400", hash_original_method = "7F1B5E60A4E4F9F3AFA65965967FBBF0", hash_generated_method = "466111B1AB5C57ABC63D1C12E91AD8B3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Iterator<E> iterator() {
            {
                Iterator<E> var24A0D29F595F4955177CF826CFD2CBB4_248758887 = (c.iterator());
            } //End block
            return (Iterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.iterator();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.615 -0400", hash_original_method = "C85E45E4AF074973339408E1197B653C", hash_generated_method = "E30E0BFDA54EAD43912BD3F60C4DF4D0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean remove(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                boolean var8E355775017A5ED204FCCA7510D23187_1865601299 = (c.remove(object));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.remove(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.615 -0400", hash_original_method = "63829008A74D54A464D81619215951F3", hash_generated_method = "3D8DC0B859D4FEDEB86A12BBA17677F4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean removeAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            {
                boolean var1464AF4DDAD9564C54B239B0335D2517_1397573578 = (c.removeAll(collection));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.removeAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.615 -0400", hash_original_method = "F83427C5B4EF86DB8198B3D2BAE482AC", hash_generated_method = "1B62D2A221722780C63E923AA2730BC5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean retainAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            {
                boolean varF2E46B90912EE4E31AEA6D3F646498E8_485465441 = (c.retainAll(collection));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.retainAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.615 -0400", hash_original_method = "8641BC878FB77D36CE60B1977D7C0FB5", hash_generated_method = "03282DD0FFF3FC0725C5F04AC483D43E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int size() {
            {
                int var0E51EFE72011B352AF314992F697E7C3_1458258452 = (c.size());
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.size();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.616 -0400", hash_original_method = "214BCEC14D5449B585926B657D8D51C2", hash_generated_method = "CCD428F2CFDEDFB072AEDC51E8F18400")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public java.lang.Object[] toArray() {
            {
                java.lang.Object[] var3F2D8DA9C0222705DC9C1F072168E1F8_1690287669 = (c.toArray());
            } //End block
            return (java.lang.Object[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.toArray();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.617 -0400", hash_original_method = "D637F0F4C3C8C312A0597F30C1C6DB59", hash_generated_method = "BBE31223EC1AD2E725016605903B1A01")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            {
                String varDA4751CDF147B4450C76D2AC5CA38320_474936281 = (c.toString());
            } //End block
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.toString();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.618 -0400", hash_original_method = "567EED27866E99DFC1B7F8B43B648D82", hash_generated_method = "487409FE4D7E310046205BCE19009834")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public <T> T[] toArray(T[] array) {
            dsTaint.addTaint(array[0].dsTaint);
            {
                T[] var5D23623B3310566BAD78670724549A14_1002517299 = (c.toArray(array));
            } //End block
            return (T[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.toArray(array);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.619 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "D4677206526438DEB3795A7C2AADA25E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void writeObject(ObjectOutputStream stream) throws IOException {
            dsTaint.addTaint(stream.dsTaint);
            {
                stream.defaultWriteObject();
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //stream.defaultWriteObject();
            //}
        }

        
        private static final long serialVersionUID = 3053995032091335093L;
    }


    
    static class SynchronizedRandomAccessList<E> extends SynchronizedList<E> implements RandomAccess {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.619 -0400", hash_original_method = "B7E7091552AE239FAE56C332916C1F88", hash_generated_method = "4DD3E70A3C9701832529FDE555B8F952")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SynchronizedRandomAccessList(List<E> l) {
            super(l);
            dsTaint.addTaint(l.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.619 -0400", hash_original_method = "333C2DB156927D33EFC68D095A4D91C7", hash_generated_method = "E80ED9C6E50D9B33454D0E5E29EBDDAE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SynchronizedRandomAccessList(List<E> l, Object mutex) {
            super(l, mutex);
            dsTaint.addTaint(mutex.dsTaint);
            dsTaint.addTaint(l.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.620 -0400", hash_original_method = "52EB3707ADD11A2326D60B7B815140D9", hash_generated_method = "02C296BB0C13E92D051765F9A9FB0741")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public List<E> subList(int start, int end) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(end);
            {
                List<E> var79F4B4FC1730C00495472D64C06A5972_988892976 = (new SynchronizedRandomAccessList<E>(list.subList(start, end), mutex));
            } //End block
            return (List<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedRandomAccessList<E>(list.subList(start, end), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.620 -0400", hash_original_method = "3A06B4F1BF7736CF10F2183ECBC34EF4", hash_generated_method = "4EF7ACAFBB67A4C354171CC2A0185800")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private Object writeReplace() {
            Object var2B258E14513ACB548867AC0E5BD5E197_494132452 = (new SynchronizedList<E>(list));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SynchronizedList<E>(list);
        }

        
        private static final long serialVersionUID = 1530674583602358482L;
    }


    
    static class SynchronizedList<E> extends SynchronizedCollection<E> implements List<E> {
        List<E> list;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.620 -0400", hash_original_method = "557BC04FB4751FAF0774C664BC5CCEDB", hash_generated_method = "3247D4327C4C798E46B6EF1386ECFF0D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SynchronizedList(List<E> l) {
            super(l);
            dsTaint.addTaint(l.dsTaint);
            // ---------- Original Method ----------
            //list = l;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.620 -0400", hash_original_method = "6BB690026CB7D337AD2D522FD2C1D564", hash_generated_method = "D8F8DA70B73D6F599C11E2D99E282F44")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SynchronizedList(List<E> l, Object mutex) {
            super(l, mutex);
            dsTaint.addTaint(mutex.dsTaint);
            dsTaint.addTaint(l.dsTaint);
            // ---------- Original Method ----------
            //list = l;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.620 -0400", hash_original_method = "771543DB5FBF857EC43E623C900790C1", hash_generated_method = "ED8146A3CA5B9C7951F456F168041DAE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void add(int location, E object) {
            dsTaint.addTaint(location);
            dsTaint.addTaint(object.dsTaint);
            {
                list.add(location, object);
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //list.add(location, object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.620 -0400", hash_original_method = "2E8B0D036C339DEB52EAEECF82B3FC29", hash_generated_method = "538F3F8B73D54A3A287CD0E7B335420E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean addAll(int location, Collection<? extends E> collection) {
            dsTaint.addTaint(location);
            dsTaint.addTaint(collection.dsTaint);
            {
                boolean var158D83A08C48A45A82B28798671769C1_1653012995 = (list.addAll(location, collection));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.addAll(location, collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.621 -0400", hash_original_method = "3D6B0DEE3E066475015263D28B67E9C7", hash_generated_method = "AACC7289683B4342C05FC957E2CFBABF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                boolean varB8EFBCA5568090BA0F116E782A49968B_2104024307 = (list.equals(object));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.equals(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.621 -0400", hash_original_method = "5B64BB89A58DED71DBA9907C06BC2CBB", hash_generated_method = "7F7D07E8B8323B6F5FE425B3AD1BA64D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E get(int location) {
            dsTaint.addTaint(location);
            {
                E var73B0B58D8D3D7335145E2B8B6AC44D88_754522021 = (list.get(location));
            } //End block
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.get(location);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.621 -0400", hash_original_method = "4F5947DB3C3ABC0CDEDCB631295417DE", hash_generated_method = "DF70C74E9F71A62B6D94B55803123DAE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            {
                int varE89315CE67DD6395C812E01B5B28CC79_1836639311 = (list.hashCode());
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.hashCode();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.621 -0400", hash_original_method = "3D24998665BD619FA01B00E0A34A83F5", hash_generated_method = "49A5CD7FDF782DBEE68EEF88B4E7ED8C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int indexOf(Object object) {
            dsTaint.addTaint(object.dsTaint);
            int size;
            Object[] array;
            {
                size = list.size();
                array = new Object[size];
                list.toArray(array);
            } //End block
            {
                {
                    int i;
                    i = 0;
                    {
                        {
                            boolean varE4EB18CE7254896A48F2456CD1C5820F_1235736823 = (object.equals(array[i]));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    int i;
                    i = 0;
                } //End collapsed parenthetic
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //final int size;
            //final Object[] array;
            //synchronized (mutex) {
                //size = list.size();
                //array = new Object[size];
                //list.toArray(array);
            //}
            //if (object != null) {
                //for (int i = 0; i < size; i++) {
                    //if (object.equals(array[i])) {
                        //return i;
                    //}
                //}
            //} else {
                //for (int i = 0; i < size; i++) {
                    //if (array[i] == null) {
                        //return i;
                    //}
                //}
            //}
            //return -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.622 -0400", hash_original_method = "615F71337583130515178716D1767A86", hash_generated_method = "F03A8F962F8DACD0C619D81E00889A2E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int lastIndexOf(Object object) {
            dsTaint.addTaint(object.dsTaint);
            int size;
            Object[] array;
            {
                size = list.size();
                array = new Object[size];
                list.toArray(array);
            } //End block
            {
                {
                    int i;
                    i = size - 1;
                    {
                        {
                            boolean varE4EB18CE7254896A48F2456CD1C5820F_184142252 = (object.equals(array[i]));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    int i;
                    i = size - 1;
                } //End collapsed parenthetic
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //final int size;
            //final Object[] array;
            //synchronized (mutex) {
                //size = list.size();
                //array = new Object[size];
                //list.toArray(array);
            //}
            //if (object != null) {
                //for (int i = size - 1; i >= 0; i--) {
                    //if (object.equals(array[i])) {
                        //return i;
                    //}
                //}
            //} else {
                //for (int i = size - 1; i >= 0; i--) {
                    //if (array[i] == null) {
                        //return i;
                    //}
                //}
            //}
            //return -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.622 -0400", hash_original_method = "9E49E91DE129681261C3C7642C2D1127", hash_generated_method = "697ACA34231B21D9CA03904F51AC1629")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public ListIterator<E> listIterator() {
            {
                ListIterator<E> var76349BCE7583779F3F3F157CAF26DD4C_1597101771 = (list.listIterator());
            } //End block
            return (ListIterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.listIterator();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.622 -0400", hash_original_method = "70349F3896FC81F4D21A3D35B0C8A4F6", hash_generated_method = "22D6500AD73FDE6C7FE4E93EC4145C78")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public ListIterator<E> listIterator(int location) {
            dsTaint.addTaint(location);
            {
                ListIterator<E> var71730C54CD0BAB9C07323A68A1A20AE4_1710828541 = (list.listIterator(location));
            } //End block
            return (ListIterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.listIterator(location);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.622 -0400", hash_original_method = "D935E09B492D323BEF59297A7648FE48", hash_generated_method = "AEBA3DC35090F356DD98B8702CC11E8E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E remove(int location) {
            dsTaint.addTaint(location);
            {
                E var8A9D2AEA7F5291AA8B5F07EF2501777A_705668202 = (list.remove(location));
            } //End block
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.remove(location);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.622 -0400", hash_original_method = "D9730991663FB8C206D80781B7E02750", hash_generated_method = "51917CAE38D8C0CF45FE184EF53E0393")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E set(int location, E object) {
            dsTaint.addTaint(location);
            dsTaint.addTaint(object.dsTaint);
            {
                E var99FBB8BC1ADB365164A853DDBCC975BF_1907331611 = (list.set(location, object));
            } //End block
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.set(location, object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.623 -0400", hash_original_method = "C38F2D62AA6D1EBD255ADC5369CBEC01", hash_generated_method = "1E4427940E0C19EB674457625CA89131")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public List<E> subList(int start, int end) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(end);
            {
                List<E> var6FDAAEF93DBE6A1FE8237A35A66F1C47_394691625 = (new SynchronizedList<E>(list.subList(start, end), mutex));
            } //End block
            return (List<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedList<E>(list.subList(start, end), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.623 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "D4677206526438DEB3795A7C2AADA25E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void writeObject(ObjectOutputStream stream) throws IOException {
            dsTaint.addTaint(stream.dsTaint);
            {
                stream.defaultWriteObject();
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //stream.defaultWriteObject();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.623 -0400", hash_original_method = "172F08E6F2352F1764A4A70C48C6E243", hash_generated_method = "A0570FE4DDAC428D74B8BC61E30AC05F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private Object readResolve() {
            {
                Object varE1CAF97EFD94FC40F8C491196F223AFE_1655540123 = (new SynchronizedRandomAccessList<E>(list, mutex));
            } //End block
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (list instanceof RandomAccess) {
                //return new SynchronizedRandomAccessList<E>(list, mutex);
            //}
            //return this;
        }

        
        private static final long serialVersionUID = -7754090372962971524L;
    }


    
    static class SynchronizedMap<K, V> implements Map<K, V>, Serializable {
        private Map<K, V> m;
        Object mutex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.623 -0400", hash_original_method = "C14189E3F71A4C148CB91C638F3BAAE3", hash_generated_method = "F060222F2DD15F34C39FD56B11EFFA95")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SynchronizedMap(Map<K, V> map) {
            dsTaint.addTaint(map.dsTaint);
            mutex = this;
            // ---------- Original Method ----------
            //m = map;
            //mutex = this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.623 -0400", hash_original_method = "6EAD9DD813CFD47244744C3F6D6A4D1C", hash_generated_method = "6E332BB2B9ED99EEF8CE970BA326E62A")
        @DSModeled(DSC.SAFE)
         SynchronizedMap(Map<K, V> map, Object mutex) {
            dsTaint.addTaint(mutex.dsTaint);
            dsTaint.addTaint(map.dsTaint);
            // ---------- Original Method ----------
            //m = map;
            //this.mutex = mutex;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.623 -0400", hash_original_method = "3DCF075501F09300584E40825720BBA2", hash_generated_method = "931659E7A8514DEF770EFF02D67516B0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void clear() {
            {
                m.clear();
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //m.clear();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.624 -0400", hash_original_method = "D2C67B34100B05197A0572527ECA3220", hash_generated_method = "2956362EB4F9202622ADDF488D247AA4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsKey(Object key) {
            dsTaint.addTaint(key.dsTaint);
            {
                boolean var5B3943E8DB1DEBF4053A7AC85BD5CB7F_847286415 = (m.containsKey(key));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.containsKey(key);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.624 -0400", hash_original_method = "FFE2162DB44C1E8BEEAD35935B233C81", hash_generated_method = "BDB701AA91C761A407BC3E09E9CBBB66")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsValue(Object value) {
            dsTaint.addTaint(value.dsTaint);
            {
                boolean var9B502A789B5AAD38CD0ED829F2887AEF_136944640 = (m.containsValue(value));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.containsValue(value);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.624 -0400", hash_original_method = "E5EA9A3F9567269DAA52E0C08140D3D5", hash_generated_method = "DAEAC9643E9977BDB9845A31B2450F40")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            {
                Set<Map.Entry<K, V>> varCCB5BAB8CD8236FC7E7EE18A7FE8FDA2_1486508517 = (new SynchronizedSet<Map.Entry<K, V>>(m.entrySet(), mutex));
            } //End block
            return (Set<Map.Entry<K, V>>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSet<Map.Entry<K, V>>(m.entrySet(), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.624 -0400", hash_original_method = "573EFA9740FEBDEC9C1CCFD8172CCEF0", hash_generated_method = "1C3E8FD7BAE34A0AADD56BEED477E6F9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                boolean var3653CC7A1B6721F556FDF4EA3FD61A52_468028061 = (m.equals(object));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.equals(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.625 -0400", hash_original_method = "80DF7D6FED6980DF61457325CD64503D", hash_generated_method = "50A41152ECF3C790B9B70B2D93E6D106")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public V get(Object key) {
            dsTaint.addTaint(key.dsTaint);
            {
                V var474A70B52BFFEC8B20AC6270DFA16E1F_1410904920 = (m.get(key));
            } //End block
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.get(key);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.625 -0400", hash_original_method = "5DDF560D56DA8F61EEAD582BB150A893", hash_generated_method = "157AFBCFA0ED1AED01CE058A47320272")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            {
                int var58938B03D27AEF577E5F8B43D45478A1_1243973554 = (m.hashCode());
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.hashCode();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.625 -0400", hash_original_method = "40A122CDBD7096230690259CC30A0F7A", hash_generated_method = "14936C8B86DA862BC1A769CEC9E79796")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean isEmpty() {
            {
                boolean var20AA7E3C23DC3AFB5FE1B5D3BD0CE158_1982036362 = (m.isEmpty());
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.isEmpty();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.625 -0400", hash_original_method = "2FBB6190D51F2A6210F8CF71191E69DD", hash_generated_method = "22DCA170192EF7D8D84988488DA3A477")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Set<K> keySet() {
            {
                Set<K> var0BD25AF91FBC2C9D7A5D0DBCD935921E_873362315 = (new SynchronizedSet<K>(m.keySet(), mutex));
            } //End block
            return (Set<K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSet<K>(m.keySet(), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.625 -0400", hash_original_method = "4BBBC2EF3E646AB7C0C1BFCAE8571FAF", hash_generated_method = "0EE2D4B09AD1372622CF00A61F946BFC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public V put(K key, V value) {
            dsTaint.addTaint(value.dsTaint);
            dsTaint.addTaint(key.dsTaint);
            {
                V var636674CA8442FF245A35ED4C39B478C0_58152899 = (m.put(key, value));
            } //End block
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.put(key, value);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.625 -0400", hash_original_method = "400FF0E6707670DAA4FF7ECA275302A3", hash_generated_method = "B213B00EFFEB1488F7F087A35FE3A21C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void putAll(Map<? extends K, ? extends V> map) {
            dsTaint.addTaint(map.dsTaint);
            {
                m.putAll(map);
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //m.putAll(map);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.626 -0400", hash_original_method = "98B37460DCD5FD18048F5172283C3141", hash_generated_method = "27419618EAE8411F7253F77F11CFF159")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public V remove(Object key) {
            dsTaint.addTaint(key.dsTaint);
            {
                V var6330C1F751AFF9358410A0C6CDD88E9D_1853414650 = (m.remove(key));
            } //End block
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.remove(key);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.626 -0400", hash_original_method = "A48EE7C65347333E889EFC2ECD0A019A", hash_generated_method = "711537C361E55E0ECC3CCED59ED245D4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int size() {
            {
                int var0BF7698F6735353014CC57B558785727_1701463608 = (m.size());
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.size();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.626 -0400", hash_original_method = "BB797020E54DC33FB15BC9404E89E5CD", hash_generated_method = "A11B25F63A27CC339D2071EC711B4F3C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Collection<V> values() {
            {
                Collection<V> varA250843E6E6DC30A02405715361D4AB0_1215887282 = (new SynchronizedCollection<V>(m.values(), mutex));
            } //End block
            return (Collection<V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedCollection<V>(m.values(), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.626 -0400", hash_original_method = "CB61B465EF18C12F472B81636CD4AC79", hash_generated_method = "1A834802E1D164C80A1F1EC145C016EB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            {
                String var955C11A8135722B04F0E9199D1AEFE75_813119476 = (m.toString());
            } //End block
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.toString();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.626 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "D4677206526438DEB3795A7C2AADA25E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void writeObject(ObjectOutputStream stream) throws IOException {
            dsTaint.addTaint(stream.dsTaint);
            {
                stream.defaultWriteObject();
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //stream.defaultWriteObject();
            //}
        }

        
        private static final long serialVersionUID = 1978198479659022715L;
    }


    
    static class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.626 -0400", hash_original_method = "F3863A567ABAC10F9410ABCF2A4DC8AC", hash_generated_method = "A2AD734765F3BC075B3D320868E11741")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SynchronizedSet(Set<E> set) {
            super(set);
            dsTaint.addTaint(set.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.627 -0400", hash_original_method = "A1BA2E3E145DCA2C522F0AB9439A1572", hash_generated_method = "F337C895D79A743423AB3D2C7AC2920D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SynchronizedSet(Set<E> set, Object mutex) {
            super(set, mutex);
            dsTaint.addTaint(mutex.dsTaint);
            dsTaint.addTaint(set.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.627 -0400", hash_original_method = "E045FF0B832C85F3AF0597463FE3892F", hash_generated_method = "D1FCCFBF2FA6E489B6D4A9D705F8BF83")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                boolean varEA83122D095DC61C01436A4AA2CBB70C_844765163 = (c.equals(object));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.equals(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.627 -0400", hash_original_method = "60CA731F9E7ECB7D3EED20B0D6D4AB09", hash_generated_method = "E5E7D7C29A9DA659B5033952DFBC26C1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            {
                int varDBC342B671922A4943718E25F26D87D0_363333917 = (c.hashCode());
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.hashCode();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.627 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "D4677206526438DEB3795A7C2AADA25E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void writeObject(ObjectOutputStream stream) throws IOException {
            dsTaint.addTaint(stream.dsTaint);
            {
                stream.defaultWriteObject();
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //stream.defaultWriteObject();
            //}
        }

        
        private static final long serialVersionUID = 487447009682186044L;
    }


    
    static class SynchronizedSortedMap<K, V> extends SynchronizedMap<K, V> implements SortedMap<K, V> {
        private SortedMap<K, V> sm;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.627 -0400", hash_original_method = "2E0F62BCD34367F1E6E251286E17ABEB", hash_generated_method = "1F0A9AF96121193005DB80B7CE352216")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SynchronizedSortedMap(SortedMap<K, V> map) {
            super(map);
            dsTaint.addTaint(map.dsTaint);
            // ---------- Original Method ----------
            //sm = map;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.628 -0400", hash_original_method = "5BF33998E3FF0155F7A513C6A201FE85", hash_generated_method = "50D27C8D449B25EC6A4BE9AF7C3CB86A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SynchronizedSortedMap(SortedMap<K, V> map, Object mutex) {
            super(map, mutex);
            dsTaint.addTaint(mutex.dsTaint);
            dsTaint.addTaint(map.dsTaint);
            // ---------- Original Method ----------
            //sm = map;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.628 -0400", hash_original_method = "78218A5A359D1FCDF6B98779037FCB94", hash_generated_method = "123A11BFCD62D8525D9922563D1EE949")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Comparator<? super K> comparator() {
            {
                Comparator<? super K> varC89FBD52D1D81FD4CD4799B6E3332E0D_1921086348 = (sm.comparator());
            } //End block
            return (Comparator<? super K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return sm.comparator();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.628 -0400", hash_original_method = "4A44F83861E496A35113DD67FECD390A", hash_generated_method = "D409100380DB3297233B9370F56401E8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public K firstKey() {
            {
                K var0B1470D61B8C6A68C7AB229BEA61F31E_1060617003 = (sm.firstKey());
            } //End block
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return sm.firstKey();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.628 -0400", hash_original_method = "758EF70CDC2061BD7D7B124D17EF3F64", hash_generated_method = "A5D9E16B547861368CC7C37A2DF4DE35")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedMap<K, V> headMap(K endKey) {
            dsTaint.addTaint(endKey.dsTaint);
            {
                SortedMap<K, V> var7A26954CB6FBB8853F179AAC3A9F4686_213123044 = (new SynchronizedSortedMap<K, V>(sm.headMap(endKey),
                        mutex));
            } //End block
            return (SortedMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedMap<K, V>(sm.headMap(endKey),
                        //mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.628 -0400", hash_original_method = "ECB924A52CC9F341D1EEB7E5D7BCCDC8", hash_generated_method = "23CEB321E3ABEEB3A4F10BF73615D0ED")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public K lastKey() {
            {
                K var7B2CD408EC41D2035EDE4EA469E2194A_1986456220 = (sm.lastKey());
            } //End block
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return sm.lastKey();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.628 -0400", hash_original_method = "E82E6227AA62F00EB1D33B47A72F41C4", hash_generated_method = "AB606073EDE4FE029706F3824030EA31")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedMap<K, V> subMap(K startKey, K endKey) {
            dsTaint.addTaint(endKey.dsTaint);
            dsTaint.addTaint(startKey.dsTaint);
            {
                SortedMap<K, V> var78669850D4141AD418B91306E95EF040_1347657855 = (new SynchronizedSortedMap<K, V>(sm.subMap(startKey,
                        endKey), mutex));
            } //End block
            return (SortedMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedMap<K, V>(sm.subMap(startKey,
                        //endKey), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.629 -0400", hash_original_method = "F7B84D714F16D295C7D43C8AA5E52D6A", hash_generated_method = "B748E25F0B02D512E8E565442B6307BA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedMap<K, V> tailMap(K startKey) {
            dsTaint.addTaint(startKey.dsTaint);
            {
                SortedMap<K, V> varB8FFAC01CC3EFAB07B9BE216D054FA49_1746541362 = (new SynchronizedSortedMap<K, V>(sm.tailMap(startKey),
                        mutex));
            } //End block
            return (SortedMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedMap<K, V>(sm.tailMap(startKey),
                        //mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.629 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "D4677206526438DEB3795A7C2AADA25E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void writeObject(ObjectOutputStream stream) throws IOException {
            dsTaint.addTaint(stream.dsTaint);
            {
                stream.defaultWriteObject();
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //stream.defaultWriteObject();
            //}
        }

        
        private static final long serialVersionUID = -8798146769416483793L;
    }


    
    static class SynchronizedSortedSet<E> extends SynchronizedSet<E> implements SortedSet<E> {
        private SortedSet<E> ss;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.629 -0400", hash_original_method = "B2F0E775DF29B0E6B28447766B0AA532", hash_generated_method = "EED60B4839F637217DC520BB3D34033E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SynchronizedSortedSet(SortedSet<E> set) {
            super(set);
            dsTaint.addTaint(set.dsTaint);
            // ---------- Original Method ----------
            //ss = set;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.629 -0400", hash_original_method = "46957450EFA60C06BEFC5742F9BFAC78", hash_generated_method = "C4E166F96C7EA40BD042B7EE1C4596E9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SynchronizedSortedSet(SortedSet<E> set, Object mutex) {
            super(set, mutex);
            dsTaint.addTaint(mutex.dsTaint);
            dsTaint.addTaint(set.dsTaint);
            // ---------- Original Method ----------
            //ss = set;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.629 -0400", hash_original_method = "D71F7DA0E84FA7A091B4017D559410C5", hash_generated_method = "CEEF4B9A6889D489DC274158870900D9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Comparator<? super E> comparator() {
            {
                Comparator<? super E> var07F86D8CCDDD798A45018D2AA9A359B8_174398066 = (ss.comparator());
            } //End block
            return (Comparator<? super E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return ss.comparator();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.630 -0400", hash_original_method = "C2C55C7E331CFDE8E84B8FC74FDABE02", hash_generated_method = "F17CEDB236E2C1310FB53DD2B4B97966")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E first() {
            {
                E var89000B20893EE4C394CCC342448E11A0_1257131056 = (ss.first());
            } //End block
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return ss.first();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.630 -0400", hash_original_method = "86DA75392AF50D6AE53AEE4A4052EBA8", hash_generated_method = "5828E2442B31512E28FFF2D9617EEAFD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedSet<E> headSet(E end) {
            dsTaint.addTaint(end.dsTaint);
            {
                SortedSet<E> varB346FB35B6D1C44194007A04DD623FE8_932878727 = (new SynchronizedSortedSet<E>(ss.headSet(end), mutex));
            } //End block
            return (SortedSet<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedSet<E>(ss.headSet(end), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.630 -0400", hash_original_method = "3C10DA3BCCE6BED4EBD1F6A2C6BC8438", hash_generated_method = "09602819296F9602F8E8F2D42B6A030D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E last() {
            {
                E varD2F8215971D155E32BF00B454EA993B4_1373339564 = (ss.last());
            } //End block
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return ss.last();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.630 -0400", hash_original_method = "662A59FFAA1C1722D75A374EC93FB0DF", hash_generated_method = "8972FDBD14D055D34BAE70C1EE9B4FDC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedSet<E> subSet(E start, E end) {
            dsTaint.addTaint(start.dsTaint);
            dsTaint.addTaint(end.dsTaint);
            {
                SortedSet<E> var8DA8E4859BA4DEDDCDC044FDF09D00F9_826619457 = (new SynchronizedSortedSet<E>(ss.subSet(start, end),
                        mutex));
            } //End block
            return (SortedSet<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedSet<E>(ss.subSet(start, end),
                        //mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.631 -0400", hash_original_method = "4C04840896A126B8B17AD8E0926A5B00", hash_generated_method = "32D2FC20EC7D9674B7096B8ED638D225")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedSet<E> tailSet(E start) {
            dsTaint.addTaint(start.dsTaint);
            {
                SortedSet<E> varABD07F26D21362C979BC33EB496AF068_1796861017 = (new SynchronizedSortedSet<E>(ss.tailSet(start), mutex));
            } //End block
            return (SortedSet<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedSet<E>(ss.tailSet(start), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.631 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "D4677206526438DEB3795A7C2AADA25E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void writeObject(ObjectOutputStream stream) throws IOException {
            dsTaint.addTaint(stream.dsTaint);
            {
                stream.defaultWriteObject();
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //stream.defaultWriteObject();
            //}
        }

        
        private static final long serialVersionUID = 8695801310862127406L;
    }


    
    private static class UnmodifiableCollection<E> implements Collection<E>, Serializable {
        Collection<E> c;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.631 -0400", hash_original_method = "0B21B3311CB87F81844FA591591A704A", hash_generated_method = "093342DA596565A998FCD68E50F5DB62")
        @DSModeled(DSC.SAFE)
         UnmodifiableCollection(Collection<E> collection) {
            dsTaint.addTaint(collection.dsTaint);
            // ---------- Original Method ----------
            //c = collection;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.631 -0400", hash_original_method = "1E7EFCC2BAD401EE702FAECD906F0B57", hash_generated_method = "30EB4576E62E12ACCEBA94FEE8664973")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean add(E object) {
            dsTaint.addTaint(object.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.631 -0400", hash_original_method = "A14B246F22D65FADC1A66C9C0851763B", hash_generated_method = "F4C80F3469CA6B814579206A1E4F6D47")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean addAll(Collection<? extends E> collection) {
            dsTaint.addTaint(collection.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.632 -0400", hash_original_method = "C5BE2B5F9D582C4EED1DC0880E8741A1", hash_generated_method = "2CA329ADE50B407D285AB2E4B5875FC8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void clear() {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.632 -0400", hash_original_method = "9A5FA57B69BAE7BFE0B020704235C788", hash_generated_method = "189E35057186D44888766BD1958B3428")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean contains(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean var57979CEAB3B2144CFD864D01F9E7B4FE_1614575925 = (c.contains(object));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c.contains(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.632 -0400", hash_original_method = "BD1B4CD05BF6E123B0DC6FD003A6020C", hash_generated_method = "6D59F9FED603F2C084DAF62483D982B1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            boolean varF92105B68CE9F70CF43B3142D405452C_1039015334 = (c.containsAll(collection));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c.containsAll(collection);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.632 -0400", hash_original_method = "F9A3CB1FB7570D28EBE20660E2FC6F42", hash_generated_method = "D21F85EC2DB7AD67942EC1FA290F0546")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean isEmpty() {
            boolean var528EAD02A70F822F393BB0C54FBB923C_328826604 = (c.isEmpty());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.633 -0400", hash_original_method = "57C2B30126E9906DFFF70EEB2D2CD18D", hash_generated_method = "812FEA62BA641BB869DF0F60AF048CFB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Iterator<E> iterator() {
            Iterator<E> var21CE468880C977D4A972F90C2645D980_2009873751 = (new Iterator<E>() {                Iterator<E> iterator = c.iterator();
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.632 -0400", hash_original_method = "AA3B17E619A4DDCE5FFF27C1294FF431", hash_generated_method = "1CD60420925FC839AF1BFEFBDB7860F0")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public boolean hasNext() {
                    boolean varA524DEFD7CC0C913305DE8790C40B8FE_1437589020 = (iterator.hasNext());
                    return dsTaint.getTaintBoolean();
                    // ---------- Original Method ----------
                    //return iterator.hasNext();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.633 -0400", hash_original_method = "E4F6FE4F8164B2EF0F004EE03FA1069C", hash_generated_method = "276F553C2EFB71AE06BE420250A3E568")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public E next() {
                    E var90F72ACFF1A35293EAA82F39737B4C78_1928486238 = (iterator.next());
                    return (E)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //return iterator.next();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.633 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "DFF7497E2B871A702DD14228358026F0")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public void remove() {
                    if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
                    // ---------- Original Method ----------
                    //throw new UnsupportedOperationException();
                }
});
            return (Iterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Iterator<E>() {
                //Iterator<E> iterator = c.iterator();
                //@Override public boolean hasNext() {
                    //return iterator.hasNext();
                //}
                //@Override public E next() {
                    //return iterator.next();
                //}
                //@Override public void remove() {
                    //throw new UnsupportedOperationException();
                //}
            //};
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.633 -0400", hash_original_method = "2165C77F20F5DBDDE4D0AED313262684", hash_generated_method = "B90F7007E6EE47AECC17F68D01FC97EC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean remove(Object object) {
            dsTaint.addTaint(object.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.633 -0400", hash_original_method = "95D6D7B80D3C762A794FEAFDE42B30FC", hash_generated_method = "A8DEE6A5D9FB1C414271FFB1CBE763D5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean removeAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.633 -0400", hash_original_method = "D4789A90B422D35C3FC475A0D6C54BE8", hash_generated_method = "3E239D76F7DD2374C0709505C45AA5C8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean retainAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.634 -0400", hash_original_method = "AC97C28F724592ABA809E2470D95C119", hash_generated_method = "4B8AE429375200F483F0A193E200F855")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int size() {
            int varC247C84593AA6020ED979B19566D13FE_875424370 = (c.size());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return c.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.634 -0400", hash_original_method = "89D7D02A9D2BDF31E775C08108CBDE5B", hash_generated_method = "3EAE4613ABE49D525B28193E133C4971")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Object[] toArray() {
            Object[] var62B66AF92E26C05B85793C43631A5670_1860202172 = (c.toArray());
            return (Object[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return c.toArray();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.634 -0400", hash_original_method = "D5913A45F2385B9A173BEEED47EA354F", hash_generated_method = "E2D653C39BD401E9A640B19727FA620B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public <T> T[] toArray(T[] array) {
            dsTaint.addTaint(array[0].dsTaint);
            T[] var3310A58999EA63E27B96F5B99AFAAFE8_1307201400 = (c.toArray(array));
            return (T[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return c.toArray(array);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.634 -0400", hash_original_method = "424D4966F358AE6553349A6493C21674", hash_generated_method = "676228BF0E0446917D17B9B901751424")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            String var864CC0AEC1F50182F68F1C735FD8AA5D_1628841841 = (c.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return c.toString();
        }

        
        private static final long serialVersionUID = 1820017752578914078L;
    }


    
    private static class UnmodifiableRandomAccessList<E> extends UnmodifiableList<E> implements RandomAccess {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.634 -0400", hash_original_method = "0A20B358F7BA1E60AD6DE80ADB85C324", hash_generated_method = "107B4911B00941DD623F84695AB75ACC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         UnmodifiableRandomAccessList(List<E> l) {
            super(l);
            dsTaint.addTaint(l.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.634 -0400", hash_original_method = "BFD692E8EF2A50E82DD6BA0EC7051578", hash_generated_method = "3DEC5D2C5D81D2113FEF7319F464BCDC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public List<E> subList(int start, int end) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(end);
            List<E> varE81752721CA68FB0892933359A043348_773817613 = (new UnmodifiableRandomAccessList<E>(list.subList(start, end)));
            return (List<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UnmodifiableRandomAccessList<E>(list.subList(start, end));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.634 -0400", hash_original_method = "C39E6F512687738DD8D987CDE63A2838", hash_generated_method = "DC6F511146034B16E7406D84CD289AC4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private Object writeReplace() {
            Object var300BED830E7750381AEC7EFF7E0F8652_1852974509 = (new UnmodifiableList<E>(list));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UnmodifiableList<E>(list);
        }

        
        private static final long serialVersionUID = -2542308836966382001L;
    }


    
    private static class UnmodifiableList<E> extends UnmodifiableCollection<E> implements List<E> {
        List<E> list;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.635 -0400", hash_original_method = "4CB96388E36B825DE711E2E59A893E0D", hash_generated_method = "143DCA1B871E7971419FC06DD8E4A314")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         UnmodifiableList(List<E> l) {
            super(l);
            dsTaint.addTaint(l.dsTaint);
            // ---------- Original Method ----------
            //list = l;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.635 -0400", hash_original_method = "CE54A57EF9628E9FD413F964E9F93054", hash_generated_method = "15FE593A6176FC6754F6A0891B082441")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void add(int location, E object) {
            dsTaint.addTaint(location);
            dsTaint.addTaint(object.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.635 -0400", hash_original_method = "6CD19404B4901DECE5B6F72EB7D0CD8F", hash_generated_method = "31EFDC9F79A4F4BB08034D25E7CBE03A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean addAll(int location, Collection<? extends E> collection) {
            dsTaint.addTaint(location);
            dsTaint.addTaint(collection.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.635 -0400", hash_original_method = "C3C1892342CAEB152D9191558B893ACD", hash_generated_method = "44BF12C162905A1376D98EF3C7C4FDC1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean var983E353D0DFE7FD02AAEFC303F168456_94705481 = (list.equals(object));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return list.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.635 -0400", hash_original_method = "DFB24286AA0C5C6BF58031CA4ED7CDCB", hash_generated_method = "52D7159D875B537195FD3B641A707F4B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E get(int location) {
            dsTaint.addTaint(location);
            E var04271A4486C85B4131CB7C5CE1827D34_898364314 = (list.get(location));
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return list.get(location);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.635 -0400", hash_original_method = "8FDA3E2E38E99F5D6FC34E94E92E953F", hash_generated_method = "7260CD502049B4DAFB96AB8868F877D8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int var9A1610964D862FF54E00A16E6D7BD291_1809313033 = (list.hashCode());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return list.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.636 -0400", hash_original_method = "E8AAF2C874038C363BF8C80F2A4ED8F2", hash_generated_method = "3165B6EAD05DED373E4A9DACF3F45B16")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int indexOf(Object object) {
            dsTaint.addTaint(object.dsTaint);
            int var77BCF240B74578A0DBB7E15170347534_1978126095 = (list.indexOf(object));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return list.indexOf(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.636 -0400", hash_original_method = "658C7926C6DFF1B86F4D9B6B0E3F5BBD", hash_generated_method = "ECBD3DFFF7C772232C517B8049487B82")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int lastIndexOf(Object object) {
            dsTaint.addTaint(object.dsTaint);
            int var158B58B87F16034A803BFB0430AFCD59_668075232 = (list.lastIndexOf(object));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return list.lastIndexOf(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.636 -0400", hash_original_method = "DF7BE0B13ABC5A9B1C74313BD06FB64C", hash_generated_method = "C695C88FC9F4975D6A58A816F57893BE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public ListIterator<E> listIterator() {
            ListIterator<E> var4B5B2DE28169C2BFBA180BAF54B9EB3E_316236237 = (listIterator(0));
            return (ListIterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return listIterator(0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.640 -0400", hash_original_method = "1D0E6831E50FA8995D23240A6E091C82", hash_generated_method = "131B5C4655B1802E3B856851E637A4AF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public ListIterator<E> listIterator(final int location) {
            dsTaint.addTaint(location);
            ListIterator<E> varD275BF41C5F268A2955DBBDA7B464371_913204869 = (new ListIterator<E>() {                ListIterator<E> iterator = list.listIterator(location);
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.636 -0400", hash_original_method = "960DAE05B3D69FE5F79E9628DB5B33E6", hash_generated_method = "17C1F19BE28A7FD98FD08D208051227F")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public void add(E object) {
                    dsTaint.addTaint(object.dsTaint);
                    if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
                    // ---------- Original Method ----------
                    //throw new UnsupportedOperationException();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.637 -0400", hash_original_method = "AA3B17E619A4DDCE5FFF27C1294FF431", hash_generated_method = "C08038A668063B058DE37EA69FD50450")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public boolean hasNext() {
                    boolean varA524DEFD7CC0C913305DE8790C40B8FE_1729341572 = (iterator.hasNext());
                    return dsTaint.getTaintBoolean();
                    // ---------- Original Method ----------
                    //return iterator.hasNext();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.637 -0400", hash_original_method = "6C308ED658D3F7DABB0C5BB5EC622D45", hash_generated_method = "F58F489A73F6524298D320F56712CB84")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public boolean hasPrevious() {
                    boolean var745E6E67FD11BD92635CEE3B0073E1C8_852174316 = (iterator.hasPrevious());
                    return dsTaint.getTaintBoolean();
                    // ---------- Original Method ----------
                    //return iterator.hasPrevious();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.638 -0400", hash_original_method = "E4F6FE4F8164B2EF0F004EE03FA1069C", hash_generated_method = "5000FB065D7A5EA69B437BD7FF527FF4")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public E next() {
                    E var90F72ACFF1A35293EAA82F39737B4C78_574036535 = (iterator.next());
                    return (E)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //return iterator.next();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.638 -0400", hash_original_method = "966AADF518643C3720C5A10EB9E91B73", hash_generated_method = "1183F59DC1D52EFE565AED51443EA46F")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public int nextIndex() {
                    int var75BE2B697D496D7CC2AE6428D4C7B255_265471542 = (iterator.nextIndex());
                    return dsTaint.getTaintInt();
                    // ---------- Original Method ----------
                    //return iterator.nextIndex();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.639 -0400", hash_original_method = "AEA372ED9A2A3ECAEDCF64AE3E3251E3", hash_generated_method = "2D481D9D416420CC2E33634267A5C5D7")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public E previous() {
                    E varCAD4AE4DF271FE76B548A2B974985145_2089545220 = (iterator.previous());
                    return (E)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //return iterator.previous();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.639 -0400", hash_original_method = "4F453E1B19F3569A7CE9D88D231730E4", hash_generated_method = "A99CD7BFC04E0F3FE6619F856CCDB121")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public int previousIndex() {
                    int var14861D7244E14DB7A3CC069FE483ACF6_859361501 = (iterator.previousIndex());
                    return dsTaint.getTaintInt();
                    // ---------- Original Method ----------
                    //return iterator.previousIndex();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.639 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "DFF7497E2B871A702DD14228358026F0")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public void remove() {
                    if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
                    // ---------- Original Method ----------
                    //throw new UnsupportedOperationException();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.639 -0400", hash_original_method = "1001E1C2B2FD09C7DE97126421AC0A91", hash_generated_method = "8C6D96C9C3787B2F611DCF19B12A5567")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public void set(E object) {
                    dsTaint.addTaint(object.dsTaint);
                    if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
                    // ---------- Original Method ----------
                    //throw new UnsupportedOperationException();
                }
});
            return (ListIterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.640 -0400", hash_original_method = "5388D372D048D053ADD084F02A9C1484", hash_generated_method = "361B9D4AD8A18831EE80E8D5EF6C199C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E remove(int location) {
            dsTaint.addTaint(location);
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.640 -0400", hash_original_method = "8830E2F07CC294339D5D496574BCFA5E", hash_generated_method = "A9A7009CA39F58951405B071A1AE0EC4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E set(int location, E object) {
            dsTaint.addTaint(location);
            dsTaint.addTaint(object.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.640 -0400", hash_original_method = "82D78FB8922B9A0888EF8A304898D60D", hash_generated_method = "C99D0DC0FAD5A88ECF6D93F8B3756A56")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public List<E> subList(int start, int end) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(end);
            List<E> var484C55B6D971B995E35583CF642ED457_1813016208 = (new UnmodifiableList<E>(list.subList(start, end)));
            return (List<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UnmodifiableList<E>(list.subList(start, end));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.640 -0400", hash_original_method = "5F3DDA40E6BDC67502A2E43BA75DBB15", hash_generated_method = "E8BED8532F9D3BAB7BCE96BD8A17CED4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private Object readResolve() {
            {
                Object varB94890DCA7A82E7DD16F752DFCEF64A6_1916299273 = (new UnmodifiableRandomAccessList<E>(list));
            } //End block
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (list instanceof RandomAccess) {
                //return new UnmodifiableRandomAccessList<E>(list);
            //}
            //return this;
        }

        
        private static final long serialVersionUID = -283967356065247728L;
    }


    
    private static class UnmodifiableMap<K, V> implements Map<K, V>, Serializable {
        private Map<K, V> m;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.640 -0400", hash_original_method = "74C4A0289A3E9196E4EF75F76384A7D2", hash_generated_method = "1B668BC0C21C655E0A0A7F44AD1BE178")
        @DSModeled(DSC.SAFE)
         UnmodifiableMap(Map<K, V> map) {
            dsTaint.addTaint(map.dsTaint);
            // ---------- Original Method ----------
            //m = map;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.641 -0400", hash_original_method = "C5BE2B5F9D582C4EED1DC0880E8741A1", hash_generated_method = "2CA329ADE50B407D285AB2E4B5875FC8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void clear() {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.641 -0400", hash_original_method = "A6C730848D8A626F99D8229EE744E3C0", hash_generated_method = "EC4EA51FBA67950BED949087023F2268")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsKey(Object key) {
            dsTaint.addTaint(key.dsTaint);
            boolean var2519B7EF565FEC21B6285F5E44AC148E_874041926 = (m.containsKey(key));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return m.containsKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.641 -0400", hash_original_method = "EF8C00CF950E8C186D2F05E1E556F384", hash_generated_method = "5D7A3FE4B4D2209E68D6F518FE91E595")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsValue(Object value) {
            dsTaint.addTaint(value.dsTaint);
            boolean varF8CB74E2C5E0734947B397D82173BDD4_211027691 = (m.containsValue(value));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return m.containsValue(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.641 -0400", hash_original_method = "FB0DE15DA25D3994421C9FBDD1812EDD", hash_generated_method = "F8588391D28BC883DEBE0B5171A44E8D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> varE7CF0764559CBDA696603C1B9F083963_1772124725 = (new UnmodifiableEntrySet<K, V>(m.entrySet()));
            return (Set<Map.Entry<K, V>>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UnmodifiableEntrySet<K, V>(m.entrySet());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.641 -0400", hash_original_method = "CE201E78EAC5D1903F741160CB297EAE", hash_generated_method = "7D78DCA7FCE604869CD46F037AB1E994")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean var9745819ACBF7C47D9CAE10D95AB26047_962723547 = (m.equals(object));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return m.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.641 -0400", hash_original_method = "B8FE254B61C57EC3A6DCE539976DA268", hash_generated_method = "7F7E4274C6CF2BC406845F9FC9E1E2BE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public V get(Object key) {
            dsTaint.addTaint(key.dsTaint);
            V var3CE9B05179DCB2168B5F27445CBC5B28_1407085968 = (m.get(key));
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return m.get(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.642 -0400", hash_original_method = "E3229E3389F030DD50B79734943DB788", hash_generated_method = "A9069AE775457537D2B55F3C7EBC0F8B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int varAA1293165230C9829C1AEACFFF576DFC_2109867593 = (m.hashCode());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return m.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.642 -0400", hash_original_method = "B9E63D3C52241E7E917CB1416ABA36E5", hash_generated_method = "5163DC4B14C88645B4A83E45A5ECDDD6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean isEmpty() {
            boolean var028CF644E61B84328EAB66D556672A81_689478979 = (m.isEmpty());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return m.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.642 -0400", hash_original_method = "2CC049F262DAAA6660AF161E9C8606F6", hash_generated_method = "BE579BD494ED101B5F58E616CA916387")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Set<K> keySet() {
            Set<K> var8D40E1914E5CD510283210347B84C9D0_329671652 = (new UnmodifiableSet<K>(m.keySet()));
            return (Set<K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UnmodifiableSet<K>(m.keySet());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.642 -0400", hash_original_method = "1AE25A34BEB4A8F08F41373ADFFCFE34", hash_generated_method = "FC5E7883587CDD24A8576AFBE23B4361")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public V put(K key, V value) {
            dsTaint.addTaint(value.dsTaint);
            dsTaint.addTaint(key.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.642 -0400", hash_original_method = "1D605566C28BBD06FDC515389557B406", hash_generated_method = "D5AC449E569469F3404817B48FB522F7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void putAll(Map<? extends K, ? extends V> map) {
            dsTaint.addTaint(map.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.642 -0400", hash_original_method = "1F8D4C123F3DDBF68E61E38EDB13F5FB", hash_generated_method = "DF36994AF1AC7C5B7960D6CAF6404F4F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public V remove(Object key) {
            dsTaint.addTaint(key.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.643 -0400", hash_original_method = "A04EE09DEB6F21FAA6A7E10DF6401CD1", hash_generated_method = "F386C74D2FDD4EC32103385FE2F6B025")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int size() {
            int varDBD6E28F15F3D13B8127CF62DD69ACD5_2135814828 = (m.size());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return m.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.643 -0400", hash_original_method = "19DD84E0D2EBBBC2FCDA12D023824450", hash_generated_method = "C99A902CFF6D96DCC7A98B835056133A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Collection<V> values() {
            Collection<V> varDEC91ADE25563BA976B08F7B41617CEC_174484072 = (new UnmodifiableCollection<V>(m.values()));
            return (Collection<V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UnmodifiableCollection<V>(m.values());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.643 -0400", hash_original_method = "5DD44B3CD2826BF39F974F66579CF74F", hash_generated_method = "329D2AB3EC870CDB52BDD0221725EEAB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            String var7BAD0880B86D95365972142C036695CB_1368803255 = (m.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return m.toString();
        }

        
        private static class UnmodifiableEntrySet<K, V> extends UnmodifiableSet<Map.Entry<K, V>> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.643 -0400", hash_original_method = "211DEE98878E4422E2F38E79CDC5F0D4", hash_generated_method = "6DA4523CB8C97DC2D6CAA92886184985")
            //DSFIXME:  CODE0002: Requires DSC value to be set
             UnmodifiableEntrySet(Set<Map.Entry<K, V>> set) {
                super(set);
                dsTaint.addTaint(set.dsTaint);
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.644 -0400", hash_original_method = "53A7F61EDA7A64FBCB28AE61A8906002", hash_generated_method = "8C7BC02C0D2E79F1D516B4241FE74061")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public Iterator<Map.Entry<K, V>> iterator() {
                Iterator<Map.Entry<K, V>> var95BE4329366684927FE70C74F3A3B722_1161422783 = (new Iterator<Map.Entry<K, V>>() {                    Iterator<Map.Entry<K, V>> iterator = c.iterator();
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.643 -0400", hash_original_method = "AA3B17E619A4DDCE5FFF27C1294FF431", hash_generated_method = "66606B506492D58CB4781C02865D2212")
                    //DSFIXME:  CODE0002: Requires DSC value to be set
                    @Override
                    public boolean hasNext() {
                        boolean var084ACAAA0951413540CCF629674B7133_651518057 = (iterator.hasNext());
                        return dsTaint.getTaintBoolean();
                        // ---------- Original Method ----------
                        //return iterator.hasNext();
                    }
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.644 -0400", hash_original_method = "EEF2AC3DD179F17AE4AC144ABD5D488C", hash_generated_method = "68867D427D0A737207EC6CD6AE310402")
                    //DSFIXME:  CODE0002: Requires DSC value to be set
                    @Override
                    public Map.Entry<K, V> next() {
                        Map.Entry<K, V> varABB809385A043EB7A7BD3F5009D7AD52_271934277 = (new UnmodifiableMapEntry<K, V>(iterator.next()));
                        return (Map.Entry<K, V>)dsTaint.getTaint();
                        // ---------- Original Method ----------
                        //return new UnmodifiableMapEntry<K, V>(iterator.next());
                    }
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.644 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "DFF7497E2B871A702DD14228358026F0")
                    //DSFIXME:  CODE0002: Requires DSC value to be set
                    @Override
                    public void remove() {
                        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
                        // ---------- Original Method ----------
                        //throw new UnsupportedOperationException();
                    }
});
                return (Iterator<Map.Entry<K, V>>)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new Iterator<Map.Entry<K, V>>() {
                    //Iterator<Map.Entry<K, V>> iterator = c.iterator();
                    //@Override public boolean hasNext() {
                        //return iterator.hasNext();
                    //}
                    //@Override public Map.Entry<K, V> next() {
                        //return new UnmodifiableMapEntry<K, V>(iterator.next());
                    //}
                    //@Override public void remove() {
                        //throw new UnsupportedOperationException();
                    //}
                //};
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.644 -0400", hash_original_method = "C353E5DD4879B90DAE1A37DDC4A8ED8C", hash_generated_method = "0580E6782B66A229C3EF8081EC67C2B7")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public Object[] toArray() {
                int length;
                length = c.size();
                Object[] result;
                result = new Object[length];
                Iterator<?> it;
                it = iterator();
                {
                    int i;
                    i = length;
                    {
                        result[i] = it.next();
                    } //End block
                } //End collapsed parenthetic
                return (Object[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //int length = c.size();
                //Object[] result = new Object[length];
                //Iterator<?> it = iterator();
                //for (int i = length; --i >= 0;) {
                    //result[i] = it.next();
                //}
                //return result;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.644 -0400", hash_original_method = "CB9686BEA448DC0D7D0077DDEB1917CB", hash_generated_method = "BFE11EFF5F96A3C2B637D1D440264065")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @SuppressWarnings("unchecked")
            @Override
            public <T> T[] toArray(T[] contents) {
                dsTaint.addTaint(contents[0].dsTaint);
                int size, index;
                size = c.size();
                index = 0;
                Iterator<Map.Entry<K, V>> it;
                it = iterator();
                {
                    Class<?> ct;
                    ct = contents.getClass().getComponentType();
                    contents = (T[]) Array.newInstance(ct, size);
                } //End block
                {
                    contents[index++] = (T) it.next();
                } //End block
                {
                    contents[index] = null;
                } //End block
                return (T[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //int size = c.size(), index = 0;
                //Iterator<Map.Entry<K, V>> it = iterator();
                //if (size > contents.length) {
                    //Class<?> ct = contents.getClass().getComponentType();
                    //contents = (T[]) Array.newInstance(ct, size);
                //}
                //while (index < size) {
                    //contents[index++] = (T) it.next();
                //}
                //if (index < contents.length) {
                    //contents[index] = null;
                //}
                //return contents;
            }

            
            private static class UnmodifiableMapEntry<K, V> implements Map.Entry<K, V> {
                Map.Entry<K, V> mapEntry;
                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.645 -0400", hash_original_method = "E37A4627FD27E632126EED134E00D831", hash_generated_method = "7844A86090E3D47F96BD0F369E47C041")
                @DSModeled(DSC.SAFE)
                 UnmodifiableMapEntry(Map.Entry<K, V> entry) {
                    dsTaint.addTaint(entry.dsTaint);
                    // ---------- Original Method ----------
                    //mapEntry = entry;
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.645 -0400", hash_original_method = "90F914E663E54C2DC9846974DAA2EFB8", hash_generated_method = "F0AAF6A3266FE889D386987AD0C4E213")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public boolean equals(Object object) {
                    dsTaint.addTaint(object.dsTaint);
                    boolean var1E6E5EE1426DD4D6EB65B99B916F7467_40688706 = (mapEntry.equals(object));
                    return dsTaint.getTaintBoolean();
                    // ---------- Original Method ----------
                    //return mapEntry.equals(object);
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.645 -0400", hash_original_method = "4DDB57034C15C2636BC5A8AFB2B3C75A", hash_generated_method = "CABABC19FC943C121A52190497477CC0")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public K getKey() {
                    K var25C1A8C49B018B5E1039568C6A58A77E_1863879335 = (mapEntry.getKey());
                    return (K)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //return mapEntry.getKey();
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.645 -0400", hash_original_method = "EA1063FCD9D2F699A9610E0A7FDC81FD", hash_generated_method = "1EB854852FF910557BD9F8EA59F3E0F6")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public V getValue() {
                    V var3A71A2C40C9A5E4B4A7FD2824BA056D3_849260563 = (mapEntry.getValue());
                    return (V)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //return mapEntry.getValue();
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.645 -0400", hash_original_method = "8A31FFFC42BCA6E359386EC1F8534D45", hash_generated_method = "9A0A52DB66895F0062D3B78535F73E2E")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public int hashCode() {
                    int varB4446261767782D97888D65AE62449D4_1861425552 = (mapEntry.hashCode());
                    return dsTaint.getTaintInt();
                    // ---------- Original Method ----------
                    //return mapEntry.hashCode();
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.646 -0400", hash_original_method = "3526712C126765AF36CB8D920CBD3B1B", hash_generated_method = "C357D29F017561737C7A54DB151746C5")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public V setValue(V object) {
                    dsTaint.addTaint(object.dsTaint);
                    if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
                    return (V)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //throw new UnsupportedOperationException();
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.646 -0400", hash_original_method = "514C7E8B8C54DBFDFB3E185BADD6AD0A", hash_generated_method = "FC97A79AFEDDD835160D4FC4E1D90C1E")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public String toString() {
                    String var23D4CB5286AA9BCD0B2722DA3B72340B_2069609852 = (mapEntry.toString());
                    return dsTaint.getTaintString();
                    // ---------- Original Method ----------
                    //return mapEntry.toString();
                }

                
            }


            
            private static final long serialVersionUID = 7854390611657943733L;
        }


        
        private static final long serialVersionUID = -1034234728574286014L;
    }


    
    private static class UnmodifiableSet<E> extends UnmodifiableCollection<E> implements Set<E> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.646 -0400", hash_original_method = "D46A71F25EF02541A08678630568218D", hash_generated_method = "49FCB8E3C6182CBD53A31859F146A4FF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         UnmodifiableSet(Set<E> set) {
            super(set);
            dsTaint.addTaint(set.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.646 -0400", hash_original_method = "BB8664F3F5CB90AA83689CAADCD9EA6B", hash_generated_method = "34A25103EF737FCAE0F344246A2CA729")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean var68E706348FF72E55282D2AEF4301CA4B_2040655263 = (c.equals(object));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.646 -0400", hash_original_method = "E858D80F3EEDE9F2B52CDB7DA7FBF12B", hash_generated_method = "5BD805342C3145B928F0EAC2521101D2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int var19B3D08FE3840D0D3E365DF71EF3E20C_1349352747 = (c.hashCode());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return c.hashCode();
        }

        
        private static final long serialVersionUID = -9215047833775013803L;
    }


    
    private static class UnmodifiableSortedMap<K, V> extends UnmodifiableMap<K, V> implements SortedMap<K, V> {
        private SortedMap<K, V> sm;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.646 -0400", hash_original_method = "AC9FE01B421B1E54651959AD61521CA6", hash_generated_method = "03FD8FDA3A4820D2CD080E379E80B836")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         UnmodifiableSortedMap(SortedMap<K, V> map) {
            super(map);
            dsTaint.addTaint(map.dsTaint);
            // ---------- Original Method ----------
            //sm = map;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.647 -0400", hash_original_method = "E5FDBCC6560BE7E99B2D2F850BD84149", hash_generated_method = "B2B182E8453C60A87875DDF9611D5BD3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Comparator<? super K> comparator() {
            Comparator<? super K> var422223D82196DD3FC2DC6264D5B430C5_1827997627 = (sm.comparator());
            return (Comparator<? super K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return sm.comparator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.647 -0400", hash_original_method = "B25E8C7440C76FBF812FF7AC9CA9D776", hash_generated_method = "9BCECDBA345342185D8BC6AD82A0CFD3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public K firstKey() {
            K var27D52CE4EA4B74D34E8381D333AAE9A4_2135789533 = (sm.firstKey());
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return sm.firstKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.647 -0400", hash_original_method = "EC6243B190269A05D31802D1260652E4", hash_generated_method = "24EDB562F018BF8D25ADB7983EBCE000")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedMap<K, V> headMap(K before) {
            dsTaint.addTaint(before.dsTaint);
            SortedMap<K, V> varCA3E385D4E8CD095E0D16C9130E8F327_1624528767 = (new UnmodifiableSortedMap<K, V>(sm.headMap(before)));
            return (SortedMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UnmodifiableSortedMap<K, V>(sm.headMap(before));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.647 -0400", hash_original_method = "00E9126A84DE8B71214859A17DA6BD2E", hash_generated_method = "07096B48ADDC1221C42B38AE14E12B2D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public K lastKey() {
            K var9F9AE843A8A54EC3D9E8230A61FB8B04_1031655179 = (sm.lastKey());
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return sm.lastKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.647 -0400", hash_original_method = "B6411009D9179ABF4D7755605B648FDC", hash_generated_method = "0D47928709FE5A093188B19E453F6D06")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedMap<K, V> subMap(K start, K end) {
            dsTaint.addTaint(start.dsTaint);
            dsTaint.addTaint(end.dsTaint);
            SortedMap<K, V> var00249249156058E6EE273C54B70BBAB5_1971609615 = (new UnmodifiableSortedMap<K, V>(sm.subMap(start, end)));
            return (SortedMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UnmodifiableSortedMap<K, V>(sm.subMap(start, end));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.647 -0400", hash_original_method = "59BADF6C5EE68C4E1DB5A6A22818328A", hash_generated_method = "692C58D9C6CD145767825942068FE675")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedMap<K, V> tailMap(K after) {
            dsTaint.addTaint(after.dsTaint);
            SortedMap<K, V> varB68C4B7747A55CAD7AAABD39E9B461EE_25237585 = (new UnmodifiableSortedMap<K, V>(sm.tailMap(after)));
            return (SortedMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UnmodifiableSortedMap<K, V>(sm.tailMap(after));
        }

        
        private static final long serialVersionUID = -8806743815996713206L;
    }


    
    private static class UnmodifiableSortedSet<E> extends UnmodifiableSet<E> implements SortedSet<E> {
        private SortedSet<E> ss;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.648 -0400", hash_original_method = "232C45C3B4117EB9042FB58E6C0CE113", hash_generated_method = "2FD66488CE1BAD16BCB7E961695AB528")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         UnmodifiableSortedSet(SortedSet<E> set) {
            super(set);
            dsTaint.addTaint(set.dsTaint);
            // ---------- Original Method ----------
            //ss = set;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.648 -0400", hash_original_method = "8514D9255D678B041F55D03BA11DCA3B", hash_generated_method = "3FAD0C2B8C2E8BF1DB6431C49102A0D0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Comparator<? super E> comparator() {
            Comparator<? super E> var05CAB94F8BD11820A94AC68A790A80A5_1041357035 = (ss.comparator());
            return (Comparator<? super E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ss.comparator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.648 -0400", hash_original_method = "6BB6C51843B41CC0DCB5509A79DBA008", hash_generated_method = "85365D9C929326C3C4E7245D86B5C072")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E first() {
            E varCAE51BE1E9DF20269B81A1FDC8990752_200029356 = (ss.first());
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ss.first();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.648 -0400", hash_original_method = "74C4BE29898589F7D7948BADA3350612", hash_generated_method = "88C2558FE3DC98ECBC8E4928F219C0E3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedSet<E> headSet(E before) {
            dsTaint.addTaint(before.dsTaint);
            SortedSet<E> var9DB1950B5F2749043373128DC25BBF71_734288568 = (new UnmodifiableSortedSet<E>(ss.headSet(before)));
            return (SortedSet<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UnmodifiableSortedSet<E>(ss.headSet(before));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.648 -0400", hash_original_method = "AAC5DDE787ACA85752B94AAB77F6B0F8", hash_generated_method = "DE18F10AC5898F0621A47E40BAEF0F8D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E last() {
            E varB0B3C145EFB1EF3B95D9D987CE98A283_1014904522 = (ss.last());
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ss.last();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.648 -0400", hash_original_method = "54602835FD774439E48CB96CB67F9D83", hash_generated_method = "7618A79A603B4BD9FD75F180E637243F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedSet<E> subSet(E start, E end) {
            dsTaint.addTaint(start.dsTaint);
            dsTaint.addTaint(end.dsTaint);
            SortedSet<E> var46D195260A644EE679FCB282DB396A37_323291883 = (new UnmodifiableSortedSet<E>(ss.subSet(start, end)));
            return (SortedSet<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UnmodifiableSortedSet<E>(ss.subSet(start, end));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.649 -0400", hash_original_method = "37640609DAC9C9170FD6CBE14C8AD6B6", hash_generated_method = "DB6C090C02B501E6757341A25306247D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedSet<E> tailSet(E after) {
            dsTaint.addTaint(after.dsTaint);
            SortedSet<E> varB747B94402EDDE06745C3B373FBEAAA8_40155697 = (new UnmodifiableSortedSet<E>(ss.tailSet(after)));
            return (SortedSet<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UnmodifiableSortedSet<E>(ss.tailSet(after));
        }

        
        private static final long serialVersionUID = -4929149591599911165L;
    }


    
    private static class SetFromMap<E> extends AbstractSet<E> implements Serializable {
        private Map<E, Boolean> m;
        private transient Set<E> backingSet;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.649 -0400", hash_original_method = "6B962D990E5B5543C1AA025E18134CE9", hash_generated_method = "0D95E1F81D6F2819FBA25784CC40AFE3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SetFromMap(final Map<E, Boolean> map) {
            dsTaint.addTaint(map.dsTaint);
            backingSet = map.keySet();
            // ---------- Original Method ----------
            //m = map;
            //backingSet = map.keySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.649 -0400", hash_original_method = "B42E9CA75A778919E90B77D794DBEE82", hash_generated_method = "21A91F430BE7F7D9DADCC90BAEAA87E2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean var1848766D38374CAEDBF00C0007CDCFC1_2040689184 = (backingSet.equals(object));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return backingSet.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.649 -0400", hash_original_method = "684F9CE738B21B1B45F3304124963EF1", hash_generated_method = "796D21DE4B233BE033B147454E890D0B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int var061E95C5D32F56D095B7A80E91EC8A56_2026754213 = (backingSet.hashCode());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return backingSet.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.649 -0400", hash_original_method = "FC84A6CABB16433CF1488E03DF7636C8", hash_generated_method = "C41EAF378A0BF5D1FD8A26C9C1476178")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean add(E object) {
            dsTaint.addTaint(object.dsTaint);
            boolean var8AF8A0D0EB560BBD1728F96A00026012_1167747259 = (m.put(object, Boolean.TRUE) == null);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return m.put(object, Boolean.TRUE) == null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.650 -0400", hash_original_method = "5163CA2ED3AD9C66F2BDAFB902590115", hash_generated_method = "5C1448B76AB003BA7ABB7E55C1011B37")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void clear() {
            m.clear();
            // ---------- Original Method ----------
            //m.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.650 -0400", hash_original_method = "C7069F73CC2FBE59B42FACF6A3731192", hash_generated_method = "96B7159C14509D6CD8172A9C3F8D2C5B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            String var76C2C76F9D113FCE27768A53C48C8DE4_1512666516 = (backingSet.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return backingSet.toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.650 -0400", hash_original_method = "C1FDFEBBA860B6E21729D041F83BDE39", hash_generated_method = "370002C6889AE07CE7B8D69FDB2D468C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean contains(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean varD69ECD74FC2F79EA60C338071C7FC221_1573106921 = (backingSet.contains(object));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return backingSet.contains(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.650 -0400", hash_original_method = "652D3A93342A70291E00DB196A629050", hash_generated_method = "DF8D5039FCDA902D09FD62CD5ACD6555")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            boolean var3951AEBB2FFEF521655479A9D2D52542_1659788773 = (backingSet.containsAll(collection));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return backingSet.containsAll(collection);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.650 -0400", hash_original_method = "B9E63D3C52241E7E917CB1416ABA36E5", hash_generated_method = "EDA54FE77F513B64E339FB723A058574")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean isEmpty() {
            boolean var028CF644E61B84328EAB66D556672A81_533039380 = (m.isEmpty());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return m.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.650 -0400", hash_original_method = "20C696E59013C16BDFED7021A5C3E797", hash_generated_method = "8359B6B8FDC9EEADEF7816221838CCDB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean remove(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean varEA834B1BBE47D90EDF860853CDE90683_2136614305 = (m.remove(object) != null);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return m.remove(object) != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.651 -0400", hash_original_method = "4A27ACEA2C9F194EF4597E8BDECC6BD7", hash_generated_method = "E6B57E12D8ECD9E8F16DACB32E2CBD75")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean retainAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            boolean varF15C5540B964CC478105DE5ACC25B10C_1384297671 = (backingSet.retainAll(collection));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return backingSet.retainAll(collection);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.651 -0400", hash_original_method = "706FD57EC242D189F78C8F40D764E8D0", hash_generated_method = "DEAF35DA08C6DE3A15A16638BD996130")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Object[] toArray() {
            Object[] varAAF6863E3FC284FF60465B89D611A453_1702388401 = (backingSet.toArray());
            return (Object[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return backingSet.toArray();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.651 -0400", hash_original_method = "5B684176C593DE73F99AF08724DF65D4", hash_generated_method = "D522F5A525D2C8BCF42ABC89515B6C7A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public <T> T[] toArray(T[] contents) {
            dsTaint.addTaint(contents[0].dsTaint);
            T[] var70E76BB3C7B4621B066FEAA9F9F6B3A3_1178851080 = (backingSet.toArray(contents));
            return (T[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return backingSet.toArray(contents);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.651 -0400", hash_original_method = "2EC39271104239DED882FB25EFF4BC23", hash_generated_method = "21082FC696FA78047BC7269AF3996265")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Iterator<E> iterator() {
            Iterator<E> var46A5BD0F9A39756579AFB4DF806B1772_1864044639 = (backingSet.iterator());
            return (Iterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return backingSet.iterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.651 -0400", hash_original_method = "A04EE09DEB6F21FAA6A7E10DF6401CD1", hash_generated_method = "C5D635581635B204E760CF171818AD74")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int size() {
            int varDBD6E28F15F3D13B8127CF62DD69ACD5_140568037 = (m.size());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return m.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.652 -0400", hash_original_method = "8082AE1FFA2825B9433C3082C2F87EDC", hash_generated_method = "2CCA3CEFD434665579ED77B9305EA2D3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @SuppressWarnings("unchecked")
        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
            dsTaint.addTaint(stream.dsTaint);
            stream.defaultReadObject();
            backingSet = m.keySet();
            // ---------- Original Method ----------
            //stream.defaultReadObject();
            //backingSet = m.keySet();
        }

        
        private static final long serialVersionUID = 2454657854757543876L;
    }


    
    private static class AsLIFOQueue<E> extends AbstractQueue<E> implements Serializable {
        private Deque<E> q;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.652 -0400", hash_original_method = "C9A3AEFCC3A9FEA0CFED796FADB14DA4", hash_generated_method = "3AB948EEEA31732DD7284B29D0F8C2D1")
        @DSModeled(DSC.SAFE)
         AsLIFOQueue(final Deque<E> deque) {
            dsTaint.addTaint(deque.dsTaint);
            // ---------- Original Method ----------
            //this.q = deque;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.652 -0400", hash_original_method = "D6ABAC5AC9E31C28EFD449012F8C668D", hash_generated_method = "BDFBE681EE852D954A427AFD528961B0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Iterator<E> iterator() {
            Iterator<E> varFBE466EF8E63E9009A03F2C0F0CC80D2_767480377 = (q.iterator());
            return (Iterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return q.iterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.652 -0400", hash_original_method = "4D120CFD44D3EE91A03411EED1F5CA02", hash_generated_method = "D3B41A6ABCF9F70447BBE2388535A789")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int size() {
            int var8E6A4AAEA94D20962C54C20127D7D8DC_1306358377 = (q.size());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return q.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.652 -0400", hash_original_method = "A29AB2808D45581589F8B0269F283532", hash_generated_method = "694266743DC285877D237755E10C1850")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean offer(E o) {
            dsTaint.addTaint(o.dsTaint);
            boolean var131D1A648D23B0B634478E3172B0A3D9_1452721551 = (q.offerFirst(o));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return q.offerFirst(o);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.652 -0400", hash_original_method = "286FFABBC697C1CEE6C49194F85DD481", hash_generated_method = "B003C5B93D551CB47AA8A1C25D540E13")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E peek() {
            E var12F2B0EBA7C02287FFA76F3A50514FE3_1521128918 = (q.peekFirst());
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return q.peekFirst();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.653 -0400", hash_original_method = "93EF986205EA0EFDB6E2F2BDD9DDBDB0", hash_generated_method = "D47FCBC32489339E6728EE572D792B3F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E poll() {
            E var513A54907E44074CF1873F435C9F7841_1324814728 = (q.pollFirst());
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return q.pollFirst();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.653 -0400", hash_original_method = "E16BCF0F708E6336497510D255228AB4", hash_generated_method = "D28B0D48580E023E68013F555E8E83FA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean add(E o) {
            dsTaint.addTaint(o.dsTaint);
            q.push(o);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //q.push(o);
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.653 -0400", hash_original_method = "ECF3C7555AB121202E1C39938D734656", hash_generated_method = "72AFA896F4EE9665FC95334E69A68411")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void clear() {
            q.clear();
            // ---------- Original Method ----------
            //q.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.653 -0400", hash_original_method = "41C0874A8589B77FE1309E3303509F6A", hash_generated_method = "C8D8AEAA5AD988BA9F8E5BC9D515E89B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E element() {
            E varA58C48EE56BDCF291271E8BA8F198C86_1349406685 = (q.getFirst());
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return q.getFirst();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.653 -0400", hash_original_method = "DBCAD9866D0C084DC455BF7C95ABCE77", hash_generated_method = "FB1A32347D61D3AD57B284414D0A8065")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E remove() {
            E var21F03F473F531B5A86EF95513BFC64D5_472135612 = (q.pop());
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return q.pop();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.653 -0400", hash_original_method = "2E730D7ABEE184A9C34DA57DF7A457EE", hash_generated_method = "53940D9E2993D45DACE393A919697C38")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean contains(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean varD460130636362755C09A666172F1A628_955368841 = (q.contains(object));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return q.contains(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.654 -0400", hash_original_method = "3E9E9A2983E74090844621EE9CF6D3D7", hash_generated_method = "E111EA5F373C28EC3697E13A24C25BAF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            boolean varDE8FC932F21B2025BA6D50595BD45CF0_994930859 = (q.containsAll(collection));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return q.containsAll(collection);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.654 -0400", hash_original_method = "3014069A2B40728BACBB472823CCCF21", hash_generated_method = "3C73125D1C000F7E55FD5514724B7C4D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean isEmpty() {
            boolean varFE3524B5D20384639CE6FC4B24FAEE92_1650157574 = (q.isEmpty());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return q.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.654 -0400", hash_original_method = "06C06D3351623BFF7BABDE8B40334F59", hash_generated_method = "DB45784022FC3D9D20DE5A9DBEB6779A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean remove(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean var430DB2157F91E84964C83805E66926D1_1815543240 = (q.remove(object));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return q.remove(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.654 -0400", hash_original_method = "13975D6542267AD488C8D9B27A0905D7", hash_generated_method = "2F610CE96F8C903A886CAACB0626796F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean removeAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            boolean varA36A955574116D3C6092CC37D2496B72_1785773803 = (q.removeAll(collection));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return q.removeAll(collection);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.654 -0400", hash_original_method = "029F8EE40CDE382EFA7F7BF13B8FE731", hash_generated_method = "B24AD9C25023091AE7E5D4C379E89B73")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean retainAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            boolean varF8C783496DD8D05EB5484CABE3DF69DA_1870937980 = (q.retainAll(collection));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return q.retainAll(collection);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.654 -0400", hash_original_method = "81809EBBF1D8298961C4E9B761FEF748", hash_generated_method = "B4417C88565AC026FFAA09F76CEA2518")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Object[] toArray() {
            Object[] varCA196E539CEA76D371684D96AE62C6BE_722097979 = (q.toArray());
            return (Object[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return q.toArray();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.655 -0400", hash_original_method = "3C7918E789D95B2A97E0F45A2E8277E0", hash_generated_method = "ED37994AE187ADB49BAA232D89C0B069")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public <T> T[] toArray(T[] contents) {
            dsTaint.addTaint(contents[0].dsTaint);
            T[] varCD03EDBC00D159F43667C38BC995C07F_1529645698 = (q.toArray(contents));
            return (T[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return q.toArray(contents);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.655 -0400", hash_original_method = "827F98847BB1D6CEA3B0A324A45F92ED", hash_generated_method = "A1D0A0DC28363CE236B6F37F6041F1CE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            String var8F4D867925AFF759292A393714F9299F_2031461598 = (q.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return q.toString();
        }

        
        private static final long serialVersionUID = 1802017725587941708L;
    }


    
    private static class CheckedCollection<E> implements Collection<E>, Serializable {
        Collection<E> c;
        Class<E> type;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.655 -0400", hash_original_method = "4DAA5B7D63536360D367B6279A6FD0F0", hash_generated_method = "E6B216B0298B7ACE3E5137DE6DABC84F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CheckedCollection(Collection<E> c, Class<E> type) {
            dsTaint.addTaint(c.dsTaint);
            dsTaint.addTaint(type.dsTaint);
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            // ---------- Original Method ----------
            //if (c == null || type == null) {
                //throw new NullPointerException();
            //}
            //this.c = c;
            //this.type = type;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.655 -0400", hash_original_method = "AC97C28F724592ABA809E2470D95C119", hash_generated_method = "4794CC3596EBC2BAFDD139A50BC71547")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int size() {
            int varC247C84593AA6020ED979B19566D13FE_1024641787 = (c.size());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return c.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.660 -0400", hash_original_method = "F9A3CB1FB7570D28EBE20660E2FC6F42", hash_generated_method = "7155F442A279B401F8836C8A154AD266")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean isEmpty() {
            boolean var528EAD02A70F822F393BB0C54FBB923C_165965360 = (c.isEmpty());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.660 -0400", hash_original_method = "AA502F510015E56A50E854673F52B13D", hash_generated_method = "DCAFED6157FB9C555A575676D4F8161A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean contains(Object obj) {
            dsTaint.addTaint(obj.dsTaint);
            boolean var9701AC7B8B31DABE176EC8837E090033_523167027 = (c.contains(obj));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c.contains(obj);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.660 -0400", hash_original_method = "A49A579D720F57F247BFFB420B912FC7", hash_generated_method = "79274BE1E8194288393A6D45436D3BA9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Iterator<E> iterator() {
            Iterator<E> i;
            i = c.iterator();
            {
                i = new CheckedListIterator<E>((ListIterator<E>) i, type);
            } //End block
            return (Iterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Iterator<E> i = c.iterator();
            //if (i instanceof ListIterator) {
                //i = new CheckedListIterator<E>((ListIterator<E>) i, type);
            //}
            //return i;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.661 -0400", hash_original_method = "89D7D02A9D2BDF31E775C08108CBDE5B", hash_generated_method = "F0522E7E6778CE0E78B24D110EC12EB8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Object[] toArray() {
            Object[] var62B66AF92E26C05B85793C43631A5670_1570625582 = (c.toArray());
            return (Object[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return c.toArray();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.661 -0400", hash_original_method = "9B8166862C116AE305DE64E80811892F", hash_generated_method = "84CBB7B6B50418160B28BB4771F13D27")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public <T> T[] toArray(T[] arr) {
            dsTaint.addTaint(arr[0].dsTaint);
            T[] var375DD56257BE0288EB32DA2FC3FEC3BC_1137941404 = (c.toArray(arr));
            return (T[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return c.toArray(arr);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.661 -0400", hash_original_method = "233202E3883C87159328A7DF45C5A0DD", hash_generated_method = "C4080D9125DFCA5980F1827A4500DB59")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean add(E obj) {
            dsTaint.addTaint(obj.dsTaint);
            boolean var7C3742253C6BF2735A6EB74A5190709F_155420551 = (c.add(checkType(obj, type)));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c.add(checkType(obj, type));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.661 -0400", hash_original_method = "A7C1CDA142B015DD1AAB47325584260A", hash_generated_method = "78E30419E37B8E0F0A592B6F903382D9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean remove(Object obj) {
            dsTaint.addTaint(obj.dsTaint);
            boolean varA24294D934B215AF55F3D7CE5097D547_435390747 = (c.remove(obj));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c.remove(obj);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.661 -0400", hash_original_method = "8A54483E259CA6D3C8AB1EBE7493D296", hash_generated_method = "366854A6E107E2750FEA8674CFB5DB84")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsAll(Collection<?> c1) {
            dsTaint.addTaint(c1.dsTaint);
            boolean varFFF4D0CC6EA0E1A2D080D41D81BC6C1F_1720955578 = (c.containsAll(c1));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c.containsAll(c1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.664 -0400", hash_original_method = "A2391F235E9474A0C2FADB6F2C5C2AB0", hash_generated_method = "9AE8324541C13296F8569A174DD57001")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @SuppressWarnings("unchecked")
        @Override
        public boolean addAll(Collection<? extends E> c1) {
            dsTaint.addTaint(c1.dsTaint);
            Object[] array;
            array = c1.toArray();
            {
                Object o = array[0];
                {
                    checkType(o, type);
                } //End block
            } //End collapsed parenthetic
            boolean var4F43D86A78906FAA31F77A4D0C40B6E3_1098055932 = (c.addAll((List<E>) Arrays.asList(array)));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //Object[] array = c1.toArray();
            //for (Object o : array) {
                //checkType(o, type);
            //}
            //return c.addAll((List<E>) Arrays.asList(array));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.664 -0400", hash_original_method = "E5A4F3F5A50F475A125F07680365C964", hash_generated_method = "1A0A5B900B918DA72A061AAFB9DA92EB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean removeAll(Collection<?> c1) {
            dsTaint.addTaint(c1.dsTaint);
            boolean var6FAA02017CB91A1460E8557E32B16FBC_439156246 = (c.removeAll(c1));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c.removeAll(c1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.664 -0400", hash_original_method = "2CCBBE73D1665A80965D3FA8CB644A3B", hash_generated_method = "B88B1014419570B03147D93DFB2B36C9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean retainAll(Collection<?> c1) {
            dsTaint.addTaint(c1.dsTaint);
            boolean var1BAABDC5B6ADB4CC0AE277B58A4293BA_1769168579 = (c.retainAll(c1));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c.retainAll(c1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.664 -0400", hash_original_method = "C75B179C04D460F62AB7F39D0D292067", hash_generated_method = "A8F69290363AB2D00FEDD4A5A3BF8CF2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void clear() {
            c.clear();
            // ---------- Original Method ----------
            //c.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.665 -0400", hash_original_method = "424D4966F358AE6553349A6493C21674", hash_generated_method = "C13222866CF17E9B8373BE4E00D06800")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            String var864CC0AEC1F50182F68F1C735FD8AA5D_706486678 = (c.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return c.toString();
        }

        
        private static final long serialVersionUID = 1578914078182001775L;
    }


    
    private static class CheckedListIterator<E> implements ListIterator<E> {
        private ListIterator<E> i;
        private Class<E> type;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.665 -0400", hash_original_method = "0B7AAA10EE83BBF7A614BF8D8C7A7C84", hash_generated_method = "4505F4797B06D924BBB1A81A93D1CEA2")
        @DSModeled(DSC.SAFE)
        public CheckedListIterator(ListIterator<E> i, Class<E> type) {
            dsTaint.addTaint(type.dsTaint);
            dsTaint.addTaint(i.dsTaint);
            // ---------- Original Method ----------
            //this.i = i;
            //this.type = type;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.665 -0400", hash_original_method = "59CA86A80410B66286C92523CF35EC7B", hash_generated_method = "39D97F23E013BF34482DD18344CCDDDE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean hasNext() {
            boolean var1611849CD1EE22EA22E4E7E3327E2E35_140561776 = (i.hasNext());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return i.hasNext();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.665 -0400", hash_original_method = "A2FD0994E634C5BCE4D27AD9176E9A5A", hash_generated_method = "08030C2A8ED3ECBEF783E0425C9A505D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E next() {
            E var95DB63288123763EC54E086A49CC4D64_1020956765 = (i.next());
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return i.next();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.665 -0400", hash_original_method = "048FA6C3E3A28865AD880AF8A3FCAE96", hash_generated_method = "598E37F558FC71BB5A0DA7BBE13EE694")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void remove() {
            i.remove();
            // ---------- Original Method ----------
            //i.remove();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.666 -0400", hash_original_method = "BBFFF3658F03DC70BAED5B88BBE801F9", hash_generated_method = "FB7F78F39EF74ABEFA9D244A62E3C430")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean hasPrevious() {
            boolean var1FCC7ECF60E98FFA6572F3122E374C7E_12740082 = (i.hasPrevious());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return i.hasPrevious();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.666 -0400", hash_original_method = "BC73D9B40C1A828CB3DD11A00CF4E28D", hash_generated_method = "F950539D60A6A6D63727F2C379E129A4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E previous() {
            E var7A95CFED89ADF92C26E73F6AF678D539_1856691916 = (i.previous());
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return i.previous();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.666 -0400", hash_original_method = "E41D02CE1A7D09C2351DC91043CD0C1F", hash_generated_method = "948269A25054C2CD2F964FD1463120A6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int nextIndex() {
            int var97CCB58C3C2141B73F996BC540E6EAF5_1377095915 = (i.nextIndex());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return i.nextIndex();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.666 -0400", hash_original_method = "F0908B37AEEE31348E4E446BDB2DC11E", hash_generated_method = "4042EC10756DD4983D93A8587C268D16")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int previousIndex() {
            int var9F734927211780D2EA84E984ED22702D_1671950071 = (i.previousIndex());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return i.previousIndex();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.666 -0400", hash_original_method = "F06067E5C50A33BA33028ACBB7E94E5C", hash_generated_method = "E99ED5E0B952886D771AC0349110AE66")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void set(E obj) {
            dsTaint.addTaint(obj.dsTaint);
            i.set(checkType(obj, type));
            // ---------- Original Method ----------
            //i.set(checkType(obj, type));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.666 -0400", hash_original_method = "3A7C6206CDBE5C448C8E83D10145E877", hash_generated_method = "7F4EEFF4353A726A49C9F0833FE473B2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void add(E obj) {
            dsTaint.addTaint(obj.dsTaint);
            i.add(checkType(obj, type));
            // ---------- Original Method ----------
            //i.add(checkType(obj, type));
        }

        
    }


    
    private static class CheckedList<E> extends CheckedCollection<E> implements List<E> {
        List<E> l;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.667 -0400", hash_original_method = "50AAAF0EF026911FE0274184FEF9C1C3", hash_generated_method = "044908EB04F484BC4927C56B04044145")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CheckedList(List<E> l, Class<E> type) {
            super(l, type);
            dsTaint.addTaint(l.dsTaint);
            dsTaint.addTaint(type.dsTaint);
            // ---------- Original Method ----------
            //this.l = l;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.669 -0400", hash_original_method = "8A1A291116E92C540879607029C861C6", hash_generated_method = "80A880C7E6BF9076828701917B26D3C3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @SuppressWarnings("unchecked")
        @Override
        public boolean addAll(int index, Collection<? extends E> c1) {
            dsTaint.addTaint(index);
            dsTaint.addTaint(c1.dsTaint);
            Object[] array;
            array = c1.toArray();
            {
                Object o = array[0];
                {
                    checkType(o, type);
                } //End block
            } //End collapsed parenthetic
            boolean var720AF4600E5540369BE417DBAEE92DFA_1003823730 = (l.addAll(index, (List<E>) Arrays.asList(array)));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //Object[] array = c1.toArray();
            //for (Object o : array) {
                //checkType(o, type);
            //}
            //return l.addAll(index, (List<E>) Arrays.asList(array));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.669 -0400", hash_original_method = "12BB9FAB0B921E0E98205977740A217D", hash_generated_method = "9132A036227E9CD4857BBEAF399F81B9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E get(int index) {
            dsTaint.addTaint(index);
            E varCC738BFB8401CF070AE45C766DD49A10_1511120797 = (l.get(index));
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return l.get(index);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.669 -0400", hash_original_method = "B15A1B3ABEAB19644273A7FDAFDFF4C3", hash_generated_method = "242B38A9526FCA40D902B1587047D4FF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E set(int index, E obj) {
            dsTaint.addTaint(index);
            dsTaint.addTaint(obj.dsTaint);
            E var95BC3D95EBED8FE150AF94B939570EB9_1463221615 = (l.set(index, checkType(obj, type)));
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return l.set(index, checkType(obj, type));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.670 -0400", hash_original_method = "97AC3A6F1A8F1F91D88637C439308CAA", hash_generated_method = "CB8BCE6E6DDD58FF07447F0EA29F38FF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void add(int index, E obj) {
            dsTaint.addTaint(index);
            dsTaint.addTaint(obj.dsTaint);
            l.add(index, checkType(obj, type));
            // ---------- Original Method ----------
            //l.add(index, checkType(obj, type));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.670 -0400", hash_original_method = "B7A754E9641B79EF3AC643C6FA162631", hash_generated_method = "59458FCB93889BCBF1EEA52AE692E473")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E remove(int index) {
            dsTaint.addTaint(index);
            E var5334BD966B25011284C4A335B4622CBB_2006001154 = (l.remove(index));
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return l.remove(index);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.670 -0400", hash_original_method = "EB95E25E6439350950712FBE2C177EC4", hash_generated_method = "FE74ADF060EA7966AEBAAF204A3E5451")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int indexOf(Object obj) {
            dsTaint.addTaint(obj.dsTaint);
            int varBB0CC98524B808CD822A2164B51F33B8_1052327406 = (l.indexOf(obj));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return l.indexOf(obj);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.670 -0400", hash_original_method = "4C828EC3A9818E335BF8E9F8513B24F5", hash_generated_method = "CD1BF6491D7EA7F0B2D5BCD5E132E281")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int lastIndexOf(Object obj) {
            dsTaint.addTaint(obj.dsTaint);
            int var68D523AC731688651041C374F25CAB09_1759466579 = (l.lastIndexOf(obj));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return l.lastIndexOf(obj);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.670 -0400", hash_original_method = "9293980ECFF31B033CDADFB0ED26EA69", hash_generated_method = "4C1330400B4B2528A75B6DDEC03E9ED7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public ListIterator<E> listIterator() {
            ListIterator<E> var1765FEA39454541ADEB5AAFF0A06F4EC_783587007 = (new CheckedListIterator<E>(l.listIterator(), type));
            return (ListIterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CheckedListIterator<E>(l.listIterator(), type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.671 -0400", hash_original_method = "31D39D7FEEE82D7A15D00B805CB5EAA4", hash_generated_method = "48152CCE7750D95763365BBA9C8E8C73")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public ListIterator<E> listIterator(int index) {
            dsTaint.addTaint(index);
            ListIterator<E> var1E7F16B9DBBA8C20B0828EBF68F598C7_1593500425 = (new CheckedListIterator<E>(l.listIterator(index), type));
            return (ListIterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CheckedListIterator<E>(l.listIterator(index), type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.671 -0400", hash_original_method = "A5E1EFD4B2650099AC132BF86B97D88F", hash_generated_method = "E60118319CAFD30166CA0133757F5A86")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public List<E> subList(int fromIndex, int toIndex) {
            dsTaint.addTaint(fromIndex);
            dsTaint.addTaint(toIndex);
            List<E> varB73C73BFAA199F4126FC4F7FE7D2FC06_1873933868 = (checkedList(l.subList(fromIndex, toIndex), type));
            return (List<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return checkedList(l.subList(fromIndex, toIndex), type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.671 -0400", hash_original_method = "A14AE2E014BAD465F594EE49A5008ED4", hash_generated_method = "71C13B95DCEB9EE1B75FDEEB6735E1C0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object obj) {
            dsTaint.addTaint(obj.dsTaint);
            boolean var559B3B39BC42D814993568E544C6FE1F_717390685 = (l.equals(obj));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return l.equals(obj);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.671 -0400", hash_original_method = "410D1D1B2E05F678DF3AB7D6BB08AEDB", hash_generated_method = "5475A525E96FC1CA5F1AA3678B7A7663")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int var283F03AD18DE255D000FAC9E62BDE6F0_85455318 = (l.hashCode());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return l.hashCode();
        }

        
        private static final long serialVersionUID = 65247728283967356L;
    }


    
    private static class CheckedRandomAccessList<E> extends CheckedList<E> implements RandomAccess {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.671 -0400", hash_original_method = "77F175BCE2CEB5DECA5010A8855616A0", hash_generated_method = "18064B6AE09D158476ACED01D6925F74")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CheckedRandomAccessList(List<E> l, Class<E> type) {
            super(l, type);
            dsTaint.addTaint(l.dsTaint);
            dsTaint.addTaint(type.dsTaint);
            // ---------- Original Method ----------
        }

        
        private static final long serialVersionUID = 1638200125423088369L;
    }


    
    private static class CheckedSet<E> extends CheckedCollection<E> implements Set<E> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.672 -0400", hash_original_method = "515963C9B1280D5707D3A720329B0AC0", hash_generated_method = "03B76B5D63199DF1531476C01EA92607")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CheckedSet(Set<E> s, Class<E> type) {
            super(s, type);
            dsTaint.addTaint(s.dsTaint);
            dsTaint.addTaint(type.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.672 -0400", hash_original_method = "F33AC6E694EC5A5F3A81FF749707DDFC", hash_generated_method = "D1E2523CD26E43713BBE7AE5BE7E0697")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object obj) {
            dsTaint.addTaint(obj.dsTaint);
            boolean varC91792C7DD4F0C8E92E42617036EED48_1762307237 = (c.equals(obj));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c.equals(obj);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.672 -0400", hash_original_method = "E858D80F3EEDE9F2B52CDB7DA7FBF12B", hash_generated_method = "F38FFF9367B4B588A64181F3CBBD38BD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int var19B3D08FE3840D0D3E365DF71EF3E20C_1500327907 = (c.hashCode());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return c.hashCode();
        }

        
        private static final long serialVersionUID = 4694047833775013803L;
    }


    
    private static class CheckedMap<K, V> implements Map<K, V>, Serializable {
        Map<K, V> m;
        Class<K> keyType;
        Class<V> valueType;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.672 -0400", hash_original_method = "906A4960963B0F972E50BE617CA562B3", hash_generated_method = "B7EB59CA924814D69798B337F8EBD57D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private CheckedMap(Map<K, V> m, Class<K> keyType, Class<V> valueType) {
            dsTaint.addTaint(keyType.dsTaint);
            dsTaint.addTaint(valueType.dsTaint);
            dsTaint.addTaint(m.dsTaint);
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            // ---------- Original Method ----------
            //if (m == null || keyType == null || valueType == null) {
                //throw new NullPointerException();
            //}
            //this.m = m;
            //this.keyType = keyType;
            //this.valueType = valueType;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.673 -0400", hash_original_method = "A04EE09DEB6F21FAA6A7E10DF6401CD1", hash_generated_method = "2234D346A56C9958DAF39C3BF2149E39")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int size() {
            int varDBD6E28F15F3D13B8127CF62DD69ACD5_148591468 = (m.size());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return m.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.673 -0400", hash_original_method = "B9E63D3C52241E7E917CB1416ABA36E5", hash_generated_method = "075FD40185F35A23E0F2A8612D43F38B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean isEmpty() {
            boolean var028CF644E61B84328EAB66D556672A81_397032247 = (m.isEmpty());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return m.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.673 -0400", hash_original_method = "A6C730848D8A626F99D8229EE744E3C0", hash_generated_method = "9EA495F93FDA3A0967D86372659CFE3B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsKey(Object key) {
            dsTaint.addTaint(key.dsTaint);
            boolean var2519B7EF565FEC21B6285F5E44AC148E_1329895185 = (m.containsKey(key));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return m.containsKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.673 -0400", hash_original_method = "EF8C00CF950E8C186D2F05E1E556F384", hash_generated_method = "FF0D93D9E68AED0402A40F73510ADD8A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsValue(Object value) {
            dsTaint.addTaint(value.dsTaint);
            boolean varF8CB74E2C5E0734947B397D82173BDD4_851145926 = (m.containsValue(value));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return m.containsValue(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.673 -0400", hash_original_method = "B8FE254B61C57EC3A6DCE539976DA268", hash_generated_method = "250379A49ECC0B739A80BF90EECE523D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public V get(Object key) {
            dsTaint.addTaint(key.dsTaint);
            V var3CE9B05179DCB2168B5F27445CBC5B28_1185411409 = (m.get(key));
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return m.get(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.673 -0400", hash_original_method = "98010DFF1DD51631676FCAC604C1B694", hash_generated_method = "C3939CDC4C5D490C46D3725C9476064A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public V put(K key, V value) {
            dsTaint.addTaint(value.dsTaint);
            dsTaint.addTaint(key.dsTaint);
            V var3900CFF6F346802A5C37740372A7DDE7_886853393 = (m.put(checkType(key, keyType), checkType(value, valueType)));
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return m.put(checkType(key, keyType), checkType(value, valueType));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.674 -0400", hash_original_method = "7E1C4ABAB7F4D30C9FA02B8AC4206202", hash_generated_method = "C7C91FD4E0364375A3A665D557945112")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public V remove(Object key) {
            dsTaint.addTaint(key.dsTaint);
            V varD8EDAC54418B5A038858C3D8CF4069D9_1649647956 = (m.remove(key));
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return m.remove(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.674 -0400", hash_original_method = "7B09FD67E4091CD76439ADACD213D3A2", hash_generated_method = "73943716BC3953B5A786030BFAF5D8B8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @SuppressWarnings("unchecked")
        @Override
        public void putAll(Map<? extends K, ? extends V> map) {
            dsTaint.addTaint(map.dsTaint);
            int size;
            size = map.size();
            Map.Entry<? extends K, ? extends V>[] entries;
            entries = new Map.Entry[size];
            Iterator<? extends Map.Entry<? extends K, ? extends V>> it;
            it = map
                    .entrySet().iterator();
            {
                int i;
                i = 0;
                {
                    Map.Entry<? extends K, ? extends V> e;
                    e = it.next();
                    checkType(e.getKey(), keyType);
                    checkType(e.getValue(), valueType);
                    entries[i] = e;
                } //End block
            } //End collapsed parenthetic
            {
                int i;
                i = 0;
                {
                    m.put(entries[i].getKey(), entries[i].getValue());
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //int size = map.size();
            //if (size == 0) {
                //return;
            //}
            //Map.Entry<? extends K, ? extends V>[] entries = new Map.Entry[size];
            //Iterator<? extends Map.Entry<? extends K, ? extends V>> it = map
                    //.entrySet().iterator();
            //for (int i = 0; i < size; i++) {
                //Map.Entry<? extends K, ? extends V> e = it.next();
                //checkType(e.getKey(), keyType);
                //checkType(e.getValue(), valueType);
                //entries[i] = e;
            //}
            //for (int i = 0; i < size; i++) {
                //m.put(entries[i].getKey(), entries[i].getValue());
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.674 -0400", hash_original_method = "5163CA2ED3AD9C66F2BDAFB902590115", hash_generated_method = "5C1448B76AB003BA7ABB7E55C1011B37")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void clear() {
            m.clear();
            // ---------- Original Method ----------
            //m.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.674 -0400", hash_original_method = "BC85ABF91A39D98F3F2ED0838950D9FC", hash_generated_method = "290432187A51E1120C0E106E0DCDC91A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Set<K> keySet() {
            Set<K> varA07641C54B940BB8232146D61EC97C56_1540495137 = (m.keySet());
            return (Set<K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return m.keySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.674 -0400", hash_original_method = "F6584059741E2818D171714370ED56BF", hash_generated_method = "F6C235D57B4EDC512D652DE5B60AB5D3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Collection<V> values() {
            Collection<V> var5507ECC94528859BCB27FED1248DB4AA_1739858279 = (m.values());
            return (Collection<V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return m.values();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.675 -0400", hash_original_method = "17C87BFAA3247941C0F3FE3FCE6C8B6B", hash_generated_method = "7C6CFCF83D5C3B6597EE17EF950E0F8A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> varB1671B733F1A4DF3968EE76EA035354B_1081031706 = (new CheckedEntrySet<K, V>(m.entrySet(), valueType));
            return (Set<Map.Entry<K, V>>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CheckedEntrySet<K, V>(m.entrySet(), valueType);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.675 -0400", hash_original_method = "5F45CB6F19E1E41DEEA3711399B994B8", hash_generated_method = "7A492291264899B7E9DA4586A8665457")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object obj) {
            dsTaint.addTaint(obj.dsTaint);
            boolean var6519380B8603327E1D0BBD66320BEF0F_354443977 = (m.equals(obj));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return m.equals(obj);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.675 -0400", hash_original_method = "E3229E3389F030DD50B79734943DB788", hash_generated_method = "72A746945FE1FA013812F3F96FDEFC06")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int varAA1293165230C9829C1AEACFFF576DFC_286258726 = (m.hashCode());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return m.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.675 -0400", hash_original_method = "5DD44B3CD2826BF39F974F66579CF74F", hash_generated_method = "CF7B5D9E9011C39FF547F46D93CE6443")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            String var7BAD0880B86D95365972142C036695CB_1640948563 = (m.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return m.toString();
        }

        
        private static class CheckedEntry<K, V> implements Map.Entry<K, V> {
            Map.Entry<K, V> e;
            Class<V> valueType;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.675 -0400", hash_original_method = "7A5E92C112A4AAE1EEB574291E4B57B6", hash_generated_method = "6AEA2B5869550196194A21DB750245C3")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public CheckedEntry(Map.Entry<K, V> e, Class<V> valueType) {
                dsTaint.addTaint(e.dsTaint);
                dsTaint.addTaint(valueType.dsTaint);
                {
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
                } //End block
                // ---------- Original Method ----------
                //if (e == null) {
                    //throw new NullPointerException();
                //}
                //this.e = e;
                //this.valueType = valueType;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.676 -0400", hash_original_method = "10D87C621F2656D3DA7DCE234A4C3FAC", hash_generated_method = "8DC362436C4724DEE32A5C7F9966AB6B")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public K getKey() {
                K var530002C589E791D5F0D59F21CB98A866_530402741 = (e.getKey());
                return (K)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return e.getKey();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.676 -0400", hash_original_method = "8EF21B2292AA31AAE181B3282F3F0262", hash_generated_method = "08BB4893C685B31BCA9616657E90925F")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public V getValue() {
                V var2794ADBC14ECE7BF0E45D7B88CA3585A_1384085294 = (e.getValue());
                return (V)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return e.getValue();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.676 -0400", hash_original_method = "22C63BC622BE9DF4D2BED624BDB5B6B5", hash_generated_method = "769FAF85E154C53E383D11E4C92FB301")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public V setValue(V obj) {
                dsTaint.addTaint(obj.dsTaint);
                V var58BA915191301B7F59E662768625FEFD_69403205 = (e.setValue(checkType(obj, valueType)));
                return (V)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return e.setValue(checkType(obj, valueType));
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.676 -0400", hash_original_method = "0FE63D6CB37B8BF21266876509A7EAAA", hash_generated_method = "54F42704180E7299D9E1F95170B88632")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean equals(Object obj) {
                dsTaint.addTaint(obj.dsTaint);
                boolean var5F98FA9F6CA964453675BAF27F4B0002_632181838 = (e.equals(obj));
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return e.equals(obj);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.676 -0400", hash_original_method = "02C3AF7FB3CFA22B693B83D22D208AF4", hash_generated_method = "9AA27CA2EF207CCF54952E8F3BD2953C")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public int hashCode() {
                int varB0D5769FD2A442E362DC4438ABD8230C_569865520 = (e.hashCode());
                return dsTaint.getTaintInt();
                // ---------- Original Method ----------
                //return e.hashCode();
            }

            
        }


        
        private static class CheckedEntrySet<K, V> implements Set<Map.Entry<K, V>> {
            Set<Map.Entry<K, V>> s;
            Class<V> valueType;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.677 -0400", hash_original_method = "77FA7326B6BB5621E7FE63699FC58F08", hash_generated_method = "CD333331CC761EDECAB17F9536544D25")
            @DSModeled(DSC.SAFE)
            public CheckedEntrySet(Set<Map.Entry<K, V>> s, Class<V> valueType) {
                dsTaint.addTaint(s.dsTaint);
                dsTaint.addTaint(valueType.dsTaint);
                // ---------- Original Method ----------
                //this.s = s;
                //this.valueType = valueType;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.677 -0400", hash_original_method = "448F3F9279BA75C161BF1A7F97E105A4", hash_generated_method = "43438F244C240ABC17F0374CEAD35E41")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public Iterator<Map.Entry<K, V>> iterator() {
                Iterator<Map.Entry<K, V>> varF3EF6D5EEA7921FC381F8C92707C8A1E_1209105372 = (new CheckedEntryIterator<K, V>(s.iterator(), valueType));
                return (Iterator<Map.Entry<K, V>>)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new CheckedEntryIterator<K, V>(s.iterator(), valueType);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.678 -0400", hash_original_method = "0FB4B292E50A952F877CB518E0A96CF9", hash_generated_method = "B8B82792E6F00DD81A1FF72D4D60881E")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public Object[] toArray() {
                int thisSize;
                thisSize = size();
                Object[] array;
                array = new Object[thisSize];
                Iterator<?> it;
                it = iterator();
                {
                    int i;
                    i = 0;
                    {
                        array[i] = it.next();
                    } //End block
                } //End collapsed parenthetic
                return (Object[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //int thisSize = size();
                //Object[] array = new Object[thisSize];
                //Iterator<?> it = iterator();
                //for (int i = 0; i < thisSize; i++) {
                    //array[i] = it.next();
                //}
                //return array;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.678 -0400", hash_original_method = "C1CA1F6CAFA571422DF3592838D87C35", hash_generated_method = "4AFD07512185E31B2D21B7434E04D600")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @SuppressWarnings("unchecked")
            @Override
            public <T> T[] toArray(T[] array) {
                dsTaint.addTaint(array[0].dsTaint);
                int thisSize;
                thisSize = size();
                {
                    Class<?> ct;
                    ct = array.getClass().getComponentType();
                    array = (T[]) Array.newInstance(ct, thisSize);
                } //End block
                Iterator<?> it;
                it = iterator();
                {
                    int i;
                    i = 0;
                    {
                        array[i] = (T) it.next();
                    } //End block
                } //End collapsed parenthetic
                {
                    array[thisSize] = null;
                } //End block
                return (T[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //int thisSize = size();
                //if (array.length < thisSize) {
                    //Class<?> ct = array.getClass().getComponentType();
                    //array = (T[]) Array.newInstance(ct, thisSize);
                //}
                //Iterator<?> it = iterator();
                //for (int i = 0; i < thisSize; i++) {
                    //array[i] = (T) it.next();
                //}
                //if (thisSize < array.length) {
                    //array[thisSize] = null;
                //}
                //return array;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.679 -0400", hash_original_method = "C32F0C36534158E273107417143214BD", hash_generated_method = "5D076182A42F323B3ABB9E18053F2275")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean retainAll(Collection<?> c) {
                dsTaint.addTaint(c.dsTaint);
                boolean var5CB6111A304F8110F244B25FAFD11216_673139151 = (s.retainAll(c));
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return s.retainAll(c);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.679 -0400", hash_original_method = "B2624C46EA911C8D7CBCD3DB1975A601", hash_generated_method = "46CBBA6ADD50322F1846BE677BD820DF")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean removeAll(Collection<?> c) {
                dsTaint.addTaint(c.dsTaint);
                boolean var9FB36AF651B537108EEB0474A946606A_1061369843 = (s.removeAll(c));
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return s.removeAll(c);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.679 -0400", hash_original_method = "D8F4D306F45D40205BDE17116DDFF9FA", hash_generated_method = "411ABAB2F5273FB43EC2CC6FC51030FB")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean containsAll(Collection<?> c) {
                dsTaint.addTaint(c.dsTaint);
                boolean var13D8B720D63124262C076810AF3BA42D_1295896928 = (s.containsAll(c));
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return s.containsAll(c);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.679 -0400", hash_original_method = "0D1A7F281A8819D32245C163B79E338D", hash_generated_method = "22250C691BF7E34205FDBDC69F057C0C")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean addAll(Collection<? extends Map.Entry<K, V>> c) {
                dsTaint.addTaint(c.dsTaint);
                if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //throw new UnsupportedOperationException();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.680 -0400", hash_original_method = "46F35AD7CAD80E45E374449F130E7D0D", hash_generated_method = "32A0962F1D325A8B4CB3B6D1DAFA25D3")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean remove(Object o) {
                dsTaint.addTaint(o.dsTaint);
                boolean varDCAB2EB8C531AB1E623FFAD695CFD286_1391991658 = (s.remove(o));
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return s.remove(o);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.680 -0400", hash_original_method = "A91421BB58ED7F6569B24AAD1B5804AB", hash_generated_method = "22464E035F2866188C3140AF6F5861AB")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean contains(Object o) {
                dsTaint.addTaint(o.dsTaint);
                boolean var42C44FAC187AFC4735D76D5B7760F520_889827592 = (s.contains(o));
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return s.contains(o);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.680 -0400", hash_original_method = "8704A9C8AC3AA02909B00E4E211C4D3E", hash_generated_method = "C5AF59629AF456CB5661EF5442AFB2A8")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean add(Map.Entry<K, V> o) {
                dsTaint.addTaint(o.dsTaint);
                if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //throw new UnsupportedOperationException();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.680 -0400", hash_original_method = "1DB64DC7E3E98DAB777752CA6247DAE5", hash_generated_method = "5DBA3DD8FC8E301DD3A59915B828D4D8")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean isEmpty() {
                boolean var33F6A8EED6267D5B4CCD3EAC631C616A_390168652 = (s.isEmpty());
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return s.isEmpty();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.680 -0400", hash_original_method = "3294D1F2516BD356F42ED84BE178EFCB", hash_generated_method = "8CAFCFFD1A3B734527CE3A6B8BDDA468")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void clear() {
                s.clear();
                // ---------- Original Method ----------
                //s.clear();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.680 -0400", hash_original_method = "61480F19A13469EF561F92E5A3700C23", hash_generated_method = "70B4752EE277693FF3CD4225CDAF1E7F")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public int size() {
                int var8151828880546AEA1C19BE7C52EE5E09_1317173410 = (s.size());
                return dsTaint.getTaintInt();
                // ---------- Original Method ----------
                //return s.size();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.681 -0400", hash_original_method = "150ADDC982A3B6D8A573E663C38A7C9E", hash_generated_method = "8E8BEE5832CDED6CA71779DBBD6CDDA9")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public int hashCode() {
                int varE2FC7D6C989F81F3F30CE1BE213D1E3F_661986876 = (s.hashCode());
                return dsTaint.getTaintInt();
                // ---------- Original Method ----------
                //return s.hashCode();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.681 -0400", hash_original_method = "2565EBD5FCFC00F10C086CB36B3EEE8C", hash_generated_method = "2D92D99A59965AC92D8AABF0190C5BB3")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean equals(Object object) {
                dsTaint.addTaint(object.dsTaint);
                boolean varB696C6744E5DE06D0B58A4DB8EE26D83_1465649128 = (s.equals(object));
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return s.equals(object);
            }

            
            private static class CheckedEntryIterator<K, V> implements Iterator<Map.Entry<K, V>> {
                Iterator<Map.Entry<K, V>> i;
                Class<V> valueType;
                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.681 -0400", hash_original_method = "3CE5E36A95DFE16D33C2CC4176CB7EE4", hash_generated_method = "78E2CB20D0AF91DDAD0D46E485FC8C23")
                @DSModeled(DSC.SAFE)
                public CheckedEntryIterator(Iterator<Map.Entry<K, V>> i,
                        Class<V> valueType) {
                    dsTaint.addTaint(valueType.dsTaint);
                    dsTaint.addTaint(i.dsTaint);
                    // ---------- Original Method ----------
                    //this.i = i;
                    //this.valueType = valueType;
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.681 -0400", hash_original_method = "59CA86A80410B66286C92523CF35EC7B", hash_generated_method = "6C11935AC91EF8DB793312DB9ACF19D9")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public boolean hasNext() {
                    boolean var048C390D087BEDAABDA4F669A9DA628E_583292145 = (i.hasNext());
                    return dsTaint.getTaintBoolean();
                    // ---------- Original Method ----------
                    //return i.hasNext();
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.681 -0400", hash_original_method = "048FA6C3E3A28865AD880AF8A3FCAE96", hash_generated_method = "598E37F558FC71BB5A0DA7BBE13EE694")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public void remove() {
                    i.remove();
                    // ---------- Original Method ----------
                    //i.remove();
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.682 -0400", hash_original_method = "4D16E0BB01C90351B8312D1A4B7DB5F2", hash_generated_method = "AC5960DB47E8CDEF07926434AC285DA9")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public Map.Entry<K, V> next() {
                    Map.Entry<K, V> var17B5968AC14D1D5FC5BD4F2E126C5421_145294159 = (new CheckedEntry<K, V>(i.next(), valueType));
                    return (Map.Entry<K, V>)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //return new CheckedEntry<K, V>(i.next(), valueType);
                }

                
            }


            
        }


        
        private static final long serialVersionUID = 5742860141034234728L;
    }


    
    private static class CheckedSortedSet<E> extends CheckedSet<E> implements SortedSet<E> {
        private SortedSet<E> ss;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.682 -0400", hash_original_method = "70499BD9B05065D265D741875DD058CA", hash_generated_method = "9AB02C1538866C7902B99FF784744F82")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CheckedSortedSet(SortedSet<E> s, Class<E> type) {
            super(s, type);
            dsTaint.addTaint(s.dsTaint);
            dsTaint.addTaint(type.dsTaint);
            // ---------- Original Method ----------
            //this.ss = s;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.682 -0400", hash_original_method = "8514D9255D678B041F55D03BA11DCA3B", hash_generated_method = "1AF645E7CA2DA0E4E47D125F9E86E3F5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Comparator<? super E> comparator() {
            Comparator<? super E> var05CAB94F8BD11820A94AC68A790A80A5_1512043596 = (ss.comparator());
            return (Comparator<? super E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ss.comparator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.682 -0400", hash_original_method = "82539AB1166DFBB28D0E3DC3D0A43121", hash_generated_method = "B2DF120E12BF9A897D9FA20BAE854EE3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedSet<E> subSet(E fromElement, E toElement) {
            dsTaint.addTaint(fromElement.dsTaint);
            dsTaint.addTaint(toElement.dsTaint);
            SortedSet<E> var5328DA8CB8368089558365859562FB92_558786082 = (new CheckedSortedSet<E>(ss.subSet(fromElement, toElement),
                    type));
            return (SortedSet<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CheckedSortedSet<E>(ss.subSet(fromElement, toElement),
                    //type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.682 -0400", hash_original_method = "68D546866615C37E07B8E968E3813E84", hash_generated_method = "195FFD3F004B472058C01AE8561F0162")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedSet<E> headSet(E toElement) {
            dsTaint.addTaint(toElement.dsTaint);
            SortedSet<E> var12D4E16E805D05744E7269E2733D45D5_2060458627 = (new CheckedSortedSet<E>(ss.headSet(toElement), type));
            return (SortedSet<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CheckedSortedSet<E>(ss.headSet(toElement), type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.682 -0400", hash_original_method = "B0B4B667BF95B9D9A3CD3F7FE8BEFA1B", hash_generated_method = "207EE603866BB6E4CD463CB8BF139A4E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedSet<E> tailSet(E fromElement) {
            dsTaint.addTaint(fromElement.dsTaint);
            SortedSet<E> var38D38D4E1852BE6949045F142A132E53_2048088675 = (new CheckedSortedSet<E>(ss.tailSet(fromElement), type));
            return (SortedSet<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CheckedSortedSet<E>(ss.tailSet(fromElement), type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.683 -0400", hash_original_method = "6BB6C51843B41CC0DCB5509A79DBA008", hash_generated_method = "A58FCF6D69591A17CCBB574FA4F2966C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E first() {
            E varCAE51BE1E9DF20269B81A1FDC8990752_1495253439 = (ss.first());
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ss.first();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.683 -0400", hash_original_method = "AAC5DDE787ACA85752B94AAB77F6B0F8", hash_generated_method = "AB35E626A012CFA6C96B82CFA8419EDC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E last() {
            E varB0B3C145EFB1EF3B95D9D987CE98A283_1594222932 = (ss.last());
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ss.last();
        }

        
        private static final long serialVersionUID = 1599911165492914959L;
    }


    
    private static class CheckedSortedMap<K, V> extends CheckedMap<K, V> implements SortedMap<K, V> {
        SortedMap<K, V> sm;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.683 -0400", hash_original_method = "2CB6EA0E6447E5AAF8B28B5FDF140BE4", hash_generated_method = "810C10DF4E552388A49E0485FC940BA7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         CheckedSortedMap(SortedMap<K, V> m, Class<K> keyType, Class<V> valueType) {
            super(m, keyType, valueType);
            dsTaint.addTaint(keyType.dsTaint);
            dsTaint.addTaint(valueType.dsTaint);
            dsTaint.addTaint(m.dsTaint);
            // ---------- Original Method ----------
            //this.sm = m;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.683 -0400", hash_original_method = "E5FDBCC6560BE7E99B2D2F850BD84149", hash_generated_method = "B51D9241D73B9A98BBA6CB2E95863328")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Comparator<? super K> comparator() {
            Comparator<? super K> var422223D82196DD3FC2DC6264D5B430C5_1051941318 = (sm.comparator());
            return (Comparator<? super K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return sm.comparator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.683 -0400", hash_original_method = "65DE11E398BB209CD2689071C041161A", hash_generated_method = "3BD109AE031F02F5531B505E03615488")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedMap<K, V> subMap(K fromKey, K toKey) {
            dsTaint.addTaint(toKey.dsTaint);
            dsTaint.addTaint(fromKey.dsTaint);
            SortedMap<K, V> var190C4EB84C21094B4E80D985CB6ACA7F_687061756 = (new CheckedSortedMap<K, V>(sm.subMap(fromKey, toKey), keyType, valueType));
            return (SortedMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CheckedSortedMap<K, V>(sm.subMap(fromKey, toKey), keyType, valueType);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.683 -0400", hash_original_method = "2C5724B582D2FAB5716323DB894A671D", hash_generated_method = "84F30D331049001E42DA3C7E00995203")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedMap<K, V> headMap(K toKey) {
            dsTaint.addTaint(toKey.dsTaint);
            SortedMap<K, V> var2BE0E60A1B317A0935CA3D78B86A50A4_1108707347 = (new CheckedSortedMap<K, V>(sm.headMap(toKey), keyType, valueType));
            return (SortedMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CheckedSortedMap<K, V>(sm.headMap(toKey), keyType, valueType);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.684 -0400", hash_original_method = "2879524DD09B17D2FCB7AD1626D24618", hash_generated_method = "18BB7094EDF5A3F70D6F4BE23F58625F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedMap<K, V> tailMap(K fromKey) {
            dsTaint.addTaint(fromKey.dsTaint);
            SortedMap<K, V> varE2D105EA819834A2EAC8202B8964FD2E_1976603030 = (new CheckedSortedMap<K, V>(sm.tailMap(fromKey), keyType, valueType));
            return (SortedMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CheckedSortedMap<K, V>(sm.tailMap(fromKey), keyType, valueType);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.684 -0400", hash_original_method = "B25E8C7440C76FBF812FF7AC9CA9D776", hash_generated_method = "7DBDD2228761FA342D0C295E9EA90F49")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public K firstKey() {
            K var27D52CE4EA4B74D34E8381D333AAE9A4_723446121 = (sm.firstKey());
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return sm.firstKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.684 -0400", hash_original_method = "00E9126A84DE8B71214859A17DA6BD2E", hash_generated_method = "B948FE47A4A4AD2647F973173EC914F3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public K lastKey() {
            K var9F9AE843A8A54EC3D9E8230A61FB8B04_13964132 = (sm.lastKey());
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return sm.lastKey();
        }

        
        private static final long serialVersionUID = 1599671320688067438L;
    }


    
    private static final Iterator<?> EMPTY_ITERATOR = new Iterator<Object>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.684 -0400", hash_original_method = "28E75D14A5D2234D3702D9638A8D3094", hash_generated_method = "989BDE69069DBEC7740F810A7550C67B")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean hasNext() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.684 -0400", hash_original_method = "243C3D15209D9BF28572CB29FC9F3DF7", hash_generated_method = "77930BA60151F2B1432EE9072FCE50D0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Object next() {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //throw new NoSuchElementException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.684 -0400", hash_original_method = "45CE80048748F3BC523226127E4746F5", hash_generated_method = "FC031BE6A6E094CAC267938D912798A0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void remove() {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            // ---------- Original Method ----------
            //throw new IllegalStateException();
        }

        
}; //Transformed anonymous class
    private static final Enumeration<?> EMPTY_ENUMERATION = new Enumeration<Object>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.685 -0400", hash_original_method = "50CD0E92886EDA5BEE0164B092B351EC", hash_generated_method = "98981E95ECE22318C61CF2D0C39CABA1")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean hasMoreElements() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.685 -0400", hash_original_method = "82381D9C34AF9F2E88B673FB4A4E6DDE", hash_generated_method = "5C13BF817CDC9470E9B8C8D70AF02BEB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Object nextElement() {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //throw new NoSuchElementException();
        }

        
}; //Transformed anonymous class
    @SuppressWarnings("unchecked") public static final List EMPTY_LIST = new EmptyList();
    @SuppressWarnings("unchecked") public static final Set EMPTY_SET = new EmptySet();
    @SuppressWarnings("unchecked") public static final Map EMPTY_MAP = new EmptyMap();
}

