package android.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.graphics.Canvas;
import android.graphics.Paint;

public interface GraphicsOperations
extends CharSequence
{
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void drawText(Canvas c, int start, int end,
                         float x, float y, Paint p);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void drawTextRun(Canvas c, int start, int end, int contextStart, int contextEnd,
            float x, float y, int flags, Paint p);
   
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    float measureText(int start, int end, Paint p);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int getTextWidths(int start, int end, float[] widths, Paint p);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    float getTextRunAdvances(int start, int end, int contextStart, int contextEnd,
            int flags, float[] advances, int advancesIndex, Paint paint);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    float getTextRunAdvances(int start, int end, int contextStart, int contextEnd,
            int flags, float[] advances, int advancesIndex, Paint paint, int reserved);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    int getTextRunCursor(int contextStart, int contextEnd, int flags, int offset,
            int cursorOpt, Paint p);
}
