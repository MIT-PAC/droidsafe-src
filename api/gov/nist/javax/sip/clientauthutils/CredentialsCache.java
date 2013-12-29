package gov.nist.javax.sip.clientauthutils;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

import javax.sip.header.AuthorizationHeader;




class CredentialsCache {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:07.439 -0500", hash_original_field = "643240A21F660338BE03E6E7FF605C37", hash_generated_field = "D736F54F12D200A8D25CC8A65E13F0DE")

    private ConcurrentHashMap<String, List<AuthorizationHeader>> authorizationHeaders =
            new ConcurrentHashMap<String, List<AuthorizationHeader>>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:07.439 -0500", hash_original_field = "738C3D18449F14F8BF2AE2302B0A1011", hash_generated_field = "02D2240A23798B540E9F3183DC11EA33")

    private Timer timer;



    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:07.444 -0500", hash_original_method = "27F7597F884C45C17FD9F63A315334B1", hash_generated_method = "27F7597F884C45C17FD9F63A315334B1")
    CredentialsCache (Timer timer) {
        this.timer = timer;
    }

    /**
     * Cache the bindings of proxyDomain and authorization header.
     *
     * @param callid
     *            the id of the call that the <tt>authorization</tt> header
     *            belongs to.
     * @param authorization
     *            the authorization header that we'd like to cache.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:07.445 -0500", hash_original_method = "557183176EBBC482C2193E58BCF0D460", hash_generated_method = "557183176EBBC482C2193E58BCF0D460")
    void cacheAuthorizationHeader(String callId,
            AuthorizationHeader authorization, int cacheTime) {
        String user = authorization.getUsername();
        if ( callId == null) throw new NullPointerException("Call ID is null!");
        if ( authorization == null) throw new NullPointerException("Null authorization domain");

        List<AuthorizationHeader> authHeaders = authorizationHeaders.get(callId);
        if (authHeaders == null) {
            authHeaders = new LinkedList<AuthorizationHeader>();
            authorizationHeaders.put(callId, authHeaders);
        } else {
            String realm = authorization.getRealm();
            for (ListIterator<AuthorizationHeader> li = authHeaders.listIterator(); li.hasNext();) {
                AuthorizationHeader authHeader = (AuthorizationHeader) li.next();
                if ( realm.equals(authHeader.getRealm()) ) {
                    li.remove();
                }
            }
        }

        authHeaders.add(authorization);

        TimeoutTask timeoutTask  = new TimeoutTask( callId,user);
        if ( cacheTime != -1)
            this.timer.schedule(timeoutTask, cacheTime*1000);


    }

    /**
     * Returns an authorization header cached for the specified call id and null
     * if no authorization header has been previously cached for this call.
     *
     * @param callid
     *            the call id that we'd like to retrive a cached authorization
     *            header for.
     *
     * @return authorization header corresponding to that user for the given
     *         proxy domain.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:07.446 -0500", hash_original_method = "0B5572B5CD4E87519D0DA5EDF97CD6AB", hash_generated_method = "0B5572B5CD4E87519D0DA5EDF97CD6AB")
    Collection<AuthorizationHeader> getCachedAuthorizationHeaders(
            String callid) {
        if (callid == null)
            throw new NullPointerException("Null arg!");
        return this.authorizationHeaders.get(callid);

    }

    /**
     * Remove a cached authorization header.
     *
     * @param callId
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:07.447 -0500", hash_original_method = "F30D19D7197AEDE7B7CBD76BE8FA4C90", hash_generated_method = "335049FAAF8BAC78F9C38099BA975A90")
    public void removeAuthenticationHeader(String callId) {
        this.authorizationHeaders.remove(callId);

    }

    
    class TimeoutTask extends TimerTask {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:07.440 -0500", hash_original_field = "2657C3812CAC2EE2FF30C5C628C0A470", hash_generated_field = "2657C3812CAC2EE2FF30C5C628C0A470")

        String callId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:07.441 -0500", hash_original_field = "603671BF518F3A411771AE6211095177", hash_generated_field = "603671BF518F3A411771AE6211095177")

        String userName;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:07.442 -0500", hash_original_method = "40061A1217D263C30B9E268AD3A22381", hash_generated_method = "B14801182577BC1053DC7DB1767BCF94")
        public TimeoutTask(String userName, String proxyDomain) {
            this.callId = proxyDomain;
            this.userName = userName;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:07.443 -0500", hash_original_method = "55798103F4DC731E25C4381B99CDD4EB", hash_generated_method = "EC9286E029470E763265287DA444C807")
        @Override
public void run() {
            authorizationHeaders.remove(callId);

        }

        
    }


    
}

