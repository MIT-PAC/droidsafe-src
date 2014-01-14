package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.util.FloatMath;

public class ColorMatrix {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:10.551 -0500", hash_original_field = "1B9AE67EA9C44659A4D1BB6336966CD5", hash_generated_field = "EB497EE5AD03BD0F08D38D6437611B86")

    private final float[] mArray = new float[20];

    /**
     * Create a new colormatrix initialized to identity (as if reset() had
     * been called).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:10.554 -0500", hash_original_method = "7C280C0D6BD3CA85A908B9065390FD08", hash_generated_method = "DB971D5BC54B5A31AD0846AFF0400420")
    
public ColorMatrix() {
        reset();
    }

    /**
        * Create a new colormatrix initialized with the specified array of values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:10.556 -0500", hash_original_method = "E88FC6AE9EAD423F2D43BC5A2B86150F", hash_generated_method = "FBF9F55517D84B6FDEDD50858A77D8DD")
    
public ColorMatrix(float[] src) {
        System.arraycopy(src, 0, mArray, 0, 20);
    }
    
    /**
     * Create a new colormatrix initialized with the specified colormatrix.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:10.558 -0500", hash_original_method = "668D89CF48F3ADC6BE7AF94D782DA652", hash_generated_method = "2ABA277C680FC2569DEF64D5B0C8092B")
    
public ColorMatrix(ColorMatrix src) {
        System.arraycopy(src.mArray, 0, mArray, 0, 20);
    }
    
    /**
     * Return the array of floats representing this colormatrix.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:10.560 -0500", hash_original_method = "C51050FB528280ED78B19148B7D68B9E", hash_generated_method = "63C6B2BBD63D99F1D2FEFB03B9401E16")
    
public final float[] getArray() { return mArray; }
    
    /**
     * Set this colormatrix to identity:
     * [ 1 0 0 0 0   - red vector
     *   0 1 0 0 0   - green vector
     *   0 0 1 0 0   - blue vector
     *   0 0 0 1 0 ] - alpha vector
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:10.563 -0500", hash_original_method = "651EAEC497B28FBE14AC71396739DF99", hash_generated_method = "CB1C5A4BEAEEF5DC9F4C010C3A76075B")
    
public void reset() {
        final float[] a = mArray;
        
        for (int i = 19; i > 0; --i) {
            a[i] = 0;
        }
        a[0] = a[6] = a[12] = a[18] = 1;
    }
    
    /**
     * Assign the src colormatrix into this matrix, copying all of its values.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:10.565 -0500", hash_original_method = "9919D3B45BE014B7359BBBE4E1EE27A7", hash_generated_method = "1D3FAA46DE81B1D61BD927E059A5DBCD")
    
public void set(ColorMatrix src) {
        System.arraycopy(src.mArray, 0, mArray, 0, 20);
    }

    /**
     * Assign the array of floats into this matrix, copying all of its values.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:10.567 -0500", hash_original_method = "1B16B7E11AFFA7F8CD6600BA7D48EFFB", hash_generated_method = "0BB84B094E6971328C21B16B46E9F34A")
    
public void set(float[] src) {
        System.arraycopy(src, 0, mArray, 0, 20);
    }
    
    /**
     * Set this colormatrix to scale by the specified values.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:10.570 -0500", hash_original_method = "0974414711261BF80A4D723D743AAB06", hash_generated_method = "BE8F1B9FD3D4F59B4EE52CC2CAD72E8F")
    
public void setScale(float rScale, float gScale, float bScale,
                         float aScale) {
        final float[] a = mArray;

        for (int i = 19; i > 0; --i) {
            a[i] = 0;
        }
        a[0] = rScale;
        a[6] = gScale;
        a[12] = bScale;
        a[18] = aScale;
    }
    
    /**
     * Set the rotation on a color axis by the specified values.
     * axis=0 correspond to a rotation around the RED color
     * axis=1 correspond to a rotation around the GREEN color
     * axis=2 correspond to a rotation around the BLUE color
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:10.572 -0500", hash_original_method = "F365836E7CADE057885AC91CF063AD58", hash_generated_method = "612FFBFFC9FED1E8E244AA6DB7FD59A1")
    
public void setRotate(int axis, float degrees) {
        reset();
        float radians = degrees * (float)Math.PI / 180;
        float cosine = FloatMath.cos(radians);
        float sine = FloatMath.sin(radians);
        switch (axis) {
        // Rotation around the red color
        case 0:
            mArray[6] = mArray[12] = cosine;
            mArray[7] = sine;
            mArray[11] = -sine;
            break;
        // Rotation around the green color
        case 1:
            mArray[0] = mArray[12] = cosine;
            mArray[2] = -sine;
            mArray[10] = sine;
            break;
        // Rotation around the blue color
        case 2:
            mArray[0] = mArray[6] = cosine;
            mArray[1] = sine;
            mArray[5] = -sine;
            break;
        default:
            throw new RuntimeException();
        }
    }
    
    /**
     * Set this colormatrix to the concatenation of the two specified
     * colormatrices, such that the resulting colormatrix has the same effect
     * as applying matB and then applying matA. It is legal for either matA or
     * matB to be the same colormatrix as this.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:10.575 -0500", hash_original_method = "843BB575BEC1DC3153103BA70AD6226C", hash_generated_method = "E3DA8F9DABD88AC3112E4758BB05B6BC")
    
public void setConcat(ColorMatrix matA, ColorMatrix matB) {
        float[] tmp = null;
        
        if (matA == this || matB == this) {
            tmp = new float[20];
        }
        else {
            tmp = mArray;
        }
        
        final float[] a = matA.mArray;
        final float[] b = matB.mArray;
        int index = 0;
        for (int j = 0; j < 20; j += 5) {
            for (int i = 0; i < 4; i++) {
                tmp[index++] = a[j + 0] * b[i + 0] +  a[j + 1] * b[i + 5] +
                               a[j + 2] * b[i + 10] + a[j + 3] * b[i + 15];
            }
            tmp[index++] = a[j + 0] * b[4] +  a[j + 1] * b[9] +
                           a[j + 2] * b[14] + a[j + 3] * b[19] +
                           a[j + 4];
        }
        
        if (tmp != mArray) {
            System.arraycopy(tmp, 0, mArray, 0, 20);
        }
    }
    
    /**
     * Concat this colormatrix with the specified prematrix. This is logically
     * the same as calling setConcat(this, prematrix);
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:10.577 -0500", hash_original_method = "776A0D16BAF4033F49AFC0802778097D", hash_generated_method = "1683E660BF0434876FDF5F0660A38086")
    
public void preConcat(ColorMatrix prematrix) {
        setConcat(this, prematrix);
    }
    
    /**
     * Concat this colormatrix with the specified postmatrix. This is logically
     * the same as calling setConcat(postmatrix, this);
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:10.579 -0500", hash_original_method = "B5BC76A876DDBB43CC54F09A33784608", hash_generated_method = "6904ABE9DB46F0850CCC8E3D457C571E")
    
public void postConcat(ColorMatrix postmatrix) {
        setConcat(postmatrix, this);
    }
    
    ///////////////////////////////////////////////////////////////////////////
    
    /**
     * Set the matrix to affect the saturation of colors. A value of 0 maps the
     * color to gray-scale. 1 is identity.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:10.582 -0500", hash_original_method = "4B5CDCAEBB0220A2068E2CB6AD49DF79", hash_generated_method = "7DDADE0AF9C68CC685E7E9244C5D45A3")
    
public void setSaturation(float sat) {
        reset();
        float[] m = mArray;
        
        final float invSat = 1 - sat;
        final float R = 0.213f * invSat;
        final float G = 0.715f * invSat;
        final float B = 0.072f * invSat;

        m[0] = R + sat; m[1] = G;       m[2] = B;
        m[5] = R;       m[6] = G + sat; m[7] = B;
        m[10] = R;      m[11] = G;      m[12] = B + sat;
    }
    
    /**
     * Set the matrix to convert RGB to YUV
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:10.584 -0500", hash_original_method = "5B1F12450A5CDB7BE7A8B64628B4B21E", hash_generated_method = "7190FA541C0D10FAB02D0B7E3C36D680")
    
public void setRGB2YUV() {
        reset();
        float[] m = mArray;
        // these coefficients match those in libjpeg
        m[0]  = 0.299f;    m[1]  = 0.587f;    m[2]  = 0.114f;
        m[5]  = -0.16874f; m[6]  = -0.33126f; m[7]  = 0.5f;
        m[10] = 0.5f;      m[11] = -0.41869f; m[12] = -0.08131f;
    }
    
    /**
     * Set the matrix to convert from YUV to RGB
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:10.587 -0500", hash_original_method = "6D15755F0D0866427FC697B26AFE845E", hash_generated_method = "258D8DD3FEC39237791A587CEA196BEB")
    
public void setYUV2RGB() {
        reset();
        float[] m = mArray;
        // these coefficients match those in libjpeg
                                        m[2] = 1.402f;
        m[5] = 1;   m[6] = -0.34414f;   m[7] = -0.71414f;
        m[10] = 1;  m[11] = 1.772f;     m[12] = 0;
    }
    
}

