package android.graphics.drawable.shapes;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

public class RoundRectShape extends RectShape {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.691 -0500", hash_original_field = "FFD42C23F2C723747ED877F614CEF10A", hash_generated_field = "6830495B7E4516D5AD2F6812EB294538")

    private float[] mOuterRadii;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.693 -0500", hash_original_field = "8671536A7A0B8FD81624A39ADB80DD93", hash_generated_field = "D2729CA6AA6C83F02D0889C112109BB9")

    private RectF   mInset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.695 -0500", hash_original_field = "0CA70E23DEE7C30ACCE020583DBFEDF8", hash_generated_field = "F28D8A31EA09EA2173CBE320E200D4AF")

    private float[] mInnerRadii;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.697 -0500", hash_original_field = "87E108BA533AD53ED54A9D43AC876571", hash_generated_field = "8D82BE416946019DAC8D55ACEFBD37C0")
    
    private RectF mInnerRect;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.699 -0500", hash_original_field = "BA85F34C67A3F4FFA171800FB1C1C633", hash_generated_field = "101E51A8003B09B39CD3C51138473AB6")

    private Path  mPath;    // this is what we actually draw
    
    /**
     * RoundRectShape constructor.
     * Specifies an outer (round)rect and an optional inner (round)rect.
     *
     * @param outerRadii An array of 8 radius values, for the outer roundrect. 
     *                   The first two floats are for the 
     *                   top-left corner (remaining pairs correspond clockwise). 
     *                   For no rounded corners on the outer rectangle, 
     *                   pass null.
     * @param inset      A RectF that specifies the distance from the inner 
     *                   rect to each side of the outer rect. 
     *                   For no inner, pass null.
     * @param innerRadii An array of 8 radius values, for the inner roundrect.
     *                   The first two floats are for the 
     *                   top-left corner (remaining pairs correspond clockwise). 
     *                   For no rounded corners on the inner rectangle, 
     *                   pass null.
     *                   If inset parameter is null, this parameter is ignored. 
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.702 -0500", hash_original_method = "BFB37C497FF277AFDA0C7FF1B797A20B", hash_generated_method = "69B629F93436596B6E6AC6E5DC0E2075")
    
public RoundRectShape(float[] outerRadii, RectF inset,
                          float[] innerRadii) {
        if (outerRadii != null && outerRadii.length < 8) {
            throw new ArrayIndexOutOfBoundsException("outer radii must have >= 8 values");
        }
        if (innerRadii != null && innerRadii.length < 8) {
            throw new ArrayIndexOutOfBoundsException("inner radii must have >= 8 values");
        }
        mOuterRadii = outerRadii;
        mInset = inset;
        mInnerRadii = innerRadii;
        
        if (inset != null) {
            mInnerRect = new RectF();
        }
        mPath = new Path();
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.704 -0500", hash_original_method = "2040FB3810CEA26BCA97DD1BCDDED3AB", hash_generated_method = "9CAFFE13CB93ED1E021F4AD5B012F36E")
    
@Override
    public void draw(Canvas canvas, Paint paint) {
        canvas.drawPath(mPath, paint);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.707 -0500", hash_original_method = "76E13F34AD3978846D0DA3AA18C0FAE1", hash_generated_method = "55B2870296B4A02D7E1BD3D46D93E70B")
    
@Override
    protected void onResize(float w, float h) {
        super.onResize(w, h);
        
        RectF r = rect();
        mPath.reset();

        if (mOuterRadii != null) {
            mPath.addRoundRect(r, mOuterRadii, Path.Direction.CW);
        } else {
            mPath.addRect(r, Path.Direction.CW);
        }
        if (mInnerRect != null) {
            mInnerRect.set(r.left + mInset.left, r.top + mInset.top,
                           r.right - mInset.right, r.bottom - mInset.bottom);
            if (mInnerRect.width() < w && mInnerRect.height() < h) {
                if (mInnerRadii != null) {
                    mPath.addRoundRect(mInnerRect, mInnerRadii, Path.Direction.CCW);
                } else {
                    mPath.addRect(mInnerRect, Path.Direction.CCW);
                }
            }
        }
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.709 -0500", hash_original_method = "C8F54F0C5741E48CA334E7AB381892D2", hash_generated_method = "278968F286E9DE55B66B86405F99994F")
    
@Override
    public RoundRectShape clone() throws CloneNotSupportedException {
        RoundRectShape shape = (RoundRectShape) super.clone();
        shape.mOuterRadii = mOuterRadii != null ? mOuterRadii.clone() : null;
        shape.mInnerRadii = mInnerRadii != null ? mInnerRadii.clone() : null;
        shape.mInset = new RectF(mInset);
        shape.mInnerRect = new RectF(mInnerRect);
        shape.mPath = new Path(mPath);
        return shape;
    }
    
}

