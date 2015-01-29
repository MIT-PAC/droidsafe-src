package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class ResultException extends CatException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.598 -0500", hash_original_field = "115A09806B035A9C2A9F9E9F3A37F598", hash_generated_field = "4AC7FC9F4E020263BC66789E594B2993")

    private ResultCode mResult;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.601 -0500", hash_original_field = "70854963B65996F51B0DD07E81D3DBE8", hash_generated_field = "CBC99389386D87423ED8125BD72ABE6E")

    private int mAdditionalInfo;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.604 -0500", hash_original_method = "68A91FDF5AB4F0330196DC8A0AB86338", hash_generated_method = "B634DA81137103DD6AF19A5BA68722BD")
    
public ResultException(ResultCode result) {
        super();

        // ETSI TS 102 223, 8.12 -- For the general results '20', '21', '26',
        // '38', '39', '3A', '3C', and '3D', it is mandatory for the terminal
        // to provide a specific cause value as additional information.
        switch (result) {
            case TERMINAL_CRNTLY_UNABLE_TO_PROCESS:    // 0x20
            case NETWORK_CRNTLY_UNABLE_TO_PROCESS:     // 0x21
            case LAUNCH_BROWSER_ERROR:                 // 0x26
            case MULTI_CARDS_CMD_ERROR:                // 0x38
            case USIM_CALL_CONTROL_PERMANENT:          // 0x39
            case BIP_ERROR:                            // 0x3a
            case FRAMES_ERROR:                         // 0x3c
            case MMS_ERROR:                            // 0x3d
                throw new AssertionError(
                        "For result code, " + result +
                        ", additional information must be given!");
        }

        mResult = result;
        mAdditionalInfo = -1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.607 -0500", hash_original_method = "04974938152AFE565028AB1B397B6372", hash_generated_method = "B46938F6D4F89ACF15851B9607BC19A7")
    
public ResultException(ResultCode result, int additionalInfo) {
        super();

        if (additionalInfo < 0) {
            throw new AssertionError(
                    "Additional info must be greater than zero!");
        }

        mResult = result;
        mAdditionalInfo = additionalInfo;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.609 -0500", hash_original_method = "A57BD664B9013CBC4792F94DA18D35A2", hash_generated_method = "F9A620449F2DA1FD900A9177C7353A34")
    
public ResultCode result() {
        return mResult;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.611 -0500", hash_original_method = "AD79E69220253098AEFB7D9A4D5D98C9", hash_generated_method = "F10D1BA9991E2F435F40C9067C4C5443")
    
public boolean hasAdditionalInfo() {
        return mAdditionalInfo >= 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.613 -0500", hash_original_method = "B6D84D422E51AC37891071F2EE987CA4", hash_generated_method = "5454E2B18A9BE8FB4E97F16CFFB98BCB")
    
public int additionalInfo() {
        return mAdditionalInfo;
    }

    
}

