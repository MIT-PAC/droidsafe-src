package javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.sip.InvalidArgumentException;
import javax.sip.address.Address;
import javax.sip.address.URI;

public interface HeaderFactory {
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setPrettyEncoding(boolean flag);

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    AcceptEncodingHeader createAcceptEncodingHeader(String encoding)
            throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    AcceptHeader createAcceptHeader(String contentType, String contentSubType)
            throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    AcceptLanguageHeader createAcceptLanguageHeader(Locale language);

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    AlertInfoHeader createAlertInfoHeader(URI alertInfo);

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    AllowEventsHeader createAllowEventsHeader(String eventType)
            throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    AllowHeader createAllowHeader(String method) throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    AuthenticationInfoHeader createAuthenticationInfoHeader(String response)
            throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    AuthorizationHeader createAuthorizationHeader(String scheme)
            throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    CallIdHeader createCallIdHeader(String callId) throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    CallInfoHeader createCallInfoHeader(URI callInfo);

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    ContactHeader createContactHeader();

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    ContactHeader createContactHeader(Address address);

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    ContentDispositionHeader createContentDispositionHeader(
            String contentDispositionType) throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    ContentEncodingHeader createContentEncodingHeader(String encoding)
            throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    ContentLanguageHeader createContentLanguageHeader(Locale contentLanguage);

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    ContentLengthHeader createContentLengthHeader(int contentLength)
            throws InvalidArgumentException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    ContentTypeHeader createContentTypeHeader(String contentType,
            String contentSubType) throws ParseException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    CSeqHeader createCSeqHeader(int sequenceNumber, String method)
            throws ParseException, InvalidArgumentException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    CSeqHeader createCSeqHeader(long sequenceNumber, String method)
            throws ParseException, InvalidArgumentException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    DateHeader createDateHeader(Calendar date);

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    ErrorInfoHeader createErrorInfoHeader(URI errorInfo);

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    EventHeader createEventHeader(String eventType) throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    ExpiresHeader createExpiresHeader(int expires)
            throws InvalidArgumentException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    ExtensionHeader createExtensionHeader(String name, String value)
            throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    FromHeader createFromHeader(Address address, String tag)
            throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Header createHeader(String name, String value) throws ParseException;
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Header createHeader(String headerText) throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    List createHeaders(String headers) throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    InReplyToHeader createInReplyToHeader(String callId) throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    MaxForwardsHeader createMaxForwardsHeader(int maxForwards)
            throws InvalidArgumentException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    MimeVersionHeader createMimeVersionHeader(int majorVersion,
            int minorVersion) throws InvalidArgumentException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    MinExpiresHeader createMinExpiresHeader(int minExpires)
            throws InvalidArgumentException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    OrganizationHeader createOrganizationHeader(String organization)
            throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    PriorityHeader createPriorityHeader(String priority) throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    ProxyAuthenticateHeader createProxyAuthenticateHeader(String scheme)
            throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    ProxyAuthorizationHeader createProxyAuthorizationHeader(String scheme)
            throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    ProxyRequireHeader createProxyRequireHeader(String optionTag)
            throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    RAckHeader createRAckHeader(long rSeqNumber, long cSeqNumber, String method)
            throws InvalidArgumentException, ParseException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    RAckHeader createRAckHeader(int rSeqNumber, int cSeqNumber, String method)
            throws InvalidArgumentException, ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    ReasonHeader createReasonHeader(String protocol, int cause, String text)
            throws InvalidArgumentException, ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    RecordRouteHeader createRecordRouteHeader(Address address);

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    ReferToHeader createReferToHeader(Address address);

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    ReplyToHeader createReplyToHeader(Address address);

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    RequireHeader createRequireHeader(String optionTag) throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    RetryAfterHeader createRetryAfterHeader(int retryAfter)
            throws InvalidArgumentException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    RouteHeader createRouteHeader(Address address);

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    RSeqHeader createRSeqHeader(long sequenceNumber)
            throws InvalidArgumentException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    RSeqHeader createRSeqHeader(int sequenceNumber)
            throws InvalidArgumentException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    ServerHeader createServerHeader(List product) throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    SIPETagHeader createSIPETagHeader(String etag) throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    SIPIfMatchHeader createSIPIfMatchHeader(String etag) throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    SubjectHeader createSubjectHeader(String subject) throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    SubscriptionStateHeader createSubscriptionStateHeader(
            String subscriptionState) throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    SupportedHeader createSupportedHeader(String optionTag)
            throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    TimeStampHeader createTimeStampHeader(float timeStamp)
            throws InvalidArgumentException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    ToHeader createToHeader(Address address, String tag) throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    UnsupportedHeader createUnsupportedHeader(String optionTag)
            throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    UserAgentHeader createUserAgentHeader(List product) throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    ViaHeader createViaHeader(String host, int port, String transport,
            String branch) throws InvalidArgumentException, ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    WarningHeader createWarningHeader(String agent, int code, String comment)
            throws InvalidArgumentException, ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    WWWAuthenticateHeader createWWWAuthenticateHeader(String scheme)
            throws ParseException;
}
