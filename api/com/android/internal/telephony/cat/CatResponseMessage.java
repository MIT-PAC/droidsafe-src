package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class CatResponseMessage {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.749 -0400", hash_original_field = "34DCAD2A2E3833D6A30423350AB93772", hash_generated_field = "05112D41676684E3E20082CD80AE4A57")

    CommandDetails cmdDet = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.750 -0400", hash_original_field = "030003E85FA524A9808C22C208E1599E", hash_generated_field = "D564E7393ADCB4AB0DDEC33D24527999")

    ResultCode resCode = ResultCode.OK;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.750 -0400", hash_original_field = "BB6CC32F58D19E5BE9F1FDD24E090D7E", hash_generated_field = "8A4681B05F71EED32A79F8A41E6E9871")

    int usersMenuSelection = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.750 -0400", hash_original_field = "383F25DCC19D3F9EF8451574DD86DF19", hash_generated_field = "EB0287EB6E8491AE9C6B217AC1842094")

    String usersInput = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.750 -0400", hash_original_field = "9814869222118D5AFE6EC2DCD4F4906A", hash_generated_field = "8436B3F9AA1BBF7470B139D65F31B82A")

    boolean usersYesNoSelection = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.750 -0400", hash_original_field = "CEE3764C586908F5A345A85C427767C8", hash_generated_field = "1348577A3B7DF35DDA0A6478D3302694")

    boolean usersConfirm = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.750 -0400", hash_original_method = "1B97059190C0D1E7E1481885E1591E21", hash_generated_method = "A736E1A352394AA9AE5E73C3C192311F")
    public  CatResponseMessage(CatCmdMessage cmdMsg) {
        this.cmdDet = cmdMsg.mCmdDet;
        // ---------- Original Method ----------
        //this.cmdDet = cmdMsg.mCmdDet;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.751 -0400", hash_original_method = "F48E3F317137773EE74DBBA707FC1847", hash_generated_method = "300FB1BC0AF88E29C6EEDB6706F8BB62")
    public void setResultCode(ResultCode resCode) {
        this.resCode = resCode;
        // ---------- Original Method ----------
        //this.resCode = resCode;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.751 -0400", hash_original_method = "2E34FF1D06310BCA5A707F04A208D5E3", hash_generated_method = "EB11734060F982B157F2E43DCE44E425")
    public void setMenuSelection(int selection) {
        this.usersMenuSelection = selection;
        // ---------- Original Method ----------
        //this.usersMenuSelection = selection;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.751 -0400", hash_original_method = "D6F0022EFC9B658375DA0AA4AF0678E5", hash_generated_method = "D9E9470C122C4DF3BE456085635E50F8")
    public void setInput(String input) {
        this.usersInput = input;
        // ---------- Original Method ----------
        //this.usersInput = input;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.752 -0400", hash_original_method = "6FEC3BD938C12B7F4A8404538ED69073", hash_generated_method = "CAB5F8FD14C650217CBA8EB5E144F8DE")
    public void setYesNo(boolean yesNo) {
        usersYesNoSelection = yesNo;
        // ---------- Original Method ----------
        //usersYesNoSelection = yesNo;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.752 -0400", hash_original_method = "EFA8BA2D7BACB7DB3D12098D0C022296", hash_generated_method = "DC26A7408DB624436E1DBB4F84C1827A")
    public void setConfirmation(boolean confirm) {
        usersConfirm = confirm;
        // ---------- Original Method ----------
        //usersConfirm = confirm;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.752 -0400", hash_original_method = "09210AE6CE37D89E5644571273FE7BA3", hash_generated_method = "9F0634CC0BD5268899574352262F6725")
     CommandDetails getCmdDetails() {
CommandDetails var0060BCF683BA9945E92A4949C9036F93_794621043 =         cmdDet;
        var0060BCF683BA9945E92A4949C9036F93_794621043.addTaint(taint);
        return var0060BCF683BA9945E92A4949C9036F93_794621043;
        // ---------- Original Method ----------
        //return cmdDet;
    }

    
}

