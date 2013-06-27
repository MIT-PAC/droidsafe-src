package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;

public final class ContentLanguageList extends SIPHeaderList<ContentLanguage> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.889 -0400", hash_original_method = "E0E10BF5A133A10286DF9F5F2B3DD32A", hash_generated_method = "B287B041EB942C3779176FC9062E1E91")
    public  ContentLanguageList() {
        super(ContentLanguage.class,
            ContentLanguageHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.890 -0400", hash_original_method = "7F1D883A3CFE2424D76B8075C1055DCD", hash_generated_method = "66D2812627DDC17DA5D7B06ED616AE7F")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1672936713 = null; //Variable for return #1
        ContentLanguageList retval;
        retval = new ContentLanguageList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_1672936713 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1672936713.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1672936713;
        // ---------- Original Method ----------
        //ContentLanguageList retval = new ContentLanguageList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.890 -0400", hash_original_field = "2FCBD6BE5A8E47E65A4185F7407B6E53", hash_generated_field = "2054C5B6FF740127B621E85A3C2E7A56")

    private static long serialVersionUID = -5302265987802886465L;
}

