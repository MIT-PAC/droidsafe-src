package gov.nist.javax.sip.clientauthutils;

// Droidsafe Imports
import droidsafe.annotations.*;
import javax.sip.ClientTransaction;

public interface AccountManager {

    

    UserCredentials getCredentials(ClientTransaction challengedTransaction, String realm);

}
