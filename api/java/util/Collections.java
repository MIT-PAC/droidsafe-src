package java.util;

// Droidsafe Imports
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class Collections {
    
    /*
    private static final Iterator<?> EMPTY_ITERATOR = new Iterator<Object>() {
        @Override public boolean hasNext() {
            return false;
        }

        @Override public Object next() {
            //throw new NoSuchElementException();
        }

        @Override public void remove() {
            //throw new IllegalStateException();
        }
    };
    private static final Enumeration<?> EMPTY_ENUMERATION = new Enumeration<Object>() {
        @Override public boolean hasMoreElements() {
            return false;
        }

        @Override public Object nextElement() {
            //throw new NoSuchElementException();
        }
    };
    */
    
    private static final class CopiesList<E> extends AbstractList<E> implements Serializable {
        
        private static final long serialVersionUID = 2739099268398711800L;
        private /*final*/ int n;
        private /*final*/ E element;
        
        CopiesList(int length, E object){
            //throw new IllegalArgumentException();
            addTaint(length);
            element = object;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            /*
            if (length < 0) {
                throw new IllegalArgumentException();
            }
            n = length;
            element = object;
            */
        }
        
        @Override public boolean contains(Object object){
            return getTaintBoolean();

            // Original method
            /*
            {
            return element == null ? object == null : element.equals(object);
        }
            */
        }
        
        @Override public int size(){
            return getTaintInt();

            // Original method
            /*
            {
            return n;
        }
            */
        }
        
        @Override public E get(int location){
            //throw new IndexOutOfBoundsException();
            return element;  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            if (location >= 0 && location < n) {
                return element;
            }
            throw new IndexOutOfBoundsException();
        }
            */
        }
    }
    
    
    /*
    @SuppressWarnings("unchecked") private static final class EmptyList extends AbstractList implements RandomAccess, Serializable {
        
        private static final long serialVersionUID = 8842843931221139166L;
        
        @Override public boolean contains(Object object){
            return getTaintBoolean();

            // Original method
            return false;
        }
        
        @Override public int size(){
            return getTaintInt();

            // Original method
            return 0;
        }
        
        @Override public Object get(int location){
            throw new IndexOutOfBoundsException();
            // Original method
            throw new IndexOutOfBoundsException();
        }
        
        private Object readResolve(){
            return Collections.EMPTY_LIST;  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            return Collections.EMPTY_LIST;
        }
    }
    
    
    @SuppressWarnings("unchecked") private static final class EmptySet extends AbstractSet implements Serializable {
        
        private static final long serialVersionUID = 1582296315990362920L;
        
        @Override public boolean contains(Object object){
            return getTaintBoolean();

            // Original method
            return false;
        }
        
        @Override public int size(){
            return getTaintInt();

            // Original method
            return 0;
        }
        
        @Override public Iterator iterator(){
            return EMPTY_ITERATOR;  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            return EMPTY_ITERATOR;
        }
        
        private Object readResolve(){
            return Collections.EMPTY_SET;  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return Collections.EMPTY_SET;
        }
    }
    
    
    @SuppressWarnings("unchecked") private static final class EmptyMap extends AbstractMap implements Serializable {
        
        private static final long serialVersionUID = 6428348081105594320L;
        
        @Override public boolean containsKey(Object key){
            return getTaintBoolean();

            // Original method
            return false;
        }
        
        @Override public boolean containsValue(Object value){
            return getTaintBoolean();

            // Original method
            return false;
        }
        
        @Override public Set entrySet(){
            return EMPTY_SET;  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            return EMPTY_SET;
        }
        
        @Override public Object get(Object key){
            return null;  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            return null;
        }
        
        @Override public Set keySet(){
            return EMPTY_SET;  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            return EMPTY_SET;
        }
        
        @Override public Collection values(){
            return EMPTY_LIST;  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            return EMPTY_LIST;
        }
        
        private Object readResolve(){
            return Collections.EMPTY_MAP;  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            return Collections.EMPTY_MAP;
        }
    }
    
    @SuppressWarnings("unchecked")
    public static final List EMPTY_LIST = new EmptyList();
    @SuppressWarnings("unchecked")
    public static final Set EMPTY_SET = new EmptySet();
    @SuppressWarnings("unchecked")
    public static final Map EMPTY_MAP = new EmptyMap();
    */
    
    private static final class ReverseComparator <T> implements Comparator<T>, Serializable {
        
        private static final ReverseComparator<Object> INSTANCE = new ReverseComparator<Object>();
        private static final long serialVersionUID = 7207038068494060240L;
        
        @SuppressWarnings("unchecked") @Override public int compare(T o1, T o2){
            //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
            //Comparable<T> c2 = (Comparable<T>) o2;
            return getTaintInt();

            // Original method
            /*
            {
            Comparable<T> c2 = (Comparable<T>) o2;
            return c2.compareTo(o1);
        }
            */
        }
        
        private Object readResolve(){
            return INSTANCE;  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return INSTANCE;
        }
            */
        }
    }
    
    
    private static final class ReverseComparator2 <T> implements Comparator<T>, Serializable {
        
        private static final long serialVersionUID = 4374092139857L;
        private final Comparator<T> cmp;
        
        ReverseComparator2(Comparator<T> comparator){
            this.cmp = comparator;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            /*
            this.cmp = comparator;
            */
        }
        
        @Override public int compare(T o1, T o2){
            return getTaintInt();

            // Original method
            /*
            {
            return cmp.compare(o2, o1);
        }
            */
        }
        
        @Override public boolean equals(Object o){
            return getTaintBoolean();

            // Original method
            /*
            {
            return o instanceof ReverseComparator2
                    && ((ReverseComparator2) o).cmp.equals(cmp);
        }
            */
        }
        
        @Override public int hashCode(){
            return getTaintInt();

            // Original method
            /*
            {
            return ~cmp.hashCode();
        }
            */
        }
    }
    
    
    private static final class SingletonSet<E> extends AbstractSet<E> implements Serializable {
        
        private static final long serialVersionUID = 3193687207550431679L;
        final E element;
        
        SingletonSet(E object){
            element = object;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            /*
            element = object;
            */
        }
        
        @Override public boolean contains(Object object){
            return getTaintBoolean();

            // Original method
            /*
            {
            return element == null ? object == null : element.equals(object);
        }
            */
        }
        
        @Override public int size(){
            return getTaintInt();

            // Original method
            /*
            {
            return 1;
        }
            */
        }
        
        @Override public Iterator<E> iterator(){
            return new Iterator<E>() {
                boolean hasNext = true;

                @Override public boolean hasNext() {
                    return hasNext;
                }

                @Override public E next() {
                    return element;
                    //throw new NoSuchElementException();
                }

                @Override public void remove() {
                    throw new UnsupportedOperationException();
                }
            };  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return new Iterator<E>() {
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
        }
            */
        }
    }
    
    
    private static final class SingletonList<E> extends AbstractList<E> implements Serializable {
        
        private static final long serialVersionUID = 3093736618740652951L;
        final E element;
        
        SingletonList(E object){
            element = object;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            /*
            element = object;
            */
        }
        
        @Override public boolean contains(Object object){
            return getTaintBoolean();

            // Original method
            /*
            {
            return element == null ? object == null : element.equals(object);
        }
            */
        }
        
        @Override public E get(int location){
            //throw new IndexOutOfBoundsException();
            return (E);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            if (location == 0) {
                return element;
            }
            throw new IndexOutOfBoundsException();
        }
            */
        }
        
        @Override public int size(){
            return getTaintInt();

            // Original method
            /*
            {
            return 1;
        }
            */
        }
    }
    
    
    private static final class SingletonMap<K, V> extends AbstractMap<K,V> implements Serializable {
        
        private static final long serialVersionUID = -6979724477215052911L;
        final K k;
        final V v;
        
        SingletonMap(K key, V value){
            k = key;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            v = value;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            /*
            k = key;
            v = value;
            */
        }
        
        @Override public boolean containsKey(Object key){
            return getTaintBoolean();

            // Original method
            /*
            {
            return k == null ? key == null : k.equals(key);
        }
            */
        }
        
        @Override public boolean containsValue(Object value){
            return getTaintBoolean();

            // Original method
            /*
            {
            return v == null ? value == null : v.equals(value);
        }
            */
        }
        
        @Override public V get(Object key){
            //DSFIXME:  CODE0006: Method has multiple returns and requires manual review
            //return null;  //DSFIXME:  CODE0001: Unresolved return type/value combination

            return v;  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            if (containsKey(key)) {
                return v;
            }
            return null;
        }
            */
        }
        
        @Override public int size(){
            return getTaintInt();

            // Original method
            /*
            {
            return 1;
        }
            */
        }
        
        @Override public Set<Map.Entry<K, V>> entrySet(){
            return new AbstractSet<Map.Entry<K, V>>() {
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
                                //throw new NoSuchElementException();
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
            };  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /* Original Method Too Long, Refer to Original Implementation */
        }
    }
    
    
    static class SynchronizedCollection<E> implements Collection<E>, Serializable {
        
        private static final long serialVersionUID = 3053995032091335093L;
        final Collection<E> c;
        /*final*/ Object mutex;
        
        SynchronizedCollection(Collection<E> collection){
            c = collection;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            /*
            c = collection;
            mutex = this;
            */
        }
        
        SynchronizedCollection(Collection<E> collection, Object mutex){
            c = collection;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            this.mutex = mutex;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            /*
            c = collection;
            this.mutex = mutex;
            */
        }
        
        @Override public boolean add(E object){
            return getTaintBoolean();

            // Original method
            /*
            {
            synchronized (mutex) {
                return c.add(object);
            }
        }
            */
        }
        
        @Override public boolean addAll(Collection<? extends E> collection){
            return getTaintBoolean();

            // Original method
            /*
            {
            synchronized (mutex) {
                return c.addAll(collection);
            }
        }
            */
        }
        
        @Override public void clear(){
            c.clear();
            // Original method
            /*
            {
            synchronized (mutex) {
                c.clear();
            }
        }
            */
        }
        
        @Override public boolean contains(Object object){
            return getTaintBoolean();

            // Original method
            /*
            {
            synchronized (mutex) {
                return c.contains(object);
            }
        }
            */
        }
        
        @Override public boolean containsAll(Collection<?> collection){
            return getTaintBoolean();

            // Original method
            /*
            {
            synchronized (mutex) {
                return c.containsAll(collection);
            }
        }
            */
        }
        
        @Override public boolean isEmpty(){
            return getTaintBoolean();

            // Original method
            /*
            {
            synchronized (mutex) {
                return c.isEmpty();
            }
        }
            */
        }
        
        @Override public Iterator<E> iterator(){
            return c.iterator();  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            synchronized (mutex) {
                return c.iterator();
            }
        }
            */
        }
        
        @Override public boolean remove(Object object){
            return getTaintBoolean();

            // Original method
            /*
            {
            synchronized (mutex) {
                return c.remove(object);
            }
        }
            */
        }
        
        @Override public boolean removeAll(Collection<?> collection){
            return getTaintBoolean();

            // Original method
            /*
            {
            synchronized (mutex) {
                return c.removeAll(collection);
            }
        }
            */
        }
        
        @Override public boolean retainAll(Collection<?> collection){
            return getTaintBoolean();

            // Original method
            /*
            {
            synchronized (mutex) {
                return c.retainAll(collection);
            }
        }
            */
        }
        
        @Override public int size(){
            return getTaintInt();

            // Original method
            /*
            {
            synchronized (mutex) {
                return c.size();
            }
        }
            */
        }
        
        @Override public java.lang.Object[] toArray(){
            return c.toArray();  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            synchronized (mutex) {
                return c.toArray();
            }
        }
            */
        }
        
        @Override public String toString(){
            return getTaintString();

            // Original method
            /*
            {
            synchronized (mutex) {
                return c.toString();
            }
        }
            */
        }
        
        @Override public <T> T[] toArray(T[] array){
            return c.toArray(array);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            synchronized (mutex) {
                return c.toArray(array);
            }
        }
            */
        }
        
        private void writeObject(ObjectOutputStream stream){
            //stream.defaultWriteObject();
            // Original method
            /*
            {
            synchronized (mutex) {
                stream.defaultWriteObject();
            }
        }
            */
        }
    }
    
    
    static class SynchronizedRandomAccessList<E> extends SynchronizedList<E> implements RandomAccess {
        
        private static final long serialVersionUID = 1530674583602358482L;
        
        SynchronizedRandomAccessList(List<E> l){
            super(l);
        }
        
        SynchronizedRandomAccessList(List<E> l, Object mutex){
            super(l, mutex);
        }
        
        @Override public List<E> subList(int start, int end){
            return new SynchronizedRandomAccessList<E>(list.subList(start, end), mutex);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            synchronized (mutex) {
                return new SynchronizedRandomAccessList<E>(list.subList(start, end), mutex);
            }
        }
            */
        }
        
        private Object writeReplace(){
            return new SynchronizedList<E>(list);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return new SynchronizedList<E>(list);
        }
            */
        }
    }
    
    
    static class SynchronizedList<E> extends SynchronizedCollection<E> implements List<E> {
        
        private static final long serialVersionUID = -7754090372962971524L;
        final List<E> list;
        
        SynchronizedList(List<E> l){
            super(l);
            list = l;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            /*
            list = l;
            */
        }
        
        SynchronizedList(List<E> l, Object mutex){
            super(l, mutex);
            list = l;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            /*
            list = l;
            */
        }
        
        @Override public void add(int location, E object){
            list.add(location, object);
            // Original method
            /*
            {
            synchronized (mutex) {
                list.add(location, object);
            }
        }
            */
        }
        
        @Override public boolean addAll(int location, Collection<? extends E> collection){
            return getTaintBoolean();

            // Original method
            /*
            {
            synchronized (mutex) {
                return list.addAll(location, collection);
            }
        }
            */
        }
        
        @Override public boolean equals(Object object){
            return getTaintBoolean();

            // Original method
            /*
            {
            synchronized (mutex) {
                return list.equals(object);
            }
        }
            */
        }
        
        @Override public E get(int location){
            return list.get(location);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            synchronized (mutex) {
                return list.get(location);
            }
        }
            */
        }
        
        @Override public int hashCode(){
            return getTaintInt();

            // Original method
            /*
            {
            synchronized (mutex) {
                return list.hashCode();
            }
        }
            */
        }
        
        @Override public int indexOf(Object object){
            //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
            //final int size;
            //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
            //final Object[] array;
            //list.toArray(array);
            return getTaintInt();

            // Original method
            /*
            {
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
            */
        }
        
        @Override public int lastIndexOf(Object object){
            //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
            //final int size;
            //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
            //final Object[] array;
            //list.toArray(array);
            return getTaintInt();

            // Original method
            /*
            {
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
            */
        }
        
        @Override public ListIterator<E> listIterator(){
            return list.listIterator();  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            synchronized (mutex) {
                return list.listIterator();
            }
        }
            */
        }
        
        @Override public ListIterator<E> listIterator(int location){
            return list.listIterator(location);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            synchronized (mutex) {
                return list.listIterator(location);
            }
        }
            */
        }
        
        @Override public E remove(int location){
            return list.remove(location);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            synchronized (mutex) {
                return list.remove(location);
            }
        }
            */
        }
        
        @Override public E set(int location, E object){
            return list.set(location, object);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            synchronized (mutex) {
                return list.set(location, object);
            }
        }
            */
        }
        
        @Override public List<E> subList(int start, int end){
            return new SynchronizedList<E>(list.subList(start, end), mutex);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            synchronized (mutex) {
                return new SynchronizedList<E>(list.subList(start, end), mutex);
            }
        }
            */
        }
        
        private void writeObject(ObjectOutputStream stream){
            //stream.defaultWriteObject();
            // Original method
            /*
            {
            synchronized (mutex) {
                stream.defaultWriteObject();
            }
        }
            */
        }
        
        private Object readResolve(){
            //DSFIXME:  CODE0006: Method has multiple returns and requires manual review
            return this;  //DSFIXME:  CODE0001: Unresolved return type/value combination


            // Original method
            /*
            {
            if (list instanceof RandomAccess) {
                return new SynchronizedRandomAccessList<E>(list, mutex);
            }
            return this;
        }
            */
        }
    }
    
    
    static class SynchronizedMap<K, V> implements Map<K,V>, Serializable {
        
        private static final long serialVersionUID = 1978198479659022715L;
        private final Map<K, V> m;
        /*final*/ Object mutex;
        
        SynchronizedMap(Map<K, V> map){
            m = map;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            /*
            m = map;
            mutex = this;
            */
        }
        
        SynchronizedMap(Map<K, V> map, Object mutex){
            m = map;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            this.mutex = mutex;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            /*
            m = map;
            this.mutex = mutex;
            */
        }
        
        @Override public void clear(){
            m.clear();
            // Original method
            /*
            {
            synchronized (mutex) {
                m.clear();
            }
        }
            */
        }
        
        @Override public boolean containsKey(Object key){
            return getTaintBoolean();

            // Original method
            /*
            {
            synchronized (mutex) {
                return m.containsKey(key);
            }
        }
            */
        }
        
        @Override public boolean containsValue(Object value){
            return getTaintBoolean();

            // Original method
            /*
            {
            synchronized (mutex) {
                return m.containsValue(value);
            }
        }
            */
        }
        
        @Override public Set<Map.Entry<K, V>> entrySet(){
            return new SynchronizedSet<Map.Entry<K, V>>(m.entrySet(), mutex);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            synchronized (mutex) {
                return new SynchronizedSet<Map.Entry<K, V>>(m.entrySet(), mutex);
            }
        }
            */
        }
        
        @Override public boolean equals(Object object){
            return getTaintBoolean();

            // Original method
            /*
            {
            synchronized (mutex) {
                return m.equals(object);
            }
        }
            */
        }
        
        @Override public V get(Object key){
            return m.get(key);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            synchronized (mutex) {
                return m.get(key);
            }
        }
            */
        }
        
        @Override public int hashCode(){
            return getTaintInt();

            // Original method
            /*
            {
            synchronized (mutex) {
                return m.hashCode();
            }
        }
            */
        }
        
        @Override public boolean isEmpty(){
            return getTaintBoolean();

            // Original method
            /*
            {
            synchronized (mutex) {
                return m.isEmpty();
            }
        }
            */
        }
        
        @Override public Set<K> keySet(){
            return new SynchronizedSet<K>(m.keySet(), mutex);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            synchronized (mutex) {
                return new SynchronizedSet<K>(m.keySet(), mutex);
            }
        }
            */
        }
        
        @Override public V put(K key, V value){
            return m.put(key, value);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            synchronized (mutex) {
                return m.put(key, value);
            }
        }
            */
        }
        
        @Override public void putAll(Map<? extends K, ? extends V> map){
            m.putAll(map);
            // Original method
            /*
            {
            synchronized (mutex) {
                m.putAll(map);
            }
        }
            */
        }
        
        @Override public V remove(Object key){
            return m.remove(key);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            synchronized (mutex) {
                return m.remove(key);
            }
        }
            */
        }
        
        @Override public int size(){
            return getTaintInt();

            // Original method
            /*
            {
            synchronized (mutex) {
                return m.size();
            }
        }
            */
        }
        
        @Override public Collection<V> values(){
            return new SynchronizedCollection<V>(m.values(), mutex);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            synchronized (mutex) {
                return new SynchronizedCollection<V>(m.values(), mutex);
            }
        }
            */
        }
        
        @Override public String toString(){
            return getTaintString();

            // Original method
            /*
            {
            synchronized (mutex) {
                return m.toString();
            }
        }
            */
        }
        
        private void writeObject(ObjectOutputStream stream){
            //stream.defaultWriteObject();
            // Original method
            /*
            {
            synchronized (mutex) {
                stream.defaultWriteObject();
            }
        }
            */
        }
    }
    
    
    static class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E> {
        
        private static final long serialVersionUID = 487447009682186044L;
        
        SynchronizedSet(Set<E> set){
            super(set);
        }
        
        SynchronizedSet(Set<E> set, Object mutex){
            super(set, mutex);
        }
        
        @Override public boolean equals(Object object){
            return getTaintBoolean();

            // Original method
            /*
            {
            synchronized (mutex) {
                return c.equals(object);
            }
        }
            */
        }
        
        @Override public int hashCode(){
            return getTaintInt();

            // Original method
            /*
            {
            synchronized (mutex) {
                return c.hashCode();
            }
        }
            */
        }
        
        private void writeObject(ObjectOutputStream stream){
            //stream.defaultWriteObject();
            // Original method
            /*
            {
            synchronized (mutex) {
                stream.defaultWriteObject();
            }
        }
            */
        }
    }
    
    
    static class SynchronizedSortedMap<K, V> extends SynchronizedMap<K,V> implements SortedMap<K,V> {
        
        private static final long serialVersionUID = -8798146769416483793L;
        private final SortedMap<K, V> sm;
        
        SynchronizedSortedMap(SortedMap<K, V> map){
            super(map);
            sm = map;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            /*
            sm = map;
            */
        }
        
        SynchronizedSortedMap(SortedMap<K, V> map, Object mutex){
            super(map, mutex);
            sm = map;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            /*
            sm = map;
            */
        }
        
        @Override public Comparator<? super K> comparator(){
            return sm.comparator();  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            synchronized (mutex) {
                return sm.comparator();
            }
        }
            */
        }
        
        @Override public K firstKey(){
            return sm.firstKey();  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            synchronized (mutex) {
                return sm.firstKey();
            }
        }
            */
        }
        
        @Override public SortedMap<K, V> headMap(K endKey){
            return new SynchronizedSortedMap<K, V>(sm.headMap(endKey),
                        mutex);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            synchronized (mutex) {
                return new SynchronizedSortedMap<K, V>(sm.headMap(endKey),
                        mutex);
            }
        }
            */
        }
        
        @Override public K lastKey(){
            return sm.lastKey();  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            synchronized (mutex) {
                return sm.lastKey();
            }
        }
            */
        }
        
        @Override public SortedMap<K, V> subMap(K startKey, K endKey){
            return new SynchronizedSortedMap<K, V>(sm.subMap(startKey,
                        endKey), mutex);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            synchronized (mutex) {
                return new SynchronizedSortedMap<K, V>(sm.subMap(startKey,
                        endKey), mutex);
            }
        }
            */
        }
        
        @Override public SortedMap<K, V> tailMap(K startKey){
            return new SynchronizedSortedMap<K, V>(sm.tailMap(startKey),
                        mutex);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            synchronized (mutex) {
                return new SynchronizedSortedMap<K, V>(sm.tailMap(startKey),
                        mutex);
            }
        }
            */
        }
        
        private void writeObject(ObjectOutputStream stream){
            //stream.defaultWriteObject();
            // Original method
            /*
            {
            synchronized (mutex) {
                stream.defaultWriteObject();
            }
        }
            */
        }
    }
    
    
    static class SynchronizedSortedSet<E> extends SynchronizedSet<E> implements SortedSet<E> {
        
        private static final long serialVersionUID = 8695801310862127406L;
        private final SortedSet<E> ss;
        
        SynchronizedSortedSet(SortedSet<E> set){
            super(set);
            ss = set;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            /*
            ss = set;
            */
        }
        
        SynchronizedSortedSet(SortedSet<E> set, Object mutex){
            super(set, mutex);
            ss = set;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            /*
            ss = set;
            */
        }
        
        @Override public Comparator<? super E> comparator(){
            return ss.comparator();  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            synchronized (mutex) {
                return ss.comparator();
            }
        }
            */
        }
        
        @Override public E first(){
            return ss.first();  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            synchronized (mutex) {
                return ss.first();
            }
        }
            */
        }
        
        @Override public SortedSet<E> headSet(E end){
            return new SynchronizedSortedSet<E>(ss.headSet(end), mutex);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            synchronized (mutex) {
                return new SynchronizedSortedSet<E>(ss.headSet(end), mutex);
            }
        }
            */
        }
        
        @Override public E last(){
            return ss.last();  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            synchronized (mutex) {
                return ss.last();
            }
        }
            */
        }
        
        @Override public SortedSet<E> subSet(E start, E end){
            return new SynchronizedSortedSet<E>(ss.subSet(start, end),
                        mutex);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            synchronized (mutex) {
                return new SynchronizedSortedSet<E>(ss.subSet(start, end),
                        mutex);
            }
        }
            */
        }
        
        @Override public SortedSet<E> tailSet(E start){
            return new SynchronizedSortedSet<E>(ss.tailSet(start), mutex);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            synchronized (mutex) {
                return new SynchronizedSortedSet<E>(ss.tailSet(start), mutex);
            }
        }
            */
        }
        
        private void writeObject(ObjectOutputStream stream){
            //stream.defaultWriteObject();
            // Original method
            /*
            {
            synchronized (mutex) {
                stream.defaultWriteObject();
            }
        }
            */
        }
    }
    
    
    private static class UnmodifiableCollection<E> implements Collection<E>, Serializable {
        
        private static final long serialVersionUID = 1820017752578914078L;
        final Collection<E> c;
        
        UnmodifiableCollection(Collection<E> collection){
            c = collection;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            /*
            c = collection;
            */
        }
        
        @Override public boolean add(E object){
            throw new UnsupportedOperationException();
            // Original method
            /*
            {
            throw new UnsupportedOperationException();
        }
            */
        }
        
        @Override public boolean addAll(Collection<? extends E> collection){
            throw new UnsupportedOperationException();
            // Original method
            /*
            {
            throw new UnsupportedOperationException();
        }
            */
        }
        
        @Override public void clear(){
            throw new UnsupportedOperationException();
            // Original method
            /*
            {
            throw new UnsupportedOperationException();
        }
            */
        }
        
        @Override public boolean contains(Object object){
            return getTaintBoolean();

            // Original method
            /*
            {
            return c.contains(object);
        }
            */
        }
        
        @Override public boolean containsAll(Collection<?> collection){
            return getTaintBoolean();

            // Original method
            /*
            {
            return c.containsAll(collection);
        }
            */
        }
        
        @Override public boolean isEmpty(){
            return getTaintBoolean();

            // Original method
            /*
            {
            return c.isEmpty();
        }
            */
        }
        
        @Override public Iterator<E> iterator(){
            return new Iterator<E>() {
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
            };  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return new Iterator<E>() {
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
        }
            */
        }
        
        @Override public boolean remove(Object object){
            throw new UnsupportedOperationException();
            // Original method
            /*
            {
            throw new UnsupportedOperationException();
        }
            */
        }
        
        @Override public boolean removeAll(Collection<?> collection){
            throw new UnsupportedOperationException();
            // Original method
            /*
            {
            throw new UnsupportedOperationException();
        }
            */
        }
        
        @Override public boolean retainAll(Collection<?> collection){
            throw new UnsupportedOperationException();
            // Original method
            /*
            {
            throw new UnsupportedOperationException();
        }
            */
        }
        
        @Override public int size(){
            return getTaintInt();

            // Original method
            /*
            {
            return c.size();
        }
            */
        }
        
        @Override public Object[] toArray(){
            return c.toArray();  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return c.toArray();
        }
            */
        }
        
        @Override public <T> T[] toArray(T[] array){
            return c.toArray(array);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return c.toArray(array);
        }
            */
        }
        
        @Override public String toString(){
            return getTaintString();

            // Original method
            /*
            {
            return c.toString();
        }
            */
        }
    }
    
    
    private static class UnmodifiableRandomAccessList<E> extends UnmodifiableList<E> implements RandomAccess {
        
        private static final long serialVersionUID = -2542308836966382001L;
        
        UnmodifiableRandomAccessList(List<E> l){
            super(l);
        }
        
        @Override public List<E> subList(int start, int end){
            return new UnmodifiableRandomAccessList<E>(list.subList(start, end));  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return new UnmodifiableRandomAccessList<E>(list.subList(start, end));
        }
            */
        }
        
        private Object writeReplace(){
            return new UnmodifiableList<E>(list);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return new UnmodifiableList<E>(list);
        }
            */
        }
    }
    
    
    private static class UnmodifiableList<E> extends UnmodifiableCollection<E> implements List<E> {
        
        private static final long serialVersionUID = -283967356065247728L;
        final List<E> list;
        
        UnmodifiableList(List<E> l){
            super(l);
            list = l;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            /*
            list = l;
            */
        }
        
        @Override public void add(int location, E object){
            throw new UnsupportedOperationException();
            // Original method
            /*
            {
            throw new UnsupportedOperationException();
        }
            */
        }
        
        @Override public boolean addAll(int location, Collection<? extends E> collection){
            throw new UnsupportedOperationException();
            // Original method
            /*
            {
            throw new UnsupportedOperationException();
        }
            */
        }
        
        @Override public boolean equals(Object object){
            return getTaintBoolean();

            // Original method
            /*
            {
            return list.equals(object);
        }
            */
        }
        
        @Override public E get(int location){
            return list.get(location);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return list.get(location);
        }
            */
        }
        
        @Override public int hashCode(){
            return getTaintInt();

            // Original method
            /*
            {
            return list.hashCode();
        }
            */
        }
        
        @Override public int indexOf(Object object){
            return getTaintInt();

            // Original method
            /*
            {
            return list.indexOf(object);
        }
            */
        }
        
        @Override public int lastIndexOf(Object object){
            return getTaintInt();

            // Original method
            /*
            {
            return list.lastIndexOf(object);
        }
            */
        }
        
        @Override public ListIterator<E> listIterator(){
            return listIterator(0);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return listIterator(0);
        }
            */
        }
        
        @Override public ListIterator<E> listIterator(final int location){
            return new ListIterator<E>() {
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
            };  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /* Original Method Too Long, Refer to Original Implementation */
        }
        
        @Override public E remove(int location){
            throw new UnsupportedOperationException();
            // Original method
            /*
            {
            throw new UnsupportedOperationException();
        }
            */
        }
        
        @Override public E set(int location, E object){
            throw new UnsupportedOperationException();
            // Original method
            /*
            {
            throw new UnsupportedOperationException();
        }
            */
        }
        
        @Override public List<E> subList(int start, int end){
            return new UnmodifiableList<E>(list.subList(start, end));  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return new UnmodifiableList<E>(list.subList(start, end));
        }
            */
        }
        
        private Object readResolve(){
            //DSFIXME:  CODE0006: Method has multiple returns and requires manual review
            //return new UnmodifiableRandomAccessList<E>(list);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            return this;  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            if (list instanceof RandomAccess) {
                return new UnmodifiableRandomAccessList<E>(list);
            }
            return this;
        }
            */
        }
    }
    
    
    private static class UnmodifiableMap<K, V> implements Map<K,V>, Serializable {
        
        private static final long serialVersionUID = -1034234728574286014L;
        private final Map<K, V> m;
        
        private static class UnmodifiableEntrySet<K, V> extends UnmodifiableSet<Map.Entry<K,V>> {
            
            private static final long serialVersionUID = 7854390611657943733L;
            
            private static class UnmodifiableMapEntry<K, V> implements Map.Entry<K,V> {
                
                Map.Entry<K, V> mapEntry;
                
                @DSModeled(DSC.SAFE)
                UnmodifiableMapEntry(Map.Entry<K, V> entry){
                    mapEntry = entry;  //DSFIXME:  CODE0003: Field assignment should be reviewed
                    /*
                    mapEntry = entry;
                    */
                }
                
                @Override public boolean equals(Object object){
                    return getTaintBoolean();

                    // Original method
                    /*
                    {
                    return mapEntry.equals(object);
                }
                    */
                }
                
                @Override public K getKey(){
                    return mapEntry.getKey();  //DSFIXME:  CODE0001: Unresolved return type/value combination

                    // Original method
                    /*
                    {
                    return mapEntry.getKey();
                }
                    */
                }
                
                @Override public V getValue(){
                    return mapEntry.getValue();  //DSFIXME:  CODE0001: Unresolved return type/value combination

                    // Original method
                    /*
                    {
                    return mapEntry.getValue();
                }
                    */
                }
                
                @Override public int hashCode(){
                    return getTaintInt();

                    // Original method
                    /*
                    {
                    return mapEntry.hashCode();
                }
                    */
                }
                
                @Override public V setValue(V object){
                    throw new UnsupportedOperationException();
                    // Original method
                    /*
                    {
                    throw new UnsupportedOperationException();
                }
                    */
                }
                
                @Override public String toString(){
                    return getTaintString();

                    // Original method
                    /*
                    {
                    return mapEntry.toString();
                }
                    */
                }
            }
            
            
            UnmodifiableEntrySet(Set<Map.Entry<K, V>> set){
                super(set);
            }
            
            @Override public Iterator<Map.Entry<K, V>> iterator(){
                return new Iterator<Map.Entry<K, V>>() {
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
                };  //DSFIXME:  CODE0001: Unresolved return type/value combination

                // Original method
                /*
                {
                return new Iterator<Map.Entry<K, V>>() {
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
            }
                */
            }
            
            @Override public Object[] toArray(){
                //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
                //int length = c.size();
                //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
                Object[] result = new Object[1];
                result.addTaint(this.getTaint().getTaint());
                //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
                //Iterator<?> it = iterator();
                return result;  //DSFIXME:  CODE0001: Unresolved return type/value combination

                // Original method
                /*
                {
                int length = c.size();
                Object[] result = new Object[length];
                Iterator<?> it = iterator();
                for (int i = length; --i >= 0;) {
                    result[i] = it.next();
                }
                return result;
            }
                */
            }
            
            @SuppressWarnings("unchecked") @Override public <T> T[] toArray(T[] contents){
                //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
                //int size = c.size(), index = 0;
                //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
                //Iterator<Map.Entry<K, V>> it = iterator();
                //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
                //Class<?> ct = contents.getClass().getComponentType();
                return contents;  //DSFIXME:  CODE0001: Unresolved return type/value combination

                // Original method
                /*
                {
                int size = c.size(), index = 0;
                Iterator<Map.Entry<K, V>> it = iterator();
                if (size > contents.length) {
                    Class<?> ct = contents.getClass().getComponentType();
                    contents = (T[]) Array.newInstance(ct, size);
                }
                while (index < size) {
                    contents[index++] = (T) it.next();
                }
                if (index < contents.length) {
                    contents[index] = null;
                }
                return contents;
            }
                */
            }
        }
        
        
        @DSModeled(DSC.SAFE)
        UnmodifiableMap(Map<K, V> map){
            m = map;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            /*
            m = map;
            */
        }
        
        @Override public void clear(){
            throw new UnsupportedOperationException();
            // Original method
            /*
            {
            throw new UnsupportedOperationException();
        }
            */
        }
        
        @Override public boolean containsKey(Object key){
            return getTaintBoolean();

            // Original method
            /*
            {
            return m.containsKey(key);
        }
            */
        }
        
        @Override public boolean containsValue(Object value){
            return getTaintBoolean();

            // Original method
            /*
            {
            return m.containsValue(value);
        }
            */
        }
        
        @Override public Set<Map.Entry<K, V>> entrySet(){
            return new UnmodifiableEntrySet<K, V>(m.entrySet());  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return new UnmodifiableEntrySet<K, V>(m.entrySet());
        }
            */
        }
        
        @Override public boolean equals(Object object){
            return getTaintBoolean();

            // Original method
            /*
            {
            return m.equals(object);
        }
            */
        }
        
        @Override public V get(Object key){
            return m.get(key);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return m.get(key);
        }
            */
        }
        
        @Override public int hashCode(){
            return getTaintInt();

            // Original method
            /*
            {
            return m.hashCode();
        }
            */
        }
        
        @Override public boolean isEmpty(){
            return getTaintBoolean();

            // Original method
            /*
            {
            return m.isEmpty();
        }
            */
        }
        
        @Override public Set<K> keySet(){
            return new UnmodifiableSet<K>(m.keySet());  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return new UnmodifiableSet<K>(m.keySet());
        }
            */
        }
        
        @Override public V put(K key, V value){
            throw new UnsupportedOperationException();
            // Original method
            /*
            {
            throw new UnsupportedOperationException();
        }
            */
        }
        
        @Override public void putAll(Map<? extends K, ? extends V> map){
            throw new UnsupportedOperationException();
            // Original method
            /*
            {
            throw new UnsupportedOperationException();
        }
            */
        }
        
        @Override public V remove(Object key){
            throw new UnsupportedOperationException();
            // Original method
            /*
            {
            throw new UnsupportedOperationException();
        }
            */
        }
        
        @Override public int size(){
            return getTaintInt();

            // Original method
            /*
            {
            return m.size();
        }
            */
        }
        
        @Override public Collection<V> values(){
            return new UnmodifiableCollection<V>(m.values());  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return new UnmodifiableCollection<V>(m.values());
        }
            */
        }
        
        @Override public String toString(){
            return getTaintString();

            // Original method
            /*
            {
            return m.toString();
        }
            */
        }
    }
    
    
    private static class UnmodifiableSet<E> extends UnmodifiableCollection<E> implements Set<E> {
        
        private static final long serialVersionUID = -9215047833775013803L;
        
        UnmodifiableSet(Set<E> set){
            super(set);
        }
        
        @Override public boolean equals(Object object){
            return getTaintBoolean();

            // Original method
            /*
            {
            return c.equals(object);
        }
            */
        }
        
        @Override public int hashCode(){
            return getTaintInt();

            // Original method
            /*
            {
            return c.hashCode();
        }
            */
        }
    }
    
    
    private static class UnmodifiableSortedMap<K, V> extends UnmodifiableMap<K,V> implements SortedMap<K,V> {
        
        private static final long serialVersionUID = -8806743815996713206L;
        private final SortedMap<K, V> sm;
        
        UnmodifiableSortedMap(SortedMap<K, V> map){
            super(map);
            sm = map;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            /*
            sm = map;
            */
        }
        
        @Override public Comparator<? super K> comparator(){
            return sm.comparator();  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return sm.comparator();
        }
            */
        }
        
        @Override public K firstKey(){
            return sm.firstKey();  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return sm.firstKey();
        }
            */
        }
        
        @Override public SortedMap<K, V> headMap(K before){
            return new UnmodifiableSortedMap<K, V>(sm.headMap(before));  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return new UnmodifiableSortedMap<K, V>(sm.headMap(before));
        }
            */
        }
        
        @Override public K lastKey(){
            return sm.lastKey();  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return sm.lastKey();
        }
            */
        }
        
        @Override public SortedMap<K, V> subMap(K start, K end){
            return new UnmodifiableSortedMap<K, V>(sm.subMap(start, end));  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return new UnmodifiableSortedMap<K, V>(sm.subMap(start, end));
        }
            */
        }
        
        @Override public SortedMap<K, V> tailMap(K after){
            return new UnmodifiableSortedMap<K, V>(sm.tailMap(after));  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return new UnmodifiableSortedMap<K, V>(sm.tailMap(after));
        }
            */
        }
    }
    
    
    private static class UnmodifiableSortedSet<E> extends UnmodifiableSet<E> implements SortedSet<E> {
        
        private static final long serialVersionUID = -4929149591599911165L;
        private final SortedSet<E> ss;
        
        UnmodifiableSortedSet(SortedSet<E> set){
            super(set);
            ss = set;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            /*
            ss = set;
            */
        }
        
        @Override public Comparator<? super E> comparator(){
            return ss.comparator();  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return ss.comparator();
        }
            */
        }
        
        @Override public E first(){
            return ss.first();  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return ss.first();
        }
            */
        }
        
        @Override public SortedSet<E> headSet(E before){
            return new UnmodifiableSortedSet<E>(ss.headSet(before));  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return new UnmodifiableSortedSet<E>(ss.headSet(before));
        }
            */
        }
        
        @Override public E last(){
            return ss.last();  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return ss.last();
        }
            */
        }
        
        @Override public SortedSet<E> subSet(E start, E end){
            return new UnmodifiableSortedSet<E>(ss.subSet(start, end));  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return new UnmodifiableSortedSet<E>(ss.subSet(start, end));
        }
            */
        }
        
        @Override public SortedSet<E> tailSet(E after){
            return new UnmodifiableSortedSet<E>(ss.tailSet(after));  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return new UnmodifiableSortedSet<E>(ss.tailSet(after));
        }
            */
        }
    }
    
    
    private Collections(){
    }
    
    /*
    @SuppressWarnings("unchecked") public static <T> int binarySearch(List<? extends Comparable<? super T>> list, T object) {
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
    */
    
    /*
    @SuppressWarnings("unchecked") public static <T> int binarySearch(List<? extends T> list, T object,
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
    */
    
    public static <T> void copy(List<? super T> destination, List<? extends T> source) {
        if (destination.size() < source.size()) {
            //throw new IndexOutOfBoundsException("destination.size() < source.size(): " +
              //      destination.size() + " < " + source.size());
        }
        Iterator<? extends T> srcIt = source.iterator();
        ListIterator<? super T> destIt = destination.listIterator();
        while (srcIt.hasNext()) {
            try {
                destIt.next();
            } catch (NoSuchElementException e) {
                
                //throw new IndexOutOfBoundsException("Source size " + source.size() +
                 //       " does not fit into destination");
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
    
    @SuppressWarnings("unchecked") public static void reverse(List<?> list) {
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
    
    @SuppressWarnings("unchecked") public static <T> Comparator<T> reverseOrder() {
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
    
    @SuppressWarnings("unchecked") public static <T extends Comparable<? super T>> void sort(List<T> list) {
        Object[] array = list.toArray();
        Arrays.sort(array);
        int i = 0;
        ListIterator<T> it = list.listIterator();
        while (it.hasNext()) {
            it.next();
            it.set((T) array[i++]);
        }
    }
    
    @SuppressWarnings("unchecked") public static <T> void sort(List<T> list, Comparator<? super T> comparator) {
        T[] array = list.toArray((T[]) new Object[list.size()]);
        Arrays.sort(array, comparator);
        int i = 0;
        ListIterator<T> it = list.listIterator();
        while (it.hasNext()) {
            it.next();
            it.set(array[i++]);
        }
    }
    
    @SuppressWarnings("unchecked") public static void swap(List<?> list, int index1, int index2) {
        if (list == null) {
            //throw new NullPointerException();
        }
        final int size = list.size();
        if (index1 < 0 || index1 >= size || index2 < 0 || index2 >= size) {
            //throw new IndexOutOfBoundsException();
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
    
    @SuppressWarnings("unchecked") public static void rotate(List<?> lst, int dist) {
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
            //throw new NullPointerException();
        }
        return new SynchronizedCollection<T>(collection);
    }
    
    public static <T> List<T> synchronizedList(List<T> list) {
        if (list == null) {
            //throw new NullPointerException();
        }
        if (list instanceof RandomAccess) {
            return new SynchronizedRandomAccessList<T>(list);
        }
        return new SynchronizedList<T>(list);
    }
    
    public static <K, V> Map<K, V> synchronizedMap(Map<K, V> map) {
        if (map == null) {
            //throw new NullPointerException();
        }
        return new SynchronizedMap<K, V>(map);
    }
    
    public static <E> Set<E> synchronizedSet(Set<E> set) {
        if (set == null) {
            //throw new NullPointerException();
        }
        return new SynchronizedSet<E>(set);
    }
    
    public static <K, V> SortedMap<K, V> synchronizedSortedMap(
            SortedMap<K, V> map) {
        if (map == null) {
            //throw new NullPointerException();
        }
        return new SynchronizedSortedMap<K, V>(map);
    }
    
    public static <E> SortedSet<E> synchronizedSortedSet(SortedSet<E> set) {
        if (set == null) {
            //throw new NullPointerException();
        }
        return new SynchronizedSortedSet<E>(set);
    }
    
    @SuppressWarnings("unchecked") public static <E> Collection<E> unmodifiableCollection(
            Collection<? extends E> collection) {
        if (collection == null) {
            //throw new NullPointerException();
        }
        return new UnmodifiableCollection<E>((Collection<E>) collection);
    }
    
    @SuppressWarnings("unchecked") public static <E> List<E> unmodifiableList(List<? extends E> list) {
        if (list == null) {
            //throw new NullPointerException();
        }
        if (list instanceof RandomAccess) {
            return new UnmodifiableRandomAccessList<E>((List<E>) list);
        }
        return new UnmodifiableList<E>((List<E>) list);
    }
    
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked") public static <K, V> Map<K, V> unmodifiableMap(
            Map<? extends K, ? extends V> map) {
        return new UnmodifiableMap<K, V>((Map<K, V>) map);
    }
    
    @SuppressWarnings("unchecked") public static <E> Set<E> unmodifiableSet(Set<? extends E> set) {
        if (set == null) {
            //throw new NullPointerException();
        }
        return new UnmodifiableSet<E>((Set<E>) set);
    }
    
    @SuppressWarnings("unchecked") public static <K, V> SortedMap<K, V> unmodifiableSortedMap(
            SortedMap<K, ? extends V> map) {
        if (map == null) {
            //throw new NullPointerException();
        }
        return new UnmodifiableSortedMap<K, V>((SortedMap<K, V>) map);
    }
    
    public static <E> SortedSet<E> unmodifiableSortedSet(SortedSet<E> set) {
        if (set == null) {
            //throw new NullPointerException();
        }
        return new UnmodifiableSortedSet<E>(set);
    }
    
    public static int frequency(Collection<?> c, Object o) {
        if (c == null) {
            //throw new NullPointerException();
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
    
    /*
    @SuppressWarnings("unchecked") public static final <T> List<T> emptyList() {
        return EMPTY_LIST;
    }
    
    @SuppressWarnings("unchecked") public static final <T> Set<T> emptySet() {
        return EMPTY_SET;
    }
    
    @SuppressWarnings("unchecked") public static final <K, V> Map<K, V> emptyMap() {
        return EMPTY_MAP;
    }
    */
    
    /* 
    @SuppressWarnings("unchecked") public static <T> Enumeration<T> emptyEnumeration() {
        return (Enumeration<T>) EMPTY_ENUMERATION;
    }
    
    @SuppressWarnings("unchecked") public static <T> Iterator<T> emptyIterator() {
        return (Iterator<T>) EMPTY_ITERATOR;
    }
    
    public static <T> ListIterator<T> emptyListIterator() {
        return Collections.<T>emptyList().listIterator();
    }
    */
    
    public static <E> Collection<E> checkedCollection(Collection<E> c,
            Class<E> type) {
        return new CheckedCollection<E>(c, type);
    }
    
    /* DSFIXME
    public static <K, V> Map<K, V> checkedMap(Map<K, V> m, Class<K> keyType,
            Class<V> valueType) {
        return new CheckedMap<K, V>(m, keyType, valueType);
    }
    */
    
    public static <E> List<E> checkedList(List<E> list, Class<E> type) {
        if (list instanceof RandomAccess) {
            return new CheckedRandomAccessList<E>(list, type);
        }
        return new CheckedList<E>(list, type);
    }
    
    public static <E> Set<E> checkedSet(Set<E> s, Class<E> type) {
        return new CheckedSet<E>(s, type);
    }
    
    /* DSFIXME
    public static <K, V> SortedMap<K, V> checkedSortedMap(SortedMap<K, V> m,
            Class<K> keyType, Class<V> valueType) {
        return new CheckedSortedMap<K, V>(m, keyType, valueType);
    }
    
    public static <E> SortedSet<E> checkedSortedSet(SortedSet<E> s,
            Class<E> type) {
        return new CheckedSortedSet<E>(s, type);
    }
    */
    
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
    	/*
        if (obj != null && !type.isInstance(obj)) {
            throw new ClassCastException("Attempt to insert element of type " + obj.getClass() +
                    " into collection of type " + type);
        }
        */
        return obj;
    }
    
    public static <E> Set<E> newSetFromMap(Map<E, Boolean> map) {
        return new SetFromMap<E>(map);
        //throw new IllegalArgumentException();
    }
    
    public static <T> Queue<T> asLifoQueue(Deque<T> deque) {
        return new AsLIFOQueue<T>(deque);
    }
    
    private static class SetFromMap <E> extends AbstractSet<E> implements Serializable {
        
        private static final long serialVersionUID = 2454657854757543876L;
        private Map<E, Boolean> m;
        private transient Set<E> backingSet;
        
        SetFromMap(final Map<E, Boolean> map){
            m = map;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            /*
            m = map;
            backingSet = map.keySet();
            */
        }
        
        @Override public boolean equals(Object object){
            return getTaintBoolean();

            // Original method
            /*
            {
            return backingSet.equals(object);
        }
            */
        }
        
        @Override public int hashCode(){
            return getTaintInt();

            // Original method
            /*
            {
            return backingSet.hashCode();
        }
            */
        }
        
        @Override public boolean add(E object){
            return getTaintBoolean();

            // Original method
            /*
            {
            return m.put(object, Boolean.TRUE) == null;
        }
            */
        }
        
        @Override public void clear(){
            m.clear();
            // Original method
            /*
            {
            m.clear();
        }
            */
        }
        
        @Override public String toString(){
            return getTaintString();

            // Original method
            /*
            {
            return backingSet.toString();
        }
            */
        }
        
        @Override public boolean contains(Object object){
            return getTaintBoolean();

            // Original method
            /*
            {
            return backingSet.contains(object);
        }
            */
        }
        
        @Override public boolean containsAll(Collection<?> collection){
            return getTaintBoolean();

            // Original method
            /*
            {
            return backingSet.containsAll(collection);
        }
            */
        }
        
        @Override public boolean isEmpty(){
            return getTaintBoolean();

            // Original method
            /*
            {
            return m.isEmpty();
        }
            */
        }
        
        @Override public boolean remove(Object object){
            return getTaintBoolean();

            // Original method
            /*
            {
            return m.remove(object) != null;
        }
            */
        }
        
        @Override public boolean retainAll(Collection<?> collection){
            return getTaintBoolean();

            // Original method
            /*
            {
            return backingSet.retainAll(collection);
        }
            */
        }
        
        @Override public Object[] toArray(){
            return backingSet.toArray();  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return backingSet.toArray();
        }
            */
        }
        
        @Override public <T> T[] toArray(T[] contents){
            return backingSet.toArray(contents);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return backingSet.toArray(contents);
        }
            */
        }
        
        @Override public Iterator<E> iterator(){
            return backingSet.iterator();  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return backingSet.iterator();
        }
            */
        }
        
        @Override public int size(){
            return getTaintInt();

            // Original method
            /*
            {
            return m.size();
        }
            */
        }
        
        @SuppressWarnings("unchecked") private void readObject(ObjectInputStream stream){
            //stream.defaultReadObject();
            // Original method
            /*
            {
            stream.defaultReadObject();
            backingSet = m.keySet();
        }
            */
        }
    }
    
    
    private static class AsLIFOQueue <E> extends AbstractQueue<E> implements Serializable {
        
        private static final long serialVersionUID = 1802017725587941708L;
        private final Deque<E> q;
        
        AsLIFOQueue(final Deque<E> deque){
            this.q = deque;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            /*
            this.q = deque;
            */
        }
        
        @Override public Iterator<E> iterator(){
            return q.iterator();  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return q.iterator();
        }
            */
        }
        
        @Override public int size(){
            return getTaintInt();

            // Original method
            /*
            {
            return q.size();
        }
            */
        }
        
        @Override public boolean offer(E o){
            return getTaintBoolean();

            // Original method
            /*
            {
            return q.offerFirst(o);
        }
            */
        }
        
        @Override public E peek(){
            return q.peekFirst();  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return q.peekFirst();
        }
            */
        }
        
        @Override public E poll(){
            return q.pollFirst();  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return q.pollFirst();
        }
            */
        }
        
        @Override public boolean add(E o){
            q.push(o);
            return getTaintBoolean();

            // Original method
            /*
            {
            q.push(o);
            return true;
        }
            */
        }
        
        @Override public void clear(){
            q.clear();
            // Original method
            /*
            {
            q.clear();
        }
            */
        }
        
        @Override public E element(){
            return q.getFirst();  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return q.getFirst();
        }
            */
        }
        
        @Override public E remove(){
            return q.pop();  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return q.pop();
        }
            */
        }
        
        @Override public boolean contains(Object object){
            return getTaintBoolean();

            // Original method
            /*
            {
            return q.contains(object);
        }
            */
        }
        
        @Override public boolean containsAll(Collection<?> collection){
            return getTaintBoolean();

            // Original method
            /*
            {
            return q.containsAll(collection);
        }
            */
        }
        
        @Override public boolean isEmpty(){
            return getTaintBoolean();

            // Original method
            /*
            {
            return q.isEmpty();
        }
            */
        }
        
        @Override public boolean remove(Object object){
            return getTaintBoolean();

            // Original method
            /*
            {
            return q.remove(object);
        }
            */
        }
        
        @Override public boolean removeAll(Collection<?> collection){
            return getTaintBoolean();

            // Original method
            /*
            {
            return q.removeAll(collection);
        }
            */
        }
        
        @Override public boolean retainAll(Collection<?> collection){
            return getTaintBoolean();

            // Original method
            /*
            {
            return q.retainAll(collection);
        }
            */
        }
        
        @Override public Object[] toArray(){
            return q.toArray();  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return q.toArray();
        }
            */
        }
        
        @Override public <T> T[] toArray(T[] contents){
            return q.toArray(contents);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return q.toArray(contents);
        }
            */
        }
        
        @Override public String toString(){
            return getTaintString();

            // Original method
            /*
            {
            return q.toString();
        }
            */
        }
    }
    
    
    private static class CheckedCollection <E> implements Collection<E>, Serializable {
        
        private static final long serialVersionUID = 1578914078182001775L;
        Collection<E> c;
        Class<E> type;
        
        public CheckedCollection(Collection<E> c, Class<E> type){
            //throw new NullPointerException();
            this.c = c;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            this.type = type;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            /*
            if (c == null || type == null) {
                throw new NullPointerException();
            }
            this.c = c;
            this.type = type;
            */
        }
        
        @Override public int size(){
            return getTaintInt();

            // Original method
            /*
            {
            return c.size();
        }
            */
        }
        
        @Override public boolean isEmpty(){
            return getTaintBoolean();

            // Original method
            /*
            {
            return c.isEmpty();
        }
            */
        }
        
        @Override public boolean contains(Object obj){
            return getTaintBoolean();

            // Original method
            /*
            {
            return c.contains(obj);
        }
            */
        }
        
        @Override public Iterator<E> iterator(){
            //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
            //Iterator<E> i = c.iterator();
            return (Iterator);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            Iterator<E> i = c.iterator();
            if (i instanceof ListIterator) {
                i = new CheckedListIterator<E>((ListIterator<E>) i, type);
            }
            return i;
        }
            */
        }
        
        @Override public Object[] toArray(){
            return c.toArray();  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return c.toArray();
        }
            */
        }
        
        @Override public <T> T[] toArray(T[] arr){
            return c.toArray(arr);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return c.toArray(arr);
        }
            */
        }
        
        @Override public boolean add(E obj){
            return getTaintBoolean();

            // Original method
            /*
            {
            return c.add(checkType(obj, type));
        }
            */
        }
        
        @Override public boolean remove(Object obj){
            return getTaintBoolean();

            // Original method
            /*
            {
            return c.remove(obj);
        }
            */
        }
        
        @Override public boolean containsAll(Collection<?> c1){
            return getTaintBoolean();

            // Original method
            /*
            {
            return c.containsAll(c1);
        }
            */
        }
        
        @SuppressWarnings("unchecked") @Override public boolean addAll(Collection<? extends E> c1){
            //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
            //Object[] array = c1.toArray();
            //checkType(o, type);
            return getTaintBoolean();

            // Original method
            /*
            {
            Object[] array = c1.toArray();
            for (Object o : array) {
                checkType(o, type);
            }
            return c.addAll((List<E>) Arrays.asList(array));
        }
            */
        }
        
        @Override public boolean removeAll(Collection<?> c1){
            return getTaintBoolean();

            // Original method
            /*
            {
            return c.removeAll(c1);
        }
            */
        }
        
        @Override public boolean retainAll(Collection<?> c1){
            return getTaintBoolean();

            // Original method
            /*
            {
            return c.retainAll(c1);
        }
            */
        }
        
        @Override public void clear(){
            c.clear();
            // Original method
            /*
            {
            c.clear();
        }
            */
        }
        
        @Override public String toString(){
            return getTaintString();

            // Original method
            /*
            {
            return c.toString();
        }
            */
        }
    }
    
    
    private static class CheckedListIterator <E> implements ListIterator<E> {
        
        private ListIterator<E> i;
        private Class<E> type;
        
        public CheckedListIterator(ListIterator<E> i, Class<E> type){
            this.i = i;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            this.type = type;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            /*
            this.i = i;
            this.type = type;
            */
        }
        
        @Override public boolean hasNext(){
            return getTaintBoolean();

            // Original method
            /*
            {
            return i.hasNext();
        }
            */
        }
        
        @Override public E next(){
            return i.next();  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return i.next();
        }
            */
        }
        
        @Override public void remove(){
            i.remove();
            // Original method
            /*
            {
            i.remove();
        }
            */
        }
        
        @Override public boolean hasPrevious(){
            return getTaintBoolean();

            // Original method
            /*
            {
            return i.hasPrevious();
        }
            */
        }
        
        @Override public E previous(){
            return i.previous();  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return i.previous();
        }
            */
        }
        
        @Override public int nextIndex(){
            return getTaintInt();

            // Original method
            /*
            {
            return i.nextIndex();
        }
            */
        }
        
        @Override public int previousIndex(){
            return getTaintInt();

            // Original method
            /*
            {
            return i.previousIndex();
        }
            */
        }
        
        @Override public void set(E obj){
            i.set(checkType(obj, type));
            // Original method
            /*
            {
            i.set(checkType(obj, type));
        }
            */
        }
        
        @Override public void add(E obj){
            i.add(checkType(obj, type));
            // Original method
            /*
            {
            i.add(checkType(obj, type));
        }
            */
        }
    }
    
    
    private static class CheckedList <E> extends CheckedCollection<E> implements List<E> {
        
        private static final long serialVersionUID = 65247728283967356L;
        List<E> l;
        
        public CheckedList(List<E> l, Class<E> type){
            super(l, type);
            this.l = l;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            /*
            this.l = l;
            */
        }
        
        @SuppressWarnings("unchecked") @Override public boolean addAll(int index, Collection<? extends E> c1){
            //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
            //Object[] array = c1.toArray();
            //checkType(o, type);
            return getTaintBoolean();

            // Original method
            /*
            {
            Object[] array = c1.toArray();
            for (Object o : array) {
                checkType(o, type);
            }
            return l.addAll(index, (List<E>) Arrays.asList(array));
        }
            */
        }
        
        @Override public E get(int index){
            return l.get(index);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return l.get(index);
        }
            */
        }
        
        @Override public E set(int index, E obj){
            return l.set(index, checkType(obj, type));  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return l.set(index, checkType(obj, type));
        }
            */
        }
        
        @Override public void add(int index, E obj){
            l.add(index, checkType(obj, type));
            // Original method
            /*
            {
            l.add(index, checkType(obj, type));
        }
            */
        }
        
        @Override public E remove(int index){
            return l.remove(index);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return l.remove(index);
        }
            */
        }
        
        @Override public int indexOf(Object obj){
            return getTaintInt();

            // Original method
            /*
            {
            return l.indexOf(obj);
        }
            */
        }
        
        @Override public int lastIndexOf(Object obj){
            return getTaintInt();

            // Original method
            /*
            {
            return l.lastIndexOf(obj);
        }
            */
        }
        
        @Override public ListIterator<E> listIterator(){
            return new CheckedListIterator<E>(l.listIterator(), type);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return new CheckedListIterator<E>(l.listIterator(), type);
        }
            */
        }
        
        @Override public ListIterator<E> listIterator(int index){
            return new CheckedListIterator<E>(l.listIterator(index), type);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return new CheckedListIterator<E>(l.listIterator(index), type);
        }
            */
        }
        
        @Override public List<E> subList(int fromIndex, int toIndex){
            return checkedList(l.subList(fromIndex, toIndex), type);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return checkedList(l.subList(fromIndex, toIndex), type);
        }
            */
        }
        
        @Override public boolean equals(Object obj){
            return getTaintBoolean();

            // Original method
            /*
            {
            return l.equals(obj);
        }
            */
        }
        
        @Override public int hashCode(){
            return getTaintInt();

            // Original method
            /*
            {
            return l.hashCode();
        }
            */
        }
    }
    
    
    private static class CheckedRandomAccessList <E> extends CheckedList<E> implements RandomAccess {
        
        private static final long serialVersionUID = 1638200125423088369L;
        
        public CheckedRandomAccessList(List<E> l, Class<E> type){
            super(l, type);
        }
    }
    
    
    private static class CheckedSet <E> extends CheckedCollection<E> implements Set<E> {
        
        private static final long serialVersionUID = 4694047833775013803L;
        
        public CheckedSet(Set<E> s, Class<E> type){
            super(s, type);
        }
        
        @Override public boolean equals(Object obj){
            return getTaintBoolean();

            // Original method
            /*
            {
            return c.equals(obj);
        }
            */
        }
        
        @Override public int hashCode(){
            return getTaintInt();

            // Original method
            /*
            {
            return c.hashCode();
        }
            */
        }
    }
    
    
    /* DSFIXME
    private static class CheckedMap <K, V> implements Map<K,V>, Serializable {
        
        private static final long serialVersionUID = 5742860141034234728L;
        Map<K, V> m;
        Class<K> keyType;
        Class<V> valueType;
        
        private CheckedMap(Map<K, V> m, Class<K> keyType, Class<V> valueType){
            //throw new NullPointerException();
            this.m = m;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            this.keyType = keyType;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            this.valueType = valueType;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            if (m == null || keyType == null || valueType == null) {
                throw new NullPointerException();
            }
            this.m = m;
            this.keyType = keyType;
            this.valueType = valueType;
        }
        
        @Override public int size(){
            return getTaintInt();

            // Original method
            return m.size();
        }
        
        @Override public boolean isEmpty(){
            return getTaintBoolean();

            // Original method
            return m.isEmpty();
        }
        
        @Override public boolean containsKey(Object key){
            return getTaintBoolean();

            // Original method
            return m.containsKey(key);
        }
        
        @Override public boolean containsValue(Object value){
            return getTaintBoolean();

            // Original method
            return m.containsValue(value);
        }
        
        @Override public V get(Object key){
            return m.get(key);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            return m.get(key);
        }
        
        @Override public V put(K key, V value){
            return m.put(checkType(key, keyType), checkType(value, valueType));  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            return m.put(checkType(key, keyType), checkType(value, valueType));
        }
        
        @Override public V remove(Object key){
            return m.remove(key);  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            return m.remove(key);
        }
        
        @SuppressWarnings("unchecked") @Override public void putAll(Map<? extends K, ? extends V> map){
            //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
            //int size = map.size();
            //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
            //Map.Entry<? extends K, ? extends V>[] entries = new Map.Entry[size];
            //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
            //Iterator<? extends Map.Entry<? extends K, ? extends V>> it = map .entrySet().iterator();
            //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
            //Map.Entry<? extends K, ? extends V> e = it.next();
            //checkType(e.getKey(), keyType);
            //checkType(e.getValue(), valueType);
            //m.put(entries[i].getKey(), entries[i].getValue());
        	//addTaint(map.getTaint());
            // Original method
        @Override public K lastKey(){
            return sm.lastKey();  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            return sm.lastKey();
        }
    }
    */
    
}

