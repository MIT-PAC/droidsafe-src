package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.SIPHeaderList;

public class PathList extends SIPHeaderList<Path> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.454 -0400", hash_original_method = "BE055353B660F0216B962EBC93C5926E", hash_generated_method = "549B6DD9125FAA9EA2320C528E76BA26")
    public  PathList() {
        super(Path.class, PathHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.454 -0400", hash_original_method = "1C195C24352DB076547F3A62B5CD27D2", hash_generated_method = "4285949C9BAB0F02E6B0433CEF7B4268")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1074427677 = null; //Variable for return #1
        PathList retval = new PathList();
        varB4EAC82CA7396A68D541C85D26508E83_1074427677 = retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_1074427677.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1074427677;
        // ---------- Original Method ----------
        //PathList retval = new PathList();
        //return retval.clonehlist(this.hlist);
    }

    
}

