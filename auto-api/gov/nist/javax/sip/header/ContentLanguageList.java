package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;

public final class ContentLanguageList extends SIPHeaderList<ContentLanguage> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.900 -0400", hash_original_method = "E0E10BF5A133A10286DF9F5F2B3DD32A", hash_generated_method = "B287B041EB942C3779176FC9062E1E91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContentLanguageList() {
        super(ContentLanguage.class,
            ContentLanguageHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.901 -0400", hash_original_method = "7F1D883A3CFE2424D76B8075C1055DCD", hash_generated_method = "121DF6A3D8C53BBC4624594AE7908743")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        ContentLanguageList retval;
        retval = new ContentLanguageList();
        retval.clonehlist(this.hlist);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ContentLanguageList retval = new ContentLanguageList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    private static final long serialVersionUID = -5302265987802886465L;
}

