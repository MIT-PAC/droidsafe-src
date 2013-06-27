package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;
import java.util.Iterator;

public final class ViaList extends SIPHeaderList<Via> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.796 -0400", hash_original_method = "810E0ED8E1E79C548735B6B2AD5FE1B8", hash_generated_method = "075F5CC46E50FEE2ED5E752A18746683")
    public  ViaList() {
        super(Via.class, ViaHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.797 -0400", hash_original_method = "4D93C8A8DA65DDEDB364A162E5648CA9", hash_generated_method = "A257A092C076B23260432A57A7386D2C")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_857971710 = null; //Variable for return #1
        ViaList retval;
        retval = new ViaList();
        varB4EAC82CA7396A68D541C85D26508E83_857971710 = retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_857971710.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_857971710;
        // ---------- Original Method ----------
        //ViaList retval = new ViaList();
        //return retval.clonehlist(this.hlist);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.797 -0400", hash_original_field = "3ECBF1E8B8DA1501F382FF3D98D84F4A", hash_generated_field = "7DBDC6703916434BAAEEAB3D6BDDEBEC")

    private static long serialVersionUID = 3899679374556152313L;
}

