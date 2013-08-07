package android.graphics.drawable;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.537 -0400", hash_original_field = "2D1FE34192530332F56868A0998C61E0", hash_generated_field = "1B46C06B589E11041FD605EA02E6FD03")

    private ScaleState mScaleState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.537 -0400", hash_original_field = "9FB80C30383848C8D006680B5F3BDAF9", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.537 -0400", hash_original_field = "C16522492B0457D64CB22178541F3ACA", hash_generated_field = "570061BA9CB059462550E9BCCD2A0735")

    private final Rect mTmpRect = new Rect();
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.537 -0400", hash_original_method = "514942F1E0299625DD7C1CF4A65C7704", hash_generated_method = "EC158C9898C13743C5AABD0B773303D8")
      ScaleDrawable() {
        this(null, null);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.538 -0400", hash_original_method = "70D37B4EA14F56A15F832FEAF48A06AB", hash_generated_method = "B8E122F34396D83FB465FB26AF671D41")
    public  ScaleDrawable(Drawable drawable, int gravity, float scaleWidth, float scaleHeight) {
        this(null, null);
        mScaleState.mDrawable = drawable;
        mScaleState.mGravity = gravity;
        mScaleState.mScaleWidth = scaleWidth;
        mScaleState.mScaleHeight = scaleHeight;
        if(drawable != null)        
        {
            drawable.setCallback(this);
        } //End block
        // ---------- Original Method ----------
        //mScaleState.mDrawable = drawable;
        //mScaleState.mGravity = gravity;
        //mScaleState.mScaleWidth = scaleWidth;
        //mScaleState.mScaleHeight = scaleHeight;
        //if (drawable != null) {
            //drawable.setCallback(this);
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.539 -0400", hash_original_method = "044BA74036106E0DA1F4FE69AE9E5ADC", hash_generated_method = "6721B4F6DF11F5114CA467CA4B12E797")
    private  ScaleDrawable(ScaleState state, Resources res) {
        mScaleState = new ScaleState(state, this, res);
        // ---------- Original Method ----------
        //mScaleState = new ScaleState(state, this, res);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.540 -0400", hash_original_method = "AEF970ED5616036B7E8018EB225E392F", hash_generated_method = "407D66097D7D477CAB56630445F364CA")
    public Drawable getDrawable() {
Drawable varCFDEF89FAAF67147C5DB39DD126E8ABC_895390183 =         mScaleState.mDrawable;
        varCFDEF89FAAF67147C5DB39DD126E8ABC_895390183.addTaint(taint);
        return varCFDEF89FAAF67147C5DB39DD126E8ABC_895390183;
        // ---------- Original Method ----------
        //return mScaleState.mDrawable;
    }

    
    @DSModeled(DSC.BAN)
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.542 -0400", hash_original_method = "49F4934EE2B25F6F115AF16904B4D689", hash_generated_method = "18728B827B2060E7E333E125B3BB8F41")
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        addTaint(attrs.getTaint());
        addTaint(parser.getTaint());
        addTaint(r.getTaint());
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
        while
((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth))        
        {
            if(type != XmlPullParser.START_TAG)            
            {
                continue;
            } //End block
            dr = Drawable.createFromXmlInner(r, parser, attrs);
        } //End block
        if(dr == null)        
        {
            IllegalArgumentException var296C3945B24A6DAF188AA064355DB331_502279918 = new IllegalArgumentException("No drawable specified for <scale>");
            var296C3945B24A6DAF188AA064355DB331_502279918.addTaint(taint);
            throw var296C3945B24A6DAF188AA064355DB331_502279918;
        } //End block
        mScaleState.mDrawable = dr;
        mScaleState.mScaleWidth = sw;
        mScaleState.mScaleHeight = sh;
        mScaleState.mGravity = g;
        mScaleState.mUseIntrinsicSizeAsMin = min;
        if(dr != null)        
        {
            dr.setCallback(this);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.543 -0400", hash_original_method = "DF6A36F8E9590497BD97E858748A70C0", hash_generated_method = "4A84881D5DFABD53CF58861821BFB1CA")
    public void invalidateDrawable(Drawable who) {
        addTaint(who.getTaint());
        if(getCallback() != null)        
        {
            getCallback().invalidateDrawable(this);
        } //End block
        // ---------- Original Method ----------
        //if (getCallback() != null) {
            //getCallback().invalidateDrawable(this);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.544 -0400", hash_original_method = "18649734DD6C42C2C51CF25B20D68FBF", hash_generated_method = "2FBABF4BE921E820D97AFDA86AEB6986")
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        addTaint(when);
        addTaint(what.getTaint());
        addTaint(who.getTaint());
        if(getCallback() != null)        
        {
            getCallback().scheduleDrawable(this, what, when);
        } //End block
        // ---------- Original Method ----------
        //if (getCallback() != null) {
            //getCallback().scheduleDrawable(this, what, when);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.545 -0400", hash_original_method = "8711E8318CA3821644E7E9EDAB95B5BC", hash_generated_method = "D5428BD0C3009E8267A2EFB5215B7437")
    public void unscheduleDrawable(Drawable who, Runnable what) {
        addTaint(what.getTaint());
        addTaint(who.getTaint());
        if(getCallback() != null)        
        {
            getCallback().unscheduleDrawable(this, what);
        } //End block
        // ---------- Original Method ----------
        //if (getCallback() != null) {
            //getCallback().unscheduleDrawable(this, what);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.545 -0400", hash_original_method = "ADD59FF7C9EB5B0D687113ACE781DE45", hash_generated_method = "D3F76CFF2B875FCF8494927DD34ABE0F")
    @Override
    public void draw(Canvas canvas) {
        addTaint(canvas.getTaint());
        if(mScaleState.mDrawable.getLevel() != 0)        
        mScaleState.mDrawable.draw(canvas);
        // ---------- Original Method ----------
        //if (mScaleState.mDrawable.getLevel() != 0)
            //mScaleState.mDrawable.draw(canvas);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.546 -0400", hash_original_method = "E88B2D3506B9FB1C95A0FECA8D5B6D9F", hash_generated_method = "180F932DFDFA0DDE1EB274CEBA9B566C")
    @Override
    public int getChangingConfigurations() {
        int varFE16558EDF961E8C22E5D8E7855D6A36_339529748 = (super.getChangingConfigurations()
                | mScaleState.mChangingConfigurations
                | mScaleState.mDrawable.getChangingConfigurations());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_578053520 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_578053520;
        // ---------- Original Method ----------
        //return super.getChangingConfigurations()
                //| mScaleState.mChangingConfigurations
                //| mScaleState.mDrawable.getChangingConfigurations();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.546 -0400", hash_original_method = "2834251DB4FA1276891A806CA1B46D6D", hash_generated_method = "8A249244EEA219263AB1531A4334A339")
    @Override
    public boolean getPadding(Rect padding) {
        addTaint(padding.getTaint());
        boolean var74D386E055963C78D69AC2E3501F909E_635987274 = (mScaleState.mDrawable.getPadding(padding));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_672217638 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_672217638;
        // ---------- Original Method ----------
        //return mScaleState.mDrawable.getPadding(padding);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.546 -0400", hash_original_method = "DF926DDC801D2CA5859468C5FAF6E2DB", hash_generated_method = "354289CF8F62F9E6D36CF0D619E8743C")
    @Override
    public boolean setVisible(boolean visible, boolean restart) {
        addTaint(restart);
        addTaint(visible);
        mScaleState.mDrawable.setVisible(visible, restart);
        boolean varDDF69A03BCD0C3664F5E7921DE2D1E4B_857894130 = (super.setVisible(visible, restart));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_301538987 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_301538987;
        // ---------- Original Method ----------
        //mScaleState.mDrawable.setVisible(visible, restart);
        //return super.setVisible(visible, restart);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.547 -0400", hash_original_method = "A9094AF2E7BD2624EE02834D750BE346", hash_generated_method = "3E6C2E3452400390CF16D5196484E50D")
    @Override
    public void setAlpha(int alpha) {
        addTaint(alpha);
        mScaleState.mDrawable.setAlpha(alpha);
        // ---------- Original Method ----------
        //mScaleState.mDrawable.setAlpha(alpha);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.547 -0400", hash_original_method = "2F836B47975A4E15DB5892CD09923112", hash_generated_method = "79B1790A79853A41BB8B34DB5A143A2F")
    @Override
    public void setColorFilter(ColorFilter cf) {
        addTaint(cf.getTaint());
        mScaleState.mDrawable.setColorFilter(cf);
        // ---------- Original Method ----------
        //mScaleState.mDrawable.setColorFilter(cf);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.548 -0400", hash_original_method = "80BFCB126A2061429F3FFA03D49A8EF5", hash_generated_method = "D80BAE0CAC0F844C45F1BB9DC257A52A")
    @Override
    public int getOpacity() {
        int varFA91D5F40561C2811142D78F7907BA00_1307228258 = (mScaleState.mDrawable.getOpacity());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_111375853 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_111375853;
        // ---------- Original Method ----------
        //return mScaleState.mDrawable.getOpacity();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.548 -0400", hash_original_method = "0B20FD6DAF06E7B53C037B30AA0A67FB", hash_generated_method = "D91EC95098377224B836A108739B69D1")
    @Override
    public boolean isStateful() {
        boolean varA8FA306E0BC04CFC5782DE32631095DC_1371909124 = (mScaleState.mDrawable.isStateful());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_50015482 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_50015482;
        // ---------- Original Method ----------
        //return mScaleState.mDrawable.isStateful();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.548 -0400", hash_original_method = "53615D161AB187EDCCE7BACA4EBD5437", hash_generated_method = "A0856DE51A824CBD314CF27BB2F0E3B6")
    @Override
    protected boolean onStateChange(int[] state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state[0]);
        boolean changed = mScaleState.mDrawable.setState(state);
        onBoundsChange(getBounds());
        boolean var8977DFAC2F8E04CB96E66882235F5ABA_1300718566 = (changed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1330495452 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1330495452;
        // ---------- Original Method ----------
        //boolean changed = mScaleState.mDrawable.setState(state);
        //onBoundsChange(getBounds());
        //return changed;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.549 -0400", hash_original_method = "60A547B14486DD6AB0D2DFD460195C57", hash_generated_method = "950E87AD410CF90CBFAA109EBB2F7680")
    @Override
    protected boolean onLevelChange(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(level);
        mScaleState.mDrawable.setLevel(level);
        onBoundsChange(getBounds());
        invalidateSelf();
        boolean varB326B5062B2F0E69046810717534CB09_1020519018 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1316476086 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1316476086;
        // ---------- Original Method ----------
        //mScaleState.mDrawable.setLevel(level);
        //onBoundsChange(getBounds());
        //invalidateSelf();
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.550 -0400", hash_original_method = "07137BB41A1EF8F3D963DF117D82A94E", hash_generated_method = "B138EF9D03A9065564B47DC104C3B65D")
    @Override
    protected void onBoundsChange(Rect bounds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(bounds.getTaint());
        final Rect r = mTmpRect;
        final boolean min = mScaleState.mUseIntrinsicSizeAsMin;
        int level = getLevel();
        int w = bounds.width();
        if(mScaleState.mScaleWidth > 0)        
        {
            final int iw = min ? mScaleState.mDrawable.getIntrinsicWidth() : 0;
            w -= (int) ((w - iw) * (10000 - level) * mScaleState.mScaleWidth / 10000);
        } //End block
        int h = bounds.height();
        if(mScaleState.mScaleHeight > 0)        
        {
            final int ih = min ? mScaleState.mDrawable.getIntrinsicHeight() : 0;
            h -= (int) ((h - ih) * (10000 - level) * mScaleState.mScaleHeight / 10000);
        } //End block
        final int layoutDirection = getResolvedLayoutDirectionSelf();
        Gravity.apply(mScaleState.mGravity, w, h, bounds, r, layoutDirection);
        if(w > 0 && h > 0)        
        {
            mScaleState.mDrawable.setBounds(r.left, r.top, r.right, r.bottom);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.551 -0400", hash_original_method = "707D1CC9562C9896640A756558D656DB", hash_generated_method = "3F876A5160B9343051B9DF04B1393C92")
    @Override
    public int getIntrinsicWidth() {
        int var16FA6C99FB0009CAD04C03746695D164_1456276452 = (mScaleState.mDrawable.getIntrinsicWidth());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1934867684 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1934867684;
        // ---------- Original Method ----------
        //return mScaleState.mDrawable.getIntrinsicWidth();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.551 -0400", hash_original_method = "974D81B98CAEE5C460DF640DA8AD364B", hash_generated_method = "93C16DAE2F1F5505799BBBB99647A2EE")
    @Override
    public int getIntrinsicHeight() {
        int varC29B3DB03CDFFDA20C9C6196C2C02D25_1813720644 = (mScaleState.mDrawable.getIntrinsicHeight());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2051784353 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2051784353;
        // ---------- Original Method ----------
        //return mScaleState.mDrawable.getIntrinsicHeight();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.552 -0400", hash_original_method = "F60FC330EC8290C7F4098E941B339581", hash_generated_method = "B66BDCE15A0B48EE1E6C299F398AD33B")
    @Override
    public ConstantState getConstantState() {
        if(mScaleState.canConstantState())        
        {
            mScaleState.mChangingConfigurations = getChangingConfigurations();
ConstantState var3E5B86D1E276DAAD0E76092A725F5FD6_2037806735 =             mScaleState;
            var3E5B86D1E276DAAD0E76092A725F5FD6_2037806735.addTaint(taint);
            return var3E5B86D1E276DAAD0E76092A725F5FD6_2037806735;
        } //End block
ConstantState var540C13E9E156B687226421B24F2DF178_1217313379 =         null;
        var540C13E9E156B687226421B24F2DF178_1217313379.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1217313379;
        // ---------- Original Method ----------
        //if (mScaleState.canConstantState()) {
            //mScaleState.mChangingConfigurations = getChangingConfigurations();
            //return mScaleState;
        //}
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.553 -0400", hash_original_method = "9ABDABB0B6579EA1F785C22EF86AAE91", hash_generated_method = "5A5125E0CF8D287C73605A4B4F453C6E")
    @Override
    public Drawable mutate() {
        if(!mMutated && super.mutate() == this)        
        {
            mScaleState.mDrawable.mutate();
            mMutated = true;
        } //End block
Drawable var72A74007B2BE62B849F475C7BDA4658B_928111769 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_928111769.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_928111769;
        // ---------- Original Method ----------
        //if (!mMutated && super.mutate() == this) {
            //mScaleState.mDrawable.mutate();
            //mMutated = true;
        //}
        //return this;
    }

    
    final static class ScaleState extends ConstantState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.554 -0400", hash_original_field = "D548B27C6AC66A9D9B5D05ED35C2D844", hash_generated_field = "38BA53DD394F85639C99ED8E666FF8FB")

        Drawable mDrawable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.554 -0400", hash_original_field = "276E0645C4E2084773D0EB8C5576428C", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.554 -0400", hash_original_field = "CD273D700DE8BE19C70F514281E9F484", hash_generated_field = "BE62C65ADB73C09453C986440B687A2B")

        float mScaleWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.554 -0400", hash_original_field = "B7DF5EF785A593829B5CF83A707A45D2", hash_generated_field = "34CDE4EA9566E05D3D0D966D1D0818AB")

        float mScaleHeight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.554 -0400", hash_original_field = "1DE05384A4316AFED99BFDA3AA41DEF9", hash_generated_field = "E8D24DE70DE8CB945622B4CE486A90EA")

        int mGravity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.554 -0400", hash_original_field = "F9EF06587AEDB2DA6BE03CDD584CD1BE", hash_generated_field = "28A7B0326EF7D610D5240DD7AC8F8125")

        boolean mUseIntrinsicSizeAsMin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.554 -0400", hash_original_field = "2E319D4D352B34E33CF19129B7212FC6", hash_generated_field = "63D49323436A33301C0DA6EDF88627FF")

        private boolean mCheckedConstantState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.554 -0400", hash_original_field = "7C8FD9809F31C20B8422D623B0EC0C4F", hash_generated_field = "F62F8D22C4EDE8B8E63C376677BD915C")

        private boolean mCanConstantState;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.556 -0400", hash_original_method = "35CFE1A9959D60B5E323A5A7C20CFF5D", hash_generated_method = "1F0E44ADA2E1F1EC451539FE81DC215E")
          ScaleState(ScaleState orig, ScaleDrawable owner, Resources res) {
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
                mScaleWidth = orig.mScaleWidth;
                mScaleHeight = orig.mScaleHeight;
                mGravity = orig.mGravity;
                mUseIntrinsicSizeAsMin = orig.mUseIntrinsicSizeAsMin;
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
                //mScaleWidth = orig.mScaleWidth;
                //mScaleHeight = orig.mScaleHeight;
                //mGravity = orig.mGravity;
                //mUseIntrinsicSizeAsMin = orig.mUseIntrinsicSizeAsMin;
                //mCheckedConstantState = mCanConstantState = true;
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.557 -0400", hash_original_method = "5066D62B21872517357C79E834FBAD6A", hash_generated_method = "25378B3BB1B033D38F5743922C64ACA6")
        @Override
        public Drawable newDrawable() {
Drawable var2C21DE3522801F86BBEE2563339154A6_191775245 =             new ScaleDrawable(this, null);
            var2C21DE3522801F86BBEE2563339154A6_191775245.addTaint(taint);
            return var2C21DE3522801F86BBEE2563339154A6_191775245;
            // ---------- Original Method ----------
            //return new ScaleDrawable(this, null);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.557 -0400", hash_original_method = "449170E73BA9730DCC0B8E2FFEB867F7", hash_generated_method = "7FBA568EE64622B3B3C00A532F08295B")
        @Override
        public Drawable newDrawable(Resources res) {
            addTaint(res.getTaint());
Drawable var82A4E78F82249DE721665224C03FCFD2_1641439021 =             new ScaleDrawable(this, res);
            var82A4E78F82249DE721665224C03FCFD2_1641439021.addTaint(taint);
            return var82A4E78F82249DE721665224C03FCFD2_1641439021;
            // ---------- Original Method ----------
            //return new ScaleDrawable(this, res);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.558 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "B5D1DC88EA7BBC985FB66EC957F145F7")
        @Override
        public int getChangingConfigurations() {
            int var276E0645C4E2084773D0EB8C5576428C_1081601048 = (mChangingConfigurations);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_715929222 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_715929222;
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.559 -0400", hash_original_method = "8D2A3A495FE794F654E28C73CF35A2A1", hash_generated_method = "24CF83496E917B4FDEDD95E08B0F9C89")
         boolean canConstantState() {
            if(!mCheckedConstantState)            
            {
                mCanConstantState = mDrawable.getConstantState() != null;
                mCheckedConstantState = true;
            } //End block
            boolean var7C8FD9809F31C20B8422D623B0EC0C4F_1760594185 = (mCanConstantState);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_446083250 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_446083250;
            // ---------- Original Method ----------
            //if (!mCheckedConstantState) {
                //mCanConstantState = mDrawable.getConstantState() != null;
                //mCheckedConstantState = true;
            //}
            //return mCanConstantState;
        }

        
    }


    
}

