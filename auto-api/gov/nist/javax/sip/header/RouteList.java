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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.157 -0400", hash_original_method = "D139D7EC1148299A31F54E2FC8ABBD38", hash_generated_method = "740A4A8603D56CB0E3B664BFE94DAD13")
    public  RouteList() {
        super(Route.class, RouteHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.158 -0400", hash_original_method = "2F61955E2C85706175B79FB3D2D2F3C0", hash_generated_method = "61A8910C72FC216446DA049A35CD7E45")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_2033995773 = null; //Variable for return #1
        RouteList retval = new RouteList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_2033995773 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_2033995773.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2033995773;
        // ---------- Original Method ----------
        //RouteList retval = new RouteList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.158 -0400", hash_original_method = "48C7607E6836F35D30114914C241A09A", hash_generated_method = "695326F3FAE3F901AA0EA8A51BA704BD")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_1972625483 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_394144268 = null; //Variable for return #2
        {
            boolean varD275F169E32BA3956D299AB16D2AE3E4_631060447 = (super.hlist.isEmpty());
            varB4EAC82CA7396A68D541C85D26508E83_1972625483 = "";
            varB4EAC82CA7396A68D541C85D26508E83_394144268 = super.encode();
        } //End collapsed parenthetic
        String varA7E53CE21691AB073D9660D615818899_1632464176; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1632464176 = varB4EAC82CA7396A68D541C85D26508E83_1972625483;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1632464176 = varB4EAC82CA7396A68D541C85D26508E83_394144268;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1632464176.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1632464176;
        // ---------- Original Method ----------
        //if ( super.hlist.isEmpty()) return "";
        //else return super.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.159 -0400", hash_original_method = "A0122B485E57B455599C6CF601D6C0DF", hash_generated_method = "1AD794B793A58C841EE91CFB0DD33BDD")
    public boolean equals(Object other) {
        RouteList that = (RouteList) other;
        {
            boolean varC5F003D93400649B46ACEC0E9A45D583_1703362206 = (this.size() != that.size());
        } //End collapsed parenthetic
        ListIterator<Route> it = this.listIterator();
        ListIterator<Route> it1 = that.listIterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_479111346 = (it.hasNext());
            {
                Route route = (Route) it.next();
                Route route1 = (Route) it1.next();
                {
                    boolean var966AB6A44187E5CD2D0EE24CB80CC8A3_1008540611 = (!route.equals(route1));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_190445478 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_190445478;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.159 -0400", hash_original_field = "D7AAF440428FA150F77B1E439C3B1197", hash_generated_field = "E9DB318843918A7C1284240E819CF95B")

    private static final long serialVersionUID = 3407603519354809748L;
}

