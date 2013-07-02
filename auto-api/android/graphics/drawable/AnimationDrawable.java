package android.graphics.drawable;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.SystemClock;
import android.util.AttributeSet;

public class AnimationDrawable extends DrawableContainer implements Runnable, Animatable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.574 -0400", hash_original_field = "3405E3C097684DA39297C61B3FBF4BCE", hash_generated_field = "8C9FC3EF51CD1D7374A26DD8B125CA14")

    private AnimationState mAnimationState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.574 -0400", hash_original_field = "FCF69B1AF5E19505D1E496A0EC6D6768", hash_generated_field = "93D0C0F4C52876AB706915475617A386")

    private int mCurFrame = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.574 -0400", hash_original_field = "9FB80C30383848C8D006680B5F3BDAF9", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.575 -0400", hash_original_method = "35EE0C4966C7CA57865D8E1E9DE06504", hash_generated_method = "86EDDFEE2C351DEF5FE882A4933337FE")
    public  AnimationDrawable() {
        this(null, null);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.575 -0400", hash_original_method = "586B7D97991AD2B5DDF2BA28DAD874F2", hash_generated_method = "355CE5AC8B9AA7CF0F6388C27E44BC3D")
    private  AnimationDrawable(AnimationState state, Resources res) {
        AnimationState as = new AnimationState(state, this, res);
        mAnimationState = as;
        setConstantState(as);
        {
            setFrame(0, true, false);
        } 
        addTaint(state.getTaint());
        addTaint(res.getTaint());
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.576 -0400", hash_original_method = "F207A8C7EE9B62CDAD2CDEF6C9E1E05A", hash_generated_method = "8DFB5C2AD54F77AF4F10C25502040893")
    @Override
    public boolean setVisible(boolean visible, boolean restart) {
        boolean changed = super.setVisible(visible, restart);
        {
            {
                setFrame(0, true, true);
            } 
        } 
        {
            unscheduleSelf(this);
        } 
        addTaint(visible);
        addTaint(restart);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1853766232 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1853766232;
        
        
        
            
                
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.576 -0400", hash_original_method = "B2F55F064A30629408E9D67D650C8080", hash_generated_method = "D9A82412AE78C2FE0FBD72E2C0367A63")
    public void start() {
        {
            boolean var9DBCB1EE9690E5DFF394DFE3019DBEB0_539349527 = (!isRunning());
            {
                run();
            } 
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.577 -0400", hash_original_method = "13ACD75B58E729F7C9E7DE6208579581", hash_generated_method = "CBE8FA80920E11377BC906AB6C5F8A49")
    public void stop() {
        {
            boolean var1FD6FB112E1C2F6634A4DABBDA9265D9_2135282564 = (isRunning());
            {
                unscheduleSelf(this);
            } 
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.577 -0400", hash_original_method = "58F8F26763BA19E1F1B373F32B389D6B", hash_generated_method = "ECB439A10E3DF978DA604F61EC63D0C2")
    public boolean isRunning() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1804452757 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1804452757;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.577 -0400", hash_original_method = "B6B243EB70C5F724D188154EAF209167", hash_generated_method = "B68A4DACC752E288041F7CFA46B6D54E")
    public void run() {
        nextFrame(false);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.578 -0400", hash_original_method = "A4EA0ABEB4B95482FCBDF5ED15C3D56A", hash_generated_method = "8F909239744731666C82AEA4198A3EE7")
    @Override
    public void unscheduleSelf(Runnable what) {
        mCurFrame = -1;
        super.unscheduleSelf(what);
        addTaint(what.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.578 -0400", hash_original_method = "078F231D1E4DEE307E947B896715B9FA", hash_generated_method = "FAA7D993854E9EB69FC0F3F5B52CBD54")
    public int getNumberOfFrames() {
        int var2E5DD581DA9E7709CCEB84A19B8FCBC8_963838231 = (mAnimationState.getChildCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_591254314 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_591254314;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.579 -0400", hash_original_method = "924497ADC8C942C05D9D7A5BCA11BCAD", hash_generated_method = "7544485D7DA6496DFBC7D618FAEFA734")
    public Drawable getFrame(int index) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_572902916 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_572902916 = mAnimationState.getChildren()[index];
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_572902916.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_572902916;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.579 -0400", hash_original_method = "F1980307C7F7FBBB813440E411F73714", hash_generated_method = "FE73FFE30D39E9CE8E630E42B6282EB3")
    public int getDuration(int i) {
        addTaint(i);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_72944625 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_72944625;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.580 -0400", hash_original_method = "F5C3EDF3EE4DBDBAFAA19B210BF98AFC", hash_generated_method = "E4777658EAE4F32AB20CED7B7B3906AD")
    public boolean isOneShot() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_977493095 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_977493095;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.580 -0400", hash_original_method = "E8F5482B51D48B1DAA2F24BE9877736B", hash_generated_method = "323509116D1A453EB4E6DE2EBA7CA601")
    public void setOneShot(boolean oneShot) {
        mAnimationState.mOneShot = oneShot;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.581 -0400", hash_original_method = "1C98A9B62B655827C0439A8A5D392C10", hash_generated_method = "49C57D466235A85405B45BDFE28239E3")
    public void addFrame(Drawable frame, int duration) {
        mAnimationState.addFrame(frame, duration);
        {
            setFrame(0, true, false);
        } 
        addTaint(frame.getTaint());
        addTaint(duration);
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.582 -0400", hash_original_method = "5BF496D6A5AC4A1943AFC092E55892DA", hash_generated_method = "6F40A60F5A3DA9E34C4405589268374B")
    private void nextFrame(boolean unschedule) {
        int next = mCurFrame+1;
        final int N = mAnimationState.getChildCount();
        {
            next = 0;
        } 
        setFrame(next, unschedule, !mAnimationState.mOneShot || next < (N - 1));
        addTaint(unschedule);
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.582 -0400", hash_original_method = "B59ABD564D6BE8E67E70E520C58F1693", hash_generated_method = "18A079E40A90B004EBB728EE7AD4B4F5")
    private void setFrame(int frame, boolean unschedule, boolean animate) {
        {
            boolean varA6C25A0F5E103E4859378F59ED342CD8_796760333 = (frame >= mAnimationState.getChildCount());
        } 
        mCurFrame = frame;
        selectDrawable(frame);
        {
            unscheduleSelf(this);
        } 
        {
            scheduleSelf(this, SystemClock.uptimeMillis() + mAnimationState.mDurations[frame]);
        } 
        addTaint(unschedule);
        addTaint(animate);
        
        
            
        
        
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
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
        int depth = 0;
        {
            boolean varB56CDBB38766BEA17078FA16D609B275_1735454723 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT &&
                ((depth = parser.getDepth()) >= innerDepth || type != XmlPullParser.END_TAG));
            {
                {
                    boolean var03C44ADC0346A0FD12ECFE38D2A0612F_2096140288 = (depth > innerDepth || !parser.getName().equals("item"));
                } 
                a = r.obtainAttributes(attrs, com.android.internal.R.styleable.AnimationDrawableItem);
                int duration;
                duration = a.getInt(
                    com.android.internal.R.styleable.AnimationDrawableItem_duration, -1);
                {
                    if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                        parser.getPositionDescription()
                        + ": <item> tag requires a 'duration' attribute");
                } 
                int drawableRes;
                drawableRes = a.getResourceId(
                    com.android.internal.R.styleable.AnimationDrawableItem_drawable, 0);
                a.recycle();
                Drawable dr;
                {
                    dr = r.getDrawable(drawableRes);
                } 
                {
                    {
                        boolean var8369081016E1C7D2726F6A3629A921B6_1431611363 = ((type=parser.next()) == XmlPullParser.TEXT);
                    } 
                    {
                        if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(parser.getPositionDescription() +
                            ": <item> tag requires a 'drawable' attribute or child tag" +
                            " defining a drawable");
                    } 
                    dr = Drawable.createFromXmlInner(r, parser, attrs);
                } 
                mAnimationState.addFrame(dr, duration);
                {
                    dr.setCallback(this);
                } 
            } 
        } 
        setFrame(0, true, false);
        addTaint(r.getTaint());
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.583 -0400", hash_original_method = "91217E14A6A0FB93E4A43550FB5F1C23", hash_generated_method = "8D47E3678528B4280AB2219BC98399A4")
    @Override
    public Drawable mutate() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1617988167 = null; 
        {
            boolean varC94B19053599294E7944C8C841976773_260787972 = (!mMutated && super.mutate() == this);
            {
                mAnimationState.mDurations = mAnimationState.mDurations.clone();
                mMutated = true;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1617988167 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1617988167.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1617988167;
        
        
            
            
        
        
    }

    
    private final static class AnimationState extends DrawableContainerState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.583 -0400", hash_original_field = "29E02C393EBF8D36CFECC064EFDF29CA", hash_generated_field = "8BD7F9CC97F6F0855D8F3C7E2109665D")

        private int[] mDurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.584 -0400", hash_original_field = "BFA6EEFE0C30E0A93CA19234400247B7", hash_generated_field = "90E32900694EFB9D3548ACF4940301BF")

        private boolean mOneShot;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.584 -0400", hash_original_method = "917C43EFB3C2CE5953BF86C61EBDB328", hash_generated_method = "7A1D1A58063C2C8919A3016E26E20E96")
          AnimationState(AnimationState orig, AnimationDrawable owner,
                Resources res) {
            super(orig, owner, res);
            {
                mDurations = orig.mDurations;
                mOneShot = orig.mOneShot;
            } 
            {
                mDurations = new int[getChildren().length];
                mOneShot = true;
            } 
            addTaint(owner.getTaint());
            addTaint(res.getTaint());
            
            
                
                
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.585 -0400", hash_original_method = "8444C7122CB16D5313EA6D9A8D591DCE", hash_generated_method = "E9C73D9F7E59C7C4DCE58AC1D8E1648F")
        @Override
        public Drawable newDrawable() {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_1923441165 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1923441165 = new AnimationDrawable(this, null);
            varB4EAC82CA7396A68D541C85D26508E83_1923441165.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1923441165;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.586 -0400", hash_original_method = "C298E1FF6FE04F3BBF8263AF38ED7861", hash_generated_method = "A82B4B6C797D6892FAA62B37C3139FDA")
        @Override
        public Drawable newDrawable(Resources res) {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_783374037 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_783374037 = new AnimationDrawable(this, res);
            addTaint(res.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_783374037.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_783374037;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.586 -0400", hash_original_method = "7FFF22B3EB022905B5691180A1C9266D", hash_generated_method = "97D22E56B38F2989776130694B9E7B3C")
        public void addFrame(Drawable dr, int dur) {
            int pos = super.addChild(dr);
            mDurations[pos] = dur;
            addTaint(dr.getTaint());
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.586 -0400", hash_original_method = "280320AC02B6789F88426235E202F89A", hash_generated_method = "5D4188E2BC1327C78E1D3DBD114160C4")
        @Override
        public void growArray(int oldSize, int newSize) {
            super.growArray(oldSize, newSize);
            int[] newDurations = new int[newSize];
            System.arraycopy(mDurations, 0, newDurations, 0, oldSize);
            mDurations = newDurations;
            addTaint(oldSize);
            addTaint(newSize);
            
            
            
            
            
        }

        
    }


    
}

