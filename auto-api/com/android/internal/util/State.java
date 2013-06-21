package com.android.internal.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Message;

public class State implements IState {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.754 -0400", hash_original_method = "1314C653F2455ACB4C7CC9637DF86BCF", hash_generated_method = "08C8C0B772A74712289D6F8F080A41CA")
    @DSModeled(DSC.SAFE)
    protected State() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.755 -0400", hash_original_method = "D62227FCEF84BCF6A743C917250E2211", hash_generated_method = "40F63E03D25AE3A18DCE7ED65AA97341")
    @DSModeled(DSC.SAFE)
    @Override
    public void enter() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.755 -0400", hash_original_method = "2C3CB485438CBA20E6D214DF13F075C8", hash_generated_method = "E074E0EF32C7F8361A1F3D5B534022CC")
    @DSModeled(DSC.SAFE)
    @Override
    public void exit() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.758 -0400", hash_original_method = "19EA475E2A58E089BFF1524EDD692DAE", hash_generated_method = "285294AD82E0DDCEDF3D4A82449C114C")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean processMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.758 -0400", hash_original_method = "F20278175B30FDA9C7EB84130BA3C8FE", hash_generated_method = "05A4B3F41C7C806B529E6C9AEC0A4CDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getName() {
        String name;
        name = getClass().getName();
        int lastDollar;
        lastDollar = name.lastIndexOf('$');
        String var972F07F5ECBA91786FC2CCC3BE9C1778_1497652535 = (name.substring(lastDollar + 1));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String name = getClass().getName();
        //int lastDollar = name.lastIndexOf('$');
        //return name.substring(lastDollar + 1);
    }

    
}

