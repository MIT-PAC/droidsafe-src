package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.SystemClock;
import android.util.AttributeSet;

public class AnimationDrawable extends DrawableContainer implements Runnable, Animatable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.549 -0400", hash_original_field = "3405E3C097684DA39297C61B3FBF4BCE", hash_generated_field = "8C9FC3EF51CD1D7374A26DD8B125CA14")

    private AnimationState mAnimationState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.549 -0400", hash_original_field = "FCF69B1AF5E19505D1E496A0EC6D6768", hash_generated_field = "93D0C0F4C52876AB706915475617A386")

    private int mCurFrame = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.549 -0400", hash_original_field = "9FB80C30383848C8D006680B5F3BDAF9", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.549 -0400", hash_original_method = "35EE0C4966C7CA57865D8E1E9DE06504", hash_generated_method = "86EDDFEE2C351DEF5FE882A4933337FE")
    public  AnimationDrawable() {
        this(null, null);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.550 -0400", hash_original_method = "586B7D97991AD2B5DDF2BA28DAD874F2", hash_generated_method = "73715A255D8BA3FA2401D48109BD3696")
    private  AnimationDrawable(AnimationState state, Resources res) {
        addTaint(res.getTaint());
        addTaint(state.getTaint());
        AnimationState as = new AnimationState(state, this, res);
        mAnimationState = as;
        setConstantState(as);
    if(state != null)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.551 -0400", hash_original_method = "F207A8C7EE9B62CDAD2CDEF6C9E1E05A", hash_generated_method = "9B96B16AC055EAD9A4E2A32C46549E24")
    @Override
    public boolean setVisible(boolean visible, boolean restart) {
        addTaint(restart);
        addTaint(visible);
        boolean changed = super.setVisible(visible, restart);
    if(visible)        
        {
    if(changed || restart)            
            {
                setFrame(0, true, true);
            } //End block
        } //End block
        else
        {
            unscheduleSelf(this);
        } //End block
        boolean var8977DFAC2F8E04CB96E66882235F5ABA_1012368932 = (changed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1149655504 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1149655504;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.551 -0400", hash_original_method = "B2F55F064A30629408E9D67D650C8080", hash_generated_method = "EC0B19409B80B0791F1EB4909F6766B3")
    public void start() {
    if(!isRunning())        
        {
            run();
        } //End block
        // ---------- Original Method ----------
        //if (!isRunning()) {
            //run();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.551 -0400", hash_original_method = "13ACD75B58E729F7C9E7DE6208579581", hash_generated_method = "53C11BAFB191CDBD4971943005900B92")
    public void stop() {
    if(isRunning())        
        {
            unscheduleSelf(this);
        } //End block
        // ---------- Original Method ----------
        //if (isRunning()) {
            //unscheduleSelf(this);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.552 -0400", hash_original_method = "58F8F26763BA19E1F1B373F32B389D6B", hash_generated_method = "AA90744769D0744D4B6AD4EAEA886F01")
    public boolean isRunning() {
        boolean varB13D098C873A2C979776046FBFB77EA9_1136532147 = (mCurFrame > -1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1851065187 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1851065187;
        // ---------- Original Method ----------
        //return mCurFrame > -1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.552 -0400", hash_original_method = "B6B243EB70C5F724D188154EAF209167", hash_generated_method = "B68A4DACC752E288041F7CFA46B6D54E")
    public void run() {
        nextFrame(false);
        // ---------- Original Method ----------
        //nextFrame(false);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.553 -0400", hash_original_method = "A4EA0ABEB4B95482FCBDF5ED15C3D56A", hash_generated_method = "042C22AA283F353A6C950406C408B229")
    @Override
    public void unscheduleSelf(Runnable what) {
        addTaint(what.getTaint());
        mCurFrame = -1;
        super.unscheduleSelf(what);
        // ---------- Original Method ----------
        //mCurFrame = -1;
        //super.unscheduleSelf(what);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.553 -0400", hash_original_method = "078F231D1E4DEE307E947B896715B9FA", hash_generated_method = "CB5A6E076B91315BD6EA2A3017404FEB")
    public int getNumberOfFrames() {
        int var49D7324FC1570CC3E57576B411A488B9_667265240 = (mAnimationState.getChildCount());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1318412362 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1318412362;
        // ---------- Original Method ----------
        //return mAnimationState.getChildCount();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.553 -0400", hash_original_method = "924497ADC8C942C05D9D7A5BCA11BCAD", hash_generated_method = "6E24379087D9A58FD040FF3564D6563E")
    public Drawable getFrame(int index) {
        addTaint(index);
Drawable varE0AB1D3BEF0F8EC2A36A9087A870E1EA_3684648 =         mAnimationState.getChildren()[index];
        varE0AB1D3BEF0F8EC2A36A9087A870E1EA_3684648.addTaint(taint);
        return varE0AB1D3BEF0F8EC2A36A9087A870E1EA_3684648;
        // ---------- Original Method ----------
        //return mAnimationState.getChildren()[index];
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.554 -0400", hash_original_method = "F1980307C7F7FBBB813440E411F73714", hash_generated_method = "CDC38B01BA0CDD0A59B9B38B6932EE68")
    public int getDuration(int i) {
        addTaint(i);
        int var05DFC31AEA2EF2949C00FD12606C7E16_1329869502 = (mAnimationState.mDurations[i]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1945517843 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1945517843;
        // ---------- Original Method ----------
        //return mAnimationState.mDurations[i];
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.554 -0400", hash_original_method = "F5C3EDF3EE4DBDBAFAA19B210BF98AFC", hash_generated_method = "B30BFA7B137518A94A4913BF0767B33E")
    public boolean isOneShot() {
        boolean varE79A063CC7E1C1620F6A53E3B407D24D_456509030 = (mAnimationState.mOneShot);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1889688229 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1889688229;
        // ---------- Original Method ----------
        //return mAnimationState.mOneShot;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.555 -0400", hash_original_method = "E8F5482B51D48B1DAA2F24BE9877736B", hash_generated_method = "323509116D1A453EB4E6DE2EBA7CA601")
    public void setOneShot(boolean oneShot) {
        mAnimationState.mOneShot = oneShot;
        // ---------- Original Method ----------
        //mAnimationState.mOneShot = oneShot;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.555 -0400", hash_original_method = "1C98A9B62B655827C0439A8A5D392C10", hash_generated_method = "55514C302C32CA2645A5D53F39C82993")
    public void addFrame(Drawable frame, int duration) {
        addTaint(duration);
        addTaint(frame.getTaint());
        mAnimationState.addFrame(frame, duration);
    if(mCurFrame < 0)        
        {
            setFrame(0, true, false);
        } //End block
        // ---------- Original Method ----------
        //mAnimationState.addFrame(frame, duration);
        //if (mCurFrame < 0) {
            //setFrame(0, true, false);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.556 -0400", hash_original_method = "5BF496D6A5AC4A1943AFC092E55892DA", hash_generated_method = "6675B8FE44905DA9FFD973246CC2786C")
    private void nextFrame(boolean unschedule) {
        addTaint(unschedule);
        int next = mCurFrame+1;
        final int N = mAnimationState.getChildCount();
    if(next >= N)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.557 -0400", hash_original_method = "B59ABD564D6BE8E67E70E520C58F1693", hash_generated_method = "BC34A338D4C6C10B3D40432E71599F26")
    private void setFrame(int frame, boolean unschedule, boolean animate) {
        addTaint(animate);
        addTaint(unschedule);
    if(frame >= mAnimationState.getChildCount())        
        {
            return;
        } //End block
        mCurFrame = frame;
        selectDrawable(frame);
    if(unschedule)        
        {
            unscheduleSelf(this);
        } //End block
    if(animate)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.560 -0400", hash_original_method = "7089458E2F1E271024E158C172450FE4", hash_generated_method = "D1B98B9E646377E77E945329295D061F")
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        addTaint(attrs.getTaint());
        addTaint(parser.getTaint());
        addTaint(r.getTaint());
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
        while
((type=parser.next()) != XmlPullParser.END_DOCUMENT &&
                ((depth = parser.getDepth()) >= innerDepth || type != XmlPullParser.END_TAG))        
        {
    if(type != XmlPullParser.START_TAG)            
            {
                continue;
            } //End block
    if(depth > innerDepth || !parser.getName().equals("item"))            
            {
                continue;
            } //End block
            a = r.obtainAttributes(attrs, com.android.internal.R.styleable.AnimationDrawableItem);
            int duration = a.getInt(
                    com.android.internal.R.styleable.AnimationDrawableItem_duration, -1);
    if(duration < 0)            
            {
                XmlPullParserException var9CF3B90D42F76ED45BE30A9B0CA40BC3_514145401 = new XmlPullParserException(
                        parser.getPositionDescription()
                        + ": <item> tag requires a 'duration' attribute");
                var9CF3B90D42F76ED45BE30A9B0CA40BC3_514145401.addTaint(taint);
                throw var9CF3B90D42F76ED45BE30A9B0CA40BC3_514145401;
            } //End block
            int drawableRes = a.getResourceId(
                    com.android.internal.R.styleable.AnimationDrawableItem_drawable, 0);
            a.recycle();
            Drawable dr;
    if(drawableRes != 0)            
            {
                dr = r.getDrawable(drawableRes);
            } //End block
            else
            {
                while
((type=parser.next()) == XmlPullParser.TEXT)                
                {
                } //End block
    if(type != XmlPullParser.START_TAG)                
                {
                    XmlPullParserException varEC1CC5BA29A24596FA4F39C7BE101107_860611806 = new XmlPullParserException(parser.getPositionDescription() +
                            ": <item> tag requires a 'drawable' attribute or child tag" +
                            " defining a drawable");
                    varEC1CC5BA29A24596FA4F39C7BE101107_860611806.addTaint(taint);
                    throw varEC1CC5BA29A24596FA4F39C7BE101107_860611806;
                } //End block
                dr = Drawable.createFromXmlInner(r, parser, attrs);
            } //End block
            mAnimationState.addFrame(dr, duration);
    if(dr != null)            
            {
                dr.setCallback(this);
            } //End block
        } //End block
        setFrame(0, true, false);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.561 -0400", hash_original_method = "91217E14A6A0FB93E4A43550FB5F1C23", hash_generated_method = "E966456877ACFD17902007B9B813AEB6")
    @Override
    public Drawable mutate() {
    if(!mMutated && super.mutate() == this)        
        {
            mAnimationState.mDurations = mAnimationState.mDurations.clone();
            mMutated = true;
        } //End block
Drawable var72A74007B2BE62B849F475C7BDA4658B_24026217 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_24026217.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_24026217;
        // ---------- Original Method ----------
        //if (!mMutated && super.mutate() == this) {
            //mAnimationState.mDurations = mAnimationState.mDurations.clone();
            //mMutated = true;
        //}
        //return this;
    }

    
    private final static class AnimationState extends DrawableContainerState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.562 -0400", hash_original_field = "29E02C393EBF8D36CFECC064EFDF29CA", hash_generated_field = "8BD7F9CC97F6F0855D8F3C7E2109665D")

        private int[] mDurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.562 -0400", hash_original_field = "BFA6EEFE0C30E0A93CA19234400247B7", hash_generated_field = "90E32900694EFB9D3548ACF4940301BF")

        private boolean mOneShot;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.563 -0400", hash_original_method = "917C43EFB3C2CE5953BF86C61EBDB328", hash_generated_method = "64BFA381AF68AC7905732FCC0C659350")
          AnimationState(AnimationState orig, AnimationDrawable owner,
                Resources res) {
            super(orig, owner, res);
            addTaint(res.getTaint());
            addTaint(owner.getTaint());
    if(orig != null)            
            {
                mDurations = orig.mDurations;
                mOneShot = orig.mOneShot;
            } //End block
            else
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.564 -0400", hash_original_method = "8444C7122CB16D5313EA6D9A8D591DCE", hash_generated_method = "0F3AD06F77F9282090DE8F368FF7E178")
        @Override
        public Drawable newDrawable() {
Drawable var9949D0644C02A40FDCE8ADC29BE8A5E1_93134476 =             new AnimationDrawable(this, null);
            var9949D0644C02A40FDCE8ADC29BE8A5E1_93134476.addTaint(taint);
            return var9949D0644C02A40FDCE8ADC29BE8A5E1_93134476;
            // ---------- Original Method ----------
            //return new AnimationDrawable(this, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.565 -0400", hash_original_method = "C298E1FF6FE04F3BBF8263AF38ED7861", hash_generated_method = "8052975E7AB18AA9D525E0D470CDD130")
        @Override
        public Drawable newDrawable(Resources res) {
            addTaint(res.getTaint());
Drawable varB1995698A6B44C5CB10B91184B1A4C71_147419150 =             new AnimationDrawable(this, res);
            varB1995698A6B44C5CB10B91184B1A4C71_147419150.addTaint(taint);
            return varB1995698A6B44C5CB10B91184B1A4C71_147419150;
            // ---------- Original Method ----------
            //return new AnimationDrawable(this, res);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.565 -0400", hash_original_method = "7FFF22B3EB022905B5691180A1C9266D", hash_generated_method = "8388298F1655C6A62F1D0AEC0222B42E")
        public void addFrame(Drawable dr, int dur) {
            addTaint(dr.getTaint());
            int pos = super.addChild(dr);
            mDurations[pos] = dur;
            // ---------- Original Method ----------
            //int pos = super.addChild(dr);
            //mDurations[pos] = dur;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.566 -0400", hash_original_method = "280320AC02B6789F88426235E202F89A", hash_generated_method = "A02687F4F28E6916CCD3F7F4E15F1157")
        @Override
        public void growArray(int oldSize, int newSize) {
            addTaint(newSize);
            addTaint(oldSize);
            super.growArray(oldSize, newSize);
            int[] newDurations = new int[newSize];
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

