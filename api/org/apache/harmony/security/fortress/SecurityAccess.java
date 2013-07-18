package org.apache.harmony.security.fortress;

// Droidsafe Imports
import java.security.Provider;
import java.util.List;

public interface SecurityAccess {
    
    public void renumProviders();

    
    public List<String> getAliases(Provider.Service s);

    
    public Provider.Service getService(Provider p, String type);
}
