package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.SIPHeaderList;

public class PathList extends SIPHeaderList<Path> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.635 -0400", hash_original_method = "BE055353B660F0216B962EBC93C5926E", hash_generated_method = "549B6DD9125FAA9EA2320C528E76BA26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PathList() {
        super(Path.class, PathHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.635 -0400", hash_original_method = "1C195C24352DB076547F3A62B5CD27D2", hash_generated_method = "FA96789C2DC42F276404847BC901500A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        PathList retval;
        retval = new PathList();
        Object varF7AD6DD8E2D0A0D86D7DC6EABC62B125_1683965505 = (retval.clonehlist(this.hlist));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //PathList retval = new PathList();
        //return retval.clonehlist(this.hlist);
    }

    
}

