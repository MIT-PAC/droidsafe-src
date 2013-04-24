package java.util;

import java.io.Serializable;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSTaintObject;


public class ArrayList<E> extends AbstractList<E> implements Cloneable, Serializable, RandomAccess {
	DSTaintObject taint = new DSTaintObject();
	
    /**
     * The elements in this list, followed by nulls.
     */
    transient Object[] array;

    @DSModeled(DSC.SAFE)
    public ArrayList(int capacity) {
    	taint.addTaint(capacity);
        array = new Object[1];
    }

    @DSModeled(DSC.SAFE)
    public ArrayList() {
        array = new Object[1];
    }

    @Override
    @DSModeled(DSC.SAFE)
    public boolean add(E object) {
    	array[0] = object;
    	return true;
    }

    @Override public void add(int index, E object) {
      
    }

   
    @Override public boolean addAll(Collection<? extends E> collection) {
       
        return true;
    }

    @SuppressWarnings("unchecked") 
    @Override
    @DSModeled(DSC.SAFE)
    public E get(int index) {
    	return (E) array[0];
    }

    @Override
    @DSModeled(DSC.SAFE)
    public int size() {
        return taint.getTaintInt();
    }

    @DSModeled(DSC.SAFE)
    public void trimToSize() {
      
    }

    @Override
    @DSModeled(DSC.SAFE)
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<E> {
    	@DSModeled(DSC.SAFE)
    	private ArrayListIterator() { }
    	
    	@DSModeled(DSC.SAFE)
    	private ArrayListIterator(ArrayList l) {
    		ArrayList.this.taint.addTaint(l);
    	}
    	
        @DSModeled(DSC.SAFE)
        public boolean hasNext() {
        	/*
            return remaining != 0;
            */
        	return true;
        }

        @DSModeled(DSC.SAFE)
        @SuppressWarnings("unchecked") public E next() {
        	/*
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
            */
        	return ArrayList.this.get(0);
        }

        @DSModeled(DSC.SAFE)
        public void remove() {
        	/*
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
            */
        }
    }
    
    @DSModeled(DSC.SAFE)
    public E remove(int index) {
    	taint.addTaint(index);
    	/*
        rangeCheck(index);

        modCount++;
        E oldValue = elementData(index);

        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                             numMoved);
        elementData[--size] = null; // Let gc do its work

        return oldValue;
        */
    	return this.get(0);
    }

    private static final long serialVersionUID = 8683452581122892189L;
 }
