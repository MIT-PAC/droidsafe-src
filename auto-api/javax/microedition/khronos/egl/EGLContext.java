package javax.microedition.khronos.egl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import javax.microedition.khronos.opengles.GL;

public abstract class EGLContext {
    private static final EGL EGL_INSTANCE = new com.google.android.gles_jni.EGLImpl();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.446 -0400", hash_original_method = "A38BB8AE655083CDE71FC7D7CD4EC6EF", hash_generated_method = "C154498B914B890373921455D4329D8F")
    public static EGL getEGL() {
        return EGL_INSTANCE;
    }

    
    public abstract GL getGL();

    
}


