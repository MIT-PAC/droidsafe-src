package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface SIPHeaderNamesIms
    extends gov.nist.javax.sip.header.SIPHeaderNames {

    public static final String PATH = PathHeader.NAME;
    public static final String SERVICE_ROUTE = ServiceRouteHeader.NAME;
    public static final String P_ASSERTED_IDENTITY = PAssertedIdentityHeader.NAME;
    public static final String P_PREFERRED_IDENTITY = PPreferredIdentityHeader.NAME;
    public static final String CALLED_PARTY_ID = PCalledPartyIDHeader.NAME;
    public static final String P_VISITED_NETWORK_ID = PVisitedNetworkIDHeader.NAME;
    public static final String P_CHARGING_FUNCTION_ADDRESSES = PChargingFunctionAddressesHeader.NAME;
    public static final String P_CHARGING_VECTOR = PChargingVectorHeader.NAME;


    
    public static final String PRIVACY = PrivacyHeader.NAME;
    public static final String P_ASSOCIATED_URI = PAssociatedURIHeader.NAME;
    public static final String P_MEDIA_AUTHORIZATION = PMediaAuthorizationHeader.NAME;
    public static final String P_ACCESS_NETWORK_INFO = PAccessNetworkInfoHeader.NAME;
    public static final String SECURITY_SERVER = SecurityServerHeader.NAME;
    public static final String SECURITY_CLIENT = SecurityClientHeader.NAME;
    public static final String SECURITY_VERIFY = SecurityVerifyHeader.NAME;

    
    public static final String P_USER_DATABASE = PUserDatabaseHeader.NAME;
    
    public static final String P_PROFILE_KEY = PProfileKeyHeader.NAME;
    
    public static final String P_SERVED_USER = PServedUserHeader.NAME;
    
    public static final String P_PREFERRED_SERVICE = PPreferredServiceHeader.NAME;
    
    public static final String P_ASSERTED_SERVICE = PAssertedServiceHeader.NAME;


}
