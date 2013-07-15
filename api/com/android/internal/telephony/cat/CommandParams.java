package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Bitmap;

class CommandParams {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.929 -0400", hash_original_field = "455D72CEA61E597AF64B6D9F179A4D87", hash_generated_field = "ADD54520BA0629F0A763D04B0B24DD10")

    CommandDetails cmdDet;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.930 -0400", hash_original_method = "2B3FA66352959F95E07A360EAE45E831", hash_generated_method = "677B05FD0D442BB524C5F5A6AA3633B9")
      CommandParams(CommandDetails cmdDet) {
        this.cmdDet = cmdDet;
        // ---------- Original Method ----------
        //this.cmdDet = cmdDet;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.930 -0400", hash_original_method = "BBFB9BBC2EA7C24F6D809DAEED5D51EA", hash_generated_method = "23AB2DEA021A7B4550E33BBE8DA037C3")
     AppInterface.CommandType getCommandType() {
AppInterface.CommandType var8A824FAC5ED556766C4037BB3498C325_134690838 =         AppInterface.CommandType.fromInt(cmdDet.typeOfCommand);
        var8A824FAC5ED556766C4037BB3498C325_134690838.addTaint(taint);
        return var8A824FAC5ED556766C4037BB3498C325_134690838;
        // ---------- Original Method ----------
        //return AppInterface.CommandType.fromInt(cmdDet.typeOfCommand);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.930 -0400", hash_original_method = "A8568713BEFC46F9EECE865CBC0E3B85", hash_generated_method = "7E2474DD83CC63C3F6EA5221A5BD0366")
     boolean setIcon(Bitmap icon) {
        addTaint(icon.getTaint());
        boolean varB326B5062B2F0E69046810717534CB09_2110540989 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_918796292 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_918796292;
        // ---------- Original Method ----------
        //return true;
    }

    
}

class DisplayTextParams extends CommandParams {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.930 -0400", hash_original_field = "D82152991B616F53E9EF719C0FDFF95B", hash_generated_field = "BB47A92F903E4E2AEB0FA2E7CC37DE84")

    TextMessage textMsg;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.931 -0400", hash_original_method = "700E001E6C7C4BB86F65A405A500553F", hash_generated_method = "83A797157C562817FB582FF53A95D1F2")
      DisplayTextParams(CommandDetails cmdDet, TextMessage textMsg) {
        super(cmdDet);
        addTaint(cmdDet.getTaint());
        this.textMsg = textMsg;
        // ---------- Original Method ----------
        //this.textMsg = textMsg;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.931 -0400", hash_original_method = "21525D99FCC45F45CD5434385C40E277", hash_generated_method = "FD5BD7FE43C7BC1B1CC45DC68D65C95D")
     boolean setIcon(Bitmap icon) {
    if(icon != null && textMsg != null)        
        {
            textMsg.icon = icon;
            boolean varB326B5062B2F0E69046810717534CB09_1898048361 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_486322637 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_486322637;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1040155657 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1991629558 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1991629558;
        // ---------- Original Method ----------
        //if (icon != null && textMsg != null) {
            //textMsg.icon = icon;
            //return true;
        //}
        //return false;
    }

    
}

class LaunchBrowserParams extends CommandParams {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.931 -0400", hash_original_field = "06B4D899C3434F9B6E6ACC3F56239187", hash_generated_field = "B2111E59C12A8525442758C5427A208C")

    TextMessage confirmMsg;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.932 -0400", hash_original_field = "15D61712450A686A7F365ADF4FEF581F", hash_generated_field = "A5764D2D4FA704D86881B5DFDB508312")

    LaunchBrowserMode mode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.932 -0400", hash_original_field = "572D4E421E5E6B9BC11D815E8A027112", hash_generated_field = "1B433832A8D8C8722BF3FE2FD98C7841")

    String url;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.932 -0400", hash_original_method = "333668ED0BA1936719D55AC9BD5C191E", hash_generated_method = "FFF01E63450B9EEAE4C232A4488BA57B")
      LaunchBrowserParams(CommandDetails cmdDet, TextMessage confirmMsg,
            String url, LaunchBrowserMode mode) {
        super(cmdDet);
        addTaint(cmdDet.getTaint());
        this.confirmMsg = confirmMsg;
        this.mode = mode;
        this.url = url;
        // ---------- Original Method ----------
        //this.confirmMsg = confirmMsg;
        //this.mode = mode;
        //this.url = url;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.933 -0400", hash_original_method = "14C8B1CAE4AF3E3922E99E945859BFE8", hash_generated_method = "35D950D8EA741EB28F2A9C300140F3F2")
     boolean setIcon(Bitmap icon) {
    if(icon != null && confirmMsg != null)        
        {
            confirmMsg.icon = icon;
            boolean varB326B5062B2F0E69046810717534CB09_1531988871 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2073189541 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2073189541;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1636687083 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1879793753 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1879793753;
        // ---------- Original Method ----------
        //if (icon != null && confirmMsg != null) {
            //confirmMsg.icon = icon;
            //return true;
        //}
        //return false;
    }

    
}

class PlayToneParams extends CommandParams {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.933 -0400", hash_original_field = "D82152991B616F53E9EF719C0FDFF95B", hash_generated_field = "BB47A92F903E4E2AEB0FA2E7CC37DE84")

    TextMessage textMsg;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.933 -0400", hash_original_field = "2E5D8AA3DFA8EF34CA5131D20F9DAD51", hash_generated_field = "8D4AD8F7EAF433DA2E5A401C5C613EFE")

    ToneSettings settings;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.934 -0400", hash_original_method = "0EF5086DB6919FD4BD0CA8FFEAE75A4D", hash_generated_method = "507694F0D9420C9BF559DAED483CCB2F")
      PlayToneParams(CommandDetails cmdDet, TextMessage textMsg,
            Tone tone, Duration duration, boolean vibrate) {
        super(cmdDet);
        addTaint(cmdDet.getTaint());
        this.textMsg = textMsg;
        this.settings = new ToneSettings(duration, tone, vibrate);
        // ---------- Original Method ----------
        //this.textMsg = textMsg;
        //this.settings = new ToneSettings(duration, tone, vibrate);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.934 -0400", hash_original_method = "21525D99FCC45F45CD5434385C40E277", hash_generated_method = "B21E04E6D87662017AF515CE423EFE99")
     boolean setIcon(Bitmap icon) {
    if(icon != null && textMsg != null)        
        {
            textMsg.icon = icon;
            boolean varB326B5062B2F0E69046810717534CB09_1311851895 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2063122136 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2063122136;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_924216968 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_344501293 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_344501293;
        // ---------- Original Method ----------
        //if (icon != null && textMsg != null) {
            //textMsg.icon = icon;
            //return true;
        //}
        //return false;
    }

    
}

class CallSetupParams extends CommandParams {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.935 -0400", hash_original_field = "06B4D899C3434F9B6E6ACC3F56239187", hash_generated_field = "B2111E59C12A8525442758C5427A208C")

    TextMessage confirmMsg;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.935 -0400", hash_original_field = "C92AF136DB908B735C01311448F4DE71", hash_generated_field = "965D344D08F644937D8D78D46A2A1817")

    TextMessage callMsg;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.935 -0400", hash_original_method = "E3AB8AF63DAE9B970C2C85BEC45D1384", hash_generated_method = "5216A679A114651E8393AFD379F5D03E")
      CallSetupParams(CommandDetails cmdDet, TextMessage confirmMsg,
            TextMessage callMsg) {
        super(cmdDet);
        addTaint(cmdDet.getTaint());
        this.confirmMsg = confirmMsg;
        this.callMsg = callMsg;
        // ---------- Original Method ----------
        //this.confirmMsg = confirmMsg;
        //this.callMsg = callMsg;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.936 -0400", hash_original_method = "7CBBFD719CD54FED6A95014430B0D13E", hash_generated_method = "06AD227C7402673962462E61EC5A7C98")
     boolean setIcon(Bitmap icon) {
    if(icon == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_954433922 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_25300575 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_25300575;
        } //End block
    if(confirmMsg != null && confirmMsg.icon == null)        
        {
            confirmMsg.icon = icon;
            boolean varB326B5062B2F0E69046810717534CB09_190824855 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_109219813 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_109219813;
        } //End block
        else
    if(callMsg != null && callMsg.icon == null)        
        {
            callMsg.icon = icon;
            boolean varB326B5062B2F0E69046810717534CB09_1469556227 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_65611636 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_65611636;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1046407091 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_170902063 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_170902063;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.938 -0400", hash_original_field = "06127BF5F44271A1FC348E33777BAE7E", hash_generated_field = "1ECB1009BB02DA4D1823D6D12E970C7B")

    Menu menu = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.938 -0400", hash_original_field = "D39C2A8FFC14B00416DE6BA09EB55732", hash_generated_field = "87D0E6332583567BDE938D421B6FE2B8")

    boolean loadTitleIcon = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.938 -0400", hash_original_method = "E55DB81905BD2AA861EB811BEF064274", hash_generated_method = "5FA47F249C0A537A6EE47B385B1F1B33")
      SelectItemParams(CommandDetails cmdDet, Menu menu, boolean loadTitleIcon) {
        super(cmdDet);
        addTaint(cmdDet.getTaint());
        this.menu = menu;
        this.loadTitleIcon = loadTitleIcon;
        // ---------- Original Method ----------
        //this.menu = menu;
        //this.loadTitleIcon = loadTitleIcon;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.939 -0400", hash_original_method = "18017A51DEA7E263420DEFD24143331D", hash_generated_method = "C012D056CA57C893611D546AAF304EC9")
     boolean setIcon(Bitmap icon) {
    if(icon != null && menu != null)        
        {
    if(loadTitleIcon && menu.titleIcon == null)            
            {
                menu.titleIcon = icon;
            } //End block
            else
            {
for(Item item : menu.items)
                {
    if(item.icon != null)                    
                    {
                        continue;
                    } //End block
                    item.icon = icon;
                    break;
                } //End block
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1804725542 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1171664714 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1171664714;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_679613207 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_140719122 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_140719122;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.939 -0400", hash_original_field = "1CFC72C8A5D816EEF0317D3D02105AD5", hash_generated_field = "FCC05DAC3210D446A9ECD36D82FBAA06")

    Input input = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.939 -0400", hash_original_method = "4B81DD05ADA485DA1C52833ACC153D55", hash_generated_method = "71BC4E482D2B82B1899F6FFE0CD22E20")
      GetInputParams(CommandDetails cmdDet, Input input) {
        super(cmdDet);
        addTaint(cmdDet.getTaint());
        this.input = input;
        // ---------- Original Method ----------
        //this.input = input;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.940 -0400", hash_original_method = "0D1B780F5B7D1ED973494BE2C3910B90", hash_generated_method = "D87E75ADCEA5AAC6CB43B328C94AF510")
     boolean setIcon(Bitmap icon) {
    if(icon != null && input != null)        
        {
            input.icon = icon;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_51419830 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2033676563 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2033676563;
        // ---------- Original Method ----------
        //if (icon != null && input != null) {
            //input.icon = icon;
        //}
        //return true;
    }

    
}

