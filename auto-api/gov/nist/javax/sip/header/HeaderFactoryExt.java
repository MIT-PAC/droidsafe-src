package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import gov.nist.javax.sip.header.extensions.JoinHeader;
import gov.nist.javax.sip.header.extensions.ReferredByHeader;
import gov.nist.javax.sip.header.extensions.ReplacesHeader;
import gov.nist.javax.sip.header.extensions.SessionExpiresHeader;
import gov.nist.javax.sip.header.ims.PAccessNetworkInfoHeader;
import gov.nist.javax.sip.header.ims.PAssertedIdentityHeader;
import gov.nist.javax.sip.header.ims.PAssertedServiceHeader;
import gov.nist.javax.sip.header.ims.PAssociatedURIHeader;
import gov.nist.javax.sip.header.ims.PCalledPartyIDHeader;
import gov.nist.javax.sip.header.ims.PChargingFunctionAddressesHeader;
import gov.nist.javax.sip.header.ims.PChargingVectorHeader;
import gov.nist.javax.sip.header.ims.PMediaAuthorizationHeader;
import gov.nist.javax.sip.header.ims.PPreferredIdentityHeader;
import gov.nist.javax.sip.header.ims.PPreferredServiceHeader;
import gov.nist.javax.sip.header.ims.PProfileKeyHeader;
import gov.nist.javax.sip.header.ims.PServedUserHeader;
import gov.nist.javax.sip.header.ims.PUserDatabaseHeader;
import gov.nist.javax.sip.header.ims.PVisitedNetworkIDHeader;
import gov.nist.javax.sip.header.ims.PathHeader;
import gov.nist.javax.sip.header.ims.PrivacyHeader;
import gov.nist.javax.sip.header.ims.SecurityClientHeader;
import gov.nist.javax.sip.header.ims.SecurityServerHeader;
import gov.nist.javax.sip.header.ims.SecurityVerifyHeader;
import gov.nist.javax.sip.header.ims.ServiceRouteHeader;
import javax.sip.InvalidArgumentException;
import javax.sip.address.Address;
import javax.sip.header.Header;
import javax.sip.header.HeaderFactory;

public interface HeaderFactoryExt extends HeaderFactory {
    
    
    public SipRequestLine createRequestLine(String requestLine) throws ParseException;
    
    
    
    public SipStatusLine createStatusLine(String statusLine) throws ParseException;
    
    
    
    public ReferredByHeader createReferredByHeader(Address address);

    
    public ReplacesHeader createReplacesHeader(String callId, String toTag,
            String fromTag) throws ParseException;

    
    public PAccessNetworkInfoHeader createPAccessNetworkInfoHeader();

    
    public PAssertedIdentityHeader createPAssertedIdentityHeader(Address address)
            throws NullPointerException, ParseException;

    
    public PAssociatedURIHeader createPAssociatedURIHeader(Address assocURI);

    
    public PCalledPartyIDHeader createPCalledPartyIDHeader(Address address);

    
    public PChargingFunctionAddressesHeader createPChargingFunctionAddressesHeader();

    
    public PChargingVectorHeader createChargingVectorHeader(String icid) throws ParseException;

     
    public PMediaAuthorizationHeader createPMediaAuthorizationHeader(String token)
        throws InvalidArgumentException, ParseException;

    
    public PPreferredIdentityHeader createPPreferredIdentityHeader(Address address);

    
    public PVisitedNetworkIDHeader createPVisitedNetworkIDHeader();

    
    public PathHeader createPathHeader(Address address);

    
    public PrivacyHeader createPrivacyHeader(String privacyType);


    
    public ServiceRouteHeader createServiceRouteHeader(Address address);

    
    public SecurityServerHeader createSecurityServerHeader();

    
    public SecurityClientHeader createSecurityClientHeader();


    
    public SecurityVerifyHeader createSecurityVerifyHeader();


    
    public SessionExpiresHeader createSessionExpiresHeader(int expires) throws InvalidArgumentException ;

    
    public JoinHeader createJoinHeader(String callId, String toTag,
            String fromTag) throws ParseException;

    
    public PUserDatabaseHeader createPUserDatabaseHeader(String databaseName);


    
    public PProfileKeyHeader createPProfileKeyHeader(Address address);

    
    public PServedUserHeader createPServedUserHeader(Address address);

    
    public PPreferredServiceHeader createPPreferredServiceHeader();

    
    public PAssertedServiceHeader createPAssertedServiceHeader();
    
    
    public Header createHeader(String header) throws ParseException;

}
