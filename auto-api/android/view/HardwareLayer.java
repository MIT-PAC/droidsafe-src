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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.449 -0400", hash_original_field = "A3DB1626A190732E588FD0D14FC8FB31", hash_generated_field = "AF6410B200BC05DCA2CF0BE65165448A")

    int mWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.449 -0400", hash_original_field = "483542B05A951AA16D89C7F809C20811", hash_generated_field = "7DDAE255893B528E7BEBEC203BC2D9F3")

    int mHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.449 -0400", hash_original_field = "D57F412B2FBE34E5266AB85A3EC09555", hash_generated_field = "1A5E1BEFDB0DF6CE4A573A377262DC5D")

    boolean mOpaque;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.461 -0400", hash_original_method = "4AE458D6667BFFD1B9464B983848F2AB", hash_generated_method = "92D52C23F6DFF44BDBE3EFECA1FD8C4D")
      HardwareLayer() {
        this(DIMENSION_UNDEFINED, DIMENSION_UNDEFINED, false);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.462 -0400", hash_original_method = "1344419F3E25BE7760177B4956551826", hash_generated_method = "FBBAA57B0C2969B94BC83489D95BFD96")
      HardwareLayer(int width, int height, boolean isOpaque) {
        mWidth = width;
        mHeight = height;
        mOpaque = isOpaque;
        // ---------- Original Method ----------
        //mWidth = width;
        //mHeight = height;
        //mOpaque = isOpaque;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.463 -0400", hash_original_method = "AA9BA105372BFC95AFBABED408315F5C", hash_generated_method = "E59437D814C2DB5DE184A1412FD4EE75")
     int getWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_709260838 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_709260838;
        // ---------- Original Method ----------
        //return mWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.463 -0400", hash_original_method = "0304EDCF78FF45B68A7EB91BFEAAA2CD", hash_generated_method = "0415CBCC21EB171BAEF2DFDCC80F29CC")
     int getHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2067916092 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2067916092;
        // ---------- Original Method ----------
        //return mHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.463 -0400", hash_original_method = "AB6C012A4EC234C0DA96929A7EE984CD", hash_generated_method = "254C429C3E425840D02750900BEBD756")
     boolean isOpaque() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_958390740 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_958390740;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.479 -0400", hash_original_method = "5ABA86D5BFEB1909CF7BF3A4764A9281", hash_generated_method = "CA074DCC936D440D7E2E186DB523EB09")
     void update(int width, int height, boolean isOpaque) {
        mWidth = width;
        mHeight = height;
        mOpaque = isOpaque;
        // ---------- Original Method ----------
        //mWidth = width;
        //mHeight = height;
        //mOpaque = isOpaque;
    }

    
    abstract void setTransform(Matrix matrix);

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.479 -0400", hash_original_field = "F0DD095A8DCED65496FFC5741CE44F3F", hash_generated_field = "11D36BD26EC6A230F5E0C7A5996FD684")

    static int DIMENSION_UNDEFINED = -1;
}

