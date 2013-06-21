package javax.microedition.khronos.egl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.microedition.khronos.opengles.GL;

public abstract class EGLContext {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.007 -0400", hash_original_method = "2470AE6AF91AC6F20E3E72FC26F6F30F", hash_generated_method = "2470AE6AF91AC6F20E3E72FC26F6F30F")
        public EGLContext ()
    {
    }


        public static EGL getEGL() {
        return EGL_INSTANCE;
    }

    
    public abstract GL getGL();

    
    private static final EGL EGL_INSTANCE = new com.google.android.gles_jni.EGLImpl();
}

