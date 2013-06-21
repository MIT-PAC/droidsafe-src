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
    private float mWidth;
    private float mHeight;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.729 -0400", hash_original_method = "0799087D90C21671208C7934CD3498AD", hash_generated_method = "0799087D90C21671208C7934CD3498AD")
        public Shape ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.729 -0400", hash_original_method = "AE68E159D936DCF4407D65307DCA00BB", hash_generated_method = "58218BB16112AA4158D0D55C2D663C76")
    @DSModeled(DSC.SAFE)
    public final float getWidth() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.730 -0400", hash_original_method = "DE764EE6028A1B0E9211313F1870FFB9", hash_generated_method = "D21570CDDF12818AE086DB1A716E58D5")
    @DSModeled(DSC.SAFE)
    public final float getHeight() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mHeight;
    }

    
    public abstract void draw(Canvas canvas, Paint paint);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.730 -0400", hash_original_method = "479131B2F6B84573C2C45F62E9B9CD93", hash_generated_method = "00930CE8D0B4EC78E9A07E25463DB353")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.730 -0400", hash_original_method = "E1C0EB5C360EF4564AFB59E1743F2057", hash_generated_method = "461DA163657BF449C403483F0E3BC9AB")
    @DSModeled(DSC.SAFE)
    public boolean hasAlpha() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.731 -0400", hash_original_method = "BE42972290D2C4FCDE54C91B730EEF2B", hash_generated_method = "6A10CB02B2C542D1B6111EA4AE6B1A9D")
    @DSModeled(DSC.SAFE)
    protected void onResize(float width, float height) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.731 -0400", hash_original_method = "581DCFE006AA020FE949D9FFE91E7EA5", hash_generated_method = "9EE26E189D27674C5F98583A7C8CFC05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Shape clone() throws CloneNotSupportedException {
        Shape var09BD8B1E17E236D76C9C15FDC0BEBE9E_696877802 = ((Shape) super.clone());
        return (Shape)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (Shape) super.clone();
    }

    
}

