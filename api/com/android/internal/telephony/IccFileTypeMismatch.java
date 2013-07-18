package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.annotations.DSGenerator;

public class IccFileTypeMismatch extends IccException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.134 -0400", hash_original_method = "E2EFD4F60E6DEBBFF1ECC3AF52B7BF83", hash_generated_method = "9C6EF2B3C8162A26105E6F68484C49DB")
    public  IccFileTypeMismatch() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.134 -0400", hash_original_method = "50ADB5D3C7BA87D326791A13088BBBA9", hash_generated_method = "6EE941989432FCE99455529F2F07D618")
    public  IccFileTypeMismatch(String s) {
        super(s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
    }

    
}

