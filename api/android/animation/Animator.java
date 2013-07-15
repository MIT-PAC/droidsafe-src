package android.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;

public abstract class Animator implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.465 -0400", hash_original_field = "76E8AF78EA383C38A6F80E45CCFEA268", hash_generated_field = "3FD42DDC5A574D761F1E8BD3EC073311")

    ArrayList<AnimatorListener> mListeners = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.466 -0400", hash_original_method = "12606DD4E4D75078EE1609D9ED5651A9", hash_generated_method = "12606DD4E4D75078EE1609D9ED5651A9")
    public Animator ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.467 -0400", hash_original_method = "077E81C30B4BFFEF2F9502DB378CA204", hash_generated_method = "A801E423F89557B74070F06DC0AB8DFA")
    public void start() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.468 -0400", hash_original_method = "E5C5DBED2FC0D18DB80484DB83D94F8A", hash_generated_method = "43CBBEFF14DFE69DF0FC06DADAEF94C2")
    public void cancel() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.469 -0400", hash_original_method = "4F105473DD7236D24F8992C8503B57B1", hash_generated_method = "9DFCE4A1701D66E2F860131DA801747C")
    public void end() {
        // ---------- Original Method ----------
    }

    
    public abstract long getStartDelay();

    
    public abstract void setStartDelay(long startDelay);

    
    public abstract Animator setDuration(long duration);

    
    public abstract long getDuration();

    
    public abstract void setInterpolator(TimeInterpolator value);

    
    public abstract boolean isRunning();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.476 -0400", hash_original_method = "5FAE51F608329798E727CB5CCA21128D", hash_generated_method = "C905F647E73DD4113EED78AF69A0FC7C")
    public boolean isStarted() {
        boolean varF7BD74CE9A58FA4CCEA8BB81790EAC23_1591580303 = (isRunning());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_876652487 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_876652487;
        // ---------- Original Method ----------
        //return isRunning();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.479 -0400", hash_original_method = "9023764EFF4F5DD5C344B401D2F44A3C", hash_generated_method = "AF6F7DF4131BFA1F773F940D8B5D8057")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.484 -0400", hash_original_method = "AF89FA0687B9630A1A89E59A21836778", hash_generated_method = "3C0FFCE85AC2501FD610186ED4E6FC48")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.489 -0400", hash_original_method = "A0C570F4990D85172FF1B2594590DE80", hash_generated_method = "C57AFCEF3F8D7F07234F527CB1A2E09F")
    public ArrayList<AnimatorListener> getListeners() {
ArrayList<AnimatorListener> var6F226E74DAC534764C2244A2BF49F27C_1815042848 =         mListeners;
        var6F226E74DAC534764C2244A2BF49F27C_1815042848.addTaint(taint);
        return var6F226E74DAC534764C2244A2BF49F27C_1815042848;
        // ---------- Original Method ----------
        //return mListeners;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.491 -0400", hash_original_method = "9F15C7E7001670487AA27A3E97528F7B", hash_generated_method = "5B058AAE3460F4AEFCF3F780E30BA666")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.495 -0400", hash_original_method = "D34181C2AB04F8825A2BE8661E83342B", hash_generated_method = "012A5A2E20E3D4F5789BECFAD2A23904")
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
Animator var6E2178F33F884BED37C5DEBCD18F9A96_1953532838 =             anim;
            var6E2178F33F884BED37C5DEBCD18F9A96_1953532838.addTaint(taint);
            return var6E2178F33F884BED37C5DEBCD18F9A96_1953532838;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA81442E36297E737EB908877E58260E8_1312913070 = new AssertionError();
            varA81442E36297E737EB908877E58260E8_1312913070.addTaint(taint);
            throw varA81442E36297E737EB908877E58260E8_1312913070;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.497 -0400", hash_original_method = "32F08DC85010676418427AA8D9A17152", hash_generated_method = "BF5AF1AD862E3A79F4B93BAB44171538")
    public void setupStartValues() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.498 -0400", hash_original_method = "4E652EB88F78E42C7E65C332BEA7074B", hash_generated_method = "F85A6F7F464E8F9389DDB8CE57A7E36C")
    public void setupEndValues() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.500 -0400", hash_original_method = "0B5C67CA62B433384E1BDDE3EB79AFB5", hash_generated_method = "085860A0B63A5244CC48441EE96D69F4")
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

