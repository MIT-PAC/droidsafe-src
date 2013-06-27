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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.951 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "B028268F85C87F49A0E45B93954BF938")

    private SipStackImpl sipStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.951 -0400", hash_original_field = "F35E88995B01DD639351EFA9D1C5FAAA", hash_generated_field = "EB3744EEB0666E12CFAB5865A55F554C")

    private Hop defaultRoute;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.958 -0400", hash_original_method = "1E8D5551C1C844D291A6EDC5BD70E069", hash_generated_method = "8B9D0899EFA10ABEE473358BCF33303F")
    private  DefaultRouter() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.959 -0400", hash_original_method = "0186412A42AE3A0076B8DB4250031F53", hash_generated_method = "C47234C914D130A9B82A889A10E64894")
    public  DefaultRouter(SipStack sipStack, String defaultRoute) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.967 -0400", hash_original_method = "5920A86ACDD933EC7CFC2B95A34FE620", hash_generated_method = "39FC0284DED100D676D67861F7EEA750")
    public Hop getNextHop(Request request) throws SipException {
        Hop varB4EAC82CA7396A68D541C85D26508E83_41687115 = null; //Variable for return #1
        Hop varB4EAC82CA7396A68D541C85D26508E83_1884536209 = null; //Variable for return #2
        Hop varB4EAC82CA7396A68D541C85D26508E83_732014328 = null; //Variable for return #3
        Hop varB4EAC82CA7396A68D541C85D26508E83_693778860 = null; //Variable for return #4
        Hop varB4EAC82CA7396A68D541C85D26508E83_198044105 = null; //Variable for return #5
        Hop varB4EAC82CA7396A68D541C85D26508E83_1999293656 = null; //Variable for return #6
        SIPRequest sipRequest;
        sipRequest = (SIPRequest) request;
        RequestLine requestLine;
        requestLine = sipRequest.getRequestLine();
        {
            varB4EAC82CA7396A68D541C85D26508E83_41687115 = defaultRoute;
        } //End block
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
                boolean varB5B2D13F5094D71E906111719A599E6C_1629044781 = (uri.isSipURI());
                {
                    SipURI sipUri;
                    sipUri = (SipURI) uri;
                    {
                        boolean var6E8FFD8A73588F386B3FBC5E1C901890_784344813 = (!sipUri.hasLrParam());
                        {
                            fixStrictRouting(sipRequest);
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_1663682752 = (sipStack.isLoggingEnabled());
                                sipStack.getStackLogger()
                                .logDebug("Route post processing fixed strict routing");
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                    Hop hop;
                    hop = createHop(sipUri,request);
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_655428627 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger()
                            .logDebug("NextHop based on Route:" + hop);
                    } //End collapsed parenthetic
                    varB4EAC82CA7396A68D541C85D26508E83_1884536209 = hop;
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new SipException("First Route not a SIP URI");
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean var06C0D014CD816D71925C4D1C6102D618_10404184 = (requestURI.isSipURI()
                && ((SipURI) requestURI).getMAddrParam() != null);
            {
                Hop hop;
                hop = createHop((SipURI) requestURI,request);
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_541836882 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger()
                        .logDebug("Using request URI maddr to route the request = "
                                + hop.toString());
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_732014328 = hop;
            } //End block
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1324669120 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger()
                        .logDebug("Using outbound proxy to route the request = "
                                + defaultRoute.toString());
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_693778860 = defaultRoute;
            } //End block
            {
                boolean varB694EFEB444F701B4E21CC50B5BEDD05_712120517 = (requestURI.isSipURI());
                {
                    Hop hop;
                    hop = createHop((SipURI) requestURI,request);
                    {
                        boolean var331EEBBEB1C0E76EF0E9DFFA8AA0059E_271579058 = (hop != null && sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug("Used request-URI for nextHop = "
                        + hop.toString());
                        {
                            boolean var2AB968A8303910EE00F810B6DE3410F9_2041710856 = (sipStack.isLoggingEnabled());
                            {
                                sipStack.getStackLogger()
                        .logDebug("returning null hop -- loop detected");
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                    varB4EAC82CA7396A68D541C85D26508E83_198044105 = hop;
                } //End block
                {
                    InternalErrorHandler.handleException("Unexpected non-sip URI",
                    this.sipStack.getStackLogger());
                    varB4EAC82CA7396A68D541C85D26508E83_1999293656 = null;
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(request.getTaint());
        Hop varA7E53CE21691AB073D9660D615818899_888236429; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_888236429 = varB4EAC82CA7396A68D541C85D26508E83_41687115;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_888236429 = varB4EAC82CA7396A68D541C85D26508E83_1884536209;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_888236429 = varB4EAC82CA7396A68D541C85D26508E83_732014328;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_888236429 = varB4EAC82CA7396A68D541C85D26508E83_693778860;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_888236429 = varB4EAC82CA7396A68D541C85D26508E83_198044105;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_888236429 = varB4EAC82CA7396A68D541C85D26508E83_1999293656;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_888236429.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_888236429;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.974 -0400", hash_original_method = "F98ABD2EA2392557384972BDB7FAD5AD", hash_generated_method = "A00E6D9EC40DF62BEB3F25BB53F7A689")
    public void fixStrictRouting(SIPRequest req) {
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
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_182491604 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("post: fixStrictRouting" + req);
            } //End block
        } //End collapsed parenthetic
        addTaint(req.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.978 -0400", hash_original_method = "1A8C9A0DF77761777787B14E70DB6165", hash_generated_method = "9421E0F670DD0AC71DA0E2F756132188")
    private final Hop createHop(SipURI sipUri, Request request) {
        Hop varB4EAC82CA7396A68D541C85D26508E83_1759327229 = null; //Variable for return #1
        String transport;
        boolean var499221342219B07035BC9A1843B93C5D_77481652 = (sipUri.isSecure());
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
            boolean var7CFABA020D3D2C4E969A93D93880102D_222010700 = (sipUri.getPort() != -1);
            {
                port = sipUri.getPort();
            } //End block
            {
                {
                    boolean var94CE0BFC80C486398609DFA5C81E6E1F_2138195233 = (transport.equalsIgnoreCase(SIPConstants.TLS));
                    port = 5061;
                    port = 5060;
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        String host;
        boolean var00ADFEB80CF4A242B4CBB42CD5D12E7A_706594014 = (sipUri.getMAddrParam() != null);
        host = sipUri.getMAddrParam();
        host = sipUri.getHost();
        AddressResolver addressResolver;
        addressResolver = this.sipStack.getAddressResolver();
        varB4EAC82CA7396A68D541C85D26508E83_1759327229 = addressResolver
                .resolveAddress(new HopImpl(host, port, transport));
        addTaint(sipUri.getTaint());
        addTaint(request.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1759327229.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1759327229;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.980 -0400", hash_original_method = "4C71B768C5A06ACD6891DA2692157012", hash_generated_method = "445FB38AFAF76E3E7D99A962698D5AC0")
    public javax.sip.address.Hop getOutboundProxy() {
        javax.sip.address.Hop varB4EAC82CA7396A68D541C85D26508E83_1176240279 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1176240279 = this.defaultRoute;
        varB4EAC82CA7396A68D541C85D26508E83_1176240279.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1176240279;
        // ---------- Original Method ----------
        //return this.defaultRoute;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.987 -0400", hash_original_method = "C9341668DF04FCD8B03458AAEB056098", hash_generated_method = "BB92F725E3DA484057C03D77E06885F9")
    public ListIterator getNextHops(Request request) {
        ListIterator varB4EAC82CA7396A68D541C85D26508E83_1581058332 = null; //Variable for return #1
        ListIterator varB4EAC82CA7396A68D541C85D26508E83_1324810959 = null; //Variable for return #2
        try 
        {
            LinkedList llist;
            llist = new LinkedList();
            llist.add(this.getNextHop(request));
            varB4EAC82CA7396A68D541C85D26508E83_1581058332 = llist.listIterator();
        } //End block
        catch (SipException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1324810959 = null;
        } //End block
        addTaint(request.getTaint());
        ListIterator varA7E53CE21691AB073D9660D615818899_2032237050; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2032237050 = varB4EAC82CA7396A68D541C85D26508E83_1581058332;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2032237050 = varB4EAC82CA7396A68D541C85D26508E83_1324810959;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2032237050.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2032237050;
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

