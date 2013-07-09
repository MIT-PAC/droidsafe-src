package android.text.style;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.730 -0400", hash_original_field = "DD0F6B30A1C3613F4ED1E78B9E676A97", hash_generated_field = "D68ADB86A975A9AE5050DE7500A9318A")

    protected int mVerticalAlignment;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.731 -0400", hash_original_field = "0AFE42520E442245FC7671F0C64652E7", hash_generated_field = "6E7F288327E5F719EDD09C1387A42733")

    private WeakReference<Drawable> mDrawableRef;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.731 -0400", hash_original_method = "587E05693DC916F3D9913DB57CE5CC25", hash_generated_method = "789768EBC2745941ED923A1AE4190854")
    public  DynamicDrawableSpan() {
        mVerticalAlignment = ALIGN_BOTTOM;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.731 -0400", hash_original_method = "5C20CFC81A776E313C1A5A57E335B286", hash_generated_method = "DB69116249BA33E0EF3EEBB6FDC4C251")
    protected  DynamicDrawableSpan(int verticalAlignment) {
        mVerticalAlignment = verticalAlignment;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.732 -0400", hash_original_method = "613CAAD12B2914F4036D9034966EEECA", hash_generated_method = "9D75668AFB69D58146E30CDAF7174A50")
    public int getVerticalAlignment() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_684068051 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_684068051;
        
        
    }

    
    public abstract Drawable getDrawable();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.732 -0400", hash_original_method = "0E2414BE2E113C87DD8ACCDB4F014ABB", hash_generated_method = "8412BC090314C674DF4D8F6DBE69A477")
    @Override
    public int getSize(Paint paint, CharSequence text,
                         int start, int end,
                         Paint.FontMetricsInt fm) {
        Drawable d = getCachedDrawable();
        Rect rect = d.getBounds();
        {
            fm.ascent = -rect.bottom;
            fm.descent = 0;
            fm.top = fm.ascent;
            fm.bottom = 0;
        } 
        addTaint(paint.getTaint());
        addTaint(text.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(fm.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1890833451 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1890833451;
        
        
        
        
            
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.733 -0400", hash_original_method = "6EDA777F5CB3128927ADAA236FCAEE94", hash_generated_method = "B00E52505CB03871258946A86CEC8B6D")
    @Override
    public void draw(Canvas canvas, CharSequence text,
                     int start, int end, float x, 
                     int top, int y, int bottom, Paint paint) {
        Drawable b = getCachedDrawable();
        canvas.save();
        int transY = bottom - b.getBounds().bottom;
        {
            transY -= paint.getFontMetricsInt().descent;
        } 
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
        
        
        
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.734 -0400", hash_original_method = "0EFD0E735C0FDE972D23D8A040440B54", hash_generated_method = "BAE96E5767FB7DFB5F1BB1A094265644")
    private Drawable getCachedDrawable() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1165864530 = null; 
        WeakReference<Drawable> wr = mDrawableRef;
        Drawable d = null;
        d = wr.get();
        {
            d = getDrawable();
            mDrawableRef = new WeakReference<Drawable>(d);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1165864530 = d;
        varB4EAC82CA7396A68D541C85D26508E83_1165864530.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1165864530;
        
        
        
        
            
        
            
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.734 -0400", hash_original_field = "EC81B49D6F038D1D244D6A566855D109", hash_generated_field = "A47BFC49D3DFA51412A4721B935ED380")

    private static final String TAG = "DynamicDrawableSpan";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.734 -0400", hash_original_field = "F6EAFC51FAE78705C767466535901625", hash_generated_field = "CFDAC4B4FA2FA0CAE26A24C1FE0C997B")

    public static final int ALIGN_BOTTOM = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.734 -0400", hash_original_field = "4F1E6FE1D0F95C6A1D7E39C526119559", hash_generated_field = "0B46879B5351D289275BAF23DDB894B7")

    public static final int ALIGN_BASELINE = 1;
}

