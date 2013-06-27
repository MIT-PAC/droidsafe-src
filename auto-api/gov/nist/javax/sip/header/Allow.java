package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;

public final class Allow extends SIPHeader implements javax.sip.header.AllowHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.402 -0400", hash_original_field = "EA9F6ACA279138C58F705C8D4CB4B8CE", hash_generated_field = "7A7B3881B98B4FAF9D2BB4D0900875E7")

    protected String method;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.410 -0400", hash_original_method = "473413697039914FAE978B5460F14DD9", hash_generated_method = "4D31534EA8011D7FF178B53A73A728AA")
    public  Allow() {
        super(ALLOW);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.410 -0400", hash_original_method = "07DC0232E600446B62A81ACF6B5528CD", hash_generated_method = "8A73E6FD8CDE43ABC63EE34599FECCC8")
    public  Allow(String m) {
        super(ALLOW);
        method = m;
        // ---------- Original Method ----------
        //method = m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.410 -0400", hash_original_method = "A65B682B0B822D8527FBE88A2FCA60FC", hash_generated_method = "0A30F9AA43BD9E20BF97B820F29E481B")
    public String getMethod() {
        String varB4EAC82CA7396A68D541C85D26508E83_1040308544 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1040308544 = method;
        varB4EAC82CA7396A68D541C85D26508E83_1040308544.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1040308544;
        // ---------- Original Method ----------
        //return method;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.411 -0400", hash_original_method = "78C1F544F0B2D71B62F1C06FF7335973", hash_generated_method = "FFB02806EF69152178684BFF9A7F00F7")
    public void setMethod(String method) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception"
                    + ", Allow, setMethod(), the method parameter is null.");
        this.method = method;
        // ---------- Original Method ----------
        //if (method == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception"
                    //+ ", Allow, setMethod(), the method parameter is null.");
        //this.method = method;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.411 -0400", hash_original_method = "48A673DBBFEBFCB1D74A4ACDDDC3C6AB", hash_generated_method = "3AA85475E14ECC211BBFDF26BFAA2EAE")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1445416235 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1445416235 = method;
        varB4EAC82CA7396A68D541C85D26508E83_1445416235.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1445416235;
        // ---------- Original Method ----------
        //return method;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.411 -0400", hash_original_field = "E2D8B8EAC99520FEE5D7EF6F1AA6DA96", hash_generated_field = "EC987D97D4EF7DAAEA4EDF312B4359D7")

    private static long serialVersionUID = -3105079479020693930L;
}

