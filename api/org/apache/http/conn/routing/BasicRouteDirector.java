package org.apache.http.conn.routing;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class BasicRouteDirector implements HttpRouteDirector {
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.788 -0400", hash_original_method = "AEF78390BB51E5E5DCB8CA44B8B94889", hash_generated_method = "AEF78390BB51E5E5DCB8CA44B8B94889")
    public BasicRouteDirector ()
    {
        //Synthesized constructor
    }

    // public default constructor

    /**
     * Provides the next step.
     *
     * @param plan      the planned route
     * @param fact      the currently established route, or
     *                  <code>null</code> if nothing is established
     *
     * @return  one of the constants defined in this class, indicating
     *          either the next step to perform, or success, or failure.
     *          0 is for success, a negative value for failure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:29.454 -0500", hash_original_method = "2D52A8A1F4F510CECBAF7D127E816999", hash_generated_method = "26F2E23187C893BF0787312C4C13EB3C")
    
public int nextStep(RouteInfo plan, RouteInfo fact) {
        if (plan == null) {
            throw new IllegalArgumentException
                ("Planned route may not be null.");
        }

        int step = UNREACHABLE;

        if ((fact == null) || (fact.getHopCount() < 1))
            step = firstStep(plan);
        else if (plan.getHopCount() > 1)
            step = proxiedStep(plan, fact);
        else
            step = directStep(plan, fact);

        return step;

    } // nextStep

    /**
     * Determines the first step to establish a route.
     *
     * @param plan      the planned route
     *
     * @return  the first step
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:29.456 -0500", hash_original_method = "966B65B53C96D6B72CF4916A6633605B", hash_generated_method = "14941E50CB5A9E94D25F3080C1DB0C47")
    
protected int firstStep(RouteInfo plan) {

        return (plan.getHopCount() > 1) ?
            CONNECT_PROXY : CONNECT_TARGET;
    }

    /**
     * Determines the next step to establish a direct connection.
     *
     * @param plan      the planned route
     * @param fact      the currently established route
     *
     * @return  one of the constants defined in this class, indicating
     *          either the next step to perform, or success, or failure
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:29.459 -0500", hash_original_method = "B25ACDEED75919F7360EB24551217719", hash_generated_method = "E15A0CD48C48D7E5F888C2EED5CC1A6D")
    
protected int directStep(RouteInfo plan, RouteInfo fact) {

        if (fact.getHopCount() > 1)
            return UNREACHABLE;
        if (!plan.getTargetHost().equals(fact.getTargetHost()))
            return UNREACHABLE;
        // If the security is too low, we could now suggest to layer
        // a secure protocol on the direct connection. Layering on direct
        // connections has not been supported in HttpClient 3.x, we don't
        // consider it here until there is a real-life use case for it.

        // Should we tolerate if security is better than planned?
        // (plan.isSecure() && !fact.isSecure())
        if (plan.isSecure() != fact.isSecure())
            return UNREACHABLE;

        // Local address has to match only if the plan specifies one.
        if ((plan.getLocalAddress() != null) &&
            !plan.getLocalAddress().equals(fact.getLocalAddress())
            )
            return UNREACHABLE;

        return COMPLETE;
    }

    /**
     * Determines the next step to establish a connection via proxy.
     *
     * @param plan      the planned route
     * @param fact      the currently established route
     *
     * @return  one of the constants defined in this class, indicating
     *          either the next step to perform, or success, or failure
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:29.461 -0500", hash_original_method = "DAD47A54D3A856226CAD2FBA5A8D36F7", hash_generated_method = "AD499F2ECD39B002F58477D70DEC1000")
    
protected int proxiedStep(RouteInfo plan, RouteInfo fact) {

        if (fact.getHopCount() <= 1)
            return UNREACHABLE;
        if (!plan.getTargetHost().equals(fact.getTargetHost()))
            return UNREACHABLE;
        final int phc = plan.getHopCount();
        final int fhc = fact.getHopCount();
        if (phc < fhc)
            return UNREACHABLE;

        for (int i=0; i<fhc-1; i++) {
            if (!plan.getHopTarget(i).equals(fact.getHopTarget(i)))
                return UNREACHABLE;
        }
        // now we know that the target matches and proxies so far are the same
        if (phc > fhc)
            return TUNNEL_PROXY; // need to extend the proxy chain
            
        // proxy chain and target are the same, check tunnelling and layering
        if ((fact.isTunnelled() && !plan.isTunnelled()) ||
            (fact.isLayered()   && !plan.isLayered()))
            return UNREACHABLE;

        if (plan.isTunnelled() && !fact.isTunnelled())
            return TUNNEL_TARGET;
        if (plan.isLayered() && !fact.isLayered())
            return LAYER_PROTOCOL;

        // tunnel and layering are the same, remains to check the security
        // Should we tolerate if security is better than planned?
        // (plan.isSecure() && !fact.isSecure())
        if (plan.isSecure() != fact.isSecure())
            return UNREACHABLE;

        return COMPLETE;
    }
    
}

