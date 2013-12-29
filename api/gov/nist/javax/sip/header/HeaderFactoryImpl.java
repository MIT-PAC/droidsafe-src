package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.address.GenericURI;
import gov.nist.javax.sip.header.extensions.Join;
import gov.nist.javax.sip.header.extensions.JoinHeader;
import gov.nist.javax.sip.header.extensions.MinSE;
import gov.nist.javax.sip.header.extensions.References;
import gov.nist.javax.sip.header.extensions.ReferencesHeader;
import gov.nist.javax.sip.header.extensions.ReferredBy;
import gov.nist.javax.sip.header.extensions.ReferredByHeader;
import gov.nist.javax.sip.header.extensions.Replaces;
import gov.nist.javax.sip.header.extensions.ReplacesHeader;
import gov.nist.javax.sip.header.extensions.SessionExpires;
import gov.nist.javax.sip.header.extensions.SessionExpiresHeader;
import gov.nist.javax.sip.header.ims.PAccessNetworkInfo;
import gov.nist.javax.sip.header.ims.PAccessNetworkInfoHeader;
import gov.nist.javax.sip.header.ims.PAssertedIdentity;
import gov.nist.javax.sip.header.ims.PAssertedIdentityHeader;
import gov.nist.javax.sip.header.ims.PAssertedService;
import gov.nist.javax.sip.header.ims.PAssertedServiceHeader;
import gov.nist.javax.sip.header.ims.PAssociatedURI;
import gov.nist.javax.sip.header.ims.PAssociatedURIHeader;
import gov.nist.javax.sip.header.ims.PCalledPartyID;
import gov.nist.javax.sip.header.ims.PCalledPartyIDHeader;
import gov.nist.javax.sip.header.ims.PChargingFunctionAddresses;
import gov.nist.javax.sip.header.ims.PChargingFunctionAddressesHeader;
import gov.nist.javax.sip.header.ims.PChargingVector;
import gov.nist.javax.sip.header.ims.PChargingVectorHeader;
import gov.nist.javax.sip.header.ims.PMediaAuthorization;
import gov.nist.javax.sip.header.ims.PMediaAuthorizationHeader;
import gov.nist.javax.sip.header.ims.PPreferredIdentity;
import gov.nist.javax.sip.header.ims.PPreferredIdentityHeader;
import gov.nist.javax.sip.header.ims.PPreferredService;
import gov.nist.javax.sip.header.ims.PPreferredServiceHeader;
import gov.nist.javax.sip.header.ims.PProfileKey;
import gov.nist.javax.sip.header.ims.PProfileKeyHeader;
import gov.nist.javax.sip.header.ims.PServedUser;
import gov.nist.javax.sip.header.ims.PServedUserHeader;
import gov.nist.javax.sip.header.ims.PUserDatabase;
import gov.nist.javax.sip.header.ims.PUserDatabaseHeader;
import gov.nist.javax.sip.header.ims.PVisitedNetworkID;
import gov.nist.javax.sip.header.ims.PVisitedNetworkIDHeader;
import gov.nist.javax.sip.header.ims.Path;
import gov.nist.javax.sip.header.ims.PathHeader;
import gov.nist.javax.sip.header.ims.Privacy;
import gov.nist.javax.sip.header.ims.PrivacyHeader;
import gov.nist.javax.sip.header.ims.SecurityClient;
import gov.nist.javax.sip.header.ims.SecurityClientHeader;
import gov.nist.javax.sip.header.ims.SecurityServer;
import gov.nist.javax.sip.header.ims.SecurityServerHeader;
import gov.nist.javax.sip.header.ims.SecurityVerify;
import gov.nist.javax.sip.header.ims.SecurityVerifyHeader;
import gov.nist.javax.sip.header.ims.ServiceRoute;
import gov.nist.javax.sip.header.ims.ServiceRouteHeader;
import gov.nist.javax.sip.parser.RequestLineParser;
import gov.nist.javax.sip.parser.StatusLineParser;
import gov.nist.javax.sip.parser.StringMsgParser;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.sip.InvalidArgumentException;
import javax.sip.address.Address;
import javax.sip.address.URI;
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
import javax.sip.header.ExtensionHeader;
import javax.sip.header.FromHeader;
import javax.sip.header.Header;
import javax.sip.header.HeaderFactory;
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
import javax.sip.header.ReferToHeader;
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






public class HeaderFactoryImpl implements HeaderFactory, HeaderFactoryExt {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.215 -0500", hash_original_field = "8C10C55A9BEAD35C9C3822ED5A78B55A", hash_generated_field = "0D2878F1D6B0CD805C869443DA7FE75E")

    private boolean stripAddressScopeZones = false;
    
    


    //////////////////////////////////////////////////////////
    // Constructor
    //////////////////////////////////////////////////////////
    /**
     * Default constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.316 -0500", hash_original_method = "EA4ABB94B4CFEF029E31D8F450F44C66", hash_generated_method = "7C59928D1BF5C24D54A1BBDB8351FCF2")
    public HeaderFactoryImpl() {
        stripAddressScopeZones
            = Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
    }

    /**
     * Set pretty encoding on / off.
     * This splits up via headers into multiple lines for readability ( better for
     * debugging ).
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.216 -0500", hash_original_method = "9BEACA878DCF694953AD8141227DB60F", hash_generated_method = "F632BF1452A4CEE092D75156519D0C5E")
    public void setPrettyEncoding(boolean flag) {
        SIPHeaderList.setPrettyEncode(flag);
    }

    /**
    * Creates a new AcceptEncodingHeader based on the newly supplied encoding
    * value.
    *
    * @param encoding - the new string containing the encoding value.
    * @throws ParseException which signals that an error has been reached
    * unexpectedly while parsing the encoding value.
    * @return the newly created AcceptEncodingHeader object.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.217 -0500", hash_original_method = "58113BBBA3D76308CFB19C46D0FF7A27", hash_generated_method = "4ADDCA2C43F67377B35C89EE4966ED54")
    public AcceptEncodingHeader createAcceptEncodingHeader(String encoding)
        throws ParseException {
        if (encoding == null)
            throw new NullPointerException("the encoding parameter is null");
        AcceptEncoding acceptEncoding = new AcceptEncoding();
        acceptEncoding.setEncoding(encoding);
        return acceptEncoding;
    }

    /**
     * Creates a new AcceptHeader based on the newly supplied contentType and
     * contentSubType values.
     *
     * @param contentType The new string content type value.
     * @param contentSubType The new string content sub-type value.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the content type or content subtype value.
     * @return the newly created AcceptHeader object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.218 -0500", hash_original_method = "3FEA70547EDCF31E1AA086D3362AC6CE", hash_generated_method = "4B1983FBB805BAAF80775A2DCEAE6D38")
    public AcceptHeader createAcceptHeader(
        String contentType,
        String contentSubType)
        throws ParseException {
        if (contentType == null || contentSubType == null)
            throw new NullPointerException("contentType or subtype is null ");
        Accept accept = new Accept();
        accept.setContentType(contentType);
        accept.setContentSubType(contentSubType);

        return accept;
    }

    /**
     * Creates a new AcceptLanguageHeader based on the newly supplied
     * language value.
     *
     * @param language - the new Locale value of the language
     * @return the newly created AcceptLanguageHeader object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.219 -0500", hash_original_method = "5AF5E9D92982780781CC81035C3C1529", hash_generated_method = "24ECF7D91B9CA37241100F960164BEB1")
    public AcceptLanguageHeader createAcceptLanguageHeader(Locale language) {
        if (language == null)
            throw new NullPointerException("null arg");
        AcceptLanguage acceptLanguage = new AcceptLanguage();
        acceptLanguage.setAcceptLanguage(language);

        return acceptLanguage;
    }

    /**
     * Creates a new AlertInfoHeader based on the newly supplied alertInfo value.
     *
     * @param alertInfo - the new URI value of the alertInfo
     * @return the newly created AlertInfoHeader object.
     * @since v1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.220 -0500", hash_original_method = "3E0D5311E2AF98CBAC12E04C1647AAA5", hash_generated_method = "E6B283644A8BA7769E8D561B4AED32BB")
    public AlertInfoHeader createAlertInfoHeader(URI alertInfo) {
        if (alertInfo == null)
            throw new NullPointerException("null arg alertInfo");
        AlertInfo a = new AlertInfo();
        a.setAlertInfo(alertInfo);
        return a;
    }

    /**
     * Creates a new AllowEventsHeader based on the newly supplied event type
     * value.
     *
     * @param eventType - the new string containing the eventType value.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the eventType value.
     * @return the newly created AllowEventsHeader object.
     * @since v1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.221 -0500", hash_original_method = "7A8DE3D3022A3669E75EC61B4D0B5F19", hash_generated_method = "DEA02F1853780F13659D188767E49E7A")
    public AllowEventsHeader createAllowEventsHeader(String eventType)
        throws ParseException {
        if (eventType == null)
            throw new NullPointerException("null arg eventType");
        AllowEvents allowEvents = new AllowEvents();
        allowEvents.setEventType(eventType);
        return allowEvents;
    }

    /**
     * Creates a new AllowHeader based on the newly supplied method value.
     *
     * @param method - the new string containing the method value.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the method value.
     * @return the newly created AllowHeader object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.222 -0500", hash_original_method = "C562ECE8E2158A54C27A4525D88FEA63", hash_generated_method = "63B9FB84CB44C042143E43DCB8FC5923")
    public AllowHeader createAllowHeader(String method) throws ParseException {
        if (method == null)
            throw new NullPointerException("null arg method");
        Allow allow = new Allow();
        allow.setMethod(method);

        return allow;
    }

    /**
     * Creates a new AuthenticationInfoHeader based on the newly supplied
     * response value.
     *
     * @param response - the new string value of the response.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the response value.
     * @return the newly created AuthenticationInfoHeader object.
     * @since v1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.223 -0500", hash_original_method = "E72D81A306A857A102E9D4437AB18CA6", hash_generated_method = "7865E9FC50251318513C5BE7BE5FFC44")
    public AuthenticationInfoHeader createAuthenticationInfoHeader(String response)
        throws ParseException {
        if (response == null)
            throw new NullPointerException("null arg response");
        AuthenticationInfo auth = new AuthenticationInfo();
        auth.setResponse(response);

        return auth;
    }

    /**
     * Creates a new AuthorizationHeader based on the newly supplied
     * scheme value.
     *
     * @param scheme - the new string value of the scheme.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the scheme value.
     * @return the newly created AuthorizationHeader object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.225 -0500", hash_original_method = "F250EC80C8CD1CBE5FF237A98CBD8CD0", hash_generated_method = "CB87B5E2DA0BE74731188AC23FFB4D66")
    public AuthorizationHeader createAuthorizationHeader(String scheme)
        throws ParseException {
        if (scheme == null)
            throw new NullPointerException("null arg scheme ");
        Authorization auth = new Authorization();
        auth.setScheme(scheme);

        return auth;
    }

    /**
     * Creates a new CSeqHeader based on the newly supplied sequence number and
     * method values.
     *
     * @param sequenceNumber - the new integer value of the sequence number.
     * @param method - the new string value of the method.
     * @throws InvalidArgumentException if supplied sequence number is less
     * than zero.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the method value.
     * @return the newly created CSeqHeader object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.226 -0500", hash_original_method = "9707416B5040BCEA07917ADCBF33DA70", hash_generated_method = "BD36747DA6AC46D7BD2660400A684EF2")
    public CSeqHeader createCSeqHeader( long sequenceNumber, String method)
        throws ParseException, InvalidArgumentException {
        if (sequenceNumber < 0)
            throw new InvalidArgumentException("bad arg " + sequenceNumber);
        if (method == null)
            throw new NullPointerException("null arg method");
        CSeq cseq = new CSeq();
        cseq.setMethod(method);
        cseq.setSeqNumber(sequenceNumber);

        return cseq;
    }

    /**
     * For backwards compatibility, also accept int
     * @deprecated
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.228 -0500", hash_original_method = "332D5DD16F528ACCDED76BFE26F4F243", hash_generated_method = "116978D5ECE6F115C01EBBBAF952AACA")
    public CSeqHeader createCSeqHeader( int sequenceNumber, String method)
        throws ParseException, InvalidArgumentException {
        return this.createCSeqHeader( (long) sequenceNumber, method );
    }

    /**
     * Creates a new CallIdHeader based on the newly supplied callId value.
     *
     * @param callId - the new string value of the call-id.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the callId value.
     * @return the newly created CallIdHeader object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.229 -0500", hash_original_method = "0CB560808F252622C176039BC6E86FF7", hash_generated_method = "60C55E1F0F57974C53272E8EC79F9AE8")
    public CallIdHeader createCallIdHeader(String callId)
        throws ParseException {
        if (callId == null)
            throw new NullPointerException("null arg callId");
        CallID c = new CallID();
        c.setCallId(callId);
        return c;
    }

    /**
     * Creates a new CallInfoHeader based on the newly supplied callInfo value.
     *
     * @param callInfo The new string value of the callInfo.
     * @return the newly created CallInfoHeader object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.230 -0500", hash_original_method = "8867B6CA9EB8DB8DAA3F991D7B0AD5D9", hash_generated_method = "1651370205F0B14DD8D601CDE34C8D81")
    public CallInfoHeader createCallInfoHeader(URI callInfo) {
        if (callInfo == null)
            throw new NullPointerException("null arg callInfo");

        CallInfo c = new CallInfo();
        c.setInfo(callInfo);
        return c;
    }

    /**
     * Creates a new ContactHeader based on the newly supplied address value.
     *
     * @param address - the new Address value of the address.
     * @return the newly created ContactHeader object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.231 -0500", hash_original_method = "45EF0D9994A51A34EA10DF4A185E8F21", hash_generated_method = "2619631381D97BC4F9BCEC4E74E8BD78")
    public ContactHeader createContactHeader(Address address) {
        if (address == null)
            throw new NullPointerException("null arg address");
        Contact contact = new Contact();
        contact.setAddress(address);

        return contact;
    }

    /**
    * Creates a new wildcard ContactHeader. This is used in Register requests
    * to indicate to the server that it should remove all locations the
    * at which the user is currently available. This implies that the
    * following conditions are met:
    * <ul>
    * <li><code>ContactHeader.getAddress.getAddress.getUserInfo() == *;</code>
    * <li><code>ContactHeader.getAddress.getAddress.isWildCard() == true;</code>
    * <li><code>ContactHeader.getExpires() == 0;</code>
    * </ul>
    *
    * @return the newly created wildcard ContactHeader.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.232 -0500", hash_original_method = "5873C88FB18B86DA11D334099F5AE064", hash_generated_method = "A09433F3D27BC274B9CEE81390A27CFC")
    public ContactHeader createContactHeader() {
        Contact contact = new Contact();
        contact.setWildCardFlag(true);
        contact.setExpires(0);

        return contact;
    }

    /**
     * Creates a new ContentDispositionHeader based on the newly supplied
     * contentDisposition value.
     *
     * @param contentDisposition - the new string value of the contentDisposition.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the contentDisposition value.
     * @return the newly created ContentDispositionHeader object.
     * @since v1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.233 -0500", hash_original_method = "CC352C2425871DC27A0C55CF39D4ABAB", hash_generated_method = "C7B47C8513D14DF9685682FBD153F45C")
    public ContentDispositionHeader createContentDispositionHeader(String contentDisposition)
        throws ParseException {
        if (contentDisposition == null)
            throw new NullPointerException("null arg contentDisposition");
        ContentDisposition c = new ContentDisposition();
        c.setDispositionType(contentDisposition);

        return c;
    }

    /**
    * Creates a new ContentEncodingHeader based on the newly supplied encoding
    * value.
    *
    * @param encoding - the new string containing the encoding value.
    * @throws ParseException which signals that an error has been reached
    * unexpectedly while parsing the encoding value.
    * @return the newly created ContentEncodingHeader object.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.234 -0500", hash_original_method = "090104ADCCDA5F259494E038435257D1", hash_generated_method = "44967D4371B86643EEA5A7B1E742DF94")
    public ContentEncodingHeader createContentEncodingHeader(String encoding)
        throws ParseException {
        if (encoding == null)
            throw new NullPointerException("null encoding");
        ContentEncoding c = new ContentEncoding();
        c.setEncoding(encoding);

        return c;
    }

    /**
     * Creates a new ContentLanguageHeader based on the newly supplied
     * contentLanguage value.
     *
     * @param contentLanguage - the new Locale value of the contentLanguage.
     * @return the newly created ContentLanguageHeader object.
     * @since v1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.235 -0500", hash_original_method = "CD027E2457CF527330FF9F4C0A972B91", hash_generated_method = "A01A741425EF2E0926BFA778BF4AFACC")
    public ContentLanguageHeader createContentLanguageHeader(Locale contentLanguage) {
        if (contentLanguage == null)
            throw new NullPointerException("null arg contentLanguage");
        ContentLanguage c = new ContentLanguage();
        c.setContentLanguage(contentLanguage);

        return c;
    }

    /**
     * Creates a new CSeqHeader based on the newly supplied contentLength value.
     *
     * @param contentLength - the new integer value of the contentLength.
     * @throws InvalidArgumentException if supplied contentLength is less
     * than zero.
     * @return the newly created ContentLengthHeader object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.236 -0500", hash_original_method = "DA3B5EC62F3E30804B07AD592D303E3E", hash_generated_method = "C581C5630CD37B1611A79974E1D1D0BE")
    public ContentLengthHeader createContentLengthHeader(int contentLength)
        throws InvalidArgumentException {
        if (contentLength < 0)
            throw new InvalidArgumentException("bad contentLength");
        ContentLength c = new ContentLength();
        c.setContentLength(contentLength);

        return c;
    }

    /**
     * Creates a new ContentTypeHeader based on the newly supplied contentType and
     * contentSubType values.
     *
     * @param contentType - the new string content type value.
     * @param contentSubType - the new string content sub-type value.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the content type or content subtype value.
     * @return the newly created ContentTypeHeader object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.238 -0500", hash_original_method = "BF42B4FF2E7F96D2FA4773C6E514B79D", hash_generated_method = "CB2C94B316DEDEA4A30B30A937886F41")
    public ContentTypeHeader createContentTypeHeader(
        String contentType,
        String contentSubType)
        throws ParseException {
        if (contentType == null || contentSubType == null)
            throw new NullPointerException("null contentType or subType");
        ContentType c = new ContentType();
        c.setContentType(contentType);
        c.setContentSubType(contentSubType);
        return c;
    }

    /**
    * Creates a new DateHeader based on the newly supplied date value.
    *
    * @param date - the new Calender value of the date.
    * @return the newly created DateHeader object.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.239 -0500", hash_original_method = "F3D0948AB2AB5DCB4D46B0F9C4754A1D", hash_generated_method = "2DA6945439286EF6E87FA0E912C22609")
    public DateHeader createDateHeader(Calendar date) {
        SIPDateHeader d = new SIPDateHeader();
        if (date == null)
            throw new NullPointerException("null date");
        d.setDate(date);

        return d;
    }

    /**
     * Creates a new EventHeader based on the newly supplied eventType value.
     *
     * @param eventType - the new string value of the eventType.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the eventType value.
     * @return the newly created EventHeader object.
     * @since v1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.240 -0500", hash_original_method = "7FD58797EECF83FE34BEE1F3B093BC46", hash_generated_method = "3712E6BE7ED8D8AF9BBA7E5263530F4C")
    public EventHeader createEventHeader(String eventType)
        throws ParseException {
        if (eventType == null)
            throw new NullPointerException("null eventType");
        Event event = new Event();
        event.setEventType(eventType);

        return event;
    }

    /**
     * Creates a new ExpiresHeader based on the newly supplied expires value.
     *
     * @param expires - the new integer value of the expires.
     * @throws InvalidArgumentException if supplied expires is less
     * than zero.
     * @return the newly created ExpiresHeader object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.241 -0500", hash_original_method = "1A307AD1BD02E7BD6299AF40D811E5D5", hash_generated_method = "08918995EB82EDD3A70D4A64ED663891")
    public ExpiresHeader createExpiresHeader(int expires)
        throws InvalidArgumentException {
        if (expires < 0)
            throw new InvalidArgumentException("bad value " + expires);
        Expires e = new Expires();
        e.setExpires(expires);

        return e;
    }

    /**
     * Creates a new ExtensionHeader based on the newly supplied name and
     * value values.
     *
     * @param name - the new string name of the ExtensionHeader value.
     * @param value - the new string value of the ExtensionHeader.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the name or value values.
     * @return the newly created ExtensionHeader object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.242 -0500", hash_original_method = "C38CB4735B94E96E0C6FB81DC8E60CBF", hash_generated_method = "5C1F890CCF751902F2531EF1594E7667")
    public javax.sip.header.ExtensionHeader createExtensionHeader(
        String name,
        String value)
        throws ParseException {
        if (name == null)
            throw new NullPointerException("bad name");

        gov.nist.javax.sip.header.ExtensionHeaderImpl ext =
            new gov.nist.javax.sip.header.ExtensionHeaderImpl();
        ext.setName(name);
        ext.setValue(value);

        return ext;
    }

    /**
     * Creates a new FromHeader based on the newly supplied address and
     * tag values.
     *
     * @param address - the new Address object of the address.
     * @param tag - the new string value of the tag.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the tag value.
     * @return the newly created FromHeader object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.243 -0500", hash_original_method = "E3876C81F77C4C65824998CB51869857", hash_generated_method = "1171480E4D0A7406002DC8F060F5B518")
    public FromHeader createFromHeader(Address address, String tag)
        throws ParseException {
        if (address == null)
            throw new NullPointerException("null address arg");
        From from = new From();
        from.setAddress(address);
        if (tag != null)
            from.setTag(tag);

        return from;
    }

    /**
     * Creates a new InReplyToHeader based on the newly supplied callId
     * value.
     *
     * @param callId - the new string containing the callId value.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the callId value.
     * @return the newly created InReplyToHeader object.
     * @since v1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.244 -0500", hash_original_method = "4DE074146D6A81FB201A39A399764E9F", hash_generated_method = "F7FB78044DCFD0CD6B05FD966C0EA7AC")
    public InReplyToHeader createInReplyToHeader(String callId)
        throws ParseException {
        if (callId == null)
            throw new NullPointerException("null callId arg");
        InReplyTo inReplyTo = new InReplyTo();
        inReplyTo.setCallId(callId);

        return inReplyTo;
    }
    /**
    * Creates a new MaxForwardsHeader based on the newly
    * supplied maxForwards value.
    *
    * @param maxForwards The new integer value of the maxForwards.
    * @throws InvalidArgumentException if supplied maxForwards is less
    * than zero or greater than 255.
    * @return the newly created MaxForwardsHeader object.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.245 -0500", hash_original_method = "2B62AE770A28023C5424C7B7718E4BD4", hash_generated_method = "452226191162440A69C61CCC2956DB5F")
    public MaxForwardsHeader createMaxForwardsHeader(int maxForwards)
        throws InvalidArgumentException {
        if (maxForwards < 0 || maxForwards > 255)
            throw new InvalidArgumentException(
                "bad maxForwards arg " + maxForwards);
        MaxForwards m = new MaxForwards();
        m.setMaxForwards(maxForwards);

        return m;
    }

    /**
     * Creates a new MimeVersionHeader based on the newly
     * supplied mimeVersion value.
     *
     * @param majorVersion - the new integer value of the majorVersion.
     * @param minorVersion - the new integer value of the minorVersion.
     * @throws InvalidArgumentException if supplied mimeVersion is less
     * than zero.
     * @return the newly created MimeVersionHeader object.
     * @since v1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.246 -0500", hash_original_method = "623C745ED7578EC4227F3B15A38B5D4A", hash_generated_method = "B10F93C097FE82E158B0DB65EFE2067A")
    public MimeVersionHeader createMimeVersionHeader(
        int majorVersion,
        int minorVersion)
        throws InvalidArgumentException {
        if (majorVersion < 0 || minorVersion < 0)
            throw new javax.sip.InvalidArgumentException(
                "bad major/minor version");
        MimeVersion m = new MimeVersion();
        m.setMajorVersion(majorVersion);
        m.setMinorVersion(minorVersion);

        return m;
    }

    /**
     * Creates a new MinExpiresHeader based on the newly supplied minExpires value.
     *
     * @param minExpires - the new integer value of the minExpires.
     * @throws InvalidArgumentException if supplied minExpires is less
     * than zero.
     * @return the newly created MinExpiresHeader object.
     * @since v1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.247 -0500", hash_original_method = "F897D0FECB8A8CC74BFA504858C91B42", hash_generated_method = "20D805C70E663C57C461557042E0E3B3")
    public MinExpiresHeader createMinExpiresHeader(int minExpires)
        throws InvalidArgumentException {
        if (minExpires < 0)
            throw new InvalidArgumentException("bad minExpires " + minExpires);
        MinExpires min = new MinExpires();
        min.setExpires(minExpires);

        return min;
    }

    /**
     * Creates a new MinSEHeader based on the newly supplied expires value.
     *
     * @param expires - the new integer value of the expires.
     * @throws InvalidArgumentException if supplied expires is less
     * than zero.
     * @return the newly created ExpiresHeader object.
     *
     * TODO: Once interfaces are in javax, change the type to MinSEHeader
     * and add to HeaderFactory. - pmusgrave
     *
     * pmusgrave
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.249 -0500", hash_original_method = "8EE941BB2D8E39A517F98D1ED3613B4D", hash_generated_method = "0C3FA5BA462F527FE7CBB3A7D0B35421")
    public ExtensionHeader createMinSEHeader(int expires)
        throws InvalidArgumentException {
        if (expires < 0)
            throw new InvalidArgumentException("bad value " + expires);
        MinSE e = new MinSE();
        e.setExpires(expires);

        return e;
    }

    /**
     * Creates a new OrganizationHeader based on the newly supplied
     * organization value.
     *
     * @param organization - the new string value of the organization.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the organization value.
     * @return the newly created OrganizationHeader object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.250 -0500", hash_original_method = "2F5DB311D13CB6144CC7B49271775C33", hash_generated_method = "41AF39E66C83ED832AC9F229D6F9164F")
    public OrganizationHeader createOrganizationHeader(String organization)
        throws ParseException {
        if (organization == null)
            throw new NullPointerException("bad organization arg");
        Organization o = new Organization();
        o.setOrganization(organization);

        return o;
    }

    /**
     * Creates a new PriorityHeader based on the newly supplied priority value.
     *
     * @param priority - the new string value of the priority.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the priority value.
     * @return the newly created PriorityHeader object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.251 -0500", hash_original_method = "085951AB405380C6C60E1EC174C5C855", hash_generated_method = "16376C82AD540DE0B3FF145F4013D4E5")
    public PriorityHeader createPriorityHeader(String priority)
        throws ParseException {
        if (priority == null)
            throw new NullPointerException("bad priority arg");
        Priority p = new Priority();
        p.setPriority(priority);

        return p;
    }

    /**
     * Creates a new ProxyAuthenticateHeader based on the newly supplied
     * scheme value.
     *
     * @param scheme - the new string value of the scheme.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the scheme value.
     * @return the newly created ProxyAuthenticateHeader object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.252 -0500", hash_original_method = "E2D1E713D6EFBD9B5EF73CE359255B39", hash_generated_method = "1A53B31ADE594DF2C681C945212BEE94")
    public ProxyAuthenticateHeader createProxyAuthenticateHeader(String scheme)
        throws ParseException {
        if (scheme == null)
            throw new NullPointerException("bad scheme arg");
        ProxyAuthenticate p = new ProxyAuthenticate();
        p.setScheme(scheme);

        return p;
    }

    /**
     * Creates a new ProxyAuthorizationHeader based on the newly supplied
     * scheme value.
     *
     * @param scheme - the new string value of the scheme.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the scheme value.
     * @return the newly created ProxyAuthorizationHeader object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.253 -0500", hash_original_method = "E046B5DACDD94AD026F81045FF391CD1", hash_generated_method = "F17286D5428B6A5E43260B1B6BC9CB17")
    public ProxyAuthorizationHeader createProxyAuthorizationHeader(String scheme)
        throws ParseException {
        if (scheme == null)
            throw new NullPointerException("bad scheme arg");
        ProxyAuthorization p = new ProxyAuthorization();
        p.setScheme(scheme);

        return p;
    }

    /**
     * Creates a new ProxyRequireHeader based on the newly supplied optionTag
     * value.
     *
     * @param optionTag - the new string OptionTag value.
     * @return the newly created ProxyRequireHeader object.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the optionTag value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.254 -0500", hash_original_method = "A059B8FD47D8FC83321E2DEF4CB18490", hash_generated_method = "611D9F064A8B84D209095D30B8CFDDB5")
    public ProxyRequireHeader createProxyRequireHeader(String optionTag)
        throws ParseException {
        if (optionTag == null)
            throw new NullPointerException("bad optionTag arg");
        ProxyRequire p = new ProxyRequire();
        p.setOptionTag(optionTag);

        return p;
    }

    /**
     * Creates a new RAckHeader based on the newly supplied rSeqNumber,
     * cSeqNumber and method values.
     *
     * @param rSeqNumber - the new integer value of the rSeqNumber.
     * @param cSeqNumber - the new integer value of the cSeqNumber.
     * @param method - the new string value of the method.
     * @throws InvalidArgumentException if supplied rSeqNumber or cSeqNumber is
     * less than zero or greater than than 2**31-1.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the method value.
     * @return the newly created RAckHeader object.
     * @since v1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.255 -0500", hash_original_method = "42539302BE9490416DF1DC01B8BC3D99", hash_generated_method = "B308AE63B2AE7F6A862BBAB1359FA13C")
    public RAckHeader createRAckHeader(
        long rSeqNumber,
        long cSeqNumber,
        String method)
        throws InvalidArgumentException, ParseException {
        if (method == null)
            throw new NullPointerException("Bad method");
        if (cSeqNumber < 0 || rSeqNumber < 0)
            throw new InvalidArgumentException("bad cseq/rseq arg");
        RAck rack = new RAck();
        rack.setMethod(method);
        rack.setCSequenceNumber(cSeqNumber);
        rack.setRSequenceNumber(rSeqNumber);

        return rack;
    }

    /**
     * @deprecated
     * @see javax.sip.header.HeaderFactory#createRAckHeader(int, int, java.lang.String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.256 -0500", hash_original_method = "B44C2BD23DFFCB51A992C42D93BADE4E", hash_generated_method = "2CADF926ED6409AFC24EC6CAF3D74F33")
    public RAckHeader createRAckHeader(int rSeqNumber, int cSeqNumber, String method) throws InvalidArgumentException, ParseException {

        return createRAckHeader((long)rSeqNumber, (long)cSeqNumber, method);
    }


    /**
     * @deprecated
     * @see javax.sip.header.HeaderFactory#createRSeqHeader(int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.257 -0500", hash_original_method = "38086BF4D4EB3CE5AB4BF7772F8EACF2", hash_generated_method = "AB81220B2482779995348ED5405A3957")
    public RSeqHeader createRSeqHeader(int sequenceNumber) throws InvalidArgumentException {

        return createRSeqHeader((long) sequenceNumber) ;
    }

    /**
     * Creates a new RSeqHeader based on the newly supplied sequenceNumber value.
     *
     * @param sequenceNumber - the new integer value of the sequenceNumber.
     * @throws InvalidArgumentException if supplied sequenceNumber is
     * less than zero or greater than than 2**31-1.
     * @return the newly created RSeqHeader object.
     * @since v1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.258 -0500", hash_original_method = "CA4CA07B31DF6CB609C05636F40DB22F", hash_generated_method = "F1656D64C351B2C62FC72407CC65AFFB")
    public RSeqHeader createRSeqHeader(long sequenceNumber)
        throws InvalidArgumentException {
        if (sequenceNumber < 0)
            throw new InvalidArgumentException(
                "invalid sequenceNumber arg " + sequenceNumber);
        RSeq rseq = new RSeq();
        rseq.setSeqNumber(sequenceNumber);

        return rseq;
    }

    /**
     * Creates a new ReasonHeader based on the newly supplied reason value.
     *
     * @param protocol - the new string value of the protocol.
     * @param cause - the new integer value of the cause.
     * @param text - the new string value of the text.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the protocol, cause or text value.
     * @return the newly created ReasonHeader object.
     * @since v1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.259 -0500", hash_original_method = "57AD0B4E4FE03197F2B52972D6060CBA", hash_generated_method = "40A032A3A8D301529979F4966F793C9E")
    public ReasonHeader createReasonHeader(
        String protocol,
        int cause,
        String text)
        throws InvalidArgumentException, ParseException {
        if (protocol == null)
            throw new NullPointerException("bad protocol arg");
        if (cause < 0)
            throw new InvalidArgumentException("bad cause");
        Reason reason = new Reason();
        reason.setProtocol(protocol);
        reason.setCause(cause);
        reason.setText(text);

        return reason;
    }

    /**
    * Creates a new RecordRouteHeader based on the newly supplied address value.
    *
    * @param address - the new Address object of the address.
    * @return the newly created RecordRouteHeader object.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.260 -0500", hash_original_method = "6DA29D8692407706B9B05391AF333993", hash_generated_method = "56F038CB529152D185A2CBDA69DBA81D")
    public RecordRouteHeader createRecordRouteHeader(Address address) {
        if ( address == null) throw new NullPointerException("Null argument!");
        RecordRoute recordRoute = new RecordRoute();
        recordRoute.setAddress(address);

        return recordRoute;
    }

    /**
    * Creates a new ReplyToHeader based on the newly supplied address value.
    *
    * @param address - the new Address object of the address.
    * @return the newly created ReplyToHeader object.
    * @since v1.1
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.261 -0500", hash_original_method = "4393C033D6B63EF338EB93DE3E753573", hash_generated_method = "5DB2D9E57BFAA6FD56609D8C5F508B28")
    public ReplyToHeader createReplyToHeader(Address address) {
        if (address == null)
            throw new NullPointerException("null address");
        ReplyTo replyTo = new ReplyTo();
        replyTo.setAddress(address);

        return replyTo;
    }

    /**
     * Creates a new RequireHeader based on the newly supplied optionTag
     * value.
     *
     * @param optionTag - the new string value containing the optionTag value.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the List of optionTag value.
     * @return the newly created RequireHeader object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.263 -0500", hash_original_method = "F65B5EA444DA08358E800CD7B469501A", hash_generated_method = "BD84134232A792C8DCFF472DF4074AE7")
    public RequireHeader createRequireHeader(String optionTag)
        throws ParseException {
        if (optionTag == null)
            throw new NullPointerException("null optionTag");
        Require require = new Require();
        require.setOptionTag(optionTag);

        return require;
    }

    /**
     * Creates a new RetryAfterHeader based on the newly supplied retryAfter
     * value.
     *
     * @param retryAfter - the new integer value of the retryAfter.
     * @throws InvalidArgumentException if supplied retryAfter is less
     * than zero.
     * @return the newly created RetryAfterHeader object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.264 -0500", hash_original_method = "43D5E8C96E4C1ED3ED5B8AD5C39C801C", hash_generated_method = "B66E712B9FB43D7AC2C0E83502131686")
    public RetryAfterHeader createRetryAfterHeader(int retryAfter)
        throws InvalidArgumentException {
        if (retryAfter < 0)
            throw new InvalidArgumentException("bad retryAfter arg");
        RetryAfter r = new RetryAfter();
        r.setRetryAfter(retryAfter);

        return r;
    }

    /**
     * Creates a new RouteHeader based on the newly supplied address value.
     *
     * @param address - the new Address object of the address.
     * @return the newly created RouteHeader object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.265 -0500", hash_original_method = "03611E3BB30258B8EC4FDC9F783CBCCF", hash_generated_method = "75EED4D564C6A1FA0F492FBBD941CE61")
    public RouteHeader createRouteHeader(Address address) {
        if (address == null)
            throw new NullPointerException("null address arg");
        Route route = new Route();
        route.setAddress(address);

        return route;
    }

    /**
     * Creates a new ServerHeader based on the newly supplied product value.
     *
     * @param product - the new list value of the product.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the product value.
     * @return the newly created ServerHeader object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.266 -0500", hash_original_method = "65AF02D93E753F97E0AF00F542D03529", hash_generated_method = "F29F21797D70C4B06E85B79AB9E1968B")
    public ServerHeader createServerHeader(List product)
        throws ParseException {
        if (product == null)
            throw new NullPointerException("null productList arg");
        Server server = new Server();
        server.setProduct(product);

        return server;
    }

    /**
     * Creates a new SubjectHeader based on the newly supplied subject value.
     *
     * @param subject - the new string value of the subject.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the subject value.
     * @return the newly created SubjectHeader object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.267 -0500", hash_original_method = "288EA55C0FFC9E81469649B581E59F71", hash_generated_method = "F55F59D5712F53A7811C6D777FB2784B")
    public SubjectHeader createSubjectHeader(String subject)
        throws ParseException {
        if (subject == null)
            throw new NullPointerException("null subject arg");
        Subject s = new Subject();
        s.setSubject(subject);

        return s;
    }

    /**
     * Creates a new SubscriptionStateHeader based on the newly supplied
     * subscriptionState value.
     *
     * @param subscriptionState - the new string value of the subscriptionState.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the subscriptionState value.
     * @return the newly created SubscriptionStateHeader object.
     * @since v1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.268 -0500", hash_original_method = "9B68B72DA8144991BC14639C6BE11723", hash_generated_method = "8327BB6171ABB6B2BBE7C0886198BF4C")
    public SubscriptionStateHeader createSubscriptionStateHeader(String subscriptionState)
        throws ParseException {
        if (subscriptionState == null)
            throw new NullPointerException("null subscriptionState arg");
        SubscriptionState s = new SubscriptionState();
        s.setState(subscriptionState);

        return s;
    }

    /**
     * Creates a new SupportedHeader based on the newly supplied optionTag
     * value.
     *
     * @param optionTag - the new string containing the optionTag value.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the optionTag value.
     * @return the newly created SupportedHeader object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.269 -0500", hash_original_method = "589849ECCDAFDA20BE0DBE1D9A436669", hash_generated_method = "E3A560F8FEC6A0B6AED8F8CC16C5F534")
    public SupportedHeader createSupportedHeader(String optionTag)
        throws ParseException {
        if (optionTag == null)
            throw new NullPointerException("null optionTag arg");
        Supported supported = new Supported();
        supported.setOptionTag(optionTag);

        return supported;
    }

    /**
     * Creates a new TimeStampHeader based on the newly supplied timeStamp value.
     *
     * @param timeStamp - the new float value of the timeStamp.
     * @throws InvalidArgumentException if supplied timeStamp is less
     * than zero.
     * @return the newly created TimeStampHeader object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.270 -0500", hash_original_method = "380079DA7F92D6CF2CEA9086AA5F92D7", hash_generated_method = "62F810F2BCF68D3D445BB90D996DBF7B")
    public TimeStampHeader createTimeStampHeader(float timeStamp)
        throws InvalidArgumentException {
        if (timeStamp < 0)
            throw new IllegalArgumentException("illegal timeStamp");
        TimeStamp t = new TimeStamp();
        t.setTimeStamp(timeStamp);

        return t;
    }

    /**
     * Creates a new ToHeader based on the newly supplied address and
     * tag values.
     *
     * @param address - the new Address object of the address.
     * @param tag - the new string value of the tag.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the tag value.
     * @return the newly created ToHeader object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.271 -0500", hash_original_method = "7928C6AF630E4BCE57D31FA4979B7453", hash_generated_method = "8EF7C6FA85B09C645E654C803E6CB6A8")
    public ToHeader createToHeader(Address address, String tag)
        throws ParseException {
        if (address == null)
            throw new NullPointerException("null address");
        To to = new To();
        to.setAddress(address);
        if (tag != null)
            to.setTag(tag);

        return to;
    }

    /**
     * Creates a new UnsupportedHeader based on the newly supplied optionTag
     * value.
     *
     * @param optionTag - the new string containing the optionTag value.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the List of optionTag value.
     * @return the newly created UnsupportedHeader object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.272 -0500", hash_original_method = "9A62FFB59334167B71BC2FE402276C31", hash_generated_method = "D42C210D0000FD68DEC32966AF1098BB")
    public UnsupportedHeader createUnsupportedHeader(String optionTag)
        throws ParseException {
        if (optionTag == null)
            throw new NullPointerException(optionTag);
        Unsupported unsupported = new Unsupported();
        unsupported.setOptionTag(optionTag);

        return unsupported;
    }

    /**
     * Creates a new UserAgentHeader based on the newly supplied product value.
     *
     * @param product - the new list value of the product.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the product value.
     * @return the newly created UserAgentHeader object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.273 -0500", hash_original_method = "0FDDC4550D32FE0A8E48193D044787BB", hash_generated_method = "B845E00C9CBC6D2C4107804420C92A12")
    public UserAgentHeader createUserAgentHeader(List product)
        throws ParseException {

        if (product == null)
            throw new NullPointerException("null user agent");
        UserAgent userAgent = new UserAgent();
        userAgent.setProduct(product);

        return userAgent;
    }

    /**
     * Creates a new ViaHeader based on the newly supplied uri and branch values.
     *
     * @param host the new host value of uri.
     * @param port the new port value of uri.
     * @param transport the new transport value of uri.
     * @param branch the new string value of the branch.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the branch value.
     * @return the newly created ViaHeader object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.275 -0500", hash_original_method = "B7A9F5DC521617567AEB2EDF2366DE24", hash_generated_method = "0EFB6A67DF9CE37072D3FACBB70497CD")
    public ViaHeader createViaHeader(
        String host,
        int port,
        String transport,
        String branch)
        throws ParseException, InvalidArgumentException {
        // This should be changed.
        if (host == null || transport == null)
            throw new NullPointerException("null arg");
        Via via = new Via();
        if (branch != null)
            via.setBranch(branch);

        // for supporting IPv6 addresses
        if(host.indexOf(':') >= 0
            && host.indexOf('[') < 0)
        {
            //strip address scope zones if any
            if(stripAddressScopeZones)
            {
                int zoneStart = host.indexOf('%');
                if(zoneStart != -1)
                    host = host.substring(0, zoneStart);
            }
            host = '[' + host + ']';
        }

        via.setHost(host);
        via.setPort(port);
        via.setTransport(transport);

        return via;
    }

    /**
     * Creates a new WWWAuthenticateHeader based on the newly supplied
     * scheme value.
     *
     * @param scheme - the new string value of the scheme.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the scheme values.
     * @return the newly created WWWAuthenticateHeader object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.276 -0500", hash_original_method = "EDE3AD5442B3DE671B6476C917BB6D0F", hash_generated_method = "0BD13C9317D8A307EA5DDA251AC3963A")
    public WWWAuthenticateHeader createWWWAuthenticateHeader(String scheme)
        throws ParseException {
        if (scheme == null)
            throw new NullPointerException("null scheme");
        WWWAuthenticate www = new WWWAuthenticate();
        www.setScheme(scheme);

        return www;
    }

    /**
     * Creates a new WarningHeader based on the newly supplied
     * agent, code and comment values.
     *
     * @param agent - the new string value of the agent.
     * @param code - the new boolean integer of the code.
     * @param comment - the new string value of the comment.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the agent or comment values.
     * @throws InvalidArgumentException if an invalid integer code is given for
     * the WarningHeader.
     * @return the newly created WarningHeader object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.277 -0500", hash_original_method = "F34478A6D1616AB2836BA2A212AE0D49", hash_generated_method = "407CF276C84C9D1F86E52E8ABF982FBB")
    public WarningHeader createWarningHeader(
        String agent,
        int code,
        String comment)
        throws ParseException, InvalidArgumentException {
        if (agent == null)
            throw new NullPointerException("null arg");
        Warning warning = new Warning();
        warning.setAgent(agent);
        warning.setCode(code);
        warning.setText(comment);

        return warning;
    }

    /** Creates a new ErrorInfoHeader based on the newly
     * supplied errorInfo value.
     *
     * @param errorInfo - the new URI value of the errorInfo.
     * @return the newly created ErrorInfoHeader object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.278 -0500", hash_original_method = "CB42C1424760C62123C05E2F8CB60B35", hash_generated_method = "D4E29284985BDC12CE5A30B884928967")
    public ErrorInfoHeader createErrorInfoHeader(URI errorInfo) {
        if (errorInfo == null)
            throw new NullPointerException("null arg");
        return new ErrorInfo((GenericURI) errorInfo);
    }
    
    /**
     * Create a header from the given header text.
     * Header should not have the trailng crlf.
     * @throws ParseException 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.280 -0500", hash_original_method = "7E6122EDAE408D205AF0C9E45A024F04", hash_generated_method = "73FD79D12E0BC58DBF740D0607743065")
    public javax.sip.header.Header createHeader(String headerText) throws ParseException {
        StringMsgParser smp = new StringMsgParser();
        SIPHeader sipHeader = smp.parseSIPHeader(headerText.trim());
        if (sipHeader instanceof SIPHeaderList) {
            if (((SIPHeaderList) sipHeader).size() > 1) {
                throw new ParseException(
                    "Only singleton allowed " + headerText,
                    0);
            } else if (((SIPHeaderList) sipHeader).size() == 0) {
                try {
                    return (Header) ((SIPHeaderList) sipHeader)
                        .getMyClass()
                        .newInstance();
                } catch (InstantiationException ex) {
                    ex.printStackTrace();
                    return null;
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                    return null;
                }
            } else {
                return (Header) ((SIPHeaderList) sipHeader).getFirst();
            }
        } else {
            return (Header) sipHeader;
        }
        
    }

    /** Create and parse a header.
     *
     * @param headerName -- header name for the header to parse.
     * @param headerValue -- header value for the header to parse.
     * @throws ParseException
     * @return  the parsed sip header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.281 -0500", hash_original_method = "BE8A77015DA0080195A899A1BFDA2B08", hash_generated_method = "4DD51F69C4AFAD774B946588A2335384")
    public javax.sip.header.Header createHeader(
        String headerName,
        String headerValue)
        throws java.text.ParseException {
        if (headerName == null)
            throw new NullPointerException("header name is null");
        String hdrText =
            new StringBuffer()
                .append(headerName)
                .append(":")
                .append(headerValue)
                .toString();
        return createHeader(hdrText);
        
    }

    /** Create and return a list of headers.
     *@param headers -- list of headers.
     *@throws ParseException -- if a parse exception occurs or a List
     * of that type of header is not alowed.
     *@return a List containing the headers.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.282 -0500", hash_original_method = "FDCDF9463F1CDDAF0BCBB63B8B4D05F5", hash_generated_method = "6F9F4BC4A555F6FA29F7EE824BCD7CBA")
    public java.util.List createHeaders(String headers)
        throws java.text.ParseException {
        if (headers == null)
            throw new NullPointerException("null arg!");
        StringMsgParser smp = new StringMsgParser();
        SIPHeader shdr = smp.parseSIPHeader(headers);
        if (shdr instanceof SIPHeaderList)
            return (SIPHeaderList) shdr;
        else
            throw new ParseException(
                "List of headers of this type is not allowed in a message",
                0);
    }

    /** Create a ReferTo Header.
     *@param address -- address for the header.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.283 -0500", hash_original_method = "5541F8A2ED86060178CAD1F0D5BA2507", hash_generated_method = "9A8154AF2DB6006EE81316CA88E8859B")
    public ReferToHeader createReferToHeader(Address address) {
        if (address == null)
            throw new NullPointerException("null address!");
        ReferTo referTo = new ReferTo();
        referTo.setAddress(address);
        return referTo;
    }

    /** Create a ReferredBy Header.
     *
     *  pmusgrave
     *
     *@param address -- address for the header.
     *
     * TODO: Once interfaces are in javax, change the type to MinSEHeader
     * and add to HeaderFactory. - pmusgrave

     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.284 -0500", hash_original_method = "A51D0E58D36C2041DD351AE4FDD73BCF", hash_generated_method = "9C103DD34050B3EC7184403C7C7A4648")
    public ReferredByHeader createReferredByHeader(Address address) {
        if (address == null)
            throw new NullPointerException("null address!");
        ReferredBy referredBy = new ReferredBy();
        referredBy.setAddress(address);
        return referredBy;
    }

    /**
     * Create a Replaces header with a call Id, to and from tag.
     *
     * TODO: Once interfaces are in javax, change the type to MinSEHeader
     * and add to HeaderFactory. - pmusgrave
     * pmusgrave
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.285 -0500", hash_original_method = "E3BB57144A133C8AFDA0829EAE12FAAB", hash_generated_method = "3BF3976AD13BB809A78001ADD263A2CE")
    public ReplacesHeader createReplacesHeader(String callId, String toTag,
                String fromTag) throws ParseException
    {
        Replaces replaces = new Replaces();
        replaces.setCallId(callId);
        replaces.setFromTag(fromTag);
        replaces.setToTag(toTag);

        return replaces;
    }

    /**
     * Create a Join header with a call Id, to and from tag.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.286 -0500", hash_original_method = "C42E665E40D735B4BFD234363CD8C238", hash_generated_method = "6FE2D9C0A2B717CDE23FE0708B3F64F1")
    public JoinHeader createJoinHeader(String callId, String toTag,
                String fromTag) throws ParseException
    {
        Join join = new Join();
        join.setCallId(callId);
        join.setFromTag(fromTag);
        join.setToTag(toTag);

        return join;
    }


    /*
     * (non-Javadoc)
     * @see javax.sip.header.HeaderFactory#createSIPETagHeader(java.lang.String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.287 -0500", hash_original_method = "95F88F9209912EE6FCAFCB830227A87B", hash_generated_method = "FDD78E279AEF1A3D79ECF0365945D565")
    public SIPETagHeader createSIPETagHeader(String etag) throws ParseException {
        return new SIPETag(etag);
    }

    /*
     * (non-Javadoc)
     * @see javax.sip.header.HeaderFactory#createSIPIfMatchHeader(java.lang.String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.288 -0500", hash_original_method = "9EE2B60A802A938BDC15DDB307A8B1D7", hash_generated_method = "5BE88D8333E0CCC7319E74CE2496534D")
    public SIPIfMatchHeader createSIPIfMatchHeader(String etag) throws ParseException {
        return new SIPIfMatch(etag);
    }

    //////////////////////////////////////////////////////////////////////////
    // The following headers are not part of the JSIP spec.
    // They are IMS headers
    // (contributed by Miguel Freitas - PT Inovacao and Telecommunications Institute)
    ///////////////////////////////////////////////////////////////////////////

    /**
     * creates a P-Access-Network-Info header
     * @return newly created P-Access-Network-Info header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.289 -0500", hash_original_method = "5900AA55EC6D83D47F45CED3D37DDEC7", hash_generated_method = "CCC9F37081A68346A27EB06AC5AAD37C")
    public PAccessNetworkInfoHeader createPAccessNetworkInfoHeader()
    {
        PAccessNetworkInfo accessNetworkInfo = new PAccessNetworkInfo();

        return accessNetworkInfo;
    }


    /**
     * P-Asserted-Identity header
     * @param address - Address
     * @return newly created P-Asserted-Identity header
     * @throws ParseException
     * @throws NullPointerException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.290 -0500", hash_original_method = "7A9453157C5A8C4FD99B8F34DC853877", hash_generated_method = "1045EE4969ECD81E537D6973B265F1AF")
    public PAssertedIdentityHeader createPAssertedIdentityHeader(Address address)
        throws NullPointerException, ParseException
    {
        if (address == null)
            throw new NullPointerException("null address!");

        PAssertedIdentity assertedIdentity = new PAssertedIdentity();
        assertedIdentity.setAddress(address);

        return assertedIdentity;


    }


    /**
     * Creates a new P-Associated-URI header based on the supplied address
     * @param assocURI - Address
     * @return newly created P-Associated-URI header
     * @throws NullPointerException if the supplied address is null
     * @throws ParseException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.291 -0500", hash_original_method = "4BD897B5832A55E4A60E9B49C4611708", hash_generated_method = "A56AA34F6163DB735767BAFF47EB85B0")
    public PAssociatedURIHeader createPAssociatedURIHeader(Address assocURI)
    {
        if (assocURI == null)
        throw new NullPointerException("null associatedURI!");

        PAssociatedURI associatedURI = new PAssociatedURI();
        associatedURI.setAddress(assocURI);

        return associatedURI;
    }




    /**
     * P-Called-Party-ID header
     * @param address - Address
     * @return newly created P-Called-Party-ID header
     * @throws NullPointerException
     * @throws ParseException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.293 -0500", hash_original_method = "FD713420BE4BC11FE9D9AB43BBBEAD30", hash_generated_method = "2457ABF9713E7ECE18E95E908033EB4B")
    public PCalledPartyIDHeader createPCalledPartyIDHeader(Address address)
    {
        if (address == null)
            throw new NullPointerException("null address!");

        PCalledPartyID calledPartyID = new PCalledPartyID();
        calledPartyID.setAddress(address);

        return calledPartyID;
    }



    /**
     * P-Charging-Function-Addresses header
     * @return newly created P-Charging-Function-Addresses header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.294 -0500", hash_original_method = "F3DC851C781199B1B5D5ECAC93663797", hash_generated_method = "77352DEEEA7B933847DD36C7B723EE3F")
    public PChargingFunctionAddressesHeader createPChargingFunctionAddressesHeader()
    {
        PChargingFunctionAddresses cfa = new PChargingFunctionAddresses();

        return cfa;
    }


    /**
     * P-Charging-Vector header
     * @param icid - icid string
     * @return newly created P-Charging-Vector header
     * @throws NullPointerException
     * @throws ParseException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.295 -0500", hash_original_method = "E82D256C40CCFC0E4431BA44734EBBF3", hash_generated_method = "6D5C7CC2F0D81500F711AEA9D1B3F8EF")
    public PChargingVectorHeader createChargingVectorHeader(String icid)
        throws ParseException
    {
        if (icid == null)
        throw new NullPointerException("null icid arg!");

        PChargingVector chargingVector = new PChargingVector();
        chargingVector.setICID(icid);

        return chargingVector;

    }


    /**
     * P-Media-Authorization header
     * @param token - token string
     * @return newly created P-Media-Authorizarion header
     * @throws InvalidArgumentException
     * @throws ParseException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.296 -0500", hash_original_method = "FB93C1554D708A44568E0208A3D181E0", hash_generated_method = "FC1E8895E9E654084A4957FF43CAA4B3")
    public PMediaAuthorizationHeader createPMediaAuthorizationHeader(String token)
        throws InvalidArgumentException, ParseException
    {
        if (token == null || token == "")
            throw new InvalidArgumentException("The Media-Authorization-Token parameter is null or empty");


        PMediaAuthorization mediaAuthorization = new PMediaAuthorization();
        mediaAuthorization.setMediaAuthorizationToken(token);

        return mediaAuthorization;
    }


    /**
     * P-Preferred-Identity header
     * @param address - Address
     * @return newly created P-Preferred-Identity header
     * @throws NullPointerException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.297 -0500", hash_original_method = "3BA03116BEA38D71B8C38B4BA62E5B71", hash_generated_method = "5F3061FD2E1DF2232BFC4EDD62C08709")
    public PPreferredIdentityHeader createPPreferredIdentityHeader(Address address)
    {
        if (address == null)
            throw new NullPointerException("null address!");

        PPreferredIdentity preferredIdentity = new PPreferredIdentity();
        preferredIdentity.setAddress(address);

        return preferredIdentity;

    }

    /**
     * P-Visited-Network-ID header
     * @return newly created P-Visited-Network-ID header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.298 -0500", hash_original_method = "B32CA202259A9B847AD818F044EE39DA", hash_generated_method = "52B75BB1D59F871626310C46024D7C11")
    public PVisitedNetworkIDHeader createPVisitedNetworkIDHeader()
    {
        PVisitedNetworkID visitedNetworkID = new PVisitedNetworkID();

        return visitedNetworkID;
    }



    /**
     * PATH header
     * @param address - Address
     * @return newly created Path header
     * @throws NullPointerException
     * @throws ParseException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.299 -0500", hash_original_method = "537B18CC29F2C70486994281CB29500B", hash_generated_method = "6A482BE6A74E58339F6E34A315D068FB")
    public PathHeader createPathHeader(Address address)
    {
        if (address == null)
            throw new NullPointerException("null address!");


        Path path = new Path();
        path.setAddress(address);

        return path;
    }


    /**
     * Privacy header
     * @param privacyType - privacy type string
     * @return newly created Privacy header
     * @throws NullPointerException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.300 -0500", hash_original_method = "85C1BF55B1F968333EFFBCF4DBC75BE6", hash_generated_method = "369026569CB74E2410F62F5387F7F141")
    public PrivacyHeader createPrivacyHeader(String privacyType)
    {
        if (privacyType == null)
            throw new NullPointerException("null privacyType arg");

        Privacy privacy = new Privacy(privacyType);

        return privacy;

    }


    /**
     * Service-Route header
     * @param address - Address
     * @return newly created Service-Route header
     * @throws NullPointerException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.301 -0500", hash_original_method = "A7CA2EB6DD40139D85B6778D2C783F9F", hash_generated_method = "EC2C494CA659AFA06CA752F5FEFC3E49")
    public ServiceRouteHeader createServiceRouteHeader(Address address)
    {
        if (address == null)
            throw new NullPointerException("null address!");

        ServiceRoute serviceRoute = new ServiceRoute();
        serviceRoute.setAddress(address);

        return serviceRoute;

    }

    /**
     * Security-Server header
     * @return newly created Security-Server header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.303 -0500", hash_original_method = "7A3E4AE36777C6F2CF79A6B3882A3053", hash_generated_method = "A03BB373737BEB4EF11616B7687DED0D")
    public SecurityServerHeader createSecurityServerHeader()
    {
        SecurityServer secServer = new SecurityServer();
        return secServer;
    }

    /**
     * Security-Client header
     * @return newly created Security-Client header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.303 -0500", hash_original_method = "2361364E4BB205FAC2A8F8549D9431F6", hash_generated_method = "AF914157A79A59D795CD06072A593918")
    public SecurityClientHeader createSecurityClientHeader()
    {
        SecurityClient secClient = new SecurityClient();
        return secClient;
    }

    /**
     * Security-Verify header
     * @return newly created Security-Verify header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.304 -0500", hash_original_method = "1063C2554F38236C917DADCB6A55ADB8", hash_generated_method = "707DF2990815E7D886CAB50CA5F51B6E")
    public SecurityVerifyHeader createSecurityVerifyHeader()
    {
        SecurityVerify secVerify = new SecurityVerify();
        return secVerify;
    }

    /**
     * @return the newly create P-User-Database header.
     * Please note that this is not a SIP/TEL uri. It is a
     * DIAMETER AAA URI.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.305 -0500", hash_original_method = "2DDC01C5DAA0917C6B8BE6B8A00F5568", hash_generated_method = "19CF3EB64D252DCC1E914345C8438226")
    public PUserDatabaseHeader createPUserDatabaseHeader(String databaseName)
    {
        if((databaseName ==null)||(databaseName.equals(" ")))
            throw new NullPointerException("Database name is null");

        PUserDatabase pUserDatabase = new PUserDatabase();
        pUserDatabase.setDatabaseName(databaseName);

        return pUserDatabase;
    }


    /**
     * 
     * @return The newly created P-Profile-Key header.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.306 -0500", hash_original_method = "6A0691F102D20D70FD0A6921A61CA118", hash_generated_method = "0719F075B7D06CC9B93C7D1074B2B433")
    public PProfileKeyHeader createPProfileKeyHeader(Address address)
    {
        if (address ==null)
            throw new NullPointerException("Address is null");
        PProfileKey pProfileKey = new PProfileKey();
        pProfileKey.setAddress(address);

        return pProfileKey;
    }

    /**
     * 
     * @return The newly created P-Served-User header.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.308 -0500", hash_original_method = "38B7C1667A9FD579C07BB14E255FF56A", hash_generated_method = "778782CCC1A57132F2C6C14F3A8F276B")
    public PServedUserHeader createPServedUserHeader(Address address)
    {
        if(address==null)
            throw new NullPointerException("Address is null");
        PServedUser psu = new PServedUser();
        psu.setAddress(address);

        return psu;
    }
    /**
     * @return The newly created P-Preferred-Service header.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.308 -0500", hash_original_method = "C0CFD4DCC2CCE8A2BE967D3A2132C68A", hash_generated_method = "F4411F29895AB1E48A0F1D4960E19576")
    public PPreferredServiceHeader createPPreferredServiceHeader()
    {
        PPreferredService pps = new PPreferredService();
        return pps;
    }

    /**
     *
     * @return The newly created P-Asserted-Service header.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.309 -0500", hash_original_method = "48E529894AF92157CD42EE8DFB6E18AB", hash_generated_method = "1E7D131782BCC183C2A9A2CA524EFEFF")
    public PAssertedServiceHeader createPAssertedServiceHeader()
    {
        PAssertedService pas = new PAssertedService();
        return pas;
    }

    /**
     * Creates a new SessionExpiresHeader based on the newly supplied expires value.
     *
     * @param expires - the new integer value of the expires.
     * @throws InvalidArgumentException if supplied expires is less
     * than zero.
     * @return the newly created SessionExpiresHeader object.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.310 -0500", hash_original_method = "6D472F26B8815D9A75157924D7DB3DB8", hash_generated_method = "0A0E6DA44D324DA85EA874CE831AF067")
    public SessionExpiresHeader createSessionExpiresHeader(int expires)
        throws InvalidArgumentException {
        if (expires < 0)
            throw new InvalidArgumentException("bad value " + expires);
        SessionExpires s = new SessionExpires();
        s.setExpires(expires);

        return s;
    }
    
    
    /**
     * Create a new Request Line from a String.
     * 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.311 -0500", hash_original_method = "F07701895F7EA99F66D330A17A2FD28D", hash_generated_method = "CCE225807CE483E1E6E6673A8C5B1BD7")
    public SipRequestLine createRequestLine(String requestLine)  throws ParseException {
        
        RequestLineParser requestLineParser = new RequestLineParser(requestLine);
        return (SipRequestLine) requestLineParser.parse();
    }
    
    /**
     * Create a new StatusLine from a String.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.312 -0500", hash_original_method = "94ED81BC52F6E3EE358EE57713F40357", hash_generated_method = "230AE6DD7E6E198D168305C6A355146F")
    public SipStatusLine createStatusLine(String statusLine) throws ParseException {
        StatusLineParser statusLineParser = new StatusLineParser(statusLine);
        return (SipStatusLine) statusLineParser.parse();
    }


    
    /**
     * Create and return a references header.
     * 
     * @param callId
     * @param rel
     * @return
     * @throws ParseException
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:55.313 -0500", hash_original_method = "B06A6A8CC80D9698711113EFD1E58499", hash_generated_method = "57C1CCBA69B4100AD0EB721BFEB07DD9")
    public ReferencesHeader createReferencesHeader(String callId, String rel) throws ParseException {
        ReferencesHeader retval = new References();
        retval.setCallId(callId);
        retval.setRel(rel);
        return retval;
    }

    
}

