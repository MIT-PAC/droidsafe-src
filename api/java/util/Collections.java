package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Array;

public class Collections {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.473 -0400", hash_original_method = "0C1BC548FC19EEB6A684F12763720939", hash_generated_method = "F5EC8594995493427AAF50F2EB8C349F")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.480 -0400", hash_original_field = "7B8B965AD4BCA0E41AB51DE7B31363A1", hash_generated_field = "01825CC32046BF0FBE11738ABC136518")

        private int n;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.480 -0400", hash_original_field = "8E2DCFD7E7E24B1CA76C1193F645902B", hash_generated_field = "93B043155067F80D0269375649E4D7D4")

        private E element;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.481 -0400", hash_original_method = "5A122D173062D06824D4571736320F87", hash_generated_method = "1A43A5296B62C4E3E324E7CAB676552E")
          CopiesList(int length, E object) {
    if(length < 0)            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_2066346895 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_2066346895.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_2066346895;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.481 -0400", hash_original_method = "B07BCF81C9C48C72A08077A0468A8769", hash_generated_method = "B2487239A1FF8A66207452174D7A30A7")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            boolean var1BF6311B6B832E206CDF43172C74BED5_1111149347 = (element == null ? object == null : element.equals(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1822265005 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1822265005;
            // ---------- Original Method ----------
            //return element == null ? object == null : element.equals(object);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.481 -0400", hash_original_method = "61094B9B9DEC6161E82512577FAF3323", hash_generated_method = "929D2518211E60B060930805F21076CD")
        @Override
        public int size() {
            int var7B8B965AD4BCA0E41AB51DE7B31363A1_546070896 = (n);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_140681901 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_140681901;
            // ---------- Original Method ----------
            //return n;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.481 -0400", hash_original_method = "857A70B35DA7146CF7ADC484EC4AABC8", hash_generated_method = "5865A676E527BE80190F7DBB7E1B5E02")
        @Override
        public E get(int location) {
            addTaint(location);
    if(location >= 0 && location < n)            
            {
E var24D05606CDD4BC4C89F2F5A15C16F343_830228875 =                 element;
                var24D05606CDD4BC4C89F2F5A15C16F343_830228875.addTaint(taint);
                return var24D05606CDD4BC4C89F2F5A15C16F343_830228875;
            } //End block
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_515012059 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_515012059.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_515012059;
            // ---------- Original Method ----------
            //if (location >= 0 && location < n) {
                //return element;
            //}
            //throw new IndexOutOfBoundsException();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.482 -0400", hash_original_field = "6A61C247691E7C356BC04B2E9E793190", hash_generated_field = "2ACBEBBA06800CFC571100A6231B0F40")

        private static final long serialVersionUID = 2739099268398711800L;
    }


    
    private static final class EmptyList extends AbstractList implements RandomAccess, Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.482 -0400", hash_original_method = "BF3F11B0BCAE2AE80C7C74CBEB88EB5B", hash_generated_method = "BF3F11B0BCAE2AE80C7C74CBEB88EB5B")
        public EmptyList ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.482 -0400", hash_original_method = "38B750FD34BF6CB1144CDF020D3299E6", hash_generated_method = "444C741AC49398C14B9DBBDCF612D00E")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_899787102 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1176927456 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1176927456;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.482 -0400", hash_original_method = "F4586E3A64B5D10DEB709A723C85E55E", hash_generated_method = "464FDAC0091B4DA2265E8277E7BA1844")
        @Override
        public int size() {
            int varCFCD208495D565EF66E7DFF9F98764DA_1560900944 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1237932401 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1237932401;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.483 -0400", hash_original_method = "F59F44D1664BC2EE59D5A9B30D144285", hash_generated_method = "BEF38668073CA1351535F5A0C35E13F7")
        @Override
        public Object get(int location) {
            addTaint(location);
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1643340676 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1643340676.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1643340676;
            // ---------- Original Method ----------
            //throw new IndexOutOfBoundsException();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.483 -0400", hash_original_method = "3CB4CAF1EADC3F12C565BD7D2B5F5514", hash_generated_method = "2158334D50875E40E814341198F9B1AD")
        private Object readResolve() {
Object var41537F84856EC2B8175806D98827383E_1665083677 =             Collections.EMPTY_LIST;
            var41537F84856EC2B8175806D98827383E_1665083677.addTaint(taint);
            return var41537F84856EC2B8175806D98827383E_1665083677;
            // ---------- Original Method ----------
            //return Collections.EMPTY_LIST;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.483 -0400", hash_original_field = "FEEABBF180D6F8A042B90CBFA55A4A94", hash_generated_field = "F94EA5528856E40DE43B84AB4D470D7D")

        private static final long serialVersionUID = 8842843931221139166L;
    }


    
    private static final class EmptySet extends AbstractSet implements Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.483 -0400", hash_original_method = "3A37381B9598D46CF46D5D53F85DF5B1", hash_generated_method = "3A37381B9598D46CF46D5D53F85DF5B1")
        public EmptySet ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.483 -0400", hash_original_method = "38B750FD34BF6CB1144CDF020D3299E6", hash_generated_method = "A6B2E5EDF6B2E2236EC8F1AB184DD46F")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_339249386 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_118343130 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_118343130;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.483 -0400", hash_original_method = "F4586E3A64B5D10DEB709A723C85E55E", hash_generated_method = "4DA4A7EED38E23B457250A53B1D87D03")
        @Override
        public int size() {
            int varCFCD208495D565EF66E7DFF9F98764DA_1804043722 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_223404643 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_223404643;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.484 -0400", hash_original_method = "FC88A4B2F50E498E162F3F7EEDE885B1", hash_generated_method = "5E6C2B8FB8F2813015054DC935C78393")
        @Override
        public Iterator iterator() {
Iterator var2DC6937AF28EC3FA949592521F2521D5_1773585260 =             EMPTY_ITERATOR;
            var2DC6937AF28EC3FA949592521F2521D5_1773585260.addTaint(taint);
            return var2DC6937AF28EC3FA949592521F2521D5_1773585260;
            // ---------- Original Method ----------
            //return EMPTY_ITERATOR;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.484 -0400", hash_original_method = "2ED0845ADEAE5655731C197578B08F82", hash_generated_method = "892236E62E979EA34B57BC8B03F3D73F")
        private Object readResolve() {
Object varF4CA34D7BD1863138D7F8BDB7243DF79_1977528406 =             Collections.EMPTY_SET;
            varF4CA34D7BD1863138D7F8BDB7243DF79_1977528406.addTaint(taint);
            return varF4CA34D7BD1863138D7F8BDB7243DF79_1977528406;
            // ---------- Original Method ----------
            //return Collections.EMPTY_SET;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.484 -0400", hash_original_field = "EBC69A53BFBAE35613EC4BD95CB98F92", hash_generated_field = "A81D1AE03C05E931255584261EF756E0")

        private static final long serialVersionUID = 1582296315990362920L;
    }


    
    private static final class EmptyMap extends AbstractMap implements Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.484 -0400", hash_original_method = "0E8F36F90F9C751DA5A12903A16705DF", hash_generated_method = "0E8F36F90F9C751DA5A12903A16705DF")
        public EmptyMap ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.484 -0400", hash_original_method = "2AD0E7E75E88E287D6229481B74BEBCC", hash_generated_method = "58D01FE91AD0F81E1C7BB96A20743F97")
        @Override
        public boolean containsKey(Object key) {
            addTaint(key.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_1428106675 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_504173078 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_504173078;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.485 -0400", hash_original_method = "9D32B6FFC088649ED5480F6E533A1288", hash_generated_method = "D40111FEF789C48AD1BF0624F62C5660")
        @Override
        public boolean containsValue(Object value) {
            addTaint(value.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_1757878042 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_676125930 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_676125930;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.485 -0400", hash_original_method = "709DD403C63D2F4104FF93FEEB6E3457", hash_generated_method = "70859CF723D23C47B652901B06F2D54C")
        @Override
        public Set entrySet() {
Set varF0EE7499B60CBE7D6945072EDEE0BCAD_2061016952 =             EMPTY_SET;
            varF0EE7499B60CBE7D6945072EDEE0BCAD_2061016952.addTaint(taint);
            return varF0EE7499B60CBE7D6945072EDEE0BCAD_2061016952;
            // ---------- Original Method ----------
            //return EMPTY_SET;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.485 -0400", hash_original_method = "59A1188DDD48CFFB749850DC2DA09C1D", hash_generated_method = "E9890906974803FCB7AA1EAB1145337D")
        @Override
        public Object get(Object key) {
            addTaint(key.getTaint());
Object var540C13E9E156B687226421B24F2DF178_1712064065 =             null;
            var540C13E9E156B687226421B24F2DF178_1712064065.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1712064065;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.485 -0400", hash_original_method = "266B164C16644761E32491964C192EB7", hash_generated_method = "B66268E8C324C34B9ED7F41339F657C9")
        @Override
        public Set keySet() {
Set varF0EE7499B60CBE7D6945072EDEE0BCAD_614725773 =             EMPTY_SET;
            varF0EE7499B60CBE7D6945072EDEE0BCAD_614725773.addTaint(taint);
            return varF0EE7499B60CBE7D6945072EDEE0BCAD_614725773;
            // ---------- Original Method ----------
            //return EMPTY_SET;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.486 -0400", hash_original_method = "745E6E226DD5F7D4E763DA74DFF70792", hash_generated_method = "20B569B55914C92D1DB00EBF5B1680D1")
        @Override
        public Collection values() {
Collection var3EB787547078B98C6DA0C5CC8DE617C5_1212377434 =             EMPTY_LIST;
            var3EB787547078B98C6DA0C5CC8DE617C5_1212377434.addTaint(taint);
            return var3EB787547078B98C6DA0C5CC8DE617C5_1212377434;
            // ---------- Original Method ----------
            //return EMPTY_LIST;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.486 -0400", hash_original_method = "59A22E9415A338EB85D7A7DD214359CC", hash_generated_method = "075CDA64577DF324111524840A83B1B1")
        private Object readResolve() {
Object var82C06B799CE89F4FFB58A600643773F8_1152042549 =             Collections.EMPTY_MAP;
            var82C06B799CE89F4FFB58A600643773F8_1152042549.addTaint(taint);
            return var82C06B799CE89F4FFB58A600643773F8_1152042549;
            // ---------- Original Method ----------
            //return Collections.EMPTY_MAP;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.486 -0400", hash_original_field = "71F087EB1E9FCDB60C678B95061CEBBD", hash_generated_field = "847A5C63C9A66D8A1818A774A2AADB69")

        private static final long serialVersionUID = 6428348081105594320L;
    }


    
    private static final class ReverseComparator<T> implements Comparator<T>, Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.486 -0400", hash_original_method = "FFB2FB11DBE006893CA9746ECCE68517", hash_generated_method = "FFB2FB11DBE006893CA9746ECCE68517")
        public ReverseComparator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.487 -0400", hash_original_method = "907488F1D5625FE5C9F59ED8A7B6E697", hash_generated_method = "2A0D32BB92F616CE7A9F7F3509D8F1BC")
        @SuppressWarnings("unchecked")
        @Override
        public int compare(T o1, T o2) {
            addTaint(o2.getTaint());
            addTaint(o1.getTaint());
            Comparable<T> c2 = (Comparable<T>) o2;
            int varA26B336DE8F584880A26AED2B3F89007_1433227411 = (c2.compareTo(o1));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2070217553 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2070217553;
            // ---------- Original Method ----------
            //Comparable<T> c2 = (Comparable<T>) o2;
            //return c2.compareTo(o1);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.487 -0400", hash_original_method = "DD371F0FDF8300FDCFBD1E5C395D42BC", hash_generated_method = "97D1697BC8A1D44E7C5160F7F4D359C7")
        private Object readResolve() throws ObjectStreamException {
Object var30C80D8445A0CA6A7769041AAD00A443_686273832 =             INSTANCE;
            var30C80D8445A0CA6A7769041AAD00A443_686273832.addTaint(taint);
            return var30C80D8445A0CA6A7769041AAD00A443_686273832;
            // ---------- Original Method ----------
            //return INSTANCE;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.487 -0400", hash_original_field = "2B003AD2E801398B9507D8ADBBB584A6", hash_generated_field = "28B0E21DBABF675E471021CA76588F6A")

        private static final ReverseComparator<Object> INSTANCE = new ReverseComparator<Object>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.487 -0400", hash_original_field = "844E6A53F14D8AD803480DAA1F2399E0", hash_generated_field = "410EA5184B11CE9687E932D7F263B83C")

        private static final long serialVersionUID = 7207038068494060240L;
    }


    
    private static final class ReverseComparator2<T> implements Comparator<T>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.487 -0400", hash_original_field = "31B4E550AA5FD883246F9B9CEAE82483", hash_generated_field = "ACD6D4A2528BA4BAF7406DE3D3F49FE6")

        private Comparator<T> cmp;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.488 -0400", hash_original_method = "1ABA0972F29BDB004C28A1246ABEF788", hash_generated_method = "B92E5576724AB283C109FF5B16A47456")
          ReverseComparator2(Comparator<T> comparator) {
            this.cmp = comparator;
            // ---------- Original Method ----------
            //this.cmp = comparator;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.488 -0400", hash_original_method = "449D1B24DD0E97F4D53DEB786BD04597", hash_generated_method = "3F1E66E19AEDB4A2EAE11CF5B5C4F697")
        @Override
        public int compare(T o1, T o2) {
            addTaint(o2.getTaint());
            addTaint(o1.getTaint());
            int varB28B1809248E2B27B989EA42D6697691_98117616 = (cmp.compare(o2, o1));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1035269838 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1035269838;
            // ---------- Original Method ----------
            //return cmp.compare(o2, o1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.489 -0400", hash_original_method = "30689CAB8FBFDCB9289EF03377EE08A0", hash_generated_method = "C71A187B907E1E2D424CD8FCAA8DBCA5")
        @Override
        public boolean equals(Object o) {
            addTaint(o.getTaint());
            boolean var806D582AA724690D98485479EAC877DC_580533597 = (o instanceof ReverseComparator2
                    && ((ReverseComparator2) o).cmp.equals(cmp));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_964686568 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_964686568;
            // ---------- Original Method ----------
            //return o instanceof ReverseComparator2
                    //&& ((ReverseComparator2) o).cmp.equals(cmp);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.489 -0400", hash_original_method = "CAA612A5887D060562790EB1CDD1FEFE", hash_generated_method = "3CA2D69EB3213D6E41539F53C025A66B")
        @Override
        public int hashCode() {
            int var131BD9FA627336BB1F5FEE4AA2610D18_397849705 = (~cmp.hashCode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1789658346 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1789658346;
            // ---------- Original Method ----------
            //return ~cmp.hashCode();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.489 -0400", hash_original_field = "C2743FD0D0E256493E9B52C087283254", hash_generated_field = "3328170146630256C37315D4155F67EF")

        private static final long serialVersionUID = 4374092139857L;
    }


    
    private static final class SingletonSet<E> extends AbstractSet<E> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.489 -0400", hash_original_field = "8E2DCFD7E7E24B1CA76C1193F645902B", hash_generated_field = "AADC7BC67B0FB6048E4A856A581BAEE9")

        E element;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.490 -0400", hash_original_method = "044BE6981927B9234E2AE8686E07A72F", hash_generated_method = "08623BAB02DDA909B203E3610F71957D")
          SingletonSet(E object) {
            element = object;
            // ---------- Original Method ----------
            //element = object;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.490 -0400", hash_original_method = "B07BCF81C9C48C72A08077A0468A8769", hash_generated_method = "121D5D8DDFC7E330FF25D6F69B7C03CA")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            boolean var1BF6311B6B832E206CDF43172C74BED5_1118853808 = (element == null ? object == null : element.equals(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_329024029 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_329024029;
            // ---------- Original Method ----------
            //return element == null ? object == null : element.equals(object);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.490 -0400", hash_original_method = "798A0AE2F2A6352396904AB5C9ED97D5", hash_generated_method = "340109FCBAE34D6291A67888F04D851C")
        @Override
        public int size() {
            int varC4CA4238A0B923820DCC509A6F75849B_1008120850 = (1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1024994561 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1024994561;
            // ---------- Original Method ----------
            //return 1;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.492 -0400", hash_original_method = "135AC18A6A8AD4548E2E750F2D4C7699", hash_generated_method = "8C06172CA126926EBCE8331222D393E4")
        @Override
        public Iterator<E> iterator() {
Iterator<E> varEF1BE467ABB7AA4C87CBCE9613BD5C24_2050477124 =             new Iterator<E>() {            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.491 -0400", hash_original_field = "42ADDF4753B3ACA32EE339265163027B", hash_generated_field = "DE9DC7F145F778F316047B4F4AEC3B9B")
            boolean hasNext = true;
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.491 -0400", hash_original_method = "1FFE1DD028DACE64CCBE65BDB363D72C", hash_generated_method = "4E08B48DDE608E8B9DA638E44DDF4D27")
            @Override
            public boolean hasNext() {
                boolean varD9CA95405A2301707BEA3F2942FAB48B_248055131 = (hasNext);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_738033327 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_738033327;
                // ---------- Original Method ----------
                //return hasNext;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.492 -0400", hash_original_method = "163A9F5CD311CAB76B0FCB4B7573EA38", hash_generated_method = "087D6FB51A68E72FD43724FCD5FB6287")
            @Override
            public E next() {
    if(hasNext)                
                {
                    hasNext = false;
E var24D05606CDD4BC4C89F2F5A15C16F343_1862912409 =                     element;
                    var24D05606CDD4BC4C89F2F5A15C16F343_1862912409.addTaint(taint);
                    return var24D05606CDD4BC4C89F2F5A15C16F343_1862912409;
                } //End block
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_1497135164 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_1497135164.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_1497135164;
                // ---------- Original Method ----------
                //if (hasNext) {
                        //hasNext = false;
                        //return element;
                    //}
                //throw new NoSuchElementException();
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.492 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "7BB46B81EDA6CAF76D7243DFA97BA823")
            @Override
            public void remove() {
                UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_953698549 = new UnsupportedOperationException();
                var81FA7E299EEE7F062EBFBEEF08B0464D_953698549.addTaint(taint);
                throw var81FA7E299EEE7F062EBFBEEF08B0464D_953698549;
                // ---------- Original Method ----------
                //throw new UnsupportedOperationException();
            }
};
            varEF1BE467ABB7AA4C87CBCE9613BD5C24_2050477124.addTaint(taint);
            return varEF1BE467ABB7AA4C87CBCE9613BD5C24_2050477124;
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.492 -0400", hash_original_field = "C80162DD8B57D34236F77D8F8A87A897", hash_generated_field = "35AF14D3D33C59E58AFC233BD942F616")

        private static final long serialVersionUID = 3193687207550431679L;
    }


    
    private static final class SingletonList<E> extends AbstractList<E> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.493 -0400", hash_original_field = "8E2DCFD7E7E24B1CA76C1193F645902B", hash_generated_field = "AADC7BC67B0FB6048E4A856A581BAEE9")

        E element;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.493 -0400", hash_original_method = "F3174A5FA7BA5962D109EAC3245F2C1D", hash_generated_method = "6BE55179558843F3290CC42091204DF4")
          SingletonList(E object) {
            element = object;
            // ---------- Original Method ----------
            //element = object;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.494 -0400", hash_original_method = "B07BCF81C9C48C72A08077A0468A8769", hash_generated_method = "6150D9BA182B06B5CABF01371D18582C")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            boolean var1BF6311B6B832E206CDF43172C74BED5_1094459175 = (element == null ? object == null : element.equals(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1987908655 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1987908655;
            // ---------- Original Method ----------
            //return element == null ? object == null : element.equals(object);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.495 -0400", hash_original_method = "1C6E7D1EB082158D5E00EA29E883A612", hash_generated_method = "E322AD435D0A5177C649E69FFE5FB4C3")
        @Override
        public E get(int location) {
            addTaint(location);
    if(location == 0)            
            {
E var24D05606CDD4BC4C89F2F5A15C16F343_348005534 =                 element;
                var24D05606CDD4BC4C89F2F5A15C16F343_348005534.addTaint(taint);
                return var24D05606CDD4BC4C89F2F5A15C16F343_348005534;
            } //End block
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_263264330 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_263264330.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_263264330;
            // ---------- Original Method ----------
            //if (location == 0) {
                //return element;
            //}
            //throw new IndexOutOfBoundsException();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.495 -0400", hash_original_method = "798A0AE2F2A6352396904AB5C9ED97D5", hash_generated_method = "0902DCE6A54739F4F6B0B5863AEF24C6")
        @Override
        public int size() {
            int varC4CA4238A0B923820DCC509A6F75849B_1283835923 = (1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1648193179 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1648193179;
            // ---------- Original Method ----------
            //return 1;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.495 -0400", hash_original_field = "136A37A5852F7DE7150E3A4BC9F06AE5", hash_generated_field = "CBFA444A21D6CBFF01F29F9591A887AB")

        private static final long serialVersionUID = 3093736618740652951L;
    }


    
    private static final class SingletonMap<K, V> extends AbstractMap<K, V> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.496 -0400", hash_original_field = "8CE4B16B22B58894AA86C421E8759DF3", hash_generated_field = "052F80594ED04BACBC2E98744BD4CC2D")

        K k;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.496 -0400", hash_original_field = "9E3669D19B675BD57058FD4664205D2A", hash_generated_field = "3A278B3CDA0FEEA24CB626A0B3136D0B")

        V v;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.496 -0400", hash_original_method = "85D3D420EE431E7A3C1CBFB71D1CEAE2", hash_generated_method = "942C300AA2E111086F3B6C3DFB936BBB")
          SingletonMap(K key, V value) {
            k = key;
            v = value;
            // ---------- Original Method ----------
            //k = key;
            //v = value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.497 -0400", hash_original_method = "26D5E87A2C62405ADA3B15C5C8B30FEC", hash_generated_method = "A882D9206A735AB64F1DC5B686AB89FD")
        @Override
        public boolean containsKey(Object key) {
            addTaint(key.getTaint());
            boolean varE4FF7C43871EEA16BF355477C9641A8F_123112138 = (k == null ? key == null : k.equals(key));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1986909148 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1986909148;
            // ---------- Original Method ----------
            //return k == null ? key == null : k.equals(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.497 -0400", hash_original_method = "827D42B4F919454EC51CA86D0E534994", hash_generated_method = "151F3CCE2BE4163087D7CA1F75AF0148")
        @Override
        public boolean containsValue(Object value) {
            addTaint(value.getTaint());
            boolean var89AFEFDF42625078B7AFD1C8FB622AB5_445728035 = (v == null ? value == null : v.equals(value));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_92802725 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_92802725;
            // ---------- Original Method ----------
            //return v == null ? value == null : v.equals(value);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.498 -0400", hash_original_method = "8C587096F5E6029DBB187C58CF22D158", hash_generated_method = "32BB4DCEE10FA069913268CB9A15FEEE")
        @Override
        public V get(Object key) {
            addTaint(key.getTaint());
    if(containsKey(key))            
            {
V var6DC76BC51820DD65E8396280E884AA78_944690929 =                 v;
                var6DC76BC51820DD65E8396280E884AA78_944690929.addTaint(taint);
                return var6DC76BC51820DD65E8396280E884AA78_944690929;
            } //End block
V var540C13E9E156B687226421B24F2DF178_1301044468 =             null;
            var540C13E9E156B687226421B24F2DF178_1301044468.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1301044468;
            // ---------- Original Method ----------
            //if (containsKey(key)) {
                //return v;
            //}
            //return null;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.498 -0400", hash_original_method = "798A0AE2F2A6352396904AB5C9ED97D5", hash_generated_method = "1088047EAA192D13F66F822067E54B02")
        @Override
        public int size() {
            int varC4CA4238A0B923820DCC509A6F75849B_1762994567 = (1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_499329982 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_499329982;
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.505 -0400", hash_original_field = "9848B8101686634CF12341A29DB1F062", hash_generated_field = "0B15CF1CC7A3921AD66781626704DE4C")

        private static final long serialVersionUID = -6979724477215052911L;
    }


    
    static class SynchronizedCollection<E> implements Collection<E>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.505 -0400", hash_original_field = "4A8A08F09D37B73795649038408B5F33", hash_generated_field = "A3C80A7E02E49F20400373DFBAF9696A")

        Collection<E> c;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.506 -0400", hash_original_field = "25A01BB859125507013A2FE9737D3C32", hash_generated_field = "5C5F8780FECE5E612AF5A86D3A8B3194")

        Object mutex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.506 -0400", hash_original_method = "30FA7B26D2517E75155300E21A44EE02", hash_generated_method = "04BEBFE0095AFAF3C9F796F57AE0BFCE")
          SynchronizedCollection(Collection<E> collection) {
            c = collection;
            mutex = this;
            // ---------- Original Method ----------
            //c = collection;
            //mutex = this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.507 -0400", hash_original_method = "A2A350BD37040709EC39C6B0536AFBDE", hash_generated_method = "4B2E27EA4C4C16202811504251810751")
          SynchronizedCollection(Collection<E> collection, Object mutex) {
            c = collection;
            this.mutex = mutex;
            // ---------- Original Method ----------
            //c = collection;
            //this.mutex = mutex;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.507 -0400", hash_original_method = "FB2AC5CD0A8119C2DE50A53F38732CDD", hash_generated_method = "CA8E53A5F6542D7099AEF75DF3BCDBF7")
        @Override
        public boolean add(E object) {
            addTaint(object.getTaint());
            synchronized
(mutex)            {
                boolean varB1EDCF55DE15920EACA4E1E5D202EB69_841240177 = (c.add(object));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_604048335 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_604048335;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.add(object);
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.507 -0400", hash_original_method = "8489E829BC0B88048B305735D46B1D99", hash_generated_method = "241AD4ED6C49F146B1D290A7B0A96C35")
        @Override
        public boolean addAll(Collection<? extends E> collection) {
            addTaint(collection.getTaint());
            synchronized
(mutex)            {
                boolean varBB2D721B097E4DDEDAE8E4090B1656E9_555841942 = (c.addAll(collection));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_845179034 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_845179034;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.addAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.508 -0400", hash_original_method = "7AE3345D011114FF0F62A8DFD7762BE2", hash_generated_method = "DF6C884B407381ED375E25E67759127F")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.508 -0400", hash_original_method = "1B12503F1112F0CD581293F3A624FEFF", hash_generated_method = "FB7239FC49F9B87A112A360F6A78602C")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            synchronized
(mutex)            {
                boolean var1AEB72C9D1B87075EB37C6366C13F8DB_347595283 = (c.contains(object));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1461348785 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1461348785;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.contains(object);
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.508 -0400", hash_original_method = "F945FF2C907D1AA0923D46DECCCD5EAD", hash_generated_method = "4C7A584C0AB5E26A49B56FB415BCFED3")
        @Override
        public boolean containsAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            synchronized
(mutex)            {
                boolean var89744A7A766147F896A88C5E38016080_1105162347 = (c.containsAll(collection));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1803843247 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1803843247;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.containsAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.509 -0400", hash_original_method = "FC4F88C8FB9F4E3716AD2ABCD3101657", hash_generated_method = "C35A7C1A50081B8B6F29945F4C10F6D6")
        @Override
        public boolean isEmpty() {
            synchronized
(mutex)            {
                boolean var65FAF5A74582A5D73E221DB675503595_112780410 = (c.isEmpty());
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_22614015 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_22614015;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.isEmpty();
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.509 -0400", hash_original_method = "7F1B5E60A4E4F9F3AFA65965967FBBF0", hash_generated_method = "DF286E2E0B19F82D2E3CC4675E2CCA96")
        @Override
        public Iterator<E> iterator() {
            synchronized
(mutex)            {
Iterator<E> var918560FDB0FDB05FBAECB3ADB6E2A6DB_1634566151 =                 c.iterator();
                var918560FDB0FDB05FBAECB3ADB6E2A6DB_1634566151.addTaint(taint);
                return var918560FDB0FDB05FBAECB3ADB6E2A6DB_1634566151;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.iterator();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.509 -0400", hash_original_method = "C85E45E4AF074973339408E1197B653C", hash_generated_method = "B47E710E43588DD3DEE6ACD6DE8CC154")
        @Override
        public boolean remove(Object object) {
            addTaint(object.getTaint());
            synchronized
(mutex)            {
                boolean var4351AB2E7C2E6CB2963502AF12FA9961_375171654 = (c.remove(object));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2096920186 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2096920186;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.remove(object);
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.510 -0400", hash_original_method = "63829008A74D54A464D81619215951F3", hash_generated_method = "931E3993BCC857B63FEF9EE5CD005A51")
        @Override
        public boolean removeAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            synchronized
(mutex)            {
                boolean var764D8CCB8FC4481072E471953CFC8F8C_500187487 = (c.removeAll(collection));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_898134963 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_898134963;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.removeAll(collection);
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.510 -0400", hash_original_method = "F83427C5B4EF86DB8198B3D2BAE482AC", hash_generated_method = "080F8C61244B73DDFFDA9A091C202D40")
        @Override
        public boolean retainAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            synchronized
(mutex)            {
                boolean var9BEBAF6C8A25352D5A75AE9DA04B09DB_1984601389 = (c.retainAll(collection));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_152287411 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_152287411;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.retainAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.510 -0400", hash_original_method = "8641BC878FB77D36CE60B1977D7C0FB5", hash_generated_method = "23218965A29F4E53D244EFC05F480C19")
        @Override
        public int size() {
            synchronized
(mutex)            {
                int varB01543F097DAA850E9B79CBAB9C1B976_98710568 = (c.size());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_105187786 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_105187786;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.size();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.511 -0400", hash_original_method = "214BCEC14D5449B585926B657D8D51C2", hash_generated_method = "91E50F7371147EC2CF6CADB5A2873465")
        @Override
        public java.lang.Object[] toArray() {
            synchronized
(mutex)            {
java.lang.Object[] var46570412E19D68724A647FAFEECFBF92_1561675811 =                 c.toArray();
                var46570412E19D68724A647FAFEECFBF92_1561675811.addTaint(taint);
                return var46570412E19D68724A647FAFEECFBF92_1561675811;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.toArray();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.511 -0400", hash_original_method = "D637F0F4C3C8C312A0597F30C1C6DB59", hash_generated_method = "5F7671DFECF461ECCF9D39021317D51F")
        @Override
        public String toString() {
            synchronized
(mutex)            {
String var7F88C51BB16CD8992026056598815CC9_1136971273 =                 c.toString();
                var7F88C51BB16CD8992026056598815CC9_1136971273.addTaint(taint);
                return var7F88C51BB16CD8992026056598815CC9_1136971273;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.toString();
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.511 -0400", hash_original_method = "567EED27866E99DFC1B7F8B43B648D82", hash_generated_method = "A6F61A97180A24B3B66428B5F14DFDC7")
        @Override
        public <T> T[] toArray(T[] array) {
            addTaint(array[0].getTaint());
            synchronized
(mutex)            {
T[] varA824E05E0FA0C1B35EB9A8324FF1796D_560895556 =                 c.toArray(array);
                varA824E05E0FA0C1B35EB9A8324FF1796D_560895556.addTaint(taint);
                return varA824E05E0FA0C1B35EB9A8324FF1796D_560895556;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.toArray(array);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.512 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "350CD97D03809885CB7561AF44340EC3")
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.512 -0400", hash_original_field = "B7F3A88BD93CCDAF65C044FAA6629D02", hash_generated_field = "0D9A3687FC51DFBFFFEA57286BC842CD")

        private static final long serialVersionUID = 3053995032091335093L;
    }


    
    static class SynchronizedRandomAccessList<E> extends SynchronizedList<E> implements RandomAccess {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.512 -0400", hash_original_method = "B7E7091552AE239FAE56C332916C1F88", hash_generated_method = "E13039390DC63B5DD55D2C3F5A398F04")
          SynchronizedRandomAccessList(List<E> l) {
            super(l);
            addTaint(l.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.513 -0400", hash_original_method = "333C2DB156927D33EFC68D095A4D91C7", hash_generated_method = "8776429B58A200120921377CD7800721")
          SynchronizedRandomAccessList(List<E> l, Object mutex) {
            super(l, mutex);
            addTaint(mutex.getTaint());
            addTaint(l.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.513 -0400", hash_original_method = "52EB3707ADD11A2326D60B7B815140D9", hash_generated_method = "0069E1B91F73575180C4B2A1398B8272")
        @Override
        public List<E> subList(int start, int end) {
            addTaint(end);
            addTaint(start);
            synchronized
(mutex)            {
List<E> var867584235690190D4FBEF7E995366649_1366786821 =                 new SynchronizedRandomAccessList<E>(list.subList(start, end), mutex);
                var867584235690190D4FBEF7E995366649_1366786821.addTaint(taint);
                return var867584235690190D4FBEF7E995366649_1366786821;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedRandomAccessList<E>(list.subList(start, end), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.513 -0400", hash_original_method = "3A06B4F1BF7736CF10F2183ECBC34EF4", hash_generated_method = "F9AE5998E76891DFFEB9711E0F335FBA")
        private Object writeReplace() {
Object var91C5F48A6EC2BB7DF4455DCCC8C58A1A_737158400 =             new SynchronizedList<E>(list);
            var91C5F48A6EC2BB7DF4455DCCC8C58A1A_737158400.addTaint(taint);
            return var91C5F48A6EC2BB7DF4455DCCC8C58A1A_737158400;
            // ---------- Original Method ----------
            //return new SynchronizedList<E>(list);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.514 -0400", hash_original_field = "9B799982724822CB2FE4521FDAC6E710", hash_generated_field = "F305BE0154CFFE9E0253007EE134CBB9")

        private static final long serialVersionUID = 1530674583602358482L;
    }


    
    static class SynchronizedList<E> extends SynchronizedCollection<E> implements List<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.514 -0400", hash_original_field = "10AE9FC7D453B0DD525D0EDF2EDE7961", hash_generated_field = "1ECA8D0C53ED31C6D874046BB18C0645")

        List<E> list;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.514 -0400", hash_original_method = "557BC04FB4751FAF0774C664BC5CCEDB", hash_generated_method = "C7C5461D5C9C9A7143EFC825B2E89308")
          SynchronizedList(List<E> l) {
            super(l);
            list = l;
            // ---------- Original Method ----------
            //list = l;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.515 -0400", hash_original_method = "6BB690026CB7D337AD2D522FD2C1D564", hash_generated_method = "DA23F60EE2F336AE20DE0F8560712B04")
          SynchronizedList(List<E> l, Object mutex) {
            super(l, mutex);
            addTaint(mutex.getTaint());
            list = l;
            // ---------- Original Method ----------
            //list = l;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.515 -0400", hash_original_method = "771543DB5FBF857EC43E623C900790C1", hash_generated_method = "E62A1EE7F4416AC86776B529C1C1745E")
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.515 -0400", hash_original_method = "2E8B0D036C339DEB52EAEECF82B3FC29", hash_generated_method = "636E574F4EEE163ACCF3208F08E60F9A")
        @Override
        public boolean addAll(int location, Collection<? extends E> collection) {
            addTaint(collection.getTaint());
            addTaint(location);
            synchronized
(mutex)            {
                boolean varE4C4ADDA86080E08AFA48F394D895E2E_364604306 = (list.addAll(location, collection));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_944275506 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_944275506;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.addAll(location, collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.516 -0400", hash_original_method = "3D6B0DEE3E066475015263D28B67E9C7", hash_generated_method = "AD2E31BABA6555DCF9A1AE64548CD468")
        @Override
        public boolean equals(Object object) {
            addTaint(object.getTaint());
            synchronized
(mutex)            {
                boolean var3031446AD6BFF612C63BB52505A53EB2_1656901817 = (list.equals(object));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1848476939 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1848476939;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.equals(object);
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.516 -0400", hash_original_method = "5B64BB89A58DED71DBA9907C06BC2CBB", hash_generated_method = "61BBF702A530FFB636A59D62CECD5419")
        @Override
        public E get(int location) {
            addTaint(location);
            synchronized
(mutex)            {
E var4DE8B026CD0A7863FB8A32177D5AA64A_851656960 =                 list.get(location);
                var4DE8B026CD0A7863FB8A32177D5AA64A_851656960.addTaint(taint);
                return var4DE8B026CD0A7863FB8A32177D5AA64A_851656960;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.get(location);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.516 -0400", hash_original_method = "4F5947DB3C3ABC0CDEDCB631295417DE", hash_generated_method = "00B509DADBD1972F08B18E0AF74AA70D")
        @Override
        public int hashCode() {
            synchronized
(mutex)            {
                int varE2167E8879221CB1AE58F4BC195DE759_431541572 = (list.hashCode());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1249383726 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1249383726;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.hashCode();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.517 -0400", hash_original_method = "3D24998665BD619FA01B00E0A34A83F5", hash_generated_method = "0B17465D55B6124398955D93BC6E6EE6")
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
                        int var865C0C0B4AB0E063E5CAA3387C1A8741_1811320238 = (i);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_213605446 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_213605446;
                    } //End block
                } //End block
            } //End block
            else
            {
for(int i = 0;i < size;i++)
                {
    if(array[i] == null)                    
                    {
                        int var865C0C0B4AB0E063E5CAA3387C1A8741_833907495 = (i);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_531794323 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_531794323;
                    } //End block
                } //End block
            } //End block
            int var6BB61E3B7BCE0931DA574D19D1D82C88_145632654 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1544969343 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1544969343;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.518 -0400", hash_original_method = "615F71337583130515178716D1767A86", hash_generated_method = "29DA614D1D8CD64CA0C115B7611F1769")
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
                        int var865C0C0B4AB0E063E5CAA3387C1A8741_525620285 = (i);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_389299979 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_389299979;
                    } //End block
                } //End block
            } //End block
            else
            {
for(int i = size - 1;i >= 0;i--)
                {
    if(array[i] == null)                    
                    {
                        int var865C0C0B4AB0E063E5CAA3387C1A8741_46628120 = (i);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1173457174 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1173457174;
                    } //End block
                } //End block
            } //End block
            int var6BB61E3B7BCE0931DA574D19D1D82C88_328052096 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_565334954 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_565334954;
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.519 -0400", hash_original_method = "9E49E91DE129681261C3C7642C2D1127", hash_generated_method = "5C1BE248ABB1B396C296B80AB21AB221")
        @Override
        public ListIterator<E> listIterator() {
            synchronized
(mutex)            {
ListIterator<E> var91E2AA6BDB726F9377DFF156580182C8_156719141 =                 list.listIterator();
                var91E2AA6BDB726F9377DFF156580182C8_156719141.addTaint(taint);
                return var91E2AA6BDB726F9377DFF156580182C8_156719141;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.listIterator();
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.519 -0400", hash_original_method = "70349F3896FC81F4D21A3D35B0C8A4F6", hash_generated_method = "E2856175F027B8D2265F5F0F983CC960")
        @Override
        public ListIterator<E> listIterator(int location) {
            addTaint(location);
            synchronized
(mutex)            {
ListIterator<E> var373790041D3D8DE94D481C14C2F81B97_2067750423 =                 list.listIterator(location);
                var373790041D3D8DE94D481C14C2F81B97_2067750423.addTaint(taint);
                return var373790041D3D8DE94D481C14C2F81B97_2067750423;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.listIterator(location);
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.520 -0400", hash_original_method = "D935E09B492D323BEF59297A7648FE48", hash_generated_method = "E894B8F36967E1E4F260BBF79ADA6758")
        @Override
        public E remove(int location) {
            addTaint(location);
            synchronized
(mutex)            {
E varAA5CAFC40D704B2187CD7B19358DE8AF_1050050680 =                 list.remove(location);
                varAA5CAFC40D704B2187CD7B19358DE8AF_1050050680.addTaint(taint);
                return varAA5CAFC40D704B2187CD7B19358DE8AF_1050050680;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.remove(location);
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.520 -0400", hash_original_method = "D9730991663FB8C206D80781B7E02750", hash_generated_method = "78EA509D76EC1F4EFC880A4678B46635")
        @Override
        public E set(int location, E object) {
            addTaint(object.getTaint());
            addTaint(location);
            synchronized
(mutex)            {
E varC7672C8496CFCB1E354FE4F100AFEEF9_1143910759 =                 list.set(location, object);
                varC7672C8496CFCB1E354FE4F100AFEEF9_1143910759.addTaint(taint);
                return varC7672C8496CFCB1E354FE4F100AFEEF9_1143910759;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.set(location, object);
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.521 -0400", hash_original_method = "C38F2D62AA6D1EBD255ADC5369CBEC01", hash_generated_method = "9603C2F643FB9B3131E47FDFA21D102B")
        @Override
        public List<E> subList(int start, int end) {
            addTaint(end);
            addTaint(start);
            synchronized
(mutex)            {
List<E> var46FC9BA78CD4658D3E3096D9AF06081C_1508664685 =                 new SynchronizedList<E>(list.subList(start, end), mutex);
                var46FC9BA78CD4658D3E3096D9AF06081C_1508664685.addTaint(taint);
                return var46FC9BA78CD4658D3E3096D9AF06081C_1508664685;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedList<E>(list.subList(start, end), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.521 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "350CD97D03809885CB7561AF44340EC3")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.521 -0400", hash_original_method = "172F08E6F2352F1764A4A70C48C6E243", hash_generated_method = "838D6542F392036674596C5DAA62E19F")
        private Object readResolve() {
    if(list instanceof RandomAccess)            
            {
Object varA5725D0BED74F1FBCBC581EA89C3A111_1139533546 =                 new SynchronizedRandomAccessList<E>(list, mutex);
                varA5725D0BED74F1FBCBC581EA89C3A111_1139533546.addTaint(taint);
                return varA5725D0BED74F1FBCBC581EA89C3A111_1139533546;
            } //End block
Object var72A74007B2BE62B849F475C7BDA4658B_2013112759 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_2013112759.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_2013112759;
            // ---------- Original Method ----------
            //if (list instanceof RandomAccess) {
                //return new SynchronizedRandomAccessList<E>(list, mutex);
            //}
            //return this;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.522 -0400", hash_original_field = "8883C8F4886CDFE339069F9C7525453D", hash_generated_field = "5528D904FB3223ACA4EBA912A58AE2BF")

        private static final long serialVersionUID = -7754090372962971524L;
    }


    
    static class SynchronizedMap<K, V> implements Map<K, V>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.522 -0400", hash_original_field = "6F8F57715090DA2632453988D9A1501B", hash_generated_field = "1785B4570966C73126874A8D942D2395")

        private Map<K, V> m;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.522 -0400", hash_original_field = "25A01BB859125507013A2FE9737D3C32", hash_generated_field = "5C5F8780FECE5E612AF5A86D3A8B3194")

        Object mutex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.522 -0400", hash_original_method = "C14189E3F71A4C148CB91C638F3BAAE3", hash_generated_method = "697756520B6F74069D1E5AA0F6D1C69A")
          SynchronizedMap(Map<K, V> map) {
            m = map;
            mutex = this;
            // ---------- Original Method ----------
            //m = map;
            //mutex = this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.523 -0400", hash_original_method = "6EAD9DD813CFD47244744C3F6D6A4D1C", hash_generated_method = "96BED7921FDC6B114140F51F8F22333E")
          SynchronizedMap(Map<K, V> map, Object mutex) {
            m = map;
            this.mutex = mutex;
            // ---------- Original Method ----------
            //m = map;
            //this.mutex = mutex;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.523 -0400", hash_original_method = "3DCF075501F09300584E40825720BBA2", hash_generated_method = "593287EE6198540DCDECFACB3A2D6C3C")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.524 -0400", hash_original_method = "D2C67B34100B05197A0572527ECA3220", hash_generated_method = "50FE5560B7A9031D719D46F004A431EA")
        @Override
        public boolean containsKey(Object key) {
            addTaint(key.getTaint());
            synchronized
(mutex)            {
                boolean var62AFCABB34FB6B56AC689F51EB3A9E27_276635579 = (m.containsKey(key));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_216317997 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_216317997;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.containsKey(key);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.524 -0400", hash_original_method = "FFE2162DB44C1E8BEEAD35935B233C81", hash_generated_method = "D1DB5896EACCC4D44C5C3B0B5230DBD8")
        @Override
        public boolean containsValue(Object value) {
            addTaint(value.getTaint());
            synchronized
(mutex)            {
                boolean varD6C1BCF4353E9D47F21CF5A12A4A7A3C_1597117996 = (m.containsValue(value));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1983209259 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1983209259;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.containsValue(value);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.524 -0400", hash_original_method = "E5EA9A3F9567269DAA52E0C08140D3D5", hash_generated_method = "2B0D24A931689C0D6C1E30CE5E7EDB69")
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            synchronized
(mutex)            {
Set<Map.Entry<K, V>> var5727BC6642E27AF92618365955C09D10_149161699 =                 new SynchronizedSet<Map.Entry<K, V>>(m.entrySet(), mutex);
                var5727BC6642E27AF92618365955C09D10_149161699.addTaint(taint);
                return var5727BC6642E27AF92618365955C09D10_149161699;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSet<Map.Entry<K, V>>(m.entrySet(), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.525 -0400", hash_original_method = "573EFA9740FEBDEC9C1CCFD8172CCEF0", hash_generated_method = "663CFBD6B51BA941490CA97B3DD7F2D2")
        @Override
        public boolean equals(Object object) {
            addTaint(object.getTaint());
            synchronized
(mutex)            {
                boolean var2173C29FE79E34E394A75A59701DB2CC_1779970862 = (m.equals(object));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_708111918 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_708111918;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.equals(object);
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.525 -0400", hash_original_method = "80DF7D6FED6980DF61457325CD64503D", hash_generated_method = "DCDA505C2722BFA4F4138C6F6B0A9864")
        @Override
        public V get(Object key) {
            addTaint(key.getTaint());
            synchronized
(mutex)            {
V var3A7E11B6611BEAA522E24ED974C59715_1044453700 =                 m.get(key);
                var3A7E11B6611BEAA522E24ED974C59715_1044453700.addTaint(taint);
                return var3A7E11B6611BEAA522E24ED974C59715_1044453700;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.get(key);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.526 -0400", hash_original_method = "5DDF560D56DA8F61EEAD582BB150A893", hash_generated_method = "7C5061886E12D5B353370DC0EF06AB2D")
        @Override
        public int hashCode() {
            synchronized
(mutex)            {
                int varE3BA1212D08FEDD275814D3960FD8F10_133977270 = (m.hashCode());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_240094968 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_240094968;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.hashCode();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.526 -0400", hash_original_method = "40A122CDBD7096230690259CC30A0F7A", hash_generated_method = "8817D991C06E37BC74CF111DA1F5F6C3")
        @Override
        public boolean isEmpty() {
            synchronized
(mutex)            {
                boolean var6FFDB0B6EFF2802DEEBD39B93137FE90_299702639 = (m.isEmpty());
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_143994682 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_143994682;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.isEmpty();
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.526 -0400", hash_original_method = "2FBB6190D51F2A6210F8CF71191E69DD", hash_generated_method = "C77B654F6997B23E167078C622E72DDC")
        @Override
        public Set<K> keySet() {
            synchronized
(mutex)            {
Set<K> var285F5F6219BDED18A916ADCBF7A0FD1A_654293171 =                 new SynchronizedSet<K>(m.keySet(), mutex);
                var285F5F6219BDED18A916ADCBF7A0FD1A_654293171.addTaint(taint);
                return var285F5F6219BDED18A916ADCBF7A0FD1A_654293171;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSet<K>(m.keySet(), mutex);
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.527 -0400", hash_original_method = "4BBBC2EF3E646AB7C0C1BFCAE8571FAF", hash_generated_method = "588CE8DDD107C76F4BC71D59FCAD6B54")
        @Override
        public V put(K key, V value) {
            addTaint(value.getTaint());
            addTaint(key.getTaint());
            synchronized
(mutex)            {
V var065C412EB078CAC7BCF0E1D4C066D348_883718612 =                 m.put(key, value);
                var065C412EB078CAC7BCF0E1D4C066D348_883718612.addTaint(taint);
                return var065C412EB078CAC7BCF0E1D4C066D348_883718612;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.put(key, value);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.527 -0400", hash_original_method = "400FF0E6707670DAA4FF7ECA275302A3", hash_generated_method = "02E0FA1D3734E664378B37F39C9464E0")
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.528 -0400", hash_original_method = "98B37460DCD5FD18048F5172283C3141", hash_generated_method = "44181E9D90A1BE0EFC7CCA81FB17803A")
        @Override
        public V remove(Object key) {
            addTaint(key.getTaint());
            synchronized
(mutex)            {
V varCFC4EE21887DEF986B37EBC86595687F_1134202239 =                 m.remove(key);
                varCFC4EE21887DEF986B37EBC86595687F_1134202239.addTaint(taint);
                return varCFC4EE21887DEF986B37EBC86595687F_1134202239;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.remove(key);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.528 -0400", hash_original_method = "A48EE7C65347333E889EFC2ECD0A019A", hash_generated_method = "0E63008661AFE4ABD9E89EAEAFF30ED4")
        @Override
        public int size() {
            synchronized
(mutex)            {
                int var313B2D1C305A713CA398B12007C9967C_1805830390 = (m.size());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_597774840 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_597774840;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.size();
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.529 -0400", hash_original_method = "BB797020E54DC33FB15BC9404E89E5CD", hash_generated_method = "1084740B306D19B7C5F41B838559A588")
        @Override
        public Collection<V> values() {
            synchronized
(mutex)            {
Collection<V> varC2AD2DC503BC6B001F17920E86024CF0_524822564 =                 new SynchronizedCollection<V>(m.values(), mutex);
                varC2AD2DC503BC6B001F17920E86024CF0_524822564.addTaint(taint);
                return varC2AD2DC503BC6B001F17920E86024CF0_524822564;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedCollection<V>(m.values(), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.529 -0400", hash_original_method = "CB61B465EF18C12F472B81636CD4AC79", hash_generated_method = "167643F877A41E0BABFCDF2C986986BA")
        @Override
        public String toString() {
            synchronized
(mutex)            {
String var8389EA5D3F4E9FD19F68E63143EE799F_103950330 =                 m.toString();
                var8389EA5D3F4E9FD19F68E63143EE799F_103950330.addTaint(taint);
                return var8389EA5D3F4E9FD19F68E63143EE799F_103950330;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.toString();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.533 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "350CD97D03809885CB7561AF44340EC3")
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.533 -0400", hash_original_field = "5DC93EB19DFCBC7B8981ED54844A07B4", hash_generated_field = "1DE57645F72579A567941D71223F2BB4")

        private static final long serialVersionUID = 1978198479659022715L;
    }


    
    static class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.534 -0400", hash_original_method = "F3863A567ABAC10F9410ABCF2A4DC8AC", hash_generated_method = "B3C414CCF795BDAB85BAEA8F2098B4FB")
          SynchronizedSet(Set<E> set) {
            super(set);
            addTaint(set.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.534 -0400", hash_original_method = "A1BA2E3E145DCA2C522F0AB9439A1572", hash_generated_method = "B6F70866DC85A2FFF9FE5147D21972E9")
          SynchronizedSet(Set<E> set, Object mutex) {
            super(set, mutex);
            addTaint(mutex.getTaint());
            addTaint(set.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.535 -0400", hash_original_method = "E045FF0B832C85F3AF0597463FE3892F", hash_generated_method = "06060C2B40E28820AC90DF7D30C56D3C")
        @Override
        public boolean equals(Object object) {
            addTaint(object.getTaint());
            synchronized
(mutex)            {
                boolean varAB5EB3EC9A33BCFBC5D0F02B0F8BDEF2_855312920 = (c.equals(object));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_480336714 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_480336714;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.equals(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.536 -0400", hash_original_method = "60CA731F9E7ECB7D3EED20B0D6D4AB09", hash_generated_method = "1651E5DDB712E0532463CE4C31D0397B")
        @Override
        public int hashCode() {
            synchronized
(mutex)            {
                int var3FFC490E9FA1D410CC240764C2B77761_48555721 = (c.hashCode());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1472162360 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1472162360;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.hashCode();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.536 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "350CD97D03809885CB7561AF44340EC3")
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.536 -0400", hash_original_field = "916EB185FF2AF0CF7FFC612F07D6DA1B", hash_generated_field = "A77C43308F38D2FC67E81B4E46E8827E")

        private static final long serialVersionUID = 487447009682186044L;
    }


    
    static class SynchronizedSortedMap<K, V> extends SynchronizedMap<K, V> implements SortedMap<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.537 -0400", hash_original_field = "ED79ACB0CD3D7F8320C53C7798335EF0", hash_generated_field = "F813233D7B24D3620137345516D05A23")

        private SortedMap<K, V> sm;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.537 -0400", hash_original_method = "2E0F62BCD34367F1E6E251286E17ABEB", hash_generated_method = "65B92739EACB6292AF1017EE07725F62")
          SynchronizedSortedMap(SortedMap<K, V> map) {
            super(map);
            sm = map;
            // ---------- Original Method ----------
            //sm = map;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.537 -0400", hash_original_method = "5BF33998E3FF0155F7A513C6A201FE85", hash_generated_method = "6296C3605A11681BE962CFBE7273FD54")
          SynchronizedSortedMap(SortedMap<K, V> map, Object mutex) {
            super(map, mutex);
            addTaint(mutex.getTaint());
            sm = map;
            // ---------- Original Method ----------
            //sm = map;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.538 -0400", hash_original_method = "78218A5A359D1FCDF6B98779037FCB94", hash_generated_method = "B11202C2D01A7D58219292A709D918F9")
        @Override
        public Comparator<? super K> comparator() {
            synchronized
(mutex)            {
Comparator<? super K> varEAAD6156DF3FBB0DB169CF3701FE5DAA_1363544710 =                 sm.comparator();
                varEAAD6156DF3FBB0DB169CF3701FE5DAA_1363544710.addTaint(taint);
                return varEAAD6156DF3FBB0DB169CF3701FE5DAA_1363544710;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return sm.comparator();
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.538 -0400", hash_original_method = "4A44F83861E496A35113DD67FECD390A", hash_generated_method = "07200DFF7CE5ECDE9D5D6A8D5DE9B15F")
        @Override
        public K firstKey() {
            synchronized
(mutex)            {
K varA58D1FB276F66FC6ABBF4CA9E354FD1B_1574645615 =                 sm.firstKey();
                varA58D1FB276F66FC6ABBF4CA9E354FD1B_1574645615.addTaint(taint);
                return varA58D1FB276F66FC6ABBF4CA9E354FD1B_1574645615;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return sm.firstKey();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.538 -0400", hash_original_method = "758EF70CDC2061BD7D7B124D17EF3F64", hash_generated_method = "1B81CB96EDFEC84216F8DDF55DECB1AC")
        @Override
        public SortedMap<K, V> headMap(K endKey) {
            addTaint(endKey.getTaint());
            synchronized
(mutex)            {
SortedMap<K, V> varEA0A15A2C4E5A413AF9B3323AD559454_1279353961 =                 new SynchronizedSortedMap<K, V>(sm.headMap(endKey),
                        mutex);
                varEA0A15A2C4E5A413AF9B3323AD559454_1279353961.addTaint(taint);
                return varEA0A15A2C4E5A413AF9B3323AD559454_1279353961;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedMap<K, V>(sm.headMap(endKey),
                        //mutex);
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.539 -0400", hash_original_method = "ECB924A52CC9F341D1EEB7E5D7BCCDC8", hash_generated_method = "40AE4F5F5C62A19F8575E806A26B9B2C")
        @Override
        public K lastKey() {
            synchronized
(mutex)            {
K varC4E8101F3F71352235F4E401D4498536_311150975 =                 sm.lastKey();
                varC4E8101F3F71352235F4E401D4498536_311150975.addTaint(taint);
                return varC4E8101F3F71352235F4E401D4498536_311150975;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return sm.lastKey();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.539 -0400", hash_original_method = "E82E6227AA62F00EB1D33B47A72F41C4", hash_generated_method = "CEA5CC094CAFB3964097A97C06A5A962")
        @Override
        public SortedMap<K, V> subMap(K startKey, K endKey) {
            addTaint(endKey.getTaint());
            addTaint(startKey.getTaint());
            synchronized
(mutex)            {
SortedMap<K, V> var3568402581E0193E041EF3FB853BEAC9_99150280 =                 new SynchronizedSortedMap<K, V>(sm.subMap(startKey,
                        endKey), mutex);
                var3568402581E0193E041EF3FB853BEAC9_99150280.addTaint(taint);
                return var3568402581E0193E041EF3FB853BEAC9_99150280;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedMap<K, V>(sm.subMap(startKey,
                        //endKey), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.540 -0400", hash_original_method = "F7B84D714F16D295C7D43C8AA5E52D6A", hash_generated_method = "164BE4562EA5E84754F610F241BD9DF3")
        @Override
        public SortedMap<K, V> tailMap(K startKey) {
            addTaint(startKey.getTaint());
            synchronized
(mutex)            {
SortedMap<K, V> var76FD45A0B6EE1B8CC0C79332C3896766_602465033 =                 new SynchronizedSortedMap<K, V>(sm.tailMap(startKey),
                        mutex);
                var76FD45A0B6EE1B8CC0C79332C3896766_602465033.addTaint(taint);
                return var76FD45A0B6EE1B8CC0C79332C3896766_602465033;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedMap<K, V>(sm.tailMap(startKey),
                        //mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.540 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "350CD97D03809885CB7561AF44340EC3")
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.540 -0400", hash_original_field = "CA84F69F8568978C0AA41949BE696442", hash_generated_field = "ECA677D018A422E9BB2369A5AF38055A")

        private static final long serialVersionUID = -8798146769416483793L;
    }


    
    static class SynchronizedSortedSet<E> extends SynchronizedSet<E> implements SortedSet<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.540 -0400", hash_original_field = "3691308F2A4C2F6983F2880D32E29C84", hash_generated_field = "5220A6F2AA4CB98BB6C290F0BB717E86")

        private SortedSet<E> ss;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.541 -0400", hash_original_method = "B2F0E775DF29B0E6B28447766B0AA532", hash_generated_method = "4CBCB006A0B32CDF41866EAC9A8E2DC9")
          SynchronizedSortedSet(SortedSet<E> set) {
            super(set);
            ss = set;
            // ---------- Original Method ----------
            //ss = set;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.541 -0400", hash_original_method = "46957450EFA60C06BEFC5742F9BFAC78", hash_generated_method = "475CBA9D2152E24CC31AED38CAE99C9B")
          SynchronizedSortedSet(SortedSet<E> set, Object mutex) {
            super(set, mutex);
            addTaint(mutex.getTaint());
            ss = set;
            // ---------- Original Method ----------
            //ss = set;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.542 -0400", hash_original_method = "D71F7DA0E84FA7A091B4017D559410C5", hash_generated_method = "05996545DBBCC57C408408F140E8DEA8")
        @Override
        public Comparator<? super E> comparator() {
            synchronized
(mutex)            {
Comparator<? super E> varEF7DDB49085F2DA083783C6BC3481D0B_1393808872 =                 ss.comparator();
                varEF7DDB49085F2DA083783C6BC3481D0B_1393808872.addTaint(taint);
                return varEF7DDB49085F2DA083783C6BC3481D0B_1393808872;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return ss.comparator();
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.542 -0400", hash_original_method = "C2C55C7E331CFDE8E84B8FC74FDABE02", hash_generated_method = "4D53EBA953142D3ABD1E8456FEA44680")
        @Override
        public E first() {
            synchronized
(mutex)            {
E varE64C384BCBD0BF9F8BB2385886B7C815_510099239 =                 ss.first();
                varE64C384BCBD0BF9F8BB2385886B7C815_510099239.addTaint(taint);
                return varE64C384BCBD0BF9F8BB2385886B7C815_510099239;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return ss.first();
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.543 -0400", hash_original_method = "86DA75392AF50D6AE53AEE4A4052EBA8", hash_generated_method = "273753288A621A4BE79ADAA091587CEF")
        @Override
        public SortedSet<E> headSet(E end) {
            addTaint(end.getTaint());
            synchronized
(mutex)            {
SortedSet<E> var8D088F33247749FC21300B712B62AE16_1069335672 =                 new SynchronizedSortedSet<E>(ss.headSet(end), mutex);
                var8D088F33247749FC21300B712B62AE16_1069335672.addTaint(taint);
                return var8D088F33247749FC21300B712B62AE16_1069335672;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedSet<E>(ss.headSet(end), mutex);
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.543 -0400", hash_original_method = "3C10DA3BCCE6BED4EBD1F6A2C6BC8438", hash_generated_method = "180F10586B7F7AA15BE4B2A74E0FCACF")
        @Override
        public E last() {
            synchronized
(mutex)            {
E var7A1B325A772301476E34C1CFA8ED9C89_1825275453 =                 ss.last();
                var7A1B325A772301476E34C1CFA8ED9C89_1825275453.addTaint(taint);
                return var7A1B325A772301476E34C1CFA8ED9C89_1825275453;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return ss.last();
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.544 -0400", hash_original_method = "662A59FFAA1C1722D75A374EC93FB0DF", hash_generated_method = "3A2A95032D0B1BDFD418305387C19ADC")
        @Override
        public SortedSet<E> subSet(E start, E end) {
            addTaint(end.getTaint());
            addTaint(start.getTaint());
            synchronized
(mutex)            {
SortedSet<E> var5FA0EEEBA5CD2BB13F60BC74D18D4C36_840736940 =                 new SynchronizedSortedSet<E>(ss.subSet(start, end),
                        mutex);
                var5FA0EEEBA5CD2BB13F60BC74D18D4C36_840736940.addTaint(taint);
                return var5FA0EEEBA5CD2BB13F60BC74D18D4C36_840736940;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedSet<E>(ss.subSet(start, end),
                        //mutex);
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.544 -0400", hash_original_method = "4C04840896A126B8B17AD8E0926A5B00", hash_generated_method = "0ADE253FBFEDF886D41EC64B236BF83F")
        @Override
        public SortedSet<E> tailSet(E start) {
            addTaint(start.getTaint());
            synchronized
(mutex)            {
SortedSet<E> var6F7D9083A65424D18B09B8597111017E_1212794595 =                 new SynchronizedSortedSet<E>(ss.tailSet(start), mutex);
                var6F7D9083A65424D18B09B8597111017E_1212794595.addTaint(taint);
                return var6F7D9083A65424D18B09B8597111017E_1212794595;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedSet<E>(ss.tailSet(start), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.545 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "350CD97D03809885CB7561AF44340EC3")
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.545 -0400", hash_original_field = "7550293A247191A63B69680B8051BA5C", hash_generated_field = "44E22A9B5E1BF0CBC26900B92B680526")

        private static final long serialVersionUID = 8695801310862127406L;
    }


    
    private static class UnmodifiableCollection<E> implements Collection<E>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.546 -0400", hash_original_field = "4A8A08F09D37B73795649038408B5F33", hash_generated_field = "A3C80A7E02E49F20400373DFBAF9696A")

        Collection<E> c;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.547 -0400", hash_original_method = "0B21B3311CB87F81844FA591591A704A", hash_generated_method = "F8A220D652916612975A1BF5C32AE7B2")
          UnmodifiableCollection(Collection<E> collection) {
            c = collection;
            // ---------- Original Method ----------
            //c = collection;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.547 -0400", hash_original_method = "1E7EFCC2BAD401EE702FAECD906F0B57", hash_generated_method = "DA7EBE007DF9329D2658ABB9B39D64C5")
        @Override
        public boolean add(E object) {
            addTaint(object.getTaint());
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_40261786 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_40261786.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_40261786;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.548 -0400", hash_original_method = "A14B246F22D65FADC1A66C9C0851763B", hash_generated_method = "C7D761013E145F7C4A70818ADC6D8FBA")
        @Override
        public boolean addAll(Collection<? extends E> collection) {
            addTaint(collection.getTaint());
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_2102478231 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_2102478231.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_2102478231;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.548 -0400", hash_original_method = "C5BE2B5F9D582C4EED1DC0880E8741A1", hash_generated_method = "2135B20139D1C7DD79F3BD41AB4A1BFC")
        @Override
        public void clear() {
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_447693912 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_447693912.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_447693912;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.550 -0400", hash_original_method = "9A5FA57B69BAE7BFE0B020704235C788", hash_generated_method = "C7DDEDB63868D236B27D9AB8286C0A96")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            boolean var1AEB72C9D1B87075EB37C6366C13F8DB_268261574 = (c.contains(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1878928909 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1878928909;
            // ---------- Original Method ----------
            //return c.contains(object);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.551 -0400", hash_original_method = "BD1B4CD05BF6E123B0DC6FD003A6020C", hash_generated_method = "E78EF3E4C321BC27FADE6691610BAC91")
        @Override
        public boolean containsAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            boolean var89744A7A766147F896A88C5E38016080_1553484327 = (c.containsAll(collection));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_748331459 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_748331459;
            // ---------- Original Method ----------
            //return c.containsAll(collection);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.551 -0400", hash_original_method = "F9A3CB1FB7570D28EBE20660E2FC6F42", hash_generated_method = "1ABE9D2714A4DB888961B43B90D84467")
        @Override
        public boolean isEmpty() {
            boolean var65FAF5A74582A5D73E221DB675503595_648404019 = (c.isEmpty());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_175224418 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_175224418;
            // ---------- Original Method ----------
            //return c.isEmpty();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.556 -0400", hash_original_method = "57C2B30126E9906DFFF70EEB2D2CD18D", hash_generated_method = "C2BA3CF12A74EA293BEA7F977497F849")
        @Override
        public Iterator<E> iterator() {
Iterator<E> var17584F965577555F1B3BEAB9FFD781E4_1671026851 =             new Iterator<E>() {            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.552 -0400", hash_original_field = "8EFDCD9E60E16BF9DA2CF814FA6A227A", hash_generated_field = "BFAA84E4781D6E7F7943DE789C19AEAB")
            Iterator<E> iterator = c.iterator();
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.552 -0400", hash_original_method = "AA3B17E619A4DDCE5FFF27C1294FF431", hash_generated_method = "755C916C6E975C63A796689406DD7CE9")
            @Override
            public boolean hasNext() {
                boolean varD6B09E4375C520F8E3C47E2CD37ACCE3_1536970735 = (iterator.hasNext());
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1974405822 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1974405822;
                // ---------- Original Method ----------
                //return iterator.hasNext();
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.555 -0400", hash_original_method = "E4F6FE4F8164B2EF0F004EE03FA1069C", hash_generated_method = "6271DD7ADBF46CD7DE4818A1D0AEC0A7")
            @Override
            public E next() {
E var862BD85102BDD28E8A3902D84E203428_1918407391 =                 iterator.next();
                var862BD85102BDD28E8A3902D84E203428_1918407391.addTaint(taint);
                return var862BD85102BDD28E8A3902D84E203428_1918407391;
                // ---------- Original Method ----------
                //return iterator.next();
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.556 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "D0BEB70B472A20E5B7493B05CA4F9146")
            @Override
            public void remove() {
                UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_324230226 = new UnsupportedOperationException();
                var81FA7E299EEE7F062EBFBEEF08B0464D_324230226.addTaint(taint);
                throw var81FA7E299EEE7F062EBFBEEF08B0464D_324230226;
                // ---------- Original Method ----------
                //throw new UnsupportedOperationException();
            }
};
            var17584F965577555F1B3BEAB9FFD781E4_1671026851.addTaint(taint);
            return var17584F965577555F1B3BEAB9FFD781E4_1671026851;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.557 -0400", hash_original_method = "2165C77F20F5DBDDE4D0AED313262684", hash_generated_method = "DAAEFD234AD612188B3D2DC9AD3F949D")
        @Override
        public boolean remove(Object object) {
            addTaint(object.getTaint());
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1893269338 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_1893269338.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_1893269338;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.558 -0400", hash_original_method = "95D6D7B80D3C762A794FEAFDE42B30FC", hash_generated_method = "D08678EDA7961C84793F39EE9B5096CF")
        @Override
        public boolean removeAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_728295418 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_728295418.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_728295418;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.558 -0400", hash_original_method = "D4789A90B422D35C3FC475A0D6C54BE8", hash_generated_method = "577D6BE88EB741C597B434C82030B677")
        @Override
        public boolean retainAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_705078067 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_705078067.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_705078067;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.558 -0400", hash_original_method = "AC97C28F724592ABA809E2470D95C119", hash_generated_method = "6661DE7AAF7768648957CB98763533B6")
        @Override
        public int size() {
            int varB01543F097DAA850E9B79CBAB9C1B976_680054365 = (c.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_393974886 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_393974886;
            // ---------- Original Method ----------
            //return c.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.559 -0400", hash_original_method = "89D7D02A9D2BDF31E775C08108CBDE5B", hash_generated_method = "76B07302B95E093E4CB0EE74EC9F3BA3")
        @Override
        public Object[] toArray() {
Object[] var46570412E19D68724A647FAFEECFBF92_1837176153 =             c.toArray();
            var46570412E19D68724A647FAFEECFBF92_1837176153.addTaint(taint);
            return var46570412E19D68724A647FAFEECFBF92_1837176153;
            // ---------- Original Method ----------
            //return c.toArray();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.559 -0400", hash_original_method = "D5913A45F2385B9A173BEEED47EA354F", hash_generated_method = "66A2BCFF1DB8F920FE8D0471F2D9983F")
        @Override
        public <T> T[] toArray(T[] array) {
            addTaint(array[0].getTaint());
T[] varA824E05E0FA0C1B35EB9A8324FF1796D_1327800200 =             c.toArray(array);
            varA824E05E0FA0C1B35EB9A8324FF1796D_1327800200.addTaint(taint);
            return varA824E05E0FA0C1B35EB9A8324FF1796D_1327800200;
            // ---------- Original Method ----------
            //return c.toArray(array);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.559 -0400", hash_original_method = "424D4966F358AE6553349A6493C21674", hash_generated_method = "239633AA27F45A6528F5C42D3FCFFD9C")
        @Override
        public String toString() {
String var7F88C51BB16CD8992026056598815CC9_299656458 =             c.toString();
            var7F88C51BB16CD8992026056598815CC9_299656458.addTaint(taint);
            return var7F88C51BB16CD8992026056598815CC9_299656458;
            // ---------- Original Method ----------
            //return c.toString();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.560 -0400", hash_original_field = "BF3B1BE107A3BC6EF3F11D547E97ECD3", hash_generated_field = "ED589FB504EC70A2532C4CA52BA9C8D0")

        private static final long serialVersionUID = 1820017752578914078L;
    }


    
    private static class UnmodifiableRandomAccessList<E> extends UnmodifiableList<E> implements RandomAccess {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.560 -0400", hash_original_method = "0A20B358F7BA1E60AD6DE80ADB85C324", hash_generated_method = "205D9E6E7A9FC9AE79599882AC59F3B2")
          UnmodifiableRandomAccessList(List<E> l) {
            super(l);
            addTaint(l.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.561 -0400", hash_original_method = "BFD692E8EF2A50E82DD6BA0EC7051578", hash_generated_method = "53349976EEB6FD914BA40C1A16886EB2")
        @Override
        public List<E> subList(int start, int end) {
            addTaint(end);
            addTaint(start);
List<E> varBA808AAB260B23150BE108CC34C64548_1503556025 =             new UnmodifiableRandomAccessList<E>(list.subList(start, end));
            varBA808AAB260B23150BE108CC34C64548_1503556025.addTaint(taint);
            return varBA808AAB260B23150BE108CC34C64548_1503556025;
            // ---------- Original Method ----------
            //return new UnmodifiableRandomAccessList<E>(list.subList(start, end));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.561 -0400", hash_original_method = "C39E6F512687738DD8D987CDE63A2838", hash_generated_method = "81F07F3897C7389775E6C0EBBA7EA0F3")
        private Object writeReplace() {
Object var49FE19F72A72127942299509E99152D2_1408297533 =             new UnmodifiableList<E>(list);
            var49FE19F72A72127942299509E99152D2_1408297533.addTaint(taint);
            return var49FE19F72A72127942299509E99152D2_1408297533;
            // ---------- Original Method ----------
            //return new UnmodifiableList<E>(list);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.561 -0400", hash_original_field = "70DB59789BD14A138F9B12A5CF11EB14", hash_generated_field = "871EA319ACA4D6DBFD800453B4F24DBA")

        private static final long serialVersionUID = -2542308836966382001L;
    }


    
    private static class UnmodifiableList<E> extends UnmodifiableCollection<E> implements List<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.561 -0400", hash_original_field = "10AE9FC7D453B0DD525D0EDF2EDE7961", hash_generated_field = "1ECA8D0C53ED31C6D874046BB18C0645")

        List<E> list;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.562 -0400", hash_original_method = "4CB96388E36B825DE711E2E59A893E0D", hash_generated_method = "51986B2400081BEED0D63B6036986FF3")
          UnmodifiableList(List<E> l) {
            super(l);
            list = l;
            // ---------- Original Method ----------
            //list = l;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.562 -0400", hash_original_method = "CE54A57EF9628E9FD413F964E9F93054", hash_generated_method = "D37ACE09484792EBEA06F7C13B297DCD")
        @Override
        public void add(int location, E object) {
            addTaint(object.getTaint());
            addTaint(location);
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1149288070 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_1149288070.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_1149288070;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.563 -0400", hash_original_method = "6CD19404B4901DECE5B6F72EB7D0CD8F", hash_generated_method = "43AEA5219ED50F311F9A53FFCAFD067D")
        @Override
        public boolean addAll(int location, Collection<? extends E> collection) {
            addTaint(collection.getTaint());
            addTaint(location);
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_869319162 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_869319162.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_869319162;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.563 -0400", hash_original_method = "C3C1892342CAEB152D9191558B893ACD", hash_generated_method = "A357E181CB7C2E5B227FCEF8388B2611")
        @Override
        public boolean equals(Object object) {
            addTaint(object.getTaint());
            boolean var3031446AD6BFF612C63BB52505A53EB2_2116409709 = (list.equals(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_424297330 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_424297330;
            // ---------- Original Method ----------
            //return list.equals(object);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.563 -0400", hash_original_method = "DFB24286AA0C5C6BF58031CA4ED7CDCB", hash_generated_method = "7776159160FDD431D5206F07C0B3EF79")
        @Override
        public E get(int location) {
            addTaint(location);
E var4DE8B026CD0A7863FB8A32177D5AA64A_1537612851 =             list.get(location);
            var4DE8B026CD0A7863FB8A32177D5AA64A_1537612851.addTaint(taint);
            return var4DE8B026CD0A7863FB8A32177D5AA64A_1537612851;
            // ---------- Original Method ----------
            //return list.get(location);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.564 -0400", hash_original_method = "8FDA3E2E38E99F5D6FC34E94E92E953F", hash_generated_method = "8C480AF729DAD5000CF2F5C770BAF5C6")
        @Override
        public int hashCode() {
            int varE2167E8879221CB1AE58F4BC195DE759_1249097061 = (list.hashCode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2044242178 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2044242178;
            // ---------- Original Method ----------
            //return list.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.564 -0400", hash_original_method = "E8AAF2C874038C363BF8C80F2A4ED8F2", hash_generated_method = "95E4FB4424019516245B12BE2CAD53DB")
        @Override
        public int indexOf(Object object) {
            addTaint(object.getTaint());
            int var58D9FF43F4C251B9AED86186A326AAC3_1867378331 = (list.indexOf(object));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_779179300 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_779179300;
            // ---------- Original Method ----------
            //return list.indexOf(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.564 -0400", hash_original_method = "658C7926C6DFF1B86F4D9B6B0E3F5BBD", hash_generated_method = "1F9032E079C306962B2F1F8FE6CF6307")
        @Override
        public int lastIndexOf(Object object) {
            addTaint(object.getTaint());
            int var967566C6740C482F2073B67DA9C60440_1063998515 = (list.lastIndexOf(object));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1504993430 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1504993430;
            // ---------- Original Method ----------
            //return list.lastIndexOf(object);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.565 -0400", hash_original_method = "DF7BE0B13ABC5A9B1C74313BD06FB64C", hash_generated_method = "7225B95CBA723722EDAAA564D1AAE434")
        @Override
        public ListIterator<E> listIterator() {
ListIterator<E> var68247D54D1DDB9E66659394CC1668C3F_1773590831 =             listIterator(0);
            var68247D54D1DDB9E66659394CC1668C3F_1773590831.addTaint(taint);
            return var68247D54D1DDB9E66659394CC1668C3F_1773590831;
            // ---------- Original Method ----------
            //return listIterator(0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.570 -0400", hash_original_method = "1D0E6831E50FA8995D23240A6E091C82", hash_generated_method = "C002F2065FBB94ABBF82DD90EDA92E4D")
        @Override
        public ListIterator<E> listIterator(final int location) {
            addTaint(location);
ListIterator<E> var69CB1B11F3ED0B0F805A4D48ECD2D84F_583287742 =             new ListIterator<E>() {            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.565 -0400", hash_original_field = "7CD65118F3CDA81C86B2D3C9CB7B6B0C", hash_generated_field = "3511DBB9873C9158ABE706F9AEA2F24A")
            ListIterator<E> iterator = list.listIterator(location);
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.565 -0400", hash_original_method = "960DAE05B3D69FE5F79E9628DB5B33E6", hash_generated_method = "60D7607700CA1E41FBBDEDD633F0B96E")
            @Override
            public void add(E object) {
                addTaint(object.getTaint());
                UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_193384998 = new UnsupportedOperationException();
                var81FA7E299EEE7F062EBFBEEF08B0464D_193384998.addTaint(taint);
                throw var81FA7E299EEE7F062EBFBEEF08B0464D_193384998;
                // ---------- Original Method ----------
                //throw new UnsupportedOperationException();
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.566 -0400", hash_original_method = "AA3B17E619A4DDCE5FFF27C1294FF431", hash_generated_method = "40B63B4E87832F0B5A51C7B40DFEC9FE")
            @Override
            public boolean hasNext() {
                boolean varD6B09E4375C520F8E3C47E2CD37ACCE3_367138477 = (iterator.hasNext());
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1054161554 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1054161554;
                // ---------- Original Method ----------
                //return iterator.hasNext();
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.567 -0400", hash_original_method = "6C308ED658D3F7DABB0C5BB5EC622D45", hash_generated_method = "2114BF224E07B2C4EE9A280345AF9C28")
            @Override
            public boolean hasPrevious() {
                boolean var1D9DFEF96F49CEE08EA58E8770A1457E_196865368 = (iterator.hasPrevious());
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2063935546 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2063935546;
                // ---------- Original Method ----------
                //return iterator.hasPrevious();
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.568 -0400", hash_original_method = "E4F6FE4F8164B2EF0F004EE03FA1069C", hash_generated_method = "D0EDD71A4C8C25CF50F717F748F2417F")
            @Override
            public E next() {
E var862BD85102BDD28E8A3902D84E203428_223097048 =                 iterator.next();
                var862BD85102BDD28E8A3902D84E203428_223097048.addTaint(taint);
                return var862BD85102BDD28E8A3902D84E203428_223097048;
                // ---------- Original Method ----------
                //return iterator.next();
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.569 -0400", hash_original_method = "966AADF518643C3720C5A10EB9E91B73", hash_generated_method = "7EB4A089F0AD2E72FA7AFA729C1D1BDD")
            @Override
            public int nextIndex() {
                int var12CE9DD76E6F4194F341429D42990C03_95872918 = (iterator.nextIndex());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1050768910 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1050768910;
                // ---------- Original Method ----------
                //return iterator.nextIndex();
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.569 -0400", hash_original_method = "AEA372ED9A2A3ECAEDCF64AE3E3251E3", hash_generated_method = "146F27492E383136D557B9791D9BCF4E")
            @Override
            public E previous() {
E var31413FEE771C499A1C4BF17C156DB014_1002824023 =                 iterator.previous();
                var31413FEE771C499A1C4BF17C156DB014_1002824023.addTaint(taint);
                return var31413FEE771C499A1C4BF17C156DB014_1002824023;
                // ---------- Original Method ----------
                //return iterator.previous();
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.570 -0400", hash_original_method = "4F453E1B19F3569A7CE9D88D231730E4", hash_generated_method = "51E52EE6BFE185F7A2A9A867D4F1EAF0")
            @Override
            public int previousIndex() {
                int varB2E4AE1C39C71EE7202B8000B21579AF_912399942 = (iterator.previousIndex());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_234553300 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_234553300;
                // ---------- Original Method ----------
                //return iterator.previousIndex();
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.570 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "63501C5567D66D3BD95202AC0F62C9C7")
            @Override
            public void remove() {
                UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1747483902 = new UnsupportedOperationException();
                var81FA7E299EEE7F062EBFBEEF08B0464D_1747483902.addTaint(taint);
                throw var81FA7E299EEE7F062EBFBEEF08B0464D_1747483902;
                // ---------- Original Method ----------
                //throw new UnsupportedOperationException();
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.570 -0400", hash_original_method = "1001E1C2B2FD09C7DE97126421AC0A91", hash_generated_method = "5AB27E1F79F6337FF099AF8B9CA9B773")
            @Override
            public void set(E object) {
                addTaint(object.getTaint());
                UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1341846028 = new UnsupportedOperationException();
                var81FA7E299EEE7F062EBFBEEF08B0464D_1341846028.addTaint(taint);
                throw var81FA7E299EEE7F062EBFBEEF08B0464D_1341846028;
                // ---------- Original Method ----------
                //throw new UnsupportedOperationException();
            }
};
            var69CB1B11F3ED0B0F805A4D48ECD2D84F_583287742.addTaint(taint);
            return var69CB1B11F3ED0B0F805A4D48ECD2D84F_583287742;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.574 -0400", hash_original_method = "5388D372D048D053ADD084F02A9C1484", hash_generated_method = "7D981BBB97B85A44145E2FD07A7D2516")
        @Override
        public E remove(int location) {
            addTaint(location);
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1098813283 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_1098813283.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_1098813283;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.578 -0400", hash_original_method = "8830E2F07CC294339D5D496574BCFA5E", hash_generated_method = "AE294195CB91D8064082C853A473B5D9")
        @Override
        public E set(int location, E object) {
            addTaint(object.getTaint());
            addTaint(location);
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1038636217 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_1038636217.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_1038636217;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.585 -0400", hash_original_method = "82D78FB8922B9A0888EF8A304898D60D", hash_generated_method = "BD545268FCD2DC97BAB1112BB4B0B90A")
        @Override
        public List<E> subList(int start, int end) {
            addTaint(end);
            addTaint(start);
List<E> varADECA7016C61BEC124377A2945128243_389927102 =             new UnmodifiableList<E>(list.subList(start, end));
            varADECA7016C61BEC124377A2945128243_389927102.addTaint(taint);
            return varADECA7016C61BEC124377A2945128243_389927102;
            // ---------- Original Method ----------
            //return new UnmodifiableList<E>(list.subList(start, end));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.586 -0400", hash_original_method = "5F3DDA40E6BDC67502A2E43BA75DBB15", hash_generated_method = "51E1FB9C5C750C00C8ABFC36FB433F3C")
        private Object readResolve() {
    if(list instanceof RandomAccess)            
            {
Object var8D8AD294B7DD22470EF7FD69FA78ABA2_1480071969 =                 new UnmodifiableRandomAccessList<E>(list);
                var8D8AD294B7DD22470EF7FD69FA78ABA2_1480071969.addTaint(taint);
                return var8D8AD294B7DD22470EF7FD69FA78ABA2_1480071969;
            } //End block
Object var72A74007B2BE62B849F475C7BDA4658B_1543542462 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1543542462.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1543542462;
            // ---------- Original Method ----------
            //if (list instanceof RandomAccess) {
                //return new UnmodifiableRandomAccessList<E>(list);
            //}
            //return this;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.586 -0400", hash_original_field = "69FDA83BF467A43A3D5BCAA929D897B3", hash_generated_field = "F0F0F0942F5CE1242FD2AB85FF483C32")

        private static final long serialVersionUID = -283967356065247728L;
    }


    
    private static class UnmodifiableMap<K, V> implements Map<K, V>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.587 -0400", hash_original_field = "6F8F57715090DA2632453988D9A1501B", hash_generated_field = "1785B4570966C73126874A8D942D2395")

        private Map<K, V> m;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.587 -0400", hash_original_method = "74C4A0289A3E9196E4EF75F76384A7D2", hash_generated_method = "DA7567E66A4C382E1EF89234BCC9D997")
          UnmodifiableMap(Map<K, V> map) {
            m = map;
            // ---------- Original Method ----------
            //m = map;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.588 -0400", hash_original_method = "C5BE2B5F9D582C4EED1DC0880E8741A1", hash_generated_method = "8FADE304CC283F3489988D071747BD54")
        @Override
        public void clear() {
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_853366231 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_853366231.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_853366231;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.588 -0400", hash_original_method = "A6C730848D8A626F99D8229EE744E3C0", hash_generated_method = "C38602E41918CD8450B9D5A228AAF006")
        @Override
        public boolean containsKey(Object key) {
            addTaint(key.getTaint());
            boolean var62AFCABB34FB6B56AC689F51EB3A9E27_690446965 = (m.containsKey(key));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1360589570 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1360589570;
            // ---------- Original Method ----------
            //return m.containsKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.589 -0400", hash_original_method = "EF8C00CF950E8C186D2F05E1E556F384", hash_generated_method = "8F914403B400682DCC76998A194BC560")
        @Override
        public boolean containsValue(Object value) {
            addTaint(value.getTaint());
            boolean varD6C1BCF4353E9D47F21CF5A12A4A7A3C_501331676 = (m.containsValue(value));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1405721042 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1405721042;
            // ---------- Original Method ----------
            //return m.containsValue(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.590 -0400", hash_original_method = "FB0DE15DA25D3994421C9FBDD1812EDD", hash_generated_method = "E167614FAF77448BAAD126DC4C31A5BA")
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
Set<Map.Entry<K, V>> var609ADEC567CF772927A2504C9FEB51A9_123644496 =             new UnmodifiableEntrySet<K, V>(m.entrySet());
            var609ADEC567CF772927A2504C9FEB51A9_123644496.addTaint(taint);
            return var609ADEC567CF772927A2504C9FEB51A9_123644496;
            // ---------- Original Method ----------
            //return new UnmodifiableEntrySet<K, V>(m.entrySet());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.590 -0400", hash_original_method = "CE201E78EAC5D1903F741160CB297EAE", hash_generated_method = "03C763E0DBEC63803D7A65306DF34D2A")
        @Override
        public boolean equals(Object object) {
            addTaint(object.getTaint());
            boolean var2173C29FE79E34E394A75A59701DB2CC_1314828036 = (m.equals(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1152901929 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1152901929;
            // ---------- Original Method ----------
            //return m.equals(object);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.591 -0400", hash_original_method = "B8FE254B61C57EC3A6DCE539976DA268", hash_generated_method = "C929F561C9483ECFE8D36E6F198CD075")
        @Override
        public V get(Object key) {
            addTaint(key.getTaint());
V var3A7E11B6611BEAA522E24ED974C59715_250502539 =             m.get(key);
            var3A7E11B6611BEAA522E24ED974C59715_250502539.addTaint(taint);
            return var3A7E11B6611BEAA522E24ED974C59715_250502539;
            // ---------- Original Method ----------
            //return m.get(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.591 -0400", hash_original_method = "E3229E3389F030DD50B79734943DB788", hash_generated_method = "0A3E4D9AC0F6CD54EE1D0D55573DB5F2")
        @Override
        public int hashCode() {
            int varE3BA1212D08FEDD275814D3960FD8F10_1944340106 = (m.hashCode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1043438264 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1043438264;
            // ---------- Original Method ----------
            //return m.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.592 -0400", hash_original_method = "B9E63D3C52241E7E917CB1416ABA36E5", hash_generated_method = "B7E796FB4952ED933A35C79CFC1C1D91")
        @Override
        public boolean isEmpty() {
            boolean var6FFDB0B6EFF2802DEEBD39B93137FE90_1415706655 = (m.isEmpty());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1341673569 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1341673569;
            // ---------- Original Method ----------
            //return m.isEmpty();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.592 -0400", hash_original_method = "2CC049F262DAAA6660AF161E9C8606F6", hash_generated_method = "9D7ED8F2895D1771DE7C63AA035DD570")
        @Override
        public Set<K> keySet() {
Set<K> var4B8E49910ECC42FB2E6ACB972650B96D_1426964839 =             new UnmodifiableSet<K>(m.keySet());
            var4B8E49910ECC42FB2E6ACB972650B96D_1426964839.addTaint(taint);
            return var4B8E49910ECC42FB2E6ACB972650B96D_1426964839;
            // ---------- Original Method ----------
            //return new UnmodifiableSet<K>(m.keySet());
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.593 -0400", hash_original_method = "1AE25A34BEB4A8F08F41373ADFFCFE34", hash_generated_method = "7306DCC1BF9AF002475666EF631A6823")
        @Override
        public V put(K key, V value) {
            addTaint(value.getTaint());
            addTaint(key.getTaint());
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1294159247 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_1294159247.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_1294159247;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.594 -0400", hash_original_method = "1D605566C28BBD06FDC515389557B406", hash_generated_method = "449671B0D8E43DEDC4C5E457E95A2F8D")
        @Override
        public void putAll(Map<? extends K, ? extends V> map) {
            addTaint(map.getTaint());
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1832854257 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_1832854257.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_1832854257;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.594 -0400", hash_original_method = "1F8D4C123F3DDBF68E61E38EDB13F5FB", hash_generated_method = "34DABDA31BDFD0DF8D645422B57E7665")
        @Override
        public V remove(Object key) {
            addTaint(key.getTaint());
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_730900937 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_730900937.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_730900937;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.594 -0400", hash_original_method = "A04EE09DEB6F21FAA6A7E10DF6401CD1", hash_generated_method = "964E14B5148A9C93D8D46E3B4A5D35EB")
        @Override
        public int size() {
            int var313B2D1C305A713CA398B12007C9967C_1429765966 = (m.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_991421211 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_991421211;
            // ---------- Original Method ----------
            //return m.size();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.595 -0400", hash_original_method = "19DD84E0D2EBBBC2FCDA12D023824450", hash_generated_method = "B8546CE9F37FDB3B046193C8CE850141")
        @Override
        public Collection<V> values() {
Collection<V> varAAA3B7F2BB8B957714BF1B9640B66E8A_498559654 =             new UnmodifiableCollection<V>(m.values());
            varAAA3B7F2BB8B957714BF1B9640B66E8A_498559654.addTaint(taint);
            return varAAA3B7F2BB8B957714BF1B9640B66E8A_498559654;
            // ---------- Original Method ----------
            //return new UnmodifiableCollection<V>(m.values());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.595 -0400", hash_original_method = "5DD44B3CD2826BF39F974F66579CF74F", hash_generated_method = "FE4C5441B223B18F2D0BE4AD452A0C8B")
        @Override
        public String toString() {
String var8389EA5D3F4E9FD19F68E63143EE799F_1221024900 =             m.toString();
            var8389EA5D3F4E9FD19F68E63143EE799F_1221024900.addTaint(taint);
            return var8389EA5D3F4E9FD19F68E63143EE799F_1221024900;
            // ---------- Original Method ----------
            //return m.toString();
        }

        
        private static class UnmodifiableEntrySet<K, V> extends UnmodifiableSet<Map.Entry<K, V>> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.595 -0400", hash_original_method = "211DEE98878E4422E2F38E79CDC5F0D4", hash_generated_method = "E5E05A5D1E2777C870B2B3DCCCA2A2BD")
              UnmodifiableEntrySet(Set<Map.Entry<K, V>> set) {
                super(set);
                addTaint(set.getTaint());
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.597 -0400", hash_original_method = "53A7F61EDA7A64FBCB28AE61A8906002", hash_generated_method = "F765AC03CBE5B6F160438688776BCFE5")
            @Override
            public Iterator<Map.Entry<K, V>> iterator() {
Iterator<Map.Entry<K, V>> var95D309287220EAC9AA0261E09FAD4D41_1605719040 =                 new Iterator<Map.Entry<K, V>>() {                @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.596 -0400", hash_original_field = "8EFDCD9E60E16BF9DA2CF814FA6A227A", hash_generated_field = "5453FE1747389AC528B71FA32FDEB84E")
                Iterator<Map.Entry<K, V>> iterator = c.iterator();
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.596 -0400", hash_original_method = "AA3B17E619A4DDCE5FFF27C1294FF431", hash_generated_method = "D4AD808AD1786532ABDD76C105225007")
                @Override
                public boolean hasNext() {
                    boolean varD6B09E4375C520F8E3C47E2CD37ACCE3_480717376 = (iterator.hasNext());
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_750891794 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_750891794;
                    // ---------- Original Method ----------
                    //return iterator.hasNext();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.597 -0400", hash_original_method = "EEF2AC3DD179F17AE4AC144ABD5D488C", hash_generated_method = "FEF55521E8FC6C17770352CF1BD49066")
                @Override
                public Map.Entry<K, V> next() {
Map.Entry<K, V> var42E2F932C8AFB71AAEEE9BC7765782DF_1668198156 =                     new UnmodifiableMapEntry<K, V>(iterator.next());
                    var42E2F932C8AFB71AAEEE9BC7765782DF_1668198156.addTaint(taint);
                    return var42E2F932C8AFB71AAEEE9BC7765782DF_1668198156;
                    // ---------- Original Method ----------
                    //return new UnmodifiableMapEntry<K, V>(iterator.next());
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.597 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "EDA66607445504C5A7FE046C9BBA4E00")
                @Override
                public void remove() {
                    UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1291563360 = new UnsupportedOperationException();
                    var81FA7E299EEE7F062EBFBEEF08B0464D_1291563360.addTaint(taint);
                    throw var81FA7E299EEE7F062EBFBEEF08B0464D_1291563360;
                    // ---------- Original Method ----------
                    //throw new UnsupportedOperationException();
                }
};
                var95D309287220EAC9AA0261E09FAD4D41_1605719040.addTaint(taint);
                return var95D309287220EAC9AA0261E09FAD4D41_1605719040;
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.598 -0400", hash_original_method = "C353E5DD4879B90DAE1A37DDC4A8ED8C", hash_generated_method = "17F7A1F145507449A1A7D5FFC3865424")
            @Override
            public Object[] toArray() {
                int length = c.size();
                Object[] result = new Object[length];
                Iterator<?> it = iterator();
for(int i = length;--i >= 0;)
                {
                    result[i] = it.next();
                } //End block
Object[] varDC838461EE2FA0CA4C9BBB70A15456B0_750349864 =                 result;
                varDC838461EE2FA0CA4C9BBB70A15456B0_750349864.addTaint(taint);
                return varDC838461EE2FA0CA4C9BBB70A15456B0_750349864;
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.599 -0400", hash_original_method = "CB9686BEA448DC0D7D0077DDEB1917CB", hash_generated_method = "D06DF1E49ED60803DD68E0AB760ABEAA")
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
T[] var5DC9C33EDB9F81CF1216538024B770BE_248339971 =                 contents;
                var5DC9C33EDB9F81CF1216538024B770BE_248339971.addTaint(taint);
                return var5DC9C33EDB9F81CF1216538024B770BE_248339971;
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
                @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.599 -0400", hash_original_field = "5B2F0A0A5E89589F62B233C643034719", hash_generated_field = "24589B068FBC99F8ED52DE988ED39319")

                Map.Entry<K, V> mapEntry;
                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.600 -0400", hash_original_method = "E37A4627FD27E632126EED134E00D831", hash_generated_method = "A97AFE882B9E93ECA34E23B05853DCFA")
                  UnmodifiableMapEntry(Map.Entry<K, V> entry) {
                    mapEntry = entry;
                    // ---------- Original Method ----------
                    //mapEntry = entry;
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.600 -0400", hash_original_method = "90F914E663E54C2DC9846974DAA2EFB8", hash_generated_method = "B5F0223928599010D0E0ED2B741B6344")
                @Override
                public boolean equals(Object object) {
                    addTaint(object.getTaint());
                    boolean var068C627FA27B72D49071EFF9531EDD5F_1309394182 = (mapEntry.equals(object));
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1204343872 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1204343872;
                    // ---------- Original Method ----------
                    //return mapEntry.equals(object);
                }

                
                @DSModeled(DSC.SAFE)
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.600 -0400", hash_original_method = "4DDB57034C15C2636BC5A8AFB2B3C75A", hash_generated_method = "4270AD5044551063EA7C01CCD37BB9C6")
                @Override
                public K getKey() {
K var1266DB74D74FC0AA9813C1E4FD8E44C9_1905427110 =                     mapEntry.getKey();
                    var1266DB74D74FC0AA9813C1E4FD8E44C9_1905427110.addTaint(taint);
                    return var1266DB74D74FC0AA9813C1E4FD8E44C9_1905427110;
                    // ---------- Original Method ----------
                    //return mapEntry.getKey();
                }

                
                @DSModeled(DSC.SAFE)
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.601 -0400", hash_original_method = "EA1063FCD9D2F699A9610E0A7FDC81FD", hash_generated_method = "5A6C65B744FBA12890636888B9C5BF5F")
                @Override
                public V getValue() {
V var1ECA470EE2F8D5500CEEBF3F98E35CB6_1169007071 =                     mapEntry.getValue();
                    var1ECA470EE2F8D5500CEEBF3F98E35CB6_1169007071.addTaint(taint);
                    return var1ECA470EE2F8D5500CEEBF3F98E35CB6_1169007071;
                    // ---------- Original Method ----------
                    //return mapEntry.getValue();
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.601 -0400", hash_original_method = "8A31FFFC42BCA6E359386EC1F8534D45", hash_generated_method = "275B6E0C1A7D847D02356D0C390E6D11")
                @Override
                public int hashCode() {
                    int var299BCBC4254A420D4D2C42119709A73C_1130297899 = (mapEntry.hashCode());
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_847332447 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_847332447;
                    // ---------- Original Method ----------
                    //return mapEntry.hashCode();
                }

                
                @DSModeled(DSC.SAFE)
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.601 -0400", hash_original_method = "3526712C126765AF36CB8D920CBD3B1B", hash_generated_method = "2183398387AC121A12A58A4D7268A75E")
                @Override
                public V setValue(V object) {
                    addTaint(object.getTaint());
                    UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1145970408 = new UnsupportedOperationException();
                    var81FA7E299EEE7F062EBFBEEF08B0464D_1145970408.addTaint(taint);
                    throw var81FA7E299EEE7F062EBFBEEF08B0464D_1145970408;
                    // ---------- Original Method ----------
                    //throw new UnsupportedOperationException();
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.602 -0400", hash_original_method = "514C7E8B8C54DBFDFB3E185BADD6AD0A", hash_generated_method = "6FE4265304E4EC5ABC8A53ECF5CFEF28")
                @Override
                public String toString() {
String varDD6ECDB9CC96346AAAE786051DD41EF3_1256501812 =                     mapEntry.toString();
                    varDD6ECDB9CC96346AAAE786051DD41EF3_1256501812.addTaint(taint);
                    return varDD6ECDB9CC96346AAAE786051DD41EF3_1256501812;
                    // ---------- Original Method ----------
                    //return mapEntry.toString();
                }

                
            }


            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.602 -0400", hash_original_field = "B44292591B716EDD855C6E185A9AC989", hash_generated_field = "12B2F4473571AB0F630FC68FA4B581F0")

            private static final long serialVersionUID = 7854390611657943733L;
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.602 -0400", hash_original_field = "5569682F9E1154F1C678E958FEEE9E89", hash_generated_field = "FFB33DF33FB47F4C6369B7156E5B3319")

        private static final long serialVersionUID = -1034234728574286014L;
    }


    
    private static class UnmodifiableSet<E> extends UnmodifiableCollection<E> implements Set<E> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.602 -0400", hash_original_method = "D46A71F25EF02541A08678630568218D", hash_generated_method = "DBD124D7730B2343640D7C872444495D")
          UnmodifiableSet(Set<E> set) {
            super(set);
            addTaint(set.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.603 -0400", hash_original_method = "BB8664F3F5CB90AA83689CAADCD9EA6B", hash_generated_method = "9161094F7481ED8F1AE27A6866B7EABE")
        @Override
        public boolean equals(Object object) {
            addTaint(object.getTaint());
            boolean varAB5EB3EC9A33BCFBC5D0F02B0F8BDEF2_2033093711 = (c.equals(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_116420726 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_116420726;
            // ---------- Original Method ----------
            //return c.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.603 -0400", hash_original_method = "E858D80F3EEDE9F2B52CDB7DA7FBF12B", hash_generated_method = "764C656E7DE4CE3E631BB6A49CEAAD2A")
        @Override
        public int hashCode() {
            int var3FFC490E9FA1D410CC240764C2B77761_152709020 = (c.hashCode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1225602003 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1225602003;
            // ---------- Original Method ----------
            //return c.hashCode();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.603 -0400", hash_original_field = "F3BE7D79D6D6372B9FD4F3861D721F88", hash_generated_field = "E7C72ADB8696D042D902371BEB24646C")

        private static final long serialVersionUID = -9215047833775013803L;
    }


    
    private static class UnmodifiableSortedMap<K, V> extends UnmodifiableMap<K, V> implements SortedMap<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.604 -0400", hash_original_field = "ED79ACB0CD3D7F8320C53C7798335EF0", hash_generated_field = "F813233D7B24D3620137345516D05A23")

        private SortedMap<K, V> sm;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.605 -0400", hash_original_method = "AC9FE01B421B1E54651959AD61521CA6", hash_generated_method = "FE478A77C43C9AB097C4727B1013B70C")
          UnmodifiableSortedMap(SortedMap<K, V> map) {
            super(map);
            sm = map;
            // ---------- Original Method ----------
            //sm = map;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.606 -0400", hash_original_method = "E5FDBCC6560BE7E99B2D2F850BD84149", hash_generated_method = "D0081ED34486CC4B67F18E46808E4E79")
        @Override
        public Comparator<? super K> comparator() {
Comparator<? super K> varEAAD6156DF3FBB0DB169CF3701FE5DAA_509460504 =             sm.comparator();
            varEAAD6156DF3FBB0DB169CF3701FE5DAA_509460504.addTaint(taint);
            return varEAAD6156DF3FBB0DB169CF3701FE5DAA_509460504;
            // ---------- Original Method ----------
            //return sm.comparator();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.608 -0400", hash_original_method = "B25E8C7440C76FBF812FF7AC9CA9D776", hash_generated_method = "5CD51D1155FBE791BEADC8337A140839")
        @Override
        public K firstKey() {
K varA58D1FB276F66FC6ABBF4CA9E354FD1B_1727411994 =             sm.firstKey();
            varA58D1FB276F66FC6ABBF4CA9E354FD1B_1727411994.addTaint(taint);
            return varA58D1FB276F66FC6ABBF4CA9E354FD1B_1727411994;
            // ---------- Original Method ----------
            //return sm.firstKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.616 -0400", hash_original_method = "EC6243B190269A05D31802D1260652E4", hash_generated_method = "DF5ABEE170A94462B34BF39DC548BED2")
        @Override
        public SortedMap<K, V> headMap(K before) {
            addTaint(before.getTaint());
SortedMap<K, V> var9E05A628EDAD674D5AC9E22861CB1AAB_1300370158 =             new UnmodifiableSortedMap<K, V>(sm.headMap(before));
            var9E05A628EDAD674D5AC9E22861CB1AAB_1300370158.addTaint(taint);
            return var9E05A628EDAD674D5AC9E22861CB1AAB_1300370158;
            // ---------- Original Method ----------
            //return new UnmodifiableSortedMap<K, V>(sm.headMap(before));
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.616 -0400", hash_original_method = "00E9126A84DE8B71214859A17DA6BD2E", hash_generated_method = "B7D697FC6F6F922A79C4C5183124BA75")
        @Override
        public K lastKey() {
K varC4E8101F3F71352235F4E401D4498536_765889645 =             sm.lastKey();
            varC4E8101F3F71352235F4E401D4498536_765889645.addTaint(taint);
            return varC4E8101F3F71352235F4E401D4498536_765889645;
            // ---------- Original Method ----------
            //return sm.lastKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.616 -0400", hash_original_method = "B6411009D9179ABF4D7755605B648FDC", hash_generated_method = "E62A9CE49A509C96CD957B1D4DA66DA4")
        @Override
        public SortedMap<K, V> subMap(K start, K end) {
            addTaint(end.getTaint());
            addTaint(start.getTaint());
SortedMap<K, V> varCCBB071ACDDD27B316590ED95D45D92F_436962478 =             new UnmodifiableSortedMap<K, V>(sm.subMap(start, end));
            varCCBB071ACDDD27B316590ED95D45D92F_436962478.addTaint(taint);
            return varCCBB071ACDDD27B316590ED95D45D92F_436962478;
            // ---------- Original Method ----------
            //return new UnmodifiableSortedMap<K, V>(sm.subMap(start, end));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.617 -0400", hash_original_method = "59BADF6C5EE68C4E1DB5A6A22818328A", hash_generated_method = "DB56AF8021E04F02000E83290CDC3247")
        @Override
        public SortedMap<K, V> tailMap(K after) {
            addTaint(after.getTaint());
SortedMap<K, V> var4272A31247EF3DF31C465D4CA23EB8D9_572789600 =             new UnmodifiableSortedMap<K, V>(sm.tailMap(after));
            var4272A31247EF3DF31C465D4CA23EB8D9_572789600.addTaint(taint);
            return var4272A31247EF3DF31C465D4CA23EB8D9_572789600;
            // ---------- Original Method ----------
            //return new UnmodifiableSortedMap<K, V>(sm.tailMap(after));
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.617 -0400", hash_original_field = "BB78CEF8331176F8CBF0AFC85E7523D8", hash_generated_field = "74C1A54CA827DD7351FCAD121C86B500")

        private static final long serialVersionUID = -8806743815996713206L;
    }


    
    private static class UnmodifiableSortedSet<E> extends UnmodifiableSet<E> implements SortedSet<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.617 -0400", hash_original_field = "3691308F2A4C2F6983F2880D32E29C84", hash_generated_field = "5220A6F2AA4CB98BB6C290F0BB717E86")

        private SortedSet<E> ss;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.618 -0400", hash_original_method = "232C45C3B4117EB9042FB58E6C0CE113", hash_generated_method = "C02ACFBA00E84FCE033C7CEC6C326A50")
          UnmodifiableSortedSet(SortedSet<E> set) {
            super(set);
            ss = set;
            // ---------- Original Method ----------
            //ss = set;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.618 -0400", hash_original_method = "8514D9255D678B041F55D03BA11DCA3B", hash_generated_method = "0A9F2E704BBDEB866FE9CBFC418F2EA6")
        @Override
        public Comparator<? super E> comparator() {
Comparator<? super E> varEF7DDB49085F2DA083783C6BC3481D0B_2034010794 =             ss.comparator();
            varEF7DDB49085F2DA083783C6BC3481D0B_2034010794.addTaint(taint);
            return varEF7DDB49085F2DA083783C6BC3481D0B_2034010794;
            // ---------- Original Method ----------
            //return ss.comparator();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.618 -0400", hash_original_method = "6BB6C51843B41CC0DCB5509A79DBA008", hash_generated_method = "4D2B3F433D39D337249C9B648406144B")
        @Override
        public E first() {
E varE64C384BCBD0BF9F8BB2385886B7C815_663457729 =             ss.first();
            varE64C384BCBD0BF9F8BB2385886B7C815_663457729.addTaint(taint);
            return varE64C384BCBD0BF9F8BB2385886B7C815_663457729;
            // ---------- Original Method ----------
            //return ss.first();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.619 -0400", hash_original_method = "74C4BE29898589F7D7948BADA3350612", hash_generated_method = "04EC92DCF89A0065D50AE2F2DCC363AB")
        @Override
        public SortedSet<E> headSet(E before) {
            addTaint(before.getTaint());
SortedSet<E> varFF8D6CDEDB36E38D2AD61812C48750BF_2025387213 =             new UnmodifiableSortedSet<E>(ss.headSet(before));
            varFF8D6CDEDB36E38D2AD61812C48750BF_2025387213.addTaint(taint);
            return varFF8D6CDEDB36E38D2AD61812C48750BF_2025387213;
            // ---------- Original Method ----------
            //return new UnmodifiableSortedSet<E>(ss.headSet(before));
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.619 -0400", hash_original_method = "AAC5DDE787ACA85752B94AAB77F6B0F8", hash_generated_method = "8815D944331EC1DF626258B21019751D")
        @Override
        public E last() {
E var7A1B325A772301476E34C1CFA8ED9C89_1945827434 =             ss.last();
            var7A1B325A772301476E34C1CFA8ED9C89_1945827434.addTaint(taint);
            return var7A1B325A772301476E34C1CFA8ED9C89_1945827434;
            // ---------- Original Method ----------
            //return ss.last();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.619 -0400", hash_original_method = "54602835FD774439E48CB96CB67F9D83", hash_generated_method = "A2B6069784A8F001D44794D60A74F205")
        @Override
        public SortedSet<E> subSet(E start, E end) {
            addTaint(end.getTaint());
            addTaint(start.getTaint());
SortedSet<E> var5983101DC91D536DAE9E9F3DAA0F4158_1559620922 =             new UnmodifiableSortedSet<E>(ss.subSet(start, end));
            var5983101DC91D536DAE9E9F3DAA0F4158_1559620922.addTaint(taint);
            return var5983101DC91D536DAE9E9F3DAA0F4158_1559620922;
            // ---------- Original Method ----------
            //return new UnmodifiableSortedSet<E>(ss.subSet(start, end));
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.620 -0400", hash_original_method = "37640609DAC9C9170FD6CBE14C8AD6B6", hash_generated_method = "066EB75DA45545C6C2DA016E2946684F")
        @Override
        public SortedSet<E> tailSet(E after) {
            addTaint(after.getTaint());
SortedSet<E> var85BF07315C1F5F4B7B2E26C588F4E538_1739344275 =             new UnmodifiableSortedSet<E>(ss.tailSet(after));
            var85BF07315C1F5F4B7B2E26C588F4E538_1739344275.addTaint(taint);
            return var85BF07315C1F5F4B7B2E26C588F4E538_1739344275;
            // ---------- Original Method ----------
            //return new UnmodifiableSortedSet<E>(ss.tailSet(after));
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.620 -0400", hash_original_field = "A7FEB93E06211B53C8063E2CA4FFCCC4", hash_generated_field = "492EEA3FB02A9A00EAE2EF3419CB36AB")

        private static final long serialVersionUID = -4929149591599911165L;
    }


    
    private static class SetFromMap<E> extends AbstractSet<E> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.620 -0400", hash_original_field = "6F8F57715090DA2632453988D9A1501B", hash_generated_field = "8D1145F106DE5C3E2B790E661BC27C3B")

        private Map<E, Boolean> m;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.621 -0400", hash_original_field = "10AA84685E8BF74D8FA1DED104C25521", hash_generated_field = "75D49D8B030B2438C97CCFE06F0E4EF6")

        private transient Set<E> backingSet;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.621 -0400", hash_original_method = "6B962D990E5B5543C1AA025E18134CE9", hash_generated_method = "68252A5316CF37F1B8C0AF671D9233B5")
          SetFromMap(final Map<E, Boolean> map) {
            m = map;
            backingSet = map.keySet();
            // ---------- Original Method ----------
            //m = map;
            //backingSet = map.keySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.621 -0400", hash_original_method = "B42E9CA75A778919E90B77D794DBEE82", hash_generated_method = "2655C33955797338EAC2E392C50BC6ED")
        @Override
        public boolean equals(Object object) {
            addTaint(object.getTaint());
            boolean varC30F0123BD7BEAECC1843E5DCA354C91_289279980 = (backingSet.equals(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1627859941 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1627859941;
            // ---------- Original Method ----------
            //return backingSet.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.622 -0400", hash_original_method = "684F9CE738B21B1B45F3304124963EF1", hash_generated_method = "28D23EA10BF557231A84892145D9BE0E")
        @Override
        public int hashCode() {
            int var67863B4311CEC139EE028FCE4488E86F_1109595579 = (backingSet.hashCode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_91861660 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_91861660;
            // ---------- Original Method ----------
            //return backingSet.hashCode();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.622 -0400", hash_original_method = "FC84A6CABB16433CF1488E03DF7636C8", hash_generated_method = "6C1C89A19028A03DDC8FC0612F5A8A7D")
        @Override
        public boolean add(E object) {
            addTaint(object.getTaint());
            boolean var60B1060CC3CCD3BB395E221A8613469A_1203527399 = (m.put(object, Boolean.TRUE) == null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_796290625 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_796290625;
            // ---------- Original Method ----------
            //return m.put(object, Boolean.TRUE) == null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.622 -0400", hash_original_method = "5163CA2ED3AD9C66F2BDAFB902590115", hash_generated_method = "5C1448B76AB003BA7ABB7E55C1011B37")
        @Override
        public void clear() {
            m.clear();
            // ---------- Original Method ----------
            //m.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.623 -0400", hash_original_method = "C7069F73CC2FBE59B42FACF6A3731192", hash_generated_method = "4BE7663E8D26B5B368E941E465FFE4B8")
        @Override
        public String toString() {
String var06060D832159DFF1A743DE22DFD02BBE_1211979218 =             backingSet.toString();
            var06060D832159DFF1A743DE22DFD02BBE_1211979218.addTaint(taint);
            return var06060D832159DFF1A743DE22DFD02BBE_1211979218;
            // ---------- Original Method ----------
            //return backingSet.toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.623 -0400", hash_original_method = "C1FDFEBBA860B6E21729D041F83BDE39", hash_generated_method = "D63D69A3C1F0CE7E36165481C101540D")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            boolean varF727171565D11CE98C1570ECC663B4C2_1474084671 = (backingSet.contains(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_852668265 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_852668265;
            // ---------- Original Method ----------
            //return backingSet.contains(object);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.624 -0400", hash_original_method = "652D3A93342A70291E00DB196A629050", hash_generated_method = "B29C35D8F8549A265C9A23787135771E")
        @Override
        public boolean containsAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            boolean varFBC587BEB1223549414B53AE862546C9_1896453607 = (backingSet.containsAll(collection));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_226315799 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_226315799;
            // ---------- Original Method ----------
            //return backingSet.containsAll(collection);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.624 -0400", hash_original_method = "B9E63D3C52241E7E917CB1416ABA36E5", hash_generated_method = "F63550F409B2B747E6B29EA5042E76B0")
        @Override
        public boolean isEmpty() {
            boolean var6FFDB0B6EFF2802DEEBD39B93137FE90_1860123000 = (m.isEmpty());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_955209664 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_955209664;
            // ---------- Original Method ----------
            //return m.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.624 -0400", hash_original_method = "20C696E59013C16BDFED7021A5C3E797", hash_generated_method = "13179F24252A02E3AA6FD16F90ABE988")
        @Override
        public boolean remove(Object object) {
            addTaint(object.getTaint());
            boolean varBBFEB77427ECEE6BC6DD85A39948F897_2135707622 = (m.remove(object) != null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_715715190 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_715715190;
            // ---------- Original Method ----------
            //return m.remove(object) != null;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.625 -0400", hash_original_method = "4A27ACEA2C9F194EF4597E8BDECC6BD7", hash_generated_method = "202F4DCBB711E319F75991CC699322C2")
        @Override
        public boolean retainAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            boolean varC258F2F6CC325D00A2245A8926671054_852077113 = (backingSet.retainAll(collection));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_662161650 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_662161650;
            // ---------- Original Method ----------
            //return backingSet.retainAll(collection);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.625 -0400", hash_original_method = "706FD57EC242D189F78C8F40D764E8D0", hash_generated_method = "6EA7ECE69460B2A81B5AD303E3546D35")
        @Override
        public Object[] toArray() {
Object[] var2AFBF44EAF1E21A3A305A3D12C081322_449829570 =             backingSet.toArray();
            var2AFBF44EAF1E21A3A305A3D12C081322_449829570.addTaint(taint);
            return var2AFBF44EAF1E21A3A305A3D12C081322_449829570;
            // ---------- Original Method ----------
            //return backingSet.toArray();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.625 -0400", hash_original_method = "5B684176C593DE73F99AF08724DF65D4", hash_generated_method = "3EBB62C86B21B36CCFA00D05B527505C")
        @Override
        public <T> T[] toArray(T[] contents) {
            addTaint(contents[0].getTaint());
T[] var3546C28EE3387A2856CC723595918E17_414522676 =             backingSet.toArray(contents);
            var3546C28EE3387A2856CC723595918E17_414522676.addTaint(taint);
            return var3546C28EE3387A2856CC723595918E17_414522676;
            // ---------- Original Method ----------
            //return backingSet.toArray(contents);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.626 -0400", hash_original_method = "2EC39271104239DED882FB25EFF4BC23", hash_generated_method = "FF683D753C59D4EAA353F612907A0592")
        @Override
        public Iterator<E> iterator() {
Iterator<E> varFCA11838FE7195B1BCD4A5C4A80B9796_1983440483 =             backingSet.iterator();
            varFCA11838FE7195B1BCD4A5C4A80B9796_1983440483.addTaint(taint);
            return varFCA11838FE7195B1BCD4A5C4A80B9796_1983440483;
            // ---------- Original Method ----------
            //return backingSet.iterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.626 -0400", hash_original_method = "A04EE09DEB6F21FAA6A7E10DF6401CD1", hash_generated_method = "914D30EADCBE212E6C8FA3CB9882E173")
        @Override
        public int size() {
            int var313B2D1C305A713CA398B12007C9967C_1625210771 = (m.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_807115698 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_807115698;
            // ---------- Original Method ----------
            //return m.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.626 -0400", hash_original_method = "8082AE1FFA2825B9433C3082C2F87EDC", hash_generated_method = "C4A865194E7336FA95CD8863516C203F")
        @SuppressWarnings("unchecked")
        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
            addTaint(stream.getTaint());
            stream.defaultReadObject();
            backingSet = m.keySet();
            // ---------- Original Method ----------
            //stream.defaultReadObject();
            //backingSet = m.keySet();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.626 -0400", hash_original_field = "68A2EE38D4624ED7EDE7470F4422D17A", hash_generated_field = "D22893062D677334CA792903B3E2A0BD")

        private static final long serialVersionUID = 2454657854757543876L;
    }


    
    private static class AsLIFOQueue<E> extends AbstractQueue<E> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.627 -0400", hash_original_field = "7694F4A66316E53C8CDD9D9954BD611D", hash_generated_field = "8E692B16EB19650DAECD0B8A91F62E63")

        private Deque<E> q;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.627 -0400", hash_original_method = "C9A3AEFCC3A9FEA0CFED796FADB14DA4", hash_generated_method = "8C725C5253844AF6C1706232C12CC260")
          AsLIFOQueue(final Deque<E> deque) {
            this.q = deque;
            // ---------- Original Method ----------
            //this.q = deque;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.627 -0400", hash_original_method = "D6ABAC5AC9E31C28EFD449012F8C668D", hash_generated_method = "9D361A3911F21AAA97F58C1710EBBB75")
        @Override
        public Iterator<E> iterator() {
Iterator<E> varD39B553C2AE1A151C282A7AD80B8BBF9_1780270435 =             q.iterator();
            varD39B553C2AE1A151C282A7AD80B8BBF9_1780270435.addTaint(taint);
            return varD39B553C2AE1A151C282A7AD80B8BBF9_1780270435;
            // ---------- Original Method ----------
            //return q.iterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.628 -0400", hash_original_method = "4D120CFD44D3EE91A03411EED1F5CA02", hash_generated_method = "37BCB1BD6D2DFF8BDF144D9204BED97D")
        @Override
        public int size() {
            int var439AEF944A957C936AE6F28AA258835C_1613192102 = (q.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2137525507 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2137525507;
            // ---------- Original Method ----------
            //return q.size();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.628 -0400", hash_original_method = "A29AB2808D45581589F8B0269F283532", hash_generated_method = "50ED7C88E22FAE87F001DEA393F29D51")
        @Override
        public boolean offer(E o) {
            addTaint(o.getTaint());
            boolean varCD3677ADCD08BD4D1FA6A059AAF29C17_1946503424 = (q.offerFirst(o));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1077011521 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1077011521;
            // ---------- Original Method ----------
            //return q.offerFirst(o);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.628 -0400", hash_original_method = "286FFABBC697C1CEE6C49194F85DD481", hash_generated_method = "DFFE22E9915B8B9D9E2C8D9A41AB5F80")
        @Override
        public E peek() {
E var72B809E445C36B133CDC3256733B835C_689100695 =             q.peekFirst();
            var72B809E445C36B133CDC3256733B835C_689100695.addTaint(taint);
            return var72B809E445C36B133CDC3256733B835C_689100695;
            // ---------- Original Method ----------
            //return q.peekFirst();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.629 -0400", hash_original_method = "93EF986205EA0EFDB6E2F2BDD9DDBDB0", hash_generated_method = "76850604C0D4A884FC92EBE4B190A4C8")
        @Override
        public E poll() {
E varAED2ABC9BC7A6C61FEC2D7E7AC242301_1517718015 =             q.pollFirst();
            varAED2ABC9BC7A6C61FEC2D7E7AC242301_1517718015.addTaint(taint);
            return varAED2ABC9BC7A6C61FEC2D7E7AC242301_1517718015;
            // ---------- Original Method ----------
            //return q.pollFirst();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.629 -0400", hash_original_method = "E16BCF0F708E6336497510D255228AB4", hash_generated_method = "D1A723C7FE237442615E40F2ACDF2D93")
        @Override
        public boolean add(E o) {
            addTaint(o.getTaint());
            q.push(o);
            boolean varB326B5062B2F0E69046810717534CB09_810490477 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1186867250 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1186867250;
            // ---------- Original Method ----------
            //q.push(o);
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.629 -0400", hash_original_method = "ECF3C7555AB121202E1C39938D734656", hash_generated_method = "72AFA896F4EE9665FC95334E69A68411")
        @Override
        public void clear() {
            q.clear();
            // ---------- Original Method ----------
            //q.clear();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.629 -0400", hash_original_method = "41C0874A8589B77FE1309E3303509F6A", hash_generated_method = "90179BF5FB5DC9435926AA326F7E5E3A")
        @Override
        public E element() {
E var39DE1B6B79580F8ECBFE056F19FB08E8_356665109 =             q.getFirst();
            var39DE1B6B79580F8ECBFE056F19FB08E8_356665109.addTaint(taint);
            return var39DE1B6B79580F8ECBFE056F19FB08E8_356665109;
            // ---------- Original Method ----------
            //return q.getFirst();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.630 -0400", hash_original_method = "DBCAD9866D0C084DC455BF7C95ABCE77", hash_generated_method = "082EA662DD586129809FA4A656BA4BBB")
        @Override
        public E remove() {
E var1D8C9B8E5EBB6E308A89652FCC2FF05C_296951220 =             q.pop();
            var1D8C9B8E5EBB6E308A89652FCC2FF05C_296951220.addTaint(taint);
            return var1D8C9B8E5EBB6E308A89652FCC2FF05C_296951220;
            // ---------- Original Method ----------
            //return q.pop();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.630 -0400", hash_original_method = "2E730D7ABEE184A9C34DA57DF7A457EE", hash_generated_method = "87122C443BA9F6936BDC4C23570F5D41")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            boolean varF7AA0027FF7CF6A518402C1D103649D0_1805884982 = (q.contains(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2141293470 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2141293470;
            // ---------- Original Method ----------
            //return q.contains(object);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.630 -0400", hash_original_method = "3E9E9A2983E74090844621EE9CF6D3D7", hash_generated_method = "7121C5BBCA13D5EB46B37154E7C2C58C")
        @Override
        public boolean containsAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            boolean var2F3EA5C79EFC09F1F5BFE6AB405CF8E1_1966176365 = (q.containsAll(collection));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1078762867 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1078762867;
            // ---------- Original Method ----------
            //return q.containsAll(collection);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.631 -0400", hash_original_method = "3014069A2B40728BACBB472823CCCF21", hash_generated_method = "CCE802C44F13B3814A4DEEF0AB1FD923")
        @Override
        public boolean isEmpty() {
            boolean varB96CEE9B3576CCF3A5D79A3822AA24C0_1392249462 = (q.isEmpty());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1688918440 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1688918440;
            // ---------- Original Method ----------
            //return q.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.631 -0400", hash_original_method = "06C06D3351623BFF7BABDE8B40334F59", hash_generated_method = "6907E7C39CE4B392B0C463B34DE0A038")
        @Override
        public boolean remove(Object object) {
            addTaint(object.getTaint());
            boolean varC41B424C0DA577FA3AD57EDD7A3297DB_588525823 = (q.remove(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_27799668 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_27799668;
            // ---------- Original Method ----------
            //return q.remove(object);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.631 -0400", hash_original_method = "13975D6542267AD488C8D9B27A0905D7", hash_generated_method = "E1FD8BA16F8973E1EB078101FADDE9FA")
        @Override
        public boolean removeAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            boolean varE95384D9CFD6BAC61C00B339AA1C12E6_1356232806 = (q.removeAll(collection));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_216240874 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_216240874;
            // ---------- Original Method ----------
            //return q.removeAll(collection);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.632 -0400", hash_original_method = "029F8EE40CDE382EFA7F7BF13B8FE731", hash_generated_method = "0B19D13D585A4672236B225360582F65")
        @Override
        public boolean retainAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            boolean var15D260DBD7670553DDB130F283831464_1729805669 = (q.retainAll(collection));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1285485280 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1285485280;
            // ---------- Original Method ----------
            //return q.retainAll(collection);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.632 -0400", hash_original_method = "81809EBBF1D8298961C4E9B761FEF748", hash_generated_method = "9ADC740ECA204BE9001EC11FA3DB442C")
        @Override
        public Object[] toArray() {
Object[] var880A48243792151F70528940250FAEFC_975522259 =             q.toArray();
            var880A48243792151F70528940250FAEFC_975522259.addTaint(taint);
            return var880A48243792151F70528940250FAEFC_975522259;
            // ---------- Original Method ----------
            //return q.toArray();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.632 -0400", hash_original_method = "3C7918E789D95B2A97E0F45A2E8277E0", hash_generated_method = "741B1D402AABC38FC45A25C786EB0BE5")
        @Override
        public <T> T[] toArray(T[] contents) {
            addTaint(contents[0].getTaint());
T[] varB826DAACB71C6F73C56D75F228BB03F8_262136205 =             q.toArray(contents);
            varB826DAACB71C6F73C56D75F228BB03F8_262136205.addTaint(taint);
            return varB826DAACB71C6F73C56D75F228BB03F8_262136205;
            // ---------- Original Method ----------
            //return q.toArray(contents);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.633 -0400", hash_original_method = "827F98847BB1D6CEA3B0A324A45F92ED", hash_generated_method = "B835AF8D2D1DEB7FBE9F1AF1D8B167F6")
        @Override
        public String toString() {
String varA79A216DB57E425634893D64CD555087_2020595453 =             q.toString();
            varA79A216DB57E425634893D64CD555087_2020595453.addTaint(taint);
            return varA79A216DB57E425634893D64CD555087_2020595453;
            // ---------- Original Method ----------
            //return q.toString();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.633 -0400", hash_original_field = "7C5B063F84AD7FF4280E3FC6C2D641FE", hash_generated_field = "4687D2B0166F4A9C03E2417C41443082")

        private static final long serialVersionUID = 1802017725587941708L;
    }


    
    private static class CheckedCollection<E> implements Collection<E>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.633 -0400", hash_original_field = "4A8A08F09D37B73795649038408B5F33", hash_generated_field = "A3C80A7E02E49F20400373DFBAF9696A")

        Collection<E> c;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.633 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "D40602D541C2081B4D03EEADC8718DAD")

        Class<E> type;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.634 -0400", hash_original_method = "4DAA5B7D63536360D367B6279A6FD0F0", hash_generated_method = "971B2F55564A8FC7C29A6E77E45D1C8A")
        public  CheckedCollection(Collection<E> c, Class<E> type) {
    if(c == null || type == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1325113795 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1325113795.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1325113795;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.634 -0400", hash_original_method = "AC97C28F724592ABA809E2470D95C119", hash_generated_method = "3918B05F182822201ADE2FBB868C8E6D")
        @Override
        public int size() {
            int varB01543F097DAA850E9B79CBAB9C1B976_810134336 = (c.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1965671300 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1965671300;
            // ---------- Original Method ----------
            //return c.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.635 -0400", hash_original_method = "F9A3CB1FB7570D28EBE20660E2FC6F42", hash_generated_method = "D464A9A68EE7A2BC78ACBB726E6BE131")
        @Override
        public boolean isEmpty() {
            boolean var65FAF5A74582A5D73E221DB675503595_1650725409 = (c.isEmpty());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1510095227 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1510095227;
            // ---------- Original Method ----------
            //return c.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.635 -0400", hash_original_method = "AA502F510015E56A50E854673F52B13D", hash_generated_method = "1DF39D8928F4CA56CB7820DC6EE6E523")
        @Override
        public boolean contains(Object obj) {
            addTaint(obj.getTaint());
            boolean var874204C752DD66571A81E72DE088C268_1821674714 = (c.contains(obj));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1192629133 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1192629133;
            // ---------- Original Method ----------
            //return c.contains(obj);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.636 -0400", hash_original_method = "A49A579D720F57F247BFFB420B912FC7", hash_generated_method = "601F3981C83B74E6A1EFCDCE0C2AB337")
        @Override
        public Iterator<E> iterator() {
            Iterator<E> i = c.iterator();
    if(i instanceof ListIterator)            
            {
                i = new CheckedListIterator<E>((ListIterator<E>) i, type);
            } //End block
Iterator<E> varD9A5948E3E870E6097B7023E4497FFEC_1123297293 =             i;
            varD9A5948E3E870E6097B7023E4497FFEC_1123297293.addTaint(taint);
            return varD9A5948E3E870E6097B7023E4497FFEC_1123297293;
            // ---------- Original Method ----------
            //Iterator<E> i = c.iterator();
            //if (i instanceof ListIterator) {
                //i = new CheckedListIterator<E>((ListIterator<E>) i, type);
            //}
            //return i;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.637 -0400", hash_original_method = "89D7D02A9D2BDF31E775C08108CBDE5B", hash_generated_method = "BA587DA215F62E796CDE31AA9AFBA5FB")
        @Override
        public Object[] toArray() {
Object[] var46570412E19D68724A647FAFEECFBF92_1264112553 =             c.toArray();
            var46570412E19D68724A647FAFEECFBF92_1264112553.addTaint(taint);
            return var46570412E19D68724A647FAFEECFBF92_1264112553;
            // ---------- Original Method ----------
            //return c.toArray();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.637 -0400", hash_original_method = "9B8166862C116AE305DE64E80811892F", hash_generated_method = "9FFC9104B13120E47AB30C8502C37089")
        @Override
        public <T> T[] toArray(T[] arr) {
            addTaint(arr[0].getTaint());
T[] varC7FA0C6E1955DD91DCB427C3A91A0EA7_482786848 =             c.toArray(arr);
            varC7FA0C6E1955DD91DCB427C3A91A0EA7_482786848.addTaint(taint);
            return varC7FA0C6E1955DD91DCB427C3A91A0EA7_482786848;
            // ---------- Original Method ----------
            //return c.toArray(arr);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.637 -0400", hash_original_method = "233202E3883C87159328A7DF45C5A0DD", hash_generated_method = "008F2964F638C9F51ACC1A0E9547D8C1")
        @Override
        public boolean add(E obj) {
            addTaint(obj.getTaint());
            boolean varFB27217C76737CE1366B2CBDCE2F738C_850548503 = (c.add(checkType(obj, type)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_960453011 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_960453011;
            // ---------- Original Method ----------
            //return c.add(checkType(obj, type));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.638 -0400", hash_original_method = "A7C1CDA142B015DD1AAB47325584260A", hash_generated_method = "69B36F8FF0D126CD460536215D21FD43")
        @Override
        public boolean remove(Object obj) {
            addTaint(obj.getTaint());
            boolean varFC763DF5EAD188B2AD1ED0810A9284B6_2031197970 = (c.remove(obj));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1197971534 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1197971534;
            // ---------- Original Method ----------
            //return c.remove(obj);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.638 -0400", hash_original_method = "8A54483E259CA6D3C8AB1EBE7493D296", hash_generated_method = "B1DE5DA981317E0EF1F0C3838C76781B")
        @Override
        public boolean containsAll(Collection<?> c1) {
            addTaint(c1.getTaint());
            boolean var5DFE467800E15F0E1972CFDCDBFA5B60_837341170 = (c.containsAll(c1));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_197266859 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_197266859;
            // ---------- Original Method ----------
            //return c.containsAll(c1);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.639 -0400", hash_original_method = "A2391F235E9474A0C2FADB6F2C5C2AB0", hash_generated_method = "99731B00F3E0BE34A423A02126549C9F")
        @SuppressWarnings("unchecked")
        @Override
        public boolean addAll(Collection<? extends E> c1) {
            addTaint(c1.getTaint());
            Object[] array = c1.toArray();
for(Object o : array)
            {
                checkType(o, type);
            } //End block
            boolean var17C01334C1A3B801F95A3E855A6155C0_630658871 = (c.addAll((List<E>) Arrays.asList(array)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1655413874 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1655413874;
            // ---------- Original Method ----------
            //Object[] array = c1.toArray();
            //for (Object o : array) {
                //checkType(o, type);
            //}
            //return c.addAll((List<E>) Arrays.asList(array));
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.640 -0400", hash_original_method = "E5A4F3F5A50F475A125F07680365C964", hash_generated_method = "C29FD36218E698143B96AB6E5424686D")
        @Override
        public boolean removeAll(Collection<?> c1) {
            addTaint(c1.getTaint());
            boolean varA68FC87E792608B8C555C5D12B82C7E6_260235907 = (c.removeAll(c1));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_260900856 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_260900856;
            // ---------- Original Method ----------
            //return c.removeAll(c1);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.640 -0400", hash_original_method = "2CCBBE73D1665A80965D3FA8CB644A3B", hash_generated_method = "BE079C4F644DF507C119DC4F8014473A")
        @Override
        public boolean retainAll(Collection<?> c1) {
            addTaint(c1.getTaint());
            boolean var1429F547061A089034C637B072A34287_361920621 = (c.retainAll(c1));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1918984926 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1918984926;
            // ---------- Original Method ----------
            //return c.retainAll(c1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.641 -0400", hash_original_method = "C75B179C04D460F62AB7F39D0D292067", hash_generated_method = "A8F69290363AB2D00FEDD4A5A3BF8CF2")
        @Override
        public void clear() {
            c.clear();
            // ---------- Original Method ----------
            //c.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.641 -0400", hash_original_method = "424D4966F358AE6553349A6493C21674", hash_generated_method = "9E625454373E15AE8A585C3B0949EC68")
        @Override
        public String toString() {
String var7F88C51BB16CD8992026056598815CC9_1724636892 =             c.toString();
            var7F88C51BB16CD8992026056598815CC9_1724636892.addTaint(taint);
            return var7F88C51BB16CD8992026056598815CC9_1724636892;
            // ---------- Original Method ----------
            //return c.toString();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.641 -0400", hash_original_field = "19984F6C6BA7815BBDF7C18EF9C975B4", hash_generated_field = "0D42B7BF026634D153E28C472B065A0D")

        private static final long serialVersionUID = 1578914078182001775L;
    }


    
    private static class CheckedListIterator<E> implements ListIterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.641 -0400", hash_original_field = "865C0C0B4AB0E063E5CAA3387C1A8741", hash_generated_field = "A3E111A0B732842F8B9E259D3903708E")

        private ListIterator<E> i;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.642 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "44DD73C068DAE541C380477699D61FAF")

        private Class<E> type;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.643 -0400", hash_original_method = "0B7AAA10EE83BBF7A614BF8D8C7A7C84", hash_generated_method = "8BB9DF0BD458C6C58CAD8ED7A978114C")
        public  CheckedListIterator(ListIterator<E> i, Class<E> type) {
            this.i = i;
            this.type = type;
            // ---------- Original Method ----------
            //this.i = i;
            //this.type = type;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.643 -0400", hash_original_method = "59CA86A80410B66286C92523CF35EC7B", hash_generated_method = "9B8BB1067FD809F7DA9C5C05F37E823C")
        @Override
        public boolean hasNext() {
            boolean varD1B5E3BB1A727F5E42DA5D458C9BD3D7_1549239579 = (i.hasNext());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1672429148 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1672429148;
            // ---------- Original Method ----------
            //return i.hasNext();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.644 -0400", hash_original_method = "A2FD0994E634C5BCE4D27AD9176E9A5A", hash_generated_method = "2C3FE6A63F617359377A413A063A2BD7")
        @Override
        public E next() {
E varF6EAB0DE2C0CB4CEE3FE4BE37522387A_1006095681 =             i.next();
            varF6EAB0DE2C0CB4CEE3FE4BE37522387A_1006095681.addTaint(taint);
            return varF6EAB0DE2C0CB4CEE3FE4BE37522387A_1006095681;
            // ---------- Original Method ----------
            //return i.next();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.644 -0400", hash_original_method = "048FA6C3E3A28865AD880AF8A3FCAE96", hash_generated_method = "598E37F558FC71BB5A0DA7BBE13EE694")
        @Override
        public void remove() {
            i.remove();
            // ---------- Original Method ----------
            //i.remove();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.644 -0400", hash_original_method = "BBFFF3658F03DC70BAED5B88BBE801F9", hash_generated_method = "79729DC14EBD678DBD364F6D9D48FCD3")
        @Override
        public boolean hasPrevious() {
            boolean var4C4BE00885D578D14F095BAF19BB3207_436787415 = (i.hasPrevious());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_112215804 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_112215804;
            // ---------- Original Method ----------
            //return i.hasPrevious();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.645 -0400", hash_original_method = "BC73D9B40C1A828CB3DD11A00CF4E28D", hash_generated_method = "13D0A45AA97C8CBEDF9A3591DB5BCE14")
        @Override
        public E previous() {
E var61117AF8F234799332538CC5E5C9E900_1844857724 =             i.previous();
            var61117AF8F234799332538CC5E5C9E900_1844857724.addTaint(taint);
            return var61117AF8F234799332538CC5E5C9E900_1844857724;
            // ---------- Original Method ----------
            //return i.previous();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.645 -0400", hash_original_method = "E41D02CE1A7D09C2351DC91043CD0C1F", hash_generated_method = "6F70FBCD3EF7B0BFA59C41B9BE55E62F")
        @Override
        public int nextIndex() {
            int var814C2FC876D21135D437F503A632B364_1716656477 = (i.nextIndex());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1543133095 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1543133095;
            // ---------- Original Method ----------
            //return i.nextIndex();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.645 -0400", hash_original_method = "F0908B37AEEE31348E4E446BDB2DC11E", hash_generated_method = "88A773E880DF4BCD1E54BD31AB6D30F4")
        @Override
        public int previousIndex() {
            int varE41ACDDE97BB93973005B931FB8EC3B0_538498321 = (i.previousIndex());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_185208009 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_185208009;
            // ---------- Original Method ----------
            //return i.previousIndex();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.646 -0400", hash_original_method = "F06067E5C50A33BA33028ACBB7E94E5C", hash_generated_method = "AEA281633F37E1B03580B196FFB0CFCE")
        @Override
        public void set(E obj) {
            addTaint(obj.getTaint());
            i.set(checkType(obj, type));
            // ---------- Original Method ----------
            //i.set(checkType(obj, type));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.646 -0400", hash_original_method = "3A7C6206CDBE5C448C8E83D10145E877", hash_generated_method = "399B84877C8BA647D446042E7B6E5BFB")
        @Override
        public void add(E obj) {
            addTaint(obj.getTaint());
            i.add(checkType(obj, type));
            // ---------- Original Method ----------
            //i.add(checkType(obj, type));
        }

        
    }


    
    private static class CheckedList<E> extends CheckedCollection<E> implements List<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.646 -0400", hash_original_field = "2DB95E8E1A9267B7A1188556B2013B33", hash_generated_field = "BA44D98E464F3917B2E777BB565BC0D3")

        List<E> l;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.647 -0400", hash_original_method = "50AAAF0EF026911FE0274184FEF9C1C3", hash_generated_method = "2DB9BC9FE1F5179D2C72A7E31D43B6BE")
        public  CheckedList(List<E> l, Class<E> type) {
            super(l, type);
            addTaint(type.getTaint());
            this.l = l;
            // ---------- Original Method ----------
            //this.l = l;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.647 -0400", hash_original_method = "8A1A291116E92C540879607029C861C6", hash_generated_method = "D1555369D83B580A53F282EFB5E148BE")
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
            boolean var4238673B8C93511BA5D32703DB38C7A5_1329196781 = (l.addAll(index, (List<E>) Arrays.asList(array)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_689261612 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_689261612;
            // ---------- Original Method ----------
            //Object[] array = c1.toArray();
            //for (Object o : array) {
                //checkType(o, type);
            //}
            //return l.addAll(index, (List<E>) Arrays.asList(array));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.648 -0400", hash_original_method = "12BB9FAB0B921E0E98205977740A217D", hash_generated_method = "F5AB804360573128D3D9F643CE73ED73")
        @Override
        public E get(int index) {
            addTaint(index);
E var0298FE27A0E002F834F5B4411219665B_1866283969 =             l.get(index);
            var0298FE27A0E002F834F5B4411219665B_1866283969.addTaint(taint);
            return var0298FE27A0E002F834F5B4411219665B_1866283969;
            // ---------- Original Method ----------
            //return l.get(index);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.648 -0400", hash_original_method = "B15A1B3ABEAB19644273A7FDAFDFF4C3", hash_generated_method = "CB5CAAED487ADB7ABB55119C6CA468D4")
        @Override
        public E set(int index, E obj) {
            addTaint(obj.getTaint());
            addTaint(index);
E var6D9000D1F8EA992EBD7004DD7A12D9D1_1807164278 =             l.set(index, checkType(obj, type));
            var6D9000D1F8EA992EBD7004DD7A12D9D1_1807164278.addTaint(taint);
            return var6D9000D1F8EA992EBD7004DD7A12D9D1_1807164278;
            // ---------- Original Method ----------
            //return l.set(index, checkType(obj, type));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.649 -0400", hash_original_method = "97AC3A6F1A8F1F91D88637C439308CAA", hash_generated_method = "36C6CB2BAFE73E5C7E33AC3DAF4D06D9")
        @Override
        public void add(int index, E obj) {
            addTaint(obj.getTaint());
            addTaint(index);
            l.add(index, checkType(obj, type));
            // ---------- Original Method ----------
            //l.add(index, checkType(obj, type));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.649 -0400", hash_original_method = "B7A754E9641B79EF3AC643C6FA162631", hash_generated_method = "9B43383182AA14049D48137BFE2DEA24")
        @Override
        public E remove(int index) {
            addTaint(index);
E varFBADEC94A2C3564C49874A24F23CA3FC_960585053 =             l.remove(index);
            varFBADEC94A2C3564C49874A24F23CA3FC_960585053.addTaint(taint);
            return varFBADEC94A2C3564C49874A24F23CA3FC_960585053;
            // ---------- Original Method ----------
            //return l.remove(index);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.649 -0400", hash_original_method = "EB95E25E6439350950712FBE2C177EC4", hash_generated_method = "2F45CDD36E39BF21063363569E1976ED")
        @Override
        public int indexOf(Object obj) {
            addTaint(obj.getTaint());
            int var1DF234A906E8BD4E44BDC0DE7EF71602_72866938 = (l.indexOf(obj));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_47732869 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_47732869;
            // ---------- Original Method ----------
            //return l.indexOf(obj);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.650 -0400", hash_original_method = "4C828EC3A9818E335BF8E9F8513B24F5", hash_generated_method = "BAEEE7E55C5A3DAF37F752489E944FEE")
        @Override
        public int lastIndexOf(Object obj) {
            addTaint(obj.getTaint());
            int varDED6B6790C09A81175529A9A7872CCBA_874743718 = (l.lastIndexOf(obj));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_234048407 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_234048407;
            // ---------- Original Method ----------
            //return l.lastIndexOf(obj);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.650 -0400", hash_original_method = "9293980ECFF31B033CDADFB0ED26EA69", hash_generated_method = "D4449BF9B8266D79C2B9729130D3EED1")
        @Override
        public ListIterator<E> listIterator() {
ListIterator<E> var82F7472176A949D32BDB07D4F238EAD8_1873520904 =             new CheckedListIterator<E>(l.listIterator(), type);
            var82F7472176A949D32BDB07D4F238EAD8_1873520904.addTaint(taint);
            return var82F7472176A949D32BDB07D4F238EAD8_1873520904;
            // ---------- Original Method ----------
            //return new CheckedListIterator<E>(l.listIterator(), type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.651 -0400", hash_original_method = "31D39D7FEEE82D7A15D00B805CB5EAA4", hash_generated_method = "E0269FE9214C39480A0CF72A0F8D22D7")
        @Override
        public ListIterator<E> listIterator(int index) {
            addTaint(index);
ListIterator<E> varA5F7F6B2E3F07D1D7E8CF79708EF7126_1176044517 =             new CheckedListIterator<E>(l.listIterator(index), type);
            varA5F7F6B2E3F07D1D7E8CF79708EF7126_1176044517.addTaint(taint);
            return varA5F7F6B2E3F07D1D7E8CF79708EF7126_1176044517;
            // ---------- Original Method ----------
            //return new CheckedListIterator<E>(l.listIterator(index), type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.651 -0400", hash_original_method = "A5E1EFD4B2650099AC132BF86B97D88F", hash_generated_method = "2A67D751349394DB31D6AAA24D90263A")
        @Override
        public List<E> subList(int fromIndex, int toIndex) {
            addTaint(toIndex);
            addTaint(fromIndex);
List<E> var2F79FD966A1897206BC3D3B193AFC354_522433253 =             checkedList(l.subList(fromIndex, toIndex), type);
            var2F79FD966A1897206BC3D3B193AFC354_522433253.addTaint(taint);
            return var2F79FD966A1897206BC3D3B193AFC354_522433253;
            // ---------- Original Method ----------
            //return checkedList(l.subList(fromIndex, toIndex), type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.651 -0400", hash_original_method = "A14AE2E014BAD465F594EE49A5008ED4", hash_generated_method = "8C619BCB2FF87239A90D02BEEC36F4CA")
        @Override
        public boolean equals(Object obj) {
            addTaint(obj.getTaint());
            boolean var58A0CE9E62AE918ABE48926E1C3EC3CC_10865747 = (l.equals(obj));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_993558323 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_993558323;
            // ---------- Original Method ----------
            //return l.equals(obj);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.652 -0400", hash_original_method = "410D1D1B2E05F678DF3AB7D6BB08AEDB", hash_generated_method = "3D962B1FA602A1EEF29D02F0F10701A2")
        @Override
        public int hashCode() {
            int var788FADE1ADA4414CD1C28D2471298E4A_669159035 = (l.hashCode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1619388709 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1619388709;
            // ---------- Original Method ----------
            //return l.hashCode();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.652 -0400", hash_original_field = "39F320D681E769EFF91E942BCC4C3E88", hash_generated_field = "872FF792DF349B762724C98686FE9FD7")

        private static final long serialVersionUID = 65247728283967356L;
    }


    
    private static class CheckedRandomAccessList<E> extends CheckedList<E> implements RandomAccess {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.652 -0400", hash_original_method = "77F175BCE2CEB5DECA5010A8855616A0", hash_generated_method = "DF70C138E9F4C5B1C1B4E34447142B86")
        public  CheckedRandomAccessList(List<E> l, Class<E> type) {
            super(l, type);
            addTaint(type.getTaint());
            addTaint(l.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.652 -0400", hash_original_field = "27B375DBE9246C47DAC482882EF8DD4B", hash_generated_field = "AE05DA4DC0253A1B88798E9C56DCC885")

        private static final long serialVersionUID = 1638200125423088369L;
    }


    
    private static class CheckedSet<E> extends CheckedCollection<E> implements Set<E> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.653 -0400", hash_original_method = "515963C9B1280D5707D3A720329B0AC0", hash_generated_method = "B78CA33EC3AFE414A9F8EB7EB33EED13")
        public  CheckedSet(Set<E> s, Class<E> type) {
            super(s, type);
            addTaint(type.getTaint());
            addTaint(s.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.653 -0400", hash_original_method = "F33AC6E694EC5A5F3A81FF749707DDFC", hash_generated_method = "A2E69EE9B175CE6626F626E6452FCE4B")
        @Override
        public boolean equals(Object obj) {
            addTaint(obj.getTaint());
            boolean var1AC73A2339BEAF3F5AD62D5280A99B42_1880924029 = (c.equals(obj));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_671624276 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_671624276;
            // ---------- Original Method ----------
            //return c.equals(obj);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.654 -0400", hash_original_method = "E858D80F3EEDE9F2B52CDB7DA7FBF12B", hash_generated_method = "1B9F11DDA975381778BD13F962E26CF4")
        @Override
        public int hashCode() {
            int var3FFC490E9FA1D410CC240764C2B77761_410943721 = (c.hashCode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_727277296 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_727277296;
            // ---------- Original Method ----------
            //return c.hashCode();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.654 -0400", hash_original_field = "C306DCFF324211BB06F1EDC3B62DB01C", hash_generated_field = "E1E04526085CC70B98A324ECDFB31198")

        private static final long serialVersionUID = 4694047833775013803L;
    }


    
    private static class CheckedMap<K, V> implements Map<K, V>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.654 -0400", hash_original_field = "6F8F57715090DA2632453988D9A1501B", hash_generated_field = "B770F05C5A3A992B6F65D731F667A79E")

        Map<K, V> m;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.655 -0400", hash_original_field = "056E0360B75D77ECE0AE955FE59BF15D", hash_generated_field = "F010784A251FB129AC47F47773283FBF")

        Class<K> keyType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.655 -0400", hash_original_field = "B96763B95160CC0943BE0DE4743A115B", hash_generated_field = "DE39CA4821E18DB5E7A7F09BBC028CB4")

        Class<V> valueType;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.656 -0400", hash_original_method = "906A4960963B0F972E50BE617CA562B3", hash_generated_method = "696EB3F84B95F1278522163C5421F2ED")
        private  CheckedMap(Map<K, V> m, Class<K> keyType, Class<V> valueType) {
    if(m == null || keyType == null || valueType == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1125527822 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1125527822.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1125527822;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.656 -0400", hash_original_method = "A04EE09DEB6F21FAA6A7E10DF6401CD1", hash_generated_method = "2FE5B3B915BF0D06D5C5041FCC3734E7")
        @Override
        public int size() {
            int var313B2D1C305A713CA398B12007C9967C_579619828 = (m.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_151625371 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_151625371;
            // ---------- Original Method ----------
            //return m.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.657 -0400", hash_original_method = "B9E63D3C52241E7E917CB1416ABA36E5", hash_generated_method = "E7508A8AC6D241BA7E20C677F68EB3BC")
        @Override
        public boolean isEmpty() {
            boolean var6FFDB0B6EFF2802DEEBD39B93137FE90_1076460241 = (m.isEmpty());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1836812100 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1836812100;
            // ---------- Original Method ----------
            //return m.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.657 -0400", hash_original_method = "A6C730848D8A626F99D8229EE744E3C0", hash_generated_method = "34AD1F342E1BC482776C807FC8F869A1")
        @Override
        public boolean containsKey(Object key) {
            addTaint(key.getTaint());
            boolean var62AFCABB34FB6B56AC689F51EB3A9E27_484893589 = (m.containsKey(key));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1987017622 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1987017622;
            // ---------- Original Method ----------
            //return m.containsKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.657 -0400", hash_original_method = "EF8C00CF950E8C186D2F05E1E556F384", hash_generated_method = "3605E8874C79AF36AD304E1FE4E94C4E")
        @Override
        public boolean containsValue(Object value) {
            addTaint(value.getTaint());
            boolean varD6C1BCF4353E9D47F21CF5A12A4A7A3C_1130849187 = (m.containsValue(value));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1508755361 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1508755361;
            // ---------- Original Method ----------
            //return m.containsValue(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.658 -0400", hash_original_method = "B8FE254B61C57EC3A6DCE539976DA268", hash_generated_method = "24C1D5A34165C0F3937B2416FF3AA67E")
        @Override
        public V get(Object key) {
            addTaint(key.getTaint());
V var3A7E11B6611BEAA522E24ED974C59715_715151067 =             m.get(key);
            var3A7E11B6611BEAA522E24ED974C59715_715151067.addTaint(taint);
            return var3A7E11B6611BEAA522E24ED974C59715_715151067;
            // ---------- Original Method ----------
            //return m.get(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.659 -0400", hash_original_method = "98010DFF1DD51631676FCAC604C1B694", hash_generated_method = "DAF0EC0221E29F904E239AFB139F8CC6")
        @Override
        public V put(K key, V value) {
            addTaint(value.getTaint());
            addTaint(key.getTaint());
V var4AD7AACB83E31077B624E290B9EC9824_2139797273 =             m.put(checkType(key, keyType), checkType(value, valueType));
            var4AD7AACB83E31077B624E290B9EC9824_2139797273.addTaint(taint);
            return var4AD7AACB83E31077B624E290B9EC9824_2139797273;
            // ---------- Original Method ----------
            //return m.put(checkType(key, keyType), checkType(value, valueType));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.659 -0400", hash_original_method = "7E1C4ABAB7F4D30C9FA02B8AC4206202", hash_generated_method = "C9CE89DF0F82E6FE8FC5391E97E30D35")
        @Override
        public V remove(Object key) {
            addTaint(key.getTaint());
V varCFC4EE21887DEF986B37EBC86595687F_1938727949 =             m.remove(key);
            varCFC4EE21887DEF986B37EBC86595687F_1938727949.addTaint(taint);
            return varCFC4EE21887DEF986B37EBC86595687F_1938727949;
            // ---------- Original Method ----------
            //return m.remove(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.660 -0400", hash_original_method = "7B09FD67E4091CD76439ADACD213D3A2", hash_generated_method = "C0C9186DFE1DC4E3DD7726A7883CEDD3")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.661 -0400", hash_original_method = "5163CA2ED3AD9C66F2BDAFB902590115", hash_generated_method = "5C1448B76AB003BA7ABB7E55C1011B37")
        @Override
        public void clear() {
            m.clear();
            // ---------- Original Method ----------
            //m.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.661 -0400", hash_original_method = "BC85ABF91A39D98F3F2ED0838950D9FC", hash_generated_method = "29721FB9C3FAF15D6844501295B043A4")
        @Override
        public Set<K> keySet() {
Set<K> var578A3E6F6455D1AAB4084B95C8582C2B_1684958895 =             m.keySet();
            var578A3E6F6455D1AAB4084B95C8582C2B_1684958895.addTaint(taint);
            return var578A3E6F6455D1AAB4084B95C8582C2B_1684958895;
            // ---------- Original Method ----------
            //return m.keySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.662 -0400", hash_original_method = "F6584059741E2818D171714370ED56BF", hash_generated_method = "12231FBFB1D5A87274DE53B213E5FBAF")
        @Override
        public Collection<V> values() {
Collection<V> var2300BDADCFD3189CDACD154819BF8B6C_1932800260 =             m.values();
            var2300BDADCFD3189CDACD154819BF8B6C_1932800260.addTaint(taint);
            return var2300BDADCFD3189CDACD154819BF8B6C_1932800260;
            // ---------- Original Method ----------
            //return m.values();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.662 -0400", hash_original_method = "17C87BFAA3247941C0F3FE3FCE6C8B6B", hash_generated_method = "64D926B18F931D0DD6837BE200466C6A")
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
Set<Map.Entry<K, V>> varD2661C1B5438601B728B1367B701D81C_1693604762 =             new CheckedEntrySet<K, V>(m.entrySet(), valueType);
            varD2661C1B5438601B728B1367B701D81C_1693604762.addTaint(taint);
            return varD2661C1B5438601B728B1367B701D81C_1693604762;
            // ---------- Original Method ----------
            //return new CheckedEntrySet<K, V>(m.entrySet(), valueType);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.663 -0400", hash_original_method = "5F45CB6F19E1E41DEEA3711399B994B8", hash_generated_method = "F46F00A408BF6D025C8002D026AF34C8")
        @Override
        public boolean equals(Object obj) {
            addTaint(obj.getTaint());
            boolean var800A7413EE12EF72F29B87C30CEE3C80_398915347 = (m.equals(obj));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_974065215 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_974065215;
            // ---------- Original Method ----------
            //return m.equals(obj);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.663 -0400", hash_original_method = "E3229E3389F030DD50B79734943DB788", hash_generated_method = "A8CF392BC0F543F732A5383611CC70DA")
        @Override
        public int hashCode() {
            int varE3BA1212D08FEDD275814D3960FD8F10_1300591696 = (m.hashCode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_790930536 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_790930536;
            // ---------- Original Method ----------
            //return m.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.664 -0400", hash_original_method = "5DD44B3CD2826BF39F974F66579CF74F", hash_generated_method = "E1C5123E3757F1D66A928BB58872E622")
        @Override
        public String toString() {
String var8389EA5D3F4E9FD19F68E63143EE799F_554042366 =             m.toString();
            var8389EA5D3F4E9FD19F68E63143EE799F_554042366.addTaint(taint);
            return var8389EA5D3F4E9FD19F68E63143EE799F_554042366;
            // ---------- Original Method ----------
            //return m.toString();
        }

        
        private static class CheckedEntry<K, V> implements Map.Entry<K, V> {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.664 -0400", hash_original_field = "E1671797C52E15F763380B45E841EC32", hash_generated_field = "FD10A3858A638ACB828326F81BE2C88B")

            Map.Entry<K, V> e;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.664 -0400", hash_original_field = "B96763B95160CC0943BE0DE4743A115B", hash_generated_field = "DE39CA4821E18DB5E7A7F09BBC028CB4")

            Class<V> valueType;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.665 -0400", hash_original_method = "7A5E92C112A4AAE1EEB574291E4B57B6", hash_generated_method = "4C86C6ED204900ACC531955934712775")
            public  CheckedEntry(Map.Entry<K, V> e, Class<V> valueType) {
    if(e == null)                
                {
                    NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_900705025 = new NullPointerException();
                    var7338BC9F48D81FE0BBD6183F4014DCC4_900705025.addTaint(taint);
                    throw var7338BC9F48D81FE0BBD6183F4014DCC4_900705025;
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.666 -0400", hash_original_method = "10D87C621F2656D3DA7DCE234A4C3FAC", hash_generated_method = "C05808A55AA4BCD55C0B8023A07A57DD")
            @Override
            public K getKey() {
K var9A71CD5F5DA92B60FFE52FF2C8232978_1331820971 =                 e.getKey();
                var9A71CD5F5DA92B60FFE52FF2C8232978_1331820971.addTaint(taint);
                return var9A71CD5F5DA92B60FFE52FF2C8232978_1331820971;
                // ---------- Original Method ----------
                //return e.getKey();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.666 -0400", hash_original_method = "8EF21B2292AA31AAE181B3282F3F0262", hash_generated_method = "957D786D6FFE5C6BA2C7A279A93E1454")
            @Override
            public V getValue() {
V varF257B8DB7DC59DBA8001AC54A776DE14_362183688 =                 e.getValue();
                varF257B8DB7DC59DBA8001AC54A776DE14_362183688.addTaint(taint);
                return varF257B8DB7DC59DBA8001AC54A776DE14_362183688;
                // ---------- Original Method ----------
                //return e.getValue();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.667 -0400", hash_original_method = "22C63BC622BE9DF4D2BED624BDB5B6B5", hash_generated_method = "B3630A5A64A0A559E17726FBB75E3000")
            @Override
            public V setValue(V obj) {
                addTaint(obj.getTaint());
V varA3C903465E9D2940193740B105ECB684_642922001 =                 e.setValue(checkType(obj, valueType));
                varA3C903465E9D2940193740B105ECB684_642922001.addTaint(taint);
                return varA3C903465E9D2940193740B105ECB684_642922001;
                // ---------- Original Method ----------
                //return e.setValue(checkType(obj, valueType));
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.667 -0400", hash_original_method = "0FE63D6CB37B8BF21266876509A7EAAA", hash_generated_method = "52C57644C58208E46E49327ACE35F80E")
            @Override
            public boolean equals(Object obj) {
                addTaint(obj.getTaint());
                boolean var0AE554311CD88A874F347078934E2E0A_2115792273 = (e.equals(obj));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_314750346 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_314750346;
                // ---------- Original Method ----------
                //return e.equals(obj);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.668 -0400", hash_original_method = "02C3AF7FB3CFA22B693B83D22D208AF4", hash_generated_method = "96086E3782AB0CEAD4DCBB90BF4C2244")
            @Override
            public int hashCode() {
                int var1A2E54A5FA8DEA36886F410DCF59F5B3_1918636719 = (e.hashCode());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_295439681 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_295439681;
                // ---------- Original Method ----------
                //return e.hashCode();
            }

            
        }


        
        private static class CheckedEntrySet<K, V> implements Set<Map.Entry<K, V>> {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.668 -0400", hash_original_field = "03C7C0ACE395D80182DB07AE2C30F034", hash_generated_field = "00162E30A8FD9ACC3B5664D702737B9D")

            Set<Map.Entry<K, V>> s;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.668 -0400", hash_original_field = "B96763B95160CC0943BE0DE4743A115B", hash_generated_field = "DE39CA4821E18DB5E7A7F09BBC028CB4")

            Class<V> valueType;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.669 -0400", hash_original_method = "77FA7326B6BB5621E7FE63699FC58F08", hash_generated_method = "B92FFB70DAF3A02ECD73F8C030E830C0")
            public  CheckedEntrySet(Set<Map.Entry<K, V>> s, Class<V> valueType) {
                this.s = s;
                this.valueType = valueType;
                // ---------- Original Method ----------
                //this.s = s;
                //this.valueType = valueType;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.670 -0400", hash_original_method = "448F3F9279BA75C161BF1A7F97E105A4", hash_generated_method = "93BC4BF27B3A74A77908DF79AA410DE9")
            @Override
            public Iterator<Map.Entry<K, V>> iterator() {
Iterator<Map.Entry<K, V>> var1CE93D03EC65B81E876F3306781A9757_413181358 =                 new CheckedEntryIterator<K, V>(s.iterator(), valueType);
                var1CE93D03EC65B81E876F3306781A9757_413181358.addTaint(taint);
                return var1CE93D03EC65B81E876F3306781A9757_413181358;
                // ---------- Original Method ----------
                //return new CheckedEntryIterator<K, V>(s.iterator(), valueType);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.670 -0400", hash_original_method = "0FB4B292E50A952F877CB518E0A96CF9", hash_generated_method = "58727B90A067D03A428A2BF1762C4A70")
            @Override
            public Object[] toArray() {
                int thisSize = size();
                Object[] array = new Object[thisSize];
                Iterator<?> it = iterator();
for(int i = 0;i < thisSize;i++)
                {
                    array[i] = it.next();
                } //End block
Object[] var1270D5B74B756F17D644A15D775499D9_1222639663 =                 array;
                var1270D5B74B756F17D644A15D775499D9_1222639663.addTaint(taint);
                return var1270D5B74B756F17D644A15D775499D9_1222639663;
                // ---------- Original Method ----------
                //int thisSize = size();
                //Object[] array = new Object[thisSize];
                //Iterator<?> it = iterator();
                //for (int i = 0; i < thisSize; i++) {
                    //array[i] = it.next();
                //}
                //return array;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.672 -0400", hash_original_method = "C1CA1F6CAFA571422DF3592838D87C35", hash_generated_method = "C48F3EA7BD3C8FBEEB439B0B9CAC26CE")
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
T[] var1270D5B74B756F17D644A15D775499D9_1562357952 =                 array;
                var1270D5B74B756F17D644A15D775499D9_1562357952.addTaint(taint);
                return var1270D5B74B756F17D644A15D775499D9_1562357952;
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.673 -0400", hash_original_method = "C32F0C36534158E273107417143214BD", hash_generated_method = "50D0491DD9DD1336B39D8888F3D1CA61")
            @Override
            public boolean retainAll(Collection<?> c) {
                addTaint(c.getTaint());
                boolean varAF54F6E00DC3C23801B63586C3FA5E53_11518205 = (s.retainAll(c));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_666105632 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_666105632;
                // ---------- Original Method ----------
                //return s.retainAll(c);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.674 -0400", hash_original_method = "B2624C46EA911C8D7CBCD3DB1975A601", hash_generated_method = "08F53BCC7FA5D58A1788397057E97D97")
            @Override
            public boolean removeAll(Collection<?> c) {
                addTaint(c.getTaint());
                boolean var342F761313C1D4EC5227ECBC3623923F_1928618454 = (s.removeAll(c));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_975982664 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_975982664;
                // ---------- Original Method ----------
                //return s.removeAll(c);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.674 -0400", hash_original_method = "D8F4D306F45D40205BDE17116DDFF9FA", hash_generated_method = "8678F68C6B3C30FC41E2721D0AEBE899")
            @Override
            public boolean containsAll(Collection<?> c) {
                addTaint(c.getTaint());
                boolean var58784A4FF377404278CAB1E899E3C954_1629888543 = (s.containsAll(c));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1008478732 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1008478732;
                // ---------- Original Method ----------
                //return s.containsAll(c);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.675 -0400", hash_original_method = "0D1A7F281A8819D32245C163B79E338D", hash_generated_method = "25469515A1F6899C8F6A7F4F88A3F27B")
            @Override
            public boolean addAll(Collection<? extends Map.Entry<K, V>> c) {
                addTaint(c.getTaint());
                UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_553930018 = new UnsupportedOperationException();
                var81FA7E299EEE7F062EBFBEEF08B0464D_553930018.addTaint(taint);
                throw var81FA7E299EEE7F062EBFBEEF08B0464D_553930018;
                // ---------- Original Method ----------
                //throw new UnsupportedOperationException();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.675 -0400", hash_original_method = "46F35AD7CAD80E45E374449F130E7D0D", hash_generated_method = "622E9BB2F6F0255B6EC6D0018F9BC37D")
            @Override
            public boolean remove(Object o) {
                addTaint(o.getTaint());
                boolean var6EA654AFD4548B7464E002E122EAB6C2_39685260 = (s.remove(o));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_912462518 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_912462518;
                // ---------- Original Method ----------
                //return s.remove(o);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.676 -0400", hash_original_method = "A91421BB58ED7F6569B24AAD1B5804AB", hash_generated_method = "E450969E4C13B6DF5A75801179AB8311")
            @Override
            public boolean contains(Object o) {
                addTaint(o.getTaint());
                boolean var422BEDB344BEE464C285B83189BC45C7_1039374822 = (s.contains(o));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1116809003 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1116809003;
                // ---------- Original Method ----------
                //return s.contains(o);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.676 -0400", hash_original_method = "8704A9C8AC3AA02909B00E4E211C4D3E", hash_generated_method = "07C36C6D9B4FA3EC8CC74995EE227E04")
            @Override
            public boolean add(Map.Entry<K, V> o) {
                addTaint(o.getTaint());
                UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1226694723 = new UnsupportedOperationException();
                var81FA7E299EEE7F062EBFBEEF08B0464D_1226694723.addTaint(taint);
                throw var81FA7E299EEE7F062EBFBEEF08B0464D_1226694723;
                // ---------- Original Method ----------
                //throw new UnsupportedOperationException();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.677 -0400", hash_original_method = "1DB64DC7E3E98DAB777752CA6247DAE5", hash_generated_method = "2DFE418A4A9BB302ABFE30B04E7540D7")
            @Override
            public boolean isEmpty() {
                boolean var40AB6CA90C65F09F18D0FDE3E5969584_407722602 = (s.isEmpty());
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1057067663 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1057067663;
                // ---------- Original Method ----------
                //return s.isEmpty();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.677 -0400", hash_original_method = "3294D1F2516BD356F42ED84BE178EFCB", hash_generated_method = "8CAFCFFD1A3B734527CE3A6B8BDDA468")
            @Override
            public void clear() {
                s.clear();
                // ---------- Original Method ----------
                //s.clear();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.678 -0400", hash_original_method = "61480F19A13469EF561F92E5A3700C23", hash_generated_method = "6974D714583868FA801E709F0FAFBFB4")
            @Override
            public int size() {
                int varE9580031F3474F849262EB0A79D5C25A_782435236 = (s.size());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_327972357 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_327972357;
                // ---------- Original Method ----------
                //return s.size();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.678 -0400", hash_original_method = "150ADDC982A3B6D8A573E663C38A7C9E", hash_generated_method = "BA36193143C42BA241AE2E2F9880F6E9")
            @Override
            public int hashCode() {
                int var4C8AC03F4D998D80C4FDFCF9D8EE7706_480611699 = (s.hashCode());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1727417780 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1727417780;
                // ---------- Original Method ----------
                //return s.hashCode();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.679 -0400", hash_original_method = "2565EBD5FCFC00F10C086CB36B3EEE8C", hash_generated_method = "C61ABEA9A0645307B1184FAD373AE366")
            @Override
            public boolean equals(Object object) {
                addTaint(object.getTaint());
                boolean varAF04D4835E7DD6BFE03DE76B7678DB28_462066611 = (s.equals(object));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2102600480 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2102600480;
                // ---------- Original Method ----------
                //return s.equals(object);
            }

            
            private static class CheckedEntryIterator<K, V> implements Iterator<Map.Entry<K, V>> {
                @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.679 -0400", hash_original_field = "865C0C0B4AB0E063E5CAA3387C1A8741", hash_generated_field = "0B0E1D6BACD1F756FB2A478A3878B968")

                Iterator<Map.Entry<K, V>> i;
                @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.679 -0400", hash_original_field = "B96763B95160CC0943BE0DE4743A115B", hash_generated_field = "DE39CA4821E18DB5E7A7F09BBC028CB4")

                Class<V> valueType;
                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.680 -0400", hash_original_method = "3CE5E36A95DFE16D33C2CC4176CB7EE4", hash_generated_method = "A4AE63E616DC64A732B8C1B01DFD5833")
                public  CheckedEntryIterator(Iterator<Map.Entry<K, V>> i,
                        Class<V> valueType) {
                    this.i = i;
                    this.valueType = valueType;
                    // ---------- Original Method ----------
                    //this.i = i;
                    //this.valueType = valueType;
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.680 -0400", hash_original_method = "59CA86A80410B66286C92523CF35EC7B", hash_generated_method = "196ACBC10DBF2E203A26CEB7020D8B98")
                @Override
                public boolean hasNext() {
                    boolean varD1B5E3BB1A727F5E42DA5D458C9BD3D7_484190150 = (i.hasNext());
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1315931154 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1315931154;
                    // ---------- Original Method ----------
                    //return i.hasNext();
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.681 -0400", hash_original_method = "048FA6C3E3A28865AD880AF8A3FCAE96", hash_generated_method = "598E37F558FC71BB5A0DA7BBE13EE694")
                @Override
                public void remove() {
                    i.remove();
                    // ---------- Original Method ----------
                    //i.remove();
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.681 -0400", hash_original_method = "4D16E0BB01C90351B8312D1A4B7DB5F2", hash_generated_method = "BFA477A2477B3938B62D25CB2106C039")
                @Override
                public Map.Entry<K, V> next() {
Map.Entry<K, V> var748211921A39127C7457517172B3D64F_1803411833 =                     new CheckedEntry<K, V>(i.next(), valueType);
                    var748211921A39127C7457517172B3D64F_1803411833.addTaint(taint);
                    return var748211921A39127C7457517172B3D64F_1803411833;
                    // ---------- Original Method ----------
                    //return new CheckedEntry<K, V>(i.next(), valueType);
                }

                
            }


            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.682 -0400", hash_original_field = "3AB92C151F5D124E5C475918FE5C2CE3", hash_generated_field = "9F44A98BA336AC9320984E43122649C3")

        private static final long serialVersionUID = 5742860141034234728L;
    }


    
    private static class CheckedSortedSet<E> extends CheckedSet<E> implements SortedSet<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.682 -0400", hash_original_field = "3691308F2A4C2F6983F2880D32E29C84", hash_generated_field = "5220A6F2AA4CB98BB6C290F0BB717E86")

        private SortedSet<E> ss;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.683 -0400", hash_original_method = "70499BD9B05065D265D741875DD058CA", hash_generated_method = "E0CB6B46CEED761E7FB456CA464AE231")
        public  CheckedSortedSet(SortedSet<E> s, Class<E> type) {
            super(s, type);
            addTaint(type.getTaint());
            this.ss = s;
            // ---------- Original Method ----------
            //this.ss = s;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.683 -0400", hash_original_method = "8514D9255D678B041F55D03BA11DCA3B", hash_generated_method = "47862D6A263E9E16F4B4BF5746D6AC9C")
        @Override
        public Comparator<? super E> comparator() {
Comparator<? super E> varEF7DDB49085F2DA083783C6BC3481D0B_198997341 =             ss.comparator();
            varEF7DDB49085F2DA083783C6BC3481D0B_198997341.addTaint(taint);
            return varEF7DDB49085F2DA083783C6BC3481D0B_198997341;
            // ---------- Original Method ----------
            //return ss.comparator();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.684 -0400", hash_original_method = "82539AB1166DFBB28D0E3DC3D0A43121", hash_generated_method = "0E455EEC1AD0C03F284940E981BDC753")
        @Override
        public SortedSet<E> subSet(E fromElement, E toElement) {
            addTaint(toElement.getTaint());
            addTaint(fromElement.getTaint());
SortedSet<E> var39AA1D247C1203BB17C04F0195F66299_1650162520 =             new CheckedSortedSet<E>(ss.subSet(fromElement, toElement),
                    type);
            var39AA1D247C1203BB17C04F0195F66299_1650162520.addTaint(taint);
            return var39AA1D247C1203BB17C04F0195F66299_1650162520;
            // ---------- Original Method ----------
            //return new CheckedSortedSet<E>(ss.subSet(fromElement, toElement),
                    //type);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.684 -0400", hash_original_method = "68D546866615C37E07B8E968E3813E84", hash_generated_method = "4ADA22544083D9E7AC72DDD3FE00D888")
        @Override
        public SortedSet<E> headSet(E toElement) {
            addTaint(toElement.getTaint());
SortedSet<E> var1D39AA96765B31B89807B0D278A7743C_759193821 =             new CheckedSortedSet<E>(ss.headSet(toElement), type);
            var1D39AA96765B31B89807B0D278A7743C_759193821.addTaint(taint);
            return var1D39AA96765B31B89807B0D278A7743C_759193821;
            // ---------- Original Method ----------
            //return new CheckedSortedSet<E>(ss.headSet(toElement), type);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.685 -0400", hash_original_method = "B0B4B667BF95B9D9A3CD3F7FE8BEFA1B", hash_generated_method = "7ACD1C4D1E13428E519EC0A8BE07DE24")
        @Override
        public SortedSet<E> tailSet(E fromElement) {
            addTaint(fromElement.getTaint());
SortedSet<E> var695EA00B3C338D4293284A5AE68D1604_2009076493 =             new CheckedSortedSet<E>(ss.tailSet(fromElement), type);
            var695EA00B3C338D4293284A5AE68D1604_2009076493.addTaint(taint);
            return var695EA00B3C338D4293284A5AE68D1604_2009076493;
            // ---------- Original Method ----------
            //return new CheckedSortedSet<E>(ss.tailSet(fromElement), type);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.685 -0400", hash_original_method = "6BB6C51843B41CC0DCB5509A79DBA008", hash_generated_method = "B9B71FD711FF0AA7399A2E4AF554146D")
        @Override
        public E first() {
E varE64C384BCBD0BF9F8BB2385886B7C815_2066295321 =             ss.first();
            varE64C384BCBD0BF9F8BB2385886B7C815_2066295321.addTaint(taint);
            return varE64C384BCBD0BF9F8BB2385886B7C815_2066295321;
            // ---------- Original Method ----------
            //return ss.first();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.686 -0400", hash_original_method = "AAC5DDE787ACA85752B94AAB77F6B0F8", hash_generated_method = "197E53D80E80DD073B8561ACF8E3A3C4")
        @Override
        public E last() {
E var7A1B325A772301476E34C1CFA8ED9C89_328321648 =             ss.last();
            var7A1B325A772301476E34C1CFA8ED9C89_328321648.addTaint(taint);
            return var7A1B325A772301476E34C1CFA8ED9C89_328321648;
            // ---------- Original Method ----------
            //return ss.last();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.686 -0400", hash_original_field = "45BA83A718F7437B80255AD942C73A67", hash_generated_field = "EFEBE119B7009CBFA7ED7A5DC59F8042")

        private static final long serialVersionUID = 1599911165492914959L;
    }


    
    private static class CheckedSortedMap<K, V> extends CheckedMap<K, V> implements SortedMap<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.686 -0400", hash_original_field = "ED79ACB0CD3D7F8320C53C7798335EF0", hash_generated_field = "41E5EF207399B1082121011C1EB446FF")

        SortedMap<K, V> sm;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.687 -0400", hash_original_method = "2CB6EA0E6447E5AAF8B28B5FDF140BE4", hash_generated_method = "BA56DA0EAD27E7AF04AC58C9B976F523")
          CheckedSortedMap(SortedMap<K, V> m, Class<K> keyType, Class<V> valueType) {
            super(m, keyType, valueType);
            addTaint(valueType.getTaint());
            addTaint(keyType.getTaint());
            this.sm = m;
            // ---------- Original Method ----------
            //this.sm = m;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.687 -0400", hash_original_method = "E5FDBCC6560BE7E99B2D2F850BD84149", hash_generated_method = "755B16B18F19777DAF1AA56D8AADCCC2")
        @Override
        public Comparator<? super K> comparator() {
Comparator<? super K> varEAAD6156DF3FBB0DB169CF3701FE5DAA_1122529191 =             sm.comparator();
            varEAAD6156DF3FBB0DB169CF3701FE5DAA_1122529191.addTaint(taint);
            return varEAAD6156DF3FBB0DB169CF3701FE5DAA_1122529191;
            // ---------- Original Method ----------
            //return sm.comparator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.688 -0400", hash_original_method = "65DE11E398BB209CD2689071C041161A", hash_generated_method = "40E3640A3C3354F587AC87F5D414998C")
        @Override
        public SortedMap<K, V> subMap(K fromKey, K toKey) {
            addTaint(toKey.getTaint());
            addTaint(fromKey.getTaint());
SortedMap<K, V> varA3CD70A724558DE3D9382CE6CF4CCBAF_231850922 =             new CheckedSortedMap<K, V>(sm.subMap(fromKey, toKey), keyType, valueType);
            varA3CD70A724558DE3D9382CE6CF4CCBAF_231850922.addTaint(taint);
            return varA3CD70A724558DE3D9382CE6CF4CCBAF_231850922;
            // ---------- Original Method ----------
            //return new CheckedSortedMap<K, V>(sm.subMap(fromKey, toKey), keyType, valueType);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.688 -0400", hash_original_method = "2C5724B582D2FAB5716323DB894A671D", hash_generated_method = "5D3B474D117638E5DB01CF71C3D55A46")
        @Override
        public SortedMap<K, V> headMap(K toKey) {
            addTaint(toKey.getTaint());
SortedMap<K, V> var6CAD4B9D7CCF5B6A99FE852125447B2A_1180474924 =             new CheckedSortedMap<K, V>(sm.headMap(toKey), keyType, valueType);
            var6CAD4B9D7CCF5B6A99FE852125447B2A_1180474924.addTaint(taint);
            return var6CAD4B9D7CCF5B6A99FE852125447B2A_1180474924;
            // ---------- Original Method ----------
            //return new CheckedSortedMap<K, V>(sm.headMap(toKey), keyType, valueType);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.689 -0400", hash_original_method = "2879524DD09B17D2FCB7AD1626D24618", hash_generated_method = "4FE0A641D063D91F6F89BF4192EA306B")
        @Override
        public SortedMap<K, V> tailMap(K fromKey) {
            addTaint(fromKey.getTaint());
SortedMap<K, V> var9E2A7B6D989F59E06621CB44A1A3AFE0_1562550461 =             new CheckedSortedMap<K, V>(sm.tailMap(fromKey), keyType, valueType);
            var9E2A7B6D989F59E06621CB44A1A3AFE0_1562550461.addTaint(taint);
            return var9E2A7B6D989F59E06621CB44A1A3AFE0_1562550461;
            // ---------- Original Method ----------
            //return new CheckedSortedMap<K, V>(sm.tailMap(fromKey), keyType, valueType);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.689 -0400", hash_original_method = "B25E8C7440C76FBF812FF7AC9CA9D776", hash_generated_method = "9F394E4AFFB5D959A5BE8C40D6FBC7F1")
        @Override
        public K firstKey() {
K varA58D1FB276F66FC6ABBF4CA9E354FD1B_771171114 =             sm.firstKey();
            varA58D1FB276F66FC6ABBF4CA9E354FD1B_771171114.addTaint(taint);
            return varA58D1FB276F66FC6ABBF4CA9E354FD1B_771171114;
            // ---------- Original Method ----------
            //return sm.firstKey();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.690 -0400", hash_original_method = "00E9126A84DE8B71214859A17DA6BD2E", hash_generated_method = "978F6290671ADE250D32FF6EC4D2AFD9")
        @Override
        public K lastKey() {
K varC4E8101F3F71352235F4E401D4498536_901214021 =             sm.lastKey();
            varC4E8101F3F71352235F4E401D4498536_901214021.addTaint(taint);
            return varC4E8101F3F71352235F4E401D4498536_901214021;
            // ---------- Original Method ----------
            //return sm.lastKey();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.690 -0400", hash_original_field = "4011ADBAF6264DE3F59FECC188B42ACB", hash_generated_field = "48CAB95B26D6FD20C5A6CF4DE2F667C3")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.691 -0400", hash_original_field = "E5D97468931D831222F89B33B06414C4", hash_generated_field = "1967470EF0F42FDB7D6E965615F956D6")

    @SuppressWarnings("unchecked")
    public static final List EMPTY_LIST = new EmptyList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.691 -0400", hash_original_field = "19637326155AD7B58E274FC2717EADC0", hash_generated_field = "EF8031119D3626285E32D155A57C6695")

    @SuppressWarnings("unchecked")
    public static final Set EMPTY_SET = new EmptySet();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.691 -0400", hash_original_field = "712F6D9422DE94FBE0F2A8F69D9E29D0", hash_generated_field = "F465655F33C72E2E2F297BFA1010664E")

    @SuppressWarnings("unchecked")
    public static final Map EMPTY_MAP = new EmptyMap();
}

