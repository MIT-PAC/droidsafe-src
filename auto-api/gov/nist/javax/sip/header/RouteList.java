package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;
import java.util.*;

public class RouteList extends SIPHeaderList<Route> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.470 -0400", hash_original_method = "D139D7EC1148299A31F54E2FC8ABBD38", hash_generated_method = "740A4A8603D56CB0E3B664BFE94DAD13")
    public  RouteList() {
        super(Route.class, RouteHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.471 -0400", hash_original_method = "2F61955E2C85706175B79FB3D2D2F3C0", hash_generated_method = "3C41BC5832EBFE09C0EC7072F4610C41")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_752857847 = null; //Variable for return #1
        RouteList retval;
        retval = new RouteList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_752857847 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_752857847.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_752857847;
        // ---------- Original Method ----------
        //RouteList retval = new RouteList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.471 -0400", hash_original_method = "48C7607E6836F35D30114914C241A09A", hash_generated_method = "A176DC29A77D29C3B93FE6080C4AAD3E")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_782352143 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1895592433 = null; //Variable for return #2
        {
            boolean varD275F169E32BA3956D299AB16D2AE3E4_935678216 = (super.hlist.isEmpty());
            varB4EAC82CA7396A68D541C85D26508E83_782352143 = "";
            varB4EAC82CA7396A68D541C85D26508E83_1895592433 = super.encode();
        } //End collapsed parenthetic
        String varA7E53CE21691AB073D9660D615818899_1243448074; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1243448074 = varB4EAC82CA7396A68D541C85D26508E83_782352143;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1243448074 = varB4EAC82CA7396A68D541C85D26508E83_1895592433;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1243448074.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1243448074;
        // ---------- Original Method ----------
        //if ( super.hlist.isEmpty()) return "";
        //else return super.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.472 -0400", hash_original_method = "A0122B485E57B455599C6CF601D6C0DF", hash_generated_method = "2BD39EAE446CADADDACF06584C462245")
    public boolean equals(Object other) {
        RouteList that;
        that = (RouteList) other;
        {
            boolean varC5F003D93400649B46ACEC0E9A45D583_145753396 = (this.size() != that.size());
        } //End collapsed parenthetic
        ListIterator<Route> it;
        it = this.listIterator();
        ListIterator<Route> it1;
        it1 = that.listIterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1788467417 = (it.hasNext());
            {
                Route route;
                route = (Route) it.next();
                Route route1;
                route1 = (Route) it1.next();
                {
                    boolean var966AB6A44187E5CD2D0EE24CB80CC8A3_738734595 = (!route.equals(route1));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_885464808 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_885464808;
        // ---------- Original Method ----------
        //if (!(other instanceof RouteList))
            //return false;
        //RouteList that = (RouteList) other;
        //if (this.size() != that.size())
            //return false;
        //ListIterator<Route> it = this.listIterator();
        //ListIterator<Route> it1 = that.listIterator();
        //while (it.hasNext()) {
            //Route route = (Route) it.next();
            //Route route1 = (Route) it1.next();
            //if (!route.equals(route1))
                //return false;
        //}
        //return true;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.472 -0400", hash_original_field = "D7AAF440428FA150F77B1E439C3B1197", hash_generated_field = "5DE31E3DC1A0E56F4E55302C18CCCFC0")

    private static long serialVersionUID = 3407603519354809748L;
}

