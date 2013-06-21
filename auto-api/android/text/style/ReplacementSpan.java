package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.text.TextPaint;

public abstract class ReplacementSpan extends MetricAffectingSpan {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.909 -0400", hash_original_method = "AA56646F3B1625C4614B05616EE478B9", hash_generated_method = "AA56646F3B1625C4614B05616EE478B9")
        public ReplacementSpan ()
    {
    }


    public abstract int getSize(Paint paint, CharSequence text,
                         int start, int end,
                         Paint.FontMetricsInt fm);

    
    public abstract void draw(Canvas canvas, CharSequence text,
                     int start, int end, float x,
                     int top, int y, int bottom, Paint paint);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.909 -0400", hash_original_method = "A699A8F3838B8D034AE05CD71CC1E03F", hash_generated_method = "420C2AF97E352E1C336FF896ACD035A9")
    @DSModeled(DSC.SAFE)
    public void updateMeasureState(TextPaint p) {
        dsTaint.addTaint(p.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.909 -0400", hash_original_method = "38B7676DEF6A1A947DFBA6BCAE88FB2B", hash_generated_method = "E5CAE41A7F5755D5B8D88A272703ED74")
    @DSModeled(DSC.SAFE)
    public void updateDrawState(TextPaint ds) {
        dsTaint.addTaint(ds.dsTaint);
        // ---------- Original Method ----------
    }

    
}

