package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.header.*;
import java.util.ListIterator;

public class ContactList extends SIPHeaderList<Contact> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.218 -0400", hash_original_method = "08930BEB23E40A04FBC039BCEAB391C2", hash_generated_method = "FDEE660B06EBDACE244CFF335014AA8A")
    public  ContactList() {
        super(Contact.class, ContactHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.218 -0400", hash_original_method = "BED68D8C66CBF48DBAF6B0E90A05F961", hash_generated_method = "D58E50333E84310EBC813A755218C676")
    public Object clone() {
        ContactList retval = new ContactList();
        retval.clonehlist(this.hlist);
Object varF9E19AD6135C970F387F77C6F3DE4477_529951351 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_529951351.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_529951351;
        // ---------- Original Method ----------
        //ContactList retval = new ContactList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.218 -0400", hash_original_field = "9BCF80090F5E30F92409C29F9B5EB7FB", hash_generated_field = "E291D90893DDADD21A34D98329EAC5F7")

    private static final long serialVersionUID = 1224806837758986814L;
}

