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
    private final AnimationState mAnimationState;
    private int mCurFrame = -1;
    private boolean mMutated;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:13.501 -0400", hash_original_method = "35EE0C4966C7CA57865D8E1E9DE06504", hash_generated_method = "EA138C3296A60428F0747CBD4F95142F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AnimationDrawable() {
        this(null, null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:13.583 -0400", hash_original_method = "586B7D97991AD2B5DDF2BA28DAD874F2", hash_generated_method = "DC448AF8BE6177ECC1EFCB8B15654F7B")
    @DSModeled(DSC.SAFE)
    private AnimationDrawable(AnimationState state, Resources res) {
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(state.dsTaint);
        AnimationState as;
        as = new AnimationState(state, this, res);
        mAnimationState = as;
        setConstantState(as);
        {
            setFrame(0, true, false);
        } //End block
        // ---------- Original Method ----------
        //AnimationState as = new AnimationState(state, this, res);
        //mAnimationState = as;
        //setConstantState(as);
        //if (state != null) {
            //setFrame(0, true, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:13.720 -0400", hash_original_method = "F207A8C7EE9B62CDAD2CDEF6C9E1E05A", hash_generated_method = "06310F7ADF0D4803E34CA1D5571CC8C3")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean setVisible(boolean visible, boolean restart) {
        dsTaint.addTaint(restart);
        dsTaint.addTaint(visible);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:13.813 -0400", hash_original_method = "B2F55F064A30629408E9D67D650C8080", hash_generated_method = "E7E052E743374688A3E35CEECA5FA2D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void start() {
        {
            boolean var9DBCB1EE9690E5DFF394DFE3019DBEB0_585789536 = (!isRunning());
            {
                run();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!isRunning()) {
            //run();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:13.863 -0400", hash_original_method = "13ACD75B58E729F7C9E7DE6208579581", hash_generated_method = "CF6802D7C177210945325217ED7E9D95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void stop() {
        {
            boolean var1FD6FB112E1C2F6634A4DABBDA9265D9_1782175992 = (isRunning());
            {
                unscheduleSelf(this);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isRunning()) {
            //unscheduleSelf(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:13.895 -0400", hash_original_method = "58F8F26763BA19E1F1B373F32B389D6B", hash_generated_method = "B517D1E30D6551FF10D6A01FC45746CF")
    @DSModeled(DSC.SAFE)
    public boolean isRunning() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCurFrame > -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:13.916 -0400", hash_original_method = "B6B243EB70C5F724D188154EAF209167", hash_generated_method = "887C95D13C089BAEC75C06F89BAEE58C")
    @DSModeled(DSC.SAFE)
    public void run() {
        nextFrame(false);
        // ---------- Original Method ----------
        //nextFrame(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:13.959 -0400", hash_original_method = "A4EA0ABEB4B95482FCBDF5ED15C3D56A", hash_generated_method = "14A92214FDEE20CEDA9226CEA0507386")
    @DSModeled(DSC.SAFE)
    @Override
    public void unscheduleSelf(Runnable what) {
        dsTaint.addTaint(what.dsTaint);
        mCurFrame = -1;
        super.unscheduleSelf(what);
        // ---------- Original Method ----------
        //mCurFrame = -1;
        //super.unscheduleSelf(what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:13.967 -0400", hash_original_method = "078F231D1E4DEE307E947B896715B9FA", hash_generated_method = "B2C132B4656C6A89427D8DC4545199CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getNumberOfFrames() {
        int var2E5DD581DA9E7709CCEB84A19B8FCBC8_1690432718 = (mAnimationState.getChildCount());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mAnimationState.getChildCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:14.009 -0400", hash_original_method = "924497ADC8C942C05D9D7A5BCA11BCAD", hash_generated_method = "13F437569A4CDC3832018507BB9F8794")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Drawable getFrame(int index) {
        dsTaint.addTaint(index);
        Drawable var2052E66A9FA1EDBCA3C48737F8ABB9C7_1658851300 = (mAnimationState.getChildren()[index]);
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mAnimationState.getChildren()[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:14.036 -0400", hash_original_method = "F1980307C7F7FBBB813440E411F73714", hash_generated_method = "EF4C0D3B01685DBFD659790878813CF6")
    @DSModeled(DSC.SAFE)
    public int getDuration(int i) {
        dsTaint.addTaint(i);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mAnimationState.mDurations[i];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:14.058 -0400", hash_original_method = "F5C3EDF3EE4DBDBAFAA19B210BF98AFC", hash_generated_method = "636E69EC16CB75955C19C547D6E268FD")
    @DSModeled(DSC.SAFE)
    public boolean isOneShot() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAnimationState.mOneShot;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:14.085 -0400", hash_original_method = "E8F5482B51D48B1DAA2F24BE9877736B", hash_generated_method = "5E54A5D0BA0A8A00CDBB9A38F259409A")
    @DSModeled(DSC.SAFE)
    public void setOneShot(boolean oneShot) {
        dsTaint.addTaint(oneShot);
        mAnimationState.mOneShot = oneShot;
        // ---------- Original Method ----------
        //mAnimationState.mOneShot = oneShot;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:14.110 -0400", hash_original_method = "1C98A9B62B655827C0439A8A5D392C10", hash_generated_method = "777D81C5EB9F6C3A50B8A82A8C1CDCE0")
    @DSModeled(DSC.SAFE)
    public void addFrame(Drawable frame, int duration) {
        dsTaint.addTaint(duration);
        dsTaint.addTaint(frame.dsTaint);
        mAnimationState.addFrame(frame, duration);
        {
            setFrame(0, true, false);
        } //End block
        // ---------- Original Method ----------
        //mAnimationState.addFrame(frame, duration);
        //if (mCurFrame < 0) {
            //setFrame(0, true, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:14.169 -0400", hash_original_method = "5BF496D6A5AC4A1943AFC092E55892DA", hash_generated_method = "6D67BBEA09C6B8591C52E0CA9CEDFDE1")
    @DSModeled(DSC.SAFE)
    private void nextFrame(boolean unschedule) {
        dsTaint.addTaint(unschedule);
        int next;
        next = mCurFrame+1;
        final int N;
        N = mAnimationState.getChildCount();
        {
            next = 0;
        } //End block
        setFrame(next, unschedule, !mAnimationState.mOneShot || next < (N - 1));
        // ---------- Original Method ----------
        //int next = mCurFrame+1;
        //final int N = mAnimationState.getChildCount();
        //if (next >= N) {
            //next = 0;
        //}
        //setFrame(next, unschedule, !mAnimationState.mOneShot || next < (N - 1));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:14.256 -0400", hash_original_method = "B59ABD564D6BE8E67E70E520C58F1693", hash_generated_method = "AB30E453CE7E22E3B2DB071C0C39C684")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setFrame(int frame, boolean unschedule, boolean animate) {
        dsTaint.addTaint(frame);
        dsTaint.addTaint(animate);
        dsTaint.addTaint(unschedule);
        {
            boolean varA6C25A0F5E103E4859378F59ED342CD8_2115238949 = (frame >= mAnimationState.getChildCount());
        } //End collapsed parenthetic
        selectDrawable(frame);
        {
            unscheduleSelf(this);
        } //End block
        {
            scheduleSelf(this, SystemClock.uptimeMillis() + mAnimationState.mDurations[frame]);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:14.575 -0400", hash_original_method = "7089458E2F1E271024E158C172450FE4", hash_generated_method = "C356D98A2CA4E6B3AFF43E76D26EC971")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
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
        final int innerDepth;
        innerDepth = parser.getDepth()+1;
        int depth = 0;
        {
            boolean varB56CDBB38766BEA17078FA16D609B275_1064666759 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT &&
                ((depth = parser.getDepth()) >= innerDepth || type != XmlPullParser.END_TAG));
            {
                {
                    boolean var03C44ADC0346A0FD12ECFE38D2A0612F_5878531 = (depth > innerDepth || !parser.getName().equals("item"));
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
                        boolean var8369081016E1C7D2726F6A3629A921B6_1727723709 = ((type=parser.next()) == XmlPullParser.TEXT);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:14.636 -0400", hash_original_method = "91217E14A6A0FB93E4A43550FB5F1C23", hash_generated_method = "A30DE4175350D1286924E06970BF33F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Drawable mutate() {
        {
            boolean varC94B19053599294E7944C8C841976773_240923921 = (!mMutated && super.mutate() == this);
            {
                mAnimationState.mDurations = mAnimationState.mDurations.clone();
                mMutated = true;
            } //End block
        } //End collapsed parenthetic
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!mMutated && super.mutate() == this) {
            //mAnimationState.mDurations = mAnimationState.mDurations.clone();
            //mMutated = true;
        //}
        //return this;
    }

    
    private final static class AnimationState extends DrawableContainerState {
        private int[] mDurations;
        private boolean mOneShot;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:14.690 -0400", hash_original_method = "917C43EFB3C2CE5953BF86C61EBDB328", hash_generated_method = "467D5263A5557643C75841C9EFB255B0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         AnimationState(AnimationState orig, AnimationDrawable owner,
                Resources res) {
            super(orig, owner, res);
            dsTaint.addTaint(res.dsTaint);
            dsTaint.addTaint(owner.dsTaint);
            dsTaint.addTaint(orig.dsTaint);
            {
                mDurations = orig.mDurations;
                mOneShot = orig.mOneShot;
            } //End block
            {
                mDurations = new int[getChildren().length];
                mOneShot = true;
            } //End block
            // ---------- Original Method ----------
            //if (orig != null) {
                //mDurations = orig.mDurations;
                //mOneShot = orig.mOneShot;
            //} else {
                //mDurations = new int[getChildren().length];
                //mOneShot = true;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:14.725 -0400", hash_original_method = "8444C7122CB16D5313EA6D9A8D591DCE", hash_generated_method = "E8DDE9F9199FDC33186F0A915192EF07")
        @DSModeled(DSC.SAFE)
        @Override
        public Drawable newDrawable() {
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new AnimationDrawable(this, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:14.746 -0400", hash_original_method = "C298E1FF6FE04F3BBF8263AF38ED7861", hash_generated_method = "A7C2CBE8F945142C7649E626F735E7CC")
        @DSModeled(DSC.SAFE)
        @Override
        public Drawable newDrawable(Resources res) {
            dsTaint.addTaint(res.dsTaint);
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new AnimationDrawable(this, res);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:14.811 -0400", hash_original_method = "7FFF22B3EB022905B5691180A1C9266D", hash_generated_method = "76476F3A7AEC71B2EA7EFFB099542E21")
        @DSModeled(DSC.SAFE)
        public void addFrame(Drawable dr, int dur) {
            dsTaint.addTaint(dur);
            dsTaint.addTaint(dr.dsTaint);
            int pos;
            pos = super.addChild(dr);
            mDurations[pos] = dur;
            // ---------- Original Method ----------
            //int pos = super.addChild(dr);
            //mDurations[pos] = dur;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:14.859 -0400", hash_original_method = "280320AC02B6789F88426235E202F89A", hash_generated_method = "D41E6D7BA9D645F0B7DD9D2A19966528")
        @DSModeled(DSC.SAFE)
        @Override
        public void growArray(int oldSize, int newSize) {
            dsTaint.addTaint(oldSize);
            dsTaint.addTaint(newSize);
            super.growArray(oldSize, newSize);
            int[] newDurations;
            newDurations = new int[newSize];
            System.arraycopy(mDurations, 0, newDurations, 0, oldSize);
            mDurations = newDurations;
            // ---------- Original Method ----------
            //super.growArray(oldSize, newSize);
            //int[] newDurations = new int[newSize];
            //System.arraycopy(mDurations, 0, newDurations, 0, oldSize);
            //mDurations = newDurations;
        }

        
    }


    
}


