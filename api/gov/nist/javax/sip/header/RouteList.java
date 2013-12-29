package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ListIterator;

import javax.sip.header.RouteHeader;






public class RouteList extends SIPHeaderList<Route> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:56.123 -0500", hash_original_field = "FBB315F346145333B7DA5F8B44F1528B", hash_generated_field = "E9DB318843918A7C1284240E819CF95B")


    private static final long serialVersionUID = 3407603519354809748L;


    /** default constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:56.124 -0500", hash_original_method = "D139D7EC1148299A31F54E2FC8ABBD38", hash_generated_method = "CB92DE875B9E55E495E5D29EFAA43A60")
    public RouteList() {
        super(Route.class, RouteHeader.NAME);

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:56.125 -0500", hash_original_method = "2F61955E2C85706175B79FB3D2D2F3C0", hash_generated_method = "3AE466ADB4F0E366572AF5C7F6662148")
    public Object clone() {
        RouteList retval = new RouteList();
        retval.clonehlist(this.hlist);
        return retval;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:56.126 -0500", hash_original_method = "48C7607E6836F35D30114914C241A09A", hash_generated_method = "00E0C4F60806BC67BD7CEDD480BF4C7C")
    public String encode() {
        if ( super.hlist.isEmpty()) return "";
        else return super.encode();
    }


    /**
    * Order is important when comparing route lists.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:56.127 -0500", hash_original_method = "A0122B485E57B455599C6CF601D6C0DF", hash_generated_method = "4D776348804CFA53F1F532DA6E9B2F88")
    public boolean equals(Object other) {
        if (!(other instanceof RouteList))
            return false;
        RouteList that = (RouteList) other;
        if (this.size() != that.size())
            return false;
        ListIterator<Route> it = this.listIterator();
        ListIterator<Route> it1 = that.listIterator();
        while (it.hasNext()) {
            Route route = (Route) it.next();
            Route route1 = (Route) it1.next();
            if (!route.equals(route1))
                return false;
        }
        return true;
    }
}

