package android.graphics.drawable.shapes;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class RectShape extends Shape {
    private RectF mRect = new RectF();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.717 -0400", hash_original_method = "86D7394A029CE4FDE438585868C447F4", hash_generated_method = "296628B3E8AE7C2CA6ACF988628F6E64")
    @DSModeled(DSC.SAFE)
    public RectShape() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.717 -0400", hash_original_method = "6BDD25C71E92DEE23AC033397583FF85", hash_generated_method = "FE08FFA4BA3BF3826393C81531C98BDD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void draw(Canvas canvas, Paint paint) {
        dsTaint.addTaint(canvas.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        canvas.drawRect(mRect, paint);
        // ---------- Original Method ----------
        //canvas.drawRect(mRect, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.717 -0400", hash_original_method = "62B0D2225FCA5D4099BD1D1E514DF479", hash_generated_method = "104BB154C77E61CCBDF7FFF209990C68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onResize(float width, float height) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        mRect.set(0, 0, width, height);
        // ---------- Original Method ----------
        //mRect.set(0, 0, width, height);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.718 -0400", hash_original_method = "B472369E445B34AFDD84E5B389A9601D", hash_generated_method = "0AF1F989EAFB92B8D95A77BE784178AD")
    @DSModeled(DSC.SAFE)
    protected final RectF rect() {
        return (RectF)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mRect;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.718 -0400", hash_original_method = "F35F96D345FDD22204E61750D42DDCE2", hash_generated_method = "9B3A3BB486848B8614A097AAAD72A3F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public RectShape clone() throws CloneNotSupportedException {
        RectShape shape;
        shape = (RectShape) super.clone();
        shape.mRect = new RectF(mRect);
        return (RectShape)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final RectShape shape = (RectShape) super.clone();
        //shape.mRect = new RectF(mRect);
        //return shape;
    }

    
}

