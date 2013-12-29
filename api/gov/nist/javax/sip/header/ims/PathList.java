package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeaderList;


public class PathList extends SIPHeaderList<Path> {

    /** Default constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:51.963 -0500", hash_original_method = "BE055353B660F0216B962EBC93C5926E", hash_generated_method = "1D3B3C217405A9903FF2639F645A4B60")
    public PathList() {
        super(Path.class, PathHeader.NAME);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:51.964 -0500", hash_original_method = "1C195C24352DB076547F3A62B5CD27D2", hash_generated_method = "32C6FCFF55A55FC31596A4C5991D9FC1")
    public Object clone() {
        PathList retval = new PathList();
        return retval.clonehlist(this.hlist);
    }

    
}

