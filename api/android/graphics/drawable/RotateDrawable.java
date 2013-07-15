package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.634 -0400", hash_original_field = "48A902C1D749B47EBC75C77370D5A1F0", hash_generated_field = "6525A0317A729C6A21603F930B262102")

    private RotateState mState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.634 -0400", hash_original_field = "9FB80C30383848C8D006680B5F3BDAF9", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.634 -0400", hash_original_method = "D68BBF88E63BC402EDEA5DC6DCE17035", hash_generated_method = "11900DAE62AC2CC48BD0D9D71B368CB1")
    public  RotateDrawable() {
        this(null, null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.635 -0400", hash_original_method = "995C0E9A95F93D2E12F98717831D2FCB", hash_generated_method = "DDDE6149D3CE02B80BFFE97CEC56A3B9")
    private  RotateDrawable(RotateState rotateState, Resources res) {
        mState = new RotateState(rotateState, this, res);
        // ---------- Original Method ----------
        //mState = new RotateState(rotateState, this, res);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.636 -0400", hash_original_method = "66E42D309847A2E591E14284403E0AD8", hash_generated_method = "E35A483B1FFB71CA229A05BEF1AD1B1F")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.636 -0400", hash_original_method = "CE08CCF44A5C011BE03C2CE7D256555D", hash_generated_method = "439FCA0638C5C733408011B39B445824")
    public Drawable getDrawable() {
Drawable varF9B456849C7B5DD9BFF89D3152C1C062_1817452349 =         mState.mDrawable;
        varF9B456849C7B5DD9BFF89D3152C1C062_1817452349.addTaint(taint);
        return varF9B456849C7B5DD9BFF89D3152C1C062_1817452349;
        // ---------- Original Method ----------
        //return mState.mDrawable;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.637 -0400", hash_original_method = "1BF1269A7F11A078222AE5900C6EC170", hash_generated_method = "D08F9EDAB6F6AE654C0E361DEE78478D")
    @Override
    public int getChangingConfigurations() {
        int varCA8871A6EDE3F4B0D8A4B17E69E2053A_1965811911 = (super.getChangingConfigurations()
                | mState.mChangingConfigurations
                | mState.mDrawable.getChangingConfigurations());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1847555503 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1847555503;
        // ---------- Original Method ----------
        //return super.getChangingConfigurations()
                //| mState.mChangingConfigurations
                //| mState.mDrawable.getChangingConfigurations();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.638 -0400", hash_original_method = "E07BF10440452C45B5D504184A6B58C8", hash_generated_method = "9AC6547287E2C3641B3198A761995499")
    public void setAlpha(int alpha) {
        addTaint(alpha);
        mState.mDrawable.setAlpha(alpha);
        // ---------- Original Method ----------
        //mState.mDrawable.setAlpha(alpha);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.639 -0400", hash_original_method = "6C570D1758B788EA390E83E99A76EB36", hash_generated_method = "15769D2690E62236B15065F92420CC65")
    public void setColorFilter(ColorFilter cf) {
        addTaint(cf.getTaint());
        mState.mDrawable.setColorFilter(cf);
        // ---------- Original Method ----------
        //mState.mDrawable.setColorFilter(cf);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.639 -0400", hash_original_method = "7CC935EC38A8A9ED900F61C0DE237712", hash_generated_method = "7D7677A93DB8C44F0F43E9EC194CE03B")
    public int getOpacity() {
        int var161C5DA78E90AA18FD3124A4BA1D9E8F_1144146539 = (mState.mDrawable.getOpacity());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1436384901 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1436384901;
        // ---------- Original Method ----------
        //return mState.mDrawable.getOpacity();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.640 -0400", hash_original_method = "289E4B14FC4BAEE8FBED5C03A1D9B634", hash_generated_method = "41CEDEB5E33EFE6B1A6A0CCC10DBF093")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.641 -0400", hash_original_method = "A01CAF97CFFAA14450A9600E14E88C8D", hash_generated_method = "7093C805993ACF54047727682755EE99")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.641 -0400", hash_original_method = "CA144C86313E3C1A3DC044F014305D8E", hash_generated_method = "FFEE17E462526EA539C05FAA6C36C1E2")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.642 -0400", hash_original_method = "02BC41BDC3ED3CF2C30379FA10185DFA", hash_generated_method = "17524E0BF548EA3C8640F1F2146633C2")
    @Override
    public boolean getPadding(Rect padding) {
        addTaint(padding.getTaint());
        boolean varF707B1D7F228AD4D878139788C1C8F59_2134478167 = (mState.mDrawable.getPadding(padding));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1306631790 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1306631790;
        // ---------- Original Method ----------
        //return mState.mDrawable.getPadding(padding);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.642 -0400", hash_original_method = "BD39509C4CE6111239623166AC9A09DC", hash_generated_method = "DABBA18205D1DDA3E25946D3ABC68BA5")
    @Override
    public boolean setVisible(boolean visible, boolean restart) {
        addTaint(restart);
        addTaint(visible);
        mState.mDrawable.setVisible(visible, restart);
        boolean varDDF69A03BCD0C3664F5E7921DE2D1E4B_629269624 = (super.setVisible(visible, restart));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1585980343 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1585980343;
        // ---------- Original Method ----------
        //mState.mDrawable.setVisible(visible, restart);
        //return super.setVisible(visible, restart);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.643 -0400", hash_original_method = "6F66CB18BCF39D7C34F81BD35385E69D", hash_generated_method = "CD54679EC64189F46A7E977AF1A12321")
    @Override
    public boolean isStateful() {
        boolean varE0911C7B30E7CAD8B191C4C55DB434C2_317017126 = (mState.mDrawable.isStateful());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1508434850 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1508434850;
        // ---------- Original Method ----------
        //return mState.mDrawable.isStateful();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.643 -0400", hash_original_method = "7EB4BF4364E02A64D78830D58D97433D", hash_generated_method = "AFF857B3327AB3E927C294787BF72EEF")
    @Override
    protected boolean onStateChange(int[] state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state[0]);
        boolean changed = mState.mDrawable.setState(state);
        onBoundsChange(getBounds());
        boolean var8977DFAC2F8E04CB96E66882235F5ABA_1702626379 = (changed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_54224203 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_54224203;
        // ---------- Original Method ----------
        //boolean changed = mState.mDrawable.setState(state);
        //onBoundsChange(getBounds());
        //return changed;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.644 -0400", hash_original_method = "83ABEEB83DB924D066F2C024127658DA", hash_generated_method = "27EE12FC134E68CF19913BE7B7462667")
    @Override
    protected boolean onLevelChange(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mState.mDrawable.setLevel(level);
        onBoundsChange(getBounds());
        mState.mCurrentDegrees = mState.mFromDegrees +
                (mState.mToDegrees - mState.mFromDegrees) *
                        ((float) level / MAX_LEVEL);
        invalidateSelf();
        boolean varB326B5062B2F0E69046810717534CB09_1091817710 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1666038677 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1666038677;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.644 -0400", hash_original_method = "EF65F96F81169D8EC042745FACAE10FF", hash_generated_method = "2F6D48DF2D9A219EA2D7DF467D1099D8")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.644 -0400", hash_original_method = "5B4218C80F47B6E11FBBAA9FF9621C9F", hash_generated_method = "78E6BFBD820F0F773CDC4C76322CDF2A")
    @Override
    public int getIntrinsicWidth() {
        int var7ADDEA45D249CEE98356EBBA52B14675_1099375968 = (mState.mDrawable.getIntrinsicWidth());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_827481367 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_827481367;
        // ---------- Original Method ----------
        //return mState.mDrawable.getIntrinsicWidth();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.645 -0400", hash_original_method = "D5692643A14F3CC0D08138E7C727B99D", hash_generated_method = "6AD2C1830C57282A4CE9F826B202530E")
    @Override
    public int getIntrinsicHeight() {
        int varE3F3C2B9CA67A8CAF781F2B0B6453BD5_2028080385 = (mState.mDrawable.getIntrinsicHeight());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_591560176 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_591560176;
        // ---------- Original Method ----------
        //return mState.mDrawable.getIntrinsicHeight();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.645 -0400", hash_original_method = "810CA52F78245136A3D7374C4FDCA32A", hash_generated_method = "B0FF323F85353006F3C4648C027A3AA8")
    @Override
    public ConstantState getConstantState() {
    if(mState.canConstantState())        
        {
            mState.mChangingConfigurations = getChangingConfigurations();
ConstantState var8B975C85F13BECB9FD4D21A5F3C8A56D_2026567605 =             mState;
            var8B975C85F13BECB9FD4D21A5F3C8A56D_2026567605.addTaint(taint);
            return var8B975C85F13BECB9FD4D21A5F3C8A56D_2026567605;
        } //End block
ConstantState var540C13E9E156B687226421B24F2DF178_288987546 =         null;
        var540C13E9E156B687226421B24F2DF178_288987546.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_288987546;
        // ---------- Original Method ----------
        //if (mState.canConstantState()) {
            //mState.mChangingConfigurations = getChangingConfigurations();
            //return mState;
        //}
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.648 -0400", hash_original_method = "A81455DB3DC70DF6E6044DAADCB89002", hash_generated_method = "D7F8EDD8EB05C7DBDED0EB9039A00D45")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.649 -0400", hash_original_method = "1ABB3B56372A1EBF2E80045724D492E3", hash_generated_method = "6A77362B8C3504D4F04AED22E02F012A")
    @Override
    public Drawable mutate() {
    if(!mMutated && super.mutate() == this)        
        {
            mState.mDrawable.mutate();
            mMutated = true;
        } //End block
Drawable var72A74007B2BE62B849F475C7BDA4658B_1333107117 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1333107117.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1333107117;
        // ---------- Original Method ----------
        //if (!mMutated && super.mutate() == this) {
            //mState.mDrawable.mutate();
            //mMutated = true;
        //}
        //return this;
    }

    
    final static class RotateState extends Drawable.ConstantState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.650 -0400", hash_original_field = "D548B27C6AC66A9D9B5D05ED35C2D844", hash_generated_field = "38BA53DD394F85639C99ED8E666FF8FB")

        Drawable mDrawable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.650 -0400", hash_original_field = "276E0645C4E2084773D0EB8C5576428C", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.650 -0400", hash_original_field = "7F7BDD395B2683F1C3CE6FF4D28782A1", hash_generated_field = "C85378C704A40C3EFC15605BD9C2CCB0")

        boolean mPivotXRel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.650 -0400", hash_original_field = "D66A9F2EFD98D68E75A6EA9E5E5D83DE", hash_generated_field = "5936761CCB9106C6D82A6436A57EC343")

        float mPivotX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.650 -0400", hash_original_field = "71E602433C1B915117E3827218A7F552", hash_generated_field = "4EE5D55A1588E348C8DE32B74EC377A0")

        boolean mPivotYRel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.651 -0400", hash_original_field = "0AD24014D3E582A643E83C27A45B1B51", hash_generated_field = "6CE864DEEFD86BFE91AA6D818A7F55C0")

        float mPivotY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.651 -0400", hash_original_field = "A15722F5083687A94AEBECFD3C44711E", hash_generated_field = "179D120EA21717CC6A9EB6675A09E18B")

        float mFromDegrees;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.651 -0400", hash_original_field = "F12DDB33947BE4AD8AACC9EB5D42D418", hash_generated_field = "D04BBDA5B46FF274C82326C147187C72")

        float mToDegrees;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.651 -0400", hash_original_field = "A400194F6090059653517E4AAABDEC7F", hash_generated_field = "EF0BD8ADAC303B1287CF1584E5AA1EDB")

        float mCurrentDegrees;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.651 -0400", hash_original_field = "7C8FD9809F31C20B8422D623B0EC0C4F", hash_generated_field = "F62F8D22C4EDE8B8E63C376677BD915C")

        private boolean mCanConstantState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.651 -0400", hash_original_field = "2E319D4D352B34E33CF19129B7212FC6", hash_generated_field = "63D49323436A33301C0DA6EDF88627FF")

        private boolean mCheckedConstantState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.652 -0400", hash_original_method = "E49363C9B9277E418FC0CB021F74A645", hash_generated_method = "D93AE749A6EA00BFCB6791BCB107BC39")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.653 -0400", hash_original_method = "9DE14D671D62BC2F01E2871493505073", hash_generated_method = "9F6942FC8E3E1073C0F5CA8E9E4EB1F6")
        @Override
        public Drawable newDrawable() {
Drawable var73906AB68FE9D3B6E333C69CB0D4CD5C_991048383 =             new RotateDrawable(this, null);
            var73906AB68FE9D3B6E333C69CB0D4CD5C_991048383.addTaint(taint);
            return var73906AB68FE9D3B6E333C69CB0D4CD5C_991048383;
            // ---------- Original Method ----------
            //return new RotateDrawable(this, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.653 -0400", hash_original_method = "3300EE781F91D7B956F1DECE09B43C56", hash_generated_method = "2807A73B2D4A64030A692748AA82EF9C")
        @Override
        public Drawable newDrawable(Resources res) {
            addTaint(res.getTaint());
Drawable var08E68496273584B2BA9853DFD7C4906A_707129120 =             new RotateDrawable(this, res);
            var08E68496273584B2BA9853DFD7C4906A_707129120.addTaint(taint);
            return var08E68496273584B2BA9853DFD7C4906A_707129120;
            // ---------- Original Method ----------
            //return new RotateDrawable(this, res);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.654 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "222F6A9DE6236510D22E31966C6DBE95")
        @Override
        public int getChangingConfigurations() {
            int var276E0645C4E2084773D0EB8C5576428C_1802649851 = (mChangingConfigurations);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_232924722 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_232924722;
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.654 -0400", hash_original_method = "8D2A3A495FE794F654E28C73CF35A2A1", hash_generated_method = "8978FB282ECDD414C8A1B8C58D608098")
        public boolean canConstantState() {
    if(!mCheckedConstantState)            
            {
                mCanConstantState = mDrawable.getConstantState() != null;
                mCheckedConstantState = true;
            } //End block
            boolean var7C8FD9809F31C20B8422D623B0EC0C4F_2143485429 = (mCanConstantState);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1616131035 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1616131035;
            // ---------- Original Method ----------
            //if (!mCheckedConstantState) {
                //mCanConstantState = mDrawable.getConstantState() != null;
                //mCheckedConstantState = true;
            //}
            //return mCanConstantState;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.654 -0400", hash_original_field = "DB3C5D7FA107BF253D250628420EA38F", hash_generated_field = "AF6B537CBDB90B8253BE1615E87A6B32")

    private static final float MAX_LEVEL = 10000.0f;
}

