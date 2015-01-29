package droidsafe.speclang;

/**
 * This class represents the null constant value in Java.
 * 
 * @author mgordon
 *
 */
public class NullValue extends ConcreteArgumentValue {
    /** static singleton because there only needs to be one null value */
    private static NullValue singleton = new NullValue();
    
    /**
     * Create a new null Value.
     */
    private NullValue() {
   
    }
    
    /**
     * Return the singleton null value.
     */
    public static NullValue getNullValue() {
        return singleton;
    }

    /**
     * Return string.
     */
    @Override
    public String toStringValue() {
        return "null";
    }
    
    /**
     * Return string.
     */
    public String toString() {
        return "null";
    }

}
