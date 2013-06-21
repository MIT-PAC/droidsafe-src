package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Bitmap;

class CommandParams {
    CommandDetails cmdDet;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.762 -0400", hash_original_method = "2B3FA66352959F95E07A360EAE45E831", hash_generated_method = "AF9BBF7CA7095E9AF327550123C83650")
    @DSModeled(DSC.SAFE)
     CommandParams(CommandDetails cmdDet) {
        dsTaint.addTaint(cmdDet.dsTaint);
        // ---------- Original Method ----------
        //this.cmdDet = cmdDet;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.763 -0400", hash_original_method = "BBFB9BBC2EA7C24F6D809DAEED5D51EA", hash_generated_method = "7DC32026D641F280E59DC02814285396")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     AppInterface.CommandType getCommandType() {
        AppInterface.CommandType varD38A16111D869E9E07C9C9CF03433B4F_309294766 = (AppInterface.CommandType.fromInt(cmdDet.typeOfCommand));
        return (AppInterface.CommandType)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return AppInterface.CommandType.fromInt(cmdDet.typeOfCommand);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.763 -0400", hash_original_method = "A8568713BEFC46F9EECE865CBC0E3B85", hash_generated_method = "4EFC2829BBEEFE7D5686ADE09ADB2041")
    @DSModeled(DSC.SAFE)
     boolean setIcon(Bitmap icon) {
        dsTaint.addTaint(icon.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
}

class DisplayTextParams extends CommandParams {
    TextMessage textMsg;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.763 -0400", hash_original_method = "700E001E6C7C4BB86F65A405A500553F", hash_generated_method = "050DF53166F68874558EB82DE9D55F3C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     DisplayTextParams(CommandDetails cmdDet, TextMessage textMsg) {
        super(cmdDet);
        dsTaint.addTaint(textMsg.dsTaint);
        dsTaint.addTaint(cmdDet.dsTaint);
        // ---------- Original Method ----------
        //this.textMsg = textMsg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.763 -0400", hash_original_method = "21525D99FCC45F45CD5434385C40E277", hash_generated_method = "671E0BAF9478C499A811110FFBBB9C3B")
    @DSModeled(DSC.SAFE)
     boolean setIcon(Bitmap icon) {
        dsTaint.addTaint(icon.dsTaint);
        {
            textMsg.icon = icon;
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (icon != null && textMsg != null) {
            //textMsg.icon = icon;
            //return true;
        //}
        //return false;
    }

    
}

class LaunchBrowserParams extends CommandParams {
    TextMessage confirmMsg;
    LaunchBrowserMode mode;
    String url;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.763 -0400", hash_original_method = "333668ED0BA1936719D55AC9BD5C191E", hash_generated_method = "AE5A40FE7A605EC1BD6F20326D91BA78")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     LaunchBrowserParams(CommandDetails cmdDet, TextMessage confirmMsg,
            String url, LaunchBrowserMode mode) {
        super(cmdDet);
        dsTaint.addTaint(confirmMsg.dsTaint);
        dsTaint.addTaint(cmdDet.dsTaint);
        dsTaint.addTaint(url);
        dsTaint.addTaint(mode.dsTaint);
        // ---------- Original Method ----------
        //this.confirmMsg = confirmMsg;
        //this.mode = mode;
        //this.url = url;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.764 -0400", hash_original_method = "14C8B1CAE4AF3E3922E99E945859BFE8", hash_generated_method = "74041F98417CC3FDFAA47623F5B23321")
    @DSModeled(DSC.SAFE)
     boolean setIcon(Bitmap icon) {
        dsTaint.addTaint(icon.dsTaint);
        {
            confirmMsg.icon = icon;
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (icon != null && confirmMsg != null) {
            //confirmMsg.icon = icon;
            //return true;
        //}
        //return false;
    }

    
}

class PlayToneParams extends CommandParams {
    TextMessage textMsg;
    ToneSettings settings;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.764 -0400", hash_original_method = "0EF5086DB6919FD4BD0CA8FFEAE75A4D", hash_generated_method = "7D27BD8B69A5D3655FE69771B6C7EF90")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     PlayToneParams(CommandDetails cmdDet, TextMessage textMsg,
            Tone tone, Duration duration, boolean vibrate) {
        super(cmdDet);
        dsTaint.addTaint(duration.dsTaint);
        dsTaint.addTaint(tone.dsTaint);
        dsTaint.addTaint(textMsg.dsTaint);
        dsTaint.addTaint(vibrate);
        dsTaint.addTaint(cmdDet.dsTaint);
        this.settings = new ToneSettings(duration, tone, vibrate);
        // ---------- Original Method ----------
        //this.textMsg = textMsg;
        //this.settings = new ToneSettings(duration, tone, vibrate);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.764 -0400", hash_original_method = "21525D99FCC45F45CD5434385C40E277", hash_generated_method = "671E0BAF9478C499A811110FFBBB9C3B")
    @DSModeled(DSC.SAFE)
     boolean setIcon(Bitmap icon) {
        dsTaint.addTaint(icon.dsTaint);
        {
            textMsg.icon = icon;
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (icon != null && textMsg != null) {
            //textMsg.icon = icon;
            //return true;
        //}
        //return false;
    }

    
}

class CallSetupParams extends CommandParams {
    TextMessage confirmMsg;
    TextMessage callMsg;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.764 -0400", hash_original_method = "E3AB8AF63DAE9B970C2C85BEC45D1384", hash_generated_method = "27160F0BAB6775D4C99DFB9902601E56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     CallSetupParams(CommandDetails cmdDet, TextMessage confirmMsg,
            TextMessage callMsg) {
        super(cmdDet);
        dsTaint.addTaint(confirmMsg.dsTaint);
        dsTaint.addTaint(cmdDet.dsTaint);
        dsTaint.addTaint(callMsg.dsTaint);
        // ---------- Original Method ----------
        //this.confirmMsg = confirmMsg;
        //this.callMsg = callMsg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.765 -0400", hash_original_method = "7CBBFD719CD54FED6A95014430B0D13E", hash_generated_method = "7578174C73D5F52761A52694A06C228E")
    @DSModeled(DSC.SAFE)
     boolean setIcon(Bitmap icon) {
        dsTaint.addTaint(icon.dsTaint);
        {
            confirmMsg.icon = icon;
        } //End block
        {
            callMsg.icon = icon;
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (icon == null) {
            //return false;
        //}
        //if (confirmMsg != null && confirmMsg.icon == null) {
            //confirmMsg.icon = icon;
            //return true;
        //} else if (callMsg != null && callMsg.icon == null) {
            //callMsg.icon = icon;
            //return true;
        //}
        //return false;
    }

    
}

class SelectItemParams extends CommandParams {
    Menu menu = null;
    boolean loadTitleIcon = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.766 -0400", hash_original_method = "E55DB81905BD2AA861EB811BEF064274", hash_generated_method = "369C00C6679A1F5283BA3C6A22F48D84")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SelectItemParams(CommandDetails cmdDet, Menu menu, boolean loadTitleIcon) {
        super(cmdDet);
        dsTaint.addTaint(loadTitleIcon);
        dsTaint.addTaint(menu.dsTaint);
        dsTaint.addTaint(cmdDet.dsTaint);
        // ---------- Original Method ----------
        //this.menu = menu;
        //this.loadTitleIcon = loadTitleIcon;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.769 -0400", hash_original_method = "18017A51DEA7E263420DEFD24143331D", hash_generated_method = "01CAD7D73EEB1270BBA81DBA46BA04B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean setIcon(Bitmap icon) {
        dsTaint.addTaint(icon.dsTaint);
        {
            {
                menu.titleIcon = icon;
            } //End block
            {
                {
                    Iterator<Item> varEC31BF7F1D0D208DA2BB8B90D8CDB8D2_704023238 = (menu.items).iterator();
                    varEC31BF7F1D0D208DA2BB8B90D8CDB8D2_704023238.hasNext();
                    Item item = varEC31BF7F1D0D208DA2BB8B90D8CDB8D2_704023238.next();
                    {
                        item.icon = icon;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (icon != null && menu != null) {
            //if (loadTitleIcon && menu.titleIcon == null) {
                //menu.titleIcon = icon;
            //} else {
                //for (Item item : menu.items) {
                    //if (item.icon != null) {
                        //continue;
                    //}
                    //item.icon = icon;
                    //break;
                //}
            //}
            //return true;
        //}
        //return false;
    }

    
}

class GetInputParams extends CommandParams {
    Input input = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.770 -0400", hash_original_method = "4B81DD05ADA485DA1C52833ACC153D55", hash_generated_method = "AA1CD8C8350CCE19CBA9088A83A37914")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     GetInputParams(CommandDetails cmdDet, Input input) {
        super(cmdDet);
        dsTaint.addTaint(input.dsTaint);
        dsTaint.addTaint(cmdDet.dsTaint);
        // ---------- Original Method ----------
        //this.input = input;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.770 -0400", hash_original_method = "0D1B780F5B7D1ED973494BE2C3910B90", hash_generated_method = "5C3B1E0D5E4007D4E5271B4F1F881131")
    @DSModeled(DSC.SAFE)
     boolean setIcon(Bitmap icon) {
        dsTaint.addTaint(icon.dsTaint);
        {
            input.icon = icon;
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (icon != null && input != null) {
            //input.icon = icon;
        //}
        //return true;
    }

    
}

class BIPClientParams extends CommandParams {
    TextMessage textMsg;
    boolean bHasAlphaId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.770 -0400", hash_original_method = "EB4FA74DE3183BC349E93653737FCD19", hash_generated_method = "6B613B5CEBBD06A0399B713BB8456503")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     BIPClientParams(CommandDetails cmdDet, TextMessage textMsg, boolean has_alpha_id) {
        super(cmdDet);
        dsTaint.addTaint(has_alpha_id);
        dsTaint.addTaint(textMsg.dsTaint);
        dsTaint.addTaint(cmdDet.dsTaint);
        // ---------- Original Method ----------
        //this.textMsg = textMsg;
        //this.bHasAlphaId = has_alpha_id;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.771 -0400", hash_original_method = "21525D99FCC45F45CD5434385C40E277", hash_generated_method = "671E0BAF9478C499A811110FFBBB9C3B")
    @DSModeled(DSC.SAFE)
     boolean setIcon(Bitmap icon) {
        dsTaint.addTaint(icon.dsTaint);
        {
            textMsg.icon = icon;
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (icon != null && textMsg != null) {
            //textMsg.icon = icon;
            //return true;
        //}
        //return false;
    }

    
}

