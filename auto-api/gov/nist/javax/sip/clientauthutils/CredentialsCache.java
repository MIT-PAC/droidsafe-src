package gov.nist.javax.sip.clientauthutils;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import javax.sip.*;
import javax.sip.header.*;
import javax.sip.address.*;
import javax.sip.message.*;

class CredentialsCache {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.961 -0400", hash_original_field = "D81018253725EE02665AA28ECF9FB59A", hash_generated_field = "D736F54F12D200A8D25CC8A65E13F0DE")

    private ConcurrentHashMap<String, List<AuthorizationHeader>> authorizationHeaders = new ConcurrentHashMap<String, List<AuthorizationHeader>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.961 -0400", hash_original_field = "2C127BF32CCB4EDF2BF22FEA5A00E494", hash_generated_field = "02D2240A23798B540E9F3183DC11EA33")

    private Timer timer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.962 -0400", hash_original_method = "27F7597F884C45C17FD9F63A315334B1", hash_generated_method = "A4870380C2579D8A506F75F9CC2B9DB5")
      CredentialsCache(Timer timer) {
        this.timer = timer;
        // ---------- Original Method ----------
        //this.timer = timer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.963 -0400", hash_original_method = "557183176EBBC482C2193E58BCF0D460", hash_generated_method = "B5C7E1244DBB4C1F2230B48756E399B2")
     void cacheAuthorizationHeader(String callId,
            AuthorizationHeader authorization, int cacheTime) {
        String user;
        user = authorization.getUsername();
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Call ID is null!");
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null authorization domain");
        List<AuthorizationHeader> authHeaders;
        authHeaders = authorizationHeaders.get(callId);
        {
            authHeaders = new LinkedList<AuthorizationHeader>();
            authorizationHeaders.put(callId, authHeaders);
        } //End block
        {
            String realm;
            realm = authorization.getRealm();
            {
                ListIterator<AuthorizationHeader> li;
                li = authHeaders.listIterator();
                boolean varD1722E42EA3CA8952F93B6521D875E61_585773212 = (li.hasNext());
                {
                    AuthorizationHeader authHeader;
                    authHeader = (AuthorizationHeader) li.next();
                    {
                        boolean varC5EB1AADFCCC32D729356E600B7D4975_1972320533 = (realm.equals(authHeader.getRealm()));
                        {
                            li.remove();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        authHeaders.add(authorization);
        TimeoutTask timeoutTask;
        timeoutTask = new TimeoutTask( callId,user);
        this.timer.schedule(timeoutTask, cacheTime*1000);
        addTaint(callId.getTaint());
        addTaint(authorization.getTaint());
        addTaint(cacheTime);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.963 -0400", hash_original_method = "0B5572B5CD4E87519D0DA5EDF97CD6AB", hash_generated_method = "D56E1614B68A59DBE54E06921C24BFD2")
     Collection<AuthorizationHeader> getCachedAuthorizationHeaders(
            String callid) {
        Collection<AuthorizationHeader> varB4EAC82CA7396A68D541C85D26508E83_1925088297 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null arg!");
        varB4EAC82CA7396A68D541C85D26508E83_1925088297 = this.authorizationHeaders.get(callid);
        addTaint(callid.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1925088297.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1925088297;
        // ---------- Original Method ----------
        //if (callid == null)
            //throw new NullPointerException("Null arg!");
        //return this.authorizationHeaders.get(callid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.963 -0400", hash_original_method = "F30D19D7197AEDE7B7CBD76BE8FA4C90", hash_generated_method = "5E8CACA192C4F9B49DE743916C47141A")
    public void removeAuthenticationHeader(String callId) {
        this.authorizationHeaders.remove(callId);
        addTaint(callId.getTaint());
        // ---------- Original Method ----------
        //this.authorizationHeaders.remove(callId);
    }

    
    class TimeoutTask extends TimerTask {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.964 -0400", hash_original_field = "0CD10A72F684313DCE7B6EF5F7F41411", hash_generated_field = "2657C3812CAC2EE2FF30C5C628C0A470")

        String callId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.964 -0400", hash_original_field = "435E0648D634175C46BD40AC366545A8", hash_generated_field = "603671BF518F3A411771AE6211095177")

        String userName;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.964 -0400", hash_original_method = "40061A1217D263C30B9E268AD3A22381", hash_generated_method = "B40B0A9A0286B38E241689D6D6DF8EDC")
        public  TimeoutTask(String userName, String proxyDomain) {
            this.callId = proxyDomain;
            this.userName = userName;
            // ---------- Original Method ----------
            //this.callId = proxyDomain;
            //this.userName = userName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.965 -0400", hash_original_method = "55798103F4DC731E25C4381B99CDD4EB", hash_generated_method = "5663D056509E54F37247034B8867685B")
        @Override
        public void run() {
            authorizationHeaders.remove(callId);
            // ---------- Original Method ----------
            //authorizationHeaders.remove(callId);
        }

        
    }


    
}

