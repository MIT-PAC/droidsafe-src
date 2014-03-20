package android.hardware;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.IRotationWatcher;
import android.view.IWindowManager;
import android.view.Surface;

import droidsafe.helpers.DSUtils;

public class SensorManager {

    /**
     * <p>
     * Computes the inclination matrix <b>I</b> as well as the rotation matrix
     * <b>R</b> transforming a vector from the device coordinate system to the
     * world's coordinate system which is defined as a direct orthonormal basis,
     * where:
     * </p>
     *
     * <ul>
     * <li>X is defined as the vector product <b>Y.Z</b> (It is tangential to
     * the ground at the device's current location and roughly points East).</li>
     * <li>Y is tangential to the ground at the device's current location and
     * points towards the magnetic North Pole.</li>
     * <li>Z points towards the sky and is perpendicular to the ground.</li>
     * </ul>
     *
     * <p>
     * <center><img src="../../../images/axis_globe.png"
     * alt="World coordinate-system diagram." border="0" /></center>
     * </p>
     *
     * <p>
     * <hr>
     * <p>
     * By definition:
     * <p>
     * [0 0 g] = <b>R</b> * <b>gravity</b> (g = magnitude of gravity)
     * <p>
     * [0 m 0] = <b>I</b> * <b>R</b> * <b>geomagnetic</b> (m = magnitude of
     * geomagnetic field)
     * <p>
     * <b>R</b> is the identity matrix when the device is aligned with the
     * world's coordinate system, that is, when the device's X axis points
     * toward East, the Y axis points to the North Pole and the device is facing
     * the sky.
     *
     * <p>
     * <b>I</b> is a rotation matrix transforming the geomagnetic vector into
     * the same coordinate space as gravity (the world's coordinate space).
     * <b>I</b> is a simple rotation around the X axis. The inclination angle in
     * radians can be computed with {@link #getInclination}.
     * <hr>
     *
     * <p>
     * Each matrix is returned either as a 3x3 or 4x4 row-major matrix depending
     * on the length of the passed array:
     * <p>
     * <u>If the array length is 16:</u>
     *
     * <pre>
     *   /  M[ 0]   M[ 1]   M[ 2]   M[ 3]  \
     *   |  M[ 4]   M[ 5]   M[ 6]   M[ 7]  |
     *   |  M[ 8]   M[ 9]   M[10]   M[11]  |
     *   \  M[12]   M[13]   M[14]   M[15]  /
     *</pre>
     *
     * This matrix is ready to be used by OpenGL ES's
     * {@link javax.microedition.khronos.opengles.GL10#glLoadMatrixf(float[], int)
     * glLoadMatrixf(float[], int)}.
     * <p>
     * Note that because OpenGL matrices are column-major matrices you must
     * transpose the matrix before using it. However, since the matrix is a
     * rotation matrix, its transpose is also its inverse, conveniently, it is
     * often the inverse of the rotation that is needed for rendering; it can
     * therefore be used with OpenGL ES directly.
     * <p>
     * Also note that the returned matrices always have this form:
     *
     * <pre>
     *   /  M[ 0]   M[ 1]   M[ 2]   0  \
     *   |  M[ 4]   M[ 5]   M[ 6]   0  |
     *   |  M[ 8]   M[ 9]   M[10]   0  |
     *   \      0       0       0   1  /
     *</pre>
     *
     * <p>
     * <u>If the array length is 9:</u>
     *
     * <pre>
     *   /  M[ 0]   M[ 1]   M[ 2]  \
     *   |  M[ 3]   M[ 4]   M[ 5]  |
     *   \  M[ 6]   M[ 7]   M[ 8]  /
     *</pre>
     *
     * <hr>
     * <p>
     * The inverse of each matrix can be computed easily by taking its
     * transpose.
     *
     * <p>
     * The matrices returned by this function are meaningful only when the
     * device is not free-falling and it is not close to the magnetic north. If
     * the device is accelerating, or placed into a strong magnetic field, the
     * returned matrices may be inaccurate.
     *
     * @param R
     *        is an array of 9 floats holding the rotation matrix <b>R</b> when
     *        this function returns. R can be null.
     *        <p>
     *
     * @param I
     *        is an array of 9 floats holding the rotation matrix <b>I</b> when
     *        this function returns. I can be null.
     *        <p>
     *
     * @param gravity
     *        is an array of 3 floats containing the gravity vector expressed in
     *        the device's coordinate. You can simply use the
     *        {@link android.hardware.SensorEvent#values values} returned by a
     *        {@link android.hardware.SensorEvent SensorEvent} of a
     *        {@link android.hardware.Sensor Sensor} of type
     *        {@link android.hardware.Sensor#TYPE_ACCELEROMETER
     *        TYPE_ACCELEROMETER}.
     *        <p>
     *
     * @param geomagnetic
     *        is an array of 3 floats containing the geomagnetic vector
     *        expressed in the device's coordinate. You can simply use the
     *        {@link android.hardware.SensorEvent#values values} returned by a
     *        {@link android.hardware.SensorEvent SensorEvent} of a
     *        {@link android.hardware.Sensor Sensor} of type
     *        {@link android.hardware.Sensor#TYPE_MAGNETIC_FIELD
     *        TYPE_MAGNETIC_FIELD}.
     *
     * @return <code>true</code> on success, <code>false</code> on failure (for
     *         instance, if the device is in free fall). On failure the output
     *         matrices are not modified.
     *
     * @see #getInclination(float[])
     * @see #getOrientation(float[], float[])
     * @see #remapCoordinateSystem(float[], int, int, float[])
     */

    @DSComment("Request/Change/Listen Android Manger")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.037 -0500", hash_original_method = "80FFBDA32F1CA6FB68C3B24B9C01CA42", hash_generated_method = "C2361A9E50FB5E2540C47B2203847598")
    
public static boolean getRotationMatrix(float[] R, float[] I,
            float[] gravity, float[] geomagnetic) {
        // TODO: move this to native code for efficiency
        float Ax = gravity[0];
        float Ay = gravity[1];
        float Az = gravity[2];
        final float Ex = geomagnetic[0];
        final float Ey = geomagnetic[1];
        final float Ez = geomagnetic[2];
        float Hx = Ey*Az - Ez*Ay;
        float Hy = Ez*Ax - Ex*Az;
        float Hz = Ex*Ay - Ey*Ax;
        final float normH = (float)Math.sqrt(Hx*Hx + Hy*Hy + Hz*Hz);
        if (normH < 0.1f) {
            // device is close to free fall (or in space?), or close to
            // magnetic north pole. Typical values are  > 100.
            return false;
        }
        final float invH = 1.0f / normH;
        Hx *= invH;
        Hy *= invH;
        Hz *= invH;
        final float invA = 1.0f / (float)Math.sqrt(Ax*Ax + Ay*Ay + Az*Az);
        Ax *= invA;
        Ay *= invA;
        Az *= invA;
        final float Mx = Ay*Hz - Az*Hy;
        final float My = Az*Hx - Ax*Hz;
        final float Mz = Ax*Hy - Ay*Hx;
        if (R != null) {
            if (R.length == 9) {
                R[0] = Hx;     R[1] = Hy;     R[2] = Hz;
                R[3] = Mx;     R[4] = My;     R[5] = Mz;
                R[6] = Ax;     R[7] = Ay;     R[8] = Az;
            } else if (R.length == 16) {
                R[0]  = Hx;    R[1]  = Hy;    R[2]  = Hz;   R[3]  = 0;
                R[4]  = Mx;    R[5]  = My;    R[6]  = Mz;   R[7]  = 0;
                R[8]  = Ax;    R[9]  = Ay;    R[10] = Az;   R[11] = 0;
                R[12] = 0;     R[13] = 0;     R[14] = 0;    R[15] = 1;
            }
        }
        if (I != null) {
            // compute the inclination matrix by projecting the geomagnetic
            // vector onto the Z (gravity) and X (horizontal component
            // of geomagnetic vector) axes.
            final float invE = 1.0f / (float)Math.sqrt(Ex*Ex + Ey*Ey + Ez*Ez);
            final float c = (Ex*Mx + Ey*My + Ez*Mz) * invE;
            final float s = (Ex*Ax + Ey*Ay + Ez*Az) * invE;
            if (I.length == 9) {
                I[0] = 1;     I[1] = 0;     I[2] = 0;
                I[3] = 0;     I[4] = c;     I[5] = s;
                I[6] = 0;     I[7] =-s;     I[8] = c;
            } else if (I.length == 16) {
                I[0] = 1;     I[1] = 0;     I[2] = 0;
                I[4] = 0;     I[5] = c;     I[6] = s;
                I[8] = 0;     I[9] =-s;     I[10]= c;
                I[3] = I[7] = I[11] = I[12] = I[13] = I[14] = 0;
                I[15] = 1;
            }
        }
        return true;
    }

    /**
     * Computes the geomagnetic inclination angle in radians from the
     * inclination matrix <b>I</b> returned by {@link #getRotationMatrix}.
     *
     * @param I
     *        inclination matrix see {@link #getRotationMatrix}.
     *
     * @return The geomagnetic inclination angle in radians.
     *
     * @see #getRotationMatrix(float[], float[], float[], float[])
     * @see #getOrientation(float[], float[])
     * @see GeomagneticField
     *
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.040 -0500", hash_original_method = "FC0D372BF97A5B9BCD6915691825C261", hash_generated_method = "D5A70E08C36B24C4FBB1CE4753C03A9A")
    
public static float getInclination(float[] I) {
        if (I.length == 9) {
            return (float)Math.atan2(I[5], I[4]);
        } else {
            return (float)Math.atan2(I[6], I[5]);
        }
    }

    /**
     * <p>
     * Rotates the supplied rotation matrix so it is expressed in a different
     * coordinate system. This is typically used when an application needs to
     * compute the three orientation angles of the device (see
     * {@link #getOrientation}) in a different coordinate system.
     * </p>
     *
     * <p>
     * When the rotation matrix is used for drawing (for instance with OpenGL
     * ES), it usually <b>doesn't need</b> to be transformed by this function,
     * unless the screen is physically rotated, in which case you can use
     * {@link android.view.Display#getRotation() Display.getRotation()} to
     * retrieve the current rotation of the screen. Note that because the user
     * is generally free to rotate their screen, you often should consider the
     * rotation in deciding the parameters to use here.
     * </p>
     *
     * <p>
     * <u>Examples:</u>
     * <p>
     *
     * <ul>
     * <li>Using the camera (Y axis along the camera's axis) for an augmented
     * reality application where the rotation angles are needed:</li>
     *
     * <p>
     * <ul>
     * <code>remapCoordinateSystem(inR, AXIS_X, AXIS_Z, outR);</code>
     * </ul>
     * </p>
     *
     * <li>Using the device as a mechanical compass when rotation is
     * {@link android.view.Surface#ROTATION_90 Surface.ROTATION_90}:</li>
     *
     * <p>
     * <ul>
     * <code>remapCoordinateSystem(inR, AXIS_Y, AXIS_MINUS_X, outR);</code>
     * </ul>
     * </p>
     *
     * Beware of the above example. This call is needed only to account for a
     * rotation from its natural orientation when calculating the rotation
     * angles (see {@link #getOrientation}). If the rotation matrix is also used
     * for rendering, it may not need to be transformed, for instance if your
     * {@link android.app.Activity Activity} is running in landscape mode.
     * </ul>
     *
     * <p>
     * Since the resulting coordinate system is orthonormal, only two axes need
     * to be specified.
     *
     * @param inR
     *        the rotation matrix to be transformed. Usually it is the matrix
     *        returned by {@link #getRotationMatrix}.
     *
     * @param X
     *        defines on which world axis and direction the X axis of the device
     *        is mapped.
     *
     * @param Y
     *        defines on which world axis and direction the Y axis of the device
     *        is mapped.
     *
     * @param outR
     *        the transformed rotation matrix. inR and outR can be the same
     *        array, but it is not recommended for performance reason.
     *
     * @return <code>true</code> on success. <code>false</code> if the input
     *         parameters are incorrect, for instance if X and Y define the same
     *         axis. Or if inR and outR don't have the same length.
     *
     * @see #getRotationMatrix(float[], float[], float[], float[])
     */

    @DSComment("Sensor accessing")
    @DSSpec(DSCat.DEVICE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.043 -0500", hash_original_method = "FE2484DC0236D6664EA6E4EA310B2D70", hash_generated_method = "646AF5810B2BD63319A7EC849D82CDA3")
    
public static boolean remapCoordinateSystem(float[] inR, int X, int Y,
            float[] outR)
    {
        if (inR == outR) {
            final float[] temp = mTempMatrix;
            synchronized(temp) {
                // we don't expect to have a lot of contention
                if (remapCoordinateSystemImpl(inR, X, Y, temp)) {
                    final int size = outR.length;
                    for (int i=0 ; i<size ; i++)
                        outR[i] = temp[i];
                    return true;
                }
            }
        }
        return remapCoordinateSystemImpl(inR, X, Y, outR);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.048 -0500", hash_original_method = "FD95EEF3A35F6010EF733035D8CD816B", hash_generated_method = "8BC9E027B9AAA12BA4D31AEB03638B1E")
    
private static boolean remapCoordinateSystemImpl(float[] inR, int X, int Y,
            float[] outR)
    {
        /*
         * X and Y define a rotation matrix 'r':
         *
         *  (X==1)?((X&0x80)?-1:1):0    (X==2)?((X&0x80)?-1:1):0    (X==3)?((X&0x80)?-1:1):0
         *  (Y==1)?((Y&0x80)?-1:1):0    (Y==2)?((Y&0x80)?-1:1):0    (Y==3)?((X&0x80)?-1:1):0
         *                              r[0] ^ r[1]
         *
         * where the 3rd line is the vector product of the first 2 lines
         *
         */

        final int length = outR.length;
        if (inR.length != length)
            return false;   // invalid parameter
        if ((X & 0x7C)!=0 || (Y & 0x7C)!=0)
            return false;   // invalid parameter
        if (((X & 0x3)==0) || ((Y & 0x3)==0))
            return false;   // no axis specified
        if ((X & 0x3) == (Y & 0x3))
            return false;   // same axis specified

        // Z is "the other" axis, its sign is either +/- sign(X)*sign(Y)
        // this can be calculated by exclusive-or'ing X and Y; except for
        // the sign inversion (+/-) which is calculated below.
        int Z = X ^ Y;

        // extract the axis (remove the sign), offset in the range 0 to 2.
        final int x = (X & 0x3)-1;
        final int y = (Y & 0x3)-1;
        final int z = (Z & 0x3)-1;

        // compute the sign of Z (whether it needs to be inverted)
        final int axis_y = (z+1)%3;
        final int axis_z = (z+2)%3;
        if (((x^axis_y)|(y^axis_z)) != 0)
            Z ^= 0x80;

        final boolean sx = (X>=0x80);
        final boolean sy = (Y>=0x80);
        final boolean sz = (Z>=0x80);

        // Perform R * r, in avoiding actual muls and adds.
        final int rowLength = ((length==16)?4:3);
        for (int j=0 ; j<3 ; j++) {
            final int offset = j*rowLength;
            for (int i=0 ; i<3 ; i++) {
                if (x==i)   outR[offset+i] = sx ? -inR[offset+0] : inR[offset+0];
                if (y==i)   outR[offset+i] = sy ? -inR[offset+1] : inR[offset+1];
                if (z==i)   outR[offset+i] = sz ? -inR[offset+2] : inR[offset+2];
            }
        }
        if (length == 16) {
            outR[3] = outR[7] = outR[11] = outR[12] = outR[13] = outR[14] = 0;
            outR[15] = 1;
        }
        return true;
    }

    /**
     * Computes the device's orientation based on the rotation matrix.
     * <p>
     * When it returns, the array values is filled with the result:
     * <ul>
     * <li>values[0]: <i>azimuth</i>, rotation around the Z axis.</li>
     * <li>values[1]: <i>pitch</i>, rotation around the X axis.</li>
     * <li>values[2]: <i>roll</i>, rotation around the Y axis.</li>
     * </ul>
     * <p>The reference coordinate-system used is different from the world
     * coordinate-system defined for the rotation matrix:</p>
     * <ul>
     * <li>X is defined as the vector product <b>Y.Z</b> (It is tangential to
     * the ground at the device's current location and roughly points West).</li>
     * <li>Y is tangential to the ground at the device's current location and
     * points towards the magnetic North Pole.</li>
     * <li>Z points towards the center of the Earth and is perpendicular to the ground.</li>
     * </ul>
     *
     * <p>
     * <center><img src="../../../images/axis_globe_inverted.png"
     * alt="Inverted world coordinate-system diagram." border="0" /></center>
     * </p>
     * <p>
     * All three angles above are in <b>radians</b> and <b>positive</b> in the
     * <b>counter-clockwise</b> direction.
     * 
     * @param R
     *        rotation matrix see {@link #getRotationMatrix}.
     * 
     * @param values
     *        an array of 3 floats to hold the result.
     * 
     * @return The array values passed as argument.
     * 
     * @see #getRotationMatrix(float[], float[], float[], float[])
     * @see GeomagneticField
     */
    @DSComment("Request/Change/Listen Android Manger")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.051 -0500", hash_original_method = "48D1C344F1CE2628DE4C68ABB227A1F6", hash_generated_method = "5E0C14D6CF43554F17C02DEA9C8592AA")
    
public static float[] getOrientation(float[] R, float values[]) {
        /*
         * 4x4 (length=16) case:
         *   /  R[ 0]   R[ 1]   R[ 2]   0  \
         *   |  R[ 4]   R[ 5]   R[ 6]   0  |
         *   |  R[ 8]   R[ 9]   R[10]   0  |
         *   \      0       0       0   1  /
         *
         * 3x3 (length=9) case:
         *   /  R[ 0]   R[ 1]   R[ 2]  \
         *   |  R[ 3]   R[ 4]   R[ 5]  |
         *   \  R[ 6]   R[ 7]   R[ 8]  /
         *
         */
        if (R.length == 9) {
            values[0] = (float)Math.atan2(R[1], R[4]);
            values[1] = (float)Math.asin(-R[7]);
            values[2] = (float)Math.atan2(-R[6], R[8]);
        } else {
            values[0] = (float)Math.atan2(R[1], R[5]);
            values[1] = (float)Math.asin(-R[9]);
            values[2] = (float)Math.atan2(-R[8], R[10]);
        }
        return values;
    }

    /**
     * Computes the Altitude in meters from the atmospheric pressure and the
     * pressure at sea level.
     * <p>
     * Typically the atmospheric pressure is read from a
     * {@link Sensor#TYPE_PRESSURE} sensor. The pressure at sea level must be
     * known, usually it can be retrieved from airport databases in the
     * vicinity. If unknown, you can use {@link #PRESSURE_STANDARD_ATMOSPHERE}
     * as an approximation, but absolute altitudes won't be accurate.
     * </p>
     * <p>
     * To calculate altitude differences, you must calculate the difference
     * between the altitudes at both points. If you don't know the altitude
     * as sea level, you can use {@link #PRESSURE_STANDARD_ATMOSPHERE} instead,
     * which will give good results considering the range of pressure typically
     * involved.
     * </p>
     * <p>
     * <code><ul>
     *  float altitude_difference =
     *      getAltitude(SensorManager.PRESSURE_STANDARD_ATMOSPHERE, pressure_at_point2)
     *      - getAltitude(SensorManager.PRESSURE_STANDARD_ATMOSPHERE, pressure_at_point1);
     * </ul></code>
     * </p>
     *
     * @param p0 pressure at sea level
     * @param p atmospheric pressure
     * @return Altitude in meters
     */
   @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.056 -0500", hash_original_method = "8E6E2A16641CB1071F07CC6C84B1A29D", hash_generated_method = "D7502A3FF04FED1BC8DD49FCBA47C0F0")
    
public static float getAltitude(float p0, float p) {
        final float coef = 1.0f / 5.255f;
        return 44330.0f * (1.0f - (float)Math.pow(p/p0, coef));
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.061 -0500", hash_original_method = "14C63D8E207B99EF2DEBC9C5BACA5384", hash_generated_method = "891234789498953B63D3A0AEE094E837")
    
static int getRotation() {
        synchronized(sListeners) {
            return sRotation;
        }
    }

    /** Helper function to compute the angle change between two rotation matrices.
     *  Given a current rotation matrix (R) and a previous rotation matrix
     *  (prevR) computes the rotation around the x,y, and z axes which
     *  transforms prevR to R.
     *  outputs a 3 element vector containing the x,y, and z angle
     *  change at indexes 0, 1, and 2 respectively.
     * <p> Each input matrix is either as a 3x3 or 4x4 row-major matrix
     * depending on the length of the passed array:
     * <p>If the array length is 9, then the array elements represent this matrix
     * <pre>
     *   /  R[ 0]   R[ 1]   R[ 2]   \
     *   |  R[ 3]   R[ 4]   R[ 5]   |
     *   \  R[ 6]   R[ 7]   R[ 8]   /
     *</pre>
     * <p>If the array length is 16, then the array elements represent this matrix
     * <pre>
     *   /  R[ 0]   R[ 1]   R[ 2]   R[ 3]  \
     *   |  R[ 4]   R[ 5]   R[ 6]   R[ 7]  |
     *   |  R[ 8]   R[ 9]   R[10]   R[11]  |
     *   \  R[12]   R[13]   R[14]   R[15]  /
     *</pre>
     * @param R current rotation matrix
     * @param prevR previous rotation matrix
     * @param angleChange an array of floats in which the angle change is stored
     */

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.136 -0500", hash_original_method = "8B9F6F99770AC610A78817CE4E6CAD01", hash_generated_method = "DA05D51C781FC5B8E1C100A7D07F55C5")
    
public static void getAngleChange( float[] angleChange, float[] R, float[] prevR) {
        float rd1=0,rd4=0, rd6=0,rd7=0, rd8=0;
        float ri0=0,ri1=0,ri2=0,ri3=0,ri4=0,ri5=0,ri6=0,ri7=0,ri8=0;
        float pri0=0, pri1=0, pri2=0, pri3=0, pri4=0, pri5=0, pri6=0, pri7=0, pri8=0;
        int i, j, k;

        if(R.length == 9) {
            ri0 = R[0];
            ri1 = R[1];
            ri2 = R[2];
            ri3 = R[3];
            ri4 = R[4];
            ri5 = R[5];
            ri6 = R[6];
            ri7 = R[7];
            ri8 = R[8];
        } else if(R.length == 16) {
            ri0 = R[0];
            ri1 = R[1];
            ri2 = R[2];
            ri3 = R[4];
            ri4 = R[5];
            ri5 = R[6];
            ri6 = R[8];
            ri7 = R[9];
            ri8 = R[10];
        }

        if(prevR.length == 9) {
            pri0 = prevR[0];
            pri1 = prevR[1];
            pri2 = prevR[2];
            pri3 = prevR[3];
            pri4 = prevR[4];
            pri5 = prevR[5];
            pri6 = prevR[6];
            pri7 = prevR[7];
            pri8 = prevR[8];
        } else if(prevR.length == 16) {
            pri0 = prevR[0];
            pri1 = prevR[1];
            pri2 = prevR[2];
            pri3 = prevR[4];
            pri4 = prevR[5];
            pri5 = prevR[6];
            pri6 = prevR[8];
            pri7 = prevR[9];
            pri8 = prevR[10];
        }

        // calculate the parts of the rotation difference matrix we need
        // rd[i][j] = pri[0][i] * ri[0][j] + pri[1][i] * ri[1][j] + pri[2][i] * ri[2][j];

        rd1 = pri0 * ri1 + pri3 * ri4 + pri6 * ri7; //rd[0][1]
        rd4 = pri1 * ri1 + pri4 * ri4 + pri7 * ri7; //rd[1][1]
        rd6 = pri2 * ri0 + pri5 * ri3 + pri8 * ri6; //rd[2][0]
        rd7 = pri2 * ri1 + pri5 * ri4 + pri8 * ri7; //rd[2][1]
        rd8 = pri2 * ri2 + pri5 * ri5 + pri8 * ri8; //rd[2][2]

        angleChange[0] = (float)Math.atan2(rd1, rd4);
        angleChange[1] = (float)Math.asin(-rd7);
        angleChange[2] = (float)Math.atan2(-rd6, rd8);

    }

    /** Helper function to convert a rotation vector to a rotation matrix.
     *  Given a rotation vector (presumably from a ROTATION_VECTOR sensor), returns a
     *  9  or 16 element rotation matrix in the array R.  R must have length 9 or 16.
     *  If R.length == 9, the following matrix is returned:
     * <pre>
     *   /  R[ 0]   R[ 1]   R[ 2]   \
     *   |  R[ 3]   R[ 4]   R[ 5]   |
     *   \  R[ 6]   R[ 7]   R[ 8]   /
     *</pre>
     * If R.length == 16, the following matrix is returned:
     * <pre>
     *   /  R[ 0]   R[ 1]   R[ 2]   0  \
     *   |  R[ 4]   R[ 5]   R[ 6]   0  |
     *   |  R[ 8]   R[ 9]   R[10]   0  |
     *   \  0       0       0       1  /
     *</pre>
     *  @param rotationVector the rotation vector to convert
     *  @param R an array of floats in which to store the rotation matrix
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.141 -0500", hash_original_method = "3DB3B83767C3E6A9B01AB274AC444879", hash_generated_method = "E7F235E6710EC91A1B9F031414035CE8")
    
public static void getRotationMatrixFromVector(float[] R, float[] rotationVector) {

        float q0;
        float q1 = rotationVector[0];
        float q2 = rotationVector[1];
        float q3 = rotationVector[2];

        if (rotationVector.length == 4) {
            q0 = rotationVector[3];
        } else {
            q0 = 1 - q1*q1 - q2*q2 - q3*q3;
            q0 = (q0 > 0) ? (float)Math.sqrt(q0) : 0;
        }

        float sq_q1 = 2 * q1 * q1;
        float sq_q2 = 2 * q2 * q2;
        float sq_q3 = 2 * q3 * q3;
        float q1_q2 = 2 * q1 * q2;
        float q3_q0 = 2 * q3 * q0;
        float q1_q3 = 2 * q1 * q3;
        float q2_q0 = 2 * q2 * q0;
        float q2_q3 = 2 * q2 * q3;
        float q1_q0 = 2 * q1 * q0;

        if(R.length == 9) {
            R[0] = 1 - sq_q2 - sq_q3;
            R[1] = q1_q2 - q3_q0;
            R[2] = q1_q3 + q2_q0;

            R[3] = q1_q2 + q3_q0;
            R[4] = 1 - sq_q1 - sq_q3;
            R[5] = q2_q3 - q1_q0;

            R[6] = q1_q3 - q2_q0;
            R[7] = q2_q3 + q1_q0;
            R[8] = 1 - sq_q1 - sq_q2;
        } else if (R.length == 16) {
            R[0] = 1 - sq_q2 - sq_q3;
            R[1] = q1_q2 - q3_q0;
            R[2] = q1_q3 + q2_q0;
            R[3] = 0.0f;

            R[4] = q1_q2 + q3_q0;
            R[5] = 1 - sq_q1 - sq_q3;
            R[6] = q2_q3 - q1_q0;
            R[7] = 0.0f;

            R[8] = q1_q3 - q2_q0;
            R[9] = q2_q3 + q1_q0;
            R[10] = 1 - sq_q1 - sq_q2;
            R[11] = 0.0f;

            R[12] = R[13] = R[14] = 0.0f;
            R[15] = 1.0f;
        }
    }

    /** Helper function to convert a rotation vector to a normalized quaternion.
     *  Given a rotation vector (presumably from a ROTATION_VECTOR sensor), returns a normalized
     *  quaternion in the array Q.  The quaternion is stored as [w, x, y, z]
     *  @param rv the rotation vector to convert
     *  @param Q an array of floats in which to store the computed quaternion
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.144 -0500", hash_original_method = "E42DD1F670DB7ECCA034D643DAC17008", hash_generated_method = "98D073E2E19CF9FB680FC2B559C5C6F5")
    
public static void getQuaternionFromVector(float[] Q, float[] rv) {
        if (rv.length == 4) {
            Q[0] = rv[3];
        } else {
            Q[0] = 1 - rv[0]*rv[0] - rv[1]*rv[1] - rv[2]*rv[2];
            Q[0] = (Q[0] > 0) ? (float)Math.sqrt(Q[0]) : 0;
        }
        Q[1] = rv[0];
        Q[2] = rv[1];
        Q[3] = rv[2];
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeClassInit() {  //Formerly a native method
		//Noop
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int sensors_module_init() {  //Formerly a native method
		return 0;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int sensors_module_get_next_sensor(Sensor sensor, int next) { //Formerly a native method
		return 0;
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static int sensors_create_queue() {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_712978663 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_712978663;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static void sensors_destroy_queue(int queue) {
    }
    
	@DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static boolean sensors_enable_sensor(int queue, String name, int sensor, int enable) {
		//Formerly a native method.  Generated a very simple stub.
		return (toTaintBoolean(queue + name.length() + sensor + enable));
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static int sensors_data_poll(int queue, float[] values, int[] status, long[] timestamp) {
        values[0] = queue;
        status[0] = queue;
        timestamp[0] = queue;
        return (int)(queue + values.getTaintInt() + status.getTaintInt() + timestamp.getTaintInt());
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.670 -0500", hash_original_field = "70463D03D9E458FAC8FA89B5DDDB34B7", hash_generated_field = "D46DC572C2EFA3216DE38441F1A6F061")

    private static final String TAG = "SensorManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.673 -0500", hash_original_field = "82575E594CABCCFA4367F2EA8C55107A", hash_generated_field = "FCB5327581E18710CDCDFFB10CC66C83")

    private static final float[] mTempMatrix = new float[16];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.676 -0500", hash_original_field = "7E2C4804440171BD36FEDD5BB2831735", hash_generated_field = "A0DE0A8A0FC5776ACAE714CB5CB82A30")

    /**
     * A constant describing an orientation sensor. See
     * {@link android.hardware.SensorListener SensorListener} for more details.
     *
     * @deprecated use {@link android.hardware.Sensor Sensor} instead.
     */
    @Deprecated
    public static final int SENSOR_ORIENTATION = 1 << 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.679 -0500", hash_original_field = "3BD30AAF24905C769AE7279A6C52F8AF", hash_generated_field = "19414CED4FA72491B85F493F8AFF63B8")

    @Deprecated
    public static final int SENSOR_ACCELEROMETER = 1 << 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.681 -0500", hash_original_field = "AB6AEC7A926F249ADF25E76099632822", hash_generated_field = "3C2362FF7C126F067910E2BCCF1EDCD7")

    @Deprecated
    public static final int SENSOR_TEMPERATURE = 1 << 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.684 -0500", hash_original_field = "336C681EB7AC47459CFC262DDECB51E9", hash_generated_field = "9238F3C8D08D015AF0853B89AD78AFB6")

    @Deprecated
    public static final int SENSOR_MAGNETIC_FIELD = 1 << 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.687 -0500", hash_original_field = "1B90AC8E04A44B00FE02551A8B02C300", hash_generated_field = "0E321C5D1567C957A91304082C18D404")

    @Deprecated
    public static final int SENSOR_LIGHT = 1 << 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.691 -0500", hash_original_field = "B77BE225A00B477533CD49D5478BF6C6", hash_generated_field = "98A64C2F6E579F9CD66D58F1C82DC056")

    @Deprecated
    public static final int SENSOR_PROXIMITY = 1 << 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.694 -0500", hash_original_field = "58AE2C243B87C25F0A0EB8AFAEEDF0E9", hash_generated_field = "EE36B6630EA8165AC8F0F495DB61178C")

    @Deprecated
    public static final int SENSOR_TRICORDER = 1 << 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.696 -0500", hash_original_field = "EC4C8BA6CB49B85C1575936CBE93BD92", hash_generated_field = "37F85BDAD647215D01EBBDFF4549DA57")

    @Deprecated
    public static final int SENSOR_ORIENTATION_RAW = 1 << 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.699 -0500", hash_original_field = "F43145C04CE31F1C72DA60CA6DF802B1", hash_generated_field = "4CFF3B4F2A25C8651ED8E70AA89C2F52")

    @Deprecated
    public static final int SENSOR_ALL = 0x7F;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.702 -0500", hash_original_field = "C6A988D222ADEF7483D2831538854271", hash_generated_field = "02BF52AB62B9B0271AC3030C44199DCA")

    @Deprecated
    public static final int SENSOR_MIN = SENSOR_ORIENTATION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.705 -0500", hash_original_field = "C34A3B119165F4385D9CE63179D7BE30", hash_generated_field = "48907DD0332337C7F41FBC22BAD37F2C")

    @Deprecated
    public static final int SENSOR_MAX = ((SENSOR_ALL + 1)>>1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.708 -0500", hash_original_field = "030CE8654C1FC76557351D80CAEE6872", hash_generated_field = "A9AC5D766E2244D46793610E9BC9AF74")

    @Deprecated
    public static final int DATA_X = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.711 -0500", hash_original_field = "D5B74E27C037FFE963921EC7095E7C00", hash_generated_field = "76993CCDC259CB3593B45E118CC14227")

    @Deprecated
    public static final int DATA_Y = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.714 -0500", hash_original_field = "C74A5A1753C5FE1AEAEFCCEF565CCD34", hash_generated_field = "B1BA023EF03C57726C71339FD98E8727")

    @Deprecated
    public static final int DATA_Z = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.717 -0500", hash_original_field = "1E14CDF4F1AB67E96CBFD8D874735F66", hash_generated_field = "24BE7FB5178190074444287EE659C8D4")

    @Deprecated
    public static final int RAW_DATA_INDEX = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.719 -0500", hash_original_field = "496C3A60C2167E24606B3907FF17BD6D", hash_generated_field = "A2C6FB458B3AEA3A9E8F6B34EBB801A3")

    @Deprecated
    public static final int RAW_DATA_X = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.722 -0500", hash_original_field = "49F8330E5755C004F4909D713AA941AB", hash_generated_field = "31BD80CB85213EDFB1B6363D6C309F09")

    @Deprecated
    public static final int RAW_DATA_Y = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.725 -0500", hash_original_field = "D98F608007447D9BC34FA8777F683E64", hash_generated_field = "A4105335D9B0E187F4624C5923397873")

    @Deprecated
    public static final int RAW_DATA_Z = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.727 -0500", hash_original_field = "D1546F1F14C4F148FCC710883E43DA0E", hash_generated_field = "E677BD9FA81EE77A42D6C83D3FCA7A4B")

    public static final float STANDARD_GRAVITY = 9.80665f;
    
    private class SensorEventPool {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.872 -0500", hash_original_field = "0B96CD9DFF232155CFA3C38B1074C08A", hash_generated_field = "845BC6592821AED77B94BBB0FC4DDA9D")

        private  int mPoolSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.875 -0500", hash_original_field = "B20E0CEC2ACB1C65BA346CEB5911ED5E", hash_generated_field = "EE1301E693311ED21AE794595E0520C9")

        private  SensorEvent mPool[];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.878 -0500", hash_original_field = "60C19ED150C3C07DB080119547F7C421", hash_generated_field = "3D0F60AFB8892A60CC0726A46DE3F85F")

        private int mNumItemsInPool;
        
        SensorEventPool(int poolSize) {
			addTaint(poolSize);
            mPoolSize = poolSize;
            mNumItemsInPool = poolSize;
            mPool = new SensorEvent[poolSize];
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.881 -0500", hash_original_method = "7237223B63C43177AB2849F160B99FEC", hash_generated_method = "9A7CB8B1C3376E5E12F2795B6006575B")
        
private SensorEvent createSensorEvent() {
            // maximal size for all legacy events is 3
            return new SensorEvent(3);
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.888 -0500", hash_original_method = "91BAA7B0EF8F8AB0DA2081F8E926B4FD", hash_generated_method = "CDF0E9A5B31422BAAA42CC13D50BE134")
        
SensorEvent getFromPool() {
            SensorEvent t = null;
            synchronized (this) {
                if (mNumItemsInPool > 0) {
                    // remove the "top" item from the pool
                    final int index = mPoolSize - mNumItemsInPool;
                    t = mPool[index];
                    mPool[index] = null;
                    mNumItemsInPool--;
                }
            }
            if (t == null) {
                // the pool was empty or this item was removed from the pool for
                // the first time. In any case, we need to create a new item.
                t = createSensorEvent();
            }
            return t;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.890 -0500", hash_original_method = "C46016A1870C47E495A9527702944C16", hash_generated_method = "696C4F051BD51B5ECA1B3799D3AE8046")
        
void returnToPool(SensorEvent t) {
            synchronized (this) {
                // is there space left in the pool?
                if (mNumItemsInPool < mPoolSize) {
                    // if so, return the item to the pool
                    mNumItemsInPool++;
                    final int index = mPoolSize - mNumItemsInPool;
                    mPool[index] = t;
                }
            }
        }
        
    }
    
    static private class SensorThread {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.900 -0500", hash_original_field = "8CE20653889294789C714060A391C40F", hash_generated_field = "8CE20653889294789C714060A391C40F")

        Thread mThread;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.902 -0500", hash_original_field = "08100F1ACCE57FCB9D4D360616E4C0FE", hash_generated_field = "08100F1ACCE57FCB9D4D360616E4C0FE")

        boolean mSensorsReady;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.905 -0500", hash_original_method = "900B05FC812E5D001EF6E5D26AE8C532", hash_generated_method = "900B05FC812E5D001EF6E5D26AE8C532")
        
SensorThread() {
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.909 -0500", hash_original_method = "3012BD4162FEB4D4063E0B4E3944BED9", hash_generated_method = "0B55AC57C8926FC3F550FAB2789DB92D")
        
@Override
        protected void finalize() {
        }

        // must be called with sListeners lock
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.912 -0500", hash_original_method = "9B9CC9DE22F3A6E67DD39AE0CF54ADF8", hash_generated_method = "9B9CC9DE22F3A6E67DD39AE0CF54ADF8")
        
boolean startLocked() {
            try {
                if (mThread == null) {
                    mSensorsReady = false;
                    SensorThreadRunnable runnable = new SensorThreadRunnable();
                    Thread thread = new Thread(runnable, SensorThread.class.getName());
                    thread.start();
                    synchronized (runnable) {
                        while (mSensorsReady == false) {
                            runnable.wait();
                        }
                    }
                    mThread = thread;
                }
            } catch (InterruptedException e) {
            }
            return mThread == null ? false : true;
        }
        
        private class SensorThreadRunnable implements Runnable {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.916 -0500", hash_original_method = "E6F9E1FFFEF800CB7D3BCE3C8792674F", hash_generated_method = "E6F9E1FFFEF800CB7D3BCE3C8792674F")
            
SensorThreadRunnable() {
            }

            @DSComment("Private Method")
            @DSBan(DSCat.PRIVATE_METHOD)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.919 -0500", hash_original_method = "8D69A6F3F762D5CCB4AA9AA134EC788D", hash_generated_method = "D751A65F76DDDCD600A043C869FE1B40")
            
private boolean open() {
                // NOTE: this cannot synchronize on sListeners, since
                // it's held in the main thread at least until we
                // return from here.
                sQueue = sensors_create_queue();
                return true;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.925 -0500", hash_original_method = "22D645F37E8BABB44C20A553228E0A5C", hash_generated_method = "22F4AAED4CF9ABF792C121D35EEB6DB4")
            
public void run() {
                //Log.d(TAG, "entering main sensor thread");
                final float[] values = new float[3];
                final int[] status = new int[1];
                final long timestamp[] = new long[1];
                Process.setThreadPriority(Process.THREAD_PRIORITY_URGENT_DISPLAY);

                if (!open()) {
                    return;
                }

                synchronized (this) {
                    // we've open the driver, we're ready to open the sensors
                    mSensorsReady = true;
                    this.notify();
                }

                while (true) {
                    // wait for an event
                    final int sensor = sensors_data_poll(sQueue, values, status, timestamp);

                    int accuracy = status[0];
                    synchronized (sListeners) {
                        if (sensor == -1 || sListeners.isEmpty()) {
                            // we lost the connection to the event stream. this happens
                            // when the last listener is removed or if there is an error
                            if (sensor == -1 && !sListeners.isEmpty()) {
                                // log a warning in case of abnormal termination
                                Log.e(TAG, "_sensors_data_poll() failed, we bail out: sensors=" + sensor);
                            }
                            // we have no more listeners or polling failed, terminate the thread
                            sensors_destroy_queue(sQueue);
                            sQueue = 0;
                            mThread = null;
                            break;
                        }
                        final Sensor sensorObject = sHandleToSensor.get(sensor);
                        if (sensorObject != null) {
                            // report the sensor event to all listeners that
                            // care about it.
                            final int size = sListeners.size();
                            for (int i=0 ; i<size ; i++) {
                                ListenerDelegate listener = sListeners.get(i);
                                if (listener.hasSensor(sensorObject)) {
                                    // this is asynchronous (okay to call
                                    // with sListeners lock held).
                                    listener.onSensorChangedLocked(sensorObject,
                                            values, timestamp, accuracy);
                                }
                            }
                        }
                    }
                }
                //Log.d(TAG, "exiting main sensor thread");
            }
            
        }
        
    }
    
    private class ListenerDelegate {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.933 -0500", hash_original_field = "DA0D09A56B45B5F18D80D9C6B8BA2BC0", hash_generated_field = "7CDF70F92784BF2F50B0C9C6E0D50D7E")

        private  SensorEventListener mSensorEventListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.935 -0500", hash_original_field = "2184C23B907203D5476570158F323AAB", hash_generated_field = "EA873B4B64DB82DE247512BA02A4C250")

        private final ArrayList<Sensor> mSensorList = new ArrayList<Sensor>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.939 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private  Handler mHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.942 -0500", hash_original_field = "CA595C2AC92E25529C00242DFAE52656", hash_generated_field = "07735EE29000B01D7B06726363C9CD51")

        public SparseBooleanArray mSensors = new SparseBooleanArray();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.944 -0500", hash_original_field = "8B7C3808BECF7B9A476FF89C5E7742CF", hash_generated_field = "2B2A7DE406F5691574493DA0CEC8A36F")

        public SparseBooleanArray mFirstEvent = new SparseBooleanArray();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.946 -0500", hash_original_field = "1934A70CAEDFCEE033C274E6C086DD81", hash_generated_field = "6E81EC263127AF97C52C45F2AB5DE4E7")

        public SparseIntArray mSensorAccuracies = new SparseIntArray();

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.954 -0500", hash_original_method = "5F32B99D810AC43D96375634E0119DDB", hash_generated_method = "455DF615F4C35FA2571A75EEF791FE3E")
        
ListenerDelegate(SensorEventListener listener, Sensor sensor, Handler handler) {
            mSensorEventListener = listener;
            Looper looper = (handler != null) ? handler.getLooper() : mMainLooper;
            // currently we create one Handler instance per listener, but we could
            // have one per looper (we'd need to pass the ListenerDelegate
            // instance to handleMessage and keep track of them separately).
            mHandler = new Handler(looper) {
                @Override
                public void handleMessage(Message msg) {
                    final SensorEvent t = (SensorEvent)msg.obj;
                    final int handle = t.sensor.getHandle();

                    switch (t.sensor.getType()) {
                        // Only report accuracy for sensors that support it.
                        case Sensor.TYPE_MAGNETIC_FIELD:
                        case Sensor.TYPE_ORIENTATION:
                            // call onAccuracyChanged() only if the value changes
                            final int accuracy = mSensorAccuracies.get(handle);
                            if ((t.accuracy >= 0) && (accuracy != t.accuracy)) {
                                mSensorAccuracies.put(handle, t.accuracy);
                                mSensorEventListener.onAccuracyChanged(t.sensor, t.accuracy);
                            }
                            break;
                        default:
                            // For other sensors, just report the accuracy once
                            if (mFirstEvent.get(handle) == false) {
                                mFirstEvent.put(handle, true);
                                mSensorEventListener.onAccuracyChanged(
                                        t.sensor, SENSOR_STATUS_ACCURACY_HIGH);
                            }
                            break;
                    }

                    mSensorEventListener.onSensorChanged(t);
                    sPool.returnToPool(t);
                }
            };
            addSensor(sensor);
        }
        
        // orphaned legacy method
        private ListenerDelegate() {
			mSensorEventListener = null;
		}

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.956 -0500", hash_original_method = "02DCCE55D13DD3643E30DA559E9BDE85", hash_generated_method = "02DCCE55D13DD3643E30DA559E9BDE85")
        
Object getListener() {
            return mSensorEventListener;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.959 -0500", hash_original_method = "B2FBA8302C1585AE96282F4E3DA295C6", hash_generated_method = "B2FBA8302C1585AE96282F4E3DA295C6")
        
void addSensor(Sensor sensor) {
            mSensors.put(sensor.getHandle(), true);
            mSensorList.add(sensor);
        }
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.961 -0500", hash_original_method = "262A581E44AC35F2D9F50EC370F0EA9A", hash_generated_method = "262A581E44AC35F2D9F50EC370F0EA9A")
        
int removeSensor(Sensor sensor) {
            mSensors.delete(sensor.getHandle());
            mSensorList.remove(sensor);
            return mSensors.size();
        }
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.964 -0500", hash_original_method = "5A86EBC59444E6C07690511EA8C8466D", hash_generated_method = "5A86EBC59444E6C07690511EA8C8466D")
        
boolean hasSensor(Sensor sensor) {
            return mSensors.get(sensor.getHandle());
        }
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.967 -0500", hash_original_method = "DA37BCA933FDDA4900146E3A50CD9005", hash_generated_method = "DA37BCA933FDDA4900146E3A50CD9005")
        
List<Sensor> getSensors() {
            return mSensorList;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.969 -0500", hash_original_method = "16733F3375BBFC31BBB88791653112DA", hash_generated_method = "16733F3375BBFC31BBB88791653112DA")
        
void onSensorChangedLocked(Sensor sensor, float[] values, long[] timestamp, int accuracy) {
            SensorEvent t = sPool.getFromPool();
            final float[] v = t.values;
            v[0] = values[0];
            v[1] = values[1];
            v[2] = values[2];
            t.timestamp = timestamp[0];
            t.accuracy = accuracy;
            t.sensor = sensor;
            Message msg = Message.obtain();
            msg.what = 0;
            msg.obj = t;
            mHandler.sendMessage(msg);
        }
        
    }
    
    private class LegacyListener implements SensorEventListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.064 -0500", hash_original_field = "2E436FBDD820B5DD767FF627A4256884", hash_generated_field = "B920C0767E790BC8A809EAECA2930561")

        private float mValues[] = new float[6];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.067 -0500", hash_original_field = "2355EBE9ED4B6DE0B89A474DD5088FFD", hash_generated_field = "C800818392D79FD320EB62250F8EBEC5")

        @SuppressWarnings("deprecation")
        private SensorListener mTarget;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.069 -0500", hash_original_field = "20846F64498C3D40AACE3386D069B618", hash_generated_field = "56793FD343ADA798CA50C026B1054688")

        private int mSensors;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.071 -0500", hash_original_field = "9C5DA461BC22BF27620686E4E1DE78B0", hash_generated_field = "7423027F5055567C2CEE13EBCD7D43EF")

        private final LmsFilter mYawfilter = new LmsFilter();

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.074 -0500", hash_original_method = "A655EEB442CA31096C7FBEA03DE93B9D", hash_generated_method = "3BF57EE36163C82569B53B48F9DB2485")
        
@SuppressWarnings("deprecation")
        LegacyListener(SensorListener target) {
            mTarget = target;
            mSensors = 0;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.077 -0500", hash_original_method = "4097E1683A40A6DEAB5492A2296E3879", hash_generated_method = "4097E1683A40A6DEAB5492A2296E3879")
        
void registerSensor(int legacyType) {
            mSensors |= legacyType;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.080 -0500", hash_original_method = "737F8C4556D577A83A29D9000B85627C", hash_generated_method = "737F8C4556D577A83A29D9000B85627C")
        
boolean unregisterSensor(int legacyType) {
            mSensors &= ~legacyType;
            int mask = SENSOR_ORIENTATION|SENSOR_ORIENTATION_RAW;
            if (((legacyType&mask)!=0) && ((mSensors&mask)!=0)) {
                return false;
            }
            return true;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.085 -0500", hash_original_method = "E64F8429635EF9F3222DE4609CE00D63", hash_generated_method = "FA00D9D1552D778DEA40C006FD6803C4")
        
@SuppressWarnings("deprecation")
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            try {
                mTarget.onAccuracyChanged(sensor.getLegacyType(), accuracy);
            } catch (AbstractMethodError e) {
                // old app that doesn't implement this method
                // just ignore it.
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.091 -0500", hash_original_method = "7B74886508DCBDDEB63A3DDB570295F3", hash_generated_method = "B343CE4D45AC9AC463FB58C5FEF47D1C")
        
@SuppressWarnings("deprecation")
        public void onSensorChanged(SensorEvent event) {
            final float v[] = mValues;
            v[0] = event.values[0];
            v[1] = event.values[1];
            v[2] = event.values[2];
            int legacyType = event.sensor.getLegacyType();
            mapSensorDataToWindow(legacyType, v, SensorManager.getRotation());
            if (event.sensor.getType() == Sensor.TYPE_ORIENTATION) {
                if ((mSensors & SENSOR_ORIENTATION_RAW)!=0) {
                    mTarget.onSensorChanged(SENSOR_ORIENTATION_RAW, v);
                }
                if ((mSensors & SENSOR_ORIENTATION)!=0) {
                    v[0] = mYawfilter.filter(event.timestamp, v[0]);
                    mTarget.onSensorChanged(SENSOR_ORIENTATION, v);
                }
            } else {
                mTarget.onSensorChanged(legacyType, v);
            }
        }

        /*
         * Helper function to convert the specified sensor's data to the windows's
         * coordinate space from the device's coordinate space.
         *
         * output: 3,4,5: values in the old API format
         *         0,1,2: transformed values in the old API format
         *
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.096 -0500", hash_original_method = "7A14D827894C3DC6FC1EC81B36F33A0A", hash_generated_method = "422B16C51048EE2E71C673F07F55597F")
        
private void mapSensorDataToWindow(int sensor,
                float[] values, int orientation) {
            float x = values[0];
            float y = values[1];
            float z = values[2];

            switch (sensor) {
                case SensorManager.SENSOR_ORIENTATION:
                case SensorManager.SENSOR_ORIENTATION_RAW:
                    z = -z;
                    break;
                case SensorManager.SENSOR_ACCELEROMETER:
                    x = -x;
                    y = -y;
                    z = -z;
                    break;
                case SensorManager.SENSOR_MAGNETIC_FIELD:
                    x = -x;
                    y = -y;
                    break;
            }
            values[0] = x;
            values[1] = y;
            values[2] = z;
            values[3] = x;
            values[4] = y;
            values[5] = z;

            if ((orientation & Surface.ROTATION_90) != 0) {
                // handles 90 and 270 rotation
                switch (sensor) {
                    case SENSOR_ACCELEROMETER:
                    case SENSOR_MAGNETIC_FIELD:
                        values[0] =-y;
                        values[1] = x;
                        values[2] = z;
                        break;
                    case SENSOR_ORIENTATION:
                    case SENSOR_ORIENTATION_RAW:
                        values[0] = x + ((x < 270) ? 90 : -270);
                        values[1] = z;
                        values[2] = y;
                        break;
                }
            }
            if ((orientation & Surface.ROTATION_180) != 0) {
                x = values[0];
                y = values[1];
                z = values[2];
                // handles 180 (flip) and 270 (flip + 90) rotation
                switch (sensor) {
                    case SENSOR_ACCELEROMETER:
                    case SENSOR_MAGNETIC_FIELD:
                        values[0] =-x;
                        values[1] =-y;
                        values[2] = z;
                        break;
                    case SENSOR_ORIENTATION:
                    case SENSOR_ORIENTATION_RAW:
                        values[0] = (x >= 180) ? (x - 180) : (x + 180);
                        values[1] =-y;
                        values[2] =-z;
                        break;
                }
            }
        }
        
    }
    
    class LmsFilter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.104 -0500", hash_original_field = "AE642BD24B30C3C139354DE3F04260BB", hash_generated_field = "289D3DCA2BB33F6334CDC99A63CB75B6")

        private static final int SENSORS_RATE_MS = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.109 -0500", hash_original_field = "CCFE3657BF30AC191919FEF1783BAAEE", hash_generated_field = "C613FE5DFDEE80ED430FEA7D721F3ABA")

        private static final int COUNT = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.112 -0500", hash_original_field = "2A193026DAA710A000D97845B3B1B716", hash_generated_field = "49D85FA4CF718BD5A4B3FDA8A3714C4E")

        private static final float PREDICTION_RATIO = 1.0f/3.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.114 -0500", hash_original_field = "4315B4155FF299A6D69CB8004A791F4F", hash_generated_field = "81506F4C7994EEC27376AE73597A30EB")

        private static final float PREDICTION_TIME = (SENSORS_RATE_MS*COUNT/1000.0f)*PREDICTION_RATIO;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.117 -0500", hash_original_field = "90FF5F3C98A879E55C5E80DE00936295", hash_generated_field = "C71ED6AA46070A985BB77E25625E8D40")

        private float mV[] = new float[COUNT*2];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.120 -0500", hash_original_field = "6FC6C43FFF4AF4FC8CE2277C690B9B2F", hash_generated_field = "454D11A3BEF77C99F353661B016C1D43")

        private float mT[] = new float[COUNT*2];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.123 -0500", hash_original_field = "3FE793BBC68255EAC5B3588E7DE2E2C6", hash_generated_field = "B8B828CADFFAE7A5A771AAB7A1527A20")

        private int mIndex;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.126 -0500", hash_original_method = "E02C377CCDCA56F06C1373683AAA5F27", hash_generated_method = "F5EC9EDE7E9B8C66412CBECF88A35AEB")
        
public LmsFilter() {
            mIndex = COUNT;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.129 -0500", hash_original_method = "EF62ACDA1EDD9BA52B9A6B99F58CD8F6", hash_generated_method = "3B29D397FABA54012913718FFB2B0DD8")
        
public float filter(long time, float in) {
            float v = in;
            final float ns = 1.0f / 1000000000.0f;
            final float t = time*ns;
            float v1 = mV[mIndex];
            if ((v-v1) > 180) {
                v -= 360;
            } else if ((v1-v) > 180) {
                v += 360;
            }
            /* Manage the circular buffer, we write the data twice spaced
             * by COUNT values, so that we don't have to copy the array
             * when it's full
             */
            mIndex++;
            if (mIndex >= COUNT*2)
                mIndex = COUNT;
            mV[mIndex] = v;
            mT[mIndex] = t;
            mV[mIndex-COUNT] = v;
            mT[mIndex-COUNT] = t;

            float A, B, C, D, E;
            float a, b;
            int i;

            A = B = C = D = E = 0;
            for (i=0 ; i<COUNT-1 ; i++) {
                final int j = mIndex - 1 - i;
                final float Z = mV[j];
                final float T = 0.5f*(mT[j] + mT[j+1]) - t;
                float dT = mT[j] - mT[j+1];
                dT *= dT;
                A += Z*dT;
                B += T*(T*dT);
                C +=   (T*dT);
                D += Z*(T*dT);
                E += dT;
            }
            b = (A*B + C*D) / (E*B + C*C);
            a = (E*b - A) / C;
            float f = b + PREDICTION_TIME*a;

            // Normalize
            f *= (1.0f / 360.0f);
            if (((f>=0)?f:-f) >= 0.5f)
                f = f - (float)Math.ceil(f + 0.5f) + 1.0f;
            if (f < 0)
                f += 1.0f;
            f *= 360.0f;
            return f;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.731 -0500", hash_original_field = "BC90407BA24759368DB6502F07B8E50D", hash_generated_field = "7DFB37D1E3A2A36A3E756E4105637B67")

    public static final float GRAVITY_SUN             = 275.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.734 -0500", hash_original_field = "04E57A220AC338E127A1ABF74125DECE", hash_generated_field = "49E30115EE56C7C9C31EF2637CCCDFC5")

    public static final float GRAVITY_MERCURY         = 3.70f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.738 -0500", hash_original_field = "2EA220FCB9247F71B7E689E95891DE46", hash_generated_field = "AB9A7548046B9BF51CB962118DCA6151")

    public static final float GRAVITY_VENUS           = 8.87f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.740 -0500", hash_original_field = "1A16BF868E2A8B3B2B00E8224536DAF7", hash_generated_field = "6F33579BCEBFC3579E1DD27C36753C71")

    public static final float GRAVITY_EARTH           = 9.80665f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.743 -0500", hash_original_field = "611DD04D2CFB605F5C687AE8D1C21633", hash_generated_field = "1FE0A959605FC1FAF77D69C67BFDC3BE")

    public static final float GRAVITY_MOON            = 1.6f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.748 -0500", hash_original_field = "E9FC955FF179A2BAAE1F5B4E1A4F6082", hash_generated_field = "2B17FA2A3C55F1F38A6124E59337C061")

    public static final float GRAVITY_MARS            = 3.71f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.752 -0500", hash_original_field = "37AD56D060552EE3978AAEEB1D8FF939", hash_generated_field = "73FD09FCDD1A7BCCC2B000AD68B58807")

    public static final float GRAVITY_JUPITER         = 23.12f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.755 -0500", hash_original_field = "D59E9850A67B9F05A69B4E63184D926E", hash_generated_field = "8D4E50FE00223ED202335CC88DA303A3")

    public static final float GRAVITY_SATURN          = 8.96f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.758 -0500", hash_original_field = "9D50A593EC4603652D21C59EF593FBF4", hash_generated_field = "12102A9D8CFFE04151CFD7073BB79258")

    public static final float GRAVITY_URANUS          = 8.69f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.762 -0500", hash_original_field = "8220228CB7942FB9DC0A984ED209FD09", hash_generated_field = "E673030DEC6B6CA64CDACFFE50927C22")

    public static final float GRAVITY_NEPTUNE         = 11.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.764 -0500", hash_original_field = "B96F11D200CCBC3878D6FFC5B60831FB", hash_generated_field = "3BB701AC05D98480880F7FCAE6D3014C")

    public static final float GRAVITY_PLUTO           = 0.6f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.767 -0500", hash_original_field = "E2C383932C6A58BD91371F73BE62EB35", hash_generated_field = "03051E3DC5786D7CF1D464F068BD1BB4")

    public static final float GRAVITY_DEATH_STAR_I    = 0.000000353036145f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.769 -0500", hash_original_field = "CA456A487188D433A4300A698999F3CE", hash_generated_field = "E52FA1DC3A5B4CFE9963B2BDDA041697")

    public static final float GRAVITY_THE_ISLAND      = 4.815162342f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.772 -0500", hash_original_field = "66955E68601FFA24100B4D75FC438926", hash_generated_field = "1F1D70384C09D59F42D38B16133845CE")

    public static final float MAGNETIC_FIELD_EARTH_MAX = 60.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.774 -0500", hash_original_field = "5399AF7A47AACD94BD0FE9A8F90590F9", hash_generated_field = "68DAB024C15BA1D077DE1B93007B509C")

    public static final float MAGNETIC_FIELD_EARTH_MIN = 30.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.777 -0500", hash_original_field = "6C870DFE7D5ECA89D0193ABF85368F62", hash_generated_field = "60B956375CABAA5A38520D232A65B625")

    public static final float PRESSURE_STANDARD_ATMOSPHERE = 1013.25f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.780 -0500", hash_original_field = "0140598F3588B4321AA557E1DEDC241C", hash_generated_field = "605D89F0BFF38A6E37EBEB6F08AEDF44")

    public static final float LIGHT_SUNLIGHT_MAX = 120000.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.782 -0500", hash_original_field = "6BE8486E684AAAEB04BBCA377300640F", hash_generated_field = "9A674B69EB6FB611C967FFBBDE8223D9")

    public static final float LIGHT_SUNLIGHT     = 110000.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.785 -0500", hash_original_field = "349994F0600549DAA67B0587C09CC4F3", hash_generated_field = "6BB4816214FD8859745E9C80F7494836")

    public static final float LIGHT_SHADE        = 20000.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.787 -0500", hash_original_field = "375725007591F50989B04488EAF0BF90", hash_generated_field = "C5A4E7A988335CAA4F0F517EE5EF0D37")

    public static final float LIGHT_OVERCAST     = 10000.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.791 -0500", hash_original_field = "0207BFA088CFBE9AA04C526A56AAB965", hash_generated_field = "F5A221C1278C6E88B02A299F37E4C30A")

    public static final float LIGHT_SUNRISE      = 400.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.794 -0500", hash_original_field = "237E23AA890BD36CEA61C864F9F33C7A", hash_generated_field = "B6A4154BC1F854EDF3EEDB64CA76D406")

    public static final float LIGHT_CLOUDY       = 100.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.796 -0500", hash_original_field = "1B1BF9BAE051F00603C5146A870FA144", hash_generated_field = "547BE1973329E70E3558646E76316249")

    public static final float LIGHT_FULLMOON     = 0.25f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.798 -0500", hash_original_field = "64AC05B8E0E7ABD39C3BD5FB09715CAB", hash_generated_field = "AA692E072FB30E0F7EB38E4F82C0839E")

    public static final float LIGHT_NO_MOON      = 0.001f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.801 -0500", hash_original_field = "E33D418A757D8C23CC4C3980FB7BD0B0", hash_generated_field = "9E8D453CFCBB64FDBAC4894075F651FA")

    public static final int SENSOR_DELAY_FASTEST = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.803 -0500", hash_original_field = "AC5C12B8F2AB3942FDDA2A3F883A05E6", hash_generated_field = "B1EA2DD8A518D8B936090226F48D8CFA")

    public static final int SENSOR_DELAY_GAME = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.806 -0500", hash_original_field = "BBC666CF8C73D71ADCBA9DA5494263CB", hash_generated_field = "34CB384FEDB81178485444F2DF81E938")

    public static final int SENSOR_DELAY_UI = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.808 -0500", hash_original_field = "BDAA4D1FF10E9C044DAC5D81B2AD6155", hash_generated_field = "ACB21A0A585352CC21D7D912BD549396")

    public static final int SENSOR_DELAY_NORMAL = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.811 -0500", hash_original_field = "C1F6233D1CCDC3D0C641211E245D0FD7", hash_generated_field = "793474660C061F4E91B691854E0C0210")

    public static final int SENSOR_STATUS_UNRELIABLE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.814 -0500", hash_original_field = "40CCB4C8EB5174643DF67A1421449D4A", hash_generated_field = "3F2964151ACC9B0BA71471A94E89BA79")

    public static final int SENSOR_STATUS_ACCURACY_LOW = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.817 -0500", hash_original_field = "7410345E8E6BCDD898F58A2E5E8E5C45", hash_generated_field = "8281325EE294F56AC1F2FD20E0D435FD")

    public static final int SENSOR_STATUS_ACCURACY_MEDIUM = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.820 -0500", hash_original_field = "0236851E645144C779BB38DD07793CFF", hash_generated_field = "1631007B616B86584B93182CCFA5F767")

    public static final int SENSOR_STATUS_ACCURACY_HIGH = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.823 -0500", hash_original_field = "933B1BFF45C90D5D876DC36633480AF9", hash_generated_field = "6D9F2A6D7916944793A0E02EE9DAC11A")

    public static final int AXIS_X = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.826 -0500", hash_original_field = "4C3D4D22CF97B39EDAA5F89DCF42BF17", hash_generated_field = "C26BE798D392A2035397D2CCF263856A")

    public static final int AXIS_Y = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.829 -0500", hash_original_field = "89F683683BD8DF3FFCA4B9A5A785E612", hash_generated_field = "99DB4EB9E499DC8FD3F2A6667C2A655F")

    public static final int AXIS_Z = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.832 -0500", hash_original_field = "705EDF815C234AABB12D763A95E29945", hash_generated_field = "3F3B6B92E6A1B2949A1EA7FCEDD211D6")

    public static final int AXIS_MINUS_X = AXIS_X | 0x80;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.835 -0500", hash_original_field = "92F6BEC0B720AEF7237D26AF110B6586", hash_generated_field = "256747ACA3A6B7781B5CC10FE1504A89")

    public static final int AXIS_MINUS_Y = AXIS_Y | 0x80;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.838 -0500", hash_original_field = "0728531671D221FA40E2FF9307BABAAD", hash_generated_field = "6A8882357B156DD35296D89B47D4D0E6")

    public static final int AXIS_MINUS_Z = AXIS_Z | 0x80;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.845 -0500", hash_original_field = "3A8EF2E0FE3F53F483877DA766E705E6", hash_generated_field = "0B37599A21C0B41121A764FFBD9EADED")

    private static final int SENSOR_DISABLE = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.847 -0500", hash_original_field = "37A81B3FE5155C44FD558B83628C65EA", hash_generated_field = "239E704B77E2A22CC375A94A4D19171C")

    private static boolean sSensorModuleInitialized = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.850 -0500", hash_original_field = "D4333A755CE7E1BDB11716C3EC2CBB2C", hash_generated_field = "B57A3B1812D8F35DF7BF04190BDD96FA")

    private static ArrayList<Sensor> sFullSensorsList = new ArrayList<Sensor>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.853 -0500", hash_original_field = "A603347377D27E70D573E6D009328529", hash_generated_field = "25CA1152319FF4B5C0D7E7F8076D16ED")

    private static SparseArray<List<Sensor>> sSensorListByType = new SparseArray<List<Sensor>>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.857 -0500", hash_original_field = "F8394A0A868CD62A3B859D8862E95ED4", hash_generated_field = "9FFB1E54F186971CA192F7BE25683B37")

    private static IWindowManager sWindowManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.859 -0500", hash_original_field = "8DDEEB0EF8344C706B44A290D2DE18A4", hash_generated_field = "0BBAD8D916700BAD614C4C1F4378A2FE")

    private static int sRotation = Surface.ROTATION_0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.862 -0500", hash_original_field = "F6B334BE1778E99F4EA1A7110FABEB20", hash_generated_field = "A8490936AB367117DB9EB37709DAADF2")

    private static SensorThread sSensorThread;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.864 -0500", hash_original_field = "47EBB544FE1BFEDB5F6E1CDE70F1739C", hash_generated_field = "085EF692D1F4F5696051F009EDF77397")

    private static int sQueue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.867 -0500", hash_original_field = "F5EEA15C28AC44E53A6518D3A47CC595", hash_generated_field = "BCFD400BB8D3E8AD87E27FCB7A4C3151")

    static SparseArray<Sensor> sHandleToSensor = new SparseArray<Sensor>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.869 -0500", hash_original_field = "4FB8DC205C79809A287973D78A1F71E7", hash_generated_field = "65AB8B1411F9486973328C8F78BB86A3")

    static final ArrayList<ListenerDelegate> sListeners =
        new ArrayList<ListenerDelegate>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.897 -0500", hash_original_field = "83C95BE42F985C78660A3F043DB1C2A2", hash_generated_field = "15CA115588C710DFD7C46B04856CF02D")

    private static SensorEventPool sPool;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.840 -0500", hash_original_field = "22AA67C96F8F7AD7DFD89E53DF216F9A", hash_generated_field = "22AA67C96F8F7AD7DFD89E53DF216F9A")

    Looper mMainLooper;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.842 -0500", hash_original_field = "D7D5A1F785EF215E867A24EB8A82EC5F", hash_generated_field = "0F9F236B24164523848440F1C5249FC1")

    @SuppressWarnings("deprecation")
    private HashMap<SensorListener, LegacyListener> mLegacyListenersMap =
        new HashMap<SensorListener, LegacyListener>();
    
	public SensorManager(Looper mainLooper) {
		/*
		 * The rest of the original implementation is simply setting
		 * up some internal state managed in private variables.  This   
		 * functionality will be commented out for now as it isn't necessary
		 */
        mMainLooper = mainLooper;
        synchronized(sListeners) {
            if (!sSensorModuleInitialized) {
                sSensorModuleInitialized = true;
                nativeClassInit();
                sWindowManager = IWindowManager.Stub.asInterface(
                        ServiceManager.getService("window"));
                if (sWindowManager != null) {
                    // if it's null we're running in the system process
                    // which won't get the rotated values
                    try {
                        sRotation = sWindowManager.watchRotation(
                                new IRotationWatcher.Stub() {
                                    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.975 -0500", hash_original_method = "BE005D6720C412EC6EF9D753DC3A6572", hash_generated_method = "772AAFB03B0C2BA8B6FB689CF7E94C52")
                            
public void onRotationChanged(int rotation) {
                                        SensorManager.this.onRotationChanged(rotation);
                                    }
                                }
                        );
                    } catch (RemoteException e) {
                    }
                }
                // initialize the sensor list
                sensors_module_init();
                final ArrayList<Sensor> fullList = sFullSensorsList;
                int i = 0;
                do {
                    Sensor sensor = new Sensor();
                    i = sensors_module_get_next_sensor(sensor, i);
                    if (i>=0) {
                        //Log.d(TAG, "found sensor: " + sensor.getName() +
                        //        ", handle=" + sensor.getHandle());
                        sensor.setLegacyType(getLegacySensorType(sensor.getType()));
                        fullList.add(sensor);
                        sHandleToSensor.append(sensor.getHandle(), sensor);
                    }
                } while (i>0);
                sPool = new SensorEventPool( sFullSensorsList.size()*2 );
                sSensorThread = new SensorThread();
            }
        }
    }
    
    // orphaned legacy method
    
	public SensorManager() {
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private int getLegacySensorType(int type) {
		/*
        switch (type) {
            case Sensor.TYPE_ACCELEROMETER:
                return SENSOR_ACCELEROMETER;
            case Sensor.TYPE_MAGNETIC_FIELD:
                return SENSOR_MAGNETIC_FIELD;
            case Sensor.TYPE_ORIENTATION:
                return SENSOR_ORIENTATION_RAW;
            case Sensor.TYPE_TEMPERATURE:
                return SENSOR_TEMPERATURE;
        }
        */
        return 0;
    }

    /**
     * @return available sensors.
     * @deprecated This method is deprecated, use
     *             {@link SensorManager#getSensorList(int)} instead
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.983 -0500", hash_original_method = "9387EF1577B9728CF6A87474164955A1", hash_generated_method = "DCEA3E6A9BE2244BFDB501B6A5CEBD04")
    
@Deprecated
    public int getSensors() {
        int result = 0;
        final ArrayList<Sensor> fullList = sFullSensorsList;
        for (Sensor i : fullList) {
            switch (i.getType()) {
                case Sensor.TYPE_ACCELEROMETER:
                    result |= SensorManager.SENSOR_ACCELEROMETER;
                    break;
                case Sensor.TYPE_MAGNETIC_FIELD:
                    result |= SensorManager.SENSOR_MAGNETIC_FIELD;
                    break;
                case Sensor.TYPE_ORIENTATION:
                    result |= SensorManager.SENSOR_ORIENTATION |
                    SensorManager.SENSOR_ORIENTATION_RAW;
                    break;
            }
        }
        return result;
    }

    /**
     * Use this method to get the list of available sensors of a certain type.
     * Make multiple calls to get sensors of different types or use
     * {@link android.hardware.Sensor#TYPE_ALL Sensor.TYPE_ALL} to get all the
     * sensors.
     *
     * @param type
     *        of sensors requested
     *
     * @return a list of sensors matching the asked type.
     *
     * @see #getDefaultSensor(int)
     * @see Sensor
     */
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.987 -0500", hash_original_method = "D388F11CBE90143BC36FA3E001809013", hash_generated_method = "A24E18E8BD8A929CC1A4EAD97C533099")
    
public List<Sensor> getSensorList(int type) {
        // cache the returned lists the first time
        List<Sensor> list;
        final ArrayList<Sensor> fullList = sFullSensorsList;
        synchronized(fullList) {
            list = sSensorListByType.get(type);
            if (list == null) {
                if (type == Sensor.TYPE_ALL) {
                    list = fullList;
                } else {
                    list = new ArrayList<Sensor>();
                    for (Sensor i : fullList) {
                        if (i.getType() == type)
                            list.add(i);
                    }
                }
                list = Collections.unmodifiableList(list);
                sSensorListByType.append(type, list);
            }
        }
        return list;
    }

    /**
     * Registers a listener for given sensors.
     *
     * @deprecated This method is deprecated, use
     *             {@link SensorManager#registerListener(SensorEventListener, Sensor, int)}
     *             instead.
     *
     * @param listener
     *        sensor listener object
     *
     * @param sensors
     *        a bit masks of the sensors to register to
     *
     * @return <code>true</code> if the sensor is supported and successfully
     *         enabled
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.993 -0500", hash_original_method = "CA10DA2A107C571495F28D1A1A335E4D", hash_generated_method = "39A71066D52410B1B2BC40D185752AD1")
    
@Deprecated
@DSVerified
@DSSafe(DSCat.ANDROID_CALLBACK)
    public boolean registerListener(SensorListener listener, int sensors) {
        return registerListener(listener, sensors, SENSOR_DELAY_NORMAL);
    }

    /**
     * Registers a SensorListener for given sensors.
     *
     * @deprecated This method is deprecated, use
     *             {@link SensorManager#registerListener(SensorEventListener, Sensor, int)}
     *             instead.
     *
     * @param listener
     *        sensor listener object
     *
     * @param sensors
     *        a bit masks of the sensors to register to
     *
     * @param rate
     *        rate of events. This is only a hint to the system. events may be
     *        received faster or slower than the specified rate. Usually events
     *        are received faster. The value must be one of
     *        {@link #SENSOR_DELAY_NORMAL}, {@link #SENSOR_DELAY_UI},
     *        {@link #SENSOR_DELAY_GAME}, or {@link #SENSOR_DELAY_FASTEST}.
     *
     * @return <code>true</code> if the sensor is supported and successfully
     *         enabled
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:52.997 -0500", hash_original_method = "B7C7A7F6BC1EDB860C06401873DD1A46", hash_generated_method = "4FB1B4808455BC8EEEEFC2E684C7D21F")
    
@Deprecated
@DSVerified
@DSSafe(DSCat.ANDROID_CALLBACK)
    public boolean registerListener(SensorListener listener, int sensors, int rate) {
        if (listener == null) {
            return false;
        }
        boolean result = false;
        result = registerLegacyListener(SENSOR_ACCELEROMETER, Sensor.TYPE_ACCELEROMETER,
                listener, sensors, rate) || result;
        result = registerLegacyListener(SENSOR_MAGNETIC_FIELD, Sensor.TYPE_MAGNETIC_FIELD,
                listener, sensors, rate) || result;
        result = registerLegacyListener(SENSOR_ORIENTATION_RAW, Sensor.TYPE_ORIENTATION,
                listener, sensors, rate) || result;
        result = registerLegacyListener(SENSOR_ORIENTATION, Sensor.TYPE_ORIENTATION,
                listener, sensors, rate) || result;
        result = registerLegacyListener(SENSOR_TEMPERATURE, Sensor.TYPE_TEMPERATURE,
                listener, sensors, rate) || result;
        return result;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.000 -0500", hash_original_method = "2BFEE9499E6BC093763ECA6BB97D348E", hash_generated_method = "0A172544D63FABEAA281C3E511794BD9")
    
@SuppressWarnings("deprecation")
    private boolean registerLegacyListener(int legacyType, int type,
            SensorListener listener, int sensors, int rate)
    {
        if (listener == null) {
            return false;
        }
        boolean result = false;
        // Are we activating this legacy sensor?
        if ((sensors & legacyType) != 0) {
            // if so, find a suitable Sensor
            Sensor sensor = getDefaultSensor(type);
            if (sensor != null) {
                // If we don't already have one, create a LegacyListener
                // to wrap this listener and process the events as
                // they are expected by legacy apps.
                LegacyListener legacyListener = null;
                synchronized (mLegacyListenersMap) {
                    legacyListener = mLegacyListenersMap.get(listener);
                    if (legacyListener == null) {
                        // we didn't find a LegacyListener for this client,
                        // create one, and put it in our list.
                        legacyListener = new LegacyListener(listener);
                        mLegacyListenersMap.put(listener, legacyListener);
                    }
                }
                // register this legacy sensor with this legacy listener
                legacyListener.registerSensor(legacyType);
                // and finally, register the legacy listener with the new apis
                result = registerListener(legacyListener, sensor, rate);
            }
        }
        return result;
    }

    /**
     * Unregisters a listener for the sensors with which it is registered.
     *
     * @deprecated This method is deprecated, use
     *             {@link SensorManager#unregisterListener(SensorEventListener, Sensor)}
     *             instead.
     *
     * @param listener
     *        a SensorListener object
     *
     * @param sensors
     *        a bit masks of the sensors to unregister from
     */
    @DSComment("potential callback called inside method")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.004 -0500", hash_original_method = "08C00AEC5C2F4A8557AFE56DD5038FAA", hash_generated_method = "F6900602A78D362DC13AF520AEF4FB59")
    
@Deprecated
    public void unregisterListener(SensorListener listener, int sensors) {
        unregisterLegacyListener(SENSOR_ACCELEROMETER, Sensor.TYPE_ACCELEROMETER,
                listener, sensors);
        unregisterLegacyListener(SENSOR_MAGNETIC_FIELD, Sensor.TYPE_MAGNETIC_FIELD,
                listener, sensors);
        unregisterLegacyListener(SENSOR_ORIENTATION_RAW, Sensor.TYPE_ORIENTATION,
                listener, sensors);
        unregisterLegacyListener(SENSOR_ORIENTATION, Sensor.TYPE_ORIENTATION,
                listener, sensors);
        unregisterLegacyListener(SENSOR_TEMPERATURE, Sensor.TYPE_TEMPERATURE,
                listener, sensors);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.008 -0500", hash_original_method = "9C431FA18D1D7C546E542BF96DE5A08A", hash_generated_method = "9A93F874B8D01166E3042BF0CDD9B098")
    
@SuppressWarnings("deprecation")
    private void unregisterLegacyListener(int legacyType, int type,
            SensorListener listener, int sensors)
    {
        if (listener == null) {
            return;
        }
        // do we know about this listener?
        LegacyListener legacyListener = null;
        synchronized (mLegacyListenersMap) {
            legacyListener = mLegacyListenersMap.get(listener);
        }
        if (legacyListener != null) {
            // Are we deactivating this legacy sensor?
            if ((sensors & legacyType) != 0) {
                // if so, find the corresponding Sensor
                Sensor sensor = getDefaultSensor(type);
                if (sensor != null) {
                    // unregister this legacy sensor and if we don't
                    // need the corresponding Sensor, unregister it too
                    if (legacyListener.unregisterSensor(legacyType)) {
                        // corresponding sensor not needed, unregister
                        unregisterListener(legacyListener, sensor);
                        // finally check if we still need the legacyListener
                        // in our mapping, if not, get rid of it too.
                        synchronized(sListeners) {
                            boolean found = false;
                            for (ListenerDelegate i : sListeners) {
                                if (i.getListener() == legacyListener) {
                                    found = true;
                                    break;
                                }
                            }
                            if (!found) {
                                synchronized (mLegacyListenersMap) {
                                    mLegacyListenersMap.remove(listener);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Unregisters a listener for all sensors.
     *
     * @deprecated This method is deprecated, use
     *             {@link SensorManager#unregisterListener(SensorEventListener)}
     *             instead.
     *
     * @param listener
     *        a SensorListener object
     */
    @DSComment("potential callback called inside method")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.010 -0500", hash_original_method = "F024191DD75DA5578F802D33C834CE8F", hash_generated_method = "C7791D999DC6F94D97BA856FF8908E2A")
    
@Deprecated
    public void unregisterListener(SensorListener listener) {
        unregisterListener(listener, SENSOR_ALL | SENSOR_ORIENTATION_RAW);
    }

    /**
     * Unregisters a listener for the sensors with which it is registered.
     *
     * @param listener
     *        a SensorEventListener object
     *
     * @param sensor
     *        the sensor to unregister from
     *
     * @see #unregisterListener(SensorEventListener)
     * @see #registerListener(SensorEventListener, Sensor, int)
     *
     */
    @DSComment("no action when removing callback")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.013 -0500", hash_original_method = "A245758148D9D81E2CADBC67CD903CC7", hash_generated_method = "097D859FD01791F8FF42C752BCE68E9A")
    @DSVerified
    
public void unregisterListener(SensorEventListener listener, Sensor sensor) {
        unregisterListener((Object)listener, sensor);
    }

    /**
     * Unregisters a listener for all sensors.
     *
     * @param listener
     *        a SensorListener object
     *
     * @see #unregisterListener(SensorEventListener, Sensor)
     * @see #registerListener(SensorEventListener, Sensor, int)
     *
     */
    @DSComment("no action when removing callback")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.016 -0500", hash_original_method = "C9A0C02866BC64B5017A48A301526982", hash_generated_method = "66E71156F28D2F602815D9F161A4681D")
    @DSVerified
    
public void unregisterListener(SensorEventListener listener) {
        unregisterListener((Object)listener);
    }
    
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public boolean registerListener(SensorEventListener listener, Sensor sensor, int rate) {
		SensorEvent se = new SensorEvent(0);
		se.sensor = sensor;
		listener.onSensorChanged(se);
		return true;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.021 -0500", hash_original_method = "500C86ADE6AA4F4A0E12D1A653386772", hash_generated_method = "019D3C8F47177FABD670184275A3E36A")
    
private boolean enableSensorLocked(Sensor sensor, int delay) {
        boolean result = false;
        for (ListenerDelegate i : sListeners) {
            if (i.hasSensor(sensor)) {
                String name = sensor.getName();
                int handle = sensor.getHandle();
                result = sensors_enable_sensor(sQueue, name, handle, delay);
                break;
            }
        }
        return result;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.023 -0500", hash_original_method = "4F96C2E0F6181D20ADA1404B28BE0C37", hash_generated_method = "22AA7206629BAC95DE6C6CC9D8F1CB9A")
    
private boolean disableSensorLocked(Sensor sensor) {
        for (ListenerDelegate i : sListeners) {
            if (i.hasSensor(sensor)) {
                // not an error, it's just that this sensor is still in use
                return true;
            }
        }
        String name = sensor.getName();
        int handle = sensor.getHandle();
        return sensors_enable_sensor(sQueue, name, handle, SENSOR_DISABLE);
    }

    /**
     * Registers a {@link android.hardware.SensorEventListener
     * SensorEventListener} for the given sensor.
     *
     * @param listener
     *        A {@link android.hardware.SensorEventListener SensorEventListener}
     *        object.
     *
     * @param sensor
     *        The {@link android.hardware.Sensor Sensor} to register to.
     *
     * @param rate
     *        The rate {@link android.hardware.SensorEvent sensor events} are
     *        delivered at. This is only a hint to the system. Events may be
     *        received faster or slower than the specified rate. Usually events
     *        are received faster. The value must be one of
     *        {@link #SENSOR_DELAY_NORMAL}, {@link #SENSOR_DELAY_UI},
     *        {@link #SENSOR_DELAY_GAME}, or {@link #SENSOR_DELAY_FASTEST}.
     *        or, the desired delay between events in microsecond.
     *
     * @param handler
     *        The {@link android.os.Handler Handler} the
     *        {@link android.hardware.SensorEvent sensor events} will be
     *        delivered to.
     *
     * @return true if the sensor is supported and successfully enabled.
     *
     * @see #registerListener(SensorEventListener, Sensor, int)
     * @see #unregisterListener(SensorEventListener)
     * @see #unregisterListener(SensorEventListener, Sensor)
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.027 -0500", hash_original_method = "55FB0E0786574FCA30E9C20955CE2F64", hash_generated_method = "45B8D2B32CD34F888BBB1F5BE2D33E25")

    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
public boolean registerListener(SensorEventListener listener, Sensor sensor, int rate,
            Handler handler) {
        if (listener == null || sensor == null) {
            return false;
        }
        boolean result = true;
        int delay = -1;
        switch (rate) {
            case SENSOR_DELAY_FASTEST:
                delay = 0;
                break;
            case SENSOR_DELAY_GAME:
                delay = 20000;
                break;
            case SENSOR_DELAY_UI:
                delay = 66667;
                break;
            case SENSOR_DELAY_NORMAL:
                delay = 200000;
                break;
            default:
                delay = rate;
                break;
        }

        synchronized (sListeners) {
            // look for this listener in our list
            ListenerDelegate l = null;
            for (ListenerDelegate i : sListeners) {
                if (i.getListener() == listener) {
                    l = i;
                    break;
                }
            }

            // if we don't find it, add it to the list
            if (l == null) {
                l = new ListenerDelegate(listener, sensor, handler);
                sListeners.add(l);
                // if the list is not empty, start our main thread
                if (!sListeners.isEmpty()) {
                    if (sSensorThread.startLocked()) {
                        if (!enableSensorLocked(sensor, delay)) {
                            // oops. there was an error
                            sListeners.remove(l);
                            result = false;
                        }
                    } else {
                        // there was an error, remove the listener
                        sListeners.remove(l);
                        result = false;
                    }
                } else {
                    // weird, we couldn't add the listener
                    result = false;
                }
            } else {
                l.addSensor(sensor);
                if (!enableSensorLocked(sensor, delay)) {
                    // oops. there was an error
                    l.removeSensor(sensor);
                    result = false;
                }
            }
        }
        
        if (listener != null) {
            listener.onSensorChanged(new SensorEvent());
            listener.onAccuracyChanged(sensor, DSUtils.FAKE_INT);
        }

        return result;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.030 -0500", hash_original_method = "1441CD23D4F492BD7877A59C29F56827", hash_generated_method = "75D63A57BC3A695659B04E7BB1EA9D4F")
    @DSVerified
private void unregisterListener(Object listener, Sensor sensor) {
        if (listener == null || sensor == null) {
            return;
        }

        synchronized (sListeners) {
            final int size = sListeners.size();
            for (int i=0 ; i<size ; i++) {
                ListenerDelegate l = sListeners.get(i);
                if (l.getListener() == listener) {
                    if (l.removeSensor(sensor) == 0) {
                        // if we have no more sensors enabled on this listener,
                        // take it off the list.
                        sListeners.remove(i);
                    }
                    break;
                }
            }
            disableSensorLocked(sensor);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:53.033 -0500", hash_original_method = "63ADCF337C7E30C1A2DEC34D1892CFB3", hash_generated_method = "F2F57CDE3878B1AC334E0670F73C4E99")
    @DSVerified    
private void unregisterListener(Object listener) {
        if (listener == null) {
            return;
        }

        synchronized (sListeners) {
            final int size = sListeners.size();
            for (int i=0 ; i<size ; i++) {
                ListenerDelegate l = sListeners.get(i);
                if (l.getListener() == listener) {
                    sListeners.remove(i);
                    // disable all sensors for this listener
                    for (Sensor sensor : l.getSensors()) {
                        disableSensorLocked(sensor);
                    }
                    break;
                }
            }
        }
    }
    
    public void onRotationChanged(int rotation) {
        synchronized(sListeners) {
        	addTaint(rotation);
            sRotation  = rotation;
        }
    }
    // orphaned legacy method
    
	@DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public Sensor getDefaultSensor(int i) {
		return new Sensor(i);
	}
    
}

