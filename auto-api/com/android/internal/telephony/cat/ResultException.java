package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ResultException extends CatException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.811 -0400", hash_original_field = "313AEF43C06545BCEAC152A1C285EBE1", hash_generated_field = "4AC7FC9F4E020263BC66789E594B2993")

    private ResultCode mResult;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.811 -0400", hash_original_field = "6498C80FCD262D5996F8FC6DFBCB3810", hash_generated_field = "CBC99389386D87423ED8125BD72ABE6E")

    private int mAdditionalInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.812 -0400", hash_original_method = "68A91FDF5AB4F0330196DC8A0AB86338", hash_generated_method = "9EC3F772E884FA27283B606E101DC285")
    public  ResultException(ResultCode result) {
        super();
        //Begin case TERMINAL_CRNTLY_UNABLE_TO_PROCESS NETWORK_CRNTLY_UNABLE_TO_PROCESS LAUNCH_BROWSER_ERROR MULTI_CARDS_CMD_ERROR USIM_CALL_CONTROL_PERMANENT BIP_ERROR FRAMES_ERROR MMS_ERROR 
        if (DroidSafeAndroidRuntime.control) throw new AssertionError(
                        "For result code, " + result +
                        ", additional information must be given!");
        //End case TERMINAL_CRNTLY_UNABLE_TO_PROCESS NETWORK_CRNTLY_UNABLE_TO_PROCESS LAUNCH_BROWSER_ERROR MULTI_CARDS_CMD_ERROR USIM_CALL_CONTROL_PERMANENT BIP_ERROR FRAMES_ERROR MMS_ERROR 
        mResult = result;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.827 -0400", hash_original_method = "04974938152AFE565028AB1B397B6372", hash_generated_method = "199B5CE58BBE38B4ACD7323418730ACE")
    public  ResultException(ResultCode result, int additionalInfo) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(
                    "Additional info must be greater than zero!");
        } //End block
        mResult = result;
        mAdditionalInfo = additionalInfo;
        // ---------- Original Method ----------
        //if (additionalInfo < 0) {
            //throw new AssertionError(
                    //"Additional info must be greater than zero!");
        //}
        //mResult = result;
        //mAdditionalInfo = additionalInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.828 -0400", hash_original_method = "A57BD664B9013CBC4792F94DA18D35A2", hash_generated_method = "91ADF55365B4EF74AD3AC590420086CE")
    public ResultCode result() {
        ResultCode varB4EAC82CA7396A68D541C85D26508E83_13850086 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_13850086 = mResult;
        varB4EAC82CA7396A68D541C85D26508E83_13850086.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_13850086;
        // ---------- Original Method ----------
        //return mResult;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.828 -0400", hash_original_method = "AD79E69220253098AEFB7D9A4D5D98C9", hash_generated_method = "B575DFC5C1592D1B0B88775F2B501101")
    public boolean hasAdditionalInfo() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1425485411 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1425485411;
        // ---------- Original Method ----------
        //return mAdditionalInfo >= 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.828 -0400", hash_original_method = "B6D84D422E51AC37891071F2EE987CA4", hash_generated_method = "FA366A9B4F27C64B03A11D265607F8DF")
    public int additionalInfo() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_702756574 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_702756574;
        // ---------- Original Method ----------
        //return mAdditionalInfo;
    }

    
}

