package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.parser.ims.*;
import gov.nist.javax.sip.header.ims.*;
import java.util.Hashtable;
import java.lang.reflect.*;
import javax.sip.header.*;
import java.text.ParseException;
import gov.nist.core.*;
import gov.nist.javax.sip.header.extensions.*;
import gov.nist.javax.sip.header.SIPHeaderNamesCache;
import gov.nist.javax.sip.parser.extensions.*;

public class ParserFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.371 -0400", hash_original_method = "402FA7B6FCFC84B93C7F2F3C6D2A34EC", hash_generated_method = "402FA7B6FCFC84B93C7F2F3C6D2A34EC")
    public ParserFactory ()
    {
        
    }


        public static HeaderParser createParser(String line) throws ParseException {
        String headerName = Lexer.getHeaderName(line);
        String headerValue = Lexer.getHeaderValue(line);
        if (headerName == null || headerValue == null)
            throw new ParseException("The header name or value is null", 0);
        Class parserClass = (Class) parserTable.get(SIPHeaderNamesCache.toLowerCase(headerName));
        if (parserClass != null) {
            try {
                Constructor cons = (Constructor) parserConstructorCache.get(parserClass);
                if (cons == null) {
                    cons = parserClass.getConstructor(constructorArgs);
                    parserConstructorCache.put(parserClass, cons);
                }
                Object[] args = new Object[1];
                args[0] = line;
                HeaderParser retval = (HeaderParser) cons.newInstance(args);
                return retval;
            } catch (Exception ex) {
                InternalErrorHandler.handleException(ex);
                return null; 
            }
        } else {
            return new HeaderParser(line);
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.372 -0400", hash_original_field = "A204131F65AC451FEF76680B6546BBD2", hash_generated_field = "0A3C66CA4CD5AF69A34601C4EB5A6186")

    private static Hashtable<String,Class<? extends HeaderParser>> parserTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.372 -0400", hash_original_field = "C8F73AA9D5B2B8D2288DBE7416221D5D", hash_generated_field = "AA78F4096AC7D2050F7D84F484AF823F")

    private static Class[] constructorArgs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.372 -0400", hash_original_field = "BDC958E88250938150F7CF03A26186B5", hash_generated_field = "DDE7A2912B25508540047823ADE279C8")

    private static Hashtable parserConstructorCache;
    static {
        parserTable = new Hashtable<String,Class<? extends HeaderParser>>();
        parserConstructorCache = new Hashtable();
        constructorArgs = new Class[1];
        constructorArgs[0] = String.class;
        parserTable.put(ReplyToHeader.NAME.toLowerCase(), ReplyToParser.class);
        parserTable.put(
            InReplyToHeader.NAME.toLowerCase(),
            InReplyToParser.class);
        parserTable.put(
            AcceptEncodingHeader.NAME.toLowerCase(),
            AcceptEncodingParser.class);
        parserTable.put(
            AcceptLanguageHeader.NAME.toLowerCase(),
            AcceptLanguageParser.class);
        parserTable.put("t", ToParser.class);
        parserTable.put(ToHeader.NAME.toLowerCase(), ToParser.class);
        parserTable.put(FromHeader.NAME.toLowerCase(), FromParser.class);
        parserTable.put("f", FromParser.class);
        parserTable.put(CSeqHeader.NAME.toLowerCase(), CSeqParser.class);
        parserTable.put(ViaHeader.NAME.toLowerCase(), ViaParser.class);
        parserTable.put("v", ViaParser.class);
        parserTable.put(ContactHeader.NAME.toLowerCase(), ContactParser.class);
        parserTable.put("m", ContactParser.class);
        parserTable.put(
            ContentTypeHeader.NAME.toLowerCase(),
            ContentTypeParser.class);
        parserTable.put("c", ContentTypeParser.class);
        parserTable.put(
            ContentLengthHeader.NAME.toLowerCase(),
            ContentLengthParser.class);
        parserTable.put("l", ContentLengthParser.class);
        parserTable.put(
            AuthorizationHeader.NAME.toLowerCase(),
            AuthorizationParser.class);
        parserTable.put(
            WWWAuthenticateHeader.NAME.toLowerCase(),
            WWWAuthenticateParser.class);
        parserTable.put(CallIdHeader.NAME.toLowerCase(), CallIDParser.class);
        parserTable.put("i", CallIDParser.class);
        parserTable.put(RouteHeader.NAME.toLowerCase(), RouteParser.class);
        parserTable.put(
            RecordRouteHeader.NAME.toLowerCase(),
            RecordRouteParser.class);
        parserTable.put(DateHeader.NAME.toLowerCase(), DateParser.class);
        parserTable.put(
            ProxyAuthorizationHeader.NAME.toLowerCase(),
            ProxyAuthorizationParser.class);
        parserTable.put(
            ProxyAuthenticateHeader.NAME.toLowerCase(),
            ProxyAuthenticateParser.class);
        parserTable.put(
            RetryAfterHeader.NAME.toLowerCase(),
            RetryAfterParser.class);
        parserTable.put(RequireHeader.NAME.toLowerCase(), RequireParser.class);
        parserTable.put(
            ProxyRequireHeader.NAME.toLowerCase(),
            ProxyRequireParser.class);
        parserTable.put(
            TimeStampHeader.NAME.toLowerCase(),
            TimeStampParser.class);
        parserTable.put(
            UnsupportedHeader.NAME.toLowerCase(),
            UnsupportedParser.class);
        parserTable.put(
            UserAgentHeader.NAME.toLowerCase(),
            UserAgentParser.class);
        parserTable.put(
            SupportedHeader.NAME.toLowerCase(),
            SupportedParser.class);
        parserTable.put("k", SupportedParser.class);
        parserTable.put(ServerHeader.NAME.toLowerCase(), ServerParser.class);
        parserTable.put(SubjectHeader.NAME.toLowerCase(), SubjectParser.class);
        parserTable.put( "s", SubjectParser.class); 
        parserTable.put(
            SubscriptionStateHeader.NAME.toLowerCase(),
            SubscriptionStateParser.class);
        parserTable.put(
            MaxForwardsHeader.NAME.toLowerCase(),
            MaxForwardsParser.class);
        parserTable.put(
            MimeVersionHeader.NAME.toLowerCase(),
            MimeVersionParser.class);
        parserTable.put(
            MinExpiresHeader.NAME.toLowerCase(),
            MinExpiresParser.class);
        parserTable.put(
            OrganizationHeader.NAME.toLowerCase(),
            OrganizationParser.class);
        parserTable.put(
            PriorityHeader.NAME.toLowerCase(),
            PriorityParser.class);
        parserTable.put(RAckHeader.NAME.toLowerCase(), RAckParser.class);
        parserTable.put(RSeqHeader.NAME.toLowerCase(), RSeqParser.class);
        parserTable.put(ReasonHeader.NAME.toLowerCase(), ReasonParser.class);
        parserTable.put(WarningHeader.NAME.toLowerCase(), WarningParser.class);
        parserTable.put(ExpiresHeader.NAME.toLowerCase(), ExpiresParser.class);
        parserTable.put(EventHeader.NAME.toLowerCase(), EventParser.class);
        parserTable.put("o", EventParser.class);
        parserTable.put(
            ErrorInfoHeader.NAME.toLowerCase(),
            ErrorInfoParser.class);
        parserTable.put(
            ContentLanguageHeader.NAME.toLowerCase(),
            ContentLanguageParser.class);
        parserTable.put(
            ContentEncodingHeader.NAME.toLowerCase(),
            ContentEncodingParser.class);
        parserTable.put("e", ContentEncodingParser.class);
        parserTable.put(
            ContentDispositionHeader.NAME.toLowerCase(),
            ContentDispositionParser.class);
        parserTable.put(
            CallInfoHeader.NAME.toLowerCase(),
            CallInfoParser.class);
        parserTable.put(
            AuthenticationInfoHeader.NAME.toLowerCase(),
            AuthenticationInfoParser.class);
        parserTable.put(AllowHeader.NAME.toLowerCase(), AllowParser.class);
        parserTable.put(
            AllowEventsHeader.NAME.toLowerCase(),
            AllowEventsParser.class);
        parserTable.put("u", AllowEventsParser.class);
        parserTable.put(
            AlertInfoHeader.NAME.toLowerCase(),
            AlertInfoParser.class);
        parserTable.put(AcceptHeader.NAME.toLowerCase(), AcceptParser.class);
        parserTable.put(ReferToHeader.NAME.toLowerCase(), ReferToParser.class);
        parserTable.put("r", ReferToParser.class);
        parserTable.put(SIPETagHeader.NAME.toLowerCase(), SIPETagParser.class);
        parserTable.put(SIPIfMatchHeader.NAME.toLowerCase(), SIPIfMatchParser.class);
        parserTable.put(PAccessNetworkInfoHeader.NAME.toLowerCase(), PAccessNetworkInfoParser.class);
        parserTable.put(PAssertedIdentityHeader.NAME.toLowerCase(), PAssertedIdentityParser.class);
        parserTable.put(PPreferredIdentityHeader.NAME.toLowerCase(), PPreferredIdentityParser.class);
        parserTable.put(PChargingVectorHeader.NAME.toLowerCase(), PChargingVectorParser.class);
        parserTable.put(PChargingFunctionAddressesHeader.NAME.toLowerCase(), PChargingFunctionAddressesParser.class);
        parserTable.put(PMediaAuthorizationHeader.NAME.toLowerCase(), PMediaAuthorizationParser.class);
        parserTable.put(PathHeader.NAME.toLowerCase(), PathParser.class);
        parserTable.put(PrivacyHeader.NAME.toLowerCase(), PrivacyParser.class);
        parserTable.put(ServiceRouteHeader.NAME.toLowerCase(), ServiceRouteParser.class);
        parserTable.put(PVisitedNetworkIDHeader.NAME.toLowerCase(), PVisitedNetworkIDParser.class);
        parserTable.put(PAssociatedURIHeader.NAME.toLowerCase(), PAssociatedURIParser.class);
        parserTable.put(PCalledPartyIDHeader.NAME.toLowerCase(), PCalledPartyIDParser.class);
        parserTable.put(SecurityServerHeader.NAME.toLowerCase(), SecurityServerParser.class);
        parserTable.put(SecurityClientHeader.NAME.toLowerCase(), SecurityClientParser.class);
        parserTable.put(SecurityVerifyHeader.NAME.toLowerCase(), SecurityVerifyParser.class);
        parserTable.put(ReferredBy.NAME.toLowerCase(), ReferredByParser.class);
        parserTable.put("b", ReferToParser.class);
        parserTable.put(SessionExpires.NAME.toLowerCase(), SessionExpiresParser.class);
        parserTable.put("x", SessionExpiresParser.class);
        parserTable.put(MinSE.NAME.toLowerCase(), MinSEParser.class);
        parserTable.put(Replaces.NAME.toLowerCase(), ReplacesParser.class);
        parserTable.put(Join.NAME.toLowerCase(), JoinParser.class);
        parserTable.put(References.NAME.toLowerCase(), ReferencesParser.class);
    }
    
}

