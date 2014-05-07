package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Array;

public class Collections {
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
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
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public static <T> Enumeration<T> enumeration(Collection<T> collection) {
        final Collection<T> c = collection;
        return new Enumeration<T>() {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.648 -0500", hash_original_field = "05C6C05F795654C532862156D373B302", hash_generated_field = "05C6C05F795654C532862156D373B302")

            Iterator<T> it = c.iterator();

            @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.651 -0500", hash_original_method = "4980969DA277364900E7318D38FDE590", hash_generated_method = "D29F81F7E6BEA5E599029144BF99998A")
            
@Override public boolean hasMoreElements() {
                return it.hasNext();
            }

            @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.654 -0500", hash_original_method = "C445C780E0050ADB56BC6AD40ED0BABB", hash_generated_method = "6F110AA01F6ADC090EF33EC78C597AB8")
            
@Override public T nextElement() {
                return it.next();
            }
        };
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public static <T> void fill(List<? super T> list, T object) {
        ListIterator<? super T> it = list.listIterator();
        while (it.hasNext()) {
            it.next();
            it.set(object);
        }
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
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
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
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
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
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
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
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

    /**
     * Modifies the specified {@code List} by reversing the order of the
     * elements.
     *
     * @param list
     *            the list to reverse.
     * @throws UnsupportedOperationException
     *             when replacing an element in the List is not supported.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.673 -0500", hash_original_method = "EB5699B10E68EAD14DB0C0B8758D3718", hash_generated_method = "31349AC10D0052A7E2BC814BABCA0E6F")
    
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
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @SuppressWarnings("unchecked")
    public static <T> Comparator<T> reverseOrder() {
        return (Comparator) ReverseComparator.INSTANCE;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public static <T> Comparator<T> reverseOrder(Comparator<T> c) {
        if (c == null) {
            return reverseOrder();
        }
        if (c instanceof ReverseComparator2) {
            return ((ReverseComparator2<T>) c).cmp;
        }
        return new ReverseComparator2<T>(c);
    }

    /**
     * Moves every element of the list to a random new position in the list.
     *
     * @param list
     *            the List to shuffle.
     *
     * @throws UnsupportedOperationException
     *             when replacing an element in the List is not supported.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.680 -0500", hash_original_method = "E5AF799D5D5F28A5FEBFEE44EB734D28", hash_generated_method = "10BF5CB2E01C600AD89E7CF99F3834F5")
    
public static void shuffle(List<?> list) {
        shuffle(list, new Random());
    }

    /**
     * Moves every element of the list to a random new position in the list
     * using the specified random number generator.
     *
     * @param list
     *            the list to shuffle.
     * @param random
     *            the random number generator.
     * @throws UnsupportedOperationException
     *             when replacing an element in the list is not supported.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.683 -0500", hash_original_method = "610901F49ED75C22083B75E1795D8046", hash_generated_method = "41B172D6B8FA1C771110E3FCBAEF085C")
    
public static void shuffle(List<?> list, Random random) {
        @SuppressWarnings("unchecked") // we won't put foreign objects in
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
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public static <E> Set<E> singleton(E object) {
        return new SingletonSet<E>(object);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public static <E> List<E> singletonList(E object) {
        return new SingletonList<E>(object);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public static <K, V> Map<K, V> singletonMap(K key, V value) {
        return new SingletonMap<K, V>(key, value);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
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
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
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

    /**
     * Swaps the elements of list {@code list} at indices {@code index1} and
     * {@code index2}.
     *
     * @param list
     *            the list to manipulate.
     * @param index1
     *            position of the first element to swap with the element in
     *            index2.
     * @param index2
     *            position of the other element.
     *
     * @throws IndexOutOfBoundsException
     *             if index1 or index2 is out of range of this list.
     * @since 1.4
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.698 -0500", hash_original_method = "7B4D18FE971E4DCC6A75CEB3B4EFC148", hash_generated_method = "A7F77A42132916904B9DB826B455D271")
    
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
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public static <T> boolean replaceAll(List<T> list, T obj, T obj2) {
        int index;
        boolean found = false;
        while ((index = list.indexOf(obj)) > -1) {
            found = true;
            list.set(index, obj2);
        }
        return found;
    }

    /**
     * Rotates the elements in {@code list} by the distance {@code dist}
     * <p>
     * e.g. for a given list with elements [1, 2, 3, 4, 5, 6, 7, 8, 9, 0],
     * calling rotate(list, 3) or rotate(list, -7) would modify the list to look
     * like this: [8, 9, 0, 1, 2, 3, 4, 5, 6, 7]
     *
     * @param lst
     *            the list whose elements are to be rotated.
     * @param dist
     *            is the distance the list is rotated. This can be any valid
     *            integer. Negative values rotate the list backwards.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.704 -0500", hash_original_method = "1281B43B461BF8F3597637C43DDB8B05", hash_generated_method = "600D86E3EFCCD73564882062018889C9")
    
@SuppressWarnings("unchecked")
    public static void rotate(List<?> lst, int dist) {
        List<Object> list = (List<Object>) lst;
        int size = list.size();

        // Can't sensibly rotate an empty collection
        if (size == 0) {
            return;
        }

        // normalize the distance
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
            // make sure each element gets juggled
            // with the element in the position it is supposed to go to
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

    /**
     * Searches the {@code list} for {@code sublist} and returns the beginning
     * index of the first occurrence.
     * <p>
     * -1 is returned if the {@code sublist} does not exist in {@code list}.
     *
     * @param list
     *            the List to search {@code sublist} in.
     * @param sublist
     *            the List to search in {@code list}.
     * @return the beginning index of the first occurrence of {@code sublist} in
     *         {@code list}, or -1.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.708 -0500", hash_original_method = "E1D1CE40A9DE659C11F6DF1EE0DED402", hash_generated_method = "15663378779EAB83241D70193F837419")
    
public static int indexOfSubList(List<?> list, List<?> sublist) {
        int size = list.size();
        int sublistSize = sublist.size();

        if (sublistSize > size) {
            return -1;
        }

        if (sublistSize == 0) {
            return 0;
        }

        // find the first element of sublist in the list to get a head start
        Object firstObj = sublist.get(0);
        int index = list.indexOf(firstObj);
        if (index == -1) {
            return -1;
        }

        while (index < size && (size - index >= sublistSize)) {
            ListIterator<?> listIt = list.listIterator(index);

            if ((firstObj == null) ? listIt.next() == null : firstObj
                    .equals(listIt.next())) {

                // iterate through the elements in sublist to see
                // if they are included in the same order in the list
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
                // All elements of sublist are found in main list
                // starting from index.
                if (!difFound) {
                    return index;
                }
            }
            // This was not the sequence we were looking for,
            // continue search for the firstObj in main list
            // at the position after index.
            index++;
        }
        return -1;
    }

    /**
     * Searches the {@code list} for {@code sublist} and returns the beginning
     * index of the last occurrence.
     * <p>
     * -1 is returned if the {@code sublist} does not exist in {@code list}.
     *
     * @param list
     *            the list to search {@code sublist} in.
     * @param sublist
     *            the list to search in {@code list}.
     * @return the beginning index of the last occurrence of {@code sublist} in
     *         {@code list}, or -1.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.711 -0500", hash_original_method = "682653A6340BAC71175A462BC9E110F0", hash_generated_method = "5B62CE3CFCE239449F21EC318A27F63F")
    
public static int lastIndexOfSubList(List<?> list, List<?> sublist) {
        int sublistSize = sublist.size();
        int size = list.size();

        if (sublistSize > size) {
            return -1;
        }

        if (sublistSize == 0) {
            return size;
        }

        // find the last element of sublist in the list to get a head start
        Object lastObj = sublist.get(sublistSize - 1);
        int index = list.lastIndexOf(lastObj);

        while ((index > -1) && (index + 1 >= sublistSize)) {
            ListIterator<?> listIt = list.listIterator(index + 1);

            if ((lastObj == null) ? listIt.previous() == null : lastObj
                    .equals(listIt.previous())) {
                // iterate through the elements in sublist to see
                // if they are included in the same order in the list
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
                // All elements of sublist are found in main list
                // starting from listIt.nextIndex().
                if (!difFound) {
                    return listIt.nextIndex();
                }
            }
            // This was not the sequence we were looking for,
            // continue search for the lastObj in main list
            // at the position before index.
            index--;
        }
        return -1;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public static <T> ArrayList<T> list(Enumeration<T> enumeration) {
        ArrayList<T> list = new ArrayList<T>();
        while (enumeration.hasMoreElements()) {
            list.add(enumeration.nextElement());
        }
        return list;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public static <T> Collection<T> synchronizedCollection(
            Collection<T> collection) {
        if (collection == null) {
            throw new NullPointerException();
        }
        return new SynchronizedCollection<T>(collection);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public static <T> List<T> synchronizedList(List<T> list) {
        if (list == null) {
            throw new NullPointerException();
        }
        if (list instanceof RandomAccess) {
            return new SynchronizedRandomAccessList<T>(list);
        }
        return new SynchronizedList<T>(list);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public static <K, V> Map<K, V> synchronizedMap(Map<K, V> map) {
        if (map == null) {
            throw new NullPointerException();
        }
        return new SynchronizedMap<K, V>(map);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public static <E> Set<E> synchronizedSet(Set<E> set) {
        if (set == null) {
            throw new NullPointerException();
        }
        return new SynchronizedSet<E>(set);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public static <K, V> SortedMap<K, V> synchronizedSortedMap(
            SortedMap<K, V> map) {
        if (map == null) {
            throw new NullPointerException();
        }
        return new SynchronizedSortedMap<K, V>(map);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public static <E> SortedSet<E> synchronizedSortedSet(SortedSet<E> set) {
        if (set == null) {
            throw new NullPointerException();
        }
        return new SynchronizedSortedSet<E>(set);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @SuppressWarnings("unchecked")
    public static <E> Collection<E> unmodifiableCollection(
            Collection<? extends E> collection) {
        if (collection == null) {
            throw new NullPointerException();
        }
        return new UnmodifiableCollection<E>((Collection<E>) collection);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
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
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @SuppressWarnings("unchecked")
    public static <K, V> Map<K, V> unmodifiableMap(
            Map<? extends K, ? extends V> map) {
        if (map == null) {
            throw new NullPointerException();
        }
        return new UnmodifiableMap<K, V>((Map<K, V>) map);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @SuppressWarnings("unchecked")
    public static <E> Set<E> unmodifiableSet(Set<? extends E> set) {
        if (set == null) {
            throw new NullPointerException();
        }
        return new UnmodifiableSet<E>((Set<E>) set);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @SuppressWarnings("unchecked")
    public static <K, V> SortedMap<K, V> unmodifiableSortedMap(
            SortedMap<K, ? extends V> map) {
        if (map == null) {
            throw new NullPointerException();
        }
        return new UnmodifiableSortedMap<K, V>((SortedMap<K, V>) map);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public static <E> SortedSet<E> unmodifiableSortedSet(SortedSet<E> set) {
        if (set == null) {
            throw new NullPointerException();
        }
        return new UnmodifiableSortedSet<E>(set);
    }

    /**
     * Returns the number of elements in the {@code Collection} that match the
     * {@code Object} passed. If the {@code Object} is {@code null}, then the
     * number of {@code null} elements is returned.
     *
     * @param c
     *            the {@code Collection} to search.
     * @param o
     *            the {@code Object} to search for.
     * @return the number of matching elements.
     * @throws NullPointerException
     *             if the {@code Collection} parameter is {@code null}.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.744 -0500", hash_original_method = "69760DD13D23FD7DA542C8A7346928F2", hash_generated_method = "0F52713CAE53AE324652702B4F0017FB")
    
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
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @SuppressWarnings("unchecked")
    public static final <T> List<T> emptyList() {
        return EMPTY_LIST;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @SuppressWarnings("unchecked")
    public static final <T> Set<T> emptySet() {
        return EMPTY_SET;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @SuppressWarnings("unchecked")
    public static final <K, V> Map<K, V> emptyMap() {
        return EMPTY_MAP;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @SuppressWarnings("unchecked")
    public static <T> Enumeration<T> emptyEnumeration() {
        return (Enumeration<T>) EMPTY_ENUMERATION;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @SuppressWarnings("unchecked")
    public static <T> Iterator<T> emptyIterator() {
        return (Iterator<T>) EMPTY_ITERATOR;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
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
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public static <T> boolean addAll(Collection<? super T> c, T... a) {
        boolean modified = false;
        for (int i = 0; i < a.length; i++) {
            modified |= c.add(a[i]);
        }
        return modified;
    }

    /**
     * Returns whether the specified collections have no elements in common.
     *
     * @param c1
     *            the first collection.
     * @param c2
     *            the second collection.
     * @return {@code true} if the collections have no elements in common,
     *         {@code false} otherwise.
     * @throws NullPointerException
     *             if one of the collections is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.776 -0500", hash_original_method = "850D5E92CAC6694D83599DC96343182A", hash_generated_method = "4739EC0EC8671BD7C3709BF4002A041F")
    
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
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static <E> E checkType(E obj, Class<? extends E> type) {
        if (obj != null && !type.isInstance(obj)) {
            throw new ClassCastException("Attempt to insert element of type " + obj.getClass() +
                    " into collection of type " + type);
        }
        return obj;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public static <E> Set<E> newSetFromMap(Map<E, Boolean> map) {
        if (map.isEmpty()) {
            return new SetFromMap<E>(map);
        }
        throw new IllegalArgumentException();
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public static <T> Queue<T> asLifoQueue(Deque<T> deque) {
        return new AsLIFOQueue<T>(deque);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.458 -0400", hash_original_field = "A240022D45397AD0FD0431DDDFAF666B", hash_generated_field = "D0EAF21E918FB32348AF27B109DA8409")

    private static final Iterator<?> EMPTY_ITERATOR = new Iterator<Object>() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.457 -0400", hash_original_method = "28E75D14A5D2234D3702D9638A8D3094", hash_generated_method = "B2F402CD4B1F330E1194A5FAF66FE3C9")
        @Override
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_799695461 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_799695461;
            
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.458 -0400", hash_original_method = "243C3D15209D9BF28572CB29FC9F3DF7", hash_generated_method = "3613EA17897DB540D203CDF04CC84004")
        @Override
        public Object next() {
        	throw new NoSuchElementException();
            
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.458 -0400", hash_original_method = "45CE80048748F3BC523226127E4746F5", hash_generated_method = "FC031BE6A6E094CAC267938D912798A0")
        @Override
        public void remove() {
        	throw new IllegalStateException();
            
        }
        
};
    
    private static final class CopiesList<E> extends AbstractList<E> implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.789 -0500", hash_original_field = "00716E08DB57F7568974F7A71EC1F099", hash_generated_field = "2ACBEBBA06800CFC571100A6231B0F40")

        private static final long serialVersionUID = 2739099268398711800L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.791 -0500", hash_original_field = "1A88FD8A1A51AFF3DB40644580C95C83", hash_generated_field = "01825CC32046BF0FBE11738ABC136518")

        private  int n;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.794 -0500", hash_original_field = "AADC7BC67B0FB6048E4A856A581BAEE9", hash_generated_field = "93B043155067F80D0269375649E4D7D4")

        private  E element;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.797 -0500", hash_original_method = "5A122D173062D06824D4571736320F87", hash_generated_method = "5A122D173062D06824D4571736320F87")
        
CopiesList(int length, E object) {
            if (length < 0) {
                throw new IllegalArgumentException();
            }
            n = length;
            element = object;
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.800 -0500", hash_original_method = "B07BCF81C9C48C72A08077A0468A8769", hash_generated_method = "64D3CED08101CC99B6FE7D19531AEE3F")
        
@Override public boolean contains(Object object) {
            return element == null ? object == null : element.equals(object);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.802 -0500", hash_original_method = "61094B9B9DEC6161E82512577FAF3323", hash_generated_method = "E03EC52A19D4CF70A2D6B0DE2B0F74C1")
        
@Override public int size() {
            return n;
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.806 -0500", hash_original_method = "857A70B35DA7146CF7ADC484EC4AABC8", hash_generated_method = "479F877B0ABD29E428BD444AFA701F75")
        
@Override public E get(int location) {
            if (location >= 0 && location < n) {
                return element;
            }
            throw new IndexOutOfBoundsException();
        }
    }
    
    private static final class EmptyList extends AbstractList implements RandomAccess, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.811 -0500", hash_original_field = "AC4AD8926B907F321F7B202F0D093F9A", hash_generated_field = "F94EA5528856E40DE43B84AB4D470D7D")

        private static final long serialVersionUID = 8842843931221139166L;
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.635 -0400", hash_original_method = "BF3F11B0BCAE2AE80C7C74CBEB88EB5B", hash_generated_method = "BF3F11B0BCAE2AE80C7C74CBEB88EB5B")
        
        public EmptyList ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.814 -0500", hash_original_method = "38B750FD34BF6CB1144CDF020D3299E6", hash_generated_method = "8729C65328EC22719E24D8B8F3074B33")
        
@Override public boolean contains(Object object) {
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.816 -0500", hash_original_method = "F4586E3A64B5D10DEB709A723C85E55E", hash_generated_method = "4CDFC238940B74101802915B9FC2BFF4")
        
@Override public int size() {
            return 0;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.819 -0500", hash_original_method = "F59F44D1664BC2EE59D5A9B30D144285", hash_generated_method = "6E068D6033E2420F6FF38CC2D9FCD252")
        
@Override public Object get(int location) {
            throw new IndexOutOfBoundsException();
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.822 -0500", hash_original_method = "3CB4CAF1EADC3F12C565BD7D2B5F5514", hash_generated_method = "1B51020FE845D5A86417A6CBAD1E8FB4")
        
private Object readResolve() {
            return Collections.EMPTY_LIST;
        }
    }
    
    private static final class EmptySet extends AbstractSet implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.828 -0500", hash_original_field = "9E6792283594617B8BF2FB28A2B989D6", hash_generated_field = "A81D1AE03C05E931255584261EF756E0")

        private static final long serialVersionUID = 1582296315990362920L;
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.636 -0400", hash_original_method = "3A37381B9598D46CF46D5D53F85DF5B1", hash_generated_method = "3A37381B9598D46CF46D5D53F85DF5B1")
        
        public EmptySet ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.831 -0500", hash_original_method = "38B750FD34BF6CB1144CDF020D3299E6", hash_generated_method = "8729C65328EC22719E24D8B8F3074B33")
        
@Override public boolean contains(Object object) {
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.833 -0500", hash_original_method = "F4586E3A64B5D10DEB709A723C85E55E", hash_generated_method = "4CDFC238940B74101802915B9FC2BFF4")
        
@Override public int size() {
            return 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.836 -0500", hash_original_method = "FC88A4B2F50E498E162F3F7EEDE885B1", hash_generated_method = "49ED735C07535D6A5542D75AEC0C2394")
        
@Override public Iterator iterator() {
            return EMPTY_ITERATOR;
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.838 -0500", hash_original_method = "2ED0845ADEAE5655731C197578B08F82", hash_generated_method = "E4008661E77172298FCA2685EADD6E4D")
        
private Object readResolve() {
            return Collections.EMPTY_SET;
        }
    }
    
    private static final class EmptyMap extends AbstractMap implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.844 -0500", hash_original_field = "90C4463D906D4A60D8013846BB8339DA", hash_generated_field = "847A5C63C9A66D8A1818A774A2AADB69")

        private static final long serialVersionUID = 6428348081105594320L;
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.638 -0400", hash_original_method = "0E8F36F90F9C751DA5A12903A16705DF", hash_generated_method = "0E8F36F90F9C751DA5A12903A16705DF")
        
        public EmptyMap ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.847 -0500", hash_original_method = "2AD0E7E75E88E287D6229481B74BEBCC", hash_generated_method = "8A38E70440D50E1A3BF09B2D7145656E")
        
@Override public boolean containsKey(Object key) {
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.849 -0500", hash_original_method = "9D32B6FFC088649ED5480F6E533A1288", hash_generated_method = "8261EA3DFCEDC8E2FFA0369F604DCD57")
        
@Override public boolean containsValue(Object value) {
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.853 -0500", hash_original_method = "709DD403C63D2F4104FF93FEEB6E3457", hash_generated_method = "BB533A070C7705FC064A047BB57585D4")
        
@Override public Set entrySet() {
            return EMPTY_SET;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.855 -0500", hash_original_method = "59A1188DDD48CFFB749850DC2DA09C1D", hash_generated_method = "570E7ABE6D948578647E0FFAB87A1F36")
        
@Override public Object get(Object key) {
            return null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.858 -0500", hash_original_method = "266B164C16644761E32491964C192EB7", hash_generated_method = "80BB4489463B2458F8C1953732F7A8CC")
        
@Override public Set keySet() {
            return EMPTY_SET;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.860 -0500", hash_original_method = "745E6E226DD5F7D4E763DA74DFF70792", hash_generated_method = "06A700552BA1B0ECC8016BE367E70109")
        
@Override public Collection values() {
            return EMPTY_LIST;
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.862 -0500", hash_original_method = "59A22E9415A338EB85D7A7DD214359CC", hash_generated_method = "1D0D07FF6A1D015A26163BBC3A137E10")
        
private Object readResolve() {
            return Collections.EMPTY_MAP;
        }
    }
    
    private static final class ReverseComparator<T> implements Comparator<T>, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.877 -0500", hash_original_field = "C70720CC76542480CA92A23FC8C9BDF8", hash_generated_field = "28B0E21DBABF675E471021CA76588F6A")

        private static final ReverseComparator<Object> INSTANCE = new ReverseComparator<Object>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.880 -0500", hash_original_field = "432AF62647CB9AAAB1998CD06CE495C0", hash_generated_field = "410EA5184B11CE9687E932D7F263B83C")

        private static final long serialVersionUID = 7207038068494060240L;
        @DSVerified
        @DSSafe(DSCat.SAFE_LIST)         
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.641 -0400", hash_original_method = "FFB2FB11DBE006893CA9746ECCE68517", hash_generated_method = "FFB2FB11DBE006893CA9746ECCE68517")
        public ReverseComparator ()
        {
            //Synthesized constructor
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.883 -0500", hash_original_method = "907488F1D5625FE5C9F59ED8A7B6E697", hash_generated_method = "88F7814B6190E538F7D18E0F8682CE52")
        
@SuppressWarnings("unchecked")
        @Override public int compare(T o1, T o2) {
            Comparable<T> c2 = (Comparable<T>) o2;
            return c2.compareTo(o1);
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.885 -0500", hash_original_method = "DD371F0FDF8300FDCFBD1E5C395D42BC", hash_generated_method = "EB5879737A33A63EF4908F97CB7A9B2B")
        
private Object readResolve() throws ObjectStreamException {
            return INSTANCE;
        }
    }
    
    private static final class ReverseComparator2<T> implements Comparator<T>, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.891 -0500", hash_original_field = "3CD6395334A23B33BB5DA8C6E9C05985", hash_generated_field = "3328170146630256C37315D4155F67EF")

        private static final long serialVersionUID = 4374092139857L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.893 -0500", hash_original_field = "EF6258006D3DD383D657E405B531EC6D", hash_generated_field = "ACD6D4A2528BA4BAF7406DE3D3F49FE6")

        private  Comparator<T> cmp;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.896 -0500", hash_original_method = "1ABA0972F29BDB004C28A1246ABEF788", hash_generated_method = "1ABA0972F29BDB004C28A1246ABEF788")
        
ReverseComparator2(Comparator<T> comparator) {
            this.cmp = comparator;
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.899 -0500", hash_original_method = "449D1B24DD0E97F4D53DEB786BD04597", hash_generated_method = "79418D852474A21724BEDAFB03A065F2")
        
@Override public int compare(T o1, T o2) {
            return cmp.compare(o2, o1);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.902 -0500", hash_original_method = "30689CAB8FBFDCB9289EF03377EE08A0", hash_generated_method = "FF0A6EB27BC795947E6340BCD1F9393A")
        
@Override public boolean equals(Object o) {
            return o instanceof ReverseComparator2
                    && ((ReverseComparator2) o).cmp.equals(cmp);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.904 -0500", hash_original_method = "CAA612A5887D060562790EB1CDD1FEFE", hash_generated_method = "9E2E2EFBA669B8D7A3ACDEB9203DF215")
        
@Override public int hashCode() {
            return ~cmp.hashCode();
        }
    }
    
    private static final class SingletonSet<E> extends AbstractSet<E> implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.909 -0500", hash_original_field = "19F42BB89BFDE994B0F8BAE72C601126", hash_generated_field = "35AF14D3D33C59E58AFC233BD942F616")

        private static final long serialVersionUID = 3193687207550431679L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.912 -0500", hash_original_field = "AADC7BC67B0FB6048E4A856A581BAEE9", hash_generated_field = "AADC7BC67B0FB6048E4A856A581BAEE9")

         E element;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.915 -0500", hash_original_method = "044BE6981927B9234E2AE8686E07A72F", hash_generated_method = "044BE6981927B9234E2AE8686E07A72F")
        
SingletonSet(E object) {
            element = object;
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.918 -0500", hash_original_method = "B07BCF81C9C48C72A08077A0468A8769", hash_generated_method = "64D3CED08101CC99B6FE7D19531AEE3F")
        
@Override public boolean contains(Object object) {
            return element == null ? object == null : element.equals(object);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.921 -0500", hash_original_method = "798A0AE2F2A6352396904AB5C9ED97D5", hash_generated_method = "999B091C3E1AA2747781C03915791B62")
        
@Override public int size() {
            return 1;
        }
                
@DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.644 -0400", hash_original_method = "135AC18A6A8AD4548E2E750F2D4C7699", hash_generated_method = "39DA48894BA329BD18C0E92D954E9E9F")
        @Override
        public Iterator<E> iterator() {
Iterator<E> varEF1BE467ABB7AA4C87CBCE9613BD5C24_1939968739 =             new Iterator<E>() {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.924 -0500", hash_original_field = "DE9DC7F145F778F316047B4F4AEC3B9B", hash_generated_field = "DE9DC7F145F778F316047B4F4AEC3B9B")

                boolean hasNext = true;

                @DSComment("From safe class list")
            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.928 -0500", hash_original_method = "1FFE1DD028DACE64CCBE65BDB363D72C", hash_generated_method = "01087F7088E6F1BA25979EF3E6629EBE")
                
@Override public boolean hasNext() {
                    return hasNext;
                }

                @DSComment("From safe class list")
            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.931 -0500", hash_original_method = "163A9F5CD311CAB76B0FCB4B7573EA38", hash_generated_method = "1EFDDCE82CFCBD16B2F32506E1C542A2")
                
@Override public E next() {
                    if (hasNext) {
                        hasNext = false;
                        return element;
                    }
                    throw new NoSuchElementException();
                }

                @DSComment("From safe class list")
            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.934 -0500", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "2F468E7B2E16EC03C905C37F83253C97")
                
@Override public void remove() {
                    throw new UnsupportedOperationException();
                }
};
            varEF1BE467ABB7AA4C87CBCE9613BD5C24_1939968739.addTaint(getTaint());
            return varEF1BE467ABB7AA4C87CBCE9613BD5C24_1939968739;
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
    }
    
    private static final class SingletonList<E> extends AbstractList<E> implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.942 -0500", hash_original_field = "A503B0C4CB45255ACA10940B2EDF16EF", hash_generated_field = "CBFA444A21D6CBFF01F29F9591A887AB")

        private static final long serialVersionUID = 3093736618740652951L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.944 -0500", hash_original_field = "AADC7BC67B0FB6048E4A856A581BAEE9", hash_generated_field = "AADC7BC67B0FB6048E4A856A581BAEE9")

         E element;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.947 -0500", hash_original_method = "F3174A5FA7BA5962D109EAC3245F2C1D", hash_generated_method = "F3174A5FA7BA5962D109EAC3245F2C1D")
        
SingletonList(E object) {
            element = object;
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.949 -0500", hash_original_method = "B07BCF81C9C48C72A08077A0468A8769", hash_generated_method = "64D3CED08101CC99B6FE7D19531AEE3F")
        
@Override public boolean contains(Object object) {
            return element == null ? object == null : element.equals(object);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.952 -0500", hash_original_method = "1C6E7D1EB082158D5E00EA29E883A612", hash_generated_method = "265E1E0AA2C90FA02DBC1C66E1F2328A")
        
@Override public E get(int location) {
            if (location == 0) {
                return element;
            }
            throw new IndexOutOfBoundsException();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.955 -0500", hash_original_method = "798A0AE2F2A6352396904AB5C9ED97D5", hash_generated_method = "999B091C3E1AA2747781C03915791B62")
        
@Override public int size() {
            return 1;
        }
    }
    
    private static final class SingletonMap<K, V> extends AbstractMap<K, V> implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.961 -0500", hash_original_field = "EE499F8A7DDE5E756436D546DA7848C2", hash_generated_field = "0B15CF1CC7A3921AD66781626704DE4C")

        private static final long serialVersionUID = -6979724477215052911L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.963 -0500", hash_original_field = "052F80594ED04BACBC2E98744BD4CC2D", hash_generated_field = "052F80594ED04BACBC2E98744BD4CC2D")

         K k;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.966 -0500", hash_original_field = "3A278B3CDA0FEEA24CB626A0B3136D0B", hash_generated_field = "3A278B3CDA0FEEA24CB626A0B3136D0B")

         V v;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.968 -0500", hash_original_method = "85D3D420EE431E7A3C1CBFB71D1CEAE2", hash_generated_method = "85D3D420EE431E7A3C1CBFB71D1CEAE2")
        
SingletonMap(K key, V value) {
            k = key;
            v = value;
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.971 -0500", hash_original_method = "26D5E87A2C62405ADA3B15C5C8B30FEC", hash_generated_method = "A6EC990122FE8BF9A7E5207ACC107358")
        
@Override public boolean containsKey(Object key) {
            return k == null ? key == null : k.equals(key);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.974 -0500", hash_original_method = "827D42B4F919454EC51CA86D0E534994", hash_generated_method = "8B11A3E797135B1B91082A04525B7FC2")
        
@Override public boolean containsValue(Object value) {
            return v == null ? value == null : v.equals(value);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.977 -0500", hash_original_method = "8C587096F5E6029DBB187C58CF22D158", hash_generated_method = "29AFCEA63D7956479E67380AE46882D5")
        
@Override public V get(Object key) {
            if (containsKey(key)) {
                return v;
            }
            return null;
        }

                @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.987 -0500", hash_original_method = "798A0AE2F2A6352396904AB5C9ED97D5", hash_generated_method = "999B091C3E1AA2747781C03915791B62")
                
@Override public int size() {
                    return 1;
                }
        
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.505 -0400", hash_original_method = "AB4A6E093F1AE40B73184C21F1D08E5E", hash_generated_method = "48A2E5782E0DCD494BF96200E66A035B")
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
Set<Map.Entry<K, V>> varC1C98ED33EBE8D5F809497AE1618869F_181985594 =             new AbstractSet<Map.Entry<K, V>>() {
                @DSComment("From safe class list")
            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.984 -0500", hash_original_method = "2A1C1E3E6C77DBF97F80372F94562608", hash_generated_method = "58634BACB7326D5D531B01DD215AB24A")
                
@Override public boolean contains(Object object) {
                    if (object instanceof Map.Entry) {
                        Map.Entry<?, ?> entry = (Map.Entry<?, ?>) object;
                        return containsKey(entry.getKey())
                                && containsValue(entry.getValue());
                    }
                    return false;
                }
            
        @DSComment("From safe class list")
            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.499 -0400", hash_original_method = "798A0AE2F2A6352396904AB5C9ED97D5", hash_generated_method = "5EF0C210C2FD458D465D7A190312FDF5")
            @Override
            public int size() {
                int varC4CA4238A0B923820DCC509A6F75849B_580395766 = (1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_210558322 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_210558322;
                // ---------- Original Method ----------
                //return 1;
            }
            @DSComment("From safe class list")
            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.504 -0400", hash_original_method = "514544EF1052F229FBEAE8C28F5C502A", hash_generated_method = "D63081166929268C954FCFB5AD6DF760")
            @Override
            public Iterator<Map.Entry<K, V>> iterator() {
Iterator<Map.Entry<K, V>> var72555FFA480563A744615CB3042A10C3_693483736 =                 new Iterator<Map.Entry<K, V>>() {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.991 -0500", hash_original_field = "DE9DC7F145F778F316047B4F4AEC3B9B", hash_generated_field = "DE9DC7F145F778F316047B4F4AEC3B9B")

                        boolean hasNext = true;

                        @DSComment("From safe class list")
                @DSSafe(DSCat.SAFE_LIST)
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.994 -0500", hash_original_method = "1FFE1DD028DACE64CCBE65BDB363D72C", hash_generated_method = "01087F7088E6F1BA25979EF3E6629EBE")
                        
@Override public boolean hasNext() {
                            return hasNext;
                        }

                        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.002 -0500", hash_original_method = "E80284659713283C8723ACEF8D2E3A9E", hash_generated_method = "76FE30C60F409FCDA460F5CF84EA4675")
                        
@Override public Map.Entry<K, V> next() {
                            if (!hasNext) {
                                throw new NoSuchElementException();
                            }

                            hasNext = false;
                            return new MapEntry<K, V>(k, v) {
                                @DSComment("From safe class list")
                    @DSSafe(DSCat.SAFE_LIST)
                    @Override public V setValue(V value) {
                                    throw new UnsupportedOperationException();
                                }
                            };
                        }

                        @DSComment("From safe class list")
                @DSSafe(DSCat.SAFE_LIST)
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.006 -0500", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "2F468E7B2E16EC03C905C37F83253C97")
                        
@Override public void remove() {
                            throw new UnsupportedOperationException();
                        }
};
                var72555FFA480563A744615CB3042A10C3_693483736.addTaint(getTaint());
                return var72555FFA480563A744615CB3042A10C3_693483736;
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }
};
            varC1C98ED33EBE8D5F809497AE1618869F_181985594.addTaint(getTaint());
            return varC1C98ED33EBE8D5F809497AE1618869F_181985594;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }
    }
    
    static class SynchronizedCollection<E> implements Collection<E>, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.017 -0500", hash_original_field = "87EA351D1C67DD99108CD76ACAEA5723", hash_generated_field = "0D9A3687FC51DFBFFFEA57286BC842CD")

        private static final long serialVersionUID = 3053995032091335093L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.020 -0500", hash_original_field = "A3C80A7E02E49F20400373DFBAF9696A", hash_generated_field = "A3C80A7E02E49F20400373DFBAF9696A")

         Collection<E> c;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.022 -0500", hash_original_field = "5C5F8780FECE5E612AF5A86D3A8B3194", hash_generated_field = "5C5F8780FECE5E612AF5A86D3A8B3194")

         Object mutex;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.025 -0500", hash_original_method = "30FA7B26D2517E75155300E21A44EE02", hash_generated_method = "30FA7B26D2517E75155300E21A44EE02")
        
SynchronizedCollection(Collection<E> collection) {
            c = collection;
            mutex = this;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.028 -0500", hash_original_method = "A2A350BD37040709EC39C6B0536AFBDE", hash_generated_method = "A2A350BD37040709EC39C6B0536AFBDE")
        
SynchronizedCollection(Collection<E> collection, Object mutex) {
            c = collection;
            this.mutex = mutex;
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.031 -0500", hash_original_method = "FB2AC5CD0A8119C2DE50A53F38732CDD", hash_generated_method = "94FADEB4F0236521C702657F5DCE4B5F")
        
@Override public boolean add(E object) {
            synchronized (mutex) {
                return c.add(object);
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.034 -0500", hash_original_method = "8489E829BC0B88048B305735D46B1D99", hash_generated_method = "56C73B0F3A8A1B8360577837BAE7FDFB")
        
@Override public boolean addAll(Collection<? extends E> collection) {
            synchronized (mutex) {
                return c.addAll(collection);
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.037 -0500", hash_original_method = "7AE3345D011114FF0F62A8DFD7762BE2", hash_generated_method = "925364CC3D5FC5910EDC4DD5AF376EB3")
        
@Override public void clear() {
            synchronized (mutex) {
                c.clear();
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.039 -0500", hash_original_method = "1B12503F1112F0CD581293F3A624FEFF", hash_generated_method = "D49561305B2DC38DB6F1EACFEB6FCD33")
        
@Override public boolean contains(Object object) {
            synchronized (mutex) {
                return c.contains(object);
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.042 -0500", hash_original_method = "F945FF2C907D1AA0923D46DECCCD5EAD", hash_generated_method = "09B9CD21C81E698AC58767E4F7F3F4B2")
        
@Override public boolean containsAll(Collection<?> collection) {
            synchronized (mutex) {
                return c.containsAll(collection);
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.044 -0500", hash_original_method = "FC4F88C8FB9F4E3716AD2ABCD3101657", hash_generated_method = "7F0B0758CB990026EB0390807DD886C2")
        
@Override public boolean isEmpty() {
            synchronized (mutex) {
                return c.isEmpty();
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.048 -0500", hash_original_method = "7F1B5E60A4E4F9F3AFA65965967FBBF0", hash_generated_method = "45AC649498573208E423AF055FCA365D")
        
@Override public Iterator<E> iterator() {
            synchronized (mutex) {
                return c.iterator();
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.050 -0500", hash_original_method = "C85E45E4AF074973339408E1197B653C", hash_generated_method = "915B89FA49E45DA76C02E72459CD4428")
        
@Override public boolean remove(Object object) {
            synchronized (mutex) {
                return c.remove(object);
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.053 -0500", hash_original_method = "63829008A74D54A464D81619215951F3", hash_generated_method = "D51BED4EE5B4A627DE2EECB9AAD74177")
        
@Override public boolean removeAll(Collection<?> collection) {
            synchronized (mutex) {
                return c.removeAll(collection);
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.056 -0500", hash_original_method = "F83427C5B4EF86DB8198B3D2BAE482AC", hash_generated_method = "6CD6525CD3254A23BC84D7EC87D725D9")
        
@Override public boolean retainAll(Collection<?> collection) {
            synchronized (mutex) {
                return c.retainAll(collection);
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.059 -0500", hash_original_method = "8641BC878FB77D36CE60B1977D7C0FB5", hash_generated_method = "509A3479626C089752A55A73222FB863")
        
@Override public int size() {
            synchronized (mutex) {
                return c.size();
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.061 -0500", hash_original_method = "214BCEC14D5449B585926B657D8D51C2", hash_generated_method = "A9B905175AC7704A5C6B5B443D150540")
        
@Override public java.lang.Object[] toArray() {
            synchronized (mutex) {
                return c.toArray();
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.065 -0500", hash_original_method = "D637F0F4C3C8C312A0597F30C1C6DB59", hash_generated_method = "EBFF0143C57F798C0D6E589BD8D7C8D3")
        
@Override public String toString() {
            synchronized (mutex) {
                return c.toString();
            }
        }
                
@DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.705 -0400", hash_original_method = "567EED27866E99DFC1B7F8B43B648D82", hash_generated_method = "5CC036A91B9EFDC6513490DF2199D4B6")
        @Override
        public <T> T[] toArray(T[] array) {
            addTaint(array[0].getTaint());
            synchronized
(mutex)            {
T[] varA824E05E0FA0C1B35EB9A8324FF1796D_221099759 =                 c.toArray(array);
                varA824E05E0FA0C1B35EB9A8324FF1796D_221099759.addTaint(getTaint());
                return varA824E05E0FA0C1B35EB9A8324FF1796D_221099759;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.toArray(array);
            //}
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.069 -0500", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "3954EFB6756B415589B943D0E0596199")
        
private void writeObject(ObjectOutputStream stream) throws IOException {
            synchronized (mutex) {
                stream.defaultWriteObject();
            }
        }
    }
    
    static class SynchronizedRandomAccessList<E> extends SynchronizedList<E> implements RandomAccess {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.076 -0500", hash_original_field = "5441B2940B2E2A85EA57DBBDDA2F3C05", hash_generated_field = "F305BE0154CFFE9E0253007EE134CBB9")

        private static final long serialVersionUID = 1530674583602358482L;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.078 -0500", hash_original_method = "B7E7091552AE239FAE56C332916C1F88", hash_generated_method = "B7E7091552AE239FAE56C332916C1F88")
        
SynchronizedRandomAccessList(List<E> l) {
            super(l);
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.081 -0500", hash_original_method = "333C2DB156927D33EFC68D095A4D91C7", hash_generated_method = "333C2DB156927D33EFC68D095A4D91C7")
        
SynchronizedRandomAccessList(List<E> l, Object mutex) {
            super(l, mutex);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.084 -0500", hash_original_method = "52EB3707ADD11A2326D60B7B815140D9", hash_generated_method = "5E1300235BC62740B6BB2D153EE81967")
        
@Override public List<E> subList(int start, int end) {
            synchronized (mutex) {
                return new SynchronizedRandomAccessList<E>(list.subList(start, end), mutex);
            }
        }

        /**
         * Replaces this SynchronizedRandomAccessList with a SynchronizedList so
         * that JREs before 1.4 can deserialize this object without any
         * problems. This is necessary since RandomAccess API was introduced
         * only in 1.4.
         * <p>
         *
         * @return SynchronizedList
         *
         * @see SynchronizedList#readResolve()
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.087 -0500", hash_original_method = "3A06B4F1BF7736CF10F2183ECBC34EF4", hash_generated_method = "54FBC06F523132A1C8B176E554D3E94D")
        
private Object writeReplace() {
            return new SynchronizedList<E>(list);
        }
    }
    
    static class SynchronizedList<E> extends SynchronizedCollection<E> implements List<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.092 -0500", hash_original_field = "EFEC40F0FBEB7C74C2A60BBE2FE9E011", hash_generated_field = "5528D904FB3223ACA4EBA912A58AE2BF")

        private static final long serialVersionUID = -7754090372962971524L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.094 -0500", hash_original_field = "1ECA8D0C53ED31C6D874046BB18C0645", hash_generated_field = "1ECA8D0C53ED31C6D874046BB18C0645")

         List<E> list;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.097 -0500", hash_original_method = "557BC04FB4751FAF0774C664BC5CCEDB", hash_generated_method = "557BC04FB4751FAF0774C664BC5CCEDB")
        
SynchronizedList(List<E> l) {
            super(l);
            list = l;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.100 -0500", hash_original_method = "6BB690026CB7D337AD2D522FD2C1D564", hash_generated_method = "6BB690026CB7D337AD2D522FD2C1D564")
        
SynchronizedList(List<E> l, Object mutex) {
            super(l, mutex);
            list = l;
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.102 -0500", hash_original_method = "771543DB5FBF857EC43E623C900790C1", hash_generated_method = "A1DD9049677D9E48734221C8050F12A5")
        
@Override public void add(int location, E object) {
            synchronized (mutex) {
                list.add(location, object);
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.106 -0500", hash_original_method = "2E8B0D036C339DEB52EAEECF82B3FC29", hash_generated_method = "D26086D1BFDA791A129F595174CAA0DA")
        
@Override public boolean addAll(int location, Collection<? extends E> collection) {
            synchronized (mutex) {
                return list.addAll(location, collection);
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.108 -0500", hash_original_method = "3D6B0DEE3E066475015263D28B67E9C7", hash_generated_method = "3C87974C121E267506A2BEF991D885A2")
        
@Override public boolean equals(Object object) {
            synchronized (mutex) {
                return list.equals(object);
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.111 -0500", hash_original_method = "5B64BB89A58DED71DBA9907C06BC2CBB", hash_generated_method = "58A747A9DBAF35C7C2B775792AB429D5")
        
@Override public E get(int location) {
            synchronized (mutex) {
                return list.get(location);
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.113 -0500", hash_original_method = "4F5947DB3C3ABC0CDEDCB631295417DE", hash_generated_method = "F3096613A9825663FC68C7122CB039F2")
        
@Override public int hashCode() {
            synchronized (mutex) {
                return list.hashCode();
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.116 -0500", hash_original_method = "3D24998665BD619FA01B00E0A34A83F5", hash_generated_method = "4474DE71BD61D730D7840FC28F4873D2")
        
@Override public int indexOf(Object object) {
            final int size;
            final Object[] array;
            synchronized (mutex) {
                size = list.size();
                array = new Object[size];
                list.toArray(array);
            }
            if (object != null) {
                for (int i = 0; i < size; i++) {
                    if (object.equals(array[i])) {
                        return i;
                    }
                }
            } else {
                for (int i = 0; i < size; i++) {
                    if (array[i] == null) {
                        return i;
                    }
                }
            }
            return -1;
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.120 -0500", hash_original_method = "615F71337583130515178716D1767A86", hash_generated_method = "53ECB56D1BF196E575AA1120330AB5CF")
        
@Override public int lastIndexOf(Object object) {
            final int size;
            final Object[] array;
            synchronized (mutex) {
                size = list.size();
                array = new Object[size];
                list.toArray(array);
            }
            if (object != null) {
                for (int i = size - 1; i >= 0; i--) {
                    if (object.equals(array[i])) {
                        return i;
                    }
                }
            } else {
                for (int i = size - 1; i >= 0; i--) {
                    if (array[i] == null) {
                        return i;
                    }
                }
            }
            return -1;
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.123 -0500", hash_original_method = "9E49E91DE129681261C3C7642C2D1127", hash_generated_method = "5EA1C85BFCEEC3534C05927B773CE8ED")
        
@Override public ListIterator<E> listIterator() {
            synchronized (mutex) {
                return list.listIterator();
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.126 -0500", hash_original_method = "70349F3896FC81F4D21A3D35B0C8A4F6", hash_generated_method = "3D284E43E7551AEB02A2C452803063CE")
        
@Override public ListIterator<E> listIterator(int location) {
            synchronized (mutex) {
                return list.listIterator(location);
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.128 -0500", hash_original_method = "D935E09B492D323BEF59297A7648FE48", hash_generated_method = "464F36B5C12BF12088CA9A0AD4F34642")
        
@Override public E remove(int location) {
            synchronized (mutex) {
                return list.remove(location);
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.131 -0500", hash_original_method = "D9730991663FB8C206D80781B7E02750", hash_generated_method = "F8D877BF206629AEF738AF4CD20A042F")
        
@Override public E set(int location, E object) {
            synchronized (mutex) {
                return list.set(location, object);
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.134 -0500", hash_original_method = "C38F2D62AA6D1EBD255ADC5369CBEC01", hash_generated_method = "345A027C61418112A164514206090040")
        
@Override public List<E> subList(int start, int end) {
            synchronized (mutex) {
                return new SynchronizedList<E>(list.subList(start, end), mutex);
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.136 -0500", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "3954EFB6756B415589B943D0E0596199")
        
private void writeObject(ObjectOutputStream stream) throws IOException {
            synchronized (mutex) {
                stream.defaultWriteObject();
            }
        }

        /**
         * Resolves SynchronizedList instances to SynchronizedRandomAccessList
         * instances if the underlying list is a Random Access list.
         * <p>
         * This is necessary since SynchronizedRandomAccessList instances are
         * replaced with SynchronizedList instances during serialization for
         * compliance with JREs before 1.4.
         * <p>
         *
         * @return a SynchronizedList instance if the underlying list implements
         *         RandomAccess interface, or this same object if not.
         *
         * @see SynchronizedRandomAccessList#writeReplace()
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.139 -0500", hash_original_method = "172F08E6F2352F1764A4A70C48C6E243", hash_generated_method = "EC2EB2F402B49276FEE60D910E3FFDD6")
        
private Object readResolve() {
            if (list instanceof RandomAccess) {
                return new SynchronizedRandomAccessList<E>(list, mutex);
            }
            return this;
        }
    }
    
    static class SynchronizedMap<K, V> implements Map<K, V>, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.146 -0500", hash_original_field = "45306B1E7073464302AF89EDF119CFD8", hash_generated_field = "1DE57645F72579A567941D71223F2BB4")

        private static final long serialVersionUID = 1978198479659022715L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.148 -0500", hash_original_field = "B770F05C5A3A992B6F65D731F667A79E", hash_generated_field = "1785B4570966C73126874A8D942D2395")

        private  Map<K, V> m;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.151 -0500", hash_original_field = "5C5F8780FECE5E612AF5A86D3A8B3194", hash_generated_field = "5C5F8780FECE5E612AF5A86D3A8B3194")

         Object mutex;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.153 -0500", hash_original_method = "C14189E3F71A4C148CB91C638F3BAAE3", hash_generated_method = "C14189E3F71A4C148CB91C638F3BAAE3")
        
SynchronizedMap(Map<K, V> map) {
            m = map;
            mutex = this;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.156 -0500", hash_original_method = "6EAD9DD813CFD47244744C3F6D6A4D1C", hash_generated_method = "6EAD9DD813CFD47244744C3F6D6A4D1C")
        
SynchronizedMap(Map<K, V> map, Object mutex) {
            m = map;
            this.mutex = mutex;
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.158 -0500", hash_original_method = "3DCF075501F09300584E40825720BBA2", hash_generated_method = "729786DD72D69ACFBED19A6934506C52")
        
@Override public void clear() {
            synchronized (mutex) {
                m.clear();
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.161 -0500", hash_original_method = "D2C67B34100B05197A0572527ECA3220", hash_generated_method = "BE804C04BB57C32A5E7CB230DF1703F1")
        
@Override public boolean containsKey(Object key) {
            synchronized (mutex) {
                return m.containsKey(key);
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.163 -0500", hash_original_method = "FFE2162DB44C1E8BEEAD35935B233C81", hash_generated_method = "84840D6E87B65928A1D668AB86583C0C")
        
@Override public boolean containsValue(Object value) {
            synchronized (mutex) {
                return m.containsValue(value);
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.167 -0500", hash_original_method = "E5EA9A3F9567269DAA52E0C08140D3D5", hash_generated_method = "078F0BCC94352984EE64AB96ED9E320D")
        
@Override public Set<Map.Entry<K, V>> entrySet() {
            synchronized (mutex) {
                return new SynchronizedSet<Map.Entry<K, V>>(m.entrySet(), mutex);
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.170 -0500", hash_original_method = "573EFA9740FEBDEC9C1CCFD8172CCEF0", hash_generated_method = "D2937EB85C33437A734B12739688A42E")
        
@Override public boolean equals(Object object) {
            synchronized (mutex) {
                return m.equals(object);
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.172 -0500", hash_original_method = "80DF7D6FED6980DF61457325CD64503D", hash_generated_method = "50815093A04A580D31E8858D3FC6BAC6")
        
@Override public V get(Object key) {
            synchronized (mutex) {
                return m.get(key);
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.175 -0500", hash_original_method = "5DDF560D56DA8F61EEAD582BB150A893", hash_generated_method = "81470556F0E8119A7949729129A060F2")
        
@Override public int hashCode() {
            synchronized (mutex) {
                return m.hashCode();
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.178 -0500", hash_original_method = "40A122CDBD7096230690259CC30A0F7A", hash_generated_method = "5BFA9CA257D661142EEBC6039E7A184D")
        
@Override public boolean isEmpty() {
            synchronized (mutex) {
                return m.isEmpty();
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.180 -0500", hash_original_method = "2FBB6190D51F2A6210F8CF71191E69DD", hash_generated_method = "07B4E131FB4B469FA290E43568CF4459")
        
@Override public Set<K> keySet() {
            synchronized (mutex) {
                return new SynchronizedSet<K>(m.keySet(), mutex);
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.183 -0500", hash_original_method = "4BBBC2EF3E646AB7C0C1BFCAE8571FAF", hash_generated_method = "2834B9F60F50527FDA0558DE796BF617")
        
@Override public V put(K key, V value) {
            synchronized (mutex) {
                return m.put(key, value);
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.186 -0500", hash_original_method = "400FF0E6707670DAA4FF7ECA275302A3", hash_generated_method = "1EB01A85BA8000DF3C6B484CC72042C3")
        
@Override public void putAll(Map<? extends K, ? extends V> map) {
            synchronized (mutex) {
                m.putAll(map);
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.188 -0500", hash_original_method = "98B37460DCD5FD18048F5172283C3141", hash_generated_method = "074144C3916F58C1CC207DC8A8A96B17")
        
@Override public V remove(Object key) {
            synchronized (mutex) {
                return m.remove(key);
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.191 -0500", hash_original_method = "A48EE7C65347333E889EFC2ECD0A019A", hash_generated_method = "F5D44EBFBC979CC210F7DE4230FC1A70")
        
@Override public int size() {
            synchronized (mutex) {
                return m.size();
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.194 -0500", hash_original_method = "BB797020E54DC33FB15BC9404E89E5CD", hash_generated_method = "B027B7DFE52F9B225904473747AEE54B")
        
@Override public Collection<V> values() {
            synchronized (mutex) {
                return new SynchronizedCollection<V>(m.values(), mutex);
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.197 -0500", hash_original_method = "CB61B465EF18C12F472B81636CD4AC79", hash_generated_method = "2E52801530DA700A8C730504D2F5FFDA")
        
@Override public String toString() {
            synchronized (mutex) {
                return m.toString();
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.199 -0500", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "3954EFB6756B415589B943D0E0596199")
        
private void writeObject(ObjectOutputStream stream) throws IOException {
            synchronized (mutex) {
                stream.defaultWriteObject();
            }
        }
    }
    
    static class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.205 -0500", hash_original_field = "AA1AF52A852FAB805B2BAC94B18AA677", hash_generated_field = "A77C43308F38D2FC67E81B4E46E8827E")

        private static final long serialVersionUID = 487447009682186044L;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.208 -0500", hash_original_method = "F3863A567ABAC10F9410ABCF2A4DC8AC", hash_generated_method = "F3863A567ABAC10F9410ABCF2A4DC8AC")
        
SynchronizedSet(Set<E> set) {
            super(set);
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.211 -0500", hash_original_method = "A1BA2E3E145DCA2C522F0AB9439A1572", hash_generated_method = "A1BA2E3E145DCA2C522F0AB9439A1572")
        
SynchronizedSet(Set<E> set, Object mutex) {
            super(set, mutex);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.213 -0500", hash_original_method = "E045FF0B832C85F3AF0597463FE3892F", hash_generated_method = "737EED3DE5CE27E32C8A87D489FD8F2B")
        
@Override public boolean equals(Object object) {
            synchronized (mutex) {
                return c.equals(object);
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.216 -0500", hash_original_method = "60CA731F9E7ECB7D3EED20B0D6D4AB09", hash_generated_method = "EC046EA3FD56E90DE4916E7D3DA575AF")
        
@Override public int hashCode() {
            synchronized (mutex) {
                return c.hashCode();
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.219 -0500", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "3954EFB6756B415589B943D0E0596199")
        
private void writeObject(ObjectOutputStream stream) throws IOException {
            synchronized (mutex) {
                stream.defaultWriteObject();
            }
        }
    }
    
    static class SynchronizedSortedMap<K, V> extends SynchronizedMap<K, V> implements SortedMap<K, V> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.224 -0500", hash_original_field = "871D6E87FBCF84363FAE899418C5F3F1", hash_generated_field = "ECA677D018A422E9BB2369A5AF38055A")

        private static final long serialVersionUID = -8798146769416483793L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.227 -0500", hash_original_field = "41E5EF207399B1082121011C1EB446FF", hash_generated_field = "F813233D7B24D3620137345516D05A23")

        private  SortedMap<K, V> sm;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.230 -0500", hash_original_method = "2E0F62BCD34367F1E6E251286E17ABEB", hash_generated_method = "2E0F62BCD34367F1E6E251286E17ABEB")
        
SynchronizedSortedMap(SortedMap<K, V> map) {
            super(map);
            sm = map;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.232 -0500", hash_original_method = "5BF33998E3FF0155F7A513C6A201FE85", hash_generated_method = "5BF33998E3FF0155F7A513C6A201FE85")
        
SynchronizedSortedMap(SortedMap<K, V> map, Object mutex) {
            super(map, mutex);
            sm = map;
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.235 -0500", hash_original_method = "78218A5A359D1FCDF6B98779037FCB94", hash_generated_method = "1320E65B040D350F1CF6EC3AFFE990CF")
        
@Override public Comparator<? super K> comparator() {
            synchronized (mutex) {
                return sm.comparator();
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.238 -0500", hash_original_method = "4A44F83861E496A35113DD67FECD390A", hash_generated_method = "DDBF5603F0414631B3631753356B6D94")
        
@Override public K firstKey() {
            synchronized (mutex) {
                return sm.firstKey();
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.241 -0500", hash_original_method = "758EF70CDC2061BD7D7B124D17EF3F64", hash_generated_method = "5BAB5489D8B7B3D3536354D5CED03F95")
        
@Override public SortedMap<K, V> headMap(K endKey) {
            synchronized (mutex) {
                return new SynchronizedSortedMap<K, V>(sm.headMap(endKey),
                        mutex);
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.244 -0500", hash_original_method = "ECB924A52CC9F341D1EEB7E5D7BCCDC8", hash_generated_method = "B96ABD8F74B10C212088DC18BA4F5A5E")
        
@Override public K lastKey() {
            synchronized (mutex) {
                return sm.lastKey();
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.246 -0500", hash_original_method = "E82E6227AA62F00EB1D33B47A72F41C4", hash_generated_method = "9E49A0A1CCD7620EF94835C6158E2723")
        
@Override public SortedMap<K, V> subMap(K startKey, K endKey) {
            synchronized (mutex) {
                return new SynchronizedSortedMap<K, V>(sm.subMap(startKey,
                        endKey), mutex);
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.249 -0500", hash_original_method = "F7B84D714F16D295C7D43C8AA5E52D6A", hash_generated_method = "BD039FE50D536008D9365CB8B53AC1A8")
        
@Override public SortedMap<K, V> tailMap(K startKey) {
            synchronized (mutex) {
                return new SynchronizedSortedMap<K, V>(sm.tailMap(startKey),
                        mutex);
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.251 -0500", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "3954EFB6756B415589B943D0E0596199")
        
private void writeObject(ObjectOutputStream stream) throws IOException {
            synchronized (mutex) {
                stream.defaultWriteObject();
            }
        }
    }
    
    static class SynchronizedSortedSet<E> extends SynchronizedSet<E> implements SortedSet<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.257 -0500", hash_original_field = "B87D4B68AB046CE9FFF8EA7965872C85", hash_generated_field = "44E22A9B5E1BF0CBC26900B92B680526")

        private static final long serialVersionUID = 8695801310862127406L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.260 -0500", hash_original_field = "3926F730B29F3CD5942BECEF18215BC4", hash_generated_field = "5220A6F2AA4CB98BB6C290F0BB717E86")

        private  SortedSet<E> ss;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.263 -0500", hash_original_method = "B2F0E775DF29B0E6B28447766B0AA532", hash_generated_method = "B2F0E775DF29B0E6B28447766B0AA532")
        
SynchronizedSortedSet(SortedSet<E> set) {
            super(set);
            ss = set;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.266 -0500", hash_original_method = "46957450EFA60C06BEFC5742F9BFAC78", hash_generated_method = "46957450EFA60C06BEFC5742F9BFAC78")
        
SynchronizedSortedSet(SortedSet<E> set, Object mutex) {
            super(set, mutex);
            ss = set;
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.269 -0500", hash_original_method = "D71F7DA0E84FA7A091B4017D559410C5", hash_generated_method = "D4D1E8E39012CC346F4CF78B20608A42")
        
@Override public Comparator<? super E> comparator() {
            synchronized (mutex) {
                return ss.comparator();
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.271 -0500", hash_original_method = "C2C55C7E331CFDE8E84B8FC74FDABE02", hash_generated_method = "458E965DF0BB6B5FBD4643F4FEA4989E")
        
@Override public E first() {
            synchronized (mutex) {
                return ss.first();
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.274 -0500", hash_original_method = "86DA75392AF50D6AE53AEE4A4052EBA8", hash_generated_method = "9859A7A2E0E667C2603590BA1F03A3B8")
        
@Override public SortedSet<E> headSet(E end) {
            synchronized (mutex) {
                return new SynchronizedSortedSet<E>(ss.headSet(end), mutex);
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.277 -0500", hash_original_method = "3C10DA3BCCE6BED4EBD1F6A2C6BC8438", hash_generated_method = "1102D2C87D10ABBDEF9902F3D42DE315")
        
@Override public E last() {
            synchronized (mutex) {
                return ss.last();
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.280 -0500", hash_original_method = "662A59FFAA1C1722D75A374EC93FB0DF", hash_generated_method = "0FE2C107C9F1C6A58752AC4122BEBAEB")
        
@Override public SortedSet<E> subSet(E start, E end) {
            synchronized (mutex) {
                return new SynchronizedSortedSet<E>(ss.subSet(start, end),
                        mutex);
            }
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.283 -0500", hash_original_method = "4C04840896A126B8B17AD8E0926A5B00", hash_generated_method = "FD3A45E67583B7D1ACCB3F2308583F93")
        
@Override public SortedSet<E> tailSet(E start) {
            synchronized (mutex) {
                return new SynchronizedSortedSet<E>(ss.tailSet(start), mutex);
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.286 -0500", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "3954EFB6756B415589B943D0E0596199")
        
private void writeObject(ObjectOutputStream stream) throws IOException {
            synchronized (mutex) {
                stream.defaultWriteObject();
            }
        }
    }
    
    private static class UnmodifiableCollection<E> implements Collection<E>, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.291 -0500", hash_original_field = "6C43110CC04324E6471EE00EA685548F", hash_generated_field = "ED589FB504EC70A2532C4CA52BA9C8D0")

        private static final long serialVersionUID = 1820017752578914078L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.293 -0500", hash_original_field = "A3C80A7E02E49F20400373DFBAF9696A", hash_generated_field = "A3C80A7E02E49F20400373DFBAF9696A")

         Collection<E> c;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.296 -0500", hash_original_method = "0B21B3311CB87F81844FA591591A704A", hash_generated_method = "0B21B3311CB87F81844FA591591A704A")
        
UnmodifiableCollection(Collection<E> collection) {
            c = collection;
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.299 -0500", hash_original_method = "1E7EFCC2BAD401EE702FAECD906F0B57", hash_generated_method = "E7A9EB0786A2E0CF65C23BCF03023D0E")
        
@Override public boolean add(E object) {
            throw new UnsupportedOperationException();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.303 -0500", hash_original_method = "A14B246F22D65FADC1A66C9C0851763B", hash_generated_method = "57DF2FFB73BB2BA89D7900E7A11FE899")
        
@Override public boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.306 -0500", hash_original_method = "C5BE2B5F9D582C4EED1DC0880E8741A1", hash_generated_method = "B8BAFB0AC3CF0151A5DF3B0432CEC10B")
        
@Override public void clear() {
            throw new UnsupportedOperationException();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.308 -0500", hash_original_method = "9A5FA57B69BAE7BFE0B020704235C788", hash_generated_method = "E32A08C7F457D35DC187CF1D44A5F194")
        
@Override public boolean contains(Object object) {
            return c.contains(object);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.311 -0500", hash_original_method = "BD1B4CD05BF6E123B0DC6FD003A6020C", hash_generated_method = "F4E6309AC2D400DE3896D8D52CDFFA0A")
        
@Override public boolean containsAll(Collection<?> collection) {
            return c.containsAll(collection);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.314 -0500", hash_original_method = "F9A3CB1FB7570D28EBE20660E2FC6F42", hash_generated_method = "23D90841DA823CEC89D1867FCC0D9D5D")
        
@Override public boolean isEmpty() {
            return c.isEmpty();
        }
                
@DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.732 -0400", hash_original_method = "57C2B30126E9906DFFF70EEB2D2CD18D", hash_generated_method = "B262D68F3934C177FEAA4645EDB16A1F")
        @Override
        public Iterator<E> iterator() {
Iterator<E> var17584F965577555F1B3BEAB9FFD781E4_1722746458 =             new Iterator<E>() {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.317 -0500", hash_original_field = "BFAA84E4781D6E7F7943DE789C19AEAB", hash_generated_field = "BFAA84E4781D6E7F7943DE789C19AEAB")

                Iterator<E> iterator = c.iterator();

                @DSComment("From safe class list")
            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.320 -0500", hash_original_method = "AA3B17E619A4DDCE5FFF27C1294FF431", hash_generated_method = "2E759C80F5A3750B360B5CEB00C83331")
                
@Override public boolean hasNext() {
                    return iterator.hasNext();
                }

                @DSComment("From safe class list")
            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.323 -0500", hash_original_method = "E4F6FE4F8164B2EF0F004EE03FA1069C", hash_generated_method = "07152F5D2150E9756A5647791A961CB3")
                
@Override public E next() {
                    return iterator.next();
                }

                @DSComment("From safe class list")
            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.326 -0500", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "2F468E7B2E16EC03C905C37F83253C97")
                
@Override public void remove() {
                    throw new UnsupportedOperationException();
                }
};
            var17584F965577555F1B3BEAB9FFD781E4_1722746458.addTaint(getTaint());
            return var17584F965577555F1B3BEAB9FFD781E4_1722746458;
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

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.332 -0500", hash_original_method = "2165C77F20F5DBDDE4D0AED313262684", hash_generated_method = "9627B71E0495FE0F4AFA53102C3D1C88")
        
@Override public boolean remove(Object object) {
            throw new UnsupportedOperationException();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.335 -0500", hash_original_method = "95D6D7B80D3C762A794FEAFDE42B30FC", hash_generated_method = "9C75476C751F6DC5AB88E50396C047FF")
        
@Override public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.337 -0500", hash_original_method = "D4789A90B422D35C3FC475A0D6C54BE8", hash_generated_method = "AF77656E728AB3FB2F8F84C437B94795")
        
@Override public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.340 -0500", hash_original_method = "AC97C28F724592ABA809E2470D95C119", hash_generated_method = "6E60024DDE6926D583CFC3C20F64A8CA")
        
@Override public int size() {
            return c.size();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.342 -0500", hash_original_method = "89D7D02A9D2BDF31E775C08108CBDE5B", hash_generated_method = "8BF4E8B38021950F5B0E5733096FB3FE")
        
@Override public Object[] toArray() {
            return c.toArray();
        }
                
@DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.735 -0400", hash_original_method = "D5913A45F2385B9A173BEEED47EA354F", hash_generated_method = "F6F2B517349AE26404C3A18C39898EBB")
        @Override
        public <T> T[] toArray(T[] array) {
            addTaint(array[0].getTaint());
T[] varA824E05E0FA0C1B35EB9A8324FF1796D_1507973265 =             c.toArray(array);
            varA824E05E0FA0C1B35EB9A8324FF1796D_1507973265.addTaint(getTaint());
            return varA824E05E0FA0C1B35EB9A8324FF1796D_1507973265;
            // ---------- Original Method ----------
            //return c.toArray(array);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.348 -0500", hash_original_method = "424D4966F358AE6553349A6493C21674", hash_generated_method = "AF73726CA0BD4643C6282EFEB60006CA")
        
@Override public String toString() {
            return c.toString();
        }
    }
    
    private static class UnmodifiableRandomAccessList<E> extends UnmodifiableList<E> implements RandomAccess {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.353 -0500", hash_original_field = "C6B578144501016B37C405E9466D0C80", hash_generated_field = "871EA319ACA4D6DBFD800453B4F24DBA")

        private static final long serialVersionUID = -2542308836966382001L;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.356 -0500", hash_original_method = "0A20B358F7BA1E60AD6DE80ADB85C324", hash_generated_method = "0A20B358F7BA1E60AD6DE80ADB85C324")
        
UnmodifiableRandomAccessList(List<E> l) {
            super(l);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.359 -0500", hash_original_method = "BFD692E8EF2A50E82DD6BA0EC7051578", hash_generated_method = "A9BB43C9BFC8381122B88F6F50C8A7DF")
        
@Override public List<E> subList(int start, int end) {
            return new UnmodifiableRandomAccessList<E>(list.subList(start, end));
        }

        /**
         * Replaces this UnmodifiableRandomAccessList with an UnmodifiableList
         * so that JREs before 1.4 can deserialize this object without any
         * problems. This is necessary since RandomAccess API was introduced
         * only in 1.4.
         * <p>
         *
         * @return UnmodifiableList
         *
         * @see UnmodifiableList#readResolve()
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.361 -0500", hash_original_method = "C39E6F512687738DD8D987CDE63A2838", hash_generated_method = "CB5BB89DAF09C50398A7481146A40D42")
        
private Object writeReplace() {
            return new UnmodifiableList<E>(list);
        }
    }
    
    private static class UnmodifiableList<E> extends UnmodifiableCollection<E> implements List<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.366 -0500", hash_original_field = "3D1217B3C30A46B09F9A2401FC2D077C", hash_generated_field = "F0F0F0942F5CE1242FD2AB85FF483C32")

        private static final long serialVersionUID = -283967356065247728L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.369 -0500", hash_original_field = "1ECA8D0C53ED31C6D874046BB18C0645", hash_generated_field = "1ECA8D0C53ED31C6D874046BB18C0645")

         List<E> list;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.372 -0500", hash_original_method = "4CB96388E36B825DE711E2E59A893E0D", hash_generated_method = "4CB96388E36B825DE711E2E59A893E0D")
        
UnmodifiableList(List<E> l) {
            super(l);
            list = l;
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.375 -0500", hash_original_method = "CE54A57EF9628E9FD413F964E9F93054", hash_generated_method = "F9C3B5D801D5115B45135EAA8D30B72D")
        
@Override public void add(int location, E object) {
            throw new UnsupportedOperationException();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.378 -0500", hash_original_method = "6CD19404B4901DECE5B6F72EB7D0CD8F", hash_generated_method = "123A508C79469E4657A4B5FA31E88801")
        
@Override public boolean addAll(int location, Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.380 -0500", hash_original_method = "C3C1892342CAEB152D9191558B893ACD", hash_generated_method = "47F4C70F03CEF2BF6859070660E1AC3F")
        
@Override public boolean equals(Object object) {
            return list.equals(object);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.383 -0500", hash_original_method = "DFB24286AA0C5C6BF58031CA4ED7CDCB", hash_generated_method = "1C2B1EC2CEC6DEB1BF019184469848C5")
        
@Override public E get(int location) {
            return list.get(location);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.385 -0500", hash_original_method = "8FDA3E2E38E99F5D6FC34E94E92E953F", hash_generated_method = "00FEED4590D0890DEB08FA108051F34A")
        
@Override public int hashCode() {
            return list.hashCode();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.388 -0500", hash_original_method = "E8AAF2C874038C363BF8C80F2A4ED8F2", hash_generated_method = "40E3B956201B0822CBC8FAF4D28ADD4C")
        
@Override public int indexOf(Object object) {
            return list.indexOf(object);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.391 -0500", hash_original_method = "658C7926C6DFF1B86F4D9B6B0E3F5BBD", hash_generated_method = "FF0703556B4BC96AF5029366117D6DCD")
        
@Override public int lastIndexOf(Object object) {
            return list.lastIndexOf(object);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.393 -0500", hash_original_method = "DF7BE0B13ABC5A9B1C74313BD06FB64C", hash_generated_method = "BFE08F68D525BB3FE20C89D63996BF59")
        
@Override public ListIterator<E> listIterator() {
            return listIterator(0);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.751 -0400", hash_original_method = "1D0E6831E50FA8995D23240A6E091C82", hash_generated_method = "685CD7A900A8299B727471C10D97D42A")
        @Override
        public ListIterator<E> listIterator(final int location) {
            addTaint(location);
ListIterator<E> var69CB1B11F3ED0B0F805A4D48ECD2D84F_44794926 =             new ListIterator<E>() {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.397 -0500", hash_original_field = "3511DBB9873C9158ABE706F9AEA2F24A", hash_generated_field = "3511DBB9873C9158ABE706F9AEA2F24A")

                ListIterator<E> iterator = list.listIterator(location);

                @DSComment("From safe class list")
            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.400 -0500", hash_original_method = "960DAE05B3D69FE5F79E9628DB5B33E6", hash_generated_method = "AC7F8352981EC4100FAB3F2FFF1754C5")
                
@Override public void add(E object) {
                    throw new UnsupportedOperationException();
                }

                @DSComment("From safe class list")
            @DSSafe(DSCat.SAFE_OTHERS)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.403 -0500", hash_original_method = "AA3B17E619A4DDCE5FFF27C1294FF431", hash_generated_method = "2E759C80F5A3750B360B5CEB00C83331")
                
@Override public boolean hasNext() {
                    return iterator.hasNext();
                }

                @DSComment("From safe class list")
            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.406 -0500", hash_original_method = "6C308ED658D3F7DABB0C5BB5EC622D45", hash_generated_method = "56A06CE3EDF18B516E5F16E1AC3C7897")
                
@Override public boolean hasPrevious() {
                    return iterator.hasPrevious();
                }

                @DSComment("From safe class list")
            @DSSafe(DSCat.SAFE_OTHERS)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.409 -0500", hash_original_method = "E4F6FE4F8164B2EF0F004EE03FA1069C", hash_generated_method = "07152F5D2150E9756A5647791A961CB3")
                
@Override public E next() {
                    return iterator.next();
                }

                @DSComment("From safe class list")
            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.413 -0500", hash_original_method = "966AADF518643C3720C5A10EB9E91B73", hash_generated_method = "8F45466F406082CBAFF1D0E45C7F0310")
                
@Override public int nextIndex() {
                    return iterator.nextIndex();
                }

                @DSComment("From safe class list")
            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.416 -0500", hash_original_method = "AEA372ED9A2A3ECAEDCF64AE3E3251E3", hash_generated_method = "1F6B1BCDF91A0A9DC195CE95DE30C69B")
                
@Override public E previous() {
                    return iterator.previous();
                }

                @DSComment("From safe class list")
            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.419 -0500", hash_original_method = "4F453E1B19F3569A7CE9D88D231730E4", hash_generated_method = "2091CEC5ED4FA81E35CAFDAA3B0C316B")
                
@Override public int previousIndex() {
                    return iterator.previousIndex();
                }

                @DSComment("From safe class list")
            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.422 -0500", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "2F468E7B2E16EC03C905C37F83253C97")
                
@Override public void remove() {
                    throw new UnsupportedOperationException();
                }

                @DSComment("From safe class list")
            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.425 -0500", hash_original_method = "1001E1C2B2FD09C7DE97126421AC0A91", hash_generated_method = "3A7DA6A34A606A81291B6164707E10F1")
                
@Override public void set(E object) {
                    throw new UnsupportedOperationException();
                }
};
            var69CB1B11F3ED0B0F805A4D48ECD2D84F_44794926.addTaint(getTaint());
            return var69CB1B11F3ED0B0F805A4D48ECD2D84F_44794926;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.430 -0500", hash_original_method = "5388D372D048D053ADD084F02A9C1484", hash_generated_method = "1FC79A5F48F627E6290C7CE9F262F1A6")
        
@Override public E remove(int location) {
            throw new UnsupportedOperationException();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.433 -0500", hash_original_method = "8830E2F07CC294339D5D496574BCFA5E", hash_generated_method = "8291D01CC6A59A73201902EAF8AA4D02")
        
@Override public E set(int location, E object) {
            throw new UnsupportedOperationException();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.436 -0500", hash_original_method = "82D78FB8922B9A0888EF8A304898D60D", hash_generated_method = "BD89F99BAD959BD50845490EE142178A")
        
@Override public List<E> subList(int start, int end) {
            return new UnmodifiableList<E>(list.subList(start, end));
        }

        /**
         * Resolves UnmodifiableList instances to UnmodifiableRandomAccessList
         * instances if the underlying list is a Random Access list.
         * <p>
         * This is necessary since UnmodifiableRandomAccessList instances are
         * replaced with UnmodifiableList instances during serialization for
         * compliance with JREs before 1.4.
         * <p>
         *
         * @return an UnmodifiableList instance if the underlying list
         *         implements RandomAccess interface, or this same object if
         *         not.
         *
         * @see UnmodifiableRandomAccessList#writeReplace()
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.439 -0500", hash_original_method = "5F3DDA40E6BDC67502A2E43BA75DBB15", hash_generated_method = "53E34E84D66C405D5242529334219C37")
        
private Object readResolve() {
            if (list instanceof RandomAccess) {
                return new UnmodifiableRandomAccessList<E>(list);
            }
            return this;
        }
    }
    
    private static class UnmodifiableMap<K, V> implements Map<K, V>, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.445 -0500", hash_original_field = "52857F37551780E390A700AB117559F7", hash_generated_field = "FFB33DF33FB47F4C6369B7156E5B3319")

        private static final long serialVersionUID = -1034234728574286014L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.448 -0500", hash_original_field = "B770F05C5A3A992B6F65D731F667A79E", hash_generated_field = "1785B4570966C73126874A8D942D2395")

        private  Map<K, V> m;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.521 -0500", hash_original_method = "74C4A0289A3E9196E4EF75F76384A7D2", hash_generated_method = "74C4A0289A3E9196E4EF75F76384A7D2")
        
UnmodifiableMap(Map<K, V> map) {
            m = map;
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.524 -0500", hash_original_method = "C5BE2B5F9D582C4EED1DC0880E8741A1", hash_generated_method = "B8BAFB0AC3CF0151A5DF3B0432CEC10B")
        
@Override public void clear() {
            throw new UnsupportedOperationException();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.526 -0500", hash_original_method = "A6C730848D8A626F99D8229EE744E3C0", hash_generated_method = "3B93E768C3A64ED5A0D81DD0991A7FAA")
        
@Override public boolean containsKey(Object key) {
            return m.containsKey(key);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.529 -0500", hash_original_method = "EF8C00CF950E8C186D2F05E1E556F384", hash_generated_method = "4FF44D21B40254D19BA7FCC5C728C5E0")
        
@Override public boolean containsValue(Object value) {
            return m.containsValue(value);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.531 -0500", hash_original_method = "FB0DE15DA25D3994421C9FBDD1812EDD", hash_generated_method = "32F4BDDF2F7C16B9E9FBFD58B725B886")
        
@Override public Set<Map.Entry<K, V>> entrySet() {
            return new UnmodifiableEntrySet<K, V>(m.entrySet());
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.534 -0500", hash_original_method = "CE201E78EAC5D1903F741160CB297EAE", hash_generated_method = "CA3D3ED71510E8BC24234D11F10F3E8F")
        
@Override public boolean equals(Object object) {
            return m.equals(object);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.537 -0500", hash_original_method = "B8FE254B61C57EC3A6DCE539976DA268", hash_generated_method = "AE77720B4866A0DA3BC89EC52150A652")
        
@Override public V get(Object key) {
            return m.get(key);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.540 -0500", hash_original_method = "E3229E3389F030DD50B79734943DB788", hash_generated_method = "5BE5D995D6BF8904D2EE4906967962E0")
        
@Override public int hashCode() {
            return m.hashCode();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.543 -0500", hash_original_method = "B9E63D3C52241E7E917CB1416ABA36E5", hash_generated_method = "55C2565032607AF5E2A50C6C3A008164")
        
@Override public boolean isEmpty() {
            return m.isEmpty();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.545 -0500", hash_original_method = "2CC049F262DAAA6660AF161E9C8606F6", hash_generated_method = "6DD14CE49CEFD5976B6CCD6607554AD1")
        
@Override public Set<K> keySet() {
            return new UnmodifiableSet<K>(m.keySet());
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.548 -0500", hash_original_method = "1AE25A34BEB4A8F08F41373ADFFCFE34", hash_generated_method = "CACCED04F0C96F2A5C570273E4025C0D")
        
@Override public V put(K key, V value) {
            throw new UnsupportedOperationException();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.551 -0500", hash_original_method = "1D605566C28BBD06FDC515389557B406", hash_generated_method = "464947B257D792A01CE7901EA2CAFDAA")
        
@Override public void putAll(Map<? extends K, ? extends V> map) {
            throw new UnsupportedOperationException();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.554 -0500", hash_original_method = "1F8D4C123F3DDBF68E61E38EDB13F5FB", hash_generated_method = "0928B31774D80B6EC2C66E34EBF5930B")
        
@Override public V remove(Object key) {
            throw new UnsupportedOperationException();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.557 -0500", hash_original_method = "A04EE09DEB6F21FAA6A7E10DF6401CD1", hash_generated_method = "D2F94241CB6C05F497616CA873009C43")
        
@Override public int size() {
            return m.size();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.560 -0500", hash_original_method = "19DD84E0D2EBBBC2FCDA12D023824450", hash_generated_method = "ED3EF9710E5BADCCAFACDE04CFDB6E33")
        
@Override public Collection<V> values() {
            return new UnmodifiableCollection<V>(m.values());
        }
        
        private static class UnmodifiableEntrySet<K, V> extends UnmodifiableSet<Map.Entry<K, V>> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.452 -0500", hash_original_field = "BEBACDBC0A0DF7B00CF983B3E8EBF15F", hash_generated_field = "12B2F4473571AB0F630FC68FA4B581F0")

            private static final long serialVersionUID = 7854390611657943733L;

            @DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.493 -0500", hash_original_method = "211DEE98878E4422E2F38E79CDC5F0D4", hash_generated_method = "211DEE98878E4422E2F38E79CDC5F0D4")
            
UnmodifiableEntrySet(Set<Map.Entry<K, V>> set) {
                super(set);
            }
            
            @DSComment("From safe class list")
            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.755 -0400", hash_original_method = "53A7F61EDA7A64FBCB28AE61A8906002", hash_generated_method = "67993FFD84C85C04B894A8095882D351")
            @Override
            public Iterator<Map.Entry<K, V>> iterator() {
Iterator<Map.Entry<K, V>> var95D309287220EAC9AA0261E09FAD4D41_1872266644 =                 new Iterator<Map.Entry<K, V>>() {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.497 -0500", hash_original_field = "5453FE1747389AC528B71FA32FDEB84E", hash_generated_field = "5453FE1747389AC528B71FA32FDEB84E")

                    Iterator<Map.Entry<K, V>> iterator = c.iterator();

                    @DSComment("From safe class list")
                @DSSafe(DSCat.SAFE_LIST)
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.500 -0500", hash_original_method = "AA3B17E619A4DDCE5FFF27C1294FF431", hash_generated_method = "2E759C80F5A3750B360B5CEB00C83331")
                    
@Override public boolean hasNext() {
                        return iterator.hasNext();
                    }

                    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.503 -0500", hash_original_method = "EEF2AC3DD179F17AE4AC144ABD5D488C", hash_generated_method = "65DB66ADC95262344EB384FF8E0E470B")
                    
@Override public Map.Entry<K, V> next() {
                        return new UnmodifiableMapEntry<K, V>(iterator.next());
                    }

                    @DSComment("From safe class list")
                @DSSafe(DSCat.SAFE_LIST)
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.506 -0500", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "2F468E7B2E16EC03C905C37F83253C97")
                    
@Override public void remove() {
                        throw new UnsupportedOperationException();
                    }
};
                var95D309287220EAC9AA0261E09FAD4D41_1872266644.addTaint(getTaint());
                return var95D309287220EAC9AA0261E09FAD4D41_1872266644;
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

            @DSComment("From safe class list")
            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.512 -0500", hash_original_method = "C353E5DD4879B90DAE1A37DDC4A8ED8C", hash_generated_method = "CF648A0FBD0DE5CC035D629420AF72AB")
            
@Override public Object[] toArray() {
                int length = c.size();
                Object[] result = new Object[length];
                Iterator<?> it = iterator();
                for (int i = length; --i >= 0;) {
                    result[i] = it.next();
                }
                return result;
            }
            
            private static class UnmodifiableMapEntry<K, V> implements Map.Entry<K, V> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.455 -0500", hash_original_field = "24589B068FBC99F8ED52DE988ED39319", hash_generated_field = "24589B068FBC99F8ED52DE988ED39319")

                Map.Entry<K, V> mapEntry;

                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.458 -0500", hash_original_method = "E37A4627FD27E632126EED134E00D831", hash_generated_method = "E37A4627FD27E632126EED134E00D831")
                
UnmodifiableMapEntry(Map.Entry<K, V> entry) {
                    mapEntry = entry;
                }

                @DSComment("From safe class list")
                @DSSafe(DSCat.SAFE_LIST)
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.472 -0500", hash_original_method = "90F914E663E54C2DC9846974DAA2EFB8", hash_generated_method = "9B7E9FD7FEB1A757322A845E47413CF5")
                
@Override public boolean equals(Object object) {
                    return mapEntry.equals(object);
                }

                @DSComment("From safe class list")
                @DSSafe(DSCat.SAFE_LIST)
                @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.475 -0500", hash_original_method = "4DDB57034C15C2636BC5A8AFB2B3C75A", hash_generated_method = "225457706CF0CB433F1F801AF96865CE")
                
@Override public K getKey() {
                    return mapEntry.getKey();
                }

                @DSComment("From safe class list")
                @DSSafe(DSCat.SAFE_OTHERS)
                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.478 -0500", hash_original_method = "EA1063FCD9D2F699A9610E0A7FDC81FD", hash_generated_method = "A0772F3488EAF611EED535B5C2598DB3")
                
@Override public V getValue() {
                    return mapEntry.getValue();
                }

                @DSComment("From safe class list")
                @DSSafe(DSCat.SAFE_LIST)
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.482 -0500", hash_original_method = "8A31FFFC42BCA6E359386EC1F8534D45", hash_generated_method = "496B3A5ADC7888CDF9EAF08D7F85E172")
                
@Override public int hashCode() {
                    return mapEntry.hashCode();
                }

                @DSComment("From safe class list")
                @DSSafe(DSCat.SAFE_LIST)
                @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.486 -0500", hash_original_method = "3526712C126765AF36CB8D920CBD3B1B", hash_generated_method = "1A70B5EC05C2DF7DBCDADBB5D8559CD6")
                
@Override public V setValue(V object) {
                    throw new UnsupportedOperationException();
                }

                @DSComment("From safe class list")
                @DSSafe(DSCat.SAFE_LIST)
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.488 -0500", hash_original_method = "514C7E8B8C54DBFDFB3E185BADD6AD0A", hash_generated_method = "03D48DDC45678E3360523D5DB551A244")
                
@Override public String toString() {
                    return mapEntry.toString();
                }
                
            }
                        
@DSComment("From safe class list")
            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.760 -0400", hash_original_method = "CB9686BEA448DC0D7D0077DDEB1917CB", hash_generated_method = "53ACFCB9D3998B322DC42B35FDCE552C")
            @SuppressWarnings("unchecked")
            @Override
            public <T> T[] toArray(T[] contents) {
                addTaint(contents[0].getTaint());
                int size = c.size();
                int index = 0;
                Iterator<Map.Entry<K, V>> it = iterator();
                if(size > contents.length)                
                {
                    Class<?> ct = contents.getClass().getComponentType();
                    contents = (T[]) Array.newInstance(ct, size);
                } //End block
                while
(index < size)                
                {
                    contents[index++] = (T) it.next();
                } //End block
                if(index < contents.length)                
                {
                    contents[index] = null;
                } //End block
T[] var5DC9C33EDB9F81CF1216538024B770BE_1421244130 =                 contents;
                var5DC9C33EDB9F81CF1216538024B770BE_1421244130.addTaint(getTaint());
                return var5DC9C33EDB9F81CF1216538024B770BE_1421244130;
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
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.562 -0500", hash_original_method = "5DD44B3CD2826BF39F974F66579CF74F", hash_generated_method = "3268D260E6A1A2E68B6C693C118395CC")
        
@Override public String toString() {
            return m.toString();
        }
    }
    
    private static class UnmodifiableSet<E> extends UnmodifiableCollection<E> implements Set<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.569 -0500", hash_original_field = "9520A6C57E7547F55E09D2FD317B435F", hash_generated_field = "E7C72ADB8696D042D902371BEB24646C")

        private static final long serialVersionUID = -9215047833775013803L;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.572 -0500", hash_original_method = "D46A71F25EF02541A08678630568218D", hash_generated_method = "D46A71F25EF02541A08678630568218D")
        
UnmodifiableSet(Set<E> set) {
            super(set);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.574 -0500", hash_original_method = "BB8664F3F5CB90AA83689CAADCD9EA6B", hash_generated_method = "72A83320DDAEAB8B4DE15CAF0F6E3055")
        
@Override public boolean equals(Object object) {
            return c.equals(object);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.577 -0500", hash_original_method = "E858D80F3EEDE9F2B52CDB7DA7FBF12B", hash_generated_method = "F8F3E42F127A914462CAAE7ED1E8BB32")
        
@Override public int hashCode() {
            return c.hashCode();
        }
    }
    
    private static class UnmodifiableSortedMap<K, V> extends UnmodifiableMap<K, V> implements SortedMap<K, V> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.583 -0500", hash_original_field = "A81AFFF7BEB365ACAB42D685468AC372", hash_generated_field = "74C1A54CA827DD7351FCAD121C86B500")

        private static final long serialVersionUID = -8806743815996713206L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.585 -0500", hash_original_field = "41E5EF207399B1082121011C1EB446FF", hash_generated_field = "F813233D7B24D3620137345516D05A23")

        private  SortedMap<K, V> sm;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.588 -0500", hash_original_method = "AC9FE01B421B1E54651959AD61521CA6", hash_generated_method = "AC9FE01B421B1E54651959AD61521CA6")
        
UnmodifiableSortedMap(SortedMap<K, V> map) {
            super(map);
            sm = map;
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.591 -0500", hash_original_method = "E5FDBCC6560BE7E99B2D2F850BD84149", hash_generated_method = "000D4A42069E78E62B5823AD0E3661B0")
        
@Override public Comparator<? super K> comparator() {
            return sm.comparator();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.593 -0500", hash_original_method = "B25E8C7440C76FBF812FF7AC9CA9D776", hash_generated_method = "661536959F07726359CED263D11FD225")
        
@Override public K firstKey() {
            return sm.firstKey();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.596 -0500", hash_original_method = "EC6243B190269A05D31802D1260652E4", hash_generated_method = "25ED372DC8A2BF66B2571EC4AE51B94A")
        
@Override public SortedMap<K, V> headMap(K before) {
            return new UnmodifiableSortedMap<K, V>(sm.headMap(before));
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.598 -0500", hash_original_method = "00E9126A84DE8B71214859A17DA6BD2E", hash_generated_method = "7935F5EBB8B85115D160546E1C167BCF")
        
@Override public K lastKey() {
            return sm.lastKey();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.602 -0500", hash_original_method = "B6411009D9179ABF4D7755605B648FDC", hash_generated_method = "39D8288C67CD595D34FF6669501D90F9")
        
@Override public SortedMap<K, V> subMap(K start, K end) {
            return new UnmodifiableSortedMap<K, V>(sm.subMap(start, end));
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.604 -0500", hash_original_method = "59BADF6C5EE68C4E1DB5A6A22818328A", hash_generated_method = "41FB81608541E4DFB3CCC3B0AB7029A8")
        
@Override public SortedMap<K, V> tailMap(K after) {
            return new UnmodifiableSortedMap<K, V>(sm.tailMap(after));
        }
    }
    
    private static class UnmodifiableSortedSet<E> extends UnmodifiableSet<E> implements SortedSet<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.610 -0500", hash_original_field = "7B1EEFDDEA1148AAB7542E75E17DDA29", hash_generated_field = "492EEA3FB02A9A00EAE2EF3419CB36AB")

        private static final long serialVersionUID = -4929149591599911165L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.612 -0500", hash_original_field = "3926F730B29F3CD5942BECEF18215BC4", hash_generated_field = "5220A6F2AA4CB98BB6C290F0BB717E86")

        private  SortedSet<E> ss;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.615 -0500", hash_original_method = "232C45C3B4117EB9042FB58E6C0CE113", hash_generated_method = "232C45C3B4117EB9042FB58E6C0CE113")
        
UnmodifiableSortedSet(SortedSet<E> set) {
            super(set);
            ss = set;
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.618 -0500", hash_original_method = "8514D9255D678B041F55D03BA11DCA3B", hash_generated_method = "7AE608335008C8F0AE22D2C4E87EC483")
        
@Override public Comparator<? super E> comparator() {
            return ss.comparator();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.620 -0500", hash_original_method = "6BB6C51843B41CC0DCB5509A79DBA008", hash_generated_method = "39E359A6FD46DB625C903A0B5CF6E58D")
        
@Override public E first() {
            return ss.first();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.623 -0500", hash_original_method = "74C4BE29898589F7D7948BADA3350612", hash_generated_method = "69BECEF49C709D5BABBA9CA8A01B796A")
        
@Override public SortedSet<E> headSet(E before) {
            return new UnmodifiableSortedSet<E>(ss.headSet(before));
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.626 -0500", hash_original_method = "AAC5DDE787ACA85752B94AAB77F6B0F8", hash_generated_method = "0D012D3DE517FECBD05E17E6247BD674")
        
@Override public E last() {
            return ss.last();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.629 -0500", hash_original_method = "54602835FD774439E48CB96CB67F9D83", hash_generated_method = "07775753E7DA6B979B2B7F24381F585E")
        
@Override public SortedSet<E> subSet(E start, E end) {
            return new UnmodifiableSortedSet<E>(ss.subSet(start, end));
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.632 -0500", hash_original_method = "37640609DAC9C9170FD6CBE14C8AD6B6", hash_generated_method = "4C940F60261F28A63DD1943A989D24C1")
        
@Override public SortedSet<E> tailSet(E after) {
            return new UnmodifiableSortedSet<E>(ss.tailSet(after));
        }
    }
    
    private static class SetFromMap<E> extends AbstractSet<E> implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.787 -0500", hash_original_field = "FBDB631736364FEA838AD2CA47185564", hash_generated_field = "D22893062D677334CA792903B3E2A0BD")

        private static final long serialVersionUID = 2454657854757543876L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.790 -0500", hash_original_field = "0B3E75A4C2A274E1A05297898A48E4F9", hash_generated_field = "8D1145F106DE5C3E2B790E661BC27C3B")

        private Map<E, Boolean> m;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.792 -0500", hash_original_field = "7527A39242482683EF2414335C5A6355", hash_generated_field = "75D49D8B030B2438C97CCFE06F0E4EF6")

        private transient Set<E> backingSet;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.795 -0500", hash_original_method = "6B962D990E5B5543C1AA025E18134CE9", hash_generated_method = "6B962D990E5B5543C1AA025E18134CE9")
        
SetFromMap(final Map<E, Boolean> map) {
            m = map;
            backingSet = map.keySet();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.798 -0500", hash_original_method = "B42E9CA75A778919E90B77D794DBEE82", hash_generated_method = "AAA6BBC43CB711CA3970EB9E5999330B")
        
@Override public boolean equals(Object object) {
            return backingSet.equals(object);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.800 -0500", hash_original_method = "684F9CE738B21B1B45F3304124963EF1", hash_generated_method = "A7A871101F3AA188EAD62AA6CD0FFA76")
        
@Override public int hashCode() {
            return backingSet.hashCode();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.803 -0500", hash_original_method = "FC84A6CABB16433CF1488E03DF7636C8", hash_generated_method = "8DDDA451C4CCCFEA8D0F2746F31A2BBB")
        
@Override public boolean add(E object) {
            return m.put(object, Boolean.TRUE) == null;
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.806 -0500", hash_original_method = "5163CA2ED3AD9C66F2BDAFB902590115", hash_generated_method = "9E8B4F567E2FFA7CDE9C7ABEE362D6DA")
        
@Override public void clear() {
            m.clear();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.809 -0500", hash_original_method = "C7069F73CC2FBE59B42FACF6A3731192", hash_generated_method = "64CB36E615E379991B59910E540A2036")
        
@Override public String toString() {
            return backingSet.toString();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.812 -0500", hash_original_method = "C1FDFEBBA860B6E21729D041F83BDE39", hash_generated_method = "791BAF19A63B299AAC6416EA0633EA1C")
        
@Override public boolean contains(Object object) {
            return backingSet.contains(object);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.815 -0500", hash_original_method = "652D3A93342A70291E00DB196A629050", hash_generated_method = "F40C67DEE4661A15C0D57098B736B823")
        
@Override public boolean containsAll(Collection<?> collection) {
            return backingSet.containsAll(collection);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.817 -0500", hash_original_method = "B9E63D3C52241E7E917CB1416ABA36E5", hash_generated_method = "55C2565032607AF5E2A50C6C3A008164")
        
@Override public boolean isEmpty() {
            return m.isEmpty();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.820 -0500", hash_original_method = "20C696E59013C16BDFED7021A5C3E797", hash_generated_method = "38EB2CD76D4A64E83AAF26E9D226BD59")
        
@Override public boolean remove(Object object) {
            return m.remove(object) != null;
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.822 -0500", hash_original_method = "4A27ACEA2C9F194EF4597E8BDECC6BD7", hash_generated_method = "643B5C0530CCA2ECA1A1A05A4866CD83")
        
@Override public boolean retainAll(Collection<?> collection) {
            return backingSet.retainAll(collection);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.826 -0500", hash_original_method = "706FD57EC242D189F78C8F40D764E8D0", hash_generated_method = "69B73516551D8C787DC6B096D26000AC")
        
@Override public Object[] toArray() {
            return backingSet.toArray();
        }
                
@DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.772 -0400", hash_original_method = "5B684176C593DE73F99AF08724DF65D4", hash_generated_method = "575476B84A4F565C006DCA5CC76F268A")
        @Override
        public <T> T[] toArray(T[] contents) {
            addTaint(contents[0].getTaint());
T[] var3546C28EE3387A2856CC723595918E17_779556003 =             backingSet.toArray(contents);
            var3546C28EE3387A2856CC723595918E17_779556003.addTaint(getTaint());
            return var3546C28EE3387A2856CC723595918E17_779556003;
            // ---------- Original Method ----------
            //return backingSet.toArray(contents);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.830 -0500", hash_original_method = "2EC39271104239DED882FB25EFF4BC23", hash_generated_method = "E9D547C10203718CD7B5678043FDBD0C")
        
@Override public Iterator<E> iterator() {
            return backingSet.iterator();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.833 -0500", hash_original_method = "A04EE09DEB6F21FAA6A7E10DF6401CD1", hash_generated_method = "D2F94241CB6C05F497616CA873009C43")
        
@Override public int size() {
            return m.size();
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.836 -0500", hash_original_method = "8082AE1FFA2825B9433C3082C2F87EDC", hash_generated_method = "6E867F0B8DA17FC4AC0FC0A3D58DD769")
        
@SuppressWarnings("unchecked")
        private void readObject(ObjectInputStream stream)
                throws IOException, ClassNotFoundException {
            stream.defaultReadObject();
            backingSet = m.keySet();
        }
    }
    
    private static class AsLIFOQueue<E> extends AbstractQueue<E> implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.841 -0500", hash_original_field = "EDA383040B740921D09D3B9F7CF5F5EA", hash_generated_field = "4687D2B0166F4A9C03E2417C41443082")

        private static final long serialVersionUID = 1802017725587941708L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.844 -0500", hash_original_field = "DFC38ACDA3A9A1B4C742C5C48FF801CC", hash_generated_field = "8E692B16EB19650DAECD0B8A91F62E63")

        private  Deque<E> q;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.847 -0500", hash_original_method = "C9A3AEFCC3A9FEA0CFED796FADB14DA4", hash_generated_method = "C9A3AEFCC3A9FEA0CFED796FADB14DA4")
        
AsLIFOQueue(final Deque<E> deque) {
            this.q = deque;
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.850 -0500", hash_original_method = "D6ABAC5AC9E31C28EFD449012F8C668D", hash_generated_method = "2908BDD29870ED1D05EAC8A72DA7A056")
        
@Override public Iterator<E> iterator() {
            return q.iterator();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.853 -0500", hash_original_method = "4D120CFD44D3EE91A03411EED1F5CA02", hash_generated_method = "18427EF2AA956566F64BC39878826B1C")
        
@Override public int size() {
            return q.size();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.855 -0500", hash_original_method = "A29AB2808D45581589F8B0269F283532", hash_generated_method = "E1D5924C1F464C71D98E0862091F1D39")
        
@Override public boolean offer(E o) {
            return q.offerFirst(o);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.858 -0500", hash_original_method = "286FFABBC697C1CEE6C49194F85DD481", hash_generated_method = "D04E5A0341153C34286117F3F5CD1330")
        
@Override public E peek() {
            return q.peekFirst();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.860 -0500", hash_original_method = "93EF986205EA0EFDB6E2F2BDD9DDBDB0", hash_generated_method = "A19DCFC3AF125F719B48AD448E8F9A48")
        
@Override public E poll() {
            return q.pollFirst();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.863 -0500", hash_original_method = "E16BCF0F708E6336497510D255228AB4", hash_generated_method = "A0A2C1B0BC971F121B28790A96A6981C")
        
@Override public boolean add(E o) {
            q.push(o);
            return true;
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.865 -0500", hash_original_method = "ECF3C7555AB121202E1C39938D734656", hash_generated_method = "05F253C2D5404952E7372E724092F4DA")
        
@Override public void clear() {
            q.clear();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.868 -0500", hash_original_method = "41C0874A8589B77FE1309E3303509F6A", hash_generated_method = "C10B9A1C0AC92C88A9B9725834FFEB5D")
        
@Override public E element() {
            return q.getFirst();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.871 -0500", hash_original_method = "DBCAD9866D0C084DC455BF7C95ABCE77", hash_generated_method = "3293165DEFB2DD7FDA89498C35E06F94")
        
@Override public E remove() {
            return q.pop();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.873 -0500", hash_original_method = "2E730D7ABEE184A9C34DA57DF7A457EE", hash_generated_method = "664C700D1ABEB59DE062335083A0EFFB")
        
@Override public boolean contains(Object object) {
            return q.contains(object);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.876 -0500", hash_original_method = "3E9E9A2983E74090844621EE9CF6D3D7", hash_generated_method = "8355EC3253ADBCB9F5AD73CCCC2E284E")
        
@Override public boolean containsAll(Collection<?> collection) {
            return q.containsAll(collection);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.880 -0500", hash_original_method = "3014069A2B40728BACBB472823CCCF21", hash_generated_method = "E40388C43D3DE5F58E5EFFB523CFCEE2")
        
@Override public boolean isEmpty() {
            return q.isEmpty();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.882 -0500", hash_original_method = "06C06D3351623BFF7BABDE8B40334F59", hash_generated_method = "78A9EB364B2886FA90AEF18D2CEE1EE6")
        
@Override public boolean remove(Object object) {
            return q.remove(object);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.885 -0500", hash_original_method = "13975D6542267AD488C8D9B27A0905D7", hash_generated_method = "784003BC793B5AF9312D55B083EEF0AF")
        
@Override public boolean removeAll(Collection<?> collection) {
            return q.removeAll(collection);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.887 -0500", hash_original_method = "029F8EE40CDE382EFA7F7BF13B8FE731", hash_generated_method = "BD3D7273A70B3631B06BEF8F0BDA7A08")
        
@Override public boolean retainAll(Collection<?> collection) {
            return q.retainAll(collection);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.890 -0500", hash_original_method = "81809EBBF1D8298961C4E9B761FEF748", hash_generated_method = "004A7FE1B801782DE7CB985A015C6360")
        
@Override public Object[] toArray() {
            return q.toArray();
        }
                
@DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.783 -0400", hash_original_method = "3C7918E789D95B2A97E0F45A2E8277E0", hash_generated_method = "A678998339B80EC4D9EC01B5E34F53F0")
        @Override
        public <T> T[] toArray(T[] contents) {
            addTaint(contents[0].getTaint());
T[] varB826DAACB71C6F73C56D75F228BB03F8_1296691217 =             q.toArray(contents);
            varB826DAACB71C6F73C56D75F228BB03F8_1296691217.addTaint(getTaint());
            return varB826DAACB71C6F73C56D75F228BB03F8_1296691217;
            // ---------- Original Method ----------
            //return q.toArray(contents);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.895 -0500", hash_original_method = "827F98847BB1D6CEA3B0A324A45F92ED", hash_generated_method = "6AA4BAB78787CE7B2A69F7225037D1F1")
        
@Override public String toString() {
            return q.toString();
        }
    }
    
    private static class CheckedCollection<E> implements Collection<E>, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.901 -0500", hash_original_field = "8AE56985A2FE4DD4E838EA62084318BB", hash_generated_field = "0D42B7BF026634D153E28C472B065A0D")

        private static final long serialVersionUID = 1578914078182001775L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.904 -0500", hash_original_field = "A3C80A7E02E49F20400373DFBAF9696A", hash_generated_field = "A3C80A7E02E49F20400373DFBAF9696A")

        Collection<E> c;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.906 -0500", hash_original_field = "D40602D541C2081B4D03EEADC8718DAD", hash_generated_field = "D40602D541C2081B4D03EEADC8718DAD")

        Class<E> type;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.909 -0500", hash_original_method = "4DAA5B7D63536360D367B6279A6FD0F0", hash_generated_method = "16003571DC95C58F4AE3258898131583")
        
public CheckedCollection(Collection<E> c, Class<E> type) {
            if (c == null || type == null) {
                throw new NullPointerException();
            }
            this.c = c;
            this.type = type;
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.911 -0500", hash_original_method = "AC97C28F724592ABA809E2470D95C119", hash_generated_method = "6E60024DDE6926D583CFC3C20F64A8CA")
        
@Override public int size() {
            return c.size();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.914 -0500", hash_original_method = "F9A3CB1FB7570D28EBE20660E2FC6F42", hash_generated_method = "23D90841DA823CEC89D1867FCC0D9D5D")
        
@Override public boolean isEmpty() {
            return c.isEmpty();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.917 -0500", hash_original_method = "AA502F510015E56A50E854673F52B13D", hash_generated_method = "7C5BA3AEB12A6117D0B2B0BC152B6FC6")
        
@Override public boolean contains(Object obj) {
            return c.contains(obj);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.920 -0500", hash_original_method = "A49A579D720F57F247BFFB420B912FC7", hash_generated_method = "E6427A61BF033359E5B96F2EBED756C8")
        
@Override public Iterator<E> iterator() {
            Iterator<E> i = c.iterator();
            if (i instanceof ListIterator) {
                i = new CheckedListIterator<E>((ListIterator<E>) i, type);
            }
            return i;
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.922 -0500", hash_original_method = "89D7D02A9D2BDF31E775C08108CBDE5B", hash_generated_method = "8BF4E8B38021950F5B0E5733096FB3FE")
        
@Override public Object[] toArray() {
            return c.toArray();
        }
                
@DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.788 -0400", hash_original_method = "9B8166862C116AE305DE64E80811892F", hash_generated_method = "52580AF03297B83D0E9C964EB937E251")
        @Override
        public <T> T[] toArray(T[] arr) {
            addTaint(arr[0].getTaint());
T[] varC7FA0C6E1955DD91DCB427C3A91A0EA7_810280548 =             c.toArray(arr);
            varC7FA0C6E1955DD91DCB427C3A91A0EA7_810280548.addTaint(getTaint());
            return varC7FA0C6E1955DD91DCB427C3A91A0EA7_810280548;
            // ---------- Original Method ----------
            //return c.toArray(arr);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.927 -0500", hash_original_method = "233202E3883C87159328A7DF45C5A0DD", hash_generated_method = "2370F6E8DBACF7B3A6BE9A78D1395445")
        
@Override public boolean add(E obj) {
            return c.add(checkType(obj, type));
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.930 -0500", hash_original_method = "A7C1CDA142B015DD1AAB47325584260A", hash_generated_method = "88F0D860E4E81DB3638467B71692E0FE")
        
@Override public boolean remove(Object obj) {
            return c.remove(obj);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.933 -0500", hash_original_method = "8A54483E259CA6D3C8AB1EBE7493D296", hash_generated_method = "B093D69C9E3C26D4A4DE9FE6BE8B372C")
        
@Override public boolean containsAll(Collection<?> c1) {
            return c.containsAll(c1);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.935 -0500", hash_original_method = "A2391F235E9474A0C2FADB6F2C5C2AB0", hash_generated_method = "850EDB13741EFBC0314EB0E159C533C3")
        
@SuppressWarnings("unchecked")
        @Override public boolean addAll(Collection<? extends E> c1) {
            Object[] array = c1.toArray();
            for (Object o : array) {
                checkType(o, type);
            }
            return c.addAll((List<E>) Arrays.asList(array));
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.938 -0500", hash_original_method = "E5A4F3F5A50F475A125F07680365C964", hash_generated_method = "ADFADA0E24B7EF5E1A5790FFD7F2BBB4")
        
@Override public boolean removeAll(Collection<?> c1) {
            return c.removeAll(c1);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.941 -0500", hash_original_method = "2CCBBE73D1665A80965D3FA8CB644A3B", hash_generated_method = "2857FC7C959BBE54BB4C29866B70C374")
        
@Override public boolean retainAll(Collection<?> c1) {
            return c.retainAll(c1);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.944 -0500", hash_original_method = "C75B179C04D460F62AB7F39D0D292067", hash_generated_method = "51596BB6B49B723A1BC434DC3A372C22")
        
@Override public void clear() {
            c.clear();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.947 -0500", hash_original_method = "424D4966F358AE6553349A6493C21674", hash_generated_method = "AF73726CA0BD4643C6282EFEB60006CA")
        
@Override public String toString() {
            return c.toString();
        }
    }
    
    private static class CheckedListIterator<E> implements ListIterator<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.952 -0500", hash_original_field = "672490E4668428437540D3382C6E62AF", hash_generated_field = "A3E111A0B732842F8B9E259D3903708E")

        private ListIterator<E> i;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.955 -0500", hash_original_field = "D40602D541C2081B4D03EEADC8718DAD", hash_generated_field = "44DD73C068DAE541C380477699D61FAF")

        private Class<E> type;

        /**
         * Constructs a dynamically typesafe view of the specified ListIterator.
         *
         * @param i -
         *            the listIterator for which a dynamically typesafe view to
         *            be constructed.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.957 -0500", hash_original_method = "0B7AAA10EE83BBF7A614BF8D8C7A7C84", hash_generated_method = "2DC0FEE32095D2D025A52D980AD843AC")
        
public CheckedListIterator(ListIterator<E> i, Class<E> type) {
            this.i = i;
            this.type = type;
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.961 -0500", hash_original_method = "59CA86A80410B66286C92523CF35EC7B", hash_generated_method = "82213A18EE2FEB4524B4369446BD59ED")
        
@Override public boolean hasNext() {
            return i.hasNext();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.963 -0500", hash_original_method = "A2FD0994E634C5BCE4D27AD9176E9A5A", hash_generated_method = "A7FF9DB1B62290274F341260B7DE01C2")
        
@Override public E next() {
            return i.next();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.966 -0500", hash_original_method = "048FA6C3E3A28865AD880AF8A3FCAE96", hash_generated_method = "F44347A90BEF2FFB451ACC6BE74B5789")
        
@Override public void remove() {
            i.remove();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.969 -0500", hash_original_method = "BBFFF3658F03DC70BAED5B88BBE801F9", hash_generated_method = "310027476E79C115DCFBFFB0AFABAB5F")
        
@Override public boolean hasPrevious() {
            return i.hasPrevious();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.971 -0500", hash_original_method = "BC73D9B40C1A828CB3DD11A00CF4E28D", hash_generated_method = "7704325A928E02F3EBDCB3C53CA11CE2")
        
@Override public E previous() {
            return i.previous();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.974 -0500", hash_original_method = "E41D02CE1A7D09C2351DC91043CD0C1F", hash_generated_method = "C92AA873E14EE0221D06FD9664B434A9")
        
@Override public int nextIndex() {
            return i.nextIndex();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.977 -0500", hash_original_method = "F0908B37AEEE31348E4E446BDB2DC11E", hash_generated_method = "5B7EAABA3425870EACC2D93C87C5F3CF")
        
@Override public int previousIndex() {
            return i.previousIndex();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.979 -0500", hash_original_method = "F06067E5C50A33BA33028ACBB7E94E5C", hash_generated_method = "43CADCC7D4B2D49DCBA57BFB83FA1235")
        
@Override public void set(E obj) {
            i.set(checkType(obj, type));
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.982 -0500", hash_original_method = "3A7C6206CDBE5C448C8E83D10145E877", hash_generated_method = "89C2BD2816062A5221FA735CF7F54CB9")
        
@Override public void add(E obj) {
            i.add(checkType(obj, type));
        }
        
    }
    
    private static class CheckedList<E> extends CheckedCollection<E> implements List<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.988 -0500", hash_original_field = "313AB5A2444D643D3A7E273BC101E993", hash_generated_field = "872FF792DF349B762724C98686FE9FD7")

        private static final long serialVersionUID = 65247728283967356L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.990 -0500", hash_original_field = "BA44D98E464F3917B2E777BB565BC0D3", hash_generated_field = "BA44D98E464F3917B2E777BB565BC0D3")

        List<E> l;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.993 -0500", hash_original_method = "50AAAF0EF026911FE0274184FEF9C1C3", hash_generated_method = "5B743ADB0DB927FEDDE9C9BB74620E2D")
        
public CheckedList(List<E> l, Class<E> type) {
            super(l, type);
            this.l = l;
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.996 -0500", hash_original_method = "8A1A291116E92C540879607029C861C6", hash_generated_method = "8161B6983EDFF45C9CC25802C8133782")
        
@SuppressWarnings("unchecked")
        @Override public boolean addAll(int index, Collection<? extends E> c1) {
            Object[] array = c1.toArray();
            for (Object o : array) {
                checkType(o, type);
            }
            return l.addAll(index, (List<E>) Arrays.asList(array));
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.999 -0500", hash_original_method = "12BB9FAB0B921E0E98205977740A217D", hash_generated_method = "0020BDB86965DE10A3879CEF40A14187")
        
@Override public E get(int index) {
            return l.get(index);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.002 -0500", hash_original_method = "B15A1B3ABEAB19644273A7FDAFDFF4C3", hash_generated_method = "1D3F1C6A064289EB39E10C16A4F32349")
        
@Override public E set(int index, E obj) {
            return l.set(index, checkType(obj, type));
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.005 -0500", hash_original_method = "97AC3A6F1A8F1F91D88637C439308CAA", hash_generated_method = "9A851CBD9F88D730E516ACB5343F2C4A")
        
@Override public void add(int index, E obj) {
            l.add(index, checkType(obj, type));
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.007 -0500", hash_original_method = "B7A754E9641B79EF3AC643C6FA162631", hash_generated_method = "B1A36A1C0FA0AFF26FA5197824CC0F3D")
        
@Override public E remove(int index) {
            return l.remove(index);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.010 -0500", hash_original_method = "EB95E25E6439350950712FBE2C177EC4", hash_generated_method = "0F0720F586C780C8B01C11259616DAFD")
        
@Override public int indexOf(Object obj) {
            return l.indexOf(obj);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.012 -0500", hash_original_method = "4C828EC3A9818E335BF8E9F8513B24F5", hash_generated_method = "37A8BE6864E113408BD2CFE11A86B9A9")
        
@Override public int lastIndexOf(Object obj) {
            return l.lastIndexOf(obj);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.015 -0500", hash_original_method = "9293980ECFF31B033CDADFB0ED26EA69", hash_generated_method = "4A5499CA4D15173C14F1C2D68462CBC5")
        
@Override public ListIterator<E> listIterator() {
            return new CheckedListIterator<E>(l.listIterator(), type);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.018 -0500", hash_original_method = "31D39D7FEEE82D7A15D00B805CB5EAA4", hash_generated_method = "B9C4940ACB7EDE95031A9B40B25D7ED9")
        
@Override public ListIterator<E> listIterator(int index) {
            return new CheckedListIterator<E>(l.listIterator(index), type);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.021 -0500", hash_original_method = "A5E1EFD4B2650099AC132BF86B97D88F", hash_generated_method = "665259FE6EA85ADE791B51503509D329")
        
@Override public List<E> subList(int fromIndex, int toIndex) {
            return checkedList(l.subList(fromIndex, toIndex), type);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.023 -0500", hash_original_method = "A14AE2E014BAD465F594EE49A5008ED4", hash_generated_method = "A67EAE4C0AF5F82468922719D8F7F67F")
        
@Override public boolean equals(Object obj) {
            return l.equals(obj);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.027 -0500", hash_original_method = "410D1D1B2E05F678DF3AB7D6BB08AEDB", hash_generated_method = "1D41B3828D5FEBE13AAEDC042DED3AC3")
        
@Override public int hashCode() {
            return l.hashCode();
        }
    }
    
    private static class CheckedRandomAccessList<E> extends CheckedList<E> implements RandomAccess {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.032 -0500", hash_original_field = "9930E78DEF386A88163DD68F9F319CF6", hash_generated_field = "AE05DA4DC0253A1B88798E9C56DCC885")

        private static final long serialVersionUID = 1638200125423088369L;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.035 -0500", hash_original_method = "77F175BCE2CEB5DECA5010A8855616A0", hash_generated_method = "B5BA00DDB8C98D0559EAC70FC647AF24")
        
public CheckedRandomAccessList(List<E> l, Class<E> type) {
            super(l, type);
        }
    }
    
    private static class CheckedSet<E> extends CheckedCollection<E> implements Set<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.040 -0500", hash_original_field = "8703A4A980C996D962366DD8FD48BC61", hash_generated_field = "E1E04526085CC70B98A324ECDFB31198")

        private static final long serialVersionUID = 4694047833775013803L;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.043 -0500", hash_original_method = "515963C9B1280D5707D3A720329B0AC0", hash_generated_method = "051963CE7D0FCE360D0B456EAB8CF2BE")
        
public CheckedSet(Set<E> s, Class<E> type) {
            super(s, type);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.046 -0500", hash_original_method = "F33AC6E694EC5A5F3A81FF749707DDFC", hash_generated_method = "4D4CD48160733433ABD58E788DC7AB59")
        
@Override public boolean equals(Object obj) {
            return c.equals(obj);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.048 -0500", hash_original_method = "E858D80F3EEDE9F2B52CDB7DA7FBF12B", hash_generated_method = "F8F3E42F127A914462CAAE7ED1E8BB32")
        
@Override public int hashCode() {
            return c.hashCode();
        }
    }
    
    private static class CheckedMap<K, V> implements Map<K, V>, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.054 -0500", hash_original_field = "863D41F428ECFBC5F882B95259992FE2", hash_generated_field = "9F44A98BA336AC9320984E43122649C3")

        private static final long serialVersionUID = 5742860141034234728L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.056 -0500", hash_original_field = "B770F05C5A3A992B6F65D731F667A79E", hash_generated_field = "B770F05C5A3A992B6F65D731F667A79E")

        Map<K, V> m;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.059 -0500", hash_original_field = "F010784A251FB129AC47F47773283FBF", hash_generated_field = "F010784A251FB129AC47F47773283FBF")

        Class<K> keyType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.061 -0500", hash_original_field = "DE39CA4821E18DB5E7A7F09BBC028CB4", hash_generated_field = "DE39CA4821E18DB5E7A7F09BBC028CB4")

        Class<V> valueType;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.064 -0500", hash_original_method = "906A4960963B0F972E50BE617CA562B3", hash_generated_method = "51CE9295353C81BC3F8FBD09458D350E")
        
private CheckedMap(Map<K, V> m, Class<K> keyType, Class<V> valueType) {
            if (m == null || keyType == null || valueType == null) {
                throw new NullPointerException();
            }
            this.m = m;
            this.keyType = keyType;
            this.valueType = valueType;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.067 -0500", hash_original_method = "A04EE09DEB6F21FAA6A7E10DF6401CD1", hash_generated_method = "D2F94241CB6C05F497616CA873009C43")
        
@Override public int size() {
            return m.size();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.070 -0500", hash_original_method = "B9E63D3C52241E7E917CB1416ABA36E5", hash_generated_method = "55C2565032607AF5E2A50C6C3A008164")
        
@Override public boolean isEmpty() {
            return m.isEmpty();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.072 -0500", hash_original_method = "A6C730848D8A626F99D8229EE744E3C0", hash_generated_method = "3B93E768C3A64ED5A0D81DD0991A7FAA")
        
@Override public boolean containsKey(Object key) {
            return m.containsKey(key);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.074 -0500", hash_original_method = "EF8C00CF950E8C186D2F05E1E556F384", hash_generated_method = "4FF44D21B40254D19BA7FCC5C728C5E0")
        
@Override public boolean containsValue(Object value) {
            return m.containsValue(value);
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.077 -0500", hash_original_method = "B8FE254B61C57EC3A6DCE539976DA268", hash_generated_method = "AE77720B4866A0DA3BC89EC52150A652")
        
@Override public V get(Object key) {
            return m.get(key);
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.080 -0500", hash_original_method = "98010DFF1DD51631676FCAC604C1B694", hash_generated_method = "3041DFD14364761680A5739E13C9123D")
        
@Override public V put(K key, V value) {
            return m.put(checkType(key, keyType), checkType(value, valueType));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.083 -0500", hash_original_method = "7E1C4ABAB7F4D30C9FA02B8AC4206202", hash_generated_method = "50ABF04DB3B9C8B520FB74FB6BEE48F5")
        
@Override public V remove(Object key) {
            return m.remove(key);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.086 -0500", hash_original_method = "7B09FD67E4091CD76439ADACD213D3A2", hash_generated_method = "1658BAA27FD8989F23604D0B5C1DA023")
        
@SuppressWarnings("unchecked")
        @Override public void putAll(Map<? extends K, ? extends V> map) {
            int size = map.size();
            if (size == 0) {
                return;
            }
            Map.Entry<? extends K, ? extends V>[] entries = new Map.Entry[size];
            Iterator<? extends Map.Entry<? extends K, ? extends V>> it = map
                    .entrySet().iterator();
            for (int i = 0; i < size; i++) {
                Map.Entry<? extends K, ? extends V> e = it.next();
                checkType(e.getKey(), keyType);
                checkType(e.getValue(), valueType);
                entries[i] = e;
            }
            for (int i = 0; i < size; i++) {
                m.put(entries[i].getKey(), entries[i].getValue());
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.089 -0500", hash_original_method = "5163CA2ED3AD9C66F2BDAFB902590115", hash_generated_method = "9E8B4F567E2FFA7CDE9C7ABEE362D6DA")
        
@Override public void clear() {
            m.clear();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.092 -0500", hash_original_method = "BC85ABF91A39D98F3F2ED0838950D9FC", hash_generated_method = "BBC43EE385BF039697A8C3D454EBF451")
        
@Override public Set<K> keySet() {
            return m.keySet();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.094 -0500", hash_original_method = "F6584059741E2818D171714370ED56BF", hash_generated_method = "D7E344EF41BF2EB522CC93B13755AB57")
        
@Override public Collection<V> values() {
            return m.values();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.097 -0500", hash_original_method = "17C87BFAA3247941C0F3FE3FCE6C8B6B", hash_generated_method = "C8BF332515D2A270C240E313007E3E6D")
        
@Override public Set<Map.Entry<K, V>> entrySet() {
            return new CheckedEntrySet<K, V>(m.entrySet(), valueType);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.100 -0500", hash_original_method = "5F45CB6F19E1E41DEEA3711399B994B8", hash_generated_method = "586B6A1499275958329804B6AAD43EF2")
        
@Override public boolean equals(Object obj) {
            return m.equals(obj);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.103 -0500", hash_original_method = "E3229E3389F030DD50B79734943DB788", hash_generated_method = "5BE5D995D6BF8904D2EE4906967962E0")
        
@Override public int hashCode() {
            return m.hashCode();
        }
        
        private static class CheckedEntry<K, V> implements Map.Entry<K, V> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.109 -0500", hash_original_field = "FD10A3858A638ACB828326F81BE2C88B", hash_generated_field = "FD10A3858A638ACB828326F81BE2C88B")

            Map.Entry<K, V> e;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.112 -0500", hash_original_field = "DE39CA4821E18DB5E7A7F09BBC028CB4", hash_generated_field = "DE39CA4821E18DB5E7A7F09BBC028CB4")

            Class<V> valueType;

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.115 -0500", hash_original_method = "7A5E92C112A4AAE1EEB574291E4B57B6", hash_generated_method = "F01408B0964A640DEA1F1FD14343143E")
            
public CheckedEntry(Map.Entry<K, V> e, Class<V> valueType) {
                if (e == null) {
                    throw new NullPointerException();
                }
                this.e = e;
                this.valueType = valueType;
            }

            @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.117 -0500", hash_original_method = "10D87C621F2656D3DA7DCE234A4C3FAC", hash_generated_method = "8702435EE7714DABAA0C679E20A72854")
            
@Override public K getKey() {
                return e.getKey();
            }

            @DSSafe(DSCat.SAFE_OTHERS)
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.120 -0500", hash_original_method = "8EF21B2292AA31AAE181B3282F3F0262", hash_generated_method = "237F2C01626B61F21501FB012D289ABA")
            
@Override public V getValue() {
                return e.getValue();
            }

            @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.123 -0500", hash_original_method = "22C63BC622BE9DF4D2BED624BDB5B6B5", hash_generated_method = "12D804BAA825C981C93D02C83F7B5DE8")
            
@Override public V setValue(V obj) {
                return e.setValue(checkType(obj, valueType));
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.126 -0500", hash_original_method = "0FE63D6CB37B8BF21266876509A7EAAA", hash_generated_method = "9A0E75B58537A9214DC2974ACE5E8BBE")
            
@Override public boolean equals(Object obj) {
                return e.equals(obj);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.129 -0500", hash_original_method = "02C3AF7FB3CFA22B693B83D22D208AF4", hash_generated_method = "ADF0BAA843DB5068394736D4B412A63E")
            
@Override public int hashCode() {
                return e.hashCode();
            }
            
        }
        
        private static class CheckedEntrySet<K, V> implements Set<Map.Entry<K, V>> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.134 -0500", hash_original_field = "00162E30A8FD9ACC3B5664D702737B9D", hash_generated_field = "00162E30A8FD9ACC3B5664D702737B9D")

            Set<Map.Entry<K, V>> s;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.137 -0500", hash_original_field = "DE39CA4821E18DB5E7A7F09BBC028CB4", hash_generated_field = "DE39CA4821E18DB5E7A7F09BBC028CB4")

            Class<V> valueType;

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.140 -0500", hash_original_method = "77FA7326B6BB5621E7FE63699FC58F08", hash_generated_method = "B866A462411DBE2FA94194FA05421B34")
            
public CheckedEntrySet(Set<Map.Entry<K, V>> s, Class<V> valueType) {
                this.s = s;
                this.valueType = valueType;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.143 -0500", hash_original_method = "448F3F9279BA75C161BF1A7F97E105A4", hash_generated_method = "7F8729926A2ABE1F42C7325BB8B29FFE")
            
@Override public Iterator<Map.Entry<K, V>> iterator() {
                return new CheckedEntryIterator<K, V>(s.iterator(), valueType);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.146 -0500", hash_original_method = "0FB4B292E50A952F877CB518E0A96CF9", hash_generated_method = "E6F7C314E079A996E508CFEE995C7545")
            
@Override public Object[] toArray() {
                int thisSize = size();
                Object[] array = new Object[thisSize];
                Iterator<?> it = iterator();
                for (int i = 0; i < thisSize; i++) {
                    array[i] = it.next();
                }
                return array;
            }
                        
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.809 -0400", hash_original_method = "C1CA1F6CAFA571422DF3592838D87C35", hash_generated_method = "38B8F3E790B72CD3320F33B7173F6282")
            @SuppressWarnings("unchecked")
            @Override
            public <T> T[] toArray(T[] array) {
                addTaint(array[0].getTaint());
                int thisSize = size();
                if(array.length < thisSize)                
                {
                    Class<?> ct = array.getClass().getComponentType();
                    array = (T[]) Array.newInstance(ct, thisSize);
                } //End block
                Iterator<?> it = iterator();
for(int i = 0;i < thisSize;i++)
                {
                    array[i] = (T) it.next();
                } //End block
                if(thisSize < array.length)                
                {
                    array[thisSize] = null;
                } //End block
T[] var1270D5B74B756F17D644A15D775499D9_2051754257 =                 array;
                var1270D5B74B756F17D644A15D775499D9_2051754257.addTaint(getTaint());
                return var1270D5B74B756F17D644A15D775499D9_2051754257;
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

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.151 -0500", hash_original_method = "C32F0C36534158E273107417143214BD", hash_generated_method = "F024F38C510D709739F000524BA92626")
            
@Override public boolean retainAll(Collection<?> c) {
                return s.retainAll(c);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.154 -0500", hash_original_method = "B2624C46EA911C8D7CBCD3DB1975A601", hash_generated_method = "BF73FF5DE3F2961064ABB957264B1B87")
            
@Override public boolean removeAll(Collection<?> c) {
                return s.removeAll(c);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.157 -0500", hash_original_method = "D8F4D306F45D40205BDE17116DDFF9FA", hash_generated_method = "97F633FCF4F2C493D76122DB4A3D8D2F")
            
@Override public boolean containsAll(Collection<?> c) {
                return s.containsAll(c);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.160 -0500", hash_original_method = "0D1A7F281A8819D32245C163B79E338D", hash_generated_method = "0CFC992AFFE34F50F1190A1FBD90F1E6")
            
@Override public boolean addAll(Collection<? extends Map.Entry<K, V>> c) {
                throw new UnsupportedOperationException();
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.163 -0500", hash_original_method = "46F35AD7CAD80E45E374449F130E7D0D", hash_generated_method = "27C8B33A4C31BEED55B710CF0DE62760")
            
@Override public boolean remove(Object o) {
                return s.remove(o);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.166 -0500", hash_original_method = "A91421BB58ED7F6569B24AAD1B5804AB", hash_generated_method = "5BA3CB7C2D6CFB51FBAED8E48E10B4C8")
            
@Override public boolean contains(Object o) {
                return s.contains(o);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.168 -0500", hash_original_method = "8704A9C8AC3AA02909B00E4E211C4D3E", hash_generated_method = "042E6CCFDC02E8C4B9412565833D805F")
            
@Override public boolean add(Map.Entry<K, V> o) {
                throw new UnsupportedOperationException();
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.172 -0500", hash_original_method = "1DB64DC7E3E98DAB777752CA6247DAE5", hash_generated_method = "9F132568E576FE2186C92C0843CC9747")
            
@Override public boolean isEmpty() {
                return s.isEmpty();
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.175 -0500", hash_original_method = "3294D1F2516BD356F42ED84BE178EFCB", hash_generated_method = "07801EF9BEB82B5F0B6E413AB3671AAE")
            
@Override public void clear() {
                s.clear();
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.178 -0500", hash_original_method = "61480F19A13469EF561F92E5A3700C23", hash_generated_method = "DDC8D2778A725C86C8A16A547D3D3B02")
            
@Override public int size() {
                return s.size();
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.181 -0500", hash_original_method = "150ADDC982A3B6D8A573E663C38A7C9E", hash_generated_method = "8148B4B7C0F9BC059927AABBFE303A51")
            
@Override public int hashCode() {
                return s.hashCode();
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.184 -0500", hash_original_method = "2565EBD5FCFC00F10C086CB36B3EEE8C", hash_generated_method = "867B240E208B675F34BAEF0363D7D6C3")
            
@Override public boolean equals(Object object) {
                return s.equals(object);
            }
            
            private static class CheckedEntryIterator<K, V> implements Iterator<Map.Entry<K, V>> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.187 -0500", hash_original_field = "0B0E1D6BACD1F756FB2A478A3878B968", hash_generated_field = "0B0E1D6BACD1F756FB2A478A3878B968")

                Iterator<Map.Entry<K, V>> i;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.190 -0500", hash_original_field = "DE39CA4821E18DB5E7A7F09BBC028CB4", hash_generated_field = "DE39CA4821E18DB5E7A7F09BBC028CB4")

                Class<V> valueType;

                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.193 -0500", hash_original_method = "3CE5E36A95DFE16D33C2CC4176CB7EE4", hash_generated_method = "FF8CA63DBB2D03153E01C25BB437D446")
                
public CheckedEntryIterator(Iterator<Map.Entry<K, V>> i,
                        Class<V> valueType) {
                    this.i = i;
                    this.valueType = valueType;
                }

                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.196 -0500", hash_original_method = "59CA86A80410B66286C92523CF35EC7B", hash_generated_method = "82213A18EE2FEB4524B4369446BD59ED")
                
@Override public boolean hasNext() {
                    return i.hasNext();
                }

                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.199 -0500", hash_original_method = "048FA6C3E3A28865AD880AF8A3FCAE96", hash_generated_method = "F44347A90BEF2FFB451ACC6BE74B5789")
                
@Override public void remove() {
                    i.remove();
                }

                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.202 -0500", hash_original_method = "4D16E0BB01C90351B8312D1A4B7DB5F2", hash_generated_method = "145EAC9B4DF96BF0FB4455F1399D27BE")
                
@Override public Map.Entry<K, V> next() {
                    return new CheckedEntry<K, V>(i.next(), valueType);
                }
                
            }
            
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.106 -0500", hash_original_method = "5DD44B3CD2826BF39F974F66579CF74F", hash_generated_method = "3268D260E6A1A2E68B6C693C118395CC")
        
@Override public String toString() {
            return m.toString();
        }
    }
    
    private static class CheckedSortedSet<E> extends CheckedSet<E> implements SortedSet<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.213 -0500", hash_original_field = "D080F7333B1CEFF6B181130B80D12E2B", hash_generated_field = "EFEBE119B7009CBFA7ED7A5DC59F8042")

        private static final long serialVersionUID = 1599911165492914959L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.217 -0500", hash_original_field = "3926F730B29F3CD5942BECEF18215BC4", hash_generated_field = "5220A6F2AA4CB98BB6C290F0BB717E86")

        private SortedSet<E> ss;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.220 -0500", hash_original_method = "70499BD9B05065D265D741875DD058CA", hash_generated_method = "63347AE67F9893C432C87E2902692594")
        
public CheckedSortedSet(SortedSet<E> s, Class<E> type) {
            super(s, type);
            this.ss = s;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.223 -0500", hash_original_method = "8514D9255D678B041F55D03BA11DCA3B", hash_generated_method = "7AE608335008C8F0AE22D2C4E87EC483")
        
@Override public Comparator<? super E> comparator() {
            return ss.comparator();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.225 -0500", hash_original_method = "82539AB1166DFBB28D0E3DC3D0A43121", hash_generated_method = "88772ED78B42DC2704716B1FDDC31CAB")
        
@Override public SortedSet<E> subSet(E fromElement, E toElement) {
            return new CheckedSortedSet<E>(ss.subSet(fromElement, toElement),
                    type);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.228 -0500", hash_original_method = "68D546866615C37E07B8E968E3813E84", hash_generated_method = "BAA4CA5391B8D36810397B0B53E1F75B")
        
@Override public SortedSet<E> headSet(E toElement) {
            return new CheckedSortedSet<E>(ss.headSet(toElement), type);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.231 -0500", hash_original_method = "B0B4B667BF95B9D9A3CD3F7FE8BEFA1B", hash_generated_method = "2C0D1A5CD674299C31BDD9F209F83805")
        
@Override public SortedSet<E> tailSet(E fromElement) {
            return new CheckedSortedSet<E>(ss.tailSet(fromElement), type);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.234 -0500", hash_original_method = "6BB6C51843B41CC0DCB5509A79DBA008", hash_generated_method = "39E359A6FD46DB625C903A0B5CF6E58D")
        
@Override public E first() {
            return ss.first();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.237 -0500", hash_original_method = "AAC5DDE787ACA85752B94AAB77F6B0F8", hash_generated_method = "0D012D3DE517FECBD05E17E6247BD674")
        
@Override public E last() {
            return ss.last();
        }
    }
    
    private static class CheckedSortedMap<K, V> extends CheckedMap<K, V> implements SortedMap<K, V> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.242 -0500", hash_original_field = "13814B80F8B9799968E3142D7456834C", hash_generated_field = "48CAB95B26D6FD20C5A6CF4DE2F667C3")

        private static final long serialVersionUID = 1599671320688067438L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.244 -0500", hash_original_field = "41E5EF207399B1082121011C1EB446FF", hash_generated_field = "41E5EF207399B1082121011C1EB446FF")

        SortedMap<K, V> sm;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.247 -0500", hash_original_method = "2CB6EA0E6447E5AAF8B28B5FDF140BE4", hash_generated_method = "2CB6EA0E6447E5AAF8B28B5FDF140BE4")
        
CheckedSortedMap(SortedMap<K, V> m, Class<K> keyType, Class<V> valueType) {
            super(m, keyType, valueType);
            this.sm = m;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.250 -0500", hash_original_method = "E5FDBCC6560BE7E99B2D2F850BD84149", hash_generated_method = "000D4A42069E78E62B5823AD0E3661B0")
        
@Override public Comparator<? super K> comparator() {
            return sm.comparator();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.252 -0500", hash_original_method = "65DE11E398BB209CD2689071C041161A", hash_generated_method = "EB77A757D8766D8F2E756EAC2C8D7A1F")
        
@Override public SortedMap<K, V> subMap(K fromKey, K toKey) {
            return new CheckedSortedMap<K, V>(sm.subMap(fromKey, toKey), keyType, valueType);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.255 -0500", hash_original_method = "2C5724B582D2FAB5716323DB894A671D", hash_generated_method = "B88DC75C9573AB388CF4523BF761B76C")
        
@Override public SortedMap<K, V> headMap(K toKey) {
            return new CheckedSortedMap<K, V>(sm.headMap(toKey), keyType, valueType);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.258 -0500", hash_original_method = "2879524DD09B17D2FCB7AD1626D24618", hash_generated_method = "F755BE6426F6F75947E0F3F3EF709DDC")
        
@Override public SortedMap<K, V> tailMap(K fromKey) {
            return new CheckedSortedMap<K, V>(sm.tailMap(fromKey), keyType, valueType);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.261 -0500", hash_original_method = "B25E8C7440C76FBF812FF7AC9CA9D776", hash_generated_method = "661536959F07726359CED263D11FD225")
        
@Override public K firstKey() {
            return sm.firstKey();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:51.263 -0500", hash_original_method = "00E9126A84DE8B71214859A17DA6BD2E", hash_generated_method = "7935F5EBB8B85115D160546E1C167BCF")
        
@Override public K lastKey() {
            return sm.lastKey();
        }
    }
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.459 -0400", hash_original_field = "BF19162ABA3425F946F5D9B6685AC2EC", hash_generated_field = "66C8EDF172F44B1C185312659E6B7E7F")

    private static final Enumeration<?> EMPTY_ENUMERATION = new Enumeration<Object>() {
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.458 -0400", hash_original_method = "50CD0E92886EDA5BEE0164B092B351EC", hash_generated_method = "5846EE9EB8DDDDC0896316CB4D84FA05")
        @Override
        public boolean hasMoreElements() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_923760985 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_923760985;
            
        }
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.459 -0400", hash_original_method = "82381D9C34AF9F2E88B673FB4A4E6DDE", hash_generated_method = "C451DB608AE3B7FAE82365C2FA63C59D")
        @Override
        public Object nextElement() {
        	throw new NoSuchElementException();
            
        }
        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.868 -0500", hash_original_field = "434E68EAB96E5E748F17F10B3723066B", hash_generated_field = "1967470EF0F42FDB7D6E965615F956D6")

    @SuppressWarnings("unchecked")
    public static final List EMPTY_LIST = new EmptyList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.871 -0500", hash_original_field = "78F0BDDB8D0CE7DB4B7B209477384AAA", hash_generated_field = "EF8031119D3626285E32D155A57C6695")

    @SuppressWarnings("unchecked")
    public static final Set EMPTY_SET = new EmptySet();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:49.873 -0500", hash_original_field = "007AC76C5C6E88555E2AE9A0B70A4E82", hash_generated_field = "F465655F33C72E2E2F297BFA1010664E")

    @SuppressWarnings("unchecked")
    public static final Map EMPTY_MAP = new EmptyMap();

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:50.636 -0500", hash_original_method = "0C1BC548FC19EEB6A684F12763720939", hash_generated_method = "43576B53454C0335BBC9B6E3431A6E67")
    
private Collections() {}
}

