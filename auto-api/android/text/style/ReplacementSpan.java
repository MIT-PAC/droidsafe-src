package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.graphics.Paint;
import android.graphics.Canvas;
import android.text.TextPaint;

public abstract class ReplacementSpan extends MetricAffectingSpan {
    
    public abstract int getSize(Paint paint, CharSequence text,
                         int start, int end,
                         Paint.FontMetricsInt fm);

    
    public abstract void draw(Canvas canvas, CharSequence text,
                     int start, int end, float x,
                     int top, int y, int bottom, Paint paint);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.311 -0400", hash_original_method = "A699A8F3838B8D034AE05CD71CC1E03F", hash_generated_method = "CADF7F784DEC46AEAB4A84D4A6BAB717")
    @DSModeled(DSC.SAFE)
    public void updateMeasureState(TextPaint p) {
        dsTaint.addTaint(p.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.311 -0400", hash_original_method = "38B7676DEF6A1A947DFBA6BCAE88FB2B", hash_generated_method = "4454E40F06AEF2F35557292995D29970")
    @DSModeled(DSC.SAFE)
    public void updateDrawState(TextPaint ds) {
        dsTaint.addTaint(ds.dsTaint);
        // ---------- Original Method ----------
    }

    
}


