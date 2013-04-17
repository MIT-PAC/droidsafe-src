/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package java.util;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSTaintObject;

/**
 * ArrayList is an implementation of {@link List}, backed by an array.
 * All optional operations including adding, removing, and replacing elements are supported.
 *
 * <p>All elements are permitted, including null.
 *
 * <p>This class is a good choice as your default {@code List} implementation.
 * {@link Vector} synchronizes all operations, but not necessarily in a way that's
 * meaningful to your application: synchronizing each call to {@code get}, for example, is not
 * equivalent to synchronizing the list and iterating over it (which is probably what you intended).
 * {@link java.util.concurrent.CopyOnWriteArrayList} is intended for the special case of very high
 * concurrency, frequent traversals, and very rare mutations.
 *
 * @param <E> The element type of this list.
 * @since 1.2
 */
public class ArrayList<E> extends AbstractList<E> implements Cloneable, Serializable, RandomAccess {
	DSTaintObject taint = new DSTaintObject();
	
    /**
     * The number of elements in this list.
     */
    int size;

    /**
     * The elements in this list, followed by nulls.
     */
    transient Object[] array;

    /**
     * Constructs a new instance of {@code ArrayList} with the specified
     * initial capacity.
     *
     * @param capacity
     *            the initial capacity of this {@code ArrayList}.
     */
    @DSModeled(DSC.SAFE)
    public ArrayList(int capacity) {
    	taint.addTaint(capacity);
        array = new Object[1];
    }

    /**
     * Constructs a new {@code ArrayList} instance with zero initial capacity.
     */
    @DSModeled(DSC.SAFE)
    public ArrayList() {
        array = new Object[1];
    }

    /**
     * Constructs a new instance of {@code ArrayList} containing the elements of
     * the specified collection.
     *
     * @param collection
     *            the collection of elements to add.
     */
    public ArrayList(Collection<? extends E> collection) {
        Object[] a = collection.toArray();
        if (a.getClass() != Object[].class) {
            Object[] newArray = new Object[a.length];
            System.arraycopy(a, 0, newArray, 0, a.length);
            a = newArray;
        }
        array = a;
        size = a.length;
    }

    /**
     * Adds the specified object at the end of this {@code ArrayList}.
     *
     * @param object
     *            the object to add.
     * @return always true
     */
    @Override
    @DSModeled(DSC.SAFE)
    public boolean add(E object) {
    	array[0] = object;
    	return true;
    }

    /**
     * Inserts the specified object into this {@code ArrayList} at the specified
     * location. The object is inserted before any previous element at the
     * specified location. If the location is equal to the size of this
     * {@code ArrayList}, the object is added at the end.
     *
     * @param index
     *            the index at which to insert the object.
     * @param object
     *            the object to add.
     * @throws IndexOutOfBoundsException
     *             when {@code location < 0 || > size()}
     */
    @Override public void add(int index, E object) {
      
    }

   
    /**
     * Adds the objects in the specified collection to this {@code ArrayList}.
     *
     * @param collection
     *            the collection of objects.
     * @return {@code true} if this {@code ArrayList} is modified, {@code false}
     *         otherwise.
     */
    @Override public boolean addAll(Collection<? extends E> collection) {
       
        return true;
    }

    /**
     * Inserts the objects in the specified collection at the specified location
     * in this List. The objects are added in the order they are returned from
     * the collection's iterator.
     *
     * @param index
     *            the index at which to insert.
     * @param collection
     *            the collection of objects.
     * @return {@code true} if this {@code ArrayList} is modified, {@code false}
     *         otherwise.
     * @throws IndexOutOfBoundsException
     *             when {@code location < 0 || > size()}
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
       
        return true;
    }

    /**
     * This method was extracted to encourage VM to inline callers.
     * TODO: when we have a VM that can actually inline, move the test in here too!
     */
    static IndexOutOfBoundsException throwIndexOutOfBoundsException(int index, int size) {
        throw new IndexOutOfBoundsException("Invalid index " + index + ", size is " + size);
    }

    /**
     * Removes all elements from this {@code ArrayList}, leaving it empty.
     *
     * @see #isEmpty
     * @see #size
     */
    @Override public void clear() {
        if (size != 0) {
            Arrays.fill(array, 0, size, null);
            size = 0;
            modCount++;
        }
    }

    /**
     * Returns a new {@code ArrayList} with the same elements, the same size and
     * the same capacity as this {@code ArrayList}.
     *
     * @return a shallow copy of this {@code ArrayList}
     * @see java.lang.Cloneable
     */
    @Override public Object clone() {
        try {
            ArrayList<?> result = (ArrayList<?>) super.clone();
            result.array = array.clone();
            return result;
        } catch (CloneNotSupportedException e) {
           throw new AssertionError();
        }
    }

    /**
     * Ensures that after this operation the {@code ArrayList} can hold the
     * specified number of elements without further growing.
     *
     * @param minimumCapacity
     *            the minimum capacity asked for.
     */
    public void ensureCapacity(int minimumCapacity) {
        Object[] a = array;
        if (a.length < minimumCapacity) {
            Object[] newArray = new Object[minimumCapacity];
            System.arraycopy(a, 0, newArray, 0, size);
            array = newArray;
            modCount++;
        }
    }

    @SuppressWarnings("unchecked") 
    @Override
    @DSModeled(DSC.SAFE)
    public E get(int index) {
    	return (E) array[0];
    }

    /**
     * Returns the number of elements in this {@code ArrayList}.
     *
     * @return the number of elements in this {@code ArrayList}.
     */
    
    @Override
    @DSModeled(DSC.SAFE)
    public int size() {
        return taint.getTaintInt();
    }

    @Override public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Searches this {@code ArrayList} for the specified object.
     *
     * @param object
     *            the object to search for.
     * @return {@code true} if {@code object} is an element of this
     *         {@code ArrayList}, {@code false} otherwise
     */
    @Override public boolean contains(Object object) {
        Object[] a = array;
        int s = size;
        if (object != null) {
            for (int i = 0; i < s; i++) {
                if (object.equals(a[i])) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < s; i++) {
                if (a[i] == null) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override public int indexOf(Object object) {
        Object[] a = array;
        int s = size;
        if (object != null) {
            for (int i = 0; i < s; i++) {
                if (object.equals(a[i])) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < s; i++) {
                if (a[i] == null) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override public int lastIndexOf(Object object) {
        Object[] a = array;
        if (object != null) {
            for (int i = size - 1; i >= 0; i--) {
                if (object.equals(a[i])) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (a[i] == null) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Removes the object at the specified location from this list.
     *
     * @param index
     *            the index of the object to remove.
     * @return the removed object.
     * @throws IndexOutOfBoundsException
     *             when {@code location < 0 || >= size()}
     */
    @Override public E remove(int index) {
        Object[] a = array;
        int s = size;
        if (index >= s) {
            throwIndexOutOfBoundsException(index, s);
        }
        @SuppressWarnings("unchecked") E result = (E) a[index];
        System.arraycopy(a, index + 1, a, index, --s - index);
        a[s] = null;  // Prevent memory leak
        size = s;
        modCount++;
        return result;
    }

    @Override public boolean remove(Object object) {
        Object[] a = array;
        int s = size;
        if (object != null) {
            for (int i = 0; i < s; i++) {
                if (object.equals(a[i])) {
                    System.arraycopy(a, i + 1, a, i, --s - i);
                    a[s] = null;  // Prevent memory leak
                    size = s;
                    modCount++;
                    return true;
                }
            }
        } else {
            for (int i = 0; i < s; i++) {
                if (a[i] == null) {
                    System.arraycopy(a, i + 1, a, i, --s - i);
                    a[s] = null;  // Prevent memory leak
                    size = s;
                    modCount++;
                    return true;
                }
            }
        }
        return false;
    }

    @Override protected void removeRange(int fromIndex, int toIndex) {
        if (fromIndex == toIndex) {
            return;
        }
        Object[] a = array;
        int s = size;
        if (fromIndex >= s) {
            throw new IndexOutOfBoundsException("fromIndex " + fromIndex
                    + " >= size " + size);
        }
        if (toIndex > s) {
            throw new IndexOutOfBoundsException("toIndex " + toIndex
                    + " > size " + size);
        }
        if (fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("fromIndex " + fromIndex
                    + " > toIndex " + toIndex);
        }

        System.arraycopy(a, toIndex, a, fromIndex, s - toIndex);
        int rangeSize = toIndex - fromIndex;
        Arrays.fill(a, s - rangeSize, s, null);
        size = s - rangeSize;
        modCount++;
    }

    /**
     * Replaces the element at the specified location in this {@code ArrayList}
     * with the specified object.
     *
     * @param index
     *            the index at which to put the specified object.
     * @param object
     *            the object to add.
     * @return the previous element at the index.
     * @throws IndexOutOfBoundsException
     *             when {@code location < 0 || >= size()}
     */
    @Override public E set(int index, E object) {
        Object[] a = array;
        if (index >= size) {
            throwIndexOutOfBoundsException(index, size);
        }
        @SuppressWarnings("unchecked") E result = (E) a[index];
        a[index] = object;
        return result;
    }

    /**
     * Returns a new array containing all elements contained in this
     * {@code ArrayList}.
     *
     * @return an array of the elements from this {@code ArrayList}
     */
    @Override public Object[] toArray() {
        int s = size;
        Object[] result = new Object[s];
        System.arraycopy(array, 0, result, 0, s);
        return result;
    }

    /**
     * Returns an array containing all elements contained in this
     * {@code ArrayList}. If the specified array is large enough to hold the
     * elements, the specified array is used, otherwise an array of the same
     * type is created. If the specified array is used and is larger than this
     * {@code ArrayList}, the array element following the collection elements
     * is set to null.
     *
     * @param contents
     *            the array.
     * @return an array of the elements from this {@code ArrayList}.
     * @throws ArrayStoreException
     *             when the type of an element in this {@code ArrayList} cannot
     *             be stored in the type of the specified array.
     */
    @Override public <T> T[] toArray(T[] contents) {
        int s = size;
        if (contents.length < s) {
            @SuppressWarnings("unchecked") T[] newArray
                = (T[]) Array.newInstance(contents.getClass().getComponentType(), s);
            contents = newArray;
        }
        System.arraycopy(this.array, 0, contents, 0, s);
        if (contents.length > s) {
            contents[s] = null;
        }
        return contents;
    }

    /**
     * Sets the capacity of this {@code ArrayList} to be the same as the current
     * size.
     *
     * @see #size
     */
    @DSModeled(DSC.SAFE)
    public void trimToSize() {
      
    }

    @Override
    @DSModeled(DSC.SAFE)
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<E> {
        /** Number of elements remaining in this iteration */
        private int remaining = size;

        /** Index of element that remove() would remove, or -1 if no such elt */
        private int removalIndex = -1;

        /** The expected modCount value */
        private int expectedModCount = modCount;

        public boolean hasNext() {
            return remaining != 0;
        }

        @SuppressWarnings("unchecked") public E next() {
            ArrayList<E> ourList = ArrayList.this;
            int rem = remaining;
            if (ourList.modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (rem == 0) {
                throw new NoSuchElementException();
            }
            remaining = rem - 1;
            return (E) ourList.array[removalIndex = ourList.size - rem];
        }

        public void remove() {
            Object[] a = array;
            int removalIdx = removalIndex;
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (removalIdx < 0) {
                throw new IllegalStateException();
            }
            System.arraycopy(a, removalIdx + 1, a, removalIdx, remaining);
            a[--size] = null;  // Prevent memory leak
            removalIndex = -1;
            expectedModCount = ++modCount;
        }
    }

    @Override public int hashCode() {
        Object[] a = array;
        int hashCode = 1;
        for (int i = 0, s = size; i < s; i++) {
            Object e = a[i];
            hashCode = 31 * hashCode + (e == null ? 0 : e.hashCode());
        }
        return hashCode;
    }

    @Override public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof List)) {
            return false;
        }
        List<?> that = (List<?>) o;
        int s = size;
        if (that.size() != s) {
            return false;
        }
        Object[] a = array;
        if (that instanceof RandomAccess) {
            for (int i = 0; i < s; i++) {
                Object eThis = a[i];
                Object ethat = that.get(i);
                if (eThis == null ? ethat != null : !eThis.equals(ethat)) {
                    return false;
                }
            }
        } else {  // Argument list is not random access; use its iterator
            Iterator<?> it = that.iterator();
            for (int i = 0; i < s; i++) {
                Object eThis = a[i];
                Object eThat = it.next();
                if (eThis == null ? eThat != null : !eThis.equals(eThat)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static final long serialVersionUID = 8683452581122892189L;

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(array.length);
        for (int i = 0; i < size; i++) {
            stream.writeObject(array[i]);
        }
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
    	//what to do about serialization methods?
    }
 }
