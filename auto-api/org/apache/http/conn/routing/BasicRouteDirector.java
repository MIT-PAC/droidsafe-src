package org.apache.http.conn.routing;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class BasicRouteDirector implements HttpRouteDirector {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.346 -0400", hash_original_method = "AEF78390BB51E5E5DCB8CA44B8B94889", hash_generated_method = "AEF78390BB51E5E5DCB8CA44B8B94889")
    public BasicRouteDirector ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.347 -0400", hash_original_method = "2D52A8A1F4F510CECBAF7D127E816999", hash_generated_method = "11BCBD2077A292A2F682131D31390F89")
    public int nextStep(RouteInfo plan, RouteInfo fact) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Planned route may not be null.");
        } //End block
        int step;
        step = UNREACHABLE;
        {
            boolean varDC3AF8859148F01EC170674A8EE05D51_857953592 = ((fact == null) || (fact.getHopCount() < 1));
            step = firstStep(plan);
            {
                boolean var6046D6BBF10C8FA378ECE56FA7490721_1049027948 = (plan.getHopCount() > 1);
                step = proxiedStep(plan, fact);
                step = directStep(plan, fact);
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(plan.getTaint());
        addTaint(fact.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_530935239 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_530935239;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.348 -0400", hash_original_method = "966B65B53C96D6B72CF4916A6633605B", hash_generated_method = "507D9C45DB60B486F40F0A91B5B2F98C")
    protected int firstStep(RouteInfo plan) {
        {
            boolean var9ADDBF903DE9AB1D6EDE2F86CE7C529E_1262226524 = ((plan.getHopCount() > 1));
        } //End flattened ternary
        addTaint(plan.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_998566684 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_998566684;
        // ---------- Original Method ----------
        //return (plan.getHopCount() > 1) ?
            //CONNECT_PROXY : CONNECT_TARGET;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.357 -0400", hash_original_method = "B25ACDEED75919F7360EB24551217719", hash_generated_method = "53E0F3AD4CA14FE25D0A34DAF95828C4")
    protected int directStep(RouteInfo plan, RouteInfo fact) {
        {
            boolean varB66C84168A0A11E206DA97FC53EECE96_1867222282 = (fact.getHopCount() > 1);
        } //End collapsed parenthetic
        {
            boolean var2095A840753C2371E56339B351F793C6_1859419416 = (!plan.getTargetHost().equals(fact.getTargetHost()));
        } //End collapsed parenthetic
        {
            boolean var2F5D2B4DC814CD5AA57F6335D676F360_1274984353 = (plan.isSecure() != fact.isSecure());
        } //End collapsed parenthetic
        {
            boolean varA6057D5451C00340B98B3FD151A1C736_282489467 = ((plan.getLocalAddress() != null) &&
            !plan.getLocalAddress().equals(fact.getLocalAddress()));
        } //End collapsed parenthetic
        addTaint(plan.getTaint());
        addTaint(fact.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1937768429 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1937768429;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.372 -0400", hash_original_method = "DAD47A54D3A856226CAD2FBA5A8D36F7", hash_generated_method = "00C78BE4DD8D3B785EE714DCB45C9D00")
    protected int proxiedStep(RouteInfo plan, RouteInfo fact) {
        {
            boolean var0C77C0B46B1BAF3E2E74D6F775BEA792_275663710 = (fact.getHopCount() <= 1);
        } //End collapsed parenthetic
        {
            boolean var2095A840753C2371E56339B351F793C6_2059191738 = (!plan.getTargetHost().equals(fact.getTargetHost()));
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
                    boolean varE461F5C2A178940FC85BAACCD10142E5_1551217516 = (!plan.getHopTarget(i).equals(fact.getHopTarget(i)));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCAE15B57EF69EEDF96317B8246AAF65E_115457475 = ((fact.isTunnelled() && !plan.isTunnelled()) ||
            (fact.isLayered()   && !plan.isLayered()));
        } //End collapsed parenthetic
        {
            boolean var57C09873B46E3C81C687C38273B9D183_655925373 = (plan.isTunnelled() && !fact.isTunnelled());
        } //End collapsed parenthetic
        {
            boolean var21E9BF7F869C4A09A03DCCBEB9F4B6AA_2035304078 = (plan.isLayered() && !fact.isLayered());
        } //End collapsed parenthetic
        {
            boolean var2F5D2B4DC814CD5AA57F6335D676F360_1597128800 = (plan.isSecure() != fact.isSecure());
        } //End collapsed parenthetic
        addTaint(plan.getTaint());
        addTaint(fact.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_696564134 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_696564134;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

