package android.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.ArrayList;

public abstract class Animator implements Cloneable {
    ArrayList<AnimatorListener> mListeners = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.817 -0400", hash_original_method = "077E81C30B4BFFEF2F9502DB378CA204", hash_generated_method = "8A429BCD41064487628C2ED5F3B03BDD")
    @DSModeled(DSC.SAFE)
    public void start() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.818 -0400", hash_original_method = "E5C5DBED2FC0D18DB80484DB83D94F8A", hash_generated_method = "A5EBC8624E6BC5560137C8161084FE89")
    @DSModeled(DSC.SAFE)
    public void cancel() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.818 -0400", hash_original_method = "4F105473DD7236D24F8992C8503B57B1", hash_generated_method = "56B53D30BB56F5522F8F679948244BD2")
    @DSModeled(DSC.SAFE)
    public void end() {
        // ---------- Original Method ----------
    }

    
    public abstract long getStartDelay();

    
    public abstract void setStartDelay(long startDelay);

    
    public abstract Animator setDuration(long duration);

    
    public abstract long getDuration();

    
    public abstract void setInterpolator(TimeInterpolator value);

    
    public abstract boolean isRunning();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.820 -0400", hash_original_method = "5FAE51F608329798E727CB5CCA21128D", hash_generated_method = "D1344510B6F965922CEE8949B39DB5A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isStarted() {
        boolean var69DB4A960590F66961631BAE04853E89_1576794172 = (isRunning());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isRunning();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.821 -0400", hash_original_method = "9023764EFF4F5DD5C344B401D2F44A3C", hash_generated_method = "C2C9AC3C95D83DBDDB2264B0FCBE2777")
    @DSModeled(DSC.SAFE)
    public void addListener(AnimatorListener listener) {
        dsTaint.addTaint(listener.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.822 -0400", hash_original_method = "AF89FA0687B9630A1A89E59A21836778", hash_generated_method = "A2A87BB91BC5CC4E7F59200174F58F48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeListener(AnimatorListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        mListeners.remove(listener);
        {
            boolean var7B2C678F8EBFAB58FB4766D26112D84C_1800700827 = (mListeners.size() == 0);
            {
                mListeners = null;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mListeners == null) {
            //return;
        //}
        //mListeners.remove(listener);
        //if (mListeners.size() == 0) {
            //mListeners = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.823 -0400", hash_original_method = "A0C570F4990D85172FF1B2594590DE80", hash_generated_method = "9DF597985F9BC0E6F05CB21D4F9BE9DF")
    @DSModeled(DSC.SAFE)
    public ArrayList<AnimatorListener> getListeners() {
        return (ArrayList<AnimatorListener>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mListeners;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.823 -0400", hash_original_method = "9F15C7E7001670487AA27A3E97528F7B", hash_generated_method = "838B17361BD21B24B836F75108452423")
    @DSModeled(DSC.SAFE)
    public void removeAllListeners() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.824 -0400", hash_original_method = "D34181C2AB04F8825A2BE8661E83342B", hash_generated_method = "4AAE2FBAB106F04EEF75E28CCF4A56CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Animator clone() {
        try 
        {
            final Animator anim;
            anim = (Animator) super.clone();
            {
                ArrayList<AnimatorListener> oldListeners;
                oldListeners = mListeners;
                anim.mListeners = new ArrayList<AnimatorListener>();
                int numListeners;
                numListeners = oldListeners.size();
                {
                    int i;
                    i = 0;
                    {
                        anim.mListeners.add(oldListeners.get(i));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        catch (CloneNotSupportedException e)
        {
            throw new AssertionError();
        } //End block
        return (Animator)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.825 -0400", hash_original_method = "32F08DC85010676418427AA8D9A17152", hash_generated_method = "2BFD4B9899D3ABADEE485927599FAA79")
    @DSModeled(DSC.SAFE)
    public void setupStartValues() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.826 -0400", hash_original_method = "4E652EB88F78E42C7E65C332BEA7074B", hash_generated_method = "9AF7619C6FF1E538ACAAF00E2AE04318")
    @DSModeled(DSC.SAFE)
    public void setupEndValues() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.826 -0400", hash_original_method = "0B5C67CA62B433384E1BDDE3EB79AFB5", hash_generated_method = "0C777EECDF69FA3A6825BD888F58F4CD")
    @DSModeled(DSC.SAFE)
    public void setTarget(Object target) {
        dsTaint.addTaint(target.dsTaint);
        // ---------- Original Method ----------
    }

    
    public static interface AnimatorListener {
        
        void onAnimationStart(Animator animation);

        
        void onAnimationEnd(Animator animation);

        
        void onAnimationCancel(Animator animation);

        
        void onAnimationRepeat(Animator animation);
    }
    
}


