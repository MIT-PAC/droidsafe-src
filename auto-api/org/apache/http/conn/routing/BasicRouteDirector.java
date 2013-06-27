package org.apache.http.conn.routing;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class BasicRouteDirector implements HttpRouteDirector {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.404 -0400", hash_original_method = "AEF78390BB51E5E5DCB8CA44B8B94889", hash_generated_method = "AEF78390BB51E5E5DCB8CA44B8B94889")
    public BasicRouteDirector ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.409 -0400", hash_original_method = "2D52A8A1F4F510CECBAF7D127E816999", hash_generated_method = "5DF53E052F2ECE4E03A3045DE7841779")
    public int nextStep(RouteInfo plan, RouteInfo fact) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Planned route may not be null.");
        } //End block
        int step;
        step = UNREACHABLE;
        {
            boolean varDC3AF8859148F01EC170674A8EE05D51_892855490 = ((fact == null) || (fact.getHopCount() < 1));
            step = firstStep(plan);
            {
                boolean var6046D6BBF10C8FA378ECE56FA7490721_356420828 = (plan.getHopCount() > 1);
                step = proxiedStep(plan, fact);
                step = directStep(plan, fact);
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(plan.getTaint());
        addTaint(fact.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1866677697 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1866677697;
        // ---------- Original Method ----------
        //if (plan == null) {
            //throw new IllegalArgumentException
                //("Planned route may not be null.");
        //}
        //int step = UNREACHABLE;
        //if ((fact == null) || (fact.getHopCount() < 1))
            //step = firstStep(plan);
        //else if (plan.getHopCount() > 1)
            //step = proxiedStep(plan, fact);
        //else
            //step = directStep(plan, fact);
        //return step;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.410 -0400", hash_original_method = "966B65B53C96D6B72CF4916A6633605B", hash_generated_method = "E09BF9D7D64F5CF36AA0154B035839D5")
    protected int firstStep(RouteInfo plan) {
        {
            boolean var9ADDBF903DE9AB1D6EDE2F86CE7C529E_450910569 = ((plan.getHopCount() > 1));
        } //End flattened ternary
        addTaint(plan.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1310977593 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1310977593;
        // ---------- Original Method ----------
        //return (plan.getHopCount() > 1) ?
            //CONNECT_PROXY : CONNECT_TARGET;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.419 -0400", hash_original_method = "B25ACDEED75919F7360EB24551217719", hash_generated_method = "C64BEBAAB6635CECF72D5C216971FACE")
    protected int directStep(RouteInfo plan, RouteInfo fact) {
        {
            boolean varB66C84168A0A11E206DA97FC53EECE96_980207838 = (fact.getHopCount() > 1);
        } //End collapsed parenthetic
        {
            boolean var2095A840753C2371E56339B351F793C6_609410345 = (!plan.getTargetHost().equals(fact.getTargetHost()));
        } //End collapsed parenthetic
        {
            boolean var2F5D2B4DC814CD5AA57F6335D676F360_911068754 = (plan.isSecure() != fact.isSecure());
        } //End collapsed parenthetic
        {
            boolean varA6057D5451C00340B98B3FD151A1C736_357016659 = ((plan.getLocalAddress() != null) &&
            !plan.getLocalAddress().equals(fact.getLocalAddress()));
        } //End collapsed parenthetic
        addTaint(plan.getTaint());
        addTaint(fact.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_974128290 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_974128290;
        // ---------- Original Method ----------
        //if (fact.getHopCount() > 1)
            //return UNREACHABLE;
        //if (!plan.getTargetHost().equals(fact.getTargetHost()))
            //return UNREACHABLE;
        //if (plan.isSecure() != fact.isSecure())
            //return UNREACHABLE;
        //if ((plan.getLocalAddress() != null) &&
            //!plan.getLocalAddress().equals(fact.getLocalAddress())
            //)
            //return UNREACHABLE;
        //return COMPLETE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.425 -0400", hash_original_method = "DAD47A54D3A856226CAD2FBA5A8D36F7", hash_generated_method = "1144B57BC48471307724F9BBAE0F93E1")
    protected int proxiedStep(RouteInfo plan, RouteInfo fact) {
        {
            boolean var0C77C0B46B1BAF3E2E74D6F775BEA792_752428419 = (fact.getHopCount() <= 1);
        } //End collapsed parenthetic
        {
            boolean var2095A840753C2371E56339B351F793C6_349351125 = (!plan.getTargetHost().equals(fact.getTargetHost()));
        } //End collapsed parenthetic
        int phc;
        phc = plan.getHopCount();
        int fhc;
        fhc = fact.getHopCount();
        {
            int i;
            i = 0;
            {
                {
                    boolean varE461F5C2A178940FC85BAACCD10142E5_1631841569 = (!plan.getHopTarget(i).equals(fact.getHopTarget(i)));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCAE15B57EF69EEDF96317B8246AAF65E_556978686 = ((fact.isTunnelled() && !plan.isTunnelled()) ||
            (fact.isLayered()   && !plan.isLayered()));
        } //End collapsed parenthetic
        {
            boolean var57C09873B46E3C81C687C38273B9D183_2104146354 = (plan.isTunnelled() && !fact.isTunnelled());
        } //End collapsed parenthetic
        {
            boolean var21E9BF7F869C4A09A03DCCBEB9F4B6AA_1118902816 = (plan.isLayered() && !fact.isLayered());
        } //End collapsed parenthetic
        {
            boolean var2F5D2B4DC814CD5AA57F6335D676F360_318342511 = (plan.isSecure() != fact.isSecure());
        } //End collapsed parenthetic
        addTaint(plan.getTaint());
        addTaint(fact.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_530181459 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_530181459;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

