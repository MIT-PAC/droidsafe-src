package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    private SipStackImpl sipStack;
    private Hop defaultRoute;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.812 -0400", hash_original_method = "1E8D5551C1C844D291A6EDC5BD70E069", hash_generated_method = "8B9D0899EFA10ABEE473358BCF33303F")
    @DSModeled(DSC.SAFE)
    private DefaultRouter() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.812 -0400", hash_original_method = "0186412A42AE3A0076B8DB4250031F53", hash_generated_method = "C61E43B185803948CFA1FF6031581D81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DefaultRouter(SipStack sipStack, String defaultRoute) {
        dsTaint.addTaint(sipStack.dsTaint);
        dsTaint.addTaint(defaultRoute);
        this.sipStack = (SipStackImpl) sipStack;
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
                if (DroidSafeAndroidRuntime.control) throw ex;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.813 -0400", hash_original_method = "5920A86ACDD933EC7CFC2B95A34FE620", hash_generated_method = "3DB59742214B82213BC69555C8F10F77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Hop getNextHop(Request request) throws SipException {
        dsTaint.addTaint(request.dsTaint);
        SIPRequest sipRequest;
        sipRequest = (SIPRequest) request;
        RequestLine requestLine;
        requestLine = sipRequest.getRequestLine();
        javax.sip.address.URI requestURI;
        requestURI = requestLine.getUri();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad message: Null requestURI");
        RouteList routes;
        routes = sipRequest.getRouteHeaders();
        {
            Route route;
            route = (Route) routes.getFirst();
            URI uri;
            uri = route.getAddress().getURI();
            {
                boolean varB5B2D13F5094D71E906111719A599E6C_1677718837 = (uri.isSipURI());
                {
                    SipURI sipUri;
                    sipUri = (SipURI) uri;
                    {
                        boolean var6E8FFD8A73588F386B3FBC5E1C901890_376492137 = (!sipUri.hasLrParam());
                        {
                            fixStrictRouting(sipRequest);
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_421964 = (sipStack.isLoggingEnabled());
                                sipStack.getStackLogger()
                                .logDebug("Route post processing fixed strict routing");
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                    Hop hop;
                    hop = createHop(sipUri,request);
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_151489817 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger()
                            .logDebug("NextHop based on Route:" + hop);
                    } //End collapsed parenthetic
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new SipException("First Route not a SIP URI");
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean var06C0D014CD816D71925C4D1C6102D618_335314677 = (requestURI.isSipURI()
                && ((SipURI) requestURI).getMAddrParam() != null);
            {
                Hop hop;
                hop = createHop((SipURI) requestURI,request);
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1657453686 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger()
                        .logDebug("Using request URI maddr to route the request = "
                                + hop.toString());
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1129912965 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger()
                        .logDebug("Using outbound proxy to route the request = "
                                + defaultRoute.toString());
                } //End collapsed parenthetic
            } //End block
            {
                boolean varB694EFEB444F701B4E21CC50B5BEDD05_1206336998 = (requestURI.isSipURI());
                {
                    Hop hop;
                    hop = createHop((SipURI) requestURI,request);
                    {
                        boolean var331EEBBEB1C0E76EF0E9DFFA8AA0059E_258572600 = (hop != null && sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug("Used request-URI for nextHop = "
                        + hop.toString());
                        {
                            boolean var2AB968A8303910EE00F810B6DE3410F9_1389467659 = (sipStack.isLoggingEnabled());
                            {
                                sipStack.getStackLogger()
                        .logDebug("returning null hop -- loop detected");
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End block
                {
                    InternalErrorHandler.handleException("Unexpected non-sip URI",
                    this.sipStack.getStackLogger());
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        return (Hop)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.814 -0400", hash_original_method = "F98ABD2EA2392557384972BDB7FAD5AD", hash_generated_method = "D5802FBEF94DE9275F1ECA98B346BDDC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void fixStrictRouting(SIPRequest req) {
        dsTaint.addTaint(req.dsTaint);
        RouteList routes;
        routes = req.getRouteHeaders();
        Route first;
        first = (Route) routes.getFirst();
        SipUri firstUri;
        firstUri = (SipUri) first.getAddress().getURI();
        routes.removeFirst();
        AddressImpl addr;
        addr = new AddressImpl();
        addr.setAddess(req.getRequestURI());
        Route route;
        route = new Route(addr);
        routes.add(route);
        req.setRequestURI(firstUri);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1634585875 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("post: fixStrictRouting" + req);
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.814 -0400", hash_original_method = "1A8C9A0DF77761777787B14E70DB6165", hash_generated_method = "91FC0FF9A449360D66869CF25C99B3BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final Hop createHop(SipURI sipUri, Request request) {
        dsTaint.addTaint(request.dsTaint);
        dsTaint.addTaint(sipUri.dsTaint);
        String transport;
        boolean var499221342219B07035BC9A1843B93C5D_676168897 = (sipUri.isSecure());
        transport = SIPConstants.TLS;
        transport = sipUri
                .getTransportParam();
        {
            ViaHeader via;
            via = (ViaHeader) request.getHeader(ViaHeader.NAME);
            transport = via.getTransport();
        } //End block
        int port;
        {
            boolean var7CFABA020D3D2C4E969A93D93880102D_268665404 = (sipUri.getPort() != -1);
            {
                port = sipUri.getPort();
            } //End block
            {
                {
                    boolean var94CE0BFC80C486398609DFA5C81E6E1F_1302599901 = (transport.equalsIgnoreCase(SIPConstants.TLS));
                    port = 5061;
                    port = 5060;
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        String host;
        boolean var00ADFEB80CF4A242B4CBB42CD5D12E7A_907379099 = (sipUri.getMAddrParam() != null);
        host = sipUri.getMAddrParam();
        host = sipUri.getHost();
        AddressResolver addressResolver;
        addressResolver = this.sipStack.getAddressResolver();
        Hop var7E518F82FA83B3BB6A2316C6D7FB16B9_724221809 = (addressResolver
                .resolveAddress(new HopImpl(host, port, transport)));
        return (Hop)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.814 -0400", hash_original_method = "4C71B768C5A06ACD6891DA2692157012", hash_generated_method = "C7DD93B8A3EE8BA3473E6BC89DF9BAF4")
    @DSModeled(DSC.SAFE)
    public javax.sip.address.Hop getOutboundProxy() {
        return (javax.sip.address.Hop)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.defaultRoute;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.814 -0400", hash_original_method = "C9341668DF04FCD8B03458AAEB056098", hash_generated_method = "B6641B214094C5BA1F51DA59E35D7C3A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ListIterator getNextHops(Request request) {
        dsTaint.addTaint(request.dsTaint);
        try 
        {
            LinkedList llist;
            llist = new LinkedList();
            llist.add(this.getNextHop(request));
            ListIterator varE9F166B7985A6D8413984AAE8A27968F_850604599 = (llist.listIterator());
        } //End block
        catch (SipException ex)
        { }
        return (ListIterator)dsTaint.getTaint();
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

