package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;

public final class ContentEncodingList extends SIPHeaderList<ContentEncoding> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.762 -0400", hash_original_method = "D2B39D5ACAE79985BE6285F6D548E94B", hash_generated_method = "9E0268B063A40FA0BEE5F57BE7734754")
    public  ContentEncodingList() {
        super( ContentEncoding.class,
            ContentEncodingHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.762 -0400", hash_original_method = "1AD27EAA5BBA618A109A28F19AA4BF35", hash_generated_method = "247C0F7DDA0D7A040FE2A79692CB6313")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_24171727 = null; //Variable for return #1
        ContentEncodingList retval;
        retval = new ContentEncodingList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_24171727 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_24171727.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_24171727;
        // ---------- Original Method ----------
        //ContentEncodingList retval = new ContentEncodingList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.762 -0400", hash_original_field = "35F458B67665F3977218E98737514A57", hash_generated_field = "6C6D823E04946A87F9EF7E868D31F90A")

    private static long serialVersionUID = 7365216146576273970L;
}

