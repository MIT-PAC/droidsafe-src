package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ATParseEx extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.550 -0400", hash_original_method = "F1F3845C26D0582188BC2F6275397113", hash_generated_method = "7AB30A637E4F0CAF99CB86D5CB1C62DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ATParseEx() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.550 -0400", hash_original_method = "A4FE2FA4458A54BB360DFC853573FC1A", hash_generated_method = "C8AA2E3C74D995229464285D4A812945")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ATParseEx(String s) {
        super(s);
        dsTaint.addTaint(s);
        // ---------- Original Method ----------
    }

    
}

