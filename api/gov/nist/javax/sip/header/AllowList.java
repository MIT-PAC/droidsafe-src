package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javax.sip.header.AllowHeader;






public class AllowList extends SIPHeaderList<Allow> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.467 -0500", hash_original_field = "3126D085B18C0C241D668F6D8D8B569F", hash_generated_field = "8863FD75AF45B1DB104BC3DD11CC5A05")

    private static final long serialVersionUID = -4699795429662562358L;


    /** default constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.473 -0500", hash_original_method = "F4CA7E921A2CAA269087CDE3B4673EDF", hash_generated_method = "72E03A22D2A84D8D19DD811CA6FF01E8")
    
public AllowList() {
        super(Allow.class, AllowHeader.NAME);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.470 -0500", hash_original_method = "0478A1539FEF5A12FA1EE4755C128735", hash_generated_method = "DEDECA4600B8A2FB49B9D4A254B06A32")
    
public Object clone() {
        AllowList retval = new AllowList();
        retval.clonehlist(this.hlist);
        return retval;
    }

    /**
     * Gets an Iterator of all the methods of the AllowHeader. Returns an empty
     *
     * Iterator if no methods are defined in this Allow Header.
     *
     *
     *
     * @return Iterator of String objects each identifing the methods of
     *
     * AllowHeader.
     *
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.476 -0500", hash_original_method = "AEA3F358A5E0CA1930C1FE1C96E2D485", hash_generated_method = "EBD2DBE5931875805EE50D4F3F19DCE7")
    
public ListIterator<String> getMethods() {

        LinkedList<String> ll = new LinkedList<String> ();

        for ( Iterator<Allow> it = this.hlist.iterator(); it.hasNext();) {
            Allow a = (Allow)it.next();
            ll.add(a.getMethod());
        }

        return ll.listIterator();
    }

    /**
     * Sets the methods supported defined by this AllowHeader.
     *
     *
     *
     * @param methods - the Iterator of Strings defining the methods supported
     *
     * in this AllowHeader
     *
     * @throws ParseException which signals that an error has been reached
     *
     * unexpectedly while parsing the Strings defining the methods supported.
     *
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.479 -0500", hash_original_method = "6420AFA8DFEC18654E9A726650C49FF0", hash_generated_method = "D7E7781B5CBB37132AAC1EA1B8FF6648")
    
public void setMethods(List<String> methods) throws ParseException {
        ListIterator<String> it = methods.listIterator();
        while (it.hasNext()) {
            Allow allow = new Allow();
            allow.setMethod((String) it.next());
            this.add(allow);
        }
    }
}

