package org.apache.harmony.security.fortress;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.Provider;
import java.util.List;

public interface SecurityAccess {
    
    public void renumProviders();

    
    public List<String> getAliases(Provider.Service s);

    
    public Provider.Service getService(Provider p, String type);
}
