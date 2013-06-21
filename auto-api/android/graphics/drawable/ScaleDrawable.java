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
import android.view.Gravity;
import android.util.AttributeSet;
import android.view.View;
import java.io.IOException;

public class ScaleDrawable extends Drawable implements Drawable.Callback {
    private ScaleState mScaleState;
    private boolean mMutated;
    private Rect mTmpRect = new Rect();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.596 -0400", hash_original_method = "514942F1E0299625DD7C1CF4A65C7704", hash_generated_method = "EC158C9898C13743C5AABD0B773303D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ScaleDrawable() {
        this(null, null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.597 -0400", hash_original_method = "70D37B4EA14F56A15F832FEAF48A06AB", hash_generated_method = "8DB28B29345089294D3328F267F96521")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ScaleDrawable(Drawable drawable, int gravity, float scaleWidth, float scaleHeight) {
        this(null, null);
        dsTaint.addTaint(scaleWidth);
        dsTaint.addTaint(scaleHeight);
        dsTaint.addTaint(drawable.dsTaint);
        dsTaint.addTaint(gravity);
        mScaleState.mDrawable = drawable;
        mScaleState.mGravity = gravity;
        mScaleState.mScaleWidth = scaleWidth;
        mScaleState.mScaleHeight = scaleHeight;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.597 -0400", hash_original_method = "044BA74036106E0DA1F4FE69AE9E5ADC", hash_generated_method = "C712A4C6C0FBBE8D869BA842B8C0DF5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ScaleDrawable(ScaleState state, Resources res) {
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(state.dsTaint);
        mScaleState = new ScaleState(state, this, res);
        // ---------- Original Method ----------
        //mScaleState = new ScaleState(state, this, res);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.597 -0400", hash_original_method = "AEF970ED5616036B7E8018EB225E392F", hash_generated_method = "0A1B5A8083094D452F881B17502A5C86")
    @DSModeled(DSC.SAFE)
    public Drawable getDrawable() {
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mScaleState.mDrawable;
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.598 -0400", hash_original_method = "49F4934EE2B25F6F115AF16904B4D689", hash_generated_method = "BD18AAFD4429E5B59F6FFBE14AD69F57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
        super.inflate(r, parser, attrs);
        int type;
        TypedArray a;
        a = r.obtainAttributes(attrs, com.android.internal.R.styleable.ScaleDrawable);
        float sw;
        sw = getPercent(a, com.android.internal.R.styleable.ScaleDrawable_scaleWidth);
        float sh;
        sh = getPercent(a, com.android.internal.R.styleable.ScaleDrawable_scaleHeight);
        int g;
        g = a.getInt(com.android.internal.R.styleable.ScaleDrawable_scaleGravity, Gravity.LEFT);
        boolean min;
        min = a.getBoolean(
                com.android.internal.R.styleable.ScaleDrawable_useIntrinsicSizeAsMinimum, false);
        Drawable dr;
        dr = a.getDrawable(com.android.internal.R.styleable.ScaleDrawable_drawable);
        a.recycle();
        int outerDepth;
        outerDepth = parser.getDepth();
        {
            boolean var09B6D7ADFBD75C31FC39E543D494D2B2_1602356187 = ((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth));
            {
                dr = Drawable.createFromXmlInner(r, parser, attrs);
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("No drawable specified for <scale>");
        } //End block
        mScaleState.mDrawable = dr;
        mScaleState.mScaleWidth = sw;
        mScaleState.mScaleHeight = sh;
        mScaleState.mGravity = g;
        mScaleState.mUseIntrinsicSizeAsMin = min;
        {
            dr.setCallback(this);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.598 -0400", hash_original_method = "DF6A36F8E9590497BD97E858748A70C0", hash_generated_method = "5F0D5CB6B267F30CC9E7959341B50785")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void invalidateDrawable(Drawable who) {
        dsTaint.addTaint(who.dsTaint);
        {
            boolean varB8E7F14DBE199F8ABFBF8F9EE31B80A9_1213030712 = (getCallback() != null);
            {
                getCallback().invalidateDrawable(this);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (getCallback() != null) {
            //getCallback().invalidateDrawable(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.599 -0400", hash_original_method = "18649734DD6C42C2C51CF25B20D68FBF", hash_generated_method = "4A576355B85C40B3AD6050A86DE5B09F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(when);
        dsTaint.addTaint(who.dsTaint);
        {
            boolean varB8E7F14DBE199F8ABFBF8F9EE31B80A9_927074536 = (getCallback() != null);
            {
                getCallback().scheduleDrawable(this, what, when);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (getCallback() != null) {
            //getCallback().scheduleDrawable(this, what, when);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.608 -0400", hash_original_method = "8711E8318CA3821644E7E9EDAB95B5BC", hash_generated_method = "059560CFCE1A2C5EDD67F7F666E84F5A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unscheduleDrawable(Drawable who, Runnable what) {
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(who.dsTaint);
        {
            boolean varB8E7F14DBE199F8ABFBF8F9EE31B80A9_1608290360 = (getCallback() != null);
            {
                getCallback().unscheduleDrawable(this, what);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (getCallback() != null) {
            //getCallback().unscheduleDrawable(this, what);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.611 -0400", hash_original_method = "ADD59FF7C9EB5B0D687113ACE781DE45", hash_generated_method = "D27626563DB514B004BD197CAB87A18E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void draw(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        {
            boolean var7358356BD51883D862E8E6D8E4009D07_871814133 = (mScaleState.mDrawable.getLevel() != 0);
            mScaleState.mDrawable.draw(canvas);
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mScaleState.mDrawable.getLevel() != 0)
            //mScaleState.mDrawable.draw(canvas);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.611 -0400", hash_original_method = "E88B2D3506B9FB1C95A0FECA8D5B6D9F", hash_generated_method = "0A784E48CD11D04E4B9A2A9D4F3B9166")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getChangingConfigurations() {
        int var612C20DFF67BAB9BD785BA1BD3D9443E_1581234743 = (super.getChangingConfigurations()
                | mScaleState.mChangingConfigurations
                | mScaleState.mDrawable.getChangingConfigurations());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return super.getChangingConfigurations()
                //| mScaleState.mChangingConfigurations
                //| mScaleState.mDrawable.getChangingConfigurations();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.611 -0400", hash_original_method = "2834251DB4FA1276891A806CA1B46D6D", hash_generated_method = "743149B036BA4B5EE52F2A1A0FAB320A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getPadding(Rect padding) {
        dsTaint.addTaint(padding.dsTaint);
        boolean var1532CFD2CDCF4ECD604CC172D7C7AE2D_1211418854 = (mScaleState.mDrawable.getPadding(padding));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mScaleState.mDrawable.getPadding(padding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.612 -0400", hash_original_method = "DF926DDC801D2CA5859468C5FAF6E2DB", hash_generated_method = "8F94D33A6FDD401170F5C0FC3BEBF523")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean setVisible(boolean visible, boolean restart) {
        dsTaint.addTaint(restart);
        dsTaint.addTaint(visible);
        mScaleState.mDrawable.setVisible(visible, restart);
        boolean var9D015C67047440F1849257F892B1DD1F_103381185 = (super.setVisible(visible, restart));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //mScaleState.mDrawable.setVisible(visible, restart);
        //return super.setVisible(visible, restart);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.612 -0400", hash_original_method = "A9094AF2E7BD2624EE02834D750BE346", hash_generated_method = "6062C695D7B2D930B4DF7E52E9B83D32")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setAlpha(int alpha) {
        dsTaint.addTaint(alpha);
        mScaleState.mDrawable.setAlpha(alpha);
        // ---------- Original Method ----------
        //mScaleState.mDrawable.setAlpha(alpha);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.613 -0400", hash_original_method = "2F836B47975A4E15DB5892CD09923112", hash_generated_method = "DBD39DD0834695DED6858BFFFD930390")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setColorFilter(ColorFilter cf) {
        dsTaint.addTaint(cf.dsTaint);
        mScaleState.mDrawable.setColorFilter(cf);
        // ---------- Original Method ----------
        //mScaleState.mDrawable.setColorFilter(cf);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.615 -0400", hash_original_method = "80BFCB126A2061429F3FFA03D49A8EF5", hash_generated_method = "08186781078D6FA0F47719C50602F1AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getOpacity() {
        int varF4977642C540CF84B049D0A6C04853BB_473339722 = (mScaleState.mDrawable.getOpacity());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mScaleState.mDrawable.getOpacity();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.615 -0400", hash_original_method = "0B20FD6DAF06E7B53C037B30AA0A67FB", hash_generated_method = "148483FE06CD9401321668A789468BE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isStateful() {
        boolean var737BE650B153F47A71DDD22A0760476E_1470859037 = (mScaleState.mDrawable.isStateful());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mScaleState.mDrawable.isStateful();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.616 -0400", hash_original_method = "53615D161AB187EDCCE7BACA4EBD5437", hash_generated_method = "4D492E6710A0B741310F525BFC9107B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean onStateChange(int[] state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(state[0]);
        boolean changed;
        changed = mScaleState.mDrawable.setState(state);
        onBoundsChange(getBounds());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean changed = mScaleState.mDrawable.setState(state);
        //onBoundsChange(getBounds());
        //return changed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.616 -0400", hash_original_method = "60A547B14486DD6AB0D2DFD460195C57", hash_generated_method = "83316763FD0C86780A280FC4F31BECEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean onLevelChange(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(level);
        mScaleState.mDrawable.setLevel(level);
        onBoundsChange(getBounds());
        invalidateSelf();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //mScaleState.mDrawable.setLevel(level);
        //onBoundsChange(getBounds());
        //invalidateSelf();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.617 -0400", hash_original_method = "07137BB41A1EF8F3D963DF117D82A94E", hash_generated_method = "0448922811A31B890211DCEA40DB97DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onBoundsChange(Rect bounds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(bounds.dsTaint);
        Rect r;
        r = mTmpRect;
        boolean min;
        min = mScaleState.mUseIntrinsicSizeAsMin;
        int level;
        level = getLevel();
        int w;
        w = bounds.width();
        {
            int iw;
            iw = mScaleState.mDrawable.getIntrinsicWidth();
            iw = 0;
            w -= (int) ((w - iw) * (10000 - level) * mScaleState.mScaleWidth / 10000);
        } //End block
        int h;
        h = bounds.height();
        {
            int ih;
            ih = mScaleState.mDrawable.getIntrinsicHeight();
            ih = 0;
            h -= (int) ((h - ih) * (10000 - level) * mScaleState.mScaleHeight / 10000);
        } //End block
        int layoutDirection;
        layoutDirection = getResolvedLayoutDirectionSelf();
        Gravity.apply(mScaleState.mGravity, w, h, bounds, r, layoutDirection);
        {
            mScaleState.mDrawable.setBounds(r.left, r.top, r.right, r.bottom);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.617 -0400", hash_original_method = "707D1CC9562C9896640A756558D656DB", hash_generated_method = "88F0B5495CB5134D2BF41DFFC5E6E4F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getIntrinsicWidth() {
        int var7D4BA5BA8C669B0C5F882713B5CD9F2F_2046431130 = (mScaleState.mDrawable.getIntrinsicWidth());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mScaleState.mDrawable.getIntrinsicWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.617 -0400", hash_original_method = "974D81B98CAEE5C460DF640DA8AD364B", hash_generated_method = "8FD9B813C01DE560D0AA41053899D01D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getIntrinsicHeight() {
        int var648D37C654A92FDAC5B6A248AE646274_756536072 = (mScaleState.mDrawable.getIntrinsicHeight());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mScaleState.mDrawable.getIntrinsicHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.618 -0400", hash_original_method = "F60FC330EC8290C7F4098E941B339581", hash_generated_method = "3C3ED6712B78BBB405CE72F5A112700E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ConstantState getConstantState() {
        {
            boolean var2E18AB2C604DBA57BAF25385D4A8DA81_81827932 = (mScaleState.canConstantState());
            {
                mScaleState.mChangingConfigurations = getChangingConfigurations();
            } //End block
        } //End collapsed parenthetic
        return (ConstantState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mScaleState.canConstantState()) {
            //mScaleState.mChangingConfigurations = getChangingConfigurations();
            //return mScaleState;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.618 -0400", hash_original_method = "9ABDABB0B6579EA1F785C22EF86AAE91", hash_generated_method = "D2423ACDA15E88DECF776A3FA471ABA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Drawable mutate() {
        {
            boolean varC94B19053599294E7944C8C841976773_942877847 = (!mMutated && super.mutate() == this);
            {
                mScaleState.mDrawable.mutate();
                mMutated = true;
            } //End block
        } //End collapsed parenthetic
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!mMutated && super.mutate() == this) {
            //mScaleState.mDrawable.mutate();
            //mMutated = true;
        //}
        //return this;
    }

    
    final static class ScaleState extends ConstantState {
        Drawable mDrawable;
        int mChangingConfigurations;
        float mScaleWidth;
        float mScaleHeight;
        int mGravity;
        boolean mUseIntrinsicSizeAsMin;
        private boolean mCheckedConstantState;
        private boolean mCanConstantState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.618 -0400", hash_original_method = "35CFE1A9959D60B5E323A5A7C20CFF5D", hash_generated_method = "6D5F214A17510B3DF563E4A160765F47")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         ScaleState(ScaleState orig, ScaleDrawable owner, Resources res) {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.619 -0400", hash_original_method = "5066D62B21872517357C79E834FBAD6A", hash_generated_method = "51D5CE860572C3A166AC985ADC31B455")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Drawable newDrawable() {
            Drawable var1034114D504B253CC99741E23B1CC8D7_19443678 = (new ScaleDrawable(this, null));
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ScaleDrawable(this, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.620 -0400", hash_original_method = "449170E73BA9730DCC0B8E2FFEB867F7", hash_generated_method = "B6C0018940AFB0B440CEAF1597759F76")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Drawable newDrawable(Resources res) {
            dsTaint.addTaint(res.dsTaint);
            Drawable var8C0894105C8175D977CA8E6B1F1A826A_145184715 = (new ScaleDrawable(this, res));
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ScaleDrawable(this, res);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.621 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "36011B0CFA5B1C48E438EB66BB35159E")
        @DSModeled(DSC.SAFE)
        @Override
        public int getChangingConfigurations() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.621 -0400", hash_original_method = "8D2A3A495FE794F654E28C73CF35A2A1", hash_generated_method = "91841D4C432CEA46787D356B5812EFCD")
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

