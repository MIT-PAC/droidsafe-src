package org.apache.http.impl.client;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.HashMap;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.client.CredentialsProvider;

public class BasicCredentialsProvider implements CredentialsProvider {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.320 -0400", hash_original_field = "74CEE513FFFAA74DACEC65FAB85A3105", hash_generated_field = "4CB8755C3EC5F46FD31D578864B43B48")

    private HashMap<AuthScope, Credentials> credMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.320 -0400", hash_original_method = "5972EEB8CE88F96A462831B5B8532572", hash_generated_method = "BABD4A71FDA2BEC7C45B048FBE26AE3C")
    public  BasicCredentialsProvider() {
        super();
        this.credMap = new HashMap<AuthScope, Credentials>();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.321 -0400", hash_original_method = "7BEE1753C2713BAF18AAEA2B93F376C4", hash_generated_method = "60493FE73BADEE018AB9D7804172B40F")
    public synchronized void setCredentials(
            final AuthScope authscope, 
            final Credentials credentials) {
        addTaint(credentials.getTaint());
        addTaint(authscope.getTaint());
    if(authscope == null)        
        {
            IllegalArgumentException varF3C54A3920ACABC473232E4B61A3EC9F_1363804195 = new IllegalArgumentException("Authentication scope may not be null");
            varF3C54A3920ACABC473232E4B61A3EC9F_1363804195.addTaint(taint);
            throw varF3C54A3920ACABC473232E4B61A3EC9F_1363804195;
        } 
        credMap.put(authscope, credentials);
        
        
            
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.322 -0400", hash_original_method = "AB70A2CF4AFF279D0378510F4C86443E", hash_generated_method = "51D4F537DE8D738FB253A8510683C590")
    public synchronized Credentials getCredentials(final AuthScope authscope) {
        addTaint(authscope.getTaint());
    if(authscope == null)        
        {
            IllegalArgumentException varF3C54A3920ACABC473232E4B61A3EC9F_1692343487 = new IllegalArgumentException("Authentication scope may not be null");
            varF3C54A3920ACABC473232E4B61A3EC9F_1692343487.addTaint(taint);
            throw varF3C54A3920ACABC473232E4B61A3EC9F_1692343487;
        } 
Credentials var9FEAE3DE7DACA4ACD3468E0C1D91FB57_447892253 =         matchCredentials(this.credMap, authscope);
        var9FEAE3DE7DACA4ACD3468E0C1D91FB57_447892253.addTaint(taint);
        return var9FEAE3DE7DACA4ACD3468E0C1D91FB57_447892253;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.322 -0400", hash_original_method = "E402ADC687ADEF99C9686D482448AD0B", hash_generated_method = "CB2935EC5CBF136C72A7D117F5A7E1DB")
    @Override
    public String toString() {
String var3ABE431499056EAEA366DD605462395E_2032166986 =         credMap.toString();
        var3ABE431499056EAEA366DD605462395E_2032166986.addTaint(taint);
        return var3ABE431499056EAEA366DD605462395E_2032166986;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.322 -0400", hash_original_method = "B811CBD1AC15B296829E7D50AE8C3355", hash_generated_method = "F819287B754D53E25A1D3BFC60FCEF93")
    public synchronized void clear() {
        this.credMap.clear();
        
        
    }

    
}

