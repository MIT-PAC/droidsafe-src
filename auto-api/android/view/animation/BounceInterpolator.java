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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.298 -0400", hash_original_method = "D77038D4E75CFBDE4153E26F51FE597B", hash_generated_method = "BCAE75B7B1877E5388B55FDFCF96BAFF")
    public  BounceInterpolator() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.299 -0400", hash_original_method = "9DB8C06C387D34AE8BE8067DF59B6EF4", hash_generated_method = "D9972086DA5439C2A06C86F55A43A9FE")
    @SuppressWarnings({"UnusedDeclaration"})
    public  BounceInterpolator(Context context, AttributeSet attrs) {
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
        private static float bounce(float t) {
        return t * t * 8.0f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.299 -0400", hash_original_method = "41D2E1F4122985CE507D75E33078C1B7", hash_generated_method = "2A8CE0DD7E644A41C8DFF1C65F450266")
    public float getInterpolation(float t) {
        t *= 1.1226f;
        float varC09F8F97BDC83BC8CFBEE84527DD3DCD_1383183866 = (bounce(t));
        float varCB99B770FB3048929834248630814BCC_387226613 = (bounce(t - 0.54719f) + 0.7f);
        float var2C2B60402FF7AC800DC47C91A3888151_1266108611 = (bounce(t - 0.8526f) + 0.9f);
        float varDCA06D45DF8D777DE4133E13BE622156_1724780810 = (bounce(t - 1.0435f) + 0.95f);
        addTaint(t);
        float var546ADE640B6EDFBC8A086EF31347E768_1142104336 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1142104336;
        // ---------- Original Method ----------
        //t *= 1.1226f;
        //if (t < 0.3535f) return bounce(t);
        //else if (t < 0.7408f) return bounce(t - 0.54719f) + 0.7f;
        //else if (t < 0.9644f) return bounce(t - 0.8526f) + 0.9f;
        //else return bounce(t - 1.0435f) + 0.95f;
    }

    
}

