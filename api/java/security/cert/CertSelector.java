package java.security.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface CertSelector extends Cloneable {

    
    public Object clone();

    
    public boolean match(Certificate cert);
}
