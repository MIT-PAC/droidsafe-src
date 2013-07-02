package com.android.internal.telephony.cat;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class ResultException extends CatException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.751 -0400", hash_original_field = "313AEF43C06545BCEAC152A1C285EBE1", hash_generated_field = "4AC7FC9F4E020263BC66789E594B2993")

    private ResultCode mResult;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.751 -0400", hash_original_field = "6498C80FCD262D5996F8FC6DFBCB3810", hash_generated_field = "CBC99389386D87423ED8125BD72ABE6E")

    private int mAdditionalInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.752 -0400", hash_original_method = "68A91FDF5AB4F0330196DC8A0AB86338", hash_generated_method = "9EC3F772E884FA27283B606E101DC285")
    public  ResultException(ResultCode result) {
        super();
        
        if (DroidSafeAndroidRuntime.control) throw new AssertionError(
                        "For result code, " + result +
                        ", additional information must be given!");
        
        mResult = result;
        mAdditionalInfo = -1;
        
        
            
            
            
            
            
            
            
            
                
                        
                        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.753 -0400", hash_original_method = "04974938152AFE565028AB1B397B6372", hash_generated_method = "199B5CE58BBE38B4ACD7323418730ACE")
    public  ResultException(ResultCode result, int additionalInfo) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(
                    "Additional info must be greater than zero!");
        } 
        mResult = result;
        mAdditionalInfo = additionalInfo;
        
        
            
                    
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.753 -0400", hash_original_method = "A57BD664B9013CBC4792F94DA18D35A2", hash_generated_method = "0BF5F8C88895666FE7611D307DB733E7")
    public ResultCode result() {
        ResultCode varB4EAC82CA7396A68D541C85D26508E83_1780889837 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1780889837 = mResult;
        varB4EAC82CA7396A68D541C85D26508E83_1780889837.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1780889837;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.754 -0400", hash_original_method = "AD79E69220253098AEFB7D9A4D5D98C9", hash_generated_method = "A5C7107B3CB35FFD43CF5BE5018F04D8")
    public boolean hasAdditionalInfo() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1651475536 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1651475536;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.754 -0400", hash_original_method = "B6D84D422E51AC37891071F2EE987CA4", hash_generated_method = "8178E2A9B9FC4F3BDC7B2E8D7E83117C")
    public int additionalInfo() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_94989666 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_94989666;
        
        
    }

    
}

