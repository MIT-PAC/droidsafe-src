package gov.nist.javax.sip.clientauthutils;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private CredentialsCache cachedCredentials;
    private Object accountManager = null;
    private HeaderFactory headerFactory;
    private SipStackImpl sipStack;
    Timer timer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.557 -0400", hash_original_method = "F290994E580301A1A06D86741D2EE4F7", hash_generated_method = "F2FC0D4C88F392C27C24ACF81358C30C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AuthenticationHelperImpl(SipStackImpl sipStack, AccountManager accountManager,
            HeaderFactory headerFactory) {
        dsTaint.addTaint(headerFactory.dsTaint);
        dsTaint.addTaint(sipStack.dsTaint);
        dsTaint.addTaint(accountManager.dsTaint);
        this.cachedCredentials = new CredentialsCache(((SIPTransactionStack) sipStack).getTimer());
        // ---------- Original Method ----------
        //this.accountManager = accountManager;
        //this.headerFactory = headerFactory;
        //this.sipStack = sipStack;
        //this.cachedCredentials = new CredentialsCache(((SIPTransactionStack) sipStack).getTimer());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.558 -0400", hash_original_method = "9D2E3CB72F7305E91EB5EE506EB32A3F", hash_generated_method = "4DA0B18BF0A06ABF21E3C64FB0B0A5E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AuthenticationHelperImpl(SipStackImpl sipStack, SecureAccountManager accountManager,
            HeaderFactory headerFactory) {
        dsTaint.addTaint(headerFactory.dsTaint);
        dsTaint.addTaint(sipStack.dsTaint);
        dsTaint.addTaint(accountManager.dsTaint);
        this.cachedCredentials = new CredentialsCache(((SIPTransactionStack) sipStack).getTimer());
        // ---------- Original Method ----------
        //this.accountManager = accountManager;
        //this.headerFactory = headerFactory;
        //this.sipStack = sipStack;
        //this.cachedCredentials = new CredentialsCache(((SIPTransactionStack) sipStack).getTimer());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.560 -0400", hash_original_method = "CD11AFCBEA5D85B140502117B9E2B2FE", hash_generated_method = "B41FDD42869CF3053612F19448D19595")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ClientTransaction handleChallenge(Response challenge,
            ClientTransaction challengedTransaction, SipProvider transactionCreator, int cacheTime) throws SipException, NullPointerException {
        dsTaint.addTaint(challengedTransaction.dsTaint);
        dsTaint.addTaint(challenge.dsTaint);
        dsTaint.addTaint(cacheTime);
        dsTaint.addTaint(transactionCreator.dsTaint);
        try 
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_453888469 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logDebug("handleChallenge: " + challenge);
                } //End block
            } //End collapsed parenthetic
            SIPRequest challengedRequest;
            challengedRequest = ((SIPRequest) challengedTransaction.getRequest());
            Request reoriginatedRequest;
            reoriginatedRequest = null;
            {
                boolean var84DC6B093324ECB6DC5CD376ABAB415E_1072357128 = (challengedRequest.getToTag() != null  ||
                    challengedTransaction.getDialog() == null ||
                    challengedTransaction.getDialog().getState() != DialogState.CONFIRMED);
                {
                    reoriginatedRequest = (Request) challengedRequest.clone();
                } //End block
                {
                    reoriginatedRequest =
                    challengedTransaction.getDialog().createRequest(challengedRequest.getMethod());
                    Iterator<String> headerNames;
                    headerNames = challengedRequest.getHeaderNames();
                    {
                        boolean var1B19958101823B6B38155B92C8E506B0_578268405 = (headerNames.hasNext());
                        {
                            String headerName;
                            headerName = headerNames.next();
                            {
                                boolean var270A70981A5F45664D8E072313B972FE_361484585 = (reoriginatedRequest.getHeader(headerName) != null);
                                {
                                    ListIterator<Header> iterator;
                                    iterator = reoriginatedRequest.getHeaders(headerName);
                                    {
                                        boolean varD953982CEBD49C2A8AA2B3ADB352204B_2071476736 = (iterator.hasNext());
                                        {
                                            reoriginatedRequest.addHeader(iterator.next());
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            removeBranchID(reoriginatedRequest);
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("A null argument was passed to handle challenge.");
            } //End block
            ListIterator authHeaders;
            authHeaders = null;
            {
                boolean var7E61F082459B37C0AFB08E4F53227E41_129130294 = (challenge.getStatusCode() == Response.UNAUTHORIZED);
                {
                    authHeaders = challenge.getHeaders(WWWAuthenticateHeader.NAME);
                } //End block
                {
                    boolean var3F6C5FE7365EA14B255312741E585648_78276101 = (challenge.getStatusCode() == Response.PROXY_AUTHENTICATION_REQUIRED);
                    {
                        authHeaders = challenge.getHeaders(ProxyAuthenticateHeader.NAME);
                    } //End block
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unexpected status code ");
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                        "Could not find WWWAuthenticate or ProxyAuthenticate headers");
            } //End block
            reoriginatedRequest.removeHeader(AuthorizationHeader.NAME);
            reoriginatedRequest.removeHeader(ProxyAuthorizationHeader.NAME);
            CSeqHeader cSeq;
            cSeq = (CSeqHeader) reoriginatedRequest.getHeader((CSeqHeader.NAME));
            try 
            {
                cSeq.setSeqNumber(cSeq.getSeqNumber() + 1l);
            } //End block
            catch (InvalidArgumentException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("Invalid CSeq -- could not increment : "
                        + cSeq.getSeqNumber());
            } //End block
            {
                boolean varC4EBC95B9BD32950D7D9394D60CFDFE9_1519028106 = (challengedRequest.getRouteHeaders() == null);
                {
                    Hop hop;
                    hop = ((SIPClientTransaction) challengedTransaction).getNextHop();
                    SipURI sipUri;
                    sipUri = (SipURI) reoriginatedRequest.getRequestURI();
                    {
                        boolean var841AE3DE7262EDC140B3815FEB3D6901_1892148058 = (!hop.getHost().equalsIgnoreCase(sipUri.getHost())
                        && !hop.equals(sipStack.getRouter(challengedRequest).getOutboundProxy()));
                        sipUri.setMAddrParam(hop.getHost());
                    } //End collapsed parenthetic
                    {
                        boolean var69B03C61B12EC7C13A31E0022669C925_1485072728 = (hop.getPort() != -1);
                        sipUri.setPort(hop.getPort());
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            ClientTransaction retryTran;
            retryTran = transactionCreator
            .getNewClientTransaction(reoriginatedRequest);
            WWWAuthenticateHeader authHeader;
            authHeader = null;
            SipURI requestUri;
            requestUri = (SipURI) challengedTransaction.getRequest().getRequestURI();
            {
                boolean var502FFDBFD46B1F7EAA9EF3A4B3E497F5_2028530660 = (authHeaders.hasNext());
                {
                    authHeader = (WWWAuthenticateHeader) authHeaders.next();
                    String realm;
                    realm = authHeader.getRealm();
                    AuthorizationHeader authorization;
                    authorization = null;
                    String sipDomain;
                    {
                        UserCredentialHash credHash;
                        credHash = ((SecureAccountManager)this.accountManager).getCredentialHash(challengedTransaction,realm);
                        URI uri;
                        uri = reoriginatedRequest.getRequestURI();
                        sipDomain = credHash.getSipDomain();
                        authorization = this.getAuthorization(reoriginatedRequest
                            .getMethod(), uri.toString(),
                            (reoriginatedRequest.getContent() == null) ? "" : new String(
                            reoriginatedRequest.getRawContent()), authHeader, credHash);
                    } //End block
                    {
                        UserCredentials userCreds;
                        userCreds = ((AccountManager) this.accountManager).getCredentials(challengedTransaction, realm);
                        sipDomain = userCreds.getSipDomain();
                        if (DroidSafeAndroidRuntime.control) throw new SipException(
                            "Cannot find user creds for the given user name and realm");
                        authorization = this.getAuthorization(reoriginatedRequest
                                .getMethod(), reoriginatedRequest.getRequestURI().toString(),
                                (reoriginatedRequest.getContent() == null) ? "" : new String(
                                reoriginatedRequest.getRawContent()), authHeader, userCreds);
                    } //End block
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_371945861 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug(
                        "Created authorization header: " + authorization.toString());
                    } //End collapsed parenthetic
                    cachedCredentials.cacheAuthorizationHeader(sipDomain,
                            authorization, cacheTime);
                    reoriginatedRequest.addHeader(authorization);
                } //End block
            } //End collapsed parenthetic
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_514904079 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logDebug(
                        "Returning authorization transaction." + retryTran);
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (SipException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw ex;
        } //End block
        catch (Exception ex)
        {
            sipStack.getStackLogger().logError("Unexpected exception ", ex);
            if (DroidSafeAndroidRuntime.control) throw new SipException("Unexpected exception ", ex);
        } //End block
        return (ClientTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.561 -0400", hash_original_method = "2D1C964540C22A20DCB24ADF01A4F207", hash_generated_method = "27182875D694A6397771FAA8FC0B327F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private AuthorizationHeader getAuthorization(String method, String uri, String requestBody,
            WWWAuthenticateHeader authHeader, UserCredentials userCredentials) {
        dsTaint.addTaint(userCredentials.dsTaint);
        dsTaint.addTaint(requestBody);
        dsTaint.addTaint(authHeader.dsTaint);
        dsTaint.addTaint(method);
        dsTaint.addTaint(uri);
        String response;
        response = null;
        String qopList;
        qopList = authHeader.getQop();
        String qop;
        qop = "auth";
        qop = null;
        String nc_value;
        nc_value = "00000001";
        String cnonce;
        cnonce = "xyz";
        response = MessageDigestAlgorithm.calculateResponse(authHeader.getAlgorithm(),
                userCredentials.getUserName(), authHeader.getRealm(), userCredentials
                        .getPassword(), authHeader.getNonce(), nc_value, 
                cnonce, 
                method, uri, requestBody, qop,sipStack.getStackLogger());
        AuthorizationHeader authorization;
        authorization = null;
        try 
        {
            {
                authorization = headerFactory.createProxyAuthorizationHeader(authHeader
                        .getScheme());
            } //End block
            {
                authorization = headerFactory.createAuthorizationHeader(authHeader.getScheme());
            } //End block
            authorization.setUsername(userCredentials.getUserName());
            authorization.setRealm(authHeader.getRealm());
            authorization.setNonce(authHeader.getNonce());
            authorization.setParameter("uri", uri);
            authorization.setResponse(response);
            {
                boolean varA19E9C0577AD2CC5719031389F3AF03F_1627221943 = (authHeader.getAlgorithm() != null);
                {
                    authorization.setAlgorithm(authHeader.getAlgorithm());
                } //End block
            } //End collapsed parenthetic
            {
                boolean varAF1F3E9686F7AA3F141EE79D05D3AE0F_2078537070 = (authHeader.getOpaque() != null);
                {
                    authorization.setOpaque(authHeader.getOpaque());
                } //End block
            } //End collapsed parenthetic
            {
                authorization.setQop(qop);
                authorization.setCNonce(cnonce);
                authorization.setNonceCount(Integer.parseInt(nc_value));
            } //End block
            authorization.setResponse(response);
        } //End block
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Failed to create an authorization header!");
        } //End block
        return (AuthorizationHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.561 -0400", hash_original_method = "122A01004B39FE573FF7374B710A1EFB", hash_generated_method = "7903D3329C64CD50463AF105F5BB2ED1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private AuthorizationHeader getAuthorization(String method, String uri, String requestBody,
            WWWAuthenticateHeader authHeader, UserCredentialHash userCredentials) {
        dsTaint.addTaint(userCredentials.dsTaint);
        dsTaint.addTaint(requestBody);
        dsTaint.addTaint(authHeader.dsTaint);
        dsTaint.addTaint(method);
        dsTaint.addTaint(uri);
        String response;
        response = null;
        String qopList;
        qopList = authHeader.getQop();
        String qop;
        qop = "auth";
        qop = null;
        String nc_value;
        nc_value = "00000001";
        String cnonce;
        cnonce = "xyz";
        response = MessageDigestAlgorithm.calculateResponse(authHeader.getAlgorithm(),
              userCredentials.getHashUserDomainPassword(), authHeader.getNonce(), nc_value, 
                cnonce, 
                method, uri, requestBody, qop,sipStack.getStackLogger());
        AuthorizationHeader authorization;
        authorization = null;
        try 
        {
            {
                authorization = headerFactory.createProxyAuthorizationHeader(authHeader
                        .getScheme());
            } //End block
            {
                authorization = headerFactory.createAuthorizationHeader(authHeader.getScheme());
            } //End block
            authorization.setUsername(userCredentials.getUserName());
            authorization.setRealm(authHeader.getRealm());
            authorization.setNonce(authHeader.getNonce());
            authorization.setParameter("uri", uri);
            authorization.setResponse(response);
            {
                boolean varA19E9C0577AD2CC5719031389F3AF03F_1593331918 = (authHeader.getAlgorithm() != null);
                {
                    authorization.setAlgorithm(authHeader.getAlgorithm());
                } //End block
            } //End collapsed parenthetic
            {
                boolean varAF1F3E9686F7AA3F141EE79D05D3AE0F_561699465 = (authHeader.getOpaque() != null);
                {
                    authorization.setOpaque(authHeader.getOpaque());
                } //End block
            } //End collapsed parenthetic
            {
                authorization.setQop(qop);
                authorization.setCNonce(cnonce);
                authorization.setNonceCount(Integer.parseInt(nc_value));
            } //End block
            authorization.setResponse(response);
        } //End block
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Failed to create an authorization header!");
        } //End block
        return (AuthorizationHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.562 -0400", hash_original_method = "ADD4EE56A02B7B5492F16169DF575C77", hash_generated_method = "DDF426E7501AB093FA2DE5F949662C01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void removeBranchID(Request request) {
        dsTaint.addTaint(request.dsTaint);
        ViaHeader viaHeader;
        viaHeader = (ViaHeader) request.getHeader(ViaHeader.NAME);
        viaHeader.removeParameter("branch");
        // ---------- Original Method ----------
        //ViaHeader viaHeader = (ViaHeader) request.getHeader(ViaHeader.NAME);
        //viaHeader.removeParameter("branch");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.565 -0400", hash_original_method = "B9EE184222D97BBFBAC451553E77E803", hash_generated_method = "1D980EFAA456CCE57EE45048DC019E19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAuthenticationHeaders(Request request) {
        dsTaint.addTaint(request.dsTaint);
        SIPRequest sipRequest;
        sipRequest = (SIPRequest) request;
        String callId;
        callId = sipRequest.getCallId().getCallId();
        request.removeHeader(AuthorizationHeader.NAME);
        Collection<AuthorizationHeader> authHeaders;
        authHeaders = this.cachedCredentials
                .getCachedAuthorizationHeaders(callId);
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1674724409 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug(
                    "Could not find authentication headers for " + callId);
            } //End collapsed parenthetic
        } //End block
        {
            Iterator<AuthorizationHeader> var55A62473FF3B1BF5FAC49D8739006C34_2031425359 = (authHeaders).iterator();
            var55A62473FF3B1BF5FAC49D8739006C34_2031425359.hasNext();
            AuthorizationHeader authHeader = var55A62473FF3B1BF5FAC49D8739006C34_2031425359.next();
            {
                request.addHeader(authHeader);
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.566 -0400", hash_original_method = "43BBEEB97A3047C63D843E4DFDBBA534", hash_generated_method = "89F874DBD9AF7E4DF9D69092FAF06151")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeCachedAuthenticationHeaders(String callId) {
        dsTaint.addTaint(callId);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null callId argument ");
        this.cachedCredentials.removeAuthenticationHeader(callId);
        // ---------- Original Method ----------
        //if (callId == null)
            //throw new NullPointerException("Null callId argument ");
        //this.cachedCredentials.removeAuthenticationHeader(callId);
    }

    
}

