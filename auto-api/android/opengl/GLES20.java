package android.opengl;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class GLES20 {

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.537 -0400", hash_original_method = "36E20589EECCDD2982BE507DDB6EF4A3", hash_generated_method = "36E20589EECCDD2982BE507DDB6EF4A3")
	public GLES20() {
		
	}

	private static void _nativeClassInit() {
	}

	public static void glActiveTexture(int texture) {
	}

	public static void glAttachShader(int program, int shader) {
	}

	public static void glBindAttribLocation(int program, int index, String name) {
	}

	public static void glBindBuffer(int target, int buffer) {
	}

	public static void glBindFramebuffer(int target, int framebuffer) {
	}

	public static void glBindRenderbuffer(int target, int renderbuffer) {
	}

	public static void glBindTexture(int target, int texture) {
	}

	public static void glBlendColor(float red, float green, float blue, float alpha) {
	}

	public static void glBlendEquation(int mode) {
	}

	public static void glBlendEquationSeparate(int modeRGB, int modeAlpha) {
	}

	public static void glBlendFunc(int sfactor, int dfactor) {
	}

	public static void glBlendFuncSeparate(int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
	}

	public static void glBufferData(int target, int size, java.nio.Buffer data, int usage) {
	}

	public static void glBufferSubData(int target, int offset, int size, java.nio.Buffer data) {
	}

	public static int glCheckFramebufferStatus(int target) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2143838249 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2143838249;
	}

	public static void glClear(int mask) {
	}

	public static void glClearColor(float red, float green, float blue, float alpha) {
	}

	public static void glClearDepthf(float depth) {
	}

	public static void glClearStencil(int s) {
	}

	public static void glColorMask(boolean red, boolean green, boolean blue, boolean alpha) {
	}

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

	public static int glCreateProgram() {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_519833282 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_519833282;
	}

	public static int glCreateShader(int type) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1748292391 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1748292391;
	}

	public static void glCullFace(int mode) {
	}

	public static void glDeleteBuffers(int n, int[] buffers, int offset) {
	}

	public static void glDeleteBuffers(int n, java.nio.IntBuffer buffers) {
	}

	public static void glDeleteFramebuffers(int n, int[] framebuffers, int offset) {
	}

	public static void glDeleteFramebuffers(int n, java.nio.IntBuffer framebuffers) {
	}

	public static void glDeleteProgram(int program) {
	}

	public static void glDeleteRenderbuffers(int n, int[] renderbuffers, int offset) {
	}

	public static void glDeleteRenderbuffers(int n, java.nio.IntBuffer renderbuffers) {
	}

	public static void glDeleteShader(int shader) {
	}

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

	public static void glDisable(int cap) {
	}

	public static void glDisableVertexAttribArray(int index) {
	}

	public static void glDrawArrays(int mode, int first, int count) {
	}

	public static void glDrawElements(int mode, int count, int type, int offset) {
	}

	public static void glDrawElements(int mode, int count, int type, java.nio.Buffer indices) {
	}

	public static void glEnable(int cap) {
	}

	public static void glEnableVertexAttribArray(int index) {
	}

	public static void glFinish() {
	}

	public static void glFlush() {
	}

	public static void glFramebufferRenderbuffer(int target, int attachment, int renderbuffertarget, int renderbuffer) {
	}

	public static void glFramebufferTexture2D(int target, int attachment, int textarget, int texture, int level) {
	}

	public static void glFrontFace(int mode) {
	}

	public static void glGenBuffers(int n, int[] buffers, int offset) {
	}

	public static void glGenBuffers(int n, java.nio.IntBuffer buffers) {
	}

	public static void glGenerateMipmap(int target) {
	}

	public static void glGenFramebuffers(int n, int[] framebuffers, int offset) {
	}

	public static void glGenFramebuffers(int n, java.nio.IntBuffer framebuffers) {
	}

	public static void glGenRenderbuffers(int n, int[] renderbuffers, int offset) {
	}

	public static void glGenRenderbuffers(int n, java.nio.IntBuffer renderbuffers) {
	}

	public static void glGenTextures(int n, int[] textures, int offset) {
	}

	public static void glGenTextures(int n, java.nio.IntBuffer textures) {
	}

	public static void glGetActiveAttrib(int program, int index, int bufsize, int[] length, int lengthOffset, int[] size, int sizeOffset, int[] type, int typeOffset, byte[] name,
			int nameOffset) {
	}

	public static void glGetActiveAttrib(int program, int index, int bufsize, java.nio.IntBuffer length, java.nio.IntBuffer size, java.nio.IntBuffer type, byte name) {
	}

	public static void glGetActiveUniform(int program, int index, int bufsize, int[] length, int lengthOffset, int[] size, int sizeOffset, int[] type, int typeOffset, byte[] name,
			int nameOffset) {
	}

	public static void glGetActiveUniform(int program, int index, int bufsize, java.nio.IntBuffer length, java.nio.IntBuffer size, java.nio.IntBuffer type, byte name) {
	}

	public static void glGetAttachedShaders(int program, int maxcount, int[] count, int countOffset, int[] shaders, int shadersOffset) {
	}

	public static void glGetAttachedShaders(int program, int maxcount, java.nio.IntBuffer count, java.nio.IntBuffer shaders) {
	}

	public static int glGetAttribLocation(int program, String name) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1250723517 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1250723517;
	}

	public static void glGetBooleanv(int pname, boolean[] params, int offset) {
	}

	public static void glGetBooleanv(int pname, java.nio.IntBuffer params) {
	}

	public static void glGetBufferParameteriv(int target, int pname, int[] params, int offset) {
	}

	public static void glGetBufferParameteriv(int target, int pname, java.nio.IntBuffer params) {
	}

	public static int glGetError() {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_117972472 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_117972472;
	}

	public static void glGetFloatv(int pname, float[] params, int offset) {
	}

	public static void glGetFloatv(int pname, java.nio.FloatBuffer params) {
	}

	public static void glGetFramebufferAttachmentParameteriv(int target, int attachment, int pname, int[] params, int offset) {
	}

	public static void glGetFramebufferAttachmentParameteriv(int target, int attachment, int pname, java.nio.IntBuffer params) {
	}

	public static void glGetIntegerv(int pname, int[] params, int offset) {
	}

	public static void glGetIntegerv(int pname, java.nio.IntBuffer params) {
	}

	public static void glGetProgramiv(int program, int pname, int[] params, int offset) {
	}

	public static void glGetProgramiv(int program, int pname, java.nio.IntBuffer params) {
	}

	public static String glGetProgramInfoLog(int program) {
		return new String();
	}

	public static void glGetRenderbufferParameteriv(int target, int pname, int[] params, int offset) {
	}

	public static void glGetRenderbufferParameteriv(int target, int pname, java.nio.IntBuffer params) {
	}

	public static void glGetShaderiv(int shader, int pname, int[] params, int offset) {
	}

	public static void glGetShaderiv(int shader, int pname, java.nio.IntBuffer params) {
	}

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

	public static int glGetUniformLocation(int program, String name) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_214476555 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_214476555;
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
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_153268133 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_153268133;
	}

	public static boolean glIsEnabled(int cap) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1843616081 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1843616081;
	}

	public static boolean glIsFramebuffer(int framebuffer) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_110434919 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_110434919;
	}

	public static boolean glIsProgram(int program) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1073646847 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1073646847;
	}

	public static boolean glIsRenderbuffer(int renderbuffer) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_736306196 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_736306196;
	}

	public static boolean glIsShader(int shader) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_504045245 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_504045245;
	}

	public static boolean glIsTexture(int texture) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1683324650 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1683324650;
	}

	public static void glLineWidth(float width) {
	}

	public static void glLinkProgram(int program) {
	}

	public static void glPixelStorei(int pname, int param) {
	}

	public static void glPolygonOffset(float factor, float units) {
	}

	public static void glReadPixels(int x, int y, int width, int height, int format, int type, java.nio.Buffer pixels) {
	}

	public static void glReleaseShaderCompiler() {
	}

	public static void glRenderbufferStorage(int target, int internalformat, int width, int height) {
	}

	public static void glSampleCoverage(float value, boolean invert) {
	}

	public static void glScissor(int x, int y, int width, int height) {
	}

	public static void glShaderBinary(int n, int[] shaders, int offset, int binaryformat, java.nio.Buffer binary, int length) {
	}

	public static void glShaderBinary(int n, java.nio.IntBuffer shaders, int binaryformat, java.nio.Buffer binary, int length) {
	}

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

	public static void glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, java.nio.Buffer pixels) {
	}

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

	public static void glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, java.nio.Buffer pixels) {
	}

	public static void glUniform1f(int location, float x) {
	}

	public static void glUniform1fv(int location, int count, float[] v, int offset) {
	}

	public static void glUniform1fv(int location, int count, java.nio.FloatBuffer v) {
	}

	public static void glUniform1i(int location, int x) {
	}

	public static void glUniform1iv(int location, int count, int[] v, int offset) {
	}

	public static void glUniform1iv(int location, int count, java.nio.IntBuffer v) {
	}

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

	public static void glUniformMatrix4fv(int location, int count, boolean transpose, float[] value, int offset) {
	}

	public static void glUniformMatrix4fv(int location, int count, boolean transpose, java.nio.FloatBuffer value) {
	}

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

	public static void glVertexAttribPointer(int indx, int size, int type, boolean normalized, int stride, int offset) {
	}

	private static void glVertexAttribPointerBounds(int indx, int size, int type, boolean normalized, int stride, java.nio.Buffer ptr, int remaining) {
	}

	public static void glVertexAttribPointer(int indx, int size, int type, boolean normalized, int stride, java.nio.Buffer ptr) {
		glVertexAttribPointerBounds(indx, size, type, normalized, stride, ptr, ptr.remaining());
	}

	public static void glViewport(int x, int y, int width, int height) {
	}

	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.569 -0400", hash_original_field = "1F05769CEBD50660050E53C9A92701F1", hash_generated_field = "43604D5B9BADECF82E5DC08A6A6E973D")
	public static final int GL_ACTIVE_TEXTURE = 0x84E0;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "C5437F0A38DF339939F8ADBFCEF73021", hash_generated_field = "825F9100DD8C652E13E98054D7F396F6")
	public static final int GL_DEPTH_BUFFER_BIT = 0x00000100;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "96E26B72A7887F97CF8D9FA1AD3FA3BC", hash_generated_field = "51F465DFDA22B261A43355734F1B08CA")
	public static final int GL_STENCIL_BUFFER_BIT = 0x00000400;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "DDBCEDDE0AD8F926F233DCF38A56B032", hash_generated_field = "ADC58C4A25500D2F22EC3873A7230F2B")
	public static final int GL_COLOR_BUFFER_BIT = 0x00004000;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "DD5A8B322A9E17F757C1D341FB599153", hash_generated_field = "EC3A3073EC7FF4A46704A9ED43C9E386")
	public static final int GL_FALSE = 0;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "B01F68C6C3BB3B207C4B4E485AAD1606", hash_generated_field = "61D712C997F883C5E54B2F3515C8B065")
	public static final int GL_TRUE = 1;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "A0DEAB85678856F70C3551801F4F9F05", hash_generated_field = "3AEB111123D4B87DB7AFE0BBC7526140")
	public static final int GL_POINTS = 0x0000;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "BCDFF039A4042EEF6936526A8879077D", hash_generated_field = "40A33BDBD75619099109C07E3630DD5F")
	public static final int GL_LINES = 0x0001;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "94AD50A68E3E65CA901AC83533C0E567", hash_generated_field = "952CBB2FE89C544168C9BA35CC4CC48B")
	public static final int GL_LINE_LOOP = 0x0002;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "09A0067EF551BDB2E2F5307DBA3224F6", hash_generated_field = "40BBE33B8608A6DBB9A295EBCE625672")
	public static final int GL_LINE_STRIP = 0x0003;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "49C90D0A56EDD50EFC7AE8F554C87FFD", hash_generated_field = "E770048AE0B8EE2CF20B5355345E232E")
	public static final int GL_TRIANGLES = 0x0004;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "49290671357E72E66662A3E469BB14D3", hash_generated_field = "2DFC30CE5B5D0C909353FE0F8E82ECAE")
	public static final int GL_TRIANGLE_STRIP = 0x0005;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "152A59DE3C8BFA0CBD7404F3E2542224", hash_generated_field = "E319033744A6FD5FBED22534A09D0D9A")
	public static final int GL_TRIANGLE_FAN = 0x0006;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "111FC8EDA50E7ADBC286866D6C474575", hash_generated_field = "2AE94B595542B2CF364EA127E42FBDCE")
	public static final int GL_ZERO = 0;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "A6E0BBD75CDE8D03D67B820A733B579A", hash_generated_field = "82D5FE136043639857A6207E913F1A47")
	public static final int GL_ONE = 1;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "36ADCC9AAD8E40BA95A5A2EE997B2504", hash_generated_field = "C2011F8B7C7C63680FD638429313D1E6")
	public static final int GL_SRC_COLOR = 0x0300;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "673E47C14DACC74B65A89D1D24224070", hash_generated_field = "FBD253CA03B8349C32F1201CE77928A2")
	public static final int GL_ONE_MINUS_SRC_COLOR = 0x0301;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "EBAD21E42B574E8C0309DFA0D3A12C06", hash_generated_field = "DD041534D4A71692473722C9C3DA669C")
	public static final int GL_SRC_ALPHA = 0x0302;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "D096BA89CE620E0C534C13953E91E551", hash_generated_field = "9C97EBACE4D89BA37F0CE50A2B4086CF")
	public static final int GL_ONE_MINUS_SRC_ALPHA = 0x0303;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "C9FE89C49BE659848A68D8F29CECB237", hash_generated_field = "EA877CAC2DCE84B662BEC6DE59F3F34C")
	public static final int GL_DST_ALPHA = 0x0304;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "B4CD25B289431614AB64FA633A98EAA4", hash_generated_field = "3AEBAEB1CF16CE34127FDC76A8AA5071")
	public static final int GL_ONE_MINUS_DST_ALPHA = 0x0305;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "EFE8A911BBA5DF4AE82EFBEEDDA12555", hash_generated_field = "16B27F3397CB1CE88331D5E0EC0490B7")
	public static final int GL_DST_COLOR = 0x0306;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "1B9DEA330C62CF82AAB8CD4A9AADABB3", hash_generated_field = "77C61F9F16CE09FE063CB4595FE9C0EF")
	public static final int GL_ONE_MINUS_DST_COLOR = 0x0307;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "3EF1DA197E57D716CE3D44DC9F9B8D75", hash_generated_field = "70AEA0E98FC9C061FAC240ADA8332C5A")
	public static final int GL_SRC_ALPHA_SATURATE = 0x0308;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "97FB81213D23BA7B21856B1D28EC9DEA", hash_generated_field = "D50902402D69C610A934715E6F129BD3")
	public static final int GL_FUNC_ADD = 0x8006;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "B250E5DB39DA8A8A9DF5F2AF693115F1", hash_generated_field = "6EC3F2C104AF957D6866EF21152EADD2")
	public static final int GL_BLEND_EQUATION = 0x8009;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "E9914BCD80315D477863AF9CB8423115", hash_generated_field = "3A289A85D25C00F928C1FE0732A231E5")
	public static final int GL_BLEND_EQUATION_RGB = 0x8009;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "396100339B52E2F76000F725C220C7B7", hash_generated_field = "8328458ADD239D21874D8602CBEE1CD0")
	public static final int GL_BLEND_EQUATION_ALPHA = 0x883D;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "50BF1EE77C6FF4547A689CCFB7C5E535", hash_generated_field = "2789A42AD17642336ED89176D3459CBA")
	public static final int GL_FUNC_SUBTRACT = 0x800A;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "E37CFD0268EAE456B77AA98306D176A7", hash_generated_field = "841B2BFE51EFB61AF9621A796D6F8FE0")
	public static final int GL_FUNC_REVERSE_SUBTRACT = 0x800B;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "4579F2E5A0030A885A396F4F110C376B", hash_generated_field = "56DA957254437B7345E4D14FFC6938F0")
	public static final int GL_BLEND_DST_RGB = 0x80C8;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "06D4C1DCBC17A2316F2AFD28FA57F8EA", hash_generated_field = "7021FDA07EC829387602BE1DA5E8DB1B")
	public static final int GL_BLEND_SRC_RGB = 0x80C9;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "09CCBC130B52BD89955FB9F68C9A37B6", hash_generated_field = "23323BADC5529A62BEEC78CC402AE3FF")
	public static final int GL_BLEND_DST_ALPHA = 0x80CA;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "ED2BE77131CECBE6ACA07FB43F08AA87", hash_generated_field = "37127A5319E99E3AF83DB2376058D495")
	public static final int GL_BLEND_SRC_ALPHA = 0x80CB;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "E4F80AADC471DE3D98E61FDB66CFF598", hash_generated_field = "82AD4438DC04513576F31837F477C2B3")
	public static final int GL_CONSTANT_COLOR = 0x8001;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "9066AC8407F2FBA2CE7298666D10BBCE", hash_generated_field = "BDCC0896DDCAFA199087427799B9EA5D")
	public static final int GL_ONE_MINUS_CONSTANT_COLOR = 0x8002;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "60C586648BFFE6213233549B8FF13D9D", hash_generated_field = "BD126F9C972C4B7B4CC57D9F4F005914")
	public static final int GL_CONSTANT_ALPHA = 0x8003;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "216FEE6E11F0E30A7FA8F763A5A00B8A", hash_generated_field = "0C97206C3329306E43B66DC5181EBE7B")
	public static final int GL_ONE_MINUS_CONSTANT_ALPHA = 0x8004;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.570 -0400", hash_original_field = "6EB356164B8C2D6601CCFA1CD7DC18FB", hash_generated_field = "1668CEB39BFB5487D035EA0A3FACD265")
	public static final int GL_BLEND_COLOR = 0x8005;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "196904480602D072181788FE0DEC8B21", hash_generated_field = "409495B1B8CFA1F8211F60AD68365B86")
	public static final int GL_ARRAY_BUFFER = 0x8892;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "156D10AAF4648BA358F69F3A51499827", hash_generated_field = "38D85FEBECCF45569EA094673A351A4D")
	public static final int GL_ELEMENT_ARRAY_BUFFER = 0x8893;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "0CB7C96E1FEE37A9DEBFA27EBFBE66C1", hash_generated_field = "B8BBB605C29E504DD83196936ACA9837")
	public static final int GL_ARRAY_BUFFER_BINDING = 0x8894;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "4B59F62E2FCB9B6867A65FA491642919", hash_generated_field = "C740F3ADA0906D319EF5C52026B18A05")
	public static final int GL_ELEMENT_ARRAY_BUFFER_BINDING = 0x8895;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "1C3F69493CC750083497E9CEC7B9D9DA", hash_generated_field = "832C1E21FAAB59494282453ADDE744D0")
	public static final int GL_STREAM_DRAW = 0x88E0;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "E73B34C5C5F4877055F5479A5AF14412", hash_generated_field = "89FAC3E23D9D7D02625C85E6D1604B80")
	public static final int GL_STATIC_DRAW = 0x88E4;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "146AD8EC4585A5F371F6D09803FE8A9E", hash_generated_field = "2242CD9452F430351807890803F544C6")
	public static final int GL_DYNAMIC_DRAW = 0x88E8;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "2702DFFC43780F3EFA3FEA1481EDFA7C", hash_generated_field = "21798B99CB9AEBC6C5FE28B5A981B8F5")
	public static final int GL_BUFFER_SIZE = 0x8764;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "29AF56CA701295059AE51CAE13F16BC4", hash_generated_field = "C76A93BA5DA7C1B1CCA9AC65B1B8BB10")
	public static final int GL_BUFFER_USAGE = 0x8765;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "CFA8BB45B54661F520F5E6BB5E563B0A", hash_generated_field = "463800F0A213D6B17324F9D7235D9EB5")
	public static final int GL_CURRENT_VERTEX_ATTRIB = 0x8626;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "45780475D656D5BA7B0700918944B0F9", hash_generated_field = "282681C01F23D92A723004A36CE68F21")
	public static final int GL_FRONT = 0x0404;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "BEA1B9EFDC06A94AC5BFB35214DD24D2", hash_generated_field = "8D01D16E233D653B13BF35763F39094C")
	public static final int GL_BACK = 0x0405;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "56F8034B9BD603833C4D5BB7792F2804", hash_generated_field = "2823AEA7B2FB283F963720184AE348D1")
	public static final int GL_FRONT_AND_BACK = 0x0408;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "A92A76DB6CB9AA05FBA60F7D549F80B4", hash_generated_field = "CFA8DF52C890C8F91C1BA2D266BB91EB")
	public static final int GL_TEXTURE_2D = 0x0DE1;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "FC9A444B144C9FBF2A6A624A86DAD235", hash_generated_field = "9ABC6C59449029C0D07E4AB5037CCDA7")
	public static final int GL_CULL_FACE = 0x0B44;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "2C746769A941190F3AACE34FCE99EB10", hash_generated_field = "B8047B6EFFF20A9163B2D267795697BD")
	public static final int GL_BLEND = 0x0BE2;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "9496A3C9F50F2FECEE9233085D8DE797", hash_generated_field = "55F31A3EBC84BD31DE876C99C319C524")
	public static final int GL_DITHER = 0x0BD0;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "894BE111258A6B18FF77F63667177FA8", hash_generated_field = "8DC539E2C1E101290729428C524DA2DC")
	public static final int GL_STENCIL_TEST = 0x0B90;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "37EE9C06B5ABECBAE35B1FC8F32A1A0A", hash_generated_field = "FA6A17422F3B297267EDCBF88D16D4C5")
	public static final int GL_DEPTH_TEST = 0x0B71;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "B556BC4F74EC161C972F7165DE856262", hash_generated_field = "62D9DAC9732EE80D837C16904113DAEA")
	public static final int GL_SCISSOR_TEST = 0x0C11;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "0F08D749CA74E2FE01651D5FE3A8A4D2", hash_generated_field = "A9BCF6D80660E88427AD2FFB50877931")
	public static final int GL_POLYGON_OFFSET_FILL = 0x8037;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "0BAFA89A78D5E21FC2F15FCD5B116BAD", hash_generated_field = "0C96EEA0B791093940726427BE517D6B")
	public static final int GL_SAMPLE_ALPHA_TO_COVERAGE = 0x809E;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "F3ECCDEBB2CC14C5C179CC60F1819510", hash_generated_field = "E4DE56A2A355F1A7C7E2A493405E4965")
	public static final int GL_SAMPLE_COVERAGE = 0x80A0;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "E272446CE554D8EE1DBDA1A31077FD6C", hash_generated_field = "0653236F53D5E9A2C959345944242124")
	public static final int GL_NO_ERROR = 0;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "600490D79A6E38846E004350C5CBB64C", hash_generated_field = "F8C6C9C7A3A9BA71ADE96972F4E2BE91")
	public static final int GL_INVALID_ENUM = 0x0500;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "3085379FEC8B4948F9D8DDA5C2ED0A1D", hash_generated_field = "E2D361363B879444BF7C0E4D575B7395")
	public static final int GL_INVALID_VALUE = 0x0501;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "D36A41405C964872CAAE27D2063C99C5", hash_generated_field = "BF905AF0CB04092D0B0DA2F0D5839959")
	public static final int GL_INVALID_OPERATION = 0x0502;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "DC7425945A9FE3F202B7030A959ECCAA", hash_generated_field = "E95871CFC24E5C6E759FA8B49E0583BF")
	public static final int GL_OUT_OF_MEMORY = 0x0505;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "D649F147F02D3CDCAE4E4624673F5A75", hash_generated_field = "2C6DCD63CABB3C41ECC7B9014ED3B907")
	public static final int GL_CW = 0x0900;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "9BAD1EF548CB0B114C1AAAB4A86FA8DE", hash_generated_field = "D90679929372A8D046997B2D0E27D061")
	public static final int GL_CCW = 0x0901;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "6A0FB2338B8B162E71F59F8896D7A182", hash_generated_field = "01DB5ECBD6642646F30B04C94349F17B")
	public static final int GL_LINE_WIDTH = 0x0B21;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "9C64BCDF8A02D1C0AD1E89A6FEF0263A", hash_generated_field = "19883743E3CCB19994F89686F320722F")
	public static final int GL_ALIASED_POINT_SIZE_RANGE = 0x846D;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "FD5288D66A66619C796D3B9E27ED513B", hash_generated_field = "8FCB0F04C33D33E10BECE828D721612F")
	public static final int GL_ALIASED_LINE_WIDTH_RANGE = 0x846E;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "D3CEBF860B33E538936EAFC4F8DC9EBB", hash_generated_field = "767EAD326AF86CD019950B2E108A7917")
	public static final int GL_CULL_FACE_MODE = 0x0B45;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "52C951C7BBD6B4515D3B95EB2DC63E29", hash_generated_field = "B3F8F582DE87930692E11DF9F0867E22")
	public static final int GL_FRONT_FACE = 0x0B46;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "2133AB122D26FA1FE29813F919A74F42", hash_generated_field = "4798273E6A8C1B8636D49958CC58C63F")
	public static final int GL_DEPTH_RANGE = 0x0B70;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.571 -0400", hash_original_field = "D525DCAA9579008E900B57511E85FB9C", hash_generated_field = "E186156B09F36E2215F5FFC278B81FD8")
	public static final int GL_DEPTH_WRITEMASK = 0x0B72;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "4E7CA842B4DA295272EB0CA8BDB039A3", hash_generated_field = "08458BB4D7EE93F163492A8A76853E2C")
	public static final int GL_DEPTH_CLEAR_VALUE = 0x0B73;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "E89BC25AA632B1F1B66872B07E5A9C34", hash_generated_field = "A5BE43A42F568B6C881DDCF04E9D2409")
	public static final int GL_DEPTH_FUNC = 0x0B74;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "696AD5E50FB840FE8BA6407F7E8D4927", hash_generated_field = "9131E5B584F55CE29F01D2ECEE52427A")
	public static final int GL_STENCIL_CLEAR_VALUE = 0x0B91;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "25B654775C3E3DD8463900C0A9C12C54", hash_generated_field = "D7938EE10441B2911024C8670D093813")
	public static final int GL_STENCIL_FUNC = 0x0B92;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "10BB8856A0E184B6277084AC22682E67", hash_generated_field = "CC69FC57D650B08307A58FD35CB51C8A")
	public static final int GL_STENCIL_FAIL = 0x0B94;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "D183EC82497756043958BC43BB82A145", hash_generated_field = "6FAC8F4E96B44838F58A4E04D6286655")
	public static final int GL_STENCIL_PASS_DEPTH_FAIL = 0x0B95;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "9269680BE2BE14F83233F2DB3E5396D4", hash_generated_field = "960C2A2112B7861CC22EACBC1AAF69FC")
	public static final int GL_STENCIL_PASS_DEPTH_PASS = 0x0B96;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "EBF444188C3A2E9E6E7E5C4A3D9D77C4", hash_generated_field = "90F2BD1F9CD30298F9AC7F2BBC6F0232")
	public static final int GL_STENCIL_REF = 0x0B97;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "65F03CAA2A6AA8B50B885E7D46E8E297", hash_generated_field = "8FAE667B4EF9352BC9C17E6BF12BA194")
	public static final int GL_STENCIL_VALUE_MASK = 0x0B93;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "E9CB0840610781A1B93F3FF2B67348A6", hash_generated_field = "3577EE931F082669BBE4D9969E122778")
	public static final int GL_STENCIL_WRITEMASK = 0x0B98;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "833EB367FB22A7EBA488588D3D918EA9", hash_generated_field = "EFFC38CBA05B79292ACD80DD4D1190D7")
	public static final int GL_STENCIL_BACK_FUNC = 0x8800;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "4703045B46C43EB68AC00FCA7F42F29C", hash_generated_field = "BDAAF1440D011FC1E51494FDA8588400")
	public static final int GL_STENCIL_BACK_FAIL = 0x8801;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "584C21868536F751566E606E41525AE4", hash_generated_field = "8A0A4F4A34082B512827A63A47F88467")
	public static final int GL_STENCIL_BACK_PASS_DEPTH_FAIL = 0x8802;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "D15694259EFAE57E8836D7CA7CE2096F", hash_generated_field = "05976D765A202DD7AF5E935D0336FC85")
	public static final int GL_STENCIL_BACK_PASS_DEPTH_PASS = 0x8803;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "402B3F0D2360E03129C83E6A0B213903", hash_generated_field = "B893D3B9E979B8C21EB6C04613D71E8C")
	public static final int GL_STENCIL_BACK_REF = 0x8CA3;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "2B6159708C770FB7A811B6B1B6FAEB22", hash_generated_field = "FBBABA523C9F04591BCDE5CAA1B50E9F")
	public static final int GL_STENCIL_BACK_VALUE_MASK = 0x8CA4;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "B7A068C34378D75B15284E638EA2BD45", hash_generated_field = "14315390EC704CAED92B0E7E67CB9D21")
	public static final int GL_STENCIL_BACK_WRITEMASK = 0x8CA5;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "C3DCD0066EA1367CF9863BD85FC1A5B9", hash_generated_field = "03970251FDEDB198C704D5CB1226C075")
	public static final int GL_VIEWPORT = 0x0BA2;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "1573DB03F78927D626CAB89DFD520854", hash_generated_field = "189E13B6264AAB01FEB79D7F93C0DED3")
	public static final int GL_SCISSOR_BOX = 0x0C10;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "9AB5799346B6460F9402E5A7123D219F", hash_generated_field = "0F9D40CABAE9B4759159781D6865495A")
	public static final int GL_COLOR_CLEAR_VALUE = 0x0C22;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "9FE549EEC72EACC7B45D52DA3D73163B", hash_generated_field = "0E0B9D3D43481CD8AAE788491395F40B")
	public static final int GL_COLOR_WRITEMASK = 0x0C23;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "EEC0689D81D81C50C16EB1A68581B32B", hash_generated_field = "07391187CDB7D66B8228865535D68F9C")
	public static final int GL_UNPACK_ALIGNMENT = 0x0CF5;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "7FEA0DBC57B5C76BBC078F8F4B97C0A6", hash_generated_field = "420168862C9EEAA13A97C845B02656C9")
	public static final int GL_PACK_ALIGNMENT = 0x0D05;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "FAEB86B9C49A86939ECD9BD123F39CA1", hash_generated_field = "A2ED8C7E41FB13A2FDF8E15102E65BC7")
	public static final int GL_MAX_TEXTURE_SIZE = 0x0D33;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "E15A84BDB4FA19571A35A7CD9D61DC77", hash_generated_field = "BC4991FCAD83DB0A7868B26EBDE034D9")
	public static final int GL_MAX_VIEWPORT_DIMS = 0x0D3A;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "939B31BD3DC4A69FE3A195CBCC3A233A", hash_generated_field = "4F10C209D49E9D5A5FC0C3797AA306D8")
	public static final int GL_SUBPIXEL_BITS = 0x0D50;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "86EE157263D0AF5638902794F52F195A", hash_generated_field = "C50548619DDE0126722D8AB15FF2EF16")
	public static final int GL_RED_BITS = 0x0D52;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "9CA32D3F28C6BC01B99E6380122E1429", hash_generated_field = "5B1708D4871A175D42766720896F17EF")
	public static final int GL_GREEN_BITS = 0x0D53;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "A6A84365E3EAF5E2363436F11361A588", hash_generated_field = "F1A2269499DEFE7DF6523956BF443AA2")
	public static final int GL_BLUE_BITS = 0x0D54;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "D5F9E5792CA4571E06A4B8C46416FE32", hash_generated_field = "C7AC3BCD060ADDD8CFBAE19F1D470C1E")
	public static final int GL_ALPHA_BITS = 0x0D55;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "33E619088D18DF8BA2CD3EEA4F5C4AB3", hash_generated_field = "C23671D29990648AA3F86C9EB1C76CED")
	public static final int GL_DEPTH_BITS = 0x0D56;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "35BAAB6F6E562C8D2A26A187F6C312A9", hash_generated_field = "C15714275693DB4FD1855853B46EB0D8")
	public static final int GL_STENCIL_BITS = 0x0D57;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "86E33269B3A5F9384B29C4773AC21C07", hash_generated_field = "A8B6B31DEEB290A3D4E14090C1758334")
	public static final int GL_POLYGON_OFFSET_UNITS = 0x2A00;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "F2FB56B94D293E32450E4293B60C4A0C", hash_generated_field = "1E251FEEDD033907636F04FDD525CDFA")
	public static final int GL_POLYGON_OFFSET_FACTOR = 0x8038;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "84D5FAB7EFCFCD2AFB6D7342FC8E6160", hash_generated_field = "2B50E2FE09FBDA6BDC1234B9C1677E6A")
	public static final int GL_TEXTURE_BINDING_2D = 0x8069;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "ADA0E02FC7A6CA97EB8F763B94E452FC", hash_generated_field = "505BCEE1C3A7503D7BE7183B26B5561C")
	public static final int GL_SAMPLE_BUFFERS = 0x80A8;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "0BF5F5BDC02DB3133A7100B6625F9F0C", hash_generated_field = "E33390EBFD238B90E5D6A5E93E9A7398")
	public static final int GL_SAMPLES = 0x80A9;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.572 -0400", hash_original_field = "4D89C7F72DDDB1C6FBF2DE480DF8092F", hash_generated_field = "2A100C6BF47ACDB822240C6C42C050DF")
	public static final int GL_SAMPLE_COVERAGE_VALUE = 0x80AA;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "895BE2E2EEB2302909BE6C60C0644325", hash_generated_field = "9C72E7351BE83A77404F868F0BAF7E60")
	public static final int GL_SAMPLE_COVERAGE_INVERT = 0x80AB;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "27E5E17196D3B0EE6B4E13DAFB61E363", hash_generated_field = "6B49EE83F1713650B4936148C3D6E1BC")
	public static final int GL_NUM_COMPRESSED_TEXTURE_FORMATS = 0x86A2;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "4BE01025E706815FA57A9FCB544D9766", hash_generated_field = "D2E69BE46D8601F3AC337E2E00FD3F7C")
	public static final int GL_COMPRESSED_TEXTURE_FORMATS = 0x86A3;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "994BD72B2035EB28A4B0724917508872", hash_generated_field = "DCD1693386658F7795F0400387749F39")
	public static final int GL_DONT_CARE = 0x1100;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "BC4EA4E148493AB89275E92881815273", hash_generated_field = "B21755035B5719E0A8E87DC953A69D86")
	public static final int GL_FASTEST = 0x1101;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "FAD71CDAADA4161E2C3890104D68FFD0", hash_generated_field = "6B136FADA83CBD44BC9F1E2EEBAE0BD5")
	public static final int GL_NICEST = 0x1102;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "F6991E35FB08704DC3D5913B5AA23800", hash_generated_field = "A6CA2B16E7F8EFAAF9D94589C56B7846")
	public static final int GL_GENERATE_MIPMAP_HINT = 0x8192;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "95017852ED5FE92600CF4DB7A0155646", hash_generated_field = "CA6B17F497DEA88919CF12FEF41C771D")
	public static final int GL_BYTE = 0x1400;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "CE83B214B66039AF4C5B212C15D93173", hash_generated_field = "D9C771F554A8939A1729582F2211DA5D")
	public static final int GL_UNSIGNED_BYTE = 0x1401;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "24EE400976B1DCE7FA604237E21D9EF1", hash_generated_field = "CEC9DBF8A25C09C8EE36A2040FCE90EC")
	public static final int GL_SHORT = 0x1402;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "E015E36E89D7DA528DBA1D604AFCEB13", hash_generated_field = "CF2E78B3A757A12168ACD04C3937641C")
	public static final int GL_UNSIGNED_SHORT = 0x1403;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "29FAED5438813C0516C1FCA8E7AB1C64", hash_generated_field = "8CDD0011064211DB2BAA375F2E79C61C")
	public static final int GL_INT = 0x1404;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "62D2909A6FBB86E066921C5543730FDA", hash_generated_field = "CDF4AE5E0E889BCB6DE8745101A9AAAB")
	public static final int GL_UNSIGNED_INT = 0x1405;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "9BC0A540EA4EC46ED1194E3FDC51CEBE", hash_generated_field = "776A345C3935B2E98F4769552CE86E47")
	public static final int GL_FLOAT = 0x1406;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "7BF8C9C82BDB73F9E3E9B5B5A60C3E19", hash_generated_field = "54727533A2FC1141376E118EFDF1E024")
	public static final int GL_FIXED = 0x140C;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "9B8BF680C939AE5D8E7E712B1E115B9D", hash_generated_field = "801768A53EC22ED09412E1BC74DBBE40")
	public static final int GL_DEPTH_COMPONENT = 0x1902;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "F654B3C5FCC164E778ED8207BD074615", hash_generated_field = "EEC5ED5025D8B6C12C784EADC0C94480")
	public static final int GL_ALPHA = 0x1906;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "79D94ECC8ED2B72E6C9EE0A613D67BF6", hash_generated_field = "6A23C406FDB5B7A1B50702BA5CC9C002")
	public static final int GL_RGB = 0x1907;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "250D21C790C7F7F82250F6DD60A63A45", hash_generated_field = "C54FF8BC96B52D3F5B82AECAA4368DC3")
	public static final int GL_RGBA = 0x1908;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "5986840FBDA6B93F51EE2C942ADFD40E", hash_generated_field = "C81D52BB104C03AD2A5683FF4CB425AE")
	public static final int GL_LUMINANCE = 0x1909;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "A9AC536C7824EE4D55BA9582A8904BDD", hash_generated_field = "05F661AB7EBC422B7D80FDAA800AC894")
	public static final int GL_LUMINANCE_ALPHA = 0x190A;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "B7A68302F5F65BA0B48C79B4331A90A5", hash_generated_field = "B20FCFFE737F717A755866C24553F9C3")
	public static final int GL_UNSIGNED_SHORT_4_4_4_4 = 0x8033;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "1B988C3EFE7C35E89D512C4DAC163448", hash_generated_field = "C2FA2F9F63044337A428E6E10E6D2AFA")
	public static final int GL_UNSIGNED_SHORT_5_5_5_1 = 0x8034;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "5F6C1C5E9BE6532DB4BA318B32B0F187", hash_generated_field = "4C7D42068CD7D103E43E5E903CF95B76")
	public static final int GL_UNSIGNED_SHORT_5_6_5 = 0x8363;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "39CAA2F3E6DDA0B86A65C9C9184415D8", hash_generated_field = "DFB96D996EEABFB9CCF2BAFC30F482F7")
	public static final int GL_FRAGMENT_SHADER = 0x8B30;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "48F82260DAEE8B52797CF1EA938328D8", hash_generated_field = "742E75B3C2E9DA0C645480394F12CD67")
	public static final int GL_VERTEX_SHADER = 0x8B31;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "8C9F0525C13D13A9E03151310C155309", hash_generated_field = "B6FC72374BFCEE9E0D09775E9FB3C888")
	public static final int GL_MAX_VERTEX_ATTRIBS = 0x8869;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "B4D2EDE05DDE7E7E2CF299D4ECAA8705", hash_generated_field = "C81AF6C51263FC6E99C5257587C2C78D")
	public static final int GL_MAX_VERTEX_UNIFORM_VECTORS = 0x8DFB;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "EC6D6AF23323128C20DCBD4562F70316", hash_generated_field = "8069D3F4E358C4F2D8E08D955EA562D9")
	public static final int GL_MAX_VARYING_VECTORS = 0x8DFC;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "636A74E202C0865BE14B89475ED2A946", hash_generated_field = "59EC03752244AF3DDF928E977A02E072")
	public static final int GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS = 0x8B4D;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "3ED9B8DBF2613F01794E2BEF8EE7B959", hash_generated_field = "6714B71F415D42AF6570D4E76696FE70")
	public static final int GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS = 0x8B4C;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "85201D21F8DCD674A25797831D05FA96", hash_generated_field = "B1BD9608C110C36D8685436853B834F7")
	public static final int GL_MAX_TEXTURE_IMAGE_UNITS = 0x8872;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "8B758183D1A4FA59EE319CA59B79C36A", hash_generated_field = "53D492D701A8AD909D2F0F45C0F4292F")
	public static final int GL_MAX_FRAGMENT_UNIFORM_VECTORS = 0x8DFD;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "20DF665BA5DC4DEC712E186B9ABB2C2F", hash_generated_field = "3EE0C5308ED4B368C49B468E15DF4498")
	public static final int GL_SHADER_TYPE = 0x8B4F;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "38437018E4F9831DD30C417E6BAF817C", hash_generated_field = "EDF95A293DF9F7FCCF00B93098264A9A")
	public static final int GL_DELETE_STATUS = 0x8B80;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "45F82B087EB3E16DC91CE0BCC196D1BE", hash_generated_field = "573E11A0B1F99D640642993EE5EAE850")
	public static final int GL_LINK_STATUS = 0x8B82;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "E61DA3DE3264A5012FC841686CEA1B1E", hash_generated_field = "F8EF30E94ABB67A125539CEB07072333")
	public static final int GL_VALIDATE_STATUS = 0x8B83;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.573 -0400", hash_original_field = "465CF8DA3A3F83A9FD82519F334E9B13", hash_generated_field = "69A29EC9CCB718D4E1887781A459F897")
	public static final int GL_ATTACHED_SHADERS = 0x8B85;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.574 -0400", hash_original_field = "61B55F93EA7721EDE4A76E0478211ACD", hash_generated_field = "C3031F2A578AA7CD7A65367E731FDFAE")
	public static final int GL_ACTIVE_UNIFORMS = 0x8B86;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.574 -0400", hash_original_field = "20196CD6B59D81F7F9FBA2943DE14C0E", hash_generated_field = "B198CAA111CE9D9C35CE2FE04190064C")
	public static final int GL_ACTIVE_UNIFORM_MAX_LENGTH = 0x8B87;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.574 -0400", hash_original_field = "D597EAC265A622B26E3CA3C044A679EF", hash_generated_field = "EB1F090B173F3D7A162F0122C843CFA6")
	public static final int GL_ACTIVE_ATTRIBUTES = 0x8B89;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.574 -0400", hash_original_field = "BDA0EC9DC04646BA2522AA4BD9A53387", hash_generated_field = "32CB6E2BDE968F3455895E8805311A2A")
	public static final int GL_ACTIVE_ATTRIBUTE_MAX_LENGTH = 0x8B8A;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.574 -0400", hash_original_field = "254A37978A6424E1569E4EBDF3EEA710", hash_generated_field = "FC2E624E99E219FDE3F8C8B5AD7D798A")
	public static final int GL_SHADING_LANGUAGE_VERSION = 0x8B8C;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.574 -0400", hash_original_field = "4AFF9FA6B343648D0B267B6CF6584900", hash_generated_field = "B241BBA49E38740ABECD5F6D8E50947D")
	public static final int GL_CURRENT_PROGRAM = 0x8B8D;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.574 -0400", hash_original_field = "3D51615DF08CA325BD60CB8BE81CB7CC", hash_generated_field = "CA379896EFAC1FCD285FDDEC471ED007")
	public static final int GL_NEVER = 0x0200;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.574 -0400", hash_original_field = "300470655124377989F9691A6B79EC37", hash_generated_field = "CF8C714644DB7D661F354ACA1832748C")
	public static final int GL_LESS = 0x0201;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.574 -0400", hash_original_field = "F103070C4A93A34E3C20C65663B5F91E", hash_generated_field = "92F53098599AA2DBF61CD4CBFE1E1026")
	public static final int GL_EQUAL = 0x0202;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.574 -0400", hash_original_field = "1138633BC15BD0C6EC2DCC5D28E264AC", hash_generated_field = "08E9588A524EB2187171C96E2FC84E53")
	public static final int GL_LEQUAL = 0x0203;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.574 -0400", hash_original_field = "8FCEE8CB4EBD54A7DBC9B80152DF4F05", hash_generated_field = "86527F04ED005A379DDE1E13CA42480F")
	public static final int GL_GREATER = 0x0204;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.574 -0400", hash_original_field = "C58C3C8ACDC5F1136CF8940BF14C8E0D", hash_generated_field = "9D163E05C29CDB049D5EFDCB69A11F5B")
	public static final int GL_NOTEQUAL = 0x0205;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.574 -0400", hash_original_field = "788C1363BA723890CEB04A7DB9715041", hash_generated_field = "7B31CD8183BCDB86620F2670173470EB")
	public static final int GL_GEQUAL = 0x0206;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.574 -0400", hash_original_field = "54C36B7B24128D358B50C0091495025D", hash_generated_field = "EC3E764163C9D8D7002C124025DD7ECB")
	public static final int GL_ALWAYS = 0x0207;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.574 -0400", hash_original_field = "E686CC35CFDF1876F125012A12665BC8", hash_generated_field = "AC1B44CC8A8DFECDC32B181A188D5EC3")
	public static final int GL_KEEP = 0x1E00;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.574 -0400", hash_original_field = "B533B1F6BA488CB7361ADCCEA076A5C0", hash_generated_field = "7825B8439D0B67AC7D326B5C83947881")
	public static final int GL_REPLACE = 0x1E01;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.574 -0400", hash_original_field = "588E513A8DF329C202409B7D9C7C7A71", hash_generated_field = "043F85B707374E94709A8F7159F387E0")
	public static final int GL_INCR = 0x1E02;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.574 -0400", hash_original_field = "F2CF86EA3D38BC0FB0C231BD4C1EA271", hash_generated_field = "5315E9E453BD796C61A0AB06DD8E6A52")
	public static final int GL_DECR = 0x1E03;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.574 -0400", hash_original_field = "5B8004742615098CD780D01CC85FADB6", hash_generated_field = "891D64DE0F628EC3BD77CEA1FB2643A6")
	public static final int GL_INVERT = 0x150A;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.574 -0400", hash_original_field = "9D1DF4C01EDCCAF754CB7C19BBF8C92A", hash_generated_field = "58D823F537D18E7F3C79D65A5F268814")
	public static final int GL_INCR_WRAP = 0x8507;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.574 -0400", hash_original_field = "3F065D086A5188D6F3A60441BD4C4BD5", hash_generated_field = "377377DC71CB527956F4E62598C7B850")
	public static final int GL_DECR_WRAP = 0x8508;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.574 -0400", hash_original_field = "6F10BB3EEEA68FE4CFE758AAF179598B", hash_generated_field = "F31B958C8F10E182C79082E291A281D3")
	public static final int GL_VENDOR = 0x1F00;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.574 -0400", hash_original_field = "98273F7F5EC8F02266A34B0F890E05BF", hash_generated_field = "9F902BB754AA320AF68CBD170F59FDF5")
	public static final int GL_RENDERER = 0x1F01;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.574 -0400", hash_original_field = "88813588EEE2E3A420DD98420E57A8F1", hash_generated_field = "ED8862F66460C23F886758F9B875895E")
	public static final int GL_VERSION = 0x1F02;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.574 -0400", hash_original_field = "6C28E650DA83F836D64B9AB62CA99166", hash_generated_field = "5B3583373834E1B16997BF3A95388EB2")
	public static final int GL_EXTENSIONS = 0x1F03;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.574 -0400", hash_original_field = "9BE69359BE4FAEFAA3F60DD821EB575E", hash_generated_field = "B0FB6384C88C83EB4C1A4C10AA65E821")
	public static final int GL_NEAREST = 0x2600;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.574 -0400", hash_original_field = "CC63F294F62FC37B4BCBD97EF5470D8B", hash_generated_field = "7F86F6F1824D09F94648C12DD73CE3CD")
	public static final int GL_LINEAR = 0x2601;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.574 -0400", hash_original_field = "5E4D49431983D6CB23D879579DBDB007", hash_generated_field = "A2ADEF4D1C78AA83F5B2352C8DBDC6E2")
	public static final int GL_NEAREST_MIPMAP_NEAREST = 0x2700;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.574 -0400", hash_original_field = "0F705B584DF3DA2C3937E05033AF08D5", hash_generated_field = "F99ADA5F5048826A006EABD5E713AD76")
	public static final int GL_LINEAR_MIPMAP_NEAREST = 0x2701;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.574 -0400", hash_original_field = "488B0B15A00A3229A4676C745F4D16CE", hash_generated_field = "F0A2FA3AACBA4EA7BA158C2462E7D640")
	public static final int GL_NEAREST_MIPMAP_LINEAR = 0x2702;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "5ADDA99B92F8A1866F76191B319F4256", hash_generated_field = "EFC7F162A4792680BED3D106B21DC2A5")
	public static final int GL_LINEAR_MIPMAP_LINEAR = 0x2703;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "2B6CFF1A5EAC91C188C9BF29BB32E747", hash_generated_field = "0F8FE623FD8E0ED110006D791288A686")
	public static final int GL_TEXTURE_MAG_FILTER = 0x2800;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "E90F72F5048AE41ACD1EE0FF2923FFFF", hash_generated_field = "702299E7AFC47AA8D9BFCB1EE1AA1BAA")
	public static final int GL_TEXTURE_MIN_FILTER = 0x2801;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "26B19CB86E36452C2B54BC27632B2BC2", hash_generated_field = "79FED79498C93220A14654ACE7E303EB")
	public static final int GL_TEXTURE_WRAP_S = 0x2802;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "0617F75267EDC6D104B54EF6E55AA0A7", hash_generated_field = "BA13CBAC042E1A4FD3E8BBA4033145DC")
	public static final int GL_TEXTURE_WRAP_T = 0x2803;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "A5DF03B9478D14E72E1E3FBEF4406430", hash_generated_field = "D123EB9A72FA50D7D443B3DBF04FC9B1")
	public static final int GL_TEXTURE = 0x1702;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "74308F7FCD801C724579B92794338672", hash_generated_field = "C5B94F87C7F7091D714E618BFF874A1B")
	public static final int GL_TEXTURE_CUBE_MAP = 0x8513;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "5641EA249076A29871DDEDD4BC5E444D", hash_generated_field = "7F5A12E4D58F030B256FA765A9073285")
	public static final int GL_TEXTURE_BINDING_CUBE_MAP = 0x8514;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "A0F2C513D62D7DB5D6934B70ADA117B6", hash_generated_field = "43380C95D61FA3716F133235A86132BC")
	public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_X = 0x8515;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "F96F601C8AB7C2856D6ABC6701D0CF6B", hash_generated_field = "07154BDBD6721FDD686965E54E50325D")
	public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_X = 0x8516;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "8EFAD79B99432BB49FF88BF96E0B2476", hash_generated_field = "EF75140F1E1C37785AFA91D59A7C333B")
	public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Y = 0x8517;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "AEAEA386F22ABEED4BD4FD3AD3F6E056", hash_generated_field = "62CC94418A851D43962F44C5B313F1E4")
	public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Y = 0x8518;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "51F9B598926A3F9EA2CA248225DD55E6", hash_generated_field = "EDB85454F5B1F42EC6A88BA603CAF693")
	public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Z = 0x8519;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "808FB9A6C9F4D6ABFACCF5FF0829FAAD", hash_generated_field = "10688D512FFDBF21EC84E1FE35A6EF2E")
	public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Z = 0x851A;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "633E5B9A0C3DF1DE95CA3AF08E8C4293", hash_generated_field = "B84618CEAC51539AAA5334C833A515BA")
	public static final int GL_MAX_CUBE_MAP_TEXTURE_SIZE = 0x851C;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "2D1F9898C91B0F87E3446BC7D669E570", hash_generated_field = "BA0F4FF4C8B05303345E6F0BCE004F67")
	public static final int GL_TEXTURE0 = 0x84C0;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "6AF29586D6768D9C8AE48115D9C97B93", hash_generated_field = "6368F222D7BE49D35F9CAFE86DFDD44A")
	public static final int GL_TEXTURE1 = 0x84C1;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "60497C35476D632D721C17C32B922673", hash_generated_field = "F9606689F311997886F22F3B4A4D9951")
	public static final int GL_TEXTURE2 = 0x84C2;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "CAF320E9076F9EA3BA5698F988E004EB", hash_generated_field = "EB7A66E482516BA8A83A2C0901AE9821")
	public static final int GL_TEXTURE3 = 0x84C3;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "E1C4031C118EBDAC97711ECC98D8932C", hash_generated_field = "8C3019ADB0DB73957332280BCB5C776D")
	public static final int GL_TEXTURE4 = 0x84C4;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "163640337500173F6B38E97AB6D0B4ED", hash_generated_field = "0ADC913BC5A636AC0043EEAB35B38ABE")
	public static final int GL_TEXTURE5 = 0x84C5;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "2D564C34E10B272BD5A552FDF88E18C3", hash_generated_field = "B031ADC1DCEDC2622EBDBEE78D98E599")
	public static final int GL_TEXTURE6 = 0x84C6;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "5D21405BBBDC8183693B38BD09F12AB9", hash_generated_field = "F0C1EE436F2FA5C7CF66757834968528")
	public static final int GL_TEXTURE7 = 0x84C7;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "9DC0ED1377156862BD12AAF1D23104E1", hash_generated_field = "378DF8E3660EABD42DFAE32C9CC7F398")
	public static final int GL_TEXTURE8 = 0x84C8;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "3D1165CC1CC15873E950B87BF3F1AC38", hash_generated_field = "3C3FCB1A67F035913B43C79D2D75D872")
	public static final int GL_TEXTURE9 = 0x84C9;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "2EAD997E695D0161EDBC3211C555CF25", hash_generated_field = "776A57758332051D1D11DFE46DC41B12")
	public static final int GL_TEXTURE10 = 0x84CA;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "DB02A680E4376411CB1666A873996E6F", hash_generated_field = "96905C885C6A888FEFF76AC4318D88E0")
	public static final int GL_TEXTURE11 = 0x84CB;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "1E502064FD3335685A2AEC4541E09CD8", hash_generated_field = "E53F5986F1DCA42B824D147FF7D61D0C")
	public static final int GL_TEXTURE12 = 0x84CC;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "8F2A1205B30D2FF145B54AC22C370404", hash_generated_field = "D736272A012DC1B2C7D4F2075A10371A")
	public static final int GL_TEXTURE13 = 0x84CD;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "1F958EC6DCD072661F1212CBE4854A2F", hash_generated_field = "A5B1A8D739FEE7A61A47B638606088EA")
	public static final int GL_TEXTURE14 = 0x84CE;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "39E3FCD5A29A0C1FDAB419BFF0FCACEA", hash_generated_field = "2D1B4D0A36141BF734DC607A7894592F")
	public static final int GL_TEXTURE15 = 0x84CF;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "108E967F5FCBF7618F14E7656EAB8891", hash_generated_field = "0FAE9C9EBBAA9BF0C721E851AF3EDE0D")
	public static final int GL_TEXTURE16 = 0x84D0;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "B00876FBFA7170FB326F65402B46F6BC", hash_generated_field = "C0ACBBDC95FC99E0E86F764F882B7F88")
	public static final int GL_TEXTURE17 = 0x84D1;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "51995D26EAD26150B355729BD25C17FF", hash_generated_field = "B5B5A27665F1BB7E1FEDCA77A03AA883")
	public static final int GL_TEXTURE18 = 0x84D2;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "580BFA1F047CD645FC8294536DD3F50F", hash_generated_field = "99C75295F9DE85B97D0A81F7CA5EA203")
	public static final int GL_TEXTURE19 = 0x84D3;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "A2C6326F2A134054463F06B4475B423D", hash_generated_field = "CD24AFB64E44A02D63932BE13470E6AA")
	public static final int GL_TEXTURE20 = 0x84D4;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "C7E4887328EE1695C1C8328D9DD17073", hash_generated_field = "E82035766A7DC3AC3F6B37809B251C21")
	public static final int GL_TEXTURE21 = 0x84D5;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "A4DCFBCFABB56511752992C9CC0F5DD4", hash_generated_field = "BD518C3B1A0B2D9E43F6B7C2A20DFE2F")
	public static final int GL_TEXTURE22 = 0x84D6;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "1E6141D9A885C049646CEFB2C839B7AC", hash_generated_field = "E51DAC73DF5C45484DA3FB37491A0EE5")
	public static final int GL_TEXTURE23 = 0x84D7;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "E035C4D4CFF946A33E67CB0A3B83B596", hash_generated_field = "B22E032B85EB699368B06AC87FE2B898")
	public static final int GL_TEXTURE24 = 0x84D8;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "E32773CD7031D2CB5C507B749A70D86E", hash_generated_field = "B8105530A28A057AD49118429901D7B6")
	public static final int GL_TEXTURE25 = 0x84D9;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "78F759D6424EEFA24F83E2D1F33B79C2", hash_generated_field = "4B11DEEFAF68B9BB74AC3A4FBDF965FF")
	public static final int GL_TEXTURE26 = 0x84DA;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "988A2D4E826AB8F927A8730B903F168E", hash_generated_field = "02DEAA70ADF70018857298DDA1032C62")
	public static final int GL_TEXTURE27 = 0x84DB;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "0DAB4AC47D0AF4435936C4445CAA694F", hash_generated_field = "165C9ED7F06E643264EE9C4A9240B619")
	public static final int GL_TEXTURE28 = 0x84DC;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.575 -0400", hash_original_field = "CB78ED601CBEF91891CBD57D76BE77D8", hash_generated_field = "6F3D9C17432273490A88EAA2FBA96C4E")
	public static final int GL_TEXTURE29 = 0x84DD;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "1E27BFAB12F5DB6A56CF1132406910F2", hash_generated_field = "01235E8CF92D5BA414CDD25B6604F79E")
	public static final int GL_TEXTURE30 = 0x84DE;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "FC9EA3CC4CA42A2F7F55EC63153F1982", hash_generated_field = "C8151127B3E9F7F60F918EEFDAFCC4BD")
	public static final int GL_TEXTURE31 = 0x84DF;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "893703471771D7A5A5D4015AA5128BB3", hash_generated_field = "0D42C554C0527A3A4F6ED53657A8F36A")
	public static final int GL_REPEAT = 0x2901;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "BF2C6C333138B8DABDD13F71371D6FEB", hash_generated_field = "F4270B23DBE6E082C9F3F938AAE90031")
	public static final int GL_CLAMP_TO_EDGE = 0x812F;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "CF77044D55DB5D73596A4B9E621AC42D", hash_generated_field = "1AA9A71612BBC2EB1A057F7B2F560C01")
	public static final int GL_MIRRORED_REPEAT = 0x8370;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "A9A0FF22662BDA24B06983BF4F7DB350", hash_generated_field = "D4F6E6C3CC7869488B1078BE957B9855")
	public static final int GL_FLOAT_VEC2 = 0x8B50;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "AACAE402992059F2C8F6457B1D783ED3", hash_generated_field = "4596CFDCADBD518B4A0CEBF25197C285")
	public static final int GL_FLOAT_VEC3 = 0x8B51;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "4CD16852577C4FD713ABF5BA166E2FEF", hash_generated_field = "D513EDE3FBDAF53F150324407F54BEA2")
	public static final int GL_FLOAT_VEC4 = 0x8B52;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "9AF72ADA346C5B083B054ACD889465A5", hash_generated_field = "8272459B4C9F6934811DA22F03948AE0")
	public static final int GL_INT_VEC2 = 0x8B53;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "8BA42690BD61078CCBA3DC6B9E4882A7", hash_generated_field = "42DD6770CF816C99003F923139114972")
	public static final int GL_INT_VEC3 = 0x8B54;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "44DBA0E5C2B3B7C93E11622B1557E7C3", hash_generated_field = "C98FB2BBE4B199F6345C8BB9E3F290AB")
	public static final int GL_INT_VEC4 = 0x8B55;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "05FEB5E081919FC363FD8FB578DD7C2B", hash_generated_field = "0F6051A9131131DB773BBB2973C1AD76")
	public static final int GL_BOOL = 0x8B56;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "8B29AC169A49DD14146269482FFC97D0", hash_generated_field = "3BA741C59E6EFAB0009C4B540ABDBEFB")
	public static final int GL_BOOL_VEC2 = 0x8B57;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "ED139EF89292802640667CFB45555992", hash_generated_field = "66A648E5348DB6AB126F90CD0089F32C")
	public static final int GL_BOOL_VEC3 = 0x8B58;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "71E2A3303A0EB2B21ED97F38B75AB5F4", hash_generated_field = "F149F7223B4F530AAB8367B3AE0A1CF4")
	public static final int GL_BOOL_VEC4 = 0x8B59;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "023BCCC6B8175A93FCF19FF218CF9306", hash_generated_field = "C8670E53BF4D877ED387C1919F866D21")
	public static final int GL_FLOAT_MAT2 = 0x8B5A;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "CE72CB943D5A646930A48C57756D8301", hash_generated_field = "83C24799B8C579DA33B7A210722F1E79")
	public static final int GL_FLOAT_MAT3 = 0x8B5B;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "AB9AD5B0C8CF9E005070DB19C7762BBD", hash_generated_field = "74986626AB3DB4BE4412BA930C6CC599")
	public static final int GL_FLOAT_MAT4 = 0x8B5C;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "599AC4B5368BC2A26FD6F2AFC904E846", hash_generated_field = "91C33DA2785847FB7931407B7D701133")
	public static final int GL_SAMPLER_2D = 0x8B5E;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "9E73D6A6855B2C03631FAA8CFA0F1AEC", hash_generated_field = "2D095C42DD6ACDABB067E994CB09DA00")
	public static final int GL_SAMPLER_CUBE = 0x8B60;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "D3B22D4CEAF782D600B47E71B4FC4D03", hash_generated_field = "7BA48C0379FE3B243BFEC33E61715DEE")
	public static final int GL_VERTEX_ATTRIB_ARRAY_ENABLED = 0x8622;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "F1B15B4B7CDDC32314B339406393BDEB", hash_generated_field = "9AA759A0E120AC1B42289AD7ED24664C")
	public static final int GL_VERTEX_ATTRIB_ARRAY_SIZE = 0x8623;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "5F2E559CD1F46796A8CB9D74053FF040", hash_generated_field = "3633EC14E4432B421044804FAE07E86C")
	public static final int GL_VERTEX_ATTRIB_ARRAY_STRIDE = 0x8624;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "E1526A0C13B45221742F70A7E3E94729", hash_generated_field = "5478CC37CB4E66292AD0A8105F5DF6CE")
	public static final int GL_VERTEX_ATTRIB_ARRAY_TYPE = 0x8625;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "0243AC5473BD75C856A8042BAFC6027F", hash_generated_field = "B514D95E4733BDA7BD5AD2935F382E0F")
	public static final int GL_VERTEX_ATTRIB_ARRAY_NORMALIZED = 0x886A;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "6F9F2FB8CE2F720489ED0087EEE64D03", hash_generated_field = "1420777BF9FB6EB437C4E11B8E3A5D32")
	public static final int GL_VERTEX_ATTRIB_ARRAY_POINTER = 0x8645;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "ECE996F1DDA03663DFD55DFC704FE86A", hash_generated_field = "DEA06FFD8284EC03552D7E15088F4E09")
	public static final int GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING = 0x889F;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "26E2E039D4B985509F68C3791DB777E9", hash_generated_field = "EE64262F12B8BD3E65560660094FFCC2")
	public static final int GL_IMPLEMENTATION_COLOR_READ_TYPE = 0x8B9A;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "4F8848057A70CFABDDAC4C20B62A4CAD", hash_generated_field = "838B9962B2D1332F46FFA23E5542F508")
	public static final int GL_IMPLEMENTATION_COLOR_READ_FORMAT = 0x8B9B;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "11A98E573EB1D0001BA277F9E985F9E4", hash_generated_field = "9F41E039736AABEFE1A573BC5BBD5695")
	public static final int GL_COMPILE_STATUS = 0x8B81;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "811D408F2B4304A9FE83893DDD269882", hash_generated_field = "E03BE42CFFC8CAC4578CDA8454531223")
	public static final int GL_INFO_LOG_LENGTH = 0x8B84;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "D974FD60DB3C014169AB7999B80813E5", hash_generated_field = "6DDD1F189FB16E97384CFC954B069C1B")
	public static final int GL_SHADER_SOURCE_LENGTH = 0x8B88;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "BC0946D1278EF22631EDA1513CE1A550", hash_generated_field = "F8085B8FA2A40E62A7A7564602688991")
	public static final int GL_SHADER_COMPILER = 0x8DFA;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "420016783A8C348FC2392EADB8DF80A2", hash_generated_field = "271E6BDD652F6762D928C8F3B4469F48")
	public static final int GL_SHADER_BINARY_FORMATS = 0x8DF8;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "21E683A49A416961340035FD879DF4CB", hash_generated_field = "66C70D901C57CD92EEB78E8C290A5D45")
	public static final int GL_NUM_SHADER_BINARY_FORMATS = 0x8DF9;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "53C56C9099AEAD451768225F904C5111", hash_generated_field = "BD5BD53920B23FAD2E8F7DD65EDDB6CC")
	public static final int GL_LOW_FLOAT = 0x8DF0;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "2F1469D2A34C289049F4478EA0122410", hash_generated_field = "94BE1C0FE932CFCE28F672B92B143981")
	public static final int GL_MEDIUM_FLOAT = 0x8DF1;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "016B49083223BC0483DE57833B76173F", hash_generated_field = "41417F8914E0ECE1B7EB2CF58E55CD24")
	public static final int GL_HIGH_FLOAT = 0x8DF2;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "911804BCA7CAA350A436D73738BC7545", hash_generated_field = "E2FAB47609BD087C1A6D4A8D66747366")
	public static final int GL_LOW_INT = 0x8DF3;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "1347909A38EEC53B75D972F68C9E9146", hash_generated_field = "A79469BB2D72F8E59B1AAD1E59F50103")
	public static final int GL_MEDIUM_INT = 0x8DF4;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "1F02FB343970DC795513FA1FC4444BB7", hash_generated_field = "7E13FD38818174F274AACF552685115D")
	public static final int GL_HIGH_INT = 0x8DF5;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "7BB0ACBEFFCD95E7782566F85CF0B24B", hash_generated_field = "C0FA865008C29096F291EFA49891FCDE")
	public static final int GL_FRAMEBUFFER = 0x8D40;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "FAD50A8C6338C6E1D6A3705E2E2A7096", hash_generated_field = "34F15D62A50F317EDEECEF55FC8CD378")
	public static final int GL_RENDERBUFFER = 0x8D41;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.576 -0400", hash_original_field = "6F1BC01401EBAFBDAB104F5B553C9C8F", hash_generated_field = "F1E976B161BD16A999C5EE1E1F0CF686")
	public static final int GL_RGBA4 = 0x8056;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.577 -0400", hash_original_field = "1BC3439182988384A0387C0DAE5F4122", hash_generated_field = "4B46C174836B400D904CAE12C46CDCD6")
	public static final int GL_RGB5_A1 = 0x8057;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.577 -0400", hash_original_field = "6DF7A05206E14A1F6D16871D727806C7", hash_generated_field = "920663D50953507C6C8FC97361EE76A5")
	public static final int GL_RGB565 = 0x8D62;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.577 -0400", hash_original_field = "B03BACF8C74D97D15453D254233DE579", hash_generated_field = "DA33D949DEC63FA48CC4A0DBBF0FD14E")
	public static final int GL_DEPTH_COMPONENT16 = 0x81A5;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.577 -0400", hash_original_field = "634050B3D1EAAA38215AAFE9DFF40692", hash_generated_field = "2343847FF61B3FEC316821DE195C2A31")
	public static final int GL_STENCIL_INDEX = 0x1901;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.577 -0400", hash_original_field = "6DF60412BA3400D88E915D98F42042FD", hash_generated_field = "D5B4DB8CCB87B2981298CB5A38127535")
	public static final int GL_STENCIL_INDEX8 = 0x8D48;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.577 -0400", hash_original_field = "BEFF1A9D4E8153F950AD6E70FD08FDBF", hash_generated_field = "75864392B783E085A4CFF6EB00C10359")
	public static final int GL_RENDERBUFFER_WIDTH = 0x8D42;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.577 -0400", hash_original_field = "EF69F589C166415CB9773FADDC97A6EC", hash_generated_field = "36D4AEE42CF64175E814E979A92E4EDF")
	public static final int GL_RENDERBUFFER_HEIGHT = 0x8D43;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.577 -0400", hash_original_field = "B2BAA445214DA024329DD8D9C96A6110", hash_generated_field = "E578E6ABBD143F5ACEFD8B86FB529F28")
	public static final int GL_RENDERBUFFER_INTERNAL_FORMAT = 0x8D44;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.577 -0400", hash_original_field = "E3A37D37BB2FE8A4CB2CBDA2D9776B88", hash_generated_field = "3BE75E97AE116A9CF526572E5032F95C")
	public static final int GL_RENDERBUFFER_RED_SIZE = 0x8D50;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.577 -0400", hash_original_field = "7CCCC4531F96E8C77ECEF810A86CA5E2", hash_generated_field = "D76A65CB3EC52B363F8E42E7F644DA18")
	public static final int GL_RENDERBUFFER_GREEN_SIZE = 0x8D51;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.577 -0400", hash_original_field = "32F7F88C8C0505AFF79585806E7EDA84", hash_generated_field = "0B4D267B9FA24858FADE43F0A33A6D61")
	public static final int GL_RENDERBUFFER_BLUE_SIZE = 0x8D52;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.577 -0400", hash_original_field = "25A5E3B263F5990463D175FC851859AD", hash_generated_field = "A87E3AB9C3F684A849790959B5AFC9B2")
	public static final int GL_RENDERBUFFER_ALPHA_SIZE = 0x8D53;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.577 -0400", hash_original_field = "77C72A4C774278E29FF1D0C60EB80E81", hash_generated_field = "4A61F358C6F6474925F129C155859795")
	public static final int GL_RENDERBUFFER_DEPTH_SIZE = 0x8D54;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.577 -0400", hash_original_field = "363330FD655F8EFD8B5B4ECC3F4A416C", hash_generated_field = "6CF3B82492F8006AE36F9C01135C5290")
	public static final int GL_RENDERBUFFER_STENCIL_SIZE = 0x8D55;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.577 -0400", hash_original_field = "38D8EA492885ACB73FBA9702D507FCB2", hash_generated_field = "D639E10A395D0273D3E79301FBC52FCD")
	public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE = 0x8CD0;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.577 -0400", hash_original_field = "A2B680632060DD381EF06CE794F71B5D", hash_generated_field = "6DBFC82CA13D6EC2F8A368E347F54544")
	public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME = 0x8CD1;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.577 -0400", hash_original_field = "D154FF186B35B0DDE5D96DAD82A2579E", hash_generated_field = "B7E17CBFB0AF5284769AD4D30028C0BC")
	public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL = 0x8CD2;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.577 -0400", hash_original_field = "780D0058F8174ED63AF01199DDD518E1", hash_generated_field = "7E7D65BB9DE23F1EE30EFDFDB79DEC8B")
	public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE = 0x8CD3;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.577 -0400", hash_original_field = "2186AB99265BD95A3774EDC4DEB7A612", hash_generated_field = "1841ED5A213CE867A8922E41D552AB3C")
	public static final int GL_COLOR_ATTACHMENT0 = 0x8CE0;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.577 -0400", hash_original_field = "B2CA5751EF204959BAC64146593B4E6F", hash_generated_field = "7FFD97E4ED3AA778308B5DC5E4C58C93")
	public static final int GL_DEPTH_ATTACHMENT = 0x8D00;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.577 -0400", hash_original_field = "D563743A495D73A0BF155EED2B8CB31E", hash_generated_field = "D1B192D07DA81762E4DD838197524765")
	public static final int GL_STENCIL_ATTACHMENT = 0x8D20;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.577 -0400", hash_original_field = "63C2D94BB12E0216B30F7D65744D89DD", hash_generated_field = "573A426131903C8A701C32864565E60B")
	public static final int GL_NONE = 0;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.577 -0400", hash_original_field = "AD0EB696333658DB0EFF21C1FE31AD48", hash_generated_field = "105CAF398E8B836BE20034169C8F9BA2")
	public static final int GL_FRAMEBUFFER_COMPLETE = 0x8CD5;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.577 -0400", hash_original_field = "BA8E2C1A31684E49A739D401567E71A7", hash_generated_field = "6020412D1FB2D2C42528245C0E277D7B")
	public static final int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT = 0x8CD6;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.577 -0400", hash_original_field = "828321B1B2E8AB47D14CD374E75FE8D1", hash_generated_field = "A779BA675B1FD53D3331DA67A0B4A4EF")
	public static final int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT = 0x8CD7;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.577 -0400", hash_original_field = "BBAA01AA8E1FC1E8210F7F975CA0775D", hash_generated_field = "FD5AD67D44E5E92889277573D8F6098F")
	public static final int GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS = 0x8CD9;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.577 -0400", hash_original_field = "4ACDBCD489C6240413496C1474B8BA65", hash_generated_field = "C959FE19D0D108FEA8CE34EE498DAE74")
	public static final int GL_FRAMEBUFFER_UNSUPPORTED = 0x8CDD;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.577 -0400", hash_original_field = "1B26C5B7F5A97B16B378679147EF4571", hash_generated_field = "50598C7C9FB2D0FDAAB2295022EE9788")
	public static final int GL_FRAMEBUFFER_BINDING = 0x8CA6;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.577 -0400", hash_original_field = "3E26BC9205FFB14E7C46AB7A9CDD2641", hash_generated_field = "D8F98CCCC88EDDD662E4F18B953CA78A")
	public static final int GL_RENDERBUFFER_BINDING = 0x8CA7;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.577 -0400", hash_original_field = "A7B5D9C27D9F8715FF7C430F6281BBDD", hash_generated_field = "4CA7363BD58B00F29CA855F161E8BF6F")
	public static final int GL_MAX_RENDERBUFFER_SIZE = 0x84E8;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.577 -0400", hash_original_field = "F2933C88801A36EF379D95207B510AAA", hash_generated_field = "B1140C120DA2B82895757FDB24797CC0")
	public static final int GL_INVALID_FRAMEBUFFER_OPERATION = 0x0506;
	static {
		_nativeClassInit();
	}

}
