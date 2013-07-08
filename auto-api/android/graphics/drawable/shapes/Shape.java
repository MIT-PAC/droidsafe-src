package android.graphics.drawable.shapes;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class Shape implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.694 -0400", hash_original_field = "A3DB1626A190732E588FD0D14FC8FB31", hash_generated_field = "08D9327CB0A0089C173FB95F7B57B648")

    private float mWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.694 -0400", hash_original_field = "483542B05A951AA16D89C7F809C20811", hash_generated_field = "AB7D3C8140C4809E830D256F2E315AC4")

    private float mHeight;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.694 -0400", hash_original_method = "DE7169FFA3F4BAA3781895C367880AD0", hash_generated_method = "DE7169FFA3F4BAA3781895C367880AD0")
    public Shape ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.695 -0400", hash_original_method = "AE68E159D936DCF4407D65307DCA00BB", hash_generated_method = "4E77FD7D7191711C4DD355669C351A06")
    public final float getWidth() {
        float var546ADE640B6EDFBC8A086EF31347E768_1860960773 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1860960773;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.696 -0400", hash_original_method = "DE764EE6028A1B0E9211313F1870FFB9", hash_generated_method = "7AF866EBA95EEF88E541759397C21BB2")
    public final float getHeight() {
        float var546ADE640B6EDFBC8A086EF31347E768_1078840696 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1078840696;
        
        
    }

    
    public abstract void draw(Canvas canvas, Paint paint);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.697 -0400", hash_original_method = "479131B2F6B84573C2C45F62E9B9CD93", hash_generated_method = "86E0FB58B46B7D21741096FE2EF3FD49")
    public final void resize(float width, float height) {
        {
            width = 0;
        } 
        {
            height =0;
        } 
        {
            mWidth = width;
            mHeight = height;
            onResize(width, height);
        } 
        
        
            
        
        
            
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.697 -0400", hash_original_method = "E1C0EB5C360EF4564AFB59E1743F2057", hash_generated_method = "B57568F66A072FE113CF0D0A5B09AF36")
    public boolean hasAlpha() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2058178441 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2058178441;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.698 -0400", hash_original_method = "BE42972290D2C4FCDE54C91B730EEF2B", hash_generated_method = "64CCA2E80A449DC56DE13C39CAADC48D")
    protected void onResize(float width, float height) {
        
        addTaint(width);
        addTaint(height);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.699 -0400", hash_original_method = "581DCFE006AA020FE949D9FFE91E7EA5", hash_generated_method = "39CA5A82DD536DB19CFFA1E1A8116C18")
    @Override
    public Shape clone() throws CloneNotSupportedException {
        Shape varB4EAC82CA7396A68D541C85D26508E83_2127933309 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2127933309 = (Shape) super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_2127933309.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2127933309;
        
        
    }

    
}

