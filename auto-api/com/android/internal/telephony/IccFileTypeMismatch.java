package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class IccFileTypeMismatch extends IccException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.339 -0400", hash_original_method = "E2EFD4F60E6DEBBFF1ECC3AF52B7BF83", hash_generated_method = "9C6EF2B3C8162A26105E6F68484C49DB")
    @DSModeled(DSC.SAFE)
    public IccFileTypeMismatch() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.339 -0400", hash_original_method = "50ADB5D3C7BA87D326791A13088BBBA9", hash_generated_method = "EBC4014357A11524BCA2CB248D4B7435")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IccFileTypeMismatch(String s) {
        super(s);
        dsTaint.addTaint(s);
        // ---------- Original Method ----------
    }

    
}

