package javax.microedition.khronos.egl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.microedition.khronos.opengles.GL;

public abstract class EGLContext {
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:57.229 -0500", hash_original_method = "A38BB8AE655083CDE71FC7D7CD4EC6EF", hash_generated_method = "C154498B914B890373921455D4329D8F")
    
public static EGL getEGL() {
        return EGL_INSTANCE;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:57.227 -0500", hash_original_field = "F0AFBDA9DA008D334F68162D65B650FA", hash_generated_field = "056C93062C94570DFC3A7503366DEEE2")

    private static final EGL EGL_INSTANCE = new com.google.android.gles_jni.EGLImpl();
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.456 -0400", hash_original_method = "08AE013F5F70C27B6C3BCCA082C95AAF", hash_generated_method = "08AE013F5F70C27B6C3BCCA082C95AAF")
    public EGLContext ()
    {
        //Synthesized constructor
    }

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:57.232 -0500", hash_original_method = "42CEDADA007B69E4214C0FDBBFC7F329", hash_generated_method = "D197F5844659FA4B7A41BD456BA1B661")
    
public abstract GL getGL();
}

