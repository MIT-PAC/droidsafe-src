package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.util.AttributeSet;
import android.util.Log;
import java.io.IOException;

public class RotateDrawable extends Drawable implements Drawable.Callback {
    private RotateState mState;
    private boolean mMutated;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.561 -0400", hash_original_method = "D68BBF88E63BC402EDEA5DC6DCE17035", hash_generated_method = "11900DAE62AC2CC48BD0D9D71B368CB1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RotateDrawable() {
        this(null, null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.562 -0400", hash_original_method = "995C0E9A95F93D2E12F98717831D2FCB", hash_generated_method = "88B71FB7273750EA5A96AA16EFF7DC4B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private RotateDrawable(RotateState rotateState, Resources res) {
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(rotateState.dsTaint);
        mState = new RotateState(rotateState, this, res);
        // ---------- Original Method ----------
        //mState = new RotateState(rotateState, this, res);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.562 -0400", hash_original_method = "66E42D309847A2E591E14284403E0AD8", hash_generated_method = "253C932B8F34D7B6238264E69EC4EB49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void draw(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        int saveCount;
        saveCount = canvas.save();
        Rect bounds;
        bounds = mState.mDrawable.getBounds();
        int w;
        w = bounds.right - bounds.left;
        int h;
        h = bounds.bottom - bounds.top;
        RotateState st;
        st = mState;
        float px;
        px = (w * st.mPivotX);
        px = st.mPivotX;
        float py;
        py = (h * st.mPivotY);
        py = st.mPivotY;
        canvas.rotate(st.mCurrentDegrees, px + bounds.left, py + bounds.top);
        st.mDrawable.draw(canvas);
        canvas.restoreToCount(saveCount);
        // ---------- Original Method ----------
        //int saveCount = canvas.save();
        //Rect bounds = mState.mDrawable.getBounds();
        //int w = bounds.right - bounds.left;
        //int h = bounds.bottom - bounds.top;
        //final RotateState st = mState;
        //float px = st.mPivotXRel ? (w * st.mPivotX) : st.mPivotX;
        //float py = st.mPivotYRel ? (h * st.mPivotY) : st.mPivotY;
        //canvas.rotate(st.mCurrentDegrees, px + bounds.left, py + bounds.top);
        //st.mDrawable.draw(canvas);
        //canvas.restoreToCount(saveCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.562 -0400", hash_original_method = "CE08CCF44A5C011BE03C2CE7D256555D", hash_generated_method = "8937045A2757750A4D2A8CD50836C56C")
    @DSModeled(DSC.SAFE)
    public Drawable getDrawable() {
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mState.mDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.563 -0400", hash_original_method = "1BF1269A7F11A078222AE5900C6EC170", hash_generated_method = "7F17D3A39B23133A83CAF34E690A2C23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getChangingConfigurations() {
        int var0FF1530E46268DA64EFCE0D0E400E8C4_263162549 = (super.getChangingConfigurations()
                | mState.mChangingConfigurations
                | mState.mDrawable.getChangingConfigurations());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return super.getChangingConfigurations()
                //| mState.mChangingConfigurations
                //| mState.mDrawable.getChangingConfigurations();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.563 -0400", hash_original_method = "E07BF10440452C45B5D504184A6B58C8", hash_generated_method = "9668A1B6D938CAFB31F9D60D64DFE637")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAlpha(int alpha) {
        dsTaint.addTaint(alpha);
        mState.mDrawable.setAlpha(alpha);
        // ---------- Original Method ----------
        //mState.mDrawable.setAlpha(alpha);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.563 -0400", hash_original_method = "6C570D1758B788EA390E83E99A76EB36", hash_generated_method = "12F58E67CB08B530512F9A3499C0C284")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setColorFilter(ColorFilter cf) {
        dsTaint.addTaint(cf.dsTaint);
        mState.mDrawable.setColorFilter(cf);
        // ---------- Original Method ----------
        //mState.mDrawable.setColorFilter(cf);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.563 -0400", hash_original_method = "7CC935EC38A8A9ED900F61C0DE237712", hash_generated_method = "F4520BCDD526C35ADE32D09F380CC855")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getOpacity() {
        int var208671101B6F4CE4F7912D03727B9ECD_247830094 = (mState.mDrawable.getOpacity());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mState.mDrawable.getOpacity();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.564 -0400", hash_original_method = "289E4B14FC4BAEE8FBED5C03A1D9B634", hash_generated_method = "41CFE1796930DCF2EA1C09782362A302")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.564 -0400", hash_original_method = "A01CAF97CFFAA14450A9600E14E88C8D", hash_generated_method = "5E91FE06A500769A5C043EEFE8B10766")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.564 -0400", hash_original_method = "CA144C86313E3C1A3DC044F014305D8E", hash_generated_method = "E7D6D2791C5354C92F65E1B2A3B561B5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.565 -0400", hash_original_method = "02BC41BDC3ED3CF2C30379FA10185DFA", hash_generated_method = "4FCD64F46BBB14BDD88087EB1F4E5D3C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getPadding(Rect padding) {
        dsTaint.addTaint(padding.dsTaint);
        boolean varC7A533DDD324CE8744300E8FF1B02882_1479323621 = (mState.mDrawable.getPadding(padding));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mState.mDrawable.getPadding(padding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.565 -0400", hash_original_method = "BD39509C4CE6111239623166AC9A09DC", hash_generated_method = "88B76AC0369A7A330450E01210DC5E94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean setVisible(boolean visible, boolean restart) {
        dsTaint.addTaint(restart);
        dsTaint.addTaint(visible);
        mState.mDrawable.setVisible(visible, restart);
        boolean var9D015C67047440F1849257F892B1DD1F_941202950 = (super.setVisible(visible, restart));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //mState.mDrawable.setVisible(visible, restart);
        //return super.setVisible(visible, restart);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.565 -0400", hash_original_method = "6F66CB18BCF39D7C34F81BD35385E69D", hash_generated_method = "A7CE9C461E1E92B5C52F1BE820D5C652")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isStateful() {
        boolean var49A6E47C93BCE92CD66848492C5DEB16_1954233653 = (mState.mDrawable.isStateful());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mState.mDrawable.isStateful();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.565 -0400", hash_original_method = "7EB4BF4364E02A64D78830D58D97433D", hash_generated_method = "8C1245CE06C1815E1052E2B4271DE005")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean onStateChange(int[] state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(state[0]);
        boolean changed;
        changed = mState.mDrawable.setState(state);
        onBoundsChange(getBounds());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean changed = mState.mDrawable.setState(state);
        //onBoundsChange(getBounds());
        //return changed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.566 -0400", hash_original_method = "83ABEEB83DB924D066F2C024127658DA", hash_generated_method = "CC5AE66F8BB7483DD8A3FE1016435462")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean onLevelChange(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(level);
        mState.mDrawable.setLevel(level);
        onBoundsChange(getBounds());
        mState.mCurrentDegrees = mState.mFromDegrees +
                (mState.mToDegrees - mState.mFromDegrees) *
                        ((float) level / MAX_LEVEL);
        invalidateSelf();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //mState.mDrawable.setLevel(level);
        //onBoundsChange(getBounds());
        //mState.mCurrentDegrees = mState.mFromDegrees +
                //(mState.mToDegrees - mState.mFromDegrees) *
                        //((float) level / MAX_LEVEL);
        //invalidateSelf();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.566 -0400", hash_original_method = "EF65F96F81169D8EC042745FACAE10FF", hash_generated_method = "74FAAF9EEB0BDB2752E58AD57B2CDB19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onBoundsChange(Rect bounds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(bounds.dsTaint);
        mState.mDrawable.setBounds(bounds.left, bounds.top,
                bounds.right, bounds.bottom);
        // ---------- Original Method ----------
        //mState.mDrawable.setBounds(bounds.left, bounds.top,
                //bounds.right, bounds.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.566 -0400", hash_original_method = "5B4218C80F47B6E11FBBAA9FF9621C9F", hash_generated_method = "3C3E8C9EF6951DFFEFA5C58DD2401FC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getIntrinsicWidth() {
        int varF0E785BE9442695B8C554DDF53D66DF4_1009867902 = (mState.mDrawable.getIntrinsicWidth());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mState.mDrawable.getIntrinsicWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.567 -0400", hash_original_method = "D5692643A14F3CC0D08138E7C727B99D", hash_generated_method = "9B73AED0037DE25324AC9BA7C29160FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getIntrinsicHeight() {
        int var740C212F7282B7300448D928B6215BB6_1045199437 = (mState.mDrawable.getIntrinsicHeight());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mState.mDrawable.getIntrinsicHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.567 -0400", hash_original_method = "810CA52F78245136A3D7374C4FDCA32A", hash_generated_method = "C7DE31EF62ED88C1F7FDDAEEFACD99EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ConstantState getConstantState() {
        {
            boolean var80BE086B3CF987C8B4EA155D5304638A_570776894 = (mState.canConstantState());
            {
                mState.mChangingConfigurations = getChangingConfigurations();
            } //End block
        } //End collapsed parenthetic
        return (ConstantState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mState.canConstantState()) {
            //mState.mChangingConfigurations = getChangingConfigurations();
            //return mState;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.568 -0400", hash_original_method = "A81455DB3DC70DF6E6044DAADCB89002", hash_generated_method = "135F975A4F8A045494AA3FFC1F7BBEB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
        TypedArray a;
        a = r.obtainAttributes(attrs,
                com.android.internal.R.styleable.RotateDrawable);
        super.inflateWithAttributes(r, parser, a,
                com.android.internal.R.styleable.RotateDrawable_visible);
        TypedValue tv;
        tv = a.peekValue(com.android.internal.R.styleable.RotateDrawable_pivotX);
        boolean pivotXRel;
        float pivotX;
        {
            pivotXRel = true;
            pivotX = 0.5f;
        } //End block
        {
            pivotXRel = tv.type == TypedValue.TYPE_FRACTION;
            pivotX = pivotXRel ? tv.getFraction(1.0f, 1.0f) : tv.getFloat();
        } //End block
        tv = a.peekValue(com.android.internal.R.styleable.RotateDrawable_pivotY);
        boolean pivotYRel;
        float pivotY;
        {
            pivotYRel = true;
            pivotY = 0.5f;
        } //End block
        {
            pivotYRel = tv.type == TypedValue.TYPE_FRACTION;
            pivotY = pivotYRel ? tv.getFraction(1.0f, 1.0f) : tv.getFloat();
        } //End block
        float fromDegrees;
        fromDegrees = a.getFloat(
                com.android.internal.R.styleable.RotateDrawable_fromDegrees, 0.0f);
        float toDegrees;
        toDegrees = a.getFloat(
                com.android.internal.R.styleable.RotateDrawable_toDegrees, 360.0f);
        int res;
        res = a.getResourceId(
                com.android.internal.R.styleable.RotateDrawable_drawable, 0);
        Drawable drawable;
        drawable = null;
        {
            drawable = r.getDrawable(res);
        } //End block
        a.recycle();
        int outerDepth;
        outerDepth = parser.getDepth();
        int type;
        {
            boolean varC141F9598534BC349F58FDDEEA6C1DB7_843549036 = ((type = parser.next()) != XmlPullParser.END_DOCUMENT &&
               (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth));
            {
                {
                    boolean var24A02A5F6DE110121BAFDE44AC7A8F0C_1180487438 = ((drawable = Drawable.createFromXmlInner(r, parser, attrs)) == null);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        mState.mDrawable = drawable;
        mState.mPivotXRel = pivotXRel;
        mState.mPivotX = pivotX;
        mState.mPivotYRel = pivotYRel;
        mState.mPivotY = pivotY;
        mState.mFromDegrees = mState.mCurrentDegrees = fromDegrees;
        mState.mToDegrees = toDegrees;
        {
            drawable.setCallback(this);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.568 -0400", hash_original_method = "1ABB3B56372A1EBF2E80045724D492E3", hash_generated_method = "58374907E02E564BD37CD5FDAEC7797E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Drawable mutate() {
        {
            boolean varC94B19053599294E7944C8C841976773_1762080078 = (!mMutated && super.mutate() == this);
            {
                mState.mDrawable.mutate();
                mMutated = true;
            } //End block
        } //End collapsed parenthetic
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!mMutated && super.mutate() == this) {
            //mState.mDrawable.mutate();
            //mMutated = true;
        //}
        //return this;
    }

    
    final static class RotateState extends Drawable.ConstantState {
        Drawable mDrawable;
        int mChangingConfigurations;
        boolean mPivotXRel;
        float mPivotX;
        boolean mPivotYRel;
        float mPivotY;
        float mFromDegrees;
        float mToDegrees;
        float mCurrentDegrees;
        private boolean mCanConstantState;
        private boolean mCheckedConstantState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.569 -0400", hash_original_method = "E49363C9B9277E418FC0CB021F74A645", hash_generated_method = "D76F293EFEA0718F2F68721828D2EC29")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public RotateState(RotateState source, RotateDrawable owner, Resources res) {
            dsTaint.addTaint(res.dsTaint);
            dsTaint.addTaint(source.dsTaint);
            dsTaint.addTaint(owner.dsTaint);
            {
                {
                    mDrawable = source.mDrawable.getConstantState().newDrawable(res);
                } //End block
                {
                    mDrawable = source.mDrawable.getConstantState().newDrawable();
                } //End block
                mDrawable.setCallback(owner);
                mPivotXRel = source.mPivotXRel;
                mPivotX = source.mPivotX;
                mPivotYRel = source.mPivotYRel;
                mPivotY = source.mPivotY;
                mFromDegrees = mCurrentDegrees = source.mFromDegrees;
                mToDegrees = source.mToDegrees;
                mCanConstantState = mCheckedConstantState = true;
            } //End block
            // ---------- Original Method ----------
            //if (source != null) {
                //if (res != null) {
                    //mDrawable = source.mDrawable.getConstantState().newDrawable(res);
                //} else {
                    //mDrawable = source.mDrawable.getConstantState().newDrawable();
                //}
                //mDrawable.setCallback(owner);
                //mPivotXRel = source.mPivotXRel;
                //mPivotX = source.mPivotX;
                //mPivotYRel = source.mPivotYRel;
                //mPivotY = source.mPivotY;
                //mFromDegrees = mCurrentDegrees = source.mFromDegrees;
                //mToDegrees = source.mToDegrees;
                //mCanConstantState = mCheckedConstantState = true;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.578 -0400", hash_original_method = "9DE14D671D62BC2F01E2871493505073", hash_generated_method = "8E767A5B828D8C1BA487A9DAF4CED246")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Drawable newDrawable() {
            Drawable var877210F356637B5B31B1E10863D074A1_851935801 = (new RotateDrawable(this, null));
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new RotateDrawable(this, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.578 -0400", hash_original_method = "3300EE781F91D7B956F1DECE09B43C56", hash_generated_method = "41796BFB80D3AB7B91657122F3877376")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Drawable newDrawable(Resources res) {
            dsTaint.addTaint(res.dsTaint);
            Drawable var123558B1F8C15FD50DA9F22ABBDFF7A0_130991844 = (new RotateDrawable(this, res));
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new RotateDrawable(this, res);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.578 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "36011B0CFA5B1C48E438EB66BB35159E")
        @DSModeled(DSC.SAFE)
        @Override
        public int getChangingConfigurations() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.579 -0400", hash_original_method = "8D2A3A495FE794F654E28C73CF35A2A1", hash_generated_method = "1AD508279EAAB1244D7009C92E2EC800")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean canConstantState() {
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


    
    private static final float MAX_LEVEL = 10000.0f;
}

