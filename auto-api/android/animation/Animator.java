package android.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;

public abstract class Animator implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:45.062 -0400", hash_original_field = "76E8AF78EA383C38A6F80E45CCFEA268", hash_generated_field = "3FD42DDC5A574D761F1E8BD3EC073311")

    ArrayList<AnimatorListener> mListeners = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:45.080 -0400", hash_original_method = "12606DD4E4D75078EE1609D9ED5651A9", hash_generated_method = "12606DD4E4D75078EE1609D9ED5651A9")
    public Animator ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:45.093 -0400", hash_original_method = "077E81C30B4BFFEF2F9502DB378CA204", hash_generated_method = "A801E423F89557B74070F06DC0AB8DFA")
    public void start() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:45.116 -0400", hash_original_method = "E5C5DBED2FC0D18DB80484DB83D94F8A", hash_generated_method = "43CBBEFF14DFE69DF0FC06DADAEF94C2")
    public void cancel() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:45.142 -0400", hash_original_method = "4F105473DD7236D24F8992C8503B57B1", hash_generated_method = "9DFCE4A1701D66E2F860131DA801747C")
    public void end() {
        // ---------- Original Method ----------
    }

    
    public abstract long getStartDelay();

    
    public abstract void setStartDelay(long startDelay);

    
    public abstract Animator setDuration(long duration);

    
    public abstract long getDuration();

    
    public abstract void setInterpolator(TimeInterpolator value);

    
    public abstract boolean isRunning();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:45.215 -0400", hash_original_method = "5FAE51F608329798E727CB5CCA21128D", hash_generated_method = "ABF7AF2070795E0A355CD481CEF6436B")
    public boolean isStarted() {
        boolean var69DB4A960590F66961631BAE04853E89_279831132 = (isRunning());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1627376089 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1627376089;
        // ---------- Original Method ----------
        //return isRunning();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:45.263 -0400", hash_original_method = "9023764EFF4F5DD5C344B401D2F44A3C", hash_generated_method = "BDE559C1AD5FF66AA451B9EDA437EDDC")
    public void addListener(AnimatorListener listener) {
        {
            mListeners = new ArrayList<AnimatorListener>();
        } //End block
        mListeners.add(listener);
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //if (mListeners == null) {
            //mListeners = new ArrayList<AnimatorListener>();
        //}
        //mListeners.add(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:45.331 -0400", hash_original_method = "AF89FA0687B9630A1A89E59A21836778", hash_generated_method = "9BB38F6FB2E82C257D37991D16D0460D")
    public void removeListener(AnimatorListener listener) {
        mListeners.remove(listener);
        {
            boolean var7B2C678F8EBFAB58FB4766D26112D84C_1669342170 = (mListeners.size() == 0);
            {
                mListeners = null;
            } //End block
        } //End collapsed parenthetic
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //if (mListeners == null) {
            //return;
        //}
        //mListeners.remove(listener);
        //if (mListeners.size() == 0) {
            //mListeners = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:45.364 -0400", hash_original_method = "A0C570F4990D85172FF1B2594590DE80", hash_generated_method = "45405F6357789540E413CC2686A50748")
    public ArrayList<AnimatorListener> getListeners() {
        ArrayList<AnimatorListener> varB4EAC82CA7396A68D541C85D26508E83_2039991647 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2039991647 = mListeners;
        varB4EAC82CA7396A68D541C85D26508E83_2039991647.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2039991647;
        // ---------- Original Method ----------
        //return mListeners;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:45.403 -0400", hash_original_method = "9F15C7E7001670487AA27A3E97528F7B", hash_generated_method = "7182680AEBBB723CE7196DE15F2F736A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:45.488 -0400", hash_original_method = "D34181C2AB04F8825A2BE8661E83342B", hash_generated_method = "C322116129ECF25205F6C75CAFEBBDFB")
    @Override
    public Animator clone() {
        Animator varB4EAC82CA7396A68D541C85D26508E83_454923363 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_454923363 = anim;
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_454923363.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_454923363;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:45.520 -0400", hash_original_method = "32F08DC85010676418427AA8D9A17152", hash_generated_method = "BF5AF1AD862E3A79F4B93BAB44171538")
    public void setupStartValues() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:45.537 -0400", hash_original_method = "4E652EB88F78E42C7E65C332BEA7074B", hash_generated_method = "F85A6F7F464E8F9389DDB8CE57A7E36C")
    public void setupEndValues() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:45.551 -0400", hash_original_method = "0B5C67CA62B433384E1BDDE3EB79AFB5", hash_generated_method = "085860A0B63A5244CC48441EE96D69F4")
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

