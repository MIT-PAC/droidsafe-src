package android.view.animation;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class AlphaAnimation extends Animation {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.147 -0500", hash_original_field = "5EA400953DB057E41C35C06D13F9FFDA", hash_generated_field = "8F4B3BC969A678303075525E27D7DA3B")

    private float mFromAlpha;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.149 -0500", hash_original_field = "44B2B066A25D4FA3AB33A72A50741FC3", hash_generated_field = "502F747FAFE7DD3F43919C5E02F013F8")

    private float mToAlpha;

    /**
     * Constructor used when an AlphaAnimation is loaded from a resource. 
     * 
     * @param context Application context to use
     * @param attrs Attribute set from which to read values
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.152 -0500", hash_original_method = "C876E0498492EBC100852A514EEAC281", hash_generated_method = "E8D13F92E4D5A8FCF20C60D0445F7401")
    
public AlphaAnimation(Context context, AttributeSet attrs) {
        super(context, attrs);
        
        TypedArray a =
            context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.AlphaAnimation);
        
        mFromAlpha = a.getFloat(com.android.internal.R.styleable.AlphaAnimation_fromAlpha, 1.0f);
        mToAlpha = a.getFloat(com.android.internal.R.styleable.AlphaAnimation_toAlpha, 1.0f);
        
        a.recycle();
    }
    
    /**
     * Constructor to use when building an AlphaAnimation from code
     * 
     * @param fromAlpha Starting alpha value for the animation, where 1.0 means
     *        fully opaque and 0.0 means fully transparent.
     * @param toAlpha Ending alpha value for the animation.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.155 -0500", hash_original_method = "DFFB255DB5DD71C3FC3D40107483D6B8", hash_generated_method = "4BCF8AF3DDE5297D42D5A4574268EB47")
    
public AlphaAnimation(float fromAlpha, float toAlpha) {
        mFromAlpha = fromAlpha;
        mToAlpha = toAlpha;
    }
    
    /**
     * Changes the alpha property of the supplied {@link Transformation}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.157 -0500", hash_original_method = "C966828EC5DEEE2C5EF9ADFBDC1A50C3", hash_generated_method = "424EEEDCB7CC4647A5F2BD09CECB4519")
    
@Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        final float alpha = mFromAlpha;
        t.setAlpha(alpha + ((mToAlpha - alpha) * interpolatedTime));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.160 -0500", hash_original_method = "484D654BC6ACB95ED68989DAAEF2DE56", hash_generated_method = "7FC191661EB19AB28162AC30D9393E1A")
    
@Override
    public boolean willChangeTransformationMatrix() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.162 -0500", hash_original_method = "B56BC808CAC9750B79234A1D767E6B5D", hash_generated_method = "369B52233226DA5B94D0CF0827F8AB05")
    
@Override
    public boolean willChangeBounds() {
        return false;
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.165 -0500", hash_original_method = "E1C0EB5C360EF4564AFB59E1743F2057", hash_generated_method = "2E265C36495AE6A5D129B9EC0B47D1EB")
    
@Override
    public boolean hasAlpha() {
        return true;
    }
    
}

