package gov.nist.javax.sip.clientauthutils;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.414 -0400", hash_original_field = "D5D9A01DEEBF6762D6D6FE216A30D468", hash_generated_field = "1A1B69CD5FD1781DFE3A277E582E290E")

    private CredentialsCache cachedCredentials;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.415 -0400", hash_original_field = "69C9987FF3C40195BFF99B67833AD04F", hash_generated_field = "BFC31B1DC824029BF180F9CDA8004E27")

    private Object accountManager = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.415 -0400", hash_original_field = "DB8E3FB60030647CE7D6D7064DCCA7DF", hash_generated_field = "1DEC16ADC00415FCFA26FDBCB5573275")

    private HeaderFactory headerFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.415 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "B028268F85C87F49A0E45B93954BF938")

    private SipStackImpl sipStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.415 -0400", hash_original_field = "2C127BF32CCB4EDF2BF22FEA5A00E494", hash_generated_field = "738C3D18449F14F8BF2AE2302B0A1011")

    Timer timer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.416 -0400", hash_original_method = "F290994E580301A1A06D86741D2EE4F7", hash_generated_method = "3415224FDE86CBFA501F38752E3A93EC")
    public  AuthenticationHelperImpl(SipStackImpl sipStack, AccountManager accountManager,
            HeaderFactory headerFactory) {
        this.accountManager = accountManager;
        this.headerFactory = headerFactory;
        this.sipStack = sipStack;
        this.cachedCredentials = new CredentialsCache(((SIPTransactionStack) sipStack).getTimer());
        // ---------- Original Method ----------
        //this.accountManager = accountManager;
        //this.headerFactory = headerFactory;
        //this.sipStack = sipStack;
        //this.cachedCredentials = new CredentialsCache(((SIPTransactionStack) sipStack).getTimer());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.418 -0400", hash_original_method = "9D2E3CB72F7305E91EB5EE506EB32A3F", hash_generated_method = "4919A0A462594FEC3FC241FCD57CA2E3")
    public  AuthenticationHelperImpl(SipStackImpl sipStack, SecureAccountManager accountManager,
            HeaderFactory headerFactory) {
        this.accountManager = accountManager;
        this.headerFactory = headerFactory;
        this.sipStack = sipStack;
        this.cachedCredentials = new CredentialsCache(((SIPTransactionStack) sipStack).getTimer());
        // ---------- Original Method ----------
        //this.accountManager = accountManager;
        //this.headerFactory = headerFactory;
        //this.sipStack = sipStack;
        //this.cachedCredentials = new CredentialsCache(((SIPTransactionStack) sipStack).getTimer());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.423 -0400", hash_original_method = "CD11AFCBEA5D85B140502117B9E2B2FE", hash_generated_method = "74F608BB73C112CE32B8C2DAFD6BAABA")
    public ClientTransaction handleChallenge(Response challenge,
            ClientTransaction challengedTransaction, SipProvider transactionCreator, int cacheTime) throws SipException, NullPointerException {
        addTaint(cacheTime);
        addTaint(transactionCreator.getTaint());
        addTaint(challengedTransaction.getTaint());
        addTaint(challenge.getTaint());
        try 
        {
            if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logDebug("handleChallenge: " + challenge);
            } //End block
            SIPRequest challengedRequest = ((SIPRequest) challengedTransaction.getRequest());
            Request reoriginatedRequest = null;
            if(challengedRequest.getToTag() != null  ||
                    challengedTransaction.getDialog() == null ||
                    challengedTransaction.getDialog().getState() != DialogState.CONFIRMED)            
            {
                reoriginatedRequest = (Request) challengedRequest.clone();
            } //End block
            else
            {
                reoriginatedRequest =
                    challengedTransaction.getDialog().createRequest(challengedRequest.getMethod());
                Iterator<String> headerNames = challengedRequest.getHeaderNames();
                while
(headerNames.hasNext())                
                {
                    String headerName = headerNames.next();
                    if(reoriginatedRequest.getHeader(headerName) != null)                    
                    {
                        ListIterator<Header> iterator = reoriginatedRequest.getHeaders(headerName);
                        while
(iterator.hasNext())                        
                        {
                            reoriginatedRequest.addHeader(iterator.next());
                        } //End block
                    } //End block
                } //End block
            } //End block
            removeBranchID(reoriginatedRequest);
            if(challenge == null || reoriginatedRequest == null)            
            {
                NullPointerException var96AE484122920EF0F496DF5CF25A9C99_1104806080 = new NullPointerException("A null argument was passed to handle challenge.");
                var96AE484122920EF0F496DF5CF25A9C99_1104806080.addTaint(taint);
                throw var96AE484122920EF0F496DF5CF25A9C99_1104806080;
            } //End block
            ListIterator authHeaders = null;
            if(challenge.getStatusCode() == Response.UNAUTHORIZED)            
            {
                authHeaders = challenge.getHeaders(WWWAuthenticateHeader.NAME);
            } //End block
            else
            if(challenge.getStatusCode() == Response.PROXY_AUTHENTICATION_REQUIRED)            
            {
                authHeaders = challenge.getHeaders(ProxyAuthenticateHeader.NAME);
            } //End block
            else
            {
                IllegalArgumentException var4B7EC1EF21A4DA6270AF6945CAACE17E_1597227134 = new IllegalArgumentException("Unexpected status code ");
                var4B7EC1EF21A4DA6270AF6945CAACE17E_1597227134.addTaint(taint);
                throw var4B7EC1EF21A4DA6270AF6945CAACE17E_1597227134;
            } //End block
            if(authHeaders == null)            
            {
                IllegalArgumentException var1E208C1F7B8D9E636C17AFCC8E1F1619_274318066 = new IllegalArgumentException(
                        "Could not find WWWAuthenticate or ProxyAuthenticate headers");
                var1E208C1F7B8D9E636C17AFCC8E1F1619_274318066.addTaint(taint);
                throw var1E208C1F7B8D9E636C17AFCC8E1F1619_274318066;
            } //End block
            reoriginatedRequest.removeHeader(AuthorizationHeader.NAME);
            reoriginatedRequest.removeHeader(ProxyAuthorizationHeader.NAME);
            CSeqHeader cSeq = (CSeqHeader) reoriginatedRequest.getHeader((CSeqHeader.NAME));
            try 
            {
                cSeq.setSeqNumber(cSeq.getSeqNumber() + 1l);
            } //End block
            catch (InvalidArgumentException ex)
            {
                SipException varF9C8340A70DD6D297A4E06531564AD95_1548930038 = new SipException("Invalid CSeq -- could not increment : "
                        + cSeq.getSeqNumber());
                varF9C8340A70DD6D297A4E06531564AD95_1548930038.addTaint(taint);
                throw varF9C8340A70DD6D297A4E06531564AD95_1548930038;
            } //End block
            if(challengedRequest.getRouteHeaders() == null)            
            {
                Hop hop = ((SIPClientTransaction) challengedTransaction).getNextHop();
                SipURI sipUri = (SipURI) reoriginatedRequest.getRequestURI();
                if(!hop.getHost().equalsIgnoreCase(sipUri.getHost())
                        && !hop.equals(sipStack.getRouter(challengedRequest).getOutboundProxy()))                
                sipUri.setMAddrParam(hop.getHost());
                if(hop.getPort() != -1)                
                sipUri.setPort(hop.getPort());
            } //End block
            ClientTransaction retryTran = transactionCreator
            .getNewClientTransaction(reoriginatedRequest);
            WWWAuthenticateHeader authHeader = null;
            SipURI requestUri = (SipURI) challengedTransaction.getRequest().getRequestURI();
            while
(authHeaders.hasNext())            
            {
                authHeader = (WWWAuthenticateHeader) authHeaders.next();
                String realm = authHeader.getRealm();
                AuthorizationHeader authorization = null;
                String sipDomain;
                if(this.accountManager instanceof SecureAccountManager)                
                {
                    UserCredentialHash credHash = ((SecureAccountManager)this.accountManager).getCredentialHash(challengedTransaction,realm);
                    URI uri = reoriginatedRequest.getRequestURI();
                    sipDomain = credHash.getSipDomain();
                    authorization = this.getAuthorization(reoriginatedRequest
                            .getMethod(), uri.toString(),
                            (reoriginatedRequest.getContent() == null) ? "" : new String(
                            reoriginatedRequest.getRawContent()), authHeader, credHash);
                } //End block
                else
                {
                    UserCredentials userCreds = ((AccountManager) this.accountManager).getCredentials(challengedTransaction, realm);
                    sipDomain = userCreds.getSipDomain();
                    if(userCreds == null)                    
                    {
                    SipException var001D950E5D3CA43067D2C277FAC3E2E7_873038759 = new SipException(
                            "Cannot find user creds for the given user name and realm");
                    var001D950E5D3CA43067D2C277FAC3E2E7_873038759.addTaint(taint);
                    throw var001D950E5D3CA43067D2C277FAC3E2E7_873038759;
                    }
                    authorization = this.getAuthorization(reoriginatedRequest
                                .getMethod(), reoriginatedRequest.getRequestURI().toString(),
                                (reoriginatedRequest.getContent() == null) ? "" : new String(
                                reoriginatedRequest.getRawContent()), authHeader, userCreds);
                } //End block
                if(sipStack.isLoggingEnabled())                
                sipStack.getStackLogger().logDebug(
                        "Created authorization header: " + authorization.toString());
                if(cacheTime != 0)                
                cachedCredentials.cacheAuthorizationHeader(sipDomain,
                            authorization, cacheTime);
                reoriginatedRequest.addHeader(authorization);
            } //End block
            if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logDebug(
                        "Returning authorization transaction." + retryTran);
            } //End block
ClientTransaction var6D5F25C6C85A276C275EA81740691138_464217576 =             retryTran;
            var6D5F25C6C85A276C275EA81740691138_464217576.addTaint(taint);
            return var6D5F25C6C85A276C275EA81740691138_464217576;
        } //End block
        catch (SipException ex)
        {
            ex.addTaint(taint);
            throw ex;
        } //End block
        catch (Exception ex)
        {
            sipStack.getStackLogger().logError("Unexpected exception ", ex);
            SipException var1A4662A0F3A987419E1A097573C62349_1759443962 = new SipException("Unexpected exception ", ex);
            var1A4662A0F3A987419E1A097573C62349_1759443962.addTaint(taint);
            throw var1A4662A0F3A987419E1A097573C62349_1759443962;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.426 -0400", hash_original_method = "2D1C964540C22A20DCB24ADF01A4F207", hash_generated_method = "9CDD65F33498225E8E1B7BF3CC485EF3")
    private AuthorizationHeader getAuthorization(String method, String uri, String requestBody,
            WWWAuthenticateHeader authHeader, UserCredentials userCredentials) {
        addTaint(userCredentials.getTaint());
        addTaint(authHeader.getTaint());
        addTaint(requestBody.getTaint());
        addTaint(uri.getTaint());
        addTaint(method.getTaint());
        String response = null;
        String qopList = authHeader.getQop();
        String qop = (qopList != null) ? "auth" : null;
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
            if(authHeader instanceof ProxyAuthenticateHeader)            
            {
                authorization = headerFactory.createProxyAuthorizationHeader(authHeader
                        .getScheme());
            } //End block
            else
            {
                authorization = headerFactory.createAuthorizationHeader(authHeader.getScheme());
            } //End block
            authorization.setUsername(userCredentials.getUserName());
            authorization.setRealm(authHeader.getRealm());
            authorization.setNonce(authHeader.getNonce());
            authorization.setParameter("uri", uri);
            authorization.setResponse(response);
            if(authHeader.getAlgorithm() != null)            
            {
                authorization.setAlgorithm(authHeader.getAlgorithm());
            } //End block
            if(authHeader.getOpaque() != null)            
            {
                authorization.setOpaque(authHeader.getOpaque());
            } //End block
            if(qop != null)            
            {
                authorization.setQop(qop);
                authorization.setCNonce(cnonce);
                authorization.setNonceCount(Integer.parseInt(nc_value));
            } //End block
            authorization.setResponse(response);
        } //End block
        catch (ParseException ex)
        {
            RuntimeException var6EBD9670529156F76A0E9D60BC2193CF_852866313 = new RuntimeException("Failed to create an authorization header!");
            var6EBD9670529156F76A0E9D60BC2193CF_852866313.addTaint(taint);
            throw var6EBD9670529156F76A0E9D60BC2193CF_852866313;
        } //End block
AuthorizationHeader var5359E7C10DEDB97213426417D84B7B29_119518739 =         authorization;
        var5359E7C10DEDB97213426417D84B7B29_119518739.addTaint(taint);
        return var5359E7C10DEDB97213426417D84B7B29_119518739;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.443 -0400", hash_original_method = "122A01004B39FE573FF7374B710A1EFB", hash_generated_method = "05470B0E9D311D4D5EF9A2E29260057D")
    private AuthorizationHeader getAuthorization(String method, String uri, String requestBody,
            WWWAuthenticateHeader authHeader, UserCredentialHash userCredentials) {
        addTaint(userCredentials.getTaint());
        addTaint(authHeader.getTaint());
        addTaint(requestBody.getTaint());
        addTaint(uri.getTaint());
        addTaint(method.getTaint());
        String response = null;
        String qopList = authHeader.getQop();
        String qop = (qopList != null) ? "auth" : null;
        String nc_value = "00000001";
        String cnonce = "xyz";
        response = MessageDigestAlgorithm.calculateResponse(authHeader.getAlgorithm(),
              userCredentials.getHashUserDomainPassword(), authHeader.getNonce(), nc_value, 
                cnonce, 
                method, uri, requestBody, qop,sipStack.getStackLogger());
        AuthorizationHeader authorization = null;
        try 
        {
            if(authHeader instanceof ProxyAuthenticateHeader)            
            {
                authorization = headerFactory.createProxyAuthorizationHeader(authHeader
                        .getScheme());
            } //End block
            else
            {
                authorization = headerFactory.createAuthorizationHeader(authHeader.getScheme());
            } //End block
            authorization.setUsername(userCredentials.getUserName());
            authorization.setRealm(authHeader.getRealm());
            authorization.setNonce(authHeader.getNonce());
            authorization.setParameter("uri", uri);
            authorization.setResponse(response);
            if(authHeader.getAlgorithm() != null)            
            {
                authorization.setAlgorithm(authHeader.getAlgorithm());
            } //End block
            if(authHeader.getOpaque() != null)            
            {
                authorization.setOpaque(authHeader.getOpaque());
            } //End block
            if(qop != null)            
            {
                authorization.setQop(qop);
                authorization.setCNonce(cnonce);
                authorization.setNonceCount(Integer.parseInt(nc_value));
            } //End block
            authorization.setResponse(response);
        } //End block
        catch (ParseException ex)
        {
            RuntimeException var6EBD9670529156F76A0E9D60BC2193CF_1349105465 = new RuntimeException("Failed to create an authorization header!");
            var6EBD9670529156F76A0E9D60BC2193CF_1349105465.addTaint(taint);
            throw var6EBD9670529156F76A0E9D60BC2193CF_1349105465;
        } //End block
AuthorizationHeader var5359E7C10DEDB97213426417D84B7B29_1443690413 =         authorization;
        var5359E7C10DEDB97213426417D84B7B29_1443690413.addTaint(taint);
        return var5359E7C10DEDB97213426417D84B7B29_1443690413;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.443 -0400", hash_original_method = "ADD4EE56A02B7B5492F16169DF575C77", hash_generated_method = "29012D0024263DF94FEF9012D9E2BD76")
    private void removeBranchID(Request request) {
        addTaint(request.getTaint());
        ViaHeader viaHeader = (ViaHeader) request.getHeader(ViaHeader.NAME);
        viaHeader.removeParameter("branch");
        // ---------- Original Method ----------
        //ViaHeader viaHeader = (ViaHeader) request.getHeader(ViaHeader.NAME);
        //viaHeader.removeParameter("branch");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.444 -0400", hash_original_method = "B9EE184222D97BBFBAC451553E77E803", hash_generated_method = "1ED2562B19815AF6F331564341AC44AD")
    public void setAuthenticationHeaders(Request request) {
        addTaint(request.getTaint());
        SIPRequest sipRequest = (SIPRequest) request;
        String callId = sipRequest.getCallId().getCallId();
        request.removeHeader(AuthorizationHeader.NAME);
        Collection<AuthorizationHeader> authHeaders = this.cachedCredentials
                .getCachedAuthorizationHeaders(callId);
        if(authHeaders == null)        
        {
            if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logDebug(
                    "Could not find authentication headers for " + callId);
            return;
        } //End block
for(AuthorizationHeader authHeader : authHeaders)
        {
            request.addHeader(authHeader);
        } //End block
        // ---------- Original Method ----------
        //SIPRequest sipRequest = (SIPRequest) request;
        //String callId = sipRequest.getCallId().getCallId();
        //request.removeHeader(AuthorizationHeader.NAME);
        //Collection<AuthorizationHeader> authHeaders = this.cachedCredentials
                //.getCachedAuthorizationHeaders(callId);
        //if (authHeaders == null) {
        	//if (sipStack.isLoggingEnabled())
        		//sipStack.getStackLogger().logDebug(
                    //"Could not find authentication headers for " + callId);
            //return;
        //}
        //for (AuthorizationHeader authHeader : authHeaders) {
            //request.addHeader(authHeader);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.444 -0400", hash_original_method = "43BBEEB97A3047C63D843E4DFDBBA534", hash_generated_method = "9622E564207F4ECD5C179331AA0490C8")
    public void removeCachedAuthenticationHeaders(String callId) {
        addTaint(callId.getTaint());
        if(callId == null)        
        {
        NullPointerException varEE4C7E2F41CCA4133A072328FE355159_81731089 = new NullPointerException("Null callId argument ");
        varEE4C7E2F41CCA4133A072328FE355159_81731089.addTaint(taint);
        throw varEE4C7E2F41CCA4133A072328FE355159_81731089;
        }
        this.cachedCredentials.removeAuthenticationHeader(callId);
        // ---------- Original Method ----------
        //if (callId == null)
            //throw new NullPointerException("Null callId argument ");
        //this.cachedCredentials.removeAuthenticationHeader(callId);
    }

    
}

