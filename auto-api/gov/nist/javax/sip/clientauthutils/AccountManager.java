package gov.nist.javax.sip.clientauthutils;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.ClientTransaction;

public interface AccountManager {

    

    UserCredentials getCredentials(ClientTransaction challengedTransaction, String realm);

}
