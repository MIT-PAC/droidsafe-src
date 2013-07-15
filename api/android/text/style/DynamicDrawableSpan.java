package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.lang.ref.WeakReference;

public abstract class DynamicDrawableSpan extends ReplacementSpan {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.167 -0400", hash_original_field = "DD0F6B30A1C3613F4ED1E78B9E676A97", hash_generated_field = "D68ADB86A975A9AE5050DE7500A9318A")

    protected int mVerticalAlignment;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.167 -0400", hash_original_field = "0AFE42520E442245FC7671F0C64652E7", hash_generated_field = "6E7F288327E5F719EDD09C1387A42733")

    private WeakReference<Drawable> mDrawableRef;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.168 -0400", hash_original_method = "587E05693DC916F3D9913DB57CE5CC25", hash_generated_method = "789768EBC2745941ED923A1AE4190854")
    public  DynamicDrawableSpan() {
        mVerticalAlignment = ALIGN_BOTTOM;
        // ---------- Original Method ----------
        //mVerticalAlignment = ALIGN_BOTTOM;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.169 -0400", hash_original_method = "5C20CFC81A776E313C1A5A57E335B286", hash_generated_method = "DB69116249BA33E0EF3EEBB6FDC4C251")
    protected  DynamicDrawableSpan(int verticalAlignment) {
        mVerticalAlignment = verticalAlignment;
        // ---------- Original Method ----------
        //mVerticalAlignment = verticalAlignment;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.169 -0400", hash_original_method = "613CAAD12B2914F4036D9034966EEECA", hash_generated_method = "06AA56A01629129DC4524AAB8FFE3774")
    public int getVerticalAlignment() {
        int varDD0F6B30A1C3613F4ED1E78B9E676A97_472378010 = (mVerticalAlignment);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_469502306 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_469502306;
        // ---------- Original Method ----------
        //return mVerticalAlignment;
    }

    
    public abstract Drawable getDrawable();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.170 -0400", hash_original_method = "0E2414BE2E113C87DD8ACCDB4F014ABB", hash_generated_method = "4A71819D1A1DD79C0343CEC40E87F61C")
    @Override
    public int getSize(Paint paint, CharSequence text,
                         int start, int end,
                         Paint.FontMetricsInt fm) {
        addTaint(fm.getTaint());
        addTaint(end);
        addTaint(start);
        addTaint(text.getTaint());
        addTaint(paint.getTaint());
        Drawable d = getCachedDrawable();
        Rect rect = d.getBounds();
    if(fm != null)        
        {
            fm.ascent = -rect.bottom;
            fm.descent = 0;
            fm.top = fm.ascent;
            fm.bottom = 0;
        } //End block
        int varEDBDBA894CAF24DA1077CEF4A95929F4_198952479 = (rect.right);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1360886535 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1360886535;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.171 -0400", hash_original_method = "6EDA777F5CB3128927ADAA236FCAEE94", hash_generated_method = "294CD1309671CFA7EE5FC6BF83780CF3")
    @Override
    public void draw(Canvas canvas, CharSequence text,
                     int start, int end, float x, 
                     int top, int y, int bottom, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(bottom);
        addTaint(y);
        addTaint(top);
        addTaint(x);
        addTaint(end);
        addTaint(start);
        addTaint(text.getTaint());
        addTaint(canvas.getTaint());
        Drawable b = getCachedDrawable();
        canvas.save();
        int transY = bottom - b.getBounds().bottom;
    if(mVerticalAlignment == ALIGN_BASELINE)        
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.172 -0400", hash_original_method = "0EFD0E735C0FDE972D23D8A040440B54", hash_generated_method = "5A539C74290ACE01A61AFC7CFEB8FC59")
    private Drawable getCachedDrawable() {
        WeakReference<Drawable> wr = mDrawableRef;
        Drawable d = null;
    if(wr != null)        
        d = wr.get();
    if(d == null)        
        {
            d = getDrawable();
            mDrawableRef = new WeakReference<Drawable>(d);
        } //End block
Drawable varBE245B24E7ED509FDFAAA6CD39E35D89_1126444331 =         d;
        varBE245B24E7ED509FDFAAA6CD39E35D89_1126444331.addTaint(taint);
        return varBE245B24E7ED509FDFAAA6CD39E35D89_1126444331;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.172 -0400", hash_original_field = "EC81B49D6F038D1D244D6A566855D109", hash_generated_field = "A47BFC49D3DFA51412A4721B935ED380")

    private static final String TAG = "DynamicDrawableSpan";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.172 -0400", hash_original_field = "F6EAFC51FAE78705C767466535901625", hash_generated_field = "CFDAC4B4FA2FA0CAE26A24C1FE0C997B")

    public static final int ALIGN_BOTTOM = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.172 -0400", hash_original_field = "4F1E6FE1D0F95C6A1D7E39C526119559", hash_generated_field = "0B46879B5351D289275BAF23DDB894B7")

    public static final int ALIGN_BASELINE = 1;
}

