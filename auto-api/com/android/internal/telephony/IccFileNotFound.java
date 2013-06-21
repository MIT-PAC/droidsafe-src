package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class IccFileNotFound extends IccException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.338 -0400", hash_original_method = "BA14DB7797A45FF6750F5919D632C5BC", hash_generated_method = "882C52828F97856B3C5401A09EB51F77")
    @DSModeled(DSC.SAFE)
     IccFileNotFound() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.338 -0400", hash_original_method = "16B6683D809802DF19583D9BD8B03BDC", hash_generated_method = "384E514C63665BDA09C3C59A8B3273E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     IccFileNotFound(String s) {
        super(s);
        dsTaint.addTaint(s);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.338 -0400", hash_original_method = "0ACB501EED723AE31A87CC247874BF4F", hash_generated_method = "EFD23FA79A0884B8ED30F1F1525C33BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     IccFileNotFound(int ef) {
        super("ICC EF Not Found 0x" + Integer.toHexString(ef));
        dsTaint.addTaint(ef);
        // ---------- Original Method ----------
    }

    
}

