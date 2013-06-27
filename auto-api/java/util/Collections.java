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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.797 -0400", hash_original_method = "0C1BC548FC19EEB6A684F12763720939", hash_generated_method = "F5EC8594995493427AAF50F2EB8C349F")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.856 -0400", hash_original_field = "7B8B965AD4BCA0E41AB51DE7B31363A1", hash_generated_field = "01825CC32046BF0FBE11738ABC136518")

        private int n;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.856 -0400", hash_original_field = "8E2DCFD7E7E24B1CA76C1193F645902B", hash_generated_field = "93B043155067F80D0269375649E4D7D4")

        private E element;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.857 -0400", hash_original_method = "5A122D173062D06824D4571736320F87", hash_generated_method = "332F4CC6EB56BB16F20F69E656CBAAF8")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.857 -0400", hash_original_method = "B07BCF81C9C48C72A08077A0468A8769", hash_generated_method = "73ED35C936EF0D60CBBAF5040AEC4400")
        @Override
        public boolean contains(Object object) {
            {
                Object var918C716CCB523821E4DE921B4E432F42_1065473231 = (element.equals(object));
            } //End flattened ternary
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1566160636 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1566160636;
            // ---------- Original Method ----------
            //return element == null ? object == null : element.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.858 -0400", hash_original_method = "61094B9B9DEC6161E82512577FAF3323", hash_generated_method = "035670436A09FA6FDDA173E270D18C5E")
        @Override
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1840022461 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1840022461;
            // ---------- Original Method ----------
            //return n;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.858 -0400", hash_original_method = "857A70B35DA7146CF7ADC484EC4AABC8", hash_generated_method = "019FC95E45CE8CFF31DF8E164ACF84CB")
        @Override
        public E get(int location) {
            E varB4EAC82CA7396A68D541C85D26508E83_666986399 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_666986399 = element;
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            addTaint(location);
            varB4EAC82CA7396A68D541C85D26508E83_666986399.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_666986399;
            // ---------- Original Method ----------
            //if (location >= 0 && location < n) {
                //return element;
            //}
            //throw new IndexOutOfBoundsException();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.858 -0400", hash_original_field = "6A61C247691E7C356BC04B2E9E793190", hash_generated_field = "51DD40AC1BF487C48DC188E284D62BA6")

        private static long serialVersionUID = 2739099268398711800L;
    }


    
    private static final class EmptyList extends AbstractList implements RandomAccess, Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.858 -0400", hash_original_method = "BF3F11B0BCAE2AE80C7C74CBEB88EB5B", hash_generated_method = "BF3F11B0BCAE2AE80C7C74CBEB88EB5B")
        public EmptyList ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.859 -0400", hash_original_method = "38B750FD34BF6CB1144CDF020D3299E6", hash_generated_method = "EAAF96F7F540FC6971B90DC0588F8D6F")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1329985602 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1329985602;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.859 -0400", hash_original_method = "F4586E3A64B5D10DEB709A723C85E55E", hash_generated_method = "C1C450AF54FCA3EA16D7D85F71755425")
        @Override
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2089285637 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2089285637;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.859 -0400", hash_original_method = "F59F44D1664BC2EE59D5A9B30D144285", hash_generated_method = "A8C1E569381DF357B1DAF3DEDBCE876B")
        @Override
        public Object get(int location) {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            addTaint(location);
            // ---------- Original Method ----------
            //throw new IndexOutOfBoundsException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.869 -0400", hash_original_method = "3CB4CAF1EADC3F12C565BD7D2B5F5514", hash_generated_method = "2E1849A6838F8DF31B6C794BE3171941")
        private Object readResolve() {
            Object varB4EAC82CA7396A68D541C85D26508E83_374559056 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_374559056 = Collections.EMPTY_LIST;
            varB4EAC82CA7396A68D541C85D26508E83_374559056.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_374559056;
            // ---------- Original Method ----------
            //return Collections.EMPTY_LIST;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.869 -0400", hash_original_field = "FEEABBF180D6F8A042B90CBFA55A4A94", hash_generated_field = "D4821F58F340DEF9C551710D53D4346E")

        private static long serialVersionUID = 8842843931221139166L;
    }


    
    private static final class EmptySet extends AbstractSet implements Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.869 -0400", hash_original_method = "3A37381B9598D46CF46D5D53F85DF5B1", hash_generated_method = "3A37381B9598D46CF46D5D53F85DF5B1")
        public EmptySet ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.870 -0400", hash_original_method = "38B750FD34BF6CB1144CDF020D3299E6", hash_generated_method = "07254727DE4FAFA4BBC7976B8826C854")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1844771113 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1844771113;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.870 -0400", hash_original_method = "F4586E3A64B5D10DEB709A723C85E55E", hash_generated_method = "61BBA9458F1F6AC2EE34C3F8812A5CDB")
        @Override
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1553933256 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1553933256;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.871 -0400", hash_original_method = "FC88A4B2F50E498E162F3F7EEDE885B1", hash_generated_method = "87F31EBC8A2D78580D8E08D6774AF39B")
        @Override
        public Iterator iterator() {
            Iterator varB4EAC82CA7396A68D541C85D26508E83_787863788 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_787863788 = EMPTY_ITERATOR;
            varB4EAC82CA7396A68D541C85D26508E83_787863788.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_787863788;
            // ---------- Original Method ----------
            //return EMPTY_ITERATOR;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.872 -0400", hash_original_method = "2ED0845ADEAE5655731C197578B08F82", hash_generated_method = "02158A5FF7CF424BF67703B9BBD1BFCC")
        private Object readResolve() {
            Object varB4EAC82CA7396A68D541C85D26508E83_2099472319 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2099472319 = Collections.EMPTY_SET;
            varB4EAC82CA7396A68D541C85D26508E83_2099472319.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2099472319;
            // ---------- Original Method ----------
            //return Collections.EMPTY_SET;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.876 -0400", hash_original_field = "EBC69A53BFBAE35613EC4BD95CB98F92", hash_generated_field = "05BD3AF517071804E9469DA21BD9AAE3")

        private static long serialVersionUID = 1582296315990362920L;
    }


    
    private static final class EmptyMap extends AbstractMap implements Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.876 -0400", hash_original_method = "0E8F36F90F9C751DA5A12903A16705DF", hash_generated_method = "0E8F36F90F9C751DA5A12903A16705DF")
        public EmptyMap ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.877 -0400", hash_original_method = "2AD0E7E75E88E287D6229481B74BEBCC", hash_generated_method = "0A924824872C671A986A3EB6BC9F8B83")
        @Override
        public boolean containsKey(Object key) {
            addTaint(key.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1945642114 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1945642114;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.877 -0400", hash_original_method = "9D32B6FFC088649ED5480F6E533A1288", hash_generated_method = "2C85AD0B0F9AB70EDF1766970C726959")
        @Override
        public boolean containsValue(Object value) {
            addTaint(value.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1852665591 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1852665591;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.882 -0400", hash_original_method = "709DD403C63D2F4104FF93FEEB6E3457", hash_generated_method = "8F5358978A2973E857C5E8FFD8E90CAB")
        @Override
        public Set entrySet() {
            Set varB4EAC82CA7396A68D541C85D26508E83_1430542605 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1430542605 = EMPTY_SET;
            varB4EAC82CA7396A68D541C85D26508E83_1430542605.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1430542605;
            // ---------- Original Method ----------
            //return EMPTY_SET;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.883 -0400", hash_original_method = "59A1188DDD48CFFB749850DC2DA09C1D", hash_generated_method = "4C6072210176A7F60F3EC6BF49228A1A")
        @Override
        public Object get(Object key) {
            Object varB4EAC82CA7396A68D541C85D26508E83_61509163 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_61509163 = null;
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_61509163.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_61509163;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.884 -0400", hash_original_method = "266B164C16644761E32491964C192EB7", hash_generated_method = "C2B68EE96618E1C6F20FFF2E211D5A8D")
        @Override
        public Set keySet() {
            Set varB4EAC82CA7396A68D541C85D26508E83_456622211 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_456622211 = EMPTY_SET;
            varB4EAC82CA7396A68D541C85D26508E83_456622211.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_456622211;
            // ---------- Original Method ----------
            //return EMPTY_SET;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.884 -0400", hash_original_method = "745E6E226DD5F7D4E763DA74DFF70792", hash_generated_method = "2075409EF08A66AE7B74D762C7C1817E")
        @Override
        public Collection values() {
            Collection varB4EAC82CA7396A68D541C85D26508E83_1279102543 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1279102543 = EMPTY_LIST;
            varB4EAC82CA7396A68D541C85D26508E83_1279102543.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1279102543;
            // ---------- Original Method ----------
            //return EMPTY_LIST;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.889 -0400", hash_original_method = "59A22E9415A338EB85D7A7DD214359CC", hash_generated_method = "10ED1CF999EF76C8FDDE0E53C331823E")
        private Object readResolve() {
            Object varB4EAC82CA7396A68D541C85D26508E83_565379464 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_565379464 = Collections.EMPTY_MAP;
            varB4EAC82CA7396A68D541C85D26508E83_565379464.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_565379464;
            // ---------- Original Method ----------
            //return Collections.EMPTY_MAP;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.889 -0400", hash_original_field = "71F087EB1E9FCDB60C678B95061CEBBD", hash_generated_field = "CB3012AFD32CA96D2DE9D9201475BE21")

        private static long serialVersionUID = 6428348081105594320L;
    }


    
    private static final class ReverseComparator<T> implements Comparator<T>, Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.890 -0400", hash_original_method = "FFB2FB11DBE006893CA9746ECCE68517", hash_generated_method = "FFB2FB11DBE006893CA9746ECCE68517")
        public ReverseComparator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.897 -0400", hash_original_method = "907488F1D5625FE5C9F59ED8A7B6E697", hash_generated_method = "B1E912CCF3EDAD3F756B6A152E12B800")
        @SuppressWarnings("unchecked")
        @Override
        public int compare(T o1, T o2) {
            Comparable<T> c2;
            c2 = (Comparable<T>) o2;
            int var692167FC6770150DF2B5DF91BFB83EC2_1952555703 = (c2.compareTo(o1));
            addTaint(o1.getTaint());
            addTaint(o2.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_84809430 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_84809430;
            // ---------- Original Method ----------
            //Comparable<T> c2 = (Comparable<T>) o2;
            //return c2.compareTo(o1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.898 -0400", hash_original_method = "DD371F0FDF8300FDCFBD1E5C395D42BC", hash_generated_method = "9349555B44D7463A882AA067C4C2988A")
        private Object readResolve() throws ObjectStreamException {
            Object varB4EAC82CA7396A68D541C85D26508E83_924037096 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_924037096 = INSTANCE;
            varB4EAC82CA7396A68D541C85D26508E83_924037096.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_924037096;
            // ---------- Original Method ----------
            //return INSTANCE;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.898 -0400", hash_original_field = "2B003AD2E801398B9507D8ADBBB584A6", hash_generated_field = "FD09203CF293DCF576A151FB2E3FAA8B")

        private static ReverseComparator<Object> INSTANCE = new ReverseComparator<Object>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.898 -0400", hash_original_field = "844E6A53F14D8AD803480DAA1F2399E0", hash_generated_field = "84BF5E9BC7C3C37BB9951FC0167E20F4")

        private static long serialVersionUID = 7207038068494060240L;
    }


    
    private static final class ReverseComparator2<T> implements Comparator<T>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.898 -0400", hash_original_field = "31B4E550AA5FD883246F9B9CEAE82483", hash_generated_field = "ACD6D4A2528BA4BAF7406DE3D3F49FE6")

        private Comparator<T> cmp;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.898 -0400", hash_original_method = "1ABA0972F29BDB004C28A1246ABEF788", hash_generated_method = "B92E5576724AB283C109FF5B16A47456")
          ReverseComparator2(Comparator<T> comparator) {
            this.cmp = comparator;
            // ---------- Original Method ----------
            //this.cmp = comparator;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.899 -0400", hash_original_method = "449D1B24DD0E97F4D53DEB786BD04597", hash_generated_method = "292807773DBD51197D98A0620F0F1F44")
        @Override
        public int compare(T o1, T o2) {
            int varC3FAEC3684B290716428C4AB73BA307C_1147223251 = (cmp.compare(o2, o1));
            addTaint(o1.getTaint());
            addTaint(o2.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1686339312 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1686339312;
            // ---------- Original Method ----------
            //return cmp.compare(o2, o1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.899 -0400", hash_original_method = "30689CAB8FBFDCB9289EF03377EE08A0", hash_generated_method = "62B8A048C0C86A251818DA5A0A5C05AF")
        @Override
        public boolean equals(Object o) {
            boolean varB42AC7AE9468AAA515C4B77EBD2F7BC7_1897098300 = (o instanceof ReverseComparator2
                    && ((ReverseComparator2) o).cmp.equals(cmp));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_859944291 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_859944291;
            // ---------- Original Method ----------
            //return o instanceof ReverseComparator2
                    //&& ((ReverseComparator2) o).cmp.equals(cmp);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.899 -0400", hash_original_method = "CAA612A5887D060562790EB1CDD1FEFE", hash_generated_method = "E4695F4DF73C15E97CA7E7AC0D7DEB7C")
        @Override
        public int hashCode() {
            int varFAD4BDCF5F08AFF151A94355744A94BB_1270576208 = (~cmp.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1015079342 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1015079342;
            // ---------- Original Method ----------
            //return ~cmp.hashCode();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.899 -0400", hash_original_field = "C2743FD0D0E256493E9B52C087283254", hash_generated_field = "D91F4B39733605415D2BC1EABB0A7C71")

        private static long serialVersionUID = 4374092139857L;
    }


    
    private static final class SingletonSet<E> extends AbstractSet<E> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.899 -0400", hash_original_field = "8E2DCFD7E7E24B1CA76C1193F645902B", hash_generated_field = "AADC7BC67B0FB6048E4A856A581BAEE9")

        E element;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.905 -0400", hash_original_method = "044BE6981927B9234E2AE8686E07A72F", hash_generated_method = "08623BAB02DDA909B203E3610F71957D")
          SingletonSet(E object) {
            element = object;
            // ---------- Original Method ----------
            //element = object;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.905 -0400", hash_original_method = "B07BCF81C9C48C72A08077A0468A8769", hash_generated_method = "B85D7242821DF1029E3037F4770022B6")
        @Override
        public boolean contains(Object object) {
            {
                Object var918C716CCB523821E4DE921B4E432F42_933784194 = (element.equals(object));
            } //End flattened ternary
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_198039563 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_198039563;
            // ---------- Original Method ----------
            //return element == null ? object == null : element.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.989 -0400", hash_original_method = "798A0AE2F2A6352396904AB5C9ED97D5", hash_generated_method = "F81E0D1404C86CDEDB5C8F041E4BF562")
        @Override
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_760155859 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_760155859;
            // ---------- Original Method ----------
            //return 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.990 -0400", hash_original_method = "135AC18A6A8AD4548E2E750F2D4C7699", hash_generated_method = "B2A6718113E6FB668A30839162986F4B")
        @Override
        public Iterator<E> iterator() {
            Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_2027886661 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2027886661 = new Iterator<E>() {
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
            varB4EAC82CA7396A68D541C85D26508E83_2027886661.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2027886661;
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.990 -0400", hash_original_field = "C80162DD8B57D34236F77D8F8A87A897", hash_generated_field = "A78776FFC0262E99D899928EA9BF3BAA")

        private static long serialVersionUID = 3193687207550431679L;
    }


    
    private static final class SingletonList<E> extends AbstractList<E> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.990 -0400", hash_original_field = "8E2DCFD7E7E24B1CA76C1193F645902B", hash_generated_field = "AADC7BC67B0FB6048E4A856A581BAEE9")

        E element;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.990 -0400", hash_original_method = "F3174A5FA7BA5962D109EAC3245F2C1D", hash_generated_method = "6BE55179558843F3290CC42091204DF4")
          SingletonList(E object) {
            element = object;
            // ---------- Original Method ----------
            //element = object;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.991 -0400", hash_original_method = "B07BCF81C9C48C72A08077A0468A8769", hash_generated_method = "D610001851E590AC8F6E2F71DB8EF3CD")
        @Override
        public boolean contains(Object object) {
            {
                Object var918C716CCB523821E4DE921B4E432F42_1025880205 = (element.equals(object));
            } //End flattened ternary
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_469699243 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_469699243;
            // ---------- Original Method ----------
            //return element == null ? object == null : element.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.992 -0400", hash_original_method = "1C6E7D1EB082158D5E00EA29E883A612", hash_generated_method = "7DED4AB533330E51D34D7244D48B71F1")
        @Override
        public E get(int location) {
            E varB4EAC82CA7396A68D541C85D26508E83_1862827546 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_1862827546 = element;
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            addTaint(location);
            varB4EAC82CA7396A68D541C85D26508E83_1862827546.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1862827546;
            // ---------- Original Method ----------
            //if (location == 0) {
                //return element;
            //}
            //throw new IndexOutOfBoundsException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.993 -0400", hash_original_method = "798A0AE2F2A6352396904AB5C9ED97D5", hash_generated_method = "2BF179AB5AA3F1D5E2A105A6D8189E20")
        @Override
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1703260240 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1703260240;
            // ---------- Original Method ----------
            //return 1;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.993 -0400", hash_original_field = "136A37A5852F7DE7150E3A4BC9F06AE5", hash_generated_field = "D432E1220EA28F82711737177832355A")

        private static long serialVersionUID = 3093736618740652951L;
    }


    
    private static final class SingletonMap<K, V> extends AbstractMap<K, V> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.993 -0400", hash_original_field = "8CE4B16B22B58894AA86C421E8759DF3", hash_generated_field = "052F80594ED04BACBC2E98744BD4CC2D")

        K k;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.993 -0400", hash_original_field = "9E3669D19B675BD57058FD4664205D2A", hash_generated_field = "3A278B3CDA0FEEA24CB626A0B3136D0B")

        V v;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.993 -0400", hash_original_method = "85D3D420EE431E7A3C1CBFB71D1CEAE2", hash_generated_method = "942C300AA2E111086F3B6C3DFB936BBB")
          SingletonMap(K key, V value) {
            k = key;
            v = value;
            // ---------- Original Method ----------
            //k = key;
            //v = value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.994 -0400", hash_original_method = "26D5E87A2C62405ADA3B15C5C8B30FEC", hash_generated_method = "E9F732717B2687E7F1C9C34365806BB4")
        @Override
        public boolean containsKey(Object key) {
            {
                Object var0EB569FD4AF21D116A21E287F6027A39_1042162924 = (k.equals(key));
            } //End flattened ternary
            addTaint(key.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1978851189 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1978851189;
            // ---------- Original Method ----------
            //return k == null ? key == null : k.equals(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.994 -0400", hash_original_method = "827D42B4F919454EC51CA86D0E534994", hash_generated_method = "B998E4148E7D135BDC90E4C442155FE9")
        @Override
        public boolean containsValue(Object value) {
            {
                Object var1F74AE50105434A557EE1F3FD50522E7_1966745718 = (v.equals(value));
            } //End flattened ternary
            addTaint(value.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1863794842 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1863794842;
            // ---------- Original Method ----------
            //return v == null ? value == null : v.equals(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.995 -0400", hash_original_method = "8C587096F5E6029DBB187C58CF22D158", hash_generated_method = "F3FA145FD0257061726867341605E042")
        @Override
        public V get(Object key) {
            V varB4EAC82CA7396A68D541C85D26508E83_1711933006 = null; //Variable for return #1
            V varB4EAC82CA7396A68D541C85D26508E83_1221484760 = null; //Variable for return #2
            {
                boolean varD8EB9E9C73E773501877E01187F3B5DA_157580787 = (containsKey(key));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1711933006 = v;
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1221484760 = null;
            addTaint(key.getTaint());
            V varA7E53CE21691AB073D9660D615818899_760257034; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_760257034 = varB4EAC82CA7396A68D541C85D26508E83_1711933006;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_760257034 = varB4EAC82CA7396A68D541C85D26508E83_1221484760;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_760257034.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_760257034;
            // ---------- Original Method ----------
            //if (containsKey(key)) {
                //return v;
            //}
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.995 -0400", hash_original_method = "798A0AE2F2A6352396904AB5C9ED97D5", hash_generated_method = "1DF973DBC16934CF0FE320E8919D385A")
        @Override
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_179273086 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_179273086;
            // ---------- Original Method ----------
            //return 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.997 -0400", hash_original_method = "AB4A6E093F1AE40B73184C21F1D08E5E", hash_generated_method = "706942B20010DE929A20BF7A273485C5")
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_111501293 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_111501293 = new AbstractSet<Map.Entry<K, V>>() {
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
            varB4EAC82CA7396A68D541C85D26508E83_111501293.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_111501293;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.997 -0400", hash_original_field = "9848B8101686634CF12341A29DB1F062", hash_generated_field = "DB7FFD9D9765DB790A815F6BB1A64934")

        private static long serialVersionUID = -6979724477215052911L;
    }


    
    static class SynchronizedCollection<E> implements Collection<E>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.997 -0400", hash_original_field = "4A8A08F09D37B73795649038408B5F33", hash_generated_field = "A3C80A7E02E49F20400373DFBAF9696A")

        Collection<E> c;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.997 -0400", hash_original_field = "25A01BB859125507013A2FE9737D3C32", hash_generated_field = "5C5F8780FECE5E612AF5A86D3A8B3194")

        Object mutex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.002 -0400", hash_original_method = "30FA7B26D2517E75155300E21A44EE02", hash_generated_method = "04BEBFE0095AFAF3C9F796F57AE0BFCE")
          SynchronizedCollection(Collection<E> collection) {
            c = collection;
            mutex = this;
            // ---------- Original Method ----------
            //c = collection;
            //mutex = this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.008 -0400", hash_original_method = "A2A350BD37040709EC39C6B0536AFBDE", hash_generated_method = "4B2E27EA4C4C16202811504251810751")
          SynchronizedCollection(Collection<E> collection, Object mutex) {
            c = collection;
            this.mutex = mutex;
            // ---------- Original Method ----------
            //c = collection;
            //this.mutex = mutex;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.009 -0400", hash_original_method = "FB2AC5CD0A8119C2DE50A53F38732CDD", hash_generated_method = "1D51539B769FD75E4B70B66AC9222100")
        @Override
        public boolean add(E object) {
            {
                boolean var2BB0FD33FED1B2B72867ACF06FBFC56B_1963193072 = (c.add(object));
            } //End block
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_660067814 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_660067814;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.add(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.011 -0400", hash_original_method = "8489E829BC0B88048B305735D46B1D99", hash_generated_method = "1839D56D14F508E68AE4AF78FBD8C13D")
        @Override
        public boolean addAll(Collection<? extends E> collection) {
            {
                boolean varAB7EBFBCA4F45D51E737154B11C4108B_1418746575 = (c.addAll(collection));
            } //End block
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1274401728 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1274401728;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.addAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.014 -0400", hash_original_method = "7AE3345D011114FF0F62A8DFD7762BE2", hash_generated_method = "ED4D6B89485DB8E6E90C08ACDF15F82F")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.014 -0400", hash_original_method = "1B12503F1112F0CD581293F3A624FEFF", hash_generated_method = "C7E5B2913B700112958CDF6C06B72BD5")
        @Override
        public boolean contains(Object object) {
            {
                boolean var34971DB84F983FD59B337EBDA19618A7_676875361 = (c.contains(object));
            } //End block
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_95867806 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_95867806;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.contains(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.014 -0400", hash_original_method = "F945FF2C907D1AA0923D46DECCCD5EAD", hash_generated_method = "BC795892C2CA543BC642E36AFEEE9CC4")
        @Override
        public boolean containsAll(Collection<?> collection) {
            {
                boolean varDACCFBFB1E0F996A35B7BB8B776BF827_90215783 = (c.containsAll(collection));
            } //End block
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1128359151 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1128359151;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.containsAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.014 -0400", hash_original_method = "FC4F88C8FB9F4E3716AD2ABCD3101657", hash_generated_method = "644958E5E1060ADD9AFF2459E0CA1DD8")
        @Override
        public boolean isEmpty() {
            {
                boolean var13DC031C5380F0C4DA515946E668AE17_1512528359 = (c.isEmpty());
            } //End block
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1816787715 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1816787715;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.isEmpty();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.027 -0400", hash_original_method = "7F1B5E60A4E4F9F3AFA65965967FBBF0", hash_generated_method = "4859F441585B358F0D02477338080396")
        @Override
        public Iterator<E> iterator() {
            Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_423993180 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_423993180 = c.iterator();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_423993180.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_423993180;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.iterator();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.028 -0400", hash_original_method = "C85E45E4AF074973339408E1197B653C", hash_generated_method = "013C421C541096D1CE77D7DF283B5BC0")
        @Override
        public boolean remove(Object object) {
            {
                boolean var8E355775017A5ED204FCCA7510D23187_524532529 = (c.remove(object));
            } //End block
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_313824669 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_313824669;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.remove(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.028 -0400", hash_original_method = "63829008A74D54A464D81619215951F3", hash_generated_method = "4816F8300740E98E90759ABBB5157460")
        @Override
        public boolean removeAll(Collection<?> collection) {
            {
                boolean var1464AF4DDAD9564C54B239B0335D2517_1161865382 = (c.removeAll(collection));
            } //End block
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2106402716 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2106402716;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.removeAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.029 -0400", hash_original_method = "F83427C5B4EF86DB8198B3D2BAE482AC", hash_generated_method = "2D8176B3CA501FAC560597747EFF0D1B")
        @Override
        public boolean retainAll(Collection<?> collection) {
            {
                boolean varF2E46B90912EE4E31AEA6D3F646498E8_428497796 = (c.retainAll(collection));
            } //End block
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_177587626 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_177587626;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.retainAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.030 -0400", hash_original_method = "8641BC878FB77D36CE60B1977D7C0FB5", hash_generated_method = "853A277629E8B0CFA8E42FC0E09784D7")
        @Override
        public int size() {
            {
                int var0E51EFE72011B352AF314992F697E7C3_1928627836 = (c.size());
            } //End block
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1216013142 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1216013142;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.size();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.045 -0400", hash_original_method = "214BCEC14D5449B585926B657D8D51C2", hash_generated_method = "542086070B12C6DCA3A6FC1A0900FF70")
        @Override
        public java.lang.Object[] toArray() {
            java.lang.Object[] varB4EAC82CA7396A68D541C85D26508E83_664363610 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_664363610 = c.toArray();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_664363610.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_664363610;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.toArray();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.046 -0400", hash_original_method = "D637F0F4C3C8C312A0597F30C1C6DB59", hash_generated_method = "6F9246297916DF37A2514FBE3237B5C8")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_814195131 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_814195131 = c.toString();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_814195131.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_814195131;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.toString();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.046 -0400", hash_original_method = "567EED27866E99DFC1B7F8B43B648D82", hash_generated_method = "1BCD5F3B260C41CC42C8E49E04C7E7C5")
        @Override
        public <T> T[] toArray(T[] array) {
            T[] varB4EAC82CA7396A68D541C85D26508E83_1691804204 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_1691804204 = c.toArray(array);
            } //End block
            addTaint(array[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1691804204.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1691804204;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.toArray(array);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.047 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "DB1DE1953401C4A8F22A25B2206D8A3D")
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.047 -0400", hash_original_field = "B7F3A88BD93CCDAF65C044FAA6629D02", hash_generated_field = "64C4CF165AE4D96687B8F95134EA7D73")

        private static long serialVersionUID = 3053995032091335093L;
    }


    
    static class SynchronizedRandomAccessList<E> extends SynchronizedList<E> implements RandomAccess {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.047 -0400", hash_original_method = "B7E7091552AE239FAE56C332916C1F88", hash_generated_method = "E13039390DC63B5DD55D2C3F5A398F04")
          SynchronizedRandomAccessList(List<E> l) {
            super(l);
            addTaint(l.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.047 -0400", hash_original_method = "333C2DB156927D33EFC68D095A4D91C7", hash_generated_method = "AE1BCAB65FE4C0FE73632D8319B7F9FE")
          SynchronizedRandomAccessList(List<E> l, Object mutex) {
            super(l, mutex);
            addTaint(l.getTaint());
            addTaint(mutex.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.050 -0400", hash_original_method = "52EB3707ADD11A2326D60B7B815140D9", hash_generated_method = "6676C66B2F99F6BFBCFBF7A0416358D7")
        @Override
        public List<E> subList(int start, int end) {
            List<E> varB4EAC82CA7396A68D541C85D26508E83_1456483803 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_1456483803 = new SynchronizedRandomAccessList<E>(list.subList(start, end), mutex);
            } //End block
            addTaint(start);
            addTaint(end);
            varB4EAC82CA7396A68D541C85D26508E83_1456483803.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1456483803;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedRandomAccessList<E>(list.subList(start, end), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.051 -0400", hash_original_method = "3A06B4F1BF7736CF10F2183ECBC34EF4", hash_generated_method = "43E3B0D6DDF14DCDD3E3D6F422270444")
        private Object writeReplace() {
            Object varB4EAC82CA7396A68D541C85D26508E83_1076083116 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1076083116 = new SynchronizedList<E>(list);
            varB4EAC82CA7396A68D541C85D26508E83_1076083116.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1076083116;
            // ---------- Original Method ----------
            //return new SynchronizedList<E>(list);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.051 -0400", hash_original_field = "9B799982724822CB2FE4521FDAC6E710", hash_generated_field = "21A753FB267D280E543AD019E21774E3")

        private static long serialVersionUID = 1530674583602358482L;
    }


    
    static class SynchronizedList<E> extends SynchronizedCollection<E> implements List<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.051 -0400", hash_original_field = "10AE9FC7D453B0DD525D0EDF2EDE7961", hash_generated_field = "1ECA8D0C53ED31C6D874046BB18C0645")

        List<E> list;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.051 -0400", hash_original_method = "557BC04FB4751FAF0774C664BC5CCEDB", hash_generated_method = "C7C5461D5C9C9A7143EFC825B2E89308")
          SynchronizedList(List<E> l) {
            super(l);
            list = l;
            // ---------- Original Method ----------
            //list = l;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.052 -0400", hash_original_method = "6BB690026CB7D337AD2D522FD2C1D564", hash_generated_method = "5A03D1AA887517822EC5152559195ADC")
          SynchronizedList(List<E> l, Object mutex) {
            super(l, mutex);
            list = l;
            addTaint(mutex.getTaint());
            // ---------- Original Method ----------
            //list = l;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.052 -0400", hash_original_method = "771543DB5FBF857EC43E623C900790C1", hash_generated_method = "91E40E74D69FC52967284256EB93FBA0")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.052 -0400", hash_original_method = "2E8B0D036C339DEB52EAEECF82B3FC29", hash_generated_method = "30CBA3BDFB4A00886BB6C22BB213CBA2")
        @Override
        public boolean addAll(int location, Collection<? extends E> collection) {
            {
                boolean var158D83A08C48A45A82B28798671769C1_226118368 = (list.addAll(location, collection));
            } //End block
            addTaint(location);
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1302622844 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1302622844;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.addAll(location, collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.070 -0400", hash_original_method = "3D6B0DEE3E066475015263D28B67E9C7", hash_generated_method = "AF973518309BC7DAC69FAD3FE35AD9A9")
        @Override
        public boolean equals(Object object) {
            {
                boolean varB8EFBCA5568090BA0F116E782A49968B_2037720070 = (list.equals(object));
            } //End block
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1210223517 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1210223517;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.equals(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.072 -0400", hash_original_method = "5B64BB89A58DED71DBA9907C06BC2CBB", hash_generated_method = "AEE1B7A4BE56D983F82651C236996D11")
        @Override
        public E get(int location) {
            E varB4EAC82CA7396A68D541C85D26508E83_153694221 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_153694221 = list.get(location);
            } //End block
            addTaint(location);
            varB4EAC82CA7396A68D541C85D26508E83_153694221.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_153694221;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.get(location);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.072 -0400", hash_original_method = "4F5947DB3C3ABC0CDEDCB631295417DE", hash_generated_method = "796B59622B888A0125DDF545219873A3")
        @Override
        public int hashCode() {
            {
                int varE89315CE67DD6395C812E01B5B28CC79_400795210 = (list.hashCode());
            } //End block
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2074972776 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2074972776;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.hashCode();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.074 -0400", hash_original_method = "3D24998665BD619FA01B00E0A34A83F5", hash_generated_method = "000B55D4BEECD40AE0ECA4F0926609AC")
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
                            boolean varE4EB18CE7254896A48F2456CD1C5820F_1284549815 = (object.equals(array[i]));
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
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1049413298 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1049413298;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.078 -0400", hash_original_method = "615F71337583130515178716D1767A86", hash_generated_method = "A353D7830B62A02A3E4014F877BE7352")
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
                            boolean varE4EB18CE7254896A48F2456CD1C5820F_1286684353 = (object.equals(array[i]));
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
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1194268122 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1194268122;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.079 -0400", hash_original_method = "9E49E91DE129681261C3C7642C2D1127", hash_generated_method = "103305A995DDB439B49B4A4F1B106C12")
        @Override
        public ListIterator<E> listIterator() {
            ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_533422226 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_533422226 = list.listIterator();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_533422226.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_533422226;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.listIterator();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.089 -0400", hash_original_method = "70349F3896FC81F4D21A3D35B0C8A4F6", hash_generated_method = "ACFF1E4CDD8355A265F6313C2BD7784F")
        @Override
        public ListIterator<E> listIterator(int location) {
            ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_691607959 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_691607959 = list.listIterator(location);
            } //End block
            addTaint(location);
            varB4EAC82CA7396A68D541C85D26508E83_691607959.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_691607959;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.listIterator(location);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.089 -0400", hash_original_method = "D935E09B492D323BEF59297A7648FE48", hash_generated_method = "0F4E7981AEDF274840E92CDDE3F7F334")
        @Override
        public E remove(int location) {
            E varB4EAC82CA7396A68D541C85D26508E83_380187620 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_380187620 = list.remove(location);
            } //End block
            addTaint(location);
            varB4EAC82CA7396A68D541C85D26508E83_380187620.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_380187620;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.remove(location);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.090 -0400", hash_original_method = "D9730991663FB8C206D80781B7E02750", hash_generated_method = "7B802560127C457116D744A0802FCCC6")
        @Override
        public E set(int location, E object) {
            E varB4EAC82CA7396A68D541C85D26508E83_224769000 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_224769000 = list.set(location, object);
            } //End block
            addTaint(location);
            addTaint(object.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_224769000.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_224769000;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.set(location, object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.090 -0400", hash_original_method = "C38F2D62AA6D1EBD255ADC5369CBEC01", hash_generated_method = "5E8F70A2120622277C408BA348B4C829")
        @Override
        public List<E> subList(int start, int end) {
            List<E> varB4EAC82CA7396A68D541C85D26508E83_1362102738 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_1362102738 = new SynchronizedList<E>(list.subList(start, end), mutex);
            } //End block
            addTaint(start);
            addTaint(end);
            varB4EAC82CA7396A68D541C85D26508E83_1362102738.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1362102738;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedList<E>(list.subList(start, end), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.091 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "DB1DE1953401C4A8F22A25B2206D8A3D")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.101 -0400", hash_original_method = "172F08E6F2352F1764A4A70C48C6E243", hash_generated_method = "8F252424545A8808AC7AA922185BA6FB")
        private Object readResolve() {
            Object varB4EAC82CA7396A68D541C85D26508E83_1441825038 = null; //Variable for return #1
            Object varB4EAC82CA7396A68D541C85D26508E83_1843396202 = null; //Variable for return #2
            {
                varB4EAC82CA7396A68D541C85D26508E83_1441825038 = new SynchronizedRandomAccessList<E>(list, mutex);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1843396202 = this;
            Object varA7E53CE21691AB073D9660D615818899_2063381475; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_2063381475 = varB4EAC82CA7396A68D541C85D26508E83_1441825038;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_2063381475 = varB4EAC82CA7396A68D541C85D26508E83_1843396202;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_2063381475.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_2063381475;
            // ---------- Original Method ----------
            //if (list instanceof RandomAccess) {
                //return new SynchronizedRandomAccessList<E>(list, mutex);
            //}
            //return this;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.101 -0400", hash_original_field = "8883C8F4886CDFE339069F9C7525453D", hash_generated_field = "FDC751B2BA1321115D7B80AF666D89CA")

        private static long serialVersionUID = -7754090372962971524L;
    }


    
    static class SynchronizedMap<K, V> implements Map<K, V>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.111 -0400", hash_original_field = "6F8F57715090DA2632453988D9A1501B", hash_generated_field = "1785B4570966C73126874A8D942D2395")

        private Map<K, V> m;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.111 -0400", hash_original_field = "25A01BB859125507013A2FE9737D3C32", hash_generated_field = "5C5F8780FECE5E612AF5A86D3A8B3194")

        Object mutex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.115 -0400", hash_original_method = "C14189E3F71A4C148CB91C638F3BAAE3", hash_generated_method = "697756520B6F74069D1E5AA0F6D1C69A")
          SynchronizedMap(Map<K, V> map) {
            m = map;
            mutex = this;
            // ---------- Original Method ----------
            //m = map;
            //mutex = this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.115 -0400", hash_original_method = "6EAD9DD813CFD47244744C3F6D6A4D1C", hash_generated_method = "96BED7921FDC6B114140F51F8F22333E")
          SynchronizedMap(Map<K, V> map, Object mutex) {
            m = map;
            this.mutex = mutex;
            // ---------- Original Method ----------
            //m = map;
            //this.mutex = mutex;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.116 -0400", hash_original_method = "3DCF075501F09300584E40825720BBA2", hash_generated_method = "931659E7A8514DEF770EFF02D67516B0")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.116 -0400", hash_original_method = "D2C67B34100B05197A0572527ECA3220", hash_generated_method = "3B58E6064F7034C2B30E0229C364D407")
        @Override
        public boolean containsKey(Object key) {
            {
                boolean var5B3943E8DB1DEBF4053A7AC85BD5CB7F_621511180 = (m.containsKey(key));
            } //End block
            addTaint(key.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1678353347 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1678353347;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.containsKey(key);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.116 -0400", hash_original_method = "FFE2162DB44C1E8BEEAD35935B233C81", hash_generated_method = "D49361200719087AEC73124D331DED02")
        @Override
        public boolean containsValue(Object value) {
            {
                boolean var9B502A789B5AAD38CD0ED829F2887AEF_1508236613 = (m.containsValue(value));
            } //End block
            addTaint(value.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_357750382 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_357750382;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.containsValue(value);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.121 -0400", hash_original_method = "E5EA9A3F9567269DAA52E0C08140D3D5", hash_generated_method = "18BAFF38D50BD9EA9A9AA8D46CEC499E")
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_1547109796 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_1547109796 = new SynchronizedSet<Map.Entry<K, V>>(m.entrySet(), mutex);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1547109796.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1547109796;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSet<Map.Entry<K, V>>(m.entrySet(), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.122 -0400", hash_original_method = "573EFA9740FEBDEC9C1CCFD8172CCEF0", hash_generated_method = "5569D93204A8DCB9281A8613F9E1FF1D")
        @Override
        public boolean equals(Object object) {
            {
                boolean var3653CC7A1B6721F556FDF4EA3FD61A52_152249586 = (m.equals(object));
            } //End block
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_608378285 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_608378285;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.equals(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.122 -0400", hash_original_method = "80DF7D6FED6980DF61457325CD64503D", hash_generated_method = "9A3354EA08AE926F9681F263D4B2F073")
        @Override
        public V get(Object key) {
            V varB4EAC82CA7396A68D541C85D26508E83_1842074437 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_1842074437 = m.get(key);
            } //End block
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1842074437.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1842074437;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.get(key);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.123 -0400", hash_original_method = "5DDF560D56DA8F61EEAD582BB150A893", hash_generated_method = "4D39321E22C6BBC13C97A65CA7CC3433")
        @Override
        public int hashCode() {
            {
                int var58938B03D27AEF577E5F8B43D45478A1_659329170 = (m.hashCode());
            } //End block
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_432210051 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_432210051;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.hashCode();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.123 -0400", hash_original_method = "40A122CDBD7096230690259CC30A0F7A", hash_generated_method = "4FC193DF618FFB85D4F4751323306CF1")
        @Override
        public boolean isEmpty() {
            {
                boolean var20AA7E3C23DC3AFB5FE1B5D3BD0CE158_433273220 = (m.isEmpty());
            } //End block
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1637456672 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1637456672;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.isEmpty();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.149 -0400", hash_original_method = "2FBB6190D51F2A6210F8CF71191E69DD", hash_generated_method = "A4A871EBF3AA45B08994ED409BB66354")
        @Override
        public Set<K> keySet() {
            Set<K> varB4EAC82CA7396A68D541C85D26508E83_760211940 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_760211940 = new SynchronizedSet<K>(m.keySet(), mutex);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_760211940.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_760211940;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSet<K>(m.keySet(), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.166 -0400", hash_original_method = "4BBBC2EF3E646AB7C0C1BFCAE8571FAF", hash_generated_method = "57491204E839B7185A1A7703608F5720")
        @Override
        public V put(K key, V value) {
            V varB4EAC82CA7396A68D541C85D26508E83_573724634 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_573724634 = m.put(key, value);
            } //End block
            addTaint(key.getTaint());
            addTaint(value.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_573724634.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_573724634;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.put(key, value);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.167 -0400", hash_original_method = "400FF0E6707670DAA4FF7ECA275302A3", hash_generated_method = "DB9FF77F668C1D72924587E83C74A1E6")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.167 -0400", hash_original_method = "98B37460DCD5FD18048F5172283C3141", hash_generated_method = "78052DBD21886B50ADB81F817CED3950")
        @Override
        public V remove(Object key) {
            V varB4EAC82CA7396A68D541C85D26508E83_722164752 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_722164752 = m.remove(key);
            } //End block
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_722164752.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_722164752;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.remove(key);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.168 -0400", hash_original_method = "A48EE7C65347333E889EFC2ECD0A019A", hash_generated_method = "90D5184FE96C18C7F8DA3CEBE320AEED")
        @Override
        public int size() {
            {
                int var0BF7698F6735353014CC57B558785727_753354672 = (m.size());
            } //End block
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2030710124 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2030710124;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.size();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.168 -0400", hash_original_method = "BB797020E54DC33FB15BC9404E89E5CD", hash_generated_method = "98C3312C2866D9C4812390BE8F29D0AD")
        @Override
        public Collection<V> values() {
            Collection<V> varB4EAC82CA7396A68D541C85D26508E83_1530785896 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_1530785896 = new SynchronizedCollection<V>(m.values(), mutex);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1530785896.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1530785896;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedCollection<V>(m.values(), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.171 -0400", hash_original_method = "CB61B465EF18C12F472B81636CD4AC79", hash_generated_method = "CC50C4438DC2F841073C8F9BC055C3A0")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_576195074 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_576195074 = m.toString();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_576195074.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_576195074;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.toString();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.171 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "DB1DE1953401C4A8F22A25B2206D8A3D")
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.171 -0400", hash_original_field = "5DC93EB19DFCBC7B8981ED54844A07B4", hash_generated_field = "1CD7BF5E81B21D730197EAE8B8531743")

        private static long serialVersionUID = 1978198479659022715L;
    }


    
    static class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.181 -0400", hash_original_method = "F3863A567ABAC10F9410ABCF2A4DC8AC", hash_generated_method = "B3C414CCF795BDAB85BAEA8F2098B4FB")
          SynchronizedSet(Set<E> set) {
            super(set);
            addTaint(set.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.181 -0400", hash_original_method = "A1BA2E3E145DCA2C522F0AB9439A1572", hash_generated_method = "F2771B0F9A187173FBD167BE172A69B3")
          SynchronizedSet(Set<E> set, Object mutex) {
            super(set, mutex);
            addTaint(set.getTaint());
            addTaint(mutex.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.181 -0400", hash_original_method = "E045FF0B832C85F3AF0597463FE3892F", hash_generated_method = "D0D27EA9D65A2AF420E1FA0696D33C6D")
        @Override
        public boolean equals(Object object) {
            {
                boolean varEA83122D095DC61C01436A4AA2CBB70C_1106441168 = (c.equals(object));
            } //End block
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_569600735 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_569600735;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.equals(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.181 -0400", hash_original_method = "60CA731F9E7ECB7D3EED20B0D6D4AB09", hash_generated_method = "4339588839A02B89CE3DF23A4C7EBBC2")
        @Override
        public int hashCode() {
            {
                int varDBC342B671922A4943718E25F26D87D0_177044326 = (c.hashCode());
            } //End block
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_558452158 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_558452158;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.hashCode();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.188 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "DB1DE1953401C4A8F22A25B2206D8A3D")
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.188 -0400", hash_original_field = "916EB185FF2AF0CF7FFC612F07D6DA1B", hash_generated_field = "4C02F77876AE663B0E37D90403F14A4B")

        private static long serialVersionUID = 487447009682186044L;
    }


    
    static class SynchronizedSortedMap<K, V> extends SynchronizedMap<K, V> implements SortedMap<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.188 -0400", hash_original_field = "ED79ACB0CD3D7F8320C53C7798335EF0", hash_generated_field = "F813233D7B24D3620137345516D05A23")

        private SortedMap<K, V> sm;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.188 -0400", hash_original_method = "2E0F62BCD34367F1E6E251286E17ABEB", hash_generated_method = "65B92739EACB6292AF1017EE07725F62")
          SynchronizedSortedMap(SortedMap<K, V> map) {
            super(map);
            sm = map;
            // ---------- Original Method ----------
            //sm = map;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.189 -0400", hash_original_method = "5BF33998E3FF0155F7A513C6A201FE85", hash_generated_method = "954D8A68339AFC6EE619959623984CAA")
          SynchronizedSortedMap(SortedMap<K, V> map, Object mutex) {
            super(map, mutex);
            sm = map;
            addTaint(mutex.getTaint());
            // ---------- Original Method ----------
            //sm = map;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.189 -0400", hash_original_method = "78218A5A359D1FCDF6B98779037FCB94", hash_generated_method = "A27E5E2F1F5129B5ABBD96BE319FD356")
        @Override
        public Comparator<? super K> comparator() {
            Comparator<? super K> varB4EAC82CA7396A68D541C85D26508E83_1795470565 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_1795470565 = sm.comparator();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1795470565.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1795470565;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return sm.comparator();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.191 -0400", hash_original_method = "4A44F83861E496A35113DD67FECD390A", hash_generated_method = "0089FE41E58E897BEFD4227239AAEB5F")
        @Override
        public K firstKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_1805921197 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_1805921197 = sm.firstKey();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1805921197.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1805921197;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return sm.firstKey();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.191 -0400", hash_original_method = "758EF70CDC2061BD7D7B124D17EF3F64", hash_generated_method = "6A7BA759413605CB46E47D309EEFC62E")
        @Override
        public SortedMap<K, V> headMap(K endKey) {
            SortedMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_1111743474 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_1111743474 = new SynchronizedSortedMap<K, V>(sm.headMap(endKey),
                        mutex);
            } //End block
            addTaint(endKey.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1111743474.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1111743474;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedMap<K, V>(sm.headMap(endKey),
                        //mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.193 -0400", hash_original_method = "ECB924A52CC9F341D1EEB7E5D7BCCDC8", hash_generated_method = "C9C40EDE21FE19623DF615E57C7096EA")
        @Override
        public K lastKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_962986680 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_962986680 = sm.lastKey();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_962986680.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_962986680;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return sm.lastKey();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.193 -0400", hash_original_method = "E82E6227AA62F00EB1D33B47A72F41C4", hash_generated_method = "DC5320C0FBFF8E0D8913FCAB8630D3A9")
        @Override
        public SortedMap<K, V> subMap(K startKey, K endKey) {
            SortedMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_1084037668 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_1084037668 = new SynchronizedSortedMap<K, V>(sm.subMap(startKey,
                        endKey), mutex);
            } //End block
            addTaint(startKey.getTaint());
            addTaint(endKey.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1084037668.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1084037668;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedMap<K, V>(sm.subMap(startKey,
                        //endKey), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.194 -0400", hash_original_method = "F7B84D714F16D295C7D43C8AA5E52D6A", hash_generated_method = "52DCCBCFCED25A768F546D509EFEF30E")
        @Override
        public SortedMap<K, V> tailMap(K startKey) {
            SortedMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_1975235302 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_1975235302 = new SynchronizedSortedMap<K, V>(sm.tailMap(startKey),
                        mutex);
            } //End block
            addTaint(startKey.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1975235302.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1975235302;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedMap<K, V>(sm.tailMap(startKey),
                        //mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.195 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "DB1DE1953401C4A8F22A25B2206D8A3D")
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.195 -0400", hash_original_field = "CA84F69F8568978C0AA41949BE696442", hash_generated_field = "F11C494151D8A9CF260338F77894A5A8")

        private static long serialVersionUID = -8798146769416483793L;
    }


    
    static class SynchronizedSortedSet<E> extends SynchronizedSet<E> implements SortedSet<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.195 -0400", hash_original_field = "3691308F2A4C2F6983F2880D32E29C84", hash_generated_field = "5220A6F2AA4CB98BB6C290F0BB717E86")

        private SortedSet<E> ss;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.195 -0400", hash_original_method = "B2F0E775DF29B0E6B28447766B0AA532", hash_generated_method = "4CBCB006A0B32CDF41866EAC9A8E2DC9")
          SynchronizedSortedSet(SortedSet<E> set) {
            super(set);
            ss = set;
            // ---------- Original Method ----------
            //ss = set;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.197 -0400", hash_original_method = "46957450EFA60C06BEFC5742F9BFAC78", hash_generated_method = "162269369C68BEF6B4124813A13B8D19")
          SynchronizedSortedSet(SortedSet<E> set, Object mutex) {
            super(set, mutex);
            ss = set;
            addTaint(mutex.getTaint());
            // ---------- Original Method ----------
            //ss = set;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.218 -0400", hash_original_method = "D71F7DA0E84FA7A091B4017D559410C5", hash_generated_method = "053FDFCDE50E0E0ACEF941BB4EC39D9F")
        @Override
        public Comparator<? super E> comparator() {
            Comparator<? super E> varB4EAC82CA7396A68D541C85D26508E83_1438190538 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_1438190538 = ss.comparator();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1438190538.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1438190538;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return ss.comparator();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.218 -0400", hash_original_method = "C2C55C7E331CFDE8E84B8FC74FDABE02", hash_generated_method = "9CAAA083079B631C4445B8F045E3A0FB")
        @Override
        public E first() {
            E varB4EAC82CA7396A68D541C85D26508E83_199443649 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_199443649 = ss.first();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_199443649.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_199443649;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return ss.first();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.219 -0400", hash_original_method = "86DA75392AF50D6AE53AEE4A4052EBA8", hash_generated_method = "7858FD29D34CA96FEE27B7A5B3A82E24")
        @Override
        public SortedSet<E> headSet(E end) {
            SortedSet<E> varB4EAC82CA7396A68D541C85D26508E83_778207444 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_778207444 = new SynchronizedSortedSet<E>(ss.headSet(end), mutex);
            } //End block
            addTaint(end.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_778207444.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_778207444;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedSet<E>(ss.headSet(end), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.224 -0400", hash_original_method = "3C10DA3BCCE6BED4EBD1F6A2C6BC8438", hash_generated_method = "48525CDE09F80646849E72901A568950")
        @Override
        public E last() {
            E varB4EAC82CA7396A68D541C85D26508E83_977038998 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_977038998 = ss.last();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_977038998.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_977038998;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return ss.last();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.230 -0400", hash_original_method = "662A59FFAA1C1722D75A374EC93FB0DF", hash_generated_method = "262D9AB8EF9C303A43711C0BE30214D1")
        @Override
        public SortedSet<E> subSet(E start, E end) {
            SortedSet<E> varB4EAC82CA7396A68D541C85D26508E83_428657367 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_428657367 = new SynchronizedSortedSet<E>(ss.subSet(start, end),
                        mutex);
            } //End block
            addTaint(start.getTaint());
            addTaint(end.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_428657367.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_428657367;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedSet<E>(ss.subSet(start, end),
                        //mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.230 -0400", hash_original_method = "4C04840896A126B8B17AD8E0926A5B00", hash_generated_method = "25B83EE5E1AFC26766D491E14CE4757C")
        @Override
        public SortedSet<E> tailSet(E start) {
            SortedSet<E> varB4EAC82CA7396A68D541C85D26508E83_861669392 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_861669392 = new SynchronizedSortedSet<E>(ss.tailSet(start), mutex);
            } //End block
            addTaint(start.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_861669392.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_861669392;
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedSet<E>(ss.tailSet(start), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.231 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "DB1DE1953401C4A8F22A25B2206D8A3D")
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.231 -0400", hash_original_field = "7550293A247191A63B69680B8051BA5C", hash_generated_field = "4AC00B60B67620AD21C2C186D9ED547F")

        private static long serialVersionUID = 8695801310862127406L;
    }


    
    private static class UnmodifiableCollection<E> implements Collection<E>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.231 -0400", hash_original_field = "4A8A08F09D37B73795649038408B5F33", hash_generated_field = "A3C80A7E02E49F20400373DFBAF9696A")

        Collection<E> c;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.231 -0400", hash_original_method = "0B21B3311CB87F81844FA591591A704A", hash_generated_method = "F8A220D652916612975A1BF5C32AE7B2")
          UnmodifiableCollection(Collection<E> collection) {
            c = collection;
            // ---------- Original Method ----------
            //c = collection;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.231 -0400", hash_original_method = "1E7EFCC2BAD401EE702FAECD906F0B57", hash_generated_method = "FC85AABA33CD116E642EEA1CC3D9D02A")
        @Override
        public boolean add(E object) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1397823333 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1397823333;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.238 -0400", hash_original_method = "A14B246F22D65FADC1A66C9C0851763B", hash_generated_method = "A3E93EC27D2C59555CC186AAD299C6E7")
        @Override
        public boolean addAll(Collection<? extends E> collection) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1343226475 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1343226475;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.239 -0400", hash_original_method = "C5BE2B5F9D582C4EED1DC0880E8741A1", hash_generated_method = "2CA329ADE50B407D285AB2E4B5875FC8")
        @Override
        public void clear() {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.239 -0400", hash_original_method = "9A5FA57B69BAE7BFE0B020704235C788", hash_generated_method = "0BCF3F4099B22A22D7136C503B1957DB")
        @Override
        public boolean contains(Object object) {
            boolean var57979CEAB3B2144CFD864D01F9E7B4FE_765755744 = (c.contains(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1683819658 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1683819658;
            // ---------- Original Method ----------
            //return c.contains(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.240 -0400", hash_original_method = "BD1B4CD05BF6E123B0DC6FD003A6020C", hash_generated_method = "3165955C58E4BE64DD1093BFF90043D8")
        @Override
        public boolean containsAll(Collection<?> collection) {
            boolean varF92105B68CE9F70CF43B3142D405452C_670026995 = (c.containsAll(collection));
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1328077383 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1328077383;
            // ---------- Original Method ----------
            //return c.containsAll(collection);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.240 -0400", hash_original_method = "F9A3CB1FB7570D28EBE20660E2FC6F42", hash_generated_method = "94E7F001B18D749DD92413E56BEEC3E9")
        @Override
        public boolean isEmpty() {
            boolean var528EAD02A70F822F393BB0C54FBB923C_1235294834 = (c.isEmpty());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_70180780 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_70180780;
            // ---------- Original Method ----------
            //return c.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.241 -0400", hash_original_method = "57C2B30126E9906DFFF70EEB2D2CD18D", hash_generated_method = "73836D09B97C0E330B34F95FA3B28682")
        @Override
        public Iterator<E> iterator() {
            Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_762947462 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_762947462 = new Iterator<E>() {
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
            varB4EAC82CA7396A68D541C85D26508E83_762947462.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_762947462;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.249 -0400", hash_original_method = "2165C77F20F5DBDDE4D0AED313262684", hash_generated_method = "FF2351E6049BCB6877DE89E2264D6714")
        @Override
        public boolean remove(Object object) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_155576557 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_155576557;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.252 -0400", hash_original_method = "95D6D7B80D3C762A794FEAFDE42B30FC", hash_generated_method = "8CD0A11EB1D4948F9C733ED33366B117")
        @Override
        public boolean removeAll(Collection<?> collection) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_576632534 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_576632534;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.252 -0400", hash_original_method = "D4789A90B422D35C3FC475A0D6C54BE8", hash_generated_method = "FBB79ECC5F6995F26E56F327EFE6710F")
        @Override
        public boolean retainAll(Collection<?> collection) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_46033939 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_46033939;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.254 -0400", hash_original_method = "AC97C28F724592ABA809E2470D95C119", hash_generated_method = "F9CBA2B9E059B2F261DB842D50C4B5F4")
        @Override
        public int size() {
            int varC247C84593AA6020ED979B19566D13FE_861158794 = (c.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1108022889 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1108022889;
            // ---------- Original Method ----------
            //return c.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.268 -0400", hash_original_method = "89D7D02A9D2BDF31E775C08108CBDE5B", hash_generated_method = "42888E378DFF2F33DC58FCEE6CCE689A")
        @Override
        public Object[] toArray() {
            Object[] varB4EAC82CA7396A68D541C85D26508E83_873536444 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_873536444 = c.toArray();
            varB4EAC82CA7396A68D541C85D26508E83_873536444.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_873536444;
            // ---------- Original Method ----------
            //return c.toArray();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.269 -0400", hash_original_method = "D5913A45F2385B9A173BEEED47EA354F", hash_generated_method = "F667A81F1E4BF7ABF4FDFC453EDA4871")
        @Override
        public <T> T[] toArray(T[] array) {
            T[] varB4EAC82CA7396A68D541C85D26508E83_1124140849 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1124140849 = c.toArray(array);
            addTaint(array[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1124140849.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1124140849;
            // ---------- Original Method ----------
            //return c.toArray(array);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.270 -0400", hash_original_method = "424D4966F358AE6553349A6493C21674", hash_generated_method = "5BF02833696E953546A12DDE309841B8")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_646675627 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_646675627 = c.toString();
            varB4EAC82CA7396A68D541C85D26508E83_646675627.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_646675627;
            // ---------- Original Method ----------
            //return c.toString();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.270 -0400", hash_original_field = "BF3B1BE107A3BC6EF3F11D547E97ECD3", hash_generated_field = "7DC41621514BC7C6F06C10E37F3F4C9C")

        private static long serialVersionUID = 1820017752578914078L;
    }


    
    private static class UnmodifiableRandomAccessList<E> extends UnmodifiableList<E> implements RandomAccess {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.270 -0400", hash_original_method = "0A20B358F7BA1E60AD6DE80ADB85C324", hash_generated_method = "205D9E6E7A9FC9AE79599882AC59F3B2")
          UnmodifiableRandomAccessList(List<E> l) {
            super(l);
            addTaint(l.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.271 -0400", hash_original_method = "BFD692E8EF2A50E82DD6BA0EC7051578", hash_generated_method = "6F3046C64C615C879C8934397EE58A5C")
        @Override
        public List<E> subList(int start, int end) {
            List<E> varB4EAC82CA7396A68D541C85D26508E83_696234831 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_696234831 = new UnmodifiableRandomAccessList<E>(list.subList(start, end));
            addTaint(start);
            addTaint(end);
            varB4EAC82CA7396A68D541C85D26508E83_696234831.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_696234831;
            // ---------- Original Method ----------
            //return new UnmodifiableRandomAccessList<E>(list.subList(start, end));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.271 -0400", hash_original_method = "C39E6F512687738DD8D987CDE63A2838", hash_generated_method = "E38D4C59662BECFAB158FDE3F208F694")
        private Object writeReplace() {
            Object varB4EAC82CA7396A68D541C85D26508E83_1113424591 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1113424591 = new UnmodifiableList<E>(list);
            varB4EAC82CA7396A68D541C85D26508E83_1113424591.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1113424591;
            // ---------- Original Method ----------
            //return new UnmodifiableList<E>(list);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.271 -0400", hash_original_field = "70DB59789BD14A138F9B12A5CF11EB14", hash_generated_field = "9DEB760C10A64C088B03BD2D84EA2AD3")

        private static long serialVersionUID = -2542308836966382001L;
    }


    
    private static class UnmodifiableList<E> extends UnmodifiableCollection<E> implements List<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.271 -0400", hash_original_field = "10AE9FC7D453B0DD525D0EDF2EDE7961", hash_generated_field = "1ECA8D0C53ED31C6D874046BB18C0645")

        List<E> list;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.271 -0400", hash_original_method = "4CB96388E36B825DE711E2E59A893E0D", hash_generated_method = "51986B2400081BEED0D63B6036986FF3")
          UnmodifiableList(List<E> l) {
            super(l);
            list = l;
            // ---------- Original Method ----------
            //list = l;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.274 -0400", hash_original_method = "CE54A57EF9628E9FD413F964E9F93054", hash_generated_method = "4E38A1F7266D70D7D320F93ABDA9F566")
        @Override
        public void add(int location, E object) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(location);
            addTaint(object.getTaint());
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.274 -0400", hash_original_method = "6CD19404B4901DECE5B6F72EB7D0CD8F", hash_generated_method = "6794C9D2B5459FF22624F71E9F6C47F4")
        @Override
        public boolean addAll(int location, Collection<? extends E> collection) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(location);
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1787988713 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1787988713;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.275 -0400", hash_original_method = "C3C1892342CAEB152D9191558B893ACD", hash_generated_method = "CE8DFE4C97FDD1F5C0D9D18D3EDEDD18")
        @Override
        public boolean equals(Object object) {
            boolean var983E353D0DFE7FD02AAEFC303F168456_1198663696 = (list.equals(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_621089018 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_621089018;
            // ---------- Original Method ----------
            //return list.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.275 -0400", hash_original_method = "DFB24286AA0C5C6BF58031CA4ED7CDCB", hash_generated_method = "2233D8A8A10EE8C37751A6D6341BCFAD")
        @Override
        public E get(int location) {
            E varB4EAC82CA7396A68D541C85D26508E83_88250082 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_88250082 = list.get(location);
            addTaint(location);
            varB4EAC82CA7396A68D541C85D26508E83_88250082.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_88250082;
            // ---------- Original Method ----------
            //return list.get(location);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.275 -0400", hash_original_method = "8FDA3E2E38E99F5D6FC34E94E92E953F", hash_generated_method = "31CD22DEB0944FD745CAFAC82D3470C1")
        @Override
        public int hashCode() {
            int var9A1610964D862FF54E00A16E6D7BD291_1942046644 = (list.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1914266934 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1914266934;
            // ---------- Original Method ----------
            //return list.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.275 -0400", hash_original_method = "E8AAF2C874038C363BF8C80F2A4ED8F2", hash_generated_method = "E5F92C05833A1B34E513269643916E19")
        @Override
        public int indexOf(Object object) {
            int var77BCF240B74578A0DBB7E15170347534_1378758679 = (list.indexOf(object));
            addTaint(object.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1474448819 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1474448819;
            // ---------- Original Method ----------
            //return list.indexOf(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.278 -0400", hash_original_method = "658C7926C6DFF1B86F4D9B6B0E3F5BBD", hash_generated_method = "5BF98A57DBA6BCD9249CA1230B8C2F1A")
        @Override
        public int lastIndexOf(Object object) {
            int var158B58B87F16034A803BFB0430AFCD59_681726493 = (list.lastIndexOf(object));
            addTaint(object.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1951868792 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1951868792;
            // ---------- Original Method ----------
            //return list.lastIndexOf(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.284 -0400", hash_original_method = "DF7BE0B13ABC5A9B1C74313BD06FB64C", hash_generated_method = "2030F420B962C79E08CBF1AA96C35527")
        @Override
        public ListIterator<E> listIterator() {
            ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_902552232 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_902552232 = listIterator(0);
            varB4EAC82CA7396A68D541C85D26508E83_902552232.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_902552232;
            // ---------- Original Method ----------
            //return listIterator(0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.286 -0400", hash_original_method = "1D0E6831E50FA8995D23240A6E091C82", hash_generated_method = "685CDE25BF487DAED130C781B7B1FEED")
        @Override
        public ListIterator<E> listIterator(final int location) {
            ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_1181755632 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1181755632 = new ListIterator<E>() {
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
            varB4EAC82CA7396A68D541C85D26508E83_1181755632.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1181755632;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.286 -0400", hash_original_method = "5388D372D048D053ADD084F02A9C1484", hash_generated_method = "ACA80C53B37816218B9855BF5E9A7790")
        @Override
        public E remove(int location) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(location);
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.287 -0400", hash_original_method = "8830E2F07CC294339D5D496574BCFA5E", hash_generated_method = "FC1CD5B83BE519CD37A91D24C6B9D9F3")
        @Override
        public E set(int location, E object) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(location);
            addTaint(object.getTaint());
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.289 -0400", hash_original_method = "82D78FB8922B9A0888EF8A304898D60D", hash_generated_method = "3F29C19D80B471EA631DCC084F21F41E")
        @Override
        public List<E> subList(int start, int end) {
            List<E> varB4EAC82CA7396A68D541C85D26508E83_36743094 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_36743094 = new UnmodifiableList<E>(list.subList(start, end));
            addTaint(start);
            addTaint(end);
            varB4EAC82CA7396A68D541C85D26508E83_36743094.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_36743094;
            // ---------- Original Method ----------
            //return new UnmodifiableList<E>(list.subList(start, end));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.289 -0400", hash_original_method = "5F3DDA40E6BDC67502A2E43BA75DBB15", hash_generated_method = "7597F925C371574DD9C93AFEA11E6916")
        private Object readResolve() {
            Object varB4EAC82CA7396A68D541C85D26508E83_1470337220 = null; //Variable for return #1
            Object varB4EAC82CA7396A68D541C85D26508E83_1591780980 = null; //Variable for return #2
            {
                varB4EAC82CA7396A68D541C85D26508E83_1470337220 = new UnmodifiableRandomAccessList<E>(list);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1591780980 = this;
            Object varA7E53CE21691AB073D9660D615818899_1774395817; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1774395817 = varB4EAC82CA7396A68D541C85D26508E83_1470337220;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1774395817 = varB4EAC82CA7396A68D541C85D26508E83_1591780980;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1774395817.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1774395817;
            // ---------- Original Method ----------
            //if (list instanceof RandomAccess) {
                //return new UnmodifiableRandomAccessList<E>(list);
            //}
            //return this;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.290 -0400", hash_original_field = "69FDA83BF467A43A3D5BCAA929D897B3", hash_generated_field = "CC3A2DE8F788BD63A31131D897B24AD1")

        private static long serialVersionUID = -283967356065247728L;
    }


    
    private static class UnmodifiableMap<K, V> implements Map<K, V>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.301 -0400", hash_original_field = "6F8F57715090DA2632453988D9A1501B", hash_generated_field = "1785B4570966C73126874A8D942D2395")

        private Map<K, V> m;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.301 -0400", hash_original_method = "74C4A0289A3E9196E4EF75F76384A7D2", hash_generated_method = "DA7567E66A4C382E1EF89234BCC9D997")
          UnmodifiableMap(Map<K, V> map) {
            m = map;
            // ---------- Original Method ----------
            //m = map;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.302 -0400", hash_original_method = "C5BE2B5F9D582C4EED1DC0880E8741A1", hash_generated_method = "2CA329ADE50B407D285AB2E4B5875FC8")
        @Override
        public void clear() {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.302 -0400", hash_original_method = "A6C730848D8A626F99D8229EE744E3C0", hash_generated_method = "A8ABC2E6280D4E337B7FA2820D37ECB8")
        @Override
        public boolean containsKey(Object key) {
            boolean var2519B7EF565FEC21B6285F5E44AC148E_503833543 = (m.containsKey(key));
            addTaint(key.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1938863490 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1938863490;
            // ---------- Original Method ----------
            //return m.containsKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.303 -0400", hash_original_method = "EF8C00CF950E8C186D2F05E1E556F384", hash_generated_method = "3F00A8515B4C6565CFFB7EDF680E4227")
        @Override
        public boolean containsValue(Object value) {
            boolean varF8CB74E2C5E0734947B397D82173BDD4_1392505541 = (m.containsValue(value));
            addTaint(value.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1805553133 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1805553133;
            // ---------- Original Method ----------
            //return m.containsValue(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.316 -0400", hash_original_method = "FB0DE15DA25D3994421C9FBDD1812EDD", hash_generated_method = "93D3C4D1FD5013A486A760E50DBCF73D")
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_9320581 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_9320581 = new UnmodifiableEntrySet<K, V>(m.entrySet());
            varB4EAC82CA7396A68D541C85D26508E83_9320581.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_9320581;
            // ---------- Original Method ----------
            //return new UnmodifiableEntrySet<K, V>(m.entrySet());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.316 -0400", hash_original_method = "CE201E78EAC5D1903F741160CB297EAE", hash_generated_method = "3ECA33A32691ED482FE6B9B565654ABC")
        @Override
        public boolean equals(Object object) {
            boolean var9745819ACBF7C47D9CAE10D95AB26047_2083495203 = (m.equals(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2022176746 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2022176746;
            // ---------- Original Method ----------
            //return m.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.317 -0400", hash_original_method = "B8FE254B61C57EC3A6DCE539976DA268", hash_generated_method = "1235EF6A4AA72BFD1681764D67D2875D")
        @Override
        public V get(Object key) {
            V varB4EAC82CA7396A68D541C85D26508E83_268357049 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_268357049 = m.get(key);
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_268357049.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_268357049;
            // ---------- Original Method ----------
            //return m.get(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.317 -0400", hash_original_method = "E3229E3389F030DD50B79734943DB788", hash_generated_method = "71DE4FCAA8B4A7E6B4E3803B6B47BA89")
        @Override
        public int hashCode() {
            int varAA1293165230C9829C1AEACFFF576DFC_1878470700 = (m.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_371041889 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_371041889;
            // ---------- Original Method ----------
            //return m.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.318 -0400", hash_original_method = "B9E63D3C52241E7E917CB1416ABA36E5", hash_generated_method = "36344623C15FF282FEB5A252D2BACC51")
        @Override
        public boolean isEmpty() {
            boolean var028CF644E61B84328EAB66D556672A81_1156113728 = (m.isEmpty());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_966809829 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_966809829;
            // ---------- Original Method ----------
            //return m.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.318 -0400", hash_original_method = "2CC049F262DAAA6660AF161E9C8606F6", hash_generated_method = "5533C43EF94C5524A9005F1A1121EE9F")
        @Override
        public Set<K> keySet() {
            Set<K> varB4EAC82CA7396A68D541C85D26508E83_2088164421 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2088164421 = new UnmodifiableSet<K>(m.keySet());
            varB4EAC82CA7396A68D541C85D26508E83_2088164421.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2088164421;
            // ---------- Original Method ----------
            //return new UnmodifiableSet<K>(m.keySet());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.319 -0400", hash_original_method = "1AE25A34BEB4A8F08F41373ADFFCFE34", hash_generated_method = "D7819781C010BECFFB3BC37EE093E818")
        @Override
        public V put(K key, V value) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(key.getTaint());
            addTaint(value.getTaint());
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.334 -0400", hash_original_method = "1D605566C28BBD06FDC515389557B406", hash_generated_method = "8C9B96AACD1010A390DA93C9E1C54679")
        @Override
        public void putAll(Map<? extends K, ? extends V> map) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(map.getTaint());
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.335 -0400", hash_original_method = "1F8D4C123F3DDBF68E61E38EDB13F5FB", hash_generated_method = "CAC84F3EBC2CB52F20821DF2278AA8A5")
        @Override
        public V remove(Object key) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(key.getTaint());
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.336 -0400", hash_original_method = "A04EE09DEB6F21FAA6A7E10DF6401CD1", hash_generated_method = "50DB67E756D5F3F7A2411C4757B28CDE")
        @Override
        public int size() {
            int varDBD6E28F15F3D13B8127CF62DD69ACD5_1998882758 = (m.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_626518319 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_626518319;
            // ---------- Original Method ----------
            //return m.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.337 -0400", hash_original_method = "19DD84E0D2EBBBC2FCDA12D023824450", hash_generated_method = "8C5C73E7FEFE201589DE7424637AE453")
        @Override
        public Collection<V> values() {
            Collection<V> varB4EAC82CA7396A68D541C85D26508E83_2111039873 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2111039873 = new UnmodifiableCollection<V>(m.values());
            varB4EAC82CA7396A68D541C85D26508E83_2111039873.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2111039873;
            // ---------- Original Method ----------
            //return new UnmodifiableCollection<V>(m.values());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.337 -0400", hash_original_method = "5DD44B3CD2826BF39F974F66579CF74F", hash_generated_method = "AE564255D67C6077E60C91F6025FA143")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_995247161 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_995247161 = m.toString();
            varB4EAC82CA7396A68D541C85D26508E83_995247161.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_995247161;
            // ---------- Original Method ----------
            //return m.toString();
        }

        
        private static class UnmodifiableEntrySet<K, V> extends UnmodifiableSet<Map.Entry<K, V>> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.338 -0400", hash_original_method = "211DEE98878E4422E2F38E79CDC5F0D4", hash_generated_method = "E5E05A5D1E2777C870B2B3DCCCA2A2BD")
              UnmodifiableEntrySet(Set<Map.Entry<K, V>> set) {
                super(set);
                addTaint(set.getTaint());
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.339 -0400", hash_original_method = "53A7F61EDA7A64FBCB28AE61A8906002", hash_generated_method = "AE5B3DA486B4A188CD3A1E57E7F3E190")
            @Override
            public Iterator<Map.Entry<K, V>> iterator() {
                Iterator<Map.Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_1796577959 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1796577959 = new Iterator<Map.Entry<K, V>>() {
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
                varB4EAC82CA7396A68D541C85D26508E83_1796577959.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1796577959;
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.359 -0400", hash_original_method = "C353E5DD4879B90DAE1A37DDC4A8ED8C", hash_generated_method = "A84F3EF99B8E6DDB9C551221F96C1C28")
            @Override
            public Object[] toArray() {
                Object[] varB4EAC82CA7396A68D541C85D26508E83_1747858221 = null; //Variable for return #1
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
                varB4EAC82CA7396A68D541C85D26508E83_1747858221 = result;
                varB4EAC82CA7396A68D541C85D26508E83_1747858221.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1747858221;
                // ---------- Original Method ----------
                //int length = c.size();
                //Object[] result = new Object[length];
                //Iterator<?> it = iterator();
                //for (int i = length; --i >= 0;) {
                    //result[i] = it.next();
                //}
                //return result;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.364 -0400", hash_original_method = "CB9686BEA448DC0D7D0077DDEB1917CB", hash_generated_method = "4281ABE3CE40928A3D59232FC2F5ACBF")
            @SuppressWarnings("unchecked")
            @Override
            public <T> T[] toArray(T[] contents) {
                T[] varB4EAC82CA7396A68D541C85D26508E83_668831755 = null; //Variable for return #1
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
                varB4EAC82CA7396A68D541C85D26508E83_668831755 = contents;
                addTaint(contents[0].getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_668831755.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_668831755;
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
                @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.364 -0400", hash_original_field = "5B2F0A0A5E89589F62B233C643034719", hash_generated_field = "24589B068FBC99F8ED52DE988ED39319")

                Map.Entry<K, V> mapEntry;
                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.365 -0400", hash_original_method = "E37A4627FD27E632126EED134E00D831", hash_generated_method = "A97AFE882B9E93ECA34E23B05853DCFA")
                  UnmodifiableMapEntry(Map.Entry<K, V> entry) {
                    mapEntry = entry;
                    // ---------- Original Method ----------
                    //mapEntry = entry;
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.365 -0400", hash_original_method = "90F914E663E54C2DC9846974DAA2EFB8", hash_generated_method = "75AE2CE58DACAD47D81260A5D2F0FDF2")
                @Override
                public boolean equals(Object object) {
                    boolean var1E6E5EE1426DD4D6EB65B99B916F7467_33707491 = (mapEntry.equals(object));
                    addTaint(object.getTaint());
                    boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_88328762 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_88328762;
                    // ---------- Original Method ----------
                    //return mapEntry.equals(object);
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.376 -0400", hash_original_method = "4DDB57034C15C2636BC5A8AFB2B3C75A", hash_generated_method = "982A4589D8BEECA47A835F9C905617A2")
                @Override
                public K getKey() {
                    K varB4EAC82CA7396A68D541C85D26508E83_273563347 = null; //Variable for return #1
                    varB4EAC82CA7396A68D541C85D26508E83_273563347 = mapEntry.getKey();
                    varB4EAC82CA7396A68D541C85D26508E83_273563347.addTaint(getTaint()); //Add taint from parent
                    return varB4EAC82CA7396A68D541C85D26508E83_273563347;
                    // ---------- Original Method ----------
                    //return mapEntry.getKey();
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.378 -0400", hash_original_method = "EA1063FCD9D2F699A9610E0A7FDC81FD", hash_generated_method = "C5B993785E7009F99D9D0C80CD8A7276")
                @Override
                public V getValue() {
                    V varB4EAC82CA7396A68D541C85D26508E83_426309419 = null; //Variable for return #1
                    varB4EAC82CA7396A68D541C85D26508E83_426309419 = mapEntry.getValue();
                    varB4EAC82CA7396A68D541C85D26508E83_426309419.addTaint(getTaint()); //Add taint from parent
                    return varB4EAC82CA7396A68D541C85D26508E83_426309419;
                    // ---------- Original Method ----------
                    //return mapEntry.getValue();
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.379 -0400", hash_original_method = "8A31FFFC42BCA6E359386EC1F8534D45", hash_generated_method = "CD11889DA9126E9C1BCA35FA502FD51A")
                @Override
                public int hashCode() {
                    int varB4446261767782D97888D65AE62449D4_699019392 = (mapEntry.hashCode());
                    int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1832464981 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1832464981;
                    // ---------- Original Method ----------
                    //return mapEntry.hashCode();
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.379 -0400", hash_original_method = "3526712C126765AF36CB8D920CBD3B1B", hash_generated_method = "1A2319FA1552949A1378D6A672B3348D")
                @Override
                public V setValue(V object) {
                    if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
                    addTaint(object.getTaint());
                    // ---------- Original Method ----------
                    //throw new UnsupportedOperationException();
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.390 -0400", hash_original_method = "514C7E8B8C54DBFDFB3E185BADD6AD0A", hash_generated_method = "DB9C16AC7ED52B163E3F00C2608EA00F")
                @Override
                public String toString() {
                    String varB4EAC82CA7396A68D541C85D26508E83_1427549001 = null; //Variable for return #1
                    varB4EAC82CA7396A68D541C85D26508E83_1427549001 = mapEntry.toString();
                    varB4EAC82CA7396A68D541C85D26508E83_1427549001.addTaint(getTaint()); //Add taint from parent
                    return varB4EAC82CA7396A68D541C85D26508E83_1427549001;
                    // ---------- Original Method ----------
                    //return mapEntry.toString();
                }

                
            }


            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.391 -0400", hash_original_field = "B44292591B716EDD855C6E185A9AC989", hash_generated_field = "D0F64DE9C2878B5A9F9C6AF47D1248F8")

            private static long serialVersionUID = 7854390611657943733L;
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.391 -0400", hash_original_field = "5569682F9E1154F1C678E958FEEE9E89", hash_generated_field = "C41A547252628431B112399CD10FEDC4")

        private static long serialVersionUID = -1034234728574286014L;
    }


    
    private static class UnmodifiableSet<E> extends UnmodifiableCollection<E> implements Set<E> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.391 -0400", hash_original_method = "D46A71F25EF02541A08678630568218D", hash_generated_method = "DBD124D7730B2343640D7C872444495D")
          UnmodifiableSet(Set<E> set) {
            super(set);
            addTaint(set.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.391 -0400", hash_original_method = "BB8664F3F5CB90AA83689CAADCD9EA6B", hash_generated_method = "59F9E3A63BE2A528C1CA15BCA2E87046")
        @Override
        public boolean equals(Object object) {
            boolean var68E706348FF72E55282D2AEF4301CA4B_590101807 = (c.equals(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1337483537 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1337483537;
            // ---------- Original Method ----------
            //return c.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.392 -0400", hash_original_method = "E858D80F3EEDE9F2B52CDB7DA7FBF12B", hash_generated_method = "30F673DD418258D7511A2A460D2968EF")
        @Override
        public int hashCode() {
            int var19B3D08FE3840D0D3E365DF71EF3E20C_1861870261 = (c.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1614741668 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1614741668;
            // ---------- Original Method ----------
            //return c.hashCode();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.392 -0400", hash_original_field = "F3BE7D79D6D6372B9FD4F3861D721F88", hash_generated_field = "81D5383F869927F5369A2964349AEBBA")

        private static long serialVersionUID = -9215047833775013803L;
    }


    
    private static class UnmodifiableSortedMap<K, V> extends UnmodifiableMap<K, V> implements SortedMap<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.392 -0400", hash_original_field = "ED79ACB0CD3D7F8320C53C7798335EF0", hash_generated_field = "F813233D7B24D3620137345516D05A23")

        private SortedMap<K, V> sm;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.392 -0400", hash_original_method = "AC9FE01B421B1E54651959AD61521CA6", hash_generated_method = "FE478A77C43C9AB097C4727B1013B70C")
          UnmodifiableSortedMap(SortedMap<K, V> map) {
            super(map);
            sm = map;
            // ---------- Original Method ----------
            //sm = map;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.392 -0400", hash_original_method = "E5FDBCC6560BE7E99B2D2F850BD84149", hash_generated_method = "B4A9571BC6C4FEBA1C94AD42CD8F693A")
        @Override
        public Comparator<? super K> comparator() {
            Comparator<? super K> varB4EAC82CA7396A68D541C85D26508E83_1044985119 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1044985119 = sm.comparator();
            varB4EAC82CA7396A68D541C85D26508E83_1044985119.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1044985119;
            // ---------- Original Method ----------
            //return sm.comparator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.393 -0400", hash_original_method = "B25E8C7440C76FBF812FF7AC9CA9D776", hash_generated_method = "9DA3A1B0ABBBA8DD4663ECB870E10D1C")
        @Override
        public K firstKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_1111208853 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1111208853 = sm.firstKey();
            varB4EAC82CA7396A68D541C85D26508E83_1111208853.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1111208853;
            // ---------- Original Method ----------
            //return sm.firstKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.393 -0400", hash_original_method = "EC6243B190269A05D31802D1260652E4", hash_generated_method = "873450318D77B6F26AC905C6A3EBD0A5")
        @Override
        public SortedMap<K, V> headMap(K before) {
            SortedMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_1927314128 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1927314128 = new UnmodifiableSortedMap<K, V>(sm.headMap(before));
            addTaint(before.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1927314128.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1927314128;
            // ---------- Original Method ----------
            //return new UnmodifiableSortedMap<K, V>(sm.headMap(before));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.409 -0400", hash_original_method = "00E9126A84DE8B71214859A17DA6BD2E", hash_generated_method = "B40C91238653BEC5DF08D97CC84FC867")
        @Override
        public K lastKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_112523871 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_112523871 = sm.lastKey();
            varB4EAC82CA7396A68D541C85D26508E83_112523871.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_112523871;
            // ---------- Original Method ----------
            //return sm.lastKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.409 -0400", hash_original_method = "B6411009D9179ABF4D7755605B648FDC", hash_generated_method = "A46774358F2CDD0E5B259B91E537874F")
        @Override
        public SortedMap<K, V> subMap(K start, K end) {
            SortedMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_525537664 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_525537664 = new UnmodifiableSortedMap<K, V>(sm.subMap(start, end));
            addTaint(start.getTaint());
            addTaint(end.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_525537664.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_525537664;
            // ---------- Original Method ----------
            //return new UnmodifiableSortedMap<K, V>(sm.subMap(start, end));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.410 -0400", hash_original_method = "59BADF6C5EE68C4E1DB5A6A22818328A", hash_generated_method = "6D97EAB734333473887EC3FF3804E0A9")
        @Override
        public SortedMap<K, V> tailMap(K after) {
            SortedMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_1149744774 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1149744774 = new UnmodifiableSortedMap<K, V>(sm.tailMap(after));
            addTaint(after.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1149744774.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1149744774;
            // ---------- Original Method ----------
            //return new UnmodifiableSortedMap<K, V>(sm.tailMap(after));
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.410 -0400", hash_original_field = "BB78CEF8331176F8CBF0AFC85E7523D8", hash_generated_field = "641E29FD5887F49BB2AAF6C5174209C1")

        private static long serialVersionUID = -8806743815996713206L;
    }


    
    private static class UnmodifiableSortedSet<E> extends UnmodifiableSet<E> implements SortedSet<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.410 -0400", hash_original_field = "3691308F2A4C2F6983F2880D32E29C84", hash_generated_field = "5220A6F2AA4CB98BB6C290F0BB717E86")

        private SortedSet<E> ss;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.410 -0400", hash_original_method = "232C45C3B4117EB9042FB58E6C0CE113", hash_generated_method = "C02ACFBA00E84FCE033C7CEC6C326A50")
          UnmodifiableSortedSet(SortedSet<E> set) {
            super(set);
            ss = set;
            // ---------- Original Method ----------
            //ss = set;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.421 -0400", hash_original_method = "8514D9255D678B041F55D03BA11DCA3B", hash_generated_method = "32EF875BA58C6AADA66C47BE6B831E9C")
        @Override
        public Comparator<? super E> comparator() {
            Comparator<? super E> varB4EAC82CA7396A68D541C85D26508E83_2046817708 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2046817708 = ss.comparator();
            varB4EAC82CA7396A68D541C85D26508E83_2046817708.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2046817708;
            // ---------- Original Method ----------
            //return ss.comparator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.422 -0400", hash_original_method = "6BB6C51843B41CC0DCB5509A79DBA008", hash_generated_method = "E2C391310A8CB4ECB6613597A9D1AAFA")
        @Override
        public E first() {
            E varB4EAC82CA7396A68D541C85D26508E83_1321956560 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1321956560 = ss.first();
            varB4EAC82CA7396A68D541C85D26508E83_1321956560.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1321956560;
            // ---------- Original Method ----------
            //return ss.first();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.425 -0400", hash_original_method = "74C4BE29898589F7D7948BADA3350612", hash_generated_method = "6D859B11288519D420EE83025E56512A")
        @Override
        public SortedSet<E> headSet(E before) {
            SortedSet<E> varB4EAC82CA7396A68D541C85D26508E83_826247589 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_826247589 = new UnmodifiableSortedSet<E>(ss.headSet(before));
            addTaint(before.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_826247589.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_826247589;
            // ---------- Original Method ----------
            //return new UnmodifiableSortedSet<E>(ss.headSet(before));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.425 -0400", hash_original_method = "AAC5DDE787ACA85752B94AAB77F6B0F8", hash_generated_method = "137733A35F64070BD2484B57280C331D")
        @Override
        public E last() {
            E varB4EAC82CA7396A68D541C85D26508E83_1835007679 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1835007679 = ss.last();
            varB4EAC82CA7396A68D541C85D26508E83_1835007679.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1835007679;
            // ---------- Original Method ----------
            //return ss.last();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.450 -0400", hash_original_method = "54602835FD774439E48CB96CB67F9D83", hash_generated_method = "2E46C6030F61F5BA5255D73A4E1E8F75")
        @Override
        public SortedSet<E> subSet(E start, E end) {
            SortedSet<E> varB4EAC82CA7396A68D541C85D26508E83_953896628 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_953896628 = new UnmodifiableSortedSet<E>(ss.subSet(start, end));
            addTaint(start.getTaint());
            addTaint(end.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_953896628.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_953896628;
            // ---------- Original Method ----------
            //return new UnmodifiableSortedSet<E>(ss.subSet(start, end));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.450 -0400", hash_original_method = "37640609DAC9C9170FD6CBE14C8AD6B6", hash_generated_method = "6576FCD9D2BBBC1D056FCF251290FC94")
        @Override
        public SortedSet<E> tailSet(E after) {
            SortedSet<E> varB4EAC82CA7396A68D541C85D26508E83_233722878 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_233722878 = new UnmodifiableSortedSet<E>(ss.tailSet(after));
            addTaint(after.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_233722878.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_233722878;
            // ---------- Original Method ----------
            //return new UnmodifiableSortedSet<E>(ss.tailSet(after));
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.450 -0400", hash_original_field = "A7FEB93E06211B53C8063E2CA4FFCCC4", hash_generated_field = "565F0337FD6DDD6623C897F298E2D4CE")

        private static long serialVersionUID = -4929149591599911165L;
    }


    
    private static class SetFromMap<E> extends AbstractSet<E> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.451 -0400", hash_original_field = "6F8F57715090DA2632453988D9A1501B", hash_generated_field = "8D1145F106DE5C3E2B790E661BC27C3B")

        private Map<E, Boolean> m;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.451 -0400", hash_original_field = "10AA84685E8BF74D8FA1DED104C25521", hash_generated_field = "75D49D8B030B2438C97CCFE06F0E4EF6")

        private transient Set<E> backingSet;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.452 -0400", hash_original_method = "6B962D990E5B5543C1AA025E18134CE9", hash_generated_method = "68252A5316CF37F1B8C0AF671D9233B5")
          SetFromMap(final Map<E, Boolean> map) {
            m = map;
            backingSet = map.keySet();
            // ---------- Original Method ----------
            //m = map;
            //backingSet = map.keySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.452 -0400", hash_original_method = "B42E9CA75A778919E90B77D794DBEE82", hash_generated_method = "B149AD856389125C4EA1A1BACFEFA753")
        @Override
        public boolean equals(Object object) {
            boolean var1848766D38374CAEDBF00C0007CDCFC1_208009872 = (backingSet.equals(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_316470710 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_316470710;
            // ---------- Original Method ----------
            //return backingSet.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.452 -0400", hash_original_method = "684F9CE738B21B1B45F3304124963EF1", hash_generated_method = "5B65AA3697F91FA642A65416E1F5E637")
        @Override
        public int hashCode() {
            int var061E95C5D32F56D095B7A80E91EC8A56_387789262 = (backingSet.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_246437262 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_246437262;
            // ---------- Original Method ----------
            //return backingSet.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.452 -0400", hash_original_method = "FC84A6CABB16433CF1488E03DF7636C8", hash_generated_method = "AF0690F554DC7C9A3C1F2E3FE59B48D0")
        @Override
        public boolean add(E object) {
            boolean var8AF8A0D0EB560BBD1728F96A00026012_988526203 = (m.put(object, Boolean.TRUE) == null);
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1036113393 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1036113393;
            // ---------- Original Method ----------
            //return m.put(object, Boolean.TRUE) == null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.452 -0400", hash_original_method = "5163CA2ED3AD9C66F2BDAFB902590115", hash_generated_method = "5C1448B76AB003BA7ABB7E55C1011B37")
        @Override
        public void clear() {
            m.clear();
            // ---------- Original Method ----------
            //m.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.453 -0400", hash_original_method = "C7069F73CC2FBE59B42FACF6A3731192", hash_generated_method = "CA1FC74D30EFB5A4D831E3EF6C85667C")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1659835486 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1659835486 = backingSet.toString();
            varB4EAC82CA7396A68D541C85D26508E83_1659835486.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1659835486;
            // ---------- Original Method ----------
            //return backingSet.toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.454 -0400", hash_original_method = "C1FDFEBBA860B6E21729D041F83BDE39", hash_generated_method = "794860D5B5F09FA2E2E42E9050EF576B")
        @Override
        public boolean contains(Object object) {
            boolean varD69ECD74FC2F79EA60C338071C7FC221_5236660 = (backingSet.contains(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1673083360 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1673083360;
            // ---------- Original Method ----------
            //return backingSet.contains(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.454 -0400", hash_original_method = "652D3A93342A70291E00DB196A629050", hash_generated_method = "57F2B739056DF18B3CD4191B8876ED45")
        @Override
        public boolean containsAll(Collection<?> collection) {
            boolean var3951AEBB2FFEF521655479A9D2D52542_1364462252 = (backingSet.containsAll(collection));
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2029819056 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2029819056;
            // ---------- Original Method ----------
            //return backingSet.containsAll(collection);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.455 -0400", hash_original_method = "B9E63D3C52241E7E917CB1416ABA36E5", hash_generated_method = "9C594923B3138010A32AF4A35EB4279D")
        @Override
        public boolean isEmpty() {
            boolean var028CF644E61B84328EAB66D556672A81_1529517776 = (m.isEmpty());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1323441707 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1323441707;
            // ---------- Original Method ----------
            //return m.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.455 -0400", hash_original_method = "20C696E59013C16BDFED7021A5C3E797", hash_generated_method = "62ED7F17682D7A997ADB1474CE8F9DDF")
        @Override
        public boolean remove(Object object) {
            boolean varEA834B1BBE47D90EDF860853CDE90683_1029273376 = (m.remove(object) != null);
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1180652641 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1180652641;
            // ---------- Original Method ----------
            //return m.remove(object) != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.469 -0400", hash_original_method = "4A27ACEA2C9F194EF4597E8BDECC6BD7", hash_generated_method = "AFD69DC2FF52D028C6252173DBD48EC3")
        @Override
        public boolean retainAll(Collection<?> collection) {
            boolean varF15C5540B964CC478105DE5ACC25B10C_516952103 = (backingSet.retainAll(collection));
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1351904505 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1351904505;
            // ---------- Original Method ----------
            //return backingSet.retainAll(collection);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.470 -0400", hash_original_method = "706FD57EC242D189F78C8F40D764E8D0", hash_generated_method = "0A4B546847587B4E0CD5053A32DC5484")
        @Override
        public Object[] toArray() {
            Object[] varB4EAC82CA7396A68D541C85D26508E83_1243416415 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1243416415 = backingSet.toArray();
            varB4EAC82CA7396A68D541C85D26508E83_1243416415.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1243416415;
            // ---------- Original Method ----------
            //return backingSet.toArray();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.471 -0400", hash_original_method = "5B684176C593DE73F99AF08724DF65D4", hash_generated_method = "726A484117974BF955915ABE16C70D18")
        @Override
        public <T> T[] toArray(T[] contents) {
            T[] varB4EAC82CA7396A68D541C85D26508E83_786207261 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_786207261 = backingSet.toArray(contents);
            addTaint(contents[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_786207261.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_786207261;
            // ---------- Original Method ----------
            //return backingSet.toArray(contents);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.475 -0400", hash_original_method = "2EC39271104239DED882FB25EFF4BC23", hash_generated_method = "A2986E3F7757E3A5983839492D262F18")
        @Override
        public Iterator<E> iterator() {
            Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_1715735981 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1715735981 = backingSet.iterator();
            varB4EAC82CA7396A68D541C85D26508E83_1715735981.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1715735981;
            // ---------- Original Method ----------
            //return backingSet.iterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.476 -0400", hash_original_method = "A04EE09DEB6F21FAA6A7E10DF6401CD1", hash_generated_method = "AE40D8A415E0E18166CB4304FE19D7CC")
        @Override
        public int size() {
            int varDBD6E28F15F3D13B8127CF62DD69ACD5_47702709 = (m.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1524135214 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1524135214;
            // ---------- Original Method ----------
            //return m.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.477 -0400", hash_original_method = "8082AE1FFA2825B9433C3082C2F87EDC", hash_generated_method = "22988C980D2DF3F54BA0C1ADFC122910")
        @SuppressWarnings("unchecked")
        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
            stream.defaultReadObject();
            backingSet = m.keySet();
            addTaint(stream.getTaint());
            // ---------- Original Method ----------
            //stream.defaultReadObject();
            //backingSet = m.keySet();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.477 -0400", hash_original_field = "68A2EE38D4624ED7EDE7470F4422D17A", hash_generated_field = "FD9A9003D1EC445F04D9A6B4A103D2D2")

        private static long serialVersionUID = 2454657854757543876L;
    }


    
    private static class AsLIFOQueue<E> extends AbstractQueue<E> implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.477 -0400", hash_original_field = "7694F4A66316E53C8CDD9D9954BD611D", hash_generated_field = "8E692B16EB19650DAECD0B8A91F62E63")

        private Deque<E> q;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.477 -0400", hash_original_method = "C9A3AEFCC3A9FEA0CFED796FADB14DA4", hash_generated_method = "8C725C5253844AF6C1706232C12CC260")
          AsLIFOQueue(final Deque<E> deque) {
            this.q = deque;
            // ---------- Original Method ----------
            //this.q = deque;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.492 -0400", hash_original_method = "D6ABAC5AC9E31C28EFD449012F8C668D", hash_generated_method = "2FC9A43AE97C3EA70F21F5C07A3ED4A5")
        @Override
        public Iterator<E> iterator() {
            Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_658659209 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_658659209 = q.iterator();
            varB4EAC82CA7396A68D541C85D26508E83_658659209.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_658659209;
            // ---------- Original Method ----------
            //return q.iterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.492 -0400", hash_original_method = "4D120CFD44D3EE91A03411EED1F5CA02", hash_generated_method = "85E278C33766B10884EDD2AD9E323C0F")
        @Override
        public int size() {
            int var8E6A4AAEA94D20962C54C20127D7D8DC_1161763702 = (q.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_263570536 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_263570536;
            // ---------- Original Method ----------
            //return q.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.492 -0400", hash_original_method = "A29AB2808D45581589F8B0269F283532", hash_generated_method = "17D7A93BD7198F9FD6D3B9F6A43F5876")
        @Override
        public boolean offer(E o) {
            boolean var131D1A648D23B0B634478E3172B0A3D9_150853286 = (q.offerFirst(o));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_695421074 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_695421074;
            // ---------- Original Method ----------
            //return q.offerFirst(o);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.493 -0400", hash_original_method = "286FFABBC697C1CEE6C49194F85DD481", hash_generated_method = "5331781B8E6C85A5A2DF746E78DFFED0")
        @Override
        public E peek() {
            E varB4EAC82CA7396A68D541C85D26508E83_2086750586 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2086750586 = q.peekFirst();
            varB4EAC82CA7396A68D541C85D26508E83_2086750586.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2086750586;
            // ---------- Original Method ----------
            //return q.peekFirst();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.493 -0400", hash_original_method = "93EF986205EA0EFDB6E2F2BDD9DDBDB0", hash_generated_method = "C7D936114AB317274D4E5803C2866BCC")
        @Override
        public E poll() {
            E varB4EAC82CA7396A68D541C85D26508E83_1129565928 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1129565928 = q.pollFirst();
            varB4EAC82CA7396A68D541C85D26508E83_1129565928.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1129565928;
            // ---------- Original Method ----------
            //return q.pollFirst();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.494 -0400", hash_original_method = "E16BCF0F708E6336497510D255228AB4", hash_generated_method = "4152114CEC1BEF3F94B10E5C4DBFC964")
        @Override
        public boolean add(E o) {
            q.push(o);
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_560826285 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_560826285;
            // ---------- Original Method ----------
            //q.push(o);
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.494 -0400", hash_original_method = "ECF3C7555AB121202E1C39938D734656", hash_generated_method = "72AFA896F4EE9665FC95334E69A68411")
        @Override
        public void clear() {
            q.clear();
            // ---------- Original Method ----------
            //q.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.494 -0400", hash_original_method = "41C0874A8589B77FE1309E3303509F6A", hash_generated_method = "253F33851E7335D0A3676AC0A826DCF6")
        @Override
        public E element() {
            E varB4EAC82CA7396A68D541C85D26508E83_711347539 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_711347539 = q.getFirst();
            varB4EAC82CA7396A68D541C85D26508E83_711347539.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_711347539;
            // ---------- Original Method ----------
            //return q.getFirst();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.499 -0400", hash_original_method = "DBCAD9866D0C084DC455BF7C95ABCE77", hash_generated_method = "3F418610DDDF667BFDED456025E1AD85")
        @Override
        public E remove() {
            E varB4EAC82CA7396A68D541C85D26508E83_458051150 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_458051150 = q.pop();
            varB4EAC82CA7396A68D541C85D26508E83_458051150.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_458051150;
            // ---------- Original Method ----------
            //return q.pop();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.499 -0400", hash_original_method = "2E730D7ABEE184A9C34DA57DF7A457EE", hash_generated_method = "E1AB90C1D3CF59E2AC4E5FD96B54B81C")
        @Override
        public boolean contains(Object object) {
            boolean varD460130636362755C09A666172F1A628_833400137 = (q.contains(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_26653455 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_26653455;
            // ---------- Original Method ----------
            //return q.contains(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.511 -0400", hash_original_method = "3E9E9A2983E74090844621EE9CF6D3D7", hash_generated_method = "01661F1CECAD8E3F0C1B5F3B9485B10D")
        @Override
        public boolean containsAll(Collection<?> collection) {
            boolean varDE8FC932F21B2025BA6D50595BD45CF0_1637481658 = (q.containsAll(collection));
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1593362460 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1593362460;
            // ---------- Original Method ----------
            //return q.containsAll(collection);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.512 -0400", hash_original_method = "3014069A2B40728BACBB472823CCCF21", hash_generated_method = "0E0E1F11D589DCC5E937D32D6F7720A5")
        @Override
        public boolean isEmpty() {
            boolean varFE3524B5D20384639CE6FC4B24FAEE92_733583542 = (q.isEmpty());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_37266034 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_37266034;
            // ---------- Original Method ----------
            //return q.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.513 -0400", hash_original_method = "06C06D3351623BFF7BABDE8B40334F59", hash_generated_method = "4FAB0BCD0098CCDFE96EAE57B4FA8F3C")
        @Override
        public boolean remove(Object object) {
            boolean var430DB2157F91E84964C83805E66926D1_341618895 = (q.remove(object));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_385890447 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_385890447;
            // ---------- Original Method ----------
            //return q.remove(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.513 -0400", hash_original_method = "13975D6542267AD488C8D9B27A0905D7", hash_generated_method = "6448717AD5296EFC32297BAE94C80076")
        @Override
        public boolean removeAll(Collection<?> collection) {
            boolean varA36A955574116D3C6092CC37D2496B72_1382139169 = (q.removeAll(collection));
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_49905689 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_49905689;
            // ---------- Original Method ----------
            //return q.removeAll(collection);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.521 -0400", hash_original_method = "029F8EE40CDE382EFA7F7BF13B8FE731", hash_generated_method = "D80E1756E641837A4BF97DEC5F6B9C84")
        @Override
        public boolean retainAll(Collection<?> collection) {
            boolean varF8C783496DD8D05EB5484CABE3DF69DA_1732365560 = (q.retainAll(collection));
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1918491441 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1918491441;
            // ---------- Original Method ----------
            //return q.retainAll(collection);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.525 -0400", hash_original_method = "81809EBBF1D8298961C4E9B761FEF748", hash_generated_method = "3BF574AAF8280C2757C73D0B9B2C63C7")
        @Override
        public Object[] toArray() {
            Object[] varB4EAC82CA7396A68D541C85D26508E83_843037415 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_843037415 = q.toArray();
            varB4EAC82CA7396A68D541C85D26508E83_843037415.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_843037415;
            // ---------- Original Method ----------
            //return q.toArray();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.526 -0400", hash_original_method = "3C7918E789D95B2A97E0F45A2E8277E0", hash_generated_method = "12FD8D585C7763606637FD2BAAB41445")
        @Override
        public <T> T[] toArray(T[] contents) {
            T[] varB4EAC82CA7396A68D541C85D26508E83_1564083383 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1564083383 = q.toArray(contents);
            addTaint(contents[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1564083383.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1564083383;
            // ---------- Original Method ----------
            //return q.toArray(contents);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.530 -0400", hash_original_method = "827F98847BB1D6CEA3B0A324A45F92ED", hash_generated_method = "44F5AFC18FA6AB1730B2DE59F1D49A1E")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_916489142 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_916489142 = q.toString();
            varB4EAC82CA7396A68D541C85D26508E83_916489142.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_916489142;
            // ---------- Original Method ----------
            //return q.toString();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.530 -0400", hash_original_field = "7C5B063F84AD7FF4280E3FC6C2D641FE", hash_generated_field = "A7C90C9954FF9FB934BEFD4B3F84C9C7")

        private static long serialVersionUID = 1802017725587941708L;
    }


    
    private static class CheckedCollection<E> implements Collection<E>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.531 -0400", hash_original_field = "4A8A08F09D37B73795649038408B5F33", hash_generated_field = "A3C80A7E02E49F20400373DFBAF9696A")

        Collection<E> c;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.534 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "D40602D541C2081B4D03EEADC8718DAD")

        Class<E> type;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.536 -0400", hash_original_method = "4DAA5B7D63536360D367B6279A6FD0F0", hash_generated_method = "7A376838DD673D1FBA51D92C8AABBFD1")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.536 -0400", hash_original_method = "AC97C28F724592ABA809E2470D95C119", hash_generated_method = "2176F5192566113DC20193347705B6E0")
        @Override
        public int size() {
            int varC247C84593AA6020ED979B19566D13FE_1871567092 = (c.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_527531778 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_527531778;
            // ---------- Original Method ----------
            //return c.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.536 -0400", hash_original_method = "F9A3CB1FB7570D28EBE20660E2FC6F42", hash_generated_method = "65384E4CD76FCBD04B622D3EAF775106")
        @Override
        public boolean isEmpty() {
            boolean var528EAD02A70F822F393BB0C54FBB923C_841232286 = (c.isEmpty());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_221515909 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_221515909;
            // ---------- Original Method ----------
            //return c.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.540 -0400", hash_original_method = "AA502F510015E56A50E854673F52B13D", hash_generated_method = "18F16E27FE03C2B226559BFABDD776E2")
        @Override
        public boolean contains(Object obj) {
            boolean var9701AC7B8B31DABE176EC8837E090033_1941094233 = (c.contains(obj));
            addTaint(obj.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_804743524 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_804743524;
            // ---------- Original Method ----------
            //return c.contains(obj);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.545 -0400", hash_original_method = "A49A579D720F57F247BFFB420B912FC7", hash_generated_method = "D8854666DB33C756C4B7522658FB5C74")
        @Override
        public Iterator<E> iterator() {
            Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_1972087780 = null; //Variable for return #1
            Iterator<E> i;
            i = c.iterator();
            {
                i = new CheckedListIterator<E>((ListIterator<E>) i, type);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1972087780 = i;
            varB4EAC82CA7396A68D541C85D26508E83_1972087780.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1972087780;
            // ---------- Original Method ----------
            //Iterator<E> i = c.iterator();
            //if (i instanceof ListIterator) {
                //i = new CheckedListIterator<E>((ListIterator<E>) i, type);
            //}
            //return i;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.550 -0400", hash_original_method = "89D7D02A9D2BDF31E775C08108CBDE5B", hash_generated_method = "7CCA9CA293DF1FD84465EC7CEECC563F")
        @Override
        public Object[] toArray() {
            Object[] varB4EAC82CA7396A68D541C85D26508E83_1260280805 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1260280805 = c.toArray();
            varB4EAC82CA7396A68D541C85D26508E83_1260280805.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1260280805;
            // ---------- Original Method ----------
            //return c.toArray();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.551 -0400", hash_original_method = "9B8166862C116AE305DE64E80811892F", hash_generated_method = "21863FAD3C9EA7F2D18BF1B5E87133ED")
        @Override
        public <T> T[] toArray(T[] arr) {
            T[] varB4EAC82CA7396A68D541C85D26508E83_934356490 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_934356490 = c.toArray(arr);
            addTaint(arr[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_934356490.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_934356490;
            // ---------- Original Method ----------
            //return c.toArray(arr);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.551 -0400", hash_original_method = "233202E3883C87159328A7DF45C5A0DD", hash_generated_method = "EE0754850B4354A9CB8159F2180F226D")
        @Override
        public boolean add(E obj) {
            boolean var7C3742253C6BF2735A6EB74A5190709F_656153418 = (c.add(checkType(obj, type)));
            addTaint(obj.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1802714426 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1802714426;
            // ---------- Original Method ----------
            //return c.add(checkType(obj, type));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.551 -0400", hash_original_method = "A7C1CDA142B015DD1AAB47325584260A", hash_generated_method = "CC580B07A5569A255B4DFC91D74310DF")
        @Override
        public boolean remove(Object obj) {
            boolean varA24294D934B215AF55F3D7CE5097D547_880959244 = (c.remove(obj));
            addTaint(obj.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_573834539 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_573834539;
            // ---------- Original Method ----------
            //return c.remove(obj);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.556 -0400", hash_original_method = "8A54483E259CA6D3C8AB1EBE7493D296", hash_generated_method = "1D6A8A53B870EFF935C04DB116C8DCF3")
        @Override
        public boolean containsAll(Collection<?> c1) {
            boolean varFFF4D0CC6EA0E1A2D080D41D81BC6C1F_1414018011 = (c.containsAll(c1));
            addTaint(c1.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1564110911 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1564110911;
            // ---------- Original Method ----------
            //return c.containsAll(c1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.616 -0400", hash_original_method = "A2391F235E9474A0C2FADB6F2C5C2AB0", hash_generated_method = "3631973F7EF1D9924D7BB9C4144C0DF8")
        @SuppressWarnings("unchecked")
        @Override
        public boolean addAll(Collection<? extends E> c1) {
            Object[] array;
            array = c1.toArray();
            {
                Object o = array[0];
                {
                    checkType(o, type);
                } //End block
            } //End collapsed parenthetic
            boolean var4F43D86A78906FAA31F77A4D0C40B6E3_2027073583 = (c.addAll((List<E>) Arrays.asList(array)));
            addTaint(c1.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1090221028 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1090221028;
            // ---------- Original Method ----------
            //Object[] array = c1.toArray();
            //for (Object o : array) {
                //checkType(o, type);
            //}
            //return c.addAll((List<E>) Arrays.asList(array));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.616 -0400", hash_original_method = "E5A4F3F5A50F475A125F07680365C964", hash_generated_method = "7354F1BF3BE9A5B111E96D13F6752051")
        @Override
        public boolean removeAll(Collection<?> c1) {
            boolean var6FAA02017CB91A1460E8557E32B16FBC_395455831 = (c.removeAll(c1));
            addTaint(c1.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1806649325 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1806649325;
            // ---------- Original Method ----------
            //return c.removeAll(c1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.617 -0400", hash_original_method = "2CCBBE73D1665A80965D3FA8CB644A3B", hash_generated_method = "5334D04949FB4EBE231D0D62D8457C5D")
        @Override
        public boolean retainAll(Collection<?> c1) {
            boolean var1BAABDC5B6ADB4CC0AE277B58A4293BA_1478336964 = (c.retainAll(c1));
            addTaint(c1.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_826014346 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_826014346;
            // ---------- Original Method ----------
            //return c.retainAll(c1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.617 -0400", hash_original_method = "C75B179C04D460F62AB7F39D0D292067", hash_generated_method = "A8F69290363AB2D00FEDD4A5A3BF8CF2")
        @Override
        public void clear() {
            c.clear();
            // ---------- Original Method ----------
            //c.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.617 -0400", hash_original_method = "424D4966F358AE6553349A6493C21674", hash_generated_method = "C948FC529F1EBBC45D8E637BC363B279")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_510704698 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_510704698 = c.toString();
            varB4EAC82CA7396A68D541C85D26508E83_510704698.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_510704698;
            // ---------- Original Method ----------
            //return c.toString();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.618 -0400", hash_original_field = "19984F6C6BA7815BBDF7C18EF9C975B4", hash_generated_field = "091117B9F49B1DAD7ABFBC5927C87468")

        private static long serialVersionUID = 1578914078182001775L;
    }


    
    private static class CheckedListIterator<E> implements ListIterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.618 -0400", hash_original_field = "865C0C0B4AB0E063E5CAA3387C1A8741", hash_generated_field = "A3E111A0B732842F8B9E259D3903708E")

        private ListIterator<E> i;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.618 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "44DD73C068DAE541C380477699D61FAF")

        private Class<E> type;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.619 -0400", hash_original_method = "0B7AAA10EE83BBF7A614BF8D8C7A7C84", hash_generated_method = "8BB9DF0BD458C6C58CAD8ED7A978114C")
        public  CheckedListIterator(ListIterator<E> i, Class<E> type) {
            this.i = i;
            this.type = type;
            // ---------- Original Method ----------
            //this.i = i;
            //this.type = type;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.619 -0400", hash_original_method = "59CA86A80410B66286C92523CF35EC7B", hash_generated_method = "1076DAC9A8DE9E82DBC9F4593D8E92ED")
        @Override
        public boolean hasNext() {
            boolean var1611849CD1EE22EA22E4E7E3327E2E35_678366823 = (i.hasNext());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2121593417 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2121593417;
            // ---------- Original Method ----------
            //return i.hasNext();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.703 -0400", hash_original_method = "A2FD0994E634C5BCE4D27AD9176E9A5A", hash_generated_method = "4B4ED2CC9F5C60263A609D720CE907EA")
        @Override
        public E next() {
            E varB4EAC82CA7396A68D541C85D26508E83_1027289690 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1027289690 = i.next();
            varB4EAC82CA7396A68D541C85D26508E83_1027289690.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1027289690;
            // ---------- Original Method ----------
            //return i.next();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.704 -0400", hash_original_method = "048FA6C3E3A28865AD880AF8A3FCAE96", hash_generated_method = "598E37F558FC71BB5A0DA7BBE13EE694")
        @Override
        public void remove() {
            i.remove();
            // ---------- Original Method ----------
            //i.remove();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.704 -0400", hash_original_method = "BBFFF3658F03DC70BAED5B88BBE801F9", hash_generated_method = "CFEB5317DAC003548C57DD1A7E44B08C")
        @Override
        public boolean hasPrevious() {
            boolean var1FCC7ECF60E98FFA6572F3122E374C7E_1083089880 = (i.hasPrevious());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2075670454 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2075670454;
            // ---------- Original Method ----------
            //return i.hasPrevious();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.705 -0400", hash_original_method = "BC73D9B40C1A828CB3DD11A00CF4E28D", hash_generated_method = "DBA28B3A691CC16C7EFA54F4A6488E6C")
        @Override
        public E previous() {
            E varB4EAC82CA7396A68D541C85D26508E83_124692757 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_124692757 = i.previous();
            varB4EAC82CA7396A68D541C85D26508E83_124692757.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_124692757;
            // ---------- Original Method ----------
            //return i.previous();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.705 -0400", hash_original_method = "E41D02CE1A7D09C2351DC91043CD0C1F", hash_generated_method = "E681519054DE45829409D6622509CC7B")
        @Override
        public int nextIndex() {
            int var97CCB58C3C2141B73F996BC540E6EAF5_192281509 = (i.nextIndex());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1242403778 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1242403778;
            // ---------- Original Method ----------
            //return i.nextIndex();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.705 -0400", hash_original_method = "F0908B37AEEE31348E4E446BDB2DC11E", hash_generated_method = "98113E7557C17E1D2C446DC7B68EDA51")
        @Override
        public int previousIndex() {
            int var9F734927211780D2EA84E984ED22702D_1763796485 = (i.previousIndex());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_902582162 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_902582162;
            // ---------- Original Method ----------
            //return i.previousIndex();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.706 -0400", hash_original_method = "F06067E5C50A33BA33028ACBB7E94E5C", hash_generated_method = "8CAFD41758A91E7AEC87DE235FEEAD5B")
        @Override
        public void set(E obj) {
            i.set(checkType(obj, type));
            addTaint(obj.getTaint());
            // ---------- Original Method ----------
            //i.set(checkType(obj, type));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.706 -0400", hash_original_method = "3A7C6206CDBE5C448C8E83D10145E877", hash_generated_method = "CB1ACD56A14B73EB8E1500AEF3BEBC77")
        @Override
        public void add(E obj) {
            i.add(checkType(obj, type));
            addTaint(obj.getTaint());
            // ---------- Original Method ----------
            //i.add(checkType(obj, type));
        }

        
    }


    
    private static class CheckedList<E> extends CheckedCollection<E> implements List<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.706 -0400", hash_original_field = "2DB95E8E1A9267B7A1188556B2013B33", hash_generated_field = "BA44D98E464F3917B2E777BB565BC0D3")

        List<E> l;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.706 -0400", hash_original_method = "50AAAF0EF026911FE0274184FEF9C1C3", hash_generated_method = "5D3DF5FB69105266A81A924324B66768")
        public  CheckedList(List<E> l, Class<E> type) {
            super(l, type);
            this.l = l;
            addTaint(type.getTaint());
            // ---------- Original Method ----------
            //this.l = l;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.757 -0400", hash_original_method = "8A1A291116E92C540879607029C861C6", hash_generated_method = "DB0C7D56FCF381892A1756531E6A23A8")
        @SuppressWarnings("unchecked")
        @Override
        public boolean addAll(int index, Collection<? extends E> c1) {
            Object[] array;
            array = c1.toArray();
            {
                Object o = array[0];
                {
                    checkType(o, type);
                } //End block
            } //End collapsed parenthetic
            boolean var720AF4600E5540369BE417DBAEE92DFA_1989233970 = (l.addAll(index, (List<E>) Arrays.asList(array)));
            addTaint(index);
            addTaint(c1.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_648407269 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_648407269;
            // ---------- Original Method ----------
            //Object[] array = c1.toArray();
            //for (Object o : array) {
                //checkType(o, type);
            //}
            //return l.addAll(index, (List<E>) Arrays.asList(array));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.779 -0400", hash_original_method = "12BB9FAB0B921E0E98205977740A217D", hash_generated_method = "300386CBD43F1436D0AD5617031521B5")
        @Override
        public E get(int index) {
            E varB4EAC82CA7396A68D541C85D26508E83_2094894605 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2094894605 = l.get(index);
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_2094894605.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2094894605;
            // ---------- Original Method ----------
            //return l.get(index);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.779 -0400", hash_original_method = "B15A1B3ABEAB19644273A7FDAFDFF4C3", hash_generated_method = "11F9147AD83505E1A959F59500CF2047")
        @Override
        public E set(int index, E obj) {
            E varB4EAC82CA7396A68D541C85D26508E83_481446644 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_481446644 = l.set(index, checkType(obj, type));
            addTaint(index);
            addTaint(obj.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_481446644.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_481446644;
            // ---------- Original Method ----------
            //return l.set(index, checkType(obj, type));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.780 -0400", hash_original_method = "97AC3A6F1A8F1F91D88637C439308CAA", hash_generated_method = "52B4CEA0E1571112BDBE5428D02E17E5")
        @Override
        public void add(int index, E obj) {
            l.add(index, checkType(obj, type));
            addTaint(index);
            addTaint(obj.getTaint());
            // ---------- Original Method ----------
            //l.add(index, checkType(obj, type));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.780 -0400", hash_original_method = "B7A754E9641B79EF3AC643C6FA162631", hash_generated_method = "62BD3A40DC0E30880F5D28B0C27B3A31")
        @Override
        public E remove(int index) {
            E varB4EAC82CA7396A68D541C85D26508E83_2080850963 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2080850963 = l.remove(index);
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_2080850963.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2080850963;
            // ---------- Original Method ----------
            //return l.remove(index);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.780 -0400", hash_original_method = "EB95E25E6439350950712FBE2C177EC4", hash_generated_method = "852F76EC999169466551B4F135EC2D7E")
        @Override
        public int indexOf(Object obj) {
            int varBB0CC98524B808CD822A2164B51F33B8_339925762 = (l.indexOf(obj));
            addTaint(obj.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_319214765 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_319214765;
            // ---------- Original Method ----------
            //return l.indexOf(obj);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.781 -0400", hash_original_method = "4C828EC3A9818E335BF8E9F8513B24F5", hash_generated_method = "B885477A0CDF5EB383954816B4FD9C63")
        @Override
        public int lastIndexOf(Object obj) {
            int var68D523AC731688651041C374F25CAB09_1337718725 = (l.lastIndexOf(obj));
            addTaint(obj.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1995800734 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1995800734;
            // ---------- Original Method ----------
            //return l.lastIndexOf(obj);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.781 -0400", hash_original_method = "9293980ECFF31B033CDADFB0ED26EA69", hash_generated_method = "341C71FA07893CDAC9AE4CA5123BA294")
        @Override
        public ListIterator<E> listIterator() {
            ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_2072523503 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2072523503 = new CheckedListIterator<E>(l.listIterator(), type);
            varB4EAC82CA7396A68D541C85D26508E83_2072523503.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2072523503;
            // ---------- Original Method ----------
            //return new CheckedListIterator<E>(l.listIterator(), type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.782 -0400", hash_original_method = "31D39D7FEEE82D7A15D00B805CB5EAA4", hash_generated_method = "A8107D9C8C85CE9EE823B0A19F0A9D53")
        @Override
        public ListIterator<E> listIterator(int index) {
            ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_1520869877 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1520869877 = new CheckedListIterator<E>(l.listIterator(index), type);
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_1520869877.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1520869877;
            // ---------- Original Method ----------
            //return new CheckedListIterator<E>(l.listIterator(index), type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.793 -0400", hash_original_method = "A5E1EFD4B2650099AC132BF86B97D88F", hash_generated_method = "AE31961A7C481563387F8618D24F2B13")
        @Override
        public List<E> subList(int fromIndex, int toIndex) {
            List<E> varB4EAC82CA7396A68D541C85D26508E83_1689013171 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1689013171 = checkedList(l.subList(fromIndex, toIndex), type);
            addTaint(fromIndex);
            addTaint(toIndex);
            varB4EAC82CA7396A68D541C85D26508E83_1689013171.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1689013171;
            // ---------- Original Method ----------
            //return checkedList(l.subList(fromIndex, toIndex), type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.793 -0400", hash_original_method = "A14AE2E014BAD465F594EE49A5008ED4", hash_generated_method = "5A93CCC265ECA7382CD74F8702A810EF")
        @Override
        public boolean equals(Object obj) {
            boolean var559B3B39BC42D814993568E544C6FE1F_1601248508 = (l.equals(obj));
            addTaint(obj.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_521481515 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_521481515;
            // ---------- Original Method ----------
            //return l.equals(obj);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.793 -0400", hash_original_method = "410D1D1B2E05F678DF3AB7D6BB08AEDB", hash_generated_method = "E366FFA649E16969A47EEE099AF4E230")
        @Override
        public int hashCode() {
            int var283F03AD18DE255D000FAC9E62BDE6F0_1005134657 = (l.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_529252228 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_529252228;
            // ---------- Original Method ----------
            //return l.hashCode();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.793 -0400", hash_original_field = "39F320D681E769EFF91E942BCC4C3E88", hash_generated_field = "D55A034AEBEAC16894A59690D71E1080")

        private static long serialVersionUID = 65247728283967356L;
    }


    
    private static class CheckedRandomAccessList<E> extends CheckedList<E> implements RandomAccess {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.794 -0400", hash_original_method = "77F175BCE2CEB5DECA5010A8855616A0", hash_generated_method = "6A34077878FEA1687712F87D427AF583")
        public  CheckedRandomAccessList(List<E> l, Class<E> type) {
            super(l, type);
            addTaint(l.getTaint());
            addTaint(type.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.794 -0400", hash_original_field = "27B375DBE9246C47DAC482882EF8DD4B", hash_generated_field = "7DB34F51EB5AF413DD89FC53AA2997EE")

        private static long serialVersionUID = 1638200125423088369L;
    }


    
    private static class CheckedSet<E> extends CheckedCollection<E> implements Set<E> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.794 -0400", hash_original_method = "515963C9B1280D5707D3A720329B0AC0", hash_generated_method = "34498A77713E1963E42E5270114D0C84")
        public  CheckedSet(Set<E> s, Class<E> type) {
            super(s, type);
            addTaint(s.getTaint());
            addTaint(type.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.794 -0400", hash_original_method = "F33AC6E694EC5A5F3A81FF749707DDFC", hash_generated_method = "646FECB5215CD2C4DA1ACEBEE513B78C")
        @Override
        public boolean equals(Object obj) {
            boolean varC91792C7DD4F0C8E92E42617036EED48_438777611 = (c.equals(obj));
            addTaint(obj.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1356744751 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1356744751;
            // ---------- Original Method ----------
            //return c.equals(obj);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.811 -0400", hash_original_method = "E858D80F3EEDE9F2B52CDB7DA7FBF12B", hash_generated_method = "0A3DD9ACE3530432DD1B429C06A6B58B")
        @Override
        public int hashCode() {
            int var19B3D08FE3840D0D3E365DF71EF3E20C_1319734949 = (c.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1903640604 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1903640604;
            // ---------- Original Method ----------
            //return c.hashCode();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.811 -0400", hash_original_field = "C306DCFF324211BB06F1EDC3B62DB01C", hash_generated_field = "E62252938195E14E1B45045DEF3D887B")

        private static long serialVersionUID = 4694047833775013803L;
    }


    
    private static class CheckedMap<K, V> implements Map<K, V>, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.811 -0400", hash_original_field = "6F8F57715090DA2632453988D9A1501B", hash_generated_field = "B770F05C5A3A992B6F65D731F667A79E")

        Map<K, V> m;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.811 -0400", hash_original_field = "056E0360B75D77ECE0AE955FE59BF15D", hash_generated_field = "F010784A251FB129AC47F47773283FBF")

        Class<K> keyType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.811 -0400", hash_original_field = "B96763B95160CC0943BE0DE4743A115B", hash_generated_field = "DE39CA4821E18DB5E7A7F09BBC028CB4")

        Class<V> valueType;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.811 -0400", hash_original_method = "906A4960963B0F972E50BE617CA562B3", hash_generated_method = "8450A17B2A66D687691112D6942B9B1A")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.812 -0400", hash_original_method = "A04EE09DEB6F21FAA6A7E10DF6401CD1", hash_generated_method = "12A8D796FE2D89F6060670CDCE65488C")
        @Override
        public int size() {
            int varDBD6E28F15F3D13B8127CF62DD69ACD5_892525050 = (m.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_733222434 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_733222434;
            // ---------- Original Method ----------
            //return m.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.812 -0400", hash_original_method = "B9E63D3C52241E7E917CB1416ABA36E5", hash_generated_method = "B255587D3C7AEC17F53DA7FC3413E4EF")
        @Override
        public boolean isEmpty() {
            boolean var028CF644E61B84328EAB66D556672A81_1788439389 = (m.isEmpty());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1565047448 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1565047448;
            // ---------- Original Method ----------
            //return m.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.812 -0400", hash_original_method = "A6C730848D8A626F99D8229EE744E3C0", hash_generated_method = "E2D85CC01C443214DB1397B35997DCEA")
        @Override
        public boolean containsKey(Object key) {
            boolean var2519B7EF565FEC21B6285F5E44AC148E_2043579002 = (m.containsKey(key));
            addTaint(key.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1734468496 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1734468496;
            // ---------- Original Method ----------
            //return m.containsKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.813 -0400", hash_original_method = "EF8C00CF950E8C186D2F05E1E556F384", hash_generated_method = "EFF374EE92BE2028BE833C055A481F83")
        @Override
        public boolean containsValue(Object value) {
            boolean varF8CB74E2C5E0734947B397D82173BDD4_1337916150 = (m.containsValue(value));
            addTaint(value.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1182687718 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1182687718;
            // ---------- Original Method ----------
            //return m.containsValue(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.817 -0400", hash_original_method = "B8FE254B61C57EC3A6DCE539976DA268", hash_generated_method = "95BAD23D735F668A55F893F1CEEE110F")
        @Override
        public V get(Object key) {
            V varB4EAC82CA7396A68D541C85D26508E83_985119014 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_985119014 = m.get(key);
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_985119014.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_985119014;
            // ---------- Original Method ----------
            //return m.get(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.817 -0400", hash_original_method = "98010DFF1DD51631676FCAC604C1B694", hash_generated_method = "50869A80EF78FA0F4755C0A5B74CB0F9")
        @Override
        public V put(K key, V value) {
            V varB4EAC82CA7396A68D541C85D26508E83_1873109525 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1873109525 = m.put(checkType(key, keyType), checkType(value, valueType));
            addTaint(key.getTaint());
            addTaint(value.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1873109525.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1873109525;
            // ---------- Original Method ----------
            //return m.put(checkType(key, keyType), checkType(value, valueType));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.817 -0400", hash_original_method = "7E1C4ABAB7F4D30C9FA02B8AC4206202", hash_generated_method = "C506DDE1EB69FE7D7FF5C33A9A1B9EAB")
        @Override
        public V remove(Object key) {
            V varB4EAC82CA7396A68D541C85D26508E83_1344756879 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1344756879 = m.remove(key);
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1344756879.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1344756879;
            // ---------- Original Method ----------
            //return m.remove(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.842 -0400", hash_original_method = "7B09FD67E4091CD76439ADACD213D3A2", hash_generated_method = "DC739BC5EA75A054DFFDEC13A9E9E582")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.842 -0400", hash_original_method = "5163CA2ED3AD9C66F2BDAFB902590115", hash_generated_method = "5C1448B76AB003BA7ABB7E55C1011B37")
        @Override
        public void clear() {
            m.clear();
            // ---------- Original Method ----------
            //m.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.844 -0400", hash_original_method = "BC85ABF91A39D98F3F2ED0838950D9FC", hash_generated_method = "3AA7D6BCF0F9070C4E28BF2AB420FD15")
        @Override
        public Set<K> keySet() {
            Set<K> varB4EAC82CA7396A68D541C85D26508E83_2084272909 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2084272909 = m.keySet();
            varB4EAC82CA7396A68D541C85D26508E83_2084272909.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2084272909;
            // ---------- Original Method ----------
            //return m.keySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.845 -0400", hash_original_method = "F6584059741E2818D171714370ED56BF", hash_generated_method = "8A4B80C84FAE14D714F590702A2D5465")
        @Override
        public Collection<V> values() {
            Collection<V> varB4EAC82CA7396A68D541C85D26508E83_2052897735 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2052897735 = m.values();
            varB4EAC82CA7396A68D541C85D26508E83_2052897735.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2052897735;
            // ---------- Original Method ----------
            //return m.values();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.852 -0400", hash_original_method = "17C87BFAA3247941C0F3FE3FCE6C8B6B", hash_generated_method = "7A8626160509562DB6D224A97B9FF1C5")
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_890728026 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_890728026 = new CheckedEntrySet<K, V>(m.entrySet(), valueType);
            varB4EAC82CA7396A68D541C85D26508E83_890728026.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_890728026;
            // ---------- Original Method ----------
            //return new CheckedEntrySet<K, V>(m.entrySet(), valueType);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.852 -0400", hash_original_method = "5F45CB6F19E1E41DEEA3711399B994B8", hash_generated_method = "CCB79404EEEC5E837828CBA495BB233D")
        @Override
        public boolean equals(Object obj) {
            boolean var6519380B8603327E1D0BBD66320BEF0F_352551088 = (m.equals(obj));
            addTaint(obj.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_622647711 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_622647711;
            // ---------- Original Method ----------
            //return m.equals(obj);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.873 -0400", hash_original_method = "E3229E3389F030DD50B79734943DB788", hash_generated_method = "DB35BF735B000CE54F6DDCCC1DCBCE92")
        @Override
        public int hashCode() {
            int varAA1293165230C9829C1AEACFFF576DFC_1758908164 = (m.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_567921141 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_567921141;
            // ---------- Original Method ----------
            //return m.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.874 -0400", hash_original_method = "5DD44B3CD2826BF39F974F66579CF74F", hash_generated_method = "6C97520388B36DD23A04F287EA4812AE")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_761898623 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_761898623 = m.toString();
            varB4EAC82CA7396A68D541C85D26508E83_761898623.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_761898623;
            // ---------- Original Method ----------
            //return m.toString();
        }

        
        private static class CheckedEntry<K, V> implements Map.Entry<K, V> {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.874 -0400", hash_original_field = "E1671797C52E15F763380B45E841EC32", hash_generated_field = "FD10A3858A638ACB828326F81BE2C88B")

            Map.Entry<K, V> e;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.874 -0400", hash_original_field = "B96763B95160CC0943BE0DE4743A115B", hash_generated_field = "DE39CA4821E18DB5E7A7F09BBC028CB4")

            Class<V> valueType;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.874 -0400", hash_original_method = "7A5E92C112A4AAE1EEB574291E4B57B6", hash_generated_method = "F20992E3708DE849084FDE77877EB9F1")
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.875 -0400", hash_original_method = "10D87C621F2656D3DA7DCE234A4C3FAC", hash_generated_method = "07FEDB034478F52C607318E931555A44")
            @Override
            public K getKey() {
                K varB4EAC82CA7396A68D541C85D26508E83_1196882497 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1196882497 = e.getKey();
                varB4EAC82CA7396A68D541C85D26508E83_1196882497.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1196882497;
                // ---------- Original Method ----------
                //return e.getKey();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.884 -0400", hash_original_method = "8EF21B2292AA31AAE181B3282F3F0262", hash_generated_method = "02D5DD0D995D984DB543BF08729DECC4")
            @Override
            public V getValue() {
                V varB4EAC82CA7396A68D541C85D26508E83_1492954118 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1492954118 = e.getValue();
                varB4EAC82CA7396A68D541C85D26508E83_1492954118.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1492954118;
                // ---------- Original Method ----------
                //return e.getValue();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.885 -0400", hash_original_method = "22C63BC622BE9DF4D2BED624BDB5B6B5", hash_generated_method = "74B945991B462B5D6687E1990849AF1D")
            @Override
            public V setValue(V obj) {
                V varB4EAC82CA7396A68D541C85D26508E83_704932971 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_704932971 = e.setValue(checkType(obj, valueType));
                addTaint(obj.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_704932971.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_704932971;
                // ---------- Original Method ----------
                //return e.setValue(checkType(obj, valueType));
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.886 -0400", hash_original_method = "0FE63D6CB37B8BF21266876509A7EAAA", hash_generated_method = "BDF5BD6ADDCE3F08C657FF0A6C417CE6")
            @Override
            public boolean equals(Object obj) {
                boolean var5F98FA9F6CA964453675BAF27F4B0002_2100071163 = (e.equals(obj));
                addTaint(obj.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_559994019 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_559994019;
                // ---------- Original Method ----------
                //return e.equals(obj);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.886 -0400", hash_original_method = "02C3AF7FB3CFA22B693B83D22D208AF4", hash_generated_method = "3347F9B9E241B9A048EBECC4833D1DD1")
            @Override
            public int hashCode() {
                int varB0D5769FD2A442E362DC4438ABD8230C_2076248054 = (e.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_776792792 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_776792792;
                // ---------- Original Method ----------
                //return e.hashCode();
            }

            
        }


        
        private static class CheckedEntrySet<K, V> implements Set<Map.Entry<K, V>> {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.886 -0400", hash_original_field = "03C7C0ACE395D80182DB07AE2C30F034", hash_generated_field = "00162E30A8FD9ACC3B5664D702737B9D")

            Set<Map.Entry<K, V>> s;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.886 -0400", hash_original_field = "B96763B95160CC0943BE0DE4743A115B", hash_generated_field = "DE39CA4821E18DB5E7A7F09BBC028CB4")

            Class<V> valueType;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.886 -0400", hash_original_method = "77FA7326B6BB5621E7FE63699FC58F08", hash_generated_method = "B92FFB70DAF3A02ECD73F8C030E830C0")
            public  CheckedEntrySet(Set<Map.Entry<K, V>> s, Class<V> valueType) {
                this.s = s;
                this.valueType = valueType;
                // ---------- Original Method ----------
                //this.s = s;
                //this.valueType = valueType;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.887 -0400", hash_original_method = "448F3F9279BA75C161BF1A7F97E105A4", hash_generated_method = "EBAF68B1832A15F7B0851134F392AA62")
            @Override
            public Iterator<Map.Entry<K, V>> iterator() {
                Iterator<Map.Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_556545261 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_556545261 = new CheckedEntryIterator<K, V>(s.iterator(), valueType);
                varB4EAC82CA7396A68D541C85D26508E83_556545261.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_556545261;
                // ---------- Original Method ----------
                //return new CheckedEntryIterator<K, V>(s.iterator(), valueType);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.887 -0400", hash_original_method = "0FB4B292E50A952F877CB518E0A96CF9", hash_generated_method = "D2F63B3078CFC85819F32B3C03CBBB91")
            @Override
            public Object[] toArray() {
                Object[] varB4EAC82CA7396A68D541C85D26508E83_89662479 = null; //Variable for return #1
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
                varB4EAC82CA7396A68D541C85D26508E83_89662479 = array;
                varB4EAC82CA7396A68D541C85D26508E83_89662479.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_89662479;
                // ---------- Original Method ----------
                //int thisSize = size();
                //Object[] array = new Object[thisSize];
                //Iterator<?> it = iterator();
                //for (int i = 0; i < thisSize; i++) {
                    //array[i] = it.next();
                //}
                //return array;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.911 -0400", hash_original_method = "C1CA1F6CAFA571422DF3592838D87C35", hash_generated_method = "75F42FC8E4B402E74D0BE4CD61C246FD")
            @SuppressWarnings("unchecked")
            @Override
            public <T> T[] toArray(T[] array) {
                T[] varB4EAC82CA7396A68D541C85D26508E83_409199280 = null; //Variable for return #1
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
                varB4EAC82CA7396A68D541C85D26508E83_409199280 = array;
                addTaint(array[0].getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_409199280.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_409199280;
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.911 -0400", hash_original_method = "C32F0C36534158E273107417143214BD", hash_generated_method = "D4D3EB1E655B4EB2B71AC67F27E18608")
            @Override
            public boolean retainAll(Collection<?> c) {
                boolean var5CB6111A304F8110F244B25FAFD11216_519705229 = (s.retainAll(c));
                addTaint(c.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_832770701 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_832770701;
                // ---------- Original Method ----------
                //return s.retainAll(c);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.911 -0400", hash_original_method = "B2624C46EA911C8D7CBCD3DB1975A601", hash_generated_method = "E93FA566F40AB20F035DE721AF9842CA")
            @Override
            public boolean removeAll(Collection<?> c) {
                boolean var9FB36AF651B537108EEB0474A946606A_646187508 = (s.removeAll(c));
                addTaint(c.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1954630533 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1954630533;
                // ---------- Original Method ----------
                //return s.removeAll(c);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.912 -0400", hash_original_method = "D8F4D306F45D40205BDE17116DDFF9FA", hash_generated_method = "5159F13293034829EC7FC6ABB05C5179")
            @Override
            public boolean containsAll(Collection<?> c) {
                boolean var13D8B720D63124262C076810AF3BA42D_2125947937 = (s.containsAll(c));
                addTaint(c.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1591490558 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1591490558;
                // ---------- Original Method ----------
                //return s.containsAll(c);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.912 -0400", hash_original_method = "0D1A7F281A8819D32245C163B79E338D", hash_generated_method = "D1DBF333EF1B9EAB330D2E04A32B065B")
            @Override
            public boolean addAll(Collection<? extends Map.Entry<K, V>> c) {
                if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
                addTaint(c.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1319822026 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1319822026;
                // ---------- Original Method ----------
                //throw new UnsupportedOperationException();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.912 -0400", hash_original_method = "46F35AD7CAD80E45E374449F130E7D0D", hash_generated_method = "514F90D998326CE49AA3DAE51B828AEE")
            @Override
            public boolean remove(Object o) {
                boolean varDCAB2EB8C531AB1E623FFAD695CFD286_1191023897 = (s.remove(o));
                addTaint(o.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1133415255 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1133415255;
                // ---------- Original Method ----------
                //return s.remove(o);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.912 -0400", hash_original_method = "A91421BB58ED7F6569B24AAD1B5804AB", hash_generated_method = "BC42FD96B54C105748532B37C5EA36FE")
            @Override
            public boolean contains(Object o) {
                boolean var42C44FAC187AFC4735D76D5B7760F520_1891828629 = (s.contains(o));
                addTaint(o.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2133714072 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2133714072;
                // ---------- Original Method ----------
                //return s.contains(o);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.931 -0400", hash_original_method = "8704A9C8AC3AA02909B00E4E211C4D3E", hash_generated_method = "CF2D419CDD8C9AA65BE0EAEB9C120D90")
            @Override
            public boolean add(Map.Entry<K, V> o) {
                if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
                addTaint(o.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_218473815 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_218473815;
                // ---------- Original Method ----------
                //throw new UnsupportedOperationException();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.932 -0400", hash_original_method = "1DB64DC7E3E98DAB777752CA6247DAE5", hash_generated_method = "D59E39A1627689C67F1366DFCD7B7BAC")
            @Override
            public boolean isEmpty() {
                boolean var33F6A8EED6267D5B4CCD3EAC631C616A_2028287246 = (s.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1372505416 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1372505416;
                // ---------- Original Method ----------
                //return s.isEmpty();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.932 -0400", hash_original_method = "3294D1F2516BD356F42ED84BE178EFCB", hash_generated_method = "8CAFCFFD1A3B734527CE3A6B8BDDA468")
            @Override
            public void clear() {
                s.clear();
                // ---------- Original Method ----------
                //s.clear();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.933 -0400", hash_original_method = "61480F19A13469EF561F92E5A3700C23", hash_generated_method = "DE893C4FF481E14D4E5AC892BE69E453")
            @Override
            public int size() {
                int var8151828880546AEA1C19BE7C52EE5E09_1989920902 = (s.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_452169617 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_452169617;
                // ---------- Original Method ----------
                //return s.size();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.933 -0400", hash_original_method = "150ADDC982A3B6D8A573E663C38A7C9E", hash_generated_method = "CEEAEE7991BD17EEE7B09328D6F51EA1")
            @Override
            public int hashCode() {
                int varE2FC7D6C989F81F3F30CE1BE213D1E3F_1946698084 = (s.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_655301734 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_655301734;
                // ---------- Original Method ----------
                //return s.hashCode();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.933 -0400", hash_original_method = "2565EBD5FCFC00F10C086CB36B3EEE8C", hash_generated_method = "B7615D99D4272A141B6304D8BE507A0B")
            @Override
            public boolean equals(Object object) {
                boolean varB696C6744E5DE06D0B58A4DB8EE26D83_1743916099 = (s.equals(object));
                addTaint(object.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_764108665 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_764108665;
                // ---------- Original Method ----------
                //return s.equals(object);
            }

            
            private static class CheckedEntryIterator<K, V> implements Iterator<Map.Entry<K, V>> {
                @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.933 -0400", hash_original_field = "865C0C0B4AB0E063E5CAA3387C1A8741", hash_generated_field = "0B0E1D6BACD1F756FB2A478A3878B968")

                Iterator<Map.Entry<K, V>> i;
                @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.933 -0400", hash_original_field = "B96763B95160CC0943BE0DE4743A115B", hash_generated_field = "DE39CA4821E18DB5E7A7F09BBC028CB4")

                Class<V> valueType;
                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.947 -0400", hash_original_method = "3CE5E36A95DFE16D33C2CC4176CB7EE4", hash_generated_method = "A4AE63E616DC64A732B8C1B01DFD5833")
                public  CheckedEntryIterator(Iterator<Map.Entry<K, V>> i,
                        Class<V> valueType) {
                    this.i = i;
                    this.valueType = valueType;
                    // ---------- Original Method ----------
                    //this.i = i;
                    //this.valueType = valueType;
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.947 -0400", hash_original_method = "59CA86A80410B66286C92523CF35EC7B", hash_generated_method = "B1F16E3F5A85B92336215AE4244E6DD6")
                @Override
                public boolean hasNext() {
                    boolean var048C390D087BEDAABDA4F669A9DA628E_1627595417 = (i.hasNext());
                    boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_65074637 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_65074637;
                    // ---------- Original Method ----------
                    //return i.hasNext();
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.947 -0400", hash_original_method = "048FA6C3E3A28865AD880AF8A3FCAE96", hash_generated_method = "598E37F558FC71BB5A0DA7BBE13EE694")
                @Override
                public void remove() {
                    i.remove();
                    // ---------- Original Method ----------
                    //i.remove();
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.948 -0400", hash_original_method = "4D16E0BB01C90351B8312D1A4B7DB5F2", hash_generated_method = "A0B4D347917E96295F95C2D5510F90D1")
                @Override
                public Map.Entry<K, V> next() {
                    Map.Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1293523823 = null; //Variable for return #1
                    varB4EAC82CA7396A68D541C85D26508E83_1293523823 = new CheckedEntry<K, V>(i.next(), valueType);
                    varB4EAC82CA7396A68D541C85D26508E83_1293523823.addTaint(getTaint()); //Add taint from parent
                    return varB4EAC82CA7396A68D541C85D26508E83_1293523823;
                    // ---------- Original Method ----------
                    //return new CheckedEntry<K, V>(i.next(), valueType);
                }

                
            }


            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.948 -0400", hash_original_field = "3AB92C151F5D124E5C475918FE5C2CE3", hash_generated_field = "91EDA6639C99882E90144B8B95C0931F")

        private static long serialVersionUID = 5742860141034234728L;
    }


    
    private static class CheckedSortedSet<E> extends CheckedSet<E> implements SortedSet<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.948 -0400", hash_original_field = "3691308F2A4C2F6983F2880D32E29C84", hash_generated_field = "5220A6F2AA4CB98BB6C290F0BB717E86")

        private SortedSet<E> ss;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.948 -0400", hash_original_method = "70499BD9B05065D265D741875DD058CA", hash_generated_method = "4EA08511A3F1AC6F4E1992BAD4189CCA")
        public  CheckedSortedSet(SortedSet<E> s, Class<E> type) {
            super(s, type);
            this.ss = s;
            addTaint(type.getTaint());
            // ---------- Original Method ----------
            //this.ss = s;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.965 -0400", hash_original_method = "8514D9255D678B041F55D03BA11DCA3B", hash_generated_method = "D92D79FC7DDC043668F315521F6F422A")
        @Override
        public Comparator<? super E> comparator() {
            Comparator<? super E> varB4EAC82CA7396A68D541C85D26508E83_632502082 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_632502082 = ss.comparator();
            varB4EAC82CA7396A68D541C85D26508E83_632502082.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_632502082;
            // ---------- Original Method ----------
            //return ss.comparator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.966 -0400", hash_original_method = "82539AB1166DFBB28D0E3DC3D0A43121", hash_generated_method = "F840981F18DBD2665CB13CE26339109A")
        @Override
        public SortedSet<E> subSet(E fromElement, E toElement) {
            SortedSet<E> varB4EAC82CA7396A68D541C85D26508E83_1310600338 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1310600338 = new CheckedSortedSet<E>(ss.subSet(fromElement, toElement),
                    type);
            addTaint(fromElement.getTaint());
            addTaint(toElement.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1310600338.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1310600338;
            // ---------- Original Method ----------
            //return new CheckedSortedSet<E>(ss.subSet(fromElement, toElement),
                    //type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.967 -0400", hash_original_method = "68D546866615C37E07B8E968E3813E84", hash_generated_method = "46ED9E55EBE5FE2CAB612E383D031AF9")
        @Override
        public SortedSet<E> headSet(E toElement) {
            SortedSet<E> varB4EAC82CA7396A68D541C85D26508E83_1067879091 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1067879091 = new CheckedSortedSet<E>(ss.headSet(toElement), type);
            addTaint(toElement.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1067879091.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1067879091;
            // ---------- Original Method ----------
            //return new CheckedSortedSet<E>(ss.headSet(toElement), type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.967 -0400", hash_original_method = "B0B4B667BF95B9D9A3CD3F7FE8BEFA1B", hash_generated_method = "13A37C125BBC2B2BD725DA2926B7B63C")
        @Override
        public SortedSet<E> tailSet(E fromElement) {
            SortedSet<E> varB4EAC82CA7396A68D541C85D26508E83_1888816923 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1888816923 = new CheckedSortedSet<E>(ss.tailSet(fromElement), type);
            addTaint(fromElement.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1888816923.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1888816923;
            // ---------- Original Method ----------
            //return new CheckedSortedSet<E>(ss.tailSet(fromElement), type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.979 -0400", hash_original_method = "6BB6C51843B41CC0DCB5509A79DBA008", hash_generated_method = "FBB8760A4964C662F6168BCF1CA55987")
        @Override
        public E first() {
            E varB4EAC82CA7396A68D541C85D26508E83_955192454 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_955192454 = ss.first();
            varB4EAC82CA7396A68D541C85D26508E83_955192454.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_955192454;
            // ---------- Original Method ----------
            //return ss.first();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.983 -0400", hash_original_method = "AAC5DDE787ACA85752B94AAB77F6B0F8", hash_generated_method = "971B580108C04C4BBF217ED8E49D94CB")
        @Override
        public E last() {
            E varB4EAC82CA7396A68D541C85D26508E83_2037470695 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2037470695 = ss.last();
            varB4EAC82CA7396A68D541C85D26508E83_2037470695.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2037470695;
            // ---------- Original Method ----------
            //return ss.last();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.983 -0400", hash_original_field = "45BA83A718F7437B80255AD942C73A67", hash_generated_field = "69806F6335C60948C846B9BCE4121A49")

        private static long serialVersionUID = 1599911165492914959L;
    }


    
    private static class CheckedSortedMap<K, V> extends CheckedMap<K, V> implements SortedMap<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.983 -0400", hash_original_field = "ED79ACB0CD3D7F8320C53C7798335EF0", hash_generated_field = "41E5EF207399B1082121011C1EB446FF")

        SortedMap<K, V> sm;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.984 -0400", hash_original_method = "2CB6EA0E6447E5AAF8B28B5FDF140BE4", hash_generated_method = "8C004DA654C6552CFBB98F0821546043")
          CheckedSortedMap(SortedMap<K, V> m, Class<K> keyType, Class<V> valueType) {
            super(m, keyType, valueType);
            this.sm = m;
            addTaint(keyType.getTaint());
            addTaint(valueType.getTaint());
            // ---------- Original Method ----------
            //this.sm = m;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.984 -0400", hash_original_method = "E5FDBCC6560BE7E99B2D2F850BD84149", hash_generated_method = "D197B00F5896B0D897DBCEDFBFFE681C")
        @Override
        public Comparator<? super K> comparator() {
            Comparator<? super K> varB4EAC82CA7396A68D541C85D26508E83_1806559613 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1806559613 = sm.comparator();
            varB4EAC82CA7396A68D541C85D26508E83_1806559613.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1806559613;
            // ---------- Original Method ----------
            //return sm.comparator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.985 -0400", hash_original_method = "65DE11E398BB209CD2689071C041161A", hash_generated_method = "4A387A5102B610E00696C5E5691E8C66")
        @Override
        public SortedMap<K, V> subMap(K fromKey, K toKey) {
            SortedMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_1770884887 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1770884887 = new CheckedSortedMap<K, V>(sm.subMap(fromKey, toKey), keyType, valueType);
            addTaint(fromKey.getTaint());
            addTaint(toKey.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1770884887.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1770884887;
            // ---------- Original Method ----------
            //return new CheckedSortedMap<K, V>(sm.subMap(fromKey, toKey), keyType, valueType);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.985 -0400", hash_original_method = "2C5724B582D2FAB5716323DB894A671D", hash_generated_method = "08FAE859964675DCC6439DF267181669")
        @Override
        public SortedMap<K, V> headMap(K toKey) {
            SortedMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_913607184 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_913607184 = new CheckedSortedMap<K, V>(sm.headMap(toKey), keyType, valueType);
            addTaint(toKey.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_913607184.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_913607184;
            // ---------- Original Method ----------
            //return new CheckedSortedMap<K, V>(sm.headMap(toKey), keyType, valueType);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.985 -0400", hash_original_method = "2879524DD09B17D2FCB7AD1626D24618", hash_generated_method = "6A1F3DFBFF8B7258462AA4875A04027F")
        @Override
        public SortedMap<K, V> tailMap(K fromKey) {
            SortedMap<K, V> varB4EAC82CA7396A68D541C85D26508E83_901485209 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_901485209 = new CheckedSortedMap<K, V>(sm.tailMap(fromKey), keyType, valueType);
            addTaint(fromKey.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_901485209.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_901485209;
            // ---------- Original Method ----------
            //return new CheckedSortedMap<K, V>(sm.tailMap(fromKey), keyType, valueType);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.994 -0400", hash_original_method = "B25E8C7440C76FBF812FF7AC9CA9D776", hash_generated_method = "B76F00E48C350B42B3E43B22BB87FE19")
        @Override
        public K firstKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_521205060 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_521205060 = sm.firstKey();
            varB4EAC82CA7396A68D541C85D26508E83_521205060.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_521205060;
            // ---------- Original Method ----------
            //return sm.firstKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.995 -0400", hash_original_method = "00E9126A84DE8B71214859A17DA6BD2E", hash_generated_method = "56F101B20F7A0187A2E7970672ABF496")
        @Override
        public K lastKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_559551399 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_559551399 = sm.lastKey();
            varB4EAC82CA7396A68D541C85D26508E83_559551399.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_559551399;
            // ---------- Original Method ----------
            //return sm.lastKey();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.995 -0400", hash_original_field = "4011ADBAF6264DE3F59FECC188B42ACB", hash_generated_field = "2714F4047A0D5B253E2EB6392246F34B")

        private static long serialVersionUID = 1599671320688067438L;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.009 -0400", hash_original_field = "A240022D45397AD0FD0431DDDFAF666B", hash_generated_field = "6EEE2C6FE34E5F8CAD02526232FB612B")

    private static Iterator<?> EMPTY_ITERATOR = new Iterator<Object>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.996 -0400", hash_original_method = "28E75D14A5D2234D3702D9638A8D3094", hash_generated_method = "8DDB7EC22A80AA14EA7467E4E3A4F74D")
        @Override
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_758133238 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_758133238;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.009 -0400", hash_original_method = "243C3D15209D9BF28572CB29FC9F3DF7", hash_generated_method = "3613EA17897DB540D203CDF04CC84004")
        @Override
        public Object next() {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            // ---------- Original Method ----------
            //throw new NoSuchElementException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.009 -0400", hash_original_method = "45CE80048748F3BC523226127E4746F5", hash_generated_method = "FC031BE6A6E094CAC267938D912798A0")
        @Override
        public void remove() {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            // ---------- Original Method ----------
            //throw new IllegalStateException();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.010 -0400", hash_original_field = "BF19162ABA3425F946F5D9B6685AC2EC", hash_generated_field = "36509578D273556AE1340657362028B4")

    private static Enumeration<?> EMPTY_ENUMERATION = new Enumeration<Object>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.009 -0400", hash_original_method = "50CD0E92886EDA5BEE0164B092B351EC", hash_generated_method = "4444AD824097E6BBD6D50318B15D9069")
        @Override
        public boolean hasMoreElements() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_950453508 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_950453508;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.010 -0400", hash_original_method = "82381D9C34AF9F2E88B673FB4A4E6DDE", hash_generated_method = "C451DB608AE3B7FAE82365C2FA63C59D")
        @Override
        public Object nextElement() {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            // ---------- Original Method ----------
            //throw new NoSuchElementException();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.010 -0400", hash_original_field = "E5D97468931D831222F89B33B06414C4", hash_generated_field = "1967470EF0F42FDB7D6E965615F956D6")

    @SuppressWarnings("unchecked")
    public static final List EMPTY_LIST = new EmptyList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.010 -0400", hash_original_field = "19637326155AD7B58E274FC2717EADC0", hash_generated_field = "EF8031119D3626285E32D155A57C6695")

    @SuppressWarnings("unchecked")
    public static final Set EMPTY_SET = new EmptySet();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.010 -0400", hash_original_field = "712F6D9422DE94FBE0F2A8F69D9E29D0", hash_generated_field = "F465655F33C72E2E2F297BFA1010664E")

    @SuppressWarnings("unchecked")
    public static final Map EMPTY_MAP = new EmptyMap();
}

