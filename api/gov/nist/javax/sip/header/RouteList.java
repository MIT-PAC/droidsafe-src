package gov.nist.javax.sip.header;

// Droidsafe Imports
import java.util.ListIterator;

import javax.sip.header.RouteHeader;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class RouteList extends SIPHeaderList<Route> {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.985 -0400", hash_original_method = "D139D7EC1148299A31F54E2FC8ABBD38", hash_generated_method = "740A4A8603D56CB0E3B664BFE94DAD13")
    public  RouteList() {
        super(Route.class, RouteHeader.NAME);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.985 -0400", hash_original_method = "2F61955E2C85706175B79FB3D2D2F3C0", hash_generated_method = "317A120C26D2C9FF471DAE91CD7FCD2D")
    public Object clone() {
        RouteList retval = new RouteList();
        retval.clonehlist(this.hlist);
Object varF9E19AD6135C970F387F77C6F3DE4477_1875551968 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1875551968.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1875551968;
        // ---------- Original Method ----------
        //RouteList retval = new RouteList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.986 -0400", hash_original_method = "48C7607E6836F35D30114914C241A09A", hash_generated_method = "DC6A7B77811D7583BB89887B4A4AA5E0")
    public String encode() {
        if(super.hlist.isEmpty())        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_343172108 =         "";
        var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_343172108.addTaint(taint);
        return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_343172108;
        }
        else
        {
String var0F81406E787DA37C7E2A213EE826C72B_1647800159 =         super.encode();
        var0F81406E787DA37C7E2A213EE826C72B_1647800159.addTaint(taint);
        return var0F81406E787DA37C7E2A213EE826C72B_1647800159;
        }
        // ---------- Original Method ----------
        //if ( super.hlist.isEmpty()) return "";
        //else return super.encode();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.987 -0400", hash_original_method = "A0122B485E57B455599C6CF601D6C0DF", hash_generated_method = "47B9DF79F3FD43AB7BF99E58B8CBC0DB")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        if(!(other instanceof RouteList))        
        {
        boolean var68934A3E9455FA72420237EB05902327_191876281 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2035564894 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2035564894;
        }
        RouteList that = (RouteList) other;
        if(this.size() != that.size())        
        {
        boolean var68934A3E9455FA72420237EB05902327_1412337121 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1863474112 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1863474112;
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
            boolean var68934A3E9455FA72420237EB05902327_263674506 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_902190338 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_902190338;
            }
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1804326159 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1323027758 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1323027758;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.987 -0400", hash_original_field = "D7AAF440428FA150F77B1E439C3B1197", hash_generated_field = "E9DB318843918A7C1284240E819CF95B")

    private static final long serialVersionUID = 3407603519354809748L;
}

