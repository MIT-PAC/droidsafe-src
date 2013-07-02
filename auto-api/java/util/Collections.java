package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Array;

public class Collections {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.212 -0400", hash_original_method = "0C1BC548FC19EEB6A684F12763720939", hash_generated_method = "F5EC8594995493427AAF50F2EB8C349F")
    private  Collections() {
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static <E> Collection<E> checkedCollection(Collection<E> c,
            Class<E> type) {
        return new CheckedCollection<E>(c, type);
    }

    
    public static <K, V> Map<K, V> checkedMap(Map<K, V> m, Class<K> keyType,
            Class<V> valueType) {
        return new CheckedMap<K, V>(m, keyType, valueType);
    }

    
    @DSModeled(DSC.SAFE)
    public static <E> List<E> checkedList(List<E> list, Class<E> type) {
        if (list instanceof RandomAccess) {
            return new CheckedRandomAccessList<E>(list, type);
        }
        return new CheckedList<E>(list, type);
    }

    
    @DSModeled(DSC.SAFE)
    public static <E> Set<E> checkedSet(Set<E> s, Class<E> type) {
        return new CheckedSet<E>(s, type);
    }

    
    public static <K, V> SortedMap<K, V> checkedSortedMap(SortedMap<K, V> m,
            Class<K> keyType, Class<V> valueType) {
        return new CheckedSortedMap<K, V>(m, keyType, valueType);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.222 -0400", hash_original_field = "7B8B965AD4BCA0E41AB51DE7B31363A1", hash_generated_field = "01825CC32046BF0FBE11738ABC136518")

        private int n;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.222 -0400", hash_original_field = "8E2DCFD7E7E24B1CA76C1193F645902B", hash_generated_field = "93B043155067F80D0269375649E4D7D4")

        private E element;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.222 -0400", hash_original_method = "5A122D173062D06824D4571736320F87", hash_generated_method = "332F4CC6EB56BB16F20F69E656CBAAF8")
          CopiesList(int length, E object) {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } 
            n = length;
            element = object;
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.223 -0400", hash_original_method = "B07BCF81C9C48C72A08077A0468A8769", hash_generated_method = "3CB0CC38B6C9BDD4DBE27BBC0C3FF640")
        @Override
        public boolean contains(Object object) {
            {
                Object var918C716CCB523821E4DE921B4E432F42_763913383 = (element.equals(object));
            } 
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1888716542 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1888716542;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.223 -0400", hash_original_method = "61094B9B9DEC6161E82512577FAF3323", hash_generated_method = "47290649455433AA55377929B44BE5FB")
        @Override
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1089975390 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1089975390;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.223 -0400", hash_original_method = "857A70B35DA7146CF7ADC484EC4AABC8", hash_generated_method = "C64922054FC03D2AFAFD597424726D7D")
        @Override
        public E get(int location) {
            E varB4EAC82CA7396A68D541C85D26508E83_682337817 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_682337817 = element;
            } 
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            addTaint(location);
            varB4EAC82CA7396A68D541C85D26508E83_682337817.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_682337817;
            
            
                
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.223 -0400", hash_original_field = "6A61C247691E7C356BC04B2E9E793190", hash_generated_field = "2ACBEBBA06800CFC571100A6231B0F40")

        private static final long serialVersionUID = 2739099268398711800L;
    }


    
    private static final class EmptyList extends AbstractList implements RandomAccess, Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.224 -0400", hash_original_method = "BF3F11B0BCAE2AE80C7C74CBEB88EB5B", hash_generated_method = "BF3F11B0BCAE2AE80C7C74CBEB88EB5B")
        public EmptyList ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.224 -0400", hash_original_method = "38B750FD34BF6CB1144CDF020D3299E6", hash_generated_method = "CAA8C534BF5724D6DB86AD80A40C9F2D")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_857551416 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_857551416;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.224 -0400", hash_original_method = "F4586E3A64B5D10DEB709A723C85E55E", hash_generated_method = "93294E84910CE6451066E62FA427C2B0")
        @Override
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_240976322 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_240976322;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.225 -0400", hash_original_method = "F59F44D1664BC2EE59D5A9B30D144285", hash_generated_method = "A8C1E569381DF357B1DAF3DEDBCE876B")
        @Override
        public Object get(int location) {
        	throw new IndexOutOfBoundsException();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.225 -0400", hash_original_method = "3CB4CAF1EADC3F12C565BD7D2B5F5514", hash_generated_method = "751513493FE4E3A88CFAF2F2DC13C9F1")
        private Object readResolve() {
            Object varB4EAC82CA7396A68D541C85D26508E83_2127736632 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2127736632 = Collections.EMPTY_LIST;
            varB4EAC82CA7396A68D541C85D26508E83_2127736632.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2127736632;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.225 -0400", hash_original_field = "FEEABBF180D6F8A042B90CBFA55A4A94", hash_generated_field = "F94EA5528856E40DE43B84AB4D470D7D")

        private static final long serialVersionUID = 8842843931221139166L;
    }


    
    private static final class EmptySet extends AbstractSet implements Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.225 -0400", hash_original_method = "3A37381B9598D46CF46D5D53F85DF5B1", hash_generated_method = "3A37381B9598D46CF46D5D53F85DF5B1")
        public EmptySet ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.225 -0400", hash_original_method = "38B750FD34BF6CB1144CDF020D3299E6", hash_generated_method = "4848829A6123A127306B6F4B7DE5AA25")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1887178189 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1887178189;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.226 -0400", hash_original_method = "F4586E3A64B5D10DEB709A723C85E55E", hash_generated_method = "5C5175D871A2276AF188217AC151F9BD")
        @Override
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1858120857 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1858120857;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.226 -0400", hash_original_method = "FC88A4B2F50E498E162F3F7EEDE885B1", hash_generated_method = "F894A934D4AE6747FE677BE8A6363747")
        @Override
        public Iterator iterator() {
            Iterator varB4EAC82CA7396A68D541C85D26508E83_1165684304 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1165684304 = EMPTY_ITERATOR;
            varB4EAC82CA7396A68D541C85D26508E83_1165684304.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1165684304;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.227 -0400", hash_original_method = "2ED0845ADEAE5655731C197578B08F82", hash_generated_method = "617F194638134549A2927AB6F7175155")
        private Object readResolve() {
            Object varB4EAC82CA7396A68D541C85D26508E83_1033186504 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1033186504 = Collections.EMPTY_SET;
            varB4EAC82CA7396A68D541C85D26508E83_1033186504.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1033186504;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.227 -0400", hash_original_field = "EBC69A53BFBAE35613EC4BD95CB98F92", hash_generated_field = "A81D1AE03C05E931255584261EF756E0")

        private static final long serialVersionUID = 1582296315990362920L;
    }


    
    private static final class EmptyMap extends AbstractMap implements Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.227 -0400", hash_original_method = "0E8F36F90F9C751DA5A12903A16705DF", hash_generated_method = "0E8F36F90F9C751DA5A12903A16705DF")
        public EmptyMap ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.228 -0400", hash_original_method = "2AD0E7E75E88E287D6229481B74BEBCC", hash_generated_method = "1B86B19C019680F98679FFAA89BB5A66")
        @Override
        public boolean containsKey(Object key) {
            addTaint(key.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1305913657 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1305913657;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.228 -0400", hash_original_method = "9D32B6FFC088649ED5480F6E533A1288", hash_generated_method = "B2EBAD8CBFA2635E944B123D9B208298")
        @Override
        public boolean containsValue(Object value) {
            addTaint(value.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2011260687 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2011260687;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.229 -0400", hash_original_method = "709DD403C63D2F4104FF93FEEB6E3457", hash_generated_method = "5E62B0070417F90BF8E2A56B0A7DA536")
        @Override
        public Set entrySet() {
            Set varB4EAC82CA7396A68D541C85D26508E83_798627384 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_798627384 = EMPTY_SET;
            varB4EAC82CA7396A68D541C85D26508E83_798627384.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_798627384;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.231 -0400", hash_original_method = "59A1188DDD48CFFB749850DC2DA09C1D", hash_generated_method = "F65AEDD4C45E984711E7967D6113F94A")
        @Override
        public Object get(Object key) {
            Object varB4EAC82CA7396A68D541C85D26508E83_1243399973 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1243399973 = null;
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1243399973.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1243399973;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.232 -0400", hash_original_method = "266B164C16644761E32491964C192EB7", hash_generated_method = "D3610CF179AEDA55D7B69ABC580548C2")
        @Override
        public Set keySet() {
            Set varB4EAC82CA7396A68D541C85D26508E83_1251952986 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1251952986 = EMPTY_SET;
            varB4EAC82CA7396A68D541C85D26508E83_1251952986.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1251952986;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.233 -0400", hash_original_method = "745E6E226DD5F7D4E763DA74DFF70792", hash_generated_method = "EB2264F5920DE3DFA689D26DFC3B3F95")
        @Override
        public Collection values() {
            Collection varB4EAC82CA7396A68D541C85D26508E83_1039527135 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1039527135 = EMPTY_LIST;
            varB4EAC82CA7396A68D541C85D26508E83_1039527135.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1039527135;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.234 -0400", hash_original_method = "59A22E9415A338EB85D7A7DD214359CC", hash_generated_method = "FC851C04F0255359A8AC717E7FF0AFFC")
        private Object readResolve() {
            Object varB4EAC82CA7396A68D541C85D26508E83_1779672610 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1779672610 = Collections.EMPTY_MAP;
            varB4EAC82CA7396A68D541C85D26508E83_1779672610.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1779672610;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.234 -0400", hash_original_field = "71F087EB1E9FCDB60C678B95061CEBBD", hash_generated_field = "847A5C63C9A66D8A1818A774A2AADB69")

        private static final long serialVersionUID = 6428348081105594320L;
    }


    
    private static final class ReverseComparator<T> implements Comparator<T>, Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.235 -0400", hash_original_method = "FFB2FB11DBE006893CA9746ECCE68517", hash_generated_method = "FFB2FB11DBE006893CA9746ECCE68517")
        public ReverseComparator ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.235 -0400", hash_original_method = "907488F1D5625FE5C9F59ED8A7B6E697", hash_generated_method = "263AC4AC083B78DF345A19A387AF8560")
        @SuppressWarnings("unchecked")
        @Override
        public int compare(T o1, T o2) {
            Comparable<T> c2 = (Comparable<T>) o2;
            int var692167FC6770150DF2B5DF91BFB83EC2_1030148406 = (c2.compareTo(o1));
            addTaint(o1.getTaint());
            addTaint(o2.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_56858056 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_56858056;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.237 -0400", hash_original_method = "DD371F0FDF8300FDCFBD1E5C395D42BC", hash_generated_method = "A40BC7B3EE28898F1BF174528393D155")
        private Object readResolve() throws ObjectStreamException {
            Object varB4EAC82CA7396A68D541C85D26508E83_1327663248 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1327663248 = INSTANCE;
            varB4EAC82CA7396A68D541C85D26508E83_1327663248.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1327663248;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.237 -0400", hash_original_field = "2B003AD2E801398B9507D8ADBBB584A6", hash_generated_field = "28B0E21DBABF675E471021CA76588F6A")

        private static final ReverseComparator<Object> INSTANCE = new ReverseComparator<Object>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.237 -0400", hash_original_field = "844E6A53F14D8AD803480DAA1F2399E0", hash_generated_field = "410EA5184B11CE9687E932D7F263B83C")

        private static final long serialVersionUID = 7207038068494060240L;
    }


    
    private static final class ReverseComparator2<T> implements Comparator<T>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.237 -0400", hash_original_field = "31B4E550AA5FD883246F9B9CEAE82483", hash_generated_field = "ACD6D4A2528BA4BAF7406DE3D3F49FE6")

        private Comparator<T> cmp;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.238 -0400", hash_original_method = "1ABA0972F29BDB004C28A1246ABEF788", hash_generated_method = "B92E5576724AB283C109FF5B16A47456")
          ReverseComparator2(Comparator<T> comparator) {
            this.cmp = comparator;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.238 -0400", hash_original_method = "449D1B24DD0E97F4D53DEB786BD04597", hash_generated_method = "6F899FF25536A5AA9EC53EBC79DABEF3")
        @Override
        public int compare(T o1, T o2) {
            int varC3FAEC3684B290716428C4AB73BA307C_1853448285 = (cmp.compare(o2, o1));
            addTaint(o1.getTaint());
            addTaint(o2.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2063427403 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2063427403;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.238 -0400", hash_original_method = "30689CAB8FBFDCB9289EF03377EE08A0", hash_generated_method = "56B61859E26A9540793E4C41B5350085")
        @Override
        public boolean equals(Object o) {
            boolean varB42AC7AE9468AAA515C4B77EBD2F7BC7_1611692087 = (o instanceof ReverseComparator2
                    && ((ReverseComparator2) o).cmp.equals(cmp));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_417993651 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_417993651;
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.239 -0400", hash_original_method = "CAA612A5887D060562790EB1CDD1FEFE", hash_generated_method = "0E81DFA5FA970429FD416B6D6BC6E729")
        @Override
        public int hashCode() {
            int varFAD4BDCF5F08AFF151A94355744A94BB_477359803 = (~cmp.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2124816777 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2124816777;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.239 -0400", hash_original_field = "C2743FD0D0E256493E9B52C087283254", hash_generated_field = "3328170146630256C37315D4155F67EF")

        private static final long serialVersionUID = 4374092139857L;
    }


    
    private static final class SingletonSet<E> extends AbstractSet<E> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.239 -0400", hash_original_field = "8E2DCFD7E7E24B1CA76C1193F645902B", hash_generated_field = "AADC7BC67B0FB6048E4A856A581BAEE9")

        E element;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.239 -0400", hash_original_method = "044BE6981927B9234E2AE8686E07A72F", hash_generated_method = "08623BAB02DDA909B203E3610F71957D")
          SingletonSet(E object) {
            element = object;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.240 -0400", hash_original_method = "B07BCF81C9C48C72A08077A0468A8769", hash_generated_method = "8251913B2F5FE4F6EC46E6E47C418154")
        @Override
        public boolean contains(Object object) {
            {
                Object var918C716CCB523821E4DE921B4E432F42_297697879 = (element.equals(object));
            } 
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_340427870 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_340427870;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.241 -0400", hash_original_method = "798A0AE2F2A6352396904AB5C9ED97D5", hash_generated_method = "5C36BA1C0646B60B89EC4F721A97BC2B")
        @Override
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_452637818 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_452637818;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.242 -0400", hash_original_method = "135AC18A6A8AD4548E2E750F2D4C7699", hash_generated_method = "F328EA9D984BC2F67E55C7BB97E6BEE2")
        @Override
        public Iterator<E> iterator() {
            Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_1818202863 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1818202863 = new Iterator<E>() {
                boolean hasNext = true;
                @Override public boolean hasNext() {
                    return hasNext;
                }
                @Override public E next() {
                    if (hasNext) {
                        hasNext = false;
                        return element;
                    }
                    throw new NoSuchElementException();
                }
                @Override public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
            varB4EAC82CA7396A68D541C85D26508E83_1818202863.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1818202863;
            
            
                
                
                    
                
                
                    
                        
                        
                    
                    
                
                
                    
                
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.242 -0400", hash_original_field = "C80162DD8B57D34236F77D8F8A87A897", hash_generated_field = "35AF14D3D33C59E58AFC233BD942F616")

        private static final long serialVersionUID = 3193687207550431679L;
    }


    
    private static final class SingletonList<E> extends AbstractList<E> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.242 -0400", hash_original_field = "8E2DCFD7E7E24B1CA76C1193F645902B", hash_generated_field = "AADC7BC67B0FB6048E4A856A581BAEE9")

        E element;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.242 -0400", hash_original_method = "F3174A5FA7BA5962D109EAC3245F2C1D", hash_generated_method = "6BE55179558843F3290CC42091204DF4")
          SingletonList(E object) {
            element = object;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.243 -0400", hash_original_method = "B07BCF81C9C48C72A08077A0468A8769", hash_generated_method = "1DD96ABF41EC1DA93C466476B509A63A")
        @Override
        public boolean contains(Object object) {
            {
                Object var918C716CCB523821E4DE921B4E432F42_1478764029 = (element.equals(object));
            } 
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_40951602 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_40951602;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.244 -0400", hash_original_method = "1C6E7D1EB082158D5E00EA29E883A612", hash_generated_method = "BC6D621D3C79C727D4E501C60598F2BA")
        @Override
        public E get(int location) {
            E varB4EAC82CA7396A68D541C85D26508E83_1157078005 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1157078005 = element;
            } 
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            addTaint(location);
            varB4EAC82CA7396A68D541C85D26508E83_1157078005.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1157078005;
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.244 -0400", hash_original_method = "798A0AE2F2A6352396904AB5C9ED97D5", hash_generated_method = "90481713C8F997EFE1F2D244CE497577")
        @Override
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1990273998 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1990273998;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.244 -0400", hash_original_field = "136A37A5852F7DE7150E3A4BC9F06AE5", hash_generated_field = "CBFA444A21D6CBFF01F29F9591A887AB")

        private static final long serialVersionUID = 3093736618740652951L;
    }


    
    private static final class SingletonMap<K, V> extends AbstractMap<K, V> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.244 -0400", hash_original_field = "8CE4B16B22B58894AA86C421E8759DF3", hash_generated_field = "052F80594ED04BACBC2E98744BD4CC2D")

        K k;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.244 -0400", hash_original_field = "9E3669D19B675BD57058FD4664205D2A", hash_generated_field = "3A278B3CDA0FEEA24CB626A0B3136D0B")

        V v;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.244 -0400", hash_original_method = "85D3D420EE431E7A3C1CBFB71D1CEAE2", hash_generated_method = "942C300AA2E111086F3B6C3DFB936BBB")
          SingletonMap(K key, V value) {
            k = key;
            v = value;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.245 -0400", hash_original_method = "26D5E87A2C62405ADA3B15C5C8B30FEC", hash_generated_method = "0B2CD28DB551AAA35673DC88FDBED997")
        @Override
        public boolean containsKey(Object key) {
            {
                Object var0EB569FD4AF21D116A21E287F6027A39_741696919 = (k.equals(key));
            } 
            addTaint(key.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1152248690 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1152248690;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.246 -0400", hash_original_method = "827D42B4F919454EC51CA86D0E534994", hash_generated_method = "7FEFD1C4F484BAC55965D4D80CBE33DA")
        @Override
        public boolean containsValue(Object value) {
            {
                Object var1F74AE50105434A557EE1F3FD50522E7_1497306745 = (v.equals(value));
            } 
            addTaint(value.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_505769651 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_505769651;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.246 -0400", hash_original_method = "8C587096F5E6029DBB187C58CF22D158", hash_generated_method = "A1458F330B00ED9F49E0069EFB2BF26D")
        @Override
        public V get(Object key) {
            V varB4EAC82CA7396A68D541C85D26508E83_1661397214 = null; 
            V varB4EAC82CA7396A68D541C85D26508E83_1038354051 = null; 
            {
                boolean varD8EB9E9C73E773501877E01187F3B5DA_271925784 = (containsKey(key));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1661397214 = v;
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1038354051 = null;
            addTaint(key.getTaint());
            V varA7E53CE21691AB073D9660D615818899_1374282809; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1374282809 = varB4EAC82CA7396A68D541C85D26508E83_1661397214;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1374282809 = varB4EAC82CA7396A68D541C85D26508E83_1038354051;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1374282809.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1374282809;
            
            
                
            
            
        }

        
        @Override public int size() {
                    return 1;
                }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.248 -0400", hash_original_method = "AB4A6E093F1AE40B73184C21F1D08E5E", hash_generated_method = "63684733F8F79C1376CCE45B9E45BD14")
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_1025930388 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1025930388 = new AbstractSet<Map.Entry<K, V>>() {
                @Override public boolean contains(Object object) {
                    if (object instanceof Map.Entry) {
                        Map.Entry<?, ?> entry = (Map.Entry<?, ?>) object;
                        return containsKey(entry.getKey())
                                && containsValue(entry.getValue());
                    }
                    return false;
                }
                @Override public int size() {
                    return 1;
                }
                @Override public Iterator<Map.Entry<K, V>> iterator() {
                    return new Iterator<Map.Entry<K, V>>() {
                        boolean hasNext = true;
                        @Override public boolean hasNext() {
                            return hasNext;
                        }
                        @Override public Map.Entry<K, V> next() {
                            if (!hasNext) {
                                throw new NoSuchElementException();
                            }
                            hasNext = false;
                            return new MapEntry<K, V>(k, v) {
                                @Override public V setValue(V value) {
                                    throw new UnsupportedOperationException();
                                }
                            };
                        }
                        @Override public void remove() {
                            throw new UnsupportedOperationException();
                        }
                    };
                }
            };
            varB4EAC82CA7396A68D541C85D26508E83_1025930388.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1025930388;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.248 -0400", hash_original_field = "9848B8101686634CF12341A29DB1F062", hash_generated_field = "0B15CF1CC7A3921AD66781626704DE4C")

        private static final long serialVersionUID = -6979724477215052911L;        
    }


    
    static class SynchronizedCollection<E> implements Collection<E>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.248 -0400", hash_original_field = "4A8A08F09D37B73795649038408B5F33", hash_generated_field = "A3C80A7E02E49F20400373DFBAF9696A")

        Collection<E> c;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.248 -0400", hash_original_field = "25A01BB859125507013A2FE9737D3C32", hash_generated_field = "5C5F8780FECE5E612AF5A86D3A8B3194")

        Object mutex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.249 -0400", hash_original_method = "30FA7B26D2517E75155300E21A44EE02", hash_generated_method = "04BEBFE0095AFAF3C9F796F57AE0BFCE")
          SynchronizedCollection(Collection<E> collection) {
            c = collection;
            mutex = this;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.249 -0400", hash_original_method = "A2A350BD37040709EC39C6B0536AFBDE", hash_generated_method = "4B2E27EA4C4C16202811504251810751")
          SynchronizedCollection(Collection<E> collection, Object mutex) {
            c = collection;
            this.mutex = mutex;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.250 -0400", hash_original_method = "FB2AC5CD0A8119C2DE50A53F38732CDD", hash_generated_method = "0ACBA5368A8C4B1EEBCE01F061F9A3A3")
        @Override
        public boolean add(E object) {
            {
                boolean var2BB0FD33FED1B2B72867ACF06FBFC56B_2031429164 = (c.add(object));
            } 
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_815336432 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_815336432;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.250 -0400", hash_original_method = "8489E829BC0B88048B305735D46B1D99", hash_generated_method = "683607DA24D5F6EDABE2A617B7034D73")
        @Override
        public boolean addAll(Collection<? extends E> collection) {
            {
                boolean varAB7EBFBCA4F45D51E737154B11C4108B_172425195 = (c.addAll(collection));
            } 
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_769780422 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_769780422;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.251 -0400", hash_original_method = "7AE3345D011114FF0F62A8DFD7762BE2", hash_generated_method = "ED4D6B89485DB8E6E90C08ACDF15F82F")
        @Override
        public void clear() {
            {
                c.clear();
            } 
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.251 -0400", hash_original_method = "1B12503F1112F0CD581293F3A624FEFF", hash_generated_method = "5157E1C2096D5097FBA971F4702BBF67")
        @Override
        public boolean contains(Object object) {
            {
                boolean var34971DB84F983FD59B337EBDA19618A7_1056452312 = (c.contains(object));
            } 
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_875404232 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_875404232;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.251 -0400", hash_original_method = "F945FF2C907D1AA0923D46DECCCD5EAD", hash_generated_method = "3E24FDA1FBF7CB372CC7B80D3380FCBA")
        @Override
        public boolean containsAll(Collection<?> collection) {
            {
                boolean varDACCFBFB1E0F996A35B7BB8B776BF827_1180863474 = (c.containsAll(collection));
            } 
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1668171568 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1668171568;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.251 -0400", hash_original_method = "FC4F88C8FB9F4E3716AD2ABCD3101657", hash_generated_method = "EBDA278DDAA7B75EA9759C3A780AF2B3")
        @Override
        public boolean isEmpty() {
            {
                boolean var13DC031C5380F0C4DA515946E668AE17_1826423739 = (c.isEmpty());
            } 
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_584202288 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_584202288;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.252 -0400", hash_original_method = "7F1B5E60A4E4F9F3AFA65965967FBBF0", hash_generated_method = "69AA8F8318EA4857F5E02B8F22DA6EDD")
        @Override
        public Iterator<E> iterator() {
            Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_1180197213 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1180197213 = c.iterator();
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1180197213.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1180197213;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.252 -0400", hash_original_method = "C85E45E4AF074973339408E1197B653C", hash_generated_method = "D35F0BBC2D3AD8B413B04A26A7F7F7A8")
        @Override
        public boolean remove(Object object) {
            {
                boolean var8E355775017A5ED204FCCA7510D23187_677895094 = (c.remove(object));
            } 
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_698079618 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_698079618;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.252 -0400", hash_original_method = "63829008A74D54A464D81619215951F3", hash_generated_method = "FDF6052CCECB0570F6F1745D2FFF5335")
        @Override
        public boolean removeAll(Collection<?> collection) {
            {
                boolean var1464AF4DDAD9564C54B239B0335D2517_2143159450 = (c.removeAll(collection));
            } 
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_373794800 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_373794800;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.253 -0400", hash_original_method = "F83427C5B4EF86DB8198B3D2BAE482AC", hash_generated_method = "2FCF40FA75826F0B59D8F913AFC0FED2")
        @Override
        public boolean retainAll(Collection<?> collection) {
            {
                boolean varF2E46B90912EE4E31AEA6D3F646498E8_464147265 = (c.retainAll(collection));
            } 
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_198723478 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_198723478;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.253 -0400", hash_original_method = "8641BC878FB77D36CE60B1977D7C0FB5", hash_generated_method = "CD4EF7012A244430C8A27286D810B9C5")
        @Override
        public int size() {
            {
                int var0E51EFE72011B352AF314992F697E7C3_1676388184 = (c.size());
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_943761537 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_943761537;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.253 -0400", hash_original_method = "214BCEC14D5449B585926B657D8D51C2", hash_generated_method = "9B33E24F1DCE74FCA77B16C492B208B7")
        @Override
        public java.lang.Object[] toArray() {
            java.lang.Object[] varB4EAC82CA7396A68D541C85D26508E83_1200326726 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1200326726 = c.toArray();
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1200326726.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1200326726;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.254 -0400", hash_original_method = "D637F0F4C3C8C312A0597F30C1C6DB59", hash_generated_method = "E890F86CB034185CA784EB550870A504")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_2046001366 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_2046001366 = c.toString();
            } 
            varB4EAC82CA7396A68D541C85D26508E83_2046001366.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2046001366;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.254 -0400", hash_original_method = "567EED27866E99DFC1B7F8B43B648D82", hash_generated_method = "4496CDE641DF58899520F967841D63E4")
        @Override
        public <T> T[] toArray(T[] array) {
            T[] varB4EAC82CA7396A68D541C85D26508E83_1284908884 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1284908884 = c.toArray(array);
            } 
            addTaint(array[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1284908884.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1284908884;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.254 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "DB1DE1953401C4A8F22A25B2206D8A3D")
        private void writeObject(ObjectOutputStream stream) throws IOException {
            {
                stream.defaultWriteObject();
            } 
            addTaint(stream.getTaint());
            
            
                
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.254 -0400", hash_original_field = "B7F3A88BD93CCDAF65C044FAA6629D02", hash_generated_field = "0D9A3687FC51DFBFFFEA57286BC842CD")

        private static final long serialVersionUID = 3053995032091335093L;
    }


    
    static class SynchronizedRandomAccessList<E> extends SynchronizedList<E> implements RandomAccess {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.255 -0400", hash_original_method = "B7E7091552AE239FAE56C332916C1F88", hash_generated_method = "E13039390DC63B5DD55D2C3F5A398F04")
          SynchronizedRandomAccessList(List<E> l) {
            super(l);
            addTaint(l.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.255 -0400", hash_original_method = "333C2DB156927D33EFC68D095A4D91C7", hash_generated_method = "AE1BCAB65FE4C0FE73632D8319B7F9FE")
          SynchronizedRandomAccessList(List<E> l, Object mutex) {
            super(l, mutex);
            addTaint(l.getTaint());
            addTaint(mutex.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.256 -0400", hash_original_method = "52EB3707ADD11A2326D60B7B815140D9", hash_generated_method = "28624EA4DF15A4AE812C02822C361B05")
        @Override
        public List<E> subList(int start, int end) {
            List<E> varB4EAC82CA7396A68D541C85D26508E83_821772014 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_821772014 = new SynchronizedRandomAccessList<E>(list.subList(start, end), mutex);
            } 
            addTaint(start);
            addTaint(end);
            varB4EAC82CA7396A68D541C85D26508E83_821772014.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_821772014;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.257 -0400", hash_original_method = "3A06B4F1BF7736CF10F2183ECBC34EF4", hash_generated_method = "9DB82AE7CC16A3987964FC2C1419F2EE")
        private Object writeReplace() {
            Object varB4EAC82CA7396A68D541C85D26508E83_718676805 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_718676805 = new SynchronizedList<E>(list);
            varB4EAC82CA7396A68D541C85D26508E83_718676805.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_718676805;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.257 -0400", hash_original_field = "9B799982724822CB2FE4521FDAC6E710", hash_generated_field = "F305BE0154CFFE9E0253007EE134CBB9")

        private static final long serialVersionUID = 1530674583602358482L;
    }


    
    static class SynchronizedList<E> extends SynchronizedCollection<E> implements List<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.258 -0400", hash_original_field = "10AE9FC7D453B0DD525D0EDF2EDE7961", hash_generated_field = "1ECA8D0C53ED31C6D874046BB18C0645")

        List<E> list;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.258 -0400", hash_original_method = "557BC04FB4751FAF0774C664BC5CCEDB", hash_generated_method = "C7C5461D5C9C9A7143EFC825B2E89308")
          SynchronizedList(List<E> l) {
            super(l);
            list = l;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.259 -0400", hash_original_method = "6BB690026CB7D337AD2D522FD2C1D564", hash_generated_method = "5A03D1AA887517822EC5152559195ADC")
          SynchronizedList(List<E> l, Object mutex) {
            super(l, mutex);
            list = l;
            addTaint(mutex.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.260 -0400", hash_original_method = "771543DB5FBF857EC43E623C900790C1", hash_generated_method = "91E40E74D69FC52967284256EB93FBA0")
        @Override
        public void add(int location, E object) {
            {
                list.add(location, object);
            } 
            addTaint(location);
            addTaint(object.getTaint());
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.261 -0400", hash_original_method = "2E8B0D036C339DEB52EAEECF82B3FC29", hash_generated_method = "D9199E47C0E3119AB33C3326C1DCA5C8")
        @Override
        public boolean addAll(int location, Collection<? extends E> collection) {
            {
                boolean var158D83A08C48A45A82B28798671769C1_1187342084 = (list.addAll(location, collection));
            } 
            addTaint(location);
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_809277087 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_809277087;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.263 -0400", hash_original_method = "3D6B0DEE3E066475015263D28B67E9C7", hash_generated_method = "4376E605507DB426E09055C3D83D3CA4")
        @Override
        public boolean equals(Object object) {
            {
                boolean varB8EFBCA5568090BA0F116E782A49968B_272038366 = (list.equals(object));
            } 
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1518424925 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1518424925;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.265 -0400", hash_original_method = "5B64BB89A58DED71DBA9907C06BC2CBB", hash_generated_method = "16E1F06352D55F6480EC0B3965BAF643")
        @Override
        public E get(int location) {
            E varB4EAC82CA7396A68D541C85D26508E83_2046744564 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_2046744564 = list.get(location);
            } 
            addTaint(location);
            varB4EAC82CA7396A68D541C85D26508E83_2046744564.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2046744564;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.266 -0400", hash_original_method = "4F5947DB3C3ABC0CDEDCB631295417DE", hash_generated_method = "BC299FE49818A0E727575488B63F86DA")
        @Override
        public int hashCode() {
            {
                int varE89315CE67DD6395C812E01B5B28CC79_1576373540 = (list.hashCode());
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_275850559 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_275850559;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.267 -0400", hash_original_method = "3D24998665BD619FA01B00E0A34A83F5", hash_generated_method = "F0A5DC6BE09E5D9391AD28F13B695CEE")
        @Override
        public int indexOf(Object object) {
            int size;
            Object[] array;
            {
                size = list.size();
                array = new Object[size];
                list.toArray(array);
            } 
            {
                {
                    int i = 0;
                    {
                        {
                            boolean varE4EB18CE7254896A48F2456CD1C5820F_31047352 = (object.equals(array[i]));
                        } 
                    } 
                } 
            } 
            {
                {
                    int i = 0;
                } 
            } 
            addTaint(object.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2058253974 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2058253974;
            
            
            
            
                
                
                
            
            
                
                    
                        
                    
                
            
                
                    
                        
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.268 -0400", hash_original_method = "615F71337583130515178716D1767A86", hash_generated_method = "5124C61D1D971AEBB680EEA12A6B497C")
        @Override
        public int lastIndexOf(Object object) {
            int size;
            Object[] array;
            {
                size = list.size();
                array = new Object[size];
                list.toArray(array);
            } 
            {
                {
                    int i = size - 1;
                    {
                        {
                            boolean varE4EB18CE7254896A48F2456CD1C5820F_189061153 = (object.equals(array[i]));
                        } 
                    } 
                } 
            } 
            {
                {
                    int i = size - 1;
                } 
            } 
            addTaint(object.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_251831072 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_251831072;
            
            
            
            
                
                
                
            
            
                
                    
                        
                    
                
            
                
                    
                        
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.269 -0400", hash_original_method = "9E49E91DE129681261C3C7642C2D1127", hash_generated_method = "85424A195084F988240CDC4A04A169CD")
        @Override
        public ListIterator<E> listIterator() {
            ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_1076124494 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1076124494 = list.listIterator();
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1076124494.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1076124494;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.270 -0400", hash_original_method = "70349F3896FC81F4D21A3D35B0C8A4F6", hash_generated_method = "E7E2099225EEA7838B08AAF96186B92B")
        @Override
        public ListIterator<E> listIterator(int location) {
            ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_1365484656 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1365484656 = list.listIterator(location);
            } 
            addTaint(location);
            varB4EAC82CA7396A68D541C85D26508E83_1365484656.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1365484656;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.270 -0400", hash_original_method = "D935E09B492D323BEF59297A7648FE48", hash_generated_method = "A8574EC96BD58830B38ED0F7D5D9A6B5")
        @Override
        public E remove(int location) {
            E varB4EAC82CA7396A68D541C85D26508E83_1453287280 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1453287280 = list.remove(location);
            } 
            addTaint(location);
            varB4EAC82CA7396A68D541C85D26508E83_1453287280.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1453287280;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.271 -0400", hash_original_method = "D9730991663FB8C206D80781B7E02750", hash_generated_method = "2909C5795E1C0C9237709EA4035F3AE8")
        @Override
        public E set(int location, E object) {
            E varB4EAC82CA7396A68D541C85D26508E83_255827313 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_255827313 = list.set(location, object);
            } 
            addTaint(location);
            addTaint(object.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_255827313.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_255827313;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.272 -0400", hash_original_method = "C38F2D62AA6D1EBD255ADC5369CBEC01", hash_generated_method = "18719031D4E9D5AC82B36B9B1475E1E1")
        @Override
        public List<E> subList(int start, int end) {
            List<E> varB4EAC82CA7396A68D541C85D26508E83_1322922609 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1322922609 = new SynchronizedList<E>(list.subList(start, end), mutex);
            } 
            addTaint(start);
            addTaint(end);
            varB4EAC82CA7396A68D541C85D26508E83_1322922609.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1322922609;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.273 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "DB1DE1953401C4A8F22A25B2206D8A3D")
        private void writeObject(ObjectOutputStream stream) throws IOException {
            {
                stream.defaultWriteObject();
            } 
            addTaint(stream.getTaint());
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.274 -0400", hash_original_method = "172F08E6F2352F1764A4A70C48C6E243", hash_generated_method = "4EF2D37538C79AEA3D4B22ADA2D28160")
        private Object readResolve() {
            Object varB4EAC82CA7396A68D541C85D26508E83_742999978 = null; 
            Object varB4EAC82CA7396A68D541C85D26508E83_91303403 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_742999978 = new SynchronizedRandomAccessList<E>(list, mutex);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_91303403 = this;
            Object varA7E53CE21691AB073D9660D615818899_2003228754; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_2003228754 = varB4EAC82CA7396A68D541C85D26508E83_742999978;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_2003228754 = varB4EAC82CA7396A68D541C85D26508E83_91303403;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_2003228754.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_2003228754;
            
            
                
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.274 -0400", hash_original_field = "8883C8F4886CDFE339069F9C7525453D", hash_generated_field = "5528D904FB3223ACA4EBA912A58AE2BF")

        private static final long serialVersionUID = -7754090372962971524L;
    }


    
    static class SynchronizedMap<K, V> implements Map<K, V>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.274 -0400", hash_original_field = "6F8F57715090DA2632453988D9A1501B", hash_generated_field = "1785B4570966C73126874A8D942D2395")

        private Map<K, V> m;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.274 -0400", hash_original_field = "25A01BB859125507013A2FE9737D3C32", hash_generated_field = "5C5F8780FECE5E612AF5A86D3A8B3194")

        Object mutex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.274 -0400", hash_original_method = "C14189E3F71A4C148CB91C638F3BAAE3", hash_generated_method = "697756520B6F74069D1E5AA0F6D1C69A")
          SynchronizedMap(Map<K, V> map) {
            m = map;
            mutex = this;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.275 -0400", hash_original_method = "6EAD9DD813CFD47244744C3F6D6A4D1C", hash_generated_method = "96BED7921FDC6B114140F51F8F22333E")
          SynchronizedMap(Map<K, V> map, Object mutex) {
            m = map;
            this.mutex = mutex;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.275 -0400", hash_original_method = "3DCF075501F09300584E40825720BBA2", hash_generated_method = "931659E7A8514DEF770EFF02D67516B0")
        @Override
        public void clear() {
            {
                m.clear();
            } 
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.275 -0400", hash_original_method = "D2C67B34100B05197A0572527ECA3220", hash_generated_method = "9BC499AF42261464337BFEBA813EBAFA")
        @Override
        public boolean containsKey(Object key) {
            {
                boolean var5B3943E8DB1DEBF4053A7AC85BD5CB7F_1362900928 = (m.containsKey(key));
            } 
            addTaint(key.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1264254424 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1264254424;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.276 -0400", hash_original_method = "FFE2162DB44C1E8BEEAD35935B233C81", hash_generated_method = "0FE91633895249BBB7C6A0929E66A015")
        @Override
        public boolean containsValue(Object value) {
            {
                boolean var9B502A789B5AAD38CD0ED829F2887AEF_672314065 = (m.containsValue(value));
            } 
            addTaint(value.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1211941837 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1211941837;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.276 -0400", hash_original_method = "E5EA9A3F9567269DAA52E0C08140D3D5", hash_generated_method = "AC7A3AB211DAEBF4F4DAC1AFCA305731")
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_345986113 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_345986113 = new SynchronizedSet<Map.Entry<K, V>>(m.entrySet(), mutex);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_345986113.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_345986113;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.276 -0400", hash_original_method = "573EFA9740FEBDEC9C1CCFD8172CCEF0", hash_generated_method = "7122F477C381A678469935B5701E10BA")
        @Override
        public boolean equals(Object object) {
            {
                boolean var3653CC7A1B6721F556FDF4EA3FD61A52_1523730968 = (m.equals(object));
            } 
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_995123684 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_995123684;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.277 -0400", hash_original_method = "80DF7D6FED6980DF61457325CD64503D", hash_generated_method = "26E1D4159E9C7954166ED32A91D5B3F3")
        @Override
        public V get(Object key) {
            V varB4EAC82CA7396A68D541C85D26508E83_565882964 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_565882964 = m.get(key);
            } 
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_565882964.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_565882964;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.277 -0400", hash_original_method = "5DDF560D56DA8F61EEAD582BB150A893", hash_generated_method = "605FA0A7F3505C1F4389BE48C76D1497")
        @Override
        public int hashCode() {
            {
                int var58938B03D27AEF577E5F8B43D45478A1_563695685 = (m.hashCode());
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1977929196 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1977929196;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.277 -0400", hash_original_method = "40A122CDBD7096230690259CC30A0F7A", hash_generated_method = "9DEA93BB94C6D0B4C03A5222BBABC9B5")
        @Override
        public boolean isEmpty() {
            {
                boolean var20AA7E3C23DC3AFB5FE1B5D3BD0CE158_1568919902 = (m.isEmpty());
            } 
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1106281430 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1106281430;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.278 -0400", hash_original_method = "2FBB6190D51F2A6210F8CF71191E69DD", hash_generated_method = "A426E1C1C28E0F567497952FAF8E5630")
        @Override
        public Set<K> keySet() {
            Set<K> varB4EAC82CA7396A68D541C85D26508E83_777153717 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_777153717 = new SynchronizedSet<K>(m.keySet(), mutex);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_777153717.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_777153717;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.278 -0400", hash_original_method = "4BBBC2EF3E646AB7C0C1BFCAE8571FAF", hash_generated_method = "CA67EBB25C6378F23C498FF5A311302A")
        @Override
        public V put(K key, V value) {
            V varB4EAC82CA7396A68D541C85D26508E83_1518852921 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1518852921 = m.put(key, value);
            } 
            addTaint(key.getTaint());
            addTaint(value.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1518852921.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1518852921;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.279 -0400", hash_original_method = "400FF0E6707670DAA4FF7ECA275302A3", hash_generated_method = "DB9FF77F668C1D72924587E83C74A1E6")
        @Override
        public void putAll(Map<? extends K, ? extends V> map) {
            {
                m.putAll(map);
            } 
            addTaint(map.getTaint());
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.279 -0400", hash_original_method = "98B37460DCD5FD18048F5172283C3141", hash_generated_method = "174DB1AEB90F99C00596757390ABCF2D")
        @Override
        public V remove(Object key) {
            V varB4EAC82CA7396A68D541C85D26508E83_270109203 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_270109203 = m.remove(key);
            } 
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_270109203.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_270109203;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.279 -0400", hash_original_method = "A48EE7C65347333E889EFC2ECD0A019A", hash_generated_method = "983B9A62679EFB07425629FA539B1731")
        @Override
        public int size() {
            {
                int var0BF7698F6735353014CC57B558785727_22451694 = (m.size());
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_373620423 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_373620423;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.280 -0400", hash_original_method = "BB797020E54DC33FB15BC9404E89E5CD", hash_generated_method = "5EB98E9197401CF467AFD93682596A33")
        @Override
        public Collection<V> values() {
            Collection<V> varB4EAC82CA7396A68D541C85D26508E83_463610465 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_463610465 = new SynchronizedCollection<V>(m.values(), mutex);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_463610465.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_463610465;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.280 -0400", hash_original_method = "CB61B465EF18C12F472B81636CD4AC79", hash_generated_method = "5D2DABFCBBEE657CFC16016D671B6D54")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_518125019 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_518125019 = m.toString();
            } 
            varB4EAC82CA7396A68D541C85D26508E83_518125019.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_518125019;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.280 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "DB1DE1953401C4A8F22A25B2206D8A3D")
        private void writeObject(ObjectOutputStream stream) throws IOException {
            {
                stream.defaultWriteObject();
            } 
            addTaint(stream.getTaint());
            
            
                
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.280 -0400", hash_original_field = "5DC93EB19DFCBC7B8981ED54844A07B4", hash_generated_field = "1DE57645F72579A567941D71223F2BB4")

        private static final long serialVersionUID = 1978198479659022715L;
    }


    
    static class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.281 -0400", hash_original_method = "F3863A567ABAC10F9410ABCF2A4DC8AC", hash_generated_method = "B3C414CCF795BDAB85BAEA8F2098B4FB")
          SynchronizedSet(Set<E> set) {
            super(set);
            addTaint(set.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.281 -0400", hash_original_method = "A1BA2E3E145DCA2C522F0AB9439A1572", hash_generated_method = "F2771B0F9A187173FBD167BE172A69B3")
          SynchronizedSet(Set<E> set, Object mutex) {
            super(set, mutex);
            addTaint(set.getTaint());
            addTaint(mutex.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.282 -0400", hash_original_method = "E045FF0B832C85F3AF0597463FE3892F", hash_generated_method = "A3EA1D75952C5D2BECB0BACA34E83474")
        @Override
        public boolean equals(Object object) {
            {
                boolean varEA83122D095DC61C01436A4AA2CBB70C_1920094583 = (c.equals(object));
            } 
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1593979171 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1593979171;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.282 -0400", hash_original_method = "60CA731F9E7ECB7D3EED20B0D6D4AB09", hash_generated_method = "C61003FB4E9EBCC78417EDFF0922A8A5")
        @Override
        public int hashCode() {
            {
                int varDBC342B671922A4943718E25F26D87D0_651285241 = (c.hashCode());
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_809106422 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_809106422;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.282 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "DB1DE1953401C4A8F22A25B2206D8A3D")
        private void writeObject(ObjectOutputStream stream) throws IOException {
            {
                stream.defaultWriteObject();
            } 
            addTaint(stream.getTaint());
            
            
                
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.282 -0400", hash_original_field = "916EB185FF2AF0CF7FFC612F07D6DA1B", hash_generated_field = "A77C43308F38D2FC67E81B4E46E8827E")

        private static final long serialVersionUID = 487447009682186044L;
    }


    
    static class SynchronizedSortedMap<K, V> extends SynchronizedMap<K, V> implements SortedMap<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.282 -0400", hash_original_field = "ED79ACB0CD3D7F8320C53C7798335EF0", hash_generated_field = "F813233D7B24D3620137345516D05A23")

        private SortedMap<K, V> sm;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.283 -0400", hash_original_method = "2E0F62BCD34367F1E6E251286E17ABEB", hash_generated_method = "65B92739EACB6292AF1017EE07725F62")
          SynchronizedSortedMap(SortedMap<K, V> map) {
            super(map);
            sm = map;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.283 -0400", hash_original_method = "5BF33998E3FF0155F7A513C6A201FE85", hash_generated_method = "954D8A68339AFC6EE619959623984CAA")
          SynchronizedSortedMap(SortedMap<K, V> map, Object mutex) {
            super(map, mutex);
            sm = map;
            addTaint(mutex.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.284 -0400", hash_original_method = "78218A5A359D1FCDF6B98779037FCB94", hash_generated_method = "A78893D2BC872529B6271CCD19A96CF2")
        @Override
        public Comparator<? super K> comparator() {
            Comparator<? super K> varB4EAC82CA7396A68D541C85D26508E83_556114795 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_556114795 = sm.comparator();
            } 
            varB4EAC82CA7396A68D541C85D26508E83_556114795.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_556114795;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.286 -0400", hash_original_method = "4A44F83861E496A35113DD67FECD390A", hash_generated_method = "985CEF4CA2104E53160426E175B50702")
        @Override
        public K firstKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_1964477174 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1964477174 = sm.firstKey();
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1964477174.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1964477174;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.289 -0400", hash_original_method = "758EF70CDC2061BD7D7B124D17EF3F64", hash_generated_method = "B25A020E85CDC539BCE26303172D5636")
        @Override
        public SortedMap<K, V> headMap(K endKey) {
            SortedMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_2007471039 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_2007471039 = new SynchronizedSortedMap<K, V>(sm.headMap(endKey),
                        mutex);
            } 
            addTaint(endKey.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2007471039.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2007471039;
            
            
                
                        
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.290 -0400", hash_original_method = "ECB924A52CC9F341D1EEB7E5D7BCCDC8", hash_generated_method = "6B184A0B8D1FC9543B0A0B4D917B9EF2")
        @Override
        public K lastKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_1144990063 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1144990063 = sm.lastKey();
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1144990063.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1144990063;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.292 -0400", hash_original_method = "E82E6227AA62F00EB1D33B47A72F41C4", hash_generated_method = "FD5407A42865A01AA805A1297A39D918")
        @Override
        public SortedMap<K, V> subMap(K startKey, K endKey) {
            SortedMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_1935784347 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1935784347 = new SynchronizedSortedMap<K, V>(sm.subMap(startKey,
                        endKey), mutex);
            } 
            addTaint(startKey.getTaint());
            addTaint(endKey.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1935784347.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1935784347;
            
            
                
                        
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.293 -0400", hash_original_method = "F7B84D714F16D295C7D43C8AA5E52D6A", hash_generated_method = "FDB2D9314DD3211844FBAE183616F291")
        @Override
        public SortedMap<K, V> tailMap(K startKey) {
            SortedMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_443277539 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_443277539 = new SynchronizedSortedMap<K, V>(sm.tailMap(startKey),
                        mutex);
            } 
            addTaint(startKey.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_443277539.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_443277539;
            
            
                
                        
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.294 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "DB1DE1953401C4A8F22A25B2206D8A3D")
        private void writeObject(ObjectOutputStream stream) throws IOException {
            {
                stream.defaultWriteObject();
            } 
            addTaint(stream.getTaint());
            
            
                
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.294 -0400", hash_original_field = "CA84F69F8568978C0AA41949BE696442", hash_generated_field = "ECA677D018A422E9BB2369A5AF38055A")

        private static final long serialVersionUID = -8798146769416483793L;
    }


    
    static class SynchronizedSortedSet<E> extends SynchronizedSet<E> implements SortedSet<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.294 -0400", hash_original_field = "3691308F2A4C2F6983F2880D32E29C84", hash_generated_field = "5220A6F2AA4CB98BB6C290F0BB717E86")

        private SortedSet<E> ss;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.295 -0400", hash_original_method = "B2F0E775DF29B0E6B28447766B0AA532", hash_generated_method = "4CBCB006A0B32CDF41866EAC9A8E2DC9")
          SynchronizedSortedSet(SortedSet<E> set) {
            super(set);
            ss = set;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.295 -0400", hash_original_method = "46957450EFA60C06BEFC5742F9BFAC78", hash_generated_method = "162269369C68BEF6B4124813A13B8D19")
          SynchronizedSortedSet(SortedSet<E> set, Object mutex) {
            super(set, mutex);
            ss = set;
            addTaint(mutex.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.297 -0400", hash_original_method = "D71F7DA0E84FA7A091B4017D559410C5", hash_generated_method = "88C667D095A948BEEBB03BF032CABC76")
        @Override
        public Comparator<? super E> comparator() {
            Comparator<? super E> varB4EAC82CA7396A68D541C85D26508E83_360413749 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_360413749 = ss.comparator();
            } 
            varB4EAC82CA7396A68D541C85D26508E83_360413749.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_360413749;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.297 -0400", hash_original_method = "C2C55C7E331CFDE8E84B8FC74FDABE02", hash_generated_method = "7B28BEB37E657BA01A35BC0C02A0CBF7")
        @Override
        public E first() {
            E varB4EAC82CA7396A68D541C85D26508E83_620216231 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_620216231 = ss.first();
            } 
            varB4EAC82CA7396A68D541C85D26508E83_620216231.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_620216231;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.298 -0400", hash_original_method = "86DA75392AF50D6AE53AEE4A4052EBA8", hash_generated_method = "827DE4DD61BBF3EAAA6ECE6B58B2F970")
        @Override
        public SortedSet<E> headSet(E end) {
            SortedSet<E> varB4EAC82CA7396A68D541C85D26508E83_1593379314 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1593379314 = new SynchronizedSortedSet<E>(ss.headSet(end), mutex);
            } 
            addTaint(end.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1593379314.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1593379314;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.298 -0400", hash_original_method = "3C10DA3BCCE6BED4EBD1F6A2C6BC8438", hash_generated_method = "E1F80BB8E4A66E664695298E1E727091")
        @Override
        public E last() {
            E varB4EAC82CA7396A68D541C85D26508E83_1155885723 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1155885723 = ss.last();
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1155885723.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1155885723;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.299 -0400", hash_original_method = "662A59FFAA1C1722D75A374EC93FB0DF", hash_generated_method = "1B187571F8B2B032B9397FD8064904F0")
        @Override
        public SortedSet<E> subSet(E start, E end) {
            SortedSet<E> varB4EAC82CA7396A68D541C85D26508E83_646396157 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_646396157 = new SynchronizedSortedSet<E>(ss.subSet(start, end),
                        mutex);
            } 
            addTaint(start.getTaint());
            addTaint(end.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_646396157.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_646396157;
            
            
                
                        
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.299 -0400", hash_original_method = "4C04840896A126B8B17AD8E0926A5B00", hash_generated_method = "CCB1B68A4495B9BB299CA0D7D7615249")
        @Override
        public SortedSet<E> tailSet(E start) {
            SortedSet<E> varB4EAC82CA7396A68D541C85D26508E83_204282227 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_204282227 = new SynchronizedSortedSet<E>(ss.tailSet(start), mutex);
            } 
            addTaint(start.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_204282227.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_204282227;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.300 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "DB1DE1953401C4A8F22A25B2206D8A3D")
        private void writeObject(ObjectOutputStream stream) throws IOException {
            {
                stream.defaultWriteObject();
            } 
            addTaint(stream.getTaint());
            
            
                
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.300 -0400", hash_original_field = "7550293A247191A63B69680B8051BA5C", hash_generated_field = "44E22A9B5E1BF0CBC26900B92B680526")

        private static final long serialVersionUID = 8695801310862127406L;
    }


    
    private static class UnmodifiableCollection<E> implements Collection<E>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.300 -0400", hash_original_field = "4A8A08F09D37B73795649038408B5F33", hash_generated_field = "A3C80A7E02E49F20400373DFBAF9696A")

        Collection<E> c;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.300 -0400", hash_original_method = "0B21B3311CB87F81844FA591591A704A", hash_generated_method = "F8A220D652916612975A1BF5C32AE7B2")
          UnmodifiableCollection(Collection<E> collection) {
            c = collection;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.301 -0400", hash_original_method = "1E7EFCC2BAD401EE702FAECD906F0B57", hash_generated_method = "28977473A6A2B9F4189E15F53E01D32D")
        @Override
        public boolean add(E object) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1338497219 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1338497219;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.301 -0400", hash_original_method = "A14B246F22D65FADC1A66C9C0851763B", hash_generated_method = "CFF5826417F47A4755B2DEC2F97CA330")
        @Override
        public boolean addAll(Collection<? extends E> collection) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_95554649 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_95554649;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.301 -0400", hash_original_method = "C5BE2B5F9D582C4EED1DC0880E8741A1", hash_generated_method = "2CA329ADE50B407D285AB2E4B5875FC8")
        @Override
        public void clear() {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.302 -0400", hash_original_method = "9A5FA57B69BAE7BFE0B020704235C788", hash_generated_method = "11A854DBD2D7B6A7ED026D230116FD2F")
        @Override
        public boolean contains(Object object) {
            boolean var57979CEAB3B2144CFD864D01F9E7B4FE_1902323668 = (c.contains(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_120825650 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_120825650;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.302 -0400", hash_original_method = "BD1B4CD05BF6E123B0DC6FD003A6020C", hash_generated_method = "3495075D9AA019CCADFE4107BB9ACB18")
        @Override
        public boolean containsAll(Collection<?> collection) {
            boolean varF92105B68CE9F70CF43B3142D405452C_1796240369 = (c.containsAll(collection));
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1456443721 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1456443721;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.303 -0400", hash_original_method = "F9A3CB1FB7570D28EBE20660E2FC6F42", hash_generated_method = "D3DB5A7090FC80E90731E5AB089C9505")
        @Override
        public boolean isEmpty() {
            boolean var528EAD02A70F822F393BB0C54FBB923C_74057758 = (c.isEmpty());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1551153484 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1551153484;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.304 -0400", hash_original_method = "57C2B30126E9906DFFF70EEB2D2CD18D", hash_generated_method = "66D4B42C5ED3621AA04A160A1EE8D228")
        @Override
        public Iterator<E> iterator() {
            Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_1465353056 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1465353056 = new Iterator<E>() {
                Iterator<E> iterator = c.iterator();
                @Override public boolean hasNext() {
                    return iterator.hasNext();
                }
                @Override public E next() {
                    return iterator.next();
                }
                @Override public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
            varB4EAC82CA7396A68D541C85D26508E83_1465353056.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1465353056;
            
            
                
                
                    
                
                
                    
                
                
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.305 -0400", hash_original_method = "2165C77F20F5DBDDE4D0AED313262684", hash_generated_method = "6A792AF405ECEFF1025340F5F9724524")
        @Override
        public boolean remove(Object object) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1089246481 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1089246481;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.305 -0400", hash_original_method = "95D6D7B80D3C762A794FEAFDE42B30FC", hash_generated_method = "EFBDE5DF4ABBEB11AC762F28B0F57AF2")
        @Override
        public boolean removeAll(Collection<?> collection) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1007644817 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1007644817;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.306 -0400", hash_original_method = "D4789A90B422D35C3FC475A0D6C54BE8", hash_generated_method = "816D19C15435D18DF724F7AFC2FCAB60")
        @Override
        public boolean retainAll(Collection<?> collection) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_757176086 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_757176086;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.306 -0400", hash_original_method = "AC97C28F724592ABA809E2470D95C119", hash_generated_method = "5529B4AAE91A0BF717355AD709924AF8")
        @Override
        public int size() {
            int varC247C84593AA6020ED979B19566D13FE_868717181 = (c.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_955259302 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_955259302;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.307 -0400", hash_original_method = "89D7D02A9D2BDF31E775C08108CBDE5B", hash_generated_method = "7C0B6015D852ACB578977B1C5F51DE12")
        @Override
        public Object[] toArray() {
            Object[] varB4EAC82CA7396A68D541C85D26508E83_290802573 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_290802573 = c.toArray();
            varB4EAC82CA7396A68D541C85D26508E83_290802573.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_290802573;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.307 -0400", hash_original_method = "D5913A45F2385B9A173BEEED47EA354F", hash_generated_method = "AE808DDD5815CE1D90E965A5C5616E1F")
        @Override
        public <T> T[] toArray(T[] array) {
            T[] varB4EAC82CA7396A68D541C85D26508E83_788460922 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_788460922 = c.toArray(array);
            addTaint(array[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_788460922.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_788460922;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.308 -0400", hash_original_method = "424D4966F358AE6553349A6493C21674", hash_generated_method = "B8BEDAAB294B60679855CFCE4F4C5233")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_34540172 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_34540172 = c.toString();
            varB4EAC82CA7396A68D541C85D26508E83_34540172.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_34540172;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.308 -0400", hash_original_field = "BF3B1BE107A3BC6EF3F11D547E97ECD3", hash_generated_field = "ED589FB504EC70A2532C4CA52BA9C8D0")

        private static final long serialVersionUID = 1820017752578914078L;
    }


    
    private static class UnmodifiableRandomAccessList<E> extends UnmodifiableList<E> implements RandomAccess {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.308 -0400", hash_original_method = "0A20B358F7BA1E60AD6DE80ADB85C324", hash_generated_method = "205D9E6E7A9FC9AE79599882AC59F3B2")
          UnmodifiableRandomAccessList(List<E> l) {
            super(l);
            addTaint(l.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.309 -0400", hash_original_method = "BFD692E8EF2A50E82DD6BA0EC7051578", hash_generated_method = "A4BA8D8BC7A77205B4988B319BCA1007")
        @Override
        public List<E> subList(int start, int end) {
            List<E> varB4EAC82CA7396A68D541C85D26508E83_827594694 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_827594694 = new UnmodifiableRandomAccessList<E>(list.subList(start, end));
            addTaint(start);
            addTaint(end);
            varB4EAC82CA7396A68D541C85D26508E83_827594694.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_827594694;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.310 -0400", hash_original_method = "C39E6F512687738DD8D987CDE63A2838", hash_generated_method = "216811606A9D2957B9BE6161E26AD595")
        private Object writeReplace() {
            Object varB4EAC82CA7396A68D541C85D26508E83_2103064661 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2103064661 = new UnmodifiableList<E>(list);
            varB4EAC82CA7396A68D541C85D26508E83_2103064661.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2103064661;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.310 -0400", hash_original_field = "70DB59789BD14A138F9B12A5CF11EB14", hash_generated_field = "871EA319ACA4D6DBFD800453B4F24DBA")

        private static final long serialVersionUID = -2542308836966382001L;
    }


    
    private static class UnmodifiableList<E> extends UnmodifiableCollection<E> implements List<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.310 -0400", hash_original_field = "10AE9FC7D453B0DD525D0EDF2EDE7961", hash_generated_field = "1ECA8D0C53ED31C6D874046BB18C0645")

        List<E> list;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.311 -0400", hash_original_method = "4CB96388E36B825DE711E2E59A893E0D", hash_generated_method = "51986B2400081BEED0D63B6036986FF3")
          UnmodifiableList(List<E> l) {
            super(l);
            list = l;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.311 -0400", hash_original_method = "CE54A57EF9628E9FD413F964E9F93054", hash_generated_method = "4E38A1F7266D70D7D320F93ABDA9F566")
        @Override
        public void add(int location, E object) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(location);
            addTaint(object.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.312 -0400", hash_original_method = "6CD19404B4901DECE5B6F72EB7D0CD8F", hash_generated_method = "B81A812FE378E3FBF62EED6A43633332")
        @Override
        public boolean addAll(int location, Collection<? extends E> collection) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(location);
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1371332220 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1371332220;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.313 -0400", hash_original_method = "C3C1892342CAEB152D9191558B893ACD", hash_generated_method = "163F893F8BA0346A5EABEBC214B3BEC7")
        @Override
        public boolean equals(Object object) {
            boolean var983E353D0DFE7FD02AAEFC303F168456_180589324 = (list.equals(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1208305546 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1208305546;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.315 -0400", hash_original_method = "DFB24286AA0C5C6BF58031CA4ED7CDCB", hash_generated_method = "D08E2072873DEB3D40DE43181E4C3319")
        @Override
        public E get(int location) {
            E varB4EAC82CA7396A68D541C85D26508E83_1102940835 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1102940835 = list.get(location);
            addTaint(location);
            varB4EAC82CA7396A68D541C85D26508E83_1102940835.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1102940835;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.317 -0400", hash_original_method = "8FDA3E2E38E99F5D6FC34E94E92E953F", hash_generated_method = "8E6DDA12299B0C1DB5945E7A4DA56EC0")
        @Override
        public int hashCode() {
            int var9A1610964D862FF54E00A16E6D7BD291_1039520419 = (list.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1742514264 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1742514264;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.318 -0400", hash_original_method = "E8AAF2C874038C363BF8C80F2A4ED8F2", hash_generated_method = "88038525797FBCB98025909AC354AA7B")
        @Override
        public int indexOf(Object object) {
            int var77BCF240B74578A0DBB7E15170347534_1741860370 = (list.indexOf(object));
            addTaint(object.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_964195019 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_964195019;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.318 -0400", hash_original_method = "658C7926C6DFF1B86F4D9B6B0E3F5BBD", hash_generated_method = "96CF46E3E7ADC983833D73A17AB063C2")
        @Override
        public int lastIndexOf(Object object) {
            int var158B58B87F16034A803BFB0430AFCD59_1196980741 = (list.lastIndexOf(object));
            addTaint(object.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1627466471 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1627466471;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.319 -0400", hash_original_method = "DF7BE0B13ABC5A9B1C74313BD06FB64C", hash_generated_method = "AD61A4F8587B0A9415C34E59249DF81B")
        @Override
        public ListIterator<E> listIterator() {
            ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_263198352 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_263198352 = listIterator(0);
            varB4EAC82CA7396A68D541C85D26508E83_263198352.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_263198352;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.320 -0400", hash_original_method = "1D0E6831E50FA8995D23240A6E091C82", hash_generated_method = "CB01E119A117CB7B5E8CEFB479FDB48E")
        @Override
        public ListIterator<E> listIterator(final int location) {
            ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_1584706905 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1584706905 = new ListIterator<E>() {
                ListIterator<E> iterator = list.listIterator(location);
                @Override public void add(E object) {
                    throw new UnsupportedOperationException();
                }
                @Override public boolean hasNext() {
                    return iterator.hasNext();
                }
                @Override public boolean hasPrevious() {
                    return iterator.hasPrevious();
                }
                @Override public E next() {
                    return iterator.next();
                }
                @Override public int nextIndex() {
                    return iterator.nextIndex();
                }
                @Override public E previous() {
                    return iterator.previous();
                }
                @Override public int previousIndex() {
                    return iterator.previousIndex();
                }
                @Override public void remove() {
                    throw new UnsupportedOperationException();
                }
                @Override public void set(E object) {
                    throw new UnsupportedOperationException();
                }
            };
            addTaint(location);
            varB4EAC82CA7396A68D541C85D26508E83_1584706905.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1584706905;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.320 -0400", hash_original_method = "5388D372D048D053ADD084F02A9C1484", hash_generated_method = "ACA80C53B37816218B9855BF5E9A7790")
        @Override
        public E remove(int location) {
        	throw new UnsupportedOperationException();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.321 -0400", hash_original_method = "8830E2F07CC294339D5D496574BCFA5E", hash_generated_method = "FC1CD5B83BE519CD37A91D24C6B9D9F3")
        @Override
        public E set(int location, E object) {
        	throw new UnsupportedOperationException();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.322 -0400", hash_original_method = "82D78FB8922B9A0888EF8A304898D60D", hash_generated_method = "CD3D359FEA2B2B221325A10E7A336FB1")
        @Override
        public List<E> subList(int start, int end) {
            List<E> varB4EAC82CA7396A68D541C85D26508E83_1479815228 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1479815228 = new UnmodifiableList<E>(list.subList(start, end));
            addTaint(start);
            addTaint(end);
            varB4EAC82CA7396A68D541C85D26508E83_1479815228.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1479815228;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.322 -0400", hash_original_method = "5F3DDA40E6BDC67502A2E43BA75DBB15", hash_generated_method = "7EB32E8908DD48008930CCFE6A990734")
        private Object readResolve() {
            Object varB4EAC82CA7396A68D541C85D26508E83_589019661 = null; 
            Object varB4EAC82CA7396A68D541C85D26508E83_856754616 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_589019661 = new UnmodifiableRandomAccessList<E>(list);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_856754616 = this;
            Object varA7E53CE21691AB073D9660D615818899_1473969349; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1473969349 = varB4EAC82CA7396A68D541C85D26508E83_589019661;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1473969349 = varB4EAC82CA7396A68D541C85D26508E83_856754616;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1473969349.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1473969349;
            
            
                
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.322 -0400", hash_original_field = "69FDA83BF467A43A3D5BCAA929D897B3", hash_generated_field = "F0F0F0942F5CE1242FD2AB85FF483C32")

        private static final long serialVersionUID = -283967356065247728L;
        
    }


    
    private static class UnmodifiableMap<K, V> implements Map<K, V>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.322 -0400", hash_original_field = "6F8F57715090DA2632453988D9A1501B", hash_generated_field = "1785B4570966C73126874A8D942D2395")

        private Map<K, V> m;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.323 -0400", hash_original_method = "74C4A0289A3E9196E4EF75F76384A7D2", hash_generated_method = "DA7567E66A4C382E1EF89234BCC9D997")
          UnmodifiableMap(Map<K, V> map) {
            m = map;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.323 -0400", hash_original_method = "C5BE2B5F9D582C4EED1DC0880E8741A1", hash_generated_method = "2CA329ADE50B407D285AB2E4B5875FC8")
        @Override
        public void clear() {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.323 -0400", hash_original_method = "A6C730848D8A626F99D8229EE744E3C0", hash_generated_method = "AE6D8C3D81A412C08D30D1497419C0BD")
        @Override
        public boolean containsKey(Object key) {
            boolean var2519B7EF565FEC21B6285F5E44AC148E_2055489353 = (m.containsKey(key));
            addTaint(key.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1976060224 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1976060224;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.323 -0400", hash_original_method = "EF8C00CF950E8C186D2F05E1E556F384", hash_generated_method = "9E3DE319CFCF9CAADDEF042DFBD955B6")
        @Override
        public boolean containsValue(Object value) {
            boolean varF8CB74E2C5E0734947B397D82173BDD4_1111617176 = (m.containsValue(value));
            addTaint(value.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2014157550 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2014157550;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.324 -0400", hash_original_method = "FB0DE15DA25D3994421C9FBDD1812EDD", hash_generated_method = "61AD3CBE804DD44D41C6F1799B786BD0")
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_421220316 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_421220316 = new UnmodifiableEntrySet<K, V>(m.entrySet());
            varB4EAC82CA7396A68D541C85D26508E83_421220316.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_421220316;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.324 -0400", hash_original_method = "CE201E78EAC5D1903F741160CB297EAE", hash_generated_method = "29E986EA28CCCE991D87DEF5E2602D77")
        @Override
        public boolean equals(Object object) {
            boolean var9745819ACBF7C47D9CAE10D95AB26047_1852675938 = (m.equals(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_19689940 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_19689940;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.325 -0400", hash_original_method = "B8FE254B61C57EC3A6DCE539976DA268", hash_generated_method = "C2ED668DF7ED8793629B678256171AE8")
        @Override
        public V get(Object key) {
            V varB4EAC82CA7396A68D541C85D26508E83_346070468 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_346070468 = m.get(key);
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_346070468.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_346070468;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.325 -0400", hash_original_method = "E3229E3389F030DD50B79734943DB788", hash_generated_method = "5871D1A081EBFBB08580EC4B5D2DA3B2")
        @Override
        public int hashCode() {
            int varAA1293165230C9829C1AEACFFF576DFC_441385939 = (m.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_909100090 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_909100090;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.326 -0400", hash_original_method = "B9E63D3C52241E7E917CB1416ABA36E5", hash_generated_method = "F325E4843961851B4E4B47E2E7D2AEA6")
        @Override
        public boolean isEmpty() {
            boolean var028CF644E61B84328EAB66D556672A81_64776259 = (m.isEmpty());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_821440302 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_821440302;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.326 -0400", hash_original_method = "2CC049F262DAAA6660AF161E9C8606F6", hash_generated_method = "4D213936329DC135C1A21488DADD1EDF")
        @Override
        public Set<K> keySet() {
            Set<K> varB4EAC82CA7396A68D541C85D26508E83_371820132 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_371820132 = new UnmodifiableSet<K>(m.keySet());
            varB4EAC82CA7396A68D541C85D26508E83_371820132.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_371820132;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.327 -0400", hash_original_method = "1AE25A34BEB4A8F08F41373ADFFCFE34", hash_generated_method = "D7819781C010BECFFB3BC37EE093E818")
        @Override
        public V put(K key, V value) {
        	throw new UnsupportedOperationException();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.327 -0400", hash_original_method = "1D605566C28BBD06FDC515389557B406", hash_generated_method = "8C9B96AACD1010A390DA93C9E1C54679")
        @Override
        public void putAll(Map<? extends K, ? extends V> map) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(map.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.328 -0400", hash_original_method = "1F8D4C123F3DDBF68E61E38EDB13F5FB", hash_generated_method = "CAC84F3EBC2CB52F20821DF2278AA8A5")
        @Override
        public V remove(Object key) {
        	throw new UnsupportedOperationException();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.329 -0400", hash_original_method = "A04EE09DEB6F21FAA6A7E10DF6401CD1", hash_generated_method = "F1579457214F58119EB822B182A5D811")
        @Override
        public int size() {
            int varDBD6E28F15F3D13B8127CF62DD69ACD5_797188144 = (m.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1346942455 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1346942455;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.330 -0400", hash_original_method = "19DD84E0D2EBBBC2FCDA12D023824450", hash_generated_method = "F047E6651DD8BDCF61380427CF74DF73")
        @Override
        public Collection<V> values() {
            Collection<V> varB4EAC82CA7396A68D541C85D26508E83_1215245479 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1215245479 = new UnmodifiableCollection<V>(m.values());
            varB4EAC82CA7396A68D541C85D26508E83_1215245479.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1215245479;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.330 -0400", hash_original_method = "5DD44B3CD2826BF39F974F66579CF74F", hash_generated_method = "752F45BB0F16EB255C781FC38E11D8E8")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_176331067 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_176331067 = m.toString();
            varB4EAC82CA7396A68D541C85D26508E83_176331067.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_176331067;
            
            
        }

        
        private static class UnmodifiableEntrySet<K, V> extends UnmodifiableSet<Map.Entry<K, V>> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.331 -0400", hash_original_method = "211DEE98878E4422E2F38E79CDC5F0D4", hash_generated_method = "E5E05A5D1E2777C870B2B3DCCCA2A2BD")
              UnmodifiableEntrySet(Set<Map.Entry<K, V>> set) {
                super(set);
                addTaint(set.getTaint());
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.331 -0400", hash_original_method = "53A7F61EDA7A64FBCB28AE61A8906002", hash_generated_method = "76E6836DBB4CE5DE0380E731687BF527")
            @Override
            public Iterator<Map.Entry<K, V>> iterator() {
                Iterator<Map.Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_682678557 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_682678557 = new Iterator<Map.Entry<K, V>>() {
                    Iterator<Map.Entry<K, V>> iterator = c.iterator();
                    @Override public boolean hasNext() {
                        return iterator.hasNext();
                    }
                    @Override public Map.Entry<K, V> next() {
                        return new UnmodifiableMapEntry<K, V>(iterator.next());
                    }
                    @Override public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
                varB4EAC82CA7396A68D541C85D26508E83_682678557.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_682678557;
                
                
                    
                    
                        
                    
                    
                        
                    
                    
                        
                    
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.332 -0400", hash_original_method = "C353E5DD4879B90DAE1A37DDC4A8ED8C", hash_generated_method = "9CCADE93F54E11A80697E2ED3BCC86FB")
            @Override
            public Object[] toArray() {
                Object[] varB4EAC82CA7396A68D541C85D26508E83_991240570 = null; 
                int length = c.size();
                Object[] result = new Object[length];
                Iterator<?> it = iterator();
                {
                    int i = length;
                    {
                        result[i] = it.next();
                    } 
                } 
                varB4EAC82CA7396A68D541C85D26508E83_991240570 = result;
                varB4EAC82CA7396A68D541C85D26508E83_991240570.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_991240570;
                
                
                
                
                
                    
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.332 -0400", hash_original_method = "CB9686BEA448DC0D7D0077DDEB1917CB", hash_generated_method = "1BA62D19FAFEEEB147B30FBF009D418A")
            @SuppressWarnings("unchecked")
            @Override
            public <T> T[] toArray(T[] contents) {
                T[] varB4EAC82CA7396A68D541C85D26508E83_1355485167 = null; 
                int size = c.size();
                int index = 0;
                Iterator<Map.Entry<K, V>> it = iterator();
                {
                    Class<?> ct = contents.getClass().getComponentType();
                    contents = (T[]) Array.newInstance(ct, size);
                } 
                {
                    contents[index++] = (T) it.next();
                } 
                {
                    contents[index] = null;
                } 
                varB4EAC82CA7396A68D541C85D26508E83_1355485167 = contents;
                addTaint(contents[0].getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_1355485167.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_1355485167;
                
                
                
                
                    
                    
                
                
                    
                
                
                    
                
                
            }

            
            private static class UnmodifiableMapEntry<K, V> implements Map.Entry<K, V> {
                @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.332 -0400", hash_original_field = "5B2F0A0A5E89589F62B233C643034719", hash_generated_field = "24589B068FBC99F8ED52DE988ED39319")

                Map.Entry<K, V> mapEntry;
                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.333 -0400", hash_original_method = "E37A4627FD27E632126EED134E00D831", hash_generated_method = "A97AFE882B9E93ECA34E23B05853DCFA")
                  UnmodifiableMapEntry(Map.Entry<K, V> entry) {
                    mapEntry = entry;
                    
                    
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.333 -0400", hash_original_method = "90F914E663E54C2DC9846974DAA2EFB8", hash_generated_method = "97CA5080A05AE8294C378D780DBBBD3D")
                @Override
                public boolean equals(Object object) {
                    boolean var1E6E5EE1426DD4D6EB65B99B916F7467_1947442913 = (mapEntry.equals(object));
                    addTaint(object.getTaint());
                    boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_420365713 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_420365713;
                    
                    
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.334 -0400", hash_original_method = "4DDB57034C15C2636BC5A8AFB2B3C75A", hash_generated_method = "80FA05268DFDFEB893D678662972E779")
                @Override
                public K getKey() {
                    K varB4EAC82CA7396A68D541C85D26508E83_376989862 = null; 
                    varB4EAC82CA7396A68D541C85D26508E83_376989862 = mapEntry.getKey();
                    varB4EAC82CA7396A68D541C85D26508E83_376989862.addTaint(getTaint()); 
                    return varB4EAC82CA7396A68D541C85D26508E83_376989862;
                    
                    
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.335 -0400", hash_original_method = "EA1063FCD9D2F699A9610E0A7FDC81FD", hash_generated_method = "EFB58DA4A88F985521E0762E4C4A08B5")
                @Override
                public V getValue() {
                    V varB4EAC82CA7396A68D541C85D26508E83_883474815 = null; 
                    varB4EAC82CA7396A68D541C85D26508E83_883474815 = mapEntry.getValue();
                    varB4EAC82CA7396A68D541C85D26508E83_883474815.addTaint(getTaint()); 
                    return varB4EAC82CA7396A68D541C85D26508E83_883474815;
                    
                    
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.336 -0400", hash_original_method = "8A31FFFC42BCA6E359386EC1F8534D45", hash_generated_method = "5BB2E49214BE3B8B31CC1E462B601475")
                @Override
                public int hashCode() {
                    int varB4446261767782D97888D65AE62449D4_1497995809 = (mapEntry.hashCode());
                    int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_859732129 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_859732129;
                    
                    
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.337 -0400", hash_original_method = "3526712C126765AF36CB8D920CBD3B1B", hash_generated_method = "1A2319FA1552949A1378D6A672B3348D")
                @Override
                public V setValue(V object) {
                	throw new UnsupportedOperationException();
                    
                    
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.340 -0400", hash_original_method = "514C7E8B8C54DBFDFB3E185BADD6AD0A", hash_generated_method = "9215E10822452E643DA96CC0BBB5F7C3")
                @Override
                public String toString() {
                    String varB4EAC82CA7396A68D541C85D26508E83_309354008 = null; 
                    varB4EAC82CA7396A68D541C85D26508E83_309354008 = mapEntry.toString();
                    varB4EAC82CA7396A68D541C85D26508E83_309354008.addTaint(getTaint()); 
                    return varB4EAC82CA7396A68D541C85D26508E83_309354008;
                    
                    
                }

                
            }


            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.340 -0400", hash_original_field = "B44292591B716EDD855C6E185A9AC989", hash_generated_field = "12B2F4473571AB0F630FC68FA4B581F0")

            private static final long serialVersionUID = 7854390611657943733L;
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.340 -0400", hash_original_field = "5569682F9E1154F1C678E958FEEE9E89", hash_generated_field = "FFB33DF33FB47F4C6369B7156E5B3319")

        private static final long serialVersionUID = -1034234728574286014L;
    }


    
    private static class UnmodifiableSet<E> extends UnmodifiableCollection<E> implements Set<E> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.342 -0400", hash_original_method = "D46A71F25EF02541A08678630568218D", hash_generated_method = "DBD124D7730B2343640D7C872444495D")
          UnmodifiableSet(Set<E> set) {
            super(set);
            addTaint(set.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.342 -0400", hash_original_method = "BB8664F3F5CB90AA83689CAADCD9EA6B", hash_generated_method = "E3725B9A7604BACEC76E29E346D65AF7")
        @Override
        public boolean equals(Object object) {
            boolean var68E706348FF72E55282D2AEF4301CA4B_1837513365 = (c.equals(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_417656259 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_417656259;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.343 -0400", hash_original_method = "E858D80F3EEDE9F2B52CDB7DA7FBF12B", hash_generated_method = "BE69E725E24003FD64A94A08D7800781")
        @Override
        public int hashCode() {
            int var19B3D08FE3840D0D3E365DF71EF3E20C_570296639 = (c.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_426187068 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_426187068;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.343 -0400", hash_original_field = "F3BE7D79D6D6372B9FD4F3861D721F88", hash_generated_field = "E7C72ADB8696D042D902371BEB24646C")

        private static final long serialVersionUID = -9215047833775013803L;
    }


    
    private static class UnmodifiableSortedMap<K, V> extends UnmodifiableMap<K, V> implements SortedMap<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.343 -0400", hash_original_field = "ED79ACB0CD3D7F8320C53C7798335EF0", hash_generated_field = "F813233D7B24D3620137345516D05A23")

        private SortedMap<K, V> sm;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.344 -0400", hash_original_method = "AC9FE01B421B1E54651959AD61521CA6", hash_generated_method = "FE478A77C43C9AB097C4727B1013B70C")
          UnmodifiableSortedMap(SortedMap<K, V> map) {
            super(map);
            sm = map;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.345 -0400", hash_original_method = "E5FDBCC6560BE7E99B2D2F850BD84149", hash_generated_method = "0F74FBB26B2EECDBA80ABE9A674B3DF0")
        @Override
        public Comparator<? super K> comparator() {
            Comparator<? super K> varB4EAC82CA7396A68D541C85D26508E83_1073162260 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1073162260 = sm.comparator();
            varB4EAC82CA7396A68D541C85D26508E83_1073162260.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1073162260;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.345 -0400", hash_original_method = "B25E8C7440C76FBF812FF7AC9CA9D776", hash_generated_method = "B0E7838A423483DAD87C79C51C932374")
        @Override
        public K firstKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_1329706546 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1329706546 = sm.firstKey();
            varB4EAC82CA7396A68D541C85D26508E83_1329706546.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1329706546;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.346 -0400", hash_original_method = "EC6243B190269A05D31802D1260652E4", hash_generated_method = "D35DFB9B91D411B5027575CB584B3618")
        @Override
        public SortedMap<K, V> headMap(K before) {
            SortedMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_445911082 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_445911082 = new UnmodifiableSortedMap<K, V>(sm.headMap(before));
            addTaint(before.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_445911082.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_445911082;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.347 -0400", hash_original_method = "00E9126A84DE8B71214859A17DA6BD2E", hash_generated_method = "FC4A7E13B4E85C7C77FDF05BCEB7277D")
        @Override
        public K lastKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_1262440315 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1262440315 = sm.lastKey();
            varB4EAC82CA7396A68D541C85D26508E83_1262440315.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1262440315;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.348 -0400", hash_original_method = "B6411009D9179ABF4D7755605B648FDC", hash_generated_method = "D1A862A8D3321D3410D36BD522B8ADEC")
        @Override
        public SortedMap<K, V> subMap(K start, K end) {
            SortedMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_2025779599 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2025779599 = new UnmodifiableSortedMap<K, V>(sm.subMap(start, end));
            addTaint(start.getTaint());
            addTaint(end.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2025779599.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2025779599;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.349 -0400", hash_original_method = "59BADF6C5EE68C4E1DB5A6A22818328A", hash_generated_method = "98A92AA04C7049B7F82F7F95665EEF83")
        @Override
        public SortedMap<K, V> tailMap(K after) {
            SortedMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_1919313570 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1919313570 = new UnmodifiableSortedMap<K, V>(sm.tailMap(after));
            addTaint(after.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1919313570.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1919313570;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.349 -0400", hash_original_field = "BB78CEF8331176F8CBF0AFC85E7523D8", hash_generated_field = "74C1A54CA827DD7351FCAD121C86B500")

        private static final long serialVersionUID = -8806743815996713206L;
    }


    
    private static class UnmodifiableSortedSet<E> extends UnmodifiableSet<E> implements SortedSet<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.349 -0400", hash_original_field = "3691308F2A4C2F6983F2880D32E29C84", hash_generated_field = "5220A6F2AA4CB98BB6C290F0BB717E86")

        private SortedSet<E> ss;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.350 -0400", hash_original_method = "232C45C3B4117EB9042FB58E6C0CE113", hash_generated_method = "C02ACFBA00E84FCE033C7CEC6C326A50")
          UnmodifiableSortedSet(SortedSet<E> set) {
            super(set);
            ss = set;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.350 -0400", hash_original_method = "8514D9255D678B041F55D03BA11DCA3B", hash_generated_method = "9BBEE2E2D855DA8E566DF2D7A1DD3A5B")
        @Override
        public Comparator<? super E> comparator() {
            Comparator<? super E> varB4EAC82CA7396A68D541C85D26508E83_292344268 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_292344268 = ss.comparator();
            varB4EAC82CA7396A68D541C85D26508E83_292344268.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_292344268;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.351 -0400", hash_original_method = "6BB6C51843B41CC0DCB5509A79DBA008", hash_generated_method = "7C1BBA70CCC21CAFE99B1CFB1D1C489C")
        @Override
        public E first() {
            E varB4EAC82CA7396A68D541C85D26508E83_1860058459 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1860058459 = ss.first();
            varB4EAC82CA7396A68D541C85D26508E83_1860058459.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1860058459;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.352 -0400", hash_original_method = "74C4BE29898589F7D7948BADA3350612", hash_generated_method = "AD2D164CC2EDD23F7BD6CE9A788EB237")
        @Override
        public SortedSet<E> headSet(E before) {
            SortedSet<E> varB4EAC82CA7396A68D541C85D26508E83_320658847 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_320658847 = new UnmodifiableSortedSet<E>(ss.headSet(before));
            addTaint(before.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_320658847.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_320658847;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.352 -0400", hash_original_method = "AAC5DDE787ACA85752B94AAB77F6B0F8", hash_generated_method = "AC9E0A6D1981CF66265E3DA51738DF41")
        @Override
        public E last() {
            E varB4EAC82CA7396A68D541C85D26508E83_1464323869 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1464323869 = ss.last();
            varB4EAC82CA7396A68D541C85D26508E83_1464323869.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1464323869;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.353 -0400", hash_original_method = "54602835FD774439E48CB96CB67F9D83", hash_generated_method = "48C5D193E218A66FEC9CE13D784C3FF8")
        @Override
        public SortedSet<E> subSet(E start, E end) {
            SortedSet<E> varB4EAC82CA7396A68D541C85D26508E83_1702315914 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1702315914 = new UnmodifiableSortedSet<E>(ss.subSet(start, end));
            addTaint(start.getTaint());
            addTaint(end.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1702315914.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1702315914;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.353 -0400", hash_original_method = "37640609DAC9C9170FD6CBE14C8AD6B6", hash_generated_method = "30B85D8E57266CF554F2C7494AF6EB1A")
        @Override
        public SortedSet<E> tailSet(E after) {
            SortedSet<E> varB4EAC82CA7396A68D541C85D26508E83_280792345 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_280792345 = new UnmodifiableSortedSet<E>(ss.tailSet(after));
            addTaint(after.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_280792345.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_280792345;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.353 -0400", hash_original_field = "A7FEB93E06211B53C8063E2CA4FFCCC4", hash_generated_field = "492EEA3FB02A9A00EAE2EF3419CB36AB")

        private static final long serialVersionUID = -4929149591599911165L;
    }


    
    private static class SetFromMap<E> extends AbstractSet<E> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.353 -0400", hash_original_field = "6F8F57715090DA2632453988D9A1501B", hash_generated_field = "8D1145F106DE5C3E2B790E661BC27C3B")

        private Map<E, Boolean> m;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.353 -0400", hash_original_field = "10AA84685E8BF74D8FA1DED104C25521", hash_generated_field = "75D49D8B030B2438C97CCFE06F0E4EF6")

        private transient Set<E> backingSet;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.354 -0400", hash_original_method = "6B962D990E5B5543C1AA025E18134CE9", hash_generated_method = "68252A5316CF37F1B8C0AF671D9233B5")
          SetFromMap(final Map<E, Boolean> map) {
            m = map;
            backingSet = map.keySet();
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.354 -0400", hash_original_method = "B42E9CA75A778919E90B77D794DBEE82", hash_generated_method = "9719A2CB340D355B27523C53B47B3A2E")
        @Override
        public boolean equals(Object object) {
            boolean var1848766D38374CAEDBF00C0007CDCFC1_1341182426 = (backingSet.equals(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_527863190 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_527863190;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.354 -0400", hash_original_method = "684F9CE738B21B1B45F3304124963EF1", hash_generated_method = "22723DBBDE6FCBA24C6B557891C186D1")
        @Override
        public int hashCode() {
            int var061E95C5D32F56D095B7A80E91EC8A56_1648268707 = (backingSet.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_173748097 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_173748097;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.354 -0400", hash_original_method = "FC84A6CABB16433CF1488E03DF7636C8", hash_generated_method = "4C6105BFE0E5B03B83BF3BF5C54492F3")
        @Override
        public boolean add(E object) {
            boolean var8AF8A0D0EB560BBD1728F96A00026012_1306428652 = (m.put(object, Boolean.TRUE) == null);
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_964969905 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_964969905;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.355 -0400", hash_original_method = "5163CA2ED3AD9C66F2BDAFB902590115", hash_generated_method = "5C1448B76AB003BA7ABB7E55C1011B37")
        @Override
        public void clear() {
            m.clear();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.355 -0400", hash_original_method = "C7069F73CC2FBE59B42FACF6A3731192", hash_generated_method = "A9F02A93A343E409C7D64AA9D7997F66")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1644817759 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1644817759 = backingSet.toString();
            varB4EAC82CA7396A68D541C85D26508E83_1644817759.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1644817759;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.355 -0400", hash_original_method = "C1FDFEBBA860B6E21729D041F83BDE39", hash_generated_method = "DA590DD1083A7F62BC82EFFB16292B25")
        @Override
        public boolean contains(Object object) {
            boolean varD69ECD74FC2F79EA60C338071C7FC221_160386083 = (backingSet.contains(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_394270843 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_394270843;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.356 -0400", hash_original_method = "652D3A93342A70291E00DB196A629050", hash_generated_method = "DC0B2289D4F2C88E065153E31ECAD87B")
        @Override
        public boolean containsAll(Collection<?> collection) {
            boolean var3951AEBB2FFEF521655479A9D2D52542_64660348 = (backingSet.containsAll(collection));
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_583499475 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_583499475;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.356 -0400", hash_original_method = "B9E63D3C52241E7E917CB1416ABA36E5", hash_generated_method = "006BE15B3AA5034B366AFDD6313B00EC")
        @Override
        public boolean isEmpty() {
            boolean var028CF644E61B84328EAB66D556672A81_1610106608 = (m.isEmpty());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_411047921 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_411047921;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.356 -0400", hash_original_method = "20C696E59013C16BDFED7021A5C3E797", hash_generated_method = "CB7D5EA75D13777A706DF9C0669038B5")
        @Override
        public boolean remove(Object object) {
            boolean varEA834B1BBE47D90EDF860853CDE90683_808968116 = (m.remove(object) != null);
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1577510307 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1577510307;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.357 -0400", hash_original_method = "4A27ACEA2C9F194EF4597E8BDECC6BD7", hash_generated_method = "D8FC24C1E1A61DC8866D45C7E50A4D6B")
        @Override
        public boolean retainAll(Collection<?> collection) {
            boolean varF15C5540B964CC478105DE5ACC25B10C_1731184919 = (backingSet.retainAll(collection));
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_686888967 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_686888967;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.357 -0400", hash_original_method = "706FD57EC242D189F78C8F40D764E8D0", hash_generated_method = "77115D149ADA12B993D12EEBFC1D2992")
        @Override
        public Object[] toArray() {
            Object[] varB4EAC82CA7396A68D541C85D26508E83_331957931 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_331957931 = backingSet.toArray();
            varB4EAC82CA7396A68D541C85D26508E83_331957931.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_331957931;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.358 -0400", hash_original_method = "5B684176C593DE73F99AF08724DF65D4", hash_generated_method = "DF625A303B058888E3F081AB381A83A9")
        @Override
        public <T> T[] toArray(T[] contents) {
            T[] varB4EAC82CA7396A68D541C85D26508E83_1452176904 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1452176904 = backingSet.toArray(contents);
            addTaint(contents[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1452176904.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1452176904;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.358 -0400", hash_original_method = "2EC39271104239DED882FB25EFF4BC23", hash_generated_method = "0BCEC44B86492773781098B089FBE7BD")
        @Override
        public Iterator<E> iterator() {
            Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_208644346 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_208644346 = backingSet.iterator();
            varB4EAC82CA7396A68D541C85D26508E83_208644346.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_208644346;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.359 -0400", hash_original_method = "A04EE09DEB6F21FAA6A7E10DF6401CD1", hash_generated_method = "3936863F5BF2E611BE4C007AFD4FB3A0")
        @Override
        public int size() {
            int varDBD6E28F15F3D13B8127CF62DD69ACD5_1382302486 = (m.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_274854924 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_274854924;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.359 -0400", hash_original_method = "8082AE1FFA2825B9433C3082C2F87EDC", hash_generated_method = "22988C980D2DF3F54BA0C1ADFC122910")
        @SuppressWarnings("unchecked")
        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
            stream.defaultReadObject();
            backingSet = m.keySet();
            addTaint(stream.getTaint());
            
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.359 -0400", hash_original_field = "68A2EE38D4624ED7EDE7470F4422D17A", hash_generated_field = "D22893062D677334CA792903B3E2A0BD")

        private static final long serialVersionUID = 2454657854757543876L;
    }


    
    private static class AsLIFOQueue<E> extends AbstractQueue<E> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.360 -0400", hash_original_field = "7694F4A66316E53C8CDD9D9954BD611D", hash_generated_field = "8E692B16EB19650DAECD0B8A91F62E63")

        private Deque<E> q;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.361 -0400", hash_original_method = "C9A3AEFCC3A9FEA0CFED796FADB14DA4", hash_generated_method = "8C725C5253844AF6C1706232C12CC260")
          AsLIFOQueue(final Deque<E> deque) {
            this.q = deque;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.364 -0400", hash_original_method = "D6ABAC5AC9E31C28EFD449012F8C668D", hash_generated_method = "D699AEA72D35FB4A6A252F5CAE20DCE0")
        @Override
        public Iterator<E> iterator() {
            Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_1819339670 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1819339670 = q.iterator();
            varB4EAC82CA7396A68D541C85D26508E83_1819339670.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1819339670;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.365 -0400", hash_original_method = "4D120CFD44D3EE91A03411EED1F5CA02", hash_generated_method = "50C34EC6D13EDD16812CD2B01728BB34")
        @Override
        public int size() {
            int var8E6A4AAEA94D20962C54C20127D7D8DC_1740382406 = (q.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1249321442 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1249321442;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.366 -0400", hash_original_method = "A29AB2808D45581589F8B0269F283532", hash_generated_method = "41BEB2CD3087C63F670D24ABCBFA41C8")
        @Override
        public boolean offer(E o) {
            boolean var131D1A648D23B0B634478E3172B0A3D9_2124723139 = (q.offerFirst(o));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_156993328 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_156993328;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.367 -0400", hash_original_method = "286FFABBC697C1CEE6C49194F85DD481", hash_generated_method = "97C5C2715F788522E9634F486043899A")
        @Override
        public E peek() {
            E varB4EAC82CA7396A68D541C85D26508E83_347115376 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_347115376 = q.peekFirst();
            varB4EAC82CA7396A68D541C85D26508E83_347115376.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_347115376;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.368 -0400", hash_original_method = "93EF986205EA0EFDB6E2F2BDD9DDBDB0", hash_generated_method = "A96B4A0D7B8093989D113F049AFB6179")
        @Override
        public E poll() {
            E varB4EAC82CA7396A68D541C85D26508E83_1848873618 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1848873618 = q.pollFirst();
            varB4EAC82CA7396A68D541C85D26508E83_1848873618.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1848873618;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.369 -0400", hash_original_method = "E16BCF0F708E6336497510D255228AB4", hash_generated_method = "1B4298A1A46CAC9EF51BDB3F6C81558E")
        @Override
        public boolean add(E o) {
            q.push(o);
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1518213141 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1518213141;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.369 -0400", hash_original_method = "ECF3C7555AB121202E1C39938D734656", hash_generated_method = "72AFA896F4EE9665FC95334E69A68411")
        @Override
        public void clear() {
            q.clear();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.370 -0400", hash_original_method = "41C0874A8589B77FE1309E3303509F6A", hash_generated_method = "84FA4F4551BF55EDC196AF7C022D80C3")
        @Override
        public E element() {
            E varB4EAC82CA7396A68D541C85D26508E83_286559447 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_286559447 = q.getFirst();
            varB4EAC82CA7396A68D541C85D26508E83_286559447.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_286559447;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.371 -0400", hash_original_method = "DBCAD9866D0C084DC455BF7C95ABCE77", hash_generated_method = "53F53379431146966FD4BFDEBBB937B0")
        @Override
        public E remove() {
            E varB4EAC82CA7396A68D541C85D26508E83_158369240 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_158369240 = q.pop();
            varB4EAC82CA7396A68D541C85D26508E83_158369240.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_158369240;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.372 -0400", hash_original_method = "2E730D7ABEE184A9C34DA57DF7A457EE", hash_generated_method = "9E60B0A0D2F82548501F1F9124B42FDB")
        @Override
        public boolean contains(Object object) {
            boolean varD460130636362755C09A666172F1A628_280164119 = (q.contains(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1761881323 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1761881323;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.373 -0400", hash_original_method = "3E9E9A2983E74090844621EE9CF6D3D7", hash_generated_method = "691360F50C95E1A277F67E3362BE670E")
        @Override
        public boolean containsAll(Collection<?> collection) {
            boolean varDE8FC932F21B2025BA6D50595BD45CF0_825948156 = (q.containsAll(collection));
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1709756377 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1709756377;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.373 -0400", hash_original_method = "3014069A2B40728BACBB472823CCCF21", hash_generated_method = "6A534D7A7A79D25713FFAC3466B12212")
        @Override
        public boolean isEmpty() {
            boolean varFE3524B5D20384639CE6FC4B24FAEE92_1293164517 = (q.isEmpty());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1003459647 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1003459647;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.373 -0400", hash_original_method = "06C06D3351623BFF7BABDE8B40334F59", hash_generated_method = "934B6B4CC36FF439DB2A883EC4400574")
        @Override
        public boolean remove(Object object) {
            boolean var430DB2157F91E84964C83805E66926D1_296860267 = (q.remove(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_233919691 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_233919691;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.374 -0400", hash_original_method = "13975D6542267AD488C8D9B27A0905D7", hash_generated_method = "30541980CC7D58714FB00A1B8FD2953B")
        @Override
        public boolean removeAll(Collection<?> collection) {
            boolean varA36A955574116D3C6092CC37D2496B72_1827091295 = (q.removeAll(collection));
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_96261939 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_96261939;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.374 -0400", hash_original_method = "029F8EE40CDE382EFA7F7BF13B8FE731", hash_generated_method = "523CA044411E3FD868CDEBA6418A8FDB")
        @Override
        public boolean retainAll(Collection<?> collection) {
            boolean varF8C783496DD8D05EB5484CABE3DF69DA_2082168596 = (q.retainAll(collection));
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1436777078 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1436777078;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.375 -0400", hash_original_method = "81809EBBF1D8298961C4E9B761FEF748", hash_generated_method = "A93EF497443E051660C1740DD9424AD3")
        @Override
        public Object[] toArray() {
            Object[] varB4EAC82CA7396A68D541C85D26508E83_1457950883 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1457950883 = q.toArray();
            varB4EAC82CA7396A68D541C85D26508E83_1457950883.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1457950883;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.375 -0400", hash_original_method = "3C7918E789D95B2A97E0F45A2E8277E0", hash_generated_method = "FDFAC4207A23F4DAFD6C39A22C806963")
        @Override
        public <T> T[] toArray(T[] contents) {
            T[] varB4EAC82CA7396A68D541C85D26508E83_2029235655 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2029235655 = q.toArray(contents);
            addTaint(contents[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2029235655.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2029235655;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.376 -0400", hash_original_method = "827F98847BB1D6CEA3B0A324A45F92ED", hash_generated_method = "EA08217F0EE7EA8EB8BE442E671B67DF")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_361903019 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_361903019 = q.toString();
            varB4EAC82CA7396A68D541C85D26508E83_361903019.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_361903019;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.376 -0400", hash_original_field = "7C5B063F84AD7FF4280E3FC6C2D641FE", hash_generated_field = "4687D2B0166F4A9C03E2417C41443082")

        private static final long serialVersionUID = 1802017725587941708L;
    }


    
    private static class CheckedCollection<E> implements Collection<E>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.376 -0400", hash_original_field = "4A8A08F09D37B73795649038408B5F33", hash_generated_field = "A3C80A7E02E49F20400373DFBAF9696A")

        Collection<E> c;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.376 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "D40602D541C2081B4D03EEADC8718DAD")

        Class<E> type;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.376 -0400", hash_original_method = "4DAA5B7D63536360D367B6279A6FD0F0", hash_generated_method = "7A376838DD673D1FBA51D92C8AABBFD1")
        public  CheckedCollection(Collection<E> c, Class<E> type) {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } 
            this.c = c;
            this.type = type;
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.376 -0400", hash_original_method = "AC97C28F724592ABA809E2470D95C119", hash_generated_method = "27D7C4F86E1F7C09F66BDC1AD9F3A537")
        @Override
        public int size() {
            int varC247C84593AA6020ED979B19566D13FE_641154083 = (c.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_255666441 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_255666441;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.377 -0400", hash_original_method = "F9A3CB1FB7570D28EBE20660E2FC6F42", hash_generated_method = "63E5328BF0330A32DC9DBA91703BCFA0")
        @Override
        public boolean isEmpty() {
            boolean var528EAD02A70F822F393BB0C54FBB923C_724056453 = (c.isEmpty());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_625681718 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_625681718;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.377 -0400", hash_original_method = "AA502F510015E56A50E854673F52B13D", hash_generated_method = "FE17D8D05D2F5CD291964793170E7B63")
        @Override
        public boolean contains(Object obj) {
            boolean var9701AC7B8B31DABE176EC8837E090033_146621372 = (c.contains(obj));
            addTaint(obj.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_876446317 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_876446317;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.378 -0400", hash_original_method = "A49A579D720F57F247BFFB420B912FC7", hash_generated_method = "6E1E882F2D46D8FA6ECD44734D4F14EA")
        @Override
        public Iterator<E> iterator() {
            Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_1478493336 = null; 
            Iterator<E> i = c.iterator();
            {
                i = new CheckedListIterator<E>((ListIterator<E>) i, type);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1478493336 = i;
            varB4EAC82CA7396A68D541C85D26508E83_1478493336.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1478493336;
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.379 -0400", hash_original_method = "89D7D02A9D2BDF31E775C08108CBDE5B", hash_generated_method = "F6652AC0272BCE64542D912B939D0377")
        @Override
        public Object[] toArray() {
            Object[] varB4EAC82CA7396A68D541C85D26508E83_1501268076 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1501268076 = c.toArray();
            varB4EAC82CA7396A68D541C85D26508E83_1501268076.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1501268076;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.379 -0400", hash_original_method = "9B8166862C116AE305DE64E80811892F", hash_generated_method = "B7BE6491FE4FB112B16D1136BD8306DE")
        @Override
        public <T> T[] toArray(T[] arr) {
            T[] varB4EAC82CA7396A68D541C85D26508E83_585829662 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_585829662 = c.toArray(arr);
            addTaint(arr[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_585829662.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_585829662;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.380 -0400", hash_original_method = "233202E3883C87159328A7DF45C5A0DD", hash_generated_method = "D6FF8A24FD2A6417A68D8FB0FC27F549")
        @Override
        public boolean add(E obj) {
            boolean var7C3742253C6BF2735A6EB74A5190709F_987909873 = (c.add(checkType(obj, type)));
            addTaint(obj.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1168764013 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1168764013;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.380 -0400", hash_original_method = "A7C1CDA142B015DD1AAB47325584260A", hash_generated_method = "DA4C5E448342C8736C887EE3F611D55E")
        @Override
        public boolean remove(Object obj) {
            boolean varA24294D934B215AF55F3D7CE5097D547_1042426772 = (c.remove(obj));
            addTaint(obj.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_861830182 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_861830182;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.380 -0400", hash_original_method = "8A54483E259CA6D3C8AB1EBE7493D296", hash_generated_method = "5C917018ADD53C4742FEFCB020F663C7")
        @Override
        public boolean containsAll(Collection<?> c1) {
            boolean varFFF4D0CC6EA0E1A2D080D41D81BC6C1F_769917715 = (c.containsAll(c1));
            addTaint(c1.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1548871371 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1548871371;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.384 -0400", hash_original_method = "A2391F235E9474A0C2FADB6F2C5C2AB0", hash_generated_method = "125D896529B17FAD6A4C54FC118A7A18")
        @SuppressWarnings("unchecked")
        @Override
        public boolean addAll(Collection<? extends E> c1) {
            Object[] array = c1.toArray();
            {
                Object o = array[0];
                {
                    checkType(o, type);
                } 
            } 
            boolean var4F43D86A78906FAA31F77A4D0C40B6E3_1530505080 = (c.addAll((List<E>) Arrays.asList(array)));
            addTaint(c1.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_688737952 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_688737952;
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.385 -0400", hash_original_method = "E5A4F3F5A50F475A125F07680365C964", hash_generated_method = "E2BC2BBA1CB7E133A0CC6D924D7531D7")
        @Override
        public boolean removeAll(Collection<?> c1) {
            boolean var6FAA02017CB91A1460E8557E32B16FBC_1558170189 = (c.removeAll(c1));
            addTaint(c1.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_372169235 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_372169235;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.386 -0400", hash_original_method = "2CCBBE73D1665A80965D3FA8CB644A3B", hash_generated_method = "AE003DAF3DA1BFF19A6F7C8FFBB05C85")
        @Override
        public boolean retainAll(Collection<?> c1) {
            boolean var1BAABDC5B6ADB4CC0AE277B58A4293BA_161584140 = (c.retainAll(c1));
            addTaint(c1.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1720361397 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1720361397;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.387 -0400", hash_original_method = "C75B179C04D460F62AB7F39D0D292067", hash_generated_method = "A8F69290363AB2D00FEDD4A5A3BF8CF2")
        @Override
        public void clear() {
            c.clear();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.389 -0400", hash_original_method = "424D4966F358AE6553349A6493C21674", hash_generated_method = "421D71E5C087CBD26F54B6E8145E27DA")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_484229916 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_484229916 = c.toString();
            varB4EAC82CA7396A68D541C85D26508E83_484229916.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_484229916;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.389 -0400", hash_original_field = "19984F6C6BA7815BBDF7C18EF9C975B4", hash_generated_field = "0D42B7BF026634D153E28C472B065A0D")

        private static final long serialVersionUID = 1578914078182001775L;
    }


    
    private static class CheckedListIterator<E> implements ListIterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.389 -0400", hash_original_field = "865C0C0B4AB0E063E5CAA3387C1A8741", hash_generated_field = "A3E111A0B732842F8B9E259D3903708E")

        private ListIterator<E> i;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.389 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "44DD73C068DAE541C380477699D61FAF")

        private Class<E> type;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.390 -0400", hash_original_method = "0B7AAA10EE83BBF7A614BF8D8C7A7C84", hash_generated_method = "8BB9DF0BD458C6C58CAD8ED7A978114C")
        public  CheckedListIterator(ListIterator<E> i, Class<E> type) {
            this.i = i;
            this.type = type;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.391 -0400", hash_original_method = "59CA86A80410B66286C92523CF35EC7B", hash_generated_method = "2091ACE85578AFE4677A5F39086A3567")
        @Override
        public boolean hasNext() {
            boolean var1611849CD1EE22EA22E4E7E3327E2E35_1659796377 = (i.hasNext());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_586393896 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_586393896;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.392 -0400", hash_original_method = "A2FD0994E634C5BCE4D27AD9176E9A5A", hash_generated_method = "1BB0EDC8173AE60CD957C1D93412805B")
        @Override
        public E next() {
            E varB4EAC82CA7396A68D541C85D26508E83_1278282939 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1278282939 = i.next();
            varB4EAC82CA7396A68D541C85D26508E83_1278282939.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1278282939;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.392 -0400", hash_original_method = "048FA6C3E3A28865AD880AF8A3FCAE96", hash_generated_method = "598E37F558FC71BB5A0DA7BBE13EE694")
        @Override
        public void remove() {
            i.remove();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.393 -0400", hash_original_method = "BBFFF3658F03DC70BAED5B88BBE801F9", hash_generated_method = "70E2A5C78135CF7CD42AA141C9722652")
        @Override
        public boolean hasPrevious() {
            boolean var1FCC7ECF60E98FFA6572F3122E374C7E_612081480 = (i.hasPrevious());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1016288699 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1016288699;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.395 -0400", hash_original_method = "BC73D9B40C1A828CB3DD11A00CF4E28D", hash_generated_method = "708E7F0968C38D60F56A8D74F910AEF7")
        @Override
        public E previous() {
            E varB4EAC82CA7396A68D541C85D26508E83_1267660590 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1267660590 = i.previous();
            varB4EAC82CA7396A68D541C85D26508E83_1267660590.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1267660590;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.395 -0400", hash_original_method = "E41D02CE1A7D09C2351DC91043CD0C1F", hash_generated_method = "A68AD897FA24530A51F4BC527CBD68A0")
        @Override
        public int nextIndex() {
            int var97CCB58C3C2141B73F996BC540E6EAF5_1226453066 = (i.nextIndex());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1080924515 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1080924515;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.396 -0400", hash_original_method = "F0908B37AEEE31348E4E446BDB2DC11E", hash_generated_method = "55099DAE4364651592FB7254F46422F2")
        @Override
        public int previousIndex() {
            int var9F734927211780D2EA84E984ED22702D_1901884575 = (i.previousIndex());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1333011681 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1333011681;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.396 -0400", hash_original_method = "F06067E5C50A33BA33028ACBB7E94E5C", hash_generated_method = "8CAFD41758A91E7AEC87DE235FEEAD5B")
        @Override
        public void set(E obj) {
            i.set(checkType(obj, type));
            addTaint(obj.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.397 -0400", hash_original_method = "3A7C6206CDBE5C448C8E83D10145E877", hash_generated_method = "CB1ACD56A14B73EB8E1500AEF3BEBC77")
        @Override
        public void add(E obj) {
            i.add(checkType(obj, type));
            addTaint(obj.getTaint());
            
            
        }

        
    }


    
    private static class CheckedList<E> extends CheckedCollection<E> implements List<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.397 -0400", hash_original_field = "2DB95E8E1A9267B7A1188556B2013B33", hash_generated_field = "BA44D98E464F3917B2E777BB565BC0D3")

        List<E> l;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.397 -0400", hash_original_method = "50AAAF0EF026911FE0274184FEF9C1C3", hash_generated_method = "5D3DF5FB69105266A81A924324B66768")
        public  CheckedList(List<E> l, Class<E> type) {
            super(l, type);
            this.l = l;
            addTaint(type.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.400 -0400", hash_original_method = "8A1A291116E92C540879607029C861C6", hash_generated_method = "B9D071DD3B43CEF4E1A018A25DA7BD9B")
        @SuppressWarnings("unchecked")
        @Override
        public boolean addAll(int index, Collection<? extends E> c1) {
            Object[] array = c1.toArray();
            {
                Object o = array[0];
                {
                    checkType(o, type);
                } 
            } 
            boolean var720AF4600E5540369BE417DBAEE92DFA_678626549 = (l.addAll(index, (List<E>) Arrays.asList(array)));
            addTaint(index);
            addTaint(c1.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_8049906 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_8049906;
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.402 -0400", hash_original_method = "12BB9FAB0B921E0E98205977740A217D", hash_generated_method = "25B4C7310CBF7DFA7CD498EE271A4BC7")
        @Override
        public E get(int index) {
            E varB4EAC82CA7396A68D541C85D26508E83_1558487876 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1558487876 = l.get(index);
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_1558487876.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1558487876;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.404 -0400", hash_original_method = "B15A1B3ABEAB19644273A7FDAFDFF4C3", hash_generated_method = "7B40E315851EDD96FC352CE1748FD354")
        @Override
        public E set(int index, E obj) {
            E varB4EAC82CA7396A68D541C85D26508E83_1651524530 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1651524530 = l.set(index, checkType(obj, type));
            addTaint(index);
            addTaint(obj.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1651524530.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1651524530;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.404 -0400", hash_original_method = "97AC3A6F1A8F1F91D88637C439308CAA", hash_generated_method = "52B4CEA0E1571112BDBE5428D02E17E5")
        @Override
        public void add(int index, E obj) {
            l.add(index, checkType(obj, type));
            addTaint(index);
            addTaint(obj.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.405 -0400", hash_original_method = "B7A754E9641B79EF3AC643C6FA162631", hash_generated_method = "3FCB12EC2949CF5C20739D0C31BFBCF7")
        @Override
        public E remove(int index) {
            E varB4EAC82CA7396A68D541C85D26508E83_304576585 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_304576585 = l.remove(index);
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_304576585.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_304576585;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.405 -0400", hash_original_method = "EB95E25E6439350950712FBE2C177EC4", hash_generated_method = "A7F28065F661989C323D2EDE1C68C7CC")
        @Override
        public int indexOf(Object obj) {
            int varBB0CC98524B808CD822A2164B51F33B8_827061190 = (l.indexOf(obj));
            addTaint(obj.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1295712219 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1295712219;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.406 -0400", hash_original_method = "4C828EC3A9818E335BF8E9F8513B24F5", hash_generated_method = "1B56AE96876386C20BF9A2F4BEB0EB9B")
        @Override
        public int lastIndexOf(Object obj) {
            int var68D523AC731688651041C374F25CAB09_566429163 = (l.lastIndexOf(obj));
            addTaint(obj.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1394504595 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1394504595;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.406 -0400", hash_original_method = "9293980ECFF31B033CDADFB0ED26EA69", hash_generated_method = "74705421132CBA6B5380B7669A3AFDB8")
        @Override
        public ListIterator<E> listIterator() {
            ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_1294975390 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1294975390 = new CheckedListIterator<E>(l.listIterator(), type);
            varB4EAC82CA7396A68D541C85D26508E83_1294975390.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1294975390;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.406 -0400", hash_original_method = "31D39D7FEEE82D7A15D00B805CB5EAA4", hash_generated_method = "98C2976B4752DA2DF3F78697A670E219")
        @Override
        public ListIterator<E> listIterator(int index) {
            ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_1250169173 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1250169173 = new CheckedListIterator<E>(l.listIterator(index), type);
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_1250169173.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1250169173;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.407 -0400", hash_original_method = "A5E1EFD4B2650099AC132BF86B97D88F", hash_generated_method = "9E2B532046DCECCF21A6E034C8C3B6D0")
        @Override
        public List<E> subList(int fromIndex, int toIndex) {
            List<E> varB4EAC82CA7396A68D541C85D26508E83_957598719 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_957598719 = checkedList(l.subList(fromIndex, toIndex), type);
            addTaint(fromIndex);
            addTaint(toIndex);
            varB4EAC82CA7396A68D541C85D26508E83_957598719.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_957598719;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.407 -0400", hash_original_method = "A14AE2E014BAD465F594EE49A5008ED4", hash_generated_method = "A389A205B2436A4D3F9D012CF4E36B9B")
        @Override
        public boolean equals(Object obj) {
            boolean var559B3B39BC42D814993568E544C6FE1F_770655647 = (l.equals(obj));
            addTaint(obj.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1362191497 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1362191497;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.407 -0400", hash_original_method = "410D1D1B2E05F678DF3AB7D6BB08AEDB", hash_generated_method = "F03776F1B725EAB87146D036F648ED1C")
        @Override
        public int hashCode() {
            int var283F03AD18DE255D000FAC9E62BDE6F0_1336538636 = (l.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_927843078 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_927843078;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.407 -0400", hash_original_field = "39F320D681E769EFF91E942BCC4C3E88", hash_generated_field = "872FF792DF349B762724C98686FE9FD7")

        private static final long serialVersionUID = 65247728283967356L;
    }


    
    private static class CheckedRandomAccessList<E> extends CheckedList<E> implements RandomAccess {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.408 -0400", hash_original_method = "77F175BCE2CEB5DECA5010A8855616A0", hash_generated_method = "6A34077878FEA1687712F87D427AF583")
        public  CheckedRandomAccessList(List<E> l, Class<E> type) {
            super(l, type);
            addTaint(l.getTaint());
            addTaint(type.getTaint());
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.408 -0400", hash_original_field = "27B375DBE9246C47DAC482882EF8DD4B", hash_generated_field = "AE05DA4DC0253A1B88798E9C56DCC885")

        private static final long serialVersionUID = 1638200125423088369L;
    }


    
    private static class CheckedSet<E> extends CheckedCollection<E> implements Set<E> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.408 -0400", hash_original_method = "515963C9B1280D5707D3A720329B0AC0", hash_generated_method = "34498A77713E1963E42E5270114D0C84")
        public  CheckedSet(Set<E> s, Class<E> type) {
            super(s, type);
            addTaint(s.getTaint());
            addTaint(type.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.409 -0400", hash_original_method = "F33AC6E694EC5A5F3A81FF749707DDFC", hash_generated_method = "FE9E14454E8A0617AEF78637CE8DCE3F")
        @Override
        public boolean equals(Object obj) {
            boolean varC91792C7DD4F0C8E92E42617036EED48_869190086 = (c.equals(obj));
            addTaint(obj.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1145259409 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1145259409;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.409 -0400", hash_original_method = "E858D80F3EEDE9F2B52CDB7DA7FBF12B", hash_generated_method = "CD7B4DAA9B88419CABAB2501099BE42E")
        @Override
        public int hashCode() {
            int var19B3D08FE3840D0D3E365DF71EF3E20C_2108732295 = (c.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1578304211 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1578304211;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.409 -0400", hash_original_field = "C306DCFF324211BB06F1EDC3B62DB01C", hash_generated_field = "E1E04526085CC70B98A324ECDFB31198")

        private static final long serialVersionUID = 4694047833775013803L;
    }


    
    private static class CheckedMap<K, V> implements Map<K, V>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.409 -0400", hash_original_field = "6F8F57715090DA2632453988D9A1501B", hash_generated_field = "B770F05C5A3A992B6F65D731F667A79E")

        Map<K, V> m;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.409 -0400", hash_original_field = "056E0360B75D77ECE0AE955FE59BF15D", hash_generated_field = "F010784A251FB129AC47F47773283FBF")

        Class<K> keyType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.409 -0400", hash_original_field = "B96763B95160CC0943BE0DE4743A115B", hash_generated_field = "DE39CA4821E18DB5E7A7F09BBC028CB4")

        Class<V> valueType;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.410 -0400", hash_original_method = "906A4960963B0F972E50BE617CA562B3", hash_generated_method = "8450A17B2A66D687691112D6942B9B1A")
        private  CheckedMap(Map<K, V> m, Class<K> keyType, Class<V> valueType) {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } 
            this.m = m;
            this.keyType = keyType;
            this.valueType = valueType;
            
            
                
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.411 -0400", hash_original_method = "A04EE09DEB6F21FAA6A7E10DF6401CD1", hash_generated_method = "ABA9B3E493D4856904C7DAE3B9CC3F61")
        @Override
        public int size() {
            int varDBD6E28F15F3D13B8127CF62DD69ACD5_1233652238 = (m.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1456724329 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1456724329;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.411 -0400", hash_original_method = "B9E63D3C52241E7E917CB1416ABA36E5", hash_generated_method = "896D8A2018E4343B2D6859B2A970E22B")
        @Override
        public boolean isEmpty() {
            boolean var028CF644E61B84328EAB66D556672A81_898933794 = (m.isEmpty());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_939195073 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_939195073;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.412 -0400", hash_original_method = "A6C730848D8A626F99D8229EE744E3C0", hash_generated_method = "3B5DBDF638EB655473C61268D2AC2F1E")
        @Override
        public boolean containsKey(Object key) {
            boolean var2519B7EF565FEC21B6285F5E44AC148E_2026993348 = (m.containsKey(key));
            addTaint(key.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1780804328 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1780804328;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.414 -0400", hash_original_method = "EF8C00CF950E8C186D2F05E1E556F384", hash_generated_method = "7542DADCE079D25B573238ACCB8DA711")
        @Override
        public boolean containsValue(Object value) {
            boolean varF8CB74E2C5E0734947B397D82173BDD4_1587582092 = (m.containsValue(value));
            addTaint(value.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1591904924 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1591904924;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.417 -0400", hash_original_method = "B8FE254B61C57EC3A6DCE539976DA268", hash_generated_method = "6B8461C107627A0127FD06A454FAF723")
        @Override
        public V get(Object key) {
            V varB4EAC82CA7396A68D541C85D26508E83_1125750666 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1125750666 = m.get(key);
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1125750666.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1125750666;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.419 -0400", hash_original_method = "98010DFF1DD51631676FCAC604C1B694", hash_generated_method = "B11C13E84AE13B1FD761165707822F56")
        @Override
        public V put(K key, V value) {
            V varB4EAC82CA7396A68D541C85D26508E83_1233644426 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1233644426 = m.put(checkType(key, keyType), checkType(value, valueType));
            addTaint(key.getTaint());
            addTaint(value.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1233644426.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1233644426;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.420 -0400", hash_original_method = "7E1C4ABAB7F4D30C9FA02B8AC4206202", hash_generated_method = "CDB87819B7C79B2308DB1C883B7C779C")
        @Override
        public V remove(Object key) {
            V varB4EAC82CA7396A68D541C85D26508E83_1264180341 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1264180341 = m.remove(key);
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1264180341.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1264180341;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.420 -0400", hash_original_method = "7B09FD67E4091CD76439ADACD213D3A2", hash_generated_method = "685B2E1D08414686BCF2DEB4BB8601A3")
        @SuppressWarnings("unchecked")
        @Override
        public void putAll(Map<? extends K, ? extends V> map) {
            int size = map.size();
            Map.Entry<? extends K, ? extends V>[] entries = new Map.Entry[size];
            Iterator<? extends Map.Entry<? extends K, ? extends V>> it = map
                    .entrySet().iterator();
            {
                int i = 0;
                {
                    Map.Entry<? extends K, ? extends V> e = it.next();
                    checkType(e.getKey(), keyType);
                    checkType(e.getValue(), valueType);
                    entries[i] = e;
                } 
            } 
            {
                int i = 0;
                {
                    m.put(entries[i].getKey(), entries[i].getValue());
                } 
            } 
            addTaint(map.getTaint());
            
            
            
                
            
            
            
                    
            
                
                
                
                
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.421 -0400", hash_original_method = "5163CA2ED3AD9C66F2BDAFB902590115", hash_generated_method = "5C1448B76AB003BA7ABB7E55C1011B37")
        @Override
        public void clear() {
            m.clear();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.422 -0400", hash_original_method = "BC85ABF91A39D98F3F2ED0838950D9FC", hash_generated_method = "ED0B55A59459C1E6D3FF163EA0E07A79")
        @Override
        public Set<K> keySet() {
            Set<K> varB4EAC82CA7396A68D541C85D26508E83_146347113 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_146347113 = m.keySet();
            varB4EAC82CA7396A68D541C85D26508E83_146347113.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_146347113;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.423 -0400", hash_original_method = "F6584059741E2818D171714370ED56BF", hash_generated_method = "BB02B060AFAD248EC6A96CC0FFFD744B")
        @Override
        public Collection<V> values() {
            Collection<V> varB4EAC82CA7396A68D541C85D26508E83_1449176390 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1449176390 = m.values();
            varB4EAC82CA7396A68D541C85D26508E83_1449176390.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1449176390;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.425 -0400", hash_original_method = "17C87BFAA3247941C0F3FE3FCE6C8B6B", hash_generated_method = "B122B7684766BB2F28B09F3E70494FD2")
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_1232670491 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1232670491 = new CheckedEntrySet<K, V>(m.entrySet(), valueType);
            varB4EAC82CA7396A68D541C85D26508E83_1232670491.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1232670491;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.425 -0400", hash_original_method = "5F45CB6F19E1E41DEEA3711399B994B8", hash_generated_method = "3EBA6E643CB1927ED47976F005167E6F")
        @Override
        public boolean equals(Object obj) {
            boolean var6519380B8603327E1D0BBD66320BEF0F_917855477 = (m.equals(obj));
            addTaint(obj.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1452970595 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1452970595;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.426 -0400", hash_original_method = "E3229E3389F030DD50B79734943DB788", hash_generated_method = "FEB67661357A5D0B5C27871A8241079B")
        @Override
        public int hashCode() {
            int varAA1293165230C9829C1AEACFFF576DFC_291710615 = (m.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_60506140 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_60506140;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.426 -0400", hash_original_method = "5DD44B3CD2826BF39F974F66579CF74F", hash_generated_method = "30BBF66F8BA89B1BB4EA6B4E92B5E3ED")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_723714724 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_723714724 = m.toString();
            varB4EAC82CA7396A68D541C85D26508E83_723714724.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_723714724;
            
            
        }

        
        private static class CheckedEntry<K, V> implements Map.Entry<K, V> {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.427 -0400", hash_original_field = "E1671797C52E15F763380B45E841EC32", hash_generated_field = "FD10A3858A638ACB828326F81BE2C88B")

            Map.Entry<K, V> e;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.427 -0400", hash_original_field = "B96763B95160CC0943BE0DE4743A115B", hash_generated_field = "DE39CA4821E18DB5E7A7F09BBC028CB4")

            Class<V> valueType;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.427 -0400", hash_original_method = "7A5E92C112A4AAE1EEB574291E4B57B6", hash_generated_method = "F20992E3708DE849084FDE77877EB9F1")
            public  CheckedEntry(Map.Entry<K, V> e, Class<V> valueType) {
                {
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
                } 
                this.e = e;
                this.valueType = valueType;
                
                
                    
                
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.428 -0400", hash_original_method = "10D87C621F2656D3DA7DCE234A4C3FAC", hash_generated_method = "597B14C1C6C47DDC7837E3C6B2E0CC87")
            @Override
            public K getKey() {
                K varB4EAC82CA7396A68D541C85D26508E83_124508168 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_124508168 = e.getKey();
                varB4EAC82CA7396A68D541C85D26508E83_124508168.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_124508168;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.428 -0400", hash_original_method = "8EF21B2292AA31AAE181B3282F3F0262", hash_generated_method = "12C1267CC104C83310899332492DEEF7")
            @Override
            public V getValue() {
                V varB4EAC82CA7396A68D541C85D26508E83_366433393 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_366433393 = e.getValue();
                varB4EAC82CA7396A68D541C85D26508E83_366433393.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_366433393;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.429 -0400", hash_original_method = "22C63BC622BE9DF4D2BED624BDB5B6B5", hash_generated_method = "77FB9318F82DEBE7F0956CD37B9A0271")
            @Override
            public V setValue(V obj) {
                V varB4EAC82CA7396A68D541C85D26508E83_1625010887 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_1625010887 = e.setValue(checkType(obj, valueType));
                addTaint(obj.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_1625010887.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_1625010887;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.429 -0400", hash_original_method = "0FE63D6CB37B8BF21266876509A7EAAA", hash_generated_method = "D2BB0E5F8D02C103B22EE906A552EE33")
            @Override
            public boolean equals(Object obj) {
                boolean var5F98FA9F6CA964453675BAF27F4B0002_688122258 = (e.equals(obj));
                addTaint(obj.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1727639558 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1727639558;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.430 -0400", hash_original_method = "02C3AF7FB3CFA22B693B83D22D208AF4", hash_generated_method = "46301576E6C70D7BED9B3F678E1D5600")
            @Override
            public int hashCode() {
                int varB0D5769FD2A442E362DC4438ABD8230C_1154569933 = (e.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1074257212 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1074257212;
                
                
            }

            
        }


        
        private static class CheckedEntrySet<K, V> implements Set<Map.Entry<K, V>> {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.430 -0400", hash_original_field = "03C7C0ACE395D80182DB07AE2C30F034", hash_generated_field = "00162E30A8FD9ACC3B5664D702737B9D")

            Set<Map.Entry<K, V>> s;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.430 -0400", hash_original_field = "B96763B95160CC0943BE0DE4743A115B", hash_generated_field = "DE39CA4821E18DB5E7A7F09BBC028CB4")

            Class<V> valueType;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.430 -0400", hash_original_method = "77FA7326B6BB5621E7FE63699FC58F08", hash_generated_method = "B92FFB70DAF3A02ECD73F8C030E830C0")
            public  CheckedEntrySet(Set<Map.Entry<K, V>> s, Class<V> valueType) {
                this.s = s;
                this.valueType = valueType;
                
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.431 -0400", hash_original_method = "448F3F9279BA75C161BF1A7F97E105A4", hash_generated_method = "236663B6E2B73C7EA0FDE0E515FCC3E7")
            @Override
            public Iterator<Map.Entry<K, V>> iterator() {
                Iterator<Map.Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_1937390880 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_1937390880 = new CheckedEntryIterator<K, V>(s.iterator(), valueType);
                varB4EAC82CA7396A68D541C85D26508E83_1937390880.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_1937390880;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.432 -0400", hash_original_method = "0FB4B292E50A952F877CB518E0A96CF9", hash_generated_method = "9ED6DA99839E4954287A0D0181ECC780")
            @Override
            public Object[] toArray() {
                Object[] varB4EAC82CA7396A68D541C85D26508E83_30918473 = null; 
                int thisSize = size();
                Object[] array = new Object[thisSize];
                Iterator<?> it = iterator();
                {
                    int i = 0;
                    {
                        array[i] = it.next();
                    } 
                } 
                varB4EAC82CA7396A68D541C85D26508E83_30918473 = array;
                varB4EAC82CA7396A68D541C85D26508E83_30918473.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_30918473;
                
                
                
                
                
                    
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.433 -0400", hash_original_method = "C1CA1F6CAFA571422DF3592838D87C35", hash_generated_method = "F268F9739BFEED6576019A14A24E87C1")
            @SuppressWarnings("unchecked")
            @Override
            public <T> T[] toArray(T[] array) {
                T[] varB4EAC82CA7396A68D541C85D26508E83_1246664879 = null; 
                int thisSize = size();
                {
                    Class<?> ct = array.getClass().getComponentType();
                    array = (T[]) Array.newInstance(ct, thisSize);
                } 
                Iterator<?> it = iterator();
                {
                    int i = 0;
                    {
                        array[i] = (T) it.next();
                    } 
                } 
                {
                    array[thisSize] = null;
                } 
                varB4EAC82CA7396A68D541C85D26508E83_1246664879 = array;
                addTaint(array[0].getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_1246664879.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_1246664879;
                
                
                
                    
                    
                
                
                
                    
                
                
                    
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.434 -0400", hash_original_method = "C32F0C36534158E273107417143214BD", hash_generated_method = "C5550D7F274BD8E74BF526E1AC3AFFFA")
            @Override
            public boolean retainAll(Collection<?> c) {
                boolean var5CB6111A304F8110F244B25FAFD11216_889762266 = (s.retainAll(c));
                addTaint(c.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1026788418 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1026788418;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.435 -0400", hash_original_method = "B2624C46EA911C8D7CBCD3DB1975A601", hash_generated_method = "59B1DECAD6A7B3C3591D103E70BB2B6D")
            @Override
            public boolean removeAll(Collection<?> c) {
                boolean var9FB36AF651B537108EEB0474A946606A_1180006032 = (s.removeAll(c));
                addTaint(c.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_725090727 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_725090727;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.437 -0400", hash_original_method = "D8F4D306F45D40205BDE17116DDFF9FA", hash_generated_method = "48B786FE79D6A37181DE5B413DB511F9")
            @Override
            public boolean containsAll(Collection<?> c) {
                boolean var13D8B720D63124262C076810AF3BA42D_526706267 = (s.containsAll(c));
                addTaint(c.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_191242905 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_191242905;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.439 -0400", hash_original_method = "0D1A7F281A8819D32245C163B79E338D", hash_generated_method = "173D8CAFFA979DBB717F5F150E9F4CB9")
            @Override
            public boolean addAll(Collection<? extends Map.Entry<K, V>> c) {
                if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
                addTaint(c.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1005308872 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1005308872;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.440 -0400", hash_original_method = "46F35AD7CAD80E45E374449F130E7D0D", hash_generated_method = "728CB4D93790F381B86127AD0F5B86CA")
            @Override
            public boolean remove(Object o) {
                boolean varDCAB2EB8C531AB1E623FFAD695CFD286_148495468 = (s.remove(o));
                addTaint(o.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_640403942 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_640403942;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.440 -0400", hash_original_method = "A91421BB58ED7F6569B24AAD1B5804AB", hash_generated_method = "276F400728E5BC3776B2568513A263BB")
            @Override
            public boolean contains(Object o) {
                boolean var42C44FAC187AFC4735D76D5B7760F520_458808033 = (s.contains(o));
                addTaint(o.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_412948894 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_412948894;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.441 -0400", hash_original_method = "8704A9C8AC3AA02909B00E4E211C4D3E", hash_generated_method = "F42BDBAE747A979C2504FD34E8617B02")
            @Override
            public boolean add(Map.Entry<K, V> o) {
                if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
                addTaint(o.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1495853696 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1495853696;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.442 -0400", hash_original_method = "1DB64DC7E3E98DAB777752CA6247DAE5", hash_generated_method = "E51C69BD0C4AA68F9A6CA668F3D746D3")
            @Override
            public boolean isEmpty() {
                boolean var33F6A8EED6267D5B4CCD3EAC631C616A_426067973 = (s.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_378256051 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_378256051;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.443 -0400", hash_original_method = "3294D1F2516BD356F42ED84BE178EFCB", hash_generated_method = "8CAFCFFD1A3B734527CE3A6B8BDDA468")
            @Override
            public void clear() {
                s.clear();
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.443 -0400", hash_original_method = "61480F19A13469EF561F92E5A3700C23", hash_generated_method = "A1C9079FD9FC7902C90A101831A4281D")
            @Override
            public int size() {
                int var8151828880546AEA1C19BE7C52EE5E09_1580806500 = (s.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1432156876 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1432156876;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.444 -0400", hash_original_method = "150ADDC982A3B6D8A573E663C38A7C9E", hash_generated_method = "44E849A6408E7CB5751FE258F1A28824")
            @Override
            public int hashCode() {
                int varE2FC7D6C989F81F3F30CE1BE213D1E3F_2114234662 = (s.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1746960721 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1746960721;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.445 -0400", hash_original_method = "2565EBD5FCFC00F10C086CB36B3EEE8C", hash_generated_method = "0255FEA777069CD467526ABE9FBF7E42")
            @Override
            public boolean equals(Object object) {
                boolean varB696C6744E5DE06D0B58A4DB8EE26D83_2124506673 = (s.equals(object));
                addTaint(object.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1309344284 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1309344284;
                
                
            }

            
            private static class CheckedEntryIterator<K, V> implements Iterator<Map.Entry<K, V>> {
                @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.445 -0400", hash_original_field = "865C0C0B4AB0E063E5CAA3387C1A8741", hash_generated_field = "0B0E1D6BACD1F756FB2A478A3878B968")

                Iterator<Map.Entry<K, V>> i;
                @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.445 -0400", hash_original_field = "B96763B95160CC0943BE0DE4743A115B", hash_generated_field = "DE39CA4821E18DB5E7A7F09BBC028CB4")

                Class<V> valueType;
                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.446 -0400", hash_original_method = "3CE5E36A95DFE16D33C2CC4176CB7EE4", hash_generated_method = "A4AE63E616DC64A732B8C1B01DFD5833")
                public  CheckedEntryIterator(Iterator<Map.Entry<K, V>> i,
                        Class<V> valueType) {
                    this.i = i;
                    this.valueType = valueType;
                    
                    
                    
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.446 -0400", hash_original_method = "59CA86A80410B66286C92523CF35EC7B", hash_generated_method = "AF5127D67DB96FEF77FD9A732F83291E")
                @Override
                public boolean hasNext() {
                    boolean var048C390D087BEDAABDA4F669A9DA628E_1070484121 = (i.hasNext());
                    boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2072687645 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_2072687645;
                    
                    
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.447 -0400", hash_original_method = "048FA6C3E3A28865AD880AF8A3FCAE96", hash_generated_method = "598E37F558FC71BB5A0DA7BBE13EE694")
                @Override
                public void remove() {
                    i.remove();
                    
                    
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.447 -0400", hash_original_method = "4D16E0BB01C90351B8312D1A4B7DB5F2", hash_generated_method = "AF8908010A8E1F576827CEE86FEDD456")
                @Override
                public Map.Entry<K, V> next() {
                    Map.Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1261423997 = null; 
                    varB4EAC82CA7396A68D541C85D26508E83_1261423997 = new CheckedEntry<K, V>(i.next(), valueType);
                    varB4EAC82CA7396A68D541C85D26508E83_1261423997.addTaint(getTaint()); 
                    return varB4EAC82CA7396A68D541C85D26508E83_1261423997;
                    
                    
                }

                
            }


            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.447 -0400", hash_original_field = "3AB92C151F5D124E5C475918FE5C2CE3", hash_generated_field = "9F44A98BA336AC9320984E43122649C3")

        private static final long serialVersionUID = 5742860141034234728L;
    }


    
    private static class CheckedSortedSet<E> extends CheckedSet<E> implements SortedSet<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.448 -0400", hash_original_field = "3691308F2A4C2F6983F2880D32E29C84", hash_generated_field = "5220A6F2AA4CB98BB6C290F0BB717E86")

        private SortedSet<E> ss;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.448 -0400", hash_original_method = "70499BD9B05065D265D741875DD058CA", hash_generated_method = "4EA08511A3F1AC6F4E1992BAD4189CCA")
        public  CheckedSortedSet(SortedSet<E> s, Class<E> type) {
            super(s, type);
            this.ss = s;
            addTaint(type.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.448 -0400", hash_original_method = "8514D9255D678B041F55D03BA11DCA3B", hash_generated_method = "B6C4771AD5771370073DD301B020F186")
        @Override
        public Comparator<? super E> comparator() {
            Comparator<? super E> varB4EAC82CA7396A68D541C85D26508E83_1838047120 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1838047120 = ss.comparator();
            varB4EAC82CA7396A68D541C85D26508E83_1838047120.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1838047120;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.449 -0400", hash_original_method = "82539AB1166DFBB28D0E3DC3D0A43121", hash_generated_method = "367C51E43BDB78E5E2C35C046DF9BE8D")
        @Override
        public SortedSet<E> subSet(E fromElement, E toElement) {
            SortedSet<E> varB4EAC82CA7396A68D541C85D26508E83_1359462010 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1359462010 = new CheckedSortedSet<E>(ss.subSet(fromElement, toElement),
                    type);
            addTaint(fromElement.getTaint());
            addTaint(toElement.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1359462010.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1359462010;
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.449 -0400", hash_original_method = "68D546866615C37E07B8E968E3813E84", hash_generated_method = "F43BC5C40E829095910FD1032DE4AD48")
        @Override
        public SortedSet<E> headSet(E toElement) {
            SortedSet<E> varB4EAC82CA7396A68D541C85D26508E83_1022082257 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1022082257 = new CheckedSortedSet<E>(ss.headSet(toElement), type);
            addTaint(toElement.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1022082257.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1022082257;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.450 -0400", hash_original_method = "B0B4B667BF95B9D9A3CD3F7FE8BEFA1B", hash_generated_method = "78CE3FF0946EE47A19E5F52A6089468E")
        @Override
        public SortedSet<E> tailSet(E fromElement) {
            SortedSet<E> varB4EAC82CA7396A68D541C85D26508E83_1862286996 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1862286996 = new CheckedSortedSet<E>(ss.tailSet(fromElement), type);
            addTaint(fromElement.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1862286996.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1862286996;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.450 -0400", hash_original_method = "6BB6C51843B41CC0DCB5509A79DBA008", hash_generated_method = "567232A4718D41FF7A8E4A8DFF6D0432")
        @Override
        public E first() {
            E varB4EAC82CA7396A68D541C85D26508E83_1657011994 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1657011994 = ss.first();
            varB4EAC82CA7396A68D541C85D26508E83_1657011994.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1657011994;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.451 -0400", hash_original_method = "AAC5DDE787ACA85752B94AAB77F6B0F8", hash_generated_method = "96A97BBEB60A18459F4A64F2D4B0E5F5")
        @Override
        public E last() {
            E varB4EAC82CA7396A68D541C85D26508E83_1648212256 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1648212256 = ss.last();
            varB4EAC82CA7396A68D541C85D26508E83_1648212256.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1648212256;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.451 -0400", hash_original_field = "45BA83A718F7437B80255AD942C73A67", hash_generated_field = "EFEBE119B7009CBFA7ED7A5DC59F8042")

        private static final long serialVersionUID = 1599911165492914959L;
    }


    
    private static class CheckedSortedMap<K, V> extends CheckedMap<K, V> implements SortedMap<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.451 -0400", hash_original_field = "ED79ACB0CD3D7F8320C53C7798335EF0", hash_generated_field = "41E5EF207399B1082121011C1EB446FF")

        SortedMap<K, V> sm;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.451 -0400", hash_original_method = "2CB6EA0E6447E5AAF8B28B5FDF140BE4", hash_generated_method = "8C004DA654C6552CFBB98F0821546043")
          CheckedSortedMap(SortedMap<K, V> m, Class<K> keyType, Class<V> valueType) {
            super(m, keyType, valueType);
            this.sm = m;
            addTaint(keyType.getTaint());
            addTaint(valueType.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.452 -0400", hash_original_method = "E5FDBCC6560BE7E99B2D2F850BD84149", hash_generated_method = "59D43CFD4544AF1689567AFB2487EEF5")
        @Override
        public Comparator<? super K> comparator() {
            Comparator<? super K> varB4EAC82CA7396A68D541C85D26508E83_1892675153 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1892675153 = sm.comparator();
            varB4EAC82CA7396A68D541C85D26508E83_1892675153.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1892675153;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.452 -0400", hash_original_method = "65DE11E398BB209CD2689071C041161A", hash_generated_method = "779BE6F1A001A6DFE1982F5E793F3D5A")
        @Override
        public SortedMap<K, V> subMap(K fromKey, K toKey) {
            SortedMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_642349574 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_642349574 = new CheckedSortedMap<K, V>(sm.subMap(fromKey, toKey), keyType, valueType);
            addTaint(fromKey.getTaint());
            addTaint(toKey.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_642349574.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_642349574;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.453 -0400", hash_original_method = "2C5724B582D2FAB5716323DB894A671D", hash_generated_method = "C92EC3423236AF2C96A11C27FDE423C5")
        @Override
        public SortedMap<K, V> headMap(K toKey) {
            SortedMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_253814347 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_253814347 = new CheckedSortedMap<K, V>(sm.headMap(toKey), keyType, valueType);
            addTaint(toKey.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_253814347.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_253814347;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.454 -0400", hash_original_method = "2879524DD09B17D2FCB7AD1626D24618", hash_generated_method = "B7A344660D4FB4812683B54D22450817")
        @Override
        public SortedMap<K, V> tailMap(K fromKey) {
            SortedMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_955416550 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_955416550 = new CheckedSortedMap<K, V>(sm.tailMap(fromKey), keyType, valueType);
            addTaint(fromKey.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_955416550.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_955416550;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.455 -0400", hash_original_method = "B25E8C7440C76FBF812FF7AC9CA9D776", hash_generated_method = "E853C99846F0D22575FDC6771312438C")
        @Override
        public K firstKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_835416369 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_835416369 = sm.firstKey();
            varB4EAC82CA7396A68D541C85D26508E83_835416369.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_835416369;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.456 -0400", hash_original_method = "00E9126A84DE8B71214859A17DA6BD2E", hash_generated_method = "B75F3CC208F0E19692E5B24E10B29431")
        @Override
        public K lastKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_1106364668 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1106364668 = sm.lastKey();
            varB4EAC82CA7396A68D541C85D26508E83_1106364668.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1106364668;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.456 -0400", hash_original_field = "4011ADBAF6264DE3F59FECC188B42ACB", hash_generated_field = "48CAB95B26D6FD20C5A6CF4DE2F667C3")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.459 -0400", hash_original_field = "E5D97468931D831222F89B33B06414C4", hash_generated_field = "1967470EF0F42FDB7D6E965615F956D6")

    @SuppressWarnings("unchecked")
    public static final List EMPTY_LIST = new EmptyList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.459 -0400", hash_original_field = "19637326155AD7B58E274FC2717EADC0", hash_generated_field = "EF8031119D3626285E32D155A57C6695")

    @SuppressWarnings("unchecked")
    public static final Set EMPTY_SET = new EmptySet();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.459 -0400", hash_original_field = "712F6D9422DE94FBE0F2A8F69D9E29D0", hash_generated_field = "F465655F33C72E2E2F297BFA1010664E")

    @SuppressWarnings("unchecked")
    public static final Map EMPTY_MAP = new EmptyMap();
}

