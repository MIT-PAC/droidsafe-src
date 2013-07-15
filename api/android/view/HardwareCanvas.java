package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public abstract class HardwareCanvas extends Canvas {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.215 -0400", hash_original_method = "B9875B3DDCC23B593D0FCAB83616982C", hash_generated_method = "B9875B3DDCC23B593D0FCAB83616982C")
    public HardwareCanvas ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.216 -0400", hash_original_method = "BD882F06CCC6AC9974E10A9883BC45CA", hash_generated_method = "BF4B8BF2B77C6E5242041DB0D943D715")
    @Override
    public boolean isHardwareAccelerated() {
        boolean varB326B5062B2F0E69046810717534CB09_1440255430 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_5135917 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_5135917;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.216 -0400", hash_original_method = "09BF352B013BE09D7407EC81EDFAD3C9", hash_generated_method = "C28BC27DFF41A23D3F8C6210902632D2")
    @Override
    public void setBitmap(Bitmap bitmap) {
        addTaint(bitmap.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1524000093 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1524000093.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1524000093;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    abstract void onPreDraw(Rect dirty);

    
    abstract void onPostDraw();

    
    abstract boolean drawDisplayList(DisplayList displayList, int width, int height, Rect dirty);

    
    abstract void outputDisplayList(DisplayList displayList);

    
    abstract void drawHardwareLayer(HardwareLayer layer, float x, float y, Paint paint);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.217 -0400", hash_original_method = "0FE8E55D6D4280D2FC5B882C82F13271", hash_generated_method = "D5AA286EE2D5379B4F1BCA85C2AC4109")
    public boolean callDrawGLFunction(int drawGLFunction) {
        addTaint(drawGLFunction);
        boolean var68934A3E9455FA72420237EB05902327_1600066036 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_731246448 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_731246448;
        // ---------- Original Method ----------
        //return false;
    }

    
}

