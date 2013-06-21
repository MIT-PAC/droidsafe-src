package android.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Intent;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

public interface KeyChainAliasCallback {

    
    public void alias(String alias);
}
