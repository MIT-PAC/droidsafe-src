package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.SystemClock;
import android.util.AttributeSet;





public class AnimationDrawable extends DrawableContainer implements Runnable, Animatable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.510 -0500", hash_original_field = "390BAAE1EB086EA47AF09FAEF9375540", hash_generated_field = "8C9FC3EF51CD1D7374A26DD8B125CA14")

    private  AnimationState mAnimationState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.512 -0500", hash_original_field = "B44B34D258300E205C325BC2D0428AC5", hash_generated_field = "93D0C0F4C52876AB706915475617A386")

    private int mCurFrame = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.514 -0500", hash_original_field = "B15C308E96D0EEBD27CFE369FA349C15", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.517 -0500", hash_original_method = "35EE0C4966C7CA57865D8E1E9DE06504", hash_generated_method = "C8B7DBD9573CE0FD586F1E926B12EEC4")
    
public AnimationDrawable() {
        this(null, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.575 -0500", hash_original_method = "586B7D97991AD2B5DDF2BA28DAD874F2", hash_generated_method = "7F2588311A812B7A27F5F33BA27DE812")
    
private AnimationDrawable(AnimationState state, Resources res) {
        AnimationState as = new AnimationState(state, this, res);
        mAnimationState = as;
        setConstantState(as);
        if (state != null) {
            setFrame(0, true, false);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.519 -0500", hash_original_method = "F207A8C7EE9B62CDAD2CDEF6C9E1E05A", hash_generated_method = "8C07124F4B80241F4930CA719BD65812")
    
@Override
    public boolean setVisible(boolean visible, boolean restart) {
        boolean changed = super.setVisible(visible, restart);
        if (visible) {
            if (changed || restart) {
                setFrame(0, true, true);
            }
        } else {
            unscheduleSelf(this);
        }
        return changed;
    }

    /**
     * <p>Starts the animation, looping if necessary. This method has no effect
     * if the animation is running.</p>
     *
     * @see #isRunning()
     * @see #stop()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.521 -0500", hash_original_method = "B2F55F064A30629408E9D67D650C8080", hash_generated_method = "D4F3C97A9CA06C43D325100C5A3348BD")
    
public void start() {
        if (!isRunning()) {
            run();
        }
    }

    /**
     * <p>Stops the animation. This method has no effect if the animation is
     * not running.</p>
     *
     * @see #isRunning()
     * @see #start()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.523 -0500", hash_original_method = "13ACD75B58E729F7C9E7DE6208579581", hash_generated_method = "ECAD6D583B3C0FBC2F97779678F13777")
    
public void stop() {
        if (isRunning()) {
            unscheduleSelf(this);
        }
    }

    /**
     * <p>Indicates whether the animation is currently running or not.</p>
     *
     * @return true if the animation is running, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.525 -0500", hash_original_method = "58F8F26763BA19E1F1B373F32B389D6B", hash_generated_method = "B66047CBA5F4925ECDEC49FBC2F485FA")
    
public boolean isRunning() {
        return mCurFrame > -1;
    }

    /**
     * <p>This method exists for implementation purpose only and should not be
     * called directly. Invoke {@link #start()} instead.</p>
     *
     * @see #start()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.527 -0500", hash_original_method = "B6B243EB70C5F724D188154EAF209167", hash_generated_method = "E05920D5F98D86E1C769E09C9DA16AE9")
    
public void run() {
        nextFrame(false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.530 -0500", hash_original_method = "A4EA0ABEB4B95482FCBDF5ED15C3D56A", hash_generated_method = "B502024B7F748BE413D5239C2348A019")
    
@Override
    public void unscheduleSelf(Runnable what) {
        mCurFrame = -1;
        super.unscheduleSelf(what);
    }

    /**
     * @return The number of frames in the animation
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.532 -0500", hash_original_method = "078F231D1E4DEE307E947B896715B9FA", hash_generated_method = "5025FEE6B92BF88A77E6F8353AA4EAD6")
    
public int getNumberOfFrames() {
        return mAnimationState.getChildCount();
    }
    
    /**
     * @return The Drawable at the specified frame index
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.534 -0500", hash_original_method = "924497ADC8C942C05D9D7A5BCA11BCAD", hash_generated_method = "8BA7E4E455DA62781E9BC042F465DB3A")
    
public Drawable getFrame(int index) {
        return mAnimationState.getChildren()[index];
    }
    
    /**
     * @return The duration in milliseconds of the frame at the 
     * specified index
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.537 -0500", hash_original_method = "F1980307C7F7FBBB813440E411F73714", hash_generated_method = "2059BCCA67A341C5AD3C2C8972CC3936")
    
public int getDuration(int i) {
        return mAnimationState.mDurations[i];
    }
    
    /**
     * @return True of the animation will play once, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.539 -0500", hash_original_method = "F5C3EDF3EE4DBDBAFAA19B210BF98AFC", hash_generated_method = "4B6186B7C773DB7FC6E34728FC5E57A5")
    
public boolean isOneShot() {
        return mAnimationState.mOneShot;
    }
    
    /**
     * Sets whether the animation should play once or repeat.
     * 
     * @param oneShot Pass true if the animation should only play once
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.541 -0500", hash_original_method = "E8F5482B51D48B1DAA2F24BE9877736B", hash_generated_method = "E0EBA634D159BA1B4DB52D6C94AA449F")
    
public void setOneShot(boolean oneShot) {
        mAnimationState.mOneShot = oneShot;
    }
    
    /**
     * Add a frame to the animation
     * 
     * @param frame The frame to add
     * @param duration How long in milliseconds the frame should appear
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.543 -0500", hash_original_method = "1C98A9B62B655827C0439A8A5D392C10", hash_generated_method = "9F147038D0E8ABB8C00272D61FE1F2AC")
    
public void addFrame(Drawable frame, int duration) {
        mAnimationState.addFrame(frame, duration);
        if (mCurFrame < 0) {
            setFrame(0, true, false);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.545 -0500", hash_original_method = "5BF496D6A5AC4A1943AFC092E55892DA", hash_generated_method = "5C02CF381FD0924066D55157DF859005")
    
private void nextFrame(boolean unschedule) {
        int next = mCurFrame+1;
        final int N = mAnimationState.getChildCount();
        if (next >= N) {
            next = 0;
        }
        setFrame(next, unschedule, !mAnimationState.mOneShot || next < (N - 1));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.547 -0500", hash_original_method = "B59ABD564D6BE8E67E70E520C58F1693", hash_generated_method = "FA116E4DF1B32B17388905DEF189AB70")
    
private void setFrame(int frame, boolean unschedule, boolean animate) {
        if (frame >= mAnimationState.getChildCount()) {
            return;
        }
        mCurFrame = frame;
        selectDrawable(frame);
        if (unschedule) {
            unscheduleSelf(this);
        }
        if (animate) {
            scheduleSelf(this, SystemClock.uptimeMillis() + mAnimationState.mDurations[frame]);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.551 -0500", hash_original_method = "7089458E2F1E271024E158C172450FE4", hash_generated_method = "EA37544FB2B700501553E8901C2F09CF")
    
@Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs)
            throws XmlPullParserException, IOException {
        
        TypedArray a = r.obtainAttributes(attrs,
                com.android.internal.R.styleable.AnimationDrawable);

        super.inflateWithAttributes(r, parser, a,
                com.android.internal.R.styleable.AnimationDrawable_visible);
        
        mAnimationState.setVariablePadding(a.getBoolean(
                com.android.internal.R.styleable.AnimationDrawable_variablePadding, false));
            
        mAnimationState.mOneShot = a.getBoolean(
                com.android.internal.R.styleable.AnimationDrawable_oneshot, false);
        
        a.recycle();
        
        int type;

        final int innerDepth = parser.getDepth()+1;
        int depth;
        while ((type=parser.next()) != XmlPullParser.END_DOCUMENT &&
                ((depth = parser.getDepth()) >= innerDepth || type != XmlPullParser.END_TAG)) {
            if (type != XmlPullParser.START_TAG) {
                continue;
            }

            if (depth > innerDepth || !parser.getName().equals("item")) {
                continue;
            }
            
            a = r.obtainAttributes(attrs, com.android.internal.R.styleable.AnimationDrawableItem);
            int duration = a.getInt(
                    com.android.internal.R.styleable.AnimationDrawableItem_duration, -1);
            if (duration < 0) {
                throw new XmlPullParserException(
                        parser.getPositionDescription()
                        + ": <item> tag requires a 'duration' attribute");
            }
            int drawableRes = a.getResourceId(
                    com.android.internal.R.styleable.AnimationDrawableItem_drawable, 0);
            
            a.recycle();
            
            Drawable dr;
            if (drawableRes != 0) {
                dr = r.getDrawable(drawableRes);
            } else {
                while ((type=parser.next()) == XmlPullParser.TEXT) {
                    // Empty
                }
                if (type != XmlPullParser.START_TAG) {
                    throw new XmlPullParserException(parser.getPositionDescription() +
                            ": <item> tag requires a 'drawable' attribute or child tag" +
                            " defining a drawable");
                }
                dr = Drawable.createFromXmlInner(r, parser, attrs);
            }
            
            mAnimationState.addFrame(dr, duration);
            if (dr != null) {
                dr.setCallback(this);
            }
        }

        setFrame(0, true, false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.553 -0500", hash_original_method = "91217E14A6A0FB93E4A43550FB5F1C23", hash_generated_method = "C13A033FD4B6D0D66363D304BAF547E6")
    
@Override
    public Drawable mutate() {
        if (!mMutated && super.mutate() == this) {
            mAnimationState.mDurations = mAnimationState.mDurations.clone();
            mMutated = true;
        }
        return this;
    }

    
    private final static class AnimationState extends DrawableContainerState {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.556 -0500", hash_original_field = "20D1C0D4800764C0753F9956F9F072EE", hash_generated_field = "8BD7F9CC97F6F0855D8F3C7E2109665D")

        private int[] mDurations;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.558 -0500", hash_original_field = "BEC82D6FC788818DE0308F568563DEFD", hash_generated_field = "90E32900694EFB9D3548ACF4940301BF")

        private boolean mOneShot;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.561 -0500", hash_original_method = "917C43EFB3C2CE5953BF86C61EBDB328", hash_generated_method = "917C43EFB3C2CE5953BF86C61EBDB328")
        
AnimationState(AnimationState orig, AnimationDrawable owner,
                Resources res) {
            super(orig, owner, res);

            if (orig != null) {
                mDurations = orig.mDurations;
                mOneShot = orig.mOneShot;
            } else {
                mDurations = new int[getChildren().length];
                mOneShot = true;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.563 -0500", hash_original_method = "8444C7122CB16D5313EA6D9A8D591DCE", hash_generated_method = "14F4F30128664C948D0F5F11A5F773A9")
        
@Override
        public Drawable newDrawable() {
            return new AnimationDrawable(this, null);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.565 -0500", hash_original_method = "C298E1FF6FE04F3BBF8263AF38ED7861", hash_generated_method = "3C42F60E01D8C401794021029D2487FC")
        
@Override
        public Drawable newDrawable(Resources res) {
            return new AnimationDrawable(this, res);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.569 -0500", hash_original_method = "7FFF22B3EB022905B5691180A1C9266D", hash_generated_method = "EC3A7E8E2C7CA49E7ABB481F3E1F46F4")
        
public void addFrame(Drawable dr, int dur) {
            // Do not combine the following. The array index must be evaluated before 
            // the array is accessed because super.addChild(dr) has a side effect on mDurations.
            int pos = super.addChild(dr);
            mDurations[pos] = dur;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.571 -0500", hash_original_method = "280320AC02B6789F88426235E202F89A", hash_generated_method = "6CA2B6FAF9DB9AD39F2DA22B5456C9C2")
        
@Override
        public void growArray(int oldSize, int newSize) {
            super.growArray(oldSize, newSize);
            int[] newDurations = new int[newSize];
            System.arraycopy(mDurations, 0, newDurations, 0, oldSize);
            mDurations = newDurations;
        }

        
    }


    
}

