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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.670 -0400", hash_original_method = "BE25141B87EEBB7CC79E715B98DBCC1B", hash_generated_method = "A1202FE197D1B9DCE04FF93738262B91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AllowEventsList() {
        super(AllowEvents.class, AllowEventsHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.670 -0400", hash_original_method = "73FBB2E32770F78B7C4AE500CDD51F25", hash_generated_method = "3E206D193176318F158ACF75F50F650F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        AllowEventsList retval;
        retval = new AllowEventsList();
        retval.clonehlist(this.hlist);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //AllowEventsList retval = new AllowEventsList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.670 -0400", hash_original_method = "8BAEE8E3A5391DDA801BF0B845B6BCD7", hash_generated_method = "307DC343BC15AEDA2F56D02C8B4D21A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ListIterator<String> getMethods() {
        ListIterator<AllowEvents> li;
        li = super.hlist.listIterator();
        LinkedList<String> ll;
        ll = new LinkedList<String> ();
        {
            boolean varBC3D864DE8830EFC1098D2C2F456529D_1524461907 = (li.hasNext());
            {
                AllowEvents allowEvents;
                allowEvents = (AllowEvents) li.next();
                ll.add(allowEvents.getEventType());
            } //End block
        } //End collapsed parenthetic
        ListIterator<String> var2256224AFFE6B2DDBD524465958612EA_1108925665 = (ll.listIterator());
        return (ListIterator<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ListIterator<AllowEvents> li = super.hlist.listIterator();
        //LinkedList<String>  ll = new LinkedList<String> ();
        //while (li.hasNext()) {
            //AllowEvents allowEvents = (AllowEvents) li.next();
            //ll.add(allowEvents.getEventType());
        //}
        //return ll.listIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.671 -0400", hash_original_method = "222F0135AD0C9432632E9A9F7AD003FD", hash_generated_method = "EFB56EB3E1070372C3C8587A4EB8CD06")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMethods(List<String> methods) throws ParseException {
        dsTaint.addTaint(methods.dsTaint);
        ListIterator<String> it;
        it = methods.listIterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1327942522 = (it.hasNext());
            {
                AllowEvents allowEvents;
                allowEvents = new AllowEvents();
                allowEvents.setEventType((String) it.next());
                this.add(allowEvents);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //ListIterator<String> it = methods.listIterator();
        //while (it.hasNext()) {
            //AllowEvents allowEvents = new AllowEvents();
            //allowEvents.setEventType((String) it.next());
            //this.add(allowEvents);
        //}
    }

    
    private static final long serialVersionUID = -684763195336212992L;
}

