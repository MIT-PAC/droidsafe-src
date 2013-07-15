package android.opengl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Writer;
import javax.microedition.khronos.egl.EGL;
import javax.microedition.khronos.opengles.GL;

public class GLDebugHelper {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.188 -0400", hash_original_method = "E7190AE5B0A4A36A0341193EE8AF97D9", hash_generated_method = "E7190AE5B0A4A36A0341193EE8AF97D9")
    public GLDebugHelper ()
    {
        //Synthesized constructor
    }


        public static GL wrap(GL gl, int configFlags, Writer log) {
        if ( configFlags != 0 ) {
            gl = new GLErrorWrapper(gl, configFlags);
        }
        if ( log != null ) {
            boolean logArgumentNames =
                (CONFIG_LOG_ARGUMENT_NAMES & configFlags) != 0;
            gl = new GLLogWrapper(gl, log, logArgumentNames);
        }
        return gl;
    }

    
        public static EGL wrap(EGL egl, int configFlags, Writer log) {
        if (log != null) {
            egl = new EGLLogWrapper(egl, configFlags, log);
        }
        return egl;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.189 -0400", hash_original_field = "BCD1C5C7A474642FC56A6EAB339737A3", hash_generated_field = "1D60AA5F88AFE3249F9506BA7A98D18D")

    public static final int CONFIG_CHECK_GL_ERROR = (1 << 0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.189 -0400", hash_original_field = "B40E64B2CB3E8DDBC500008FC519F654", hash_generated_field = "EAA855F37701CDB86B5D8770295B9F3D")

    public static final int CONFIG_CHECK_THREAD = (1 << 1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.189 -0400", hash_original_field = "FD61D53E208E91CC3F48B56007284381", hash_generated_field = "D09C1D12C10A5C76CA8C4E7F70BE1743")

    public static final int CONFIG_LOG_ARGUMENT_NAMES = (1 << 2);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.189 -0400", hash_original_field = "E4392FD48E83B39959631FA4FEDEC15D", hash_generated_field = "B10B5B91E743ADE3F0E13FBD502DB184")

    public static final int ERROR_WRONG_THREAD = 0x7000;
}

