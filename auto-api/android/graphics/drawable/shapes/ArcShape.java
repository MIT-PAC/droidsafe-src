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

public class ArcShape extends RectShape {
    private float mStart;
    private float mSweep;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:13:25.704 -0400", hash_original_method = "3444E7C7C3D119A4AD66CBA8E6A98FE3", hash_generated_method = "877F8B874A6A40F692E9CA728FC2BA3D")
    @DSModeled(DSC.SAFE)
    public ArcShape(float startAngle, float sweepAngle) {
        dsTaint.addTaint(startAngle);
        dsTaint.addTaint(sweepAngle);
        // ---------- Original Method ----------
        //mStart = startAngle;
        //mSweep = sweepAngle;
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-12 11:10:59.253 -0400",hash_original_method="642984509625E500EEAAF4D2000D590E",hash_generated_method="FFFA2A7823795393CBC0AF0027EF5042")
@Override
    public void draw(Canvas canvas, Paint paint) {
        dsTaint.addTaint(canvas.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        canvas.drawArc(rect(), mStart, mSweep, true, paint);
        // ---------- Original Method ----------
        //canvas.drawArc(rect(), mStart, mSweep, true, paint);
    }

    
}


