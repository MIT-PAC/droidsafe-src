package droidsafe.utils;

/** 
 * An interface to facilitate custom equality and hash code.
 */
public interface Equality {

    public boolean equals(Object key, Object other);
    
    public int hashCode(Object obj);

}
