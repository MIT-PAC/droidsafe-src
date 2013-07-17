package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.*;
import android.util.AttributeSet;
import android.util.Log;
import java.io.IOException;

public class InsetDrawable extends Drawable implements Drawable.Callback {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.045 -0400", hash_original_field = "692D46240E2C79BE643C2665EC4B2520", hash_generated_field = "3AE2C9F0AA2C9F1010956C331820EBD8")

    private InsetState mInsetState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.045 -0400", hash_original_field = "C16522492B0457D64CB22178541F3ACA", hash_generated_field = "570061BA9CB059462550E9BCCD2A0735")

    private final Rect mTmpRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.045 -0400", hash_original_field = "9FB80C30383848C8D006680B5F3BDAF9", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.045 -0400", hash_original_method = "F48DBEE10522FF6B015323744245900F", hash_generated_method = "DDE232BCCCC6C70EAA4019D4AF233073")
      InsetDrawable() {
        this(null, null);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.045 -0400", hash_original_method = "2918696D36F33B173FD0AA17323912B6", hash_generated_method = "C707C6402ABF12F91F85B26152257A57")
    public  InsetDrawable(Drawable drawable, int inset) {
        this(drawable, inset, inset, inset, inset);
        addTaint(inset);
        addTaint(drawable.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.046 -0400", hash_original_method = "410D0B69961CD6B4D438C72969BE5ACA", hash_generated_method = "BDE2FD81BC8DEC3BDC4CFFBE6796D731")
    public  InsetDrawable(Drawable drawable, int insetLeft, int insetTop,
                         int insetRight, int insetBottom) {
        this(null, null);
        mInsetState.mDrawable = drawable;
        mInsetState.mInsetLeft = insetLeft;
        mInsetState.mInsetTop = insetTop;
        mInsetState.mInsetRight = insetRight;
        mInsetState.mInsetBottom = insetBottom;
        if(drawable != null)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.046 -0400", hash_original_method = "125D08C0C0AD10DE80234690E438546C", hash_generated_method = "D3D8132F753D7CBE37A3E6171E0E9075")
    private  InsetDrawable(InsetState state, Resources res) {
        mInsetState = new InsetState(state, this, res);
        // ---------- Original Method ----------
        //mInsetState = new InsetState(state, this, res);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.047 -0400", hash_original_method = "308C72D2B889366D58587F5D48DD90DC", hash_generated_method = "101DDD0BB91A7A23B315B4B03BDC9C6B")
    @Override
    public void inflate(Resources r, XmlPullParser parser,
                                  AttributeSet attrs) throws XmlPullParserException, IOException {
        addTaint(attrs.getTaint());
        addTaint(parser.getTaint());
        addTaint(r.getTaint());
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
        if(drawableRes != 0)        
        {
            dr = r.getDrawable(drawableRes);
        } //End block
        else
        {
            while
((type=parser.next()) == XmlPullParser.TEXT)            
            {
            } //End block
            if(type != XmlPullParser.START_TAG)            
            {
                XmlPullParserException var58281AF8D26FBBBC49F5D1A227F1BE07_2060693535 = new XmlPullParserException(
                        parser.getPositionDescription()
                        + ": <inset> tag requires a 'drawable' attribute or "
                        + "child tag defining a drawable");
                var58281AF8D26FBBBC49F5D1A227F1BE07_2060693535.addTaint(taint);
                throw var58281AF8D26FBBBC49F5D1A227F1BE07_2060693535;
            } //End block
            dr = Drawable.createFromXmlInner(r, parser, attrs);
        } //End block
        if(dr == null)        
        {
        } //End block
        mInsetState.mDrawable = dr;
        mInsetState.mInsetLeft = inLeft;
        mInsetState.mInsetRight = inRight;
        mInsetState.mInsetTop = inTop;
        mInsetState.mInsetBottom = inBottom;
        if(dr != null)        
        {
            dr.setCallback(this);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.048 -0400", hash_original_method = "289E4B14FC4BAEE8FBED5C03A1D9B634", hash_generated_method = "41CEDEB5E33EFE6B1A6A0CCC10DBF093")
    public void invalidateDrawable(Drawable who) {
        addTaint(who.getTaint());
        final Callback callback = getCallback();
        if(callback != null)        
        {
            callback.invalidateDrawable(this);
        } //End block
        // ---------- Original Method ----------
        //final Callback callback = getCallback();
        //if (callback != null) {
            //callback.invalidateDrawable(this);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.049 -0400", hash_original_method = "A01CAF97CFFAA14450A9600E14E88C8D", hash_generated_method = "7093C805993ACF54047727682755EE99")
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        addTaint(when);
        addTaint(what.getTaint());
        addTaint(who.getTaint());
        final Callback callback = getCallback();
        if(callback != null)        
        {
            callback.scheduleDrawable(this, what, when);
        } //End block
        // ---------- Original Method ----------
        //final Callback callback = getCallback();
        //if (callback != null) {
            //callback.scheduleDrawable(this, what, when);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.049 -0400", hash_original_method = "CA144C86313E3C1A3DC044F014305D8E", hash_generated_method = "FFEE17E462526EA539C05FAA6C36C1E2")
    public void unscheduleDrawable(Drawable who, Runnable what) {
        addTaint(what.getTaint());
        addTaint(who.getTaint());
        final Callback callback = getCallback();
        if(callback != null)        
        {
            callback.unscheduleDrawable(this, what);
        } //End block
        // ---------- Original Method ----------
        //final Callback callback = getCallback();
        //if (callback != null) {
            //callback.unscheduleDrawable(this, what);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.049 -0400", hash_original_method = "5D957288FBCBF53EE4FDA5CCA4D587F6", hash_generated_method = "0AE679AC8500AC73B320CE05372B04ED")
    @Override
    public void draw(Canvas canvas) {
        addTaint(canvas.getTaint());
        mInsetState.mDrawable.draw(canvas);
        // ---------- Original Method ----------
        //mInsetState.mDrawable.draw(canvas);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.050 -0400", hash_original_method = "5E6B5E9F59EDAB724B1161E1868DCBF2", hash_generated_method = "2C7280979C9D9C7359BF015AFD3DE0AC")
    @Override
    public int getChangingConfigurations() {
        int var8BCB67A53F511443DB184419A87F2E7C_991974904 = (super.getChangingConfigurations()
                | mInsetState.mChangingConfigurations
                | mInsetState.mDrawable.getChangingConfigurations());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_889227972 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_889227972;
        // ---------- Original Method ----------
        //return super.getChangingConfigurations()
                //| mInsetState.mChangingConfigurations
                //| mInsetState.mDrawable.getChangingConfigurations();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.051 -0400", hash_original_method = "453C0F994CC6F9573C64E5784E899FE5", hash_generated_method = "E09DE66DC38BF792FBF17D7993663C0E")
    @Override
    public boolean getPadding(Rect padding) {
        addTaint(padding.getTaint());
        boolean pad = mInsetState.mDrawable.getPadding(padding);
        padding.left += mInsetState.mInsetLeft;
        padding.right += mInsetState.mInsetRight;
        padding.top += mInsetState.mInsetTop;
        padding.bottom += mInsetState.mInsetBottom;
        if(pad || (mInsetState.mInsetLeft | mInsetState.mInsetRight | 
                    mInsetState.mInsetTop | mInsetState.mInsetBottom) != 0)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1342924289 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_332453046 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_332453046;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_214485759 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_429872371 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_429872371;
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.052 -0400", hash_original_method = "EFF30D1C1A84058D8C292EB91F9472BE", hash_generated_method = "5854DA1CF7A8E8DB6F28508AF46A1525")
    @Override
    public boolean setVisible(boolean visible, boolean restart) {
        addTaint(restart);
        addTaint(visible);
        mInsetState.mDrawable.setVisible(visible, restart);
        boolean varDDF69A03BCD0C3664F5E7921DE2D1E4B_1324809738 = (super.setVisible(visible, restart));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_392893885 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_392893885;
        // ---------- Original Method ----------
        //mInsetState.mDrawable.setVisible(visible, restart);
        //return super.setVisible(visible, restart);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.052 -0400", hash_original_method = "B23A5809007626F95D6E0E75FACEBCF9", hash_generated_method = "B2E55B711D3C9EC7C67C521CC17C04FF")
    @Override
    public void setAlpha(int alpha) {
        addTaint(alpha);
        mInsetState.mDrawable.setAlpha(alpha);
        // ---------- Original Method ----------
        //mInsetState.mDrawable.setAlpha(alpha);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.053 -0400", hash_original_method = "06DFACBA6F5F88BE2848B90C2DE93101", hash_generated_method = "FD2032C111DF32112CC3353B961D84D1")
    @Override
    public void setColorFilter(ColorFilter cf) {
        addTaint(cf.getTaint());
        mInsetState.mDrawable.setColorFilter(cf);
        // ---------- Original Method ----------
        //mInsetState.mDrawable.setColorFilter(cf);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.053 -0400", hash_original_method = "84C32146675D5EBE47A9CF2427DBDE28", hash_generated_method = "92740E29287CE805F5822D375DD7C2BE")
    @Override
    public int getOpacity() {
        int var981B0A1EB9C31692794A7C5F2677F8AA_1515290905 = (mInsetState.mDrawable.getOpacity());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1027760640 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1027760640;
        // ---------- Original Method ----------
        //return mInsetState.mDrawable.getOpacity();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.054 -0400", hash_original_method = "043A29D2ADB29827582E75471CD5479B", hash_generated_method = "C377F8DDBFF81DC3A4C0806CF3984C2F")
    @Override
    public boolean isStateful() {
        boolean var7A5AB571406FDEB1DF724D88561FF188_1581993717 = (mInsetState.mDrawable.isStateful());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1250419384 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1250419384;
        // ---------- Original Method ----------
        //return mInsetState.mDrawable.isStateful();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.054 -0400", hash_original_method = "246AAD5F68D871EA63688A0B06577CD4", hash_generated_method = "7D4B3443EE81F1CEF57937A4602F13EE")
    @Override
    protected boolean onStateChange(int[] state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state[0]);
        boolean changed = mInsetState.mDrawable.setState(state);
        onBoundsChange(getBounds());
        boolean var8977DFAC2F8E04CB96E66882235F5ABA_113745358 = (changed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1753642465 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1753642465;
        // ---------- Original Method ----------
        //boolean changed = mInsetState.mDrawable.setState(state);
        //onBoundsChange(getBounds());
        //return changed;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.055 -0400", hash_original_method = "95EBA24DAC30ACDEC92CAFB7918B63D7", hash_generated_method = "3FAE60EE4D8770E53E9BFE6F069424E4")
    @Override
    protected void onBoundsChange(Rect bounds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(bounds.getTaint());
        final Rect r = mTmpRect;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.056 -0400", hash_original_method = "AB4853FCC2E61C4308CEBFB5AE69B700", hash_generated_method = "7D068A89E49B2D899868E59A520790A1")
    @Override
    public int getIntrinsicWidth() {
        int var0828DDC3E2ECF8919494808606EBDB3D_471687361 = (mInsetState.mDrawable.getIntrinsicWidth());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_316165814 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_316165814;
        // ---------- Original Method ----------
        //return mInsetState.mDrawable.getIntrinsicWidth();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.056 -0400", hash_original_method = "29FF5B29153AE16681DB19A374B63115", hash_generated_method = "397210219C72CA7AE259B214AA8121E9")
    @Override
    public int getIntrinsicHeight() {
        int varD4CCE1A91A4F9DBCFF307766E7EAC390_379064829 = (mInsetState.mDrawable.getIntrinsicHeight());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1636884344 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1636884344;
        // ---------- Original Method ----------
        //return mInsetState.mDrawable.getIntrinsicHeight();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.057 -0400", hash_original_method = "1E9E2DEF1AEF301447A2F1B1CB9B55FF", hash_generated_method = "2615CF71CA3847A29EFD47ECC5EEA634")
    @Override
    public ConstantState getConstantState() {
        if(mInsetState.canConstantState())        
        {
            mInsetState.mChangingConfigurations = getChangingConfigurations();
ConstantState var133144328737051F5F5AB1032A4ECC7F_1624180696 =             mInsetState;
            var133144328737051F5F5AB1032A4ECC7F_1624180696.addTaint(taint);
            return var133144328737051F5F5AB1032A4ECC7F_1624180696;
        } //End block
ConstantState var540C13E9E156B687226421B24F2DF178_2087854974 =         null;
        var540C13E9E156B687226421B24F2DF178_2087854974.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2087854974;
        // ---------- Original Method ----------
        //if (mInsetState.canConstantState()) {
            //mInsetState.mChangingConfigurations = getChangingConfigurations();
            //return mInsetState;
        //}
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.057 -0400", hash_original_method = "22F293566220E6F3A8D3A4AE196709E5", hash_generated_method = "5468D9C07A7B440F70D3B6DFCFADF543")
    @Override
    public Drawable mutate() {
        if(!mMutated && super.mutate() == this)        
        {
            mInsetState.mDrawable.mutate();
            mMutated = true;
        } //End block
Drawable var72A74007B2BE62B849F475C7BDA4658B_1181236348 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1181236348.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1181236348;
        // ---------- Original Method ----------
        //if (!mMutated && super.mutate() == this) {
            //mInsetState.mDrawable.mutate();
            //mMutated = true;
        //}
        //return this;
    }

    
    final static class InsetState extends ConstantState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.058 -0400", hash_original_field = "D548B27C6AC66A9D9B5D05ED35C2D844", hash_generated_field = "38BA53DD394F85639C99ED8E666FF8FB")

        Drawable mDrawable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.058 -0400", hash_original_field = "276E0645C4E2084773D0EB8C5576428C", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.058 -0400", hash_original_field = "0661D6C227585E45459B91C5D242ACDF", hash_generated_field = "E2BE4EAC7479E12B8AD15F8A1DC878B0")

        int mInsetLeft;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.058 -0400", hash_original_field = "7C1DAF4ABF7868C1680EB9D50A37BCF1", hash_generated_field = "BDC766ACBEF4E33A22B4884B070885A7")

        int mInsetTop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.058 -0400", hash_original_field = "2A242A7F704CF1F009B3DCF034A62B32", hash_generated_field = "858AD29F4440BFB10D0903CBBA92AF5F")

        int mInsetRight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.058 -0400", hash_original_field = "1BF559D66726A6CAAC1A1E589C5D2017", hash_generated_field = "637B8F5F49094B17B0B21610CF248426")

        int mInsetBottom;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.058 -0400", hash_original_field = "2E319D4D352B34E33CF19129B7212FC6", hash_generated_field = "04605894B57F7B3414AF620BF4AC040E")

        boolean mCheckedConstantState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.059 -0400", hash_original_field = "7C8FD9809F31C20B8422D623B0EC0C4F", hash_generated_field = "09212A3A30B7E6D48DEECC4F4639CCBC")

        boolean mCanConstantState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.060 -0400", hash_original_method = "758BE6D06942564382533B70A9D03639", hash_generated_method = "19B8FADDE39120D20D6DC0EEFA7BD850")
          InsetState(InsetState orig, InsetDrawable owner, Resources res) {
            addTaint(owner.getTaint());
            if(orig != null)            
            {
                if(res != null)                
                {
                    mDrawable = orig.mDrawable.getConstantState().newDrawable(res);
                } //End block
                else
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.060 -0400", hash_original_method = "6B31FDACEACBBE413B6F897E56BE7FF9", hash_generated_method = "34FD35EF917736469C1FBF1762BE7BF1")
        @Override
        public Drawable newDrawable() {
Drawable varDB9B967A5014A8FE41C25705F9BF22C7_13126911 =             new InsetDrawable(this, null);
            varDB9B967A5014A8FE41C25705F9BF22C7_13126911.addTaint(taint);
            return varDB9B967A5014A8FE41C25705F9BF22C7_13126911;
            // ---------- Original Method ----------
            //return new InsetDrawable(this, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.060 -0400", hash_original_method = "51EF496D1F925226C92A50925EFC08B6", hash_generated_method = "26F99944B304C0D578C75525F9761CBC")
        @Override
        public Drawable newDrawable(Resources res) {
            addTaint(res.getTaint());
Drawable varFC2F28817735D8057413562963630ACD_1185924332 =             new InsetDrawable(this, res);
            varFC2F28817735D8057413562963630ACD_1185924332.addTaint(taint);
            return varFC2F28817735D8057413562963630ACD_1185924332;
            // ---------- Original Method ----------
            //return new InsetDrawable(this, res);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.061 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "423F30E30C4CB5EE312274BEDCEAC485")
        @Override
        public int getChangingConfigurations() {
            int var276E0645C4E2084773D0EB8C5576428C_520097837 = (mChangingConfigurations);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_548822743 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_548822743;
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.061 -0400", hash_original_method = "8D2A3A495FE794F654E28C73CF35A2A1", hash_generated_method = "F916E29121D16EEC051BC4EC73115E0B")
         boolean canConstantState() {
            if(!mCheckedConstantState)            
            {
                mCanConstantState = mDrawable.getConstantState() != null;
                mCheckedConstantState = true;
            } //End block
            boolean var7C8FD9809F31C20B8422D623B0EC0C4F_641248541 = (mCanConstantState);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_351765610 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_351765610;
            // ---------- Original Method ----------
            //if (!mCheckedConstantState) {
                //mCanConstantState = mDrawable.getConstantState() != null;
                //mCheckedConstantState = true;
            //}
            //return mCanConstantState;
        }

        
    }


    
}

