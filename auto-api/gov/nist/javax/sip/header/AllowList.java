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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.470 -0400", hash_original_method = "F4CA7E921A2CAA269087CDE3B4673EDF", hash_generated_method = "D9C4828F0D645AEECBD56D2F64C1FA84")
    public  AllowList() {
        super(Allow.class, AllowHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.475 -0400", hash_original_method = "0478A1539FEF5A12FA1EE4755C128735", hash_generated_method = "C08B5F74EA5F082750957EA59EE8E02C")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_786400221 = null; //Variable for return #1
        AllowList retval;
        retval = new AllowList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_786400221 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_786400221.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_786400221;
        // ---------- Original Method ----------
        //AllowList retval = new AllowList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.477 -0400", hash_original_method = "AEA3F358A5E0CA1930C1FE1C96E2D485", hash_generated_method = "E4E88E16DC5F39D262909E5E81C75F75")
    public ListIterator<String> getMethods() {
        ListIterator<String> varB4EAC82CA7396A68D541C85D26508E83_1251498530 = null; //Variable for return #1
        LinkedList<String> ll;
        ll = new LinkedList<String> ();
        {
            Iterator<Allow> it;
            it = this.hlist.iterator();
            boolean var03729FD53960D8DCA3A41A13A0229637_1749544732 = (it.hasNext());
            {
                Allow a;
                a = (Allow)it.next();
                ll.add(a.getMethod());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1251498530 = ll.listIterator();
        varB4EAC82CA7396A68D541C85D26508E83_1251498530.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1251498530;
        // ---------- Original Method ----------
        //LinkedList<String> ll = new LinkedList<String> ();
        //for ( Iterator<Allow> it = this.hlist.iterator(); it.hasNext();) {
            //Allow a = (Allow)it.next();
            //ll.add(a.getMethod());
        //}
        //return ll.listIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.477 -0400", hash_original_method = "6420AFA8DFEC18654E9A726650C49FF0", hash_generated_method = "1F77F0C43368E5E565605E6ABEEE6541")
    public void setMethods(List<String> methods) throws ParseException {
        ListIterator<String> it;
        it = methods.listIterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1194199240 = (it.hasNext());
            {
                Allow allow;
                allow = new Allow();
                allow.setMethod((String) it.next());
                this.add(allow);
            } //End block
        } //End collapsed parenthetic
        addTaint(methods.getTaint());
        // ---------- Original Method ----------
        //ListIterator<String> it = methods.listIterator();
        //while (it.hasNext()) {
            //Allow allow = new Allow();
            //allow.setMethod((String) it.next());
            //this.add(allow);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.478 -0400", hash_original_field = "677FE0780DF95025943ABD130FD2DC12", hash_generated_field = "A5F6882F027BA9044A4566ED353737E7")

    private static long serialVersionUID = -4699795429662562358L;
}

