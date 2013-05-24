package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public abstract class AbstractSet <E> extends AbstractCollection<E> implements Set<E> {
    public DSTaintObject dsTaint = new DSTaintObject();
    
    
    protected AbstractSet(){
    }
    
    @Override public boolean equals(Object object){
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Set<?> s = (Set<?>) object;
        return dsTaint.getTaintBoolean();

        // Original method
        /*
        {
        if (this == object) {
            return true;
        }
        if (object instanceof Set) {
            Set<?> s = (Set<?>) object;

            try {
                return size() == s.size() && containsAll(s);
            } catch (NullPointerException ignored) {
                return false;
            } catch (ClassCastException ignored) {
                return false;
            }
        }
        return false;
    }
        */
    }
    
    @Override public int hashCode(){
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //int result = 0;
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Iterator<?> it = iterator();
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Object next = it.next();
        //result += next == null ? 0 : next.hashCode();
        return dsTaint.getTaintInt();

        // Original method
        /*
        {
        int result = 0;
        Iterator<?> it = iterator();
        while (it.hasNext()) {
            Object next = it.next();
            result += next == null ? 0 : next.hashCode();
        }
        return result;
    }
        */
    }
    
    @Override public boolean removeAll(Collection<?> collection){
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //boolean result = false;
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Iterator<?> it = iterator();
        //it.remove();
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Iterator<?> it = collection.iterator();
        return dsTaint.getTaintBoolean();

        // Original method
        /*
        {
        boolean result = false;
        if (size() <= collection.size()) {
            Iterator<?> it = iterator();
            while (it.hasNext()) {
                if (collection.contains(it.next())) {
                    it.remove();
                    result = true;
                }
            }
        } else {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                result = remove(it.next()) || result;
            }
        }
        return result;
    }
        */
    }
}

