package droidsafe.analyses.value;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/** 
 * Reusable forwarding class. Uses composition instead of inheritance (see Item 16 in Effective Java 2nd ed by Bloch)
 *
 * @author dpetters
 */
public class ForwardingSet<E> implements Set<E> {

    /**
     * Private field referencing existing class
     */
    private final Set<E> s;

    /**
     * Only constructor.
     */
    public ForwardingSet(Set<E> setParam) { 
        this.s = setParam; 
    }

    /**
     * Getter for the private composition field
     */
    public Set<E> getSet() {
        return this.s;
    }

    /**
     * Forwarding method
     */
    public void clear() { 
        s.clear();
    }

    /**
     * Forwarding method
     */
    public boolean contains(Object o) { 
        return s.contains(o);
    }

    /**
     * Forwarding method
     */
    public boolean isEmpty() { 
        return s.isEmpty();
    }

    /**
     * Forwarding method
     */
    public int size() { 
        return s.size(); 
    }

    /**
     * Forwarding method
     */
    public Iterator<E> iterator() { 
        return s.iterator();
    }

    /**
     * Forwarding method
     */
    public boolean add(E e) { 
        return s.add(e);
    }

    /**
     * Forwarding method
     */
    public boolean remove(Object o) { 
        return s.remove(o); 
    }

    /**
     * Forwarding method
     */
    public boolean containsAll(Collection<?> c)
    { 
        return s.containsAll(c);
    }

    /**
     * Forwarding method
     */
    public boolean addAll(Collection<? extends E> c)
    { 
        return s.addAll(c);
    }

    /**
     * Forwarding method
     */
    public boolean removeAll(Collection<?> c)
    { 
        return s.removeAll(c);
    }

    /**
     * Forwarding method
     */
    public boolean retainAll(Collection<?> c)
    {
        return s.retainAll(c);
    }

    /**
     * Forwarding method
     */
    public Object[] toArray() { return s.toArray(); }

    /**
     * Forwarding method
     */
    public <T> T[] toArray(T[] a) { return s.toArray(a); }

    /**
     * Forwarding method
     */
    @Override public boolean equals(Object o)
    { 
        return s.equals(o);
    }

    /**
     * Forwarding method
     */
    @Override 
    public int hashCode() { 
        return s.hashCode(); 
    }

    /**
     * Forwarding method
     */
    @Override 
    public String toString() { 
        return s.toString();
    }
}
