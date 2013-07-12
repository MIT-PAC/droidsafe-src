package android.security;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Intent;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

public interface KeyChainAliasCallback {

    
    public void alias(String alias);
}
