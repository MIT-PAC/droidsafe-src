package gov.nist.javax.sip.stack;

// Droidsafe Imports
import gov.nist.core.InternalErrorHandler;
import gov.nist.core.net.AddressResolver;
import gov.nist.javax.sip.SIPConstants;
import gov.nist.javax.sip.SipStackImpl;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.address.SipUri;
import gov.nist.javax.sip.header.RequestLine;
import gov.nist.javax.sip.header.Route;
import gov.nist.javax.sip.header.RouteList;
import gov.nist.javax.sip.message.SIPRequest;

import java.util.LinkedList;
import java.util.ListIterator;

import javax.sip.SipException;
import javax.sip.SipStack;
import javax.sip.address.Hop;
import javax.sip.address.Router;
import javax.sip.address.SipURI;
import javax.sip.address.URI;
import javax.sip.header.ViaHeader;
import javax.sip.message.Request;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class DefaultRouter implements Router {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.245 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "B028268F85C87F49A0E45B93954BF938")

    private SipStackImpl sipStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.245 -0400", hash_original_field = "F35E88995B01DD639351EFA9D1C5FAAA", hash_generated_field = "EB3744EEB0666E12CFAB5865A55F554C")

    private Hop defaultRoute;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.245 -0400", hash_original_method = "1E8D5551C1C844D291A6EDC5BD70E069", hash_generated_method = "8B9D0899EFA10ABEE473358BCF33303F")
    private  DefaultRouter() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.246 -0400", hash_original_method = "0186412A42AE3A0076B8DB4250031F53", hash_generated_method = "4D64756E5CD8C2A1884EACDB2A802A85")
    public  DefaultRouter(SipStack sipStack, String defaultRoute) {
        this.sipStack = (SipStackImpl) sipStack;
        if(defaultRoute != null)        
        {
            try 
            {
                this.defaultRoute = (Hop) this.sipStack.getAddressResolver()
                        .resolveAddress((Hop) (new HopImpl(defaultRoute)));
            } //End block
            catch (IllegalArgumentException ex)
            {
                ((SIPTransactionStack) sipStack)
                        .getStackLogger()
                        .logError(
                                "Invalid default route specification - need host:port/transport");
                ex.addTaint(taint);
                throw ex;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //this.sipStack = (SipStackImpl) sipStack;
        //if (defaultRoute != null) {
            //try {
                //this.defaultRoute = (Hop) this.sipStack.getAddressResolver()
                        //.resolveAddress((Hop) (new HopImpl(defaultRoute)));
            //} catch (IllegalArgumentException ex) {
                //((SIPTransactionStack) sipStack)
                        //.getStackLogger()
                        //.logError(
                                //"Invalid default route specification - need host:port/transport");
                //throw ex;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.248 -0400", hash_original_method = "5920A86ACDD933EC7CFC2B95A34FE620", hash_generated_method = "921CF172215FBF4F6D7D386AE3E09E2D")
    public Hop getNextHop(Request request) throws SipException {
        addTaint(request.getTaint());
        SIPRequest sipRequest = (SIPRequest) request;
        RequestLine requestLine = sipRequest.getRequestLine();
        if(requestLine == null)        
        {
Hop var7C3D9107A1BB6CCC233CC962C791CA18_2145367497 =             defaultRoute;
            var7C3D9107A1BB6CCC233CC962C791CA18_2145367497.addTaint(taint);
            return var7C3D9107A1BB6CCC233CC962C791CA18_2145367497;
        } //End block
        javax.sip.address.URI requestURI = requestLine.getUri();
        if(requestURI == null)        
        {
        IllegalArgumentException var42845BE86469A3107A3A8086513D244C_2145142927 = new IllegalArgumentException("Bad message: Null requestURI");
        var42845BE86469A3107A3A8086513D244C_2145142927.addTaint(taint);
        throw var42845BE86469A3107A3A8086513D244C_2145142927;
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
                } //End block
                Hop hop = createHop(sipUri,request);
                if(sipStack.isLoggingEnabled())                
                sipStack.getStackLogger()
                            .logDebug("NextHop based on Route:" + hop);
Hop varCF598A87F121766CA237EE82036D5763_1757688341 =                 hop;
                varCF598A87F121766CA237EE82036D5763_1757688341.addTaint(taint);
                return varCF598A87F121766CA237EE82036D5763_1757688341;
            } //End block
            else
            {
                SipException varF581249094E58B797A880CDDFBC80E70_338119421 = new SipException("First Route not a SIP URI");
                varF581249094E58B797A880CDDFBC80E70_338119421.addTaint(taint);
                throw varF581249094E58B797A880CDDFBC80E70_338119421;
            } //End block
        } //End block
        else
        if(requestURI.isSipURI()
                && ((SipURI) requestURI).getMAddrParam() != null)        
        {
            Hop hop = createHop((SipURI) requestURI,request);
            if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger()
                        .logDebug("Using request URI maddr to route the request = "
                                + hop.toString());
Hop varCF598A87F121766CA237EE82036D5763_1649649944 =             hop;
            varCF598A87F121766CA237EE82036D5763_1649649944.addTaint(taint);
            return varCF598A87F121766CA237EE82036D5763_1649649944;
        } //End block
        else
        if(defaultRoute != null)        
        {
            if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger()
                        .logDebug("Using outbound proxy to route the request = "
                                + defaultRoute.toString());
Hop var7C3D9107A1BB6CCC233CC962C791CA18_1261596643 =             defaultRoute;
            var7C3D9107A1BB6CCC233CC962C791CA18_1261596643.addTaint(taint);
            return var7C3D9107A1BB6CCC233CC962C791CA18_1261596643;
        } //End block
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
            } //End block
Hop varCF598A87F121766CA237EE82036D5763_1711049645 =             hop;
            varCF598A87F121766CA237EE82036D5763_1711049645.addTaint(taint);
            return varCF598A87F121766CA237EE82036D5763_1711049645;
        } //End block
        else
        {
            InternalErrorHandler.handleException("Unexpected non-sip URI",
                    this.sipStack.getStackLogger());
Hop var540C13E9E156B687226421B24F2DF178_1655616454 =             null;
            var540C13E9E156B687226421B24F2DF178_1655616454.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1655616454;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.250 -0400", hash_original_method = "F98ABD2EA2392557384972BDB7FAD5AD", hash_generated_method = "CCCEB65ED8C3986E9BC1D4BBCEE4CB85")
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
        } //End block
        // ---------- Original Method ----------
        //RouteList routes = req.getRouteHeaders();
        //Route first = (Route) routes.getFirst();
        //SipUri firstUri = (SipUri) first.getAddress().getURI();
        //routes.removeFirst();
        //AddressImpl addr = new AddressImpl();
        //addr.setAddess(req.getRequestURI());
        //Route route = new Route(addr);
        //routes.add(route);
        //req.setRequestURI(firstUri);
        //if (sipStack.isLoggingEnabled()) {
            //sipStack.getStackLogger().logDebug("post: fixStrictRouting" + req);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.251 -0400", hash_original_method = "1A8C9A0DF77761777787B14E70DB6165", hash_generated_method = "39C1AAAB58BADDF0DA98ACB8EB84D987")
    private final Hop createHop(SipURI sipUri, Request request) {
        addTaint(request.getTaint());
        addTaint(sipUri.getTaint());
        String transport = sipUri.isSecure() ? SIPConstants.TLS : sipUri
                .getTransportParam();
        if(transport == null)        
        {
            ViaHeader via = (ViaHeader) request.getHeader(ViaHeader.NAME);
            transport = via.getTransport();
        } //End block
        int port;
        if(sipUri.getPort() != -1)        
        {
            port = sipUri.getPort();
        } //End block
        else
        {
            if(transport.equalsIgnoreCase(SIPConstants.TLS))            
            port = 5061;
            else
            port = 5060;
        } //End block
        String host = sipUri.getMAddrParam() != null ? sipUri.getMAddrParam()
                : sipUri.getHost();
        AddressResolver addressResolver = this.sipStack.getAddressResolver();
Hop var65DBDE1B68EBAE1D8996367F5504793F_1691065314 =         addressResolver
                .resolveAddress(new HopImpl(host, port, transport));
        var65DBDE1B68EBAE1D8996367F5504793F_1691065314.addTaint(taint);
        return var65DBDE1B68EBAE1D8996367F5504793F_1691065314;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.252 -0400", hash_original_method = "4C71B768C5A06ACD6891DA2692157012", hash_generated_method = "47726005354A78097C87947469E24437")
    public javax.sip.address.Hop getOutboundProxy() {
javax.sip.address.Hop varF8E8BFFE70D4C82F135420B297CB0572_1275462397 =         this.defaultRoute;
        varF8E8BFFE70D4C82F135420B297CB0572_1275462397.addTaint(taint);
        return varF8E8BFFE70D4C82F135420B297CB0572_1275462397;
        // ---------- Original Method ----------
        //return this.defaultRoute;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.253 -0400", hash_original_method = "C9341668DF04FCD8B03458AAEB056098", hash_generated_method = "5B5E07C756CAD4CE8EEC53749D4C8F5C")
    public ListIterator getNextHops(Request request) {
        addTaint(request.getTaint());
        try 
        {
            LinkedList llist = new LinkedList();
            llist.add(this.getNextHop(request));
ListIterator var20F8225C0A6BB17E1A7F99EEDC8CFDB8_1719661165 =             llist.listIterator();
            var20F8225C0A6BB17E1A7F99EEDC8CFDB8_1719661165.addTaint(taint);
            return var20F8225C0A6BB17E1A7F99EEDC8CFDB8_1719661165;
        } //End block
        catch (SipException ex)
        {
ListIterator var540C13E9E156B687226421B24F2DF178_537294936 =             null;
            var540C13E9E156B687226421B24F2DF178_537294936.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_537294936;
        } //End block
        // ---------- Original Method ----------
        //try {
            //LinkedList llist = new LinkedList();
            //llist.add(this.getNextHop(request));
            //return llist.listIterator();
        //} catch (SipException ex) {
            //return null;
        //}
    }

    
}

