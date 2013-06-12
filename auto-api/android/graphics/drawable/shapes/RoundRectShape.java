package android.graphics.drawable.shapes;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

public class RoundRectShape extends RectShape {
    private float[] mOuterRadii;
    private RectF   mInset;
    private float[] mInnerRadii;
    private RectF mInnerRect;
    private Path  mPath;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:17.843 -0400", hash_original_method = "BFB37C497FF277AFDA0C7FF1B797A20B", hash_generated_method = "F8208E316999C406496B813FD2AA4C33")
    @DSModeled(DSC.SAFE)
    public RoundRectShape(float[] outerRadii, RectF inset,
                          float[] innerRadii) {
        dsTaint.addTaint(outerRadii);
        dsTaint.addTaint(innerRadii);
        dsTaint.addTaint(inset.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException("outer radii must have >= 8 values");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException("inner radii must have >= 8 values");
        } //End block
        {
            mInnerRect = new RectF();
        } //End block
        mPath = new Path();
        // ---------- Original Method ----------
        //if (outerRadii != null && outerRadii.length < 8) {
            //throw new ArrayIndexOutOfBoundsException("outer radii must have >= 8 values");
        //}
        //if (innerRadii != null && innerRadii.length < 8) {
            //throw new ArrayIndexOutOfBoundsException("inner radii must have >= 8 values");
        //}
        //mOuterRadii = outerRadii;
        //mInset = inset;
        //mInnerRadii = innerRadii;
        //if (inset != null) {
            //mInnerRect = new RectF();
        //}
        //mPath = new Path();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:17.852 -0400", hash_original_method = "2040FB3810CEA26BCA97DD1BCDDED3AB", hash_generated_method = "CE80D9993DBEDCCF58272E27CEE9A1B3")
    @DSModeled(DSC.SAFE)
    @Override
    public void draw(Canvas canvas, Paint paint) {
        dsTaint.addTaint(canvas.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        canvas.drawPath(mPath, paint);
        // ---------- Original Method ----------
        //canvas.drawPath(mPath, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:17.866 -0400", hash_original_method = "76E13F34AD3978846D0DA3AA18C0FAE1", hash_generated_method = "3AAE5BD9468E59B15A993246D2F8FDE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onResize(float w, float h) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(w);
        dsTaint.addTaint(h);
        super.onResize(w, h);
        RectF r;
        r = rect();
        mPath.reset();
        {
            mPath.addRoundRect(r, mOuterRadii, Path.Direction.CW);
        } //End block
        {
            mPath.addRect(r, Path.Direction.CW);
        } //End block
        {
            mInnerRect.set(r.left + mInset.left, r.top + mInset.top,
                           r.right - mInset.right, r.bottom - mInset.bottom);
            {
                boolean varFA69053F663231AFFAF816545E5D72F2_1874676645 = (mInnerRect.width() < w && mInnerRect.height() < h);
                {
                    {
                        mPath.addRoundRect(mInnerRect, mInnerRadii, Path.Direction.CCW);
                    } //End block
                    {
                        mPath.addRect(mInnerRect, Path.Direction.CCW);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //super.onResize(w, h);
        //RectF r = rect();
        //mPath.reset();
        //if (mOuterRadii != null) {
            //mPath.addRoundRect(r, mOuterRadii, Path.Direction.CW);
        //} else {
            //mPath.addRect(r, Path.Direction.CW);
        //}
        //if (mInnerRect != null) {
            //mInnerRect.set(r.left + mInset.left, r.top + mInset.top,
                           //r.right - mInset.right, r.bottom - mInset.bottom);
            //if (mInnerRect.width() < w && mInnerRect.height() < h) {
                //if (mInnerRadii != null) {
                    //mPath.addRoundRect(mInnerRect, mInnerRadii, Path.Direction.CCW);
                //} else {
                    //mPath.addRect(mInnerRect, Path.Direction.CCW);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:01.168 -0400",hash_original_method="C8F54F0C5741E48CA334E7AB381892D2",hash_generated_method="4940FA84ACC0E27BE9E0A8A450C20BA2")
@Override
    public RoundRectShape clone() throws CloneNotSupportedException {
        RoundRectShape shape;
        shape = (RoundRectShape) super.clone();
        shape.mOuterRadii = mOuterRadii != null ? mOuterRadii.clone() : null;
        shape.mInnerRadii = mInnerRadii != null ? mInnerRadii.clone() : null;
        shape.mInset = new RectF(mInset);
        shape.mInnerRect = new RectF(mInnerRect);
        shape.mPath = new Path(mPath);
        return (RoundRectShape)dsTaint.getTaint();
        // ---------- Original Method ----------
        //RoundRectShape shape = (RoundRectShape) super.clone();
        //shape.mOuterRadii = mOuterRadii != null ? mOuterRadii.clone() : null;
        //shape.mInnerRadii = mInnerRadii != null ? mInnerRadii.clone() : null;
        //shape.mInset = new RectF(mInset);
        //shape.mInnerRect = new RectF(mInnerRect);
        //shape.mPath = new Path(mPath);
        //return shape;
    }

    
}


