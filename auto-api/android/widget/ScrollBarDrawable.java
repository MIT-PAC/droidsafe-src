package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class ScrollBarDrawable extends Drawable {
    private Drawable mVerticalTrack;
    private Drawable mHorizontalTrack;
    private Drawable mVerticalThumb;
    private Drawable mHorizontalThumb;
    private int mRange;
    private int mOffset;
    private int mExtent;
    private boolean mVertical;
    private boolean mChanged;
    private boolean mRangeChanged;
    private Rect mTempBounds = new Rect();
    private boolean mAlwaysDrawHorizontalTrack;
    private boolean mAlwaysDrawVerticalTrack;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.257 -0400", hash_original_method = "F6C29E547BD302257DEE1C67DCEB3680", hash_generated_method = "5558BCE67B8081D2BE7E25243209DB1F")
    @DSModeled(DSC.SAFE)
    public ScrollBarDrawable() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.257 -0400", hash_original_method = "338EA256BE1472C967D04B115E1F5FA4", hash_generated_method = "4724FABBD9ADD035C527090EF9405DF5")
    @DSModeled(DSC.SAFE)
    public void setAlwaysDrawHorizontalTrack(boolean alwaysDrawTrack) {
        dsTaint.addTaint(alwaysDrawTrack);
        // ---------- Original Method ----------
        //mAlwaysDrawHorizontalTrack = alwaysDrawTrack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.258 -0400", hash_original_method = "901AC7B8EB84A9D2458B7938E8E4C73B", hash_generated_method = "E7E81A04CEE6A1C4564A47C3F4552782")
    @DSModeled(DSC.SAFE)
    public void setAlwaysDrawVerticalTrack(boolean alwaysDrawTrack) {
        dsTaint.addTaint(alwaysDrawTrack);
        // ---------- Original Method ----------
        //mAlwaysDrawVerticalTrack = alwaysDrawTrack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.258 -0400", hash_original_method = "0A81522E62255950E42918FC464ECE8D", hash_generated_method = "8A1A5072A1A1C065243F4428EE2E96AA")
    @DSModeled(DSC.SAFE)
    public boolean getAlwaysDrawVerticalTrack() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAlwaysDrawVerticalTrack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.258 -0400", hash_original_method = "58B8563B0AE3601908934E7BD6ECE0D9", hash_generated_method = "7798A3B802C61576AEF68FA5A9A15946")
    @DSModeled(DSC.SAFE)
    public boolean getAlwaysDrawHorizontalTrack() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAlwaysDrawHorizontalTrack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.258 -0400", hash_original_method = "0CC6554F6E9383DBFFA4FCF818E81542", hash_generated_method = "58E555983B4BD5D6179525EDCC527628")
    @DSModeled(DSC.SAFE)
    public void setParameters(int range, int offset, int extent, boolean vertical) {
        dsTaint.addTaint(vertical);
        dsTaint.addTaint(range);
        dsTaint.addTaint(extent);
        dsTaint.addTaint(offset);
        {
            mChanged = true;
        } //End block
        {
            mRangeChanged = true;
        } //End block
        // ---------- Original Method ----------
        //if (mVertical != vertical) {
            //mChanged = true;
        //}
        //if (mRange != range || mOffset != offset || mExtent != extent) {
            //mRangeChanged = true;
        //}
        //mRange = range;
        //mOffset = offset;
        //mExtent = extent;
        //mVertical = vertical;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.259 -0400", hash_original_method = "1E3ED238DD8B93FF3896611B5226DF40", hash_generated_method = "8A6FD03C9F6C0308CD4820550717BA8E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void draw(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        boolean vertical;
        vertical = mVertical;
        int extent;
        extent = mExtent;
        int range;
        range = mRange;
        boolean drawTrack;
        drawTrack = true;
        boolean drawThumb;
        drawThumb = true;
        {
            drawTrack = vertical ? mAlwaysDrawVerticalTrack : mAlwaysDrawHorizontalTrack;
            drawThumb = false;
        } //End block
        Rect r;
        r = getBounds();
        {
            boolean varD76EA641DE25B667522D35D8A7259174_1678979842 = (canvas.quickReject(r.left, r.top, r.right, r.bottom, Canvas.EdgeType.AA));
        } //End collapsed parenthetic
        {
            drawTrack(canvas, r, vertical);
        } //End block
        {
            int size;
            size = r.height();
            size = r.width();
            int thickness;
            thickness = r.width();
            thickness = r.height();
            int length;
            length = Math.round((float) size * extent / range);
            int offset;
            offset = Math.round((float) (size - length) * mOffset / (range - extent));
            int minLength;
            minLength = thickness * 2;
            {
                length = minLength;
            } //End block
            {
                offset = size - length;
            } //End block
            drawThumb(canvas, r, offset, length, vertical);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.260 -0400", hash_original_method = "44DF7C7CE3C6FB97927067DC59DBEDA2", hash_generated_method = "8399837364562D02DF26AC3B0467A1F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onBoundsChange(Rect bounds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(bounds.dsTaint);
        super.onBoundsChange(bounds);
        mChanged = true;
        // ---------- Original Method ----------
        //super.onBoundsChange(bounds);
        //mChanged = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.261 -0400", hash_original_method = "FBC32EDDC9C94F2A507C4B078AFDC706", hash_generated_method = "669600ECB5A05057328290968A88737F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void drawTrack(Canvas canvas, Rect bounds, boolean vertical) {
        dsTaint.addTaint(bounds.dsTaint);
        dsTaint.addTaint(vertical);
        dsTaint.addTaint(canvas.dsTaint);
        Drawable track;
        {
            track = mVerticalTrack;
        } //End block
        {
            track = mHorizontalTrack;
        } //End block
        {
            {
                track.setBounds(bounds);
            } //End block
            track.draw(canvas);
        } //End block
        // ---------- Original Method ----------
        //Drawable track;
        //if (vertical) {
            //track = mVerticalTrack;
        //} else {
            //track = mHorizontalTrack;
        //}
        //if (track != null) {
            //if (mChanged) {
                //track.setBounds(bounds);
            //}
            //track.draw(canvas);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.262 -0400", hash_original_method = "272AE2AAF08C3293C4192CBFA02ABB41", hash_generated_method = "02C573996179B33599807428A4ECB8EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void drawThumb(Canvas canvas, Rect bounds, int offset, int length, boolean vertical) {
        dsTaint.addTaint(bounds.dsTaint);
        dsTaint.addTaint(vertical);
        dsTaint.addTaint(length);
        dsTaint.addTaint(canvas.dsTaint);
        dsTaint.addTaint(offset);
        Rect thumbRect;
        thumbRect = mTempBounds;
        boolean changed;
        changed = mRangeChanged || mChanged;
        {
            {
                thumbRect.set(bounds.left,  bounds.top + offset,
                        bounds.right, bounds.top + offset + length);
            } //End block
            {
                thumbRect.set(bounds.left + offset, bounds.top,
                        bounds.left + offset + length, bounds.bottom);
            } //End block
        } //End block
        {
            Drawable thumb;
            thumb = mVerticalThumb;
            thumb.setBounds(thumbRect);
            thumb.draw(canvas);
        } //End block
        {
            Drawable thumb;
            thumb = mHorizontalThumb;
            thumb.setBounds(thumbRect);
            thumb.draw(canvas);
        } //End block
        // ---------- Original Method ----------
        //final Rect thumbRect = mTempBounds;
        //final boolean changed = mRangeChanged || mChanged;
        //if (changed) {
            //if (vertical) {
                //thumbRect.set(bounds.left,  bounds.top + offset,
                        //bounds.right, bounds.top + offset + length);
            //} else {
                //thumbRect.set(bounds.left + offset, bounds.top,
                        //bounds.left + offset + length, bounds.bottom);
            //}
        //}
        //if (vertical) {
            //final Drawable thumb = mVerticalThumb;
            //if (changed) thumb.setBounds(thumbRect);
            //thumb.draw(canvas);
        //} else {
            //final Drawable thumb = mHorizontalThumb;
            //if (changed) thumb.setBounds(thumbRect);
            //thumb.draw(canvas);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.262 -0400", hash_original_method = "CF1FA0D3674C65E82EB702858CBA2EA8", hash_generated_method = "F9DDA9C78D0CF7617AE31BB14875E420")
    @DSModeled(DSC.SAFE)
    public void setVerticalThumbDrawable(Drawable thumb) {
        dsTaint.addTaint(thumb.dsTaint);
        // ---------- Original Method ----------
        //if (thumb != null) {
            //mVerticalThumb = thumb;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.262 -0400", hash_original_method = "95A534FB494475ED343603B1A863AD99", hash_generated_method = "FEE033EA3644932BFBBCC41F91EF3D5D")
    @DSModeled(DSC.SAFE)
    public void setVerticalTrackDrawable(Drawable track) {
        dsTaint.addTaint(track.dsTaint);
        // ---------- Original Method ----------
        //mVerticalTrack = track;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.262 -0400", hash_original_method = "D314A45F62304CCC7D305EC252A7898A", hash_generated_method = "DD6DB339D1EB6EB019CA71000DFB4277")
    @DSModeled(DSC.SAFE)
    public void setHorizontalThumbDrawable(Drawable thumb) {
        dsTaint.addTaint(thumb.dsTaint);
        // ---------- Original Method ----------
        //if (thumb != null) {
            //mHorizontalThumb = thumb;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.262 -0400", hash_original_method = "AA2EFF46594CC873B99869053CAE3587", hash_generated_method = "6EF8F8C3571BC81E0834852EFDEA90C9")
    @DSModeled(DSC.SAFE)
    public void setHorizontalTrackDrawable(Drawable track) {
        dsTaint.addTaint(track.dsTaint);
        // ---------- Original Method ----------
        //mHorizontalTrack = track;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.263 -0400", hash_original_method = "7E286D23B763C72717353421EFF3C480", hash_generated_method = "252BEDC26F9441FC1E6B28E4943F4C79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getSize(boolean vertical) {
        dsTaint.addTaint(vertical);
        {
            int var57087549A55D8A830EECC66A97BBD029_2144665904 = ((mVerticalTrack != null ?
                    mVerticalTrack : mVerticalThumb).getIntrinsicWidth()); //DSFIXME:  CODE0008: Nested ternary operator in expression
        } //End block
        {
            int var96DC261A22A8F5D18162BD604E7B7C4D_690299331 = ((mHorizontalTrack != null ?
                    mHorizontalTrack : mHorizontalThumb).getIntrinsicHeight()); //DSFIXME:  CODE0008: Nested ternary operator in expression
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (vertical) {
            //return (mVerticalTrack != null ?
                    //mVerticalTrack : mVerticalThumb).getIntrinsicWidth();
        //} else {
            //return (mHorizontalTrack != null ?
                    //mHorizontalTrack : mHorizontalThumb).getIntrinsicHeight();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.263 -0400", hash_original_method = "B18AEA250E30640B8B376B842AF0FDF6", hash_generated_method = "EBD0EA3B399F81377E11BA51EBF2BCE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setAlpha(int alpha) {
        dsTaint.addTaint(alpha);
        {
            mVerticalTrack.setAlpha(alpha);
        } //End block
        mVerticalThumb.setAlpha(alpha);
        {
            mHorizontalTrack.setAlpha(alpha);
        } //End block
        mHorizontalThumb.setAlpha(alpha);
        // ---------- Original Method ----------
        //if (mVerticalTrack != null) {
            //mVerticalTrack.setAlpha(alpha);
        //}
        //mVerticalThumb.setAlpha(alpha);
        //if (mHorizontalTrack != null) {
            //mHorizontalTrack.setAlpha(alpha);
        //}
        //mHorizontalThumb.setAlpha(alpha);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.263 -0400", hash_original_method = "CBF97912C9C8F01704D565D3AA800300", hash_generated_method = "DA6EEFDFBF6FCBDF4541AD79EDA157A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setColorFilter(ColorFilter cf) {
        dsTaint.addTaint(cf.dsTaint);
        {
            mVerticalTrack.setColorFilter(cf);
        } //End block
        mVerticalThumb.setColorFilter(cf);
        {
            mHorizontalTrack.setColorFilter(cf);
        } //End block
        mHorizontalThumb.setColorFilter(cf);
        // ---------- Original Method ----------
        //if (mVerticalTrack != null) {
            //mVerticalTrack.setColorFilter(cf);
        //}
        //mVerticalThumb.setColorFilter(cf);
        //if (mHorizontalTrack != null) {
            //mHorizontalTrack.setColorFilter(cf);
        //}
        //mHorizontalThumb.setColorFilter(cf);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.263 -0400", hash_original_method = "AB3D570DA2A917C408AB4F7D8FCD7103", hash_generated_method = "ABA86D69E3485D7E8F9A1E6F7D7F161F")
    @DSModeled(DSC.SAFE)
    @Override
    public int getOpacity() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return PixelFormat.TRANSLUCENT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.263 -0400", hash_original_method = "C5352C5923C905107C68A18CC8B889AA", hash_generated_method = "CC5B6B70FF872F7261BF7DD87131422C")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "ScrollBarDrawable: range=" + mRange + " offset=" + mOffset +
               //" extent=" + mExtent + (mVertical ? " V" : " H");
    }

    
}

