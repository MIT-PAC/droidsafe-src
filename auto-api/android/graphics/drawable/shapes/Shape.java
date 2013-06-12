package android.graphics.drawable.shapes;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class Shape implements Cloneable {
    private float mWidth;
    private float mHeight;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.170 -0400", hash_original_method = "AE68E159D936DCF4407D65307DCA00BB", hash_generated_method = "B6F58769457938367AEBFE7A9F9647DF")
    @DSModeled(DSC.SAFE)
    public final float getWidth() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.170 -0400", hash_original_method = "DE764EE6028A1B0E9211313F1870FFB9", hash_generated_method = "F1F3A079FFAB11307E3196A16B90B822")
    @DSModeled(DSC.SAFE)
    public final float getHeight() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mHeight;
    }

    
    public abstract void draw(Canvas canvas, Paint paint);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.170 -0400", hash_original_method = "479131B2F6B84573C2C45F62E9B9CD93", hash_generated_method = "FB74BC839B3B419056E5804010BCC571")
    @DSModeled(DSC.SAFE)
    public final void resize(float width, float height) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        {
            width = 0;
        } //End block
        {
            height =0;
        } //End block
        {
            onResize(width, height);
        } //End block
        // ---------- Original Method ----------
        //if (width < 0) {
            //width = 0;
        //}
        //if (height < 0) {
            //height =0;
        //}
        //if (mWidth != width || mHeight != height) {
            //mWidth = width;
            //mHeight = height;
            //onResize(width, height);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.170 -0400", hash_original_method = "E1C0EB5C360EF4564AFB59E1743F2057", hash_generated_method = "159AAB2E35D7561CF0C3D2EB76011CE5")
    @DSModeled(DSC.SAFE)
    public boolean hasAlpha() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.170 -0400", hash_original_method = "BE42972290D2C4FCDE54C91B730EEF2B", hash_generated_method = "8C04D251C984789F4336220FDFD79271")
    @DSModeled(DSC.SAFE)
    protected void onResize(float width, float height) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.170 -0400", hash_original_method = "581DCFE006AA020FE949D9FFE91E7EA5", hash_generated_method = "9E6B8F4620EB8E5DFBB3E3DAFABB49F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Shape clone() throws CloneNotSupportedException {
        Shape var09BD8B1E17E236D76C9C15FDC0BEBE9E_1075516553 = ((Shape) super.clone());
        return (Shape)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (Shape) super.clone();
    }

    
}


