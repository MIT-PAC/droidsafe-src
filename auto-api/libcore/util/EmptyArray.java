package libcore.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public final class EmptyArray {
    public static final boolean[] BOOLEAN = new boolean[0];
    public static final byte[] BYTE = new byte[0];
    public static final char[] CHAR = new char[0];
    public static final double[] DOUBLE = new double[0];
    public static final int[] INT = new int[0];
    public static final Class<?>[] CLASS = new Class[0];
    public static final Object[] OBJECT = new Object[0];
    public static final String[] STRING = new String[0];
    public static final Throwable[] THROWABLE = new Throwable[0];
    public static final StackTraceElement[] STACK_TRACE_ELEMENT = new StackTraceElement[0];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.539 -0400", hash_original_method = "22DFB1C541C2464C033363DDDF2AB621", hash_generated_method = "B28A75E5976B5ADC1FE1FE845D140023")
    @DSModeled(DSC.SAFE)
    private EmptyArray() {
        // ---------- Original Method ----------
    }

    
}


