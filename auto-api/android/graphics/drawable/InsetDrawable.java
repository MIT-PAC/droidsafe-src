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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.456 -0400", hash_original_field = "692D46240E2C79BE643C2665EC4B2520", hash_generated_field = "3AE2C9F0AA2C9F1010956C331820EBD8")

    private InsetState mInsetState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.456 -0400", hash_original_field = "C16522492B0457D64CB22178541F3ACA", hash_generated_field = "A9D5B7D1068DC6DDDEE02560E993CCF6")

    private Rect mTmpRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.456 -0400", hash_original_field = "9FB80C30383848C8D006680B5F3BDAF9", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.548 -0400", hash_original_method = "F48DBEE10522FF6B015323744245900F", hash_generated_method = "DDE232BCCCC6C70EAA4019D4AF233073")
      InsetDrawable() {
        this(null, null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.548 -0400", hash_original_method = "2918696D36F33B173FD0AA17323912B6", hash_generated_method = "F516FC568E70638930A753F88AED5958")
    public  InsetDrawable(Drawable drawable, int inset) {
        this(drawable, inset, inset, inset, inset);
        addTaint(drawable.getTaint());
        addTaint(inset);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.564 -0400", hash_original_method = "410D0B69961CD6B4D438C72969BE5ACA", hash_generated_method = "B12F7AAED084552C5CFCA183DE3BD2DB")
    public  InsetDrawable(Drawable drawable, int insetLeft, int insetTop,
                         int insetRight, int insetBottom) {
        this(null, null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.565 -0400", hash_original_method = "125D08C0C0AD10DE80234690E438546C", hash_generated_method = "D3D8132F753D7CBE37A3E6171E0E9075")
    private  InsetDrawable(InsetState state, Resources res) {
        mInsetState = new InsetState(state, this, res);
        // ---------- Original Method ----------
        //mInsetState = new InsetState(state, this, res);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.586 -0400", hash_original_method = "308C72D2B889366D58587F5D48DD90DC", hash_generated_method = "D4B47DE17D51269F622F652E10E46914")
    @Override
    public void inflate(Resources r, XmlPullParser parser,
                                  AttributeSet attrs) throws XmlPullParserException, IOException {
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
                boolean var6B5B5852701B8FCC2CE942637EBFE70C_1530858436 = ((type=parser.next()) == XmlPullParser.TEXT);
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
        addTaint(r.getTaint());
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.587 -0400", hash_original_method = "289E4B14FC4BAEE8FBED5C03A1D9B634", hash_generated_method = "8C74E1ED724AA0C6A0C97462CE6BFB75")
    public void invalidateDrawable(Drawable who) {
        Callback callback;
        callback = getCallback();
        {
            callback.invalidateDrawable(this);
        } //End block
        addTaint(who.getTaint());
        // ---------- Original Method ----------
        //final Callback callback = getCallback();
        //if (callback != null) {
            //callback.invalidateDrawable(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.607 -0400", hash_original_method = "A01CAF97CFFAA14450A9600E14E88C8D", hash_generated_method = "D0BA170008FFB5E5F5CAA53137A69B81")
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        Callback callback;
        callback = getCallback();
        {
            callback.scheduleDrawable(this, what, when);
        } //End block
        addTaint(who.getTaint());
        addTaint(what.getTaint());
        addTaint(when);
        // ---------- Original Method ----------
        //final Callback callback = getCallback();
        //if (callback != null) {
            //callback.scheduleDrawable(this, what, when);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.608 -0400", hash_original_method = "CA144C86313E3C1A3DC044F014305D8E", hash_generated_method = "F27A8BA34D960AEC80EA06B1020FC534")
    public void unscheduleDrawable(Drawable who, Runnable what) {
        Callback callback;
        callback = getCallback();
        {
            callback.unscheduleDrawable(this, what);
        } //End block
        addTaint(who.getTaint());
        addTaint(what.getTaint());
        // ---------- Original Method ----------
        //final Callback callback = getCallback();
        //if (callback != null) {
            //callback.unscheduleDrawable(this, what);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.609 -0400", hash_original_method = "5D957288FBCBF53EE4FDA5CCA4D587F6", hash_generated_method = "DDC1BB677D2FDD30A29668EC6FA6B286")
    @Override
    public void draw(Canvas canvas) {
        mInsetState.mDrawable.draw(canvas);
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        //mInsetState.mDrawable.draw(canvas);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.631 -0400", hash_original_method = "5E6B5E9F59EDAB724B1161E1868DCBF2", hash_generated_method = "8536F972DD054EB3A46228E8CA6B34FA")
    @Override
    public int getChangingConfigurations() {
        int var61EF387ADAB9AB2D890E9E42218FD44A_1693945257 = (super.getChangingConfigurations()
                | mInsetState.mChangingConfigurations
                | mInsetState.mDrawable.getChangingConfigurations());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1049816692 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1049816692;
        // ---------- Original Method ----------
        //return super.getChangingConfigurations()
                //| mInsetState.mChangingConfigurations
                //| mInsetState.mDrawable.getChangingConfigurations();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.633 -0400", hash_original_method = "453C0F994CC6F9573C64E5784E899FE5", hash_generated_method = "C2E59C8CAEEE2989E7BCDAFBFD4A00C7")
    @Override
    public boolean getPadding(Rect padding) {
        boolean pad;
        pad = mInsetState.mDrawable.getPadding(padding);
        padding.left += mInsetState.mInsetLeft;
        padding.right += mInsetState.mInsetRight;
        padding.top += mInsetState.mInsetTop;
        padding.bottom += mInsetState.mInsetBottom;
        addTaint(padding.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_185773692 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_185773692;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.634 -0400", hash_original_method = "EFF30D1C1A84058D8C292EB91F9472BE", hash_generated_method = "E058B2D372D46AA2887CD3170F50EC7B")
    @Override
    public boolean setVisible(boolean visible, boolean restart) {
        mInsetState.mDrawable.setVisible(visible, restart);
        boolean var9D015C67047440F1849257F892B1DD1F_1406404032 = (super.setVisible(visible, restart));
        addTaint(visible);
        addTaint(restart);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_822735573 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_822735573;
        // ---------- Original Method ----------
        //mInsetState.mDrawable.setVisible(visible, restart);
        //return super.setVisible(visible, restart);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.634 -0400", hash_original_method = "B23A5809007626F95D6E0E75FACEBCF9", hash_generated_method = "2DB5D0F9927235609F5B5403BE4C0B30")
    @Override
    public void setAlpha(int alpha) {
        mInsetState.mDrawable.setAlpha(alpha);
        addTaint(alpha);
        // ---------- Original Method ----------
        //mInsetState.mDrawable.setAlpha(alpha);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.654 -0400", hash_original_method = "06DFACBA6F5F88BE2848B90C2DE93101", hash_generated_method = "15B428D72E537C686D0BB3487E0C3605")
    @Override
    public void setColorFilter(ColorFilter cf) {
        mInsetState.mDrawable.setColorFilter(cf);
        addTaint(cf.getTaint());
        // ---------- Original Method ----------
        //mInsetState.mDrawable.setColorFilter(cf);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.654 -0400", hash_original_method = "84C32146675D5EBE47A9CF2427DBDE28", hash_generated_method = "A10EABDBF6CE4CC828BBB99C45F229BC")
    @Override
    public int getOpacity() {
        int varBEAEEE19271DBC4B9E294A9607E28C8B_2024323713 = (mInsetState.mDrawable.getOpacity());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_832576627 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_832576627;
        // ---------- Original Method ----------
        //return mInsetState.mDrawable.getOpacity();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.655 -0400", hash_original_method = "043A29D2ADB29827582E75471CD5479B", hash_generated_method = "DC848178776D015810563943E37D7E4E")
    @Override
    public boolean isStateful() {
        boolean varBA951C8D6B94B7E63AFFEFE558352D27_351086192 = (mInsetState.mDrawable.isStateful());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_710711674 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_710711674;
        // ---------- Original Method ----------
        //return mInsetState.mDrawable.isStateful();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.655 -0400", hash_original_method = "246AAD5F68D871EA63688A0B06577CD4", hash_generated_method = "A331886E764714DB476718EA83620A6C")
    @Override
    protected boolean onStateChange(int[] state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        boolean changed;
        changed = mInsetState.mDrawable.setState(state);
        onBoundsChange(getBounds());
        addTaint(state[0]);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1353734004 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1353734004;
        // ---------- Original Method ----------
        //boolean changed = mInsetState.mDrawable.setState(state);
        //onBoundsChange(getBounds());
        //return changed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.657 -0400", hash_original_method = "95EBA24DAC30ACDEC92CAFB7918B63D7", hash_generated_method = "A2065B0F50E9DFA088244C6265EFE6D7")
    @Override
    protected void onBoundsChange(Rect bounds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Rect r;
        r = mTmpRect;
        r.set(bounds);
        r.left += mInsetState.mInsetLeft;
        r.top += mInsetState.mInsetTop;
        r.right -= mInsetState.mInsetRight;
        r.bottom -= mInsetState.mInsetBottom;
        mInsetState.mDrawable.setBounds(r.left, r.top, r.right, r.bottom);
        addTaint(bounds.getTaint());
        // ---------- Original Method ----------
        //final Rect r = mTmpRect;
        //r.set(bounds);
        //r.left += mInsetState.mInsetLeft;
        //r.top += mInsetState.mInsetTop;
        //r.right -= mInsetState.mInsetRight;
        //r.bottom -= mInsetState.mInsetBottom;
        //mInsetState.mDrawable.setBounds(r.left, r.top, r.right, r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.662 -0400", hash_original_method = "AB4853FCC2E61C4308CEBFB5AE69B700", hash_generated_method = "7901A425C503CCBB48AD66C681566C37")
    @Override
    public int getIntrinsicWidth() {
        int varD77C9A288011CB8161A5891EAD9C1592_1368074025 = (mInsetState.mDrawable.getIntrinsicWidth());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1938786039 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1938786039;
        // ---------- Original Method ----------
        //return mInsetState.mDrawable.getIntrinsicWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.665 -0400", hash_original_method = "29FF5B29153AE16681DB19A374B63115", hash_generated_method = "D33DE7F149F8D4824B02B44D96BBCE66")
    @Override
    public int getIntrinsicHeight() {
        int var5F2B6F0755F35B09C0CED510B2920689_187495518 = (mInsetState.mDrawable.getIntrinsicHeight());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1908487205 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1908487205;
        // ---------- Original Method ----------
        //return mInsetState.mDrawable.getIntrinsicHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.689 -0400", hash_original_method = "1E9E2DEF1AEF301447A2F1B1CB9B55FF", hash_generated_method = "966EC42836D4FC63E06B01DC6F257050")
    @Override
    public ConstantState getConstantState() {
        ConstantState varB4EAC82CA7396A68D541C85D26508E83_1216490585 = null; //Variable for return #1
        ConstantState varB4EAC82CA7396A68D541C85D26508E83_247503951 = null; //Variable for return #2
        {
            boolean varDF5C3001CFA292CC1683AFE8A4C4D7A6_436017899 = (mInsetState.canConstantState());
            {
                mInsetState.mChangingConfigurations = getChangingConfigurations();
                varB4EAC82CA7396A68D541C85D26508E83_1216490585 = mInsetState;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_247503951 = null;
        ConstantState varA7E53CE21691AB073D9660D615818899_1969176363; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1969176363 = varB4EAC82CA7396A68D541C85D26508E83_1216490585;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1969176363 = varB4EAC82CA7396A68D541C85D26508E83_247503951;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1969176363.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1969176363;
        // ---------- Original Method ----------
        //if (mInsetState.canConstantState()) {
            //mInsetState.mChangingConfigurations = getChangingConfigurations();
            //return mInsetState;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.690 -0400", hash_original_method = "22F293566220E6F3A8D3A4AE196709E5", hash_generated_method = "88A813AC9FDE5167FF1DC8F8BE884FC3")
    @Override
    public Drawable mutate() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_417988671 = null; //Variable for return #1
        {
            boolean varC94B19053599294E7944C8C841976773_1700585142 = (!mMutated && super.mutate() == this);
            {
                mInsetState.mDrawable.mutate();
                mMutated = true;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_417988671 = this;
        varB4EAC82CA7396A68D541C85D26508E83_417988671.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_417988671;
        // ---------- Original Method ----------
        //if (!mMutated && super.mutate() == this) {
            //mInsetState.mDrawable.mutate();
            //mMutated = true;
        //}
        //return this;
    }

    
    final static class InsetState extends ConstantState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.700 -0400", hash_original_field = "D548B27C6AC66A9D9B5D05ED35C2D844", hash_generated_field = "38BA53DD394F85639C99ED8E666FF8FB")

        Drawable mDrawable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.700 -0400", hash_original_field = "276E0645C4E2084773D0EB8C5576428C", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.700 -0400", hash_original_field = "0661D6C227585E45459B91C5D242ACDF", hash_generated_field = "E2BE4EAC7479E12B8AD15F8A1DC878B0")

        int mInsetLeft;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.701 -0400", hash_original_field = "7C1DAF4ABF7868C1680EB9D50A37BCF1", hash_generated_field = "BDC766ACBEF4E33A22B4884B070885A7")

        int mInsetTop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.701 -0400", hash_original_field = "2A242A7F704CF1F009B3DCF034A62B32", hash_generated_field = "858AD29F4440BFB10D0903CBBA92AF5F")

        int mInsetRight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.701 -0400", hash_original_field = "1BF559D66726A6CAAC1A1E589C5D2017", hash_generated_field = "637B8F5F49094B17B0B21610CF248426")

        int mInsetBottom;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.701 -0400", hash_original_field = "2E319D4D352B34E33CF19129B7212FC6", hash_generated_field = "04605894B57F7B3414AF620BF4AC040E")

        boolean mCheckedConstantState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.701 -0400", hash_original_field = "7C8FD9809F31C20B8422D623B0EC0C4F", hash_generated_field = "09212A3A30B7E6D48DEECC4F4639CCBC")

        boolean mCanConstantState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.717 -0400", hash_original_method = "758BE6D06942564382533B70A9D03639", hash_generated_method = "2C50C7EFE727D0458A162A0FD19AAFDA")
          InsetState(InsetState orig, InsetDrawable owner, Resources res) {
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
            addTaint(owner.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.729 -0400", hash_original_method = "6B31FDACEACBBE413B6F897E56BE7FF9", hash_generated_method = "0FC35D25F11454C74976CE759E1EB981")
        @Override
        public Drawable newDrawable() {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_232432677 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_232432677 = new InsetDrawable(this, null);
            varB4EAC82CA7396A68D541C85D26508E83_232432677.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_232432677;
            // ---------- Original Method ----------
            //return new InsetDrawable(this, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.734 -0400", hash_original_method = "51EF496D1F925226C92A50925EFC08B6", hash_generated_method = "3DEC99723FA1D7E3A5D995DD5B2BCE18")
        @Override
        public Drawable newDrawable(Resources res) {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_1168115345 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1168115345 = new InsetDrawable(this, res);
            addTaint(res.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1168115345.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1168115345;
            // ---------- Original Method ----------
            //return new InsetDrawable(this, res);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.734 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "C3E4857B0A6022D4F9B0D9D41CF0D7D8")
        @Override
        public int getChangingConfigurations() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1358661724 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1358661724;
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.735 -0400", hash_original_method = "8D2A3A495FE794F654E28C73CF35A2A1", hash_generated_method = "AD771F33AC87719DFDDD99C8C3618705")
         boolean canConstantState() {
            {
                mCanConstantState = mDrawable.getConstantState() != null;
                mCheckedConstantState = true;
            } //End block
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_373991453 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_373991453;
            // ---------- Original Method ----------
            //if (!mCheckedConstantState) {
                //mCanConstantState = mDrawable.getConstantState() != null;
                //mCheckedConstantState = true;
            //}
            //return mCanConstantState;
        }

        
    }


    
}

