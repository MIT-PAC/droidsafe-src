package android.view.animation;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.util.AttributeSet;

public class BounceInterpolator implements Interpolator {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.085 -0500", hash_original_method = "CF1B738C3C29A998D09201CEFD64B6C7", hash_generated_method = "D71225CF7859E1919935DA421FBB23A0")
    
private static float bounce(float t) {
        return t * t * 8.0f;
    }
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.080 -0500", hash_original_method = "D77038D4E75CFBDE4153E26F51FE597B", hash_generated_method = "6C70A431107080396FEEE77824D013BB")
    
public BounceInterpolator() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.083 -0500", hash_original_method = "9DB8C06C387D34AE8BE8067DF59B6EF4", hash_generated_method = "F33E65D7C53CE9B32D7FB02B3016CDA6")
    
@SuppressWarnings({"UnusedDeclaration"})
    public BounceInterpolator(Context context, AttributeSet attrs) {
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.087 -0500", hash_original_method = "41D2E1F4122985CE507D75E33078C1B7", hash_generated_method = "90ED175F687447FA6DACA97109F45F44")
    
public float getInterpolation(float t) {
        // _b(t) = t * t * 8
        // bs(t) = _b(t) for t < 0.3535
        // bs(t) = _b(t - 0.54719) + 0.7 for t < 0.7408
        // bs(t) = _b(t - 0.8526) + 0.9 for t < 0.9644
        // bs(t) = _b(t - 1.0435) + 0.95 for t <= 1.0
        // b(t) = bs(t * 1.1226)
        t *= 1.1226f;
        if (t < 0.3535f) return bounce(t);
        else if (t < 0.7408f) return bounce(t - 0.54719f) + 0.7f;
        else if (t < 0.9644f) return bounce(t - 0.8526f) + 0.9f;
        else return bounce(t - 1.0435f) + 0.95f;
    }
    
}

