package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.ColorFilter;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Log;
import android.os.SystemClock;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import com.android.internal.R;

public class AnimatedRotateDrawable extends Drawable implements Drawable.Callback, Runnable, Animatable {
    private AnimatedRotateState mState;
    private boolean mMutated;
    private float mCurrentDegrees;
    private float mIncrement;
    private boolean mRunning;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.858 -0400", hash_original_method = "69ED55E7C9BDFB1CF0205590E3E993B2", hash_generated_method = "5F987BF114CD8F7A8EE74075FD2E9C32")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AnimatedRotateDrawable() {
        this(null, null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.858 -0400", hash_original_method = "AB41A646EB91FDEF71B00BCF9A828D48", hash_generated_method = "9880FEE20115D30E14A9B19FD102142B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private AnimatedRotateDrawable(AnimatedRotateState rotateState, Resources res) {
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(rotateState.dsTaint);
        mState = new AnimatedRotateState(rotateState, this, res);
        init();
        // ---------- Original Method ----------
        //mState = new AnimatedRotateState(rotateState, this, res);
        //init();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.858 -0400", hash_original_method = "10C2A2E1B80AA77427356DB5B80319DC", hash_generated_method = "E5CFFB9A12443405FF52BE3BA82EA4E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void init() {
        AnimatedRotateState state;
        state = mState;
        mIncrement = 360.0f / state.mFramesCount;
        Drawable drawable;
        drawable = state.mDrawable;
        {
            drawable.setFilterBitmap(true);
            {
                ((BitmapDrawable) drawable).setAntiAlias(true);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //final AnimatedRotateState state = mState;
        //mIncrement = 360.0f / state.mFramesCount;
        //final Drawable drawable = state.mDrawable;
        //if (drawable != null) {
            //drawable.setFilterBitmap(true);
            //if (drawable instanceof BitmapDrawable) {
                //((BitmapDrawable) drawable).setAntiAlias(true);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.859 -0400", hash_original_method = "5DFCBA38220408C5DABBFEFD0FA87F8B", hash_generated_method = "C8D719C2BE1A9D721542EBF9834C2F84")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void draw(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        int saveCount;
        saveCount = canvas.save();
        AnimatedRotateState st;
        st = mState;
        Drawable drawable;
        drawable = st.mDrawable;
        Rect bounds;
        bounds = drawable.getBounds();
        int w;
        w = bounds.right - bounds.left;
        int h;
        h = bounds.bottom - bounds.top;
        float px;
        px = (w * st.mPivotX);
        px = st.mPivotX;
        float py;
        py = (h * st.mPivotY);
        py = st.mPivotY;
        canvas.rotate(mCurrentDegrees, px + bounds.left, py + bounds.top);
        drawable.draw(canvas);
        canvas.restoreToCount(saveCount);
        // ---------- Original Method ----------
        //int saveCount = canvas.save();
        //final AnimatedRotateState st = mState;
        //final Drawable drawable = st.mDrawable;
        //final Rect bounds = drawable.getBounds();
        //int w = bounds.right - bounds.left;
        //int h = bounds.bottom - bounds.top;
        //float px = st.mPivotXRel ? (w * st.mPivotX) : st.mPivotX;
        //float py = st.mPivotYRel ? (h * st.mPivotY) : st.mPivotY;
        //canvas.rotate(mCurrentDegrees, px + bounds.left, py + bounds.top);
        //drawable.draw(canvas);
        //canvas.restoreToCount(saveCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.859 -0400", hash_original_method = "1FA1E7775B3C135CAFD58A0739A38376", hash_generated_method = "9E812F682EF5DA4823FCECFC0C00F9F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void start() {
        {
            mRunning = true;
            nextFrame();
        } //End block
        // ---------- Original Method ----------
        //if (!mRunning) {
            //mRunning = true;
            //nextFrame();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.859 -0400", hash_original_method = "9B01F7CABB2406558D1BC0A57268160A", hash_generated_method = "DE4674A61A26FAFB8EEC5D6045E39EA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void stop() {
        mRunning = false;
        unscheduleSelf(this);
        // ---------- Original Method ----------
        //mRunning = false;
        //unscheduleSelf(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.859 -0400", hash_original_method = "57CB6888179AFBC1686AC8B460D38FA6", hash_generated_method = "309924529868F71E79240CABEB5DEA71")
    @DSModeled(DSC.SAFE)
    public boolean isRunning() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mRunning;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.860 -0400", hash_original_method = "7EB3E4BAE2A62EDC6364E7CD5F30E825", hash_generated_method = "186E401AF8BB6D7DC716D6E328839E6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nextFrame() {
        unscheduleSelf(this);
        scheduleSelf(this, SystemClock.uptimeMillis() + mState.mFrameDuration);
        // ---------- Original Method ----------
        //unscheduleSelf(this);
        //scheduleSelf(this, SystemClock.uptimeMillis() + mState.mFrameDuration);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.860 -0400", hash_original_method = "47627FAA36D08729C94EAD6CAAA95F6C", hash_generated_method = "91F28FFFE1A8505DB00F206AC64D46A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void run() {
        mCurrentDegrees += mIncrement;
        {
            mCurrentDegrees = 0.0f;
        } //End block
        invalidateSelf();
        nextFrame();
        // ---------- Original Method ----------
        //mCurrentDegrees += mIncrement;
        //if (mCurrentDegrees > (360.0f - mIncrement)) {
            //mCurrentDegrees = 0.0f;
        //}
        //invalidateSelf();
        //nextFrame();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.860 -0400", hash_original_method = "183F775A408D23F991FB2833203EEE63", hash_generated_method = "4BFC1F7529537608C5A1571FB310B827")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean setVisible(boolean visible, boolean restart) {
        dsTaint.addTaint(restart);
        dsTaint.addTaint(visible);
        mState.mDrawable.setVisible(visible, restart);
        boolean changed;
        changed = super.setVisible(visible, restart);
        {
            {
                mCurrentDegrees = 0.0f;
                nextFrame();
            } //End block
        } //End block
        {
            unscheduleSelf(this);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //mState.mDrawable.setVisible(visible, restart);
        //boolean changed = super.setVisible(visible, restart);
        //if (visible) {
            //if (changed || restart) {
                //mCurrentDegrees = 0.0f;
                //nextFrame();
            //}
        //} else {
            //unscheduleSelf(this);
        //}
        //return changed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.860 -0400", hash_original_method = "CE08CCF44A5C011BE03C2CE7D256555D", hash_generated_method = "8937045A2757750A4D2A8CD50836C56C")
    @DSModeled(DSC.SAFE)
    public Drawable getDrawable() {
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mState.mDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.861 -0400", hash_original_method = "1BF1269A7F11A078222AE5900C6EC170", hash_generated_method = "3F03F53CD9C559FA844C0E614C0195A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getChangingConfigurations() {
        int var0FF1530E46268DA64EFCE0D0E400E8C4_1181542229 = (super.getChangingConfigurations()
                | mState.mChangingConfigurations
                | mState.mDrawable.getChangingConfigurations());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return super.getChangingConfigurations()
                //| mState.mChangingConfigurations
                //| mState.mDrawable.getChangingConfigurations();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.861 -0400", hash_original_method = "E07BF10440452C45B5D504184A6B58C8", hash_generated_method = "B896A41CEEE15AF87AFF6FCB643F8317")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setAlpha(int alpha) {
        dsTaint.addTaint(alpha);
        mState.mDrawable.setAlpha(alpha);
        // ---------- Original Method ----------
        //mState.mDrawable.setAlpha(alpha);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.861 -0400", hash_original_method = "6C570D1758B788EA390E83E99A76EB36", hash_generated_method = "FD3A1D817FF05D3054CF5ACBCF169189")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setColorFilter(ColorFilter cf) {
        dsTaint.addTaint(cf.dsTaint);
        mState.mDrawable.setColorFilter(cf);
        // ---------- Original Method ----------
        //mState.mDrawable.setColorFilter(cf);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.861 -0400", hash_original_method = "7CC935EC38A8A9ED900F61C0DE237712", hash_generated_method = "085F7A274FB8145C0E11860ABFCEE2E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getOpacity() {
        int var208671101B6F4CE4F7912D03727B9ECD_377863131 = (mState.mDrawable.getOpacity());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mState.mDrawable.getOpacity();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.862 -0400", hash_original_method = "289E4B14FC4BAEE8FBED5C03A1D9B634", hash_generated_method = "41CFE1796930DCF2EA1C09782362A302")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.862 -0400", hash_original_method = "A01CAF97CFFAA14450A9600E14E88C8D", hash_generated_method = "5E91FE06A500769A5C043EEFE8B10766")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.862 -0400", hash_original_method = "CA144C86313E3C1A3DC044F014305D8E", hash_generated_method = "E7D6D2791C5354C92F65E1B2A3B561B5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.862 -0400", hash_original_method = "02BC41BDC3ED3CF2C30379FA10185DFA", hash_generated_method = "7639EE6AF4242A4E39F0D4714CEE41F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getPadding(Rect padding) {
        dsTaint.addTaint(padding.dsTaint);
        boolean varC7A533DDD324CE8744300E8FF1B02882_1660435015 = (mState.mDrawable.getPadding(padding));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mState.mDrawable.getPadding(padding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.863 -0400", hash_original_method = "6F66CB18BCF39D7C34F81BD35385E69D", hash_generated_method = "B787AB6DB7C638C7DBCC56BC92B6E5CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isStateful() {
        boolean var49A6E47C93BCE92CD66848492C5DEB16_105710290 = (mState.mDrawable.isStateful());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mState.mDrawable.isStateful();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.863 -0400", hash_original_method = "EF65F96F81169D8EC042745FACAE10FF", hash_generated_method = "E8D212A8B046F329B6A702E8C264C324")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onBoundsChange(Rect bounds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(bounds.dsTaint);
        mState.mDrawable.setBounds(bounds.left, bounds.top, bounds.right, bounds.bottom);
        // ---------- Original Method ----------
        //mState.mDrawable.setBounds(bounds.left, bounds.top, bounds.right, bounds.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.863 -0400", hash_original_method = "5B4218C80F47B6E11FBBAA9FF9621C9F", hash_generated_method = "E02D7B01B578AB7588805DFB5869E27B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getIntrinsicWidth() {
        int varF0E785BE9442695B8C554DDF53D66DF4_983310066 = (mState.mDrawable.getIntrinsicWidth());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mState.mDrawable.getIntrinsicWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.863 -0400", hash_original_method = "D5692643A14F3CC0D08138E7C727B99D", hash_generated_method = "F55DE407BA67405148F73967D426769F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getIntrinsicHeight() {
        int var740C212F7282B7300448D928B6215BB6_719874761 = (mState.mDrawable.getIntrinsicHeight());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mState.mDrawable.getIntrinsicHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.864 -0400", hash_original_method = "810CA52F78245136A3D7374C4FDCA32A", hash_generated_method = "DE1E33049BCA1325569725C25ED7CD19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ConstantState getConstantState() {
        {
            boolean var80BE086B3CF987C8B4EA155D5304638A_1881467239 = (mState.canConstantState());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.864 -0400", hash_original_method = "A622CEEF500B9000EB94812A972E6C45", hash_generated_method = "E6DAD5BE27D596D3A60E7EAE7BDAE905")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
        TypedArray a;
        a = r.obtainAttributes(attrs, R.styleable.AnimatedRotateDrawable);
        super.inflateWithAttributes(r, parser, a, R.styleable.AnimatedRotateDrawable_visible);
        TypedValue tv;
        tv = a.peekValue(R.styleable.AnimatedRotateDrawable_pivotX);
        boolean pivotXRel;
        pivotXRel = tv.type == TypedValue.TYPE_FRACTION;
        float pivotX;
        pivotX = tv.getFraction(1.0f, 1.0f);
        pivotX = tv.getFloat();
        tv = a.peekValue(R.styleable.AnimatedRotateDrawable_pivotY);
        boolean pivotYRel;
        pivotYRel = tv.type == TypedValue.TYPE_FRACTION;
        float pivotY;
        pivotY = tv.getFraction(1.0f, 1.0f);
        pivotY = tv.getFloat();
        setFramesCount(a.getInt(R.styleable.AnimatedRotateDrawable_framesCount, 12));
        setFramesDuration(a.getInt(R.styleable.AnimatedRotateDrawable_frameDuration, 150));
        int res;
        res = a.getResourceId(R.styleable.AnimatedRotateDrawable_drawable, 0);
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
            boolean varC141F9598534BC349F58FDDEEA6C1DB7_557958668 = ((type = parser.next()) != XmlPullParser.END_DOCUMENT &&
               (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth));
            {
                {
                    boolean var24A02A5F6DE110121BAFDE44AC7A8F0C_1509891461 = ((drawable = Drawable.createFromXmlInner(r, parser, attrs)) == null);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        AnimatedRotateState rotateState;
        rotateState = mState;
        rotateState.mDrawable = drawable;
        rotateState.mPivotXRel = pivotXRel;
        rotateState.mPivotX = pivotX;
        rotateState.mPivotYRel = pivotYRel;
        rotateState.mPivotY = pivotY;
        init();
        {
            drawable.setCallback(this);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.865 -0400", hash_original_method = "B458BF95D94A39224F760F42AF094AE9", hash_generated_method = "73DBFAD728C670168A1A878BABC1836D")
    @DSModeled(DSC.SAFE)
    public void setFramesCount(int framesCount) {
        dsTaint.addTaint(framesCount);
        mState.mFramesCount = framesCount;
        mIncrement = 360.0f / mState.mFramesCount;
        // ---------- Original Method ----------
        //mState.mFramesCount = framesCount;
        //mIncrement = 360.0f / mState.mFramesCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.865 -0400", hash_original_method = "CDF8A4A058FBB62E5E21EBF9FD2DD694", hash_generated_method = "6E2748036DC7D93F27FA785D930D6E0A")
    @DSModeled(DSC.SAFE)
    public void setFramesDuration(int framesDuration) {
        dsTaint.addTaint(framesDuration);
        mState.mFrameDuration = framesDuration;
        // ---------- Original Method ----------
        //mState.mFrameDuration = framesDuration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.865 -0400", hash_original_method = "1ABB3B56372A1EBF2E80045724D492E3", hash_generated_method = "D95CA058E1EAAEA851F89EFE86113F64")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Drawable mutate() {
        {
            boolean varC94B19053599294E7944C8C841976773_93381071 = (!mMutated && super.mutate() == this);
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

    
    final static class AnimatedRotateState extends Drawable.ConstantState {
        Drawable mDrawable;
        int mChangingConfigurations;
        boolean mPivotXRel;
        float mPivotX;
        boolean mPivotYRel;
        float mPivotY;
        int mFrameDuration;
        int mFramesCount;
        private boolean mCanConstantState;
        private boolean mCheckedConstantState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.866 -0400", hash_original_method = "1B1F90708B07C46F9FB4F0410B3AE108", hash_generated_method = "5FC6B111C090515912C5BF97381E4E94")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public AnimatedRotateState(AnimatedRotateState source, AnimatedRotateDrawable owner,
                Resources res) {
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
                mFramesCount = source.mFramesCount;
                mFrameDuration = source.mFrameDuration;
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
                //mFramesCount = source.mFramesCount;
                //mFrameDuration = source.mFrameDuration;
                //mCanConstantState = mCheckedConstantState = true;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.866 -0400", hash_original_method = "90513075AAF61DC02051F8AF573AA026", hash_generated_method = "A7951C6909E2DE69B0A610DD80870092")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Drawable newDrawable() {
            Drawable var5115818C0B8FBC60B2C89C6E5103E54D_1096258097 = (new AnimatedRotateDrawable(this, null));
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new AnimatedRotateDrawable(this, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.866 -0400", hash_original_method = "8E62ECEB973FF3825859D252B23F201A", hash_generated_method = "CC4324CC5798B10C2AF71F2B212B1124")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Drawable newDrawable(Resources res) {
            dsTaint.addTaint(res.dsTaint);
            Drawable var2EE94815F5B28DC4EEAB349FB930377F_1808140986 = (new AnimatedRotateDrawable(this, res));
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new AnimatedRotateDrawable(this, res);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.866 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "36011B0CFA5B1C48E438EB66BB35159E")
        @DSModeled(DSC.SAFE)
        @Override
        public int getChangingConfigurations() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.866 -0400", hash_original_method = "8D2A3A495FE794F654E28C73CF35A2A1", hash_generated_method = "1AD508279EAAB1244D7009C92E2EC800")
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


    
}

