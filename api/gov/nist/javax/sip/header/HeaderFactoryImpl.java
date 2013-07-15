package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.484 -0400", hash_original_field = "6FA63D73209D74D0D54BC416A32DB10D", hash_generated_field = "0D2878F1D6B0CD805C869443DA7FE75E")

    private boolean stripAddressScopeZones = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.484 -0400", hash_original_method = "EA4ABB94B4CFEF029E31D8F450F44C66", hash_generated_method = "4DBE2EDCEE71001244079D3C05C060E8")
    public  HeaderFactoryImpl() {
        stripAddressScopeZones
            = Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
        // ---------- Original Method ----------
        //stripAddressScopeZones
            //= Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.485 -0400", hash_original_method = "9BEACA878DCF694953AD8141227DB60F", hash_generated_method = "3F1A3DE5498669AA00ABE685D6431FC2")
    public void setPrettyEncoding(boolean flag) {
        addTaint(flag);
        SIPHeaderList.setPrettyEncode(flag);
        // ---------- Original Method ----------
        //SIPHeaderList.setPrettyEncode(flag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.485 -0400", hash_original_method = "58113BBBA3D76308CFB19C46D0FF7A27", hash_generated_method = "24B77DBFFC0C907475E5D48D0009252C")
    public AcceptEncodingHeader createAcceptEncodingHeader(String encoding) throws ParseException {
        addTaint(encoding.getTaint());
    if(encoding == null)        
        {
        NullPointerException varDEA08EDB3217C2BADAB82B9BBFFECD37_637657811 = new NullPointerException("the encoding parameter is null");
        varDEA08EDB3217C2BADAB82B9BBFFECD37_637657811.addTaint(taint);
        throw varDEA08EDB3217C2BADAB82B9BBFFECD37_637657811;
        }
        AcceptEncoding acceptEncoding = new AcceptEncoding();
        acceptEncoding.setEncoding(encoding);
AcceptEncodingHeader varE01F2A72A06A1B398025C7E45032A16D_31487278 =         acceptEncoding;
        varE01F2A72A06A1B398025C7E45032A16D_31487278.addTaint(taint);
        return varE01F2A72A06A1B398025C7E45032A16D_31487278;
        // ---------- Original Method ----------
        //if (encoding == null)
            //throw new NullPointerException("the encoding parameter is null");
        //AcceptEncoding acceptEncoding = new AcceptEncoding();
        //acceptEncoding.setEncoding(encoding);
        //return acceptEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.486 -0400", hash_original_method = "3FEA70547EDCF31E1AA086D3362AC6CE", hash_generated_method = "D82A0629D406C121BF62A4C9ED39C7CB")
    public AcceptHeader createAcceptHeader(
        String contentType,
        String contentSubType) throws ParseException {
        addTaint(contentSubType.getTaint());
        addTaint(contentType.getTaint());
    if(contentType == null || contentSubType == null)        
        {
        NullPointerException var27CF75CB0BF0A10A901AD6DC140858D3_1647829584 = new NullPointerException("contentType or subtype is null ");
        var27CF75CB0BF0A10A901AD6DC140858D3_1647829584.addTaint(taint);
        throw var27CF75CB0BF0A10A901AD6DC140858D3_1647829584;
        }
        Accept accept = new Accept();
        accept.setContentType(contentType);
        accept.setContentSubType(contentSubType);
AcceptHeader var4810606E904E6475813B05DAB05FAA99_1726379420 =         accept;
        var4810606E904E6475813B05DAB05FAA99_1726379420.addTaint(taint);
        return var4810606E904E6475813B05DAB05FAA99_1726379420;
        // ---------- Original Method ----------
        //if (contentType == null || contentSubType == null)
            //throw new NullPointerException("contentType or subtype is null ");
        //Accept accept = new Accept();
        //accept.setContentType(contentType);
        //accept.setContentSubType(contentSubType);
        //return accept;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.486 -0400", hash_original_method = "5AF5E9D92982780781CC81035C3C1529", hash_generated_method = "9B014924F8252696A1EAC90B7371055C")
    public AcceptLanguageHeader createAcceptLanguageHeader(Locale language) {
        addTaint(language.getTaint());
    if(language == null)        
        {
        NullPointerException varCF8D07C80828DCBD1FC1EB16BCF7D0F2_1625674034 = new NullPointerException("null arg");
        varCF8D07C80828DCBD1FC1EB16BCF7D0F2_1625674034.addTaint(taint);
        throw varCF8D07C80828DCBD1FC1EB16BCF7D0F2_1625674034;
        }
        AcceptLanguage acceptLanguage = new AcceptLanguage();
        acceptLanguage.setAcceptLanguage(language);
AcceptLanguageHeader varA29C4E14CD304C607CC754001D3111CC_1954970747 =         acceptLanguage;
        varA29C4E14CD304C607CC754001D3111CC_1954970747.addTaint(taint);
        return varA29C4E14CD304C607CC754001D3111CC_1954970747;
        // ---------- Original Method ----------
        //if (language == null)
            //throw new NullPointerException("null arg");
        //AcceptLanguage acceptLanguage = new AcceptLanguage();
        //acceptLanguage.setAcceptLanguage(language);
        //return acceptLanguage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.486 -0400", hash_original_method = "3E0D5311E2AF98CBAC12E04C1647AAA5", hash_generated_method = "519B162A81B0A80CC2B5C1AD8D22C7AD")
    public AlertInfoHeader createAlertInfoHeader(URI alertInfo) {
        addTaint(alertInfo.getTaint());
    if(alertInfo == null)        
        {
        NullPointerException var779EAD4B03B6321A19989346C69A355A_671315673 = new NullPointerException("null arg alertInfo");
        var779EAD4B03B6321A19989346C69A355A_671315673.addTaint(taint);
        throw var779EAD4B03B6321A19989346C69A355A_671315673;
        }
        AlertInfo a = new AlertInfo();
        a.setAlertInfo(alertInfo);
AlertInfoHeader var3F5343BF1D849954A73F0BB303805FFD_2030211000 =         a;
        var3F5343BF1D849954A73F0BB303805FFD_2030211000.addTaint(taint);
        return var3F5343BF1D849954A73F0BB303805FFD_2030211000;
        // ---------- Original Method ----------
        //if (alertInfo == null)
            //throw new NullPointerException("null arg alertInfo");
        //AlertInfo a = new AlertInfo();
        //a.setAlertInfo(alertInfo);
        //return a;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.487 -0400", hash_original_method = "7A8DE3D3022A3669E75EC61B4D0B5F19", hash_generated_method = "E587E58B3E39113A3AD5BB86143AB645")
    public AllowEventsHeader createAllowEventsHeader(String eventType) throws ParseException {
        addTaint(eventType.getTaint());
    if(eventType == null)        
        {
        NullPointerException varF80AB4E0A5EA9F006568379580EF78C8_1792930512 = new NullPointerException("null arg eventType");
        varF80AB4E0A5EA9F006568379580EF78C8_1792930512.addTaint(taint);
        throw varF80AB4E0A5EA9F006568379580EF78C8_1792930512;
        }
        AllowEvents allowEvents = new AllowEvents();
        allowEvents.setEventType(eventType);
AllowEventsHeader var7AAF24C270C1FFA4026ACFC304EDA15A_1083849687 =         allowEvents;
        var7AAF24C270C1FFA4026ACFC304EDA15A_1083849687.addTaint(taint);
        return var7AAF24C270C1FFA4026ACFC304EDA15A_1083849687;
        // ---------- Original Method ----------
        //if (eventType == null)
            //throw new NullPointerException("null arg eventType");
        //AllowEvents allowEvents = new AllowEvents();
        //allowEvents.setEventType(eventType);
        //return allowEvents;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.487 -0400", hash_original_method = "C562ECE8E2158A54C27A4525D88FEA63", hash_generated_method = "B08F3EE7D39F1D77A4AA23676DEA93D6")
    public AllowHeader createAllowHeader(String method) throws ParseException {
        addTaint(method.getTaint());
    if(method == null)        
        {
        NullPointerException var399A735BE4E996AEE3B42328FB71B78B_807421897 = new NullPointerException("null arg method");
        var399A735BE4E996AEE3B42328FB71B78B_807421897.addTaint(taint);
        throw var399A735BE4E996AEE3B42328FB71B78B_807421897;
        }
        Allow allow = new Allow();
        allow.setMethod(method);
AllowHeader var9E6A6E901ADF174DAF31F3629A9D8C1B_1433929516 =         allow;
        var9E6A6E901ADF174DAF31F3629A9D8C1B_1433929516.addTaint(taint);
        return var9E6A6E901ADF174DAF31F3629A9D8C1B_1433929516;
        // ---------- Original Method ----------
        //if (method == null)
            //throw new NullPointerException("null arg method");
        //Allow allow = new Allow();
        //allow.setMethod(method);
        //return allow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.488 -0400", hash_original_method = "E72D81A306A857A102E9D4437AB18CA6", hash_generated_method = "0A13B24C39FC09A3780FEAEC18E27BB4")
    public AuthenticationInfoHeader createAuthenticationInfoHeader(String response) throws ParseException {
        addTaint(response.getTaint());
    if(response == null)        
        {
        NullPointerException var433DFD9714713F19150708C72828B04A_1437381857 = new NullPointerException("null arg response");
        var433DFD9714713F19150708C72828B04A_1437381857.addTaint(taint);
        throw var433DFD9714713F19150708C72828B04A_1437381857;
        }
        AuthenticationInfo auth = new AuthenticationInfo();
        auth.setResponse(response);
AuthenticationInfoHeader varFE2A4E660D0434D283705BEC4309B2E4_677101019 =         auth;
        varFE2A4E660D0434D283705BEC4309B2E4_677101019.addTaint(taint);
        return varFE2A4E660D0434D283705BEC4309B2E4_677101019;
        // ---------- Original Method ----------
        //if (response == null)
            //throw new NullPointerException("null arg response");
        //AuthenticationInfo auth = new AuthenticationInfo();
        //auth.setResponse(response);
        //return auth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.488 -0400", hash_original_method = "F250EC80C8CD1CBE5FF237A98CBD8CD0", hash_generated_method = "13A6A4015E5601DDF99DE44679CD9F5A")
    public AuthorizationHeader createAuthorizationHeader(String scheme) throws ParseException {
        addTaint(scheme.getTaint());
    if(scheme == null)        
        {
        NullPointerException var248D7F660A7C64246C65E344DAEB7E03_1894129701 = new NullPointerException("null arg scheme ");
        var248D7F660A7C64246C65E344DAEB7E03_1894129701.addTaint(taint);
        throw var248D7F660A7C64246C65E344DAEB7E03_1894129701;
        }
        Authorization auth = new Authorization();
        auth.setScheme(scheme);
AuthorizationHeader varFE2A4E660D0434D283705BEC4309B2E4_1078765885 =         auth;
        varFE2A4E660D0434D283705BEC4309B2E4_1078765885.addTaint(taint);
        return varFE2A4E660D0434D283705BEC4309B2E4_1078765885;
        // ---------- Original Method ----------
        //if (scheme == null)
            //throw new NullPointerException("null arg scheme ");
        //Authorization auth = new Authorization();
        //auth.setScheme(scheme);
        //return auth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.488 -0400", hash_original_method = "9707416B5040BCEA07917ADCBF33DA70", hash_generated_method = "126274FBD90239230F1294BC18EEBEA4")
    public CSeqHeader createCSeqHeader( long sequenceNumber, String method) throws ParseException, InvalidArgumentException {
        addTaint(method.getTaint());
        addTaint(sequenceNumber);
    if(sequenceNumber < 0)        
        {
        InvalidArgumentException var4E2C5630472389A0FA953FD60456BBEC_2110492818 = new InvalidArgumentException("bad arg " + sequenceNumber);
        var4E2C5630472389A0FA953FD60456BBEC_2110492818.addTaint(taint);
        throw var4E2C5630472389A0FA953FD60456BBEC_2110492818;
        }
    if(method == null)        
        {
        NullPointerException var399A735BE4E996AEE3B42328FB71B78B_716444607 = new NullPointerException("null arg method");
        var399A735BE4E996AEE3B42328FB71B78B_716444607.addTaint(taint);
        throw var399A735BE4E996AEE3B42328FB71B78B_716444607;
        }
        CSeq cseq = new CSeq();
        cseq.setMethod(method);
        cseq.setSeqNumber(sequenceNumber);
CSeqHeader varFC7826BD3106DF80805DB927415679C2_1353907146 =         cseq;
        varFC7826BD3106DF80805DB927415679C2_1353907146.addTaint(taint);
        return varFC7826BD3106DF80805DB927415679C2_1353907146;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.489 -0400", hash_original_method = "332D5DD16F528ACCDED76BFE26F4F243", hash_generated_method = "2B7B2AAEBA71EBB8D3ED229388E8221C")
    public CSeqHeader createCSeqHeader( int sequenceNumber, String method) throws ParseException, InvalidArgumentException {
        addTaint(method.getTaint());
        addTaint(sequenceNumber);
CSeqHeader varEB341C41EAF652A028D677FFCBAF073B_2079331073 =         this.createCSeqHeader( (long) sequenceNumber, method );
        varEB341C41EAF652A028D677FFCBAF073B_2079331073.addTaint(taint);
        return varEB341C41EAF652A028D677FFCBAF073B_2079331073;
        // ---------- Original Method ----------
        //return this.createCSeqHeader( (long) sequenceNumber, method );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.489 -0400", hash_original_method = "0CB560808F252622C176039BC6E86FF7", hash_generated_method = "3EC63214570975A2031314D2C2A1977E")
    public CallIdHeader createCallIdHeader(String callId) throws ParseException {
        addTaint(callId.getTaint());
    if(callId == null)        
        {
        NullPointerException var3ACAC66E634D40B72DDDB712DF5B0D7C_1730934062 = new NullPointerException("null arg callId");
        var3ACAC66E634D40B72DDDB712DF5B0D7C_1730934062.addTaint(taint);
        throw var3ACAC66E634D40B72DDDB712DF5B0D7C_1730934062;
        }
        CallID c = new CallID();
        c.setCallId(callId);
CallIdHeader var807FB10045EE51C06BDB74744A6714DF_1506976709 =         c;
        var807FB10045EE51C06BDB74744A6714DF_1506976709.addTaint(taint);
        return var807FB10045EE51C06BDB74744A6714DF_1506976709;
        // ---------- Original Method ----------
        //if (callId == null)
            //throw new NullPointerException("null arg callId");
        //CallID c = new CallID();
        //c.setCallId(callId);
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.489 -0400", hash_original_method = "8867B6CA9EB8DB8DAA3F991D7B0AD5D9", hash_generated_method = "244D93E8950BFDA2D8D8B79FCB2222C9")
    public CallInfoHeader createCallInfoHeader(URI callInfo) {
        addTaint(callInfo.getTaint());
    if(callInfo == null)        
        {
        NullPointerException var45772051CC68D2809BF7600BA06F2333_1143278617 = new NullPointerException("null arg callInfo");
        var45772051CC68D2809BF7600BA06F2333_1143278617.addTaint(taint);
        throw var45772051CC68D2809BF7600BA06F2333_1143278617;
        }
        CallInfo c = new CallInfo();
        c.setInfo(callInfo);
CallInfoHeader var807FB10045EE51C06BDB74744A6714DF_189993553 =         c;
        var807FB10045EE51C06BDB74744A6714DF_189993553.addTaint(taint);
        return var807FB10045EE51C06BDB74744A6714DF_189993553;
        // ---------- Original Method ----------
        //if (callInfo == null)
            //throw new NullPointerException("null arg callInfo");
        //CallInfo c = new CallInfo();
        //c.setInfo(callInfo);
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.490 -0400", hash_original_method = "45EF0D9994A51A34EA10DF4A185E8F21", hash_generated_method = "165AD5C7F0FE45A2840D36727560AB2A")
    public ContactHeader createContactHeader(Address address) {
        addTaint(address.getTaint());
    if(address == null)        
        {
        NullPointerException varEA0AFDD92357D6E24F03515D275B80B6_1035417586 = new NullPointerException("null arg address");
        varEA0AFDD92357D6E24F03515D275B80B6_1035417586.addTaint(taint);
        throw varEA0AFDD92357D6E24F03515D275B80B6_1035417586;
        }
        Contact contact = new Contact();
        contact.setAddress(address);
ContactHeader var695F7F01550A7C9445656119C31590B1_518192670 =         contact;
        var695F7F01550A7C9445656119C31590B1_518192670.addTaint(taint);
        return var695F7F01550A7C9445656119C31590B1_518192670;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null arg address");
        //Contact contact = new Contact();
        //contact.setAddress(address);
        //return contact;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.490 -0400", hash_original_method = "5873C88FB18B86DA11D334099F5AE064", hash_generated_method = "A49013795D8F5BD419E6EF731CB1223A")
    public ContactHeader createContactHeader() {
        Contact contact = new Contact();
        contact.setWildCardFlag(true);
        contact.setExpires(0);
ContactHeader var695F7F01550A7C9445656119C31590B1_867892263 =         contact;
        var695F7F01550A7C9445656119C31590B1_867892263.addTaint(taint);
        return var695F7F01550A7C9445656119C31590B1_867892263;
        // ---------- Original Method ----------
        //Contact contact = new Contact();
        //contact.setWildCardFlag(true);
        //contact.setExpires(0);
        //return contact;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.490 -0400", hash_original_method = "CC352C2425871DC27A0C55CF39D4ABAB", hash_generated_method = "D737A83EDFC9735E46A07CE5CA3CFCD5")
    public ContentDispositionHeader createContentDispositionHeader(String contentDisposition) throws ParseException {
        addTaint(contentDisposition.getTaint());
    if(contentDisposition == null)        
        {
        NullPointerException varAAF294EDB1A36F2A920A05248736DF62_940041391 = new NullPointerException("null arg contentDisposition");
        varAAF294EDB1A36F2A920A05248736DF62_940041391.addTaint(taint);
        throw varAAF294EDB1A36F2A920A05248736DF62_940041391;
        }
        ContentDisposition c = new ContentDisposition();
        c.setDispositionType(contentDisposition);
ContentDispositionHeader var807FB10045EE51C06BDB74744A6714DF_1436558768 =         c;
        var807FB10045EE51C06BDB74744A6714DF_1436558768.addTaint(taint);
        return var807FB10045EE51C06BDB74744A6714DF_1436558768;
        // ---------- Original Method ----------
        //if (contentDisposition == null)
            //throw new NullPointerException("null arg contentDisposition");
        //ContentDisposition c = new ContentDisposition();
        //c.setDispositionType(contentDisposition);
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.491 -0400", hash_original_method = "090104ADCCDA5F259494E038435257D1", hash_generated_method = "A9A03E00B7D30566D9A45EEA47604BF4")
    public ContentEncodingHeader createContentEncodingHeader(String encoding) throws ParseException {
        addTaint(encoding.getTaint());
    if(encoding == null)        
        {
        NullPointerException var4C674A525DB996A1012167A3B21269D5_1706650694 = new NullPointerException("null encoding");
        var4C674A525DB996A1012167A3B21269D5_1706650694.addTaint(taint);
        throw var4C674A525DB996A1012167A3B21269D5_1706650694;
        }
        ContentEncoding c = new ContentEncoding();
        c.setEncoding(encoding);
ContentEncodingHeader var807FB10045EE51C06BDB74744A6714DF_1607109730 =         c;
        var807FB10045EE51C06BDB74744A6714DF_1607109730.addTaint(taint);
        return var807FB10045EE51C06BDB74744A6714DF_1607109730;
        // ---------- Original Method ----------
        //if (encoding == null)
            //throw new NullPointerException("null encoding");
        //ContentEncoding c = new ContentEncoding();
        //c.setEncoding(encoding);
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.491 -0400", hash_original_method = "CD027E2457CF527330FF9F4C0A972B91", hash_generated_method = "0D06106A6F7C0D75CC212AF8CAE7C151")
    public ContentLanguageHeader createContentLanguageHeader(Locale contentLanguage) {
        addTaint(contentLanguage.getTaint());
    if(contentLanguage == null)        
        {
        NullPointerException varAC83619DCA13C5FD95F312D657A5294C_1443731182 = new NullPointerException("null arg contentLanguage");
        varAC83619DCA13C5FD95F312D657A5294C_1443731182.addTaint(taint);
        throw varAC83619DCA13C5FD95F312D657A5294C_1443731182;
        }
        ContentLanguage c = new ContentLanguage();
        c.setContentLanguage(contentLanguage);
ContentLanguageHeader var807FB10045EE51C06BDB74744A6714DF_2136567259 =         c;
        var807FB10045EE51C06BDB74744A6714DF_2136567259.addTaint(taint);
        return var807FB10045EE51C06BDB74744A6714DF_2136567259;
        // ---------- Original Method ----------
        //if (contentLanguage == null)
            //throw new NullPointerException("null arg contentLanguage");
        //ContentLanguage c = new ContentLanguage();
        //c.setContentLanguage(contentLanguage);
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.492 -0400", hash_original_method = "DA3B5EC62F3E30804B07AD592D303E3E", hash_generated_method = "826B017E24438955D2732BCF32CC4B8B")
    public ContentLengthHeader createContentLengthHeader(int contentLength) throws InvalidArgumentException {
        addTaint(contentLength);
    if(contentLength < 0)        
        {
        InvalidArgumentException var30EDEF7A7B9B96D47CAAA8CFB4ADDA2B_393941775 = new InvalidArgumentException("bad contentLength");
        var30EDEF7A7B9B96D47CAAA8CFB4ADDA2B_393941775.addTaint(taint);
        throw var30EDEF7A7B9B96D47CAAA8CFB4ADDA2B_393941775;
        }
        ContentLength c = new ContentLength();
        c.setContentLength(contentLength);
ContentLengthHeader var807FB10045EE51C06BDB74744A6714DF_811975897 =         c;
        var807FB10045EE51C06BDB74744A6714DF_811975897.addTaint(taint);
        return var807FB10045EE51C06BDB74744A6714DF_811975897;
        // ---------- Original Method ----------
        //if (contentLength < 0)
            //throw new InvalidArgumentException("bad contentLength");
        //ContentLength c = new ContentLength();
        //c.setContentLength(contentLength);
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.492 -0400", hash_original_method = "BF42B4FF2E7F96D2FA4773C6E514B79D", hash_generated_method = "D6C5AEA48FEBE05677723BFC8618F004")
    public ContentTypeHeader createContentTypeHeader(
        String contentType,
        String contentSubType) throws ParseException {
        addTaint(contentSubType.getTaint());
        addTaint(contentType.getTaint());
    if(contentType == null || contentSubType == null)        
        {
        NullPointerException var2B513044B221C7056C3803C6C31C8201_388493196 = new NullPointerException("null contentType or subType");
        var2B513044B221C7056C3803C6C31C8201_388493196.addTaint(taint);
        throw var2B513044B221C7056C3803C6C31C8201_388493196;
        }
        ContentType c = new ContentType();
        c.setContentType(contentType);
        c.setContentSubType(contentSubType);
ContentTypeHeader var807FB10045EE51C06BDB74744A6714DF_831979803 =         c;
        var807FB10045EE51C06BDB74744A6714DF_831979803.addTaint(taint);
        return var807FB10045EE51C06BDB74744A6714DF_831979803;
        // ---------- Original Method ----------
        //if (contentType == null || contentSubType == null)
            //throw new NullPointerException("null contentType or subType");
        //ContentType c = new ContentType();
        //c.setContentType(contentType);
        //c.setContentSubType(contentSubType);
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.493 -0400", hash_original_method = "F3D0948AB2AB5DCB4D46B0F9C4754A1D", hash_generated_method = "F6BB102F5188D7F6C31AFD25688F0277")
    public DateHeader createDateHeader(Calendar date) {
        addTaint(date.getTaint());
        SIPDateHeader d = new SIPDateHeader();
    if(date == null)        
        {
        NullPointerException var72A525CDA1FC3B46EBEE8B395772AADA_679398019 = new NullPointerException("null date");
        var72A525CDA1FC3B46EBEE8B395772AADA_679398019.addTaint(taint);
        throw var72A525CDA1FC3B46EBEE8B395772AADA_679398019;
        }
        d.setDate(date);
DateHeader varBE245B24E7ED509FDFAAA6CD39E35D89_1940631792 =         d;
        varBE245B24E7ED509FDFAAA6CD39E35D89_1940631792.addTaint(taint);
        return varBE245B24E7ED509FDFAAA6CD39E35D89_1940631792;
        // ---------- Original Method ----------
        //SIPDateHeader d = new SIPDateHeader();
        //if (date == null)
            //throw new NullPointerException("null date");
        //d.setDate(date);
        //return d;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.493 -0400", hash_original_method = "7FD58797EECF83FE34BEE1F3B093BC46", hash_generated_method = "B00A74993249B5C4704300F83893664E")
    public EventHeader createEventHeader(String eventType) throws ParseException {
        addTaint(eventType.getTaint());
    if(eventType == null)        
        {
        NullPointerException varC3169858D04CE419EDD144E9093988C9_845335340 = new NullPointerException("null eventType");
        varC3169858D04CE419EDD144E9093988C9_845335340.addTaint(taint);
        throw varC3169858D04CE419EDD144E9093988C9_845335340;
        }
        Event event = new Event();
        event.setEventType(eventType);
EventHeader var3162E7A4A1E5D72F1058A9B39A6A8738_1280722239 =         event;
        var3162E7A4A1E5D72F1058A9B39A6A8738_1280722239.addTaint(taint);
        return var3162E7A4A1E5D72F1058A9B39A6A8738_1280722239;
        // ---------- Original Method ----------
        //if (eventType == null)
            //throw new NullPointerException("null eventType");
        //Event event = new Event();
        //event.setEventType(eventType);
        //return event;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.494 -0400", hash_original_method = "1A307AD1BD02E7BD6299AF40D811E5D5", hash_generated_method = "CE0B24DFF98508A7AA08C63D4F2C939E")
    public ExpiresHeader createExpiresHeader(int expires) throws InvalidArgumentException {
        addTaint(expires);
    if(expires < 0)        
        {
        InvalidArgumentException varD793F10BEC5AF07D94BCB0E147C43386_426966422 = new InvalidArgumentException("bad value " + expires);
        varD793F10BEC5AF07D94BCB0E147C43386_426966422.addTaint(taint);
        throw varD793F10BEC5AF07D94BCB0E147C43386_426966422;
        }
        Expires e = new Expires();
        e.setExpires(expires);
ExpiresHeader var6BFFBFA2F1D556BA80433C2335198CE9_1251899169 =         e;
        var6BFFBFA2F1D556BA80433C2335198CE9_1251899169.addTaint(taint);
        return var6BFFBFA2F1D556BA80433C2335198CE9_1251899169;
        // ---------- Original Method ----------
        //if (expires < 0)
            //throw new InvalidArgumentException("bad value " + expires);
        //Expires e = new Expires();
        //e.setExpires(expires);
        //return e;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.494 -0400", hash_original_method = "C38CB4735B94E96E0C6FB81DC8E60CBF", hash_generated_method = "63750E2D03A433A272B650AA6E864503")
    public javax.sip.header.ExtensionHeader createExtensionHeader(
        String name,
        String value) throws ParseException {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
    if(name == null)        
        {
        NullPointerException varF8E41E74DC7E4A1BFFD590DA02D269D3_1157992332 = new NullPointerException("bad name");
        varF8E41E74DC7E4A1BFFD590DA02D269D3_1157992332.addTaint(taint);
        throw varF8E41E74DC7E4A1BFFD590DA02D269D3_1157992332;
        }
        gov.nist.javax.sip.header.ExtensionHeaderImpl ext = new gov.nist.javax.sip.header.ExtensionHeaderImpl();
        ext.setName(name);
        ext.setValue(value);
javax.sip.header.ExtensionHeader varFDE9E71E25F62874B52BEEA10AF11C0A_664096576 =         ext;
        varFDE9E71E25F62874B52BEEA10AF11C0A_664096576.addTaint(taint);
        return varFDE9E71E25F62874B52BEEA10AF11C0A_664096576;
        // ---------- Original Method ----------
        //if (name == null)
            //throw new NullPointerException("bad name");
        //gov.nist.javax.sip.header.ExtensionHeaderImpl ext =
            //new gov.nist.javax.sip.header.ExtensionHeaderImpl();
        //ext.setName(name);
        //ext.setValue(value);
        //return ext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.495 -0400", hash_original_method = "E3876C81F77C4C65824998CB51869857", hash_generated_method = "5A77EC325510B45956911A838A410C84")
    public FromHeader createFromHeader(Address address, String tag) throws ParseException {
        addTaint(tag.getTaint());
        addTaint(address.getTaint());
    if(address == null)        
        {
        NullPointerException varB13A65CC050DE58641D8F0978770CC55_1450321492 = new NullPointerException("null address arg");
        varB13A65CC050DE58641D8F0978770CC55_1450321492.addTaint(taint);
        throw varB13A65CC050DE58641D8F0978770CC55_1450321492;
        }
        From from = new From();
        from.setAddress(address);
    if(tag != null)        
        from.setTag(tag);
FromHeader var48A496C0AD319E4CFD66279C8D5D42FE_1248602989 =         from;
        var48A496C0AD319E4CFD66279C8D5D42FE_1248602989.addTaint(taint);
        return var48A496C0AD319E4CFD66279C8D5D42FE_1248602989;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address arg");
        //From from = new From();
        //from.setAddress(address);
        //if (tag != null)
            //from.setTag(tag);
        //return from;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.495 -0400", hash_original_method = "4DE074146D6A81FB201A39A399764E9F", hash_generated_method = "8106F6A4775F2FFE793877ED02FE64FD")
    public InReplyToHeader createInReplyToHeader(String callId) throws ParseException {
        addTaint(callId.getTaint());
    if(callId == null)        
        {
        NullPointerException varB13FA8C583E355B9E3F94958A87BC8A2_1484019868 = new NullPointerException("null callId arg");
        varB13FA8C583E355B9E3F94958A87BC8A2_1484019868.addTaint(taint);
        throw varB13FA8C583E355B9E3F94958A87BC8A2_1484019868;
        }
        InReplyTo inReplyTo = new InReplyTo();
        inReplyTo.setCallId(callId);
InReplyToHeader varD68AE97D1428FF1C23FFFC857A57F924_1544408149 =         inReplyTo;
        varD68AE97D1428FF1C23FFFC857A57F924_1544408149.addTaint(taint);
        return varD68AE97D1428FF1C23FFFC857A57F924_1544408149;
        // ---------- Original Method ----------
        //if (callId == null)
            //throw new NullPointerException("null callId arg");
        //InReplyTo inReplyTo = new InReplyTo();
        //inReplyTo.setCallId(callId);
        //return inReplyTo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.495 -0400", hash_original_method = "2B62AE770A28023C5424C7B7718E4BD4", hash_generated_method = "7E13A9960AE426AB70EA3984474DD785")
    public MaxForwardsHeader createMaxForwardsHeader(int maxForwards) throws InvalidArgumentException {
        addTaint(maxForwards);
    if(maxForwards < 0 || maxForwards > 255)        
        {
        InvalidArgumentException var4ADBA25E60B51233156C4DAE056000FF_564801514 = new InvalidArgumentException(
                "bad maxForwards arg " + maxForwards);
        var4ADBA25E60B51233156C4DAE056000FF_564801514.addTaint(taint);
        throw var4ADBA25E60B51233156C4DAE056000FF_564801514;
        }
        MaxForwards m = new MaxForwards();
        m.setMaxForwards(maxForwards);
MaxForwardsHeader varBD22C5ECD1F8BC3EE2416AF7A8014FD2_329060127 =         m;
        varBD22C5ECD1F8BC3EE2416AF7A8014FD2_329060127.addTaint(taint);
        return varBD22C5ECD1F8BC3EE2416AF7A8014FD2_329060127;
        // ---------- Original Method ----------
        //if (maxForwards < 0 || maxForwards > 255)
            //throw new InvalidArgumentException(
                //"bad maxForwards arg " + maxForwards);
        //MaxForwards m = new MaxForwards();
        //m.setMaxForwards(maxForwards);
        //return m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.496 -0400", hash_original_method = "623C745ED7578EC4227F3B15A38B5D4A", hash_generated_method = "6CADD6B9BE300D4C3FCEE2D86E8496CC")
    public MimeVersionHeader createMimeVersionHeader(
        int majorVersion,
        int minorVersion) throws InvalidArgumentException {
        addTaint(minorVersion);
        addTaint(majorVersion);
    if(majorVersion < 0 || minorVersion < 0)        
        {
        javax.sip.InvalidArgumentException var8492CA1CD5121DE5FD9B2CF52BE09D73_2088565727 = new javax.sip.InvalidArgumentException(
                "bad major/minor version");
        var8492CA1CD5121DE5FD9B2CF52BE09D73_2088565727.addTaint(taint);
        throw var8492CA1CD5121DE5FD9B2CF52BE09D73_2088565727;
        }
        MimeVersion m = new MimeVersion();
        m.setMajorVersion(majorVersion);
        m.setMinorVersion(minorVersion);
MimeVersionHeader varBD22C5ECD1F8BC3EE2416AF7A8014FD2_1729004553 =         m;
        varBD22C5ECD1F8BC3EE2416AF7A8014FD2_1729004553.addTaint(taint);
        return varBD22C5ECD1F8BC3EE2416AF7A8014FD2_1729004553;
        // ---------- Original Method ----------
        //if (majorVersion < 0 || minorVersion < 0)
            //throw new javax.sip.InvalidArgumentException(
                //"bad major/minor version");
        //MimeVersion m = new MimeVersion();
        //m.setMajorVersion(majorVersion);
        //m.setMinorVersion(minorVersion);
        //return m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.496 -0400", hash_original_method = "F897D0FECB8A8CC74BFA504858C91B42", hash_generated_method = "47F1BD287A263F0222D50E964A7269AB")
    public MinExpiresHeader createMinExpiresHeader(int minExpires) throws InvalidArgumentException {
        addTaint(minExpires);
    if(minExpires < 0)        
        {
        InvalidArgumentException var0BEF6269B8DD8CBC7746379A17D8AE50_326789885 = new InvalidArgumentException("bad minExpires " + minExpires);
        var0BEF6269B8DD8CBC7746379A17D8AE50_326789885.addTaint(taint);
        throw var0BEF6269B8DD8CBC7746379A17D8AE50_326789885;
        }
        MinExpires min = new MinExpires();
        min.setExpires(minExpires);
MinExpiresHeader varD85D633807129E579A78008D2DCE7AA0_1757915269 =         min;
        varD85D633807129E579A78008D2DCE7AA0_1757915269.addTaint(taint);
        return varD85D633807129E579A78008D2DCE7AA0_1757915269;
        // ---------- Original Method ----------
        //if (minExpires < 0)
            //throw new InvalidArgumentException("bad minExpires " + minExpires);
        //MinExpires min = new MinExpires();
        //min.setExpires(minExpires);
        //return min;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.497 -0400", hash_original_method = "8EE941BB2D8E39A517F98D1ED3613B4D", hash_generated_method = "9F6D09355E632842106916BFB08705E8")
    public ExtensionHeader createMinSEHeader(int expires) throws InvalidArgumentException {
        addTaint(expires);
    if(expires < 0)        
        {
        InvalidArgumentException varD793F10BEC5AF07D94BCB0E147C43386_888449627 = new InvalidArgumentException("bad value " + expires);
        varD793F10BEC5AF07D94BCB0E147C43386_888449627.addTaint(taint);
        throw varD793F10BEC5AF07D94BCB0E147C43386_888449627;
        }
        MinSE e = new MinSE();
        e.setExpires(expires);
ExtensionHeader var6BFFBFA2F1D556BA80433C2335198CE9_700853173 =         e;
        var6BFFBFA2F1D556BA80433C2335198CE9_700853173.addTaint(taint);
        return var6BFFBFA2F1D556BA80433C2335198CE9_700853173;
        // ---------- Original Method ----------
        //if (expires < 0)
            //throw new InvalidArgumentException("bad value " + expires);
        //MinSE e = new MinSE();
        //e.setExpires(expires);
        //return e;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.497 -0400", hash_original_method = "2F5DB311D13CB6144CC7B49271775C33", hash_generated_method = "DAC612C4872300669714FD524DB79052")
    public OrganizationHeader createOrganizationHeader(String organization) throws ParseException {
        addTaint(organization.getTaint());
    if(organization == null)        
        {
        NullPointerException var9F93DACCED6B45354A8AF698260C72F6_153426213 = new NullPointerException("bad organization arg");
        var9F93DACCED6B45354A8AF698260C72F6_153426213.addTaint(taint);
        throw var9F93DACCED6B45354A8AF698260C72F6_153426213;
        }
        Organization o = new Organization();
        o.setOrganization(organization);
OrganizationHeader varBB0FDDC5CC83552BCB5FF7675B18007A_1096332044 =         o;
        varBB0FDDC5CC83552BCB5FF7675B18007A_1096332044.addTaint(taint);
        return varBB0FDDC5CC83552BCB5FF7675B18007A_1096332044;
        // ---------- Original Method ----------
        //if (organization == null)
            //throw new NullPointerException("bad organization arg");
        //Organization o = new Organization();
        //o.setOrganization(organization);
        //return o;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.497 -0400", hash_original_method = "085951AB405380C6C60E1EC174C5C855", hash_generated_method = "878E06FC478E5268E540800A4BC5C550")
    public PriorityHeader createPriorityHeader(String priority) throws ParseException {
        addTaint(priority.getTaint());
    if(priority == null)        
        {
        NullPointerException varF6F42D2BD8B49E3D46DE35DB64F3B92E_1876173713 = new NullPointerException("bad priority arg");
        varF6F42D2BD8B49E3D46DE35DB64F3B92E_1876173713.addTaint(taint);
        throw varF6F42D2BD8B49E3D46DE35DB64F3B92E_1876173713;
        }
        Priority p = new Priority();
        p.setPriority(priority);
PriorityHeader var74E4690D9F2A026504928C017944E149_837490687 =         p;
        var74E4690D9F2A026504928C017944E149_837490687.addTaint(taint);
        return var74E4690D9F2A026504928C017944E149_837490687;
        // ---------- Original Method ----------
        //if (priority == null)
            //throw new NullPointerException("bad priority arg");
        //Priority p = new Priority();
        //p.setPriority(priority);
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.498 -0400", hash_original_method = "E2D1E713D6EFBD9B5EF73CE359255B39", hash_generated_method = "5357A4F7A10E58E2DAF77A7313471EB1")
    public ProxyAuthenticateHeader createProxyAuthenticateHeader(String scheme) throws ParseException {
        addTaint(scheme.getTaint());
    if(scheme == null)        
        {
        NullPointerException varA0F89B53E83988ECCB3AD3510E40DE72_2054498533 = new NullPointerException("bad scheme arg");
        varA0F89B53E83988ECCB3AD3510E40DE72_2054498533.addTaint(taint);
        throw varA0F89B53E83988ECCB3AD3510E40DE72_2054498533;
        }
        ProxyAuthenticate p = new ProxyAuthenticate();
        p.setScheme(scheme);
ProxyAuthenticateHeader var74E4690D9F2A026504928C017944E149_1362762815 =         p;
        var74E4690D9F2A026504928C017944E149_1362762815.addTaint(taint);
        return var74E4690D9F2A026504928C017944E149_1362762815;
        // ---------- Original Method ----------
        //if (scheme == null)
            //throw new NullPointerException("bad scheme arg");
        //ProxyAuthenticate p = new ProxyAuthenticate();
        //p.setScheme(scheme);
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.498 -0400", hash_original_method = "E046B5DACDD94AD026F81045FF391CD1", hash_generated_method = "82405F5F286E2A538312B7ABB1925F38")
    public ProxyAuthorizationHeader createProxyAuthorizationHeader(String scheme) throws ParseException {
        addTaint(scheme.getTaint());
    if(scheme == null)        
        {
        NullPointerException varA0F89B53E83988ECCB3AD3510E40DE72_1820483039 = new NullPointerException("bad scheme arg");
        varA0F89B53E83988ECCB3AD3510E40DE72_1820483039.addTaint(taint);
        throw varA0F89B53E83988ECCB3AD3510E40DE72_1820483039;
        }
        ProxyAuthorization p = new ProxyAuthorization();
        p.setScheme(scheme);
ProxyAuthorizationHeader var74E4690D9F2A026504928C017944E149_1853552893 =         p;
        var74E4690D9F2A026504928C017944E149_1853552893.addTaint(taint);
        return var74E4690D9F2A026504928C017944E149_1853552893;
        // ---------- Original Method ----------
        //if (scheme == null)
            //throw new NullPointerException("bad scheme arg");
        //ProxyAuthorization p = new ProxyAuthorization();
        //p.setScheme(scheme);
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.498 -0400", hash_original_method = "A059B8FD47D8FC83321E2DEF4CB18490", hash_generated_method = "FCF996CF1FDE86F92E8CEEF92530B7A0")
    public ProxyRequireHeader createProxyRequireHeader(String optionTag) throws ParseException {
        addTaint(optionTag.getTaint());
    if(optionTag == null)        
        {
        NullPointerException var386549F2204FFC26DF882B52B7F0CF19_1447228510 = new NullPointerException("bad optionTag arg");
        var386549F2204FFC26DF882B52B7F0CF19_1447228510.addTaint(taint);
        throw var386549F2204FFC26DF882B52B7F0CF19_1447228510;
        }
        ProxyRequire p = new ProxyRequire();
        p.setOptionTag(optionTag);
ProxyRequireHeader var74E4690D9F2A026504928C017944E149_1492123097 =         p;
        var74E4690D9F2A026504928C017944E149_1492123097.addTaint(taint);
        return var74E4690D9F2A026504928C017944E149_1492123097;
        // ---------- Original Method ----------
        //if (optionTag == null)
            //throw new NullPointerException("bad optionTag arg");
        //ProxyRequire p = new ProxyRequire();
        //p.setOptionTag(optionTag);
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.499 -0400", hash_original_method = "42539302BE9490416DF1DC01B8BC3D99", hash_generated_method = "8560E9494BB828A83E09B99E3CDAE5E6")
    public RAckHeader createRAckHeader(
        long rSeqNumber,
        long cSeqNumber,
        String method) throws InvalidArgumentException, ParseException {
        addTaint(method.getTaint());
        addTaint(cSeqNumber);
        addTaint(rSeqNumber);
    if(method == null)        
        {
        NullPointerException var8A31632CC81FE67E278C798F8DC0B26E_386354195 = new NullPointerException("Bad method");
        var8A31632CC81FE67E278C798F8DC0B26E_386354195.addTaint(taint);
        throw var8A31632CC81FE67E278C798F8DC0B26E_386354195;
        }
    if(cSeqNumber < 0 || rSeqNumber < 0)        
        {
        InvalidArgumentException var70D6FD986849A7980BD21CE67C3313D2_1438126394 = new InvalidArgumentException("bad cseq/rseq arg");
        var70D6FD986849A7980BD21CE67C3313D2_1438126394.addTaint(taint);
        throw var70D6FD986849A7980BD21CE67C3313D2_1438126394;
        }
        RAck rack = new RAck();
        rack.setMethod(method);
        rack.setCSequenceNumber(cSeqNumber);
        rack.setRSequenceNumber(rSeqNumber);
RAckHeader var55285630369F90A1D1B24F624C06D15F_1682883707 =         rack;
        var55285630369F90A1D1B24F624C06D15F_1682883707.addTaint(taint);
        return var55285630369F90A1D1B24F624C06D15F_1682883707;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.499 -0400", hash_original_method = "B44C2BD23DFFCB51A992C42D93BADE4E", hash_generated_method = "77D81DF05A08442C2B9AE8E812F9F648")
    public RAckHeader createRAckHeader(int rSeqNumber, int cSeqNumber, String method) throws InvalidArgumentException, ParseException {
        addTaint(method.getTaint());
        addTaint(cSeqNumber);
        addTaint(rSeqNumber);
RAckHeader var0DFEE96A820BC9D494DCB5F0837AAF6A_806597186 =         createRAckHeader((long)rSeqNumber, (long)cSeqNumber, method);
        var0DFEE96A820BC9D494DCB5F0837AAF6A_806597186.addTaint(taint);
        return var0DFEE96A820BC9D494DCB5F0837AAF6A_806597186;
        // ---------- Original Method ----------
        //return createRAckHeader((long)rSeqNumber, (long)cSeqNumber, method);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.500 -0400", hash_original_method = "38086BF4D4EB3CE5AB4BF7772F8EACF2", hash_generated_method = "3540F631E62F4D6FB03B3AF2366FF87A")
    public RSeqHeader createRSeqHeader(int sequenceNumber) throws InvalidArgumentException {
        addTaint(sequenceNumber);
RSeqHeader var1B9DD1E25CC91263F0C8D46DE9A85E59_740280725 =         createRSeqHeader((long) sequenceNumber);
        var1B9DD1E25CC91263F0C8D46DE9A85E59_740280725.addTaint(taint);
        return var1B9DD1E25CC91263F0C8D46DE9A85E59_740280725;
        // ---------- Original Method ----------
        //return createRSeqHeader((long) sequenceNumber) ;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.500 -0400", hash_original_method = "CA4CA07B31DF6CB609C05636F40DB22F", hash_generated_method = "E33ADEEC5A461AFB5940B489E63C180C")
    public RSeqHeader createRSeqHeader(long sequenceNumber) throws InvalidArgumentException {
        addTaint(sequenceNumber);
    if(sequenceNumber < 0)        
        {
        InvalidArgumentException varBFDDAC68A0E1346F06A7F4105BB5D866_1786496491 = new InvalidArgumentException(
                "invalid sequenceNumber arg " + sequenceNumber);
        varBFDDAC68A0E1346F06A7F4105BB5D866_1786496491.addTaint(taint);
        throw varBFDDAC68A0E1346F06A7F4105BB5D866_1786496491;
        }
        RSeq rseq = new RSeq();
        rseq.setSeqNumber(sequenceNumber);
RSeqHeader varB6E01D29654A1562BB86607DADA039F5_1160213020 =         rseq;
        varB6E01D29654A1562BB86607DADA039F5_1160213020.addTaint(taint);
        return varB6E01D29654A1562BB86607DADA039F5_1160213020;
        // ---------- Original Method ----------
        //if (sequenceNumber < 0)
            //throw new InvalidArgumentException(
                //"invalid sequenceNumber arg " + sequenceNumber);
        //RSeq rseq = new RSeq();
        //rseq.setSeqNumber(sequenceNumber);
        //return rseq;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.501 -0400", hash_original_method = "57AD0B4E4FE03197F2B52972D6060CBA", hash_generated_method = "D972F7A645ACAD95BCFE8C4DA89D001C")
    public ReasonHeader createReasonHeader(
        String protocol,
        int cause,
        String text) throws InvalidArgumentException, ParseException {
        addTaint(text.getTaint());
        addTaint(cause);
        addTaint(protocol.getTaint());
    if(protocol == null)        
        {
        NullPointerException var29C0CEBB847CB5119F14B332EA879C4A_1834677571 = new NullPointerException("bad protocol arg");
        var29C0CEBB847CB5119F14B332EA879C4A_1834677571.addTaint(taint);
        throw var29C0CEBB847CB5119F14B332EA879C4A_1834677571;
        }
    if(cause < 0)        
        {
        InvalidArgumentException varF711110E46579A941898B39DFD04655B_569708972 = new InvalidArgumentException("bad cause");
        varF711110E46579A941898B39DFD04655B_569708972.addTaint(taint);
        throw varF711110E46579A941898B39DFD04655B_569708972;
        }
        Reason reason = new Reason();
        reason.setProtocol(protocol);
        reason.setCause(cause);
        reason.setText(text);
ReasonHeader varD602C4C1684F7464133CA1A6851CC44A_343902434 =         reason;
        varD602C4C1684F7464133CA1A6851CC44A_343902434.addTaint(taint);
        return varD602C4C1684F7464133CA1A6851CC44A_343902434;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.501 -0400", hash_original_method = "6DA29D8692407706B9B05391AF333993", hash_generated_method = "DC8DB6629914A0DDC1A07556B11EE7BA")
    public RecordRouteHeader createRecordRouteHeader(Address address) {
        addTaint(address.getTaint());
    if(address == null)        
        {
        NullPointerException var2E325D1E8870351157D8C6AB415344DD_828532758 = new NullPointerException("Null argument!");
        var2E325D1E8870351157D8C6AB415344DD_828532758.addTaint(taint);
        throw var2E325D1E8870351157D8C6AB415344DD_828532758;
        }
        RecordRoute recordRoute = new RecordRoute();
        recordRoute.setAddress(address);
RecordRouteHeader varA6E6B75E47735133E1A83569179469B8_142791152 =         recordRoute;
        varA6E6B75E47735133E1A83569179469B8_142791152.addTaint(taint);
        return varA6E6B75E47735133E1A83569179469B8_142791152;
        // ---------- Original Method ----------
        //if ( address == null) throw new NullPointerException("Null argument!");
        //RecordRoute recordRoute = new RecordRoute();
        //recordRoute.setAddress(address);
        //return recordRoute;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.502 -0400", hash_original_method = "4393C033D6B63EF338EB93DE3E753573", hash_generated_method = "1468E468BBACF93684FF1FE2A6E30CD7")
    public ReplyToHeader createReplyToHeader(Address address) {
        addTaint(address.getTaint());
    if(address == null)        
        {
        NullPointerException var3DC5AE26648CEFA4BB39A1606DD56EB1_1395267040 = new NullPointerException("null address");
        var3DC5AE26648CEFA4BB39A1606DD56EB1_1395267040.addTaint(taint);
        throw var3DC5AE26648CEFA4BB39A1606DD56EB1_1395267040;
        }
        ReplyTo replyTo = new ReplyTo();
        replyTo.setAddress(address);
ReplyToHeader var43C4044FC3C522AE3C13CF309B9542DA_821439541 =         replyTo;
        var43C4044FC3C522AE3C13CF309B9542DA_821439541.addTaint(taint);
        return var43C4044FC3C522AE3C13CF309B9542DA_821439541;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address");
        //ReplyTo replyTo = new ReplyTo();
        //replyTo.setAddress(address);
        //return replyTo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.502 -0400", hash_original_method = "F65B5EA444DA08358E800CD7B469501A", hash_generated_method = "1C8D4D4A789ABBE18445FBE15884C1F3")
    public RequireHeader createRequireHeader(String optionTag) throws ParseException {
        addTaint(optionTag.getTaint());
    if(optionTag == null)        
        {
        NullPointerException varBB3EE5E771CE88EAE9D5CF28870DCD80_1939965879 = new NullPointerException("null optionTag");
        varBB3EE5E771CE88EAE9D5CF28870DCD80_1939965879.addTaint(taint);
        throw varBB3EE5E771CE88EAE9D5CF28870DCD80_1939965879;
        }
        Require require = new Require();
        require.setOptionTag(optionTag);
RequireHeader varED3A0ADDA3171B6DFFBE81FB8135FA28_1335154057 =         require;
        varED3A0ADDA3171B6DFFBE81FB8135FA28_1335154057.addTaint(taint);
        return varED3A0ADDA3171B6DFFBE81FB8135FA28_1335154057;
        // ---------- Original Method ----------
        //if (optionTag == null)
            //throw new NullPointerException("null optionTag");
        //Require require = new Require();
        //require.setOptionTag(optionTag);
        //return require;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.502 -0400", hash_original_method = "43D5E8C96E4C1ED3ED5B8AD5C39C801C", hash_generated_method = "2D144FFCE487FB5CDD4CE74C3A09AE80")
    public RetryAfterHeader createRetryAfterHeader(int retryAfter) throws InvalidArgumentException {
        addTaint(retryAfter);
    if(retryAfter < 0)        
        {
        InvalidArgumentException var5E335D663753BAA1818B3637467CA5D7_1609164790 = new InvalidArgumentException("bad retryAfter arg");
        var5E335D663753BAA1818B3637467CA5D7_1609164790.addTaint(taint);
        throw var5E335D663753BAA1818B3637467CA5D7_1609164790;
        }
        RetryAfter r = new RetryAfter();
        r.setRetryAfter(retryAfter);
RetryAfterHeader var4C1F3C86A0E56B6E375080F5F710547E_1946321890 =         r;
        var4C1F3C86A0E56B6E375080F5F710547E_1946321890.addTaint(taint);
        return var4C1F3C86A0E56B6E375080F5F710547E_1946321890;
        // ---------- Original Method ----------
        //if (retryAfter < 0)
            //throw new InvalidArgumentException("bad retryAfter arg");
        //RetryAfter r = new RetryAfter();
        //r.setRetryAfter(retryAfter);
        //return r;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.503 -0400", hash_original_method = "03611E3BB30258B8EC4FDC9F783CBCCF", hash_generated_method = "3525C43165113F0F71308307CBFAC38E")
    public RouteHeader createRouteHeader(Address address) {
        addTaint(address.getTaint());
    if(address == null)        
        {
        NullPointerException varB13A65CC050DE58641D8F0978770CC55_605252407 = new NullPointerException("null address arg");
        varB13A65CC050DE58641D8F0978770CC55_605252407.addTaint(taint);
        throw varB13A65CC050DE58641D8F0978770CC55_605252407;
        }
        Route route = new Route();
        route.setAddress(address);
RouteHeader var6679678B82FF79D06F753D1737D68FA6_700810052 =         route;
        var6679678B82FF79D06F753D1737D68FA6_700810052.addTaint(taint);
        return var6679678B82FF79D06F753D1737D68FA6_700810052;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address arg");
        //Route route = new Route();
        //route.setAddress(address);
        //return route;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.503 -0400", hash_original_method = "65AF02D93E753F97E0AF00F542D03529", hash_generated_method = "3794D0CF31476D626A72B14E21FEB83E")
    public ServerHeader createServerHeader(List product) throws ParseException {
        addTaint(product.getTaint());
    if(product == null)        
        {
        NullPointerException var1C78C0F8472931B367DDD776F0D85910_313111543 = new NullPointerException("null productList arg");
        var1C78C0F8472931B367DDD776F0D85910_313111543.addTaint(taint);
        throw var1C78C0F8472931B367DDD776F0D85910_313111543;
        }
        Server server = new Server();
        server.setProduct(product);
ServerHeader varCF007A6E73A4D4959380322938EA0E3D_2005593309 =         server;
        varCF007A6E73A4D4959380322938EA0E3D_2005593309.addTaint(taint);
        return varCF007A6E73A4D4959380322938EA0E3D_2005593309;
        // ---------- Original Method ----------
        //if (product == null)
            //throw new NullPointerException("null productList arg");
        //Server server = new Server();
        //server.setProduct(product);
        //return server;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.504 -0400", hash_original_method = "288EA55C0FFC9E81469649B581E59F71", hash_generated_method = "7FD1BEC8801A0F3F66E91E0A847BDC1A")
    public SubjectHeader createSubjectHeader(String subject) throws ParseException {
        addTaint(subject.getTaint());
    if(subject == null)        
        {
        NullPointerException var8220919DE52863BEED16FB185B602832_2045827954 = new NullPointerException("null subject arg");
        var8220919DE52863BEED16FB185B602832_2045827954.addTaint(taint);
        throw var8220919DE52863BEED16FB185B602832_2045827954;
        }
        Subject s = new Subject();
        s.setSubject(subject);
SubjectHeader var0478718F0636FB61899C13801CE9FE09_462735442 =         s;
        var0478718F0636FB61899C13801CE9FE09_462735442.addTaint(taint);
        return var0478718F0636FB61899C13801CE9FE09_462735442;
        // ---------- Original Method ----------
        //if (subject == null)
            //throw new NullPointerException("null subject arg");
        //Subject s = new Subject();
        //s.setSubject(subject);
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.505 -0400", hash_original_method = "9B68B72DA8144991BC14639C6BE11723", hash_generated_method = "42291ACF33D3E174EC8C92E5F775139F")
    public SubscriptionStateHeader createSubscriptionStateHeader(String subscriptionState) throws ParseException {
        addTaint(subscriptionState.getTaint());
    if(subscriptionState == null)        
        {
        NullPointerException var381DF38433050ABB414F5C86AFE9F070_608742924 = new NullPointerException("null subscriptionState arg");
        var381DF38433050ABB414F5C86AFE9F070_608742924.addTaint(taint);
        throw var381DF38433050ABB414F5C86AFE9F070_608742924;
        }
        SubscriptionState s = new SubscriptionState();
        s.setState(subscriptionState);
SubscriptionStateHeader var0478718F0636FB61899C13801CE9FE09_808176758 =         s;
        var0478718F0636FB61899C13801CE9FE09_808176758.addTaint(taint);
        return var0478718F0636FB61899C13801CE9FE09_808176758;
        // ---------- Original Method ----------
        //if (subscriptionState == null)
            //throw new NullPointerException("null subscriptionState arg");
        //SubscriptionState s = new SubscriptionState();
        //s.setState(subscriptionState);
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.506 -0400", hash_original_method = "589849ECCDAFDA20BE0DBE1D9A436669", hash_generated_method = "D6414CF72313354633AF42ED2EB6F338")
    public SupportedHeader createSupportedHeader(String optionTag) throws ParseException {
        addTaint(optionTag.getTaint());
    if(optionTag == null)        
        {
        NullPointerException var197E1CE6AE56D4596090EA3D944C6875_324372769 = new NullPointerException("null optionTag arg");
        var197E1CE6AE56D4596090EA3D944C6875_324372769.addTaint(taint);
        throw var197E1CE6AE56D4596090EA3D944C6875_324372769;
        }
        Supported supported = new Supported();
        supported.setOptionTag(optionTag);
SupportedHeader varA336F51205FB983FAB754C908A4BC849_1780772954 =         supported;
        varA336F51205FB983FAB754C908A4BC849_1780772954.addTaint(taint);
        return varA336F51205FB983FAB754C908A4BC849_1780772954;
        // ---------- Original Method ----------
        //if (optionTag == null)
            //throw new NullPointerException("null optionTag arg");
        //Supported supported = new Supported();
        //supported.setOptionTag(optionTag);
        //return supported;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.506 -0400", hash_original_method = "380079DA7F92D6CF2CEA9086AA5F92D7", hash_generated_method = "46978CBB7CC986458B3080AD127652AE")
    public TimeStampHeader createTimeStampHeader(float timeStamp) throws InvalidArgumentException {
        addTaint(timeStamp);
    if(timeStamp < 0)        
        {
        IllegalArgumentException var0B7CE32DADC88EFC0D72F5BEE4FB479E_883640805 = new IllegalArgumentException("illegal timeStamp");
        var0B7CE32DADC88EFC0D72F5BEE4FB479E_883640805.addTaint(taint);
        throw var0B7CE32DADC88EFC0D72F5BEE4FB479E_883640805;
        }
        TimeStamp t = new TimeStamp();
        t.setTimeStamp(timeStamp);
TimeStampHeader varE0D714D758F1540A8DF364A965AF9150_1233615006 =         t;
        varE0D714D758F1540A8DF364A965AF9150_1233615006.addTaint(taint);
        return varE0D714D758F1540A8DF364A965AF9150_1233615006;
        // ---------- Original Method ----------
        //if (timeStamp < 0)
            //throw new IllegalArgumentException("illegal timeStamp");
        //TimeStamp t = new TimeStamp();
        //t.setTimeStamp(timeStamp);
        //return t;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.507 -0400", hash_original_method = "7928C6AF630E4BCE57D31FA4979B7453", hash_generated_method = "8F0B4C0BEB1FB67B825D8E96952C553B")
    public ToHeader createToHeader(Address address, String tag) throws ParseException {
        addTaint(tag.getTaint());
        addTaint(address.getTaint());
    if(address == null)        
        {
        NullPointerException var3DC5AE26648CEFA4BB39A1606DD56EB1_912162435 = new NullPointerException("null address");
        var3DC5AE26648CEFA4BB39A1606DD56EB1_912162435.addTaint(taint);
        throw var3DC5AE26648CEFA4BB39A1606DD56EB1_912162435;
        }
        To to = new To();
        to.setAddress(address);
    if(tag != null)        
        to.setTag(tag);
ToHeader var26633470D0AEBDC975B85A12020B47EA_1790666234 =         to;
        var26633470D0AEBDC975B85A12020B47EA_1790666234.addTaint(taint);
        return var26633470D0AEBDC975B85A12020B47EA_1790666234;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address");
        //To to = new To();
        //to.setAddress(address);
        //if (tag != null)
            //to.setTag(tag);
        //return to;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.508 -0400", hash_original_method = "9A62FFB59334167B71BC2FE402276C31", hash_generated_method = "EA74A541D95CDD47BAB5633346EF0C41")
    public UnsupportedHeader createUnsupportedHeader(String optionTag) throws ParseException {
        addTaint(optionTag.getTaint());
    if(optionTag == null)        
        {
        NullPointerException var23FAE4DD19C0C26206FBF7D1B5A32522_2022881376 = new NullPointerException(optionTag);
        var23FAE4DD19C0C26206FBF7D1B5A32522_2022881376.addTaint(taint);
        throw var23FAE4DD19C0C26206FBF7D1B5A32522_2022881376;
        }
        Unsupported unsupported = new Unsupported();
        unsupported.setOptionTag(optionTag);
UnsupportedHeader var2C8D6A66521E13DFB3C6622EE99EBB01_1273018454 =         unsupported;
        var2C8D6A66521E13DFB3C6622EE99EBB01_1273018454.addTaint(taint);
        return var2C8D6A66521E13DFB3C6622EE99EBB01_1273018454;
        // ---------- Original Method ----------
        //if (optionTag == null)
            //throw new NullPointerException(optionTag);
        //Unsupported unsupported = new Unsupported();
        //unsupported.setOptionTag(optionTag);
        //return unsupported;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.508 -0400", hash_original_method = "0FDDC4550D32FE0A8E48193D044787BB", hash_generated_method = "04E48530975A6FBB41A889D35FFE89E0")
    public UserAgentHeader createUserAgentHeader(List product) throws ParseException {
        addTaint(product.getTaint());
    if(product == null)        
        {
        NullPointerException var4BCA999F6C649C38D36E052754075631_450942351 = new NullPointerException("null user agent");
        var4BCA999F6C649C38D36E052754075631_450942351.addTaint(taint);
        throw var4BCA999F6C649C38D36E052754075631_450942351;
        }
        UserAgent userAgent = new UserAgent();
        userAgent.setProduct(product);
UserAgentHeader varB90BAE9CF13799DF66AC7440F5DAE3DA_848747652 =         userAgent;
        varB90BAE9CF13799DF66AC7440F5DAE3DA_848747652.addTaint(taint);
        return varB90BAE9CF13799DF66AC7440F5DAE3DA_848747652;
        // ---------- Original Method ----------
        //if (product == null)
            //throw new NullPointerException("null user agent");
        //UserAgent userAgent = new UserAgent();
        //userAgent.setProduct(product);
        //return userAgent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.509 -0400", hash_original_method = "B7A9F5DC521617567AEB2EDF2366DE24", hash_generated_method = "7DAA02B7D3152FB3F2D61C532BE60203")
    public ViaHeader createViaHeader(
        String host,
        int port,
        String transport,
        String branch) throws ParseException, InvalidArgumentException {
        addTaint(branch.getTaint());
        addTaint(transport.getTaint());
        addTaint(port);
        addTaint(host.getTaint());
    if(host == null || transport == null)        
        {
        NullPointerException varCF8D07C80828DCBD1FC1EB16BCF7D0F2_1208807770 = new NullPointerException("null arg");
        varCF8D07C80828DCBD1FC1EB16BCF7D0F2_1208807770.addTaint(taint);
        throw varCF8D07C80828DCBD1FC1EB16BCF7D0F2_1208807770;
        }
        Via via = new Via();
    if(branch != null)        
        via.setBranch(branch);
    if(host.indexOf(':') >= 0
            && host.indexOf('[') < 0)        
        {
    if(stripAddressScopeZones)            
            {
                int zoneStart = host.indexOf('%');
    if(zoneStart != -1)                
                host = host.substring(0, zoneStart);
            } //End block
            host = '[' + host + ']';
        } //End block
        via.setHost(host);
        via.setPort(port);
        via.setTransport(transport);
ViaHeader var744F9AD2C48AA2D9C877F464ADEF2D12_1258758580 =         via;
        var744F9AD2C48AA2D9C877F464ADEF2D12_1258758580.addTaint(taint);
        return var744F9AD2C48AA2D9C877F464ADEF2D12_1258758580;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.510 -0400", hash_original_method = "EDE3AD5442B3DE671B6476C917BB6D0F", hash_generated_method = "29D38E8DFBD81CFC0C5EDAF5A6BBAE73")
    public WWWAuthenticateHeader createWWWAuthenticateHeader(String scheme) throws ParseException {
        addTaint(scheme.getTaint());
    if(scheme == null)        
        {
        NullPointerException var1AEA5D4F366FD331D1B5DABFEA649E98_1400080560 = new NullPointerException("null scheme");
        var1AEA5D4F366FD331D1B5DABFEA649E98_1400080560.addTaint(taint);
        throw var1AEA5D4F366FD331D1B5DABFEA649E98_1400080560;
        }
        WWWAuthenticate www = new WWWAuthenticate();
        www.setScheme(scheme);
WWWAuthenticateHeader var373D84FA8665DACE10DFF8065F46F380_1465237623 =         www;
        var373D84FA8665DACE10DFF8065F46F380_1465237623.addTaint(taint);
        return var373D84FA8665DACE10DFF8065F46F380_1465237623;
        // ---------- Original Method ----------
        //if (scheme == null)
            //throw new NullPointerException("null scheme");
        //WWWAuthenticate www = new WWWAuthenticate();
        //www.setScheme(scheme);
        //return www;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.510 -0400", hash_original_method = "F34478A6D1616AB2836BA2A212AE0D49", hash_generated_method = "3318C601BBBFF6570F5F862B3BC1EB43")
    public WarningHeader createWarningHeader(
        String agent,
        int code,
        String comment) throws ParseException, InvalidArgumentException {
        addTaint(comment.getTaint());
        addTaint(code);
        addTaint(agent.getTaint());
    if(agent == null)        
        {
        NullPointerException varCF8D07C80828DCBD1FC1EB16BCF7D0F2_1281103918 = new NullPointerException("null arg");
        varCF8D07C80828DCBD1FC1EB16BCF7D0F2_1281103918.addTaint(taint);
        throw varCF8D07C80828DCBD1FC1EB16BCF7D0F2_1281103918;
        }
        Warning warning = new Warning();
        warning.setAgent(agent);
        warning.setCode(code);
        warning.setText(comment);
WarningHeader var8A39DBFB7207495DDB5D7A9A922E3CEC_1023405171 =         warning;
        var8A39DBFB7207495DDB5D7A9A922E3CEC_1023405171.addTaint(taint);
        return var8A39DBFB7207495DDB5D7A9A922E3CEC_1023405171;
        // ---------- Original Method ----------
        //if (agent == null)
            //throw new NullPointerException("null arg");
        //Warning warning = new Warning();
        //warning.setAgent(agent);
        //warning.setCode(code);
        //warning.setText(comment);
        //return warning;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.510 -0400", hash_original_method = "CB42C1424760C62123C05E2F8CB60B35", hash_generated_method = "0444EF64AF19D833802F44B9C59C4412")
    public ErrorInfoHeader createErrorInfoHeader(URI errorInfo) {
        addTaint(errorInfo.getTaint());
    if(errorInfo == null)        
        {
        NullPointerException varCF8D07C80828DCBD1FC1EB16BCF7D0F2_1319371898 = new NullPointerException("null arg");
        varCF8D07C80828DCBD1FC1EB16BCF7D0F2_1319371898.addTaint(taint);
        throw varCF8D07C80828DCBD1FC1EB16BCF7D0F2_1319371898;
        }
ErrorInfoHeader varAC4EE33C2B0252F0E59C54FCD6BACAA8_1389740758 =         new ErrorInfo((GenericURI) errorInfo);
        varAC4EE33C2B0252F0E59C54FCD6BACAA8_1389740758.addTaint(taint);
        return varAC4EE33C2B0252F0E59C54FCD6BACAA8_1389740758;
        // ---------- Original Method ----------
        //if (errorInfo == null)
            //throw new NullPointerException("null arg");
        //return new ErrorInfo((GenericURI) errorInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.511 -0400", hash_original_method = "7E6122EDAE408D205AF0C9E45A024F04", hash_generated_method = "931DCF2BB138EEB0A6B4CE80BA126F34")
    public javax.sip.header.Header createHeader(String headerText) throws ParseException {
        addTaint(headerText.getTaint());
        StringMsgParser smp = new StringMsgParser();
        SIPHeader sipHeader = smp.parseSIPHeader(headerText.trim());
    if(sipHeader instanceof SIPHeaderList)        
        {
    if(((SIPHeaderList) sipHeader).size() > 1)            
            {
                ParseException var1955A4930226679B2CEA0C0577B95C61_215026446 = new ParseException(
                    "Only singleton allowed " + headerText,
                    0);
                var1955A4930226679B2CEA0C0577B95C61_215026446.addTaint(taint);
                throw var1955A4930226679B2CEA0C0577B95C61_215026446;
            } //End block
            else
    if(((SIPHeaderList) sipHeader).size() == 0)            
            {
                try 
                {
javax.sip.header.Header varB295316523F2A72D2F3C14B49031D525_1051403497 =                     (Header) ((SIPHeaderList) sipHeader)
                        .getMyClass()
                        .newInstance();
                    varB295316523F2A72D2F3C14B49031D525_1051403497.addTaint(taint);
                    return varB295316523F2A72D2F3C14B49031D525_1051403497;
                } //End block
                catch (InstantiationException ex)
                {
                    ex.printStackTrace();
javax.sip.header.Header var540C13E9E156B687226421B24F2DF178_498816369 =                     null;
                    var540C13E9E156B687226421B24F2DF178_498816369.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_498816369;
                } //End block
                catch (IllegalAccessException ex)
                {
                    ex.printStackTrace();
javax.sip.header.Header var540C13E9E156B687226421B24F2DF178_281464460 =                     null;
                    var540C13E9E156B687226421B24F2DF178_281464460.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_281464460;
                } //End block
            } //End block
            else
            {
javax.sip.header.Header var7CAD833627878FD3F7B863ACAAFB2E71_416512550 =                 (Header) ((SIPHeaderList) sipHeader).getFirst();
                var7CAD833627878FD3F7B863ACAAFB2E71_416512550.addTaint(taint);
                return var7CAD833627878FD3F7B863ACAAFB2E71_416512550;
            } //End block
        } //End block
        else
        {
javax.sip.header.Header varDF77B5B4168F45421B89B792E9510A4B_1466634192 =             (Header) sipHeader;
            varDF77B5B4168F45421B89B792E9510A4B_1466634192.addTaint(taint);
            return varDF77B5B4168F45421B89B792E9510A4B_1466634192;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.512 -0400", hash_original_method = "BE8A77015DA0080195A899A1BFDA2B08", hash_generated_method = "33BCC67C8B654E6EFE3891C229FAE971")
    public javax.sip.header.Header createHeader(
        String headerName,
        String headerValue) throws java.text.ParseException {
        addTaint(headerValue.getTaint());
        addTaint(headerName.getTaint());
    if(headerName == null)        
        {
        NullPointerException var733D8B70EC4B32137CE05F03DD83A4E5_43812144 = new NullPointerException("header name is null");
        var733D8B70EC4B32137CE05F03DD83A4E5_43812144.addTaint(taint);
        throw var733D8B70EC4B32137CE05F03DD83A4E5_43812144;
        }
        String hdrText = new StringBuffer()
                .append(headerName)
                .append(":")
                .append(headerValue)
                .toString();
javax.sip.header.Header varBD16535AB9329533F3A0DEDB01A35333_1715179378 =         createHeader(hdrText);
        varBD16535AB9329533F3A0DEDB01A35333_1715179378.addTaint(taint);
        return varBD16535AB9329533F3A0DEDB01A35333_1715179378;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.512 -0400", hash_original_method = "FDCDF9463F1CDDAF0BCBB63B8B4D05F5", hash_generated_method = "A818F082763FAF1087500C5FA56E57C7")
    public java.util.List createHeaders(String headers) throws java.text.ParseException {
        addTaint(headers.getTaint());
    if(headers == null)        
        {
        NullPointerException var46DC74EA01AD115A93A248B83CD80DF3_1364085157 = new NullPointerException("null arg!");
        var46DC74EA01AD115A93A248B83CD80DF3_1364085157.addTaint(taint);
        throw var46DC74EA01AD115A93A248B83CD80DF3_1364085157;
        }
        StringMsgParser smp = new StringMsgParser();
        SIPHeader shdr = smp.parseSIPHeader(headers);
    if(shdr instanceof SIPHeaderList)        
        {
java.util.List varC9B92F5DCD806E11915358BFB63728E4_1012119137 =         (SIPHeaderList) shdr;
        varC9B92F5DCD806E11915358BFB63728E4_1012119137.addTaint(taint);
        return varC9B92F5DCD806E11915358BFB63728E4_1012119137;
        }
        else
        {
        ParseException var36D31F0E791914E00297F2507AD0EF01_1569393652 = new ParseException(
                "List of headers of this type is not allowed in a message",
                0);
        var36D31F0E791914E00297F2507AD0EF01_1569393652.addTaint(taint);
        throw var36D31F0E791914E00297F2507AD0EF01_1569393652;
        }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.513 -0400", hash_original_method = "5541F8A2ED86060178CAD1F0D5BA2507", hash_generated_method = "D5A03E1D685456420D4CD9E3CC273801")
    public ReferToHeader createReferToHeader(Address address) {
        addTaint(address.getTaint());
    if(address == null)        
        {
        NullPointerException varE8525DFA678FE47A97D101FCF8E1FD9C_1830334982 = new NullPointerException("null address!");
        varE8525DFA678FE47A97D101FCF8E1FD9C_1830334982.addTaint(taint);
        throw varE8525DFA678FE47A97D101FCF8E1FD9C_1830334982;
        }
        ReferTo referTo = new ReferTo();
        referTo.setAddress(address);
ReferToHeader varF03467BD7719B93D23F3A1857BAA9912_1976555155 =         referTo;
        varF03467BD7719B93D23F3A1857BAA9912_1976555155.addTaint(taint);
        return varF03467BD7719B93D23F3A1857BAA9912_1976555155;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address!");
        //ReferTo referTo = new ReferTo();
        //referTo.setAddress(address);
        //return referTo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.513 -0400", hash_original_method = "A51D0E58D36C2041DD351AE4FDD73BCF", hash_generated_method = "080D71B133D068E2AFC41714C1D30A90")
    public ReferredByHeader createReferredByHeader(Address address) {
        addTaint(address.getTaint());
    if(address == null)        
        {
        NullPointerException varE8525DFA678FE47A97D101FCF8E1FD9C_202336968 = new NullPointerException("null address!");
        varE8525DFA678FE47A97D101FCF8E1FD9C_202336968.addTaint(taint);
        throw varE8525DFA678FE47A97D101FCF8E1FD9C_202336968;
        }
        ReferredBy referredBy = new ReferredBy();
        referredBy.setAddress(address);
ReferredByHeader var141045FB21A8AF64D1C5F6F1584D6BEE_701605718 =         referredBy;
        var141045FB21A8AF64D1C5F6F1584D6BEE_701605718.addTaint(taint);
        return var141045FB21A8AF64D1C5F6F1584D6BEE_701605718;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address!");
        //ReferredBy referredBy = new ReferredBy();
        //referredBy.setAddress(address);
        //return referredBy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.514 -0400", hash_original_method = "E3BB57144A133C8AFDA0829EAE12FAAB", hash_generated_method = "D59D44F57288F0D2B48F96A3CC46A95E")
    public ReplacesHeader createReplacesHeader(String callId, String toTag,
                String fromTag) throws ParseException {
        addTaint(fromTag.getTaint());
        addTaint(toTag.getTaint());
        addTaint(callId.getTaint());
        Replaces replaces = new Replaces();
        replaces.setCallId(callId);
        replaces.setFromTag(fromTag);
        replaces.setToTag(toTag);
ReplacesHeader varC6183C02DA53C65BFA5F0C5E1854FB03_800955011 =         replaces;
        varC6183C02DA53C65BFA5F0C5E1854FB03_800955011.addTaint(taint);
        return varC6183C02DA53C65BFA5F0C5E1854FB03_800955011;
        // ---------- Original Method ----------
        //Replaces replaces = new Replaces();
        //replaces.setCallId(callId);
        //replaces.setFromTag(fromTag);
        //replaces.setToTag(toTag);
        //return replaces;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.514 -0400", hash_original_method = "C42E665E40D735B4BFD234363CD8C238", hash_generated_method = "B41DA838F99E54DD61867B12447A70F2")
    public JoinHeader createJoinHeader(String callId, String toTag,
                String fromTag) throws ParseException {
        addTaint(fromTag.getTaint());
        addTaint(toTag.getTaint());
        addTaint(callId.getTaint());
        Join join = new Join();
        join.setCallId(callId);
        join.setFromTag(fromTag);
        join.setToTag(toTag);
JoinHeader var59C21E822A750D48D69BB7F7F2BC3BAC_551476813 =         join;
        var59C21E822A750D48D69BB7F7F2BC3BAC_551476813.addTaint(taint);
        return var59C21E822A750D48D69BB7F7F2BC3BAC_551476813;
        // ---------- Original Method ----------
        //Join join = new Join();
        //join.setCallId(callId);
        //join.setFromTag(fromTag);
        //join.setToTag(toTag);
        //return join;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.515 -0400", hash_original_method = "95F88F9209912EE6FCAFCB830227A87B", hash_generated_method = "9D29937CDAAD761E7329C0C015348A46")
    public SIPETagHeader createSIPETagHeader(String etag) throws ParseException {
        addTaint(etag.getTaint());
SIPETagHeader var291CF9A2FF2260285D5CB46C2A704F48_754010820 =         new SIPETag(etag);
        var291CF9A2FF2260285D5CB46C2A704F48_754010820.addTaint(taint);
        return var291CF9A2FF2260285D5CB46C2A704F48_754010820;
        // ---------- Original Method ----------
        //return new SIPETag(etag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.515 -0400", hash_original_method = "9EE2B60A802A938BDC15DDB307A8B1D7", hash_generated_method = "D0BF3A9951B60C4134AFAB96FE29B2A4")
    public SIPIfMatchHeader createSIPIfMatchHeader(String etag) throws ParseException {
        addTaint(etag.getTaint());
SIPIfMatchHeader varB410D690332AF08D0FC018DF0D69B7CE_878373607 =         new SIPIfMatch(etag);
        varB410D690332AF08D0FC018DF0D69B7CE_878373607.addTaint(taint);
        return varB410D690332AF08D0FC018DF0D69B7CE_878373607;
        // ---------- Original Method ----------
        //return new SIPIfMatch(etag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.515 -0400", hash_original_method = "5900AA55EC6D83D47F45CED3D37DDEC7", hash_generated_method = "ECC4506567B3712338EAFF3B851E0B80")
    public PAccessNetworkInfoHeader createPAccessNetworkInfoHeader() {
        PAccessNetworkInfo accessNetworkInfo = new PAccessNetworkInfo();
PAccessNetworkInfoHeader varD15244C320EF41E0D4A4D9B428353746_1801248386 =         accessNetworkInfo;
        varD15244C320EF41E0D4A4D9B428353746_1801248386.addTaint(taint);
        return varD15244C320EF41E0D4A4D9B428353746_1801248386;
        // ---------- Original Method ----------
        //PAccessNetworkInfo accessNetworkInfo = new PAccessNetworkInfo();
        //return accessNetworkInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.515 -0400", hash_original_method = "7A9453157C5A8C4FD99B8F34DC853877", hash_generated_method = "707923BA92AFD8F4E1F21DA2AE0BBAA3")
    public PAssertedIdentityHeader createPAssertedIdentityHeader(Address address) throws NullPointerException, ParseException {
        addTaint(address.getTaint());
    if(address == null)        
        {
        NullPointerException varE8525DFA678FE47A97D101FCF8E1FD9C_1450934820 = new NullPointerException("null address!");
        varE8525DFA678FE47A97D101FCF8E1FD9C_1450934820.addTaint(taint);
        throw varE8525DFA678FE47A97D101FCF8E1FD9C_1450934820;
        }
        PAssertedIdentity assertedIdentity = new PAssertedIdentity();
        assertedIdentity.setAddress(address);
PAssertedIdentityHeader var586CB37773D43E7CD1E709F401C21BB3_423613760 =         assertedIdentity;
        var586CB37773D43E7CD1E709F401C21BB3_423613760.addTaint(taint);
        return var586CB37773D43E7CD1E709F401C21BB3_423613760;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address!");
        //PAssertedIdentity assertedIdentity = new PAssertedIdentity();
        //assertedIdentity.setAddress(address);
        //return assertedIdentity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.516 -0400", hash_original_method = "4BD897B5832A55E4A60E9B49C4611708", hash_generated_method = "44C29D6C97F044AA311C326E03EE61AE")
    public PAssociatedURIHeader createPAssociatedURIHeader(Address assocURI) {
        addTaint(assocURI.getTaint());
    if(assocURI == null)        
        {
        NullPointerException var28221BBD544578F591863E5698989BB4_396951759 = new NullPointerException("null associatedURI!");
        var28221BBD544578F591863E5698989BB4_396951759.addTaint(taint);
        throw var28221BBD544578F591863E5698989BB4_396951759;
        }
        PAssociatedURI associatedURI = new PAssociatedURI();
        associatedURI.setAddress(assocURI);
PAssociatedURIHeader var8DE9C24312E4E28CA8FEED92DFD9E8E3_1656388512 =         associatedURI;
        var8DE9C24312E4E28CA8FEED92DFD9E8E3_1656388512.addTaint(taint);
        return var8DE9C24312E4E28CA8FEED92DFD9E8E3_1656388512;
        // ---------- Original Method ----------
        //if (assocURI == null)
        //throw new NullPointerException("null associatedURI!");
        //PAssociatedURI associatedURI = new PAssociatedURI();
        //associatedURI.setAddress(assocURI);
        //return associatedURI;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.516 -0400", hash_original_method = "FD713420BE4BC11FE9D9AB43BBBEAD30", hash_generated_method = "82B96D577DA1EC97EBBB4BCC44787C50")
    public PCalledPartyIDHeader createPCalledPartyIDHeader(Address address) {
        addTaint(address.getTaint());
    if(address == null)        
        {
        NullPointerException varE8525DFA678FE47A97D101FCF8E1FD9C_1984785325 = new NullPointerException("null address!");
        varE8525DFA678FE47A97D101FCF8E1FD9C_1984785325.addTaint(taint);
        throw varE8525DFA678FE47A97D101FCF8E1FD9C_1984785325;
        }
        PCalledPartyID calledPartyID = new PCalledPartyID();
        calledPartyID.setAddress(address);
PCalledPartyIDHeader var7CED634B91969C8974B3C449C1A23580_1751587548 =         calledPartyID;
        var7CED634B91969C8974B3C449C1A23580_1751587548.addTaint(taint);
        return var7CED634B91969C8974B3C449C1A23580_1751587548;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address!");
        //PCalledPartyID calledPartyID = new PCalledPartyID();
        //calledPartyID.setAddress(address);
        //return calledPartyID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.516 -0400", hash_original_method = "F3DC851C781199B1B5D5ECAC93663797", hash_generated_method = "ACF8D1803DB718553C0B077E6F39E501")
    public PChargingFunctionAddressesHeader createPChargingFunctionAddressesHeader() {
        PChargingFunctionAddresses cfa = new PChargingFunctionAddresses();
PChargingFunctionAddressesHeader varE046E386FC389472A248E17E60EB6DEF_1497493811 =         cfa;
        varE046E386FC389472A248E17E60EB6DEF_1497493811.addTaint(taint);
        return varE046E386FC389472A248E17E60EB6DEF_1497493811;
        // ---------- Original Method ----------
        //PChargingFunctionAddresses cfa = new PChargingFunctionAddresses();
        //return cfa;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.517 -0400", hash_original_method = "E82D256C40CCFC0E4431BA44734EBBF3", hash_generated_method = "EF767636864870236E370A71F3690B3E")
    public PChargingVectorHeader createChargingVectorHeader(String icid) throws ParseException {
        addTaint(icid.getTaint());
    if(icid == null)        
        {
        NullPointerException varFD44068B705D976744414AD0B4B432E4_2146198779 = new NullPointerException("null icid arg!");
        varFD44068B705D976744414AD0B4B432E4_2146198779.addTaint(taint);
        throw varFD44068B705D976744414AD0B4B432E4_2146198779;
        }
        PChargingVector chargingVector = new PChargingVector();
        chargingVector.setICID(icid);
PChargingVectorHeader var14792F8596B417D3663D3E76C47F07C6_1147958720 =         chargingVector;
        var14792F8596B417D3663D3E76C47F07C6_1147958720.addTaint(taint);
        return var14792F8596B417D3663D3E76C47F07C6_1147958720;
        // ---------- Original Method ----------
        //if (icid == null)
        //throw new NullPointerException("null icid arg!");
        //PChargingVector chargingVector = new PChargingVector();
        //chargingVector.setICID(icid);
        //return chargingVector;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.517 -0400", hash_original_method = "FB93C1554D708A44568E0208A3D181E0", hash_generated_method = "531DFB9DEC1ADEAF949DB6332E849454")
    public PMediaAuthorizationHeader createPMediaAuthorizationHeader(String token) throws InvalidArgumentException, ParseException {
        addTaint(token.getTaint());
    if(token == null || token == "")        
        {
        InvalidArgumentException varB7D4EEE3C6AC4EE5886401A42EE1AABD_484348216 = new InvalidArgumentException("The Media-Authorization-Token parameter is null or empty");
        varB7D4EEE3C6AC4EE5886401A42EE1AABD_484348216.addTaint(taint);
        throw varB7D4EEE3C6AC4EE5886401A42EE1AABD_484348216;
        }
        PMediaAuthorization mediaAuthorization = new PMediaAuthorization();
        mediaAuthorization.setMediaAuthorizationToken(token);
PMediaAuthorizationHeader varB5E3A59672490506AE529DA0C24E953C_484848113 =         mediaAuthorization;
        varB5E3A59672490506AE529DA0C24E953C_484848113.addTaint(taint);
        return varB5E3A59672490506AE529DA0C24E953C_484848113;
        // ---------- Original Method ----------
        //if (token == null || token == "")
            //throw new InvalidArgumentException("The Media-Authorization-Token parameter is null or empty");
        //PMediaAuthorization mediaAuthorization = new PMediaAuthorization();
        //mediaAuthorization.setMediaAuthorizationToken(token);
        //return mediaAuthorization;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.517 -0400", hash_original_method = "3BA03116BEA38D71B8C38B4BA62E5B71", hash_generated_method = "97FC7ACEE5540580D994BC31B426EBAD")
    public PPreferredIdentityHeader createPPreferredIdentityHeader(Address address) {
        addTaint(address.getTaint());
    if(address == null)        
        {
        NullPointerException varE8525DFA678FE47A97D101FCF8E1FD9C_1824491656 = new NullPointerException("null address!");
        varE8525DFA678FE47A97D101FCF8E1FD9C_1824491656.addTaint(taint);
        throw varE8525DFA678FE47A97D101FCF8E1FD9C_1824491656;
        }
        PPreferredIdentity preferredIdentity = new PPreferredIdentity();
        preferredIdentity.setAddress(address);
PPreferredIdentityHeader varA31ABC368F16950DF3CB99008CCE7249_266323002 =         preferredIdentity;
        varA31ABC368F16950DF3CB99008CCE7249_266323002.addTaint(taint);
        return varA31ABC368F16950DF3CB99008CCE7249_266323002;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address!");
        //PPreferredIdentity preferredIdentity = new PPreferredIdentity();
        //preferredIdentity.setAddress(address);
        //return preferredIdentity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.518 -0400", hash_original_method = "B32CA202259A9B847AD818F044EE39DA", hash_generated_method = "178D34264F343AE2B3189A8A447C8E24")
    public PVisitedNetworkIDHeader createPVisitedNetworkIDHeader() {
        PVisitedNetworkID visitedNetworkID = new PVisitedNetworkID();
PVisitedNetworkIDHeader var6957EE20ACDD1D79BD41A02CAED798C2_963655421 =         visitedNetworkID;
        var6957EE20ACDD1D79BD41A02CAED798C2_963655421.addTaint(taint);
        return var6957EE20ACDD1D79BD41A02CAED798C2_963655421;
        // ---------- Original Method ----------
        //PVisitedNetworkID visitedNetworkID = new PVisitedNetworkID();
        //return visitedNetworkID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.518 -0400", hash_original_method = "537B18CC29F2C70486994281CB29500B", hash_generated_method = "F7D981101034DC0D465A3383242DF046")
    public PathHeader createPathHeader(Address address) {
        addTaint(address.getTaint());
    if(address == null)        
        {
        NullPointerException varE8525DFA678FE47A97D101FCF8E1FD9C_721550297 = new NullPointerException("null address!");
        varE8525DFA678FE47A97D101FCF8E1FD9C_721550297.addTaint(taint);
        throw varE8525DFA678FE47A97D101FCF8E1FD9C_721550297;
        }
        Path path = new Path();
        path.setAddress(address);
PathHeader var535F4D9720F3B0C96D8143873CE0638C_1954531308 =         path;
        var535F4D9720F3B0C96D8143873CE0638C_1954531308.addTaint(taint);
        return var535F4D9720F3B0C96D8143873CE0638C_1954531308;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address!");
        //Path path = new Path();
        //path.setAddress(address);
        //return path;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.518 -0400", hash_original_method = "85C1BF55B1F968333EFFBCF4DBC75BE6", hash_generated_method = "299E2FD9E18E78865106B18997CCD832")
    public PrivacyHeader createPrivacyHeader(String privacyType) {
        addTaint(privacyType.getTaint());
    if(privacyType == null)        
        {
        NullPointerException var5374F286F8F8B5AB5D244EE7B912AEA8_392728664 = new NullPointerException("null privacyType arg");
        var5374F286F8F8B5AB5D244EE7B912AEA8_392728664.addTaint(taint);
        throw var5374F286F8F8B5AB5D244EE7B912AEA8_392728664;
        }
        Privacy privacy = new Privacy(privacyType);
PrivacyHeader var28A65DCE41136C6290258CACACAD7232_410132373 =         privacy;
        var28A65DCE41136C6290258CACACAD7232_410132373.addTaint(taint);
        return var28A65DCE41136C6290258CACACAD7232_410132373;
        // ---------- Original Method ----------
        //if (privacyType == null)
            //throw new NullPointerException("null privacyType arg");
        //Privacy privacy = new Privacy(privacyType);
        //return privacy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.519 -0400", hash_original_method = "A7CA2EB6DD40139D85B6778D2C783F9F", hash_generated_method = "52A50A02A622B96A32DE5282E7940217")
    public ServiceRouteHeader createServiceRouteHeader(Address address) {
        addTaint(address.getTaint());
    if(address == null)        
        {
        NullPointerException varE8525DFA678FE47A97D101FCF8E1FD9C_1736258639 = new NullPointerException("null address!");
        varE8525DFA678FE47A97D101FCF8E1FD9C_1736258639.addTaint(taint);
        throw varE8525DFA678FE47A97D101FCF8E1FD9C_1736258639;
        }
        ServiceRoute serviceRoute = new ServiceRoute();
        serviceRoute.setAddress(address);
ServiceRouteHeader var053B5E67A3C405C92299DADD82C58C15_1161772902 =         serviceRoute;
        var053B5E67A3C405C92299DADD82C58C15_1161772902.addTaint(taint);
        return var053B5E67A3C405C92299DADD82C58C15_1161772902;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address!");
        //ServiceRoute serviceRoute = new ServiceRoute();
        //serviceRoute.setAddress(address);
        //return serviceRoute;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.519 -0400", hash_original_method = "7A3E4AE36777C6F2CF79A6B3882A3053", hash_generated_method = "68F1F97D16188D03AE0764B4F018E82C")
    public SecurityServerHeader createSecurityServerHeader() {
        SecurityServer secServer = new SecurityServer();
SecurityServerHeader varB3B00B359D9C7A7FF5ACB7ADF2B29DE0_355281247 =         secServer;
        varB3B00B359D9C7A7FF5ACB7ADF2B29DE0_355281247.addTaint(taint);
        return varB3B00B359D9C7A7FF5ACB7ADF2B29DE0_355281247;
        // ---------- Original Method ----------
        //SecurityServer secServer = new SecurityServer();
        //return secServer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.519 -0400", hash_original_method = "2361364E4BB205FAC2A8F8549D9431F6", hash_generated_method = "29D74477CD011EA6FBD2F1E0CCC7121E")
    public SecurityClientHeader createSecurityClientHeader() {
        SecurityClient secClient = new SecurityClient();
SecurityClientHeader var765B30730561AF88047895923F1DCCDD_1732272326 =         secClient;
        var765B30730561AF88047895923F1DCCDD_1732272326.addTaint(taint);
        return var765B30730561AF88047895923F1DCCDD_1732272326;
        // ---------- Original Method ----------
        //SecurityClient secClient = new SecurityClient();
        //return secClient;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.519 -0400", hash_original_method = "1063C2554F38236C917DADCB6A55ADB8", hash_generated_method = "161792A0AD314A22FB0716890D02ED62")
    public SecurityVerifyHeader createSecurityVerifyHeader() {
        SecurityVerify secVerify = new SecurityVerify();
SecurityVerifyHeader var1B1489A71D080EE8E6383DDAAD133BA7_1634179347 =         secVerify;
        var1B1489A71D080EE8E6383DDAAD133BA7_1634179347.addTaint(taint);
        return var1B1489A71D080EE8E6383DDAAD133BA7_1634179347;
        // ---------- Original Method ----------
        //SecurityVerify secVerify = new SecurityVerify();
        //return secVerify;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.520 -0400", hash_original_method = "2DDC01C5DAA0917C6B8BE6B8A00F5568", hash_generated_method = "E660161F091E768D35E1D8458D8E175D")
    public PUserDatabaseHeader createPUserDatabaseHeader(String databaseName) {
        addTaint(databaseName.getTaint());
    if((databaseName ==null)||(databaseName.equals(" ")))        
        {
        NullPointerException varA3D75CD097E396096D0DAAE2F57C8E0F_1178273372 = new NullPointerException("Database name is null");
        varA3D75CD097E396096D0DAAE2F57C8E0F_1178273372.addTaint(taint);
        throw varA3D75CD097E396096D0DAAE2F57C8E0F_1178273372;
        }
        PUserDatabase pUserDatabase = new PUserDatabase();
        pUserDatabase.setDatabaseName(databaseName);
PUserDatabaseHeader var4329ACBB572204F8114532C71BA12EEC_976652197 =         pUserDatabase;
        var4329ACBB572204F8114532C71BA12EEC_976652197.addTaint(taint);
        return var4329ACBB572204F8114532C71BA12EEC_976652197;
        // ---------- Original Method ----------
        //if((databaseName ==null)||(databaseName.equals(" ")))
            //throw new NullPointerException("Database name is null");
        //PUserDatabase pUserDatabase = new PUserDatabase();
        //pUserDatabase.setDatabaseName(databaseName);
        //return pUserDatabase;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.520 -0400", hash_original_method = "6A0691F102D20D70FD0A6921A61CA118", hash_generated_method = "2CCF483B6E731C333BCEA030D663723B")
    public PProfileKeyHeader createPProfileKeyHeader(Address address) {
        addTaint(address.getTaint());
    if(address ==null)        
        {
        NullPointerException var1F6D57328866E4090FEBEBA91EBDEDF8_1431522354 = new NullPointerException("Address is null");
        var1F6D57328866E4090FEBEBA91EBDEDF8_1431522354.addTaint(taint);
        throw var1F6D57328866E4090FEBEBA91EBDEDF8_1431522354;
        }
        PProfileKey pProfileKey = new PProfileKey();
        pProfileKey.setAddress(address);
PProfileKeyHeader varEC0FDC302A29833D6488CF0AD4961908_797903469 =         pProfileKey;
        varEC0FDC302A29833D6488CF0AD4961908_797903469.addTaint(taint);
        return varEC0FDC302A29833D6488CF0AD4961908_797903469;
        // ---------- Original Method ----------
        //if (address ==null)
            //throw new NullPointerException("Address is null");
        //PProfileKey pProfileKey = new PProfileKey();
        //pProfileKey.setAddress(address);
        //return pProfileKey;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.521 -0400", hash_original_method = "38B7C1667A9FD579C07BB14E255FF56A", hash_generated_method = "F1DAD0006DEF2B6490E8D0A585CFCE39")
    public PServedUserHeader createPServedUserHeader(Address address) {
        addTaint(address.getTaint());
    if(address==null)        
        {
        NullPointerException var1F6D57328866E4090FEBEBA91EBDEDF8_740482159 = new NullPointerException("Address is null");
        var1F6D57328866E4090FEBEBA91EBDEDF8_740482159.addTaint(taint);
        throw var1F6D57328866E4090FEBEBA91EBDEDF8_740482159;
        }
        PServedUser psu = new PServedUser();
        psu.setAddress(address);
PServedUserHeader var692F8B60AB5F287F67B57796A596B4F9_62488513 =         psu;
        var692F8B60AB5F287F67B57796A596B4F9_62488513.addTaint(taint);
        return var692F8B60AB5F287F67B57796A596B4F9_62488513;
        // ---------- Original Method ----------
        //if(address==null)
            //throw new NullPointerException("Address is null");
        //PServedUser psu = new PServedUser();
        //psu.setAddress(address);
        //return psu;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.521 -0400", hash_original_method = "C0CFD4DCC2CCE8A2BE967D3A2132C68A", hash_generated_method = "7AC7195FE1F1D280AC2010F4D1C44287")
    public PPreferredServiceHeader createPPreferredServiceHeader() {
        PPreferredService pps = new PPreferredService();
PPreferredServiceHeader varC898577DF9A25F8DAE1AF7FE9C1F2518_1155894921 =         pps;
        varC898577DF9A25F8DAE1AF7FE9C1F2518_1155894921.addTaint(taint);
        return varC898577DF9A25F8DAE1AF7FE9C1F2518_1155894921;
        // ---------- Original Method ----------
        //PPreferredService pps = new PPreferredService();
        //return pps;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.521 -0400", hash_original_method = "48E529894AF92157CD42EE8DFB6E18AB", hash_generated_method = "F96BAE47B098A1D5C2054C9CE17F1B0A")
    public PAssertedServiceHeader createPAssertedServiceHeader() {
        PAssertedService pas = new PAssertedService();
PAssertedServiceHeader var7B54B6FCDA842A4EF6E5AEAFAFBF1E41_1361463025 =         pas;
        var7B54B6FCDA842A4EF6E5AEAFAFBF1E41_1361463025.addTaint(taint);
        return var7B54B6FCDA842A4EF6E5AEAFAFBF1E41_1361463025;
        // ---------- Original Method ----------
        //PAssertedService pas = new PAssertedService();
        //return pas;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.521 -0400", hash_original_method = "6D472F26B8815D9A75157924D7DB3DB8", hash_generated_method = "4F0DC62E56316FAC67C55D33FCC3E2D5")
    public SessionExpiresHeader createSessionExpiresHeader(int expires) throws InvalidArgumentException {
        addTaint(expires);
    if(expires < 0)        
        {
        InvalidArgumentException varD793F10BEC5AF07D94BCB0E147C43386_740003003 = new InvalidArgumentException("bad value " + expires);
        varD793F10BEC5AF07D94BCB0E147C43386_740003003.addTaint(taint);
        throw varD793F10BEC5AF07D94BCB0E147C43386_740003003;
        }
        SessionExpires s = new SessionExpires();
        s.setExpires(expires);
SessionExpiresHeader var0478718F0636FB61899C13801CE9FE09_1383497327 =         s;
        var0478718F0636FB61899C13801CE9FE09_1383497327.addTaint(taint);
        return var0478718F0636FB61899C13801CE9FE09_1383497327;
        // ---------- Original Method ----------
        //if (expires < 0)
            //throw new InvalidArgumentException("bad value " + expires);
        //SessionExpires s = new SessionExpires();
        //s.setExpires(expires);
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.522 -0400", hash_original_method = "F07701895F7EA99F66D330A17A2FD28D", hash_generated_method = "EA0EF5EB9C7FC392EF0D83A503AAA9E2")
    public SipRequestLine createRequestLine(String requestLine) throws ParseException {
        addTaint(requestLine.getTaint());
        RequestLineParser requestLineParser = new RequestLineParser(requestLine);
SipRequestLine var4373A505D5EBC4D14D70210E0EBFEE5F_1593410304 =         (SipRequestLine) requestLineParser.parse();
        var4373A505D5EBC4D14D70210E0EBFEE5F_1593410304.addTaint(taint);
        return var4373A505D5EBC4D14D70210E0EBFEE5F_1593410304;
        // ---------- Original Method ----------
        //RequestLineParser requestLineParser = new RequestLineParser(requestLine);
        //return (SipRequestLine) requestLineParser.parse();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.522 -0400", hash_original_method = "94ED81BC52F6E3EE358EE57713F40357", hash_generated_method = "1C844CE6B4C96566DDE0CF29E1B296F0")
    public SipStatusLine createStatusLine(String statusLine) throws ParseException {
        addTaint(statusLine.getTaint());
        StatusLineParser statusLineParser = new StatusLineParser(statusLine);
SipStatusLine var12D9C3CA3BC7C79C668BDC85C705FE7E_1308543572 =         (SipStatusLine) statusLineParser.parse();
        var12D9C3CA3BC7C79C668BDC85C705FE7E_1308543572.addTaint(taint);
        return var12D9C3CA3BC7C79C668BDC85C705FE7E_1308543572;
        // ---------- Original Method ----------
        //StatusLineParser statusLineParser = new StatusLineParser(statusLine);
        //return (SipStatusLine) statusLineParser.parse();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.523 -0400", hash_original_method = "B06A6A8CC80D9698711113EFD1E58499", hash_generated_method = "4D1DDB535E4E01D77A1A9BF03CB287A3")
    public ReferencesHeader createReferencesHeader(String callId, String rel) throws ParseException {
        addTaint(rel.getTaint());
        addTaint(callId.getTaint());
        ReferencesHeader retval = new References();
        retval.setCallId(callId);
        retval.setRel(rel);
ReferencesHeader varF9E19AD6135C970F387F77C6F3DE4477_311574179 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_311574179.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_311574179;
        // ---------- Original Method ----------
        //ReferencesHeader retval = new References();
        //retval.setCallId(callId);
        //retval.setRel(rel);
        //return retval;
    }

    
}

