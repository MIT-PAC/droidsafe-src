package com.android.internal.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Message;

public class State implements IState {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.785 -0400", hash_original_method = "1314C653F2455ACB4C7CC9637DF86BCF", hash_generated_method = "08C8C0B772A74712289D6F8F080A41CA")
    protected  State() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.786 -0400", hash_original_method = "D62227FCEF84BCF6A743C917250E2211", hash_generated_method = "40F63E03D25AE3A18DCE7ED65AA97341")
    @Override
    public void enter() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.786 -0400", hash_original_method = "2C3CB485438CBA20E6D214DF13F075C8", hash_generated_method = "E074E0EF32C7F8361A1F3D5B534022CC")
    @Override
    public void exit() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.786 -0400", hash_original_method = "19EA475E2A58E089BFF1524EDD692DAE", hash_generated_method = "0431794CBECD654BBC02E4D3E47C43A1")
    @Override
    public boolean processMessage(Message msg) {
        addTaint(msg.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1235423499 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2087597972 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2087597972;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.786 -0400", hash_original_method = "F20278175B30FDA9C7EB84130BA3C8FE", hash_generated_method = "D05F9339CE6C7FCEC65AE131A321876D")
    @Override
    public String getName() {
        String name = getClass().getName();
        int lastDollar = name.lastIndexOf('$');
String varD7C421C03C1A323F8F634419CD6A2301_314790684 =         name.substring(lastDollar + 1);
        varD7C421C03C1A323F8F634419CD6A2301_314790684.addTaint(taint);
        return varD7C421C03C1A323F8F634419CD6A2301_314790684;
        // ---------- Original Method ----------
        //String name = getClass().getName();
        //int lastDollar = name.lastIndexOf('$');
        //return name.substring(lastDollar + 1);
    }

    
}

