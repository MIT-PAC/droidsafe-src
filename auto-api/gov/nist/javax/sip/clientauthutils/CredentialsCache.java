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
    private ConcurrentHashMap<String, List<AuthorizationHeader>> authorizationHeaders =
            new ConcurrentHashMap<String, List<AuthorizationHeader>>();
    private Timer timer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.569 -0400", hash_original_method = "27F7597F884C45C17FD9F63A315334B1", hash_generated_method = "35AF5F3D6526B94E57EBA60DB138FF21")
    @DSModeled(DSC.SAFE)
     CredentialsCache(Timer timer) {
        dsTaint.addTaint(timer.dsTaint);
        // ---------- Original Method ----------
        //this.timer = timer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.570 -0400", hash_original_method = "557183176EBBC482C2193E58BCF0D460", hash_generated_method = "8970D2434463FB74CD025F73C84B872B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void cacheAuthorizationHeader(String callId,
            AuthorizationHeader authorization, int cacheTime) {
        dsTaint.addTaint(cacheTime);
        dsTaint.addTaint(authorization.dsTaint);
        dsTaint.addTaint(callId);
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
                boolean varD1722E42EA3CA8952F93B6521D875E61_204546883 = (li.hasNext());
                {
                    AuthorizationHeader authHeader;
                    authHeader = (AuthorizationHeader) li.next();
                    {
                        boolean varC5EB1AADFCCC32D729356E600B7D4975_729604032 = (realm.equals(authHeader.getRealm()));
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.570 -0400", hash_original_method = "0B5572B5CD4E87519D0DA5EDF97CD6AB", hash_generated_method = "6EBD53FE8CA29CCCC0CA203AB032486D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Collection<AuthorizationHeader> getCachedAuthorizationHeaders(
            String callid) {
        dsTaint.addTaint(callid);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null arg!");
        Collection<AuthorizationHeader> var0D808643CD5A915B3D6696D19C44033B_650516519 = (this.authorizationHeaders.get(callid));
        return (Collection<AuthorizationHeader>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (callid == null)
            //throw new NullPointerException("Null arg!");
        //return this.authorizationHeaders.get(callid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.570 -0400", hash_original_method = "F30D19D7197AEDE7B7CBD76BE8FA4C90", hash_generated_method = "4A4B7771B3E8CD7CF7BD35BDB2C499B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeAuthenticationHeader(String callId) {
        dsTaint.addTaint(callId);
        this.authorizationHeaders.remove(callId);
        // ---------- Original Method ----------
        //this.authorizationHeaders.remove(callId);
    }

    
    class TimeoutTask extends TimerTask {
        String callId;
        String userName;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.570 -0400", hash_original_method = "40061A1217D263C30B9E268AD3A22381", hash_generated_method = "2544FEF505E5D0A689574AFB7D372FAC")
        @DSModeled(DSC.SAFE)
        public TimeoutTask(String userName, String proxyDomain) {
            dsTaint.addTaint(proxyDomain);
            dsTaint.addTaint(userName);
            // ---------- Original Method ----------
            //this.callId = proxyDomain;
            //this.userName = userName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.570 -0400", hash_original_method = "55798103F4DC731E25C4381B99CDD4EB", hash_generated_method = "5663D056509E54F37247034B8867685B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void run() {
            authorizationHeaders.remove(callId);
            // ---------- Original Method ----------
            //authorizationHeaders.remove(callId);
        }

        
    }


    
}

