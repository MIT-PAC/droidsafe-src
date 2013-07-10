package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.625 -0400", hash_original_field = "6FA63D73209D74D0D54BC416A32DB10D", hash_generated_field = "0D2878F1D6B0CD805C869443DA7FE75E")

    private boolean stripAddressScopeZones = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.626 -0400", hash_original_method = "EA4ABB94B4CFEF029E31D8F450F44C66", hash_generated_method = "4DBE2EDCEE71001244079D3C05C060E8")
    public  HeaderFactoryImpl() {
        stripAddressScopeZones
            = Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.626 -0400", hash_original_method = "9BEACA878DCF694953AD8141227DB60F", hash_generated_method = "EC22EB8666E3DDC0B2C501EFE162CB63")
    public void setPrettyEncoding(boolean flag) {
        SIPHeaderList.setPrettyEncode(flag);
        addTaint(flag);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.627 -0400", hash_original_method = "58113BBBA3D76308CFB19C46D0FF7A27", hash_generated_method = "6F3F700FF6C5C29AB0CFA2DDAFD1E4AD")
    public AcceptEncodingHeader createAcceptEncodingHeader(String encoding) throws ParseException {
        AcceptEncodingHeader varB4EAC82CA7396A68D541C85D26508E83_658051250 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("the encoding parameter is null");
        AcceptEncoding acceptEncoding = new AcceptEncoding();
        acceptEncoding.setEncoding(encoding);
        varB4EAC82CA7396A68D541C85D26508E83_658051250 = acceptEncoding;
        addTaint(encoding.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_658051250.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_658051250;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.627 -0400", hash_original_method = "3FEA70547EDCF31E1AA086D3362AC6CE", hash_generated_method = "811A9C28DB01AF9035456BFAEC1CE3F7")
    public AcceptHeader createAcceptHeader(
        String contentType,
        String contentSubType) throws ParseException {
        AcceptHeader varB4EAC82CA7396A68D541C85D26508E83_1215557984 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("contentType or subtype is null ");
        Accept accept = new Accept();
        accept.setContentType(contentType);
        accept.setContentSubType(contentSubType);
        varB4EAC82CA7396A68D541C85D26508E83_1215557984 = accept;
        addTaint(contentType.getTaint());
        addTaint(contentSubType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1215557984.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1215557984;
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.628 -0400", hash_original_method = "5AF5E9D92982780781CC81035C3C1529", hash_generated_method = "116E271E1FC255313E1E364127680CB9")
    public AcceptLanguageHeader createAcceptLanguageHeader(Locale language) {
        AcceptLanguageHeader varB4EAC82CA7396A68D541C85D26508E83_1120685499 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        AcceptLanguage acceptLanguage = new AcceptLanguage();
        acceptLanguage.setAcceptLanguage(language);
        varB4EAC82CA7396A68D541C85D26508E83_1120685499 = acceptLanguage;
        addTaint(language.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1120685499.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1120685499;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.629 -0400", hash_original_method = "3E0D5311E2AF98CBAC12E04C1647AAA5", hash_generated_method = "4108D91BD0BEEED0CA70D82D95C86DBA")
    public AlertInfoHeader createAlertInfoHeader(URI alertInfo) {
        AlertInfoHeader varB4EAC82CA7396A68D541C85D26508E83_876797318 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg alertInfo");
        AlertInfo a = new AlertInfo();
        a.setAlertInfo(alertInfo);
        varB4EAC82CA7396A68D541C85D26508E83_876797318 = a;
        addTaint(alertInfo.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_876797318.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_876797318;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.630 -0400", hash_original_method = "7A8DE3D3022A3669E75EC61B4D0B5F19", hash_generated_method = "DE5B8C51A1C1190114CFE3FDAA60481C")
    public AllowEventsHeader createAllowEventsHeader(String eventType) throws ParseException {
        AllowEventsHeader varB4EAC82CA7396A68D541C85D26508E83_619561962 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg eventType");
        AllowEvents allowEvents = new AllowEvents();
        allowEvents.setEventType(eventType);
        varB4EAC82CA7396A68D541C85D26508E83_619561962 = allowEvents;
        addTaint(eventType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_619561962.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_619561962;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.631 -0400", hash_original_method = "C562ECE8E2158A54C27A4525D88FEA63", hash_generated_method = "28380C4E7AE5A18520DA44B74B826DEE")
    public AllowHeader createAllowHeader(String method) throws ParseException {
        AllowHeader varB4EAC82CA7396A68D541C85D26508E83_435875135 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg method");
        Allow allow = new Allow();
        allow.setMethod(method);
        varB4EAC82CA7396A68D541C85D26508E83_435875135 = allow;
        addTaint(method.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_435875135.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_435875135;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.633 -0400", hash_original_method = "E72D81A306A857A102E9D4437AB18CA6", hash_generated_method = "6DEF5A056562DF238F23A7ADF76C7437")
    public AuthenticationInfoHeader createAuthenticationInfoHeader(String response) throws ParseException {
        AuthenticationInfoHeader varB4EAC82CA7396A68D541C85D26508E83_720057245 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg response");
        AuthenticationInfo auth = new AuthenticationInfo();
        auth.setResponse(response);
        varB4EAC82CA7396A68D541C85D26508E83_720057245 = auth;
        addTaint(response.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_720057245.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_720057245;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.634 -0400", hash_original_method = "F250EC80C8CD1CBE5FF237A98CBD8CD0", hash_generated_method = "43816CDB3032FB1CF13E3EB5899320CB")
    public AuthorizationHeader createAuthorizationHeader(String scheme) throws ParseException {
        AuthorizationHeader varB4EAC82CA7396A68D541C85D26508E83_654872497 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg scheme ");
        Authorization auth = new Authorization();
        auth.setScheme(scheme);
        varB4EAC82CA7396A68D541C85D26508E83_654872497 = auth;
        addTaint(scheme.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_654872497.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_654872497;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.634 -0400", hash_original_method = "9707416B5040BCEA07917ADCBF33DA70", hash_generated_method = "7B97D8F596CAB36BBCD0BD399DBA10B1")
    public CSeqHeader createCSeqHeader( long sequenceNumber, String method) throws ParseException, InvalidArgumentException {
        CSeqHeader varB4EAC82CA7396A68D541C85D26508E83_1738974659 = null; 
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad arg " + sequenceNumber);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg method");
        CSeq cseq = new CSeq();
        cseq.setMethod(method);
        cseq.setSeqNumber(sequenceNumber);
        varB4EAC82CA7396A68D541C85D26508E83_1738974659 = cseq;
        addTaint(sequenceNumber);
        addTaint(method.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1738974659.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1738974659;
        
        
            
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.635 -0400", hash_original_method = "332D5DD16F528ACCDED76BFE26F4F243", hash_generated_method = "378BF5F43EAC10ED86EE43BF1CE8C4AF")
    public CSeqHeader createCSeqHeader( int sequenceNumber, String method) throws ParseException, InvalidArgumentException {
        CSeqHeader varB4EAC82CA7396A68D541C85D26508E83_108799294 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_108799294 = this.createCSeqHeader( (long) sequenceNumber, method );
        addTaint(sequenceNumber);
        addTaint(method.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_108799294.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_108799294;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.636 -0400", hash_original_method = "0CB560808F252622C176039BC6E86FF7", hash_generated_method = "26EB56395F21B89C3F4B9233213CB17F")
    public CallIdHeader createCallIdHeader(String callId) throws ParseException {
        CallIdHeader varB4EAC82CA7396A68D541C85D26508E83_1212618735 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg callId");
        CallID c = new CallID();
        c.setCallId(callId);
        varB4EAC82CA7396A68D541C85D26508E83_1212618735 = c;
        addTaint(callId.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1212618735.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1212618735;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.637 -0400", hash_original_method = "8867B6CA9EB8DB8DAA3F991D7B0AD5D9", hash_generated_method = "81B457C05F58DF4180518A80C981BE22")
    public CallInfoHeader createCallInfoHeader(URI callInfo) {
        CallInfoHeader varB4EAC82CA7396A68D541C85D26508E83_1197165409 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg callInfo");
        CallInfo c = new CallInfo();
        c.setInfo(callInfo);
        varB4EAC82CA7396A68D541C85D26508E83_1197165409 = c;
        addTaint(callInfo.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1197165409.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1197165409;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.637 -0400", hash_original_method = "45EF0D9994A51A34EA10DF4A185E8F21", hash_generated_method = "B755B7B07FF37B424EB9E539A3B9D326")
    public ContactHeader createContactHeader(Address address) {
        ContactHeader varB4EAC82CA7396A68D541C85D26508E83_1019685078 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg address");
        Contact contact = new Contact();
        contact.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_1019685078 = contact;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1019685078.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1019685078;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.638 -0400", hash_original_method = "5873C88FB18B86DA11D334099F5AE064", hash_generated_method = "652983D761257E0466BB88A2DD5E98EA")
    public ContactHeader createContactHeader() {
        ContactHeader varB4EAC82CA7396A68D541C85D26508E83_929284755 = null; 
        Contact contact = new Contact();
        contact.setWildCardFlag(true);
        contact.setExpires(0);
        varB4EAC82CA7396A68D541C85D26508E83_929284755 = contact;
        varB4EAC82CA7396A68D541C85D26508E83_929284755.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_929284755;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.639 -0400", hash_original_method = "CC352C2425871DC27A0C55CF39D4ABAB", hash_generated_method = "30DCB317320486DA693FD314EF600433")
    public ContentDispositionHeader createContentDispositionHeader(String contentDisposition) throws ParseException {
        ContentDispositionHeader varB4EAC82CA7396A68D541C85D26508E83_1469740684 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg contentDisposition");
        ContentDisposition c = new ContentDisposition();
        c.setDispositionType(contentDisposition);
        varB4EAC82CA7396A68D541C85D26508E83_1469740684 = c;
        addTaint(contentDisposition.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1469740684.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1469740684;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.640 -0400", hash_original_method = "090104ADCCDA5F259494E038435257D1", hash_generated_method = "66095F895D47C3E590BC8CC70D16889D")
    public ContentEncodingHeader createContentEncodingHeader(String encoding) throws ParseException {
        ContentEncodingHeader varB4EAC82CA7396A68D541C85D26508E83_968322385 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null encoding");
        ContentEncoding c = new ContentEncoding();
        c.setEncoding(encoding);
        varB4EAC82CA7396A68D541C85D26508E83_968322385 = c;
        addTaint(encoding.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_968322385.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_968322385;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.641 -0400", hash_original_method = "CD027E2457CF527330FF9F4C0A972B91", hash_generated_method = "78E3790B4E9C81489CDCF189803B2E13")
    public ContentLanguageHeader createContentLanguageHeader(Locale contentLanguage) {
        ContentLanguageHeader varB4EAC82CA7396A68D541C85D26508E83_1592039215 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg contentLanguage");
        ContentLanguage c = new ContentLanguage();
        c.setContentLanguage(contentLanguage);
        varB4EAC82CA7396A68D541C85D26508E83_1592039215 = c;
        addTaint(contentLanguage.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1592039215.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1592039215;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.642 -0400", hash_original_method = "DA3B5EC62F3E30804B07AD592D303E3E", hash_generated_method = "CA112ECC84C44421CE459B7E2CDA8F90")
    public ContentLengthHeader createContentLengthHeader(int contentLength) throws InvalidArgumentException {
        ContentLengthHeader varB4EAC82CA7396A68D541C85D26508E83_226367604 = null; 
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad contentLength");
        ContentLength c = new ContentLength();
        c.setContentLength(contentLength);
        varB4EAC82CA7396A68D541C85D26508E83_226367604 = c;
        addTaint(contentLength);
        varB4EAC82CA7396A68D541C85D26508E83_226367604.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_226367604;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.643 -0400", hash_original_method = "BF42B4FF2E7F96D2FA4773C6E514B79D", hash_generated_method = "DB801DD45CA4BC2374A9344F71458981")
    public ContentTypeHeader createContentTypeHeader(
        String contentType,
        String contentSubType) throws ParseException {
        ContentTypeHeader varB4EAC82CA7396A68D541C85D26508E83_780686260 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null contentType or subType");
        ContentType c = new ContentType();
        c.setContentType(contentType);
        c.setContentSubType(contentSubType);
        varB4EAC82CA7396A68D541C85D26508E83_780686260 = c;
        addTaint(contentType.getTaint());
        addTaint(contentSubType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_780686260.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_780686260;
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.644 -0400", hash_original_method = "F3D0948AB2AB5DCB4D46B0F9C4754A1D", hash_generated_method = "D52290CBEC1C9CE8F7D5ED51828B4C08")
    public DateHeader createDateHeader(Calendar date) {
        DateHeader varB4EAC82CA7396A68D541C85D26508E83_164834426 = null; 
        SIPDateHeader d = new SIPDateHeader();
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null date");
        d.setDate(date);
        varB4EAC82CA7396A68D541C85D26508E83_164834426 = d;
        addTaint(date.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_164834426.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_164834426;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.645 -0400", hash_original_method = "7FD58797EECF83FE34BEE1F3B093BC46", hash_generated_method = "E863CF6B6FEDE1700A8CF2086B1C57D8")
    public EventHeader createEventHeader(String eventType) throws ParseException {
        EventHeader varB4EAC82CA7396A68D541C85D26508E83_1897724279 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null eventType");
        Event event = new Event();
        event.setEventType(eventType);
        varB4EAC82CA7396A68D541C85D26508E83_1897724279 = event;
        addTaint(eventType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1897724279.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1897724279;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.646 -0400", hash_original_method = "1A307AD1BD02E7BD6299AF40D811E5D5", hash_generated_method = "7C6B2C400B85BB8548CFAE9222AF81F4")
    public ExpiresHeader createExpiresHeader(int expires) throws InvalidArgumentException {
        ExpiresHeader varB4EAC82CA7396A68D541C85D26508E83_1219481014 = null; 
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad value " + expires);
        Expires e = new Expires();
        e.setExpires(expires);
        varB4EAC82CA7396A68D541C85D26508E83_1219481014 = e;
        addTaint(expires);
        varB4EAC82CA7396A68D541C85D26508E83_1219481014.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1219481014;
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.646 -0400", hash_original_method = "C38CB4735B94E96E0C6FB81DC8E60CBF", hash_generated_method = "0FE53CEC11E1443FF34FD7525F254DED")
    public javax.sip.header.ExtensionHeader createExtensionHeader(
        String name,
        String value) throws ParseException {
        javax.sip.header.ExtensionHeader varB4EAC82CA7396A68D541C85D26508E83_1605918890 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("bad name");
        gov.nist.javax.sip.header.ExtensionHeaderImpl ext = new gov.nist.javax.sip.header.ExtensionHeaderImpl();
        ext.setName(name);
        ext.setValue(value);
        varB4EAC82CA7396A68D541C85D26508E83_1605918890 = ext;
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1605918890.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1605918890;
        
        
            
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.647 -0400", hash_original_method = "E3876C81F77C4C65824998CB51869857", hash_generated_method = "FC30DAFCA7F220616752F138A370D918")
    public FromHeader createFromHeader(Address address, String tag) throws ParseException {
        FromHeader varB4EAC82CA7396A68D541C85D26508E83_1420832911 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address arg");
        From from = new From();
        from.setAddress(address);
        from.setTag(tag);
        varB4EAC82CA7396A68D541C85D26508E83_1420832911 = from;
        addTaint(address.getTaint());
        addTaint(tag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1420832911.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1420832911;
        
        
            
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.648 -0400", hash_original_method = "4DE074146D6A81FB201A39A399764E9F", hash_generated_method = "DFA71E8B4A0046F7BB21355856CA09D8")
    public InReplyToHeader createInReplyToHeader(String callId) throws ParseException {
        InReplyToHeader varB4EAC82CA7396A68D541C85D26508E83_663636836 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null callId arg");
        InReplyTo inReplyTo = new InReplyTo();
        inReplyTo.setCallId(callId);
        varB4EAC82CA7396A68D541C85D26508E83_663636836 = inReplyTo;
        addTaint(callId.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_663636836.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_663636836;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.650 -0400", hash_original_method = "2B62AE770A28023C5424C7B7718E4BD4", hash_generated_method = "F82DA5DC7BF9F31C89C56A0172E05A97")
    public MaxForwardsHeader createMaxForwardsHeader(int maxForwards) throws InvalidArgumentException {
        MaxForwardsHeader varB4EAC82CA7396A68D541C85D26508E83_1793666137 = null; 
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "bad maxForwards arg " + maxForwards);
        MaxForwards m = new MaxForwards();
        m.setMaxForwards(maxForwards);
        varB4EAC82CA7396A68D541C85D26508E83_1793666137 = m;
        addTaint(maxForwards);
        varB4EAC82CA7396A68D541C85D26508E83_1793666137.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1793666137;
        
        
            
                
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.653 -0400", hash_original_method = "623C745ED7578EC4227F3B15A38B5D4A", hash_generated_method = "DBFDBA81C2859FE58AD4DEA5D37CB417")
    public MimeVersionHeader createMimeVersionHeader(
        int majorVersion,
        int minorVersion) throws InvalidArgumentException {
        MimeVersionHeader varB4EAC82CA7396A68D541C85D26508E83_1715955110 = null; 
        if (DroidSafeAndroidRuntime.control) throw new javax.sip.InvalidArgumentException(
                "bad major/minor version");
        MimeVersion m = new MimeVersion();
        m.setMajorVersion(majorVersion);
        m.setMinorVersion(minorVersion);
        varB4EAC82CA7396A68D541C85D26508E83_1715955110 = m;
        addTaint(majorVersion);
        addTaint(minorVersion);
        varB4EAC82CA7396A68D541C85D26508E83_1715955110.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1715955110;
        
        
            
                
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.656 -0400", hash_original_method = "F897D0FECB8A8CC74BFA504858C91B42", hash_generated_method = "2AD4C4D4BFFD31452BACBDE24768546E")
    public MinExpiresHeader createMinExpiresHeader(int minExpires) throws InvalidArgumentException {
        MinExpiresHeader varB4EAC82CA7396A68D541C85D26508E83_49150424 = null; 
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad minExpires " + minExpires);
        MinExpires min = new MinExpires();
        min.setExpires(minExpires);
        varB4EAC82CA7396A68D541C85D26508E83_49150424 = min;
        addTaint(minExpires);
        varB4EAC82CA7396A68D541C85D26508E83_49150424.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_49150424;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.658 -0400", hash_original_method = "8EE941BB2D8E39A517F98D1ED3613B4D", hash_generated_method = "8D4D45132467CE9022316CEE9AC37DB9")
    public ExtensionHeader createMinSEHeader(int expires) throws InvalidArgumentException {
        ExtensionHeader varB4EAC82CA7396A68D541C85D26508E83_1973274565 = null; 
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad value " + expires);
        MinSE e = new MinSE();
        e.setExpires(expires);
        varB4EAC82CA7396A68D541C85D26508E83_1973274565 = e;
        addTaint(expires);
        varB4EAC82CA7396A68D541C85D26508E83_1973274565.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1973274565;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.659 -0400", hash_original_method = "2F5DB311D13CB6144CC7B49271775C33", hash_generated_method = "D0E116A62841219BF743867B298DDD84")
    public OrganizationHeader createOrganizationHeader(String organization) throws ParseException {
        OrganizationHeader varB4EAC82CA7396A68D541C85D26508E83_56235172 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("bad organization arg");
        Organization o = new Organization();
        o.setOrganization(organization);
        varB4EAC82CA7396A68D541C85D26508E83_56235172 = o;
        addTaint(organization.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_56235172.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_56235172;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.660 -0400", hash_original_method = "085951AB405380C6C60E1EC174C5C855", hash_generated_method = "29771021C2FD36773F2BD617FBCC9C6F")
    public PriorityHeader createPriorityHeader(String priority) throws ParseException {
        PriorityHeader varB4EAC82CA7396A68D541C85D26508E83_2043556332 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("bad priority arg");
        Priority p = new Priority();
        p.setPriority(priority);
        varB4EAC82CA7396A68D541C85D26508E83_2043556332 = p;
        addTaint(priority.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2043556332.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2043556332;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.662 -0400", hash_original_method = "E2D1E713D6EFBD9B5EF73CE359255B39", hash_generated_method = "B980E6DB877ECA56FFC1984E344E06F7")
    public ProxyAuthenticateHeader createProxyAuthenticateHeader(String scheme) throws ParseException {
        ProxyAuthenticateHeader varB4EAC82CA7396A68D541C85D26508E83_314254970 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("bad scheme arg");
        ProxyAuthenticate p = new ProxyAuthenticate();
        p.setScheme(scheme);
        varB4EAC82CA7396A68D541C85D26508E83_314254970 = p;
        addTaint(scheme.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_314254970.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_314254970;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.663 -0400", hash_original_method = "E046B5DACDD94AD026F81045FF391CD1", hash_generated_method = "9491D1C92415AB53B5A8301D32CDF49B")
    public ProxyAuthorizationHeader createProxyAuthorizationHeader(String scheme) throws ParseException {
        ProxyAuthorizationHeader varB4EAC82CA7396A68D541C85D26508E83_2026202218 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("bad scheme arg");
        ProxyAuthorization p = new ProxyAuthorization();
        p.setScheme(scheme);
        varB4EAC82CA7396A68D541C85D26508E83_2026202218 = p;
        addTaint(scheme.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2026202218.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2026202218;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.664 -0400", hash_original_method = "A059B8FD47D8FC83321E2DEF4CB18490", hash_generated_method = "904B6E8523BFBEDAC46EE14BFC462D87")
    public ProxyRequireHeader createProxyRequireHeader(String optionTag) throws ParseException {
        ProxyRequireHeader varB4EAC82CA7396A68D541C85D26508E83_1223810346 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("bad optionTag arg");
        ProxyRequire p = new ProxyRequire();
        p.setOptionTag(optionTag);
        varB4EAC82CA7396A68D541C85D26508E83_1223810346 = p;
        addTaint(optionTag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1223810346.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1223810346;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.665 -0400", hash_original_method = "42539302BE9490416DF1DC01B8BC3D99", hash_generated_method = "DCB4F121C91F9CB115CDBAFE5220F0A3")
    public RAckHeader createRAckHeader(
        long rSeqNumber,
        long cSeqNumber,
        String method) throws InvalidArgumentException, ParseException {
        RAckHeader varB4EAC82CA7396A68D541C85D26508E83_1539135798 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Bad method");
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad cseq/rseq arg");
        RAck rack = new RAck();
        rack.setMethod(method);
        rack.setCSequenceNumber(cSeqNumber);
        rack.setRSequenceNumber(rSeqNumber);
        varB4EAC82CA7396A68D541C85D26508E83_1539135798 = rack;
        addTaint(rSeqNumber);
        addTaint(cSeqNumber);
        addTaint(method.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1539135798.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1539135798;
        
        
            
        
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.666 -0400", hash_original_method = "B44C2BD23DFFCB51A992C42D93BADE4E", hash_generated_method = "28C40A41F1FA6C79B7EEB33C6B97E9CF")
    public RAckHeader createRAckHeader(int rSeqNumber, int cSeqNumber, String method) throws InvalidArgumentException, ParseException {
        RAckHeader varB4EAC82CA7396A68D541C85D26508E83_17615026 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_17615026 = createRAckHeader((long)rSeqNumber, (long)cSeqNumber, method);
        addTaint(rSeqNumber);
        addTaint(cSeqNumber);
        addTaint(method.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_17615026.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_17615026;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.666 -0400", hash_original_method = "38086BF4D4EB3CE5AB4BF7772F8EACF2", hash_generated_method = "9481B821F7A784C6A184C4F4D29932E2")
    public RSeqHeader createRSeqHeader(int sequenceNumber) throws InvalidArgumentException {
        RSeqHeader varB4EAC82CA7396A68D541C85D26508E83_450808423 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_450808423 = createRSeqHeader((long) sequenceNumber);
        addTaint(sequenceNumber);
        varB4EAC82CA7396A68D541C85D26508E83_450808423.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_450808423;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.667 -0400", hash_original_method = "CA4CA07B31DF6CB609C05636F40DB22F", hash_generated_method = "DE8F68FCA60FE89A2D555874578631C1")
    public RSeqHeader createRSeqHeader(long sequenceNumber) throws InvalidArgumentException {
        RSeqHeader varB4EAC82CA7396A68D541C85D26508E83_896848013 = null; 
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "invalid sequenceNumber arg " + sequenceNumber);
        RSeq rseq = new RSeq();
        rseq.setSeqNumber(sequenceNumber);
        varB4EAC82CA7396A68D541C85D26508E83_896848013 = rseq;
        addTaint(sequenceNumber);
        varB4EAC82CA7396A68D541C85D26508E83_896848013.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_896848013;
        
        
            
                
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.668 -0400", hash_original_method = "57AD0B4E4FE03197F2B52972D6060CBA", hash_generated_method = "8463FB0F65401F76357928C41A606A0A")
    public ReasonHeader createReasonHeader(
        String protocol,
        int cause,
        String text) throws InvalidArgumentException, ParseException {
        ReasonHeader varB4EAC82CA7396A68D541C85D26508E83_146384622 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("bad protocol arg");
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad cause");
        Reason reason = new Reason();
        reason.setProtocol(protocol);
        reason.setCause(cause);
        reason.setText(text);
        varB4EAC82CA7396A68D541C85D26508E83_146384622 = reason;
        addTaint(protocol.getTaint());
        addTaint(cause);
        addTaint(text.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_146384622.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_146384622;
        
        
            
        
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.670 -0400", hash_original_method = "6DA29D8692407706B9B05391AF333993", hash_generated_method = "173DD777ACBF65382BEE3BD9201FFCFF")
    public RecordRouteHeader createRecordRouteHeader(Address address) {
        RecordRouteHeader varB4EAC82CA7396A68D541C85D26508E83_1981463248 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null argument!");
        RecordRoute recordRoute = new RecordRoute();
        recordRoute.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_1981463248 = recordRoute;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1981463248.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1981463248;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.672 -0400", hash_original_method = "4393C033D6B63EF338EB93DE3E753573", hash_generated_method = "956649DE34BABA8FC28619AD215FE905")
    public ReplyToHeader createReplyToHeader(Address address) {
        ReplyToHeader varB4EAC82CA7396A68D541C85D26508E83_863639492 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address");
        ReplyTo replyTo = new ReplyTo();
        replyTo.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_863639492 = replyTo;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_863639492.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_863639492;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.673 -0400", hash_original_method = "F65B5EA444DA08358E800CD7B469501A", hash_generated_method = "8D39F8B0E458B747B9259C403CFEE326")
    public RequireHeader createRequireHeader(String optionTag) throws ParseException {
        RequireHeader varB4EAC82CA7396A68D541C85D26508E83_1601016696 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null optionTag");
        Require require = new Require();
        require.setOptionTag(optionTag);
        varB4EAC82CA7396A68D541C85D26508E83_1601016696 = require;
        addTaint(optionTag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1601016696.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1601016696;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.674 -0400", hash_original_method = "43D5E8C96E4C1ED3ED5B8AD5C39C801C", hash_generated_method = "E04B0F43881BA2556DCE185A56E9FB36")
    public RetryAfterHeader createRetryAfterHeader(int retryAfter) throws InvalidArgumentException {
        RetryAfterHeader varB4EAC82CA7396A68D541C85D26508E83_85082346 = null; 
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad retryAfter arg");
        RetryAfter r = new RetryAfter();
        r.setRetryAfter(retryAfter);
        varB4EAC82CA7396A68D541C85D26508E83_85082346 = r;
        addTaint(retryAfter);
        varB4EAC82CA7396A68D541C85D26508E83_85082346.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_85082346;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.675 -0400", hash_original_method = "03611E3BB30258B8EC4FDC9F783CBCCF", hash_generated_method = "592913329F802E65618E2B83A1D8AD12")
    public RouteHeader createRouteHeader(Address address) {
        RouteHeader varB4EAC82CA7396A68D541C85D26508E83_355035302 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address arg");
        Route route = new Route();
        route.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_355035302 = route;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_355035302.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_355035302;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.676 -0400", hash_original_method = "65AF02D93E753F97E0AF00F542D03529", hash_generated_method = "3E7BA8D4525525A1E2E37940BAA7811F")
    public ServerHeader createServerHeader(List product) throws ParseException {
        ServerHeader varB4EAC82CA7396A68D541C85D26508E83_1222980412 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null productList arg");
        Server server = new Server();
        server.setProduct(product);
        varB4EAC82CA7396A68D541C85D26508E83_1222980412 = server;
        addTaint(product.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1222980412.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1222980412;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.678 -0400", hash_original_method = "288EA55C0FFC9E81469649B581E59F71", hash_generated_method = "DD0B4CF9BDC6C56CCCE6FCF19AA6024C")
    public SubjectHeader createSubjectHeader(String subject) throws ParseException {
        SubjectHeader varB4EAC82CA7396A68D541C85D26508E83_101026350 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null subject arg");
        Subject s = new Subject();
        s.setSubject(subject);
        varB4EAC82CA7396A68D541C85D26508E83_101026350 = s;
        addTaint(subject.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_101026350.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_101026350;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.681 -0400", hash_original_method = "9B68B72DA8144991BC14639C6BE11723", hash_generated_method = "2BD4B95C79F06EC94E0A697A33E9E4B9")
    public SubscriptionStateHeader createSubscriptionStateHeader(String subscriptionState) throws ParseException {
        SubscriptionStateHeader varB4EAC82CA7396A68D541C85D26508E83_2136631660 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null subscriptionState arg");
        SubscriptionState s = new SubscriptionState();
        s.setState(subscriptionState);
        varB4EAC82CA7396A68D541C85D26508E83_2136631660 = s;
        addTaint(subscriptionState.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2136631660.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2136631660;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.683 -0400", hash_original_method = "589849ECCDAFDA20BE0DBE1D9A436669", hash_generated_method = "3420A157C2252F79066B687ABE3D9BB9")
    public SupportedHeader createSupportedHeader(String optionTag) throws ParseException {
        SupportedHeader varB4EAC82CA7396A68D541C85D26508E83_1435534404 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null optionTag arg");
        Supported supported = new Supported();
        supported.setOptionTag(optionTag);
        varB4EAC82CA7396A68D541C85D26508E83_1435534404 = supported;
        addTaint(optionTag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1435534404.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1435534404;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.685 -0400", hash_original_method = "380079DA7F92D6CF2CEA9086AA5F92D7", hash_generated_method = "12871F880A92A0908BB75D25525853FD")
    public TimeStampHeader createTimeStampHeader(float timeStamp) throws InvalidArgumentException {
        TimeStampHeader varB4EAC82CA7396A68D541C85D26508E83_664419729 = null; 
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("illegal timeStamp");
        TimeStamp t = new TimeStamp();
        t.setTimeStamp(timeStamp);
        varB4EAC82CA7396A68D541C85D26508E83_664419729 = t;
        addTaint(timeStamp);
        varB4EAC82CA7396A68D541C85D26508E83_664419729.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_664419729;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.686 -0400", hash_original_method = "7928C6AF630E4BCE57D31FA4979B7453", hash_generated_method = "C091A43340CCC7414DF81F76004F865B")
    public ToHeader createToHeader(Address address, String tag) throws ParseException {
        ToHeader varB4EAC82CA7396A68D541C85D26508E83_595731247 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address");
        To to = new To();
        to.setAddress(address);
        to.setTag(tag);
        varB4EAC82CA7396A68D541C85D26508E83_595731247 = to;
        addTaint(address.getTaint());
        addTaint(tag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_595731247.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_595731247;
        
        
            
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.687 -0400", hash_original_method = "9A62FFB59334167B71BC2FE402276C31", hash_generated_method = "5BD17AF13267E04DA90237C13E2BBCE2")
    public UnsupportedHeader createUnsupportedHeader(String optionTag) throws ParseException {
        UnsupportedHeader varB4EAC82CA7396A68D541C85D26508E83_767694136 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(optionTag);
        Unsupported unsupported = new Unsupported();
        unsupported.setOptionTag(optionTag);
        varB4EAC82CA7396A68D541C85D26508E83_767694136 = unsupported;
        addTaint(optionTag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_767694136.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_767694136;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.688 -0400", hash_original_method = "0FDDC4550D32FE0A8E48193D044787BB", hash_generated_method = "177016466221B8DEBE82EFEECD7F46FB")
    public UserAgentHeader createUserAgentHeader(List product) throws ParseException {
        UserAgentHeader varB4EAC82CA7396A68D541C85D26508E83_1615084418 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null user agent");
        UserAgent userAgent = new UserAgent();
        userAgent.setProduct(product);
        varB4EAC82CA7396A68D541C85D26508E83_1615084418 = userAgent;
        addTaint(product.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1615084418.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1615084418;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.689 -0400", hash_original_method = "B7A9F5DC521617567AEB2EDF2366DE24", hash_generated_method = "74B8248F289BC64E85362A4018DCD9B6")
    public ViaHeader createViaHeader(
        String host,
        int port,
        String transport,
        String branch) throws ParseException, InvalidArgumentException {
        ViaHeader varB4EAC82CA7396A68D541C85D26508E83_578060318 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        Via via = new Via();
        via.setBranch(branch);
        {
            boolean var892BBD36F1835D9F17C0D62A38310742_1830708874 = (host.indexOf(':') >= 0
            && host.indexOf('[') < 0);
            {
                {
                    int zoneStart = host.indexOf('%');
                    host = host.substring(0, zoneStart);
                } 
                host = '[' + host + ']';
            } 
        } 
        via.setHost(host);
        via.setPort(port);
        via.setTransport(transport);
        varB4EAC82CA7396A68D541C85D26508E83_578060318 = via;
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(transport.getTaint());
        addTaint(branch.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_578060318.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_578060318;
        
        
            
        
        
            
        
            
        
            
            
                
                
                    
            
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.690 -0400", hash_original_method = "EDE3AD5442B3DE671B6476C917BB6D0F", hash_generated_method = "929D437658018773BBDA455820117CB0")
    public WWWAuthenticateHeader createWWWAuthenticateHeader(String scheme) throws ParseException {
        WWWAuthenticateHeader varB4EAC82CA7396A68D541C85D26508E83_894243017 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null scheme");
        WWWAuthenticate www = new WWWAuthenticate();
        www.setScheme(scheme);
        varB4EAC82CA7396A68D541C85D26508E83_894243017 = www;
        addTaint(scheme.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_894243017.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_894243017;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.690 -0400", hash_original_method = "F34478A6D1616AB2836BA2A212AE0D49", hash_generated_method = "FE2BF844A75CF78457B3B9F76CE71151")
    public WarningHeader createWarningHeader(
        String agent,
        int code,
        String comment) throws ParseException, InvalidArgumentException {
        WarningHeader varB4EAC82CA7396A68D541C85D26508E83_184508322 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        Warning warning = new Warning();
        warning.setAgent(agent);
        warning.setCode(code);
        warning.setText(comment);
        varB4EAC82CA7396A68D541C85D26508E83_184508322 = warning;
        addTaint(agent.getTaint());
        addTaint(code);
        addTaint(comment.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_184508322.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_184508322;
        
        
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.692 -0400", hash_original_method = "CB42C1424760C62123C05E2F8CB60B35", hash_generated_method = "777384F946E7ACFAC0432375C5E226AC")
    public ErrorInfoHeader createErrorInfoHeader(URI errorInfo) {
        ErrorInfoHeader varB4EAC82CA7396A68D541C85D26508E83_1760004116 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        varB4EAC82CA7396A68D541C85D26508E83_1760004116 = new ErrorInfo((GenericURI) errorInfo);
        addTaint(errorInfo.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1760004116.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1760004116;
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.694 -0400", hash_original_method = "7E6122EDAE408D205AF0C9E45A024F04", hash_generated_method = "0295881AB8275E5986ED479FF5020F2E")
    public javax.sip.header.Header createHeader(String headerText) throws ParseException {
        javax.sip.header.Header varB4EAC82CA7396A68D541C85D26508E83_968690383 = null; 
        javax.sip.header.Header varB4EAC82CA7396A68D541C85D26508E83_788606032 = null; 
        javax.sip.header.Header varB4EAC82CA7396A68D541C85D26508E83_965405385 = null; 
        javax.sip.header.Header varB4EAC82CA7396A68D541C85D26508E83_623426104 = null; 
        javax.sip.header.Header varB4EAC82CA7396A68D541C85D26508E83_1443984640 = null; 
        StringMsgParser smp = new StringMsgParser();
        SIPHeader sipHeader = smp.parseSIPHeader(headerText.trim());
        {
            {
                boolean var376AECF828F744DA20E1ADDFF5E39535_1965706613 = (((SIPHeaderList) sipHeader).size() > 1);
                {
                    if (DroidSafeAndroidRuntime.control) throw new ParseException(
                    "Only singleton allowed " + headerText,
                    0);
                } 
                {
                    boolean varB2077481A39B1082F8C4F3463BCDED80_1143224825 = (((SIPHeaderList) sipHeader).size() == 0);
                    {
                        try 
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_968690383 = (Header) ((SIPHeaderList) sipHeader)
                        .getMyClass()
                        .newInstance();
                        } 
                        catch (InstantiationException ex)
                        {
                            ex.printStackTrace();
                            varB4EAC82CA7396A68D541C85D26508E83_788606032 = null;
                        } 
                        catch (IllegalAccessException ex)
                        {
                            ex.printStackTrace();
                            varB4EAC82CA7396A68D541C85D26508E83_965405385 = null;
                        } 
                    } 
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_623426104 = (Header) ((SIPHeaderList) sipHeader).getFirst();
                    } 
                } 
            } 
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1443984640 = (Header) sipHeader;
        } 
        addTaint(headerText.getTaint());
        javax.sip.header.Header varA7E53CE21691AB073D9660D615818899_368957704; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_368957704 = varB4EAC82CA7396A68D541C85D26508E83_968690383;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_368957704 = varB4EAC82CA7396A68D541C85D26508E83_788606032;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_368957704 = varB4EAC82CA7396A68D541C85D26508E83_965405385;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_368957704 = varB4EAC82CA7396A68D541C85D26508E83_623426104;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_368957704 = varB4EAC82CA7396A68D541C85D26508E83_1443984640;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_368957704.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_368957704;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.696 -0400", hash_original_method = "BE8A77015DA0080195A899A1BFDA2B08", hash_generated_method = "E925EB98B2E6363793867C67A80D81A9")
    public javax.sip.header.Header createHeader(
        String headerName,
        String headerValue) throws java.text.ParseException {
        javax.sip.header.Header varB4EAC82CA7396A68D541C85D26508E83_1428894161 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("header name is null");
        String hdrText = new StringBuffer()
                .append(headerName)
                .append(":")
                .append(headerValue)
                .toString();
        varB4EAC82CA7396A68D541C85D26508E83_1428894161 = createHeader(hdrText);
        addTaint(headerName.getTaint());
        addTaint(headerValue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1428894161.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1428894161;
        
        
            
        
            
                
                
                
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.697 -0400", hash_original_method = "FDCDF9463F1CDDAF0BCBB63B8B4D05F5", hash_generated_method = "BE4A2630EC37157C7FEEC2FC8F909DF7")
    public java.util.List createHeaders(String headers) throws java.text.ParseException {
        java.util.List varB4EAC82CA7396A68D541C85D26508E83_195046805 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg!");
        StringMsgParser smp = new StringMsgParser();
        SIPHeader shdr = smp.parseSIPHeader(headers);
        varB4EAC82CA7396A68D541C85D26508E83_195046805 = (SIPHeaderList) shdr;
        if (DroidSafeAndroidRuntime.control) throw new ParseException(
                "List of headers of this type is not allowed in a message",
                0);
        addTaint(headers.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_195046805.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_195046805;
        
        
            
        
        
        
            
        
            
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.698 -0400", hash_original_method = "5541F8A2ED86060178CAD1F0D5BA2507", hash_generated_method = "E00113719812146C6219218262F0141D")
    public ReferToHeader createReferToHeader(Address address) {
        ReferToHeader varB4EAC82CA7396A68D541C85D26508E83_2136460345 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address!");
        ReferTo referTo = new ReferTo();
        referTo.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_2136460345 = referTo;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2136460345.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2136460345;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.699 -0400", hash_original_method = "A51D0E58D36C2041DD351AE4FDD73BCF", hash_generated_method = "97281038632F0A62F0432CC1741DD51C")
    public ReferredByHeader createReferredByHeader(Address address) {
        ReferredByHeader varB4EAC82CA7396A68D541C85D26508E83_1062884329 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address!");
        ReferredBy referredBy = new ReferredBy();
        referredBy.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_1062884329 = referredBy;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1062884329.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1062884329;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.701 -0400", hash_original_method = "E3BB57144A133C8AFDA0829EAE12FAAB", hash_generated_method = "C67D669C3D3B0BB38B9322892A66F09B")
    public ReplacesHeader createReplacesHeader(String callId, String toTag,
                String fromTag) throws ParseException {
        ReplacesHeader varB4EAC82CA7396A68D541C85D26508E83_1927558706 = null; 
        Replaces replaces = new Replaces();
        replaces.setCallId(callId);
        replaces.setFromTag(fromTag);
        replaces.setToTag(toTag);
        varB4EAC82CA7396A68D541C85D26508E83_1927558706 = replaces;
        addTaint(callId.getTaint());
        addTaint(toTag.getTaint());
        addTaint(fromTag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1927558706.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1927558706;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.704 -0400", hash_original_method = "C42E665E40D735B4BFD234363CD8C238", hash_generated_method = "93B45B1452577E998F0789389FBC1E7C")
    public JoinHeader createJoinHeader(String callId, String toTag,
                String fromTag) throws ParseException {
        JoinHeader varB4EAC82CA7396A68D541C85D26508E83_1671691556 = null; 
        Join join = new Join();
        join.setCallId(callId);
        join.setFromTag(fromTag);
        join.setToTag(toTag);
        varB4EAC82CA7396A68D541C85D26508E83_1671691556 = join;
        addTaint(callId.getTaint());
        addTaint(toTag.getTaint());
        addTaint(fromTag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1671691556.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1671691556;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.707 -0400", hash_original_method = "95F88F9209912EE6FCAFCB830227A87B", hash_generated_method = "D3925184CF0281F4AD1316EE37533DB8")
    public SIPETagHeader createSIPETagHeader(String etag) throws ParseException {
        SIPETagHeader varB4EAC82CA7396A68D541C85D26508E83_980000826 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_980000826 = new SIPETag(etag);
        addTaint(etag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_980000826.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_980000826;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.709 -0400", hash_original_method = "9EE2B60A802A938BDC15DDB307A8B1D7", hash_generated_method = "313F130DC9DCE4E3748E2D58C011B56B")
    public SIPIfMatchHeader createSIPIfMatchHeader(String etag) throws ParseException {
        SIPIfMatchHeader varB4EAC82CA7396A68D541C85D26508E83_280738549 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_280738549 = new SIPIfMatch(etag);
        addTaint(etag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_280738549.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_280738549;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.711 -0400", hash_original_method = "5900AA55EC6D83D47F45CED3D37DDEC7", hash_generated_method = "9F6EA658821448FB8EFF24761C5959C4")
    public PAccessNetworkInfoHeader createPAccessNetworkInfoHeader() {
        PAccessNetworkInfoHeader varB4EAC82CA7396A68D541C85D26508E83_1858255705 = null; 
        PAccessNetworkInfo accessNetworkInfo = new PAccessNetworkInfo();
        varB4EAC82CA7396A68D541C85D26508E83_1858255705 = accessNetworkInfo;
        varB4EAC82CA7396A68D541C85D26508E83_1858255705.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1858255705;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.712 -0400", hash_original_method = "7A9453157C5A8C4FD99B8F34DC853877", hash_generated_method = "A19C698352C6F56827C73638BE11DB56")
    public PAssertedIdentityHeader createPAssertedIdentityHeader(Address address) throws NullPointerException, ParseException {
        PAssertedIdentityHeader varB4EAC82CA7396A68D541C85D26508E83_855764700 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address!");
        PAssertedIdentity assertedIdentity = new PAssertedIdentity();
        assertedIdentity.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_855764700 = assertedIdentity;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_855764700.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_855764700;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.713 -0400", hash_original_method = "4BD897B5832A55E4A60E9B49C4611708", hash_generated_method = "64520BE07DA04E7453E25956E1E892F1")
    public PAssociatedURIHeader createPAssociatedURIHeader(Address assocURI) {
        PAssociatedURIHeader varB4EAC82CA7396A68D541C85D26508E83_245614136 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null associatedURI!");
        PAssociatedURI associatedURI = new PAssociatedURI();
        associatedURI.setAddress(assocURI);
        varB4EAC82CA7396A68D541C85D26508E83_245614136 = associatedURI;
        addTaint(assocURI.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_245614136.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_245614136;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.715 -0400", hash_original_method = "FD713420BE4BC11FE9D9AB43BBBEAD30", hash_generated_method = "E097E82FCC41B3F165A637289A1084AA")
    public PCalledPartyIDHeader createPCalledPartyIDHeader(Address address) {
        PCalledPartyIDHeader varB4EAC82CA7396A68D541C85D26508E83_1747487458 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address!");
        PCalledPartyID calledPartyID = new PCalledPartyID();
        calledPartyID.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_1747487458 = calledPartyID;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1747487458.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1747487458;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.716 -0400", hash_original_method = "F3DC851C781199B1B5D5ECAC93663797", hash_generated_method = "B92F34C51957502F24B358A98B95E4A1")
    public PChargingFunctionAddressesHeader createPChargingFunctionAddressesHeader() {
        PChargingFunctionAddressesHeader varB4EAC82CA7396A68D541C85D26508E83_1047602260 = null; 
        PChargingFunctionAddresses cfa = new PChargingFunctionAddresses();
        varB4EAC82CA7396A68D541C85D26508E83_1047602260 = cfa;
        varB4EAC82CA7396A68D541C85D26508E83_1047602260.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1047602260;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.717 -0400", hash_original_method = "E82D256C40CCFC0E4431BA44734EBBF3", hash_generated_method = "E62276A5CC8971C41F76C3B7AB7476AB")
    public PChargingVectorHeader createChargingVectorHeader(String icid) throws ParseException {
        PChargingVectorHeader varB4EAC82CA7396A68D541C85D26508E83_1340406517 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null icid arg!");
        PChargingVector chargingVector = new PChargingVector();
        chargingVector.setICID(icid);
        varB4EAC82CA7396A68D541C85D26508E83_1340406517 = chargingVector;
        addTaint(icid.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1340406517.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1340406517;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.717 -0400", hash_original_method = "FB93C1554D708A44568E0208A3D181E0", hash_generated_method = "4F28E9639B0563A6FFB870F68185E7C8")
    public PMediaAuthorizationHeader createPMediaAuthorizationHeader(String token) throws InvalidArgumentException, ParseException {
        PMediaAuthorizationHeader varB4EAC82CA7396A68D541C85D26508E83_785044792 = null; 
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("The Media-Authorization-Token parameter is null or empty");
        PMediaAuthorization mediaAuthorization = new PMediaAuthorization();
        mediaAuthorization.setMediaAuthorizationToken(token);
        varB4EAC82CA7396A68D541C85D26508E83_785044792 = mediaAuthorization;
        addTaint(token.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_785044792.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_785044792;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.718 -0400", hash_original_method = "3BA03116BEA38D71B8C38B4BA62E5B71", hash_generated_method = "ED247A32792288CDD59143EA3B338222")
    public PPreferredIdentityHeader createPPreferredIdentityHeader(Address address) {
        PPreferredIdentityHeader varB4EAC82CA7396A68D541C85D26508E83_1589471707 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address!");
        PPreferredIdentity preferredIdentity = new PPreferredIdentity();
        preferredIdentity.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_1589471707 = preferredIdentity;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1589471707.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1589471707;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.719 -0400", hash_original_method = "B32CA202259A9B847AD818F044EE39DA", hash_generated_method = "D95A670BF1A35493F4DA578832564E58")
    public PVisitedNetworkIDHeader createPVisitedNetworkIDHeader() {
        PVisitedNetworkIDHeader varB4EAC82CA7396A68D541C85D26508E83_1208485756 = null; 
        PVisitedNetworkID visitedNetworkID = new PVisitedNetworkID();
        varB4EAC82CA7396A68D541C85D26508E83_1208485756 = visitedNetworkID;
        varB4EAC82CA7396A68D541C85D26508E83_1208485756.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1208485756;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.720 -0400", hash_original_method = "537B18CC29F2C70486994281CB29500B", hash_generated_method = "76ECB9DBA34E99E41526CE4ECA37BE1B")
    public PathHeader createPathHeader(Address address) {
        PathHeader varB4EAC82CA7396A68D541C85D26508E83_410307475 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address!");
        Path path = new Path();
        path.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_410307475 = path;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_410307475.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_410307475;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.721 -0400", hash_original_method = "85C1BF55B1F968333EFFBCF4DBC75BE6", hash_generated_method = "E0C0E1063552D01DB44A397424D88E48")
    public PrivacyHeader createPrivacyHeader(String privacyType) {
        PrivacyHeader varB4EAC82CA7396A68D541C85D26508E83_1922085337 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null privacyType arg");
        Privacy privacy = new Privacy(privacyType);
        varB4EAC82CA7396A68D541C85D26508E83_1922085337 = privacy;
        addTaint(privacyType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1922085337.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1922085337;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.722 -0400", hash_original_method = "A7CA2EB6DD40139D85B6778D2C783F9F", hash_generated_method = "9058012A730BDF4F39C875E90FCA97E9")
    public ServiceRouteHeader createServiceRouteHeader(Address address) {
        ServiceRouteHeader varB4EAC82CA7396A68D541C85D26508E83_974467081 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address!");
        ServiceRoute serviceRoute = new ServiceRoute();
        serviceRoute.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_974467081 = serviceRoute;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_974467081.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_974467081;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.724 -0400", hash_original_method = "7A3E4AE36777C6F2CF79A6B3882A3053", hash_generated_method = "53A272207D6E5D15585FD494FAFF3140")
    public SecurityServerHeader createSecurityServerHeader() {
        SecurityServerHeader varB4EAC82CA7396A68D541C85D26508E83_1534628171 = null; 
        SecurityServer secServer = new SecurityServer();
        varB4EAC82CA7396A68D541C85D26508E83_1534628171 = secServer;
        varB4EAC82CA7396A68D541C85D26508E83_1534628171.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1534628171;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.725 -0400", hash_original_method = "2361364E4BB205FAC2A8F8549D9431F6", hash_generated_method = "6FD4E7C20640D4733D6B6DCE2EFB3A75")
    public SecurityClientHeader createSecurityClientHeader() {
        SecurityClientHeader varB4EAC82CA7396A68D541C85D26508E83_2061913097 = null; 
        SecurityClient secClient = new SecurityClient();
        varB4EAC82CA7396A68D541C85D26508E83_2061913097 = secClient;
        varB4EAC82CA7396A68D541C85D26508E83_2061913097.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2061913097;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.728 -0400", hash_original_method = "1063C2554F38236C917DADCB6A55ADB8", hash_generated_method = "752516548C3A0BF560F47353B496C04C")
    public SecurityVerifyHeader createSecurityVerifyHeader() {
        SecurityVerifyHeader varB4EAC82CA7396A68D541C85D26508E83_1978583849 = null; 
        SecurityVerify secVerify = new SecurityVerify();
        varB4EAC82CA7396A68D541C85D26508E83_1978583849 = secVerify;
        varB4EAC82CA7396A68D541C85D26508E83_1978583849.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1978583849;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.731 -0400", hash_original_method = "2DDC01C5DAA0917C6B8BE6B8A00F5568", hash_generated_method = "4E8DC73FD58B366E01EAC3EB68A68504")
    public PUserDatabaseHeader createPUserDatabaseHeader(String databaseName) {
        PUserDatabaseHeader varB4EAC82CA7396A68D541C85D26508E83_1889327832 = null; 
        {
            boolean varAC311902DF4878F599DD65CB8A1544C9_2047316220 = ((databaseName ==null)||(databaseName.equals(" ")));
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Database name is null");
        } 
        PUserDatabase pUserDatabase = new PUserDatabase();
        pUserDatabase.setDatabaseName(databaseName);
        varB4EAC82CA7396A68D541C85D26508E83_1889327832 = pUserDatabase;
        addTaint(databaseName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1889327832.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1889327832;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.733 -0400", hash_original_method = "6A0691F102D20D70FD0A6921A61CA118", hash_generated_method = "B1AC4C20F5AFA5F835D248C1515177AE")
    public PProfileKeyHeader createPProfileKeyHeader(Address address) {
        PProfileKeyHeader varB4EAC82CA7396A68D541C85D26508E83_257536868 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Address is null");
        PProfileKey pProfileKey = new PProfileKey();
        pProfileKey.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_257536868 = pProfileKey;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_257536868.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_257536868;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.734 -0400", hash_original_method = "38B7C1667A9FD579C07BB14E255FF56A", hash_generated_method = "222841C9BC4C921BA23122279D31575F")
    public PServedUserHeader createPServedUserHeader(Address address) {
        PServedUserHeader varB4EAC82CA7396A68D541C85D26508E83_111904581 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Address is null");
        PServedUser psu = new PServedUser();
        psu.setAddress(address);
        varB4EAC82CA7396A68D541C85D26508E83_111904581 = psu;
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_111904581.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_111904581;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.736 -0400", hash_original_method = "C0CFD4DCC2CCE8A2BE967D3A2132C68A", hash_generated_method = "9B39E8016B97343884EEA93387FF7A35")
    public PPreferredServiceHeader createPPreferredServiceHeader() {
        PPreferredServiceHeader varB4EAC82CA7396A68D541C85D26508E83_386098197 = null; 
        PPreferredService pps = new PPreferredService();
        varB4EAC82CA7396A68D541C85D26508E83_386098197 = pps;
        varB4EAC82CA7396A68D541C85D26508E83_386098197.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_386098197;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.737 -0400", hash_original_method = "48E529894AF92157CD42EE8DFB6E18AB", hash_generated_method = "C70C4AEB43D89DBC68832433EC0B689F")
    public PAssertedServiceHeader createPAssertedServiceHeader() {
        PAssertedServiceHeader varB4EAC82CA7396A68D541C85D26508E83_1264085299 = null; 
        PAssertedService pas = new PAssertedService();
        varB4EAC82CA7396A68D541C85D26508E83_1264085299 = pas;
        varB4EAC82CA7396A68D541C85D26508E83_1264085299.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1264085299;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.738 -0400", hash_original_method = "6D472F26B8815D9A75157924D7DB3DB8", hash_generated_method = "BACF11A4F7049B304DBFF7BD56C71324")
    public SessionExpiresHeader createSessionExpiresHeader(int expires) throws InvalidArgumentException {
        SessionExpiresHeader varB4EAC82CA7396A68D541C85D26508E83_1395051245 = null; 
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad value " + expires);
        SessionExpires s = new SessionExpires();
        s.setExpires(expires);
        varB4EAC82CA7396A68D541C85D26508E83_1395051245 = s;
        addTaint(expires);
        varB4EAC82CA7396A68D541C85D26508E83_1395051245.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1395051245;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.739 -0400", hash_original_method = "F07701895F7EA99F66D330A17A2FD28D", hash_generated_method = "F4B7AC482F55E7A0EE875844ED518567")
    public SipRequestLine createRequestLine(String requestLine) throws ParseException {
        SipRequestLine varB4EAC82CA7396A68D541C85D26508E83_312123619 = null; 
        RequestLineParser requestLineParser = new RequestLineParser(requestLine);
        varB4EAC82CA7396A68D541C85D26508E83_312123619 = (SipRequestLine) requestLineParser.parse();
        addTaint(requestLine.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_312123619.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_312123619;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.739 -0400", hash_original_method = "94ED81BC52F6E3EE358EE57713F40357", hash_generated_method = "9C4D59E9A667D8050AE2F0FF39E3B196")
    public SipStatusLine createStatusLine(String statusLine) throws ParseException {
        SipStatusLine varB4EAC82CA7396A68D541C85D26508E83_477362512 = null; 
        StatusLineParser statusLineParser = new StatusLineParser(statusLine);
        varB4EAC82CA7396A68D541C85D26508E83_477362512 = (SipStatusLine) statusLineParser.parse();
        addTaint(statusLine.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_477362512.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_477362512;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.740 -0400", hash_original_method = "B06A6A8CC80D9698711113EFD1E58499", hash_generated_method = "557C35059F04D36AA185E567368A02A5")
    public ReferencesHeader createReferencesHeader(String callId, String rel) throws ParseException {
        ReferencesHeader varB4EAC82CA7396A68D541C85D26508E83_529673725 = null; 
        ReferencesHeader retval = new References();
        retval.setCallId(callId);
        retval.setRel(rel);
        varB4EAC82CA7396A68D541C85D26508E83_529673725 = retval;
        addTaint(callId.getTaint());
        addTaint(rel.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_529673725.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_529673725;
        
        
        
        
        
    }

    
}

