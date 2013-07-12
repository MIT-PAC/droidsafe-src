package gov.nist.javax.sip.stack;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.message.*;
import gov.nist.javax.sip.address.*;
import gov.nist.javax.sip.header.*;
import gov.nist.javax.sip.*;
import gov.nist.core.*;
import gov.nist.core.net.AddressResolver;
import javax.sip.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import javax.sip.header.RouteHeader;
import javax.sip.header.ViaHeader;
import javax.sip.message.*;
import javax.sip.address.*;

public class DefaultRouter implements Router {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.407 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "B028268F85C87F49A0E45B93954BF938")

    private SipStackImpl sipStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.407 -0400", hash_original_field = "F35E88995B01DD639351EFA9D1C5FAAA", hash_generated_field = "EB3744EEB0666E12CFAB5865A55F554C")

    private Hop defaultRoute;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.408 -0400", hash_original_method = "1E8D5551C1C844D291A6EDC5BD70E069", hash_generated_method = "8B9D0899EFA10ABEE473358BCF33303F")
    private  DefaultRouter() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.409 -0400", hash_original_method = "0186412A42AE3A0076B8DB4250031F53", hash_generated_method = "4D64756E5CD8C2A1884EACDB2A802A85")
    public  DefaultRouter(SipStack sipStack, String defaultRoute) {
        this.sipStack = (SipStackImpl) sipStack;
    if(defaultRoute != null)        
        {
            try 
            {
                this.defaultRoute = (Hop) this.sipStack.getAddressResolver()
                        .resolveAddress((Hop) (new HopImpl(defaultRoute)));
            } 
            catch (IllegalArgumentException ex)
            {
                ((SIPTransactionStack) sipStack)
                        .getStackLogger()
                        .logError(
                                "Invalid default route specification - need host:port/transport");
                ex.addTaint(taint);
                throw ex;
            } 
        } 
        
        
        
            
                
                        
            
                
                        
                        
                                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.411 -0400", hash_original_method = "5920A86ACDD933EC7CFC2B95A34FE620", hash_generated_method = "42AB5B38E31E7C58B261E8D8BB62570E")
    public Hop getNextHop(Request request) throws SipException {
        addTaint(request.getTaint());
        SIPRequest sipRequest = (SIPRequest) request;
        RequestLine requestLine = sipRequest.getRequestLine();
    if(requestLine == null)        
        {
Hop var7C3D9107A1BB6CCC233CC962C791CA18_735859892 =             defaultRoute;
            var7C3D9107A1BB6CCC233CC962C791CA18_735859892.addTaint(taint);
            return var7C3D9107A1BB6CCC233CC962C791CA18_735859892;
        } 
        javax.sip.address.URI requestURI = requestLine.getUri();
    if(requestURI == null)        
        {
        IllegalArgumentException var42845BE86469A3107A3A8086513D244C_697697608 = new IllegalArgumentException("Bad message: Null requestURI");
        var42845BE86469A3107A3A8086513D244C_697697608.addTaint(taint);
        throw var42845BE86469A3107A3A8086513D244C_697697608;
        }
        RouteList routes = sipRequest.getRouteHeaders();
    if(routes != null)        
        {
            Route route = (Route) routes.getFirst();
            URI uri = route.getAddress().getURI();
    if(uri.isSipURI())            
            {
                SipURI sipUri = (SipURI) uri;
    if(!sipUri.hasLrParam())                
                {
                    fixStrictRouting(sipRequest);
    if(sipStack.isLoggingEnabled())                    
                    sipStack.getStackLogger()
                                .logDebug("Route post processing fixed strict routing");
                } 
                Hop hop = createHop(sipUri,request);
    if(sipStack.isLoggingEnabled())                
                sipStack.getStackLogger()
                            .logDebug("NextHop based on Route:" + hop);
Hop varCF598A87F121766CA237EE82036D5763_471176525 =                 hop;
                varCF598A87F121766CA237EE82036D5763_471176525.addTaint(taint);
                return varCF598A87F121766CA237EE82036D5763_471176525;
            } 
            else
            {
                SipException varF581249094E58B797A880CDDFBC80E70_547484095 = new SipException("First Route not a SIP URI");
                varF581249094E58B797A880CDDFBC80E70_547484095.addTaint(taint);
                throw varF581249094E58B797A880CDDFBC80E70_547484095;
            } 
        } 
        else
    if(requestURI.isSipURI()
                && ((SipURI) requestURI).getMAddrParam() != null)        
        {
            Hop hop = createHop((SipURI) requestURI,request);
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger()
                        .logDebug("Using request URI maddr to route the request = "
                                + hop.toString());
Hop varCF598A87F121766CA237EE82036D5763_1599305194 =             hop;
            varCF598A87F121766CA237EE82036D5763_1599305194.addTaint(taint);
            return varCF598A87F121766CA237EE82036D5763_1599305194;
        } 
        else
    if(defaultRoute != null)        
        {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger()
                        .logDebug("Using outbound proxy to route the request = "
                                + defaultRoute.toString());
Hop var7C3D9107A1BB6CCC233CC962C791CA18_1244361738 =             defaultRoute;
            var7C3D9107A1BB6CCC233CC962C791CA18_1244361738.addTaint(taint);
            return var7C3D9107A1BB6CCC233CC962C791CA18_1244361738;
        } 
        else
    if(requestURI.isSipURI())        
        {
            Hop hop = createHop((SipURI) requestURI,request);
    if(hop != null && sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logDebug("Used request-URI for nextHop = "
                        + hop.toString());
            else
    if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger()
                        .logDebug("returning null hop -- loop detected");
            } 
Hop varCF598A87F121766CA237EE82036D5763_2069249668 =             hop;
            varCF598A87F121766CA237EE82036D5763_2069249668.addTaint(taint);
            return varCF598A87F121766CA237EE82036D5763_2069249668;
        } 
        else
        {
            InternalErrorHandler.handleException("Unexpected non-sip URI",
                    this.sipStack.getStackLogger());
Hop var540C13E9E156B687226421B24F2DF178_1321341416 =             null;
            var540C13E9E156B687226421B24F2DF178_1321341416.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1321341416;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.415 -0400", hash_original_method = "F98ABD2EA2392557384972BDB7FAD5AD", hash_generated_method = "CCCEB65ED8C3986E9BC1D4BBCEE4CB85")
    public void fixStrictRouting(SIPRequest req) {
        addTaint(req.getTaint());
        RouteList routes = req.getRouteHeaders();
        Route first = (Route) routes.getFirst();
        SipUri firstUri = (SipUri) first.getAddress().getURI();
        routes.removeFirst();
        AddressImpl addr = new AddressImpl();
        addr.setAddess(req.getRequestURI());
        Route route = new Route(addr);
        routes.add(route);
        req.setRequestURI(firstUri);
    if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug("post: fixStrictRouting" + req);
        } 
        
        
        
        
        
        
        
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.417 -0400", hash_original_method = "1A8C9A0DF77761777787B14E70DB6165", hash_generated_method = "9965ABBDBA48243E81E71B7307AD254C")
    private final Hop createHop(SipURI sipUri, Request request) {
        addTaint(request.getTaint());
        addTaint(sipUri.getTaint());
        String transport = sipUri.isSecure() ? SIPConstants.TLS : sipUri
                .getTransportParam();
    if(transport == null)        
        {
            ViaHeader via = (ViaHeader) request.getHeader(ViaHeader.NAME);
            transport = via.getTransport();
        } 
        int port;
    if(sipUri.getPort() != -1)        
        {
            port = sipUri.getPort();
        } 
        else
        {
    if(transport.equalsIgnoreCase(SIPConstants.TLS))            
            port = 5061;
            else
            port = 5060;
        } 
        String host = sipUri.getMAddrParam() != null ? sipUri.getMAddrParam()
                : sipUri.getHost();
        AddressResolver addressResolver = this.sipStack.getAddressResolver();
Hop var65DBDE1B68EBAE1D8996367F5504793F_1122010583 =         addressResolver
                .resolveAddress(new HopImpl(host, port, transport));
        var65DBDE1B68EBAE1D8996367F5504793F_1122010583.addTaint(taint);
        return var65DBDE1B68EBAE1D8996367F5504793F_1122010583;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.418 -0400", hash_original_method = "4C71B768C5A06ACD6891DA2692157012", hash_generated_method = "0DD18B7568666651288BE099106B1FC2")
    public javax.sip.address.Hop getOutboundProxy() {
javax.sip.address.Hop varF8E8BFFE70D4C82F135420B297CB0572_695786099 =         this.defaultRoute;
        varF8E8BFFE70D4C82F135420B297CB0572_695786099.addTaint(taint);
        return varF8E8BFFE70D4C82F135420B297CB0572_695786099;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.419 -0400", hash_original_method = "C9341668DF04FCD8B03458AAEB056098", hash_generated_method = "BEFF587FFA9EA1B4E8126F524E58D06C")
    public ListIterator getNextHops(Request request) {
        addTaint(request.getTaint());
        try 
        {
            LinkedList llist = new LinkedList();
            llist.add(this.getNextHop(request));
ListIterator var20F8225C0A6BB17E1A7F99EEDC8CFDB8_1623850426 =             llist.listIterator();
            var20F8225C0A6BB17E1A7F99EEDC8CFDB8_1623850426.addTaint(taint);
            return var20F8225C0A6BB17E1A7F99EEDC8CFDB8_1623850426;
        } 
        catch (SipException ex)
        {
ListIterator var540C13E9E156B687226421B24F2DF178_1682092073 =             null;
            var540C13E9E156B687226421B24F2DF178_1682092073.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1682092073;
        } 
        
        
            
            
            
        
            
        
    }

    
}

