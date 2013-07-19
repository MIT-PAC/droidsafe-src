package android.opengl;

// Droidsafe Imports
import java.nio.Buffer;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSUtils;

public class GLES10 {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.982 -0400", hash_original_method = "821E4B2AC1205B57597681A054E6B512", hash_generated_method = "821E4B2AC1205B57597681A054E6B512")
    public GLES10 ()
    {
        //Synthesized constructor
    }


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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.031 -0400", hash_original_field = "FB4F1E35C7F7DF4F6C693B7753EDA2A0", hash_generated_field = "D27742AE443C6C6ED0F4E7EA8517EEEB")

    public static final int GL_ADD                                   = 0x0104;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.031 -0400", hash_original_field = "FD5288D66A66619C796D3B9E27ED513B", hash_generated_field = "8FCB0F04C33D33E10BECE828D721612F")

    public static final int GL_ALIASED_LINE_WIDTH_RANGE              = 0x846E;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.031 -0400", hash_original_field = "9C64BCDF8A02D1C0AD1E89A6FEF0263A", hash_generated_field = "19883743E3CCB19994F89686F320722F")

    public static final int GL_ALIASED_POINT_SIZE_RANGE              = 0x846D;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.031 -0400", hash_original_field = "F654B3C5FCC164E778ED8207BD074615", hash_generated_field = "EEC5ED5025D8B6C12C784EADC0C94480")

    public static final int GL_ALPHA                                 = 0x1906;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.031 -0400", hash_original_field = "D5F9E5792CA4571E06A4B8C46416FE32", hash_generated_field = "C7AC3BCD060ADDD8CFBAE19F1D470C1E")

    public static final int GL_ALPHA_BITS                            = 0x0D55;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.031 -0400", hash_original_field = "F34D351170DF674DDE1631D15B1C4780", hash_generated_field = "38B6EF6729F7CD24CD574E54ED389ED0")

    public static final int GL_ALPHA_TEST                            = 0x0BC0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.031 -0400", hash_original_field = "54C36B7B24128D358B50C0091495025D", hash_generated_field = "EC3E764163C9D8D7002C124025DD7ECB")

    public static final int GL_ALWAYS                                = 0x0207;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.031 -0400", hash_original_field = "E8DB83FC8303D64F2C9AA587D85B503C", hash_generated_field = "07E89F7A5BAB3444FAE261B847A3C4BC")

    public static final int GL_AMBIENT                               = 0x1200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.031 -0400", hash_original_field = "65B8D665DF5AA37870F126AE745F23AC", hash_generated_field = "223F9BC6C497C82CA5718076B78FF908")

    public static final int GL_AMBIENT_AND_DIFFUSE                   = 0x1602;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.031 -0400", hash_original_field = "DC2E202B06040CD1C4E196B03247D2BC", hash_generated_field = "BA9B3BD283E1C71AB295B485ECAA8836")

    public static final int GL_AND                                   = 0x1501;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.031 -0400", hash_original_field = "9956B6C5133E994BA68B4DFF58F3F5E8", hash_generated_field = "5D04BC7CFF6DF830F48A2FCD555C8F36")

    public static final int GL_AND_INVERTED                          = 0x1504;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.032 -0400", hash_original_field = "12484A52AA0FCF47AB11F71A927A5E18", hash_generated_field = "1D57CA60396066A3389AE708DCA8DA5A")

    public static final int GL_AND_REVERSE                           = 0x1502;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.032 -0400", hash_original_field = "BEA1B9EFDC06A94AC5BFB35214DD24D2", hash_generated_field = "8D01D16E233D653B13BF35763F39094C")

    public static final int GL_BACK                                  = 0x0405;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.032 -0400", hash_original_field = "2C746769A941190F3AACE34FCE99EB10", hash_generated_field = "B8047B6EFFF20A9163B2D267795697BD")

    public static final int GL_BLEND                                 = 0x0BE2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.032 -0400", hash_original_field = "A6A84365E3EAF5E2363436F11361A588", hash_generated_field = "F1A2269499DEFE7DF6523956BF443AA2")

    public static final int GL_BLUE_BITS                             = 0x0D54;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.032 -0400", hash_original_field = "95017852ED5FE92600CF4DB7A0155646", hash_generated_field = "CA6B17F497DEA88919CF12FEF41C771D")

    public static final int GL_BYTE                                  = 0x1400;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.032 -0400", hash_original_field = "9BAD1EF548CB0B114C1AAAB4A86FA8DE", hash_generated_field = "D90679929372A8D046997B2D0E27D061")

    public static final int GL_CCW                                   = 0x0901;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.032 -0400", hash_original_field = "BF2C6C333138B8DABDD13F71371D6FEB", hash_generated_field = "F4270B23DBE6E082C9F3F938AAE90031")

    public static final int GL_CLAMP_TO_EDGE                         = 0x812F;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.032 -0400", hash_original_field = "31824718694C13287E86964AA52281E8", hash_generated_field = "2E6DC39DD1868170030F558C041130BF")

    public static final int GL_CLEAR                                 = 0x1500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.032 -0400", hash_original_field = "34CA0393209CDFDBF53AB49DB88DCF87", hash_generated_field = "8BDC411E2D9FAF4BECADB461B3B575FB")

    public static final int GL_COLOR_ARRAY                           = 0x8076;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.032 -0400", hash_original_field = "A4C94C6278D7C6FD0E38F334B504435B", hash_generated_field = "810CFD64F6256C5C1473DE92CB1814AE")

    public static final int GL_COLOR_BUFFER_BIT                      = 0x4000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.032 -0400", hash_original_field = "E2F0D30A489F7685FB90AD741442AA8E", hash_generated_field = "FB145914AFB2167EDE7E71018FC7321F")

    public static final int GL_COLOR_LOGIC_OP                        = 0x0BF2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.032 -0400", hash_original_field = "36BE72B9615823A71F149581081C0417", hash_generated_field = "B7EAE3253401931A3DD43C93FBCE8003")

    public static final int GL_COLOR_MATERIAL                        = 0x0B57;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.032 -0400", hash_original_field = "4BE01025E706815FA57A9FCB544D9766", hash_generated_field = "D2E69BE46D8601F3AC337E2E00FD3F7C")

    public static final int GL_COMPRESSED_TEXTURE_FORMATS            = 0x86A3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.032 -0400", hash_original_field = "074EDEF1C72DE56939BD9FA324BB90A9", hash_generated_field = "5868B334D97EB62CC4BC2B85FAAB0966")

    public static final int GL_CONSTANT_ATTENUATION                  = 0x1207;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.032 -0400", hash_original_field = "780BC3AB1858D82B19616CEB681BC0A1", hash_generated_field = "A2BBD95B50BA674B8CCBB9435F5C4FAE")

    public static final int GL_COPY                                  = 0x1503;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.032 -0400", hash_original_field = "A22B45FA829D8053D61D49AB9E867816", hash_generated_field = "49183E3CB11DBDCAF1AC5BECCC5B7A45")

    public static final int GL_COPY_INVERTED                         = 0x150C;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.032 -0400", hash_original_field = "FC9A444B144C9FBF2A6A624A86DAD235", hash_generated_field = "9ABC6C59449029C0D07E4AB5037CCDA7")

    public static final int GL_CULL_FACE                             = 0x0B44;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.032 -0400", hash_original_field = "D649F147F02D3CDCAE4E4624673F5A75", hash_generated_field = "2C6DCD63CABB3C41ECC7B9014ED3B907")

    public static final int GL_CW                                    = 0x0900;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.032 -0400", hash_original_field = "26EB3482903A46BD71F5A0DA83E047DE", hash_generated_field = "26696F0B6502F90FFA2DD38B033B8342")

    public static final int GL_DECAL                                 = 0x2101;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.032 -0400", hash_original_field = "F2CF86EA3D38BC0FB0C231BD4C1EA271", hash_generated_field = "5315E9E453BD796C61A0AB06DD8E6A52")

    public static final int GL_DECR                                  = 0x1E03;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.032 -0400", hash_original_field = "33E619088D18DF8BA2CD3EEA4F5C4AB3", hash_generated_field = "C23671D29990648AA3F86C9EB1C76CED")

    public static final int GL_DEPTH_BITS                            = 0x0D56;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.032 -0400", hash_original_field = "A69FB08D803394F51591054739D7150D", hash_generated_field = "CE5A7EEFA7A57362D3457C20E6FC6A41")

    public static final int GL_DEPTH_BUFFER_BIT                      = 0x0100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.032 -0400", hash_original_field = "37EE9C06B5ABECBAE35B1FC8F32A1A0A", hash_generated_field = "FA6A17422F3B297267EDCBF88D16D4C5")

    public static final int GL_DEPTH_TEST                            = 0x0B71;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.032 -0400", hash_original_field = "FD5B7CC61A91E3C77AB9B0FB256C19AA", hash_generated_field = "20E0F92169D8F2A08CC46924EE40A1E6")

    public static final int GL_DIFFUSE                               = 0x1201;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.032 -0400", hash_original_field = "9496A3C9F50F2FECEE9233085D8DE797", hash_generated_field = "55F31A3EBC84BD31DE876C99C319C524")

    public static final int GL_DITHER                                = 0x0BD0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.032 -0400", hash_original_field = "994BD72B2035EB28A4B0724917508872", hash_generated_field = "DCD1693386658F7795F0400387749F39")

    public static final int GL_DONT_CARE                             = 0x1100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.032 -0400", hash_original_field = "C9FE89C49BE659848A68D8F29CECB237", hash_generated_field = "EA877CAC2DCE84B662BEC6DE59F3F34C")

    public static final int GL_DST_ALPHA                             = 0x0304;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.032 -0400", hash_original_field = "EFE8A911BBA5DF4AE82EFBEEDDA12555", hash_generated_field = "16B27F3397CB1CE88331D5E0EC0490B7")

    public static final int GL_DST_COLOR                             = 0x0306;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.032 -0400", hash_original_field = "1E50FDFC9E02E470941B2C41B2F5487A", hash_generated_field = "6C4F95B6EAF97800868FD6A760EBC895")

    public static final int GL_EMISSION                              = 0x1600;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.034 -0400", hash_original_field = "F103070C4A93A34E3C20C65663B5F91E", hash_generated_field = "92F53098599AA2DBF61CD4CBFE1E1026")

    public static final int GL_EQUAL                                 = 0x0202;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.034 -0400", hash_original_field = "4A0A555178C1A8B9B55F8DE57F9E1964", hash_generated_field = "1165864DAB653E46FDAF3AEF954F51C3")

    public static final int GL_EQUIV                                 = 0x1509;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.034 -0400", hash_original_field = "E7173D5F3E1CD5668546890194029F45", hash_generated_field = "FEF69717A6DA6BDB60A5030EDA198E77")

    public static final int GL_EXP                                   = 0x0800;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.034 -0400", hash_original_field = "C5059654F60B795FB7B66742E6C355BB", hash_generated_field = "6030A7E30363E1AE146F7326B6666B25")

    public static final int GL_EXP2                                  = 0x0801;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.034 -0400", hash_original_field = "6C28E650DA83F836D64B9AB62CA99166", hash_generated_field = "5B3583373834E1B16997BF3A95388EB2")

    public static final int GL_EXTENSIONS                            = 0x1F03;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.034 -0400", hash_original_field = "DD5A8B322A9E17F757C1D341FB599153", hash_generated_field = "EC3A3073EC7FF4A46704A9ED43C9E386")

    public static final int GL_FALSE                                 = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.034 -0400", hash_original_field = "BC4EA4E148493AB89275E92881815273", hash_generated_field = "B21755035B5719E0A8E87DC953A69D86")

    public static final int GL_FASTEST                               = 0x1101;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.034 -0400", hash_original_field = "7BF8C9C82BDB73F9E3E9B5B5A60C3E19", hash_generated_field = "54727533A2FC1141376E118EFDF1E024")

    public static final int GL_FIXED                                 = 0x140C;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.034 -0400", hash_original_field = "13F926C7EC772D1FACC7C12CAF3DA9A8", hash_generated_field = "98049EDDB51104947F27F933739B6FDA")

    public static final int GL_FLAT                                  = 0x1D00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.034 -0400", hash_original_field = "9BC0A540EA4EC46ED1194E3FDC51CEBE", hash_generated_field = "776A345C3935B2E98F4769552CE86E47")

    public static final int GL_FLOAT                                 = 0x1406;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.034 -0400", hash_original_field = "C7B008D4B3D4EB83E23091320EA9BBD8", hash_generated_field = "3706E7E127C89D3D2CF277CE6EDA97B9")

    public static final int GL_FOG                                   = 0x0B60;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.034 -0400", hash_original_field = "DD03A681EB33522332AA7580417D2A9D", hash_generated_field = "FB750791B90DDB00FED202C50E5699D0")

    public static final int GL_FOG_COLOR                             = 0x0B66;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.034 -0400", hash_original_field = "A390AE671169096919A88C1176C02927", hash_generated_field = "B65E326C97BCB3FEA25D25C0E9BB154A")

    public static final int GL_FOG_DENSITY                           = 0x0B62;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.034 -0400", hash_original_field = "9C7E022BE9311FC5D40637C294C12A17", hash_generated_field = "7BAC6DF42105FEA7EDC06E7DC29E1ACB")

    public static final int GL_FOG_END                               = 0x0B64;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.034 -0400", hash_original_field = "87E1CD15B3353FE781027AF40CE58CB1", hash_generated_field = "57E47577439A44FE1812F19F24A78AB6")

    public static final int GL_FOG_HINT                              = 0x0C54;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.034 -0400", hash_original_field = "45C05D9A2951D626D32D497819208589", hash_generated_field = "143F8D3D3ED49B93EE6C3E46DA31A010")

    public static final int GL_FOG_MODE                              = 0x0B65;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.034 -0400", hash_original_field = "684E7BE759E5150DE3FD74C5C9AF2A24", hash_generated_field = "7B8BC5489CCC64942C883329D202FC2E")

    public static final int GL_FOG_START                             = 0x0B63;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.034 -0400", hash_original_field = "45780475D656D5BA7B0700918944B0F9", hash_generated_field = "282681C01F23D92A723004A36CE68F21")

    public static final int GL_FRONT                                 = 0x0404;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.034 -0400", hash_original_field = "56F8034B9BD603833C4D5BB7792F2804", hash_generated_field = "2823AEA7B2FB283F963720184AE348D1")

    public static final int GL_FRONT_AND_BACK                        = 0x0408;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.034 -0400", hash_original_field = "788C1363BA723890CEB04A7DB9715041", hash_generated_field = "7B31CD8183BCDB86620F2670173470EB")

    public static final int GL_GEQUAL                                = 0x0206;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.034 -0400", hash_original_field = "8FCEE8CB4EBD54A7DBC9B80152DF4F05", hash_generated_field = "86527F04ED005A379DDE1E13CA42480F")

    public static final int GL_GREATER                               = 0x0204;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.034 -0400", hash_original_field = "9CA32D3F28C6BC01B99E6380122E1429", hash_generated_field = "5B1708D4871A175D42766720896F17EF")

    public static final int GL_GREEN_BITS                            = 0x0D53;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.034 -0400", hash_original_field = "6F2113FF693D5D3B6E3BDAC25AD52E6B", hash_generated_field = "E75F4661E6BC1652CEA99ED159E33473")

    public static final int GL_IMPLEMENTATION_COLOR_READ_FORMAT_OES  = 0x8B9B;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.034 -0400", hash_original_field = "FC586D12F7021289C0E38AC4F9D79441", hash_generated_field = "DFD6CB449573A61D72BC74D9554593A3")

    public static final int GL_IMPLEMENTATION_COLOR_READ_TYPE_OES    = 0x8B9A;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.034 -0400", hash_original_field = "588E513A8DF329C202409B7D9C7C7A71", hash_generated_field = "043F85B707374E94709A8F7159F387E0")

    public static final int GL_INCR                                  = 0x1E02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.035 -0400", hash_original_field = "600490D79A6E38846E004350C5CBB64C", hash_generated_field = "F8C6C9C7A3A9BA71ADE96972F4E2BE91")

    public static final int GL_INVALID_ENUM                          = 0x0500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.035 -0400", hash_original_field = "D36A41405C964872CAAE27D2063C99C5", hash_generated_field = "BF905AF0CB04092D0B0DA2F0D5839959")

    public static final int GL_INVALID_OPERATION                     = 0x0502;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.035 -0400", hash_original_field = "3085379FEC8B4948F9D8DDA5C2ED0A1D", hash_generated_field = "E2D361363B879444BF7C0E4D575B7395")

    public static final int GL_INVALID_VALUE                         = 0x0501;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.035 -0400", hash_original_field = "5B8004742615098CD780D01CC85FADB6", hash_generated_field = "891D64DE0F628EC3BD77CEA1FB2643A6")

    public static final int GL_INVERT                                = 0x150A;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.035 -0400", hash_original_field = "E686CC35CFDF1876F125012A12665BC8", hash_generated_field = "AC1B44CC8A8DFECDC32B181A188D5EC3")

    public static final int GL_KEEP                                  = 0x1E00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.035 -0400", hash_original_field = "1138633BC15BD0C6EC2DCC5D28E264AC", hash_generated_field = "08E9588A524EB2187171C96E2FC84E53")

    public static final int GL_LEQUAL                                = 0x0203;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.035 -0400", hash_original_field = "300470655124377989F9691A6B79EC37", hash_generated_field = "CF8C714644DB7D661F354ACA1832748C")

    public static final int GL_LESS                                  = 0x0201;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.035 -0400", hash_original_field = "04EFB1C3E7C689BA94987A5863971CDB", hash_generated_field = "AF8440865F2F26F712D1616924735CF5")

    public static final int GL_LIGHT_MODEL_AMBIENT                   = 0x0B53;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.035 -0400", hash_original_field = "078BD829175018C52F85AF987324D981", hash_generated_field = "A9B6557380A4ABA45BAED06133659422")

    public static final int GL_LIGHT_MODEL_TWO_SIDE                  = 0x0B52;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.035 -0400", hash_original_field = "8AE0486E5BEDE28FF333A402A3B81CD4", hash_generated_field = "87081B5629D615316866F1985C549C37")

    public static final int GL_LIGHT0                                = 0x4000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.035 -0400", hash_original_field = "1749AD4EB5B6C50D435A9F58C85CD857", hash_generated_field = "E6F4B0A7926BF9402BBBCF679B24E489")

    public static final int GL_LIGHT1                                = 0x4001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.035 -0400", hash_original_field = "AE25FD6FDA46E7DC8B1363B7E868E23F", hash_generated_field = "EC6FA40CBE677E6B7CA40C7F687CCE62")

    public static final int GL_LIGHT2                                = 0x4002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.035 -0400", hash_original_field = "305B3D9DBD51B784043B5561F156D3B9", hash_generated_field = "E022472535714BC1A9DF41E7BDFBD1EA")

    public static final int GL_LIGHT3                                = 0x4003;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.035 -0400", hash_original_field = "160E55B787136CF3F63FBEDAA2AB6419", hash_generated_field = "79CC5D591CC5B155F1625859745EF718")

    public static final int GL_LIGHT4                                = 0x4004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.035 -0400", hash_original_field = "E69729C46BDED3CAAAA0C35C84F68E11", hash_generated_field = "71A7C93F764B85A1F574D55E1360E938")

    public static final int GL_LIGHT5                                = 0x4005;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.035 -0400", hash_original_field = "42554419A9D3FD4BFCB92E5BD00F8FCC", hash_generated_field = "0DEFC14603CF8F3F6AFC2B20FDD173EF")

    public static final int GL_LIGHT6                                = 0x4006;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.035 -0400", hash_original_field = "3FB560DF6721E4BD13379C49CB7198C8", hash_generated_field = "1A53CFE985D60518DD5592F449A16B09")

    public static final int GL_LIGHT7                                = 0x4007;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.035 -0400", hash_original_field = "BAF529EA1CDC065B3A8F73EE9A7BF398", hash_generated_field = "FD64162239E37E313868FD5904EA9C32")

    public static final int GL_LIGHTING                              = 0x0B50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.035 -0400", hash_original_field = "94AD50A68E3E65CA901AC83533C0E567", hash_generated_field = "952CBB2FE89C544168C9BA35CC4CC48B")

    public static final int GL_LINE_LOOP                             = 0x0002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.035 -0400", hash_original_field = "26F4CE7CD5CE13AE16C50CB131D80E8D", hash_generated_field = "4C16D3D6EE8EDFBFF7534020BFACEB79")

    public static final int GL_LINE_SMOOTH                           = 0x0B20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.035 -0400", hash_original_field = "921D70B1D16832729D6CCF25EDB68D3D", hash_generated_field = "7E8AE3A556EE56EFF2B3130759B09459")

    public static final int GL_LINE_SMOOTH_HINT                      = 0x0C52;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.035 -0400", hash_original_field = "09A0067EF551BDB2E2F5307DBA3224F6", hash_generated_field = "40BBE33B8608A6DBB9A295EBCE625672")

    public static final int GL_LINE_STRIP                            = 0x0003;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.035 -0400", hash_original_field = "CC63F294F62FC37B4BCBD97EF5470D8B", hash_generated_field = "7F86F6F1824D09F94648C12DD73CE3CD")

    public static final int GL_LINEAR                                = 0x2601;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.035 -0400", hash_original_field = "6D6EA939B8A758132160FCD77501F5A2", hash_generated_field = "59C76027C9FC5CB90D086830D8C7732B")

    public static final int GL_LINEAR_ATTENUATION                    = 0x1208;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.035 -0400", hash_original_field = "5ADDA99B92F8A1866F76191B319F4256", hash_generated_field = "EFC7F162A4792680BED3D106B21DC2A5")

    public static final int GL_LINEAR_MIPMAP_LINEAR                  = 0x2703;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.035 -0400", hash_original_field = "0F705B584DF3DA2C3937E05033AF08D5", hash_generated_field = "F99ADA5F5048826A006EABD5E713AD76")

    public static final int GL_LINEAR_MIPMAP_NEAREST                 = 0x2701;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.035 -0400", hash_original_field = "BCDFF039A4042EEF6936526A8879077D", hash_generated_field = "40A33BDBD75619099109C07E3630DD5F")

    public static final int GL_LINES                                 = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.035 -0400", hash_original_field = "5986840FBDA6B93F51EE2C942ADFD40E", hash_generated_field = "C81D52BB104C03AD2A5683FF4CB425AE")

    public static final int GL_LUMINANCE                             = 0x1909;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.035 -0400", hash_original_field = "A9AC536C7824EE4D55BA9582A8904BDD", hash_generated_field = "05F661AB7EBC422B7D80FDAA800AC894")

    public static final int GL_LUMINANCE_ALPHA                       = 0x190A;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.036 -0400", hash_original_field = "8BDD69EA1BD560DE6794F1CBFF248C2C", hash_generated_field = "202EB8896F582EBAA04E6E98B03B12DB")

    public static final int GL_MAX_ELEMENTS_INDICES                  = 0x80E9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.036 -0400", hash_original_field = "4D40FD89AA8A0A8287C5C9143BC56D74", hash_generated_field = "4AEECB2CCF825B1060E71980DBC9DDEC")

    public static final int GL_MAX_ELEMENTS_VERTICES                 = 0x80E8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.036 -0400", hash_original_field = "625A63D20D2D8F1FFA9ED5E10B72E8C7", hash_generated_field = "AF4D917C74C65AD9762C4A0BBF093A06")

    public static final int GL_MAX_LIGHTS                            = 0x0D31;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.036 -0400", hash_original_field = "A9A34C9801F6C60B952A817D206533D8", hash_generated_field = "43175315FCA32B060BB1A6BDB208C16B")

    public static final int GL_MAX_MODELVIEW_STACK_DEPTH             = 0x0D36;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.036 -0400", hash_original_field = "DE2ECA3F07480471E7CAC001D8F5E107", hash_generated_field = "4A66F6A691E63E3F093A3FA2F9A3D0AD")

    public static final int GL_MAX_PROJECTION_STACK_DEPTH            = 0x0D38;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.036 -0400", hash_original_field = "FAEB86B9C49A86939ECD9BD123F39CA1", hash_generated_field = "A2ED8C7E41FB13A2FDF8E15102E65BC7")

    public static final int GL_MAX_TEXTURE_SIZE                      = 0x0D33;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.036 -0400", hash_original_field = "7030464C5828524C6AFC712B4C5B27D6", hash_generated_field = "60C86A620843010085E4D0268BFB9814")

    public static final int GL_MAX_TEXTURE_STACK_DEPTH               = 0x0D39;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.036 -0400", hash_original_field = "E66FFA558A5940ACEFC433C994302090", hash_generated_field = "83A60959C83AD96C864DEFB7ABAE4AC9")

    public static final int GL_MAX_TEXTURE_UNITS                     = 0x84E2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.036 -0400", hash_original_field = "E15A84BDB4FA19571A35A7CD9D61DC77", hash_generated_field = "BC4991FCAD83DB0A7868B26EBDE034D9")

    public static final int GL_MAX_VIEWPORT_DIMS                     = 0x0D3A;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.036 -0400", hash_original_field = "BD24D1D0F34A20203222EBD78773DA42", hash_generated_field = "740C93E3D8D876B74C865DE85E68100A")

    public static final int GL_MODELVIEW                             = 0x1700;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.036 -0400", hash_original_field = "1FD63C029527EACB7136B13FEE1003A8", hash_generated_field = "73E49FDB3A804D4928F06F74F59462F8")

    public static final int GL_MODULATE                              = 0x2100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.036 -0400", hash_original_field = "7A16AFF5FAC36CB10E94A11BA77AA208", hash_generated_field = "C156FD026A906AD527F64E8DD42BCF39")

    public static final int GL_MULTISAMPLE                           = 0x809D;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.036 -0400", hash_original_field = "54E15E400893160195F7AB49FC886849", hash_generated_field = "3032A5E567BDC33CCD1B098A67429801")

    public static final int GL_NAND                                  = 0x150E;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.036 -0400", hash_original_field = "9BE69359BE4FAEFAA3F60DD821EB575E", hash_generated_field = "B0FB6384C88C83EB4C1A4C10AA65E821")

    public static final int GL_NEAREST                               = 0x2600;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.036 -0400", hash_original_field = "488B0B15A00A3229A4676C745F4D16CE", hash_generated_field = "F0A2FA3AACBA4EA7BA158C2462E7D640")

    public static final int GL_NEAREST_MIPMAP_LINEAR                 = 0x2702;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.036 -0400", hash_original_field = "5E4D49431983D6CB23D879579DBDB007", hash_generated_field = "A2ADEF4D1C78AA83F5B2352C8DBDC6E2")

    public static final int GL_NEAREST_MIPMAP_NEAREST                = 0x2700;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.036 -0400", hash_original_field = "3D51615DF08CA325BD60CB8BE81CB7CC", hash_generated_field = "CA379896EFAC1FCD285FDDEC471ED007")

    public static final int GL_NEVER                                 = 0x0200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.036 -0400", hash_original_field = "FAD71CDAADA4161E2C3890104D68FFD0", hash_generated_field = "6B136FADA83CBD44BC9F1E2EEBAE0BD5")

    public static final int GL_NICEST                                = 0x1102;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.036 -0400", hash_original_field = "E272446CE554D8EE1DBDA1A31077FD6C", hash_generated_field = "0653236F53D5E9A2C959345944242124")

    public static final int GL_NO_ERROR                              = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.036 -0400", hash_original_field = "E8913DCFD03D3C0E32323E10B13365BD", hash_generated_field = "3F1C265BDD42A6D0315AAFE8F09131D1")

    public static final int GL_NOOP                                  = 0x1505;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.036 -0400", hash_original_field = "FEDC0225103F5FF4AA1D95B03C525CB6", hash_generated_field = "18B7E9E1BA6195643B53D2A9AAF14D1E")

    public static final int GL_NOR                                   = 0x1508;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.036 -0400", hash_original_field = "2999F00AEB586E0447B740F05EFBA093", hash_generated_field = "3F4BE46C087510D64FA53C02FA1CBC92")

    public static final int GL_NORMAL_ARRAY                          = 0x8075;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.037 -0400", hash_original_field = "727DAC01F62C93F7AF52FA86D4B11938", hash_generated_field = "43829DD71C6737F206FDDC66EBBBD41E")

    public static final int GL_NORMALIZE                             = 0x0BA1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.037 -0400", hash_original_field = "C58C3C8ACDC5F1136CF8940BF14C8E0D", hash_generated_field = "9D163E05C29CDB049D5EFDCB69A11F5B")

    public static final int GL_NOTEQUAL                              = 0x0205;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.037 -0400", hash_original_field = "27E5E17196D3B0EE6B4E13DAFB61E363", hash_generated_field = "6B49EE83F1713650B4936148C3D6E1BC")

    public static final int GL_NUM_COMPRESSED_TEXTURE_FORMATS        = 0x86A2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.037 -0400", hash_original_field = "A6E0BBD75CDE8D03D67B820A733B579A", hash_generated_field = "82D5FE136043639857A6207E913F1A47")

    public static final int GL_ONE                                   = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.037 -0400", hash_original_field = "B4CD25B289431614AB64FA633A98EAA4", hash_generated_field = "3AEBAEB1CF16CE34127FDC76A8AA5071")

    public static final int GL_ONE_MINUS_DST_ALPHA                   = 0x0305;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.037 -0400", hash_original_field = "1B9DEA330C62CF82AAB8CD4A9AADABB3", hash_generated_field = "77C61F9F16CE09FE063CB4595FE9C0EF")

    public static final int GL_ONE_MINUS_DST_COLOR                   = 0x0307;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.037 -0400", hash_original_field = "D096BA89CE620E0C534C13953E91E551", hash_generated_field = "9C97EBACE4D89BA37F0CE50A2B4086CF")

    public static final int GL_ONE_MINUS_SRC_ALPHA                   = 0x0303;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.037 -0400", hash_original_field = "673E47C14DACC74B65A89D1D24224070", hash_generated_field = "FBD253CA03B8349C32F1201CE77928A2")

    public static final int GL_ONE_MINUS_SRC_COLOR                   = 0x0301;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.039 -0400", hash_original_field = "DBC68E683C529326192A45F7D2CE0BCC", hash_generated_field = "80F56DE664B2AA32726BB92E544F03F9")

    public static final int GL_OR                                    = 0x1507;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.039 -0400", hash_original_field = "A8C9CD608C039329D62EE87EA5BF2BFF", hash_generated_field = "B7C10797E01825622AFA629744754F2A")

    public static final int GL_OR_INVERTED                           = 0x150D;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.039 -0400", hash_original_field = "396149C2E42DB7168AD15EF495C32DC9", hash_generated_field = "12314B03B0236E1D65B12AAEECCA570A")

    public static final int GL_OR_REVERSE                            = 0x150B;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.039 -0400", hash_original_field = "DC7425945A9FE3F202B7030A959ECCAA", hash_generated_field = "E95871CFC24E5C6E759FA8B49E0583BF")

    public static final int GL_OUT_OF_MEMORY                         = 0x0505;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.039 -0400", hash_original_field = "7FEA0DBC57B5C76BBC078F8F4B97C0A6", hash_generated_field = "420168862C9EEAA13A97C845B02656C9")

    public static final int GL_PACK_ALIGNMENT                        = 0x0D05;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.040 -0400", hash_original_field = "30BA3184666F99002F516954D6D1E988", hash_generated_field = "6E71011AF8631728C453BEE15B7B5DBA")

    public static final int GL_PALETTE4_R5_G6_B5_OES                 = 0x8B92;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.040 -0400", hash_original_field = "AA29DF8A06C3336F8A433B776DD66298", hash_generated_field = "67065582CB57B3C138E72ECAD8081F39")

    public static final int GL_PALETTE4_RGB5_A1_OES                  = 0x8B94;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.040 -0400", hash_original_field = "4056BDDCD0659C038C33156586599A62", hash_generated_field = "0C243A77FF74BA1139674E36D1CA7AB1")

    public static final int GL_PALETTE4_RGB8_OES                     = 0x8B90;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.040 -0400", hash_original_field = "1DF57EDA21044D244D0459711FAB2775", hash_generated_field = "EB628C04C68E50F3147DB532B280AAB7")

    public static final int GL_PALETTE4_RGBA4_OES                    = 0x8B93;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.040 -0400", hash_original_field = "6BEC6B39CD162675B27488932853EFB6", hash_generated_field = "0BF68A287D4F23AB3DA63C8FD7684E95")

    public static final int GL_PALETTE4_RGBA8_OES                    = 0x8B91;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.040 -0400", hash_original_field = "3AD2C0D0101A02C8FA75FB437AF7C3E1", hash_generated_field = "960FFADB5ED90D70B6E3FB7102E9C8E1")

    public static final int GL_PALETTE8_R5_G6_B5_OES                 = 0x8B97;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.040 -0400", hash_original_field = "E3C95AFD5DF5A0443D30E25F1609A6A3", hash_generated_field = "3A21DDA7019CF0336BAABE397A967950")

    public static final int GL_PALETTE8_RGB5_A1_OES                  = 0x8B99;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.040 -0400", hash_original_field = "B38E889690832707B921661B4D6BEA6B", hash_generated_field = "A7CADAC9EC391EF396A5FE756E7FB25B")

    public static final int GL_PALETTE8_RGB8_OES                     = 0x8B95;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.040 -0400", hash_original_field = "9ED72EA49DEE91FE155FFA08904AE944", hash_generated_field = "064376BF7F9C14290F210642DBB3605A")

    public static final int GL_PALETTE8_RGBA4_OES                    = 0x8B98;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.040 -0400", hash_original_field = "1F3B3FAE199DEBF15CBA66DB4C9A59E9", hash_generated_field = "4125779681067A28CF0738094BF99EDE")

    public static final int GL_PALETTE8_RGBA8_OES                    = 0x8B96;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.040 -0400", hash_original_field = "A6C72C0F41CF3E09FA6665B0A686D7D2", hash_generated_field = "F5F7B445E6936478867FC77FE0835D68")

    public static final int GL_PERSPECTIVE_CORRECTION_HINT           = 0x0C50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.040 -0400", hash_original_field = "FE964E50B9D4664A26BF959159E22725", hash_generated_field = "C7E4DE85CE1CC2EFFB63BE988898F30F")

    public static final int GL_POINT_SMOOTH                          = 0x0B10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.040 -0400", hash_original_field = "12A709698C763974855A6A5B74999B4F", hash_generated_field = "B7166765151D437013F461E263F390C5")

    public static final int GL_POINT_SMOOTH_HINT                     = 0x0C51;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.040 -0400", hash_original_field = "A0DEAB85678856F70C3551801F4F9F05", hash_generated_field = "3AEB111123D4B87DB7AFE0BBC7526140")

    public static final int GL_POINTS                                = 0x0000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.040 -0400", hash_original_field = "7FC1486A1574B7B0DE6987256D891AF5", hash_generated_field = "9C29D60FA8E6E6ED9DBE90CC6638837E")

    public static final int GL_POINT_FADE_THRESHOLD_SIZE             = 0x8128;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.040 -0400", hash_original_field = "6A84B133830E282F3C5091488CE46B8A", hash_generated_field = "884E2C3B57DFAADABA663012091B4580")

    public static final int GL_POINT_SIZE                            = 0x0B11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.040 -0400", hash_original_field = "0F08D749CA74E2FE01651D5FE3A8A4D2", hash_generated_field = "A9BCF6D80660E88427AD2FFB50877931")

    public static final int GL_POLYGON_OFFSET_FILL                   = 0x8037;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.040 -0400", hash_original_field = "CA22DB2B13E2C7BB510E165AACC6B86C", hash_generated_field = "8026E5960476EE448734A9AD1D73EB47")

    public static final int GL_POLYGON_SMOOTH_HINT                   = 0x0C53;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.040 -0400", hash_original_field = "A58E55C6FB08016999C13831B6BA668D", hash_generated_field = "998F948A2ADD5ECD8FB2B8CFD946F083")

    public static final int GL_POSITION                              = 0x1203;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.040 -0400", hash_original_field = "F8F6B70F9AC440765F8ED37C8194712B", hash_generated_field = "F9D5848D419F9D4EA5EB074827AB7B99")

    public static final int GL_PROJECTION                            = 0x1701;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.040 -0400", hash_original_field = "FD024EE60DD08E72585CF9A257132B02", hash_generated_field = "4D69C053353BF0375CBDEFF4AFBFF53C")

    public static final int GL_QUADRATIC_ATTENUATION                 = 0x1209;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.040 -0400", hash_original_field = "86EE157263D0AF5638902794F52F195A", hash_generated_field = "C50548619DDE0126722D8AB15FF2EF16")

    public static final int GL_RED_BITS                              = 0x0D52;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.040 -0400", hash_original_field = "98273F7F5EC8F02266A34B0F890E05BF", hash_generated_field = "9F902BB754AA320AF68CBD170F59FDF5")

    public static final int GL_RENDERER                              = 0x1F01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.040 -0400", hash_original_field = "893703471771D7A5A5D4015AA5128BB3", hash_generated_field = "0D42C554C0527A3A4F6ED53657A8F36A")

    public static final int GL_REPEAT                                = 0x2901;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.040 -0400", hash_original_field = "B533B1F6BA488CB7361ADCCEA076A5C0", hash_generated_field = "7825B8439D0B67AC7D326B5C83947881")

    public static final int GL_REPLACE                               = 0x1E01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.040 -0400", hash_original_field = "74A41B6D470E9C1F10D6E0FA1C7E8958", hash_generated_field = "7DB76300EC4BE9E2609D28090A8278E6")

    public static final int GL_RESCALE_NORMAL                        = 0x803A;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.040 -0400", hash_original_field = "79D94ECC8ED2B72E6C9EE0A613D67BF6", hash_generated_field = "6A23C406FDB5B7A1B50702BA5CC9C002")

    public static final int GL_RGB                                   = 0x1907;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.040 -0400", hash_original_field = "250D21C790C7F7F82250F6DD60A63A45", hash_generated_field = "C54FF8BC96B52D3F5B82AECAA4368DC3")

    public static final int GL_RGBA                                  = 0x1908;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.040 -0400", hash_original_field = "0BAFA89A78D5E21FC2F15FCD5B116BAD", hash_generated_field = "0C96EEA0B791093940726427BE517D6B")

    public static final int GL_SAMPLE_ALPHA_TO_COVERAGE              = 0x809E;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.040 -0400", hash_original_field = "1F3202BAE8B46157CD99F626A757CA2F", hash_generated_field = "0E73AE151CEF2B958D203993434326FF")

    public static final int GL_SAMPLE_ALPHA_TO_ONE                   = 0x809F;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.041 -0400", hash_original_field = "F3ECCDEBB2CC14C5C179CC60F1819510", hash_generated_field = "E4DE56A2A355F1A7C7E2A493405E4965")

    public static final int GL_SAMPLE_COVERAGE                       = 0x80A0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.041 -0400", hash_original_field = "B556BC4F74EC161C972F7165DE856262", hash_generated_field = "62D9DAC9732EE80D837C16904113DAEA")

    public static final int GL_SCISSOR_TEST                          = 0x0C11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.041 -0400", hash_original_field = "EBAA7B005F98D0FE92FDF0F342F02AD7", hash_generated_field = "9CB846346BE94B52C52BE7794A8736B5")

    public static final int GL_SET                                   = 0x150F;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.041 -0400", hash_original_field = "3E9F0976E7851A45598430469B89A994", hash_generated_field = "DD582C04EF1BE601FA83D17CD2612018")

    public static final int GL_SHININESS                             = 0x1601;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.041 -0400", hash_original_field = "24EE400976B1DCE7FA604237E21D9EF1", hash_generated_field = "CEC9DBF8A25C09C8EE36A2040FCE90EC")

    public static final int GL_SHORT                                 = 0x1402;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.041 -0400", hash_original_field = "C964F7E4D3F74657FA2AFE820ED55B6B", hash_generated_field = "9DF9EDCCCD8DDF8E857FDA6D3F4F7DBE")

    public static final int GL_SMOOTH                                = 0x1D01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.041 -0400", hash_original_field = "9EE0F10DC77B31202C49D02FD8E6A353", hash_generated_field = "C30E5625814CB50255AB78BB7DA42F4D")

    public static final int GL_SMOOTH_LINE_WIDTH_RANGE               = 0x0B22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.041 -0400", hash_original_field = "7C37DF787C2877AD642280D837656C06", hash_generated_field = "A799B28566EA058D37D89C7D458E78EE")

    public static final int GL_SMOOTH_POINT_SIZE_RANGE               = 0x0B12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.041 -0400", hash_original_field = "575A3D501C6AFBF40BD07A0E00C53BA9", hash_generated_field = "95BEA1C61974D1DF0E8F69C4BA7DF04F")

    public static final int GL_SPECULAR                              = 0x1202;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.041 -0400", hash_original_field = "D7FF8675DB3DB2F79A920996C36B4736", hash_generated_field = "7BD68C4D23E779D5379C002B53B7DA06")

    public static final int GL_SPOT_CUTOFF                           = 0x1206;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.041 -0400", hash_original_field = "3EDE16B2384497C3146FE629830B47E9", hash_generated_field = "65D3A16B2BD9979E240E9E4E835121C5")

    public static final int GL_SPOT_DIRECTION                        = 0x1204;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.041 -0400", hash_original_field = "0615B956BC263D9023C9D2E2B63A6644", hash_generated_field = "5876C8792992CB3A2FAF78DBD67F9AC3")

    public static final int GL_SPOT_EXPONENT                         = 0x1205;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.041 -0400", hash_original_field = "EBAD21E42B574E8C0309DFA0D3A12C06", hash_generated_field = "DD041534D4A71692473722C9C3DA669C")

    public static final int GL_SRC_ALPHA                             = 0x0302;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.041 -0400", hash_original_field = "3EF1DA197E57D716CE3D44DC9F9B8D75", hash_generated_field = "70AEA0E98FC9C061FAC240ADA8332C5A")

    public static final int GL_SRC_ALPHA_SATURATE                    = 0x0308;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.041 -0400", hash_original_field = "36ADCC9AAD8E40BA95A5A2EE997B2504", hash_generated_field = "C2011F8B7C7C63680FD638429313D1E6")

    public static final int GL_SRC_COLOR                             = 0x0300;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.041 -0400", hash_original_field = "2BD846D8ED269751C4F2849E671FA30E", hash_generated_field = "C11D5F5E1FCC59AF256FCC31CB234897")

    public static final int GL_STACK_OVERFLOW                        = 0x0503;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.041 -0400", hash_original_field = "B9E52AA7DD4C82B8FBD406E05C008CF4", hash_generated_field = "8C3794E0BC4CCD7174221E7F186FA5B6")

    public static final int GL_STACK_UNDERFLOW                       = 0x0504;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.041 -0400", hash_original_field = "35BAAB6F6E562C8D2A26A187F6C312A9", hash_generated_field = "C15714275693DB4FD1855853B46EB0D8")

    public static final int GL_STENCIL_BITS                          = 0x0D57;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.041 -0400", hash_original_field = "F8440947DE0695D39C7BA9BCDACCA71A", hash_generated_field = "221627FEE208D0522BB5C3111C9D1FD5")

    public static final int GL_STENCIL_BUFFER_BIT                    = 0x0400;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.041 -0400", hash_original_field = "894BE111258A6B18FF77F63667177FA8", hash_generated_field = "8DC539E2C1E101290729428C524DA2DC")

    public static final int GL_STENCIL_TEST                          = 0x0B90;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.041 -0400", hash_original_field = "939B31BD3DC4A69FE3A195CBCC3A233A", hash_generated_field = "4F10C209D49E9D5A5FC0C3797AA306D8")

    public static final int GL_SUBPIXEL_BITS                         = 0x0D50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.041 -0400", hash_original_field = "A5DF03B9478D14E72E1E3FBEF4406430", hash_generated_field = "D123EB9A72FA50D7D443B3DBF04FC9B1")

    public static final int GL_TEXTURE                               = 0x1702;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.041 -0400", hash_original_field = "A92A76DB6CB9AA05FBA60F7D549F80B4", hash_generated_field = "CFA8DF52C890C8F91C1BA2D266BB91EB")

    public static final int GL_TEXTURE_2D                            = 0x0DE1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.041 -0400", hash_original_field = "BF0CE546574A796330F052E9D3016320", hash_generated_field = "7F2496749EFA918509600AB619E8D791")

    public static final int GL_TEXTURE_COORD_ARRAY                   = 0x8078;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.041 -0400", hash_original_field = "D67D6EF05845B9FFFA8DB602125D9770", hash_generated_field = "9D9F670C0CE058448AD88C16F5E3EB98")

    public static final int GL_TEXTURE_ENV                           = 0x2300;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.041 -0400", hash_original_field = "B00C3EEEDE4EDC116CC41219FC90C5A3", hash_generated_field = "8E10958B00705AA7561B64315A59C454")

    public static final int GL_TEXTURE_ENV_COLOR                     = 0x2201;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.041 -0400", hash_original_field = "D02A0DFA198597AE34A6CD836D47D3AA", hash_generated_field = "54FE1A0F6DDE9D8E380CC763FDBC221B")

    public static final int GL_TEXTURE_ENV_MODE                      = 0x2200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.041 -0400", hash_original_field = "2B6CFF1A5EAC91C188C9BF29BB32E747", hash_generated_field = "0F8FE623FD8E0ED110006D791288A686")

    public static final int GL_TEXTURE_MAG_FILTER                    = 0x2800;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.041 -0400", hash_original_field = "E90F72F5048AE41ACD1EE0FF2923FFFF", hash_generated_field = "702299E7AFC47AA8D9BFCB1EE1AA1BAA")

    public static final int GL_TEXTURE_MIN_FILTER                    = 0x2801;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.041 -0400", hash_original_field = "26B19CB86E36452C2B54BC27632B2BC2", hash_generated_field = "79FED79498C93220A14654ACE7E303EB")

    public static final int GL_TEXTURE_WRAP_S                        = 0x2802;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.041 -0400", hash_original_field = "0617F75267EDC6D104B54EF6E55AA0A7", hash_generated_field = "BA13CBAC042E1A4FD3E8BBA4033145DC")

    public static final int GL_TEXTURE_WRAP_T                        = 0x2803;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.041 -0400", hash_original_field = "2D1F9898C91B0F87E3446BC7D669E570", hash_generated_field = "BA0F4FF4C8B05303345E6F0BCE004F67")

    public static final int GL_TEXTURE0                              = 0x84C0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.042 -0400", hash_original_field = "6AF29586D6768D9C8AE48115D9C97B93", hash_generated_field = "6368F222D7BE49D35F9CAFE86DFDD44A")

    public static final int GL_TEXTURE1                              = 0x84C1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.042 -0400", hash_original_field = "60497C35476D632D721C17C32B922673", hash_generated_field = "F9606689F311997886F22F3B4A4D9951")

    public static final int GL_TEXTURE2                              = 0x84C2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.042 -0400", hash_original_field = "CAF320E9076F9EA3BA5698F988E004EB", hash_generated_field = "EB7A66E482516BA8A83A2C0901AE9821")

    public static final int GL_TEXTURE3                              = 0x84C3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.042 -0400", hash_original_field = "E1C4031C118EBDAC97711ECC98D8932C", hash_generated_field = "8C3019ADB0DB73957332280BCB5C776D")

    public static final int GL_TEXTURE4                              = 0x84C4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.042 -0400", hash_original_field = "163640337500173F6B38E97AB6D0B4ED", hash_generated_field = "0ADC913BC5A636AC0043EEAB35B38ABE")

    public static final int GL_TEXTURE5                              = 0x84C5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.042 -0400", hash_original_field = "2D564C34E10B272BD5A552FDF88E18C3", hash_generated_field = "B031ADC1DCEDC2622EBDBEE78D98E599")

    public static final int GL_TEXTURE6                              = 0x84C6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.042 -0400", hash_original_field = "5D21405BBBDC8183693B38BD09F12AB9", hash_generated_field = "F0C1EE436F2FA5C7CF66757834968528")

    public static final int GL_TEXTURE7                              = 0x84C7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.042 -0400", hash_original_field = "9DC0ED1377156862BD12AAF1D23104E1", hash_generated_field = "378DF8E3660EABD42DFAE32C9CC7F398")

    public static final int GL_TEXTURE8                              = 0x84C8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.042 -0400", hash_original_field = "3D1165CC1CC15873E950B87BF3F1AC38", hash_generated_field = "3C3FCB1A67F035913B43C79D2D75D872")

    public static final int GL_TEXTURE9                              = 0x84C9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.042 -0400", hash_original_field = "2EAD997E695D0161EDBC3211C555CF25", hash_generated_field = "776A57758332051D1D11DFE46DC41B12")

    public static final int GL_TEXTURE10                             = 0x84CA;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.042 -0400", hash_original_field = "DB02A680E4376411CB1666A873996E6F", hash_generated_field = "96905C885C6A888FEFF76AC4318D88E0")

    public static final int GL_TEXTURE11                             = 0x84CB;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.042 -0400", hash_original_field = "1E502064FD3335685A2AEC4541E09CD8", hash_generated_field = "E53F5986F1DCA42B824D147FF7D61D0C")

    public static final int GL_TEXTURE12                             = 0x84CC;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.042 -0400", hash_original_field = "8F2A1205B30D2FF145B54AC22C370404", hash_generated_field = "D736272A012DC1B2C7D4F2075A10371A")

    public static final int GL_TEXTURE13                             = 0x84CD;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.042 -0400", hash_original_field = "1F958EC6DCD072661F1212CBE4854A2F", hash_generated_field = "A5B1A8D739FEE7A61A47B638606088EA")

    public static final int GL_TEXTURE14                             = 0x84CE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.042 -0400", hash_original_field = "39E3FCD5A29A0C1FDAB419BFF0FCACEA", hash_generated_field = "2D1B4D0A36141BF734DC607A7894592F")

    public static final int GL_TEXTURE15                             = 0x84CF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.042 -0400", hash_original_field = "108E967F5FCBF7618F14E7656EAB8891", hash_generated_field = "0FAE9C9EBBAA9BF0C721E851AF3EDE0D")

    public static final int GL_TEXTURE16                             = 0x84D0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.042 -0400", hash_original_field = "B00876FBFA7170FB326F65402B46F6BC", hash_generated_field = "C0ACBBDC95FC99E0E86F764F882B7F88")

    public static final int GL_TEXTURE17                             = 0x84D1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.042 -0400", hash_original_field = "51995D26EAD26150B355729BD25C17FF", hash_generated_field = "B5B5A27665F1BB7E1FEDCA77A03AA883")

    public static final int GL_TEXTURE18                             = 0x84D2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.042 -0400", hash_original_field = "580BFA1F047CD645FC8294536DD3F50F", hash_generated_field = "99C75295F9DE85B97D0A81F7CA5EA203")

    public static final int GL_TEXTURE19                             = 0x84D3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.042 -0400", hash_original_field = "A2C6326F2A134054463F06B4475B423D", hash_generated_field = "CD24AFB64E44A02D63932BE13470E6AA")

    public static final int GL_TEXTURE20                             = 0x84D4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.042 -0400", hash_original_field = "C7E4887328EE1695C1C8328D9DD17073", hash_generated_field = "E82035766A7DC3AC3F6B37809B251C21")

    public static final int GL_TEXTURE21                             = 0x84D5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.042 -0400", hash_original_field = "A4DCFBCFABB56511752992C9CC0F5DD4", hash_generated_field = "BD518C3B1A0B2D9E43F6B7C2A20DFE2F")

    public static final int GL_TEXTURE22                             = 0x84D6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.042 -0400", hash_original_field = "1E6141D9A885C049646CEFB2C839B7AC", hash_generated_field = "E51DAC73DF5C45484DA3FB37491A0EE5")

    public static final int GL_TEXTURE23                             = 0x84D7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.042 -0400", hash_original_field = "E035C4D4CFF946A33E67CB0A3B83B596", hash_generated_field = "B22E032B85EB699368B06AC87FE2B898")

    public static final int GL_TEXTURE24                             = 0x84D8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.042 -0400", hash_original_field = "E32773CD7031D2CB5C507B749A70D86E", hash_generated_field = "B8105530A28A057AD49118429901D7B6")

    public static final int GL_TEXTURE25                             = 0x84D9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.042 -0400", hash_original_field = "78F759D6424EEFA24F83E2D1F33B79C2", hash_generated_field = "4B11DEEFAF68B9BB74AC3A4FBDF965FF")

    public static final int GL_TEXTURE26                             = 0x84DA;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.042 -0400", hash_original_field = "988A2D4E826AB8F927A8730B903F168E", hash_generated_field = "02DEAA70ADF70018857298DDA1032C62")

    public static final int GL_TEXTURE27                             = 0x84DB;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.042 -0400", hash_original_field = "0DAB4AC47D0AF4435936C4445CAA694F", hash_generated_field = "165C9ED7F06E643264EE9C4A9240B619")

    public static final int GL_TEXTURE28                             = 0x84DC;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.042 -0400", hash_original_field = "CB78ED601CBEF91891CBD57D76BE77D8", hash_generated_field = "6F3D9C17432273490A88EAA2FBA96C4E")

    public static final int GL_TEXTURE29                             = 0x84DD;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.042 -0400", hash_original_field = "1E27BFAB12F5DB6A56CF1132406910F2", hash_generated_field = "01235E8CF92D5BA414CDD25B6604F79E")

    public static final int GL_TEXTURE30                             = 0x84DE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.043 -0400", hash_original_field = "FC9EA3CC4CA42A2F7F55EC63153F1982", hash_generated_field = "C8151127B3E9F7F60F918EEFDAFCC4BD")

    public static final int GL_TEXTURE31                             = 0x84DF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.043 -0400", hash_original_field = "152A59DE3C8BFA0CBD7404F3E2542224", hash_generated_field = "E319033744A6FD5FBED22534A09D0D9A")

    public static final int GL_TRIANGLE_FAN                          = 0x0006;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.043 -0400", hash_original_field = "49290671357E72E66662A3E469BB14D3", hash_generated_field = "2DFC30CE5B5D0C909353FE0F8E82ECAE")

    public static final int GL_TRIANGLE_STRIP                        = 0x0005;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.043 -0400", hash_original_field = "49C90D0A56EDD50EFC7AE8F554C87FFD", hash_generated_field = "E770048AE0B8EE2CF20B5355345E232E")

    public static final int GL_TRIANGLES                             = 0x0004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.043 -0400", hash_original_field = "B01F68C6C3BB3B207C4B4E485AAD1606", hash_generated_field = "61D712C997F883C5E54B2F3515C8B065")

    public static final int GL_TRUE                                  = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.043 -0400", hash_original_field = "EEC0689D81D81C50C16EB1A68581B32B", hash_generated_field = "07391187CDB7D66B8228865535D68F9C")

    public static final int GL_UNPACK_ALIGNMENT                      = 0x0CF5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.043 -0400", hash_original_field = "CE83B214B66039AF4C5B212C15D93173", hash_generated_field = "D9C771F554A8939A1729582F2211DA5D")

    public static final int GL_UNSIGNED_BYTE                         = 0x1401;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.043 -0400", hash_original_field = "E015E36E89D7DA528DBA1D604AFCEB13", hash_generated_field = "CF2E78B3A757A12168ACD04C3937641C")

    public static final int GL_UNSIGNED_SHORT                        = 0x1403;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.043 -0400", hash_original_field = "B7A68302F5F65BA0B48C79B4331A90A5", hash_generated_field = "B20FCFFE737F717A755866C24553F9C3")

    public static final int GL_UNSIGNED_SHORT_4_4_4_4                = 0x8033;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.043 -0400", hash_original_field = "1B988C3EFE7C35E89D512C4DAC163448", hash_generated_field = "C2FA2F9F63044337A428E6E10E6D2AFA")

    public static final int GL_UNSIGNED_SHORT_5_5_5_1                = 0x8034;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.043 -0400", hash_original_field = "5F6C1C5E9BE6532DB4BA318B32B0F187", hash_generated_field = "4C7D42068CD7D103E43E5E903CF95B76")

    public static final int GL_UNSIGNED_SHORT_5_6_5                  = 0x8363;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.043 -0400", hash_original_field = "6F10BB3EEEA68FE4CFE758AAF179598B", hash_generated_field = "F31B958C8F10E182C79082E291A281D3")

    public static final int GL_VENDOR                                = 0x1F00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.043 -0400", hash_original_field = "88813588EEE2E3A420DD98420E57A8F1", hash_generated_field = "ED8862F66460C23F886758F9B875895E")

    public static final int GL_VERSION                               = 0x1F02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.043 -0400", hash_original_field = "1988780674739821E2E10D4075606336", hash_generated_field = "3990C55AAECCCFAEA365D6980417A473")

    public static final int GL_VERTEX_ARRAY                          = 0x8074;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.043 -0400", hash_original_field = "98D4D65B4F5BC7589BBCF336C559AC06", hash_generated_field = "6E6721A9B523AF92C6B8D975826C22B9")

    public static final int GL_XOR                                   = 0x1506;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.043 -0400", hash_original_field = "111FC8EDA50E7ADBC286866D6C474575", hash_generated_field = "2AE94B595542B2CF364EA127E42FBDCE")

    public static final int GL_ZERO                                  = 0;
    static {
	    _nativeClassInit();
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.043 -0400", hash_original_field = "00D43C45545BEAB276C8B6E7584D8726", hash_generated_field = "CC0DE27B6F7397C17CC69EA408C69F1E")

    private static Buffer _colorPointer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.043 -0400", hash_original_field = "8EB1F8CC3C950259BDE4D5C978B61A86", hash_generated_field = "C2CCFC200FD14AD989DA8589B75E7348")

    private static Buffer _normalPointer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.043 -0400", hash_original_field = "6BF557F8D1797661B3E616241BE86B27", hash_generated_field = "9B1316D706ADB0AC88260735536598A3")

    private static Buffer _texCoordPointer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.043 -0400", hash_original_field = "40D9459A4ECC0DE7954A9152F8631D8C", hash_generated_field = "B911415BE838F3334EDD65DA9B0BAD98")

    private static Buffer _vertexPointer;
}

