package android.view;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;




public abstract class HardwareCanvas extends Canvas {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.414 -0400", hash_original_method = "B9875B3DDCC23B593D0FCAB83616982C", hash_generated_method = "B9875B3DDCC23B593D0FCAB83616982C")
    public HardwareCanvas ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.414 -0400", hash_original_method = "BD882F06CCC6AC9974E10A9883BC45CA", hash_generated_method = "32D0010EFAD0960CA2AF0CE769CE07C5")
    @Override
    public boolean isHardwareAccelerated() {
        boolean varB326B5062B2F0E69046810717534CB09_635942841 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_16266688 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_16266688;
        // ---------- Original Method ----------
        //return true;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.414 -0400", hash_original_method = "09BF352B013BE09D7407EC81EDFAD3C9", hash_generated_method = "7462F96BF1C63630B7D25EC3C339A546")
    @Override
    public void setBitmap(Bitmap bitmap) {
        addTaint(bitmap.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1936478601 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1936478601.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1936478601;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SAFE)
    abstract void onPreDraw(Rect dirty);

    
    @DSModeled(DSC.SAFE)
    abstract void onPostDraw();

    
    @DSModeled(DSC.SAFE)
    abstract boolean drawDisplayList(DisplayList displayList, int width, int height, Rect dirty);

    
    @DSModeled(DSC.SAFE)
    abstract void outputDisplayList(DisplayList displayList);

    
    @DSModeled(DSC.SAFE)
    abstract void drawHardwareLayer(HardwareLayer layer, float x, float y, Paint paint);

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.416 -0400", hash_original_method = "0FE8E55D6D4280D2FC5B882C82F13271", hash_generated_method = "F5E0E18D1F71B3D61E7E551BE94BFB72")
    public boolean callDrawGLFunction(int drawGLFunction) {
        addTaint(drawGLFunction);
        boolean var68934A3E9455FA72420237EB05902327_763373228 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_422251858 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_422251858;
        // ---------- Original Method ----------
        //return false;
    }

    
}

