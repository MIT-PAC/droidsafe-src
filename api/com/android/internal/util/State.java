package com.android.internal.util;

// Droidsafe Imports
import android.os.Message;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class State implements IState {
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.812 -0400", hash_original_method = "1314C653F2455ACB4C7CC9637DF86BCF", hash_generated_method = "08C8C0B772A74712289D6F8F080A41CA")
    protected  State() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.813 -0400", hash_original_method = "D62227FCEF84BCF6A743C917250E2211", hash_generated_method = "40F63E03D25AE3A18DCE7ED65AA97341")
    @Override
    public void enter() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.814 -0400", hash_original_method = "2C3CB485438CBA20E6D214DF13F075C8", hash_generated_method = "E074E0EF32C7F8361A1F3D5B534022CC")
    @Override
    public void exit() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.814 -0400", hash_original_method = "19EA475E2A58E089BFF1524EDD692DAE", hash_generated_method = "5E9F6EF3B54B3F113EF739F50561D7B4")
    @Override
    public boolean processMessage(Message msg) {
        addTaint(msg.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1716831185 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_748601424 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_748601424;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.815 -0400", hash_original_method = "F20278175B30FDA9C7EB84130BA3C8FE", hash_generated_method = "1580D2CB3EBF60187D6E524FADE38E57")
    @Override
    public String getName() {
        String name = getClass().getName();
        int lastDollar = name.lastIndexOf('$');
String varD7C421C03C1A323F8F634419CD6A2301_591302873 =         name.substring(lastDollar + 1);
        varD7C421C03C1A323F8F634419CD6A2301_591302873.addTaint(taint);
        return varD7C421C03C1A323F8F634419CD6A2301_591302873;
        // ---------- Original Method ----------
        //String name = getClass().getName();
        //int lastDollar = name.lastIndexOf('$');
        //return name.substring(lastDollar + 1);
    }

    
}

