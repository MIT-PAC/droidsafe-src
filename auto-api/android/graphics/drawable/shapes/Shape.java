package android.graphics.drawable.shapes;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class Shape implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.992 -0400", hash_original_field = "A3DB1626A190732E588FD0D14FC8FB31", hash_generated_field = "08D9327CB0A0089C173FB95F7B57B648")

    private float mWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.993 -0400", hash_original_field = "483542B05A951AA16D89C7F809C20811", hash_generated_field = "AB7D3C8140C4809E830D256F2E315AC4")

    private float mHeight;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.000 -0400", hash_original_method = "DE7169FFA3F4BAA3781895C367880AD0", hash_generated_method = "DE7169FFA3F4BAA3781895C367880AD0")
    public Shape ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.000 -0400", hash_original_method = "AE68E159D936DCF4407D65307DCA00BB", hash_generated_method = "C8DC40054FB5DAE7FE12F47195EE1655")
    public final float getWidth() {
        float var546ADE640B6EDFBC8A086EF31347E768_519224472 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_519224472;
        // ---------- Original Method ----------
        //return mWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.001 -0400", hash_original_method = "DE764EE6028A1B0E9211313F1870FFB9", hash_generated_method = "3A27413BBFEBFD55ACCDE8767A9311F4")
    public final float getHeight() {
        float var546ADE640B6EDFBC8A086EF31347E768_2118159287 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2118159287;
        // ---------- Original Method ----------
        //return mHeight;
    }

    
    public abstract void draw(Canvas canvas, Paint paint);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.002 -0400", hash_original_method = "479131B2F6B84573C2C45F62E9B9CD93", hash_generated_method = "86E0FB58B46B7D21741096FE2EF3FD49")
    public final void resize(float width, float height) {
        {
            width = 0;
        } //End block
        {
            height =0;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.003 -0400", hash_original_method = "E1C0EB5C360EF4564AFB59E1743F2057", hash_generated_method = "526F5BEAADA7F6FC9C278F42113BC34A")
    public boolean hasAlpha() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1520545643 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1520545643;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.003 -0400", hash_original_method = "BE42972290D2C4FCDE54C91B730EEF2B", hash_generated_method = "64CCA2E80A449DC56DE13C39CAADC48D")
    protected void onResize(float width, float height) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(width);
        addTaint(height);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.004 -0400", hash_original_method = "581DCFE006AA020FE949D9FFE91E7EA5", hash_generated_method = "764516D3C9B7055E1D74741D460D8209")
    @Override
    public Shape clone() throws CloneNotSupportedException {
        Shape varB4EAC82CA7396A68D541C85D26508E83_1122347709 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1122347709 = (Shape) super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1122347709.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1122347709;
        // ---------- Original Method ----------
        //return (Shape) super.clone();
    }

    
}

