package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.drawable.shapes.RoundRectShape;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

public class PaintDrawable extends ShapeDrawable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.580 -0400", hash_original_method = "35894A2FD0CE190FC6DCE9F697221056", hash_generated_method = "C2DDD9F96B236904D52621DDE9E6E0DC")
    public  PaintDrawable() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.580 -0400", hash_original_method = "51DC0DAE916B0D4375C00567B21115B1", hash_generated_method = "F038BEBA2C824113480A3ED8D46A5AD4")
    public  PaintDrawable(int color) {
        addTaint(color);
        getPaint().setColor(color);
        // ---------- Original Method ----------
        //getPaint().setColor(color);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.581 -0400", hash_original_method = "29D687C39F10D3A684C3799EDBB48EFB", hash_generated_method = "DD6D7AA9CCA6C07DFFA82A81BED3D395")
    public void setCornerRadius(float radius) {
        addTaint(radius);
        float[] radii = null;
    if(radius > 0)        
        {
            radii = new float[8];
for(int i = 0;i < 8;i++)
            {
                radii[i] = radius;
            } //End block
        } //End block
        setCornerRadii(radii);
        // ---------- Original Method ----------
        //float[] radii = null;
        //if (radius > 0) {
            //radii = new float[8];
            //for (int i = 0; i < 8; i++) {
                //radii[i] = radius;
            //}
        //}
        //setCornerRadii(radii);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.582 -0400", hash_original_method = "458539BDB31F16A86FED0FC05CC292D2", hash_generated_method = "AA2193EDD7BAB7075681D1D029ADA281")
    public void setCornerRadii(float[] radii) {
        addTaint(radii[0]);
    if(radii == null)        
        {
    if(getShape() != null)            
            {
                setShape(null);
            } //End block
        } //End block
        else
        {
            setShape(new RoundRectShape(radii, null, null));
        } //End block
        invalidateSelf();
        // ---------- Original Method ----------
        //if (radii == null) {
            //if (getShape() != null) {
                //setShape(null);
            //}
        //} else {
            //setShape(new RoundRectShape(radii, null, null));
        //}
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.582 -0400", hash_original_method = "B0701038A568952969848F330DE56979", hash_generated_method = "0ABCD2AE3C82DDA83E207AD6D8C76457")
    @Override
    protected boolean inflateTag(String name, Resources r, XmlPullParser parser,
                                 AttributeSet attrs) {
        addTaint(attrs.getTaint());
        addTaint(parser.getTaint());
        addTaint(r.getTaint());
        addTaint(name.getTaint());
    if(name.equals("corners"))        
        {
            TypedArray a = r.obtainAttributes(attrs,
                                        com.android.internal.R.styleable.DrawableCorners);
            int radius = a.getDimensionPixelSize(
                                com.android.internal.R.styleable.DrawableCorners_radius, 0);
            setCornerRadius(radius);
            int topLeftRadius = a.getDimensionPixelSize(
                    com.android.internal.R.styleable.DrawableCorners_topLeftRadius, radius);
            int topRightRadius = a.getDimensionPixelSize(
                    com.android.internal.R.styleable.DrawableCorners_topRightRadius, radius);
            int bottomLeftRadius = a.getDimensionPixelSize(
                com.android.internal.R.styleable.DrawableCorners_bottomLeftRadius, radius);
            int bottomRightRadius = a.getDimensionPixelSize(
                com.android.internal.R.styleable.DrawableCorners_bottomRightRadius, radius);
    if(topLeftRadius != radius || topRightRadius != radius ||
                    bottomLeftRadius != radius || bottomRightRadius != radius)            
            {
                setCornerRadii(new float[] {
                               topLeftRadius, topLeftRadius,
                               topRightRadius, topRightRadius,
                               bottomLeftRadius, bottomLeftRadius,
                               bottomRightRadius, bottomRightRadius
                               });
            } //End block
            a.recycle();
            boolean varB326B5062B2F0E69046810717534CB09_244260748 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_728090986 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_728090986;
        } //End block
        boolean var9077A3F291F5E6AD62C84074997FA4F8_1129484368 = (super.inflateTag(name, r, parser, attrs));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_413690476 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_413690476;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

