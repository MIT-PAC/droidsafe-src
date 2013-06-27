package com.android.internal.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Message;

public class State implements IState {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.474 -0400", hash_original_method = "1314C653F2455ACB4C7CC9637DF86BCF", hash_generated_method = "08C8C0B772A74712289D6F8F080A41CA")
    protected  State() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.475 -0400", hash_original_method = "D62227FCEF84BCF6A743C917250E2211", hash_generated_method = "40F63E03D25AE3A18DCE7ED65AA97341")
    @Override
    public void enter() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.475 -0400", hash_original_method = "2C3CB485438CBA20E6D214DF13F075C8", hash_generated_method = "E074E0EF32C7F8361A1F3D5B534022CC")
    @Override
    public void exit() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.475 -0400", hash_original_method = "19EA475E2A58E089BFF1524EDD692DAE", hash_generated_method = "32005E29F95AD285840AE1DFFA910398")
    @Override
    public boolean processMessage(Message msg) {
        addTaint(msg.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1823528548 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1823528548;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.475 -0400", hash_original_method = "F20278175B30FDA9C7EB84130BA3C8FE", hash_generated_method = "F9D09E36ED66162A46596C9A449DCFC5")
    @Override
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1195192293 = null; //Variable for return #1
        String name;
        name = getClass().getName();
        int lastDollar;
        lastDollar = name.lastIndexOf('$');
        varB4EAC82CA7396A68D541C85D26508E83_1195192293 = name.substring(lastDollar + 1);
        varB4EAC82CA7396A68D541C85D26508E83_1195192293.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1195192293;
        // ---------- Original Method ----------
        //String name = getClass().getName();
        //int lastDollar = name.lastIndexOf('$');
        //return name.substring(lastDollar + 1);
    }

    
}

