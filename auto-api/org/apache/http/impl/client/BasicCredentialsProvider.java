package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.HashMap;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.client.CredentialsProvider;

public class BasicCredentialsProvider implements CredentialsProvider {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.233 -0400", hash_original_field = "74CEE513FFFAA74DACEC65FAB85A3105", hash_generated_field = "4CB8755C3EC5F46FD31D578864B43B48")

    private HashMap<AuthScope, Credentials> credMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.234 -0400", hash_original_method = "5972EEB8CE88F96A462831B5B8532572", hash_generated_method = "BABD4A71FDA2BEC7C45B048FBE26AE3C")
    public  BasicCredentialsProvider() {
        super();
        this.credMap = new HashMap<AuthScope, Credentials>();
        // ---------- Original Method ----------
        //this.credMap = new HashMap<AuthScope, Credentials>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.234 -0400", hash_original_method = "7BEE1753C2713BAF18AAEA2B93F376C4", hash_generated_method = "6279FC114B659733CFA85BCB29C63EC8")
    public synchronized void setCredentials(
            final AuthScope authscope, 
            final Credentials credentials) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Authentication scope may not be null");
        } //End block
        credMap.put(authscope, credentials);
        addTaint(authscope.getTaint());
        addTaint(credentials.getTaint());
        // ---------- Original Method ----------
        //if (authscope == null) {
            //throw new IllegalArgumentException("Authentication scope may not be null");
        //}
        //credMap.put(authscope, credentials);
    }

    
        private static Credentials matchCredentials(
            final HashMap<AuthScope, Credentials> map, 
            final AuthScope authscope) {
        Credentials creds = map.get(authscope);
        if (creds == null) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.242 -0400", hash_original_method = "AB70A2CF4AFF279D0378510F4C86443E", hash_generated_method = "CFD577BD8B22511BE125E6E5C88FB7B6")
    public synchronized Credentials getCredentials(final AuthScope authscope) {
        Credentials varB4EAC82CA7396A68D541C85D26508E83_1168348821 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Authentication scope may not be null");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1168348821 = matchCredentials(this.credMap, authscope);
        addTaint(authscope.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1168348821.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1168348821;
        // ---------- Original Method ----------
        //if (authscope == null) {
            //throw new IllegalArgumentException("Authentication scope may not be null");
        //}
        //return matchCredentials(this.credMap, authscope);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.242 -0400", hash_original_method = "E402ADC687ADEF99C9686D482448AD0B", hash_generated_method = "C1D3D1DC3CF85E37B0D218419F73D8C5")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_493655280 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_493655280 = credMap.toString();
        varB4EAC82CA7396A68D541C85D26508E83_493655280.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_493655280;
        // ---------- Original Method ----------
        //return credMap.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.265 -0400", hash_original_method = "B811CBD1AC15B296829E7D50AE8C3355", hash_generated_method = "F819287B754D53E25A1D3BFC60FCEF93")
    public synchronized void clear() {
        this.credMap.clear();
        // ---------- Original Method ----------
        //this.credMap.clear();
    }

    
}

