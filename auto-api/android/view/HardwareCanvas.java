package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public abstract class HardwareCanvas extends Canvas {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.979 -0400", hash_original_method = "BD882F06CCC6AC9974E10A9883BC45CA", hash_generated_method = "0A2900992B7E68F119D00C54B826E567")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isHardwareAccelerated() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.979 -0400", hash_original_method = "09BF352B013BE09D7407EC81EDFAD3C9", hash_generated_method = "1C41DE8B6BE5AE0839481E7FC5E1BB3F")
    @DSModeled(DSC.SAFE)
    @Override
    public void setBitmap(Bitmap bitmap) {
        dsTaint.addTaint(bitmap.dsTaint);
        throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    abstract void onPreDraw(Rect dirty);

    
    abstract void onPostDraw();

    
    abstract boolean drawDisplayList(DisplayList displayList, int width, int height, Rect dirty);

    
    abstract void outputDisplayList(DisplayList displayList);

    
    abstract void drawHardwareLayer(HardwareLayer layer, float x, float y, Paint paint);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.980 -0400", hash_original_method = "0FE8E55D6D4280D2FC5B882C82F13271", hash_generated_method = "CC36DB763A92103F8F7312318E05E580")
    @DSModeled(DSC.SAFE)
    public boolean callDrawGLFunction(int drawGLFunction) {
        dsTaint.addTaint(drawGLFunction);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
}


