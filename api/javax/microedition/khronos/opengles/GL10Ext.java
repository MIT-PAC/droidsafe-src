package javax.microedition.khronos.opengles;

// Droidsafe Imports

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
