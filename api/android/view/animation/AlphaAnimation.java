package android.view.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class AlphaAnimation extends Animation {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.492 -0400", hash_original_field = "B07850EE7AEF229E426B7DD4E4BFC2DD", hash_generated_field = "8F4B3BC969A678303075525E27D7DA3B")

    private float mFromAlpha;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.492 -0400", hash_original_field = "2ADAC0695AC76E4E87FBD8B1EC1E031D", hash_generated_field = "502F747FAFE7DD3F43919C5E02F013F8")

    private float mToAlpha;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.492 -0400", hash_original_method = "C876E0498492EBC100852A514EEAC281", hash_generated_method = "E763CE01596363CF2569E58BA34F76AD")
    public  AlphaAnimation(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.AlphaAnimation);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.493 -0400", hash_original_method = "DFFB255DB5DD71C3FC3D40107483D6B8", hash_generated_method = "7E04B9E7B71153B6C1B61C22649FFF9B")
    public  AlphaAnimation(float fromAlpha, float toAlpha) {
        mFromAlpha = fromAlpha;
        mToAlpha = toAlpha;
        // ---------- Original Method ----------
        //mFromAlpha = fromAlpha;
        //mToAlpha = toAlpha;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.493 -0400", hash_original_method = "C966828EC5DEEE2C5EF9ADFBDC1A50C3", hash_generated_method = "6DF76B1F64A45DEDEA1BB459C7CD473C")
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        addTaint(t.getTaint());
        addTaint(interpolatedTime);
        final float alpha = mFromAlpha;
        t.setAlpha(alpha + ((mToAlpha - alpha) * interpolatedTime));
        // ---------- Original Method ----------
        //final float alpha = mFromAlpha;
        //t.setAlpha(alpha + ((mToAlpha - alpha) * interpolatedTime));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.494 -0400", hash_original_method = "484D654BC6ACB95ED68989DAAEF2DE56", hash_generated_method = "93AB9A4E56639EF9D72ADD65BB1F9CCF")
    @Override
    public boolean willChangeTransformationMatrix() {
        boolean var68934A3E9455FA72420237EB05902327_1849825567 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1974636075 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1974636075;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.494 -0400", hash_original_method = "B56BC808CAC9750B79234A1D767E6B5D", hash_generated_method = "4CC5AE47C9F1160A46FBD72071E2A95C")
    @Override
    public boolean willChangeBounds() {
        boolean var68934A3E9455FA72420237EB05902327_1647180331 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1580424230 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1580424230;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.494 -0400", hash_original_method = "E1C0EB5C360EF4564AFB59E1743F2057", hash_generated_method = "56A51EE9DEA2F1C32860F37DF590D018")
    @Override
    public boolean hasAlpha() {
        boolean varB326B5062B2F0E69046810717534CB09_1507716300 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2065039452 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2065039452;
        // ---------- Original Method ----------
        //return true;
    }

    
}

