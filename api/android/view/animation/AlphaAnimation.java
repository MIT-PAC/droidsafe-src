package android.view.animation;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;





public class AlphaAnimation extends Animation {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.676 -0400", hash_original_field = "B07850EE7AEF229E426B7DD4E4BFC2DD", hash_generated_field = "8F4B3BC969A678303075525E27D7DA3B")

    private float mFromAlpha;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.676 -0400", hash_original_field = "2ADAC0695AC76E4E87FBD8B1EC1E031D", hash_generated_field = "502F747FAFE7DD3F43919C5E02F013F8")

    private float mToAlpha;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.677 -0400", hash_original_method = "C876E0498492EBC100852A514EEAC281", hash_generated_method = "E763CE01596363CF2569E58BA34F76AD")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.678 -0400", hash_original_method = "DFFB255DB5DD71C3FC3D40107483D6B8", hash_generated_method = "7E04B9E7B71153B6C1B61C22649FFF9B")
    public  AlphaAnimation(float fromAlpha, float toAlpha) {
        mFromAlpha = fromAlpha;
        mToAlpha = toAlpha;
        // ---------- Original Method ----------
        //mFromAlpha = fromAlpha;
        //mToAlpha = toAlpha;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.678 -0400", hash_original_method = "C966828EC5DEEE2C5EF9ADFBDC1A50C3", hash_generated_method = "6DF76B1F64A45DEDEA1BB459C7CD473C")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.678 -0400", hash_original_method = "484D654BC6ACB95ED68989DAAEF2DE56", hash_generated_method = "0A46F008F088D45B91CA76923EF5675C")
    @Override
    public boolean willChangeTransformationMatrix() {
        boolean var68934A3E9455FA72420237EB05902327_102490886 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_217891554 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_217891554;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.679 -0400", hash_original_method = "B56BC808CAC9750B79234A1D767E6B5D", hash_generated_method = "2B2362FAAA001AC29304F0DC81831A9C")
    @Override
    public boolean willChangeBounds() {
        boolean var68934A3E9455FA72420237EB05902327_663735715 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2121244018 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2121244018;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.679 -0400", hash_original_method = "E1C0EB5C360EF4564AFB59E1743F2057", hash_generated_method = "F2BC0D7CE54BB7B88ABD0C82ACB6038A")
    @Override
    public boolean hasAlpha() {
        boolean varB326B5062B2F0E69046810717534CB09_740075177 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1883194791 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1883194791;
        // ---------- Original Method ----------
        //return true;
    }

    
}

