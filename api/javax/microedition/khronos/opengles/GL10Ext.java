package javax.microedition.khronos.opengles;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface GL10Ext extends GL {

    int glQueryMatrixxOES(
        int[] mantissa,
        int mantissaOffset,
        int[] exponent,
        int exponentOffset
    );

    int glQueryMatrixxOES(
        java.nio.IntBuffer mantissa,
        java.nio.IntBuffer exponent
    );

}
