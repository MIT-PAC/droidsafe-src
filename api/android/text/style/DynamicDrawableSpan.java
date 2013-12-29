package android.text.style;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.ref.WeakReference;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;





public abstract class DynamicDrawableSpan extends ReplacementSpan {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:52.017 -0500", hash_original_field = "56F35BBCC1FA1116F768C6A5AC9A74AB", hash_generated_field = "A47BFC49D3DFA51412A4721B935ED380")

    private static final String TAG = "DynamicDrawableSpan";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:52.018 -0500", hash_original_field = "DA55C5480338EE52D690CE71C8FB9376", hash_generated_field = "CFDAC4B4FA2FA0CAE26A24C1FE0C997B")

    public static final int ALIGN_BOTTOM = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:52.018 -0500", hash_original_field = "16608AC0377A02C97DB20C32DEAAB601", hash_generated_field = "0B46879B5351D289275BAF23DDB894B7")

    public static final int ALIGN_BASELINE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:52.019 -0500", hash_original_field = "EBBD40EF7B2AC897D0C3172D0FE7C4AC", hash_generated_field = "D68ADB86A975A9AE5050DE7500A9318A")

    
    protected  int mVerticalAlignment;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:52.026 -0500", hash_original_field = "ED75FAB2DB1FB4241E447355C9E64AAD", hash_generated_field = "6E7F288327E5F719EDD09C1387A42733")


    private WeakReference<Drawable> mDrawableRef;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:52.020 -0500", hash_original_method = "587E05693DC916F3D9913DB57CE5CC25", hash_generated_method = "238F142918127464373E6EBD171C4CBE")
    public DynamicDrawableSpan() {
        mVerticalAlignment = ALIGN_BOTTOM;
    }

    /**
     * @param verticalAlignment one of {@link #ALIGN_BOTTOM} or {@link #ALIGN_BASELINE}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:52.021 -0500", hash_original_method = "5C20CFC81A776E313C1A5A57E335B286", hash_generated_method = "015624268560D7FE9F04FD2AB3AD5663")
    protected DynamicDrawableSpan(int verticalAlignment) {
        mVerticalAlignment = verticalAlignment;
    }

    /**
     * Returns the vertical alignment of this span, one of {@link #ALIGN_BOTTOM} or
     * {@link #ALIGN_BASELINE}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:52.022 -0500", hash_original_method = "613CAAD12B2914F4036D9034966EEECA", hash_generated_method = "BA3D48C58348343E6A2D35E66B5517B0")
    public int getVerticalAlignment() {
        return mVerticalAlignment;
    }

    /**
     * Your subclass must implement this method to provide the bitmap   
     * to be drawn.  The dimensions of the bitmap must be the same
     * from each call to the next.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:52.023 -0500", hash_original_method = "E45D5E06CC36B350F0B5005D9DCCC267", hash_generated_method = "57902D8C8D7589E5DAB6EC912EF26A6A")
    public abstract Drawable getDrawable();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:52.023 -0500", hash_original_method = "0E2414BE2E113C87DD8ACCDB4F014ABB", hash_generated_method = "C9C3C36E50E6A598AF3BBEAF7C1AD242")
    @Override
public int getSize(Paint paint, CharSequence text,
                         int start, int end,
                         Paint.FontMetricsInt fm) {
        Drawable d = getCachedDrawable();
        Rect rect = d.getBounds();

        if (fm != null) {
            fm.ascent = -rect.bottom; 
            fm.descent = 0; 

            fm.top = fm.ascent;
            fm.bottom = 0;
        }

        return rect.right;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:52.024 -0500", hash_original_method = "6EDA777F5CB3128927ADAA236FCAEE94", hash_generated_method = "A1A4D8C1BC83ACC2A94439B9A22C37C4")
    @Override
public void draw(Canvas canvas, CharSequence text,
                     int start, int end, float x, 
                     int top, int y, int bottom, Paint paint) {
        Drawable b = getCachedDrawable();
        canvas.save();
        
        int transY = bottom - b.getBounds().bottom;
        if (mVerticalAlignment == ALIGN_BASELINE) {
            transY -= paint.getFontMetricsInt().descent;
        }

        canvas.translate(x, transY);
        b.draw(canvas);
        canvas.restore();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:52.025 -0500", hash_original_method = "0EFD0E735C0FDE972D23D8A040440B54", hash_generated_method = "61C2D922936EDCEF7C52DCFD5CE525DD")
    private Drawable getCachedDrawable() {
        WeakReference<Drawable> wr = mDrawableRef;
        Drawable d = null;

        if (wr != null)
            d = wr.get();

        if (d == null) {
            d = getDrawable();
            mDrawableRef = new WeakReference<Drawable>(d);
        }

        return d;
    }
}

