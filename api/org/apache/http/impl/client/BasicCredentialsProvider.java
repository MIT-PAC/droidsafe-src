package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.HashMap;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.client.CredentialsProvider;






public class BasicCredentialsProvider implements CredentialsProvider {

    /**
     * Find matching {@link Credentials credentials} for the given authentication scope.
     *
     * @param map the credentials hash map
     * @param authscope the {@link AuthScope authentication scope}
     * @return the credentials 
     * 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:21.866 -0500", hash_original_method = "74E158E95C20526AD59FDAD0A2FEEA37", hash_generated_method = "953D805A7445BC0CF3DCF5DF0660A9F6")
    private static Credentials matchCredentials(
            final HashMap<AuthScope, Credentials> map, 
            final AuthScope authscope) {
        // see if we get a direct hit
        Credentials creds = map.get(authscope);
        if (creds == null) {
            // Nope.
            // Do a full scan
            int bestMatchFactor  = -1;
            AuthScope bestMatch  = null;
            for (AuthScope current: map.keySet()) {
                int factor = authscope.match(current);
                if (factor > bestMatchFactor) {
                    bestMatchFactor = factor;
                    bestMatch = current;
                }
            }
            if (bestMatch != null) {
                creds = map.get(bestMatch);
            }
        }
        return creds;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:21.863 -0500", hash_original_field = "1E8313F9EEBE642AC22DE9A578EF7E98", hash_generated_field = "4CB8755C3EC5F46FD31D578864B43B48")


    private  HashMap<AuthScope, Credentials> credMap;

    /**
     * Default constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:21.864 -0500", hash_original_method = "5972EEB8CE88F96A462831B5B8532572", hash_generated_method = "A8BCCD00D446B6E31B47D169AE8D8F0E")
    public BasicCredentialsProvider() {
        super();
        this.credMap = new HashMap<AuthScope, Credentials>();
    }

    /** 
     * Sets the {@link Credentials credentials} for the given authentication 
     * scope. Any previous credentials for the given scope will be overwritten.
     * 
     * @param authscope the {@link AuthScope authentication scope}
     * @param credentials the authentication {@link Credentials credentials} 
     * for the given scope.
     * 
     * @see #getCredentials(AuthScope)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:21.865 -0500", hash_original_method = "7BEE1753C2713BAF18AAEA2B93F376C4", hash_generated_method = "53FEF55F9300A2CB346836C703DB0EE3")
    public synchronized void setCredentials(
            final AuthScope authscope, 
            final Credentials credentials) {
        if (authscope == null) {
            throw new IllegalArgumentException("Authentication scope may not be null");
        }
        credMap.put(authscope, credentials);
    }
    
    /**
     * Get the {@link Credentials credentials} for the given authentication scope.
     *
     * @param authscope the {@link AuthScope authentication scope}
     * @return the credentials 
     * 
     * @see #setCredentials(AuthScope, Credentials)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:21.867 -0500", hash_original_method = "AB70A2CF4AFF279D0378510F4C86443E", hash_generated_method = "AD74E7647CF1BA650C56EB6F309907D4")
    public synchronized Credentials getCredentials(final AuthScope authscope) {
        if (authscope == null) {
            throw new IllegalArgumentException("Authentication scope may not be null");
        }
        return matchCredentials(this.credMap, authscope);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:21.868 -0500", hash_original_method = "E402ADC687ADEF99C9686D482448AD0B", hash_generated_method = "2ABECB1CB235C5846122A309DD8851A3")
    @Override
public String toString() {
        return credMap.toString();
    }
    
    /**
     * Clears all credentials.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:21.868 -0500", hash_original_method = "B811CBD1AC15B296829E7D50AE8C3355", hash_generated_method = "A810294C07066476F9BAC36021118ED2")
    public synchronized void clear() {
        this.credMap.clear();
    }

    
}

