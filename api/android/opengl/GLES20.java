package android.opengl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import droidsafe.helpers.DSUtils;

public class GLES20 {
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void _nativeClassInit() {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glActiveTexture(int texture) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glAttachShader(int program, int shader) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glBindAttribLocation(int program, int index, String name) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glBindBuffer(int target, int buffer) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glBindFramebuffer(int target, int framebuffer) {
	}
    
    public static void glBindRenderbuffer(int target, int renderbuffer) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glBindTexture(int target, int texture) {
	}
    
    public static void glBlendColor(float red, float green, float blue, float alpha) {
	}
    
    public static void glBlendEquation(int mode) {
	}
    
    public static void glBlendEquationSeparate(int modeRGB, int modeAlpha) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glBlendFunc(int sfactor, int dfactor) {
	}
    
    public static void glBlendFuncSeparate(int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glBufferData(int target, int size, java.nio.Buffer data, int usage) {
	}
    
    public static void glBufferSubData(int target, int offset, int size, java.nio.Buffer data) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static int glCheckFramebufferStatus(int target) {
        return target;
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glClear(int mask) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glClearColor(float red, float green, float blue, float alpha) {
	}
    
    public static void glClearDepthf(float depth) {
	}
    
    public static void glClearStencil(int s) {
	}
    
    public static void glColorMask(boolean red, boolean green, boolean blue, boolean alpha) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glCompileShader(int shader) {
	}
    
    public static void glCompressedTexImage2D(int target, int level, int internalformat, int width, int height, int border, int imageSize, java.nio.Buffer data) {
	}
    
    public static void glCompressedTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, java.nio.Buffer data) {
	}
    
    public static void glCopyTexImage2D(int target, int level, int internalformat, int x, int y, int width, int height, int border) {
	}
    
    public static void glCopyTexSubImage2D(int target, int level, int xoffset, int yoffset, int x, int y, int width, int height) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static int glCreateProgram() {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_519833282 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_519833282;
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static int glCreateShader(int type) {
        return type;
	}
    
    public static void glCullFace(int mode) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glDeleteBuffers(int n, int[] buffers, int offset) {
	}
    
    public static void glDeleteBuffers(int n, java.nio.IntBuffer buffers) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glDeleteFramebuffers(int n, int[] framebuffers, int offset) {
	}
    
    public static void glDeleteFramebuffers(int n, java.nio.IntBuffer framebuffers) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glDeleteProgram(int program) {
	}
    
    public static void glDeleteRenderbuffers(int n, int[] renderbuffers, int offset) {
	}
    
    public static void glDeleteRenderbuffers(int n, java.nio.IntBuffer renderbuffers) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glDeleteShader(int shader) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glDeleteTextures(int n, int[] textures, int offset) {
	}
    
    public static void glDeleteTextures(int n, java.nio.IntBuffer textures) {
	}
    
    public static void glDepthFunc(int func) {
	}
    
    public static void glDepthMask(boolean flag) {
	}
    
    public static void glDepthRangef(float zNear, float zFar) {
	}
    
    public static void glDetachShader(int program, int shader) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glDisable(int cap) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glDisableVertexAttribArray(int index) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glDrawArrays(int mode, int first, int count) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glDrawElements(int mode, int count, int type, int offset) {
	}
    
    public static void glDrawElements(int mode, int count, int type, java.nio.Buffer indices) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glEnable(int cap) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glEnableVertexAttribArray(int index) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glFinish() {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glFlush() {
	}
    
    public static void glFramebufferRenderbuffer(int target, int attachment, int renderbuffertarget, int renderbuffer) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glFramebufferTexture2D(int target, int attachment, int textarget, int texture, int level) {
	}
    
    public static void glFrontFace(int mode) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glGenBuffers(int n, int[] buffers, int offset) {
	}
    
    public static void glGenBuffers(int n, java.nio.IntBuffer buffers) {
	}
    
    public static void glGenerateMipmap(int target) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glGenFramebuffers(int n, int[] framebuffers, int offset) {
	}
    
    public static void glGenFramebuffers(int n, java.nio.IntBuffer framebuffers) {
	}
    
    public static void glGenRenderbuffers(int n, int[] renderbuffers, int offset) {
	}
    
    public static void glGenRenderbuffers(int n, java.nio.IntBuffer renderbuffers) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glGenTextures(int n, int[] textures, int offset) {
	}
    
    public static void glGenTextures(int n, java.nio.IntBuffer textures) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glGetActiveAttrib(int program, int index, int bufsize, int[] length, int lengthOffset, int[] size, int sizeOffset, int[] type, int typeOffset, byte[] name,
			int nameOffset) {
	}
    
    public static void glGetActiveAttrib(int program, int index, int bufsize, java.nio.IntBuffer length, java.nio.IntBuffer size, java.nio.IntBuffer type, byte name) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glGetActiveUniform(int program, int index, int bufsize, int[] length, int lengthOffset, int[] size, int sizeOffset, int[] type, int typeOffset, byte[] name,
			int nameOffset) {
	}
    
    public static void glGetActiveUniform(int program, int index, int bufsize, java.nio.IntBuffer length, java.nio.IntBuffer size, java.nio.IntBuffer type, byte name) {
	}
    
    public static void glGetAttachedShaders(int program, int maxcount, int[] count, int countOffset, int[] shaders, int shadersOffset) {
	}
    
    public static void glGetAttachedShaders(int program, int maxcount, java.nio.IntBuffer count, java.nio.IntBuffer shaders) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static int glGetAttribLocation(int program, String name) {
        return (program + name.getTaintInt());
	}
    
    public static void glGetBooleanv(int pname, boolean[] params, int offset) {
	}
    
    public static void glGetBooleanv(int pname, java.nio.IntBuffer params) {
	}
    
    public static void glGetBufferParameteriv(int target, int pname, int[] params, int offset) {
	}
    
    public static void glGetBufferParameteriv(int target, int pname, java.nio.IntBuffer params) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static int glGetError() {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_117972472 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_117972472;
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glGetFloatv(int pname, float[] params, int offset) {
	}
    
    public static void glGetFloatv(int pname, java.nio.FloatBuffer params) {
	}
    
    public static void glGetFramebufferAttachmentParameteriv(int target, int attachment, int pname, int[] params, int offset) {
	}
    
    public static void glGetFramebufferAttachmentParameteriv(int target, int attachment, int pname, java.nio.IntBuffer params) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glGetIntegerv(int pname, int[] params, int offset) {
	}
    
    public static void glGetIntegerv(int pname, java.nio.IntBuffer params) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glGetProgramiv(int program, int pname, int[] params, int offset) {
	}
    
    public static void glGetProgramiv(int program, int pname, java.nio.IntBuffer params) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static String glGetProgramInfoLog(int program) {
		return new String();
	}
    
    public static void glGetRenderbufferParameteriv(int target, int pname, int[] params, int offset) {
	}
    
    public static void glGetRenderbufferParameteriv(int target, int pname, java.nio.IntBuffer params) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glGetShaderiv(int shader, int pname, int[] params, int offset) {
	}
    
    public static void glGetShaderiv(int shader, int pname, java.nio.IntBuffer params) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static String glGetShaderInfoLog(int shader) {
		return new String();
	}
    
    public static void glGetShaderPrecisionFormat(int shadertype, int precisiontype, int[] range, int rangeOffset, int[] precision, int precisionOffset) {
	}
    
    public static void glGetShaderPrecisionFormat(int shadertype, int precisiontype, java.nio.IntBuffer range, java.nio.IntBuffer precision) {
	}
    
    public static void glGetShaderSource(int shader, int bufsize, int[] length, int lengthOffset, byte[] source, int sourceOffset) {
	}
    
    public static void glGetShaderSource(int shader, int bufsize, java.nio.IntBuffer length, byte source) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static String glGetString(int name) {
		return new String();
	}
    
    public static void glGetTexParameterfv(int target, int pname, float[] params, int offset) {
	}
    
    public static void glGetTexParameterfv(int target, int pname, java.nio.FloatBuffer params) {
	}
    
    public static void glGetTexParameteriv(int target, int pname, int[] params, int offset) {
	}
    
    public static void glGetTexParameteriv(int target, int pname, java.nio.IntBuffer params) {
	}
    
    public static void glGetUniformfv(int program, int location, float[] params, int offset) {
	}
    
    public static void glGetUniformfv(int program, int location, java.nio.FloatBuffer params) {
	}
    
    public static void glGetUniformiv(int program, int location, int[] params, int offset) {
	}
    
    public static void glGetUniformiv(int program, int location, java.nio.IntBuffer params) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static int glGetUniformLocation(int program, String name) {
        return (name.getTaintInt() + program);
	}
    
    public static void glGetVertexAttribfv(int index, int pname, float[] params, int offset) {
	}
    
    public static void glGetVertexAttribfv(int index, int pname, java.nio.FloatBuffer params) {
	}
    
    public static void glGetVertexAttribiv(int index, int pname, int[] params, int offset) {
	}
    
    public static void glGetVertexAttribiv(int index, int pname, java.nio.IntBuffer params) {
	}
    
    public static void glHint(int target, int mode) {
	}
    
    public static boolean glIsBuffer(int buffer) {
        return (buffer > 0);
	}
    
    public static boolean glIsEnabled(int cap) {
        return (cap > 0);
	}
    
    public static boolean glIsFramebuffer(int framebuffer) {
        return (framebuffer != 0);
	}
    
    public static boolean glIsProgram(int program) {
        return (program != 0);
	}
    
    public static boolean glIsRenderbuffer(int renderbuffer) {
        return (renderbuffer != 0);
	}
    
    public static boolean glIsShader(int shader) {
        return shader;
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static boolean glIsTexture(int texture) {
        return texture;
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glLineWidth(float width) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glLinkProgram(int program) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glPixelStorei(int pname, int param) {
	}
    
    public static void glPolygonOffset(float factor, float units) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glReadPixels(int x, int y, int width, int height, int format, int type, java.nio.Buffer pixels) {
	}
    
    public static void glReleaseShaderCompiler() {
	}
    
    public static void glRenderbufferStorage(int target, int internalformat, int width, int height) {
	}
    
    public static void glSampleCoverage(float value, boolean invert) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glScissor(int x, int y, int width, int height) {
	}
    
    public static void glShaderBinary(int n, int[] shaders, int offset, int binaryformat, java.nio.Buffer binary, int length) {
	}
    
    public static void glShaderBinary(int n, java.nio.IntBuffer shaders, int binaryformat, java.nio.Buffer binary, int length) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glShaderSource(int shader, String string) {
	}
    
    public static void glStencilFunc(int func, int ref, int mask) {
	}
    
    public static void glStencilFuncSeparate(int face, int func, int ref, int mask) {
	}
    
    public static void glStencilMask(int mask) {
	}
    
    public static void glStencilMaskSeparate(int face, int mask) {
	}
    
    public static void glStencilOp(int fail, int zfail, int zpass) {
	}
    
    public static void glStencilOpSeparate(int face, int fail, int zfail, int zpass) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, java.nio.Buffer pixels) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glTexParameterf(int target, int pname, float param) {
	}
    
    public static void glTexParameterfv(int target, int pname, float[] params, int offset) {
	}
    
    public static void glTexParameterfv(int target, int pname, java.nio.FloatBuffer params) {
	}
    
    public static void glTexParameteri(int target, int pname, int param) {
	}
    
    public static void glTexParameteriv(int target, int pname, int[] params, int offset) {
	}
    
    public static void glTexParameteriv(int target, int pname, java.nio.IntBuffer params) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, java.nio.Buffer pixels) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glUniform1f(int location, float x) {
	}
    
    public static void glUniform1fv(int location, int count, float[] v, int offset) {
	}
    
    public static void glUniform1fv(int location, int count, java.nio.FloatBuffer v) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glUniform1i(int location, int x) {
	}
    
    public static void glUniform1iv(int location, int count, int[] v, int offset) {
	}
    
    public static void glUniform1iv(int location, int count, java.nio.IntBuffer v) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glUniform2f(int location, float x, float y) {
	}
    
    public static void glUniform2fv(int location, int count, float[] v, int offset) {
	}
    
    public static void glUniform2fv(int location, int count, java.nio.FloatBuffer v) {
	}
    
    public static void glUniform2i(int location, int x, int y) {
	}
    
    public static void glUniform2iv(int location, int count, int[] v, int offset) {
	}
    
    public static void glUniform2iv(int location, int count, java.nio.IntBuffer v) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glUniform3f(int location, float x, float y, float z) {
	}
    
    public static void glUniform3fv(int location, int count, float[] v, int offset) {
	}
    
    public static void glUniform3fv(int location, int count, java.nio.FloatBuffer v) {
	}
    
    public static void glUniform3i(int location, int x, int y, int z) {
	}
    
    public static void glUniform3iv(int location, int count, int[] v, int offset) {
	}
    
    public static void glUniform3iv(int location, int count, java.nio.IntBuffer v) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glUniform4f(int location, float x, float y, float z, float w) {
	}
    
    public static void glUniform4fv(int location, int count, float[] v, int offset) {
	}
    
    public static void glUniform4fv(int location, int count, java.nio.FloatBuffer v) {
	}
    
    public static void glUniform4i(int location, int x, int y, int z, int w) {
	}
    
    public static void glUniform4iv(int location, int count, int[] v, int offset) {
	}
    
    public static void glUniform4iv(int location, int count, java.nio.IntBuffer v) {
	}
    
    public static void glUniformMatrix2fv(int location, int count, boolean transpose, float[] value, int offset) {
	}
    
    public static void glUniformMatrix2fv(int location, int count, boolean transpose, java.nio.FloatBuffer value) {
	}
    
    public static void glUniformMatrix3fv(int location, int count, boolean transpose, float[] value, int offset) {
	}
    
    public static void glUniformMatrix3fv(int location, int count, boolean transpose, java.nio.FloatBuffer value) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glUniformMatrix4fv(int location, int count, boolean transpose, float[] value, int offset) {
	}
    
    public static void glUniformMatrix4fv(int location, int count, boolean transpose, java.nio.FloatBuffer value) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glUseProgram(int program) {
	}
    
    public static void glValidateProgram(int program) {
	}
    
    public static void glVertexAttrib1f(int indx, float x) {
	}
    
    public static void glVertexAttrib1fv(int indx, float[] values, int offset) {
	}
    
    public static void glVertexAttrib1fv(int indx, java.nio.FloatBuffer values) {
	}
    
    public static void glVertexAttrib2f(int indx, float x, float y) {
	}
    
    public static void glVertexAttrib2fv(int indx, float[] values, int offset) {
	}
    
    public static void glVertexAttrib2fv(int indx, java.nio.FloatBuffer values) {
	}
    
    public static void glVertexAttrib3f(int indx, float x, float y, float z) {
	}
    
    public static void glVertexAttrib3fv(int indx, float[] values, int offset) {
	}
    
    public static void glVertexAttrib3fv(int indx, java.nio.FloatBuffer values) {
	}
    
    public static void glVertexAttrib4f(int indx, float x, float y, float z, float w) {
	}
    
    public static void glVertexAttrib4fv(int indx, float[] values, int offset) {
	}
    
    public static void glVertexAttrib4fv(int indx, java.nio.FloatBuffer values) {
	}
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glVertexAttribPointer(int indx, int size, int type, boolean normalized, int stride, int offset) {
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void glVertexAttribPointerBounds(int indx, int size, int type, boolean normalized, int stride, java.nio.Buffer ptr, int remaining) {
	}

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:12.824 -0500", hash_original_method = "3131AE64743A58774CEFE4BA0D002733", hash_generated_method = "8A6AFF09F7EB55DE063D9B664AA8F12E")
    
public static void glVertexAttribPointer(
        int indx,
        int size,
        int type,
        boolean normalized,
        int stride,
        java.nio.Buffer ptr
    ) {
        glVertexAttribPointerBounds(
            indx,
            size,
            type,
            normalized,
            stride,
            ptr,
            ptr.remaining()
        );
    }
    
    @DSComment("OpenGL Graphics Manipulation")
    @DSSafe(DSCat.GRAPHICS)
    public static void glViewport(int x, int y, int width, int height) {
	}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.128 -0500", hash_original_field = "4108D2E908495B9D3DBDA59F2E00A327", hash_generated_field = "43604D5B9BADECF82E5DC08A6A6E973D")

    public static final int GL_ACTIVE_TEXTURE                          = 0x84E0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.131 -0500", hash_original_field = "4D2B5E7F3B0B44F8A6A7B3F58829B63A", hash_generated_field = "825F9100DD8C652E13E98054D7F396F6")

    public static final int GL_DEPTH_BUFFER_BIT                        = 0x00000100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.134 -0500", hash_original_field = "8D4B50CE6BC97FDBE7E4C9D828FFEAF9", hash_generated_field = "51F465DFDA22B261A43355734F1B08CA")

    public static final int GL_STENCIL_BUFFER_BIT                      = 0x00000400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.137 -0500", hash_original_field = "FA6BB81EF5BAFAF806154918BAE300CF", hash_generated_field = "ADC58C4A25500D2F22EC3873A7230F2B")

    public static final int GL_COLOR_BUFFER_BIT                        = 0x00004000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.140 -0500", hash_original_field = "08093328E5CBC234C1A3469BF219D73F", hash_generated_field = "EC3A3073EC7FF4A46704A9ED43C9E386")

    public static final int GL_FALSE                                   = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.143 -0500", hash_original_field = "52A8117B6258A2597D3FCB27F3B3F858", hash_generated_field = "61D712C997F883C5E54B2F3515C8B065")

    public static final int GL_TRUE                                    = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.146 -0500", hash_original_field = "8749C057A3111991FD4D1B79CDC23774", hash_generated_field = "3AEB111123D4B87DB7AFE0BBC7526140")

    public static final int GL_POINTS                                  = 0x0000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.148 -0500", hash_original_field = "B649F75AB5AA45B52229086A01D8C7D3", hash_generated_field = "40A33BDBD75619099109C07E3630DD5F")

    public static final int GL_LINES                                   = 0x0001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.152 -0500", hash_original_field = "EED2D831F232BB8B730D9142F14CA3C7", hash_generated_field = "952CBB2FE89C544168C9BA35CC4CC48B")

    public static final int GL_LINE_LOOP                               = 0x0002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.154 -0500", hash_original_field = "3150112A8009CB667FDF9F27566C72DA", hash_generated_field = "40BBE33B8608A6DBB9A295EBCE625672")

    public static final int GL_LINE_STRIP                              = 0x0003;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.157 -0500", hash_original_field = "1C87BDB4260C88F3E387AADE1385026B", hash_generated_field = "E770048AE0B8EE2CF20B5355345E232E")

    public static final int GL_TRIANGLES                               = 0x0004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.159 -0500", hash_original_field = "7B04E94F15950352604BF61C2167BB9A", hash_generated_field = "2DFC30CE5B5D0C909353FE0F8E82ECAE")

    public static final int GL_TRIANGLE_STRIP                          = 0x0005;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.163 -0500", hash_original_field = "2D54BDF5B77E4B9A5E4F7165E7B820E8", hash_generated_field = "E319033744A6FD5FBED22534A09D0D9A")

    public static final int GL_TRIANGLE_FAN                            = 0x0006;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.166 -0500", hash_original_field = "B948F81EA8A7845FB3E8D7046A8B0327", hash_generated_field = "2AE94B595542B2CF364EA127E42FBDCE")

    public static final int GL_ZERO                                    = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.169 -0500", hash_original_field = "BE3417F18C108C62495D072D46E3DD9E", hash_generated_field = "82D5FE136043639857A6207E913F1A47")

    public static final int GL_ONE                                     = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.172 -0500", hash_original_field = "98C174CDFE2C236BE132B81F977C8CF4", hash_generated_field = "C2011F8B7C7C63680FD638429313D1E6")

    public static final int GL_SRC_COLOR                               = 0x0300;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.175 -0500", hash_original_field = "BDCA30E102D92990FB060AD043B08CF9", hash_generated_field = "FBD253CA03B8349C32F1201CE77928A2")

    public static final int GL_ONE_MINUS_SRC_COLOR                     = 0x0301;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.177 -0500", hash_original_field = "A89BDCA912F84D6BAB2471EB3ABA9336", hash_generated_field = "DD041534D4A71692473722C9C3DA669C")

    public static final int GL_SRC_ALPHA                               = 0x0302;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.180 -0500", hash_original_field = "415D9A12139EDD68230C201E5D780D0B", hash_generated_field = "9C97EBACE4D89BA37F0CE50A2B4086CF")

    public static final int GL_ONE_MINUS_SRC_ALPHA                     = 0x0303;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.183 -0500", hash_original_field = "02EC0D013713BAD1AB69A75E3017F120", hash_generated_field = "EA877CAC2DCE84B662BEC6DE59F3F34C")

    public static final int GL_DST_ALPHA                               = 0x0304;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.185 -0500", hash_original_field = "B59E269D67BE16F3BA6A9E974E40C3D3", hash_generated_field = "3AEBAEB1CF16CE34127FDC76A8AA5071")

    public static final int GL_ONE_MINUS_DST_ALPHA                     = 0x0305;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.188 -0500", hash_original_field = "4863C86C8D6BECBD02B1BF3834A8DA37", hash_generated_field = "16B27F3397CB1CE88331D5E0EC0490B7")

    public static final int GL_DST_COLOR                               = 0x0306;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.190 -0500", hash_original_field = "0068DB757F519A69C3BC0A03427FC87B", hash_generated_field = "77C61F9F16CE09FE063CB4595FE9C0EF")

    public static final int GL_ONE_MINUS_DST_COLOR                     = 0x0307;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.193 -0500", hash_original_field = "F5B8188E28210B4B0AB4FC64EAB105A3", hash_generated_field = "70AEA0E98FC9C061FAC240ADA8332C5A")

    public static final int GL_SRC_ALPHA_SATURATE                      = 0x0308;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.197 -0500", hash_original_field = "B6A1037741E5737EF2533FD8FEB427D9", hash_generated_field = "D50902402D69C610A934715E6F129BD3")

    public static final int GL_FUNC_ADD                                = 0x8006;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.200 -0500", hash_original_field = "ACFAF021F40EFC09BD94B4A737330DA6", hash_generated_field = "6EC3F2C104AF957D6866EF21152EADD2")

    public static final int GL_BLEND_EQUATION                          = 0x8009;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.202 -0500", hash_original_field = "BD84431587975D4C8B4436B5AC5BB717", hash_generated_field = "3A289A85D25C00F928C1FE0732A231E5")

    public static final int GL_BLEND_EQUATION_RGB                      = 0x8009;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.205 -0500", hash_original_field = "AAC2211534A1A951913FFB5E94E5B380", hash_generated_field = "8328458ADD239D21874D8602CBEE1CD0")

    public static final int GL_BLEND_EQUATION_ALPHA                    = 0x883D;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.207 -0500", hash_original_field = "BF10E2E3BBD96E8E42F80E40F24787D3", hash_generated_field = "2789A42AD17642336ED89176D3459CBA")

    public static final int GL_FUNC_SUBTRACT                           = 0x800A;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.212 -0500", hash_original_field = "7DACDA7B02BB2FC47E99ADAAF6FD5A2E", hash_generated_field = "841B2BFE51EFB61AF9621A796D6F8FE0")

    public static final int GL_FUNC_REVERSE_SUBTRACT                   = 0x800B;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.217 -0500", hash_original_field = "DCF24BCCF63A220E0EEEA46E4B12DA89", hash_generated_field = "56DA957254437B7345E4D14FFC6938F0")

    public static final int GL_BLEND_DST_RGB                           = 0x80C8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.220 -0500", hash_original_field = "6FF989D3BBE792DF316783A0773BCBAE", hash_generated_field = "7021FDA07EC829387602BE1DA5E8DB1B")

    public static final int GL_BLEND_SRC_RGB                           = 0x80C9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.223 -0500", hash_original_field = "4B145927BB17C3EA6F6D480D81626281", hash_generated_field = "23323BADC5529A62BEEC78CC402AE3FF")

    public static final int GL_BLEND_DST_ALPHA                         = 0x80CA;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.225 -0500", hash_original_field = "BFA8ED8F8A8352493C5D06D2DF96E5EB", hash_generated_field = "37127A5319E99E3AF83DB2376058D495")

    public static final int GL_BLEND_SRC_ALPHA                         = 0x80CB;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.228 -0500", hash_original_field = "4FE303C32ABA1DE8A09F598DB68B6586", hash_generated_field = "82AD4438DC04513576F31837F477C2B3")

    public static final int GL_CONSTANT_COLOR                          = 0x8001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.230 -0500", hash_original_field = "8827028E6992AB73C9CAF1D75F381053", hash_generated_field = "BDCC0896DDCAFA199087427799B9EA5D")

    public static final int GL_ONE_MINUS_CONSTANT_COLOR                = 0x8002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.233 -0500", hash_original_field = "FE2108F98C02704F23ADAF0397BD3537", hash_generated_field = "BD126F9C972C4B7B4CC57D9F4F005914")

    public static final int GL_CONSTANT_ALPHA                          = 0x8003;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.235 -0500", hash_original_field = "95C0F112EEC7AA6F7DDD615007FF2FDB", hash_generated_field = "0C97206C3329306E43B66DC5181EBE7B")

    public static final int GL_ONE_MINUS_CONSTANT_ALPHA                = 0x8004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.237 -0500", hash_original_field = "497ED10E5FC8D59BB3181852DA9BBF2C", hash_generated_field = "1668CEB39BFB5487D035EA0A3FACD265")

    public static final int GL_BLEND_COLOR                             = 0x8005;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.241 -0500", hash_original_field = "30A4E1BD01577F6F03472A930D7EB9BC", hash_generated_field = "409495B1B8CFA1F8211F60AD68365B86")

    public static final int GL_ARRAY_BUFFER                            = 0x8892;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.245 -0500", hash_original_field = "51C2587F4D5082179BAB886D37A4B135", hash_generated_field = "38D85FEBECCF45569EA094673A351A4D")

    public static final int GL_ELEMENT_ARRAY_BUFFER                    = 0x8893;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.249 -0500", hash_original_field = "6753618594D647C8A2F4EF0645D7A0B1", hash_generated_field = "B8BBB605C29E504DD83196936ACA9837")

    public static final int GL_ARRAY_BUFFER_BINDING                    = 0x8894;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.252 -0500", hash_original_field = "82C4195EC75EF495BD37785DD951357C", hash_generated_field = "C740F3ADA0906D319EF5C52026B18A05")

    public static final int GL_ELEMENT_ARRAY_BUFFER_BINDING            = 0x8895;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.254 -0500", hash_original_field = "037DF20F10DEAA30C4AE98729347FEB7", hash_generated_field = "832C1E21FAAB59494282453ADDE744D0")

    public static final int GL_STREAM_DRAW                             = 0x88E0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.257 -0500", hash_original_field = "B683E4BF745535C0798C557BE7DB7BBF", hash_generated_field = "89FAC3E23D9D7D02625C85E6D1604B80")

    public static final int GL_STATIC_DRAW                             = 0x88E4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.259 -0500", hash_original_field = "0E7F593ACFBB927F2703925FF729EFA1", hash_generated_field = "2242CD9452F430351807890803F544C6")

    public static final int GL_DYNAMIC_DRAW                            = 0x88E8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.262 -0500", hash_original_field = "49D58916F537460E52CCB872E862BE0E", hash_generated_field = "21798B99CB9AEBC6C5FE28B5A981B8F5")

    public static final int GL_BUFFER_SIZE                             = 0x8764;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.265 -0500", hash_original_field = "E4587114BC789348367E884667D98B95", hash_generated_field = "C76A93BA5DA7C1B1CCA9AC65B1B8BB10")

    public static final int GL_BUFFER_USAGE                            = 0x8765;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.267 -0500", hash_original_field = "2F015CB3EE8B57A93046FC73B45D0F94", hash_generated_field = "463800F0A213D6B17324F9D7235D9EB5")

    public static final int GL_CURRENT_VERTEX_ATTRIB                   = 0x8626;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.270 -0500", hash_original_field = "B2AB6067D36EDEFAA41112C2BEEE2FC2", hash_generated_field = "282681C01F23D92A723004A36CE68F21")

    public static final int GL_FRONT                                   = 0x0404;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.273 -0500", hash_original_field = "DBC720A258D1D52F03238794938A4584", hash_generated_field = "8D01D16E233D653B13BF35763F39094C")

    public static final int GL_BACK                                    = 0x0405;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.276 -0500", hash_original_field = "EC74BF4B1349C10E5DE032A3CBAB4EB7", hash_generated_field = "2823AEA7B2FB283F963720184AE348D1")

    public static final int GL_FRONT_AND_BACK                          = 0x0408;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.278 -0500", hash_original_field = "9539D8C154FDDE11BCDC70B372765AE3", hash_generated_field = "CFA8DF52C890C8F91C1BA2D266BB91EB")

    public static final int GL_TEXTURE_2D                              = 0x0DE1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.280 -0500", hash_original_field = "7490372009263C674F2FFF43612A874B", hash_generated_field = "9ABC6C59449029C0D07E4AB5037CCDA7")

    public static final int GL_CULL_FACE                               = 0x0B44;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.283 -0500", hash_original_field = "35610FBC5C341882519ECEC953D817D1", hash_generated_field = "B8047B6EFFF20A9163B2D267795697BD")

    public static final int GL_BLEND                                   = 0x0BE2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.286 -0500", hash_original_field = "973E1204B3D1DA59852E88B466F65A17", hash_generated_field = "55F31A3EBC84BD31DE876C99C319C524")

    public static final int GL_DITHER                                  = 0x0BD0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.289 -0500", hash_original_field = "7AC6C4E7FDB8FDC2381A14CAED9B2FCC", hash_generated_field = "8DC539E2C1E101290729428C524DA2DC")

    public static final int GL_STENCIL_TEST                            = 0x0B90;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.291 -0500", hash_original_field = "D0F13481B1237405585629B11F088C2F", hash_generated_field = "FA6A17422F3B297267EDCBF88D16D4C5")

    public static final int GL_DEPTH_TEST                              = 0x0B71;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.294 -0500", hash_original_field = "B5A39E08958BA0858C6FA9DCE1E96848", hash_generated_field = "62D9DAC9732EE80D837C16904113DAEA")

    public static final int GL_SCISSOR_TEST                            = 0x0C11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.297 -0500", hash_original_field = "A7A9C246E3B70DBCAF97010BE7A70112", hash_generated_field = "A9BCF6D80660E88427AD2FFB50877931")

    public static final int GL_POLYGON_OFFSET_FILL                     = 0x8037;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.299 -0500", hash_original_field = "C38759DE17EB471A77221F6DD9B8427F", hash_generated_field = "0C96EEA0B791093940726427BE517D6B")

    public static final int GL_SAMPLE_ALPHA_TO_COVERAGE                = 0x809E;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.302 -0500", hash_original_field = "1C8D3D44F8563C0E22E998CFA5366CD6", hash_generated_field = "E4DE56A2A355F1A7C7E2A493405E4965")

    public static final int GL_SAMPLE_COVERAGE                         = 0x80A0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.305 -0500", hash_original_field = "AFC6AFB12451CE4897E0CFDCF60E5755", hash_generated_field = "0653236F53D5E9A2C959345944242124")

    public static final int GL_NO_ERROR                                = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.307 -0500", hash_original_field = "2D16131BF3DC60CF3E5A4F19DFFE7A28", hash_generated_field = "F8C6C9C7A3A9BA71ADE96972F4E2BE91")

    public static final int GL_INVALID_ENUM                            = 0x0500;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.310 -0500", hash_original_field = "34BE2E4458B164A81EE0F052CB485000", hash_generated_field = "E2D361363B879444BF7C0E4D575B7395")

    public static final int GL_INVALID_VALUE                           = 0x0501;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.313 -0500", hash_original_field = "0D18295AB7AD87C1319901E77B247DEF", hash_generated_field = "BF905AF0CB04092D0B0DA2F0D5839959")

    public static final int GL_INVALID_OPERATION                       = 0x0502;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.317 -0500", hash_original_field = "A5C3165A95E16E89415D8AD126DA00F5", hash_generated_field = "E95871CFC24E5C6E759FA8B49E0583BF")

    public static final int GL_OUT_OF_MEMORY                           = 0x0505;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.321 -0500", hash_original_field = "9B9C8CC921A30F76E5A85BE33BC5EFD4", hash_generated_field = "2C6DCD63CABB3C41ECC7B9014ED3B907")

    public static final int GL_CW                                      = 0x0900;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.326 -0500", hash_original_field = "664F37115AA5C42CD3C8607DACCE9706", hash_generated_field = "D90679929372A8D046997B2D0E27D061")

    public static final int GL_CCW                                     = 0x0901;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.330 -0500", hash_original_field = "978C88F11E8DA56AB2F61CBF9D31D57C", hash_generated_field = "01DB5ECBD6642646F30B04C94349F17B")

    public static final int GL_LINE_WIDTH                              = 0x0B21;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.335 -0500", hash_original_field = "D23E522CA4824E747CD019155533B48C", hash_generated_field = "19883743E3CCB19994F89686F320722F")

    public static final int GL_ALIASED_POINT_SIZE_RANGE                = 0x846D;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.340 -0500", hash_original_field = "CC04B228955912ABA3215389FED65A0B", hash_generated_field = "8FCB0F04C33D33E10BECE828D721612F")

    public static final int GL_ALIASED_LINE_WIDTH_RANGE                = 0x846E;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.344 -0500", hash_original_field = "9881E9FE1144E29F541E77E354602455", hash_generated_field = "767EAD326AF86CD019950B2E108A7917")

    public static final int GL_CULL_FACE_MODE                          = 0x0B45;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.349 -0500", hash_original_field = "EA31347CF9DD98739B0D29F49ECE3DE5", hash_generated_field = "B3F8F582DE87930692E11DF9F0867E22")

    public static final int GL_FRONT_FACE                              = 0x0B46;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.353 -0500", hash_original_field = "116BE645A99C2B421A855E01E4F865EE", hash_generated_field = "4798273E6A8C1B8636D49958CC58C63F")

    public static final int GL_DEPTH_RANGE                             = 0x0B70;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.358 -0500", hash_original_field = "6F86B5C796500E6656BBC9E0D13F5016", hash_generated_field = "E186156B09F36E2215F5FFC278B81FD8")

    public static final int GL_DEPTH_WRITEMASK                         = 0x0B72;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.363 -0500", hash_original_field = "F199B31483D694420682C5E4711F3788", hash_generated_field = "08458BB4D7EE93F163492A8A76853E2C")

    public static final int GL_DEPTH_CLEAR_VALUE                       = 0x0B73;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.367 -0500", hash_original_field = "903D74AC0CD9D48A7EC673BE044B394F", hash_generated_field = "A5BE43A42F568B6C881DDCF04E9D2409")

    public static final int GL_DEPTH_FUNC                              = 0x0B74;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.370 -0500", hash_original_field = "24B43CA4CBA4DBAE24EF0E19892801C8", hash_generated_field = "9131E5B584F55CE29F01D2ECEE52427A")

    public static final int GL_STENCIL_CLEAR_VALUE                     = 0x0B91;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.373 -0500", hash_original_field = "F68483CEB6EAFD3044B5AFF6CCAF2E7E", hash_generated_field = "D7938EE10441B2911024C8670D093813")

    public static final int GL_STENCIL_FUNC                            = 0x0B92;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.375 -0500", hash_original_field = "6B20B0EA59D5480675154434B7988CE0", hash_generated_field = "CC69FC57D650B08307A58FD35CB51C8A")

    public static final int GL_STENCIL_FAIL                            = 0x0B94;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.377 -0500", hash_original_field = "4367369BF5F88124932BB84B7B47D3B9", hash_generated_field = "6FAC8F4E96B44838F58A4E04D6286655")

    public static final int GL_STENCIL_PASS_DEPTH_FAIL                 = 0x0B95;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.380 -0500", hash_original_field = "B2C1BF44825B5E1E2DFC25C8E9225815", hash_generated_field = "960C2A2112B7861CC22EACBC1AAF69FC")

    public static final int GL_STENCIL_PASS_DEPTH_PASS                 = 0x0B96;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.384 -0500", hash_original_field = "CB00DDFCC4D1F488204B73280A2D64F4", hash_generated_field = "90F2BD1F9CD30298F9AC7F2BBC6F0232")

    public static final int GL_STENCIL_REF                             = 0x0B97;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.386 -0500", hash_original_field = "87D26BE2599194882EBEB305B9E070D0", hash_generated_field = "8FAE667B4EF9352BC9C17E6BF12BA194")

    public static final int GL_STENCIL_VALUE_MASK                      = 0x0B93;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.389 -0500", hash_original_field = "6759BBAF82D86929E0B63219191DB344", hash_generated_field = "3577EE931F082669BBE4D9969E122778")

    public static final int GL_STENCIL_WRITEMASK                       = 0x0B98;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.391 -0500", hash_original_field = "0601139CFECC8F4EBD6F15E453B1FC07", hash_generated_field = "EFFC38CBA05B79292ACD80DD4D1190D7")

    public static final int GL_STENCIL_BACK_FUNC                       = 0x8800;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.394 -0500", hash_original_field = "B23CF9AC93B66E4B26D13B8933A28D13", hash_generated_field = "BDAAF1440D011FC1E51494FDA8588400")

    public static final int GL_STENCIL_BACK_FAIL                       = 0x8801;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.396 -0500", hash_original_field = "61A0276F85DEACED3D95450E647AA6A6", hash_generated_field = "8A0A4F4A34082B512827A63A47F88467")

    public static final int GL_STENCIL_BACK_PASS_DEPTH_FAIL            = 0x8802;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.399 -0500", hash_original_field = "476681907CE150D26C2FE551A2F9E869", hash_generated_field = "05976D765A202DD7AF5E935D0336FC85")

    public static final int GL_STENCIL_BACK_PASS_DEPTH_PASS            = 0x8803;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.401 -0500", hash_original_field = "B5DC4044FAA46503F833C6E592B56096", hash_generated_field = "B893D3B9E979B8C21EB6C04613D71E8C")

    public static final int GL_STENCIL_BACK_REF                        = 0x8CA3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.404 -0500", hash_original_field = "58EC8365C4813A09DA9FD47BC22A27BD", hash_generated_field = "FBBABA523C9F04591BCDE5CAA1B50E9F")

    public static final int GL_STENCIL_BACK_VALUE_MASK                 = 0x8CA4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.407 -0500", hash_original_field = "5903D902AF815B87B53DB89C0C7E0D0B", hash_generated_field = "14315390EC704CAED92B0E7E67CB9D21")

    public static final int GL_STENCIL_BACK_WRITEMASK                  = 0x8CA5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.410 -0500", hash_original_field = "49E2487644C8C933AD41EB669F85105F", hash_generated_field = "03970251FDEDB198C704D5CB1226C075")

    public static final int GL_VIEWPORT                                = 0x0BA2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.413 -0500", hash_original_field = "CC99C2E113C8F8769FBE73458BA9CDB0", hash_generated_field = "189E13B6264AAB01FEB79D7F93C0DED3")

    public static final int GL_SCISSOR_BOX                             = 0x0C10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.416 -0500", hash_original_field = "CEA0E610BB82BE6EC569559D2CCF0026", hash_generated_field = "0F9D40CABAE9B4759159781D6865495A")

    public static final int GL_COLOR_CLEAR_VALUE                       = 0x0C22;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.419 -0500", hash_original_field = "44F18008F68B38823D5C02957236E774", hash_generated_field = "0E0B9D3D43481CD8AAE788491395F40B")

    public static final int GL_COLOR_WRITEMASK                         = 0x0C23;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.421 -0500", hash_original_field = "0B8D42835C9C2BBFF982D2D833B6C0AC", hash_generated_field = "07391187CDB7D66B8228865535D68F9C")

    public static final int GL_UNPACK_ALIGNMENT                        = 0x0CF5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.424 -0500", hash_original_field = "043A9621A96C595B99C0AA0EF8129A28", hash_generated_field = "420168862C9EEAA13A97C845B02656C9")

    public static final int GL_PACK_ALIGNMENT                          = 0x0D05;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.427 -0500", hash_original_field = "F2B788CF5B11DB045326273D95DD86E5", hash_generated_field = "A2ED8C7E41FB13A2FDF8E15102E65BC7")

    public static final int GL_MAX_TEXTURE_SIZE                        = 0x0D33;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.431 -0500", hash_original_field = "E47BC043AF4253D7DB507677D5911C84", hash_generated_field = "BC4991FCAD83DB0A7868B26EBDE034D9")

    public static final int GL_MAX_VIEWPORT_DIMS                       = 0x0D3A;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.433 -0500", hash_original_field = "21E52FCB8DC6989E1B60991E86C508AC", hash_generated_field = "4F10C209D49E9D5A5FC0C3797AA306D8")

    public static final int GL_SUBPIXEL_BITS                           = 0x0D50;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.437 -0500", hash_original_field = "573C8BCBD9BE06BAB47FD8CDBA768172", hash_generated_field = "C50548619DDE0126722D8AB15FF2EF16")

    public static final int GL_RED_BITS                                = 0x0D52;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.439 -0500", hash_original_field = "FEA3DAEC267A934EDBFFB2BC5CBF903E", hash_generated_field = "5B1708D4871A175D42766720896F17EF")

    public static final int GL_GREEN_BITS                              = 0x0D53;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.442 -0500", hash_original_field = "8DF0B9E9F5FA5238FE8FAFE2A4CA6F6D", hash_generated_field = "F1A2269499DEFE7DF6523956BF443AA2")

    public static final int GL_BLUE_BITS                               = 0x0D54;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.444 -0500", hash_original_field = "0BD04B615D2994BAF855E0E27434C845", hash_generated_field = "C7AC3BCD060ADDD8CFBAE19F1D470C1E")

    public static final int GL_ALPHA_BITS                              = 0x0D55;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.446 -0500", hash_original_field = "F1DB310DE09FD1581A3011C1A26135CD", hash_generated_field = "C23671D29990648AA3F86C9EB1C76CED")

    public static final int GL_DEPTH_BITS                              = 0x0D56;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.449 -0500", hash_original_field = "B8C947A45ACCE718281BEF771D2B12E3", hash_generated_field = "C15714275693DB4FD1855853B46EB0D8")

    public static final int GL_STENCIL_BITS                            = 0x0D57;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.451 -0500", hash_original_field = "83710292B11F60FDA4823C44D17505E5", hash_generated_field = "A8B6B31DEEB290A3D4E14090C1758334")

    public static final int GL_POLYGON_OFFSET_UNITS                    = 0x2A00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.454 -0500", hash_original_field = "92E162C785B9CDA1F9F35F85A673D331", hash_generated_field = "1E251FEEDD033907636F04FDD525CDFA")

    public static final int GL_POLYGON_OFFSET_FACTOR                   = 0x8038;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.456 -0500", hash_original_field = "938851113A33339E6B55D8916AE30226", hash_generated_field = "2B50E2FE09FBDA6BDC1234B9C1677E6A")

    public static final int GL_TEXTURE_BINDING_2D                      = 0x8069;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.459 -0500", hash_original_field = "D0E0A9C0B1D716B476986B5356ED952F", hash_generated_field = "505BCEE1C3A7503D7BE7183B26B5561C")

    public static final int GL_SAMPLE_BUFFERS                          = 0x80A8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.461 -0500", hash_original_field = "21E1CBA928C8A0BE58533B2F28AC005B", hash_generated_field = "E33390EBFD238B90E5D6A5E93E9A7398")

    public static final int GL_SAMPLES                                 = 0x80A9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.464 -0500", hash_original_field = "696CB551D212A79D523F6CEE506F83B2", hash_generated_field = "2A100C6BF47ACDB822240C6C42C050DF")

    public static final int GL_SAMPLE_COVERAGE_VALUE                   = 0x80AA;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.466 -0500", hash_original_field = "4CAF44F73C4BFFA727C9F735BF04F684", hash_generated_field = "9C72E7351BE83A77404F868F0BAF7E60")

    public static final int GL_SAMPLE_COVERAGE_INVERT                  = 0x80AB;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.469 -0500", hash_original_field = "CF4D37A50463EA0D044D48473E29BA5D", hash_generated_field = "6B49EE83F1713650B4936148C3D6E1BC")

    public static final int GL_NUM_COMPRESSED_TEXTURE_FORMATS          = 0x86A2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.472 -0500", hash_original_field = "3C65E305EB9C422B8C41D812296B3952", hash_generated_field = "D2E69BE46D8601F3AC337E2E00FD3F7C")

    public static final int GL_COMPRESSED_TEXTURE_FORMATS              = 0x86A3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.474 -0500", hash_original_field = "767F2D72D715CE4230C056184CC6A96E", hash_generated_field = "DCD1693386658F7795F0400387749F39")

    public static final int GL_DONT_CARE                               = 0x1100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.477 -0500", hash_original_field = "93E7F72639BC02FB7FCD0538A4BCF285", hash_generated_field = "B21755035B5719E0A8E87DC953A69D86")

    public static final int GL_FASTEST                                 = 0x1101;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.479 -0500", hash_original_field = "FB17732C5DFB9464572E46E15DB6C58A", hash_generated_field = "6B136FADA83CBD44BC9F1E2EEBAE0BD5")

    public static final int GL_NICEST                                  = 0x1102;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.482 -0500", hash_original_field = "37EB6A830F515DF2BF84858F818D03C8", hash_generated_field = "A6CA2B16E7F8EFAAF9D94589C56B7846")

    public static final int GL_GENERATE_MIPMAP_HINT                    = 0x8192;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.484 -0500", hash_original_field = "9E4B0A571D2EED4C51981CCA7D4D69B7", hash_generated_field = "CA6B17F497DEA88919CF12FEF41C771D")

    public static final int GL_BYTE                                    = 0x1400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.486 -0500", hash_original_field = "999046ADB4870579F39328909A1A9B6E", hash_generated_field = "D9C771F554A8939A1729582F2211DA5D")

    public static final int GL_UNSIGNED_BYTE                           = 0x1401;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.488 -0500", hash_original_field = "1DE2129B136A0CFD87625EC66C51E758", hash_generated_field = "CEC9DBF8A25C09C8EE36A2040FCE90EC")

    public static final int GL_SHORT                                   = 0x1402;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.491 -0500", hash_original_field = "3123986411AF203CCDBF3D8D148287F4", hash_generated_field = "CF2E78B3A757A12168ACD04C3937641C")

    public static final int GL_UNSIGNED_SHORT                          = 0x1403;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.493 -0500", hash_original_field = "15298CBDD3FFF192B52BB3DFA50C51EE", hash_generated_field = "8CDD0011064211DB2BAA375F2E79C61C")

    public static final int GL_INT                                     = 0x1404;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.497 -0500", hash_original_field = "8EE6B87AC6ABF9E257C21298B735174B", hash_generated_field = "CDF4AE5E0E889BCB6DE8745101A9AAAB")

    public static final int GL_UNSIGNED_INT                            = 0x1405;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.499 -0500", hash_original_field = "1FF7A980B9B38A89818F163C1D490A01", hash_generated_field = "776A345C3935B2E98F4769552CE86E47")

    public static final int GL_FLOAT                                   = 0x1406;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.502 -0500", hash_original_field = "D6F9F4A8F3817F8C8ADC7E605BFC5587", hash_generated_field = "54727533A2FC1141376E118EFDF1E024")

    public static final int GL_FIXED                                   = 0x140C;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.504 -0500", hash_original_field = "E8A1D3ED94EA98805C766A792C47755C", hash_generated_field = "801768A53EC22ED09412E1BC74DBBE40")

    public static final int GL_DEPTH_COMPONENT                         = 0x1902;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.507 -0500", hash_original_field = "FFF5CB89CA98BAED11102950880EE41A", hash_generated_field = "EEC5ED5025D8B6C12C784EADC0C94480")

    public static final int GL_ALPHA                                   = 0x1906;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.509 -0500", hash_original_field = "E3AB3708E6A2351311954AE650A3CEFB", hash_generated_field = "6A23C406FDB5B7A1B50702BA5CC9C002")

    public static final int GL_RGB                                     = 0x1907;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.512 -0500", hash_original_field = "29F3B403F55C150284208289AAAD9B12", hash_generated_field = "C54FF8BC96B52D3F5B82AECAA4368DC3")

    public static final int GL_RGBA                                    = 0x1908;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.515 -0500", hash_original_field = "480EA8989C2A8C6794C8BDAF00694497", hash_generated_field = "C81D52BB104C03AD2A5683FF4CB425AE")

    public static final int GL_LUMINANCE                               = 0x1909;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.517 -0500", hash_original_field = "9A4AFD12A281DC13B83F1DA8EB1A62E2", hash_generated_field = "05F661AB7EBC422B7D80FDAA800AC894")

    public static final int GL_LUMINANCE_ALPHA                         = 0x190A;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.519 -0500", hash_original_field = "4B17FBB5AC887466065B1E91E5ACAB14", hash_generated_field = "B20FCFFE737F717A755866C24553F9C3")

    public static final int GL_UNSIGNED_SHORT_4_4_4_4                  = 0x8033;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.522 -0500", hash_original_field = "E8798CEEB1DAFC122C9E0A25BB290B0F", hash_generated_field = "C2FA2F9F63044337A428E6E10E6D2AFA")

    public static final int GL_UNSIGNED_SHORT_5_5_5_1                  = 0x8034;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.524 -0500", hash_original_field = "07A9F1ABC7D0EAB39B28F3E9DD79271F", hash_generated_field = "4C7D42068CD7D103E43E5E903CF95B76")

    public static final int GL_UNSIGNED_SHORT_5_6_5                    = 0x8363;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.527 -0500", hash_original_field = "D18A43C4DE383BDB7B48D536BAF562E4", hash_generated_field = "DFB96D996EEABFB9CCF2BAFC30F482F7")

    public static final int GL_FRAGMENT_SHADER                           = 0x8B30;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.530 -0500", hash_original_field = "31CC87457CE53940E730E32843D5A32F", hash_generated_field = "742E75B3C2E9DA0C645480394F12CD67")

    public static final int GL_VERTEX_SHADER                             = 0x8B31;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.532 -0500", hash_original_field = "57980586736C33E1C963AAB09217AF7C", hash_generated_field = "B6FC72374BFCEE9E0D09775E9FB3C888")

    public static final int GL_MAX_VERTEX_ATTRIBS                        = 0x8869;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.535 -0500", hash_original_field = "9184106B28AA19751BD924BC612FD80C", hash_generated_field = "C81AF6C51263FC6E99C5257587C2C78D")

    public static final int GL_MAX_VERTEX_UNIFORM_VECTORS                = 0x8DFB;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.537 -0500", hash_original_field = "F5BED9F2A0F8F3DC31C1B2AE561A19A7", hash_generated_field = "8069D3F4E358C4F2D8E08D955EA562D9")

    public static final int GL_MAX_VARYING_VECTORS                       = 0x8DFC;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.540 -0500", hash_original_field = "CB3E110C7705F6AF80446A835440FE43", hash_generated_field = "59EC03752244AF3DDF928E977A02E072")

    public static final int GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS          = 0x8B4D;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.543 -0500", hash_original_field = "37B0579B1E08E3CFA103ADB40829B736", hash_generated_field = "6714B71F415D42AF6570D4E76696FE70")

    public static final int GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS            = 0x8B4C;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.546 -0500", hash_original_field = "DCA87B78E93D1ED6F8028A46D7D73731", hash_generated_field = "B1BD9608C110C36D8685436853B834F7")

    public static final int GL_MAX_TEXTURE_IMAGE_UNITS                   = 0x8872;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.548 -0500", hash_original_field = "D5E1EB38AD354E5F32A9F98C3F48FB7F", hash_generated_field = "53D492D701A8AD909D2F0F45C0F4292F")

    public static final int GL_MAX_FRAGMENT_UNIFORM_VECTORS              = 0x8DFD;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.551 -0500", hash_original_field = "AA058C3F6410C2A2E7D8DF0ABE6FD893", hash_generated_field = "3EE0C5308ED4B368C49B468E15DF4498")

    public static final int GL_SHADER_TYPE                               = 0x8B4F;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.553 -0500", hash_original_field = "47CF80E8A8F6D6347EE14F805F95441B", hash_generated_field = "EDF95A293DF9F7FCCF00B93098264A9A")

    public static final int GL_DELETE_STATUS                             = 0x8B80;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.555 -0500", hash_original_field = "CEBC0CA0D00275CE009E73DDE2A92505", hash_generated_field = "573E11A0B1F99D640642993EE5EAE850")

    public static final int GL_LINK_STATUS                               = 0x8B82;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.558 -0500", hash_original_field = "166C4061D244E539B49627A130D679F9", hash_generated_field = "F8EF30E94ABB67A125539CEB07072333")

    public static final int GL_VALIDATE_STATUS                           = 0x8B83;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.560 -0500", hash_original_field = "E2B9ED6AA291EEE5608ED3BEA6B526E1", hash_generated_field = "69A29EC9CCB718D4E1887781A459F897")

    public static final int GL_ATTACHED_SHADERS                          = 0x8B85;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.563 -0500", hash_original_field = "B589B1258EE389E93D134BD060D47B76", hash_generated_field = "C3031F2A578AA7CD7A65367E731FDFAE")

    public static final int GL_ACTIVE_UNIFORMS                           = 0x8B86;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.565 -0500", hash_original_field = "72EA8B46905E2CEE27817E459179A9B4", hash_generated_field = "B198CAA111CE9D9C35CE2FE04190064C")

    public static final int GL_ACTIVE_UNIFORM_MAX_LENGTH                 = 0x8B87;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.568 -0500", hash_original_field = "8C099C4C2EA1FCA29F7F1E2E19D30433", hash_generated_field = "EB1F090B173F3D7A162F0122C843CFA6")

    public static final int GL_ACTIVE_ATTRIBUTES                         = 0x8B89;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.571 -0500", hash_original_field = "CCFCEB5BEDB17A563DC2920C58D422E6", hash_generated_field = "32CB6E2BDE968F3455895E8805311A2A")

    public static final int GL_ACTIVE_ATTRIBUTE_MAX_LENGTH               = 0x8B8A;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.574 -0500", hash_original_field = "B747ACCEE8F03DC6F7FA578FFA513CD8", hash_generated_field = "FC2E624E99E219FDE3F8C8B5AD7D798A")

    public static final int GL_SHADING_LANGUAGE_VERSION                  = 0x8B8C;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.576 -0500", hash_original_field = "B6022F6D0E1C1F44FD2B1197B7C77FA5", hash_generated_field = "B241BBA49E38740ABECD5F6D8E50947D")

    public static final int GL_CURRENT_PROGRAM                           = 0x8B8D;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.578 -0500", hash_original_field = "C1A2FFB66B994BA0851EFB1100DD7056", hash_generated_field = "CA379896EFAC1FCD285FDDEC471ED007")

    public static final int GL_NEVER                                   = 0x0200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.581 -0500", hash_original_field = "7414B764B67C5AFD49CD31BDE0E07442", hash_generated_field = "CF8C714644DB7D661F354ACA1832748C")

    public static final int GL_LESS                                    = 0x0201;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.583 -0500", hash_original_field = "42E44886009387D44E4669B9CDEAF7DC", hash_generated_field = "92F53098599AA2DBF61CD4CBFE1E1026")

    public static final int GL_EQUAL                                   = 0x0202;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.586 -0500", hash_original_field = "E71998529BCEFBBF0A0CD4EDC889BF82", hash_generated_field = "08E9588A524EB2187171C96E2FC84E53")

    public static final int GL_LEQUAL                                  = 0x0203;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.589 -0500", hash_original_field = "C372F824268DD69862545B39ED8E2AE3", hash_generated_field = "86527F04ED005A379DDE1E13CA42480F")

    public static final int GL_GREATER                                 = 0x0204;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.591 -0500", hash_original_field = "8ADA244D49A89E972D7719F3729D6A36", hash_generated_field = "9D163E05C29CDB049D5EFDCB69A11F5B")

    public static final int GL_NOTEQUAL                                = 0x0205;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.594 -0500", hash_original_field = "A5892DC0E79258334CEFDB0FB30B3475", hash_generated_field = "7B31CD8183BCDB86620F2670173470EB")

    public static final int GL_GEQUAL                                  = 0x0206;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.597 -0500", hash_original_field = "EDFD8F9549373DC77F00008A1399E35B", hash_generated_field = "EC3E764163C9D8D7002C124025DD7ECB")

    public static final int GL_ALWAYS                                  = 0x0207;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.599 -0500", hash_original_field = "1DF781C33EFBC997C5B580D81D7AE16F", hash_generated_field = "AC1B44CC8A8DFECDC32B181A188D5EC3")

    public static final int GL_KEEP                                    = 0x1E00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.601 -0500", hash_original_field = "78D992323043FA2D5A1F33048B1A6145", hash_generated_field = "7825B8439D0B67AC7D326B5C83947881")

    public static final int GL_REPLACE                                 = 0x1E01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.604 -0500", hash_original_field = "9761009C24B2BF0B42E22EA0006177AF", hash_generated_field = "043F85B707374E94709A8F7159F387E0")

    public static final int GL_INCR                                    = 0x1E02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.608 -0500", hash_original_field = "D2F20C84A1C919A9C558275594323D3F", hash_generated_field = "5315E9E453BD796C61A0AB06DD8E6A52")

    public static final int GL_DECR                                    = 0x1E03;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.610 -0500", hash_original_field = "D604842D4B662F65E7D15865473FDA4B", hash_generated_field = "891D64DE0F628EC3BD77CEA1FB2643A6")

    public static final int GL_INVERT                                  = 0x150A;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.612 -0500", hash_original_field = "10D39312ED266137D02FCC514B8F2E81", hash_generated_field = "58D823F537D18E7F3C79D65A5F268814")

    public static final int GL_INCR_WRAP                               = 0x8507;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.615 -0500", hash_original_field = "47FAB4C7F8F69B23F6AB6D5AA9005FB9", hash_generated_field = "377377DC71CB527956F4E62598C7B850")

    public static final int GL_DECR_WRAP                               = 0x8508;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.618 -0500", hash_original_field = "13292DA983E183437E9618E56CB5156B", hash_generated_field = "F31B958C8F10E182C79082E291A281D3")

    public static final int GL_VENDOR                                  = 0x1F00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.620 -0500", hash_original_field = "2CAB903AFB7E7259D70A8A2A9A531E3A", hash_generated_field = "9F902BB754AA320AF68CBD170F59FDF5")

    public static final int GL_RENDERER                                = 0x1F01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.622 -0500", hash_original_field = "51ADFA9DD0AD564D6D95836EAC7BAB1D", hash_generated_field = "ED8862F66460C23F886758F9B875895E")

    public static final int GL_VERSION                                 = 0x1F02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.625 -0500", hash_original_field = "74C2FA001A93BA23E7A55D9A0635CA87", hash_generated_field = "5B3583373834E1B16997BF3A95388EB2")

    public static final int GL_EXTENSIONS                              = 0x1F03;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.627 -0500", hash_original_field = "C977327F831E39C7AFE53D0F2597AE25", hash_generated_field = "B0FB6384C88C83EB4C1A4C10AA65E821")

    public static final int GL_NEAREST                                 = 0x2600;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.630 -0500", hash_original_field = "8997B1C0659E305F61EAA4CB5A592F0C", hash_generated_field = "7F86F6F1824D09F94648C12DD73CE3CD")

    public static final int GL_LINEAR                                  = 0x2601;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.633 -0500", hash_original_field = "92E8A86C0B0D56C39F6138FE785285B8", hash_generated_field = "A2ADEF4D1C78AA83F5B2352C8DBDC6E2")

    public static final int GL_NEAREST_MIPMAP_NEAREST                  = 0x2700;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.635 -0500", hash_original_field = "0EE84A6AB540681890D0FE6B0AB93549", hash_generated_field = "F99ADA5F5048826A006EABD5E713AD76")

    public static final int GL_LINEAR_MIPMAP_NEAREST                   = 0x2701;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.638 -0500", hash_original_field = "ED7976C7BA2505C53FE444F38C14E66D", hash_generated_field = "F0A2FA3AACBA4EA7BA158C2462E7D640")

    public static final int GL_NEAREST_MIPMAP_LINEAR                   = 0x2702;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.640 -0500", hash_original_field = "3773D8C88B54887BE91C8E1D880BE8B0", hash_generated_field = "EFC7F162A4792680BED3D106B21DC2A5")

    public static final int GL_LINEAR_MIPMAP_LINEAR                    = 0x2703;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.643 -0500", hash_original_field = "018E893F09D867497338F5D3F559C559", hash_generated_field = "0F8FE623FD8E0ED110006D791288A686")

    public static final int GL_TEXTURE_MAG_FILTER                      = 0x2800;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.645 -0500", hash_original_field = "EF69FF9691AE0660968EAF9E2C586876", hash_generated_field = "702299E7AFC47AA8D9BFCB1EE1AA1BAA")

    public static final int GL_TEXTURE_MIN_FILTER                      = 0x2801;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.648 -0500", hash_original_field = "1BDD8C1E472FCD5A3466D0A3D5344B15", hash_generated_field = "79FED79498C93220A14654ACE7E303EB")

    public static final int GL_TEXTURE_WRAP_S                          = 0x2802;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.651 -0500", hash_original_field = "33634015A2F3B3E75B62E4C9D0CD0BD3", hash_generated_field = "BA13CBAC042E1A4FD3E8BBA4033145DC")

    public static final int GL_TEXTURE_WRAP_T                          = 0x2803;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.654 -0500", hash_original_field = "3CD565265BBFE2ADC034B60B340B3D44", hash_generated_field = "D123EB9A72FA50D7D443B3DBF04FC9B1")

    public static final int GL_TEXTURE                                 = 0x1702;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.656 -0500", hash_original_field = "8E0DA218425EF647771D602FCA5D50D6", hash_generated_field = "C5B94F87C7F7091D714E618BFF874A1B")

    public static final int GL_TEXTURE_CUBE_MAP                        = 0x8513;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.659 -0500", hash_original_field = "B5A1EC6D83425CC09CBF7D9F697027C5", hash_generated_field = "7F5A12E4D58F030B256FA765A9073285")

    public static final int GL_TEXTURE_BINDING_CUBE_MAP                = 0x8514;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.662 -0500", hash_original_field = "CCCC8137D6F8910B1CA584B3C373D95E", hash_generated_field = "43380C95D61FA3716F133235A86132BC")

    public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_X             = 0x8515;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.664 -0500", hash_original_field = "9ED662E72ED0F43ECA2CBF16FE99E424", hash_generated_field = "07154BDBD6721FDD686965E54E50325D")

    public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_X             = 0x8516;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.667 -0500", hash_original_field = "F8B4E714A8D0AC912FAA3EF85969C13E", hash_generated_field = "EF75140F1E1C37785AFA91D59A7C333B")

    public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Y             = 0x8517;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.669 -0500", hash_original_field = "37CCA574502C50DDEA92F0AA1B8629C1", hash_generated_field = "62CC94418A851D43962F44C5B313F1E4")

    public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Y             = 0x8518;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.671 -0500", hash_original_field = "19C4213077AA2C261403EE9062A9324C", hash_generated_field = "EDB85454F5B1F42EC6A88BA603CAF693")

    public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Z             = 0x8519;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.674 -0500", hash_original_field = "4AFD13B2DCD5E2A12F0D9F1C21F8EC0A", hash_generated_field = "10688D512FFDBF21EC84E1FE35A6EF2E")

    public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Z             = 0x851A;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.677 -0500", hash_original_field = "BF8FEB908A3C4BF3133B17E260ABDEEF", hash_generated_field = "B84618CEAC51539AAA5334C833A515BA")

    public static final int GL_MAX_CUBE_MAP_TEXTURE_SIZE               = 0x851C;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.680 -0500", hash_original_field = "3DD490B50766608561B1A5126B7E164C", hash_generated_field = "BA0F4FF4C8B05303345E6F0BCE004F67")

    public static final int GL_TEXTURE0                                = 0x84C0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.682 -0500", hash_original_field = "CE139042B64D48C3A736BE08C34C5078", hash_generated_field = "6368F222D7BE49D35F9CAFE86DFDD44A")

    public static final int GL_TEXTURE1                                = 0x84C1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.685 -0500", hash_original_field = "A1FFB07863AF783CBEA187BE75C4830C", hash_generated_field = "F9606689F311997886F22F3B4A4D9951")

    public static final int GL_TEXTURE2                                = 0x84C2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.687 -0500", hash_original_field = "9B1517A010254159397F9D98E039CCFE", hash_generated_field = "EB7A66E482516BA8A83A2C0901AE9821")

    public static final int GL_TEXTURE3                                = 0x84C3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.690 -0500", hash_original_field = "C8CE09357BFA99CBB869E2C04B0CE04D", hash_generated_field = "8C3019ADB0DB73957332280BCB5C776D")

    public static final int GL_TEXTURE4                                = 0x84C4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.692 -0500", hash_original_field = "64E05661B12599CF1D039CAFE17C6496", hash_generated_field = "0ADC913BC5A636AC0043EEAB35B38ABE")

    public static final int GL_TEXTURE5                                = 0x84C5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.695 -0500", hash_original_field = "E6EED6A9DB08B1609B5B5BE8E577EC45", hash_generated_field = "B031ADC1DCEDC2622EBDBEE78D98E599")

    public static final int GL_TEXTURE6                                = 0x84C6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.697 -0500", hash_original_field = "AE875D1062C62848D29CFD4654E010FB", hash_generated_field = "F0C1EE436F2FA5C7CF66757834968528")

    public static final int GL_TEXTURE7                                = 0x84C7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.700 -0500", hash_original_field = "4841664708E9342C92BDD75CACB83BD7", hash_generated_field = "378DF8E3660EABD42DFAE32C9CC7F398")

    public static final int GL_TEXTURE8                                = 0x84C8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.702 -0500", hash_original_field = "F439487211CB1DE1289F3E725BDC695C", hash_generated_field = "3C3FCB1A67F035913B43C79D2D75D872")

    public static final int GL_TEXTURE9                                = 0x84C9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.705 -0500", hash_original_field = "056426FE6B11B6F7F5243EDEE3A22A28", hash_generated_field = "776A57758332051D1D11DFE46DC41B12")

    public static final int GL_TEXTURE10                               = 0x84CA;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.708 -0500", hash_original_field = "D3A7A1F3EBBF3F51E4DD70BAFF59B6A8", hash_generated_field = "96905C885C6A888FEFF76AC4318D88E0")

    public static final int GL_TEXTURE11                               = 0x84CB;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.710 -0500", hash_original_field = "CA78B1F28279F7148C43C1F7C2B933CE", hash_generated_field = "E53F5986F1DCA42B824D147FF7D61D0C")

    public static final int GL_TEXTURE12                               = 0x84CC;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.713 -0500", hash_original_field = "615B7F2AE9070E41D72D63D523FA04B3", hash_generated_field = "D736272A012DC1B2C7D4F2075A10371A")

    public static final int GL_TEXTURE13                               = 0x84CD;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.715 -0500", hash_original_field = "5BFDE30A56CAE7E8751F0C7FB3E334D8", hash_generated_field = "A5B1A8D739FEE7A61A47B638606088EA")

    public static final int GL_TEXTURE14                               = 0x84CE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.717 -0500", hash_original_field = "91F9568852C6EA6DD00A36F58B59FF4F", hash_generated_field = "2D1B4D0A36141BF734DC607A7894592F")

    public static final int GL_TEXTURE15                               = 0x84CF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.721 -0500", hash_original_field = "165AB6DCF9BD3B4952B7CE99C98B8601", hash_generated_field = "0FAE9C9EBBAA9BF0C721E851AF3EDE0D")

    public static final int GL_TEXTURE16                               = 0x84D0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.723 -0500", hash_original_field = "4B13CD2C75FDED6B6C59E69AA9532281", hash_generated_field = "C0ACBBDC95FC99E0E86F764F882B7F88")

    public static final int GL_TEXTURE17                               = 0x84D1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.726 -0500", hash_original_field = "C3E91C036291AFED32E619B284F10514", hash_generated_field = "B5B5A27665F1BB7E1FEDCA77A03AA883")

    public static final int GL_TEXTURE18                               = 0x84D2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.729 -0500", hash_original_field = "077652260DB6E8270D799A538FA58309", hash_generated_field = "99C75295F9DE85B97D0A81F7CA5EA203")

    public static final int GL_TEXTURE19                               = 0x84D3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.731 -0500", hash_original_field = "1E1CD4E45FDDB569893FC9A22F384A66", hash_generated_field = "CD24AFB64E44A02D63932BE13470E6AA")

    public static final int GL_TEXTURE20                               = 0x84D4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.734 -0500", hash_original_field = "8637A19E20509056DCBB22D3ED4B01A9", hash_generated_field = "E82035766A7DC3AC3F6B37809B251C21")

    public static final int GL_TEXTURE21                               = 0x84D5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.736 -0500", hash_original_field = "CFDB09C55A24B0460CB480E21813B5BA", hash_generated_field = "BD518C3B1A0B2D9E43F6B7C2A20DFE2F")

    public static final int GL_TEXTURE22                               = 0x84D6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.739 -0500", hash_original_field = "9C6DB8E9450D3E857DF99080E4F12DCC", hash_generated_field = "E51DAC73DF5C45484DA3FB37491A0EE5")

    public static final int GL_TEXTURE23                               = 0x84D7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.741 -0500", hash_original_field = "B7DF0F962D833D5612BE9C7709606CF4", hash_generated_field = "B22E032B85EB699368B06AC87FE2B898")

    public static final int GL_TEXTURE24                               = 0x84D8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.744 -0500", hash_original_field = "C5932B6B2F972096BFCEB2894F80947B", hash_generated_field = "B8105530A28A057AD49118429901D7B6")

    public static final int GL_TEXTURE25                               = 0x84D9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.746 -0500", hash_original_field = "1B9A610CEE2E503141D47440146970B9", hash_generated_field = "4B11DEEFAF68B9BB74AC3A4FBDF965FF")

    public static final int GL_TEXTURE26                               = 0x84DA;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.748 -0500", hash_original_field = "6165DCBFD82F3EDE8C32846E59F25296", hash_generated_field = "02DEAA70ADF70018857298DDA1032C62")

    public static final int GL_TEXTURE27                               = 0x84DB;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.752 -0500", hash_original_field = "B282F75862E10CB6011BAAB5E8F0A4CD", hash_generated_field = "165C9ED7F06E643264EE9C4A9240B619")

    public static final int GL_TEXTURE28                               = 0x84DC;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.755 -0500", hash_original_field = "877611DA02271209594534FB1593287B", hash_generated_field = "6F3D9C17432273490A88EAA2FBA96C4E")

    public static final int GL_TEXTURE29                               = 0x84DD;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.757 -0500", hash_original_field = "FB650C88AC32AF7163DA924005799716", hash_generated_field = "01235E8CF92D5BA414CDD25B6604F79E")

    public static final int GL_TEXTURE30                               = 0x84DE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.760 -0500", hash_original_field = "774CA161FAB678EA83105708EAEB0DA7", hash_generated_field = "C8151127B3E9F7F60F918EEFDAFCC4BD")

    public static final int GL_TEXTURE31                               = 0x84DF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.763 -0500", hash_original_field = "FBE41B699F250F3B67045411FE37C16D", hash_generated_field = "0D42C554C0527A3A4F6ED53657A8F36A")

    public static final int GL_REPEAT                                  = 0x2901;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.766 -0500", hash_original_field = "857519BF45989933C8294B74805A89C8", hash_generated_field = "F4270B23DBE6E082C9F3F938AAE90031")

    public static final int GL_CLAMP_TO_EDGE                           = 0x812F;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.768 -0500", hash_original_field = "EC612706138569A75798DA1705096443", hash_generated_field = "1AA9A71612BBC2EB1A057F7B2F560C01")

    public static final int GL_MIRRORED_REPEAT                         = 0x8370;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.771 -0500", hash_original_field = "72E95A8650D1AA1C4BEA2E312901CB48", hash_generated_field = "D4F6E6C3CC7869488B1078BE957B9855")

    public static final int GL_FLOAT_VEC2                              = 0x8B50;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.773 -0500", hash_original_field = "C371BFE3D952D3F27743441176119656", hash_generated_field = "4596CFDCADBD518B4A0CEBF25197C285")

    public static final int GL_FLOAT_VEC3                              = 0x8B51;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.776 -0500", hash_original_field = "BC4CC5B66023831B0D23F7407B8A8260", hash_generated_field = "D513EDE3FBDAF53F150324407F54BEA2")

    public static final int GL_FLOAT_VEC4                              = 0x8B52;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.778 -0500", hash_original_field = "AC6DD9140ACB4123200257F790C0077C", hash_generated_field = "8272459B4C9F6934811DA22F03948AE0")

    public static final int GL_INT_VEC2                                = 0x8B53;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.781 -0500", hash_original_field = "3086636C57E2E502758BB1C5F288CE74", hash_generated_field = "42DD6770CF816C99003F923139114972")

    public static final int GL_INT_VEC3                                = 0x8B54;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.784 -0500", hash_original_field = "144B6E073C40A4E6006ADE685D63A3C2", hash_generated_field = "C98FB2BBE4B199F6345C8BB9E3F290AB")

    public static final int GL_INT_VEC4                                = 0x8B55;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.786 -0500", hash_original_field = "63C2C5E414E124DCFB580D335FF7B3FC", hash_generated_field = "0F6051A9131131DB773BBB2973C1AD76")

    public static final int GL_BOOL                                    = 0x8B56;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.788 -0500", hash_original_field = "3FCC64D9639DD73BD40DB3FCC11C135A", hash_generated_field = "3BA741C59E6EFAB0009C4B540ABDBEFB")

    public static final int GL_BOOL_VEC2                               = 0x8B57;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.791 -0500", hash_original_field = "7803ABFE4C4CF4B8E14025A73C55652B", hash_generated_field = "66A648E5348DB6AB126F90CD0089F32C")

    public static final int GL_BOOL_VEC3                               = 0x8B58;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.793 -0500", hash_original_field = "D649D32ACB4EA495C1C5B240F0EA4918", hash_generated_field = "F149F7223B4F530AAB8367B3AE0A1CF4")

    public static final int GL_BOOL_VEC4                               = 0x8B59;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.796 -0500", hash_original_field = "1489D4656FC7225533B86DC200888E83", hash_generated_field = "C8670E53BF4D877ED387C1919F866D21")

    public static final int GL_FLOAT_MAT2                              = 0x8B5A;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.798 -0500", hash_original_field = "A613E8E0205AA09B158AA2F543104453", hash_generated_field = "83C24799B8C579DA33B7A210722F1E79")

    public static final int GL_FLOAT_MAT3                              = 0x8B5B;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.801 -0500", hash_original_field = "832F971BEF7A42A612D6AAF0CDDA9C31", hash_generated_field = "74986626AB3DB4BE4412BA930C6CC599")

    public static final int GL_FLOAT_MAT4                              = 0x8B5C;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.803 -0500", hash_original_field = "DB17A2B4384F21E77C4CDC1F966D9685", hash_generated_field = "91C33DA2785847FB7931407B7D701133")

    public static final int GL_SAMPLER_2D                              = 0x8B5E;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.806 -0500", hash_original_field = "4F0E3A07172B52DFC911AE21DDCE9BBC", hash_generated_field = "2D095C42DD6ACDABB067E994CB09DA00")

    public static final int GL_SAMPLER_CUBE                            = 0x8B60;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.809 -0500", hash_original_field = "259048B7FF977C8DD0FBE275FB3BE0D3", hash_generated_field = "7BA48C0379FE3B243BFEC33E61715DEE")

    public static final int GL_VERTEX_ATTRIB_ARRAY_ENABLED                 = 0x8622;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.811 -0500", hash_original_field = "51E5A56D2D6CA22064EC6A71C28B9167", hash_generated_field = "9AA759A0E120AC1B42289AD7ED24664C")

    public static final int GL_VERTEX_ATTRIB_ARRAY_SIZE                    = 0x8623;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.814 -0500", hash_original_field = "35D72EF0E86FBC21FD3DDEE780FB18FC", hash_generated_field = "3633EC14E4432B421044804FAE07E86C")

    public static final int GL_VERTEX_ATTRIB_ARRAY_STRIDE                  = 0x8624;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.816 -0500", hash_original_field = "A0F935B2AE5A03FA54F681BB585FBA39", hash_generated_field = "5478CC37CB4E66292AD0A8105F5DF6CE")

    public static final int GL_VERTEX_ATTRIB_ARRAY_TYPE                    = 0x8625;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.819 -0500", hash_original_field = "1B63E1E912CE7D2CFCB1F75A6B721AC5", hash_generated_field = "B514D95E4733BDA7BD5AD2935F382E0F")

    public static final int GL_VERTEX_ATTRIB_ARRAY_NORMALIZED              = 0x886A;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.822 -0500", hash_original_field = "DA01345B63E3B585E1E60C1AD8B68476", hash_generated_field = "1420777BF9FB6EB437C4E11B8E3A5D32")

    public static final int GL_VERTEX_ATTRIB_ARRAY_POINTER                 = 0x8645;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.825 -0500", hash_original_field = "1E3045E52CBCA5CA1670FC7DF98E05DC", hash_generated_field = "DEA06FFD8284EC03552D7E15088F4E09")

    public static final int GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING          = 0x889F;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.828 -0500", hash_original_field = "A0B9A787E6DFDDD70536293EEAD6E89A", hash_generated_field = "EE64262F12B8BD3E65560660094FFCC2")

    public static final int GL_IMPLEMENTATION_COLOR_READ_TYPE            = 0x8B9A;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.830 -0500", hash_original_field = "C5FC465F4B66D653259850C4F348AD3B", hash_generated_field = "838B9962B2D1332F46FFA23E5542F508")

    public static final int GL_IMPLEMENTATION_COLOR_READ_FORMAT          = 0x8B9B;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.833 -0500", hash_original_field = "5A97FB964032A75D3F4221ECC751A7F4", hash_generated_field = "9F41E039736AABEFE1A573BC5BBD5695")

    public static final int GL_COMPILE_STATUS                          = 0x8B81;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.835 -0500", hash_original_field = "CEEC4834EA498DAD79BDB7C07374671F", hash_generated_field = "E03BE42CFFC8CAC4578CDA8454531223")

    public static final int GL_INFO_LOG_LENGTH                         = 0x8B84;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.838 -0500", hash_original_field = "98E84EFA219F1AA6450423C3810F35D1", hash_generated_field = "6DDD1F189FB16E97384CFC954B069C1B")

    public static final int GL_SHADER_SOURCE_LENGTH                    = 0x8B88;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.842 -0500", hash_original_field = "F092BCFC22C3335FFF0441394CD35282", hash_generated_field = "F8085B8FA2A40E62A7A7564602688991")

    public static final int GL_SHADER_COMPILER                         = 0x8DFA;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.844 -0500", hash_original_field = "7AB139C4906C9A6539A2DC5B55B21923", hash_generated_field = "271E6BDD652F6762D928C8F3B4469F48")

    public static final int GL_SHADER_BINARY_FORMATS                   = 0x8DF8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.847 -0500", hash_original_field = "B965905006F0235CDA43899427996A5E", hash_generated_field = "66C70D901C57CD92EEB78E8C290A5D45")

    public static final int GL_NUM_SHADER_BINARY_FORMATS               = 0x8DF9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.850 -0500", hash_original_field = "279DC0ABF83B41D32FFF1A6942093E34", hash_generated_field = "BD5BD53920B23FAD2E8F7DD65EDDB6CC")

    public static final int GL_LOW_FLOAT                               = 0x8DF0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.853 -0500", hash_original_field = "6F4159C6F9ADABB3705DC57C928FE399", hash_generated_field = "94BE1C0FE932CFCE28F672B92B143981")

    public static final int GL_MEDIUM_FLOAT                            = 0x8DF1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.855 -0500", hash_original_field = "0DFD38E306BFF6D75684BD0C5AC2AFAB", hash_generated_field = "41417F8914E0ECE1B7EB2CF58E55CD24")

    public static final int GL_HIGH_FLOAT                              = 0x8DF2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.858 -0500", hash_original_field = "CED4EB5CE17FA37299348882C91DF75F", hash_generated_field = "E2FAB47609BD087C1A6D4A8D66747366")

    public static final int GL_LOW_INT                                 = 0x8DF3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.860 -0500", hash_original_field = "0485C2CC2E51F3913771BE1DE6D36138", hash_generated_field = "A79469BB2D72F8E59B1AAD1E59F50103")

    public static final int GL_MEDIUM_INT                              = 0x8DF4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.863 -0500", hash_original_field = "D36F91B9BC53440CC1F29F67899E6189", hash_generated_field = "7E13FD38818174F274AACF552685115D")

    public static final int GL_HIGH_INT                                = 0x8DF5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.865 -0500", hash_original_field = "AEB31F2D8FCF1F3329A359AB4E84D8CC", hash_generated_field = "C0FA865008C29096F291EFA49891FCDE")

    public static final int GL_FRAMEBUFFER                             = 0x8D40;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.869 -0500", hash_original_field = "9F682A27D8F1E11D73EDEB40626878B2", hash_generated_field = "34F15D62A50F317EDEECEF55FC8CD378")

    public static final int GL_RENDERBUFFER                            = 0x8D41;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.872 -0500", hash_original_field = "D0F737BBE20E9123880DADC09CD6956B", hash_generated_field = "F1E976B161BD16A999C5EE1E1F0CF686")

    public static final int GL_RGBA4                                   = 0x8056;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.874 -0500", hash_original_field = "6534A245CCEF54A9A3BAB14FC0B90199", hash_generated_field = "4B46C174836B400D904CAE12C46CDCD6")

    public static final int GL_RGB5_A1                                 = 0x8057;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.876 -0500", hash_original_field = "DC81467EE2C299AF0689F5C64129CE9A", hash_generated_field = "920663D50953507C6C8FC97361EE76A5")

    public static final int GL_RGB565                                  = 0x8D62;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.878 -0500", hash_original_field = "167547A5FFF830C9B8056A9C56AB6947", hash_generated_field = "DA33D949DEC63FA48CC4A0DBBF0FD14E")

    public static final int GL_DEPTH_COMPONENT16                       = 0x81A5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.881 -0500", hash_original_field = "D5F4DFE6964DDE32549D46A3E05453FC", hash_generated_field = "2343847FF61B3FEC316821DE195C2A31")

    public static final int GL_STENCIL_INDEX                           = 0x1901;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.883 -0500", hash_original_field = "9C59FE6274FA7AFEED4B6C2D918809FE", hash_generated_field = "D5B4DB8CCB87B2981298CB5A38127535")

    public static final int GL_STENCIL_INDEX8                          = 0x8D48;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.886 -0500", hash_original_field = "788E1FF0C7A0769514A9C9ABDB6CEC5E", hash_generated_field = "75864392B783E085A4CFF6EB00C10359")

    public static final int GL_RENDERBUFFER_WIDTH                      = 0x8D42;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.889 -0500", hash_original_field = "877784ACDD3F7BFB73442D725C87073B", hash_generated_field = "36D4AEE42CF64175E814E979A92E4EDF")

    public static final int GL_RENDERBUFFER_HEIGHT                     = 0x8D43;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.892 -0500", hash_original_field = "9E0EC22D8BF943732265771D00F7210A", hash_generated_field = "E578E6ABBD143F5ACEFD8B86FB529F28")

    public static final int GL_RENDERBUFFER_INTERNAL_FORMAT            = 0x8D44;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.894 -0500", hash_original_field = "B6086AA972A2748918C724BABA8ED7C1", hash_generated_field = "3BE75E97AE116A9CF526572E5032F95C")

    public static final int GL_RENDERBUFFER_RED_SIZE                   = 0x8D50;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.897 -0500", hash_original_field = "49F8B74FB1A36A69A602A5F85BBF69F6", hash_generated_field = "D76A65CB3EC52B363F8E42E7F644DA18")

    public static final int GL_RENDERBUFFER_GREEN_SIZE                 = 0x8D51;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.900 -0500", hash_original_field = "0C5E558453D0B70918CE873EBC7C552C", hash_generated_field = "0B4D267B9FA24858FADE43F0A33A6D61")

    public static final int GL_RENDERBUFFER_BLUE_SIZE                  = 0x8D52;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.902 -0500", hash_original_field = "B140B0E24938F0151E6A62291C2A12A9", hash_generated_field = "A87E3AB9C3F684A849790959B5AFC9B2")

    public static final int GL_RENDERBUFFER_ALPHA_SIZE                 = 0x8D53;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.924 -0500", hash_original_field = "9B1029CE2F63940F99563DF8878A06E5", hash_generated_field = "4A61F358C6F6474925F129C155859795")

    public static final int GL_RENDERBUFFER_DEPTH_SIZE                 = 0x8D54;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.927 -0500", hash_original_field = "66864DCB467634684F3B0743199B9265", hash_generated_field = "6CF3B82492F8006AE36F9C01135C5290")

    public static final int GL_RENDERBUFFER_STENCIL_SIZE               = 0x8D55;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.930 -0500", hash_original_field = "A95A3D92FE22AB66D34B59E4E6D62DF6", hash_generated_field = "D639E10A395D0273D3E79301FBC52FCD")

    public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE      = 0x8CD0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.933 -0500", hash_original_field = "D9E6094991697F477F16442DD87C132F", hash_generated_field = "6DBFC82CA13D6EC2F8A368E347F54544")

    public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME      = 0x8CD1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.935 -0500", hash_original_field = "18DCBF1421F692EE5193613B2DFBF27D", hash_generated_field = "B7E17CBFB0AF5284769AD4D30028C0BC")

    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL    = 0x8CD2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.939 -0500", hash_original_field = "946541B1A4A45BC819D835160BCAF3DF", hash_generated_field = "7E7D65BB9DE23F1EE30EFDFDB79DEC8B")

    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE = 0x8CD3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.942 -0500", hash_original_field = "9F82A099A605DACDDE28F8BAFC56CB93", hash_generated_field = "1841ED5A213CE867A8922E41D552AB3C")

    public static final int GL_COLOR_ATTACHMENT0                       = 0x8CE0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.944 -0500", hash_original_field = "A0456AAE5036EFE8C5409F7523CC64B4", hash_generated_field = "7FFD97E4ED3AA778308B5DC5E4C58C93")

    public static final int GL_DEPTH_ATTACHMENT                        = 0x8D00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.948 -0500", hash_original_field = "C080ACC44D232AEE2EE0D3496A33F69A", hash_generated_field = "D1B192D07DA81762E4DD838197524765")

    public static final int GL_STENCIL_ATTACHMENT                      = 0x8D20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.952 -0500", hash_original_field = "5E23B56DAC95EA94273B21C925780E32", hash_generated_field = "573A426131903C8A701C32864565E60B")

    public static final int GL_NONE                                    = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.956 -0500", hash_original_field = "4FCDDEC0033FC95AB035473B8CA98EC4", hash_generated_field = "105CAF398E8B836BE20034169C8F9BA2")

    public static final int GL_FRAMEBUFFER_COMPLETE                    = 0x8CD5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.960 -0500", hash_original_field = "9D269177FBC3D491CA882BD94F9622A1", hash_generated_field = "6020412D1FB2D2C42528245C0E277D7B")

    public static final int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT       = 0x8CD6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.963 -0500", hash_original_field = "C115F85C768132B2E1F6281E7B8D3F8D", hash_generated_field = "A779BA675B1FD53D3331DA67A0B4A4EF")

    public static final int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT          = 0x8CD7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.966 -0500", hash_original_field = "4E98932110A0F01819DB9030E7B8F745", hash_generated_field = "FD5AD67D44E5E92889277573D8F6098F")

    public static final int GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS       = 0x8CD9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.968 -0500", hash_original_field = "8A00BDAEFB2E440280F6626580D7926B", hash_generated_field = "C959FE19D0D108FEA8CE34EE498DAE74")

    public static final int GL_FRAMEBUFFER_UNSUPPORTED                 = 0x8CDD;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.972 -0500", hash_original_field = "18E26BFEA8F395AF9FA8B5DCAD06DED8", hash_generated_field = "50598C7C9FB2D0FDAAB2295022EE9788")

    public static final int GL_FRAMEBUFFER_BINDING                     = 0x8CA6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.974 -0500", hash_original_field = "E94ECFB38F90B2F8322E581CDE6ABA6C", hash_generated_field = "D8F98CCCC88EDDD662E4F18B953CA78A")

    public static final int GL_RENDERBUFFER_BINDING                    = 0x8CA7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.978 -0500", hash_original_field = "1A60E9DE469A0CB7BAA11576F30ED95C", hash_generated_field = "4CA7363BD58B00F29CA855F161E8BF6F")

    public static final int GL_MAX_RENDERBUFFER_SIZE                   = 0x84E8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:11.981 -0500", hash_original_field = "39F0FF889044D8C9113411F40CA206C0", hash_generated_field = "B1140C120DA2B82895757FDB24797CC0")

    public static final int GL_INVALID_FRAMEBUFFER_OPERATION           = 0x0506;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:24.093 -0400", hash_original_method = "36E20589EECCDD2982BE507DDB6EF4A3", hash_generated_method = "36E20589EECCDD2982BE507DDB6EF4A3")
    public GLES20 ()
    {
        //Synthesized constructor
    }
    static {
	    _nativeClassInit();
    }
    
}

