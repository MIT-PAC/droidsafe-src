package android.view.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class BounceInterpolator implements Interpolator {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.747 -0400", hash_original_method = "D77038D4E75CFBDE4153E26F51FE597B", hash_generated_method = "BCAE75B7B1877E5388B55FDFCF96BAFF")
    public  BounceInterpolator() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.747 -0400", hash_original_method = "9DB8C06C387D34AE8BE8067DF59B6EF4", hash_generated_method = "367E2A2CCA9D6836860359C23DC3276A")
    @SuppressWarnings({"UnusedDeclaration"})
    public  BounceInterpolator(Context context, AttributeSet attrs) {
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
    private static float bounce(float t) {
        return t * t * 8.0f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.748 -0400", hash_original_method = "41D2E1F4122985CE507D75E33078C1B7", hash_generated_method = "A01FFCDE03B1DDD6C37CEEA181AD87A8")
    public float getInterpolation(float t) {
        addTaint(t);
        t *= 1.1226f;
    if(t < 0.3535f)        
        {
        float var69B7F5DCE725939B9EF4B0DC9CBDA765_1404420609 = (bounce(t));
                float var546ADE640B6EDFBC8A086EF31347E768_566210938 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_566210938;
        }
        else
    if(t < 0.7408f)        
        {
        float var836793277504BE03007E73B9A2D7A278_1735777889 = (bounce(t - 0.54719f) + 0.7f);
                float var546ADE640B6EDFBC8A086EF31347E768_702806342 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_702806342;
        }
        else
    if(t < 0.9644f)        
        {
        float var6233C0D320F4F3C000E77EB15F66B744_2114001545 = (bounce(t - 0.8526f) + 0.9f);
                float var546ADE640B6EDFBC8A086EF31347E768_938736748 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_938736748;
        }
        else
        {
        float var8641DFECEBCA7BCD9A4E0AD768D5677E_263547852 = (bounce(t - 1.0435f) + 0.95f);
                float var546ADE640B6EDFBC8A086EF31347E768_227974137 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_227974137;
        }
        // ---------- Original Method ----------
        //t *= 1.1226f;
        //if (t < 0.3535f) return bounce(t);
        //else if (t < 0.7408f) return bounce(t - 0.54719f) + 0.7f;
        //else if (t < 0.9644f) return bounce(t - 0.8526f) + 0.9f;
        //else return bounce(t - 1.0435f) + 0.95f;
    }

    
}

