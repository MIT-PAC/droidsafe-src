package gov.nist.javax.sip.header;

// Droidsafe Imports
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

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class HeaderFactoryImpl implements HeaderFactory, HeaderFactoryExt {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.489 -0400", hash_original_field = "6FA63D73209D74D0D54BC416A32DB10D", hash_generated_field = "0D2878F1D6B0CD805C869443DA7FE75E")

    private boolean stripAddressScopeZones = false;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.489 -0400", hash_original_method = "EA4ABB94B4CFEF029E31D8F450F44C66", hash_generated_method = "4DBE2EDCEE71001244079D3C05C060E8")
    public  HeaderFactoryImpl() {
        stripAddressScopeZones
            = Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
        // ---------- Original Method ----------
        //stripAddressScopeZones
            //= Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.490 -0400", hash_original_method = "9BEACA878DCF694953AD8141227DB60F", hash_generated_method = "3F1A3DE5498669AA00ABE685D6431FC2")
    public void setPrettyEncoding(boolean flag) {
        addTaint(flag);
        SIPHeaderList.setPrettyEncode(flag);
        // ---------- Original Method ----------
        //SIPHeaderList.setPrettyEncode(flag);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.490 -0400", hash_original_method = "58113BBBA3D76308CFB19C46D0FF7A27", hash_generated_method = "F768D270E1EB95FC2BDA2F4F92F3C1DA")
    public AcceptEncodingHeader createAcceptEncodingHeader(String encoding) throws ParseException {
        addTaint(encoding.getTaint());
        if(encoding == null)        
        {
        NullPointerException varDEA08EDB3217C2BADAB82B9BBFFECD37_1022024128 = new NullPointerException("the encoding parameter is null");
        varDEA08EDB3217C2BADAB82B9BBFFECD37_1022024128.addTaint(taint);
        throw varDEA08EDB3217C2BADAB82B9BBFFECD37_1022024128;
        }
        AcceptEncoding acceptEncoding = new AcceptEncoding();
        acceptEncoding.setEncoding(encoding);
AcceptEncodingHeader varE01F2A72A06A1B398025C7E45032A16D_2095722742 =         acceptEncoding;
        varE01F2A72A06A1B398025C7E45032A16D_2095722742.addTaint(taint);
        return varE01F2A72A06A1B398025C7E45032A16D_2095722742;
        // ---------- Original Method ----------
        //if (encoding == null)
            //throw new NullPointerException("the encoding parameter is null");
        //AcceptEncoding acceptEncoding = new AcceptEncoding();
        //acceptEncoding.setEncoding(encoding);
        //return acceptEncoding;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.491 -0400", hash_original_method = "3FEA70547EDCF31E1AA086D3362AC6CE", hash_generated_method = "6266B2833E88CA5C052503AFCE9BF16D")
    public AcceptHeader createAcceptHeader(
        String contentType,
        String contentSubType) throws ParseException {
        addTaint(contentSubType.getTaint());
        addTaint(contentType.getTaint());
        if(contentType == null || contentSubType == null)        
        {
        NullPointerException var27CF75CB0BF0A10A901AD6DC140858D3_1352937742 = new NullPointerException("contentType or subtype is null ");
        var27CF75CB0BF0A10A901AD6DC140858D3_1352937742.addTaint(taint);
        throw var27CF75CB0BF0A10A901AD6DC140858D3_1352937742;
        }
        Accept accept = new Accept();
        accept.setContentType(contentType);
        accept.setContentSubType(contentSubType);
AcceptHeader var4810606E904E6475813B05DAB05FAA99_1167170816 =         accept;
        var4810606E904E6475813B05DAB05FAA99_1167170816.addTaint(taint);
        return var4810606E904E6475813B05DAB05FAA99_1167170816;
        // ---------- Original Method ----------
        //if (contentType == null || contentSubType == null)
            //throw new NullPointerException("contentType or subtype is null ");
        //Accept accept = new Accept();
        //accept.setContentType(contentType);
        //accept.setContentSubType(contentSubType);
        //return accept;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.491 -0400", hash_original_method = "5AF5E9D92982780781CC81035C3C1529", hash_generated_method = "0C659304EECAA7DDD5DD0E99DFE32C96")
    public AcceptLanguageHeader createAcceptLanguageHeader(Locale language) {
        addTaint(language.getTaint());
        if(language == null)        
        {
        NullPointerException varCF8D07C80828DCBD1FC1EB16BCF7D0F2_1886599467 = new NullPointerException("null arg");
        varCF8D07C80828DCBD1FC1EB16BCF7D0F2_1886599467.addTaint(taint);
        throw varCF8D07C80828DCBD1FC1EB16BCF7D0F2_1886599467;
        }
        AcceptLanguage acceptLanguage = new AcceptLanguage();
        acceptLanguage.setAcceptLanguage(language);
AcceptLanguageHeader varA29C4E14CD304C607CC754001D3111CC_2094697349 =         acceptLanguage;
        varA29C4E14CD304C607CC754001D3111CC_2094697349.addTaint(taint);
        return varA29C4E14CD304C607CC754001D3111CC_2094697349;
        // ---------- Original Method ----------
        //if (language == null)
            //throw new NullPointerException("null arg");
        //AcceptLanguage acceptLanguage = new AcceptLanguage();
        //acceptLanguage.setAcceptLanguage(language);
        //return acceptLanguage;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.491 -0400", hash_original_method = "3E0D5311E2AF98CBAC12E04C1647AAA5", hash_generated_method = "828754EF894079E2DD86065C392186A6")
    public AlertInfoHeader createAlertInfoHeader(URI alertInfo) {
        addTaint(alertInfo.getTaint());
        if(alertInfo == null)        
        {
        NullPointerException var779EAD4B03B6321A19989346C69A355A_1386357220 = new NullPointerException("null arg alertInfo");
        var779EAD4B03B6321A19989346C69A355A_1386357220.addTaint(taint);
        throw var779EAD4B03B6321A19989346C69A355A_1386357220;
        }
        AlertInfo a = new AlertInfo();
        a.setAlertInfo(alertInfo);
AlertInfoHeader var3F5343BF1D849954A73F0BB303805FFD_33358082 =         a;
        var3F5343BF1D849954A73F0BB303805FFD_33358082.addTaint(taint);
        return var3F5343BF1D849954A73F0BB303805FFD_33358082;
        // ---------- Original Method ----------
        //if (alertInfo == null)
            //throw new NullPointerException("null arg alertInfo");
        //AlertInfo a = new AlertInfo();
        //a.setAlertInfo(alertInfo);
        //return a;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.492 -0400", hash_original_method = "7A8DE3D3022A3669E75EC61B4D0B5F19", hash_generated_method = "BA5EF42AC9A5A30B5115EAE92B0BD964")
    public AllowEventsHeader createAllowEventsHeader(String eventType) throws ParseException {
        addTaint(eventType.getTaint());
        if(eventType == null)        
        {
        NullPointerException varF80AB4E0A5EA9F006568379580EF78C8_2143153055 = new NullPointerException("null arg eventType");
        varF80AB4E0A5EA9F006568379580EF78C8_2143153055.addTaint(taint);
        throw varF80AB4E0A5EA9F006568379580EF78C8_2143153055;
        }
        AllowEvents allowEvents = new AllowEvents();
        allowEvents.setEventType(eventType);
AllowEventsHeader var7AAF24C270C1FFA4026ACFC304EDA15A_2065274706 =         allowEvents;
        var7AAF24C270C1FFA4026ACFC304EDA15A_2065274706.addTaint(taint);
        return var7AAF24C270C1FFA4026ACFC304EDA15A_2065274706;
        // ---------- Original Method ----------
        //if (eventType == null)
            //throw new NullPointerException("null arg eventType");
        //AllowEvents allowEvents = new AllowEvents();
        //allowEvents.setEventType(eventType);
        //return allowEvents;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.492 -0400", hash_original_method = "C562ECE8E2158A54C27A4525D88FEA63", hash_generated_method = "92EF36A6F793A87BEB36649BB84ADC41")
    public AllowHeader createAllowHeader(String method) throws ParseException {
        addTaint(method.getTaint());
        if(method == null)        
        {
        NullPointerException var399A735BE4E996AEE3B42328FB71B78B_2003817378 = new NullPointerException("null arg method");
        var399A735BE4E996AEE3B42328FB71B78B_2003817378.addTaint(taint);
        throw var399A735BE4E996AEE3B42328FB71B78B_2003817378;
        }
        Allow allow = new Allow();
        allow.setMethod(method);
AllowHeader var9E6A6E901ADF174DAF31F3629A9D8C1B_1432903219 =         allow;
        var9E6A6E901ADF174DAF31F3629A9D8C1B_1432903219.addTaint(taint);
        return var9E6A6E901ADF174DAF31F3629A9D8C1B_1432903219;
        // ---------- Original Method ----------
        //if (method == null)
            //throw new NullPointerException("null arg method");
        //Allow allow = new Allow();
        //allow.setMethod(method);
        //return allow;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.492 -0400", hash_original_method = "E72D81A306A857A102E9D4437AB18CA6", hash_generated_method = "AB7A4D6428EBE54ADF00E5C66CB6157E")
    public AuthenticationInfoHeader createAuthenticationInfoHeader(String response) throws ParseException {
        addTaint(response.getTaint());
        if(response == null)        
        {
        NullPointerException var433DFD9714713F19150708C72828B04A_1798494388 = new NullPointerException("null arg response");
        var433DFD9714713F19150708C72828B04A_1798494388.addTaint(taint);
        throw var433DFD9714713F19150708C72828B04A_1798494388;
        }
        AuthenticationInfo auth = new AuthenticationInfo();
        auth.setResponse(response);
AuthenticationInfoHeader varFE2A4E660D0434D283705BEC4309B2E4_618575540 =         auth;
        varFE2A4E660D0434D283705BEC4309B2E4_618575540.addTaint(taint);
        return varFE2A4E660D0434D283705BEC4309B2E4_618575540;
        // ---------- Original Method ----------
        //if (response == null)
            //throw new NullPointerException("null arg response");
        //AuthenticationInfo auth = new AuthenticationInfo();
        //auth.setResponse(response);
        //return auth;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.493 -0400", hash_original_method = "F250EC80C8CD1CBE5FF237A98CBD8CD0", hash_generated_method = "553DAABD29378439311EEB4591E7F62C")
    public AuthorizationHeader createAuthorizationHeader(String scheme) throws ParseException {
        addTaint(scheme.getTaint());
        if(scheme == null)        
        {
        NullPointerException var248D7F660A7C64246C65E344DAEB7E03_1265895049 = new NullPointerException("null arg scheme ");
        var248D7F660A7C64246C65E344DAEB7E03_1265895049.addTaint(taint);
        throw var248D7F660A7C64246C65E344DAEB7E03_1265895049;
        }
        Authorization auth = new Authorization();
        auth.setScheme(scheme);
AuthorizationHeader varFE2A4E660D0434D283705BEC4309B2E4_1192349026 =         auth;
        varFE2A4E660D0434D283705BEC4309B2E4_1192349026.addTaint(taint);
        return varFE2A4E660D0434D283705BEC4309B2E4_1192349026;
        // ---------- Original Method ----------
        //if (scheme == null)
            //throw new NullPointerException("null arg scheme ");
        //Authorization auth = new Authorization();
        //auth.setScheme(scheme);
        //return auth;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.493 -0400", hash_original_method = "9707416B5040BCEA07917ADCBF33DA70", hash_generated_method = "07E3D465F04D693597DEF95B54454C53")
    public CSeqHeader createCSeqHeader( long sequenceNumber, String method) throws ParseException, InvalidArgumentException {
        addTaint(method.getTaint());
        addTaint(sequenceNumber);
        if(sequenceNumber < 0)        
        {
        InvalidArgumentException var4E2C5630472389A0FA953FD60456BBEC_1631901214 = new InvalidArgumentException("bad arg " + sequenceNumber);
        var4E2C5630472389A0FA953FD60456BBEC_1631901214.addTaint(taint);
        throw var4E2C5630472389A0FA953FD60456BBEC_1631901214;
        }
        if(method == null)        
        {
        NullPointerException var399A735BE4E996AEE3B42328FB71B78B_1668035149 = new NullPointerException("null arg method");
        var399A735BE4E996AEE3B42328FB71B78B_1668035149.addTaint(taint);
        throw var399A735BE4E996AEE3B42328FB71B78B_1668035149;
        }
        CSeq cseq = new CSeq();
        cseq.setMethod(method);
        cseq.setSeqNumber(sequenceNumber);
CSeqHeader varFC7826BD3106DF80805DB927415679C2_1800467999 =         cseq;
        varFC7826BD3106DF80805DB927415679C2_1800467999.addTaint(taint);
        return varFC7826BD3106DF80805DB927415679C2_1800467999;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.493 -0400", hash_original_method = "332D5DD16F528ACCDED76BFE26F4F243", hash_generated_method = "2B397A1E802D8F64DB002BBF000E1D14")
    public CSeqHeader createCSeqHeader( int sequenceNumber, String method) throws ParseException, InvalidArgumentException {
        addTaint(method.getTaint());
        addTaint(sequenceNumber);
CSeqHeader varEB341C41EAF652A028D677FFCBAF073B_2079914799 =         this.createCSeqHeader( (long) sequenceNumber, method );
        varEB341C41EAF652A028D677FFCBAF073B_2079914799.addTaint(taint);
        return varEB341C41EAF652A028D677FFCBAF073B_2079914799;
        // ---------- Original Method ----------
        //return this.createCSeqHeader( (long) sequenceNumber, method );
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.494 -0400", hash_original_method = "0CB560808F252622C176039BC6E86FF7", hash_generated_method = "3737EE9B1CA62C1B891B2067BCE60899")
    public CallIdHeader createCallIdHeader(String callId) throws ParseException {
        addTaint(callId.getTaint());
        if(callId == null)        
        {
        NullPointerException var3ACAC66E634D40B72DDDB712DF5B0D7C_854462679 = new NullPointerException("null arg callId");
        var3ACAC66E634D40B72DDDB712DF5B0D7C_854462679.addTaint(taint);
        throw var3ACAC66E634D40B72DDDB712DF5B0D7C_854462679;
        }
        CallID c = new CallID();
        c.setCallId(callId);
CallIdHeader var807FB10045EE51C06BDB74744A6714DF_249735594 =         c;
        var807FB10045EE51C06BDB74744A6714DF_249735594.addTaint(taint);
        return var807FB10045EE51C06BDB74744A6714DF_249735594;
        // ---------- Original Method ----------
        //if (callId == null)
            //throw new NullPointerException("null arg callId");
        //CallID c = new CallID();
        //c.setCallId(callId);
        //return c;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.494 -0400", hash_original_method = "8867B6CA9EB8DB8DAA3F991D7B0AD5D9", hash_generated_method = "95E88A7F3E07D240243CCF84777185FD")
    public CallInfoHeader createCallInfoHeader(URI callInfo) {
        addTaint(callInfo.getTaint());
        if(callInfo == null)        
        {
        NullPointerException var45772051CC68D2809BF7600BA06F2333_767071698 = new NullPointerException("null arg callInfo");
        var45772051CC68D2809BF7600BA06F2333_767071698.addTaint(taint);
        throw var45772051CC68D2809BF7600BA06F2333_767071698;
        }
        CallInfo c = new CallInfo();
        c.setInfo(callInfo);
CallInfoHeader var807FB10045EE51C06BDB74744A6714DF_2049524180 =         c;
        var807FB10045EE51C06BDB74744A6714DF_2049524180.addTaint(taint);
        return var807FB10045EE51C06BDB74744A6714DF_2049524180;
        // ---------- Original Method ----------
        //if (callInfo == null)
            //throw new NullPointerException("null arg callInfo");
        //CallInfo c = new CallInfo();
        //c.setInfo(callInfo);
        //return c;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.495 -0400", hash_original_method = "45EF0D9994A51A34EA10DF4A185E8F21", hash_generated_method = "829167466200CFA101441F7116D5803D")
    public ContactHeader createContactHeader(Address address) {
        addTaint(address.getTaint());
        if(address == null)        
        {
        NullPointerException varEA0AFDD92357D6E24F03515D275B80B6_218128158 = new NullPointerException("null arg address");
        varEA0AFDD92357D6E24F03515D275B80B6_218128158.addTaint(taint);
        throw varEA0AFDD92357D6E24F03515D275B80B6_218128158;
        }
        Contact contact = new Contact();
        contact.setAddress(address);
ContactHeader var695F7F01550A7C9445656119C31590B1_521016035 =         contact;
        var695F7F01550A7C9445656119C31590B1_521016035.addTaint(taint);
        return var695F7F01550A7C9445656119C31590B1_521016035;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null arg address");
        //Contact contact = new Contact();
        //contact.setAddress(address);
        //return contact;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.495 -0400", hash_original_method = "5873C88FB18B86DA11D334099F5AE064", hash_generated_method = "B2514BCDD1CA6D7FF83FF7072505E261")
    public ContactHeader createContactHeader() {
        Contact contact = new Contact();
        contact.setWildCardFlag(true);
        contact.setExpires(0);
ContactHeader var695F7F01550A7C9445656119C31590B1_1354602107 =         contact;
        var695F7F01550A7C9445656119C31590B1_1354602107.addTaint(taint);
        return var695F7F01550A7C9445656119C31590B1_1354602107;
        // ---------- Original Method ----------
        //Contact contact = new Contact();
        //contact.setWildCardFlag(true);
        //contact.setExpires(0);
        //return contact;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.495 -0400", hash_original_method = "CC352C2425871DC27A0C55CF39D4ABAB", hash_generated_method = "84EFABFE4670ACB019EFC1071EB18FA8")
    public ContentDispositionHeader createContentDispositionHeader(String contentDisposition) throws ParseException {
        addTaint(contentDisposition.getTaint());
        if(contentDisposition == null)        
        {
        NullPointerException varAAF294EDB1A36F2A920A05248736DF62_320658866 = new NullPointerException("null arg contentDisposition");
        varAAF294EDB1A36F2A920A05248736DF62_320658866.addTaint(taint);
        throw varAAF294EDB1A36F2A920A05248736DF62_320658866;
        }
        ContentDisposition c = new ContentDisposition();
        c.setDispositionType(contentDisposition);
ContentDispositionHeader var807FB10045EE51C06BDB74744A6714DF_287615069 =         c;
        var807FB10045EE51C06BDB74744A6714DF_287615069.addTaint(taint);
        return var807FB10045EE51C06BDB74744A6714DF_287615069;
        // ---------- Original Method ----------
        //if (contentDisposition == null)
            //throw new NullPointerException("null arg contentDisposition");
        //ContentDisposition c = new ContentDisposition();
        //c.setDispositionType(contentDisposition);
        //return c;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.496 -0400", hash_original_method = "090104ADCCDA5F259494E038435257D1", hash_generated_method = "188FBF8798363A0ADE87B4D518C4A8B0")
    public ContentEncodingHeader createContentEncodingHeader(String encoding) throws ParseException {
        addTaint(encoding.getTaint());
        if(encoding == null)        
        {
        NullPointerException var4C674A525DB996A1012167A3B21269D5_2135206791 = new NullPointerException("null encoding");
        var4C674A525DB996A1012167A3B21269D5_2135206791.addTaint(taint);
        throw var4C674A525DB996A1012167A3B21269D5_2135206791;
        }
        ContentEncoding c = new ContentEncoding();
        c.setEncoding(encoding);
ContentEncodingHeader var807FB10045EE51C06BDB74744A6714DF_873778252 =         c;
        var807FB10045EE51C06BDB74744A6714DF_873778252.addTaint(taint);
        return var807FB10045EE51C06BDB74744A6714DF_873778252;
        // ---------- Original Method ----------
        //if (encoding == null)
            //throw new NullPointerException("null encoding");
        //ContentEncoding c = new ContentEncoding();
        //c.setEncoding(encoding);
        //return c;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.496 -0400", hash_original_method = "CD027E2457CF527330FF9F4C0A972B91", hash_generated_method = "A4A6758E2BB30F6664A344DA6EC78998")
    public ContentLanguageHeader createContentLanguageHeader(Locale contentLanguage) {
        addTaint(contentLanguage.getTaint());
        if(contentLanguage == null)        
        {
        NullPointerException varAC83619DCA13C5FD95F312D657A5294C_919464905 = new NullPointerException("null arg contentLanguage");
        varAC83619DCA13C5FD95F312D657A5294C_919464905.addTaint(taint);
        throw varAC83619DCA13C5FD95F312D657A5294C_919464905;
        }
        ContentLanguage c = new ContentLanguage();
        c.setContentLanguage(contentLanguage);
ContentLanguageHeader var807FB10045EE51C06BDB74744A6714DF_2140913111 =         c;
        var807FB10045EE51C06BDB74744A6714DF_2140913111.addTaint(taint);
        return var807FB10045EE51C06BDB74744A6714DF_2140913111;
        // ---------- Original Method ----------
        //if (contentLanguage == null)
            //throw new NullPointerException("null arg contentLanguage");
        //ContentLanguage c = new ContentLanguage();
        //c.setContentLanguage(contentLanguage);
        //return c;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.497 -0400", hash_original_method = "DA3B5EC62F3E30804B07AD592D303E3E", hash_generated_method = "666797244D38945B342540F8DD3C7119")
    public ContentLengthHeader createContentLengthHeader(int contentLength) throws InvalidArgumentException {
        addTaint(contentLength);
        if(contentLength < 0)        
        {
        InvalidArgumentException var30EDEF7A7B9B96D47CAAA8CFB4ADDA2B_671624733 = new InvalidArgumentException("bad contentLength");
        var30EDEF7A7B9B96D47CAAA8CFB4ADDA2B_671624733.addTaint(taint);
        throw var30EDEF7A7B9B96D47CAAA8CFB4ADDA2B_671624733;
        }
        ContentLength c = new ContentLength();
        c.setContentLength(contentLength);
ContentLengthHeader var807FB10045EE51C06BDB74744A6714DF_17230930 =         c;
        var807FB10045EE51C06BDB74744A6714DF_17230930.addTaint(taint);
        return var807FB10045EE51C06BDB74744A6714DF_17230930;
        // ---------- Original Method ----------
        //if (contentLength < 0)
            //throw new InvalidArgumentException("bad contentLength");
        //ContentLength c = new ContentLength();
        //c.setContentLength(contentLength);
        //return c;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.497 -0400", hash_original_method = "BF42B4FF2E7F96D2FA4773C6E514B79D", hash_generated_method = "348BDBEF611AF879AFAF4298FB5703ED")
    public ContentTypeHeader createContentTypeHeader(
        String contentType,
        String contentSubType) throws ParseException {
        addTaint(contentSubType.getTaint());
        addTaint(contentType.getTaint());
        if(contentType == null || contentSubType == null)        
        {
        NullPointerException var2B513044B221C7056C3803C6C31C8201_951615468 = new NullPointerException("null contentType or subType");
        var2B513044B221C7056C3803C6C31C8201_951615468.addTaint(taint);
        throw var2B513044B221C7056C3803C6C31C8201_951615468;
        }
        ContentType c = new ContentType();
        c.setContentType(contentType);
        c.setContentSubType(contentSubType);
ContentTypeHeader var807FB10045EE51C06BDB74744A6714DF_503714201 =         c;
        var807FB10045EE51C06BDB74744A6714DF_503714201.addTaint(taint);
        return var807FB10045EE51C06BDB74744A6714DF_503714201;
        // ---------- Original Method ----------
        //if (contentType == null || contentSubType == null)
            //throw new NullPointerException("null contentType or subType");
        //ContentType c = new ContentType();
        //c.setContentType(contentType);
        //c.setContentSubType(contentSubType);
        //return c;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.497 -0400", hash_original_method = "F3D0948AB2AB5DCB4D46B0F9C4754A1D", hash_generated_method = "9F877447E68BC9D85D3E2D262B5151F6")
    public DateHeader createDateHeader(Calendar date) {
        addTaint(date.getTaint());
        SIPDateHeader d = new SIPDateHeader();
        if(date == null)        
        {
        NullPointerException var72A525CDA1FC3B46EBEE8B395772AADA_2063637691 = new NullPointerException("null date");
        var72A525CDA1FC3B46EBEE8B395772AADA_2063637691.addTaint(taint);
        throw var72A525CDA1FC3B46EBEE8B395772AADA_2063637691;
        }
        d.setDate(date);
DateHeader varBE245B24E7ED509FDFAAA6CD39E35D89_1672044119 =         d;
        varBE245B24E7ED509FDFAAA6CD39E35D89_1672044119.addTaint(taint);
        return varBE245B24E7ED509FDFAAA6CD39E35D89_1672044119;
        // ---------- Original Method ----------
        //SIPDateHeader d = new SIPDateHeader();
        //if (date == null)
            //throw new NullPointerException("null date");
        //d.setDate(date);
        //return d;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.498 -0400", hash_original_method = "7FD58797EECF83FE34BEE1F3B093BC46", hash_generated_method = "0C4D7601ADB75975D20466C44BABE300")
    public EventHeader createEventHeader(String eventType) throws ParseException {
        addTaint(eventType.getTaint());
        if(eventType == null)        
        {
        NullPointerException varC3169858D04CE419EDD144E9093988C9_1491365573 = new NullPointerException("null eventType");
        varC3169858D04CE419EDD144E9093988C9_1491365573.addTaint(taint);
        throw varC3169858D04CE419EDD144E9093988C9_1491365573;
        }
        Event event = new Event();
        event.setEventType(eventType);
EventHeader var3162E7A4A1E5D72F1058A9B39A6A8738_476801745 =         event;
        var3162E7A4A1E5D72F1058A9B39A6A8738_476801745.addTaint(taint);
        return var3162E7A4A1E5D72F1058A9B39A6A8738_476801745;
        // ---------- Original Method ----------
        //if (eventType == null)
            //throw new NullPointerException("null eventType");
        //Event event = new Event();
        //event.setEventType(eventType);
        //return event;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.498 -0400", hash_original_method = "1A307AD1BD02E7BD6299AF40D811E5D5", hash_generated_method = "F30E9747519D1CB69DB9733D76DB53CC")
    public ExpiresHeader createExpiresHeader(int expires) throws InvalidArgumentException {
        addTaint(expires);
        if(expires < 0)        
        {
        InvalidArgumentException varD793F10BEC5AF07D94BCB0E147C43386_1753233009 = new InvalidArgumentException("bad value " + expires);
        varD793F10BEC5AF07D94BCB0E147C43386_1753233009.addTaint(taint);
        throw varD793F10BEC5AF07D94BCB0E147C43386_1753233009;
        }
        Expires e = new Expires();
        e.setExpires(expires);
ExpiresHeader var6BFFBFA2F1D556BA80433C2335198CE9_754931538 =         e;
        var6BFFBFA2F1D556BA80433C2335198CE9_754931538.addTaint(taint);
        return var6BFFBFA2F1D556BA80433C2335198CE9_754931538;
        // ---------- Original Method ----------
        //if (expires < 0)
            //throw new InvalidArgumentException("bad value " + expires);
        //Expires e = new Expires();
        //e.setExpires(expires);
        //return e;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.498 -0400", hash_original_method = "C38CB4735B94E96E0C6FB81DC8E60CBF", hash_generated_method = "F61AA8D7D7A68017096B5AC850E16B65")
    public javax.sip.header.ExtensionHeader createExtensionHeader(
        String name,
        String value) throws ParseException {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        if(name == null)        
        {
        NullPointerException varF8E41E74DC7E4A1BFFD590DA02D269D3_1100009473 = new NullPointerException("bad name");
        varF8E41E74DC7E4A1BFFD590DA02D269D3_1100009473.addTaint(taint);
        throw varF8E41E74DC7E4A1BFFD590DA02D269D3_1100009473;
        }
        gov.nist.javax.sip.header.ExtensionHeaderImpl ext = new gov.nist.javax.sip.header.ExtensionHeaderImpl();
        ext.setName(name);
        ext.setValue(value);
javax.sip.header.ExtensionHeader varFDE9E71E25F62874B52BEEA10AF11C0A_257939502 =         ext;
        varFDE9E71E25F62874B52BEEA10AF11C0A_257939502.addTaint(taint);
        return varFDE9E71E25F62874B52BEEA10AF11C0A_257939502;
        // ---------- Original Method ----------
        //if (name == null)
            //throw new NullPointerException("bad name");
        //gov.nist.javax.sip.header.ExtensionHeaderImpl ext =
            //new gov.nist.javax.sip.header.ExtensionHeaderImpl();
        //ext.setName(name);
        //ext.setValue(value);
        //return ext;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.499 -0400", hash_original_method = "E3876C81F77C4C65824998CB51869857", hash_generated_method = "384795232219284D6403E8D829D16D66")
    public FromHeader createFromHeader(Address address, String tag) throws ParseException {
        addTaint(tag.getTaint());
        addTaint(address.getTaint());
        if(address == null)        
        {
        NullPointerException varB13A65CC050DE58641D8F0978770CC55_1527936121 = new NullPointerException("null address arg");
        varB13A65CC050DE58641D8F0978770CC55_1527936121.addTaint(taint);
        throw varB13A65CC050DE58641D8F0978770CC55_1527936121;
        }
        From from = new From();
        from.setAddress(address);
        if(tag != null)        
        from.setTag(tag);
FromHeader var48A496C0AD319E4CFD66279C8D5D42FE_2116660013 =         from;
        var48A496C0AD319E4CFD66279C8D5D42FE_2116660013.addTaint(taint);
        return var48A496C0AD319E4CFD66279C8D5D42FE_2116660013;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address arg");
        //From from = new From();
        //from.setAddress(address);
        //if (tag != null)
            //from.setTag(tag);
        //return from;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.499 -0400", hash_original_method = "4DE074146D6A81FB201A39A399764E9F", hash_generated_method = "7BBE8206B2F954B57E70827D953E6D9A")
    public InReplyToHeader createInReplyToHeader(String callId) throws ParseException {
        addTaint(callId.getTaint());
        if(callId == null)        
        {
        NullPointerException varB13FA8C583E355B9E3F94958A87BC8A2_1225599448 = new NullPointerException("null callId arg");
        varB13FA8C583E355B9E3F94958A87BC8A2_1225599448.addTaint(taint);
        throw varB13FA8C583E355B9E3F94958A87BC8A2_1225599448;
        }
        InReplyTo inReplyTo = new InReplyTo();
        inReplyTo.setCallId(callId);
InReplyToHeader varD68AE97D1428FF1C23FFFC857A57F924_568217151 =         inReplyTo;
        varD68AE97D1428FF1C23FFFC857A57F924_568217151.addTaint(taint);
        return varD68AE97D1428FF1C23FFFC857A57F924_568217151;
        // ---------- Original Method ----------
        //if (callId == null)
            //throw new NullPointerException("null callId arg");
        //InReplyTo inReplyTo = new InReplyTo();
        //inReplyTo.setCallId(callId);
        //return inReplyTo;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.500 -0400", hash_original_method = "2B62AE770A28023C5424C7B7718E4BD4", hash_generated_method = "EDC6FC983C3A43B86C66FAB5B4DC8497")
    public MaxForwardsHeader createMaxForwardsHeader(int maxForwards) throws InvalidArgumentException {
        addTaint(maxForwards);
        if(maxForwards < 0 || maxForwards > 255)        
        {
        InvalidArgumentException var4ADBA25E60B51233156C4DAE056000FF_1005835132 = new InvalidArgumentException(
                "bad maxForwards arg " + maxForwards);
        var4ADBA25E60B51233156C4DAE056000FF_1005835132.addTaint(taint);
        throw var4ADBA25E60B51233156C4DAE056000FF_1005835132;
        }
        MaxForwards m = new MaxForwards();
        m.setMaxForwards(maxForwards);
MaxForwardsHeader varBD22C5ECD1F8BC3EE2416AF7A8014FD2_2019079767 =         m;
        varBD22C5ECD1F8BC3EE2416AF7A8014FD2_2019079767.addTaint(taint);
        return varBD22C5ECD1F8BC3EE2416AF7A8014FD2_2019079767;
        // ---------- Original Method ----------
        //if (maxForwards < 0 || maxForwards > 255)
            //throw new InvalidArgumentException(
                //"bad maxForwards arg " + maxForwards);
        //MaxForwards m = new MaxForwards();
        //m.setMaxForwards(maxForwards);
        //return m;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.500 -0400", hash_original_method = "623C745ED7578EC4227F3B15A38B5D4A", hash_generated_method = "68A5DAB49AE8491A618154461446866E")
    public MimeVersionHeader createMimeVersionHeader(
        int majorVersion,
        int minorVersion) throws InvalidArgumentException {
        addTaint(minorVersion);
        addTaint(majorVersion);
        if(majorVersion < 0 || minorVersion < 0)        
        {
        javax.sip.InvalidArgumentException var8492CA1CD5121DE5FD9B2CF52BE09D73_827500255 = new javax.sip.InvalidArgumentException(
                "bad major/minor version");
        var8492CA1CD5121DE5FD9B2CF52BE09D73_827500255.addTaint(taint);
        throw var8492CA1CD5121DE5FD9B2CF52BE09D73_827500255;
        }
        MimeVersion m = new MimeVersion();
        m.setMajorVersion(majorVersion);
        m.setMinorVersion(minorVersion);
MimeVersionHeader varBD22C5ECD1F8BC3EE2416AF7A8014FD2_2124329079 =         m;
        varBD22C5ECD1F8BC3EE2416AF7A8014FD2_2124329079.addTaint(taint);
        return varBD22C5ECD1F8BC3EE2416AF7A8014FD2_2124329079;
        // ---------- Original Method ----------
        //if (majorVersion < 0 || minorVersion < 0)
            //throw new javax.sip.InvalidArgumentException(
                //"bad major/minor version");
        //MimeVersion m = new MimeVersion();
        //m.setMajorVersion(majorVersion);
        //m.setMinorVersion(minorVersion);
        //return m;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.500 -0400", hash_original_method = "F897D0FECB8A8CC74BFA504858C91B42", hash_generated_method = "612A71AA6F6569FFD1097C6AB4ECCB2E")
    public MinExpiresHeader createMinExpiresHeader(int minExpires) throws InvalidArgumentException {
        addTaint(minExpires);
        if(minExpires < 0)        
        {
        InvalidArgumentException var0BEF6269B8DD8CBC7746379A17D8AE50_707303397 = new InvalidArgumentException("bad minExpires " + minExpires);
        var0BEF6269B8DD8CBC7746379A17D8AE50_707303397.addTaint(taint);
        throw var0BEF6269B8DD8CBC7746379A17D8AE50_707303397;
        }
        MinExpires min = new MinExpires();
        min.setExpires(minExpires);
MinExpiresHeader varD85D633807129E579A78008D2DCE7AA0_1724179010 =         min;
        varD85D633807129E579A78008D2DCE7AA0_1724179010.addTaint(taint);
        return varD85D633807129E579A78008D2DCE7AA0_1724179010;
        // ---------- Original Method ----------
        //if (minExpires < 0)
            //throw new InvalidArgumentException("bad minExpires " + minExpires);
        //MinExpires min = new MinExpires();
        //min.setExpires(minExpires);
        //return min;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.501 -0400", hash_original_method = "8EE941BB2D8E39A517F98D1ED3613B4D", hash_generated_method = "99BAB0C01637BD0872B497341498F694")
    public ExtensionHeader createMinSEHeader(int expires) throws InvalidArgumentException {
        addTaint(expires);
        if(expires < 0)        
        {
        InvalidArgumentException varD793F10BEC5AF07D94BCB0E147C43386_1056059603 = new InvalidArgumentException("bad value " + expires);
        varD793F10BEC5AF07D94BCB0E147C43386_1056059603.addTaint(taint);
        throw varD793F10BEC5AF07D94BCB0E147C43386_1056059603;
        }
        MinSE e = new MinSE();
        e.setExpires(expires);
ExtensionHeader var6BFFBFA2F1D556BA80433C2335198CE9_1699186070 =         e;
        var6BFFBFA2F1D556BA80433C2335198CE9_1699186070.addTaint(taint);
        return var6BFFBFA2F1D556BA80433C2335198CE9_1699186070;
        // ---------- Original Method ----------
        //if (expires < 0)
            //throw new InvalidArgumentException("bad value " + expires);
        //MinSE e = new MinSE();
        //e.setExpires(expires);
        //return e;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.501 -0400", hash_original_method = "2F5DB311D13CB6144CC7B49271775C33", hash_generated_method = "75D7A42B3A19D389A24440FFA6A0F373")
    public OrganizationHeader createOrganizationHeader(String organization) throws ParseException {
        addTaint(organization.getTaint());
        if(organization == null)        
        {
        NullPointerException var9F93DACCED6B45354A8AF698260C72F6_531166359 = new NullPointerException("bad organization arg");
        var9F93DACCED6B45354A8AF698260C72F6_531166359.addTaint(taint);
        throw var9F93DACCED6B45354A8AF698260C72F6_531166359;
        }
        Organization o = new Organization();
        o.setOrganization(organization);
OrganizationHeader varBB0FDDC5CC83552BCB5FF7675B18007A_816341067 =         o;
        varBB0FDDC5CC83552BCB5FF7675B18007A_816341067.addTaint(taint);
        return varBB0FDDC5CC83552BCB5FF7675B18007A_816341067;
        // ---------- Original Method ----------
        //if (organization == null)
            //throw new NullPointerException("bad organization arg");
        //Organization o = new Organization();
        //o.setOrganization(organization);
        //return o;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.501 -0400", hash_original_method = "085951AB405380C6C60E1EC174C5C855", hash_generated_method = "5651DB11D1E17510AFE8806967F76981")
    public PriorityHeader createPriorityHeader(String priority) throws ParseException {
        addTaint(priority.getTaint());
        if(priority == null)        
        {
        NullPointerException varF6F42D2BD8B49E3D46DE35DB64F3B92E_604874490 = new NullPointerException("bad priority arg");
        varF6F42D2BD8B49E3D46DE35DB64F3B92E_604874490.addTaint(taint);
        throw varF6F42D2BD8B49E3D46DE35DB64F3B92E_604874490;
        }
        Priority p = new Priority();
        p.setPriority(priority);
PriorityHeader var74E4690D9F2A026504928C017944E149_162240688 =         p;
        var74E4690D9F2A026504928C017944E149_162240688.addTaint(taint);
        return var74E4690D9F2A026504928C017944E149_162240688;
        // ---------- Original Method ----------
        //if (priority == null)
            //throw new NullPointerException("bad priority arg");
        //Priority p = new Priority();
        //p.setPriority(priority);
        //return p;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.501 -0400", hash_original_method = "E2D1E713D6EFBD9B5EF73CE359255B39", hash_generated_method = "2A6E8ECD015FC33F6D8F2AE5AD4AFC98")
    public ProxyAuthenticateHeader createProxyAuthenticateHeader(String scheme) throws ParseException {
        addTaint(scheme.getTaint());
        if(scheme == null)        
        {
        NullPointerException varA0F89B53E83988ECCB3AD3510E40DE72_780719632 = new NullPointerException("bad scheme arg");
        varA0F89B53E83988ECCB3AD3510E40DE72_780719632.addTaint(taint);
        throw varA0F89B53E83988ECCB3AD3510E40DE72_780719632;
        }
        ProxyAuthenticate p = new ProxyAuthenticate();
        p.setScheme(scheme);
ProxyAuthenticateHeader var74E4690D9F2A026504928C017944E149_1085051923 =         p;
        var74E4690D9F2A026504928C017944E149_1085051923.addTaint(taint);
        return var74E4690D9F2A026504928C017944E149_1085051923;
        // ---------- Original Method ----------
        //if (scheme == null)
            //throw new NullPointerException("bad scheme arg");
        //ProxyAuthenticate p = new ProxyAuthenticate();
        //p.setScheme(scheme);
        //return p;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.502 -0400", hash_original_method = "E046B5DACDD94AD026F81045FF391CD1", hash_generated_method = "C5F1912E11445D62BF6E57CF19549118")
    public ProxyAuthorizationHeader createProxyAuthorizationHeader(String scheme) throws ParseException {
        addTaint(scheme.getTaint());
        if(scheme == null)        
        {
        NullPointerException varA0F89B53E83988ECCB3AD3510E40DE72_877672385 = new NullPointerException("bad scheme arg");
        varA0F89B53E83988ECCB3AD3510E40DE72_877672385.addTaint(taint);
        throw varA0F89B53E83988ECCB3AD3510E40DE72_877672385;
        }
        ProxyAuthorization p = new ProxyAuthorization();
        p.setScheme(scheme);
ProxyAuthorizationHeader var74E4690D9F2A026504928C017944E149_946441464 =         p;
        var74E4690D9F2A026504928C017944E149_946441464.addTaint(taint);
        return var74E4690D9F2A026504928C017944E149_946441464;
        // ---------- Original Method ----------
        //if (scheme == null)
            //throw new NullPointerException("bad scheme arg");
        //ProxyAuthorization p = new ProxyAuthorization();
        //p.setScheme(scheme);
        //return p;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.502 -0400", hash_original_method = "A059B8FD47D8FC83321E2DEF4CB18490", hash_generated_method = "F590AED58F3BDBF4AEF330A8091728AD")
    public ProxyRequireHeader createProxyRequireHeader(String optionTag) throws ParseException {
        addTaint(optionTag.getTaint());
        if(optionTag == null)        
        {
        NullPointerException var386549F2204FFC26DF882B52B7F0CF19_1544367166 = new NullPointerException("bad optionTag arg");
        var386549F2204FFC26DF882B52B7F0CF19_1544367166.addTaint(taint);
        throw var386549F2204FFC26DF882B52B7F0CF19_1544367166;
        }
        ProxyRequire p = new ProxyRequire();
        p.setOptionTag(optionTag);
ProxyRequireHeader var74E4690D9F2A026504928C017944E149_1163818863 =         p;
        var74E4690D9F2A026504928C017944E149_1163818863.addTaint(taint);
        return var74E4690D9F2A026504928C017944E149_1163818863;
        // ---------- Original Method ----------
        //if (optionTag == null)
            //throw new NullPointerException("bad optionTag arg");
        //ProxyRequire p = new ProxyRequire();
        //p.setOptionTag(optionTag);
        //return p;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.502 -0400", hash_original_method = "42539302BE9490416DF1DC01B8BC3D99", hash_generated_method = "88A012A0028EFD0B33E1ADA2116FC5E3")
    public RAckHeader createRAckHeader(
        long rSeqNumber,
        long cSeqNumber,
        String method) throws InvalidArgumentException, ParseException {
        addTaint(method.getTaint());
        addTaint(cSeqNumber);
        addTaint(rSeqNumber);
        if(method == null)        
        {
        NullPointerException var8A31632CC81FE67E278C798F8DC0B26E_254278279 = new NullPointerException("Bad method");
        var8A31632CC81FE67E278C798F8DC0B26E_254278279.addTaint(taint);
        throw var8A31632CC81FE67E278C798F8DC0B26E_254278279;
        }
        if(cSeqNumber < 0 || rSeqNumber < 0)        
        {
        InvalidArgumentException var70D6FD986849A7980BD21CE67C3313D2_1345635896 = new InvalidArgumentException("bad cseq/rseq arg");
        var70D6FD986849A7980BD21CE67C3313D2_1345635896.addTaint(taint);
        throw var70D6FD986849A7980BD21CE67C3313D2_1345635896;
        }
        RAck rack = new RAck();
        rack.setMethod(method);
        rack.setCSequenceNumber(cSeqNumber);
        rack.setRSequenceNumber(rSeqNumber);
RAckHeader var55285630369F90A1D1B24F624C06D15F_1269673454 =         rack;
        var55285630369F90A1D1B24F624C06D15F_1269673454.addTaint(taint);
        return var55285630369F90A1D1B24F624C06D15F_1269673454;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.503 -0400", hash_original_method = "B44C2BD23DFFCB51A992C42D93BADE4E", hash_generated_method = "5C7AB424865705FAE4E9B79BB1B1B093")
    public RAckHeader createRAckHeader(int rSeqNumber, int cSeqNumber, String method) throws InvalidArgumentException, ParseException {
        addTaint(method.getTaint());
        addTaint(cSeqNumber);
        addTaint(rSeqNumber);
RAckHeader var0DFEE96A820BC9D494DCB5F0837AAF6A_1795218614 =         createRAckHeader((long)rSeqNumber, (long)cSeqNumber, method);
        var0DFEE96A820BC9D494DCB5F0837AAF6A_1795218614.addTaint(taint);
        return var0DFEE96A820BC9D494DCB5F0837AAF6A_1795218614;
        // ---------- Original Method ----------
        //return createRAckHeader((long)rSeqNumber, (long)cSeqNumber, method);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.503 -0400", hash_original_method = "38086BF4D4EB3CE5AB4BF7772F8EACF2", hash_generated_method = "AFB758CF7DDE4EE783CFDB9C4586487A")
    public RSeqHeader createRSeqHeader(int sequenceNumber) throws InvalidArgumentException {
        addTaint(sequenceNumber);
RSeqHeader var1B9DD1E25CC91263F0C8D46DE9A85E59_1776615688 =         createRSeqHeader((long) sequenceNumber);
        var1B9DD1E25CC91263F0C8D46DE9A85E59_1776615688.addTaint(taint);
        return var1B9DD1E25CC91263F0C8D46DE9A85E59_1776615688;
        // ---------- Original Method ----------
        //return createRSeqHeader((long) sequenceNumber) ;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.503 -0400", hash_original_method = "CA4CA07B31DF6CB609C05636F40DB22F", hash_generated_method = "582A29D6FBEBE7C011F8704DA44DF374")
    public RSeqHeader createRSeqHeader(long sequenceNumber) throws InvalidArgumentException {
        addTaint(sequenceNumber);
        if(sequenceNumber < 0)        
        {
        InvalidArgumentException varBFDDAC68A0E1346F06A7F4105BB5D866_61325717 = new InvalidArgumentException(
                "invalid sequenceNumber arg " + sequenceNumber);
        varBFDDAC68A0E1346F06A7F4105BB5D866_61325717.addTaint(taint);
        throw varBFDDAC68A0E1346F06A7F4105BB5D866_61325717;
        }
        RSeq rseq = new RSeq();
        rseq.setSeqNumber(sequenceNumber);
RSeqHeader varB6E01D29654A1562BB86607DADA039F5_1018351736 =         rseq;
        varB6E01D29654A1562BB86607DADA039F5_1018351736.addTaint(taint);
        return varB6E01D29654A1562BB86607DADA039F5_1018351736;
        // ---------- Original Method ----------
        //if (sequenceNumber < 0)
            //throw new InvalidArgumentException(
                //"invalid sequenceNumber arg " + sequenceNumber);
        //RSeq rseq = new RSeq();
        //rseq.setSeqNumber(sequenceNumber);
        //return rseq;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.503 -0400", hash_original_method = "57AD0B4E4FE03197F2B52972D6060CBA", hash_generated_method = "BD79F97A0CB3E8F72CA9FD308058C275")
    public ReasonHeader createReasonHeader(
        String protocol,
        int cause,
        String text) throws InvalidArgumentException, ParseException {
        addTaint(text.getTaint());
        addTaint(cause);
        addTaint(protocol.getTaint());
        if(protocol == null)        
        {
        NullPointerException var29C0CEBB847CB5119F14B332EA879C4A_1388392689 = new NullPointerException("bad protocol arg");
        var29C0CEBB847CB5119F14B332EA879C4A_1388392689.addTaint(taint);
        throw var29C0CEBB847CB5119F14B332EA879C4A_1388392689;
        }
        if(cause < 0)        
        {
        InvalidArgumentException varF711110E46579A941898B39DFD04655B_944438835 = new InvalidArgumentException("bad cause");
        varF711110E46579A941898B39DFD04655B_944438835.addTaint(taint);
        throw varF711110E46579A941898B39DFD04655B_944438835;
        }
        Reason reason = new Reason();
        reason.setProtocol(protocol);
        reason.setCause(cause);
        reason.setText(text);
ReasonHeader varD602C4C1684F7464133CA1A6851CC44A_1602037136 =         reason;
        varD602C4C1684F7464133CA1A6851CC44A_1602037136.addTaint(taint);
        return varD602C4C1684F7464133CA1A6851CC44A_1602037136;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.503 -0400", hash_original_method = "6DA29D8692407706B9B05391AF333993", hash_generated_method = "921CEA60751132F9B4B40C6A7F72FEC3")
    public RecordRouteHeader createRecordRouteHeader(Address address) {
        addTaint(address.getTaint());
        if(address == null)        
        {
        NullPointerException var2E325D1E8870351157D8C6AB415344DD_604754267 = new NullPointerException("Null argument!");
        var2E325D1E8870351157D8C6AB415344DD_604754267.addTaint(taint);
        throw var2E325D1E8870351157D8C6AB415344DD_604754267;
        }
        RecordRoute recordRoute = new RecordRoute();
        recordRoute.setAddress(address);
RecordRouteHeader varA6E6B75E47735133E1A83569179469B8_1717445932 =         recordRoute;
        varA6E6B75E47735133E1A83569179469B8_1717445932.addTaint(taint);
        return varA6E6B75E47735133E1A83569179469B8_1717445932;
        // ---------- Original Method ----------
        //if ( address == null) throw new NullPointerException("Null argument!");
        //RecordRoute recordRoute = new RecordRoute();
        //recordRoute.setAddress(address);
        //return recordRoute;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.503 -0400", hash_original_method = "4393C033D6B63EF338EB93DE3E753573", hash_generated_method = "E0FD0A4185ADE5BA15FC4912BD7ED3FA")
    public ReplyToHeader createReplyToHeader(Address address) {
        addTaint(address.getTaint());
        if(address == null)        
        {
        NullPointerException var3DC5AE26648CEFA4BB39A1606DD56EB1_411377191 = new NullPointerException("null address");
        var3DC5AE26648CEFA4BB39A1606DD56EB1_411377191.addTaint(taint);
        throw var3DC5AE26648CEFA4BB39A1606DD56EB1_411377191;
        }
        ReplyTo replyTo = new ReplyTo();
        replyTo.setAddress(address);
ReplyToHeader var43C4044FC3C522AE3C13CF309B9542DA_910188962 =         replyTo;
        var43C4044FC3C522AE3C13CF309B9542DA_910188962.addTaint(taint);
        return var43C4044FC3C522AE3C13CF309B9542DA_910188962;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address");
        //ReplyTo replyTo = new ReplyTo();
        //replyTo.setAddress(address);
        //return replyTo;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.504 -0400", hash_original_method = "F65B5EA444DA08358E800CD7B469501A", hash_generated_method = "CFA2349D1E5E62ACAD2FC540D390CECB")
    public RequireHeader createRequireHeader(String optionTag) throws ParseException {
        addTaint(optionTag.getTaint());
        if(optionTag == null)        
        {
        NullPointerException varBB3EE5E771CE88EAE9D5CF28870DCD80_1559144354 = new NullPointerException("null optionTag");
        varBB3EE5E771CE88EAE9D5CF28870DCD80_1559144354.addTaint(taint);
        throw varBB3EE5E771CE88EAE9D5CF28870DCD80_1559144354;
        }
        Require require = new Require();
        require.setOptionTag(optionTag);
RequireHeader varED3A0ADDA3171B6DFFBE81FB8135FA28_1229930348 =         require;
        varED3A0ADDA3171B6DFFBE81FB8135FA28_1229930348.addTaint(taint);
        return varED3A0ADDA3171B6DFFBE81FB8135FA28_1229930348;
        // ---------- Original Method ----------
        //if (optionTag == null)
            //throw new NullPointerException("null optionTag");
        //Require require = new Require();
        //require.setOptionTag(optionTag);
        //return require;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.504 -0400", hash_original_method = "43D5E8C96E4C1ED3ED5B8AD5C39C801C", hash_generated_method = "5703C328CFD9F7C5AF8308B926080480")
    public RetryAfterHeader createRetryAfterHeader(int retryAfter) throws InvalidArgumentException {
        addTaint(retryAfter);
        if(retryAfter < 0)        
        {
        InvalidArgumentException var5E335D663753BAA1818B3637467CA5D7_1731066784 = new InvalidArgumentException("bad retryAfter arg");
        var5E335D663753BAA1818B3637467CA5D7_1731066784.addTaint(taint);
        throw var5E335D663753BAA1818B3637467CA5D7_1731066784;
        }
        RetryAfter r = new RetryAfter();
        r.setRetryAfter(retryAfter);
RetryAfterHeader var4C1F3C86A0E56B6E375080F5F710547E_415052517 =         r;
        var4C1F3C86A0E56B6E375080F5F710547E_415052517.addTaint(taint);
        return var4C1F3C86A0E56B6E375080F5F710547E_415052517;
        // ---------- Original Method ----------
        //if (retryAfter < 0)
            //throw new InvalidArgumentException("bad retryAfter arg");
        //RetryAfter r = new RetryAfter();
        //r.setRetryAfter(retryAfter);
        //return r;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.504 -0400", hash_original_method = "03611E3BB30258B8EC4FDC9F783CBCCF", hash_generated_method = "22D47E70F72BF0CB7C8786C76296A8E8")
    public RouteHeader createRouteHeader(Address address) {
        addTaint(address.getTaint());
        if(address == null)        
        {
        NullPointerException varB13A65CC050DE58641D8F0978770CC55_1066589973 = new NullPointerException("null address arg");
        varB13A65CC050DE58641D8F0978770CC55_1066589973.addTaint(taint);
        throw varB13A65CC050DE58641D8F0978770CC55_1066589973;
        }
        Route route = new Route();
        route.setAddress(address);
RouteHeader var6679678B82FF79D06F753D1737D68FA6_1329099169 =         route;
        var6679678B82FF79D06F753D1737D68FA6_1329099169.addTaint(taint);
        return var6679678B82FF79D06F753D1737D68FA6_1329099169;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address arg");
        //Route route = new Route();
        //route.setAddress(address);
        //return route;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.504 -0400", hash_original_method = "65AF02D93E753F97E0AF00F542D03529", hash_generated_method = "84B1BA0F1682DC1C08924332E01DAB43")
    public ServerHeader createServerHeader(List product) throws ParseException {
        addTaint(product.getTaint());
        if(product == null)        
        {
        NullPointerException var1C78C0F8472931B367DDD776F0D85910_646699325 = new NullPointerException("null productList arg");
        var1C78C0F8472931B367DDD776F0D85910_646699325.addTaint(taint);
        throw var1C78C0F8472931B367DDD776F0D85910_646699325;
        }
        Server server = new Server();
        server.setProduct(product);
ServerHeader varCF007A6E73A4D4959380322938EA0E3D_495014741 =         server;
        varCF007A6E73A4D4959380322938EA0E3D_495014741.addTaint(taint);
        return varCF007A6E73A4D4959380322938EA0E3D_495014741;
        // ---------- Original Method ----------
        //if (product == null)
            //throw new NullPointerException("null productList arg");
        //Server server = new Server();
        //server.setProduct(product);
        //return server;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.505 -0400", hash_original_method = "288EA55C0FFC9E81469649B581E59F71", hash_generated_method = "2E56530E417C9A88305245E00EE98149")
    public SubjectHeader createSubjectHeader(String subject) throws ParseException {
        addTaint(subject.getTaint());
        if(subject == null)        
        {
        NullPointerException var8220919DE52863BEED16FB185B602832_1118095755 = new NullPointerException("null subject arg");
        var8220919DE52863BEED16FB185B602832_1118095755.addTaint(taint);
        throw var8220919DE52863BEED16FB185B602832_1118095755;
        }
        Subject s = new Subject();
        s.setSubject(subject);
SubjectHeader var0478718F0636FB61899C13801CE9FE09_849313161 =         s;
        var0478718F0636FB61899C13801CE9FE09_849313161.addTaint(taint);
        return var0478718F0636FB61899C13801CE9FE09_849313161;
        // ---------- Original Method ----------
        //if (subject == null)
            //throw new NullPointerException("null subject arg");
        //Subject s = new Subject();
        //s.setSubject(subject);
        //return s;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.505 -0400", hash_original_method = "9B68B72DA8144991BC14639C6BE11723", hash_generated_method = "B43BC9E243F06C98F5A99B73D2342263")
    public SubscriptionStateHeader createSubscriptionStateHeader(String subscriptionState) throws ParseException {
        addTaint(subscriptionState.getTaint());
        if(subscriptionState == null)        
        {
        NullPointerException var381DF38433050ABB414F5C86AFE9F070_1732029470 = new NullPointerException("null subscriptionState arg");
        var381DF38433050ABB414F5C86AFE9F070_1732029470.addTaint(taint);
        throw var381DF38433050ABB414F5C86AFE9F070_1732029470;
        }
        SubscriptionState s = new SubscriptionState();
        s.setState(subscriptionState);
SubscriptionStateHeader var0478718F0636FB61899C13801CE9FE09_480508865 =         s;
        var0478718F0636FB61899C13801CE9FE09_480508865.addTaint(taint);
        return var0478718F0636FB61899C13801CE9FE09_480508865;
        // ---------- Original Method ----------
        //if (subscriptionState == null)
            //throw new NullPointerException("null subscriptionState arg");
        //SubscriptionState s = new SubscriptionState();
        //s.setState(subscriptionState);
        //return s;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.506 -0400", hash_original_method = "589849ECCDAFDA20BE0DBE1D9A436669", hash_generated_method = "E79061E26199BEB1A65BEBA53683B681")
    public SupportedHeader createSupportedHeader(String optionTag) throws ParseException {
        addTaint(optionTag.getTaint());
        if(optionTag == null)        
        {
        NullPointerException var197E1CE6AE56D4596090EA3D944C6875_1461264264 = new NullPointerException("null optionTag arg");
        var197E1CE6AE56D4596090EA3D944C6875_1461264264.addTaint(taint);
        throw var197E1CE6AE56D4596090EA3D944C6875_1461264264;
        }
        Supported supported = new Supported();
        supported.setOptionTag(optionTag);
SupportedHeader varA336F51205FB983FAB754C908A4BC849_1193425308 =         supported;
        varA336F51205FB983FAB754C908A4BC849_1193425308.addTaint(taint);
        return varA336F51205FB983FAB754C908A4BC849_1193425308;
        // ---------- Original Method ----------
        //if (optionTag == null)
            //throw new NullPointerException("null optionTag arg");
        //Supported supported = new Supported();
        //supported.setOptionTag(optionTag);
        //return supported;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.506 -0400", hash_original_method = "380079DA7F92D6CF2CEA9086AA5F92D7", hash_generated_method = "A25A33FF4ED422150C9484263A13D7B0")
    public TimeStampHeader createTimeStampHeader(float timeStamp) throws InvalidArgumentException {
        addTaint(timeStamp);
        if(timeStamp < 0)        
        {
        IllegalArgumentException var0B7CE32DADC88EFC0D72F5BEE4FB479E_186810612 = new IllegalArgumentException("illegal timeStamp");
        var0B7CE32DADC88EFC0D72F5BEE4FB479E_186810612.addTaint(taint);
        throw var0B7CE32DADC88EFC0D72F5BEE4FB479E_186810612;
        }
        TimeStamp t = new TimeStamp();
        t.setTimeStamp(timeStamp);
TimeStampHeader varE0D714D758F1540A8DF364A965AF9150_386213476 =         t;
        varE0D714D758F1540A8DF364A965AF9150_386213476.addTaint(taint);
        return varE0D714D758F1540A8DF364A965AF9150_386213476;
        // ---------- Original Method ----------
        //if (timeStamp < 0)
            //throw new IllegalArgumentException("illegal timeStamp");
        //TimeStamp t = new TimeStamp();
        //t.setTimeStamp(timeStamp);
        //return t;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.507 -0400", hash_original_method = "7928C6AF630E4BCE57D31FA4979B7453", hash_generated_method = "1240BA3266FA0CBF01023584D7177FEF")
    public ToHeader createToHeader(Address address, String tag) throws ParseException {
        addTaint(tag.getTaint());
        addTaint(address.getTaint());
        if(address == null)        
        {
        NullPointerException var3DC5AE26648CEFA4BB39A1606DD56EB1_1111251600 = new NullPointerException("null address");
        var3DC5AE26648CEFA4BB39A1606DD56EB1_1111251600.addTaint(taint);
        throw var3DC5AE26648CEFA4BB39A1606DD56EB1_1111251600;
        }
        To to = new To();
        to.setAddress(address);
        if(tag != null)        
        to.setTag(tag);
ToHeader var26633470D0AEBDC975B85A12020B47EA_2146856875 =         to;
        var26633470D0AEBDC975B85A12020B47EA_2146856875.addTaint(taint);
        return var26633470D0AEBDC975B85A12020B47EA_2146856875;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address");
        //To to = new To();
        //to.setAddress(address);
        //if (tag != null)
            //to.setTag(tag);
        //return to;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.507 -0400", hash_original_method = "9A62FFB59334167B71BC2FE402276C31", hash_generated_method = "E9CBA8B978F6D92A880AC55D0E3C6002")
    public UnsupportedHeader createUnsupportedHeader(String optionTag) throws ParseException {
        addTaint(optionTag.getTaint());
        if(optionTag == null)        
        {
        NullPointerException var23FAE4DD19C0C26206FBF7D1B5A32522_906987008 = new NullPointerException(optionTag);
        var23FAE4DD19C0C26206FBF7D1B5A32522_906987008.addTaint(taint);
        throw var23FAE4DD19C0C26206FBF7D1B5A32522_906987008;
        }
        Unsupported unsupported = new Unsupported();
        unsupported.setOptionTag(optionTag);
UnsupportedHeader var2C8D6A66521E13DFB3C6622EE99EBB01_1167744816 =         unsupported;
        var2C8D6A66521E13DFB3C6622EE99EBB01_1167744816.addTaint(taint);
        return var2C8D6A66521E13DFB3C6622EE99EBB01_1167744816;
        // ---------- Original Method ----------
        //if (optionTag == null)
            //throw new NullPointerException(optionTag);
        //Unsupported unsupported = new Unsupported();
        //unsupported.setOptionTag(optionTag);
        //return unsupported;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.508 -0400", hash_original_method = "0FDDC4550D32FE0A8E48193D044787BB", hash_generated_method = "671CA4E70862F42E87371C71B0E6C702")
    public UserAgentHeader createUserAgentHeader(List product) throws ParseException {
        addTaint(product.getTaint());
        if(product == null)        
        {
        NullPointerException var4BCA999F6C649C38D36E052754075631_1043360565 = new NullPointerException("null user agent");
        var4BCA999F6C649C38D36E052754075631_1043360565.addTaint(taint);
        throw var4BCA999F6C649C38D36E052754075631_1043360565;
        }
        UserAgent userAgent = new UserAgent();
        userAgent.setProduct(product);
UserAgentHeader varB90BAE9CF13799DF66AC7440F5DAE3DA_714867499 =         userAgent;
        varB90BAE9CF13799DF66AC7440F5DAE3DA_714867499.addTaint(taint);
        return varB90BAE9CF13799DF66AC7440F5DAE3DA_714867499;
        // ---------- Original Method ----------
        //if (product == null)
            //throw new NullPointerException("null user agent");
        //UserAgent userAgent = new UserAgent();
        //userAgent.setProduct(product);
        //return userAgent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.508 -0400", hash_original_method = "B7A9F5DC521617567AEB2EDF2366DE24", hash_generated_method = "86D5BD46026F1D0231FB0027514D1AF4")
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
        NullPointerException varCF8D07C80828DCBD1FC1EB16BCF7D0F2_772222959 = new NullPointerException("null arg");
        varCF8D07C80828DCBD1FC1EB16BCF7D0F2_772222959.addTaint(taint);
        throw varCF8D07C80828DCBD1FC1EB16BCF7D0F2_772222959;
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
ViaHeader var744F9AD2C48AA2D9C877F464ADEF2D12_556371098 =         via;
        var744F9AD2C48AA2D9C877F464ADEF2D12_556371098.addTaint(taint);
        return var744F9AD2C48AA2D9C877F464ADEF2D12_556371098;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.509 -0400", hash_original_method = "EDE3AD5442B3DE671B6476C917BB6D0F", hash_generated_method = "9D1518C26650419CDFFC71BEF82A99C0")
    public WWWAuthenticateHeader createWWWAuthenticateHeader(String scheme) throws ParseException {
        addTaint(scheme.getTaint());
        if(scheme == null)        
        {
        NullPointerException var1AEA5D4F366FD331D1B5DABFEA649E98_981790769 = new NullPointerException("null scheme");
        var1AEA5D4F366FD331D1B5DABFEA649E98_981790769.addTaint(taint);
        throw var1AEA5D4F366FD331D1B5DABFEA649E98_981790769;
        }
        WWWAuthenticate www = new WWWAuthenticate();
        www.setScheme(scheme);
WWWAuthenticateHeader var373D84FA8665DACE10DFF8065F46F380_522555871 =         www;
        var373D84FA8665DACE10DFF8065F46F380_522555871.addTaint(taint);
        return var373D84FA8665DACE10DFF8065F46F380_522555871;
        // ---------- Original Method ----------
        //if (scheme == null)
            //throw new NullPointerException("null scheme");
        //WWWAuthenticate www = new WWWAuthenticate();
        //www.setScheme(scheme);
        //return www;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.509 -0400", hash_original_method = "F34478A6D1616AB2836BA2A212AE0D49", hash_generated_method = "E9F36920F591D34E2C453893ECCF354B")
    public WarningHeader createWarningHeader(
        String agent,
        int code,
        String comment) throws ParseException, InvalidArgumentException {
        addTaint(comment.getTaint());
        addTaint(code);
        addTaint(agent.getTaint());
        if(agent == null)        
        {
        NullPointerException varCF8D07C80828DCBD1FC1EB16BCF7D0F2_307936633 = new NullPointerException("null arg");
        varCF8D07C80828DCBD1FC1EB16BCF7D0F2_307936633.addTaint(taint);
        throw varCF8D07C80828DCBD1FC1EB16BCF7D0F2_307936633;
        }
        Warning warning = new Warning();
        warning.setAgent(agent);
        warning.setCode(code);
        warning.setText(comment);
WarningHeader var8A39DBFB7207495DDB5D7A9A922E3CEC_789050346 =         warning;
        var8A39DBFB7207495DDB5D7A9A922E3CEC_789050346.addTaint(taint);
        return var8A39DBFB7207495DDB5D7A9A922E3CEC_789050346;
        // ---------- Original Method ----------
        //if (agent == null)
            //throw new NullPointerException("null arg");
        //Warning warning = new Warning();
        //warning.setAgent(agent);
        //warning.setCode(code);
        //warning.setText(comment);
        //return warning;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.510 -0400", hash_original_method = "CB42C1424760C62123C05E2F8CB60B35", hash_generated_method = "0E8014B2C6F983EB1764D36F7D2455BE")
    public ErrorInfoHeader createErrorInfoHeader(URI errorInfo) {
        addTaint(errorInfo.getTaint());
        if(errorInfo == null)        
        {
        NullPointerException varCF8D07C80828DCBD1FC1EB16BCF7D0F2_1572096445 = new NullPointerException("null arg");
        varCF8D07C80828DCBD1FC1EB16BCF7D0F2_1572096445.addTaint(taint);
        throw varCF8D07C80828DCBD1FC1EB16BCF7D0F2_1572096445;
        }
ErrorInfoHeader varAC4EE33C2B0252F0E59C54FCD6BACAA8_1813319502 =         new ErrorInfo((GenericURI) errorInfo);
        varAC4EE33C2B0252F0E59C54FCD6BACAA8_1813319502.addTaint(taint);
        return varAC4EE33C2B0252F0E59C54FCD6BACAA8_1813319502;
        // ---------- Original Method ----------
        //if (errorInfo == null)
            //throw new NullPointerException("null arg");
        //return new ErrorInfo((GenericURI) errorInfo);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.510 -0400", hash_original_method = "7E6122EDAE408D205AF0C9E45A024F04", hash_generated_method = "D612DBE80DC816F33DBE01DD657B407B")
    public javax.sip.header.Header createHeader(String headerText) throws ParseException {
        addTaint(headerText.getTaint());
        StringMsgParser smp = new StringMsgParser();
        SIPHeader sipHeader = smp.parseSIPHeader(headerText.trim());
        if(sipHeader instanceof SIPHeaderList)        
        {
            if(((SIPHeaderList) sipHeader).size() > 1)            
            {
                ParseException var1955A4930226679B2CEA0C0577B95C61_243340073 = new ParseException(
                    "Only singleton allowed " + headerText,
                    0);
                var1955A4930226679B2CEA0C0577B95C61_243340073.addTaint(taint);
                throw var1955A4930226679B2CEA0C0577B95C61_243340073;
            } //End block
            else
            if(((SIPHeaderList) sipHeader).size() == 0)            
            {
                try 
                {
javax.sip.header.Header varB295316523F2A72D2F3C14B49031D525_1666914308 =                     (Header) ((SIPHeaderList) sipHeader)
                        .getMyClass()
                        .newInstance();
                    varB295316523F2A72D2F3C14B49031D525_1666914308.addTaint(taint);
                    return varB295316523F2A72D2F3C14B49031D525_1666914308;
                } //End block
                catch (InstantiationException ex)
                {
                    ex.printStackTrace();
javax.sip.header.Header var540C13E9E156B687226421B24F2DF178_22627649 =                     null;
                    var540C13E9E156B687226421B24F2DF178_22627649.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_22627649;
                } //End block
                catch (IllegalAccessException ex)
                {
                    ex.printStackTrace();
javax.sip.header.Header var540C13E9E156B687226421B24F2DF178_1431016844 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1431016844.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1431016844;
                } //End block
            } //End block
            else
            {
javax.sip.header.Header var7CAD833627878FD3F7B863ACAAFB2E71_252896444 =                 (Header) ((SIPHeaderList) sipHeader).getFirst();
                var7CAD833627878FD3F7B863ACAAFB2E71_252896444.addTaint(taint);
                return var7CAD833627878FD3F7B863ACAAFB2E71_252896444;
            } //End block
        } //End block
        else
        {
javax.sip.header.Header varDF77B5B4168F45421B89B792E9510A4B_224160585 =             (Header) sipHeader;
            varDF77B5B4168F45421B89B792E9510A4B_224160585.addTaint(taint);
            return varDF77B5B4168F45421B89B792E9510A4B_224160585;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.510 -0400", hash_original_method = "BE8A77015DA0080195A899A1BFDA2B08", hash_generated_method = "EAD18EE9DCD733364A4913BF5D15222F")
    public javax.sip.header.Header createHeader(
        String headerName,
        String headerValue) throws java.text.ParseException {
        addTaint(headerValue.getTaint());
        addTaint(headerName.getTaint());
        if(headerName == null)        
        {
        NullPointerException var733D8B70EC4B32137CE05F03DD83A4E5_122089648 = new NullPointerException("header name is null");
        var733D8B70EC4B32137CE05F03DD83A4E5_122089648.addTaint(taint);
        throw var733D8B70EC4B32137CE05F03DD83A4E5_122089648;
        }
        String hdrText = new StringBuffer()
                .append(headerName)
                .append(":")
                .append(headerValue)
                .toString();
javax.sip.header.Header varBD16535AB9329533F3A0DEDB01A35333_1212270065 =         createHeader(hdrText);
        varBD16535AB9329533F3A0DEDB01A35333_1212270065.addTaint(taint);
        return varBD16535AB9329533F3A0DEDB01A35333_1212270065;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.511 -0400", hash_original_method = "FDCDF9463F1CDDAF0BCBB63B8B4D05F5", hash_generated_method = "EF5A22F564A2DC106820257EBCD18D88")
    public java.util.List createHeaders(String headers) throws java.text.ParseException {
        addTaint(headers.getTaint());
        if(headers == null)        
        {
        NullPointerException var46DC74EA01AD115A93A248B83CD80DF3_1392914565 = new NullPointerException("null arg!");
        var46DC74EA01AD115A93A248B83CD80DF3_1392914565.addTaint(taint);
        throw var46DC74EA01AD115A93A248B83CD80DF3_1392914565;
        }
        StringMsgParser smp = new StringMsgParser();
        SIPHeader shdr = smp.parseSIPHeader(headers);
        if(shdr instanceof SIPHeaderList)        
        {
java.util.List varC9B92F5DCD806E11915358BFB63728E4_1817614690 =         (SIPHeaderList) shdr;
        varC9B92F5DCD806E11915358BFB63728E4_1817614690.addTaint(taint);
        return varC9B92F5DCD806E11915358BFB63728E4_1817614690;
        }
        else
        {
        ParseException var36D31F0E791914E00297F2507AD0EF01_1352688049 = new ParseException(
                "List of headers of this type is not allowed in a message",
                0);
        var36D31F0E791914E00297F2507AD0EF01_1352688049.addTaint(taint);
        throw var36D31F0E791914E00297F2507AD0EF01_1352688049;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.511 -0400", hash_original_method = "5541F8A2ED86060178CAD1F0D5BA2507", hash_generated_method = "7D8269B1FD00AA9F729AF38022E35CC4")
    public ReferToHeader createReferToHeader(Address address) {
        addTaint(address.getTaint());
        if(address == null)        
        {
        NullPointerException varE8525DFA678FE47A97D101FCF8E1FD9C_925495684 = new NullPointerException("null address!");
        varE8525DFA678FE47A97D101FCF8E1FD9C_925495684.addTaint(taint);
        throw varE8525DFA678FE47A97D101FCF8E1FD9C_925495684;
        }
        ReferTo referTo = new ReferTo();
        referTo.setAddress(address);
ReferToHeader varF03467BD7719B93D23F3A1857BAA9912_204052398 =         referTo;
        varF03467BD7719B93D23F3A1857BAA9912_204052398.addTaint(taint);
        return varF03467BD7719B93D23F3A1857BAA9912_204052398;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address!");
        //ReferTo referTo = new ReferTo();
        //referTo.setAddress(address);
        //return referTo;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.511 -0400", hash_original_method = "A51D0E58D36C2041DD351AE4FDD73BCF", hash_generated_method = "6899D69E69A89495E0F1CD1179D7A627")
    public ReferredByHeader createReferredByHeader(Address address) {
        addTaint(address.getTaint());
        if(address == null)        
        {
        NullPointerException varE8525DFA678FE47A97D101FCF8E1FD9C_217767297 = new NullPointerException("null address!");
        varE8525DFA678FE47A97D101FCF8E1FD9C_217767297.addTaint(taint);
        throw varE8525DFA678FE47A97D101FCF8E1FD9C_217767297;
        }
        ReferredBy referredBy = new ReferredBy();
        referredBy.setAddress(address);
ReferredByHeader var141045FB21A8AF64D1C5F6F1584D6BEE_1421306617 =         referredBy;
        var141045FB21A8AF64D1C5F6F1584D6BEE_1421306617.addTaint(taint);
        return var141045FB21A8AF64D1C5F6F1584D6BEE_1421306617;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address!");
        //ReferredBy referredBy = new ReferredBy();
        //referredBy.setAddress(address);
        //return referredBy;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.511 -0400", hash_original_method = "E3BB57144A133C8AFDA0829EAE12FAAB", hash_generated_method = "061E6C66E7539AA1F21C26ACB540659B")
    public ReplacesHeader createReplacesHeader(String callId, String toTag,
                String fromTag) throws ParseException {
        addTaint(fromTag.getTaint());
        addTaint(toTag.getTaint());
        addTaint(callId.getTaint());
        Replaces replaces = new Replaces();
        replaces.setCallId(callId);
        replaces.setFromTag(fromTag);
        replaces.setToTag(toTag);
ReplacesHeader varC6183C02DA53C65BFA5F0C5E1854FB03_1263149027 =         replaces;
        varC6183C02DA53C65BFA5F0C5E1854FB03_1263149027.addTaint(taint);
        return varC6183C02DA53C65BFA5F0C5E1854FB03_1263149027;
        // ---------- Original Method ----------
        //Replaces replaces = new Replaces();
        //replaces.setCallId(callId);
        //replaces.setFromTag(fromTag);
        //replaces.setToTag(toTag);
        //return replaces;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.512 -0400", hash_original_method = "C42E665E40D735B4BFD234363CD8C238", hash_generated_method = "D2E288894CA3DF6225A7F0B0B0A7FE59")
    public JoinHeader createJoinHeader(String callId, String toTag,
                String fromTag) throws ParseException {
        addTaint(fromTag.getTaint());
        addTaint(toTag.getTaint());
        addTaint(callId.getTaint());
        Join join = new Join();
        join.setCallId(callId);
        join.setFromTag(fromTag);
        join.setToTag(toTag);
JoinHeader var59C21E822A750D48D69BB7F7F2BC3BAC_1884194680 =         join;
        var59C21E822A750D48D69BB7F7F2BC3BAC_1884194680.addTaint(taint);
        return var59C21E822A750D48D69BB7F7F2BC3BAC_1884194680;
        // ---------- Original Method ----------
        //Join join = new Join();
        //join.setCallId(callId);
        //join.setFromTag(fromTag);
        //join.setToTag(toTag);
        //return join;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.512 -0400", hash_original_method = "95F88F9209912EE6FCAFCB830227A87B", hash_generated_method = "0A9322F015E1ED51D7A947475BF128B7")
    public SIPETagHeader createSIPETagHeader(String etag) throws ParseException {
        addTaint(etag.getTaint());
SIPETagHeader var291CF9A2FF2260285D5CB46C2A704F48_1996375482 =         new SIPETag(etag);
        var291CF9A2FF2260285D5CB46C2A704F48_1996375482.addTaint(taint);
        return var291CF9A2FF2260285D5CB46C2A704F48_1996375482;
        // ---------- Original Method ----------
        //return new SIPETag(etag);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.512 -0400", hash_original_method = "9EE2B60A802A938BDC15DDB307A8B1D7", hash_generated_method = "988400FDC5567BB37F36F65C8AA7FB8D")
    public SIPIfMatchHeader createSIPIfMatchHeader(String etag) throws ParseException {
        addTaint(etag.getTaint());
SIPIfMatchHeader varB410D690332AF08D0FC018DF0D69B7CE_342133025 =         new SIPIfMatch(etag);
        varB410D690332AF08D0FC018DF0D69B7CE_342133025.addTaint(taint);
        return varB410D690332AF08D0FC018DF0D69B7CE_342133025;
        // ---------- Original Method ----------
        //return new SIPIfMatch(etag);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.512 -0400", hash_original_method = "5900AA55EC6D83D47F45CED3D37DDEC7", hash_generated_method = "C9F65C7F55BF484981FC7F7B2E8FB216")
    public PAccessNetworkInfoHeader createPAccessNetworkInfoHeader() {
        PAccessNetworkInfo accessNetworkInfo = new PAccessNetworkInfo();
PAccessNetworkInfoHeader varD15244C320EF41E0D4A4D9B428353746_1931823536 =         accessNetworkInfo;
        varD15244C320EF41E0D4A4D9B428353746_1931823536.addTaint(taint);
        return varD15244C320EF41E0D4A4D9B428353746_1931823536;
        // ---------- Original Method ----------
        //PAccessNetworkInfo accessNetworkInfo = new PAccessNetworkInfo();
        //return accessNetworkInfo;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.512 -0400", hash_original_method = "7A9453157C5A8C4FD99B8F34DC853877", hash_generated_method = "1D2F6480EEE442A8EAED2D0F042C9499")
    public PAssertedIdentityHeader createPAssertedIdentityHeader(Address address) throws NullPointerException, ParseException {
        addTaint(address.getTaint());
        if(address == null)        
        {
        NullPointerException varE8525DFA678FE47A97D101FCF8E1FD9C_1937152552 = new NullPointerException("null address!");
        varE8525DFA678FE47A97D101FCF8E1FD9C_1937152552.addTaint(taint);
        throw varE8525DFA678FE47A97D101FCF8E1FD9C_1937152552;
        }
        PAssertedIdentity assertedIdentity = new PAssertedIdentity();
        assertedIdentity.setAddress(address);
PAssertedIdentityHeader var586CB37773D43E7CD1E709F401C21BB3_214387530 =         assertedIdentity;
        var586CB37773D43E7CD1E709F401C21BB3_214387530.addTaint(taint);
        return var586CB37773D43E7CD1E709F401C21BB3_214387530;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address!");
        //PAssertedIdentity assertedIdentity = new PAssertedIdentity();
        //assertedIdentity.setAddress(address);
        //return assertedIdentity;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.512 -0400", hash_original_method = "4BD897B5832A55E4A60E9B49C4611708", hash_generated_method = "F04853AE59AD07632A64D208BC84E28B")
    public PAssociatedURIHeader createPAssociatedURIHeader(Address assocURI) {
        addTaint(assocURI.getTaint());
        if(assocURI == null)        
        {
        NullPointerException var28221BBD544578F591863E5698989BB4_1328059223 = new NullPointerException("null associatedURI!");
        var28221BBD544578F591863E5698989BB4_1328059223.addTaint(taint);
        throw var28221BBD544578F591863E5698989BB4_1328059223;
        }
        PAssociatedURI associatedURI = new PAssociatedURI();
        associatedURI.setAddress(assocURI);
PAssociatedURIHeader var8DE9C24312E4E28CA8FEED92DFD9E8E3_289648589 =         associatedURI;
        var8DE9C24312E4E28CA8FEED92DFD9E8E3_289648589.addTaint(taint);
        return var8DE9C24312E4E28CA8FEED92DFD9E8E3_289648589;
        // ---------- Original Method ----------
        //if (assocURI == null)
        //throw new NullPointerException("null associatedURI!");
        //PAssociatedURI associatedURI = new PAssociatedURI();
        //associatedURI.setAddress(assocURI);
        //return associatedURI;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.513 -0400", hash_original_method = "FD713420BE4BC11FE9D9AB43BBBEAD30", hash_generated_method = "03C6C1BF446134B3943DB46B7E13628F")
    public PCalledPartyIDHeader createPCalledPartyIDHeader(Address address) {
        addTaint(address.getTaint());
        if(address == null)        
        {
        NullPointerException varE8525DFA678FE47A97D101FCF8E1FD9C_65164894 = new NullPointerException("null address!");
        varE8525DFA678FE47A97D101FCF8E1FD9C_65164894.addTaint(taint);
        throw varE8525DFA678FE47A97D101FCF8E1FD9C_65164894;
        }
        PCalledPartyID calledPartyID = new PCalledPartyID();
        calledPartyID.setAddress(address);
PCalledPartyIDHeader var7CED634B91969C8974B3C449C1A23580_1188688570 =         calledPartyID;
        var7CED634B91969C8974B3C449C1A23580_1188688570.addTaint(taint);
        return var7CED634B91969C8974B3C449C1A23580_1188688570;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address!");
        //PCalledPartyID calledPartyID = new PCalledPartyID();
        //calledPartyID.setAddress(address);
        //return calledPartyID;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.513 -0400", hash_original_method = "F3DC851C781199B1B5D5ECAC93663797", hash_generated_method = "87BD86A9A3A389060978BA1E3CAD395C")
    public PChargingFunctionAddressesHeader createPChargingFunctionAddressesHeader() {
        PChargingFunctionAddresses cfa = new PChargingFunctionAddresses();
PChargingFunctionAddressesHeader varE046E386FC389472A248E17E60EB6DEF_1225781983 =         cfa;
        varE046E386FC389472A248E17E60EB6DEF_1225781983.addTaint(taint);
        return varE046E386FC389472A248E17E60EB6DEF_1225781983;
        // ---------- Original Method ----------
        //PChargingFunctionAddresses cfa = new PChargingFunctionAddresses();
        //return cfa;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.513 -0400", hash_original_method = "E82D256C40CCFC0E4431BA44734EBBF3", hash_generated_method = "74C8DFBC654B702CAC37E268DE9E532B")
    public PChargingVectorHeader createChargingVectorHeader(String icid) throws ParseException {
        addTaint(icid.getTaint());
        if(icid == null)        
        {
        NullPointerException varFD44068B705D976744414AD0B4B432E4_2003869175 = new NullPointerException("null icid arg!");
        varFD44068B705D976744414AD0B4B432E4_2003869175.addTaint(taint);
        throw varFD44068B705D976744414AD0B4B432E4_2003869175;
        }
        PChargingVector chargingVector = new PChargingVector();
        chargingVector.setICID(icid);
PChargingVectorHeader var14792F8596B417D3663D3E76C47F07C6_971188617 =         chargingVector;
        var14792F8596B417D3663D3E76C47F07C6_971188617.addTaint(taint);
        return var14792F8596B417D3663D3E76C47F07C6_971188617;
        // ---------- Original Method ----------
        //if (icid == null)
        //throw new NullPointerException("null icid arg!");
        //PChargingVector chargingVector = new PChargingVector();
        //chargingVector.setICID(icid);
        //return chargingVector;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.513 -0400", hash_original_method = "FB93C1554D708A44568E0208A3D181E0", hash_generated_method = "4AF30714B61A3FDDF40B27C01479ED88")
    public PMediaAuthorizationHeader createPMediaAuthorizationHeader(String token) throws InvalidArgumentException, ParseException {
        addTaint(token.getTaint());
        if(token == null || token == "")        
        {
        InvalidArgumentException varB7D4EEE3C6AC4EE5886401A42EE1AABD_105300915 = new InvalidArgumentException("The Media-Authorization-Token parameter is null or empty");
        varB7D4EEE3C6AC4EE5886401A42EE1AABD_105300915.addTaint(taint);
        throw varB7D4EEE3C6AC4EE5886401A42EE1AABD_105300915;
        }
        PMediaAuthorization mediaAuthorization = new PMediaAuthorization();
        mediaAuthorization.setMediaAuthorizationToken(token);
PMediaAuthorizationHeader varB5E3A59672490506AE529DA0C24E953C_104751081 =         mediaAuthorization;
        varB5E3A59672490506AE529DA0C24E953C_104751081.addTaint(taint);
        return varB5E3A59672490506AE529DA0C24E953C_104751081;
        // ---------- Original Method ----------
        //if (token == null || token == "")
            //throw new InvalidArgumentException("The Media-Authorization-Token parameter is null or empty");
        //PMediaAuthorization mediaAuthorization = new PMediaAuthorization();
        //mediaAuthorization.setMediaAuthorizationToken(token);
        //return mediaAuthorization;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.513 -0400", hash_original_method = "3BA03116BEA38D71B8C38B4BA62E5B71", hash_generated_method = "0C19F5D5DA82F69575D6EFC9E1AF2C72")
    public PPreferredIdentityHeader createPPreferredIdentityHeader(Address address) {
        addTaint(address.getTaint());
        if(address == null)        
        {
        NullPointerException varE8525DFA678FE47A97D101FCF8E1FD9C_1549731932 = new NullPointerException("null address!");
        varE8525DFA678FE47A97D101FCF8E1FD9C_1549731932.addTaint(taint);
        throw varE8525DFA678FE47A97D101FCF8E1FD9C_1549731932;
        }
        PPreferredIdentity preferredIdentity = new PPreferredIdentity();
        preferredIdentity.setAddress(address);
PPreferredIdentityHeader varA31ABC368F16950DF3CB99008CCE7249_468041141 =         preferredIdentity;
        varA31ABC368F16950DF3CB99008CCE7249_468041141.addTaint(taint);
        return varA31ABC368F16950DF3CB99008CCE7249_468041141;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address!");
        //PPreferredIdentity preferredIdentity = new PPreferredIdentity();
        //preferredIdentity.setAddress(address);
        //return preferredIdentity;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.513 -0400", hash_original_method = "B32CA202259A9B847AD818F044EE39DA", hash_generated_method = "51B9E979469BBBBD74136980BF96A2AB")
    public PVisitedNetworkIDHeader createPVisitedNetworkIDHeader() {
        PVisitedNetworkID visitedNetworkID = new PVisitedNetworkID();
PVisitedNetworkIDHeader var6957EE20ACDD1D79BD41A02CAED798C2_1138130596 =         visitedNetworkID;
        var6957EE20ACDD1D79BD41A02CAED798C2_1138130596.addTaint(taint);
        return var6957EE20ACDD1D79BD41A02CAED798C2_1138130596;
        // ---------- Original Method ----------
        //PVisitedNetworkID visitedNetworkID = new PVisitedNetworkID();
        //return visitedNetworkID;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.513 -0400", hash_original_method = "537B18CC29F2C70486994281CB29500B", hash_generated_method = "0016585719B33C6306A58637BC8AA548")
    public PathHeader createPathHeader(Address address) {
        addTaint(address.getTaint());
        if(address == null)        
        {
        NullPointerException varE8525DFA678FE47A97D101FCF8E1FD9C_1896175255 = new NullPointerException("null address!");
        varE8525DFA678FE47A97D101FCF8E1FD9C_1896175255.addTaint(taint);
        throw varE8525DFA678FE47A97D101FCF8E1FD9C_1896175255;
        }
        Path path = new Path();
        path.setAddress(address);
PathHeader var535F4D9720F3B0C96D8143873CE0638C_1220702712 =         path;
        var535F4D9720F3B0C96D8143873CE0638C_1220702712.addTaint(taint);
        return var535F4D9720F3B0C96D8143873CE0638C_1220702712;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address!");
        //Path path = new Path();
        //path.setAddress(address);
        //return path;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.513 -0400", hash_original_method = "85C1BF55B1F968333EFFBCF4DBC75BE6", hash_generated_method = "448B019F52479E6C7F934170A33A4760")
    public PrivacyHeader createPrivacyHeader(String privacyType) {
        addTaint(privacyType.getTaint());
        if(privacyType == null)        
        {
        NullPointerException var5374F286F8F8B5AB5D244EE7B912AEA8_845858853 = new NullPointerException("null privacyType arg");
        var5374F286F8F8B5AB5D244EE7B912AEA8_845858853.addTaint(taint);
        throw var5374F286F8F8B5AB5D244EE7B912AEA8_845858853;
        }
        Privacy privacy = new Privacy(privacyType);
PrivacyHeader var28A65DCE41136C6290258CACACAD7232_2092069769 =         privacy;
        var28A65DCE41136C6290258CACACAD7232_2092069769.addTaint(taint);
        return var28A65DCE41136C6290258CACACAD7232_2092069769;
        // ---------- Original Method ----------
        //if (privacyType == null)
            //throw new NullPointerException("null privacyType arg");
        //Privacy privacy = new Privacy(privacyType);
        //return privacy;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.514 -0400", hash_original_method = "A7CA2EB6DD40139D85B6778D2C783F9F", hash_generated_method = "6CE673CBB70B14EDBDB43E149027B551")
    public ServiceRouteHeader createServiceRouteHeader(Address address) {
        addTaint(address.getTaint());
        if(address == null)        
        {
        NullPointerException varE8525DFA678FE47A97D101FCF8E1FD9C_1493669116 = new NullPointerException("null address!");
        varE8525DFA678FE47A97D101FCF8E1FD9C_1493669116.addTaint(taint);
        throw varE8525DFA678FE47A97D101FCF8E1FD9C_1493669116;
        }
        ServiceRoute serviceRoute = new ServiceRoute();
        serviceRoute.setAddress(address);
ServiceRouteHeader var053B5E67A3C405C92299DADD82C58C15_433993921 =         serviceRoute;
        var053B5E67A3C405C92299DADD82C58C15_433993921.addTaint(taint);
        return var053B5E67A3C405C92299DADD82C58C15_433993921;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address!");
        //ServiceRoute serviceRoute = new ServiceRoute();
        //serviceRoute.setAddress(address);
        //return serviceRoute;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.514 -0400", hash_original_method = "7A3E4AE36777C6F2CF79A6B3882A3053", hash_generated_method = "7CC017D49652A2CD932F291CB0F95A13")
    public SecurityServerHeader createSecurityServerHeader() {
        SecurityServer secServer = new SecurityServer();
SecurityServerHeader varB3B00B359D9C7A7FF5ACB7ADF2B29DE0_512271059 =         secServer;
        varB3B00B359D9C7A7FF5ACB7ADF2B29DE0_512271059.addTaint(taint);
        return varB3B00B359D9C7A7FF5ACB7ADF2B29DE0_512271059;
        // ---------- Original Method ----------
        //SecurityServer secServer = new SecurityServer();
        //return secServer;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.514 -0400", hash_original_method = "2361364E4BB205FAC2A8F8549D9431F6", hash_generated_method = "C24A62177E5CE770C6CB92D769BE8679")
    public SecurityClientHeader createSecurityClientHeader() {
        SecurityClient secClient = new SecurityClient();
SecurityClientHeader var765B30730561AF88047895923F1DCCDD_1252996294 =         secClient;
        var765B30730561AF88047895923F1DCCDD_1252996294.addTaint(taint);
        return var765B30730561AF88047895923F1DCCDD_1252996294;
        // ---------- Original Method ----------
        //SecurityClient secClient = new SecurityClient();
        //return secClient;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.514 -0400", hash_original_method = "1063C2554F38236C917DADCB6A55ADB8", hash_generated_method = "EC40FE57F3C79244471BD6182B1AA919")
    public SecurityVerifyHeader createSecurityVerifyHeader() {
        SecurityVerify secVerify = new SecurityVerify();
SecurityVerifyHeader var1B1489A71D080EE8E6383DDAAD133BA7_1822606268 =         secVerify;
        var1B1489A71D080EE8E6383DDAAD133BA7_1822606268.addTaint(taint);
        return var1B1489A71D080EE8E6383DDAAD133BA7_1822606268;
        // ---------- Original Method ----------
        //SecurityVerify secVerify = new SecurityVerify();
        //return secVerify;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.514 -0400", hash_original_method = "2DDC01C5DAA0917C6B8BE6B8A00F5568", hash_generated_method = "E82131C19C62A1B77EDC90D6F31E7FB5")
    public PUserDatabaseHeader createPUserDatabaseHeader(String databaseName) {
        addTaint(databaseName.getTaint());
        if((databaseName ==null)||(databaseName.equals(" ")))        
        {
        NullPointerException varA3D75CD097E396096D0DAAE2F57C8E0F_809301870 = new NullPointerException("Database name is null");
        varA3D75CD097E396096D0DAAE2F57C8E0F_809301870.addTaint(taint);
        throw varA3D75CD097E396096D0DAAE2F57C8E0F_809301870;
        }
        PUserDatabase pUserDatabase = new PUserDatabase();
        pUserDatabase.setDatabaseName(databaseName);
PUserDatabaseHeader var4329ACBB572204F8114532C71BA12EEC_1068870392 =         pUserDatabase;
        var4329ACBB572204F8114532C71BA12EEC_1068870392.addTaint(taint);
        return var4329ACBB572204F8114532C71BA12EEC_1068870392;
        // ---------- Original Method ----------
        //if((databaseName ==null)||(databaseName.equals(" ")))
            //throw new NullPointerException("Database name is null");
        //PUserDatabase pUserDatabase = new PUserDatabase();
        //pUserDatabase.setDatabaseName(databaseName);
        //return pUserDatabase;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.514 -0400", hash_original_method = "6A0691F102D20D70FD0A6921A61CA118", hash_generated_method = "0C89F3E24F1DC6F64107C22AE2039675")
    public PProfileKeyHeader createPProfileKeyHeader(Address address) {
        addTaint(address.getTaint());
        if(address ==null)        
        {
        NullPointerException var1F6D57328866E4090FEBEBA91EBDEDF8_472927505 = new NullPointerException("Address is null");
        var1F6D57328866E4090FEBEBA91EBDEDF8_472927505.addTaint(taint);
        throw var1F6D57328866E4090FEBEBA91EBDEDF8_472927505;
        }
        PProfileKey pProfileKey = new PProfileKey();
        pProfileKey.setAddress(address);
PProfileKeyHeader varEC0FDC302A29833D6488CF0AD4961908_1825656923 =         pProfileKey;
        varEC0FDC302A29833D6488CF0AD4961908_1825656923.addTaint(taint);
        return varEC0FDC302A29833D6488CF0AD4961908_1825656923;
        // ---------- Original Method ----------
        //if (address ==null)
            //throw new NullPointerException("Address is null");
        //PProfileKey pProfileKey = new PProfileKey();
        //pProfileKey.setAddress(address);
        //return pProfileKey;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.514 -0400", hash_original_method = "38B7C1667A9FD579C07BB14E255FF56A", hash_generated_method = "67B14DEC35EEF6F7D2602E37454D46A5")
    public PServedUserHeader createPServedUserHeader(Address address) {
        addTaint(address.getTaint());
        if(address==null)        
        {
        NullPointerException var1F6D57328866E4090FEBEBA91EBDEDF8_1683072719 = new NullPointerException("Address is null");
        var1F6D57328866E4090FEBEBA91EBDEDF8_1683072719.addTaint(taint);
        throw var1F6D57328866E4090FEBEBA91EBDEDF8_1683072719;
        }
        PServedUser psu = new PServedUser();
        psu.setAddress(address);
PServedUserHeader var692F8B60AB5F287F67B57796A596B4F9_593394778 =         psu;
        var692F8B60AB5F287F67B57796A596B4F9_593394778.addTaint(taint);
        return var692F8B60AB5F287F67B57796A596B4F9_593394778;
        // ---------- Original Method ----------
        //if(address==null)
            //throw new NullPointerException("Address is null");
        //PServedUser psu = new PServedUser();
        //psu.setAddress(address);
        //return psu;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.514 -0400", hash_original_method = "C0CFD4DCC2CCE8A2BE967D3A2132C68A", hash_generated_method = "A113F477366EEBD38EF339AA0C093024")
    public PPreferredServiceHeader createPPreferredServiceHeader() {
        PPreferredService pps = new PPreferredService();
PPreferredServiceHeader varC898577DF9A25F8DAE1AF7FE9C1F2518_424489142 =         pps;
        varC898577DF9A25F8DAE1AF7FE9C1F2518_424489142.addTaint(taint);
        return varC898577DF9A25F8DAE1AF7FE9C1F2518_424489142;
        // ---------- Original Method ----------
        //PPreferredService pps = new PPreferredService();
        //return pps;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.515 -0400", hash_original_method = "48E529894AF92157CD42EE8DFB6E18AB", hash_generated_method = "7D2662C7372DB1DD610A3E948332BEE5")
    public PAssertedServiceHeader createPAssertedServiceHeader() {
        PAssertedService pas = new PAssertedService();
PAssertedServiceHeader var7B54B6FCDA842A4EF6E5AEAFAFBF1E41_1307946485 =         pas;
        var7B54B6FCDA842A4EF6E5AEAFAFBF1E41_1307946485.addTaint(taint);
        return var7B54B6FCDA842A4EF6E5AEAFAFBF1E41_1307946485;
        // ---------- Original Method ----------
        //PAssertedService pas = new PAssertedService();
        //return pas;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.515 -0400", hash_original_method = "6D472F26B8815D9A75157924D7DB3DB8", hash_generated_method = "3A7FD22C18CFF6B2C1ABBD7B237E3AD1")
    public SessionExpiresHeader createSessionExpiresHeader(int expires) throws InvalidArgumentException {
        addTaint(expires);
        if(expires < 0)        
        {
        InvalidArgumentException varD793F10BEC5AF07D94BCB0E147C43386_1689685852 = new InvalidArgumentException("bad value " + expires);
        varD793F10BEC5AF07D94BCB0E147C43386_1689685852.addTaint(taint);
        throw varD793F10BEC5AF07D94BCB0E147C43386_1689685852;
        }
        SessionExpires s = new SessionExpires();
        s.setExpires(expires);
SessionExpiresHeader var0478718F0636FB61899C13801CE9FE09_854660441 =         s;
        var0478718F0636FB61899C13801CE9FE09_854660441.addTaint(taint);
        return var0478718F0636FB61899C13801CE9FE09_854660441;
        // ---------- Original Method ----------
        //if (expires < 0)
            //throw new InvalidArgumentException("bad value " + expires);
        //SessionExpires s = new SessionExpires();
        //s.setExpires(expires);
        //return s;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.515 -0400", hash_original_method = "F07701895F7EA99F66D330A17A2FD28D", hash_generated_method = "0B9FE635861FFE03AB382E05CEEF632D")
    public SipRequestLine createRequestLine(String requestLine) throws ParseException {
        addTaint(requestLine.getTaint());
        RequestLineParser requestLineParser = new RequestLineParser(requestLine);
SipRequestLine var4373A505D5EBC4D14D70210E0EBFEE5F_1671437427 =         (SipRequestLine) requestLineParser.parse();
        var4373A505D5EBC4D14D70210E0EBFEE5F_1671437427.addTaint(taint);
        return var4373A505D5EBC4D14D70210E0EBFEE5F_1671437427;
        // ---------- Original Method ----------
        //RequestLineParser requestLineParser = new RequestLineParser(requestLine);
        //return (SipRequestLine) requestLineParser.parse();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.515 -0400", hash_original_method = "94ED81BC52F6E3EE358EE57713F40357", hash_generated_method = "0A659780E6E329F50CF3613D8B56C684")
    public SipStatusLine createStatusLine(String statusLine) throws ParseException {
        addTaint(statusLine.getTaint());
        StatusLineParser statusLineParser = new StatusLineParser(statusLine);
SipStatusLine var12D9C3CA3BC7C79C668BDC85C705FE7E_190264930 =         (SipStatusLine) statusLineParser.parse();
        var12D9C3CA3BC7C79C668BDC85C705FE7E_190264930.addTaint(taint);
        return var12D9C3CA3BC7C79C668BDC85C705FE7E_190264930;
        // ---------- Original Method ----------
        //StatusLineParser statusLineParser = new StatusLineParser(statusLine);
        //return (SipStatusLine) statusLineParser.parse();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.515 -0400", hash_original_method = "B06A6A8CC80D9698711113EFD1E58499", hash_generated_method = "E8B05C3D4917DC6137634A9BFF89DAFA")
    public ReferencesHeader createReferencesHeader(String callId, String rel) throws ParseException {
        addTaint(rel.getTaint());
        addTaint(callId.getTaint());
        ReferencesHeader retval = new References();
        retval.setCallId(callId);
        retval.setRel(rel);
ReferencesHeader varF9E19AD6135C970F387F77C6F3DE4477_838215526 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_838215526.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_838215526;
        // ---------- Original Method ----------
        //ReferencesHeader retval = new References();
        //retval.setCallId(callId);
        //retval.setRel(rel);
        //return retval;
    }

    
}

