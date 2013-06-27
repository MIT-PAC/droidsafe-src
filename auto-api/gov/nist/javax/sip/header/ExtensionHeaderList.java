package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ListIterator;
import javax.sip.header.ExtensionHeader;
import javax.sip.header.Header;

public class ExtensionHeaderList extends SIPHeaderList<ExtensionHeaderImpl> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.975 -0400", hash_original_method = "9F1BA104827E0F2F29324BDDE3EB0EE9", hash_generated_method = "3D5B61862F27E9137B1BDBC12BD22287")
    public  ExtensionHeaderList(String hName) {
        super( ExtensionHeaderImpl.class, hName);
        addTaint(hName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.976 -0400", hash_original_method = "52FAE424BADAAEF22385083D45DE9281", hash_generated_method = "B4759EE8D9DB6DE8172FBD3EF60E4182")
    public  ExtensionHeaderList() {
        super(ExtensionHeaderImpl.class,null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.976 -0400", hash_original_method = "C859D426E02BE595D55C2FAA9CB97225", hash_generated_method = "9C3E630DF25BCF3F2AEAA12301EE0B57")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1452739286 = null; //Variable for return #1
        ExtensionHeaderList retval;
        retval = new ExtensionHeaderList(headerName);
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_1452739286 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1452739286.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1452739286;
        // ---------- Original Method ----------
        //ExtensionHeaderList retval = new ExtensionHeaderList(headerName);
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.977 -0400", hash_original_method = "05F9E55197B7F8BF967FE19D758EB1FB", hash_generated_method = "A9B3921DB8E925225FF58F81B61203C5")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_671215784 = null; //Variable for return #1
        StringBuffer retval;
        retval = new StringBuffer();
        ListIterator<ExtensionHeaderImpl> it;
        it = this.listIterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_2091965068 = (it.hasNext());
            {
                ExtensionHeaderImpl eh;
                eh = (ExtensionHeaderImpl) it.next();
                retval.append(eh.encode());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_671215784 = retval.toString();
        varB4EAC82CA7396A68D541C85D26508E83_671215784.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_671215784;
        // ---------- Original Method ----------
        //StringBuffer retval = new StringBuffer();
        //ListIterator<ExtensionHeaderImpl> it = this.listIterator();
        //while(it.hasNext()) {
           //ExtensionHeaderImpl eh = (ExtensionHeaderImpl) it.next();
           //retval.append(eh.encode());
        //}
        //return retval.toString();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.977 -0400", hash_original_field = "49645EF719FC8343E1DC5FC8240E0CF5", hash_generated_field = "10C35333E6515F24176B0AFD4602C1F5")

    private static long serialVersionUID = 4681326807149890197L;
}

