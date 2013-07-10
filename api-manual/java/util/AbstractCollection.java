package java.util;

import java.lang.reflect.Array;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public abstract class AbstractCollection<E> implements Collection<E> {
	
	@DSModeled(DSC.SAFE)
	protected AbstractCollection() {
    }
	
	public boolean removeAll(Collection<?> collection) {
        boolean result = false;
        Iterator<?> it = iterator();
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                result = true;
            }
        }
        return result;
	}
	
	public boolean retainAll(Collection<?> collection) {
        boolean result = false;
        Iterator<?> it = iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                result = true;
            }
        }
        return result;
    }
	
	public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }
	
	public boolean remove(Object object) {
        Iterator<?> it = iterator();
        if (object != null) {
            while (it.hasNext()) {
                if (object.equals(it.next())) {
                    it.remove();
                    return true;
                }
            }
        } else {
            while (it.hasNext()) {
                if (it.next() == null) {
                    it.remove();
                    return true;
                }
            }
        }
        return false;
    }
	
	public Object[] toArray() {
        int size = size(), index = 0;
        Iterator<?> it = iterator();
        Object[] array = new Object[size];
        while (index < size) {
            array[index++] = it.next();
        }
        return array;
    }
	
	@SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] contents) {
        int size = size(), index = 0;
        if (size > contents.length) {
            Class<?> ct = contents.getClass().getComponentType();
            contents = (T[]) Array.newInstance(ct, size);
        }
        for (E entry : this) {
            contents[index++] = (T) entry;
        }
        if (index < contents.length) {
            contents[index] = null;
        }
        return contents;
    }
	
	public boolean isEmpty() {
        return size() == 0;
    }
	
	@Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        
        StringBuilder buffer = new StringBuilder(size() * 16);
        buffer.append('[');
        Iterator<?> it = iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next != this) {
                buffer.append(next);
            } else {
                buffer.append("(this Collection)");
            }
            if (it.hasNext()) {
                buffer.append(", ");
            }
        }
        buffer.append(']');
        return buffer.toString();
    }
	
	public boolean contains(Object object) {
        Iterator<E> it = iterator();
        if (object != null) {
            while (it.hasNext()) {
                if (object.equals(it.next())) {
                    return true;
                }
            }
        } else {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return true;
                }
            }
        }
        return false;
    }
	
	public boolean addAll(Collection<? extends E> collection) {
        boolean result = false;
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            if (add(it.next())) {
                result = true;
            }
        }
        return result;
    }
    
	public void clear() {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }
	
	public boolean add(E object) {
        throw new UnsupportedOperationException();
    }
	
	public abstract Iterator<E> iterator();
	public abstract int size();
}
