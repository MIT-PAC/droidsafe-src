package android.view.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class AlphaAnimation extends Animation {
    private float mFromAlpha;
    private float mToAlpha;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.819 -0400", hash_original_method = "C876E0498492EBC100852A514EEAC281", hash_generated_method = "C2CDD557671B1A414B5C0A0697147874")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.820 -0400", hash_original_method = "DFFB255DB5DD71C3FC3D40107483D6B8", hash_generated_method = "8E8B54E3C6125D895B3222B236A4219C")
    @DSModeled(DSC.SAFE)
    public AlphaAnimation(float fromAlpha, float toAlpha) {
        dsTaint.addTaint(fromAlpha);
        dsTaint.addTaint(toAlpha);
        // ---------- Original Method ----------
        //mFromAlpha = fromAlpha;
        //mToAlpha = toAlpha;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.820 -0400", hash_original_method = "C966828EC5DEEE2C5EF9ADFBDC1A50C3", hash_generated_method = "EB97BCD846E447C01A7A2BD51B58CCC0")
    @DSModeled(DSC.SAFE)
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        dsTaint.addTaint(t.dsTaint);
        dsTaint.addTaint(interpolatedTime);
        final float alpha;
        alpha = mFromAlpha;
        t.setAlpha(alpha + ((mToAlpha - alpha) * interpolatedTime));
        // ---------- Original Method ----------
        //final float alpha = mFromAlpha;
        //t.setAlpha(alpha + ((mToAlpha - alpha) * interpolatedTime));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.820 -0400", hash_original_method = "484D654BC6ACB95ED68989DAAEF2DE56", hash_generated_method = "6D5A3FADED34E3DBD71A271076135B86")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean willChangeTransformationMatrix() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.820 -0400", hash_original_method = "B56BC808CAC9750B79234A1D767E6B5D", hash_generated_method = "A03F7E5CD531B0A33F489B42294918ED")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean willChangeBounds() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.820 -0400", hash_original_method = "E1C0EB5C360EF4564AFB59E1743F2057", hash_generated_method = "D72D5138BCE4B130AD793898CE1F03C3")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean hasAlpha() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
}


