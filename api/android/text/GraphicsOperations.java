package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Canvas;
import android.graphics.Paint;

public interface GraphicsOperations
extends CharSequence
{
    
    void drawText(Canvas c, int start, int end,
                         float x, float y, Paint p);

    
    void drawTextRun(Canvas c, int start, int end, int contextStart, int contextEnd,
            float x, float y, int flags, Paint p);

   
    float measureText(int start, int end, Paint p);

    
    public int getTextWidths(int start, int end, float[] widths, Paint p);

    
    float getTextRunAdvances(int start, int end, int contextStart, int contextEnd,
            int flags, float[] advances, int advancesIndex, Paint paint);

    
    float getTextRunAdvances(int start, int end, int contextStart, int contextEnd,
            int flags, float[] advances, int advancesIndex, Paint paint, int reserved);

    
    int getTextRunCursor(int contextStart, int contextEnd, int flags, int offset,
            int cursorOpt, Paint p);
}
