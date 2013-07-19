package org.apache.http.impl.client;

// Droidsafe Imports
import java.util.HashMap;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.client.CredentialsProvider;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class BasicCredentialsProvider implements CredentialsProvider {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.636 -0400", hash_original_field = "74CEE513FFFAA74DACEC65FAB85A3105", hash_generated_field = "4CB8755C3EC5F46FD31D578864B43B48")

    private HashMap<AuthScope, Credentials> credMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.636 -0400", hash_original_method = "5972EEB8CE88F96A462831B5B8532572", hash_generated_method = "BABD4A71FDA2BEC7C45B048FBE26AE3C")
    public  BasicCredentialsProvider() {
        super();
        this.credMap = new HashMap<AuthScope, Credentials>();
        // ---------- Original Method ----------
        //this.credMap = new HashMap<AuthScope, Credentials>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.637 -0400", hash_original_method = "7BEE1753C2713BAF18AAEA2B93F376C4", hash_generated_method = "C02985C51952FEBF384894B5A041D875")
    public synchronized void setCredentials(
            final AuthScope authscope, 
            final Credentials credentials) {
        addTaint(credentials.getTaint());
        addTaint(authscope.getTaint());
        if(authscope == null)        
        {
            IllegalArgumentException varF3C54A3920ACABC473232E4B61A3EC9F_1155552501 = new IllegalArgumentException("Authentication scope may not be null");
            varF3C54A3920ACABC473232E4B61A3EC9F_1155552501.addTaint(taint);
            throw varF3C54A3920ACABC473232E4B61A3EC9F_1155552501;
        } //End block
        credMap.put(authscope, credentials);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.637 -0400", hash_original_method = "AB70A2CF4AFF279D0378510F4C86443E", hash_generated_method = "7747ABD7D4C5D25041A98CC2E7B1D2E6")
    public synchronized Credentials getCredentials(final AuthScope authscope) {
        addTaint(authscope.getTaint());
        if(authscope == null)        
        {
            IllegalArgumentException varF3C54A3920ACABC473232E4B61A3EC9F_122454253 = new IllegalArgumentException("Authentication scope may not be null");
            varF3C54A3920ACABC473232E4B61A3EC9F_122454253.addTaint(taint);
            throw varF3C54A3920ACABC473232E4B61A3EC9F_122454253;
        } //End block
Credentials var9FEAE3DE7DACA4ACD3468E0C1D91FB57_2132784250 =         matchCredentials(this.credMap, authscope);
        var9FEAE3DE7DACA4ACD3468E0C1D91FB57_2132784250.addTaint(taint);
        return var9FEAE3DE7DACA4ACD3468E0C1D91FB57_2132784250;
        // ---------- Original Method ----------
        //if (authscope == null) {
            //throw new IllegalArgumentException("Authentication scope may not be null");
        //}
        //return matchCredentials(this.credMap, authscope);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.637 -0400", hash_original_method = "E402ADC687ADEF99C9686D482448AD0B", hash_generated_method = "CC0812857403AC3B2801BE6E312F1A1F")
    @Override
    public String toString() {
String var3ABE431499056EAEA366DD605462395E_1666665672 =         credMap.toString();
        var3ABE431499056EAEA366DD605462395E_1666665672.addTaint(taint);
        return var3ABE431499056EAEA366DD605462395E_1666665672;
        // ---------- Original Method ----------
        //return credMap.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.637 -0400", hash_original_method = "B811CBD1AC15B296829E7D50AE8C3355", hash_generated_method = "F819287B754D53E25A1D3BFC60FCEF93")
    public synchronized void clear() {
        this.credMap.clear();
        // ---------- Original Method ----------
        //this.credMap.clear();
    }

    
}

