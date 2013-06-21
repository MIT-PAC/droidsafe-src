package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class CatResponseMessage {
    CommandDetails cmdDet = null;
    ResultCode resCode  = ResultCode.OK;
    int usersMenuSelection = 0;
    String usersInput  = null;
    boolean usersYesNoSelection = false;
    boolean usersConfirm = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.646 -0400", hash_original_method = "1B97059190C0D1E7E1481885E1591E21", hash_generated_method = "621A0E9947475A6E3C19E72024294AE6")
    @DSModeled(DSC.SAFE)
    public CatResponseMessage(CatCmdMessage cmdMsg) {
        dsTaint.addTaint(cmdMsg.dsTaint);
        this.cmdDet = cmdMsg.mCmdDet;
        // ---------- Original Method ----------
        //this.cmdDet = cmdMsg.mCmdDet;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.646 -0400", hash_original_method = "F48E3F317137773EE74DBBA707FC1847", hash_generated_method = "DD901E27683E060FB3F49731119AC410")
    @DSModeled(DSC.SAFE)
    public void setResultCode(ResultCode resCode) {
        dsTaint.addTaint(resCode.dsTaint);
        // ---------- Original Method ----------
        //this.resCode = resCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.646 -0400", hash_original_method = "2E34FF1D06310BCA5A707F04A208D5E3", hash_generated_method = "06675863BE9593560A534323BF8C1904")
    @DSModeled(DSC.SAFE)
    public void setMenuSelection(int selection) {
        dsTaint.addTaint(selection);
        // ---------- Original Method ----------
        //this.usersMenuSelection = selection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.647 -0400", hash_original_method = "D6F0022EFC9B658375DA0AA4AF0678E5", hash_generated_method = "36DDA2C0FD31D3225DA5AFEC57CC65A2")
    @DSModeled(DSC.SAFE)
    public void setInput(String input) {
        dsTaint.addTaint(input);
        // ---------- Original Method ----------
        //this.usersInput = input;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.647 -0400", hash_original_method = "6FEC3BD938C12B7F4A8404538ED69073", hash_generated_method = "AA2D273DB3C523202621433FCD28DB4A")
    @DSModeled(DSC.SAFE)
    public void setYesNo(boolean yesNo) {
        dsTaint.addTaint(yesNo);
        // ---------- Original Method ----------
        //usersYesNoSelection = yesNo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.647 -0400", hash_original_method = "EFA8BA2D7BACB7DB3D12098D0C022296", hash_generated_method = "86081FB01D4F0600D91F731322913205")
    @DSModeled(DSC.SAFE)
    public void setConfirmation(boolean confirm) {
        dsTaint.addTaint(confirm);
        // ---------- Original Method ----------
        //usersConfirm = confirm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.648 -0400", hash_original_method = "09210AE6CE37D89E5644571273FE7BA3", hash_generated_method = "4AA6700B484EA0A0D17BBBF93DE6F1B4")
    @DSModeled(DSC.SAFE)
     CommandDetails getCmdDetails() {
        return (CommandDetails)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return cmdDet;
    }

    
}

