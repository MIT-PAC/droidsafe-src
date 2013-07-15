package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class ResultException extends CatException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.436 -0400", hash_original_field = "313AEF43C06545BCEAC152A1C285EBE1", hash_generated_field = "4AC7FC9F4E020263BC66789E594B2993")

    private ResultCode mResult;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.436 -0400", hash_original_field = "6498C80FCD262D5996F8FC6DFBCB3810", hash_generated_field = "CBC99389386D87423ED8125BD72ABE6E")

    private int mAdditionalInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.436 -0400", hash_original_method = "68A91FDF5AB4F0330196DC8A0AB86338", hash_generated_method = "F2FADFCC30E76631514698BDCA558F6F")
    public  ResultException(ResultCode result) {
        super();
switch(result){
        case TERMINAL_CRNTLY_UNABLE_TO_PROCESS:
        case NETWORK_CRNTLY_UNABLE_TO_PROCESS:
        case LAUNCH_BROWSER_ERROR:
        case MULTI_CARDS_CMD_ERROR:
        case USIM_CALL_CONTROL_PERMANENT:
        case BIP_ERROR:
        case FRAMES_ERROR:
        case MMS_ERROR:
        AssertionError var33E7929F74F47B391FB5094D4EA0FA2E_1630524016 = new AssertionError(
                        "For result code, " + result +
                        ", additional information must be given!");
        var33E7929F74F47B391FB5094D4EA0FA2E_1630524016.addTaint(taint);
        throw var33E7929F74F47B391FB5094D4EA0FA2E_1630524016;
}        mResult = result;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.437 -0400", hash_original_method = "04974938152AFE565028AB1B397B6372", hash_generated_method = "384EE0B38CBD4EF488144DB8763928F0")
    public  ResultException(ResultCode result, int additionalInfo) {
        super();
    if(additionalInfo < 0)        
        {
            AssertionError var30A8245AE5940E473F92B163F3FFEB21_1730852641 = new AssertionError(
                    "Additional info must be greater than zero!");
            var30A8245AE5940E473F92B163F3FFEB21_1730852641.addTaint(taint);
            throw var30A8245AE5940E473F92B163F3FFEB21_1730852641;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.437 -0400", hash_original_method = "A57BD664B9013CBC4792F94DA18D35A2", hash_generated_method = "F11503413B099E7A79622CC75DFF52C3")
    public ResultCode result() {
ResultCode var8EC17D26103D23643357521909BC2C9A_2107171367 =         mResult;
        var8EC17D26103D23643357521909BC2C9A_2107171367.addTaint(taint);
        return var8EC17D26103D23643357521909BC2C9A_2107171367;
        // ---------- Original Method ----------
        //return mResult;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.438 -0400", hash_original_method = "AD79E69220253098AEFB7D9A4D5D98C9", hash_generated_method = "E6D3E2277772EB74BDC255ED1393CB76")
    public boolean hasAdditionalInfo() {
        boolean var3EA2D272F0FBB334247B11D270B31BE9_2086994566 = (mAdditionalInfo >= 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1205973301 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1205973301;
        // ---------- Original Method ----------
        //return mAdditionalInfo >= 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.438 -0400", hash_original_method = "B6D84D422E51AC37891071F2EE987CA4", hash_generated_method = "C7E716A3499B84AC949B4A0187EBF2E8")
    public int additionalInfo() {
        int var6498C80FCD262D5996F8FC6DFBCB3810_1428367724 = (mAdditionalInfo);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1742609601 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1742609601;
        // ---------- Original Method ----------
        //return mAdditionalInfo;
    }

    
}

