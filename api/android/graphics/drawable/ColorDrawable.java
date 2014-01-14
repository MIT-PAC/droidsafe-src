package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.util.AttributeSet;

public class ColorDrawable extends Drawable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.360 -0500", hash_original_field = "A405993723FCD61240CC265F058545AB", hash_generated_field = "FD7347C3EC0F5B546B9EA73CCF0BC637")

    private ColorState mState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.362 -0500", hash_original_field = "1D0586880E5CE88B4198E05E1760434E", hash_generated_field = "90B0608AB53F75A0AC388611FFB8AF86")

    private final Paint mPaint = new Paint();

    /**
     * Creates a new black ColorDrawable.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.365 -0500", hash_original_method = "54D21D729D42DC46694E67B89A565C46", hash_generated_method = "34344A6BE132AF626299B3B6BCCE447B")
    
public ColorDrawable() {
        this(null);
    }

    /**
     * Creates a new ColorDrawable with the specified color.
     *
     * @param color The color to draw.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.367 -0500", hash_original_method = "2F37015D01FE06195FB00430A764BE1B", hash_generated_method = "859BCCE0A1E0BEBBC583BBAFD3E0D0CC")
    
public ColorDrawable(int color) {
        this(null);
        setColor(color);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.370 -0500", hash_original_method = "7CD96EE67F31C94A04E847450668AE59", hash_generated_method = "B395FE4CA0A5A6A3E50659683A5AA0F9")
    
private ColorDrawable(ColorState state) {
        mState = new ColorState(state);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.372 -0500", hash_original_method = "CCB9F44E02BA506AC13DF4A6CD3FA45F", hash_generated_method = "79A1C10E5A48365D8B9978537D00AB08")
    
@Override
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | mState.mChangingConfigurations;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.374 -0500", hash_original_method = "55968084A6009D3A7FE038F60520CF52", hash_generated_method = "8D30CB84BF554034217ED9C9C801583F")
    
@Override
    public void draw(Canvas canvas) {
        if ((mState.mUseColor >>> 24) != 0) {
            mPaint.setColor(mState.mUseColor);
            canvas.drawRect(getBounds(), mPaint);
        }
    }

    /**
     * Gets the drawable's color value.
     *
     * @return int The color to draw.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.377 -0500", hash_original_method = "12CB188AAA441342DA340C647E5F4CB8", hash_generated_method = "B0AA492B9D8833FB6DBD1E2EE33781FD")
    
public int getColor() {
        return mState.mUseColor;
    }

    /**
     * Sets the drawable's color value. This action will clobber the results of prior calls to
     * {@link #setAlpha(int)} on this object, which side-affected the underlying color.
     *
     * @param color The color to draw.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.379 -0500", hash_original_method = "BF4E5D15208BCF2CD8D02BB100F40081", hash_generated_method = "0F5478CF321F06D2A372334E3E461D87")
    
public void setColor(int color) {
        if (mState.mBaseColor != color || mState.mUseColor != color) {
            invalidateSelf();
            mState.mBaseColor = mState.mUseColor = color;
        }
    }

    /**
     * Returns the alpha value of this drawable's color.
     *
     * @return A value between 0 and 255.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.381 -0500", hash_original_method = "5CD88AD7EDD59028127023DB7F8765AB", hash_generated_method = "60FD9929B15A1D916703D0B6F5F8B120")
    
public int getAlpha() {
        return mState.mUseColor >>> 24;
    }

    /**
     * Sets the color's alpha value.
     *
     * @param alpha The alpha value to set, between 0 and 255.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.383 -0500", hash_original_method = "459E9D088A35A829F6316FAAD661A311", hash_generated_method = "76FD3359CB81794BC431052CE211C471")
    
public void setAlpha(int alpha) {
        alpha += alpha >> 7;   // make it 0..256
        int baseAlpha = mState.mBaseColor >>> 24;
        int useAlpha = baseAlpha * alpha >> 8;
        int oldUseColor = mState.mUseColor;
        mState.mUseColor = (mState.mBaseColor << 8 >>> 8) | (useAlpha << 24);
        if (oldUseColor != mState.mUseColor) {
            invalidateSelf();
        }
    }

    /**
     * Setting a color filter on a ColorDrawable has no effect.
     *
     * @param colorFilter Ignore.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.385 -0500", hash_original_method = "A617079D3CF57FB47B0EF9E1F05040EF", hash_generated_method = "4F96E60EF79CC62633E15FD9F37728CA")
    
public void setColorFilter(ColorFilter colorFilter) {
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.387 -0500", hash_original_method = "B5DEC9C614B60B544E3B9333F2490C35", hash_generated_method = "24344A1D81C73B8A7DBBD6DCA997AFDC")
    
public int getOpacity() {
        switch (mState.mUseColor >>> 24) {
            case 255:
                return PixelFormat.OPAQUE;
            case 0:
                return PixelFormat.TRANSPARENT;
        }
        return PixelFormat.TRANSLUCENT;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.390 -0500", hash_original_method = "9E06540C925D15124E32C083B6C47AE0", hash_generated_method = "6A71D7ED8BAFA80F13CF78171B3BB8D1")
    
@Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs)
            throws XmlPullParserException, IOException {
        super.inflate(r, parser, attrs);

        TypedArray a = r.obtainAttributes(attrs, com.android.internal.R.styleable.ColorDrawable);

        int color = mState.mBaseColor;
        color = a.getColor(com.android.internal.R.styleable.ColorDrawable_color, color);
        mState.mBaseColor = mState.mUseColor = color;

        a.recycle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.392 -0500", hash_original_method = "4A867A0EE58AB54D1A1755C00D03A40D", hash_generated_method = "D328269FA4DE1E27DC0EA952FFEBF9D7")
    
@Override
    public ConstantState getConstantState() {
        mState.mChangingConfigurations = getChangingConfigurations();
        return mState;
    }
    
    final static class ColorState extends ConstantState {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.395 -0500", hash_original_field = "5AE93BCE3A5CA0AC335BC45A61DD8BC4", hash_generated_field = "5AE93BCE3A5CA0AC335BC45A61DD8BC4")

        int mBaseColor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.397 -0500", hash_original_field = "FE9A913640A2B3D963243CB0B70E7356", hash_generated_field = "FE9A913640A2B3D963243CB0B70E7356")

        int mUseColor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.399 -0500", hash_original_field = "9BFAF00848476277D36D9BA586984BA7", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.402 -0500", hash_original_method = "0E70F7D5221A41101F9B0C34DE630337", hash_generated_method = "0E70F7D5221A41101F9B0C34DE630337")
        
ColorState(ColorState state) {
            if (state != null) {
                mBaseColor = state.mBaseColor;
                mUseColor = state.mUseColor;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.404 -0500", hash_original_method = "92EB93C0950DAF4E6DCB00F8ABBC1496", hash_generated_method = "71E30C80FFCC09458F86FD722B60B635")
        
@Override
        public Drawable newDrawable() {
            return new ColorDrawable(this);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.407 -0500", hash_original_method = "03B9F081DCE7F9DB71B8311343C06715", hash_generated_method = "40FD7748F58588475ED44B8065E7A537")
        
@Override
        public Drawable newDrawable(Resources res) {
            return new ColorDrawable(this);
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.409 -0500", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "3AB30668ED270F2EDF2E0129C706FE4D")
        
@Override
        public int getChangingConfigurations() {
            return mChangingConfigurations;
        }
        
    }
    
}

