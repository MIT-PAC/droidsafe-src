package gov.nist.javax.sip.clientauthutils;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.SipStackImpl;
import gov.nist.javax.sip.address.SipUri;
import gov.nist.javax.sip.message.SIPRequest;
import gov.nist.javax.sip.stack.SIPClientTransaction;
import gov.nist.javax.sip.stack.SIPTransactionStack;
import java.text.ParseException;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Timer;
import javax.sip.ClientTransaction;
import javax.sip.DialogState;
import javax.sip.InvalidArgumentException;
import javax.sip.SipException;
import javax.sip.SipProvider;
import javax.sip.address.Hop;
import javax.sip.address.SipURI;
import javax.sip.address.URI;
import javax.sip.header.AuthorizationHeader;
import javax.sip.header.CSeqHeader;
import javax.sip.header.Header;
import javax.sip.header.HeaderFactory;
import javax.sip.header.ProxyAuthenticateHeader;
import javax.sip.header.ProxyAuthorizationHeader;
import javax.sip.header.ViaHeader;
import javax.sip.header.WWWAuthenticateHeader;
import javax.sip.message.Request;
import javax.sip.message.Response;

public class AuthenticationHelperImpl implements AuthenticationHelper {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.643 -0400", hash_original_field = "D5D9A01DEEBF6762D6D6FE216A30D468", hash_generated_field = "1A1B69CD5FD1781DFE3A277E582E290E")

    private CredentialsCache cachedCredentials;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.643 -0400", hash_original_field = "69C9987FF3C40195BFF99B67833AD04F", hash_generated_field = "BFC31B1DC824029BF180F9CDA8004E27")

    private Object accountManager = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.643 -0400", hash_original_field = "DB8E3FB60030647CE7D6D7064DCCA7DF", hash_generated_field = "1DEC16ADC00415FCFA26FDBCB5573275")

    private HeaderFactory headerFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.643 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "B028268F85C87F49A0E45B93954BF938")

    private SipStackImpl sipStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.643 -0400", hash_original_field = "2C127BF32CCB4EDF2BF22FEA5A00E494", hash_generated_field = "738C3D18449F14F8BF2AE2302B0A1011")

    Timer timer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.644 -0400", hash_original_method = "F290994E580301A1A06D86741D2EE4F7", hash_generated_method = "3415224FDE86CBFA501F38752E3A93EC")
    public  AuthenticationHelperImpl(SipStackImpl sipStack, AccountManager accountManager,
            HeaderFactory headerFactory) {
        this.accountManager = accountManager;
        this.headerFactory = headerFactory;
        this.sipStack = sipStack;
        this.cachedCredentials = new CredentialsCache(((SIPTransactionStack) sipStack).getTimer());
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.644 -0400", hash_original_method = "9D2E3CB72F7305E91EB5EE506EB32A3F", hash_generated_method = "4919A0A462594FEC3FC241FCD57CA2E3")
    public  AuthenticationHelperImpl(SipStackImpl sipStack, SecureAccountManager accountManager,
            HeaderFactory headerFactory) {
        this.accountManager = accountManager;
        this.headerFactory = headerFactory;
        this.sipStack = sipStack;
        this.cachedCredentials = new CredentialsCache(((SIPTransactionStack) sipStack).getTimer());
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.647 -0400", hash_original_method = "CD11AFCBEA5D85B140502117B9E2B2FE", hash_generated_method = "6CB023060087B5DA0BBF98F87B0FFF9E")
    public ClientTransaction handleChallenge(Response challenge,
            ClientTransaction challengedTransaction, SipProvider transactionCreator, int cacheTime) throws SipException, NullPointerException {
        ClientTransaction varB4EAC82CA7396A68D541C85D26508E83_1429274100 = null; 
        try 
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_2047718680 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logDebug("handleChallenge: " + challenge);
                } 
            } 
            SIPRequest challengedRequest = ((SIPRequest) challengedTransaction.getRequest());
            Request reoriginatedRequest = null;
            {
                boolean var84DC6B093324ECB6DC5CD376ABAB415E_1570653618 = (challengedRequest.getToTag() != null  ||
                    challengedTransaction.getDialog() == null ||
                    challengedTransaction.getDialog().getState() != DialogState.CONFIRMED);
                {
                    reoriginatedRequest = (Request) challengedRequest.clone();
                } 
                {
                    reoriginatedRequest =
                    challengedTransaction.getDialog().createRequest(challengedRequest.getMethod());
                    Iterator<String> headerNames = challengedRequest.getHeaderNames();
                    {
                        boolean var1B19958101823B6B38155B92C8E506B0_1856443536 = (headerNames.hasNext());
                        {
                            String headerName = headerNames.next();
                            {
                                boolean var270A70981A5F45664D8E072313B972FE_865229985 = (reoriginatedRequest.getHeader(headerName) != null);
                                {
                                    ListIterator<Header> iterator = reoriginatedRequest.getHeaders(headerName);
                                    {
                                        boolean varD953982CEBD49C2A8AA2B3ADB352204B_2085531584 = (iterator.hasNext());
                                        {
                                            reoriginatedRequest.addHeader(iterator.next());
                                        } 
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            removeBranchID(reoriginatedRequest);
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("A null argument was passed to handle challenge.");
            } 
            ListIterator authHeaders = null;
            {
                boolean var7E61F082459B37C0AFB08E4F53227E41_1103243373 = (challenge.getStatusCode() == Response.UNAUTHORIZED);
                {
                    authHeaders = challenge.getHeaders(WWWAuthenticateHeader.NAME);
                } 
                {
                    boolean var3F6C5FE7365EA14B255312741E585648_1415229094 = (challenge.getStatusCode() == Response.PROXY_AUTHENTICATION_REQUIRED);
                    {
                        authHeaders = challenge.getHeaders(ProxyAuthenticateHeader.NAME);
                    } 
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unexpected status code ");
                    } 
                } 
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                        "Could not find WWWAuthenticate or ProxyAuthenticate headers");
            } 
            reoriginatedRequest.removeHeader(AuthorizationHeader.NAME);
            reoriginatedRequest.removeHeader(ProxyAuthorizationHeader.NAME);
            CSeqHeader cSeq = (CSeqHeader) reoriginatedRequest.getHeader((CSeqHeader.NAME));
            try 
            {
                cSeq.setSeqNumber(cSeq.getSeqNumber() + 1l);
            } 
            catch (InvalidArgumentException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("Invalid CSeq -- could not increment : "
                        + cSeq.getSeqNumber());
            } 
            {
                boolean varC4EBC95B9BD32950D7D9394D60CFDFE9_2045110833 = (challengedRequest.getRouteHeaders() == null);
                {
                    Hop hop = ((SIPClientTransaction) challengedTransaction).getNextHop();
                    SipURI sipUri = (SipURI) reoriginatedRequest.getRequestURI();
                    {
                        boolean var841AE3DE7262EDC140B3815FEB3D6901_373039996 = (!hop.getHost().equalsIgnoreCase(sipUri.getHost())
                        && !hop.equals(sipStack.getRouter(challengedRequest).getOutboundProxy()));
                        sipUri.setMAddrParam(hop.getHost());
                    } 
                    {
                        boolean var69B03C61B12EC7C13A31E0022669C925_815106611 = (hop.getPort() != -1);
                        sipUri.setPort(hop.getPort());
                    } 
                } 
            } 
            ClientTransaction retryTran = transactionCreator
            .getNewClientTransaction(reoriginatedRequest);
            WWWAuthenticateHeader authHeader = null;
            SipURI requestUri = (SipURI) challengedTransaction.getRequest().getRequestURI();
            {
                boolean var502FFDBFD46B1F7EAA9EF3A4B3E497F5_1626028624 = (authHeaders.hasNext());
                {
                    authHeader = (WWWAuthenticateHeader) authHeaders.next();
                    String realm = authHeader.getRealm();
                    AuthorizationHeader authorization = null;
                    String sipDomain;
                    {
                        UserCredentialHash credHash = ((SecureAccountManager)this.accountManager).getCredentialHash(challengedTransaction,realm);
                        URI uri = reoriginatedRequest.getRequestURI();
                        sipDomain = credHash.getSipDomain();
                        authorization = this.getAuthorization(reoriginatedRequest
                            .getMethod(), uri.toString(),
                            (reoriginatedRequest.getContent() == null) ? "" : new String(
                            reoriginatedRequest.getRawContent()), authHeader, credHash);
                    } 
                    {
                        UserCredentials userCreds = ((AccountManager) this.accountManager).getCredentials(challengedTransaction, realm);
                        sipDomain = userCreds.getSipDomain();
                        if (DroidSafeAndroidRuntime.control) throw new SipException(
                            "Cannot find user creds for the given user name and realm");
                        authorization = this.getAuthorization(reoriginatedRequest
                                .getMethod(), reoriginatedRequest.getRequestURI().toString(),
                                (reoriginatedRequest.getContent() == null) ? "" : new String(
                                reoriginatedRequest.getRawContent()), authHeader, userCreds);
                    } 
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1863418913 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug(
                        "Created authorization header: " + authorization.toString());
                    } 
                    cachedCredentials.cacheAuthorizationHeader(sipDomain,
                            authorization, cacheTime);
                    reoriginatedRequest.addHeader(authorization);
                } 
            } 
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_901408106 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logDebug(
                        "Returning authorization transaction." + retryTran);
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1429274100 = retryTran;
        } 
        catch (SipException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw ex;
        } 
        catch (Exception ex)
        {
            sipStack.getStackLogger().logError("Unexpected exception ", ex);
            if (DroidSafeAndroidRuntime.control) throw new SipException("Unexpected exception ", ex);
        } 
        addTaint(challenge.getTaint());
        addTaint(challengedTransaction.getTaint());
        addTaint(transactionCreator.getTaint());
        addTaint(cacheTime);
        varB4EAC82CA7396A68D541C85D26508E83_1429274100.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1429274100;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.649 -0400", hash_original_method = "2D1C964540C22A20DCB24ADF01A4F207", hash_generated_method = "6731C82BC853A58D2408C73F4940263B")
    private AuthorizationHeader getAuthorization(String method, String uri, String requestBody,
            WWWAuthenticateHeader authHeader, UserCredentials userCredentials) {
        AuthorizationHeader varB4EAC82CA7396A68D541C85D26508E83_960874856 = null; 
        String response = null;
        String qopList = authHeader.getQop();
        String qop;
        qop = "auth";
        qop = null;
        String nc_value = "00000001";
        String cnonce = "xyz";
        response = MessageDigestAlgorithm.calculateResponse(authHeader.getAlgorithm(),
                userCredentials.getUserName(), authHeader.getRealm(), userCredentials
                        .getPassword(), authHeader.getNonce(), nc_value, 
                cnonce, 
                method, uri, requestBody, qop,sipStack.getStackLogger());
        AuthorizationHeader authorization = null;
        try 
        {
            {
                authorization = headerFactory.createProxyAuthorizationHeader(authHeader
                        .getScheme());
            } 
            {
                authorization = headerFactory.createAuthorizationHeader(authHeader.getScheme());
            } 
            authorization.setUsername(userCredentials.getUserName());
            authorization.setRealm(authHeader.getRealm());
            authorization.setNonce(authHeader.getNonce());
            authorization.setParameter("uri", uri);
            authorization.setResponse(response);
            {
                boolean varA19E9C0577AD2CC5719031389F3AF03F_565340385 = (authHeader.getAlgorithm() != null);
                {
                    authorization.setAlgorithm(authHeader.getAlgorithm());
                } 
            } 
            {
                boolean varAF1F3E9686F7AA3F141EE79D05D3AE0F_2100859767 = (authHeader.getOpaque() != null);
                {
                    authorization.setOpaque(authHeader.getOpaque());
                } 
            } 
            {
                authorization.setQop(qop);
                authorization.setCNonce(cnonce);
                authorization.setNonceCount(Integer.parseInt(nc_value));
            } 
            authorization.setResponse(response);
        } 
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Failed to create an authorization header!");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_960874856 = authorization;
        addTaint(method.getTaint());
        addTaint(uri.getTaint());
        addTaint(requestBody.getTaint());
        addTaint(authHeader.getTaint());
        addTaint(userCredentials.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_960874856.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_960874856;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.650 -0400", hash_original_method = "122A01004B39FE573FF7374B710A1EFB", hash_generated_method = "D0C389DD99DD5644CAC8292892DD9258")
    private AuthorizationHeader getAuthorization(String method, String uri, String requestBody,
            WWWAuthenticateHeader authHeader, UserCredentialHash userCredentials) {
        AuthorizationHeader varB4EAC82CA7396A68D541C85D26508E83_1386782794 = null; 
        String response = null;
        String qopList = authHeader.getQop();
        String qop;
        qop = "auth";
        qop = null;
        String nc_value = "00000001";
        String cnonce = "xyz";
        response = MessageDigestAlgorithm.calculateResponse(authHeader.getAlgorithm(),
              userCredentials.getHashUserDomainPassword(), authHeader.getNonce(), nc_value, 
                cnonce, 
                method, uri, requestBody, qop,sipStack.getStackLogger());
        AuthorizationHeader authorization = null;
        try 
        {
            {
                authorization = headerFactory.createProxyAuthorizationHeader(authHeader
                        .getScheme());
            } 
            {
                authorization = headerFactory.createAuthorizationHeader(authHeader.getScheme());
            } 
            authorization.setUsername(userCredentials.getUserName());
            authorization.setRealm(authHeader.getRealm());
            authorization.setNonce(authHeader.getNonce());
            authorization.setParameter("uri", uri);
            authorization.setResponse(response);
            {
                boolean varA19E9C0577AD2CC5719031389F3AF03F_1295072083 = (authHeader.getAlgorithm() != null);
                {
                    authorization.setAlgorithm(authHeader.getAlgorithm());
                } 
            } 
            {
                boolean varAF1F3E9686F7AA3F141EE79D05D3AE0F_1971913163 = (authHeader.getOpaque() != null);
                {
                    authorization.setOpaque(authHeader.getOpaque());
                } 
            } 
            {
                authorization.setQop(qop);
                authorization.setCNonce(cnonce);
                authorization.setNonceCount(Integer.parseInt(nc_value));
            } 
            authorization.setResponse(response);
        } 
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Failed to create an authorization header!");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1386782794 = authorization;
        addTaint(method.getTaint());
        addTaint(uri.getTaint());
        addTaint(requestBody.getTaint());
        addTaint(authHeader.getTaint());
        addTaint(userCredentials.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1386782794.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1386782794;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.650 -0400", hash_original_method = "ADD4EE56A02B7B5492F16169DF575C77", hash_generated_method = "A7CC263C61734DEC54C681AF9EB74DCE")
    private void removeBranchID(Request request) {
        ViaHeader viaHeader = (ViaHeader) request.getHeader(ViaHeader.NAME);
        viaHeader.removeParameter("branch");
        addTaint(request.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.654 -0400", hash_original_method = "B9EE184222D97BBFBAC451553E77E803", hash_generated_method = "40CF7625464A9474F1926242087E897E")
    public void setAuthenticationHeaders(Request request) {
        SIPRequest sipRequest = (SIPRequest) request;
        String callId = sipRequest.getCallId().getCallId();
        request.removeHeader(AuthorizationHeader.NAME);
        Collection<AuthorizationHeader> authHeaders = this.cachedCredentials
                .getCachedAuthorizationHeaders(callId);
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_504469147 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug(
                    "Could not find authentication headers for " + callId);
            } 
        } 
        {
            Iterator<AuthorizationHeader> var55A62473FF3B1BF5FAC49D8739006C34_1177206899 = (authHeaders).iterator();
            var55A62473FF3B1BF5FAC49D8739006C34_1177206899.hasNext();
            AuthorizationHeader authHeader = var55A62473FF3B1BF5FAC49D8739006C34_1177206899.next();
            {
                request.addHeader(authHeader);
            } 
        } 
        addTaint(request.getTaint());
        
        
        
        
        
                
        
        	
        		
                    
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.655 -0400", hash_original_method = "43BBEEB97A3047C63D843E4DFDBBA534", hash_generated_method = "DF07FC0587507BE7A5A04B1E5FD4F897")
    public void removeCachedAuthenticationHeaders(String callId) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null callId argument ");
        this.cachedCredentials.removeAuthenticationHeader(callId);
        addTaint(callId.getTaint());
        
        
            
        
    }

    
}

