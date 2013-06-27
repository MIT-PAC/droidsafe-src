package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.SIPHeaderList;

public class PathList extends SIPHeaderList<Path> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.591 -0400", hash_original_method = "BE055353B660F0216B962EBC93C5926E", hash_generated_method = "549B6DD9125FAA9EA2320C528E76BA26")
    public  PathList() {
        super(Path.class, PathHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.593 -0400", hash_original_method = "1C195C24352DB076547F3A62B5CD27D2", hash_generated_method = "48DE09CCD8FA561C4053D17876165377")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1058682292 = null; //Variable for return #1
        PathList retval;
        retval = new PathList();
        varB4EAC82CA7396A68D541C85D26508E83_1058682292 = retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_1058682292.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1058682292;
        // ---------- Original Method ----------
        //PathList retval = new PathList();
        //return retval.clonehlist(this.hlist);
    }

    
}

