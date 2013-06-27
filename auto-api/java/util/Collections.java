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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.251 -0400", hash_original_method = "0C1BC548FC19EEB6A684F12763720939", hash_generated_method = "F5EC8594995493427AAF50F2EB8C349F")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.324 -0400", hash_original_field = "7B8B965AD4BCA0E41AB51DE7B31363A1", hash_generated_field = "01825CC32046BF0FBE11738ABC136518")

        private int n;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.324 -0400", hash_original_field = "8E2DCFD7E7E24B1CA76C1193F645902B", hash_generated_field = "93B043155067F80D0269375649E4D7D4")

        private E element;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.325 -0400", hash_original_method = "5A122D173062D06824D4571736320F87", hash_generated_method = "332F4CC6EB56BB16F20F69E656CBAAF8")
          CopiesList(int length, E object) {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.325 -0400", hash_original_method = "B07BCF81C9C48C72A08077A0468A8769", hash_generated_method = "F4A90EB183160BD396C7CAD75C7205F1")
        @Override
        public boolean contains(Object object) {
            {
                Object var918C716CCB523821E4DE921B4E432F42_805103461 = (element.equals(object));
            } //End flattened ternary
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_739099622 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_739099622;
            // ---------- Original Method ----------
            //return element == null ? object == null : element.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.325 -0400", hash_original_method = "61094B9B9DEC6161E82512577FAF3323", hash_generated_method = "544C69A8CD81C881C2EE0BBA49BA8EEE")
        @Override
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_13829013 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_13829013;
            // ---------- Original Method ----------
            //return n;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.326 -0400", hash_original_method = "857A70B35DA7146CF7ADC484EC4AABC8", hash_generated_method = "243B377082DAF80B75B10C38A4F9ABE6")
        @Override
        public E get(int location) {
            E varB4EAC82CA7396A68D541C85D26508E83_1714277785 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_1714277785 = element;
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            addTaint(location);
            varB4EAC82CA7396A68D541C85D26508E83_1714277785.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1714277785;
            // ---------- Original Method ----------
            //if (location >= 0 && location < n) {
                //return element;
            //}
            //throw new IndexOutOfBoundsException();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.333 -0400", hash_original_field = "6A61C247691E7C356BC04B2E9E793190", hash_generated_field = "51DD40AC1BF487C48DC188E284D62BA6")

        private static long serialVersionUID = 2739099268398711800L;
    }


    
    private static final class EmptyList extends AbstractList implements RandomAccess, Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.333 -0400", hash_original_method = "BF3F11B0BCAE2AE80C7C74CBEB88EB5B", hash_generated_method = "BF3F11B0BCAE2AE80C7C74CBEB88EB5B")
        public EmptyList ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.334 -0400", hash_original_method = "38B750FD34BF6CB1144CDF020D3299E6", hash_generated_method = "D74B87C730B647D045DC6C234C12E30D")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1231336118 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1231336118;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.335 -0400", hash_original_method = "F4586E3A64B5D10DEB709A723C85E55E", hash_generated_method = "007F33EC650B349EEBD51CF4179EC905")
        @Override
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1823071098 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1823071098;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.335 -0400", hash_original_method = "F59F44D1664BC2EE59D5A9B30D144285", hash_generated_method = "A8C1E569381DF357B1DAF3DEDBCE876B")
        @Override
        public Object get(int location) {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            addTaint(location);
            // ---------- Original Method ----------
            //throw new IndexOutOfBoundsException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.335 -0400", hash_original_method = "3CB4CAF1EADC3F12C565BD7D2B5F5514", hash_generated_method = "25784C3E8AB0E388EFD347E734B03B7C")
        private Object readResolve() {
            Object varB4EAC82CA7396A68D541C85D26508E83_2081203387 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2081203387 = Collections.EMPTY_LIST;
            varB4EAC82CA7396A68D541C85D26508E83_2081203387.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2081203387;
            // ---------- Original Method ----------
            //return Collections.EMPTY_LIST;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.335 -0400", hash_original_field = "FEEABBF180D6F8A042B90CBFA55A4A94", hash_generated_field = "D4821F58F340DEF9C551710D53D4346E")

        private static long serialVersionUID = 8842843931221139166L;
    }


    
    private static final class EmptySet extends AbstractSet implements Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.336 -0400", hash_original_method = "3A37381B9598D46CF46D5D53F85DF5B1", hash_generated_method = "3A37381B9598D46CF46D5D53F85DF5B1")
        public EmptySet ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.336 -0400", hash_original_method = "38B750FD34BF6CB1144CDF020D3299E6", hash_generated_method = "58B27A60BF892AFD03F51E7EE9E12F83")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_101449793 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_101449793;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.336 -0400", hash_original_method = "F4586E3A64B5D10DEB709A723C85E55E", hash_generated_method = "5BA79499BDFF40D584F06B2BF20C8011")
        @Override
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1235746447 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1235746447;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.349 -0400", hash_original_method = "FC88A4B2F50E498E162F3F7EEDE885B1", hash_generated_method = "F1FFE65AADB71D3E98324943E6EAB6C9")
        @Override
        public Iterator iterator() {
            Iterator varB4EAC82CA7396A68D541C85D26508E83_2000054919 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2000054919 = EMPTY_ITERATOR;
            varB4EAC82CA7396A68D541C85D26508E83_2000054919.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2000054919;
            // ---------- Original Method ----------
            //return EMPTY_ITERATOR;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.350 -0400", hash_original_method = "2ED0845ADEAE5655731C197578B08F82", hash_generated_method = "E38A174277DB67788E6D0D794255ECA4")
        private Object readResolve() {
            Object varB4EAC82CA7396A68D541C85D26508E83_29358539 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_29358539 = Collections.EMPTY_SET;
            varB4EAC82CA7396A68D541C85D26508E83_29358539.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_29358539;
            // ---------- Original Method ----------
            //return Collections.EMPTY_SET;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.351 -0400", hash_original_field = "EBC69A53BFBAE35613EC4BD95CB98F92", hash_generated_field = "05BD3AF517071804E9469DA21BD9AAE3")

        private static long serialVersionUID = 1582296315990362920L;
    }


    
    private static final class EmptyMap extends AbstractMap implements Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.351 -0400", hash_original_method = "0E8F36F90F9C751DA5A12903A16705DF", hash_generated_method = "0E8F36F90F9C751DA5A12903A16705DF")
        public EmptyMap ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.351 -0400", hash_original_method = "2AD0E7E75E88E287D6229481B74BEBCC", hash_generated_method = "9C06CA8B8FF225A9BF735213EDD54968")
        @Override
        public boolean containsKey(Object key) {
            addTaint(key.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1649565198 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1649565198;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.353 -0400", hash_original_method = "9D32B6FFC088649ED5480F6E533A1288", hash_generated_method = "8EB18F3AF9D088259AAB0ED58CD378A8")
        @Override
        public boolean containsValue(Object value) {
            addTaint(value.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2000205579 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2000205579;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.360 -0400", hash_original_method = "709DD403C63D2F4104FF93FEEB6E3457", hash_generated_method = "00217C510DD412F80076DFE7F0F4BC70")
        @Override
        public Set entrySet() {
            Set varB4EAC82CA7396A68D541C85D26508E83_547777438 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_547777438 = EMPTY_SET;
            varB4EAC82CA7396A68D541C85D26508E83_547777438.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_547777438;
            // ---------- Original Method ----------
            //return EMPTY_SET;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.361 -0400", hash_original_method = "59A1188DDD48CFFB749850DC2DA09C1D", hash_generated_method = "88772B1344FCDED81EBE1D2FDAF3CCA1")
        @Override
        public Object get(Object key) {
            Object varB4EAC82CA7396A68D541C85D26508E83_1847405579 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1847405579 = null;
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1847405579.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1847405579;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.373 -0400", hash_original_method = "266B164C16644761E32491964C192EB7", hash_generated_method = "C356BA548C68C84D43E61756D9181B02")
        @Override
        public Set keySet() {
            Set varB4EAC82CA7396A68D541C85D26508E83_1149249935 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1149249935 = EMPTY_SET;
            varB4EAC82CA7396A68D541C85D26508E83_1149249935.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1149249935;
            // ---------- Original Method ----------
            //return EMPTY_SET;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.374 -0400", hash_original_method = "745E6E226DD5F7D4E763DA74DFF70792", hash_generated_method = "356FBD64EF95B63AE45046F5B8026CA9")
        @Override
        public Collection values() {
            Collection varB4EAC82CA7396A68D541C85D26508E83_1230032194 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1230032194 = EMPTY_LIST;
            varB4EAC82CA7396A68D541C85D26508E83_1230032194.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1230032194;
            // ---------- Original Method ----------
            //return EMPTY_LIST;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.374 -0400", hash_original_method = "59A22E9415A338EB85D7A7DD214359CC", hash_generated_method = "3F97E802BBFAE55DCF36CD05DBD07230")
        private Object readResolve() {
            Object varB4EAC82CA7396A68D541C85D26508E83_1880635815 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1880635815 = Collections.EMPTY_MAP;
            varB4EAC82CA7396A68D541C85D26508E83_1880635815.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1880635815;
            // ---------- Original Method ----------
            //return Collections.EMPTY_MAP;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.374 -0400", hash_original_field = "71F087EB1E9FCDB60C678B95061CEBBD", hash_generated_field = "CB3012AFD32CA96D2DE9D9201475BE21")

        private static long serialVersionUID = 6428348081105594320L;
    }


    
    private static final class ReverseComparator<T> implements Comparator<T>, Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.375 -0400", hash_original_method = "FFB2FB11DBE006893CA9746ECCE68517", hash_generated_method = "FFB2FB11DBE006893CA9746ECCE68517")
        public ReverseComparator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.375 -0400", hash_original_method = "907488F1D5625FE5C9F59ED8A7B6E697", hash_generated_method = "5C777EBAE6D521C94B2018E1EAFEEB60")
        @SuppressWarnings("unchecked")
        @Override
        public int compare(T o1, T o2) {
            Comparable<T> c2;
            c2 = (Comparable<T>) o2;
            int var692167FC6770150DF2B5DF91BFB83EC2_1132811916 = (c2.compareTo(o1));
            addTaint(o1.getTaint());
            addTaint(o2.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_385962888 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_385962888;
            // ---------- Original Method ----------
            //Comparable<T> c2 = (Comparable<T>) o2;
            //return c2.compareTo(o1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.375 -0400", hash_original_method = "DD371F0FDF8300FDCFBD1E5C395D42BC", hash_generated_method = "55748A670670B93F8D3C9D15363E368D")
        private Object readResolve() throws ObjectStreamException {
            Object varB4EAC82CA7396A68D541C85D26508E83_81346032 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_81346032 = INSTANCE;
            varB4EAC82CA7396A68D541C85D26508E83_81346032.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_81346032;
            // ---------- Original Method ----------
            //return INSTANCE;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.375 -0400", hash_original_field = "2B003AD2E801398B9507D8ADBBB584A6", hash_generated_field = "FD09203CF293DCF576A151FB2E3FAA8B")

        private static ReverseComparator<Object> INSTANCE = new ReverseComparator<Object>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.375 -0400", hash_original_field = "844E6A53F14D8AD803480DAA1F2399E0", hash_generated_field = "84BF5E9BC7C3C37BB9951FC0167E20F4")

        private static long serialVersionUID = 7207038068494060240L;
    }


    
    private static final class ReverseComparator2<T> implements Comparator<T>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.375 -0400", hash_original_field = "31B4E550AA5FD883246F9B9CEAE82483", hash_generated_field = "ACD6D4A2528BA4BAF7406DE3D3F49FE6")

        private Comparator<T> cmp;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.376 -0400", hash_original_method = "1ABA0972F29BDB004C28A1246ABEF788", hash_generated_method = "B92E5576724AB283C109FF5B16A47456")
          ReverseComparator2(Comparator<T> comparator) {
            this.cmp = comparator;
            // ---------- Original Method ----------
            //this.cmp = comparator;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.376 -0400", hash_original_method = "449D1B24DD0E97F4D53DEB786BD04597", hash_generated_method = "D8772F8185BF9A1DBB3621DF763D78CE")
        @Override
        public int compare(T o1, T o2) {
            int varC3FAEC3684B290716428C4AB73BA307C_1749440336 = (cmp.compare(o2, o1));
            addTaint(o1.getTaint());
            addTaint(o2.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_359042068 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_359042068;
            // ---------- Original Method ----------
            //return cmp.compare(o2, o1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.376 -0400", hash_original_method = "30689CAB8FBFDCB9289EF03377EE08A0", hash_generated_method = "88BCA6B5CDE5ED98347AAB99A37C1D62")
        @Override
        public boolean equals(Object o) {
            boolean varB42AC7AE9468AAA515C4B77EBD2F7BC7_964061979 = (o instanceof ReverseComparator2
                    && ((ReverseComparator2) o).cmp.equals(cmp));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1347154365 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1347154365;
            // ---------- Original Method ----------
            //return o instanceof ReverseComparator2
                    //&& ((ReverseComparator2) o).cmp.equals(cmp);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.383 -0400", hash_original_method = "CAA612A5887D060562790EB1CDD1FEFE", hash_generated_method = "B560A3FADA69B12499E85F8A93C6F6F3")
        @Override
        public int hashCode() {
            int varFAD4BDCF5F08AFF151A94355744A94BB_1394391815 = (~cmp.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1730412652 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1730412652;
            // ---------- Original Method ----------
            //return ~cmp.hashCode();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.383 -0400", hash_original_field = "C2743FD0D0E256493E9B52C087283254", hash_generated_field = "D91F4B39733605415D2BC1EABB0A7C71")

        private static long serialVersionUID = 4374092139857L;
    }


    
    private static final class SingletonSet<E> extends AbstractSet<E> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.383 -0400", hash_original_field = "8E2DCFD7E7E24B1CA76C1193F645902B", hash_generated_field = "AADC7BC67B0FB6048E4A856A581BAEE9")

        E element;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.384 -0400", hash_original_method = "044BE6981927B9234E2AE8686E07A72F", hash_generated_method = "08623BAB02DDA909B203E3610F71957D")
          SingletonSet(E object) {
            element = object;
            // ---------- Original Method ----------
            //element = object;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.384 -0400", hash_original_method = "B07BCF81C9C48C72A08077A0468A8769", hash_generated_method = "4BE59DD608B0DA2B5D398D19E3C3441B")
        @Override
        public boolean contains(Object object) {
            {
                Object var918C716CCB523821E4DE921B4E432F42_912152365 = (element.equals(object));
            } //End flattened ternary
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_341983562 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_341983562;
            // ---------- Original Method ----------
            //return element == null ? object == null : element.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.385 -0400", hash_original_method = "798A0AE2F2A6352396904AB5C9ED97D5", hash_generated_method = "B7C99C30AB83CA1C15B389EF0075A905")
        @Override
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_163633676 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_163633676;
            // ---------- Original Method ----------
            //return 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.392 -0400", hash_original_method = "135AC18A6A8AD4548E2E750F2D4C7699", hash_generated_method = "5E88DB52A5D07DE75A115E0A45DC8DDC")
        @Override
        public Iterator<E> iterator() {
            Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_286586439 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_286586439 = new Iterator<E>() {
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
            varB4EAC82CA7396A68D541C85D26508E83_286586439.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_286586439;
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.392 -0400", hash_original_field = "C80162DD8B57D34236F77D8F8A87A897", hash_generated_field = "A78776FFC0262E99D899928EA9BF3BAA")

        private static long serialVersionUID = 3193687207550431679L;
    }


    
    private static final class SingletonList<E> extends AbstractList<E> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.400 -0400", hash_original_field = "8E2DCFD7E7E24B1CA76C1193F645902B", hash_generated_field = "AADC7BC67B0FB6048E4A856A581BAEE9")

        E element;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.401 -0400", hash_original_method = "F3174A5FA7BA5962D109EAC3245F2C1D", hash_generated_method = "6BE55179558843F3290CC42091204DF4")
          SingletonList(E object) {
            element = object;
            // ---------- Original Method ----------
            //element = object;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.411 -0400", hash_original_method = "B07BCF81C9C48C72A08077A0468A8769", hash_generated_method = "AE00C134944F0DEEF0825E0775A19B0B")
        @Override
        public boolean contains(Object object) {
            {
                Object var918C716CCB523821E4DE921B4E432F42_1345109064 = (element.equals(object));
            } //End flattened ternary
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_449509524 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_449509524;
            // ---------- Original Method ----------
            //return element == null ? object == null : element.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.414 -0400", hash_original_method = "1C6E7D1EB082158D5E00EA29E883A612", hash_generated_method = "EBC8BC51706AA679CB5D036DBAED0FCA")
        @Override
        public E get(int location) {
            E varB4EAC82CA7396A68D541C85D26508E83_1674328227 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_1674328227 = element;
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            addTaint(location);
            varB4EAC82CA7396A68D541C85D26508E83_1674328227.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1674328227;
            // ---------- Original Method ----------
            //if (location == 0) {
                //return element;
            //}
            //throw new IndexOutOfBoundsException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.421 -0400", hash_original_method = "798A0AE2F2A6352396904AB5C9ED97D5", hash_generated_method = "D8D9AC6D48E94B662D11B993DE9E1B1A")
        @Override
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1635434437 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1635434437;
            // ---------- Original Method ----------
            //return 1;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.421 -0400", hash_original_field = "136A37A5852F7DE7150E3A4BC9F06AE5", hash_generated_field = "D432E1220EA28F82711737177832355A")

        private static long serialVersionUID = 3093736618740652951L;
    }


    
    private static final class SingletonMap<K, V> extends AbstractMap<K, V> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.421 -0400", hash_original_field = "8CE4B16B22B58894AA86C421E8759DF3", hash_generated_field = "052F80594ED04BACBC2E98744BD4CC2D")

        K k;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.421 -0400", hash_original_field = "9E3669D19B675BD57058FD4664205D2A", hash_generated_field = "3A278B3CDA0FEEA24CB626A0B3136D0B")

        V v;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.424 -0400", hash_original_method = "85D3D420EE431E7A3C1CBFB71D1CEAE2", hash_generated_method = "942C300AA2E111086F3B6C3DFB936BBB")
          SingletonMap(K key, V value) {
            k = key;
            v = value;
            // ---------- Original Method ----------
            //k = key;
            //v = value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.428 -0400", hash_original_method = "26D5E87A2C62405ADA3B15C5C8B30FEC", hash_generated_method = "E08A1D9079071068F65EADA438720897")
        @Override
        public boolean containsKey(Object key) {
            {
                Object var0EB569FD4AF21D116A21E287F6027A39_2075124654 = (k.equals(key));
            } //End flattened ternary
            addTaint(key.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_865756599 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_865756599;
            // ---------- Original Method ----------
            //return k == null ? key == null : k.equals(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.429 -0400", hash_original_method = "827D42B4F919454EC51CA86D0E534994", hash_generated_method = "98B4650D494AB03E0DB14A87024A1092")
        @Override
        public boolean containsValue(Object value) {
            {
                Object var1F74AE50105434A557EE1F3FD50522E7_1039177024 = (v.equals(value));
            } //End flattened ternary
            addTaint(value.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_592728431 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_592728431;
            // ---------- Original Method ----------
            //return v == null ? value == null : v.equals(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.430 -0400", hash_original_method = "8C587096F5E6029DBB187C58CF22D158", hash_generated_method = "1D26DDEE87243E9D24BC0B61F54E8EE2")
        @Override
        public V get(Object key) {
            V varB4EAC82CA7396A68D541C85D26508E83_1242892479 = null; //Variable for return #1
            V varB4EAC82CA7396A68D541C85D26508E83_447723211 = null; //Variable for return #2
            {
                boolean varD8EB9E9C73E773501877E01187F3B5DA_1329212623 = (containsKey(key));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1242892479 = v;
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_447723211 = null;
            addTaint(key.getTaint());
            V varA7E53CE21691AB073D9660D615818899_1683613786; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1683613786 = varB4EAC82CA7396A68D541C85D26508E83_1242892479;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1683613786 = varB4EAC82CA7396A68D541C85D26508E83_447723211;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1683613786.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1683613786;
            // ---------- Original Method ----------
            //if (containsKey(key)) {
                //return v;
            //}
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.446 -0400", hash_original_method = "798A0AE2F2A6352396904AB5C9ED97D5", hash_generated_method = "D3FAE8F95C86369B6F40BDE3AD32A772")
        @Override
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_656805315 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_656805315;
            // ---------- Original Method ----------
            //return 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.447 -0400", hash_original_method = "AB4A6E093F1AE40B73184C21F1D08E5E", hash_generated_method = "741226737840812C38C3CDC3345EC092")
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_65186046 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_65186046 = new AbstractSet<Map.Entry<K, V>>() {
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
            varB4EAC82CA7396A68D541C85D26508E83_65186046.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_65186046;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.447 -0400", hash_original_field = "9848B8101686634CF12341A29DB1F062", hash_generated_field = "DB7FFD9D9765DB790A815F6BB1A64934")

        private static long serialVersionUID = -6979724477215052911L;
    }


    
    static class SynchronizedCollection<E> implements Collection<E>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.447 -0400", hash_original_field = "4A8A08F09D37B73795649038408B5F33", hash_generated_field = "A3C80A7E02E49F20400373DFBAF9696A")

        Collection<E> c;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.447 -0400", hash_original_field = "25A01BB859125507013A2FE9737D3C32", hash_generated_field = "5C5F8780FECE5E612AF5A86D3A8B3194")

        Object mutex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.447 -0400", hash_original_method = "30FA7B26D2517E75155300E21A44EE02", hash_generated_method = "04BEBFE0095AFAF3C9F796F57AE0BFCE")
          SynchronizedCollection(Collection<E> collection) {
            c = collection;
            mutex = this;
            // ---------- Original Method ----------
            //c = collection;
            //mutex = this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.448 -0400", hash_original_method = "A2A350BD37040709EC39C6B0536AFBDE", hash_generated_method = "4B2E27EA4C4C16202811504251810751")
          SynchronizedCollection(Collection<E> collection, Object mutex) {
            c = collection;
            this.mutex = mutex;
            // ---------- Original Method ----------
            //c = collection;
            //this.mutex = mutex;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.448 -0400", hash_original_method = "FB2AC5CD0A8119C2DE50A53F38732CDD", hash_generated_method = "D13C0E87E89AC3D6E56208FF6F71CAF0")
        @Override
        public boolean add(E object) {
            {
                boolean var2BB0FD33FED1B2B72867ACF06FBFC56B_739237142 = (c.add(object));
            } //End block
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_689397009 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_689397009;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.add(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.452 -0400", hash_original_method = "8489E829BC0B88048B305735D46B1D99", hash_generated_method = "5B3EAAB894D817391E95F695FE5F359D")
        @Override
        public boolean addAll(Collection<? extends E> collection) {
            {
                boolean varAB7EBFBCA4F45D51E737154B11C4108B_1316704225 = (c.addAll(collection));
            } //End block
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_52451356 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_52451356;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.addAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.453 -0400", hash_original_method = "7AE3345D011114FF0F62A8DFD7762BE2", hash_generated_method = "ED4D6B89485DB8E6E90C08ACDF15F82F")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.453 -0400", hash_original_method = "1B12503F1112F0CD581293F3A624FEFF", hash_generated_method = "F0C4D3B462704713C4DB7EF56CB12A0A")
        @Override
        public boolean contains(Object object) {
            {
                boolean var34971DB84F983FD59B337EBDA19618A7_932633871 = (c.contains(object));
            } //End block
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2058651212 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2058651212;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.contains(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.471 -0400", hash_original_method = "F945FF2C907D1AA0923D46DECCCD5EAD", hash_generated_method = "345D7B1A80C2EB12D6DF544979C2B4AE")
        @Override
        public boolean containsAll(Collection<?> collection) {
            {
                boolean varDACCFBFB1E0F996A35B7BB8B776BF827_1939291458 = (c.containsAll(collection));
            } //End block
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1535032561 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1535032561;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.containsAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.473 -0400", hash_original_method = "FC4F88C8FB9F4E3716AD2ABCD3101657", hash_generated_method = "A82DF85A6F2DD5186CC8EBCE6ADB8756")
        @Override
        public boolean isEmpty() {
            {
                boolean var13DC031C5380F0C4DA515946E668AE17_717699012 = (c.isEmpty());
            } //End block
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1167613510 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1167613510;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.isEmpty();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.482 -0400", hash_original_method = "7F1B5E60A4E4F9F3AFA65965967FBBF0", hash_generated_method = "21EC86955565A4FC61D2EB58D1385B30")
        @Override
        public Iterator<E> iterator() {
            Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_176275549 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_176275549 = c.iterator();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_176275549.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_176275549;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.iterator();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.482 -0400", hash_original_method = "C85E45E4AF074973339408E1197B653C", hash_generated_method = "F34A23EDB5B558031263EC76EDA402DE")
        @Override
        public boolean remove(Object object) {
            {
                boolean var8E355775017A5ED204FCCA7510D23187_642804978 = (c.remove(object));
            } //End block
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1329542546 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1329542546;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.remove(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.482 -0400", hash_original_method = "63829008A74D54A464D81619215951F3", hash_generated_method = "D6BB3EFD620007CD1AF309D755ECDDF7")
        @Override
        public boolean removeAll(Collection<?> collection) {
            {
                boolean var1464AF4DDAD9564C54B239B0335D2517_288052262 = (c.removeAll(collection));
            } //End block
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1984194275 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1984194275;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.removeAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.483 -0400", hash_original_method = "F83427C5B4EF86DB8198B3D2BAE482AC", hash_generated_method = "6A0891BB7616E494647448E402D691FC")
        @Override
        public boolean retainAll(Collection<?> collection) {
            {
                boolean varF2E46B90912EE4E31AEA6D3F646498E8_41830001 = (c.retainAll(collection));
            } //End block
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1992257969 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1992257969;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.retainAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.483 -0400", hash_original_method = "8641BC878FB77D36CE60B1977D7C0FB5", hash_generated_method = "E3B6CBE8B50E59DB483EE7A76A79F3C4")
        @Override
        public int size() {
            {
                int var0E51EFE72011B352AF314992F697E7C3_693833864 = (c.size());
            } //End block
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1308602260 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1308602260;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.size();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.484 -0400", hash_original_method = "214BCEC14D5449B585926B657D8D51C2", hash_generated_method = "D68AE478E59AB0C38D57D803E29280F2")
        @Override
        public java.lang.Object[] toArray() {
            java.lang.Object[] varB4EAC82CA7396A68D541C85D26508E83_1277997152 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_1277997152 = c.toArray();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1277997152.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1277997152;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.toArray();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.488 -0400", hash_original_method = "D637F0F4C3C8C312A0597F30C1C6DB59", hash_generated_method = "88D30BAE248DBF15F1978546E1D3597B")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_633139042 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_633139042 = c.toString();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_633139042.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_633139042;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.toString();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.500 -0400", hash_original_method = "567EED27866E99DFC1B7F8B43B648D82", hash_generated_method = "6B211700215C9D4F701A01ED2E51F31E")
        @Override
        public <T> T[] toArray(T[] array) {
            T[] varB4EAC82CA7396A68D541C85D26508E83_28614756 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_28614756 = c.toArray(array);
            } //End block
            addTaint(array[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_28614756.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_28614756;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.toArray(array);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.501 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "DB1DE1953401C4A8F22A25B2206D8A3D")
        private void writeObject(ObjectOutputStream stream) throws IOException {
            {
                stream.defaultWriteObject();
            } //End block
            addTaint(stream.getTaint());
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //stream.defaultWriteObject();
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.501 -0400", hash_original_field = "B7F3A88BD93CCDAF65C044FAA6629D02", hash_generated_field = "64C4CF165AE4D96687B8F95134EA7D73")

        private static long serialVersionUID = 3053995032091335093L;
    }


    
    static class SynchronizedRandomAccessList<E> extends SynchronizedList<E> implements RandomAccess {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.501 -0400", hash_original_method = "B7E7091552AE239FAE56C332916C1F88", hash_generated_method = "E13039390DC63B5DD55D2C3F5A398F04")
          SynchronizedRandomAccessList(List<E> l) {
            super(l);
            addTaint(l.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.501 -0400", hash_original_method = "333C2DB156927D33EFC68D095A4D91C7", hash_generated_method = "AE1BCAB65FE4C0FE73632D8319B7F9FE")
          SynchronizedRandomAccessList(List<E> l, Object mutex) {
            super(l, mutex);
            addTaint(l.getTaint());
            addTaint(mutex.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.502 -0400", hash_original_method = "52EB3707ADD11A2326D60B7B815140D9", hash_generated_method = "3138E160431620074E885952014424F6")
        @Override
        public List<E> subList(int start, int end) {
            List<E> varB4EAC82CA7396A68D541C85D26508E83_306869000 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_306869000 = new SynchronizedRandomAccessList<E>(list.subList(start, end), mutex);
            } //End block
            addTaint(start);
            addTaint(end);
            varB4EAC82CA7396A68D541C85D26508E83_306869000.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_306869000;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedRandomAccessList<E>(list.subList(start, end), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.502 -0400", hash_original_method = "3A06B4F1BF7736CF10F2183ECBC34EF4", hash_generated_method = "409A7ED8ABCC753A5D2EE0957EB851DD")
        private Object writeReplace() {
            Object varB4EAC82CA7396A68D541C85D26508E83_1203398801 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1203398801 = new SynchronizedList<E>(list);
            varB4EAC82CA7396A68D541C85D26508E83_1203398801.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1203398801;
            // ---------- Original Method ----------
            //return new SynchronizedList<E>(list);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.503 -0400", hash_original_field = "9B799982724822CB2FE4521FDAC6E710", hash_generated_field = "21A753FB267D280E543AD019E21774E3")

        private static long serialVersionUID = 1530674583602358482L;
    }


    
    static class SynchronizedList<E> extends SynchronizedCollection<E> implements List<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.503 -0400", hash_original_field = "10AE9FC7D453B0DD525D0EDF2EDE7961", hash_generated_field = "1ECA8D0C53ED31C6D874046BB18C0645")

        List<E> list;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.514 -0400", hash_original_method = "557BC04FB4751FAF0774C664BC5CCEDB", hash_generated_method = "C7C5461D5C9C9A7143EFC825B2E89308")
          SynchronizedList(List<E> l) {
            super(l);
            list = l;
            // ---------- Original Method ----------
            //list = l;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.516 -0400", hash_original_method = "6BB690026CB7D337AD2D522FD2C1D564", hash_generated_method = "5A03D1AA887517822EC5152559195ADC")
          SynchronizedList(List<E> l, Object mutex) {
            super(l, mutex);
            list = l;
            addTaint(mutex.getTaint());
            // ---------- Original Method ----------
            //list = l;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.517 -0400", hash_original_method = "771543DB5FBF857EC43E623C900790C1", hash_generated_method = "91E40E74D69FC52967284256EB93FBA0")
        @Override
        public void add(int location, E object) {
            {
                list.add(location, object);
            } //End block
            addTaint(location);
            addTaint(object.getTaint());
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //list.add(location, object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.519 -0400", hash_original_method = "2E8B0D036C339DEB52EAEECF82B3FC29", hash_generated_method = "A4A9D242B299B567CB07F212673F2DF8")
        @Override
        public boolean addAll(int location, Collection<? extends E> collection) {
            {
                boolean var158D83A08C48A45A82B28798671769C1_1098544237 = (list.addAll(location, collection));
            } //End block
            addTaint(location);
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_381626968 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_381626968;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.addAll(location, collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.521 -0400", hash_original_method = "3D6B0DEE3E066475015263D28B67E9C7", hash_generated_method = "308E8DE7AAA093CC3E763762D5775406")
        @Override
        public boolean equals(Object object) {
            {
                boolean varB8EFBCA5568090BA0F116E782A49968B_1063822414 = (list.equals(object));
            } //End block
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1170718888 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1170718888;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.equals(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.533 -0400", hash_original_method = "5B64BB89A58DED71DBA9907C06BC2CBB", hash_generated_method = "B538F5CC10135197A6A0FC0BE5E786F1")
        @Override
        public E get(int location) {
            E varB4EAC82CA7396A68D541C85D26508E83_1048899106 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_1048899106 = list.get(location);
            } //End block
            addTaint(location);
            varB4EAC82CA7396A68D541C85D26508E83_1048899106.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1048899106;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.get(location);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.533 -0400", hash_original_method = "4F5947DB3C3ABC0CDEDCB631295417DE", hash_generated_method = "A6C7C8DEC0EB80853C8AB39345FBE8AB")
        @Override
        public int hashCode() {
            {
                int varE89315CE67DD6395C812E01B5B28CC79_1859395623 = (list.hashCode());
            } //End block
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1813902560 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1813902560;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.hashCode();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.534 -0400", hash_original_method = "3D24998665BD619FA01B00E0A34A83F5", hash_generated_method = "04ACA6241C785E00227BEF663A9B91BC")
        @Override
        public int indexOf(Object object) {
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
                            boolean varE4EB18CE7254896A48F2456CD1C5820F_55113403 = (object.equals(array[i]));
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
            addTaint(object.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1652855533 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1652855533;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.535 -0400", hash_original_method = "615F71337583130515178716D1767A86", hash_generated_method = "E408D983E016B0DBA09D01E29E4296DE")
        @Override
        public int lastIndexOf(Object object) {
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
                            boolean varE4EB18CE7254896A48F2456CD1C5820F_419848638 = (object.equals(array[i]));
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
            addTaint(object.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_109624544 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_109624544;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.546 -0400", hash_original_method = "9E49E91DE129681261C3C7642C2D1127", hash_generated_method = "2F1832F029EEACF9E6D845798CED0806")
        @Override
        public ListIterator<E> listIterator() {
            ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_1671736548 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_1671736548 = list.listIterator();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1671736548.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1671736548;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.listIterator();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.546 -0400", hash_original_method = "70349F3896FC81F4D21A3D35B0C8A4F6", hash_generated_method = "C395BD93F9551A25CA7B6A4B85393E75")
        @Override
        public ListIterator<E> listIterator(int location) {
            ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_1186766219 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_1186766219 = list.listIterator(location);
            } //End block
            addTaint(location);
            varB4EAC82CA7396A68D541C85D26508E83_1186766219.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1186766219;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.listIterator(location);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.547 -0400", hash_original_method = "D935E09B492D323BEF59297A7648FE48", hash_generated_method = "FB21B68B402FE91EE1435D7AC05CA0DF")
        @Override
        public E remove(int location) {
            E varB4EAC82CA7396A68D541C85D26508E83_2079720922 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_2079720922 = list.remove(location);
            } //End block
            addTaint(location);
            varB4EAC82CA7396A68D541C85D26508E83_2079720922.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2079720922;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.remove(location);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.551 -0400", hash_original_method = "D9730991663FB8C206D80781B7E02750", hash_generated_method = "B9766C600210D3B00C7D470B2FE7D89A")
        @Override
        public E set(int location, E object) {
            E varB4EAC82CA7396A68D541C85D26508E83_16848882 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_16848882 = list.set(location, object);
            } //End block
            addTaint(location);
            addTaint(object.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_16848882.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_16848882;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.set(location, object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.554 -0400", hash_original_method = "C38F2D62AA6D1EBD255ADC5369CBEC01", hash_generated_method = "1FE363E0AB40C49ECC85B469BFF554DD")
        @Override
        public List<E> subList(int start, int end) {
            List<E> varB4EAC82CA7396A68D541C85D26508E83_839286040 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_839286040 = new SynchronizedList<E>(list.subList(start, end), mutex);
            } //End block
            addTaint(start);
            addTaint(end);
            varB4EAC82CA7396A68D541C85D26508E83_839286040.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_839286040;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedList<E>(list.subList(start, end), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.555 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "DB1DE1953401C4A8F22A25B2206D8A3D")
        private void writeObject(ObjectOutputStream stream) throws IOException {
            {
                stream.defaultWriteObject();
            } //End block
            addTaint(stream.getTaint());
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //stream.defaultWriteObject();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.560 -0400", hash_original_method = "172F08E6F2352F1764A4A70C48C6E243", hash_generated_method = "6BF1A89FAC5AD4F29BA2548F3D39F6F0")
        private Object readResolve() {
            Object varB4EAC82CA7396A68D541C85D26508E83_2136694824 = null; //Variable for return #1
            Object varB4EAC82CA7396A68D541C85D26508E83_920452798 = null; //Variable for return #2
            {
                varB4EAC82CA7396A68D541C85D26508E83_2136694824 = new SynchronizedRandomAccessList<E>(list, mutex);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_920452798 = this;
            Object varA7E53CE21691AB073D9660D615818899_151241717; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_151241717 = varB4EAC82CA7396A68D541C85D26508E83_2136694824;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_151241717 = varB4EAC82CA7396A68D541C85D26508E83_920452798;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_151241717.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_151241717;
            // ---------- Original Method ----------
            //if (list instanceof RandomAccess) {
                //return new SynchronizedRandomAccessList<E>(list, mutex);
            //}
            //return this;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.560 -0400", hash_original_field = "8883C8F4886CDFE339069F9C7525453D", hash_generated_field = "FDC751B2BA1321115D7B80AF666D89CA")

        private static long serialVersionUID = -7754090372962971524L;
    }


    
    static class SynchronizedMap<K, V> implements Map<K, V>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.564 -0400", hash_original_field = "6F8F57715090DA2632453988D9A1501B", hash_generated_field = "1785B4570966C73126874A8D942D2395")

        private Map<K, V> m;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.564 -0400", hash_original_field = "25A01BB859125507013A2FE9737D3C32", hash_generated_field = "5C5F8780FECE5E612AF5A86D3A8B3194")

        Object mutex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.564 -0400", hash_original_method = "C14189E3F71A4C148CB91C638F3BAAE3", hash_generated_method = "697756520B6F74069D1E5AA0F6D1C69A")
          SynchronizedMap(Map<K, V> map) {
            m = map;
            mutex = this;
            // ---------- Original Method ----------
            //m = map;
            //mutex = this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.568 -0400", hash_original_method = "6EAD9DD813CFD47244744C3F6D6A4D1C", hash_generated_method = "96BED7921FDC6B114140F51F8F22333E")
          SynchronizedMap(Map<K, V> map, Object mutex) {
            m = map;
            this.mutex = mutex;
            // ---------- Original Method ----------
            //m = map;
            //this.mutex = mutex;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.569 -0400", hash_original_method = "3DCF075501F09300584E40825720BBA2", hash_generated_method = "931659E7A8514DEF770EFF02D67516B0")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.585 -0400", hash_original_method = "D2C67B34100B05197A0572527ECA3220", hash_generated_method = "A768E00DDE15FBD3C7AE245A6477ED99")
        @Override
        public boolean containsKey(Object key) {
            {
                boolean var5B3943E8DB1DEBF4053A7AC85BD5CB7F_1659334204 = (m.containsKey(key));
            } //End block
            addTaint(key.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2113656855 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2113656855;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.containsKey(key);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.585 -0400", hash_original_method = "FFE2162DB44C1E8BEEAD35935B233C81", hash_generated_method = "573FBA0AFB351C730243722183A27990")
        @Override
        public boolean containsValue(Object value) {
            {
                boolean var9B502A789B5AAD38CD0ED829F2887AEF_1027634102 = (m.containsValue(value));
            } //End block
            addTaint(value.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_638196332 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_638196332;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.containsValue(value);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.586 -0400", hash_original_method = "E5EA9A3F9567269DAA52E0C08140D3D5", hash_generated_method = "1F8BBD89FF12379C0D5B14BB6DD3AEBB")
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_717029403 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_717029403 = new SynchronizedSet<Map.Entry<K, V>>(m.entrySet(), mutex);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_717029403.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_717029403;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSet<Map.Entry<K, V>>(m.entrySet(), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.586 -0400", hash_original_method = "573EFA9740FEBDEC9C1CCFD8172CCEF0", hash_generated_method = "B6E5C63548739A51AE95C1B8B8BF6840")
        @Override
        public boolean equals(Object object) {
            {
                boolean var3653CC7A1B6721F556FDF4EA3FD61A52_102975229 = (m.equals(object));
            } //End block
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1439212044 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1439212044;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.equals(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.590 -0400", hash_original_method = "80DF7D6FED6980DF61457325CD64503D", hash_generated_method = "030B177ECDDEB84B78A09BBDD44ACB3F")
        @Override
        public V get(Object key) {
            V varB4EAC82CA7396A68D541C85D26508E83_1917593795 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_1917593795 = m.get(key);
            } //End block
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1917593795.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1917593795;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.get(key);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.591 -0400", hash_original_method = "5DDF560D56DA8F61EEAD582BB150A893", hash_generated_method = "376E1637A8BC6822B8D5E028F8475EC7")
        @Override
        public int hashCode() {
            {
                int var58938B03D27AEF577E5F8B43D45478A1_1137276855 = (m.hashCode());
            } //End block
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1182834363 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1182834363;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.hashCode();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.591 -0400", hash_original_method = "40A122CDBD7096230690259CC30A0F7A", hash_generated_method = "31AE2CC9B1A302132F0EF3E61D6F93F7")
        @Override
        public boolean isEmpty() {
            {
                boolean var20AA7E3C23DC3AFB5FE1B5D3BD0CE158_219025542 = (m.isEmpty());
            } //End block
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_634705053 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_634705053;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.isEmpty();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.595 -0400", hash_original_method = "2FBB6190D51F2A6210F8CF71191E69DD", hash_generated_method = "B67A871543319FE9B2B31BC44B657923")
        @Override
        public Set<K> keySet() {
            Set<K> varB4EAC82CA7396A68D541C85D26508E83_1200278450 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_1200278450 = new SynchronizedSet<K>(m.keySet(), mutex);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1200278450.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1200278450;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSet<K>(m.keySet(), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.606 -0400", hash_original_method = "4BBBC2EF3E646AB7C0C1BFCAE8571FAF", hash_generated_method = "61C545F8B3C168169D2B4825920B1500")
        @Override
        public V put(K key, V value) {
            V varB4EAC82CA7396A68D541C85D26508E83_1970590617 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_1970590617 = m.put(key, value);
            } //End block
            addTaint(key.getTaint());
            addTaint(value.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1970590617.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1970590617;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.put(key, value);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.607 -0400", hash_original_method = "400FF0E6707670DAA4FF7ECA275302A3", hash_generated_method = "DB9FF77F668C1D72924587E83C74A1E6")
        @Override
        public void putAll(Map<? extends K, ? extends V> map) {
            {
                m.putAll(map);
            } //End block
            addTaint(map.getTaint());
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //m.putAll(map);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.607 -0400", hash_original_method = "98B37460DCD5FD18048F5172283C3141", hash_generated_method = "67DD865AF2BC99C664CBD61D4749BB4D")
        @Override
        public V remove(Object key) {
            V varB4EAC82CA7396A68D541C85D26508E83_1324110639 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_1324110639 = m.remove(key);
            } //End block
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1324110639.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1324110639;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.remove(key);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.607 -0400", hash_original_method = "A48EE7C65347333E889EFC2ECD0A019A", hash_generated_method = "524FC85D57CC37799DA867D4D8D12009")
        @Override
        public int size() {
            {
                int var0BF7698F6735353014CC57B558785727_185820830 = (m.size());
            } //End block
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1517840532 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1517840532;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.size();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.608 -0400", hash_original_method = "BB797020E54DC33FB15BC9404E89E5CD", hash_generated_method = "D909AE0E67782551384CF302F4B30301")
        @Override
        public Collection<V> values() {
            Collection<V> varB4EAC82CA7396A68D541C85D26508E83_1393669407 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_1393669407 = new SynchronizedCollection<V>(m.values(), mutex);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1393669407.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1393669407;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedCollection<V>(m.values(), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.609 -0400", hash_original_method = "CB61B465EF18C12F472B81636CD4AC79", hash_generated_method = "62669CB5A608469C760B505047DC1049")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1910544920 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_1910544920 = m.toString();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1910544920.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1910544920;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.toString();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.609 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "DB1DE1953401C4A8F22A25B2206D8A3D")
        private void writeObject(ObjectOutputStream stream) throws IOException {
            {
                stream.defaultWriteObject();
            } //End block
            addTaint(stream.getTaint());
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //stream.defaultWriteObject();
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.609 -0400", hash_original_field = "5DC93EB19DFCBC7B8981ED54844A07B4", hash_generated_field = "1CD7BF5E81B21D730197EAE8B8531743")

        private static long serialVersionUID = 1978198479659022715L;
    }


    
    static class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.620 -0400", hash_original_method = "F3863A567ABAC10F9410ABCF2A4DC8AC", hash_generated_method = "B3C414CCF795BDAB85BAEA8F2098B4FB")
          SynchronizedSet(Set<E> set) {
            super(set);
            addTaint(set.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.620 -0400", hash_original_method = "A1BA2E3E145DCA2C522F0AB9439A1572", hash_generated_method = "F2771B0F9A187173FBD167BE172A69B3")
          SynchronizedSet(Set<E> set, Object mutex) {
            super(set, mutex);
            addTaint(set.getTaint());
            addTaint(mutex.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.621 -0400", hash_original_method = "E045FF0B832C85F3AF0597463FE3892F", hash_generated_method = "0B1820E3C9C061EAA2B692FE357E87FC")
        @Override
        public boolean equals(Object object) {
            {
                boolean varEA83122D095DC61C01436A4AA2CBB70C_1236967581 = (c.equals(object));
            } //End block
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_210970495 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_210970495;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.equals(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.621 -0400", hash_original_method = "60CA731F9E7ECB7D3EED20B0D6D4AB09", hash_generated_method = "DBD8FD39452310794A9A7AC8462959BC")
        @Override
        public int hashCode() {
            {
                int varDBC342B671922A4943718E25F26D87D0_934602531 = (c.hashCode());
            } //End block
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_716060585 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_716060585;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.hashCode();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.621 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "DB1DE1953401C4A8F22A25B2206D8A3D")
        private void writeObject(ObjectOutputStream stream) throws IOException {
            {
                stream.defaultWriteObject();
            } //End block
            addTaint(stream.getTaint());
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //stream.defaultWriteObject();
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.621 -0400", hash_original_field = "916EB185FF2AF0CF7FFC612F07D6DA1B", hash_generated_field = "4C02F77876AE663B0E37D90403F14A4B")

        private static long serialVersionUID = 487447009682186044L;
    }


    
    static class SynchronizedSortedMap<K, V> extends SynchronizedMap<K, V> implements SortedMap<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.621 -0400", hash_original_field = "ED79ACB0CD3D7F8320C53C7798335EF0", hash_generated_field = "F813233D7B24D3620137345516D05A23")

        private SortedMap<K, V> sm;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.622 -0400", hash_original_method = "2E0F62BCD34367F1E6E251286E17ABEB", hash_generated_method = "65B92739EACB6292AF1017EE07725F62")
          SynchronizedSortedMap(SortedMap<K, V> map) {
            super(map);
            sm = map;
            // ---------- Original Method ----------
            //sm = map;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.622 -0400", hash_original_method = "5BF33998E3FF0155F7A513C6A201FE85", hash_generated_method = "954D8A68339AFC6EE619959623984CAA")
          SynchronizedSortedMap(SortedMap<K, V> map, Object mutex) {
            super(map, mutex);
            sm = map;
            addTaint(mutex.getTaint());
            // ---------- Original Method ----------
            //sm = map;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.623 -0400", hash_original_method = "78218A5A359D1FCDF6B98779037FCB94", hash_generated_method = "36FBEB63360E30A6E273E1689F626A69")
        @Override
        public Comparator<? super K> comparator() {
            Comparator<? super K> varB4EAC82CA7396A68D541C85D26508E83_467166109 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_467166109 = sm.comparator();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_467166109.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_467166109;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return sm.comparator();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.623 -0400", hash_original_method = "4A44F83861E496A35113DD67FECD390A", hash_generated_method = "F1323B80B46D651ED401B2BFD13E0B7E")
        @Override
        public K firstKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_652871188 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_652871188 = sm.firstKey();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_652871188.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_652871188;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return sm.firstKey();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.634 -0400", hash_original_method = "758EF70CDC2061BD7D7B124D17EF3F64", hash_generated_method = "E6E401E03EED1397E950638B89303BE0")
        @Override
        public SortedMap<K, V> headMap(K endKey) {
            SortedMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_1840325221 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_1840325221 = new SynchronizedSortedMap<K, V>(sm.headMap(endKey),
                        mutex);
            } //End block
            addTaint(endKey.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1840325221.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1840325221;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedMap<K, V>(sm.headMap(endKey),
                        //mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.635 -0400", hash_original_method = "ECB924A52CC9F341D1EEB7E5D7BCCDC8", hash_generated_method = "F457E747F8877D54B0E6133FE5A214B3")
        @Override
        public K lastKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_858126644 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_858126644 = sm.lastKey();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_858126644.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_858126644;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return sm.lastKey();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.635 -0400", hash_original_method = "E82E6227AA62F00EB1D33B47A72F41C4", hash_generated_method = "A85AF6CC6EFDE94614148CFC80E0B461")
        @Override
        public SortedMap<K, V> subMap(K startKey, K endKey) {
            SortedMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_1990347934 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_1990347934 = new SynchronizedSortedMap<K, V>(sm.subMap(startKey,
                        endKey), mutex);
            } //End block
            addTaint(startKey.getTaint());
            addTaint(endKey.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1990347934.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1990347934;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedMap<K, V>(sm.subMap(startKey,
                        //endKey), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.636 -0400", hash_original_method = "F7B84D714F16D295C7D43C8AA5E52D6A", hash_generated_method = "B8C39DB31E9709CC5583F3182097586A")
        @Override
        public SortedMap<K, V> tailMap(K startKey) {
            SortedMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_672460007 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_672460007 = new SynchronizedSortedMap<K, V>(sm.tailMap(startKey),
                        mutex);
            } //End block
            addTaint(startKey.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_672460007.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_672460007;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedMap<K, V>(sm.tailMap(startKey),
                        //mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.636 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "DB1DE1953401C4A8F22A25B2206D8A3D")
        private void writeObject(ObjectOutputStream stream) throws IOException {
            {
                stream.defaultWriteObject();
            } //End block
            addTaint(stream.getTaint());
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //stream.defaultWriteObject();
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.636 -0400", hash_original_field = "CA84F69F8568978C0AA41949BE696442", hash_generated_field = "F11C494151D8A9CF260338F77894A5A8")

        private static long serialVersionUID = -8798146769416483793L;
    }


    
    static class SynchronizedSortedSet<E> extends SynchronizedSet<E> implements SortedSet<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.643 -0400", hash_original_field = "3691308F2A4C2F6983F2880D32E29C84", hash_generated_field = "5220A6F2AA4CB98BB6C290F0BB717E86")

        private SortedSet<E> ss;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.657 -0400", hash_original_method = "B2F0E775DF29B0E6B28447766B0AA532", hash_generated_method = "4CBCB006A0B32CDF41866EAC9A8E2DC9")
          SynchronizedSortedSet(SortedSet<E> set) {
            super(set);
            ss = set;
            // ---------- Original Method ----------
            //ss = set;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.657 -0400", hash_original_method = "46957450EFA60C06BEFC5742F9BFAC78", hash_generated_method = "162269369C68BEF6B4124813A13B8D19")
          SynchronizedSortedSet(SortedSet<E> set, Object mutex) {
            super(set, mutex);
            ss = set;
            addTaint(mutex.getTaint());
            // ---------- Original Method ----------
            //ss = set;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.658 -0400", hash_original_method = "D71F7DA0E84FA7A091B4017D559410C5", hash_generated_method = "6169E20ED98B95E0791C784F3408C0F4")
        @Override
        public Comparator<? super E> comparator() {
            Comparator<? super E> varB4EAC82CA7396A68D541C85D26508E83_1475888441 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_1475888441 = ss.comparator();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1475888441.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1475888441;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return ss.comparator();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.658 -0400", hash_original_method = "C2C55C7E331CFDE8E84B8FC74FDABE02", hash_generated_method = "E0BCECBF253F172DDED1ECE0B709DBA5")
        @Override
        public E first() {
            E varB4EAC82CA7396A68D541C85D26508E83_348774915 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_348774915 = ss.first();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_348774915.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_348774915;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return ss.first();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.659 -0400", hash_original_method = "86DA75392AF50D6AE53AEE4A4052EBA8", hash_generated_method = "377EFB7DA36AF4B4C4C76882EEFAD939")
        @Override
        public SortedSet<E> headSet(E end) {
            SortedSet<E> varB4EAC82CA7396A68D541C85D26508E83_2030104148 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_2030104148 = new SynchronizedSortedSet<E>(ss.headSet(end), mutex);
            } //End block
            addTaint(end.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2030104148.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2030104148;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedSet<E>(ss.headSet(end), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.659 -0400", hash_original_method = "3C10DA3BCCE6BED4EBD1F6A2C6BC8438", hash_generated_method = "456EB722B5E2AAE339256EAE9549C000")
        @Override
        public E last() {
            E varB4EAC82CA7396A68D541C85D26508E83_669067498 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_669067498 = ss.last();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_669067498.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_669067498;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return ss.last();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.659 -0400", hash_original_method = "662A59FFAA1C1722D75A374EC93FB0DF", hash_generated_method = "1F8EB4083618D40E23813D7F6D70D7A0")
        @Override
        public SortedSet<E> subSet(E start, E end) {
            SortedSet<E> varB4EAC82CA7396A68D541C85D26508E83_1089351461 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_1089351461 = new SynchronizedSortedSet<E>(ss.subSet(start, end),
                        mutex);
            } //End block
            addTaint(start.getTaint());
            addTaint(end.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1089351461.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1089351461;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedSet<E>(ss.subSet(start, end),
                        //mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.660 -0400", hash_original_method = "4C04840896A126B8B17AD8E0926A5B00", hash_generated_method = "4E72F9AAE5BEB1FC4421D7DDAB7F905E")
        @Override
        public SortedSet<E> tailSet(E start) {
            SortedSet<E> varB4EAC82CA7396A68D541C85D26508E83_1794100464 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_1794100464 = new SynchronizedSortedSet<E>(ss.tailSet(start), mutex);
            } //End block
            addTaint(start.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1794100464.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1794100464;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedSet<E>(ss.tailSet(start), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.660 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "DB1DE1953401C4A8F22A25B2206D8A3D")
        private void writeObject(ObjectOutputStream stream) throws IOException {
            {
                stream.defaultWriteObject();
            } //End block
            addTaint(stream.getTaint());
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //stream.defaultWriteObject();
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.660 -0400", hash_original_field = "7550293A247191A63B69680B8051BA5C", hash_generated_field = "4AC00B60B67620AD21C2C186D9ED547F")

        private static long serialVersionUID = 8695801310862127406L;
    }


    
    private static class UnmodifiableCollection<E> implements Collection<E>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.660 -0400", hash_original_field = "4A8A08F09D37B73795649038408B5F33", hash_generated_field = "A3C80A7E02E49F20400373DFBAF9696A")

        Collection<E> c;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.667 -0400", hash_original_method = "0B21B3311CB87F81844FA591591A704A", hash_generated_method = "F8A220D652916612975A1BF5C32AE7B2")
          UnmodifiableCollection(Collection<E> collection) {
            c = collection;
            // ---------- Original Method ----------
            //c = collection;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.669 -0400", hash_original_method = "1E7EFCC2BAD401EE702FAECD906F0B57", hash_generated_method = "185FE0956D690EEE3B181D7E18AD4F5A")
        @Override
        public boolean add(E object) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_408957301 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_408957301;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.669 -0400", hash_original_method = "A14B246F22D65FADC1A66C9C0851763B", hash_generated_method = "EFCB39D9E98FBC5853952B5DFFEEDB65")
        @Override
        public boolean addAll(Collection<? extends E> collection) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_311001762 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_311001762;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.681 -0400", hash_original_method = "C5BE2B5F9D582C4EED1DC0880E8741A1", hash_generated_method = "2CA329ADE50B407D285AB2E4B5875FC8")
        @Override
        public void clear() {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.686 -0400", hash_original_method = "9A5FA57B69BAE7BFE0B020704235C788", hash_generated_method = "8AB5A6A75E7498D13D70F408527A134C")
        @Override
        public boolean contains(Object object) {
            boolean var57979CEAB3B2144CFD864D01F9E7B4FE_1961441339 = (c.contains(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1167143437 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1167143437;
            // ---------- Original Method ----------
            //return c.contains(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.687 -0400", hash_original_method = "BD1B4CD05BF6E123B0DC6FD003A6020C", hash_generated_method = "4B4060B6757D17452B781EE66008A336")
        @Override
        public boolean containsAll(Collection<?> collection) {
            boolean varF92105B68CE9F70CF43B3142D405452C_616127537 = (c.containsAll(collection));
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_801731957 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_801731957;
            // ---------- Original Method ----------
            //return c.containsAll(collection);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.687 -0400", hash_original_method = "F9A3CB1FB7570D28EBE20660E2FC6F42", hash_generated_method = "CDE77A2930669F88BCB4839ECE1A5E38")
        @Override
        public boolean isEmpty() {
            boolean var528EAD02A70F822F393BB0C54FBB923C_216806152 = (c.isEmpty());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1717642449 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1717642449;
            // ---------- Original Method ----------
            //return c.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.687 -0400", hash_original_method = "57C2B30126E9906DFFF70EEB2D2CD18D", hash_generated_method = "2044FD41068B9A6D47D809FFCD2DDA6B")
        @Override
        public Iterator<E> iterator() {
            Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_1533901072 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1533901072 = new Iterator<E>() {
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
            varB4EAC82CA7396A68D541C85D26508E83_1533901072.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1533901072;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.688 -0400", hash_original_method = "2165C77F20F5DBDDE4D0AED313262684", hash_generated_method = "C3B04DAF7431A94E81EB57FA103EC509")
        @Override
        public boolean remove(Object object) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_26510545 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_26510545;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.688 -0400", hash_original_method = "95D6D7B80D3C762A794FEAFDE42B30FC", hash_generated_method = "ECBD466018BDCFC6D358D775EBF3BE7A")
        @Override
        public boolean removeAll(Collection<?> collection) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_380059022 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_380059022;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.688 -0400", hash_original_method = "D4789A90B422D35C3FC475A0D6C54BE8", hash_generated_method = "9BCD588E2EAA0E8106A9DDF32C3583E5")
        @Override
        public boolean retainAll(Collection<?> collection) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_139309615 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_139309615;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.689 -0400", hash_original_method = "AC97C28F724592ABA809E2470D95C119", hash_generated_method = "6013265079C3F0FF79168A0F302B9B8B")
        @Override
        public int size() {
            int varC247C84593AA6020ED979B19566D13FE_416054338 = (c.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2098422690 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2098422690;
            // ---------- Original Method ----------
            //return c.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.689 -0400", hash_original_method = "89D7D02A9D2BDF31E775C08108CBDE5B", hash_generated_method = "1A4E7EA8543CCD2D6089EAFC570EDEF1")
        @Override
        public Object[] toArray() {
            Object[] varB4EAC82CA7396A68D541C85D26508E83_2017771201 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2017771201 = c.toArray();
            varB4EAC82CA7396A68D541C85D26508E83_2017771201.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2017771201;
            // ---------- Original Method ----------
            //return c.toArray();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.689 -0400", hash_original_method = "D5913A45F2385B9A173BEEED47EA354F", hash_generated_method = "06A476F6336174FC4A488196F5AB2958")
        @Override
        public <T> T[] toArray(T[] array) {
            T[] varB4EAC82CA7396A68D541C85D26508E83_2098357582 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2098357582 = c.toArray(array);
            addTaint(array[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2098357582.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2098357582;
            // ---------- Original Method ----------
            //return c.toArray(array);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.690 -0400", hash_original_method = "424D4966F358AE6553349A6493C21674", hash_generated_method = "DDA5016BEF6E4A02228A69346798CFAE")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_81657194 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_81657194 = c.toString();
            varB4EAC82CA7396A68D541C85D26508E83_81657194.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_81657194;
            // ---------- Original Method ----------
            //return c.toString();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.690 -0400", hash_original_field = "BF3B1BE107A3BC6EF3F11D547E97ECD3", hash_generated_field = "7DC41621514BC7C6F06C10E37F3F4C9C")

        private static long serialVersionUID = 1820017752578914078L;
    }


    
    private static class UnmodifiableRandomAccessList<E> extends UnmodifiableList<E> implements RandomAccess {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.691 -0400", hash_original_method = "0A20B358F7BA1E60AD6DE80ADB85C324", hash_generated_method = "205D9E6E7A9FC9AE79599882AC59F3B2")
          UnmodifiableRandomAccessList(List<E> l) {
            super(l);
            addTaint(l.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.691 -0400", hash_original_method = "BFD692E8EF2A50E82DD6BA0EC7051578", hash_generated_method = "230ADA0F0ABCBA5D3BBFCD9E6681E941")
        @Override
        public List<E> subList(int start, int end) {
            List<E> varB4EAC82CA7396A68D541C85D26508E83_975109622 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_975109622 = new UnmodifiableRandomAccessList<E>(list.subList(start, end));
            addTaint(start);
            addTaint(end);
            varB4EAC82CA7396A68D541C85D26508E83_975109622.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_975109622;
            // ---------- Original Method ----------
            //return new UnmodifiableRandomAccessList<E>(list.subList(start, end));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.706 -0400", hash_original_method = "C39E6F512687738DD8D987CDE63A2838", hash_generated_method = "15B8AC6E7C1AAC02A8A11320FAC0CEF3")
        private Object writeReplace() {
            Object varB4EAC82CA7396A68D541C85D26508E83_1863576031 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1863576031 = new UnmodifiableList<E>(list);
            varB4EAC82CA7396A68D541C85D26508E83_1863576031.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1863576031;
            // ---------- Original Method ----------
            //return new UnmodifiableList<E>(list);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.707 -0400", hash_original_field = "70DB59789BD14A138F9B12A5CF11EB14", hash_generated_field = "9DEB760C10A64C088B03BD2D84EA2AD3")

        private static long serialVersionUID = -2542308836966382001L;
    }


    
    private static class UnmodifiableList<E> extends UnmodifiableCollection<E> implements List<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.707 -0400", hash_original_field = "10AE9FC7D453B0DD525D0EDF2EDE7961", hash_generated_field = "1ECA8D0C53ED31C6D874046BB18C0645")

        List<E> list;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.707 -0400", hash_original_method = "4CB96388E36B825DE711E2E59A893E0D", hash_generated_method = "51986B2400081BEED0D63B6036986FF3")
          UnmodifiableList(List<E> l) {
            super(l);
            list = l;
            // ---------- Original Method ----------
            //list = l;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.707 -0400", hash_original_method = "CE54A57EF9628E9FD413F964E9F93054", hash_generated_method = "4E38A1F7266D70D7D320F93ABDA9F566")
        @Override
        public void add(int location, E object) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(location);
            addTaint(object.getTaint());
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.708 -0400", hash_original_method = "6CD19404B4901DECE5B6F72EB7D0CD8F", hash_generated_method = "4447D3DF9E2BB0213A281DD967404A5F")
        @Override
        public boolean addAll(int location, Collection<? extends E> collection) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(location);
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2120410106 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2120410106;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.708 -0400", hash_original_method = "C3C1892342CAEB152D9191558B893ACD", hash_generated_method = "20C1CBB33E68339CEC5A996EBB1E08A7")
        @Override
        public boolean equals(Object object) {
            boolean var983E353D0DFE7FD02AAEFC303F168456_743083524 = (list.equals(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1188352691 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1188352691;
            // ---------- Original Method ----------
            //return list.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.708 -0400", hash_original_method = "DFB24286AA0C5C6BF58031CA4ED7CDCB", hash_generated_method = "107B07E81D095CD41EF531294AFE6628")
        @Override
        public E get(int location) {
            E varB4EAC82CA7396A68D541C85D26508E83_101195592 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_101195592 = list.get(location);
            addTaint(location);
            varB4EAC82CA7396A68D541C85D26508E83_101195592.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_101195592;
            // ---------- Original Method ----------
            //return list.get(location);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.708 -0400", hash_original_method = "8FDA3E2E38E99F5D6FC34E94E92E953F", hash_generated_method = "AAE02DE549195B26292E2D80E87FF2A8")
        @Override
        public int hashCode() {
            int var9A1610964D862FF54E00A16E6D7BD291_1070078086 = (list.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1576996916 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1576996916;
            // ---------- Original Method ----------
            //return list.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.709 -0400", hash_original_method = "E8AAF2C874038C363BF8C80F2A4ED8F2", hash_generated_method = "EAF1DA0B68E6225285C7DFC3918A5A4C")
        @Override
        public int indexOf(Object object) {
            int var77BCF240B74578A0DBB7E15170347534_2101104749 = (list.indexOf(object));
            addTaint(object.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_127274265 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_127274265;
            // ---------- Original Method ----------
            //return list.indexOf(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.709 -0400", hash_original_method = "658C7926C6DFF1B86F4D9B6B0E3F5BBD", hash_generated_method = "E590C282728B8593203812EC693FC848")
        @Override
        public int lastIndexOf(Object object) {
            int var158B58B87F16034A803BFB0430AFCD59_191500243 = (list.lastIndexOf(object));
            addTaint(object.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_357711955 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_357711955;
            // ---------- Original Method ----------
            //return list.lastIndexOf(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.709 -0400", hash_original_method = "DF7BE0B13ABC5A9B1C74313BD06FB64C", hash_generated_method = "859FD8B09AA1A28BCE5219225E255D49")
        @Override
        public ListIterator<E> listIterator() {
            ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_1393137924 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1393137924 = listIterator(0);
            varB4EAC82CA7396A68D541C85D26508E83_1393137924.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1393137924;
            // ---------- Original Method ----------
            //return listIterator(0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.710 -0400", hash_original_method = "1D0E6831E50FA8995D23240A6E091C82", hash_generated_method = "5BDC38F974127891A3DE74F3A7EDDDEC")
        @Override
        public ListIterator<E> listIterator(final int location) {
            ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_356812273 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_356812273 = new ListIterator<E>() {
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
            varB4EAC82CA7396A68D541C85D26508E83_356812273.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_356812273;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.710 -0400", hash_original_method = "5388D372D048D053ADD084F02A9C1484", hash_generated_method = "ACA80C53B37816218B9855BF5E9A7790")
        @Override
        public E remove(int location) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(location);
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.725 -0400", hash_original_method = "8830E2F07CC294339D5D496574BCFA5E", hash_generated_method = "FC1CD5B83BE519CD37A91D24C6B9D9F3")
        @Override
        public E set(int location, E object) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(location);
            addTaint(object.getTaint());
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.725 -0400", hash_original_method = "82D78FB8922B9A0888EF8A304898D60D", hash_generated_method = "AAFBEFAE7DD8759CFE5EF90DED60F833")
        @Override
        public List<E> subList(int start, int end) {
            List<E> varB4EAC82CA7396A68D541C85D26508E83_644801984 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_644801984 = new UnmodifiableList<E>(list.subList(start, end));
            addTaint(start);
            addTaint(end);
            varB4EAC82CA7396A68D541C85D26508E83_644801984.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_644801984;
            // ---------- Original Method ----------
            //return new UnmodifiableList<E>(list.subList(start, end));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.727 -0400", hash_original_method = "5F3DDA40E6BDC67502A2E43BA75DBB15", hash_generated_method = "DFDE3D8DC7BB52B1170D8FF7CE1B99A4")
        private Object readResolve() {
            Object varB4EAC82CA7396A68D541C85D26508E83_1190350002 = null; //Variable for return #1
            Object varB4EAC82CA7396A68D541C85D26508E83_870249743 = null; //Variable for return #2
            {
                varB4EAC82CA7396A68D541C85D26508E83_1190350002 = new UnmodifiableRandomAccessList<E>(list);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_870249743 = this;
            Object varA7E53CE21691AB073D9660D615818899_1313007558; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1313007558 = varB4EAC82CA7396A68D541C85D26508E83_1190350002;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1313007558 = varB4EAC82CA7396A68D541C85D26508E83_870249743;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1313007558.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1313007558;
            // ---------- Original Method ----------
            //if (list instanceof RandomAccess) {
                //return new UnmodifiableRandomAccessList<E>(list);
            //}
            //return this;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.727 -0400", hash_original_field = "69FDA83BF467A43A3D5BCAA929D897B3", hash_generated_field = "CC3A2DE8F788BD63A31131D897B24AD1")

        private static long serialVersionUID = -283967356065247728L;
    }


    
    private static class UnmodifiableMap<K, V> implements Map<K, V>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.727 -0400", hash_original_field = "6F8F57715090DA2632453988D9A1501B", hash_generated_field = "1785B4570966C73126874A8D942D2395")

        private Map<K, V> m;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.727 -0400", hash_original_method = "74C4A0289A3E9196E4EF75F76384A7D2", hash_generated_method = "DA7567E66A4C382E1EF89234BCC9D997")
          UnmodifiableMap(Map<K, V> map) {
            m = map;
            // ---------- Original Method ----------
            //m = map;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.734 -0400", hash_original_method = "C5BE2B5F9D582C4EED1DC0880E8741A1", hash_generated_method = "2CA329ADE50B407D285AB2E4B5875FC8")
        @Override
        public void clear() {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.735 -0400", hash_original_method = "A6C730848D8A626F99D8229EE744E3C0", hash_generated_method = "17958CF55524D3C6AF5E0E88DC3C541E")
        @Override
        public boolean containsKey(Object key) {
            boolean var2519B7EF565FEC21B6285F5E44AC148E_396469083 = (m.containsKey(key));
            addTaint(key.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_331764925 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_331764925;
            // ---------- Original Method ----------
            //return m.containsKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.735 -0400", hash_original_method = "EF8C00CF950E8C186D2F05E1E556F384", hash_generated_method = "42FED7C594015BE272FAF5AE3D1B36A8")
        @Override
        public boolean containsValue(Object value) {
            boolean varF8CB74E2C5E0734947B397D82173BDD4_1064532368 = (m.containsValue(value));
            addTaint(value.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1641359557 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1641359557;
            // ---------- Original Method ----------
            //return m.containsValue(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.736 -0400", hash_original_method = "FB0DE15DA25D3994421C9FBDD1812EDD", hash_generated_method = "20B8752DAFD0935564DA1B861C407B8F")
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_300709660 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_300709660 = new UnmodifiableEntrySet<K, V>(m.entrySet());
            varB4EAC82CA7396A68D541C85D26508E83_300709660.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_300709660;
            // ---------- Original Method ----------
            //return new UnmodifiableEntrySet<K, V>(m.entrySet());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.736 -0400", hash_original_method = "CE201E78EAC5D1903F741160CB297EAE", hash_generated_method = "0FF09D48EA8D28928CB13DDD9D1CFE78")
        @Override
        public boolean equals(Object object) {
            boolean var9745819ACBF7C47D9CAE10D95AB26047_909008376 = (m.equals(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1529829526 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1529829526;
            // ---------- Original Method ----------
            //return m.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.737 -0400", hash_original_method = "B8FE254B61C57EC3A6DCE539976DA268", hash_generated_method = "4AA5A2220D09451AFCC29B2210B10526")
        @Override
        public V get(Object key) {
            V varB4EAC82CA7396A68D541C85D26508E83_1655030784 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1655030784 = m.get(key);
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1655030784.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1655030784;
            // ---------- Original Method ----------
            //return m.get(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.824 -0400", hash_original_method = "E3229E3389F030DD50B79734943DB788", hash_generated_method = "62E3AECEDCB3B67BEF93786C58977CE1")
        @Override
        public int hashCode() {
            int varAA1293165230C9829C1AEACFFF576DFC_271584411 = (m.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_198477293 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_198477293;
            // ---------- Original Method ----------
            //return m.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.825 -0400", hash_original_method = "B9E63D3C52241E7E917CB1416ABA36E5", hash_generated_method = "B6147A246C0D398449109E4C4C15EA91")
        @Override
        public boolean isEmpty() {
            boolean var028CF644E61B84328EAB66D556672A81_1892534105 = (m.isEmpty());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_654659460 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_654659460;
            // ---------- Original Method ----------
            //return m.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.825 -0400", hash_original_method = "2CC049F262DAAA6660AF161E9C8606F6", hash_generated_method = "84DA8196F8972BADE4C367357F153C7C")
        @Override
        public Set<K> keySet() {
            Set<K> varB4EAC82CA7396A68D541C85D26508E83_1645265004 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1645265004 = new UnmodifiableSet<K>(m.keySet());
            varB4EAC82CA7396A68D541C85D26508E83_1645265004.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1645265004;
            // ---------- Original Method ----------
            //return new UnmodifiableSet<K>(m.keySet());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.826 -0400", hash_original_method = "1AE25A34BEB4A8F08F41373ADFFCFE34", hash_generated_method = "D7819781C010BECFFB3BC37EE093E818")
        @Override
        public V put(K key, V value) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(key.getTaint());
            addTaint(value.getTaint());
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.826 -0400", hash_original_method = "1D605566C28BBD06FDC515389557B406", hash_generated_method = "8C9B96AACD1010A390DA93C9E1C54679")
        @Override
        public void putAll(Map<? extends K, ? extends V> map) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(map.getTaint());
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.826 -0400", hash_original_method = "1F8D4C123F3DDBF68E61E38EDB13F5FB", hash_generated_method = "CAC84F3EBC2CB52F20821DF2278AA8A5")
        @Override
        public V remove(Object key) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(key.getTaint());
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.832 -0400", hash_original_method = "A04EE09DEB6F21FAA6A7E10DF6401CD1", hash_generated_method = "F4C4E2A3D2C482146C838DBBB4492C04")
        @Override
        public int size() {
            int varDBD6E28F15F3D13B8127CF62DD69ACD5_1857741975 = (m.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1685053505 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1685053505;
            // ---------- Original Method ----------
            //return m.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.833 -0400", hash_original_method = "19DD84E0D2EBBBC2FCDA12D023824450", hash_generated_method = "19E2F934856ADB5796C42BA6F872DBD6")
        @Override
        public Collection<V> values() {
            Collection<V> varB4EAC82CA7396A68D541C85D26508E83_1231742708 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1231742708 = new UnmodifiableCollection<V>(m.values());
            varB4EAC82CA7396A68D541C85D26508E83_1231742708.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1231742708;
            // ---------- Original Method ----------
            //return new UnmodifiableCollection<V>(m.values());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.833 -0400", hash_original_method = "5DD44B3CD2826BF39F974F66579CF74F", hash_generated_method = "B7E814345EAD1CB671D028111CBA42C3")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1785632922 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1785632922 = m.toString();
            varB4EAC82CA7396A68D541C85D26508E83_1785632922.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1785632922;
            // ---------- Original Method ----------
            //return m.toString();
        }

        
        private static class UnmodifiableEntrySet<K, V> extends UnmodifiableSet<Map.Entry<K, V>> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.834 -0400", hash_original_method = "211DEE98878E4422E2F38E79CDC5F0D4", hash_generated_method = "E5E05A5D1E2777C870B2B3DCCCA2A2BD")
              UnmodifiableEntrySet(Set<Map.Entry<K, V>> set) {
                super(set);
                addTaint(set.getTaint());
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.834 -0400", hash_original_method = "53A7F61EDA7A64FBCB28AE61A8906002", hash_generated_method = "3440155453C9A694A303BFF057E6FE24")
            @Override
            public Iterator<Map.Entry<K, V>> iterator() {
                Iterator<Map.Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_1452540671 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1452540671 = new Iterator<Map.Entry<K, V>>() {
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
                varB4EAC82CA7396A68D541C85D26508E83_1452540671.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1452540671;
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.835 -0400", hash_original_method = "C353E5DD4879B90DAE1A37DDC4A8ED8C", hash_generated_method = "0F69DDF2BCEB94083AE44E69D8CE6CE2")
            @Override
            public Object[] toArray() {
                Object[] varB4EAC82CA7396A68D541C85D26508E83_1781822192 = null; //Variable for return #1
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
                varB4EAC82CA7396A68D541C85D26508E83_1781822192 = result;
                varB4EAC82CA7396A68D541C85D26508E83_1781822192.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1781822192;
                // ---------- Original Method ----------
                //int length = c.size();
                //Object[] result = new Object[length];
                //Iterator<?> it = iterator();
                //for (int i = length; --i >= 0;) {
                    //result[i] = it.next();
                //}
                //return result;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.836 -0400", hash_original_method = "CB9686BEA448DC0D7D0077DDEB1917CB", hash_generated_method = "47D473FDB3586D87D2E11B92AE3B9AED")
            @SuppressWarnings("unchecked")
            @Override
            public <T> T[] toArray(T[] contents) {
                T[] varB4EAC82CA7396A68D541C85D26508E83_1999192400 = null; //Variable for return #1
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
                varB4EAC82CA7396A68D541C85D26508E83_1999192400 = contents;
                addTaint(contents[0].getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_1999192400.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1999192400;
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
                @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.836 -0400", hash_original_field = "5B2F0A0A5E89589F62B233C643034719", hash_generated_field = "24589B068FBC99F8ED52DE988ED39319")

                Map.Entry<K, V> mapEntry;
                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.836 -0400", hash_original_method = "E37A4627FD27E632126EED134E00D831", hash_generated_method = "A97AFE882B9E93ECA34E23B05853DCFA")
                  UnmodifiableMapEntry(Map.Entry<K, V> entry) {
                    mapEntry = entry;
                    // ---------- Original Method ----------
                    //mapEntry = entry;
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.836 -0400", hash_original_method = "90F914E663E54C2DC9846974DAA2EFB8", hash_generated_method = "45183BC4334E45B5CE58543921C53832")
                @Override
                public boolean equals(Object object) {
                    boolean var1E6E5EE1426DD4D6EB65B99B916F7467_1564270829 = (mapEntry.equals(object));
                    addTaint(object.getTaint());
                    boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1933444167 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1933444167;
                    // ---------- Original Method ----------
                    //return mapEntry.equals(object);
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.837 -0400", hash_original_method = "4DDB57034C15C2636BC5A8AFB2B3C75A", hash_generated_method = "34880C7BA4F956E9DD34DE66A27F0402")
                @Override
                public K getKey() {
                    K varB4EAC82CA7396A68D541C85D26508E83_1819192542 = null; //Variable for return #1
                    varB4EAC82CA7396A68D541C85D26508E83_1819192542 = mapEntry.getKey();
                    varB4EAC82CA7396A68D541C85D26508E83_1819192542.addTaint(getTaint()); //Add taint from parent
                    return varB4EAC82CA7396A68D541C85D26508E83_1819192542;
                    // ---------- Original Method ----------
                    //return mapEntry.getKey();
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.837 -0400", hash_original_method = "EA1063FCD9D2F699A9610E0A7FDC81FD", hash_generated_method = "6B1394DC625BA65144230898E4CC25B7")
                @Override
                public V getValue() {
                    V varB4EAC82CA7396A68D541C85D26508E83_1152007529 = null; //Variable for return #1
                    varB4EAC82CA7396A68D541C85D26508E83_1152007529 = mapEntry.getValue();
                    varB4EAC82CA7396A68D541C85D26508E83_1152007529.addTaint(getTaint()); //Add taint from parent
                    return varB4EAC82CA7396A68D541C85D26508E83_1152007529;
                    // ---------- Original Method ----------
                    //return mapEntry.getValue();
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.837 -0400", hash_original_method = "8A31FFFC42BCA6E359386EC1F8534D45", hash_generated_method = "13343ED42F8AF7DA26280AF6CCFE13F1")
                @Override
                public int hashCode() {
                    int varB4446261767782D97888D65AE62449D4_468305825 = (mapEntry.hashCode());
                    int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1384002609 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1384002609;
                    // ---------- Original Method ----------
                    //return mapEntry.hashCode();
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.838 -0400", hash_original_method = "3526712C126765AF36CB8D920CBD3B1B", hash_generated_method = "1A2319FA1552949A1378D6A672B3348D")
                @Override
                public V setValue(V object) {
                    if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
                    addTaint(object.getTaint());
                    // ---------- Original Method ----------
                    //throw new UnsupportedOperationException();
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.838 -0400", hash_original_method = "514C7E8B8C54DBFDFB3E185BADD6AD0A", hash_generated_method = "A932106729B370DF1B5351CA02DEB90B")
                @Override
                public String toString() {
                    String varB4EAC82CA7396A68D541C85D26508E83_1548072650 = null; //Variable for return #1
                    varB4EAC82CA7396A68D541C85D26508E83_1548072650 = mapEntry.toString();
                    varB4EAC82CA7396A68D541C85D26508E83_1548072650.addTaint(getTaint()); //Add taint from parent
                    return varB4EAC82CA7396A68D541C85D26508E83_1548072650;
                    // ---------- Original Method ----------
                    //return mapEntry.toString();
                }

                
            }


            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.838 -0400", hash_original_field = "B44292591B716EDD855C6E185A9AC989", hash_generated_field = "D0F64DE9C2878B5A9F9C6AF47D1248F8")

            private static long serialVersionUID = 7854390611657943733L;
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.838 -0400", hash_original_field = "5569682F9E1154F1C678E958FEEE9E89", hash_generated_field = "C41A547252628431B112399CD10FEDC4")

        private static long serialVersionUID = -1034234728574286014L;
    }


    
    private static class UnmodifiableSet<E> extends UnmodifiableCollection<E> implements Set<E> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.850 -0400", hash_original_method = "D46A71F25EF02541A08678630568218D", hash_generated_method = "DBD124D7730B2343640D7C872444495D")
          UnmodifiableSet(Set<E> set) {
            super(set);
            addTaint(set.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.850 -0400", hash_original_method = "BB8664F3F5CB90AA83689CAADCD9EA6B", hash_generated_method = "04EA54F72E5E96D681B60C7527939DF3")
        @Override
        public boolean equals(Object object) {
            boolean var68E706348FF72E55282D2AEF4301CA4B_794033271 = (c.equals(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_122290575 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_122290575;
            // ---------- Original Method ----------
            //return c.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.851 -0400", hash_original_method = "E858D80F3EEDE9F2B52CDB7DA7FBF12B", hash_generated_method = "0BF935B317E55B4497CC3ECE52796C44")
        @Override
        public int hashCode() {
            int var19B3D08FE3840D0D3E365DF71EF3E20C_1777442720 = (c.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_712853640 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_712853640;
            // ---------- Original Method ----------
            //return c.hashCode();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.851 -0400", hash_original_field = "F3BE7D79D6D6372B9FD4F3861D721F88", hash_generated_field = "81D5383F869927F5369A2964349AEBBA")

        private static long serialVersionUID = -9215047833775013803L;
    }


    
    private static class UnmodifiableSortedMap<K, V> extends UnmodifiableMap<K, V> implements SortedMap<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.851 -0400", hash_original_field = "ED79ACB0CD3D7F8320C53C7798335EF0", hash_generated_field = "F813233D7B24D3620137345516D05A23")

        private SortedMap<K, V> sm;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.851 -0400", hash_original_method = "AC9FE01B421B1E54651959AD61521CA6", hash_generated_method = "FE478A77C43C9AB097C4727B1013B70C")
          UnmodifiableSortedMap(SortedMap<K, V> map) {
            super(map);
            sm = map;
            // ---------- Original Method ----------
            //sm = map;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.853 -0400", hash_original_method = "E5FDBCC6560BE7E99B2D2F850BD84149", hash_generated_method = "602B6DB66D9CD3E7EF09B03B0972D128")
        @Override
        public Comparator<? super K> comparator() {
            Comparator<? super K> varB4EAC82CA7396A68D541C85D26508E83_1792901156 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1792901156 = sm.comparator();
            varB4EAC82CA7396A68D541C85D26508E83_1792901156.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1792901156;
            // ---------- Original Method ----------
            //return sm.comparator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.853 -0400", hash_original_method = "B25E8C7440C76FBF812FF7AC9CA9D776", hash_generated_method = "45AADFF7E4C6262634965823B778211F")
        @Override
        public K firstKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_674257962 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_674257962 = sm.firstKey();
            varB4EAC82CA7396A68D541C85D26508E83_674257962.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_674257962;
            // ---------- Original Method ----------
            //return sm.firstKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.854 -0400", hash_original_method = "EC6243B190269A05D31802D1260652E4", hash_generated_method = "EF6F17015513B58F5303045EEC458D54")
        @Override
        public SortedMap<K, V> headMap(K before) {
            SortedMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_949043196 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_949043196 = new UnmodifiableSortedMap<K, V>(sm.headMap(before));
            addTaint(before.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_949043196.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_949043196;
            // ---------- Original Method ----------
            //return new UnmodifiableSortedMap<K, V>(sm.headMap(before));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.854 -0400", hash_original_method = "00E9126A84DE8B71214859A17DA6BD2E", hash_generated_method = "46BFBD65181B8388160211CE86A07C4F")
        @Override
        public K lastKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_132425228 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_132425228 = sm.lastKey();
            varB4EAC82CA7396A68D541C85D26508E83_132425228.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_132425228;
            // ---------- Original Method ----------
            //return sm.lastKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.855 -0400", hash_original_method = "B6411009D9179ABF4D7755605B648FDC", hash_generated_method = "88F920A53F4FA5CEB3E4358F52CA495A")
        @Override
        public SortedMap<K, V> subMap(K start, K end) {
            SortedMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_1232152527 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1232152527 = new UnmodifiableSortedMap<K, V>(sm.subMap(start, end));
            addTaint(start.getTaint());
            addTaint(end.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1232152527.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1232152527;
            // ---------- Original Method ----------
            //return new UnmodifiableSortedMap<K, V>(sm.subMap(start, end));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.855 -0400", hash_original_method = "59BADF6C5EE68C4E1DB5A6A22818328A", hash_generated_method = "701C6CE253C1E4C3CE3D18A004F4DEF7")
        @Override
        public SortedMap<K, V> tailMap(K after) {
            SortedMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_283948465 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_283948465 = new UnmodifiableSortedMap<K, V>(sm.tailMap(after));
            addTaint(after.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_283948465.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_283948465;
            // ---------- Original Method ----------
            //return new UnmodifiableSortedMap<K, V>(sm.tailMap(after));
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.858 -0400", hash_original_field = "BB78CEF8331176F8CBF0AFC85E7523D8", hash_generated_field = "641E29FD5887F49BB2AAF6C5174209C1")

        private static long serialVersionUID = -8806743815996713206L;
    }


    
    private static class UnmodifiableSortedSet<E> extends UnmodifiableSet<E> implements SortedSet<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.858 -0400", hash_original_field = "3691308F2A4C2F6983F2880D32E29C84", hash_generated_field = "5220A6F2AA4CB98BB6C290F0BB717E86")

        private SortedSet<E> ss;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.859 -0400", hash_original_method = "232C45C3B4117EB9042FB58E6C0CE113", hash_generated_method = "C02ACFBA00E84FCE033C7CEC6C326A50")
          UnmodifiableSortedSet(SortedSet<E> set) {
            super(set);
            ss = set;
            // ---------- Original Method ----------
            //ss = set;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.869 -0400", hash_original_method = "8514D9255D678B041F55D03BA11DCA3B", hash_generated_method = "BC10C3D0D5B4E2444E0374AB99025F87")
        @Override
        public Comparator<? super E> comparator() {
            Comparator<? super E> varB4EAC82CA7396A68D541C85D26508E83_1433337904 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1433337904 = ss.comparator();
            varB4EAC82CA7396A68D541C85D26508E83_1433337904.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1433337904;
            // ---------- Original Method ----------
            //return ss.comparator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.870 -0400", hash_original_method = "6BB6C51843B41CC0DCB5509A79DBA008", hash_generated_method = "3101522B45F1BFAB4C19DC874C39CCCB")
        @Override
        public E first() {
            E varB4EAC82CA7396A68D541C85D26508E83_1033776828 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1033776828 = ss.first();
            varB4EAC82CA7396A68D541C85D26508E83_1033776828.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1033776828;
            // ---------- Original Method ----------
            //return ss.first();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.870 -0400", hash_original_method = "74C4BE29898589F7D7948BADA3350612", hash_generated_method = "766F696F9E773B6C74D54AB50A99213D")
        @Override
        public SortedSet<E> headSet(E before) {
            SortedSet<E> varB4EAC82CA7396A68D541C85D26508E83_389151230 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_389151230 = new UnmodifiableSortedSet<E>(ss.headSet(before));
            addTaint(before.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_389151230.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_389151230;
            // ---------- Original Method ----------
            //return new UnmodifiableSortedSet<E>(ss.headSet(before));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.875 -0400", hash_original_method = "AAC5DDE787ACA85752B94AAB77F6B0F8", hash_generated_method = "2B00BE23291603DA8C3DF22FEC154F61")
        @Override
        public E last() {
            E varB4EAC82CA7396A68D541C85D26508E83_2110067388 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2110067388 = ss.last();
            varB4EAC82CA7396A68D541C85D26508E83_2110067388.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2110067388;
            // ---------- Original Method ----------
            //return ss.last();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.876 -0400", hash_original_method = "54602835FD774439E48CB96CB67F9D83", hash_generated_method = "C1248A67473C27ABC525AD31D1080018")
        @Override
        public SortedSet<E> subSet(E start, E end) {
            SortedSet<E> varB4EAC82CA7396A68D541C85D26508E83_1278707308 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1278707308 = new UnmodifiableSortedSet<E>(ss.subSet(start, end));
            addTaint(start.getTaint());
            addTaint(end.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1278707308.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1278707308;
            // ---------- Original Method ----------
            //return new UnmodifiableSortedSet<E>(ss.subSet(start, end));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.876 -0400", hash_original_method = "37640609DAC9C9170FD6CBE14C8AD6B6", hash_generated_method = "63EBE1F0E5473CDAD825A5E6C6F55909")
        @Override
        public SortedSet<E> tailSet(E after) {
            SortedSet<E> varB4EAC82CA7396A68D541C85D26508E83_2027814972 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2027814972 = new UnmodifiableSortedSet<E>(ss.tailSet(after));
            addTaint(after.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2027814972.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2027814972;
            // ---------- Original Method ----------
            //return new UnmodifiableSortedSet<E>(ss.tailSet(after));
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.876 -0400", hash_original_field = "A7FEB93E06211B53C8063E2CA4FFCCC4", hash_generated_field = "565F0337FD6DDD6623C897F298E2D4CE")

        private static long serialVersionUID = -4929149591599911165L;
    }


    
    private static class SetFromMap<E> extends AbstractSet<E> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.877 -0400", hash_original_field = "6F8F57715090DA2632453988D9A1501B", hash_generated_field = "8D1145F106DE5C3E2B790E661BC27C3B")

        private Map<E, Boolean> m;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.877 -0400", hash_original_field = "10AA84685E8BF74D8FA1DED104C25521", hash_generated_field = "75D49D8B030B2438C97CCFE06F0E4EF6")

        private transient Set<E> backingSet;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.878 -0400", hash_original_method = "6B962D990E5B5543C1AA025E18134CE9", hash_generated_method = "68252A5316CF37F1B8C0AF671D9233B5")
          SetFromMap(final Map<E, Boolean> map) {
            m = map;
            backingSet = map.keySet();
            // ---------- Original Method ----------
            //m = map;
            //backingSet = map.keySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.887 -0400", hash_original_method = "B42E9CA75A778919E90B77D794DBEE82", hash_generated_method = "DF9856418EF4B577CD71C0A783358F57")
        @Override
        public boolean equals(Object object) {
            boolean var1848766D38374CAEDBF00C0007CDCFC1_988189693 = (backingSet.equals(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1592366163 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1592366163;
            // ---------- Original Method ----------
            //return backingSet.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.887 -0400", hash_original_method = "684F9CE738B21B1B45F3304124963EF1", hash_generated_method = "FE95202F9647A6A98A58EE0D1622BE55")
        @Override
        public int hashCode() {
            int var061E95C5D32F56D095B7A80E91EC8A56_383665724 = (backingSet.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2039684048 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2039684048;
            // ---------- Original Method ----------
            //return backingSet.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.887 -0400", hash_original_method = "FC84A6CABB16433CF1488E03DF7636C8", hash_generated_method = "2D365BC712D67BC8499DAC38B2692FC9")
        @Override
        public boolean add(E object) {
            boolean var8AF8A0D0EB560BBD1728F96A00026012_1405759243 = (m.put(object, Boolean.TRUE) == null);
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_760594980 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_760594980;
            // ---------- Original Method ----------
            //return m.put(object, Boolean.TRUE) == null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.892 -0400", hash_original_method = "5163CA2ED3AD9C66F2BDAFB902590115", hash_generated_method = "5C1448B76AB003BA7ABB7E55C1011B37")
        @Override
        public void clear() {
            m.clear();
            // ---------- Original Method ----------
            //m.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.894 -0400", hash_original_method = "C7069F73CC2FBE59B42FACF6A3731192", hash_generated_method = "30F7CD864F6157C7F7282F4AA10360D7")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_776533692 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_776533692 = backingSet.toString();
            varB4EAC82CA7396A68D541C85D26508E83_776533692.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_776533692;
            // ---------- Original Method ----------
            //return backingSet.toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.894 -0400", hash_original_method = "C1FDFEBBA860B6E21729D041F83BDE39", hash_generated_method = "FBA29B79EB745FF153CC24667A576F80")
        @Override
        public boolean contains(Object object) {
            boolean varD69ECD74FC2F79EA60C338071C7FC221_1729222750 = (backingSet.contains(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_658202383 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_658202383;
            // ---------- Original Method ----------
            //return backingSet.contains(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.903 -0400", hash_original_method = "652D3A93342A70291E00DB196A629050", hash_generated_method = "F9F285A1F22DAB0214137185AFB0EC27")
        @Override
        public boolean containsAll(Collection<?> collection) {
            boolean var3951AEBB2FFEF521655479A9D2D52542_653338466 = (backingSet.containsAll(collection));
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1465120576 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1465120576;
            // ---------- Original Method ----------
            //return backingSet.containsAll(collection);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.904 -0400", hash_original_method = "B9E63D3C52241E7E917CB1416ABA36E5", hash_generated_method = "A0EE2F2175C08BBA6B766A000252E58C")
        @Override
        public boolean isEmpty() {
            boolean var028CF644E61B84328EAB66D556672A81_1976374471 = (m.isEmpty());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1935985977 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1935985977;
            // ---------- Original Method ----------
            //return m.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.905 -0400", hash_original_method = "20C696E59013C16BDFED7021A5C3E797", hash_generated_method = "5D57E2B74946172A0B829C1FE53BEE95")
        @Override
        public boolean remove(Object object) {
            boolean varEA834B1BBE47D90EDF860853CDE90683_1876257829 = (m.remove(object) != null);
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_535374418 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_535374418;
            // ---------- Original Method ----------
            //return m.remove(object) != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.906 -0400", hash_original_method = "4A27ACEA2C9F194EF4597E8BDECC6BD7", hash_generated_method = "D9CE1F86AD234E680D754ABE8D30DA13")
        @Override
        public boolean retainAll(Collection<?> collection) {
            boolean varF15C5540B964CC478105DE5ACC25B10C_1802275724 = (backingSet.retainAll(collection));
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1305162222 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1305162222;
            // ---------- Original Method ----------
            //return backingSet.retainAll(collection);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.907 -0400", hash_original_method = "706FD57EC242D189F78C8F40D764E8D0", hash_generated_method = "E91FB39D2A7B5C33795150F133DD77D8")
        @Override
        public Object[] toArray() {
            Object[] varB4EAC82CA7396A68D541C85D26508E83_1922229762 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1922229762 = backingSet.toArray();
            varB4EAC82CA7396A68D541C85D26508E83_1922229762.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1922229762;
            // ---------- Original Method ----------
            //return backingSet.toArray();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.907 -0400", hash_original_method = "5B684176C593DE73F99AF08724DF65D4", hash_generated_method = "19844A8172CB76F8CB2795632E518BCF")
        @Override
        public <T> T[] toArray(T[] contents) {
            T[] varB4EAC82CA7396A68D541C85D26508E83_1691936513 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1691936513 = backingSet.toArray(contents);
            addTaint(contents[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1691936513.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1691936513;
            // ---------- Original Method ----------
            //return backingSet.toArray(contents);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.932 -0400", hash_original_method = "2EC39271104239DED882FB25EFF4BC23", hash_generated_method = "9FEE140A678D81AD94560B726E4EC342")
        @Override
        public Iterator<E> iterator() {
            Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_1307651761 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1307651761 = backingSet.iterator();
            varB4EAC82CA7396A68D541C85D26508E83_1307651761.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1307651761;
            // ---------- Original Method ----------
            //return backingSet.iterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.933 -0400", hash_original_method = "A04EE09DEB6F21FAA6A7E10DF6401CD1", hash_generated_method = "0FDE7BE3A2D91B1C35D23840D76433E0")
        @Override
        public int size() {
            int varDBD6E28F15F3D13B8127CF62DD69ACD5_1511586554 = (m.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_134263781 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_134263781;
            // ---------- Original Method ----------
            //return m.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.933 -0400", hash_original_method = "8082AE1FFA2825B9433C3082C2F87EDC", hash_generated_method = "22988C980D2DF3F54BA0C1ADFC122910")
        @SuppressWarnings("unchecked")
        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
            stream.defaultReadObject();
            backingSet = m.keySet();
            addTaint(stream.getTaint());
            // ---------- Original Method ----------
            //stream.defaultReadObject();
            //backingSet = m.keySet();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.933 -0400", hash_original_field = "68A2EE38D4624ED7EDE7470F4422D17A", hash_generated_field = "FD9A9003D1EC445F04D9A6B4A103D2D2")

        private static long serialVersionUID = 2454657854757543876L;
    }


    
    private static class AsLIFOQueue<E> extends AbstractQueue<E> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.934 -0400", hash_original_field = "7694F4A66316E53C8CDD9D9954BD611D", hash_generated_field = "8E692B16EB19650DAECD0B8A91F62E63")

        private Deque<E> q;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.938 -0400", hash_original_method = "C9A3AEFCC3A9FEA0CFED796FADB14DA4", hash_generated_method = "8C725C5253844AF6C1706232C12CC260")
          AsLIFOQueue(final Deque<E> deque) {
            this.q = deque;
            // ---------- Original Method ----------
            //this.q = deque;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.939 -0400", hash_original_method = "D6ABAC5AC9E31C28EFD449012F8C668D", hash_generated_method = "F301A988FF063B047293A8D5A87AC54C")
        @Override
        public Iterator<E> iterator() {
            Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_1007099600 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1007099600 = q.iterator();
            varB4EAC82CA7396A68D541C85D26508E83_1007099600.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1007099600;
            // ---------- Original Method ----------
            //return q.iterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.939 -0400", hash_original_method = "4D120CFD44D3EE91A03411EED1F5CA02", hash_generated_method = "8E2712A773D2F96639BA9D673B1D78D9")
        @Override
        public int size() {
            int var8E6A4AAEA94D20962C54C20127D7D8DC_789394883 = (q.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2104863401 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2104863401;
            // ---------- Original Method ----------
            //return q.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.939 -0400", hash_original_method = "A29AB2808D45581589F8B0269F283532", hash_generated_method = "6134290A462156E777F499B2588CEC4F")
        @Override
        public boolean offer(E o) {
            boolean var131D1A648D23B0B634478E3172B0A3D9_1438305413 = (q.offerFirst(o));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_652374696 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_652374696;
            // ---------- Original Method ----------
            //return q.offerFirst(o);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.941 -0400", hash_original_method = "286FFABBC697C1CEE6C49194F85DD481", hash_generated_method = "E05679EB2C348900E8577994A1E37DD2")
        @Override
        public E peek() {
            E varB4EAC82CA7396A68D541C85D26508E83_540631153 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_540631153 = q.peekFirst();
            varB4EAC82CA7396A68D541C85D26508E83_540631153.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_540631153;
            // ---------- Original Method ----------
            //return q.peekFirst();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.942 -0400", hash_original_method = "93EF986205EA0EFDB6E2F2BDD9DDBDB0", hash_generated_method = "D74A943BE775CEFC84A206BB49ACF7FB")
        @Override
        public E poll() {
            E varB4EAC82CA7396A68D541C85D26508E83_608577846 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_608577846 = q.pollFirst();
            varB4EAC82CA7396A68D541C85D26508E83_608577846.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_608577846;
            // ---------- Original Method ----------
            //return q.pollFirst();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.942 -0400", hash_original_method = "E16BCF0F708E6336497510D255228AB4", hash_generated_method = "43FBCD0E554ED3F46CE3D7B071E101FA")
        @Override
        public boolean add(E o) {
            q.push(o);
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1046700588 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1046700588;
            // ---------- Original Method ----------
            //q.push(o);
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.942 -0400", hash_original_method = "ECF3C7555AB121202E1C39938D734656", hash_generated_method = "72AFA896F4EE9665FC95334E69A68411")
        @Override
        public void clear() {
            q.clear();
            // ---------- Original Method ----------
            //q.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.958 -0400", hash_original_method = "41C0874A8589B77FE1309E3303509F6A", hash_generated_method = "9C827776D58335847165C7F510E2E09E")
        @Override
        public E element() {
            E varB4EAC82CA7396A68D541C85D26508E83_1647617768 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1647617768 = q.getFirst();
            varB4EAC82CA7396A68D541C85D26508E83_1647617768.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1647617768;
            // ---------- Original Method ----------
            //return q.getFirst();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.962 -0400", hash_original_method = "DBCAD9866D0C084DC455BF7C95ABCE77", hash_generated_method = "69F90531E3BED79762FED94E7A3DB4DF")
        @Override
        public E remove() {
            E varB4EAC82CA7396A68D541C85D26508E83_883343222 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_883343222 = q.pop();
            varB4EAC82CA7396A68D541C85D26508E83_883343222.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_883343222;
            // ---------- Original Method ----------
            //return q.pop();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.962 -0400", hash_original_method = "2E730D7ABEE184A9C34DA57DF7A457EE", hash_generated_method = "FD66B8232A33D63FC7D3DBF0799E3F89")
        @Override
        public boolean contains(Object object) {
            boolean varD460130636362755C09A666172F1A628_59300168 = (q.contains(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1239453508 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1239453508;
            // ---------- Original Method ----------
            //return q.contains(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.963 -0400", hash_original_method = "3E9E9A2983E74090844621EE9CF6D3D7", hash_generated_method = "E3DC2289776478AAADC2F3EF4CB72832")
        @Override
        public boolean containsAll(Collection<?> collection) {
            boolean varDE8FC932F21B2025BA6D50595BD45CF0_1053233660 = (q.containsAll(collection));
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_588040820 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_588040820;
            // ---------- Original Method ----------
            //return q.containsAll(collection);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.963 -0400", hash_original_method = "3014069A2B40728BACBB472823CCCF21", hash_generated_method = "184F73B3EB04195735ADC7EE79F75A5D")
        @Override
        public boolean isEmpty() {
            boolean varFE3524B5D20384639CE6FC4B24FAEE92_322774657 = (q.isEmpty());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1914689436 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1914689436;
            // ---------- Original Method ----------
            //return q.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.963 -0400", hash_original_method = "06C06D3351623BFF7BABDE8B40334F59", hash_generated_method = "7A4F51A26F093DC69F9C886799C85434")
        @Override
        public boolean remove(Object object) {
            boolean var430DB2157F91E84964C83805E66926D1_1114819623 = (q.remove(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_58877389 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_58877389;
            // ---------- Original Method ----------
            //return q.remove(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.964 -0400", hash_original_method = "13975D6542267AD488C8D9B27A0905D7", hash_generated_method = "803AEEAA36B8F42A6F617DD1EA52B571")
        @Override
        public boolean removeAll(Collection<?> collection) {
            boolean varA36A955574116D3C6092CC37D2496B72_1456203370 = (q.removeAll(collection));
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1246372550 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1246372550;
            // ---------- Original Method ----------
            //return q.removeAll(collection);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.964 -0400", hash_original_method = "029F8EE40CDE382EFA7F7BF13B8FE731", hash_generated_method = "823A87BBA3AE771FA65EE34A84CE5E32")
        @Override
        public boolean retainAll(Collection<?> collection) {
            boolean varF8C783496DD8D05EB5484CABE3DF69DA_1151152438 = (q.retainAll(collection));
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_638117757 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_638117757;
            // ---------- Original Method ----------
            //return q.retainAll(collection);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.964 -0400", hash_original_method = "81809EBBF1D8298961C4E9B761FEF748", hash_generated_method = "F55CE69925DA0E5F084A706AF20EA675")
        @Override
        public Object[] toArray() {
            Object[] varB4EAC82CA7396A68D541C85D26508E83_1514949720 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1514949720 = q.toArray();
            varB4EAC82CA7396A68D541C85D26508E83_1514949720.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1514949720;
            // ---------- Original Method ----------
            //return q.toArray();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.965 -0400", hash_original_method = "3C7918E789D95B2A97E0F45A2E8277E0", hash_generated_method = "1EFD19EAA06F8AAD257A60AB72858B88")
        @Override
        public <T> T[] toArray(T[] contents) {
            T[] varB4EAC82CA7396A68D541C85D26508E83_1820375514 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1820375514 = q.toArray(contents);
            addTaint(contents[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1820375514.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1820375514;
            // ---------- Original Method ----------
            //return q.toArray(contents);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.965 -0400", hash_original_method = "827F98847BB1D6CEA3B0A324A45F92ED", hash_generated_method = "E29AA33CF6FA668FD12027DE393D88EA")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_2139142323 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2139142323 = q.toString();
            varB4EAC82CA7396A68D541C85D26508E83_2139142323.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2139142323;
            // ---------- Original Method ----------
            //return q.toString();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.965 -0400", hash_original_field = "7C5B063F84AD7FF4280E3FC6C2D641FE", hash_generated_field = "A7C90C9954FF9FB934BEFD4B3F84C9C7")

        private static long serialVersionUID = 1802017725587941708L;
    }


    
    private static class CheckedCollection<E> implements Collection<E>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.965 -0400", hash_original_field = "4A8A08F09D37B73795649038408B5F33", hash_generated_field = "A3C80A7E02E49F20400373DFBAF9696A")

        Collection<E> c;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.965 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "D40602D541C2081B4D03EEADC8718DAD")

        Class<E> type;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.966 -0400", hash_original_method = "4DAA5B7D63536360D367B6279A6FD0F0", hash_generated_method = "7A376838DD673D1FBA51D92C8AABBFD1")
        public  CheckedCollection(Collection<E> c, Class<E> type) {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.966 -0400", hash_original_method = "AC97C28F724592ABA809E2470D95C119", hash_generated_method = "00AD731D432DB385A3BF7F384855D047")
        @Override
        public int size() {
            int varC247C84593AA6020ED979B19566D13FE_527765225 = (c.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1172467255 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1172467255;
            // ---------- Original Method ----------
            //return c.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.966 -0400", hash_original_method = "F9A3CB1FB7570D28EBE20660E2FC6F42", hash_generated_method = "A0673426DA535FDFCBDE9D2D58DF4569")
        @Override
        public boolean isEmpty() {
            boolean var528EAD02A70F822F393BB0C54FBB923C_1175503413 = (c.isEmpty());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1952410230 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1952410230;
            // ---------- Original Method ----------
            //return c.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.967 -0400", hash_original_method = "AA502F510015E56A50E854673F52B13D", hash_generated_method = "BF1CCE25960648DE47C04982D162B487")
        @Override
        public boolean contains(Object obj) {
            boolean var9701AC7B8B31DABE176EC8837E090033_331237445 = (c.contains(obj));
            addTaint(obj.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_50640991 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_50640991;
            // ---------- Original Method ----------
            //return c.contains(obj);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.987 -0400", hash_original_method = "A49A579D720F57F247BFFB420B912FC7", hash_generated_method = "703485CD7FA9731D7C3B1568F5DA4092")
        @Override
        public Iterator<E> iterator() {
            Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_109647954 = null; //Variable for return #1
            Iterator<E> i;
            i = c.iterator();
            {
                i = new CheckedListIterator<E>((ListIterator<E>) i, type);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_109647954 = i;
            varB4EAC82CA7396A68D541C85D26508E83_109647954.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_109647954;
            // ---------- Original Method ----------
            //Iterator<E> i = c.iterator();
            //if (i instanceof ListIterator) {
                //i = new CheckedListIterator<E>((ListIterator<E>) i, type);
            //}
            //return i;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.988 -0400", hash_original_method = "89D7D02A9D2BDF31E775C08108CBDE5B", hash_generated_method = "110D7DC78CA7A166A1FD31A6816E2219")
        @Override
        public Object[] toArray() {
            Object[] varB4EAC82CA7396A68D541C85D26508E83_74400128 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_74400128 = c.toArray();
            varB4EAC82CA7396A68D541C85D26508E83_74400128.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_74400128;
            // ---------- Original Method ----------
            //return c.toArray();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.988 -0400", hash_original_method = "9B8166862C116AE305DE64E80811892F", hash_generated_method = "C52A8639F52E8A8DA8AEFE2035848FFF")
        @Override
        public <T> T[] toArray(T[] arr) {
            T[] varB4EAC82CA7396A68D541C85D26508E83_184543263 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_184543263 = c.toArray(arr);
            addTaint(arr[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_184543263.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_184543263;
            // ---------- Original Method ----------
            //return c.toArray(arr);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.989 -0400", hash_original_method = "233202E3883C87159328A7DF45C5A0DD", hash_generated_method = "F80CD8C706DF242CF89D1E47ECA37197")
        @Override
        public boolean add(E obj) {
            boolean var7C3742253C6BF2735A6EB74A5190709F_1444575009 = (c.add(checkType(obj, type)));
            addTaint(obj.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1823376790 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1823376790;
            // ---------- Original Method ----------
            //return c.add(checkType(obj, type));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.989 -0400", hash_original_method = "A7C1CDA142B015DD1AAB47325584260A", hash_generated_method = "C5D478F120EB88A880714DB9C98FFBD0")
        @Override
        public boolean remove(Object obj) {
            boolean varA24294D934B215AF55F3D7CE5097D547_1650334757 = (c.remove(obj));
            addTaint(obj.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_366566422 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_366566422;
            // ---------- Original Method ----------
            //return c.remove(obj);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.989 -0400", hash_original_method = "8A54483E259CA6D3C8AB1EBE7493D296", hash_generated_method = "9513EFF5B42CA19C6FF79DB117092368")
        @Override
        public boolean containsAll(Collection<?> c1) {
            boolean varFFF4D0CC6EA0E1A2D080D41D81BC6C1F_1075189422 = (c.containsAll(c1));
            addTaint(c1.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_345239821 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_345239821;
            // ---------- Original Method ----------
            //return c.containsAll(c1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.011 -0400", hash_original_method = "A2391F235E9474A0C2FADB6F2C5C2AB0", hash_generated_method = "B7CA74E384A8F5C77247B87E72CB7AB1")
        @SuppressWarnings("unchecked")
        @Override
        public boolean addAll(Collection<? extends E> c1) {
            Object[] array;
            array = c1.toArray();
            {
                Iterator<Object> varE9BE5E7924F9D605B7D95BF8D41D5A3D_1036267861 = (array).iterator();
                varE9BE5E7924F9D605B7D95BF8D41D5A3D_1036267861.hasNext();
                Object o = varE9BE5E7924F9D605B7D95BF8D41D5A3D_1036267861.next();
                {
                    checkType(o, type);
                } //End block
            } //End collapsed parenthetic
            boolean var4F43D86A78906FAA31F77A4D0C40B6E3_1930761386 = (c.addAll((List<E>) Arrays.asList(array)));
            addTaint(c1.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1903708076 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1903708076;
            // ---------- Original Method ----------
            //Object[] array = c1.toArray();
            //for (Object o : array) {
                //checkType(o, type);
            //}
            //return c.addAll((List<E>) Arrays.asList(array));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.030 -0400", hash_original_method = "E5A4F3F5A50F475A125F07680365C964", hash_generated_method = "FC6957D9CD520C4ED869BC01DE196471")
        @Override
        public boolean removeAll(Collection<?> c1) {
            boolean var6FAA02017CB91A1460E8557E32B16FBC_543701903 = (c.removeAll(c1));
            addTaint(c1.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_590429757 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_590429757;
            // ---------- Original Method ----------
            //return c.removeAll(c1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.036 -0400", hash_original_method = "2CCBBE73D1665A80965D3FA8CB644A3B", hash_generated_method = "58DD50ADBA9E650105FD8F224DCA2BAB")
        @Override
        public boolean retainAll(Collection<?> c1) {
            boolean var1BAABDC5B6ADB4CC0AE277B58A4293BA_6820641 = (c.retainAll(c1));
            addTaint(c1.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1983602650 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1983602650;
            // ---------- Original Method ----------
            //return c.retainAll(c1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.036 -0400", hash_original_method = "C75B179C04D460F62AB7F39D0D292067", hash_generated_method = "A8F69290363AB2D00FEDD4A5A3BF8CF2")
        @Override
        public void clear() {
            c.clear();
            // ---------- Original Method ----------
            //c.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.037 -0400", hash_original_method = "424D4966F358AE6553349A6493C21674", hash_generated_method = "85CF715BD53A1960E09C0DAFC1856E39")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_295599220 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_295599220 = c.toString();
            varB4EAC82CA7396A68D541C85D26508E83_295599220.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_295599220;
            // ---------- Original Method ----------
            //return c.toString();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.037 -0400", hash_original_field = "19984F6C6BA7815BBDF7C18EF9C975B4", hash_generated_field = "091117B9F49B1DAD7ABFBC5927C87468")

        private static long serialVersionUID = 1578914078182001775L;
    }


    
    private static class CheckedListIterator<E> implements ListIterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.037 -0400", hash_original_field = "865C0C0B4AB0E063E5CAA3387C1A8741", hash_generated_field = "A3E111A0B732842F8B9E259D3903708E")

        private ListIterator<E> i;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.037 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "44DD73C068DAE541C380477699D61FAF")

        private Class<E> type;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.037 -0400", hash_original_method = "0B7AAA10EE83BBF7A614BF8D8C7A7C84", hash_generated_method = "8BB9DF0BD458C6C58CAD8ED7A978114C")
        public  CheckedListIterator(ListIterator<E> i, Class<E> type) {
            this.i = i;
            this.type = type;
            // ---------- Original Method ----------
            //this.i = i;
            //this.type = type;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.038 -0400", hash_original_method = "59CA86A80410B66286C92523CF35EC7B", hash_generated_method = "BF70C2D70199B588D69B9E3D487A13BB")
        @Override
        public boolean hasNext() {
            boolean var1611849CD1EE22EA22E4E7E3327E2E35_436795849 = (i.hasNext());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2109129249 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2109129249;
            // ---------- Original Method ----------
            //return i.hasNext();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.038 -0400", hash_original_method = "A2FD0994E634C5BCE4D27AD9176E9A5A", hash_generated_method = "3F0C1C95EFD8A6B19FA5B1750E4B706A")
        @Override
        public E next() {
            E varB4EAC82CA7396A68D541C85D26508E83_1286923636 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1286923636 = i.next();
            varB4EAC82CA7396A68D541C85D26508E83_1286923636.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1286923636;
            // ---------- Original Method ----------
            //return i.next();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.038 -0400", hash_original_method = "048FA6C3E3A28865AD880AF8A3FCAE96", hash_generated_method = "598E37F558FC71BB5A0DA7BBE13EE694")
        @Override
        public void remove() {
            i.remove();
            // ---------- Original Method ----------
            //i.remove();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.052 -0400", hash_original_method = "BBFFF3658F03DC70BAED5B88BBE801F9", hash_generated_method = "9959D541D2FF9188DC836F740FEC0BDD")
        @Override
        public boolean hasPrevious() {
            boolean var1FCC7ECF60E98FFA6572F3122E374C7E_1757084500 = (i.hasPrevious());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_157245464 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_157245464;
            // ---------- Original Method ----------
            //return i.hasPrevious();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.052 -0400", hash_original_method = "BC73D9B40C1A828CB3DD11A00CF4E28D", hash_generated_method = "F1D5DC7248BE87B2A95B5DC608CE6437")
        @Override
        public E previous() {
            E varB4EAC82CA7396A68D541C85D26508E83_174180198 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_174180198 = i.previous();
            varB4EAC82CA7396A68D541C85D26508E83_174180198.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_174180198;
            // ---------- Original Method ----------
            //return i.previous();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.052 -0400", hash_original_method = "E41D02CE1A7D09C2351DC91043CD0C1F", hash_generated_method = "E783C9717C0E7E619992360F8A81B0E7")
        @Override
        public int nextIndex() {
            int var97CCB58C3C2141B73F996BC540E6EAF5_914859017 = (i.nextIndex());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1523318272 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1523318272;
            // ---------- Original Method ----------
            //return i.nextIndex();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.053 -0400", hash_original_method = "F0908B37AEEE31348E4E446BDB2DC11E", hash_generated_method = "4CA91743B0E25770443248F9750788AB")
        @Override
        public int previousIndex() {
            int var9F734927211780D2EA84E984ED22702D_1971295355 = (i.previousIndex());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_13014290 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_13014290;
            // ---------- Original Method ----------
            //return i.previousIndex();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.053 -0400", hash_original_method = "F06067E5C50A33BA33028ACBB7E94E5C", hash_generated_method = "8CAFD41758A91E7AEC87DE235FEEAD5B")
        @Override
        public void set(E obj) {
            i.set(checkType(obj, type));
            addTaint(obj.getTaint());
            // ---------- Original Method ----------
            //i.set(checkType(obj, type));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.053 -0400", hash_original_method = "3A7C6206CDBE5C448C8E83D10145E877", hash_generated_method = "CB1ACD56A14B73EB8E1500AEF3BEBC77")
        @Override
        public void add(E obj) {
            i.add(checkType(obj, type));
            addTaint(obj.getTaint());
            // ---------- Original Method ----------
            //i.add(checkType(obj, type));
        }

        
    }


    
    private static class CheckedList<E> extends CheckedCollection<E> implements List<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.053 -0400", hash_original_field = "2DB95E8E1A9267B7A1188556B2013B33", hash_generated_field = "BA44D98E464F3917B2E777BB565BC0D3")

        List<E> l;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.054 -0400", hash_original_method = "50AAAF0EF026911FE0274184FEF9C1C3", hash_generated_method = "5D3DF5FB69105266A81A924324B66768")
        public  CheckedList(List<E> l, Class<E> type) {
            super(l, type);
            this.l = l;
            addTaint(type.getTaint());
            // ---------- Original Method ----------
            //this.l = l;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.087 -0400", hash_original_method = "8A1A291116E92C540879607029C861C6", hash_generated_method = "D6DA0CAA39730ECDBE1EA63493FFBC80")
        @SuppressWarnings("unchecked")
        @Override
        public boolean addAll(int index, Collection<? extends E> c1) {
            Object[] array;
            array = c1.toArray();
            {
                Iterator<Object> varE9BE5E7924F9D605B7D95BF8D41D5A3D_819397688 = (array).iterator();
                varE9BE5E7924F9D605B7D95BF8D41D5A3D_819397688.hasNext();
                Object o = varE9BE5E7924F9D605B7D95BF8D41D5A3D_819397688.next();
                {
                    checkType(o, type);
                } //End block
            } //End collapsed parenthetic
            boolean var720AF4600E5540369BE417DBAEE92DFA_753130096 = (l.addAll(index, (List<E>) Arrays.asList(array)));
            addTaint(index);
            addTaint(c1.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_607897894 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_607897894;
            // ---------- Original Method ----------
            //Object[] array = c1.toArray();
            //for (Object o : array) {
                //checkType(o, type);
            //}
            //return l.addAll(index, (List<E>) Arrays.asList(array));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.097 -0400", hash_original_method = "12BB9FAB0B921E0E98205977740A217D", hash_generated_method = "3E286A08BB77CE74D4E3686E5192A9C1")
        @Override
        public E get(int index) {
            E varB4EAC82CA7396A68D541C85D26508E83_1192573595 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1192573595 = l.get(index);
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_1192573595.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1192573595;
            // ---------- Original Method ----------
            //return l.get(index);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.098 -0400", hash_original_method = "B15A1B3ABEAB19644273A7FDAFDFF4C3", hash_generated_method = "C92796E7450D21FBEACD3ED8D46B9205")
        @Override
        public E set(int index, E obj) {
            E varB4EAC82CA7396A68D541C85D26508E83_482126662 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_482126662 = l.set(index, checkType(obj, type));
            addTaint(index);
            addTaint(obj.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_482126662.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_482126662;
            // ---------- Original Method ----------
            //return l.set(index, checkType(obj, type));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.098 -0400", hash_original_method = "97AC3A6F1A8F1F91D88637C439308CAA", hash_generated_method = "52B4CEA0E1571112BDBE5428D02E17E5")
        @Override
        public void add(int index, E obj) {
            l.add(index, checkType(obj, type));
            addTaint(index);
            addTaint(obj.getTaint());
            // ---------- Original Method ----------
            //l.add(index, checkType(obj, type));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.111 -0400", hash_original_method = "B7A754E9641B79EF3AC643C6FA162631", hash_generated_method = "04EDE0C563E0CB6BAE46A909A4E8C6AB")
        @Override
        public E remove(int index) {
            E varB4EAC82CA7396A68D541C85D26508E83_1321970789 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1321970789 = l.remove(index);
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_1321970789.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1321970789;
            // ---------- Original Method ----------
            //return l.remove(index);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.111 -0400", hash_original_method = "EB95E25E6439350950712FBE2C177EC4", hash_generated_method = "E02EE060D79F75DE9B261DC1B5336E34")
        @Override
        public int indexOf(Object obj) {
            int varBB0CC98524B808CD822A2164B51F33B8_399116899 = (l.indexOf(obj));
            addTaint(obj.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1617335424 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1617335424;
            // ---------- Original Method ----------
            //return l.indexOf(obj);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.111 -0400", hash_original_method = "4C828EC3A9818E335BF8E9F8513B24F5", hash_generated_method = "2DC7BFDB647E1D53EC7CF86E43AB16D8")
        @Override
        public int lastIndexOf(Object obj) {
            int var68D523AC731688651041C374F25CAB09_980878518 = (l.lastIndexOf(obj));
            addTaint(obj.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_921236047 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_921236047;
            // ---------- Original Method ----------
            //return l.lastIndexOf(obj);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.112 -0400", hash_original_method = "9293980ECFF31B033CDADFB0ED26EA69", hash_generated_method = "1685A18B97FDE2A8232F834D202AEDAE")
        @Override
        public ListIterator<E> listIterator() {
            ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_628486792 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_628486792 = new CheckedListIterator<E>(l.listIterator(), type);
            varB4EAC82CA7396A68D541C85D26508E83_628486792.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_628486792;
            // ---------- Original Method ----------
            //return new CheckedListIterator<E>(l.listIterator(), type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.113 -0400", hash_original_method = "31D39D7FEEE82D7A15D00B805CB5EAA4", hash_generated_method = "4F6CE08227C318808CDB545AFAD0B440")
        @Override
        public ListIterator<E> listIterator(int index) {
            ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_2003575541 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2003575541 = new CheckedListIterator<E>(l.listIterator(index), type);
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_2003575541.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2003575541;
            // ---------- Original Method ----------
            //return new CheckedListIterator<E>(l.listIterator(index), type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.114 -0400", hash_original_method = "A5E1EFD4B2650099AC132BF86B97D88F", hash_generated_method = "D1548A2EC17C1619304FF61F76C6D687")
        @Override
        public List<E> subList(int fromIndex, int toIndex) {
            List<E> varB4EAC82CA7396A68D541C85D26508E83_354289867 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_354289867 = checkedList(l.subList(fromIndex, toIndex), type);
            addTaint(fromIndex);
            addTaint(toIndex);
            varB4EAC82CA7396A68D541C85D26508E83_354289867.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_354289867;
            // ---------- Original Method ----------
            //return checkedList(l.subList(fromIndex, toIndex), type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.135 -0400", hash_original_method = "A14AE2E014BAD465F594EE49A5008ED4", hash_generated_method = "560455CA6532594B9CC3AD40FAC4456D")
        @Override
        public boolean equals(Object obj) {
            boolean var559B3B39BC42D814993568E544C6FE1F_1078694473 = (l.equals(obj));
            addTaint(obj.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_171869281 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_171869281;
            // ---------- Original Method ----------
            //return l.equals(obj);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.135 -0400", hash_original_method = "410D1D1B2E05F678DF3AB7D6BB08AEDB", hash_generated_method = "F3DB7FDD89B6F15963B735BAF4008083")
        @Override
        public int hashCode() {
            int var283F03AD18DE255D000FAC9E62BDE6F0_221907696 = (l.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1521694633 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1521694633;
            // ---------- Original Method ----------
            //return l.hashCode();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.135 -0400", hash_original_field = "39F320D681E769EFF91E942BCC4C3E88", hash_generated_field = "D55A034AEBEAC16894A59690D71E1080")

        private static long serialVersionUID = 65247728283967356L;
    }


    
    private static class CheckedRandomAccessList<E> extends CheckedList<E> implements RandomAccess {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.136 -0400", hash_original_method = "77F175BCE2CEB5DECA5010A8855616A0", hash_generated_method = "6A34077878FEA1687712F87D427AF583")
        public  CheckedRandomAccessList(List<E> l, Class<E> type) {
            super(l, type);
            addTaint(l.getTaint());
            addTaint(type.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.136 -0400", hash_original_field = "27B375DBE9246C47DAC482882EF8DD4B", hash_generated_field = "7DB34F51EB5AF413DD89FC53AA2997EE")

        private static long serialVersionUID = 1638200125423088369L;
    }


    
    private static class CheckedSet<E> extends CheckedCollection<E> implements Set<E> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.136 -0400", hash_original_method = "515963C9B1280D5707D3A720329B0AC0", hash_generated_method = "34498A77713E1963E42E5270114D0C84")
        public  CheckedSet(Set<E> s, Class<E> type) {
            super(s, type);
            addTaint(s.getTaint());
            addTaint(type.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.136 -0400", hash_original_method = "F33AC6E694EC5A5F3A81FF749707DDFC", hash_generated_method = "4CFB8C8FC9D779AB06DFB8BC83B7F7A2")
        @Override
        public boolean equals(Object obj) {
            boolean varC91792C7DD4F0C8E92E42617036EED48_610157340 = (c.equals(obj));
            addTaint(obj.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_698990398 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_698990398;
            // ---------- Original Method ----------
            //return c.equals(obj);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.137 -0400", hash_original_method = "E858D80F3EEDE9F2B52CDB7DA7FBF12B", hash_generated_method = "A9563003D8E187F063D4474532D48CC4")
        @Override
        public int hashCode() {
            int var19B3D08FE3840D0D3E365DF71EF3E20C_1914073991 = (c.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1851929370 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1851929370;
            // ---------- Original Method ----------
            //return c.hashCode();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.137 -0400", hash_original_field = "C306DCFF324211BB06F1EDC3B62DB01C", hash_generated_field = "E62252938195E14E1B45045DEF3D887B")

        private static long serialVersionUID = 4694047833775013803L;
    }


    
    private static class CheckedMap<K, V> implements Map<K, V>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.137 -0400", hash_original_field = "6F8F57715090DA2632453988D9A1501B", hash_generated_field = "B770F05C5A3A992B6F65D731F667A79E")

        Map<K, V> m;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.137 -0400", hash_original_field = "056E0360B75D77ECE0AE955FE59BF15D", hash_generated_field = "F010784A251FB129AC47F47773283FBF")

        Class<K> keyType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.137 -0400", hash_original_field = "B96763B95160CC0943BE0DE4743A115B", hash_generated_field = "DE39CA4821E18DB5E7A7F09BBC028CB4")

        Class<V> valueType;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.137 -0400", hash_original_method = "906A4960963B0F972E50BE617CA562B3", hash_generated_method = "8450A17B2A66D687691112D6942B9B1A")
        private  CheckedMap(Map<K, V> m, Class<K> keyType, Class<V> valueType) {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.146 -0400", hash_original_method = "A04EE09DEB6F21FAA6A7E10DF6401CD1", hash_generated_method = "81FF2F66284AE10AED7BBE7BAACC9CD8")
        @Override
        public int size() {
            int varDBD6E28F15F3D13B8127CF62DD69ACD5_1806400334 = (m.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_339080861 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_339080861;
            // ---------- Original Method ----------
            //return m.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.146 -0400", hash_original_method = "B9E63D3C52241E7E917CB1416ABA36E5", hash_generated_method = "D07C2E5C1C4D7AF4B416C585E77A4B22")
        @Override
        public boolean isEmpty() {
            boolean var028CF644E61B84328EAB66D556672A81_253433400 = (m.isEmpty());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2084811605 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2084811605;
            // ---------- Original Method ----------
            //return m.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.146 -0400", hash_original_method = "A6C730848D8A626F99D8229EE744E3C0", hash_generated_method = "16BE0D8BAB912A92D664A621A8BB847B")
        @Override
        public boolean containsKey(Object key) {
            boolean var2519B7EF565FEC21B6285F5E44AC148E_598737829 = (m.containsKey(key));
            addTaint(key.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1982146399 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1982146399;
            // ---------- Original Method ----------
            //return m.containsKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.147 -0400", hash_original_method = "EF8C00CF950E8C186D2F05E1E556F384", hash_generated_method = "22C9E6F224ACE019D7FE7A965EA63999")
        @Override
        public boolean containsValue(Object value) {
            boolean varF8CB74E2C5E0734947B397D82173BDD4_1152851056 = (m.containsValue(value));
            addTaint(value.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_418413171 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_418413171;
            // ---------- Original Method ----------
            //return m.containsValue(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.147 -0400", hash_original_method = "B8FE254B61C57EC3A6DCE539976DA268", hash_generated_method = "2F6D927A0805FB6BDEB7AD226CC577C6")
        @Override
        public V get(Object key) {
            V varB4EAC82CA7396A68D541C85D26508E83_1239280738 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1239280738 = m.get(key);
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1239280738.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1239280738;
            // ---------- Original Method ----------
            //return m.get(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.147 -0400", hash_original_method = "98010DFF1DD51631676FCAC604C1B694", hash_generated_method = "776727040322120B4D1E16A6A81EFD40")
        @Override
        public V put(K key, V value) {
            V varB4EAC82CA7396A68D541C85D26508E83_131539442 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_131539442 = m.put(checkType(key, keyType), checkType(value, valueType));
            addTaint(key.getTaint());
            addTaint(value.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_131539442.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_131539442;
            // ---------- Original Method ----------
            //return m.put(checkType(key, keyType), checkType(value, valueType));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.148 -0400", hash_original_method = "7E1C4ABAB7F4D30C9FA02B8AC4206202", hash_generated_method = "147C3FBE205610A7D00E8AA7A9B963B7")
        @Override
        public V remove(Object key) {
            V varB4EAC82CA7396A68D541C85D26508E83_708261519 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_708261519 = m.remove(key);
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_708261519.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_708261519;
            // ---------- Original Method ----------
            //return m.remove(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.148 -0400", hash_original_method = "7B09FD67E4091CD76439ADACD213D3A2", hash_generated_method = "DC739BC5EA75A054DFFDEC13A9E9E582")
        @SuppressWarnings("unchecked")
        @Override
        public void putAll(Map<? extends K, ? extends V> map) {
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
            addTaint(map.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.160 -0400", hash_original_method = "5163CA2ED3AD9C66F2BDAFB902590115", hash_generated_method = "5C1448B76AB003BA7ABB7E55C1011B37")
        @Override
        public void clear() {
            m.clear();
            // ---------- Original Method ----------
            //m.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.160 -0400", hash_original_method = "BC85ABF91A39D98F3F2ED0838950D9FC", hash_generated_method = "6217F812EA65BF0E0B2DC3D751B3366E")
        @Override
        public Set<K> keySet() {
            Set<K> varB4EAC82CA7396A68D541C85D26508E83_1535732593 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1535732593 = m.keySet();
            varB4EAC82CA7396A68D541C85D26508E83_1535732593.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1535732593;
            // ---------- Original Method ----------
            //return m.keySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.161 -0400", hash_original_method = "F6584059741E2818D171714370ED56BF", hash_generated_method = "C6A14C65D65C924027A5ED88B5045A2A")
        @Override
        public Collection<V> values() {
            Collection<V> varB4EAC82CA7396A68D541C85D26508E83_1596327314 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1596327314 = m.values();
            varB4EAC82CA7396A68D541C85D26508E83_1596327314.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1596327314;
            // ---------- Original Method ----------
            //return m.values();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.161 -0400", hash_original_method = "17C87BFAA3247941C0F3FE3FCE6C8B6B", hash_generated_method = "D4D8E50F6CDCA29B108B8C464A6B98CE")
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_2126294152 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2126294152 = new CheckedEntrySet<K, V>(m.entrySet(), valueType);
            varB4EAC82CA7396A68D541C85D26508E83_2126294152.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2126294152;
            // ---------- Original Method ----------
            //return new CheckedEntrySet<K, V>(m.entrySet(), valueType);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.161 -0400", hash_original_method = "5F45CB6F19E1E41DEEA3711399B994B8", hash_generated_method = "1AEEC2DE7F16DFDFCDD9C8BBE9E5C191")
        @Override
        public boolean equals(Object obj) {
            boolean var6519380B8603327E1D0BBD66320BEF0F_920109249 = (m.equals(obj));
            addTaint(obj.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1375008705 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1375008705;
            // ---------- Original Method ----------
            //return m.equals(obj);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.179 -0400", hash_original_method = "E3229E3389F030DD50B79734943DB788", hash_generated_method = "0F8898A87EFF6B7CD056888CF88F02EE")
        @Override
        public int hashCode() {
            int varAA1293165230C9829C1AEACFFF576DFC_324259590 = (m.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_844863245 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_844863245;
            // ---------- Original Method ----------
            //return m.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.179 -0400", hash_original_method = "5DD44B3CD2826BF39F974F66579CF74F", hash_generated_method = "B24E62D97E167378C6A9152962DE0558")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_823028548 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_823028548 = m.toString();
            varB4EAC82CA7396A68D541C85D26508E83_823028548.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_823028548;
            // ---------- Original Method ----------
            //return m.toString();
        }

        
        private static class CheckedEntry<K, V> implements Map.Entry<K, V> {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.179 -0400", hash_original_field = "E1671797C52E15F763380B45E841EC32", hash_generated_field = "FD10A3858A638ACB828326F81BE2C88B")

            Map.Entry<K, V> e;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.179 -0400", hash_original_field = "B96763B95160CC0943BE0DE4743A115B", hash_generated_field = "DE39CA4821E18DB5E7A7F09BBC028CB4")

            Class<V> valueType;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.180 -0400", hash_original_method = "7A5E92C112A4AAE1EEB574291E4B57B6", hash_generated_method = "F20992E3708DE849084FDE77877EB9F1")
            public  CheckedEntry(Map.Entry<K, V> e, Class<V> valueType) {
                {
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.180 -0400", hash_original_method = "10D87C621F2656D3DA7DCE234A4C3FAC", hash_generated_method = "268D7827A617C8F1EB90C0AEE0B53392")
            @Override
            public K getKey() {
                K varB4EAC82CA7396A68D541C85D26508E83_906665375 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_906665375 = e.getKey();
                varB4EAC82CA7396A68D541C85D26508E83_906665375.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_906665375;
                // ---------- Original Method ----------
                //return e.getKey();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.181 -0400", hash_original_method = "8EF21B2292AA31AAE181B3282F3F0262", hash_generated_method = "DE20C74D607E3147C8F1E25A0D81FD89")
            @Override
            public V getValue() {
                V varB4EAC82CA7396A68D541C85D26508E83_1786861461 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1786861461 = e.getValue();
                varB4EAC82CA7396A68D541C85D26508E83_1786861461.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1786861461;
                // ---------- Original Method ----------
                //return e.getValue();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.181 -0400", hash_original_method = "22C63BC622BE9DF4D2BED624BDB5B6B5", hash_generated_method = "8391355658FD43A2D95912987496C55B")
            @Override
            public V setValue(V obj) {
                V varB4EAC82CA7396A68D541C85D26508E83_1393028805 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1393028805 = e.setValue(checkType(obj, valueType));
                addTaint(obj.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_1393028805.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1393028805;
                // ---------- Original Method ----------
                //return e.setValue(checkType(obj, valueType));
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.181 -0400", hash_original_method = "0FE63D6CB37B8BF21266876509A7EAAA", hash_generated_method = "27055D55F487B318AEB8291E5C21EF93")
            @Override
            public boolean equals(Object obj) {
                boolean var5F98FA9F6CA964453675BAF27F4B0002_940181594 = (e.equals(obj));
                addTaint(obj.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_176259642 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_176259642;
                // ---------- Original Method ----------
                //return e.equals(obj);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.182 -0400", hash_original_method = "02C3AF7FB3CFA22B693B83D22D208AF4", hash_generated_method = "62CC3E63B46C26CF0C90CD2A706D8B00")
            @Override
            public int hashCode() {
                int varB0D5769FD2A442E362DC4438ABD8230C_37336015 = (e.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1679620898 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1679620898;
                // ---------- Original Method ----------
                //return e.hashCode();
            }

            
        }


        
        private static class CheckedEntrySet<K, V> implements Set<Map.Entry<K, V>> {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.182 -0400", hash_original_field = "03C7C0ACE395D80182DB07AE2C30F034", hash_generated_field = "00162E30A8FD9ACC3B5664D702737B9D")

            Set<Map.Entry<K, V>> s;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.182 -0400", hash_original_field = "B96763B95160CC0943BE0DE4743A115B", hash_generated_field = "DE39CA4821E18DB5E7A7F09BBC028CB4")

            Class<V> valueType;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.182 -0400", hash_original_method = "77FA7326B6BB5621E7FE63699FC58F08", hash_generated_method = "B92FFB70DAF3A02ECD73F8C030E830C0")
            public  CheckedEntrySet(Set<Map.Entry<K, V>> s, Class<V> valueType) {
                this.s = s;
                this.valueType = valueType;
                // ---------- Original Method ----------
                //this.s = s;
                //this.valueType = valueType;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.183 -0400", hash_original_method = "448F3F9279BA75C161BF1A7F97E105A4", hash_generated_method = "CBC53FDF747179DC84AB5480FA5436B8")
            @Override
            public Iterator<Map.Entry<K, V>> iterator() {
                Iterator<Map.Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_1106150298 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1106150298 = new CheckedEntryIterator<K, V>(s.iterator(), valueType);
                varB4EAC82CA7396A68D541C85D26508E83_1106150298.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1106150298;
                // ---------- Original Method ----------
                //return new CheckedEntryIterator<K, V>(s.iterator(), valueType);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.183 -0400", hash_original_method = "0FB4B292E50A952F877CB518E0A96CF9", hash_generated_method = "2DC97EFDC3663C641C6AFF11B5210615")
            @Override
            public Object[] toArray() {
                Object[] varB4EAC82CA7396A68D541C85D26508E83_1603663694 = null; //Variable for return #1
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
                varB4EAC82CA7396A68D541C85D26508E83_1603663694 = array;
                varB4EAC82CA7396A68D541C85D26508E83_1603663694.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1603663694;
                // ---------- Original Method ----------
                //int thisSize = size();
                //Object[] array = new Object[thisSize];
                //Iterator<?> it = iterator();
                //for (int i = 0; i < thisSize; i++) {
                    //array[i] = it.next();
                //}
                //return array;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.201 -0400", hash_original_method = "C1CA1F6CAFA571422DF3592838D87C35", hash_generated_method = "07AB4628DA4092B27ACD51DE97370518")
            @SuppressWarnings("unchecked")
            @Override
            public <T> T[] toArray(T[] array) {
                T[] varB4EAC82CA7396A68D541C85D26508E83_1755002690 = null; //Variable for return #1
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
                varB4EAC82CA7396A68D541C85D26508E83_1755002690 = array;
                addTaint(array[0].getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_1755002690.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1755002690;
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.202 -0400", hash_original_method = "C32F0C36534158E273107417143214BD", hash_generated_method = "D441297BB67A567EAD693CE90042A065")
            @Override
            public boolean retainAll(Collection<?> c) {
                boolean var5CB6111A304F8110F244B25FAFD11216_997878321 = (s.retainAll(c));
                addTaint(c.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1104288840 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1104288840;
                // ---------- Original Method ----------
                //return s.retainAll(c);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.202 -0400", hash_original_method = "B2624C46EA911C8D7CBCD3DB1975A601", hash_generated_method = "94A1559C7C26AF8BAE57F5CAB22DBA08")
            @Override
            public boolean removeAll(Collection<?> c) {
                boolean var9FB36AF651B537108EEB0474A946606A_325791638 = (s.removeAll(c));
                addTaint(c.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1388374267 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1388374267;
                // ---------- Original Method ----------
                //return s.removeAll(c);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.202 -0400", hash_original_method = "D8F4D306F45D40205BDE17116DDFF9FA", hash_generated_method = "9EBB22F23843C2515D94A334C5F3B4E2")
            @Override
            public boolean containsAll(Collection<?> c) {
                boolean var13D8B720D63124262C076810AF3BA42D_389834895 = (s.containsAll(c));
                addTaint(c.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_773876813 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_773876813;
                // ---------- Original Method ----------
                //return s.containsAll(c);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.202 -0400", hash_original_method = "0D1A7F281A8819D32245C163B79E338D", hash_generated_method = "3C9095790CFD46B283A75CB41D672256")
            @Override
            public boolean addAll(Collection<? extends Map.Entry<K, V>> c) {
                if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
                addTaint(c.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_400877704 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_400877704;
                // ---------- Original Method ----------
                //throw new UnsupportedOperationException();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.203 -0400", hash_original_method = "46F35AD7CAD80E45E374449F130E7D0D", hash_generated_method = "CC5C8E5D7B70140A495324F8D3B4BBD0")
            @Override
            public boolean remove(Object o) {
                boolean varDCAB2EB8C531AB1E623FFAD695CFD286_1363387986 = (s.remove(o));
                addTaint(o.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1637504161 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1637504161;
                // ---------- Original Method ----------
                //return s.remove(o);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.203 -0400", hash_original_method = "A91421BB58ED7F6569B24AAD1B5804AB", hash_generated_method = "E0EB98102DF1F35E94C3E1BD2A4226AA")
            @Override
            public boolean contains(Object o) {
                boolean var42C44FAC187AFC4735D76D5B7760F520_51067913 = (s.contains(o));
                addTaint(o.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_684609818 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_684609818;
                // ---------- Original Method ----------
                //return s.contains(o);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.203 -0400", hash_original_method = "8704A9C8AC3AA02909B00E4E211C4D3E", hash_generated_method = "9AE325D7C4BBD807AB68BE366CFD67A6")
            @Override
            public boolean add(Map.Entry<K, V> o) {
                if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
                addTaint(o.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_192371913 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_192371913;
                // ---------- Original Method ----------
                //throw new UnsupportedOperationException();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.222 -0400", hash_original_method = "1DB64DC7E3E98DAB777752CA6247DAE5", hash_generated_method = "71EA4288BB1C7C6A23748125C78B221F")
            @Override
            public boolean isEmpty() {
                boolean var33F6A8EED6267D5B4CCD3EAC631C616A_1305258912 = (s.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1467327260 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1467327260;
                // ---------- Original Method ----------
                //return s.isEmpty();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.222 -0400", hash_original_method = "3294D1F2516BD356F42ED84BE178EFCB", hash_generated_method = "8CAFCFFD1A3B734527CE3A6B8BDDA468")
            @Override
            public void clear() {
                s.clear();
                // ---------- Original Method ----------
                //s.clear();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.222 -0400", hash_original_method = "61480F19A13469EF561F92E5A3700C23", hash_generated_method = "567CF60DC81B0533F5194EC834862ADF")
            @Override
            public int size() {
                int var8151828880546AEA1C19BE7C52EE5E09_305668777 = (s.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1567157103 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1567157103;
                // ---------- Original Method ----------
                //return s.size();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.222 -0400", hash_original_method = "150ADDC982A3B6D8A573E663C38A7C9E", hash_generated_method = "33C7219CA5D07F0D54E4F061A6860F25")
            @Override
            public int hashCode() {
                int varE2FC7D6C989F81F3F30CE1BE213D1E3F_813290593 = (s.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_351442521 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_351442521;
                // ---------- Original Method ----------
                //return s.hashCode();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.223 -0400", hash_original_method = "2565EBD5FCFC00F10C086CB36B3EEE8C", hash_generated_method = "7421022D4AB261A4A1DFE58F7B9B2CF6")
            @Override
            public boolean equals(Object object) {
                boolean varB696C6744E5DE06D0B58A4DB8EE26D83_1442633392 = (s.equals(object));
                addTaint(object.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1360138470 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1360138470;
                // ---------- Original Method ----------
                //return s.equals(object);
            }

            
            private static class CheckedEntryIterator<K, V> implements Iterator<Map.Entry<K, V>> {
                @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.223 -0400", hash_original_field = "865C0C0B4AB0E063E5CAA3387C1A8741", hash_generated_field = "0B0E1D6BACD1F756FB2A478A3878B968")

                Iterator<Map.Entry<K, V>> i;
                @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.223 -0400", hash_original_field = "B96763B95160CC0943BE0DE4743A115B", hash_generated_field = "DE39CA4821E18DB5E7A7F09BBC028CB4")

                Class<V> valueType;
                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.223 -0400", hash_original_method = "3CE5E36A95DFE16D33C2CC4176CB7EE4", hash_generated_method = "A4AE63E616DC64A732B8C1B01DFD5833")
                public  CheckedEntryIterator(Iterator<Map.Entry<K, V>> i,
                        Class<V> valueType) {
                    this.i = i;
                    this.valueType = valueType;
                    // ---------- Original Method ----------
                    //this.i = i;
                    //this.valueType = valueType;
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.223 -0400", hash_original_method = "59CA86A80410B66286C92523CF35EC7B", hash_generated_method = "CD7AD5A74BC60A47ED04219238A3BB18")
                @Override
                public boolean hasNext() {
                    boolean var048C390D087BEDAABDA4F669A9DA628E_563629894 = (i.hasNext());
                    boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1622180440 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1622180440;
                    // ---------- Original Method ----------
                    //return i.hasNext();
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.224 -0400", hash_original_method = "048FA6C3E3A28865AD880AF8A3FCAE96", hash_generated_method = "598E37F558FC71BB5A0DA7BBE13EE694")
                @Override
                public void remove() {
                    i.remove();
                    // ---------- Original Method ----------
                    //i.remove();
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.224 -0400", hash_original_method = "4D16E0BB01C90351B8312D1A4B7DB5F2", hash_generated_method = "A98437322F1F47CDDEF464208EC01DFD")
                @Override
                public Map.Entry<K, V> next() {
                    Map.Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_234507521 = null; //Variable for return #1
                    varB4EAC82CA7396A68D541C85D26508E83_234507521 = new CheckedEntry<K, V>(i.next(), valueType);
                    varB4EAC82CA7396A68D541C85D26508E83_234507521.addTaint(getTaint()); //Add taint from parent
                    return varB4EAC82CA7396A68D541C85D26508E83_234507521;
                    // ---------- Original Method ----------
                    //return new CheckedEntry<K, V>(i.next(), valueType);
                }

                
            }


            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.224 -0400", hash_original_field = "3AB92C151F5D124E5C475918FE5C2CE3", hash_generated_field = "91EDA6639C99882E90144B8B95C0931F")

        private static long serialVersionUID = 5742860141034234728L;
    }


    
    private static class CheckedSortedSet<E> extends CheckedSet<E> implements SortedSet<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.239 -0400", hash_original_field = "3691308F2A4C2F6983F2880D32E29C84", hash_generated_field = "5220A6F2AA4CB98BB6C290F0BB717E86")

        private SortedSet<E> ss;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.240 -0400", hash_original_method = "70499BD9B05065D265D741875DD058CA", hash_generated_method = "4EA08511A3F1AC6F4E1992BAD4189CCA")
        public  CheckedSortedSet(SortedSet<E> s, Class<E> type) {
            super(s, type);
            this.ss = s;
            addTaint(type.getTaint());
            // ---------- Original Method ----------
            //this.ss = s;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.241 -0400", hash_original_method = "8514D9255D678B041F55D03BA11DCA3B", hash_generated_method = "1B6B451708F6D117CCF8A4AB51F56D63")
        @Override
        public Comparator<? super E> comparator() {
            Comparator<? super E> varB4EAC82CA7396A68D541C85D26508E83_2029012074 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2029012074 = ss.comparator();
            varB4EAC82CA7396A68D541C85D26508E83_2029012074.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2029012074;
            // ---------- Original Method ----------
            //return ss.comparator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.244 -0400", hash_original_method = "82539AB1166DFBB28D0E3DC3D0A43121", hash_generated_method = "5E6EEA6F8F41476936B2AB5AA90CA75B")
        @Override
        public SortedSet<E> subSet(E fromElement, E toElement) {
            SortedSet<E> varB4EAC82CA7396A68D541C85D26508E83_886047742 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_886047742 = new CheckedSortedSet<E>(ss.subSet(fromElement, toElement),
                    type);
            addTaint(fromElement.getTaint());
            addTaint(toElement.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_886047742.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_886047742;
            // ---------- Original Method ----------
            //return new CheckedSortedSet<E>(ss.subSet(fromElement, toElement),
                    //type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.245 -0400", hash_original_method = "68D546866615C37E07B8E968E3813E84", hash_generated_method = "9044A53AB750C8AF55EB1CBEC6000332")
        @Override
        public SortedSet<E> headSet(E toElement) {
            SortedSet<E> varB4EAC82CA7396A68D541C85D26508E83_2007530658 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2007530658 = new CheckedSortedSet<E>(ss.headSet(toElement), type);
            addTaint(toElement.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2007530658.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2007530658;
            // ---------- Original Method ----------
            //return new CheckedSortedSet<E>(ss.headSet(toElement), type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.259 -0400", hash_original_method = "B0B4B667BF95B9D9A3CD3F7FE8BEFA1B", hash_generated_method = "0E53D278CF7FBD391E7B94D4F3B93595")
        @Override
        public SortedSet<E> tailSet(E fromElement) {
            SortedSet<E> varB4EAC82CA7396A68D541C85D26508E83_167126843 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_167126843 = new CheckedSortedSet<E>(ss.tailSet(fromElement), type);
            addTaint(fromElement.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_167126843.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_167126843;
            // ---------- Original Method ----------
            //return new CheckedSortedSet<E>(ss.tailSet(fromElement), type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.260 -0400", hash_original_method = "6BB6C51843B41CC0DCB5509A79DBA008", hash_generated_method = "85D7E1D1E7EF3351228618A516BB4AF3")
        @Override
        public E first() {
            E varB4EAC82CA7396A68D541C85D26508E83_1303877199 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1303877199 = ss.first();
            varB4EAC82CA7396A68D541C85D26508E83_1303877199.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1303877199;
            // ---------- Original Method ----------
            //return ss.first();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.260 -0400", hash_original_method = "AAC5DDE787ACA85752B94AAB77F6B0F8", hash_generated_method = "63A034DDBD8C1904886CA852B799F461")
        @Override
        public E last() {
            E varB4EAC82CA7396A68D541C85D26508E83_873738389 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_873738389 = ss.last();
            varB4EAC82CA7396A68D541C85D26508E83_873738389.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_873738389;
            // ---------- Original Method ----------
            //return ss.last();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.260 -0400", hash_original_field = "45BA83A718F7437B80255AD942C73A67", hash_generated_field = "69806F6335C60948C846B9BCE4121A49")

        private static long serialVersionUID = 1599911165492914959L;
    }


    
    private static class CheckedSortedMap<K, V> extends CheckedMap<K, V> implements SortedMap<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.260 -0400", hash_original_field = "ED79ACB0CD3D7F8320C53C7798335EF0", hash_generated_field = "41E5EF207399B1082121011C1EB446FF")

        SortedMap<K, V> sm;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.261 -0400", hash_original_method = "2CB6EA0E6447E5AAF8B28B5FDF140BE4", hash_generated_method = "8C004DA654C6552CFBB98F0821546043")
          CheckedSortedMap(SortedMap<K, V> m, Class<K> keyType, Class<V> valueType) {
            super(m, keyType, valueType);
            this.sm = m;
            addTaint(keyType.getTaint());
            addTaint(valueType.getTaint());
            // ---------- Original Method ----------
            //this.sm = m;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.262 -0400", hash_original_method = "E5FDBCC6560BE7E99B2D2F850BD84149", hash_generated_method = "1DDC71439D68DA8D5D7F13C21EF023DE")
        @Override
        public Comparator<? super K> comparator() {
            Comparator<? super K> varB4EAC82CA7396A68D541C85D26508E83_1898331661 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1898331661 = sm.comparator();
            varB4EAC82CA7396A68D541C85D26508E83_1898331661.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1898331661;
            // ---------- Original Method ----------
            //return sm.comparator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.262 -0400", hash_original_method = "65DE11E398BB209CD2689071C041161A", hash_generated_method = "1B67CE4B4614F0EF3687FCE17D339362")
        @Override
        public SortedMap<K, V> subMap(K fromKey, K toKey) {
            SortedMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_1160231482 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1160231482 = new CheckedSortedMap<K, V>(sm.subMap(fromKey, toKey), keyType, valueType);
            addTaint(fromKey.getTaint());
            addTaint(toKey.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1160231482.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1160231482;
            // ---------- Original Method ----------
            //return new CheckedSortedMap<K, V>(sm.subMap(fromKey, toKey), keyType, valueType);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.284 -0400", hash_original_method = "2C5724B582D2FAB5716323DB894A671D", hash_generated_method = "AF7F87F57F86E79E69F172B95C9E7432")
        @Override
        public SortedMap<K, V> headMap(K toKey) {
            SortedMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_1024236234 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1024236234 = new CheckedSortedMap<K, V>(sm.headMap(toKey), keyType, valueType);
            addTaint(toKey.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1024236234.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1024236234;
            // ---------- Original Method ----------
            //return new CheckedSortedMap<K, V>(sm.headMap(toKey), keyType, valueType);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.284 -0400", hash_original_method = "2879524DD09B17D2FCB7AD1626D24618", hash_generated_method = "4B8A8E2C91CDAAB19BE53884E28557FD")
        @Override
        public SortedMap<K, V> tailMap(K fromKey) {
            SortedMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_1171520804 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1171520804 = new CheckedSortedMap<K, V>(sm.tailMap(fromKey), keyType, valueType);
            addTaint(fromKey.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1171520804.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1171520804;
            // ---------- Original Method ----------
            //return new CheckedSortedMap<K, V>(sm.tailMap(fromKey), keyType, valueType);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.285 -0400", hash_original_method = "B25E8C7440C76FBF812FF7AC9CA9D776", hash_generated_method = "D8249087770487F90CCCBF0A115C9045")
        @Override
        public K firstKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_183761819 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_183761819 = sm.firstKey();
            varB4EAC82CA7396A68D541C85D26508E83_183761819.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_183761819;
            // ---------- Original Method ----------
            //return sm.firstKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.286 -0400", hash_original_method = "00E9126A84DE8B71214859A17DA6BD2E", hash_generated_method = "C76988DECAAD8EEF54EE2BB6BD3B6BB4")
        @Override
        public K lastKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_698283540 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_698283540 = sm.lastKey();
            varB4EAC82CA7396A68D541C85D26508E83_698283540.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_698283540;
            // ---------- Original Method ----------
            //return sm.lastKey();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.286 -0400", hash_original_field = "4011ADBAF6264DE3F59FECC188B42ACB", hash_generated_field = "2714F4047A0D5B253E2EB6392246F34B")

        private static long serialVersionUID = 1599671320688067438L;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.298 -0400", hash_original_field = "A240022D45397AD0FD0431DDDFAF666B", hash_generated_field = "300B2F61C6CA9B6A3CB58436BAD60BA5")

    private static Iterator<?> EMPTY_ITERATOR = new Iterator<Object>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.286 -0400", hash_original_method = "28E75D14A5D2234D3702D9638A8D3094", hash_generated_method = "96BE113E93856BD672B99CCCF5AC9106")
        @Override
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2083384972 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2083384972;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.298 -0400", hash_original_method = "243C3D15209D9BF28572CB29FC9F3DF7", hash_generated_method = "3613EA17897DB540D203CDF04CC84004")
        @Override
        public Object next() {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            // ---------- Original Method ----------
            //throw new NoSuchElementException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.298 -0400", hash_original_method = "45CE80048748F3BC523226127E4746F5", hash_generated_method = "FC031BE6A6E094CAC267938D912798A0")
        @Override
        public void remove() {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            // ---------- Original Method ----------
            //throw new IllegalStateException();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.299 -0400", hash_original_field = "BF19162ABA3425F946F5D9B6685AC2EC", hash_generated_field = "73668C061CDD89379C8D82D31D7BBAE2")

    private static Enumeration<?> EMPTY_ENUMERATION = new Enumeration<Object>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.299 -0400", hash_original_method = "50CD0E92886EDA5BEE0164B092B351EC", hash_generated_method = "A925EE762B6356B66C979AD24F67E6D8")
        @Override
        public boolean hasMoreElements() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_741161673 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_741161673;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.299 -0400", hash_original_method = "82381D9C34AF9F2E88B673FB4A4E6DDE", hash_generated_method = "C451DB608AE3B7FAE82365C2FA63C59D")
        @Override
        public Object nextElement() {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            // ---------- Original Method ----------
            //throw new NoSuchElementException();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.299 -0400", hash_original_field = "E5D97468931D831222F89B33B06414C4", hash_generated_field = "1967470EF0F42FDB7D6E965615F956D6")

    @SuppressWarnings("unchecked")
    public static final List EMPTY_LIST = new EmptyList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.300 -0400", hash_original_field = "19637326155AD7B58E274FC2717EADC0", hash_generated_field = "EF8031119D3626285E32D155A57C6695")

    @SuppressWarnings("unchecked")
    public static final Set EMPTY_SET = new EmptySet();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.300 -0400", hash_original_field = "712F6D9422DE94FBE0F2A8F69D9E29D0", hash_generated_field = "F465655F33C72E2E2F297BFA1010664E")

    @SuppressWarnings("unchecked")
    public static final Map EMPTY_MAP = new EmptyMap();
}

