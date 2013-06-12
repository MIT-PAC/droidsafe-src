package android.opengl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import static javax.microedition.khronos.egl.EGL10.EGL_DEFAULT_DISPLAY;
import static javax.microedition.khronos.egl.EGL10.EGL_NO_DISPLAY;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import android.os.Looper;
import android.util.Log;
import com.google.android.gles_jni.EGLImpl;

public abstract class ManagedEGLContext {
    static final String TAG = "ManagedEGLContext";
    static final ArrayList<ManagedEGLContext> sActive = new ArrayList<ManagedEGLContext>();
    final EGLContext mContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.508 -0400", hash_original_method = "9D266735F37ADE970716DE5C813A7490", hash_generated_method = "AE71F2325D6682519AFF9C65F4505BF1")
    @DSModeled(DSC.SAFE)
    public ManagedEGLContext(EGLContext context) {
        dsTaint.addTaint(context.dsTaint);
        {
            sActive.add(this);
        } //End block
        // ---------- Original Method ----------
        //mContext = context;
        //synchronized (sActive) {
            //sActive.add(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.509 -0400", hash_original_method = "0BA5CAD8B17303B4C3A912EF0F9065A7", hash_generated_method = "CDBBBA9BBAE37203DA8A714079149201")
    @DSModeled(DSC.SAFE)
    public EGLContext getContext() {
        return (EGLContext)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.509 -0400", hash_original_method = "3A3C884C8DD72479D5B7016BF0489D57", hash_generated_method = "8C4EE93F3AD81D3C3595DE05AAD5401B")
    @DSModeled(DSC.SAFE)
    public void terminate() {
        execTerminate();
        // ---------- Original Method ----------
        //execTerminate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.509 -0400", hash_original_method = "B8E737E7A559452A0DBE946D6943CE60", hash_generated_method = "E5E27514A9D1172F74ADB70029BC850D")
    @DSModeled(DSC.SAFE)
     void execTerminate() {
        onTerminate(mContext);
        // ---------- Original Method ----------
        //onTerminate(mContext);
    }

    
    public abstract void onTerminate(EGLContext context);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.509 -0400", hash_original_method = "5D3101613FD0E07F1B5669C4B02EC8F5", hash_generated_method = "079BC8F35727E6A494293F43D18760DE")
    public static boolean doTerminate() {
        ArrayList<ManagedEGLContext> active;
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("Called on wrong thread");
        }
        synchronized (sActive) {
            if (sActive.size() <= 0) {
                return false;
            }
            EGL10 egl = (EGL10) EGLContext.getEGL();
            EGLDisplay display = egl.eglGetDisplay(EGL_DEFAULT_DISPLAY);
            if (display == EGL_NO_DISPLAY) {
                Log.w(TAG, "doTerminate failed: no display");
                return false;
            }
            if (EGLImpl.getInitCount(display) != sActive.size()) {
                Log.w(TAG, "doTerminate failed: EGL count is " + EGLImpl.getInitCount(display)
                        + " but managed count is " + sActive.size());
                return false;
            }
            active = new ArrayList<ManagedEGLContext>(sActive);
            sActive.clear();
        }
        for (int i = 0; i < active.size(); i++) {
            active.get(i).execTerminate();
        }
        return true;
    }

    
}


