package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.ListIterator;
import javax.sip.header.ExtensionHeader;
import javax.sip.header.Header;

public class ExtensionHeaderList extends SIPHeaderList<ExtensionHeaderImpl> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.540 -0400", hash_original_method = "9F1BA104827E0F2F29324BDDE3EB0EE9", hash_generated_method = "3D5B61862F27E9137B1BDBC12BD22287")
    public  ExtensionHeaderList(String hName) {
        super( ExtensionHeaderImpl.class, hName);
        addTaint(hName.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.541 -0400", hash_original_method = "52FAE424BADAAEF22385083D45DE9281", hash_generated_method = "B4759EE8D9DB6DE8172FBD3EF60E4182")
    public  ExtensionHeaderList() {
        super(ExtensionHeaderImpl.class,null);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.541 -0400", hash_original_method = "C859D426E02BE595D55C2FAA9CB97225", hash_generated_method = "9FCC66DB1DF2BE071C6305F4C228919A")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1044010652 = null; 
        ExtensionHeaderList retval = new ExtensionHeaderList(headerName);
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_1044010652 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1044010652.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1044010652;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.541 -0400", hash_original_method = "05F9E55197B7F8BF967FE19D758EB1FB", hash_generated_method = "7AD4BBEDF40DDF9FBB1BB0EAE3225708")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_1612405668 = null; 
        StringBuffer retval = new StringBuffer();
        ListIterator<ExtensionHeaderImpl> it = this.listIterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_718236489 = (it.hasNext());
            {
                ExtensionHeaderImpl eh = (ExtensionHeaderImpl) it.next();
                retval.append(eh.encode());
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1612405668 = retval.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1612405668.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1612405668;
        
        
        
        
           
           
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.542 -0400", hash_original_field = "49645EF719FC8343E1DC5FC8240E0CF5", hash_generated_field = "C901BD677804F800F6B013B6AE6500C8")

    private static final long serialVersionUID = 4681326807149890197L;
}

