package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public class IccFileNotFound extends IccException {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:33.731 -0500", hash_original_method = "BA14DB7797A45FF6750F5919D632C5BC", hash_generated_method = "BA14DB7797A45FF6750F5919D632C5BC")
    IccFileNotFound() {

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:33.732 -0500", hash_original_method = "16B6683D809802DF19583D9BD8B03BDC", hash_generated_method = "16B6683D809802DF19583D9BD8B03BDC")
    IccFileNotFound(String s) {
        super(s);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:33.733 -0500", hash_original_method = "0ACB501EED723AE31A87CC247874BF4F", hash_generated_method = "0ACB501EED723AE31A87CC247874BF4F")
    IccFileNotFound(int ef) {
        super("ICC EF Not Found 0x" + Integer.toHexString(ef));
    }

    
}

