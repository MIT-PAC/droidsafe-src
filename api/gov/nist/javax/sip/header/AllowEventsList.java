package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.*;
import java.text.ParseException;
import javax.sip.header.*;

public class AllowEventsList extends SIPHeaderList<AllowEvents> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.763 -0400", hash_original_method = "BE25141B87EEBB7CC79E715B98DBCC1B", hash_generated_method = "A1202FE197D1B9DCE04FF93738262B91")
    public  AllowEventsList() {
        super(AllowEvents.class, AllowEventsHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.763 -0400", hash_original_method = "73FBB2E32770F78B7C4AE500CDD51F25", hash_generated_method = "5B262789B2B290382B872CFB5BF5BAC3")
    public Object clone() {
        AllowEventsList retval = new AllowEventsList();
        retval.clonehlist(this.hlist);
Object varF9E19AD6135C970F387F77C6F3DE4477_1835489206 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1835489206.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1835489206;
        // ---------- Original Method ----------
        //AllowEventsList retval = new AllowEventsList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.763 -0400", hash_original_method = "8BAEE8E3A5391DDA801BF0B845B6BCD7", hash_generated_method = "CBDC39FA51DCCD52575AE6A6ABCB9248")
    public ListIterator<String> getMethods() {
        ListIterator<AllowEvents> li = super.hlist.listIterator();
        LinkedList<String> ll = new LinkedList<String> ();
        while
(li.hasNext())        
        {
            AllowEvents allowEvents = (AllowEvents) li.next();
            ll.add(allowEvents.getEventType());
        } //End block
ListIterator<String> var7235968E19DD3F2C4738A491078B8CA6_1289305044 =         ll.listIterator();
        var7235968E19DD3F2C4738A491078B8CA6_1289305044.addTaint(taint);
        return var7235968E19DD3F2C4738A491078B8CA6_1289305044;
        // ---------- Original Method ----------
        //ListIterator<AllowEvents> li = super.hlist.listIterator();
        //LinkedList<String>  ll = new LinkedList<String> ();
        //while (li.hasNext()) {
            //AllowEvents allowEvents = (AllowEvents) li.next();
            //ll.add(allowEvents.getEventType());
        //}
        //return ll.listIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.764 -0400", hash_original_method = "222F0135AD0C9432632E9A9F7AD003FD", hash_generated_method = "03030E28EC1CE2FA8AE1745188C84303")
    public void setMethods(List<String> methods) throws ParseException {
        addTaint(methods.getTaint());
        ListIterator<String> it = methods.listIterator();
        while
(it.hasNext())        
        {
            AllowEvents allowEvents = new AllowEvents();
            allowEvents.setEventType((String) it.next());
            this.add(allowEvents);
        } //End block
        // ---------- Original Method ----------
        //ListIterator<String> it = methods.listIterator();
        //while (it.hasNext()) {
            //AllowEvents allowEvents = new AllowEvents();
            //allowEvents.setEventType((String) it.next());
            //this.add(allowEvents);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.764 -0400", hash_original_field = "9B4A51790DC9D39D457C58F68E673C3F", hash_generated_field = "86B6C308D3FCCC18BA910315347C5416")

    private static final long serialVersionUID = -684763195336212992L;
}

