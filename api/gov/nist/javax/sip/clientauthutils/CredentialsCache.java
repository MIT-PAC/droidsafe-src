package gov.nist.javax.sip.clientauthutils;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import javax.sip.*;
import javax.sip.header.*;
import javax.sip.address.*;
import javax.sip.message.*;

class CredentialsCache {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.527 -0400", hash_original_field = "D81018253725EE02665AA28ECF9FB59A", hash_generated_field = "D736F54F12D200A8D25CC8A65E13F0DE")

    private ConcurrentHashMap<String, List<AuthorizationHeader>> authorizationHeaders = new ConcurrentHashMap<String, List<AuthorizationHeader>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.528 -0400", hash_original_field = "2C127BF32CCB4EDF2BF22FEA5A00E494", hash_generated_field = "02D2240A23798B540E9F3183DC11EA33")

    private Timer timer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.528 -0400", hash_original_method = "27F7597F884C45C17FD9F63A315334B1", hash_generated_method = "A4870380C2579D8A506F75F9CC2B9DB5")
      CredentialsCache(Timer timer) {
        this.timer = timer;
        // ---------- Original Method ----------
        //this.timer = timer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.529 -0400", hash_original_method = "557183176EBBC482C2193E58BCF0D460", hash_generated_method = "C3AE2C4FA62399767D9B85770005EFD1")
     void cacheAuthorizationHeader(String callId,
            AuthorizationHeader authorization, int cacheTime) {
        addTaint(cacheTime);
        addTaint(authorization.getTaint());
        addTaint(callId.getTaint());
        String user = authorization.getUsername();
    if(callId == null)        
        {
        NullPointerException var228B439B12474C35C0ABC31A2823EC93_271950619 = new NullPointerException("Call ID is null!");
        var228B439B12474C35C0ABC31A2823EC93_271950619.addTaint(taint);
        throw var228B439B12474C35C0ABC31A2823EC93_271950619;
        }
    if(authorization == null)        
        {
        NullPointerException var4846CD46E1509569A2299D351EDC2C83_79969503 = new NullPointerException("Null authorization domain");
        var4846CD46E1509569A2299D351EDC2C83_79969503.addTaint(taint);
        throw var4846CD46E1509569A2299D351EDC2C83_79969503;
        }
        List<AuthorizationHeader> authHeaders = authorizationHeaders.get(callId);
    if(authHeaders == null)        
        {
            authHeaders = new LinkedList<AuthorizationHeader>();
            authorizationHeaders.put(callId, authHeaders);
        } //End block
        else
        {
            String realm = authorization.getRealm();
for(ListIterator<AuthorizationHeader> li = authHeaders.listIterator();li.hasNext();)
            {
                AuthorizationHeader authHeader = (AuthorizationHeader) li.next();
    if(realm.equals(authHeader.getRealm()))                
                {
                    li.remove();
                } //End block
            } //End block
        } //End block
        authHeaders.add(authorization);
        TimeoutTask timeoutTask = new TimeoutTask( callId,user);
    if(cacheTime != -1)        
        this.timer.schedule(timeoutTask, cacheTime*1000);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.529 -0400", hash_original_method = "0B5572B5CD4E87519D0DA5EDF97CD6AB", hash_generated_method = "B808A812EC76A0391A146C1DB73B64A8")
     Collection<AuthorizationHeader> getCachedAuthorizationHeaders(
            String callid) {
        addTaint(callid.getTaint());
    if(callid == null)        
        {
        NullPointerException varE84A8BDB23C173B128D18CC91FD319FA_1333718483 = new NullPointerException("Null arg!");
        varE84A8BDB23C173B128D18CC91FD319FA_1333718483.addTaint(taint);
        throw varE84A8BDB23C173B128D18CC91FD319FA_1333718483;
        }
Collection<AuthorizationHeader> varCC9B97112287D995B85611F9FD824364_1199836506 =         this.authorizationHeaders.get(callid);
        varCC9B97112287D995B85611F9FD824364_1199836506.addTaint(taint);
        return varCC9B97112287D995B85611F9FD824364_1199836506;
        // ---------- Original Method ----------
        //if (callid == null)
            //throw new NullPointerException("Null arg!");
        //return this.authorizationHeaders.get(callid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.530 -0400", hash_original_method = "F30D19D7197AEDE7B7CBD76BE8FA4C90", hash_generated_method = "4443D8C37AE3A23AE8431B57C448E0E2")
    public void removeAuthenticationHeader(String callId) {
        addTaint(callId.getTaint());
        this.authorizationHeaders.remove(callId);
        // ---------- Original Method ----------
        //this.authorizationHeaders.remove(callId);
    }

    
    class TimeoutTask extends TimerTask {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.530 -0400", hash_original_field = "0CD10A72F684313DCE7B6EF5F7F41411", hash_generated_field = "2657C3812CAC2EE2FF30C5C628C0A470")

        String callId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.530 -0400", hash_original_field = "435E0648D634175C46BD40AC366545A8", hash_generated_field = "603671BF518F3A411771AE6211095177")

        String userName;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.531 -0400", hash_original_method = "40061A1217D263C30B9E268AD3A22381", hash_generated_method = "B40B0A9A0286B38E241689D6D6DF8EDC")
        public  TimeoutTask(String userName, String proxyDomain) {
            this.callId = proxyDomain;
            this.userName = userName;
            // ---------- Original Method ----------
            //this.callId = proxyDomain;
            //this.userName = userName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.531 -0400", hash_original_method = "55798103F4DC731E25C4381B99CDD4EB", hash_generated_method = "5663D056509E54F37247034B8867685B")
        @Override
        public void run() {
            authorizationHeaders.remove(callId);
            // ---------- Original Method ----------
            //authorizationHeaders.remove(callId);
        }

        
    }


    
}

