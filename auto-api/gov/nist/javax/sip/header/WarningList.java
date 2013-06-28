package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;

public class WarningList extends SIPHeaderList<Warning> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.989 -0400", hash_original_method = "8098AC8A06CDB819C465A9D30CC2E5BB", hash_generated_method = "62F1F7BE0861080B87B988F0A42FF4AC")
    public  WarningList() {
        super(Warning.class, Warning.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.990 -0400", hash_original_method = "266F52C906228C3D1DC5D5C7E03D3C84", hash_generated_method = "ACE24E59799C62E9A58AC691BC49601F")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1364827492 = null; //Variable for return #1
        WarningList retval = new WarningList();
        varB4EAC82CA7396A68D541C85D26508E83_1364827492 = retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_1364827492.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1364827492;
        // ---------- Original Method ----------
        //WarningList retval = new WarningList();
        //return retval.clonehlist(this.hlist);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.990 -0400", hash_original_field = "0D28E51547CF8629AAEF431248291D24", hash_generated_field = "546B02DCE7471BB4B665A16CFACDC783")

    private static final long serialVersionUID = -1423278728898430175L;
}

