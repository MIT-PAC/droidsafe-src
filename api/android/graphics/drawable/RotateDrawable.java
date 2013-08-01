package android.graphics.drawable;

// Droidsafe Imports
import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class RotateDrawable extends Drawable implements Drawable.Callback {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.449 -0400", hash_original_field = "48A902C1D749B47EBC75C77370D5A1F0", hash_generated_field = "6525A0317A729C6A21603F930B262102")

    private RotateState mState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.450 -0400", hash_original_field = "9FB80C30383848C8D006680B5F3BDAF9", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.450 -0400", hash_original_method = "D68BBF88E63BC402EDEA5DC6DCE17035", hash_generated_method = "11900DAE62AC2CC48BD0D9D71B368CB1")
    public  RotateDrawable() {
        this(null, null);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.450 -0400", hash_original_method = "995C0E9A95F93D2E12F98717831D2FCB", hash_generated_method = "DDDE6149D3CE02B80BFFE97CEC56A3B9")
    private  RotateDrawable(RotateState rotateState, Resources res) {
        mState = new RotateState(rotateState, this, res);
        // ---------- Original Method ----------
        //mState = new RotateState(rotateState, this, res);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.451 -0400", hash_original_method = "66E42D309847A2E591E14284403E0AD8", hash_generated_method = "E35A483B1FFB71CA229A05BEF1AD1B1F")
    public void draw(Canvas canvas) {
        addTaint(canvas.getTaint());
        int saveCount = canvas.save();
        Rect bounds = mState.mDrawable.getBounds();
        int w = bounds.right - bounds.left;
        int h = bounds.bottom - bounds.top;
        final RotateState st = mState;
        float px = st.mPivotXRel ? (w * st.mPivotX) : st.mPivotX;
        float py = st.mPivotYRel ? (h * st.mPivotY) : st.mPivotY;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.453 -0400", hash_original_method = "CE08CCF44A5C011BE03C2CE7D256555D", hash_generated_method = "629150F29F4DB469D974DE4B9FC8A364")
    public Drawable getDrawable() {
Drawable varF9B456849C7B5DD9BFF89D3152C1C062_964373471 =         mState.mDrawable;
        varF9B456849C7B5DD9BFF89D3152C1C062_964373471.addTaint(taint);
        return varF9B456849C7B5DD9BFF89D3152C1C062_964373471;
        // ---------- Original Method ----------
        //return mState.mDrawable;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.453 -0400", hash_original_method = "1BF1269A7F11A078222AE5900C6EC170", hash_generated_method = "9C6A9EDBBC43138BE9B9AA6CB8BF91BB")
    @Override
    public int getChangingConfigurations() {
        int varCA8871A6EDE3F4B0D8A4B17E69E2053A_55039543 = (super.getChangingConfigurations()
                | mState.mChangingConfigurations
                | mState.mDrawable.getChangingConfigurations());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2108684485 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2108684485;
        // ---------- Original Method ----------
        //return super.getChangingConfigurations()
                //| mState.mChangingConfigurations
                //| mState.mDrawable.getChangingConfigurations();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.454 -0400", hash_original_method = "E07BF10440452C45B5D504184A6B58C8", hash_generated_method = "9AC6547287E2C3641B3198A761995499")
    public void setAlpha(int alpha) {
        addTaint(alpha);
        mState.mDrawable.setAlpha(alpha);
        // ---------- Original Method ----------
        //mState.mDrawable.setAlpha(alpha);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.455 -0400", hash_original_method = "6C570D1758B788EA390E83E99A76EB36", hash_generated_method = "15769D2690E62236B15065F92420CC65")
    public void setColorFilter(ColorFilter cf) {
        addTaint(cf.getTaint());
        mState.mDrawable.setColorFilter(cf);
        // ---------- Original Method ----------
        //mState.mDrawable.setColorFilter(cf);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.455 -0400", hash_original_method = "7CC935EC38A8A9ED900F61C0DE237712", hash_generated_method = "D1CAF229B4E8D64C70824D68D0F142B5")
    public int getOpacity() {
        int var161C5DA78E90AA18FD3124A4BA1D9E8F_1577323618 = (mState.mDrawable.getOpacity());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_707978172 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_707978172;
        // ---------- Original Method ----------
        //return mState.mDrawable.getOpacity();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.455 -0400", hash_original_method = "289E4B14FC4BAEE8FBED5C03A1D9B634", hash_generated_method = "41CEDEB5E33EFE6B1A6A0CCC10DBF093")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.456 -0400", hash_original_method = "A01CAF97CFFAA14450A9600E14E88C8D", hash_generated_method = "7093C805993ACF54047727682755EE99")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.457 -0400", hash_original_method = "CA144C86313E3C1A3DC044F014305D8E", hash_generated_method = "FFEE17E462526EA539C05FAA6C36C1E2")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.457 -0400", hash_original_method = "02BC41BDC3ED3CF2C30379FA10185DFA", hash_generated_method = "E2B851DDBF74B593F2FE9AB69E94BF67")
    @Override
    public boolean getPadding(Rect padding) {
        addTaint(padding.getTaint());
        boolean varF707B1D7F228AD4D878139788C1C8F59_407156958 = (mState.mDrawable.getPadding(padding));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1693283523 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1693283523;
        // ---------- Original Method ----------
        //return mState.mDrawable.getPadding(padding);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.458 -0400", hash_original_method = "BD39509C4CE6111239623166AC9A09DC", hash_generated_method = "278CEB67D18D9DD3B4770345BA0A1955")
    @Override
    public boolean setVisible(boolean visible, boolean restart) {
        addTaint(restart);
        addTaint(visible);
        mState.mDrawable.setVisible(visible, restart);
        boolean varDDF69A03BCD0C3664F5E7921DE2D1E4B_777060009 = (super.setVisible(visible, restart));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_825695905 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_825695905;
        // ---------- Original Method ----------
        //mState.mDrawable.setVisible(visible, restart);
        //return super.setVisible(visible, restart);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.459 -0400", hash_original_method = "6F66CB18BCF39D7C34F81BD35385E69D", hash_generated_method = "1E3D17CAF933A02A297DB88992028692")
    @Override
    public boolean isStateful() {
        boolean varE0911C7B30E7CAD8B191C4C55DB434C2_818155349 = (mState.mDrawable.isStateful());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_578842981 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_578842981;
        // ---------- Original Method ----------
        //return mState.mDrawable.isStateful();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.461 -0400", hash_original_method = "7EB4BF4364E02A64D78830D58D97433D", hash_generated_method = "C228289014BC65F621254758ED6E953E")
    @Override
    protected boolean onStateChange(int[] state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state[0]);
        boolean changed = mState.mDrawable.setState(state);
        onBoundsChange(getBounds());
        boolean var8977DFAC2F8E04CB96E66882235F5ABA_745123806 = (changed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_823359261 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_823359261;
        // ---------- Original Method ----------
        //boolean changed = mState.mDrawable.setState(state);
        //onBoundsChange(getBounds());
        //return changed;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.462 -0400", hash_original_method = "83ABEEB83DB924D066F2C024127658DA", hash_generated_method = "7F1EC773C3D31B9CD0AEC625110B305A")
    @Override
    protected boolean onLevelChange(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mState.mDrawable.setLevel(level);
        onBoundsChange(getBounds());
        mState.mCurrentDegrees = mState.mFromDegrees +
                (mState.mToDegrees - mState.mFromDegrees) *
                        ((float) level / MAX_LEVEL);
        invalidateSelf();
        boolean varB326B5062B2F0E69046810717534CB09_1852460542 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_419185984 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_419185984;
        // ---------- Original Method ----------
        //mState.mDrawable.setLevel(level);
        //onBoundsChange(getBounds());
        //mState.mCurrentDegrees = mState.mFromDegrees +
                //(mState.mToDegrees - mState.mFromDegrees) *
                        //((float) level / MAX_LEVEL);
        //invalidateSelf();
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.462 -0400", hash_original_method = "EF65F96F81169D8EC042745FACAE10FF", hash_generated_method = "2F6D48DF2D9A219EA2D7DF467D1099D8")
    @Override
    protected void onBoundsChange(Rect bounds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(bounds.getTaint());
        mState.mDrawable.setBounds(bounds.left, bounds.top,
                bounds.right, bounds.bottom);
        // ---------- Original Method ----------
        //mState.mDrawable.setBounds(bounds.left, bounds.top,
                //bounds.right, bounds.bottom);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.463 -0400", hash_original_method = "5B4218C80F47B6E11FBBAA9FF9621C9F", hash_generated_method = "B72459CE1E150E1B60BB40BE8ED571DB")
    @Override
    public int getIntrinsicWidth() {
        int var7ADDEA45D249CEE98356EBBA52B14675_1009796290 = (mState.mDrawable.getIntrinsicWidth());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_864013049 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_864013049;
        // ---------- Original Method ----------
        //return mState.mDrawable.getIntrinsicWidth();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.463 -0400", hash_original_method = "D5692643A14F3CC0D08138E7C727B99D", hash_generated_method = "F06973A3A23A28981318EEEF2DF1AA6D")
    @Override
    public int getIntrinsicHeight() {
        int varE3F3C2B9CA67A8CAF781F2B0B6453BD5_596203067 = (mState.mDrawable.getIntrinsicHeight());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1490588168 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1490588168;
        // ---------- Original Method ----------
        //return mState.mDrawable.getIntrinsicHeight();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.464 -0400", hash_original_method = "810CA52F78245136A3D7374C4FDCA32A", hash_generated_method = "C1FDFD407566408B18D479E4E3E9034A")
    @Override
    public ConstantState getConstantState() {
        if(mState.canConstantState())        
        {
            mState.mChangingConfigurations = getChangingConfigurations();
ConstantState var8B975C85F13BECB9FD4D21A5F3C8A56D_998593563 =             mState;
            var8B975C85F13BECB9FD4D21A5F3C8A56D_998593563.addTaint(taint);
            return var8B975C85F13BECB9FD4D21A5F3C8A56D_998593563;
        } //End block
ConstantState var540C13E9E156B687226421B24F2DF178_128487927 =         null;
        var540C13E9E156B687226421B24F2DF178_128487927.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_128487927;
        // ---------- Original Method ----------
        //if (mState.canConstantState()) {
            //mState.mChangingConfigurations = getChangingConfigurations();
            //return mState;
        //}
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.466 -0400", hash_original_method = "A81455DB3DC70DF6E6044DAADCB89002", hash_generated_method = "D7F8EDD8EB05C7DBDED0EB9039A00D45")
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        addTaint(attrs.getTaint());
        addTaint(parser.getTaint());
        addTaint(r.getTaint());
        TypedArray a = r.obtainAttributes(attrs,
                com.android.internal.R.styleable.RotateDrawable);
        super.inflateWithAttributes(r, parser, a,
                com.android.internal.R.styleable.RotateDrawable_visible);
        TypedValue tv = a.peekValue(com.android.internal.R.styleable.RotateDrawable_pivotX);
        boolean pivotXRel;
        float pivotX;
        if(tv == null)        
        {
            pivotXRel = true;
            pivotX = 0.5f;
        } //End block
        else
        {
            pivotXRel = tv.type == TypedValue.TYPE_FRACTION;
            pivotX = pivotXRel ? tv.getFraction(1.0f, 1.0f) : tv.getFloat();
        } //End block
        tv = a.peekValue(com.android.internal.R.styleable.RotateDrawable_pivotY);
        boolean pivotYRel;
        float pivotY;
        if(tv == null)        
        {
            pivotYRel = true;
            pivotY = 0.5f;
        } //End block
        else
        {
            pivotYRel = tv.type == TypedValue.TYPE_FRACTION;
            pivotY = pivotYRel ? tv.getFraction(1.0f, 1.0f) : tv.getFloat();
        } //End block
        float fromDegrees = a.getFloat(
                com.android.internal.R.styleable.RotateDrawable_fromDegrees, 0.0f);
        float toDegrees = a.getFloat(
                com.android.internal.R.styleable.RotateDrawable_toDegrees, 360.0f);
        int res = a.getResourceId(
                com.android.internal.R.styleable.RotateDrawable_drawable, 0);
        Drawable drawable = null;
        if(res > 0)        
        {
            drawable = r.getDrawable(res);
        } //End block
        a.recycle();
        int outerDepth = parser.getDepth();
        int type;
        while
((type = parser.next()) != XmlPullParser.END_DOCUMENT &&
               (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth))        
        {
            if(type != XmlPullParser.START_TAG)            
            {
                continue;
            } //End block
            if((drawable = Drawable.createFromXmlInner(r, parser, attrs)) == null)            
            {
            } //End block
        } //End block
        if(drawable == null)        
        {
        } //End block
        mState.mDrawable = drawable;
        mState.mPivotXRel = pivotXRel;
        mState.mPivotX = pivotX;
        mState.mPivotYRel = pivotYRel;
        mState.mPivotY = pivotY;
        mState.mFromDegrees = mState.mCurrentDegrees = fromDegrees;
        mState.mToDegrees = toDegrees;
        if(drawable != null)        
        {
            drawable.setCallback(this);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.467 -0400", hash_original_method = "1ABB3B56372A1EBF2E80045724D492E3", hash_generated_method = "572D18E804C11E8D38ED7797886C6003")
    @Override
    public Drawable mutate() {
        if(!mMutated && super.mutate() == this)        
        {
            mState.mDrawable.mutate();
            mMutated = true;
        } //End block
Drawable var72A74007B2BE62B849F475C7BDA4658B_831116189 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_831116189.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_831116189;
        // ---------- Original Method ----------
        //if (!mMutated && super.mutate() == this) {
            //mState.mDrawable.mutate();
            //mMutated = true;
        //}
        //return this;
    }

    
    final static class RotateState extends Drawable.ConstantState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.468 -0400", hash_original_field = "D548B27C6AC66A9D9B5D05ED35C2D844", hash_generated_field = "38BA53DD394F85639C99ED8E666FF8FB")

        Drawable mDrawable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.468 -0400", hash_original_field = "276E0645C4E2084773D0EB8C5576428C", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.468 -0400", hash_original_field = "7F7BDD395B2683F1C3CE6FF4D28782A1", hash_generated_field = "C85378C704A40C3EFC15605BD9C2CCB0")

        boolean mPivotXRel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.468 -0400", hash_original_field = "D66A9F2EFD98D68E75A6EA9E5E5D83DE", hash_generated_field = "5936761CCB9106C6D82A6436A57EC343")

        float mPivotX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.468 -0400", hash_original_field = "71E602433C1B915117E3827218A7F552", hash_generated_field = "4EE5D55A1588E348C8DE32B74EC377A0")

        boolean mPivotYRel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.469 -0400", hash_original_field = "0AD24014D3E582A643E83C27A45B1B51", hash_generated_field = "6CE864DEEFD86BFE91AA6D818A7F55C0")

        float mPivotY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.469 -0400", hash_original_field = "A15722F5083687A94AEBECFD3C44711E", hash_generated_field = "179D120EA21717CC6A9EB6675A09E18B")

        float mFromDegrees;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.484 -0400", hash_original_field = "F12DDB33947BE4AD8AACC9EB5D42D418", hash_generated_field = "D04BBDA5B46FF274C82326C147187C72")

        float mToDegrees;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.484 -0400", hash_original_field = "A400194F6090059653517E4AAABDEC7F", hash_generated_field = "EF0BD8ADAC303B1287CF1584E5AA1EDB")

        float mCurrentDegrees;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.484 -0400", hash_original_field = "7C8FD9809F31C20B8422D623B0EC0C4F", hash_generated_field = "F62F8D22C4EDE8B8E63C376677BD915C")

        private boolean mCanConstantState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.484 -0400", hash_original_field = "2E319D4D352B34E33CF19129B7212FC6", hash_generated_field = "63D49323436A33301C0DA6EDF88627FF")

        private boolean mCheckedConstantState;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.484 -0400", hash_original_method = "E49363C9B9277E418FC0CB021F74A645", hash_generated_method = "D93AE749A6EA00BFCB6791BCB107BC39")
        public  RotateState(RotateState source, RotateDrawable owner, Resources res) {
            addTaint(owner.getTaint());
            if(source != null)            
            {
                if(res != null)                
                {
                    mDrawable = source.mDrawable.getConstantState().newDrawable(res);
                } //End block
                else
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.485 -0400", hash_original_method = "9DE14D671D62BC2F01E2871493505073", hash_generated_method = "25DE17AEC6EC1DAA256A3154E4EF3E45")
        @Override
        public Drawable newDrawable() {
Drawable var73906AB68FE9D3B6E333C69CB0D4CD5C_526931470 =             new RotateDrawable(this, null);
            var73906AB68FE9D3B6E333C69CB0D4CD5C_526931470.addTaint(taint);
            return var73906AB68FE9D3B6E333C69CB0D4CD5C_526931470;
            // ---------- Original Method ----------
            //return new RotateDrawable(this, null);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.485 -0400", hash_original_method = "3300EE781F91D7B956F1DECE09B43C56", hash_generated_method = "90799AF38953B20F4E50B918ABF00292")
        @Override
        public Drawable newDrawable(Resources res) {
            addTaint(res.getTaint());
Drawable var08E68496273584B2BA9853DFD7C4906A_498088075 =             new RotateDrawable(this, res);
            var08E68496273584B2BA9853DFD7C4906A_498088075.addTaint(taint);
            return var08E68496273584B2BA9853DFD7C4906A_498088075;
            // ---------- Original Method ----------
            //return new RotateDrawable(this, res);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.485 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "77F4041127D0A7252C298BFC4A64BCD3")
        @Override
        public int getChangingConfigurations() {
            int var276E0645C4E2084773D0EB8C5576428C_1768084894 = (mChangingConfigurations);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1067182655 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1067182655;
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.485 -0400", hash_original_method = "8D2A3A495FE794F654E28C73CF35A2A1", hash_generated_method = "46DEEFD7667524EE8B0A6DAE656561DA")
        public boolean canConstantState() {
            if(!mCheckedConstantState)            
            {
                mCanConstantState = mDrawable.getConstantState() != null;
                mCheckedConstantState = true;
            } //End block
            boolean var7C8FD9809F31C20B8422D623B0EC0C4F_1950857644 = (mCanConstantState);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_990487250 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_990487250;
            // ---------- Original Method ----------
            //if (!mCheckedConstantState) {
                //mCanConstantState = mDrawable.getConstantState() != null;
                //mCheckedConstantState = true;
            //}
            //return mCanConstantState;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.485 -0400", hash_original_field = "DB3C5D7FA107BF253D250628420EA38F", hash_generated_field = "AF6B537CBDB90B8253BE1615E87A6B32")

    private static final float MAX_LEVEL = 10000.0f;
}

