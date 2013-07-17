package android.graphics.drawable.shapes;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class Shape implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.862 -0400", hash_original_field = "A3DB1626A190732E588FD0D14FC8FB31", hash_generated_field = "08D9327CB0A0089C173FB95F7B57B648")

    private float mWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.862 -0400", hash_original_field = "483542B05A951AA16D89C7F809C20811", hash_generated_field = "AB7D3C8140C4809E830D256F2E315AC4")

    private float mHeight;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.862 -0400", hash_original_method = "DE7169FFA3F4BAA3781895C367880AD0", hash_generated_method = "DE7169FFA3F4BAA3781895C367880AD0")
    public Shape ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.863 -0400", hash_original_method = "AE68E159D936DCF4407D65307DCA00BB", hash_generated_method = "08712320330AFFF8EC5E9C9A5E581779")
    public final float getWidth() {
        float varA3DB1626A190732E588FD0D14FC8FB31_113355619 = (mWidth);
                float var546ADE640B6EDFBC8A086EF31347E768_1078334916 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1078334916;
        // ---------- Original Method ----------
        //return mWidth;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.863 -0400", hash_original_method = "DE764EE6028A1B0E9211313F1870FFB9", hash_generated_method = "E04AF9E7F151FEBE6F14FB01C79E55F5")
    public final float getHeight() {
        float var483542B05A951AA16D89C7F809C20811_361476375 = (mHeight);
                float var546ADE640B6EDFBC8A086EF31347E768_527125968 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_527125968;
        // ---------- Original Method ----------
        //return mHeight;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract void draw(Canvas canvas, Paint paint);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.864 -0400", hash_original_method = "479131B2F6B84573C2C45F62E9B9CD93", hash_generated_method = "0005C399ECDAC583EA7CF26BC52623DF")
    public final void resize(float width, float height) {
        if(width < 0)        
        {
            width = 0;
        } //End block
        if(height < 0)        
        {
            height =0;
        } //End block
        if(mWidth != width || mHeight != height)        
        {
            mWidth = width;
            mHeight = height;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.865 -0400", hash_original_method = "E1C0EB5C360EF4564AFB59E1743F2057", hash_generated_method = "5E96AF5704951AB7BB19B4B60B21FE50")
    public boolean hasAlpha() {
        boolean varB326B5062B2F0E69046810717534CB09_1254298347 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_792572299 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_792572299;
        // ---------- Original Method ----------
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.866 -0400", hash_original_method = "BE42972290D2C4FCDE54C91B730EEF2B", hash_generated_method = "8DB1B544845DD6BA7EDC971E45AACF98")
    protected void onResize(float width, float height) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(height);
        addTaint(width);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.866 -0400", hash_original_method = "581DCFE006AA020FE949D9FFE91E7EA5", hash_generated_method = "67E6426C2709EF2D90456F7388E0D053")
    @Override
    public Shape clone() throws CloneNotSupportedException {
Shape varB632EBC59CAD06503BD7942F64659BCA_1421381751 =         (Shape) super.clone();
        varB632EBC59CAD06503BD7942F64659BCA_1421381751.addTaint(taint);
        return varB632EBC59CAD06503BD7942F64659BCA_1421381751;
        // ---------- Original Method ----------
        //return (Shape) super.clone();
    }

    
}

