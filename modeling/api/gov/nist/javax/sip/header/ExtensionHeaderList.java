package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ListIterator;

public class ExtensionHeaderList extends SIPHeaderList<ExtensionHeaderImpl> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.521 -0500", hash_original_field = "58E3CCA7E2AAA3E0DC76C7C57052B201", hash_generated_field = "C901BD677804F800F6B013B6AE6500C8")

    private static final long serialVersionUID = 4681326807149890197L;
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.527 -0500", hash_original_method = "9F1BA104827E0F2F29324BDDE3EB0EE9", hash_generated_method = "51B2C597779951FAD329383C2C836B25")
    
public ExtensionHeaderList(String hName) {
        super( ExtensionHeaderImpl.class, hName);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.530 -0500", hash_original_method = "52FAE424BADAAEF22385083D45DE9281", hash_generated_method = "AEBCEF2F63FAE8D2CF1FFDFEBA42309F")
    
public ExtensionHeaderList() {
        super(ExtensionHeaderImpl.class,null);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.523 -0500", hash_original_method = "C859D426E02BE595D55C2FAA9CB97225", hash_generated_method = "B7F895EB064386538442B0104026E859")
    
public Object clone() {
        ExtensionHeaderList retval = new ExtensionHeaderList(headerName);
        retval.clonehlist(this.hlist);
        return retval;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.534 -0500", hash_original_method = "05F9E55197B7F8BF967FE19D758EB1FB", hash_generated_method = "9112A084FC8B867E36A85D3547A2F8E6")
    
public String encode() {
        StringBuffer retval = new StringBuffer();
        ListIterator<ExtensionHeaderImpl> it = this.listIterator();
        while(it.hasNext()) {
           ExtensionHeaderImpl eh = (ExtensionHeaderImpl) it.next();
           retval.append(eh.encode());
        }
        return retval.toString();
    }
}

