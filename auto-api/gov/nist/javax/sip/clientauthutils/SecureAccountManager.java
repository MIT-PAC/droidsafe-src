package gov.nist.javax.sip.clientauthutils;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.sip.ClientTransaction;

public interface SecureAccountManager  {
    

    UserCredentialHash getCredentialHash(ClientTransaction challengedTransaction, String realm);

}
