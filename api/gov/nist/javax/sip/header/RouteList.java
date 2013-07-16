package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.header.*;
import java.util.*;

public class RouteList extends SIPHeaderList<Route> {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.952 -0400", hash_original_method = "D139D7EC1148299A31F54E2FC8ABBD38", hash_generated_method = "740A4A8603D56CB0E3B664BFE94DAD13")
    public  RouteList() {
        super(Route.class, RouteHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.953 -0400", hash_original_method = "2F61955E2C85706175B79FB3D2D2F3C0", hash_generated_method = "E60595335F48FBD842A1848DC368E2EA")
    public Object clone() {
        RouteList retval = new RouteList();
        retval.clonehlist(this.hlist);
Object varF9E19AD6135C970F387F77C6F3DE4477_436543702 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_436543702.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_436543702;
        // ---------- Original Method ----------
        //RouteList retval = new RouteList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.953 -0400", hash_original_method = "48C7607E6836F35D30114914C241A09A", hash_generated_method = "25FF13FC18D2BC26D3C0C3DEA67DBC6A")
    public String encode() {
    if(super.hlist.isEmpty())        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1755024228 =         "";
        var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1755024228.addTaint(taint);
        return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1755024228;
        }
        else
        {
String var0F81406E787DA37C7E2A213EE826C72B_1109398079 =         super.encode();
        var0F81406E787DA37C7E2A213EE826C72B_1109398079.addTaint(taint);
        return var0F81406E787DA37C7E2A213EE826C72B_1109398079;
        }
        // ---------- Original Method ----------
        //if ( super.hlist.isEmpty()) return "";
        //else return super.encode();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.954 -0400", hash_original_method = "A0122B485E57B455599C6CF601D6C0DF", hash_generated_method = "D1AFADA48B49E99C67E8D48BE74A2E3D")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(!(other instanceof RouteList))        
        {
        boolean var68934A3E9455FA72420237EB05902327_929183578 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_347845918 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_347845918;
        }
        RouteList that = (RouteList) other;
    if(this.size() != that.size())        
        {
        boolean var68934A3E9455FA72420237EB05902327_147428413 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_170435130 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_170435130;
        }
        ListIterator<Route> it = this.listIterator();
        ListIterator<Route> it1 = that.listIterator();
        while
(it.hasNext())        
        {
            Route route = (Route) it.next();
            Route route1 = (Route) it1.next();
    if(!route.equals(route1))            
            {
            boolean var68934A3E9455FA72420237EB05902327_1465441311 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1190966432 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1190966432;
            }
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_795882954 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_92009679 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_92009679;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.954 -0400", hash_original_field = "D7AAF440428FA150F77B1E439C3B1197", hash_generated_field = "E9DB318843918A7C1284240E819CF95B")

    private static final long serialVersionUID = 3407603519354809748L;
}

