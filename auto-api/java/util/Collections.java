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
    private static final Iterator<?> EMPTY_ITERATOR = new Iterator<Object>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.460 -0400", hash_original_method = "28E75D14A5D2234D3702D9638A8D3094", hash_generated_method = "C287E2037440BE256524A3C5DE1E4C9C")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean hasNext() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.467 -0400", hash_original_method = "243C3D15209D9BF28572CB29FC9F3DF7", hash_generated_method = "C1DC81DFCE769DF322DAB12F2A8C1D1A")
        @DSModeled(DSC.SAFE)
        @Override
        public Object next() {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //throw new NoSuchElementException();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.474 -0400", hash_original_method = "45CE80048748F3BC523226127E4746F5", hash_generated_method = "F46B8B9AA8141D01937BA62F4B7EB9ED")
        @DSModeled(DSC.SAFE)
        @Override
        public void remove() {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            // ---------- Original Method ----------
            //throw new IllegalStateException();
        }


}; //Transformed anonymous class
    private static final Enumeration<?> EMPTY_ENUMERATION = new Enumeration<Object>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.477 -0400", hash_original_method = "50CD0E92886EDA5BEE0164B092B351EC", hash_generated_method = "D990677E1CB9DCFAF72A3AF93636CB5E")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean hasMoreElements() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.481 -0400", hash_original_method = "82381D9C34AF9F2E88B673FB4A4E6DDE", hash_generated_method = "0121C406148A537174173CF2B6CF885D")
        @DSModeled(DSC.SAFE)
        @Override
        public Object nextElement() {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.494 -0400", hash_original_method = "0C1BC548FC19EEB6A684F12763720939", hash_generated_method = "E73BB050B9C2D6C02B81CF7AEB0AC739")
    @DSModeled(DSC.SAFE)
    private Collections() {
        // ---------- Original Method ----------
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.504 -0400", hash_original_method = "639DCFC6603C0FE7D95B5F727C42F869", hash_generated_method = "C74DB74D36B5DE795D1FA3801CEF0D62")
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.519 -0400", hash_original_method = "7EE4BC25497A399F0057D0EDDA546990", hash_generated_method = "183EA53264CFEAD83FA7167AF45DE6E5")
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.524 -0400", hash_original_method = "4DAF8815DF5AE5641557279C14C79B8B", hash_generated_method = "42FD57A0C1919E9F4B581427431DBBA4")
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.536 -0400", hash_original_method = "333DF3A528D354763516FD7D10C7D14D", hash_generated_method = "FBADBAF8F47BC1A79BA238A71394986E")
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.539 -0400", hash_original_method = "62935A13652FEE658979A1B588203D96", hash_generated_method = "6BEF1095B7C5E6DC71C1E4FFA97124F3")
    public static <T> void fill(List<? super T> list, T object) {
        ListIterator<? super T> it = list.listIterator();
        while (it.hasNext()) {
            it.next();
            it.set(object);
        }
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.549 -0400", hash_original_method = "9EA4A5E40EF3A55FC218758BEF12D5D6", hash_generated_method = "83F9C050AE4842598DA7A81607173BFD")
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.552 -0400", hash_original_method = "BEBAF4C7785D93F09A03868592048900", hash_generated_method = "020097D52BF79A254AB7E4F89C4580CE")
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.555 -0400", hash_original_method = "EA5F430AB64F3DB3A0E15CE09B069784", hash_generated_method = "3E1F9B4A7A186A235ABFB54B2506E9FB")
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.558 -0400", hash_original_method = "24E498CA55A79FBCB8DBC624ECFDC8C2", hash_generated_method = "DBD4CBA5AD5AFAA8A4184EEBB04A90E0")
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.560 -0400", hash_original_method = "CA4F12BCC9FC3922FDA42F7B1D85BF52", hash_generated_method = "D45A9C3E8257215F6E2994036B74EBDE")
    public static <T> List<T> nCopies(final int length, T object) {
        List<Object> list = new CopiesList(length); 
        list.add(object);
        return (List<T>)list;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.580 -0400", hash_original_method = "EB5699B10E68EAD14DB0C0B8758D3718", hash_generated_method = "31349AC10D0052A7E2BC814BABCA0E6F")
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.582 -0400", hash_original_method = "6DC9DA2B3115217FB9A4BED85E16405F", hash_generated_method = "8C847D9B315CAEB3A2441D841F7B6E4E")
    @SuppressWarnings("unchecked")
    public static <T> Comparator<T> reverseOrder() {
        return (Comparator) ReverseComparator.INSTANCE;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.586 -0400", hash_original_method = "EB6B29E81FA958B4A18DE59CA51C3B68", hash_generated_method = "BB4A33D767C1344B643C80DDF58C2B94")
    public static <T> Comparator<T> reverseOrder(Comparator<T> c) {
        if (c == null) {
            return reverseOrder();
        }
        if (c instanceof ReverseComparator2) {
            return ((ReverseComparator2<T>) c).cmp;
        }
        return new ReverseComparator2<T>(c);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.593 -0400", hash_original_method = "E5AF799D5D5F28A5FEBFEE44EB734D28", hash_generated_method = "10BF5CB2E01C600AD89E7CF99F3834F5")
    public static void shuffle(List<?> list) {
        shuffle(list, new Random());
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.595 -0400", hash_original_method = "610901F49ED75C22083B75E1795D8046", hash_generated_method = "F3CA27D10376DF15BFE3DF819D1A6C72")
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.604 -0400", hash_original_method = "12FCAA4ABC86B71C16C808A6B679AB8E", hash_generated_method = "4C1D1ECE77BCA0DEE03E6B789BD5D67A")
    public static <E> Set<E> singleton(E object) {
        return new SingletonSet<E>(object);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.608 -0400", hash_original_method = "999943D18ABDC661759F1C7A52BB5DB9", hash_generated_method = "6EC81F1F3259C3A43C38304C638F1A04")
    public static <E> List<E> singletonList(E object) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return new SingletonList<E>(object);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.617 -0400", hash_original_method = "9D629CB80218D378F947A940DF0A687F", hash_generated_method = "CBFEF44EF9740BBF6393C5F9ABD43DA7")
    public static <K, V> Map<K, V> singletonMap(K key, V value) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return new SingletonMap<K, V>(key, value);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.622 -0400", hash_original_method = "7728BE757A1FA8D23064A39A5721D4F3", hash_generated_method = "0513CB0A5FF3DBAE70D2113311C6B35A")
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.625 -0400", hash_original_method = "550C37DC35A21FFEAB740FB6E8E187DD", hash_generated_method = "ADC4C1577E0373128E7E2E866378926D")
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.632 -0400", hash_original_method = "7B4D18FE971E4DCC6A75CEB3B4EFC148", hash_generated_method = "A7F77A42132916904B9DB826B455D271")
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.641 -0400", hash_original_method = "4FA0ADC7B132286E8BEC760B3B473151", hash_generated_method = "903ADF8A474279138316A0C5CDBB7A4E")
    public static <T> boolean replaceAll(List<T> list, T obj, T obj2) {
        int index;
        boolean found = false;
        while ((index = list.indexOf(obj)) > -1) {
            found = true;
            list.set(index, obj2);
        }
        return found;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.653 -0400", hash_original_method = "1281B43B461BF8F3597637C43DDB8B05", hash_generated_method = "585C79A9D02578B7A5E65DBDF48E3245")
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.664 -0400", hash_original_method = "E1D1CE40A9DE659C11F6DF1EE0DED402", hash_generated_method = "343C9D8EF6CA44762FC0AEE7C66FE092")
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.673 -0400", hash_original_method = "682653A6340BAC71175A462BC9E110F0", hash_generated_method = "5916513B08E39B8EF18D5CEA31994618")
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.687 -0400", hash_original_method = "C88929F07D74A697323F0CA10424C476", hash_generated_method = "880357B29D4ECB5D482E151AF34A1048")
    public static <T> ArrayList<T> list(Enumeration<T> enumeration) {
        ArrayList<T> list = new ArrayList<T>();
        while (enumeration.hasMoreElements()) {
            list.add(enumeration.nextElement());
        }
        return list;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.693 -0400", hash_original_method = "6E43AB3D08960348228DF658132887B3", hash_generated_method = "E9F5DE13BDB7D5360DAD72566862CF99")
    public static <T> Collection<T> synchronizedCollection(
            Collection<T> collection) {
        if (collection == null) {
            throw new NullPointerException();
        }
        return new SynchronizedCollection<T>(collection);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.695 -0400", hash_original_method = "2FFB099497385BC1C3F1B683583D48BE", hash_generated_method = "91B5547A9CEABE2220B6B1D0D27DBC7B")
    public static <T> List<T> synchronizedList(List<T> list) {
        if (list == null) {
            throw new NullPointerException();
        }
        if (list instanceof RandomAccess) {
            return new SynchronizedRandomAccessList<T>(list);
        }
        return new SynchronizedList<T>(list);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.708 -0400", hash_original_method = "24D426A1A5E5C520D92BE47A1C821155", hash_generated_method = "AEF58FC203C288723412CC2D7C5B15D4")
    public static <K, V> Map<K, V> synchronizedMap(Map<K, V> map) {
        if (map == null) {
            throw new NullPointerException();
        }
        return new SynchronizedMap<K, V>(map);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.710 -0400", hash_original_method = "74DA5E727C67C655DD045BA87BF8472B", hash_generated_method = "58359D5F71673E150981FBBDF7A4A5B5")
    public static <E> Set<E> synchronizedSet(Set<E> set) {
        if (set == null) {
            throw new NullPointerException();
        }
        return new SynchronizedSet<E>(set);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.717 -0400", hash_original_method = "A98AFC063D0A48542150939E7020059D", hash_generated_method = "827E66F11CFDCDFDF31DA03CFCF238ED")
    public static <K, V> SortedMap<K, V> synchronizedSortedMap(
            SortedMap<K, V> map) {
        if (map == null) {
            throw new NullPointerException();
        }
        return new SynchronizedSortedMap<K, V>(map);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.719 -0400", hash_original_method = "2B295CCFD9495D71551B5F58A07BEBAB", hash_generated_method = "780669CF622974C78D717AB6A9CC1493")
    public static <E> SortedSet<E> synchronizedSortedSet(SortedSet<E> set) {
        if (set == null) {
            throw new NullPointerException();
        }
        return new SynchronizedSortedSet<E>(set);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.721 -0400", hash_original_method = "3B4D35B7C543CBEB6CC17697CCEEE62B", hash_generated_method = "85262CB651C4F765414293B715F3DEAF")
    @SuppressWarnings("unchecked")
    public static <E> Collection<E> unmodifiableCollection(
            Collection<? extends E> collection) {
        if (collection == null) {
            throw new NullPointerException();
        }
        return new UnmodifiableCollection<E>((Collection<E>) collection);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.730 -0400", hash_original_method = "B5A8074AE8066AC7C1199AD52D55F900", hash_generated_method = "1AF25DD3231708F4537234303038B12D")
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.732 -0400", hash_original_method = "E32CF8466D0D3C027A819BD01F18D286", hash_generated_method = "E601DACA90DFEE88424A2AF79E36964E")
    @SuppressWarnings("unchecked")
    public static <K, V> Map<K, V> unmodifiableMap(
            Map<? extends K, ? extends V> map) {
        if (map == null) {
            throw new NullPointerException();
        }
        return new UnmodifiableMap<K, V>((Map<K, V>) map);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.734 -0400", hash_original_method = "732B93ED04C6C885FF5A6C566A1AD920", hash_generated_method = "9EFA18D2D76669F531FA703410E8A880")
    @SuppressWarnings("unchecked")
    public static <E> Set<E> unmodifiableSet(Set<? extends E> set) {
        if (set == null) {
            throw new NullPointerException();
        }
        return new UnmodifiableSet<E>((Set<E>) set);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.739 -0400", hash_original_method = "F9B60149CA5C4E0C4E856413AA7BBCC1", hash_generated_method = "BD6548625684DDDFD73365BFC05CC28C")
    @SuppressWarnings("unchecked")
    public static <K, V> SortedMap<K, V> unmodifiableSortedMap(
            SortedMap<K, ? extends V> map) {
        if (map == null) {
            throw new NullPointerException();
        }
        return new UnmodifiableSortedMap<K, V>((SortedMap<K, V>) map);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.743 -0400", hash_original_method = "34401690D339F7CE4C950EBE212EF143", hash_generated_method = "B3EBAE1B81EA9000A1EB9DA8E75DB12D")
    public static <E> SortedSet<E> unmodifiableSortedSet(SortedSet<E> set) {
        if (set == null) {
            throw new NullPointerException();
        }
        return new UnmodifiableSortedSet<E>(set);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.755 -0400", hash_original_method = "69760DD13D23FD7DA542C8A7346928F2", hash_generated_method = "0F52713CAE53AE324652702B4F0017FB")
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.757 -0400", hash_original_method = "75D75DD95DCB5E5DE52265A94ED70540", hash_generated_method = "F9D0490D6F2944C124AC2208751BDB76")
    @SuppressWarnings("unchecked")
    public static final <T> List<T> emptyList() {
        return EMPTY_LIST;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.759 -0400", hash_original_method = "73E5A788497714026D7280A7E3DC806D", hash_generated_method = "06F8F398E594D330A71ECA7ADF0B82F5")
    @SuppressWarnings("unchecked")
    public static final <T> Set<T> emptySet() {
        return EMPTY_SET;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.762 -0400", hash_original_method = "D72611BD94F420F8FA9573B5FA90656E", hash_generated_method = "F2BFF433AE87E0C67FF809622BBF0612")
    @SuppressWarnings("unchecked")
    public static final <K, V> Map<K, V> emptyMap() {
        return EMPTY_MAP;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.764 -0400", hash_original_method = "2F45A93FC63D40819E1B96E4A691CBD6", hash_generated_method = "BA20C7BC70673FF8B2072671BB5513CE")
    @SuppressWarnings("unchecked")
    public static <T> Enumeration<T> emptyEnumeration() {
        return (Enumeration<T>) EMPTY_ENUMERATION;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.765 -0400", hash_original_method = "349CBCC4DD02D999D655CB376FDEE3F7", hash_generated_method = "1153908B5EF7C2ADAA8A88973D2AE21F")
    @SuppressWarnings("unchecked")
    public static <T> Iterator<T> emptyIterator() {
        return (Iterator<T>) EMPTY_ITERATOR;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.769 -0400", hash_original_method = "FFB178E72EC97BEFDD63737FE0E0AD79", hash_generated_method = "C930058F1D1154DDBA7A0E46F7E92996")
    public static <T> ListIterator<T> emptyListIterator() {
        return Collections.<T>emptyList().listIterator();
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.774 -0400", hash_original_method = "DEF46954F3212FCD50E2F664CE85D90F", hash_generated_method = "77848C0E49B360C4338EA59E92A114E8")
    public static <E> Collection<E> checkedCollection(Collection<E> c,
            Class<E> type) {
        return new CheckedCollection<E>(c, type);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.776 -0400", hash_original_method = "26757EF50093F69F46B00E2488E96A0F", hash_generated_method = "B11C64597F139D458AA4131D42D096E8")
    public static <K, V> Map<K, V> checkedMap(Map<K, V> m, Class<K> keyType,
            Class<V> valueType) {
        return new CheckedMap<K, V>(m, keyType, valueType);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.778 -0400", hash_original_method = "9AFFDACEE17FE4A3968CBD94A110F361", hash_generated_method = "7ED91593A16ED489A39A8022C8262FBC")
    public static <E> List<E> checkedList(List<E> list, Class<E> type) {
        if (list instanceof RandomAccess) {
            return new CheckedRandomAccessList<E>(list, type);
        }
        return new CheckedList<E>(list, type);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.779 -0400", hash_original_method = "97926C04320CC583CBCEEBD8B4FF75E5", hash_generated_method = "2A86172C4155ED60C9BAAF25DF5728D1")
    public static <E> Set<E> checkedSet(Set<E> s, Class<E> type) {
        return new CheckedSet<E>(s, type);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.781 -0400", hash_original_method = "6FD17870AE45146EDDFA69CFB9E6F29D", hash_generated_method = "5B39EC5B7590FBB5427AC7453EA6C3CA")
    public static <K, V> SortedMap<K, V> checkedSortedMap(SortedMap<K, V> m,
            Class<K> keyType, Class<V> valueType) {
        return new CheckedSortedMap<K, V>(m, keyType, valueType);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.782 -0400", hash_original_method = "A9DFE2021401CB17AE293C849D6A117C", hash_generated_method = "7CAED30118B547485EA3992B1C0349AE")
    public static <E> SortedSet<E> checkedSortedSet(SortedSet<E> s,
            Class<E> type) {
        return new CheckedSortedSet<E>(s, type);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.784 -0400", hash_original_method = "E490B9510D2924BFC8D3C1976280F42D", hash_generated_method = "2D23F298601EA1CE2D591185E8DAC71B")
    public static <T> boolean addAll(Collection<? super T> c, T... a) {
        boolean modified = false;
        for (int i = 0; i < a.length; i++) {
            modified |= c.add(a[i]);
        }
        return modified;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.785 -0400", hash_original_method = "850D5E92CAC6694D83599DC96343182A", hash_generated_method = "4739EC0EC8671BD7C3709BF4002A041F")
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.787 -0400", hash_original_method = "1EAD1C5D0DB90DE32D6FF184DEEB9492", hash_generated_method = "0C51E31B21B812417C8D735344100763")
    static <E> E checkType(E obj, Class<? extends E> type) {
        if (obj != null && !type.isInstance(obj)) {
            throw new ClassCastException("Attempt to insert element of type " + obj.getClass() +
                    " into collection of type " + type);
        }
        return obj;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.790 -0400", hash_original_method = "4E45278DD48A168ADBD01BC7FD4B658A", hash_generated_method = "6273DD59988DC942B4763819B203FB99")
    public static <E> Set<E> newSetFromMap(Map<E, Boolean> map) {
        if (map.isEmpty()) {
            return new SetFromMap<E>(map);
        }
        throw new IllegalArgumentException();
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.793 -0400", hash_original_method = "77F9A8334F6DA18515BAA9683A005F14", hash_generated_method = "B3F57051595BF7BD740996460A0B8F5B")
    public static <T> Queue<T> asLifoQueue(Deque<T> deque) {
        return new AsLIFOQueue<T>(deque);
    }


    private static final class CopiesList extends AbstractList<Object> implements Serializable {
        private static final long serialVersionUID = 2739099268398711800L;
        private final int n;
        private final Object element;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.795 -0400", hash_original_method = "5A122D173062D06824D4571736320F87", hash_generated_method = "4616EA9BF8E2E231C22796697F8BB32A")
        @DSModeled(DSC.SAFE)
         CopiesList(int length, Object object) {
            dsTaint.addTaint(length);
            //dsTaint.addTaint(object.dsTaint);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
            // ---------- Original Method ----------
            //if (length < 0) {
                //throw new IllegalArgumentException();
            //}
            n = length;
            element = object;
        }
        
        public CopiesList(int length) {
    	    dsTaint.addTaint(length);
            //dsTaint.addTaint(object.dsTaint);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
            // ---------- Original Method ----------
            //if (length < 0) {
                //throw new IllegalArgumentException();
            //}
            n = length;
            element = new Object(); 
        }



        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.798 -0400", hash_original_method = "B07BCF81C9C48C72A08077A0468A8769", hash_generated_method = "F95B7F765956E917882DFCB013641384")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean contains(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                Object var918C716CCB523821E4DE921B4E432F42_2081958819 = (element.equals(object));
            } //End flattened ternary
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return element == null ? object == null : element.equals(object);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.799 -0400", hash_original_method = "61094B9B9DEC6161E82512577FAF3323", hash_generated_method = "FC84746358C0AD219EE4E552EE1ABF36")
        @DSModeled(DSC.SAFE)
        @Override
        public int size() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return n;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.801 -0400", hash_original_method = "857A70B35DA7146CF7ADC484EC4AABC8", hash_generated_method = "813E45065670BF38DC37F14D2250A52B")
        @DSModeled(DSC.SAFE)
        @Override
        public Object get(int location) {
            dsTaint.addTaint(location);
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            return dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (location >= 0 && location < n) {
                //return element;
            //}
            //throw new IndexOutOfBoundsException();
        }
    }



    private static final class EmptyList extends AbstractList implements RandomAccess, Serializable {
        private static final long serialVersionUID = 8842843931221139166L;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.804 -0400", hash_original_method = "38B750FD34BF6CB1144CDF020D3299E6", hash_generated_method = "C484A77686DD466B6A63CDF43C859A80")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean contains(Object object) {
            dsTaint.addTaint(object.dsTaint);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.806 -0400", hash_original_method = "F4586E3A64B5D10DEB709A723C85E55E", hash_generated_method = "3758599F04938929F49FAB44F9BE5DBC")
        @DSModeled(DSC.SAFE)
        @Override
        public int size() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.808 -0400", hash_original_method = "F59F44D1664BC2EE59D5A9B30D144285", hash_generated_method = "2A7AE74564A65013D788A72BB9C4BCF8")
        @DSModeled(DSC.SAFE)
        @Override
        public Object get(int location) {
            dsTaint.addTaint(location);
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //throw new IndexOutOfBoundsException();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.809 -0400", hash_original_method = "3CB4CAF1EADC3F12C565BD7D2B5F5514", hash_generated_method = "45859EC24535F94D96C808B4A126ABAE")
        @DSModeled(DSC.SAFE)
        private Object readResolve() {
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return Collections.EMPTY_LIST;
        }


    }



    private static final class EmptySet extends AbstractSet implements Serializable {
        private static final long serialVersionUID = 1582296315990362920L;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.811 -0400", hash_original_method = "38B750FD34BF6CB1144CDF020D3299E6", hash_generated_method = "C484A77686DD466B6A63CDF43C859A80")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean contains(Object object) {
            dsTaint.addTaint(object.dsTaint);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.813 -0400", hash_original_method = "F4586E3A64B5D10DEB709A723C85E55E", hash_generated_method = "3758599F04938929F49FAB44F9BE5DBC")
        @DSModeled(DSC.SAFE)
        @Override
        public int size() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.814 -0400", hash_original_method = "FC88A4B2F50E498E162F3F7EEDE885B1", hash_generated_method = "A74417724F59107357B2DC48AA27CCD0")
        @DSModeled(DSC.SAFE)
        @Override
        public Iterator iterator() {
            return (Iterator)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return EMPTY_ITERATOR;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.817 -0400", hash_original_method = "2ED0845ADEAE5655731C197578B08F82", hash_generated_method = "C1160ECDC17CDCF83CBA764FAE6B181C")
        @DSModeled(DSC.SAFE)
        private Object readResolve() {
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return Collections.EMPTY_SET;
        }


    }



    private static final class EmptyMap extends AbstractMap implements Serializable {
        private static final long serialVersionUID = 6428348081105594320L;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.819 -0400", hash_original_method = "2AD0E7E75E88E287D6229481B74BEBCC", hash_generated_method = "753A68D9624A07455D114036E463F5BB")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean containsKey(Object key) {
            dsTaint.addTaint(key.dsTaint);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.825 -0400", hash_original_method = "9D32B6FFC088649ED5480F6E533A1288", hash_generated_method = "E46274FE8FABD93976444FBB5D0BD212")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean containsValue(Object value) {
            dsTaint.addTaint(value.dsTaint);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.827 -0400", hash_original_method = "709DD403C63D2F4104FF93FEEB6E3457", hash_generated_method = "EA104C1038D32B75BD3A755BE31BA4C6")
        @DSModeled(DSC.SAFE)
        @Override
        public Set entrySet() {
            return (Set)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return EMPTY_SET;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.829 -0400", hash_original_method = "59A1188DDD48CFFB749850DC2DA09C1D", hash_generated_method = "64892D182ED1FA980DB633DE2E4F6329")
        @DSModeled(DSC.SAFE)
        @Override
        public Object get(Object key) {
            dsTaint.addTaint(key.dsTaint);
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return null;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.830 -0400", hash_original_method = "266B164C16644761E32491964C192EB7", hash_generated_method = "CBCE00703C0D2AB2BE7A41B5560856C4")
        @DSModeled(DSC.SAFE)
        @Override
        public Set keySet() {
            return (Set)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return EMPTY_SET;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.844 -0400", hash_original_method = "745E6E226DD5F7D4E763DA74DFF70792", hash_generated_method = "F0FA12E9C1049A9FEDB64993C018B3B8")
        @DSModeled(DSC.SAFE)
        @Override
        public Collection values() {
            return (Collection)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return EMPTY_LIST;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.848 -0400", hash_original_method = "59A22E9415A338EB85D7A7DD214359CC", hash_generated_method = "2B1B2568D8C89EB54063E4ED3957C683")
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.857 -0400", hash_original_method = "907488F1D5625FE5C9F59ED8A7B6E697", hash_generated_method = "40BCE5830411B50573036093381A4904")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @SuppressWarnings("unchecked")
        @Override
        public int compare(T o1, T o2) {
            dsTaint.addTaint(o2.dsTaint);
            dsTaint.addTaint(o1.dsTaint);
            Comparable<T> c2;
            c2 = (Comparable<T>) o2;
            int var692167FC6770150DF2B5DF91BFB83EC2_1875171908 = (c2.compareTo(o1));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //Comparable<T> c2 = (Comparable<T>) o2;
            //return c2.compareTo(o1);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.868 -0400", hash_original_method = "DD371F0FDF8300FDCFBD1E5C395D42BC", hash_generated_method = "34F11C83B2727316E14F7DFFDA03F68F")
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.870 -0400", hash_original_method = "1ABA0972F29BDB004C28A1246ABEF788", hash_generated_method = "2998CE5678F8452038B74C404414921C")
        @DSModeled(DSC.SAFE)
         ReverseComparator2(Comparator<T> comparator) {
            dsTaint.addTaint(comparator.dsTaint);
            // ---------- Original Method ----------
            this.cmp = comparator;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.875 -0400", hash_original_method = "449D1B24DD0E97F4D53DEB786BD04597", hash_generated_method = "C52D7FAB091A987B2EE87630CDBB38B7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int compare(T o1, T o2) {
            dsTaint.addTaint(o2.dsTaint);
            dsTaint.addTaint(o1.dsTaint);
            int varC3FAEC3684B290716428C4AB73BA307C_1286406918 = (cmp.compare(o2, o1));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return cmp.compare(o2, o1);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.878 -0400", hash_original_method = "30689CAB8FBFDCB9289EF03377EE08A0", hash_generated_method = "90AB41341556B153E2DDFED0099988F3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object o) {
            dsTaint.addTaint(o.dsTaint);
            boolean varB42AC7AE9468AAA515C4B77EBD2F7BC7_860102543 = (o instanceof ReverseComparator2
                    && ((ReverseComparator2) o).cmp.equals(cmp));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return o instanceof ReverseComparator2
                    //&& ((ReverseComparator2) o).cmp.equals(cmp);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.885 -0400", hash_original_method = "CAA612A5887D060562790EB1CDD1FEFE", hash_generated_method = "BB63457619A2BEF3DA628211455A2407")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int varFAD4BDCF5F08AFF151A94355744A94BB_1425399475 = (~cmp.hashCode());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return ~cmp.hashCode();
        }


    }



    private static final class SingletonSet<E> extends AbstractSet<E> implements Serializable {
        private static final long serialVersionUID = 3193687207550431679L;
        final E element;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.887 -0400", hash_original_method = "044BE6981927B9234E2AE8686E07A72F", hash_generated_method = "6F43C33BE0EDBBCCC839475B4AEDEB84")
        @DSModeled(DSC.SAFE)
         SingletonSet(E object) {
            dsTaint.addTaint(object.dsTaint);
            // ---------- Original Method ----------
            element = object;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.898 -0400", hash_original_method = "B07BCF81C9C48C72A08077A0468A8769", hash_generated_method = "03E8EFD2CCD92DA448B62D2998005DBD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean contains(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                Object var918C716CCB523821E4DE921B4E432F42_1860506222 = (element.equals(object));
            } //End flattened ternary
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return element == null ? object == null : element.equals(object);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.900 -0400", hash_original_method = "798A0AE2F2A6352396904AB5C9ED97D5", hash_generated_method = "B297A1211E718A1D34F594A0541039B7")
        @DSModeled(DSC.SAFE)
        @Override
        public int size() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 1;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.901 -0400", hash_original_method = "135AC18A6A8AD4548E2E750F2D4C7699", hash_generated_method = "3BCF86373F43570A953F3B01E8AC4196")
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.906 -0400", hash_original_method = "F3174A5FA7BA5962D109EAC3245F2C1D", hash_generated_method = "FDCC8095FB9FFA2E6168557E63486A7F")
        @DSModeled(DSC.SAFE)
         SingletonList(E object) {
            dsTaint.addTaint(object.dsTaint);
            // ---------- Original Method ----------
            element = object;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.909 -0400", hash_original_method = "B07BCF81C9C48C72A08077A0468A8769", hash_generated_method = "0A391161EF41FADD7A8F8385371D910D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean contains(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                Object var918C716CCB523821E4DE921B4E432F42_511374454 = (element.equals(object));
            } //End flattened ternary
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return element == null ? object == null : element.equals(object);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.911 -0400", hash_original_method = "1C6E7D1EB082158D5E00EA29E883A612", hash_generated_method = "D7CB2253F31AFF31ACEBE2E831186314")
        @DSModeled(DSC.SAFE)
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


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.912 -0400", hash_original_method = "798A0AE2F2A6352396904AB5C9ED97D5", hash_generated_method = "B297A1211E718A1D34F594A0541039B7")
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.918 -0400", hash_original_method = "85D3D420EE431E7A3C1CBFB71D1CEAE2", hash_generated_method = "3031694470ADF5215E79E7B0B4F0DAE1")
        @DSModeled(DSC.SAFE)
         SingletonMap(K key, V value) {
            dsTaint.addTaint(value.dsTaint);
            dsTaint.addTaint(key.dsTaint);
            // ---------- Original Method ----------
            k = key;
            v = value;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.922 -0400", hash_original_method = "26D5E87A2C62405ADA3B15C5C8B30FEC", hash_generated_method = "C2CDA0FA5718A9147EF7FE55DBA69B04")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsKey(Object key) {
            dsTaint.addTaint(key.dsTaint);
            {
                Object var0EB569FD4AF21D116A21E287F6027A39_577849089 = (k.equals(key));
            } //End flattened ternary
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return k == null ? key == null : k.equals(key);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.925 -0400", hash_original_method = "827D42B4F919454EC51CA86D0E534994", hash_generated_method = "3E77F6A217A99162D90E252643031499")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsValue(Object value) {
            dsTaint.addTaint(value.dsTaint);
            {
                Object var1F74AE50105434A557EE1F3FD50522E7_2128621492 = (v.equals(value));
            } //End flattened ternary
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return v == null ? value == null : v.equals(value);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.927 -0400", hash_original_method = "8C587096F5E6029DBB187C58CF22D158", hash_generated_method = "38D4860E309555EB470227141A100B69")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public V get(Object key) {
            dsTaint.addTaint(key.dsTaint);
            {
                boolean varD8EB9E9C73E773501877E01187F3B5DA_558470017 = (containsKey(key));
            } //End collapsed parenthetic
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (containsKey(key)) {
                //return v;
            //}
            //return null;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.929 -0400", hash_original_method = "798A0AE2F2A6352396904AB5C9ED97D5", hash_generated_method = "B297A1211E718A1D34F594A0541039B7")
        @DSModeled(DSC.SAFE)
        @Override
        public int size() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 1;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.930 -0400", hash_original_method = "AB4A6E093F1AE40B73184C21F1D08E5E", hash_generated_method = "61713F515EC7D8BEB7A8B71BE9D9F6FA")
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.937 -0400", hash_original_method = "30FA7B26D2517E75155300E21A44EE02", hash_generated_method = "F71C7C8FDA3C6A34CD3ABA7D840B5C0F")
        @DSModeled(DSC.SAFE)
         SynchronizedCollection(Collection<E> collection) {
            dsTaint.addTaint(collection.dsTaint);
            mutex = this;
            // ---------- Original Method ----------
            c = collection;
            //mutex = this;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.947 -0400", hash_original_method = "A2A350BD37040709EC39C6B0536AFBDE", hash_generated_method = "8E0E3C245A37B9462D76E8441F71257B")
        @DSModeled(DSC.SAFE)
         SynchronizedCollection(Collection<E> collection, Object mutex) {
            dsTaint.addTaint(mutex.dsTaint);
            dsTaint.addTaint(collection.dsTaint);
            // ---------- Original Method ----------
            c = collection;
            this.mutex = mutex;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.951 -0400", hash_original_method = "FB2AC5CD0A8119C2DE50A53F38732CDD", hash_generated_method = "6100C61303D14664B52CA9B6D861962A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean add(E object) {
            dsTaint.addTaint(object.dsTaint);
            {
                boolean var2BB0FD33FED1B2B72867ACF06FBFC56B_414855815 = (c.add(object));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.add(object);
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.954 -0400", hash_original_method = "8489E829BC0B88048B305735D46B1D99", hash_generated_method = "E1E92C3C573B48C2A032E55F9EE643CA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean addAll(Collection<? extends E> collection) {
            dsTaint.addTaint(collection.dsTaint);
            {
                boolean varAB7EBFBCA4F45D51E737154B11C4108B_450332264 = (c.addAll(collection));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.addAll(collection);
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.957 -0400", hash_original_method = "7AE3345D011114FF0F62A8DFD7762BE2", hash_generated_method = "F61AFEA220D9937EED4DD567DC05838D")
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


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.960 -0400", hash_original_method = "1B12503F1112F0CD581293F3A624FEFF", hash_generated_method = "701EC5278E3442D8788D0D5C195182CB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean contains(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                boolean var34971DB84F983FD59B337EBDA19618A7_693893786 = (c.contains(object));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.contains(object);
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.962 -0400", hash_original_method = "F945FF2C907D1AA0923D46DECCCD5EAD", hash_generated_method = "D3A224A7A11E8A64FE1A5CDCA728AF4A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            {
                boolean varDACCFBFB1E0F996A35B7BB8B776BF827_644858038 = (c.containsAll(collection));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.containsAll(collection);
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.964 -0400", hash_original_method = "FC4F88C8FB9F4E3716AD2ABCD3101657", hash_generated_method = "B556CBEFD716E2E29F71DBF2592140D1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean isEmpty() {
            {
                boolean var13DC031C5380F0C4DA515946E668AE17_583224976 = (c.isEmpty());
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.isEmpty();
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.966 -0400", hash_original_method = "7F1B5E60A4E4F9F3AFA65965967FBBF0", hash_generated_method = "CEB3FD833C604E9D5D436863BE61DBB3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Iterator<E> iterator() {
            {
                Iterator<E> var24A0D29F595F4955177CF826CFD2CBB4_1428947046 = (c.iterator());
            } //End block
            return (Iterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.iterator();
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.968 -0400", hash_original_method = "C85E45E4AF074973339408E1197B653C", hash_generated_method = "DB51B99B45C3734A572C89705E5237BA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean remove(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                boolean var8E355775017A5ED204FCCA7510D23187_1677448700 = (c.remove(object));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.remove(object);
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.969 -0400", hash_original_method = "63829008A74D54A464D81619215951F3", hash_generated_method = "7EB2469955706F282DE8287279A38494")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean removeAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            {
                boolean var1464AF4DDAD9564C54B239B0335D2517_1357115559 = (c.removeAll(collection));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.removeAll(collection);
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.971 -0400", hash_original_method = "F83427C5B4EF86DB8198B3D2BAE482AC", hash_generated_method = "8541697F7913FFBC74F395EF71D6598A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean retainAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            {
                boolean varF2E46B90912EE4E31AEA6D3F646498E8_140743378 = (c.retainAll(collection));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.retainAll(collection);
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.975 -0400", hash_original_method = "8641BC878FB77D36CE60B1977D7C0FB5", hash_generated_method = "B880F2AA746F965F27297160DDC6CB33")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int size() {
            {
                int var0E51EFE72011B352AF314992F697E7C3_982999397 = (c.size());
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.size();
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.978 -0400", hash_original_method = "214BCEC14D5449B585926B657D8D51C2", hash_generated_method = "7E5ECA07FC9A50D8DF7B01069E0E7DCC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public java.lang.Object[] toArray() {
            {
                java.lang.Object[] var3F2D8DA9C0222705DC9C1F072168E1F8_1491149091 = (c.toArray());
            } //End block
            return (java.lang.Object[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.toArray();
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.980 -0400", hash_original_method = "D637F0F4C3C8C312A0597F30C1C6DB59", hash_generated_method = "B46A300721F89565C7F6E7AFAB278592")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            {
                String varDA4751CDF147B4450C76D2AC5CA38320_2093225033 = (c.toString());
            } //End block
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.toString();
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.982 -0400", hash_original_method = "567EED27866E99DFC1B7F8B43B648D82", hash_generated_method = "B35E2669FF577B3C32A9B3D1B6F3CA6D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public <T> T[] toArray(T[] array) {
            dsTaint.addTaint(array[0].dsTaint);
            {
                T[] var5D23623B3310566BAD78670724549A14_1701112952 = (c.toArray(array));
            } //End block
            return (T[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.toArray(array);
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.984 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "6001D7B256B91F08C850EFC8421AA226")
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.986 -0400", hash_original_method = "B7E7091552AE239FAE56C332916C1F88", hash_generated_method = "82BFACD42C2297AAD8262E74EEEB2F4C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SynchronizedRandomAccessList(List<E> l) {
            super(l);
            dsTaint.addTaint(l.dsTaint);
            // ---------- Original Method ----------
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.987 -0400", hash_original_method = "333C2DB156927D33EFC68D095A4D91C7", hash_generated_method = "05ACD6BF9EF868EE70FF78FF5785BFD9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SynchronizedRandomAccessList(List<E> l, Object mutex) {
            super(l, mutex);
            dsTaint.addTaint(mutex.dsTaint);
            dsTaint.addTaint(l.dsTaint);
            // ---------- Original Method ----------
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.989 -0400", hash_original_method = "52EB3707ADD11A2326D60B7B815140D9", hash_generated_method = "8DB7FA336723F9CD2AED17102EE85E8C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public List<E> subList(int start, int end) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(end);
            {
                List<E> var79F4B4FC1730C00495472D64C06A5972_1452370429 = (new SynchronizedRandomAccessList<E>(list.subList(start, end), mutex));
            } //End block
            return (List<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedRandomAccessList<E>(list.subList(start, end), mutex);
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.991 -0400", hash_original_method = "3A06B4F1BF7736CF10F2183ECBC34EF4", hash_generated_method = "E33B997055ADB9FE6AAEFFE34613170E")
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.994 -0400", hash_original_method = "557BC04FB4751FAF0774C664BC5CCEDB", hash_generated_method = "ED866C5CCE5B8540209DF43AC567233E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SynchronizedList(List<E> l) {
            super(l);
            dsTaint.addTaint(l.dsTaint);
            // ---------- Original Method ----------
            list = l;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.995 -0400", hash_original_method = "6BB690026CB7D337AD2D522FD2C1D564", hash_generated_method = "904C60DA0082C3B1ECA4D2B66725ACF3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SynchronizedList(List<E> l, Object mutex) {
            super(l, mutex);
            dsTaint.addTaint(mutex.dsTaint);
            dsTaint.addTaint(l.dsTaint);
            // ---------- Original Method ----------
            list = l;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.997 -0400", hash_original_method = "771543DB5FBF857EC43E623C900790C1", hash_generated_method = "554450E0E64B2800881B3E3B804CBAC0")
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


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:40.998 -0400", hash_original_method = "2E8B0D036C339DEB52EAEECF82B3FC29", hash_generated_method = "E518A80F80A5BADE9B0EF15868F6CE56")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean addAll(int location, Collection<? extends E> collection) {
            dsTaint.addTaint(location);
            dsTaint.addTaint(collection.dsTaint);
            {
                boolean var158D83A08C48A45A82B28798671769C1_1270250854 = (list.addAll(location, collection));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.addAll(location, collection);
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.000 -0400", hash_original_method = "3D6B0DEE3E066475015263D28B67E9C7", hash_generated_method = "B5082A7BF2F945C076E4DB316AAF13EB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                boolean varB8EFBCA5568090BA0F116E782A49968B_816220603 = (list.equals(object));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.equals(object);
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.002 -0400", hash_original_method = "5B64BB89A58DED71DBA9907C06BC2CBB", hash_generated_method = "7B98086986E2FA8B066944FDA570EEC9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E get(int location) {
            dsTaint.addTaint(location);
            {
                E var73B0B58D8D3D7335145E2B8B6AC44D88_1930264100 = (list.get(location));
            } //End block
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.get(location);
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.004 -0400", hash_original_method = "4F5947DB3C3ABC0CDEDCB631295417DE", hash_generated_method = "CA11C80DB9AF53F6CE1609DAA849DE90")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            {
                int varE89315CE67DD6395C812E01B5B28CC79_317977988 = (list.hashCode());
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.hashCode();
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.015 -0400", hash_original_method = "3D24998665BD619FA01B00E0A34A83F5", hash_generated_method = "8B993438ED72BE3D5FA99B25E62CACD1")
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
                            boolean varE4EB18CE7254896A48F2456CD1C5820F_940169736 = (object.equals(array[i]));
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


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.019 -0400", hash_original_method = "615F71337583130515178716D1767A86", hash_generated_method = "89CD741A847FA27FC58FBC590D2FF437")
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
                            boolean varE4EB18CE7254896A48F2456CD1C5820F_1961365666 = (object.equals(array[i]));
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


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.021 -0400", hash_original_method = "9E49E91DE129681261C3C7642C2D1127", hash_generated_method = "044A67BD3214EBED62169A7924E3E9FC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public ListIterator<E> listIterator() {
            {
                ListIterator<E> var76349BCE7583779F3F3F157CAF26DD4C_493985013 = (list.listIterator());
            } //End block
            return (ListIterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.listIterator();
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.023 -0400", hash_original_method = "70349F3896FC81F4D21A3D35B0C8A4F6", hash_generated_method = "293AC7448D78A3DA3172BD003C2B9533")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public ListIterator<E> listIterator(int location) {
            dsTaint.addTaint(location);
            {
                ListIterator<E> var71730C54CD0BAB9C07323A68A1A20AE4_1312873224 = (list.listIterator(location));
            } //End block
            return (ListIterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.listIterator(location);
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.025 -0400", hash_original_method = "D935E09B492D323BEF59297A7648FE48", hash_generated_method = "B0EEA2AED4A0BC50B3D6CA5B197BD120")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E remove(int location) {
            dsTaint.addTaint(location);
            {
                E var8A9D2AEA7F5291AA8B5F07EF2501777A_1831050249 = (list.remove(location));
            } //End block
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.remove(location);
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.027 -0400", hash_original_method = "D9730991663FB8C206D80781B7E02750", hash_generated_method = "CE5AC4E3EED41A21214FD57E12D01080")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E set(int location, E object) {
            dsTaint.addTaint(location);
            dsTaint.addTaint(object.dsTaint);
            {
                E var99FBB8BC1ADB365164A853DDBCC975BF_385890747 = (list.set(location, object));
            } //End block
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return list.set(location, object);
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.029 -0400", hash_original_method = "C38F2D62AA6D1EBD255ADC5369CBEC01", hash_generated_method = "E6CAF3C6C1B2CA975B6174C56DD924A1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public List<E> subList(int start, int end) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(end);
            {
                List<E> var6FDAAEF93DBE6A1FE8237A35A66F1C47_1022179509 = (new SynchronizedList<E>(list.subList(start, end), mutex));
            } //End block
            return (List<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedList<E>(list.subList(start, end), mutex);
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.031 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "6001D7B256B91F08C850EFC8421AA226")
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


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.033 -0400", hash_original_method = "172F08E6F2352F1764A4A70C48C6E243", hash_generated_method = "27053DFF59060ADAD999927A6ECE4E61")
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.035 -0400", hash_original_method = "C14189E3F71A4C148CB91C638F3BAAE3", hash_generated_method = "2616A09CADEFBE498D5704A0229BCF47")
        @DSModeled(DSC.SAFE)
         SynchronizedMap(Map<K, V> map) {
            dsTaint.addTaint(map.dsTaint);
            mutex = this;
            // ---------- Original Method ----------
            m = map;
            //mutex = this;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.036 -0400", hash_original_method = "6EAD9DD813CFD47244744C3F6D6A4D1C", hash_generated_method = "934F05BC4AC32CFE49361C2B60E85BB9")
        @DSModeled(DSC.SAFE)
         SynchronizedMap(Map<K, V> map, Object mutex) {
            dsTaint.addTaint(mutex.dsTaint);
            dsTaint.addTaint(map.dsTaint);
            // ---------- Original Method ----------
            m = map;
            this.mutex = mutex;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.040 -0400", hash_original_method = "3DCF075501F09300584E40825720BBA2", hash_generated_method = "3A0A2D335B1D2F737F299BBE51B1D966")
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


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.046 -0400", hash_original_method = "D2C67B34100B05197A0572527ECA3220", hash_generated_method = "1850FA9DAF8B6BF7150A6D14C009DAE1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsKey(Object key) {
            dsTaint.addTaint(key.dsTaint);
            {
                boolean var5B3943E8DB1DEBF4053A7AC85BD5CB7F_649682335 = (m.containsKey(key));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.containsKey(key);
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.049 -0400", hash_original_method = "FFE2162DB44C1E8BEEAD35935B233C81", hash_generated_method = "186D499E6B64C6C14A490D106DFEAA11")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsValue(Object value) {
            dsTaint.addTaint(value.dsTaint);
            {
                boolean var9B502A789B5AAD38CD0ED829F2887AEF_647126903 = (m.containsValue(value));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.containsValue(value);
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.051 -0400", hash_original_method = "E5EA9A3F9567269DAA52E0C08140D3D5", hash_generated_method = "2E09CD4606F3F2F2C77F06D14702D519")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            {
                Set<Map.Entry<K, V>> varCCB5BAB8CD8236FC7E7EE18A7FE8FDA2_1395554127 = (new SynchronizedSet<Map.Entry<K, V>>(m.entrySet(), mutex));
            } //End block
            return (Set<Map.Entry<K, V>>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSet<Map.Entry<K, V>>(m.entrySet(), mutex);
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.053 -0400", hash_original_method = "573EFA9740FEBDEC9C1CCFD8172CCEF0", hash_generated_method = "13E374B7AF5FD4E0FDE989C678406956")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                boolean var3653CC7A1B6721F556FDF4EA3FD61A52_722713690 = (m.equals(object));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.equals(object);
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.057 -0400", hash_original_method = "80DF7D6FED6980DF61457325CD64503D", hash_generated_method = "C0B2C8EBDB4E49F1C82901802DDCE96F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public V get(Object key) {
            dsTaint.addTaint(key.dsTaint);
            {
                V var474A70B52BFFEC8B20AC6270DFA16E1F_959866118 = (m.get(key));
            } //End block
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.get(key);
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.059 -0400", hash_original_method = "5DDF560D56DA8F61EEAD582BB150A893", hash_generated_method = "CCF9840F7BFF54E7505C501583486525")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            {
                int var58938B03D27AEF577E5F8B43D45478A1_1228209579 = (m.hashCode());
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.hashCode();
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.060 -0400", hash_original_method = "40A122CDBD7096230690259CC30A0F7A", hash_generated_method = "D57F42B48AC0A6E918207BCAAEF924DD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean isEmpty() {
            {
                boolean var20AA7E3C23DC3AFB5FE1B5D3BD0CE158_1680525779 = (m.isEmpty());
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.isEmpty();
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.063 -0400", hash_original_method = "2FBB6190D51F2A6210F8CF71191E69DD", hash_generated_method = "663ED1E515E97FF3261BC2426F3E021F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Set<K> keySet() {
            {
                Set<K> var0BD25AF91FBC2C9D7A5D0DBCD935921E_1400569969 = (new SynchronizedSet<K>(m.keySet(), mutex));
            } //End block
            return (Set<K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSet<K>(m.keySet(), mutex);
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.065 -0400", hash_original_method = "4BBBC2EF3E646AB7C0C1BFCAE8571FAF", hash_generated_method = "22B189B5704CDD506725C6380D4321C2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public V put(K key, V value) {
            dsTaint.addTaint(value.dsTaint);
            dsTaint.addTaint(key.dsTaint);
            {
                V var636674CA8442FF245A35ED4C39B478C0_238424305 = (m.put(key, value));
            } //End block
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.put(key, value);
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.071 -0400", hash_original_method = "400FF0E6707670DAA4FF7ECA275302A3", hash_generated_method = "935458F8EC7F77EFDD9CD52B724C2EE7")
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


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.074 -0400", hash_original_method = "98B37460DCD5FD18048F5172283C3141", hash_generated_method = "A7413D49B919C94BC389EAB85D01C5F3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public V remove(Object key) {
            dsTaint.addTaint(key.dsTaint);
            {
                V var6330C1F751AFF9358410A0C6CDD88E9D_1271405585 = (m.remove(key));
            } //End block
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.remove(key);
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.077 -0400", hash_original_method = "A48EE7C65347333E889EFC2ECD0A019A", hash_generated_method = "1ABD35C83B9B59633A0394D61516CCB9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int size() {
            {
                int var0BF7698F6735353014CC57B558785727_1378385007 = (m.size());
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.size();
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.079 -0400", hash_original_method = "BB797020E54DC33FB15BC9404E89E5CD", hash_generated_method = "25039651214C99D8398E1AE6250C2548")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Collection<V> values() {
            {
                Collection<V> varA250843E6E6DC30A02405715361D4AB0_473572856 = (new SynchronizedCollection<V>(m.values(), mutex));
            } //End block
            return (Collection<V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedCollection<V>(m.values(), mutex);
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.081 -0400", hash_original_method = "CB61B465EF18C12F472B81636CD4AC79", hash_generated_method = "CAD5DCDDEC3225D60FF378ADAA3B79FE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            {
                String var955C11A8135722B04F0E9199D1AEFE75_2097180152 = (m.toString());
            } //End block
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return m.toString();
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.082 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "6001D7B256B91F08C850EFC8421AA226")
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.084 -0400", hash_original_method = "F3863A567ABAC10F9410ABCF2A4DC8AC", hash_generated_method = "2D2D7A07B8EB52B9E71B84200AC7DA02")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SynchronizedSet(Set<E> set) {
            super(set);
            dsTaint.addTaint(set.dsTaint);
            // ---------- Original Method ----------
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.085 -0400", hash_original_method = "A1BA2E3E145DCA2C522F0AB9439A1572", hash_generated_method = "90B7E706DF5646F1084FC04AF8669537")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SynchronizedSet(Set<E> set, Object mutex) {
            super(set, mutex);
            dsTaint.addTaint(mutex.dsTaint);
            dsTaint.addTaint(set.dsTaint);
            // ---------- Original Method ----------
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.087 -0400", hash_original_method = "E045FF0B832C85F3AF0597463FE3892F", hash_generated_method = "702110A60C4E142E2A0ADCA73543E451")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                boolean varEA83122D095DC61C01436A4AA2CBB70C_451072607 = (c.equals(object));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.equals(object);
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.089 -0400", hash_original_method = "60CA731F9E7ECB7D3EED20B0D6D4AB09", hash_generated_method = "02A6F31B1A6781184AAD41B7FFA20991")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            {
                int varDBC342B671922A4943718E25F26D87D0_1495363703 = (c.hashCode());
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return c.hashCode();
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.091 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "6001D7B256B91F08C850EFC8421AA226")
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.093 -0400", hash_original_method = "2E0F62BCD34367F1E6E251286E17ABEB", hash_generated_method = "CED4518808A1B6E3DBF59B2B29C4D376")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SynchronizedSortedMap(SortedMap<K, V> map) {
            super(map);
            dsTaint.addTaint(map.dsTaint);
            // ---------- Original Method ----------
            sm = map;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.094 -0400", hash_original_method = "5BF33998E3FF0155F7A513C6A201FE85", hash_generated_method = "CCB0196D8995C70169C4DA033A52F020")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SynchronizedSortedMap(SortedMap<K, V> map, Object mutex) {
            super(map, mutex);
            dsTaint.addTaint(mutex.dsTaint);
            dsTaint.addTaint(map.dsTaint);
            // ---------- Original Method ----------
            sm = map;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.097 -0400", hash_original_method = "78218A5A359D1FCDF6B98779037FCB94", hash_generated_method = "16227E53FBF50BF76498B12A96F769FF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Comparator<? super K> comparator() {
            {
                Comparator<? super K> varC89FBD52D1D81FD4CD4799B6E3332E0D_1721930635 = (sm.comparator());
            } //End block
            return (Comparator<? super K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return sm.comparator();
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.098 -0400", hash_original_method = "4A44F83861E496A35113DD67FECD390A", hash_generated_method = "B6EFFA3BB77FBBD77F1013933FDD62D8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public K firstKey() {
            {
                K var0B1470D61B8C6A68C7AB229BEA61F31E_735733734 = (sm.firstKey());
            } //End block
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return sm.firstKey();
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.101 -0400", hash_original_method = "758EF70CDC2061BD7D7B124D17EF3F64", hash_generated_method = "FF62BC3E7C5E374727AA4C3F3BA90D7B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedMap<K, V> headMap(K endKey) {
            dsTaint.addTaint(endKey.dsTaint);
            {
                SortedMap<K, V> var7A26954CB6FBB8853F179AAC3A9F4686_1327916844 = (new SynchronizedSortedMap<K, V>(sm.headMap(endKey),
                        mutex));
            } //End block
            return (SortedMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedMap<K, V>(sm.headMap(endKey),
                        //mutex);
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.103 -0400", hash_original_method = "ECB924A52CC9F341D1EEB7E5D7BCCDC8", hash_generated_method = "ACCADFF04EC30F6577B2C6D23EC6E55D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public K lastKey() {
            {
                K var7B2CD408EC41D2035EDE4EA469E2194A_1929990806 = (sm.lastKey());
            } //End block
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return sm.lastKey();
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.115 -0400", hash_original_method = "E82E6227AA62F00EB1D33B47A72F41C4", hash_generated_method = "404A03BF2FFA3E5AD184F0A15CB74106")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedMap<K, V> subMap(K startKey, K endKey) {
            dsTaint.addTaint(endKey.dsTaint);
            dsTaint.addTaint(startKey.dsTaint);
            {
                SortedMap<K, V> var78669850D4141AD418B91306E95EF040_1623821801 = (new SynchronizedSortedMap<K, V>(sm.subMap(startKey,
                        endKey), mutex));
            } //End block
            return (SortedMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedMap<K, V>(sm.subMap(startKey,
                        //endKey), mutex);
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.117 -0400", hash_original_method = "F7B84D714F16D295C7D43C8AA5E52D6A", hash_generated_method = "254D0EA47C505D6C7A71D556C6DC7F4B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedMap<K, V> tailMap(K startKey) {
            dsTaint.addTaint(startKey.dsTaint);
            {
                SortedMap<K, V> varB8FFAC01CC3EFAB07B9BE216D054FA49_1220694902 = (new SynchronizedSortedMap<K, V>(sm.tailMap(startKey),
                        mutex));
            } //End block
            return (SortedMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedMap<K, V>(sm.tailMap(startKey),
                        //mutex);
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.119 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "6001D7B256B91F08C850EFC8421AA226")
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.121 -0400", hash_original_method = "B2F0E775DF29B0E6B28447766B0AA532", hash_generated_method = "5987A3D9286F010FF2A9B19B86F8A1BD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SynchronizedSortedSet(SortedSet<E> set) {
            super(set);
            dsTaint.addTaint(set.dsTaint);
            // ---------- Original Method ----------
            ss = set;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.123 -0400", hash_original_method = "46957450EFA60C06BEFC5742F9BFAC78", hash_generated_method = "AD36C2F291DBB1191783901C5A344D0C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SynchronizedSortedSet(SortedSet<E> set, Object mutex) {
            super(set, mutex);
            dsTaint.addTaint(mutex.dsTaint);
            dsTaint.addTaint(set.dsTaint);
            // ---------- Original Method ----------
            ss = set;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.125 -0400", hash_original_method = "D71F7DA0E84FA7A091B4017D559410C5", hash_generated_method = "8B5A7D1BBD93C004ABE2F43EBF4735BE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Comparator<? super E> comparator() {
            {
                Comparator<? super E> var07F86D8CCDDD798A45018D2AA9A359B8_1803576159 = (ss.comparator());
            } //End block
            return (Comparator<? super E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return ss.comparator();
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.126 -0400", hash_original_method = "C2C55C7E331CFDE8E84B8FC74FDABE02", hash_generated_method = "21FB71AEA50D5594F6EA17DC8FD3D27D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E first() {
            {
                E var89000B20893EE4C394CCC342448E11A0_14591163 = (ss.first());
            } //End block
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return ss.first();
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.128 -0400", hash_original_method = "86DA75392AF50D6AE53AEE4A4052EBA8", hash_generated_method = "A8C6F65C883B360AB5A94FAEA7696311")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedSet<E> headSet(E end) {
            dsTaint.addTaint(end.dsTaint);
            {
                SortedSet<E> varB346FB35B6D1C44194007A04DD623FE8_1487310885 = (new SynchronizedSortedSet<E>(ss.headSet(end), mutex));
            } //End block
            return (SortedSet<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedSet<E>(ss.headSet(end), mutex);
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.130 -0400", hash_original_method = "3C10DA3BCCE6BED4EBD1F6A2C6BC8438", hash_generated_method = "382E28DC50865F1399E67FD43CBE3E45")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E last() {
            {
                E varD2F8215971D155E32BF00B454EA993B4_550124971 = (ss.last());
            } //End block
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return ss.last();
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.136 -0400", hash_original_method = "662A59FFAA1C1722D75A374EC93FB0DF", hash_generated_method = "61D4E7C8CDD7C8C2E6F5B6E0D0AC3FF9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedSet<E> subSet(E start, E end) {
            dsTaint.addTaint(start.dsTaint);
            dsTaint.addTaint(end.dsTaint);
            {
                SortedSet<E> var8DA8E4859BA4DEDDCDC044FDF09D00F9_257093720 = (new SynchronizedSortedSet<E>(ss.subSet(start, end),
                        mutex));
            } //End block
            return (SortedSet<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedSet<E>(ss.subSet(start, end),
                        //mutex);
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.142 -0400", hash_original_method = "4C04840896A126B8B17AD8E0926A5B00", hash_generated_method = "DEC0916E66942FEFF701D94C6FB4F381")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedSet<E> tailSet(E start) {
            dsTaint.addTaint(start.dsTaint);
            {
                SortedSet<E> varABD07F26D21362C979BC33EB496AF068_1542192673 = (new SynchronizedSortedSet<E>(ss.tailSet(start), mutex));
            } //End block
            return (SortedSet<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mutex) {
                //return new SynchronizedSortedSet<E>(ss.tailSet(start), mutex);
            //}
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.143 -0400", hash_original_method = "981AD07707BE70675431924A12FE33C6", hash_generated_method = "6001D7B256B91F08C850EFC8421AA226")
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.147 -0400", hash_original_method = "0B21B3311CB87F81844FA591591A704A", hash_generated_method = "80B1011CB907D82DB2358BEE37382326")
        @DSModeled(DSC.SAFE)
         UnmodifiableCollection(Collection<E> collection) {
            dsTaint.addTaint(collection.dsTaint);
            // ---------- Original Method ----------
            c = collection;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.152 -0400", hash_original_method = "1E7EFCC2BAD401EE702FAECD906F0B57", hash_generated_method = "5DB475504A90482B869840DCBF62DA32")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean add(E object) {
            dsTaint.addTaint(object.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.156 -0400", hash_original_method = "A14B246F22D65FADC1A66C9C0851763B", hash_generated_method = "A9A5A5552B557E0C4EAC8C623BA05114")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean addAll(Collection<? extends E> collection) {
            dsTaint.addTaint(collection.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.157 -0400", hash_original_method = "C5BE2B5F9D582C4EED1DC0880E8741A1", hash_generated_method = "9E448290AD9533E2404B8F42EF4217B0")
        @DSModeled(DSC.SAFE)
        @Override
        public void clear() {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.159 -0400", hash_original_method = "9A5FA57B69BAE7BFE0B020704235C788", hash_generated_method = "C857DC0F4C079E99F8C8DFA0B5C44C3B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean contains(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean var57979CEAB3B2144CFD864D01F9E7B4FE_963412492 = (c.contains(object));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c.contains(object);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.160 -0400", hash_original_method = "BD1B4CD05BF6E123B0DC6FD003A6020C", hash_generated_method = "D981856AF737087CE8AA773F607E4E3F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            boolean varF92105B68CE9F70CF43B3142D405452C_1116869605 = (c.containsAll(collection));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c.containsAll(collection);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.162 -0400", hash_original_method = "F9A3CB1FB7570D28EBE20660E2FC6F42", hash_generated_method = "BDC83BFABA5272F92D88B8F710A076D0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean isEmpty() {
            boolean var528EAD02A70F822F393BB0C54FBB923C_375034656 = (c.isEmpty());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c.isEmpty();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.165 -0400", hash_original_method = "57C2B30126E9906DFFF70EEB2D2CD18D", hash_generated_method = "6506BC8D5D9EAAD432A1B285E2DB107E")
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


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.167 -0400", hash_original_method = "2165C77F20F5DBDDE4D0AED313262684", hash_generated_method = "2606F7C643E012B9CC82FF6C3F6729DF")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean remove(Object object) {
            dsTaint.addTaint(object.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.169 -0400", hash_original_method = "95D6D7B80D3C762A794FEAFDE42B30FC", hash_generated_method = "64E56F99062490B7C30D4C3BF7E8E0E6")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean removeAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.171 -0400", hash_original_method = "D4789A90B422D35C3FC475A0D6C54BE8", hash_generated_method = "2CB005A513E74AD2F74E7B4156F565A4")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean retainAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.178 -0400", hash_original_method = "AC97C28F724592ABA809E2470D95C119", hash_generated_method = "873642E2D8199FEBF6204B2627548A67")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int size() {
            int varC247C84593AA6020ED979B19566D13FE_588647639 = (c.size());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return c.size();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.184 -0400", hash_original_method = "89D7D02A9D2BDF31E775C08108CBDE5B", hash_generated_method = "67C04DF52484900E2D3C821C17103FE3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Object[] toArray() {
            Object[] var62B66AF92E26C05B85793C43631A5670_1863968621 = (c.toArray());
            return (Object[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return c.toArray();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.186 -0400", hash_original_method = "D5913A45F2385B9A173BEEED47EA354F", hash_generated_method = "19F2267176B32EEAA05766A1810087E7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public <T> T[] toArray(T[] array) {
            dsTaint.addTaint(array[0].dsTaint);
            T[] var3310A58999EA63E27B96F5B99AFAAFE8_1151964209 = (c.toArray(array));
            return (T[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return c.toArray(array);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.188 -0400", hash_original_method = "424D4966F358AE6553349A6493C21674", hash_generated_method = "5DE4C7A44C8B9060093A56E913A4451D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            String var864CC0AEC1F50182F68F1C735FD8AA5D_858907856 = (c.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return c.toString();
        }


    }



    private static class UnmodifiableRandomAccessList<E> extends UnmodifiableList<E> implements RandomAccess {
        private static final long serialVersionUID = -2542308836966382001L;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.193 -0400", hash_original_method = "0A20B358F7BA1E60AD6DE80ADB85C324", hash_generated_method = "A96D994A481491761A5028B806B54AF9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         UnmodifiableRandomAccessList(List<E> l) {
            super(l);
            dsTaint.addTaint(l.dsTaint);
            // ---------- Original Method ----------
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.200 -0400", hash_original_method = "BFD692E8EF2A50E82DD6BA0EC7051578", hash_generated_method = "4574A86F96AD23659ED2608C91635D36")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public List<E> subList(int start, int end) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(end);
            List<E> varE81752721CA68FB0892933359A043348_469988546 = (new UnmodifiableRandomAccessList<E>(list.subList(start, end)));
            return (List<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UnmodifiableRandomAccessList<E>(list.subList(start, end));
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.202 -0400", hash_original_method = "C39E6F512687738DD8D987CDE63A2838", hash_generated_method = "C4B3A3F66C5D4A8E6CF2C83B5656BFDE")
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.204 -0400", hash_original_method = "4CB96388E36B825DE711E2E59A893E0D", hash_generated_method = "FFAF02DD659C9257C95875AB10D93C61")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         UnmodifiableList(List<E> l) {
            super(l);
            dsTaint.addTaint(l.dsTaint);
            // ---------- Original Method ----------
            list = l;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.212 -0400", hash_original_method = "CE54A57EF9628E9FD413F964E9F93054", hash_generated_method = "0ACFA9E566D685329F2A220DB1EFB417")
        @DSModeled(DSC.SAFE)
        @Override
        public void add(int location, E object) {
            dsTaint.addTaint(location);
            dsTaint.addTaint(object.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.219 -0400", hash_original_method = "6CD19404B4901DECE5B6F72EB7D0CD8F", hash_generated_method = "1CDFD95C7631A083231C15855EEA674C")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean addAll(int location, Collection<? extends E> collection) {
            dsTaint.addTaint(location);
            dsTaint.addTaint(collection.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.220 -0400", hash_original_method = "C3C1892342CAEB152D9191558B893ACD", hash_generated_method = "7F81227AB3D31CD22A08375EC07E4566")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean var983E353D0DFE7FD02AAEFC303F168456_593325138 = (list.equals(object));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return list.equals(object);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.222 -0400", hash_original_method = "DFB24286AA0C5C6BF58031CA4ED7CDCB", hash_generated_method = "EB1264A102D7F76F012F6EC33E122564")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E get(int location) {
            dsTaint.addTaint(location);
            E var04271A4486C85B4131CB7C5CE1827D34_2040580228 = (list.get(location));
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return list.get(location);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.229 -0400", hash_original_method = "8FDA3E2E38E99F5D6FC34E94E92E953F", hash_generated_method = "3D6B7D56695F43B02613CDDC2CD7392A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int var9A1610964D862FF54E00A16E6D7BD291_1313003396 = (list.hashCode());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return list.hashCode();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.231 -0400", hash_original_method = "E8AAF2C874038C363BF8C80F2A4ED8F2", hash_generated_method = "0C34246AE28CDB92DB878940A5D62E71")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int indexOf(Object object) {
            dsTaint.addTaint(object.dsTaint);
            int var77BCF240B74578A0DBB7E15170347534_1887049161 = (list.indexOf(object));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return list.indexOf(object);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.239 -0400", hash_original_method = "658C7926C6DFF1B86F4D9B6B0E3F5BBD", hash_generated_method = "9A7332CB2C1064BD3F2012F2AE72C935")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int lastIndexOf(Object object) {
            dsTaint.addTaint(object.dsTaint);
            int var158B58B87F16034A803BFB0430AFCD59_1781382300 = (list.lastIndexOf(object));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return list.lastIndexOf(object);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.242 -0400", hash_original_method = "DF7BE0B13ABC5A9B1C74313BD06FB64C", hash_generated_method = "F2378C5A80857762605D89D9ECC04D05")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public ListIterator<E> listIterator() {
            ListIterator<E> var4B5B2DE28169C2BFBA180BAF54B9EB3E_2015467064 = (listIterator(0));
            return (ListIterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return listIterator(0);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.248 -0400", hash_original_method = "1D0E6831E50FA8995D23240A6E091C82", hash_generated_method = "DBF5D04F8B31FE376E9A10A7512674CA")
        @DSModeled(DSC.SAFE)
        @Override
        public ListIterator<E> listIterator(final int location) {
            dsTaint.addTaint(location);
            return (ListIterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.249 -0400", hash_original_method = "5388D372D048D053ADD084F02A9C1484", hash_generated_method = "3C06FCB8B28A841347E649E27CAAC90D")
        @DSModeled(DSC.SAFE)
        @Override
        public E remove(int location) {
            dsTaint.addTaint(location);
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.251 -0400", hash_original_method = "8830E2F07CC294339D5D496574BCFA5E", hash_generated_method = "136437B57C6E54736B14E31818AB5070")
        @DSModeled(DSC.SAFE)
        @Override
        public E set(int location, E object) {
            dsTaint.addTaint(location);
            dsTaint.addTaint(object.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.254 -0400", hash_original_method = "82D78FB8922B9A0888EF8A304898D60D", hash_generated_method = "69FF994C4306281B76209BD0B0296FB8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public List<E> subList(int start, int end) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(end);
            List<E> var484C55B6D971B995E35583CF642ED457_6326017 = (new UnmodifiableList<E>(list.subList(start, end)));
            return (List<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UnmodifiableList<E>(list.subList(start, end));
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.256 -0400", hash_original_method = "5F3DDA40E6BDC67502A2E43BA75DBB15", hash_generated_method = "F730E915E9BE2FED7BC3A9310834D39A")
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.258 -0400", hash_original_method = "74C4A0289A3E9196E4EF75F76384A7D2", hash_generated_method = "3432E276797EB26AFE57E72BF647BDF2")
        @DSModeled(DSC.SAFE)
         UnmodifiableMap(Map<K, V> map) {
            dsTaint.addTaint(map.dsTaint);
            // ---------- Original Method ----------
            m = map;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.260 -0400", hash_original_method = "C5BE2B5F9D582C4EED1DC0880E8741A1", hash_generated_method = "9E448290AD9533E2404B8F42EF4217B0")
        @DSModeled(DSC.SAFE)
        @Override
        public void clear() {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.261 -0400", hash_original_method = "A6C730848D8A626F99D8229EE744E3C0", hash_generated_method = "8B518D815DB2DB5BDD157A348CC10A99")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsKey(Object key) {
            dsTaint.addTaint(key.dsTaint);
            boolean var2519B7EF565FEC21B6285F5E44AC148E_252937572 = (m.containsKey(key));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return m.containsKey(key);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.263 -0400", hash_original_method = "EF8C00CF950E8C186D2F05E1E556F384", hash_generated_method = "25467375E90C52A4E3A6AAEF2722D6BF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsValue(Object value) {
            dsTaint.addTaint(value.dsTaint);
            boolean varF8CB74E2C5E0734947B397D82173BDD4_2047319643 = (m.containsValue(value));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return m.containsValue(value);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.266 -0400", hash_original_method = "FB0DE15DA25D3994421C9FBDD1812EDD", hash_generated_method = "B6D8077B8776FEE5322A2D056C5E7693")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> varE7CF0764559CBDA696603C1B9F083963_1353918623 = (new UnmodifiableEntrySet<K, V>(m.entrySet()));
            return (Set<Map.Entry<K, V>>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UnmodifiableEntrySet<K, V>(m.entrySet());
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.274 -0400", hash_original_method = "CE201E78EAC5D1903F741160CB297EAE", hash_generated_method = "9EAAA57EAAB652979F05668A10520E7E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean var9745819ACBF7C47D9CAE10D95AB26047_1980016165 = (m.equals(object));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return m.equals(object);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.277 -0400", hash_original_method = "B8FE254B61C57EC3A6DCE539976DA268", hash_generated_method = "1F2BF4AF3823B1584CF1EEFC3C6601E9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public V get(Object key) {
            dsTaint.addTaint(key.dsTaint);
            V var3CE9B05179DCB2168B5F27445CBC5B28_1618915012 = (m.get(key));
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return m.get(key);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.289 -0400", hash_original_method = "E3229E3389F030DD50B79734943DB788", hash_generated_method = "9EE3F0A917C37DFCE6628471D0B9BA54")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int varAA1293165230C9829C1AEACFFF576DFC_928472972 = (m.hashCode());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return m.hashCode();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.291 -0400", hash_original_method = "B9E63D3C52241E7E917CB1416ABA36E5", hash_generated_method = "D0373C33170B2111CB1AB6E390CCFD07")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean isEmpty() {
            boolean var028CF644E61B84328EAB66D556672A81_1642850493 = (m.isEmpty());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return m.isEmpty();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.294 -0400", hash_original_method = "2CC049F262DAAA6660AF161E9C8606F6", hash_generated_method = "557C74A25B1C8E72F209CA38E781BDD9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Set<K> keySet() {
            Set<K> var8D40E1914E5CD510283210347B84C9D0_2143215113 = (new UnmodifiableSet<K>(m.keySet()));
            return (Set<K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UnmodifiableSet<K>(m.keySet());
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.296 -0400", hash_original_method = "1AE25A34BEB4A8F08F41373ADFFCFE34", hash_generated_method = "33976647D46A7C0B8FA597283E84D464")
        @DSModeled(DSC.SAFE)
        @Override
        public V put(K key, V value) {
            dsTaint.addTaint(value.dsTaint);
            dsTaint.addTaint(key.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.298 -0400", hash_original_method = "1D605566C28BBD06FDC515389557B406", hash_generated_method = "F585D66E2C8ACFBD5256D1DE63926779")
        @DSModeled(DSC.SAFE)
        @Override
        public void putAll(Map<? extends K, ? extends V> map) {
            dsTaint.addTaint(map.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.300 -0400", hash_original_method = "1F8D4C123F3DDBF68E61E38EDB13F5FB", hash_generated_method = "3EA5A9E66D66203C2A71DBB3CE9C2C66")
        @DSModeled(DSC.SAFE)
        @Override
        public V remove(Object key) {
            dsTaint.addTaint(key.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.302 -0400", hash_original_method = "A04EE09DEB6F21FAA6A7E10DF6401CD1", hash_generated_method = "F294EE539290054DD942C3D4ABD08676")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int size() {
            int varDBD6E28F15F3D13B8127CF62DD69ACD5_1006934079 = (m.size());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return m.size();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.311 -0400", hash_original_method = "19DD84E0D2EBBBC2FCDA12D023824450", hash_generated_method = "1D13BD3257A0AC82E6405C8DDD71316C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Collection<V> values() {
            Collection<V> varDEC91ADE25563BA976B08F7B41617CEC_992524533 = (new UnmodifiableCollection<V>(m.values()));
            return (Collection<V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UnmodifiableCollection<V>(m.values());
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.313 -0400", hash_original_method = "5DD44B3CD2826BF39F974F66579CF74F", hash_generated_method = "B57D20EAE3177D83611B512B7C1A1D53")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            String var7BAD0880B86D95365972142C036695CB_1326732574 = (m.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return m.toString();
        }


        private static class UnmodifiableEntrySet<K, V> extends UnmodifiableSet<Map.Entry<K, V>> {
            private static final long serialVersionUID = 7854390611657943733L;

            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.315 -0400", hash_original_method = "211DEE98878E4422E2F38E79CDC5F0D4", hash_generated_method = "47A19A9E7FD1D7831CA027AD146EC331")
            //DSFIXME:  CODE0002: Requires DSC value to be set
             UnmodifiableEntrySet(Set<Map.Entry<K, V>> set) {
                super(set);
                dsTaint.addTaint(set.dsTaint);
                // ---------- Original Method ----------
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.317 -0400", hash_original_method = "53A7F61EDA7A64FBCB28AE61A8906002", hash_generated_method = "1AFF48D160AF3ED5DB3A2D828BDC4015")
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


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.320 -0400", hash_original_method = "C353E5DD4879B90DAE1A37DDC4A8ED8C", hash_generated_method = "BC1D4B3D7750FB48CFEB2CD3031AE50D")
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


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.324 -0400", hash_original_method = "CB9686BEA448DC0D7D0077DDEB1917CB", hash_generated_method = "3CC5F42D29BED8F47175705C0F7EA762")
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

                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.327 -0400", hash_original_method = "E37A4627FD27E632126EED134E00D831", hash_generated_method = "A0EF7E8338A715743B22982431056C29")
                @DSModeled(DSC.SAFE)
                 UnmodifiableMapEntry(Map.Entry<K, V> entry) {
                    dsTaint.addTaint(entry.dsTaint);
                    // ---------- Original Method ----------
                    //mapEntry = entry;
                }


                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.328 -0400", hash_original_method = "90F914E663E54C2DC9846974DAA2EFB8", hash_generated_method = "E20C98B08A795CAFEAB8A3158181B929")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public boolean equals(Object object) {
                    dsTaint.addTaint(object.dsTaint);
                    boolean var1E6E5EE1426DD4D6EB65B99B916F7467_2124494370 = (mapEntry.equals(object));
                    return dsTaint.getTaintBoolean();
                    // ---------- Original Method ----------
                    //return mapEntry.equals(object);
                }


                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.330 -0400", hash_original_method = "4DDB57034C15C2636BC5A8AFB2B3C75A", hash_generated_method = "5E59A4E2507ECC9728570674187F1AEF")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public K getKey() {
                    K var25C1A8C49B018B5E1039568C6A58A77E_492949161 = (mapEntry.getKey());
                    return (K)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //return mapEntry.getKey();
                }


                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.332 -0400", hash_original_method = "EA1063FCD9D2F699A9610E0A7FDC81FD", hash_generated_method = "5D9017E6CC1418B799FCDBE446052D70")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public V getValue() {
                    V var3A71A2C40C9A5E4B4A7FD2824BA056D3_2102746032 = (mapEntry.getValue());
                    return (V)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //return mapEntry.getValue();
                }


                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.334 -0400", hash_original_method = "8A31FFFC42BCA6E359386EC1F8534D45", hash_generated_method = "429BC287341136E8C73CC69775C11A99")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public int hashCode() {
                    int varB4446261767782D97888D65AE62449D4_1970821160 = (mapEntry.hashCode());
                    return dsTaint.getTaintInt();
                    // ---------- Original Method ----------
                    //return mapEntry.hashCode();
                }


                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.335 -0400", hash_original_method = "3526712C126765AF36CB8D920CBD3B1B", hash_generated_method = "FF611110844F4EAC1A268C8C636901B8")
                @DSModeled(DSC.SAFE)
                @Override
                public V setValue(V object) {
                    dsTaint.addTaint(object.dsTaint);
                    if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
                    return (V)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //throw new UnsupportedOperationException();
                }


                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.339 -0400", hash_original_method = "514C7E8B8C54DBFDFB3E185BADD6AD0A", hash_generated_method = "1DED32A97C625D6D761E2B3C8A05B878")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public String toString() {
                    String var23D4CB5286AA9BCD0B2722DA3B72340B_1934328071 = (mapEntry.toString());
                    return dsTaint.getTaintString();
                    // ---------- Original Method ----------
                    //return mapEntry.toString();
                }


            }



        }



    }



    private static class UnmodifiableSet<E> extends UnmodifiableCollection<E> implements Set<E> {
        private static final long serialVersionUID = -9215047833775013803L;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.342 -0400", hash_original_method = "D46A71F25EF02541A08678630568218D", hash_generated_method = "737102E62EAB8335F4D8B503C28B28CF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         UnmodifiableSet(Set<E> set) {
            super(set);
            dsTaint.addTaint(set.dsTaint);
            // ---------- Original Method ----------
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.344 -0400", hash_original_method = "BB8664F3F5CB90AA83689CAADCD9EA6B", hash_generated_method = "A0F2026FDC29CBE79BA7F5EBDE6D981E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean var68E706348FF72E55282D2AEF4301CA4B_1486415991 = (c.equals(object));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c.equals(object);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.346 -0400", hash_original_method = "E858D80F3EEDE9F2B52CDB7DA7FBF12B", hash_generated_method = "4EE427674121AF194B009EBD6834A2FF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int var19B3D08FE3840D0D3E365DF71EF3E20C_1883869499 = (c.hashCode());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return c.hashCode();
        }


    }



    private static class UnmodifiableSortedMap<K, V> extends UnmodifiableMap<K, V> implements SortedMap<K, V> {
        private static final long serialVersionUID = -8806743815996713206L;
        private final SortedMap<K, V> sm;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.351 -0400", hash_original_method = "AC9FE01B421B1E54651959AD61521CA6", hash_generated_method = "F7FC3AC1069CC00C4D5DF11AFFA87B62")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         UnmodifiableSortedMap(SortedMap<K, V> map) {
            super(map);
            dsTaint.addTaint(map.dsTaint);
            // ---------- Original Method ----------
            sm = map;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.354 -0400", hash_original_method = "E5FDBCC6560BE7E99B2D2F850BD84149", hash_generated_method = "A44E1BE944FEF19CB0C94ADBD2557A7C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Comparator<? super K> comparator() {
            Comparator<? super K> var422223D82196DD3FC2DC6264D5B430C5_1418129412 = (sm.comparator());
            return (Comparator<? super K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return sm.comparator();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.356 -0400", hash_original_method = "B25E8C7440C76FBF812FF7AC9CA9D776", hash_generated_method = "EDDBC2A89B3349D2C7F4EC7331E7FAFB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public K firstKey() {
            K var27D52CE4EA4B74D34E8381D333AAE9A4_1873682037 = (sm.firstKey());
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return sm.firstKey();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.358 -0400", hash_original_method = "EC6243B190269A05D31802D1260652E4", hash_generated_method = "401E01ABE033AB869B8AE956FD033D0B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedMap<K, V> headMap(K before) {
            dsTaint.addTaint(before.dsTaint);
            SortedMap<K, V> varCA3E385D4E8CD095E0D16C9130E8F327_1572084673 = (new UnmodifiableSortedMap<K, V>(sm.headMap(before)));
            return (SortedMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UnmodifiableSortedMap<K, V>(sm.headMap(before));
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.360 -0400", hash_original_method = "00E9126A84DE8B71214859A17DA6BD2E", hash_generated_method = "9A2D1C6E0746B3AD13F91F0CA47A7D82")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public K lastKey() {
            K var9F9AE843A8A54EC3D9E8230A61FB8B04_1521093309 = (sm.lastKey());
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return sm.lastKey();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.362 -0400", hash_original_method = "B6411009D9179ABF4D7755605B648FDC", hash_generated_method = "D1BCB901BB596A4B0EF97AEC64C67D4C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedMap<K, V> subMap(K start, K end) {
            dsTaint.addTaint(start.dsTaint);
            dsTaint.addTaint(end.dsTaint);
            SortedMap<K, V> var00249249156058E6EE273C54B70BBAB5_1776410330 = (new UnmodifiableSortedMap<K, V>(sm.subMap(start, end)));
            return (SortedMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UnmodifiableSortedMap<K, V>(sm.subMap(start, end));
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.366 -0400", hash_original_method = "59BADF6C5EE68C4E1DB5A6A22818328A", hash_generated_method = "1438A606E184D98F8EC9DDB163FA4B49")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedMap<K, V> tailMap(K after) {
            dsTaint.addTaint(after.dsTaint);
            SortedMap<K, V> varB68C4B7747A55CAD7AAABD39E9B461EE_702418190 = (new UnmodifiableSortedMap<K, V>(sm.tailMap(after)));
            return (SortedMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UnmodifiableSortedMap<K, V>(sm.tailMap(after));
        }


    }



    private static class UnmodifiableSortedSet<E> extends UnmodifiableSet<E> implements SortedSet<E> {
        private static final long serialVersionUID = -4929149591599911165L;
        private final SortedSet<E> ss;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.368 -0400", hash_original_method = "232C45C3B4117EB9042FB58E6C0CE113", hash_generated_method = "311A55703B4AE62BAA7EE624745C04C4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         UnmodifiableSortedSet(SortedSet<E> set) {
            super(set);
            dsTaint.addTaint(set.dsTaint);
            // ---------- Original Method ----------
            ss = set;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.371 -0400", hash_original_method = "8514D9255D678B041F55D03BA11DCA3B", hash_generated_method = "06A6B91840D1187C86AE338B9D8E151E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Comparator<? super E> comparator() {
            Comparator<? super E> var05CAB94F8BD11820A94AC68A790A80A5_688616177 = (ss.comparator());
            return (Comparator<? super E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ss.comparator();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.373 -0400", hash_original_method = "6BB6C51843B41CC0DCB5509A79DBA008", hash_generated_method = "9488718A3C0B428B718BC5808F8BEFDA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E first() {
            E varCAE51BE1E9DF20269B81A1FDC8990752_221467081 = (ss.first());
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ss.first();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.375 -0400", hash_original_method = "74C4BE29898589F7D7948BADA3350612", hash_generated_method = "7061D18C7455D2D9D70BCE915601F0F2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedSet<E> headSet(E before) {
            dsTaint.addTaint(before.dsTaint);
            SortedSet<E> var9DB1950B5F2749043373128DC25BBF71_294542350 = (new UnmodifiableSortedSet<E>(ss.headSet(before)));
            return (SortedSet<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UnmodifiableSortedSet<E>(ss.headSet(before));
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.378 -0400", hash_original_method = "AAC5DDE787ACA85752B94AAB77F6B0F8", hash_generated_method = "A81D47A0E677C3BC0C5BDD34BD364613")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E last() {
            E varB0B3C145EFB1EF3B95D9D987CE98A283_378413296 = (ss.last());
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ss.last();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.380 -0400", hash_original_method = "54602835FD774439E48CB96CB67F9D83", hash_generated_method = "91690EB920EA7008FA4A7592A1DEAFB7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedSet<E> subSet(E start, E end) {
            dsTaint.addTaint(start.dsTaint);
            dsTaint.addTaint(end.dsTaint);
            SortedSet<E> var46D195260A644EE679FCB282DB396A37_1450650071 = (new UnmodifiableSortedSet<E>(ss.subSet(start, end)));
            return (SortedSet<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UnmodifiableSortedSet<E>(ss.subSet(start, end));
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.382 -0400", hash_original_method = "37640609DAC9C9170FD6CBE14C8AD6B6", hash_generated_method = "5646E42A2FA0638294A6D6DAABD60D4C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedSet<E> tailSet(E after) {
            dsTaint.addTaint(after.dsTaint);
            SortedSet<E> varB747B94402EDDE06745C3B373FBEAAA8_164563247 = (new UnmodifiableSortedSet<E>(ss.tailSet(after)));
            return (SortedSet<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UnmodifiableSortedSet<E>(ss.tailSet(after));
        }


    }



    private static class SetFromMap<E> extends AbstractSet<E> implements Serializable {
        private static final long serialVersionUID = 2454657854757543876L;
        private Map<E, Boolean> m;
        private transient Set<E> backingSet;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.392 -0400", hash_original_method = "6B962D990E5B5543C1AA025E18134CE9", hash_generated_method = "BF1D765C697501CB46ECE71078EC7C10")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SetFromMap(final Map<E, Boolean> map) {
            dsTaint.addTaint(map.dsTaint);
            backingSet = map.keySet();
            // ---------- Original Method ----------
            //m = map;
            //backingSet = map.keySet();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.393 -0400", hash_original_method = "B42E9CA75A778919E90B77D794DBEE82", hash_generated_method = "034050AA2D42F4944EFBCBEA5A14383D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean var1848766D38374CAEDBF00C0007CDCFC1_1024316437 = (backingSet.equals(object));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return backingSet.equals(object);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.400 -0400", hash_original_method = "684F9CE738B21B1B45F3304124963EF1", hash_generated_method = "DDD914C1466A7DE16C343FEE268DEE4B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int var061E95C5D32F56D095B7A80E91EC8A56_1677258234 = (backingSet.hashCode());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return backingSet.hashCode();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.409 -0400", hash_original_method = "FC84A6CABB16433CF1488E03DF7636C8", hash_generated_method = "8AD0ECE6388CEAF2DA02A33F0B6442E2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean add(E object) {
            dsTaint.addTaint(object.dsTaint);
            boolean var8AF8A0D0EB560BBD1728F96A00026012_1346197582 = (m.put(object, Boolean.TRUE) == null);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return m.put(object, Boolean.TRUE) == null;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.410 -0400", hash_original_method = "5163CA2ED3AD9C66F2BDAFB902590115", hash_generated_method = "3D07CBB638C6514CE20DA136AC64FDB0")
        @DSModeled(DSC.SAFE)
        @Override
        public void clear() {
            m.clear();
            // ---------- Original Method ----------
            //m.clear();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.412 -0400", hash_original_method = "C7069F73CC2FBE59B42FACF6A3731192", hash_generated_method = "5E1F0039D93A0898322BCC6D17213660")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            String var76C2C76F9D113FCE27768A53C48C8DE4_1197035456 = (backingSet.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return backingSet.toString();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.417 -0400", hash_original_method = "C1FDFEBBA860B6E21729D041F83BDE39", hash_generated_method = "A98AB70914754AF0030F0697602462DB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean contains(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean varD69ECD74FC2F79EA60C338071C7FC221_272964516 = (backingSet.contains(object));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return backingSet.contains(object);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.419 -0400", hash_original_method = "652D3A93342A70291E00DB196A629050", hash_generated_method = "CB4BDBA2AC47EE0E22A96F1465C276E8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            boolean var3951AEBB2FFEF521655479A9D2D52542_130993808 = (backingSet.containsAll(collection));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return backingSet.containsAll(collection);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.420 -0400", hash_original_method = "B9E63D3C52241E7E917CB1416ABA36E5", hash_generated_method = "D93269E44EEA50B9A03E2E82E630C293")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean isEmpty() {
            boolean var028CF644E61B84328EAB66D556672A81_1715929791 = (m.isEmpty());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return m.isEmpty();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.422 -0400", hash_original_method = "20C696E59013C16BDFED7021A5C3E797", hash_generated_method = "1BB3100CBDD8EB46D4A1B61C11ED1AC3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean remove(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean varEA834B1BBE47D90EDF860853CDE90683_821931694 = (m.remove(object) != null);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return m.remove(object) != null;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.425 -0400", hash_original_method = "4A27ACEA2C9F194EF4597E8BDECC6BD7", hash_generated_method = "A939982408E7F0D564AD9EEFD42490C8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean retainAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            boolean varF15C5540B964CC478105DE5ACC25B10C_910018164 = (backingSet.retainAll(collection));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return backingSet.retainAll(collection);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.427 -0400", hash_original_method = "706FD57EC242D189F78C8F40D764E8D0", hash_generated_method = "19C2F0B1EEE54087244639A773EC33F0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Object[] toArray() {
            Object[] varAAF6863E3FC284FF60465B89D611A453_1185159467 = (backingSet.toArray());
            return (Object[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return backingSet.toArray();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.430 -0400", hash_original_method = "5B684176C593DE73F99AF08724DF65D4", hash_generated_method = "1F2EDB9128315592E4A1DE2B1AEC8572")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public <T> T[] toArray(T[] contents) {
            dsTaint.addTaint(contents[0].dsTaint);
            T[] var70E76BB3C7B4621B066FEAA9F9F6B3A3_1121458282 = (backingSet.toArray(contents));
            return (T[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return backingSet.toArray(contents);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.433 -0400", hash_original_method = "2EC39271104239DED882FB25EFF4BC23", hash_generated_method = "0DC4E6F7FF443ABE9D7CF3B5E3B9F255")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Iterator<E> iterator() {
            Iterator<E> var46A5BD0F9A39756579AFB4DF806B1772_49100043 = (backingSet.iterator());
            return (Iterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return backingSet.iterator();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.435 -0400", hash_original_method = "A04EE09DEB6F21FAA6A7E10DF6401CD1", hash_generated_method = "C72FDCB19C40586EC8EA144B3C195618")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int size() {
            int varDBD6E28F15F3D13B8127CF62DD69ACD5_1926850928 = (m.size());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return m.size();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.437 -0400", hash_original_method = "8082AE1FFA2825B9433C3082C2F87EDC", hash_generated_method = "12FAA4DAD11AE53FB89BD8976C1F314C")
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.439 -0400", hash_original_method = "C9A3AEFCC3A9FEA0CFED796FADB14DA4", hash_generated_method = "A33813B5A05201CDFA91E1E126627558")
        @DSModeled(DSC.SAFE)
         AsLIFOQueue(final Deque<E> deque) {
            dsTaint.addTaint(deque.dsTaint);
            // ---------- Original Method ----------
            this.q = deque;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.441 -0400", hash_original_method = "D6ABAC5AC9E31C28EFD449012F8C668D", hash_generated_method = "D8EDF972B25FC4D52F3914C3D00B5DDB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Iterator<E> iterator() {
            Iterator<E> varFBE466EF8E63E9009A03F2C0F0CC80D2_1792185859 = (q.iterator());
            return (Iterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return q.iterator();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.444 -0400", hash_original_method = "4D120CFD44D3EE91A03411EED1F5CA02", hash_generated_method = "38AA863FE5CE0738B97772195F176CCA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int size() {
            int var8E6A4AAEA94D20962C54C20127D7D8DC_1474057032 = (q.size());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return q.size();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.446 -0400", hash_original_method = "A29AB2808D45581589F8B0269F283532", hash_generated_method = "569EFAD793AC0621DDB3972BF7DD482B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean offer(E o) {
            dsTaint.addTaint(o.dsTaint);
            boolean var131D1A648D23B0B634478E3172B0A3D9_207297659 = (q.offerFirst(o));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return q.offerFirst(o);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.448 -0400", hash_original_method = "286FFABBC697C1CEE6C49194F85DD481", hash_generated_method = "8B70F95D268A58CE8D7E22192B052821")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E peek() {
            E var12F2B0EBA7C02287FFA76F3A50514FE3_1792281070 = (q.peekFirst());
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return q.peekFirst();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.450 -0400", hash_original_method = "93EF986205EA0EFDB6E2F2BDD9DDBDB0", hash_generated_method = "347BC33432C9DFB2D795167F8B193123")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E poll() {
            E var513A54907E44074CF1873F435C9F7841_1199703156 = (q.pollFirst());
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return q.pollFirst();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.452 -0400", hash_original_method = "E16BCF0F708E6336497510D255228AB4", hash_generated_method = "52B6DC92C3D50047DC8BA6F7910E736C")
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


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.454 -0400", hash_original_method = "ECF3C7555AB121202E1C39938D734656", hash_generated_method = "39D060DA43AA8AA99E75D005C15EE3F2")
        @DSModeled(DSC.SAFE)
        @Override
        public void clear() {
            q.clear();
            // ---------- Original Method ----------
            //q.clear();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.456 -0400", hash_original_method = "41C0874A8589B77FE1309E3303509F6A", hash_generated_method = "BDC97E4FE5464CC6C245952014B8EEE5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E element() {
            E varA58C48EE56BDCF291271E8BA8F198C86_81019425 = (q.getFirst());
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return q.getFirst();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.458 -0400", hash_original_method = "DBCAD9866D0C084DC455BF7C95ABCE77", hash_generated_method = "BD461C8B24B888B2EB147051EF290A22")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E remove() {
            E var21F03F473F531B5A86EF95513BFC64D5_1663573951 = (q.pop());
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return q.pop();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.460 -0400", hash_original_method = "2E730D7ABEE184A9C34DA57DF7A457EE", hash_generated_method = "8E75CFF65F9AAF1369FF7D346BB732AF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean contains(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean varD460130636362755C09A666172F1A628_1480646348 = (q.contains(object));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return q.contains(object);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.463 -0400", hash_original_method = "3E9E9A2983E74090844621EE9CF6D3D7", hash_generated_method = "9A5C241B1D80340C92B1845BB295CE4C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            boolean varDE8FC932F21B2025BA6D50595BD45CF0_1219968207 = (q.containsAll(collection));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return q.containsAll(collection);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.465 -0400", hash_original_method = "3014069A2B40728BACBB472823CCCF21", hash_generated_method = "BAEB9CC899E1BCA00F7C0F11617AFE27")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean isEmpty() {
            boolean varFE3524B5D20384639CE6FC4B24FAEE92_1720130355 = (q.isEmpty());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return q.isEmpty();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.467 -0400", hash_original_method = "06C06D3351623BFF7BABDE8B40334F59", hash_generated_method = "89EB3DF2925B1A51E1EE7312FC0357EF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean remove(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean var430DB2157F91E84964C83805E66926D1_8408742 = (q.remove(object));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return q.remove(object);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.468 -0400", hash_original_method = "13975D6542267AD488C8D9B27A0905D7", hash_generated_method = "06B0A063A50BC599C9646EFAE81F4924")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean removeAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            boolean varA36A955574116D3C6092CC37D2496B72_2025027758 = (q.removeAll(collection));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return q.removeAll(collection);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.470 -0400", hash_original_method = "029F8EE40CDE382EFA7F7BF13B8FE731", hash_generated_method = "AAEF09FB6FAF97CB8177288706DAFB1B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean retainAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            boolean varF8C783496DD8D05EB5484CABE3DF69DA_736856205 = (q.retainAll(collection));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return q.retainAll(collection);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.471 -0400", hash_original_method = "81809EBBF1D8298961C4E9B761FEF748", hash_generated_method = "05874DDEC2A0226B9104DE03CB77518E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Object[] toArray() {
            Object[] varCA196E539CEA76D371684D96AE62C6BE_279512702 = (q.toArray());
            return (Object[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return q.toArray();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.474 -0400", hash_original_method = "3C7918E789D95B2A97E0F45A2E8277E0", hash_generated_method = "859566E2FA86F06B80498976BBD5AEE7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public <T> T[] toArray(T[] contents) {
            dsTaint.addTaint(contents[0].dsTaint);
            T[] varCD03EDBC00D159F43667C38BC995C07F_1443387907 = (q.toArray(contents));
            return (T[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return q.toArray(contents);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.481 -0400", hash_original_method = "827F98847BB1D6CEA3B0A324A45F92ED", hash_generated_method = "517EC087979FC28D5AF37EE238B52831")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            String var8F4D867925AFF759292A393714F9299F_1666077639 = (q.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return q.toString();
        }


    }



    private static class CheckedCollection<E> implements Collection<E>, Serializable {
        private static final long serialVersionUID = 1578914078182001775L;
        Collection<E> c;
        Class<E> type;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.488 -0400", hash_original_method = "4DAA5B7D63536360D367B6279A6FD0F0", hash_generated_method = "160806BEB990DB3E8CA4939FD9250442")
        @DSModeled(DSC.SAFE)
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


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.491 -0400", hash_original_method = "AC97C28F724592ABA809E2470D95C119", hash_generated_method = "CB64931B2A3D0C7895FB31DD2A32E720")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int size() {
            int varC247C84593AA6020ED979B19566D13FE_926091527 = (c.size());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return c.size();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.497 -0400", hash_original_method = "F9A3CB1FB7570D28EBE20660E2FC6F42", hash_generated_method = "87372D56BE100426B43EFC709AB7A757")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean isEmpty() {
            boolean var528EAD02A70F822F393BB0C54FBB923C_99052988 = (c.isEmpty());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c.isEmpty();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.500 -0400", hash_original_method = "AA502F510015E56A50E854673F52B13D", hash_generated_method = "37795FCCF3C00650D045065CCC957C71")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean contains(Object obj) {
            dsTaint.addTaint(obj.dsTaint);
            boolean var9701AC7B8B31DABE176EC8837E090033_1024790552 = (c.contains(obj));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c.contains(obj);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.510 -0400", hash_original_method = "A49A579D720F57F247BFFB420B912FC7", hash_generated_method = "64FAFC88C1CE6CA1AE51F5DAF5D821B8")
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


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.512 -0400", hash_original_method = "89D7D02A9D2BDF31E775C08108CBDE5B", hash_generated_method = "0522618C3E103DA94D811AF9D6A1BE45")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Object[] toArray() {
            Object[] var62B66AF92E26C05B85793C43631A5670_1112540207 = (c.toArray());
            return (Object[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return c.toArray();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.514 -0400", hash_original_method = "9B8166862C116AE305DE64E80811892F", hash_generated_method = "18D6B6FE6B846EDC7F60A96BD9219393")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public <T> T[] toArray(T[] arr) {
            dsTaint.addTaint(arr[0].dsTaint);
            T[] var375DD56257BE0288EB32DA2FC3FEC3BC_357401499 = (c.toArray(arr));
            return (T[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return c.toArray(arr);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.517 -0400", hash_original_method = "233202E3883C87159328A7DF45C5A0DD", hash_generated_method = "FE557F5895F0236969F2BBE2A4D67BC3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean add(E obj) {
            dsTaint.addTaint(obj.dsTaint);
            boolean var7C3742253C6BF2735A6EB74A5190709F_788999651 = (c.add(checkType(obj, type)));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c.add(checkType(obj, type));
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.525 -0400", hash_original_method = "A7C1CDA142B015DD1AAB47325584260A", hash_generated_method = "F3DA4C431B841A901801B00A0E6166ED")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean remove(Object obj) {
            dsTaint.addTaint(obj.dsTaint);
            boolean varA24294D934B215AF55F3D7CE5097D547_685972143 = (c.remove(obj));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c.remove(obj);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.527 -0400", hash_original_method = "8A54483E259CA6D3C8AB1EBE7493D296", hash_generated_method = "9161F80D246DAFDA65B2238160F4CDF9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsAll(Collection<?> c1) {
            dsTaint.addTaint(c1.dsTaint);
            boolean varFFF4D0CC6EA0E1A2D080D41D81BC6C1F_1681072498 = (c.containsAll(c1));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c.containsAll(c1);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.533 -0400", hash_original_method = "A2391F235E9474A0C2FADB6F2C5C2AB0", hash_generated_method = "FDE4BC832CBF073ABCE02DF4A69BFBC9")
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
            boolean var4F43D86A78906FAA31F77A4D0C40B6E3_79112853 = (c.addAll((List<E>) Arrays.asList(array)));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //Object[] array = c1.toArray();
            //for (Object o : array) {
                //checkType(o, type);
            //}
            //return c.addAll((List<E>) Arrays.asList(array));
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.543 -0400", hash_original_method = "E5A4F3F5A50F475A125F07680365C964", hash_generated_method = "24C83336094B0C220C00C11A48F3F5C8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean removeAll(Collection<?> c1) {
            dsTaint.addTaint(c1.dsTaint);
            boolean var6FAA02017CB91A1460E8557E32B16FBC_1571718970 = (c.removeAll(c1));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c.removeAll(c1);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.548 -0400", hash_original_method = "2CCBBE73D1665A80965D3FA8CB644A3B", hash_generated_method = "9B1394085CA69D46B89F1482422778A1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean retainAll(Collection<?> c1) {
            dsTaint.addTaint(c1.dsTaint);
            boolean var1BAABDC5B6ADB4CC0AE277B58A4293BA_1790835513 = (c.retainAll(c1));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c.retainAll(c1);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.561 -0400", hash_original_method = "C75B179C04D460F62AB7F39D0D292067", hash_generated_method = "B7255833352F8FF19704A021FC35B60E")
        @DSModeled(DSC.SAFE)
        @Override
        public void clear() {
            c.clear();
            // ---------- Original Method ----------
            //c.clear();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.563 -0400", hash_original_method = "424D4966F358AE6553349A6493C21674", hash_generated_method = "E426A00D715286AC8AC8FB464E194DED")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            String var864CC0AEC1F50182F68F1C735FD8AA5D_1000363917 = (c.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return c.toString();
        }


    }



    private static class CheckedListIterator<E> implements ListIterator<E> {
        private ListIterator<E> i;
        private Class<E> type;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.564 -0400", hash_original_method = "0B7AAA10EE83BBF7A614BF8D8C7A7C84", hash_generated_method = "FCF3DC239F68EA0C87BFF9E2E8589D41")
        @DSModeled(DSC.SAFE)
        public CheckedListIterator(ListIterator<E> i, Class<E> type) {
            dsTaint.addTaint(type.dsTaint);
            dsTaint.addTaint(i.dsTaint);
            // ---------- Original Method ----------
            //this.i = i;
            //this.type = type;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.566 -0400", hash_original_method = "59CA86A80410B66286C92523CF35EC7B", hash_generated_method = "9913779CA0AAFC671DEF15DCF8D93D75")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean hasNext() {
            boolean var1611849CD1EE22EA22E4E7E3327E2E35_127977121 = (i.hasNext());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return i.hasNext();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.576 -0400", hash_original_method = "A2FD0994E634C5BCE4D27AD9176E9A5A", hash_generated_method = "C46E04B192455EF2F964B7778324ACFE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E next() {
            E var95DB63288123763EC54E086A49CC4D64_1445041457 = (i.next());
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return i.next();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.578 -0400", hash_original_method = "048FA6C3E3A28865AD880AF8A3FCAE96", hash_generated_method = "6D29B2FB41FB1A7A3AE157A46C52D7BC")
        @DSModeled(DSC.SAFE)
        @Override
        public void remove() {
            i.remove();
            // ---------- Original Method ----------
            //i.remove();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.579 -0400", hash_original_method = "BBFFF3658F03DC70BAED5B88BBE801F9", hash_generated_method = "8E852185B8B007D20043B8291285F873")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean hasPrevious() {
            boolean var1FCC7ECF60E98FFA6572F3122E374C7E_420064575 = (i.hasPrevious());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return i.hasPrevious();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.581 -0400", hash_original_method = "BC73D9B40C1A828CB3DD11A00CF4E28D", hash_generated_method = "F5055039D27FA9D0E92F334489C7C6BD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E previous() {
            E var7A95CFED89ADF92C26E73F6AF678D539_1708721434 = (i.previous());
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return i.previous();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.589 -0400", hash_original_method = "E41D02CE1A7D09C2351DC91043CD0C1F", hash_generated_method = "8F3470F378263F703C697A5E6D52F4C7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int nextIndex() {
            int var97CCB58C3C2141B73F996BC540E6EAF5_307390674 = (i.nextIndex());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return i.nextIndex();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.591 -0400", hash_original_method = "F0908B37AEEE31348E4E446BDB2DC11E", hash_generated_method = "42A498127916EFC987E16A3C7814DD08")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int previousIndex() {
            int var9F734927211780D2EA84E984ED22702D_843025873 = (i.previousIndex());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return i.previousIndex();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.596 -0400", hash_original_method = "F06067E5C50A33BA33028ACBB7E94E5C", hash_generated_method = "8E56812530262B85D475854C36F6618F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void set(E obj) {
            dsTaint.addTaint(obj.dsTaint);
            i.set(checkType(obj, type));
            // ---------- Original Method ----------
            //i.set(checkType(obj, type));
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.608 -0400", hash_original_method = "3A7C6206CDBE5C448C8E83D10145E877", hash_generated_method = "0ABCCC2A8A2B3F488A04A2A053B8ED0C")
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.610 -0400", hash_original_method = "50AAAF0EF026911FE0274184FEF9C1C3", hash_generated_method = "99D7D8FD55DC31A1DA7CD6E7572B59F8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CheckedList(List<E> l, Class<E> type) {
            super(l, type);
            dsTaint.addTaint(l.dsTaint);
            dsTaint.addTaint(type.dsTaint);
            // ---------- Original Method ----------
            //this.l = l;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.614 -0400", hash_original_method = "8A1A291116E92C540879607029C861C6", hash_generated_method = "E6FCDBEF0C3E48D2732404DE7417719A")
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
            boolean var720AF4600E5540369BE417DBAEE92DFA_667080980 = (l.addAll(index, (List<E>) Arrays.asList(array)));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //Object[] array = c1.toArray();
            //for (Object o : array) {
                //checkType(o, type);
            //}
            //return l.addAll(index, (List<E>) Arrays.asList(array));
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.617 -0400", hash_original_method = "12BB9FAB0B921E0E98205977740A217D", hash_generated_method = "8262B261B70B23987CA0FD2B5A3A2DFB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E get(int index) {
            dsTaint.addTaint(index);
            E varCC738BFB8401CF070AE45C766DD49A10_232223134 = (l.get(index));
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return l.get(index);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.628 -0400", hash_original_method = "B15A1B3ABEAB19644273A7FDAFDFF4C3", hash_generated_method = "3E349DA6B4165C0DFE39EA241C201A0F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E set(int index, E obj) {
            dsTaint.addTaint(index);
            dsTaint.addTaint(obj.dsTaint);
            E var95BC3D95EBED8FE150AF94B939570EB9_781721759 = (l.set(index, checkType(obj, type)));
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return l.set(index, checkType(obj, type));
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.630 -0400", hash_original_method = "97AC3A6F1A8F1F91D88637C439308CAA", hash_generated_method = "2258CC910FFD7EDA4E16A8A69AC87CA3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void add(int index, E obj) {
            dsTaint.addTaint(index);
            dsTaint.addTaint(obj.dsTaint);
            l.add(index, checkType(obj, type));
            // ---------- Original Method ----------
            //l.add(index, checkType(obj, type));
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.650 -0400", hash_original_method = "B7A754E9641B79EF3AC643C6FA162631", hash_generated_method = "C4DD0B5E2DCC96B6C685378A3C5B71A5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E remove(int index) {
            dsTaint.addTaint(index);
            E var5334BD966B25011284C4A335B4622CBB_1934448848 = (l.remove(index));
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return l.remove(index);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.653 -0400", hash_original_method = "EB95E25E6439350950712FBE2C177EC4", hash_generated_method = "F2EF382383767C57E8F692C0590C5BAD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int indexOf(Object obj) {
            dsTaint.addTaint(obj.dsTaint);
            int varBB0CC98524B808CD822A2164B51F33B8_357387578 = (l.indexOf(obj));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return l.indexOf(obj);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.660 -0400", hash_original_method = "4C828EC3A9818E335BF8E9F8513B24F5", hash_generated_method = "E82A362774782576F0E4DBA19FBC0369")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int lastIndexOf(Object obj) {
            dsTaint.addTaint(obj.dsTaint);
            int var68D523AC731688651041C374F25CAB09_788210102 = (l.lastIndexOf(obj));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return l.lastIndexOf(obj);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.665 -0400", hash_original_method = "9293980ECFF31B033CDADFB0ED26EA69", hash_generated_method = "7AF1C72ECD1C5ABA494A93E5EC24C6DF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public ListIterator<E> listIterator() {
            ListIterator<E> var1765FEA39454541ADEB5AAFF0A06F4EC_40728581 = (new CheckedListIterator<E>(l.listIterator(), type));
            return (ListIterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CheckedListIterator<E>(l.listIterator(), type);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.671 -0400", hash_original_method = "31D39D7FEEE82D7A15D00B805CB5EAA4", hash_generated_method = "FC825559EE8E78231CC512CD06D9A3B3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public ListIterator<E> listIterator(int index) {
            dsTaint.addTaint(index);
            ListIterator<E> var1E7F16B9DBBA8C20B0828EBF68F598C7_931651010 = (new CheckedListIterator<E>(l.listIterator(index), type));
            return (ListIterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CheckedListIterator<E>(l.listIterator(index), type);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.677 -0400", hash_original_method = "A5E1EFD4B2650099AC132BF86B97D88F", hash_generated_method = "9E89E1EC838DEB290820FD47522D9BCE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public List<E> subList(int fromIndex, int toIndex) {
            dsTaint.addTaint(fromIndex);
            dsTaint.addTaint(toIndex);
            List<E> varB73C73BFAA199F4126FC4F7FE7D2FC06_1145970028 = (checkedList(l.subList(fromIndex, toIndex), type));
            return (List<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return checkedList(l.subList(fromIndex, toIndex), type);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.680 -0400", hash_original_method = "A14AE2E014BAD465F594EE49A5008ED4", hash_generated_method = "1A56713DA686F28A67B204542ADF21BE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object obj) {
            dsTaint.addTaint(obj.dsTaint);
            boolean var559B3B39BC42D814993568E544C6FE1F_1748734316 = (l.equals(obj));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return l.equals(obj);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.682 -0400", hash_original_method = "410D1D1B2E05F678DF3AB7D6BB08AEDB", hash_generated_method = "6BA652BBC464CF031ADF5E95E86FA334")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int var283F03AD18DE255D000FAC9E62BDE6F0_385485804 = (l.hashCode());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return l.hashCode();
        }


    }



    private static class CheckedRandomAccessList<E> extends CheckedList<E> implements RandomAccess {
        private static final long serialVersionUID = 1638200125423088369L;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.684 -0400", hash_original_method = "77F175BCE2CEB5DECA5010A8855616A0", hash_generated_method = "5E4A2AE80028801E8269440117B013FD")
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.685 -0400", hash_original_method = "515963C9B1280D5707D3A720329B0AC0", hash_generated_method = "72531B2B622A6920DA113492B8437A0D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CheckedSet(Set<E> s, Class<E> type) {
            super(s, type);
            dsTaint.addTaint(s.dsTaint);
            dsTaint.addTaint(type.dsTaint);
            // ---------- Original Method ----------
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.687 -0400", hash_original_method = "F33AC6E694EC5A5F3A81FF749707DDFC", hash_generated_method = "78DF5CD5C5E8DCA6A233A7EE125D2E2D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object obj) {
            dsTaint.addTaint(obj.dsTaint);
            boolean varC91792C7DD4F0C8E92E42617036EED48_1685001385 = (c.equals(obj));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c.equals(obj);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.689 -0400", hash_original_method = "E858D80F3EEDE9F2B52CDB7DA7FBF12B", hash_generated_method = "4C370A05D78C2CC1E1FA91508CE70F14")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int var19B3D08FE3840D0D3E365DF71EF3E20C_1982817356 = (c.hashCode());
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.692 -0400", hash_original_method = "906A4960963B0F972E50BE617CA562B3", hash_generated_method = "277D581FDB5788E5ED01F680E50EABD2")
        @DSModeled(DSC.SAFE)
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


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.693 -0400", hash_original_method = "A04EE09DEB6F21FAA6A7E10DF6401CD1", hash_generated_method = "AA555F531FC31A1393B8F2EB39BD21D7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int size() {
            int varDBD6E28F15F3D13B8127CF62DD69ACD5_1394880388 = (m.size());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return m.size();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.695 -0400", hash_original_method = "B9E63D3C52241E7E917CB1416ABA36E5", hash_generated_method = "386C4E89B82064AEF40930639D742BA3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean isEmpty() {
            boolean var028CF644E61B84328EAB66D556672A81_1874122016 = (m.isEmpty());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return m.isEmpty();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.697 -0400", hash_original_method = "A6C730848D8A626F99D8229EE744E3C0", hash_generated_method = "431C5EA20D88B7351B39EAC90EC1506D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsKey(Object key) {
            dsTaint.addTaint(key.dsTaint);
            boolean var2519B7EF565FEC21B6285F5E44AC148E_1329021770 = (m.containsKey(key));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return m.containsKey(key);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.699 -0400", hash_original_method = "EF8C00CF950E8C186D2F05E1E556F384", hash_generated_method = "ED3C1D61E2A95F058723A0E68558D267")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsValue(Object value) {
            dsTaint.addTaint(value.dsTaint);
            boolean varF8CB74E2C5E0734947B397D82173BDD4_1007995719 = (m.containsValue(value));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return m.containsValue(value);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.700 -0400", hash_original_method = "B8FE254B61C57EC3A6DCE539976DA268", hash_generated_method = "01AEE63963B22A72155A87A49F9D9B6E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public V get(Object key) {
            dsTaint.addTaint(key.dsTaint);
            V var3CE9B05179DCB2168B5F27445CBC5B28_577902349 = (m.get(key));
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return m.get(key);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.702 -0400", hash_original_method = "98010DFF1DD51631676FCAC604C1B694", hash_generated_method = "580D57977EC7C68150C331337C3C13D2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public V put(K key, V value) {
            dsTaint.addTaint(value.dsTaint);
            dsTaint.addTaint(key.dsTaint);
            V var3900CFF6F346802A5C37740372A7DDE7_1174302329 = (m.put(checkType(key, keyType), checkType(value, valueType)));
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return m.put(checkType(key, keyType), checkType(value, valueType));
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.703 -0400", hash_original_method = "7E1C4ABAB7F4D30C9FA02B8AC4206202", hash_generated_method = "B31E2353CAEA6BD791B3CD867DA4D383")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public V remove(Object key) {
            dsTaint.addTaint(key.dsTaint);
            V varD8EDAC54418B5A038858C3D8CF4069D9_1070269732 = (m.remove(key));
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return m.remove(key);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.706 -0400", hash_original_method = "7B09FD67E4091CD76439ADACD213D3A2", hash_generated_method = "320CCB7540F9C99E27B61DBB8742F865")
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


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.708 -0400", hash_original_method = "5163CA2ED3AD9C66F2BDAFB902590115", hash_generated_method = "3D07CBB638C6514CE20DA136AC64FDB0")
        @DSModeled(DSC.SAFE)
        @Override
        public void clear() {
            m.clear();
            // ---------- Original Method ----------
            //m.clear();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.713 -0400", hash_original_method = "BC85ABF91A39D98F3F2ED0838950D9FC", hash_generated_method = "7452EE00851BEEA7E6F5BF35A9AA7897")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Set<K> keySet() {
            Set<K> varA07641C54B940BB8232146D61EC97C56_964838604 = (m.keySet());
            return (Set<K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return m.keySet();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.720 -0400", hash_original_method = "F6584059741E2818D171714370ED56BF", hash_generated_method = "3F182AFAB76A42443D7B914D6759F0DF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Collection<V> values() {
            Collection<V> var5507ECC94528859BCB27FED1248DB4AA_1144586453 = (m.values());
            return (Collection<V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return m.values();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.722 -0400", hash_original_method = "17C87BFAA3247941C0F3FE3FCE6C8B6B", hash_generated_method = "38063A8AA513237215AA392D9227D07C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> varB1671B733F1A4DF3968EE76EA035354B_1647487997 = (new CheckedEntrySet<K, V>(m.entrySet(), valueType));
            return (Set<Map.Entry<K, V>>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CheckedEntrySet<K, V>(m.entrySet(), valueType);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.728 -0400", hash_original_method = "5F45CB6F19E1E41DEEA3711399B994B8", hash_generated_method = "EF94BD8025711B2F9A5916F3340F2C96")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object obj) {
            dsTaint.addTaint(obj.dsTaint);
            boolean var6519380B8603327E1D0BBD66320BEF0F_1557320934 = (m.equals(obj));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return m.equals(obj);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.730 -0400", hash_original_method = "E3229E3389F030DD50B79734943DB788", hash_generated_method = "BC74C66A08052222745F2F921273A73C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int varAA1293165230C9829C1AEACFFF576DFC_1968681393 = (m.hashCode());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return m.hashCode();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.731 -0400", hash_original_method = "5DD44B3CD2826BF39F974F66579CF74F", hash_generated_method = "4137D75D2B3392466EC12E91EAFC3221")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            String var7BAD0880B86D95365972142C036695CB_1607545803 = (m.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return m.toString();
        }


        private static class CheckedEntry<K, V> implements Map.Entry<K, V> {
            Map.Entry<K, V> e;
            Class<V> valueType;

            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.733 -0400", hash_original_method = "7A5E92C112A4AAE1EEB574291E4B57B6", hash_generated_method = "E4554D9818E9D2CE04870544B4B8C321")
            @DSModeled(DSC.SAFE)
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


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.740 -0400", hash_original_method = "10D87C621F2656D3DA7DCE234A4C3FAC", hash_generated_method = "2822D17091DFB16A2506B682C514F78C")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public K getKey() {
                K var530002C589E791D5F0D59F21CB98A866_494225709 = (e.getKey());
                return (K)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return e.getKey();
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.742 -0400", hash_original_method = "8EF21B2292AA31AAE181B3282F3F0262", hash_generated_method = "499CAAA8F5F8E927938B3015214AF4DE")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public V getValue() {
                V var2794ADBC14ECE7BF0E45D7B88CA3585A_2045797158 = (e.getValue());
                return (V)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return e.getValue();
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.745 -0400", hash_original_method = "22C63BC622BE9DF4D2BED624BDB5B6B5", hash_generated_method = "162A65673EC82F601188495B4B6CE98D")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public V setValue(V obj) {
                dsTaint.addTaint(obj.dsTaint);
                V var58BA915191301B7F59E662768625FEFD_550054611 = (e.setValue(checkType(obj, valueType)));
                return (V)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return e.setValue(checkType(obj, valueType));
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.746 -0400", hash_original_method = "0FE63D6CB37B8BF21266876509A7EAAA", hash_generated_method = "E224467A83158A45416F1FCFB01C5DD1")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean equals(Object obj) {
                dsTaint.addTaint(obj.dsTaint);
                boolean var5F98FA9F6CA964453675BAF27F4B0002_1557065736 = (e.equals(obj));
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return e.equals(obj);
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.748 -0400", hash_original_method = "02C3AF7FB3CFA22B693B83D22D208AF4", hash_generated_method = "4313AFE0A644D856E31FC1873EB4A619")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public int hashCode() {
                int varB0D5769FD2A442E362DC4438ABD8230C_1499748214 = (e.hashCode());
                return dsTaint.getTaintInt();
                // ---------- Original Method ----------
                //return e.hashCode();
            }


        }



        private static class CheckedEntrySet<K, V> implements Set<Map.Entry<K, V>> {
            Set<Map.Entry<K, V>> s;
            Class<V> valueType;

            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.750 -0400", hash_original_method = "77FA7326B6BB5621E7FE63699FC58F08", hash_generated_method = "6741420195AEA923161F639431806CD7")
            @DSModeled(DSC.SAFE)
            public CheckedEntrySet(Set<Map.Entry<K, V>> s, Class<V> valueType) {
                dsTaint.addTaint(s.dsTaint);
                dsTaint.addTaint(valueType.dsTaint);
                // ---------- Original Method ----------
                //this.s = s;
                //this.valueType = valueType;
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.753 -0400", hash_original_method = "448F3F9279BA75C161BF1A7F97E105A4", hash_generated_method = "9237195E3F86EF1FBC2AA83618CDA074")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public Iterator<Map.Entry<K, V>> iterator() {
                Iterator<Map.Entry<K, V>> varF3EF6D5EEA7921FC381F8C92707C8A1E_1524443782 = (new CheckedEntryIterator<K, V>(s.iterator(), valueType));
                return (Iterator<Map.Entry<K, V>>)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new CheckedEntryIterator<K, V>(s.iterator(), valueType);
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.755 -0400", hash_original_method = "0FB4B292E50A952F877CB518E0A96CF9", hash_generated_method = "51EDC078CAC93301956F894CBDC7A984")
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


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.764 -0400", hash_original_method = "C1CA1F6CAFA571422DF3592838D87C35", hash_generated_method = "86C13F539ED4267BFA810C7F0DB52C56")
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


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.767 -0400", hash_original_method = "C32F0C36534158E273107417143214BD", hash_generated_method = "F94588FFBEEBC375315FF907CE9428A6")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean retainAll(Collection<?> c) {
                dsTaint.addTaint(c.dsTaint);
                boolean var5CB6111A304F8110F244B25FAFD11216_1745288109 = (s.retainAll(c));
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return s.retainAll(c);
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.772 -0400", hash_original_method = "B2624C46EA911C8D7CBCD3DB1975A601", hash_generated_method = "5628B5036A44E853CB363A0698897BE7")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean removeAll(Collection<?> c) {
                dsTaint.addTaint(c.dsTaint);
                boolean var9FB36AF651B537108EEB0474A946606A_1392346416 = (s.removeAll(c));
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return s.removeAll(c);
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.775 -0400", hash_original_method = "D8F4D306F45D40205BDE17116DDFF9FA", hash_generated_method = "4AA03FAC93DE40DA941BE2F060444806")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean containsAll(Collection<?> c) {
                dsTaint.addTaint(c.dsTaint);
                boolean var13D8B720D63124262C076810AF3BA42D_1940022697 = (s.containsAll(c));
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return s.containsAll(c);
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.783 -0400", hash_original_method = "0D1A7F281A8819D32245C163B79E338D", hash_generated_method = "7E9F99CD0ECEB5F7B0A26BBAF3D11FD6")
            @DSModeled(DSC.SAFE)
            @Override
            public boolean addAll(Collection<? extends Map.Entry<K, V>> c) {
                dsTaint.addTaint(c.dsTaint);
                if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //throw new UnsupportedOperationException();
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.785 -0400", hash_original_method = "46F35AD7CAD80E45E374449F130E7D0D", hash_generated_method = "7975C4DE35CD3F0E21E7E7350C54F224")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean remove(Object o) {
                dsTaint.addTaint(o.dsTaint);
                boolean varDCAB2EB8C531AB1E623FFAD695CFD286_1913146368 = (s.remove(o));
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return s.remove(o);
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.787 -0400", hash_original_method = "A91421BB58ED7F6569B24AAD1B5804AB", hash_generated_method = "169681B2048EA4656B55D473AD286499")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean contains(Object o) {
                dsTaint.addTaint(o.dsTaint);
                boolean var42C44FAC187AFC4735D76D5B7760F520_1494728591 = (s.contains(o));
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return s.contains(o);
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.788 -0400", hash_original_method = "8704A9C8AC3AA02909B00E4E211C4D3E", hash_generated_method = "98FAB28521C375BAF393E3EBD45AB056")
            @DSModeled(DSC.SAFE)
            @Override
            public boolean add(Map.Entry<K, V> o) {
                dsTaint.addTaint(o.dsTaint);
                if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //throw new UnsupportedOperationException();
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.790 -0400", hash_original_method = "1DB64DC7E3E98DAB777752CA6247DAE5", hash_generated_method = "5CC98BC6625B6D9B2F81EBFC387A5019")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean isEmpty() {
                boolean var33F6A8EED6267D5B4CCD3EAC631C616A_1153898041 = (s.isEmpty());
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return s.isEmpty();
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.791 -0400", hash_original_method = "3294D1F2516BD356F42ED84BE178EFCB", hash_generated_method = "56F964FA6A70EFA400FD2CD819F1C315")
            @DSModeled(DSC.SAFE)
            @Override
            public void clear() {
                s.clear();
                // ---------- Original Method ----------
                //s.clear();
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.793 -0400", hash_original_method = "61480F19A13469EF561F92E5A3700C23", hash_generated_method = "EB78C82A06BD3DF9BB098F5589073D6A")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public int size() {
                int var8151828880546AEA1C19BE7C52EE5E09_1959750704 = (s.size());
                return dsTaint.getTaintInt();
                // ---------- Original Method ----------
                //return s.size();
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.795 -0400", hash_original_method = "150ADDC982A3B6D8A573E663C38A7C9E", hash_generated_method = "24D6039FF2B2EE0D83173A92C50F7E60")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public int hashCode() {
                int varE2FC7D6C989F81F3F30CE1BE213D1E3F_904200088 = (s.hashCode());
                return dsTaint.getTaintInt();
                // ---------- Original Method ----------
                //return s.hashCode();
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.796 -0400", hash_original_method = "2565EBD5FCFC00F10C086CB36B3EEE8C", hash_generated_method = "1A861096DB4D376718F99E66EEF51CAC")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean equals(Object object) {
                dsTaint.addTaint(object.dsTaint);
                boolean varB696C6744E5DE06D0B58A4DB8EE26D83_1665554287 = (s.equals(object));
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return s.equals(object);
            }


            private static class CheckedEntryIterator<K, V> implements Iterator<Map.Entry<K, V>> {
                Iterator<Map.Entry<K, V>> i;
                Class<V> valueType;

                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.798 -0400", hash_original_method = "3CE5E36A95DFE16D33C2CC4176CB7EE4", hash_generated_method = "FA312F363D00A194C21F865C60036D10")
                @DSModeled(DSC.SAFE)
                public CheckedEntryIterator(Iterator<Map.Entry<K, V>> i,
                        Class<V> valueType) {
                    dsTaint.addTaint(valueType.dsTaint);
                    dsTaint.addTaint(i.dsTaint);
                    // ---------- Original Method ----------
                    //this.i = i;
                    //this.valueType = valueType;
                }


                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.799 -0400", hash_original_method = "59CA86A80410B66286C92523CF35EC7B", hash_generated_method = "9B80D3900BCFDD42DFC22C23E52486FD")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public boolean hasNext() {
                    boolean var048C390D087BEDAABDA4F669A9DA628E_314593686 = (i.hasNext());
                    return dsTaint.getTaintBoolean();
                    // ---------- Original Method ----------
                    //return i.hasNext();
                }


                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.800 -0400", hash_original_method = "048FA6C3E3A28865AD880AF8A3FCAE96", hash_generated_method = "6D29B2FB41FB1A7A3AE157A46C52D7BC")
                @DSModeled(DSC.SAFE)
                @Override
                public void remove() {
                    i.remove();
                    // ---------- Original Method ----------
                    //i.remove();
                }


                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.804 -0400", hash_original_method = "4D16E0BB01C90351B8312D1A4B7DB5F2", hash_generated_method = "F4CAF2BED5EAEBF2579540B734025059")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public Map.Entry<K, V> next() {
                    Map.Entry<K, V> var17B5968AC14D1D5FC5BD4F2E126C5421_1858598388 = (new CheckedEntry<K, V>(i.next(), valueType));
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.807 -0400", hash_original_method = "70499BD9B05065D265D741875DD058CA", hash_generated_method = "1C0AC7F2E2097A5D5F1C954C8F6DEEE4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CheckedSortedSet(SortedSet<E> s, Class<E> type) {
            super(s, type);
            dsTaint.addTaint(s.dsTaint);
            dsTaint.addTaint(type.dsTaint);
            // ---------- Original Method ----------
            //this.ss = s;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.809 -0400", hash_original_method = "8514D9255D678B041F55D03BA11DCA3B", hash_generated_method = "43029F831E267A3A9160247A9063A91F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Comparator<? super E> comparator() {
            Comparator<? super E> var05CAB94F8BD11820A94AC68A790A80A5_1751709214 = (ss.comparator());
            return (Comparator<? super E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ss.comparator();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.811 -0400", hash_original_method = "82539AB1166DFBB28D0E3DC3D0A43121", hash_generated_method = "305DFED68C486AEB6DF9A3A6CF249A69")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedSet<E> subSet(E fromElement, E toElement) {
            dsTaint.addTaint(fromElement.dsTaint);
            dsTaint.addTaint(toElement.dsTaint);
            SortedSet<E> var5328DA8CB8368089558365859562FB92_2116185547 = (new CheckedSortedSet<E>(ss.subSet(fromElement, toElement),
                    type));
            return (SortedSet<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CheckedSortedSet<E>(ss.subSet(fromElement, toElement),
                    //type);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.817 -0400", hash_original_method = "68D546866615C37E07B8E968E3813E84", hash_generated_method = "3BECACE1ABFC57E73EE1D900DBAABD10")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedSet<E> headSet(E toElement) {
            dsTaint.addTaint(toElement.dsTaint);
            SortedSet<E> var12D4E16E805D05744E7269E2733D45D5_1933791607 = (new CheckedSortedSet<E>(ss.headSet(toElement), type));
            return (SortedSet<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CheckedSortedSet<E>(ss.headSet(toElement), type);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.820 -0400", hash_original_method = "B0B4B667BF95B9D9A3CD3F7FE8BEFA1B", hash_generated_method = "7B20E2E9C6A014BA3C4839449D1F7C25")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedSet<E> tailSet(E fromElement) {
            dsTaint.addTaint(fromElement.dsTaint);
            SortedSet<E> var38D38D4E1852BE6949045F142A132E53_1810657899 = (new CheckedSortedSet<E>(ss.tailSet(fromElement), type));
            return (SortedSet<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CheckedSortedSet<E>(ss.tailSet(fromElement), type);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.823 -0400", hash_original_method = "6BB6C51843B41CC0DCB5509A79DBA008", hash_generated_method = "36F9963099EED55D4009D4296E72BADB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E first() {
            E varCAE51BE1E9DF20269B81A1FDC8990752_1292058212 = (ss.first());
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ss.first();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.824 -0400", hash_original_method = "AAC5DDE787ACA85752B94AAB77F6B0F8", hash_generated_method = "BF733ED6C38263FCC3E97B1D223982D1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E last() {
            E varB0B3C145EFB1EF3B95D9D987CE98A283_1082089955 = (ss.last());
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ss.last();
        }


    }



    private static class CheckedSortedMap<K, V> extends CheckedMap<K, V> implements SortedMap<K, V> {
        private static final long serialVersionUID = 1599671320688067438L;
        SortedMap<K, V> sm;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.828 -0400", hash_original_method = "2CB6EA0E6447E5AAF8B28B5FDF140BE4", hash_generated_method = "8232567E35D257A2309B59E4B066FF21")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         CheckedSortedMap(SortedMap<K, V> m, Class<K> keyType, Class<V> valueType) {
            super(m, keyType, valueType);
            dsTaint.addTaint(keyType.dsTaint);
            dsTaint.addTaint(valueType.dsTaint);
            dsTaint.addTaint(m.dsTaint);
            // ---------- Original Method ----------
            //this.sm = m;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.830 -0400", hash_original_method = "E5FDBCC6560BE7E99B2D2F850BD84149", hash_generated_method = "D5F33D1AB091245F919AAB7A2D83C8A1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Comparator<? super K> comparator() {
            Comparator<? super K> var422223D82196DD3FC2DC6264D5B430C5_439091060 = (sm.comparator());
            return (Comparator<? super K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return sm.comparator();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.831 -0400", hash_original_method = "65DE11E398BB209CD2689071C041161A", hash_generated_method = "75B87DB511BF01527374D2445BCC49B9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedMap<K, V> subMap(K fromKey, K toKey) {
            dsTaint.addTaint(toKey.dsTaint);
            dsTaint.addTaint(fromKey.dsTaint);
            SortedMap<K, V> var190C4EB84C21094B4E80D985CB6ACA7F_1847914707 = (new CheckedSortedMap<K, V>(sm.subMap(fromKey, toKey), keyType, valueType));
            return (SortedMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CheckedSortedMap<K, V>(sm.subMap(fromKey, toKey), keyType, valueType);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.836 -0400", hash_original_method = "2C5724B582D2FAB5716323DB894A671D", hash_generated_method = "6CA8E57C8CA4D5940C900A92CB242B06")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedMap<K, V> headMap(K toKey) {
            dsTaint.addTaint(toKey.dsTaint);
            SortedMap<K, V> var2BE0E60A1B317A0935CA3D78B86A50A4_2013564943 = (new CheckedSortedMap<K, V>(sm.headMap(toKey), keyType, valueType));
            return (SortedMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CheckedSortedMap<K, V>(sm.headMap(toKey), keyType, valueType);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.845 -0400", hash_original_method = "2879524DD09B17D2FCB7AD1626D24618", hash_generated_method = "02AD8710BD666BDB21AF947AD7C04797")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SortedMap<K, V> tailMap(K fromKey) {
            dsTaint.addTaint(fromKey.dsTaint);
            SortedMap<K, V> varE2D105EA819834A2EAC8202B8964FD2E_1811194770 = (new CheckedSortedMap<K, V>(sm.tailMap(fromKey), keyType, valueType));
            return (SortedMap<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CheckedSortedMap<K, V>(sm.tailMap(fromKey), keyType, valueType);
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.847 -0400", hash_original_method = "B25E8C7440C76FBF812FF7AC9CA9D776", hash_generated_method = "892BA2FE9FCA06EDDB487F5590A0415E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public K firstKey() {
            K var27D52CE4EA4B74D34E8381D333AAE9A4_150131214 = (sm.firstKey());
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return sm.firstKey();
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:41.850 -0400", hash_original_method = "00E9126A84DE8B71214859A17DA6BD2E", hash_generated_method = "1A94F4424692A514BA3974382ECEFEFF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public K lastKey() {
            K var9F9AE843A8A54EC3D9E8230A61FB8B04_1657740529 = (sm.lastKey());
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return sm.lastKey();
        }


    }



}


