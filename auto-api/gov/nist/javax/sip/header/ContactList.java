package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;
import java.util.ListIterator;

public class ContactList extends SIPHeaderList<Contact> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.884 -0400", hash_original_method = "08930BEB23E40A04FBC039BCEAB391C2", hash_generated_method = "FDEE660B06EBDACE244CFF335014AA8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContactList() {
        super(Contact.class, ContactHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.885 -0400", hash_original_method = "BED68D8C66CBF48DBAF6B0E90A05F961", hash_generated_method = "2B829DBE48243A68FC8C452BB97C6161")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        ContactList retval;
        retval = new ContactList();
        retval.clonehlist(this.hlist);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ContactList retval = new ContactList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    private static final long serialVersionUID = 1224806837758986814L;
}

