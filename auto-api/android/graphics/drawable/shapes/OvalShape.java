package android.graphics.drawable.shapes;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Canvas;
import android.graphics.Paint;

public class OvalShape extends RectShape {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:13:25.835 -0400", hash_original_method = "A39F39BCABED7B932265F8CF61962720", hash_generated_method = "6E765B63E0EEB35E78D63B7FED38F817")
    @DSModeled(DSC.SAFE)
    public OvalShape() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-12 11:10:59.291 -0400",hash_original_method="13801347121740510DC8997A2082C7EE",hash_generated_method="313FEFC8965FE40301AEA1FB713CF5A9")
@Override
    public void draw(Canvas canvas, Paint paint) {
        dsTaint.addTaint(canvas.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        canvas.drawOval(rect(), paint);
        // ---------- Original Method ----------
        //canvas.drawOval(rect(), paint);
    }

    
}


