package gov.nist.javax.sip.clientauthutils;

// Droidsafe Imports
import javax.sip.ClientTransaction;

public interface SecureAccountManager  {
    

    UserCredentialHash getCredentialHash(ClientTransaction challengedTransaction, String realm);

}
