package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.header.ContactHeader;






public class ContactList extends SIPHeaderList<Contact> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.284 -0500", hash_original_field = "B96A442BF1BF7586B00FE080FF2A9C4A", hash_generated_field = "E291D90893DDADD21A34D98329EAC5F7")


    private static final long serialVersionUID = 1224806837758986814L;
    /**
     * Constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.294 -0500", hash_original_method = "08930BEB23E40A04FBC039BCEAB391C2", hash_generated_method = "0F15B70E29F7A7F39B29D14A09DFF381")
    
public ContactList() {
        super(Contact.class, ContactHeader.NAME);

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.289 -0500", hash_original_method = "BED68D8C66CBF48DBAF6B0E90A05F961", hash_generated_method = "AF13FD62132D1786E55AA330F1C50A93")
    
public Object clone() {
        ContactList retval = new ContactList();
        retval.clonehlist(this.hlist);
        return retval;
    }
}

