package javax.net.ssl;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.net.Socket;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

public interface X509KeyManager extends KeyManager {

    
    public String chooseClientAlias(String[] keyType, Principal[] issuers,
            Socket socket);

    
    public String chooseServerAlias(String keyType, Principal[] issuers,
            Socket socket);

    
    public X509Certificate[] getCertificateChain(String alias);

    
    public String[] getClientAliases(String keyType, Principal[] issuers);

    
    public String[] getServerAliases(String keyType, Principal[] issuers);

    
    public PrivateKey getPrivateKey(String alias);
}
