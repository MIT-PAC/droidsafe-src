package android.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;

public abstract class Animator implements Cloneable {
    ArrayList<AnimatorListener> mListeners = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.816 -0400", hash_original_method = "336A903C803FDB1E314910987278FAEA", hash_generated_method = "336A903C803FDB1E314910987278FAEA")
        public Animator ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.816 -0400", hash_original_method = "077E81C30B4BFFEF2F9502DB378CA204", hash_generated_method = "A801E423F89557B74070F06DC0AB8DFA")
    @DSModeled(DSC.SAFE)
    public void start() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.817 -0400", hash_original_method = "E5C5DBED2FC0D18DB80484DB83D94F8A", hash_generated_method = "43CBBEFF14DFE69DF0FC06DADAEF94C2")
    @DSModeled(DSC.SAFE)
    public void cancel() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.818 -0400", hash_original_method = "4F105473DD7236D24F8992C8503B57B1", hash_generated_method = "9DFCE4A1701D66E2F860131DA801747C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.823 -0400", hash_original_method = "5FAE51F608329798E727CB5CCA21128D", hash_generated_method = "88EBE40F02E7D59ECEF9E026106DEE92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isStarted() {
        boolean var69DB4A960590F66961631BAE04853E89_970750831 = (isRunning());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isRunning();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.824 -0400", hash_original_method = "9023764EFF4F5DD5C344B401D2F44A3C", hash_generated_method = "0FD241F565CCF3F95C398BB65ADCC3ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.826 -0400", hash_original_method = "AF89FA0687B9630A1A89E59A21836778", hash_generated_method = "B0A16741E3C1C91EC7C67E14BC3B9C79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeListener(AnimatorListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        mListeners.remove(listener);
        {
            boolean var7B2C678F8EBFAB58FB4766D26112D84C_1722786020 = (mListeners.size() == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.826 -0400", hash_original_method = "A0C570F4990D85172FF1B2594590DE80", hash_generated_method = "C9D08FCF041F9ECCD8C81DA1F95F4030")
    @DSModeled(DSC.SAFE)
    public ArrayList<AnimatorListener> getListeners() {
        return (ArrayList<AnimatorListener>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mListeners;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.827 -0400", hash_original_method = "9F15C7E7001670487AA27A3E97528F7B", hash_generated_method = "7182680AEBBB723CE7196DE15F2F736A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.828 -0400", hash_original_method = "D34181C2AB04F8825A2BE8661E83342B", hash_generated_method = "4D000E5C91E5EE29567C18A12EC141BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Animator clone() {
        try 
        {
            Animator anim;
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
            if (DroidSafeAndroidRuntime.control) throw new AssertionError();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.829 -0400", hash_original_method = "32F08DC85010676418427AA8D9A17152", hash_generated_method = "BF5AF1AD862E3A79F4B93BAB44171538")
    @DSModeled(DSC.SAFE)
    public void setupStartValues() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.831 -0400", hash_original_method = "4E652EB88F78E42C7E65C332BEA7074B", hash_generated_method = "F85A6F7F464E8F9389DDB8CE57A7E36C")
    @DSModeled(DSC.SAFE)
    public void setupEndValues() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.832 -0400", hash_original_method = "0B5C67CA62B433384E1BDDE3EB79AFB5", hash_generated_method = "76BD06DFA1B55DF4403E8374B86954A5")
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

