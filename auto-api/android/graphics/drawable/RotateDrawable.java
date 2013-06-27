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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.031 -0400", hash_original_field = "48A902C1D749B47EBC75C77370D5A1F0", hash_generated_field = "6525A0317A729C6A21603F930B262102")

    private RotateState mState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.031 -0400", hash_original_field = "9FB80C30383848C8D006680B5F3BDAF9", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.047 -0400", hash_original_method = "D68BBF88E63BC402EDEA5DC6DCE17035", hash_generated_method = "11900DAE62AC2CC48BD0D9D71B368CB1")
    public  RotateDrawable() {
        this(null, null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.049 -0400", hash_original_method = "995C0E9A95F93D2E12F98717831D2FCB", hash_generated_method = "DDDE6149D3CE02B80BFFE97CEC56A3B9")
    private  RotateDrawable(RotateState rotateState, Resources res) {
        mState = new RotateState(rotateState, this, res);
        // ---------- Original Method ----------
        //mState = new RotateState(rotateState, this, res);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.070 -0400", hash_original_method = "66E42D309847A2E591E14284403E0AD8", hash_generated_method = "8B844E7C92DB0727B2521E6E15A179F2")
    public void draw(Canvas canvas) {
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
        addTaint(canvas.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.076 -0400", hash_original_method = "CE08CCF44A5C011BE03C2CE7D256555D", hash_generated_method = "149D3AFEF63F5F03E7E6485D89D61CE0")
    public Drawable getDrawable() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_11782414 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_11782414 = mState.mDrawable;
        varB4EAC82CA7396A68D541C85D26508E83_11782414.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_11782414;
        // ---------- Original Method ----------
        //return mState.mDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.079 -0400", hash_original_method = "1BF1269A7F11A078222AE5900C6EC170", hash_generated_method = "57851EEC9B01C134CA641761F480A4E6")
    @Override
    public int getChangingConfigurations() {
        int var0FF1530E46268DA64EFCE0D0E400E8C4_1529684777 = (super.getChangingConfigurations()
                | mState.mChangingConfigurations
                | mState.mDrawable.getChangingConfigurations());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1500943175 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1500943175;
        // ---------- Original Method ----------
        //return super.getChangingConfigurations()
                //| mState.mChangingConfigurations
                //| mState.mDrawable.getChangingConfigurations();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.090 -0400", hash_original_method = "E07BF10440452C45B5D504184A6B58C8", hash_generated_method = "3AFBA9D32163C6E692886F65C6D62B09")
    public void setAlpha(int alpha) {
        mState.mDrawable.setAlpha(alpha);
        addTaint(alpha);
        // ---------- Original Method ----------
        //mState.mDrawable.setAlpha(alpha);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.092 -0400", hash_original_method = "6C570D1758B788EA390E83E99A76EB36", hash_generated_method = "FDF85341B55FAE09CB02C13E5DED17EE")
    public void setColorFilter(ColorFilter cf) {
        mState.mDrawable.setColorFilter(cf);
        addTaint(cf.getTaint());
        // ---------- Original Method ----------
        //mState.mDrawable.setColorFilter(cf);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.105 -0400", hash_original_method = "7CC935EC38A8A9ED900F61C0DE237712", hash_generated_method = "A9BEFE6330CB447ED011C066648E6BA7")
    public int getOpacity() {
        int var208671101B6F4CE4F7912D03727B9ECD_416466272 = (mState.mDrawable.getOpacity());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_96081744 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_96081744;
        // ---------- Original Method ----------
        //return mState.mDrawable.getOpacity();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.105 -0400", hash_original_method = "289E4B14FC4BAEE8FBED5C03A1D9B634", hash_generated_method = "8C74E1ED724AA0C6A0C97462CE6BFB75")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.106 -0400", hash_original_method = "A01CAF97CFFAA14450A9600E14E88C8D", hash_generated_method = "D0BA170008FFB5E5F5CAA53137A69B81")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.130 -0400", hash_original_method = "CA144C86313E3C1A3DC044F014305D8E", hash_generated_method = "F27A8BA34D960AEC80EA06B1020FC534")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.131 -0400", hash_original_method = "02BC41BDC3ED3CF2C30379FA10185DFA", hash_generated_method = "CE74B83B1D1559DA7E792BC4DF2C1F4D")
    @Override
    public boolean getPadding(Rect padding) {
        boolean varC7A533DDD324CE8744300E8FF1B02882_933586974 = (mState.mDrawable.getPadding(padding));
        addTaint(padding.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1603937407 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1603937407;
        // ---------- Original Method ----------
        //return mState.mDrawable.getPadding(padding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.131 -0400", hash_original_method = "BD39509C4CE6111239623166AC9A09DC", hash_generated_method = "074C680CCD05029ECABAB741C6A265F5")
    @Override
    public boolean setVisible(boolean visible, boolean restart) {
        mState.mDrawable.setVisible(visible, restart);
        boolean var9D015C67047440F1849257F892B1DD1F_1011483324 = (super.setVisible(visible, restart));
        addTaint(visible);
        addTaint(restart);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1518994100 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1518994100;
        // ---------- Original Method ----------
        //mState.mDrawable.setVisible(visible, restart);
        //return super.setVisible(visible, restart);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.132 -0400", hash_original_method = "6F66CB18BCF39D7C34F81BD35385E69D", hash_generated_method = "0F48FAF433C97FE221E1741B255DCE5F")
    @Override
    public boolean isStateful() {
        boolean var49A6E47C93BCE92CD66848492C5DEB16_1965441942 = (mState.mDrawable.isStateful());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1186138454 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1186138454;
        // ---------- Original Method ----------
        //return mState.mDrawable.isStateful();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.132 -0400", hash_original_method = "7EB4BF4364E02A64D78830D58D97433D", hash_generated_method = "E4881F994C642642A54C4D4568A1E1E1")
    @Override
    protected boolean onStateChange(int[] state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        boolean changed;
        changed = mState.mDrawable.setState(state);
        onBoundsChange(getBounds());
        addTaint(state[0]);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1208686529 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1208686529;
        // ---------- Original Method ----------
        //boolean changed = mState.mDrawable.setState(state);
        //onBoundsChange(getBounds());
        //return changed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.152 -0400", hash_original_method = "83ABEEB83DB924D066F2C024127658DA", hash_generated_method = "D9F82544A4B228E257D9D103B98536D8")
    @Override
    protected boolean onLevelChange(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mState.mDrawable.setLevel(level);
        onBoundsChange(getBounds());
        mState.mCurrentDegrees = mState.mFromDegrees +
                (mState.mToDegrees - mState.mFromDegrees) *
                        ((float) level / MAX_LEVEL);
        invalidateSelf();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_237103495 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_237103495;
        // ---------- Original Method ----------
        //mState.mDrawable.setLevel(level);
        //onBoundsChange(getBounds());
        //mState.mCurrentDegrees = mState.mFromDegrees +
                //(mState.mToDegrees - mState.mFromDegrees) *
                        //((float) level / MAX_LEVEL);
        //invalidateSelf();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.152 -0400", hash_original_method = "EF65F96F81169D8EC042745FACAE10FF", hash_generated_method = "725A4580427364ED0C788713F8BA39CF")
    @Override
    protected void onBoundsChange(Rect bounds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mState.mDrawable.setBounds(bounds.left, bounds.top,
                bounds.right, bounds.bottom);
        addTaint(bounds.getTaint());
        // ---------- Original Method ----------
        //mState.mDrawable.setBounds(bounds.left, bounds.top,
                //bounds.right, bounds.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.163 -0400", hash_original_method = "5B4218C80F47B6E11FBBAA9FF9621C9F", hash_generated_method = "87F675248B70FAB2093750FCD1202712")
    @Override
    public int getIntrinsicWidth() {
        int varF0E785BE9442695B8C554DDF53D66DF4_1828426920 = (mState.mDrawable.getIntrinsicWidth());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_225404196 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_225404196;
        // ---------- Original Method ----------
        //return mState.mDrawable.getIntrinsicWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.179 -0400", hash_original_method = "D5692643A14F3CC0D08138E7C727B99D", hash_generated_method = "BF2C0CC8A1427EDC8BAE8593C50154B5")
    @Override
    public int getIntrinsicHeight() {
        int var740C212F7282B7300448D928B6215BB6_270607438 = (mState.mDrawable.getIntrinsicHeight());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_661488636 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_661488636;
        // ---------- Original Method ----------
        //return mState.mDrawable.getIntrinsicHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.180 -0400", hash_original_method = "810CA52F78245136A3D7374C4FDCA32A", hash_generated_method = "4090839C33B7C03DF6E5FF87E7988D2F")
    @Override
    public ConstantState getConstantState() {
        ConstantState varB4EAC82CA7396A68D541C85D26508E83_2002899796 = null; //Variable for return #1
        ConstantState varB4EAC82CA7396A68D541C85D26508E83_1292239316 = null; //Variable for return #2
        {
            boolean var80BE086B3CF987C8B4EA155D5304638A_1686447343 = (mState.canConstantState());
            {
                mState.mChangingConfigurations = getChangingConfigurations();
                varB4EAC82CA7396A68D541C85D26508E83_2002899796 = mState;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1292239316 = null;
        ConstantState varA7E53CE21691AB073D9660D615818899_1647313841; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1647313841 = varB4EAC82CA7396A68D541C85D26508E83_2002899796;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1647313841 = varB4EAC82CA7396A68D541C85D26508E83_1292239316;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1647313841.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1647313841;
        // ---------- Original Method ----------
        //if (mState.canConstantState()) {
            //mState.mChangingConfigurations = getChangingConfigurations();
            //return mState;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.208 -0400", hash_original_method = "A81455DB3DC70DF6E6044DAADCB89002", hash_generated_method = "E4A29F2E0546F1AF02AADAA5A395B549")
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
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
            boolean varC141F9598534BC349F58FDDEEA6C1DB7_110311834 = ((type = parser.next()) != XmlPullParser.END_DOCUMENT &&
               (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth));
            {
                {
                    boolean var24A02A5F6DE110121BAFDE44AC7A8F0C_513945970 = ((drawable = Drawable.createFromXmlInner(r, parser, attrs)) == null);
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
        addTaint(r.getTaint());
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.217 -0400", hash_original_method = "1ABB3B56372A1EBF2E80045724D492E3", hash_generated_method = "2EE6A8DCC923CB53DCFF27813211F1DE")
    @Override
    public Drawable mutate() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1951247977 = null; //Variable for return #1
        {
            boolean varC94B19053599294E7944C8C841976773_42604850 = (!mMutated && super.mutate() == this);
            {
                mState.mDrawable.mutate();
                mMutated = true;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1951247977 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1951247977.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1951247977;
        // ---------- Original Method ----------
        //if (!mMutated && super.mutate() == this) {
            //mState.mDrawable.mutate();
            //mMutated = true;
        //}
        //return this;
    }

    
    final static class RotateState extends Drawable.ConstantState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.218 -0400", hash_original_field = "D548B27C6AC66A9D9B5D05ED35C2D844", hash_generated_field = "38BA53DD394F85639C99ED8E666FF8FB")

        Drawable mDrawable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.218 -0400", hash_original_field = "276E0645C4E2084773D0EB8C5576428C", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.218 -0400", hash_original_field = "7F7BDD395B2683F1C3CE6FF4D28782A1", hash_generated_field = "C85378C704A40C3EFC15605BD9C2CCB0")

        boolean mPivotXRel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.218 -0400", hash_original_field = "D66A9F2EFD98D68E75A6EA9E5E5D83DE", hash_generated_field = "5936761CCB9106C6D82A6436A57EC343")

        float mPivotX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.218 -0400", hash_original_field = "71E602433C1B915117E3827218A7F552", hash_generated_field = "4EE5D55A1588E348C8DE32B74EC377A0")

        boolean mPivotYRel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.218 -0400", hash_original_field = "0AD24014D3E582A643E83C27A45B1B51", hash_generated_field = "6CE864DEEFD86BFE91AA6D818A7F55C0")

        float mPivotY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.218 -0400", hash_original_field = "A15722F5083687A94AEBECFD3C44711E", hash_generated_field = "179D120EA21717CC6A9EB6675A09E18B")

        float mFromDegrees;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.218 -0400", hash_original_field = "F12DDB33947BE4AD8AACC9EB5D42D418", hash_generated_field = "D04BBDA5B46FF274C82326C147187C72")

        float mToDegrees;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.218 -0400", hash_original_field = "A400194F6090059653517E4AAABDEC7F", hash_generated_field = "EF0BD8ADAC303B1287CF1584E5AA1EDB")

        float mCurrentDegrees;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.218 -0400", hash_original_field = "7C8FD9809F31C20B8422D623B0EC0C4F", hash_generated_field = "F62F8D22C4EDE8B8E63C376677BD915C")

        private boolean mCanConstantState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.219 -0400", hash_original_field = "2E319D4D352B34E33CF19129B7212FC6", hash_generated_field = "63D49323436A33301C0DA6EDF88627FF")

        private boolean mCheckedConstantState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.237 -0400", hash_original_method = "E49363C9B9277E418FC0CB021F74A645", hash_generated_method = "A73888FB168FDEBC06E52F115FC78B07")
        public  RotateState(RotateState source, RotateDrawable owner, Resources res) {
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
                //mFromDegrees = mCurrentDegrees = source.mFromDegrees;
                //mToDegrees = source.mToDegrees;
                //mCanConstantState = mCheckedConstantState = true;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.237 -0400", hash_original_method = "9DE14D671D62BC2F01E2871493505073", hash_generated_method = "3BF2CBB5EB4CF9DD9458F50A5C6CB453")
        @Override
        public Drawable newDrawable() {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_883629539 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_883629539 = new RotateDrawable(this, null);
            varB4EAC82CA7396A68D541C85D26508E83_883629539.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_883629539;
            // ---------- Original Method ----------
            //return new RotateDrawable(this, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.251 -0400", hash_original_method = "3300EE781F91D7B956F1DECE09B43C56", hash_generated_method = "FA64EBD0759AA1A984256E94469E429E")
        @Override
        public Drawable newDrawable(Resources res) {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_1050877079 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1050877079 = new RotateDrawable(this, res);
            addTaint(res.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1050877079.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1050877079;
            // ---------- Original Method ----------
            //return new RotateDrawable(this, res);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.252 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "A1296EAADC47B46118AEF327E77E56E8")
        @Override
        public int getChangingConfigurations() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_87055686 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_87055686;
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.253 -0400", hash_original_method = "8D2A3A495FE794F654E28C73CF35A2A1", hash_generated_method = "996728AD96BF7E04D2A639E6EDCCF832")
        public boolean canConstantState() {
            {
                mCanConstantState = mDrawable.getConstantState() != null;
                mCheckedConstantState = true;
            } //End block
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1463983598 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1463983598;
            // ---------- Original Method ----------
            //if (!mCheckedConstantState) {
                //mCanConstantState = mDrawable.getConstantState() != null;
                //mCheckedConstantState = true;
            //}
            //return mCanConstantState;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.253 -0400", hash_original_field = "DB3C5D7FA107BF253D250628420EA38F", hash_generated_field = "D2D93D89AD92097ED0ADB8112BF087D7")

    private static float MAX_LEVEL = 10000.0f;
}

