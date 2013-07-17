package android.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;

public abstract class Animator implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.806 -0400", hash_original_field = "76E8AF78EA383C38A6F80E45CCFEA268", hash_generated_field = "3FD42DDC5A574D761F1E8BD3EC073311")

    ArrayList<AnimatorListener> mListeners = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.808 -0400", hash_original_method = "12606DD4E4D75078EE1609D9ED5651A9", hash_generated_method = "12606DD4E4D75078EE1609D9ED5651A9")
    public Animator ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.810 -0400", hash_original_method = "077E81C30B4BFFEF2F9502DB378CA204", hash_generated_method = "A801E423F89557B74070F06DC0AB8DFA")
    public void start() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.813 -0400", hash_original_method = "E5C5DBED2FC0D18DB80484DB83D94F8A", hash_generated_method = "43CBBEFF14DFE69DF0FC06DADAEF94C2")
    public void cancel() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.815 -0400", hash_original_method = "4F105473DD7236D24F8992C8503B57B1", hash_generated_method = "9DFCE4A1701D66E2F860131DA801747C")
    public void end() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public abstract long getStartDelay();

    
    @DSModeled(DSC.SAFE)
    public abstract void setStartDelay(long startDelay);

    
    @DSModeled(DSC.SAFE)
    public abstract Animator setDuration(long duration);

    
    @DSModeled(DSC.SAFE)
    public abstract long getDuration();

    
    @DSModeled(DSC.SAFE)
    public abstract void setInterpolator(TimeInterpolator value);

    
    @DSModeled(DSC.SAFE)
    public abstract boolean isRunning();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.829 -0400", hash_original_method = "5FAE51F608329798E727CB5CCA21128D", hash_generated_method = "76BE79E698B7251D3BF51E131C8CDFFE")
    public boolean isStarted() {
        boolean varF7BD74CE9A58FA4CCEA8BB81790EAC23_1865415482 = (isRunning());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1853781609 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1853781609;
        // ---------- Original Method ----------
        //return isRunning();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.833 -0400", hash_original_method = "9023764EFF4F5DD5C344B401D2F44A3C", hash_generated_method = "AF6F7DF4131BFA1F773F940D8B5D8057")
    public void addListener(AnimatorListener listener) {
        addTaint(listener.getTaint());
        if(mListeners == null)        
        {
            mListeners = new ArrayList<AnimatorListener>();
        } //End block
        mListeners.add(listener);
        // ---------- Original Method ----------
        //if (mListeners == null) {
            //mListeners = new ArrayList<AnimatorListener>();
        //}
        //mListeners.add(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.836 -0400", hash_original_method = "AF89FA0687B9630A1A89E59A21836778", hash_generated_method = "3C0FFCE85AC2501FD610186ED4E6FC48")
    public void removeListener(AnimatorListener listener) {
        addTaint(listener.getTaint());
        if(mListeners == null)        
        {
            return;
        } //End block
        mListeners.remove(listener);
        if(mListeners.size() == 0)        
        {
            mListeners = null;
        } //End block
        // ---------- Original Method ----------
        //if (mListeners == null) {
            //return;
        //}
        //mListeners.remove(listener);
        //if (mListeners.size() == 0) {
            //mListeners = null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.840 -0400", hash_original_method = "A0C570F4990D85172FF1B2594590DE80", hash_generated_method = "80EB6D23C0E183B892E0E9305C327579")
    public ArrayList<AnimatorListener> getListeners() {
ArrayList<AnimatorListener> var6F226E74DAC534764C2244A2BF49F27C_7535036 =         mListeners;
        var6F226E74DAC534764C2244A2BF49F27C_7535036.addTaint(taint);
        return var6F226E74DAC534764C2244A2BF49F27C_7535036;
        // ---------- Original Method ----------
        //return mListeners;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.844 -0400", hash_original_method = "9F15C7E7001670487AA27A3E97528F7B", hash_generated_method = "5B058AAE3460F4AEFCF3F780E30BA666")
    public void removeAllListeners() {
        if(mListeners != null)        
        {
            mListeners.clear();
            mListeners = null;
        } //End block
        // ---------- Original Method ----------
        //if (mListeners != null) {
            //mListeners.clear();
            //mListeners = null;
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.853 -0400", hash_original_method = "D34181C2AB04F8825A2BE8661E83342B", hash_generated_method = "412815C57F1A77E71236CF0F155CB0D6")
    @Override
    public Animator clone() {
        try 
        {
            final Animator anim = (Animator) super.clone();
            if(mListeners != null)            
            {
                ArrayList<AnimatorListener> oldListeners = mListeners;
                anim.mListeners = new ArrayList<AnimatorListener>();
                int numListeners = oldListeners.size();
for(int i = 0;i < numListeners;++i)
                {
                    anim.mListeners.add(oldListeners.get(i));
                } //End block
            } //End block
Animator var6E2178F33F884BED37C5DEBCD18F9A96_1651601836 =             anim;
            var6E2178F33F884BED37C5DEBCD18F9A96_1651601836.addTaint(taint);
            return var6E2178F33F884BED37C5DEBCD18F9A96_1651601836;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA81442E36297E737EB908877E58260E8_40329820 = new AssertionError();
            varA81442E36297E737EB908877E58260E8_40329820.addTaint(taint);
            throw varA81442E36297E737EB908877E58260E8_40329820;
        } //End block
        // ---------- Original Method ----------
        //try {
            //final Animator anim = (Animator) super.clone();
            //if (mListeners != null) {
                //ArrayList<AnimatorListener> oldListeners = mListeners;
                //anim.mListeners = new ArrayList<AnimatorListener>();
                //int numListeners = oldListeners.size();
                //for (int i = 0; i < numListeners; ++i) {
                    //anim.mListeners.add(oldListeners.get(i));
                //}
            //}
            //return anim;
        //} catch (CloneNotSupportedException e) {
           //throw new AssertionError();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.857 -0400", hash_original_method = "32F08DC85010676418427AA8D9A17152", hash_generated_method = "BF5AF1AD862E3A79F4B93BAB44171538")
    public void setupStartValues() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.859 -0400", hash_original_method = "4E652EB88F78E42C7E65C332BEA7074B", hash_generated_method = "F85A6F7F464E8F9389DDB8CE57A7E36C")
    public void setupEndValues() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.863 -0400", hash_original_method = "0B5C67CA62B433384E1BDDE3EB79AFB5", hash_generated_method = "085860A0B63A5244CC48441EE96D69F4")
    public void setTarget(Object target) {
        addTaint(target.getTaint());
        // ---------- Original Method ----------
    }

    
    public static interface AnimatorListener {
        
        void onAnimationStart(Animator animation);

        
        void onAnimationEnd(Animator animation);

        
        void onAnimationCancel(Animator animation);

        
        void onAnimationRepeat(Animator animation);
    }
    
}

