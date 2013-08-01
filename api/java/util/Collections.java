package java.util;

// Droidsafe Imports
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Array;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class Collections {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.629 -0400", hash_original_method = "0C1BC548FC19EEB6A684F12763720939", hash_generated_method = "F5EC8594995493427AAF50F2EB8C349F")
    private  Collections() {
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static <T> void fill(List<? super T> list, T object) {
        ListIterator<? super T> it = list.listIterator();
        while (it.hasNext()) {
            it.next();
            it.set(object);
        }
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    public static <T> Comparator<T> reverseOrder() {
        return (Comparator) ReverseComparator.INSTANCE;
    }

    
    @DSModeled(DSC.SAFE)
    public static <T> Comparator<T> reverseOrder(Comparator<T> c) {
        if (c == null) {
            return reverseOrder();
        }
        if (c instanceof ReverseComparator2) {
            return ((ReverseComparator2<T>) c).cmp;
        }
        return new ReverseComparator2<T>(c);
    }

    
    @DSModeled(DSC.SAFE)
    public static void shuffle(List<?> list) {
        shuffle(list, new Random());
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static <E> Set<E> singleton(E object) {
        return new SingletonSet<E>(object);
    }

    
    @DSModeled(DSC.SAFE)
    public static <E> List<E> singletonList(E object) {
        return new SingletonList<E>(object);
    }

    
    @DSModeled(DSC.SAFE)
    public static <K, V> Map<K, V> singletonMap(K key, V value) {
        return new SingletonMap<K, V>(key, value);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static <T> boolean replaceAll(List<T> list, T obj, T obj2) {
        int index;
        boolean found = false;
        while ((index = list.indexOf(obj)) > -1) {
            found = true;
            list.set(index, obj2);
        }
        return found;
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static <T> ArrayList<T> list(Enumeration<T> enumeration) {
        ArrayList<T> list = new ArrayList<T>();
        while (enumeration.hasMoreElements()) {
            list.add(enumeration.nextElement());
        }
        return list;
    }

    
    @DSModeled(DSC.SAFE)
    public static <T> Collection<T> synchronizedCollection(
            Collection<T> collection) {
        if (collection == null) {
            throw new NullPointerException();
        }
        return new SynchronizedCollection<T>(collection);
    }

    
    @DSModeled(DSC.SAFE)
    public static <T> List<T> synchronizedList(List<T> list) {
        if (list == null) {
            throw new NullPointerException();
        }
        if (list instanceof RandomAccess) {
            return new SynchronizedRandomAccessList<T>(list);
        }
        return new SynchronizedList<T>(list);
    }

    
    @DSModeled(DSC.SAFE)
    public static <K, V> Map<K, V> synchronizedMap(Map<K, V> map) {
        if (map == null) {
            throw new NullPointerException();
        }
        return new SynchronizedMap<K, V>(map);
    }

    
    @DSModeled(DSC.SAFE)
    public static <E> Set<E> synchronizedSet(Set<E> set) {
        if (set == null) {
            throw new NullPointerException();
        }
        return new SynchronizedSet<E>(set);
    }

    
    @DSModeled(DSC.SAFE)
    public static <K, V> SortedMap<K, V> synchronizedSortedMap(
            SortedMap<K, V> map) {
        if (map == null) {
            throw new NullPointerException();
        }
        return new SynchronizedSortedMap<K, V>(map);
    }

    
    @DSModeled(DSC.SAFE)
    public static <E> SortedSet<E> synchronizedSortedSet(SortedSet<E> set) {
        if (set == null) {
            throw new NullPointerException();
        }
        return new SynchronizedSortedSet<E>(set);
    }

    
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    public static <E> Collection<E> unmodifiableCollection(
            Collection<? extends E> collection) {
        if (collection == null) {
            throw new NullPointerException();
        }
        return new UnmodifiableCollection<E>((Collection<E>) collection);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    public static <K, V> Map<K, V> unmodifiableMap(
            Map<? extends K, ? extends V> map) {
        if (map == null) {
            throw new NullPointerException();
        }
        return new UnmodifiableMap<K, V>((Map<K, V>) map);
    }

    
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    public static <E> Set<E> unmodifiableSet(Set<? extends E> set) {
        if (set == null) {
            throw new NullPointerException();
        }
        return new UnmodifiableSet<E>((Set<E>) set);
    }

    
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    public static <K, V> SortedMap<K, V> unmodifiableSortedMap(
            SortedMap<K, ? extends V> map) {
        if (map == null) {
            throw new NullPointerException();
        }
        return new UnmodifiableSortedMap<K, V>((SortedMap<K, V>) map);
    }

    
    @DSModeled(DSC.SAFE)
    public static <E> SortedSet<E> unmodifiableSortedSet(SortedSet<E> set) {
        if (set == null) {
            throw new NullPointerException();
        }
        return new UnmodifiableSortedSet<E>(set);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    public static final <T> List<T> emptyList() {
        return EMPTY_LIST;
    }

    
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    public static final <T> Set<T> emptySet() {
        return EMPTY_SET;
    }

    
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    public static final <K, V> Map<K, V> emptyMap() {
        return EMPTY_MAP;
    }

    
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    public static <T> Enumeration<T> emptyEnumeration() {
        return (Enumeration<T>) EMPTY_ENUMERATION;
    }

    
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    public static <T> Iterator<T> emptyIterator() {
        return (Iterator<T>) EMPTY_ITERATOR;
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    static <E> E checkType(E obj, Class<? extends E> type) {
        if (obj != null && !type.isInstance(obj)) {
            throw new ClassCastException("Attempt to insert element of type " + obj.getClass() +
                    " into collection of type " + type);
        }
        return obj;
    }

    
    @DSModeled(DSC.SAFE)
    public static <E> Set<E> newSetFromMap(Map<E, Boolean> map) {
        if (map.isEmpty()) {
            return new SetFromMap<E>(map);
        }
        throw new IllegalArgumentException();
    }

    
    @DSModeled(DSC.SAFE)
    public static <T> Queue<T> asLifoQueue(Deque<T> deque) {
        return new AsLIFOQueue<T>(deque);
    }

    
    private static final class CopiesList<E> extends AbstractList<E> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.634 -0400", hash_original_field = "7B8B965AD4BCA0E41AB51DE7B31363A1", hash_generated_field = "01825CC32046BF0FBE11738ABC136518")

        private int n;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.634 -0400", hash_original_field = "8E2DCFD7E7E24B1CA76C1193F645902B", hash_generated_field = "93B043155067F80D0269375649E4D7D4")

        private E element;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.634 -0400", hash_original_method = "5A122D173062D06824D4571736320F87", hash_generated_method = "EA507A4D3034FB0073A08BC40FB510D4")
          CopiesList(int length, E object) {
            if(length < 0)            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_588636139 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_588636139.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_588636139;
            } //End block
            n = length;
            element = object;
            // ---------- Original Method ----------
            //if (length < 0) {
                //throw new IllegalArgumentException();
            //}
            //n = length;
            //element = object;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.634 -0400", hash_original_method = "B07BCF81C9C48C72A08077A0468A8769", hash_generated_method = "D0EADCE4B2E5C13F71A646E884E147D5")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            boolean var1BF6311B6B832E206CDF43172C74BED5_722396698 = (element == null ? object == null : element.equals(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1945510660 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1945510660;
            // ---------- Original Method ----------
            //return element == null ? object == null : element.equals(object);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.635 -0400", hash_original_method = "61094B9B9DEC6161E82512577FAF3323", hash_generated_method = "62C665AE206F372C87C19DA7CDC14DB2")
        @Override
        public int size() {
            int var7B8B965AD4BCA0E41AB51DE7B31363A1_2079384307 = (n);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1817561562 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1817561562;
            // ---------- Original Method ----------
            //return n;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.635 -0400", hash_original_method = "857A70B35DA7146CF7ADC484EC4AABC8", hash_generated_method = "AC6742562E7D0BF6BBDCAA35CE148150")
        @Override
        public E get(int location) {
            addTaint(location);
            if(location >= 0 && location < n)            
            {
E var24D05606CDD4BC4C89F2F5A15C16F343_533353621 =                 element;
                var24D05606CDD4BC4C89F2F5A15C16F343_533353621.addTaint(taint);
                return var24D05606CDD4BC4C89F2F5A15C16F343_533353621;
            } //End block
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_630411665 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_630411665.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_630411665;
            // ---------- Original Method ----------
            //if (location >= 0 && location < n) {
                //return element;
            //}
            //throw new IndexOutOfBoundsException();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.635 -0400", hash_original_field = "6A61C247691E7C356BC04B2E9E793190", hash_generated_field = "2ACBEBBA06800CFC571100A6231B0F40")

        private static final long serialVersionUID = 2739099268398711800L;
    }


    
    private static final class EmptyList extends AbstractList implements RandomAccess, Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.635 -0400", hash_original_method = "BF3F11B0BCAE2AE80C7C74CBEB88EB5B", hash_generated_method = "BF3F11B0BCAE2AE80C7C74CBEB88EB5B")
        @DSModeled(DSC.SAFE)
        public EmptyList ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.635 -0400", hash_original_method = "38B750FD34BF6CB1144CDF020D3299E6", hash_generated_method = "957588B5AEACC9ECFCB02968935C459A")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_736199665 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_69813877 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_69813877;
            // ---------- Original Method ----------
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.636 -0400", hash_original_method = "F4586E3A64B5D10DEB709A723C85E55E", hash_generated_method = "B75A61B83DEEF38B8DB59BC84FBD9F6A")
        @Override
        public int size() {
            int varCFCD208495D565EF66E7DFF9F98764DA_1079353273 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1199215638 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1199215638;
            // ---------- Original Method ----------
            //return 0;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.636 -0400", hash_original_method = "F59F44D1664BC2EE59D5A9B30D144285", hash_generated_method = "CBFA1392286CF083CFFAFBFEC6E4A85E")
        @Override
        public Object get(int location) {
            addTaint(location);
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_248150697 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_248150697.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_248150697;
            // ---------- Original Method ----------
            //throw new IndexOutOfBoundsException();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.636 -0400", hash_original_method = "3CB4CAF1EADC3F12C565BD7D2B5F5514", hash_generated_method = "801FC09055278A4658A521B8059E8876")
        private Object readResolve() {
Object var41537F84856EC2B8175806D98827383E_1804832711 =             Collections.EMPTY_LIST;
            var41537F84856EC2B8175806D98827383E_1804832711.addTaint(taint);
            return var41537F84856EC2B8175806D98827383E_1804832711;
            // ---------- Original Method ----------
            //return Collections.EMPTY_LIST;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.636 -0400", hash_original_field = "FEEABBF180D6F8A042B90CBFA55A4A94", hash_generated_field = "F94EA5528856E40DE43B84AB4D470D7D")

        private static final long serialVersionUID = 8842843931221139166L;
    }


    
    private static final class EmptySet extends AbstractSet implements Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.636 -0400", hash_original_method = "3A37381B9598D46CF46D5D53F85DF5B1", hash_generated_method = "3A37381B9598D46CF46D5D53F85DF5B1")
        @DSModeled(DSC.SAFE)
        public EmptySet ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.636 -0400", hash_original_method = "38B750FD34BF6CB1144CDF020D3299E6", hash_generated_method = "C74C7D09C0552EDDEB033F1E363BB355")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_2032197728 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1810261945 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1810261945;
            // ---------- Original Method ----------
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.636 -0400", hash_original_method = "F4586E3A64B5D10DEB709A723C85E55E", hash_generated_method = "8C6C62C64A30A515EF00F3A33C4043B2")
        @Override
        public int size() {
            int varCFCD208495D565EF66E7DFF9F98764DA_608494480 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_240052546 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_240052546;
            // ---------- Original Method ----------
            //return 0;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.638 -0400", hash_original_method = "FC88A4B2F50E498E162F3F7EEDE885B1", hash_generated_method = "1664388D092FF4E38B8E589AB4C5A2A8")
        @Override
        public Iterator iterator() {
Iterator var2DC6937AF28EC3FA949592521F2521D5_1518535643 =             EMPTY_ITERATOR;
            var2DC6937AF28EC3FA949592521F2521D5_1518535643.addTaint(taint);
            return var2DC6937AF28EC3FA949592521F2521D5_1518535643;
            // ---------- Original Method ----------
            //return EMPTY_ITERATOR;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.638 -0400", hash_original_method = "2ED0845ADEAE5655731C197578B08F82", hash_generated_method = "2877B1327402811348CAB38C7BD23CD2")
        private Object readResolve() {
Object varF4CA34D7BD1863138D7F8BDB7243DF79_1138094290 =             Collections.EMPTY_SET;
            varF4CA34D7BD1863138D7F8BDB7243DF79_1138094290.addTaint(taint);
            return varF4CA34D7BD1863138D7F8BDB7243DF79_1138094290;
            // ---------- Original Method ----------
            //return Collections.EMPTY_SET;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.638 -0400", hash_original_field = "EBC69A53BFBAE35613EC4BD95CB98F92", hash_generated_field = "A81D1AE03C05E931255584261EF756E0")

        private static final long serialVersionUID = 1582296315990362920L;
    }


    
    private static final class EmptyMap extends AbstractMap implements Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.638 -0400", hash_original_method = "0E8F36F90F9C751DA5A12903A16705DF", hash_generated_method = "0E8F36F90F9C751DA5A12903A16705DF")
        @DSModeled(DSC.SAFE)
        public EmptyMap ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.638 -0400", hash_original_method = "2AD0E7E75E88E287D6229481B74BEBCC", hash_generated_method = "7BF3F51C44C2E1AD8785A69F3CE58BA3")
        @Override
        public boolean containsKey(Object key) {
            addTaint(key.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_822509761 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_263002060 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_263002060;
            // ---------- Original Method ----------
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.638 -0400", hash_original_method = "9D32B6FFC088649ED5480F6E533A1288", hash_generated_method = "A9261254763C0086FEBC3A0A9CBB388A")
        @Override
        public boolean containsValue(Object value) {
            addTaint(value.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_1267073014 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_721651000 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_721651000;
            // ---------- Original Method ----------
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.639 -0400", hash_original_method = "709DD403C63D2F4104FF93FEEB6E3457", hash_generated_method = "0F68D107E47B9341B1258F78D94FCE87")
        @Override
        public Set entrySet() {
Set varF0EE7499B60CBE7D6945072EDEE0BCAD_447407542 =             EMPTY_SET;
            varF0EE7499B60CBE7D6945072EDEE0BCAD_447407542.addTaint(taint);
            return varF0EE7499B60CBE7D6945072EDEE0BCAD_447407542;
            // ---------- Original Method ----------
            //return EMPTY_SET;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.639 -0400", hash_original_method = "59A1188DDD48CFFB749850DC2DA09C1D", hash_generated_method = "659FBF44F1229A5304C9051771FBE972")
        @Override
        public Object get(Object key) {
            addTaint(key.getTaint());
Object var540C13E9E156B687226421B24F2DF178_2123660504 =             null;
            var540C13E9E156B687226421B24F2DF178_2123660504.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2123660504;
            // ---------- Original Method ----------
            //return null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.639 -0400", hash_original_method = "266B164C16644761E32491964C192EB7", hash_generated_method = "350C108E16AB470CDB4BA7A50951C432")
        @Override
        public Set keySet() {
Set varF0EE7499B60CBE7D6945072EDEE0BCAD_1005532496 =             EMPTY_SET;
            varF0EE7499B60CBE7D6945072EDEE0BCAD_1005532496.addTaint(taint);
            return varF0EE7499B60CBE7D6945072EDEE0BCAD_1005532496;
            // ---------- Original Method ----------
            //return EMPTY_SET;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.639 -0400", hash_original_method = "745E6E226DD5F7D4E763DA74DFF70792", hash_generated_method = "691A85393BB6B192552D290AA7BAEC6E")
        @Override
        public Collection values() {
Collection var3EB787547078B98C6DA0C5CC8DE617C5_161877832 =             EMPTY_LIST;
            var3EB787547078B98C6DA0C5CC8DE617C5_161877832.addTaint(taint);
            return var3EB787547078B98C6DA0C5CC8DE617C5_161877832;
            // ---------- Original Method ----------
            //return EMPTY_LIST;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.639 -0400", hash_original_method = "59A22E9415A338EB85D7A7DD214359CC", hash_generated_method = "36AE1B37DFE3EF645F4EC1A1CBBA862B")
        private Object readResolve() {
Object var82C06B799CE89F4FFB58A600643773F8_1481268190 =             Collections.EMPTY_MAP;
            var82C06B799CE89F4FFB58A600643773F8_1481268190.addTaint(taint);
            return var82C06B799CE89F4FFB58A600643773F8_1481268190;
            // ---------- Original Method ----------
            //return Collections.EMPTY_MAP;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.639 -0400", hash_original_field = "71F087EB1E9FCDB60C678B95061CEBBD", hash_generated_field = "847A5C63C9A66D8A1818A774A2AADB69")

        private static final long serialVersionUID = 6428348081105594320L;
    }


    
    private static final class ReverseComparator<T> implements Comparator<T>, Serializable {
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.641 -0400", hash_original_method = "FFB2FB11DBE006893CA9746ECCE68517", hash_generated_method = "FFB2FB11DBE006893CA9746ECCE68517")
        public ReverseComparator ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.642 -0400", hash_original_method = "907488F1D5625FE5C9F59ED8A7B6E697", hash_generated_method = "DB2F195699931A90428B9596CC7F5BD0")
        @SuppressWarnings("unchecked")
        @Override
        public int compare(T o1, T o2) {
            addTaint(o2.getTaint());
            addTaint(o1.getTaint());
            Comparable<T> c2 = (Comparable<T>) o2;
            int varA26B336DE8F584880A26AED2B3F89007_633967340 = (c2.compareTo(o1));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1259368009 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1259368009;
            // ---------- Original Method ----------
            //Comparable<T> c2 = (Comparable<T>) o2;
            //return c2.compareTo(o1);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.642 -0400", hash_original_method = "DD371F0FDF8300FDCFBD1E5C395D42BC", hash_generated_method = "F238C0F6F57039370F30CCC0ECAEA2BC")
        private Object readResolve() throws ObjectStreamException {
Object var30C80D8445A0CA6A7769041AAD00A443_1340467786 =             INSTANCE;
            var30C80D8445A0CA6A7769041AAD00A443_1340467786.addTaint(taint);
            return var30C80D8445A0CA6A7769041AAD00A443_1340467786;
            // ---------- Original Method ----------
            //return INSTANCE;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.642 -0400", hash_original_field = "2B003AD2E801398B9507D8ADBBB584A6", hash_generated_field = "28B0E21DBABF675E471021CA76588F6A")

        private static final ReverseComparator<Object> INSTANCE = new ReverseComparator<Object>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.642 -0400", hash_original_field = "844E6A53F14D8AD803480DAA1F2399E0", hash_generated_field = "410EA5184B11CE9687E932D7F263B83C")

        private static final long serialVersionUID = 7207038068494060240L;
    }


    
    private static final class ReverseComparator2<T> implements Comparator<T>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.642 -0400", hash_original_field = "31B4E550AA5FD883246F9B9CEAE82483", hash_generated_field = "ACD6D4A2528BA4BAF7406DE3D3F49FE6")

        private Comparator<T> cmp;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.642 -0400", hash_original_method = "1ABA0972F29BDB004C28A1246ABEF788", hash_generated_method = "B92E5576724AB283C109FF5B16A47456")
          ReverseComparator2(Comparator<T> comparator) {
            this.cmp = comparator;
            // ---------- Original Method ----------
            //this.cmp = comparator;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.642 -0400", hash_original_method = "449D1B24DD0E97F4D53DEB786BD04597", hash_generated_method = "4D5711262556E9AD9566D15D33F287CA")
        @Override
        public int compare(T o1, T o2) {
            addTaint(o2.getTaint());
            addTaint(o1.getTaint());
            int varB28B1809248E2B27B989EA42D6697691_431175315 = (cmp.compare(o2, o1));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_755034792 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_755034792;
            // ---------- Original Method ----------
            //return cmp.compare(o2, o1);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.642 -0400", hash_original_method = "30689CAB8FBFDCB9289EF03377EE08A0", hash_generated_method = "7DEF688EB173F196A9A86D3171C52CD3")
        @Override
        public boolean equals(Object o) {
            addTaint(o.getTaint());
            boolean var806D582AA724690D98485479EAC877DC_1438224987 = (o instanceof ReverseComparator2
                    && ((ReverseComparator2) o).cmp.equals(cmp));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_770706413 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_770706413;
            // ---------- Original Method ----------
            //return o instanceof ReverseComparator2
                    //&& ((ReverseComparator2) o).cmp.equals(cmp);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.642 -0400", hash_original_method = "CAA612A5887D060562790EB1CDD1FEFE", hash_generated_method = "9406A0166EB3C994CDF041E0C99AE653")
        @Override
        public int hashCode() {
            int var131BD9FA627336BB1F5FEE4AA2610D18_432344270 = (~cmp.hashCode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1293756650 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1293756650;
            // ---------- Original Method ----------
            //return ~cmp.hashCode();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.642 -0400", hash_original_field = "C2743FD0D0E256493E9B52C087283254", hash_generated_field = "3328170146630256C37315D4155F67EF")

        private static final long serialVersionUID = 4374092139857L;
    }


    
    private static final class SingletonSet<E> extends AbstractSet<E> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.642 -0400", hash_original_field = "8E2DCFD7E7E24B1CA76C1193F645902B", hash_generated_field = "AADC7BC67B0FB6048E4A856A581BAEE9")

        E element;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.643 -0400", hash_original_method = "044BE6981927B9234E2AE8686E07A72F", hash_generated_method = "08623BAB02DDA909B203E3610F71957D")
          SingletonSet(E object) {
            element = object;
            // ---------- Original Method ----------
            //element = object;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.643 -0400", hash_original_method = "B07BCF81C9C48C72A08077A0468A8769", hash_generated_method = "F3EF1B784FFB42B115D7031D15660B68")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            boolean var1BF6311B6B832E206CDF43172C74BED5_1476562172 = (element == null ? object == null : element.equals(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1482059742 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1482059742;
            // ---------- Original Method ----------
            //return element == null ? object == null : element.equals(object);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.644 -0400", hash_original_method = "798A0AE2F2A6352396904AB5C9ED97D5", hash_generated_method = "452637F021520314E7F8E1FE66FAC4EA")
        @Override
        public int size() {
            int varC4CA4238A0B923820DCC509A6F75849B_227002521 = (1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_69069058 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_69069058;
            // ---------- Original Method ----------
            //return 1;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.644 -0400", hash_original_method = "135AC18A6A8AD4548E2E750F2D4C7699", hash_generated_method = "39DA48894BA329BD18C0E92D954E9E9F")
        @Override
        public Iterator<E> iterator() {
Iterator<E> varEF1BE467ABB7AA4C87CBCE9613BD5C24_1939968739 =             new Iterator<E>() {            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.644 -0400", hash_original_field = "42ADDF4753B3ACA32EE339265163027B", hash_generated_field = "DE9DC7F145F778F316047B4F4AEC3B9B")
            boolean hasNext = true;
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.644 -0400", hash_original_method = "1FFE1DD028DACE64CCBE65BDB363D72C", hash_generated_method = "2A98214D57023A09402BB808AED6A9DC")
            @Override
            public boolean hasNext() {
                boolean varD9CA95405A2301707BEA3F2942FAB48B_600479706 = (hasNext);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_344904331 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_344904331;
                // ---------- Original Method ----------
                //return hasNext;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.644 -0400", hash_original_method = "163A9F5CD311CAB76B0FCB4B7573EA38", hash_generated_method = "D3A20B9110EDB69D5177BBD684C16F5B")
            @Override
            public E next() {
                if(hasNext)                
                {
                    hasNext = false;
E var24D05606CDD4BC4C89F2F5A15C16F343_201288366 =                     element;
                    var24D05606CDD4BC4C89F2F5A15C16F343_201288366.addTaint(taint);
                    return var24D05606CDD4BC4C89F2F5A15C16F343_201288366;
                } //End block
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_756636258 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_756636258.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_756636258;
                // ---------- Original Method ----------
                //if (hasNext) {
                        //hasNext = false;
                        //return element;
                    //}
                //throw new NoSuchElementException();
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.644 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "477E9908F25628C920DF2B584D450959")
            @Override
            public void remove() {
                UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1803348934 = new UnsupportedOperationException();
                var81FA7E299EEE7F062EBFBEEF08B0464D_1803348934.addTaint(taint);
                throw var81FA7E299EEE7F062EBFBEEF08B0464D_1803348934;
                // ---------- Original Method ----------
                //throw new UnsupportedOperationException();
            }
};
            varEF1BE467ABB7AA4C87CBCE9613BD5C24_1939968739.addTaint(taint);
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.644 -0400", hash_original_field = "C80162DD8B57D34236F77D8F8A87A897", hash_generated_field = "35AF14D3D33C59E58AFC233BD942F616")

        private static final long serialVersionUID = 3193687207550431679L;
    }


    
    private static final class SingletonList<E> extends AbstractList<E> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.644 -0400", hash_original_field = "8E2DCFD7E7E24B1CA76C1193F645902B", hash_generated_field = "AADC7BC67B0FB6048E4A856A581BAEE9")

        E element;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.646 -0400", hash_original_method = "F3174A5FA7BA5962D109EAC3245F2C1D", hash_generated_method = "6BE55179558843F3290CC42091204DF4")
          SingletonList(E object) {
            element = object;
            // ---------- Original Method ----------
            //element = object;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.646 -0400", hash_original_method = "B07BCF81C9C48C72A08077A0468A8769", hash_generated_method = "FDEE593B4FE5A463F2E7691A6EAD45F2")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            boolean var1BF6311B6B832E206CDF43172C74BED5_2118186210 = (element == null ? object == null : element.equals(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_624628681 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_624628681;
            // ---------- Original Method ----------
            //return element == null ? object == null : element.equals(object);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.646 -0400", hash_original_method = "1C6E7D1EB082158D5E00EA29E883A612", hash_generated_method = "2AC16BF1CEDA9D5C228314CA598D53DD")
        @Override
        public E get(int location) {
            addTaint(location);
            if(location == 0)            
            {
E var24D05606CDD4BC4C89F2F5A15C16F343_946837297 =                 element;
                var24D05606CDD4BC4C89F2F5A15C16F343_946837297.addTaint(taint);
                return var24D05606CDD4BC4C89F2F5A15C16F343_946837297;
            } //End block
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_441656111 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_441656111.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_441656111;
            // ---------- Original Method ----------
            //if (location == 0) {
                //return element;
            //}
            //throw new IndexOutOfBoundsException();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.646 -0400", hash_original_method = "798A0AE2F2A6352396904AB5C9ED97D5", hash_generated_method = "75355FDFB07E0D1CFFAB52B24FE15E43")
        @Override
        public int size() {
            int varC4CA4238A0B923820DCC509A6F75849B_78465805 = (1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_920393351 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_920393351;
            // ---------- Original Method ----------
            //return 1;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.646 -0400", hash_original_field = "136A37A5852F7DE7150E3A4BC9F06AE5", hash_generated_field = "CBFA444A21D6CBFF01F29F9591A887AB")

        private static final long serialVersionUID = 3093736618740652951L;
    }


    
    private static final class SingletonMap<K, V> extends AbstractMap<K, V> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.646 -0400", hash_original_field = "8CE4B16B22B58894AA86C421E8759DF3", hash_generated_field = "052F80594ED04BACBC2E98744BD4CC2D")

        K k;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.646 -0400", hash_original_field = "9E3669D19B675BD57058FD4664205D2A", hash_generated_field = "3A278B3CDA0FEEA24CB626A0B3136D0B")

        V v;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.646 -0400", hash_original_method = "85D3D420EE431E7A3C1CBFB71D1CEAE2", hash_generated_method = "942C300AA2E111086F3B6C3DFB936BBB")
          SingletonMap(K key, V value) {
            k = key;
            v = value;
            // ---------- Original Method ----------
            //k = key;
            //v = value;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.647 -0400", hash_original_method = "26D5E87A2C62405ADA3B15C5C8B30FEC", hash_generated_method = "3DAA9D5405CBA7169D085143D2AC83EE")
        @Override
        public boolean containsKey(Object key) {
            addTaint(key.getTaint());
            boolean varE4FF7C43871EEA16BF355477C9641A8F_1533354129 = (k == null ? key == null : k.equals(key));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1800484873 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1800484873;
            // ---------- Original Method ----------
            //return k == null ? key == null : k.equals(key);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.647 -0400", hash_original_method = "827D42B4F919454EC51CA86D0E534994", hash_generated_method = "20F83E7587CE842B0894F2D5B92CAF18")
        @Override
        public boolean containsValue(Object value) {
            addTaint(value.getTaint());
            boolean var89AFEFDF42625078B7AFD1C8FB622AB5_71655225 = (v == null ? value == null : v.equals(value));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1316977818 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1316977818;
            // ---------- Original Method ----------
            //return v == null ? value == null : v.equals(value);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.648 -0400", hash_original_method = "8C587096F5E6029DBB187C58CF22D158", hash_generated_method = "7C0CA045289EFCA6FBE0BD352CA43B85")
        @Override
        public V get(Object key) {
            addTaint(key.getTaint());
            if(containsKey(key))            
            {
V var6DC76BC51820DD65E8396280E884AA78_97251722 =                 v;
                var6DC76BC51820DD65E8396280E884AA78_97251722.addTaint(taint);
                return var6DC76BC51820DD65E8396280E884AA78_97251722;
            } //End block
V var540C13E9E156B687226421B24F2DF178_369839050 =             null;
            var540C13E9E156B687226421B24F2DF178_369839050.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_369839050;
            // ---------- Original Method ----------
            //if (containsKey(key)) {
                //return v;
            //}
            //return null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.648 -0400", hash_original_method = "798A0AE2F2A6352396904AB5C9ED97D5", hash_generated_method = "5BB9DBD2AB515A5C5F36D85F32E30EA8")
        @Override
        public int size() {
            int varC4CA4238A0B923820DCC509A6F75849B_1732611020 = (1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_510572704 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_510572704;
            // ---------- Original Method ----------
            //return 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.505 -0400", hash_original_method = "AB4A6E093F1AE40B73184C21F1D08E5E", hash_generated_method = "48A2E5782E0DCD494BF96200E66A035B")
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
Set<Map.Entry<K, V>> varC1C98ED33EBE8D5F809497AE1618869F_181985594 =             new AbstractSet<Map.Entry<K, V>>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.499 -0400", hash_original_method = "2A1C1E3E6C77DBF97F80372F94562608", hash_generated_method = "D338873399F21C168B46B599E7AD6070")
            @Override
            public boolean contains(Object object) {
                addTaint(object.getTaint());
    if(object instanceof Map.Entry)                
                {
                    Map.Entry<?, ?> entry = (Map.Entry<?, ?>) object;
                    boolean var6D90BCF138926802445A3EFCAF8CBE03_28890093 = (containsKey(entry.getKey())
                                && containsValue(entry.getValue()));
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1498191315 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1498191315;
                } //End block
                boolean var68934A3E9455FA72420237EB05902327_1697897273 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_138830698 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_138830698;
                // ---------- Original Method ----------
                //if (object instanceof Map.Entry) {
                        //Map.Entry<?, ?> entry = (Map.Entry<?, ?>) object;
                        //return containsKey(entry.getKey())
                                //&& containsValue(entry.getValue());
                    //}
                //return false;
            }
            @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.499 -0400", hash_original_method = "798A0AE2F2A6352396904AB5C9ED97D5", hash_generated_method = "5EF0C210C2FD458D465D7A190312FDF5")
            @Override
            public int size() {
                int varC4CA4238A0B923820DCC509A6F75849B_580395766 = (1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_210558322 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_210558322;
                // ---------- Original Method ----------
                //return 1;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.504 -0400", hash_original_method = "514544EF1052F229FBEAE8C28F5C502A", hash_generated_method = "D63081166929268C954FCFB5AD6DF760")
            @Override
            public Iterator<Map.Entry<K, V>> iterator() {
Iterator<Map.Entry<K, V>> var72555FFA480563A744615CB3042A10C3_693483736 =                 new Iterator<Map.Entry<K, V>>() {                @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.500 -0400", hash_original_field = "42ADDF4753B3ACA32EE339265163027B", hash_generated_field = "DE9DC7F145F778F316047B4F4AEC3B9B")
                boolean hasNext = true;
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.500 -0400", hash_original_method = "1FFE1DD028DACE64CCBE65BDB363D72C", hash_generated_method = "CEE619A24E48BC379FDED3A48B0D271A")
                @Override
                public boolean hasNext() {
                    boolean varD9CA95405A2301707BEA3F2942FAB48B_1288819671 = (hasNext);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1288991136 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1288991136;
                    // ---------- Original Method ----------
                    //return hasNext;
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.503 -0400", hash_original_method = "E80284659713283C8723ACEF8D2E3A9E", hash_generated_method = "AC8345E6077CAB2D7D6A4E7303EDB467")
                @Override
                public Map.Entry<K, V> next() {
    if(!hasNext)                    
                    {
                        NoSuchElementException var28D00AB599969908D71F102AF992D49A_631679991 = new NoSuchElementException();
                        var28D00AB599969908D71F102AF992D49A_631679991.addTaint(taint);
                        throw var28D00AB599969908D71F102AF992D49A_631679991;
                    } //End block
                    hasNext = false;
Map.Entry<K, V> var9E12D90BC96A0F9C001C5904062535E7_420079315 =                     new MapEntry<K, V>(k, v) {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.501 -0400", hash_original_method = "C8286CC3DDAAC404E3663F831F2B1F6D", hash_generated_method = "CF5093F6E109CC7BF4DDEB6776FCD544")
                    @Override
                    public V setValue(V value) {
                        addTaint(value.getTaint());
                        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1098018997 = new UnsupportedOperationException();
                        var81FA7E299EEE7F062EBFBEEF08B0464D_1098018997.addTaint(taint);
                        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1098018997;
                        // ---------- Original Method ----------
                        //throw new UnsupportedOperationException();
                    }
};
                    var9E12D90BC96A0F9C001C5904062535E7_420079315.addTaint(taint);
                    return var9E12D90BC96A0F9C001C5904062535E7_420079315;
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
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.504 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "598E38112D9BC5237C6C26384A731D6B")
                @Override
                public void remove() {
                    UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_687439959 = new UnsupportedOperationException();
                    var81FA7E299EEE7F062EBFBEEF08B0464D_687439959.addTaint(taint);
                    throw var81FA7E299EEE7F062EBFBEEF08B0464D_687439959;
                    // ---------- Original Method ----------
                    //throw new UnsupportedOperationException();
                }
};
                var72555FFA480563A744615CB3042A10C3_693483736.addTaint(taint);
                return var72555FFA480563A744615CB3042A10C3_693483736;
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }
};
            varC1C98ED33EBE8D5F809497AE1618869F_181985594.addTaint(taint);
            return varC1C98ED33EBE8D5F809497AE1618869F_181985594;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.703 -0400", hash_original_field = "9848B8101686634CF12341A29DB1F062", hash_generated_field = "0B15CF1CC7A3921AD66781626704DE4C")

        private static final long serialVersionUID = -6979724477215052911L;
    }


    
    static class SynchronizedCollection<E> implements Collection<E>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.703 -0400", hash_original_field = "4A8A08F09D37B73795649038408B5F33", hash_generated_field = "A3C80A7E02E49F20400373DFBAF9696A")

        Collection<E> c;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.703 -0400", hash_original_field = "25A01BB859125507013A2FE9737D3C32", hash_generated_field = "5C5F8780FECE5E612AF5A86D3A8B3194")

        Object mutex;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.703 -0400", hash_original_method = "30FA7B26D2517E75155300E21A44EE02", hash_generated_method = "04BEBFE0095AFAF3C9F796F57AE0BFCE")
          SynchronizedCollection(Collection<E> collection) {
            c = collection;
            mutex = this;
            // ---------- Original Method ----------
            //c = collection;
            //mutex = this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.703 -0400", hash_original_method = "A2A350BD37040709EC39C6B0536AFBDE", hash_generated_method = "4B2E27EA4C4C16202811504251810751")
          SynchronizedCollection(Collection<E> collection, Object mutex) {
            c = collection;
            this.mutex = mutex;
            // ---------- Original Method ----------
            //c = collection;
            //this.mutex = mutex;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.703 -0400", hash_original_method = "FB2AC5CD0A8119C2DE50A53F38732CDD", hash_generated_method = "201C073E60F2FB4A062552DFB49A0BBD")
        @Override
        public boolean add(E object) {
            addTaint(object.getTaint());
            synchronized
(mutex)            {
                boolean varB1EDCF55DE15920EACA4E1E5D202EB69_1657972821 = (c.add(object));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_995243943 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_995243943;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.add(object);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.704 -0400", hash_original_method = "8489E829BC0B88048B305735D46B1D99", hash_generated_method = "3E31014E03B0C0959A96B03F2A055041")
        @Override
        public boolean addAll(Collection<? extends E> collection) {
            addTaint(collection.getTaint());
            synchronized
(mutex)            {
                boolean varBB2D721B097E4DDEDAE8E4090B1656E9_1399751548 = (c.addAll(collection));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_695711736 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_695711736;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.addAll(collection);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.704 -0400", hash_original_method = "7AE3345D011114FF0F62A8DFD7762BE2", hash_generated_method = "DF6C884B407381ED375E25E67759127F")
        @Override
        public void clear() {
            synchronized
(mutex)            {
                c.clear();
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //c.clear();
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.704 -0400", hash_original_method = "1B12503F1112F0CD581293F3A624FEFF", hash_generated_method = "40D94128D1B93DB3AEEBA9C944D040A7")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            synchronized
(mutex)            {
                boolean var1AEB72C9D1B87075EB37C6366C13F8DB_1632679843 = (c.contains(object));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1823262257 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1823262257;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.contains(object);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.704 -0400", hash_original_method = "F945FF2C907D1AA0923D46DECCCD5EAD", hash_generated_method = "84A660CC4893824FC26344D4B692EBAB")
        @Override
        public boolean containsAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            synchronized
(mutex)            {
                boolean var89744A7A766147F896A88C5E38016080_998615906 = (c.containsAll(collection));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1122874706 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1122874706;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.containsAll(collection);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.704 -0400", hash_original_method = "FC4F88C8FB9F4E3716AD2ABCD3101657", hash_generated_method = "1309FB3046AD7CF9D3539633770AD34F")
        @Override
        public boolean isEmpty() {
            synchronized
(mutex)            {
                boolean var65FAF5A74582A5D73E221DB675503595_468703616 = (c.isEmpty());
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2013064786 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2013064786;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.isEmpty();
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.704 -0400", hash_original_method = "7F1B5E60A4E4F9F3AFA65965967FBBF0", hash_generated_method = "CB6AF8B0493F4060C639287224CA0C76")
        @Override
        public Iterator<E> iterator() {
            synchronized
(mutex)            {
Iterator<E> var918560FDB0FDB05FBAECB3ADB6E2A6DB_1342722677 =                 c.iterator();
                var918560FDB0FDB05FBAECB3ADB6E2A6DB_1342722677.addTaint(taint);
                return var918560FDB0FDB05FBAECB3ADB6E2A6DB_1342722677;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.iterator();
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.704 -0400", hash_original_method = "C85E45E4AF074973339408E1197B653C", hash_generated_method = "CE3B4722CF86448119F17BB49FC1C094")
        @Override
        public boolean remove(Object object) {
            addTaint(object.getTaint());
            synchronized
(mutex)            {
                boolean var4351AB2E7C2E6CB2963502AF12FA9961_1039375739 = (c.remove(object));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1752047894 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1752047894;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.remove(object);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.704 -0400", hash_original_method = "63829008A74D54A464D81619215951F3", hash_generated_method = "662ED57EBFCD47C8998B294AB9721367")
        @Override
        public boolean removeAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            synchronized
(mutex)            {
                boolean var764D8CCB8FC4481072E471953CFC8F8C_2025068227 = (c.removeAll(collection));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_839683631 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_839683631;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.removeAll(collection);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.705 -0400", hash_original_method = "F83427C5B4EF86DB8198B3D2BAE482AC", hash_generated_method = "CD278A132C8F48CD84EFF87A6429870C")
        @Override
        public boolean retainAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            synchronized
(mutex)            {
                boolean var9BEBAF6C8A25352D5A75AE9DA04B09DB_408790457 = (c.retainAll(collection));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1424500971 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1424500971;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.retainAll(collection);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.705 -0400", hash_original_method = "8641BC878FB77D36CE60B1977D7C0FB5", hash_generated_method = "56312E32D6028F12EC3F04F29C3F7550")
        @Override
        public int size() {
            synchronized
(mutex)            {
                int varB01543F097DAA850E9B79CBAB9C1B976_1255291109 = (c.size());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1954598912 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1954598912;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.size();
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.705 -0400", hash_original_method = "214BCEC14D5449B585926B657D8D51C2", hash_generated_method = "5A7ECDE553C25FFF08FBD2EFC59506EF")
        @Override
        public java.lang.Object[] toArray() {
            synchronized
(mutex)            {
java.lang.Object[] var46570412E19D68724A647FAFEECFBF92_729589703 =                 c.toArray();
                var46570412E19D68724A647FAFEECFBF92_729589703.addTaint(taint);
                return var46570412E19D68724A647FAFEECFBF92_729589703;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.toArray();
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.705 -0400", hash_original_method = "D637F0F4C3C8C312A0597F30C1C6DB59", hash_generated_method = "35649F821AF2CBE13A8B8014B9022CF7")
        @Override
        public String toString() {
            synchronized
(mutex)            {
String var7F88C51BB16CD8992026056598815CC9_530930727 =                 c.toString();
                var7F88C51BB16CD8992026056598815CC9_530930727.addTaint(taint);
                return var7F88C51BB16CD8992026056598815CC9_530930727;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.toString();
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.705 -0400", hash_original_method = "567EED27866E99DFC1B7F8B43B648D82", hash_generated_method = "5CC036A91B9EFDC6513490DF2199D4B6")
        @Override
        public <T> T[] toArray(T[] array) {
            addTaint(array[0].getTaint());
            synchronized
(mutex)            {
T[] varA824E05E0FA0C1B35EB9A8324FF1796D_221099759 =                 c.toArray(array);
                varA824E05E0FA0C1B35EB9A8324FF1796D_221099759.addTaint(taint);
                return varA824E05E0FA0C1B35EB9A8324FF1796D_221099759;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.toArray(array);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.705 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "350CD97D03809885CB7561AF44340EC3")
        private void writeObject(ObjectOutputStream stream) throws IOException {
            addTaint(stream.getTaint());
            synchronized
(mutex)            {
                stream.defaultWriteObject();
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //stream.defaultWriteObject();
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.705 -0400", hash_original_field = "B7F3A88BD93CCDAF65C044FAA6629D02", hash_generated_field = "0D9A3687FC51DFBFFFEA57286BC842CD")

        private static final long serialVersionUID = 3053995032091335093L;
    }


    
    static class SynchronizedRandomAccessList<E> extends SynchronizedList<E> implements RandomAccess {
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.705 -0400", hash_original_method = "B7E7091552AE239FAE56C332916C1F88", hash_generated_method = "E13039390DC63B5DD55D2C3F5A398F04")
          SynchronizedRandomAccessList(List<E> l) {
            super(l);
            addTaint(l.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.705 -0400", hash_original_method = "333C2DB156927D33EFC68D095A4D91C7", hash_generated_method = "8776429B58A200120921377CD7800721")
          SynchronizedRandomAccessList(List<E> l, Object mutex) {
            super(l, mutex);
            addTaint(mutex.getTaint());
            addTaint(l.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.706 -0400", hash_original_method = "52EB3707ADD11A2326D60B7B815140D9", hash_generated_method = "5D9963FAA7A089AE0351CE1DE979334E")
        @Override
        public List<E> subList(int start, int end) {
            addTaint(end);
            addTaint(start);
            synchronized
(mutex)            {
List<E> var867584235690190D4FBEF7E995366649_1163571144 =                 new SynchronizedRandomAccessList<E>(list.subList(start, end), mutex);
                var867584235690190D4FBEF7E995366649_1163571144.addTaint(taint);
                return var867584235690190D4FBEF7E995366649_1163571144;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedRandomAccessList<E>(list.subList(start, end), mutex);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.706 -0400", hash_original_method = "3A06B4F1BF7736CF10F2183ECBC34EF4", hash_generated_method = "1D611E60A248E06873F76D240E7D2213")
        private Object writeReplace() {
Object var91C5F48A6EC2BB7DF4455DCCC8C58A1A_876647516 =             new SynchronizedList<E>(list);
            var91C5F48A6EC2BB7DF4455DCCC8C58A1A_876647516.addTaint(taint);
            return var91C5F48A6EC2BB7DF4455DCCC8C58A1A_876647516;
            // ---------- Original Method ----------
            //return new SynchronizedList<E>(list);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.706 -0400", hash_original_field = "9B799982724822CB2FE4521FDAC6E710", hash_generated_field = "F305BE0154CFFE9E0253007EE134CBB9")

        private static final long serialVersionUID = 1530674583602358482L;
    }


    
    static class SynchronizedList<E> extends SynchronizedCollection<E> implements List<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.706 -0400", hash_original_field = "10AE9FC7D453B0DD525D0EDF2EDE7961", hash_generated_field = "1ECA8D0C53ED31C6D874046BB18C0645")

        List<E> list;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.706 -0400", hash_original_method = "557BC04FB4751FAF0774C664BC5CCEDB", hash_generated_method = "C7C5461D5C9C9A7143EFC825B2E89308")
          SynchronizedList(List<E> l) {
            super(l);
            list = l;
            // ---------- Original Method ----------
            //list = l;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.706 -0400", hash_original_method = "6BB690026CB7D337AD2D522FD2C1D564", hash_generated_method = "DA23F60EE2F336AE20DE0F8560712B04")
          SynchronizedList(List<E> l, Object mutex) {
            super(l, mutex);
            addTaint(mutex.getTaint());
            list = l;
            // ---------- Original Method ----------
            //list = l;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.706 -0400", hash_original_method = "771543DB5FBF857EC43E623C900790C1", hash_generated_method = "E62A1EE7F4416AC86776B529C1C1745E")
        @Override
        public void add(int location, E object) {
            addTaint(object.getTaint());
            addTaint(location);
            synchronized
(mutex)            {
                list.add(location, object);
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //list.add(location, object);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.706 -0400", hash_original_method = "2E8B0D036C339DEB52EAEECF82B3FC29", hash_generated_method = "0B146F399C3D6F0BBA8E6DF193F6F263")
        @Override
        public boolean addAll(int location, Collection<? extends E> collection) {
            addTaint(collection.getTaint());
            addTaint(location);
            synchronized
(mutex)            {
                boolean varE4C4ADDA86080E08AFA48F394D895E2E_698435637 = (list.addAll(location, collection));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_481618904 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_481618904;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.addAll(location, collection);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.707 -0400", hash_original_method = "3D6B0DEE3E066475015263D28B67E9C7", hash_generated_method = "7CEB95454E58A40F20EED03BB646C080")
        @Override
        public boolean equals(Object object) {
            addTaint(object.getTaint());
            synchronized
(mutex)            {
                boolean var3031446AD6BFF612C63BB52505A53EB2_1104447145 = (list.equals(object));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1589190205 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1589190205;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.equals(object);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.707 -0400", hash_original_method = "5B64BB89A58DED71DBA9907C06BC2CBB", hash_generated_method = "AFDAA05D3400E46653EE77C22B8CAC8A")
        @Override
        public E get(int location) {
            addTaint(location);
            synchronized
(mutex)            {
E var4DE8B026CD0A7863FB8A32177D5AA64A_1130337798 =                 list.get(location);
                var4DE8B026CD0A7863FB8A32177D5AA64A_1130337798.addTaint(taint);
                return var4DE8B026CD0A7863FB8A32177D5AA64A_1130337798;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.get(location);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.707 -0400", hash_original_method = "4F5947DB3C3ABC0CDEDCB631295417DE", hash_generated_method = "84FC1134FA7A9A56E1DE484EDF2309F6")
        @Override
        public int hashCode() {
            synchronized
(mutex)            {
                int varE2167E8879221CB1AE58F4BC195DE759_1269467020 = (list.hashCode());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1407053983 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1407053983;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.hashCode();
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.707 -0400", hash_original_method = "3D24998665BD619FA01B00E0A34A83F5", hash_generated_method = "BFFB28F2DD926A06C5DADC48EBD65674")
        @Override
        public int indexOf(Object object) {
            addTaint(object.getTaint());
            int size;
            Object[] array;
            synchronized
(mutex)            {
                size = list.size();
                array = new Object[size];
                list.toArray(array);
            } //End block
            if(object != null)            
            {
for(int i = 0;i < size;i++)
                {
                    if(object.equals(array[i]))                    
                    {
                        int var865C0C0B4AB0E063E5CAA3387C1A8741_1798538378 = (i);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1156867390 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1156867390;
                    } //End block
                } //End block
            } //End block
            else
            {
for(int i = 0;i < size;i++)
                {
                    if(array[i] == null)                    
                    {
                        int var865C0C0B4AB0E063E5CAA3387C1A8741_1233688771 = (i);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1513448497 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1513448497;
                    } //End block
                } //End block
            } //End block
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1875636998 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1928205603 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1928205603;
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.708 -0400", hash_original_method = "615F71337583130515178716D1767A86", hash_generated_method = "DBF393AD4295CA677886B1C9DB13385A")
        @Override
        public int lastIndexOf(Object object) {
            addTaint(object.getTaint());
            int size;
            Object[] array;
            synchronized
(mutex)            {
                size = list.size();
                array = new Object[size];
                list.toArray(array);
            } //End block
            if(object != null)            
            {
for(int i = size - 1;i >= 0;i--)
                {
                    if(object.equals(array[i]))                    
                    {
                        int var865C0C0B4AB0E063E5CAA3387C1A8741_1070565089 = (i);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1304878774 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1304878774;
                    } //End block
                } //End block
            } //End block
            else
            {
for(int i = size - 1;i >= 0;i--)
                {
                    if(array[i] == null)                    
                    {
                        int var865C0C0B4AB0E063E5CAA3387C1A8741_720112067 = (i);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_26121326 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_26121326;
                    } //End block
                } //End block
            } //End block
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1551729751 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_730246591 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_730246591;
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.709 -0400", hash_original_method = "9E49E91DE129681261C3C7642C2D1127", hash_generated_method = "839F5791F7C4ED95C9DF848D87219876")
        @Override
        public ListIterator<E> listIterator() {
            synchronized
(mutex)            {
ListIterator<E> var91E2AA6BDB726F9377DFF156580182C8_448847256 =                 list.listIterator();
                var91E2AA6BDB726F9377DFF156580182C8_448847256.addTaint(taint);
                return var91E2AA6BDB726F9377DFF156580182C8_448847256;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.listIterator();
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.709 -0400", hash_original_method = "70349F3896FC81F4D21A3D35B0C8A4F6", hash_generated_method = "6DA6710853FE165ABCEDA4278BEFEE65")
        @Override
        public ListIterator<E> listIterator(int location) {
            addTaint(location);
            synchronized
(mutex)            {
ListIterator<E> var373790041D3D8DE94D481C14C2F81B97_1821586238 =                 list.listIterator(location);
                var373790041D3D8DE94D481C14C2F81B97_1821586238.addTaint(taint);
                return var373790041D3D8DE94D481C14C2F81B97_1821586238;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.listIterator(location);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.709 -0400", hash_original_method = "D935E09B492D323BEF59297A7648FE48", hash_generated_method = "4D9F7B24F83C3F4063B148F1A09CD7B1")
        @Override
        public E remove(int location) {
            addTaint(location);
            synchronized
(mutex)            {
E varAA5CAFC40D704B2187CD7B19358DE8AF_789798889 =                 list.remove(location);
                varAA5CAFC40D704B2187CD7B19358DE8AF_789798889.addTaint(taint);
                return varAA5CAFC40D704B2187CD7B19358DE8AF_789798889;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.remove(location);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.709 -0400", hash_original_method = "D9730991663FB8C206D80781B7E02750", hash_generated_method = "83727FD49CF4037AE55844307C1CE103")
        @Override
        public E set(int location, E object) {
            addTaint(object.getTaint());
            addTaint(location);
            synchronized
(mutex)            {
E varC7672C8496CFCB1E354FE4F100AFEEF9_1576902716 =                 list.set(location, object);
                varC7672C8496CFCB1E354FE4F100AFEEF9_1576902716.addTaint(taint);
                return varC7672C8496CFCB1E354FE4F100AFEEF9_1576902716;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.set(location, object);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.709 -0400", hash_original_method = "C38F2D62AA6D1EBD255ADC5369CBEC01", hash_generated_method = "5F882D868AC0245D78A2A582CF2AC259")
        @Override
        public List<E> subList(int start, int end) {
            addTaint(end);
            addTaint(start);
            synchronized
(mutex)            {
List<E> var46FC9BA78CD4658D3E3096D9AF06081C_1845511722 =                 new SynchronizedList<E>(list.subList(start, end), mutex);
                var46FC9BA78CD4658D3E3096D9AF06081C_1845511722.addTaint(taint);
                return var46FC9BA78CD4658D3E3096D9AF06081C_1845511722;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedList<E>(list.subList(start, end), mutex);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.710 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "350CD97D03809885CB7561AF44340EC3")
        private void writeObject(ObjectOutputStream stream) throws IOException {
            addTaint(stream.getTaint());
            synchronized
(mutex)            {
                stream.defaultWriteObject();
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //stream.defaultWriteObject();
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.710 -0400", hash_original_method = "172F08E6F2352F1764A4A70C48C6E243", hash_generated_method = "D917FF639D73A35AA5BAFA4F89FE4441")
        private Object readResolve() {
            if(list instanceof RandomAccess)            
            {
Object varA5725D0BED74F1FBCBC581EA89C3A111_2048307648 =                 new SynchronizedRandomAccessList<E>(list, mutex);
                varA5725D0BED74F1FBCBC581EA89C3A111_2048307648.addTaint(taint);
                return varA5725D0BED74F1FBCBC581EA89C3A111_2048307648;
            } //End block
Object var72A74007B2BE62B849F475C7BDA4658B_1782787474 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1782787474.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1782787474;
            // ---------- Original Method ----------
            //if (list instanceof RandomAccess) {
                //return new SynchronizedRandomAccessList<E>(list, mutex);
            //}
            //return this;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.713 -0400", hash_original_field = "8883C8F4886CDFE339069F9C7525453D", hash_generated_field = "5528D904FB3223ACA4EBA912A58AE2BF")

        private static final long serialVersionUID = -7754090372962971524L;
    }


    
    static class SynchronizedMap<K, V> implements Map<K, V>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.713 -0400", hash_original_field = "6F8F57715090DA2632453988D9A1501B", hash_generated_field = "1785B4570966C73126874A8D942D2395")

        private Map<K, V> m;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.713 -0400", hash_original_field = "25A01BB859125507013A2FE9737D3C32", hash_generated_field = "5C5F8780FECE5E612AF5A86D3A8B3194")

        Object mutex;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.714 -0400", hash_original_method = "C14189E3F71A4C148CB91C638F3BAAE3", hash_generated_method = "697756520B6F74069D1E5AA0F6D1C69A")
          SynchronizedMap(Map<K, V> map) {
            m = map;
            mutex = this;
            // ---------- Original Method ----------
            //m = map;
            //mutex = this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.714 -0400", hash_original_method = "6EAD9DD813CFD47244744C3F6D6A4D1C", hash_generated_method = "96BED7921FDC6B114140F51F8F22333E")
          SynchronizedMap(Map<K, V> map, Object mutex) {
            m = map;
            this.mutex = mutex;
            // ---------- Original Method ----------
            //m = map;
            //this.mutex = mutex;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.714 -0400", hash_original_method = "3DCF075501F09300584E40825720BBA2", hash_generated_method = "593287EE6198540DCDECFACB3A2D6C3C")
        @Override
        public void clear() {
            synchronized
(mutex)            {
                m.clear();
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //m.clear();
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.714 -0400", hash_original_method = "D2C67B34100B05197A0572527ECA3220", hash_generated_method = "14594DE10C94AB3156C005F6B065C0AA")
        @Override
        public boolean containsKey(Object key) {
            addTaint(key.getTaint());
            synchronized
(mutex)            {
                boolean var62AFCABB34FB6B56AC689F51EB3A9E27_712160437 = (m.containsKey(key));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1869599556 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1869599556;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.containsKey(key);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.714 -0400", hash_original_method = "FFE2162DB44C1E8BEEAD35935B233C81", hash_generated_method = "7564F17A43E42B221EBCB9DFEB187B03")
        @Override
        public boolean containsValue(Object value) {
            addTaint(value.getTaint());
            synchronized
(mutex)            {
                boolean varD6C1BCF4353E9D47F21CF5A12A4A7A3C_1329451471 = (m.containsValue(value));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1021192588 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1021192588;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.containsValue(value);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.714 -0400", hash_original_method = "E5EA9A3F9567269DAA52E0C08140D3D5", hash_generated_method = "A849171EFFA58F06781B95D03B3AF24E")
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            synchronized
(mutex)            {
Set<Map.Entry<K, V>> var5727BC6642E27AF92618365955C09D10_645081424 =                 new SynchronizedSet<Map.Entry<K, V>>(m.entrySet(), mutex);
                var5727BC6642E27AF92618365955C09D10_645081424.addTaint(taint);
                return var5727BC6642E27AF92618365955C09D10_645081424;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSet<Map.Entry<K, V>>(m.entrySet(), mutex);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.715 -0400", hash_original_method = "573EFA9740FEBDEC9C1CCFD8172CCEF0", hash_generated_method = "9BB3B302BF469E2235CA8EC46B33413B")
        @Override
        public boolean equals(Object object) {
            addTaint(object.getTaint());
            synchronized
(mutex)            {
                boolean var2173C29FE79E34E394A75A59701DB2CC_1804717866 = (m.equals(object));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1168115707 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1168115707;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.equals(object);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.715 -0400", hash_original_method = "80DF7D6FED6980DF61457325CD64503D", hash_generated_method = "0501700BEB29283D9DAF071522D8119E")
        @Override
        public V get(Object key) {
            addTaint(key.getTaint());
            synchronized
(mutex)            {
V var3A7E11B6611BEAA522E24ED974C59715_1325717892 =                 m.get(key);
                var3A7E11B6611BEAA522E24ED974C59715_1325717892.addTaint(taint);
                return var3A7E11B6611BEAA522E24ED974C59715_1325717892;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.get(key);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.715 -0400", hash_original_method = "5DDF560D56DA8F61EEAD582BB150A893", hash_generated_method = "3A9ACFF9BE8E900345EA388512D7012A")
        @Override
        public int hashCode() {
            synchronized
(mutex)            {
                int varE3BA1212D08FEDD275814D3960FD8F10_759013305 = (m.hashCode());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_83835016 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_83835016;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.hashCode();
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.715 -0400", hash_original_method = "40A122CDBD7096230690259CC30A0F7A", hash_generated_method = "A4F038BCE0980D38D69744151FEBF565")
        @Override
        public boolean isEmpty() {
            synchronized
(mutex)            {
                boolean var6FFDB0B6EFF2802DEEBD39B93137FE90_960698018 = (m.isEmpty());
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1169404562 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1169404562;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.isEmpty();
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.716 -0400", hash_original_method = "2FBB6190D51F2A6210F8CF71191E69DD", hash_generated_method = "AFF2CC30ED0E920237ABB506F508B4A5")
        @Override
        public Set<K> keySet() {
            synchronized
(mutex)            {
Set<K> var285F5F6219BDED18A916ADCBF7A0FD1A_2025751712 =                 new SynchronizedSet<K>(m.keySet(), mutex);
                var285F5F6219BDED18A916ADCBF7A0FD1A_2025751712.addTaint(taint);
                return var285F5F6219BDED18A916ADCBF7A0FD1A_2025751712;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSet<K>(m.keySet(), mutex);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.716 -0400", hash_original_method = "4BBBC2EF3E646AB7C0C1BFCAE8571FAF", hash_generated_method = "4FB6FD22FCBEBE6D1FDEF8A31E7ECE3A")
        @Override
        public V put(K key, V value) {
            addTaint(value.getTaint());
            addTaint(key.getTaint());
            synchronized
(mutex)            {
V var065C412EB078CAC7BCF0E1D4C066D348_1396350974 =                 m.put(key, value);
                var065C412EB078CAC7BCF0E1D4C066D348_1396350974.addTaint(taint);
                return var065C412EB078CAC7BCF0E1D4C066D348_1396350974;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.put(key, value);
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.716 -0400", hash_original_method = "400FF0E6707670DAA4FF7ECA275302A3", hash_generated_method = "02E0FA1D3734E664378B37F39C9464E0")
        @Override
        public void putAll(Map<? extends K, ? extends V> map) {
            addTaint(map.getTaint());
            synchronized
(mutex)            {
                m.putAll(map);
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //m.putAll(map);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.716 -0400", hash_original_method = "98B37460DCD5FD18048F5172283C3141", hash_generated_method = "591EBB5D2F05272F50B0A27643599129")
        @Override
        public V remove(Object key) {
            addTaint(key.getTaint());
            synchronized
(mutex)            {
V varCFC4EE21887DEF986B37EBC86595687F_1960922061 =                 m.remove(key);
                varCFC4EE21887DEF986B37EBC86595687F_1960922061.addTaint(taint);
                return varCFC4EE21887DEF986B37EBC86595687F_1960922061;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.remove(key);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.719 -0400", hash_original_method = "A48EE7C65347333E889EFC2ECD0A019A", hash_generated_method = "E30BC2398808B2624895DD3BDE3B54B8")
        @Override
        public int size() {
            synchronized
(mutex)            {
                int var313B2D1C305A713CA398B12007C9967C_465341048 = (m.size());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_850285068 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_850285068;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.size();
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.719 -0400", hash_original_method = "BB797020E54DC33FB15BC9404E89E5CD", hash_generated_method = "B39A35EEA2BC6C3D83B29CA282D3127C")
        @Override
        public Collection<V> values() {
            synchronized
(mutex)            {
Collection<V> varC2AD2DC503BC6B001F17920E86024CF0_1534707480 =                 new SynchronizedCollection<V>(m.values(), mutex);
                varC2AD2DC503BC6B001F17920E86024CF0_1534707480.addTaint(taint);
                return varC2AD2DC503BC6B001F17920E86024CF0_1534707480;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedCollection<V>(m.values(), mutex);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.719 -0400", hash_original_method = "CB61B465EF18C12F472B81636CD4AC79", hash_generated_method = "4AFCF1BFB2770DA4EF3CB3842CE00E1C")
        @Override
        public String toString() {
            synchronized
(mutex)            {
String var8389EA5D3F4E9FD19F68E63143EE799F_223768981 =                 m.toString();
                var8389EA5D3F4E9FD19F68E63143EE799F_223768981.addTaint(taint);
                return var8389EA5D3F4E9FD19F68E63143EE799F_223768981;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.toString();
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.719 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "350CD97D03809885CB7561AF44340EC3")
        private void writeObject(ObjectOutputStream stream) throws IOException {
            addTaint(stream.getTaint());
            synchronized
(mutex)            {
                stream.defaultWriteObject();
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //stream.defaultWriteObject();
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.719 -0400", hash_original_field = "5DC93EB19DFCBC7B8981ED54844A07B4", hash_generated_field = "1DE57645F72579A567941D71223F2BB4")

        private static final long serialVersionUID = 1978198479659022715L;
    }


    
    static class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E> {
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.719 -0400", hash_original_method = "F3863A567ABAC10F9410ABCF2A4DC8AC", hash_generated_method = "B3C414CCF795BDAB85BAEA8F2098B4FB")
          SynchronizedSet(Set<E> set) {
            super(set);
            addTaint(set.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.719 -0400", hash_original_method = "A1BA2E3E145DCA2C522F0AB9439A1572", hash_generated_method = "B6F70866DC85A2FFF9FE5147D21972E9")
          SynchronizedSet(Set<E> set, Object mutex) {
            super(set, mutex);
            addTaint(mutex.getTaint());
            addTaint(set.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.720 -0400", hash_original_method = "E045FF0B832C85F3AF0597463FE3892F", hash_generated_method = "53F479451805304CED7A35AE31225A78")
        @Override
        public boolean equals(Object object) {
            addTaint(object.getTaint());
            synchronized
(mutex)            {
                boolean varAB5EB3EC9A33BCFBC5D0F02B0F8BDEF2_1952067649 = (c.equals(object));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1555455041 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1555455041;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.equals(object);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.720 -0400", hash_original_method = "60CA731F9E7ECB7D3EED20B0D6D4AB09", hash_generated_method = "77641DECB7E1FAD563413DE40774BC17")
        @Override
        public int hashCode() {
            synchronized
(mutex)            {
                int var3FFC490E9FA1D410CC240764C2B77761_1538422119 = (c.hashCode());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_364835140 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_364835140;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.hashCode();
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.720 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "350CD97D03809885CB7561AF44340EC3")
        private void writeObject(ObjectOutputStream stream) throws IOException {
            addTaint(stream.getTaint());
            synchronized
(mutex)            {
                stream.defaultWriteObject();
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //stream.defaultWriteObject();
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.720 -0400", hash_original_field = "916EB185FF2AF0CF7FFC612F07D6DA1B", hash_generated_field = "A77C43308F38D2FC67E81B4E46E8827E")

        private static final long serialVersionUID = 487447009682186044L;
    }


    
    static class SynchronizedSortedMap<K, V> extends SynchronizedMap<K, V> implements SortedMap<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.720 -0400", hash_original_field = "ED79ACB0CD3D7F8320C53C7798335EF0", hash_generated_field = "F813233D7B24D3620137345516D05A23")

        private SortedMap<K, V> sm;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.720 -0400", hash_original_method = "2E0F62BCD34367F1E6E251286E17ABEB", hash_generated_method = "65B92739EACB6292AF1017EE07725F62")
          SynchronizedSortedMap(SortedMap<K, V> map) {
            super(map);
            sm = map;
            // ---------- Original Method ----------
            //sm = map;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.721 -0400", hash_original_method = "5BF33998E3FF0155F7A513C6A201FE85", hash_generated_method = "6296C3605A11681BE962CFBE7273FD54")
          SynchronizedSortedMap(SortedMap<K, V> map, Object mutex) {
            super(map, mutex);
            addTaint(mutex.getTaint());
            sm = map;
            // ---------- Original Method ----------
            //sm = map;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.721 -0400", hash_original_method = "78218A5A359D1FCDF6B98779037FCB94", hash_generated_method = "BA1AD2D583284BF5304A175C0AD71118")
        @Override
        public Comparator<? super K> comparator() {
            synchronized
(mutex)            {
Comparator<? super K> varEAAD6156DF3FBB0DB169CF3701FE5DAA_969255526 =                 sm.comparator();
                varEAAD6156DF3FBB0DB169CF3701FE5DAA_969255526.addTaint(taint);
                return varEAAD6156DF3FBB0DB169CF3701FE5DAA_969255526;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return sm.comparator();
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.721 -0400", hash_original_method = "4A44F83861E496A35113DD67FECD390A", hash_generated_method = "2338D426AC498492331825AD4747E93D")
        @Override
        public K firstKey() {
            synchronized
(mutex)            {
K varA58D1FB276F66FC6ABBF4CA9E354FD1B_1382405129 =                 sm.firstKey();
                varA58D1FB276F66FC6ABBF4CA9E354FD1B_1382405129.addTaint(taint);
                return varA58D1FB276F66FC6ABBF4CA9E354FD1B_1382405129;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return sm.firstKey();
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.721 -0400", hash_original_method = "758EF70CDC2061BD7D7B124D17EF3F64", hash_generated_method = "65EB30DBF5A01F6D20FB1B14EA0ECCC4")
        @Override
        public SortedMap<K, V> headMap(K endKey) {
            addTaint(endKey.getTaint());
            synchronized
(mutex)            {
SortedMap<K, V> varEA0A15A2C4E5A413AF9B3323AD559454_1707638873 =                 new SynchronizedSortedMap<K, V>(sm.headMap(endKey),
                        mutex);
                varEA0A15A2C4E5A413AF9B3323AD559454_1707638873.addTaint(taint);
                return varEA0A15A2C4E5A413AF9B3323AD559454_1707638873;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedMap<K, V>(sm.headMap(endKey),
                        //mutex);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.721 -0400", hash_original_method = "ECB924A52CC9F341D1EEB7E5D7BCCDC8", hash_generated_method = "FF1DD67707DC9B6992B039DB4CE23202")
        @Override
        public K lastKey() {
            synchronized
(mutex)            {
K varC4E8101F3F71352235F4E401D4498536_1302195384 =                 sm.lastKey();
                varC4E8101F3F71352235F4E401D4498536_1302195384.addTaint(taint);
                return varC4E8101F3F71352235F4E401D4498536_1302195384;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return sm.lastKey();
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.724 -0400", hash_original_method = "E82E6227AA62F00EB1D33B47A72F41C4", hash_generated_method = "125CDCBD2E8E3A501BA45ECE7248A61C")
        @Override
        public SortedMap<K, V> subMap(K startKey, K endKey) {
            addTaint(endKey.getTaint());
            addTaint(startKey.getTaint());
            synchronized
(mutex)            {
SortedMap<K, V> var3568402581E0193E041EF3FB853BEAC9_710711460 =                 new SynchronizedSortedMap<K, V>(sm.subMap(startKey,
                        endKey), mutex);
                var3568402581E0193E041EF3FB853BEAC9_710711460.addTaint(taint);
                return var3568402581E0193E041EF3FB853BEAC9_710711460;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedMap<K, V>(sm.subMap(startKey,
                        //endKey), mutex);
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.724 -0400", hash_original_method = "F7B84D714F16D295C7D43C8AA5E52D6A", hash_generated_method = "350FCE6F52B0165D060B4F12E0ED15C0")
        @Override
        public SortedMap<K, V> tailMap(K startKey) {
            addTaint(startKey.getTaint());
            synchronized
(mutex)            {
SortedMap<K, V> var76FD45A0B6EE1B8CC0C79332C3896766_1887335037 =                 new SynchronizedSortedMap<K, V>(sm.tailMap(startKey),
                        mutex);
                var76FD45A0B6EE1B8CC0C79332C3896766_1887335037.addTaint(taint);
                return var76FD45A0B6EE1B8CC0C79332C3896766_1887335037;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedMap<K, V>(sm.tailMap(startKey),
                        //mutex);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.724 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "350CD97D03809885CB7561AF44340EC3")
        private void writeObject(ObjectOutputStream stream) throws IOException {
            addTaint(stream.getTaint());
            synchronized
(mutex)            {
                stream.defaultWriteObject();
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //stream.defaultWriteObject();
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.725 -0400", hash_original_field = "CA84F69F8568978C0AA41949BE696442", hash_generated_field = "ECA677D018A422E9BB2369A5AF38055A")

        private static final long serialVersionUID = -8798146769416483793L;
    }


    
    static class SynchronizedSortedSet<E> extends SynchronizedSet<E> implements SortedSet<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.725 -0400", hash_original_field = "3691308F2A4C2F6983F2880D32E29C84", hash_generated_field = "5220A6F2AA4CB98BB6C290F0BB717E86")

        private SortedSet<E> ss;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.725 -0400", hash_original_method = "B2F0E775DF29B0E6B28447766B0AA532", hash_generated_method = "4CBCB006A0B32CDF41866EAC9A8E2DC9")
          SynchronizedSortedSet(SortedSet<E> set) {
            super(set);
            ss = set;
            // ---------- Original Method ----------
            //ss = set;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.725 -0400", hash_original_method = "46957450EFA60C06BEFC5742F9BFAC78", hash_generated_method = "475CBA9D2152E24CC31AED38CAE99C9B")
          SynchronizedSortedSet(SortedSet<E> set, Object mutex) {
            super(set, mutex);
            addTaint(mutex.getTaint());
            ss = set;
            // ---------- Original Method ----------
            //ss = set;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.725 -0400", hash_original_method = "D71F7DA0E84FA7A091B4017D559410C5", hash_generated_method = "F08FBAB5E89CD501F1619A4FE4BD57C3")
        @Override
        public Comparator<? super E> comparator() {
            synchronized
(mutex)            {
Comparator<? super E> varEF7DDB49085F2DA083783C6BC3481D0B_1121190879 =                 ss.comparator();
                varEF7DDB49085F2DA083783C6BC3481D0B_1121190879.addTaint(taint);
                return varEF7DDB49085F2DA083783C6BC3481D0B_1121190879;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return ss.comparator();
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.725 -0400", hash_original_method = "C2C55C7E331CFDE8E84B8FC74FDABE02", hash_generated_method = "D1740F4486F0AE46C779FAD0EDF07342")
        @Override
        public E first() {
            synchronized
(mutex)            {
E varE64C384BCBD0BF9F8BB2385886B7C815_756868566 =                 ss.first();
                varE64C384BCBD0BF9F8BB2385886B7C815_756868566.addTaint(taint);
                return varE64C384BCBD0BF9F8BB2385886B7C815_756868566;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return ss.first();
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.726 -0400", hash_original_method = "86DA75392AF50D6AE53AEE4A4052EBA8", hash_generated_method = "24D127000B513E6D1D4A7124831C71D8")
        @Override
        public SortedSet<E> headSet(E end) {
            addTaint(end.getTaint());
            synchronized
(mutex)            {
SortedSet<E> var8D088F33247749FC21300B712B62AE16_1068488577 =                 new SynchronizedSortedSet<E>(ss.headSet(end), mutex);
                var8D088F33247749FC21300B712B62AE16_1068488577.addTaint(taint);
                return var8D088F33247749FC21300B712B62AE16_1068488577;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedSet<E>(ss.headSet(end), mutex);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.726 -0400", hash_original_method = "3C10DA3BCCE6BED4EBD1F6A2C6BC8438", hash_generated_method = "EC365CE7B59B9842D7EA9466B770009C")
        @Override
        public E last() {
            synchronized
(mutex)            {
E var7A1B325A772301476E34C1CFA8ED9C89_564864021 =                 ss.last();
                var7A1B325A772301476E34C1CFA8ED9C89_564864021.addTaint(taint);
                return var7A1B325A772301476E34C1CFA8ED9C89_564864021;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return ss.last();
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.726 -0400", hash_original_method = "662A59FFAA1C1722D75A374EC93FB0DF", hash_generated_method = "D2FB3E60710609B389D64D1634C28E31")
        @Override
        public SortedSet<E> subSet(E start, E end) {
            addTaint(end.getTaint());
            addTaint(start.getTaint());
            synchronized
(mutex)            {
SortedSet<E> var5FA0EEEBA5CD2BB13F60BC74D18D4C36_487092198 =                 new SynchronizedSortedSet<E>(ss.subSet(start, end),
                        mutex);
                var5FA0EEEBA5CD2BB13F60BC74D18D4C36_487092198.addTaint(taint);
                return var5FA0EEEBA5CD2BB13F60BC74D18D4C36_487092198;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedSet<E>(ss.subSet(start, end),
                        //mutex);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.726 -0400", hash_original_method = "4C04840896A126B8B17AD8E0926A5B00", hash_generated_method = "07F6824ECF3CEA5849FDA0D62BC1FB4E")
        @Override
        public SortedSet<E> tailSet(E start) {
            addTaint(start.getTaint());
            synchronized
(mutex)            {
SortedSet<E> var6F7D9083A65424D18B09B8597111017E_923391220 =                 new SynchronizedSortedSet<E>(ss.tailSet(start), mutex);
                var6F7D9083A65424D18B09B8597111017E_923391220.addTaint(taint);
                return var6F7D9083A65424D18B09B8597111017E_923391220;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedSet<E>(ss.tailSet(start), mutex);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.726 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "350CD97D03809885CB7561AF44340EC3")
        private void writeObject(ObjectOutputStream stream) throws IOException {
            addTaint(stream.getTaint());
            synchronized
(mutex)            {
                stream.defaultWriteObject();
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //stream.defaultWriteObject();
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.727 -0400", hash_original_field = "7550293A247191A63B69680B8051BA5C", hash_generated_field = "44E22A9B5E1BF0CBC26900B92B680526")

        private static final long serialVersionUID = 8695801310862127406L;
    }


    
    private static class UnmodifiableCollection<E> implements Collection<E>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.727 -0400", hash_original_field = "4A8A08F09D37B73795649038408B5F33", hash_generated_field = "A3C80A7E02E49F20400373DFBAF9696A")

        Collection<E> c;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.727 -0400", hash_original_method = "0B21B3311CB87F81844FA591591A704A", hash_generated_method = "F8A220D652916612975A1BF5C32AE7B2")
          UnmodifiableCollection(Collection<E> collection) {
            c = collection;
            // ---------- Original Method ----------
            //c = collection;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.727 -0400", hash_original_method = "1E7EFCC2BAD401EE702FAECD906F0B57", hash_generated_method = "E96C25819EE135BA1CB880FA2242A911")
        @Override
        public boolean add(E object) {
            addTaint(object.getTaint());
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1073856363 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_1073856363.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_1073856363;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.730 -0400", hash_original_method = "A14B246F22D65FADC1A66C9C0851763B", hash_generated_method = "80D6F41E993284659833E68194DD64E2")
        @Override
        public boolean addAll(Collection<? extends E> collection) {
            addTaint(collection.getTaint());
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_378159507 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_378159507.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_378159507;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.730 -0400", hash_original_method = "C5BE2B5F9D582C4EED1DC0880E8741A1", hash_generated_method = "89BB186C06AFCA7B91AD8ED8455F97B2")
        @Override
        public void clear() {
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_143678270 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_143678270.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_143678270;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.730 -0400", hash_original_method = "9A5FA57B69BAE7BFE0B020704235C788", hash_generated_method = "C112AFDD773B8D9A8878752094DF4411")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            boolean var1AEB72C9D1B87075EB37C6366C13F8DB_1585481049 = (c.contains(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_693777270 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_693777270;
            // ---------- Original Method ----------
            //return c.contains(object);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.731 -0400", hash_original_method = "BD1B4CD05BF6E123B0DC6FD003A6020C", hash_generated_method = "164F4527AA8858983CE951755E420081")
        @Override
        public boolean containsAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            boolean var89744A7A766147F896A88C5E38016080_1941143243 = (c.containsAll(collection));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1592147471 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1592147471;
            // ---------- Original Method ----------
            //return c.containsAll(collection);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.731 -0400", hash_original_method = "F9A3CB1FB7570D28EBE20660E2FC6F42", hash_generated_method = "9EFFDB7F93B2A3B3FC70774A5FCA7A4D")
        @Override
        public boolean isEmpty() {
            boolean var65FAF5A74582A5D73E221DB675503595_1242072604 = (c.isEmpty());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1009429778 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1009429778;
            // ---------- Original Method ----------
            //return c.isEmpty();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.732 -0400", hash_original_method = "57C2B30126E9906DFFF70EEB2D2CD18D", hash_generated_method = "B262D68F3934C177FEAA4645EDB16A1F")
        @Override
        public Iterator<E> iterator() {
Iterator<E> var17584F965577555F1B3BEAB9FFD781E4_1722746458 =             new Iterator<E>() {            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.731 -0400", hash_original_field = "8EFDCD9E60E16BF9DA2CF814FA6A227A", hash_generated_field = "BFAA84E4781D6E7F7943DE789C19AEAB")
            Iterator<E> iterator = c.iterator();
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.731 -0400", hash_original_method = "AA3B17E619A4DDCE5FFF27C1294FF431", hash_generated_method = "61B452FE88E2B53DA264328736C4E75C")
            @Override
            public boolean hasNext() {
                boolean varD6B09E4375C520F8E3C47E2CD37ACCE3_1421180279 = (iterator.hasNext());
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_339903115 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_339903115;
                // ---------- Original Method ----------
                //return iterator.hasNext();
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.731 -0400", hash_original_method = "E4F6FE4F8164B2EF0F004EE03FA1069C", hash_generated_method = "1379AC8E7CA0E95528701719109AF5AB")
            @Override
            public E next() {
E var862BD85102BDD28E8A3902D84E203428_28494495 =                 iterator.next();
                var862BD85102BDD28E8A3902D84E203428_28494495.addTaint(taint);
                return var862BD85102BDD28E8A3902D84E203428_28494495;
                // ---------- Original Method ----------
                //return iterator.next();
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.732 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "1799936A0D60A0FCD61BEE3E705A2583")
            @Override
            public void remove() {
                UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_803291903 = new UnsupportedOperationException();
                var81FA7E299EEE7F062EBFBEEF08B0464D_803291903.addTaint(taint);
                throw var81FA7E299EEE7F062EBFBEEF08B0464D_803291903;
                // ---------- Original Method ----------
                //throw new UnsupportedOperationException();
            }
};
            var17584F965577555F1B3BEAB9FFD781E4_1722746458.addTaint(taint);
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.735 -0400", hash_original_method = "2165C77F20F5DBDDE4D0AED313262684", hash_generated_method = "29D4FAD5F4ADB17279910B70DC47BB6C")
        @Override
        public boolean remove(Object object) {
            addTaint(object.getTaint());
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_602509909 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_602509909.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_602509909;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.735 -0400", hash_original_method = "95D6D7B80D3C762A794FEAFDE42B30FC", hash_generated_method = "4BF2C244984FF41EA1F14B8B24D21044")
        @Override
        public boolean removeAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1157213482 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_1157213482.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_1157213482;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.735 -0400", hash_original_method = "D4789A90B422D35C3FC475A0D6C54BE8", hash_generated_method = "8352437364EBA678F7C9C71255CCC81A")
        @Override
        public boolean retainAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1187573945 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_1187573945.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_1187573945;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.735 -0400", hash_original_method = "AC97C28F724592ABA809E2470D95C119", hash_generated_method = "0D050D1942533993C4E2F47857265E82")
        @Override
        public int size() {
            int varB01543F097DAA850E9B79CBAB9C1B976_259249667 = (c.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_531002610 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_531002610;
            // ---------- Original Method ----------
            //return c.size();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.735 -0400", hash_original_method = "89D7D02A9D2BDF31E775C08108CBDE5B", hash_generated_method = "7C73CBA4F3A7365C0DDC41D76D61E8B2")
        @Override
        public Object[] toArray() {
Object[] var46570412E19D68724A647FAFEECFBF92_941269109 =             c.toArray();
            var46570412E19D68724A647FAFEECFBF92_941269109.addTaint(taint);
            return var46570412E19D68724A647FAFEECFBF92_941269109;
            // ---------- Original Method ----------
            //return c.toArray();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.735 -0400", hash_original_method = "D5913A45F2385B9A173BEEED47EA354F", hash_generated_method = "F6F2B517349AE26404C3A18C39898EBB")
        @Override
        public <T> T[] toArray(T[] array) {
            addTaint(array[0].getTaint());
T[] varA824E05E0FA0C1B35EB9A8324FF1796D_1507973265 =             c.toArray(array);
            varA824E05E0FA0C1B35EB9A8324FF1796D_1507973265.addTaint(taint);
            return varA824E05E0FA0C1B35EB9A8324FF1796D_1507973265;
            // ---------- Original Method ----------
            //return c.toArray(array);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.735 -0400", hash_original_method = "424D4966F358AE6553349A6493C21674", hash_generated_method = "1FDB78D15533F0B07984F6A004F1C52F")
        @Override
        public String toString() {
String var7F88C51BB16CD8992026056598815CC9_1170159354 =             c.toString();
            var7F88C51BB16CD8992026056598815CC9_1170159354.addTaint(taint);
            return var7F88C51BB16CD8992026056598815CC9_1170159354;
            // ---------- Original Method ----------
            //return c.toString();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.735 -0400", hash_original_field = "BF3B1BE107A3BC6EF3F11D547E97ECD3", hash_generated_field = "ED589FB504EC70A2532C4CA52BA9C8D0")

        private static final long serialVersionUID = 1820017752578914078L;
    }


    
    private static class UnmodifiableRandomAccessList<E> extends UnmodifiableList<E> implements RandomAccess {
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.736 -0400", hash_original_method = "0A20B358F7BA1E60AD6DE80ADB85C324", hash_generated_method = "205D9E6E7A9FC9AE79599882AC59F3B2")
          UnmodifiableRandomAccessList(List<E> l) {
            super(l);
            addTaint(l.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.736 -0400", hash_original_method = "BFD692E8EF2A50E82DD6BA0EC7051578", hash_generated_method = "1FB188F9B3F02D495A441ECBEF1B0D19")
        @Override
        public List<E> subList(int start, int end) {
            addTaint(end);
            addTaint(start);
List<E> varBA808AAB260B23150BE108CC34C64548_232408560 =             new UnmodifiableRandomAccessList<E>(list.subList(start, end));
            varBA808AAB260B23150BE108CC34C64548_232408560.addTaint(taint);
            return varBA808AAB260B23150BE108CC34C64548_232408560;
            // ---------- Original Method ----------
            //return new UnmodifiableRandomAccessList<E>(list.subList(start, end));
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.736 -0400", hash_original_method = "C39E6F512687738DD8D987CDE63A2838", hash_generated_method = "64AAE86A1F1D78D605C8AB1B8D900EC6")
        private Object writeReplace() {
Object var49FE19F72A72127942299509E99152D2_1212784955 =             new UnmodifiableList<E>(list);
            var49FE19F72A72127942299509E99152D2_1212784955.addTaint(taint);
            return var49FE19F72A72127942299509E99152D2_1212784955;
            // ---------- Original Method ----------
            //return new UnmodifiableList<E>(list);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.736 -0400", hash_original_field = "70DB59789BD14A138F9B12A5CF11EB14", hash_generated_field = "871EA319ACA4D6DBFD800453B4F24DBA")

        private static final long serialVersionUID = -2542308836966382001L;
    }


    
    private static class UnmodifiableList<E> extends UnmodifiableCollection<E> implements List<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.736 -0400", hash_original_field = "10AE9FC7D453B0DD525D0EDF2EDE7961", hash_generated_field = "1ECA8D0C53ED31C6D874046BB18C0645")

        List<E> list;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.736 -0400", hash_original_method = "4CB96388E36B825DE711E2E59A893E0D", hash_generated_method = "51986B2400081BEED0D63B6036986FF3")
          UnmodifiableList(List<E> l) {
            super(l);
            list = l;
            // ---------- Original Method ----------
            //list = l;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.736 -0400", hash_original_method = "CE54A57EF9628E9FD413F964E9F93054", hash_generated_method = "6FAFF815A037654EB8BB30F2A1A2160D")
        @Override
        public void add(int location, E object) {
            addTaint(object.getTaint());
            addTaint(location);
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_817048974 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_817048974.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_817048974;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.736 -0400", hash_original_method = "6CD19404B4901DECE5B6F72EB7D0CD8F", hash_generated_method = "0E62497F726FF5A01DDA48865C9D3E63")
        @Override
        public boolean addAll(int location, Collection<? extends E> collection) {
            addTaint(collection.getTaint());
            addTaint(location);
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_2135230045 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_2135230045.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_2135230045;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.736 -0400", hash_original_method = "C3C1892342CAEB152D9191558B893ACD", hash_generated_method = "9D99C584559181B5DC3D8DF7C5D84501")
        @Override
        public boolean equals(Object object) {
            addTaint(object.getTaint());
            boolean var3031446AD6BFF612C63BB52505A53EB2_694265550 = (list.equals(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_191728034 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_191728034;
            // ---------- Original Method ----------
            //return list.equals(object);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.737 -0400", hash_original_method = "DFB24286AA0C5C6BF58031CA4ED7CDCB", hash_generated_method = "EE8C498C8E5B5CAF83C2AA93AA73443C")
        @Override
        public E get(int location) {
            addTaint(location);
E var4DE8B026CD0A7863FB8A32177D5AA64A_1792988359 =             list.get(location);
            var4DE8B026CD0A7863FB8A32177D5AA64A_1792988359.addTaint(taint);
            return var4DE8B026CD0A7863FB8A32177D5AA64A_1792988359;
            // ---------- Original Method ----------
            //return list.get(location);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.738 -0400", hash_original_method = "8FDA3E2E38E99F5D6FC34E94E92E953F", hash_generated_method = "B5E46D931DD6EC3F7323D447840FAE30")
        @Override
        public int hashCode() {
            int varE2167E8879221CB1AE58F4BC195DE759_1642397272 = (list.hashCode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1772709449 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1772709449;
            // ---------- Original Method ----------
            //return list.hashCode();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.738 -0400", hash_original_method = "E8AAF2C874038C363BF8C80F2A4ED8F2", hash_generated_method = "198ED754991E582ABE43BA0B344CB8E4")
        @Override
        public int indexOf(Object object) {
            addTaint(object.getTaint());
            int var58D9FF43F4C251B9AED86186A326AAC3_999191411 = (list.indexOf(object));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1463919383 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1463919383;
            // ---------- Original Method ----------
            //return list.indexOf(object);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.738 -0400", hash_original_method = "658C7926C6DFF1B86F4D9B6B0E3F5BBD", hash_generated_method = "572050AD7F6CE35E40239B35B2525A2F")
        @Override
        public int lastIndexOf(Object object) {
            addTaint(object.getTaint());
            int var967566C6740C482F2073B67DA9C60440_539280233 = (list.lastIndexOf(object));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_720188610 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_720188610;
            // ---------- Original Method ----------
            //return list.lastIndexOf(object);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.738 -0400", hash_original_method = "DF7BE0B13ABC5A9B1C74313BD06FB64C", hash_generated_method = "7B5944A476995F1923E213EA4C244FF5")
        @Override
        public ListIterator<E> listIterator() {
ListIterator<E> var68247D54D1DDB9E66659394CC1668C3F_1140878997 =             listIterator(0);
            var68247D54D1DDB9E66659394CC1668C3F_1140878997.addTaint(taint);
            return var68247D54D1DDB9E66659394CC1668C3F_1140878997;
            // ---------- Original Method ----------
            //return listIterator(0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.751 -0400", hash_original_method = "1D0E6831E50FA8995D23240A6E091C82", hash_generated_method = "685CD7A900A8299B727471C10D97D42A")
        @Override
        public ListIterator<E> listIterator(final int location) {
            addTaint(location);
ListIterator<E> var69CB1B11F3ED0B0F805A4D48ECD2D84F_44794926 =             new ListIterator<E>() {            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.738 -0400", hash_original_field = "7CD65118F3CDA81C86B2D3C9CB7B6B0C", hash_generated_field = "3511DBB9873C9158ABE706F9AEA2F24A")
            ListIterator<E> iterator = list.listIterator(location);
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.739 -0400", hash_original_method = "960DAE05B3D69FE5F79E9628DB5B33E6", hash_generated_method = "8B03C96520DB33C498C5D7EFFC9020E9")
            @Override
            public void add(E object) {
                addTaint(object.getTaint());
                UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_466210049 = new UnsupportedOperationException();
                var81FA7E299EEE7F062EBFBEEF08B0464D_466210049.addTaint(taint);
                throw var81FA7E299EEE7F062EBFBEEF08B0464D_466210049;
                // ---------- Original Method ----------
                //throw new UnsupportedOperationException();
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.739 -0400", hash_original_method = "AA3B17E619A4DDCE5FFF27C1294FF431", hash_generated_method = "7DFF87F70712B3934D1337A001FA46EE")
            @Override
            public boolean hasNext() {
                boolean varD6B09E4375C520F8E3C47E2CD37ACCE3_59246464 = (iterator.hasNext());
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_657891769 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_657891769;
                // ---------- Original Method ----------
                //return iterator.hasNext();
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.739 -0400", hash_original_method = "6C308ED658D3F7DABB0C5BB5EC622D45", hash_generated_method = "351890C155A901122D236C15D5A49332")
            @Override
            public boolean hasPrevious() {
                boolean var1D9DFEF96F49CEE08EA58E8770A1457E_1651649163 = (iterator.hasPrevious());
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1159602045 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1159602045;
                // ---------- Original Method ----------
                //return iterator.hasPrevious();
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.739 -0400", hash_original_method = "E4F6FE4F8164B2EF0F004EE03FA1069C", hash_generated_method = "B67ADE2EE6FF512132D0D06E4192095A")
            @Override
            public E next() {
E var862BD85102BDD28E8A3902D84E203428_986328006 =                 iterator.next();
                var862BD85102BDD28E8A3902D84E203428_986328006.addTaint(taint);
                return var862BD85102BDD28E8A3902D84E203428_986328006;
                // ---------- Original Method ----------
                //return iterator.next();
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.751 -0400", hash_original_method = "966AADF518643C3720C5A10EB9E91B73", hash_generated_method = "AA89C07F18AE9B5E587A599EC94355DF")
            @Override
            public int nextIndex() {
                int var12CE9DD76E6F4194F341429D42990C03_1279202303 = (iterator.nextIndex());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_800081253 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_800081253;
                // ---------- Original Method ----------
                //return iterator.nextIndex();
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.751 -0400", hash_original_method = "AEA372ED9A2A3ECAEDCF64AE3E3251E3", hash_generated_method = "1AC81D2795E07EF1BF706AACAD074F47")
            @Override
            public E previous() {
E var31413FEE771C499A1C4BF17C156DB014_2022211192 =                 iterator.previous();
                var31413FEE771C499A1C4BF17C156DB014_2022211192.addTaint(taint);
                return var31413FEE771C499A1C4BF17C156DB014_2022211192;
                // ---------- Original Method ----------
                //return iterator.previous();
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.751 -0400", hash_original_method = "4F453E1B19F3569A7CE9D88D231730E4", hash_generated_method = "5CEDFF91E1311BC784C1027073521E2F")
            @Override
            public int previousIndex() {
                int varB2E4AE1C39C71EE7202B8000B21579AF_1760172313 = (iterator.previousIndex());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_704530010 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_704530010;
                // ---------- Original Method ----------
                //return iterator.previousIndex();
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.751 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "8A36645F0DF4FC521A2AAA813831D40A")
            @Override
            public void remove() {
                UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_342406479 = new UnsupportedOperationException();
                var81FA7E299EEE7F062EBFBEEF08B0464D_342406479.addTaint(taint);
                throw var81FA7E299EEE7F062EBFBEEF08B0464D_342406479;
                // ---------- Original Method ----------
                //throw new UnsupportedOperationException();
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.751 -0400", hash_original_method = "1001E1C2B2FD09C7DE97126421AC0A91", hash_generated_method = "F8ABC1FC228F3BA982AD3C7C07606FE2")
            @Override
            public void set(E object) {
                addTaint(object.getTaint());
                UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1239772105 = new UnsupportedOperationException();
                var81FA7E299EEE7F062EBFBEEF08B0464D_1239772105.addTaint(taint);
                throw var81FA7E299EEE7F062EBFBEEF08B0464D_1239772105;
                // ---------- Original Method ----------
                //throw new UnsupportedOperationException();
            }
};
            var69CB1B11F3ED0B0F805A4D48ECD2D84F_44794926.addTaint(taint);
            return var69CB1B11F3ED0B0F805A4D48ECD2D84F_44794926;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.751 -0400", hash_original_method = "5388D372D048D053ADD084F02A9C1484", hash_generated_method = "BFD32AFF5545E116D899BC9BDE8EACD0")
        @Override
        public E remove(int location) {
            addTaint(location);
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_369589180 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_369589180.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_369589180;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.752 -0400", hash_original_method = "8830E2F07CC294339D5D496574BCFA5E", hash_generated_method = "9B856F5787849C9957B25D2B5BB2F8D4")
        @Override
        public E set(int location, E object) {
            addTaint(object.getTaint());
            addTaint(location);
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1556303158 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_1556303158.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_1556303158;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.752 -0400", hash_original_method = "82D78FB8922B9A0888EF8A304898D60D", hash_generated_method = "4D644052B3BAA3A7CD1FBAD85025C104")
        @Override
        public List<E> subList(int start, int end) {
            addTaint(end);
            addTaint(start);
List<E> varADECA7016C61BEC124377A2945128243_66833490 =             new UnmodifiableList<E>(list.subList(start, end));
            varADECA7016C61BEC124377A2945128243_66833490.addTaint(taint);
            return varADECA7016C61BEC124377A2945128243_66833490;
            // ---------- Original Method ----------
            //return new UnmodifiableList<E>(list.subList(start, end));
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.752 -0400", hash_original_method = "5F3DDA40E6BDC67502A2E43BA75DBB15", hash_generated_method = "AAA08931C5127FE348601A70E027DF82")
        private Object readResolve() {
            if(list instanceof RandomAccess)            
            {
Object var8D8AD294B7DD22470EF7FD69FA78ABA2_1314513296 =                 new UnmodifiableRandomAccessList<E>(list);
                var8D8AD294B7DD22470EF7FD69FA78ABA2_1314513296.addTaint(taint);
                return var8D8AD294B7DD22470EF7FD69FA78ABA2_1314513296;
            } //End block
Object var72A74007B2BE62B849F475C7BDA4658B_953277828 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_953277828.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_953277828;
            // ---------- Original Method ----------
            //if (list instanceof RandomAccess) {
                //return new UnmodifiableRandomAccessList<E>(list);
            //}
            //return this;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.752 -0400", hash_original_field = "69FDA83BF467A43A3D5BCAA929D897B3", hash_generated_field = "F0F0F0942F5CE1242FD2AB85FF483C32")

        private static final long serialVersionUID = -283967356065247728L;
    }


    
    private static class UnmodifiableMap<K, V> implements Map<K, V>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.752 -0400", hash_original_field = "6F8F57715090DA2632453988D9A1501B", hash_generated_field = "1785B4570966C73126874A8D942D2395")

        private Map<K, V> m;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.752 -0400", hash_original_method = "74C4A0289A3E9196E4EF75F76384A7D2", hash_generated_method = "DA7567E66A4C382E1EF89234BCC9D997")
          UnmodifiableMap(Map<K, V> map) {
            m = map;
            // ---------- Original Method ----------
            //m = map;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.752 -0400", hash_original_method = "C5BE2B5F9D582C4EED1DC0880E8741A1", hash_generated_method = "6A3DBAEE0EAF4F652EB00971CDBBD65C")
        @Override
        public void clear() {
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_720281312 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_720281312.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_720281312;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.753 -0400", hash_original_method = "A6C730848D8A626F99D8229EE744E3C0", hash_generated_method = "2451CA28A0F5A3F85B6A8C73BDA450FA")
        @Override
        public boolean containsKey(Object key) {
            addTaint(key.getTaint());
            boolean var62AFCABB34FB6B56AC689F51EB3A9E27_1462023997 = (m.containsKey(key));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_682978428 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_682978428;
            // ---------- Original Method ----------
            //return m.containsKey(key);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.753 -0400", hash_original_method = "EF8C00CF950E8C186D2F05E1E556F384", hash_generated_method = "3B6693F53EF7AB3E0D5E8759FEA8437C")
        @Override
        public boolean containsValue(Object value) {
            addTaint(value.getTaint());
            boolean varD6C1BCF4353E9D47F21CF5A12A4A7A3C_1827196026 = (m.containsValue(value));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1659419744 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1659419744;
            // ---------- Original Method ----------
            //return m.containsValue(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.753 -0400", hash_original_method = "FB0DE15DA25D3994421C9FBDD1812EDD", hash_generated_method = "4C8869CD78EDAB65CBF45B98903CB104")
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
Set<Map.Entry<K, V>> var609ADEC567CF772927A2504C9FEB51A9_1064808319 =             new UnmodifiableEntrySet<K, V>(m.entrySet());
            var609ADEC567CF772927A2504C9FEB51A9_1064808319.addTaint(taint);
            return var609ADEC567CF772927A2504C9FEB51A9_1064808319;
            // ---------- Original Method ----------
            //return new UnmodifiableEntrySet<K, V>(m.entrySet());
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.753 -0400", hash_original_method = "CE201E78EAC5D1903F741160CB297EAE", hash_generated_method = "B9559A16890F689518430E15C9AD8160")
        @Override
        public boolean equals(Object object) {
            addTaint(object.getTaint());
            boolean var2173C29FE79E34E394A75A59701DB2CC_765960118 = (m.equals(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_784981357 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_784981357;
            // ---------- Original Method ----------
            //return m.equals(object);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.753 -0400", hash_original_method = "B8FE254B61C57EC3A6DCE539976DA268", hash_generated_method = "3FCD6A9DEDB853DDD86F089623136DA4")
        @Override
        public V get(Object key) {
            addTaint(key.getTaint());
V var3A7E11B6611BEAA522E24ED974C59715_2140404626 =             m.get(key);
            var3A7E11B6611BEAA522E24ED974C59715_2140404626.addTaint(taint);
            return var3A7E11B6611BEAA522E24ED974C59715_2140404626;
            // ---------- Original Method ----------
            //return m.get(key);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.753 -0400", hash_original_method = "E3229E3389F030DD50B79734943DB788", hash_generated_method = "72D8CB775288963D6254A9912272C25E")
        @Override
        public int hashCode() {
            int varE3BA1212D08FEDD275814D3960FD8F10_467746570 = (m.hashCode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1118457995 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1118457995;
            // ---------- Original Method ----------
            //return m.hashCode();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.754 -0400", hash_original_method = "B9E63D3C52241E7E917CB1416ABA36E5", hash_generated_method = "26323ACFAA53950AB1599DC38DE0572C")
        @Override
        public boolean isEmpty() {
            boolean var6FFDB0B6EFF2802DEEBD39B93137FE90_1623841325 = (m.isEmpty());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_122941882 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_122941882;
            // ---------- Original Method ----------
            //return m.isEmpty();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.754 -0400", hash_original_method = "2CC049F262DAAA6660AF161E9C8606F6", hash_generated_method = "15250C08B99FE0A17A6976733C8DE624")
        @Override
        public Set<K> keySet() {
Set<K> var4B8E49910ECC42FB2E6ACB972650B96D_238760514 =             new UnmodifiableSet<K>(m.keySet());
            var4B8E49910ECC42FB2E6ACB972650B96D_238760514.addTaint(taint);
            return var4B8E49910ECC42FB2E6ACB972650B96D_238760514;
            // ---------- Original Method ----------
            //return new UnmodifiableSet<K>(m.keySet());
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.754 -0400", hash_original_method = "1AE25A34BEB4A8F08F41373ADFFCFE34", hash_generated_method = "54F5BD81F18F75883C151DE9A86D1D68")
        @Override
        public V put(K key, V value) {
            addTaint(value.getTaint());
            addTaint(key.getTaint());
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1652085161 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_1652085161.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_1652085161;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.754 -0400", hash_original_method = "1D605566C28BBD06FDC515389557B406", hash_generated_method = "11C37ED810FBC9B142F50F35C264D4B8")
        @Override
        public void putAll(Map<? extends K, ? extends V> map) {
            addTaint(map.getTaint());
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1523950078 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_1523950078.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_1523950078;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.754 -0400", hash_original_method = "1F8D4C123F3DDBF68E61E38EDB13F5FB", hash_generated_method = "B90534DE76EAA9DE89E40B4C9C44914D")
        @Override
        public V remove(Object key) {
            addTaint(key.getTaint());
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_776996840 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_776996840.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_776996840;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.754 -0400", hash_original_method = "A04EE09DEB6F21FAA6A7E10DF6401CD1", hash_generated_method = "61468B8B4A71E604E7B45DE64FA889FF")
        @Override
        public int size() {
            int var313B2D1C305A713CA398B12007C9967C_1359944086 = (m.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1737672235 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1737672235;
            // ---------- Original Method ----------
            //return m.size();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.754 -0400", hash_original_method = "19DD84E0D2EBBBC2FCDA12D023824450", hash_generated_method = "E44E929FAAFC276AB6B8E9739E57DE03")
        @Override
        public Collection<V> values() {
Collection<V> varAAA3B7F2BB8B957714BF1B9640B66E8A_1114410851 =             new UnmodifiableCollection<V>(m.values());
            varAAA3B7F2BB8B957714BF1B9640B66E8A_1114410851.addTaint(taint);
            return varAAA3B7F2BB8B957714BF1B9640B66E8A_1114410851;
            // ---------- Original Method ----------
            //return new UnmodifiableCollection<V>(m.values());
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.754 -0400", hash_original_method = "5DD44B3CD2826BF39F974F66579CF74F", hash_generated_method = "24AF35686D22596D05151AA9B69EC711")
        @Override
        public String toString() {
String var8389EA5D3F4E9FD19F68E63143EE799F_163713358 =             m.toString();
            var8389EA5D3F4E9FD19F68E63143EE799F_163713358.addTaint(taint);
            return var8389EA5D3F4E9FD19F68E63143EE799F_163713358;
            // ---------- Original Method ----------
            //return m.toString();
        }

        
        private static class UnmodifiableEntrySet<K, V> extends UnmodifiableSet<Map.Entry<K, V>> {
            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.754 -0400", hash_original_method = "211DEE98878E4422E2F38E79CDC5F0D4", hash_generated_method = "E5E05A5D1E2777C870B2B3DCCCA2A2BD")
              UnmodifiableEntrySet(Set<Map.Entry<K, V>> set) {
                super(set);
                addTaint(set.getTaint());
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.755 -0400", hash_original_method = "53A7F61EDA7A64FBCB28AE61A8906002", hash_generated_method = "67993FFD84C85C04B894A8095882D351")
            @Override
            public Iterator<Map.Entry<K, V>> iterator() {
Iterator<Map.Entry<K, V>> var95D309287220EAC9AA0261E09FAD4D41_1872266644 =                 new Iterator<Map.Entry<K, V>>() {                @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.755 -0400", hash_original_field = "8EFDCD9E60E16BF9DA2CF814FA6A227A", hash_generated_field = "5453FE1747389AC528B71FA32FDEB84E")
                Iterator<Map.Entry<K, V>> iterator = c.iterator();
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.755 -0400", hash_original_method = "AA3B17E619A4DDCE5FFF27C1294FF431", hash_generated_method = "790B8EF54A092AB0CB166BE909AE45ED")
                @Override
                public boolean hasNext() {
                    boolean varD6B09E4375C520F8E3C47E2CD37ACCE3_1869921335 = (iterator.hasNext());
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_222983436 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_222983436;
                    // ---------- Original Method ----------
                    //return iterator.hasNext();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.755 -0400", hash_original_method = "EEF2AC3DD179F17AE4AC144ABD5D488C", hash_generated_method = "CB4213BC0043596BE2DE7AF0846AAC88")
                @Override
                public Map.Entry<K, V> next() {
Map.Entry<K, V> var42E2F932C8AFB71AAEEE9BC7765782DF_939717901 =                     new UnmodifiableMapEntry<K, V>(iterator.next());
                    var42E2F932C8AFB71AAEEE9BC7765782DF_939717901.addTaint(taint);
                    return var42E2F932C8AFB71AAEEE9BC7765782DF_939717901;
                    // ---------- Original Method ----------
                    //return new UnmodifiableMapEntry<K, V>(iterator.next());
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.755 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "9EF62F93497CEB9E5F1598F4DD8D863E")
                @Override
                public void remove() {
                    UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1165628562 = new UnsupportedOperationException();
                    var81FA7E299EEE7F062EBFBEEF08B0464D_1165628562.addTaint(taint);
                    throw var81FA7E299EEE7F062EBFBEEF08B0464D_1165628562;
                    // ---------- Original Method ----------
                    //throw new UnsupportedOperationException();
                }
};
                var95D309287220EAC9AA0261E09FAD4D41_1872266644.addTaint(taint);
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

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.755 -0400", hash_original_method = "C353E5DD4879B90DAE1A37DDC4A8ED8C", hash_generated_method = "70153BC72EF249BF79D22C13942CD4ED")
            @Override
            public Object[] toArray() {
                int length = c.size();
                Object[] result = new Object[length];
                Iterator<?> it = iterator();
for(int i = length;--i >= 0;)
                {
                    result[i] = it.next();
                } //End block
Object[] varDC838461EE2FA0CA4C9BBB70A15456B0_706682712 =                 result;
                varDC838461EE2FA0CA4C9BBB70A15456B0_706682712.addTaint(taint);
                return varDC838461EE2FA0CA4C9BBB70A15456B0_706682712;
                // ---------- Original Method ----------
                //int length = c.size();
                //Object[] result = new Object[length];
                //Iterator<?> it = iterator();
                //for (int i = length; --i >= 0;) {
                    //result[i] = it.next();
                //}
                //return result;
            }

            
                        @DSModeled(DSC.SAFE)
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
                var5DC9C33EDB9F81CF1216538024B770BE_1421244130.addTaint(taint);
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

            
            private static class UnmodifiableMapEntry<K, V> implements Map.Entry<K, V> {
                @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.760 -0400", hash_original_field = "5B2F0A0A5E89589F62B233C643034719", hash_generated_field = "24589B068FBC99F8ED52DE988ED39319")

                Map.Entry<K, V> mapEntry;
                
                @DSModeled(DSC.SAFE)
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.760 -0400", hash_original_method = "E37A4627FD27E632126EED134E00D831", hash_generated_method = "A97AFE882B9E93ECA34E23B05853DCFA")
                  UnmodifiableMapEntry(Map.Entry<K, V> entry) {
                    mapEntry = entry;
                    // ---------- Original Method ----------
                    //mapEntry = entry;
                }

                
                                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.760 -0400", hash_original_method = "90F914E663E54C2DC9846974DAA2EFB8", hash_generated_method = "285AA6B276A319A39A076447F493A975")
                @Override
                public boolean equals(Object object) {
                    addTaint(object.getTaint());
                    boolean var068C627FA27B72D49071EFF9531EDD5F_1915215222 = (mapEntry.equals(object));
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1763007477 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1763007477;
                    // ---------- Original Method ----------
                    //return mapEntry.equals(object);
                }

                
                                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.761 -0400", hash_original_method = "4DDB57034C15C2636BC5A8AFB2B3C75A", hash_generated_method = "FFB395F279882748E6E7F4922F29CC71")
                @Override
                public K getKey() {
K var1266DB74D74FC0AA9813C1E4FD8E44C9_1484210817 =                     mapEntry.getKey();
                    var1266DB74D74FC0AA9813C1E4FD8E44C9_1484210817.addTaint(taint);
                    return var1266DB74D74FC0AA9813C1E4FD8E44C9_1484210817;
                    // ---------- Original Method ----------
                    //return mapEntry.getKey();
                }

                
                                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.761 -0400", hash_original_method = "EA1063FCD9D2F699A9610E0A7FDC81FD", hash_generated_method = "BFD3ACFD67D25956899BDDCFE1E6637D")
                @Override
                public V getValue() {
V var1ECA470EE2F8D5500CEEBF3F98E35CB6_602297793 =                     mapEntry.getValue();
                    var1ECA470EE2F8D5500CEEBF3F98E35CB6_602297793.addTaint(taint);
                    return var1ECA470EE2F8D5500CEEBF3F98E35CB6_602297793;
                    // ---------- Original Method ----------
                    //return mapEntry.getValue();
                }

                
                                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.761 -0400", hash_original_method = "8A31FFFC42BCA6E359386EC1F8534D45", hash_generated_method = "47EFC37E30BECD93573481AA87312987")
                @Override
                public int hashCode() {
                    int var299BCBC4254A420D4D2C42119709A73C_2063893761 = (mapEntry.hashCode());
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2117007945 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2117007945;
                    // ---------- Original Method ----------
                    //return mapEntry.hashCode();
                }

                
                                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.761 -0400", hash_original_method = "3526712C126765AF36CB8D920CBD3B1B", hash_generated_method = "ACB2736E5ADF7C215CC268FEB4907827")
                @Override
                public V setValue(V object) {
                    addTaint(object.getTaint());
                    UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_937392558 = new UnsupportedOperationException();
                    var81FA7E299EEE7F062EBFBEEF08B0464D_937392558.addTaint(taint);
                    throw var81FA7E299EEE7F062EBFBEEF08B0464D_937392558;
                    // ---------- Original Method ----------
                    //throw new UnsupportedOperationException();
                }

                
                                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.761 -0400", hash_original_method = "514C7E8B8C54DBFDFB3E185BADD6AD0A", hash_generated_method = "3990C726194680D3F8E43E22247C1E48")
                @Override
                public String toString() {
String varDD6ECDB9CC96346AAAE786051DD41EF3_1678315505 =                     mapEntry.toString();
                    varDD6ECDB9CC96346AAAE786051DD41EF3_1678315505.addTaint(taint);
                    return varDD6ECDB9CC96346AAAE786051DD41EF3_1678315505;
                    // ---------- Original Method ----------
                    //return mapEntry.toString();
                }

                
            }


            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.762 -0400", hash_original_field = "B44292591B716EDD855C6E185A9AC989", hash_generated_field = "12B2F4473571AB0F630FC68FA4B581F0")

            private static final long serialVersionUID = 7854390611657943733L;
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.762 -0400", hash_original_field = "5569682F9E1154F1C678E958FEEE9E89", hash_generated_field = "FFB33DF33FB47F4C6369B7156E5B3319")

        private static final long serialVersionUID = -1034234728574286014L;
    }


    
    private static class UnmodifiableSet<E> extends UnmodifiableCollection<E> implements Set<E> {
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.762 -0400", hash_original_method = "D46A71F25EF02541A08678630568218D", hash_generated_method = "DBD124D7730B2343640D7C872444495D")
          UnmodifiableSet(Set<E> set) {
            super(set);
            addTaint(set.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.762 -0400", hash_original_method = "BB8664F3F5CB90AA83689CAADCD9EA6B", hash_generated_method = "2DAD44D57A02F21DDFB313B34390CEDD")
        @Override
        public boolean equals(Object object) {
            addTaint(object.getTaint());
            boolean varAB5EB3EC9A33BCFBC5D0F02B0F8BDEF2_1900062618 = (c.equals(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1008149057 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1008149057;
            // ---------- Original Method ----------
            //return c.equals(object);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.762 -0400", hash_original_method = "E858D80F3EEDE9F2B52CDB7DA7FBF12B", hash_generated_method = "62C345AECBD6903DBDB8C10B78391AA3")
        @Override
        public int hashCode() {
            int var3FFC490E9FA1D410CC240764C2B77761_775217255 = (c.hashCode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_918766829 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_918766829;
            // ---------- Original Method ----------
            //return c.hashCode();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.762 -0400", hash_original_field = "F3BE7D79D6D6372B9FD4F3861D721F88", hash_generated_field = "E7C72ADB8696D042D902371BEB24646C")

        private static final long serialVersionUID = -9215047833775013803L;
    }


    
    private static class UnmodifiableSortedMap<K, V> extends UnmodifiableMap<K, V> implements SortedMap<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.762 -0400", hash_original_field = "ED79ACB0CD3D7F8320C53C7798335EF0", hash_generated_field = "F813233D7B24D3620137345516D05A23")

        private SortedMap<K, V> sm;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.762 -0400", hash_original_method = "AC9FE01B421B1E54651959AD61521CA6", hash_generated_method = "FE478A77C43C9AB097C4727B1013B70C")
          UnmodifiableSortedMap(SortedMap<K, V> map) {
            super(map);
            sm = map;
            // ---------- Original Method ----------
            //sm = map;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.762 -0400", hash_original_method = "E5FDBCC6560BE7E99B2D2F850BD84149", hash_generated_method = "02DD1E4907902189E239BF84B627E08D")
        @Override
        public Comparator<? super K> comparator() {
Comparator<? super K> varEAAD6156DF3FBB0DB169CF3701FE5DAA_605748996 =             sm.comparator();
            varEAAD6156DF3FBB0DB169CF3701FE5DAA_605748996.addTaint(taint);
            return varEAAD6156DF3FBB0DB169CF3701FE5DAA_605748996;
            // ---------- Original Method ----------
            //return sm.comparator();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.763 -0400", hash_original_method = "B25E8C7440C76FBF812FF7AC9CA9D776", hash_generated_method = "465FF723C8B2CF518D90A4DAC9D90F4F")
        @Override
        public K firstKey() {
K varA58D1FB276F66FC6ABBF4CA9E354FD1B_122706290 =             sm.firstKey();
            varA58D1FB276F66FC6ABBF4CA9E354FD1B_122706290.addTaint(taint);
            return varA58D1FB276F66FC6ABBF4CA9E354FD1B_122706290;
            // ---------- Original Method ----------
            //return sm.firstKey();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.766 -0400", hash_original_method = "EC6243B190269A05D31802D1260652E4", hash_generated_method = "B39BFCCDBF3E73E16E4776F433908625")
        @Override
        public SortedMap<K, V> headMap(K before) {
            addTaint(before.getTaint());
SortedMap<K, V> var9E05A628EDAD674D5AC9E22861CB1AAB_1925857819 =             new UnmodifiableSortedMap<K, V>(sm.headMap(before));
            var9E05A628EDAD674D5AC9E22861CB1AAB_1925857819.addTaint(taint);
            return var9E05A628EDAD674D5AC9E22861CB1AAB_1925857819;
            // ---------- Original Method ----------
            //return new UnmodifiableSortedMap<K, V>(sm.headMap(before));
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.766 -0400", hash_original_method = "00E9126A84DE8B71214859A17DA6BD2E", hash_generated_method = "F62B2EB9B7A3E755BE6ACEBE56E18298")
        @Override
        public K lastKey() {
K varC4E8101F3F71352235F4E401D4498536_1101522341 =             sm.lastKey();
            varC4E8101F3F71352235F4E401D4498536_1101522341.addTaint(taint);
            return varC4E8101F3F71352235F4E401D4498536_1101522341;
            // ---------- Original Method ----------
            //return sm.lastKey();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.766 -0400", hash_original_method = "B6411009D9179ABF4D7755605B648FDC", hash_generated_method = "771C700A575920071751E05C52FCC306")
        @Override
        public SortedMap<K, V> subMap(K start, K end) {
            addTaint(end.getTaint());
            addTaint(start.getTaint());
SortedMap<K, V> varCCBB071ACDDD27B316590ED95D45D92F_76689459 =             new UnmodifiableSortedMap<K, V>(sm.subMap(start, end));
            varCCBB071ACDDD27B316590ED95D45D92F_76689459.addTaint(taint);
            return varCCBB071ACDDD27B316590ED95D45D92F_76689459;
            // ---------- Original Method ----------
            //return new UnmodifiableSortedMap<K, V>(sm.subMap(start, end));
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.767 -0400", hash_original_method = "59BADF6C5EE68C4E1DB5A6A22818328A", hash_generated_method = "3DBEEFFD70D4684BDDABEEE45CCB1AD5")
        @Override
        public SortedMap<K, V> tailMap(K after) {
            addTaint(after.getTaint());
SortedMap<K, V> var4272A31247EF3DF31C465D4CA23EB8D9_1605644604 =             new UnmodifiableSortedMap<K, V>(sm.tailMap(after));
            var4272A31247EF3DF31C465D4CA23EB8D9_1605644604.addTaint(taint);
            return var4272A31247EF3DF31C465D4CA23EB8D9_1605644604;
            // ---------- Original Method ----------
            //return new UnmodifiableSortedMap<K, V>(sm.tailMap(after));
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.767 -0400", hash_original_field = "BB78CEF8331176F8CBF0AFC85E7523D8", hash_generated_field = "74C1A54CA827DD7351FCAD121C86B500")

        private static final long serialVersionUID = -8806743815996713206L;
    }


    
    private static class UnmodifiableSortedSet<E> extends UnmodifiableSet<E> implements SortedSet<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.767 -0400", hash_original_field = "3691308F2A4C2F6983F2880D32E29C84", hash_generated_field = "5220A6F2AA4CB98BB6C290F0BB717E86")

        private SortedSet<E> ss;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.767 -0400", hash_original_method = "232C45C3B4117EB9042FB58E6C0CE113", hash_generated_method = "C02ACFBA00E84FCE033C7CEC6C326A50")
          UnmodifiableSortedSet(SortedSet<E> set) {
            super(set);
            ss = set;
            // ---------- Original Method ----------
            //ss = set;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.767 -0400", hash_original_method = "8514D9255D678B041F55D03BA11DCA3B", hash_generated_method = "052144F612C8362D58E75F8EFCD20039")
        @Override
        public Comparator<? super E> comparator() {
Comparator<? super E> varEF7DDB49085F2DA083783C6BC3481D0B_798733203 =             ss.comparator();
            varEF7DDB49085F2DA083783C6BC3481D0B_798733203.addTaint(taint);
            return varEF7DDB49085F2DA083783C6BC3481D0B_798733203;
            // ---------- Original Method ----------
            //return ss.comparator();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.767 -0400", hash_original_method = "6BB6C51843B41CC0DCB5509A79DBA008", hash_generated_method = "D12258BD7DA134597EF8F9E445168A94")
        @Override
        public E first() {
E varE64C384BCBD0BF9F8BB2385886B7C815_1454816959 =             ss.first();
            varE64C384BCBD0BF9F8BB2385886B7C815_1454816959.addTaint(taint);
            return varE64C384BCBD0BF9F8BB2385886B7C815_1454816959;
            // ---------- Original Method ----------
            //return ss.first();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.767 -0400", hash_original_method = "74C4BE29898589F7D7948BADA3350612", hash_generated_method = "533FE302F492A42DFD665631EADB54A9")
        @Override
        public SortedSet<E> headSet(E before) {
            addTaint(before.getTaint());
SortedSet<E> varFF8D6CDEDB36E38D2AD61812C48750BF_794344710 =             new UnmodifiableSortedSet<E>(ss.headSet(before));
            varFF8D6CDEDB36E38D2AD61812C48750BF_794344710.addTaint(taint);
            return varFF8D6CDEDB36E38D2AD61812C48750BF_794344710;
            // ---------- Original Method ----------
            //return new UnmodifiableSortedSet<E>(ss.headSet(before));
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.768 -0400", hash_original_method = "AAC5DDE787ACA85752B94AAB77F6B0F8", hash_generated_method = "1333F201233FA45232A28A911A8EA877")
        @Override
        public E last() {
E var7A1B325A772301476E34C1CFA8ED9C89_408523978 =             ss.last();
            var7A1B325A772301476E34C1CFA8ED9C89_408523978.addTaint(taint);
            return var7A1B325A772301476E34C1CFA8ED9C89_408523978;
            // ---------- Original Method ----------
            //return ss.last();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.768 -0400", hash_original_method = "54602835FD774439E48CB96CB67F9D83", hash_generated_method = "6979F8FBD67705E5495D91967CDA8D61")
        @Override
        public SortedSet<E> subSet(E start, E end) {
            addTaint(end.getTaint());
            addTaint(start.getTaint());
SortedSet<E> var5983101DC91D536DAE9E9F3DAA0F4158_1893266694 =             new UnmodifiableSortedSet<E>(ss.subSet(start, end));
            var5983101DC91D536DAE9E9F3DAA0F4158_1893266694.addTaint(taint);
            return var5983101DC91D536DAE9E9F3DAA0F4158_1893266694;
            // ---------- Original Method ----------
            //return new UnmodifiableSortedSet<E>(ss.subSet(start, end));
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.768 -0400", hash_original_method = "37640609DAC9C9170FD6CBE14C8AD6B6", hash_generated_method = "D13974247E14B91E89F19BF265290CA2")
        @Override
        public SortedSet<E> tailSet(E after) {
            addTaint(after.getTaint());
SortedSet<E> var85BF07315C1F5F4B7B2E26C588F4E538_1006316282 =             new UnmodifiableSortedSet<E>(ss.tailSet(after));
            var85BF07315C1F5F4B7B2E26C588F4E538_1006316282.addTaint(taint);
            return var85BF07315C1F5F4B7B2E26C588F4E538_1006316282;
            // ---------- Original Method ----------
            //return new UnmodifiableSortedSet<E>(ss.tailSet(after));
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.768 -0400", hash_original_field = "A7FEB93E06211B53C8063E2CA4FFCCC4", hash_generated_field = "492EEA3FB02A9A00EAE2EF3419CB36AB")

        private static final long serialVersionUID = -4929149591599911165L;
    }


    
    private static class SetFromMap<E> extends AbstractSet<E> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.768 -0400", hash_original_field = "6F8F57715090DA2632453988D9A1501B", hash_generated_field = "8D1145F106DE5C3E2B790E661BC27C3B")

        private Map<E, Boolean> m;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.768 -0400", hash_original_field = "10AA84685E8BF74D8FA1DED104C25521", hash_generated_field = "75D49D8B030B2438C97CCFE06F0E4EF6")

        private transient Set<E> backingSet;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.768 -0400", hash_original_method = "6B962D990E5B5543C1AA025E18134CE9", hash_generated_method = "68252A5316CF37F1B8C0AF671D9233B5")
          SetFromMap(final Map<E, Boolean> map) {
            m = map;
            backingSet = map.keySet();
            // ---------- Original Method ----------
            //m = map;
            //backingSet = map.keySet();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.769 -0400", hash_original_method = "B42E9CA75A778919E90B77D794DBEE82", hash_generated_method = "4779DBC5DD6625BF0EE8EA22B613F82A")
        @Override
        public boolean equals(Object object) {
            addTaint(object.getTaint());
            boolean varC30F0123BD7BEAECC1843E5DCA354C91_844634836 = (backingSet.equals(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_513452126 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_513452126;
            // ---------- Original Method ----------
            //return backingSet.equals(object);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.769 -0400", hash_original_method = "684F9CE738B21B1B45F3304124963EF1", hash_generated_method = "DCA5995DA53E03DD2EA5AB2F42E1E680")
        @Override
        public int hashCode() {
            int var67863B4311CEC139EE028FCE4488E86F_1041965064 = (backingSet.hashCode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1704626011 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1704626011;
            // ---------- Original Method ----------
            //return backingSet.hashCode();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.769 -0400", hash_original_method = "FC84A6CABB16433CF1488E03DF7636C8", hash_generated_method = "8403F49712F2E101D4C12F7F658D54F5")
        @Override
        public boolean add(E object) {
            addTaint(object.getTaint());
            boolean var60B1060CC3CCD3BB395E221A8613469A_1602193388 = (m.put(object, Boolean.TRUE) == null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1083799748 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1083799748;
            // ---------- Original Method ----------
            //return m.put(object, Boolean.TRUE) == null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.771 -0400", hash_original_method = "5163CA2ED3AD9C66F2BDAFB902590115", hash_generated_method = "5C1448B76AB003BA7ABB7E55C1011B37")
        @Override
        public void clear() {
            m.clear();
            // ---------- Original Method ----------
            //m.clear();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.771 -0400", hash_original_method = "C7069F73CC2FBE59B42FACF6A3731192", hash_generated_method = "7CBD6BF4DF44DD33582514BF4D630BEF")
        @Override
        public String toString() {
String var06060D832159DFF1A743DE22DFD02BBE_1691062534 =             backingSet.toString();
            var06060D832159DFF1A743DE22DFD02BBE_1691062534.addTaint(taint);
            return var06060D832159DFF1A743DE22DFD02BBE_1691062534;
            // ---------- Original Method ----------
            //return backingSet.toString();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.771 -0400", hash_original_method = "C1FDFEBBA860B6E21729D041F83BDE39", hash_generated_method = "F3056F06E671F0879D15225008645537")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            boolean varF727171565D11CE98C1570ECC663B4C2_1783310446 = (backingSet.contains(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1331344813 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1331344813;
            // ---------- Original Method ----------
            //return backingSet.contains(object);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.771 -0400", hash_original_method = "652D3A93342A70291E00DB196A629050", hash_generated_method = "3459A2C4E340EADCEEB1608A174F9D05")
        @Override
        public boolean containsAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            boolean varFBC587BEB1223549414B53AE862546C9_1357323924 = (backingSet.containsAll(collection));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1755280534 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1755280534;
            // ---------- Original Method ----------
            //return backingSet.containsAll(collection);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.771 -0400", hash_original_method = "B9E63D3C52241E7E917CB1416ABA36E5", hash_generated_method = "BE0CE73819B18CF1A15EF3ADCB44A34C")
        @Override
        public boolean isEmpty() {
            boolean var6FFDB0B6EFF2802DEEBD39B93137FE90_1309983559 = (m.isEmpty());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_803650271 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_803650271;
            // ---------- Original Method ----------
            //return m.isEmpty();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.772 -0400", hash_original_method = "20C696E59013C16BDFED7021A5C3E797", hash_generated_method = "B451003B332675A80CD8E3B9CA003572")
        @Override
        public boolean remove(Object object) {
            addTaint(object.getTaint());
            boolean varBBFEB77427ECEE6BC6DD85A39948F897_1991907508 = (m.remove(object) != null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1068087701 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1068087701;
            // ---------- Original Method ----------
            //return m.remove(object) != null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.772 -0400", hash_original_method = "4A27ACEA2C9F194EF4597E8BDECC6BD7", hash_generated_method = "D83BEF908326DF78DE90460904A021F2")
        @Override
        public boolean retainAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            boolean varC258F2F6CC325D00A2245A8926671054_1320968777 = (backingSet.retainAll(collection));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1157156598 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1157156598;
            // ---------- Original Method ----------
            //return backingSet.retainAll(collection);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.772 -0400", hash_original_method = "706FD57EC242D189F78C8F40D764E8D0", hash_generated_method = "B8614661CA56FFB255AAB20B4D31F0E6")
        @Override
        public Object[] toArray() {
Object[] var2AFBF44EAF1E21A3A305A3D12C081322_458080672 =             backingSet.toArray();
            var2AFBF44EAF1E21A3A305A3D12C081322_458080672.addTaint(taint);
            return var2AFBF44EAF1E21A3A305A3D12C081322_458080672;
            // ---------- Original Method ----------
            //return backingSet.toArray();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.772 -0400", hash_original_method = "5B684176C593DE73F99AF08724DF65D4", hash_generated_method = "575476B84A4F565C006DCA5CC76F268A")
        @Override
        public <T> T[] toArray(T[] contents) {
            addTaint(contents[0].getTaint());
T[] var3546C28EE3387A2856CC723595918E17_779556003 =             backingSet.toArray(contents);
            var3546C28EE3387A2856CC723595918E17_779556003.addTaint(taint);
            return var3546C28EE3387A2856CC723595918E17_779556003;
            // ---------- Original Method ----------
            //return backingSet.toArray(contents);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.773 -0400", hash_original_method = "2EC39271104239DED882FB25EFF4BC23", hash_generated_method = "E770DC38D52B6F9286F9AF3491CE9CEE")
        @Override
        public Iterator<E> iterator() {
Iterator<E> varFCA11838FE7195B1BCD4A5C4A80B9796_2034278783 =             backingSet.iterator();
            varFCA11838FE7195B1BCD4A5C4A80B9796_2034278783.addTaint(taint);
            return varFCA11838FE7195B1BCD4A5C4A80B9796_2034278783;
            // ---------- Original Method ----------
            //return backingSet.iterator();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.773 -0400", hash_original_method = "A04EE09DEB6F21FAA6A7E10DF6401CD1", hash_generated_method = "BE69955F0E7AFDFC2B2B8FF056909189")
        @Override
        public int size() {
            int var313B2D1C305A713CA398B12007C9967C_801855426 = (m.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1048445171 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1048445171;
            // ---------- Original Method ----------
            //return m.size();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.773 -0400", hash_original_method = "8082AE1FFA2825B9433C3082C2F87EDC", hash_generated_method = "C4A865194E7336FA95CD8863516C203F")
        @SuppressWarnings("unchecked")
        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
            addTaint(stream.getTaint());
            stream.defaultReadObject();
            backingSet = m.keySet();
            // ---------- Original Method ----------
            //stream.defaultReadObject();
            //backingSet = m.keySet();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.773 -0400", hash_original_field = "68A2EE38D4624ED7EDE7470F4422D17A", hash_generated_field = "D22893062D677334CA792903B3E2A0BD")

        private static final long serialVersionUID = 2454657854757543876L;
    }


    
    private static class AsLIFOQueue<E> extends AbstractQueue<E> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.773 -0400", hash_original_field = "7694F4A66316E53C8CDD9D9954BD611D", hash_generated_field = "8E692B16EB19650DAECD0B8A91F62E63")

        private Deque<E> q;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.773 -0400", hash_original_method = "C9A3AEFCC3A9FEA0CFED796FADB14DA4", hash_generated_method = "8C725C5253844AF6C1706232C12CC260")
          AsLIFOQueue(final Deque<E> deque) {
            this.q = deque;
            // ---------- Original Method ----------
            //this.q = deque;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.774 -0400", hash_original_method = "D6ABAC5AC9E31C28EFD449012F8C668D", hash_generated_method = "2622DBA4A1E5A6A503DD2C4C41FFF96B")
        @Override
        public Iterator<E> iterator() {
Iterator<E> varD39B553C2AE1A151C282A7AD80B8BBF9_1072416672 =             q.iterator();
            varD39B553C2AE1A151C282A7AD80B8BBF9_1072416672.addTaint(taint);
            return varD39B553C2AE1A151C282A7AD80B8BBF9_1072416672;
            // ---------- Original Method ----------
            //return q.iterator();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.774 -0400", hash_original_method = "4D120CFD44D3EE91A03411EED1F5CA02", hash_generated_method = "393C7868B2310CD91121247C484BE3F8")
        @Override
        public int size() {
            int var439AEF944A957C936AE6F28AA258835C_1729103524 = (q.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1366866221 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1366866221;
            // ---------- Original Method ----------
            //return q.size();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.774 -0400", hash_original_method = "A29AB2808D45581589F8B0269F283532", hash_generated_method = "63586B7D44678581C922F471FBB600BD")
        @Override
        public boolean offer(E o) {
            addTaint(o.getTaint());
            boolean varCD3677ADCD08BD4D1FA6A059AAF29C17_362398784 = (q.offerFirst(o));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1526516349 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1526516349;
            // ---------- Original Method ----------
            //return q.offerFirst(o);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.774 -0400", hash_original_method = "286FFABBC697C1CEE6C49194F85DD481", hash_generated_method = "C213D1629D61A7EA7A480835EBCF048B")
        @Override
        public E peek() {
E var72B809E445C36B133CDC3256733B835C_1269062365 =             q.peekFirst();
            var72B809E445C36B133CDC3256733B835C_1269062365.addTaint(taint);
            return var72B809E445C36B133CDC3256733B835C_1269062365;
            // ---------- Original Method ----------
            //return q.peekFirst();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.774 -0400", hash_original_method = "93EF986205EA0EFDB6E2F2BDD9DDBDB0", hash_generated_method = "E0276BEA37458CFB5AD9830EDFE6AADB")
        @Override
        public E poll() {
E varAED2ABC9BC7A6C61FEC2D7E7AC242301_592618582 =             q.pollFirst();
            varAED2ABC9BC7A6C61FEC2D7E7AC242301_592618582.addTaint(taint);
            return varAED2ABC9BC7A6C61FEC2D7E7AC242301_592618582;
            // ---------- Original Method ----------
            //return q.pollFirst();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.776 -0400", hash_original_method = "E16BCF0F708E6336497510D255228AB4", hash_generated_method = "9185A11F5FFCDE151F17C86C375065B3")
        @Override
        public boolean add(E o) {
            addTaint(o.getTaint());
            q.push(o);
            boolean varB326B5062B2F0E69046810717534CB09_1703076545 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_732737744 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_732737744;
            // ---------- Original Method ----------
            //q.push(o);
            //return true;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.776 -0400", hash_original_method = "ECF3C7555AB121202E1C39938D734656", hash_generated_method = "72AFA896F4EE9665FC95334E69A68411")
        @Override
        public void clear() {
            q.clear();
            // ---------- Original Method ----------
            //q.clear();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.776 -0400", hash_original_method = "41C0874A8589B77FE1309E3303509F6A", hash_generated_method = "B238A8B14778AF2C8B022A721DDF1A21")
        @Override
        public E element() {
E var39DE1B6B79580F8ECBFE056F19FB08E8_1889212505 =             q.getFirst();
            var39DE1B6B79580F8ECBFE056F19FB08E8_1889212505.addTaint(taint);
            return var39DE1B6B79580F8ECBFE056F19FB08E8_1889212505;
            // ---------- Original Method ----------
            //return q.getFirst();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.776 -0400", hash_original_method = "DBCAD9866D0C084DC455BF7C95ABCE77", hash_generated_method = "D86B00975F94C4559703E1E74E88C01C")
        @Override
        public E remove() {
E var1D8C9B8E5EBB6E308A89652FCC2FF05C_1431720460 =             q.pop();
            var1D8C9B8E5EBB6E308A89652FCC2FF05C_1431720460.addTaint(taint);
            return var1D8C9B8E5EBB6E308A89652FCC2FF05C_1431720460;
            // ---------- Original Method ----------
            //return q.pop();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.776 -0400", hash_original_method = "2E730D7ABEE184A9C34DA57DF7A457EE", hash_generated_method = "A4B50D65E244CF7E56DC5387015C510A")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            boolean varF7AA0027FF7CF6A518402C1D103649D0_1186051876 = (q.contains(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1626593202 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1626593202;
            // ---------- Original Method ----------
            //return q.contains(object);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.776 -0400", hash_original_method = "3E9E9A2983E74090844621EE9CF6D3D7", hash_generated_method = "00F2060E3CD6E4EFE9FEBBE1889D6726")
        @Override
        public boolean containsAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            boolean var2F3EA5C79EFC09F1F5BFE6AB405CF8E1_718462498 = (q.containsAll(collection));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1718691390 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1718691390;
            // ---------- Original Method ----------
            //return q.containsAll(collection);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.776 -0400", hash_original_method = "3014069A2B40728BACBB472823CCCF21", hash_generated_method = "3093E8F59E4451F864C075B58F35392C")
        @Override
        public boolean isEmpty() {
            boolean varB96CEE9B3576CCF3A5D79A3822AA24C0_1389032877 = (q.isEmpty());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1350409462 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1350409462;
            // ---------- Original Method ----------
            //return q.isEmpty();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.776 -0400", hash_original_method = "06C06D3351623BFF7BABDE8B40334F59", hash_generated_method = "8A8F99B8F038A386201D104DA8043E15")
        @Override
        public boolean remove(Object object) {
            addTaint(object.getTaint());
            boolean varC41B424C0DA577FA3AD57EDD7A3297DB_546009350 = (q.remove(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2006046292 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2006046292;
            // ---------- Original Method ----------
            //return q.remove(object);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.777 -0400", hash_original_method = "13975D6542267AD488C8D9B27A0905D7", hash_generated_method = "670CCBCA01C92590262067152BC7E170")
        @Override
        public boolean removeAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            boolean varE95384D9CFD6BAC61C00B339AA1C12E6_1669654715 = (q.removeAll(collection));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_78091925 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_78091925;
            // ---------- Original Method ----------
            //return q.removeAll(collection);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.783 -0400", hash_original_method = "029F8EE40CDE382EFA7F7BF13B8FE731", hash_generated_method = "4A738D70459C1AE02B7377D39F433548")
        @Override
        public boolean retainAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            boolean var15D260DBD7670553DDB130F283831464_729222203 = (q.retainAll(collection));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_946901193 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_946901193;
            // ---------- Original Method ----------
            //return q.retainAll(collection);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.783 -0400", hash_original_method = "81809EBBF1D8298961C4E9B761FEF748", hash_generated_method = "356A948EF616A75212BBF45DEB4E0B6E")
        @Override
        public Object[] toArray() {
Object[] var880A48243792151F70528940250FAEFC_782656804 =             q.toArray();
            var880A48243792151F70528940250FAEFC_782656804.addTaint(taint);
            return var880A48243792151F70528940250FAEFC_782656804;
            // ---------- Original Method ----------
            //return q.toArray();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.783 -0400", hash_original_method = "3C7918E789D95B2A97E0F45A2E8277E0", hash_generated_method = "A678998339B80EC4D9EC01B5E34F53F0")
        @Override
        public <T> T[] toArray(T[] contents) {
            addTaint(contents[0].getTaint());
T[] varB826DAACB71C6F73C56D75F228BB03F8_1296691217 =             q.toArray(contents);
            varB826DAACB71C6F73C56D75F228BB03F8_1296691217.addTaint(taint);
            return varB826DAACB71C6F73C56D75F228BB03F8_1296691217;
            // ---------- Original Method ----------
            //return q.toArray(contents);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.783 -0400", hash_original_method = "827F98847BB1D6CEA3B0A324A45F92ED", hash_generated_method = "341B8F135BCA513771D8A693C6BABD40")
        @Override
        public String toString() {
String varA79A216DB57E425634893D64CD555087_103625344 =             q.toString();
            varA79A216DB57E425634893D64CD555087_103625344.addTaint(taint);
            return varA79A216DB57E425634893D64CD555087_103625344;
            // ---------- Original Method ----------
            //return q.toString();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.783 -0400", hash_original_field = "7C5B063F84AD7FF4280E3FC6C2D641FE", hash_generated_field = "4687D2B0166F4A9C03E2417C41443082")

        private static final long serialVersionUID = 1802017725587941708L;
    }


    
    private static class CheckedCollection<E> implements Collection<E>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.783 -0400", hash_original_field = "4A8A08F09D37B73795649038408B5F33", hash_generated_field = "A3C80A7E02E49F20400373DFBAF9696A")

        Collection<E> c;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.783 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "D40602D541C2081B4D03EEADC8718DAD")

        Class<E> type;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.783 -0400", hash_original_method = "4DAA5B7D63536360D367B6279A6FD0F0", hash_generated_method = "E6E45CD66454EAF9D9DE5B8BB2CE005B")
        public  CheckedCollection(Collection<E> c, Class<E> type) {
            if(c == null || type == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_2013038744 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_2013038744.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_2013038744;
            } //End block
            this.c = c;
            this.type = type;
            // ---------- Original Method ----------
            //if (c == null || type == null) {
                //throw new NullPointerException();
            //}
            //this.c = c;
            //this.type = type;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.784 -0400", hash_original_method = "AC97C28F724592ABA809E2470D95C119", hash_generated_method = "143135CCA80BFAE802C44EF341BCAFE2")
        @Override
        public int size() {
            int varB01543F097DAA850E9B79CBAB9C1B976_631985863 = (c.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_454095710 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_454095710;
            // ---------- Original Method ----------
            //return c.size();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.784 -0400", hash_original_method = "F9A3CB1FB7570D28EBE20660E2FC6F42", hash_generated_method = "A993B8A93B0CEF761E619325F98C3BD7")
        @Override
        public boolean isEmpty() {
            boolean var65FAF5A74582A5D73E221DB675503595_1524416399 = (c.isEmpty());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_750872867 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_750872867;
            // ---------- Original Method ----------
            //return c.isEmpty();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.787 -0400", hash_original_method = "AA502F510015E56A50E854673F52B13D", hash_generated_method = "6D608D4375EB511BC9EC40A3506A1818")
        @Override
        public boolean contains(Object obj) {
            addTaint(obj.getTaint());
            boolean var874204C752DD66571A81E72DE088C268_1727635424 = (c.contains(obj));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1830131620 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1830131620;
            // ---------- Original Method ----------
            //return c.contains(obj);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.788 -0400", hash_original_method = "A49A579D720F57F247BFFB420B912FC7", hash_generated_method = "699B9DD651FC16C2DCADBC6A13B084C1")
        @Override
        public Iterator<E> iterator() {
            Iterator<E> i = c.iterator();
            if(i instanceof ListIterator)            
            {
                i = new CheckedListIterator<E>((ListIterator<E>) i, type);
            } //End block
Iterator<E> varD9A5948E3E870E6097B7023E4497FFEC_440745056 =             i;
            varD9A5948E3E870E6097B7023E4497FFEC_440745056.addTaint(taint);
            return varD9A5948E3E870E6097B7023E4497FFEC_440745056;
            // ---------- Original Method ----------
            //Iterator<E> i = c.iterator();
            //if (i instanceof ListIterator) {
                //i = new CheckedListIterator<E>((ListIterator<E>) i, type);
            //}
            //return i;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.788 -0400", hash_original_method = "89D7D02A9D2BDF31E775C08108CBDE5B", hash_generated_method = "D99BC077716E9062A6579CE5AE6B2CDB")
        @Override
        public Object[] toArray() {
Object[] var46570412E19D68724A647FAFEECFBF92_375234401 =             c.toArray();
            var46570412E19D68724A647FAFEECFBF92_375234401.addTaint(taint);
            return var46570412E19D68724A647FAFEECFBF92_375234401;
            // ---------- Original Method ----------
            //return c.toArray();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.788 -0400", hash_original_method = "9B8166862C116AE305DE64E80811892F", hash_generated_method = "52580AF03297B83D0E9C964EB937E251")
        @Override
        public <T> T[] toArray(T[] arr) {
            addTaint(arr[0].getTaint());
T[] varC7FA0C6E1955DD91DCB427C3A91A0EA7_810280548 =             c.toArray(arr);
            varC7FA0C6E1955DD91DCB427C3A91A0EA7_810280548.addTaint(taint);
            return varC7FA0C6E1955DD91DCB427C3A91A0EA7_810280548;
            // ---------- Original Method ----------
            //return c.toArray(arr);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.788 -0400", hash_original_method = "233202E3883C87159328A7DF45C5A0DD", hash_generated_method = "1DF834182A75B95337FE22F2D63D959D")
        @Override
        public boolean add(E obj) {
            addTaint(obj.getTaint());
            boolean varFB27217C76737CE1366B2CBDCE2F738C_1521072195 = (c.add(checkType(obj, type)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_723380347 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_723380347;
            // ---------- Original Method ----------
            //return c.add(checkType(obj, type));
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.788 -0400", hash_original_method = "A7C1CDA142B015DD1AAB47325584260A", hash_generated_method = "31C23B611FAE7FEDC8B95CC801B863D3")
        @Override
        public boolean remove(Object obj) {
            addTaint(obj.getTaint());
            boolean varFC763DF5EAD188B2AD1ED0810A9284B6_1053255132 = (c.remove(obj));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1566869999 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1566869999;
            // ---------- Original Method ----------
            //return c.remove(obj);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.788 -0400", hash_original_method = "8A54483E259CA6D3C8AB1EBE7493D296", hash_generated_method = "74D2E0DD683917BFBB2D9608D95167A4")
        @Override
        public boolean containsAll(Collection<?> c1) {
            addTaint(c1.getTaint());
            boolean var5DFE467800E15F0E1972CFDCDBFA5B60_754829289 = (c.containsAll(c1));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1240885506 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1240885506;
            // ---------- Original Method ----------
            //return c.containsAll(c1);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.789 -0400", hash_original_method = "A2391F235E9474A0C2FADB6F2C5C2AB0", hash_generated_method = "57A5C62E6D9ABD06891DDB62B41AB830")
        @SuppressWarnings("unchecked")
        @Override
        public boolean addAll(Collection<? extends E> c1) {
            addTaint(c1.getTaint());
            Object[] array = c1.toArray();
for(Object o : array)
            {
                checkType(o, type);
            } //End block
            boolean var17C01334C1A3B801F95A3E855A6155C0_1173742483 = (c.addAll((List<E>) Arrays.asList(array)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1997626715 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1997626715;
            // ---------- Original Method ----------
            //Object[] array = c1.toArray();
            //for (Object o : array) {
                //checkType(o, type);
            //}
            //return c.addAll((List<E>) Arrays.asList(array));
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.789 -0400", hash_original_method = "E5A4F3F5A50F475A125F07680365C964", hash_generated_method = "B4363840C63DC2D3C6633C7948B0CDB6")
        @Override
        public boolean removeAll(Collection<?> c1) {
            addTaint(c1.getTaint());
            boolean varA68FC87E792608B8C555C5D12B82C7E6_642356476 = (c.removeAll(c1));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1776622994 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1776622994;
            // ---------- Original Method ----------
            //return c.removeAll(c1);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.789 -0400", hash_original_method = "2CCBBE73D1665A80965D3FA8CB644A3B", hash_generated_method = "23D51D45CAB39746B533273608C2EAB5")
        @Override
        public boolean retainAll(Collection<?> c1) {
            addTaint(c1.getTaint());
            boolean var1429F547061A089034C637B072A34287_1975702817 = (c.retainAll(c1));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1597284937 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1597284937;
            // ---------- Original Method ----------
            //return c.retainAll(c1);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.789 -0400", hash_original_method = "C75B179C04D460F62AB7F39D0D292067", hash_generated_method = "A8F69290363AB2D00FEDD4A5A3BF8CF2")
        @Override
        public void clear() {
            c.clear();
            // ---------- Original Method ----------
            //c.clear();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.789 -0400", hash_original_method = "424D4966F358AE6553349A6493C21674", hash_generated_method = "3F6A7530817F9BD65AB99BCEC54EF271")
        @Override
        public String toString() {
String var7F88C51BB16CD8992026056598815CC9_1152798828 =             c.toString();
            var7F88C51BB16CD8992026056598815CC9_1152798828.addTaint(taint);
            return var7F88C51BB16CD8992026056598815CC9_1152798828;
            // ---------- Original Method ----------
            //return c.toString();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.789 -0400", hash_original_field = "19984F6C6BA7815BBDF7C18EF9C975B4", hash_generated_field = "0D42B7BF026634D153E28C472B065A0D")

        private static final long serialVersionUID = 1578914078182001775L;
    }


    
    private static class CheckedListIterator<E> implements ListIterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.790 -0400", hash_original_field = "865C0C0B4AB0E063E5CAA3387C1A8741", hash_generated_field = "A3E111A0B732842F8B9E259D3903708E")

        private ListIterator<E> i;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.790 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "44DD73C068DAE541C380477699D61FAF")

        private Class<E> type;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.790 -0400", hash_original_method = "0B7AAA10EE83BBF7A614BF8D8C7A7C84", hash_generated_method = "8BB9DF0BD458C6C58CAD8ED7A978114C")
        public  CheckedListIterator(ListIterator<E> i, Class<E> type) {
            this.i = i;
            this.type = type;
            // ---------- Original Method ----------
            //this.i = i;
            //this.type = type;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.790 -0400", hash_original_method = "59CA86A80410B66286C92523CF35EC7B", hash_generated_method = "227826EC60BFA6F4FE7B54FEF1D3565B")
        @Override
        public boolean hasNext() {
            boolean varD1B5E3BB1A727F5E42DA5D458C9BD3D7_1432356413 = (i.hasNext());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1613028323 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1613028323;
            // ---------- Original Method ----------
            //return i.hasNext();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.790 -0400", hash_original_method = "A2FD0994E634C5BCE4D27AD9176E9A5A", hash_generated_method = "00EAC222A2ECFE3025C1EC0F710BDCFB")
        @Override
        public E next() {
E varF6EAB0DE2C0CB4CEE3FE4BE37522387A_1196602657 =             i.next();
            varF6EAB0DE2C0CB4CEE3FE4BE37522387A_1196602657.addTaint(taint);
            return varF6EAB0DE2C0CB4CEE3FE4BE37522387A_1196602657;
            // ---------- Original Method ----------
            //return i.next();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.790 -0400", hash_original_method = "048FA6C3E3A28865AD880AF8A3FCAE96", hash_generated_method = "598E37F558FC71BB5A0DA7BBE13EE694")
        @Override
        public void remove() {
            i.remove();
            // ---------- Original Method ----------
            //i.remove();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.790 -0400", hash_original_method = "BBFFF3658F03DC70BAED5B88BBE801F9", hash_generated_method = "FFFEA175D403C4D2812828DD12686C4E")
        @Override
        public boolean hasPrevious() {
            boolean var4C4BE00885D578D14F095BAF19BB3207_1836856505 = (i.hasPrevious());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1341605151 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1341605151;
            // ---------- Original Method ----------
            //return i.hasPrevious();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.790 -0400", hash_original_method = "BC73D9B40C1A828CB3DD11A00CF4E28D", hash_generated_method = "A774663EC330FE8260FDB1156980D900")
        @Override
        public E previous() {
E var61117AF8F234799332538CC5E5C9E900_1541992252 =             i.previous();
            var61117AF8F234799332538CC5E5C9E900_1541992252.addTaint(taint);
            return var61117AF8F234799332538CC5E5C9E900_1541992252;
            // ---------- Original Method ----------
            //return i.previous();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.790 -0400", hash_original_method = "E41D02CE1A7D09C2351DC91043CD0C1F", hash_generated_method = "E571B99B4790A2F59AB463E84E740303")
        @Override
        public int nextIndex() {
            int var814C2FC876D21135D437F503A632B364_1381784978 = (i.nextIndex());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1082520949 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1082520949;
            // ---------- Original Method ----------
            //return i.nextIndex();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.790 -0400", hash_original_method = "F0908B37AEEE31348E4E446BDB2DC11E", hash_generated_method = "4496887275C53FAB5AB505D62BBB9061")
        @Override
        public int previousIndex() {
            int varE41ACDDE97BB93973005B931FB8EC3B0_2089818099 = (i.previousIndex());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2012795349 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2012795349;
            // ---------- Original Method ----------
            //return i.previousIndex();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.791 -0400", hash_original_method = "F06067E5C50A33BA33028ACBB7E94E5C", hash_generated_method = "AEA281633F37E1B03580B196FFB0CFCE")
        @Override
        public void set(E obj) {
            addTaint(obj.getTaint());
            i.set(checkType(obj, type));
            // ---------- Original Method ----------
            //i.set(checkType(obj, type));
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.791 -0400", hash_original_method = "3A7C6206CDBE5C448C8E83D10145E877", hash_generated_method = "399B84877C8BA647D446042E7B6E5BFB")
        @Override
        public void add(E obj) {
            addTaint(obj.getTaint());
            i.add(checkType(obj, type));
            // ---------- Original Method ----------
            //i.add(checkType(obj, type));
        }

        
    }


    
    private static class CheckedList<E> extends CheckedCollection<E> implements List<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.791 -0400", hash_original_field = "2DB95E8E1A9267B7A1188556B2013B33", hash_generated_field = "BA44D98E464F3917B2E777BB565BC0D3")

        List<E> l;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.791 -0400", hash_original_method = "50AAAF0EF026911FE0274184FEF9C1C3", hash_generated_method = "2DB9BC9FE1F5179D2C72A7E31D43B6BE")
        public  CheckedList(List<E> l, Class<E> type) {
            super(l, type);
            addTaint(type.getTaint());
            this.l = l;
            // ---------- Original Method ----------
            //this.l = l;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.791 -0400", hash_original_method = "8A1A291116E92C540879607029C861C6", hash_generated_method = "1B48255B5B50D2DBF9305C6799A700C1")
        @SuppressWarnings("unchecked")
        @Override
        public boolean addAll(int index, Collection<? extends E> c1) {
            addTaint(c1.getTaint());
            addTaint(index);
            Object[] array = c1.toArray();
for(Object o : array)
            {
                checkType(o, type);
            } //End block
            boolean var4238673B8C93511BA5D32703DB38C7A5_953889117 = (l.addAll(index, (List<E>) Arrays.asList(array)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1285690523 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1285690523;
            // ---------- Original Method ----------
            //Object[] array = c1.toArray();
            //for (Object o : array) {
                //checkType(o, type);
            //}
            //return l.addAll(index, (List<E>) Arrays.asList(array));
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.791 -0400", hash_original_method = "12BB9FAB0B921E0E98205977740A217D", hash_generated_method = "7C4D71E67A22C346731DC7204A8FD532")
        @Override
        public E get(int index) {
            addTaint(index);
E var0298FE27A0E002F834F5B4411219665B_1125080555 =             l.get(index);
            var0298FE27A0E002F834F5B4411219665B_1125080555.addTaint(taint);
            return var0298FE27A0E002F834F5B4411219665B_1125080555;
            // ---------- Original Method ----------
            //return l.get(index);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.791 -0400", hash_original_method = "B15A1B3ABEAB19644273A7FDAFDFF4C3", hash_generated_method = "73C891A7A1742BA93237CFA992E59EFE")
        @Override
        public E set(int index, E obj) {
            addTaint(obj.getTaint());
            addTaint(index);
E var6D9000D1F8EA992EBD7004DD7A12D9D1_446353084 =             l.set(index, checkType(obj, type));
            var6D9000D1F8EA992EBD7004DD7A12D9D1_446353084.addTaint(taint);
            return var6D9000D1F8EA992EBD7004DD7A12D9D1_446353084;
            // ---------- Original Method ----------
            //return l.set(index, checkType(obj, type));
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.792 -0400", hash_original_method = "97AC3A6F1A8F1F91D88637C439308CAA", hash_generated_method = "36C6CB2BAFE73E5C7E33AC3DAF4D06D9")
        @Override
        public void add(int index, E obj) {
            addTaint(obj.getTaint());
            addTaint(index);
            l.add(index, checkType(obj, type));
            // ---------- Original Method ----------
            //l.add(index, checkType(obj, type));
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.793 -0400", hash_original_method = "B7A754E9641B79EF3AC643C6FA162631", hash_generated_method = "A25F8DE074077D019B5938E85E423BED")
        @Override
        public E remove(int index) {
            addTaint(index);
E varFBADEC94A2C3564C49874A24F23CA3FC_1518767455 =             l.remove(index);
            varFBADEC94A2C3564C49874A24F23CA3FC_1518767455.addTaint(taint);
            return varFBADEC94A2C3564C49874A24F23CA3FC_1518767455;
            // ---------- Original Method ----------
            //return l.remove(index);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.793 -0400", hash_original_method = "EB95E25E6439350950712FBE2C177EC4", hash_generated_method = "F3175075D801772DD88CBC5CED990A33")
        @Override
        public int indexOf(Object obj) {
            addTaint(obj.getTaint());
            int var1DF234A906E8BD4E44BDC0DE7EF71602_1249146834 = (l.indexOf(obj));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_472062744 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_472062744;
            // ---------- Original Method ----------
            //return l.indexOf(obj);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.793 -0400", hash_original_method = "4C828EC3A9818E335BF8E9F8513B24F5", hash_generated_method = "F472E94BD55F7A53CA51EFFE634EE801")
        @Override
        public int lastIndexOf(Object obj) {
            addTaint(obj.getTaint());
            int varDED6B6790C09A81175529A9A7872CCBA_381364238 = (l.lastIndexOf(obj));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1728091710 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1728091710;
            // ---------- Original Method ----------
            //return l.lastIndexOf(obj);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.793 -0400", hash_original_method = "9293980ECFF31B033CDADFB0ED26EA69", hash_generated_method = "3263E1E76C1B6C75C6DBD28260F1004E")
        @Override
        public ListIterator<E> listIterator() {
ListIterator<E> var82F7472176A949D32BDB07D4F238EAD8_562978662 =             new CheckedListIterator<E>(l.listIterator(), type);
            var82F7472176A949D32BDB07D4F238EAD8_562978662.addTaint(taint);
            return var82F7472176A949D32BDB07D4F238EAD8_562978662;
            // ---------- Original Method ----------
            //return new CheckedListIterator<E>(l.listIterator(), type);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.794 -0400", hash_original_method = "31D39D7FEEE82D7A15D00B805CB5EAA4", hash_generated_method = "DEEA93F2C2BF0C381EB5852653A65B57")
        @Override
        public ListIterator<E> listIterator(int index) {
            addTaint(index);
ListIterator<E> varA5F7F6B2E3F07D1D7E8CF79708EF7126_448826847 =             new CheckedListIterator<E>(l.listIterator(index), type);
            varA5F7F6B2E3F07D1D7E8CF79708EF7126_448826847.addTaint(taint);
            return varA5F7F6B2E3F07D1D7E8CF79708EF7126_448826847;
            // ---------- Original Method ----------
            //return new CheckedListIterator<E>(l.listIterator(index), type);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.794 -0400", hash_original_method = "A5E1EFD4B2650099AC132BF86B97D88F", hash_generated_method = "B76999A11CF204ED7F08480A7CD7E6E6")
        @Override
        public List<E> subList(int fromIndex, int toIndex) {
            addTaint(toIndex);
            addTaint(fromIndex);
List<E> var2F79FD966A1897206BC3D3B193AFC354_898498141 =             checkedList(l.subList(fromIndex, toIndex), type);
            var2F79FD966A1897206BC3D3B193AFC354_898498141.addTaint(taint);
            return var2F79FD966A1897206BC3D3B193AFC354_898498141;
            // ---------- Original Method ----------
            //return checkedList(l.subList(fromIndex, toIndex), type);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.794 -0400", hash_original_method = "A14AE2E014BAD465F594EE49A5008ED4", hash_generated_method = "73F57AF723C7855CC8E20D9066951003")
        @Override
        public boolean equals(Object obj) {
            addTaint(obj.getTaint());
            boolean var58A0CE9E62AE918ABE48926E1C3EC3CC_1852248750 = (l.equals(obj));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1157803766 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1157803766;
            // ---------- Original Method ----------
            //return l.equals(obj);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.794 -0400", hash_original_method = "410D1D1B2E05F678DF3AB7D6BB08AEDB", hash_generated_method = "68DCD3A2CE36EFBF40022F6768862F3B")
        @Override
        public int hashCode() {
            int var788FADE1ADA4414CD1C28D2471298E4A_785986903 = (l.hashCode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_92734608 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_92734608;
            // ---------- Original Method ----------
            //return l.hashCode();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.794 -0400", hash_original_field = "39F320D681E769EFF91E942BCC4C3E88", hash_generated_field = "872FF792DF349B762724C98686FE9FD7")

        private static final long serialVersionUID = 65247728283967356L;
    }


    
    private static class CheckedRandomAccessList<E> extends CheckedList<E> implements RandomAccess {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.797 -0400", hash_original_method = "77F175BCE2CEB5DECA5010A8855616A0", hash_generated_method = "DF70C138E9F4C5B1C1B4E34447142B86")
        public  CheckedRandomAccessList(List<E> l, Class<E> type) {
            super(l, type);
            addTaint(type.getTaint());
            addTaint(l.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.797 -0400", hash_original_field = "27B375DBE9246C47DAC482882EF8DD4B", hash_generated_field = "AE05DA4DC0253A1B88798E9C56DCC885")

        private static final long serialVersionUID = 1638200125423088369L;
    }


    
    private static class CheckedSet<E> extends CheckedCollection<E> implements Set<E> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.797 -0400", hash_original_method = "515963C9B1280D5707D3A720329B0AC0", hash_generated_method = "B78CA33EC3AFE414A9F8EB7EB33EED13")
        public  CheckedSet(Set<E> s, Class<E> type) {
            super(s, type);
            addTaint(type.getTaint());
            addTaint(s.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.797 -0400", hash_original_method = "F33AC6E694EC5A5F3A81FF749707DDFC", hash_generated_method = "A3A5AA25B6660549AF73896260ED36BE")
        @Override
        public boolean equals(Object obj) {
            addTaint(obj.getTaint());
            boolean var1AC73A2339BEAF3F5AD62D5280A99B42_200836406 = (c.equals(obj));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1036750256 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1036750256;
            // ---------- Original Method ----------
            //return c.equals(obj);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.797 -0400", hash_original_method = "E858D80F3EEDE9F2B52CDB7DA7FBF12B", hash_generated_method = "2AFB9B8B7EAD610670FA13A5EC3ECD6F")
        @Override
        public int hashCode() {
            int var3FFC490E9FA1D410CC240764C2B77761_1813525217 = (c.hashCode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_418166474 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_418166474;
            // ---------- Original Method ----------
            //return c.hashCode();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.797 -0400", hash_original_field = "C306DCFF324211BB06F1EDC3B62DB01C", hash_generated_field = "E1E04526085CC70B98A324ECDFB31198")

        private static final long serialVersionUID = 4694047833775013803L;
    }


    
    private static class CheckedMap<K, V> implements Map<K, V>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.797 -0400", hash_original_field = "6F8F57715090DA2632453988D9A1501B", hash_generated_field = "B770F05C5A3A992B6F65D731F667A79E")

        Map<K, V> m;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.797 -0400", hash_original_field = "056E0360B75D77ECE0AE955FE59BF15D", hash_generated_field = "F010784A251FB129AC47F47773283FBF")

        Class<K> keyType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.797 -0400", hash_original_field = "B96763B95160CC0943BE0DE4743A115B", hash_generated_field = "DE39CA4821E18DB5E7A7F09BBC028CB4")

        Class<V> valueType;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.797 -0400", hash_original_method = "906A4960963B0F972E50BE617CA562B3", hash_generated_method = "736784CD61B98BDCBC16A53741F55A38")
        private  CheckedMap(Map<K, V> m, Class<K> keyType, Class<V> valueType) {
            if(m == null || keyType == null || valueType == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1215878985 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1215878985.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1215878985;
            } //End block
            this.m = m;
            this.keyType = keyType;
            this.valueType = valueType;
            // ---------- Original Method ----------
            //if (m == null || keyType == null || valueType == null) {
                //throw new NullPointerException();
            //}
            //this.m = m;
            //this.keyType = keyType;
            //this.valueType = valueType;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.799 -0400", hash_original_method = "A04EE09DEB6F21FAA6A7E10DF6401CD1", hash_generated_method = "87E5C11C18F63A45F76EAC2D83110913")
        @Override
        public int size() {
            int var313B2D1C305A713CA398B12007C9967C_1047498468 = (m.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1809115284 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1809115284;
            // ---------- Original Method ----------
            //return m.size();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.799 -0400", hash_original_method = "B9E63D3C52241E7E917CB1416ABA36E5", hash_generated_method = "5600D5C8FCB50CA5ABF847E9304E3C69")
        @Override
        public boolean isEmpty() {
            boolean var6FFDB0B6EFF2802DEEBD39B93137FE90_1920270640 = (m.isEmpty());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_208874689 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_208874689;
            // ---------- Original Method ----------
            //return m.isEmpty();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.799 -0400", hash_original_method = "A6C730848D8A626F99D8229EE744E3C0", hash_generated_method = "A50A27A7D659FE065D338DF816A64B65")
        @Override
        public boolean containsKey(Object key) {
            addTaint(key.getTaint());
            boolean var62AFCABB34FB6B56AC689F51EB3A9E27_2011612811 = (m.containsKey(key));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_610094019 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_610094019;
            // ---------- Original Method ----------
            //return m.containsKey(key);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.799 -0400", hash_original_method = "EF8C00CF950E8C186D2F05E1E556F384", hash_generated_method = "D7DCC33292E23FCF3C83A8D1E6BE857A")
        @Override
        public boolean containsValue(Object value) {
            addTaint(value.getTaint());
            boolean varD6C1BCF4353E9D47F21CF5A12A4A7A3C_329583911 = (m.containsValue(value));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_331916293 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_331916293;
            // ---------- Original Method ----------
            //return m.containsValue(value);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.799 -0400", hash_original_method = "B8FE254B61C57EC3A6DCE539976DA268", hash_generated_method = "7B96E1F188DC0F0DF3074DEE04AA2EAF")
        @Override
        public V get(Object key) {
            addTaint(key.getTaint());
V var3A7E11B6611BEAA522E24ED974C59715_1763548895 =             m.get(key);
            var3A7E11B6611BEAA522E24ED974C59715_1763548895.addTaint(taint);
            return var3A7E11B6611BEAA522E24ED974C59715_1763548895;
            // ---------- Original Method ----------
            //return m.get(key);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.799 -0400", hash_original_method = "98010DFF1DD51631676FCAC604C1B694", hash_generated_method = "E65BB443412FB1C0B428904F29ACEB97")
        @Override
        public V put(K key, V value) {
            addTaint(value.getTaint());
            addTaint(key.getTaint());
V var4AD7AACB83E31077B624E290B9EC9824_1583051847 =             m.put(checkType(key, keyType), checkType(value, valueType));
            var4AD7AACB83E31077B624E290B9EC9824_1583051847.addTaint(taint);
            return var4AD7AACB83E31077B624E290B9EC9824_1583051847;
            // ---------- Original Method ----------
            //return m.put(checkType(key, keyType), checkType(value, valueType));
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.799 -0400", hash_original_method = "7E1C4ABAB7F4D30C9FA02B8AC4206202", hash_generated_method = "1CF58C8161489828FF7D4CA7BCA9754A")
        @Override
        public V remove(Object key) {
            addTaint(key.getTaint());
V varCFC4EE21887DEF986B37EBC86595687F_1948572469 =             m.remove(key);
            varCFC4EE21887DEF986B37EBC86595687F_1948572469.addTaint(taint);
            return varCFC4EE21887DEF986B37EBC86595687F_1948572469;
            // ---------- Original Method ----------
            //return m.remove(key);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.800 -0400", hash_original_method = "7B09FD67E4091CD76439ADACD213D3A2", hash_generated_method = "C0C9186DFE1DC4E3DD7726A7883CEDD3")
        @SuppressWarnings("unchecked")
        @Override
        public void putAll(Map<? extends K, ? extends V> map) {
            addTaint(map.getTaint());
            int size = map.size();
            if(size == 0)            
            {
                return;
            } //End block
            Map.Entry<? extends K, ? extends V>[] entries = new Map.Entry[size];
            Iterator<? extends Map.Entry<? extends K, ? extends V>> it = map
                    .entrySet().iterator();
for(int i = 0;i < size;i++)
            {
                Map.Entry<? extends K, ? extends V> e = it.next();
                checkType(e.getKey(), keyType);
                checkType(e.getValue(), valueType);
                entries[i] = e;
            } //End block
for(int i = 0;i < size;i++)
            {
                m.put(entries[i].getKey(), entries[i].getValue());
            } //End block
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.801 -0400", hash_original_method = "5163CA2ED3AD9C66F2BDAFB902590115", hash_generated_method = "5C1448B76AB003BA7ABB7E55C1011B37")
        @Override
        public void clear() {
            m.clear();
            // ---------- Original Method ----------
            //m.clear();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.801 -0400", hash_original_method = "BC85ABF91A39D98F3F2ED0838950D9FC", hash_generated_method = "AC24FF7CF474F2FC6F6DD8FC531A9D7A")
        @Override
        public Set<K> keySet() {
Set<K> var578A3E6F6455D1AAB4084B95C8582C2B_2075895818 =             m.keySet();
            var578A3E6F6455D1AAB4084B95C8582C2B_2075895818.addTaint(taint);
            return var578A3E6F6455D1AAB4084B95C8582C2B_2075895818;
            // ---------- Original Method ----------
            //return m.keySet();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.801 -0400", hash_original_method = "F6584059741E2818D171714370ED56BF", hash_generated_method = "8CC70FDB9E8CF9739A72CA0FCF72C594")
        @Override
        public Collection<V> values() {
Collection<V> var2300BDADCFD3189CDACD154819BF8B6C_218625224 =             m.values();
            var2300BDADCFD3189CDACD154819BF8B6C_218625224.addTaint(taint);
            return var2300BDADCFD3189CDACD154819BF8B6C_218625224;
            // ---------- Original Method ----------
            //return m.values();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.801 -0400", hash_original_method = "17C87BFAA3247941C0F3FE3FCE6C8B6B", hash_generated_method = "932895D0E72EB06688BC34D8AFF32589")
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
Set<Map.Entry<K, V>> varD2661C1B5438601B728B1367B701D81C_1132620308 =             new CheckedEntrySet<K, V>(m.entrySet(), valueType);
            varD2661C1B5438601B728B1367B701D81C_1132620308.addTaint(taint);
            return varD2661C1B5438601B728B1367B701D81C_1132620308;
            // ---------- Original Method ----------
            //return new CheckedEntrySet<K, V>(m.entrySet(), valueType);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.801 -0400", hash_original_method = "5F45CB6F19E1E41DEEA3711399B994B8", hash_generated_method = "6CE9BBFCE14AF74F21A7707911CEECA6")
        @Override
        public boolean equals(Object obj) {
            addTaint(obj.getTaint());
            boolean var800A7413EE12EF72F29B87C30CEE3C80_959608304 = (m.equals(obj));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1294857826 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1294857826;
            // ---------- Original Method ----------
            //return m.equals(obj);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.802 -0400", hash_original_method = "E3229E3389F030DD50B79734943DB788", hash_generated_method = "590A91F2A40B4F6EBC386A66AF707372")
        @Override
        public int hashCode() {
            int varE3BA1212D08FEDD275814D3960FD8F10_1785399738 = (m.hashCode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1610855827 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1610855827;
            // ---------- Original Method ----------
            //return m.hashCode();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.802 -0400", hash_original_method = "5DD44B3CD2826BF39F974F66579CF74F", hash_generated_method = "B48B9B6E559EE21CD4D51DADE2260013")
        @Override
        public String toString() {
String var8389EA5D3F4E9FD19F68E63143EE799F_1558700953 =             m.toString();
            var8389EA5D3F4E9FD19F68E63143EE799F_1558700953.addTaint(taint);
            return var8389EA5D3F4E9FD19F68E63143EE799F_1558700953;
            // ---------- Original Method ----------
            //return m.toString();
        }

        
        private static class CheckedEntry<K, V> implements Map.Entry<K, V> {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.802 -0400", hash_original_field = "E1671797C52E15F763380B45E841EC32", hash_generated_field = "FD10A3858A638ACB828326F81BE2C88B")

            Map.Entry<K, V> e;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.802 -0400", hash_original_field = "B96763B95160CC0943BE0DE4743A115B", hash_generated_field = "DE39CA4821E18DB5E7A7F09BBC028CB4")

            Class<V> valueType;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.802 -0400", hash_original_method = "7A5E92C112A4AAE1EEB574291E4B57B6", hash_generated_method = "651F2B7D39E4134CB19731CEAE842524")
            public  CheckedEntry(Map.Entry<K, V> e, Class<V> valueType) {
                if(e == null)                
                {
                    NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1022368871 = new NullPointerException();
                    var7338BC9F48D81FE0BBD6183F4014DCC4_1022368871.addTaint(taint);
                    throw var7338BC9F48D81FE0BBD6183F4014DCC4_1022368871;
                } //End block
                this.e = e;
                this.valueType = valueType;
                // ---------- Original Method ----------
                //if (e == null) {
                    //throw new NullPointerException();
                //}
                //this.e = e;
                //this.valueType = valueType;
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.803 -0400", hash_original_method = "10D87C621F2656D3DA7DCE234A4C3FAC", hash_generated_method = "1DE0892AD82D31DFEDA9A75D2CB29F7A")
            @Override
            public K getKey() {
K var9A71CD5F5DA92B60FFE52FF2C8232978_2088195920 =                 e.getKey();
                var9A71CD5F5DA92B60FFE52FF2C8232978_2088195920.addTaint(taint);
                return var9A71CD5F5DA92B60FFE52FF2C8232978_2088195920;
                // ---------- Original Method ----------
                //return e.getKey();
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.804 -0400", hash_original_method = "8EF21B2292AA31AAE181B3282F3F0262", hash_generated_method = "0E34F8EDC76BADBC08ECDCEDD4B7E516")
            @Override
            public V getValue() {
V varF257B8DB7DC59DBA8001AC54A776DE14_333187858 =                 e.getValue();
                varF257B8DB7DC59DBA8001AC54A776DE14_333187858.addTaint(taint);
                return varF257B8DB7DC59DBA8001AC54A776DE14_333187858;
                // ---------- Original Method ----------
                //return e.getValue();
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.804 -0400", hash_original_method = "22C63BC622BE9DF4D2BED624BDB5B6B5", hash_generated_method = "B572A8B7D554C748FDD396AA2A841493")
            @Override
            public V setValue(V obj) {
                addTaint(obj.getTaint());
V varA3C903465E9D2940193740B105ECB684_1100220153 =                 e.setValue(checkType(obj, valueType));
                varA3C903465E9D2940193740B105ECB684_1100220153.addTaint(taint);
                return varA3C903465E9D2940193740B105ECB684_1100220153;
                // ---------- Original Method ----------
                //return e.setValue(checkType(obj, valueType));
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.804 -0400", hash_original_method = "0FE63D6CB37B8BF21266876509A7EAAA", hash_generated_method = "78964FDB40D71B6BCCEBB16F2E6C8452")
            @Override
            public boolean equals(Object obj) {
                addTaint(obj.getTaint());
                boolean var0AE554311CD88A874F347078934E2E0A_497282274 = (e.equals(obj));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1116085995 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1116085995;
                // ---------- Original Method ----------
                //return e.equals(obj);
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.804 -0400", hash_original_method = "02C3AF7FB3CFA22B693B83D22D208AF4", hash_generated_method = "281DD6406F6BC6BB7AAAB462EFBCD92C")
            @Override
            public int hashCode() {
                int var1A2E54A5FA8DEA36886F410DCF59F5B3_1108292856 = (e.hashCode());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1382118260 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1382118260;
                // ---------- Original Method ----------
                //return e.hashCode();
            }

            
        }


        
        private static class CheckedEntrySet<K, V> implements Set<Map.Entry<K, V>> {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.804 -0400", hash_original_field = "03C7C0ACE395D80182DB07AE2C30F034", hash_generated_field = "00162E30A8FD9ACC3B5664D702737B9D")

            Set<Map.Entry<K, V>> s;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.804 -0400", hash_original_field = "B96763B95160CC0943BE0DE4743A115B", hash_generated_field = "DE39CA4821E18DB5E7A7F09BBC028CB4")

            Class<V> valueType;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.804 -0400", hash_original_method = "77FA7326B6BB5621E7FE63699FC58F08", hash_generated_method = "B92FFB70DAF3A02ECD73F8C030E830C0")
            public  CheckedEntrySet(Set<Map.Entry<K, V>> s, Class<V> valueType) {
                this.s = s;
                this.valueType = valueType;
                // ---------- Original Method ----------
                //this.s = s;
                //this.valueType = valueType;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.805 -0400", hash_original_method = "448F3F9279BA75C161BF1A7F97E105A4", hash_generated_method = "FD7F77FD28F676B52806C35196C0D024")
            @Override
            public Iterator<Map.Entry<K, V>> iterator() {
Iterator<Map.Entry<K, V>> var1CE93D03EC65B81E876F3306781A9757_188718215 =                 new CheckedEntryIterator<K, V>(s.iterator(), valueType);
                var1CE93D03EC65B81E876F3306781A9757_188718215.addTaint(taint);
                return var1CE93D03EC65B81E876F3306781A9757_188718215;
                // ---------- Original Method ----------
                //return new CheckedEntryIterator<K, V>(s.iterator(), valueType);
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.809 -0400", hash_original_method = "0FB4B292E50A952F877CB518E0A96CF9", hash_generated_method = "E915604F524349E8EDA45B4839793CAB")
            @Override
            public Object[] toArray() {
                int thisSize = size();
                Object[] array = new Object[thisSize];
                Iterator<?> it = iterator();
for(int i = 0;i < thisSize;i++)
                {
                    array[i] = it.next();
                } //End block
Object[] var1270D5B74B756F17D644A15D775499D9_2032106389 =                 array;
                var1270D5B74B756F17D644A15D775499D9_2032106389.addTaint(taint);
                return var1270D5B74B756F17D644A15D775499D9_2032106389;
                // ---------- Original Method ----------
                //int thisSize = size();
                //Object[] array = new Object[thisSize];
                //Iterator<?> it = iterator();
                //for (int i = 0; i < thisSize; i++) {
                    //array[i] = it.next();
                //}
                //return array;
            }

            
                        @DSModeled(DSC.SAFE)
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
                var1270D5B74B756F17D644A15D775499D9_2051754257.addTaint(taint);
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

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.809 -0400", hash_original_method = "C32F0C36534158E273107417143214BD", hash_generated_method = "BC6AD2257781529CDD4CB1062D36EDC9")
            @Override
            public boolean retainAll(Collection<?> c) {
                addTaint(c.getTaint());
                boolean varAF54F6E00DC3C23801B63586C3FA5E53_1363461877 = (s.retainAll(c));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1343020236 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1343020236;
                // ---------- Original Method ----------
                //return s.retainAll(c);
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.809 -0400", hash_original_method = "B2624C46EA911C8D7CBCD3DB1975A601", hash_generated_method = "0810F4125011739D683E63EEA6A382DD")
            @Override
            public boolean removeAll(Collection<?> c) {
                addTaint(c.getTaint());
                boolean var342F761313C1D4EC5227ECBC3623923F_1247514666 = (s.removeAll(c));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_160522217 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_160522217;
                // ---------- Original Method ----------
                //return s.removeAll(c);
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.810 -0400", hash_original_method = "D8F4D306F45D40205BDE17116DDFF9FA", hash_generated_method = "124F4D95BA028ABFC100AB6A60EC5DED")
            @Override
            public boolean containsAll(Collection<?> c) {
                addTaint(c.getTaint());
                boolean var58784A4FF377404278CAB1E899E3C954_123278230 = (s.containsAll(c));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2129938248 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2129938248;
                // ---------- Original Method ----------
                //return s.containsAll(c);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.811 -0400", hash_original_method = "0D1A7F281A8819D32245C163B79E338D", hash_generated_method = "3D363D989C18DE27B2655AD8DDB31706")
            @Override
            public boolean addAll(Collection<? extends Map.Entry<K, V>> c) {
                addTaint(c.getTaint());
                UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_334492699 = new UnsupportedOperationException();
                var81FA7E299EEE7F062EBFBEEF08B0464D_334492699.addTaint(taint);
                throw var81FA7E299EEE7F062EBFBEEF08B0464D_334492699;
                // ---------- Original Method ----------
                //throw new UnsupportedOperationException();
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.811 -0400", hash_original_method = "46F35AD7CAD80E45E374449F130E7D0D", hash_generated_method = "AF4065406628FC1DFF0F9FCC449A8E4C")
            @Override
            public boolean remove(Object o) {
                addTaint(o.getTaint());
                boolean var6EA654AFD4548B7464E002E122EAB6C2_34566766 = (s.remove(o));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_149000975 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_149000975;
                // ---------- Original Method ----------
                //return s.remove(o);
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.811 -0400", hash_original_method = "A91421BB58ED7F6569B24AAD1B5804AB", hash_generated_method = "36AAFB96183541F4A08601C00B1ED89C")
            @Override
            public boolean contains(Object o) {
                addTaint(o.getTaint());
                boolean var422BEDB344BEE464C285B83189BC45C7_1277628110 = (s.contains(o));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_17956070 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_17956070;
                // ---------- Original Method ----------
                //return s.contains(o);
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.812 -0400", hash_original_method = "8704A9C8AC3AA02909B00E4E211C4D3E", hash_generated_method = "7861E9F44A94883D36C0944B9D866134")
            @Override
            public boolean add(Map.Entry<K, V> o) {
                addTaint(o.getTaint());
                UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1474642054 = new UnsupportedOperationException();
                var81FA7E299EEE7F062EBFBEEF08B0464D_1474642054.addTaint(taint);
                throw var81FA7E299EEE7F062EBFBEEF08B0464D_1474642054;
                // ---------- Original Method ----------
                //throw new UnsupportedOperationException();
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.812 -0400", hash_original_method = "1DB64DC7E3E98DAB777752CA6247DAE5", hash_generated_method = "F7BA65704AEAD714C349E7B616F0D814")
            @Override
            public boolean isEmpty() {
                boolean var40AB6CA90C65F09F18D0FDE3E5969584_989677249 = (s.isEmpty());
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1501669558 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1501669558;
                // ---------- Original Method ----------
                //return s.isEmpty();
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.812 -0400", hash_original_method = "3294D1F2516BD356F42ED84BE178EFCB", hash_generated_method = "8CAFCFFD1A3B734527CE3A6B8BDDA468")
            @Override
            public void clear() {
                s.clear();
                // ---------- Original Method ----------
                //s.clear();
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.812 -0400", hash_original_method = "61480F19A13469EF561F92E5A3700C23", hash_generated_method = "577288055042EC829F072B5A84D1B4F1")
            @Override
            public int size() {
                int varE9580031F3474F849262EB0A79D5C25A_1895362912 = (s.size());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_125634837 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_125634837;
                // ---------- Original Method ----------
                //return s.size();
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.812 -0400", hash_original_method = "150ADDC982A3B6D8A573E663C38A7C9E", hash_generated_method = "4156B3CA1B3E1837163DA917717208EB")
            @Override
            public int hashCode() {
                int var4C8AC03F4D998D80C4FDFCF9D8EE7706_385577000 = (s.hashCode());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_229656896 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_229656896;
                // ---------- Original Method ----------
                //return s.hashCode();
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.812 -0400", hash_original_method = "2565EBD5FCFC00F10C086CB36B3EEE8C", hash_generated_method = "55C7CC0AC880858538CB6656B372F8C8")
            @Override
            public boolean equals(Object object) {
                addTaint(object.getTaint());
                boolean varAF04D4835E7DD6BFE03DE76B7678DB28_300192309 = (s.equals(object));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_300150713 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_300150713;
                // ---------- Original Method ----------
                //return s.equals(object);
            }

            
            private static class CheckedEntryIterator<K, V> implements Iterator<Map.Entry<K, V>> {
                @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.813 -0400", hash_original_field = "865C0C0B4AB0E063E5CAA3387C1A8741", hash_generated_field = "0B0E1D6BACD1F756FB2A478A3878B968")

                Iterator<Map.Entry<K, V>> i;
                @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.813 -0400", hash_original_field = "B96763B95160CC0943BE0DE4743A115B", hash_generated_field = "DE39CA4821E18DB5E7A7F09BBC028CB4")

                Class<V> valueType;
                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.814 -0400", hash_original_method = "3CE5E36A95DFE16D33C2CC4176CB7EE4", hash_generated_method = "A4AE63E616DC64A732B8C1B01DFD5833")
                public  CheckedEntryIterator(Iterator<Map.Entry<K, V>> i,
                        Class<V> valueType) {
                    this.i = i;
                    this.valueType = valueType;
                    // ---------- Original Method ----------
                    //this.i = i;
                    //this.valueType = valueType;
                }

                
                                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.814 -0400", hash_original_method = "59CA86A80410B66286C92523CF35EC7B", hash_generated_method = "56B07F552551259C5785E48762118414")
                @Override
                public boolean hasNext() {
                    boolean varD1B5E3BB1A727F5E42DA5D458C9BD3D7_419132855 = (i.hasNext());
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2047035914 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_2047035914;
                    // ---------- Original Method ----------
                    //return i.hasNext();
                }

                
                                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.814 -0400", hash_original_method = "048FA6C3E3A28865AD880AF8A3FCAE96", hash_generated_method = "598E37F558FC71BB5A0DA7BBE13EE694")
                @Override
                public void remove() {
                    i.remove();
                    // ---------- Original Method ----------
                    //i.remove();
                }

                
                @DSModeled(DSC.SAFE)
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.814 -0400", hash_original_method = "4D16E0BB01C90351B8312D1A4B7DB5F2", hash_generated_method = "505A7BA0C93B3926FF38FA2EC353BB01")
                @Override
                public Map.Entry<K, V> next() {
Map.Entry<K, V> var748211921A39127C7457517172B3D64F_1738323667 =                     new CheckedEntry<K, V>(i.next(), valueType);
                    var748211921A39127C7457517172B3D64F_1738323667.addTaint(taint);
                    return var748211921A39127C7457517172B3D64F_1738323667;
                    // ---------- Original Method ----------
                    //return new CheckedEntry<K, V>(i.next(), valueType);
                }

                
            }


            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.814 -0400", hash_original_field = "3AB92C151F5D124E5C475918FE5C2CE3", hash_generated_field = "9F44A98BA336AC9320984E43122649C3")

        private static final long serialVersionUID = 5742860141034234728L;
    }


    
    private static class CheckedSortedSet<E> extends CheckedSet<E> implements SortedSet<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.815 -0400", hash_original_field = "3691308F2A4C2F6983F2880D32E29C84", hash_generated_field = "5220A6F2AA4CB98BB6C290F0BB717E86")

        private SortedSet<E> ss;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.815 -0400", hash_original_method = "70499BD9B05065D265D741875DD058CA", hash_generated_method = "E0CB6B46CEED761E7FB456CA464AE231")
        public  CheckedSortedSet(SortedSet<E> s, Class<E> type) {
            super(s, type);
            addTaint(type.getTaint());
            this.ss = s;
            // ---------- Original Method ----------
            //this.ss = s;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.815 -0400", hash_original_method = "8514D9255D678B041F55D03BA11DCA3B", hash_generated_method = "11A9C2D7C35D19DF88D2F3AA3419C0F5")
        @Override
        public Comparator<? super E> comparator() {
Comparator<? super E> varEF7DDB49085F2DA083783C6BC3481D0B_956731464 =             ss.comparator();
            varEF7DDB49085F2DA083783C6BC3481D0B_956731464.addTaint(taint);
            return varEF7DDB49085F2DA083783C6BC3481D0B_956731464;
            // ---------- Original Method ----------
            //return ss.comparator();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.816 -0400", hash_original_method = "82539AB1166DFBB28D0E3DC3D0A43121", hash_generated_method = "F15830FABD3515E38DECFA833E31AC32")
        @Override
        public SortedSet<E> subSet(E fromElement, E toElement) {
            addTaint(toElement.getTaint());
            addTaint(fromElement.getTaint());
SortedSet<E> var39AA1D247C1203BB17C04F0195F66299_100025839 =             new CheckedSortedSet<E>(ss.subSet(fromElement, toElement),
                    type);
            var39AA1D247C1203BB17C04F0195F66299_100025839.addTaint(taint);
            return var39AA1D247C1203BB17C04F0195F66299_100025839;
            // ---------- Original Method ----------
            //return new CheckedSortedSet<E>(ss.subSet(fromElement, toElement),
                    //type);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.816 -0400", hash_original_method = "68D546866615C37E07B8E968E3813E84", hash_generated_method = "8E09DFBFB472E9ACA5F0794F8D3B7F0A")
        @Override
        public SortedSet<E> headSet(E toElement) {
            addTaint(toElement.getTaint());
SortedSet<E> var1D39AA96765B31B89807B0D278A7743C_1136057867 =             new CheckedSortedSet<E>(ss.headSet(toElement), type);
            var1D39AA96765B31B89807B0D278A7743C_1136057867.addTaint(taint);
            return var1D39AA96765B31B89807B0D278A7743C_1136057867;
            // ---------- Original Method ----------
            //return new CheckedSortedSet<E>(ss.headSet(toElement), type);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.816 -0400", hash_original_method = "B0B4B667BF95B9D9A3CD3F7FE8BEFA1B", hash_generated_method = "7A3666725F9DE0D4944EBDB595F2AD84")
        @Override
        public SortedSet<E> tailSet(E fromElement) {
            addTaint(fromElement.getTaint());
SortedSet<E> var695EA00B3C338D4293284A5AE68D1604_89472955 =             new CheckedSortedSet<E>(ss.tailSet(fromElement), type);
            var695EA00B3C338D4293284A5AE68D1604_89472955.addTaint(taint);
            return var695EA00B3C338D4293284A5AE68D1604_89472955;
            // ---------- Original Method ----------
            //return new CheckedSortedSet<E>(ss.tailSet(fromElement), type);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.816 -0400", hash_original_method = "6BB6C51843B41CC0DCB5509A79DBA008", hash_generated_method = "4AA1A44F75A96ABD615B6A73634D58D0")
        @Override
        public E first() {
E varE64C384BCBD0BF9F8BB2385886B7C815_1542427542 =             ss.first();
            varE64C384BCBD0BF9F8BB2385886B7C815_1542427542.addTaint(taint);
            return varE64C384BCBD0BF9F8BB2385886B7C815_1542427542;
            // ---------- Original Method ----------
            //return ss.first();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.817 -0400", hash_original_method = "AAC5DDE787ACA85752B94AAB77F6B0F8", hash_generated_method = "7CAC722A3FDDAC17AA0FC36F0D7A5897")
        @Override
        public E last() {
E var7A1B325A772301476E34C1CFA8ED9C89_145393978 =             ss.last();
            var7A1B325A772301476E34C1CFA8ED9C89_145393978.addTaint(taint);
            return var7A1B325A772301476E34C1CFA8ED9C89_145393978;
            // ---------- Original Method ----------
            //return ss.last();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.817 -0400", hash_original_field = "45BA83A718F7437B80255AD942C73A67", hash_generated_field = "EFEBE119B7009CBFA7ED7A5DC59F8042")

        private static final long serialVersionUID = 1599911165492914959L;
    }


    
    private static class CheckedSortedMap<K, V> extends CheckedMap<K, V> implements SortedMap<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.817 -0400", hash_original_field = "ED79ACB0CD3D7F8320C53C7798335EF0", hash_generated_field = "41E5EF207399B1082121011C1EB446FF")

        SortedMap<K, V> sm;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.817 -0400", hash_original_method = "2CB6EA0E6447E5AAF8B28B5FDF140BE4", hash_generated_method = "BA56DA0EAD27E7AF04AC58C9B976F523")
          CheckedSortedMap(SortedMap<K, V> m, Class<K> keyType, Class<V> valueType) {
            super(m, keyType, valueType);
            addTaint(valueType.getTaint());
            addTaint(keyType.getTaint());
            this.sm = m;
            // ---------- Original Method ----------
            //this.sm = m;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.817 -0400", hash_original_method = "E5FDBCC6560BE7E99B2D2F850BD84149", hash_generated_method = "94AABB71112B602D7967AA2CDE3C5E11")
        @Override
        public Comparator<? super K> comparator() {
Comparator<? super K> varEAAD6156DF3FBB0DB169CF3701FE5DAA_91908963 =             sm.comparator();
            varEAAD6156DF3FBB0DB169CF3701FE5DAA_91908963.addTaint(taint);
            return varEAAD6156DF3FBB0DB169CF3701FE5DAA_91908963;
            // ---------- Original Method ----------
            //return sm.comparator();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.817 -0400", hash_original_method = "65DE11E398BB209CD2689071C041161A", hash_generated_method = "78F02ABB8E95CA290E595128B56E68BE")
        @Override
        public SortedMap<K, V> subMap(K fromKey, K toKey) {
            addTaint(toKey.getTaint());
            addTaint(fromKey.getTaint());
SortedMap<K, V> varA3CD70A724558DE3D9382CE6CF4CCBAF_1030986867 =             new CheckedSortedMap<K, V>(sm.subMap(fromKey, toKey), keyType, valueType);
            varA3CD70A724558DE3D9382CE6CF4CCBAF_1030986867.addTaint(taint);
            return varA3CD70A724558DE3D9382CE6CF4CCBAF_1030986867;
            // ---------- Original Method ----------
            //return new CheckedSortedMap<K, V>(sm.subMap(fromKey, toKey), keyType, valueType);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.818 -0400", hash_original_method = "2C5724B582D2FAB5716323DB894A671D", hash_generated_method = "7D87D1978FC314F7EAEF8474B4912F77")
        @Override
        public SortedMap<K, V> headMap(K toKey) {
            addTaint(toKey.getTaint());
SortedMap<K, V> var6CAD4B9D7CCF5B6A99FE852125447B2A_1138612523 =             new CheckedSortedMap<K, V>(sm.headMap(toKey), keyType, valueType);
            var6CAD4B9D7CCF5B6A99FE852125447B2A_1138612523.addTaint(taint);
            return var6CAD4B9D7CCF5B6A99FE852125447B2A_1138612523;
            // ---------- Original Method ----------
            //return new CheckedSortedMap<K, V>(sm.headMap(toKey), keyType, valueType);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.818 -0400", hash_original_method = "2879524DD09B17D2FCB7AD1626D24618", hash_generated_method = "1E3B8BDD13B87FBC5C335D9464C8ED58")
        @Override
        public SortedMap<K, V> tailMap(K fromKey) {
            addTaint(fromKey.getTaint());
SortedMap<K, V> var9E2A7B6D989F59E06621CB44A1A3AFE0_434386008 =             new CheckedSortedMap<K, V>(sm.tailMap(fromKey), keyType, valueType);
            var9E2A7B6D989F59E06621CB44A1A3AFE0_434386008.addTaint(taint);
            return var9E2A7B6D989F59E06621CB44A1A3AFE0_434386008;
            // ---------- Original Method ----------
            //return new CheckedSortedMap<K, V>(sm.tailMap(fromKey), keyType, valueType);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.818 -0400", hash_original_method = "B25E8C7440C76FBF812FF7AC9CA9D776", hash_generated_method = "DF8F133C05C239736266BD572ACF0A54")
        @Override
        public K firstKey() {
K varA58D1FB276F66FC6ABBF4CA9E354FD1B_1168753497 =             sm.firstKey();
            varA58D1FB276F66FC6ABBF4CA9E354FD1B_1168753497.addTaint(taint);
            return varA58D1FB276F66FC6ABBF4CA9E354FD1B_1168753497;
            // ---------- Original Method ----------
            //return sm.firstKey();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.819 -0400", hash_original_method = "00E9126A84DE8B71214859A17DA6BD2E", hash_generated_method = "D4B1FE3A6260D6353DFD87F6083AA65A")
        @Override
        public K lastKey() {
K varC4E8101F3F71352235F4E401D4498536_249888266 =             sm.lastKey();
            varC4E8101F3F71352235F4E401D4498536_249888266.addTaint(taint);
            return varC4E8101F3F71352235F4E401D4498536_249888266;
            // ---------- Original Method ----------
            //return sm.lastKey();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.819 -0400", hash_original_field = "4011ADBAF6264DE3F59FECC188B42ACB", hash_generated_field = "48CAB95B26D6FD20C5A6CF4DE2F667C3")

        private static final long serialVersionUID = 1599671320688067438L;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.459 -0400", hash_original_field = "BF19162ABA3425F946F5D9B6685AC2EC", hash_generated_field = "66C8EDF172F44B1C185312659E6B7E7F")

    private static final Enumeration<?> EMPTY_ENUMERATION = new Enumeration<Object>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.458 -0400", hash_original_method = "50CD0E92886EDA5BEE0164B092B351EC", hash_generated_method = "5846EE9EB8DDDDC0896316CB4D84FA05")
        @Override
        public boolean hasMoreElements() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_923760985 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_923760985;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.459 -0400", hash_original_method = "82381D9C34AF9F2E88B673FB4A4E6DDE", hash_generated_method = "C451DB608AE3B7FAE82365C2FA63C59D")
        @Override
        public Object nextElement() {
        	throw new NoSuchElementException();
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.819 -0400", hash_original_field = "E5D97468931D831222F89B33B06414C4", hash_generated_field = "1967470EF0F42FDB7D6E965615F956D6")

    @SuppressWarnings("unchecked")
    public static final List EMPTY_LIST = new EmptyList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.819 -0400", hash_original_field = "19637326155AD7B58E274FC2717EADC0", hash_generated_field = "EF8031119D3626285E32D155A57C6695")

    @SuppressWarnings("unchecked")
    public static final Set EMPTY_SET = new EmptySet();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.819 -0400", hash_original_field = "712F6D9422DE94FBE0F2A8F69D9E29D0", hash_generated_field = "F465655F33C72E2E2F297BFA1010664E")

    @SuppressWarnings("unchecked")
    public static final Map EMPTY_MAP = new EmptyMap();
}

