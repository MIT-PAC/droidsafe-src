package com.android.internal.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Message;

public class State implements IState {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.658 -0400", hash_original_method = "1314C653F2455ACB4C7CC9637DF86BCF", hash_generated_method = "47DEC0556AD78536F5B9D9D001470FDC")
    @DSModeled(DSC.SAFE)
    protected State() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.658 -0400", hash_original_method = "D62227FCEF84BCF6A743C917250E2211", hash_generated_method = "CE059AC5F15A470E9F00589FC22803BD")
    @DSModeled(DSC.SAFE)
    @Override
    public void enter() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.658 -0400", hash_original_method = "2C3CB485438CBA20E6D214DF13F075C8", hash_generated_method = "6A60C348BE899187FEDE66D57161EF89")
    @DSModeled(DSC.SAFE)
    @Override
    public void exit() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.658 -0400", hash_original_method = "19EA475E2A58E089BFF1524EDD692DAE", hash_generated_method = "B97A849C181C16B7F6B92B8C483FAC3A")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean processMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.658 -0400", hash_original_method = "F20278175B30FDA9C7EB84130BA3C8FE", hash_generated_method = "67A632461EC18A5E6D4A8DF199BFB6EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getName() {
        String name;
        name = getClass().getName();
        int lastDollar;
        lastDollar = name.lastIndexOf('$');
        String var972F07F5ECBA91786FC2CCC3BE9C1778_185202587 = (name.substring(lastDollar + 1));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String name = getClass().getName();
        //int lastDollar = name.lastIndexOf('$');
        //return name.substring(lastDollar + 1);
    }

    
}


