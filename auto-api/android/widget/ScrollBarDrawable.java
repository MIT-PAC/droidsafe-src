package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private final Rect mTempBounds = new Rect();
    private boolean mAlwaysDrawHorizontalTrack;
    private boolean mAlwaysDrawVerticalTrack;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.248 -0400", hash_original_method = "F6C29E547BD302257DEE1C67DCEB3680", hash_generated_method = "3B675DA6F914A5AE27A703DD87A670AC")
    @DSModeled(DSC.SAFE)
    public ScrollBarDrawable() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.248 -0400", hash_original_method = "338EA256BE1472C967D04B115E1F5FA4", hash_generated_method = "B71562816E7051502CCC83CBB051C618")
    @DSModeled(DSC.SAFE)
    public void setAlwaysDrawHorizontalTrack(boolean alwaysDrawTrack) {
        dsTaint.addTaint(alwaysDrawTrack);
        // ---------- Original Method ----------
        //mAlwaysDrawHorizontalTrack = alwaysDrawTrack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.248 -0400", hash_original_method = "901AC7B8EB84A9D2458B7938E8E4C73B", hash_generated_method = "3F002A13E1CC92AB5052D5FE703CCDD2")
    @DSModeled(DSC.SAFE)
    public void setAlwaysDrawVerticalTrack(boolean alwaysDrawTrack) {
        dsTaint.addTaint(alwaysDrawTrack);
        // ---------- Original Method ----------
        //mAlwaysDrawVerticalTrack = alwaysDrawTrack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.248 -0400", hash_original_method = "0A81522E62255950E42918FC464ECE8D", hash_generated_method = "AA59BCA4EE5EE0DDEFC89AF12F334960")
    @DSModeled(DSC.SAFE)
    public boolean getAlwaysDrawVerticalTrack() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAlwaysDrawVerticalTrack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.248 -0400", hash_original_method = "58B8563B0AE3601908934E7BD6ECE0D9", hash_generated_method = "6CC00F1CD818CA0D168ED62AA719E909")
    @DSModeled(DSC.SAFE)
    public boolean getAlwaysDrawHorizontalTrack() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAlwaysDrawHorizontalTrack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.248 -0400", hash_original_method = "0CC6554F6E9383DBFFA4FCF818E81542", hash_generated_method = "99456D75EF099812770ACA50AC112039")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.249 -0400", hash_original_method = "1E3ED238DD8B93FF3896611B5226DF40", hash_generated_method = "77EF17CB347A02BB9786D66AA17FE266")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void draw(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        final boolean vertical;
        vertical = mVertical;
        final int extent;
        extent = mExtent;
        final int range;
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
            boolean varD76EA641DE25B667522D35D8A7259174_965277686 = (canvas.quickReject(r.left, r.top, r.right, r.bottom, Canvas.EdgeType.AA));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.249 -0400", hash_original_method = "44DF7C7CE3C6FB97927067DC59DBEDA2", hash_generated_method = "0241DC8B4536FC4CF92E28094E4C7772")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.249 -0400", hash_original_method = "FBC32EDDC9C94F2A507C4B078AFDC706", hash_generated_method = "A5770BEC6BA8C1E69998E2E338053A4B")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.249 -0400", hash_original_method = "272AE2AAF08C3293C4192CBFA02ABB41", hash_generated_method = "3CAC1F5E958F343356B5184A38D3D08C")
    @DSModeled(DSC.SAFE)
    protected void drawThumb(Canvas canvas, Rect bounds, int offset, int length, boolean vertical) {
        dsTaint.addTaint(bounds.dsTaint);
        dsTaint.addTaint(vertical);
        dsTaint.addTaint(length);
        dsTaint.addTaint(canvas.dsTaint);
        dsTaint.addTaint(offset);
        final Rect thumbRect;
        thumbRect = mTempBounds;
        final boolean changed;
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
            final Drawable thumb;
            thumb = mVerticalThumb;
            thumb.setBounds(thumbRect);
            thumb.draw(canvas);
        } //End block
        {
            final Drawable thumb;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.249 -0400", hash_original_method = "CF1FA0D3674C65E82EB702858CBA2EA8", hash_generated_method = "E32FDC079F0095A8B0AB729D1FC90579")
    @DSModeled(DSC.SAFE)
    public void setVerticalThumbDrawable(Drawable thumb) {
        dsTaint.addTaint(thumb.dsTaint);
        // ---------- Original Method ----------
        //if (thumb != null) {
            //mVerticalThumb = thumb;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.249 -0400", hash_original_method = "95A534FB494475ED343603B1A863AD99", hash_generated_method = "E11C315A5C63206ACA60BF09AF6E7A69")
    @DSModeled(DSC.SAFE)
    public void setVerticalTrackDrawable(Drawable track) {
        dsTaint.addTaint(track.dsTaint);
        // ---------- Original Method ----------
        //mVerticalTrack = track;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.249 -0400", hash_original_method = "D314A45F62304CCC7D305EC252A7898A", hash_generated_method = "3E1C99AF349491D26D5463C648924731")
    @DSModeled(DSC.SAFE)
    public void setHorizontalThumbDrawable(Drawable thumb) {
        dsTaint.addTaint(thumb.dsTaint);
        // ---------- Original Method ----------
        //if (thumb != null) {
            //mHorizontalThumb = thumb;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.249 -0400", hash_original_method = "AA2EFF46594CC873B99869053CAE3587", hash_generated_method = "CB3AA312D4A24F451304D79A4FF37F9C")
    @DSModeled(DSC.SAFE)
    public void setHorizontalTrackDrawable(Drawable track) {
        dsTaint.addTaint(track.dsTaint);
        // ---------- Original Method ----------
        //mHorizontalTrack = track;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.249 -0400", hash_original_method = "7E286D23B763C72717353421EFF3C480", hash_generated_method = "F11529C2DB8F3BA83EB89C1A9BB6FDCC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getSize(boolean vertical) {
        dsTaint.addTaint(vertical);
        {
            int var57087549A55D8A830EECC66A97BBD029_1011516156 = ((mVerticalTrack != null ?
                    mVerticalTrack : mVerticalThumb).getIntrinsicWidth()); //DSFIXME:  CODE0008: Nested ternary operator in expression
        } //End block
        {
            int var96DC261A22A8F5D18162BD604E7B7C4D_1988435985 = ((mHorizontalTrack != null ?
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.249 -0400", hash_original_method = "B18AEA250E30640B8B376B842AF0FDF6", hash_generated_method = "C7FA3618CDF5905A401E9A868FD0FA88")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.250 -0400", hash_original_method = "CBF97912C9C8F01704D565D3AA800300", hash_generated_method = "FB9105AEE8DA1D8041EF294FFD676E3D")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.250 -0400", hash_original_method = "AB3D570DA2A917C408AB4F7D8FCD7103", hash_generated_method = "1253909CC9FBD9731E124D68ED8E1B93")
    @DSModeled(DSC.SAFE)
    @Override
    public int getOpacity() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return PixelFormat.TRANSLUCENT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.250 -0400", hash_original_method = "C5352C5923C905107C68A18CC8B889AA", hash_generated_method = "0977877BD0638F8AB540C000D977BFA0")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "ScrollBarDrawable: range=" + mRange + " offset=" + mOffset +
               //" extent=" + mExtent + (mVertical ? " V" : " H");
    }

    
}


