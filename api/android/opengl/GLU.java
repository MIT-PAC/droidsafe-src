package android.opengl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.microedition.khronos.opengles.GL10;






public class GLU {

    /**
     * Return an error string from a GL or GLU error code.
     *
     * @param error - a GL or GLU error code.
     * @return the error string for the input error code, or NULL if the input
     *         was not a valid GL or GLU error code.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:31.582 -0500", hash_original_method = "3ABE2F316ECDFFD83FBC44153E87F595", hash_generated_method = "A2FC8AFF15470D95D80EA5B87B62A329")
    public static String gluErrorString(int error) {
        switch (error) {
        case GL10.GL_NO_ERROR:
            return "no error";
        case GL10.GL_INVALID_ENUM:
            return "invalid enum";
        case GL10.GL_INVALID_VALUE:
            return "invalid value";
        case GL10.GL_INVALID_OPERATION:
            return "invalid operation";
        case GL10.GL_STACK_OVERFLOW:
            return "stack overflow";
        case GL10.GL_STACK_UNDERFLOW:
            return "stack underflow";
        case GL10.GL_OUT_OF_MEMORY:
            return "out of memory";
        default:
            return null;
        }
    }

    /**
     * Define a viewing transformation in terms of an eye point, a center of
     * view, and an up vector.
     *
     * @param gl a GL10 interface
     * @param eyeX eye point X
     * @param eyeY eye point Y
     * @param eyeZ eye point Z
     * @param centerX center of view X
     * @param centerY center of view Y
     * @param centerZ center of view Z
     * @param upX up vector X
     * @param upY up vector Y
     * @param upZ up vector Z
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:31.583 -0500", hash_original_method = "E1F5217DF3769CB3D03EC18F545E133B", hash_generated_method = "18747120E5EC77DBCD3996A0DFF45257")
    public static void gluLookAt(GL10 gl, float eyeX, float eyeY, float eyeZ,
            float centerX, float centerY, float centerZ, float upX, float upY,
            float upZ) {

        float[] scratch = sScratch;
        synchronized(scratch) {
            Matrix.setLookAtM(scratch, 0, eyeX, eyeY, eyeZ, centerX, centerY, centerZ,
                    upX, upY, upZ);
            gl.glMultMatrixf(scratch, 0);
        }
    }

    /**
     * Set up a 2D orthographic projection matrix
     *
     * @param gl
     * @param left
     * @param right
     * @param bottom
     * @param top
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:31.584 -0500", hash_original_method = "516F308BCBD27D7CFD7DAEDE95CCF081", hash_generated_method = "B88CCE3E38D7C85BA2E6327BB09A86FE")
    public static void gluOrtho2D(GL10 gl, float left, float right,
            float bottom, float top) {
        gl.glOrthof(left, right, bottom, top, -1.0f, 1.0f);
    }

    /**
     * Set up a perspective projection matrix
     *
     * @param gl a GL10 interface
     * @param fovy specifies the field of view angle, in degrees, in the Y
     *        direction.
     * @param aspect specifies the aspect ration that determins the field of
     *        view in the x direction. The aspect ratio is the ratio of x
     *        (width) to y (height).
     * @param zNear specifies the distance from the viewer to the near clipping
     *        plane (always positive).
     * @param zFar specifies the distance from the viewer to the far clipping
     *        plane (always positive).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:31.585 -0500", hash_original_method = "9AF538E08B87A3ABF0DDE7BDDBBA91E2", hash_generated_method = "F2BF80FB629DF731008AB1848AA5E537")
    public static void gluPerspective(GL10 gl, float fovy, float aspect,
            float zNear, float zFar) {
        float top = zNear * (float) Math.tan(fovy * (Math.PI / 360.0));
        float bottom = -top;
        float left = bottom * aspect;
        float right = top * aspect;
        gl.glFrustumf(left, right, bottom, top, zNear, zFar);
    }

    /**
     * Map object coordinates into window coordinates. gluProject transforms the
     * specified object coordinates into window coordinates using model, proj,
     * and view. The result is stored in win.
     * <p>
     * Note that you can use the OES_matrix_get extension, if present, to get
     * the current modelView and projection matrices.
     *
     * @param objX object coordinates X
     * @param objY object coordinates Y
     * @param objZ object coordinates Z
     * @param model the current modelview matrix
     * @param modelOffset the offset into the model array where the modelview
     *        maxtrix data starts.
     * @param project the current projection matrix
     * @param projectOffset the offset into the project array where the project
     *        matrix data starts.
     * @param view the current view, {x, y, width, height}
     * @param viewOffset the offset into the view array where the view vector
     *        data starts.
     * @param win the output vector {winX, winY, winZ}, that returns the
     *        computed window coordinates.
     * @param winOffset the offset into the win array where the win vector data
     *        starts.
     * @return A return value of GL_TRUE indicates success, a return value of
     *         GL_FALSE indicates failure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:31.586 -0500", hash_original_method = "EEC212663EADADCD78540A87E501357F", hash_generated_method = "A36D94FB65933FB8D9C8978CB370655C")
    public static int gluProject(float objX, float objY, float objZ,
            float[] model, int modelOffset, float[] project, int projectOffset,
            int[] view, int viewOffset, float[] win, int winOffset) {
        float[] scratch = sScratch;
        synchronized(scratch) {
            final int M_OFFSET = 0; // 0..15
            final int V_OFFSET = 16; // 16..19
            final int V2_OFFSET = 20; // 20..23
            Matrix.multiplyMM(scratch, M_OFFSET, project, projectOffset,
                    model, modelOffset);

            scratch[V_OFFSET + 0] = objX;
            scratch[V_OFFSET + 1] = objY;
            scratch[V_OFFSET + 2] = objZ;
            scratch[V_OFFSET + 3] = 1.0f;

            Matrix.multiplyMV(scratch, V2_OFFSET,
                    scratch, M_OFFSET, scratch, V_OFFSET);

            float w = scratch[V2_OFFSET + 3];
            if (w == 0.0f) {
                return GL10.GL_FALSE;
            }

            float rw = 1.0f / w;

            win[winOffset] =
                    view[viewOffset] + view[viewOffset + 2]
                            * (scratch[V2_OFFSET + 0] * rw + 1.0f)
                            * 0.5f;
            win[winOffset + 1] =
                    view[viewOffset + 1] + view[viewOffset + 3]
                            * (scratch[V2_OFFSET + 1] * rw + 1.0f) * 0.5f;
            win[winOffset + 2] = (scratch[V2_OFFSET + 2] * rw + 1.0f) * 0.5f;
        }

        return GL10.GL_TRUE;
    }

    /**
     * Map window coordinates to object coordinates. gluUnProject maps the
     * specified window coordinates into object coordinates using model, proj,
     * and view. The result is stored in obj.
     * <p>
     * Note that you can use the OES_matrix_get extension, if present, to get
     * the current modelView and projection matrices.
     *
     * @param winX window coordinates X
     * @param winY window coordinates Y
     * @param winZ window coordinates Z
     * @param model the current modelview matrix
     * @param modelOffset the offset into the model array where the modelview
     *        maxtrix data starts.
     * @param project the current projection matrix
     * @param projectOffset the offset into the project array where the project
     *        matrix data starts.
     * @param view the current view, {x, y, width, height}
     * @param viewOffset the offset into the view array where the view vector
     *        data starts.
     * @param obj the output vector {objX, objY, objZ}, that returns the
     *        computed object coordinates.
     * @param objOffset the offset into the obj array where the obj vector data
     *        starts.
     * @return A return value of GL10.GL_TRUE indicates success, a return value
     *         of GL10.GL_FALSE indicates failure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:31.587 -0500", hash_original_method = "9E656F575164E75EE282031F44B3A846", hash_generated_method = "806483B9BF809EDA45E3F98ECBB0C618")
    public static int gluUnProject(float winX, float winY, float winZ,
            float[] model, int modelOffset, float[] project, int projectOffset,
            int[] view, int viewOffset, float[] obj, int objOffset) {
        float[] scratch = sScratch;
        synchronized(scratch) {
            final int PM_OFFSET = 0; // 0..15
            final int INVPM_OFFSET = 16; // 16..31
               final int V_OFFSET = 0; // 0..3 Reuses PM_OFFSET space
            Matrix.multiplyMM(scratch, PM_OFFSET, project, projectOffset,
                    model, modelOffset);

            if (!Matrix.invertM(scratch, INVPM_OFFSET, scratch, PM_OFFSET)) {
                return GL10.GL_FALSE;
            }

            scratch[V_OFFSET + 0] =
                    2.0f * (winX - view[viewOffset + 0]) / view[viewOffset + 2]
                            - 1.0f;
            scratch[V_OFFSET + 1] =
                    2.0f * (winY - view[viewOffset + 1]) / view[viewOffset + 3]
                            - 1.0f;
            scratch[V_OFFSET + 2] = 2.0f * winZ - 1.0f;
            scratch[V_OFFSET + 3] = 1.0f;

            Matrix.multiplyMV(obj, objOffset, scratch, INVPM_OFFSET,
                    scratch, V_OFFSET);
        }

        return GL10.GL_TRUE;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:31.588 -0500", hash_original_field = "0B653DD92412B1F46EE9BDC62D614682", hash_generated_field = "4C7E849CA192581CA2BD76D1C6206DA9")


    private static final float[] sScratch = new float[32];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.361 -0400", hash_original_method = "81777980E1C12E67D555E59C0A8957E0", hash_generated_method = "81777980E1C12E67D555E59C0A8957E0")
    public GLU ()
    {
        //Synthesized constructor
    }
}

