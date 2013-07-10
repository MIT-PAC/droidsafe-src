package android.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
        public BadSurfaceTypeException() {
        }

        public BadSurfaceTypeException(String name) {
            super(name);
        }
    }

    
    public interface Callback {
        
        public void surfaceCreated(SurfaceHolder holder);

        
        public void surfaceChanged(SurfaceHolder holder, int format, int width,
                int height);

        
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
