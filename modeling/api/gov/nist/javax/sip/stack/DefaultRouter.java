package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

public class DefaultRouter implements Router {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:28.132 -0500", hash_original_field = "03821C4D777C0A4AB8577E0C5F2371D6", hash_generated_field = "B028268F85C87F49A0E45B93954BF938")

    private SipStackImpl sipStack;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:28.134 -0500", hash_original_field = "F732783B6547E2F4AE4819E261C89621", hash_generated_field = "EB3744EEB0666E12CFAB5865A55F554C")

    private Hop defaultRoute;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:28.137 -0500", hash_original_method = "1E8D5551C1C844D291A6EDC5BD70E069", hash_generated_method = "76740CD8F7CB8A612911FE9CCA9CE730")
    
private DefaultRouter() {

    }

    /**
     * Constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:28.140 -0500", hash_original_method = "0186412A42AE3A0076B8DB4250031F53", hash_generated_method = "E1819CBFE819C754DAEC9A44444CE3AA")
    
public DefaultRouter(SipStack sipStack, String defaultRoute) {
        this.sipStack = (SipStackImpl) sipStack;
        if (defaultRoute != null) {
            try {
                this.defaultRoute = (Hop) this.sipStack.getAddressResolver()
                        .resolveAddress((Hop) (new HopImpl(defaultRoute)));
            } catch (IllegalArgumentException ex) {
                // The outbound proxy is optional. If specified it should be host:port/transport.
                ((SIPTransactionStack) sipStack)
                        .getStackLogger()
                        .logError(
                                "Invalid default route specification - need host:port/transport");
                throw ex;
            }
        }
    }

    /**
     * Return addresses for default proxy to forward the request to. The list is
     * organized in the following priority. If the requestURI refers directly to
     * a host, the host and port information are extracted from it and made the
     * next hop on the list. If the default route has been specified, then it is
     * used to construct the next element of the list. <code>
     * RouteHeader firstRoute = (RouteHeader) req.getHeader( RouteHeader.NAME );
     * if (firstRoute!=null) {
     *   URI uri = firstRoute.getAddress().getURI();
     *    if (uri.isSIPUri()) {
     *       SipURI nextHop = (SipURI) uri;
     *       if ( nextHop.hasLrParam() ) {
     *           // OK, use it
     *       } else {
     *           nextHop = fixStrictRouting( req );        <--- Here, make the modifications as per RFC3261
     *       }
     *   } else {
     *       // error: non-SIP URI not allowed in Route headers
     *       throw new SipException( "Request has Route header with non-SIP URI" );
     *   }
     * } else if (outboundProxy!=null) {
     *   // use outbound proxy for nextHop
     * } else if ( req.getRequestURI().isSipURI() ) {
     *   // use request URI for nextHop
     * }
     *
     * </code>
     *
     * @param request
     *            is the sip request to route.
     *
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:28.144 -0500", hash_original_method = "5920A86ACDD933EC7CFC2B95A34FE620", hash_generated_method = "D3DAE52BFAEF18F6BBC76B854B4C5773")
    
public Hop getNextHop(Request request) throws SipException {

        SIPRequest sipRequest = (SIPRequest) request;

        RequestLine requestLine = sipRequest.getRequestLine();
        if (requestLine == null) {
            return defaultRoute;
        }
        javax.sip.address.URI requestURI = requestLine.getUri();
        if (requestURI == null)
            throw new IllegalArgumentException("Bad message: Null requestURI");

        RouteList routes = sipRequest.getRouteHeaders();

        /*
         * In case the topmost Route header contains no 'lr' parameter (which
         * means the next hop is a strict router), the implementation will
         * perform 'Route Information Postprocessing' as described in RFC3261
         * section 16.6 step 6 (also known as "Route header popping"). That is,
         * the following modifications will be made to the request:
         *
         * The implementation places the Request-URI into the Route header field
         * as the last value.
         *
         * The implementation then places the first Route header field value
         * into the Request-URI and removes that value from the Route header
         * field.
         *
         * Subsequently, the request URI will be used as next hop target
         */

        if (routes != null) {

            // to send the request through a specified hop the application is
            // supposed to prepend the appropriate Route header which.
            Route route = (Route) routes.getFirst();
            URI uri = route.getAddress().getURI();
            if (uri.isSipURI()) {
                SipURI sipUri = (SipURI) uri;
                if (!sipUri.hasLrParam()) {

                    fixStrictRouting(sipRequest);
                    if (sipStack.isLoggingEnabled())
                        sipStack.getStackLogger()
                                .logDebug("Route post processing fixed strict routing");
                }

                Hop hop = createHop(sipUri,request);
                if (sipStack.isLoggingEnabled())
                    sipStack.getStackLogger()
                            .logDebug("NextHop based on Route:" + hop);
                return hop;
            } else {
                throw new SipException("First Route not a SIP URI");
            }

        } else if (requestURI.isSipURI()
                && ((SipURI) requestURI).getMAddrParam() != null) {
            Hop hop = createHop((SipURI) requestURI,request);
            if (sipStack.isLoggingEnabled())
                sipStack.getStackLogger()
                        .logDebug("Using request URI maddr to route the request = "
                                + hop.toString());

            // JvB: don't remove it!
            // ((SipURI) requestURI).removeParameter("maddr");

            return hop;

        } else if (defaultRoute != null) {
            if (sipStack.isLoggingEnabled())
                sipStack.getStackLogger()
                        .logDebug("Using outbound proxy to route the request = "
                                + defaultRoute.toString());
            return defaultRoute;
        } else if (requestURI.isSipURI()) {
            Hop hop = createHop((SipURI) requestURI,request);
            if (hop != null && sipStack.isLoggingEnabled())
                sipStack.getStackLogger().logDebug("Used request-URI for nextHop = "
                        + hop.toString());
            else if (sipStack.isLoggingEnabled()) {
                sipStack.getStackLogger()
                        .logDebug("returning null hop -- loop detected");
            }
            return hop;

        } else {
            // The internal router should never be consulted for non-sip URIs.
            InternalErrorHandler.handleException("Unexpected non-sip URI",
                    this.sipStack.getStackLogger());
            return null;
        }

    }

    /**
     * Performs strict router fix according to RFC3261 section 16.6 step 6
     *
     * pre: top route header in request has no 'lr' parameter in URI post:
     * request-URI added as last route header, new req-URI = top-route-URI
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:28.147 -0500", hash_original_method = "F98ABD2EA2392557384972BDB7FAD5AD", hash_generated_method = "79CB2E4E46BC8B45741840D877F07864")
    
public void fixStrictRouting(SIPRequest req) {

        RouteList routes = req.getRouteHeaders();
        Route first = (Route) routes.getFirst();
        SipUri firstUri = (SipUri) first.getAddress().getURI();
        routes.removeFirst();

        // Add request-URI as last Route entry
        AddressImpl addr = new AddressImpl();
        addr.setAddess(req.getRequestURI()); // don't clone it
        Route route = new Route(addr);

        routes.add(route); // as last one
        req.setRequestURI(firstUri);
        if (sipStack.isLoggingEnabled()) {
            sipStack.getStackLogger().logDebug("post: fixStrictRouting" + req);
        }
    }

    /**
     * Utility method to create a hop from a SIP URI
     *
     * @param sipUri
     * @return
     */

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:28.150 -0500", hash_original_method = "1A8C9A0DF77761777787B14E70DB6165", hash_generated_method = "3A7A70F4AA7EA0B40E7A88DF9227401C")
    
private final Hop createHop(SipURI sipUri, Request request) {
        // always use TLS when secure
        String transport = sipUri.isSecure() ? SIPConstants.TLS : sipUri
                .getTransportParam();
        if (transport == null) {
            //@see issue 131
            ViaHeader via = (ViaHeader) request.getHeader(ViaHeader.NAME);
            transport = via.getTransport();
        }

        // sipUri.removeParameter("transport");

        int port;
        if (sipUri.getPort() != -1) {
            port = sipUri.getPort();
        } else {
            if (transport.equalsIgnoreCase(SIPConstants.TLS))
                port = 5061;
            else
                port = 5060; // TCP or UDP
        }
        String host = sipUri.getMAddrParam() != null ? sipUri.getMAddrParam()
                : sipUri.getHost();
        AddressResolver addressResolver = this.sipStack.getAddressResolver();
        return addressResolver
                .resolveAddress(new HopImpl(host, port, transport));

    }

    /**
     * Get the default hop.
     *
     * @return defaultRoute is the default route. public java.util.Iterator
     *         getDefaultRoute(Request request) { return
     *         this.getNextHops((SIPRequest)request); }
     */

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:28.153 -0500", hash_original_method = "4C71B768C5A06ACD6891DA2692157012", hash_generated_method = "D4FA1AE20F412895E9950D7AAD4B0640")
    
public javax.sip.address.Hop getOutboundProxy() {
        return this.defaultRoute;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.sip.address.Router#getNextHop(javax.sip.message.Request)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:28.156 -0500", hash_original_method = "C9341668DF04FCD8B03458AAEB056098", hash_generated_method = "A4BD2AA04B9A90D6BF97BA1652C80190")
    
public ListIterator getNextHops(Request request) {
        try {
            LinkedList llist = new LinkedList();
            llist.add(this.getNextHop(request));
            return llist.listIterator();
        } catch (SipException ex) {
            return null;
        }

    }
    
}

