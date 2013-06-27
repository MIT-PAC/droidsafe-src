package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;

public class WarningList extends SIPHeaderList<Warning> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.843 -0400", hash_original_method = "8098AC8A06CDB819C465A9D30CC2E5BB", hash_generated_method = "62F1F7BE0861080B87B988F0A42FF4AC")
    public  WarningList() {
        super(Warning.class, Warning.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.854 -0400", hash_original_method = "266F52C906228C3D1DC5D5C7E03D3C84", hash_generated_method = "C01B28D4901B5DC72716D7DBC16DB63D")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_941838969 = null; //Variable for return #1
        WarningList retval;
        retval = new WarningList();
        varB4EAC82CA7396A68D541C85D26508E83_941838969 = retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_941838969.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_941838969;
        // ---------- Original Method ----------
        //WarningList retval = new WarningList();
        //return retval.clonehlist(this.hlist);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.854 -0400", hash_original_field = "0D28E51547CF8629AAEF431248291D24", hash_generated_field = "8DC5E6EB1DA7526DCE7A39A287449F50")

    private static long serialVersionUID = -1423278728898430175L;
}

