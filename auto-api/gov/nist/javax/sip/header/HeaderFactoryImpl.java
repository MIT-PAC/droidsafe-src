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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.150 -0400", hash_original_field = "6FA63D73209D74D0D54BC416A32DB10D", hash_generated_field = "0D2878F1D6B0CD805C869443DA7FE75E")

    private boolean stripAddressScopeZones = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.151 -0400", hash_original_method = "EA4ABB94B4CFEF029E31D8F450F44C66", hash_generated_method = "4DBE2EDCEE71001244079D3C05C060E8")
    public  HeaderFactoryImpl() {
        stripAddressScopeZones
            = Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
        // ---------- Original Method ----------
        //stripAddressScopeZones
            //= Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.152 -0400", hash_original_method = "9BEACA878DCF694953AD8141227DB60F", hash_generated_method = "EC22EB8666E3DDC0B2C501EFE162CB63")
    public void setPrettyEncoding(boolean flag) {
        SIPHeaderList.setPrettyEncode(flag);
        addTaint(flag);
        // ---------- Original Method ----------
        //SIPHeaderList.setPrettyEncode(flag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.158 -0400", hash_original_method = "58113BBBA3D76308CFB19C46D0FF7A27", hash_generated_method = "10F67EB7521F2771C0BC074FB8013DCC")
    public AcceptEncodingHeader createAcceptEncodingHeader(String encoding) throws ParseException {
        AcceptEncodingHeader varB4EAC82CA7396A68D541C85D26508E83_1485384773 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("the encoding parameter is null");
        AcceptEncoding acceptEncoding;
        acceptEncoding = new AcceptEncoding();
        acceptEncoding.setEncoding(encoding);
        varB4EAC82CA7396A68D541C85D26508E83_1485384773 = acceptEncoding;
        addTaint(encoding.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1485384773.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1485384773;
        // ---------- Original Method ----------
        //if (encoding == null)
            //throw new NullPointerException("the encoding parameter is null");
        //AcceptEncoding acceptEncoding = new AcceptEncoding();
        //acceptEncoding.setEncoding(encoding);
        //return acceptEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.174 -0400", hash_original_method = "3FEA70547EDCF31E1AA086D3362AC6CE", hash_generated_method = "E1B8A6C7C04F234F6D0425ABBD48FA98")
    public AcceptHeader createAcceptHeader(
        String contentType,
        String contentSubType) throws ParseException {
        AcceptHeader varB4EAC82CA7396A68D541C85D26508E83_930976229 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("contentType or subtype is null ");
        Accept accept;
        accept = new Accept();
        accept.setContentType(contentType);
        accept.setContentSubType(contentSubType);
        varB4EAC82CA7396A68D541C85D26508E83_930976229 = accept;
        addTaint(contentType.getTaint());
        addTaint(contentSubType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_930976229.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_930976229;
        // ---------- Original Method ----------
        //if (contentType == null || contentSubType == null)
            //throw new NullPointerException("contentType or subtype is null ");
        //Accept accept = new Accept();
        //accept.setContentType(contentType);
        //accept.setContentSubType(contentSubType);
        //return accept;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.175 -0400", hash_original_method = "5AF5E9D92982780781CC81035C3C1529", hash_generated_method = "E91C6AE54FDF72CE9ADAB57CA3E1EC02")
    public AcceptLanguageHeader createAcceptLanguageHeader(Locale language) {
        AcceptLanguageHeader varB4EAC82CA7396A68D541C85D26508E83_1149296636 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        AcceptLanguage acceptLanguage;
        acceptLanguage = new AcceptLanguage();
        acceptLanguage.setAcceptLanguage(language);
        varB4EAC82CA7396A68D541C85D26508E83_1149296636 = acceptLanguage;
        addTaint(language.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1149296636.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1149296636;
        // ---------- Original Method ----------
        //if (language == null)
            //throw new NullPointerException("null arg");
        //AcceptLanguage acceptLanguage = new AcceptLanguage();
        //acceptLanguage.setAcceptLanguage(language);
        //return acceptLanguage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.176 -0400", hash_original_method = "3E0D5311E2AF98CBAC12E04C1647AAA5", hash_generated_method = "54E1B1ED7BD8E29C5C73DD00199BD509")
    public AlertInfoHeader createAlertInfoHeader(URI alertInfo) {
        AlertInfoHeader varB4EAC82CA7396A68D541C85D26508E83_1917431692 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg alertInfo");
        AlertInfo a;
        a = new AlertInfo();
        a.setAlertInfo(alertInfo);
        varB4EAC82CA7396A68D541C85D26508E83_1917431692 = a;
        addTaint(alertInfo.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1917431692.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1917431692;
        // ---------- Original Method ----------
        //if (alertInfo == null)
            //throw new NullPointerException("null arg alertInfo");
        //AlertInfo a = new AlertInfo();
        //a.setAlertInfo(alertInfo);
        //return a;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.178 -0400", hash_original_method = "7A8DE3D3022A3669E75EC61B4D0B5F19", hash_generated_method = "3D04B55753262FFA8DE790409ACE3844")
    public AllowEventsHeader createAllowEventsHeader(String eventType) throws ParseException {
        AllowEventsHeader varB4EAC82CA7396A68D541C85D26508E83_378053627 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg eventType");
        AllowEvents allowEvents;
        allowEvents = new AllowEvents();
        allowEvents.setEventType(eventType);
        varB4EAC82CA7396A68D541C85D26508E83_378053627 = allowEvents;
        addTaint(eventType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_378053627.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_378053627;
        // ---------- Original Method ----------
        //if (eventType == null)
            //throw new NullPointerException("null arg eventType");
        //AllowEvents allowEvents = new AllowEvents();
        //allowEvents.setEventType(eventType);
        //return allowEvents;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.183 -0400", hash_original_method = "C562ECE8E2158A54C27A4525D88FEA63", hash_generated_method = "F0BEE166E09EFE4F68EF38CB7F388626")
    public AllowHeader createAllowHeader(String method) throws ParseException {
        AllowHeader varB4EAC82CA7396A68D541C85D26508E83_634947910 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg method");
        Allow allow;
        allow = new Allow();
        allow.setMethod(method);
        varB4EAC82CA7396A68D541C85D26508E83_634947910 = allow;
        addTaint(method.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_634947910.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_634947910;
        // ---------- Original Method ----------
        //if (method == null)
            //throw new NullPointerException("null arg method");
        //Allow allow = new Allow();
        //allow.setMethod(method);
        //return allow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.185 -0400", hash_original_method = "E72D81A306A857A102E9D4437AB18CA6", hash_generated_method = "A7D861DAD783B55C6A51B95815C39C7B")
    public AuthenticationInfoHeader createAuthenticationInfoHeader(String response) throws ParseException {
        AuthenticationInfoHeader varB4EAC82CA7396A68D541C85D26508E83_240746330 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg response");
        AuthenticationInfo auth;
        auth = new AuthenticationInfo();
        auth.setResponse(response);
        varB4EAC82CA7396A68D541C85D26508E83_240746330 = auth;
        addTaint(response.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_240746330.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_240746330;
        // ---------- Original Method ----------
        //if (response == null)
            //throw new NullPointerException("null arg response");
        //AuthenticationInfo auth = new AuthenticationInfo();
        //auth.setResponse(response);
        //return auth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.189 -0400", hash_original_method = "F250EC80C8CD1CBE5FF237A98CBD8CD0", hash_generated_method = "DF0BB4C2C2DF7E094EF3F6CE85AFA71E")
    public AuthorizationHeader createAuthorizationHeader(String scheme) throws ParseException {
        AuthorizationHeader varB4EAC82CA7396A68D541C85D26508E83_1875691429 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg scheme ");
        Authorization auth;
        auth = new Authorization();
        auth.setScheme(scheme);
        varB4EAC82CA7396A68D541C85D26508E83_1875691429 = auth;
        addTaint(scheme.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1875691429.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1875691429;
        // ---------- Original Method ----------
        //if (scheme == null)
            //throw new NullPointerException("null arg scheme ");
        //Authorization auth = new Authorization();
        //auth.setScheme(scheme);
        //return auth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.190 -0400", hash_original_method = "9707416B5040BCEA07917ADCBF33DA70", hash_generated_method = "A78CFED75427662EBBFD1F6EC25134DE")
    public CSeqHeader createCSeqHeader( long sequenceNumber, String method) throws ParseException, InvalidArgumentException {
        CSeqHeader varB4EAC82CA7396A68D541C85D26508E83_2100020230 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad arg " + sequenceNumber);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg method");
        CSeq cseq;
        cseq = new CSeq();
        cseq.setMethod(method);
        cseq.setSeqNumber(sequenceNumber);
        varB4EAC82CA7396A68D541C85D26508E83_2100020230 = cseq;
        addTaint(sequenceNumber);
        addTaint(method.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2100020230.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2100020230;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.198 -0400", hash_original_method = "332D5DD16F528ACCDED76BFE26F4F243", hash_generated_method = "9D8B7EFB41721193B62F30AE484A332A")
    public CSeqHeader createCSeqHeader( int sequenceNumber, String method) throws ParseException, InvalidArgumentException {
        CSeqHeader varB4EAC82CA7396A68D541C85D26508E83_1752977103 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1752977103 = this.createCSeqHeader( (long) sequenceNumber, method );
        addTaint(sequenceNumber);
        addTaint(method.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1752977103.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1752977103;
        // ---------- Original Method ----------
        //return this.createCSeqHeader( (long) sequenceNumber, method );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.199 -0400", hash_original_method = "0CB560808F252622C176039BC6E86FF7", hash_generated_method = "38A5C3DD06038A5BE811C3D46276B244")
    public CallIdHeader createCallIdHeader(String callId) throws ParseException {
        CallIdHeader varB4EAC82CA7396A68D541C85D26508E83_1377570484 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg callId");
        CallID c;
        c = new CallID();
        c.setCallId(callId);
        varB4EAC82CA7396A68D541C85D26508E83_1377570484 = c;
        addTaint(callId.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1377570484.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1377570484;
        // ---------- Original Method ----------
        //if (callId == null)
            //throw new NullPointerException("null arg callId");
        //CallID c = new CallID();
        //c.setCallId(callId);
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.199 -0400", hash_original_method = "8867B6CA9EB8DB8DAA3F991D7B0AD5D9", hash_generated_method = "62F005F4BEE59F081D321FAB61C9AF97")
    public CallInfoHeader createCallInfoHeader(URI callInfo) {
        CallInfoHeader varB4EAC82CA7396A68D541C85D26508E83_930638051 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg callInfo");
        CallInfo c;
        c = new CallInfo();
        c.setInfo(callInfo);
        varB4EAC82CA7396A68D541C85D26508E83_930638051 = c;
        addTaint(callInfo.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_930638051.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_930638051;
        // ---------- Original Method ----------
        //if (callInfo == null)
            //throw new NullPointerException("null arg callInfo");
        //CallInfo c = new CallInfo();
        //c.setInfo(callInfo);
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.200 -0400", hash_original_method = "45EF0D9994A51A34EA10DF4A185E8F21", hash_generated_method = "C6C5DBFC49F73AB694D772D9AE1CE869")
    public ContactHeader createContactHeader(Address address) {
        ContactHeader varB4EAC82CA7396A68D541C85D26508E83_333508898 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg address");
        Contact contact;
        contact = new Contact();
        contact.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_333508898 = contact;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_333508898.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_333508898;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null arg address");
        //Contact contact = new Contact();
        //contact.setAddress(address);
        //return contact;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.200 -0400", hash_original_method = "5873C88FB18B86DA11D334099F5AE064", hash_generated_method = "ED321285C7957A7554B8138F4223B156")
    public ContactHeader createContactHeader() {
        ContactHeader varB4EAC82CA7396A68D541C85D26508E83_1001387503 = null; //Variable for return #1
        Contact contact;
        contact = new Contact();
        contact.setWildCardFlag(true);
        contact.setExpires(0);
        varB4EAC82CA7396A68D541C85D26508E83_1001387503 = contact;
        varB4EAC82CA7396A68D541C85D26508E83_1001387503.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1001387503;
        // ---------- Original Method ----------
        //Contact contact = new Contact();
        //contact.setWildCardFlag(true);
        //contact.setExpires(0);
        //return contact;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.207 -0400", hash_original_method = "CC352C2425871DC27A0C55CF39D4ABAB", hash_generated_method = "ECDCE4ECCD5F56E43CD65D2F498ECA05")
    public ContentDispositionHeader createContentDispositionHeader(String contentDisposition) throws ParseException {
        ContentDispositionHeader varB4EAC82CA7396A68D541C85D26508E83_322672824 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg contentDisposition");
        ContentDisposition c;
        c = new ContentDisposition();
        c.setDispositionType(contentDisposition);
        varB4EAC82CA7396A68D541C85D26508E83_322672824 = c;
        addTaint(contentDisposition.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_322672824.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_322672824;
        // ---------- Original Method ----------
        //if (contentDisposition == null)
            //throw new NullPointerException("null arg contentDisposition");
        //ContentDisposition c = new ContentDisposition();
        //c.setDispositionType(contentDisposition);
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.213 -0400", hash_original_method = "090104ADCCDA5F259494E038435257D1", hash_generated_method = "24A41C39A6C6CCD592B6220960338E96")
    public ContentEncodingHeader createContentEncodingHeader(String encoding) throws ParseException {
        ContentEncodingHeader varB4EAC82CA7396A68D541C85D26508E83_1682890752 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null encoding");
        ContentEncoding c;
        c = new ContentEncoding();
        c.setEncoding(encoding);
        varB4EAC82CA7396A68D541C85D26508E83_1682890752 = c;
        addTaint(encoding.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1682890752.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1682890752;
        // ---------- Original Method ----------
        //if (encoding == null)
            //throw new NullPointerException("null encoding");
        //ContentEncoding c = new ContentEncoding();
        //c.setEncoding(encoding);
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.214 -0400", hash_original_method = "CD027E2457CF527330FF9F4C0A972B91", hash_generated_method = "B07816683E04ED05525C46F7CFAF2133")
    public ContentLanguageHeader createContentLanguageHeader(Locale contentLanguage) {
        ContentLanguageHeader varB4EAC82CA7396A68D541C85D26508E83_2015483625 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg contentLanguage");
        ContentLanguage c;
        c = new ContentLanguage();
        c.setContentLanguage(contentLanguage);
        varB4EAC82CA7396A68D541C85D26508E83_2015483625 = c;
        addTaint(contentLanguage.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2015483625.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2015483625;
        // ---------- Original Method ----------
        //if (contentLanguage == null)
            //throw new NullPointerException("null arg contentLanguage");
        //ContentLanguage c = new ContentLanguage();
        //c.setContentLanguage(contentLanguage);
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.221 -0400", hash_original_method = "DA3B5EC62F3E30804B07AD592D303E3E", hash_generated_method = "4C93FE127D4C8636903DC9451F06DF63")
    public ContentLengthHeader createContentLengthHeader(int contentLength) throws InvalidArgumentException {
        ContentLengthHeader varB4EAC82CA7396A68D541C85D26508E83_388571605 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad contentLength");
        ContentLength c;
        c = new ContentLength();
        c.setContentLength(contentLength);
        varB4EAC82CA7396A68D541C85D26508E83_388571605 = c;
        addTaint(contentLength);
        varB4EAC82CA7396A68D541C85D26508E83_388571605.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_388571605;
        // ---------- Original Method ----------
        //if (contentLength < 0)
            //throw new InvalidArgumentException("bad contentLength");
        //ContentLength c = new ContentLength();
        //c.setContentLength(contentLength);
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.221 -0400", hash_original_method = "BF42B4FF2E7F96D2FA4773C6E514B79D", hash_generated_method = "1841CABAB2281C00D8CDF5398256F561")
    public ContentTypeHeader createContentTypeHeader(
        String contentType,
        String contentSubType) throws ParseException {
        ContentTypeHeader varB4EAC82CA7396A68D541C85D26508E83_1116286211 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null contentType or subType");
        ContentType c;
        c = new ContentType();
        c.setContentType(contentType);
        c.setContentSubType(contentSubType);
        varB4EAC82CA7396A68D541C85D26508E83_1116286211 = c;
        addTaint(contentType.getTaint());
        addTaint(contentSubType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1116286211.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1116286211;
        // ---------- Original Method ----------
        //if (contentType == null || contentSubType == null)
            //throw new NullPointerException("null contentType or subType");
        //ContentType c = new ContentType();
        //c.setContentType(contentType);
        //c.setContentSubType(contentSubType);
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.222 -0400", hash_original_method = "F3D0948AB2AB5DCB4D46B0F9C4754A1D", hash_generated_method = "89E735D6B838F8A7F32F5C95CA98742E")
    public DateHeader createDateHeader(Calendar date) {
        DateHeader varB4EAC82CA7396A68D541C85D26508E83_1091994653 = null; //Variable for return #1
        SIPDateHeader d;
        d = new SIPDateHeader();
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null date");
        d.setDate(date);
        varB4EAC82CA7396A68D541C85D26508E83_1091994653 = d;
        addTaint(date.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1091994653.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1091994653;
        // ---------- Original Method ----------
        //SIPDateHeader d = new SIPDateHeader();
        //if (date == null)
            //throw new NullPointerException("null date");
        //d.setDate(date);
        //return d;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.222 -0400", hash_original_method = "7FD58797EECF83FE34BEE1F3B093BC46", hash_generated_method = "B1CAA7D5E9FD5EA6E7E48269924FEE2A")
    public EventHeader createEventHeader(String eventType) throws ParseException {
        EventHeader varB4EAC82CA7396A68D541C85D26508E83_516946537 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null eventType");
        Event event;
        event = new Event();
        event.setEventType(eventType);
        varB4EAC82CA7396A68D541C85D26508E83_516946537 = event;
        addTaint(eventType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_516946537.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_516946537;
        // ---------- Original Method ----------
        //if (eventType == null)
            //throw new NullPointerException("null eventType");
        //Event event = new Event();
        //event.setEventType(eventType);
        //return event;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.227 -0400", hash_original_method = "1A307AD1BD02E7BD6299AF40D811E5D5", hash_generated_method = "8B68D053713ED994F942A76F6BB6FFAC")
    public ExpiresHeader createExpiresHeader(int expires) throws InvalidArgumentException {
        ExpiresHeader varB4EAC82CA7396A68D541C85D26508E83_1582426153 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad value " + expires);
        Expires e;
        e = new Expires();
        e.setExpires(expires);
        varB4EAC82CA7396A68D541C85D26508E83_1582426153 = e;
        addTaint(expires);
        varB4EAC82CA7396A68D541C85D26508E83_1582426153.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1582426153;
        // ---------- Original Method ----------
        //if (expires < 0)
            //throw new InvalidArgumentException("bad value " + expires);
        //Expires e = new Expires();
        //e.setExpires(expires);
        //return e;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.230 -0400", hash_original_method = "C38CB4735B94E96E0C6FB81DC8E60CBF", hash_generated_method = "30231EE599A500A3EBFA43857A5395B7")
    public javax.sip.header.ExtensionHeader createExtensionHeader(
        String name,
        String value) throws ParseException {
        javax.sip.header.ExtensionHeader varB4EAC82CA7396A68D541C85D26508E83_371754625 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("bad name");
        gov.nist.javax.sip.header.ExtensionHeaderImpl ext;
        ext = new gov.nist.javax.sip.header.ExtensionHeaderImpl();
        ext.setName(name);
        ext.setValue(value);
        varB4EAC82CA7396A68D541C85D26508E83_371754625 = ext;
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_371754625.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_371754625;
        // ---------- Original Method ----------
        //if (name == null)
            //throw new NullPointerException("bad name");
        //gov.nist.javax.sip.header.ExtensionHeaderImpl ext =
            //new gov.nist.javax.sip.header.ExtensionHeaderImpl();
        //ext.setName(name);
        //ext.setValue(value);
        //return ext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.244 -0400", hash_original_method = "E3876C81F77C4C65824998CB51869857", hash_generated_method = "CC18A4090ACC4C7768907FC7F4F2C42E")
    public FromHeader createFromHeader(Address address, String tag) throws ParseException {
        FromHeader varB4EAC82CA7396A68D541C85D26508E83_24861599 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address arg");
        From from;
        from = new From();
        from.setAddress(address);
        from.setTag(tag);
        varB4EAC82CA7396A68D541C85D26508E83_24861599 = from;
        addTaint(address.getTaint());
        addTaint(tag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_24861599.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_24861599;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address arg");
        //From from = new From();
        //from.setAddress(address);
        //if (tag != null)
            //from.setTag(tag);
        //return from;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.247 -0400", hash_original_method = "4DE074146D6A81FB201A39A399764E9F", hash_generated_method = "0A2F39163E286167858943696D446D06")
    public InReplyToHeader createInReplyToHeader(String callId) throws ParseException {
        InReplyToHeader varB4EAC82CA7396A68D541C85D26508E83_181007957 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null callId arg");
        InReplyTo inReplyTo;
        inReplyTo = new InReplyTo();
        inReplyTo.setCallId(callId);
        varB4EAC82CA7396A68D541C85D26508E83_181007957 = inReplyTo;
        addTaint(callId.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_181007957.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_181007957;
        // ---------- Original Method ----------
        //if (callId == null)
            //throw new NullPointerException("null callId arg");
        //InReplyTo inReplyTo = new InReplyTo();
        //inReplyTo.setCallId(callId);
        //return inReplyTo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.248 -0400", hash_original_method = "2B62AE770A28023C5424C7B7718E4BD4", hash_generated_method = "E433810136E05A04E89E8A3AAAE2A5CC")
    public MaxForwardsHeader createMaxForwardsHeader(int maxForwards) throws InvalidArgumentException {
        MaxForwardsHeader varB4EAC82CA7396A68D541C85D26508E83_1423090520 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "bad maxForwards arg " + maxForwards);
        MaxForwards m;
        m = new MaxForwards();
        m.setMaxForwards(maxForwards);
        varB4EAC82CA7396A68D541C85D26508E83_1423090520 = m;
        addTaint(maxForwards);
        varB4EAC82CA7396A68D541C85D26508E83_1423090520.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1423090520;
        // ---------- Original Method ----------
        //if (maxForwards < 0 || maxForwards > 255)
            //throw new InvalidArgumentException(
                //"bad maxForwards arg " + maxForwards);
        //MaxForwards m = new MaxForwards();
        //m.setMaxForwards(maxForwards);
        //return m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.248 -0400", hash_original_method = "623C745ED7578EC4227F3B15A38B5D4A", hash_generated_method = "BC1446E926147169DD33E57D8951563C")
    public MimeVersionHeader createMimeVersionHeader(
        int majorVersion,
        int minorVersion) throws InvalidArgumentException {
        MimeVersionHeader varB4EAC82CA7396A68D541C85D26508E83_905236715 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new javax.sip.InvalidArgumentException(
                "bad major/minor version");
        MimeVersion m;
        m = new MimeVersion();
        m.setMajorVersion(majorVersion);
        m.setMinorVersion(minorVersion);
        varB4EAC82CA7396A68D541C85D26508E83_905236715 = m;
        addTaint(majorVersion);
        addTaint(minorVersion);
        varB4EAC82CA7396A68D541C85D26508E83_905236715.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_905236715;
        // ---------- Original Method ----------
        //if (majorVersion < 0 || minorVersion < 0)
            //throw new javax.sip.InvalidArgumentException(
                //"bad major/minor version");
        //MimeVersion m = new MimeVersion();
        //m.setMajorVersion(majorVersion);
        //m.setMinorVersion(minorVersion);
        //return m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.253 -0400", hash_original_method = "F897D0FECB8A8CC74BFA504858C91B42", hash_generated_method = "86200788F18DB07FB6DC7EE665DD1D72")
    public MinExpiresHeader createMinExpiresHeader(int minExpires) throws InvalidArgumentException {
        MinExpiresHeader varB4EAC82CA7396A68D541C85D26508E83_1054946543 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad minExpires " + minExpires);
        MinExpires min;
        min = new MinExpires();
        min.setExpires(minExpires);
        varB4EAC82CA7396A68D541C85D26508E83_1054946543 = min;
        addTaint(minExpires);
        varB4EAC82CA7396A68D541C85D26508E83_1054946543.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1054946543;
        // ---------- Original Method ----------
        //if (minExpires < 0)
            //throw new InvalidArgumentException("bad minExpires " + minExpires);
        //MinExpires min = new MinExpires();
        //min.setExpires(minExpires);
        //return min;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.257 -0400", hash_original_method = "8EE941BB2D8E39A517F98D1ED3613B4D", hash_generated_method = "6C24F2E8BF56DEEA90A3B0B9E24BAC9F")
    public ExtensionHeader createMinSEHeader(int expires) throws InvalidArgumentException {
        ExtensionHeader varB4EAC82CA7396A68D541C85D26508E83_2048987527 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad value " + expires);
        MinSE e;
        e = new MinSE();
        e.setExpires(expires);
        varB4EAC82CA7396A68D541C85D26508E83_2048987527 = e;
        addTaint(expires);
        varB4EAC82CA7396A68D541C85D26508E83_2048987527.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2048987527;
        // ---------- Original Method ----------
        //if (expires < 0)
            //throw new InvalidArgumentException("bad value " + expires);
        //MinSE e = new MinSE();
        //e.setExpires(expires);
        //return e;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.258 -0400", hash_original_method = "2F5DB311D13CB6144CC7B49271775C33", hash_generated_method = "DBFA3D963A87C9C9BF010293AF444A7F")
    public OrganizationHeader createOrganizationHeader(String organization) throws ParseException {
        OrganizationHeader varB4EAC82CA7396A68D541C85D26508E83_162772240 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("bad organization arg");
        Organization o;
        o = new Organization();
        o.setOrganization(organization);
        varB4EAC82CA7396A68D541C85D26508E83_162772240 = o;
        addTaint(organization.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_162772240.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_162772240;
        // ---------- Original Method ----------
        //if (organization == null)
            //throw new NullPointerException("bad organization arg");
        //Organization o = new Organization();
        //o.setOrganization(organization);
        //return o;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.258 -0400", hash_original_method = "085951AB405380C6C60E1EC174C5C855", hash_generated_method = "D9E5041E99FCFAD3719D99CA9378F774")
    public PriorityHeader createPriorityHeader(String priority) throws ParseException {
        PriorityHeader varB4EAC82CA7396A68D541C85D26508E83_573160792 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("bad priority arg");
        Priority p;
        p = new Priority();
        p.setPriority(priority);
        varB4EAC82CA7396A68D541C85D26508E83_573160792 = p;
        addTaint(priority.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_573160792.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_573160792;
        // ---------- Original Method ----------
        //if (priority == null)
            //throw new NullPointerException("bad priority arg");
        //Priority p = new Priority();
        //p.setPriority(priority);
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.263 -0400", hash_original_method = "E2D1E713D6EFBD9B5EF73CE359255B39", hash_generated_method = "B9C264758048119B8AFBCD68652839C5")
    public ProxyAuthenticateHeader createProxyAuthenticateHeader(String scheme) throws ParseException {
        ProxyAuthenticateHeader varB4EAC82CA7396A68D541C85D26508E83_1017934620 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("bad scheme arg");
        ProxyAuthenticate p;
        p = new ProxyAuthenticate();
        p.setScheme(scheme);
        varB4EAC82CA7396A68D541C85D26508E83_1017934620 = p;
        addTaint(scheme.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1017934620.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1017934620;
        // ---------- Original Method ----------
        //if (scheme == null)
            //throw new NullPointerException("bad scheme arg");
        //ProxyAuthenticate p = new ProxyAuthenticate();
        //p.setScheme(scheme);
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.266 -0400", hash_original_method = "E046B5DACDD94AD026F81045FF391CD1", hash_generated_method = "4989DE8146DA9BB028EBC61E93CD09F4")
    public ProxyAuthorizationHeader createProxyAuthorizationHeader(String scheme) throws ParseException {
        ProxyAuthorizationHeader varB4EAC82CA7396A68D541C85D26508E83_1437657798 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("bad scheme arg");
        ProxyAuthorization p;
        p = new ProxyAuthorization();
        p.setScheme(scheme);
        varB4EAC82CA7396A68D541C85D26508E83_1437657798 = p;
        addTaint(scheme.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1437657798.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1437657798;
        // ---------- Original Method ----------
        //if (scheme == null)
            //throw new NullPointerException("bad scheme arg");
        //ProxyAuthorization p = new ProxyAuthorization();
        //p.setScheme(scheme);
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.267 -0400", hash_original_method = "A059B8FD47D8FC83321E2DEF4CB18490", hash_generated_method = "F71B1D79E87D5C2D63C48F7CFBA27DA4")
    public ProxyRequireHeader createProxyRequireHeader(String optionTag) throws ParseException {
        ProxyRequireHeader varB4EAC82CA7396A68D541C85D26508E83_940953801 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("bad optionTag arg");
        ProxyRequire p;
        p = new ProxyRequire();
        p.setOptionTag(optionTag);
        varB4EAC82CA7396A68D541C85D26508E83_940953801 = p;
        addTaint(optionTag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_940953801.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_940953801;
        // ---------- Original Method ----------
        //if (optionTag == null)
            //throw new NullPointerException("bad optionTag arg");
        //ProxyRequire p = new ProxyRequire();
        //p.setOptionTag(optionTag);
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.268 -0400", hash_original_method = "42539302BE9490416DF1DC01B8BC3D99", hash_generated_method = "A49A6A6975A8BF2BB7151E382339BF9A")
    public RAckHeader createRAckHeader(
        long rSeqNumber,
        long cSeqNumber,
        String method) throws InvalidArgumentException, ParseException {
        RAckHeader varB4EAC82CA7396A68D541C85D26508E83_739884252 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Bad method");
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad cseq/rseq arg");
        RAck rack;
        rack = new RAck();
        rack.setMethod(method);
        rack.setCSequenceNumber(cSeqNumber);
        rack.setRSequenceNumber(rSeqNumber);
        varB4EAC82CA7396A68D541C85D26508E83_739884252 = rack;
        addTaint(rSeqNumber);
        addTaint(cSeqNumber);
        addTaint(method.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_739884252.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_739884252;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.278 -0400", hash_original_method = "B44C2BD23DFFCB51A992C42D93BADE4E", hash_generated_method = "22E59B4EE449C22B9DF228185312810D")
    public RAckHeader createRAckHeader(int rSeqNumber, int cSeqNumber, String method) throws InvalidArgumentException, ParseException {
        RAckHeader varB4EAC82CA7396A68D541C85D26508E83_1088981953 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1088981953 = createRAckHeader((long)rSeqNumber, (long)cSeqNumber, method);
        addTaint(rSeqNumber);
        addTaint(cSeqNumber);
        addTaint(method.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1088981953.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1088981953;
        // ---------- Original Method ----------
        //return createRAckHeader((long)rSeqNumber, (long)cSeqNumber, method);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.279 -0400", hash_original_method = "38086BF4D4EB3CE5AB4BF7772F8EACF2", hash_generated_method = "A9801D42277E358F1431EA6EBFAD06CD")
    public RSeqHeader createRSeqHeader(int sequenceNumber) throws InvalidArgumentException {
        RSeqHeader varB4EAC82CA7396A68D541C85D26508E83_1566796039 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1566796039 = createRSeqHeader((long) sequenceNumber);
        addTaint(sequenceNumber);
        varB4EAC82CA7396A68D541C85D26508E83_1566796039.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1566796039;
        // ---------- Original Method ----------
        //return createRSeqHeader((long) sequenceNumber) ;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.279 -0400", hash_original_method = "CA4CA07B31DF6CB609C05636F40DB22F", hash_generated_method = "96C4FC12B2D3F5A3F058A503130C16F1")
    public RSeqHeader createRSeqHeader(long sequenceNumber) throws InvalidArgumentException {
        RSeqHeader varB4EAC82CA7396A68D541C85D26508E83_2086250133 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "invalid sequenceNumber arg " + sequenceNumber);
        RSeq rseq;
        rseq = new RSeq();
        rseq.setSeqNumber(sequenceNumber);
        varB4EAC82CA7396A68D541C85D26508E83_2086250133 = rseq;
        addTaint(sequenceNumber);
        varB4EAC82CA7396A68D541C85D26508E83_2086250133.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2086250133;
        // ---------- Original Method ----------
        //if (sequenceNumber < 0)
            //throw new InvalidArgumentException(
                //"invalid sequenceNumber arg " + sequenceNumber);
        //RSeq rseq = new RSeq();
        //rseq.setSeqNumber(sequenceNumber);
        //return rseq;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.280 -0400", hash_original_method = "57AD0B4E4FE03197F2B52972D6060CBA", hash_generated_method = "305164A1B9392EF74C694CCC96FA56C4")
    public ReasonHeader createReasonHeader(
        String protocol,
        int cause,
        String text) throws InvalidArgumentException, ParseException {
        ReasonHeader varB4EAC82CA7396A68D541C85D26508E83_276099920 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("bad protocol arg");
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad cause");
        Reason reason;
        reason = new Reason();
        reason.setProtocol(protocol);
        reason.setCause(cause);
        reason.setText(text);
        varB4EAC82CA7396A68D541C85D26508E83_276099920 = reason;
        addTaint(protocol.getTaint());
        addTaint(cause);
        addTaint(text.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_276099920.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_276099920;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.284 -0400", hash_original_method = "6DA29D8692407706B9B05391AF333993", hash_generated_method = "0EAEE031355BBF0FE087BA1EA595103F")
    public RecordRouteHeader createRecordRouteHeader(Address address) {
        RecordRouteHeader varB4EAC82CA7396A68D541C85D26508E83_829613062 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null argument!");
        RecordRoute recordRoute;
        recordRoute = new RecordRoute();
        recordRoute.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_829613062 = recordRoute;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_829613062.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_829613062;
        // ---------- Original Method ----------
        //if ( address == null) throw new NullPointerException("Null argument!");
        //RecordRoute recordRoute = new RecordRoute();
        //recordRoute.setAddress(address);
        //return recordRoute;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.286 -0400", hash_original_method = "4393C033D6B63EF338EB93DE3E753573", hash_generated_method = "6440295BA353C344393A416D74D1C525")
    public ReplyToHeader createReplyToHeader(Address address) {
        ReplyToHeader varB4EAC82CA7396A68D541C85D26508E83_198007940 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address");
        ReplyTo replyTo;
        replyTo = new ReplyTo();
        replyTo.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_198007940 = replyTo;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_198007940.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_198007940;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address");
        //ReplyTo replyTo = new ReplyTo();
        //replyTo.setAddress(address);
        //return replyTo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.299 -0400", hash_original_method = "F65B5EA444DA08358E800CD7B469501A", hash_generated_method = "AA1450C85916B12CBBEE2F4017D408C7")
    public RequireHeader createRequireHeader(String optionTag) throws ParseException {
        RequireHeader varB4EAC82CA7396A68D541C85D26508E83_1791321483 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null optionTag");
        Require require;
        require = new Require();
        require.setOptionTag(optionTag);
        varB4EAC82CA7396A68D541C85D26508E83_1791321483 = require;
        addTaint(optionTag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1791321483.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1791321483;
        // ---------- Original Method ----------
        //if (optionTag == null)
            //throw new NullPointerException("null optionTag");
        //Require require = new Require();
        //require.setOptionTag(optionTag);
        //return require;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.300 -0400", hash_original_method = "43D5E8C96E4C1ED3ED5B8AD5C39C801C", hash_generated_method = "7B02C8E9300690B75C4D826AF895E7D6")
    public RetryAfterHeader createRetryAfterHeader(int retryAfter) throws InvalidArgumentException {
        RetryAfterHeader varB4EAC82CA7396A68D541C85D26508E83_1895551712 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad retryAfter arg");
        RetryAfter r;
        r = new RetryAfter();
        r.setRetryAfter(retryAfter);
        varB4EAC82CA7396A68D541C85D26508E83_1895551712 = r;
        addTaint(retryAfter);
        varB4EAC82CA7396A68D541C85D26508E83_1895551712.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1895551712;
        // ---------- Original Method ----------
        //if (retryAfter < 0)
            //throw new InvalidArgumentException("bad retryAfter arg");
        //RetryAfter r = new RetryAfter();
        //r.setRetryAfter(retryAfter);
        //return r;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.300 -0400", hash_original_method = "03611E3BB30258B8EC4FDC9F783CBCCF", hash_generated_method = "FF4F041A9207A5AA7C8A56CE80FFA6AE")
    public RouteHeader createRouteHeader(Address address) {
        RouteHeader varB4EAC82CA7396A68D541C85D26508E83_184851550 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address arg");
        Route route;
        route = new Route();
        route.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_184851550 = route;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_184851550.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_184851550;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address arg");
        //Route route = new Route();
        //route.setAddress(address);
        //return route;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.301 -0400", hash_original_method = "65AF02D93E753F97E0AF00F542D03529", hash_generated_method = "46DC351B5D847F76F676C09E5BD115B9")
    public ServerHeader createServerHeader(List product) throws ParseException {
        ServerHeader varB4EAC82CA7396A68D541C85D26508E83_1469388543 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null productList arg");
        Server server;
        server = new Server();
        server.setProduct(product);
        varB4EAC82CA7396A68D541C85D26508E83_1469388543 = server;
        addTaint(product.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1469388543.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1469388543;
        // ---------- Original Method ----------
        //if (product == null)
            //throw new NullPointerException("null productList arg");
        //Server server = new Server();
        //server.setProduct(product);
        //return server;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.301 -0400", hash_original_method = "288EA55C0FFC9E81469649B581E59F71", hash_generated_method = "DF6582A62CF820A9EB938A796348CD09")
    public SubjectHeader createSubjectHeader(String subject) throws ParseException {
        SubjectHeader varB4EAC82CA7396A68D541C85D26508E83_1696811079 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null subject arg");
        Subject s;
        s = new Subject();
        s.setSubject(subject);
        varB4EAC82CA7396A68D541C85D26508E83_1696811079 = s;
        addTaint(subject.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1696811079.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1696811079;
        // ---------- Original Method ----------
        //if (subject == null)
            //throw new NullPointerException("null subject arg");
        //Subject s = new Subject();
        //s.setSubject(subject);
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.306 -0400", hash_original_method = "9B68B72DA8144991BC14639C6BE11723", hash_generated_method = "0CC7A8C47505FD73282C64E0FAF839FB")
    public SubscriptionStateHeader createSubscriptionStateHeader(String subscriptionState) throws ParseException {
        SubscriptionStateHeader varB4EAC82CA7396A68D541C85D26508E83_733394432 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null subscriptionState arg");
        SubscriptionState s;
        s = new SubscriptionState();
        s.setState(subscriptionState);
        varB4EAC82CA7396A68D541C85D26508E83_733394432 = s;
        addTaint(subscriptionState.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_733394432.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_733394432;
        // ---------- Original Method ----------
        //if (subscriptionState == null)
            //throw new NullPointerException("null subscriptionState arg");
        //SubscriptionState s = new SubscriptionState();
        //s.setState(subscriptionState);
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.306 -0400", hash_original_method = "589849ECCDAFDA20BE0DBE1D9A436669", hash_generated_method = "99ABAA8D749F13B1F22974C993A5221F")
    public SupportedHeader createSupportedHeader(String optionTag) throws ParseException {
        SupportedHeader varB4EAC82CA7396A68D541C85D26508E83_453492884 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null optionTag arg");
        Supported supported;
        supported = new Supported();
        supported.setOptionTag(optionTag);
        varB4EAC82CA7396A68D541C85D26508E83_453492884 = supported;
        addTaint(optionTag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_453492884.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_453492884;
        // ---------- Original Method ----------
        //if (optionTag == null)
            //throw new NullPointerException("null optionTag arg");
        //Supported supported = new Supported();
        //supported.setOptionTag(optionTag);
        //return supported;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.329 -0400", hash_original_method = "380079DA7F92D6CF2CEA9086AA5F92D7", hash_generated_method = "50C3EB98381817514B826BB35D839374")
    public TimeStampHeader createTimeStampHeader(float timeStamp) throws InvalidArgumentException {
        TimeStampHeader varB4EAC82CA7396A68D541C85D26508E83_1980270360 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("illegal timeStamp");
        TimeStamp t;
        t = new TimeStamp();
        t.setTimeStamp(timeStamp);
        varB4EAC82CA7396A68D541C85D26508E83_1980270360 = t;
        addTaint(timeStamp);
        varB4EAC82CA7396A68D541C85D26508E83_1980270360.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1980270360;
        // ---------- Original Method ----------
        //if (timeStamp < 0)
            //throw new IllegalArgumentException("illegal timeStamp");
        //TimeStamp t = new TimeStamp();
        //t.setTimeStamp(timeStamp);
        //return t;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.329 -0400", hash_original_method = "7928C6AF630E4BCE57D31FA4979B7453", hash_generated_method = "1832AFD2F855BA12B65529E374D64506")
    public ToHeader createToHeader(Address address, String tag) throws ParseException {
        ToHeader varB4EAC82CA7396A68D541C85D26508E83_1399802716 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address");
        To to;
        to = new To();
        to.setAddress(address);
        to.setTag(tag);
        varB4EAC82CA7396A68D541C85D26508E83_1399802716 = to;
        addTaint(address.getTaint());
        addTaint(tag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1399802716.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1399802716;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address");
        //To to = new To();
        //to.setAddress(address);
        //if (tag != null)
            //to.setTag(tag);
        //return to;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.330 -0400", hash_original_method = "9A62FFB59334167B71BC2FE402276C31", hash_generated_method = "EB7D259BD9FA9B952698A7742AE28319")
    public UnsupportedHeader createUnsupportedHeader(String optionTag) throws ParseException {
        UnsupportedHeader varB4EAC82CA7396A68D541C85D26508E83_1597853340 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(optionTag);
        Unsupported unsupported;
        unsupported = new Unsupported();
        unsupported.setOptionTag(optionTag);
        varB4EAC82CA7396A68D541C85D26508E83_1597853340 = unsupported;
        addTaint(optionTag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1597853340.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1597853340;
        // ---------- Original Method ----------
        //if (optionTag == null)
            //throw new NullPointerException(optionTag);
        //Unsupported unsupported = new Unsupported();
        //unsupported.setOptionTag(optionTag);
        //return unsupported;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.338 -0400", hash_original_method = "0FDDC4550D32FE0A8E48193D044787BB", hash_generated_method = "3278D600AC170316106F337A51E24DB3")
    public UserAgentHeader createUserAgentHeader(List product) throws ParseException {
        UserAgentHeader varB4EAC82CA7396A68D541C85D26508E83_444815699 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null user agent");
        UserAgent userAgent;
        userAgent = new UserAgent();
        userAgent.setProduct(product);
        varB4EAC82CA7396A68D541C85D26508E83_444815699 = userAgent;
        addTaint(product.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_444815699.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_444815699;
        // ---------- Original Method ----------
        //if (product == null)
            //throw new NullPointerException("null user agent");
        //UserAgent userAgent = new UserAgent();
        //userAgent.setProduct(product);
        //return userAgent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.339 -0400", hash_original_method = "B7A9F5DC521617567AEB2EDF2366DE24", hash_generated_method = "4F643D1D6AA2F1E0F28D6F55CDF2908C")
    public ViaHeader createViaHeader(
        String host,
        int port,
        String transport,
        String branch) throws ParseException, InvalidArgumentException {
        ViaHeader varB4EAC82CA7396A68D541C85D26508E83_393482633 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        Via via;
        via = new Via();
        via.setBranch(branch);
        {
            boolean var892BBD36F1835D9F17C0D62A38310742_657215835 = (host.indexOf(':') >= 0
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
        varB4EAC82CA7396A68D541C85D26508E83_393482633 = via;
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(transport.getTaint());
        addTaint(branch.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_393482633.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_393482633;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.340 -0400", hash_original_method = "EDE3AD5442B3DE671B6476C917BB6D0F", hash_generated_method = "DB1654A15E29A843C35BECFC3CC9B2D4")
    public WWWAuthenticateHeader createWWWAuthenticateHeader(String scheme) throws ParseException {
        WWWAuthenticateHeader varB4EAC82CA7396A68D541C85D26508E83_873528012 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null scheme");
        WWWAuthenticate www;
        www = new WWWAuthenticate();
        www.setScheme(scheme);
        varB4EAC82CA7396A68D541C85D26508E83_873528012 = www;
        addTaint(scheme.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_873528012.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_873528012;
        // ---------- Original Method ----------
        //if (scheme == null)
            //throw new NullPointerException("null scheme");
        //WWWAuthenticate www = new WWWAuthenticate();
        //www.setScheme(scheme);
        //return www;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.351 -0400", hash_original_method = "F34478A6D1616AB2836BA2A212AE0D49", hash_generated_method = "8A5793D86D7DAFC1B3D8682FFF176D9B")
    public WarningHeader createWarningHeader(
        String agent,
        int code,
        String comment) throws ParseException, InvalidArgumentException {
        WarningHeader varB4EAC82CA7396A68D541C85D26508E83_1566201590 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        Warning warning;
        warning = new Warning();
        warning.setAgent(agent);
        warning.setCode(code);
        warning.setText(comment);
        varB4EAC82CA7396A68D541C85D26508E83_1566201590 = warning;
        addTaint(agent.getTaint());
        addTaint(code);
        addTaint(comment.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1566201590.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1566201590;
        // ---------- Original Method ----------
        //if (agent == null)
            //throw new NullPointerException("null arg");
        //Warning warning = new Warning();
        //warning.setAgent(agent);
        //warning.setCode(code);
        //warning.setText(comment);
        //return warning;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.352 -0400", hash_original_method = "CB42C1424760C62123C05E2F8CB60B35", hash_generated_method = "311DB13106BA6886DB470DDA84DBB0A7")
    public ErrorInfoHeader createErrorInfoHeader(URI errorInfo) {
        ErrorInfoHeader varB4EAC82CA7396A68D541C85D26508E83_141053053 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        varB4EAC82CA7396A68D541C85D26508E83_141053053 = new ErrorInfo((GenericURI) errorInfo);
        addTaint(errorInfo.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_141053053.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_141053053;
        // ---------- Original Method ----------
        //if (errorInfo == null)
            //throw new NullPointerException("null arg");
        //return new ErrorInfo((GenericURI) errorInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.353 -0400", hash_original_method = "7E6122EDAE408D205AF0C9E45A024F04", hash_generated_method = "58D57C66A8A4B48E041F286DB8BB3542")
    public javax.sip.header.Header createHeader(String headerText) throws ParseException {
        javax.sip.header.Header varB4EAC82CA7396A68D541C85D26508E83_1389735652 = null; //Variable for return #1
        javax.sip.header.Header varB4EAC82CA7396A68D541C85D26508E83_816975330 = null; //Variable for return #2
        javax.sip.header.Header varB4EAC82CA7396A68D541C85D26508E83_1417955998 = null; //Variable for return #3
        javax.sip.header.Header varB4EAC82CA7396A68D541C85D26508E83_113599558 = null; //Variable for return #4
        javax.sip.header.Header varB4EAC82CA7396A68D541C85D26508E83_1729406019 = null; //Variable for return #5
        StringMsgParser smp;
        smp = new StringMsgParser();
        SIPHeader sipHeader;
        sipHeader = smp.parseSIPHeader(headerText.trim());
        {
            {
                boolean var376AECF828F744DA20E1ADDFF5E39535_889679400 = (((SIPHeaderList) sipHeader).size() > 1);
                {
                    if (DroidSafeAndroidRuntime.control) throw new ParseException(
                    "Only singleton allowed " + headerText,
                    0);
                } //End block
                {
                    boolean varB2077481A39B1082F8C4F3463BCDED80_1391443402 = (((SIPHeaderList) sipHeader).size() == 0);
                    {
                        try 
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1389735652 = (Header) ((SIPHeaderList) sipHeader)
                        .getMyClass()
                        .newInstance();
                        } //End block
                        catch (InstantiationException ex)
                        {
                            ex.printStackTrace();
                            varB4EAC82CA7396A68D541C85D26508E83_816975330 = null;
                        } //End block
                        catch (IllegalAccessException ex)
                        {
                            ex.printStackTrace();
                            varB4EAC82CA7396A68D541C85D26508E83_1417955998 = null;
                        } //End block
                    } //End block
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_113599558 = (Header) ((SIPHeaderList) sipHeader).getFirst();
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1729406019 = (Header) sipHeader;
        } //End block
        addTaint(headerText.getTaint());
        javax.sip.header.Header varA7E53CE21691AB073D9660D615818899_32691253; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_32691253 = varB4EAC82CA7396A68D541C85D26508E83_1389735652;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_32691253 = varB4EAC82CA7396A68D541C85D26508E83_816975330;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_32691253 = varB4EAC82CA7396A68D541C85D26508E83_1417955998;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_32691253 = varB4EAC82CA7396A68D541C85D26508E83_113599558;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_32691253 = varB4EAC82CA7396A68D541C85D26508E83_1729406019;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_32691253.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_32691253;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.353 -0400", hash_original_method = "BE8A77015DA0080195A899A1BFDA2B08", hash_generated_method = "B5D272319761BD1CCB6F110816ABBB94")
    public javax.sip.header.Header createHeader(
        String headerName,
        String headerValue) throws java.text.ParseException {
        javax.sip.header.Header varB4EAC82CA7396A68D541C85D26508E83_409884154 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("header name is null");
        String hdrText;
        hdrText = new StringBuffer()
                .append(headerName)
                .append(":")
                .append(headerValue)
                .toString();
        varB4EAC82CA7396A68D541C85D26508E83_409884154 = createHeader(hdrText);
        addTaint(headerName.getTaint());
        addTaint(headerValue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_409884154.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_409884154;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.354 -0400", hash_original_method = "FDCDF9463F1CDDAF0BCBB63B8B4D05F5", hash_generated_method = "63908F072A1242D0866797ED7BF8BA78")
    public java.util.List createHeaders(String headers) throws java.text.ParseException {
        java.util.List varB4EAC82CA7396A68D541C85D26508E83_435547199 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg!");
        StringMsgParser smp;
        smp = new StringMsgParser();
        SIPHeader shdr;
        shdr = smp.parseSIPHeader(headers);
        varB4EAC82CA7396A68D541C85D26508E83_435547199 = (SIPHeaderList) shdr;
        if (DroidSafeAndroidRuntime.control) throw new ParseException(
                "List of headers of this type is not allowed in a message",
                0);
        addTaint(headers.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_435547199.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_435547199;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.355 -0400", hash_original_method = "5541F8A2ED86060178CAD1F0D5BA2507", hash_generated_method = "3FD8DAE49F0187561F8ED480EE857C4C")
    public ReferToHeader createReferToHeader(Address address) {
        ReferToHeader varB4EAC82CA7396A68D541C85D26508E83_1639698721 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address!");
        ReferTo referTo;
        referTo = new ReferTo();
        referTo.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_1639698721 = referTo;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1639698721.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1639698721;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address!");
        //ReferTo referTo = new ReferTo();
        //referTo.setAddress(address);
        //return referTo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.363 -0400", hash_original_method = "A51D0E58D36C2041DD351AE4FDD73BCF", hash_generated_method = "F0E3937E99CF00D5F486522C37E5AA45")
    public ReferredByHeader createReferredByHeader(Address address) {
        ReferredByHeader varB4EAC82CA7396A68D541C85D26508E83_908495445 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address!");
        ReferredBy referredBy;
        referredBy = new ReferredBy();
        referredBy.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_908495445 = referredBy;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_908495445.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_908495445;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address!");
        //ReferredBy referredBy = new ReferredBy();
        //referredBy.setAddress(address);
        //return referredBy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.366 -0400", hash_original_method = "E3BB57144A133C8AFDA0829EAE12FAAB", hash_generated_method = "728BDDEE2C7EF90887B35931CC2FA077")
    public ReplacesHeader createReplacesHeader(String callId, String toTag,
                String fromTag) throws ParseException {
        ReplacesHeader varB4EAC82CA7396A68D541C85D26508E83_1547832916 = null; //Variable for return #1
        Replaces replaces;
        replaces = new Replaces();
        replaces.setCallId(callId);
        replaces.setFromTag(fromTag);
        replaces.setToTag(toTag);
        varB4EAC82CA7396A68D541C85D26508E83_1547832916 = replaces;
        addTaint(callId.getTaint());
        addTaint(toTag.getTaint());
        addTaint(fromTag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1547832916.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1547832916;
        // ---------- Original Method ----------
        //Replaces replaces = new Replaces();
        //replaces.setCallId(callId);
        //replaces.setFromTag(fromTag);
        //replaces.setToTag(toTag);
        //return replaces;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.366 -0400", hash_original_method = "C42E665E40D735B4BFD234363CD8C238", hash_generated_method = "0B6451F68DE4172F63EDC2EBD4913C4C")
    public JoinHeader createJoinHeader(String callId, String toTag,
                String fromTag) throws ParseException {
        JoinHeader varB4EAC82CA7396A68D541C85D26508E83_1200269306 = null; //Variable for return #1
        Join join;
        join = new Join();
        join.setCallId(callId);
        join.setFromTag(fromTag);
        join.setToTag(toTag);
        varB4EAC82CA7396A68D541C85D26508E83_1200269306 = join;
        addTaint(callId.getTaint());
        addTaint(toTag.getTaint());
        addTaint(fromTag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1200269306.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1200269306;
        // ---------- Original Method ----------
        //Join join = new Join();
        //join.setCallId(callId);
        //join.setFromTag(fromTag);
        //join.setToTag(toTag);
        //return join;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.367 -0400", hash_original_method = "95F88F9209912EE6FCAFCB830227A87B", hash_generated_method = "75F835A70B238599448923119F25CB92")
    public SIPETagHeader createSIPETagHeader(String etag) throws ParseException {
        SIPETagHeader varB4EAC82CA7396A68D541C85D26508E83_2124489810 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2124489810 = new SIPETag(etag);
        addTaint(etag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2124489810.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2124489810;
        // ---------- Original Method ----------
        //return new SIPETag(etag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.368 -0400", hash_original_method = "9EE2B60A802A938BDC15DDB307A8B1D7", hash_generated_method = "45B7F14CA5623145098117E828B9C54D")
    public SIPIfMatchHeader createSIPIfMatchHeader(String etag) throws ParseException {
        SIPIfMatchHeader varB4EAC82CA7396A68D541C85D26508E83_557085720 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_557085720 = new SIPIfMatch(etag);
        addTaint(etag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_557085720.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_557085720;
        // ---------- Original Method ----------
        //return new SIPIfMatch(etag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.372 -0400", hash_original_method = "5900AA55EC6D83D47F45CED3D37DDEC7", hash_generated_method = "B708549076D2E8EC878CBF5208C8EC5D")
    public PAccessNetworkInfoHeader createPAccessNetworkInfoHeader() {
        PAccessNetworkInfoHeader varB4EAC82CA7396A68D541C85D26508E83_2092400967 = null; //Variable for return #1
        PAccessNetworkInfo accessNetworkInfo;
        accessNetworkInfo = new PAccessNetworkInfo();
        varB4EAC82CA7396A68D541C85D26508E83_2092400967 = accessNetworkInfo;
        varB4EAC82CA7396A68D541C85D26508E83_2092400967.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2092400967;
        // ---------- Original Method ----------
        //PAccessNetworkInfo accessNetworkInfo = new PAccessNetworkInfo();
        //return accessNetworkInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.376 -0400", hash_original_method = "7A9453157C5A8C4FD99B8F34DC853877", hash_generated_method = "E6A382FA53D634F8F05E0FB615BAC847")
    public PAssertedIdentityHeader createPAssertedIdentityHeader(Address address) throws NullPointerException, ParseException {
        PAssertedIdentityHeader varB4EAC82CA7396A68D541C85D26508E83_417160492 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address!");
        PAssertedIdentity assertedIdentity;
        assertedIdentity = new PAssertedIdentity();
        assertedIdentity.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_417160492 = assertedIdentity;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_417160492.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_417160492;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address!");
        //PAssertedIdentity assertedIdentity = new PAssertedIdentity();
        //assertedIdentity.setAddress(address);
        //return assertedIdentity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.376 -0400", hash_original_method = "4BD897B5832A55E4A60E9B49C4611708", hash_generated_method = "5A495817F4474F3F34BC1DDEAC674B88")
    public PAssociatedURIHeader createPAssociatedURIHeader(Address assocURI) {
        PAssociatedURIHeader varB4EAC82CA7396A68D541C85D26508E83_92416049 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null associatedURI!");
        PAssociatedURI associatedURI;
        associatedURI = new PAssociatedURI();
        associatedURI.setAddress(assocURI);
        varB4EAC82CA7396A68D541C85D26508E83_92416049 = associatedURI;
        addTaint(assocURI.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_92416049.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_92416049;
        // ---------- Original Method ----------
        //if (assocURI == null)
        //throw new NullPointerException("null associatedURI!");
        //PAssociatedURI associatedURI = new PAssociatedURI();
        //associatedURI.setAddress(assocURI);
        //return associatedURI;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.380 -0400", hash_original_method = "FD713420BE4BC11FE9D9AB43BBBEAD30", hash_generated_method = "9FEB7684AAAFCE96099EA8C05C21373E")
    public PCalledPartyIDHeader createPCalledPartyIDHeader(Address address) {
        PCalledPartyIDHeader varB4EAC82CA7396A68D541C85D26508E83_113077450 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address!");
        PCalledPartyID calledPartyID;
        calledPartyID = new PCalledPartyID();
        calledPartyID.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_113077450 = calledPartyID;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_113077450.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_113077450;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address!");
        //PCalledPartyID calledPartyID = new PCalledPartyID();
        //calledPartyID.setAddress(address);
        //return calledPartyID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.380 -0400", hash_original_method = "F3DC851C781199B1B5D5ECAC93663797", hash_generated_method = "F601284927032A20447A31DC226DCC74")
    public PChargingFunctionAddressesHeader createPChargingFunctionAddressesHeader() {
        PChargingFunctionAddressesHeader varB4EAC82CA7396A68D541C85D26508E83_1581021281 = null; //Variable for return #1
        PChargingFunctionAddresses cfa;
        cfa = new PChargingFunctionAddresses();
        varB4EAC82CA7396A68D541C85D26508E83_1581021281 = cfa;
        varB4EAC82CA7396A68D541C85D26508E83_1581021281.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1581021281;
        // ---------- Original Method ----------
        //PChargingFunctionAddresses cfa = new PChargingFunctionAddresses();
        //return cfa;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.381 -0400", hash_original_method = "E82D256C40CCFC0E4431BA44734EBBF3", hash_generated_method = "63A0A065B4BE44695CFEAF6833D26C2D")
    public PChargingVectorHeader createChargingVectorHeader(String icid) throws ParseException {
        PChargingVectorHeader varB4EAC82CA7396A68D541C85D26508E83_529852439 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null icid arg!");
        PChargingVector chargingVector;
        chargingVector = new PChargingVector();
        chargingVector.setICID(icid);
        varB4EAC82CA7396A68D541C85D26508E83_529852439 = chargingVector;
        addTaint(icid.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_529852439.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_529852439;
        // ---------- Original Method ----------
        //if (icid == null)
        //throw new NullPointerException("null icid arg!");
        //PChargingVector chargingVector = new PChargingVector();
        //chargingVector.setICID(icid);
        //return chargingVector;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.382 -0400", hash_original_method = "FB93C1554D708A44568E0208A3D181E0", hash_generated_method = "A94BA82BEAFB186D8945AB9BC1D5ED05")
    public PMediaAuthorizationHeader createPMediaAuthorizationHeader(String token) throws InvalidArgumentException, ParseException {
        PMediaAuthorizationHeader varB4EAC82CA7396A68D541C85D26508E83_601472189 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("The Media-Authorization-Token parameter is null or empty");
        PMediaAuthorization mediaAuthorization;
        mediaAuthorization = new PMediaAuthorization();
        mediaAuthorization.setMediaAuthorizationToken(token);
        varB4EAC82CA7396A68D541C85D26508E83_601472189 = mediaAuthorization;
        addTaint(token.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_601472189.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_601472189;
        // ---------- Original Method ----------
        //if (token == null || token == "")
            //throw new InvalidArgumentException("The Media-Authorization-Token parameter is null or empty");
        //PMediaAuthorization mediaAuthorization = new PMediaAuthorization();
        //mediaAuthorization.setMediaAuthorizationToken(token);
        //return mediaAuthorization;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.382 -0400", hash_original_method = "3BA03116BEA38D71B8C38B4BA62E5B71", hash_generated_method = "92E2D241BBB32C71A85CE7223779463E")
    public PPreferredIdentityHeader createPPreferredIdentityHeader(Address address) {
        PPreferredIdentityHeader varB4EAC82CA7396A68D541C85D26508E83_1915287964 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address!");
        PPreferredIdentity preferredIdentity;
        preferredIdentity = new PPreferredIdentity();
        preferredIdentity.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_1915287964 = preferredIdentity;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1915287964.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1915287964;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address!");
        //PPreferredIdentity preferredIdentity = new PPreferredIdentity();
        //preferredIdentity.setAddress(address);
        //return preferredIdentity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.383 -0400", hash_original_method = "B32CA202259A9B847AD818F044EE39DA", hash_generated_method = "D3DF883A2E1FFAF2BEE0D9363FE85FB1")
    public PVisitedNetworkIDHeader createPVisitedNetworkIDHeader() {
        PVisitedNetworkIDHeader varB4EAC82CA7396A68D541C85D26508E83_174676840 = null; //Variable for return #1
        PVisitedNetworkID visitedNetworkID;
        visitedNetworkID = new PVisitedNetworkID();
        varB4EAC82CA7396A68D541C85D26508E83_174676840 = visitedNetworkID;
        varB4EAC82CA7396A68D541C85D26508E83_174676840.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_174676840;
        // ---------- Original Method ----------
        //PVisitedNetworkID visitedNetworkID = new PVisitedNetworkID();
        //return visitedNetworkID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.383 -0400", hash_original_method = "537B18CC29F2C70486994281CB29500B", hash_generated_method = "30CA1D2E2BF9BC88BCF672EF59920DD0")
    public PathHeader createPathHeader(Address address) {
        PathHeader varB4EAC82CA7396A68D541C85D26508E83_1972584581 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address!");
        Path path;
        path = new Path();
        path.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_1972584581 = path;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1972584581.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1972584581;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address!");
        //Path path = new Path();
        //path.setAddress(address);
        //return path;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.387 -0400", hash_original_method = "85C1BF55B1F968333EFFBCF4DBC75BE6", hash_generated_method = "F3CEF64BFB22CF3E1C07CD2A412E5D17")
    public PrivacyHeader createPrivacyHeader(String privacyType) {
        PrivacyHeader varB4EAC82CA7396A68D541C85D26508E83_1928994133 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null privacyType arg");
        Privacy privacy;
        privacy = new Privacy(privacyType);
        varB4EAC82CA7396A68D541C85D26508E83_1928994133 = privacy;
        addTaint(privacyType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1928994133.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1928994133;
        // ---------- Original Method ----------
        //if (privacyType == null)
            //throw new NullPointerException("null privacyType arg");
        //Privacy privacy = new Privacy(privacyType);
        //return privacy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.387 -0400", hash_original_method = "A7CA2EB6DD40139D85B6778D2C783F9F", hash_generated_method = "BBF06792E6F4CBAF4A4B478006431C00")
    public ServiceRouteHeader createServiceRouteHeader(Address address) {
        ServiceRouteHeader varB4EAC82CA7396A68D541C85D26508E83_1405901519 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address!");
        ServiceRoute serviceRoute;
        serviceRoute = new ServiceRoute();
        serviceRoute.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_1405901519 = serviceRoute;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1405901519.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1405901519;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address!");
        //ServiceRoute serviceRoute = new ServiceRoute();
        //serviceRoute.setAddress(address);
        //return serviceRoute;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.391 -0400", hash_original_method = "7A3E4AE36777C6F2CF79A6B3882A3053", hash_generated_method = "7475E8E71BB9720E9E84E2828D34D2C6")
    public SecurityServerHeader createSecurityServerHeader() {
        SecurityServerHeader varB4EAC82CA7396A68D541C85D26508E83_352466251 = null; //Variable for return #1
        SecurityServer secServer;
        secServer = new SecurityServer();
        varB4EAC82CA7396A68D541C85D26508E83_352466251 = secServer;
        varB4EAC82CA7396A68D541C85D26508E83_352466251.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_352466251;
        // ---------- Original Method ----------
        //SecurityServer secServer = new SecurityServer();
        //return secServer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.399 -0400", hash_original_method = "2361364E4BB205FAC2A8F8549D9431F6", hash_generated_method = "23E1E7E0B25456D041DF739DD841D540")
    public SecurityClientHeader createSecurityClientHeader() {
        SecurityClientHeader varB4EAC82CA7396A68D541C85D26508E83_347727514 = null; //Variable for return #1
        SecurityClient secClient;
        secClient = new SecurityClient();
        varB4EAC82CA7396A68D541C85D26508E83_347727514 = secClient;
        varB4EAC82CA7396A68D541C85D26508E83_347727514.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_347727514;
        // ---------- Original Method ----------
        //SecurityClient secClient = new SecurityClient();
        //return secClient;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.399 -0400", hash_original_method = "1063C2554F38236C917DADCB6A55ADB8", hash_generated_method = "61A515DF7A1FA041733DB3A439B9C73A")
    public SecurityVerifyHeader createSecurityVerifyHeader() {
        SecurityVerifyHeader varB4EAC82CA7396A68D541C85D26508E83_1025992399 = null; //Variable for return #1
        SecurityVerify secVerify;
        secVerify = new SecurityVerify();
        varB4EAC82CA7396A68D541C85D26508E83_1025992399 = secVerify;
        varB4EAC82CA7396A68D541C85D26508E83_1025992399.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1025992399;
        // ---------- Original Method ----------
        //SecurityVerify secVerify = new SecurityVerify();
        //return secVerify;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.400 -0400", hash_original_method = "2DDC01C5DAA0917C6B8BE6B8A00F5568", hash_generated_method = "BA36662CDD68093E30E0EC1D0F6AC71B")
    public PUserDatabaseHeader createPUserDatabaseHeader(String databaseName) {
        PUserDatabaseHeader varB4EAC82CA7396A68D541C85D26508E83_1275840825 = null; //Variable for return #1
        {
            boolean varAC311902DF4878F599DD65CB8A1544C9_1407998189 = ((databaseName ==null)||(databaseName.equals(" ")));
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Database name is null");
        } //End collapsed parenthetic
        PUserDatabase pUserDatabase;
        pUserDatabase = new PUserDatabase();
        pUserDatabase.setDatabaseName(databaseName);
        varB4EAC82CA7396A68D541C85D26508E83_1275840825 = pUserDatabase;
        addTaint(databaseName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1275840825.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1275840825;
        // ---------- Original Method ----------
        //if((databaseName ==null)||(databaseName.equals(" ")))
            //throw new NullPointerException("Database name is null");
        //PUserDatabase pUserDatabase = new PUserDatabase();
        //pUserDatabase.setDatabaseName(databaseName);
        //return pUserDatabase;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.401 -0400", hash_original_method = "6A0691F102D20D70FD0A6921A61CA118", hash_generated_method = "73C8549DF997DCE5BAA0B9D4D92F5AED")
    public PProfileKeyHeader createPProfileKeyHeader(Address address) {
        PProfileKeyHeader varB4EAC82CA7396A68D541C85D26508E83_1949157641 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Address is null");
        PProfileKey pProfileKey;
        pProfileKey = new PProfileKey();
        pProfileKey.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_1949157641 = pProfileKey;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1949157641.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1949157641;
        // ---------- Original Method ----------
        //if (address ==null)
            //throw new NullPointerException("Address is null");
        //PProfileKey pProfileKey = new PProfileKey();
        //pProfileKey.setAddress(address);
        //return pProfileKey;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.404 -0400", hash_original_method = "38B7C1667A9FD579C07BB14E255FF56A", hash_generated_method = "47ACF012BB39DA6B68CE79CD042E7310")
    public PServedUserHeader createPServedUserHeader(Address address) {
        PServedUserHeader varB4EAC82CA7396A68D541C85D26508E83_289066278 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Address is null");
        PServedUser psu;
        psu = new PServedUser();
        psu.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_289066278 = psu;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_289066278.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_289066278;
        // ---------- Original Method ----------
        //if(address==null)
            //throw new NullPointerException("Address is null");
        //PServedUser psu = new PServedUser();
        //psu.setAddress(address);
        //return psu;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.408 -0400", hash_original_method = "C0CFD4DCC2CCE8A2BE967D3A2132C68A", hash_generated_method = "8869B28776C2FE26B2946BC4E7E8AC1D")
    public PPreferredServiceHeader createPPreferredServiceHeader() {
        PPreferredServiceHeader varB4EAC82CA7396A68D541C85D26508E83_1858917769 = null; //Variable for return #1
        PPreferredService pps;
        pps = new PPreferredService();
        varB4EAC82CA7396A68D541C85D26508E83_1858917769 = pps;
        varB4EAC82CA7396A68D541C85D26508E83_1858917769.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1858917769;
        // ---------- Original Method ----------
        //PPreferredService pps = new PPreferredService();
        //return pps;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.410 -0400", hash_original_method = "48E529894AF92157CD42EE8DFB6E18AB", hash_generated_method = "B93A30A1D1037F348D9CCA5F1D2C381F")
    public PAssertedServiceHeader createPAssertedServiceHeader() {
        PAssertedServiceHeader varB4EAC82CA7396A68D541C85D26508E83_185200929 = null; //Variable for return #1
        PAssertedService pas;
        pas = new PAssertedService();
        varB4EAC82CA7396A68D541C85D26508E83_185200929 = pas;
        varB4EAC82CA7396A68D541C85D26508E83_185200929.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_185200929;
        // ---------- Original Method ----------
        //PAssertedService pas = new PAssertedService();
        //return pas;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.412 -0400", hash_original_method = "6D472F26B8815D9A75157924D7DB3DB8", hash_generated_method = "E81616C4949A20FCEA355B006F92BD8A")
    public SessionExpiresHeader createSessionExpiresHeader(int expires) throws InvalidArgumentException {
        SessionExpiresHeader varB4EAC82CA7396A68D541C85D26508E83_1371739745 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad value " + expires);
        SessionExpires s;
        s = new SessionExpires();
        s.setExpires(expires);
        varB4EAC82CA7396A68D541C85D26508E83_1371739745 = s;
        addTaint(expires);
        varB4EAC82CA7396A68D541C85D26508E83_1371739745.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1371739745;
        // ---------- Original Method ----------
        //if (expires < 0)
            //throw new InvalidArgumentException("bad value " + expires);
        //SessionExpires s = new SessionExpires();
        //s.setExpires(expires);
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.414 -0400", hash_original_method = "F07701895F7EA99F66D330A17A2FD28D", hash_generated_method = "62BA3E2BE4113D9D305B8A38D95C4B25")
    public SipRequestLine createRequestLine(String requestLine) throws ParseException {
        SipRequestLine varB4EAC82CA7396A68D541C85D26508E83_377682852 = null; //Variable for return #1
        RequestLineParser requestLineParser;
        requestLineParser = new RequestLineParser(requestLine);
        varB4EAC82CA7396A68D541C85D26508E83_377682852 = (SipRequestLine) requestLineParser.parse();
        addTaint(requestLine.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_377682852.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_377682852;
        // ---------- Original Method ----------
        //RequestLineParser requestLineParser = new RequestLineParser(requestLine);
        //return (SipRequestLine) requestLineParser.parse();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.431 -0400", hash_original_method = "94ED81BC52F6E3EE358EE57713F40357", hash_generated_method = "05F4B8AFFC6C9FF116A13F53D6F67C8E")
    public SipStatusLine createStatusLine(String statusLine) throws ParseException {
        SipStatusLine varB4EAC82CA7396A68D541C85D26508E83_1268030881 = null; //Variable for return #1
        StatusLineParser statusLineParser;
        statusLineParser = new StatusLineParser(statusLine);
        varB4EAC82CA7396A68D541C85D26508E83_1268030881 = (SipStatusLine) statusLineParser.parse();
        addTaint(statusLine.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1268030881.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1268030881;
        // ---------- Original Method ----------
        //StatusLineParser statusLineParser = new StatusLineParser(statusLine);
        //return (SipStatusLine) statusLineParser.parse();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.432 -0400", hash_original_method = "B06A6A8CC80D9698711113EFD1E58499", hash_generated_method = "722BA71A34787966257A1AE12013C6E1")
    public ReferencesHeader createReferencesHeader(String callId, String rel) throws ParseException {
        ReferencesHeader varB4EAC82CA7396A68D541C85D26508E83_231010304 = null; //Variable for return #1
        ReferencesHeader retval;
        retval = new References();
        retval.setCallId(callId);
        retval.setRel(rel);
        varB4EAC82CA7396A68D541C85D26508E83_231010304 = retval;
        addTaint(callId.getTaint());
        addTaint(rel.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_231010304.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_231010304;
        // ---------- Original Method ----------
        //ReferencesHeader retval = new References();
        //retval.setCallId(callId);
        //retval.setRel(rel);
        //return retval;
    }

    
}

