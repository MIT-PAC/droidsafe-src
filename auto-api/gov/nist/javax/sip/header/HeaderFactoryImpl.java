package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.ims.*;
import gov.nist.javax.sip.header.extensions.*;
import javax.sip.header.*;
import gov.nist.javax.sip.parser.*;
import gov.nist.javax.sip.parser.extensions.ReferencesParser;
import javax.sip.address.*;
import java.text.ParseException;
import javax.sip.InvalidArgumentException;
import java.util.*;
import gov.nist.javax.sip.address.*;

public class HeaderFactoryImpl implements HeaderFactory, HeaderFactoryExt {
    private boolean stripAddressScopeZones = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.967 -0400", hash_original_method = "EA4ABB94B4CFEF029E31D8F450F44C66", hash_generated_method = "4DBE2EDCEE71001244079D3C05C060E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HeaderFactoryImpl() {
        stripAddressScopeZones
            = Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
        // ---------- Original Method ----------
        //stripAddressScopeZones
            //= Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.967 -0400", hash_original_method = "9BEACA878DCF694953AD8141227DB60F", hash_generated_method = "6DDBFC661174DD8A7083EF218EAD1BF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPrettyEncoding(boolean flag) {
        dsTaint.addTaint(flag);
        SIPHeaderList.setPrettyEncode(flag);
        // ---------- Original Method ----------
        //SIPHeaderList.setPrettyEncode(flag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.968 -0400", hash_original_method = "58113BBBA3D76308CFB19C46D0FF7A27", hash_generated_method = "0B4DB5C9C149AD0376E06AB532C121CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AcceptEncodingHeader createAcceptEncodingHeader(String encoding) throws ParseException {
        dsTaint.addTaint(encoding);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("the encoding parameter is null");
        AcceptEncoding acceptEncoding;
        acceptEncoding = new AcceptEncoding();
        acceptEncoding.setEncoding(encoding);
        return (AcceptEncodingHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (encoding == null)
            //throw new NullPointerException("the encoding parameter is null");
        //AcceptEncoding acceptEncoding = new AcceptEncoding();
        //acceptEncoding.setEncoding(encoding);
        //return acceptEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.969 -0400", hash_original_method = "3FEA70547EDCF31E1AA086D3362AC6CE", hash_generated_method = "D93642482B98A91B38216CF5DFB30928")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AcceptHeader createAcceptHeader(
        String contentType,
        String contentSubType) throws ParseException {
        dsTaint.addTaint(contentSubType);
        dsTaint.addTaint(contentType);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("contentType or subtype is null ");
        Accept accept;
        accept = new Accept();
        accept.setContentType(contentType);
        accept.setContentSubType(contentSubType);
        return (AcceptHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (contentType == null || contentSubType == null)
            //throw new NullPointerException("contentType or subtype is null ");
        //Accept accept = new Accept();
        //accept.setContentType(contentType);
        //accept.setContentSubType(contentSubType);
        //return accept;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.970 -0400", hash_original_method = "5AF5E9D92982780781CC81035C3C1529", hash_generated_method = "3004F5D7590C9744D1EB8A2F45061A8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AcceptLanguageHeader createAcceptLanguageHeader(Locale language) {
        dsTaint.addTaint(language.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        AcceptLanguage acceptLanguage;
        acceptLanguage = new AcceptLanguage();
        acceptLanguage.setAcceptLanguage(language);
        return (AcceptLanguageHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (language == null)
            //throw new NullPointerException("null arg");
        //AcceptLanguage acceptLanguage = new AcceptLanguage();
        //acceptLanguage.setAcceptLanguage(language);
        //return acceptLanguage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.970 -0400", hash_original_method = "3E0D5311E2AF98CBAC12E04C1647AAA5", hash_generated_method = "ACF743CBFA6BCCD8871C8B93304FA48A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AlertInfoHeader createAlertInfoHeader(URI alertInfo) {
        dsTaint.addTaint(alertInfo.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg alertInfo");
        AlertInfo a;
        a = new AlertInfo();
        a.setAlertInfo(alertInfo);
        return (AlertInfoHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (alertInfo == null)
            //throw new NullPointerException("null arg alertInfo");
        //AlertInfo a = new AlertInfo();
        //a.setAlertInfo(alertInfo);
        //return a;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.970 -0400", hash_original_method = "7A8DE3D3022A3669E75EC61B4D0B5F19", hash_generated_method = "8126EA92B7E6CFF478102C77AF129243")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AllowEventsHeader createAllowEventsHeader(String eventType) throws ParseException {
        dsTaint.addTaint(eventType);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg eventType");
        AllowEvents allowEvents;
        allowEvents = new AllowEvents();
        allowEvents.setEventType(eventType);
        return (AllowEventsHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (eventType == null)
            //throw new NullPointerException("null arg eventType");
        //AllowEvents allowEvents = new AllowEvents();
        //allowEvents.setEventType(eventType);
        //return allowEvents;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.970 -0400", hash_original_method = "C562ECE8E2158A54C27A4525D88FEA63", hash_generated_method = "BCC3DB958C4D6DB031D0C2B1BB0BECEB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AllowHeader createAllowHeader(String method) throws ParseException {
        dsTaint.addTaint(method);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg method");
        Allow allow;
        allow = new Allow();
        allow.setMethod(method);
        return (AllowHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (method == null)
            //throw new NullPointerException("null arg method");
        //Allow allow = new Allow();
        //allow.setMethod(method);
        //return allow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.971 -0400", hash_original_method = "E72D81A306A857A102E9D4437AB18CA6", hash_generated_method = "4EE415C0CB20E4BF13F986CE5F2B7692")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AuthenticationInfoHeader createAuthenticationInfoHeader(String response) throws ParseException {
        dsTaint.addTaint(response);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg response");
        AuthenticationInfo auth;
        auth = new AuthenticationInfo();
        auth.setResponse(response);
        return (AuthenticationInfoHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (response == null)
            //throw new NullPointerException("null arg response");
        //AuthenticationInfo auth = new AuthenticationInfo();
        //auth.setResponse(response);
        //return auth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.971 -0400", hash_original_method = "F250EC80C8CD1CBE5FF237A98CBD8CD0", hash_generated_method = "DB9D5F8DB74BB730D08F9D7E905ECE0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AuthorizationHeader createAuthorizationHeader(String scheme) throws ParseException {
        dsTaint.addTaint(scheme);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg scheme ");
        Authorization auth;
        auth = new Authorization();
        auth.setScheme(scheme);
        return (AuthorizationHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (scheme == null)
            //throw new NullPointerException("null arg scheme ");
        //Authorization auth = new Authorization();
        //auth.setScheme(scheme);
        //return auth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.971 -0400", hash_original_method = "9707416B5040BCEA07917ADCBF33DA70", hash_generated_method = "FE5B201240C3BFA6417CF230F266EE02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CSeqHeader createCSeqHeader( long sequenceNumber, String method) throws ParseException, InvalidArgumentException {
        dsTaint.addTaint(method);
        dsTaint.addTaint(sequenceNumber);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad arg " + sequenceNumber);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg method");
        CSeq cseq;
        cseq = new CSeq();
        cseq.setMethod(method);
        cseq.setSeqNumber(sequenceNumber);
        return (CSeqHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (sequenceNumber < 0)
            //throw new InvalidArgumentException("bad arg " + sequenceNumber);
        //if (method == null)
            //throw new NullPointerException("null arg method");
        //CSeq cseq = new CSeq();
        //cseq.setMethod(method);
        //cseq.setSeqNumber(sequenceNumber);
        //return cseq;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.971 -0400", hash_original_method = "332D5DD16F528ACCDED76BFE26F4F243", hash_generated_method = "96FBCC86A6999B6CD74EACF0E60BFD4E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CSeqHeader createCSeqHeader( int sequenceNumber, String method) throws ParseException, InvalidArgumentException {
        dsTaint.addTaint(method);
        dsTaint.addTaint(sequenceNumber);
        CSeqHeader varEA2CE63C92FD50F460A3DCB93C08A3D8_587916468 = (this.createCSeqHeader( (long) sequenceNumber, method ));
        return (CSeqHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.createCSeqHeader( (long) sequenceNumber, method );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.972 -0400", hash_original_method = "0CB560808F252622C176039BC6E86FF7", hash_generated_method = "00A9D441B085C83F689BA23B4503650D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CallIdHeader createCallIdHeader(String callId) throws ParseException {
        dsTaint.addTaint(callId);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg callId");
        CallID c;
        c = new CallID();
        c.setCallId(callId);
        return (CallIdHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (callId == null)
            //throw new NullPointerException("null arg callId");
        //CallID c = new CallID();
        //c.setCallId(callId);
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.972 -0400", hash_original_method = "8867B6CA9EB8DB8DAA3F991D7B0AD5D9", hash_generated_method = "E3A197B3890BE8D0181A5192474AA71C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CallInfoHeader createCallInfoHeader(URI callInfo) {
        dsTaint.addTaint(callInfo.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg callInfo");
        CallInfo c;
        c = new CallInfo();
        c.setInfo(callInfo);
        return (CallInfoHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (callInfo == null)
            //throw new NullPointerException("null arg callInfo");
        //CallInfo c = new CallInfo();
        //c.setInfo(callInfo);
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.972 -0400", hash_original_method = "45EF0D9994A51A34EA10DF4A185E8F21", hash_generated_method = "6144B577CE5583F0350633D247047A6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContactHeader createContactHeader(Address address) {
        dsTaint.addTaint(address.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg address");
        Contact contact;
        contact = new Contact();
        contact.setAddress(address);
        return (ContactHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null arg address");
        //Contact contact = new Contact();
        //contact.setAddress(address);
        //return contact;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.973 -0400", hash_original_method = "5873C88FB18B86DA11D334099F5AE064", hash_generated_method = "413A25633FF65E80FD63F563ADE895FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContactHeader createContactHeader() {
        Contact contact;
        contact = new Contact();
        contact.setWildCardFlag(true);
        contact.setExpires(0);
        return (ContactHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Contact contact = new Contact();
        //contact.setWildCardFlag(true);
        //contact.setExpires(0);
        //return contact;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.973 -0400", hash_original_method = "CC352C2425871DC27A0C55CF39D4ABAB", hash_generated_method = "0FDF4B4A9DDEA6939974227304B9A464")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContentDispositionHeader createContentDispositionHeader(String contentDisposition) throws ParseException {
        dsTaint.addTaint(contentDisposition);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg contentDisposition");
        ContentDisposition c;
        c = new ContentDisposition();
        c.setDispositionType(contentDisposition);
        return (ContentDispositionHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (contentDisposition == null)
            //throw new NullPointerException("null arg contentDisposition");
        //ContentDisposition c = new ContentDisposition();
        //c.setDispositionType(contentDisposition);
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.973 -0400", hash_original_method = "090104ADCCDA5F259494E038435257D1", hash_generated_method = "4FEA4B764320E7827E27A1EAA77EC787")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContentEncodingHeader createContentEncodingHeader(String encoding) throws ParseException {
        dsTaint.addTaint(encoding);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null encoding");
        ContentEncoding c;
        c = new ContentEncoding();
        c.setEncoding(encoding);
        return (ContentEncodingHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (encoding == null)
            //throw new NullPointerException("null encoding");
        //ContentEncoding c = new ContentEncoding();
        //c.setEncoding(encoding);
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.974 -0400", hash_original_method = "CD027E2457CF527330FF9F4C0A972B91", hash_generated_method = "39817B70F7AECDCE2FF0ACCD6328C29A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContentLanguageHeader createContentLanguageHeader(Locale contentLanguage) {
        dsTaint.addTaint(contentLanguage.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg contentLanguage");
        ContentLanguage c;
        c = new ContentLanguage();
        c.setContentLanguage(contentLanguage);
        return (ContentLanguageHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (contentLanguage == null)
            //throw new NullPointerException("null arg contentLanguage");
        //ContentLanguage c = new ContentLanguage();
        //c.setContentLanguage(contentLanguage);
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.974 -0400", hash_original_method = "DA3B5EC62F3E30804B07AD592D303E3E", hash_generated_method = "23A10C1CF08DF6B161442A9C431AF382")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContentLengthHeader createContentLengthHeader(int contentLength) throws InvalidArgumentException {
        dsTaint.addTaint(contentLength);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad contentLength");
        ContentLength c;
        c = new ContentLength();
        c.setContentLength(contentLength);
        return (ContentLengthHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (contentLength < 0)
            //throw new InvalidArgumentException("bad contentLength");
        //ContentLength c = new ContentLength();
        //c.setContentLength(contentLength);
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.974 -0400", hash_original_method = "BF42B4FF2E7F96D2FA4773C6E514B79D", hash_generated_method = "9887B46BE7C25DD5861EC361761FDC4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContentTypeHeader createContentTypeHeader(
        String contentType,
        String contentSubType) throws ParseException {
        dsTaint.addTaint(contentSubType);
        dsTaint.addTaint(contentType);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null contentType or subType");
        ContentType c;
        c = new ContentType();
        c.setContentType(contentType);
        c.setContentSubType(contentSubType);
        return (ContentTypeHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (contentType == null || contentSubType == null)
            //throw new NullPointerException("null contentType or subType");
        //ContentType c = new ContentType();
        //c.setContentType(contentType);
        //c.setContentSubType(contentSubType);
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.975 -0400", hash_original_method = "F3D0948AB2AB5DCB4D46B0F9C4754A1D", hash_generated_method = "542489F1C94CCF00F000619C91BBD891")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DateHeader createDateHeader(Calendar date) {
        dsTaint.addTaint(date.dsTaint);
        SIPDateHeader d;
        d = new SIPDateHeader();
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null date");
        d.setDate(date);
        return (DateHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SIPDateHeader d = new SIPDateHeader();
        //if (date == null)
            //throw new NullPointerException("null date");
        //d.setDate(date);
        //return d;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.975 -0400", hash_original_method = "7FD58797EECF83FE34BEE1F3B093BC46", hash_generated_method = "9B882181DD3B43B4C836A40457831B81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public EventHeader createEventHeader(String eventType) throws ParseException {
        dsTaint.addTaint(eventType);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null eventType");
        Event event;
        event = new Event();
        event.setEventType(eventType);
        return (EventHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (eventType == null)
            //throw new NullPointerException("null eventType");
        //Event event = new Event();
        //event.setEventType(eventType);
        //return event;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.975 -0400", hash_original_method = "1A307AD1BD02E7BD6299AF40D811E5D5", hash_generated_method = "6B8AF91CA995DBEAB807AC3356D8A28C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ExpiresHeader createExpiresHeader(int expires) throws InvalidArgumentException {
        dsTaint.addTaint(expires);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad value " + expires);
        Expires e;
        e = new Expires();
        e.setExpires(expires);
        return (ExpiresHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (expires < 0)
            //throw new InvalidArgumentException("bad value " + expires);
        //Expires e = new Expires();
        //e.setExpires(expires);
        //return e;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.976 -0400", hash_original_method = "C38CB4735B94E96E0C6FB81DC8E60CBF", hash_generated_method = "3782A14EFE5BDC0C2C5BD4BE230A3935")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public javax.sip.header.ExtensionHeader createExtensionHeader(
        String name,
        String value) throws ParseException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("bad name");
        gov.nist.javax.sip.header.ExtensionHeaderImpl ext;
        ext = new gov.nist.javax.sip.header.ExtensionHeaderImpl();
        ext.setName(name);
        ext.setValue(value);
        return (javax.sip.header.ExtensionHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (name == null)
            //throw new NullPointerException("bad name");
        //gov.nist.javax.sip.header.ExtensionHeaderImpl ext =
            //new gov.nist.javax.sip.header.ExtensionHeaderImpl();
        //ext.setName(name);
        //ext.setValue(value);
        //return ext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.977 -0400", hash_original_method = "E3876C81F77C4C65824998CB51869857", hash_generated_method = "348D7A1F26CCA7E58217BF4D9A12A8A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FromHeader createFromHeader(Address address, String tag) throws ParseException {
        dsTaint.addTaint(address.dsTaint);
        dsTaint.addTaint(tag);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address arg");
        From from;
        from = new From();
        from.setAddress(address);
        from.setTag(tag);
        return (FromHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address arg");
        //From from = new From();
        //from.setAddress(address);
        //if (tag != null)
            //from.setTag(tag);
        //return from;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.977 -0400", hash_original_method = "4DE074146D6A81FB201A39A399764E9F", hash_generated_method = "BE65013AA3CAD5629F9A9CEEB8E71264")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InReplyToHeader createInReplyToHeader(String callId) throws ParseException {
        dsTaint.addTaint(callId);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null callId arg");
        InReplyTo inReplyTo;
        inReplyTo = new InReplyTo();
        inReplyTo.setCallId(callId);
        return (InReplyToHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (callId == null)
            //throw new NullPointerException("null callId arg");
        //InReplyTo inReplyTo = new InReplyTo();
        //inReplyTo.setCallId(callId);
        //return inReplyTo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.978 -0400", hash_original_method = "2B62AE770A28023C5424C7B7718E4BD4", hash_generated_method = "E8A0B71EAAF3ED835085824B38FD6A01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MaxForwardsHeader createMaxForwardsHeader(int maxForwards) throws InvalidArgumentException {
        dsTaint.addTaint(maxForwards);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "bad maxForwards arg " + maxForwards);
        MaxForwards m;
        m = new MaxForwards();
        m.setMaxForwards(maxForwards);
        return (MaxForwardsHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (maxForwards < 0 || maxForwards > 255)
            //throw new InvalidArgumentException(
                //"bad maxForwards arg " + maxForwards);
        //MaxForwards m = new MaxForwards();
        //m.setMaxForwards(maxForwards);
        //return m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.978 -0400", hash_original_method = "623C745ED7578EC4227F3B15A38B5D4A", hash_generated_method = "F4949FD4AC93A7C125E574350DA9EBDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MimeVersionHeader createMimeVersionHeader(
        int majorVersion,
        int minorVersion) throws InvalidArgumentException {
        dsTaint.addTaint(majorVersion);
        dsTaint.addTaint(minorVersion);
        if (DroidSafeAndroidRuntime.control) throw new javax.sip.InvalidArgumentException(
                "bad major/minor version");
        MimeVersion m;
        m = new MimeVersion();
        m.setMajorVersion(majorVersion);
        m.setMinorVersion(minorVersion);
        return (MimeVersionHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (majorVersion < 0 || minorVersion < 0)
            //throw new javax.sip.InvalidArgumentException(
                //"bad major/minor version");
        //MimeVersion m = new MimeVersion();
        //m.setMajorVersion(majorVersion);
        //m.setMinorVersion(minorVersion);
        //return m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.978 -0400", hash_original_method = "F897D0FECB8A8CC74BFA504858C91B42", hash_generated_method = "842F3D2DDBE56DAD0C495B144E5945BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MinExpiresHeader createMinExpiresHeader(int minExpires) throws InvalidArgumentException {
        dsTaint.addTaint(minExpires);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad minExpires " + minExpires);
        MinExpires min;
        min = new MinExpires();
        min.setExpires(minExpires);
        return (MinExpiresHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (minExpires < 0)
            //throw new InvalidArgumentException("bad minExpires " + minExpires);
        //MinExpires min = new MinExpires();
        //min.setExpires(minExpires);
        //return min;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.978 -0400", hash_original_method = "8EE941BB2D8E39A517F98D1ED3613B4D", hash_generated_method = "B506BC95C045D9484F700503B95B323C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ExtensionHeader createMinSEHeader(int expires) throws InvalidArgumentException {
        dsTaint.addTaint(expires);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad value " + expires);
        MinSE e;
        e = new MinSE();
        e.setExpires(expires);
        return (ExtensionHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (expires < 0)
            //throw new InvalidArgumentException("bad value " + expires);
        //MinSE e = new MinSE();
        //e.setExpires(expires);
        //return e;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.979 -0400", hash_original_method = "2F5DB311D13CB6144CC7B49271775C33", hash_generated_method = "43325EC28449DB5B5CCB44DBDA6132EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OrganizationHeader createOrganizationHeader(String organization) throws ParseException {
        dsTaint.addTaint(organization);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("bad organization arg");
        Organization o;
        o = new Organization();
        o.setOrganization(organization);
        return (OrganizationHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (organization == null)
            //throw new NullPointerException("bad organization arg");
        //Organization o = new Organization();
        //o.setOrganization(organization);
        //return o;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.979 -0400", hash_original_method = "085951AB405380C6C60E1EC174C5C855", hash_generated_method = "51BDE503E342F19CB76BD6D24757ACA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PriorityHeader createPriorityHeader(String priority) throws ParseException {
        dsTaint.addTaint(priority);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("bad priority arg");
        Priority p;
        p = new Priority();
        p.setPriority(priority);
        return (PriorityHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (priority == null)
            //throw new NullPointerException("bad priority arg");
        //Priority p = new Priority();
        //p.setPriority(priority);
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.979 -0400", hash_original_method = "E2D1E713D6EFBD9B5EF73CE359255B39", hash_generated_method = "18649A38975DBF43A67D7BA433952D25")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ProxyAuthenticateHeader createProxyAuthenticateHeader(String scheme) throws ParseException {
        dsTaint.addTaint(scheme);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("bad scheme arg");
        ProxyAuthenticate p;
        p = new ProxyAuthenticate();
        p.setScheme(scheme);
        return (ProxyAuthenticateHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (scheme == null)
            //throw new NullPointerException("bad scheme arg");
        //ProxyAuthenticate p = new ProxyAuthenticate();
        //p.setScheme(scheme);
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.979 -0400", hash_original_method = "E046B5DACDD94AD026F81045FF391CD1", hash_generated_method = "3AC868FF4C79F10968228C93ECA17EA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ProxyAuthorizationHeader createProxyAuthorizationHeader(String scheme) throws ParseException {
        dsTaint.addTaint(scheme);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("bad scheme arg");
        ProxyAuthorization p;
        p = new ProxyAuthorization();
        p.setScheme(scheme);
        return (ProxyAuthorizationHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (scheme == null)
            //throw new NullPointerException("bad scheme arg");
        //ProxyAuthorization p = new ProxyAuthorization();
        //p.setScheme(scheme);
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.980 -0400", hash_original_method = "A059B8FD47D8FC83321E2DEF4CB18490", hash_generated_method = "26339FF89DC989CC21DE421740798FDE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ProxyRequireHeader createProxyRequireHeader(String optionTag) throws ParseException {
        dsTaint.addTaint(optionTag);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("bad optionTag arg");
        ProxyRequire p;
        p = new ProxyRequire();
        p.setOptionTag(optionTag);
        return (ProxyRequireHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (optionTag == null)
            //throw new NullPointerException("bad optionTag arg");
        //ProxyRequire p = new ProxyRequire();
        //p.setOptionTag(optionTag);
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.980 -0400", hash_original_method = "42539302BE9490416DF1DC01B8BC3D99", hash_generated_method = "A59EEC0A0B66AF2224701B24FCD58400")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RAckHeader createRAckHeader(
        long rSeqNumber,
        long cSeqNumber,
        String method) throws InvalidArgumentException, ParseException {
        dsTaint.addTaint(cSeqNumber);
        dsTaint.addTaint(rSeqNumber);
        dsTaint.addTaint(method);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Bad method");
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad cseq/rseq arg");
        RAck rack;
        rack = new RAck();
        rack.setMethod(method);
        rack.setCSequenceNumber(cSeqNumber);
        rack.setRSequenceNumber(rSeqNumber);
        return (RAckHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (method == null)
            //throw new NullPointerException("Bad method");
        //if (cSeqNumber < 0 || rSeqNumber < 0)
            //throw new InvalidArgumentException("bad cseq/rseq arg");
        //RAck rack = new RAck();
        //rack.setMethod(method);
        //rack.setCSequenceNumber(cSeqNumber);
        //rack.setRSequenceNumber(rSeqNumber);
        //return rack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.980 -0400", hash_original_method = "B44C2BD23DFFCB51A992C42D93BADE4E", hash_generated_method = "5C305CFCCCCF00A73AA0DB1CC89887F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RAckHeader createRAckHeader(int rSeqNumber, int cSeqNumber, String method) throws InvalidArgumentException, ParseException {
        dsTaint.addTaint(cSeqNumber);
        dsTaint.addTaint(rSeqNumber);
        dsTaint.addTaint(method);
        RAckHeader varA3A0B061F115D77FF15C585BC92B4AF0_1370424738 = (createRAckHeader((long)rSeqNumber, (long)cSeqNumber, method));
        return (RAckHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return createRAckHeader((long)rSeqNumber, (long)cSeqNumber, method);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.980 -0400", hash_original_method = "38086BF4D4EB3CE5AB4BF7772F8EACF2", hash_generated_method = "9168C2477B90D6D3B90DF2535ADA9DE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RSeqHeader createRSeqHeader(int sequenceNumber) throws InvalidArgumentException {
        dsTaint.addTaint(sequenceNumber);
        RSeqHeader var708EDC4205114AFFA99A85454649BB4E_1024865981 = (createRSeqHeader((long) sequenceNumber));
        return (RSeqHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return createRSeqHeader((long) sequenceNumber) ;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.981 -0400", hash_original_method = "CA4CA07B31DF6CB609C05636F40DB22F", hash_generated_method = "FE51A033526D3D37F6AE8BB12E7253FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RSeqHeader createRSeqHeader(long sequenceNumber) throws InvalidArgumentException {
        dsTaint.addTaint(sequenceNumber);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "invalid sequenceNumber arg " + sequenceNumber);
        RSeq rseq;
        rseq = new RSeq();
        rseq.setSeqNumber(sequenceNumber);
        return (RSeqHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (sequenceNumber < 0)
            //throw new InvalidArgumentException(
                //"invalid sequenceNumber arg " + sequenceNumber);
        //RSeq rseq = new RSeq();
        //rseq.setSeqNumber(sequenceNumber);
        //return rseq;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.981 -0400", hash_original_method = "57AD0B4E4FE03197F2B52972D6060CBA", hash_generated_method = "091B3F0C8FBFDB3AA31B582F7E9C181F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ReasonHeader createReasonHeader(
        String protocol,
        int cause,
        String text) throws InvalidArgumentException, ParseException {
        dsTaint.addTaint(text);
        dsTaint.addTaint(protocol);
        dsTaint.addTaint(cause);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("bad protocol arg");
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad cause");
        Reason reason;
        reason = new Reason();
        reason.setProtocol(protocol);
        reason.setCause(cause);
        reason.setText(text);
        return (ReasonHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (protocol == null)
            //throw new NullPointerException("bad protocol arg");
        //if (cause < 0)
            //throw new InvalidArgumentException("bad cause");
        //Reason reason = new Reason();
        //reason.setProtocol(protocol);
        //reason.setCause(cause);
        //reason.setText(text);
        //return reason;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.981 -0400", hash_original_method = "6DA29D8692407706B9B05391AF333993", hash_generated_method = "806DF823CCED3955BAFE449F8EAFCA58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RecordRouteHeader createRecordRouteHeader(Address address) {
        dsTaint.addTaint(address.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null argument!");
        RecordRoute recordRoute;
        recordRoute = new RecordRoute();
        recordRoute.setAddress(address);
        return (RecordRouteHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if ( address == null) throw new NullPointerException("Null argument!");
        //RecordRoute recordRoute = new RecordRoute();
        //recordRoute.setAddress(address);
        //return recordRoute;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.981 -0400", hash_original_method = "4393C033D6B63EF338EB93DE3E753573", hash_generated_method = "CAE17EE130979198402550928D610AC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ReplyToHeader createReplyToHeader(Address address) {
        dsTaint.addTaint(address.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address");
        ReplyTo replyTo;
        replyTo = new ReplyTo();
        replyTo.setAddress(address);
        return (ReplyToHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address");
        //ReplyTo replyTo = new ReplyTo();
        //replyTo.setAddress(address);
        //return replyTo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.982 -0400", hash_original_method = "F65B5EA444DA08358E800CD7B469501A", hash_generated_method = "686B75AED482ED12F4D0C0B739976DBE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RequireHeader createRequireHeader(String optionTag) throws ParseException {
        dsTaint.addTaint(optionTag);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null optionTag");
        Require require;
        require = new Require();
        require.setOptionTag(optionTag);
        return (RequireHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (optionTag == null)
            //throw new NullPointerException("null optionTag");
        //Require require = new Require();
        //require.setOptionTag(optionTag);
        //return require;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.982 -0400", hash_original_method = "43D5E8C96E4C1ED3ED5B8AD5C39C801C", hash_generated_method = "7CF0B2C2D7BA12047B7F5AC45FBD954A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RetryAfterHeader createRetryAfterHeader(int retryAfter) throws InvalidArgumentException {
        dsTaint.addTaint(retryAfter);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad retryAfter arg");
        RetryAfter r;
        r = new RetryAfter();
        r.setRetryAfter(retryAfter);
        return (RetryAfterHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (retryAfter < 0)
            //throw new InvalidArgumentException("bad retryAfter arg");
        //RetryAfter r = new RetryAfter();
        //r.setRetryAfter(retryAfter);
        //return r;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.982 -0400", hash_original_method = "03611E3BB30258B8EC4FDC9F783CBCCF", hash_generated_method = "A5692F556698F1FA158BD081A0FB0022")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RouteHeader createRouteHeader(Address address) {
        dsTaint.addTaint(address.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address arg");
        Route route;
        route = new Route();
        route.setAddress(address);
        return (RouteHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address arg");
        //Route route = new Route();
        //route.setAddress(address);
        //return route;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.982 -0400", hash_original_method = "65AF02D93E753F97E0AF00F542D03529", hash_generated_method = "75AC75FA1504AC1078671DD800ACF15A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServerHeader createServerHeader(List product) throws ParseException {
        dsTaint.addTaint(product.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null productList arg");
        Server server;
        server = new Server();
        server.setProduct(product);
        return (ServerHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (product == null)
            //throw new NullPointerException("null productList arg");
        //Server server = new Server();
        //server.setProduct(product);
        //return server;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.982 -0400", hash_original_method = "288EA55C0FFC9E81469649B581E59F71", hash_generated_method = "C202982EA50345CE8557BF364F1A3DAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SubjectHeader createSubjectHeader(String subject) throws ParseException {
        dsTaint.addTaint(subject);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null subject arg");
        Subject s;
        s = new Subject();
        s.setSubject(subject);
        return (SubjectHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (subject == null)
            //throw new NullPointerException("null subject arg");
        //Subject s = new Subject();
        //s.setSubject(subject);
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.983 -0400", hash_original_method = "9B68B72DA8144991BC14639C6BE11723", hash_generated_method = "DB65EF9A5680C3EBE1C665C1756DF67C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SubscriptionStateHeader createSubscriptionStateHeader(String subscriptionState) throws ParseException {
        dsTaint.addTaint(subscriptionState);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null subscriptionState arg");
        SubscriptionState s;
        s = new SubscriptionState();
        s.setState(subscriptionState);
        return (SubscriptionStateHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (subscriptionState == null)
            //throw new NullPointerException("null subscriptionState arg");
        //SubscriptionState s = new SubscriptionState();
        //s.setState(subscriptionState);
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.983 -0400", hash_original_method = "589849ECCDAFDA20BE0DBE1D9A436669", hash_generated_method = "776B4BC729BBEA6D078D52C5BF5642E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SupportedHeader createSupportedHeader(String optionTag) throws ParseException {
        dsTaint.addTaint(optionTag);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null optionTag arg");
        Supported supported;
        supported = new Supported();
        supported.setOptionTag(optionTag);
        return (SupportedHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (optionTag == null)
            //throw new NullPointerException("null optionTag arg");
        //Supported supported = new Supported();
        //supported.setOptionTag(optionTag);
        //return supported;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.983 -0400", hash_original_method = "380079DA7F92D6CF2CEA9086AA5F92D7", hash_generated_method = "6FD0E8DC451700E4B8459C5AAD90081B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TimeStampHeader createTimeStampHeader(float timeStamp) throws InvalidArgumentException {
        dsTaint.addTaint(timeStamp);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("illegal timeStamp");
        TimeStamp t;
        t = new TimeStamp();
        t.setTimeStamp(timeStamp);
        return (TimeStampHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (timeStamp < 0)
            //throw new IllegalArgumentException("illegal timeStamp");
        //TimeStamp t = new TimeStamp();
        //t.setTimeStamp(timeStamp);
        //return t;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.983 -0400", hash_original_method = "7928C6AF630E4BCE57D31FA4979B7453", hash_generated_method = "631AA2E5F6EBAAE44C60144FAA8CF4A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ToHeader createToHeader(Address address, String tag) throws ParseException {
        dsTaint.addTaint(address.dsTaint);
        dsTaint.addTaint(tag);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address");
        To to;
        to = new To();
        to.setAddress(address);
        to.setTag(tag);
        return (ToHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address");
        //To to = new To();
        //to.setAddress(address);
        //if (tag != null)
            //to.setTag(tag);
        //return to;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.983 -0400", hash_original_method = "9A62FFB59334167B71BC2FE402276C31", hash_generated_method = "32F53FCED69C574E4EE7F739021CDC44")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UnsupportedHeader createUnsupportedHeader(String optionTag) throws ParseException {
        dsTaint.addTaint(optionTag);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(optionTag);
        Unsupported unsupported;
        unsupported = new Unsupported();
        unsupported.setOptionTag(optionTag);
        return (UnsupportedHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (optionTag == null)
            //throw new NullPointerException(optionTag);
        //Unsupported unsupported = new Unsupported();
        //unsupported.setOptionTag(optionTag);
        //return unsupported;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.984 -0400", hash_original_method = "0FDDC4550D32FE0A8E48193D044787BB", hash_generated_method = "A1A0671AF9D5A7AFCA19AB8787BC69C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UserAgentHeader createUserAgentHeader(List product) throws ParseException {
        dsTaint.addTaint(product.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null user agent");
        UserAgent userAgent;
        userAgent = new UserAgent();
        userAgent.setProduct(product);
        return (UserAgentHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (product == null)
            //throw new NullPointerException("null user agent");
        //UserAgent userAgent = new UserAgent();
        //userAgent.setProduct(product);
        //return userAgent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.984 -0400", hash_original_method = "B7A9F5DC521617567AEB2EDF2366DE24", hash_generated_method = "F623841798BD3FF9381CDB5E66BC5644")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViaHeader createViaHeader(
        String host,
        int port,
        String transport,
        String branch) throws ParseException, InvalidArgumentException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(host);
        dsTaint.addTaint(transport);
        dsTaint.addTaint(branch);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        Via via;
        via = new Via();
        via.setBranch(branch);
        {
            boolean var892BBD36F1835D9F17C0D62A38310742_1192779635 = (host.indexOf(':') >= 0
            && host.indexOf('[') < 0);
            {
                {
                    int zoneStart;
                    zoneStart = host.indexOf('%');
                    host = host.substring(0, zoneStart);
                } //End block
                host = '[' + host + ']';
            } //End block
        } //End collapsed parenthetic
        via.setHost(host);
        via.setPort(port);
        via.setTransport(transport);
        return (ViaHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (host == null || transport == null)
            //throw new NullPointerException("null arg");
        //Via via = new Via();
        //if (branch != null)
            //via.setBranch(branch);
        //if(host.indexOf(':') >= 0
            //&& host.indexOf('[') < 0)
        //{
            //if(stripAddressScopeZones)
            //{
                //int zoneStart = host.indexOf('%');
                //if(zoneStart != -1)
                    //host = host.substring(0, zoneStart);
            //}
            //host = '[' + host + ']';
        //}
        //via.setHost(host);
        //via.setPort(port);
        //via.setTransport(transport);
        //return via;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.984 -0400", hash_original_method = "EDE3AD5442B3DE671B6476C917BB6D0F", hash_generated_method = "234E1A774B5D1004A6D0D86BD2E06BFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WWWAuthenticateHeader createWWWAuthenticateHeader(String scheme) throws ParseException {
        dsTaint.addTaint(scheme);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null scheme");
        WWWAuthenticate www;
        www = new WWWAuthenticate();
        www.setScheme(scheme);
        return (WWWAuthenticateHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (scheme == null)
            //throw new NullPointerException("null scheme");
        //WWWAuthenticate www = new WWWAuthenticate();
        //www.setScheme(scheme);
        //return www;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.985 -0400", hash_original_method = "F34478A6D1616AB2836BA2A212AE0D49", hash_generated_method = "E721927FC53970087D4AE5C43A4371CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WarningHeader createWarningHeader(
        String agent,
        int code,
        String comment) throws ParseException, InvalidArgumentException {
        dsTaint.addTaint(code);
        dsTaint.addTaint(comment);
        dsTaint.addTaint(agent);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        Warning warning;
        warning = new Warning();
        warning.setAgent(agent);
        warning.setCode(code);
        warning.setText(comment);
        return (WarningHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (agent == null)
            //throw new NullPointerException("null arg");
        //Warning warning = new Warning();
        //warning.setAgent(agent);
        //warning.setCode(code);
        //warning.setText(comment);
        //return warning;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.985 -0400", hash_original_method = "CB42C1424760C62123C05E2F8CB60B35", hash_generated_method = "507CC2B7B5066F2FBA671840901C405C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ErrorInfoHeader createErrorInfoHeader(URI errorInfo) {
        dsTaint.addTaint(errorInfo.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        ErrorInfoHeader var6DC19D7EFE49A5445384B22FF61AC113_1836843922 = (new ErrorInfo((GenericURI) errorInfo));
        return (ErrorInfoHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (errorInfo == null)
            //throw new NullPointerException("null arg");
        //return new ErrorInfo((GenericURI) errorInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.985 -0400", hash_original_method = "7E6122EDAE408D205AF0C9E45A024F04", hash_generated_method = "6254992B97970E3E13D4E06CCEF3A38D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public javax.sip.header.Header createHeader(String headerText) throws ParseException {
        dsTaint.addTaint(headerText);
        StringMsgParser smp;
        smp = new StringMsgParser();
        SIPHeader sipHeader;
        sipHeader = smp.parseSIPHeader(headerText.trim());
        {
            {
                boolean var376AECF828F744DA20E1ADDFF5E39535_2047228207 = (((SIPHeaderList) sipHeader).size() > 1);
                {
                    if (DroidSafeAndroidRuntime.control) throw new ParseException(
                    "Only singleton allowed " + headerText,
                    0);
                } //End block
                {
                    boolean varB2077481A39B1082F8C4F3463BCDED80_401391943 = (((SIPHeaderList) sipHeader).size() == 0);
                    {
                        try 
                        {
                            javax.sip.header.Header varBB1E57E1E96D4039C7DDD959B440E457_710717997 = ((Header) ((SIPHeaderList) sipHeader)
                        .getMyClass()
                        .newInstance());
                        } //End block
                        catch (InstantiationException ex)
                        {
                            ex.printStackTrace();
                        } //End block
                        catch (IllegalAccessException ex)
                        {
                            ex.printStackTrace();
                        } //End block
                    } //End block
                    {
                        javax.sip.header.Header varE50C9F3C5311371D9D04EA48E9F3814B_1877264023 = ((Header) ((SIPHeaderList) sipHeader).getFirst());
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        return (javax.sip.header.Header)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.986 -0400", hash_original_method = "BE8A77015DA0080195A899A1BFDA2B08", hash_generated_method = "989BE275ABEF2EBAFC21067BCC65CE0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public javax.sip.header.Header createHeader(
        String headerName,
        String headerValue) throws java.text.ParseException {
        dsTaint.addTaint(headerValue);
        dsTaint.addTaint(headerName);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("header name is null");
        String hdrText;
        hdrText = new StringBuffer()
                .append(headerName)
                .append(":")
                .append(headerValue)
                .toString();
        javax.sip.header.Header varF117C52D2CE6D297F36EF2D593E445B2_1222758003 = (createHeader(hdrText));
        return (javax.sip.header.Header)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (headerName == null)
            //throw new NullPointerException("header name is null");
        //String hdrText =
            //new StringBuffer()
                //.append(headerName)
                //.append(":")
                //.append(headerValue)
                //.toString();
        //return createHeader(hdrText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.986 -0400", hash_original_method = "FDCDF9463F1CDDAF0BCBB63B8B4D05F5", hash_generated_method = "CC8426F5EE5448D54CEB8047730D8B6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public java.util.List createHeaders(String headers) throws java.text.ParseException {
        dsTaint.addTaint(headers);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg!");
        StringMsgParser smp;
        smp = new StringMsgParser();
        SIPHeader shdr;
        shdr = smp.parseSIPHeader(headers);
        if (DroidSafeAndroidRuntime.control) throw new ParseException(
                "List of headers of this type is not allowed in a message",
                0);
        return (java.util.List)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (headers == null)
            //throw new NullPointerException("null arg!");
        //StringMsgParser smp = new StringMsgParser();
        //SIPHeader shdr = smp.parseSIPHeader(headers);
        //if (shdr instanceof SIPHeaderList)
            //return (SIPHeaderList) shdr;
        //else
            //throw new ParseException(
                //"List of headers of this type is not allowed in a message",
                //0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.986 -0400", hash_original_method = "5541F8A2ED86060178CAD1F0D5BA2507", hash_generated_method = "2D1F072ABE3C95C380E71A45E88DF49D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ReferToHeader createReferToHeader(Address address) {
        dsTaint.addTaint(address.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address!");
        ReferTo referTo;
        referTo = new ReferTo();
        referTo.setAddress(address);
        return (ReferToHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address!");
        //ReferTo referTo = new ReferTo();
        //referTo.setAddress(address);
        //return referTo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.986 -0400", hash_original_method = "A51D0E58D36C2041DD351AE4FDD73BCF", hash_generated_method = "4A9BD728739607C547330141D72AB2F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ReferredByHeader createReferredByHeader(Address address) {
        dsTaint.addTaint(address.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address!");
        ReferredBy referredBy;
        referredBy = new ReferredBy();
        referredBy.setAddress(address);
        return (ReferredByHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address!");
        //ReferredBy referredBy = new ReferredBy();
        //referredBy.setAddress(address);
        //return referredBy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.986 -0400", hash_original_method = "E3BB57144A133C8AFDA0829EAE12FAAB", hash_generated_method = "1AD954E4D223C0C088F4394DD729B914")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ReplacesHeader createReplacesHeader(String callId, String toTag,
                String fromTag) throws ParseException {
        dsTaint.addTaint(toTag);
        dsTaint.addTaint(fromTag);
        dsTaint.addTaint(callId);
        Replaces replaces;
        replaces = new Replaces();
        replaces.setCallId(callId);
        replaces.setFromTag(fromTag);
        replaces.setToTag(toTag);
        return (ReplacesHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Replaces replaces = new Replaces();
        //replaces.setCallId(callId);
        //replaces.setFromTag(fromTag);
        //replaces.setToTag(toTag);
        //return replaces;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.987 -0400", hash_original_method = "C42E665E40D735B4BFD234363CD8C238", hash_generated_method = "0529941A751A35F6F371BBA12AE67D72")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JoinHeader createJoinHeader(String callId, String toTag,
                String fromTag) throws ParseException {
        dsTaint.addTaint(toTag);
        dsTaint.addTaint(fromTag);
        dsTaint.addTaint(callId);
        Join join;
        join = new Join();
        join.setCallId(callId);
        join.setFromTag(fromTag);
        join.setToTag(toTag);
        return (JoinHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Join join = new Join();
        //join.setCallId(callId);
        //join.setFromTag(fromTag);
        //join.setToTag(toTag);
        //return join;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.987 -0400", hash_original_method = "95F88F9209912EE6FCAFCB830227A87B", hash_generated_method = "6890DA398CEA9623F6331304D04CDEB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPETagHeader createSIPETagHeader(String etag) throws ParseException {
        dsTaint.addTaint(etag);
        SIPETagHeader var3069C65E235469DE3C80A7E1685FB817_419399262 = (new SIPETag(etag));
        return (SIPETagHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new SIPETag(etag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.987 -0400", hash_original_method = "9EE2B60A802A938BDC15DDB307A8B1D7", hash_generated_method = "90154813A242529118E9753BD59ADE40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPIfMatchHeader createSIPIfMatchHeader(String etag) throws ParseException {
        dsTaint.addTaint(etag);
        SIPIfMatchHeader varEF847DBAA42F8341B775931BDEA0E2A2_1729094714 = (new SIPIfMatch(etag));
        return (SIPIfMatchHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new SIPIfMatch(etag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.987 -0400", hash_original_method = "5900AA55EC6D83D47F45CED3D37DDEC7", hash_generated_method = "886BE69D5C8037378F099AA7BF529635")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PAccessNetworkInfoHeader createPAccessNetworkInfoHeader() {
        PAccessNetworkInfo accessNetworkInfo;
        accessNetworkInfo = new PAccessNetworkInfo();
        return (PAccessNetworkInfoHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //PAccessNetworkInfo accessNetworkInfo = new PAccessNetworkInfo();
        //return accessNetworkInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.987 -0400", hash_original_method = "7A9453157C5A8C4FD99B8F34DC853877", hash_generated_method = "895D86A79AC9456E6CC375D60AE909A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PAssertedIdentityHeader createPAssertedIdentityHeader(Address address) throws NullPointerException, ParseException {
        dsTaint.addTaint(address.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address!");
        PAssertedIdentity assertedIdentity;
        assertedIdentity = new PAssertedIdentity();
        assertedIdentity.setAddress(address);
        return (PAssertedIdentityHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address!");
        //PAssertedIdentity assertedIdentity = new PAssertedIdentity();
        //assertedIdentity.setAddress(address);
        //return assertedIdentity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.987 -0400", hash_original_method = "4BD897B5832A55E4A60E9B49C4611708", hash_generated_method = "8AD964828A8A5083D0389F4E0D623F06")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PAssociatedURIHeader createPAssociatedURIHeader(Address assocURI) {
        dsTaint.addTaint(assocURI.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null associatedURI!");
        PAssociatedURI associatedURI;
        associatedURI = new PAssociatedURI();
        associatedURI.setAddress(assocURI);
        return (PAssociatedURIHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (assocURI == null)
        //throw new NullPointerException("null associatedURI!");
        //PAssociatedURI associatedURI = new PAssociatedURI();
        //associatedURI.setAddress(assocURI);
        //return associatedURI;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.987 -0400", hash_original_method = "FD713420BE4BC11FE9D9AB43BBBEAD30", hash_generated_method = "4E929F4DF688685C3A46D5E8DFBCA0F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PCalledPartyIDHeader createPCalledPartyIDHeader(Address address) {
        dsTaint.addTaint(address.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address!");
        PCalledPartyID calledPartyID;
        calledPartyID = new PCalledPartyID();
        calledPartyID.setAddress(address);
        return (PCalledPartyIDHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address!");
        //PCalledPartyID calledPartyID = new PCalledPartyID();
        //calledPartyID.setAddress(address);
        //return calledPartyID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.988 -0400", hash_original_method = "F3DC851C781199B1B5D5ECAC93663797", hash_generated_method = "F255A525EE0ED8025A5B6E6455D540D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PChargingFunctionAddressesHeader createPChargingFunctionAddressesHeader() {
        PChargingFunctionAddresses cfa;
        cfa = new PChargingFunctionAddresses();
        return (PChargingFunctionAddressesHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //PChargingFunctionAddresses cfa = new PChargingFunctionAddresses();
        //return cfa;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.988 -0400", hash_original_method = "E82D256C40CCFC0E4431BA44734EBBF3", hash_generated_method = "2CAB9E4F32C0AFF24D69D3BB7A9FE849")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PChargingVectorHeader createChargingVectorHeader(String icid) throws ParseException {
        dsTaint.addTaint(icid);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null icid arg!");
        PChargingVector chargingVector;
        chargingVector = new PChargingVector();
        chargingVector.setICID(icid);
        return (PChargingVectorHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (icid == null)
        //throw new NullPointerException("null icid arg!");
        //PChargingVector chargingVector = new PChargingVector();
        //chargingVector.setICID(icid);
        //return chargingVector;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.988 -0400", hash_original_method = "FB93C1554D708A44568E0208A3D181E0", hash_generated_method = "631985AA094B159504434FF603BC4344")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PMediaAuthorizationHeader createPMediaAuthorizationHeader(String token) throws InvalidArgumentException, ParseException {
        dsTaint.addTaint(token);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("The Media-Authorization-Token parameter is null or empty");
        PMediaAuthorization mediaAuthorization;
        mediaAuthorization = new PMediaAuthorization();
        mediaAuthorization.setMediaAuthorizationToken(token);
        return (PMediaAuthorizationHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (token == null || token == "")
            //throw new InvalidArgumentException("The Media-Authorization-Token parameter is null or empty");
        //PMediaAuthorization mediaAuthorization = new PMediaAuthorization();
        //mediaAuthorization.setMediaAuthorizationToken(token);
        //return mediaAuthorization;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.988 -0400", hash_original_method = "3BA03116BEA38D71B8C38B4BA62E5B71", hash_generated_method = "221A71CC9DA3BB1FF8E129F6C8D564C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PPreferredIdentityHeader createPPreferredIdentityHeader(Address address) {
        dsTaint.addTaint(address.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address!");
        PPreferredIdentity preferredIdentity;
        preferredIdentity = new PPreferredIdentity();
        preferredIdentity.setAddress(address);
        return (PPreferredIdentityHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address!");
        //PPreferredIdentity preferredIdentity = new PPreferredIdentity();
        //preferredIdentity.setAddress(address);
        //return preferredIdentity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.988 -0400", hash_original_method = "B32CA202259A9B847AD818F044EE39DA", hash_generated_method = "D6F7522BE1963D80D5C545CAD8603915")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PVisitedNetworkIDHeader createPVisitedNetworkIDHeader() {
        PVisitedNetworkID visitedNetworkID;
        visitedNetworkID = new PVisitedNetworkID();
        return (PVisitedNetworkIDHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //PVisitedNetworkID visitedNetworkID = new PVisitedNetworkID();
        //return visitedNetworkID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.988 -0400", hash_original_method = "537B18CC29F2C70486994281CB29500B", hash_generated_method = "2504D97D950BDCF36DBDB6D50B7D2756")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PathHeader createPathHeader(Address address) {
        dsTaint.addTaint(address.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address!");
        Path path;
        path = new Path();
        path.setAddress(address);
        return (PathHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address!");
        //Path path = new Path();
        //path.setAddress(address);
        //return path;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.993 -0400", hash_original_method = "85C1BF55B1F968333EFFBCF4DBC75BE6", hash_generated_method = "807AD17A53911343A4635BB5D8179EC9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrivacyHeader createPrivacyHeader(String privacyType) {
        dsTaint.addTaint(privacyType);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null privacyType arg");
        Privacy privacy;
        privacy = new Privacy(privacyType);
        return (PrivacyHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (privacyType == null)
            //throw new NullPointerException("null privacyType arg");
        //Privacy privacy = new Privacy(privacyType);
        //return privacy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.994 -0400", hash_original_method = "A7CA2EB6DD40139D85B6778D2C783F9F", hash_generated_method = "148CDB6A153FAE99E37D4913E3EEE2F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServiceRouteHeader createServiceRouteHeader(Address address) {
        dsTaint.addTaint(address.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address!");
        ServiceRoute serviceRoute;
        serviceRoute = new ServiceRoute();
        serviceRoute.setAddress(address);
        return (ServiceRouteHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address!");
        //ServiceRoute serviceRoute = new ServiceRoute();
        //serviceRoute.setAddress(address);
        //return serviceRoute;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.994 -0400", hash_original_method = "7A3E4AE36777C6F2CF79A6B3882A3053", hash_generated_method = "CEFDA47883F293CA249B0DC8315284A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SecurityServerHeader createSecurityServerHeader() {
        SecurityServer secServer;
        secServer = new SecurityServer();
        return (SecurityServerHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SecurityServer secServer = new SecurityServer();
        //return secServer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.994 -0400", hash_original_method = "2361364E4BB205FAC2A8F8549D9431F6", hash_generated_method = "460B8C8F59A90D00012AE662FC6B74F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SecurityClientHeader createSecurityClientHeader() {
        SecurityClient secClient;
        secClient = new SecurityClient();
        return (SecurityClientHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SecurityClient secClient = new SecurityClient();
        //return secClient;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.994 -0400", hash_original_method = "1063C2554F38236C917DADCB6A55ADB8", hash_generated_method = "7B187ED0C7B14E82725550B6CB5FF6F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SecurityVerifyHeader createSecurityVerifyHeader() {
        SecurityVerify secVerify;
        secVerify = new SecurityVerify();
        return (SecurityVerifyHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SecurityVerify secVerify = new SecurityVerify();
        //return secVerify;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.995 -0400", hash_original_method = "2DDC01C5DAA0917C6B8BE6B8A00F5568", hash_generated_method = "3187660888122BBEF431A913C9D21651")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PUserDatabaseHeader createPUserDatabaseHeader(String databaseName) {
        dsTaint.addTaint(databaseName);
        {
            boolean varAC311902DF4878F599DD65CB8A1544C9_1477150637 = ((databaseName ==null)||(databaseName.equals(" ")));
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Database name is null");
        } //End collapsed parenthetic
        PUserDatabase pUserDatabase;
        pUserDatabase = new PUserDatabase();
        pUserDatabase.setDatabaseName(databaseName);
        return (PUserDatabaseHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if((databaseName ==null)||(databaseName.equals(" ")))
            //throw new NullPointerException("Database name is null");
        //PUserDatabase pUserDatabase = new PUserDatabase();
        //pUserDatabase.setDatabaseName(databaseName);
        //return pUserDatabase;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.995 -0400", hash_original_method = "6A0691F102D20D70FD0A6921A61CA118", hash_generated_method = "E013ECD5853A4A65C32573724194275B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PProfileKeyHeader createPProfileKeyHeader(Address address) {
        dsTaint.addTaint(address.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Address is null");
        PProfileKey pProfileKey;
        pProfileKey = new PProfileKey();
        pProfileKey.setAddress(address);
        return (PProfileKeyHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (address ==null)
            //throw new NullPointerException("Address is null");
        //PProfileKey pProfileKey = new PProfileKey();
        //pProfileKey.setAddress(address);
        //return pProfileKey;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.995 -0400", hash_original_method = "38B7C1667A9FD579C07BB14E255FF56A", hash_generated_method = "A96C96D0E0FED8696E13586F172FFC41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PServedUserHeader createPServedUserHeader(Address address) {
        dsTaint.addTaint(address.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Address is null");
        PServedUser psu;
        psu = new PServedUser();
        psu.setAddress(address);
        return (PServedUserHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if(address==null)
            //throw new NullPointerException("Address is null");
        //PServedUser psu = new PServedUser();
        //psu.setAddress(address);
        //return psu;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.995 -0400", hash_original_method = "C0CFD4DCC2CCE8A2BE967D3A2132C68A", hash_generated_method = "0BCED0D98258A32F6E9C0756E516A414")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PPreferredServiceHeader createPPreferredServiceHeader() {
        PPreferredService pps;
        pps = new PPreferredService();
        return (PPreferredServiceHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //PPreferredService pps = new PPreferredService();
        //return pps;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.995 -0400", hash_original_method = "48E529894AF92157CD42EE8DFB6E18AB", hash_generated_method = "30358C5D9149B9A07557F0801F2A17D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PAssertedServiceHeader createPAssertedServiceHeader() {
        PAssertedService pas;
        pas = new PAssertedService();
        return (PAssertedServiceHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //PAssertedService pas = new PAssertedService();
        //return pas;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.996 -0400", hash_original_method = "6D472F26B8815D9A75157924D7DB3DB8", hash_generated_method = "BB795884E6ABCE1C9A557F0E437894A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SessionExpiresHeader createSessionExpiresHeader(int expires) throws InvalidArgumentException {
        dsTaint.addTaint(expires);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad value " + expires);
        SessionExpires s;
        s = new SessionExpires();
        s.setExpires(expires);
        return (SessionExpiresHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (expires < 0)
            //throw new InvalidArgumentException("bad value " + expires);
        //SessionExpires s = new SessionExpires();
        //s.setExpires(expires);
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.996 -0400", hash_original_method = "F07701895F7EA99F66D330A17A2FD28D", hash_generated_method = "FA9CA3787E57564210C0B0C1B1B7AB95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SipRequestLine createRequestLine(String requestLine) throws ParseException {
        dsTaint.addTaint(requestLine);
        RequestLineParser requestLineParser;
        requestLineParser = new RequestLineParser(requestLine);
        SipRequestLine var10CBB73868EAD7E0CDE6BC2F0EB26CCF_1373584068 = ((SipRequestLine) requestLineParser.parse());
        return (SipRequestLine)dsTaint.getTaint();
        // ---------- Original Method ----------
        //RequestLineParser requestLineParser = new RequestLineParser(requestLine);
        //return (SipRequestLine) requestLineParser.parse();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.996 -0400", hash_original_method = "94ED81BC52F6E3EE358EE57713F40357", hash_generated_method = "4776B3D543107C5E24D3965284DF0C92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SipStatusLine createStatusLine(String statusLine) throws ParseException {
        dsTaint.addTaint(statusLine);
        StatusLineParser statusLineParser;
        statusLineParser = new StatusLineParser(statusLine);
        SipStatusLine varF6BBE388002C96E17FC3DCF6A48D81FA_1746010253 = ((SipStatusLine) statusLineParser.parse());
        return (SipStatusLine)dsTaint.getTaint();
        // ---------- Original Method ----------
        //StatusLineParser statusLineParser = new StatusLineParser(statusLine);
        //return (SipStatusLine) statusLineParser.parse();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.996 -0400", hash_original_method = "B06A6A8CC80D9698711113EFD1E58499", hash_generated_method = "1D97B554D9B9C922895F186718BF8C5A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ReferencesHeader createReferencesHeader(String callId, String rel) throws ParseException {
        dsTaint.addTaint(rel);
        dsTaint.addTaint(callId);
        ReferencesHeader retval;
        retval = new References();
        retval.setCallId(callId);
        retval.setRel(rel);
        return (ReferencesHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ReferencesHeader retval = new References();
        //retval.setCallId(callId);
        //retval.setRel(rel);
        //return retval;
    }

    
}

