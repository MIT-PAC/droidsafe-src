package android.graphics.drawable.shapes;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class Shape implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.899 -0400", hash_original_field = "A3DB1626A190732E588FD0D14FC8FB31", hash_generated_field = "08D9327CB0A0089C173FB95F7B57B648")

    private float mWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.899 -0400", hash_original_field = "483542B05A951AA16D89C7F809C20811", hash_generated_field = "AB7D3C8140C4809E830D256F2E315AC4")

    private float mHeight;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.899 -0400", hash_original_method = "DE7169FFA3F4BAA3781895C367880AD0", hash_generated_method = "DE7169FFA3F4BAA3781895C367880AD0")
    public Shape ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.899 -0400", hash_original_method = "AE68E159D936DCF4407D65307DCA00BB", hash_generated_method = "E48014F70D3E5F39E0DCF1DF595CAD23")
    public final float getWidth() {
        float varA3DB1626A190732E588FD0D14FC8FB31_1487139116 = (mWidth);
                float var546ADE640B6EDFBC8A086EF31347E768_160340390 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_160340390;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.900 -0400", hash_original_method = "DE764EE6028A1B0E9211313F1870FFB9", hash_generated_method = "76CAFF0E3110953EB38006D931D7826E")
    public final float getHeight() {
        float var483542B05A951AA16D89C7F809C20811_225719814 = (mHeight);
                float var546ADE640B6EDFBC8A086EF31347E768_1043871658 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1043871658;
        
        
    }

    
    public abstract void draw(Canvas canvas, Paint paint);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.901 -0400", hash_original_method = "479131B2F6B84573C2C45F62E9B9CD93", hash_generated_method = "0005C399ECDAC583EA7CF26BC52623DF")
    public final void resize(float width, float height) {
    if(width < 0)        
        {
            width = 0;
        } 
    if(height < 0)        
        {
            height =0;
        } 
    if(mWidth != width || mHeight != height)        
        {
            mWidth = width;
            mHeight = height;
            onResize(width, height);
        } 
        
        
            
        
        
            
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.901 -0400", hash_original_method = "E1C0EB5C360EF4564AFB59E1743F2057", hash_generated_method = "6E65011723CE7E6BDFCC452E8AD78986")
    public boolean hasAlpha() {
        boolean varB326B5062B2F0E69046810717534CB09_354796770 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1250367609 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1250367609;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.902 -0400", hash_original_method = "BE42972290D2C4FCDE54C91B730EEF2B", hash_generated_method = "8DB1B544845DD6BA7EDC971E45AACF98")
    protected void onResize(float width, float height) {
        
        addTaint(height);
        addTaint(width);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.902 -0400", hash_original_method = "581DCFE006AA020FE949D9FFE91E7EA5", hash_generated_method = "2D84F0D3F89D5F878278949D3282BE9D")
    @Override
    public Shape clone() throws CloneNotSupportedException {
Shape varB632EBC59CAD06503BD7942F64659BCA_1263079991 =         (Shape) super.clone();
        varB632EBC59CAD06503BD7942F64659BCA_1263079991.addTaint(taint);
        return varB632EBC59CAD06503BD7942F64659BCA_1263079991;
        
        
    }

    
}

