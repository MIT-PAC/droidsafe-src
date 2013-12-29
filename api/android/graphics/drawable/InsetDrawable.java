package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.util.AttributeSet;





public class InsetDrawable extends Drawable implements Drawable.Callback {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.684 -0500", hash_original_field = "9579D92D104C8EB77E7F2AEAD01651CF", hash_generated_field = "3AE2C9F0AA2C9F1010956C331820EBD8")

    private InsetState mInsetState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.684 -0500", hash_original_field = "C53D3ED3F7CBB30122A6D714A9203A7D", hash_generated_field = "570061BA9CB059462550E9BCCD2A0735")

    private final Rect mTmpRect = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.685 -0500", hash_original_field = "B15C308E96D0EEBD27CFE369FA349C15", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.686 -0500", hash_original_method = "F48DBEE10522FF6B015323744245900F", hash_generated_method = "F48DBEE10522FF6B015323744245900F")
    InsetDrawable() {
        this(null, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.687 -0500", hash_original_method = "2918696D36F33B173FD0AA17323912B6", hash_generated_method = "006A1CFE13FED7D42659D310B575C038")
    public InsetDrawable(Drawable drawable, int inset) {
        this(drawable, inset, inset, inset, inset);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.688 -0500", hash_original_method = "410D0B69961CD6B4D438C72969BE5ACA", hash_generated_method = "97B357D9C68C840B71652125E5A19287")
    public InsetDrawable(Drawable drawable, int insetLeft, int insetTop,
                         int insetRight, int insetBottom) {
        this(null, null);
        
        mInsetState.mDrawable = drawable;
        mInsetState.mInsetLeft = insetLeft;
        mInsetState.mInsetTop = insetTop;
        mInsetState.mInsetRight = insetRight;
        mInsetState.mInsetBottom = insetBottom;
        
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.716 -0500", hash_original_method = "125D08C0C0AD10DE80234690E438546C", hash_generated_method = "AF71487F4706DFE58346401219D92326")
    private InsetDrawable(InsetState state, Resources res) {
        mInsetState = new InsetState(state, this, res);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.689 -0500", hash_original_method = "308C72D2B889366D58587F5D48DD90DC", hash_generated_method = "F690735CBA198CBD24FBB4BD4F6BBC1C")
    @Override
public void inflate(Resources r, XmlPullParser parser,
                                  AttributeSet attrs)
    throws XmlPullParserException, IOException {
        int type;
        
        TypedArray a = r.obtainAttributes(attrs,
                com.android.internal.R.styleable.InsetDrawable);

        super.inflateWithAttributes(r, parser, a,
                com.android.internal.R.styleable.InsetDrawable_visible);

        int drawableRes = a.getResourceId(com.android.internal.R.styleable.
                                    InsetDrawable_drawable, 0);

        int inLeft = a.getDimensionPixelOffset(com.android.internal.R.styleable.
                                    InsetDrawable_insetLeft, 0);
        int inTop = a.getDimensionPixelOffset(com.android.internal.R.styleable.
                                    InsetDrawable_insetTop, 0);
        int inRight = a.getDimensionPixelOffset(com.android.internal.R.styleable.
                                    InsetDrawable_insetRight, 0);
        int inBottom = a.getDimensionPixelOffset(com.android.internal.R.styleable.
                                    InsetDrawable_insetBottom, 0);

        a.recycle();

        Drawable dr;
        if (drawableRes != 0) {
            dr = r.getDrawable(drawableRes);
        } else {
            while ((type=parser.next()) == XmlPullParser.TEXT) {
            }
            if (type != XmlPullParser.START_TAG) {
                throw new XmlPullParserException(
                        parser.getPositionDescription()
                        + ": <inset> tag requires a 'drawable' attribute or "
                        + "child tag defining a drawable");
            }
            dr = Drawable.createFromXmlInner(r, parser, attrs);
        }

        if (dr == null) {
            Log.w("drawable", "No drawable specified for <inset>");
        }

        mInsetState.mDrawable = dr;
        mInsetState.mInsetLeft = inLeft;
        mInsetState.mInsetRight = inRight;
        mInsetState.mInsetTop = inTop;
        mInsetState.mInsetBottom = inBottom;

        if (dr != null) {
            dr.setCallback(this);
        }
    }

    // overrides from Drawable.Callback

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.690 -0500", hash_original_method = "289E4B14FC4BAEE8FBED5C03A1D9B634", hash_generated_method = "B516B8CE176B97B58ED719463429883C")
    public void invalidateDrawable(Drawable who) {
        final Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.691 -0500", hash_original_method = "A01CAF97CFFAA14450A9600E14E88C8D", hash_generated_method = "D916965E7ED92878F703EBB8407A3435")
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        final Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, what, when);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.692 -0500", hash_original_method = "CA144C86313E3C1A3DC044F014305D8E", hash_generated_method = "1F0141991B8511B6AE50284469FB44D8")
    public void unscheduleDrawable(Drawable who, Runnable what) {
        final Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, what);
        }
    }

    // overrides from Drawable

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.692 -0500", hash_original_method = "5D957288FBCBF53EE4FDA5CCA4D587F6", hash_generated_method = "534DB1386FA897BE38214CEE92F87441")
    @Override
public void draw(Canvas canvas) {
        mInsetState.mDrawable.draw(canvas);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.693 -0500", hash_original_method = "5E6B5E9F59EDAB724B1161E1868DCBF2", hash_generated_method = "A5E94C52FBA1EA9E7C6C96F0844AC16A")
    @Override
public int getChangingConfigurations() {
        return super.getChangingConfigurations()
                | mInsetState.mChangingConfigurations
                | mInsetState.mDrawable.getChangingConfigurations();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.694 -0500", hash_original_method = "453C0F994CC6F9573C64E5784E899FE5", hash_generated_method = "8DA37E97C2303B21F80E85601E3C7335")
    @Override
public boolean getPadding(Rect padding) {
        boolean pad = mInsetState.mDrawable.getPadding(padding);

        padding.left += mInsetState.mInsetLeft;
        padding.right += mInsetState.mInsetRight;
        padding.top += mInsetState.mInsetTop;
        padding.bottom += mInsetState.mInsetBottom;

        if (pad || (mInsetState.mInsetLeft | mInsetState.mInsetRight | 
                    mInsetState.mInsetTop | mInsetState.mInsetBottom) != 0) {
            return true;
        } else {
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.695 -0500", hash_original_method = "EFF30D1C1A84058D8C292EB91F9472BE", hash_generated_method = "9ED10647082E06E9753799E94D347860")
    @Override
public boolean setVisible(boolean visible, boolean restart) {
        mInsetState.mDrawable.setVisible(visible, restart);
        return super.setVisible(visible, restart);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.696 -0500", hash_original_method = "B23A5809007626F95D6E0E75FACEBCF9", hash_generated_method = "CD442C7F76CD5BA02659E66FC4BB1BD1")
    @Override
public void setAlpha(int alpha) {
        mInsetState.mDrawable.setAlpha(alpha);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.697 -0500", hash_original_method = "06DFACBA6F5F88BE2848B90C2DE93101", hash_generated_method = "403ED5464F72B5720F66D941673BEB49")
    @Override
public void setColorFilter(ColorFilter cf) {
        mInsetState.mDrawable.setColorFilter(cf);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.697 -0500", hash_original_method = "84C32146675D5EBE47A9CF2427DBDE28", hash_generated_method = "536CDDC75C5B7F134CE8566472B9408B")
    @Override
public int getOpacity() {
        return mInsetState.mDrawable.getOpacity();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.698 -0500", hash_original_method = "043A29D2ADB29827582E75471CD5479B", hash_generated_method = "064B57BB71644FAFCE23E922867341E9")
    @Override
public boolean isStateful() {
        return mInsetState.mDrawable.isStateful();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.699 -0500", hash_original_method = "246AAD5F68D871EA63688A0B06577CD4", hash_generated_method = "7835BD96E5EC82AE8EC98157776365D5")
    @Override
protected boolean onStateChange(int[] state) {
        boolean changed = mInsetState.mDrawable.setState(state);
        onBoundsChange(getBounds());
        return changed;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.700 -0500", hash_original_method = "95EBA24DAC30ACDEC92CAFB7918B63D7", hash_generated_method = "733209570493DF9D24A1356D934428DA")
    @Override
protected void onBoundsChange(Rect bounds) {
        final Rect r = mTmpRect;
        r.set(bounds);

        r.left += mInsetState.mInsetLeft;
        r.top += mInsetState.mInsetTop;
        r.right -= mInsetState.mInsetRight;
        r.bottom -= mInsetState.mInsetBottom;

        mInsetState.mDrawable.setBounds(r.left, r.top, r.right, r.bottom);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.701 -0500", hash_original_method = "AB4853FCC2E61C4308CEBFB5AE69B700", hash_generated_method = "474DB5BDE1F8B547F65CC9A0E464316B")
    @Override
public int getIntrinsicWidth() {
        return mInsetState.mDrawable.getIntrinsicWidth();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.702 -0500", hash_original_method = "29FF5B29153AE16681DB19A374B63115", hash_generated_method = "9B3C0C9A781973B63CC53E902FBFA47F")
    @Override
public int getIntrinsicHeight() {
        return mInsetState.mDrawable.getIntrinsicHeight();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.703 -0500", hash_original_method = "1E9E2DEF1AEF301447A2F1B1CB9B55FF", hash_generated_method = "89BCCAFBA0248D2F2B83AFE96D296A26")
    @Override
public ConstantState getConstantState() {
        if (mInsetState.canConstantState()) {
            mInsetState.mChangingConfigurations = getChangingConfigurations();
            return mInsetState;
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.704 -0500", hash_original_method = "22F293566220E6F3A8D3A4AE196709E5", hash_generated_method = "FDE970B4F7D68D7C73910CB887137C35")
    @Override
public Drawable mutate() {
        if (!mMutated && super.mutate() == this) {
            mInsetState.mDrawable.mutate();
            mMutated = true;
        }
        return this;
    }

    
    final static class InsetState extends ConstantState {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.704 -0500", hash_original_field = "38BA53DD394F85639C99ED8E666FF8FB", hash_generated_field = "38BA53DD394F85639C99ED8E666FF8FB")

        Drawable mDrawable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.705 -0500", hash_original_field = "9BFAF00848476277D36D9BA586984BA7", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.706 -0500", hash_original_field = "E2BE4EAC7479E12B8AD15F8A1DC878B0", hash_generated_field = "E2BE4EAC7479E12B8AD15F8A1DC878B0")


        int mInsetLeft;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.706 -0500", hash_original_field = "BDC766ACBEF4E33A22B4884B070885A7", hash_generated_field = "BDC766ACBEF4E33A22B4884B070885A7")

        int mInsetTop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.707 -0500", hash_original_field = "858AD29F4440BFB10D0903CBBA92AF5F", hash_generated_field = "858AD29F4440BFB10D0903CBBA92AF5F")

        int mInsetRight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.708 -0500", hash_original_field = "637B8F5F49094B17B0B21610CF248426", hash_generated_field = "637B8F5F49094B17B0B21610CF248426")

        int mInsetBottom;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.709 -0500", hash_original_field = "04605894B57F7B3414AF620BF4AC040E", hash_generated_field = "04605894B57F7B3414AF620BF4AC040E")


        boolean mCheckedConstantState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.709 -0500", hash_original_field = "09212A3A30B7E6D48DEECC4F4639CCBC", hash_generated_field = "09212A3A30B7E6D48DEECC4F4639CCBC")

        boolean mCanConstantState;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.710 -0500", hash_original_method = "758BE6D06942564382533B70A9D03639", hash_generated_method = "758BE6D06942564382533B70A9D03639")
        InsetState(InsetState orig, InsetDrawable owner, Resources res) {
            if (orig != null) {
                if (res != null) {
                    mDrawable = orig.mDrawable.getConstantState().newDrawable(res);
                } else {
                    mDrawable = orig.mDrawable.getConstantState().newDrawable();
                }
                mDrawable.setCallback(owner);
                mInsetLeft = orig.mInsetLeft;
                mInsetTop = orig.mInsetTop;
                mInsetRight = orig.mInsetRight;
                mInsetBottom = orig.mInsetBottom;
                mCheckedConstantState = mCanConstantState = true;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.711 -0500", hash_original_method = "6B31FDACEACBBE413B6F897E56BE7FF9", hash_generated_method = "7F21A3103CB5BD9EA3F7F91AB31E9105")
        @Override
public Drawable newDrawable() {
            return new InsetDrawable(this, null);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.712 -0500", hash_original_method = "51EF496D1F925226C92A50925EFC08B6", hash_generated_method = "1D193FC808D3FE37932C648E720496ED")
        @Override
public Drawable newDrawable(Resources res) {
            return new InsetDrawable(this, res);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.713 -0500", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "3AB30668ED270F2EDF2E0129C706FE4D")
        @Override
public int getChangingConfigurations() {
            return mChangingConfigurations;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:51.713 -0500", hash_original_method = "8D2A3A495FE794F654E28C73CF35A2A1", hash_generated_method = "8D2A3A495FE794F654E28C73CF35A2A1")
        boolean canConstantState() {
            if (!mCheckedConstantState) {
                mCanConstantState = mDrawable.getConstantState() != null;
                mCheckedConstantState = true;
            }

            return mCanConstantState;
        }

        
    }


    
}

