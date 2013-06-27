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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.429 -0400", hash_original_method = "D139D7EC1148299A31F54E2FC8ABBD38", hash_generated_method = "740A4A8603D56CB0E3B664BFE94DAD13")
    public  RouteList() {
        super(Route.class, RouteHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.429 -0400", hash_original_method = "2F61955E2C85706175B79FB3D2D2F3C0", hash_generated_method = "B3334A85B829F0765E6703F1F43A8E3E")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_537180386 = null; //Variable for return #1
        RouteList retval;
        retval = new RouteList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_537180386 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_537180386.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_537180386;
        // ---------- Original Method ----------
        //RouteList retval = new RouteList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.431 -0400", hash_original_method = "48C7607E6836F35D30114914C241A09A", hash_generated_method = "449EEE065F24680BE8ED189E7F4F5BDD")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_2009900486 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1107446148 = null; //Variable for return #2
        {
            boolean varD275F169E32BA3956D299AB16D2AE3E4_1861275606 = (super.hlist.isEmpty());
            varB4EAC82CA7396A68D541C85D26508E83_2009900486 = "";
            varB4EAC82CA7396A68D541C85D26508E83_1107446148 = super.encode();
        } //End collapsed parenthetic
        String varA7E53CE21691AB073D9660D615818899_1471733170; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1471733170 = varB4EAC82CA7396A68D541C85D26508E83_2009900486;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1471733170 = varB4EAC82CA7396A68D541C85D26508E83_1107446148;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1471733170.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1471733170;
        // ---------- Original Method ----------
        //if ( super.hlist.isEmpty()) return "";
        //else return super.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.436 -0400", hash_original_method = "A0122B485E57B455599C6CF601D6C0DF", hash_generated_method = "61812236C2434984BCA7658D84BA5489")
    public boolean equals(Object other) {
        RouteList that;
        that = (RouteList) other;
        {
            boolean varC5F003D93400649B46ACEC0E9A45D583_1126959602 = (this.size() != that.size());
        } //End collapsed parenthetic
        ListIterator<Route> it;
        it = this.listIterator();
        ListIterator<Route> it1;
        it1 = that.listIterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1761735563 = (it.hasNext());
            {
                Route route;
                route = (Route) it.next();
                Route route1;
                route1 = (Route) it1.next();
                {
                    boolean var966AB6A44187E5CD2D0EE24CB80CC8A3_1862562797 = (!route.equals(route1));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1277522503 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1277522503;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.436 -0400", hash_original_field = "D7AAF440428FA150F77B1E439C3B1197", hash_generated_field = "5DE31E3DC1A0E56F4E55302C18CCCFC0")

    private static long serialVersionUID = 3407603519354809748L;
}

