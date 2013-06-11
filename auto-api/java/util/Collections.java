package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Array;

public class Collections {
    private static final Iterator<?> EMPTY_ITERATOR = new Iterator<Object>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.796 -0400", hash_original_method = "28E75D14A5D2234D3702D9638A8D3094", hash_generated_method = "C287E2037440BE256524A3C5DE1E4C9C")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean hasNext() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.796 -0400", hash_original_method = "243C3D15209D9BF28572CB29FC9F3DF7", hash_generated_method = "E440A24826AB2B193C731DDED7E04DCA")
        @DSModeled(DSC.SAFE)
        @Override
        public Object next() {
            throw new NoSuchElementException();
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //throw new NoSuchElementException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.796 -0400", hash_original_method = "45CE80048748F3BC523226127E4746F5", hash_generated_method = "9E7C99BD5F1211C594EBBF6C36A6D133")
        @DSModeled(DSC.SAFE)
        @Override
        public void remove() {
            throw new IllegalStateException();
            // ---------- Original Method ----------
            //throw new IllegalStateException();
        }

        
}; //Transformed anonymous class
    private static final Enumeration<?> EMPTY_ENUMERATION = new Enumeration<Object>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.796 -0400", hash_original_method = "50CD0E92886EDA5BEE0164B092B351EC", hash_generated_method = "D990677E1CB9DCFAF72A3AF93636CB5E")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean hasMoreElements() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.796 -0400", hash_original_method = "82381D9C34AF9F2E88B673FB4A4E6DDE", hash_generated_method = "DC6748CBC176ABEA65F03EFA5D2443BE")
        @DSModeled(DSC.SAFE)
        @Override
        public Object nextElement() {
            throw new NoSuchElementException();
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //throw new NoSuchElementException();
        }

        
}; //Transformed anonymous class
    @SuppressWarnings("unchecked")
    public static final List EMPTY_LIST = new EmptyList();
    @SuppressWarnings("unchecked")
    public static final Set EMPTY_SET = new EmptySet();
    @SuppressWarnings("unchecked")
    public static final Map EMPTY_MAP = new EmptyMap();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.796 -0400", hash_original_method = "0C1BC548FC19EEB6A684F12763720939", hash_generated_method = "E73BB050B9C2D6C02B81CF7AEB0AC739")
    @DSModeled(DSC.SAFE)
    private Collections() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.796 -0400", hash_original_method = "639DCFC6603C0FE7D95B5F727C42F869", hash_generated_method = "C74DB74D36B5DE795D1FA3801CEF0D62")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.796 -0400", hash_original_method = "7EE4BC25497A399F0057D0EDDA546990", hash_generated_method = "183EA53264CFEAD83FA7167AF45DE6E5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.796 -0400", hash_original_method = "4DAF8815DF5AE5641557279C14C79B8B", hash_generated_method = "42FD57A0C1919E9F4B581427431DBBA4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.796 -0400", hash_original_method = "333DF3A528D354763516FD7D10C7D14D", hash_generated_method = "FBADBAF8F47BC1A79BA238A71394986E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.796 -0400", hash_original_method = "62935A13652FEE658979A1B588203D96", hash_generated_method = "6BEF1095B7C5E6DC71C1E4FFA97124F3")
    public static <T> void fill(List<? super T> list, T object) {
        ListIterator<? super T> it = list.listIterator();
        while (it.hasNext()) {
            it.next();
            it.set(object);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.796 -0400", hash_original_method = "9EA4A5E40EF3A55FC218758BEF12D5D6", hash_generated_method = "83F9C050AE4842598DA7A81607173BFD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.797 -0400", hash_original_method = "BEBAF4C7785D93F09A03868592048900", hash_generated_method = "020097D52BF79A254AB7E4F89C4580CE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.797 -0400", hash_original_method = "EA5F430AB64F3DB3A0E15CE09B069784", hash_generated_method = "3E1F9B4A7A186A235ABFB54B2506E9FB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.797 -0400", hash_original_method = "24E498CA55A79FBCB8DBC624ECFDC8C2", hash_generated_method = "DBD4CBA5AD5AFAA8A4184EEBB04A90E0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.797 -0400", hash_original_method = "CA4F12BCC9FC3922FDA42F7B1D85BF52", hash_generated_method = "D45A9C3E8257215F6E2994036B74EBDE")
    public static <T> List<T> nCopies(final int length, T object) {
        return new CopiesList<T>(length, object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.797 -0400", hash_original_method = "EB5699B10E68EAD14DB0C0B8758D3718", hash_generated_method = "31349AC10D0052A7E2BC814BABCA0E6F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.797 -0400", hash_original_method = "6DC9DA2B3115217FB9A4BED85E16405F", hash_generated_method = "8C847D9B315CAEB3A2441D841F7B6E4E")
    @SuppressWarnings("unchecked")
    public static <T> Comparator<T> reverseOrder() {
        return (Comparator) ReverseComparator.INSTANCE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.797 -0400", hash_original_method = "EB6B29E81FA958B4A18DE59CA51C3B68", hash_generated_method = "BB4A33D767C1344B643C80DDF58C2B94")
    public static <T> Comparator<T> reverseOrder(Comparator<T> c) {
        if (c == null) {
            return reverseOrder();
        }
        if (c instanceof ReverseComparator2) {
            return ((ReverseComparator2<T>) c).cmp;
        }
        return new ReverseComparator2<T>(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.797 -0400", hash_original_method = "E5AF799D5D5F28A5FEBFEE44EB734D28", hash_generated_method = "10BF5CB2E01C600AD89E7CF99F3834F5")
    public static void shuffle(List<?> list) {
        shuffle(list, new Random());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.797 -0400", hash_original_method = "610901F49ED75C22083B75E1795D8046", hash_generated_method = "F3CA27D10376DF15BFE3DF819D1A6C72")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.797 -0400", hash_original_method = "12FCAA4ABC86B71C16C808A6B679AB8E", hash_generated_method = "4C1D1ECE77BCA0DEE03E6B789BD5D67A")
    public static <E> Set<E> singleton(E object) {
        return new SingletonSet<E>(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.797 -0400", hash_original_method = "999943D18ABDC661759F1C7A52BB5DB9", hash_generated_method = "6EC81F1F3259C3A43C38304C638F1A04")
    public static <E> List<E> singletonList(E object) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return new SingletonList<E>(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.797 -0400", hash_original_method = "9D629CB80218D378F947A940DF0A687F", hash_generated_method = "CBFEF44EF9740BBF6393C5F9ABD43DA7")
    public static <K, V> Map<K, V> singletonMap(K key, V value) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return new SingletonMap<K, V>(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.797 -0400", hash_original_method = "7728BE757A1FA8D23064A39A5721D4F3", hash_generated_method = "0513CB0A5FF3DBAE70D2113311C6B35A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.797 -0400", hash_original_method = "550C37DC35A21FFEAB740FB6E8E187DD", hash_generated_method = "ADC4C1577E0373128E7E2E866378926D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.797 -0400", hash_original_method = "7B4D18FE971E4DCC6A75CEB3B4EFC148", hash_generated_method = "A7F77A42132916904B9DB826B455D271")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.797 -0400", hash_original_method = "4FA0ADC7B132286E8BEC760B3B473151", hash_generated_method = "903ADF8A474279138316A0C5CDBB7A4E")
    public static <T> boolean replaceAll(List<T> list, T obj, T obj2) {
        int index;
        boolean found = false;
        while ((index = list.indexOf(obj)) > -1) {
            found = true;
            list.set(index, obj2);
        }
        return found;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.797 -0400", hash_original_method = "1281B43B461BF8F3597637C43DDB8B05", hash_generated_method = "585C79A9D02578B7A5E65DBDF48E3245")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.798 -0400", hash_original_method = "E1D1CE40A9DE659C11F6DF1EE0DED402", hash_generated_method = "343C9D8EF6CA44762FC0AEE7C66FE092")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.798 -0400", hash_original_method = "682653A6340BAC71175A462BC9E110F0", hash_generated_method = "5916513B08E39B8EF18D5CEA31994618")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.798 -0400", hash_original_method = "C88929F07D74A697323F0CA10424C476", hash_generated_method = "880357B29D4ECB5D482E151AF34A1048")
    public static <T> ArrayList<T> list(Enumeration<T> enumeration) {
        ArrayList<T> list = new ArrayList<T>();
        while (enumeration.hasMoreElements()) {
            list.add(enumeration.nextElement());
        }
        return list;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.798 -0400", hash_original_method = "6E43AB3D08960348228DF658132887B3", hash_generated_method = "E9F5DE13BDB7D5360DAD72566862CF99")
    public static <T> Collection<T> synchronizedCollection(
            Collection<T> collection) {
        if (collection == null) {
            throw new NullPointerException();
        }
        return new SynchronizedCollection<T>(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.798 -0400", hash_original_method = "2FFB099497385BC1C3F1B683583D48BE", hash_generated_method = "91B5547A9CEABE2220B6B1D0D27DBC7B")
    public static <T> List<T> synchronizedList(List<T> list) {
        if (list == null) {
            throw new NullPointerException();
        }
        if (list instanceof RandomAccess) {
            return new SynchronizedRandomAccessList<T>(list);
        }
        return new SynchronizedList<T>(list);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.798 -0400", hash_original_method = "24D426A1A5E5C520D92BE47A1C821155", hash_generated_method = "AEF58FC203C288723412CC2D7C5B15D4")
    public static <K, V> Map<K, V> synchronizedMap(Map<K, V> map) {
        if (map == null) {
            throw new NullPointerException();
        }
        return new SynchronizedMap<K, V>(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.798 -0400", hash_original_method = "74DA5E727C67C655DD045BA87BF8472B", hash_generated_method = "58359D5F71673E150981FBBDF7A4A5B5")
    public static <E> Set<E> synchronizedSet(Set<E> set) {
        if (set == null) {
            throw new NullPointerException();
        }
        return new SynchronizedSet<E>(set);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.798 -0400", hash_original_method = "A98AFC063D0A48542150939E7020059D", hash_generated_method = "827E66F11CFDCDFDF31DA03CFCF238ED")
    public static <K, V> SortedMap<K, V> synchronizedSortedMap(
            SortedMap<K, V> map) {
        if (map == null) {
            throw new NullPointerException();
        }
        return new SynchronizedSortedMap<K, V>(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.798 -0400", hash_original_method = "2B295CCFD9495D71551B5F58A07BEBAB", hash_generated_method = "780669CF622974C78D717AB6A9CC1493")
    public static <E> SortedSet<E> synchronizedSortedSet(SortedSet<E> set) {
        if (set == null) {
            throw new NullPointerException();
        }
        return new SynchronizedSortedSet<E>(set);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.798 -0400", hash_original_method = "3B4D35B7C543CBEB6CC17697CCEEE62B", hash_generated_method = "85262CB651C4F765414293B715F3DEAF")
    @SuppressWarnings("unchecked")
    public static <E> Collection<E> unmodifiableCollection(
            Collection<? extends E> collection) {
        if (collection == null) {
            throw new NullPointerException();
        }
        return new UnmodifiableCollection<E>((Collection<E>) collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.798 -0400", hash_original_method = "B5A8074AE8066AC7C1199AD52D55F900", hash_generated_method = "1AF25DD3231708F4537234303038B12D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.798 -0400", hash_original_method = "E32CF8466D0D3C027A819BD01F18D286", hash_generated_method = "E601DACA90DFEE88424A2AF79E36964E")
    @SuppressWarnings("unchecked")
    public static <K, V> Map<K, V> unmodifiableMap(
            Map<? extends K, ? extends V> map) {
        if (map == null) {
            throw new NullPointerException();
        }
        return new UnmodifiableMap<K, V>((Map<K, V>) map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.798 -0400", hash_original_method = "732B93ED04C6C885FF5A6C566A1AD920", hash_generated_method = "9EFA18D2D76669F531FA703410E8A880")
    @SuppressWarnings("unchecked")
    public static <E> Set<E> unmodifiableSet(Set<? extends E> set) {
        if (set == null) {
            throw new NullPointerException();
        }
        return new UnmodifiableSet<E>((Set<E>) set);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.798 -0400", hash_original_method = "F9B60149CA5C4E0C4E856413AA7BBCC1", hash_generated_method = "BD6548625684DDDFD73365BFC05CC28C")
    @SuppressWarnings("unchecked")
    public static <K, V> SortedMap<K, V> unmodifiableSortedMap(
            SortedMap<K, ? extends V> map) {
        if (map == null) {
            throw new NullPointerException();
        }
        return new UnmodifiableSortedMap<K, V>((SortedMap<K, V>) map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.798 -0400", hash_original_method = "34401690D339F7CE4C950EBE212EF143", hash_generated_method = "B3EBAE1B81EA9000A1EB9DA8E75DB12D")
    public static <E> SortedSet<E> unmodifiableSortedSet(SortedSet<E> set) {
        if (set == null) {
            throw new NullPointerException();
        }
        return new UnmodifiableSortedSet<E>(set);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.798 -0400", hash_original_method = "69760DD13D23FD7DA542C8A7346928F2", hash_generated_method = "0F52713CAE53AE324652702B4F0017FB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.798 -0400", hash_original_method = "75D75DD95DCB5E5DE52265A94ED70540", hash_generated_method = "F9D0490D6F2944C124AC2208751BDB76")
    @SuppressWarnings("unchecked")
    public static final <T> List<T> emptyList() {
        return EMPTY_LIST;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.798 -0400", hash_original_method = "73E5A788497714026D7280A7E3DC806D", hash_generated_method = "06F8F398E594D330A71ECA7ADF0B82F5")
    @SuppressWarnings("unchecked")
    public static final <T> Set<T> emptySet() {
        return EMPTY_SET;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.798 -0400", hash_original_method = "D72611BD94F420F8FA9573B5FA90656E", hash_generated_method = "F2BFF433AE87E0C67FF809622BBF0612")
    @SuppressWarnings("unchecked")
    public static final <K, V> Map<K, V> emptyMap() {
        return EMPTY_MAP;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.798 -0400", hash_original_method = "2F45A93FC63D40819E1B96E4A691CBD6", hash_generated_method = "BA20C7BC70673FF8B2072671BB5513CE")
    @SuppressWarnings("unchecked")
    public static <T> Enumeration<T> emptyEnumeration() {
        return (Enumeration<T>) EMPTY_ENUMERATION;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.798 -0400", hash_original_method = "349CBCC4DD02D999D655CB376FDEE3F7", hash_generated_method = "1153908B5EF7C2ADAA8A88973D2AE21F")
    @SuppressWarnings("unchecked")
    public static <T> Iterator<T> emptyIterator() {
        return (Iterator<T>) EMPTY_ITERATOR;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.798 -0400", hash_original_method = "FFB178E72EC97BEFDD63737FE0E0AD79", hash_generated_method = "C930058F1D1154DDBA7A0E46F7E92996")
    public static <T> ListIterator<T> emptyListIterator() {
        return Collections.<T>emptyList().listIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.799 -0400", hash_original_method = "DEF46954F3212FCD50E2F664CE85D90F", hash_generated_method = "77848C0E49B360C4338EA59E92A114E8")
    public static <E> Collection<E> checkedCollection(Collection<E> c,
            Class<E> type) {
        return new CheckedCollection<E>(c, type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.799 -0400", hash_original_method = "26757EF50093F69F46B00E2488E96A0F", hash_generated_method = "B11C64597F139D458AA4131D42D096E8")
    public static <K, V> Map<K, V> checkedMap(Map<K, V> m, Class<K> keyType,
            Class<V> valueType) {
        return new CheckedMap<K, V>(m, keyType, valueType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.799 -0400", hash_original_method = "9AFFDACEE17FE4A3968CBD94A110F361", hash_generated_method = "7ED91593A16ED489A39A8022C8262FBC")
    public static <E> List<E> checkedList(List<E> list, Class<E> type) {
        if (list instanceof RandomAccess) {
            return new CheckedRandomAccessList<E>(list, type);
        }
        return new CheckedList<E>(list, type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.799 -0400", hash_original_method = "97926C04320CC583CBCEEBD8B4FF75E5", hash_generated_method = "2A86172C4155ED60C9BAAF25DF5728D1")
    public static <E> Set<E> checkedSet(Set<E> s, Class<E> type) {
        return new CheckedSet<E>(s, type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.799 -0400", hash_original_method = "6FD17870AE45146EDDFA69CFB9E6F29D", hash_generated_method = "5B39EC5B7590FBB5427AC7453EA6C3CA")
    public static <K, V> SortedMap<K, V> checkedSortedMap(SortedMap<K, V> m,
            Class<K> keyType, Class<V> valueType) {
        return new CheckedSortedMap<K, V>(m, keyType, valueType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.799 -0400", hash_original_method = "A9DFE2021401CB17AE293C849D6A117C", hash_generated_method = "7CAED30118B547485EA3992B1C0349AE")
    public static <E> SortedSet<E> checkedSortedSet(SortedSet<E> s,
            Class<E> type) {
        return new CheckedSortedSet<E>(s, type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.799 -0400", hash_original_method = "E490B9510D2924BFC8D3C1976280F42D", hash_generated_method = "2D23F298601EA1CE2D591185E8DAC71B")
    public static <T> boolean addAll(Collection<? super T> c, T... a) {
        boolean modified = false;
        for (int i = 0; i < a.length; i++) {
            modified |= c.add(a[i]);
        }
        return modified;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.799 -0400", hash_original_method = "850D5E92CAC6694D83599DC96343182A", hash_generated_method = "4739EC0EC8671BD7C3709BF4002A041F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.799 -0400", hash_original_method = "1EAD1C5D0DB90DE32D6FF184DEEB9492", hash_generated_method = "0C51E31B21B812417C8D735344100763")
    static <E> E checkType(E obj, Class<? extends E> type) {
        if (obj != null && !type.isInstance(obj)) {
            throw new ClassCastException("Attempt to insert element of type " + obj.getClass() +
                    " into collection of type " + type);
        }
        return obj;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.799 -0400", hash_original_method = "4E45278DD48A168ADBD01BC7FD4B658A", hash_generated_method = "6273DD59988DC942B4763819B203FB99")
    public static <E> Set<E> newSetFromMap(Map<E, Boolean> map) {
        if (map.isEmpty()) {
            return new SetFromMap<E>(map);
        }
        throw new IllegalArgumentException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.799 -0400", hash_original_method = "77F9A8334F6DA18515BAA9683A005F14", hash_generated_method = "B3F57051595BF7BD740996460A0B8F5B")
    public static <T> Queue<T> asLifoQueue(Deque<T> deque) {
        return new AsLIFOQueue<T>(deque);
    }

    
    private static final class CopiesList<E> extends AbstractList<E> implements Serializable {
        private static final long serialVersionUID = 2739099268398711800L;
        private final int n;
        private final E element;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.799 -0400", hash_original_method = "5A122D173062D06824D4571736320F87", hash_generated_method = "C72543BC4DDC2D24F46B30611275E523")
        @DSModeled(DSC.SAFE)
         CopiesList(int length, E object) {
            dsTaint.addTaint(length);
            dsTaint.addTaint(object.dsTaint);
            {
                throw new IllegalArgumentException();
            } //End block
            // ---------- Original Method ----------
            //if (length < 0) {
                //throw new IllegalArgumentException();
            //}
            //n = length;
            //element = object;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.799 -0400", hash_original_method = "B07BCF81C9C48C72A08077A0468A8769", hash_generated_method = "056975F6DB07F50892D728B08B476F05")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean contains(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                Object var918C716CCB523821E4DE921B4E432F42_1023863225 = (element.equals(object));
            } //End flattened ternary
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return element == null ? object == null : element.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.799 -0400", hash_original_method = "61094B9B9DEC6161E82512577FAF3323", hash_generated_method = "FC84746358C0AD219EE4E552EE1ABF36")
        @DSModeled(DSC.SAFE)
        @Override
        public int size() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return n;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.799 -0400", hash_original_method = "857A70B35DA7146CF7ADC484EC4AABC8", hash_generated_method = "49FF6FF9E0708A65C001B0ABFA6331D7")
        @DSModeled(DSC.SAFE)
        @Override
        public E get(int location) {
            dsTaint.addTaint(location);
            throw new IndexOutOfBoundsException();
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (location >= 0 && location < n) {
                //return element;
            //}
            //throw new IndexOutOfBoundsException();
        }

        
    }


    
    private static final class EmptyList extends AbstractList implements RandomAccess, Serializable {
        private static final long serialVersionUID = 8842843931221139166L;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.799 -0400", hash_original_method = "38B750FD34BF6CB1144CDF020D3299E6", hash_generated_method = "C484A77686DD466B6A63CDF43C859A80")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean contains(Object object) {
            dsTaint.addTaint(object.dsTaint);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.799 -0400", hash_original_method = "F4586E3A64B5D10DEB709A723C85E55E", hash_generated_method = "3758599F04938929F49FAB44F9BE5DBC")
        @DSModeled(DSC.SAFE)
        @Override
        public int size() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.799 -0400", hash_original_method = "F59F44D1664BC2EE59D5A9B30D144285", hash_generated_method = "080F4DC73A9487E31432A033F2FEDF12")
        @DSModeled(DSC.SAFE)
        @Override
        public Object get(int location) {
            dsTaint.addTaint(location);
            throw new IndexOutOfBoundsException();
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //throw new IndexOutOfBoundsException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.799 -0400", hash_original_method = "3CB4CAF1EADC3F12C565BD7D2B5F5514", hash_generated_method = "45859EC24535F94D96C808B4A126ABAE")
        @DSModeled(DSC.SAFE)
        private Object readResolve() {
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return Collections.EMPTY_LIST;
        }

        
    }


    
    private static final class EmptySet extends AbstractSet implements Serializable {
        private static final long serialVersionUID = 1582296315990362920L;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.799 -0400", hash_original_method = "38B750FD34BF6CB1144CDF020D3299E6", hash_generated_method = "C484A77686DD466B6A63CDF43C859A80")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean contains(Object object) {
            dsTaint.addTaint(object.dsTaint);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.800 -0400", hash_original_method = "F4586E3A64B5D10DEB709A723C85E55E", hash_generated_method = "3758599F04938929F49FAB44F9BE5DBC")
        @DSModeled(DSC.SAFE)
        @Override
        public int size() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.800 -0400", hash_original_method = "FC88A4B2F50E498E162F3F7EEDE885B1", hash_generated_method = "A74417724F59107357B2DC48AA27CCD0")
        @DSModeled(DSC.SAFE)
        @Override
        public Iterator iterator() {
            return (Iterator)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return EMPTY_ITERATOR;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.800 -0400", hash_original_method = "2ED0845ADEAE5655731C197578B08F82", hash_generated_method = "C1160ECDC17CDCF83CBA764FAE6B181C")
        @DSModeled(DSC.SAFE)
        private Object readResolve() {
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return Collections.EMPTY_SET;
        }

        
    }


    
    private static final class EmptyMap extends AbstractMap implements Serializable {
        private static final long serialVersionUID = 6428348081105594320L;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.800 -0400", hash_original_method = "2AD0E7E75E88E287D6229481B74BEBCC", hash_generated_method = "753A68D9624A07455D114036E463F5BB")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean containsKey(Object key) {
            dsTaint.addTaint(key.dsTaint);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.800 -0400", hash_original_method = "9D32B6FFC088649ED5480F6E533A1288", hash_generated_method = "E46274FE8FABD93976444FBB5D0BD212")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean containsValue(Object value) {
            dsTaint.addTaint(value.dsTaint);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.800 -0400", hash_original_method = "709DD403C63D2F4104FF93FEEB6E3457", hash_generated_method = "EA104C1038D32B75BD3A755BE31BA4C6")
        @DSModeled(DSC.SAFE)
        @Override
        public Set entrySet() {
            return (Set)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return EMPTY_SET;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.800 -0400", hash_original_method = "59A1188DDD48CFFB749850DC2DA09C1D", hash_generated_method = "64892D182ED1FA980DB633DE2E4F6329")
        @DSModeled(DSC.SAFE)
        @Override
        public Object get(Object key) {
            dsTaint.addTaint(key.dsTaint);
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.800 -0400", hash_original_method = "266B164C16644761E32491964C192EB7", hash_generated_method = "CBCE00703C0D2AB2BE7A41B5560856C4")
        @DSModeled(DSC.SAFE)
        @Override
        public Set keySet() {
            return (Set)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return EMPTY_SET;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.800 -0400", hash_original_method = "745E6E226DD5F7D4E763DA74DFF70792", hash_generated_method = "F0FA12E9C1049A9FEDB64993C018B3B8")
        @DSModeled(DSC.SAFE)
        @Override
        public Collection values() {
            return (Collection)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return EMPTY_LIST;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.800 -0400", hash_original_method = "59A22E9415A338EB85D7A7DD214359CC", hash_generated_method = "2B1B2568D8C89EB54063E4ED3957C683")
        @DSModeled(DSC.SAFE)
        private Object readResolve() {
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return Collections.EMPTY_MAP;
        }

        
    }


    
    private static final class ReverseComparator<T> implements Comparator<T>, Serializable {
        private static final ReverseComparator<Object> INSTANCE = new ReverseComparator<Object>();
        private static final long serialVersionUID = 7207038068494060240L;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.800 -0400", hash_original_method = "907488F1D5625FE5C9F59ED8A7B6E697", hash_generated_method = "B7FFB45AE24C3C0EEB17CE3A4ABD8BF3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @SuppressWarnings("unchecked")
        @Override
        public int compare(T o1, T o2) {
            dsTaint.addTaint(o2.dsTaint);
            dsTaint.addTaint(o1.dsTaint);
            Comparable<T> c2;
            c2 = (Comparable<T>) o2;
            int var692167FC6770150DF2B5DF91BFB83EC2_647231190 = (c2.compareTo(o1));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //Comparable<T> c2 = (Comparable<T>) o2;
            //return c2.compareTo(o1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.800 -0400", hash_original_method = "DD371F0FDF8300FDCFBD1E5C395D42BC", hash_generated_method = "34F11C83B2727316E14F7DFFDA03F68F")
        @DSModeled(DSC.SAFE)
        private Object readResolve() throws ObjectStreamException {
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return INSTANCE;
        }

        
    }


    
    private static final class ReverseComparator2<T> implements Comparator<T>, Serializable {
        private static final long serialVersionUID = 4374092139857L;
        private final Comparator<T> cmp;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.800 -0400", hash_original_method = "1ABA0972F29BDB004C28A1246ABEF788", hash_generated_method = "2998CE5678F8452038B74C404414921C")
        @DSModeled(DSC.SAFE)
         ReverseComparator2(Comparator<T> comparator) {
            dsTaint.addTaint(comparator.dsTaint);
            // ---------- Original Method ----------
            //this.cmp = comparator;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.800 -0400", hash_original_method = "449D1B24DD0E97F4D53DEB786BD04597", hash_generated_method = "82E9A5BE5D6F8F42A4D8C1FA2EB379F3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int compare(T o1, T o2) {
            dsTaint.addTaint(o2.dsTaint);
            dsTaint.addTaint(o1.dsTaint);
            int varC3FAEC3684B290716428C4AB73BA307C_44055944 = (cmp.compare(o2, o1));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return cmp.compare(o2, o1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.800 -0400", hash_original_method = "30689CAB8FBFDCB9289EF03377EE08A0", hash_generated_method = "B6781C631010A52EFD367BEB93922EB3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object o) {
            dsTaint.addTaint(o.dsTaint);
            boolean varB42AC7AE9468AAA515C4B77EBD2F7BC7_1773150007 = (o instanceof ReverseComparator2
                    && ((ReverseComparator2) o).cmp.equals(cmp));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return o instanceof ReverseComparator2
                    //&& ((ReverseComparator2) o).cmp.equals(cmp);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.800 -0400", hash_original_method = "CAA612A5887D060562790EB1CDD1FEFE", hash_generated_method = "64FC5DFC3437C277C4358F9B1F86EBC0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int varFAD4BDCF5F08AFF151A94355744A94BB_1222699812 = (~cmp.hashCode());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return ~cmp.hashCode();
        }

        
    }


    
    private static final class SingletonSet<E> extends AbstractSet<E> implements Serializable {
        private static final long serialVersionUID = 3193687207550431679L;
        final E element;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.800 -0400", hash_original_method = "044BE6981927B9234E2AE8686E07A72F", hash_generated_method = "6F43C33BE0EDBBCCC839475B4AEDEB84")
        @DSModeled(DSC.SAFE)
         SingletonSet(E object) {
            dsTaint.addTaint(object.dsTaint);
            // ---------- Original Method ----------
            //element = object;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.800 -0400", hash_original_method = "B07BCF81C9C48C72A08077A0468A8769", hash_generated_method = "646724120885579C82AACE96E78282DE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean contains(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                Object var918C716CCB523821E4DE921B4E432F42_1608784191 = (element.equals(object));
            } //End flattened ternary
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return element == null ? object == null : element.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.800 -0400", hash_original_method = "798A0AE2F2A6352396904AB5C9ED97D5", hash_generated_method = "B297A1211E718A1D34F594A0541039B7")
        @DSModeled(DSC.SAFE)
        @Override
        public int size() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.800 -0400", hash_original_method = "135AC18A6A8AD4548E2E750F2D4C7699", hash_generated_method = "3BCF86373F43570A953F3B01E8AC4196")
        @DSModeled(DSC.SAFE)
        @Override
        public Iterator<E> iterator() {
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

        
    }


    
    private static final class SingletonList<E> extends AbstractList<E> implements Serializable {
        private static final long serialVersionUID = 3093736618740652951L;
        final E element;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.801 -0400", hash_original_method = "F3174A5FA7BA5962D109EAC3245F2C1D", hash_generated_method = "FDCC8095FB9FFA2E6168557E63486A7F")
        @DSModeled(DSC.SAFE)
         SingletonList(E object) {
            dsTaint.addTaint(object.dsTaint);
            // ---------- Original Method ----------
            //element = object;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.801 -0400", hash_original_method = "B07BCF81C9C48C72A08077A0468A8769", hash_generated_method = "3F8BB438520E3405B3EFA0ECA48C6C38")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean contains(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                Object var918C716CCB523821E4DE921B4E432F42_245707962 = (element.equals(object));
            } //End flattened ternary
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return element == null ? object == null : element.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.801 -0400", hash_original_method = "1C6E7D1EB082158D5E00EA29E883A612", hash_generated_method = "CEBEB3C09A7B0C500854905F3EEFAEF8")
        @DSModeled(DSC.SAFE)
        @Override
        public E get(int location) {
            dsTaint.addTaint(location);
            throw new IndexOutOfBoundsException();
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (location == 0) {
                //return element;
            //}
            //throw new IndexOutOfBoundsException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.801 -0400", hash_original_method = "798A0AE2F2A6352396904AB5C9ED97D5", hash_generated_method = "B297A1211E718A1D34F594A0541039B7")
        @DSModeled(DSC.SAFE)
        @Override
        public int size() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 1;
        }

        
    }


    
    private static final class SingletonMap<K, V> extends AbstractMap<K, V> implements Serializable {
        private static final long serialVersionUID = -6979724477215052911L;
        final K k;
        final V v;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.801 -0400", hash_original_method = "85D3D420EE431E7A3C1CBFB71D1CEAE2", hash_generated_method = "3031694470ADF5215E79E7B0B4F0DAE1")
        @DSModeled(DSC.SAFE)
         SingletonMap(K key, V value) {
            dsTaint.addTaint(value.dsTaint);
            dsTaint.addTaint(key.dsTaint);
            // ---------- Original Method ----------
            //k = key;
            //v = value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.801 -0400", hash_original_method = "26D5E87A2C62405ADA3B15C5C8B30FEC", hash_generated_method = "2995B134FFECDD4460EBF371E55B2BDF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsKey(Object key) {
            dsTaint.addTaint(key.dsTaint);
            {
                Object var0EB569FD4AF21D116A21E287F6027A39_1370701381 = (k.equals(key));
            } //End flattened ternary
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return k == null ? key == null : k.equals(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.801 -0400", hash_original_method = "827D42B4F919454EC51CA86D0E534994", hash_generated_method = "E001EC3410A177827DA3BC368661B144")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsValue(Object value) {
            dsTaint.addTaint(value.dsTaint);
            {
                Object var1F74AE50105434A557EE1F3FD50522E7_560363105 = (v.equals(value));
            } //End flattened ternary
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return v == null ? value == null : v.equals(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.801 -0400", hash_original_method = "8C587096F5E6029DBB187C58CF22D158", hash_generated_method = "EE6D41CA0B068B3119FAD761317E3CB8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public V get(Object key) {
            dsTaint.addTaint(key.dsTaint);
            {
                boolean varD8EB9E9C73E773501877E01187F3B5DA_277483935 = (containsKey(key));
            } //End collapsed parenthetic
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (containsKey(key)) {
                //return v;
            //}
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.801 -0400", hash_original_method = "798A0AE2F2A6352396904AB5C9ED97D5", hash_generated_method = "B297A1211E718A1D34F594A0541039B7")
        @DSModeled(DSC.SAFE)
        @Override
        public int size() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.801 -0400", hash_original_method = "AB4A6E093F1AE40B73184C21F1D08E5E", hash_generated_method = "61713F515EC7D8BEB7A8B71BE9D9F6FA")
        @DSModeled(DSC.SAFE)
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            return (Set<Map.Entry<K, V>>)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    static class SynchronizedCollection<E> implements Collection<E>, Serializable {
        private static final long serialVersionUID = 3053995032091335093L;
        final Collection<E> c;
        final Object mutex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.801 -0400", hash_original_method = "30FA7B26D2517E75155300E21A44EE02", hash_generated_method = "F71C7C8FDA3C6A34CD3ABA7D840B5C0F")
        @DSModeled(DSC.SAFE)
         SynchronizedCollection(Collection<E> collection) {
            dsTaint.addTaint(collection.dsTaint);
            mutex = this;
            // ---------- Original Method ----------
            //c = collection;
            //mutex = this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.801 -0400", hash_original_method = "A2A350BD37040709EC39C6B0536AFBDE", hash_generated_method = "8E0E3C245A37B9462D76E8441F71257B")
        @DSModeled(DSC.SAFE)
         SynchronizedCollection(Collection<E> collection, Object mutex) {
            dsTaint.addTaint(mutex.dsTaint);
            dsTaint.addTaint(collection.dsTaint);
            // ---------- Original Method ----------
            //c = collection;
            //this.mutex = mutex;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.801 -0400", hash_original_method = "FB2AC5CD0A8119C2DE50A53F38732CDD", hash_generated_method = "2A40B7B039BCFA2840C4938D6CCC02C1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean add(E object) {
            dsTaint.addTaint(object.dsTaint);
            {
                boolean var2BB0FD33FED1B2B72867ACF06FBFC56B_283649616 = (c.add(object));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.add(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.801 -0400", hash_original_method = "8489E829BC0B88048B305735D46B1D99", hash_generated_method = "E7B4BCE6C74383493EC62A3F6CA08CD4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean addAll(Collection<? extends E> collection) {
            dsTaint.addTaint(collection.dsTaint);
            {
                boolean varAB7EBFBCA4F45D51E737154B11C4108B_858337130 = (c.addAll(collection));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.addAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.801 -0400", hash_original_method = "7AE3345D011114FF0F62A8DFD7762BE2", hash_generated_method = "F61AFEA220D9937EED4DD567DC05838D")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.801 -0400", hash_original_method = "1B12503F1112F0CD581293F3A624FEFF", hash_generated_method = "B6A92A177F8D7096C6C444565AA5CBB9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean contains(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                boolean var34971DB84F983FD59B337EBDA19618A7_1311070424 = (c.contains(object));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.contains(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.802 -0400", hash_original_method = "F945FF2C907D1AA0923D46DECCCD5EAD", hash_generated_method = "402BFBCCD213D984CA6447492F55F7D1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            {
                boolean varDACCFBFB1E0F996A35B7BB8B776BF827_1009965796 = (c.containsAll(collection));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.containsAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.802 -0400", hash_original_method = "FC4F88C8FB9F4E3716AD2ABCD3101657", hash_generated_method = "847CDEC8CC3C6F3213B0D7254A69C3BB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean isEmpty() {
            {
                boolean var13DC031C5380F0C4DA515946E668AE17_700611117 = (c.isEmpty());
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.isEmpty();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.802 -0400", hash_original_method = "7F1B5E60A4E4F9F3AFA65965967FBBF0", hash_generated_method = "DE02358903B4BB74F22ED1A2B6BADB3D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Iterator<E> iterator() {
            {
                Iterator<E> var24A0D29F595F4955177CF826CFD2CBB4_36362214 = (c.iterator());
            } //End block
            return (Iterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.iterator();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.802 -0400", hash_original_method = "C85E45E4AF074973339408E1197B653C", hash_generated_method = "B03538D8351EAF1A490B8E869F6257EE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean remove(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                boolean var8E355775017A5ED204FCCA7510D23187_1457154973 = (c.remove(object));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.remove(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.802 -0400", hash_original_method = "63829008A74D54A464D81619215951F3", hash_generated_method = "A60D3B054993961C748868E1D426EED8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean removeAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            {
                boolean var1464AF4DDAD9564C54B239B0335D2517_374616683 = (c.removeAll(collection));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.removeAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.802 -0400", hash_original_method = "F83427C5B4EF86DB8198B3D2BAE482AC", hash_generated_method = "6516F4E691F56CB2639C6B7FE0D7951B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean retainAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            {
                boolean varF2E46B90912EE4E31AEA6D3F646498E8_687091882 = (c.retainAll(collection));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.retainAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.802 -0400", hash_original_method = "8641BC878FB77D36CE60B1977D7C0FB5", hash_generated_method = "2A57520CB0B5B539D456CB329690A49A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int size() {
            {
                int var0E51EFE72011B352AF314992F697E7C3_1129515384 = (c.size());
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.size();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.802 -0400", hash_original_method = "214BCEC14D5449B585926B657D8D51C2", hash_generated_method = "11AAE714F622BAB5117652D2ABC69BB9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public java.lang.Object[] toArray() {
            {
                java.lang.Object[] var3F2D8DA9C0222705DC9C1F072168E1F8_1990617590 = (c.toArray());
            } //End block
            return (java.lang.Object[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.toArray();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.802 -0400", hash_original_method = "D637F0F4C3C8C312A0597F30C1C6DB59", hash_generated_method = "EAD627F54F1121F00ADDD3D49EFB657D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            {
                String varDA4751CDF147B4450C76D2AC5CA38320_2032509009 = (c.toString());
            } //End block
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.toString();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.802 -0400", hash_original_method = "567EED27866E99DFC1B7F8B43B648D82", hash_generated_method = "9F6B373229780678DFD235ACBFB474EE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public <T> T[] toArray(T[] array) {
            dsTaint.addTaint(array.dsTaint);
            {
                T[] var5D23623B3310566BAD78670724549A14_1501810012 = (c.toArray(array));
            } //End block
            return (T[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.toArray(array);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.802 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "6001D7B256B91F08C850EFC8421AA226")
        @DSModeled(DSC.SAFE)
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

        
    }


    
    static class SynchronizedRandomAccessList<E> extends SynchronizedList<E> implements RandomAccess {
        private static final long serialVersionUID = 1530674583602358482L;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.802 -0400", hash_original_method = "B7E7091552AE239FAE56C332916C1F88", hash_generated_method = "82BFACD42C2297AAD8262E74EEEB2F4C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SynchronizedRandomAccessList(List<E> l) {
            super(l);
            dsTaint.addTaint(l.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.802 -0400", hash_original_method = "333C2DB156927D33EFC68D095A4D91C7", hash_generated_method = "05ACD6BF9EF868EE70FF78FF5785BFD9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SynchronizedRandomAccessList(List<E> l, Object mutex) {
            super(l, mutex);
            dsTaint.addTaint(mutex.dsTaint);
            dsTaint.addTaint(l.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.802 -0400", hash_original_method = "52EB3707ADD11A2326D60B7B815140D9", hash_generated_method = "C0F0A643DBFC95EE9B1128AC1B5E6786")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public List<E> subList(int start, int end) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(end);
            {
                List<E> var79F4B4FC1730C00495472D64C06A5972_10471606 = (new SynchronizedRandomAccessList<E>(list.subList(start, end), mutex));
            } //End block
            return (List<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedRandomAccessList<E>(list.subList(start, end), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.802 -0400", hash_original_method = "3A06B4F1BF7736CF10F2183ECBC34EF4", hash_generated_method = "E33B997055ADB9FE6AAEFFE34613170E")
        @DSModeled(DSC.SAFE)
        private Object writeReplace() {
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SynchronizedList<E>(list);
        }

        
    }


    
    static class SynchronizedList<E> extends SynchronizedCollection<E> implements List<E> {
        private static final long serialVersionUID = -7754090372962971524L;
        final List<E> list;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.802 -0400", hash_original_method = "557BC04FB4751FAF0774C664BC5CCEDB", hash_generated_method = "ED866C5CCE5B8540209DF43AC567233E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SynchronizedList(List<E> l) {
            super(l);
            dsTaint.addTaint(l.dsTaint);
            // ---------- Original Method ----------
            //list = l;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.802 -0400", hash_original_method = "6BB690026CB7D337AD2D522FD2C1D564", hash_generated_method = "904C60DA0082C3B1ECA4D2B66725ACF3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SynchronizedList(List<E> l, Object mutex) {
            super(l, mutex);
            dsTaint.addTaint(mutex.dsTaint);
            dsTaint.addTaint(l.dsTaint);
            // ---------- Original Method ----------
            //list = l;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.802 -0400", hash_original_method = "771543DB5FBF857EC43E623C900790C1", hash_generated_method = "554450E0E64B2800881B3E3B804CBAC0")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.803 -0400", hash_original_method = "2E8B0D036C339DEB52EAEECF82B3FC29", hash_generated_method = "9BEB063159B87DF1C0FDF888C5466A07")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean addAll(int location, Collection<? extends E> collection) {
            dsTaint.addTaint(location);
            dsTaint.addTaint(collection.dsTaint);
            {
                boolean var158D83A08C48A45A82B28798671769C1_994416622 = (list.addAll(location, collection));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.addAll(location, collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.803 -0400", hash_original_method = "3D6B0DEE3E066475015263D28B67E9C7", hash_generated_method = "355160778814EED58CF8662923029165")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                boolean varB8EFBCA5568090BA0F116E782A49968B_1169956991 = (list.equals(object));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.equals(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.803 -0400", hash_original_method = "5B64BB89A58DED71DBA9907C06BC2CBB", hash_generated_method = "1B3B2085C4DF25A1B2435B5A168FD9BD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E get(int location) {
            dsTaint.addTaint(location);
            {
                E var73B0B58D8D3D7335145E2B8B6AC44D88_1880523662 = (list.get(location));
            } //End block
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.get(location);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.803 -0400", hash_original_method = "4F5947DB3C3ABC0CDEDCB631295417DE", hash_generated_method = "A265C4D9F732D9184B824366B99B61C1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            {
                int varE89315CE67DD6395C812E01B5B28CC79_767911799 = (list.hashCode());
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.hashCode();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.803 -0400", hash_original_method = "3D24998665BD619FA01B00E0A34A83F5", hash_generated_method = "89005510203CCA35810C907CD5B70CC8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int indexOf(Object object) {
            dsTaint.addTaint(object.dsTaint);
            final int size;
            final Object[] array;
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
                            boolean varE4EB18CE7254896A48F2456CD1C5820F_348565748 = (object.equals(array[i]));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.803 -0400", hash_original_method = "615F71337583130515178716D1767A86", hash_generated_method = "D2781DC51EF1A019572948EF34EA8783")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int lastIndexOf(Object object) {
            dsTaint.addTaint(object.dsTaint);
            final int size;
            final Object[] array;
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
                            boolean varE4EB18CE7254896A48F2456CD1C5820F_1364391984 = (object.equals(array[i]));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.803 -0400", hash_original_method = "9E49E91DE129681261C3C7642C2D1127", hash_generated_method = "10F4E2E41C9086DFC4DECF442608775F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public ListIterator<E> listIterator() {
            {
                ListIterator<E> var76349BCE7583779F3F3F157CAF26DD4C_1744672224 = (list.listIterator());
            } //End block
            return (ListIterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.listIterator();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.803 -0400", hash_original_method = "70349F3896FC81F4D21A3D35B0C8A4F6", hash_generated_method = "103044CF35B29AFE1E9C277072206D4D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public ListIterator<E> listIterator(int location) {
            dsTaint.addTaint(location);
            {
                ListIterator<E> var71730C54CD0BAB9C07323A68A1A20AE4_1535354183 = (list.listIterator(location));
            } //End block
            return (ListIterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.listIterator(location);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.803 -0400", hash_original_method = "D935E09B492D323BEF59297A7648FE48", hash_generated_method = "17D66F02492C1AB0772270F7597AE978")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E remove(int location) {
            dsTaint.addTaint(location);
            {
                E var8A9D2AEA7F5291AA8B5F07EF2501777A_1242342450 = (list.remove(location));
            } //End block
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.remove(location);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.803 -0400", hash_original_method = "D9730991663FB8C206D80781B7E02750", hash_generated_method = "59502C0CB1A84ED47A42A409D5E870B8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E set(int location, E object) {
            dsTaint.addTaint(location);
            dsTaint.addTaint(object.dsTaint);
            {
                E var99FBB8BC1ADB365164A853DDBCC975BF_1235399515 = (list.set(location, object));
            } //End block
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.set(location, object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.803 -0400", hash_original_method = "C38F2D62AA6D1EBD255ADC5369CBEC01", hash_generated_method = "E63CB46A2D541207DF4B5777F4B64531")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public List<E> subList(int start, int end) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(end);
            {
                List<E> var6FDAAEF93DBE6A1FE8237A35A66F1C47_1147260741 = (new SynchronizedList<E>(list.subList(start, end), mutex));
            } //End block
            return (List<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedList<E>(list.subList(start, end), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.803 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "6001D7B256B91F08C850EFC8421AA226")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.804 -0400", hash_original_method = "172F08E6F2352F1764A4A70C48C6E243", hash_generated_method = "27053DFF59060ADAD999927A6ECE4E61")
        @DSModeled(DSC.SAFE)
        private Object readResolve() {
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (list instanceof RandomAccess) {
                //return new SynchronizedRandomAccessList<E>(list, mutex);
            //}
            //return this;
        }

        
    }


    
    static class SynchronizedMap<K, V> implements Map<K, V>, Serializable {
        private static final long serialVersionUID = 1978198479659022715L;
        private final Map<K, V> m;
        final Object mutex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.804 -0400", hash_original_method = "C14189E3F71A4C148CB91C638F3BAAE3", hash_generated_method = "2616A09CADEFBE498D5704A0229BCF47")
        @DSModeled(DSC.SAFE)
         SynchronizedMap(Map<K, V> map) {
            dsTaint.addTaint(map.dsTaint);
            mutex = this;
            // ---------- Original Method ----------
            //m = map;
            //mutex = this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.804 -0400", hash_original_method = "6EAD9DD813CFD47244744C3F6D6A4D1C", hash_generated_method = "934F05BC4AC32CFE49361C2B60E85BB9")
        @DSModeled(DSC.SAFE)
         SynchronizedMap(Map<K, V> map, Object mutex) {
            dsTaint.addTaint(mutex.dsTaint);
            dsTaint.addTaint(map.dsTaint);
            // ---------- Original Method ----------
            //m = map;
            //this.mutex = mutex;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.804 -0400", hash_original_method = "3DCF075501F09300584E40825720BBA2", hash_generated_method = "3A0A2D335B1D2F737F299BBE51B1D966")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.804 -0400", hash_original_method = "D2C67B34100B05197A0572527ECA3220", hash_generated_method = "1568F8C58E467C52D3283AD8F1A23484")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsKey(Object key) {
            dsTaint.addTaint(key.dsTaint);
            {
                boolean var5B3943E8DB1DEBF4053A7AC85BD5CB7F_1022527126 = (m.containsKey(key));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.containsKey(key);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.804 -0400", hash_original_method = "FFE2162DB44C1E8BEEAD35935B233C81", hash_generated_method = "A72F764F14C91E4B55265A88F3140D43")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsValue(Object value) {
            dsTaint.addTaint(value.dsTaint);
            {
                boolean var9B502A789B5AAD38CD0ED829F2887AEF_2116172462 = (m.containsValue(value));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.containsValue(value);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.804 -0400", hash_original_method = "E5EA9A3F9567269DAA52E0C08140D3D5", hash_generated_method = "446E7B9BFD4DC9500CD472D0C7D69DB7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            {
                Set<Map.Entry<K, V>> varCCB5BAB8CD8236FC7E7EE18A7FE8FDA2_229318537 = (new SynchronizedSet<Map.Entry<K, V>>(m.entrySet(), mutex));
            } //End block
            return (Set<Map.Entry<K, V>>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSet<Map.Entry<K, V>>(m.entrySet(), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.804 -0400", hash_original_method = "573EFA9740FEBDEC9C1CCFD8172CCEF0", hash_generated_method = "D1D5D7C7209A54CCDCD799A5FDE14E26")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                boolean var3653CC7A1B6721F556FDF4EA3FD61A52_1614086769 = (m.equals(object));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.equals(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.804 -0400", hash_original_method = "80DF7D6FED6980DF61457325CD64503D", hash_generated_method = "D00686D3D8EE042890696B621B350AB9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public V get(Object key) {
            dsTaint.addTaint(key.dsTaint);
            {
                V var474A70B52BFFEC8B20AC6270DFA16E1F_1081144039 = (m.get(key));
            } //End block
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.get(key);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.804 -0400", hash_original_method = "5DDF560D56DA8F61EEAD582BB150A893", hash_generated_method = "A60817AB23DE185C54732205E0E8019B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            {
                int var58938B03D27AEF577E5F8B43D45478A1_641499939 = (m.hashCode());
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.hashCode();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.804 -0400", hash_original_method = "40A122CDBD7096230690259CC30A0F7A", hash_generated_method = "ED4B6EF1D1138234E9A713D910DD6C9B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean isEmpty() {
            {
                boolean var20AA7E3C23DC3AFB5FE1B5D3BD0CE158_648119901 = (m.isEmpty());
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.isEmpty();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.804 -0400", hash_original_method = "2FBB6190D51F2A6210F8CF71191E69DD", hash_generated_method = "15AC4744EE671CCE70DD27A0B31066D8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Set<K> keySet() {
            {
                Set<K> var0BD25AF91FBC2C9D7A5D0DBCD935921E_761157672 = (new SynchronizedSet<K>(m.keySet(), mutex));
            } //End block
            return (Set<K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSet<K>(m.keySet(), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.804 -0400", hash_original_method = "4BBBC2EF3E646AB7C0C1BFCAE8571FAF", hash_generated_method = "F340E4C4C50D7A36E25E34B349E289D1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public V put(K key, V value) {
            dsTaint.addTaint(value.dsTaint);
            dsTaint.addTaint(key.dsTaint);
            {
                V var636674CA8442FF245A35ED4C39B478C0_774569776 = (m.put(key, value));
            } //End block
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.put(key, value);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.804 -0400", hash_original_method = "400FF0E6707670DAA4FF7ECA275302A3", hash_generated_method = "935458F8EC7F77EFDD9CD52B724C2EE7")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.804 -0400", hash_original_method = "98B37460DCD5FD18048F5172283C3141", hash_generated_method = "5D03AEAFACB0533C91BCA0370B9081D8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public V remove(Object key) {
            dsTaint.addTaint(key.dsTaint);
            {
                V var6330C1F751AFF9358410A0C6CDD88E9D_330997661 = (m.remove(key));
            } //End block
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.remove(key);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.804 -0400", hash_original_method = "A48EE7C65347333E889EFC2ECD0A019A", hash_generated_method = "1E9830EDC13ECB738A33277F178F1CA0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int size() {
            {
                int var0BF7698F6735353014CC57B558785727_477542254 = (m.size());
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.size();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.804 -0400", hash_original_method = "BB797020E54DC33FB15BC9404E89E5CD", hash_generated_method = "BF461FEB46CBA0125BFDAE17C46B8E39")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Collection<V> values() {
            {
                Collection<V> varA250843E6E6DC30A02405715361D4AB0_233186523 = (new SynchronizedCollection<V>(m.values(), mutex));
            } //End block
            return (Collection<V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedCollection<V>(m.values(), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.804 -0400", hash_original_method = "CB61B465EF18C12F472B81636CD4AC79", hash_generated_method = "09953441EE97BE9DAB2E8F90A1D3B676")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            {
                String var955C11A8135722B04F0E9199D1AEFE75_1782369259 = (m.toString());
            } //End block
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.toString();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.805 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "6001D7B256B91F08C850EFC8421AA226")
        @DSModeled(DSC.SAFE)
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

        
    }


    
    static class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E> {
        private static final long serialVersionUID = 487447009682186044L;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.805 -0400", hash_original_method = "F3863A567ABAC10F9410ABCF2A4DC8AC", hash_generated_method = "2D2D7A07B8EB52B9E71B84200AC7DA02")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SynchronizedSet(Set<E> set) {
            super(set);
            dsTaint.addTaint(set.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.805 -0400", hash_original_method = "A1BA2E3E145DCA2C522F0AB9439A1572", hash_generated_method = "90B7E706DF5646F1084FC04AF8669537")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SynchronizedSet(Set<E> set, Object mutex) {
            super(set, mutex);
            dsTaint.addTaint(mutex.dsTaint);
            dsTaint.addTaint(set.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.805 -0400", hash_original_method = "E045FF0B832C85F3AF0597463FE3892F", hash_generated_method = "31AE081D8AB5A3D46FA38EF9B35D9E17")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                boolean varEA83122D095DC61C01436A4AA2CBB70C_1715425495 = (c.equals(object));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.equals(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.805 -0400", hash_original_method = "60CA731F9E7ECB7D3EED20B0D6D4AB09", hash_generated_method = "A1A920FD32A61B360444200CACA9E90C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            {
                int varDBC342B671922A4943718E25F26D87D0_300649192 = (c.hashCode());
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.hashCode();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.805 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "6001D7B256B91F08C850EFC8421AA226")
        @DSModeled(DSC.SAFE)
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

        
    }


    
    static class SynchronizedSortedMap<K, V> extends SynchronizedMap<K, V> implements SortedMap<K, V> {
        private static final long serialVersionUID = -8798146769416483793L;
        private final SortedMap<K, V> sm;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.805 -0400", hash_original_method = "2E0F62BCD34367F1E6E251286E17ABEB", hash_generated_method = "CED4518808A1B6E3DBF59B2B29C4D376")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SynchronizedSortedMap(SortedMap<K, V> map) {
            super(map);
            dsTaint.addTaint(map.dsTaint);
            // ---------- Original Method ----------
            //sm = map;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.805 -0400", hash_original_method = "5BF33998E3FF0155F7A513C6A201FE85", hash_generated_method = "CCB0196D8995C70169C4DA033A52F020")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SynchronizedSortedMap(SortedMap<K, V> map, Object mutex) {
            super(map, mutex);
            dsTaint.addTaint(mutex.dsTaint);
            dsTaint.addTaint(map.dsTaint);
            // ---------- Original Method ----------
            //sm = map;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.805 -0400", hash_original_method = "78218A5A359D1FCDF6B98779037FCB94", hash_generated_method = "B41B54D03184A5AB2F2505C04391840D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Comparator<? super K> comparator() {
            {
                Comparator<? super K> varC89FBD52D1D81FD4CD4799B6E3332E0D_1970489503 = (sm.comparator());
            } //End block
            return (Comparator<? super K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return sm.comparator();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.805 -0400", hash_original_method = "4A44F83861E496A35113DD67FECD390A", hash_generated_method = "6A90174B1BC2CB76A9D6742E86105F87")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public K firstKey() {
            {
                K var0B1470D61B8C6A68C7AB229BEA61F31E_1037160163 = (sm.firstKey());
            } //End block
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return sm.firstKey();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.805 -0400", hash_original_method = "758EF70CDC2061BD7D7B124D17EF3F64", hash_generated_method = "1B1ACEA5798420E299BE4106D34B1618")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedMap<K, V> headMap(K endKey) {
            dsTaint.addTaint(endKey.dsTaint);
            {
                SortedMap<K, V> var7A26954CB6FBB8853F179AAC3A9F4686_773170348 = (new SynchronizedSortedMap<K, V>(sm.headMap(endKey),
                        mutex));
            } //End block
            return (SortedMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedMap<K, V>(sm.headMap(endKey),
                        //mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.805 -0400", hash_original_method = "ECB924A52CC9F341D1EEB7E5D7BCCDC8", hash_generated_method = "1C39A0177F9AC9E333BE72649E9E80D7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public K lastKey() {
            {
                K var7B2CD408EC41D2035EDE4EA469E2194A_932562602 = (sm.lastKey());
            } //End block
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return sm.lastKey();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.805 -0400", hash_original_method = "E82E6227AA62F00EB1D33B47A72F41C4", hash_generated_method = "7A2F98766535726BA88CCC98B8572C78")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedMap<K, V> subMap(K startKey, K endKey) {
            dsTaint.addTaint(endKey.dsTaint);
            dsTaint.addTaint(startKey.dsTaint);
            {
                SortedMap<K, V> var78669850D4141AD418B91306E95EF040_1027102316 = (new SynchronizedSortedMap<K, V>(sm.subMap(startKey,
                        endKey), mutex));
            } //End block
            return (SortedMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedMap<K, V>(sm.subMap(startKey,
                        //endKey), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.805 -0400", hash_original_method = "F7B84D714F16D295C7D43C8AA5E52D6A", hash_generated_method = "8631161189021A2C1449B12105BC6D84")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedMap<K, V> tailMap(K startKey) {
            dsTaint.addTaint(startKey.dsTaint);
            {
                SortedMap<K, V> varB8FFAC01CC3EFAB07B9BE216D054FA49_640276803 = (new SynchronizedSortedMap<K, V>(sm.tailMap(startKey),
                        mutex));
            } //End block
            return (SortedMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedMap<K, V>(sm.tailMap(startKey),
                        //mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.805 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "6001D7B256B91F08C850EFC8421AA226")
        @DSModeled(DSC.SAFE)
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

        
    }


    
    static class SynchronizedSortedSet<E> extends SynchronizedSet<E> implements SortedSet<E> {
        private static final long serialVersionUID = 8695801310862127406L;
        private final SortedSet<E> ss;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.805 -0400", hash_original_method = "B2F0E775DF29B0E6B28447766B0AA532", hash_generated_method = "5987A3D9286F010FF2A9B19B86F8A1BD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SynchronizedSortedSet(SortedSet<E> set) {
            super(set);
            dsTaint.addTaint(set.dsTaint);
            // ---------- Original Method ----------
            //ss = set;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.805 -0400", hash_original_method = "46957450EFA60C06BEFC5742F9BFAC78", hash_generated_method = "AD36C2F291DBB1191783901C5A344D0C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SynchronizedSortedSet(SortedSet<E> set, Object mutex) {
            super(set, mutex);
            dsTaint.addTaint(mutex.dsTaint);
            dsTaint.addTaint(set.dsTaint);
            // ---------- Original Method ----------
            //ss = set;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.806 -0400", hash_original_method = "D71F7DA0E84FA7A091B4017D559410C5", hash_generated_method = "6BEAD36353837C107C86B5C0E98AF4C1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Comparator<? super E> comparator() {
            {
                Comparator<? super E> var07F86D8CCDDD798A45018D2AA9A359B8_92429761 = (ss.comparator());
            } //End block
            return (Comparator<? super E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return ss.comparator();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.806 -0400", hash_original_method = "C2C55C7E331CFDE8E84B8FC74FDABE02", hash_generated_method = "476548C1AB2D5B75E1EDD2383110363D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E first() {
            {
                E var89000B20893EE4C394CCC342448E11A0_1636743624 = (ss.first());
            } //End block
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return ss.first();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.806 -0400", hash_original_method = "86DA75392AF50D6AE53AEE4A4052EBA8", hash_generated_method = "1E567EB8904E9A69CC99F1035A7EBB48")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedSet<E> headSet(E end) {
            dsTaint.addTaint(end.dsTaint);
            {
                SortedSet<E> varB346FB35B6D1C44194007A04DD623FE8_1090362628 = (new SynchronizedSortedSet<E>(ss.headSet(end), mutex));
            } //End block
            return (SortedSet<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedSet<E>(ss.headSet(end), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.806 -0400", hash_original_method = "3C10DA3BCCE6BED4EBD1F6A2C6BC8438", hash_generated_method = "EF88302BED0ABEE53BF6285D1EE58F35")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E last() {
            {
                E varD2F8215971D155E32BF00B454EA993B4_2110477823 = (ss.last());
            } //End block
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return ss.last();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.806 -0400", hash_original_method = "662A59FFAA1C1722D75A374EC93FB0DF", hash_generated_method = "384DA3C3FC241BEBCE0D4DCAA9D279BC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedSet<E> subSet(E start, E end) {
            dsTaint.addTaint(start.dsTaint);
            dsTaint.addTaint(end.dsTaint);
            {
                SortedSet<E> var8DA8E4859BA4DEDDCDC044FDF09D00F9_664507395 = (new SynchronizedSortedSet<E>(ss.subSet(start, end),
                        mutex));
            } //End block
            return (SortedSet<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedSet<E>(ss.subSet(start, end),
                        //mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.806 -0400", hash_original_method = "4C04840896A126B8B17AD8E0926A5B00", hash_generated_method = "9BFCCD6D62D245674AA492998CBB5F96")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedSet<E> tailSet(E start) {
            dsTaint.addTaint(start.dsTaint);
            {
                SortedSet<E> varABD07F26D21362C979BC33EB496AF068_1364949094 = (new SynchronizedSortedSet<E>(ss.tailSet(start), mutex));
            } //End block
            return (SortedSet<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedSet<E>(ss.tailSet(start), mutex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.806 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "6001D7B256B91F08C850EFC8421AA226")
        @DSModeled(DSC.SAFE)
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

        
    }


    
    private static class UnmodifiableCollection<E> implements Collection<E>, Serializable {
        private static final long serialVersionUID = 1820017752578914078L;
        final Collection<E> c;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.806 -0400", hash_original_method = "0B21B3311CB87F81844FA591591A704A", hash_generated_method = "80B1011CB907D82DB2358BEE37382326")
        @DSModeled(DSC.SAFE)
         UnmodifiableCollection(Collection<E> collection) {
            dsTaint.addTaint(collection.dsTaint);
            // ---------- Original Method ----------
            //c = collection;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.806 -0400", hash_original_method = "1E7EFCC2BAD401EE702FAECD906F0B57", hash_generated_method = "6BE5354F15D77EC3BA45EA657A9467BA")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean add(E object) {
            dsTaint.addTaint(object.dsTaint);
            throw new UnsupportedOperationException();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.806 -0400", hash_original_method = "A14B246F22D65FADC1A66C9C0851763B", hash_generated_method = "B09B39596A304BA06F03A0C4E4A1B257")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean addAll(Collection<? extends E> collection) {
            dsTaint.addTaint(collection.dsTaint);
            throw new UnsupportedOperationException();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.806 -0400", hash_original_method = "C5BE2B5F9D582C4EED1DC0880E8741A1", hash_generated_method = "E59C38A84382DD4D32BB293C8BC8255C")
        @DSModeled(DSC.SAFE)
        @Override
        public void clear() {
            throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.806 -0400", hash_original_method = "9A5FA57B69BAE7BFE0B020704235C788", hash_generated_method = "7127DBEDA691CE2CDE11CA2C13671141")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean contains(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean var57979CEAB3B2144CFD864D01F9E7B4FE_860022108 = (c.contains(object));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c.contains(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.806 -0400", hash_original_method = "BD1B4CD05BF6E123B0DC6FD003A6020C", hash_generated_method = "DB8DCB9482E76F71B241AAF7C2884DE9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            boolean varF92105B68CE9F70CF43B3142D405452C_315640937 = (c.containsAll(collection));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c.containsAll(collection);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.806 -0400", hash_original_method = "F9A3CB1FB7570D28EBE20660E2FC6F42", hash_generated_method = "A5BA40330F8A6D09E00B6F5672BE7A94")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean isEmpty() {
            boolean var528EAD02A70F822F393BB0C54FBB923C_1777711958 = (c.isEmpty());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.806 -0400", hash_original_method = "57C2B30126E9906DFFF70EEB2D2CD18D", hash_generated_method = "6506BC8D5D9EAAD432A1B285E2DB107E")
        @DSModeled(DSC.SAFE)
        @Override
        public Iterator<E> iterator() {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.806 -0400", hash_original_method = "2165C77F20F5DBDDE4D0AED313262684", hash_generated_method = "8C6FD4F70961468DAA6FA0CF27442E53")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean remove(Object object) {
            dsTaint.addTaint(object.dsTaint);
            throw new UnsupportedOperationException();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.806 -0400", hash_original_method = "95D6D7B80D3C762A794FEAFDE42B30FC", hash_generated_method = "955A0397A2F91676AC0871CD34C9AE42")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean removeAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            throw new UnsupportedOperationException();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.806 -0400", hash_original_method = "D4789A90B422D35C3FC475A0D6C54BE8", hash_generated_method = "8FED39DB0F5460DE8677A3715D9FE238")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean retainAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            throw new UnsupportedOperationException();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.806 -0400", hash_original_method = "AC97C28F724592ABA809E2470D95C119", hash_generated_method = "EAA3D826F9D62A529BFD25518AC1C10A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int size() {
            int varC247C84593AA6020ED979B19566D13FE_795855403 = (c.size());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return c.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.807 -0400", hash_original_method = "89D7D02A9D2BDF31E775C08108CBDE5B", hash_generated_method = "DA89445BE4769485F34AFCE363501B09")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Object[] toArray() {
            Object[] var62B66AF92E26C05B85793C43631A5670_581952697 = (c.toArray());
            return (Object[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return c.toArray();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.807 -0400", hash_original_method = "D5913A45F2385B9A173BEEED47EA354F", hash_generated_method = "AB77E9C7E6E587A405CB258CD58CA020")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public <T> T[] toArray(T[] array) {
            dsTaint.addTaint(array.dsTaint);
            T[] var3310A58999EA63E27B96F5B99AFAAFE8_1986922744 = (c.toArray(array));
            return (T[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return c.toArray(array);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.807 -0400", hash_original_method = "424D4966F358AE6553349A6493C21674", hash_generated_method = "EE90B8D1E2A37A7A38BEFEF5E77BF45B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            String var864CC0AEC1F50182F68F1C735FD8AA5D_264262135 = (c.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return c.toString();
        }

        
    }


    
    private static class UnmodifiableRandomAccessList<E> extends UnmodifiableList<E> implements RandomAccess {
        private static final long serialVersionUID = -2542308836966382001L;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.807 -0400", hash_original_method = "0A20B358F7BA1E60AD6DE80ADB85C324", hash_generated_method = "A96D994A481491761A5028B806B54AF9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         UnmodifiableRandomAccessList(List<E> l) {
            super(l);
            dsTaint.addTaint(l.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.807 -0400", hash_original_method = "BFD692E8EF2A50E82DD6BA0EC7051578", hash_generated_method = "F7D7C5869ACC3AAA7DEE62C1AEBF48F6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public List<E> subList(int start, int end) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(end);
            List<E> varE81752721CA68FB0892933359A043348_1659815600 = (new UnmodifiableRandomAccessList<E>(list.subList(start, end)));
            return (List<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UnmodifiableRandomAccessList<E>(list.subList(start, end));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.807 -0400", hash_original_method = "C39E6F512687738DD8D987CDE63A2838", hash_generated_method = "C4B3A3F66C5D4A8E6CF2C83B5656BFDE")
        @DSModeled(DSC.SAFE)
        private Object writeReplace() {
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UnmodifiableList<E>(list);
        }

        
    }


    
    private static class UnmodifiableList<E> extends UnmodifiableCollection<E> implements List<E> {
        private static final long serialVersionUID = -283967356065247728L;
        final List<E> list;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.807 -0400", hash_original_method = "4CB96388E36B825DE711E2E59A893E0D", hash_generated_method = "FFAF02DD659C9257C95875AB10D93C61")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         UnmodifiableList(List<E> l) {
            super(l);
            dsTaint.addTaint(l.dsTaint);
            // ---------- Original Method ----------
            //list = l;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.807 -0400", hash_original_method = "CE54A57EF9628E9FD413F964E9F93054", hash_generated_method = "A3866508A1552A99AFE06923A7C95695")
        @DSModeled(DSC.SAFE)
        @Override
        public void add(int location, E object) {
            dsTaint.addTaint(location);
            dsTaint.addTaint(object.dsTaint);
            throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.807 -0400", hash_original_method = "6CD19404B4901DECE5B6F72EB7D0CD8F", hash_generated_method = "EE2ED22BBFBA8CF2D0E3186047B62A66")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean addAll(int location, Collection<? extends E> collection) {
            dsTaint.addTaint(location);
            dsTaint.addTaint(collection.dsTaint);
            throw new UnsupportedOperationException();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.807 -0400", hash_original_method = "C3C1892342CAEB152D9191558B893ACD", hash_generated_method = "3DBEB3742AF1BE137C7EE2D781E7854B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean var983E353D0DFE7FD02AAEFC303F168456_1811886237 = (list.equals(object));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return list.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.807 -0400", hash_original_method = "DFB24286AA0C5C6BF58031CA4ED7CDCB", hash_generated_method = "607EB30AA8F54A69706DA096233DCA6B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E get(int location) {
            dsTaint.addTaint(location);
            E var04271A4486C85B4131CB7C5CE1827D34_1401051711 = (list.get(location));
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return list.get(location);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.807 -0400", hash_original_method = "8FDA3E2E38E99F5D6FC34E94E92E953F", hash_generated_method = "60D829A22F29B8E8D255099DFB1D6CD3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int var9A1610964D862FF54E00A16E6D7BD291_104230209 = (list.hashCode());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return list.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.807 -0400", hash_original_method = "E8AAF2C874038C363BF8C80F2A4ED8F2", hash_generated_method = "283FBFCB26CABBCC8F70F6431A08B183")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int indexOf(Object object) {
            dsTaint.addTaint(object.dsTaint);
            int var77BCF240B74578A0DBB7E15170347534_1330293589 = (list.indexOf(object));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return list.indexOf(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.807 -0400", hash_original_method = "658C7926C6DFF1B86F4D9B6B0E3F5BBD", hash_generated_method = "A65DC66F80B8CA90CDDD4EE14630D0E3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int lastIndexOf(Object object) {
            dsTaint.addTaint(object.dsTaint);
            int var158B58B87F16034A803BFB0430AFCD59_568291158 = (list.lastIndexOf(object));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return list.lastIndexOf(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.807 -0400", hash_original_method = "DF7BE0B13ABC5A9B1C74313BD06FB64C", hash_generated_method = "878B934B15FA9BB1EA7A2BD25E3D2961")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public ListIterator<E> listIterator() {
            ListIterator<E> var4B5B2DE28169C2BFBA180BAF54B9EB3E_983792209 = (listIterator(0));
            return (ListIterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return listIterator(0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.807 -0400", hash_original_method = "1D0E6831E50FA8995D23240A6E091C82", hash_generated_method = "DBF5D04F8B31FE376E9A10A7512674CA")
        @DSModeled(DSC.SAFE)
        @Override
        public ListIterator<E> listIterator(final int location) {
            dsTaint.addTaint(location);
            return (ListIterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.807 -0400", hash_original_method = "5388D372D048D053ADD084F02A9C1484", hash_generated_method = "EE4AE19434747A1F481E3A3EF9C2C63B")
        @DSModeled(DSC.SAFE)
        @Override
        public E remove(int location) {
            dsTaint.addTaint(location);
            throw new UnsupportedOperationException();
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.807 -0400", hash_original_method = "8830E2F07CC294339D5D496574BCFA5E", hash_generated_method = "3DD7F23FFE9DB8DDD9A22A8A567D39B6")
        @DSModeled(DSC.SAFE)
        @Override
        public E set(int location, E object) {
            dsTaint.addTaint(location);
            dsTaint.addTaint(object.dsTaint);
            throw new UnsupportedOperationException();
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.807 -0400", hash_original_method = "82D78FB8922B9A0888EF8A304898D60D", hash_generated_method = "031DD6E246EE67B77980187BC7B83D09")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public List<E> subList(int start, int end) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(end);
            List<E> var484C55B6D971B995E35583CF642ED457_1983240427 = (new UnmodifiableList<E>(list.subList(start, end)));
            return (List<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UnmodifiableList<E>(list.subList(start, end));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.808 -0400", hash_original_method = "5F3DDA40E6BDC67502A2E43BA75DBB15", hash_generated_method = "F730E915E9BE2FED7BC3A9310834D39A")
        @DSModeled(DSC.SAFE)
        private Object readResolve() {
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (list instanceof RandomAccess) {
                //return new UnmodifiableRandomAccessList<E>(list);
            //}
            //return this;
        }

        
    }


    
    private static class UnmodifiableMap<K, V> implements Map<K, V>, Serializable {
        private static final long serialVersionUID = -1034234728574286014L;
        private final Map<K, V> m;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.808 -0400", hash_original_method = "74C4A0289A3E9196E4EF75F76384A7D2", hash_generated_method = "3432E276797EB26AFE57E72BF647BDF2")
        @DSModeled(DSC.SAFE)
         UnmodifiableMap(Map<K, V> map) {
            dsTaint.addTaint(map.dsTaint);
            // ---------- Original Method ----------
            //m = map;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.808 -0400", hash_original_method = "C5BE2B5F9D582C4EED1DC0880E8741A1", hash_generated_method = "E59C38A84382DD4D32BB293C8BC8255C")
        @DSModeled(DSC.SAFE)
        @Override
        public void clear() {
            throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.808 -0400", hash_original_method = "A6C730848D8A626F99D8229EE744E3C0", hash_generated_method = "ED062AB4CF493FF9EB5D3E51D1D2370B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsKey(Object key) {
            dsTaint.addTaint(key.dsTaint);
            boolean var2519B7EF565FEC21B6285F5E44AC148E_1845456655 = (m.containsKey(key));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return m.containsKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.808 -0400", hash_original_method = "EF8C00CF950E8C186D2F05E1E556F384", hash_generated_method = "89448001129D0297045E83EC577B35F8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsValue(Object value) {
            dsTaint.addTaint(value.dsTaint);
            boolean varF8CB74E2C5E0734947B397D82173BDD4_2000725118 = (m.containsValue(value));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return m.containsValue(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.808 -0400", hash_original_method = "FB0DE15DA25D3994421C9FBDD1812EDD", hash_generated_method = "58C750654776BB2846F961C5FD03D355")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> varE7CF0764559CBDA696603C1B9F083963_240959663 = (new UnmodifiableEntrySet<K, V>(m.entrySet()));
            return (Set<Map.Entry<K, V>>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UnmodifiableEntrySet<K, V>(m.entrySet());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.808 -0400", hash_original_method = "CE201E78EAC5D1903F741160CB297EAE", hash_generated_method = "42C7115DE9121C776965469393D1107E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean var9745819ACBF7C47D9CAE10D95AB26047_475244405 = (m.equals(object));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return m.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.808 -0400", hash_original_method = "B8FE254B61C57EC3A6DCE539976DA268", hash_generated_method = "A7A1CBFC53F05439FB5F5869DA3EE9C1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public V get(Object key) {
            dsTaint.addTaint(key.dsTaint);
            V var3CE9B05179DCB2168B5F27445CBC5B28_340043398 = (m.get(key));
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return m.get(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.808 -0400", hash_original_method = "E3229E3389F030DD50B79734943DB788", hash_generated_method = "6D55CCA0F61311C32063B9E9D678315D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int varAA1293165230C9829C1AEACFFF576DFC_1959547264 = (m.hashCode());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return m.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.808 -0400", hash_original_method = "B9E63D3C52241E7E917CB1416ABA36E5", hash_generated_method = "C60D4412716D9FF097F6DA2E6AC6A888")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean isEmpty() {
            boolean var028CF644E61B84328EAB66D556672A81_189655554 = (m.isEmpty());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return m.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.808 -0400", hash_original_method = "2CC049F262DAAA6660AF161E9C8606F6", hash_generated_method = "29742B7F87F9CB3F9418D18EF978D720")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Set<K> keySet() {
            Set<K> var8D40E1914E5CD510283210347B84C9D0_664749668 = (new UnmodifiableSet<K>(m.keySet()));
            return (Set<K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UnmodifiableSet<K>(m.keySet());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.808 -0400", hash_original_method = "1AE25A34BEB4A8F08F41373ADFFCFE34", hash_generated_method = "1C71CFD8F9ECFAAF375960086FF493F8")
        @DSModeled(DSC.SAFE)
        @Override
        public V put(K key, V value) {
            dsTaint.addTaint(value.dsTaint);
            dsTaint.addTaint(key.dsTaint);
            throw new UnsupportedOperationException();
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.808 -0400", hash_original_method = "1D605566C28BBD06FDC515389557B406", hash_generated_method = "008458D67559BE6B5E501E6E85A56F09")
        @DSModeled(DSC.SAFE)
        @Override
        public void putAll(Map<? extends K, ? extends V> map) {
            dsTaint.addTaint(map.dsTaint);
            throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.808 -0400", hash_original_method = "1F8D4C123F3DDBF68E61E38EDB13F5FB", hash_generated_method = "50493F2564190F720EBF0586F994F0AF")
        @DSModeled(DSC.SAFE)
        @Override
        public V remove(Object key) {
            dsTaint.addTaint(key.dsTaint);
            throw new UnsupportedOperationException();
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.808 -0400", hash_original_method = "A04EE09DEB6F21FAA6A7E10DF6401CD1", hash_generated_method = "3585279140B78E3E2AFEBA348AC394BF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int size() {
            int varDBD6E28F15F3D13B8127CF62DD69ACD5_2027015560 = (m.size());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return m.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.808 -0400", hash_original_method = "19DD84E0D2EBBBC2FCDA12D023824450", hash_generated_method = "C18C2CF4744DA1E442FDC953956310EA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Collection<V> values() {
            Collection<V> varDEC91ADE25563BA976B08F7B41617CEC_1532351066 = (new UnmodifiableCollection<V>(m.values()));
            return (Collection<V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UnmodifiableCollection<V>(m.values());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.808 -0400", hash_original_method = "5DD44B3CD2826BF39F974F66579CF74F", hash_generated_method = "5DDAA6DE029B59C493CAA0661DE24068")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            String var7BAD0880B86D95365972142C036695CB_2068363016 = (m.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return m.toString();
        }

        
        private static class UnmodifiableEntrySet<K, V> extends UnmodifiableSet<Map.Entry<K, V>> {
            private static final long serialVersionUID = 7854390611657943733L;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.808 -0400", hash_original_method = "211DEE98878E4422E2F38E79CDC5F0D4", hash_generated_method = "47A19A9E7FD1D7831CA027AD146EC331")
            //DSFIXME:  CODE0002: Requires DSC value to be set
             UnmodifiableEntrySet(Set<Map.Entry<K, V>> set) {
                super(set);
                dsTaint.addTaint(set.dsTaint);
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.808 -0400", hash_original_method = "53A7F61EDA7A64FBCB28AE61A8906002", hash_generated_method = "1AFF48D160AF3ED5DB3A2D828BDC4015")
            @DSModeled(DSC.SAFE)
            @Override
            public Iterator<Map.Entry<K, V>> iterator() {
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.808 -0400", hash_original_method = "C353E5DD4879B90DAE1A37DDC4A8ED8C", hash_generated_method = "BC1D4B3D7750FB48CFEB2CD3031AE50D")
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.809 -0400", hash_original_method = "CB9686BEA448DC0D7D0077DDEB1917CB", hash_generated_method = "3CC5F42D29BED8F47175705C0F7EA762")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @SuppressWarnings("unchecked")
            @Override
            public <T> T[] toArray(T[] contents) {
                dsTaint.addTaint(contents.dsTaint);
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
                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.809 -0400", hash_original_method = "E37A4627FD27E632126EED134E00D831", hash_generated_method = "A0EF7E8338A715743B22982431056C29")
                @DSModeled(DSC.SAFE)
                 UnmodifiableMapEntry(Map.Entry<K, V> entry) {
                    dsTaint.addTaint(entry.dsTaint);
                    // ---------- Original Method ----------
                    //mapEntry = entry;
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.809 -0400", hash_original_method = "90F914E663E54C2DC9846974DAA2EFB8", hash_generated_method = "4A31F56BF404F54B00B62BC35B31BF77")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public boolean equals(Object object) {
                    dsTaint.addTaint(object.dsTaint);
                    boolean var1E6E5EE1426DD4D6EB65B99B916F7467_2104383977 = (mapEntry.equals(object));
                    return dsTaint.getTaintBoolean();
                    // ---------- Original Method ----------
                    //return mapEntry.equals(object);
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.809 -0400", hash_original_method = "4DDB57034C15C2636BC5A8AFB2B3C75A", hash_generated_method = "929FB0CB76FEA7BA3E50C48B0009CA7C")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public K getKey() {
                    K var25C1A8C49B018B5E1039568C6A58A77E_119531690 = (mapEntry.getKey());
                    return (K)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //return mapEntry.getKey();
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.809 -0400", hash_original_method = "EA1063FCD9D2F699A9610E0A7FDC81FD", hash_generated_method = "0DA256534ED899B18E69B82CFB258603")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public V getValue() {
                    V var3A71A2C40C9A5E4B4A7FD2824BA056D3_1085062111 = (mapEntry.getValue());
                    return (V)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //return mapEntry.getValue();
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.809 -0400", hash_original_method = "8A31FFFC42BCA6E359386EC1F8534D45", hash_generated_method = "C422CB7A4BA977CAC1300DD83CFB0170")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public int hashCode() {
                    int varB4446261767782D97888D65AE62449D4_608168399 = (mapEntry.hashCode());
                    return dsTaint.getTaintInt();
                    // ---------- Original Method ----------
                    //return mapEntry.hashCode();
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.809 -0400", hash_original_method = "3526712C126765AF36CB8D920CBD3B1B", hash_generated_method = "839A6E1BD9159A88C50C1D3D4163507C")
                @DSModeled(DSC.SAFE)
                @Override
                public V setValue(V object) {
                    dsTaint.addTaint(object.dsTaint);
                    throw new UnsupportedOperationException();
                    return (V)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //throw new UnsupportedOperationException();
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.809 -0400", hash_original_method = "514C7E8B8C54DBFDFB3E185BADD6AD0A", hash_generated_method = "1844E7D335892EA8F1BC77BB5CC37866")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public String toString() {
                    String var23D4CB5286AA9BCD0B2722DA3B72340B_2034961282 = (mapEntry.toString());
                    return dsTaint.getTaintString();
                    // ---------- Original Method ----------
                    //return mapEntry.toString();
                }

                
            }


            
        }


        
    }


    
    private static class UnmodifiableSet<E> extends UnmodifiableCollection<E> implements Set<E> {
        private static final long serialVersionUID = -9215047833775013803L;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.809 -0400", hash_original_method = "D46A71F25EF02541A08678630568218D", hash_generated_method = "737102E62EAB8335F4D8B503C28B28CF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         UnmodifiableSet(Set<E> set) {
            super(set);
            dsTaint.addTaint(set.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.809 -0400", hash_original_method = "BB8664F3F5CB90AA83689CAADCD9EA6B", hash_generated_method = "836A11022B23E323DC143FC87CD1FA41")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean var68E706348FF72E55282D2AEF4301CA4B_1034781937 = (c.equals(object));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.809 -0400", hash_original_method = "E858D80F3EEDE9F2B52CDB7DA7FBF12B", hash_generated_method = "D706111CBA2E7B9C6298134E9FD6F993")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int var19B3D08FE3840D0D3E365DF71EF3E20C_1467287357 = (c.hashCode());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return c.hashCode();
        }

        
    }


    
    private static class UnmodifiableSortedMap<K, V> extends UnmodifiableMap<K, V> implements SortedMap<K, V> {
        private static final long serialVersionUID = -8806743815996713206L;
        private final SortedMap<K, V> sm;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.809 -0400", hash_original_method = "AC9FE01B421B1E54651959AD61521CA6", hash_generated_method = "F7FC3AC1069CC00C4D5DF11AFFA87B62")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         UnmodifiableSortedMap(SortedMap<K, V> map) {
            super(map);
            dsTaint.addTaint(map.dsTaint);
            // ---------- Original Method ----------
            //sm = map;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.809 -0400", hash_original_method = "E5FDBCC6560BE7E99B2D2F850BD84149", hash_generated_method = "9208F2498CE95103706D687CB5BD08D1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Comparator<? super K> comparator() {
            Comparator<? super K> var422223D82196DD3FC2DC6264D5B430C5_580984157 = (sm.comparator());
            return (Comparator<? super K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return sm.comparator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.809 -0400", hash_original_method = "B25E8C7440C76FBF812FF7AC9CA9D776", hash_generated_method = "C01198792D730EE083C715E993586F6B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public K firstKey() {
            K var27D52CE4EA4B74D34E8381D333AAE9A4_1272470296 = (sm.firstKey());
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return sm.firstKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.809 -0400", hash_original_method = "EC6243B190269A05D31802D1260652E4", hash_generated_method = "DAB3A41B4315332083D8F77F6C736CCF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedMap<K, V> headMap(K before) {
            dsTaint.addTaint(before.dsTaint);
            SortedMap<K, V> varCA3E385D4E8CD095E0D16C9130E8F327_1401592541 = (new UnmodifiableSortedMap<K, V>(sm.headMap(before)));
            return (SortedMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UnmodifiableSortedMap<K, V>(sm.headMap(before));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.809 -0400", hash_original_method = "00E9126A84DE8B71214859A17DA6BD2E", hash_generated_method = "B1D5A7CC76224064219AACD92C6E4F9B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public K lastKey() {
            K var9F9AE843A8A54EC3D9E8230A61FB8B04_1744331988 = (sm.lastKey());
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return sm.lastKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.810 -0400", hash_original_method = "B6411009D9179ABF4D7755605B648FDC", hash_generated_method = "8CA735441A58C18096FBAC456B34AD8E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedMap<K, V> subMap(K start, K end) {
            dsTaint.addTaint(start.dsTaint);
            dsTaint.addTaint(end.dsTaint);
            SortedMap<K, V> var00249249156058E6EE273C54B70BBAB5_1295375479 = (new UnmodifiableSortedMap<K, V>(sm.subMap(start, end)));
            return (SortedMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UnmodifiableSortedMap<K, V>(sm.subMap(start, end));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.810 -0400", hash_original_method = "59BADF6C5EE68C4E1DB5A6A22818328A", hash_generated_method = "C0497C0698D17D87F45070DE80D5803F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedMap<K, V> tailMap(K after) {
            dsTaint.addTaint(after.dsTaint);
            SortedMap<K, V> varB68C4B7747A55CAD7AAABD39E9B461EE_1469582804 = (new UnmodifiableSortedMap<K, V>(sm.tailMap(after)));
            return (SortedMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UnmodifiableSortedMap<K, V>(sm.tailMap(after));
        }

        
    }


    
    private static class UnmodifiableSortedSet<E> extends UnmodifiableSet<E> implements SortedSet<E> {
        private static final long serialVersionUID = -4929149591599911165L;
        private final SortedSet<E> ss;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.810 -0400", hash_original_method = "232C45C3B4117EB9042FB58E6C0CE113", hash_generated_method = "311A55703B4AE62BAA7EE624745C04C4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         UnmodifiableSortedSet(SortedSet<E> set) {
            super(set);
            dsTaint.addTaint(set.dsTaint);
            // ---------- Original Method ----------
            //ss = set;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.810 -0400", hash_original_method = "8514D9255D678B041F55D03BA11DCA3B", hash_generated_method = "E75C1CFF2AA4CDA5F8CBEDBC297D73AE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Comparator<? super E> comparator() {
            Comparator<? super E> var05CAB94F8BD11820A94AC68A790A80A5_702902754 = (ss.comparator());
            return (Comparator<? super E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ss.comparator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.810 -0400", hash_original_method = "6BB6C51843B41CC0DCB5509A79DBA008", hash_generated_method = "29BDFA389C5F9A7DB266D4C435FAC6E8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E first() {
            E varCAE51BE1E9DF20269B81A1FDC8990752_373494009 = (ss.first());
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ss.first();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.810 -0400", hash_original_method = "74C4BE29898589F7D7948BADA3350612", hash_generated_method = "289E8B0FD830ACBCAE0C9F24E04BDAF4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedSet<E> headSet(E before) {
            dsTaint.addTaint(before.dsTaint);
            SortedSet<E> var9DB1950B5F2749043373128DC25BBF71_1392484613 = (new UnmodifiableSortedSet<E>(ss.headSet(before)));
            return (SortedSet<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UnmodifiableSortedSet<E>(ss.headSet(before));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.810 -0400", hash_original_method = "AAC5DDE787ACA85752B94AAB77F6B0F8", hash_generated_method = "643579EDC10B4EE830CDD99FC33A3D5F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E last() {
            E varB0B3C145EFB1EF3B95D9D987CE98A283_1618883660 = (ss.last());
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ss.last();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.810 -0400", hash_original_method = "54602835FD774439E48CB96CB67F9D83", hash_generated_method = "CC4594DA1605779281BAA98E323505BE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedSet<E> subSet(E start, E end) {
            dsTaint.addTaint(start.dsTaint);
            dsTaint.addTaint(end.dsTaint);
            SortedSet<E> var46D195260A644EE679FCB282DB396A37_891122912 = (new UnmodifiableSortedSet<E>(ss.subSet(start, end)));
            return (SortedSet<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UnmodifiableSortedSet<E>(ss.subSet(start, end));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.810 -0400", hash_original_method = "37640609DAC9C9170FD6CBE14C8AD6B6", hash_generated_method = "4D4A64923338500D7E4D2CA0F6D62FEA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedSet<E> tailSet(E after) {
            dsTaint.addTaint(after.dsTaint);
            SortedSet<E> varB747B94402EDDE06745C3B373FBEAAA8_419265662 = (new UnmodifiableSortedSet<E>(ss.tailSet(after)));
            return (SortedSet<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UnmodifiableSortedSet<E>(ss.tailSet(after));
        }

        
    }


    
    private static class SetFromMap<E> extends AbstractSet<E> implements Serializable {
        private static final long serialVersionUID = 2454657854757543876L;
        private Map<E, Boolean> m;
        private transient Set<E> backingSet;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.810 -0400", hash_original_method = "6B962D990E5B5543C1AA025E18134CE9", hash_generated_method = "BF1D765C697501CB46ECE71078EC7C10")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SetFromMap(final Map<E, Boolean> map) {
            dsTaint.addTaint(map.dsTaint);
            backingSet = map.keySet();
            // ---------- Original Method ----------
            //m = map;
            //backingSet = map.keySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.810 -0400", hash_original_method = "B42E9CA75A778919E90B77D794DBEE82", hash_generated_method = "BE4F10E731A09F82AF123F487A4A1E93")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean var1848766D38374CAEDBF00C0007CDCFC1_1763064133 = (backingSet.equals(object));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return backingSet.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.810 -0400", hash_original_method = "684F9CE738B21B1B45F3304124963EF1", hash_generated_method = "17B3146A1AD17AB67B860080FEB4F476")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int var061E95C5D32F56D095B7A80E91EC8A56_1761542727 = (backingSet.hashCode());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return backingSet.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.810 -0400", hash_original_method = "FC84A6CABB16433CF1488E03DF7636C8", hash_generated_method = "27A3D6571E60D44C5F957F6B95B087C8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean add(E object) {
            dsTaint.addTaint(object.dsTaint);
            boolean var8AF8A0D0EB560BBD1728F96A00026012_2088669610 = (m.put(object, Boolean.TRUE) == null);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return m.put(object, Boolean.TRUE) == null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.810 -0400", hash_original_method = "5163CA2ED3AD9C66F2BDAFB902590115", hash_generated_method = "3D07CBB638C6514CE20DA136AC64FDB0")
        @DSModeled(DSC.SAFE)
        @Override
        public void clear() {
            m.clear();
            // ---------- Original Method ----------
            //m.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.810 -0400", hash_original_method = "C7069F73CC2FBE59B42FACF6A3731192", hash_generated_method = "25270ACEBAA8A33973D38481BA06F994")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            String var76C2C76F9D113FCE27768A53C48C8DE4_958808741 = (backingSet.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return backingSet.toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.810 -0400", hash_original_method = "C1FDFEBBA860B6E21729D041F83BDE39", hash_generated_method = "D52D8846458F264DA2A83CCAAC00B5E6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean contains(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean varD69ECD74FC2F79EA60C338071C7FC221_666953919 = (backingSet.contains(object));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return backingSet.contains(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.810 -0400", hash_original_method = "652D3A93342A70291E00DB196A629050", hash_generated_method = "52C404657C4E3393E51BFB3D8B57429C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            boolean var3951AEBB2FFEF521655479A9D2D52542_1650589518 = (backingSet.containsAll(collection));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return backingSet.containsAll(collection);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.810 -0400", hash_original_method = "B9E63D3C52241E7E917CB1416ABA36E5", hash_generated_method = "CEEDE4325408260A5BFEBB4E64434F57")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean isEmpty() {
            boolean var028CF644E61B84328EAB66D556672A81_2108897614 = (m.isEmpty());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return m.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.810 -0400", hash_original_method = "20C696E59013C16BDFED7021A5C3E797", hash_generated_method = "78E194D7EA15D5233DE11BB2A94FA1A7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean remove(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean varEA834B1BBE47D90EDF860853CDE90683_1128815538 = (m.remove(object) != null);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return m.remove(object) != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.810 -0400", hash_original_method = "4A27ACEA2C9F194EF4597E8BDECC6BD7", hash_generated_method = "CE7CFC52A860F6CC735FE44D89EF921B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean retainAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            boolean varF15C5540B964CC478105DE5ACC25B10C_365751919 = (backingSet.retainAll(collection));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return backingSet.retainAll(collection);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.811 -0400", hash_original_method = "706FD57EC242D189F78C8F40D764E8D0", hash_generated_method = "D03F0FAF7A24817065AE344D863A3ADF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Object[] toArray() {
            Object[] varAAF6863E3FC284FF60465B89D611A453_1332252829 = (backingSet.toArray());
            return (Object[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return backingSet.toArray();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.811 -0400", hash_original_method = "5B684176C593DE73F99AF08724DF65D4", hash_generated_method = "0A9ADB20BDED4F7F8D2485A277FD1EF1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public <T> T[] toArray(T[] contents) {
            dsTaint.addTaint(contents.dsTaint);
            T[] var70E76BB3C7B4621B066FEAA9F9F6B3A3_1028103937 = (backingSet.toArray(contents));
            return (T[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return backingSet.toArray(contents);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.811 -0400", hash_original_method = "2EC39271104239DED882FB25EFF4BC23", hash_generated_method = "6FB6B8F765DCC50FA2A16B8360935024")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Iterator<E> iterator() {
            Iterator<E> var46A5BD0F9A39756579AFB4DF806B1772_1104147623 = (backingSet.iterator());
            return (Iterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return backingSet.iterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.811 -0400", hash_original_method = "A04EE09DEB6F21FAA6A7E10DF6401CD1", hash_generated_method = "365EA54523FD7696A267A79B9D607575")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int size() {
            int varDBD6E28F15F3D13B8127CF62DD69ACD5_539610431 = (m.size());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return m.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.811 -0400", hash_original_method = "8082AE1FFA2825B9433C3082C2F87EDC", hash_generated_method = "12FAA4DAD11AE53FB89BD8976C1F314C")
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

        
    }


    
    private static class AsLIFOQueue<E> extends AbstractQueue<E> implements Serializable {
        private static final long serialVersionUID = 1802017725587941708L;
        private final Deque<E> q;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.811 -0400", hash_original_method = "C9A3AEFCC3A9FEA0CFED796FADB14DA4", hash_generated_method = "A33813B5A05201CDFA91E1E126627558")
        @DSModeled(DSC.SAFE)
         AsLIFOQueue(final Deque<E> deque) {
            dsTaint.addTaint(deque.dsTaint);
            // ---------- Original Method ----------
            //this.q = deque;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.811 -0400", hash_original_method = "D6ABAC5AC9E31C28EFD449012F8C668D", hash_generated_method = "16C0E36F3B2F6D2A9BCDBAC362584E58")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Iterator<E> iterator() {
            Iterator<E> varFBE466EF8E63E9009A03F2C0F0CC80D2_247921693 = (q.iterator());
            return (Iterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return q.iterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.811 -0400", hash_original_method = "4D120CFD44D3EE91A03411EED1F5CA02", hash_generated_method = "59207B86F03E02091D0A75FE386B2CC0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int size() {
            int var8E6A4AAEA94D20962C54C20127D7D8DC_1073292740 = (q.size());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return q.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.811 -0400", hash_original_method = "A29AB2808D45581589F8B0269F283532", hash_generated_method = "9079FD893121B20986222829D670939B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean offer(E o) {
            dsTaint.addTaint(o.dsTaint);
            boolean var131D1A648D23B0B634478E3172B0A3D9_143756645 = (q.offerFirst(o));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return q.offerFirst(o);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.811 -0400", hash_original_method = "286FFABBC697C1CEE6C49194F85DD481", hash_generated_method = "1B3CCE4FC32772A500C60F59C1E876B3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E peek() {
            E var12F2B0EBA7C02287FFA76F3A50514FE3_1277609534 = (q.peekFirst());
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return q.peekFirst();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.811 -0400", hash_original_method = "93EF986205EA0EFDB6E2F2BDD9DDBDB0", hash_generated_method = "38BA45A306522A22EFC127B32D3E30A0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E poll() {
            E var513A54907E44074CF1873F435C9F7841_2076003351 = (q.pollFirst());
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return q.pollFirst();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.811 -0400", hash_original_method = "E16BCF0F708E6336497510D255228AB4", hash_generated_method = "52B6DC92C3D50047DC8BA6F7910E736C")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean add(E o) {
            dsTaint.addTaint(o.dsTaint);
            q.push(o);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //q.push(o);
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.811 -0400", hash_original_method = "ECF3C7555AB121202E1C39938D734656", hash_generated_method = "39D060DA43AA8AA99E75D005C15EE3F2")
        @DSModeled(DSC.SAFE)
        @Override
        public void clear() {
            q.clear();
            // ---------- Original Method ----------
            //q.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.811 -0400", hash_original_method = "41C0874A8589B77FE1309E3303509F6A", hash_generated_method = "098041F988164A7F5C4FDA70F4CCFB3F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E element() {
            E varA58C48EE56BDCF291271E8BA8F198C86_344883485 = (q.getFirst());
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return q.getFirst();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.811 -0400", hash_original_method = "DBCAD9866D0C084DC455BF7C95ABCE77", hash_generated_method = "19D3D88E77CD39AE4E8CDBDD2BFA640F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E remove() {
            E var21F03F473F531B5A86EF95513BFC64D5_1002697437 = (q.pop());
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return q.pop();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.811 -0400", hash_original_method = "2E730D7ABEE184A9C34DA57DF7A457EE", hash_generated_method = "090C7EDBC4A215656388888C908C66DD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean contains(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean varD460130636362755C09A666172F1A628_874749503 = (q.contains(object));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return q.contains(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.811 -0400", hash_original_method = "3E9E9A2983E74090844621EE9CF6D3D7", hash_generated_method = "2B8588F6F83A965845AA10366FEA6E85")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            boolean varDE8FC932F21B2025BA6D50595BD45CF0_428944523 = (q.containsAll(collection));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return q.containsAll(collection);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.811 -0400", hash_original_method = "3014069A2B40728BACBB472823CCCF21", hash_generated_method = "91DDEB85D9F6F8413E6A9BDF288369F0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean isEmpty() {
            boolean varFE3524B5D20384639CE6FC4B24FAEE92_2067649781 = (q.isEmpty());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return q.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.811 -0400", hash_original_method = "06C06D3351623BFF7BABDE8B40334F59", hash_generated_method = "B41D6DCB55D6FEFE3E9637A014273EB5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean remove(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean var430DB2157F91E84964C83805E66926D1_395103434 = (q.remove(object));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return q.remove(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.812 -0400", hash_original_method = "13975D6542267AD488C8D9B27A0905D7", hash_generated_method = "786EFA124A6FE1281183A8ED8C7493A1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean removeAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            boolean varA36A955574116D3C6092CC37D2496B72_1719538372 = (q.removeAll(collection));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return q.removeAll(collection);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.812 -0400", hash_original_method = "029F8EE40CDE382EFA7F7BF13B8FE731", hash_generated_method = "2FA83B5513A12870B536847C643D097F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean retainAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            boolean varF8C783496DD8D05EB5484CABE3DF69DA_1237372615 = (q.retainAll(collection));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return q.retainAll(collection);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.812 -0400", hash_original_method = "81809EBBF1D8298961C4E9B761FEF748", hash_generated_method = "EC92346CB650C07DD4979E0A4329177D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Object[] toArray() {
            Object[] varCA196E539CEA76D371684D96AE62C6BE_2065089604 = (q.toArray());
            return (Object[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return q.toArray();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.812 -0400", hash_original_method = "3C7918E789D95B2A97E0F45A2E8277E0", hash_generated_method = "85ADC51247341B10E5BE8DA2CFD14F44")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public <T> T[] toArray(T[] contents) {
            dsTaint.addTaint(contents.dsTaint);
            T[] varCD03EDBC00D159F43667C38BC995C07F_240979595 = (q.toArray(contents));
            return (T[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return q.toArray(contents);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.812 -0400", hash_original_method = "827F98847BB1D6CEA3B0A324A45F92ED", hash_generated_method = "C9461E1BA294C30CF505DCB84B4EC9D6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            String var8F4D867925AFF759292A393714F9299F_374299325 = (q.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return q.toString();
        }

        
    }


    
    private static class CheckedCollection<E> implements Collection<E>, Serializable {
        private static final long serialVersionUID = 1578914078182001775L;
        Collection<E> c;
        Class<E> type;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.812 -0400", hash_original_method = "4DAA5B7D63536360D367B6279A6FD0F0", hash_generated_method = "C8BA4D645A0D002242B37419565BD119")
        @DSModeled(DSC.SAFE)
        public CheckedCollection(Collection<E> c, Class<E> type) {
            dsTaint.addTaint(c.dsTaint);
            dsTaint.addTaint(type.dsTaint);
            {
                throw new NullPointerException();
            } //End block
            // ---------- Original Method ----------
            //if (c == null || type == null) {
                //throw new NullPointerException();
            //}
            //this.c = c;
            //this.type = type;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.812 -0400", hash_original_method = "AC97C28F724592ABA809E2470D95C119", hash_generated_method = "428301435C7C280C97E50075BF5138AA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int size() {
            int varC247C84593AA6020ED979B19566D13FE_361033357 = (c.size());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return c.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.812 -0400", hash_original_method = "F9A3CB1FB7570D28EBE20660E2FC6F42", hash_generated_method = "360C4486098A4E3B1A820D1D2C8EA081")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean isEmpty() {
            boolean var528EAD02A70F822F393BB0C54FBB923C_1285445993 = (c.isEmpty());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.812 -0400", hash_original_method = "AA502F510015E56A50E854673F52B13D", hash_generated_method = "2E6FFBE59E4CE923E62E00C00F1C84E0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean contains(Object obj) {
            dsTaint.addTaint(obj.dsTaint);
            boolean var9701AC7B8B31DABE176EC8837E090033_2057388812 = (c.contains(obj));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c.contains(obj);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.812 -0400", hash_original_method = "A49A579D720F57F247BFFB420B912FC7", hash_generated_method = "64FAFC88C1CE6CA1AE51F5DAF5D821B8")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.812 -0400", hash_original_method = "89D7D02A9D2BDF31E775C08108CBDE5B", hash_generated_method = "8D3DA690E8F93E2B8627279130B7CB32")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Object[] toArray() {
            Object[] var62B66AF92E26C05B85793C43631A5670_1413506821 = (c.toArray());
            return (Object[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return c.toArray();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.812 -0400", hash_original_method = "9B8166862C116AE305DE64E80811892F", hash_generated_method = "D021CB468B6B13EBEE3238B580D5D101")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public <T> T[] toArray(T[] arr) {
            dsTaint.addTaint(arr.dsTaint);
            T[] var375DD56257BE0288EB32DA2FC3FEC3BC_315411968 = (c.toArray(arr));
            return (T[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return c.toArray(arr);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.812 -0400", hash_original_method = "233202E3883C87159328A7DF45C5A0DD", hash_generated_method = "8E71EA2B5FF0AA029241E1D3AB57AFC2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean add(E obj) {
            dsTaint.addTaint(obj.dsTaint);
            boolean var7C3742253C6BF2735A6EB74A5190709F_2038426244 = (c.add(checkType(obj, type)));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c.add(checkType(obj, type));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.812 -0400", hash_original_method = "A7C1CDA142B015DD1AAB47325584260A", hash_generated_method = "C2DCEF5AE79B8AC42EA560F2DACF17AF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean remove(Object obj) {
            dsTaint.addTaint(obj.dsTaint);
            boolean varA24294D934B215AF55F3D7CE5097D547_1176967780 = (c.remove(obj));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c.remove(obj);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.812 -0400", hash_original_method = "8A54483E259CA6D3C8AB1EBE7493D296", hash_generated_method = "AF4188BE6EDB78F6ACAC4E5FE46F839D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsAll(Collection<?> c1) {
            dsTaint.addTaint(c1.dsTaint);
            boolean varFFF4D0CC6EA0E1A2D080D41D81BC6C1F_1772950301 = (c.containsAll(c1));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c.containsAll(c1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.812 -0400", hash_original_method = "A2391F235E9474A0C2FADB6F2C5C2AB0", hash_generated_method = "98402352430E3328AA01912F97D5D791")
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
            boolean var4F43D86A78906FAA31F77A4D0C40B6E3_1455479997 = (c.addAll((List<E>) Arrays.asList(array)));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //Object[] array = c1.toArray();
            //for (Object o : array) {
                //checkType(o, type);
            //}
            //return c.addAll((List<E>) Arrays.asList(array));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.812 -0400", hash_original_method = "E5A4F3F5A50F475A125F07680365C964", hash_generated_method = "DE1A1672209D994E88D87A7260885294")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean removeAll(Collection<?> c1) {
            dsTaint.addTaint(c1.dsTaint);
            boolean var6FAA02017CB91A1460E8557E32B16FBC_1374434296 = (c.removeAll(c1));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c.removeAll(c1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.813 -0400", hash_original_method = "2CCBBE73D1665A80965D3FA8CB644A3B", hash_generated_method = "634876AC98EA672ECD43AA198233FD3D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean retainAll(Collection<?> c1) {
            dsTaint.addTaint(c1.dsTaint);
            boolean var1BAABDC5B6ADB4CC0AE277B58A4293BA_365455083 = (c.retainAll(c1));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c.retainAll(c1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.813 -0400", hash_original_method = "C75B179C04D460F62AB7F39D0D292067", hash_generated_method = "B7255833352F8FF19704A021FC35B60E")
        @DSModeled(DSC.SAFE)
        @Override
        public void clear() {
            c.clear();
            // ---------- Original Method ----------
            //c.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.813 -0400", hash_original_method = "424D4966F358AE6553349A6493C21674", hash_generated_method = "14A91A23B96E56FE20CC78887044FCF6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            String var864CC0AEC1F50182F68F1C735FD8AA5D_1061444575 = (c.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return c.toString();
        }

        
    }


    
    private static class CheckedListIterator<E> implements ListIterator<E> {
        private ListIterator<E> i;
        private Class<E> type;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.813 -0400", hash_original_method = "0B7AAA10EE83BBF7A614BF8D8C7A7C84", hash_generated_method = "FCF3DC239F68EA0C87BFF9E2E8589D41")
        @DSModeled(DSC.SAFE)
        public CheckedListIterator(ListIterator<E> i, Class<E> type) {
            dsTaint.addTaint(type.dsTaint);
            dsTaint.addTaint(i.dsTaint);
            // ---------- Original Method ----------
            //this.i = i;
            //this.type = type;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.813 -0400", hash_original_method = "59CA86A80410B66286C92523CF35EC7B", hash_generated_method = "9028D3241AD9B0D4B03EAB2423B18569")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean hasNext() {
            boolean var1611849CD1EE22EA22E4E7E3327E2E35_1453439864 = (i.hasNext());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return i.hasNext();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.813 -0400", hash_original_method = "A2FD0994E634C5BCE4D27AD9176E9A5A", hash_generated_method = "29EADBAD6E04DD146CB934EC53A8C96D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E next() {
            E var95DB63288123763EC54E086A49CC4D64_150608941 = (i.next());
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return i.next();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.813 -0400", hash_original_method = "048FA6C3E3A28865AD880AF8A3FCAE96", hash_generated_method = "6D29B2FB41FB1A7A3AE157A46C52D7BC")
        @DSModeled(DSC.SAFE)
        @Override
        public void remove() {
            i.remove();
            // ---------- Original Method ----------
            //i.remove();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.813 -0400", hash_original_method = "BBFFF3658F03DC70BAED5B88BBE801F9", hash_generated_method = "58ACCEC3FC3909F65B8268585AE016FA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean hasPrevious() {
            boolean var1FCC7ECF60E98FFA6572F3122E374C7E_348289141 = (i.hasPrevious());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return i.hasPrevious();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.813 -0400", hash_original_method = "BC73D9B40C1A828CB3DD11A00CF4E28D", hash_generated_method = "D18AB289FB389DAAA6AA050575CA817A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E previous() {
            E var7A95CFED89ADF92C26E73F6AF678D539_743432853 = (i.previous());
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return i.previous();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.813 -0400", hash_original_method = "E41D02CE1A7D09C2351DC91043CD0C1F", hash_generated_method = "1B18A95F6A42B15074AA28DC72DF698B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int nextIndex() {
            int var97CCB58C3C2141B73F996BC540E6EAF5_916242725 = (i.nextIndex());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return i.nextIndex();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.813 -0400", hash_original_method = "F0908B37AEEE31348E4E446BDB2DC11E", hash_generated_method = "EBE26920858DF766E0C3E0313EE74C2C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int previousIndex() {
            int var9F734927211780D2EA84E984ED22702D_343522986 = (i.previousIndex());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return i.previousIndex();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.813 -0400", hash_original_method = "F06067E5C50A33BA33028ACBB7E94E5C", hash_generated_method = "8E56812530262B85D475854C36F6618F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void set(E obj) {
            dsTaint.addTaint(obj.dsTaint);
            i.set(checkType(obj, type));
            // ---------- Original Method ----------
            //i.set(checkType(obj, type));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.813 -0400", hash_original_method = "3A7C6206CDBE5C448C8E83D10145E877", hash_generated_method = "0ABCCC2A8A2B3F488A04A2A053B8ED0C")
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
        private static final long serialVersionUID = 65247728283967356L;
        List<E> l;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.813 -0400", hash_original_method = "50AAAF0EF026911FE0274184FEF9C1C3", hash_generated_method = "99D7D8FD55DC31A1DA7CD6E7572B59F8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CheckedList(List<E> l, Class<E> type) {
            super(l, type);
            dsTaint.addTaint(l.dsTaint);
            dsTaint.addTaint(type.dsTaint);
            // ---------- Original Method ----------
            //this.l = l;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.813 -0400", hash_original_method = "8A1A291116E92C540879607029C861C6", hash_generated_method = "A9625D79330FA656F84015DC9AB1BA11")
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
            boolean var720AF4600E5540369BE417DBAEE92DFA_1274895915 = (l.addAll(index, (List<E>) Arrays.asList(array)));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //Object[] array = c1.toArray();
            //for (Object o : array) {
                //checkType(o, type);
            //}
            //return l.addAll(index, (List<E>) Arrays.asList(array));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.813 -0400", hash_original_method = "12BB9FAB0B921E0E98205977740A217D", hash_generated_method = "7F498327F5F0FB714C9649B48AA16387")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E get(int index) {
            dsTaint.addTaint(index);
            E varCC738BFB8401CF070AE45C766DD49A10_1819272539 = (l.get(index));
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return l.get(index);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.813 -0400", hash_original_method = "B15A1B3ABEAB19644273A7FDAFDFF4C3", hash_generated_method = "1163C7780955CE9FF06C9C587A251DB2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E set(int index, E obj) {
            dsTaint.addTaint(index);
            dsTaint.addTaint(obj.dsTaint);
            E var95BC3D95EBED8FE150AF94B939570EB9_353355183 = (l.set(index, checkType(obj, type)));
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return l.set(index, checkType(obj, type));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.814 -0400", hash_original_method = "97AC3A6F1A8F1F91D88637C439308CAA", hash_generated_method = "2258CC910FFD7EDA4E16A8A69AC87CA3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void add(int index, E obj) {
            dsTaint.addTaint(index);
            dsTaint.addTaint(obj.dsTaint);
            l.add(index, checkType(obj, type));
            // ---------- Original Method ----------
            //l.add(index, checkType(obj, type));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.814 -0400", hash_original_method = "B7A754E9641B79EF3AC643C6FA162631", hash_generated_method = "F4C5D6477706DC1D4B262C087E90BD51")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E remove(int index) {
            dsTaint.addTaint(index);
            E var5334BD966B25011284C4A335B4622CBB_466264327 = (l.remove(index));
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return l.remove(index);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.814 -0400", hash_original_method = "EB95E25E6439350950712FBE2C177EC4", hash_generated_method = "A3E4A542D7A0FBB5623D2C18EB89906B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int indexOf(Object obj) {
            dsTaint.addTaint(obj.dsTaint);
            int varBB0CC98524B808CD822A2164B51F33B8_171115917 = (l.indexOf(obj));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return l.indexOf(obj);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.814 -0400", hash_original_method = "4C828EC3A9818E335BF8E9F8513B24F5", hash_generated_method = "4A769C6F10A625D2F590302D046A7343")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int lastIndexOf(Object obj) {
            dsTaint.addTaint(obj.dsTaint);
            int var68D523AC731688651041C374F25CAB09_1562162155 = (l.lastIndexOf(obj));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return l.lastIndexOf(obj);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.814 -0400", hash_original_method = "9293980ECFF31B033CDADFB0ED26EA69", hash_generated_method = "903AF283BCEAD3BCED7D7A43FFDA75BB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public ListIterator<E> listIterator() {
            ListIterator<E> var1765FEA39454541ADEB5AAFF0A06F4EC_540871240 = (new CheckedListIterator<E>(l.listIterator(), type));
            return (ListIterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CheckedListIterator<E>(l.listIterator(), type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.814 -0400", hash_original_method = "31D39D7FEEE82D7A15D00B805CB5EAA4", hash_generated_method = "9D4A11A2BB84D70468AE1C9E54C82907")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public ListIterator<E> listIterator(int index) {
            dsTaint.addTaint(index);
            ListIterator<E> var1E7F16B9DBBA8C20B0828EBF68F598C7_418339575 = (new CheckedListIterator<E>(l.listIterator(index), type));
            return (ListIterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CheckedListIterator<E>(l.listIterator(index), type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.814 -0400", hash_original_method = "A5E1EFD4B2650099AC132BF86B97D88F", hash_generated_method = "5939269433507F586D14AF8411ADFC10")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public List<E> subList(int fromIndex, int toIndex) {
            dsTaint.addTaint(fromIndex);
            dsTaint.addTaint(toIndex);
            List<E> varB73C73BFAA199F4126FC4F7FE7D2FC06_1733710260 = (checkedList(l.subList(fromIndex, toIndex), type));
            return (List<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return checkedList(l.subList(fromIndex, toIndex), type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.814 -0400", hash_original_method = "A14AE2E014BAD465F594EE49A5008ED4", hash_generated_method = "7FF0F230E7C63C55C2110C9CE80690E3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object obj) {
            dsTaint.addTaint(obj.dsTaint);
            boolean var559B3B39BC42D814993568E544C6FE1F_1537993645 = (l.equals(obj));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return l.equals(obj);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.814 -0400", hash_original_method = "410D1D1B2E05F678DF3AB7D6BB08AEDB", hash_generated_method = "B4FF2CA3A07477B9B0E13F5A05A206BB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int var283F03AD18DE255D000FAC9E62BDE6F0_1184254144 = (l.hashCode());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return l.hashCode();
        }

        
    }


    
    private static class CheckedRandomAccessList<E> extends CheckedList<E> implements RandomAccess {
        private static final long serialVersionUID = 1638200125423088369L;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.814 -0400", hash_original_method = "77F175BCE2CEB5DECA5010A8855616A0", hash_generated_method = "5E4A2AE80028801E8269440117B013FD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CheckedRandomAccessList(List<E> l, Class<E> type) {
            super(l, type);
            dsTaint.addTaint(l.dsTaint);
            dsTaint.addTaint(type.dsTaint);
            // ---------- Original Method ----------
        }

        
    }


    
    private static class CheckedSet<E> extends CheckedCollection<E> implements Set<E> {
        private static final long serialVersionUID = 4694047833775013803L;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.814 -0400", hash_original_method = "515963C9B1280D5707D3A720329B0AC0", hash_generated_method = "72531B2B622A6920DA113492B8437A0D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CheckedSet(Set<E> s, Class<E> type) {
            super(s, type);
            dsTaint.addTaint(s.dsTaint);
            dsTaint.addTaint(type.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.814 -0400", hash_original_method = "F33AC6E694EC5A5F3A81FF749707DDFC", hash_generated_method = "6942E7A77DE3D4C57400229939333726")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object obj) {
            dsTaint.addTaint(obj.dsTaint);
            boolean varC91792C7DD4F0C8E92E42617036EED48_1236707697 = (c.equals(obj));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c.equals(obj);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.814 -0400", hash_original_method = "E858D80F3EEDE9F2B52CDB7DA7FBF12B", hash_generated_method = "7C6AA3CCF9837A1AC91021566CA28CCA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int var19B3D08FE3840D0D3E365DF71EF3E20C_343109552 = (c.hashCode());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return c.hashCode();
        }

        
    }


    
    private static class CheckedMap<K, V> implements Map<K, V>, Serializable {
        private static final long serialVersionUID = 5742860141034234728L;
        Map<K, V> m;
        Class<K> keyType;
        Class<V> valueType;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.814 -0400", hash_original_method = "906A4960963B0F972E50BE617CA562B3", hash_generated_method = "C3EAF3DFF932B5352D76C757F4196560")
        @DSModeled(DSC.SAFE)
        private CheckedMap(Map<K, V> m, Class<K> keyType, Class<V> valueType) {
            dsTaint.addTaint(keyType.dsTaint);
            dsTaint.addTaint(valueType.dsTaint);
            dsTaint.addTaint(m.dsTaint);
            {
                throw new NullPointerException();
            } //End block
            // ---------- Original Method ----------
            //if (m == null || keyType == null || valueType == null) {
                //throw new NullPointerException();
            //}
            //this.m = m;
            //this.keyType = keyType;
            //this.valueType = valueType;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.814 -0400", hash_original_method = "A04EE09DEB6F21FAA6A7E10DF6401CD1", hash_generated_method = "10BD9AB1B8E99254DAA715A357DCF060")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int size() {
            int varDBD6E28F15F3D13B8127CF62DD69ACD5_442889938 = (m.size());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return m.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.814 -0400", hash_original_method = "B9E63D3C52241E7E917CB1416ABA36E5", hash_generated_method = "9B50F14FDE7A49D9D10429F4C9F23F7E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean isEmpty() {
            boolean var028CF644E61B84328EAB66D556672A81_1716227447 = (m.isEmpty());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return m.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.814 -0400", hash_original_method = "A6C730848D8A626F99D8229EE744E3C0", hash_generated_method = "8D1593A46365D9775D51BF662B67072F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsKey(Object key) {
            dsTaint.addTaint(key.dsTaint);
            boolean var2519B7EF565FEC21B6285F5E44AC148E_398413807 = (m.containsKey(key));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return m.containsKey(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.814 -0400", hash_original_method = "EF8C00CF950E8C186D2F05E1E556F384", hash_generated_method = "3A56BF6CA7E35A580325734228FC5DC7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsValue(Object value) {
            dsTaint.addTaint(value.dsTaint);
            boolean varF8CB74E2C5E0734947B397D82173BDD4_988612596 = (m.containsValue(value));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return m.containsValue(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.815 -0400", hash_original_method = "B8FE254B61C57EC3A6DCE539976DA268", hash_generated_method = "BB9D3E0DD2EA207541BBCF2259C551B9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public V get(Object key) {
            dsTaint.addTaint(key.dsTaint);
            V var3CE9B05179DCB2168B5F27445CBC5B28_1300449048 = (m.get(key));
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return m.get(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.815 -0400", hash_original_method = "98010DFF1DD51631676FCAC604C1B694", hash_generated_method = "9E4AAAA6DA83939C04D06E771D99C2CA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public V put(K key, V value) {
            dsTaint.addTaint(value.dsTaint);
            dsTaint.addTaint(key.dsTaint);
            V var3900CFF6F346802A5C37740372A7DDE7_1646666141 = (m.put(checkType(key, keyType), checkType(value, valueType)));
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return m.put(checkType(key, keyType), checkType(value, valueType));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.815 -0400", hash_original_method = "7E1C4ABAB7F4D30C9FA02B8AC4206202", hash_generated_method = "8E8EF7BBB4D433742276A839198558A2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public V remove(Object key) {
            dsTaint.addTaint(key.dsTaint);
            V varD8EDAC54418B5A038858C3D8CF4069D9_1018311779 = (m.remove(key));
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return m.remove(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.815 -0400", hash_original_method = "7B09FD67E4091CD76439ADACD213D3A2", hash_generated_method = "320CCB7540F9C99E27B61DBB8742F865")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.815 -0400", hash_original_method = "5163CA2ED3AD9C66F2BDAFB902590115", hash_generated_method = "3D07CBB638C6514CE20DA136AC64FDB0")
        @DSModeled(DSC.SAFE)
        @Override
        public void clear() {
            m.clear();
            // ---------- Original Method ----------
            //m.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.815 -0400", hash_original_method = "BC85ABF91A39D98F3F2ED0838950D9FC", hash_generated_method = "AC673F545DD74F5179274248F803383B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Set<K> keySet() {
            Set<K> varA07641C54B940BB8232146D61EC97C56_802788482 = (m.keySet());
            return (Set<K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return m.keySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.815 -0400", hash_original_method = "F6584059741E2818D171714370ED56BF", hash_generated_method = "69E6A58252CA8A17E2BBE3ACE3029374")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Collection<V> values() {
            Collection<V> var5507ECC94528859BCB27FED1248DB4AA_1399655774 = (m.values());
            return (Collection<V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return m.values();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.815 -0400", hash_original_method = "17C87BFAA3247941C0F3FE3FCE6C8B6B", hash_generated_method = "C0C899C3DC6BDD51CBB2704B512E197A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> varB1671B733F1A4DF3968EE76EA035354B_2067335626 = (new CheckedEntrySet<K, V>(m.entrySet(), valueType));
            return (Set<Map.Entry<K, V>>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CheckedEntrySet<K, V>(m.entrySet(), valueType);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.815 -0400", hash_original_method = "5F45CB6F19E1E41DEEA3711399B994B8", hash_generated_method = "0E65A46ECFC5F7EA9A876A1B2FE4EB2E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object obj) {
            dsTaint.addTaint(obj.dsTaint);
            boolean var6519380B8603327E1D0BBD66320BEF0F_838522549 = (m.equals(obj));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return m.equals(obj);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.815 -0400", hash_original_method = "E3229E3389F030DD50B79734943DB788", hash_generated_method = "7BA191277085AF69CDAE9D0F1BD06B0F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int varAA1293165230C9829C1AEACFFF576DFC_1938513180 = (m.hashCode());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return m.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.815 -0400", hash_original_method = "5DD44B3CD2826BF39F974F66579CF74F", hash_generated_method = "5E080DB7423C51FAA01EAE7B41520432")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            String var7BAD0880B86D95365972142C036695CB_1156753931 = (m.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return m.toString();
        }

        
        private static class CheckedEntry<K, V> implements Map.Entry<K, V> {
            Map.Entry<K, V> e;
            Class<V> valueType;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.815 -0400", hash_original_method = "7A5E92C112A4AAE1EEB574291E4B57B6", hash_generated_method = "EB958629026009169B4D7A54E8608B9D")
            @DSModeled(DSC.SAFE)
            public CheckedEntry(Map.Entry<K, V> e, Class<V> valueType) {
                dsTaint.addTaint(e.dsTaint);
                dsTaint.addTaint(valueType.dsTaint);
                {
                    throw new NullPointerException();
                } //End block
                // ---------- Original Method ----------
                //if (e == null) {
                    //throw new NullPointerException();
                //}
                //this.e = e;
                //this.valueType = valueType;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.815 -0400", hash_original_method = "10D87C621F2656D3DA7DCE234A4C3FAC", hash_generated_method = "111FCA42CAEB6BCD59B36223C00A31C4")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public K getKey() {
                K var530002C589E791D5F0D59F21CB98A866_1432591252 = (e.getKey());
                return (K)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return e.getKey();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.815 -0400", hash_original_method = "8EF21B2292AA31AAE181B3282F3F0262", hash_generated_method = "8B5ED4B314D05C42AE9BD631C90DEA63")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public V getValue() {
                V var2794ADBC14ECE7BF0E45D7B88CA3585A_798241307 = (e.getValue());
                return (V)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return e.getValue();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.815 -0400", hash_original_method = "22C63BC622BE9DF4D2BED624BDB5B6B5", hash_generated_method = "3330824FC9A56264465F81B6E46877A8")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public V setValue(V obj) {
                dsTaint.addTaint(obj.dsTaint);
                V var58BA915191301B7F59E662768625FEFD_885075649 = (e.setValue(checkType(obj, valueType)));
                return (V)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return e.setValue(checkType(obj, valueType));
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.815 -0400", hash_original_method = "0FE63D6CB37B8BF21266876509A7EAAA", hash_generated_method = "266D79B6228D585EA6EAD3842A90F4C8")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean equals(Object obj) {
                dsTaint.addTaint(obj.dsTaint);
                boolean var5F98FA9F6CA964453675BAF27F4B0002_624848723 = (e.equals(obj));
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return e.equals(obj);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.816 -0400", hash_original_method = "02C3AF7FB3CFA22B693B83D22D208AF4", hash_generated_method = "7F24508289892014E2CBFE2E212C4C69")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public int hashCode() {
                int varB0D5769FD2A442E362DC4438ABD8230C_1307275608 = (e.hashCode());
                return dsTaint.getTaintInt();
                // ---------- Original Method ----------
                //return e.hashCode();
            }

            
        }


        
        private static class CheckedEntrySet<K, V> implements Set<Map.Entry<K, V>> {
            Set<Map.Entry<K, V>> s;
            Class<V> valueType;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.816 -0400", hash_original_method = "77FA7326B6BB5621E7FE63699FC58F08", hash_generated_method = "6741420195AEA923161F639431806CD7")
            @DSModeled(DSC.SAFE)
            public CheckedEntrySet(Set<Map.Entry<K, V>> s, Class<V> valueType) {
                dsTaint.addTaint(s.dsTaint);
                dsTaint.addTaint(valueType.dsTaint);
                // ---------- Original Method ----------
                //this.s = s;
                //this.valueType = valueType;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.816 -0400", hash_original_method = "448F3F9279BA75C161BF1A7F97E105A4", hash_generated_method = "8D27EF3512A8C735C1798DF18C234D71")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public Iterator<Map.Entry<K, V>> iterator() {
                Iterator<Map.Entry<K, V>> varF3EF6D5EEA7921FC381F8C92707C8A1E_44459936 = (new CheckedEntryIterator<K, V>(s.iterator(), valueType));
                return (Iterator<Map.Entry<K, V>>)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new CheckedEntryIterator<K, V>(s.iterator(), valueType);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.816 -0400", hash_original_method = "0FB4B292E50A952F877CB518E0A96CF9", hash_generated_method = "51EDC078CAC93301956F894CBDC7A984")
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.816 -0400", hash_original_method = "C1CA1F6CAFA571422DF3592838D87C35", hash_generated_method = "86C13F539ED4267BFA810C7F0DB52C56")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @SuppressWarnings("unchecked")
            @Override
            public <T> T[] toArray(T[] array) {
                dsTaint.addTaint(array.dsTaint);
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.816 -0400", hash_original_method = "C32F0C36534158E273107417143214BD", hash_generated_method = "12B291A3F8F6CC232C0DEBC6EBC4F8BE")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean retainAll(Collection<?> c) {
                dsTaint.addTaint(c.dsTaint);
                boolean var5CB6111A304F8110F244B25FAFD11216_28084088 = (s.retainAll(c));
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return s.retainAll(c);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.816 -0400", hash_original_method = "B2624C46EA911C8D7CBCD3DB1975A601", hash_generated_method = "0B4A4909EC1DE492C52F928B3CD9AC76")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean removeAll(Collection<?> c) {
                dsTaint.addTaint(c.dsTaint);
                boolean var9FB36AF651B537108EEB0474A946606A_684630618 = (s.removeAll(c));
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return s.removeAll(c);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.816 -0400", hash_original_method = "D8F4D306F45D40205BDE17116DDFF9FA", hash_generated_method = "BF88F0659382B04B18AD061647E34955")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean containsAll(Collection<?> c) {
                dsTaint.addTaint(c.dsTaint);
                boolean var13D8B720D63124262C076810AF3BA42D_1046287692 = (s.containsAll(c));
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return s.containsAll(c);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.816 -0400", hash_original_method = "0D1A7F281A8819D32245C163B79E338D", hash_generated_method = "68BAD2D529904697A8D27257AA704A4F")
            @DSModeled(DSC.SAFE)
            @Override
            public boolean addAll(Collection<? extends Map.Entry<K, V>> c) {
                dsTaint.addTaint(c.dsTaint);
                throw new UnsupportedOperationException();
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //throw new UnsupportedOperationException();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.816 -0400", hash_original_method = "46F35AD7CAD80E45E374449F130E7D0D", hash_generated_method = "6C7117ED9A28117E6ABAD1B62AFDE206")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean remove(Object o) {
                dsTaint.addTaint(o.dsTaint);
                boolean varDCAB2EB8C531AB1E623FFAD695CFD286_148791915 = (s.remove(o));
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return s.remove(o);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.816 -0400", hash_original_method = "A91421BB58ED7F6569B24AAD1B5804AB", hash_generated_method = "F61E9DF684537D2A7E2651056B696CDA")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean contains(Object o) {
                dsTaint.addTaint(o.dsTaint);
                boolean var42C44FAC187AFC4735D76D5B7760F520_1967667787 = (s.contains(o));
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return s.contains(o);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.816 -0400", hash_original_method = "8704A9C8AC3AA02909B00E4E211C4D3E", hash_generated_method = "F45A28808A69AF3F77C2922247C10A12")
            @DSModeled(DSC.SAFE)
            @Override
            public boolean add(Map.Entry<K, V> o) {
                dsTaint.addTaint(o.dsTaint);
                throw new UnsupportedOperationException();
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //throw new UnsupportedOperationException();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.816 -0400", hash_original_method = "1DB64DC7E3E98DAB777752CA6247DAE5", hash_generated_method = "0E2E41C7E77C223BF5D8941D56922AD7")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean isEmpty() {
                boolean var33F6A8EED6267D5B4CCD3EAC631C616A_197264638 = (s.isEmpty());
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return s.isEmpty();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.816 -0400", hash_original_method = "3294D1F2516BD356F42ED84BE178EFCB", hash_generated_method = "56F964FA6A70EFA400FD2CD819F1C315")
            @DSModeled(DSC.SAFE)
            @Override
            public void clear() {
                s.clear();
                // ---------- Original Method ----------
                //s.clear();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.816 -0400", hash_original_method = "61480F19A13469EF561F92E5A3700C23", hash_generated_method = "87D759DFB6E83DCC12A216145853F6B2")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public int size() {
                int var8151828880546AEA1C19BE7C52EE5E09_648373722 = (s.size());
                return dsTaint.getTaintInt();
                // ---------- Original Method ----------
                //return s.size();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.816 -0400", hash_original_method = "150ADDC982A3B6D8A573E663C38A7C9E", hash_generated_method = "9CBDE179892D1810CD67B52BC44035F1")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public int hashCode() {
                int varE2FC7D6C989F81F3F30CE1BE213D1E3F_1792592696 = (s.hashCode());
                return dsTaint.getTaintInt();
                // ---------- Original Method ----------
                //return s.hashCode();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.816 -0400", hash_original_method = "2565EBD5FCFC00F10C086CB36B3EEE8C", hash_generated_method = "3E127FFBD632399F3CED804124ABF608")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean equals(Object object) {
                dsTaint.addTaint(object.dsTaint);
                boolean varB696C6744E5DE06D0B58A4DB8EE26D83_307834986 = (s.equals(object));
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return s.equals(object);
            }

            
            private static class CheckedEntryIterator<K, V> implements Iterator<Map.Entry<K, V>> {
                Iterator<Map.Entry<K, V>> i;
                Class<V> valueType;
                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.817 -0400", hash_original_method = "3CE5E36A95DFE16D33C2CC4176CB7EE4", hash_generated_method = "FA312F363D00A194C21F865C60036D10")
                @DSModeled(DSC.SAFE)
                public CheckedEntryIterator(Iterator<Map.Entry<K, V>> i,
                        Class<V> valueType) {
                    dsTaint.addTaint(valueType.dsTaint);
                    dsTaint.addTaint(i.dsTaint);
                    // ---------- Original Method ----------
                    //this.i = i;
                    //this.valueType = valueType;
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.817 -0400", hash_original_method = "59CA86A80410B66286C92523CF35EC7B", hash_generated_method = "5B4D53C32F78BD6EAC71C751323DAED5")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public boolean hasNext() {
                    boolean var048C390D087BEDAABDA4F669A9DA628E_1435392476 = (i.hasNext());
                    return dsTaint.getTaintBoolean();
                    // ---------- Original Method ----------
                    //return i.hasNext();
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.817 -0400", hash_original_method = "048FA6C3E3A28865AD880AF8A3FCAE96", hash_generated_method = "6D29B2FB41FB1A7A3AE157A46C52D7BC")
                @DSModeled(DSC.SAFE)
                @Override
                public void remove() {
                    i.remove();
                    // ---------- Original Method ----------
                    //i.remove();
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.817 -0400", hash_original_method = "4D16E0BB01C90351B8312D1A4B7DB5F2", hash_generated_method = "574DECEECBA7C458069B584D6BF5FB4A")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public Map.Entry<K, V> next() {
                    Map.Entry<K, V> var17B5968AC14D1D5FC5BD4F2E126C5421_1229547763 = (new CheckedEntry<K, V>(i.next(), valueType));
                    return (Map.Entry<K, V>)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //return new CheckedEntry<K, V>(i.next(), valueType);
                }

                
            }


            
        }


        
    }


    
    private static class CheckedSortedSet<E> extends CheckedSet<E> implements SortedSet<E> {
        private static final long serialVersionUID = 1599911165492914959L;
        private SortedSet<E> ss;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.817 -0400", hash_original_method = "70499BD9B05065D265D741875DD058CA", hash_generated_method = "1C0AC7F2E2097A5D5F1C954C8F6DEEE4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CheckedSortedSet(SortedSet<E> s, Class<E> type) {
            super(s, type);
            dsTaint.addTaint(s.dsTaint);
            dsTaint.addTaint(type.dsTaint);
            // ---------- Original Method ----------
            //this.ss = s;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.817 -0400", hash_original_method = "8514D9255D678B041F55D03BA11DCA3B", hash_generated_method = "98CE7438B089184CD40C4EFEFCD64B2D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Comparator<? super E> comparator() {
            Comparator<? super E> var05CAB94F8BD11820A94AC68A790A80A5_630834470 = (ss.comparator());
            return (Comparator<? super E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ss.comparator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.817 -0400", hash_original_method = "82539AB1166DFBB28D0E3DC3D0A43121", hash_generated_method = "07633C84DF373F678E82C474A85D19D8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedSet<E> subSet(E fromElement, E toElement) {
            dsTaint.addTaint(fromElement.dsTaint);
            dsTaint.addTaint(toElement.dsTaint);
            SortedSet<E> var5328DA8CB8368089558365859562FB92_460315263 = (new CheckedSortedSet<E>(ss.subSet(fromElement, toElement),
                    type));
            return (SortedSet<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CheckedSortedSet<E>(ss.subSet(fromElement, toElement),
                    //type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.817 -0400", hash_original_method = "68D546866615C37E07B8E968E3813E84", hash_generated_method = "FA0E2CF1B2B6E30465E42CE1E6658323")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedSet<E> headSet(E toElement) {
            dsTaint.addTaint(toElement.dsTaint);
            SortedSet<E> var12D4E16E805D05744E7269E2733D45D5_913109385 = (new CheckedSortedSet<E>(ss.headSet(toElement), type));
            return (SortedSet<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CheckedSortedSet<E>(ss.headSet(toElement), type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.817 -0400", hash_original_method = "B0B4B667BF95B9D9A3CD3F7FE8BEFA1B", hash_generated_method = "D8A5551C879CEB52976466DFE001E8F9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedSet<E> tailSet(E fromElement) {
            dsTaint.addTaint(fromElement.dsTaint);
            SortedSet<E> var38D38D4E1852BE6949045F142A132E53_747072183 = (new CheckedSortedSet<E>(ss.tailSet(fromElement), type));
            return (SortedSet<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CheckedSortedSet<E>(ss.tailSet(fromElement), type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.817 -0400", hash_original_method = "6BB6C51843B41CC0DCB5509A79DBA008", hash_generated_method = "CBBC8B0B0D7746C56B5CF562ACF2C216")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E first() {
            E varCAE51BE1E9DF20269B81A1FDC8990752_2096386840 = (ss.first());
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ss.first();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.817 -0400", hash_original_method = "AAC5DDE787ACA85752B94AAB77F6B0F8", hash_generated_method = "5A5695B3A840232C1E4B61EBFD96B92A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E last() {
            E varB0B3C145EFB1EF3B95D9D987CE98A283_1127879882 = (ss.last());
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ss.last();
        }

        
    }


    
    private static class CheckedSortedMap<K, V> extends CheckedMap<K, V> implements SortedMap<K, V> {
        private static final long serialVersionUID = 1599671320688067438L;
        SortedMap<K, V> sm;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.817 -0400", hash_original_method = "2CB6EA0E6447E5AAF8B28B5FDF140BE4", hash_generated_method = "8232567E35D257A2309B59E4B066FF21")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         CheckedSortedMap(SortedMap<K, V> m, Class<K> keyType, Class<V> valueType) {
            super(m, keyType, valueType);
            dsTaint.addTaint(keyType.dsTaint);
            dsTaint.addTaint(valueType.dsTaint);
            dsTaint.addTaint(m.dsTaint);
            // ---------- Original Method ----------
            //this.sm = m;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.817 -0400", hash_original_method = "E5FDBCC6560BE7E99B2D2F850BD84149", hash_generated_method = "A9D9D8DE42603457C8E7AE8197F5B466")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Comparator<? super K> comparator() {
            Comparator<? super K> var422223D82196DD3FC2DC6264D5B430C5_802983866 = (sm.comparator());
            return (Comparator<? super K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return sm.comparator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.817 -0400", hash_original_method = "65DE11E398BB209CD2689071C041161A", hash_generated_method = "95A1E12287E5F4314EC5D134650DE151")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedMap<K, V> subMap(K fromKey, K toKey) {
            dsTaint.addTaint(toKey.dsTaint);
            dsTaint.addTaint(fromKey.dsTaint);
            SortedMap<K, V> var190C4EB84C21094B4E80D985CB6ACA7F_1852763815 = (new CheckedSortedMap<K, V>(sm.subMap(fromKey, toKey), keyType, valueType));
            return (SortedMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CheckedSortedMap<K, V>(sm.subMap(fromKey, toKey), keyType, valueType);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.817 -0400", hash_original_method = "2C5724B582D2FAB5716323DB894A671D", hash_generated_method = "776F718F4D4E9CD6DD22D0AEA43B2B24")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedMap<K, V> headMap(K toKey) {
            dsTaint.addTaint(toKey.dsTaint);
            SortedMap<K, V> var2BE0E60A1B317A0935CA3D78B86A50A4_1453846821 = (new CheckedSortedMap<K, V>(sm.headMap(toKey), keyType, valueType));
            return (SortedMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CheckedSortedMap<K, V>(sm.headMap(toKey), keyType, valueType);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.817 -0400", hash_original_method = "2879524DD09B17D2FCB7AD1626D24618", hash_generated_method = "CDB9D5688D4263D69680FF0F893EE719")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedMap<K, V> tailMap(K fromKey) {
            dsTaint.addTaint(fromKey.dsTaint);
            SortedMap<K, V> varE2D105EA819834A2EAC8202B8964FD2E_463462969 = (new CheckedSortedMap<K, V>(sm.tailMap(fromKey), keyType, valueType));
            return (SortedMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CheckedSortedMap<K, V>(sm.tailMap(fromKey), keyType, valueType);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.817 -0400", hash_original_method = "B25E8C7440C76FBF812FF7AC9CA9D776", hash_generated_method = "475D8B3514F68A7F95BA04BF0D9F3992")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public K firstKey() {
            K var27D52CE4EA4B74D34E8381D333AAE9A4_441547228 = (sm.firstKey());
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return sm.firstKey();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.818 -0400", hash_original_method = "00E9126A84DE8B71214859A17DA6BD2E", hash_generated_method = "398E8F47887422C5BD309DC0C001B9A2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public K lastKey() {
            K var9F9AE843A8A54EC3D9E8230A61FB8B04_1059648636 = (sm.lastKey());
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return sm.lastKey();
        }

        
    }


    
}


