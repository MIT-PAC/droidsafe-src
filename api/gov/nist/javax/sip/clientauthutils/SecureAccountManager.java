package gov.nist.javax.sip.clientauthutils;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.ClientTransaction;

public interface SecureAccountManager  {
    

    UserCredentialHash getCredentialHash(ClientTransaction challengedTransaction, String realm);

}
