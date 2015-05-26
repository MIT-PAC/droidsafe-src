package droidsafe.utils;

/** 
 * Mutable Int class for incrementing / counting maps.
 * 
 * @author mgordon
 *
 */
public class MutableInt {
    int value = 1; // note that we start at 1 since we're counting

    public void increment () { 
        ++value;      
    }

    public int  value() { 
        return value; 
    }
}
