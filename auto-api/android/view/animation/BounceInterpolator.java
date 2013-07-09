package android.view.animation;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class BounceInterpolator implements Interpolator {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.451 -0400", hash_original_method = "D77038D4E75CFBDE4153E26F51FE597B", hash_generated_method = "BCAE75B7B1877E5388B55FDFCF96BAFF")
    public  BounceInterpolator() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.451 -0400", hash_original_method = "9DB8C06C387D34AE8BE8067DF59B6EF4", hash_generated_method = "D9972086DA5439C2A06C86F55A43A9FE")
    @SuppressWarnings({"UnusedDeclaration"})
    public  BounceInterpolator(Context context, AttributeSet attrs) {
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    private static float bounce(float t) {
        return t * t * 8.0f;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.451 -0400", hash_original_method = "41D2E1F4122985CE507D75E33078C1B7", hash_generated_method = "7E349E91C926AB9B820A255EE9603DB2")
    public float getInterpolation(float t) {
        t *= 1.1226f;
        float varC09F8F97BDC83BC8CFBEE84527DD3DCD_1092713726 = (bounce(t));
        float varCB99B770FB3048929834248630814BCC_229403516 = (bounce(t - 0.54719f) + 0.7f);
        float var2C2B60402FF7AC800DC47C91A3888151_693046350 = (bounce(t - 0.8526f) + 0.9f);
        float varDCA06D45DF8D777DE4133E13BE622156_107104985 = (bounce(t - 1.0435f) + 0.95f);
        addTaint(t);
        float var546ADE640B6EDFBC8A086EF31347E768_275961904 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_275961904;
        
        
        
        
        
        
    }

    
}

