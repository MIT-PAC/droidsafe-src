package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class EncodeException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.153 -0400", hash_original_method = "F9AE7F85F23C7FEE107F4543E0942608", hash_generated_method = "E3D169A62DC6D3221C9019B8C374B014")
    public  EncodeException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.153 -0400", hash_original_method = "B14B4375D163DC42A1F3E7F49D8709C1", hash_generated_method = "36394A59FC717516A9754A22F6F5B740")
    public  EncodeException(String s) {
        super(s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.153 -0400", hash_original_method = "E2DA8F75EC5117714B2DD703BD84F5F0", hash_generated_method = "8FDE096199D30728C219E9A50076C43C")
    public  EncodeException(char c) {
        super("Unencodable char: '" + c + "'");
        addTaint(c);
        // ---------- Original Method ----------
    }

    
}

