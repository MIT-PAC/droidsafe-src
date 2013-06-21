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
    private float mFromAlpha;
    private float mToAlpha;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.974 -0400", hash_original_method = "C876E0498492EBC100852A514EEAC281", hash_generated_method = "FBE55F39925D7C3DCA98CF69B123173E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AlphaAnimation(Context context, AttributeSet attrs) {
        super(context, attrs);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.AlphaAnimation);
        mFromAlpha = a.getFloat(com.android.internal.R.styleable.AlphaAnimation_fromAlpha, 1.0f);
        mToAlpha = a.getFloat(com.android.internal.R.styleable.AlphaAnimation_toAlpha, 1.0f);
        a.recycle();
        // ---------- Original Method ----------
        //TypedArray a =
            //context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.AlphaAnimation);
        //mFromAlpha = a.getFloat(com.android.internal.R.styleable.AlphaAnimation_fromAlpha, 1.0f);
        //mToAlpha = a.getFloat(com.android.internal.R.styleable.AlphaAnimation_toAlpha, 1.0f);
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.975 -0400", hash_original_method = "DFFB255DB5DD71C3FC3D40107483D6B8", hash_generated_method = "6AA1E61736356A3AE6457E0003BE5755")
    @DSModeled(DSC.SAFE)
    public AlphaAnimation(float fromAlpha, float toAlpha) {
        dsTaint.addTaint(fromAlpha);
        dsTaint.addTaint(toAlpha);
        // ---------- Original Method ----------
        //mFromAlpha = fromAlpha;
        //mToAlpha = toAlpha;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.975 -0400", hash_original_method = "C966828EC5DEEE2C5EF9ADFBDC1A50C3", hash_generated_method = "D0FF5B3B8396CF099A24F1F72CCB537F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        dsTaint.addTaint(t.dsTaint);
        dsTaint.addTaint(interpolatedTime);
        float alpha;
        alpha = mFromAlpha;
        t.setAlpha(alpha + ((mToAlpha - alpha) * interpolatedTime));
        // ---------- Original Method ----------
        //final float alpha = mFromAlpha;
        //t.setAlpha(alpha + ((mToAlpha - alpha) * interpolatedTime));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.975 -0400", hash_original_method = "484D654BC6ACB95ED68989DAAEF2DE56", hash_generated_method = "FB6D2B72046DE2392DE2832B8B309654")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean willChangeTransformationMatrix() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.975 -0400", hash_original_method = "B56BC808CAC9750B79234A1D767E6B5D", hash_generated_method = "915103B04EB3C7A0335B89E53C5A8523")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean willChangeBounds() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.976 -0400", hash_original_method = "E1C0EB5C360EF4564AFB59E1743F2057", hash_generated_method = "0622B7A113BAD8B7D9741F85AF1730D3")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean hasAlpha() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
}

