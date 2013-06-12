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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:13:25.984 -0400", hash_original_method = "86D7394A029CE4FDE438585868C447F4", hash_generated_method = "756EBC629250EA51E732010EE61907C4")
    @DSModeled(DSC.SAFE)
    public RectShape() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:13:28.502 -0400", hash_original_method = "6BDD25C71E92DEE23AC033397583FF85", hash_generated_method = "F12CF724CC698428EBC2EE14E75E2DED")
    @DSModeled(DSC.SAFE)
    @Override
    public void draw(Canvas canvas, Paint paint) {
        dsTaint.addTaint(canvas.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        canvas.drawRect(mRect, paint);
        // ---------- Original Method ----------
        //canvas.drawRect(mRect, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:13:28.526 -0400", hash_original_method = "62B0D2225FCA5D4099BD1D1E514DF479", hash_generated_method = "B125ED5DCBD2B0D810475A08D498A2A2")
    @DSModeled(DSC.SAFE)
    @Override
    protected void onResize(float width, float height) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        mRect.set(0, 0, width, height);
        // ---------- Original Method ----------
        //mRect.set(0, 0, width, height);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:13:28.532 -0400", hash_original_method = "B472369E445B34AFDD84E5B389A9601D", hash_generated_method = "CC3BEC95F550E16A2F7FC15DF5CC013F")
    @DSModeled(DSC.SAFE)
    protected final RectF rect() {
        return (RectF)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mRect;
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-12 11:10:59.645 -0400",hash_original_method="F35F96D345FDD22204E61750D42DDCE2",hash_generated_method="30A2C0AFE0B24F23652468FA85E023F4")
@Override
    public RectShape clone() throws CloneNotSupportedException {
        final RectShape shape;
        shape = (RectShape) super.clone();
        shape.mRect = new RectF(mRect);
        return (RectShape)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final RectShape shape = (RectShape) super.clone();
        //shape.mRect = new RectF(mRect);
        //return shape;
    }

    
}


