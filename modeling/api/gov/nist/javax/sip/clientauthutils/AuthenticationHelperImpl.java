/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package gov.nist.javax.sip.clientauthutils;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.SipStackImpl;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:40.489 -0500", hash_original_field = "97A26D8BD8CC9D6A8A6173064B299B5B", hash_generated_field = "1A1B69CD5FD1781DFE3A277E582E290E")

    private CredentialsCache cachedCredentials;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:40.493 -0500", hash_original_field = "C27B4CFF7ED57BCE405C9A2519668187", hash_generated_field = "BFC31B1DC824029BF180F9CDA8004E27")

    private Object accountManager = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:40.495 -0500", hash_original_field = "10A2CC1A3815FEE16ABD51761A52F26D", hash_generated_field = "1DEC16ADC00415FCFA26FDBCB5573275")

    private HeaderFactory headerFactory;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:40.498 -0500", hash_original_field = "03821C4D777C0A4AB8577E0C5F2371D6", hash_generated_field = "B028268F85C87F49A0E45B93954BF938")

    private SipStackImpl sipStack;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:40.500 -0500", hash_original_field = "738C3D18449F14F8BF2AE2302B0A1011", hash_generated_field = "738C3D18449F14F8BF2AE2302B0A1011")

    Timer timer;

    /**
     * Default constructor for the security manager. There is one Account manager. There is one
     * SipSecurity manager for every user name,
     *
     * @param sipStack -- our stack.
     * @param accountManager -- an implementation of the AccountManager interface.
     * @param headerFactory -- header factory.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:40.503 -0500", hash_original_method = "F290994E580301A1A06D86741D2EE4F7", hash_generated_method = "33B7CE5A0CBE6C6AB083EADD5FC8BFB9")
    
public AuthenticationHelperImpl(SipStackImpl sipStack, AccountManager accountManager,
            HeaderFactory headerFactory) {
        this.accountManager = accountManager;
        this.headerFactory = headerFactory;
        this.sipStack = sipStack;

        this.cachedCredentials = new CredentialsCache(((SIPTransactionStack) sipStack).getTimer());
    }
    
    /**
     * Default constructor for the security manager. There is one Account manager. There is one
     * SipSecurity manager for every user name,
     *
     * @param sipStack -- our stack.
     * @param accountManager -- an implementation of the AccountManager interface.
     * @param headerFactory -- header factory.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:40.506 -0500", hash_original_method = "9D2E3CB72F7305E91EB5EE506EB32A3F", hash_generated_method = "FA1055DE4A5DF1618E1899C9039840B3")
    
public AuthenticationHelperImpl(SipStackImpl sipStack, SecureAccountManager accountManager,
            HeaderFactory headerFactory) {
        this.accountManager = accountManager;
        this.headerFactory = headerFactory;
        this.sipStack = sipStack;

        this.cachedCredentials = new CredentialsCache(((SIPTransactionStack) sipStack).getTimer());
    }

    /*
     * (non-Javadoc)
     *
     * @see gov.nist.javax.sip.clientauthutils.AuthenticationHelper#handleChallenge(javax.sip.message.Response,
     *      javax.sip.ClientTransaction, javax.sip.SipProvider)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:40.512 -0500", hash_original_method = "CD11AFCBEA5D85B140502117B9E2B2FE", hash_generated_method = "8FCC82F4671DFF458822C68BE5416359")
    
public ClientTransaction handleChallenge(Response challenge,
            ClientTransaction challengedTransaction, SipProvider transactionCreator, int cacheTime)
            throws SipException, NullPointerException {
        try {
            if (sipStack.isLoggingEnabled()) {
                sipStack.getStackLogger().logDebug("handleChallenge: " + challenge);
            }

            SIPRequest challengedRequest = ((SIPRequest) challengedTransaction.getRequest());

            Request reoriginatedRequest = null;
            /*
             * If the challenged request is part of a Dialog and the
             * Dialog is confirmed the re-originated request should be
             * generated as an in-Dialog request.
             */
            if (  challengedRequest.getToTag() != null  ||
                    challengedTransaction.getDialog() == null ||
                    challengedTransaction.getDialog().getState() != DialogState.CONFIRMED)  {
                reoriginatedRequest = (Request) challengedRequest.clone();
            } else {
                /*
                 * Re-originate the request by consulting the dialog. In particular
                 * the route set could change between the original request and the 
                 * in-dialog challenge.
                 */
                reoriginatedRequest =
                    challengedTransaction.getDialog().createRequest(challengedRequest.getMethod());
                Iterator<String> headerNames = challengedRequest.getHeaderNames();
                while (headerNames.hasNext()) {
                    String headerName = headerNames.next();
                    if ( reoriginatedRequest.getHeader(headerName) != null) {
                        ListIterator<Header> iterator = reoriginatedRequest.getHeaders(headerName);
                        while (iterator.hasNext()) {
                            reoriginatedRequest.addHeader(iterator.next());
                        }
                    }
                }
            }

            // remove the branch id so that we could use the request in a new
            // transaction
            removeBranchID(reoriginatedRequest);

            if (challenge == null || reoriginatedRequest == null) {
                throw new NullPointerException("A null argument was passed to handle challenge.");
            }

            ListIterator authHeaders = null;

            if (challenge.getStatusCode() == Response.UNAUTHORIZED) {
                authHeaders = challenge.getHeaders(WWWAuthenticateHeader.NAME);
            } else if (challenge.getStatusCode() == Response.PROXY_AUTHENTICATION_REQUIRED) {
                authHeaders = challenge.getHeaders(ProxyAuthenticateHeader.NAME);
            } else {
                throw new IllegalArgumentException("Unexpected status code ");
            }

            if (authHeaders == null) {
                throw new IllegalArgumentException(
                        "Could not find WWWAuthenticate or ProxyAuthenticate headers");
            }

            // Remove all authorization headers from the request (we'll re-add them
            // from cache)
            reoriginatedRequest.removeHeader(AuthorizationHeader.NAME);
            reoriginatedRequest.removeHeader(ProxyAuthorizationHeader.NAME);

            // rfc 3261 says that the cseq header should be augmented for the new
            // request. do it here so that the new dialog (created together with
            // the new client transaction) takes it into account.
            // Bug report - Fredrik Wickstrom
            CSeqHeader cSeq = (CSeqHeader) reoriginatedRequest.getHeader((CSeqHeader.NAME));
            try {
                cSeq.setSeqNumber(cSeq.getSeqNumber() + 1l);
            } catch (InvalidArgumentException ex) {
                throw new SipException("Invalid CSeq -- could not increment : "
                        + cSeq.getSeqNumber());
            }

            /* Resolve this to the next hop based on the previous lookup. If we are not using
             * lose routing (RFC2543) then just attach hop as a maddr param.
             */
            if ( challengedRequest.getRouteHeaders() == null ) {
                Hop hop   = ((SIPClientTransaction) challengedTransaction).getNextHop();
                SipURI sipUri = (SipURI) reoriginatedRequest.getRequestURI();
                // BEGIN android-added
                if ( !hop.getHost().equalsIgnoreCase(sipUri.getHost())
                        && !hop.equals(sipStack.getRouter(challengedRequest).getOutboundProxy()) )
                // END android-added
                sipUri.setMAddrParam(hop.getHost());
                if ( hop.getPort() != -1 ) sipUri.setPort(hop.getPort());
            }
            ClientTransaction retryTran = transactionCreator
            .getNewClientTransaction(reoriginatedRequest);

            WWWAuthenticateHeader authHeader = null;
            SipURI requestUri = (SipURI) challengedTransaction.getRequest().getRequestURI();
            while (authHeaders.hasNext()) {
                authHeader = (WWWAuthenticateHeader) authHeaders.next();
                String realm = authHeader.getRealm();
                AuthorizationHeader authorization = null;
                String sipDomain;
                if ( this.accountManager instanceof SecureAccountManager ) {
                    UserCredentialHash credHash =
                        ((SecureAccountManager)this.accountManager).getCredentialHash(challengedTransaction,realm);
                    URI uri = reoriginatedRequest.getRequestURI();
                    sipDomain = credHash.getSipDomain();
                    authorization = this.getAuthorization(reoriginatedRequest
                            .getMethod(), uri.toString(),
                            (reoriginatedRequest.getContent() == null) ? "" : new String(
                            reoriginatedRequest.getRawContent()), authHeader, credHash);
                } else {
                    UserCredentials userCreds = ((AccountManager) this.accountManager).getCredentials(challengedTransaction, realm);
                    sipDomain = userCreds.getSipDomain();
                    if (userCreds == null)
                         throw new SipException(
                            "Cannot find user creds for the given user name and realm");

                    // we haven't yet authenticated this realm since we were
                    // started.

                       authorization = this.getAuthorization(reoriginatedRequest
                                .getMethod(), reoriginatedRequest.getRequestURI().toString(),
                                (reoriginatedRequest.getContent() == null) ? "" : new String(
                                reoriginatedRequest.getRawContent()), authHeader, userCreds);
                }
                if (sipStack.isLoggingEnabled())
                	sipStack.getStackLogger().logDebug(
                        "Created authorization header: " + authorization.toString());

                if (cacheTime != 0)
                    cachedCredentials.cacheAuthorizationHeader(sipDomain,
                            authorization, cacheTime);

                reoriginatedRequest.addHeader(authorization);
            }

            if (sipStack.isLoggingEnabled()) {
                sipStack.getStackLogger().logDebug(
                        "Returning authorization transaction." + retryTran);
            }
            return retryTran;
        } catch (SipException ex) {
            throw ex;
        } catch (Exception ex) {
            sipStack.getStackLogger().logError("Unexpected exception ", ex);
            throw new SipException("Unexpected exception ", ex);
        }
    }

    /**
     * Generates an authorisation header in response to wwwAuthHeader.
     *
     * @param method method of the request being authenticated
     * @param uri digest-uri
     * @param requestBody the body of the request.
     * @param authHeader the challenge that we should respond to
     * @param userCredentials username and pass
     *
     * @return an authorisation header in response to authHeader.
     *
     * @throws OperationFailedException if auth header was malformated.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:40.516 -0500", hash_original_method = "2D1C964540C22A20DCB24ADF01A4F207", hash_generated_method = "3C62CCFD7B649592248DE3F9EE489D88")
    
private AuthorizationHeader getAuthorization(String method, String uri, String requestBody,
            WWWAuthenticateHeader authHeader, UserCredentials userCredentials) {
        String response = null;

        // JvB: authHeader.getQop() is a quoted _list_ of qop values
        // (e.g. "auth,auth-int") Client is supposed to pick one
        String qopList = authHeader.getQop();
        String qop = (qopList != null) ? "auth" : null;
        String nc_value = "00000001";
        String cnonce = "xyz";

        response = MessageDigestAlgorithm.calculateResponse(authHeader.getAlgorithm(),
                userCredentials.getUserName(), authHeader.getRealm(), userCredentials
                        .getPassword(), authHeader.getNonce(), nc_value, // JvB added
                cnonce, // JvB added
                method, uri, requestBody, qop,sipStack.getStackLogger());// jvb changed

        AuthorizationHeader authorization = null;
        try {
            if (authHeader instanceof ProxyAuthenticateHeader) {
                authorization = headerFactory.createProxyAuthorizationHeader(authHeader
                        .getScheme());
            } else {
                authorization = headerFactory.createAuthorizationHeader(authHeader.getScheme());
            }

            authorization.setUsername(userCredentials.getUserName());
            authorization.setRealm(authHeader.getRealm());
            authorization.setNonce(authHeader.getNonce());
            authorization.setParameter("uri", uri);
            authorization.setResponse(response);
            if (authHeader.getAlgorithm() != null) {
                authorization.setAlgorithm(authHeader.getAlgorithm());
            }

            if (authHeader.getOpaque() != null) {
                authorization.setOpaque(authHeader.getOpaque());
            }

            // jvb added
            if (qop != null) {
                authorization.setQop(qop);
                authorization.setCNonce(cnonce);
                authorization.setNonceCount(Integer.parseInt(nc_value));
            }

            authorization.setResponse(response);

        } catch (ParseException ex) {
            throw new RuntimeException("Failed to create an authorization header!");
        }

        return authorization;
    }
    /**
     * Generates an authorisation header in response to wwwAuthHeader.
     *
     * @param method method of the request being authenticated
     * @param uri digest-uri
     * @param requestBody the body of the request.
     * @param authHeader the challenge that we should respond to
     * @param userCredentials username and pass
     *
     * @return an authorisation header in response to authHeader.
     *
     * @throws OperationFailedException if auth header was malformated.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:40.519 -0500", hash_original_method = "122A01004B39FE573FF7374B710A1EFB", hash_generated_method = "18E181D32449677DD9947AC370571D70")
    
private AuthorizationHeader getAuthorization(String method, String uri, String requestBody,
            WWWAuthenticateHeader authHeader, UserCredentialHash userCredentials) {
        String response = null;

        // JvB: authHeader.getQop() is a quoted _list_ of qop values
        // (e.g. "auth,auth-int") Client is supposed to pick one
        String qopList = authHeader.getQop();
        String qop = (qopList != null) ? "auth" : null;
        String nc_value = "00000001";
        String cnonce = "xyz";

        response = MessageDigestAlgorithm.calculateResponse(authHeader.getAlgorithm(),
              userCredentials.getHashUserDomainPassword(), authHeader.getNonce(), nc_value, // JvB added
                cnonce, // JvB added
                method, uri, requestBody, qop,sipStack.getStackLogger());// jvb changed

        AuthorizationHeader authorization = null;
        try {
            if (authHeader instanceof ProxyAuthenticateHeader) {
                authorization = headerFactory.createProxyAuthorizationHeader(authHeader
                        .getScheme());
            } else {
                authorization = headerFactory.createAuthorizationHeader(authHeader.getScheme());
            }

            authorization.setUsername(userCredentials.getUserName());
            authorization.setRealm(authHeader.getRealm());
            authorization.setNonce(authHeader.getNonce());
            authorization.setParameter("uri", uri);
            authorization.setResponse(response);
            if (authHeader.getAlgorithm() != null) {
                authorization.setAlgorithm(authHeader.getAlgorithm());
            }

            if (authHeader.getOpaque() != null) {
                authorization.setOpaque(authHeader.getOpaque());
            }

            // jvb added
            if (qop != null) {
                authorization.setQop(qop);
                authorization.setCNonce(cnonce);
                authorization.setNonceCount(Integer.parseInt(nc_value));
            }

            authorization.setResponse(response);

        } catch (ParseException ex) {
            throw new RuntimeException("Failed to create an authorization header!");
        }

        return authorization;
    }
    /**
     * Removes all via headers from <tt>request</tt> and replaces them with a new one, equal to
     * the one that was top most.
     *
     * @param request the Request whose branchID we'd like to remove.
     *
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:40.522 -0500", hash_original_method = "ADD4EE56A02B7B5492F16169DF575C77", hash_generated_method = "C79BF4B67E3189EEF19E9080990D2DC9")
    
private void removeBranchID(Request request) {

        ViaHeader viaHeader = (ViaHeader) request.getHeader(ViaHeader.NAME);

        viaHeader.removeParameter("branch");

    }

    /*
     * (non-Javadoc)
     *
     * @see gov.nist.javax.sip.clientauthutils.AuthenticationHelper#attachAuthenticationHeaders(javax.sip.message.Request)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:40.524 -0500", hash_original_method = "B9EE184222D97BBFBAC451553E77E803", hash_generated_method = "A798D3698DF72238D1C6CD71B2A220E9")
    
public void setAuthenticationHeaders(Request request) {
        SIPRequest sipRequest = (SIPRequest) request;

        String callId = sipRequest.getCallId().getCallId();

        request.removeHeader(AuthorizationHeader.NAME);
        Collection<AuthorizationHeader> authHeaders = this.cachedCredentials
                .getCachedAuthorizationHeaders(callId);
        if (authHeaders == null) {
        	if (sipStack.isLoggingEnabled())
        		sipStack.getStackLogger().logDebug(
                    "Could not find authentication headers for " + callId);
            return;
        }

        for (AuthorizationHeader authHeader : authHeaders) {
            request.addHeader(authHeader);
        }

    }

    /*
     * (non-Javadoc)
     *
     * @see gov.nist.javax.sip.clientauthutils.AuthenticationHelper#removeCachedAuthenticationHeaders(java.lang.String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:40.527 -0500", hash_original_method = "43BBEEB97A3047C63D843E4DFDBBA534", hash_generated_method = "BF571E1D8212250C7306D7DD8B674A4E")
    
public void removeCachedAuthenticationHeaders(String callId) {
        if (callId == null)
            throw new NullPointerException("Null callId argument ");
        this.cachedCredentials.removeAuthenticationHeader(callId);

    }
    
}

