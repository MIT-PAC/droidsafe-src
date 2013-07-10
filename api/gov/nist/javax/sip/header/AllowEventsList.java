package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.*;
import java.text.ParseException;
import javax.sip.header.*;

public class AllowEventsList extends SIPHeaderList<AllowEvents> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.907 -0400", hash_original_method = "BE25141B87EEBB7CC79E715B98DBCC1B", hash_generated_method = "A1202FE197D1B9DCE04FF93738262B91")
    public  AllowEventsList() {
        super(AllowEvents.class, AllowEventsHeader.NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.908 -0400", hash_original_method = "73FBB2E32770F78B7C4AE500CDD51F25", hash_generated_method = "F9C5646B852ECCDA87EE257FE6647CA9")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_919611714 = null; 
        AllowEventsList retval = new AllowEventsList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_919611714 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_919611714.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_919611714;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.909 -0400", hash_original_method = "8BAEE8E3A5391DDA801BF0B845B6BCD7", hash_generated_method = "0296CFC0D2FB30C746644A14D4B93167")
    public ListIterator<String> getMethods() {
        ListIterator<String> varB4EAC82CA7396A68D541C85D26508E83_1027820907 = null; 
        ListIterator<AllowEvents> li = super.hlist.listIterator();
        LinkedList<String> ll = new LinkedList<String> ();
        {
            boolean varBC3D864DE8830EFC1098D2C2F456529D_960182411 = (li.hasNext());
            {
                AllowEvents allowEvents = (AllowEvents) li.next();
                ll.add(allowEvents.getEventType());
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1027820907 = ll.listIterator();
        varB4EAC82CA7396A68D541C85D26508E83_1027820907.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1027820907;
        
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.909 -0400", hash_original_method = "222F0135AD0C9432632E9A9F7AD003FD", hash_generated_method = "3F6E0748021386CCD853600153483DD8")
    public void setMethods(List<String> methods) throws ParseException {
        ListIterator<String> it = methods.listIterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_506602507 = (it.hasNext());
            {
                AllowEvents allowEvents = new AllowEvents();
                allowEvents.setEventType((String) it.next());
                this.add(allowEvents);
            } 
        } 
        addTaint(methods.getTaint());
        
        
        
            
            
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.909 -0400", hash_original_field = "9B4A51790DC9D39D457C58F68E673C3F", hash_generated_field = "86B6C308D3FCCC18BA910315347C5416")

    private static final long serialVersionUID = -684763195336212992L;
}

