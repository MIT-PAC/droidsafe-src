package android.opengl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.Buffer;





import droidsafe.helpers.DSUtils;

public class GLES10 {


    @DSModeled(DSC.SAFE)
    private static void _nativeClassInit() {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glActiveTexture(
        int texture
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glAlphaFunc(
        int func,
        float ref
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glAlphaFuncx(
        int func,
        int ref
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glBindTexture(
        int target,
        int texture
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glBlendFunc(
        int sfactor,
        int dfactor
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glClear(
        int mask
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glClearColor(
        float red,
        float green,
        float blue,
        float alpha
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glClearColorx(
        int red,
        int green,
        int blue,
        int alpha
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glClearDepthf(
        float depth
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glClearDepthx(
        int depth
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glClearStencil(
        int s
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glClientActiveTexture(
        int texture
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glColor4f(
        float red,
        float green,
        float blue,
        float alpha
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glColor4x(
        int red,
        int green,
        int blue,
        int alpha
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glColorMask(
        boolean red,
        boolean green,
        boolean blue,
        boolean alpha
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void glColorPointerBounds(
        int size,
        int type,
        int stride,
        java.nio.Buffer pointer,
        int remaining
    ) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.390 -0500", hash_original_method = "BE0504B13DA269CA089182E44C7F834B", hash_generated_method = "E55C13D509154F4DE7354A9F83B5D0C9")
    public static void glColorPointer(
        int size,
        int type,
        int stride,
        java.nio.Buffer pointer
    ) {
        glColorPointerBounds(
            size,
            type,
            stride,
            pointer,
            pointer.remaining()
        );
        if ((size == 4) &&
            ((type == GL_FLOAT) ||
             (type == GL_UNSIGNED_BYTE) ||
             (type == GL_FIXED)) &&
            (stride >= 0)) {
            _colorPointer = pointer;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void glCompressedTexImage2D(
        int target,
        int level,
        int internalformat,
        int width,
        int height,
        int border,
        int imageSize,
        java.nio.Buffer data
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glCompressedTexSubImage2D(
        int target,
        int level,
        int xoffset,
        int yoffset,
        int width,
        int height,
        int format,
        int imageSize,
        java.nio.Buffer data
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glCopyTexImage2D(
        int target,
        int level,
        int internalformat,
        int x,
        int y,
        int width,
        int height,
        int border
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glCopyTexSubImage2D(
        int target,
        int level,
        int xoffset,
        int yoffset,
        int x,
        int y,
        int width,
        int height
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glCullFace(
        int mode
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glDeleteTextures(
        int n,
        int[] textures,
        int offset
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glDeleteTextures(
        int n,
        java.nio.IntBuffer textures
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glDepthFunc(
        int func
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glDepthMask(
        boolean flag
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glDepthRangef(
        float zNear,
        float zFar
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glDepthRangex(
        int zNear,
        int zFar
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glDisable(
        int cap
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glDisableClientState(
        int array
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glDrawArrays(
        int mode,
        int first,
        int count
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glDrawElements(
        int mode,
        int count,
        int type,
        java.nio.Buffer indices
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glEnable(
        int cap
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glEnableClientState(
        int array
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glFinish(
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glFlush(
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glFogf(
        int pname,
        float param
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glFogfv(
        int pname,
        float[] params,
        int offset
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glFogfv(
        int pname,
        java.nio.FloatBuffer params
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glFogx(
        int pname,
        int param
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glFogxv(
        int pname,
        int[] params,
        int offset
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glFogxv(
        int pname,
        java.nio.IntBuffer params
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glFrontFace(
        int mode
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glFrustumf(
        float left,
        float right,
        float bottom,
        float top,
        float zNear,
        float zFar
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glFrustumx(
        int left,
        int right,
        int bottom,
        int top,
        int zNear,
        int zFar
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glGenTextures(
        int n,
        int[] textures,
        int offset
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glGenTextures(
        int n,
        java.nio.IntBuffer textures
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static int glGetError(
    ) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_807932943 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_807932943;
    }

    
    @DSModeled(DSC.SAFE)
    public static void glGetIntegerv(
        int pname,
        int[] params,
        int offset
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glGetIntegerv(
        int pname,
        java.nio.IntBuffer params
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static String glGetString(int name) {
    	String s = new String();
    	s.addTaint(name);
    	return s;
    }

    
    @DSModeled(DSC.SAFE)
    public static void glHint(
        int target,
        int mode
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glLightModelf(
        int pname,
        float param
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glLightModelfv(
        int pname,
        float[] params,
        int offset
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glLightModelfv(
        int pname,
        java.nio.FloatBuffer params
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glLightModelx(
        int pname,
        int param
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glLightModelxv(
        int pname,
        int[] params,
        int offset
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glLightModelxv(
        int pname,
        java.nio.IntBuffer params
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glLightf(
        int light,
        int pname,
        float param
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glLightfv(
        int light,
        int pname,
        float[] params,
        int offset
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glLightfv(
        int light,
        int pname,
        java.nio.FloatBuffer params
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glLightx(
        int light,
        int pname,
        int param
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glLightxv(
        int light,
        int pname,
        int[] params,
        int offset
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glLightxv(
        int light,
        int pname,
        java.nio.IntBuffer params
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glLineWidth(
        float width
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glLineWidthx(
        int width
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glLoadIdentity(
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glLoadMatrixf(
        float[] m,
        int offset
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glLoadMatrixf(
        java.nio.FloatBuffer m
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glLoadMatrixx(
        int[] m,
        int offset
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glLoadMatrixx(
        java.nio.IntBuffer m
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glLogicOp(
        int opcode
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glMaterialf(
        int face,
        int pname,
        float param
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glMaterialfv(
        int face,
        int pname,
        float[] params,
        int offset
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glMaterialfv(
        int face,
        int pname,
        java.nio.FloatBuffer params
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glMaterialx(
        int face,
        int pname,
        int param
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glMaterialxv(
        int face,
        int pname,
        int[] params,
        int offset
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glMaterialxv(
        int face,
        int pname,
        java.nio.IntBuffer params
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glMatrixMode(
        int mode
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glMultMatrixf(
        float[] m,
        int offset
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glMultMatrixf(
        java.nio.FloatBuffer m
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glMultMatrixx(
        int[] m,
        int offset
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glMultMatrixx(
        java.nio.IntBuffer m
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glMultiTexCoord4f(
        int target,
        float s,
        float t,
        float r,
        float q
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glMultiTexCoord4x(
        int target,
        int s,
        int t,
        int r,
        int q
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glNormal3f(
        float nx,
        float ny,
        float nz
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glNormal3x(
        int nx,
        int ny,
        int nz
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void glNormalPointerBounds(
        int type,
        int stride,
        java.nio.Buffer pointer,
        int remaining
    ) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.489 -0500", hash_original_method = "B0279F28E501DAEA74F3B8688C94AB46", hash_generated_method = "E0CAD87B922D331AFE3559DD6604D76B")
    public static void glNormalPointer(
        int type,
        int stride,
        java.nio.Buffer pointer
    ) {
        glNormalPointerBounds(
            type,
            stride,
            pointer,
            pointer.remaining()
        );
        if (((type == GL_FLOAT) ||
             (type == GL_BYTE) ||
             (type == GL_SHORT) ||
             (type == GL_FIXED)) &&
            (stride >= 0)) {
            _normalPointer = pointer;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void glOrthof(
        float left,
        float right,
        float bottom,
        float top,
        float zNear,
        float zFar
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glOrthox(
        int left,
        int right,
        int bottom,
        int top,
        int zNear,
        int zFar
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glPixelStorei(
        int pname,
        int param
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glPointSize(
        float size
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glPointSizex(
        int size
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glPolygonOffset(
        float factor,
        float units
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glPolygonOffsetx(
        int factor,
        int units
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glPopMatrix(
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glPushMatrix(
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glReadPixels(
        int x,
        int y,
        int width,
        int height,
        int format,
        int type,
        java.nio.Buffer pixels
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glRotatef(
        float angle,
        float x,
        float y,
        float z
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glRotatex(
        int angle,
        int x,
        int y,
        int z
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glSampleCoverage(
        float value,
        boolean invert
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glSampleCoveragex(
        int value,
        boolean invert
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glScalef(
        float x,
        float y,
        float z
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glScalex(
        int x,
        int y,
        int z
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glScissor(
        int x,
        int y,
        int width,
        int height
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glShadeModel(
        int mode
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glStencilFunc(
        int func,
        int ref,
        int mask
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glStencilMask(
        int mask
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glStencilOp(
        int fail,
        int zfail,
        int zpass
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void glTexCoordPointerBounds(
        int size,
        int type,
        int stride,
        java.nio.Buffer pointer,
        int remaining
    ) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.522 -0500", hash_original_method = "76ED75F6FDC0A5E37C32F775B196CB2D", hash_generated_method = "71736D36A8BAB00E8122634E4F4DD41B")
    public static void glTexCoordPointer(
        int size,
        int type,
        int stride,
        java.nio.Buffer pointer
    ) {
        glTexCoordPointerBounds(
            size,
            type,
            stride,
            pointer,
            pointer.remaining()
        );
        if (((size == 2) ||
             (size == 3) ||
             (size == 4)) &&
            ((type == GL_FLOAT) ||
             (type == GL_BYTE) ||
             (type == GL_SHORT) ||
             (type == GL_FIXED)) &&
            (stride >= 0)) {
            _texCoordPointer = pointer;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void glTexEnvf(
        int target,
        int pname,
        float param
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glTexEnvfv(
        int target,
        int pname,
        float[] params,
        int offset
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glTexEnvfv(
        int target,
        int pname,
        java.nio.FloatBuffer params
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glTexEnvx(
        int target,
        int pname,
        int param
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glTexEnvxv(
        int target,
        int pname,
        int[] params,
        int offset
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glTexEnvxv(
        int target,
        int pname,
        java.nio.IntBuffer params
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glTexImage2D(
        int target,
        int level,
        int internalformat,
        int width,
        int height,
        int border,
        int format,
        int type,
        java.nio.Buffer pixels
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glTexParameterf(
        int target,
        int pname,
        float param
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glTexParameterx(
        int target,
        int pname,
        int param
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glTexSubImage2D(
        int target,
        int level,
        int xoffset,
        int yoffset,
        int width,
        int height,
        int format,
        int type,
        java.nio.Buffer pixels
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glTranslatef(
        float x,
        float y,
        float z
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void glTranslatex(
        int x,
        int y,
        int z
    ) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void glVertexPointerBounds(
        int size,
        int type,
        int stride,
        java.nio.Buffer pointer,
        int remaining
    ) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.541 -0500", hash_original_method = "EB50FBD03587D2E27B120FC4C1DFD2C5", hash_generated_method = "6E805E9FC023739AC027763D81FABB93")
    public static void glVertexPointer(
        int size,
        int type,
        int stride,
        java.nio.Buffer pointer
    ) {
        glVertexPointerBounds(
            size,
            type,
            stride,
            pointer,
            pointer.remaining()
        );
        if (((size == 2) ||
             (size == 3) ||
             (size == 4)) &&
            ((type == GL_FLOAT) ||
             (type == GL_BYTE) ||
             (type == GL_SHORT) ||
             (type == GL_FIXED)) &&
            (stride >= 0)) {
            _vertexPointer = pointer;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void glViewport(
        int x,
        int y,
        int width,
        int height
    ) {
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.158 -0500", hash_original_field = "E1161BA79B40F255CD8134C006DCB75B", hash_generated_field = "D27742AE443C6C6ED0F4E7EA8517EEEB")

    public static final int GL_ADD                                   = 0x0104;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.158 -0500", hash_original_field = "CC04B228955912ABA3215389FED65A0B", hash_generated_field = "8FCB0F04C33D33E10BECE828D721612F")

    public static final int GL_ALIASED_LINE_WIDTH_RANGE              = 0x846E;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.159 -0500", hash_original_field = "D23E522CA4824E747CD019155533B48C", hash_generated_field = "19883743E3CCB19994F89686F320722F")

    public static final int GL_ALIASED_POINT_SIZE_RANGE              = 0x846D;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.160 -0500", hash_original_field = "FFF5CB89CA98BAED11102950880EE41A", hash_generated_field = "EEC5ED5025D8B6C12C784EADC0C94480")

    public static final int GL_ALPHA                                 = 0x1906;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.161 -0500", hash_original_field = "0BD04B615D2994BAF855E0E27434C845", hash_generated_field = "C7AC3BCD060ADDD8CFBAE19F1D470C1E")

    public static final int GL_ALPHA_BITS                            = 0x0D55;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.162 -0500", hash_original_field = "6F291F781112E80A17A6EF3D47AB3D24", hash_generated_field = "38B6EF6729F7CD24CD574E54ED389ED0")

    public static final int GL_ALPHA_TEST                            = 0x0BC0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.163 -0500", hash_original_field = "EDFD8F9549373DC77F00008A1399E35B", hash_generated_field = "EC3E764163C9D8D7002C124025DD7ECB")

    public static final int GL_ALWAYS                                = 0x0207;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.164 -0500", hash_original_field = "AB14659A3FCFA8F20ACA468BE0C1DF9A", hash_generated_field = "07E89F7A5BAB3444FAE261B847A3C4BC")

    public static final int GL_AMBIENT                               = 0x1200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.164 -0500", hash_original_field = "E2F0E5D25C4601E8DEB2370768B8D0D8", hash_generated_field = "223F9BC6C497C82CA5718076B78FF908")

    public static final int GL_AMBIENT_AND_DIFFUSE                   = 0x1602;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.165 -0500", hash_original_field = "C4A80266C6BCBBEFBB91BBDF2C63531B", hash_generated_field = "BA9B3BD283E1C71AB295B485ECAA8836")

    public static final int GL_AND                                   = 0x1501;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.166 -0500", hash_original_field = "40AB1541D31881228892D2B5635A61EE", hash_generated_field = "5D04BC7CFF6DF830F48A2FCD555C8F36")

    public static final int GL_AND_INVERTED                          = 0x1504;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.167 -0500", hash_original_field = "21F56E193883D9858022C0BAA2F2292B", hash_generated_field = "1D57CA60396066A3389AE708DCA8DA5A")

    public static final int GL_AND_REVERSE                           = 0x1502;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.168 -0500", hash_original_field = "DBC720A258D1D52F03238794938A4584", hash_generated_field = "8D01D16E233D653B13BF35763F39094C")

    public static final int GL_BACK                                  = 0x0405;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.169 -0500", hash_original_field = "35610FBC5C341882519ECEC953D817D1", hash_generated_field = "B8047B6EFFF20A9163B2D267795697BD")

    public static final int GL_BLEND                                 = 0x0BE2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.169 -0500", hash_original_field = "8DF0B9E9F5FA5238FE8FAFE2A4CA6F6D", hash_generated_field = "F1A2269499DEFE7DF6523956BF443AA2")

    public static final int GL_BLUE_BITS                             = 0x0D54;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.170 -0500", hash_original_field = "9E4B0A571D2EED4C51981CCA7D4D69B7", hash_generated_field = "CA6B17F497DEA88919CF12FEF41C771D")

    public static final int GL_BYTE                                  = 0x1400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.171 -0500", hash_original_field = "664F37115AA5C42CD3C8607DACCE9706", hash_generated_field = "D90679929372A8D046997B2D0E27D061")

    public static final int GL_CCW                                   = 0x0901;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.172 -0500", hash_original_field = "857519BF45989933C8294B74805A89C8", hash_generated_field = "F4270B23DBE6E082C9F3F938AAE90031")

    public static final int GL_CLAMP_TO_EDGE                         = 0x812F;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.173 -0500", hash_original_field = "300321B9A5DFB1D51C6734FA8C7C8A02", hash_generated_field = "2E6DC39DD1868170030F558C041130BF")

    public static final int GL_CLEAR                                 = 0x1500;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.174 -0500", hash_original_field = "BBC7443E26849678D719AA9B74E84107", hash_generated_field = "8BDC411E2D9FAF4BECADB461B3B575FB")

    public static final int GL_COLOR_ARRAY                           = 0x8076;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.174 -0500", hash_original_field = "A6BEE1BFE4AB54A1CC720297AFB1E69E", hash_generated_field = "810CFD64F6256C5C1473DE92CB1814AE")

    public static final int GL_COLOR_BUFFER_BIT                      = 0x4000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.176 -0500", hash_original_field = "4B3CF104DD9B255D4B5AAC76E94D6D9D", hash_generated_field = "FB145914AFB2167EDE7E71018FC7321F")

    public static final int GL_COLOR_LOGIC_OP                        = 0x0BF2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.177 -0500", hash_original_field = "7648FEBCD13C5D7B8F8B3ED03B5BD14C", hash_generated_field = "B7EAE3253401931A3DD43C93FBCE8003")

    public static final int GL_COLOR_MATERIAL                        = 0x0B57;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.178 -0500", hash_original_field = "3C65E305EB9C422B8C41D812296B3952", hash_generated_field = "D2E69BE46D8601F3AC337E2E00FD3F7C")

    public static final int GL_COMPRESSED_TEXTURE_FORMATS            = 0x86A3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.179 -0500", hash_original_field = "2C46F849F79BFA3B5338300634F43838", hash_generated_field = "5868B334D97EB62CC4BC2B85FAAB0966")

    public static final int GL_CONSTANT_ATTENUATION                  = 0x1207;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.179 -0500", hash_original_field = "9768F102F2B28E4DFF0565A9DBC1371D", hash_generated_field = "A2BBD95B50BA674B8CCBB9435F5C4FAE")

    public static final int GL_COPY                                  = 0x1503;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.180 -0500", hash_original_field = "DF81F7A2CE79F8A3A3861414AE0DA8C0", hash_generated_field = "49183E3CB11DBDCAF1AC5BECCC5B7A45")

    public static final int GL_COPY_INVERTED                         = 0x150C;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.181 -0500", hash_original_field = "7490372009263C674F2FFF43612A874B", hash_generated_field = "9ABC6C59449029C0D07E4AB5037CCDA7")

    public static final int GL_CULL_FACE                             = 0x0B44;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.182 -0500", hash_original_field = "9B9C8CC921A30F76E5A85BE33BC5EFD4", hash_generated_field = "2C6DCD63CABB3C41ECC7B9014ED3B907")

    public static final int GL_CW                                    = 0x0900;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.183 -0500", hash_original_field = "C6A4F49BB6D3C8AD8BF4C11297E76896", hash_generated_field = "26696F0B6502F90FFA2DD38B033B8342")

    public static final int GL_DECAL                                 = 0x2101;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.184 -0500", hash_original_field = "D2F20C84A1C919A9C558275594323D3F", hash_generated_field = "5315E9E453BD796C61A0AB06DD8E6A52")

    public static final int GL_DECR                                  = 0x1E03;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.185 -0500", hash_original_field = "F1DB310DE09FD1581A3011C1A26135CD", hash_generated_field = "C23671D29990648AA3F86C9EB1C76CED")

    public static final int GL_DEPTH_BITS                            = 0x0D56;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.185 -0500", hash_original_field = "0996968BC8C79356E5BAC8A27E53B278", hash_generated_field = "CE5A7EEFA7A57362D3457C20E6FC6A41")

    public static final int GL_DEPTH_BUFFER_BIT                      = 0x0100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.186 -0500", hash_original_field = "D0F13481B1237405585629B11F088C2F", hash_generated_field = "FA6A17422F3B297267EDCBF88D16D4C5")

    public static final int GL_DEPTH_TEST                            = 0x0B71;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.187 -0500", hash_original_field = "1CE59C3BA4F77B155EC131CD7C89AEA6", hash_generated_field = "20E0F92169D8F2A08CC46924EE40A1E6")

    public static final int GL_DIFFUSE                               = 0x1201;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.188 -0500", hash_original_field = "973E1204B3D1DA59852E88B466F65A17", hash_generated_field = "55F31A3EBC84BD31DE876C99C319C524")

    public static final int GL_DITHER                                = 0x0BD0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.189 -0500", hash_original_field = "767F2D72D715CE4230C056184CC6A96E", hash_generated_field = "DCD1693386658F7795F0400387749F39")

    public static final int GL_DONT_CARE                             = 0x1100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.190 -0500", hash_original_field = "02EC0D013713BAD1AB69A75E3017F120", hash_generated_field = "EA877CAC2DCE84B662BEC6DE59F3F34C")

    public static final int GL_DST_ALPHA                             = 0x0304;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.191 -0500", hash_original_field = "4863C86C8D6BECBD02B1BF3834A8DA37", hash_generated_field = "16B27F3397CB1CE88331D5E0EC0490B7")

    public static final int GL_DST_COLOR                             = 0x0306;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.192 -0500", hash_original_field = "8493D37D10BE5947AAC0989A40A03238", hash_generated_field = "6C4F95B6EAF97800868FD6A760EBC895")

    public static final int GL_EMISSION                              = 0x1600;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.192 -0500", hash_original_field = "42E44886009387D44E4669B9CDEAF7DC", hash_generated_field = "92F53098599AA2DBF61CD4CBFE1E1026")

    public static final int GL_EQUAL                                 = 0x0202;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.193 -0500", hash_original_field = "83B7279B9E53876208D602D3A3ABF218", hash_generated_field = "1165864DAB653E46FDAF3AEF954F51C3")

    public static final int GL_EQUIV                                 = 0x1509;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.194 -0500", hash_original_field = "A78A2C9AD8D39A4BE2FF46054F82632E", hash_generated_field = "FEF69717A6DA6BDB60A5030EDA198E77")

    public static final int GL_EXP                                   = 0x0800;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.195 -0500", hash_original_field = "2D8DA6E5F13FD0C55B55612491B4E7EE", hash_generated_field = "6030A7E30363E1AE146F7326B6666B25")

    public static final int GL_EXP2                                  = 0x0801;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.196 -0500", hash_original_field = "74C2FA001A93BA23E7A55D9A0635CA87", hash_generated_field = "5B3583373834E1B16997BF3A95388EB2")

    public static final int GL_EXTENSIONS                            = 0x1F03;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.197 -0500", hash_original_field = "08093328E5CBC234C1A3469BF219D73F", hash_generated_field = "EC3A3073EC7FF4A46704A9ED43C9E386")

    public static final int GL_FALSE                                 = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.198 -0500", hash_original_field = "93E7F72639BC02FB7FCD0538A4BCF285", hash_generated_field = "B21755035B5719E0A8E87DC953A69D86")

    public static final int GL_FASTEST                               = 0x1101;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.198 -0500", hash_original_field = "D6F9F4A8F3817F8C8ADC7E605BFC5587", hash_generated_field = "54727533A2FC1141376E118EFDF1E024")

    public static final int GL_FIXED                                 = 0x140C;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.199 -0500", hash_original_field = "38630EAA5148811ECFE7C7909D6CBE45", hash_generated_field = "98049EDDB51104947F27F933739B6FDA")

    public static final int GL_FLAT                                  = 0x1D00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.200 -0500", hash_original_field = "1FF7A980B9B38A89818F163C1D490A01", hash_generated_field = "776A345C3935B2E98F4769552CE86E47")

    public static final int GL_FLOAT                                 = 0x1406;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.201 -0500", hash_original_field = "1ABA11AA576856144BF26617657D142C", hash_generated_field = "3706E7E127C89D3D2CF277CE6EDA97B9")

    public static final int GL_FOG                                   = 0x0B60;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.202 -0500", hash_original_field = "1B677712424F5EEEDAD562CDA70CB546", hash_generated_field = "FB750791B90DDB00FED202C50E5699D0")

    public static final int GL_FOG_COLOR                             = 0x0B66;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.203 -0500", hash_original_field = "29B5D3E95E3D2F95BAF436E07188E13E", hash_generated_field = "B65E326C97BCB3FEA25D25C0E9BB154A")

    public static final int GL_FOG_DENSITY                           = 0x0B62;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.204 -0500", hash_original_field = "7265F33CA3A4F3E63559D2BD129EA514", hash_generated_field = "7BAC6DF42105FEA7EDC06E7DC29E1ACB")

    public static final int GL_FOG_END                               = 0x0B64;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.204 -0500", hash_original_field = "E83A60968E7FF0353D58C13C4DB4F4FF", hash_generated_field = "57E47577439A44FE1812F19F24A78AB6")

    public static final int GL_FOG_HINT                              = 0x0C54;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.206 -0500", hash_original_field = "F5C68EB48161A6258AE6BB7A8ABA90FB", hash_generated_field = "143F8D3D3ED49B93EE6C3E46DA31A010")

    public static final int GL_FOG_MODE                              = 0x0B65;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.207 -0500", hash_original_field = "53800F84DAC2856E916FDFD3651B8704", hash_generated_field = "7B8BC5489CCC64942C883329D202FC2E")

    public static final int GL_FOG_START                             = 0x0B63;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.207 -0500", hash_original_field = "B2AB6067D36EDEFAA41112C2BEEE2FC2", hash_generated_field = "282681C01F23D92A723004A36CE68F21")

    public static final int GL_FRONT                                 = 0x0404;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.208 -0500", hash_original_field = "EC74BF4B1349C10E5DE032A3CBAB4EB7", hash_generated_field = "2823AEA7B2FB283F963720184AE348D1")

    public static final int GL_FRONT_AND_BACK                        = 0x0408;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.209 -0500", hash_original_field = "A5892DC0E79258334CEFDB0FB30B3475", hash_generated_field = "7B31CD8183BCDB86620F2670173470EB")

    public static final int GL_GEQUAL                                = 0x0206;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.210 -0500", hash_original_field = "C372F824268DD69862545B39ED8E2AE3", hash_generated_field = "86527F04ED005A379DDE1E13CA42480F")

    public static final int GL_GREATER                               = 0x0204;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.211 -0500", hash_original_field = "FEA3DAEC267A934EDBFFB2BC5CBF903E", hash_generated_field = "5B1708D4871A175D42766720896F17EF")

    public static final int GL_GREEN_BITS                            = 0x0D53;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.211 -0500", hash_original_field = "17FA6D99F64A5CFE4C3126D76EB8CC54", hash_generated_field = "E75F4661E6BC1652CEA99ED159E33473")

    public static final int GL_IMPLEMENTATION_COLOR_READ_FORMAT_OES  = 0x8B9B;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.212 -0500", hash_original_field = "C8502A17A1DEF8CE62D653274AC9936A", hash_generated_field = "DFD6CB449573A61D72BC74D9554593A3")

    public static final int GL_IMPLEMENTATION_COLOR_READ_TYPE_OES    = 0x8B9A;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.213 -0500", hash_original_field = "9761009C24B2BF0B42E22EA0006177AF", hash_generated_field = "043F85B707374E94709A8F7159F387E0")

    public static final int GL_INCR                                  = 0x1E02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.214 -0500", hash_original_field = "2D16131BF3DC60CF3E5A4F19DFFE7A28", hash_generated_field = "F8C6C9C7A3A9BA71ADE96972F4E2BE91")

    public static final int GL_INVALID_ENUM                          = 0x0500;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.215 -0500", hash_original_field = "0D18295AB7AD87C1319901E77B247DEF", hash_generated_field = "BF905AF0CB04092D0B0DA2F0D5839959")

    public static final int GL_INVALID_OPERATION                     = 0x0502;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.215 -0500", hash_original_field = "34BE2E4458B164A81EE0F052CB485000", hash_generated_field = "E2D361363B879444BF7C0E4D575B7395")

    public static final int GL_INVALID_VALUE                         = 0x0501;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.216 -0500", hash_original_field = "D604842D4B662F65E7D15865473FDA4B", hash_generated_field = "891D64DE0F628EC3BD77CEA1FB2643A6")

    public static final int GL_INVERT                                = 0x150A;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.217 -0500", hash_original_field = "1DF781C33EFBC997C5B580D81D7AE16F", hash_generated_field = "AC1B44CC8A8DFECDC32B181A188D5EC3")

    public static final int GL_KEEP                                  = 0x1E00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.218 -0500", hash_original_field = "E71998529BCEFBBF0A0CD4EDC889BF82", hash_generated_field = "08E9588A524EB2187171C96E2FC84E53")

    public static final int GL_LEQUAL                                = 0x0203;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.219 -0500", hash_original_field = "7414B764B67C5AFD49CD31BDE0E07442", hash_generated_field = "CF8C714644DB7D661F354ACA1832748C")

    public static final int GL_LESS                                  = 0x0201;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.220 -0500", hash_original_field = "150E737992636F402C5990E78F438B22", hash_generated_field = "AF8440865F2F26F712D1616924735CF5")

    public static final int GL_LIGHT_MODEL_AMBIENT                   = 0x0B53;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.221 -0500", hash_original_field = "8A9429EE43F9EC678E96CF8CB6EC88E1", hash_generated_field = "A9B6557380A4ABA45BAED06133659422")

    public static final int GL_LIGHT_MODEL_TWO_SIDE                  = 0x0B52;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.222 -0500", hash_original_field = "253A4401CDCF411B9A97044EC145BF26", hash_generated_field = "87081B5629D615316866F1985C549C37")

    public static final int GL_LIGHT0                                = 0x4000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.223 -0500", hash_original_field = "AF35F3480A414765776BC10E4156C5F0", hash_generated_field = "E6F4B0A7926BF9402BBBCF679B24E489")

    public static final int GL_LIGHT1                                = 0x4001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.224 -0500", hash_original_field = "DDCB4A8D7E9EEE7B6E945A48D571F37E", hash_generated_field = "EC6FA40CBE677E6B7CA40C7F687CCE62")

    public static final int GL_LIGHT2                                = 0x4002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.225 -0500", hash_original_field = "FCDA5A8591C29223F149E487A0EF16AB", hash_generated_field = "E022472535714BC1A9DF41E7BDFBD1EA")

    public static final int GL_LIGHT3                                = 0x4003;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.225 -0500", hash_original_field = "2D112729D8D23D1784DCDC27BC74B4D2", hash_generated_field = "79CC5D591CC5B155F1625859745EF718")

    public static final int GL_LIGHT4                                = 0x4004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.226 -0500", hash_original_field = "886E3F59790C20ED037FF1223D613AF1", hash_generated_field = "71A7C93F764B85A1F574D55E1360E938")

    public static final int GL_LIGHT5                                = 0x4005;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.227 -0500", hash_original_field = "706CAAF2DAFD09B390EEC6EB6EAC7EDB", hash_generated_field = "0DEFC14603CF8F3F6AFC2B20FDD173EF")

    public static final int GL_LIGHT6                                = 0x4006;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.228 -0500", hash_original_field = "FD6D5ED157BED65AA7982007DE73D1D6", hash_generated_field = "1A53CFE985D60518DD5592F449A16B09")

    public static final int GL_LIGHT7                                = 0x4007;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.229 -0500", hash_original_field = "76460BD0A34EAF35E76774153C96B5E8", hash_generated_field = "FD64162239E37E313868FD5904EA9C32")

    public static final int GL_LIGHTING                              = 0x0B50;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.230 -0500", hash_original_field = "EED2D831F232BB8B730D9142F14CA3C7", hash_generated_field = "952CBB2FE89C544168C9BA35CC4CC48B")

    public static final int GL_LINE_LOOP                             = 0x0002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.230 -0500", hash_original_field = "3950E0B1CFF39F1DE43F9A4709B07091", hash_generated_field = "4C16D3D6EE8EDFBFF7534020BFACEB79")

    public static final int GL_LINE_SMOOTH                           = 0x0B20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.231 -0500", hash_original_field = "71C2366FD48D77EFD6214A48B80BA338", hash_generated_field = "7E8AE3A556EE56EFF2B3130759B09459")

    public static final int GL_LINE_SMOOTH_HINT                      = 0x0C52;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.232 -0500", hash_original_field = "3150112A8009CB667FDF9F27566C72DA", hash_generated_field = "40BBE33B8608A6DBB9A295EBCE625672")

    public static final int GL_LINE_STRIP                            = 0x0003;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.233 -0500", hash_original_field = "8997B1C0659E305F61EAA4CB5A592F0C", hash_generated_field = "7F86F6F1824D09F94648C12DD73CE3CD")

    public static final int GL_LINEAR                                = 0x2601;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.234 -0500", hash_original_field = "993E7A0DC0E5B2D8C289AEDC70034F65", hash_generated_field = "59C76027C9FC5CB90D086830D8C7732B")

    public static final int GL_LINEAR_ATTENUATION                    = 0x1208;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.235 -0500", hash_original_field = "3773D8C88B54887BE91C8E1D880BE8B0", hash_generated_field = "EFC7F162A4792680BED3D106B21DC2A5")

    public static final int GL_LINEAR_MIPMAP_LINEAR                  = 0x2703;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.236 -0500", hash_original_field = "0EE84A6AB540681890D0FE6B0AB93549", hash_generated_field = "F99ADA5F5048826A006EABD5E713AD76")

    public static final int GL_LINEAR_MIPMAP_NEAREST                 = 0x2701;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.236 -0500", hash_original_field = "B649F75AB5AA45B52229086A01D8C7D3", hash_generated_field = "40A33BDBD75619099109C07E3630DD5F")

    public static final int GL_LINES                                 = 0x0001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.237 -0500", hash_original_field = "480EA8989C2A8C6794C8BDAF00694497", hash_generated_field = "C81D52BB104C03AD2A5683FF4CB425AE")

    public static final int GL_LUMINANCE                             = 0x1909;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.238 -0500", hash_original_field = "9A4AFD12A281DC13B83F1DA8EB1A62E2", hash_generated_field = "05F661AB7EBC422B7D80FDAA800AC894")

    public static final int GL_LUMINANCE_ALPHA                       = 0x190A;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.239 -0500", hash_original_field = "ADCF2B167E619F18E79BC0C514D096A7", hash_generated_field = "202EB8896F582EBAA04E6E98B03B12DB")

    public static final int GL_MAX_ELEMENTS_INDICES                  = 0x80E9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.240 -0500", hash_original_field = "8E614F17EA793D881531365EF4417788", hash_generated_field = "4AEECB2CCF825B1060E71980DBC9DDEC")

    public static final int GL_MAX_ELEMENTS_VERTICES                 = 0x80E8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.241 -0500", hash_original_field = "50A023BE4E6524342A48DABCE4E64403", hash_generated_field = "AF4D917C74C65AD9762C4A0BBF093A06")

    public static final int GL_MAX_LIGHTS                            = 0x0D31;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.242 -0500", hash_original_field = "C9DEED33A4B0A3C856D703C43BF78196", hash_generated_field = "43175315FCA32B060BB1A6BDB208C16B")

    public static final int GL_MAX_MODELVIEW_STACK_DEPTH             = 0x0D36;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.242 -0500", hash_original_field = "D839E524591C056FE30694212DBDE5A0", hash_generated_field = "4A66F6A691E63E3F093A3FA2F9A3D0AD")

    public static final int GL_MAX_PROJECTION_STACK_DEPTH            = 0x0D38;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.243 -0500", hash_original_field = "F2B788CF5B11DB045326273D95DD86E5", hash_generated_field = "A2ED8C7E41FB13A2FDF8E15102E65BC7")

    public static final int GL_MAX_TEXTURE_SIZE                      = 0x0D33;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.244 -0500", hash_original_field = "B16FB989E7F6C7C41AC2F2223D8FAA1B", hash_generated_field = "60C86A620843010085E4D0268BFB9814")

    public static final int GL_MAX_TEXTURE_STACK_DEPTH               = 0x0D39;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.245 -0500", hash_original_field = "D2B1F659772C2033813F0DD2233DBCE7", hash_generated_field = "83A60959C83AD96C864DEFB7ABAE4AC9")

    public static final int GL_MAX_TEXTURE_UNITS                     = 0x84E2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.246 -0500", hash_original_field = "E47BC043AF4253D7DB507677D5911C84", hash_generated_field = "BC4991FCAD83DB0A7868B26EBDE034D9")

    public static final int GL_MAX_VIEWPORT_DIMS                     = 0x0D3A;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.247 -0500", hash_original_field = "DF1AC0028213776F5B3F3E922747CFD9", hash_generated_field = "740C93E3D8D876B74C865DE85E68100A")

    public static final int GL_MODELVIEW                             = 0x1700;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.248 -0500", hash_original_field = "20D309E1D08E44AE1F1DA8DBA029B371", hash_generated_field = "73E49FDB3A804D4928F06F74F59462F8")

    public static final int GL_MODULATE                              = 0x2100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.249 -0500", hash_original_field = "343C99C81EA5CEE9D3712365E415B287", hash_generated_field = "C156FD026A906AD527F64E8DD42BCF39")

    public static final int GL_MULTISAMPLE                           = 0x809D;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.249 -0500", hash_original_field = "8B56FA7C3AEE4BDD7449BA941339EDDB", hash_generated_field = "3032A5E567BDC33CCD1B098A67429801")

    public static final int GL_NAND                                  = 0x150E;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.251 -0500", hash_original_field = "C977327F831E39C7AFE53D0F2597AE25", hash_generated_field = "B0FB6384C88C83EB4C1A4C10AA65E821")

    public static final int GL_NEAREST                               = 0x2600;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.252 -0500", hash_original_field = "ED7976C7BA2505C53FE444F38C14E66D", hash_generated_field = "F0A2FA3AACBA4EA7BA158C2462E7D640")

    public static final int GL_NEAREST_MIPMAP_LINEAR                 = 0x2702;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.252 -0500", hash_original_field = "92E8A86C0B0D56C39F6138FE785285B8", hash_generated_field = "A2ADEF4D1C78AA83F5B2352C8DBDC6E2")

    public static final int GL_NEAREST_MIPMAP_NEAREST                = 0x2700;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.253 -0500", hash_original_field = "C1A2FFB66B994BA0851EFB1100DD7056", hash_generated_field = "CA379896EFAC1FCD285FDDEC471ED007")

    public static final int GL_NEVER                                 = 0x0200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.254 -0500", hash_original_field = "FB17732C5DFB9464572E46E15DB6C58A", hash_generated_field = "6B136FADA83CBD44BC9F1E2EEBAE0BD5")

    public static final int GL_NICEST                                = 0x1102;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.255 -0500", hash_original_field = "AFC6AFB12451CE4897E0CFDCF60E5755", hash_generated_field = "0653236F53D5E9A2C959345944242124")

    public static final int GL_NO_ERROR                              = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.256 -0500", hash_original_field = "34C658D4BF3A3B5473BD4DDC04C4AAAF", hash_generated_field = "3F1C265BDD42A6D0315AAFE8F09131D1")

    public static final int GL_NOOP                                  = 0x1505;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.256 -0500", hash_original_field = "49CEA7114C00EA585B68D813F6245D10", hash_generated_field = "18B7E9E1BA6195643B53D2A9AAF14D1E")

    public static final int GL_NOR                                   = 0x1508;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.257 -0500", hash_original_field = "8130C82FB302B3F78B1441425587E507", hash_generated_field = "3F4BE46C087510D64FA53C02FA1CBC92")

    public static final int GL_NORMAL_ARRAY                          = 0x8075;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.258 -0500", hash_original_field = "761537AC7A7A2A56652DEA5DEF0CBA53", hash_generated_field = "43829DD71C6737F206FDDC66EBBBD41E")

    public static final int GL_NORMALIZE                             = 0x0BA1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.259 -0500", hash_original_field = "8ADA244D49A89E972D7719F3729D6A36", hash_generated_field = "9D163E05C29CDB049D5EFDCB69A11F5B")

    public static final int GL_NOTEQUAL                              = 0x0205;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.260 -0500", hash_original_field = "CF4D37A50463EA0D044D48473E29BA5D", hash_generated_field = "6B49EE83F1713650B4936148C3D6E1BC")

    public static final int GL_NUM_COMPRESSED_TEXTURE_FORMATS        = 0x86A2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.260 -0500", hash_original_field = "BE3417F18C108C62495D072D46E3DD9E", hash_generated_field = "82D5FE136043639857A6207E913F1A47")

    public static final int GL_ONE                                   = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.261 -0500", hash_original_field = "B59E269D67BE16F3BA6A9E974E40C3D3", hash_generated_field = "3AEBAEB1CF16CE34127FDC76A8AA5071")

    public static final int GL_ONE_MINUS_DST_ALPHA                   = 0x0305;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.262 -0500", hash_original_field = "0068DB757F519A69C3BC0A03427FC87B", hash_generated_field = "77C61F9F16CE09FE063CB4595FE9C0EF")

    public static final int GL_ONE_MINUS_DST_COLOR                   = 0x0307;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.263 -0500", hash_original_field = "415D9A12139EDD68230C201E5D780D0B", hash_generated_field = "9C97EBACE4D89BA37F0CE50A2B4086CF")

    public static final int GL_ONE_MINUS_SRC_ALPHA                   = 0x0303;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.264 -0500", hash_original_field = "BDCA30E102D92990FB060AD043B08CF9", hash_generated_field = "FBD253CA03B8349C32F1201CE77928A2")

    public static final int GL_ONE_MINUS_SRC_COLOR                   = 0x0301;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.265 -0500", hash_original_field = "775343C64E38EE3507EF132BE1863F32", hash_generated_field = "80F56DE664B2AA32726BB92E544F03F9")

    public static final int GL_OR                                    = 0x1507;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.266 -0500", hash_original_field = "4D294B5FC716E7B6A36827270828A902", hash_generated_field = "B7C10797E01825622AFA629744754F2A")

    public static final int GL_OR_INVERTED                           = 0x150D;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.267 -0500", hash_original_field = "25F6D22846719F17180D06A4B9D17ED0", hash_generated_field = "12314B03B0236E1D65B12AAEECCA570A")

    public static final int GL_OR_REVERSE                            = 0x150B;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.268 -0500", hash_original_field = "A5C3165A95E16E89415D8AD126DA00F5", hash_generated_field = "E95871CFC24E5C6E759FA8B49E0583BF")

    public static final int GL_OUT_OF_MEMORY                         = 0x0505;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.269 -0500", hash_original_field = "043A9621A96C595B99C0AA0EF8129A28", hash_generated_field = "420168862C9EEAA13A97C845B02656C9")

    public static final int GL_PACK_ALIGNMENT                        = 0x0D05;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.269 -0500", hash_original_field = "076F0CE58886F4886F3D7530AF02A681", hash_generated_field = "6E71011AF8631728C453BEE15B7B5DBA")

    public static final int GL_PALETTE4_R5_G6_B5_OES                 = 0x8B92;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.270 -0500", hash_original_field = "6EC216676A0017D71CDA9CE4A5904EED", hash_generated_field = "67065582CB57B3C138E72ECAD8081F39")

    public static final int GL_PALETTE4_RGB5_A1_OES                  = 0x8B94;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.271 -0500", hash_original_field = "2C8E5BD9BD18EEE669FF1F4F3432E19D", hash_generated_field = "0C243A77FF74BA1139674E36D1CA7AB1")

    public static final int GL_PALETTE4_RGB8_OES                     = 0x8B90;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.272 -0500", hash_original_field = "624B6B9736F5BFD2F6E49315EA13866A", hash_generated_field = "EB628C04C68E50F3147DB532B280AAB7")

    public static final int GL_PALETTE4_RGBA4_OES                    = 0x8B93;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.273 -0500", hash_original_field = "E6A5ED3D15B3C499D9B6EDFFBDB18FA2", hash_generated_field = "0BF68A287D4F23AB3DA63C8FD7684E95")

    public static final int GL_PALETTE4_RGBA8_OES                    = 0x8B91;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.274 -0500", hash_original_field = "666B855B138176DDF848E78A1191E9AF", hash_generated_field = "960FFADB5ED90D70B6E3FB7102E9C8E1")

    public static final int GL_PALETTE8_R5_G6_B5_OES                 = 0x8B97;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.275 -0500", hash_original_field = "512766B777AC019EF701D61097656166", hash_generated_field = "3A21DDA7019CF0336BAABE397A967950")

    public static final int GL_PALETTE8_RGB5_A1_OES                  = 0x8B99;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.276 -0500", hash_original_field = "07407378B9FAEDE68A1DEB7CE4FC7B7E", hash_generated_field = "A7CADAC9EC391EF396A5FE756E7FB25B")

    public static final int GL_PALETTE8_RGB8_OES                     = 0x8B95;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.276 -0500", hash_original_field = "1ED24EDAAACF8A12B00A1B2596ACC878", hash_generated_field = "064376BF7F9C14290F210642DBB3605A")

    public static final int GL_PALETTE8_RGBA4_OES                    = 0x8B98;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.277 -0500", hash_original_field = "F91DAEE1B18BD9DD743B41DE5D7E71BE", hash_generated_field = "4125779681067A28CF0738094BF99EDE")

    public static final int GL_PALETTE8_RGBA8_OES                    = 0x8B96;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.278 -0500", hash_original_field = "B26CC1E78B4982E2D2740980FA91C8A8", hash_generated_field = "F5F7B445E6936478867FC77FE0835D68")

    public static final int GL_PERSPECTIVE_CORRECTION_HINT           = 0x0C50;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.279 -0500", hash_original_field = "28E738F11100D444D246DA66355DD6D1", hash_generated_field = "C7E4DE85CE1CC2EFFB63BE988898F30F")

    public static final int GL_POINT_SMOOTH                          = 0x0B10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.280 -0500", hash_original_field = "0874C1A8F6DEEC1B8BA82F3E41EA4309", hash_generated_field = "B7166765151D437013F461E263F390C5")

    public static final int GL_POINT_SMOOTH_HINT                     = 0x0C51;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.281 -0500", hash_original_field = "8749C057A3111991FD4D1B79CDC23774", hash_generated_field = "3AEB111123D4B87DB7AFE0BBC7526140")

    public static final int GL_POINTS                                = 0x0000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.281 -0500", hash_original_field = "331923954F88A58B5306CE5D595B736B", hash_generated_field = "9C29D60FA8E6E6ED9DBE90CC6638837E")

    public static final int GL_POINT_FADE_THRESHOLD_SIZE             = 0x8128;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.282 -0500", hash_original_field = "8C9443B0F76E878861AF3727D1E846F0", hash_generated_field = "884E2C3B57DFAADABA663012091B4580")

    public static final int GL_POINT_SIZE                            = 0x0B11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.283 -0500", hash_original_field = "A7A9C246E3B70DBCAF97010BE7A70112", hash_generated_field = "A9BCF6D80660E88427AD2FFB50877931")

    public static final int GL_POLYGON_OFFSET_FILL                   = 0x8037;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.284 -0500", hash_original_field = "A8B6C5C7F447E7F85F9A7EA630D8BBC1", hash_generated_field = "8026E5960476EE448734A9AD1D73EB47")

    public static final int GL_POLYGON_SMOOTH_HINT                   = 0x0C53;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.285 -0500", hash_original_field = "CE291833E23A777B5431F5EAB3CB0F9E", hash_generated_field = "998F948A2ADD5ECD8FB2B8CFD946F083")

    public static final int GL_POSITION                              = 0x1203;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.286 -0500", hash_original_field = "576EB9E2CD40C59971DA008CD8DD06A1", hash_generated_field = "F9D5848D419F9D4EA5EB074827AB7B99")

    public static final int GL_PROJECTION                            = 0x1701;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.287 -0500", hash_original_field = "BF50C67533DDA591F6097B7CCFAB410D", hash_generated_field = "4D69C053353BF0375CBDEFF4AFBFF53C")

    public static final int GL_QUADRATIC_ATTENUATION                 = 0x1209;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.287 -0500", hash_original_field = "573C8BCBD9BE06BAB47FD8CDBA768172", hash_generated_field = "C50548619DDE0126722D8AB15FF2EF16")

    public static final int GL_RED_BITS                              = 0x0D52;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.288 -0500", hash_original_field = "2CAB903AFB7E7259D70A8A2A9A531E3A", hash_generated_field = "9F902BB754AA320AF68CBD170F59FDF5")

    public static final int GL_RENDERER                              = 0x1F01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.289 -0500", hash_original_field = "FBE41B699F250F3B67045411FE37C16D", hash_generated_field = "0D42C554C0527A3A4F6ED53657A8F36A")

    public static final int GL_REPEAT                                = 0x2901;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.290 -0500", hash_original_field = "78D992323043FA2D5A1F33048B1A6145", hash_generated_field = "7825B8439D0B67AC7D326B5C83947881")

    public static final int GL_REPLACE                               = 0x1E01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.291 -0500", hash_original_field = "3C94A7ADEA4BC671D625FD587C7FC325", hash_generated_field = "7DB76300EC4BE9E2609D28090A8278E6")

    public static final int GL_RESCALE_NORMAL                        = 0x803A;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.292 -0500", hash_original_field = "E3AB3708E6A2351311954AE650A3CEFB", hash_generated_field = "6A23C406FDB5B7A1B50702BA5CC9C002")

    public static final int GL_RGB                                   = 0x1907;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.293 -0500", hash_original_field = "29F3B403F55C150284208289AAAD9B12", hash_generated_field = "C54FF8BC96B52D3F5B82AECAA4368DC3")

    public static final int GL_RGBA                                  = 0x1908;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.293 -0500", hash_original_field = "C38759DE17EB471A77221F6DD9B8427F", hash_generated_field = "0C96EEA0B791093940726427BE517D6B")

    public static final int GL_SAMPLE_ALPHA_TO_COVERAGE              = 0x809E;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.294 -0500", hash_original_field = "B30F1F7C2CFAF5047C92E3E0852CF33E", hash_generated_field = "0E73AE151CEF2B958D203993434326FF")

    public static final int GL_SAMPLE_ALPHA_TO_ONE                   = 0x809F;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.296 -0500", hash_original_field = "1C8D3D44F8563C0E22E998CFA5366CD6", hash_generated_field = "E4DE56A2A355F1A7C7E2A493405E4965")

    public static final int GL_SAMPLE_COVERAGE                       = 0x80A0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.297 -0500", hash_original_field = "B5A39E08958BA0858C6FA9DCE1E96848", hash_generated_field = "62D9DAC9732EE80D837C16904113DAEA")

    public static final int GL_SCISSOR_TEST                          = 0x0C11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.298 -0500", hash_original_field = "195D05843735B12A21179B25DC25C389", hash_generated_field = "9CB846346BE94B52C52BE7794A8736B5")

    public static final int GL_SET                                   = 0x150F;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.299 -0500", hash_original_field = "F7061196BE86F9EF2F6C36017AC0B2A8", hash_generated_field = "DD582C04EF1BE601FA83D17CD2612018")

    public static final int GL_SHININESS                             = 0x1601;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.300 -0500", hash_original_field = "1DE2129B136A0CFD87625EC66C51E758", hash_generated_field = "CEC9DBF8A25C09C8EE36A2040FCE90EC")

    public static final int GL_SHORT                                 = 0x1402;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.300 -0500", hash_original_field = "11969F6720EC8829977E19485400EDA7", hash_generated_field = "9DF9EDCCCD8DDF8E857FDA6D3F4F7DBE")

    public static final int GL_SMOOTH                                = 0x1D01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.301 -0500", hash_original_field = "99590FA94E57FBA9AE2FB33176B1DF9C", hash_generated_field = "C30E5625814CB50255AB78BB7DA42F4D")

    public static final int GL_SMOOTH_LINE_WIDTH_RANGE               = 0x0B22;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.302 -0500", hash_original_field = "7D4E2E699E7901205A39D5D835743C2F", hash_generated_field = "A799B28566EA058D37D89C7D458E78EE")

    public static final int GL_SMOOTH_POINT_SIZE_RANGE               = 0x0B12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.303 -0500", hash_original_field = "56C7DBB7A45DE8EE70DBEF5287CF58F3", hash_generated_field = "95BEA1C61974D1DF0E8F69C4BA7DF04F")

    public static final int GL_SPECULAR                              = 0x1202;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.304 -0500", hash_original_field = "4D0EB936734B4E783441090B36F1BA89", hash_generated_field = "7BD68C4D23E779D5379C002B53B7DA06")

    public static final int GL_SPOT_CUTOFF                           = 0x1206;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.304 -0500", hash_original_field = "84C53626E2CA82D93BAB0CEC4F2A2526", hash_generated_field = "65D3A16B2BD9979E240E9E4E835121C5")

    public static final int GL_SPOT_DIRECTION                        = 0x1204;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.305 -0500", hash_original_field = "0D999AC4B607D46B12796DB7370CE97C", hash_generated_field = "5876C8792992CB3A2FAF78DBD67F9AC3")

    public static final int GL_SPOT_EXPONENT                         = 0x1205;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.306 -0500", hash_original_field = "A89BDCA912F84D6BAB2471EB3ABA9336", hash_generated_field = "DD041534D4A71692473722C9C3DA669C")

    public static final int GL_SRC_ALPHA                             = 0x0302;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.307 -0500", hash_original_field = "F5B8188E28210B4B0AB4FC64EAB105A3", hash_generated_field = "70AEA0E98FC9C061FAC240ADA8332C5A")

    public static final int GL_SRC_ALPHA_SATURATE                    = 0x0308;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.308 -0500", hash_original_field = "98C174CDFE2C236BE132B81F977C8CF4", hash_generated_field = "C2011F8B7C7C63680FD638429313D1E6")

    public static final int GL_SRC_COLOR                             = 0x0300;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.308 -0500", hash_original_field = "30E88FF768467553D4077C842F565555", hash_generated_field = "C11D5F5E1FCC59AF256FCC31CB234897")

    public static final int GL_STACK_OVERFLOW                        = 0x0503;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.309 -0500", hash_original_field = "29350850F85AD03601B4ACBF366A8341", hash_generated_field = "8C3794E0BC4CCD7174221E7F186FA5B6")

    public static final int GL_STACK_UNDERFLOW                       = 0x0504;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.311 -0500", hash_original_field = "B8C947A45ACCE718281BEF771D2B12E3", hash_generated_field = "C15714275693DB4FD1855853B46EB0D8")

    public static final int GL_STENCIL_BITS                          = 0x0D57;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.312 -0500", hash_original_field = "0849230A5D15D1BE12177D63CF03D8ED", hash_generated_field = "221627FEE208D0522BB5C3111C9D1FD5")

    public static final int GL_STENCIL_BUFFER_BIT                    = 0x0400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.313 -0500", hash_original_field = "7AC6C4E7FDB8FDC2381A14CAED9B2FCC", hash_generated_field = "8DC539E2C1E101290729428C524DA2DC")

    public static final int GL_STENCIL_TEST                          = 0x0B90;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.314 -0500", hash_original_field = "21E52FCB8DC6989E1B60991E86C508AC", hash_generated_field = "4F10C209D49E9D5A5FC0C3797AA306D8")

    public static final int GL_SUBPIXEL_BITS                         = 0x0D50;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.315 -0500", hash_original_field = "3CD565265BBFE2ADC034B60B340B3D44", hash_generated_field = "D123EB9A72FA50D7D443B3DBF04FC9B1")

    public static final int GL_TEXTURE                               = 0x1702;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.315 -0500", hash_original_field = "9539D8C154FDDE11BCDC70B372765AE3", hash_generated_field = "CFA8DF52C890C8F91C1BA2D266BB91EB")

    public static final int GL_TEXTURE_2D                            = 0x0DE1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.316 -0500", hash_original_field = "E264E7ED37C03D910B902A850AD6CD64", hash_generated_field = "7F2496749EFA918509600AB619E8D791")

    public static final int GL_TEXTURE_COORD_ARRAY                   = 0x8078;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.317 -0500", hash_original_field = "2EE127C3055B56398154A668D304E766", hash_generated_field = "9D9F670C0CE058448AD88C16F5E3EB98")

    public static final int GL_TEXTURE_ENV                           = 0x2300;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.318 -0500", hash_original_field = "63526458AF58AD6550423EE5A92F9F4C", hash_generated_field = "8E10958B00705AA7561B64315A59C454")

    public static final int GL_TEXTURE_ENV_COLOR                     = 0x2201;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.319 -0500", hash_original_field = "9FFDD0FB6D27BD14769B8BB08321EC49", hash_generated_field = "54FE1A0F6DDE9D8E380CC763FDBC221B")

    public static final int GL_TEXTURE_ENV_MODE                      = 0x2200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.320 -0500", hash_original_field = "018E893F09D867497338F5D3F559C559", hash_generated_field = "0F8FE623FD8E0ED110006D791288A686")

    public static final int GL_TEXTURE_MAG_FILTER                    = 0x2800;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.320 -0500", hash_original_field = "EF69FF9691AE0660968EAF9E2C586876", hash_generated_field = "702299E7AFC47AA8D9BFCB1EE1AA1BAA")

    public static final int GL_TEXTURE_MIN_FILTER                    = 0x2801;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.321 -0500", hash_original_field = "1BDD8C1E472FCD5A3466D0A3D5344B15", hash_generated_field = "79FED79498C93220A14654ACE7E303EB")

    public static final int GL_TEXTURE_WRAP_S                        = 0x2802;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.322 -0500", hash_original_field = "33634015A2F3B3E75B62E4C9D0CD0BD3", hash_generated_field = "BA13CBAC042E1A4FD3E8BBA4033145DC")

    public static final int GL_TEXTURE_WRAP_T                        = 0x2803;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.323 -0500", hash_original_field = "3DD490B50766608561B1A5126B7E164C", hash_generated_field = "BA0F4FF4C8B05303345E6F0BCE004F67")

    public static final int GL_TEXTURE0                              = 0x84C0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.324 -0500", hash_original_field = "CE139042B64D48C3A736BE08C34C5078", hash_generated_field = "6368F222D7BE49D35F9CAFE86DFDD44A")

    public static final int GL_TEXTURE1                              = 0x84C1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.325 -0500", hash_original_field = "A1FFB07863AF783CBEA187BE75C4830C", hash_generated_field = "F9606689F311997886F22F3B4A4D9951")

    public static final int GL_TEXTURE2                              = 0x84C2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.326 -0500", hash_original_field = "9B1517A010254159397F9D98E039CCFE", hash_generated_field = "EB7A66E482516BA8A83A2C0901AE9821")

    public static final int GL_TEXTURE3                              = 0x84C3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.327 -0500", hash_original_field = "C8CE09357BFA99CBB869E2C04B0CE04D", hash_generated_field = "8C3019ADB0DB73957332280BCB5C776D")

    public static final int GL_TEXTURE4                              = 0x84C4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.327 -0500", hash_original_field = "64E05661B12599CF1D039CAFE17C6496", hash_generated_field = "0ADC913BC5A636AC0043EEAB35B38ABE")

    public static final int GL_TEXTURE5                              = 0x84C5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.328 -0500", hash_original_field = "E6EED6A9DB08B1609B5B5BE8E577EC45", hash_generated_field = "B031ADC1DCEDC2622EBDBEE78D98E599")

    public static final int GL_TEXTURE6                              = 0x84C6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.329 -0500", hash_original_field = "AE875D1062C62848D29CFD4654E010FB", hash_generated_field = "F0C1EE436F2FA5C7CF66757834968528")

    public static final int GL_TEXTURE7                              = 0x84C7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.330 -0500", hash_original_field = "4841664708E9342C92BDD75CACB83BD7", hash_generated_field = "378DF8E3660EABD42DFAE32C9CC7F398")

    public static final int GL_TEXTURE8                              = 0x84C8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.331 -0500", hash_original_field = "F439487211CB1DE1289F3E725BDC695C", hash_generated_field = "3C3FCB1A67F035913B43C79D2D75D872")

    public static final int GL_TEXTURE9                              = 0x84C9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.331 -0500", hash_original_field = "056426FE6B11B6F7F5243EDEE3A22A28", hash_generated_field = "776A57758332051D1D11DFE46DC41B12")

    public static final int GL_TEXTURE10                             = 0x84CA;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.332 -0500", hash_original_field = "D3A7A1F3EBBF3F51E4DD70BAFF59B6A8", hash_generated_field = "96905C885C6A888FEFF76AC4318D88E0")

    public static final int GL_TEXTURE11                             = 0x84CB;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.333 -0500", hash_original_field = "CA78B1F28279F7148C43C1F7C2B933CE", hash_generated_field = "E53F5986F1DCA42B824D147FF7D61D0C")

    public static final int GL_TEXTURE12                             = 0x84CC;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.334 -0500", hash_original_field = "615B7F2AE9070E41D72D63D523FA04B3", hash_generated_field = "D736272A012DC1B2C7D4F2075A10371A")

    public static final int GL_TEXTURE13                             = 0x84CD;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.335 -0500", hash_original_field = "5BFDE30A56CAE7E8751F0C7FB3E334D8", hash_generated_field = "A5B1A8D739FEE7A61A47B638606088EA")

    public static final int GL_TEXTURE14                             = 0x84CE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.336 -0500", hash_original_field = "91F9568852C6EA6DD00A36F58B59FF4F", hash_generated_field = "2D1B4D0A36141BF734DC607A7894592F")

    public static final int GL_TEXTURE15                             = 0x84CF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.337 -0500", hash_original_field = "165AB6DCF9BD3B4952B7CE99C98B8601", hash_generated_field = "0FAE9C9EBBAA9BF0C721E851AF3EDE0D")

    public static final int GL_TEXTURE16                             = 0x84D0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.337 -0500", hash_original_field = "4B13CD2C75FDED6B6C59E69AA9532281", hash_generated_field = "C0ACBBDC95FC99E0E86F764F882B7F88")

    public static final int GL_TEXTURE17                             = 0x84D1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.338 -0500", hash_original_field = "C3E91C036291AFED32E619B284F10514", hash_generated_field = "B5B5A27665F1BB7E1FEDCA77A03AA883")

    public static final int GL_TEXTURE18                             = 0x84D2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.339 -0500", hash_original_field = "077652260DB6E8270D799A538FA58309", hash_generated_field = "99C75295F9DE85B97D0A81F7CA5EA203")

    public static final int GL_TEXTURE19                             = 0x84D3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.340 -0500", hash_original_field = "1E1CD4E45FDDB569893FC9A22F384A66", hash_generated_field = "CD24AFB64E44A02D63932BE13470E6AA")

    public static final int GL_TEXTURE20                             = 0x84D4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.341 -0500", hash_original_field = "8637A19E20509056DCBB22D3ED4B01A9", hash_generated_field = "E82035766A7DC3AC3F6B37809B251C21")

    public static final int GL_TEXTURE21                             = 0x84D5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.342 -0500", hash_original_field = "CFDB09C55A24B0460CB480E21813B5BA", hash_generated_field = "BD518C3B1A0B2D9E43F6B7C2A20DFE2F")

    public static final int GL_TEXTURE22                             = 0x84D6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.343 -0500", hash_original_field = "9C6DB8E9450D3E857DF99080E4F12DCC", hash_generated_field = "E51DAC73DF5C45484DA3FB37491A0EE5")

    public static final int GL_TEXTURE23                             = 0x84D7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.344 -0500", hash_original_field = "B7DF0F962D833D5612BE9C7709606CF4", hash_generated_field = "B22E032B85EB699368B06AC87FE2B898")

    public static final int GL_TEXTURE24                             = 0x84D8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.345 -0500", hash_original_field = "C5932B6B2F972096BFCEB2894F80947B", hash_generated_field = "B8105530A28A057AD49118429901D7B6")

    public static final int GL_TEXTURE25                             = 0x84D9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.346 -0500", hash_original_field = "1B9A610CEE2E503141D47440146970B9", hash_generated_field = "4B11DEEFAF68B9BB74AC3A4FBDF965FF")

    public static final int GL_TEXTURE26                             = 0x84DA;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.347 -0500", hash_original_field = "6165DCBFD82F3EDE8C32846E59F25296", hash_generated_field = "02DEAA70ADF70018857298DDA1032C62")

    public static final int GL_TEXTURE27                             = 0x84DB;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.347 -0500", hash_original_field = "B282F75862E10CB6011BAAB5E8F0A4CD", hash_generated_field = "165C9ED7F06E643264EE9C4A9240B619")

    public static final int GL_TEXTURE28                             = 0x84DC;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.348 -0500", hash_original_field = "877611DA02271209594534FB1593287B", hash_generated_field = "6F3D9C17432273490A88EAA2FBA96C4E")

    public static final int GL_TEXTURE29                             = 0x84DD;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.349 -0500", hash_original_field = "FB650C88AC32AF7163DA924005799716", hash_generated_field = "01235E8CF92D5BA414CDD25B6604F79E")

    public static final int GL_TEXTURE30                             = 0x84DE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.350 -0500", hash_original_field = "774CA161FAB678EA83105708EAEB0DA7", hash_generated_field = "C8151127B3E9F7F60F918EEFDAFCC4BD")

    public static final int GL_TEXTURE31                             = 0x84DF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.350 -0500", hash_original_field = "2D54BDF5B77E4B9A5E4F7165E7B820E8", hash_generated_field = "E319033744A6FD5FBED22534A09D0D9A")

    public static final int GL_TRIANGLE_FAN                          = 0x0006;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.351 -0500", hash_original_field = "7B04E94F15950352604BF61C2167BB9A", hash_generated_field = "2DFC30CE5B5D0C909353FE0F8E82ECAE")

    public static final int GL_TRIANGLE_STRIP                        = 0x0005;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.352 -0500", hash_original_field = "1C87BDB4260C88F3E387AADE1385026B", hash_generated_field = "E770048AE0B8EE2CF20B5355345E232E")

    public static final int GL_TRIANGLES                             = 0x0004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.353 -0500", hash_original_field = "52A8117B6258A2597D3FCB27F3B3F858", hash_generated_field = "61D712C997F883C5E54B2F3515C8B065")

    public static final int GL_TRUE                                  = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.354 -0500", hash_original_field = "0B8D42835C9C2BBFF982D2D833B6C0AC", hash_generated_field = "07391187CDB7D66B8228865535D68F9C")

    public static final int GL_UNPACK_ALIGNMENT                      = 0x0CF5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.355 -0500", hash_original_field = "999046ADB4870579F39328909A1A9B6E", hash_generated_field = "D9C771F554A8939A1729582F2211DA5D")

    public static final int GL_UNSIGNED_BYTE                         = 0x1401;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.356 -0500", hash_original_field = "3123986411AF203CCDBF3D8D148287F4", hash_generated_field = "CF2E78B3A757A12168ACD04C3937641C")

    public static final int GL_UNSIGNED_SHORT                        = 0x1403;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.357 -0500", hash_original_field = "4B17FBB5AC887466065B1E91E5ACAB14", hash_generated_field = "B20FCFFE737F717A755866C24553F9C3")

    public static final int GL_UNSIGNED_SHORT_4_4_4_4                = 0x8033;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.358 -0500", hash_original_field = "E8798CEEB1DAFC122C9E0A25BB290B0F", hash_generated_field = "C2FA2F9F63044337A428E6E10E6D2AFA")

    public static final int GL_UNSIGNED_SHORT_5_5_5_1                = 0x8034;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.359 -0500", hash_original_field = "07A9F1ABC7D0EAB39B28F3E9DD79271F", hash_generated_field = "4C7D42068CD7D103E43E5E903CF95B76")

    public static final int GL_UNSIGNED_SHORT_5_6_5                  = 0x8363;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.360 -0500", hash_original_field = "13292DA983E183437E9618E56CB5156B", hash_generated_field = "F31B958C8F10E182C79082E291A281D3")

    public static final int GL_VENDOR                                = 0x1F00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.360 -0500", hash_original_field = "51ADFA9DD0AD564D6D95836EAC7BAB1D", hash_generated_field = "ED8862F66460C23F886758F9B875895E")

    public static final int GL_VERSION                               = 0x1F02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.361 -0500", hash_original_field = "E2AE46EC305C74A3CA560E9968B41D06", hash_generated_field = "3990C55AAECCCFAEA365D6980417A473")

    public static final int GL_VERTEX_ARRAY                          = 0x8074;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.362 -0500", hash_original_field = "79C89735C888F7DD1E3B5BD48F83D06E", hash_generated_field = "6E6721A9B523AF92C6B8D975826C22B9")

    public static final int GL_XOR                                   = 0x1506;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.363 -0500", hash_original_field = "B948F81EA8A7845FB3E8D7046A8B0327", hash_generated_field = "2AE94B595542B2CF364EA127E42FBDCE")

    public static final int GL_ZERO                                  = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.365 -0500", hash_original_field = "C996664BBE6BD4BF532455DA5A634B33", hash_generated_field = "CC0DE27B6F7397C17CC69EA408C69F1E")


    private static Buffer _colorPointer;
    static {
	    _nativeClassInit();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.366 -0500", hash_original_field = "8B47751956F5C4E94314D09DA2B8311A", hash_generated_field = "C2CCFC200FD14AD989DA8589B75E7348")

    private static Buffer _normalPointer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.367 -0500", hash_original_field = "6AC62719D60111EB6E49EB3057F67E56", hash_generated_field = "9B1316D706ADB0AC88260735536598A3")

    private static Buffer _texCoordPointer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:33.368 -0500", hash_original_field = "9961D914C807C17127AF57F66D732213", hash_generated_field = "B911415BE838F3334EDD65DA9B0BAD98")

    private static Buffer _vertexPointer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.982 -0400", hash_original_method = "821E4B2AC1205B57597681A054E6B512", hash_generated_method = "821E4B2AC1205B57597681A054E6B512")
    public GLES10 ()
    {
        //Synthesized constructor
    }
}

