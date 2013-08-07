package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.extensions.JoinHeader;
import gov.nist.javax.sip.header.extensions.MinSEHeader;
import gov.nist.javax.sip.header.extensions.ReferredByHeader;
import gov.nist.javax.sip.header.extensions.ReplacesHeader;
import gov.nist.javax.sip.header.extensions.SessionExpiresHeader;

import javax.sip.header.AcceptEncodingHeader;
import javax.sip.header.AcceptHeader;
import javax.sip.header.AcceptLanguageHeader;
import javax.sip.header.AlertInfoHeader;
import javax.sip.header.AllowEventsHeader;
import javax.sip.header.AllowHeader;
import javax.sip.header.AuthenticationInfoHeader;
import javax.sip.header.AuthorizationHeader;
import javax.sip.header.CSeqHeader;
import javax.sip.header.CallIdHeader;
import javax.sip.header.CallInfoHeader;
import javax.sip.header.ContactHeader;
import javax.sip.header.ContentDispositionHeader;
import javax.sip.header.ContentEncodingHeader;
import javax.sip.header.ContentLanguageHeader;
import javax.sip.header.ContentLengthHeader;
import javax.sip.header.ContentTypeHeader;
import javax.sip.header.DateHeader;
import javax.sip.header.ErrorInfoHeader;
import javax.sip.header.EventHeader;
import javax.sip.header.ExpiresHeader;
import javax.sip.header.FromHeader;
import javax.sip.header.InReplyToHeader;
import javax.sip.header.MaxForwardsHeader;
import javax.sip.header.MimeVersionHeader;
import javax.sip.header.MinExpiresHeader;
import javax.sip.header.OrganizationHeader;
import javax.sip.header.PriorityHeader;
import javax.sip.header.ProxyAuthenticateHeader;
import javax.sip.header.ProxyAuthorizationHeader;
import javax.sip.header.ProxyRequireHeader;
import javax.sip.header.RAckHeader;
import javax.sip.header.RSeqHeader;
import javax.sip.header.ReasonHeader;
import javax.sip.header.RecordRouteHeader;
import javax.sip.header.ReplyToHeader;
import javax.sip.header.RequireHeader;
import javax.sip.header.RetryAfterHeader;
import javax.sip.header.RouteHeader;
import javax.sip.header.SIPETagHeader;
import javax.sip.header.SIPIfMatchHeader;
import javax.sip.header.ServerHeader;
import javax.sip.header.SubjectHeader;
import javax.sip.header.SubscriptionStateHeader;
import javax.sip.header.SupportedHeader;
import javax.sip.header.TimeStampHeader;
import javax.sip.header.ToHeader;
import javax.sip.header.UnsupportedHeader;
import javax.sip.header.UserAgentHeader;
import javax.sip.header.ViaHeader;
import javax.sip.header.WWWAuthenticateHeader;
import javax.sip.header.WarningHeader;

public interface SIPHeaderNames {

    public static final String MIN_EXPIRES = MinExpiresHeader.NAME; 
    public static final String ERROR_INFO = ErrorInfoHeader.NAME; 
    public static final String MIME_VERSION = MimeVersionHeader.NAME; 
    public static final String IN_REPLY_TO = InReplyToHeader.NAME; 
    public static final String ALLOW = AllowHeader.NAME; 
    public static final String CONTENT_LANGUAGE = ContentLanguageHeader.NAME;
    
    public static final String CALL_INFO = CallInfoHeader.NAME; 
    public static final String CSEQ = CSeqHeader.NAME; 
    public static final String ALERT_INFO = AlertInfoHeader.NAME; 
    public static final String ACCEPT_ENCODING = AcceptEncodingHeader.NAME;
    
    public static final String ACCEPT = AcceptHeader.NAME; 
    public static final String ACCEPT_LANGUAGE = AcceptLanguageHeader.NAME;
    
    public static final String RECORD_ROUTE = RecordRouteHeader.NAME; 
    public static final String TIMESTAMP = TimeStampHeader.NAME; 
    public static final String TO = ToHeader.NAME; 
    public static final String VIA = ViaHeader.NAME; 
    public static final String FROM = FromHeader.NAME; 
    public static final String CALL_ID = CallIdHeader.NAME; 
    public static final String AUTHORIZATION = AuthorizationHeader.NAME; 
    public static final String PROXY_AUTHENTICATE =
        ProxyAuthenticateHeader.NAME;
    
    public static final String SERVER = ServerHeader.NAME; 
    public static final String UNSUPPORTED = UnsupportedHeader.NAME; 
    public static final String RETRY_AFTER = RetryAfterHeader.NAME; 
    public static final String CONTENT_TYPE = ContentTypeHeader.NAME; 
    public static final String CONTENT_ENCODING = ContentEncodingHeader.NAME;
    
    public static final String CONTENT_LENGTH = ContentLengthHeader.NAME; 
    public static final String ROUTE = RouteHeader.NAME; 
    public static final String CONTACT = ContactHeader.NAME; 
    public static final String WWW_AUTHENTICATE = WWWAuthenticateHeader.NAME;
    
    public static final String MAX_FORWARDS = MaxForwardsHeader.NAME; 
    public static final String ORGANIZATION = OrganizationHeader.NAME; 
    public static final String PROXY_AUTHORIZATION =
        ProxyAuthorizationHeader.NAME;
    
    public static final String PROXY_REQUIRE = ProxyRequireHeader.NAME; 
    public static final String REQUIRE = RequireHeader.NAME; 
    public static final String CONTENT_DISPOSITION =
        ContentDispositionHeader.NAME;
    
    public static final String SUBJECT = SubjectHeader.NAME; 
    public static final String USER_AGENT = UserAgentHeader.NAME; 
    public static final String WARNING = WarningHeader.NAME; 
    public static final String PRIORITY = PriorityHeader.NAME; 
    public static final String DATE = DateHeader.NAME; 
    public static final String EXPIRES = ExpiresHeader.NAME; 
    public static final String SUPPORTED = SupportedHeader.NAME; 
    public static final String AUTHENTICATION_INFO =
        AuthenticationInfoHeader.NAME;
    
    public static final String REPLY_TO = ReplyToHeader.NAME; 
    public static final String RACK = RAckHeader.NAME; 
    public static final String RSEQ = RSeqHeader.NAME; 
    public static final String REASON = ReasonHeader.NAME; 
    public static final String SUBSCRIPTION_STATE =
        SubscriptionStateHeader.NAME;
    
    public static final String EVENT = EventHeader.NAME; 
    public static final String ALLOW_EVENTS = AllowEventsHeader.NAME; 

    public static final String SIP_ETAG = SIPETagHeader.NAME; 
    public static final String SIP_IF_MATCH = SIPIfMatchHeader.NAME; 

    
    public static final String REFERRED_BY = ReferredByHeader.NAME; 
    public static final String SESSION_EXPIRES = SessionExpiresHeader.NAME; 
    public static final String MIN_SE = MinSEHeader.NAME; 
    public static final String REPLACES = ReplacesHeader.NAME; 
    public static final String JOIN = JoinHeader.NAME; 

}
