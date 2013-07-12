package org.apache.http.conn.routing;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class BasicRouteDirector implements HttpRouteDirector {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.461 -0400", hash_original_method = "AEF78390BB51E5E5DCB8CA44B8B94889", hash_generated_method = "AEF78390BB51E5E5DCB8CA44B8B94889")
    public BasicRouteDirector ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.463 -0400", hash_original_method = "2D52A8A1F4F510CECBAF7D127E816999", hash_generated_method = "AE96B334629636C10C12D729BC03ED76")
    public int nextStep(RouteInfo plan, RouteInfo fact) {
        addTaint(fact.getTaint());
        addTaint(plan.getTaint());
    if(plan == null)        
        {
            IllegalArgumentException varD18AAFD4D49E5C0AE7C21EBCCB2F15E3_161228701 = new IllegalArgumentException
                ("Planned route may not be null.");
            varD18AAFD4D49E5C0AE7C21EBCCB2F15E3_161228701.addTaint(taint);
            throw varD18AAFD4D49E5C0AE7C21EBCCB2F15E3_161228701;
        } //End block
        int step = UNREACHABLE;
    if((fact == null) || (fact.getHopCount() < 1))        
        step = firstStep(plan);
        else
    if(plan.getHopCount() > 1)        
        step = proxiedStep(plan, fact);
        else
        step = directStep(plan, fact);
        int var2764CA9D34E90313978D044F27AE433B_1409092420 = (step);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1978739048 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1978739048;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.463 -0400", hash_original_method = "966B65B53C96D6B72CF4916A6633605B", hash_generated_method = "4AC12214541757CAE131EFC9E6990D0B")
    protected int firstStep(RouteInfo plan) {
        addTaint(plan.getTaint());
        int var944F519AA24A9AB0CE12023A3FF4A30C_896728395 = ((plan.getHopCount() > 1) ?
            CONNECT_PROXY : CONNECT_TARGET);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_372684638 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_372684638;
        // ---------- Original Method ----------
        //return (plan.getHopCount() > 1) ?
            //CONNECT_PROXY : CONNECT_TARGET;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.464 -0400", hash_original_method = "B25ACDEED75919F7360EB24551217719", hash_generated_method = "362F4602D2CFAB2F358F80B4306EF5DB")
    protected int directStep(RouteInfo plan, RouteInfo fact) {
        addTaint(fact.getTaint());
        addTaint(plan.getTaint());
    if(fact.getHopCount() > 1)        
        {
        int var58FD3B3B1F27606728077423EB21D8D6_2011904519 = (UNREACHABLE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_393128986 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_393128986;
        }
    if(!plan.getTargetHost().equals(fact.getTargetHost()))        
        {
        int var58FD3B3B1F27606728077423EB21D8D6_1117182465 = (UNREACHABLE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1985563729 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1985563729;
        }
    if(plan.isSecure() != fact.isSecure())        
        {
        int var58FD3B3B1F27606728077423EB21D8D6_1138581083 = (UNREACHABLE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1484265185 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1484265185;
        }
    if((plan.getLocalAddress() != null) &&
            !plan.getLocalAddress().equals(fact.getLocalAddress()))        
        {
        int var58FD3B3B1F27606728077423EB21D8D6_250863503 = (UNREACHABLE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2049149049 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2049149049;
        }
        int var3DE44296982E58199AFC513A715B12BA_1677160235 = (COMPLETE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1659735599 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1659735599;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.465 -0400", hash_original_method = "DAD47A54D3A856226CAD2FBA5A8D36F7", hash_generated_method = "3C338E012F54B51990525DA27C05BDB6")
    protected int proxiedStep(RouteInfo plan, RouteInfo fact) {
        addTaint(fact.getTaint());
        addTaint(plan.getTaint());
    if(fact.getHopCount() <= 1)        
        {
        int var58FD3B3B1F27606728077423EB21D8D6_463225937 = (UNREACHABLE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_817306699 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_817306699;
        }
    if(!plan.getTargetHost().equals(fact.getTargetHost()))        
        {
        int var58FD3B3B1F27606728077423EB21D8D6_280775493 = (UNREACHABLE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1117668399 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1117668399;
        }
        final int phc = plan.getHopCount();
        final int fhc = fact.getHopCount();
    if(phc < fhc)        
        {
        int var58FD3B3B1F27606728077423EB21D8D6_1837722837 = (UNREACHABLE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1871970814 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1871970814;
        }
for(int i=0;i<fhc-1;i++)
        {
    if(!plan.getHopTarget(i).equals(fact.getHopTarget(i)))            
            {
            int var58FD3B3B1F27606728077423EB21D8D6_973984709 = (UNREACHABLE);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1332877938 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1332877938;
            }
        } //End block
    if(phc > fhc)        
        {
        int varBF531891E7568480D1039EF413BB779F_751516437 = (TUNNEL_PROXY);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1689331634 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1689331634;
        }
    if((fact.isTunnelled() && !plan.isTunnelled()) ||
            (fact.isLayered()   && !plan.isLayered()))        
        {
        int var58FD3B3B1F27606728077423EB21D8D6_2080180033 = (UNREACHABLE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1031268786 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1031268786;
        }
    if(plan.isTunnelled() && !fact.isTunnelled())        
        {
        int varF06A253D9F2F306E5723BDA6A76A8B25_555972311 = (TUNNEL_TARGET);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_160118153 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_160118153;
        }
    if(plan.isLayered() && !fact.isLayered())        
        {
        int var7F8125505602529376F2DAD8DB0E3E4C_1010012854 = (LAYER_PROTOCOL);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1942721844 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1942721844;
        }
    if(plan.isSecure() != fact.isSecure())        
        {
        int var58FD3B3B1F27606728077423EB21D8D6_1602675401 = (UNREACHABLE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1776212021 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1776212021;
        }
        int var3DE44296982E58199AFC513A715B12BA_1096403672 = (COMPLETE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1620213055 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1620213055;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

