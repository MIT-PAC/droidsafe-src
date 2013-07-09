package javax.microedition.khronos.egl;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.microedition.khronos.opengles.GL;

public abstract class EGLContext {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.382 -0400", hash_original_method = "08AE013F5F70C27B6C3BCCA082C95AAF", hash_generated_method = "08AE013F5F70C27B6C3BCCA082C95AAF")
    public EGLContext ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    public static EGL getEGL() {
        return EGL_INSTANCE;
    }

    
    public abstract GL getGL();

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.383 -0400", hash_original_field = "8FA0140371A1967018E732A94D26DE99", hash_generated_field = "056C93062C94570DFC3A7503366DEEE2")

    private static final EGL EGL_INSTANCE = new com.google.android.gles_jni.EGLImpl();
}

