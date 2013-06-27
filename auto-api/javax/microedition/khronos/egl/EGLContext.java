package javax.microedition.khronos.egl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.microedition.khronos.opengles.GL;

public abstract class EGLContext {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.006 -0400", hash_original_method = "08AE013F5F70C27B6C3BCCA082C95AAF", hash_generated_method = "08AE013F5F70C27B6C3BCCA082C95AAF")
    public EGLContext ()
    {
        //Synthesized constructor
    }


        public static EGL getEGL() {
        return EGL_INSTANCE;
    }

    
    public abstract GL getGL();

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.007 -0400", hash_original_field = "8FA0140371A1967018E732A94D26DE99", hash_generated_field = "36FAA6302B2748469CF1235878C79F9C")

    private static EGL EGL_INSTANCE = new com.google.android.gles_jni.EGLImpl();
}

