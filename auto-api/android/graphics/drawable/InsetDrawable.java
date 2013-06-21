package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.*;
import android.util.AttributeSet;
import android.util.Log;
import java.io.IOException;

public class InsetDrawable extends Drawable implements Drawable.Callback {
    private InsetState mInsetState;
    private Rect mTmpRect = new Rect();
    private boolean mMutated;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.378 -0400", hash_original_method = "F48DBEE10522FF6B015323744245900F", hash_generated_method = "DDE232BCCCC6C70EAA4019D4AF233073")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     InsetDrawable() {
        this(null, null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.378 -0400", hash_original_method = "2918696D36F33B173FD0AA17323912B6", hash_generated_method = "0465B3F6CB33B2BAC407C9D3638A931D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InsetDrawable(Drawable drawable, int inset) {
        this(drawable, inset, inset, inset, inset);
        dsTaint.addTaint(inset);
        dsTaint.addTaint(drawable.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.379 -0400", hash_original_method = "410D0B69961CD6B4D438C72969BE5ACA", hash_generated_method = "30590D7ECC5C4DCEC24906D2AC9D8BD8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InsetDrawable(Drawable drawable, int insetLeft, int insetTop,
                         int insetRight, int insetBottom) {
        this(null, null);
        dsTaint.addTaint(insetLeft);
        dsTaint.addTaint(drawable.dsTaint);
        dsTaint.addTaint(insetBottom);
        dsTaint.addTaint(insetRight);
        dsTaint.addTaint(insetTop);
        mInsetState.mDrawable = drawable;
        mInsetState.mInsetLeft = insetLeft;
        mInsetState.mInsetTop = insetTop;
        mInsetState.mInsetRight = insetRight;
        mInsetState.mInsetBottom = insetBottom;
        {
            drawable.setCallback(this);
        } //End block
        // ---------- Original Method ----------
        //mInsetState.mDrawable = drawable;
        //mInsetState.mInsetLeft = insetLeft;
        //mInsetState.mInsetTop = insetTop;
        //mInsetState.mInsetRight = insetRight;
        //mInsetState.mInsetBottom = insetBottom;
        //if (drawable != null) {
            //drawable.setCallback(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.379 -0400", hash_original_method = "125D08C0C0AD10DE80234690E438546C", hash_generated_method = "06D2806656DAF153B70EBA0026CF570E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private InsetDrawable(InsetState state, Resources res) {
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(state.dsTaint);
        mInsetState = new InsetState(state, this, res);
        // ---------- Original Method ----------
        //mInsetState = new InsetState(state, this, res);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.380 -0400", hash_original_method = "308C72D2B889366D58587F5D48DD90DC", hash_generated_method = "BA3AE57599313183C052F055BD8FBE51")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void inflate(Resources r, XmlPullParser parser,
                                  AttributeSet attrs) throws XmlPullParserException, IOException {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
        int type;
        TypedArray a;
        a = r.obtainAttributes(attrs,
                com.android.internal.R.styleable.InsetDrawable);
        super.inflateWithAttributes(r, parser, a,
                com.android.internal.R.styleable.InsetDrawable_visible);
        int drawableRes;
        drawableRes = a.getResourceId(com.android.internal.R.styleable.
                                    InsetDrawable_drawable, 0);
        int inLeft;
        inLeft = a.getDimensionPixelOffset(com.android.internal.R.styleable.
                                    InsetDrawable_insetLeft, 0);
        int inTop;
        inTop = a.getDimensionPixelOffset(com.android.internal.R.styleable.
                                    InsetDrawable_insetTop, 0);
        int inRight;
        inRight = a.getDimensionPixelOffset(com.android.internal.R.styleable.
                                    InsetDrawable_insetRight, 0);
        int inBottom;
        inBottom = a.getDimensionPixelOffset(com.android.internal.R.styleable.
                                    InsetDrawable_insetBottom, 0);
        a.recycle();
        Drawable dr;
        {
            dr = r.getDrawable(drawableRes);
        } //End block
        {
            {
                boolean var6B5B5852701B8FCC2CE942637EBFE70C_1703500285 = ((type=parser.next()) == XmlPullParser.TEXT);
            } //End collapsed parenthetic
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                        parser.getPositionDescription()
                        + ": <inset> tag requires a 'drawable' attribute or "
                        + "child tag defining a drawable");
            } //End block
            dr = Drawable.createFromXmlInner(r, parser, attrs);
        } //End block
        mInsetState.mDrawable = dr;
        mInsetState.mInsetLeft = inLeft;
        mInsetState.mInsetRight = inRight;
        mInsetState.mInsetTop = inTop;
        mInsetState.mInsetBottom = inBottom;
        {
            dr.setCallback(this);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.380 -0400", hash_original_method = "289E4B14FC4BAEE8FBED5C03A1D9B634", hash_generated_method = "41CFE1796930DCF2EA1C09782362A302")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void invalidateDrawable(Drawable who) {
        dsTaint.addTaint(who.dsTaint);
        Callback callback;
        callback = getCallback();
        {
            callback.invalidateDrawable(this);
        } //End block
        // ---------- Original Method ----------
        //final Callback callback = getCallback();
        //if (callback != null) {
            //callback.invalidateDrawable(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.381 -0400", hash_original_method = "A01CAF97CFFAA14450A9600E14E88C8D", hash_generated_method = "5E91FE06A500769A5C043EEFE8B10766")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(when);
        dsTaint.addTaint(who.dsTaint);
        Callback callback;
        callback = getCallback();
        {
            callback.scheduleDrawable(this, what, when);
        } //End block
        // ---------- Original Method ----------
        //final Callback callback = getCallback();
        //if (callback != null) {
            //callback.scheduleDrawable(this, what, when);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.381 -0400", hash_original_method = "CA144C86313E3C1A3DC044F014305D8E", hash_generated_method = "E7D6D2791C5354C92F65E1B2A3B561B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unscheduleDrawable(Drawable who, Runnable what) {
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(who.dsTaint);
        Callback callback;
        callback = getCallback();
        {
            callback.unscheduleDrawable(this, what);
        } //End block
        // ---------- Original Method ----------
        //final Callback callback = getCallback();
        //if (callback != null) {
            //callback.unscheduleDrawable(this, what);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.381 -0400", hash_original_method = "5D957288FBCBF53EE4FDA5CCA4D587F6", hash_generated_method = "2204270B331B9D5D0636539490FE8D36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void draw(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        mInsetState.mDrawable.draw(canvas);
        // ---------- Original Method ----------
        //mInsetState.mDrawable.draw(canvas);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.382 -0400", hash_original_method = "5E6B5E9F59EDAB724B1161E1868DCBF2", hash_generated_method = "1766C7829A33C008E24BB6B5E55A5546")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getChangingConfigurations() {
        int var61EF387ADAB9AB2D890E9E42218FD44A_1975584506 = (super.getChangingConfigurations()
                | mInsetState.mChangingConfigurations
                | mInsetState.mDrawable.getChangingConfigurations());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return super.getChangingConfigurations()
                //| mInsetState.mChangingConfigurations
                //| mInsetState.mDrawable.getChangingConfigurations();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.382 -0400", hash_original_method = "453C0F994CC6F9573C64E5784E899FE5", hash_generated_method = "62334236C292759611CA9E6445B89B71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getPadding(Rect padding) {
        dsTaint.addTaint(padding.dsTaint);
        boolean pad;
        pad = mInsetState.mDrawable.getPadding(padding);
        padding.left += mInsetState.mInsetLeft;
        padding.right += mInsetState.mInsetRight;
        padding.top += mInsetState.mInsetTop;
        padding.bottom += mInsetState.mInsetBottom;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean pad = mInsetState.mDrawable.getPadding(padding);
        //padding.left += mInsetState.mInsetLeft;
        //padding.right += mInsetState.mInsetRight;
        //padding.top += mInsetState.mInsetTop;
        //padding.bottom += mInsetState.mInsetBottom;
        //if (pad || (mInsetState.mInsetLeft | mInsetState.mInsetRight | 
                    //mInsetState.mInsetTop | mInsetState.mInsetBottom) != 0) {
            //return true;
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.382 -0400", hash_original_method = "EFF30D1C1A84058D8C292EB91F9472BE", hash_generated_method = "641495D6F89E34B26A8C40FC430A6F97")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean setVisible(boolean visible, boolean restart) {
        dsTaint.addTaint(restart);
        dsTaint.addTaint(visible);
        mInsetState.mDrawable.setVisible(visible, restart);
        boolean var9D015C67047440F1849257F892B1DD1F_1018810611 = (super.setVisible(visible, restart));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //mInsetState.mDrawable.setVisible(visible, restart);
        //return super.setVisible(visible, restart);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.383 -0400", hash_original_method = "B23A5809007626F95D6E0E75FACEBCF9", hash_generated_method = "60501B63D2C815758B7C6CDC9BE06044")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setAlpha(int alpha) {
        dsTaint.addTaint(alpha);
        mInsetState.mDrawable.setAlpha(alpha);
        // ---------- Original Method ----------
        //mInsetState.mDrawable.setAlpha(alpha);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.383 -0400", hash_original_method = "06DFACBA6F5F88BE2848B90C2DE93101", hash_generated_method = "B89580DD552C01BB2F1DB1C74DCE435F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setColorFilter(ColorFilter cf) {
        dsTaint.addTaint(cf.dsTaint);
        mInsetState.mDrawable.setColorFilter(cf);
        // ---------- Original Method ----------
        //mInsetState.mDrawable.setColorFilter(cf);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.383 -0400", hash_original_method = "84C32146675D5EBE47A9CF2427DBDE28", hash_generated_method = "F3FD9C5350321370B3FE98A3C9099F83")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getOpacity() {
        int varBEAEEE19271DBC4B9E294A9607E28C8B_1979278019 = (mInsetState.mDrawable.getOpacity());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mInsetState.mDrawable.getOpacity();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.383 -0400", hash_original_method = "043A29D2ADB29827582E75471CD5479B", hash_generated_method = "E816D4CF74D412D4FF2BF01D2D56CED0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isStateful() {
        boolean varBA951C8D6B94B7E63AFFEFE558352D27_805196706 = (mInsetState.mDrawable.isStateful());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mInsetState.mDrawable.isStateful();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.384 -0400", hash_original_method = "246AAD5F68D871EA63688A0B06577CD4", hash_generated_method = "30FE44FF6F2B6AF69BA2EE35FDDCD7A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean onStateChange(int[] state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(state[0]);
        boolean changed;
        changed = mInsetState.mDrawable.setState(state);
        onBoundsChange(getBounds());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean changed = mInsetState.mDrawable.setState(state);
        //onBoundsChange(getBounds());
        //return changed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.384 -0400", hash_original_method = "95EBA24DAC30ACDEC92CAFB7918B63D7", hash_generated_method = "4DC546053CA95448B704529B85BF9ADA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onBoundsChange(Rect bounds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(bounds.dsTaint);
        Rect r;
        r = mTmpRect;
        r.set(bounds);
        r.left += mInsetState.mInsetLeft;
        r.top += mInsetState.mInsetTop;
        r.right -= mInsetState.mInsetRight;
        r.bottom -= mInsetState.mInsetBottom;
        mInsetState.mDrawable.setBounds(r.left, r.top, r.right, r.bottom);
        // ---------- Original Method ----------
        //final Rect r = mTmpRect;
        //r.set(bounds);
        //r.left += mInsetState.mInsetLeft;
        //r.top += mInsetState.mInsetTop;
        //r.right -= mInsetState.mInsetRight;
        //r.bottom -= mInsetState.mInsetBottom;
        //mInsetState.mDrawable.setBounds(r.left, r.top, r.right, r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.385 -0400", hash_original_method = "AB4853FCC2E61C4308CEBFB5AE69B700", hash_generated_method = "342328569339DD6F1B08015E840A438D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getIntrinsicWidth() {
        int varD77C9A288011CB8161A5891EAD9C1592_1039329783 = (mInsetState.mDrawable.getIntrinsicWidth());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mInsetState.mDrawable.getIntrinsicWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.385 -0400", hash_original_method = "29FF5B29153AE16681DB19A374B63115", hash_generated_method = "F655E611B7C5B2DCD18E31B2062AAB3E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getIntrinsicHeight() {
        int var5F2B6F0755F35B09C0CED510B2920689_705533964 = (mInsetState.mDrawable.getIntrinsicHeight());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mInsetState.mDrawable.getIntrinsicHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.396 -0400", hash_original_method = "1E9E2DEF1AEF301447A2F1B1CB9B55FF", hash_generated_method = "06834E8E5AAA1FBF58E236E6D0C32A63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ConstantState getConstantState() {
        {
            boolean varDF5C3001CFA292CC1683AFE8A4C4D7A6_176983324 = (mInsetState.canConstantState());
            {
                mInsetState.mChangingConfigurations = getChangingConfigurations();
            } //End block
        } //End collapsed parenthetic
        return (ConstantState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mInsetState.canConstantState()) {
            //mInsetState.mChangingConfigurations = getChangingConfigurations();
            //return mInsetState;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.396 -0400", hash_original_method = "22F293566220E6F3A8D3A4AE196709E5", hash_generated_method = "C0175AC6D2ACC659B19AC9A8A3F77C4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Drawable mutate() {
        {
            boolean varC94B19053599294E7944C8C841976773_1911716494 = (!mMutated && super.mutate() == this);
            {
                mInsetState.mDrawable.mutate();
                mMutated = true;
            } //End block
        } //End collapsed parenthetic
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!mMutated && super.mutate() == this) {
            //mInsetState.mDrawable.mutate();
            //mMutated = true;
        //}
        //return this;
    }

    
    final static class InsetState extends ConstantState {
        Drawable mDrawable;
        int mChangingConfigurations;
        int mInsetLeft;
        int mInsetTop;
        int mInsetRight;
        int mInsetBottom;
        boolean mCheckedConstantState;
        boolean mCanConstantState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.398 -0400", hash_original_method = "758BE6D06942564382533B70A9D03639", hash_generated_method = "1131F72DD572C6362743C73D5D2178A6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         InsetState(InsetState orig, InsetDrawable owner, Resources res) {
            dsTaint.addTaint(res.dsTaint);
            dsTaint.addTaint(owner.dsTaint);
            dsTaint.addTaint(orig.dsTaint);
            {
                {
                    mDrawable = orig.mDrawable.getConstantState().newDrawable(res);
                } //End block
                {
                    mDrawable = orig.mDrawable.getConstantState().newDrawable();
                } //End block
                mDrawable.setCallback(owner);
                mInsetLeft = orig.mInsetLeft;
                mInsetTop = orig.mInsetTop;
                mInsetRight = orig.mInsetRight;
                mInsetBottom = orig.mInsetBottom;
                mCheckedConstantState = mCanConstantState = true;
            } //End block
            // ---------- Original Method ----------
            //if (orig != null) {
                //if (res != null) {
                    //mDrawable = orig.mDrawable.getConstantState().newDrawable(res);
                //} else {
                    //mDrawable = orig.mDrawable.getConstantState().newDrawable();
                //}
                //mDrawable.setCallback(owner);
                //mInsetLeft = orig.mInsetLeft;
                //mInsetTop = orig.mInsetTop;
                //mInsetRight = orig.mInsetRight;
                //mInsetBottom = orig.mInsetBottom;
                //mCheckedConstantState = mCanConstantState = true;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.399 -0400", hash_original_method = "6B31FDACEACBBE413B6F897E56BE7FF9", hash_generated_method = "FA4016FBDE90DC7CDA1C787C4F59018F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Drawable newDrawable() {
            Drawable varDC06677BBFCCD7CBD3514F5B654FF5BB_1210811010 = (new InsetDrawable(this, null));
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new InsetDrawable(this, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.399 -0400", hash_original_method = "51EF496D1F925226C92A50925EFC08B6", hash_generated_method = "5542EDA83DE2EE333F7770D3661F04D8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Drawable newDrawable(Resources res) {
            dsTaint.addTaint(res.dsTaint);
            Drawable varFF82EEBE2CC997C8515BFCBC6B35808E_2059879801 = (new InsetDrawable(this, res));
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new InsetDrawable(this, res);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.399 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "36011B0CFA5B1C48E438EB66BB35159E")
        @DSModeled(DSC.SAFE)
        @Override
        public int getChangingConfigurations() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.399 -0400", hash_original_method = "8D2A3A495FE794F654E28C73CF35A2A1", hash_generated_method = "91841D4C432CEA46787D356B5812EFCD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         boolean canConstantState() {
            {
                mCanConstantState = mDrawable.getConstantState() != null;
                mCheckedConstantState = true;
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (!mCheckedConstantState) {
                //mCanConstantState = mDrawable.getConstantState() != null;
                //mCheckedConstantState = true;
            //}
            //return mCanConstantState;
        }

        
    }


    
}

