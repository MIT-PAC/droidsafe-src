package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.SystemClock;
import android.util.AttributeSet;

public class AnimationDrawable extends DrawableContainer implements Runnable, Animatable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.932 -0400", hash_original_field = "3405E3C097684DA39297C61B3FBF4BCE", hash_generated_field = "8C9FC3EF51CD1D7374A26DD8B125CA14")

    private AnimationState mAnimationState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.932 -0400", hash_original_field = "FCF69B1AF5E19505D1E496A0EC6D6768", hash_generated_field = "93D0C0F4C52876AB706915475617A386")

    private int mCurFrame = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.933 -0400", hash_original_field = "9FB80C30383848C8D006680B5F3BDAF9", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.933 -0400", hash_original_method = "35EE0C4966C7CA57865D8E1E9DE06504", hash_generated_method = "86EDDFEE2C351DEF5FE882A4933337FE")
    public  AnimationDrawable() {
        this(null, null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.936 -0400", hash_original_method = "586B7D97991AD2B5DDF2BA28DAD874F2", hash_generated_method = "5F3E65F8077205A430BAA79E56A40C2D")
    private  AnimationDrawable(AnimationState state, Resources res) {
        AnimationState as;
        as = new AnimationState(state, this, res);
        mAnimationState = as;
        setConstantState(as);
        {
            setFrame(0, true, false);
        } //End block
        addTaint(state.getTaint());
        addTaint(res.getTaint());
        // ---------- Original Method ----------
        //AnimationState as = new AnimationState(state, this, res);
        //mAnimationState = as;
        //setConstantState(as);
        //if (state != null) {
            //setFrame(0, true, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.938 -0400", hash_original_method = "F207A8C7EE9B62CDAD2CDEF6C9E1E05A", hash_generated_method = "BD60CD8B85EE2EFC1E3202C044CEE740")
    @Override
    public boolean setVisible(boolean visible, boolean restart) {
        boolean changed;
        changed = super.setVisible(visible, restart);
        {
            {
                setFrame(0, true, true);
            } //End block
        } //End block
        {
            unscheduleSelf(this);
        } //End block
        addTaint(visible);
        addTaint(restart);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_265998369 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_265998369;
        // ---------- Original Method ----------
        //boolean changed = super.setVisible(visible, restart);
        //if (visible) {
            //if (changed || restart) {
                //setFrame(0, true, true);
            //}
        //} else {
            //unscheduleSelf(this);
        //}
        //return changed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.941 -0400", hash_original_method = "B2F55F064A30629408E9D67D650C8080", hash_generated_method = "9EF73A5A88E435581E8EC02D715E3651")
    public void start() {
        {
            boolean var9DBCB1EE9690E5DFF394DFE3019DBEB0_1313547421 = (!isRunning());
            {
                run();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!isRunning()) {
            //run();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.941 -0400", hash_original_method = "13ACD75B58E729F7C9E7DE6208579581", hash_generated_method = "9CAD406BAC60A2CDC9967F7C8E8E0D03")
    public void stop() {
        {
            boolean var1FD6FB112E1C2F6634A4DABBDA9265D9_1961485696 = (isRunning());
            {
                unscheduleSelf(this);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isRunning()) {
            //unscheduleSelf(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.963 -0400", hash_original_method = "58F8F26763BA19E1F1B373F32B389D6B", hash_generated_method = "37E386DDFD1D5D2E043C456452BD823B")
    public boolean isRunning() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1351864751 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1351864751;
        // ---------- Original Method ----------
        //return mCurFrame > -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.964 -0400", hash_original_method = "B6B243EB70C5F724D188154EAF209167", hash_generated_method = "B68A4DACC752E288041F7CFA46B6D54E")
    public void run() {
        nextFrame(false);
        // ---------- Original Method ----------
        //nextFrame(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.986 -0400", hash_original_method = "A4EA0ABEB4B95482FCBDF5ED15C3D56A", hash_generated_method = "8F909239744731666C82AEA4198A3EE7")
    @Override
    public void unscheduleSelf(Runnable what) {
        mCurFrame = -1;
        super.unscheduleSelf(what);
        addTaint(what.getTaint());
        // ---------- Original Method ----------
        //mCurFrame = -1;
        //super.unscheduleSelf(what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.987 -0400", hash_original_method = "078F231D1E4DEE307E947B896715B9FA", hash_generated_method = "CCA68739E5031C0F0BC4A8128919C972")
    public int getNumberOfFrames() {
        int var2E5DD581DA9E7709CCEB84A19B8FCBC8_502291858 = (mAnimationState.getChildCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1520432585 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1520432585;
        // ---------- Original Method ----------
        //return mAnimationState.getChildCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.995 -0400", hash_original_method = "924497ADC8C942C05D9D7A5BCA11BCAD", hash_generated_method = "B8CCD002681FA7C5F39D33094A7BD1F2")
    public Drawable getFrame(int index) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_204305637 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_204305637 = mAnimationState.getChildren()[index];
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_204305637.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_204305637;
        // ---------- Original Method ----------
        //return mAnimationState.getChildren()[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.995 -0400", hash_original_method = "F1980307C7F7FBBB813440E411F73714", hash_generated_method = "3C1EE7133EF4FE96EF4065CE682E6936")
    public int getDuration(int i) {
        addTaint(i);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1948962536 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1948962536;
        // ---------- Original Method ----------
        //return mAnimationState.mDurations[i];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.996 -0400", hash_original_method = "F5C3EDF3EE4DBDBAFAA19B210BF98AFC", hash_generated_method = "9FDA91A0BF52949BCDD461B33F82271D")
    public boolean isOneShot() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_334448131 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_334448131;
        // ---------- Original Method ----------
        //return mAnimationState.mOneShot;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.997 -0400", hash_original_method = "E8F5482B51D48B1DAA2F24BE9877736B", hash_generated_method = "323509116D1A453EB4E6DE2EBA7CA601")
    public void setOneShot(boolean oneShot) {
        mAnimationState.mOneShot = oneShot;
        // ---------- Original Method ----------
        //mAnimationState.mOneShot = oneShot;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.020 -0400", hash_original_method = "1C98A9B62B655827C0439A8A5D392C10", hash_generated_method = "49C57D466235A85405B45BDFE28239E3")
    public void addFrame(Drawable frame, int duration) {
        mAnimationState.addFrame(frame, duration);
        {
            setFrame(0, true, false);
        } //End block
        addTaint(frame.getTaint());
        addTaint(duration);
        // ---------- Original Method ----------
        //mAnimationState.addFrame(frame, duration);
        //if (mCurFrame < 0) {
            //setFrame(0, true, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.029 -0400", hash_original_method = "5BF496D6A5AC4A1943AFC092E55892DA", hash_generated_method = "55EEEB58CD9BE4A916D324CE017E5554")
    private void nextFrame(boolean unschedule) {
        int next;
        next = mCurFrame+1;
        int N;
        N = mAnimationState.getChildCount();
        {
            next = 0;
        } //End block
        setFrame(next, unschedule, !mAnimationState.mOneShot || next < (N - 1));
        addTaint(unschedule);
        // ---------- Original Method ----------
        //int next = mCurFrame+1;
        //final int N = mAnimationState.getChildCount();
        //if (next >= N) {
            //next = 0;
        //}
        //setFrame(next, unschedule, !mAnimationState.mOneShot || next < (N - 1));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.030 -0400", hash_original_method = "B59ABD564D6BE8E67E70E520C58F1693", hash_generated_method = "CE53AB1C622F38A27A8B0714A6D3FD92")
    private void setFrame(int frame, boolean unschedule, boolean animate) {
        {
            boolean varA6C25A0F5E103E4859378F59ED342CD8_89409955 = (frame >= mAnimationState.getChildCount());
        } //End collapsed parenthetic
        mCurFrame = frame;
        selectDrawable(frame);
        {
            unscheduleSelf(this);
        } //End block
        {
            scheduleSelf(this, SystemClock.uptimeMillis() + mAnimationState.mDurations[frame]);
        } //End block
        addTaint(unschedule);
        addTaint(animate);
        // ---------- Original Method ----------
        //if (frame >= mAnimationState.getChildCount()) {
            //return;
        //}
        //mCurFrame = frame;
        //selectDrawable(frame);
        //if (unschedule) {
            //unscheduleSelf(this);
        //}
        //if (animate) {
            //scheduleSelf(this, SystemClock.uptimeMillis() + mAnimationState.mDurations[frame]);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.058 -0400", hash_original_method = "7089458E2F1E271024E158C172450FE4", hash_generated_method = "24AB06E0EDE206D802B270F9393DE800")
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        TypedArray a;
        a = r.obtainAttributes(attrs,
                com.android.internal.R.styleable.AnimationDrawable);
        super.inflateWithAttributes(r, parser, a,
                com.android.internal.R.styleable.AnimationDrawable_visible);
        mAnimationState.setVariablePadding(a.getBoolean(
                com.android.internal.R.styleable.AnimationDrawable_variablePadding, false));
        mAnimationState.mOneShot = a.getBoolean(
                com.android.internal.R.styleable.AnimationDrawable_oneshot, false);
        a.recycle();
        int type;
        int innerDepth;
        innerDepth = parser.getDepth()+1;
        int depth;
        {
            boolean varB56CDBB38766BEA17078FA16D609B275_1735454723 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT &&
                ((depth = parser.getDepth()) >= innerDepth || type != XmlPullParser.END_TAG));
            {
                {
                    boolean var03C44ADC0346A0FD12ECFE38D2A0612F_2096140288 = (depth > innerDepth || !parser.getName().equals("item"));
                } //End collapsed parenthetic
                a = r.obtainAttributes(attrs, com.android.internal.R.styleable.AnimationDrawableItem);
                int duration;
                duration = a.getInt(
                    com.android.internal.R.styleable.AnimationDrawableItem_duration, -1);
                {
                    if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                        parser.getPositionDescription()
                        + ": <item> tag requires a 'duration' attribute");
                } //End block
                int drawableRes;
                drawableRes = a.getResourceId(
                    com.android.internal.R.styleable.AnimationDrawableItem_drawable, 0);
                a.recycle();
                Drawable dr;
                {
                    dr = r.getDrawable(drawableRes);
                } //End block
                {
                    {
                        boolean var8369081016E1C7D2726F6A3629A921B6_1431611363 = ((type=parser.next()) == XmlPullParser.TEXT);
                    } //End collapsed parenthetic
                    {
                        if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(parser.getPositionDescription() +
                            ": <item> tag requires a 'drawable' attribute or child tag" +
                            " defining a drawable");
                    } //End block
                    dr = Drawable.createFromXmlInner(r, parser, attrs);
                } //End block
                mAnimationState.addFrame(dr, duration);
                {
                    dr.setCallback(this);
                } //End block
            } //End block
        } //End collapsed parenthetic
        setFrame(0, true, false);
        addTaint(r.getTaint());
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.067 -0400", hash_original_method = "91217E14A6A0FB93E4A43550FB5F1C23", hash_generated_method = "9742EE920ED149AB99808FD9CBDC610D")
    @Override
    public Drawable mutate() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_281848125 = null; //Variable for return #1
        {
            boolean varC94B19053599294E7944C8C841976773_1963165405 = (!mMutated && super.mutate() == this);
            {
                mAnimationState.mDurations = mAnimationState.mDurations.clone();
                mMutated = true;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_281848125 = this;
        varB4EAC82CA7396A68D541C85D26508E83_281848125.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_281848125;
        // ---------- Original Method ----------
        //if (!mMutated && super.mutate() == this) {
            //mAnimationState.mDurations = mAnimationState.mDurations.clone();
            //mMutated = true;
        //}
        //return this;
    }

    
    private final static class AnimationState extends DrawableContainerState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.067 -0400", hash_original_field = "29E02C393EBF8D36CFECC064EFDF29CA", hash_generated_field = "8BD7F9CC97F6F0855D8F3C7E2109665D")

        private int[] mDurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.067 -0400", hash_original_field = "BFA6EEFE0C30E0A93CA19234400247B7", hash_generated_field = "90E32900694EFB9D3548ACF4940301BF")

        private boolean mOneShot;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.068 -0400", hash_original_method = "917C43EFB3C2CE5953BF86C61EBDB328", hash_generated_method = "7A1D1A58063C2C8919A3016E26E20E96")
          AnimationState(AnimationState orig, AnimationDrawable owner,
                Resources res) {
            super(orig, owner, res);
            {
                mDurations = orig.mDurations;
                mOneShot = orig.mOneShot;
            } //End block
            {
                mDurations = new int[getChildren().length];
                mOneShot = true;
            } //End block
            addTaint(owner.getTaint());
            addTaint(res.getTaint());
            // ---------- Original Method ----------
            //if (orig != null) {
                //mDurations = orig.mDurations;
                //mOneShot = orig.mOneShot;
            //} else {
                //mDurations = new int[getChildren().length];
                //mOneShot = true;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.087 -0400", hash_original_method = "8444C7122CB16D5313EA6D9A8D591DCE", hash_generated_method = "A3BDD0CE5D3384883E674880B55B4800")
        @Override
        public Drawable newDrawable() {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_1638889958 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1638889958 = new AnimationDrawable(this, null);
            varB4EAC82CA7396A68D541C85D26508E83_1638889958.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1638889958;
            // ---------- Original Method ----------
            //return new AnimationDrawable(this, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.088 -0400", hash_original_method = "C298E1FF6FE04F3BBF8263AF38ED7861", hash_generated_method = "CF779AB530AA5D69E7AA32244612528B")
        @Override
        public Drawable newDrawable(Resources res) {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_1316698176 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1316698176 = new AnimationDrawable(this, res);
            addTaint(res.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1316698176.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1316698176;
            // ---------- Original Method ----------
            //return new AnimationDrawable(this, res);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.089 -0400", hash_original_method = "7FFF22B3EB022905B5691180A1C9266D", hash_generated_method = "803E240F9E233E1C5F790A6EA5BB3A46")
        public void addFrame(Drawable dr, int dur) {
            int pos;
            pos = super.addChild(dr);
            mDurations[pos] = dur;
            addTaint(dr.getTaint());
            // ---------- Original Method ----------
            //int pos = super.addChild(dr);
            //mDurations[pos] = dur;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.090 -0400", hash_original_method = "280320AC02B6789F88426235E202F89A", hash_generated_method = "26A317E57B4E7602475A18C7D768AFDA")
        @Override
        public void growArray(int oldSize, int newSize) {
            super.growArray(oldSize, newSize);
            int[] newDurations;
            newDurations = new int[newSize];
            System.arraycopy(mDurations, 0, newDurations, 0, oldSize);
            mDurations = newDurations;
            addTaint(oldSize);
            addTaint(newSize);
            // ---------- Original Method ----------
            //super.growArray(oldSize, newSize);
            //int[] newDurations = new int[newSize];
            //System.arraycopy(mDurations, 0, newDurations, 0, oldSize);
            //mDurations = newDurations;
        }

        
    }


    
}

