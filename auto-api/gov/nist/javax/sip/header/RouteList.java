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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.168 -0400", hash_original_method = "D139D7EC1148299A31F54E2FC8ABBD38", hash_generated_method = "740A4A8603D56CB0E3B664BFE94DAD13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RouteList() {
        super(Route.class, RouteHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.168 -0400", hash_original_method = "2F61955E2C85706175B79FB3D2D2F3C0", hash_generated_method = "5AE0F30B3979D3E892929A7CD224EB72")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        RouteList retval;
        retval = new RouteList();
        retval.clonehlist(this.hlist);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //RouteList retval = new RouteList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.168 -0400", hash_original_method = "48C7607E6836F35D30114914C241A09A", hash_generated_method = "CE3FD456F48DAED55342922195BCB124")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encode() {
        {
            boolean varD275F169E32BA3956D299AB16D2AE3E4_2078156230 = (super.hlist.isEmpty());
            String var6A2638D0C314CDCF29E6831D7360324B_652721119 = (super.encode());
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if ( super.hlist.isEmpty()) return "";
        //else return super.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.169 -0400", hash_original_method = "A0122B485E57B455599C6CF601D6C0DF", hash_generated_method = "896373C0017148E47A9C8580321473DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        RouteList that;
        that = (RouteList) other;
        {
            boolean varC5F003D93400649B46ACEC0E9A45D583_178015361 = (this.size() != that.size());
        } //End collapsed parenthetic
        ListIterator<Route> it;
        it = this.listIterator();
        ListIterator<Route> it1;
        it1 = that.listIterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_11580151 = (it.hasNext());
            {
                Route route;
                route = (Route) it.next();
                Route route1;
                route1 = (Route) it1.next();
                {
                    boolean var966AB6A44187E5CD2D0EE24CB80CC8A3_1745398450 = (!route.equals(route1));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    private static final long serialVersionUID = 3407603519354809748L;
}

