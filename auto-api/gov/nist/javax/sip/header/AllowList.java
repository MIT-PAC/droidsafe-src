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

public class AllowList extends SIPHeaderList<Allow> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.675 -0400", hash_original_method = "F4CA7E921A2CAA269087CDE3B4673EDF", hash_generated_method = "D9C4828F0D645AEECBD56D2F64C1FA84")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AllowList() {
        super(Allow.class, AllowHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.675 -0400", hash_original_method = "0478A1539FEF5A12FA1EE4755C128735", hash_generated_method = "39D33A7B266EF04D25F882A67390D85E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        AllowList retval;
        retval = new AllowList();
        retval.clonehlist(this.hlist);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //AllowList retval = new AllowList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.676 -0400", hash_original_method = "AEA3F358A5E0CA1930C1FE1C96E2D485", hash_generated_method = "E20F8CB9904FF73FDDEEC24CF5BF8F68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ListIterator<String> getMethods() {
        LinkedList<String> ll;
        ll = new LinkedList<String> ();
        {
            Iterator<Allow> it;
            it = this.hlist.iterator();
            boolean var03729FD53960D8DCA3A41A13A0229637_326309822 = (it.hasNext());
            {
                Allow a;
                a = (Allow)it.next();
                ll.add(a.getMethod());
            } //End block
        } //End collapsed parenthetic
        ListIterator<String> var2256224AFFE6B2DDBD524465958612EA_1842780185 = (ll.listIterator());
        return (ListIterator<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //LinkedList<String> ll = new LinkedList<String> ();
        //for ( Iterator<Allow> it = this.hlist.iterator(); it.hasNext();) {
            //Allow a = (Allow)it.next();
            //ll.add(a.getMethod());
        //}
        //return ll.listIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.676 -0400", hash_original_method = "6420AFA8DFEC18654E9A726650C49FF0", hash_generated_method = "954D528CF39A3CD907D5A5D4A67E0764")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMethods(List<String> methods) throws ParseException {
        dsTaint.addTaint(methods.dsTaint);
        ListIterator<String> it;
        it = methods.listIterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1104843477 = (it.hasNext());
            {
                Allow allow;
                allow = new Allow();
                allow.setMethod((String) it.next());
                this.add(allow);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //ListIterator<String> it = methods.listIterator();
        //while (it.hasNext()) {
            //Allow allow = new Allow();
            //allow.setMethod((String) it.next());
            //this.add(allow);
        //}
    }

    
    private static final long serialVersionUID = -4699795429662562358L;
}

