package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.graphics.Canvas;
import android.graphics.Rect;

public interface SurfaceHolder {

    
    @Deprecated
    public static final int SURFACE_TYPE_NORMAL = 0;
    
    @Deprecated
    public static final int SURFACE_TYPE_HARDWARE = 1;
    
    @Deprecated
    public static final int SURFACE_TYPE_GPU = 2;
    
    @Deprecated
    public static final int SURFACE_TYPE_PUSH_BUFFERS = 3;

    
    public static class BadSurfaceTypeException extends RuntimeException {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.840 -0500", hash_original_method = "5B711042C26083732A0FE1DD39275FD8", hash_generated_method = "FD7DD460BCB3D7623A5171C48B4F08E5")
        
public BadSurfaceTypeException() {
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.843 -0500", hash_original_method = "548B66E802408B549443C0031F038236", hash_generated_method = "B26C9C0F99ED3B0153CF9DE48E3B5F31")
        
public BadSurfaceTypeException(String name) {
            super(name);
        }
    }

    
    public interface Callback {
        @DSVerified("Callback modeled")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void surfaceCreated(SurfaceHolder holder);

        @DSVerified("Callback modeled")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void surfaceChanged(SurfaceHolder holder, int format, int width,
                int height);

        @DSVerified("Callback modeled")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void surfaceDestroyed(SurfaceHolder holder);
    }

    
    public interface Callback2 extends Callback {
        
        public void surfaceRedrawNeeded(SurfaceHolder holder);
    }

    
    public void addCallback(Callback callback);

    
    public void removeCallback(Callback callback);

    
    public boolean isCreating();
    
    
    @Deprecated
    public void setType(int type);

    
    public void setFixedSize(int width, int height);

    
    public void setSizeFromLayout();

    
    public void setFormat(int format);

    
    public void setKeepScreenOn(boolean screenOn);
    
    
    public Canvas lockCanvas();

    
    
    public Canvas lockCanvas(Rect dirty);

    
    public void unlockCanvasAndPost(Canvas canvas);

    
    public Rect getSurfaceFrame();

    
    public Surface getSurface();
    
}
