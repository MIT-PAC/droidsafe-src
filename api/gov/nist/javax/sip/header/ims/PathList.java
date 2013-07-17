package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.SIPHeaderList;

public class PathList extends SIPHeaderList<Path> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.371 -0400", hash_original_method = "BE055353B660F0216B962EBC93C5926E", hash_generated_method = "549B6DD9125FAA9EA2320C528E76BA26")
    public  PathList() {
        super(Path.class, PathHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.371 -0400", hash_original_method = "1C195C24352DB076547F3A62B5CD27D2", hash_generated_method = "FDF7075EE2291FF4260464C14631B340")
    public Object clone() {
        PathList retval = new PathList();
Object varF627329B9209466293A1BF71D9AF7B2B_1990962897 =         retval.clonehlist(this.hlist);
        varF627329B9209466293A1BF71D9AF7B2B_1990962897.addTaint(taint);
        return varF627329B9209466293A1BF71D9AF7B2B_1990962897;
        // ---------- Original Method ----------
        //PathList retval = new PathList();
        //return retval.clonehlist(this.hlist);
    }

    
}

