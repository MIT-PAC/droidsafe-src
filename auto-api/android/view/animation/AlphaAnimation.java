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

public class AlphaAnimation extends Animation {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.957 -0400", hash_original_field = "B07850EE7AEF229E426B7DD4E4BFC2DD", hash_generated_field = "8F4B3BC969A678303075525E27D7DA3B")

    private float mFromAlpha;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.957 -0400", hash_original_field = "2ADAC0695AC76E4E87FBD8B1EC1E031D", hash_generated_field = "502F747FAFE7DD3F43919C5E02F013F8")

    private float mToAlpha;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.961 -0400", hash_original_method = "C876E0498492EBC100852A514EEAC281", hash_generated_method = "F2A0F51038D413200218AC1BEA6352DB")
    public  AlphaAnimation(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.AlphaAnimation);
        mFromAlpha = a.getFloat(com.android.internal.R.styleable.AlphaAnimation_fromAlpha, 1.0f);
        mToAlpha = a.getFloat(com.android.internal.R.styleable.AlphaAnimation_toAlpha, 1.0f);
        a.recycle();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
        //TypedArray a =
            //context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.AlphaAnimation);
        //mFromAlpha = a.getFloat(com.android.internal.R.styleable.AlphaAnimation_fromAlpha, 1.0f);
        //mToAlpha = a.getFloat(com.android.internal.R.styleable.AlphaAnimation_toAlpha, 1.0f);
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.962 -0400", hash_original_method = "DFFB255DB5DD71C3FC3D40107483D6B8", hash_generated_method = "7E04B9E7B71153B6C1B61C22649FFF9B")
    public  AlphaAnimation(float fromAlpha, float toAlpha) {
        mFromAlpha = fromAlpha;
        mToAlpha = toAlpha;
        // ---------- Original Method ----------
        //mFromAlpha = fromAlpha;
        //mToAlpha = toAlpha;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.962 -0400", hash_original_method = "C966828EC5DEEE2C5EF9ADFBDC1A50C3", hash_generated_method = "489FF0A98524FAEDCD4F3C58938A1A8D")
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        float alpha;
        alpha = mFromAlpha;
        t.setAlpha(alpha + ((mToAlpha - alpha) * interpolatedTime));
        addTaint(interpolatedTime);
        addTaint(t.getTaint());
        // ---------- Original Method ----------
        //final float alpha = mFromAlpha;
        //t.setAlpha(alpha + ((mToAlpha - alpha) * interpolatedTime));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.963 -0400", hash_original_method = "484D654BC6ACB95ED68989DAAEF2DE56", hash_generated_method = "2098E13412A5FC84AB428FCC8A291090")
    @Override
    public boolean willChangeTransformationMatrix() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_196307124 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_196307124;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.969 -0400", hash_original_method = "B56BC808CAC9750B79234A1D767E6B5D", hash_generated_method = "EDD9277DF5F77F9F9A74622129F179D4")
    @Override
    public boolean willChangeBounds() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1588283764 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1588283764;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.972 -0400", hash_original_method = "E1C0EB5C360EF4564AFB59E1743F2057", hash_generated_method = "DE54223D5977D58D84D944FCB7F8AAE4")
    @Override
    public boolean hasAlpha() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1410413560 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1410413560;
        // ---------- Original Method ----------
        //return true;
    }

    
}

