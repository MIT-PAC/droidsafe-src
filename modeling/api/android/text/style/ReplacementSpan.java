package android.text.style;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;

public abstract class ReplacementSpan extends MetricAffectingSpan {
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.082 -0400", hash_original_method = "2ECC8F1A2253E21B3B9AB67FC300FA22", hash_generated_method = "2ECC8F1A2253E21B3B9AB67FC300FA22")
    public ReplacementSpan ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.943 -0500", hash_original_method = "2BFF9DC1056E43EDBEC2EC5D3C05A7CF", hash_generated_method = "00AE4EFC9FD311F0158573FE00820A76")
    
public abstract int getSize(Paint paint, CharSequence text,
                         int start, int end,
                         Paint.FontMetricsInt fm);
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.945 -0500", hash_original_method = "D1309B3A587F3A9B312E7EB475FAED7E", hash_generated_method = "E1BFC406604A9E612F6839FD2364D32A")
    
public abstract void draw(Canvas canvas, CharSequence text,
                     int start, int end, float x,
                     int top, int y, int bottom, Paint paint);

    /**
     * This method does nothing, since ReplacementSpans are measured
     * explicitly instead of affecting Paint properties.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.948 -0500", hash_original_method = "A699A8F3838B8D034AE05CD71CC1E03F", hash_generated_method = "2D8B9E7148A621165C9B1048AC79D92B")
    
public void updateMeasureState(TextPaint p) { }

    /**
     * This method does nothing, since ReplacementSpans are drawn
     * explicitly instead of affecting Paint properties.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.950 -0500", hash_original_method = "38B7676DEF6A1A947DFBA6BCAE88FB2B", hash_generated_method = "A47F6D3494DC1730CD7574D8CB3CD150")
    
public void updateDrawState(TextPaint ds) { }
    
}

