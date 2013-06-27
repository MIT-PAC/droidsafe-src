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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.830 -0400", hash_original_method = "2ECC8F1A2253E21B3B9AB67FC300FA22", hash_generated_method = "2ECC8F1A2253E21B3B9AB67FC300FA22")
    public ReplacementSpan ()
    {
        //Synthesized constructor
    }


    public abstract int getSize(Paint paint, CharSequence text,
                         int start, int end,
                         Paint.FontMetricsInt fm);

    
    public abstract void draw(Canvas canvas, CharSequence text,
                     int start, int end, float x,
                     int top, int y, int bottom, Paint paint);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.831 -0400", hash_original_method = "A699A8F3838B8D034AE05CD71CC1E03F", hash_generated_method = "6E00101E00426EF68AD26810595FA873")
    public void updateMeasureState(TextPaint p) {
        addTaint(p.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.832 -0400", hash_original_method = "38B7676DEF6A1A947DFBA6BCAE88FB2B", hash_generated_method = "A99FCE9C339DBD7365B6728543F91927")
    public void updateDrawState(TextPaint ds) {
        addTaint(ds.getTaint());
        // ---------- Original Method ----------
    }

    
}

