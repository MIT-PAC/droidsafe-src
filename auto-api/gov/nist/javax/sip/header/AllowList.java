package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.*;
import java.text.ParseException;
import javax.sip.header.*;

public class AllowList extends SIPHeaderList<Allow> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.920 -0400", hash_original_method = "F4CA7E921A2CAA269087CDE3B4673EDF", hash_generated_method = "D9C4828F0D645AEECBD56D2F64C1FA84")
    public  AllowList() {
        super(Allow.class, AllowHeader.NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.921 -0400", hash_original_method = "0478A1539FEF5A12FA1EE4755C128735", hash_generated_method = "5E10A443B88ADBE5D001DA04212FA0ED")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1232971617 = null; 
        AllowList retval = new AllowList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_1232971617 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1232971617.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1232971617;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.922 -0400", hash_original_method = "AEA3F358A5E0CA1930C1FE1C96E2D485", hash_generated_method = "8764338852D6E1D08B35D04B6101DD87")
    public ListIterator<String> getMethods() {
        ListIterator<String> varB4EAC82CA7396A68D541C85D26508E83_268036005 = null; 
        LinkedList<String> ll = new LinkedList<String> ();
        {
            Iterator<Allow> it = this.hlist.iterator();
            boolean var03729FD53960D8DCA3A41A13A0229637_619049431 = (it.hasNext());
            {
                Allow a = (Allow)it.next();
                ll.add(a.getMethod());
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_268036005 = ll.listIterator();
        varB4EAC82CA7396A68D541C85D26508E83_268036005.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_268036005;
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.923 -0400", hash_original_method = "6420AFA8DFEC18654E9A726650C49FF0", hash_generated_method = "6CFDD9E8FCEED905956D5C41086D47B1")
    public void setMethods(List<String> methods) throws ParseException {
        ListIterator<String> it = methods.listIterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_370188991 = (it.hasNext());
            {
                Allow allow = new Allow();
                allow.setMethod((String) it.next());
                this.add(allow);
            } 
        } 
        addTaint(methods.getTaint());
        
        
        
            
            
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.924 -0400", hash_original_field = "677FE0780DF95025943ABD130FD2DC12", hash_generated_field = "8863FD75AF45B1DB104BC3DD11CC5A05")

    private static final long serialVersionUID = -4699795429662562358L;
}

