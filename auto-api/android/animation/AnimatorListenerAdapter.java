package android.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class AnimatorListenerAdapter implements Animator.AnimatorListener {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.874 -0400", hash_original_method = "3239F8E64103A5EFEAA04A508EA5DAA5", hash_generated_method = "3239F8E64103A5EFEAA04A508EA5DAA5")
        public AnimatorListenerAdapter ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.874 -0400", hash_original_method = "16FF962612CA0CC38B4765F38064800C", hash_generated_method = "48C2321585D7270ECEF5AA43CFB95837")
    @DSModeled(DSC.SAFE)
    @Override
    public void onAnimationCancel(Animator animation) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(animation.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.875 -0400", hash_original_method = "5CF474E58C527E8964A758ECD279FAE2", hash_generated_method = "F8F506F997A11F14FCEB55912544158D")
    @DSModeled(DSC.SAFE)
    @Override
    public void onAnimationEnd(Animator animation) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(animation.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.876 -0400", hash_original_method = "FA58700A4888ED9E658B43737D17A966", hash_generated_method = "2D32F9A43E5261B156C7705DA49965D8")
    @DSModeled(DSC.SAFE)
    @Override
    public void onAnimationRepeat(Animator animation) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(animation.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.876 -0400", hash_original_method = "B990D1A680B01C8A5486D22741D7E96B", hash_generated_method = "C15E52C113AB38D8B645FC895A607B2B")
    @DSModeled(DSC.SAFE)
    @Override
    public void onAnimationStart(Animator animation) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(animation.dsTaint);
        // ---------- Original Method ----------
    }

    
}

