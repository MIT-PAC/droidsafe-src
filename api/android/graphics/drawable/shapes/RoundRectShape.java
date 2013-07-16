package android.graphics.drawable.shapes;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

public class RoundRectShape extends RectShape {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.888 -0400", hash_original_field = "68D931F8388C49D8823BCF532F82A9A6", hash_generated_field = "6830495B7E4516D5AD2F6812EB294538")

    private float[] mOuterRadii;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.888 -0400", hash_original_field = "CF7B030D6062D49C71B570885E3215E0", hash_generated_field = "D2729CA6AA6C83F02D0889C112109BB9")

    private RectF mInset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.888 -0400", hash_original_field = "A6A16C7DD74ADEEBC4B029FFD9506FDE", hash_generated_field = "F28D8A31EA09EA2173CBE320E200D4AF")

    private float[] mInnerRadii;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.888 -0400", hash_original_field = "5B44FC9034F0DBA89B65AA417F353CFB", hash_generated_field = "8D82BE416946019DAC8D55ACEFBD37C0")

    private RectF mInnerRect;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.888 -0400", hash_original_field = "FB4FCB3508FC66D4E3F113990AC335C6", hash_generated_field = "101E51A8003B09B39CD3C51138473AB6")

    private Path mPath;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.889 -0400", hash_original_method = "BFB37C497FF277AFDA0C7FF1B797A20B", hash_generated_method = "BDCC58A5738C946C01F8FF4317D1875E")
    public  RoundRectShape(float[] outerRadii, RectF inset,
                          float[] innerRadii) {
    if(outerRadii != null && outerRadii.length < 8)        
        {
            ArrayIndexOutOfBoundsException var8E9EFB62FA44DFF932FD8F4A104B3011_1227019666 = new ArrayIndexOutOfBoundsException("outer radii must have >= 8 values");
            var8E9EFB62FA44DFF932FD8F4A104B3011_1227019666.addTaint(taint);
            throw var8E9EFB62FA44DFF932FD8F4A104B3011_1227019666;
        } //End block
    if(innerRadii != null && innerRadii.length < 8)        
        {
            ArrayIndexOutOfBoundsException varEA92C32A253067335B2FC46E6E2144DE_1641832609 = new ArrayIndexOutOfBoundsException("inner radii must have >= 8 values");
            varEA92C32A253067335B2FC46E6E2144DE_1641832609.addTaint(taint);
            throw varEA92C32A253067335B2FC46E6E2144DE_1641832609;
        } //End block
        mOuterRadii = outerRadii;
        mInset = inset;
        mInnerRadii = innerRadii;
    if(inset != null)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.890 -0400", hash_original_method = "2040FB3810CEA26BCA97DD1BCDDED3AB", hash_generated_method = "5A8E3A9F0731F4E763FCC10657835012")
    @Override
    public void draw(Canvas canvas, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(canvas.getTaint());
        canvas.drawPath(mPath, paint);
        // ---------- Original Method ----------
        //canvas.drawPath(mPath, paint);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.890 -0400", hash_original_method = "76E13F34AD3978846D0DA3AA18C0FAE1", hash_generated_method = "735F9B12D406D8A9FFB85CD16A55E733")
    @Override
    protected void onResize(float w, float h) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(h);
        addTaint(w);
        super.onResize(w, h);
        RectF r = rect();
        mPath.reset();
    if(mOuterRadii != null)        
        {
            mPath.addRoundRect(r, mOuterRadii, Path.Direction.CW);
        } //End block
        else
        {
            mPath.addRect(r, Path.Direction.CW);
        } //End block
    if(mInnerRect != null)        
        {
            mInnerRect.set(r.left + mInset.left, r.top + mInset.top,
                           r.right - mInset.right, r.bottom - mInset.bottom);
    if(mInnerRect.width() < w && mInnerRect.height() < h)            
            {
    if(mInnerRadii != null)                
                {
                    mPath.addRoundRect(mInnerRect, mInnerRadii, Path.Direction.CCW);
                } //End block
                else
                {
                    mPath.addRect(mInnerRect, Path.Direction.CCW);
                } //End block
            } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.891 -0400", hash_original_method = "C8F54F0C5741E48CA334E7AB381892D2", hash_generated_method = "1FBD5A284A46A5247A946486E8EDB55D")
    @Override
    public RoundRectShape clone() throws CloneNotSupportedException {
        RoundRectShape shape = (RoundRectShape) super.clone();
        shape.mOuterRadii = mOuterRadii != null ? mOuterRadii.clone() : null;
        shape.mInnerRadii = mInnerRadii != null ? mInnerRadii.clone() : null;
        shape.mInset = new RectF(mInset);
        shape.mInnerRect = new RectF(mInnerRect);
        shape.mPath = new Path(mPath);
RoundRectShape var1E03F90B1057A29F071E0E1A1AD4365B_726902994 =         shape;
        var1E03F90B1057A29F071E0E1A1AD4365B_726902994.addTaint(taint);
        return var1E03F90B1057A29F071E0E1A1AD4365B_726902994;
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

