package java.util;

import droidsafe.annotations.*;
import droidsafe.helpers.*;

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
	        return new FullListIterator(location);
	    }
	
	protected void removeRange(int start, int end) {
        Iterator<?> it = listIterator(start);
        for (int i = start; i < end; i++) {
            it.next();
            it.remove();
        }
    }
	
	public List<E> subList(int start, int end) {
        if (start >= 0 && end <= size()) {
            if (start <= end) {
                if (this instanceof RandomAccess) {
                    return new SubAbstractListRandomAccess<E>(this, start, end);
                }
                return new SubAbstractList<E>(this, start, end);
            }
            throw new IllegalArgumentException();
        }
        throw new IndexOutOfBoundsException();
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
	
	// ---------------- Inner Classes --------------------
	
	private static final class SubAbstractListRandomAccess<E> extends
    SubAbstractList<E> implements RandomAccess {
		SubAbstractListRandomAccess(AbstractList<E> list, int start, int end) {
			super(list, start, end);
		}
	}
	
	private static class SubAbstractList<E> extends AbstractList<E> {
		private final AbstractList<E> fullList;

        private int offset;
        private int size;
        
        private static final class SubAbstractListIterator<E> implements
        ListIterator<E> {
        	private final SubAbstractList<E> subList;
            private final ListIterator<E> iterator;

            private int start;
            private int end;
            
            SubAbstractListIterator(ListIterator<E> it,
                    SubAbstractList<E> list, int offset, int length) {
                iterator = it;
                subList = list;
                start = offset;
                end = start + length;
            }

			@Override
			public void add(E object) {
                iterator.add(object);
                subList.sizeChanged(true);
                end++;
            }

			@Override
			public boolean hasNext() {
                return iterator.nextIndex() < end;
            }

			@Override
			public boolean hasPrevious() {
                return iterator.previousIndex() >= start;
            }

			@Override
			public E next() {
                if (iterator.nextIndex() < end) {
                    return iterator.next();
                }
                throw new NoSuchElementException();
            }

			@Override
			public int nextIndex() {
                return iterator.nextIndex() - start;
            }

			@Override
			public E previous() {
                if (iterator.previousIndex() >= start) {
                    return iterator.previous();
                }
                throw new NoSuchElementException();
            }

			@Override
			public int previousIndex() {
                int previous = iterator.previousIndex();
                if (previous >= start) {
                    return previous - start;
                }
                return -1;
            }

			@Override
			public void remove() {
                iterator.remove();
                subList.sizeChanged(false);
                end--;
            }

			@Override
			public void set(E object) {
                iterator.set(object);
            }
        }
        
		SubAbstractList(AbstractList<E> list, int start, int end) {
            fullList = list;
            modCount = fullList.modCount;
            offset = start;
            size = end - start;
        }
		
		void sizeChanged(boolean increment) {
            if (increment) {
                size++;
            } else {
                size--;
            }
            modCount = fullList.modCount;
        }
		
		@Override
		public boolean add(E object) {
	        add(size(), object);
	        return true;
	    }

		@Override
		public void add(int location, E object) {
	        throw new UnsupportedOperationException();
	    }

		@Override
		public boolean addAll(int location, Collection<? extends E> collection) {
	        Iterator<? extends E> it = collection.iterator();
	        while (it.hasNext()) {
	            add(location++, it.next());
	        }
	        return !collection.isEmpty();
	    }

		@Override
        public E get(int location) {
            if (modCount == fullList.modCount) {
                if (location >= 0 && location < size) {
                    return fullList.get(location + offset);
                }
                throw new IndexOutOfBoundsException();
            }
            throw new ConcurrentModificationException();
        }

		@Override
        public ListIterator<E> listIterator(int location) {
            if (modCount == fullList.modCount) {
                if (location >= 0 && location <= size) {
                    return new SubAbstractListIterator<E>(fullList
                            .listIterator(location + offset), this, offset,
                            size);
                }
                throw new IndexOutOfBoundsException();
            }
            throw new ConcurrentModificationException();
        }

		@Override
        public E remove(int location) {
            if (modCount == fullList.modCount) {
                if (location >= 0 && location < size) {
                    E result = fullList.remove(location + offset);
                    size--;
                    modCount = fullList.modCount;
                    return result;
                }
                throw new IndexOutOfBoundsException();
            }
            throw new ConcurrentModificationException();
        }
		
		@Override
        public E set(int location, E object) {
            if (modCount == fullList.modCount) {
                if (location >= 0 && location < size) {
                    return fullList.set(location + offset, object);
                }
                throw new IndexOutOfBoundsException();
            }
            throw new ConcurrentModificationException();
        }

		@Override
        public Iterator<E> iterator() {
            return listIterator(0);
        }

		@Override
        public int size() {
            if (modCount == fullList.modCount) {
                return size;
            }
            throw new ConcurrentModificationException();
        }
	}
	
	private class SimpleListIterator implements Iterator<E> {
		private int pos = -1; // Was package
        private int expectedModCount; // Was package
        private int lastPosition = -1; // Was package

        SimpleListIterator() {
            expectedModCount = modCount;
        }
        
		@Override
		public boolean hasNext() {
            return pos + 1 < size();
        }

		@Override
		public E next() {
            if (expectedModCount == modCount) {
                try {
                    E result = get(pos + 1);
                    lastPosition = ++pos;
                    return result;
                } catch (IndexOutOfBoundsException e) {
                    throw new NoSuchElementException();
                }
            }
            throw new ConcurrentModificationException();
        }

		@Override
		public void remove() {
            if (this.lastPosition == -1) {
                throw new IllegalStateException();
            }

            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }

            try {
                AbstractList.this.remove(lastPosition);
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }

            expectedModCount = modCount;
            if (pos == lastPosition) {
                pos--;
            }
            lastPosition = -1;
        }
	}
	
	private final class FullListIterator extends SimpleListIterator implements ListIterator<E> {
		FullListIterator(int start) {
            if (start >= 0 && start <= size()) {
                pos = start - 1;
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
		
		@Override
		public void add(E object) {
            if (expectedModCount == modCount) {
                try {
                    AbstractList.this.add(pos + 1, object);
                } catch (IndexOutOfBoundsException e) {
                    throw new NoSuchElementException();
                }
                pos++;
                lastPosition = -1;
                if (modCount != expectedModCount) {
                    expectedModCount = modCount;
                }
            } else {
                throw new ConcurrentModificationException();
            }
        }

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public E previous() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void set(E arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
