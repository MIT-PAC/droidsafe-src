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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.685 -0400", hash_original_field = "68D931F8388C49D8823BCF532F82A9A6", hash_generated_field = "6830495B7E4516D5AD2F6812EB294538")

    private float[] mOuterRadii;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.685 -0400", hash_original_field = "CF7B030D6062D49C71B570885E3215E0", hash_generated_field = "D2729CA6AA6C83F02D0889C112109BB9")

    private RectF mInset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.686 -0400", hash_original_field = "A6A16C7DD74ADEEBC4B029FFD9506FDE", hash_generated_field = "F28D8A31EA09EA2173CBE320E200D4AF")

    private float[] mInnerRadii;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.686 -0400", hash_original_field = "5B44FC9034F0DBA89B65AA417F353CFB", hash_generated_field = "8D82BE416946019DAC8D55ACEFBD37C0")

    private RectF mInnerRect;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.686 -0400", hash_original_field = "FB4FCB3508FC66D4E3F113990AC335C6", hash_generated_field = "101E51A8003B09B39CD3C51138473AB6")

    private Path mPath;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.686 -0400", hash_original_method = "BFB37C497FF277AFDA0C7FF1B797A20B", hash_generated_method = "94B0D9B05F731E5147F7A0229DF87285")
    public  RoundRectShape(float[] outerRadii, RectF inset,
                          float[] innerRadii) {
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException("outer radii must have >= 8 values");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException("inner radii must have >= 8 values");
        } //End block
        mOuterRadii = outerRadii;
        mInset = inset;
        mInnerRadii = innerRadii;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.687 -0400", hash_original_method = "2040FB3810CEA26BCA97DD1BCDDED3AB", hash_generated_method = "B30DDC876EC034A877CEF75817710D39")
    @Override
    public void draw(Canvas canvas, Paint paint) {
        canvas.drawPath(mPath, paint);
        addTaint(canvas.getTaint());
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //canvas.drawPath(mPath, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.687 -0400", hash_original_method = "76E13F34AD3978846D0DA3AA18C0FAE1", hash_generated_method = "204679C09190CD018CC8744118485983")
    @Override
    protected void onResize(float w, float h) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onResize(w, h);
        RectF r = rect();
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
                boolean varFA69053F663231AFFAF816545E5D72F2_1169951959 = (mInnerRect.width() < w && mInnerRect.height() < h);
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
        addTaint(w);
        addTaint(h);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.688 -0400", hash_original_method = "C8F54F0C5741E48CA334E7AB381892D2", hash_generated_method = "20C1954FF9750C817659025E58F24F38")
    @Override
    public RoundRectShape clone() throws CloneNotSupportedException {
        RoundRectShape varB4EAC82CA7396A68D541C85D26508E83_47322483 = null; //Variable for return #1
        RoundRectShape shape = (RoundRectShape) super.clone();
        shape.mOuterRadii = mOuterRadii != null ? mOuterRadii.clone() : null;
        shape.mInnerRadii = mInnerRadii != null ? mInnerRadii.clone() : null;
        shape.mInset = new RectF(mInset);
        shape.mInnerRect = new RectF(mInnerRect);
        shape.mPath = new Path(mPath);
        varB4EAC82CA7396A68D541C85D26508E83_47322483 = shape;
        varB4EAC82CA7396A68D541C85D26508E83_47322483.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_47322483;
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

