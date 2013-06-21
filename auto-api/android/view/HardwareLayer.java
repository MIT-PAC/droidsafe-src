package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;

abstract class HardwareLayer {
    int mWidth;
    int mHeight;
    boolean mOpaque;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.731 -0400", hash_original_method = "4AE458D6667BFFD1B9464B983848F2AB", hash_generated_method = "92D52C23F6DFF44BDBE3EFECA1FD8C4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     HardwareLayer() {
        this(DIMENSION_UNDEFINED, DIMENSION_UNDEFINED, false);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.731 -0400", hash_original_method = "1344419F3E25BE7760177B4956551826", hash_generated_method = "7240EB6F23007FCD07296B2AD9662242")
    @DSModeled(DSC.SAFE)
     HardwareLayer(int width, int height, boolean isOpaque) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        dsTaint.addTaint(isOpaque);
        // ---------- Original Method ----------
        //mWidth = width;
        //mHeight = height;
        //mOpaque = isOpaque;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.731 -0400", hash_original_method = "AA9BA105372BFC95AFBABED408315F5C", hash_generated_method = "90F3BA870ED6B5EBF5902C2B2FA837B0")
    @DSModeled(DSC.SAFE)
     int getWidth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.731 -0400", hash_original_method = "0304EDCF78FF45B68A7EB91BFEAAA2CD", hash_generated_method = "BB57510AB364E705B686AA16D8961A34")
    @DSModeled(DSC.SAFE)
     int getHeight() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.731 -0400", hash_original_method = "AB6C012A4EC234C0DA96929A7EE984CD", hash_generated_method = "005FC5BE9C4FBDD638707E2D9D7CB36F")
    @DSModeled(DSC.SAFE)
     boolean isOpaque() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mOpaque;
    }

    
    abstract boolean isValid();

    
    abstract void resize(int width, int height);

    
    abstract HardwareCanvas getCanvas();

    
    abstract void destroy();

    
    abstract HardwareCanvas start(Canvas currentCanvas);

    
    abstract void end(Canvas currentCanvas);

    
    abstract boolean copyInto(Bitmap bitmap);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.732 -0400", hash_original_method = "5ABA86D5BFEB1909CF7BF3A4764A9281", hash_generated_method = "8C28FB45E4200F6384F0A6547AFA830C")
    @DSModeled(DSC.SAFE)
     void update(int width, int height, boolean isOpaque) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        dsTaint.addTaint(isOpaque);
        // ---------- Original Method ----------
        //mWidth = width;
        //mHeight = height;
        //mOpaque = isOpaque;
    }

    
    abstract void setTransform(Matrix matrix);

    
    static final int DIMENSION_UNDEFINED = -1;
}

