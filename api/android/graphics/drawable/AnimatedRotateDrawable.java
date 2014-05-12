package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.TypedValue;

import com.android.internal.R;

public class AnimatedRotateDrawable extends Drawable implements Drawable.Callback, Runnable, Animatable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.504 -0500", hash_original_field = "76B2D79DE74AF341676FB7B6133116D3", hash_generated_field = "FE6E5F6D52B9C115F35C89BDFFFA8B21")

    private AnimatedRotateState mState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.506 -0500", hash_original_field = "B15C308E96D0EEBD27CFE369FA349C15", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.508 -0500", hash_original_field = "EF0BD8ADAC303B1287CF1584E5AA1EDB", hash_generated_field = "0FCE98F0DE619D64A68E05CE83D6979D")

    private float mCurrentDegrees;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.511 -0500", hash_original_field = "40FB6879153ADDF4293522E3BE29F6A2", hash_generated_field = "94CC63D1D9940286EFAAE48CDCD55743")

    private float mIncrement;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.513 -0500", hash_original_field = "2573C0D70D240E9163F4E289C1920019", hash_generated_field = "E765B9874E0B1A54BCA423FC936F9647")

    private boolean mRunning;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.515 -0500", hash_original_method = "69ED55E7C9BDFB1CF0205590E3E993B2", hash_generated_method = "97D85F0291C818293A666051BBB96F70")
    
public AnimatedRotateDrawable() {
        this(null, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.518 -0500", hash_original_method = "AB41A646EB91FDEF71B00BCF9A828D48", hash_generated_method = "4A2A00CE8DF9BEFBF33BB7F7CB9649BD")
    
private AnimatedRotateDrawable(AnimatedRotateState rotateState, Resources res) {
        mState = new AnimatedRotateState(rotateState, this, res);
        init();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.520 -0500", hash_original_method = "10C2A2E1B80AA77427356DB5B80319DC", hash_generated_method = "ABF52A393B5FCD61FA229006AF9DB780")
    
private void init() {
        final AnimatedRotateState state = mState;
        mIncrement = 360.0f / state.mFramesCount;
        final Drawable drawable = state.mDrawable;
        if (drawable != null) {
            drawable.setFilterBitmap(true);
            if (drawable instanceof BitmapDrawable) {
                ((BitmapDrawable) drawable).setAntiAlias(true);
            }
        }
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.522 -0500", hash_original_method = "5DFCBA38220408C5DABBFEFD0FA87F8B", hash_generated_method = "D9B5048E192D6A721FAD907C26FD5607")
    
@Override
    public void draw(Canvas canvas) {
        int saveCount = canvas.save();

        final AnimatedRotateState st = mState;
        final Drawable drawable = st.mDrawable;
        final Rect bounds = drawable.getBounds();

        int w = bounds.right - bounds.left;
        int h = bounds.bottom - bounds.top;

        float px = st.mPivotXRel ? (w * st.mPivotX) : st.mPivotX;
        float py = st.mPivotYRel ? (h * st.mPivotY) : st.mPivotY;

        canvas.rotate(mCurrentDegrees, px + bounds.left, py + bounds.top);

        drawable.draw(canvas);

        canvas.restoreToCount(saveCount);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.525 -0500", hash_original_method = "1FA1E7775B3C135CAFD58A0739A38376", hash_generated_method = "FFB8BF2CEBA838C4F757E65C503F3316")
    
public void start() {
        if (!mRunning) {
            mRunning = true;
            nextFrame();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.527 -0500", hash_original_method = "9B01F7CABB2406558D1BC0A57268160A", hash_generated_method = "46EA80257F49FB5300903CEBFB6E3246")
    
public void stop() {
        mRunning = false;
        unscheduleSelf(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.529 -0500", hash_original_method = "57CB6888179AFBC1686AC8B460D38FA6", hash_generated_method = "C1447D8BD6B76ACC955861B552542AF0")
    
public boolean isRunning() {
        return mRunning;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.532 -0500", hash_original_method = "7EB3E4BAE2A62EDC6364E7CD5F30E825", hash_generated_method = "8E7FB90703DD01D4D0984540A5BD2FCB")
    
private void nextFrame() {
        unscheduleSelf(this);
        scheduleSelf(this, SystemClock.uptimeMillis() + mState.mFrameDuration);
    }
    
    @DSSpec(DSCat.THREADING)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.534 -0500", hash_original_method = "47627FAA36D08729C94EAD6CAAA95F6C", hash_generated_method = "07BAA077FF907E7C89171D76FBDFAEA0")
    
public void run() {
        // TODO: This should be computed in draw(Canvas), based on the amount
        // of time since the last frame drawn 
        mCurrentDegrees += mIncrement;
        if (mCurrentDegrees > (360.0f - mIncrement)) {
            mCurrentDegrees = 0.0f;
        }
        invalidateSelf();
        nextFrame();
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.536 -0500", hash_original_method = "183F775A408D23F991FB2833203EEE63", hash_generated_method = "03EF580F34B523F3F86B03A2584BFB35")
    
@Override
    public boolean setVisible(boolean visible, boolean restart) {
        mState.mDrawable.setVisible(visible, restart);
        boolean changed = super.setVisible(visible, restart);
        if (visible) {
            if (changed || restart) {
                mCurrentDegrees = 0.0f;
                nextFrame();
            }
        } else {
            unscheduleSelf(this);
        }
        return changed;
    }
    
    /**
     * Returns the drawable rotated by this RotateDrawable.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.538 -0500", hash_original_method = "CE08CCF44A5C011BE03C2CE7D256555D", hash_generated_method = "BEFA5166E237A523F1847A1483E2D376")
    
public Drawable getDrawable() {
        return mState.mDrawable;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.540 -0500", hash_original_method = "1BF1269A7F11A078222AE5900C6EC170", hash_generated_method = "F4C80938C81C1C6892334A7C3046F63C")
    
@Override
    public int getChangingConfigurations() {
        return super.getChangingConfigurations()
                | mState.mChangingConfigurations
                | mState.mDrawable.getChangingConfigurations();
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.543 -0500", hash_original_method = "E07BF10440452C45B5D504184A6B58C8", hash_generated_method = "771A5B696691C72ECB795BE897A70411")
    
@Override
    public void setAlpha(int alpha) {
        mState.mDrawable.setAlpha(alpha);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.545 -0500", hash_original_method = "6C570D1758B788EA390E83E99A76EB36", hash_generated_method = "D515DA309DA73F6E9E81CB00A60B86B6")
    
@Override
    public void setColorFilter(ColorFilter cf) {
        mState.mDrawable.setColorFilter(cf);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.547 -0500", hash_original_method = "7CC935EC38A8A9ED900F61C0DE237712", hash_generated_method = "2C6912CB7EFAF5519A5B360EDA63E638")
    
@Override
    public int getOpacity() {
        return mState.mDrawable.getOpacity();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.549 -0500", hash_original_method = "289E4B14FC4BAEE8FBED5C03A1D9B634", hash_generated_method = "B516B8CE176B97B58ED719463429883C")
    
public void invalidateDrawable(Drawable who) {
        final Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.552 -0500", hash_original_method = "A01CAF97CFFAA14450A9600E14E88C8D", hash_generated_method = "D916965E7ED92878F703EBB8407A3435")
    
public void scheduleDrawable(Drawable who, Runnable what, long when) {
        final Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, what, when);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.554 -0500", hash_original_method = "CA144C86313E3C1A3DC044F014305D8E", hash_generated_method = "1F0141991B8511B6AE50284469FB44D8")
    
public void unscheduleDrawable(Drawable who, Runnable what) {
        final Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, what);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.556 -0500", hash_original_method = "02BC41BDC3ED3CF2C30379FA10185DFA", hash_generated_method = "EF37E14ABAA41BD949B44B96BCA98DD1")
    
@Override
    public boolean getPadding(Rect padding) {
        return mState.mDrawable.getPadding(padding);
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.558 -0500", hash_original_method = "6F66CB18BCF39D7C34F81BD35385E69D", hash_generated_method = "8D650BF6AB97FF0BA6CDB1926623C43C")
    
@Override
    public boolean isStateful() {
        return mState.mDrawable.isStateful();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.560 -0500", hash_original_method = "EF65F96F81169D8EC042745FACAE10FF", hash_generated_method = "6B53241A301D10E115CDC4FD994DABEE")
    
@Override
    protected void onBoundsChange(Rect bounds) {
        mState.mDrawable.setBounds(bounds.left, bounds.top, bounds.right, bounds.bottom);
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.563 -0500", hash_original_method = "5B4218C80F47B6E11FBBAA9FF9621C9F", hash_generated_method = "E28C2E4A7B9402F89BB9614B8EB9AEEA")
    
@Override
    public int getIntrinsicWidth() {
        return mState.mDrawable.getIntrinsicWidth();
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.565 -0500", hash_original_method = "D5692643A14F3CC0D08138E7C727B99D", hash_generated_method = "7484AD6435F7AE8BD48190BEDCA8E9A4")
    
@Override
    public int getIntrinsicHeight() {
        return mState.mDrawable.getIntrinsicHeight();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.567 -0500", hash_original_method = "810CA52F78245136A3D7374C4FDCA32A", hash_generated_method = "F7FD4C2E1CE6CB5A53EF92C865F3EA82")
    
@Override
    public ConstantState getConstantState() {
        if (mState.canConstantState()) {
            mState.mChangingConfigurations = getChangingConfigurations();
            return mState;
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.571 -0500", hash_original_method = "A622CEEF500B9000EB94812A972E6C45", hash_generated_method = "5622AAAB2C0F1A07028EE13781D0DF43")
    
@Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs)
            throws XmlPullParserException, IOException {

        final TypedArray a = r.obtainAttributes(attrs, R.styleable.AnimatedRotateDrawable);

        super.inflateWithAttributes(r, parser, a, R.styleable.AnimatedRotateDrawable_visible);
        
        TypedValue tv = a.peekValue(R.styleable.AnimatedRotateDrawable_pivotX);
        final boolean pivotXRel = tv.type == TypedValue.TYPE_FRACTION;
        final float pivotX = pivotXRel ? tv.getFraction(1.0f, 1.0f) : tv.getFloat();
        
        tv = a.peekValue(R.styleable.AnimatedRotateDrawable_pivotY);
        final boolean pivotYRel = tv.type == TypedValue.TYPE_FRACTION;
        final float pivotY = pivotYRel ? tv.getFraction(1.0f, 1.0f) : tv.getFloat();

        setFramesCount(a.getInt(R.styleable.AnimatedRotateDrawable_framesCount, 12));
        setFramesDuration(a.getInt(R.styleable.AnimatedRotateDrawable_frameDuration, 150));

        final int res = a.getResourceId(R.styleable.AnimatedRotateDrawable_drawable, 0);
        Drawable drawable = null;
        if (res > 0) {
            drawable = r.getDrawable(res);
        }

        a.recycle();
        
        int outerDepth = parser.getDepth();
        int type;
        while ((type = parser.next()) != XmlPullParser.END_DOCUMENT &&
               (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth)) {

            if (type != XmlPullParser.START_TAG) {
                continue;
            }

            if ((drawable = Drawable.createFromXmlInner(r, parser, attrs)) == null) {
                Log.w("drawable", "Bad element under <animated-rotate>: "
                        + parser .getName());
            }
        }

        if (drawable == null) {
            Log.w("drawable", "No drawable specified for <animated-rotate>");
        }

        final AnimatedRotateState rotateState = mState;
        rotateState.mDrawable = drawable;
        rotateState.mPivotXRel = pivotXRel;
        rotateState.mPivotX = pivotX;
        rotateState.mPivotYRel = pivotYRel;
        rotateState.mPivotY = pivotY;

        init();

        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.573 -0500", hash_original_method = "B458BF95D94A39224F760F42AF094AE9", hash_generated_method = "719550CF33B70706D47D813266C6FAC0")
    
public void setFramesCount(int framesCount) {
        mState.mFramesCount = framesCount;
        mIncrement = 360.0f / mState.mFramesCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.575 -0500", hash_original_method = "CDF8A4A058FBB62E5E21EBF9FD2DD694", hash_generated_method = "BBB8B51A11AE5B721E7130146A6DE3DF")
    
public void setFramesDuration(int framesDuration) {
        mState.mFrameDuration = framesDuration;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.577 -0500", hash_original_method = "1ABB3B56372A1EBF2E80045724D492E3", hash_generated_method = "414636B1F74F02F73E1047B03CD83E9B")
    
@Override
    public Drawable mutate() {
        if (!mMutated && super.mutate() == this) {
            mState.mDrawable.mutate();
            mMutated = true;
        }
        return this;
    }
    
    final static class AnimatedRotateState extends Drawable.ConstantState {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.580 -0500", hash_original_field = "38BA53DD394F85639C99ED8E666FF8FB", hash_generated_field = "38BA53DD394F85639C99ED8E666FF8FB")

        Drawable mDrawable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.583 -0500", hash_original_field = "9BFAF00848476277D36D9BA586984BA7", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.585 -0500", hash_original_field = "C85378C704A40C3EFC15605BD9C2CCB0", hash_generated_field = "C85378C704A40C3EFC15605BD9C2CCB0")
        
        boolean mPivotXRel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.587 -0500", hash_original_field = "5936761CCB9106C6D82A6436A57EC343", hash_generated_field = "5936761CCB9106C6D82A6436A57EC343")

        float mPivotX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.589 -0500", hash_original_field = "4EE5D55A1588E348C8DE32B74EC377A0", hash_generated_field = "4EE5D55A1588E348C8DE32B74EC377A0")

        boolean mPivotYRel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.591 -0500", hash_original_field = "6CE864DEEFD86BFE91AA6D818A7F55C0", hash_generated_field = "6CE864DEEFD86BFE91AA6D818A7F55C0")

        float mPivotY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.593 -0500", hash_original_field = "0644D880B120B0F98D7BCA0C2E0486B2", hash_generated_field = "0644D880B120B0F98D7BCA0C2E0486B2")

        int mFrameDuration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.595 -0500", hash_original_field = "5ECD6AC9A9CB96CB01ACA98AF1EE1385", hash_generated_field = "5ECD6AC9A9CB96CB01ACA98AF1EE1385")

        int mFramesCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.597 -0500", hash_original_field = "09212A3A30B7E6D48DEECC4F4639CCBC", hash_generated_field = "F62F8D22C4EDE8B8E63C376677BD915C")

        private boolean mCanConstantState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.599 -0500", hash_original_field = "04605894B57F7B3414AF620BF4AC040E", hash_generated_field = "63D49323436A33301C0DA6EDF88627FF")

        private boolean mCheckedConstantState;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.602 -0500", hash_original_method = "1B1F90708B07C46F9FB4F0410B3AE108", hash_generated_method = "D833034A91655C36359E83C1265D544A")
        
public AnimatedRotateState(AnimatedRotateState source, AnimatedRotateDrawable owner,
                Resources res) {
            if (source != null) {
                if (res != null) {
                    mDrawable = source.mDrawable.getConstantState().newDrawable(res);
                } else {
                    mDrawable = source.mDrawable.getConstantState().newDrawable();
                }
                mDrawable.setCallback(owner);
                mPivotXRel = source.mPivotXRel;
                mPivotX = source.mPivotX;
                mPivotYRel = source.mPivotYRel;
                mPivotY = source.mPivotY;
                mFramesCount = source.mFramesCount;
                mFrameDuration = source.mFrameDuration;
                mCanConstantState = mCheckedConstantState = true;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.608 -0500", hash_original_method = "90513075AAF61DC02051F8AF573AA026", hash_generated_method = "ADE057D47096800C99221883F0F623BA")
        
@Override
        public Drawable newDrawable() {
            return new AnimatedRotateDrawable(this, null);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.611 -0500", hash_original_method = "8E62ECEB973FF3825859D252B23F201A", hash_generated_method = "7CB9BF17EB6791D4C70DC5F0594E8B16")
        
@Override
        public Drawable newDrawable(Resources res) {
            return new AnimatedRotateDrawable(this, res);
        }
        
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.613 -0500", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "3AB30668ED270F2EDF2E0129C706FE4D")
        
@Override
        public int getChangingConfigurations() {
            return mChangingConfigurations;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:17.616 -0500", hash_original_method = "8D2A3A495FE794F654E28C73CF35A2A1", hash_generated_method = "D7605CD8561469FF7F51AF0DC063DCC1")
        
public boolean canConstantState() {
            if (!mCheckedConstantState) {
                mCanConstantState = mDrawable.getConstantState() != null;
                mCheckedConstantState = true;
            }

            return mCanConstantState;
        }
        
    }
    
}

