package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.graphics.*;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;

public class ColorDrawable extends Drawable {
    private ColorState mState;
    private final Paint mPaint = new Paint();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.079 -0400", hash_original_method = "54D21D729D42DC46694E67B89A565C46", hash_generated_method = "56552CF2046DE8577AC00D74D286B5D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ColorDrawable() {
        this(null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.079 -0400", hash_original_method = "2F37015D01FE06195FB00430A764BE1B", hash_generated_method = "570AEC9BE4B29AFB737581F421722B9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ColorDrawable(int color) {
        this(null);
        dsTaint.addTaint(color);
        setColor(color);
        // ---------- Original Method ----------
        //setColor(color);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.080 -0400", hash_original_method = "7CD96EE67F31C94A04E847450668AE59", hash_generated_method = "741C466D7F81B95C941E98832B43A921")
    @DSModeled(DSC.SAFE)
    private ColorDrawable(ColorState state) {
        dsTaint.addTaint(state.dsTaint);
        mState = new ColorState(state);
        // ---------- Original Method ----------
        //mState = new ColorState(state);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.080 -0400", hash_original_method = "CCB9F44E02BA506AC13DF4A6CD3FA45F", hash_generated_method = "815A17B12EA0891B75491009D7C13DA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getChangingConfigurations() {
        int var30AA64123BE85DE614C625863A9143B9_1823677393 = (super.getChangingConfigurations() | mState.mChangingConfigurations);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return super.getChangingConfigurations() | mState.mChangingConfigurations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.080 -0400", hash_original_method = "55968084A6009D3A7FE038F60520CF52", hash_generated_method = "CE41AB8CD89CF884B82CAA32654F356A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void draw(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        {
            mPaint.setColor(mState.mUseColor);
            canvas.drawRect(getBounds(), mPaint);
        } //End block
        // ---------- Original Method ----------
        //if ((mState.mUseColor >>> 24) != 0) {
            //mPaint.setColor(mState.mUseColor);
            //canvas.drawRect(getBounds(), mPaint);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.080 -0400", hash_original_method = "12CB188AAA441342DA340C647E5F4CB8", hash_generated_method = "65FFB891C785B6C28F0A917FC4EBDD4E")
    @DSModeled(DSC.SAFE)
    public int getColor() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mState.mUseColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.080 -0400", hash_original_method = "BF4E5D15208BCF2CD8D02BB100F40081", hash_generated_method = "4D1F7B329BFD3DEEEC8A80E3AA39A09B")
    @DSModeled(DSC.SAFE)
    public void setColor(int color) {
        dsTaint.addTaint(color);
        {
            invalidateSelf();
            mState.mBaseColor = mState.mUseColor = color;
        } //End block
        // ---------- Original Method ----------
        //if (mState.mBaseColor != color || mState.mUseColor != color) {
            //invalidateSelf();
            //mState.mBaseColor = mState.mUseColor = color;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.080 -0400", hash_original_method = "5CD88AD7EDD59028127023DB7F8765AB", hash_generated_method = "FC800270C4065CE009184E5025A47A60")
    @DSModeled(DSC.SAFE)
    public int getAlpha() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mState.mUseColor >>> 24;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.081 -0400", hash_original_method = "459E9D088A35A829F6316FAAD661A311", hash_generated_method = "4A4A78018469E28494C3F4F3D2126D6E")
    @DSModeled(DSC.SAFE)
    public void setAlpha(int alpha) {
        dsTaint.addTaint(alpha);
        alpha += alpha >> 7;
        int baseAlpha;
        baseAlpha = mState.mBaseColor >>> 24;
        int useAlpha;
        useAlpha = baseAlpha * alpha >> 8;
        int oldUseColor;
        oldUseColor = mState.mUseColor;
        mState.mUseColor = (mState.mBaseColor << 8 >>> 8) | (useAlpha << 24);
        {
            invalidateSelf();
        } //End block
        // ---------- Original Method ----------
        //alpha += alpha >> 7;
        //int baseAlpha = mState.mBaseColor >>> 24;
        //int useAlpha = baseAlpha * alpha >> 8;
        //int oldUseColor = mState.mUseColor;
        //mState.mUseColor = (mState.mBaseColor << 8 >>> 8) | (useAlpha << 24);
        //if (oldUseColor != mState.mUseColor) {
            //invalidateSelf();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.081 -0400", hash_original_method = "A617079D3CF57FB47B0EF9E1F05040EF", hash_generated_method = "E7057BCE11DD612F625E54C38046A87F")
    @DSModeled(DSC.SAFE)
    public void setColorFilter(ColorFilter colorFilter) {
        dsTaint.addTaint(colorFilter.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.081 -0400", hash_original_method = "B5DEC9C614B60B544E3B9333F2490C35", hash_generated_method = "87A447CEEE4EB672C7F398790376886C")
    @DSModeled(DSC.SAFE)
    public int getOpacity() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //switch (mState.mUseColor >>> 24) {
            //case 255:
                //return PixelFormat.OPAQUE;
            //case 0:
                //return PixelFormat.TRANSPARENT;
        //}
        //return PixelFormat.TRANSLUCENT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.081 -0400", hash_original_method = "9E06540C925D15124E32C083B6C47AE0", hash_generated_method = "6008203A5005A66FC86BF6AE75C6D37B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
        super.inflate(r, parser, attrs);
        TypedArray a;
        a = r.obtainAttributes(attrs, com.android.internal.R.styleable.ColorDrawable);
        int color;
        color = mState.mBaseColor;
        color = a.getColor(com.android.internal.R.styleable.ColorDrawable_color, color);
        mState.mBaseColor = mState.mUseColor = color;
        a.recycle();
        // ---------- Original Method ----------
        //super.inflate(r, parser, attrs);
        //TypedArray a = r.obtainAttributes(attrs, com.android.internal.R.styleable.ColorDrawable);
        //int color = mState.mBaseColor;
        //color = a.getColor(com.android.internal.R.styleable.ColorDrawable_color, color);
        //mState.mBaseColor = mState.mUseColor = color;
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.081 -0400", hash_original_method = "4A867A0EE58AB54D1A1755C00D03A40D", hash_generated_method = "96A0AA87CC8F990D09575446A8A6CAB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ConstantState getConstantState() {
        mState.mChangingConfigurations = getChangingConfigurations();
        return (ConstantState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mState.mChangingConfigurations = getChangingConfigurations();
        //return mState;
    }

    
    final static class ColorState extends ConstantState {
        int mBaseColor;
        int mUseColor;
        int mChangingConfigurations;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.081 -0400", hash_original_method = "0E70F7D5221A41101F9B0C34DE630337", hash_generated_method = "FC5B37D71C518870C0D2394F33CE7A30")
        @DSModeled(DSC.SAFE)
         ColorState(ColorState state) {
            dsTaint.addTaint(state.dsTaint);
            {
                mBaseColor = state.mBaseColor;
                mUseColor = state.mUseColor;
            } //End block
            // ---------- Original Method ----------
            //if (state != null) {
                //mBaseColor = state.mBaseColor;
                //mUseColor = state.mUseColor;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.082 -0400", hash_original_method = "92EB93C0950DAF4E6DCB00F8ABBC1496", hash_generated_method = "773E1E8A98AC24CF984BAFBC6A2B1549")
        @DSModeled(DSC.SAFE)
        @Override
        public Drawable newDrawable() {
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ColorDrawable(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.082 -0400", hash_original_method = "03B9F081DCE7F9DB71B8311343C06715", hash_generated_method = "18615C0F7B0EE68BC848D879A018C326")
        @DSModeled(DSC.SAFE)
        @Override
        public Drawable newDrawable(Resources res) {
            dsTaint.addTaint(res.dsTaint);
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ColorDrawable(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.082 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "2D59F41488F7278F18877F131EF0D371")
        @DSModeled(DSC.SAFE)
        @Override
        public int getChangingConfigurations() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
    }


    
}


