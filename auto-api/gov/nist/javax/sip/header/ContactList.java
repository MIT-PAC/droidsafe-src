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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.674 -0400", hash_original_method = "08930BEB23E40A04FBC039BCEAB391C2", hash_generated_method = "FDEE660B06EBDACE244CFF335014AA8A")
    public  ContactList() {
        super(Contact.class, ContactHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.675 -0400", hash_original_method = "BED68D8C66CBF48DBAF6B0E90A05F961", hash_generated_method = "35EB91E35821DF7DFFCC28377B7A16B0")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_199611243 = null; //Variable for return #1
        ContactList retval;
        retval = new ContactList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_199611243 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_199611243.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_199611243;
        // ---------- Original Method ----------
        //ContactList retval = new ContactList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.675 -0400", hash_original_field = "9BCF80090F5E30F92409C29F9B5EB7FB", hash_generated_field = "B54CEB46416BCCAC2E16AE88ED1890F5")

    private static long serialVersionUID = 1224806837758986814L;
}

