package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;

public final class ContentEncodingList extends SIPHeaderList<ContentEncoding> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.403 -0400", hash_original_method = "D2B39D5ACAE79985BE6285F6D548E94B", hash_generated_method = "9E0268B063A40FA0BEE5F57BE7734754")
    public  ContentEncodingList() {
        super( ContentEncoding.class,
            ContentEncodingHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.404 -0400", hash_original_method = "1AD27EAA5BBA618A109A28F19AA4BF35", hash_generated_method = "A064513C9057316F61D7F3DDF399F39F")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1629497106 = null; //Variable for return #1
        ContentEncodingList retval = new ContentEncodingList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_1629497106 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1629497106.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1629497106;
        // ---------- Original Method ----------
        //ContentEncodingList retval = new ContentEncodingList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.404 -0400", hash_original_field = "35F458B67665F3977218E98737514A57", hash_generated_field = "612F67254FCE833D5ACC9D399512B874")

    private static final long serialVersionUID = 7365216146576273970L;
}

