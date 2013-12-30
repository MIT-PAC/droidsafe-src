package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.graphics.Bitmap;





class CommandParams {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.508 -0500", hash_original_field = "ADD54520BA0629F0A763D04B0B24DD10", hash_generated_field = "ADD54520BA0629F0A763D04B0B24DD10")

    CommandDetails cmdDet;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.511 -0500", hash_original_method = "2B3FA66352959F95E07A360EAE45E831", hash_generated_method = "2B3FA66352959F95E07A360EAE45E831")
    
CommandParams(CommandDetails cmdDet) {
        this.cmdDet = cmdDet;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.513 -0500", hash_original_method = "BBFB9BBC2EA7C24F6D809DAEED5D51EA", hash_generated_method = "BBFB9BBC2EA7C24F6D809DAEED5D51EA")
    
AppInterface.CommandType getCommandType() {
        return AppInterface.CommandType.fromInt(cmdDet.typeOfCommand);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.515 -0500", hash_original_method = "A8568713BEFC46F9EECE865CBC0E3B85", hash_generated_method = "A8568713BEFC46F9EECE865CBC0E3B85")
    
boolean setIcon(Bitmap icon) { return true; }

    
}

class DisplayTextParams extends CommandParams {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.517 -0500", hash_original_field = "BB47A92F903E4E2AEB0FA2E7CC37DE84", hash_generated_field = "BB47A92F903E4E2AEB0FA2E7CC37DE84")

    TextMessage textMsg;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.519 -0500", hash_original_method = "700E001E6C7C4BB86F65A405A500553F", hash_generated_method = "700E001E6C7C4BB86F65A405A500553F")
    
DisplayTextParams(CommandDetails cmdDet, TextMessage textMsg) {
        super(cmdDet);
        this.textMsg = textMsg;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.522 -0500", hash_original_method = "21525D99FCC45F45CD5434385C40E277", hash_generated_method = "21525D99FCC45F45CD5434385C40E277")
    
boolean setIcon(Bitmap icon) {
        if (icon != null && textMsg != null) {
            textMsg.icon = icon;
            return true;
        }
        return false;
    }

    
}

class LaunchBrowserParams extends CommandParams {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.524 -0500", hash_original_field = "B2111E59C12A8525442758C5427A208C", hash_generated_field = "B2111E59C12A8525442758C5427A208C")

    TextMessage confirmMsg;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.526 -0500", hash_original_field = "A5764D2D4FA704D86881B5DFDB508312", hash_generated_field = "A5764D2D4FA704D86881B5DFDB508312")

    LaunchBrowserMode mode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.528 -0500", hash_original_field = "1B433832A8D8C8722BF3FE2FD98C7841", hash_generated_field = "1B433832A8D8C8722BF3FE2FD98C7841")

    String url;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.532 -0500", hash_original_method = "333668ED0BA1936719D55AC9BD5C191E", hash_generated_method = "333668ED0BA1936719D55AC9BD5C191E")
    
LaunchBrowserParams(CommandDetails cmdDet, TextMessage confirmMsg,
            String url, LaunchBrowserMode mode) {
        super(cmdDet);
        this.confirmMsg = confirmMsg;
        this.mode = mode;
        this.url = url;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.534 -0500", hash_original_method = "14C8B1CAE4AF3E3922E99E945859BFE8", hash_generated_method = "14C8B1CAE4AF3E3922E99E945859BFE8")
    
boolean setIcon(Bitmap icon) {
        if (icon != null && confirmMsg != null) {
            confirmMsg.icon = icon;
            return true;
        }
        return false;
    }

    
}

class PlayToneParams extends CommandParams {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.536 -0500", hash_original_field = "BB47A92F903E4E2AEB0FA2E7CC37DE84", hash_generated_field = "BB47A92F903E4E2AEB0FA2E7CC37DE84")

    TextMessage textMsg;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.538 -0500", hash_original_field = "8D4AD8F7EAF433DA2E5A401C5C613EFE", hash_generated_field = "8D4AD8F7EAF433DA2E5A401C5C613EFE")

    ToneSettings settings;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.541 -0500", hash_original_method = "0EF5086DB6919FD4BD0CA8FFEAE75A4D", hash_generated_method = "0EF5086DB6919FD4BD0CA8FFEAE75A4D")
    
PlayToneParams(CommandDetails cmdDet, TextMessage textMsg,
            Tone tone, Duration duration, boolean vibrate) {
        super(cmdDet);
        this.textMsg = textMsg;
        this.settings = new ToneSettings(duration, tone, vibrate);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.543 -0500", hash_original_method = "21525D99FCC45F45CD5434385C40E277", hash_generated_method = "21525D99FCC45F45CD5434385C40E277")
    
boolean setIcon(Bitmap icon) {
        if (icon != null && textMsg != null) {
            textMsg.icon = icon;
            return true;
        }
        return false;
    }

    
}

class CallSetupParams extends CommandParams {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.545 -0500", hash_original_field = "B2111E59C12A8525442758C5427A208C", hash_generated_field = "B2111E59C12A8525442758C5427A208C")

    TextMessage confirmMsg;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.547 -0500", hash_original_field = "965D344D08F644937D8D78D46A2A1817", hash_generated_field = "965D344D08F644937D8D78D46A2A1817")

    TextMessage callMsg;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.550 -0500", hash_original_method = "E3AB8AF63DAE9B970C2C85BEC45D1384", hash_generated_method = "E3AB8AF63DAE9B970C2C85BEC45D1384")
    
CallSetupParams(CommandDetails cmdDet, TextMessage confirmMsg,
            TextMessage callMsg) {
        super(cmdDet);
        this.confirmMsg = confirmMsg;
        this.callMsg = callMsg;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.552 -0500", hash_original_method = "7CBBFD719CD54FED6A95014430B0D13E", hash_generated_method = "7CBBFD719CD54FED6A95014430B0D13E")
    
boolean setIcon(Bitmap icon) {
        if (icon == null) {
            return false;
        }
        if (confirmMsg != null && confirmMsg.icon == null) {
            confirmMsg.icon = icon;
            return true;
        } else if (callMsg != null && callMsg.icon == null) {
            callMsg.icon = icon;
            return true;
        }
        return false;
    }

    
}

class SelectItemParams extends CommandParams {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.555 -0500", hash_original_field = "1ECB1009BB02DA4D1823D6D12E970C7B", hash_generated_field = "1ECB1009BB02DA4D1823D6D12E970C7B")

    Menu menu = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.556 -0500", hash_original_field = "87D0E6332583567BDE938D421B6FE2B8", hash_generated_field = "87D0E6332583567BDE938D421B6FE2B8")

    boolean loadTitleIcon = false;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.559 -0500", hash_original_method = "E55DB81905BD2AA861EB811BEF064274", hash_generated_method = "E55DB81905BD2AA861EB811BEF064274")
    
SelectItemParams(CommandDetails cmdDet, Menu menu, boolean loadTitleIcon) {
        super(cmdDet);
        this.menu = menu;
        this.loadTitleIcon = loadTitleIcon;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.561 -0500", hash_original_method = "18017A51DEA7E263420DEFD24143331D", hash_generated_method = "18017A51DEA7E263420DEFD24143331D")
    
boolean setIcon(Bitmap icon) {
        if (icon != null && menu != null) {
            if (loadTitleIcon && menu.titleIcon == null) {
                menu.titleIcon = icon;
            } else {
                for (Item item : menu.items) {
                    if (item.icon != null) {
                        continue;
                    }
                    item.icon = icon;
                    break;
                }
            }
            return true;
        }
        return false;
    }

    
}

class GetInputParams extends CommandParams {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.563 -0500", hash_original_field = "FCC05DAC3210D446A9ECD36D82FBAA06", hash_generated_field = "FCC05DAC3210D446A9ECD36D82FBAA06")

    Input input = null;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.566 -0500", hash_original_method = "4B81DD05ADA485DA1C52833ACC153D55", hash_generated_method = "4B81DD05ADA485DA1C52833ACC153D55")
    
GetInputParams(CommandDetails cmdDet, Input input) {
        super(cmdDet);
        this.input = input;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.568 -0500", hash_original_method = "0D1B780F5B7D1ED973494BE2C3910B90", hash_generated_method = "0D1B780F5B7D1ED973494BE2C3910B90")
    
boolean setIcon(Bitmap icon) {
        if (icon != null && input != null) {
            input.icon = icon;
        }
        return true;
    }

    
}

