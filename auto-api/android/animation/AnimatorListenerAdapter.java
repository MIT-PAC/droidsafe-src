package android.animation;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public abstract class AnimatorListenerAdapter implements Animator.AnimatorListener {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.965 -0400", hash_original_method = "577D05693184EE178A20150D84A37CD4", hash_generated_method = "577D05693184EE178A20150D84A37CD4")
    public AnimatorListenerAdapter ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.965 -0400", hash_original_method = "16FF962612CA0CC38B4765F38064800C", hash_generated_method = "87B148FBA6A6D3270D8BD7F9EEB4C6C1")
    @Override
    public void onAnimationCancel(Animator animation) {
        
        addTaint(animation.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.966 -0400", hash_original_method = "5CF474E58C527E8964A758ECD279FAE2", hash_generated_method = "9FD1D86737CB6EF909820EA3AC18580A")
    @Override
    public void onAnimationEnd(Animator animation) {
        
        addTaint(animation.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.967 -0400", hash_original_method = "FA58700A4888ED9E658B43737D17A966", hash_generated_method = "4BE2C3EAC3B10B8BD5CE86F0E3077935")
    @Override
    public void onAnimationRepeat(Animator animation) {
        
        addTaint(animation.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.968 -0400", hash_original_method = "B990D1A680B01C8A5486D22741D7E96B", hash_generated_method = "B2B2A92B36E552BECB72262238AEF578")
    @Override
    public void onAnimationStart(Animator animation) {
        
        addTaint(animation.getTaint());
        
    }

    
}

