package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.core.*;
import gov.nist.javax.sip.header.ims.*;
import java.util.Hashtable;

public class NameMap implements SIPHeaderNames, PackageNames {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.621 -0400", hash_original_method = "4E6FA555129DB964A8E35D51AC605671", hash_generated_method = "4E6FA555129DB964A8E35D51AC605671")
    public NameMap ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
    protected static void putNameMap(String headerName, String className) {
        nameMap.put(
            headerName.toLowerCase(),
            className);
    }

    
        @DSModeled(DSC.SAFE)
    public static Class getClassFromName(String headerName) {
        String className = (String) nameMap.get(headerName.toLowerCase());
        if (className == null)
            return null;
        else {
            try {
                return Class.forName(className);
            } catch (ClassNotFoundException ex) {
                return null;
            }
        }
    }

    
        public static void addExtensionHeader(
        String headerName,
        String className) {
        nameMap.put(headerName.toLowerCase(), className);
    }

    
        private static void initializeNameMap() {
        nameMap = new Hashtable();
        putNameMap(MinExpires.NAME, MinExpires.class.getName());
        putNameMap(ErrorInfo.NAME, ErrorInfo.class.getName());
        putNameMap(MimeVersion.NAME, MimeVersion.class.getName());
        putNameMap(InReplyTo.NAME, InReplyTo.class.getName());
        putNameMap(Allow.NAME, Allow.class.getName());
        putNameMap(ContentLanguage.NAME, ContentLanguage.class.getName());
        putNameMap(CALL_INFO, CallInfo.class.getName());
        putNameMap(CSEQ, CSeq.class.getName());
        putNameMap(ALERT_INFO, AlertInfo.class.getName());
        putNameMap(ACCEPT_ENCODING, AcceptEncoding.class.getName());
        putNameMap(ACCEPT, Accept.class.getName());
        putNameMap(ACCEPT_LANGUAGE, AcceptLanguage.class.getName());
        putNameMap(RECORD_ROUTE, RecordRoute.class.getName());
        putNameMap(TIMESTAMP, TimeStamp.class.getName());
        putNameMap(TO, To.class.getName());
        putNameMap(VIA, Via.class.getName());
        putNameMap(FROM, From.class.getName());
        putNameMap(CALL_ID, CallID.class.getName());
        putNameMap(AUTHORIZATION, Authorization.class.getName());
        putNameMap(PROXY_AUTHENTICATE, ProxyAuthenticate.class.getName());
        putNameMap(SERVER, Server.class.getName());
        putNameMap(UNSUPPORTED, Unsupported.class.getName());
        putNameMap(RETRY_AFTER, RetryAfter.class.getName());
        putNameMap(CONTENT_TYPE, ContentType.class.getName());
        putNameMap(CONTENT_ENCODING, ContentEncoding.class.getName());
        putNameMap(CONTENT_LENGTH, ContentLength.class.getName());
        putNameMap(ROUTE, Route.class.getName());
        putNameMap(CONTACT, Contact.class.getName());
        putNameMap(WWW_AUTHENTICATE, WWWAuthenticate.class.getName());
        putNameMap(MAX_FORWARDS, MaxForwards.class.getName());
        putNameMap(ORGANIZATION, Organization.class.getName());
        putNameMap(PROXY_AUTHORIZATION, ProxyAuthorization.class.getName());
        putNameMap(PROXY_REQUIRE, ProxyRequire.class.getName());
        putNameMap(REQUIRE, Require.class.getName());
        putNameMap(CONTENT_DISPOSITION, ContentDisposition.class.getName());
        putNameMap(SUBJECT, Subject.class.getName());
        putNameMap(USER_AGENT, UserAgent.class.getName());
        putNameMap(WARNING, Warning.class.getName());
        putNameMap(PRIORITY, Priority.class.getName());
        putNameMap(DATE, SIPDateHeader.class.getName());
        putNameMap(EXPIRES, Expires.class.getName());
        putNameMap(SUPPORTED, Supported.class.getName());
        putNameMap(REPLY_TO, ReplyTo.class.getName());
        putNameMap(SUBSCRIPTION_STATE, SubscriptionState.class.getName());
        putNameMap(EVENT, Event.class.getName());
        putNameMap(ALLOW_EVENTS, AllowEvents.class.getName());
        putNameMap(REFERRED_BY, "ReferredBy");
        putNameMap(SESSION_EXPIRES, "SessionExpires");
        putNameMap(MIN_SE, "MinSE");
        putNameMap(REPLACES, "Replaces");
        putNameMap(JOIN, "Join");
        putNameMap(PAccessNetworkInfoHeader.NAME, PAccessNetworkInfo.class.getName());
        putNameMap(PAssertedIdentityHeader.NAME, PAssertedIdentity.class.getName());
        putNameMap(PAssociatedURIHeader.NAME, PAssociatedURI.class.getName());
        putNameMap(PCalledPartyIDHeader.NAME, PCalledPartyID.class.getName());
        putNameMap(PChargingFunctionAddressesHeader.NAME,  PChargingFunctionAddresses.class.getName());
        putNameMap(PChargingVectorHeader.NAME,PChargingVector.class.getName());
        putNameMap(PMediaAuthorizationHeader.NAME,PMediaAuthorization.class.getName());
        putNameMap(Path.NAME, Path.class.getName());
        putNameMap(PPreferredIdentity.NAME, PPreferredIdentity.class.getName());
        putNameMap(Privacy.NAME,Privacy.class.getName());
        putNameMap(ServiceRoute.NAME, ServiceRoute.class.getName());
        putNameMap(PVisitedNetworkID.NAME, PVisitedNetworkID.class.getName());
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.622 -0400", hash_original_field = "C45F42D8E26367D12A9961EAC2595CDF", hash_generated_field = "531CBEFD115E0D8DD45BF7A253D5B3F3")

    static Hashtable nameMap;
    static {
        initializeNameMap();
    }
    
}

