package org.apache.http.conn.routing;

// Droidsafe Imports
import droidsafe.annotations.*;


public class BasicRouteDirector implements HttpRouteDirector {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.788 -0400", hash_original_method = "AEF78390BB51E5E5DCB8CA44B8B94889", hash_generated_method = "AEF78390BB51E5E5DCB8CA44B8B94889")
    public BasicRouteDirector ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.790 -0400", hash_original_method = "2D52A8A1F4F510CECBAF7D127E816999", hash_generated_method = "DD5AFA38DD0547CB7400AC6059E28E5D")
    public int nextStep(RouteInfo plan, RouteInfo fact) {
        addTaint(fact.getTaint());
        addTaint(plan.getTaint());
        if(plan == null)        
        {
            IllegalArgumentException varD18AAFD4D49E5C0AE7C21EBCCB2F15E3_70110829 = new IllegalArgumentException
                ("Planned route may not be null.");
            varD18AAFD4D49E5C0AE7C21EBCCB2F15E3_70110829.addTaint(taint);
            throw varD18AAFD4D49E5C0AE7C21EBCCB2F15E3_70110829;
        } //End block
        int step = UNREACHABLE;
        if((fact == null) || (fact.getHopCount() < 1))        
        step = firstStep(plan);
        else
        if(plan.getHopCount() > 1)        
        step = proxiedStep(plan, fact);
        else
        step = directStep(plan, fact);
        int var2764CA9D34E90313978D044F27AE433B_1006008986 = (step);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2001328391 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2001328391;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.790 -0400", hash_original_method = "966B65B53C96D6B72CF4916A6633605B", hash_generated_method = "CE9FCAB79AB495B21E65B93EEA9F5749")
    protected int firstStep(RouteInfo plan) {
        addTaint(plan.getTaint());
        int var944F519AA24A9AB0CE12023A3FF4A30C_1837761842 = ((plan.getHopCount() > 1) ?
            CONNECT_PROXY : CONNECT_TARGET);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_944376344 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_944376344;
        // ---------- Original Method ----------
        //return (plan.getHopCount() > 1) ?
            //CONNECT_PROXY : CONNECT_TARGET;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.791 -0400", hash_original_method = "B25ACDEED75919F7360EB24551217719", hash_generated_method = "DC93C6182126897F7A16AF7CCD103CF9")
    protected int directStep(RouteInfo plan, RouteInfo fact) {
        addTaint(fact.getTaint());
        addTaint(plan.getTaint());
        if(fact.getHopCount() > 1)        
        {
        int var58FD3B3B1F27606728077423EB21D8D6_1462990744 = (UNREACHABLE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1953777246 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1953777246;
        }
        if(!plan.getTargetHost().equals(fact.getTargetHost()))        
        {
        int var58FD3B3B1F27606728077423EB21D8D6_1979629798 = (UNREACHABLE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1757535176 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1757535176;
        }
        if(plan.isSecure() != fact.isSecure())        
        {
        int var58FD3B3B1F27606728077423EB21D8D6_1773946521 = (UNREACHABLE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1358854807 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1358854807;
        }
        if((plan.getLocalAddress() != null) &&
            !plan.getLocalAddress().equals(fact.getLocalAddress()))        
        {
        int var58FD3B3B1F27606728077423EB21D8D6_120502339 = (UNREACHABLE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1680879086 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1680879086;
        }
        int var3DE44296982E58199AFC513A715B12BA_147095337 = (COMPLETE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_937287137 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_937287137;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.792 -0400", hash_original_method = "DAD47A54D3A856226CAD2FBA5A8D36F7", hash_generated_method = "3A1F82BA4D189E06CEC903CB93A2FDD4")
    protected int proxiedStep(RouteInfo plan, RouteInfo fact) {
        addTaint(fact.getTaint());
        addTaint(plan.getTaint());
        if(fact.getHopCount() <= 1)        
        {
        int var58FD3B3B1F27606728077423EB21D8D6_261536747 = (UNREACHABLE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1524772674 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1524772674;
        }
        if(!plan.getTargetHost().equals(fact.getTargetHost()))        
        {
        int var58FD3B3B1F27606728077423EB21D8D6_629029397 = (UNREACHABLE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1835943520 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1835943520;
        }
        final int phc = plan.getHopCount();
        final int fhc = fact.getHopCount();
        if(phc < fhc)        
        {
        int var58FD3B3B1F27606728077423EB21D8D6_909737605 = (UNREACHABLE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1091082154 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1091082154;
        }
for(int i=0;i<fhc-1;i++)
        {
            if(!plan.getHopTarget(i).equals(fact.getHopTarget(i)))            
            {
            int var58FD3B3B1F27606728077423EB21D8D6_2085687109 = (UNREACHABLE);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_156711148 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_156711148;
            }
        } //End block
        if(phc > fhc)        
        {
        int varBF531891E7568480D1039EF413BB779F_149074214 = (TUNNEL_PROXY);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2014209755 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2014209755;
        }
        if((fact.isTunnelled() && !plan.isTunnelled()) ||
            (fact.isLayered()   && !plan.isLayered()))        
        {
        int var58FD3B3B1F27606728077423EB21D8D6_142467276 = (UNREACHABLE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_790194492 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_790194492;
        }
        if(plan.isTunnelled() && !fact.isTunnelled())        
        {
        int varF06A253D9F2F306E5723BDA6A76A8B25_1197816350 = (TUNNEL_TARGET);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1428613494 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1428613494;
        }
        if(plan.isLayered() && !fact.isLayered())        
        {
        int var7F8125505602529376F2DAD8DB0E3E4C_1549057390 = (LAYER_PROTOCOL);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_206341137 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_206341137;
        }
        if(plan.isSecure() != fact.isSecure())        
        {
        int var58FD3B3B1F27606728077423EB21D8D6_1086181147 = (UNREACHABLE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1266841531 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1266841531;
        }
        int var3DE44296982E58199AFC513A715B12BA_1592743838 = (COMPLETE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1048957186 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1048957186;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

