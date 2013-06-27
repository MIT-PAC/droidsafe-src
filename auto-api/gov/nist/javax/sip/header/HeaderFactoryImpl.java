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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.120 -0400", hash_original_field = "6FA63D73209D74D0D54BC416A32DB10D", hash_generated_field = "0D2878F1D6B0CD805C869443DA7FE75E")

    private boolean stripAddressScopeZones = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.122 -0400", hash_original_method = "EA4ABB94B4CFEF029E31D8F450F44C66", hash_generated_method = "4DBE2EDCEE71001244079D3C05C060E8")
    public  HeaderFactoryImpl() {
        stripAddressScopeZones
            = Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
        // ---------- Original Method ----------
        //stripAddressScopeZones
            //= Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.123 -0400", hash_original_method = "9BEACA878DCF694953AD8141227DB60F", hash_generated_method = "EC22EB8666E3DDC0B2C501EFE162CB63")
    public void setPrettyEncoding(boolean flag) {
        SIPHeaderList.setPrettyEncode(flag);
        addTaint(flag);
        // ---------- Original Method ----------
        //SIPHeaderList.setPrettyEncode(flag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.124 -0400", hash_original_method = "58113BBBA3D76308CFB19C46D0FF7A27", hash_generated_method = "F564760B9722EDC3A21D42B1338A9785")
    public AcceptEncodingHeader createAcceptEncodingHeader(String encoding) throws ParseException {
        AcceptEncodingHeader varB4EAC82CA7396A68D541C85D26508E83_1789135174 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("the encoding parameter is null");
        AcceptEncoding acceptEncoding;
        acceptEncoding = new AcceptEncoding();
        acceptEncoding.setEncoding(encoding);
        varB4EAC82CA7396A68D541C85D26508E83_1789135174 = acceptEncoding;
        addTaint(encoding.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1789135174.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1789135174;
        // ---------- Original Method ----------
        //if (encoding == null)
            //throw new NullPointerException("the encoding parameter is null");
        //AcceptEncoding acceptEncoding = new AcceptEncoding();
        //acceptEncoding.setEncoding(encoding);
        //return acceptEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.127 -0400", hash_original_method = "3FEA70547EDCF31E1AA086D3362AC6CE", hash_generated_method = "4942E0ACDD8D084A41F70031E424E3A4")
    public AcceptHeader createAcceptHeader(
        String contentType,
        String contentSubType) throws ParseException {
        AcceptHeader varB4EAC82CA7396A68D541C85D26508E83_891922037 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("contentType or subtype is null ");
        Accept accept;
        accept = new Accept();
        accept.setContentType(contentType);
        accept.setContentSubType(contentSubType);
        varB4EAC82CA7396A68D541C85D26508E83_891922037 = accept;
        addTaint(contentType.getTaint());
        addTaint(contentSubType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_891922037.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_891922037;
        // ---------- Original Method ----------
        //if (contentType == null || contentSubType == null)
            //throw new NullPointerException("contentType or subtype is null ");
        //Accept accept = new Accept();
        //accept.setContentType(contentType);
        //accept.setContentSubType(contentSubType);
        //return accept;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.132 -0400", hash_original_method = "5AF5E9D92982780781CC81035C3C1529", hash_generated_method = "0479A5A52E4EC17730A6E00A9BBDF11C")
    public AcceptLanguageHeader createAcceptLanguageHeader(Locale language) {
        AcceptLanguageHeader varB4EAC82CA7396A68D541C85D26508E83_1120355606 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        AcceptLanguage acceptLanguage;
        acceptLanguage = new AcceptLanguage();
        acceptLanguage.setAcceptLanguage(language);
        varB4EAC82CA7396A68D541C85D26508E83_1120355606 = acceptLanguage;
        addTaint(language.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1120355606.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1120355606;
        // ---------- Original Method ----------
        //if (language == null)
            //throw new NullPointerException("null arg");
        //AcceptLanguage acceptLanguage = new AcceptLanguage();
        //acceptLanguage.setAcceptLanguage(language);
        //return acceptLanguage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.133 -0400", hash_original_method = "3E0D5311E2AF98CBAC12E04C1647AAA5", hash_generated_method = "A9061A635BBC5DACEF6C71724F4202CF")
    public AlertInfoHeader createAlertInfoHeader(URI alertInfo) {
        AlertInfoHeader varB4EAC82CA7396A68D541C85D26508E83_1794930473 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg alertInfo");
        AlertInfo a;
        a = new AlertInfo();
        a.setAlertInfo(alertInfo);
        varB4EAC82CA7396A68D541C85D26508E83_1794930473 = a;
        addTaint(alertInfo.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1794930473.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1794930473;
        // ---------- Original Method ----------
        //if (alertInfo == null)
            //throw new NullPointerException("null arg alertInfo");
        //AlertInfo a = new AlertInfo();
        //a.setAlertInfo(alertInfo);
        //return a;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.137 -0400", hash_original_method = "7A8DE3D3022A3669E75EC61B4D0B5F19", hash_generated_method = "9B7BD7185B219B3F0F880A0A66A5A2F6")
    public AllowEventsHeader createAllowEventsHeader(String eventType) throws ParseException {
        AllowEventsHeader varB4EAC82CA7396A68D541C85D26508E83_791050660 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg eventType");
        AllowEvents allowEvents;
        allowEvents = new AllowEvents();
        allowEvents.setEventType(eventType);
        varB4EAC82CA7396A68D541C85D26508E83_791050660 = allowEvents;
        addTaint(eventType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_791050660.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_791050660;
        // ---------- Original Method ----------
        //if (eventType == null)
            //throw new NullPointerException("null arg eventType");
        //AllowEvents allowEvents = new AllowEvents();
        //allowEvents.setEventType(eventType);
        //return allowEvents;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.138 -0400", hash_original_method = "C562ECE8E2158A54C27A4525D88FEA63", hash_generated_method = "148EF442F99B431597E0402A0186B8D9")
    public AllowHeader createAllowHeader(String method) throws ParseException {
        AllowHeader varB4EAC82CA7396A68D541C85D26508E83_253718245 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg method");
        Allow allow;
        allow = new Allow();
        allow.setMethod(method);
        varB4EAC82CA7396A68D541C85D26508E83_253718245 = allow;
        addTaint(method.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_253718245.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_253718245;
        // ---------- Original Method ----------
        //if (method == null)
            //throw new NullPointerException("null arg method");
        //Allow allow = new Allow();
        //allow.setMethod(method);
        //return allow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.147 -0400", hash_original_method = "E72D81A306A857A102E9D4437AB18CA6", hash_generated_method = "2CE152FDF4B8FBBC169613A88487BC64")
    public AuthenticationInfoHeader createAuthenticationInfoHeader(String response) throws ParseException {
        AuthenticationInfoHeader varB4EAC82CA7396A68D541C85D26508E83_1623054577 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg response");
        AuthenticationInfo auth;
        auth = new AuthenticationInfo();
        auth.setResponse(response);
        varB4EAC82CA7396A68D541C85D26508E83_1623054577 = auth;
        addTaint(response.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1623054577.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1623054577;
        // ---------- Original Method ----------
        //if (response == null)
            //throw new NullPointerException("null arg response");
        //AuthenticationInfo auth = new AuthenticationInfo();
        //auth.setResponse(response);
        //return auth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.156 -0400", hash_original_method = "F250EC80C8CD1CBE5FF237A98CBD8CD0", hash_generated_method = "7AD4D86DBD5ED9B6169ED3020C909FE9")
    public AuthorizationHeader createAuthorizationHeader(String scheme) throws ParseException {
        AuthorizationHeader varB4EAC82CA7396A68D541C85D26508E83_1323843656 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg scheme ");
        Authorization auth;
        auth = new Authorization();
        auth.setScheme(scheme);
        varB4EAC82CA7396A68D541C85D26508E83_1323843656 = auth;
        addTaint(scheme.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1323843656.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1323843656;
        // ---------- Original Method ----------
        //if (scheme == null)
            //throw new NullPointerException("null arg scheme ");
        //Authorization auth = new Authorization();
        //auth.setScheme(scheme);
        //return auth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.157 -0400", hash_original_method = "9707416B5040BCEA07917ADCBF33DA70", hash_generated_method = "7968EE1A7130803F94F128C75FCEC9E5")
    public CSeqHeader createCSeqHeader( long sequenceNumber, String method) throws ParseException, InvalidArgumentException {
        CSeqHeader varB4EAC82CA7396A68D541C85D26508E83_1856824760 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad arg " + sequenceNumber);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg method");
        CSeq cseq;
        cseq = new CSeq();
        cseq.setMethod(method);
        cseq.setSeqNumber(sequenceNumber);
        varB4EAC82CA7396A68D541C85D26508E83_1856824760 = cseq;
        addTaint(sequenceNumber);
        addTaint(method.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1856824760.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1856824760;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.161 -0400", hash_original_method = "332D5DD16F528ACCDED76BFE26F4F243", hash_generated_method = "87C7599A367274F222EFFF20ED18C986")
    public CSeqHeader createCSeqHeader( int sequenceNumber, String method) throws ParseException, InvalidArgumentException {
        CSeqHeader varB4EAC82CA7396A68D541C85D26508E83_673520556 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_673520556 = this.createCSeqHeader( (long) sequenceNumber, method );
        addTaint(sequenceNumber);
        addTaint(method.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_673520556.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_673520556;
        // ---------- Original Method ----------
        //return this.createCSeqHeader( (long) sequenceNumber, method );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.165 -0400", hash_original_method = "0CB560808F252622C176039BC6E86FF7", hash_generated_method = "1922ED14B08DADB8AF2479FCF54EA742")
    public CallIdHeader createCallIdHeader(String callId) throws ParseException {
        CallIdHeader varB4EAC82CA7396A68D541C85D26508E83_1820225073 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg callId");
        CallID c;
        c = new CallID();
        c.setCallId(callId);
        varB4EAC82CA7396A68D541C85D26508E83_1820225073 = c;
        addTaint(callId.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1820225073.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1820225073;
        // ---------- Original Method ----------
        //if (callId == null)
            //throw new NullPointerException("null arg callId");
        //CallID c = new CallID();
        //c.setCallId(callId);
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.175 -0400", hash_original_method = "8867B6CA9EB8DB8DAA3F991D7B0AD5D9", hash_generated_method = "61024652B81A13637BBC348DDBAF35CB")
    public CallInfoHeader createCallInfoHeader(URI callInfo) {
        CallInfoHeader varB4EAC82CA7396A68D541C85D26508E83_801314517 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg callInfo");
        CallInfo c;
        c = new CallInfo();
        c.setInfo(callInfo);
        varB4EAC82CA7396A68D541C85D26508E83_801314517 = c;
        addTaint(callInfo.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_801314517.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_801314517;
        // ---------- Original Method ----------
        //if (callInfo == null)
            //throw new NullPointerException("null arg callInfo");
        //CallInfo c = new CallInfo();
        //c.setInfo(callInfo);
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.176 -0400", hash_original_method = "45EF0D9994A51A34EA10DF4A185E8F21", hash_generated_method = "F9BC5C1D67BAE7F7C42CF6F7F083E73C")
    public ContactHeader createContactHeader(Address address) {
        ContactHeader varB4EAC82CA7396A68D541C85D26508E83_1116012244 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg address");
        Contact contact;
        contact = new Contact();
        contact.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_1116012244 = contact;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1116012244.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1116012244;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null arg address");
        //Contact contact = new Contact();
        //contact.setAddress(address);
        //return contact;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.177 -0400", hash_original_method = "5873C88FB18B86DA11D334099F5AE064", hash_generated_method = "EE30980B0F85FBA2DA6766B75CA742B4")
    public ContactHeader createContactHeader() {
        ContactHeader varB4EAC82CA7396A68D541C85D26508E83_700514762 = null; //Variable for return #1
        Contact contact;
        contact = new Contact();
        contact.setWildCardFlag(true);
        contact.setExpires(0);
        varB4EAC82CA7396A68D541C85D26508E83_700514762 = contact;
        varB4EAC82CA7396A68D541C85D26508E83_700514762.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_700514762;
        // ---------- Original Method ----------
        //Contact contact = new Contact();
        //contact.setWildCardFlag(true);
        //contact.setExpires(0);
        //return contact;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.178 -0400", hash_original_method = "CC352C2425871DC27A0C55CF39D4ABAB", hash_generated_method = "DB2125C658AD43062DF36D42549AD9F8")
    public ContentDispositionHeader createContentDispositionHeader(String contentDisposition) throws ParseException {
        ContentDispositionHeader varB4EAC82CA7396A68D541C85D26508E83_1146221718 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg contentDisposition");
        ContentDisposition c;
        c = new ContentDisposition();
        c.setDispositionType(contentDisposition);
        varB4EAC82CA7396A68D541C85D26508E83_1146221718 = c;
        addTaint(contentDisposition.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1146221718.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1146221718;
        // ---------- Original Method ----------
        //if (contentDisposition == null)
            //throw new NullPointerException("null arg contentDisposition");
        //ContentDisposition c = new ContentDisposition();
        //c.setDispositionType(contentDisposition);
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.179 -0400", hash_original_method = "090104ADCCDA5F259494E038435257D1", hash_generated_method = "F74F554B166D56F575339C5188FF4CB4")
    public ContentEncodingHeader createContentEncodingHeader(String encoding) throws ParseException {
        ContentEncodingHeader varB4EAC82CA7396A68D541C85D26508E83_613434964 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null encoding");
        ContentEncoding c;
        c = new ContentEncoding();
        c.setEncoding(encoding);
        varB4EAC82CA7396A68D541C85D26508E83_613434964 = c;
        addTaint(encoding.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_613434964.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_613434964;
        // ---------- Original Method ----------
        //if (encoding == null)
            //throw new NullPointerException("null encoding");
        //ContentEncoding c = new ContentEncoding();
        //c.setEncoding(encoding);
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.179 -0400", hash_original_method = "CD027E2457CF527330FF9F4C0A972B91", hash_generated_method = "A888031E86282DA5B647DC4A5C696BEA")
    public ContentLanguageHeader createContentLanguageHeader(Locale contentLanguage) {
        ContentLanguageHeader varB4EAC82CA7396A68D541C85D26508E83_1674247988 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg contentLanguage");
        ContentLanguage c;
        c = new ContentLanguage();
        c.setContentLanguage(contentLanguage);
        varB4EAC82CA7396A68D541C85D26508E83_1674247988 = c;
        addTaint(contentLanguage.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1674247988.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1674247988;
        // ---------- Original Method ----------
        //if (contentLanguage == null)
            //throw new NullPointerException("null arg contentLanguage");
        //ContentLanguage c = new ContentLanguage();
        //c.setContentLanguage(contentLanguage);
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.180 -0400", hash_original_method = "DA3B5EC62F3E30804B07AD592D303E3E", hash_generated_method = "15695C85B448CB09BD2F26B03E50179E")
    public ContentLengthHeader createContentLengthHeader(int contentLength) throws InvalidArgumentException {
        ContentLengthHeader varB4EAC82CA7396A68D541C85D26508E83_1059012646 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad contentLength");
        ContentLength c;
        c = new ContentLength();
        c.setContentLength(contentLength);
        varB4EAC82CA7396A68D541C85D26508E83_1059012646 = c;
        addTaint(contentLength);
        varB4EAC82CA7396A68D541C85D26508E83_1059012646.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1059012646;
        // ---------- Original Method ----------
        //if (contentLength < 0)
            //throw new InvalidArgumentException("bad contentLength");
        //ContentLength c = new ContentLength();
        //c.setContentLength(contentLength);
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.193 -0400", hash_original_method = "BF42B4FF2E7F96D2FA4773C6E514B79D", hash_generated_method = "FE9362C0957E391709B65B206716C87B")
    public ContentTypeHeader createContentTypeHeader(
        String contentType,
        String contentSubType) throws ParseException {
        ContentTypeHeader varB4EAC82CA7396A68D541C85D26508E83_699790015 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null contentType or subType");
        ContentType c;
        c = new ContentType();
        c.setContentType(contentType);
        c.setContentSubType(contentSubType);
        varB4EAC82CA7396A68D541C85D26508E83_699790015 = c;
        addTaint(contentType.getTaint());
        addTaint(contentSubType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_699790015.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_699790015;
        // ---------- Original Method ----------
        //if (contentType == null || contentSubType == null)
            //throw new NullPointerException("null contentType or subType");
        //ContentType c = new ContentType();
        //c.setContentType(contentType);
        //c.setContentSubType(contentSubType);
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.193 -0400", hash_original_method = "F3D0948AB2AB5DCB4D46B0F9C4754A1D", hash_generated_method = "C8389EFFEE144DBE5EE925E61968C92A")
    public DateHeader createDateHeader(Calendar date) {
        DateHeader varB4EAC82CA7396A68D541C85D26508E83_1677881735 = null; //Variable for return #1
        SIPDateHeader d;
        d = new SIPDateHeader();
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null date");
        d.setDate(date);
        varB4EAC82CA7396A68D541C85D26508E83_1677881735 = d;
        addTaint(date.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1677881735.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1677881735;
        // ---------- Original Method ----------
        //SIPDateHeader d = new SIPDateHeader();
        //if (date == null)
            //throw new NullPointerException("null date");
        //d.setDate(date);
        //return d;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.195 -0400", hash_original_method = "7FD58797EECF83FE34BEE1F3B093BC46", hash_generated_method = "07E3B5BF9A1784833EFFD44D9291C859")
    public EventHeader createEventHeader(String eventType) throws ParseException {
        EventHeader varB4EAC82CA7396A68D541C85D26508E83_1358026499 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null eventType");
        Event event;
        event = new Event();
        event.setEventType(eventType);
        varB4EAC82CA7396A68D541C85D26508E83_1358026499 = event;
        addTaint(eventType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1358026499.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1358026499;
        // ---------- Original Method ----------
        //if (eventType == null)
            //throw new NullPointerException("null eventType");
        //Event event = new Event();
        //event.setEventType(eventType);
        //return event;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.197 -0400", hash_original_method = "1A307AD1BD02E7BD6299AF40D811E5D5", hash_generated_method = "D80358DEF9A317296514439DCCE25143")
    public ExpiresHeader createExpiresHeader(int expires) throws InvalidArgumentException {
        ExpiresHeader varB4EAC82CA7396A68D541C85D26508E83_1887319146 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad value " + expires);
        Expires e;
        e = new Expires();
        e.setExpires(expires);
        varB4EAC82CA7396A68D541C85D26508E83_1887319146 = e;
        addTaint(expires);
        varB4EAC82CA7396A68D541C85D26508E83_1887319146.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1887319146;
        // ---------- Original Method ----------
        //if (expires < 0)
            //throw new InvalidArgumentException("bad value " + expires);
        //Expires e = new Expires();
        //e.setExpires(expires);
        //return e;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.200 -0400", hash_original_method = "C38CB4735B94E96E0C6FB81DC8E60CBF", hash_generated_method = "F3776D6E97A878060B62D003AA005471")
    public javax.sip.header.ExtensionHeader createExtensionHeader(
        String name,
        String value) throws ParseException {
        javax.sip.header.ExtensionHeader varB4EAC82CA7396A68D541C85D26508E83_1767168452 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("bad name");
        gov.nist.javax.sip.header.ExtensionHeaderImpl ext;
        ext = new gov.nist.javax.sip.header.ExtensionHeaderImpl();
        ext.setName(name);
        ext.setValue(value);
        varB4EAC82CA7396A68D541C85D26508E83_1767168452 = ext;
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1767168452.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1767168452;
        // ---------- Original Method ----------
        //if (name == null)
            //throw new NullPointerException("bad name");
        //gov.nist.javax.sip.header.ExtensionHeaderImpl ext =
            //new gov.nist.javax.sip.header.ExtensionHeaderImpl();
        //ext.setName(name);
        //ext.setValue(value);
        //return ext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.201 -0400", hash_original_method = "E3876C81F77C4C65824998CB51869857", hash_generated_method = "73E00BF006B5761B9563A7675D4E3D8E")
    public FromHeader createFromHeader(Address address, String tag) throws ParseException {
        FromHeader varB4EAC82CA7396A68D541C85D26508E83_1623105113 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address arg");
        From from;
        from = new From();
        from.setAddress(address);
        from.setTag(tag);
        varB4EAC82CA7396A68D541C85D26508E83_1623105113 = from;
        addTaint(address.getTaint());
        addTaint(tag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1623105113.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1623105113;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address arg");
        //From from = new From();
        //from.setAddress(address);
        //if (tag != null)
            //from.setTag(tag);
        //return from;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.202 -0400", hash_original_method = "4DE074146D6A81FB201A39A399764E9F", hash_generated_method = "52A47A45CECD776B4DB97797F12BFB06")
    public InReplyToHeader createInReplyToHeader(String callId) throws ParseException {
        InReplyToHeader varB4EAC82CA7396A68D541C85D26508E83_1275678047 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null callId arg");
        InReplyTo inReplyTo;
        inReplyTo = new InReplyTo();
        inReplyTo.setCallId(callId);
        varB4EAC82CA7396A68D541C85D26508E83_1275678047 = inReplyTo;
        addTaint(callId.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1275678047.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1275678047;
        // ---------- Original Method ----------
        //if (callId == null)
            //throw new NullPointerException("null callId arg");
        //InReplyTo inReplyTo = new InReplyTo();
        //inReplyTo.setCallId(callId);
        //return inReplyTo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.204 -0400", hash_original_method = "2B62AE770A28023C5424C7B7718E4BD4", hash_generated_method = "BFB8260E0C59407D6004AF0A01965894")
    public MaxForwardsHeader createMaxForwardsHeader(int maxForwards) throws InvalidArgumentException {
        MaxForwardsHeader varB4EAC82CA7396A68D541C85D26508E83_599492876 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "bad maxForwards arg " + maxForwards);
        MaxForwards m;
        m = new MaxForwards();
        m.setMaxForwards(maxForwards);
        varB4EAC82CA7396A68D541C85D26508E83_599492876 = m;
        addTaint(maxForwards);
        varB4EAC82CA7396A68D541C85D26508E83_599492876.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_599492876;
        // ---------- Original Method ----------
        //if (maxForwards < 0 || maxForwards > 255)
            //throw new InvalidArgumentException(
                //"bad maxForwards arg " + maxForwards);
        //MaxForwards m = new MaxForwards();
        //m.setMaxForwards(maxForwards);
        //return m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.229 -0400", hash_original_method = "623C745ED7578EC4227F3B15A38B5D4A", hash_generated_method = "93E2DA4CF213F2A72590EA37A8DEF1B9")
    public MimeVersionHeader createMimeVersionHeader(
        int majorVersion,
        int minorVersion) throws InvalidArgumentException {
        MimeVersionHeader varB4EAC82CA7396A68D541C85D26508E83_1956071445 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new javax.sip.InvalidArgumentException(
                "bad major/minor version");
        MimeVersion m;
        m = new MimeVersion();
        m.setMajorVersion(majorVersion);
        m.setMinorVersion(minorVersion);
        varB4EAC82CA7396A68D541C85D26508E83_1956071445 = m;
        addTaint(majorVersion);
        addTaint(minorVersion);
        varB4EAC82CA7396A68D541C85D26508E83_1956071445.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1956071445;
        // ---------- Original Method ----------
        //if (majorVersion < 0 || minorVersion < 0)
            //throw new javax.sip.InvalidArgumentException(
                //"bad major/minor version");
        //MimeVersion m = new MimeVersion();
        //m.setMajorVersion(majorVersion);
        //m.setMinorVersion(minorVersion);
        //return m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.239 -0400", hash_original_method = "F897D0FECB8A8CC74BFA504858C91B42", hash_generated_method = "5AC7B97A52701370015A675066F77003")
    public MinExpiresHeader createMinExpiresHeader(int minExpires) throws InvalidArgumentException {
        MinExpiresHeader varB4EAC82CA7396A68D541C85D26508E83_1077461493 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad minExpires " + minExpires);
        MinExpires min;
        min = new MinExpires();
        min.setExpires(minExpires);
        varB4EAC82CA7396A68D541C85D26508E83_1077461493 = min;
        addTaint(minExpires);
        varB4EAC82CA7396A68D541C85D26508E83_1077461493.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1077461493;
        // ---------- Original Method ----------
        //if (minExpires < 0)
            //throw new InvalidArgumentException("bad minExpires " + minExpires);
        //MinExpires min = new MinExpires();
        //min.setExpires(minExpires);
        //return min;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.239 -0400", hash_original_method = "8EE941BB2D8E39A517F98D1ED3613B4D", hash_generated_method = "1495E7A32DE3917A4E5DB3DA6BCD400B")
    public ExtensionHeader createMinSEHeader(int expires) throws InvalidArgumentException {
        ExtensionHeader varB4EAC82CA7396A68D541C85D26508E83_1370771465 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad value " + expires);
        MinSE e;
        e = new MinSE();
        e.setExpires(expires);
        varB4EAC82CA7396A68D541C85D26508E83_1370771465 = e;
        addTaint(expires);
        varB4EAC82CA7396A68D541C85D26508E83_1370771465.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1370771465;
        // ---------- Original Method ----------
        //if (expires < 0)
            //throw new InvalidArgumentException("bad value " + expires);
        //MinSE e = new MinSE();
        //e.setExpires(expires);
        //return e;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.240 -0400", hash_original_method = "2F5DB311D13CB6144CC7B49271775C33", hash_generated_method = "08D9040484B49796BDBA12107BFEEF22")
    public OrganizationHeader createOrganizationHeader(String organization) throws ParseException {
        OrganizationHeader varB4EAC82CA7396A68D541C85D26508E83_1445430211 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("bad organization arg");
        Organization o;
        o = new Organization();
        o.setOrganization(organization);
        varB4EAC82CA7396A68D541C85D26508E83_1445430211 = o;
        addTaint(organization.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1445430211.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1445430211;
        // ---------- Original Method ----------
        //if (organization == null)
            //throw new NullPointerException("bad organization arg");
        //Organization o = new Organization();
        //o.setOrganization(organization);
        //return o;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.241 -0400", hash_original_method = "085951AB405380C6C60E1EC174C5C855", hash_generated_method = "48903065B1B3AC33DB82CBBE7814690A")
    public PriorityHeader createPriorityHeader(String priority) throws ParseException {
        PriorityHeader varB4EAC82CA7396A68D541C85D26508E83_1048615397 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("bad priority arg");
        Priority p;
        p = new Priority();
        p.setPriority(priority);
        varB4EAC82CA7396A68D541C85D26508E83_1048615397 = p;
        addTaint(priority.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1048615397.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1048615397;
        // ---------- Original Method ----------
        //if (priority == null)
            //throw new NullPointerException("bad priority arg");
        //Priority p = new Priority();
        //p.setPriority(priority);
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.242 -0400", hash_original_method = "E2D1E713D6EFBD9B5EF73CE359255B39", hash_generated_method = "B8DD132397109543DD2DFF0A2CC2A392")
    public ProxyAuthenticateHeader createProxyAuthenticateHeader(String scheme) throws ParseException {
        ProxyAuthenticateHeader varB4EAC82CA7396A68D541C85D26508E83_1312742035 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("bad scheme arg");
        ProxyAuthenticate p;
        p = new ProxyAuthenticate();
        p.setScheme(scheme);
        varB4EAC82CA7396A68D541C85D26508E83_1312742035 = p;
        addTaint(scheme.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1312742035.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1312742035;
        // ---------- Original Method ----------
        //if (scheme == null)
            //throw new NullPointerException("bad scheme arg");
        //ProxyAuthenticate p = new ProxyAuthenticate();
        //p.setScheme(scheme);
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.243 -0400", hash_original_method = "E046B5DACDD94AD026F81045FF391CD1", hash_generated_method = "AB31D60A80D3E1CD600BAB5A00FA9162")
    public ProxyAuthorizationHeader createProxyAuthorizationHeader(String scheme) throws ParseException {
        ProxyAuthorizationHeader varB4EAC82CA7396A68D541C85D26508E83_58158450 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("bad scheme arg");
        ProxyAuthorization p;
        p = new ProxyAuthorization();
        p.setScheme(scheme);
        varB4EAC82CA7396A68D541C85D26508E83_58158450 = p;
        addTaint(scheme.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_58158450.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_58158450;
        // ---------- Original Method ----------
        //if (scheme == null)
            //throw new NullPointerException("bad scheme arg");
        //ProxyAuthorization p = new ProxyAuthorization();
        //p.setScheme(scheme);
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.243 -0400", hash_original_method = "A059B8FD47D8FC83321E2DEF4CB18490", hash_generated_method = "324EDFBC0F4DB43AB9685F904364B2FB")
    public ProxyRequireHeader createProxyRequireHeader(String optionTag) throws ParseException {
        ProxyRequireHeader varB4EAC82CA7396A68D541C85D26508E83_1817643819 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("bad optionTag arg");
        ProxyRequire p;
        p = new ProxyRequire();
        p.setOptionTag(optionTag);
        varB4EAC82CA7396A68D541C85D26508E83_1817643819 = p;
        addTaint(optionTag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1817643819.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1817643819;
        // ---------- Original Method ----------
        //if (optionTag == null)
            //throw new NullPointerException("bad optionTag arg");
        //ProxyRequire p = new ProxyRequire();
        //p.setOptionTag(optionTag);
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.245 -0400", hash_original_method = "42539302BE9490416DF1DC01B8BC3D99", hash_generated_method = "7234907E7729AF508337E2276A8430A8")
    public RAckHeader createRAckHeader(
        long rSeqNumber,
        long cSeqNumber,
        String method) throws InvalidArgumentException, ParseException {
        RAckHeader varB4EAC82CA7396A68D541C85D26508E83_1603127687 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Bad method");
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad cseq/rseq arg");
        RAck rack;
        rack = new RAck();
        rack.setMethod(method);
        rack.setCSequenceNumber(cSeqNumber);
        rack.setRSequenceNumber(rSeqNumber);
        varB4EAC82CA7396A68D541C85D26508E83_1603127687 = rack;
        addTaint(rSeqNumber);
        addTaint(cSeqNumber);
        addTaint(method.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1603127687.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1603127687;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.252 -0400", hash_original_method = "B44C2BD23DFFCB51A992C42D93BADE4E", hash_generated_method = "E1E6A3504A86498F276FB447CAE4B65A")
    public RAckHeader createRAckHeader(int rSeqNumber, int cSeqNumber, String method) throws InvalidArgumentException, ParseException {
        RAckHeader varB4EAC82CA7396A68D541C85D26508E83_1702606251 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1702606251 = createRAckHeader((long)rSeqNumber, (long)cSeqNumber, method);
        addTaint(rSeqNumber);
        addTaint(cSeqNumber);
        addTaint(method.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1702606251.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1702606251;
        // ---------- Original Method ----------
        //return createRAckHeader((long)rSeqNumber, (long)cSeqNumber, method);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.253 -0400", hash_original_method = "38086BF4D4EB3CE5AB4BF7772F8EACF2", hash_generated_method = "DCA28C9D2EF16B6809F52C7C1FDCB0E9")
    public RSeqHeader createRSeqHeader(int sequenceNumber) throws InvalidArgumentException {
        RSeqHeader varB4EAC82CA7396A68D541C85D26508E83_1893313766 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1893313766 = createRSeqHeader((long) sequenceNumber);
        addTaint(sequenceNumber);
        varB4EAC82CA7396A68D541C85D26508E83_1893313766.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1893313766;
        // ---------- Original Method ----------
        //return createRSeqHeader((long) sequenceNumber) ;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.256 -0400", hash_original_method = "CA4CA07B31DF6CB609C05636F40DB22F", hash_generated_method = "3DAA4F2AEA9F4CAFDC62B8B209602897")
    public RSeqHeader createRSeqHeader(long sequenceNumber) throws InvalidArgumentException {
        RSeqHeader varB4EAC82CA7396A68D541C85D26508E83_1860584650 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "invalid sequenceNumber arg " + sequenceNumber);
        RSeq rseq;
        rseq = new RSeq();
        rseq.setSeqNumber(sequenceNumber);
        varB4EAC82CA7396A68D541C85D26508E83_1860584650 = rseq;
        addTaint(sequenceNumber);
        varB4EAC82CA7396A68D541C85D26508E83_1860584650.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1860584650;
        // ---------- Original Method ----------
        //if (sequenceNumber < 0)
            //throw new InvalidArgumentException(
                //"invalid sequenceNumber arg " + sequenceNumber);
        //RSeq rseq = new RSeq();
        //rseq.setSeqNumber(sequenceNumber);
        //return rseq;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.258 -0400", hash_original_method = "57AD0B4E4FE03197F2B52972D6060CBA", hash_generated_method = "80F0C132FF23E4FC6ED9DB91D2CAB49C")
    public ReasonHeader createReasonHeader(
        String protocol,
        int cause,
        String text) throws InvalidArgumentException, ParseException {
        ReasonHeader varB4EAC82CA7396A68D541C85D26508E83_76516294 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("bad protocol arg");
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad cause");
        Reason reason;
        reason = new Reason();
        reason.setProtocol(protocol);
        reason.setCause(cause);
        reason.setText(text);
        varB4EAC82CA7396A68D541C85D26508E83_76516294 = reason;
        addTaint(protocol.getTaint());
        addTaint(cause);
        addTaint(text.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_76516294.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_76516294;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.263 -0400", hash_original_method = "6DA29D8692407706B9B05391AF333993", hash_generated_method = "88D15B1FB66BA5D8F20A5D938B42B3A9")
    public RecordRouteHeader createRecordRouteHeader(Address address) {
        RecordRouteHeader varB4EAC82CA7396A68D541C85D26508E83_156968933 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null argument!");
        RecordRoute recordRoute;
        recordRoute = new RecordRoute();
        recordRoute.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_156968933 = recordRoute;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_156968933.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_156968933;
        // ---------- Original Method ----------
        //if ( address == null) throw new NullPointerException("Null argument!");
        //RecordRoute recordRoute = new RecordRoute();
        //recordRoute.setAddress(address);
        //return recordRoute;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.276 -0400", hash_original_method = "4393C033D6B63EF338EB93DE3E753573", hash_generated_method = "3922B0A6A4BACBA15FC2548D62C7AC63")
    public ReplyToHeader createReplyToHeader(Address address) {
        ReplyToHeader varB4EAC82CA7396A68D541C85D26508E83_143530319 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address");
        ReplyTo replyTo;
        replyTo = new ReplyTo();
        replyTo.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_143530319 = replyTo;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_143530319.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_143530319;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address");
        //ReplyTo replyTo = new ReplyTo();
        //replyTo.setAddress(address);
        //return replyTo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.280 -0400", hash_original_method = "F65B5EA444DA08358E800CD7B469501A", hash_generated_method = "918F5280567FBB53ECF78A95CDC8C2B7")
    public RequireHeader createRequireHeader(String optionTag) throws ParseException {
        RequireHeader varB4EAC82CA7396A68D541C85D26508E83_1128414083 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null optionTag");
        Require require;
        require = new Require();
        require.setOptionTag(optionTag);
        varB4EAC82CA7396A68D541C85D26508E83_1128414083 = require;
        addTaint(optionTag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1128414083.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1128414083;
        // ---------- Original Method ----------
        //if (optionTag == null)
            //throw new NullPointerException("null optionTag");
        //Require require = new Require();
        //require.setOptionTag(optionTag);
        //return require;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.285 -0400", hash_original_method = "43D5E8C96E4C1ED3ED5B8AD5C39C801C", hash_generated_method = "095889676C1D28A0AE73C3444FD2B64C")
    public RetryAfterHeader createRetryAfterHeader(int retryAfter) throws InvalidArgumentException {
        RetryAfterHeader varB4EAC82CA7396A68D541C85D26508E83_622884790 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad retryAfter arg");
        RetryAfter r;
        r = new RetryAfter();
        r.setRetryAfter(retryAfter);
        varB4EAC82CA7396A68D541C85D26508E83_622884790 = r;
        addTaint(retryAfter);
        varB4EAC82CA7396A68D541C85D26508E83_622884790.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_622884790;
        // ---------- Original Method ----------
        //if (retryAfter < 0)
            //throw new InvalidArgumentException("bad retryAfter arg");
        //RetryAfter r = new RetryAfter();
        //r.setRetryAfter(retryAfter);
        //return r;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.285 -0400", hash_original_method = "03611E3BB30258B8EC4FDC9F783CBCCF", hash_generated_method = "CE81C05C76E19E1B6C3E7BAB97470C3E")
    public RouteHeader createRouteHeader(Address address) {
        RouteHeader varB4EAC82CA7396A68D541C85D26508E83_1681655512 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address arg");
        Route route;
        route = new Route();
        route.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_1681655512 = route;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1681655512.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1681655512;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address arg");
        //Route route = new Route();
        //route.setAddress(address);
        //return route;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.286 -0400", hash_original_method = "65AF02D93E753F97E0AF00F542D03529", hash_generated_method = "469C134497B67B6B1E00C355AF4E70BC")
    public ServerHeader createServerHeader(List product) throws ParseException {
        ServerHeader varB4EAC82CA7396A68D541C85D26508E83_680789033 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null productList arg");
        Server server;
        server = new Server();
        server.setProduct(product);
        varB4EAC82CA7396A68D541C85D26508E83_680789033 = server;
        addTaint(product.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_680789033.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_680789033;
        // ---------- Original Method ----------
        //if (product == null)
            //throw new NullPointerException("null productList arg");
        //Server server = new Server();
        //server.setProduct(product);
        //return server;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.287 -0400", hash_original_method = "288EA55C0FFC9E81469649B581E59F71", hash_generated_method = "AA2F66B5670B7F0A5532C77D8A5437DD")
    public SubjectHeader createSubjectHeader(String subject) throws ParseException {
        SubjectHeader varB4EAC82CA7396A68D541C85D26508E83_93395837 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null subject arg");
        Subject s;
        s = new Subject();
        s.setSubject(subject);
        varB4EAC82CA7396A68D541C85D26508E83_93395837 = s;
        addTaint(subject.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_93395837.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_93395837;
        // ---------- Original Method ----------
        //if (subject == null)
            //throw new NullPointerException("null subject arg");
        //Subject s = new Subject();
        //s.setSubject(subject);
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.288 -0400", hash_original_method = "9B68B72DA8144991BC14639C6BE11723", hash_generated_method = "AB7453E6DE63A20F7D5AC634D78AA9DD")
    public SubscriptionStateHeader createSubscriptionStateHeader(String subscriptionState) throws ParseException {
        SubscriptionStateHeader varB4EAC82CA7396A68D541C85D26508E83_82261097 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null subscriptionState arg");
        SubscriptionState s;
        s = new SubscriptionState();
        s.setState(subscriptionState);
        varB4EAC82CA7396A68D541C85D26508E83_82261097 = s;
        addTaint(subscriptionState.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_82261097.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_82261097;
        // ---------- Original Method ----------
        //if (subscriptionState == null)
            //throw new NullPointerException("null subscriptionState arg");
        //SubscriptionState s = new SubscriptionState();
        //s.setState(subscriptionState);
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.288 -0400", hash_original_method = "589849ECCDAFDA20BE0DBE1D9A436669", hash_generated_method = "10499CF5429F6660E303EE6CA7017198")
    public SupportedHeader createSupportedHeader(String optionTag) throws ParseException {
        SupportedHeader varB4EAC82CA7396A68D541C85D26508E83_2058386641 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null optionTag arg");
        Supported supported;
        supported = new Supported();
        supported.setOptionTag(optionTag);
        varB4EAC82CA7396A68D541C85D26508E83_2058386641 = supported;
        addTaint(optionTag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2058386641.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2058386641;
        // ---------- Original Method ----------
        //if (optionTag == null)
            //throw new NullPointerException("null optionTag arg");
        //Supported supported = new Supported();
        //supported.setOptionTag(optionTag);
        //return supported;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.289 -0400", hash_original_method = "380079DA7F92D6CF2CEA9086AA5F92D7", hash_generated_method = "C060FB9CBFA5ABD93000D468DDC879B1")
    public TimeStampHeader createTimeStampHeader(float timeStamp) throws InvalidArgumentException {
        TimeStampHeader varB4EAC82CA7396A68D541C85D26508E83_766454242 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("illegal timeStamp");
        TimeStamp t;
        t = new TimeStamp();
        t.setTimeStamp(timeStamp);
        varB4EAC82CA7396A68D541C85D26508E83_766454242 = t;
        addTaint(timeStamp);
        varB4EAC82CA7396A68D541C85D26508E83_766454242.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_766454242;
        // ---------- Original Method ----------
        //if (timeStamp < 0)
            //throw new IllegalArgumentException("illegal timeStamp");
        //TimeStamp t = new TimeStamp();
        //t.setTimeStamp(timeStamp);
        //return t;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.302 -0400", hash_original_method = "7928C6AF630E4BCE57D31FA4979B7453", hash_generated_method = "142F8AA6EB4EB55685D0E41F252ED800")
    public ToHeader createToHeader(Address address, String tag) throws ParseException {
        ToHeader varB4EAC82CA7396A68D541C85D26508E83_51568348 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address");
        To to;
        to = new To();
        to.setAddress(address);
        to.setTag(tag);
        varB4EAC82CA7396A68D541C85D26508E83_51568348 = to;
        addTaint(address.getTaint());
        addTaint(tag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_51568348.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_51568348;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address");
        //To to = new To();
        //to.setAddress(address);
        //if (tag != null)
            //to.setTag(tag);
        //return to;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.302 -0400", hash_original_method = "9A62FFB59334167B71BC2FE402276C31", hash_generated_method = "E1B44B4D5EF1A4C676DDD016B0B9E063")
    public UnsupportedHeader createUnsupportedHeader(String optionTag) throws ParseException {
        UnsupportedHeader varB4EAC82CA7396A68D541C85D26508E83_300334100 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(optionTag);
        Unsupported unsupported;
        unsupported = new Unsupported();
        unsupported.setOptionTag(optionTag);
        varB4EAC82CA7396A68D541C85D26508E83_300334100 = unsupported;
        addTaint(optionTag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_300334100.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_300334100;
        // ---------- Original Method ----------
        //if (optionTag == null)
            //throw new NullPointerException(optionTag);
        //Unsupported unsupported = new Unsupported();
        //unsupported.setOptionTag(optionTag);
        //return unsupported;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.303 -0400", hash_original_method = "0FDDC4550D32FE0A8E48193D044787BB", hash_generated_method = "DB60DC837E11FD3C09C5B583AC6CC3A2")
    public UserAgentHeader createUserAgentHeader(List product) throws ParseException {
        UserAgentHeader varB4EAC82CA7396A68D541C85D26508E83_751798905 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null user agent");
        UserAgent userAgent;
        userAgent = new UserAgent();
        userAgent.setProduct(product);
        varB4EAC82CA7396A68D541C85D26508E83_751798905 = userAgent;
        addTaint(product.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_751798905.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_751798905;
        // ---------- Original Method ----------
        //if (product == null)
            //throw new NullPointerException("null user agent");
        //UserAgent userAgent = new UserAgent();
        //userAgent.setProduct(product);
        //return userAgent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.304 -0400", hash_original_method = "B7A9F5DC521617567AEB2EDF2366DE24", hash_generated_method = "5F9D5F1C6C4427D067E188AB38E54B80")
    public ViaHeader createViaHeader(
        String host,
        int port,
        String transport,
        String branch) throws ParseException, InvalidArgumentException {
        ViaHeader varB4EAC82CA7396A68D541C85D26508E83_2103599809 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        Via via;
        via = new Via();
        via.setBranch(branch);
        {
            boolean var892BBD36F1835D9F17C0D62A38310742_1030466509 = (host.indexOf(':') >= 0
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
        varB4EAC82CA7396A68D541C85D26508E83_2103599809 = via;
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(transport.getTaint());
        addTaint(branch.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2103599809.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2103599809;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.305 -0400", hash_original_method = "EDE3AD5442B3DE671B6476C917BB6D0F", hash_generated_method = "8C611E18801A83AEBA1B71A20D748A81")
    public WWWAuthenticateHeader createWWWAuthenticateHeader(String scheme) throws ParseException {
        WWWAuthenticateHeader varB4EAC82CA7396A68D541C85D26508E83_1514699917 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null scheme");
        WWWAuthenticate www;
        www = new WWWAuthenticate();
        www.setScheme(scheme);
        varB4EAC82CA7396A68D541C85D26508E83_1514699917 = www;
        addTaint(scheme.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1514699917.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1514699917;
        // ---------- Original Method ----------
        //if (scheme == null)
            //throw new NullPointerException("null scheme");
        //WWWAuthenticate www = new WWWAuthenticate();
        //www.setScheme(scheme);
        //return www;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.306 -0400", hash_original_method = "F34478A6D1616AB2836BA2A212AE0D49", hash_generated_method = "74086D1C73868128355F19B3AA9F659E")
    public WarningHeader createWarningHeader(
        String agent,
        int code,
        String comment) throws ParseException, InvalidArgumentException {
        WarningHeader varB4EAC82CA7396A68D541C85D26508E83_1605280296 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        Warning warning;
        warning = new Warning();
        warning.setAgent(agent);
        warning.setCode(code);
        warning.setText(comment);
        varB4EAC82CA7396A68D541C85D26508E83_1605280296 = warning;
        addTaint(agent.getTaint());
        addTaint(code);
        addTaint(comment.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1605280296.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1605280296;
        // ---------- Original Method ----------
        //if (agent == null)
            //throw new NullPointerException("null arg");
        //Warning warning = new Warning();
        //warning.setAgent(agent);
        //warning.setCode(code);
        //warning.setText(comment);
        //return warning;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.306 -0400", hash_original_method = "CB42C1424760C62123C05E2F8CB60B35", hash_generated_method = "175A902B8627C5DD2057D4549D9C7D7D")
    public ErrorInfoHeader createErrorInfoHeader(URI errorInfo) {
        ErrorInfoHeader varB4EAC82CA7396A68D541C85D26508E83_973103219 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        varB4EAC82CA7396A68D541C85D26508E83_973103219 = new ErrorInfo((GenericURI) errorInfo);
        addTaint(errorInfo.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_973103219.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_973103219;
        // ---------- Original Method ----------
        //if (errorInfo == null)
            //throw new NullPointerException("null arg");
        //return new ErrorInfo((GenericURI) errorInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.320 -0400", hash_original_method = "7E6122EDAE408D205AF0C9E45A024F04", hash_generated_method = "F5DD3BC61B85355BAACD4D17C729D2D8")
    public javax.sip.header.Header createHeader(String headerText) throws ParseException {
        javax.sip.header.Header varB4EAC82CA7396A68D541C85D26508E83_1583909463 = null; //Variable for return #1
        javax.sip.header.Header varB4EAC82CA7396A68D541C85D26508E83_1942796650 = null; //Variable for return #2
        javax.sip.header.Header varB4EAC82CA7396A68D541C85D26508E83_1982070672 = null; //Variable for return #3
        javax.sip.header.Header varB4EAC82CA7396A68D541C85D26508E83_514918735 = null; //Variable for return #4
        javax.sip.header.Header varB4EAC82CA7396A68D541C85D26508E83_1294879093 = null; //Variable for return #5
        StringMsgParser smp;
        smp = new StringMsgParser();
        SIPHeader sipHeader;
        sipHeader = smp.parseSIPHeader(headerText.trim());
        {
            {
                boolean var376AECF828F744DA20E1ADDFF5E39535_1042903137 = (((SIPHeaderList) sipHeader).size() > 1);
                {
                    if (DroidSafeAndroidRuntime.control) throw new ParseException(
                    "Only singleton allowed " + headerText,
                    0);
                } //End block
                {
                    boolean varB2077481A39B1082F8C4F3463BCDED80_946563205 = (((SIPHeaderList) sipHeader).size() == 0);
                    {
                        try 
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1583909463 = (Header) ((SIPHeaderList) sipHeader)
                        .getMyClass()
                        .newInstance();
                        } //End block
                        catch (InstantiationException ex)
                        {
                            ex.printStackTrace();
                            varB4EAC82CA7396A68D541C85D26508E83_1942796650 = null;
                        } //End block
                        catch (IllegalAccessException ex)
                        {
                            ex.printStackTrace();
                            varB4EAC82CA7396A68D541C85D26508E83_1982070672 = null;
                        } //End block
                    } //End block
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_514918735 = (Header) ((SIPHeaderList) sipHeader).getFirst();
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1294879093 = (Header) sipHeader;
        } //End block
        addTaint(headerText.getTaint());
        javax.sip.header.Header varA7E53CE21691AB073D9660D615818899_285365079; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_285365079 = varB4EAC82CA7396A68D541C85D26508E83_1583909463;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_285365079 = varB4EAC82CA7396A68D541C85D26508E83_1942796650;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_285365079 = varB4EAC82CA7396A68D541C85D26508E83_1982070672;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_285365079 = varB4EAC82CA7396A68D541C85D26508E83_514918735;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_285365079 = varB4EAC82CA7396A68D541C85D26508E83_1294879093;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_285365079.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_285365079;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.320 -0400", hash_original_method = "BE8A77015DA0080195A899A1BFDA2B08", hash_generated_method = "DA254310F09DF1BB3F85B1A53F9CF62B")
    public javax.sip.header.Header createHeader(
        String headerName,
        String headerValue) throws java.text.ParseException {
        javax.sip.header.Header varB4EAC82CA7396A68D541C85D26508E83_1658314722 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("header name is null");
        String hdrText;
        hdrText = new StringBuffer()
                .append(headerName)
                .append(":")
                .append(headerValue)
                .toString();
        varB4EAC82CA7396A68D541C85D26508E83_1658314722 = createHeader(hdrText);
        addTaint(headerName.getTaint());
        addTaint(headerValue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1658314722.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1658314722;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.321 -0400", hash_original_method = "FDCDF9463F1CDDAF0BCBB63B8B4D05F5", hash_generated_method = "6C2615F10076254639E9B8AD1A83DB7C")
    public java.util.List createHeaders(String headers) throws java.text.ParseException {
        java.util.List varB4EAC82CA7396A68D541C85D26508E83_924567231 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg!");
        StringMsgParser smp;
        smp = new StringMsgParser();
        SIPHeader shdr;
        shdr = smp.parseSIPHeader(headers);
        varB4EAC82CA7396A68D541C85D26508E83_924567231 = (SIPHeaderList) shdr;
        if (DroidSafeAndroidRuntime.control) throw new ParseException(
                "List of headers of this type is not allowed in a message",
                0);
        addTaint(headers.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_924567231.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_924567231;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.321 -0400", hash_original_method = "5541F8A2ED86060178CAD1F0D5BA2507", hash_generated_method = "1C415D9F9EB92EC8220BF6E07C940501")
    public ReferToHeader createReferToHeader(Address address) {
        ReferToHeader varB4EAC82CA7396A68D541C85D26508E83_1916871290 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address!");
        ReferTo referTo;
        referTo = new ReferTo();
        referTo.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_1916871290 = referTo;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1916871290.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1916871290;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address!");
        //ReferTo referTo = new ReferTo();
        //referTo.setAddress(address);
        //return referTo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.325 -0400", hash_original_method = "A51D0E58D36C2041DD351AE4FDD73BCF", hash_generated_method = "4238E05E88F0930499EDCFB45E14F674")
    public ReferredByHeader createReferredByHeader(Address address) {
        ReferredByHeader varB4EAC82CA7396A68D541C85D26508E83_972783050 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address!");
        ReferredBy referredBy;
        referredBy = new ReferredBy();
        referredBy.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_972783050 = referredBy;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_972783050.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_972783050;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address!");
        //ReferredBy referredBy = new ReferredBy();
        //referredBy.setAddress(address);
        //return referredBy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.326 -0400", hash_original_method = "E3BB57144A133C8AFDA0829EAE12FAAB", hash_generated_method = "BA4975CF29CB6649256DF00EC394C483")
    public ReplacesHeader createReplacesHeader(String callId, String toTag,
                String fromTag) throws ParseException {
        ReplacesHeader varB4EAC82CA7396A68D541C85D26508E83_1036489850 = null; //Variable for return #1
        Replaces replaces;
        replaces = new Replaces();
        replaces.setCallId(callId);
        replaces.setFromTag(fromTag);
        replaces.setToTag(toTag);
        varB4EAC82CA7396A68D541C85D26508E83_1036489850 = replaces;
        addTaint(callId.getTaint());
        addTaint(toTag.getTaint());
        addTaint(fromTag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1036489850.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1036489850;
        // ---------- Original Method ----------
        //Replaces replaces = new Replaces();
        //replaces.setCallId(callId);
        //replaces.setFromTag(fromTag);
        //replaces.setToTag(toTag);
        //return replaces;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.328 -0400", hash_original_method = "C42E665E40D735B4BFD234363CD8C238", hash_generated_method = "58470E27E07697C0E90B820F28EFB8CF")
    public JoinHeader createJoinHeader(String callId, String toTag,
                String fromTag) throws ParseException {
        JoinHeader varB4EAC82CA7396A68D541C85D26508E83_202675857 = null; //Variable for return #1
        Join join;
        join = new Join();
        join.setCallId(callId);
        join.setFromTag(fromTag);
        join.setToTag(toTag);
        varB4EAC82CA7396A68D541C85D26508E83_202675857 = join;
        addTaint(callId.getTaint());
        addTaint(toTag.getTaint());
        addTaint(fromTag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_202675857.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_202675857;
        // ---------- Original Method ----------
        //Join join = new Join();
        //join.setCallId(callId);
        //join.setFromTag(fromTag);
        //join.setToTag(toTag);
        //return join;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.329 -0400", hash_original_method = "95F88F9209912EE6FCAFCB830227A87B", hash_generated_method = "E3090BC7A6C5F1C0481948232EE46608")
    public SIPETagHeader createSIPETagHeader(String etag) throws ParseException {
        SIPETagHeader varB4EAC82CA7396A68D541C85D26508E83_287211368 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_287211368 = new SIPETag(etag);
        addTaint(etag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_287211368.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_287211368;
        // ---------- Original Method ----------
        //return new SIPETag(etag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.333 -0400", hash_original_method = "9EE2B60A802A938BDC15DDB307A8B1D7", hash_generated_method = "249024E2D5AF79B6107D2FD43B36679B")
    public SIPIfMatchHeader createSIPIfMatchHeader(String etag) throws ParseException {
        SIPIfMatchHeader varB4EAC82CA7396A68D541C85D26508E83_610178282 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_610178282 = new SIPIfMatch(etag);
        addTaint(etag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_610178282.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_610178282;
        // ---------- Original Method ----------
        //return new SIPIfMatch(etag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.333 -0400", hash_original_method = "5900AA55EC6D83D47F45CED3D37DDEC7", hash_generated_method = "013BB6E65B9BA7803963552171321C62")
    public PAccessNetworkInfoHeader createPAccessNetworkInfoHeader() {
        PAccessNetworkInfoHeader varB4EAC82CA7396A68D541C85D26508E83_252125949 = null; //Variable for return #1
        PAccessNetworkInfo accessNetworkInfo;
        accessNetworkInfo = new PAccessNetworkInfo();
        varB4EAC82CA7396A68D541C85D26508E83_252125949 = accessNetworkInfo;
        varB4EAC82CA7396A68D541C85D26508E83_252125949.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_252125949;
        // ---------- Original Method ----------
        //PAccessNetworkInfo accessNetworkInfo = new PAccessNetworkInfo();
        //return accessNetworkInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.336 -0400", hash_original_method = "7A9453157C5A8C4FD99B8F34DC853877", hash_generated_method = "C0FE08EA097C7A0C88DD3E8694C78808")
    public PAssertedIdentityHeader createPAssertedIdentityHeader(Address address) throws NullPointerException, ParseException {
        PAssertedIdentityHeader varB4EAC82CA7396A68D541C85D26508E83_1780814923 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address!");
        PAssertedIdentity assertedIdentity;
        assertedIdentity = new PAssertedIdentity();
        assertedIdentity.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_1780814923 = assertedIdentity;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1780814923.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1780814923;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address!");
        //PAssertedIdentity assertedIdentity = new PAssertedIdentity();
        //assertedIdentity.setAddress(address);
        //return assertedIdentity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.337 -0400", hash_original_method = "4BD897B5832A55E4A60E9B49C4611708", hash_generated_method = "8D473037872E7E4B189EEE1BF9378DD1")
    public PAssociatedURIHeader createPAssociatedURIHeader(Address assocURI) {
        PAssociatedURIHeader varB4EAC82CA7396A68D541C85D26508E83_602457489 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null associatedURI!");
        PAssociatedURI associatedURI;
        associatedURI = new PAssociatedURI();
        associatedURI.setAddress(assocURI);
        varB4EAC82CA7396A68D541C85D26508E83_602457489 = associatedURI;
        addTaint(assocURI.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_602457489.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_602457489;
        // ---------- Original Method ----------
        //if (assocURI == null)
        //throw new NullPointerException("null associatedURI!");
        //PAssociatedURI associatedURI = new PAssociatedURI();
        //associatedURI.setAddress(assocURI);
        //return associatedURI;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.344 -0400", hash_original_method = "FD713420BE4BC11FE9D9AB43BBBEAD30", hash_generated_method = "68745830AD820908D945126BD1F78541")
    public PCalledPartyIDHeader createPCalledPartyIDHeader(Address address) {
        PCalledPartyIDHeader varB4EAC82CA7396A68D541C85D26508E83_337745125 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address!");
        PCalledPartyID calledPartyID;
        calledPartyID = new PCalledPartyID();
        calledPartyID.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_337745125 = calledPartyID;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_337745125.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_337745125;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address!");
        //PCalledPartyID calledPartyID = new PCalledPartyID();
        //calledPartyID.setAddress(address);
        //return calledPartyID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.351 -0400", hash_original_method = "F3DC851C781199B1B5D5ECAC93663797", hash_generated_method = "1A96E9AD8FD8A6558510C03BF5C45650")
    public PChargingFunctionAddressesHeader createPChargingFunctionAddressesHeader() {
        PChargingFunctionAddressesHeader varB4EAC82CA7396A68D541C85D26508E83_775370507 = null; //Variable for return #1
        PChargingFunctionAddresses cfa;
        cfa = new PChargingFunctionAddresses();
        varB4EAC82CA7396A68D541C85D26508E83_775370507 = cfa;
        varB4EAC82CA7396A68D541C85D26508E83_775370507.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_775370507;
        // ---------- Original Method ----------
        //PChargingFunctionAddresses cfa = new PChargingFunctionAddresses();
        //return cfa;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.354 -0400", hash_original_method = "E82D256C40CCFC0E4431BA44734EBBF3", hash_generated_method = "5FAD6CE61B938EE210A0A77D46186573")
    public PChargingVectorHeader createChargingVectorHeader(String icid) throws ParseException {
        PChargingVectorHeader varB4EAC82CA7396A68D541C85D26508E83_1102435800 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null icid arg!");
        PChargingVector chargingVector;
        chargingVector = new PChargingVector();
        chargingVector.setICID(icid);
        varB4EAC82CA7396A68D541C85D26508E83_1102435800 = chargingVector;
        addTaint(icid.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1102435800.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1102435800;
        // ---------- Original Method ----------
        //if (icid == null)
        //throw new NullPointerException("null icid arg!");
        //PChargingVector chargingVector = new PChargingVector();
        //chargingVector.setICID(icid);
        //return chargingVector;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.354 -0400", hash_original_method = "FB93C1554D708A44568E0208A3D181E0", hash_generated_method = "1E0424D4074539931338010D4EBDB4C1")
    public PMediaAuthorizationHeader createPMediaAuthorizationHeader(String token) throws InvalidArgumentException, ParseException {
        PMediaAuthorizationHeader varB4EAC82CA7396A68D541C85D26508E83_357223075 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("The Media-Authorization-Token parameter is null or empty");
        PMediaAuthorization mediaAuthorization;
        mediaAuthorization = new PMediaAuthorization();
        mediaAuthorization.setMediaAuthorizationToken(token);
        varB4EAC82CA7396A68D541C85D26508E83_357223075 = mediaAuthorization;
        addTaint(token.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_357223075.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_357223075;
        // ---------- Original Method ----------
        //if (token == null || token == "")
            //throw new InvalidArgumentException("The Media-Authorization-Token parameter is null or empty");
        //PMediaAuthorization mediaAuthorization = new PMediaAuthorization();
        //mediaAuthorization.setMediaAuthorizationToken(token);
        //return mediaAuthorization;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.364 -0400", hash_original_method = "3BA03116BEA38D71B8C38B4BA62E5B71", hash_generated_method = "2178615D06EB41B4533F88ABE0353049")
    public PPreferredIdentityHeader createPPreferredIdentityHeader(Address address) {
        PPreferredIdentityHeader varB4EAC82CA7396A68D541C85D26508E83_1003733431 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address!");
        PPreferredIdentity preferredIdentity;
        preferredIdentity = new PPreferredIdentity();
        preferredIdentity.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_1003733431 = preferredIdentity;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1003733431.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1003733431;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address!");
        //PPreferredIdentity preferredIdentity = new PPreferredIdentity();
        //preferredIdentity.setAddress(address);
        //return preferredIdentity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.366 -0400", hash_original_method = "B32CA202259A9B847AD818F044EE39DA", hash_generated_method = "6DB4A2477C87D4BEF9D9CEB43F92A1FF")
    public PVisitedNetworkIDHeader createPVisitedNetworkIDHeader() {
        PVisitedNetworkIDHeader varB4EAC82CA7396A68D541C85D26508E83_153089260 = null; //Variable for return #1
        PVisitedNetworkID visitedNetworkID;
        visitedNetworkID = new PVisitedNetworkID();
        varB4EAC82CA7396A68D541C85D26508E83_153089260 = visitedNetworkID;
        varB4EAC82CA7396A68D541C85D26508E83_153089260.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_153089260;
        // ---------- Original Method ----------
        //PVisitedNetworkID visitedNetworkID = new PVisitedNetworkID();
        //return visitedNetworkID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.367 -0400", hash_original_method = "537B18CC29F2C70486994281CB29500B", hash_generated_method = "C1A093CE1D6494591587EC738A735190")
    public PathHeader createPathHeader(Address address) {
        PathHeader varB4EAC82CA7396A68D541C85D26508E83_106468083 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address!");
        Path path;
        path = new Path();
        path.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_106468083 = path;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_106468083.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_106468083;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address!");
        //Path path = new Path();
        //path.setAddress(address);
        //return path;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.413 -0400", hash_original_method = "85C1BF55B1F968333EFFBCF4DBC75BE6", hash_generated_method = "18B7ECC70D9545581C821419DA62118D")
    public PrivacyHeader createPrivacyHeader(String privacyType) {
        PrivacyHeader varB4EAC82CA7396A68D541C85D26508E83_72400486 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null privacyType arg");
        Privacy privacy;
        privacy = new Privacy(privacyType);
        varB4EAC82CA7396A68D541C85D26508E83_72400486 = privacy;
        addTaint(privacyType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_72400486.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_72400486;
        // ---------- Original Method ----------
        //if (privacyType == null)
            //throw new NullPointerException("null privacyType arg");
        //Privacy privacy = new Privacy(privacyType);
        //return privacy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.413 -0400", hash_original_method = "A7CA2EB6DD40139D85B6778D2C783F9F", hash_generated_method = "6D82497E259378828A2C57CE0075985A")
    public ServiceRouteHeader createServiceRouteHeader(Address address) {
        ServiceRouteHeader varB4EAC82CA7396A68D541C85D26508E83_224419225 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address!");
        ServiceRoute serviceRoute;
        serviceRoute = new ServiceRoute();
        serviceRoute.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_224419225 = serviceRoute;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_224419225.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_224419225;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address!");
        //ServiceRoute serviceRoute = new ServiceRoute();
        //serviceRoute.setAddress(address);
        //return serviceRoute;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.414 -0400", hash_original_method = "7A3E4AE36777C6F2CF79A6B3882A3053", hash_generated_method = "0207A132D33459DDCE653F2314A04D2B")
    public SecurityServerHeader createSecurityServerHeader() {
        SecurityServerHeader varB4EAC82CA7396A68D541C85D26508E83_1130284169 = null; //Variable for return #1
        SecurityServer secServer;
        secServer = new SecurityServer();
        varB4EAC82CA7396A68D541C85D26508E83_1130284169 = secServer;
        varB4EAC82CA7396A68D541C85D26508E83_1130284169.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1130284169;
        // ---------- Original Method ----------
        //SecurityServer secServer = new SecurityServer();
        //return secServer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.414 -0400", hash_original_method = "2361364E4BB205FAC2A8F8549D9431F6", hash_generated_method = "9F20BB1A6E299CC71726175D0264A9D8")
    public SecurityClientHeader createSecurityClientHeader() {
        SecurityClientHeader varB4EAC82CA7396A68D541C85D26508E83_1512370416 = null; //Variable for return #1
        SecurityClient secClient;
        secClient = new SecurityClient();
        varB4EAC82CA7396A68D541C85D26508E83_1512370416 = secClient;
        varB4EAC82CA7396A68D541C85D26508E83_1512370416.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1512370416;
        // ---------- Original Method ----------
        //SecurityClient secClient = new SecurityClient();
        //return secClient;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.414 -0400", hash_original_method = "1063C2554F38236C917DADCB6A55ADB8", hash_generated_method = "EA5C1CB8549BF0C5C9D66013EFEE68B2")
    public SecurityVerifyHeader createSecurityVerifyHeader() {
        SecurityVerifyHeader varB4EAC82CA7396A68D541C85D26508E83_1870271162 = null; //Variable for return #1
        SecurityVerify secVerify;
        secVerify = new SecurityVerify();
        varB4EAC82CA7396A68D541C85D26508E83_1870271162 = secVerify;
        varB4EAC82CA7396A68D541C85D26508E83_1870271162.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1870271162;
        // ---------- Original Method ----------
        //SecurityVerify secVerify = new SecurityVerify();
        //return secVerify;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.428 -0400", hash_original_method = "2DDC01C5DAA0917C6B8BE6B8A00F5568", hash_generated_method = "1A09BA43F2774C2564806DB447F03BC4")
    public PUserDatabaseHeader createPUserDatabaseHeader(String databaseName) {
        PUserDatabaseHeader varB4EAC82CA7396A68D541C85D26508E83_1027279243 = null; //Variable for return #1
        {
            boolean varAC311902DF4878F599DD65CB8A1544C9_362297232 = ((databaseName ==null)||(databaseName.equals(" ")));
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Database name is null");
        } //End collapsed parenthetic
        PUserDatabase pUserDatabase;
        pUserDatabase = new PUserDatabase();
        pUserDatabase.setDatabaseName(databaseName);
        varB4EAC82CA7396A68D541C85D26508E83_1027279243 = pUserDatabase;
        addTaint(databaseName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1027279243.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1027279243;
        // ---------- Original Method ----------
        //if((databaseName ==null)||(databaseName.equals(" ")))
            //throw new NullPointerException("Database name is null");
        //PUserDatabase pUserDatabase = new PUserDatabase();
        //pUserDatabase.setDatabaseName(databaseName);
        //return pUserDatabase;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.433 -0400", hash_original_method = "6A0691F102D20D70FD0A6921A61CA118", hash_generated_method = "341117E20CDDF3DC6F64186F3C4E5A2F")
    public PProfileKeyHeader createPProfileKeyHeader(Address address) {
        PProfileKeyHeader varB4EAC82CA7396A68D541C85D26508E83_1539973509 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Address is null");
        PProfileKey pProfileKey;
        pProfileKey = new PProfileKey();
        pProfileKey.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_1539973509 = pProfileKey;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1539973509.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1539973509;
        // ---------- Original Method ----------
        //if (address ==null)
            //throw new NullPointerException("Address is null");
        //PProfileKey pProfileKey = new PProfileKey();
        //pProfileKey.setAddress(address);
        //return pProfileKey;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.433 -0400", hash_original_method = "38B7C1667A9FD579C07BB14E255FF56A", hash_generated_method = "1712602EC73DB264F5CF29E5D98AB366")
    public PServedUserHeader createPServedUserHeader(Address address) {
        PServedUserHeader varB4EAC82CA7396A68D541C85D26508E83_1853501039 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Address is null");
        PServedUser psu;
        psu = new PServedUser();
        psu.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_1853501039 = psu;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1853501039.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1853501039;
        // ---------- Original Method ----------
        //if(address==null)
            //throw new NullPointerException("Address is null");
        //PServedUser psu = new PServedUser();
        //psu.setAddress(address);
        //return psu;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.434 -0400", hash_original_method = "C0CFD4DCC2CCE8A2BE967D3A2132C68A", hash_generated_method = "056930F0760F0F31BC34AADB99868B20")
    public PPreferredServiceHeader createPPreferredServiceHeader() {
        PPreferredServiceHeader varB4EAC82CA7396A68D541C85D26508E83_548729062 = null; //Variable for return #1
        PPreferredService pps;
        pps = new PPreferredService();
        varB4EAC82CA7396A68D541C85D26508E83_548729062 = pps;
        varB4EAC82CA7396A68D541C85D26508E83_548729062.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_548729062;
        // ---------- Original Method ----------
        //PPreferredService pps = new PPreferredService();
        //return pps;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.434 -0400", hash_original_method = "48E529894AF92157CD42EE8DFB6E18AB", hash_generated_method = "DD7AEC10A62B6B076BFC68BCE3EFE4B1")
    public PAssertedServiceHeader createPAssertedServiceHeader() {
        PAssertedServiceHeader varB4EAC82CA7396A68D541C85D26508E83_1183440613 = null; //Variable for return #1
        PAssertedService pas;
        pas = new PAssertedService();
        varB4EAC82CA7396A68D541C85D26508E83_1183440613 = pas;
        varB4EAC82CA7396A68D541C85D26508E83_1183440613.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1183440613;
        // ---------- Original Method ----------
        //PAssertedService pas = new PAssertedService();
        //return pas;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.437 -0400", hash_original_method = "6D472F26B8815D9A75157924D7DB3DB8", hash_generated_method = "45B4DD2048FD6894C3C1F99E9589F3E2")
    public SessionExpiresHeader createSessionExpiresHeader(int expires) throws InvalidArgumentException {
        SessionExpiresHeader varB4EAC82CA7396A68D541C85D26508E83_2125179477 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad value " + expires);
        SessionExpires s;
        s = new SessionExpires();
        s.setExpires(expires);
        varB4EAC82CA7396A68D541C85D26508E83_2125179477 = s;
        addTaint(expires);
        varB4EAC82CA7396A68D541C85D26508E83_2125179477.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2125179477;
        // ---------- Original Method ----------
        //if (expires < 0)
            //throw new InvalidArgumentException("bad value " + expires);
        //SessionExpires s = new SessionExpires();
        //s.setExpires(expires);
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.439 -0400", hash_original_method = "F07701895F7EA99F66D330A17A2FD28D", hash_generated_method = "C725F8D84F759F333DE607D528A2C2C5")
    public SipRequestLine createRequestLine(String requestLine) throws ParseException {
        SipRequestLine varB4EAC82CA7396A68D541C85D26508E83_1430248916 = null; //Variable for return #1
        RequestLineParser requestLineParser;
        requestLineParser = new RequestLineParser(requestLine);
        varB4EAC82CA7396A68D541C85D26508E83_1430248916 = (SipRequestLine) requestLineParser.parse();
        addTaint(requestLine.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1430248916.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1430248916;
        // ---------- Original Method ----------
        //RequestLineParser requestLineParser = new RequestLineParser(requestLine);
        //return (SipRequestLine) requestLineParser.parse();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.439 -0400", hash_original_method = "94ED81BC52F6E3EE358EE57713F40357", hash_generated_method = "EA682D6619998BFD9A613168E173FBFF")
    public SipStatusLine createStatusLine(String statusLine) throws ParseException {
        SipStatusLine varB4EAC82CA7396A68D541C85D26508E83_532943089 = null; //Variable for return #1
        StatusLineParser statusLineParser;
        statusLineParser = new StatusLineParser(statusLine);
        varB4EAC82CA7396A68D541C85D26508E83_532943089 = (SipStatusLine) statusLineParser.parse();
        addTaint(statusLine.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_532943089.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_532943089;
        // ---------- Original Method ----------
        //StatusLineParser statusLineParser = new StatusLineParser(statusLine);
        //return (SipStatusLine) statusLineParser.parse();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.442 -0400", hash_original_method = "B06A6A8CC80D9698711113EFD1E58499", hash_generated_method = "019741E4B50B38841BC88FA4E877F25A")
    public ReferencesHeader createReferencesHeader(String callId, String rel) throws ParseException {
        ReferencesHeader varB4EAC82CA7396A68D541C85D26508E83_1971222638 = null; //Variable for return #1
        ReferencesHeader retval;
        retval = new References();
        retval.setCallId(callId);
        retval.setRel(rel);
        varB4EAC82CA7396A68D541C85D26508E83_1971222638 = retval;
        addTaint(callId.getTaint());
        addTaint(rel.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1971222638.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1971222638;
        // ---------- Original Method ----------
        //ReferencesHeader retval = new References();
        //retval.setCallId(callId);
        //retval.setRel(rel);
        //return retval;
    }

    
}

