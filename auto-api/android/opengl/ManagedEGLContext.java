package android.opengl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    EGLContext mContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.305 -0400", hash_original_method = "9D266735F37ADE970716DE5C813A7490", hash_generated_method = "767E122B1A6AF139B793945643282773")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.306 -0400", hash_original_method = "0BA5CAD8B17303B4C3A912EF0F9065A7", hash_generated_method = "7625AB1D754B02E35F44925BCAD262A7")
    @DSModeled(DSC.SAFE)
    public EGLContext getContext() {
        return (EGLContext)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.306 -0400", hash_original_method = "3A3C884C8DD72479D5B7016BF0489D57", hash_generated_method = "418519E6B0AAFC40765D5AFF890A67AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void terminate() {
        execTerminate();
        // ---------- Original Method ----------
        //execTerminate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.306 -0400", hash_original_method = "B8E737E7A559452A0DBE946D6943CE60", hash_generated_method = "B6770F67CF9038CAE7126511421AF7E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void execTerminate() {
        onTerminate(mContext);
        // ---------- Original Method ----------
        //onTerminate(mContext);
    }

    
    public abstract void onTerminate(EGLContext context);

    
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

    
    static final String TAG = "ManagedEGLContext";
    static final ArrayList<ManagedEGLContext> sActive = new ArrayList<ManagedEGLContext>();
}

