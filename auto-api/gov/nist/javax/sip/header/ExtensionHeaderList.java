package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ListIterator;
import javax.sip.header.ExtensionHeader;
import javax.sip.header.Header;

public class ExtensionHeaderList extends SIPHeaderList<ExtensionHeaderImpl> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.941 -0400", hash_original_method = "9F1BA104827E0F2F29324BDDE3EB0EE9", hash_generated_method = "2924676E098739E5ECA29CEFC093B7A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ExtensionHeaderList(String hName) {
        super( ExtensionHeaderImpl.class, hName);
        dsTaint.addTaint(hName);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.941 -0400", hash_original_method = "52FAE424BADAAEF22385083D45DE9281", hash_generated_method = "B4759EE8D9DB6DE8172FBD3EF60E4182")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ExtensionHeaderList() {
        super(ExtensionHeaderImpl.class,null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.941 -0400", hash_original_method = "C859D426E02BE595D55C2FAA9CB97225", hash_generated_method = "372FE7404DB9FF3F573993ACD870EEB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        ExtensionHeaderList retval;
        retval = new ExtensionHeaderList(headerName);
        retval.clonehlist(this.hlist);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ExtensionHeaderList retval = new ExtensionHeaderList(headerName);
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.941 -0400", hash_original_method = "05F9E55197B7F8BF967FE19D758EB1FB", hash_generated_method = "66664FEF77B35061DEE6EB45C5754447")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encode() {
        StringBuffer retval;
        retval = new StringBuffer();
        ListIterator<ExtensionHeaderImpl> it;
        it = this.listIterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_907254607 = (it.hasNext());
            {
                ExtensionHeaderImpl eh;
                eh = (ExtensionHeaderImpl) it.next();
                retval.append(eh.encode());
            } //End block
        } //End collapsed parenthetic
        String var0F1F65BA89BF920BA1A29FC87F91B969_1240630706 = (retval.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuffer retval = new StringBuffer();
        //ListIterator<ExtensionHeaderImpl> it = this.listIterator();
        //while(it.hasNext()) {
           //ExtensionHeaderImpl eh = (ExtensionHeaderImpl) it.next();
           //retval.append(eh.encode());
        //}
        //return retval.toString();
    }

    
    private static final long serialVersionUID = 4681326807149890197L;
}

