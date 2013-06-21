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
    private AnimationState mAnimationState;
    private int mCurFrame = -1;
    private boolean mMutated;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.882 -0400", hash_original_method = "35EE0C4966C7CA57865D8E1E9DE06504", hash_generated_method = "86EDDFEE2C351DEF5FE882A4933337FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AnimationDrawable() {
        this(null, null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.883 -0400", hash_original_method = "586B7D97991AD2B5DDF2BA28DAD874F2", hash_generated_method = "03E6EEB84987063D309D5B55621B3604")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.883 -0400", hash_original_method = "F207A8C7EE9B62CDAD2CDEF6C9E1E05A", hash_generated_method = "87FF73D880D08B158E19A98360A48433")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.883 -0400", hash_original_method = "B2F55F064A30629408E9D67D650C8080", hash_generated_method = "F40058535F2E3B7BA0D3022B9CFA87E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void start() {
        {
            boolean var9DBCB1EE9690E5DFF394DFE3019DBEB0_491016091 = (!isRunning());
            {
                run();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!isRunning()) {
            //run();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.884 -0400", hash_original_method = "13ACD75B58E729F7C9E7DE6208579581", hash_generated_method = "915964BFDF456E57F4FA4780B4927830")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void stop() {
        {
            boolean var1FD6FB112E1C2F6634A4DABBDA9265D9_1033331562 = (isRunning());
            {
                unscheduleSelf(this);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isRunning()) {
            //unscheduleSelf(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.884 -0400", hash_original_method = "58F8F26763BA19E1F1B373F32B389D6B", hash_generated_method = "42FCC4CDB898072BEFCDA23F66277D99")
    @DSModeled(DSC.SAFE)
    public boolean isRunning() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCurFrame > -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.884 -0400", hash_original_method = "B6B243EB70C5F724D188154EAF209167", hash_generated_method = "B68A4DACC752E288041F7CFA46B6D54E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void run() {
        nextFrame(false);
        // ---------- Original Method ----------
        //nextFrame(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.884 -0400", hash_original_method = "A4EA0ABEB4B95482FCBDF5ED15C3D56A", hash_generated_method = "83EDFC2BD01089C733731417513F29E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void unscheduleSelf(Runnable what) {
        dsTaint.addTaint(what.dsTaint);
        mCurFrame = -1;
        super.unscheduleSelf(what);
        // ---------- Original Method ----------
        //mCurFrame = -1;
        //super.unscheduleSelf(what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.885 -0400", hash_original_method = "078F231D1E4DEE307E947B896715B9FA", hash_generated_method = "C2E9EAAC6BFC7E613A3F447C7FD5B07F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getNumberOfFrames() {
        int var2E5DD581DA9E7709CCEB84A19B8FCBC8_192835059 = (mAnimationState.getChildCount());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mAnimationState.getChildCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.885 -0400", hash_original_method = "924497ADC8C942C05D9D7A5BCA11BCAD", hash_generated_method = "B9B226726498AF5C7EF1B8137AC52E91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Drawable getFrame(int index) {
        dsTaint.addTaint(index);
        Drawable var2052E66A9FA1EDBCA3C48737F8ABB9C7_218143649 = (mAnimationState.getChildren()[index]);
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mAnimationState.getChildren()[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.885 -0400", hash_original_method = "F1980307C7F7FBBB813440E411F73714", hash_generated_method = "B35927D354F2EFE601D92A2D17EFF2EC")
    @DSModeled(DSC.SAFE)
    public int getDuration(int i) {
        dsTaint.addTaint(i);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mAnimationState.mDurations[i];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.885 -0400", hash_original_method = "F5C3EDF3EE4DBDBAFAA19B210BF98AFC", hash_generated_method = "B0B2BEE00FEC0F8150F6581BA8A5F06A")
    @DSModeled(DSC.SAFE)
    public boolean isOneShot() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAnimationState.mOneShot;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.886 -0400", hash_original_method = "E8F5482B51D48B1DAA2F24BE9877736B", hash_generated_method = "AB1CACA9B2C1FE2545DEEB6E717928D0")
    @DSModeled(DSC.SAFE)
    public void setOneShot(boolean oneShot) {
        dsTaint.addTaint(oneShot);
        mAnimationState.mOneShot = oneShot;
        // ---------- Original Method ----------
        //mAnimationState.mOneShot = oneShot;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.886 -0400", hash_original_method = "1C98A9B62B655827C0439A8A5D392C10", hash_generated_method = "A43666D363BAAEF4C38125C7FAE85BA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.887 -0400", hash_original_method = "5BF496D6A5AC4A1943AFC092E55892DA", hash_generated_method = "F8AF647044223C5E5FD1AD045DDDA879")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nextFrame(boolean unschedule) {
        dsTaint.addTaint(unschedule);
        int next;
        next = mCurFrame+1;
        int N;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.888 -0400", hash_original_method = "B59ABD564D6BE8E67E70E520C58F1693", hash_generated_method = "F5CBD3087ED42F5D2DC67E6CAB134C5D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setFrame(int frame, boolean unschedule, boolean animate) {
        dsTaint.addTaint(animate);
        dsTaint.addTaint(frame);
        dsTaint.addTaint(unschedule);
        {
            boolean varA6C25A0F5E103E4859378F59ED342CD8_1718981443 = (frame >= mAnimationState.getChildCount());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.889 -0400", hash_original_method = "7089458E2F1E271024E158C172450FE4", hash_generated_method = "7871BA9738C99217E3247AF940E7A43A")
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
        int innerDepth;
        innerDepth = parser.getDepth()+1;
        int depth;
        {
            boolean varB56CDBB38766BEA17078FA16D609B275_1473256315 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT &&
                ((depth = parser.getDepth()) >= innerDepth || type != XmlPullParser.END_TAG));
            {
                {
                    boolean var03C44ADC0346A0FD12ECFE38D2A0612F_730174211 = (depth > innerDepth || !parser.getName().equals("item"));
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
                        boolean var8369081016E1C7D2726F6A3629A921B6_1881109622 = ((type=parser.next()) == XmlPullParser.TEXT);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.890 -0400", hash_original_method = "91217E14A6A0FB93E4A43550FB5F1C23", hash_generated_method = "DB1D5F9050C0056A5D1EF1B6EF89E5B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Drawable mutate() {
        {
            boolean varC94B19053599294E7944C8C841976773_605740168 = (!mMutated && super.mutate() == this);
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.890 -0400", hash_original_method = "917C43EFB3C2CE5953BF86C61EBDB328", hash_generated_method = "6CD5609CAB714EE65B27EAC78288E19A")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.891 -0400", hash_original_method = "8444C7122CB16D5313EA6D9A8D591DCE", hash_generated_method = "8F7A0F9FF00D194C23C6F8065BFBFEA5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Drawable newDrawable() {
            Drawable varD822A8DCE481D69D61F9CED43BD50C33_1169430222 = (new AnimationDrawable(this, null));
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new AnimationDrawable(this, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.891 -0400", hash_original_method = "C298E1FF6FE04F3BBF8263AF38ED7861", hash_generated_method = "21548EC3C3709004616FA2D666A93825")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Drawable newDrawable(Resources res) {
            dsTaint.addTaint(res.dsTaint);
            Drawable var3478344CF451E638A8C6EDD28FB82A71_1636738188 = (new AnimationDrawable(this, res));
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new AnimationDrawable(this, res);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.891 -0400", hash_original_method = "7FFF22B3EB022905B5691180A1C9266D", hash_generated_method = "C05E8AE17BBEF3BDDA470960C89428FE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.891 -0400", hash_original_method = "280320AC02B6789F88426235E202F89A", hash_generated_method = "2A218FBA0A63570BB378EB890AE311F2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

