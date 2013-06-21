package android.view.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class BounceInterpolator implements Interpolator {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.102 -0400", hash_original_method = "D77038D4E75CFBDE4153E26F51FE597B", hash_generated_method = "BCAE75B7B1877E5388B55FDFCF96BAFF")
    @DSModeled(DSC.SAFE)
    public BounceInterpolator() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.103 -0400", hash_original_method = "9DB8C06C387D34AE8BE8067DF59B6EF4", hash_generated_method = "CC28EF732368DA6E894A22ABAFA151D8")
    @DSModeled(DSC.SAFE)
    @SuppressWarnings({"UnusedDeclaration"})
    public BounceInterpolator(Context context, AttributeSet attrs) {
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
        private static float bounce(float t) {
        return t * t * 8.0f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.103 -0400", hash_original_method = "41D2E1F4122985CE507D75E33078C1B7", hash_generated_method = "728374ECBAB76055E2623B0C417B7286")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getInterpolation(float t) {
        dsTaint.addTaint(t);
        t *= 1.1226f;
        float varC09F8F97BDC83BC8CFBEE84527DD3DCD_146596670 = (bounce(t));
        float varCB99B770FB3048929834248630814BCC_2084990911 = (bounce(t - 0.54719f) + 0.7f);
        float var2C2B60402FF7AC800DC47C91A3888151_1956015894 = (bounce(t - 0.8526f) + 0.9f);
        float varDCA06D45DF8D777DE4133E13BE622156_1381855511 = (bounce(t - 1.0435f) + 0.95f);
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //t *= 1.1226f;
        //if (t < 0.3535f) return bounce(t);
        //else if (t < 0.7408f) return bounce(t - 0.54719f) + 0.7f;
        //else if (t < 0.9644f) return bounce(t - 0.8526f) + 0.9f;
        //else return bounce(t - 1.0435f) + 0.95f;
    }

    
}

