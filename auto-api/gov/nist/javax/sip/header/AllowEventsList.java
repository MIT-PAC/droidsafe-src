package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.*;
import java.text.ParseException;
import javax.sip.header.*;

public class AllowEventsList extends SIPHeaderList<AllowEvents> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.283 -0400", hash_original_method = "BE25141B87EEBB7CC79E715B98DBCC1B", hash_generated_method = "A1202FE197D1B9DCE04FF93738262B91")
    public  AllowEventsList() {
        super(AllowEvents.class, AllowEventsHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.290 -0400", hash_original_method = "73FBB2E32770F78B7C4AE500CDD51F25", hash_generated_method = "2E81E58B05351ACCF2F53141AC2ED73B")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1779291574 = null; //Variable for return #1
        AllowEventsList retval;
        retval = new AllowEventsList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_1779291574 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1779291574.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1779291574;
        // ---------- Original Method ----------
        //AllowEventsList retval = new AllowEventsList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.298 -0400", hash_original_method = "8BAEE8E3A5391DDA801BF0B845B6BCD7", hash_generated_method = "062E13C35868E1F1645897B48F963A9E")
    public ListIterator<String> getMethods() {
        ListIterator<String> varB4EAC82CA7396A68D541C85D26508E83_1246233891 = null; //Variable for return #1
        ListIterator<AllowEvents> li;
        li = super.hlist.listIterator();
        LinkedList<String> ll;
        ll = new LinkedList<String> ();
        {
            boolean varBC3D864DE8830EFC1098D2C2F456529D_451151182 = (li.hasNext());
            {
                AllowEvents allowEvents;
                allowEvents = (AllowEvents) li.next();
                ll.add(allowEvents.getEventType());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1246233891 = ll.listIterator();
        varB4EAC82CA7396A68D541C85D26508E83_1246233891.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1246233891;
        // ---------- Original Method ----------
        //ListIterator<AllowEvents> li = super.hlist.listIterator();
        //LinkedList<String>  ll = new LinkedList<String> ();
        //while (li.hasNext()) {
            //AllowEvents allowEvents = (AllowEvents) li.next();
            //ll.add(allowEvents.getEventType());
        //}
        //return ll.listIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.307 -0400", hash_original_method = "222F0135AD0C9432632E9A9F7AD003FD", hash_generated_method = "D5905A569D9460C2B3B4D2FD022E4012")
    public void setMethods(List<String> methods) throws ParseException {
        ListIterator<String> it;
        it = methods.listIterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_231539583 = (it.hasNext());
            {
                AllowEvents allowEvents;
                allowEvents = new AllowEvents();
                allowEvents.setEventType((String) it.next());
                this.add(allowEvents);
            } //End block
        } //End collapsed parenthetic
        addTaint(methods.getTaint());
        // ---------- Original Method ----------
        //ListIterator<String> it = methods.listIterator();
        //while (it.hasNext()) {
            //AllowEvents allowEvents = new AllowEvents();
            //allowEvents.setEventType((String) it.next());
            //this.add(allowEvents);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.307 -0400", hash_original_field = "9B4A51790DC9D39D457C58F68E673C3F", hash_generated_field = "53B5E9BED2B3AA2C41C82825A70DFF8C")

    private static long serialVersionUID = -684763195336212992L;
}

