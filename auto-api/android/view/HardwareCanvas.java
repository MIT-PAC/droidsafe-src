package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public abstract class HardwareCanvas extends Canvas {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.407 -0400", hash_original_method = "B9875B3DDCC23B593D0FCAB83616982C", hash_generated_method = "B9875B3DDCC23B593D0FCAB83616982C")
    public HardwareCanvas ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.407 -0400", hash_original_method = "BD882F06CCC6AC9974E10A9883BC45CA", hash_generated_method = "A194DACC76F2CF4E1BC37E8FD7D6C740")
    @Override
    public boolean isHardwareAccelerated() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1065045965 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1065045965;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.408 -0400", hash_original_method = "09BF352B013BE09D7407EC81EDFAD3C9", hash_generated_method = "BF1514EE48C976A7758AB254865300FC")
    @Override
    public void setBitmap(Bitmap bitmap) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(bitmap.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    abstract void onPreDraw(Rect dirty);

    
    abstract void onPostDraw();

    
    abstract boolean drawDisplayList(DisplayList displayList, int width, int height, Rect dirty);

    
    abstract void outputDisplayList(DisplayList displayList);

    
    abstract void drawHardwareLayer(HardwareLayer layer, float x, float y, Paint paint);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.410 -0400", hash_original_method = "0FE8E55D6D4280D2FC5B882C82F13271", hash_generated_method = "FD3F6815547E51FAD1A512ABB1652142")
    public boolean callDrawGLFunction(int drawGLFunction) {
        addTaint(drawGLFunction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1335516531 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1335516531;
        // ---------- Original Method ----------
        //return false;
    }

    
}

