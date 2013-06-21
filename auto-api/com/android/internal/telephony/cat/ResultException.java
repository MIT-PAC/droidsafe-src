package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ResultException extends CatException {
    private ResultCode mResult;
    private int mAdditionalInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.997 -0400", hash_original_method = "68A91FDF5AB4F0330196DC8A0AB86338", hash_generated_method = "CE0CD70F8347A944F5DC591D16E15062")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ResultException(ResultCode result) {
        super();
        dsTaint.addTaint(result.dsTaint);
        //Begin case TERMINAL_CRNTLY_UNABLE_TO_PROCESS NETWORK_CRNTLY_UNABLE_TO_PROCESS LAUNCH_BROWSER_ERROR MULTI_CARDS_CMD_ERROR USIM_CALL_CONTROL_PERMANENT BIP_ERROR FRAMES_ERROR MMS_ERROR 
        if (DroidSafeAndroidRuntime.control) throw new AssertionError(
                        "For result code, " + result +
                        ", additional information must be given!");
        //End case TERMINAL_CRNTLY_UNABLE_TO_PROCESS NETWORK_CRNTLY_UNABLE_TO_PROCESS LAUNCH_BROWSER_ERROR MULTI_CARDS_CMD_ERROR USIM_CALL_CONTROL_PERMANENT BIP_ERROR FRAMES_ERROR MMS_ERROR 
        mAdditionalInfo = -1;
        // ---------- Original Method ----------
        //switch (result) {
            //case TERMINAL_CRNTLY_UNABLE_TO_PROCESS:    
            //case NETWORK_CRNTLY_UNABLE_TO_PROCESS:     
            //case LAUNCH_BROWSER_ERROR:                 
            //case MULTI_CARDS_CMD_ERROR:                
            //case USIM_CALL_CONTROL_PERMANENT:          
            //case BIP_ERROR:                            
            //case FRAMES_ERROR:                         
            //case MMS_ERROR:                            
                //throw new AssertionError(
                        //"For result code, " + result +
                        //", additional information must be given!");
        //}
        //mResult = result;
        //mAdditionalInfo = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.997 -0400", hash_original_method = "04974938152AFE565028AB1B397B6372", hash_generated_method = "90F0F49DCD256569FE9AAD8582412607")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ResultException(ResultCode result, int additionalInfo) {
        super();
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(additionalInfo);
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(
                    "Additional info must be greater than zero!");
        } //End block
        // ---------- Original Method ----------
        //if (additionalInfo < 0) {
            //throw new AssertionError(
                    //"Additional info must be greater than zero!");
        //}
        //mResult = result;
        //mAdditionalInfo = additionalInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.998 -0400", hash_original_method = "A57BD664B9013CBC4792F94DA18D35A2", hash_generated_method = "610DB47E262E666C100AF985E5268461")
    @DSModeled(DSC.SAFE)
    public ResultCode result() {
        return (ResultCode)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mResult;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.998 -0400", hash_original_method = "AD79E69220253098AEFB7D9A4D5D98C9", hash_generated_method = "79C4066A3D24C5DA3A4F06F4F7C21FFE")
    @DSModeled(DSC.SAFE)
    public boolean hasAdditionalInfo() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAdditionalInfo >= 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.998 -0400", hash_original_method = "B6D84D422E51AC37891071F2EE987CA4", hash_generated_method = "F7DE115FE53AD977C3EDBD457924F933")
    @DSModeled(DSC.SAFE)
    public int additionalInfo() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mAdditionalInfo;
    }

    
}

