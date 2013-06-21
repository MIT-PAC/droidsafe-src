package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public final class ASN1Exception extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.939 -0400", hash_original_method = "723A1DBA8406751CA0BE121F0D1A9151", hash_generated_method = "100C81B0E4342CF8587B50AC19A58F3C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ASN1Exception(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -3561981263989123987L;
}

