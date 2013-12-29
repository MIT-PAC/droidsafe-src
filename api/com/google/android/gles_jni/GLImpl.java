package com.google.android.gles_jni;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.Buffer;

import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL10Ext;
import javax.microedition.khronos.opengles.GL11;
import javax.microedition.khronos.opengles.GL11Ext;
import javax.microedition.khronos.opengles.GL11ExtensionPack;

import android.app.AppGlobals;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.os.Build;
import android.util.Log;





public class GLImpl implements GL10, GL10Ext, GL11, GL11Ext, GL11ExtensionPack {

    
    @DSModeled(DSC.SAFE)
    private static void _nativeClassInit() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.521 -0500", hash_original_method = "E04EF08BFD93A483AA0844852D39BA58", hash_generated_method = "9829AD318F7509A81CFA7788602F79B9")
    private static boolean allowIndirectBuffers(String appName) {
        boolean result = false;
        int version = 0;
        IPackageManager pm = AppGlobals.getPackageManager();
        try {
            ApplicationInfo applicationInfo = pm.getApplicationInfo(appName, 0);
            if (applicationInfo != null) {
                version = applicationInfo.targetSdkVersion;
            }
        } catch (android.os.RemoteException e) {
            // ignore
        }
        Log.e("OpenGLES", String.format(
            "Application %s (SDK target %d) called a GL11 Pointer method with an indirect Buffer.",
            appName, version));
        if (version <= Build.VERSION_CODES.CUPCAKE) {
            result = true;
        }
        return result;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.510 -0500", hash_original_field = "15CBD0DB05354E49FA41EDA6F6894843", hash_generated_field = "15CBD0DB05354E49FA41EDA6F6894843")


    Buffer _colorPointer = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.511 -0500", hash_original_field = "1D9638494227294B6707A326980392B7", hash_generated_field = "1D9638494227294B6707A326980392B7")

    Buffer _normalPointer = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.512 -0500", hash_original_field = "A097629D9CDA30DDF5BE5A14512EB23F", hash_generated_field = "A097629D9CDA30DDF5BE5A14512EB23F")

    Buffer _texCoordPointer = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.513 -0500", hash_original_field = "00B0011F84BCEE8409C349D31613FF06", hash_generated_field = "00B0011F84BCEE8409C349D31613FF06")

    Buffer _vertexPointer = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.513 -0500", hash_original_field = "4CBE9C8ACE3C168F1CD97C057E7266C4", hash_generated_field = "4CBE9C8ACE3C168F1CD97C057E7266C4")

    Buffer _pointSizePointerOES = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.514 -0500", hash_original_field = "DD8607AFD26FDEAB9A9B73DCDCB63BB2", hash_generated_field = "DD8607AFD26FDEAB9A9B73DCDCB63BB2")

    Buffer _matrixIndexPointerOES = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.515 -0500", hash_original_field = "41E3253F5FB30C5383FBE43DCA9E249D", hash_generated_field = "41E3253F5FB30C5383FBE43DCA9E249D")

    Buffer _weightPointerOES = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.515 -0500", hash_original_field = "73A1F70905A1BE33646C96B7C05B64F3", hash_generated_field = "AF11D4A762D9150D29527EF81F1566DE")

    
    private boolean haveCheckedExtensions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.516 -0500", hash_original_field = "0C660BE3729DC93ABED19DDBD7A37606", hash_generated_field = "84E67FD7C266DDF7D2E0C04DAF1F0E62")

    private boolean have_OES_blend_equation_separate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.517 -0500", hash_original_field = "1B46EC03537D0FB42CE459FDDC7EE386", hash_generated_field = "B6A044407641930A7CE41C04E383ED0F")

    private boolean have_OES_blend_subtract;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.518 -0500", hash_original_field = "B9F9910695EBD901D3E6661CB64751B6", hash_generated_field = "FA9978BE7CE9264B5E6B531CE7E2C25D")

    private boolean have_OES_framebuffer_object;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.519 -0500", hash_original_field = "2FB99007DC3EFC3B765077A6B9939870", hash_generated_field = "C64C57713C6D3FD3A3964CCE4EB4099C")

    private boolean have_OES_texture_cube_map;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.519 -0500", hash_original_method = "B8D773F1A7CFA96D2497C742B1D0AB9A", hash_generated_method = "9F5A49AA48AD01F7014749F961360A93")
    public GLImpl() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.520 -0500", hash_original_method = "16A1ADA10B85F20D9DE0E81A43C2050C", hash_generated_method = "8CDF9B55474B65C865A584623DFC99FA")
    public void glGetPointerv(int pname, java.nio.Buffer[] params) {
        throw new UnsupportedOperationException("glGetPointerv");
    }

    // C function void glActiveTexture ( GLenum texture )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.523 -0500", hash_original_method = "97DEC0321FF9B09E49E45C9980AD2CAB", hash_generated_method = "4C6CB1689E9B43619F7847D45B491D64")
    public native void glActiveTexture(
        int texture
    );

    // C function void glAlphaFunc ( GLenum func, GLclampf ref )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.524 -0500", hash_original_method = "E7B4134F951CACA5D3E260E6C8389AD6", hash_generated_method = "C5168120B38BA72F7BE4D976201F8B93")
    public native void glAlphaFunc(
        int func,
        float ref
    );

    // C function void glAlphaFuncx ( GLenum func, GLclampx ref )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.526 -0500", hash_original_method = "0865B3896933828D18B5F3FD6A177BE6", hash_generated_method = "8A7B7848F606DDD618E1728598D80E53")
    public native void glAlphaFuncx(
        int func,
        int ref
    );

    // C function void glBindTexture ( GLenum target, GLuint texture )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.527 -0500", hash_original_method = "F26D066144D77B7F711F4AD20988DF70", hash_generated_method = "C73E8721A849242A56365AB35218C20C")
    public native void glBindTexture(
        int target,
        int texture
    );

    // C function void glBlendFunc ( GLenum sfactor, GLenum dfactor )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.528 -0500", hash_original_method = "A2FFC2EC79748E7F073DCEF2CA88E7F7", hash_generated_method = "5834D0729F8A966A3F391E75D435CE68")
    public native void glBlendFunc(
        int sfactor,
        int dfactor
    );

    // C function void glClear ( GLbitfield mask )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.529 -0500", hash_original_method = "CEF5782DE326F4639690136522E382D5", hash_generated_method = "5177EC30EAFA0F898076FB6D3A77D7C2")
    public native void glClear(
        int mask
    );

    // C function void glClearColor ( GLclampf red, GLclampf green, GLclampf blue, GLclampf alpha )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.531 -0500", hash_original_method = "7CE69D057BBB96A8C17F9D52DC80AA96", hash_generated_method = "13E3481C51988F6F5C45FCE84287C1AD")
    public native void glClearColor(
        float red,
        float green,
        float blue,
        float alpha
    );

    // C function void glClearColorx ( GLclampx red, GLclampx green, GLclampx blue, GLclampx alpha )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.532 -0500", hash_original_method = "275A5B33E1A225983A518F82979B2F68", hash_generated_method = "7619B5ACBB76D9730A14EDB110B21B74")
    public native void glClearColorx(
        int red,
        int green,
        int blue,
        int alpha
    );

    // C function void glClearDepthf ( GLclampf depth )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.533 -0500", hash_original_method = "1EB7D9BA90DAFE23078810226BAE8C0C", hash_generated_method = "8FCB3131F3E51472F3EC329B10BFD2C8")
    public native void glClearDepthf(
        float depth
    );

    // C function void glClearDepthx ( GLclampx depth )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.534 -0500", hash_original_method = "3F34D4A59EEDC6C0D2CA3EEB8AC8090C", hash_generated_method = "FD164E16F23F5F0B4FBE95D359424E07")
    public native void glClearDepthx(
        int depth
    );

    // C function void glClearStencil ( GLint s )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.536 -0500", hash_original_method = "0B981F79246B08586C7CE02E0CA71119", hash_generated_method = "DCA4DF71FD50A733261078992B7B41A1")
    public native void glClearStencil(
        int s
    );

    // C function void glClientActiveTexture ( GLenum texture )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.537 -0500", hash_original_method = "0F933753B69BA360F13E4FB9F8E0065B", hash_generated_method = "78E2341CF250B5EBBB9EFDD3009DE0D8")
    public native void glClientActiveTexture(
        int texture
    );

    // C function void glColor4f ( GLfloat red, GLfloat green, GLfloat blue, GLfloat alpha )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.538 -0500", hash_original_method = "0533CB48F440C5DC30BCFA6724D2A255", hash_generated_method = "33BEFFC2BF733DD54FD2121006416974")
    public native void glColor4f(
        float red,
        float green,
        float blue,
        float alpha
    );

    // C function void glColor4x ( GLfixed red, GLfixed green, GLfixed blue, GLfixed alpha )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.540 -0500", hash_original_method = "74951C5E7B28BB879C844C1CB4A28E26", hash_generated_method = "1ECBCF11BA6E32695A29C123766970B0")
    public native void glColor4x(
        int red,
        int green,
        int blue,
        int alpha
    );

    // C function void glColorMask ( GLboolean red, GLboolean green, GLboolean blue, GLboolean alpha )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.541 -0500", hash_original_method = "35F5236562E70DF9BC2799C8D2FADA8F", hash_generated_method = "C836ED1323D0CD8392F19BB75F121492")
    public native void glColorMask(
        boolean red,
        boolean green,
        boolean blue,
        boolean alpha
    );

    // C function void glColorPointer ( GLint size, GLenum type, GLsizei stride, const GLvoid *pointer )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.543 -0500", hash_original_method = "D299BA021168438B5E6E34E52FC6C3F5", hash_generated_method = "493F4A6C3E94A11A15130D27B190F584")
    private native void glColorPointerBounds(
        int size,
        int type,
        int stride,
        java.nio.Buffer pointer,
        int remaining
    );

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.544 -0500", hash_original_method = "BE0504B13DA269CA089182E44C7F834B", hash_generated_method = "0A000298EA6D049157E5BBB4051BF9F9")
    public void glColorPointer(
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

    // C function void glCompressedTexImage2D ( GLenum target, GLint level, GLenum internalformat, GLsizei width, GLsizei height, GLint border, GLsizei imageSize, const GLvoid *data )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.545 -0500", hash_original_method = "1DF16BDBC659AD9A84053C254D5C876E", hash_generated_method = "46F56BEEBCF1B709ED19331B95EA4F52")
    public native void glCompressedTexImage2D(
        int target,
        int level,
        int internalformat,
        int width,
        int height,
        int border,
        int imageSize,
        java.nio.Buffer data
    );

    // C function void glCompressedTexSubImage2D ( GLenum target, GLint level, GLint xoffset, GLint yoffset, GLsizei width, GLsizei height, GLenum format, GLsizei imageSize, const GLvoid *data )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.547 -0500", hash_original_method = "5F3B11428832BB3EDC7989E25F3372FC", hash_generated_method = "DFC7696B63DB31547EC142232A5C781D")
    public native void glCompressedTexSubImage2D(
        int target,
        int level,
        int xoffset,
        int yoffset,
        int width,
        int height,
        int format,
        int imageSize,
        java.nio.Buffer data
    );

    // C function void glCopyTexImage2D ( GLenum target, GLint level, GLenum internalformat, GLint x, GLint y, GLsizei width, GLsizei height, GLint border )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.548 -0500", hash_original_method = "842526CAA5B5EF81DE180C77C64E9061", hash_generated_method = "A015856E8941C769E22B6D7F88137138")
    public native void glCopyTexImage2D(
        int target,
        int level,
        int internalformat,
        int x,
        int y,
        int width,
        int height,
        int border
    );

    // C function void glCopyTexSubImage2D ( GLenum target, GLint level, GLint xoffset, GLint yoffset, GLint x, GLint y, GLsizei width, GLsizei height )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.549 -0500", hash_original_method = "F04240E045617269474207BFBECC16FF", hash_generated_method = "EAE07E73B6D3E1900191858B6FBB7FEE")
    public native void glCopyTexSubImage2D(
        int target,
        int level,
        int xoffset,
        int yoffset,
        int x,
        int y,
        int width,
        int height
    );

    // C function void glCullFace ( GLenum mode )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.551 -0500", hash_original_method = "BF058CF8285375279C20F1E97C513D8F", hash_generated_method = "A023E9FC3C8494DB4ADE2D5887E29F1F")
    public native void glCullFace(
        int mode
    );

    // C function void glDeleteTextures ( GLsizei n, const GLuint *textures )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.552 -0500", hash_original_method = "101445A2DF4F3A2138F3CE9187FCE63C", hash_generated_method = "BC171F5344F1ECDF1716C4E90B6F4D56")
    public native void glDeleteTextures(
        int n,
        int[] textures,
        int offset
    );

    // C function void glDeleteTextures ( GLsizei n, const GLuint *textures )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.553 -0500", hash_original_method = "D095348CAE17C3691EC094768112CBAF", hash_generated_method = "94959CAF323EF44EB8E5A4A1A66344FC")
    public native void glDeleteTextures(
        int n,
        java.nio.IntBuffer textures
    );

    // C function void glDepthFunc ( GLenum func )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.555 -0500", hash_original_method = "8C02F7FAED1907F361FD59A628ECBD22", hash_generated_method = "BDFF66F82487D16850CC21912C45AAB7")
    public native void glDepthFunc(
        int func
    );

    // C function void glDepthMask ( GLboolean flag )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.556 -0500", hash_original_method = "C2DFC52E0130222A386062E7C36C540C", hash_generated_method = "96ED65E3EB60D232B48CA251AC1A8840")
    public native void glDepthMask(
        boolean flag
    );

    // C function void glDepthRangef ( GLclampf zNear, GLclampf zFar )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.558 -0500", hash_original_method = "E7355D3212849EB0BD47CDEAB4ED34D8", hash_generated_method = "85A388F11C5F6195FC6CF7F005ED4533")
    public native void glDepthRangef(
        float zNear,
        float zFar
    );

    // C function void glDepthRangex ( GLclampx zNear, GLclampx zFar )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.559 -0500", hash_original_method = "E32ECE36BCFE7480D9AC74D264F5EFCB", hash_generated_method = "1871F6EBB7CD5F18475D2F4B58AEC6BB")
    public native void glDepthRangex(
        int zNear,
        int zFar
    );

    // C function void glDisable ( GLenum cap )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.560 -0500", hash_original_method = "256D91725811492CC49701A657A0BEE5", hash_generated_method = "003A969863429C1AEEEE9465FCEC2B03")
    public native void glDisable(
        int cap
    );

    // C function void glDisableClientState ( GLenum array )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.562 -0500", hash_original_method = "45A7662FE3309DCB52E9D50B8B88E585", hash_generated_method = "37C33353C2EB36E449AD9FA72A50B296")
    public native void glDisableClientState(
        int array
    );

    // C function void glDrawArrays ( GLenum mode, GLint first, GLsizei count )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.563 -0500", hash_original_method = "D8CC37788E3378C496F8ED8C8C656160", hash_generated_method = "9363B3EF00BCAF7E1D1E5E9D4D6FB8F2")
    public native void glDrawArrays(
        int mode,
        int first,
        int count
    );

    // C function void glDrawElements ( GLenum mode, GLsizei count, GLenum type, const GLvoid *indices )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.564 -0500", hash_original_method = "AA331AE5D7C80D1BAA992FA5E2ACE318", hash_generated_method = "C89D7AA545DE8085CC5883ED3DB13551")
    public native void glDrawElements(
        int mode,
        int count,
        int type,
        java.nio.Buffer indices
    );

    // C function void glEnable ( GLenum cap )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.566 -0500", hash_original_method = "DA63A528B7CE4387E843DC02AB39FA4E", hash_generated_method = "D9F80F8D24656D37C8368128FFA0C2BE")
    public native void glEnable(
        int cap
    );

    // C function void glEnableClientState ( GLenum array )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.567 -0500", hash_original_method = "65AED86EB3A5CAC39903F830C4DC3A62", hash_generated_method = "4944C5B48EEB70BB7E980F2D26D1EB64")
    public native void glEnableClientState(
        int array
    );

    // C function void glFinish ( void )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.568 -0500", hash_original_method = "B245C18D1679C9F54DA6F9DB4AB7671B", hash_generated_method = "1E29E5E52DCE953B11B35317ED42906C")
    public native void glFinish(
    );

    // C function void glFlush ( void )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.570 -0500", hash_original_method = "0DC82BEA9D8586E19F2791A82FAA6841", hash_generated_method = "FAAEF6F7F644A398A44B4BE0A342A89A")
    public native void glFlush(
    );

    // C function void glFogf ( GLenum pname, GLfloat param )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.571 -0500", hash_original_method = "B9E8FFE3840C500F758630055A918A38", hash_generated_method = "1F6DB70DCFE39A47E229B48932E17D5B")
    public native void glFogf(
        int pname,
        float param
    );

    // C function void glFogfv ( GLenum pname, const GLfloat *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.573 -0500", hash_original_method = "BE00E22E98F513D77F19185FDB52DF2B", hash_generated_method = "DD642F78E1448B4DF6BFE9A88C2B7DF3")
    public native void glFogfv(
        int pname,
        float[] params,
        int offset
    );

    // C function void glFogfv ( GLenum pname, const GLfloat *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.574 -0500", hash_original_method = "AD37BF249EE97473580D297C4497D098", hash_generated_method = "6B46FC8B7A190FD10777D13521F87EBA")
    public native void glFogfv(
        int pname,
        java.nio.FloatBuffer params
    );

    // C function void glFogx ( GLenum pname, GLfixed param )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.575 -0500", hash_original_method = "D2A635C8556AD8704E3B26380CA4E66B", hash_generated_method = "CA57CC54A0EE0E44305F2931F9E503B4")
    public native void glFogx(
        int pname,
        int param
    );

    // C function void glFogxv ( GLenum pname, const GLfixed *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.576 -0500", hash_original_method = "56931392328BA8F65D6B9AE45F613231", hash_generated_method = "5C0B6F72655C3BEAB93D22EE1D36C200")
    public native void glFogxv(
        int pname,
        int[] params,
        int offset
    );

    // C function void glFogxv ( GLenum pname, const GLfixed *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.578 -0500", hash_original_method = "D9ACE5927E1ADC9EC43FDBC1C3AFD392", hash_generated_method = "6EF281F0C8416D6A9A43C857E7423973")
    public native void glFogxv(
        int pname,
        java.nio.IntBuffer params
    );

    // C function void glFrontFace ( GLenum mode )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.579 -0500", hash_original_method = "58E66F9B437E228FC7F553B01D901911", hash_generated_method = "AEAF4DE7CE2D4837C7AD0611B7378256")
    public native void glFrontFace(
        int mode
    );

    // C function void glFrustumf ( GLfloat left, GLfloat right, GLfloat bottom, GLfloat top, GLfloat zNear, GLfloat zFar )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.580 -0500", hash_original_method = "258ACC44157D8C73AE0DD0608758234D", hash_generated_method = "6290FEF4B83573274E5EBAA62E056B43")
    public native void glFrustumf(
        float left,
        float right,
        float bottom,
        float top,
        float zNear,
        float zFar
    );

    // C function void glFrustumx ( GLfixed left, GLfixed right, GLfixed bottom, GLfixed top, GLfixed zNear, GLfixed zFar )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.582 -0500", hash_original_method = "B647E46DB6CC0EF9C5D63CE945C7426B", hash_generated_method = "7E0C69C358071B4AACB3E8CDA3521A3C")
    public native void glFrustumx(
        int left,
        int right,
        int bottom,
        int top,
        int zNear,
        int zFar
    );

    // C function void glGenTextures ( GLsizei n, GLuint *textures )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.583 -0500", hash_original_method = "F376BD874C5726C877C78955E3906803", hash_generated_method = "90FE1082ACDF4C81B626C7E7CB7AF7DB")
    public native void glGenTextures(
        int n,
        int[] textures,
        int offset
    );

    // C function void glGenTextures ( GLsizei n, GLuint *textures )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.584 -0500", hash_original_method = "5433EB0BD32825204D952206851671B4", hash_generated_method = "F9E95B58CC6666C5EB7BF5FCB846D4F0")
    public native void glGenTextures(
        int n,
        java.nio.IntBuffer textures
    );

    // C function GLenum glGetError ( void )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.586 -0500", hash_original_method = "3AEB3B830A2084F227EAFBC906BD9186", hash_generated_method = "DD793727C886A722DC5BC460149DF529")
    public native int glGetError(
    );

    // C function void glGetIntegerv ( GLenum pname, GLint *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.587 -0500", hash_original_method = "BE83917E35D95BF70433F1B2EFD4AA45", hash_generated_method = "F76BB9ECDF440CFC44D61DA468870F4A")
    public native void glGetIntegerv(
        int pname,
        int[] params,
        int offset
    );

    // C function void glGetIntegerv ( GLenum pname, GLint *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.589 -0500", hash_original_method = "773ECB86C0D6C008ED75815E0C485FED", hash_generated_method = "C9E07D5B699DDB20C3AE0B409F4F4B2A")
    public native void glGetIntegerv(
        int pname,
        java.nio.IntBuffer params
    );

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.464 -0400", hash_original_method = "C8F5D66A4A0C233120B2D99EA024C798", hash_generated_method = "C8637FC1886E81608EB74A6761675B8E")
    public String _glGetString(
        int name
    ) {
    	addTaint(name);
    	String s = new String();
    	s.addTaint(taint);
    	return s;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.591 -0500", hash_original_method = "A9D2CB8422A028FB150957649B6BF2BA", hash_generated_method = "3BE9FD0A183CF7450E703F7B97DF6F9F")
    public String glGetString(
        int name
    ) {
        String returnValue;
        returnValue = _glGetString(
            name
        );
        return returnValue;
    }

    // C function void glHint ( GLenum target, GLenum mode )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.592 -0500", hash_original_method = "E301695B30A10DCD62C26798611AB78D", hash_generated_method = "B0BFBC359CDAE60C4F892B5412580E52")
    public native void glHint(
        int target,
        int mode
    );

    // C function void glLightModelf ( GLenum pname, GLfloat param )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.594 -0500", hash_original_method = "5B55D240600D2347D0B596E98C1FD03E", hash_generated_method = "998FD76EB23BBBDAA0275B04386BDF65")
    public native void glLightModelf(
        int pname,
        float param
    );

    // C function void glLightModelfv ( GLenum pname, const GLfloat *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.595 -0500", hash_original_method = "469DC3934BDE6F64F646577239C71F2F", hash_generated_method = "E8FF54AA5EE53BEA750F49F5C369B217")
    public native void glLightModelfv(
        int pname,
        float[] params,
        int offset
    );

    // C function void glLightModelfv ( GLenum pname, const GLfloat *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.596 -0500", hash_original_method = "F43364E33E247B9D84BA159B372B4002", hash_generated_method = "2FE2D7248B594F9C1A38967EEA71B381")
    public native void glLightModelfv(
        int pname,
        java.nio.FloatBuffer params
    );

    // C function void glLightModelx ( GLenum pname, GLfixed param )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.598 -0500", hash_original_method = "9B3A746FED707CC1F39424E3DA8ABB06", hash_generated_method = "1C68A1588A0EE06E26C3813D726BE126")
    public native void glLightModelx(
        int pname,
        int param
    );

    // C function void glLightModelxv ( GLenum pname, const GLfixed *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.599 -0500", hash_original_method = "63BEC7A58A6C485233CE34909855CC91", hash_generated_method = "242C02C4EE70EABEBDC5329A20448DCD")
    public native void glLightModelxv(
        int pname,
        int[] params,
        int offset
    );

    // C function void glLightModelxv ( GLenum pname, const GLfixed *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.600 -0500", hash_original_method = "4983CEF3084132F982716E77E65DA0DC", hash_generated_method = "0E003E79E83DFDF08A91600C2421B376")
    public native void glLightModelxv(
        int pname,
        java.nio.IntBuffer params
    );

    // C function void glLightf ( GLenum light, GLenum pname, GLfloat param )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.602 -0500", hash_original_method = "BC4F16E0EA5A26CEBC4A97ACCF933FD8", hash_generated_method = "C1C2305B8537AA8830FD240A3D9D3D11")
    public native void glLightf(
        int light,
        int pname,
        float param
    );

    // C function void glLightfv ( GLenum light, GLenum pname, const GLfloat *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.603 -0500", hash_original_method = "EB971A23213F76661BF6D474DB7C2C2B", hash_generated_method = "2889BC6E6F590135251A8A3BCEE64AED")
    public native void glLightfv(
        int light,
        int pname,
        float[] params,
        int offset
    );

    // C function void glLightfv ( GLenum light, GLenum pname, const GLfloat *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.604 -0500", hash_original_method = "BBD1B83CF877B43B7D98E2E20B1FA8F5", hash_generated_method = "FF901289A1292E27F88E592262E05E01")
    public native void glLightfv(
        int light,
        int pname,
        java.nio.FloatBuffer params
    );

    // C function void glLightx ( GLenum light, GLenum pname, GLfixed param )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.606 -0500", hash_original_method = "1636FACE953A8B90B672FD6B8B82E049", hash_generated_method = "9978E3CE176C95A0C96F3303FEDEB716")
    public native void glLightx(
        int light,
        int pname,
        int param
    );

    // C function void glLightxv ( GLenum light, GLenum pname, const GLfixed *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.608 -0500", hash_original_method = "5EEC4CF6BA8F18D7C0133A72068C6997", hash_generated_method = "EB2A010336D616E99632FC402D2412C5")
    public native void glLightxv(
        int light,
        int pname,
        int[] params,
        int offset
    );

    // C function void glLightxv ( GLenum light, GLenum pname, const GLfixed *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.609 -0500", hash_original_method = "A87D0BD27836CABD7E83A0BE50712B19", hash_generated_method = "27D4ED54B672E4D7DDF8EC9B274C9253")
    public native void glLightxv(
        int light,
        int pname,
        java.nio.IntBuffer params
    );

    // C function void glLineWidth ( GLfloat width )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.610 -0500", hash_original_method = "418A5E015C9F0EF8168906698F676B52", hash_generated_method = "1FF020BF762BD692B345FDAF2C148C39")
    public native void glLineWidth(
        float width
    );

    // C function void glLineWidthx ( GLfixed width )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.612 -0500", hash_original_method = "46A2A26397F6D04C8D01B2E1097F9B31", hash_generated_method = "DAE8DCBD8E052EE4C9A99BE457FCCD0C")
    public native void glLineWidthx(
        int width
    );

    // C function void glLoadIdentity ( void )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.613 -0500", hash_original_method = "D042F9F6A97E88B9C214C3163B975280", hash_generated_method = "6FD172E341982713333485DFCE9F383C")
    public native void glLoadIdentity(
    );

    // C function void glLoadMatrixf ( const GLfloat *m )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.614 -0500", hash_original_method = "BF5B7D451473F76AF4260EBB3D9B9ECD", hash_generated_method = "A70325651AECD175919D39BB26420915")
    public native void glLoadMatrixf(
        float[] m,
        int offset
    );

    // C function void glLoadMatrixf ( const GLfloat *m )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.616 -0500", hash_original_method = "837F28F7EEECF84ECA621818DC3C637A", hash_generated_method = "B51E27632D82AE01FA56A4CDA75C7858")
    public native void glLoadMatrixf(
        java.nio.FloatBuffer m
    );

    // C function void glLoadMatrixx ( const GLfixed *m )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.617 -0500", hash_original_method = "8EEBBA5929A3A830E73BB9FC9F171FB5", hash_generated_method = "D2AD2B07F0FFEA0F934E6A6967A38DCB")
    public native void glLoadMatrixx(
        int[] m,
        int offset
    );

    // C function void glLoadMatrixx ( const GLfixed *m )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.618 -0500", hash_original_method = "3F7B33E669417D7583090F577D211E45", hash_generated_method = "09992BA3780D6B662D48DCE01C937CF1")
    public native void glLoadMatrixx(
        java.nio.IntBuffer m
    );

    // C function void glLogicOp ( GLenum opcode )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.620 -0500", hash_original_method = "EFB3D7E34F512A452A0388AA3929F12A", hash_generated_method = "0618C06D3E051C37DED8F39653D86DF8")
    public native void glLogicOp(
        int opcode
    );

    // C function void glMaterialf ( GLenum face, GLenum pname, GLfloat param )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.621 -0500", hash_original_method = "2486F3344BB028D6ECF51AD6932BC71D", hash_generated_method = "2356C91DAFA71F322028F7055760D03B")
    public native void glMaterialf(
        int face,
        int pname,
        float param
    );

    // C function void glMaterialfv ( GLenum face, GLenum pname, const GLfloat *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.622 -0500", hash_original_method = "FBDA35E6E17FD54BBA85AC8AD5CB2D2D", hash_generated_method = "E1E0074F1867D769BFA3805F01A130B1")
    public native void glMaterialfv(
        int face,
        int pname,
        float[] params,
        int offset
    );

    // C function void glMaterialfv ( GLenum face, GLenum pname, const GLfloat *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.623 -0500", hash_original_method = "0C556B2BE454B86C9858160252C402E3", hash_generated_method = "852F17F41C53E4326462B5598A370427")
    public native void glMaterialfv(
        int face,
        int pname,
        java.nio.FloatBuffer params
    );

    // C function void glMaterialx ( GLenum face, GLenum pname, GLfixed param )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.625 -0500", hash_original_method = "061C8AE3D5B422D4FA509AC9BB661EA2", hash_generated_method = "E976E526230214EF62761B1314398DE9")
    public native void glMaterialx(
        int face,
        int pname,
        int param
    );

    // C function void glMaterialxv ( GLenum face, GLenum pname, const GLfixed *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.626 -0500", hash_original_method = "472B643031F0D036A87E30E2765D5474", hash_generated_method = "0FFB9956268DE0A16576ADC7675CAE1C")
    public native void glMaterialxv(
        int face,
        int pname,
        int[] params,
        int offset
    );

    // C function void glMaterialxv ( GLenum face, GLenum pname, const GLfixed *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.627 -0500", hash_original_method = "C8896486401C23A34B9A8815791ACA5F", hash_generated_method = "98D68D9D9CD53A2AF29F0DBEF9E8795E")
    public native void glMaterialxv(
        int face,
        int pname,
        java.nio.IntBuffer params
    );

    // C function void glMatrixMode ( GLenum mode )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.629 -0500", hash_original_method = "071A0DE8AF455560D084B2FEE6249056", hash_generated_method = "B8C961B5A1DCFA9635274245018A477C")
    public native void glMatrixMode(
        int mode
    );

    // C function void glMultMatrixf ( const GLfloat *m )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.631 -0500", hash_original_method = "F3AFD06B34A43E8403C806B69E46B6B8", hash_generated_method = "00880E0D4AC0BAB93B57E5629396A4FB")
    public native void glMultMatrixf(
        float[] m,
        int offset
    );

    // C function void glMultMatrixf ( const GLfloat *m )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.632 -0500", hash_original_method = "9713DC69CB7C2DDBF435393A004F3DD4", hash_generated_method = "C40EBD29A1F4FD873389B79CAC6E7A00")
    public native void glMultMatrixf(
        java.nio.FloatBuffer m
    );

    // C function void glMultMatrixx ( const GLfixed *m )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.633 -0500", hash_original_method = "4465F8842A1FA52D69E1334040E6F51E", hash_generated_method = "6B3BE5EAAF20DB9AA3258BE77D71F06A")
    public native void glMultMatrixx(
        int[] m,
        int offset
    );

    // C function void glMultMatrixx ( const GLfixed *m )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.635 -0500", hash_original_method = "DF5EC04F6F5FD65FC1A3F65FA14E17AE", hash_generated_method = "9FDAFEE34D6B1E280292C3E4CB56C15F")
    public native void glMultMatrixx(
        java.nio.IntBuffer m
    );

    // C function void glMultiTexCoord4f ( GLenum target, GLfloat s, GLfloat t, GLfloat r, GLfloat q )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.636 -0500", hash_original_method = "11C7AE2F7FBF34FAA4EB3D3D62BF913A", hash_generated_method = "8056584DC30BCB8BECCBBE3EAA1F4D14")
    public native void glMultiTexCoord4f(
        int target,
        float s,
        float t,
        float r,
        float q
    );

    // C function void glMultiTexCoord4x ( GLenum target, GLfixed s, GLfixed t, GLfixed r, GLfixed q )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.637 -0500", hash_original_method = "23E284E29F32FC21C7A0FCFA0D22DEB6", hash_generated_method = "24E73D61D15D7C001A675E06CF6D41E6")
    public native void glMultiTexCoord4x(
        int target,
        int s,
        int t,
        int r,
        int q
    );

    // C function void glNormal3f ( GLfloat nx, GLfloat ny, GLfloat nz )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.639 -0500", hash_original_method = "9DE586E6F695FF88688A307035F39CA5", hash_generated_method = "6A16A7B10082CF75F20EE810FA1F6649")
    public native void glNormal3f(
        float nx,
        float ny,
        float nz
    );

    // C function void glNormal3x ( GLfixed nx, GLfixed ny, GLfixed nz )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.640 -0500", hash_original_method = "20119369DE227042EDEFDBE3270C3DE9", hash_generated_method = "F87183CB92D1EADD091A2D24E979DBFA")
    public native void glNormal3x(
        int nx,
        int ny,
        int nz
    );

    // C function void glNormalPointer ( GLenum type, GLsizei stride, const GLvoid *pointer )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.641 -0500", hash_original_method = "1F3C9CA6DB76EF1CEC4FE9381E242024", hash_generated_method = "11511F01B01522DC10E58561A22B6EF2")
    private native void glNormalPointerBounds(
        int type,
        int stride,
        java.nio.Buffer pointer,
        int remaining
    );

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.642 -0500", hash_original_method = "B0279F28E501DAEA74F3B8688C94AB46", hash_generated_method = "19EABBC95EEF8C07A7F0D28523485046")
    public void glNormalPointer(
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

    // C function void glOrthof ( GLfloat left, GLfloat right, GLfloat bottom, GLfloat top, GLfloat zNear, GLfloat zFar )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.644 -0500", hash_original_method = "FA472E5A7F4340721FB63D20C6C9872C", hash_generated_method = "D72B42E58AA0FA94C4967821BD68AB1D")
    public native void glOrthof(
        float left,
        float right,
        float bottom,
        float top,
        float zNear,
        float zFar
    );

    // C function void glOrthox ( GLfixed left, GLfixed right, GLfixed bottom, GLfixed top, GLfixed zNear, GLfixed zFar )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.645 -0500", hash_original_method = "779BA3AE3934F2C0E0D6CD9B22925617", hash_generated_method = "4274F8550201A11AC81C3498DD87A08C")
    public native void glOrthox(
        int left,
        int right,
        int bottom,
        int top,
        int zNear,
        int zFar
    );

    // C function void glPixelStorei ( GLenum pname, GLint param )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.646 -0500", hash_original_method = "9F46DCF7880A291F21EA87295ECFB64D", hash_generated_method = "5A300AA59F8253B41974F3B402B8AD7B")
    public native void glPixelStorei(
        int pname,
        int param
    );

    // C function void glPointSize ( GLfloat size )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.648 -0500", hash_original_method = "70E088306D05927B07E2ED10F48C457E", hash_generated_method = "792138F828092EDFA9F58F9AC931E5B5")
    public native void glPointSize(
        float size
    );

    // C function void glPointSizex ( GLfixed size )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.649 -0500", hash_original_method = "8990BB5170BD865165F8304AE65CA7D9", hash_generated_method = "800B311D33080704B324D541ED8B68A7")
    public native void glPointSizex(
        int size
    );

    // C function void glPolygonOffset ( GLfloat factor, GLfloat units )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.650 -0500", hash_original_method = "E1FC86F4B601EF0C69805BFC127ED812", hash_generated_method = "C4BE05A57708D922D602A272798C6333")
    public native void glPolygonOffset(
        float factor,
        float units
    );

    // C function void glPolygonOffsetx ( GLfixed factor, GLfixed units )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.652 -0500", hash_original_method = "627C0C70B067DF76C0A65620B55C9D89", hash_generated_method = "FD5C57AD169B755876AEA8E1544E4C89")
    public native void glPolygonOffsetx(
        int factor,
        int units
    );

    // C function void glPopMatrix ( void )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.653 -0500", hash_original_method = "7B9DD6E697258B776092627B483BEC50", hash_generated_method = "5DF85316C471AA8A268E12BEFACFA67A")
    public native void glPopMatrix(
    );

    // C function void glPushMatrix ( void )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.654 -0500", hash_original_method = "5E9492F1A35F4DB85CB36C12255394B9", hash_generated_method = "2E8BDA7973E6FD7EA6FFB691486E1EF6")
    public native void glPushMatrix(
    );

    // C function void glReadPixels ( GLint x, GLint y, GLsizei width, GLsizei height, GLenum format, GLenum type, GLvoid *pixels )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.656 -0500", hash_original_method = "06F089EB522BB6494D3BBAD3A839D917", hash_generated_method = "F2399E84EB4FD8B3E2FD992166851754")
    public native void glReadPixels(
        int x,
        int y,
        int width,
        int height,
        int format,
        int type,
        java.nio.Buffer pixels
    );

    // C function void glRotatef ( GLfloat angle, GLfloat x, GLfloat y, GLfloat z )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.658 -0500", hash_original_method = "1C954364937B2BCE355EFA4F5D15232D", hash_generated_method = "C67ADE2187752927725BB72FC4C1CBFD")
    public native void glRotatef(
        float angle,
        float x,
        float y,
        float z
    );

    // C function void glRotatex ( GLfixed angle, GLfixed x, GLfixed y, GLfixed z )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.659 -0500", hash_original_method = "B1A5B8433BC4E0D5D8E9AD5FE1254788", hash_generated_method = "E92B71E37B8E7D4E2453A508848EB8DD")
    public native void glRotatex(
        int angle,
        int x,
        int y,
        int z
    );

    // C function void glSampleCoverage ( GLclampf value, GLboolean invert )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.661 -0500", hash_original_method = "AA4B2DFEFBE4905278A3F5AA24D3A995", hash_generated_method = "DDD7499ABCE8843956F4CD027F47DF48")
    public native void glSampleCoverage(
        float value,
        boolean invert
    );

    // C function void glSampleCoveragex ( GLclampx value, GLboolean invert )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.662 -0500", hash_original_method = "44B6D2540DFD3AA85A51F37AE0763C78", hash_generated_method = "6F412F5048872574FCE9CFCF8FA27EB7")
    public native void glSampleCoveragex(
        int value,
        boolean invert
    );

    // C function void glScalef ( GLfloat x, GLfloat y, GLfloat z )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.663 -0500", hash_original_method = "EF219AA0948830AA415C1204BCBC2736", hash_generated_method = "1EFE085298327B7D235847392B70FD40")
    public native void glScalef(
        float x,
        float y,
        float z
    );

    // C function void glScalex ( GLfixed x, GLfixed y, GLfixed z )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.665 -0500", hash_original_method = "84D2C12CD2738F500F416AFA5567D4F0", hash_generated_method = "E02E7AAEF99B1D46AB012600E3FB68D0")
    public native void glScalex(
        int x,
        int y,
        int z
    );

    // C function void glScissor ( GLint x, GLint y, GLsizei width, GLsizei height )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.666 -0500", hash_original_method = "2706B1054613592AF5D1DF72ABC0CD83", hash_generated_method = "F3E39EA608C973A31E28118FB67091CE")
    public native void glScissor(
        int x,
        int y,
        int width,
        int height
    );

    // C function void glShadeModel ( GLenum mode )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.667 -0500", hash_original_method = "06D4AD727137B397BA1C790AE88392D9", hash_generated_method = "CD89EA5551BC0AB5B2948CA5E10A8A84")
    public native void glShadeModel(
        int mode
    );

    // C function void glStencilFunc ( GLenum func, GLint ref, GLuint mask )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.668 -0500", hash_original_method = "E1207A48D38BC4812B68A4C96B0D52F1", hash_generated_method = "4D3E141B3D866F1CF05AD1F6791EB09D")
    public native void glStencilFunc(
        int func,
        int ref,
        int mask
    );

    // C function void glStencilMask ( GLuint mask )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.670 -0500", hash_original_method = "7094BBA3123BF4E1DB187F35149B8AFA", hash_generated_method = "1944F549D08418430DEFE197D24DFF38")
    public native void glStencilMask(
        int mask
    );

    // C function void glStencilOp ( GLenum fail, GLenum zfail, GLenum zpass )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.671 -0500", hash_original_method = "B10D55F18627610DD2579793D42F3254", hash_generated_method = "D7D9B459E8BDF5395ABAE37E09BDC9C1")
    public native void glStencilOp(
        int fail,
        int zfail,
        int zpass
    );

    // C function void glTexCoordPointer ( GLint size, GLenum type, GLsizei stride, const GLvoid *pointer )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.672 -0500", hash_original_method = "9D620040AA720FDD33F346FBC8BD5A6E", hash_generated_method = "A08F9635BBFEAFC6D0A24232BB76EDF3")
    private native void glTexCoordPointerBounds(
        int size,
        int type,
        int stride,
        java.nio.Buffer pointer,
        int remaining
    );

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.673 -0500", hash_original_method = "76ED75F6FDC0A5E37C32F775B196CB2D", hash_generated_method = "26C6BFF8153E5DCD917E5120E9C37958")
    public void glTexCoordPointer(
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

    // C function void glTexEnvf ( GLenum target, GLenum pname, GLfloat param )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.674 -0500", hash_original_method = "C92F17394C34CCF009999C2B03267478", hash_generated_method = "3E3B63679E989C62907C01DEDDF7FD9F")
    public native void glTexEnvf(
        int target,
        int pname,
        float param
    );

    // C function void glTexEnvfv ( GLenum target, GLenum pname, const GLfloat *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.676 -0500", hash_original_method = "17EB1D9A37B75139BEBB3A24236CA174", hash_generated_method = "40FDD770A1C2C8056F9D00051AFF8868")
    public native void glTexEnvfv(
        int target,
        int pname,
        float[] params,
        int offset
    );

    // C function void glTexEnvfv ( GLenum target, GLenum pname, const GLfloat *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.678 -0500", hash_original_method = "7DAA860F4B0103CB3FBE5370186D423C", hash_generated_method = "6F9A1A6B33C95615CF7F52DDFC0C7B58")
    public native void glTexEnvfv(
        int target,
        int pname,
        java.nio.FloatBuffer params
    );

    // C function void glTexEnvx ( GLenum target, GLenum pname, GLfixed param )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.679 -0500", hash_original_method = "0B4A8E67F48DF299AEE127C1D6D6E842", hash_generated_method = "6AC40C415FBA2B74B39D343716AF35A3")
    public native void glTexEnvx(
        int target,
        int pname,
        int param
    );

    // C function void glTexEnvxv ( GLenum target, GLenum pname, const GLfixed *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.680 -0500", hash_original_method = "3454AE1EA38B6015D5079DEC25C07356", hash_generated_method = "31AD39075845100B39EAFAB65F943DDC")
    public native void glTexEnvxv(
        int target,
        int pname,
        int[] params,
        int offset
    );

    // C function void glTexEnvxv ( GLenum target, GLenum pname, const GLfixed *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.682 -0500", hash_original_method = "A182AF661C6E3504BF48BA26E70CC975", hash_generated_method = "75AFBB6F813B4BD012026D3ACB65178B")
    public native void glTexEnvxv(
        int target,
        int pname,
        java.nio.IntBuffer params
    );

    // C function void glTexImage2D ( GLenum target, GLint level, GLint internalformat, GLsizei width, GLsizei height, GLint border, GLenum format, GLenum type, const GLvoid *pixels )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.683 -0500", hash_original_method = "1318832C2059A909174341F9487D764F", hash_generated_method = "F73C0205E0453A4E7173E35AFBD09D99")
    public native void glTexImage2D(
        int target,
        int level,
        int internalformat,
        int width,
        int height,
        int border,
        int format,
        int type,
        java.nio.Buffer pixels
    );

    // C function void glTexParameterf ( GLenum target, GLenum pname, GLfloat param )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.684 -0500", hash_original_method = "F2C35EB1905189AC842F73F625C9049E", hash_generated_method = "266ED5630C9ED820F5E89680B900131D")
    public native void glTexParameterf(
        int target,
        int pname,
        float param
    );

    // C function void glTexParameterx ( GLenum target, GLenum pname, GLfixed param )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.686 -0500", hash_original_method = "679BAE0DF1765F687A0745B0BA3EC234", hash_generated_method = "242773463266767E0F42C7A7591BD3CF")
    public native void glTexParameterx(
        int target,
        int pname,
        int param
    );

    // C function void glTexSubImage2D ( GLenum target, GLint level, GLint xoffset, GLint yoffset, GLsizei width, GLsizei height, GLenum format, GLenum type, const GLvoid *pixels )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.687 -0500", hash_original_method = "6621BB389C4964067C97C1E29DF058F0", hash_generated_method = "6C21BAA5667AFE719F6AB63DA33C708D")
    public native void glTexSubImage2D(
        int target,
        int level,
        int xoffset,
        int yoffset,
        int width,
        int height,
        int format,
        int type,
        java.nio.Buffer pixels
    );

    // C function void glTranslatef ( GLfloat x, GLfloat y, GLfloat z )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.689 -0500", hash_original_method = "8D88726507AA19B9B9ECE00EF0AA6770", hash_generated_method = "1B9079C9148C75565007DB0C6735BF8B")
    public native void glTranslatef(
        float x,
        float y,
        float z
    );

    // C function void glTranslatex ( GLfixed x, GLfixed y, GLfixed z )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.690 -0500", hash_original_method = "156D8083E2F48E9E423D17537DC8B72A", hash_generated_method = "A5954711FC5C76BC4E894E932B3CA897")
    public native void glTranslatex(
        int x,
        int y,
        int z
    );

    // C function void glVertexPointer ( GLint size, GLenum type, GLsizei stride, const GLvoid *pointer )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.691 -0500", hash_original_method = "93D9D08DB02A2FA19D56A49842CFD50E", hash_generated_method = "2471551A5C22A8F9068959FEF4D5D767")
    private native void glVertexPointerBounds(
        int size,
        int type,
        int stride,
        java.nio.Buffer pointer,
        int remaining
    );

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.692 -0500", hash_original_method = "EB50FBD03587D2E27B120FC4C1DFD2C5", hash_generated_method = "CDF0571CE5F50C239BEA09013418FAFA")
    public void glVertexPointer(
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

    // C function void glViewport ( GLint x, GLint y, GLsizei width, GLsizei height )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.693 -0500", hash_original_method = "4BB437B5524083B48EDAA779B8096AF4", hash_generated_method = "4CC08BFF4E78B8CFE8801E67317CD07E")
    public native void glViewport(
        int x,
        int y,
        int width,
        int height
    );

    // C function GLbitfield glQueryMatrixxOES ( GLfixed *mantissa, GLint *exponent )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.695 -0500", hash_original_method = "9B92240362A0C24B54C7BFD4F1CE5714", hash_generated_method = "58AE92BB11DD724F78776160263270A7")
    public native int glQueryMatrixxOES(
        int[] mantissa,
        int mantissaOffset,
        int[] exponent,
        int exponentOffset
    );

    // C function GLbitfield glQueryMatrixxOES ( GLfixed *mantissa, GLint *exponent )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.696 -0500", hash_original_method = "101C06E84233F4A43BD578F661A40864", hash_generated_method = "B66AA64622887D181247BB5C164241C1")
    public native int glQueryMatrixxOES(
        java.nio.IntBuffer mantissa,
        java.nio.IntBuffer exponent
    );

    // C function void glBindBuffer ( GLenum target, GLuint buffer )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.698 -0500", hash_original_method = "8D2FB6E82772953815CBFED3E425025F", hash_generated_method = "31B1BB640D23890685FA42191A2D1429")
    public native void glBindBuffer(
        int target,
        int buffer
    );

    // C function void glBufferData ( GLenum target, GLsizeiptr size, const GLvoid *data, GLenum usage )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.699 -0500", hash_original_method = "60652602159136F858DBF56A81FAD463", hash_generated_method = "957D75D40A195EC11438C53BB453837F")
    public native void glBufferData(
        int target,
        int size,
        java.nio.Buffer data,
        int usage
    );

    // C function void glBufferSubData ( GLenum target, GLintptr offset, GLsizeiptr size, const GLvoid *data )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.700 -0500", hash_original_method = "8950BE5BF752428FF824E4C8DAF2F401", hash_generated_method = "118829D44C033D9DA9F9A2B950EBC6ED")
    public native void glBufferSubData(
        int target,
        int offset,
        int size,
        java.nio.Buffer data
    );

    // C function void glClipPlanef ( GLenum plane, const GLfloat *equation )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.701 -0500", hash_original_method = "155F1B281020C8D1BB6048C36DD6FADD", hash_generated_method = "D92BB11FBF1A874BBFAF7B8D9A34B9FC")
    public native void glClipPlanef(
        int plane,
        float[] equation,
        int offset
    );

    // C function void glClipPlanef ( GLenum plane, const GLfloat *equation )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.703 -0500", hash_original_method = "BFAF1ADDEE7B010F7D84F768A9758F4D", hash_generated_method = "6203E14D40A86A1EA6302762B623FB4A")
    public native void glClipPlanef(
        int plane,
        java.nio.FloatBuffer equation
    );

    // C function void glClipPlanex ( GLenum plane, const GLfixed *equation )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.704 -0500", hash_original_method = "0657B828FBDFCB33E6AEAE065879195B", hash_generated_method = "CD72A02566F14C30B60C775EF9DA886D")
    public native void glClipPlanex(
        int plane,
        int[] equation,
        int offset
    );

    // C function void glClipPlanex ( GLenum plane, const GLfixed *equation )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.706 -0500", hash_original_method = "0DA6B6D2978A64F63583FC89A46DD2C9", hash_generated_method = "D3121A4BEE0DDF7228AD3D830A6DAB8C")
    public native void glClipPlanex(
        int plane,
        java.nio.IntBuffer equation
    );

    // C function void glColor4ub ( GLubyte red, GLubyte green, GLubyte blue, GLubyte alpha )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.707 -0500", hash_original_method = "27D12F7262E17AFA65E5B69E9E658934", hash_generated_method = "FA41D4743F1E4936F1ECE47504D7C5C9")
    public native void glColor4ub(
        byte red,
        byte green,
        byte blue,
        byte alpha
    );

    // C function void glColorPointer ( GLint size, GLenum type, GLsizei stride, GLint offset )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.709 -0500", hash_original_method = "BFA7C744F4E209AD9E46A7063445C612", hash_generated_method = "FA145892E5BEDDA20B5B5CDCB3032FCE")
    public native void glColorPointer(
        int size,
        int type,
        int stride,
        int offset
    );

    // C function void glDeleteBuffers ( GLsizei n, const GLuint *buffers )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.710 -0500", hash_original_method = "E5E400D8B0DD28099195D126630AE3F3", hash_generated_method = "A43E15E7AF53934924E33EE424E01064")
    public native void glDeleteBuffers(
        int n,
        int[] buffers,
        int offset
    );

    // C function void glDeleteBuffers ( GLsizei n, const GLuint *buffers )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.711 -0500", hash_original_method = "70C001894D0487E1FC16B5A8E3289001", hash_generated_method = "0CE03670317027DA011CD738769E5300")
    public native void glDeleteBuffers(
        int n,
        java.nio.IntBuffer buffers
    );

    // C function void glDrawElements ( GLenum mode, GLsizei count, GLenum type, GLint offset )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.713 -0500", hash_original_method = "435560D0BA5A8695B9DFA99E435C09EF", hash_generated_method = "1E499A92B8E376C1D88FE24D6E88B989")
    public native void glDrawElements(
        int mode,
        int count,
        int type,
        int offset
    );

    // C function void glGenBuffers ( GLsizei n, GLuint *buffers )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.714 -0500", hash_original_method = "FA01B6EEE9A8B6C56F123033DDBB027C", hash_generated_method = "AA9BF7F1582100C83D14090A58CA03A2")
    public native void glGenBuffers(
        int n,
        int[] buffers,
        int offset
    );

    // C function void glGenBuffers ( GLsizei n, GLuint *buffers )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.715 -0500", hash_original_method = "A06F6445182A854FF9614FEACAA08BDA", hash_generated_method = "40433EF458C765EC776E0F9467D20D4B")
    public native void glGenBuffers(
        int n,
        java.nio.IntBuffer buffers
    );

    // C function void glGetBooleanv ( GLenum pname, GLboolean *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.717 -0500", hash_original_method = "7095CBF55ACD4B9F2AA86E657F4CB2B3", hash_generated_method = "A5DC8F5EE28A6504FE38C281E39C8632")
    public native void glGetBooleanv(
        int pname,
        boolean[] params,
        int offset
    );

    // C function void glGetBooleanv ( GLenum pname, GLboolean *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.718 -0500", hash_original_method = "6AE434FF80C80956E80241A5F3448A43", hash_generated_method = "4AB2BA038585DEF1AE5F89D98D5003C2")
    public native void glGetBooleanv(
        int pname,
        java.nio.IntBuffer params
    );

    // C function void glGetBufferParameteriv ( GLenum target, GLenum pname, GLint *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.719 -0500", hash_original_method = "FE5274567105EB2D10CBB5CF28493B10", hash_generated_method = "FE515732CB921CE5BCA7EF3404846FE2")
    public native void glGetBufferParameteriv(
        int target,
        int pname,
        int[] params,
        int offset
    );

    // C function void glGetBufferParameteriv ( GLenum target, GLenum pname, GLint *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.721 -0500", hash_original_method = "72ED25126A92670FCEBB1B4962677465", hash_generated_method = "C22840F6B606CF4A31746F6A85248864")
    public native void glGetBufferParameteriv(
        int target,
        int pname,
        java.nio.IntBuffer params
    );

    // C function void glGetClipPlanef ( GLenum pname, GLfloat *eqn )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.722 -0500", hash_original_method = "B414E64778E376C130F5038CB527E31F", hash_generated_method = "C1CF44293638B616EA6917BC11E1D2A5")
    public native void glGetClipPlanef(
        int pname,
        float[] eqn,
        int offset
    );

    // C function void glGetClipPlanef ( GLenum pname, GLfloat *eqn )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.723 -0500", hash_original_method = "1C111E4CC3829517C17B35EA499D5BFD", hash_generated_method = "B705A752299A506A0C28C8F3722F1240")
    public native void glGetClipPlanef(
        int pname,
        java.nio.FloatBuffer eqn
    );

    // C function void glGetClipPlanex ( GLenum pname, GLfixed *eqn )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.725 -0500", hash_original_method = "9782A147ABD9AFBBF1DDDCF344CA05F5", hash_generated_method = "37D0A10C39751DD5D468A344F23C6B3B")
    public native void glGetClipPlanex(
        int pname,
        int[] eqn,
        int offset
    );

    // C function void glGetClipPlanex ( GLenum pname, GLfixed *eqn )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.726 -0500", hash_original_method = "4DB3F0354D2E2FDC4D6C7551700566FD", hash_generated_method = "35825992D09D4B75B58E8BBF13CC11FE")
    public native void glGetClipPlanex(
        int pname,
        java.nio.IntBuffer eqn
    );

    // C function void glGetFixedv ( GLenum pname, GLfixed *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.727 -0500", hash_original_method = "72D05611B5260CD5F4BD9FBDD7EF3356", hash_generated_method = "EFB92EA3AB7AAB668BBE9A6E22FD0F53")
    public native void glGetFixedv(
        int pname,
        int[] params,
        int offset
    );

    // C function void glGetFixedv ( GLenum pname, GLfixed *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.729 -0500", hash_original_method = "D5438CEA44EE048204E6C055FB0ADA7A", hash_generated_method = "3DCCB10EC603B358B9A870CE805ADB4F")
    public native void glGetFixedv(
        int pname,
        java.nio.IntBuffer params
    );

    // C function void glGetFloatv ( GLenum pname, GLfloat *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.730 -0500", hash_original_method = "D28AD4CA9FE8670565C188B18F0632DC", hash_generated_method = "1412022097CCA6ED347625B6122FACCC")
    public native void glGetFloatv(
        int pname,
        float[] params,
        int offset
    );

    // C function void glGetFloatv ( GLenum pname, GLfloat *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.732 -0500", hash_original_method = "3B5B54F3207F36DC8458C2C22ECF19A7", hash_generated_method = "3991BA1A775456E37F0CAB1DCCE0997C")
    public native void glGetFloatv(
        int pname,
        java.nio.FloatBuffer params
    );

    // C function void glGetLightfv ( GLenum light, GLenum pname, GLfloat *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.734 -0500", hash_original_method = "6E5CC7433F2D11EE58A323BDB9B2C031", hash_generated_method = "C59978ECC944E2CDEE6388400CE12EEF")
    public native void glGetLightfv(
        int light,
        int pname,
        float[] params,
        int offset
    );

    // C function void glGetLightfv ( GLenum light, GLenum pname, GLfloat *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.735 -0500", hash_original_method = "6D38AF1876F30D3A6786EFE90DF09285", hash_generated_method = "7BEDE3058B0EA1763B1385D85AC5D95A")
    public native void glGetLightfv(
        int light,
        int pname,
        java.nio.FloatBuffer params
    );

    // C function void glGetLightxv ( GLenum light, GLenum pname, GLfixed *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.737 -0500", hash_original_method = "6258F81E6CD446483B153322692371F6", hash_generated_method = "A3F2AAF8B6B018315458B3E5F1196C0F")
    public native void glGetLightxv(
        int light,
        int pname,
        int[] params,
        int offset
    );

    // C function void glGetLightxv ( GLenum light, GLenum pname, GLfixed *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.738 -0500", hash_original_method = "858C4450F94D83CD8A405C5DA4478E6B", hash_generated_method = "1BF6316E4C1060F7715EAC602B45DB52")
    public native void glGetLightxv(
        int light,
        int pname,
        java.nio.IntBuffer params
    );

    // C function void glGetMaterialfv ( GLenum face, GLenum pname, GLfloat *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.739 -0500", hash_original_method = "4AD4AE19FF3DE20072E7B36663EF7FF1", hash_generated_method = "479A338FE375820897777FBC8098E9C9")
    public native void glGetMaterialfv(
        int face,
        int pname,
        float[] params,
        int offset
    );

    // C function void glGetMaterialfv ( GLenum face, GLenum pname, GLfloat *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.741 -0500", hash_original_method = "AAEA106163ADE72C9EC108D40BEC96F3", hash_generated_method = "6245D365492906F66B5D98708897D6B1")
    public native void glGetMaterialfv(
        int face,
        int pname,
        java.nio.FloatBuffer params
    );

    // C function void glGetMaterialxv ( GLenum face, GLenum pname, GLfixed *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.742 -0500", hash_original_method = "DA45382300D64D4633231B25DC790ED5", hash_generated_method = "D70D4295B74A60CD215B9456320F34DA")
    public native void glGetMaterialxv(
        int face,
        int pname,
        int[] params,
        int offset
    );

    // C function void glGetMaterialxv ( GLenum face, GLenum pname, GLfixed *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.743 -0500", hash_original_method = "77D07CA7E363A44E04443485884C5B13", hash_generated_method = "94ACC39CD79FD9888707AA623F263899")
    public native void glGetMaterialxv(
        int face,
        int pname,
        java.nio.IntBuffer params
    );

    // C function void glGetTexEnviv ( GLenum env, GLenum pname, GLint *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.744 -0500", hash_original_method = "BC56AF50A79D05EDBF323A443949E95D", hash_generated_method = "4D6FDA83CD290E739350B3B4D172E992")
    public native void glGetTexEnviv(
        int env,
        int pname,
        int[] params,
        int offset
    );

    // C function void glGetTexEnviv ( GLenum env, GLenum pname, GLint *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.746 -0500", hash_original_method = "E065D6D8A539FB0D184E951B3A77BFAF", hash_generated_method = "6629A53BFA4BB2D456B613180B5B787C")
    public native void glGetTexEnviv(
        int env,
        int pname,
        java.nio.IntBuffer params
    );

    // C function void glGetTexEnvxv ( GLenum env, GLenum pname, GLfixed *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.747 -0500", hash_original_method = "EE2ECB11441E634C6CF011A0FBC9E456", hash_generated_method = "8CA44FCF94D5D0106437C27A685EA0F4")
    public native void glGetTexEnvxv(
        int env,
        int pname,
        int[] params,
        int offset
    );

    // C function void glGetTexEnvxv ( GLenum env, GLenum pname, GLfixed *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.749 -0500", hash_original_method = "4763956A6FE09C8FE7B17EE79BBD7E20", hash_generated_method = "FE97EBCC2DE28A98B0133904B0530872")
    public native void glGetTexEnvxv(
        int env,
        int pname,
        java.nio.IntBuffer params
    );

    // C function void glGetTexParameterfv ( GLenum target, GLenum pname, GLfloat *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.751 -0500", hash_original_method = "A8EA7C4CAD5F8207BAFF4D19B2B8A061", hash_generated_method = "B73F3A0B568B7219BA9977351D87B381")
    public native void glGetTexParameterfv(
        int target,
        int pname,
        float[] params,
        int offset
    );

    // C function void glGetTexParameterfv ( GLenum target, GLenum pname, GLfloat *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.752 -0500", hash_original_method = "4367C68441A9AA98F01515FDC90FDB44", hash_generated_method = "7A7A9E49CB9AA0CF1B828B34A367161C")
    public native void glGetTexParameterfv(
        int target,
        int pname,
        java.nio.FloatBuffer params
    );

    // C function void glGetTexParameteriv ( GLenum target, GLenum pname, GLint *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.753 -0500", hash_original_method = "8602EDD51435EC27A0B8958E793FF372", hash_generated_method = "C2635ADA66CFD3C5D4EFAB825A9FF962")
    public native void glGetTexParameteriv(
        int target,
        int pname,
        int[] params,
        int offset
    );

    // C function void glGetTexParameteriv ( GLenum target, GLenum pname, GLint *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.755 -0500", hash_original_method = "71368889A06C9E1744E4E25318DA6058", hash_generated_method = "14B503906C43DAF9055719AC89E05CED")
    public native void glGetTexParameteriv(
        int target,
        int pname,
        java.nio.IntBuffer params
    );

    // C function void glGetTexParameterxv ( GLenum target, GLenum pname, GLfixed *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.756 -0500", hash_original_method = "1BA765DD7E0FB5AA6AD2EBB11DF8B607", hash_generated_method = "41DF22905394D1744B7FE15C5C5469A0")
    public native void glGetTexParameterxv(
        int target,
        int pname,
        int[] params,
        int offset
    );

    // C function void glGetTexParameterxv ( GLenum target, GLenum pname, GLfixed *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.757 -0500", hash_original_method = "374E464895B48D2BEAC554053928B2AF", hash_generated_method = "53E9DD10B71C2B31ECAF925626FDC011")
    public native void glGetTexParameterxv(
        int target,
        int pname,
        java.nio.IntBuffer params
    );

    // C function GLboolean glIsBuffer ( GLuint buffer )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.759 -0500", hash_original_method = "5CBCE22A13679DB40202021E228060B4", hash_generated_method = "E623043B3115F13D1F67EF02DEA718A4")
    public native boolean glIsBuffer(
        int buffer
    );

    // C function GLboolean glIsEnabled ( GLenum cap )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.760 -0500", hash_original_method = "2B37B396792E11A373DC696386D55E16", hash_generated_method = "C0AAAEF7B66BA208622D5D65A70FBD48")
    public native boolean glIsEnabled(
        int cap
    );

    // C function GLboolean glIsTexture ( GLuint texture )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.761 -0500", hash_original_method = "B0774EFDFDF7E34E3A748242DEA5FF75", hash_generated_method = "CF2615EFCC4B47B35A6D097235D79AE6")
    public native boolean glIsTexture(
        int texture
    );

    // C function void glNormalPointer ( GLenum type, GLsizei stride, GLint offset )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.763 -0500", hash_original_method = "59EE792672F5ACA51D14291B099DC2AE", hash_generated_method = "A352D7F384F0394CADDB1163CDD56C46")
    public native void glNormalPointer(
        int type,
        int stride,
        int offset
    );

    // C function void glPointParameterf ( GLenum pname, GLfloat param )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.764 -0500", hash_original_method = "E63CD7975861B2CCB6AD8F16DA976646", hash_generated_method = "31B3D2BF2CC08D5A9E1EA4A5AE034F6E")
    public native void glPointParameterf(
        int pname,
        float param
    );

    // C function void glPointParameterfv ( GLenum pname, const GLfloat *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.766 -0500", hash_original_method = "A11196C9C3232519E010B3D895E7B10B", hash_generated_method = "B93229A30EC56108296ACC1607594652")
    public native void glPointParameterfv(
        int pname,
        float[] params,
        int offset
    );

    // C function void glPointParameterfv ( GLenum pname, const GLfloat *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.767 -0500", hash_original_method = "6E76F6C08D9C74E626F785B0CF4DDD86", hash_generated_method = "8C91BBD2E346D3DA3DD90F4D8DFF47BA")
    public native void glPointParameterfv(
        int pname,
        java.nio.FloatBuffer params
    );

    // C function void glPointParameterx ( GLenum pname, GLfixed param )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.768 -0500", hash_original_method = "2BB54735F90AB9973C6E35C2068C71E7", hash_generated_method = "199C98310F2B16AD70A2E76C58E65C27")
    public native void glPointParameterx(
        int pname,
        int param
    );

    // C function void glPointParameterxv ( GLenum pname, const GLfixed *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.770 -0500", hash_original_method = "5934D4E26BE75521F9F4579D9C8DCFE4", hash_generated_method = "05404D642F7BD0AF7AFC405222AA5E34")
    public native void glPointParameterxv(
        int pname,
        int[] params,
        int offset
    );

    // C function void glPointParameterxv ( GLenum pname, const GLfixed *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.771 -0500", hash_original_method = "C6C705CE06675FCC62C044DF88D7C5DF", hash_generated_method = "CBA580E32C927287A79E1F83FADE4A9A")
    public native void glPointParameterxv(
        int pname,
        java.nio.IntBuffer params
    );

    // C function void glPointSizePointerOES ( GLenum type, GLsizei stride, const GLvoid *pointer )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.772 -0500", hash_original_method = "8C106C3CEF3BB7BF47C54FD961C1CA10", hash_generated_method = "4C7002A2C1F164554BAD655FCD0D1B33")
    private native void glPointSizePointerOESBounds(
        int type,
        int stride,
        java.nio.Buffer pointer,
        int remaining
    );

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.773 -0500", hash_original_method = "EC0D07F3AF47DBC4190CF008FCA93E16", hash_generated_method = "573822153179A8174E41A0B8AB94E64C")
    public void glPointSizePointerOES(
        int type,
        int stride,
        java.nio.Buffer pointer
    ) {
        glPointSizePointerOESBounds(
            type,
            stride,
            pointer,
            pointer.remaining()
        );
        if (((type == GL_FLOAT) ||
             (type == GL_FIXED)) &&
            (stride >= 0)) {
            _pointSizePointerOES = pointer;
        }
    }

    // C function void glTexCoordPointer ( GLint size, GLenum type, GLsizei stride, GLint offset )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.775 -0500", hash_original_method = "12CDED926CDCF7EA42742009896284D9", hash_generated_method = "64AC45D0150BBFAD85F8151B2EB76997")
    public native void glTexCoordPointer(
        int size,
        int type,
        int stride,
        int offset
    );

    // C function void glTexEnvi ( GLenum target, GLenum pname, GLint param )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.776 -0500", hash_original_method = "D87BE224D969AEA6EA7B6B5DC106EE96", hash_generated_method = "478D76EEF06E16C314742767064F78B9")
    public native void glTexEnvi(
        int target,
        int pname,
        int param
    );

    // C function void glTexEnviv ( GLenum target, GLenum pname, const GLint *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.777 -0500", hash_original_method = "5D2B9210D6DE6236279DA021F5E63F79", hash_generated_method = "BBECDAC3A5847CC4890BE04C36F3CD3D")
    public native void glTexEnviv(
        int target,
        int pname,
        int[] params,
        int offset
    );

    // C function void glTexEnviv ( GLenum target, GLenum pname, const GLint *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.779 -0500", hash_original_method = "5C6F79AEDC5DC4EAF22C5D32A1DF3A50", hash_generated_method = "75073F3880CCE911B645B76017140F32")
    public native void glTexEnviv(
        int target,
        int pname,
        java.nio.IntBuffer params
    );

    // C function void glTexParameterfv ( GLenum target, GLenum pname, const GLfloat *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.780 -0500", hash_original_method = "A0FA0DFE2CA71C45A154ED0DC216DF9E", hash_generated_method = "26E078663A87ECB037BDFB981BC6D395")
    public native void glTexParameterfv(
        int target,
        int pname,
        float[] params,
        int offset
    );

    // C function void glTexParameterfv ( GLenum target, GLenum pname, const GLfloat *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.782 -0500", hash_original_method = "6A0800686C986953231F118EFA89B68E", hash_generated_method = "D0A76304B8B71557E96E180094ED8B7A")
    public native void glTexParameterfv(
        int target,
        int pname,
        java.nio.FloatBuffer params
    );

    // C function void glTexParameteri ( GLenum target, GLenum pname, GLint param )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.783 -0500", hash_original_method = "1ACB3111112291A939213D1C616FDF01", hash_generated_method = "A00888CC17F98BAC3BB05680DCFE3142")
    public native void glTexParameteri(
        int target,
        int pname,
        int param
    );

    // C function void glTexParameteriv ( GLenum target, GLenum pname, const GLint *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.784 -0500", hash_original_method = "B9123A3C5F31C764ACDC251B4B063084", hash_generated_method = "6EBFAA9B523B8A959C334A3D36CB8BDF")
    public native void glTexParameteriv(
        int target,
        int pname,
        int[] params,
        int offset
    );

    // C function void glTexParameteriv ( GLenum target, GLenum pname, const GLint *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.785 -0500", hash_original_method = "14BFADF901BE034B97F27EFDB7249EC5", hash_generated_method = "362AE167B60B8D17F1D233E424CF1727")
    public native void glTexParameteriv(
        int target,
        int pname,
        java.nio.IntBuffer params
    );

    // C function void glTexParameterxv ( GLenum target, GLenum pname, const GLfixed *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.787 -0500", hash_original_method = "3F6F8E0BA39C35229A89553DB35B9114", hash_generated_method = "DA63368EA6ECB36C718F943D7E247A6F")
    public native void glTexParameterxv(
        int target,
        int pname,
        int[] params,
        int offset
    );

    // C function void glTexParameterxv ( GLenum target, GLenum pname, const GLfixed *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.788 -0500", hash_original_method = "04A367584151D9D9FD975F225EE885B4", hash_generated_method = "BE8C03AD9C7B0EB3149391F7F09820F4")
    public native void glTexParameterxv(
        int target,
        int pname,
        java.nio.IntBuffer params
    );

    // C function void glVertexPointer ( GLint size, GLenum type, GLsizei stride, GLint offset )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.789 -0500", hash_original_method = "7C26F1A50D75B77F9272FCB63EA624C6", hash_generated_method = "9CEAF6FD2FF5BA85A3402F390E3209B4")
    public native void glVertexPointer(
        int size,
        int type,
        int stride,
        int offset
    );

    // C function void glCurrentPaletteMatrixOES ( GLuint matrixpaletteindex )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.791 -0500", hash_original_method = "95BA1F07B3AEB4D134CCBDFFE0DB7EE4", hash_generated_method = "DB151D95BCB48DAC6D6F0BD013C8A282")
    public native void glCurrentPaletteMatrixOES(
        int matrixpaletteindex
    );

    // C function void glDrawTexfOES ( GLfloat x, GLfloat y, GLfloat z, GLfloat width, GLfloat height )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.792 -0500", hash_original_method = "D2BE11A64665DB8B06B4DC96FEC208B6", hash_generated_method = "35D06E56461713E5CF23BCF7DE973E1E")
    public native void glDrawTexfOES(
        float x,
        float y,
        float z,
        float width,
        float height
    );

    // C function void glDrawTexfvOES ( const GLfloat *coords )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.793 -0500", hash_original_method = "1910442FB838D19DD4C27DB699DB4D46", hash_generated_method = "315CDF7E83469E9E156A98E8012ED4AB")
    public native void glDrawTexfvOES(
        float[] coords,
        int offset
    );

    // C function void glDrawTexfvOES ( const GLfloat *coords )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.796 -0500", hash_original_method = "831C162EE3D2DC1DF6F1AE6669ECD44A", hash_generated_method = "1B06CC971A9A00374A3E6478D496FA4A")
    public native void glDrawTexfvOES(
        java.nio.FloatBuffer coords
    );

    // C function void glDrawTexiOES ( GLint x, GLint y, GLint z, GLint width, GLint height )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.797 -0500", hash_original_method = "A28C833EC2B9C4EB45296643BE372A85", hash_generated_method = "0B299743567F2E4AA49B685CDAB233FE")
    public native void glDrawTexiOES(
        int x,
        int y,
        int z,
        int width,
        int height
    );

    // C function void glDrawTexivOES ( const GLint *coords )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.798 -0500", hash_original_method = "38C985EB15B5E699CFA5800CE9313B6C", hash_generated_method = "5167A7D49CC26DBD171ABE8BA204A738")
    public native void glDrawTexivOES(
        int[] coords,
        int offset
    );

    // C function void glDrawTexivOES ( const GLint *coords )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.800 -0500", hash_original_method = "2E2E2E76797892659616F6D96EE421EA", hash_generated_method = "8C9C317B46D5534672A63517F607D7AB")
    public native void glDrawTexivOES(
        java.nio.IntBuffer coords
    );

    // C function void glDrawTexsOES ( GLshort x, GLshort y, GLshort z, GLshort width, GLshort height )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.801 -0500", hash_original_method = "8566A29D8D8B09C3A6BC518418932CDB", hash_generated_method = "C3D50E2E4ABEA738A4C6453354ED5633")
    public native void glDrawTexsOES(
        short x,
        short y,
        short z,
        short width,
        short height
    );

    // C function void glDrawTexsvOES ( const GLshort *coords )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.802 -0500", hash_original_method = "91E6CBADB398633A4383C31A0AD86296", hash_generated_method = "4439971046D5E58B667222CA4FDA4D03")
    public native void glDrawTexsvOES(
        short[] coords,
        int offset
    );

    // C function void glDrawTexsvOES ( const GLshort *coords )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.803 -0500", hash_original_method = "0954B7C7035D691303E55E25D6EFB672", hash_generated_method = "27E2A4117FE9AA8E7348DB6BBBEE1460")
    public native void glDrawTexsvOES(
        java.nio.ShortBuffer coords
    );

    // C function void glDrawTexxOES ( GLfixed x, GLfixed y, GLfixed z, GLfixed width, GLfixed height )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.805 -0500", hash_original_method = "74CF88596F8DBCCE4A394CCE81E9FC91", hash_generated_method = "7CCAC5C5C93EC4ACF859904166F8425D")
    public native void glDrawTexxOES(
        int x,
        int y,
        int z,
        int width,
        int height
    );

    // C function void glDrawTexxvOES ( const GLfixed *coords )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.806 -0500", hash_original_method = "2F7A3F5025DF5EF064319814B3209A3C", hash_generated_method = "0CDF2DF76A5C389DFBCB3F6F95017F5C")
    public native void glDrawTexxvOES(
        int[] coords,
        int offset
    );

    // C function void glDrawTexxvOES ( const GLfixed *coords )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.807 -0500", hash_original_method = "51D917B4A8B9530FF8924BF2E6AF392B", hash_generated_method = "D7E655B256849F097DFDF59CA829763F")
    public native void glDrawTexxvOES(
        java.nio.IntBuffer coords
    );

    // C function void glLoadPaletteFromModelViewMatrixOES ( void )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.809 -0500", hash_original_method = "0DEF4FDA31B693FD58B4F5466D1F6B2D", hash_generated_method = "2A346EF012D053D9993CB1ACC0E78FF4")
    public native void glLoadPaletteFromModelViewMatrixOES(
    );

    // C function void glMatrixIndexPointerOES ( GLint size, GLenum type, GLsizei stride, const GLvoid *pointer )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.810 -0500", hash_original_method = "6A7CA123A9CB88F0A99C0D9B4D2D33AF", hash_generated_method = "5AAA432A476B2287EA2125EE664731E7")
    private native void glMatrixIndexPointerOESBounds(
        int size,
        int type,
        int stride,
        java.nio.Buffer pointer,
        int remaining
    );

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.811 -0500", hash_original_method = "A2DEF3847665EA2F7AE241D0B05BBB08", hash_generated_method = "98EE92C9ACB66EF29A184648B207D31C")
    public void glMatrixIndexPointerOES(
        int size,
        int type,
        int stride,
        java.nio.Buffer pointer
    ) {
        glMatrixIndexPointerOESBounds(
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
            _matrixIndexPointerOES = pointer;
        }
    }

    // C function void glMatrixIndexPointerOES ( GLint size, GLenum type, GLsizei stride, GLint offset )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.812 -0500", hash_original_method = "C6EEDA2F0CB848D1825DAA27E05C1F25", hash_generated_method = "8A5BA4E7B94A73082554B8D7139333AD")
    public native void glMatrixIndexPointerOES(
        int size,
        int type,
        int stride,
        int offset
    );

    // C function void glWeightPointerOES ( GLint size, GLenum type, GLsizei stride, const GLvoid *pointer )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.814 -0500", hash_original_method = "733A86C2F1705E763179D2C64FE1F559", hash_generated_method = "E24695617E5C147F5AC582DB338C49E7")
    private native void glWeightPointerOESBounds(
        int size,
        int type,
        int stride,
        java.nio.Buffer pointer,
        int remaining
    );

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.815 -0500", hash_original_method = "DA1591FF7EA6F5F9EAE67C123814B637", hash_generated_method = "CCD8573B351DECAD987D3711506887B5")
    public void glWeightPointerOES(
        int size,
        int type,
        int stride,
        java.nio.Buffer pointer
    ) {
        glWeightPointerOESBounds(
            size,
            type,
            stride,
            pointer,
            pointer.remaining()
        );
    }

    // C function void glWeightPointerOES ( GLint size, GLenum type, GLsizei stride, GLint offset )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.816 -0500", hash_original_method = "80F6563B1D95178FF3AFD1CF5B96CA9E", hash_generated_method = "B44C439B13B09F294FAD0A873A0BD37A")
    public native void glWeightPointerOES(
        int size,
        int type,
        int stride,
        int offset
    );

    // C function void glBindFramebufferOES ( GLint target, GLint framebuffer )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.817 -0500", hash_original_method = "7012E0C28CAA85B7F547C387DC5490BF", hash_generated_method = "A78DC9B5762312C65B39F79D1511A1A4")
    public native void glBindFramebufferOES(
        int target,
        int framebuffer
    );

    // C function void glBindRenderbufferOES ( GLint target, GLint renderbuffer )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.819 -0500", hash_original_method = "E996F619A69BBB02AE5800FE72064177", hash_generated_method = "E4A147CC3B1255023F56897C3BDDDBD6")
    public native void glBindRenderbufferOES(
        int target,
        int renderbuffer
    );

    // C function void glBlendEquation ( GLint mode )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.820 -0500", hash_original_method = "96629AB18523F1B8BD5CC1F0B06C9A3A", hash_generated_method = "00DA7C4CC0C2CCCEC590F04CA5D41206")
    public native void glBlendEquation(
        int mode
    );

    // C function void glBlendEquationSeparate ( GLint modeRGB, GLint modeAlpha )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.821 -0500", hash_original_method = "D2522F56984AE422BAA6705290A5800D", hash_generated_method = "83D2046EAA55C297113328A42E91CA0B")
    public native void glBlendEquationSeparate(
        int modeRGB,
        int modeAlpha
    );

    // C function void glBlendFuncSeparate ( GLint srcRGB, GLint dstRGB, GLint srcAlpha, GLint dstAlpha )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.823 -0500", hash_original_method = "BEC8094313FE35DDC834FD9794924A8C", hash_generated_method = "FE1ACA0C7FB38A0D9DA292FA90CFCFF3")
    public native void glBlendFuncSeparate(
        int srcRGB,
        int dstRGB,
        int srcAlpha,
        int dstAlpha
    );

    // C function GLint glCheckFramebufferStatusOES ( GLint target )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.824 -0500", hash_original_method = "B1A4A768D52CA135614FAA74BF2A89E7", hash_generated_method = "D6481D07FAE147CB83604D702015BD27")
    public native int glCheckFramebufferStatusOES(
        int target
    );

    // C function void glDeleteFramebuffersOES ( GLint n, GLuint *framebuffers )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.826 -0500", hash_original_method = "224046A7647ABE7AB757051B3805C7F0", hash_generated_method = "746C644361CB0BBF50AD889B07EDA214")
    public native void glDeleteFramebuffersOES(
        int n,
        int[] framebuffers,
        int offset
    );

    // C function void glDeleteFramebuffersOES ( GLint n, GLuint *framebuffers )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.827 -0500", hash_original_method = "0DFDB8F7E46ED0CE9E0FCF78465DA298", hash_generated_method = "A9AA34096737E48D22F6168A0953F8C0")
    public native void glDeleteFramebuffersOES(
        int n,
        java.nio.IntBuffer framebuffers
    );

    // C function void glDeleteRenderbuffersOES ( GLint n, GLuint *renderbuffers )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.828 -0500", hash_original_method = "1FFECA3ED850152A6CC369D1F14D97EB", hash_generated_method = "588C12784B309E6EDA5FD7D41B6D73D6")
    public native void glDeleteRenderbuffersOES(
        int n,
        int[] renderbuffers,
        int offset
    );

    // C function void glDeleteRenderbuffersOES ( GLint n, GLuint *renderbuffers )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.830 -0500", hash_original_method = "46CFE024939DBAEA7FE408A9C7C03F41", hash_generated_method = "D0725E2523DB512623E2FB6886C360CE")
    public native void glDeleteRenderbuffersOES(
        int n,
        java.nio.IntBuffer renderbuffers
    );

    // C function void glFramebufferRenderbufferOES ( GLint target, GLint attachment, GLint renderbuffertarget, GLint renderbuffer )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.831 -0500", hash_original_method = "DF7EC8EDF18B86227477D66A9E612D5C", hash_generated_method = "48D9CD68EC89E0EA97C3699291A162DD")
    public native void glFramebufferRenderbufferOES(
        int target,
        int attachment,
        int renderbuffertarget,
        int renderbuffer
    );

    // C function void glFramebufferTexture2DOES ( GLint target, GLint attachment, GLint textarget, GLint texture, GLint level )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.832 -0500", hash_original_method = "E6578E5E33958E12104B156D133D18C1", hash_generated_method = "5ECAB2CC32AB60947BBC81241D0E7F52")
    public native void glFramebufferTexture2DOES(
        int target,
        int attachment,
        int textarget,
        int texture,
        int level
    );

    // C function void glGenerateMipmapOES ( GLint target )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.833 -0500", hash_original_method = "CF3BBC0690535D9ACEDA510E7C25FE93", hash_generated_method = "3AEDC1F8D9073C10B9A51E13977999E5")
    public native void glGenerateMipmapOES(
        int target
    );

    // C function void glGenFramebuffersOES ( GLint n, GLuint *framebuffers )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.835 -0500", hash_original_method = "5CF430CF82275396EA94D85409CBB33E", hash_generated_method = "E93B78E75C4FC074A7823940F85A9349")
    public native void glGenFramebuffersOES(
        int n,
        int[] framebuffers,
        int offset
    );

    // C function void glGenFramebuffersOES ( GLint n, GLuint *framebuffers )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.836 -0500", hash_original_method = "4BB7994AB48E0E49BC5DEE99DDBE64C7", hash_generated_method = "CE668B7C044DDA5C52DC2CF2295D41CD")
    public native void glGenFramebuffersOES(
        int n,
        java.nio.IntBuffer framebuffers
    );

    // C function void glGenRenderbuffersOES ( GLint n, GLuint *renderbuffers )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.837 -0500", hash_original_method = "C06623E355A0F7E782F31327854908F9", hash_generated_method = "9E61800CAABACDE4688C2B81C14423BF")
    public native void glGenRenderbuffersOES(
        int n,
        int[] renderbuffers,
        int offset
    );

    // C function void glGenRenderbuffersOES ( GLint n, GLuint *renderbuffers )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.839 -0500", hash_original_method = "7033C2CDCB61F1BA8BB94D8B8850FD60", hash_generated_method = "AC7FFEE97F82353A42C5C1D00A12BE5E")
    public native void glGenRenderbuffersOES(
        int n,
        java.nio.IntBuffer renderbuffers
    );

    // C function void glGetFramebufferAttachmentParameterivOES ( GLint target, GLint attachment, GLint pname, GLint *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.841 -0500", hash_original_method = "F29F63990C9EBFB77B2A5E7A020E447B", hash_generated_method = "0C4133798E3CADE4A15F2D14B815EF41")
    public native void glGetFramebufferAttachmentParameterivOES(
        int target,
        int attachment,
        int pname,
        int[] params,
        int offset
    );

    // C function void glGetFramebufferAttachmentParameterivOES ( GLint target, GLint attachment, GLint pname, GLint *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.842 -0500", hash_original_method = "80E3B7662123EAE7B5048632F9E3C14B", hash_generated_method = "40597A13972A9B4125F0C71BDEF8C94C")
    public native void glGetFramebufferAttachmentParameterivOES(
        int target,
        int attachment,
        int pname,
        java.nio.IntBuffer params
    );

    // C function void glGetRenderbufferParameterivOES ( GLint target, GLint pname, GLint *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.843 -0500", hash_original_method = "6361A7359BD6B257B9C730DAA1639DC0", hash_generated_method = "CFD90D8BE24D8A8B0E34920395D49704")
    public native void glGetRenderbufferParameterivOES(
        int target,
        int pname,
        int[] params,
        int offset
    );

    // C function void glGetRenderbufferParameterivOES ( GLint target, GLint pname, GLint *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.845 -0500", hash_original_method = "D4443F3E98C9A915B5F88EF6379DF720", hash_generated_method = "BE37D9B816D0D50C81B057692966EAC6")
    public native void glGetRenderbufferParameterivOES(
        int target,
        int pname,
        java.nio.IntBuffer params
    );

    // C function void glGetTexGenfv ( GLint coord, GLint pname, GLfloat *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.846 -0500", hash_original_method = "CCB2C58BFB01275BCB44948E86C23A6F", hash_generated_method = "E59CC13373DE50EF55BD8DFB78B0C8A3")
    public native void glGetTexGenfv(
        int coord,
        int pname,
        float[] params,
        int offset
    );

    // C function void glGetTexGenfv ( GLint coord, GLint pname, GLfloat *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.847 -0500", hash_original_method = "BA57774F60DC2980B7FF38B0A2E8016F", hash_generated_method = "98071483354F54C1FBAEFD71E463E3B1")
    public native void glGetTexGenfv(
        int coord,
        int pname,
        java.nio.FloatBuffer params
    );

    // C function void glGetTexGeniv ( GLint coord, GLint pname, GLint *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.849 -0500", hash_original_method = "D83AC0B94E45154E9C39405960588DD9", hash_generated_method = "5131AD59B53FEE2091AF555063D08987")
    public native void glGetTexGeniv(
        int coord,
        int pname,
        int[] params,
        int offset
    );

    // C function void glGetTexGeniv ( GLint coord, GLint pname, GLint *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.850 -0500", hash_original_method = "EF430454571D4D94946D5978BDE708A5", hash_generated_method = "3E565924B658838906CCB702EEE802E0")
    public native void glGetTexGeniv(
        int coord,
        int pname,
        java.nio.IntBuffer params
    );

    // C function void glGetTexGenxv ( GLint coord, GLint pname, GLint *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.851 -0500", hash_original_method = "1448662FEB07A59CFBC07726254162A7", hash_generated_method = "A736892972D8C5F2967654C0C7F27803")
    public native void glGetTexGenxv(
        int coord,
        int pname,
        int[] params,
        int offset
    );

    // C function void glGetTexGenxv ( GLint coord, GLint pname, GLint *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.853 -0500", hash_original_method = "AA312740D7D8B86852FA57EC0F935C49", hash_generated_method = "1E4F245335D342999EE3157A2DD5CDEC")
    public native void glGetTexGenxv(
        int coord,
        int pname,
        java.nio.IntBuffer params
    );

    // C function GLboolean glIsFramebufferOES ( GLint framebuffer )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.854 -0500", hash_original_method = "0A5D6A2632DB9C567FFD91F0ACA40965", hash_generated_method = "3B4190DAD4FA0F3A408498E1B5034E74")
    public native boolean glIsFramebufferOES(
        int framebuffer
    );

    // C function GLboolean glIsRenderbufferOES ( GLint renderbuffer )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.855 -0500", hash_original_method = "B2AFE473D5090C2AFBF0DD5218613E24", hash_generated_method = "BAE1CE66980EBA598856A52EF42007CB")
    public native boolean glIsRenderbufferOES(
        int renderbuffer
    );

    // C function void glRenderbufferStorageOES ( GLint target, GLint internalformat, GLint width, GLint height )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.857 -0500", hash_original_method = "4BF2A91D21E16F3AE981CF68C4DFDE38", hash_generated_method = "974660AD6A3E8D36A803FEB629A3D73A")
    public native void glRenderbufferStorageOES(
        int target,
        int internalformat,
        int width,
        int height
    );

    // C function void glTexGenf ( GLint coord, GLint pname, GLfloat param )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.858 -0500", hash_original_method = "DF1DDF095262CB65042B8B6E4ACB5D83", hash_generated_method = "EBE13106BC643AD7F752C84BCFC8EB0C")
    public native void glTexGenf(
        int coord,
        int pname,
        float param
    );

    // C function void glTexGenfv ( GLint coord, GLint pname, GLfloat *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.859 -0500", hash_original_method = "021935B8D9D6C7B463624EBDA4B11EB4", hash_generated_method = "3235027D0B5A0C68FFF5DE03C58505DB")
    public native void glTexGenfv(
        int coord,
        int pname,
        float[] params,
        int offset
    );

    // C function void glTexGenfv ( GLint coord, GLint pname, GLfloat *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.861 -0500", hash_original_method = "D8B15F6B92AF3D4541AFD7FC1F3284DA", hash_generated_method = "10B5F3AC69C73D40BC528D8671403C00")
    public native void glTexGenfv(
        int coord,
        int pname,
        java.nio.FloatBuffer params
    );

    // C function void glTexGeni ( GLint coord, GLint pname, GLint param )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.862 -0500", hash_original_method = "53C8322668092422760AEEABF3A0A50D", hash_generated_method = "69FF5F5E1517C97751828CAC43F4C1B2")
    public native void glTexGeni(
        int coord,
        int pname,
        int param
    );

    // C function void glTexGeniv ( GLint coord, GLint pname, GLint *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.863 -0500", hash_original_method = "B98ED31CB4FEB2295803ED2F666679A9", hash_generated_method = "FA94BA48321F86C7E77D2ECE0AB20377")
    public native void glTexGeniv(
        int coord,
        int pname,
        int[] params,
        int offset
    );

    // C function void glTexGeniv ( GLint coord, GLint pname, GLint *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.865 -0500", hash_original_method = "E7AA7F75A0A7E8AB84868E171B6AFAE8", hash_generated_method = "18FC549CAF8EACFC7C49BD599B902003")
    public native void glTexGeniv(
        int coord,
        int pname,
        java.nio.IntBuffer params
    );

    // C function void glTexGenx ( GLint coord, GLint pname, GLint param )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.866 -0500", hash_original_method = "231B06A212F7462B4A9045C185C5C0A0", hash_generated_method = "84E04F840384BFEAF55501E594108E16")
    public native void glTexGenx(
        int coord,
        int pname,
        int param
    );

    // C function void glTexGenxv ( GLint coord, GLint pname, GLint *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.867 -0500", hash_original_method = "1AD9E3A06A99E29BF5DD361F01CD823D", hash_generated_method = "615A76E5D693153FC317F9BC9CA6C5E6")
    public native void glTexGenxv(
        int coord,
        int pname,
        int[] params,
        int offset
    );

    // C function void glTexGenxv ( GLint coord, GLint pname, GLint *params )

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.869 -0500", hash_original_method = "33A72688981BB5774C2892D6B098DC19", hash_generated_method = "A0830F82FA1193AF1347E5FEE837F96D")
    public native void glTexGenxv(
        int coord,
        int pname,
        java.nio.IntBuffer params
    );

    
    static {
	_nativeClassInit();
    }
    
}

