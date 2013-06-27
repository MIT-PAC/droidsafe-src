package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;

public class SupportedList extends SIPHeaderList<Supported> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.798 -0400", hash_original_method = "C97E7EF6FC87A3A068AC23349CE0B329", hash_generated_method = "9D8330A8D22F00AA1938D1F30E872420")
    public  SupportedList() {
        super(Supported.class, SupportedHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.799 -0400", hash_original_method = "45CDCD8BD327539AF66457D00250AD24", hash_generated_method = "6F5A297E9F8F7880117F557BC61F9455")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_803100778 = null; //Variable for return #1
        SupportedList retval;
        retval = new SupportedList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_803100778 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_803100778.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_803100778;
        // ---------- Original Method ----------
        //SupportedList retval = new SupportedList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.799 -0400", hash_original_field = "0C172D453BA0BA79FBC9C11E860BD33B", hash_generated_field = "77183F171450CAE05C6DC6A2B0963AD9")

    private static long serialVersionUID = -4539299544895602367L;
}

