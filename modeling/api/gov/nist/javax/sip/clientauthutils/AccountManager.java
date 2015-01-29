package gov.nist.javax.sip.clientauthutils;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.ClientTransaction;

public interface AccountManager {

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    UserCredentials getCredentials(ClientTransaction challengedTransaction, String realm);

}
