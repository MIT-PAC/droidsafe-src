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
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;

public class ScaleDrawable extends Drawable implements Drawable.Callback {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.365 -0500", hash_original_method = "AD555C970189F0219863B034E1D9DD68", hash_generated_method = "44EAFCBF6EA8C70DBF376DA93B1BF15C")
    
private static float getPercent(TypedArray a, int name) {
        String s = a.getString(name);
        if (s != null) {
            if (s.endsWith("%")) {
                String f = s.substring(0, s.length() - 1);
                return Float.parseFloat(f) / 100.0f;
            }
        }
        return -1;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.352 -0500", hash_original_field = "9BD8E5D25C8573C7A1B4ED1164D995F1", hash_generated_field = "1B46C06B589E11041FD605EA02E6FD03")

    private ScaleState mScaleState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.354 -0500", hash_original_field = "B15C308E96D0EEBD27CFE369FA349C15", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.356 -0500", hash_original_field = "C53D3ED3F7CBB30122A6D714A9203A7D", hash_generated_field = "570061BA9CB059462550E9BCCD2A0735")

    private final Rect mTmpRect = new Rect();

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.358 -0500", hash_original_method = "514942F1E0299625DD7C1CF4A65C7704", hash_generated_method = "514942F1E0299625DD7C1CF4A65C7704")
    
ScaleDrawable() {
        this(null, null);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.361 -0500", hash_original_method = "70D37B4EA14F56A15F832FEAF48A06AB", hash_generated_method = "C4C0994804CD7C7B9CC2D5D101747A5B")
    
public ScaleDrawable(Drawable drawable, int gravity, float scaleWidth, float scaleHeight) {
        this(null, null);

        mScaleState.mDrawable = drawable;
        mScaleState.mGravity = gravity;
        mScaleState.mScaleWidth = scaleWidth;
        mScaleState.mScaleHeight = scaleHeight;

        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.446 -0500", hash_original_method = "044BA74036106E0DA1F4FE69AE9E5ADC", hash_generated_method = "86EBA26761F06AD1C643FBDB7235D0CE")
    
private ScaleDrawable(ScaleState state, Resources res) {
        mScaleState = new ScaleState(state, this, res);
    }

    /**
     * Returns the drawable scaled by this ScaleDrawable.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.363 -0500", hash_original_method = "AEF970ED5616036B7E8018EB225E392F", hash_generated_method = "7E60DA76D5AE2F7F190E0BCA10AD03F3")
    
public Drawable getDrawable() {
        return mScaleState.mDrawable;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.369 -0500", hash_original_method = "49F4934EE2B25F6F115AF16904B4D689", hash_generated_method = "0A8579DE1A56F4C20A2FDD1199C822F5")
    
@Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs)
            throws XmlPullParserException, IOException {
        super.inflate(r, parser, attrs);

        int type;

        TypedArray a = r.obtainAttributes(attrs, com.android.internal.R.styleable.ScaleDrawable);

        float sw = getPercent(a, com.android.internal.R.styleable.ScaleDrawable_scaleWidth);
        float sh = getPercent(a, com.android.internal.R.styleable.ScaleDrawable_scaleHeight);
        int g = a.getInt(com.android.internal.R.styleable.ScaleDrawable_scaleGravity, Gravity.LEFT);
        boolean min = a.getBoolean(
                com.android.internal.R.styleable.ScaleDrawable_useIntrinsicSizeAsMinimum, false);
        Drawable dr = a.getDrawable(com.android.internal.R.styleable.ScaleDrawable_drawable);

        a.recycle();

        final int outerDepth = parser.getDepth();
        while ((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth)) {
            if (type != XmlPullParser.START_TAG) {
                continue;
            }
            dr = Drawable.createFromXmlInner(r, parser, attrs);
        }

        if (dr == null) {
            throw new IllegalArgumentException("No drawable specified for <scale>");
        }

        mScaleState.mDrawable = dr;
        mScaleState.mScaleWidth = sw;
        mScaleState.mScaleHeight = sh;
        mScaleState.mGravity = g;
        mScaleState.mUseIntrinsicSizeAsMin = min;
        if (dr != null) {
            dr.setCallback(this);
        }
    }

    // overrides from Drawable.Callback

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.371 -0500", hash_original_method = "DF6A36F8E9590497BD97E858748A70C0", hash_generated_method = "3E519C5086A400FEB4FABA79EECC8E24")
    
public void invalidateDrawable(Drawable who) {
        if (getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.374 -0500", hash_original_method = "18649734DD6C42C2C51CF25B20D68FBF", hash_generated_method = "D0F9C0E1D398C6AF139A8E60D2F12793")
    
public void scheduleDrawable(Drawable who, Runnable what, long when) {
        if (getCallback() != null) {
            getCallback().scheduleDrawable(this, what, when);
        }
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.376 -0500", hash_original_method = "8711E8318CA3821644E7E9EDAB95B5BC", hash_generated_method = "D78A1EF0B4B68AA59D2C1FA88E9F00F6")
    
public void unscheduleDrawable(Drawable who, Runnable what) {
        if (getCallback() != null) {
            getCallback().unscheduleDrawable(this, what);
        }
    }

    // overrides from Drawable

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.379 -0500", hash_original_method = "ADD59FF7C9EB5B0D687113ACE781DE45", hash_generated_method = "CB02458F1D006FC2E23C0DC6ED263F18")
    
@Override
    public void draw(Canvas canvas) {
        if (mScaleState.mDrawable.getLevel() != 0)
            mScaleState.mDrawable.draw(canvas);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.381 -0500", hash_original_method = "E88B2D3506B9FB1C95A0FECA8D5B6D9F", hash_generated_method = "4A95099F8292E13BD75B67DDE273D589")
    
@Override
    public int getChangingConfigurations() {
        return super.getChangingConfigurations()
                | mScaleState.mChangingConfigurations
                | mScaleState.mDrawable.getChangingConfigurations();
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.384 -0500", hash_original_method = "2834251DB4FA1276891A806CA1B46D6D", hash_generated_method = "48659C475E3A241212847496BC9B36D1")
    
@Override
    public boolean getPadding(Rect padding) {
        // XXX need to adjust padding!
        return mScaleState.mDrawable.getPadding(padding);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.386 -0500", hash_original_method = "DF926DDC801D2CA5859468C5FAF6E2DB", hash_generated_method = "C7BCD75D907E572B272042986EF02446")
    
@Override
    public boolean setVisible(boolean visible, boolean restart) {
        mScaleState.mDrawable.setVisible(visible, restart);
        return super.setVisible(visible, restart);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.388 -0500", hash_original_method = "A9094AF2E7BD2624EE02834D750BE346", hash_generated_method = "C53765E7BE2C3EA82D3F84A3FD491B95")
    
@Override
    public void setAlpha(int alpha) {
        mScaleState.mDrawable.setAlpha(alpha);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.390 -0500", hash_original_method = "2F836B47975A4E15DB5892CD09923112", hash_generated_method = "650BBE805AC3F8933A5C66BDBA414AC0")
    
@Override
    public void setColorFilter(ColorFilter cf) {
        mScaleState.mDrawable.setColorFilter(cf);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.393 -0500", hash_original_method = "80BFCB126A2061429F3FFA03D49A8EF5", hash_generated_method = "8D11BFA8153DDCE9FE644013635B8861")
    
@Override
    public int getOpacity() {
        return mScaleState.mDrawable.getOpacity();
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.395 -0500", hash_original_method = "0B20FD6DAF06E7B53C037B30AA0A67FB", hash_generated_method = "A52600B6DBF81C4A9F9E45D1364F0EC2")
    
@Override
    public boolean isStateful() {
        return mScaleState.mDrawable.isStateful();
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.397 -0500", hash_original_method = "53615D161AB187EDCCE7BACA4EBD5437", hash_generated_method = "825E97FA599FC1E21ED1990668C060B3")
    
@Override
    protected boolean onStateChange(int[] state) {
        boolean changed = mScaleState.mDrawable.setState(state);
        onBoundsChange(getBounds());
        return changed;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.399 -0500", hash_original_method = "60A547B14486DD6AB0D2DFD460195C57", hash_generated_method = "78CFBB838D2A49A06A7DC308D655319C")
    
@Override
    protected boolean onLevelChange(int level) {
        mScaleState.mDrawable.setLevel(level);
        onBoundsChange(getBounds());
        invalidateSelf();
        return true;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.403 -0500", hash_original_method = "07137BB41A1EF8F3D963DF117D82A94E", hash_generated_method = "815813C42814D0836831DD253CAF0C7E")
    
@Override
    protected void onBoundsChange(Rect bounds) {
        final Rect r = mTmpRect;
        final boolean min = mScaleState.mUseIntrinsicSizeAsMin;
        int level = getLevel();
        int w = bounds.width();
        if (mScaleState.mScaleWidth > 0) {
            final int iw = min ? mScaleState.mDrawable.getIntrinsicWidth() : 0;
            w -= (int) ((w - iw) * (10000 - level) * mScaleState.mScaleWidth / 10000);
        }
        int h = bounds.height();
        if (mScaleState.mScaleHeight > 0) {
            final int ih = min ? mScaleState.mDrawable.getIntrinsicHeight() : 0;
            h -= (int) ((h - ih) * (10000 - level) * mScaleState.mScaleHeight / 10000);
        }
        final int layoutDirection = getResolvedLayoutDirectionSelf();
        Gravity.apply(mScaleState.mGravity, w, h, bounds, r, layoutDirection);

        if (w > 0 && h > 0) {
            mScaleState.mDrawable.setBounds(r.left, r.top, r.right, r.bottom);
        }
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.405 -0500", hash_original_method = "707D1CC9562C9896640A756558D656DB", hash_generated_method = "E5F2CE83E03BA71AE99934E4508AF9F1")
    
@Override
    public int getIntrinsicWidth() {
        return mScaleState.mDrawable.getIntrinsicWidth();
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.407 -0500", hash_original_method = "974D81B98CAEE5C460DF640DA8AD364B", hash_generated_method = "633893E83533A99A7C444E930976D52E")
    
@Override
    public int getIntrinsicHeight() {
        return mScaleState.mDrawable.getIntrinsicHeight();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.409 -0500", hash_original_method = "F60FC330EC8290C7F4098E941B339581", hash_generated_method = "C9ED1510C162F7D1A21549F17CF8F48A")
    
@Override
    public ConstantState getConstantState() {
        if (mScaleState.canConstantState()) {
            mScaleState.mChangingConfigurations = getChangingConfigurations();
            return mScaleState;
        }
        return null;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.412 -0500", hash_original_method = "9ABDABB0B6579EA1F785C22EF86AAE91", hash_generated_method = "D4279A635DF4007A2AEECD577BCEB77F")
    
@Override
    public Drawable mutate() {
        if (!mMutated && super.mutate() == this) {
            mScaleState.mDrawable.mutate();
            mMutated = true;
        }
        return this;
    }
    
    final static class ScaleState extends ConstantState {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.415 -0500", hash_original_field = "38BA53DD394F85639C99ED8E666FF8FB", hash_generated_field = "38BA53DD394F85639C99ED8E666FF8FB")

        Drawable mDrawable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.417 -0500", hash_original_field = "9BFAF00848476277D36D9BA586984BA7", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.419 -0500", hash_original_field = "BE62C65ADB73C09453C986440B687A2B", hash_generated_field = "BE62C65ADB73C09453C986440B687A2B")

        float mScaleWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.421 -0500", hash_original_field = "34CDE4EA9566E05D3D0D966D1D0818AB", hash_generated_field = "34CDE4EA9566E05D3D0D966D1D0818AB")

        float mScaleHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.423 -0500", hash_original_field = "E8D24DE70DE8CB945622B4CE486A90EA", hash_generated_field = "E8D24DE70DE8CB945622B4CE486A90EA")

        int mGravity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.425 -0500", hash_original_field = "28A7B0326EF7D610D5240DD7AC8F8125", hash_generated_field = "28A7B0326EF7D610D5240DD7AC8F8125")

        boolean mUseIntrinsicSizeAsMin;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.427 -0500", hash_original_field = "04605894B57F7B3414AF620BF4AC040E", hash_generated_field = "63D49323436A33301C0DA6EDF88627FF")

        private boolean mCheckedConstantState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.429 -0500", hash_original_field = "09212A3A30B7E6D48DEECC4F4639CCBC", hash_generated_field = "F62F8D22C4EDE8B8E63C376677BD915C")

        private boolean mCanConstantState;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.432 -0500", hash_original_method = "35CFE1A9959D60B5E323A5A7C20CFF5D", hash_generated_method = "35CFE1A9959D60B5E323A5A7C20CFF5D")
        
ScaleState(ScaleState orig, ScaleDrawable owner, Resources res) {
            if (orig != null) {
                if (res != null) {
                    mDrawable = orig.mDrawable.getConstantState().newDrawable(res);
                } else {
                    mDrawable = orig.mDrawable.getConstantState().newDrawable();
                }
                mDrawable.setCallback(owner);
                mScaleWidth = orig.mScaleWidth;
                mScaleHeight = orig.mScaleHeight;
                mGravity = orig.mGravity;
                mUseIntrinsicSizeAsMin = orig.mUseIntrinsicSizeAsMin;
                mCheckedConstantState = mCanConstantState = true;
            }
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.435 -0500", hash_original_method = "5066D62B21872517357C79E834FBAD6A", hash_generated_method = "559646AF10B92EA95ED8276BBF80F5A3")
        
@Override
        public Drawable newDrawable() {
            return new ScaleDrawable(this, null);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.437 -0500", hash_original_method = "449170E73BA9730DCC0B8E2FFEB867F7", hash_generated_method = "ED023BDE45928942557E96424C0272AA")
        
@Override
        public Drawable newDrawable(Resources res) {
            return new ScaleDrawable(this, res);
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.440 -0500", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "3AB30668ED270F2EDF2E0129C706FE4D")
        
@Override
        public int getChangingConfigurations() {
            return mChangingConfigurations;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.442 -0500", hash_original_method = "8D2A3A495FE794F654E28C73CF35A2A1", hash_generated_method = "8D2A3A495FE794F654E28C73CF35A2A1")
        
boolean canConstantState() {
            if (!mCheckedConstantState) {
                mCanConstantState = mDrawable.getConstantState() != null;
                mCheckedConstantState = true;
            }

            return mCanConstantState;
        }
        
    }
    
}

