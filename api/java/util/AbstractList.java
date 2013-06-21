package java.util;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E> {
    protected transient int modCount;
	
    private int pos = -1; // Was package
    private int expectedModCount;   // Was package
    private int lastPosition = -1;   // Was package
	
    @DSModeled(DSC.SAFE)
	protected AbstractList() {
    }
	
    @Override
        public void clear() {
        removeRange(0, size());
    }
	
    public E set(int location, E object) {
        throw new UnsupportedOperationException();
    }
	
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }
	
    public ListIterator<E> listIterator(int location) {
        return listIterator(0);
    }
	
    protected void removeRange(int start, int end) {
        Iterator<?> it = listIterator(start);
        for (int i = start; i < end; i++) {
            it.next();
            it.remove();
        }
    }
	
    @DSModeled(DSC.SAFE)
	public List<E> subList(int start, int end) {
        return new ArrayList();
    }
	
    public int indexOf(Object object) {
        ListIterator<?> it = listIterator();
        if (object != null) {
            while (it.hasNext()) {
                if (object.equals(it.next())) {
                    return it.previousIndex();
                }
            }
        } else {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return it.previousIndex();
                }
            }
        }
        return -1;
    }
	
    public int lastIndexOf(Object object) {
        ListIterator<?> it = listIterator(size());
        if (object != null) {
            while (it.hasPrevious()) {
                if (object.equals(it.previous())) {
                    return it.nextIndex();
                }
            }
        } else {
            while (it.hasPrevious()) {
                if (it.previous() == null) {
                    return it.nextIndex();
                }
            }
        }
        return -1;
    }
	
    public boolean addAll(int location, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            add(location++, it.next());
        }
        return !collection.isEmpty();
    }
	
    @DSModeled(DSC.SAFE)
	public boolean add(E object) {
        addTaint(object);
        return getTaintBoolean();
    }
	
    @DSModeled(DSC.SAFE)
	public void add(int location, E object) {
        throw new UnsupportedOperationException();
    }
    
    @DSModeled(DSC.SAFE)
	public Iterator<E> iterator() {
        Itr itr = new Itr();
        itr.addTaint(this.getTaint());
        return (Iterator<E>) itr;
     }
	
    @DSModeled(DSC.SAFE)
	public E remove(int location) {
        throw new UnsupportedOperationException();
    }
    // ---------------- Inner Classes --------------------

}
