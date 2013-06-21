package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private Paint mPaint = new Paint();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.013 -0400", hash_original_method = "54D21D729D42DC46694E67B89A565C46", hash_generated_method = "CE3A2ECE3ABD8585C34F7B80A3F3230E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ColorDrawable() {
        this(null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.014 -0400", hash_original_method = "2F37015D01FE06195FB00430A764BE1B", hash_generated_method = "44A151DE718B0463BE0EA47C21D3769C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ColorDrawable(int color) {
        this(null);
        dsTaint.addTaint(color);
        setColor(color);
        // ---------- Original Method ----------
        //setColor(color);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.014 -0400", hash_original_method = "7CD96EE67F31C94A04E847450668AE59", hash_generated_method = "FA29CBAE858A3EA656ED9E9141A079DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ColorDrawable(ColorState state) {
        dsTaint.addTaint(state.dsTaint);
        mState = new ColorState(state);
        // ---------- Original Method ----------
        //mState = new ColorState(state);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.014 -0400", hash_original_method = "CCB9F44E02BA506AC13DF4A6CD3FA45F", hash_generated_method = "264DC267E87032C62BD50083CCBF1928")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getChangingConfigurations() {
        int var30AA64123BE85DE614C625863A9143B9_1656708186 = (super.getChangingConfigurations() | mState.mChangingConfigurations);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return super.getChangingConfigurations() | mState.mChangingConfigurations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.015 -0400", hash_original_method = "55968084A6009D3A7FE038F60520CF52", hash_generated_method = "E17763AE91A2E612643DE338DBB077CC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.015 -0400", hash_original_method = "12CB188AAA441342DA340C647E5F4CB8", hash_generated_method = "3AD3EEA74CFD4503A6890F8880F16303")
    @DSModeled(DSC.SAFE)
    public int getColor() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mState.mUseColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.015 -0400", hash_original_method = "BF4E5D15208BCF2CD8D02BB100F40081", hash_generated_method = "0383D46BED05C23E784048B80C6893F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.015 -0400", hash_original_method = "5CD88AD7EDD59028127023DB7F8765AB", hash_generated_method = "6A4786AFA30EE97CFB95C4A01B1E69E9")
    @DSModeled(DSC.SAFE)
    public int getAlpha() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mState.mUseColor >>> 24;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.016 -0400", hash_original_method = "459E9D088A35A829F6316FAAD661A311", hash_generated_method = "A1093A4D2876D9699C6165BD6518A031")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.016 -0400", hash_original_method = "A617079D3CF57FB47B0EF9E1F05040EF", hash_generated_method = "6787DF169C8B0B93A2C1CED5BE7CF922")
    @DSModeled(DSC.SAFE)
    public void setColorFilter(ColorFilter colorFilter) {
        dsTaint.addTaint(colorFilter.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.017 -0400", hash_original_method = "B5DEC9C614B60B544E3B9333F2490C35", hash_generated_method = "EBC5F594311D10901337596AEF25C288")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.017 -0400", hash_original_method = "9E06540C925D15124E32C083B6C47AE0", hash_generated_method = "15D8D31697D67F935E3DC0E6C5053300")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.017 -0400", hash_original_method = "4A867A0EE58AB54D1A1755C00D03A40D", hash_generated_method = "CED8EB0851A69B11BC5EB40A0DAB88C3")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.018 -0400", hash_original_method = "0E70F7D5221A41101F9B0C34DE630337", hash_generated_method = "E05D0CA806884B0B7F3A7CA6B62ABE35")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.018 -0400", hash_original_method = "92EB93C0950DAF4E6DCB00F8ABBC1496", hash_generated_method = "85C6C7604B4380FD75FE8ACD20282FDB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Drawable newDrawable() {
            Drawable varFCD6FD27499630FF643F723C084FC804_1580885505 = (new ColorDrawable(this));
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ColorDrawable(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.021 -0400", hash_original_method = "03B9F081DCE7F9DB71B8311343C06715", hash_generated_method = "8AC996038080A451F2D8AA37C21C3B5A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Drawable newDrawable(Resources res) {
            dsTaint.addTaint(res.dsTaint);
            Drawable varFCD6FD27499630FF643F723C084FC804_412290631 = (new ColorDrawable(this));
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ColorDrawable(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.022 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "36011B0CFA5B1C48E438EB66BB35159E")
        @DSModeled(DSC.SAFE)
        @Override
        public int getChangingConfigurations() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
    }


    
}

