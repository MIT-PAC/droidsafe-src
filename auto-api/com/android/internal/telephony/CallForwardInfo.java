package com.android.internal.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.telephony.PhoneNumberUtils;

public class CallForwardInfo {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.491 -0400", hash_original_field = "9ACB44549B41563697BB490144EC6258", hash_generated_field = "E9243AA6ACDC688110619DDCF59ACF0B")

    public int status;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.491 -0400", hash_original_field = "40BEA8D637CDF2C1B07FCF0630482B73", hash_generated_field = "4CD87EFFD76230E744684521DDB4CA27")

    public int reason;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.491 -0400", hash_original_field = "DB5C79ECE95FFF211F38DA6EF0C80673", hash_generated_field = "E084E4CD80C0302BF3BC150DFB947842")

    public int serviceClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.491 -0400", hash_original_field = "937DBB9A0118D36E0A642441A8BA71F7", hash_generated_field = "BA17426A58710B9C5E5B752C001049B9")

    public int toa;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.491 -0400", hash_original_field = "B1BC248A7FF2B2E95569F56DE68615DF", hash_generated_field = "35C5A82434F6EB5F96609BC97C13822F")

    public String number;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.491 -0400", hash_original_field = "B027311958C60F0B86890A8ABF172D72", hash_generated_field = "5D1F33269E9E5D70AC3DCFCD9620B054")

    public int timeSeconds;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.491 -0400", hash_original_method = "1AD2DD7ADA01B6155671A6205A67842C", hash_generated_method = "1AD2DD7ADA01B6155671A6205A67842C")
    public CallForwardInfo ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.492 -0400", hash_original_method = "EA7E7BF9BED1BC105930545F926483CA", hash_generated_method = "0EB59ED9CD8F9221538A9F1E4CC81139")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2081492170 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2081492170 = super.toString() + (status == 0 ? " not active " : " active ")
            + " reason: " + reason
            + " serviceClass: " + serviceClass
            + " \"" + PhoneNumberUtils.stringFromStringAndTOA(number, toa) + "\" "
            + timeSeconds + " seconds";
        varB4EAC82CA7396A68D541C85D26508E83_2081492170.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2081492170;
        
        
            
            
            
            
    }

    
}

