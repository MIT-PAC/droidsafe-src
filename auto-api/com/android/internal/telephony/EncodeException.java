package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class EncodeException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.136 -0400", hash_original_method = "F9AE7F85F23C7FEE107F4543E0942608", hash_generated_method = "E3D169A62DC6D3221C9019B8C374B014")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public EncodeException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.136 -0400", hash_original_method = "B14B4375D163DC42A1F3E7F49D8709C1", hash_generated_method = "4E8D6E6AF6E76A0D453A85CB8D8EB5CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public EncodeException(String s) {
        super(s);
        dsTaint.addTaint(s);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.136 -0400", hash_original_method = "E2DA8F75EC5117714B2DD703BD84F5F0", hash_generated_method = "434371664044B55742F3CCFB2A523138")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public EncodeException(char c) {
        super("Unencodable char: '" + c + "'");
        dsTaint.addTaint(c);
        // ---------- Original Method ----------
    }

    
}

