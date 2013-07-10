package org.apache.http.conn.routing;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class BasicRouteDirector implements HttpRouteDirector {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.107 -0400", hash_original_method = "AEF78390BB51E5E5DCB8CA44B8B94889", hash_generated_method = "AEF78390BB51E5E5DCB8CA44B8B94889")
    public BasicRouteDirector ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.108 -0400", hash_original_method = "2D52A8A1F4F510CECBAF7D127E816999", hash_generated_method = "CBD26D137086F8F212F8F00EFD4A089B")
    public int nextStep(RouteInfo plan, RouteInfo fact) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Planned route may not be null.");
        } 
        int step = UNREACHABLE;
        {
            boolean varDC3AF8859148F01EC170674A8EE05D51_1141302470 = ((fact == null) || (fact.getHopCount() < 1));
            step = firstStep(plan);
            {
                boolean var6046D6BBF10C8FA378ECE56FA7490721_1955263563 = (plan.getHopCount() > 1);
                step = proxiedStep(plan, fact);
                step = directStep(plan, fact);
            } 
        } 
        addTaint(plan.getTaint());
        addTaint(fact.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1101506497 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1101506497;
        
        
            
                
        
        
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.109 -0400", hash_original_method = "966B65B53C96D6B72CF4916A6633605B", hash_generated_method = "2998365C48B8C7E8312A6EA0E55D2D4D")
    protected int firstStep(RouteInfo plan) {
        {
            boolean var9ADDBF903DE9AB1D6EDE2F86CE7C529E_210206520 = ((plan.getHopCount() > 1));
        } 
        addTaint(plan.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_993153974 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_993153974;
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.109 -0400", hash_original_method = "B25ACDEED75919F7360EB24551217719", hash_generated_method = "CB01034D3D2EB811DD53D387CAEEAAC0")
    protected int directStep(RouteInfo plan, RouteInfo fact) {
        {
            boolean varB66C84168A0A11E206DA97FC53EECE96_1195363202 = (fact.getHopCount() > 1);
        } 
        {
            boolean var2095A840753C2371E56339B351F793C6_207926992 = (!plan.getTargetHost().equals(fact.getTargetHost()));
        } 
        {
            boolean var2F5D2B4DC814CD5AA57F6335D676F360_642281353 = (plan.isSecure() != fact.isSecure());
        } 
        {
            boolean varA6057D5451C00340B98B3FD151A1C736_63140282 = ((plan.getLocalAddress() != null) &&
            !plan.getLocalAddress().equals(fact.getLocalAddress()));
        } 
        addTaint(plan.getTaint());
        addTaint(fact.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1238061603 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1238061603;
        
        
            
        
            
        
            
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.110 -0400", hash_original_method = "DAD47A54D3A856226CAD2FBA5A8D36F7", hash_generated_method = "0CF3261390F78E4237940527535B6669")
    protected int proxiedStep(RouteInfo plan, RouteInfo fact) {
        {
            boolean var0C77C0B46B1BAF3E2E74D6F775BEA792_367499168 = (fact.getHopCount() <= 1);
        } 
        {
            boolean var2095A840753C2371E56339B351F793C6_696389501 = (!plan.getTargetHost().equals(fact.getTargetHost()));
        } 
        final int phc = plan.getHopCount();
        final int fhc = fact.getHopCount();
        {
            int i = 0;
            {
                {
                    boolean varE461F5C2A178940FC85BAACCD10142E5_1048327454 = (!plan.getHopTarget(i).equals(fact.getHopTarget(i)));
                } 
            } 
        } 
        {
            boolean varCAE15B57EF69EEDF96317B8246AAF65E_1636432734 = ((fact.isTunnelled() && !plan.isTunnelled()) ||
            (fact.isLayered()   && !plan.isLayered()));
        } 
        {
            boolean var57C09873B46E3C81C687C38273B9D183_1366886408 = (plan.isTunnelled() && !fact.isTunnelled());
        } 
        {
            boolean var21E9BF7F869C4A09A03DCCBEB9F4B6AA_1860840896 = (plan.isLayered() && !fact.isLayered());
        } 
        {
            boolean var2F5D2B4DC814CD5AA57F6335D676F360_1673254865 = (plan.isSecure() != fact.isSecure());
        } 
        addTaint(plan.getTaint());
        addTaint(fact.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1160074302 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1160074302;
        
        
    }

    
}

