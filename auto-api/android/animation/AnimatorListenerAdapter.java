package android.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public abstract class AnimatorListenerAdapter implements Animator.AnimatorListener {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.828 -0400", hash_original_method = "16FF962612CA0CC38B4765F38064800C", hash_generated_method = "1BC0C718FD765BD9EDB80DA5FE6E2332")
    @DSModeled(DSC.SAFE)
    @Override
    public void onAnimationCancel(Animator animation) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(animation.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.829 -0400", hash_original_method = "5CF474E58C527E8964A758ECD279FAE2", hash_generated_method = "39BA00246ADC9D6EC682D2311E571D4A")
    @DSModeled(DSC.SAFE)
    @Override
    public void onAnimationEnd(Animator animation) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(animation.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.829 -0400", hash_original_method = "FA58700A4888ED9E658B43737D17A966", hash_generated_method = "75FF296FC60604A343A82AB9CB8690F0")
    @DSModeled(DSC.SAFE)
    @Override
    public void onAnimationRepeat(Animator animation) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(animation.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.830 -0400", hash_original_method = "B990D1A680B01C8A5486D22741D7E96B", hash_generated_method = "055CED28A243DDD2B0445C0C4C3FE2BE")
    @DSModeled(DSC.SAFE)
    @Override
    public void onAnimationStart(Animator animation) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(animation.dsTaint);
        // ---------- Original Method ----------
    }

    
}


