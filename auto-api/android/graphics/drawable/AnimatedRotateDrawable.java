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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.907 -0400", hash_original_field = "48A902C1D749B47EBC75C77370D5A1F0", hash_generated_field = "FE6E5F6D52B9C115F35C89BDFFFA8B21")

    private AnimatedRotateState mState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.927 -0400", hash_original_field = "9FB80C30383848C8D006680B5F3BDAF9", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.927 -0400", hash_original_field = "A400194F6090059653517E4AAABDEC7F", hash_generated_field = "0FCE98F0DE619D64A68E05CE83D6979D")

    private float mCurrentDegrees;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.927 -0400", hash_original_field = "B954C9EDAC21852B96AD8DA47FB0BB4A", hash_generated_field = "94CC63D1D9940286EFAAE48CDCD55743")

    private float mIncrement;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.927 -0400", hash_original_field = "EDF4C7A103D013E4C010EA6C8903F47F", hash_generated_field = "E765B9874E0B1A54BCA423FC936F9647")

    private boolean mRunning;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.928 -0400", hash_original_method = "69ED55E7C9BDFB1CF0205590E3E993B2", hash_generated_method = "5F987BF114CD8F7A8EE74075FD2E9C32")
    public  AnimatedRotateDrawable() {
        this(null, null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.929 -0400", hash_original_method = "AB41A646EB91FDEF71B00BCF9A828D48", hash_generated_method = "A63703D8323CBA74C528AB39CAA25753")
    private  AnimatedRotateDrawable(AnimatedRotateState rotateState, Resources res) {
        mState = new AnimatedRotateState(rotateState, this, res);
        init();
        // ---------- Original Method ----------
        //mState = new AnimatedRotateState(rotateState, this, res);
        //init();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.930 -0400", hash_original_method = "10C2A2E1B80AA77427356DB5B80319DC", hash_generated_method = "E5CFFB9A12443405FF52BE3BA82EA4E0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.956 -0400", hash_original_method = "5DFCBA38220408C5DABBFEFD0FA87F8B", hash_generated_method = "0CC2C3097D06FE21C56EA8956C20FC4A")
    @Override
    public void draw(Canvas canvas) {
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
        addTaint(canvas.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.957 -0400", hash_original_method = "1FA1E7775B3C135CAFD58A0739A38376", hash_generated_method = "9E812F682EF5DA4823FCECFC0C00F9F5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.958 -0400", hash_original_method = "9B01F7CABB2406558D1BC0A57268160A", hash_generated_method = "DE4674A61A26FAFB8EEC5D6045E39EA4")
    public void stop() {
        mRunning = false;
        unscheduleSelf(this);
        // ---------- Original Method ----------
        //mRunning = false;
        //unscheduleSelf(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.959 -0400", hash_original_method = "57CB6888179AFBC1686AC8B460D38FA6", hash_generated_method = "DE5EA93B7C30FF5A569FDEC35C36239C")
    public boolean isRunning() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1656448456 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1656448456;
        // ---------- Original Method ----------
        //return mRunning;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.991 -0400", hash_original_method = "7EB3E4BAE2A62EDC6364E7CD5F30E825", hash_generated_method = "186E401AF8BB6D7DC716D6E328839E6A")
    private void nextFrame() {
        unscheduleSelf(this);
        scheduleSelf(this, SystemClock.uptimeMillis() + mState.mFrameDuration);
        // ---------- Original Method ----------
        //unscheduleSelf(this);
        //scheduleSelf(this, SystemClock.uptimeMillis() + mState.mFrameDuration);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.001 -0400", hash_original_method = "47627FAA36D08729C94EAD6CAAA95F6C", hash_generated_method = "91F28FFFE1A8505DB00F206AC64D46A0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.018 -0400", hash_original_method = "183F775A408D23F991FB2833203EEE63", hash_generated_method = "45ECEE2703AD1D1CDFC7A759DF0F67DC")
    @Override
    public boolean setVisible(boolean visible, boolean restart) {
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
        addTaint(visible);
        addTaint(restart);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_160413941 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_160413941;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.023 -0400", hash_original_method = "CE08CCF44A5C011BE03C2CE7D256555D", hash_generated_method = "F4F557DEE8098191C5A9A762068C5CF9")
    public Drawable getDrawable() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_727959607 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_727959607 = mState.mDrawable;
        varB4EAC82CA7396A68D541C85D26508E83_727959607.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_727959607;
        // ---------- Original Method ----------
        //return mState.mDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.024 -0400", hash_original_method = "1BF1269A7F11A078222AE5900C6EC170", hash_generated_method = "A7AE07CE88AAADA8BF6543DC232522D9")
    @Override
    public int getChangingConfigurations() {
        int var0FF1530E46268DA64EFCE0D0E400E8C4_1263750344 = (super.getChangingConfigurations()
                | mState.mChangingConfigurations
                | mState.mDrawable.getChangingConfigurations());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_265480272 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_265480272;
        // ---------- Original Method ----------
        //return super.getChangingConfigurations()
                //| mState.mChangingConfigurations
                //| mState.mDrawable.getChangingConfigurations();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.025 -0400", hash_original_method = "E07BF10440452C45B5D504184A6B58C8", hash_generated_method = "8801B05A78398BA33099DDD5FC547159")
    @Override
    public void setAlpha(int alpha) {
        mState.mDrawable.setAlpha(alpha);
        addTaint(alpha);
        // ---------- Original Method ----------
        //mState.mDrawable.setAlpha(alpha);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.031 -0400", hash_original_method = "6C570D1758B788EA390E83E99A76EB36", hash_generated_method = "7BE9D61989CD3E2790D5181149F40CF6")
    @Override
    public void setColorFilter(ColorFilter cf) {
        mState.mDrawable.setColorFilter(cf);
        addTaint(cf.getTaint());
        // ---------- Original Method ----------
        //mState.mDrawable.setColorFilter(cf);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.033 -0400", hash_original_method = "7CC935EC38A8A9ED900F61C0DE237712", hash_generated_method = "AD3D62A2FEEF8FFC29CA78DDE3825DCE")
    @Override
    public int getOpacity() {
        int var208671101B6F4CE4F7912D03727B9ECD_1146346697 = (mState.mDrawable.getOpacity());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1566228887 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1566228887;
        // ---------- Original Method ----------
        //return mState.mDrawable.getOpacity();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.033 -0400", hash_original_method = "289E4B14FC4BAEE8FBED5C03A1D9B634", hash_generated_method = "8C74E1ED724AA0C6A0C97462CE6BFB75")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.035 -0400", hash_original_method = "A01CAF97CFFAA14450A9600E14E88C8D", hash_generated_method = "D0BA170008FFB5E5F5CAA53137A69B81")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.035 -0400", hash_original_method = "CA144C86313E3C1A3DC044F014305D8E", hash_generated_method = "F27A8BA34D960AEC80EA06B1020FC534")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.055 -0400", hash_original_method = "02BC41BDC3ED3CF2C30379FA10185DFA", hash_generated_method = "ECD82EBF53B5BA704306B6BB294CE743")
    @Override
    public boolean getPadding(Rect padding) {
        boolean varC7A533DDD324CE8744300E8FF1B02882_1587971682 = (mState.mDrawable.getPadding(padding));
        addTaint(padding.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1199769520 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1199769520;
        // ---------- Original Method ----------
        //return mState.mDrawable.getPadding(padding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.055 -0400", hash_original_method = "6F66CB18BCF39D7C34F81BD35385E69D", hash_generated_method = "583B3D28B252B08913C4D1BA8BB3F36C")
    @Override
    public boolean isStateful() {
        boolean var49A6E47C93BCE92CD66848492C5DEB16_1100922783 = (mState.mDrawable.isStateful());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1015877288 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1015877288;
        // ---------- Original Method ----------
        //return mState.mDrawable.isStateful();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.056 -0400", hash_original_method = "EF65F96F81169D8EC042745FACAE10FF", hash_generated_method = "4FD0A705CB8023B974D0770B2E09B67B")
    @Override
    protected void onBoundsChange(Rect bounds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mState.mDrawable.setBounds(bounds.left, bounds.top, bounds.right, bounds.bottom);
        addTaint(bounds.getTaint());
        // ---------- Original Method ----------
        //mState.mDrawable.setBounds(bounds.left, bounds.top, bounds.right, bounds.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.056 -0400", hash_original_method = "5B4218C80F47B6E11FBBAA9FF9621C9F", hash_generated_method = "9DEA37D607102775D4D148ACE17B3583")
    @Override
    public int getIntrinsicWidth() {
        int varF0E785BE9442695B8C554DDF53D66DF4_1239875013 = (mState.mDrawable.getIntrinsicWidth());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_282272109 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_282272109;
        // ---------- Original Method ----------
        //return mState.mDrawable.getIntrinsicWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.074 -0400", hash_original_method = "D5692643A14F3CC0D08138E7C727B99D", hash_generated_method = "8CF109AADA6290307BD8BDF11A5DDEB1")
    @Override
    public int getIntrinsicHeight() {
        int var740C212F7282B7300448D928B6215BB6_2001121060 = (mState.mDrawable.getIntrinsicHeight());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1775100876 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1775100876;
        // ---------- Original Method ----------
        //return mState.mDrawable.getIntrinsicHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.075 -0400", hash_original_method = "810CA52F78245136A3D7374C4FDCA32A", hash_generated_method = "F5AFF0EE7ACF40E654A09C55274B1576")
    @Override
    public ConstantState getConstantState() {
        ConstantState varB4EAC82CA7396A68D541C85D26508E83_14056540 = null; //Variable for return #1
        ConstantState varB4EAC82CA7396A68D541C85D26508E83_662952996 = null; //Variable for return #2
        {
            boolean var80BE086B3CF987C8B4EA155D5304638A_1206185556 = (mState.canConstantState());
            {
                mState.mChangingConfigurations = getChangingConfigurations();
                varB4EAC82CA7396A68D541C85D26508E83_14056540 = mState;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_662952996 = null;
        ConstantState varA7E53CE21691AB073D9660D615818899_1214397726; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1214397726 = varB4EAC82CA7396A68D541C85D26508E83_14056540;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1214397726 = varB4EAC82CA7396A68D541C85D26508E83_662952996;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1214397726.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1214397726;
        // ---------- Original Method ----------
        //if (mState.canConstantState()) {
            //mState.mChangingConfigurations = getChangingConfigurations();
            //return mState;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.096 -0400", hash_original_method = "A622CEEF500B9000EB94812A972E6C45", hash_generated_method = "F4C256BE8E52837AC69CF896186B8672")
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
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
            boolean varC141F9598534BC349F58FDDEEA6C1DB7_355919432 = ((type = parser.next()) != XmlPullParser.END_DOCUMENT &&
               (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth));
            {
                {
                    boolean var24A02A5F6DE110121BAFDE44AC7A8F0C_1789058457 = ((drawable = Drawable.createFromXmlInner(r, parser, attrs)) == null);
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
        addTaint(r.getTaint());
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.097 -0400", hash_original_method = "B458BF95D94A39224F760F42AF094AE9", hash_generated_method = "C62AE0432E269CE7FBBF9D025C9EDB42")
    public void setFramesCount(int framesCount) {
        mState.mFramesCount = framesCount;
        mIncrement = 360.0f / mState.mFramesCount;
        // ---------- Original Method ----------
        //mState.mFramesCount = framesCount;
        //mIncrement = 360.0f / mState.mFramesCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.110 -0400", hash_original_method = "CDF8A4A058FBB62E5E21EBF9FD2DD694", hash_generated_method = "A03827D13AD31602F15D5BCB5CBA16BF")
    public void setFramesDuration(int framesDuration) {
        mState.mFrameDuration = framesDuration;
        // ---------- Original Method ----------
        //mState.mFrameDuration = framesDuration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.111 -0400", hash_original_method = "1ABB3B56372A1EBF2E80045724D492E3", hash_generated_method = "BA795A12FDE4F4AD51E4EFB4702E9A92")
    @Override
    public Drawable mutate() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_708799555 = null; //Variable for return #1
        {
            boolean varC94B19053599294E7944C8C841976773_880368116 = (!mMutated && super.mutate() == this);
            {
                mState.mDrawable.mutate();
                mMutated = true;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_708799555 = this;
        varB4EAC82CA7396A68D541C85D26508E83_708799555.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_708799555;
        // ---------- Original Method ----------
        //if (!mMutated && super.mutate() == this) {
            //mState.mDrawable.mutate();
            //mMutated = true;
        //}
        //return this;
    }

    
    final static class AnimatedRotateState extends Drawable.ConstantState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.111 -0400", hash_original_field = "D548B27C6AC66A9D9B5D05ED35C2D844", hash_generated_field = "38BA53DD394F85639C99ED8E666FF8FB")

        Drawable mDrawable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.111 -0400", hash_original_field = "276E0645C4E2084773D0EB8C5576428C", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.111 -0400", hash_original_field = "7F7BDD395B2683F1C3CE6FF4D28782A1", hash_generated_field = "C85378C704A40C3EFC15605BD9C2CCB0")

        boolean mPivotXRel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.111 -0400", hash_original_field = "D66A9F2EFD98D68E75A6EA9E5E5D83DE", hash_generated_field = "5936761CCB9106C6D82A6436A57EC343")

        float mPivotX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.112 -0400", hash_original_field = "71E602433C1B915117E3827218A7F552", hash_generated_field = "4EE5D55A1588E348C8DE32B74EC377A0")

        boolean mPivotYRel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.112 -0400", hash_original_field = "0AD24014D3E582A643E83C27A45B1B51", hash_generated_field = "6CE864DEEFD86BFE91AA6D818A7F55C0")

        float mPivotY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.112 -0400", hash_original_field = "ACF20957D6502920CE28BD5E78CCEE92", hash_generated_field = "0644D880B120B0F98D7BCA0C2E0486B2")

        int mFrameDuration;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.112 -0400", hash_original_field = "E1762CF88059E9A4F6ACDD6D1B47D33D", hash_generated_field = "5ECD6AC9A9CB96CB01ACA98AF1EE1385")

        int mFramesCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.112 -0400", hash_original_field = "7C8FD9809F31C20B8422D623B0EC0C4F", hash_generated_field = "F62F8D22C4EDE8B8E63C376677BD915C")

        private boolean mCanConstantState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.112 -0400", hash_original_field = "2E319D4D352B34E33CF19129B7212FC6", hash_generated_field = "63D49323436A33301C0DA6EDF88627FF")

        private boolean mCheckedConstantState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.125 -0400", hash_original_method = "1B1F90708B07C46F9FB4F0410B3AE108", hash_generated_method = "70CF591B411F6A1AB10E0D4CBDB26BA7")
        public  AnimatedRotateState(AnimatedRotateState source, AnimatedRotateDrawable owner,
                Resources res) {
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
            addTaint(owner.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.139 -0400", hash_original_method = "90513075AAF61DC02051F8AF573AA026", hash_generated_method = "4E9805F8A9307ADBE0A36D05D77E9796")
        @Override
        public Drawable newDrawable() {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_1155907868 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1155907868 = new AnimatedRotateDrawable(this, null);
            varB4EAC82CA7396A68D541C85D26508E83_1155907868.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1155907868;
            // ---------- Original Method ----------
            //return new AnimatedRotateDrawable(this, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.140 -0400", hash_original_method = "8E62ECEB973FF3825859D252B23F201A", hash_generated_method = "DD4F8C09FAEA2D18F0FF72A670B8FE04")
        @Override
        public Drawable newDrawable(Resources res) {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_1191929118 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1191929118 = new AnimatedRotateDrawable(this, res);
            addTaint(res.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1191929118.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1191929118;
            // ---------- Original Method ----------
            //return new AnimatedRotateDrawable(this, res);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.141 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "76986E96FEFD4A2AEE3B02151C801403")
        @Override
        public int getChangingConfigurations() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_89991484 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_89991484;
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.155 -0400", hash_original_method = "8D2A3A495FE794F654E28C73CF35A2A1", hash_generated_method = "090E8286E3BA19272CCAC54FFCB5932B")
        public boolean canConstantState() {
            {
                mCanConstantState = mDrawable.getConstantState() != null;
                mCheckedConstantState = true;
            } //End block
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1598915785 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1598915785;
            // ---------- Original Method ----------
            //if (!mCheckedConstantState) {
                //mCanConstantState = mDrawable.getConstantState() != null;
                //mCheckedConstantState = true;
            //}
            //return mCanConstantState;
        }

        
    }


    
}

