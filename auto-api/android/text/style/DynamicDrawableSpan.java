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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.681 -0400", hash_original_field = "DD0F6B30A1C3613F4ED1E78B9E676A97", hash_generated_field = "D68ADB86A975A9AE5050DE7500A9318A")

    protected int mVerticalAlignment;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.681 -0400", hash_original_field = "0AFE42520E442245FC7671F0C64652E7", hash_generated_field = "6E7F288327E5F719EDD09C1387A42733")

    private WeakReference<Drawable> mDrawableRef;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.687 -0400", hash_original_method = "587E05693DC916F3D9913DB57CE5CC25", hash_generated_method = "789768EBC2745941ED923A1AE4190854")
    public  DynamicDrawableSpan() {
        mVerticalAlignment = ALIGN_BOTTOM;
        // ---------- Original Method ----------
        //mVerticalAlignment = ALIGN_BOTTOM;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.688 -0400", hash_original_method = "5C20CFC81A776E313C1A5A57E335B286", hash_generated_method = "DB69116249BA33E0EF3EEBB6FDC4C251")
    protected  DynamicDrawableSpan(int verticalAlignment) {
        mVerticalAlignment = verticalAlignment;
        // ---------- Original Method ----------
        //mVerticalAlignment = verticalAlignment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.689 -0400", hash_original_method = "613CAAD12B2914F4036D9034966EEECA", hash_generated_method = "150E6465680F5573CF3588899A2C1A66")
    public int getVerticalAlignment() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_733329099 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_733329099;
        // ---------- Original Method ----------
        //return mVerticalAlignment;
    }

    
    public abstract Drawable getDrawable();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.690 -0400", hash_original_method = "0E2414BE2E113C87DD8ACCDB4F014ABB", hash_generated_method = "319CC96AFAC5AE104F1CA68822336786")
    @Override
    public int getSize(Paint paint, CharSequence text,
                         int start, int end,
                         Paint.FontMetricsInt fm) {
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
        addTaint(paint.getTaint());
        addTaint(text.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(fm.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1257778109 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1257778109;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.691 -0400", hash_original_method = "6EDA777F5CB3128927ADAA236FCAEE94", hash_generated_method = "A271D251E1C40F2CD729291B641273CA")
    @Override
    public void draw(Canvas canvas, CharSequence text,
                     int start, int end, float x, 
                     int top, int y, int bottom, Paint paint) {
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
        addTaint(canvas.getTaint());
        addTaint(text.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(x);
        addTaint(top);
        addTaint(y);
        addTaint(bottom);
        addTaint(paint.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.707 -0400", hash_original_method = "0EFD0E735C0FDE972D23D8A040440B54", hash_generated_method = "5537F267EE6D0C40C587BD8DAEB0E691")
    private Drawable getCachedDrawable() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_294324798 = null; //Variable for return #1
        WeakReference<Drawable> wr;
        wr = mDrawableRef;
        Drawable d;
        d = null;
        d = wr.get();
        {
            d = getDrawable();
            mDrawableRef = new WeakReference<Drawable>(d);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_294324798 = d;
        varB4EAC82CA7396A68D541C85D26508E83_294324798.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_294324798;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.707 -0400", hash_original_field = "EC81B49D6F038D1D244D6A566855D109", hash_generated_field = "3F0EF5A636266FBA07FB335BDAAB6083")

    private static String TAG = "DynamicDrawableSpan";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.707 -0400", hash_original_field = "F6EAFC51FAE78705C767466535901625", hash_generated_field = "CFDAC4B4FA2FA0CAE26A24C1FE0C997B")

    public static final int ALIGN_BOTTOM = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.707 -0400", hash_original_field = "4F1E6FE1D0F95C6A1D7E39C526119559", hash_generated_field = "0B46879B5351D289275BAF23DDB894B7")

    public static final int ALIGN_BASELINE = 1;
}

