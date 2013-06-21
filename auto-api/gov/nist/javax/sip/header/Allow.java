package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;

public final class Allow extends SIPHeader implements javax.sip.header.AllowHeader {
    protected String method;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.662 -0400", hash_original_method = "473413697039914FAE978B5460F14DD9", hash_generated_method = "4D31534EA8011D7FF178B53A73A728AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Allow() {
        super(ALLOW);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.662 -0400", hash_original_method = "07DC0232E600446B62A81ACF6B5528CD", hash_generated_method = "0BEE0B220F29A522AB7ABDBEDCBD80EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Allow(String m) {
        super(ALLOW);
        dsTaint.addTaint(m);
        // ---------- Original Method ----------
        //method = m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.662 -0400", hash_original_method = "A65B682B0B822D8527FBE88A2FCA60FC", hash_generated_method = "66F4EA2E5AA841011071F21690E6549B")
    @DSModeled(DSC.SAFE)
    public String getMethod() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return method;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.662 -0400", hash_original_method = "78C1F544F0B2D71B62F1C06FF7335973", hash_generated_method = "55E2B305FFAB1760223B86BCD06CB069")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMethod(String method) throws ParseException {
        dsTaint.addTaint(method);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception"
                    + ", Allow, setMethod(), the method parameter is null.");
        // ---------- Original Method ----------
        //if (method == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception"
                    //+ ", Allow, setMethod(), the method parameter is null.");
        //this.method = method;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.662 -0400", hash_original_method = "48A673DBBFEBFCB1D74A4ACDDDC3C6AB", hash_generated_method = "BCBE54ED5AC13549D13912264BD98AE0")
    @DSModeled(DSC.SAFE)
    protected String encodeBody() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return method;
    }

    
    private static final long serialVersionUID = -3105079479020693930L;
}

