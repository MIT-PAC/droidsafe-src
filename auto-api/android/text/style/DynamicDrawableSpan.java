package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.lang.ref.WeakReference;

public abstract class DynamicDrawableSpan extends ReplacementSpan {
    protected int mVerticalAlignment;
    private WeakReference<Drawable> mDrawableRef;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.835 -0400", hash_original_method = "587E05693DC916F3D9913DB57CE5CC25", hash_generated_method = "789768EBC2745941ED923A1AE4190854")
    @DSModeled(DSC.SAFE)
    public DynamicDrawableSpan() {
        mVerticalAlignment = ALIGN_BOTTOM;
        // ---------- Original Method ----------
        //mVerticalAlignment = ALIGN_BOTTOM;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.835 -0400", hash_original_method = "5C20CFC81A776E313C1A5A57E335B286", hash_generated_method = "14C104E26AB99D0E518C0F2E71769293")
    @DSModeled(DSC.SAFE)
    protected DynamicDrawableSpan(int verticalAlignment) {
        dsTaint.addTaint(verticalAlignment);
        // ---------- Original Method ----------
        //mVerticalAlignment = verticalAlignment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.835 -0400", hash_original_method = "613CAAD12B2914F4036D9034966EEECA", hash_generated_method = "E5917AFCC12A1D446B2E0B6D97DB671F")
    @DSModeled(DSC.SAFE)
    public int getVerticalAlignment() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mVerticalAlignment;
    }

    
    public abstract Drawable getDrawable();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.837 -0400", hash_original_method = "0E2414BE2E113C87DD8ACCDB4F014ABB", hash_generated_method = "2E1C6FCF9BA91D768712D1977F0E7D57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getSize(Paint paint, CharSequence text,
                         int start, int end,
                         Paint.FontMetricsInt fm) {
        dsTaint.addTaint(fm.dsTaint);
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(end);
        Drawable d;
        d = getCachedDrawable();
        Rect rect;
        rect = d.getBounds();
        {
            fm.ascent = -rect.bottom;
            fm.descent = 0;
            fm.top = fm.ascent;
            fm.bottom = 0;
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //Drawable d = getCachedDrawable();
        //Rect rect = d.getBounds();
        //if (fm != null) {
            //fm.ascent = -rect.bottom; 
            //fm.descent = 0; 
            //fm.top = fm.ascent;
            //fm.bottom = 0;
        //}
        //return rect.right;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.838 -0400", hash_original_method = "6EDA777F5CB3128927ADAA236FCAEE94", hash_generated_method = "208BDB077121B362D0B4216741B1B140")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void draw(Canvas canvas, CharSequence text,
                     int start, int end, float x, 
                     int top, int y, int bottom, Paint paint) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(canvas.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(end);
        dsTaint.addTaint(top);
        dsTaint.addTaint(x);
        Drawable b;
        b = getCachedDrawable();
        canvas.save();
        int transY;
        transY = bottom - b.getBounds().bottom;
        {
            transY -= paint.getFontMetricsInt().descent;
        } //End block
        canvas.translate(x, transY);
        b.draw(canvas);
        canvas.restore();
        // ---------- Original Method ----------
        //Drawable b = getCachedDrawable();
        //canvas.save();
        //int transY = bottom - b.getBounds().bottom;
        //if (mVerticalAlignment == ALIGN_BASELINE) {
            //transY -= paint.getFontMetricsInt().descent;
        //}
        //canvas.translate(x, transY);
        //b.draw(canvas);
        //canvas.restore();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.838 -0400", hash_original_method = "0EFD0E735C0FDE972D23D8A040440B54", hash_generated_method = "5173EC1A5785516F8858228289728A07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Drawable getCachedDrawable() {
        WeakReference<Drawable> wr;
        wr = mDrawableRef;
        Drawable d;
        d = null;
        d = wr.get();
        {
            d = getDrawable();
            mDrawableRef = new WeakReference<Drawable>(d);
        } //End block
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //WeakReference<Drawable> wr = mDrawableRef;
        //Drawable d = null;
        //if (wr != null)
            //d = wr.get();
        //if (d == null) {
            //d = getDrawable();
            //mDrawableRef = new WeakReference<Drawable>(d);
        //}
        //return d;
    }

    
    private static final String TAG = "DynamicDrawableSpan";
    public static final int ALIGN_BOTTOM = 0;
    public static final int ALIGN_BASELINE = 1;
}

