package android.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public abstract class HardwareCanvas extends Canvas {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.433 -0400", hash_original_method = "B9875B3DDCC23B593D0FCAB83616982C", hash_generated_method = "B9875B3DDCC23B593D0FCAB83616982C")
    public HardwareCanvas ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.433 -0400", hash_original_method = "BD882F06CCC6AC9974E10A9883BC45CA", hash_generated_method = "CAE08316648F95666AFE312E89C2E187")
    @Override
    public boolean isHardwareAccelerated() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1655197646 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1655197646;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.434 -0400", hash_original_method = "09BF352B013BE09D7407EC81EDFAD3C9", hash_generated_method = "BF1514EE48C976A7758AB254865300FC")
    @Override
    public void setBitmap(Bitmap bitmap) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(bitmap.getTaint());
        
        
    }

    
    abstract void onPreDraw(Rect dirty);

    
    abstract void onPostDraw();

    
    abstract boolean drawDisplayList(DisplayList displayList, int width, int height, Rect dirty);

    
    abstract void outputDisplayList(DisplayList displayList);

    
    abstract void drawHardwareLayer(HardwareLayer layer, float x, float y, Paint paint);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.435 -0400", hash_original_method = "0FE8E55D6D4280D2FC5B882C82F13271", hash_generated_method = "5D6B72256A0BCF7D23B6794DF677C924")
    public boolean callDrawGLFunction(int drawGLFunction) {
        addTaint(drawGLFunction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1937969822 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1937969822;
        
        
    }

    
}

